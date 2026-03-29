// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.bot

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects

/** Track bot token usage */
class BotTrackUsageParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun inputTokens(): Long = body.inputTokens()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputTokens(): Long = body.outputTokens()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun platformUserId(): String = body.platformUserId()

    /**
     * Returns the raw JSON value of [inputTokens].
     *
     * Unlike [inputTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _inputTokens(): JsonField<Long> = body._inputTokens()

    /**
     * Returns the raw JSON value of [outputTokens].
     *
     * Unlike [outputTokens], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _outputTokens(): JsonField<Long> = body._outputTokens()

    /**
     * Returns the raw JSON value of [platformUserId].
     *
     * Unlike [platformUserId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _platformUserId(): JsonField<String> = body._platformUserId()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BotTrackUsageParams].
         *
         * The following fields are required:
         * ```java
         * .inputTokens()
         * .outputTokens()
         * .platformUserId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BotTrackUsageParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(botTrackUsageParams: BotTrackUsageParams) = apply {
            body = botTrackUsageParams.body.toBuilder()
            additionalHeaders = botTrackUsageParams.additionalHeaders.toBuilder()
            additionalQueryParams = botTrackUsageParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [inputTokens]
         * - [outputTokens]
         * - [platformUserId]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        fun inputTokens(inputTokens: Long) = apply { body.inputTokens(inputTokens) }

        /**
         * Sets [Builder.inputTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun inputTokens(inputTokens: JsonField<Long>) = apply { body.inputTokens(inputTokens) }

        fun outputTokens(outputTokens: Long) = apply { body.outputTokens(outputTokens) }

        /**
         * Sets [Builder.outputTokens] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputTokens] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun outputTokens(outputTokens: JsonField<Long>) = apply { body.outputTokens(outputTokens) }

        fun platformUserId(platformUserId: String) = apply { body.platformUserId(platformUserId) }

        /**
         * Sets [Builder.platformUserId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.platformUserId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun platformUserId(platformUserId: JsonField<String>) = apply {
            body.platformUserId(platformUserId)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

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
         * Returns an immutable instance of [BotTrackUsageParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .inputTokens()
         * .outputTokens()
         * .platformUserId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BotTrackUsageParams =
            BotTrackUsageParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val inputTokens: JsonField<Long>,
        private val outputTokens: JsonField<Long>,
        private val platformUserId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("inputTokens")
            @ExcludeMissing
            inputTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("outputTokens")
            @ExcludeMissing
            outputTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("platformUserId")
            @ExcludeMissing
            platformUserId: JsonField<String> = JsonMissing.of(),
        ) : this(inputTokens, outputTokens, platformUserId, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun inputTokens(): Long = inputTokens.getRequired("inputTokens")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun outputTokens(): Long = outputTokens.getRequired("outputTokens")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun platformUserId(): String = platformUserId.getRequired("platformUserId")

        /**
         * Returns the raw JSON value of [inputTokens].
         *
         * Unlike [inputTokens], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("inputTokens")
        @ExcludeMissing
        fun _inputTokens(): JsonField<Long> = inputTokens

        /**
         * Returns the raw JSON value of [outputTokens].
         *
         * Unlike [outputTokens], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("outputTokens")
        @ExcludeMissing
        fun _outputTokens(): JsonField<Long> = outputTokens

        /**
         * Returns the raw JSON value of [platformUserId].
         *
         * Unlike [platformUserId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("platformUserId")
        @ExcludeMissing
        fun _platformUserId(): JsonField<String> = platformUserId

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .inputTokens()
             * .outputTokens()
             * .platformUserId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var inputTokens: JsonField<Long>? = null
            private var outputTokens: JsonField<Long>? = null
            private var platformUserId: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                inputTokens = body.inputTokens
                outputTokens = body.outputTokens
                platformUserId = body.platformUserId
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            fun inputTokens(inputTokens: Long) = inputTokens(JsonField.of(inputTokens))

            /**
             * Sets [Builder.inputTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputTokens] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun inputTokens(inputTokens: JsonField<Long>) = apply { this.inputTokens = inputTokens }

            fun outputTokens(outputTokens: Long) = outputTokens(JsonField.of(outputTokens))

            /**
             * Sets [Builder.outputTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputTokens] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputTokens(outputTokens: JsonField<Long>) = apply {
                this.outputTokens = outputTokens
            }

            fun platformUserId(platformUserId: String) =
                platformUserId(JsonField.of(platformUserId))

            /**
             * Sets [Builder.platformUserId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.platformUserId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun platformUserId(platformUserId: JsonField<String>) = apply {
                this.platformUserId = platformUserId
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .inputTokens()
             * .outputTokens()
             * .platformUserId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("inputTokens", inputTokens),
                    checkRequired("outputTokens", outputTokens),
                    checkRequired("platformUserId", platformUserId),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            inputTokens()
            outputTokens()
            platformUserId()
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
        @JvmSynthetic
        internal fun validity(): Int =
            (if (inputTokens.asKnown().isPresent) 1 else 0) +
                (if (outputTokens.asKnown().isPresent) 1 else 0) +
                (if (platformUserId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                inputTokens == other.inputTokens &&
                outputTokens == other.outputTokens &&
                platformUserId == other.platformUserId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(inputTokens, outputTokens, platformUserId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{inputTokens=$inputTokens, outputTokens=$outputTokens, platformUserId=$platformUserId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BotTrackUsageParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "BotTrackUsageParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
