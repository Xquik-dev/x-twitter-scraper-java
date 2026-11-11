// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

@file:JvmName("ApiFields")

package com.x_twitter_scraper.api.apifields

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File
import kotlin.system.exitProcess

private const val ACCEPTED_FILE = "accepted-field-differences.json"
private const val EXCLUDED_FILE = "excluded-operations.json"

private val httpMethods =
    listOf("get", "put", "post", "delete", "options", "head", "patch", "trace")

private val differencePattern =
    Regex(
        "^(${httpMethods.joinToString("|") { it.uppercase() }}) /\\S* (request|response) (missing|extra|enum|required|nullable) \\S+$"
    )

internal fun comparable(operation: String): String = operation.replace(Regex("\\{[^}]*\\}"), "{}")

internal class FieldCheck(private val spec: JsonNode, private val root: File) {

    private val mapper = ObjectMapper()

    fun run(): String {
        val accepted = readAccepted()
        val excluded = readExcluded()
        val shapes = SdkShapes()
        val specShapes = SpecShapes(spec)
        val operations = specOperations().filterNot { comparable(it.first) in excluded }
        val sdk = sdkOperations(shapes, operations.map { it.first })
        val unread = operations.filter { (id, _) -> id !in sdk }
        if (unread.isNotEmpty()) {
            throw CheckFailure(
                (unread.map { (id, _) -> "$id has no SDK method the field check can read." } +
                        "Write each operation above as a service method, or list it in $EXCLUDED_FILE.")
                    .joinToString("\n")
            )
        }
        val found =
            operations
                .flatMap { (id, specOperation) ->
                    val (pathItem, operation) = specOperation
                    sdk.getValue(id).flatMap { method ->
                        val (query, body) = shapes.params(method.params, method.input)
                        val response = method.response?.let { shapes.type(it) }
                        compareOperation(
                                specShapes.operation(pathItem, operation, method.bodyType),
                                SdkOperation(query, body, response),
                                shapes.defs,
                            )
                            .map { "$id ${it.side} ${it.kind} ${it.path}" }
                    }
                }
                .distinct()
        val acceptedKeys = accepted.map(::comparable).toSet()
        val foundKeys = found.map(::comparable).toSet()
        val differences = found.filter { comparable(it) !in acceptedKeys }
        val stale =
            accepted
                .filter { comparable(it) !in foundKeys }
                .map { "$ACCEPTED_FILE lists $it, which the check no longer finds. Remove it." }
        if (differences.isNotEmpty() || stale.isNotEmpty()) {
            val next =
                if (differences.isNotEmpty())
                    "Fix each field above in the SDK, or list it in $ACCEPTED_FILE with a reason."
                else "Remove each difference above from $ACCEPTED_FILE."
            throw CheckFailure((differences + stale + next).joinToString("\n"))
        }
        return "The SDK's fields match the API for ${plural(operations.size, "operation")}, and " +
            "$ACCEPTED_FILE lists ${plural(accepted.size, "accepted difference")}."
    }

    private fun plural(count: Int, noun: String): String =
        "$count $noun${if (count == 1) "" else "s"}"

    private fun specOperations(): List<Pair<String, Pair<JsonNode, JsonNode>>> {
        val root = firstUrl(spec.get("servers"))
        return spec.path("paths").properties().flatMap { (path, item) ->
            httpMethods.mapNotNull { method ->
                item.get(method)?.let { operation ->
                    val server =
                        firstUrl(operation.get("servers"))
                            ?: firstUrl(item.get("servers"))
                            ?: root
                            ?: ""
                    "${method.uppercase()} ${urlPath(server)}$path" to (item to operation)
                }
            }
        }
    }

    private fun firstUrl(servers: JsonNode?): String? =
        servers?.takeIf { it.isArray && !it.isEmpty }?.get(0)?.get("url")?.asText()

    private fun urlPath(url: String): String =
        url.replace(Regex("^[A-Za-z][A-Za-z0-9+.-]*://[^/]*"), "")
            .replace(Regex("[?#].*$"), "")
            .trimEnd('/')

    private fun sdkOperations(shapes: SdkShapes, ids: List<String>): Map<String, List<SdkMethod>> {
        val templates = ids.map { id -> id to Operations.segments(id.substringAfter(" ")) }
        return Operations.methods(shapes)
            .mapNotNull { method -> match(method, templates)?.let { it to method } }
            .groupBy({ it.first }, { it.second })
    }

    private fun match(method: SdkMethod, templates: List<Pair<String, List<String>>>): String? =
        templates
            .filter { (id, segments) ->
                id.substringBefore(" ") == method.httpMethod &&
                    segments.size == method.segments.size &&
                    segments.zip(method.segments).all { (template, actual) ->
                        template.startsWith("{") || template == actual
                    }
            }
            .maxByOrNull { (_, segments) -> segments.count { !it.startsWith("{") } }
            ?.first

    private fun readExcluded(): Set<String> =
        readJson(EXCLUDED_FILE)
            .flatMap { group -> group.path("operations").map { comparable(it.asText()) } }
            .toSet()

    private fun readAccepted(): List<String> {
        val groups = readJson(ACCEPTED_FILE)
        fun invalid(problem: String): Nothing =
            throw CheckFailure("$ACCEPTED_FILE is not valid. $problem.")
        if (!groups.isArray) invalid("It must hold a list of groups")
        val seen = mutableSetOf<String>()
        groups.forEachIndexed { index, group ->
            val label = "Group ${index + 1}"
            if (!group.isObject) invalid("$label is not an object")
            group
                .fieldNames()
                .asSequence()
                .firstOrNull { it != "reason" && it != "differences" }
                ?.let {
                    invalid("$label has the unknown field $it")
                }
            val reason = group.get("reason")
            if (reason == null || !reason.isTextual || reason.asText().isBlank())
                invalid("$label needs a reason")
            val differences = group.get("differences")
            if (differences == null || !differences.isArray || differences.isEmpty)
                invalid("$label needs at least 1 difference")
            for (entry in differences) {
                if (!entry.isTextual || !differencePattern.matches(entry.asText())) {
                    invalid(
                        "$label lists $entry, which needs a method, a path, request or response, a kind and a field, " +
                            "such as GET /api/v1/events response missing events[].data.followedAt"
                    )
                }
                if (!seen.add(comparable(entry.asText())))
                    invalid("It lists ${entry.asText()} more than once")
            }
        }
        return groups.flatMap { group -> group.get("differences").map { it.asText() } }
    }

    private fun readJson(name: String): JsonNode {
        val file = File(root, name)
        if (!file.isFile)
            throw CheckFailure("$name is not valid. The repository root has no such file.")
        return try {
            mapper.readTree(file)
        } catch (e: JsonProcessingException) {
            throw CheckFailure(
                "$name is not valid. It is not JSON near line ${e.location?.lineNr ?: 1}."
            )
        }
    }
}

fun main(args: Array<String>) {
    val (specPath, root) = args
    try {
        val spec = ObjectMapper().readTree(File(specPath))
        println(FieldCheck(spec, File(root)).run())
    } catch (e: CheckFailure) {
        System.err.println(e.message)
        exitProcess(1)
    }
}
