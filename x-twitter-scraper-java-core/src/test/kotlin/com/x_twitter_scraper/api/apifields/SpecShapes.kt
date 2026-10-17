// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.apifields

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.fasterxml.jackson.databind.node.ObjectNode

internal class CheckFailure(message: String) : Exception(message)

private val bodyTypes =
    setOf("application/json", "multipart/form-data", "application/x-www-form-urlencoded")

private val ignoredRefSiblings =
    setOf(
        "\$ref",
        "description",
        "example",
        "examples",
        "title",
        "deprecated",
        "readOnly",
        "writeOnly",
    )

internal class SpecShapes(private val spec: JsonNode) {

    fun resolve(ref: String): JsonNode {
        val target =
            ref.removePrefix("#/").split("/").fold<String, JsonNode?>(spec) { node, part ->
                node?.get(part.replace("~1", "/").replace("~0", "~"))
            }
        if (target == null || target.isMissingNode) {
            throw CheckFailure("Could not resolve $ref in the API spec. Check the spec source.")
        }
        return target
    }

    fun shape(schema: JsonNode?, stack: List<String> = emptyList()): Pair<Shape, Boolean> {
        if (schema == null || !schema.isObject) return Unknown to false
        if (schema.has("\$ref")) return refShape(schema as ObjectNode, stack)
        var nullable = schema.path("nullable").asBoolean(false)
        val typeNode = schema.get("type")
        val types: List<String>? =
            when {
                typeNode == null -> null
                typeNode.isArray -> typeNode.map { it.asText() }
                typeNode.asText() == "null" -> return Unknown to true
                else -> listOf(typeNode.asText())
            }
        if (types != null && "null" in types) nullable = true
        val plainTypes = types?.filter { it != "null" }
        schema.get("allOf")?.let { allOf ->
            val parts = allOf.map { shape(it, stack).first }.toMutableList()
            val properties = schema.get("properties")
            if (properties != null && properties.size() > 0) {
                val rest = (schema as ObjectNode).deepCopy().apply { remove("allOf") }
                parts.add(shape(rest, stack).first)
            }
            return intersect(parts) to nullable
        }
        for (keyword in listOf("oneOf", "anyOf")) {
            val alternatives = schema.get(keyword) ?: continue
            var variants = mutableListOf<Shape>()
            for (sub in alternatives) {
                val enum = sub.get("enum")
                if (
                    sub.path("type").asText() == "null" ||
                        (enum != null && enum.size() == 1 && enum[0].isNull)
                ) {
                    nullable = true
                    continue
                }
                val (variant, variantNullable) = shape(sub, stack)
                nullable = nullable || variantNullable
                variants.add(variant)
            }
            val properties = schema.get("properties")
            if (properties != null && properties.size() > 0) {
                val rest = (schema as ObjectNode).deepCopy().apply { remove(keyword) }
                val base = shape(rest, stack).first
                variants = variants.map { intersect(listOf(base, it)) }.toMutableList()
            }
            return (if (variants.size == 1) variants.single() else Union(variants)) to nullable
        }
        if (schema.has("const")) return leaf(listOf(scalar(schema.get("const")))) to nullable
        schema
            .get("enum")
            ?.takeIf { it.isArray }
            ?.let { enum ->
                val values = enum.filter { !it.isNull }.map(::scalar)
                return leaf(values) to (nullable || values.size < enum.size())
            }
        val properties = schema.get("properties")
        if (plainTypes == null && properties == null && schema.has("required")) {
            return Free(schema.path("required").map { it.asText() }) to nullable
        }
        val isObject = plainTypes?.contains("object") == true || properties != null
        if (isObject && properties != null && properties.size() > 0) {
            val required = schema.path("required").map { it.asText() }.toSet()
            val props =
                properties.properties().associate { (name, sub) ->
                    val (child, childNullable) = shape(sub, stack)
                    name to Prop(name in required, childNullable, child)
                }
            val additional = schema.get("additionalProperties")
            val open = additional != null && !(additional.isBoolean && !additional.asBoolean())
            return Obj(props, open) to nullable
        }
        if (isObject) {
            val required = schema.path("required").map { it.asText() }
            return Free(required) to nullable
        }
        if (plainTypes?.contains("array") == true) {
            if (schema.has("items") && !schema.has("prefixItems")) {
                return Arr(shape(schema.get("items"), stack).first) to nullable
            }
            return Leaf() to nullable
        }
        return Leaf() to nullable
    }

    private fun scalar(node: JsonNode): String =
        if (node.isTextual) node.asText() else node.toString()

    private fun refShape(schema: ObjectNode, stack: List<String>): Pair<Shape, Boolean> {
        val ref = schema.get("\$ref").asText()
        if (ref in stack) return Cycle to false
        val target = resolve(ref)
        val siblings = schema.deepCopy().apply { remove(ignoredRefSiblings) }
        if (siblings.properties().any { (key, _) -> key != "type" }) {
            val combined = JsonNodeFactory.instance.objectNode()
            combined.putArray("allOf").add(target).add(siblings)
            return shape(combined, stack + ref)
        }
        val (shape, nullable) = shape(target, stack + ref)
        val siblingType = siblings.get("type")
        return shape to
            (nullable ||
                (siblingType != null &&
                    siblingType.isArray &&
                    siblingType.any { it.asText() == "null" }))
    }

    private fun schemas(content: JsonNode?, accept: (String) -> Boolean): List<JsonNode> =
        content
            ?.properties()
            ?.filter { (type, media) ->
                accept(type.substringBefore(";").trim()) && media.has("schema")
            }
            ?.map { (_, media) -> media.get("schema") } ?: emptyList()

    fun operation(pathItem: JsonNode, operation: JsonNode): SpecOperation {
        val params = linkedMapOf<String, JsonNode>()
        for (raw in pathItem.path("parameters") + operation.path("parameters")) {
            val param = if (raw.has("\$ref")) resolve(raw.get("\$ref").asText()) else raw
            params["${param.path("in").asText()} ${param.path("name").asText()}"] = param
        }
        val query = linkedMapOf<String, Prop>()
        val nonBodyParams = mutableListOf<String>()
        for (param in params.values) {
            val name = param.path("name").asText()
            when (param.path("in").asText()) {
                "query" ->
                    query[name] =
                        Prop(
                            param.path("required").asBoolean(false),
                            null,
                            shape(param.get("schema")).first,
                        )
                "path",
                "header" -> nonBodyParams.add(name)
            }
        }
        val requestBody =
            operation.get("requestBody")?.let {
                if (it.has("\$ref")) resolve(it.get("\$ref").asText()) else it
            }
        val bodies =
            schemas(requestBody?.get("content")) { it in bodyTypes }.map { shape(it).first }
        val responses =
            operation
                .path("responses")
                .properties()
                .filter { (code, _) -> code.startsWith("2") }
                .flatMap { (_, raw) ->
                    val response = if (raw.has("\$ref")) resolve(raw.get("\$ref").asText()) else raw
                    schemas(response.get("content")) {
                        it == "application/json" || it.endsWith("+json")
                    }
                }
                .map { shape(it).first }
        return SpecOperation(Obj(query), nonBodyParams, one(bodies), one(responses))
    }

    private fun one(shapes: List<Shape>): Shape? =
        when (shapes.size) {
            0 -> null
            1 -> shapes.single()
            else -> Union(shapes)
        }
}
