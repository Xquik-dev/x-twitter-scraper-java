// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

import com.fasterxml.jackson.annotation.JsonCreator
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Get extraction results */
class ExtractionRetrieveParams
private constructor(
    private val id: String?,
    private val cursor: String?,
    private val fieldStyle: FieldStyle?,
    private val includeRaw: Boolean?,
    private val limit: Long?,
    private val outputMode: OutputMode?,
    private val outputPreset: OutputPreset?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun id(): Optional<String> = Optional.ofNullable(id)

    /** Previous nextCursor. */
    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    /** Preserve source keys or convert result field names. */
    fun fieldStyle(): Optional<FieldStyle> = Optional.ofNullable(fieldStyle)

    /** Use outputMode=raw instead. */
    fun includeRaw(): Optional<Boolean> = Optional.ofNullable(includeRaw)

    /** Maximum number of results to return (1-1000, default 100) */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /** Select compact, full, or raw-compatible result fields. */
    fun outputMode(): Optional<OutputMode> = Optional.ofNullable(outputMode)

    /** Keep enrichment nested or merge it into each result. */
    fun outputPreset(): Optional<OutputPreset> = Optional.ofNullable(outputPreset)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ExtractionRetrieveParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ExtractionRetrieveParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExtractionRetrieveParams]. */
    class Builder internal constructor() {

        private var id: String? = null
        private var cursor: String? = null
        private var fieldStyle: FieldStyle? = null
        private var includeRaw: Boolean? = null
        private var limit: Long? = null
        private var outputMode: OutputMode? = null
        private var outputPreset: OutputPreset? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(extractionRetrieveParams: ExtractionRetrieveParams) = apply {
            id = extractionRetrieveParams.id
            cursor = extractionRetrieveParams.cursor
            fieldStyle = extractionRetrieveParams.fieldStyle
            includeRaw = extractionRetrieveParams.includeRaw
            limit = extractionRetrieveParams.limit
            outputMode = extractionRetrieveParams.outputMode
            outputPreset = extractionRetrieveParams.outputPreset
            additionalHeaders = extractionRetrieveParams.additionalHeaders.toBuilder()
            additionalQueryParams = extractionRetrieveParams.additionalQueryParams.toBuilder()
        }

        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /** Previous nextCursor. */
        fun cursor(cursor: String?) = apply { this.cursor = cursor }

        /** Alias for calling [Builder.cursor] with `cursor.orElse(null)`. */
        fun cursor(cursor: Optional<String>) = cursor(cursor.getOrNull())

        /** Preserve source keys or convert result field names. */
        fun fieldStyle(fieldStyle: FieldStyle?) = apply { this.fieldStyle = fieldStyle }

        /** Alias for calling [Builder.fieldStyle] with `fieldStyle.orElse(null)`. */
        fun fieldStyle(fieldStyle: Optional<FieldStyle>) = fieldStyle(fieldStyle.getOrNull())

        /** Use outputMode=raw instead. */
        fun includeRaw(includeRaw: Boolean?) = apply { this.includeRaw = includeRaw }

        /**
         * Alias for [Builder.includeRaw].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun includeRaw(includeRaw: Boolean) = includeRaw(includeRaw as Boolean?)

        /** Alias for calling [Builder.includeRaw] with `includeRaw.orElse(null)`. */
        fun includeRaw(includeRaw: Optional<Boolean>) = includeRaw(includeRaw.getOrNull())

        /** Maximum number of results to return (1-1000, default 100) */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        /** Select compact, full, or raw-compatible result fields. */
        fun outputMode(outputMode: OutputMode?) = apply { this.outputMode = outputMode }

        /** Alias for calling [Builder.outputMode] with `outputMode.orElse(null)`. */
        fun outputMode(outputMode: Optional<OutputMode>) = outputMode(outputMode.getOrNull())

        /** Keep enrichment nested or merge it into each result. */
        fun outputPreset(outputPreset: OutputPreset?) = apply { this.outputPreset = outputPreset }

        /** Alias for calling [Builder.outputPreset] with `outputPreset.orElse(null)`. */
        fun outputPreset(outputPreset: Optional<OutputPreset>) =
            outputPreset(outputPreset.getOrNull())

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [ExtractionRetrieveParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ExtractionRetrieveParams =
            ExtractionRetrieveParams(
                id,
                cursor,
                fieldStyle,
                includeRaw,
                limit,
                outputMode,
                outputPreset,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> id ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                cursor?.let { put("cursor", it) }
                fieldStyle?.let { put("fieldStyle", it.toString()) }
                includeRaw?.let { put("includeRaw", it.toString()) }
                limit?.let { put("limit", it.toString()) }
                outputMode?.let { put("outputMode", it.toString()) }
                outputPreset?.let { put("outputPreset", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    /** Preserve source keys or convert result field names. */
    class FieldStyle @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val SOURCE = of("source")

            @JvmField val CAMEL_CASE = of("camelCase")

            @JvmField val SNAKE_CASE = of("snake_case")

            @JvmStatic fun of(value: String) = FieldStyle(JsonField.of(value))
        }

        /** An enum containing [FieldStyle]'s known values. */
        enum class Known {
            SOURCE,
            CAMEL_CASE,
            SNAKE_CASE,
        }

        /**
         * An enum containing [FieldStyle]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [FieldStyle] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SOURCE,
            CAMEL_CASE,
            SNAKE_CASE,
            /**
             * An enum member indicating that [FieldStyle] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                SOURCE -> Value.SOURCE
                CAMEL_CASE -> Value.CAMEL_CASE
                SNAKE_CASE -> Value.SNAKE_CASE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                SOURCE -> Known.SOURCE
                CAMEL_CASE -> Known.CAMEL_CASE
                SNAKE_CASE -> Known.SNAKE_CASE
                else -> throw XTwitterScraperInvalidDataException("Unknown FieldStyle: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): FieldStyle = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FieldStyle && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Select compact, full, or raw-compatible result fields. */
    class OutputMode @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val COMPACT = of("compact")

            @JvmField val FULL = of("full")

            @JvmField val RAW = of("raw")

            @JvmStatic fun of(value: String) = OutputMode(JsonField.of(value))
        }

        /** An enum containing [OutputMode]'s known values. */
        enum class Known {
            COMPACT,
            FULL,
            RAW,
        }

        /**
         * An enum containing [OutputMode]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [OutputMode] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            COMPACT,
            FULL,
            RAW,
            /**
             * An enum member indicating that [OutputMode] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                COMPACT -> Value.COMPACT
                FULL -> Value.FULL
                RAW -> Value.RAW
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                COMPACT -> Known.COMPACT
                FULL -> Known.FULL
                RAW -> Known.RAW
                else -> throw XTwitterScraperInvalidDataException("Unknown OutputMode: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): OutputMode = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OutputMode && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Keep enrichment nested or merge it into each result. */
    class OutputPreset @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val NESTED = of("nested")

            @JvmField val FLAT = of("flat")

            @JvmStatic fun of(value: String) = OutputPreset(JsonField.of(value))
        }

        /** An enum containing [OutputPreset]'s known values. */
        enum class Known {
            NESTED,
            FLAT,
        }

        /**
         * An enum containing [OutputPreset]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [OutputPreset] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            NESTED,
            FLAT,
            /**
             * An enum member indicating that [OutputPreset] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                NESTED -> Value.NESTED
                FLAT -> Value.FLAT
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                NESTED -> Known.NESTED
                FLAT -> Known.FLAT
                else -> throw XTwitterScraperInvalidDataException("Unknown OutputPreset: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): OutputPreset = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OutputPreset && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExtractionRetrieveParams &&
            id == other.id &&
            cursor == other.cursor &&
            fieldStyle == other.fieldStyle &&
            includeRaw == other.includeRaw &&
            limit == other.limit &&
            outputMode == other.outputMode &&
            outputPreset == other.outputPreset &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            id,
            cursor,
            fieldStyle,
            includeRaw,
            limit,
            outputMode,
            outputPreset,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "ExtractionRetrieveParams{id=$id, cursor=$cursor, fieldStyle=$fieldStyle, includeRaw=$includeRaw, limit=$limit, outputMode=$outputMode, outputPreset=$outputPreset, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
