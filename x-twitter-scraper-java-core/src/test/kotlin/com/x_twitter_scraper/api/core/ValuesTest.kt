package com.x_twitter_scraper.api.core

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ValuesTest {
    companion object {
        private val NON_JSON = Any()
    }

    enum class TestCase(
        val value: JsonField<*>,
        val expectedIsMissing: Boolean = false,
        val expectedIsNull: Boolean = false,
        val expectedAsKnown: Optional<*> = Optional.empty<Nothing>(),
        val expectedAsBoolean: Optional<Boolean> = Optional.empty(),
        val expectedAsNumber: Optional<Number> = Optional.empty(),
        val expectedAsString: Optional<String> = Optional.empty(),
        val expectedAsArray: Optional<List<JsonValue>> = Optional.empty(),
        val expectedAsObject: Optional<Map<String, JsonValue>> = Optional.empty(),
    ) {
        MISSING(JsonMissing.of(), expectedIsMissing = true),
        NULL(JsonNull.of(), expectedIsNull = true),
        KNOWN(KnownValue.of(NON_JSON), expectedAsKnown = Optional.of(NON_JSON)),
        KNOWN_BOOLEAN(
            KnownValue.of(true),
            expectedAsKnown = Optional.of(true),
            expectedAsBoolean = Optional.of(true),
        ),
        BOOLEAN(JsonBoolean.of(true), expectedAsBoolean = Optional.of(true)),
        KNOWN_NUMBER(
            KnownValue.of(42),
            expectedAsKnown = Optional.of(42),
            expectedAsNumber = Optional.of(42),
        ),
        NUMBER(JsonNumber.of(42), expectedAsNumber = Optional.of(42)),
        KNOWN_STRING(
            KnownValue.of("hello"),
            expectedAsKnown = Optional.of("hello"),
            expectedAsString = Optional.of("hello"),
        ),
        STRING(JsonString.of("hello"), expectedAsString = Optional.of("hello")),
        KNOWN_ARRAY_NOT_ALL_JSON(
            KnownValue.of(listOf("a", "b", NON_JSON)),
            expectedAsKnown = Optional.of(listOf("a", "b", NON_JSON)),
        ),
        KNOWN_ARRAY(
            KnownValue.of(listOf("a", "b", "c")),
            expectedAsKnown = Optional.of(listOf("a", "b", "c")),
            expectedAsArray =
                Optional.of(listOf(JsonString.of("a"), JsonString.of("b"), JsonString.of("c"))),
        ),
        ARRAY(
            JsonArray.of(listOf(JsonString.of("a"), JsonString.of("b"), JsonString.of("c"))),
            expectedAsArray =
                Optional.of(listOf(JsonString.of("a"), JsonString.of("b"), JsonString.of("c"))),
        ),
        KNOWN_OBJECT_NOT_ALL_STRING_KEYS(
            KnownValue.of(mapOf("a" to "b", 42 to "c")),
            expectedAsKnown = Optional.of(mapOf("a" to "b", 42 to "c")),
        ),
        KNOWN_OBJECT_NOT_ALL_JSON(
            KnownValue.of(mapOf("a" to "b", "b" to NON_JSON)),
            expectedAsKnown = Optional.of(mapOf("a" to "b", "b" to NON_JSON)),
        ),
        KNOWN_OBJECT(
            KnownValue.of(mapOf("a" to "b", "b" to "c")),
            expectedAsKnown = Optional.of(mapOf("a" to "b", "b" to "c")),
            expectedAsObject =
                Optional.of(mapOf("a" to JsonString.of("b"), "b" to JsonString.of("c"))),
        ),
        OBJECT(
            JsonObject.of(mapOf("a" to JsonString.of("b"), "b" to JsonString.of("c"))),
            expectedAsObject =
                Optional.of(mapOf("a" to JsonString.of("b"), "b" to JsonString.of("c"))),
        ),
    }

    @ParameterizedTest
    @EnumSource
    fun isMissing(testCase: TestCase) {
        val isMissing = testCase.value.isMissing()

        assertThat(isMissing).isEqualTo(testCase.expectedIsMissing)
    }

    @ParameterizedTest
    @EnumSource
    fun isNull(testCase: TestCase) {
        val isNull = testCase.value.isNull()

        assertThat(isNull).isEqualTo(testCase.expectedIsNull)
    }

    @ParameterizedTest
    @EnumSource
    fun asKnown(testCase: TestCase) {
        val known = testCase.value.asKnown()

        assertThat(known).isEqualTo(testCase.expectedAsKnown)
    }

    @ParameterizedTest
    @EnumSource
    fun asBoolean(testCase: TestCase) {
        val boolean = testCase.value.asBoolean()

        assertThat(boolean).isEqualTo(testCase.expectedAsBoolean)
    }

    @ParameterizedTest
    @EnumSource
    fun asNumber(testCase: TestCase) {
        val number = testCase.value.asNumber()

        assertThat(number).isEqualTo(testCase.expectedAsNumber)
    }

    @ParameterizedTest
    @EnumSource
    fun asString(testCase: TestCase) {
        val string = testCase.value.asString()

        assertThat(string).isEqualTo(testCase.expectedAsString)
    }

    @ParameterizedTest
    @EnumSource
    fun asArray(testCase: TestCase) {
        val array = testCase.value.asArray()

        assertThat(array).isEqualTo(testCase.expectedAsArray)
    }

    @ParameterizedTest
    @EnumSource
    fun asObject(testCase: TestCase) {
        val obj = testCase.value.asObject()

        assertThat(obj).isEqualTo(testCase.expectedAsObject)
    }

    @Test
    fun fieldAccessMappingAndVisitors() {
        val known: JsonField<String> = JsonField.of("known")
        val missing: JsonField<String> = JsonMissing.of()
        val nullValue: JsonField<String> = JsonNull.of()
        val unknown: JsonField<String> = JsonString.of("unknown")

        assertThat(known.asUnknown()).isEmpty()
        assertThat(unknown.asUnknown()).contains(JsonString.of("unknown"))
        assertThat(known.asStringOrThrow()).isEqualTo("known")
        assertThatThrownBy { JsonNumber.of(42).asStringOrThrow() }
            .isInstanceOf(XTwitterScraperInvalidDataException::class.java)
            .hasMessage("Value is not a string")

        assertThat(known.getRequired("field")).isEqualTo("known")
        assertThatThrownBy { missing.getRequired("field") }
            .isInstanceOf(XTwitterScraperInvalidDataException::class.java)
            .hasMessage("`field` is not set")
        assertThatThrownBy { nullValue.getRequired("field") }
            .isInstanceOf(XTwitterScraperInvalidDataException::class.java)
            .hasMessage("`field` is null")
        assertThatThrownBy { unknown.getRequired("field") }
            .isInstanceOf(XTwitterScraperInvalidDataException::class.java)
            .hasMessageContaining("`field` is invalid")

        assertThat(known.getOptional("field")).contains("known")
        assertThat(missing.getOptional("field")).isEmpty()
        assertThat(nullValue.getOptional("field")).isEmpty()
        assertThatThrownBy { unknown.getOptional("field") }
            .isInstanceOf(XTwitterScraperInvalidDataException::class.java)
            .hasMessageContaining("`field` is invalid")

        assertThat(known.map(String::length)).isEqualTo(JsonField.of(5))
        assertThat(unknown.map(String::length)).isSameAs(unknown)

        var consumed: String? = null
        known.accept { consumed = it }
        unknown.accept { consumed = "unexpected" }
        assertThat(consumed).isEqualTo("known")

        val visitor =
            object : JsonField.Visitor<String, String> {
                override fun visitKnown(value: String): String = "known:$value"

                override fun visitString(value: String): String = "unknown:$value"
            }
        assertThat(known.accept(visitor)).isEqualTo("known:known")
        assertThat(unknown.accept(visitor)).isEqualTo("unknown:unknown")

        val defaultVisitor = object : JsonField.Visitor<String, String> {}
        assertThatThrownBy { known.accept(defaultVisitor) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Unexpected value")

        assertThat(JsonField.ofNullable("value")).isEqualTo(JsonField.of("value"))
        assertThat(JsonField.ofNullable<String>(null)).isSameAs(JsonNull.of())
        assertThat(JsonField.IsMissing()).isEqualTo(JsonMissing.of())
        assertThat(JsonField.IsMissing()).isNotEqualTo(JsonNull.of())
        assertThat(JsonField.IsMissing().hashCode()).isEqualTo(JsonField.IsMissing().hashCode())
    }

    @Test
    fun jsonValueConversionsNodesAndVisitors() {
        val values =
            listOf(
                JsonMissing.of() to "missing",
                JsonNull.of() to "null",
                JsonBoolean.of(true) to "boolean:true",
                JsonNumber.of(42) to "number:42",
                JsonString.of("value") to "string:value",
                JsonArray.of(listOf(JsonString.of("value"))) to "array:1",
                JsonObject.of(mapOf("key" to JsonString.of("value"))) to "object:1",
            )
        val visitor =
            object : JsonValue.Visitor<String> {
                override fun visitMissing(): String = "missing"

                override fun visitNull(): String = "null"

                override fun visitBoolean(value: Boolean): String = "boolean:$value"

                override fun visitNumber(value: Number): String = "number:$value"

                override fun visitString(value: String): String = "string:$value"

                override fun visitArray(values: List<JsonValue>): String = "array:${values.size}"

                override fun visitObject(values: Map<String, JsonValue>): String =
                    "object:${values.size}"
            }

        values.forEach { (value, expected) ->
            assertThat(value.accept(visitor)).isEqualTo(expected)
        }

        val defaultVisitor = object : JsonValue.Visitor<String> {}
        values.forEach { (value) ->
            assertThatThrownBy { value.accept(defaultVisitor) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Unexpected value")
        }

        assertThat(JsonString.of("value").convert(String::class.java)).isEqualTo("value")
        assertThat(
                JsonObject.of(mapOf("key" to JsonString.of("value")))
                    .convert(object : TypeReference<Map<String, String>>() {})
            )
            .containsEntry("key", "value")

        val nodes = JsonNodeFactory.instance
        assertThat(JsonValue.fromJsonNode(nodes.missingNode())).isSameAs(JsonMissing.of())
        assertThat(JsonValue.fromJsonNode(nodes.nullNode())).isSameAs(JsonNull.of())
        assertThat(JsonValue.fromJsonNode(nodes.booleanNode(true))).isEqualTo(JsonBoolean.of(true))
        assertThat(JsonValue.fromJsonNode(nodes.numberNode(42))).isEqualTo(JsonNumber.of(42))
        assertThat(JsonValue.fromJsonNode(nodes.textNode("value")))
            .isEqualTo(JsonString.of("value"))
        assertThat(JsonValue.fromJsonNode(nodes.arrayNode().add(1)))
            .isEqualTo(JsonArray.of(listOf(JsonNumber.of(1))))
        assertThat(JsonValue.fromJsonNode(nodes.objectNode().put("key", "value")))
            .isEqualTo(JsonObject.of(mapOf("key" to JsonString.of("value"))))
        assertThatThrownBy { JsonValue.fromJsonNode(nodes.binaryNode(byteArrayOf(1))) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("Unexpected JsonNode type")
        assertThatThrownBy { JsonValue.fromJsonNode(nodes.pojoNode(Any())) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("Unexpected JsonNode type")

        assertThat(JsonValue.from(null)).isSameAs(JsonNull.of())
        val existing = JsonString.of("existing")
        assertThat(JsonValue.from(existing)).isSameAs(existing)
        assertThat(JsonValue.Deserializer().getNullValue(null)).isSameAs(JsonNull.of())
    }

    @Test
    fun valueSemanticsAndMissingSerialization() {
        val known = KnownValue.of(byteArrayOf(1, 2))
        assertThat(known).isEqualTo(known)
        assertThat(known).isEqualTo(KnownValue.of(byteArrayOf(1, 2)))
        assertThat(known).isNotEqualTo(KnownValue.of(byteArrayOf(2, 1)))
        assertThat(known).isNotEqualTo(JsonString.of("value"))
        assertThat(known.hashCode()).isEqualTo(KnownValue.of(byteArrayOf(1, 2)).hashCode())
        assertThat(known.toString()).contains("1", "2")

        val scalarValues =
            listOf<JsonValue>(JsonBoolean.of(true), JsonNumber.of(42), JsonString.of("value"))
        scalarValues.forEach { value ->
            assertThat(value).isEqualTo(value)
            assertThat(value.hashCode()).isEqualTo(value.hashCode())
            assertThat(value.toString()).isNotEmpty()
        }
        assertThat(JsonBoolean.of(true)).isNotEqualTo(JsonBoolean.of(false))
        assertThat(JsonBoolean.of(true)).isNotEqualTo(JsonNumber.of(1))
        assertThat(JsonNumber.of(42)).isNotEqualTo(JsonNumber.of(43))
        assertThat(JsonNumber.of(42)).isNotEqualTo(JsonString.of("42"))
        assertThat(JsonString.of("value")).isNotEqualTo(JsonString.of("other"))
        assertThat(JsonString.of("value")).isNotEqualTo(JsonNumber.of(1))

        val mutableArray = mutableListOf<JsonValue>(JsonNumber.of(1))
        val array = JsonArray.of(mutableArray)
        mutableArray.add(JsonNumber.of(2))
        assertThat(array.values).containsExactly(JsonNumber.of(1))
        assertThat(array).isEqualTo(array)
        assertThat(array).isEqualTo(JsonArray.of(listOf(JsonNumber.of(1))))
        assertThat(array).isNotEqualTo(JsonArray.of(emptyList()))
        assertThat(array).isNotEqualTo(JsonObject.of(emptyMap()))
        assertThat(array.hashCode()).isEqualTo(array.values.hashCode())
        assertThat(array.toString()).isEqualTo("[1]")

        val mutableObject = mutableMapOf<String, JsonValue>("key" to JsonNumber.of(1))
        val obj = JsonObject.of(mutableObject)
        mutableObject["other"] = JsonNumber.of(2)
        assertThat(obj.values).containsOnlyKeys("key")
        assertThat(obj).isEqualTo(obj)
        assertThat(obj).isEqualTo(JsonObject.of(mapOf("key" to JsonNumber.of(1))))
        assertThat(obj).isNotEqualTo(JsonObject.of(emptyMap()))
        assertThat(obj).isNotEqualTo(JsonArray.of(emptyList()))
        assertThat(obj.hashCode()).isEqualTo(obj.values.hashCode())
        assertThat(obj.toString()).contains("key=1")
        assertThat(JsonMissing.of().toString()).isEmpty()
        assertThat(JsonNull.of().toString()).isEqualTo("null")

        val output = ByteArrayOutputStream()
        JsonFactory().createGenerator(output).use { generator ->
            assertThatThrownBy {
                    JsonMissing.Serializer()
                        .serialize(JsonMissing.of(), generator, jsonMapper().serializerProvider)
                }
                .isInstanceOf(IllegalStateException::class.java)
                .hasMessage("JsonMissing cannot be serialized")
        }
    }

    @Test
    fun multipartFields() {
        val text = MultipartField.of("value")
        val bytes = MultipartField.of(byteArrayOf(1, 2))
        val stream = MultipartField.of(ByteArrayInputStream(byteArrayOf(1, 2)))
        val custom =
            MultipartField.builder<String>()
                .value("value")
                .contentType("application/custom")
                .filename(Optional.of("value.txt"))
                .build()
        val noFilename =
            MultipartField.builder<String>()
                .value(JsonField.of("value"))
                .filename(Optional.empty())
                .build()

        assertThat(text.contentType).isEqualTo("text/plain; charset=utf-8")
        assertThat(bytes.contentType).isEqualTo("application/octet-stream")
        assertThat(stream.contentType).isEqualTo("application/octet-stream")
        assertThat(custom.filename()).contains("value.txt")
        assertThat(noFilename.filename()).isEmpty()
        assertThat(custom.map(String::length).value.asKnown()).contains(5)
        assertThat(custom).isEqualTo(custom)
        assertThat(custom)
            .isEqualTo(
                MultipartField.builder<String>()
                    .value("value")
                    .contentType("application/custom")
                    .filename("value.txt")
                    .build()
            )
        assertThat(custom).isNotEqualTo(text)
        assertThat(custom).isNotEqualTo("value")
        assertThat(custom.hashCode()).isEqualTo(custom.hashCode())
        assertThat(custom.toString()).contains("application/custom", "value.txt")
        assertThatThrownBy { MultipartField.builder<String>().build() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("`value` is required, but was not set")
    }
}
