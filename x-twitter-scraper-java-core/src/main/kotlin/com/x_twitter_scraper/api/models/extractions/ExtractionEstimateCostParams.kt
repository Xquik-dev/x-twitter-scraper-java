// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.Enum
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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Estimate extraction cost */
class ExtractionEstimateCostParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Identifier for the extraction tool used to run a job.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun toolType(): ToolType = body.toolType()

    /**
     * Raw advanced query string appended to the estimate (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun advancedQuery(): Optional<String> = body.advancedQuery()

    /**
     * Exact phrase filter for search estimation
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun exactPhrase(): Optional<String> = body.exactPhrase()

    /**
     * Words excluded from estimated search results
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun excludeWords(): Optional<String> = body.excludeWords()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun searchQuery(): Optional<String> = body.searchQuery()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetCommunityId(): Optional<String> = body.targetCommunityId()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetListId(): Optional<String> = body.targetListId()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetSpaceId(): Optional<String> = body.targetSpaceId()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetTweetId(): Optional<String> = body.targetTweetId()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetUsername(): Optional<String> = body.targetUsername()

    /**
     * Returns the raw JSON value of [toolType].
     *
     * Unlike [toolType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _toolType(): JsonField<ToolType> = body._toolType()

    /**
     * Returns the raw JSON value of [advancedQuery].
     *
     * Unlike [advancedQuery], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _advancedQuery(): JsonField<String> = body._advancedQuery()

    /**
     * Returns the raw JSON value of [exactPhrase].
     *
     * Unlike [exactPhrase], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _exactPhrase(): JsonField<String> = body._exactPhrase()

    /**
     * Returns the raw JSON value of [excludeWords].
     *
     * Unlike [excludeWords], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _excludeWords(): JsonField<String> = body._excludeWords()

    /**
     * Returns the raw JSON value of [searchQuery].
     *
     * Unlike [searchQuery], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _searchQuery(): JsonField<String> = body._searchQuery()

    /**
     * Returns the raw JSON value of [targetCommunityId].
     *
     * Unlike [targetCommunityId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _targetCommunityId(): JsonField<String> = body._targetCommunityId()

    /**
     * Returns the raw JSON value of [targetListId].
     *
     * Unlike [targetListId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _targetListId(): JsonField<String> = body._targetListId()

    /**
     * Returns the raw JSON value of [targetSpaceId].
     *
     * Unlike [targetSpaceId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _targetSpaceId(): JsonField<String> = body._targetSpaceId()

    /**
     * Returns the raw JSON value of [targetTweetId].
     *
     * Unlike [targetTweetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _targetTweetId(): JsonField<String> = body._targetTweetId()

    /**
     * Returns the raw JSON value of [targetUsername].
     *
     * Unlike [targetUsername], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _targetUsername(): JsonField<String> = body._targetUsername()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ExtractionEstimateCostParams].
         *
         * The following fields are required:
         * ```java
         * .toolType()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExtractionEstimateCostParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(extractionEstimateCostParams: ExtractionEstimateCostParams) = apply {
            body = extractionEstimateCostParams.body.toBuilder()
            additionalHeaders = extractionEstimateCostParams.additionalHeaders.toBuilder()
            additionalQueryParams = extractionEstimateCostParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [toolType]
         * - [advancedQuery]
         * - [exactPhrase]
         * - [excludeWords]
         * - [searchQuery]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Identifier for the extraction tool used to run a job. */
        fun toolType(toolType: ToolType) = apply { body.toolType(toolType) }

        /**
         * Sets [Builder.toolType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolType] with a well-typed [ToolType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun toolType(toolType: JsonField<ToolType>) = apply { body.toolType(toolType) }

        /** Raw advanced query string appended to the estimate (tweet_search_extractor) */
        fun advancedQuery(advancedQuery: String) = apply { body.advancedQuery(advancedQuery) }

        /**
         * Sets [Builder.advancedQuery] to an arbitrary JSON value.
         *
         * You should usually call [Builder.advancedQuery] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun advancedQuery(advancedQuery: JsonField<String>) = apply {
            body.advancedQuery(advancedQuery)
        }

        /** Exact phrase filter for search estimation */
        fun exactPhrase(exactPhrase: String) = apply { body.exactPhrase(exactPhrase) }

        /**
         * Sets [Builder.exactPhrase] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exactPhrase] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun exactPhrase(exactPhrase: JsonField<String>) = apply { body.exactPhrase(exactPhrase) }

        /** Words excluded from estimated search results */
        fun excludeWords(excludeWords: String) = apply { body.excludeWords(excludeWords) }

        /**
         * Sets [Builder.excludeWords] to an arbitrary JSON value.
         *
         * You should usually call [Builder.excludeWords] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun excludeWords(excludeWords: JsonField<String>) = apply {
            body.excludeWords(excludeWords)
        }

        fun searchQuery(searchQuery: String) = apply { body.searchQuery(searchQuery) }

        /**
         * Sets [Builder.searchQuery] to an arbitrary JSON value.
         *
         * You should usually call [Builder.searchQuery] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun searchQuery(searchQuery: JsonField<String>) = apply { body.searchQuery(searchQuery) }

        fun targetCommunityId(targetCommunityId: String) = apply {
            body.targetCommunityId(targetCommunityId)
        }

        /**
         * Sets [Builder.targetCommunityId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targetCommunityId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun targetCommunityId(targetCommunityId: JsonField<String>) = apply {
            body.targetCommunityId(targetCommunityId)
        }

        fun targetListId(targetListId: String) = apply { body.targetListId(targetListId) }

        /**
         * Sets [Builder.targetListId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targetListId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun targetListId(targetListId: JsonField<String>) = apply {
            body.targetListId(targetListId)
        }

        fun targetSpaceId(targetSpaceId: String) = apply { body.targetSpaceId(targetSpaceId) }

        /**
         * Sets [Builder.targetSpaceId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targetSpaceId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun targetSpaceId(targetSpaceId: JsonField<String>) = apply {
            body.targetSpaceId(targetSpaceId)
        }

        fun targetTweetId(targetTweetId: String) = apply { body.targetTweetId(targetTweetId) }

        /**
         * Sets [Builder.targetTweetId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targetTweetId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun targetTweetId(targetTweetId: JsonField<String>) = apply {
            body.targetTweetId(targetTweetId)
        }

        fun targetUsername(targetUsername: String) = apply { body.targetUsername(targetUsername) }

        /**
         * Sets [Builder.targetUsername] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targetUsername] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun targetUsername(targetUsername: JsonField<String>) = apply {
            body.targetUsername(targetUsername)
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
         * Returns an immutable instance of [ExtractionEstimateCostParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .toolType()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ExtractionEstimateCostParams =
            ExtractionEstimateCostParams(
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
        private val toolType: JsonField<ToolType>,
        private val advancedQuery: JsonField<String>,
        private val exactPhrase: JsonField<String>,
        private val excludeWords: JsonField<String>,
        private val searchQuery: JsonField<String>,
        private val targetCommunityId: JsonField<String>,
        private val targetListId: JsonField<String>,
        private val targetSpaceId: JsonField<String>,
        private val targetTweetId: JsonField<String>,
        private val targetUsername: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("toolType")
            @ExcludeMissing
            toolType: JsonField<ToolType> = JsonMissing.of(),
            @JsonProperty("advancedQuery")
            @ExcludeMissing
            advancedQuery: JsonField<String> = JsonMissing.of(),
            @JsonProperty("exactPhrase")
            @ExcludeMissing
            exactPhrase: JsonField<String> = JsonMissing.of(),
            @JsonProperty("excludeWords")
            @ExcludeMissing
            excludeWords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("searchQuery")
            @ExcludeMissing
            searchQuery: JsonField<String> = JsonMissing.of(),
            @JsonProperty("targetCommunityId")
            @ExcludeMissing
            targetCommunityId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("targetListId")
            @ExcludeMissing
            targetListId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("targetSpaceId")
            @ExcludeMissing
            targetSpaceId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("targetTweetId")
            @ExcludeMissing
            targetTweetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("targetUsername")
            @ExcludeMissing
            targetUsername: JsonField<String> = JsonMissing.of(),
        ) : this(
            toolType,
            advancedQuery,
            exactPhrase,
            excludeWords,
            searchQuery,
            targetCommunityId,
            targetListId,
            targetSpaceId,
            targetTweetId,
            targetUsername,
            mutableMapOf(),
        )

        /**
         * Identifier for the extraction tool used to run a job.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun toolType(): ToolType = toolType.getRequired("toolType")

        /**
         * Raw advanced query string appended to the estimate (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun advancedQuery(): Optional<String> = advancedQuery.getOptional("advancedQuery")

        /**
         * Exact phrase filter for search estimation
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun exactPhrase(): Optional<String> = exactPhrase.getOptional("exactPhrase")

        /**
         * Words excluded from estimated search results
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun excludeWords(): Optional<String> = excludeWords.getOptional("excludeWords")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun searchQuery(): Optional<String> = searchQuery.getOptional("searchQuery")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targetCommunityId(): Optional<String> =
            targetCommunityId.getOptional("targetCommunityId")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targetListId(): Optional<String> = targetListId.getOptional("targetListId")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targetSpaceId(): Optional<String> = targetSpaceId.getOptional("targetSpaceId")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targetTweetId(): Optional<String> = targetTweetId.getOptional("targetTweetId")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targetUsername(): Optional<String> = targetUsername.getOptional("targetUsername")

        /**
         * Returns the raw JSON value of [toolType].
         *
         * Unlike [toolType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("toolType") @ExcludeMissing fun _toolType(): JsonField<ToolType> = toolType

        /**
         * Returns the raw JSON value of [advancedQuery].
         *
         * Unlike [advancedQuery], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("advancedQuery")
        @ExcludeMissing
        fun _advancedQuery(): JsonField<String> = advancedQuery

        /**
         * Returns the raw JSON value of [exactPhrase].
         *
         * Unlike [exactPhrase], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("exactPhrase")
        @ExcludeMissing
        fun _exactPhrase(): JsonField<String> = exactPhrase

        /**
         * Returns the raw JSON value of [excludeWords].
         *
         * Unlike [excludeWords], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("excludeWords")
        @ExcludeMissing
        fun _excludeWords(): JsonField<String> = excludeWords

        /**
         * Returns the raw JSON value of [searchQuery].
         *
         * Unlike [searchQuery], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("searchQuery")
        @ExcludeMissing
        fun _searchQuery(): JsonField<String> = searchQuery

        /**
         * Returns the raw JSON value of [targetCommunityId].
         *
         * Unlike [targetCommunityId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("targetCommunityId")
        @ExcludeMissing
        fun _targetCommunityId(): JsonField<String> = targetCommunityId

        /**
         * Returns the raw JSON value of [targetListId].
         *
         * Unlike [targetListId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("targetListId")
        @ExcludeMissing
        fun _targetListId(): JsonField<String> = targetListId

        /**
         * Returns the raw JSON value of [targetSpaceId].
         *
         * Unlike [targetSpaceId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("targetSpaceId")
        @ExcludeMissing
        fun _targetSpaceId(): JsonField<String> = targetSpaceId

        /**
         * Returns the raw JSON value of [targetTweetId].
         *
         * Unlike [targetTweetId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("targetTweetId")
        @ExcludeMissing
        fun _targetTweetId(): JsonField<String> = targetTweetId

        /**
         * Returns the raw JSON value of [targetUsername].
         *
         * Unlike [targetUsername], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("targetUsername")
        @ExcludeMissing
        fun _targetUsername(): JsonField<String> = targetUsername

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
             * .toolType()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var toolType: JsonField<ToolType>? = null
            private var advancedQuery: JsonField<String> = JsonMissing.of()
            private var exactPhrase: JsonField<String> = JsonMissing.of()
            private var excludeWords: JsonField<String> = JsonMissing.of()
            private var searchQuery: JsonField<String> = JsonMissing.of()
            private var targetCommunityId: JsonField<String> = JsonMissing.of()
            private var targetListId: JsonField<String> = JsonMissing.of()
            private var targetSpaceId: JsonField<String> = JsonMissing.of()
            private var targetTweetId: JsonField<String> = JsonMissing.of()
            private var targetUsername: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                toolType = body.toolType
                advancedQuery = body.advancedQuery
                exactPhrase = body.exactPhrase
                excludeWords = body.excludeWords
                searchQuery = body.searchQuery
                targetCommunityId = body.targetCommunityId
                targetListId = body.targetListId
                targetSpaceId = body.targetSpaceId
                targetTweetId = body.targetTweetId
                targetUsername = body.targetUsername
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Identifier for the extraction tool used to run a job. */
            fun toolType(toolType: ToolType) = toolType(JsonField.of(toolType))

            /**
             * Sets [Builder.toolType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toolType] with a well-typed [ToolType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun toolType(toolType: JsonField<ToolType>) = apply { this.toolType = toolType }

            /** Raw advanced query string appended to the estimate (tweet_search_extractor) */
            fun advancedQuery(advancedQuery: String) = advancedQuery(JsonField.of(advancedQuery))

            /**
             * Sets [Builder.advancedQuery] to an arbitrary JSON value.
             *
             * You should usually call [Builder.advancedQuery] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun advancedQuery(advancedQuery: JsonField<String>) = apply {
                this.advancedQuery = advancedQuery
            }

            /** Exact phrase filter for search estimation */
            fun exactPhrase(exactPhrase: String) = exactPhrase(JsonField.of(exactPhrase))

            /**
             * Sets [Builder.exactPhrase] to an arbitrary JSON value.
             *
             * You should usually call [Builder.exactPhrase] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun exactPhrase(exactPhrase: JsonField<String>) = apply {
                this.exactPhrase = exactPhrase
            }

            /** Words excluded from estimated search results */
            fun excludeWords(excludeWords: String) = excludeWords(JsonField.of(excludeWords))

            /**
             * Sets [Builder.excludeWords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.excludeWords] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun excludeWords(excludeWords: JsonField<String>) = apply {
                this.excludeWords = excludeWords
            }

            fun searchQuery(searchQuery: String) = searchQuery(JsonField.of(searchQuery))

            /**
             * Sets [Builder.searchQuery] to an arbitrary JSON value.
             *
             * You should usually call [Builder.searchQuery] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun searchQuery(searchQuery: JsonField<String>) = apply {
                this.searchQuery = searchQuery
            }

            fun targetCommunityId(targetCommunityId: String) =
                targetCommunityId(JsonField.of(targetCommunityId))

            /**
             * Sets [Builder.targetCommunityId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.targetCommunityId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun targetCommunityId(targetCommunityId: JsonField<String>) = apply {
                this.targetCommunityId = targetCommunityId
            }

            fun targetListId(targetListId: String) = targetListId(JsonField.of(targetListId))

            /**
             * Sets [Builder.targetListId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.targetListId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun targetListId(targetListId: JsonField<String>) = apply {
                this.targetListId = targetListId
            }

            fun targetSpaceId(targetSpaceId: String) = targetSpaceId(JsonField.of(targetSpaceId))

            /**
             * Sets [Builder.targetSpaceId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.targetSpaceId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun targetSpaceId(targetSpaceId: JsonField<String>) = apply {
                this.targetSpaceId = targetSpaceId
            }

            fun targetTweetId(targetTweetId: String) = targetTweetId(JsonField.of(targetTweetId))

            /**
             * Sets [Builder.targetTweetId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.targetTweetId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun targetTweetId(targetTweetId: JsonField<String>) = apply {
                this.targetTweetId = targetTweetId
            }

            fun targetUsername(targetUsername: String) =
                targetUsername(JsonField.of(targetUsername))

            /**
             * Sets [Builder.targetUsername] to an arbitrary JSON value.
             *
             * You should usually call [Builder.targetUsername] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun targetUsername(targetUsername: JsonField<String>) = apply {
                this.targetUsername = targetUsername
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
             * .toolType()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("toolType", toolType),
                    advancedQuery,
                    exactPhrase,
                    excludeWords,
                    searchQuery,
                    targetCommunityId,
                    targetListId,
                    targetSpaceId,
                    targetTweetId,
                    targetUsername,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            toolType().validate()
            advancedQuery()
            exactPhrase()
            excludeWords()
            searchQuery()
            targetCommunityId()
            targetListId()
            targetSpaceId()
            targetTweetId()
            targetUsername()
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
            (toolType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (advancedQuery.asKnown().isPresent) 1 else 0) +
                (if (exactPhrase.asKnown().isPresent) 1 else 0) +
                (if (excludeWords.asKnown().isPresent) 1 else 0) +
                (if (searchQuery.asKnown().isPresent) 1 else 0) +
                (if (targetCommunityId.asKnown().isPresent) 1 else 0) +
                (if (targetListId.asKnown().isPresent) 1 else 0) +
                (if (targetSpaceId.asKnown().isPresent) 1 else 0) +
                (if (targetTweetId.asKnown().isPresent) 1 else 0) +
                (if (targetUsername.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                toolType == other.toolType &&
                advancedQuery == other.advancedQuery &&
                exactPhrase == other.exactPhrase &&
                excludeWords == other.excludeWords &&
                searchQuery == other.searchQuery &&
                targetCommunityId == other.targetCommunityId &&
                targetListId == other.targetListId &&
                targetSpaceId == other.targetSpaceId &&
                targetTweetId == other.targetTweetId &&
                targetUsername == other.targetUsername &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                toolType,
                advancedQuery,
                exactPhrase,
                excludeWords,
                searchQuery,
                targetCommunityId,
                targetListId,
                targetSpaceId,
                targetTweetId,
                targetUsername,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{toolType=$toolType, advancedQuery=$advancedQuery, exactPhrase=$exactPhrase, excludeWords=$excludeWords, searchQuery=$searchQuery, targetCommunityId=$targetCommunityId, targetListId=$targetListId, targetSpaceId=$targetSpaceId, targetTweetId=$targetTweetId, targetUsername=$targetUsername, additionalProperties=$additionalProperties}"
    }

    /** Identifier for the extraction tool used to run a job. */
    class ToolType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val ARTICLE_EXTRACTOR = of("article_extractor")

            @JvmField val COMMUNITY_EXTRACTOR = of("community_extractor")

            @JvmField val COMMUNITY_MODERATOR_EXPLORER = of("community_moderator_explorer")

            @JvmField val COMMUNITY_POST_EXTRACTOR = of("community_post_extractor")

            @JvmField val COMMUNITY_SEARCH = of("community_search")

            @JvmField val FOLLOWER_EXPLORER = of("follower_explorer")

            @JvmField val FOLLOWING_EXPLORER = of("following_explorer")

            @JvmField val LIST_FOLLOWER_EXPLORER = of("list_follower_explorer")

            @JvmField val LIST_MEMBER_EXTRACTOR = of("list_member_extractor")

            @JvmField val LIST_POST_EXTRACTOR = of("list_post_extractor")

            @JvmField val MENTION_EXTRACTOR = of("mention_extractor")

            @JvmField val PEOPLE_SEARCH = of("people_search")

            @JvmField val POST_EXTRACTOR = of("post_extractor")

            @JvmField val QUOTE_EXTRACTOR = of("quote_extractor")

            @JvmField val REPLY_EXTRACTOR = of("reply_extractor")

            @JvmField val REPOST_EXTRACTOR = of("repost_extractor")

            @JvmField val SPACE_EXPLORER = of("space_explorer")

            @JvmField val THREAD_EXTRACTOR = of("thread_extractor")

            @JvmField val TWEET_SEARCH_EXTRACTOR = of("tweet_search_extractor")

            @JvmField val VERIFIED_FOLLOWER_EXPLORER = of("verified_follower_explorer")

            @JvmStatic fun of(value: String) = ToolType(JsonField.of(value))
        }

        /** An enum containing [ToolType]'s known values. */
        enum class Known {
            ARTICLE_EXTRACTOR,
            COMMUNITY_EXTRACTOR,
            COMMUNITY_MODERATOR_EXPLORER,
            COMMUNITY_POST_EXTRACTOR,
            COMMUNITY_SEARCH,
            FOLLOWER_EXPLORER,
            FOLLOWING_EXPLORER,
            LIST_FOLLOWER_EXPLORER,
            LIST_MEMBER_EXTRACTOR,
            LIST_POST_EXTRACTOR,
            MENTION_EXTRACTOR,
            PEOPLE_SEARCH,
            POST_EXTRACTOR,
            QUOTE_EXTRACTOR,
            REPLY_EXTRACTOR,
            REPOST_EXTRACTOR,
            SPACE_EXPLORER,
            THREAD_EXTRACTOR,
            TWEET_SEARCH_EXTRACTOR,
            VERIFIED_FOLLOWER_EXPLORER,
        }

        /**
         * An enum containing [ToolType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ToolType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ARTICLE_EXTRACTOR,
            COMMUNITY_EXTRACTOR,
            COMMUNITY_MODERATOR_EXPLORER,
            COMMUNITY_POST_EXTRACTOR,
            COMMUNITY_SEARCH,
            FOLLOWER_EXPLORER,
            FOLLOWING_EXPLORER,
            LIST_FOLLOWER_EXPLORER,
            LIST_MEMBER_EXTRACTOR,
            LIST_POST_EXTRACTOR,
            MENTION_EXTRACTOR,
            PEOPLE_SEARCH,
            POST_EXTRACTOR,
            QUOTE_EXTRACTOR,
            REPLY_EXTRACTOR,
            REPOST_EXTRACTOR,
            SPACE_EXPLORER,
            THREAD_EXTRACTOR,
            TWEET_SEARCH_EXTRACTOR,
            VERIFIED_FOLLOWER_EXPLORER,
            /** An enum member indicating that [ToolType] was instantiated with an unknown value. */
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
                ARTICLE_EXTRACTOR -> Value.ARTICLE_EXTRACTOR
                COMMUNITY_EXTRACTOR -> Value.COMMUNITY_EXTRACTOR
                COMMUNITY_MODERATOR_EXPLORER -> Value.COMMUNITY_MODERATOR_EXPLORER
                COMMUNITY_POST_EXTRACTOR -> Value.COMMUNITY_POST_EXTRACTOR
                COMMUNITY_SEARCH -> Value.COMMUNITY_SEARCH
                FOLLOWER_EXPLORER -> Value.FOLLOWER_EXPLORER
                FOLLOWING_EXPLORER -> Value.FOLLOWING_EXPLORER
                LIST_FOLLOWER_EXPLORER -> Value.LIST_FOLLOWER_EXPLORER
                LIST_MEMBER_EXTRACTOR -> Value.LIST_MEMBER_EXTRACTOR
                LIST_POST_EXTRACTOR -> Value.LIST_POST_EXTRACTOR
                MENTION_EXTRACTOR -> Value.MENTION_EXTRACTOR
                PEOPLE_SEARCH -> Value.PEOPLE_SEARCH
                POST_EXTRACTOR -> Value.POST_EXTRACTOR
                QUOTE_EXTRACTOR -> Value.QUOTE_EXTRACTOR
                REPLY_EXTRACTOR -> Value.REPLY_EXTRACTOR
                REPOST_EXTRACTOR -> Value.REPOST_EXTRACTOR
                SPACE_EXPLORER -> Value.SPACE_EXPLORER
                THREAD_EXTRACTOR -> Value.THREAD_EXTRACTOR
                TWEET_SEARCH_EXTRACTOR -> Value.TWEET_SEARCH_EXTRACTOR
                VERIFIED_FOLLOWER_EXPLORER -> Value.VERIFIED_FOLLOWER_EXPLORER
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
                ARTICLE_EXTRACTOR -> Known.ARTICLE_EXTRACTOR
                COMMUNITY_EXTRACTOR -> Known.COMMUNITY_EXTRACTOR
                COMMUNITY_MODERATOR_EXPLORER -> Known.COMMUNITY_MODERATOR_EXPLORER
                COMMUNITY_POST_EXTRACTOR -> Known.COMMUNITY_POST_EXTRACTOR
                COMMUNITY_SEARCH -> Known.COMMUNITY_SEARCH
                FOLLOWER_EXPLORER -> Known.FOLLOWER_EXPLORER
                FOLLOWING_EXPLORER -> Known.FOLLOWING_EXPLORER
                LIST_FOLLOWER_EXPLORER -> Known.LIST_FOLLOWER_EXPLORER
                LIST_MEMBER_EXTRACTOR -> Known.LIST_MEMBER_EXTRACTOR
                LIST_POST_EXTRACTOR -> Known.LIST_POST_EXTRACTOR
                MENTION_EXTRACTOR -> Known.MENTION_EXTRACTOR
                PEOPLE_SEARCH -> Known.PEOPLE_SEARCH
                POST_EXTRACTOR -> Known.POST_EXTRACTOR
                QUOTE_EXTRACTOR -> Known.QUOTE_EXTRACTOR
                REPLY_EXTRACTOR -> Known.REPLY_EXTRACTOR
                REPOST_EXTRACTOR -> Known.REPOST_EXTRACTOR
                SPACE_EXPLORER -> Known.SPACE_EXPLORER
                THREAD_EXTRACTOR -> Known.THREAD_EXTRACTOR
                TWEET_SEARCH_EXTRACTOR -> Known.TWEET_SEARCH_EXTRACTOR
                VERIFIED_FOLLOWER_EXPLORER -> Known.VERIFIED_FOLLOWER_EXPLORER
                else -> throw XTwitterScraperInvalidDataException("Unknown ToolType: $value")
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

        fun validate(): ToolType = apply {
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

            return other is ToolType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExtractionEstimateCostParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ExtractionEstimateCostParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
