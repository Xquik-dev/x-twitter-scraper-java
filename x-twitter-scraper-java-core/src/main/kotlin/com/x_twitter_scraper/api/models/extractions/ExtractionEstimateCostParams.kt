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
import java.time.LocalDate
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
     * Alternative words or quoted phrases for estimated results. Separate with spaces, commas, or
     * lines.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun anyWords(): Optional<String> = body.anyWords()

    /**
     * Geo bounding box used for estimation, e.g. -74.1 40.6 -73.9 40.8 (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun boundingBox(): Optional<String> = body.boundingBox()

    /**
     * Cashtags applied to the estimate, separated by spaces, commas, or lines.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun cashtags(): Optional<String> = body.cashtags()

    /**
     * Conversation ID filter used for estimation (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun conversationId(): Optional<String> = body.conversationId()

    /**
     * Exact phrase filter for search estimation
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun exactPhrase(): Optional<String> = body.exactPhrase()

    /**
     * Words or quoted phrases excluded from estimated results. Separate with spaces, commas, or
     * lines.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun excludeWords(): Optional<String> = body.excludeWords()

    /**
     * Estimate only tweets from this author username (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun fromUser(): Optional<String> = body.fromUser()

    /**
     * Hashtags applied to the estimate, separated by spaces, commas, or lines.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun hashtags(): Optional<String> = body.hashtags()

    /**
     * Estimate only replies to this tweet ID (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun inReplyToTweetId(): Optional<String> = body.inReplyToTweetId()

    /**
     * Language code used for estimate filtering (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun language(): Optional<String> = body.language()

    /**
     * Estimate search results within this list ID (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun listId(): Optional<String> = body.listId()

    /**
     * Media type used for estimate filtering (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun mediaType(): Optional<MediaType> = body.mediaType()

    /**
     * Estimate tweets mentioning this username (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun mentioning(): Optional<String> = body.mentioning()

    /**
     * Minimum likes threshold for estimated results (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun minFaves(): Optional<Long> = body.minFaves()

    /**
     * Minimum quote count threshold for estimated results (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun minQuotes(): Optional<Long> = body.minQuotes()

    /**
     * Minimum replies threshold for estimated results (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun minReplies(): Optional<Long> = body.minReplies()

    /**
     * Minimum retweets threshold for estimated results (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun minRetweets(): Optional<Long> = body.minRetweets()

    /**
     * Estimate search results within this place ID (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun place(): Optional<String> = body.place()

    /**
     * Estimate search results within this country code (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun placeCountry(): Optional<String> = body.placeCountry()

    /**
     * Geo point radius used for estimation, e.g. -73.99 40.73 25mi (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun pointRadius(): Optional<String> = body.pointRadius()

    /**
     * Quote mode used for estimation (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun quotes(): Optional<Quotes> = body.quotes()

    /**
     * Estimate only quotes of this tweet ID (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun quotesOfTweetId(): Optional<String> = body.quotesOfTweetId()

    /**
     * Reply mode used for estimation (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun replies(): Optional<Replies> = body.replies()

    /**
     * Maximum number of results to estimate. When set, the estimate caps projected results to this
     * value.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun resultsLimit(): Optional<Long> = body.resultsLimit()

    /**
     * Retweet mode used for estimation (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun retweets(): Optional<Retweets> = body.retweets()

    /**
     * Estimate only retweets of this tweet ID (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun retweetsOfTweetId(): Optional<String> = body.retweetsOfTweetId()

    /**
     * Query used to price tweet_search_extractor or community_search.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun searchQuery(): Optional<String> = body.searchQuery()

    /**
     * Estimate start date in YYYY-MM-DD format (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun sinceDate(): Optional<LocalDate> = body.sinceDate()

    /**
     * Community ID used to price community_post_extractor or community_search.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetCommunityId(): Optional<String> = body.targetCommunityId()

    /**
     * List ID used to price list_follower_explorer, list_member_extractor, or list_post_extractor.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetListId(): Optional<String> = body.targetListId()

    /**
     * Space ID used to price space_explorer.
     *
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
     * Estimate replies sent to this username (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun toUser(): Optional<String> = body.toUser()

    /**
     * Estimate end date in YYYY-MM-DD format (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun untilDate(): Optional<LocalDate> = body.untilDate()

    /**
     * URL substring or domain filter used for estimation (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun url(): Optional<String> = body.url()

    /**
     * Estimate only verified authors (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun verifiedOnly(): Optional<Boolean> = body.verifiedOnly()

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
     * Returns the raw JSON value of [anyWords].
     *
     * Unlike [anyWords], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _anyWords(): JsonField<String> = body._anyWords()

    /**
     * Returns the raw JSON value of [boundingBox].
     *
     * Unlike [boundingBox], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _boundingBox(): JsonField<String> = body._boundingBox()

    /**
     * Returns the raw JSON value of [cashtags].
     *
     * Unlike [cashtags], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _cashtags(): JsonField<String> = body._cashtags()

    /**
     * Returns the raw JSON value of [conversationId].
     *
     * Unlike [conversationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _conversationId(): JsonField<String> = body._conversationId()

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
     * Returns the raw JSON value of [fromUser].
     *
     * Unlike [fromUser], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _fromUser(): JsonField<String> = body._fromUser()

    /**
     * Returns the raw JSON value of [hashtags].
     *
     * Unlike [hashtags], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _hashtags(): JsonField<String> = body._hashtags()

    /**
     * Returns the raw JSON value of [inReplyToTweetId].
     *
     * Unlike [inReplyToTweetId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _inReplyToTweetId(): JsonField<String> = body._inReplyToTweetId()

    /**
     * Returns the raw JSON value of [language].
     *
     * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _language(): JsonField<String> = body._language()

    /**
     * Returns the raw JSON value of [listId].
     *
     * Unlike [listId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _listId(): JsonField<String> = body._listId()

    /**
     * Returns the raw JSON value of [mediaType].
     *
     * Unlike [mediaType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _mediaType(): JsonField<MediaType> = body._mediaType()

    /**
     * Returns the raw JSON value of [mentioning].
     *
     * Unlike [mentioning], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _mentioning(): JsonField<String> = body._mentioning()

    /**
     * Returns the raw JSON value of [minFaves].
     *
     * Unlike [minFaves], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _minFaves(): JsonField<Long> = body._minFaves()

    /**
     * Returns the raw JSON value of [minQuotes].
     *
     * Unlike [minQuotes], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _minQuotes(): JsonField<Long> = body._minQuotes()

    /**
     * Returns the raw JSON value of [minReplies].
     *
     * Unlike [minReplies], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _minReplies(): JsonField<Long> = body._minReplies()

    /**
     * Returns the raw JSON value of [minRetweets].
     *
     * Unlike [minRetweets], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _minRetweets(): JsonField<Long> = body._minRetweets()

    /**
     * Returns the raw JSON value of [place].
     *
     * Unlike [place], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _place(): JsonField<String> = body._place()

    /**
     * Returns the raw JSON value of [placeCountry].
     *
     * Unlike [placeCountry], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _placeCountry(): JsonField<String> = body._placeCountry()

    /**
     * Returns the raw JSON value of [pointRadius].
     *
     * Unlike [pointRadius], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _pointRadius(): JsonField<String> = body._pointRadius()

    /**
     * Returns the raw JSON value of [quotes].
     *
     * Unlike [quotes], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _quotes(): JsonField<Quotes> = body._quotes()

    /**
     * Returns the raw JSON value of [quotesOfTweetId].
     *
     * Unlike [quotesOfTweetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _quotesOfTweetId(): JsonField<String> = body._quotesOfTweetId()

    /**
     * Returns the raw JSON value of [replies].
     *
     * Unlike [replies], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _replies(): JsonField<Replies> = body._replies()

    /**
     * Returns the raw JSON value of [resultsLimit].
     *
     * Unlike [resultsLimit], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _resultsLimit(): JsonField<Long> = body._resultsLimit()

    /**
     * Returns the raw JSON value of [retweets].
     *
     * Unlike [retweets], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _retweets(): JsonField<Retweets> = body._retweets()

    /**
     * Returns the raw JSON value of [retweetsOfTweetId].
     *
     * Unlike [retweetsOfTweetId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _retweetsOfTweetId(): JsonField<String> = body._retweetsOfTweetId()

    /**
     * Returns the raw JSON value of [searchQuery].
     *
     * Unlike [searchQuery], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _searchQuery(): JsonField<String> = body._searchQuery()

    /**
     * Returns the raw JSON value of [sinceDate].
     *
     * Unlike [sinceDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sinceDate(): JsonField<LocalDate> = body._sinceDate()

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

    /**
     * Returns the raw JSON value of [toUser].
     *
     * Unlike [toUser], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _toUser(): JsonField<String> = body._toUser()

    /**
     * Returns the raw JSON value of [untilDate].
     *
     * Unlike [untilDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _untilDate(): JsonField<LocalDate> = body._untilDate()

    /**
     * Returns the raw JSON value of [url].
     *
     * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _url(): JsonField<String> = body._url()

    /**
     * Returns the raw JSON value of [verifiedOnly].
     *
     * Unlike [verifiedOnly], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _verifiedOnly(): JsonField<Boolean> = body._verifiedOnly()

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
         * - [anyWords]
         * - [boundingBox]
         * - [cashtags]
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

        /**
         * Alternative words or quoted phrases for estimated results. Separate with spaces, commas,
         * or lines.
         */
        fun anyWords(anyWords: String) = apply { body.anyWords(anyWords) }

        /**
         * Sets [Builder.anyWords] to an arbitrary JSON value.
         *
         * You should usually call [Builder.anyWords] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun anyWords(anyWords: JsonField<String>) = apply { body.anyWords(anyWords) }

        /**
         * Geo bounding box used for estimation, e.g. -74.1 40.6 -73.9 40.8 (tweet_search_extractor)
         */
        fun boundingBox(boundingBox: String) = apply { body.boundingBox(boundingBox) }

        /**
         * Sets [Builder.boundingBox] to an arbitrary JSON value.
         *
         * You should usually call [Builder.boundingBox] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun boundingBox(boundingBox: JsonField<String>) = apply { body.boundingBox(boundingBox) }

        /** Cashtags applied to the estimate, separated by spaces, commas, or lines. */
        fun cashtags(cashtags: String) = apply { body.cashtags(cashtags) }

        /**
         * Sets [Builder.cashtags] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cashtags] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cashtags(cashtags: JsonField<String>) = apply { body.cashtags(cashtags) }

        /** Conversation ID filter used for estimation (tweet_search_extractor) */
        fun conversationId(conversationId: String) = apply { body.conversationId(conversationId) }

        /**
         * Sets [Builder.conversationId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.conversationId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun conversationId(conversationId: JsonField<String>) = apply {
            body.conversationId(conversationId)
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

        /**
         * Words or quoted phrases excluded from estimated results. Separate with spaces, commas, or
         * lines.
         */
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

        /** Estimate only tweets from this author username (tweet_search_extractor) */
        fun fromUser(fromUser: String) = apply { body.fromUser(fromUser) }

        /**
         * Sets [Builder.fromUser] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fromUser] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fromUser(fromUser: JsonField<String>) = apply { body.fromUser(fromUser) }

        /** Hashtags applied to the estimate, separated by spaces, commas, or lines. */
        fun hashtags(hashtags: String) = apply { body.hashtags(hashtags) }

        /**
         * Sets [Builder.hashtags] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hashtags] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hashtags(hashtags: JsonField<String>) = apply { body.hashtags(hashtags) }

        /** Estimate only replies to this tweet ID (tweet_search_extractor) */
        fun inReplyToTweetId(inReplyToTweetId: String) = apply {
            body.inReplyToTweetId(inReplyToTweetId)
        }

        /**
         * Sets [Builder.inReplyToTweetId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inReplyToTweetId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inReplyToTweetId(inReplyToTweetId: JsonField<String>) = apply {
            body.inReplyToTweetId(inReplyToTweetId)
        }

        /** Language code used for estimate filtering (tweet_search_extractor) */
        fun language(language: String) = apply { body.language(language) }

        /**
         * Sets [Builder.language] to an arbitrary JSON value.
         *
         * You should usually call [Builder.language] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun language(language: JsonField<String>) = apply { body.language(language) }

        /** Estimate search results within this list ID (tweet_search_extractor) */
        fun listId(listId: String) = apply { body.listId(listId) }

        /**
         * Sets [Builder.listId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.listId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun listId(listId: JsonField<String>) = apply { body.listId(listId) }

        /** Media type used for estimate filtering (tweet_search_extractor) */
        fun mediaType(mediaType: MediaType) = apply { body.mediaType(mediaType) }

        /**
         * Sets [Builder.mediaType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mediaType] with a well-typed [MediaType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun mediaType(mediaType: JsonField<MediaType>) = apply { body.mediaType(mediaType) }

        /** Estimate tweets mentioning this username (tweet_search_extractor) */
        fun mentioning(mentioning: String) = apply { body.mentioning(mentioning) }

        /**
         * Sets [Builder.mentioning] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mentioning] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun mentioning(mentioning: JsonField<String>) = apply { body.mentioning(mentioning) }

        /** Minimum likes threshold for estimated results (tweet_search_extractor) */
        fun minFaves(minFaves: Long) = apply { body.minFaves(minFaves) }

        /**
         * Sets [Builder.minFaves] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minFaves] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun minFaves(minFaves: JsonField<Long>) = apply { body.minFaves(minFaves) }

        /** Minimum quote count threshold for estimated results (tweet_search_extractor) */
        fun minQuotes(minQuotes: Long) = apply { body.minQuotes(minQuotes) }

        /**
         * Sets [Builder.minQuotes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minQuotes] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun minQuotes(minQuotes: JsonField<Long>) = apply { body.minQuotes(minQuotes) }

        /** Minimum replies threshold for estimated results (tweet_search_extractor) */
        fun minReplies(minReplies: Long) = apply { body.minReplies(minReplies) }

        /**
         * Sets [Builder.minReplies] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minReplies] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun minReplies(minReplies: JsonField<Long>) = apply { body.minReplies(minReplies) }

        /** Minimum retweets threshold for estimated results (tweet_search_extractor) */
        fun minRetweets(minRetweets: Long) = apply { body.minRetweets(minRetweets) }

        /**
         * Sets [Builder.minRetweets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minRetweets] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun minRetweets(minRetweets: JsonField<Long>) = apply { body.minRetweets(minRetweets) }

        /** Estimate search results within this place ID (tweet_search_extractor) */
        fun place(place: String) = apply { body.place(place) }

        /**
         * Sets [Builder.place] to an arbitrary JSON value.
         *
         * You should usually call [Builder.place] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun place(place: JsonField<String>) = apply { body.place(place) }

        /** Estimate search results within this country code (tweet_search_extractor) */
        fun placeCountry(placeCountry: String) = apply { body.placeCountry(placeCountry) }

        /**
         * Sets [Builder.placeCountry] to an arbitrary JSON value.
         *
         * You should usually call [Builder.placeCountry] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun placeCountry(placeCountry: JsonField<String>) = apply {
            body.placeCountry(placeCountry)
        }

        /** Geo point radius used for estimation, e.g. -73.99 40.73 25mi (tweet_search_extractor) */
        fun pointRadius(pointRadius: String) = apply { body.pointRadius(pointRadius) }

        /**
         * Sets [Builder.pointRadius] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pointRadius] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun pointRadius(pointRadius: JsonField<String>) = apply { body.pointRadius(pointRadius) }

        /** Quote mode used for estimation (tweet_search_extractor) */
        fun quotes(quotes: Quotes) = apply { body.quotes(quotes) }

        /**
         * Sets [Builder.quotes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quotes] with a well-typed [Quotes] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun quotes(quotes: JsonField<Quotes>) = apply { body.quotes(quotes) }

        /** Estimate only quotes of this tweet ID (tweet_search_extractor) */
        fun quotesOfTweetId(quotesOfTweetId: String) = apply {
            body.quotesOfTweetId(quotesOfTweetId)
        }

        /**
         * Sets [Builder.quotesOfTweetId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quotesOfTweetId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun quotesOfTweetId(quotesOfTweetId: JsonField<String>) = apply {
            body.quotesOfTweetId(quotesOfTweetId)
        }

        /** Reply mode used for estimation (tweet_search_extractor) */
        fun replies(replies: Replies) = apply { body.replies(replies) }

        /**
         * Sets [Builder.replies] to an arbitrary JSON value.
         *
         * You should usually call [Builder.replies] with a well-typed [Replies] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun replies(replies: JsonField<Replies>) = apply { body.replies(replies) }

        /**
         * Maximum number of results to estimate. When set, the estimate caps projected results to
         * this value.
         */
        fun resultsLimit(resultsLimit: Long) = apply { body.resultsLimit(resultsLimit) }

        /**
         * Sets [Builder.resultsLimit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.resultsLimit] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun resultsLimit(resultsLimit: JsonField<Long>) = apply { body.resultsLimit(resultsLimit) }

        /** Retweet mode used for estimation (tweet_search_extractor) */
        fun retweets(retweets: Retweets) = apply { body.retweets(retweets) }

        /**
         * Sets [Builder.retweets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.retweets] with a well-typed [Retweets] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun retweets(retweets: JsonField<Retweets>) = apply { body.retweets(retweets) }

        /** Estimate only retweets of this tweet ID (tweet_search_extractor) */
        fun retweetsOfTweetId(retweetsOfTweetId: String) = apply {
            body.retweetsOfTweetId(retweetsOfTweetId)
        }

        /**
         * Sets [Builder.retweetsOfTweetId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.retweetsOfTweetId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun retweetsOfTweetId(retweetsOfTweetId: JsonField<String>) = apply {
            body.retweetsOfTweetId(retweetsOfTweetId)
        }

        /** Query used to price tweet_search_extractor or community_search. */
        fun searchQuery(searchQuery: String) = apply { body.searchQuery(searchQuery) }

        /**
         * Sets [Builder.searchQuery] to an arbitrary JSON value.
         *
         * You should usually call [Builder.searchQuery] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun searchQuery(searchQuery: JsonField<String>) = apply { body.searchQuery(searchQuery) }

        /** Estimate start date in YYYY-MM-DD format (tweet_search_extractor) */
        fun sinceDate(sinceDate: LocalDate) = apply { body.sinceDate(sinceDate) }

        /**
         * Sets [Builder.sinceDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sinceDate] with a well-typed [LocalDate] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sinceDate(sinceDate: JsonField<LocalDate>) = apply { body.sinceDate(sinceDate) }

        /** Community ID used to price community_post_extractor or community_search. */
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

        /**
         * List ID used to price list_follower_explorer, list_member_extractor, or
         * list_post_extractor.
         */
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

        /** Space ID used to price space_explorer. */
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

        /** Estimate replies sent to this username (tweet_search_extractor) */
        fun toUser(toUser: String) = apply { body.toUser(toUser) }

        /**
         * Sets [Builder.toUser] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toUser] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun toUser(toUser: JsonField<String>) = apply { body.toUser(toUser) }

        /** Estimate end date in YYYY-MM-DD format (tweet_search_extractor) */
        fun untilDate(untilDate: LocalDate) = apply { body.untilDate(untilDate) }

        /**
         * Sets [Builder.untilDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.untilDate] with a well-typed [LocalDate] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun untilDate(untilDate: JsonField<LocalDate>) = apply { body.untilDate(untilDate) }

        /** URL substring or domain filter used for estimation (tweet_search_extractor) */
        fun url(url: String) = apply { body.url(url) }

        /**
         * Sets [Builder.url] to an arbitrary JSON value.
         *
         * You should usually call [Builder.url] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun url(url: JsonField<String>) = apply { body.url(url) }

        /** Estimate only verified authors (tweet_search_extractor) */
        fun verifiedOnly(verifiedOnly: Boolean) = apply { body.verifiedOnly(verifiedOnly) }

        /**
         * Sets [Builder.verifiedOnly] to an arbitrary JSON value.
         *
         * You should usually call [Builder.verifiedOnly] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun verifiedOnly(verifiedOnly: JsonField<Boolean>) = apply {
            body.verifiedOnly(verifiedOnly)
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
        private val anyWords: JsonField<String>,
        private val boundingBox: JsonField<String>,
        private val cashtags: JsonField<String>,
        private val conversationId: JsonField<String>,
        private val exactPhrase: JsonField<String>,
        private val excludeWords: JsonField<String>,
        private val fromUser: JsonField<String>,
        private val hashtags: JsonField<String>,
        private val inReplyToTweetId: JsonField<String>,
        private val language: JsonField<String>,
        private val listId: JsonField<String>,
        private val mediaType: JsonField<MediaType>,
        private val mentioning: JsonField<String>,
        private val minFaves: JsonField<Long>,
        private val minQuotes: JsonField<Long>,
        private val minReplies: JsonField<Long>,
        private val minRetweets: JsonField<Long>,
        private val place: JsonField<String>,
        private val placeCountry: JsonField<String>,
        private val pointRadius: JsonField<String>,
        private val quotes: JsonField<Quotes>,
        private val quotesOfTweetId: JsonField<String>,
        private val replies: JsonField<Replies>,
        private val resultsLimit: JsonField<Long>,
        private val retweets: JsonField<Retweets>,
        private val retweetsOfTweetId: JsonField<String>,
        private val searchQuery: JsonField<String>,
        private val sinceDate: JsonField<LocalDate>,
        private val targetCommunityId: JsonField<String>,
        private val targetListId: JsonField<String>,
        private val targetSpaceId: JsonField<String>,
        private val targetTweetId: JsonField<String>,
        private val targetUsername: JsonField<String>,
        private val toUser: JsonField<String>,
        private val untilDate: JsonField<LocalDate>,
        private val url: JsonField<String>,
        private val verifiedOnly: JsonField<Boolean>,
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
            @JsonProperty("anyWords")
            @ExcludeMissing
            anyWords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("boundingBox")
            @ExcludeMissing
            boundingBox: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cashtags")
            @ExcludeMissing
            cashtags: JsonField<String> = JsonMissing.of(),
            @JsonProperty("conversationId")
            @ExcludeMissing
            conversationId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("exactPhrase")
            @ExcludeMissing
            exactPhrase: JsonField<String> = JsonMissing.of(),
            @JsonProperty("excludeWords")
            @ExcludeMissing
            excludeWords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("fromUser")
            @ExcludeMissing
            fromUser: JsonField<String> = JsonMissing.of(),
            @JsonProperty("hashtags")
            @ExcludeMissing
            hashtags: JsonField<String> = JsonMissing.of(),
            @JsonProperty("inReplyToTweetId")
            @ExcludeMissing
            inReplyToTweetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("language")
            @ExcludeMissing
            language: JsonField<String> = JsonMissing.of(),
            @JsonProperty("listId") @ExcludeMissing listId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("mediaType")
            @ExcludeMissing
            mediaType: JsonField<MediaType> = JsonMissing.of(),
            @JsonProperty("mentioning")
            @ExcludeMissing
            mentioning: JsonField<String> = JsonMissing.of(),
            @JsonProperty("minFaves") @ExcludeMissing minFaves: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("minQuotes")
            @ExcludeMissing
            minQuotes: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("minReplies")
            @ExcludeMissing
            minReplies: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("minRetweets")
            @ExcludeMissing
            minRetweets: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("place") @ExcludeMissing place: JsonField<String> = JsonMissing.of(),
            @JsonProperty("placeCountry")
            @ExcludeMissing
            placeCountry: JsonField<String> = JsonMissing.of(),
            @JsonProperty("pointRadius")
            @ExcludeMissing
            pointRadius: JsonField<String> = JsonMissing.of(),
            @JsonProperty("quotes") @ExcludeMissing quotes: JsonField<Quotes> = JsonMissing.of(),
            @JsonProperty("quotesOfTweetId")
            @ExcludeMissing
            quotesOfTweetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("replies") @ExcludeMissing replies: JsonField<Replies> = JsonMissing.of(),
            @JsonProperty("resultsLimit")
            @ExcludeMissing
            resultsLimit: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("retweets")
            @ExcludeMissing
            retweets: JsonField<Retweets> = JsonMissing.of(),
            @JsonProperty("retweetsOfTweetId")
            @ExcludeMissing
            retweetsOfTweetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("searchQuery")
            @ExcludeMissing
            searchQuery: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sinceDate")
            @ExcludeMissing
            sinceDate: JsonField<LocalDate> = JsonMissing.of(),
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
            @JsonProperty("toUser") @ExcludeMissing toUser: JsonField<String> = JsonMissing.of(),
            @JsonProperty("untilDate")
            @ExcludeMissing
            untilDate: JsonField<LocalDate> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("verifiedOnly")
            @ExcludeMissing
            verifiedOnly: JsonField<Boolean> = JsonMissing.of(),
        ) : this(
            toolType,
            advancedQuery,
            anyWords,
            boundingBox,
            cashtags,
            conversationId,
            exactPhrase,
            excludeWords,
            fromUser,
            hashtags,
            inReplyToTweetId,
            language,
            listId,
            mediaType,
            mentioning,
            minFaves,
            minQuotes,
            minReplies,
            minRetweets,
            place,
            placeCountry,
            pointRadius,
            quotes,
            quotesOfTweetId,
            replies,
            resultsLimit,
            retweets,
            retweetsOfTweetId,
            searchQuery,
            sinceDate,
            targetCommunityId,
            targetListId,
            targetSpaceId,
            targetTweetId,
            targetUsername,
            toUser,
            untilDate,
            url,
            verifiedOnly,
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
         * Alternative words or quoted phrases for estimated results. Separate with spaces, commas,
         * or lines.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun anyWords(): Optional<String> = anyWords.getOptional("anyWords")

        /**
         * Geo bounding box used for estimation, e.g. -74.1 40.6 -73.9 40.8 (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun boundingBox(): Optional<String> = boundingBox.getOptional("boundingBox")

        /**
         * Cashtags applied to the estimate, separated by spaces, commas, or lines.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun cashtags(): Optional<String> = cashtags.getOptional("cashtags")

        /**
         * Conversation ID filter used for estimation (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun conversationId(): Optional<String> = conversationId.getOptional("conversationId")

        /**
         * Exact phrase filter for search estimation
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun exactPhrase(): Optional<String> = exactPhrase.getOptional("exactPhrase")

        /**
         * Words or quoted phrases excluded from estimated results. Separate with spaces, commas, or
         * lines.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun excludeWords(): Optional<String> = excludeWords.getOptional("excludeWords")

        /**
         * Estimate only tweets from this author username (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun fromUser(): Optional<String> = fromUser.getOptional("fromUser")

        /**
         * Hashtags applied to the estimate, separated by spaces, commas, or lines.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun hashtags(): Optional<String> = hashtags.getOptional("hashtags")

        /**
         * Estimate only replies to this tweet ID (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun inReplyToTweetId(): Optional<String> = inReplyToTweetId.getOptional("inReplyToTweetId")

        /**
         * Language code used for estimate filtering (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun language(): Optional<String> = language.getOptional("language")

        /**
         * Estimate search results within this list ID (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun listId(): Optional<String> = listId.getOptional("listId")

        /**
         * Media type used for estimate filtering (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun mediaType(): Optional<MediaType> = mediaType.getOptional("mediaType")

        /**
         * Estimate tweets mentioning this username (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun mentioning(): Optional<String> = mentioning.getOptional("mentioning")

        /**
         * Minimum likes threshold for estimated results (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun minFaves(): Optional<Long> = minFaves.getOptional("minFaves")

        /**
         * Minimum quote count threshold for estimated results (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun minQuotes(): Optional<Long> = minQuotes.getOptional("minQuotes")

        /**
         * Minimum replies threshold for estimated results (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun minReplies(): Optional<Long> = minReplies.getOptional("minReplies")

        /**
         * Minimum retweets threshold for estimated results (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun minRetweets(): Optional<Long> = minRetweets.getOptional("minRetweets")

        /**
         * Estimate search results within this place ID (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun place(): Optional<String> = place.getOptional("place")

        /**
         * Estimate search results within this country code (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun placeCountry(): Optional<String> = placeCountry.getOptional("placeCountry")

        /**
         * Geo point radius used for estimation, e.g. -73.99 40.73 25mi (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun pointRadius(): Optional<String> = pointRadius.getOptional("pointRadius")

        /**
         * Quote mode used for estimation (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun quotes(): Optional<Quotes> = quotes.getOptional("quotes")

        /**
         * Estimate only quotes of this tweet ID (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun quotesOfTweetId(): Optional<String> = quotesOfTweetId.getOptional("quotesOfTweetId")

        /**
         * Reply mode used for estimation (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun replies(): Optional<Replies> = replies.getOptional("replies")

        /**
         * Maximum number of results to estimate. When set, the estimate caps projected results to
         * this value.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun resultsLimit(): Optional<Long> = resultsLimit.getOptional("resultsLimit")

        /**
         * Retweet mode used for estimation (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun retweets(): Optional<Retweets> = retweets.getOptional("retweets")

        /**
         * Estimate only retweets of this tweet ID (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun retweetsOfTweetId(): Optional<String> =
            retweetsOfTweetId.getOptional("retweetsOfTweetId")

        /**
         * Query used to price tweet_search_extractor or community_search.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun searchQuery(): Optional<String> = searchQuery.getOptional("searchQuery")

        /**
         * Estimate start date in YYYY-MM-DD format (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun sinceDate(): Optional<LocalDate> = sinceDate.getOptional("sinceDate")

        /**
         * Community ID used to price community_post_extractor or community_search.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targetCommunityId(): Optional<String> =
            targetCommunityId.getOptional("targetCommunityId")

        /**
         * List ID used to price list_follower_explorer, list_member_extractor, or
         * list_post_extractor.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targetListId(): Optional<String> = targetListId.getOptional("targetListId")

        /**
         * Space ID used to price space_explorer.
         *
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
         * Estimate replies sent to this username (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun toUser(): Optional<String> = toUser.getOptional("toUser")

        /**
         * Estimate end date in YYYY-MM-DD format (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun untilDate(): Optional<LocalDate> = untilDate.getOptional("untilDate")

        /**
         * URL substring or domain filter used for estimation (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * Estimate only verified authors (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun verifiedOnly(): Optional<Boolean> = verifiedOnly.getOptional("verifiedOnly")

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
         * Returns the raw JSON value of [anyWords].
         *
         * Unlike [anyWords], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("anyWords") @ExcludeMissing fun _anyWords(): JsonField<String> = anyWords

        /**
         * Returns the raw JSON value of [boundingBox].
         *
         * Unlike [boundingBox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("boundingBox")
        @ExcludeMissing
        fun _boundingBox(): JsonField<String> = boundingBox

        /**
         * Returns the raw JSON value of [cashtags].
         *
         * Unlike [cashtags], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cashtags") @ExcludeMissing fun _cashtags(): JsonField<String> = cashtags

        /**
         * Returns the raw JSON value of [conversationId].
         *
         * Unlike [conversationId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("conversationId")
        @ExcludeMissing
        fun _conversationId(): JsonField<String> = conversationId

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
         * Returns the raw JSON value of [fromUser].
         *
         * Unlike [fromUser], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fromUser") @ExcludeMissing fun _fromUser(): JsonField<String> = fromUser

        /**
         * Returns the raw JSON value of [hashtags].
         *
         * Unlike [hashtags], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hashtags") @ExcludeMissing fun _hashtags(): JsonField<String> = hashtags

        /**
         * Returns the raw JSON value of [inReplyToTweetId].
         *
         * Unlike [inReplyToTweetId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("inReplyToTweetId")
        @ExcludeMissing
        fun _inReplyToTweetId(): JsonField<String> = inReplyToTweetId

        /**
         * Returns the raw JSON value of [language].
         *
         * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<String> = language

        /**
         * Returns the raw JSON value of [listId].
         *
         * Unlike [listId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("listId") @ExcludeMissing fun _listId(): JsonField<String> = listId

        /**
         * Returns the raw JSON value of [mediaType].
         *
         * Unlike [mediaType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mediaType")
        @ExcludeMissing
        fun _mediaType(): JsonField<MediaType> = mediaType

        /**
         * Returns the raw JSON value of [mentioning].
         *
         * Unlike [mentioning], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mentioning")
        @ExcludeMissing
        fun _mentioning(): JsonField<String> = mentioning

        /**
         * Returns the raw JSON value of [minFaves].
         *
         * Unlike [minFaves], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("minFaves") @ExcludeMissing fun _minFaves(): JsonField<Long> = minFaves

        /**
         * Returns the raw JSON value of [minQuotes].
         *
         * Unlike [minQuotes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("minQuotes") @ExcludeMissing fun _minQuotes(): JsonField<Long> = minQuotes

        /**
         * Returns the raw JSON value of [minReplies].
         *
         * Unlike [minReplies], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("minReplies") @ExcludeMissing fun _minReplies(): JsonField<Long> = minReplies

        /**
         * Returns the raw JSON value of [minRetweets].
         *
         * Unlike [minRetweets], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("minRetweets")
        @ExcludeMissing
        fun _minRetweets(): JsonField<Long> = minRetweets

        /**
         * Returns the raw JSON value of [place].
         *
         * Unlike [place], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("place") @ExcludeMissing fun _place(): JsonField<String> = place

        /**
         * Returns the raw JSON value of [placeCountry].
         *
         * Unlike [placeCountry], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("placeCountry")
        @ExcludeMissing
        fun _placeCountry(): JsonField<String> = placeCountry

        /**
         * Returns the raw JSON value of [pointRadius].
         *
         * Unlike [pointRadius], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("pointRadius")
        @ExcludeMissing
        fun _pointRadius(): JsonField<String> = pointRadius

        /**
         * Returns the raw JSON value of [quotes].
         *
         * Unlike [quotes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("quotes") @ExcludeMissing fun _quotes(): JsonField<Quotes> = quotes

        /**
         * Returns the raw JSON value of [quotesOfTweetId].
         *
         * Unlike [quotesOfTweetId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("quotesOfTweetId")
        @ExcludeMissing
        fun _quotesOfTweetId(): JsonField<String> = quotesOfTweetId

        /**
         * Returns the raw JSON value of [replies].
         *
         * Unlike [replies], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("replies") @ExcludeMissing fun _replies(): JsonField<Replies> = replies

        /**
         * Returns the raw JSON value of [resultsLimit].
         *
         * Unlike [resultsLimit], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("resultsLimit")
        @ExcludeMissing
        fun _resultsLimit(): JsonField<Long> = resultsLimit

        /**
         * Returns the raw JSON value of [retweets].
         *
         * Unlike [retweets], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("retweets") @ExcludeMissing fun _retweets(): JsonField<Retweets> = retweets

        /**
         * Returns the raw JSON value of [retweetsOfTweetId].
         *
         * Unlike [retweetsOfTweetId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("retweetsOfTweetId")
        @ExcludeMissing
        fun _retweetsOfTweetId(): JsonField<String> = retweetsOfTweetId

        /**
         * Returns the raw JSON value of [searchQuery].
         *
         * Unlike [searchQuery], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("searchQuery")
        @ExcludeMissing
        fun _searchQuery(): JsonField<String> = searchQuery

        /**
         * Returns the raw JSON value of [sinceDate].
         *
         * Unlike [sinceDate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sinceDate")
        @ExcludeMissing
        fun _sinceDate(): JsonField<LocalDate> = sinceDate

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

        /**
         * Returns the raw JSON value of [toUser].
         *
         * Unlike [toUser], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("toUser") @ExcludeMissing fun _toUser(): JsonField<String> = toUser

        /**
         * Returns the raw JSON value of [untilDate].
         *
         * Unlike [untilDate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("untilDate")
        @ExcludeMissing
        fun _untilDate(): JsonField<LocalDate> = untilDate

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [verifiedOnly].
         *
         * Unlike [verifiedOnly], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("verifiedOnly")
        @ExcludeMissing
        fun _verifiedOnly(): JsonField<Boolean> = verifiedOnly

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
            private var anyWords: JsonField<String> = JsonMissing.of()
            private var boundingBox: JsonField<String> = JsonMissing.of()
            private var cashtags: JsonField<String> = JsonMissing.of()
            private var conversationId: JsonField<String> = JsonMissing.of()
            private var exactPhrase: JsonField<String> = JsonMissing.of()
            private var excludeWords: JsonField<String> = JsonMissing.of()
            private var fromUser: JsonField<String> = JsonMissing.of()
            private var hashtags: JsonField<String> = JsonMissing.of()
            private var inReplyToTweetId: JsonField<String> = JsonMissing.of()
            private var language: JsonField<String> = JsonMissing.of()
            private var listId: JsonField<String> = JsonMissing.of()
            private var mediaType: JsonField<MediaType> = JsonMissing.of()
            private var mentioning: JsonField<String> = JsonMissing.of()
            private var minFaves: JsonField<Long> = JsonMissing.of()
            private var minQuotes: JsonField<Long> = JsonMissing.of()
            private var minReplies: JsonField<Long> = JsonMissing.of()
            private var minRetweets: JsonField<Long> = JsonMissing.of()
            private var place: JsonField<String> = JsonMissing.of()
            private var placeCountry: JsonField<String> = JsonMissing.of()
            private var pointRadius: JsonField<String> = JsonMissing.of()
            private var quotes: JsonField<Quotes> = JsonMissing.of()
            private var quotesOfTweetId: JsonField<String> = JsonMissing.of()
            private var replies: JsonField<Replies> = JsonMissing.of()
            private var resultsLimit: JsonField<Long> = JsonMissing.of()
            private var retweets: JsonField<Retweets> = JsonMissing.of()
            private var retweetsOfTweetId: JsonField<String> = JsonMissing.of()
            private var searchQuery: JsonField<String> = JsonMissing.of()
            private var sinceDate: JsonField<LocalDate> = JsonMissing.of()
            private var targetCommunityId: JsonField<String> = JsonMissing.of()
            private var targetListId: JsonField<String> = JsonMissing.of()
            private var targetSpaceId: JsonField<String> = JsonMissing.of()
            private var targetTweetId: JsonField<String> = JsonMissing.of()
            private var targetUsername: JsonField<String> = JsonMissing.of()
            private var toUser: JsonField<String> = JsonMissing.of()
            private var untilDate: JsonField<LocalDate> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var verifiedOnly: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                toolType = body.toolType
                advancedQuery = body.advancedQuery
                anyWords = body.anyWords
                boundingBox = body.boundingBox
                cashtags = body.cashtags
                conversationId = body.conversationId
                exactPhrase = body.exactPhrase
                excludeWords = body.excludeWords
                fromUser = body.fromUser
                hashtags = body.hashtags
                inReplyToTweetId = body.inReplyToTweetId
                language = body.language
                listId = body.listId
                mediaType = body.mediaType
                mentioning = body.mentioning
                minFaves = body.minFaves
                minQuotes = body.minQuotes
                minReplies = body.minReplies
                minRetweets = body.minRetweets
                place = body.place
                placeCountry = body.placeCountry
                pointRadius = body.pointRadius
                quotes = body.quotes
                quotesOfTweetId = body.quotesOfTweetId
                replies = body.replies
                resultsLimit = body.resultsLimit
                retweets = body.retweets
                retweetsOfTweetId = body.retweetsOfTweetId
                searchQuery = body.searchQuery
                sinceDate = body.sinceDate
                targetCommunityId = body.targetCommunityId
                targetListId = body.targetListId
                targetSpaceId = body.targetSpaceId
                targetTweetId = body.targetTweetId
                targetUsername = body.targetUsername
                toUser = body.toUser
                untilDate = body.untilDate
                url = body.url
                verifiedOnly = body.verifiedOnly
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

            /**
             * Alternative words or quoted phrases for estimated results. Separate with spaces,
             * commas, or lines.
             */
            fun anyWords(anyWords: String) = anyWords(JsonField.of(anyWords))

            /**
             * Sets [Builder.anyWords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.anyWords] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun anyWords(anyWords: JsonField<String>) = apply { this.anyWords = anyWords }

            /**
             * Geo bounding box used for estimation, e.g. -74.1 40.6 -73.9 40.8
             * (tweet_search_extractor)
             */
            fun boundingBox(boundingBox: String) = boundingBox(JsonField.of(boundingBox))

            /**
             * Sets [Builder.boundingBox] to an arbitrary JSON value.
             *
             * You should usually call [Builder.boundingBox] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun boundingBox(boundingBox: JsonField<String>) = apply {
                this.boundingBox = boundingBox
            }

            /** Cashtags applied to the estimate, separated by spaces, commas, or lines. */
            fun cashtags(cashtags: String) = cashtags(JsonField.of(cashtags))

            /**
             * Sets [Builder.cashtags] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cashtags] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cashtags(cashtags: JsonField<String>) = apply { this.cashtags = cashtags }

            /** Conversation ID filter used for estimation (tweet_search_extractor) */
            fun conversationId(conversationId: String) =
                conversationId(JsonField.of(conversationId))

            /**
             * Sets [Builder.conversationId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.conversationId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun conversationId(conversationId: JsonField<String>) = apply {
                this.conversationId = conversationId
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

            /**
             * Words or quoted phrases excluded from estimated results. Separate with spaces,
             * commas, or lines.
             */
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

            /** Estimate only tweets from this author username (tweet_search_extractor) */
            fun fromUser(fromUser: String) = fromUser(JsonField.of(fromUser))

            /**
             * Sets [Builder.fromUser] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fromUser] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fromUser(fromUser: JsonField<String>) = apply { this.fromUser = fromUser }

            /** Hashtags applied to the estimate, separated by spaces, commas, or lines. */
            fun hashtags(hashtags: String) = hashtags(JsonField.of(hashtags))

            /**
             * Sets [Builder.hashtags] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hashtags] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hashtags(hashtags: JsonField<String>) = apply { this.hashtags = hashtags }

            /** Estimate only replies to this tweet ID (tweet_search_extractor) */
            fun inReplyToTweetId(inReplyToTweetId: String) =
                inReplyToTweetId(JsonField.of(inReplyToTweetId))

            /**
             * Sets [Builder.inReplyToTweetId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inReplyToTweetId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun inReplyToTweetId(inReplyToTweetId: JsonField<String>) = apply {
                this.inReplyToTweetId = inReplyToTweetId
            }

            /** Language code used for estimate filtering (tweet_search_extractor) */
            fun language(language: String) = language(JsonField.of(language))

            /**
             * Sets [Builder.language] to an arbitrary JSON value.
             *
             * You should usually call [Builder.language] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun language(language: JsonField<String>) = apply { this.language = language }

            /** Estimate search results within this list ID (tweet_search_extractor) */
            fun listId(listId: String) = listId(JsonField.of(listId))

            /**
             * Sets [Builder.listId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.listId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun listId(listId: JsonField<String>) = apply { this.listId = listId }

            /** Media type used for estimate filtering (tweet_search_extractor) */
            fun mediaType(mediaType: MediaType) = mediaType(JsonField.of(mediaType))

            /**
             * Sets [Builder.mediaType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mediaType] with a well-typed [MediaType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mediaType(mediaType: JsonField<MediaType>) = apply { this.mediaType = mediaType }

            /** Estimate tweets mentioning this username (tweet_search_extractor) */
            fun mentioning(mentioning: String) = mentioning(JsonField.of(mentioning))

            /**
             * Sets [Builder.mentioning] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mentioning] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mentioning(mentioning: JsonField<String>) = apply { this.mentioning = mentioning }

            /** Minimum likes threshold for estimated results (tweet_search_extractor) */
            fun minFaves(minFaves: Long) = minFaves(JsonField.of(minFaves))

            /**
             * Sets [Builder.minFaves] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minFaves] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minFaves(minFaves: JsonField<Long>) = apply { this.minFaves = minFaves }

            /** Minimum quote count threshold for estimated results (tweet_search_extractor) */
            fun minQuotes(minQuotes: Long) = minQuotes(JsonField.of(minQuotes))

            /**
             * Sets [Builder.minQuotes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minQuotes] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minQuotes(minQuotes: JsonField<Long>) = apply { this.minQuotes = minQuotes }

            /** Minimum replies threshold for estimated results (tweet_search_extractor) */
            fun minReplies(minReplies: Long) = minReplies(JsonField.of(minReplies))

            /**
             * Sets [Builder.minReplies] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minReplies] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minReplies(minReplies: JsonField<Long>) = apply { this.minReplies = minReplies }

            /** Minimum retweets threshold for estimated results (tweet_search_extractor) */
            fun minRetweets(minRetweets: Long) = minRetweets(JsonField.of(minRetweets))

            /**
             * Sets [Builder.minRetweets] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minRetweets] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minRetweets(minRetweets: JsonField<Long>) = apply { this.minRetweets = minRetweets }

            /** Estimate search results within this place ID (tweet_search_extractor) */
            fun place(place: String) = place(JsonField.of(place))

            /**
             * Sets [Builder.place] to an arbitrary JSON value.
             *
             * You should usually call [Builder.place] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun place(place: JsonField<String>) = apply { this.place = place }

            /** Estimate search results within this country code (tweet_search_extractor) */
            fun placeCountry(placeCountry: String) = placeCountry(JsonField.of(placeCountry))

            /**
             * Sets [Builder.placeCountry] to an arbitrary JSON value.
             *
             * You should usually call [Builder.placeCountry] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun placeCountry(placeCountry: JsonField<String>) = apply {
                this.placeCountry = placeCountry
            }

            /**
             * Geo point radius used for estimation, e.g. -73.99 40.73 25mi (tweet_search_extractor)
             */
            fun pointRadius(pointRadius: String) = pointRadius(JsonField.of(pointRadius))

            /**
             * Sets [Builder.pointRadius] to an arbitrary JSON value.
             *
             * You should usually call [Builder.pointRadius] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun pointRadius(pointRadius: JsonField<String>) = apply {
                this.pointRadius = pointRadius
            }

            /** Quote mode used for estimation (tweet_search_extractor) */
            fun quotes(quotes: Quotes) = quotes(JsonField.of(quotes))

            /**
             * Sets [Builder.quotes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.quotes] with a well-typed [Quotes] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun quotes(quotes: JsonField<Quotes>) = apply { this.quotes = quotes }

            /** Estimate only quotes of this tweet ID (tweet_search_extractor) */
            fun quotesOfTweetId(quotesOfTweetId: String) =
                quotesOfTweetId(JsonField.of(quotesOfTweetId))

            /**
             * Sets [Builder.quotesOfTweetId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.quotesOfTweetId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun quotesOfTweetId(quotesOfTweetId: JsonField<String>) = apply {
                this.quotesOfTweetId = quotesOfTweetId
            }

            /** Reply mode used for estimation (tweet_search_extractor) */
            fun replies(replies: Replies) = replies(JsonField.of(replies))

            /**
             * Sets [Builder.replies] to an arbitrary JSON value.
             *
             * You should usually call [Builder.replies] with a well-typed [Replies] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun replies(replies: JsonField<Replies>) = apply { this.replies = replies }

            /**
             * Maximum number of results to estimate. When set, the estimate caps projected results
             * to this value.
             */
            fun resultsLimit(resultsLimit: Long) = resultsLimit(JsonField.of(resultsLimit))

            /**
             * Sets [Builder.resultsLimit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.resultsLimit] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun resultsLimit(resultsLimit: JsonField<Long>) = apply {
                this.resultsLimit = resultsLimit
            }

            /** Retweet mode used for estimation (tweet_search_extractor) */
            fun retweets(retweets: Retweets) = retweets(JsonField.of(retweets))

            /**
             * Sets [Builder.retweets] to an arbitrary JSON value.
             *
             * You should usually call [Builder.retweets] with a well-typed [Retweets] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun retweets(retweets: JsonField<Retweets>) = apply { this.retweets = retweets }

            /** Estimate only retweets of this tweet ID (tweet_search_extractor) */
            fun retweetsOfTweetId(retweetsOfTweetId: String) =
                retweetsOfTweetId(JsonField.of(retweetsOfTweetId))

            /**
             * Sets [Builder.retweetsOfTweetId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.retweetsOfTweetId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun retweetsOfTweetId(retweetsOfTweetId: JsonField<String>) = apply {
                this.retweetsOfTweetId = retweetsOfTweetId
            }

            /** Query used to price tweet_search_extractor or community_search. */
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

            /** Estimate start date in YYYY-MM-DD format (tweet_search_extractor) */
            fun sinceDate(sinceDate: LocalDate) = sinceDate(JsonField.of(sinceDate))

            /**
             * Sets [Builder.sinceDate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sinceDate] with a well-typed [LocalDate] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sinceDate(sinceDate: JsonField<LocalDate>) = apply { this.sinceDate = sinceDate }

            /** Community ID used to price community_post_extractor or community_search. */
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

            /**
             * List ID used to price list_follower_explorer, list_member_extractor, or
             * list_post_extractor.
             */
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

            /** Space ID used to price space_explorer. */
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

            /** Estimate replies sent to this username (tweet_search_extractor) */
            fun toUser(toUser: String) = toUser(JsonField.of(toUser))

            /**
             * Sets [Builder.toUser] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toUser] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun toUser(toUser: JsonField<String>) = apply { this.toUser = toUser }

            /** Estimate end date in YYYY-MM-DD format (tweet_search_extractor) */
            fun untilDate(untilDate: LocalDate) = untilDate(JsonField.of(untilDate))

            /**
             * Sets [Builder.untilDate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.untilDate] with a well-typed [LocalDate] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun untilDate(untilDate: JsonField<LocalDate>) = apply { this.untilDate = untilDate }

            /** URL substring or domain filter used for estimation (tweet_search_extractor) */
            fun url(url: String) = url(JsonField.of(url))

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun url(url: JsonField<String>) = apply { this.url = url }

            /** Estimate only verified authors (tweet_search_extractor) */
            fun verifiedOnly(verifiedOnly: Boolean) = verifiedOnly(JsonField.of(verifiedOnly))

            /**
             * Sets [Builder.verifiedOnly] to an arbitrary JSON value.
             *
             * You should usually call [Builder.verifiedOnly] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun verifiedOnly(verifiedOnly: JsonField<Boolean>) = apply {
                this.verifiedOnly = verifiedOnly
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
                    anyWords,
                    boundingBox,
                    cashtags,
                    conversationId,
                    exactPhrase,
                    excludeWords,
                    fromUser,
                    hashtags,
                    inReplyToTweetId,
                    language,
                    listId,
                    mediaType,
                    mentioning,
                    minFaves,
                    minQuotes,
                    minReplies,
                    minRetweets,
                    place,
                    placeCountry,
                    pointRadius,
                    quotes,
                    quotesOfTweetId,
                    replies,
                    resultsLimit,
                    retweets,
                    retweetsOfTweetId,
                    searchQuery,
                    sinceDate,
                    targetCommunityId,
                    targetListId,
                    targetSpaceId,
                    targetTweetId,
                    targetUsername,
                    toUser,
                    untilDate,
                    url,
                    verifiedOnly,
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

            toolType().validate()
            advancedQuery()
            anyWords()
            boundingBox()
            cashtags()
            conversationId()
            exactPhrase()
            excludeWords()
            fromUser()
            hashtags()
            inReplyToTweetId()
            language()
            listId()
            mediaType().ifPresent { it.validate() }
            mentioning()
            minFaves()
            minQuotes()
            minReplies()
            minRetweets()
            place()
            placeCountry()
            pointRadius()
            quotes().ifPresent { it.validate() }
            quotesOfTweetId()
            replies().ifPresent { it.validate() }
            resultsLimit()
            retweets().ifPresent { it.validate() }
            retweetsOfTweetId()
            searchQuery()
            sinceDate()
            targetCommunityId()
            targetListId()
            targetSpaceId()
            targetTweetId()
            targetUsername()
            toUser()
            untilDate()
            url()
            verifiedOnly()
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
                (if (anyWords.asKnown().isPresent) 1 else 0) +
                (if (boundingBox.asKnown().isPresent) 1 else 0) +
                (if (cashtags.asKnown().isPresent) 1 else 0) +
                (if (conversationId.asKnown().isPresent) 1 else 0) +
                (if (exactPhrase.asKnown().isPresent) 1 else 0) +
                (if (excludeWords.asKnown().isPresent) 1 else 0) +
                (if (fromUser.asKnown().isPresent) 1 else 0) +
                (if (hashtags.asKnown().isPresent) 1 else 0) +
                (if (inReplyToTweetId.asKnown().isPresent) 1 else 0) +
                (if (language.asKnown().isPresent) 1 else 0) +
                (if (listId.asKnown().isPresent) 1 else 0) +
                (mediaType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (mentioning.asKnown().isPresent) 1 else 0) +
                (if (minFaves.asKnown().isPresent) 1 else 0) +
                (if (minQuotes.asKnown().isPresent) 1 else 0) +
                (if (minReplies.asKnown().isPresent) 1 else 0) +
                (if (minRetweets.asKnown().isPresent) 1 else 0) +
                (if (place.asKnown().isPresent) 1 else 0) +
                (if (placeCountry.asKnown().isPresent) 1 else 0) +
                (if (pointRadius.asKnown().isPresent) 1 else 0) +
                (quotes.asKnown().getOrNull()?.validity() ?: 0) +
                (if (quotesOfTweetId.asKnown().isPresent) 1 else 0) +
                (replies.asKnown().getOrNull()?.validity() ?: 0) +
                (if (resultsLimit.asKnown().isPresent) 1 else 0) +
                (retweets.asKnown().getOrNull()?.validity() ?: 0) +
                (if (retweetsOfTweetId.asKnown().isPresent) 1 else 0) +
                (if (searchQuery.asKnown().isPresent) 1 else 0) +
                (if (sinceDate.asKnown().isPresent) 1 else 0) +
                (if (targetCommunityId.asKnown().isPresent) 1 else 0) +
                (if (targetListId.asKnown().isPresent) 1 else 0) +
                (if (targetSpaceId.asKnown().isPresent) 1 else 0) +
                (if (targetTweetId.asKnown().isPresent) 1 else 0) +
                (if (targetUsername.asKnown().isPresent) 1 else 0) +
                (if (toUser.asKnown().isPresent) 1 else 0) +
                (if (untilDate.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0) +
                (if (verifiedOnly.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                toolType == other.toolType &&
                advancedQuery == other.advancedQuery &&
                anyWords == other.anyWords &&
                boundingBox == other.boundingBox &&
                cashtags == other.cashtags &&
                conversationId == other.conversationId &&
                exactPhrase == other.exactPhrase &&
                excludeWords == other.excludeWords &&
                fromUser == other.fromUser &&
                hashtags == other.hashtags &&
                inReplyToTweetId == other.inReplyToTweetId &&
                language == other.language &&
                listId == other.listId &&
                mediaType == other.mediaType &&
                mentioning == other.mentioning &&
                minFaves == other.minFaves &&
                minQuotes == other.minQuotes &&
                minReplies == other.minReplies &&
                minRetweets == other.minRetweets &&
                place == other.place &&
                placeCountry == other.placeCountry &&
                pointRadius == other.pointRadius &&
                quotes == other.quotes &&
                quotesOfTweetId == other.quotesOfTweetId &&
                replies == other.replies &&
                resultsLimit == other.resultsLimit &&
                retweets == other.retweets &&
                retweetsOfTweetId == other.retweetsOfTweetId &&
                searchQuery == other.searchQuery &&
                sinceDate == other.sinceDate &&
                targetCommunityId == other.targetCommunityId &&
                targetListId == other.targetListId &&
                targetSpaceId == other.targetSpaceId &&
                targetTweetId == other.targetTweetId &&
                targetUsername == other.targetUsername &&
                toUser == other.toUser &&
                untilDate == other.untilDate &&
                url == other.url &&
                verifiedOnly == other.verifiedOnly &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                toolType,
                advancedQuery,
                anyWords,
                boundingBox,
                cashtags,
                conversationId,
                exactPhrase,
                excludeWords,
                fromUser,
                hashtags,
                inReplyToTweetId,
                language,
                listId,
                mediaType,
                mentioning,
                minFaves,
                minQuotes,
                minReplies,
                minRetweets,
                place,
                placeCountry,
                pointRadius,
                quotes,
                quotesOfTweetId,
                replies,
                resultsLimit,
                retweets,
                retweetsOfTweetId,
                searchQuery,
                sinceDate,
                targetCommunityId,
                targetListId,
                targetSpaceId,
                targetTweetId,
                targetUsername,
                toUser,
                untilDate,
                url,
                verifiedOnly,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{toolType=$toolType, advancedQuery=$advancedQuery, anyWords=$anyWords, boundingBox=$boundingBox, cashtags=$cashtags, conversationId=$conversationId, exactPhrase=$exactPhrase, excludeWords=$excludeWords, fromUser=$fromUser, hashtags=$hashtags, inReplyToTweetId=$inReplyToTweetId, language=$language, listId=$listId, mediaType=$mediaType, mentioning=$mentioning, minFaves=$minFaves, minQuotes=$minQuotes, minReplies=$minReplies, minRetweets=$minRetweets, place=$place, placeCountry=$placeCountry, pointRadius=$pointRadius, quotes=$quotes, quotesOfTweetId=$quotesOfTweetId, replies=$replies, resultsLimit=$resultsLimit, retweets=$retweets, retweetsOfTweetId=$retweetsOfTweetId, searchQuery=$searchQuery, sinceDate=$sinceDate, targetCommunityId=$targetCommunityId, targetListId=$targetListId, targetSpaceId=$targetSpaceId, targetTweetId=$targetTweetId, targetUsername=$targetUsername, toUser=$toUser, untilDate=$untilDate, url=$url, verifiedOnly=$verifiedOnly, additionalProperties=$additionalProperties}"
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

            @JvmField val FAVORITERS = of("favoriters")

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

            @JvmField val USER_LIKES = of("user_likes")

            @JvmField val USER_MEDIA = of("user_media")

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
            FAVORITERS,
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
            USER_LIKES,
            USER_MEDIA,
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
            FAVORITERS,
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
            USER_LIKES,
            USER_MEDIA,
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
                FAVORITERS -> Value.FAVORITERS
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
                USER_LIKES -> Value.USER_LIKES
                USER_MEDIA -> Value.USER_MEDIA
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
                FAVORITERS -> Known.FAVORITERS
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
                USER_LIKES -> Known.USER_LIKES
                USER_MEDIA -> Known.USER_MEDIA
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
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

    /** Media type used for estimate filtering (tweet_search_extractor) */
    class MediaType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val IMAGES = of("images")

            @JvmField val VIDEOS = of("videos")

            @JvmField val GIFS = of("gifs")

            @JvmField val MEDIA = of("media")

            @JvmField val LINKS = of("links")

            @JvmField val NONE = of("none")

            @JvmStatic fun of(value: String) = MediaType(JsonField.of(value))
        }

        /** An enum containing [MediaType]'s known values. */
        enum class Known {
            IMAGES,
            VIDEOS,
            GIFS,
            MEDIA,
            LINKS,
            NONE,
        }

        /**
         * An enum containing [MediaType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [MediaType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            IMAGES,
            VIDEOS,
            GIFS,
            MEDIA,
            LINKS,
            NONE,
            /**
             * An enum member indicating that [MediaType] was instantiated with an unknown value.
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
                IMAGES -> Value.IMAGES
                VIDEOS -> Value.VIDEOS
                GIFS -> Value.GIFS
                MEDIA -> Value.MEDIA
                LINKS -> Value.LINKS
                NONE -> Value.NONE
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
                IMAGES -> Known.IMAGES
                VIDEOS -> Known.VIDEOS
                GIFS -> Known.GIFS
                MEDIA -> Known.MEDIA
                LINKS -> Known.LINKS
                NONE -> Known.NONE
                else -> throw XTwitterScraperInvalidDataException("Unknown MediaType: $value")
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
        fun validate(): MediaType = apply {
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

            return other is MediaType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Quote mode used for estimation (tweet_search_extractor) */
    class Quotes @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val INCLUDE = of("include")

            @JvmField val EXCLUDE = of("exclude")

            @JvmField val ONLY = of("only")

            @JvmStatic fun of(value: String) = Quotes(JsonField.of(value))
        }

        /** An enum containing [Quotes]'s known values. */
        enum class Known {
            INCLUDE,
            EXCLUDE,
            ONLY,
        }

        /**
         * An enum containing [Quotes]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Quotes] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            INCLUDE,
            EXCLUDE,
            ONLY,
            /** An enum member indicating that [Quotes] was instantiated with an unknown value. */
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
                INCLUDE -> Value.INCLUDE
                EXCLUDE -> Value.EXCLUDE
                ONLY -> Value.ONLY
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
                INCLUDE -> Known.INCLUDE
                EXCLUDE -> Known.EXCLUDE
                ONLY -> Known.ONLY
                else -> throw XTwitterScraperInvalidDataException("Unknown Quotes: $value")
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
        fun validate(): Quotes = apply {
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

            return other is Quotes && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Reply mode used for estimation (tweet_search_extractor) */
    class Replies @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val INCLUDE = of("include")

            @JvmField val EXCLUDE = of("exclude")

            @JvmField val ONLY = of("only")

            @JvmStatic fun of(value: String) = Replies(JsonField.of(value))
        }

        /** An enum containing [Replies]'s known values. */
        enum class Known {
            INCLUDE,
            EXCLUDE,
            ONLY,
        }

        /**
         * An enum containing [Replies]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Replies] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            INCLUDE,
            EXCLUDE,
            ONLY,
            /** An enum member indicating that [Replies] was instantiated with an unknown value. */
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
                INCLUDE -> Value.INCLUDE
                EXCLUDE -> Value.EXCLUDE
                ONLY -> Value.ONLY
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
                INCLUDE -> Known.INCLUDE
                EXCLUDE -> Known.EXCLUDE
                ONLY -> Known.ONLY
                else -> throw XTwitterScraperInvalidDataException("Unknown Replies: $value")
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
        fun validate(): Replies = apply {
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

            return other is Replies && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Retweet mode used for estimation (tweet_search_extractor) */
    class Retweets @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val INCLUDE = of("include")

            @JvmField val EXCLUDE = of("exclude")

            @JvmField val ONLY = of("only")

            @JvmStatic fun of(value: String) = Retweets(JsonField.of(value))
        }

        /** An enum containing [Retweets]'s known values. */
        enum class Known {
            INCLUDE,
            EXCLUDE,
            ONLY,
        }

        /**
         * An enum containing [Retweets]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Retweets] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            INCLUDE,
            EXCLUDE,
            ONLY,
            /** An enum member indicating that [Retweets] was instantiated with an unknown value. */
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
                INCLUDE -> Value.INCLUDE
                EXCLUDE -> Value.EXCLUDE
                ONLY -> Value.ONLY
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
                INCLUDE -> Known.INCLUDE
                EXCLUDE -> Known.EXCLUDE
                ONLY -> Known.ONLY
                else -> throw XTwitterScraperInvalidDataException("Unknown Retweets: $value")
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
        fun validate(): Retweets = apply {
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

            return other is Retweets && value == other.value
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
