// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.media

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Download images and videos from tweets */
class MediaDownloadParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Numeric tweet ID alias for tweetInput
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun tweetId(): Optional<String> = body.tweetId()

    /**
     * Array of tweet URLs or IDs (bulk, max 50 string items)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun tweetIds(): Optional<List<String>> = body.tweetIds()

    /**
     * Tweet URL or ID (single tweet)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun tweetInput(): Optional<String> = body.tweetInput()

    /**
     * Tweet URL alias for tweetInput
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun tweetUrl(): Optional<String> = body.tweetUrl()

    /**
     * Returns the raw JSON value of [tweetId].
     *
     * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tweetId(): JsonField<String> = body._tweetId()

    /**
     * Returns the raw JSON value of [tweetIds].
     *
     * Unlike [tweetIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tweetIds(): JsonField<List<String>> = body._tweetIds()

    /**
     * Returns the raw JSON value of [tweetInput].
     *
     * Unlike [tweetInput], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tweetInput(): JsonField<String> = body._tweetInput()

    /**
     * Returns the raw JSON value of [tweetUrl].
     *
     * Unlike [tweetUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tweetUrl(): JsonField<String> = body._tweetUrl()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): MediaDownloadParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [MediaDownloadParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MediaDownloadParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(mediaDownloadParams: MediaDownloadParams) = apply {
            body = mediaDownloadParams.body.toBuilder()
            additionalHeaders = mediaDownloadParams.additionalHeaders.toBuilder()
            additionalQueryParams = mediaDownloadParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [tweetId]
         * - [tweetIds]
         * - [tweetInput]
         * - [tweetUrl]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Numeric tweet ID alias for tweetInput */
        fun tweetId(tweetId: String) = apply { body.tweetId(tweetId) }

        /**
         * Sets [Builder.tweetId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tweetId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tweetId(tweetId: JsonField<String>) = apply { body.tweetId(tweetId) }

        /** Array of tweet URLs or IDs (bulk, max 50 string items) */
        fun tweetIds(tweetIds: List<String>) = apply { body.tweetIds(tweetIds) }

        /**
         * Sets [Builder.tweetIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tweetIds] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun tweetIds(tweetIds: JsonField<List<String>>) = apply { body.tweetIds(tweetIds) }

        /**
         * Adds a single [String] to [tweetIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTweetId(tweetId: String) = apply { body.addTweetId(tweetId) }

        /** Tweet URL or ID (single tweet) */
        fun tweetInput(tweetInput: String) = apply { body.tweetInput(tweetInput) }

        /**
         * Sets [Builder.tweetInput] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tweetInput] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tweetInput(tweetInput: JsonField<String>) = apply { body.tweetInput(tweetInput) }

        /** Tweet URL alias for tweetInput */
        fun tweetUrl(tweetUrl: String) = apply { body.tweetUrl(tweetUrl) }

        /**
         * Sets [Builder.tweetUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tweetUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tweetUrl(tweetUrl: JsonField<String>) = apply { body.tweetUrl(tweetUrl) }

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
         * Returns an immutable instance of [MediaDownloadParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MediaDownloadParams =
            MediaDownloadParams(
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
        private val tweetId: JsonField<String>,
        private val tweetIds: JsonField<List<String>>,
        private val tweetInput: JsonField<String>,
        private val tweetUrl: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tweetIds")
            @ExcludeMissing
            tweetIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("tweetInput")
            @ExcludeMissing
            tweetInput: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tweetUrl")
            @ExcludeMissing
            tweetUrl: JsonField<String> = JsonMissing.of(),
        ) : this(tweetId, tweetIds, tweetInput, tweetUrl, mutableMapOf())

        /**
         * Numeric tweet ID alias for tweetInput
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun tweetId(): Optional<String> = tweetId.getOptional("tweetId")

        /**
         * Array of tweet URLs or IDs (bulk, max 50 string items)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun tweetIds(): Optional<List<String>> = tweetIds.getOptional("tweetIds")

        /**
         * Tweet URL or ID (single tweet)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun tweetInput(): Optional<String> = tweetInput.getOptional("tweetInput")

        /**
         * Tweet URL alias for tweetInput
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun tweetUrl(): Optional<String> = tweetUrl.getOptional("tweetUrl")

        /**
         * Returns the raw JSON value of [tweetId].
         *
         * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

        /**
         * Returns the raw JSON value of [tweetIds].
         *
         * Unlike [tweetIds], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweetIds")
        @ExcludeMissing
        fun _tweetIds(): JsonField<List<String>> = tweetIds

        /**
         * Returns the raw JSON value of [tweetInput].
         *
         * Unlike [tweetInput], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweetInput")
        @ExcludeMissing
        fun _tweetInput(): JsonField<String> = tweetInput

        /**
         * Returns the raw JSON value of [tweetUrl].
         *
         * Unlike [tweetUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweetUrl") @ExcludeMissing fun _tweetUrl(): JsonField<String> = tweetUrl

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var tweetId: JsonField<String> = JsonMissing.of()
            private var tweetIds: JsonField<MutableList<String>>? = null
            private var tweetInput: JsonField<String> = JsonMissing.of()
            private var tweetUrl: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                tweetId = body.tweetId
                tweetIds = body.tweetIds.map { it.toMutableList() }
                tweetInput = body.tweetInput
                tweetUrl = body.tweetUrl
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Numeric tweet ID alias for tweetInput */
            fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

            /**
             * Sets [Builder.tweetId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tweetId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

            /** Array of tweet URLs or IDs (bulk, max 50 string items) */
            fun tweetIds(tweetIds: List<String>) = tweetIds(JsonField.of(tweetIds))

            /**
             * Sets [Builder.tweetIds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tweetIds] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tweetIds(tweetIds: JsonField<List<String>>) = apply {
                this.tweetIds = tweetIds.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [tweetIds].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTweetId(tweetId: String) = apply {
                tweetIds =
                    (tweetIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tweetIds", it).add(tweetId)
                    }
            }

            /** Tweet URL or ID (single tweet) */
            fun tweetInput(tweetInput: String) = tweetInput(JsonField.of(tweetInput))

            /**
             * Sets [Builder.tweetInput] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tweetInput] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tweetInput(tweetInput: JsonField<String>) = apply { this.tweetInput = tweetInput }

            /** Tweet URL alias for tweetInput */
            fun tweetUrl(tweetUrl: String) = tweetUrl(JsonField.of(tweetUrl))

            /**
             * Sets [Builder.tweetUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tweetUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tweetUrl(tweetUrl: JsonField<String>) = apply { this.tweetUrl = tweetUrl }

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
             */
            fun build(): Body =
                Body(
                    tweetId,
                    (tweetIds ?: JsonMissing.of()).map { it.toImmutable() },
                    tweetInput,
                    tweetUrl,
                    additionalProperties.toMutableMap(),
                )
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
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            tweetId()
            tweetIds()
            tweetInput()
            tweetUrl()
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
            (if (tweetId.asKnown().isPresent) 1 else 0) +
                (tweetIds.asKnown().getOrNull()?.size ?: 0) +
                (if (tweetInput.asKnown().isPresent) 1 else 0) +
                (if (tweetUrl.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                tweetId == other.tweetId &&
                tweetIds == other.tweetIds &&
                tweetInput == other.tweetInput &&
                tweetUrl == other.tweetUrl &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(tweetId, tweetIds, tweetInput, tweetUrl, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{tweetId=$tweetId, tweetIds=$tweetIds, tweetInput=$tweetInput, tweetUrl=$tweetUrl, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MediaDownloadParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "MediaDownloadParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
