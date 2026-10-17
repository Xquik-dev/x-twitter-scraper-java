// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.apifields

import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.MultipartField
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.jsonMapper
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.lang.reflect.WildcardType
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.Optional
import kotlin.reflect.full.declaredMemberFunctions

private val leafClasses: Set<Class<*>> =
    setOfNotNull(
        String::class.java,
        Long::class.javaObjectType,
        Long::class.javaPrimitiveType,
        Int::class.javaObjectType,
        Int::class.javaPrimitiveType,
        Double::class.javaObjectType,
        Double::class.javaPrimitiveType,
        Float::class.javaObjectType,
        Boolean::class.javaObjectType,
        Boolean::class.javaPrimitiveType,
        OffsetDateTime::class.java,
        LocalDate::class.java,
        InputStream::class.java,
        ByteArray::class.java,
    )

private val requiredMessage = Regex("^`(\\w+)` is required, but was not set$")
private val alternativeMessage = Regex("^Exactly one of `(\\w+)` or `(\\w+)` must be set$")

/** Reads the JSON shapes of the SDK's compiled model, params, enum and union classes. */
internal class SdkShapes {

    val defs = linkedMapOf<String, Shape>()

    fun type(type: Type): Shape =
        when (type) {
            is ParameterizedType -> parameterized(type)
            is WildcardType -> type(type.upperBounds.single())
            is Class<*> -> classShape(type)
            else -> throw CheckFailure("The field check cannot read the type $type.")
        }

    private fun parameterized(type: ParameterizedType): Shape {
        val raw = type.rawType as Class<*>
        val argument = type.actualTypeArguments.firstOrNull()
        return when {
            List::class.java.isAssignableFrom(raw) -> Arr(type(argument!!))
            raw == Optional::class.java ||
                raw == JsonField::class.java ||
                raw == MultipartField::class.java -> type(argument!!)
            Map::class.java.isAssignableFrom(raw) -> Free()
            else -> throw CheckFailure("The field check cannot read the type $type.")
        }
    }

    private fun classShape(cls: Class<*>): Shape {
        if (cls in leafClasses) return Leaf()
        if (JsonValue::class.java.isAssignableFrom(cls)) return Unknown
        if (Enum::class.java.isAssignableFrom(cls)) return leaf(enumValues(cls))
        if (cls.name in defs) return Ref(cls.name)
        return when {
            isUnion(cls) -> define(cls) { Union(unionVariants(cls)) }
            modelProperties(cls).isNotEmpty() -> define(cls) { model(cls) }
            hasMethod(cls, "_additionalProperties") -> Free()
            else -> throw CheckFailure("The field check cannot read the class ${cls.name}.")
        }
    }

    private fun define(cls: Class<*>, build: () -> Shape): Shape {
        defs[cls.name] = Unknown
        defs[cls.name] = build()
        return Ref(cls.name)
    }

    fun enumValues(cls: Class<*>): List<String> =
        cls.fields
            .filter { Modifier.isStatic(it.modifiers) && it.type == cls }
            .map { field ->
                val value = cls.getMethod("_value").invoke(field.get(null)) as JsonField<*>
                value.asKnown().orElseThrow().toString()
            }

    private fun isUnion(cls: Class<*>): Boolean =
        cls.declaredClasses.any { it.simpleName == "Visitor" && it.isInterface }

    private fun unionVariants(cls: Class<*>): List<Shape> =
        cls.methods
            .filter {
                it.name.startsWith("is") &&
                    it.parameterCount == 0 &&
                    it.returnType == Boolean::class.javaPrimitiveType
            }
            .mapNotNull { check ->
                val accessor = check.name.removePrefix("is").replaceFirstChar { it.lowercase() }
                cls.methods.firstOrNull {
                    it.name == accessor &&
                        it.parameterCount == 0 &&
                        it.returnType == Optional::class.java
                }
            }
            .sortedBy { it.name }
            .map { type(it.genericReturnType) }

    private fun modelProperties(cls: Class<*>): List<Pair<String, Method>> =
        cls.declaredMethods
            .filter {
                it.name.startsWith("_") &&
                    it.parameterCount == 0 &&
                    it.isAnnotationPresent(JsonProperty::class.java)
            }
            .map { it.getAnnotation(JsonProperty::class.java).value to it }
            .sortedBy { it.first }

    private fun model(cls: Class<*>): Shape {
        val required = requiredFields(cls)
        val nullable = nullableFields(cls)
        val props =
            modelProperties(cls).associate { (wire, method) ->
                val name = method.name.removePrefix("_")
                val raw = method.returnType == JsonValue::class.java
                wire to
                    Prop(
                        if (raw) null else name in required,
                        if (raw) null else name in nullable,
                        type(method.genericReturnType),
                    )
            }
        return Obj(props)
    }

    private fun builderOf(cls: Class<*>): Any? =
        cls.methods
            .firstOrNull {
                it.name == "builder" && it.parameterCount == 0 && Modifier.isStatic(it.modifiers)
            }
            ?.invoke(null)

    private fun requiredFields(cls: Class<*>): Set<String> {
        val builder =
            builderOf(cls)
                ?: throw CheckFailure("${cls.name} has no builder the field check can read.")
        val required = linkedSetOf<String>()
        while (true) {
            val name = missingRequired(builder) ?: return required
            if (!required.add(name)) throw CheckFailure("${cls.name} keeps asking for ${name}.")
            setPlaceholder(builder, name)
        }
    }

    private fun missingRequired(builder: Any): String? =
        try {
            builder.javaClass.getMethod("build").invoke(builder)
            null
        } catch (e: InvocationTargetException) {
            val message = e.targetException.message.orEmpty()
            val alternative = alternativeMessage.matchEntire(message)
            if (alternative != null) {
                setPlaceholder(builder, alternative.groupValues[1])
                missingRequired(builder)
            } else {
                requiredMessage.find(message)?.groupValues?.get(1) ?: throw e.targetException
            }
        }

    fun setRequired(builder: Any, error: IllegalStateException) {
        val name = requiredMessage.find(error.message.orEmpty())?.groupValues?.get(1) ?: throw error
        setPlaceholder(builder, name)
    }

    private fun setPlaceholder(builder: Any, name: String) {
        val setters = builder.javaClass.methods.filter { it.name == name && it.parameterCount == 1 }
        setters
            .firstNotNullOfOrNull { s ->
                Samples.of(s.genericParameterTypes[0])?.let { s to it.first }
            }
            ?.let { (setter, value) ->
                setter.invoke(builder, value)
                return
            }
        setters
            .firstOrNull {
                it.parameterTypes[0].name.startsWith("com.x_twitter_scraper.api.models")
            }
            ?.let {
                it.invoke(
                    builder,
                    jsonMapper().convertValue(emptyMap<String, Any>(), it.parameterTypes[0]),
                )
                return
            }
        setters
            .firstOrNull { it.parameterTypes[0] == JsonField::class.java }
            ?.let {
                it.invoke(builder, JsonMissing.of())
                return
            }
        setters
            .firstOrNull { it.parameterTypes[0] == MultipartField::class.java }
            ?.let {
                it.invoke(builder, MultipartField.of<Any>(JsonMissing.of()))
                return
            }
        throw CheckFailure("The field check cannot set ${builder.javaClass.name}.$name.")
    }

    private fun nullableFields(cls: Class<*>): Set<String> {
        val builder =
            cls.declaredClasses.firstOrNull { it.simpleName == "Builder" } ?: return emptySet()
        return builder.kotlin.declaredMemberFunctions
            .filter { f -> f.parameters.size == 2 && f.parameters[1].type.isMarkedNullable }
            .map { it.name }
            .toSet()
    }

    fun params(cls: Class<*>): Pair<Shape, Shape?> = query(cls) to body(cls)

    fun newParams(cls: Class<*>): Pair<Any, Set<String>> {
        val builder =
            builderOf(cls)
                ?: throw CheckFailure("${cls.name} has no builder the field check can read.")
        val required = linkedSetOf<String>()
        while (true) {
            val name = missingRequired(builder) ?: break
            if (!required.add(name)) throw CheckFailure("${cls.name} keeps asking for ${name}.")
            setPlaceholder(builder, name)
        }
        return builder to required
    }

    private fun query(cls: Class<*>): Shape {
        val (builder, required) = newParams(cls)
        val base = builder.javaClass.getMethod("build").invoke(builder) as Params
        val baseQuery = queryMap(base)
        val props = linkedMapOf<String, Prop>()
        for (getter in cls.declaredMethods) {
            if (
                getter.parameterCount != 0 ||
                    getter.name.startsWith("_") ||
                    getter.isSynthetic ||
                    !Modifier.isPublic(getter.modifiers)
            )
                continue
            if (
                cls.methods.any {
                    it.name == "_${getter.name}" && it.returnType == MultipartField::class.java
                }
            )
                continue
            val setters =
                builder.javaClass.methods.filter {
                    it.name == getter.name && it.parameterCount == 1
                }
            if (setters.isEmpty()) continue
            val current = currentValue(getter, base)
            val setter =
                setters.firstNotNullOfOrNull { s ->
                    Samples.of(s.genericParameterTypes[0])?.let { (a, b) ->
                        s to (if (a == current) b else a)
                    }
                } ?: continue
            val changed = base.javaClass.getMethod("toBuilder").invoke(base)
            setter.first.invoke(changed, setter.second)
            val after = queryMap(changed.javaClass.getMethod("build").invoke(changed) as Params)
            val keys = (after.keys + baseQuery.keys).filter { after[it] != baseQuery[it] }
            if (keys.isEmpty()) continue
            if (keys.size > 1)
                throw CheckFailure("${cls.name}.${getter.name} sets ${keys.joinToString()}.")
            props[keys.single()] =
                Prop(getter.name in required, null, type(unwrapOptional(getter.genericReturnType)))
        }
        return Obj(props)
    }

    private fun currentValue(getter: Method, params: Any): Any? =
        try {
            getter.invoke(params).let { if (it is Optional<*>) it.orElse(null) else it }
        } catch (e: InvocationTargetException) {
            null
        }

    private fun queryMap(params: Params): Map<String, List<String>> =
        params._queryParams().let { q -> q.keys().associateWith { q.values(it) } }

    private fun unwrapOptional(type: Type): Type =
        if (type is ParameterizedType && type.rawType == Optional::class.java)
            type.actualTypeArguments[0]
        else type

    private fun body(cls: Class<*>): Shape? {
        val method =
            cls.methods.firstOrNull { it.name == "_body" && it.parameterCount == 0 } ?: return null
        val type = method.genericReturnType
        val raw = (type as? ParameterizedType)?.rawType ?: type
        return when {
            raw == Optional::class.java -> null
            raw is Class<*> && Map::class.java.isAssignableFrom(raw) -> {
                val body =
                    cls.declaredClasses.firstOrNull { it.simpleName == "Body" }
                        ?: throw CheckFailure(
                            "${cls.name} sends a multipart body without a Body class."
                        )
                type(body)
            }
            else -> type(type)
        }
    }

    private fun hasMethod(cls: Class<*>, name: String): Boolean =
        cls.methods.any { it.name == name && it.parameterCount == 0 }
}

/** 2 distinct sample values for each settable parameter type. */
internal object Samples {

    fun of(type: Type): Pair<Any, Any>? {
        if (type is ParameterizedType && type.rawType == List::class.java) {
            val item = of(type.actualTypeArguments[0]) ?: return null
            return listOf(item.first) to listOf(item.second)
        }
        val cls = type as? Class<*> ?: return null
        return when {
            cls == String::class.java -> "sample" to "other"
            cls == Long::class.javaObjectType || cls == Long::class.javaPrimitiveType -> 7L to 8L
            cls == Double::class.javaObjectType || cls == Double::class.javaPrimitiveType ->
                7.5 to 8.5
            cls == Boolean::class.javaObjectType || cls == Boolean::class.javaPrimitiveType ->
                true to false
            cls == OffsetDateTime::class.java ->
                OffsetDateTime.parse("2026-01-01T00:00:00Z") to
                    OffsetDateTime.parse("2026-01-02T00:00:00Z")
            cls == LocalDate::class.java ->
                LocalDate.parse("2026-01-01") to LocalDate.parse("2026-01-02")
            cls == InputStream::class.java ->
                ByteArrayInputStream(byteArrayOf(1)) to ByteArrayInputStream(byteArrayOf(2))
            Enum::class.java.isAssignableFrom(cls) -> enumSamples(cls)
            else -> null
        }
    }

    private fun enumSamples(cls: Class<*>): Pair<Any, Any> {
        val constants =
            cls.fields
                .filter { Modifier.isStatic(it.modifiers) && it.type == cls }
                .map { it.get(null) }
        constants.getOrNull(1)?.let {
            return constants.first() to it
        }
        val factory =
            cls.methods.first {
                it.name == "of" && it.parameterCount == 1 && Modifier.isStatic(it.modifiers)
            }
        val raw =
            of(factory.parameterTypes[0])
                ?: throw CheckFailure("The field check cannot build a value of ${cls.name}.")
        return constants.first() to factory.invoke(null, raw.second)
    }
}
