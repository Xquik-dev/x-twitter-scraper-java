// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.apifields

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.models.x.sports.SportsTeamRecord
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class ShapesTest {

    private fun specOperation(responses: String, extra: String = ""): SpecOperation {
        val spec =
            ObjectMapper()
                .readTree(
                    """
                    {
                      "paths": {"/things": {"get": {$extra "responses": $responses}}},
                      "components": {
                        "schemas": {
                          "Thing": {"type": "object", "required": ["id"], "properties": {"id": {"type": "string"}, "tags": {"type": "array", "items": {"type": "string"}}}},
                          "Node": {"type": "object", "properties": {"child": {"${'$'}ref": "#/components/schemas/Node"}}}
                        },
                        "parameters": {"Limit": {"name": "limit", "in": "query", "required": true, "schema": {"type": "integer"}}},
                        "requestBodies": {"Upload": {"content": {"multipart/form-data": {"schema": {"type": "object", "properties": {"file": {"type": "string"}}}}}}}
                      }
                    }
                    """
                )
        val shapes = SpecShapes(spec)
        return shapes.operation(spec.at("/paths/~1things"), spec.at("/paths/~1things/get"))
    }

    private fun compare(
        spec: SpecOperation,
        response: Shape?,
        query: Shape = Obj(emptyMap()),
        body: Shape? = null,
        defs: Map<String, Shape> = emptyMap(),
    ) =
        compareOperation(spec, SdkOperation(query, body, response), defs).map {
            "${it.side} ${it.kind} ${it.path}"
        }

    private fun json(schema: String) =
        """{"200": {"content": {"application/json": {"schema": $schema}}}}"""

    @Test
    fun reportsMissingExtraRequiredAndNullableFieldsAtEveryDepth() {
        val spec =
            specOperation(
                json(
                    """{"type": "object", "required": ["id"], "properties": {"id": {"type": ["string", "null"]}, "items": {"type": "array", "items": {"type": "object", "properties": {"name": {"type": "string"}, "kind": {"enum": ["a", "b"]}}}}}}"""
                )
            )
        val sdk =
            Obj(
                mapOf(
                    "id" to Prop(false, false, Leaf()),
                    "items" to
                        Prop(
                            false,
                            false,
                            Many(
                                Obj(
                                    mapOf(
                                        "kind" to Prop(false, false, leaf(listOf("a"))),
                                        "old" to Prop(false, false, Leaf()),
                                    )
                                )
                            ),
                        ),
                )
            )

        assertThat(compare(spec, sdk))
            .containsExactly(
                "response required id",
                "response nullable id",
                "response missing items[].name",
                "response enum items[].kind",
                "response extra items[].old",
            )
    }

    @Test
    fun countsAMissingObjectOnceAtItsTopPosition() {
        val spec =
            specOperation(
                json(
                    """{"type": "object", "properties": {"thing": {"${'$'}ref": "#/components/schemas/Thing"}}}"""
                )
            )

        assertThat(compare(spec, Obj(emptyMap()))).containsExactly("response missing thing")
        assertThat(compare(spec, null)).containsExactly("response missing thing")
    }

    @Test
    fun mergesSeveralSuccessBodiesAndRequiresAFieldOnlyWhenEveryBodyDoes() {
        val spec =
            specOperation(
                """{
                  "200": {"content": {"application/json": {"schema": {"type": "object", "required": ["a", "b"], "properties": {"a": {"type": "string"}, "b": {"type": "string"}}}}}},
                  "202": {"content": {"application/json": {"schema": {"type": "object", "required": ["a"], "properties": {"a": {"type": "string"}, "c": {"type": "string"}}}}}}
                }"""
            )
        val sdk =
            Obj(
                mapOf(
                    "a" to Prop(true, false, Leaf()),
                    "b" to Prop(true, false, Leaf()),
                    "c" to Prop(false, false, Leaf()),
                )
            )

        assertThat(compare(spec, sdk)).containsExactly("response required b")
    }

    @Test
    fun intersectsAllOfPartsIncludingArraysAndBareRequiredLists() {
        val spec =
            specOperation(
                json(
                    """{"allOf": [
                      {"type": "object", "properties": {"rows": {"type": "array", "items": {"${'$'}ref": "#/components/schemas/Thing"}}, "note": {"type": "string"}}},
                      {"type": "object", "properties": {"rows": {"type": "array", "items": {"type": "object", "properties": {"rank": {"type": "integer"}}}}}},
                      {"required": ["note"]}
                    ]}"""
                )
            )
        val sdk =
            Obj(
                mapOf(
                    "note" to Prop(true, false, Leaf()),
                    "rows" to
                        Prop(
                            false,
                            false,
                            Many(
                                Obj(
                                    mapOf(
                                        "id" to Prop(true, false, Leaf()),
                                        "tags" to Prop(false, false, Many(Leaf())),
                                        "rank" to Prop(false, false, Leaf()),
                                    )
                                )
                            ),
                        ),
                )
            )

        assertThat(compare(spec, sdk)).isEmpty()
    }

    @Test
    fun stopsAtCyclesFreeFormObjectsAndUntypedValues() {
        val spec =
            specOperation(
                json(
                    """{"type": "object", "properties": {"node": {"${'$'}ref": "#/components/schemas/Node"}, "meta": {"type": "object"}, "data": {"type": "object", "properties": {"x": {"type": "string"}}}}}"""
                )
            )
        val sdk =
            Obj(
                mapOf(
                    "node" to
                        Prop(
                            false,
                            false,
                            Obj(
                                mapOf(
                                    "child" to
                                        Prop(
                                            false,
                                            false,
                                            Obj(mapOf("other" to Prop(false, false, Leaf()))),
                                        )
                                )
                            ),
                        ),
                    "meta" to Prop(false, false, Obj(mapOf("any" to Prop(false, false, Leaf())))),
                    "data" to Prop(false, false, Unknown),
                )
            )

        assertThat(compare(spec, sdk)).isEmpty()
    }

    private val record =
        """{"type": "object", "required": ["wins", "losses", "ties"], "properties": {"wins": {"type": ["integer", "null"]}, "losses": {"type": ["integer", "null"]}, "ties": {"type": ["integer", "null"]}}}"""

    private val recordWithStreak =
        """{"allOf": [$record, {"type": "object", "properties": {"streak": {"type": "string"}}}]}"""

    private val typedRecords = object : TypeReference<Map<String, SportsTeamRecord>>() {}

    private val untypedRecords = object : TypeReference<Map<String, JsonValue>>() {}

    private fun map(values: String) = """{"type": "object", "additionalProperties": $values}"""

    private fun recordsDifferences(records: String, sdkRecords: TypeReference<*>): List<String> {
        val shapes = SdkShapes()
        val sdk = Obj(mapOf("records" to Prop(false, false, shapes.type(sdkRecords.type))))
        val spec = specOperation(json("""{"type": "object", "properties": {"records": $records}}"""))
        return compare(spec, sdk, defs = shapes.defs)
    }

    @Test
    fun reportsAFieldTheSdkLacksInTypedMapValues() {
        val missing = listOf("response missing records{}.streak")
        val union = """{"anyOf": [${map(record)}, ${map(recordWithStreak)}]}"""
        val intersection = """{"allOf": [${map(record)}, ${map(recordWithStreak)}]}"""

        assertThat(recordsDifferences(map(recordWithStreak), typedRecords)).isEqualTo(missing)
        assertThat(recordsDifferences(union, typedRecords)).isEqualTo(missing)
        assertThat(recordsDifferences(intersection, typedRecords)).isEqualTo(missing)
    }

    @Test
    fun leavesAMapFreeFormWhenEitherSideLeavesItsValuesUntyped() {
        assertThat(recordsDifferences(map(record), typedRecords)).isEmpty()
        assertThat(recordsDifferences(map("true"), typedRecords)).isEmpty()
        assertThat(recordsDifferences(map("{}"), typedRecords)).isEmpty()
        assertThat(recordsDifferences(record, untypedRecords)).isEmpty()
    }

    @Test
    fun allowsExtraSdkFieldsUnderAnOpenObject() {
        val spec =
            specOperation(
                json(
                    """{"type": "object", "additionalProperties": true, "properties": {"a": {"type": "string"}}}"""
                )
            )

        assertThat(
                compare(
                    spec,
                    Obj(
                        mapOf("a" to Prop(false, false, Leaf()), "b" to Prop(false, false, Leaf()))
                    ),
                )
            )
            .isEmpty()
    }

    @Test
    fun readsQueryParamsBodiesAndRefsWithSiblings() {
        val spec =
            specOperation(
                json(
                    """{"${'$'}ref": "#/components/schemas/Thing", "description": "Ignored", "properties": {"extra": {"type": "string"}}}"""
                ),
                """"parameters": [{"${'$'}ref": "#/components/parameters/Limit"}, {"name": "id", "in": "path", "required": true, "schema": {"type": "string"}}], "requestBody": {"${'$'}ref": "#/components/requestBodies/Upload"},""",
            )

        assertThat(spec.query.props.keys).containsExactly("limit")
        assertThat(spec.query.props.getValue("limit").required).isTrue()
        assertThat(spec.nonBodyParams).containsExactly("id")
        assertThat((spec.body as Obj).props.keys).containsExactly("file")
        assertThat((spec.response as Obj).props.keys)
            .containsExactlyInAnyOrder("id", "tags", "extra")
    }

    @Test
    fun treatsNullVariantsAndConstantsAsTheSpecDefinesThem() {
        val spec =
            specOperation(
                json(
                    """{"type": "object", "properties": {"a": {"oneOf": [{"type": "string"}, {"type": "null"}]}, "b": {"const": "fixed"}, "c": {"enum": ["x", null]}}}"""
                )
            )
        val response = spec.response as Obj

        assertThat(response.props.getValue("a").nullable).isTrue()
        assertThat(response.props.getValue("b").shape).isEqualTo(Leaf(listOf("fixed")))
        assertThat(response.props.getValue("c")).isEqualTo(Prop(false, true, Leaf(listOf("x"))))
    }

    @Test
    fun failsOnAReferenceTheSpecDoesNotDefine() {
        assertThatThrownBy {
                specOperation(json("""{"${'$'}ref": "#/components/schemas/Missing"}"""))
            }
            .isInstanceOf(CheckFailure::class.java)
            .hasMessage(
                "Could not resolve #/components/schemas/Missing in the API spec. Check the spec source."
            )
    }
}
