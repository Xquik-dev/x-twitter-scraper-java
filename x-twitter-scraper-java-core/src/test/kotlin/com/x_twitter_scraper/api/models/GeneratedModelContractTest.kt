// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.Enum as XquikEnum
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.MultipartField
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.lang.reflect.GenericArrayType
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.lang.reflect.TypeVariable
import java.lang.reflect.WildcardType
import java.math.BigDecimal
import java.math.BigInteger
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.time.Duration
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.Optional
import java.util.UUID
import java.util.function.Consumer
import kotlin.io.path.extension
import kotlin.io.path.isRegularFile
import kotlin.io.path.relativeTo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/** Enforces shared contracts across every generated model discovered on the test classpath. */
internal class GeneratedModelContractTest {

    @Test
    fun generatedModelsPreserveJsonFieldContracts() {
        verifyGeneratedContracts(generatedModelClasses(), 300, ::verifyModel)
    }

    @Test
    fun generatedModelsValidateFullyPopulatedValues() {
        verifyGeneratedContracts(generatedModelClasses(), 300, ::verifyPopulatedModel)
    }

    @Test
    fun generatedRequestParamsPreserveBuilderContracts() {
        verifyGeneratedContracts(generatedParamClasses(), 100, ::verifyParams)
    }

    @Test
    fun generatedEnumsPreserveKnownUnknownAndInvalidValues() {
        verifyGeneratedContracts(generatedEnumClasses(), 100, ::verifyEnum)
    }

    private fun verifyGeneratedContracts(
        generatedClasses: List<Class<*>>,
        expectedClassCountFloor: Int,
        verifier: (Class<*>) -> Unit,
    ) {
        assertThat(generatedClasses).hasSizeGreaterThan(expectedClassCountFloor)

        val failures = generatedClasses.mapNotNull { generatedClass ->
            runCatching { verifier(generatedClass) }
                .exceptionOrNull()
                ?.let { error ->
                    "${generatedClass.name}: ${error.stackTraceToString()}"
                }
        }

        assertThat(failures).describedAs(failures.joinToString("\n\n")).isEmpty()
    }

    private fun verifyModel(modelClass: Class<*>) {
        val emptyModel = MAPPER.readValue("{}", modelClass)
        val emptyCopy = copyOf(emptyModel)

        assertThat(MAPPER.writeValueAsString(emptyModel)).isEqualTo("{}")
        assertThat(emptyCopy).isEqualTo(emptyModel)
        assertThat(emptyModel).isEqualTo(emptyCopy)
        assertThat(emptyModel).isEqualTo(emptyModel)
        assertThat(emptyModel).isNotEqualTo(null)
        assertThat(emptyModel).isNotEqualTo(Any())
        assertThat(emptyCopy.hashCode()).isEqualTo(emptyModel.hashCode())
        assertThat(emptyModel.toString()).isNotBlank()

        verifyValidation(emptyModel)
        assertThat(validityOf(emptyModel)).isZero()
        verifyUnknownProperty(modelClass, emptyModel)
        rawFieldGetters(modelClass).forEach { verifyJsonField(modelClass, emptyModel, it) }
    }

    private fun verifyPopulatedModel(modelClass: Class<*>) {
        val populatedModel = populatedModel(modelClass, emptySet())
        val serializedModel = MAPPER.writeValueAsString(populatedModel)
        val roundTripModel = MAPPER.readValue(serializedModel, modelClass)
        val populatedCopy = copyOf(populatedModel)
        val rawGetters =
            rawFieldGetters(modelClass).filterNot {
                referencesAncestor(it.genericReturnType, setOf(modelClass))
            }

        verifyValidation(populatedModel, expectedValid = true)
        verifyValidation(roundTripModel, expectedValid = true)

        assertThat(populatedCopy).isEqualTo(populatedModel)
        assertThat(roundTripModel).isEqualTo(populatedModel)
        assertThat(populatedCopy.hashCode()).isEqualTo(populatedModel.hashCode())
        assertThat(populatedModel.toString()).isNotBlank()

        val minimumValidity = if (rawGetters.isEmpty()) 0 else 1
        assertThat(validityOf(populatedModel)).isGreaterThanOrEqualTo(minimumValidity)

        rawGetters.forEach { rawGetter ->
            val field = rawGetter.invoke(populatedModel) as JsonField<*>
            val typedGetter =
                modelClass.methods.singleOrNull {
                    it.name == rawGetter.name.removePrefix("_") && it.parameterCount == 0
                }

            assertThat(field.isMissing()).describedAs(rawGetter.toGenericString()).isFalse()
            if (!JsonValue::class.java.isAssignableFrom(rawGetter.returnType)) {
                assertThat(field.isNull()).describedAs(rawGetter.toGenericString()).isFalse()
            }
            if (typedGetter != null) {
                val value = typedGetter.invoke(populatedModel)
                assertThat(value).describedAs(typedGetter.toGenericString()).isNotNull()
                if (value is Optional<*>) {
                    assertThat(value).describedAs(typedGetter.toGenericString()).isPresent()
                }
            }
        }
    }

    private fun verifyEnum(enumClass: Class<*>) {
        val knownValues =
            enumClass.fields
                .filter {
                    Modifier.isStatic(it.modifiers) && enumClass.isAssignableFrom(it.type)
                }
                .map { it.get(null) }
        val of =
            enumClass.methods.single {
                Modifier.isStatic(it.modifiers) &&
                    it.name == "of" &&
                    it.parameterCount == 1 &&
                    it.returnType == enumClass
            }
        val rawValue = enumClass.methods.single { it.name == "_value" && it.parameterCount == 0 }
        val asPrimitive =
            enumClass.methods.single {
                it.name.startsWith("as") &&
                    it.name.length > 2 &&
                    it.parameterCount == 0 &&
                    it.declaringClass == enumClass
            }
        val value = enumClass.methods.single { it.name == "value" && it.parameterCount == 0 }
        val known = enumClass.methods.single { it.name == "known" && it.parameterCount == 0 }
        val validate = enumClass.methods.single { it.name == "validate" && it.parameterCount == 0 }
        val isValid = enumClass.methods.single { it.name == "isValid" && it.parameterCount == 0 }

        assertThat(knownValues).isNotEmpty()

        knownValues.forEach { knownValue ->
            val wireValue =
                (rawValue.invoke(knownValue) as JsonField<*>).asKnown().orElseThrow {
                    AssertionError("Known enum value is missing")
                }
            val reconstructed = of.invoke(null, wireValue)

            assertThat(asPrimitive.invoke(knownValue)).isEqualTo(wireValue)
            assertThat(value.invoke(knownValue).toString()).isNotEqualTo(UNKNOWN_ENUM_NAME)
            assertThat(known.invoke(knownValue).toString()).isNotEqualTo(UNKNOWN_ENUM_NAME)
            assertThat(validate.invoke(knownValue)).isSameAs(knownValue)
            assertThat(validate.invoke(knownValue)).isSameAs(knownValue)
            assertThat(isValid.invoke(knownValue)).isEqualTo(true)
            assertThat(validityOf(knownValue)).isEqualTo(1)
            assertThat(reconstructed).isEqualTo(knownValue)
            assertThat(reconstructed.hashCode()).isEqualTo(knownValue.hashCode())
            assertThat(knownValue.toString()).isEqualTo(wireValue.toString())
        }

        if (knownValues.size > 1) {
            assertThat(knownValues.first()).isNotEqualTo(knownValues.last())
        }

        val unknownWireValue = unknownWireValue(of.parameterTypes.single(), knownValues, rawValue)
        val unknown = of.invoke(null, unknownWireValue)
        assertThat(asPrimitive.invoke(unknown)).isEqualTo(unknownWireValue)
        assertThat(value.invoke(unknown).toString()).isEqualTo(UNKNOWN_ENUM_NAME)
        assertThat(invocationFailure { known.invoke(unknown) })
            .isInstanceOf(XTwitterScraperInvalidDataException::class.java)
        assertThat(invocationFailure { validate.invoke(unknown) })
            .isInstanceOf(XTwitterScraperInvalidDataException::class.java)
        assertThat(isValid.invoke(unknown)).isEqualTo(false)
        assertThat(validityOf(unknown)).isZero()

        val invalidJson =
            if (of.parameterTypes.single() == String::class.java) "{}" else "\"invalid\""
        val invalid = MAPPER.readValue(invalidJson, enumClass)
        assertThat((rawValue.invoke(invalid) as JsonField<*>).asUnknown()).isPresent()
        assertThat(value.invoke(invalid).toString()).isEqualTo(UNKNOWN_ENUM_NAME)
        assertThat(invocationFailure { asPrimitive.invoke(invalid) })
            .isInstanceOf(XTwitterScraperInvalidDataException::class.java)
        assertThat(invocationFailure { validate.invoke(invalid) })
            .isInstanceOf(XTwitterScraperInvalidDataException::class.java)
        assertThat(isValid.invoke(invalid)).isEqualTo(false)
        assertThat(validityOf(invalid)).isZero()
        assertThat(invalid).isNotEqualTo(unknown)
        assertThat(invalid).isNotEqualTo(Any())
        assertThat(invalid).isNotEqualTo(null)
        assertThat(invalid.toString()).isNotBlank()
    }

    private fun unknownWireValue(
        wireType: Class<*>,
        knownValues: List<Any>,
        rawValue: Method,
    ): Any =
        when (wireType) {
            String::class.java -> UNKNOWN_ENUM_VALUE
            Boolean::class.javaPrimitiveType,
            Boolean::class.javaObjectType ->
                listOf(false, true).firstOrNull { candidate ->
                    knownValues.none {
                        (rawValue.invoke(it) as JsonField<*>).asBoolean().orElse(null) == candidate
                    }
                } ?: error("Boolean enum has no unknown wire value")
            Long::class.javaPrimitiveType,
            Long::class.javaObjectType ->
                knownValues
                    .map {
                        (rawValue.invoke(it) as JsonField<*>)
                            .asNumber()
                            .orElseThrow { AssertionError("Known enum number is missing") }
                            .toLong()
                    }
                    .maxOrNull()
                    ?.plus(1L) ?: 1L
            else -> error("Unsupported enum wire type: ${wireType.name}")
        }

    private fun validityOf(value: Any): Int {
        val validity =
            value.javaClass.declaredMethods.single {
                it.name.startsWith("validity") && it.parameterCount == 0
            }

        return validity.invoke(value) as Int
    }

    private fun verifyParams(paramClass: Class<*>) {
        val builder = newBuilder(paramClass)
        val unsupportedMethods = applyBuilderMutators(builder)
        val params = build(builder)
        val copy = copyOf(params)

        assertThat(unsupportedMethods)
            .describedAs("Unsupported builder methods for ${paramClass.name}")
            .isEmpty()
        assertThat(copy).isEqualTo(params)
        assertThat(params).isEqualTo(copy)
        assertThat(params).isEqualTo(params)
        assertThat(params).isNotEqualTo(null)
        assertThat(params).isNotEqualTo(Any())
        assertThat(copy.hashCode()).isEqualTo(params.hashCode())
        assertThat(params.toString()).isNotBlank()

        paramClass.methods
            .filter {
                it.declaringClass == paramClass &&
                    !Modifier.isStatic(it.modifiers) &&
                    it.parameterCount == 0 &&
                    it.name !in OBJECT_METHODS &&
                    it.name != "toBuilder"
            }
            .forEach { getter ->
                val value = getter.invoke(params)
                assertThat(value).describedAs("${paramClass.name}.${getter.name}").isNotNull()
                if (value is Optional<*> && !getter.name.startsWith("_")) {
                    assertThat(value).describedAs("${paramClass.name}.${getter.name}").isPresent()
                }
            }
    }

    private fun newBuilder(modelClass: Class<*>): Any {
        val builderMethod =
            modelClass.methods.single {
                Modifier.isStatic(it.modifiers) && it.name == "builder" && it.parameterCount == 0
            }

        return builderMethod.invoke(null)
    }

    private fun applyBuilderMutators(
        builder: Any,
        sampler: (Type) -> Any? = ::sampleValue,
        shouldSkip: (Method) -> Boolean = { false },
    ): List<String> {
        val methods =
            builder.javaClass.methods
                .filter {
                    it.declaringClass == builder.javaClass &&
                        !it.isSynthetic &&
                        it.returnType == builder.javaClass &&
                        it.name != "from"
                }
                .sortedWith(
                    compareBy<Method>(
                        { builderMethodOrder(it) },
                        { it.name },
                        { it.parameterTypes.joinToString { type -> type.name } },
                    )
                )
        val unsupported = mutableListOf<String>()

        methods.forEach { method ->
            if (shouldSkip(method)) {
                return@forEach
            }

            val arguments = method.genericParameterTypes.map(sampler)
            if (arguments.any { it == null }) {
                unsupported += method.toGenericString()
                return@forEach
            }

            method.invoke(builder, *arguments.toTypedArray())
        }

        return unsupported
    }

    private fun populatedModel(modelClass: Class<*>, ancestors: Set<Class<*>>): Any {
        check(modelClass !in ancestors) {
            "Recursive model dependency: ${(ancestors + modelClass).joinToString { it.name }}"
        }

        val builder = newBuilder(modelClass)
        val populatedAncestors = ancestors + modelClass
        val unsupportedMethods =
            applyBuilderMutators(
                builder,
                { type ->
                    sampleValue(type) { nestedModel ->
                        validModelValue(nestedModel, populatedAncestors)
                    }
                },
                { method ->
                    preservesDefaultJsonLiteral(method) ||
                        method.genericParameterTypes.any {
                            referencesAncestor(it, populatedAncestors)
                        }
                },
            )

        check(unsupportedMethods.isEmpty()) {
            "Unsupported builder methods for ${modelClass.name}: ${unsupportedMethods.joinToString()}"
        }

        return build(builder)
    }

    private fun preservesDefaultJsonLiteral(method: Method): Boolean =
        method.parameterTypes.singleOrNull()?.let {
            JsonValue::class.java.isAssignableFrom(it)
        } == true

    private fun referencesAncestor(type: Type, ancestors: Set<Class<*>>): Boolean =
        when (type) {
            is Class<*> -> type in ancestors
            is GenericArrayType -> referencesAncestor(type.genericComponentType, ancestors)
            is ParameterizedType ->
                referencesAncestor(type.rawType, ancestors) ||
                    type.actualTypeArguments.any { referencesAncestor(it, ancestors) }
            is TypeVariable<*> -> type.bounds.any { referencesAncestor(it, ancestors) }
            is WildcardType ->
                (type.lowerBounds + type.upperBounds).any { referencesAncestor(it, ancestors) }
            else -> false
        }

    private fun builderMethodOrder(method: Method): Int =
        when {
            method.name == "body" -> 0
            method.name.startsWith("remove") -> 1
            method.parameterTypes.any { JsonField::class.java.isAssignableFrom(it) } -> 2
            else -> 3
        }

    private fun sampleValue(type: Type): Any? = sampleValue(type, ::defaultModelValue)

    private fun sampleValue(
        type: Type,
        modelValue: (Class<*>) -> Any?,
    ): Any? {
        val nestedValue = { nestedType: Type -> sampleValue(nestedType, modelValue) }

        if (type is WildcardType) {
            return (type.lowerBounds.firstOrNull() ?: type.upperBounds.firstOrNull())?.let(
                nestedValue
            )
        }
        if (type is TypeVariable<*>) {
            return type.bounds.firstOrNull()?.let(nestedValue)
        }
        if (type is GenericArrayType) {
            val component = nestedValue(type.genericComponentType) ?: return null
            val array = java.lang.reflect.Array.newInstance(component.javaClass, 1)
            java.lang.reflect.Array.set(array, 0, component)
            return array
        }

        val rawClass = rawClass(type) ?: return null

        if (rawClass == String::class.java || rawClass == CharSequence::class.java) {
            return CONTRACT_VALUE
        }
        if (rawClass == Long::class.javaPrimitiveType || rawClass == Long::class.javaObjectType) {
            return 1L
        }
        if (rawClass == Int::class.javaPrimitiveType || rawClass == Int::class.javaObjectType) {
            return 1
        }
        if (
            rawClass == Double::class.javaPrimitiveType || rawClass == Double::class.javaObjectType
        ) {
            return 1.0
        }
        if (rawClass == Float::class.javaPrimitiveType || rawClass == Float::class.javaObjectType) {
            return 1.0F
        }
        if (rawClass == Short::class.javaPrimitiveType || rawClass == Short::class.javaObjectType) {
            return 1.toShort()
        }
        if (rawClass == Byte::class.javaPrimitiveType || rawClass == Byte::class.javaObjectType) {
            return 1.toByte()
        }
        if (
            rawClass == Boolean::class.javaPrimitiveType ||
                rawClass == Boolean::class.javaObjectType
        ) {
            return true
        }
        if (rawClass == ByteArray::class.java) {
            return CONTRACT_VALUE.toByteArray()
        }
        if (InputStream::class.java.isAssignableFrom(rawClass)) {
            return ByteArrayInputStream(CONTRACT_VALUE.toByteArray())
        }
        if (rawClass == LocalDate::class.java) {
            return LocalDate.parse("2026-01-01")
        }
        if (rawClass == OffsetDateTime::class.java) {
            return OffsetDateTime.parse("2026-01-01T00:00:00Z")
        }
        if (rawClass == Duration::class.java) {
            return Duration.ofSeconds(1)
        }
        if (rawClass == BigDecimal::class.java) {
            return BigDecimal.ONE
        }
        if (rawClass == BigInteger::class.java) {
            return BigInteger.ONE
        }
        if (rawClass == UUID::class.java) {
            return UUID.fromString("00000000-0000-0000-0000-000000000001")
        }
        if (rawClass == JsonField::class.java) {
            val valueType = (type as? ParameterizedType)?.actualTypeArguments?.firstOrNull()
            return JsonField.of(valueType?.let(nestedValue) ?: CONTRACT_VALUE)
        }
        if (rawClass == JsonValue::class.java) {
            return JsonValue.from(CONTRACT_VALUE)
        }
        if (rawClass == MultipartField::class.java) {
            val valueType = (type as? ParameterizedType)?.actualTypeArguments?.firstOrNull()
            return MultipartField.of(valueType?.let(nestedValue) ?: CONTRACT_VALUE)
        }
        if (rawClass == Optional::class.java) {
            val valueType = (type as? ParameterizedType)?.actualTypeArguments?.firstOrNull()
            return Optional.of(valueType?.let(nestedValue) ?: CONTRACT_VALUE)
        }
        if (rawClass == Headers::class.java) {
            return Headers.builder().put(CONTRACT_HEADER, CONTRACT_VALUE).build()
        }
        if (rawClass == QueryParams::class.java) {
            return QueryParams.builder().put(CONTRACT_QUERY, CONTRACT_VALUE).build()
        }
        if (rawClass == Consumer::class.java) {
            return Consumer<Any> {}
        }
        if (rawClass.isEnum) {
            return rawClass.enumConstants.first()
        }
        if (Map::class.java.isAssignableFrom(rawClass)) {
            val valueType = (type as? ParameterizedType)?.actualTypeArguments?.getOrNull(1)
            return mapOf(CONTRACT_VALUE to (valueType?.let(nestedValue) ?: CONTRACT_VALUE))
        }
        if (Set::class.java.isAssignableFrom(rawClass)) {
            val valueType = (type as? ParameterizedType)?.actualTypeArguments?.firstOrNull()
            return setOf(valueType?.let(nestedValue) ?: CONTRACT_VALUE)
        }
        if (
            Iterable::class.java.isAssignableFrom(rawClass) ||
                Collection::class.java.isAssignableFrom(rawClass)
        ) {
            val valueType = (type as? ParameterizedType)?.actualTypeArguments?.firstOrNull()
            return listOf(valueType?.let(nestedValue) ?: CONTRACT_VALUE)
        }

        val constant =
            rawClass.fields.firstOrNull {
                Modifier.isStatic(it.modifiers) && rawClass.isAssignableFrom(it.type)
            }
        if (constant != null) {
            return constant.get(null)
        }

        if (rawClass.name.startsWith(MODEL_PACKAGE)) {
            return modelValue(rawClass)
        }

        return null
    }

    private fun validModelValue(modelClass: Class<*>, ancestors: Set<Class<*>>): Any? =
        if (hasBuilder(modelClass)) {
            populatedModel(modelClass, ancestors)
        } else {
            factoryModelValue(modelClass, ancestors) ?: defaultModelValue(modelClass)
        }

    private fun factoryModelValue(modelClass: Class<*>, ancestors: Set<Class<*>>): Any? {
        val factories =
            modelClass.methods
                .filter { method ->
                    method.name.startsWith("of") &&
                        method.parameterCount == 1 &&
                        modelClass.isAssignableFrom(method.returnType)
                }
                .sortedBy { method -> method.name }
        val factoryAncestors = ancestors + modelClass

        return factories.firstNotNullOfOrNull { factory ->
            if (referencesAncestor(factory.genericParameterTypes.single(), factoryAncestors)) {
                return@firstNotNullOfOrNull null
            }

            val argument =
                sampleValue(factory.genericParameterTypes.single()) { nestedModel ->
                    validModelValue(nestedModel, factoryAncestors)
                } ?: return@firstNotNullOfOrNull null
            runCatching { factory.invoke(null, argument) }.getOrNull()
        }
    }

    private fun defaultModelValue(modelClass: Class<*>): Any? {
        val deserialized = runCatching { MAPPER.readValue("{}", modelClass) }.getOrNull()
        if (deserialized != null) {
            return deserialized
        }

        return runCatching {
            val builder = newBuilder(modelClass)
            check(applyBuilderMutators(builder).isEmpty())
            build(builder)
        }
            .getOrNull()
    }

    private fun hasBuilder(modelClass: Class<*>): Boolean =
        modelClass.methods.any {
            Modifier.isStatic(it.modifiers) && it.name == "builder" && it.parameterCount == 0
        }

    private fun rawClass(type: Type): Class<*>? =
        when (type) {
            is Class<*> -> type
            is ParameterizedType -> type.rawType as? Class<*>
            else -> null
        }

    private fun build(builder: Any): Any {
        val build =
            builder.javaClass.methods.single { it.name == "build" && it.parameterCount == 0 }

        return build.invoke(builder)
    }

    private fun verifyValidation(model: Any, expectedValid: Boolean? = null) {
        val isValid =
            model.javaClass.methods.singleOrNull { it.name == "isValid" && it.parameterCount == 0 }
        val validate =
            model.javaClass.methods.singleOrNull { it.name == "validate" && it.parameterCount == 0 }

        if (isValid == null || validate == null) {
            assertThat(isValid).isNull()
            assertThat(validate).isNull()
            return
        }

        val valid = isValid.invoke(model) as Boolean
        val validationFailure = invocationFailure { validate.invoke(model) }
        if (expectedValid != null) {
            assertThat(valid).describedAs(model.javaClass.name).isEqualTo(expectedValid)
        }

        if (valid) {
            assertThat(validationFailure).isNull()
            assertThat(validate.invoke(model)).isSameAs(model)
            assertThat(isValid.invoke(model)).isEqualTo(true)
        } else {
            assertThat(validationFailure)
                .isInstanceOf(XTwitterScraperInvalidDataException::class.java)
            assertThat(isValid.invoke(model)).isEqualTo(false)
        }
    }

    private fun verifyUnknownProperty(modelClass: Class<*>, emptyModel: Any) {
        val additionalProperties =
            modelClass.methods.singleOrNull {
                it.name == "_additionalProperties" &&
                    it.parameterCount == 0 &&
                    Map::class.java.isAssignableFrom(it.returnType)
            } ?: return
        val unknownModel =
            MAPPER.readValue(
                MAPPER.writeValueAsString(mapOf(UNKNOWN_PROPERTY to true)),
                modelClass,
            )
        val unknownProperties = additionalProperties.invoke(unknownModel) as Map<*, *>

        assertThat(additionalProperties.invoke(emptyModel) as Map<*, *>).isEmpty()
        assertThat(unknownProperties.keys).contains(UNKNOWN_PROPERTY)
        assertThat(
                MAPPER.readTree(MAPPER.writeValueAsString(unknownModel))[UNKNOWN_PROPERTY]
                    .asBoolean()
            )
            .isTrue()
        assertThat(copyOf(unknownModel)).isEqualTo(unknownModel)
        assertThat(unknownModel).isNotEqualTo(emptyModel)
        assertThat(unknownModel.hashCode()).isNotEqualTo(emptyModel.hashCode())
        assertThat(unknownModel.toString()).contains(UNKNOWN_PROPERTY)
    }

    private fun verifyJsonField(modelClass: Class<*>, emptyModel: Any, rawGetter: Method) {
        val propertyName = rawGetter.getAnnotation(JsonProperty::class.java).value
        val emptyField = rawGetter.invoke(emptyModel) as JsonField<*>
        val typedGetter =
            modelClass.methods.singleOrNull {
                it.name == rawGetter.name.removePrefix("_") && it.parameterCount == 0
            }

        assertThat(emptyField.isMissing()).isTrue()
        if (typedGetter == null) {
            verifyRawOnlyJsonField(modelClass, emptyModel, rawGetter, propertyName)
            return
        }

        assertMissingGetter(typedGetter, emptyModel)

        val invalidModel =
            INVALID_VALUES.asSequence()
                .map { value ->
                    MAPPER.readValue(
                        MAPPER.writeValueAsString(mapOf(propertyName to value)),
                        modelClass,
                    )
                }
                .firstOrNull { candidate ->
                    val field = rawGetter.invoke(candidate) as JsonField<*>
                    field.asUnknown().isPresent && !field.isMissing() && !field.isNull()
                }

        if (invalidModel == null) {
            return
        }

        val invalidField = rawGetter.invoke(invalidModel) as JsonField<*>
        val getterFailure = invocationFailure { typedGetter.invoke(invalidModel) }

        assertThat(invalidField.asUnknown()).isPresent()
        assertThat(getterFailure).isInstanceOf(XTwitterScraperInvalidDataException::class.java)
        assertThat(copyOf(invalidModel)).isEqualTo(invalidModel)
        assertThat(invalidModel).isNotEqualTo(emptyModel)
        assertThat(invalidModel.hashCode()).isNotEqualTo(emptyModel.hashCode())
        assertThat(invalidModel.toString()).contains(rawGetter.name.removePrefix("_"))
    }

    private fun verifyRawOnlyJsonField(
        modelClass: Class<*>,
        emptyModel: Any,
        rawGetter: Method,
        propertyName: String,
    ) {
        val valueModel =
            MAPPER.readValue(
                MAPPER.writeValueAsString(mapOf(propertyName to true)),
                modelClass,
            )
        val valueField = rawGetter.invoke(valueModel) as JsonField<*>

        assertThat(valueField.asBoolean()).contains(true)
        assertThat(copyOf(valueModel)).isEqualTo(valueModel)
        assertThat(valueModel).isNotEqualTo(emptyModel)
        assertThat(valueModel.toString()).contains(rawGetter.name.removePrefix("_"))
    }

    private fun assertMissingGetter(getter: Method, model: Any) {
        val failure = invocationFailure { getter.invoke(model) }

        if (failure != null) {
            assertThat(failure).isInstanceOf(XTwitterScraperInvalidDataException::class.java)
            return
        }

        assertThat(Optional::class.java.isAssignableFrom(getter.returnType)).isTrue()
        assertThat(getter.invoke(model) as Optional<*>).isEmpty()
    }

    private fun copyOf(model: Any): Any {
        val toBuilder =
            model.javaClass.methods.single { it.name == "toBuilder" && it.parameterCount == 0 }
        val builder = toBuilder.invoke(model)
        val build =
            builder.javaClass.methods.single { it.name == "build" && it.parameterCount == 0 }

        return build.invoke(builder)
    }

    private fun rawFieldGetters(modelClass: Class<*>): List<Method> =
        modelClass.methods
            .filter {
                it.name.startsWith("_") &&
                    it.parameterCount == 0 &&
                    JsonField::class.java.isAssignableFrom(it.returnType) &&
                    it.isAnnotationPresent(JsonProperty::class.java)
            }
            .sortedBy { it.name }

    private fun generatedModelClasses(): List<Class<*>> =
        allModelClasses().filter(::isGeneratedJsonModel)

    private fun generatedParamClasses(): List<Class<*>> =
        allModelClasses().filter {
            Params::class.java.isAssignableFrom(it) &&
                !it.isInterface &&
                !Modifier.isAbstract(it.modifiers) &&
                hasBuilder(it) &&
                it.methods.any { method ->
                    method.name == "toBuilder" && method.parameterCount == 0
                }
        }

    private fun generatedEnumClasses(): List<Class<*>> =
        allModelClasses().filter {
            XquikEnum::class.java.isAssignableFrom(it) &&
                !it.isInterface &&
                !it.isEnum &&
                !Modifier.isAbstract(it.modifiers)
        }

    private fun allModelClasses(): List<Class<*>> =
        classDirectories()
            .flatMap(::classNames)
            .distinct()
            .map { Class.forName(it) }
            .sortedBy { it.name }

    private fun classNames(classDirectory: Path): List<String> =
        Files.walk(classDirectory).use { paths ->
            paths
                .iterator()
                .asSequence()
                .filter { it.isRegularFile() }
                .filter { it.extension == "class" }
                .map { classFile -> className(classDirectory, classFile) }
                .toList()
        }

    private fun classDirectories(): List<Path> =
        Thread.currentThread()
            .contextClassLoader
            .getResources(MODEL_RESOURCE_PATH)
            .toList()
            .filter { it.protocol == "file" }
            .map { Paths.get(it.toURI()) }

    private fun className(classDirectory: Path, classFile: Path): String {
        val nestedName =
            classFile.relativeTo(classDirectory).toString().removeSuffix(".class").replace('/', '.')

        return "$MODEL_PACKAGE.$nestedName"
    }

    private fun isGeneratedJsonModel(modelClass: Class<*>): Boolean =
        !modelClass.isInterface &&
            !modelClass.isEnum &&
            !modelClass.isAnnotation &&
            !modelClass.isSynthetic &&
            !Modifier.isAbstract(modelClass.modifiers) &&
            !modelClass.name.endsWith("\$Builder") &&
            !modelClass.name.endsWith("\$Companion") &&
            modelClass.declaredConstructors.any { constructor ->
                val creator = constructor.getAnnotation(JsonCreator::class.java)
                creator != null && creator.mode != JsonCreator.Mode.DISABLED
            } &&
            modelClass.methods.any { it.name == "toBuilder" && it.parameterCount == 0 }

    private fun invocationFailure(block: () -> Unit): Throwable? =
        try {
            block()
            null
        } catch (error: InvocationTargetException) {
            error.cause ?: error
        }

    companion object {

        private const val MODEL_PACKAGE = "com.x_twitter_scraper.api.models"
        private const val MODEL_RESOURCE_PATH = "com/x_twitter_scraper/api/models"
        private const val UNKNOWN_PROPERTY = "__contract_probe"
        private const val CONTRACT_VALUE = "contract-value"
        private const val CONTRACT_HEADER = "X-Contract-Probe"
        private const val CONTRACT_QUERY = "__contract_probe"
        private const val UNKNOWN_ENUM_NAME = "_UNKNOWN"
        private const val UNKNOWN_ENUM_VALUE = "__contract_unknown"
        private val MAPPER = jsonMapper()
        private val INVALID_VALUES =
            listOf(emptyMap<String, Any>(), emptyList<Any>(), "invalid", 1, true)
        private val OBJECT_METHODS = setOf("equals", "hashCode", "toString")
    }
}
