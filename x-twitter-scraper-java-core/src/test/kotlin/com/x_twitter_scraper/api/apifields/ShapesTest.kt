// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.apifields

import com.fasterxml.jackson.databind.ObjectMapper
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
    ) =
        compareOperation(spec, SdkOperation(query, body, response), emptyMap()).map {
            "${it.side} ${it.kind} ${it.path}"
        }

    private fun json(schema: String) =
        """{"200": {"content": {"application/json": {"schema": $schema}}}}"""

    private fun requestBodySpec(mediaType: String): SpecOperation =
        specOperation(
            "{}",
            """"requestBody": {"content": {
              "application/json": {"schema": {"type": "object", "required": ["body"], "properties": {"body": {"type": "string"}}}},
              "$mediaType": {"schema": {"type": "object", "properties": {"body": {"type": "string"}, "attachments": {"type": "array", "items": {"type": "string", "format": "binary"}}}}}
            }},""",
        )

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
                            Arr(
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
    fun reportsRequiredAndMissingFieldsAcrossRequestBodyTypes() {
        val sdk = Obj(mapOf("body" to Prop(true, false, Leaf())))

        listOf("multipart/form-data", "application/x-www-form-urlencoded").forEach { mediaType ->
            assertThat(compare(requestBodySpec(mediaType), null, body = sdk))
                .containsExactly("request required body", "request missing attachments")
        }
    }

    @Test
    fun passesWhenRequestFieldsMatchEveryBodyType() {
        val sdk =
            Obj(
                mapOf(
                    "body" to Prop(false, false, Leaf()),
                    "attachments" to Prop(false, false, Arr(Leaf())),
                )
            )

        listOf("multipart/form-data", "application/x-www-form-urlencoded").forEach { mediaType ->
            assertThat(compare(requestBodySpec(mediaType), null, body = sdk)).isEmpty()
        }
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
                            Arr(
                                Obj(
                                    mapOf(
                                        "id" to Prop(true, false, Leaf()),
                                        "tags" to Prop(false, false, Arr(Leaf())),
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
