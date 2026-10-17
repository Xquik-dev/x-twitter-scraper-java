// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.apifields

internal sealed interface Shape

internal data class Free(val requires: List<String> = emptyList()) : Shape

internal data object Cycle : Shape

internal data object Unknown : Shape

internal data class Leaf(val values: List<String>? = null) : Shape

internal data class Obj(val props: Map<String, Prop>, val open: Boolean = false) : Shape

internal data class Arr(val items: Shape) : Shape

internal data class Union(val variants: List<Shape>) : Shape

internal data class Ref(val name: String) : Shape

internal data class Prop(val required: Boolean?, val nullable: Boolean?, val shape: Shape)

internal data class Difference(val side: String, val kind: String, val path: String)

internal fun leaf(values: Collection<Any?>?): Leaf =
    Leaf(values?.map { it.toString() }?.distinct()?.sorted())

private fun opaque(shape: Shape): Boolean = shape is Free || shape is Cycle || shape is Unknown

internal fun canon(
    shape: Shape,
    defs: Map<String, Shape> = emptyMap(),
    stack: List<String> = emptyList(),
): Shape =
    when (shape) {
        is Ref ->
            if (shape.name in stack) Cycle
            else canon(defs.getValue(shape.name), defs, stack + shape.name)
        is Obj ->
            Obj(
                shape.props.mapValues { (_, p) -> p.copy(shape = canon(p.shape, defs, stack)) },
                shape.open,
            )
        is Arr -> Arr(canon(shape.items, defs, stack))
        is Union -> mergeUnion(shape.variants.map { canon(it, defs, stack) })
        else -> shape
    }

private fun mergeProps(objects: List<Obj>): Map<String, Prop> {
    val names = objects.flatMap { it.props.keys }.distinct()
    return names.associateWith { name ->
        val have = objects.mapNotNull { it.props[name] }
        val requireds = have.map { it.required }
        val required =
            if (have.size < objects.size) {
                if (requireds.all { it != null }) false else null
            } else if (requireds.any { it == null }) {
                null
            } else {
                requireds.all { it == true }
            }
        val nullables = have.map { it.nullable }
        val nullable = if (nullables.any { it == null }) null else nullables.any { it == true }
        Prop(required, nullable, mergeUnion(have.map { it.shape }))
    }
}

internal fun mergeUnion(all: List<Shape>): Shape {
    val known = all.filter { it !is Cycle && it != Unknown }
    val variants = known.ifEmpty { all }
    if (variants.isEmpty()) return Unknown
    if (variants.size == 1) return variants.single()
    if (variants.any { it is Free }) return Free()
    val objects = variants.filterIsInstance<Obj>()
    if (objects.isNotEmpty()) return Obj(mergeProps(objects), objects.any { it.open })
    val arrays = variants.filterIsInstance<Arr>()
    if (arrays.isNotEmpty()) return Arr(mergeUnion(arrays.map { it.items }))
    val leaves = variants.filterIsInstance<Leaf>()
    if (leaves.isNotEmpty()) {
        return if (leaves.all { it.values != null }) leaf(leaves.flatMap { it.values.orEmpty() })
        else Leaf()
    }
    return Unknown
}

internal fun intersect(all: List<Shape>): Shape {
    val parts = all.filter { it != Unknown }
    if (parts.isEmpty()) return Unknown
    val unions = parts.filterIsInstance<Union>()
    if (unions.size == 1) {
        val rest = parts.filter { it !is Union }
        return Union(unions.single().variants.map { intersect(rest + it) })
    }
    if (parts.size > 1 && parts.all { it is Arr }) {
        return Arr(intersect(parts.map { (it as Arr).items }))
    }
    val objects = parts.filterIsInstance<Obj>()
    if (objects.isEmpty()) return parts.first()
    val props = linkedMapOf<String, Prop>()
    for (o in objects) {
        for ((name, p) in o.props) {
            val old = props[name]
            props[name] =
                if (old == null) p
                else
                    Prop(
                        old.required == true || p.required == true,
                        old.nullable == true && p.nullable == true,
                        intersect(listOf(old.shape, p.shape)),
                    )
        }
    }
    for (name in parts.filterIsInstance<Free>().flatMap { it.requires }) {
        props[name]?.let { props[name] = it.copy(required = true) }
    }
    return Obj(props, objects.any { it.open })
}

private fun topLevel(shape: Shape?, kind: String, side: String): List<Difference> =
    if (shape is Obj) shape.props.keys.map { Difference(side, kind, it) } else emptyList()

private fun compareTree(
    spec: Shape,
    sdk: Shape,
    path: String,
    side: String,
    out: MutableList<Difference>,
) {
    if (opaque(spec) || opaque(sdk)) return
    if (spec is Obj && sdk is Obj) {
        for ((name, specProp) in spec.props) {
            val here = if (path.isEmpty()) name else "$path.$name"
            val sdkProp = sdk.props[name]
            if (sdkProp == null) {
                out.add(Difference(side, "missing", here))
                continue
            }
            if (
                specProp.required != null &&
                    sdkProp.required != null &&
                    specProp.required != sdkProp.required
            ) {
                out.add(Difference(side, "required", here))
            }
            if (
                specProp.nullable != null &&
                    sdkProp.nullable != null &&
                    specProp.nullable != sdkProp.nullable
            ) {
                out.add(Difference(side, "nullable", here))
            }
            compareTree(specProp.shape, sdkProp.shape, here, side, out)
        }
        if (!spec.open) {
            for (name in sdk.props.keys - spec.props.keys) {
                out.add(Difference(side, "extra", if (path.isEmpty()) name else "$path.$name"))
            }
        }
        return
    }
    if (spec is Arr && sdk is Arr) {
        compareTree(spec.items, sdk.items, "$path[]", side, out)
        return
    }
    if (spec is Leaf && sdk is Leaf) {
        if (spec.values != null && sdk.values != null && spec.values != sdk.values) {
            out.add(Difference(side, "enum", path))
        }
        return
    }
    if (path.isEmpty()) out.addAll(topLevel(spec, "missing", side))
    else out.add(Difference(side, "missing", path))
}

private fun normalized(name: String): String = name.lowercase().replace(Regex("[^a-z0-9]"), "")

private fun withoutParams(
    shape: Shape?,
    nonBodyParams: List<String>,
    specNames: Set<String>,
): Shape? {
    if (shape !is Obj) return shape
    val names = nonBodyParams.map(::normalized).toSet()
    return Obj(
        shape.props.filterKeys { !(normalized(it) in names && it !in specNames) },
        shape.open,
    )
}

internal data class SpecOperation(
    val query: Obj,
    val nonBodyParams: List<String>,
    val body: Shape?,
    val response: Shape?,
)

internal data class SdkOperation(val query: Shape, val body: Shape?, val response: Shape?)

internal fun compareOperation(
    spec: SpecOperation,
    sdk: SdkOperation,
    defs: Map<String, Shape>,
): List<Difference> {
    val specQuery = canon(spec.query) as Obj
    val specBody = spec.body?.let { canon(it) }
    val specNames = specQuery.props.keys + ((specBody as? Obj)?.props?.keys ?: emptySet())
    val sdkQuery = withoutParams(canon(sdk.query, defs), spec.nonBodyParams, specNames)!!
    var sdkBody = sdk.body?.let { withoutParams(canon(it, defs), spec.nonBodyParams, specNames) }
    if (sdkBody is Obj && sdkBody.props.isEmpty() && specBody == null) sdkBody = null
    val specResponse = spec.response?.let { canon(it) }
    val out = mutableListOf<Difference>()
    compareTree(specQuery, sdkQuery, "", "request", out)
    when {
        specBody != null && sdkBody != null -> compareTree(specBody, sdkBody, "", "request", out)
        specBody != null -> out.addAll(topLevel(specBody, "missing", "request"))
        sdkBody != null -> out.addAll(topLevel(sdkBody, "extra", "request"))
    }
    when {
        specResponse != null && sdk.response != null ->
            compareTree(specResponse, canon(sdk.response, defs), "", "response", out)
        specResponse != null -> out.addAll(topLevel(specResponse, "missing", "response"))
    }
    return out
}
