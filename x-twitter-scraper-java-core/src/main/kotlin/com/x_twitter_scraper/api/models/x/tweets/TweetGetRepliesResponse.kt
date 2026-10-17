// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.SearchTweet
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Direct reply rows. No-mode requests use resumable automatic coverage. Complete mode also returns
 * nested replies and coverage diagnostics. Keep nested replies separate from direct coverage.
 */
class TweetGetRepliesResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val hasNextPage: JsonField<Boolean>,
    private val nextCursor: JsonField<String>,
    private val tweets: JsonField<List<SearchTweet>>,
    private val diagnostic: JsonField<Diagnostic>,
    private val filteredCount: JsonField<Long>,
    private val hiddenReplies: JsonField<Long>,
    private val limitReached: JsonField<Boolean>,
    private val message: JsonField<String>,
    private val nestedReplies: JsonField<List<SearchTweet>>,
    private val orderPartial: JsonField<Boolean>,
    private val partialBefore: JsonField<OffsetDateTime>,
    private val readBackTo: JsonField<OffsetDateTime>,
    private val searchContext: JsonField<PaginatedTweets.SearchContext>,
    private val searchedQuery: JsonField<String>,
    private val windowComplete: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("has_next_page")
        @ExcludeMissing
        hasNextPage: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("next_cursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tweets")
        @ExcludeMissing
        tweets: JsonField<List<SearchTweet>> = JsonMissing.of(),
        @JsonProperty("diagnostic")
        @ExcludeMissing
        diagnostic: JsonField<Diagnostic> = JsonMissing.of(),
        @JsonProperty("filtered_count")
        @ExcludeMissing
        filteredCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("hiddenReplies")
        @ExcludeMissing
        hiddenReplies: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("limit_reached")
        @ExcludeMissing
        limitReached: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        @JsonProperty("nested_replies")
        @ExcludeMissing
        nestedReplies: JsonField<List<SearchTweet>> = JsonMissing.of(),
        @JsonProperty("orderPartial")
        @ExcludeMissing
        orderPartial: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("partialBefore")
        @ExcludeMissing
        partialBefore: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("readBackTo")
        @ExcludeMissing
        readBackTo: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("searchContext")
        @ExcludeMissing
        searchContext: JsonField<PaginatedTweets.SearchContext> = JsonMissing.of(),
        @JsonProperty("searchedQuery")
        @ExcludeMissing
        searchedQuery: JsonField<String> = JsonMissing.of(),
        @JsonProperty("windowComplete")
        @ExcludeMissing
        windowComplete: JsonField<Boolean> = JsonMissing.of(),
    ) : this(
        hasNextPage,
        nextCursor,
        tweets,
        diagnostic,
        filteredCount,
        hiddenReplies,
        limitReached,
        message,
        nestedReplies,
        orderPartial,
        partialBefore,
        readBackTo,
        searchContext,
        searchedQuery,
        windowComplete,
        mutableMapOf(),
    )

    fun toPaginatedTweets(): PaginatedTweets =
        PaginatedTweets.builder()
            .hasNextPage(hasNextPage)
            .nextCursor(nextCursor)
            .tweets(tweets)
            .filteredCount(filteredCount)
            .readBackTo(readBackTo)
            .searchContext(searchContext)
            .searchedQuery(searchedQuery)
            .windowComplete(windowComplete)
            .build()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun hasNextPage(): Boolean = hasNextPage.getRequired("has_next_page")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun nextCursor(): String = nextCursor.getRequired("next_cursor")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun tweets(): List<SearchTweet> = tweets.getRequired("tweets")

    /**
     * Evidence for direct-reply coverage and collector behavior.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun diagnostic(): Optional<Diagnostic> = diagnostic.getOptional("diagnostic")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun filteredCount(): Optional<Long> = filteredCount.getOptional("filtered_count")

    /**
     * Present on the last automatic page, and on a complete-mode answer without rows. X counts this
     * many more replies but shows them to nobody. They may be hidden, protected or deleted. A retry
     * returns the same replies.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun hiddenReplies(): Optional<Long> = hiddenReplies.getOptional("hiddenReplies")

    /**
     * Present when your limit cut a complete-mode answer. The post has more replies. Raise limit to
     * get them all.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun limitReached(): Optional<Boolean> = limitReached.getOptional("limit_reached")

    /**
     * Explains an answer cut by your limit.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun message(): Optional<String> = message.getOptional("message")

    /**
     * Nested replies. Excluded from direct coverage.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun nestedReplies(): Optional<List<SearchTweet>> = nestedReplies.getOptional("nested_replies")

    /**
     * Present with latest or oldest sort. The read stopped before it held every reply X shows. Rows
     * stay sorted by date, but replies may be missing between them. Retry later for a gap-free
     * order. Complete mode and automatic pages set it alike.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun orderPartial(): Optional<Boolean> = orderPartial.getOptional("orderPartial")

    /**
     * Present on an answer that lacks replies of a large thread posted before this time. X shows
     * only part of the replies older than 7 days. A retry returns about the same replies.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun partialBefore(): Optional<OffsetDateTime> = partialBefore.getOptional("partialBefore")

    /**
     * How far back a filtered Latest search has read, in UTC. Xquik checked every newer post, so an
     * empty page still moves this time back.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun readBackTo(): Optional<OffsetDateTime> = readBackTo.getOptional("readBackTo")

    /**
     * What X shows beside a search's posts that is the same for every reader. Present on a search
     * for a cashtag X has a card for, such as $BTC.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun searchContext(): Optional<PaginatedTweets.SearchContext> =
        searchContext.getOptional("searchContext")

    /**
     * Search q as X ran it, when Xquik fixed it.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun searchedQuery(): Optional<String> = searchedQuery.getOptional("searchedQuery")

    /**
     * Present on a last page whose sources all read past its start time.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun windowComplete(): Optional<Boolean> = windowComplete.getOptional("windowComplete")

    /**
     * Returns the raw JSON value of [hasNextPage].
     *
     * Unlike [hasNextPage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("has_next_page")
    @ExcludeMissing
    fun _hasNextPage(): JsonField<Boolean> = hasNextPage

    /**
     * Returns the raw JSON value of [nextCursor].
     *
     * Unlike [nextCursor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("next_cursor") @ExcludeMissing fun _nextCursor(): JsonField<String> = nextCursor

    /**
     * Returns the raw JSON value of [tweets].
     *
     * Unlike [tweets], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tweets") @ExcludeMissing fun _tweets(): JsonField<List<SearchTweet>> = tweets

    /**
     * Returns the raw JSON value of [diagnostic].
     *
     * Unlike [diagnostic], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("diagnostic")
    @ExcludeMissing
    fun _diagnostic(): JsonField<Diagnostic> = diagnostic

    /**
     * Returns the raw JSON value of [filteredCount].
     *
     * Unlike [filteredCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("filtered_count")
    @ExcludeMissing
    fun _filteredCount(): JsonField<Long> = filteredCount

    /**
     * Returns the raw JSON value of [hiddenReplies].
     *
     * Unlike [hiddenReplies], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hiddenReplies")
    @ExcludeMissing
    fun _hiddenReplies(): JsonField<Long> = hiddenReplies

    /**
     * Returns the raw JSON value of [limitReached].
     *
     * Unlike [limitReached], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("limit_reached")
    @ExcludeMissing
    fun _limitReached(): JsonField<Boolean> = limitReached

    /**
     * Returns the raw JSON value of [message].
     *
     * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

    /**
     * Returns the raw JSON value of [nestedReplies].
     *
     * Unlike [nestedReplies], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("nested_replies")
    @ExcludeMissing
    fun _nestedReplies(): JsonField<List<SearchTweet>> = nestedReplies

    /**
     * Returns the raw JSON value of [orderPartial].
     *
     * Unlike [orderPartial], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("orderPartial")
    @ExcludeMissing
    fun _orderPartial(): JsonField<Boolean> = orderPartial

    /**
     * Returns the raw JSON value of [partialBefore].
     *
     * Unlike [partialBefore], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("partialBefore")
    @ExcludeMissing
    fun _partialBefore(): JsonField<OffsetDateTime> = partialBefore

    /**
     * Returns the raw JSON value of [readBackTo].
     *
     * Unlike [readBackTo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("readBackTo")
    @ExcludeMissing
    fun _readBackTo(): JsonField<OffsetDateTime> = readBackTo

    /**
     * Returns the raw JSON value of [searchContext].
     *
     * Unlike [searchContext], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("searchContext")
    @ExcludeMissing
    fun _searchContext(): JsonField<PaginatedTweets.SearchContext> = searchContext

    /**
     * Returns the raw JSON value of [searchedQuery].
     *
     * Unlike [searchedQuery], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("searchedQuery")
    @ExcludeMissing
    fun _searchedQuery(): JsonField<String> = searchedQuery

    /**
     * Returns the raw JSON value of [windowComplete].
     *
     * Unlike [windowComplete], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("windowComplete")
    @ExcludeMissing
    fun _windowComplete(): JsonField<Boolean> = windowComplete

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
         * Returns a mutable builder for constructing an instance of [TweetGetRepliesResponse].
         *
         * The following fields are required:
         * ```java
         * .hasNextPage()
         * .nextCursor()
         * .tweets()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetGetRepliesResponse]. */
    class Builder internal constructor() {

        private var hasNextPage: JsonField<Boolean>? = null
        private var nextCursor: JsonField<String>? = null
        private var tweets: JsonField<MutableList<SearchTweet>>? = null
        private var diagnostic: JsonField<Diagnostic> = JsonMissing.of()
        private var filteredCount: JsonField<Long> = JsonMissing.of()
        private var hiddenReplies: JsonField<Long> = JsonMissing.of()
        private var limitReached: JsonField<Boolean> = JsonMissing.of()
        private var message: JsonField<String> = JsonMissing.of()
        private var nestedReplies: JsonField<MutableList<SearchTweet>>? = null
        private var orderPartial: JsonField<Boolean> = JsonMissing.of()
        private var partialBefore: JsonField<OffsetDateTime> = JsonMissing.of()
        private var readBackTo: JsonField<OffsetDateTime> = JsonMissing.of()
        private var searchContext: JsonField<PaginatedTweets.SearchContext> = JsonMissing.of()
        private var searchedQuery: JsonField<String> = JsonMissing.of()
        private var windowComplete: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tweetGetRepliesResponse: TweetGetRepliesResponse) = apply {
            hasNextPage = tweetGetRepliesResponse.hasNextPage
            nextCursor = tweetGetRepliesResponse.nextCursor
            tweets = tweetGetRepliesResponse.tweets.map { it.toMutableList() }
            diagnostic = tweetGetRepliesResponse.diagnostic
            filteredCount = tweetGetRepliesResponse.filteredCount
            hiddenReplies = tweetGetRepliesResponse.hiddenReplies
            limitReached = tweetGetRepliesResponse.limitReached
            message = tweetGetRepliesResponse.message
            nestedReplies = tweetGetRepliesResponse.nestedReplies.map { it.toMutableList() }
            orderPartial = tweetGetRepliesResponse.orderPartial
            partialBefore = tweetGetRepliesResponse.partialBefore
            readBackTo = tweetGetRepliesResponse.readBackTo
            searchContext = tweetGetRepliesResponse.searchContext
            searchedQuery = tweetGetRepliesResponse.searchedQuery
            windowComplete = tweetGetRepliesResponse.windowComplete
            additionalProperties = tweetGetRepliesResponse.additionalProperties.toMutableMap()
        }

        fun hasNextPage(hasNextPage: Boolean) = hasNextPage(JsonField.of(hasNextPage))

        /** Sets [Builder.hasNextPage] to an arbitrary JSON value. */
        fun hasNextPage(hasNextPage: JsonField<Boolean>) = apply { this.hasNextPage = hasNextPage }

        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /** Sets [Builder.nextCursor] to an arbitrary JSON value. */
        fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

        fun tweets(tweets: List<SearchTweet>) = tweets(JsonField.of(tweets))

        /** Sets [Builder.tweets] to an arbitrary JSON value. */
        fun tweets(tweets: JsonField<List<SearchTweet>>) = apply {
            this.tweets = tweets.map { it.toMutableList() }
        }

        /**
         * Adds a single [SearchTweet] to [tweets].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTweet(tweet: SearchTweet) = apply {
            tweets =
                (tweets ?: JsonField.of(mutableListOf())).also {
                    checkKnown("tweets", it).add(tweet)
                }
        }

        /** Evidence for direct-reply coverage and collector behavior. */
        fun diagnostic(diagnostic: Diagnostic) = diagnostic(JsonField.of(diagnostic))

        /** Sets [Builder.diagnostic] to an arbitrary JSON value. */
        fun diagnostic(diagnostic: JsonField<Diagnostic>) = apply { this.diagnostic = diagnostic }

        fun filteredCount(filteredCount: Long) = filteredCount(JsonField.of(filteredCount))

        /** Sets [Builder.filteredCount] to an arbitrary JSON value. */
        fun filteredCount(filteredCount: JsonField<Long>) = apply {
            this.filteredCount = filteredCount
        }

        /**
         * Present on the last automatic page, and on a complete-mode answer without rows. X counts
         * this many more replies but shows them to nobody. They may be hidden, protected or
         * deleted. A retry returns the same replies.
         */
        fun hiddenReplies(hiddenReplies: Long) = hiddenReplies(JsonField.of(hiddenReplies))

        /** Sets [Builder.hiddenReplies] to an arbitrary JSON value. */
        fun hiddenReplies(hiddenReplies: JsonField<Long>) = apply {
            this.hiddenReplies = hiddenReplies
        }

        /**
         * Present when your limit cut a complete-mode answer. The post has more replies. Raise
         * limit to get them all.
         */
        fun limitReached(limitReached: Boolean) = limitReached(JsonField.of(limitReached))

        /** Sets [Builder.limitReached] to an arbitrary JSON value. */
        fun limitReached(limitReached: JsonField<Boolean>) = apply {
            this.limitReached = limitReached
        }

        /** Explains an answer cut by your limit. */
        fun message(message: String) = message(JsonField.of(message))

        /** Sets [Builder.message] to an arbitrary JSON value. */
        fun message(message: JsonField<String>) = apply { this.message = message }

        /** Nested replies. Excluded from direct coverage. */
        fun nestedReplies(nestedReplies: List<SearchTweet>) =
            nestedReplies(JsonField.of(nestedReplies))

        /** Sets [Builder.nestedReplies] to an arbitrary JSON value. */
        fun nestedReplies(nestedReplies: JsonField<List<SearchTweet>>) = apply {
            this.nestedReplies = nestedReplies.map { it.toMutableList() }
        }

        /**
         * Adds a single [SearchTweet] to [nestedReplies].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addNestedReply(nestedReply: SearchTweet) = apply {
            nestedReplies =
                (nestedReplies ?: JsonField.of(mutableListOf())).also {
                    checkKnown("nestedReplies", it).add(nestedReply)
                }
        }

        /**
         * Present with latest or oldest sort. The read stopped before it held every reply X shows.
         * Rows stay sorted by date, but replies may be missing between them. Retry later for a
         * gap-free order. Complete mode and automatic pages set it alike.
         */
        fun orderPartial(orderPartial: Boolean) = orderPartial(JsonField.of(orderPartial))

        /** Sets [Builder.orderPartial] to an arbitrary JSON value. */
        fun orderPartial(orderPartial: JsonField<Boolean>) = apply {
            this.orderPartial = orderPartial
        }

        /**
         * Present on an answer that lacks replies of a large thread posted before this time. X
         * shows only part of the replies older than 7 days. A retry returns about the same replies.
         */
        fun partialBefore(partialBefore: OffsetDateTime) =
            partialBefore(JsonField.of(partialBefore))

        /** Sets [Builder.partialBefore] to an arbitrary JSON value. */
        fun partialBefore(partialBefore: JsonField<OffsetDateTime>) = apply {
            this.partialBefore = partialBefore
        }

        /**
         * How far back a filtered Latest search has read, in UTC. Xquik checked every newer post,
         * so an empty page still moves this time back.
         */
        fun readBackTo(readBackTo: OffsetDateTime) = readBackTo(JsonField.of(readBackTo))

        /** Sets [Builder.readBackTo] to an arbitrary JSON value. */
        fun readBackTo(readBackTo: JsonField<OffsetDateTime>) = apply {
            this.readBackTo = readBackTo
        }

        /**
         * What X shows beside a search's posts that is the same for every reader. Present on a
         * search for a cashtag X has a card for, such as $BTC.
         */
        fun searchContext(searchContext: PaginatedTweets.SearchContext) =
            searchContext(JsonField.of(searchContext))

        /** Sets [Builder.searchContext] to an arbitrary JSON value. */
        fun searchContext(searchContext: JsonField<PaginatedTweets.SearchContext>) = apply {
            this.searchContext = searchContext
        }

        /** Search q as X ran it, when Xquik fixed it. */
        fun searchedQuery(searchedQuery: String) = searchedQuery(JsonField.of(searchedQuery))

        /** Sets [Builder.searchedQuery] to an arbitrary JSON value. */
        fun searchedQuery(searchedQuery: JsonField<String>) = apply {
            this.searchedQuery = searchedQuery
        }

        /** Present on a last page whose sources all read past its start time. */
        fun windowComplete(windowComplete: Boolean) = windowComplete(JsonField.of(windowComplete))

        /** Sets [Builder.windowComplete] to an arbitrary JSON value. */
        fun windowComplete(windowComplete: JsonField<Boolean>) = apply {
            this.windowComplete = windowComplete
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
         * Returns an immutable instance of [TweetGetRepliesResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .hasNextPage()
         * .nextCursor()
         * .tweets()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TweetGetRepliesResponse =
            TweetGetRepliesResponse(
                checkRequired("hasNextPage", hasNextPage),
                checkRequired("nextCursor", nextCursor),
                checkRequired("tweets", tweets).map { it.toImmutable() },
                diagnostic,
                filteredCount,
                hiddenReplies,
                limitReached,
                message,
                (nestedReplies ?: JsonMissing.of()).map { it.toImmutable() },
                orderPartial,
                partialBefore,
                readBackTo,
                searchContext,
                searchedQuery,
                windowComplete,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match
     *   its expected type.
     */
    fun validate(): TweetGetRepliesResponse = apply {
        if (validated) {
            return@apply
        }

        hasNextPage()
        nextCursor()
        tweets().forEach { it.validate() }
        diagnostic().ifPresent { it.validate() }
        filteredCount()
        hiddenReplies()
        limitReached()
        message()
        nestedReplies().ifPresent { it.forEach { it.validate() } }
        orderPartial()
        partialBefore()
        readBackTo()
        searchContext().ifPresent { it.validate() }
        searchedQuery()
        windowComplete()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    @JvmSynthetic
    internal fun validity(): Int =
        (if (hasNextPage.asKnown().isPresent) 1 else 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0) +
            (tweets.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (diagnostic.asKnown().getOrNull()?.validity() ?: 0) +
            (if (filteredCount.asKnown().isPresent) 1 else 0) +
            (if (hiddenReplies.asKnown().isPresent) 1 else 0) +
            (if (limitReached.asKnown().isPresent) 1 else 0) +
            (if (message.asKnown().isPresent) 1 else 0) +
            (nestedReplies.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (orderPartial.asKnown().isPresent) 1 else 0) +
            (if (partialBefore.asKnown().isPresent) 1 else 0) +
            (if (readBackTo.asKnown().isPresent) 1 else 0) +
            (searchContext.asKnown().getOrNull()?.validity() ?: 0) +
            (if (searchedQuery.asKnown().isPresent) 1 else 0) +
            (if (windowComplete.asKnown().isPresent) 1 else 0)

    /** Evidence for direct-reply coverage and collector behavior. */
    class Diagnostic
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val complete: JsonField<Boolean>,
        private val coveragePercentage: JsonField<Double>,
        private val cursorFailures: JsonField<Long>,
        private val duplicateCount: JsonField<Long>,
        private val emptyFalseProgressPages: JsonField<Long>,
        private val malformedCount: JsonField<Long>,
        private val missingResponseModulesOrFields: JsonField<List<String>>,
        private val nestedReplyCount: JsonField<Long>,
        private val pagesAttempted: JsonField<Long>,
        private val recommendedFallback: JsonField<String>,
        private val repeatedCursorCount: JsonField<Long>,
        private val reportedReplyCount: JsonField<Long>,
        private val responseTruncated: JsonField<Boolean>,
        private val richness: JsonField<Richness>,
        private val strategiesAttempted: JsonField<List<StrategiesAttempted>>,
        private val targetDirectReplies: JsonField<Long>,
        private val uniqueDirectReplies: JsonField<Long>,
        private val unrelatedCount: JsonField<Long>,
        private val replyScopeComplete: JsonField<Boolean>,
        private val replyTreeComplete: JsonField<Boolean>,
        private val sourcesEnded: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("complete")
            @ExcludeMissing
            complete: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("coveragePercentage")
            @ExcludeMissing
            coveragePercentage: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("cursorFailures")
            @ExcludeMissing
            cursorFailures: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("duplicateCount")
            @ExcludeMissing
            duplicateCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("emptyFalseProgressPages")
            @ExcludeMissing
            emptyFalseProgressPages: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("malformedCount")
            @ExcludeMissing
            malformedCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("missingResponseModulesOrFields")
            @ExcludeMissing
            missingResponseModulesOrFields: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("nestedReplyCount")
            @ExcludeMissing
            nestedReplyCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("pagesAttempted")
            @ExcludeMissing
            pagesAttempted: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("recommendedFallback")
            @ExcludeMissing
            recommendedFallback: JsonField<String> = JsonMissing.of(),
            @JsonProperty("repeatedCursorCount")
            @ExcludeMissing
            repeatedCursorCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("reportedReplyCount")
            @ExcludeMissing
            reportedReplyCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("responseTruncated")
            @ExcludeMissing
            responseTruncated: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("richness")
            @ExcludeMissing
            richness: JsonField<Richness> = JsonMissing.of(),
            @JsonProperty("strategiesAttempted")
            @ExcludeMissing
            strategiesAttempted: JsonField<List<StrategiesAttempted>> = JsonMissing.of(),
            @JsonProperty("targetDirectReplies")
            @ExcludeMissing
            targetDirectReplies: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("uniqueDirectReplies")
            @ExcludeMissing
            uniqueDirectReplies: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("unrelatedCount")
            @ExcludeMissing
            unrelatedCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("replyScopeComplete")
            @ExcludeMissing
            replyScopeComplete: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("replyTreeComplete")
            @ExcludeMissing
            replyTreeComplete: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("sourcesEnded")
            @ExcludeMissing
            sourcesEnded: JsonField<Boolean> = JsonMissing.of(),
        ) : this(
            complete,
            coveragePercentage,
            cursorFailures,
            duplicateCount,
            emptyFalseProgressPages,
            malformedCount,
            missingResponseModulesOrFields,
            nestedReplyCount,
            pagesAttempted,
            recommendedFallback,
            repeatedCursorCount,
            reportedReplyCount,
            responseTruncated,
            richness,
            strategiesAttempted,
            targetDirectReplies,
            uniqueDirectReplies,
            unrelatedCount,
            replyScopeComplete,
            replyTreeComplete,
            sourcesEnded,
            mutableMapOf(),
        )

        /**
         * Whether coverage met the target without truncation.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun complete(): Boolean = complete.getRequired("complete")

        /**
         * Unique direct replies as a percentage of the reported count.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun coveragePercentage(): Double = coveragePercentage.getRequired("coveragePercentage")

        /**
         * Cursor requests that failed.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun cursorFailures(): Long = cursorFailures.getRequired("cursorFailures")

        /**
         * Duplicate tweet IDs removed across pages and strategies.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun duplicateCount(): Long = duplicateCount.getRequired("duplicateCount")

        /**
         * Empty pages rejected because they did not make progress.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun emptyFalseProgressPages(): Long =
            emptyFalseProgressPages.getRequired("emptyFalseProgressPages")

        /**
         * Malformed response items rejected.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun malformedCount(): Long = malformedCount.getRequired("malformedCount")

        /**
         * Expected response modules or fields missing from X.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun missingResponseModulesOrFields(): List<String> =
            missingResponseModulesOrFields.getRequired("missingResponseModulesOrFields")

        /**
         * Unique nested replies kept outside direct coverage.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun nestedReplyCount(): Long = nestedReplyCount.getRequired("nestedReplyCount")

        /**
         * Total pages attempted across all strategies.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun pagesAttempted(): Long = pagesAttempted.getRequired("pagesAttempted")

        /**
         * Recommended next action when coverage is incomplete.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun recommendedFallback(): String = recommendedFallback.getRequired("recommendedFallback")

        /**
         * Repeated cursors rejected to prevent loops.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun repeatedCursorCount(): Long = repeatedCursorCount.getRequired("repeatedCursorCount")

        /**
         * Reply count reported on the source post.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun reportedReplyCount(): Long = reportedReplyCount.getRequired("reportedReplyCount")

        /**
         * Whether the requested row limit truncated safe results.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun responseTruncated(): Boolean = responseTruncated.getRequired("responseTruncated")

        /**
         * Field-presence counts across the collected direct replies.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun richness(): Richness = richness.getRequired("richness")

        /**
         * Per-strategy pagination and contribution evidence.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun strategiesAttempted(): List<StrategiesAttempted> =
            strategiesAttempted.getRequired("strategiesAttempted")

        /**
         * Minimum direct replies required for the coverage target.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun targetDirectReplies(): Long = targetDirectReplies.getRequired("targetDirectReplies")

        /**
         * Unique replies whose parent ID equals the source post ID.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun uniqueDirectReplies(): Long = uniqueDirectReplies.getRequired("uniqueDirectReplies")

        /**
         * Tweets rejected because they belonged elsewhere.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun unrelatedCount(): Long = unrelatedCount.getRequired("unrelatedCount")

        /**
         * Replies are accounted for through the requested scope & depth. Source errors remain
         * separate.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun replyScopeComplete(): Optional<Boolean> =
            replyScopeComplete.getOptional("replyScopeComplete")

        /**
         * All child counts are known & match collected replies.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun replyTreeComplete(): Optional<Boolean> =
            replyTreeComplete.getOptional("replyTreeComplete")

        /**
         * Every source ended, or no reply view shows a reply. A retry returns the same rows.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun sourcesEnded(): Optional<Boolean> = sourcesEnded.getOptional("sourcesEnded")

        /**
         * Returns the raw JSON value of [complete].
         *
         * Unlike [complete], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("complete") @ExcludeMissing fun _complete(): JsonField<Boolean> = complete

        /**
         * Returns the raw JSON value of [coveragePercentage].
         *
         * Unlike [coveragePercentage], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("coveragePercentage")
        @ExcludeMissing
        fun _coveragePercentage(): JsonField<Double> = coveragePercentage

        /**
         * Returns the raw JSON value of [cursorFailures].
         *
         * Unlike [cursorFailures], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("cursorFailures")
        @ExcludeMissing
        fun _cursorFailures(): JsonField<Long> = cursorFailures

        /**
         * Returns the raw JSON value of [duplicateCount].
         *
         * Unlike [duplicateCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("duplicateCount")
        @ExcludeMissing
        fun _duplicateCount(): JsonField<Long> = duplicateCount

        /**
         * Returns the raw JSON value of [emptyFalseProgressPages].
         *
         * Unlike [emptyFalseProgressPages], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("emptyFalseProgressPages")
        @ExcludeMissing
        fun _emptyFalseProgressPages(): JsonField<Long> = emptyFalseProgressPages

        /**
         * Returns the raw JSON value of [malformedCount].
         *
         * Unlike [malformedCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("malformedCount")
        @ExcludeMissing
        fun _malformedCount(): JsonField<Long> = malformedCount

        /**
         * Returns the raw JSON value of [missingResponseModulesOrFields].
         *
         * Unlike [missingResponseModulesOrFields], this method doesn't throw if the JSON field has
         * an unexpected type.
         */
        @JsonProperty("missingResponseModulesOrFields")
        @ExcludeMissing
        fun _missingResponseModulesOrFields(): JsonField<List<String>> =
            missingResponseModulesOrFields

        /**
         * Returns the raw JSON value of [nestedReplyCount].
         *
         * Unlike [nestedReplyCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("nestedReplyCount")
        @ExcludeMissing
        fun _nestedReplyCount(): JsonField<Long> = nestedReplyCount

        /**
         * Returns the raw JSON value of [pagesAttempted].
         *
         * Unlike [pagesAttempted], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("pagesAttempted")
        @ExcludeMissing
        fun _pagesAttempted(): JsonField<Long> = pagesAttempted

        /**
         * Returns the raw JSON value of [recommendedFallback].
         *
         * Unlike [recommendedFallback], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("recommendedFallback")
        @ExcludeMissing
        fun _recommendedFallback(): JsonField<String> = recommendedFallback

        /**
         * Returns the raw JSON value of [repeatedCursorCount].
         *
         * Unlike [repeatedCursorCount], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("repeatedCursorCount")
        @ExcludeMissing
        fun _repeatedCursorCount(): JsonField<Long> = repeatedCursorCount

        /**
         * Returns the raw JSON value of [reportedReplyCount].
         *
         * Unlike [reportedReplyCount], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("reportedReplyCount")
        @ExcludeMissing
        fun _reportedReplyCount(): JsonField<Long> = reportedReplyCount

        /**
         * Returns the raw JSON value of [responseTruncated].
         *
         * Unlike [responseTruncated], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("responseTruncated")
        @ExcludeMissing
        fun _responseTruncated(): JsonField<Boolean> = responseTruncated

        /**
         * Returns the raw JSON value of [richness].
         *
         * Unlike [richness], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("richness") @ExcludeMissing fun _richness(): JsonField<Richness> = richness

        /**
         * Returns the raw JSON value of [strategiesAttempted].
         *
         * Unlike [strategiesAttempted], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("strategiesAttempted")
        @ExcludeMissing
        fun _strategiesAttempted(): JsonField<List<StrategiesAttempted>> = strategiesAttempted

        /**
         * Returns the raw JSON value of [targetDirectReplies].
         *
         * Unlike [targetDirectReplies], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("targetDirectReplies")
        @ExcludeMissing
        fun _targetDirectReplies(): JsonField<Long> = targetDirectReplies

        /**
         * Returns the raw JSON value of [uniqueDirectReplies].
         *
         * Unlike [uniqueDirectReplies], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("uniqueDirectReplies")
        @ExcludeMissing
        fun _uniqueDirectReplies(): JsonField<Long> = uniqueDirectReplies

        /**
         * Returns the raw JSON value of [unrelatedCount].
         *
         * Unlike [unrelatedCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("unrelatedCount")
        @ExcludeMissing
        fun _unrelatedCount(): JsonField<Long> = unrelatedCount

        /**
         * Returns the raw JSON value of [replyScopeComplete].
         *
         * Unlike [replyScopeComplete], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("replyScopeComplete")
        @ExcludeMissing
        fun _replyScopeComplete(): JsonField<Boolean> = replyScopeComplete

        /**
         * Returns the raw JSON value of [replyTreeComplete].
         *
         * Unlike [replyTreeComplete], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("replyTreeComplete")
        @ExcludeMissing
        fun _replyTreeComplete(): JsonField<Boolean> = replyTreeComplete

        /**
         * Returns the raw JSON value of [sourcesEnded].
         *
         * Unlike [sourcesEnded], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("sourcesEnded")
        @ExcludeMissing
        fun _sourcesEnded(): JsonField<Boolean> = sourcesEnded

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
             * Returns a mutable builder for constructing an instance of [Diagnostic].
             *
             * The following fields are required:
             * ```java
             * .complete()
             * .coveragePercentage()
             * .cursorFailures()
             * .duplicateCount()
             * .emptyFalseProgressPages()
             * .malformedCount()
             * .missingResponseModulesOrFields()
             * .nestedReplyCount()
             * .pagesAttempted()
             * .recommendedFallback()
             * .repeatedCursorCount()
             * .reportedReplyCount()
             * .responseTruncated()
             * .richness()
             * .strategiesAttempted()
             * .targetDirectReplies()
             * .uniqueDirectReplies()
             * .unrelatedCount()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Diagnostic]. */
        class Builder internal constructor() {

            private var complete: JsonField<Boolean>? = null
            private var coveragePercentage: JsonField<Double>? = null
            private var cursorFailures: JsonField<Long>? = null
            private var duplicateCount: JsonField<Long>? = null
            private var emptyFalseProgressPages: JsonField<Long>? = null
            private var malformedCount: JsonField<Long>? = null
            private var missingResponseModulesOrFields: JsonField<MutableList<String>>? = null
            private var nestedReplyCount: JsonField<Long>? = null
            private var pagesAttempted: JsonField<Long>? = null
            private var recommendedFallback: JsonField<String>? = null
            private var repeatedCursorCount: JsonField<Long>? = null
            private var reportedReplyCount: JsonField<Long>? = null
            private var responseTruncated: JsonField<Boolean>? = null
            private var richness: JsonField<Richness>? = null
            private var strategiesAttempted: JsonField<MutableList<StrategiesAttempted>>? = null
            private var targetDirectReplies: JsonField<Long>? = null
            private var uniqueDirectReplies: JsonField<Long>? = null
            private var unrelatedCount: JsonField<Long>? = null
            private var replyScopeComplete: JsonField<Boolean> = JsonMissing.of()
            private var replyTreeComplete: JsonField<Boolean> = JsonMissing.of()
            private var sourcesEnded: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(diagnostic: Diagnostic) = apply {
                complete = diagnostic.complete
                coveragePercentage = diagnostic.coveragePercentage
                cursorFailures = diagnostic.cursorFailures
                duplicateCount = diagnostic.duplicateCount
                emptyFalseProgressPages = diagnostic.emptyFalseProgressPages
                malformedCount = diagnostic.malformedCount
                missingResponseModulesOrFields =
                    diagnostic.missingResponseModulesOrFields.map { it.toMutableList() }
                nestedReplyCount = diagnostic.nestedReplyCount
                pagesAttempted = diagnostic.pagesAttempted
                recommendedFallback = diagnostic.recommendedFallback
                repeatedCursorCount = diagnostic.repeatedCursorCount
                reportedReplyCount = diagnostic.reportedReplyCount
                responseTruncated = diagnostic.responseTruncated
                richness = diagnostic.richness
                strategiesAttempted = diagnostic.strategiesAttempted.map { it.toMutableList() }
                targetDirectReplies = diagnostic.targetDirectReplies
                uniqueDirectReplies = diagnostic.uniqueDirectReplies
                unrelatedCount = diagnostic.unrelatedCount
                replyScopeComplete = diagnostic.replyScopeComplete
                replyTreeComplete = diagnostic.replyTreeComplete
                sourcesEnded = diagnostic.sourcesEnded
                additionalProperties = diagnostic.additionalProperties.toMutableMap()
            }

            /** Whether coverage met the target without truncation. */
            fun complete(complete: Boolean) = complete(JsonField.of(complete))

            /** Sets [Builder.complete] to an arbitrary JSON value. */
            fun complete(complete: JsonField<Boolean>) = apply { this.complete = complete }

            /** Unique direct replies as a percentage of the reported count. */
            fun coveragePercentage(coveragePercentage: Double) =
                coveragePercentage(JsonField.of(coveragePercentage))

            /** Sets [Builder.coveragePercentage] to an arbitrary JSON value. */
            fun coveragePercentage(coveragePercentage: JsonField<Double>) = apply {
                this.coveragePercentage = coveragePercentage
            }

            /** Cursor requests that failed. */
            fun cursorFailures(cursorFailures: Long) = cursorFailures(JsonField.of(cursorFailures))

            /** Sets [Builder.cursorFailures] to an arbitrary JSON value. */
            fun cursorFailures(cursorFailures: JsonField<Long>) = apply {
                this.cursorFailures = cursorFailures
            }

            /** Duplicate tweet IDs removed across pages and strategies. */
            fun duplicateCount(duplicateCount: Long) = duplicateCount(JsonField.of(duplicateCount))

            /** Sets [Builder.duplicateCount] to an arbitrary JSON value. */
            fun duplicateCount(duplicateCount: JsonField<Long>) = apply {
                this.duplicateCount = duplicateCount
            }

            /** Empty pages rejected because they did not make progress. */
            fun emptyFalseProgressPages(emptyFalseProgressPages: Long) =
                emptyFalseProgressPages(JsonField.of(emptyFalseProgressPages))

            /** Sets [Builder.emptyFalseProgressPages] to an arbitrary JSON value. */
            fun emptyFalseProgressPages(emptyFalseProgressPages: JsonField<Long>) = apply {
                this.emptyFalseProgressPages = emptyFalseProgressPages
            }

            /** Malformed response items rejected. */
            fun malformedCount(malformedCount: Long) = malformedCount(JsonField.of(malformedCount))

            /** Sets [Builder.malformedCount] to an arbitrary JSON value. */
            fun malformedCount(malformedCount: JsonField<Long>) = apply {
                this.malformedCount = malformedCount
            }

            /** Expected response modules or fields missing from X. */
            fun missingResponseModulesOrFields(missingResponseModulesOrFields: List<String>) =
                missingResponseModulesOrFields(JsonField.of(missingResponseModulesOrFields))

            /** Sets [Builder.missingResponseModulesOrFields] to an arbitrary JSON value. */
            fun missingResponseModulesOrFields(
                missingResponseModulesOrFields: JsonField<List<String>>
            ) = apply {
                this.missingResponseModulesOrFields = missingResponseModulesOrFields.map {
                    it.toMutableList()
                }
            }

            /**
             * Adds a single [String] to [missingResponseModulesOrFields].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addMissingResponseModulesOrField(missingResponseModulesOrField: String) = apply {
                missingResponseModulesOrFields =
                    (missingResponseModulesOrFields ?: JsonField.of(mutableListOf())).also {
                        checkKnown("missingResponseModulesOrFields", it)
                            .add(missingResponseModulesOrField)
                    }
            }

            /** Unique nested replies kept outside direct coverage. */
            fun nestedReplyCount(nestedReplyCount: Long) =
                nestedReplyCount(JsonField.of(nestedReplyCount))

            /** Sets [Builder.nestedReplyCount] to an arbitrary JSON value. */
            fun nestedReplyCount(nestedReplyCount: JsonField<Long>) = apply {
                this.nestedReplyCount = nestedReplyCount
            }

            /** Total pages attempted across all strategies. */
            fun pagesAttempted(pagesAttempted: Long) = pagesAttempted(JsonField.of(pagesAttempted))

            /** Sets [Builder.pagesAttempted] to an arbitrary JSON value. */
            fun pagesAttempted(pagesAttempted: JsonField<Long>) = apply {
                this.pagesAttempted = pagesAttempted
            }

            /** Recommended next action when coverage is incomplete. */
            fun recommendedFallback(recommendedFallback: String) =
                recommendedFallback(JsonField.of(recommendedFallback))

            /** Sets [Builder.recommendedFallback] to an arbitrary JSON value. */
            fun recommendedFallback(recommendedFallback: JsonField<String>) = apply {
                this.recommendedFallback = recommendedFallback
            }

            /** Repeated cursors rejected to prevent loops. */
            fun repeatedCursorCount(repeatedCursorCount: Long) =
                repeatedCursorCount(JsonField.of(repeatedCursorCount))

            /** Sets [Builder.repeatedCursorCount] to an arbitrary JSON value. */
            fun repeatedCursorCount(repeatedCursorCount: JsonField<Long>) = apply {
                this.repeatedCursorCount = repeatedCursorCount
            }

            /** Reply count reported on the source post. */
            fun reportedReplyCount(reportedReplyCount: Long) =
                reportedReplyCount(JsonField.of(reportedReplyCount))

            /** Sets [Builder.reportedReplyCount] to an arbitrary JSON value. */
            fun reportedReplyCount(reportedReplyCount: JsonField<Long>) = apply {
                this.reportedReplyCount = reportedReplyCount
            }

            /** Whether the requested row limit truncated safe results. */
            fun responseTruncated(responseTruncated: Boolean) =
                responseTruncated(JsonField.of(responseTruncated))

            /** Sets [Builder.responseTruncated] to an arbitrary JSON value. */
            fun responseTruncated(responseTruncated: JsonField<Boolean>) = apply {
                this.responseTruncated = responseTruncated
            }

            /** Field-presence counts across the collected direct replies. */
            fun richness(richness: Richness) = richness(JsonField.of(richness))

            /** Sets [Builder.richness] to an arbitrary JSON value. */
            fun richness(richness: JsonField<Richness>) = apply { this.richness = richness }

            /** Per-strategy pagination and contribution evidence. */
            fun strategiesAttempted(strategiesAttempted: List<StrategiesAttempted>) =
                strategiesAttempted(JsonField.of(strategiesAttempted))

            /** Sets [Builder.strategiesAttempted] to an arbitrary JSON value. */
            fun strategiesAttempted(strategiesAttempted: JsonField<List<StrategiesAttempted>>) =
                apply {
                    this.strategiesAttempted = strategiesAttempted.map { it.toMutableList() }
                }

            /**
             * Adds a single [StrategiesAttempted] to [Builder.strategiesAttempted].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addStrategiesAttempted(strategiesAttempted: StrategiesAttempted) = apply {
                this.strategiesAttempted =
                    (this.strategiesAttempted ?: JsonField.of(mutableListOf())).also {
                        checkKnown("strategiesAttempted", it).add(strategiesAttempted)
                    }
            }

            /** Minimum direct replies required for the coverage target. */
            fun targetDirectReplies(targetDirectReplies: Long) =
                targetDirectReplies(JsonField.of(targetDirectReplies))

            /** Sets [Builder.targetDirectReplies] to an arbitrary JSON value. */
            fun targetDirectReplies(targetDirectReplies: JsonField<Long>) = apply {
                this.targetDirectReplies = targetDirectReplies
            }

            /** Unique replies whose parent ID equals the source post ID. */
            fun uniqueDirectReplies(uniqueDirectReplies: Long) =
                uniqueDirectReplies(JsonField.of(uniqueDirectReplies))

            /** Sets [Builder.uniqueDirectReplies] to an arbitrary JSON value. */
            fun uniqueDirectReplies(uniqueDirectReplies: JsonField<Long>) = apply {
                this.uniqueDirectReplies = uniqueDirectReplies
            }

            /** Tweets rejected because they belonged elsewhere. */
            fun unrelatedCount(unrelatedCount: Long) = unrelatedCount(JsonField.of(unrelatedCount))

            /** Sets [Builder.unrelatedCount] to an arbitrary JSON value. */
            fun unrelatedCount(unrelatedCount: JsonField<Long>) = apply {
                this.unrelatedCount = unrelatedCount
            }

            /**
             * Replies are accounted for through the requested scope & depth. Source errors remain
             * separate.
             */
            fun replyScopeComplete(replyScopeComplete: Boolean) =
                replyScopeComplete(JsonField.of(replyScopeComplete))

            /** Sets [Builder.replyScopeComplete] to an arbitrary JSON value. */
            fun replyScopeComplete(replyScopeComplete: JsonField<Boolean>) = apply {
                this.replyScopeComplete = replyScopeComplete
            }

            /** All child counts are known & match collected replies. */
            fun replyTreeComplete(replyTreeComplete: Boolean) =
                replyTreeComplete(JsonField.of(replyTreeComplete))

            /** Sets [Builder.replyTreeComplete] to an arbitrary JSON value. */
            fun replyTreeComplete(replyTreeComplete: JsonField<Boolean>) = apply {
                this.replyTreeComplete = replyTreeComplete
            }

            /**
             * Every source ended, or no reply view shows a reply. A retry returns the same rows.
             */
            fun sourcesEnded(sourcesEnded: Boolean) = sourcesEnded(JsonField.of(sourcesEnded))

            /** Sets [Builder.sourcesEnded] to an arbitrary JSON value. */
            fun sourcesEnded(sourcesEnded: JsonField<Boolean>) = apply {
                this.sourcesEnded = sourcesEnded
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
             * Returns an immutable instance of [Diagnostic].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .complete()
             * .coveragePercentage()
             * .cursorFailures()
             * .duplicateCount()
             * .emptyFalseProgressPages()
             * .malformedCount()
             * .missingResponseModulesOrFields()
             * .nestedReplyCount()
             * .pagesAttempted()
             * .recommendedFallback()
             * .repeatedCursorCount()
             * .reportedReplyCount()
             * .responseTruncated()
             * .richness()
             * .strategiesAttempted()
             * .targetDirectReplies()
             * .uniqueDirectReplies()
             * .unrelatedCount()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Diagnostic =
                Diagnostic(
                    checkRequired("complete", complete),
                    checkRequired("coveragePercentage", coveragePercentage),
                    checkRequired("cursorFailures", cursorFailures),
                    checkRequired("duplicateCount", duplicateCount),
                    checkRequired("emptyFalseProgressPages", emptyFalseProgressPages),
                    checkRequired("malformedCount", malformedCount),
                    checkRequired("missingResponseModulesOrFields", missingResponseModulesOrFields)
                        .map { it.toImmutable() },
                    checkRequired("nestedReplyCount", nestedReplyCount),
                    checkRequired("pagesAttempted", pagesAttempted),
                    checkRequired("recommendedFallback", recommendedFallback),
                    checkRequired("repeatedCursorCount", repeatedCursorCount),
                    checkRequired("reportedReplyCount", reportedReplyCount),
                    checkRequired("responseTruncated", responseTruncated),
                    checkRequired("richness", richness),
                    checkRequired("strategiesAttempted", strategiesAttempted).map {
                        it.toImmutable()
                    },
                    checkRequired("targetDirectReplies", targetDirectReplies),
                    checkRequired("uniqueDirectReplies", uniqueDirectReplies),
                    checkRequired("unrelatedCount", unrelatedCount),
                    replyScopeComplete,
                    replyTreeComplete,
                    sourcesEnded,
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
        fun validate(): Diagnostic = apply {
            if (validated) {
                return@apply
            }

            complete()
            coveragePercentage()
            cursorFailures()
            duplicateCount()
            emptyFalseProgressPages()
            malformedCount()
            missingResponseModulesOrFields()
            nestedReplyCount()
            pagesAttempted()
            recommendedFallback()
            repeatedCursorCount()
            reportedReplyCount()
            responseTruncated()
            richness().validate()
            strategiesAttempted().forEach { it.validate() }
            targetDirectReplies()
            uniqueDirectReplies()
            unrelatedCount()
            replyScopeComplete()
            replyTreeComplete()
            sourcesEnded()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        @JvmSynthetic
        internal fun validity(): Int =
            (if (complete.asKnown().isPresent) 1 else 0) +
                (if (coveragePercentage.asKnown().isPresent) 1 else 0) +
                (if (cursorFailures.asKnown().isPresent) 1 else 0) +
                (if (duplicateCount.asKnown().isPresent) 1 else 0) +
                (if (emptyFalseProgressPages.asKnown().isPresent) 1 else 0) +
                (if (malformedCount.asKnown().isPresent) 1 else 0) +
                (missingResponseModulesOrFields.asKnown().getOrNull()?.size ?: 0) +
                (if (nestedReplyCount.asKnown().isPresent) 1 else 0) +
                (if (pagesAttempted.asKnown().isPresent) 1 else 0) +
                (if (recommendedFallback.asKnown().isPresent) 1 else 0) +
                (if (repeatedCursorCount.asKnown().isPresent) 1 else 0) +
                (if (reportedReplyCount.asKnown().isPresent) 1 else 0) +
                (if (responseTruncated.asKnown().isPresent) 1 else 0) +
                (richness.asKnown().getOrNull()?.validity() ?: 0) +
                (strategiesAttempted.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (targetDirectReplies.asKnown().isPresent) 1 else 0) +
                (if (uniqueDirectReplies.asKnown().isPresent) 1 else 0) +
                (if (unrelatedCount.asKnown().isPresent) 1 else 0) +
                (if (replyScopeComplete.asKnown().isPresent) 1 else 0) +
                (if (replyTreeComplete.asKnown().isPresent) 1 else 0) +
                (if (sourcesEnded.asKnown().isPresent) 1 else 0)

        /** Field-presence counts across the collected direct replies. */
        class Richness
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val article: JsonField<Long>,
            private val author: JsonField<Long>,
            private val card: JsonField<Long>,
            private val communityNote: JsonField<Long>,
            private val createdAt: JsonField<Long>,
            private val engagementCounts: JsonField<Long>,
            private val entities: JsonField<Long>,
            private val language: JsonField<Long>,
            private val media: JsonField<Long>,
            private val quotedOrRepostedTweet: JsonField<Long>,
            private val text: JsonField<Long>,
            private val totalReplies: JsonField<Long>,
            private val url: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("article")
                @ExcludeMissing
                article: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("author") @ExcludeMissing author: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("card") @ExcludeMissing card: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("communityNote")
                @ExcludeMissing
                communityNote: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("createdAt")
                @ExcludeMissing
                createdAt: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("engagementCounts")
                @ExcludeMissing
                engagementCounts: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("entities")
                @ExcludeMissing
                entities: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("language")
                @ExcludeMissing
                language: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("media") @ExcludeMissing media: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("quotedOrRepostedTweet")
                @ExcludeMissing
                quotedOrRepostedTweet: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("text") @ExcludeMissing text: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("totalReplies")
                @ExcludeMissing
                totalReplies: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("url") @ExcludeMissing url: JsonField<Long> = JsonMissing.of(),
            ) : this(
                article,
                author,
                card,
                communityNote,
                createdAt,
                engagementCounts,
                entities,
                language,
                media,
                quotedOrRepostedTweet,
                text,
                totalReplies,
                url,
                mutableMapOf(),
            )

            /**
             * Replies with article content.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun article(): Long = article.getRequired("article")

            /**
             * Replies with author details.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun author(): Long = author.getRequired("author")

            /**
             * Replies with card metadata.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun card(): Long = card.getRequired("card")

            /**
             * Replies with community-note data.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun communityNote(): Long = communityNote.getRequired("communityNote")

            /**
             * Replies with a creation timestamp.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun createdAt(): Long = createdAt.getRequired("createdAt")

            /**
             * Replies with engagement counts.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun engagementCounts(): Long = engagementCounts.getRequired("engagementCounts")

            /**
             * Replies with entity metadata.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun entities(): Long = entities.getRequired("entities")

            /**
             * Replies with a language value.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun language(): Long = language.getRequired("language")

            /**
             * Replies with media metadata.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun media(): Long = media.getRequired("media")

            /**
             * Replies with quoted or reposted tweet data.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun quotedOrRepostedTweet(): Long =
                quotedOrRepostedTweet.getRequired("quotedOrRepostedTweet")

            /**
             * Replies with text.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun text(): Long = text.getRequired("text")

            /**
             * Total unique direct replies evaluated for richness.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun totalReplies(): Long = totalReplies.getRequired("totalReplies")

            /**
             * Replies with a canonical URL.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun url(): Long = url.getRequired("url")

            /**
             * Returns the raw JSON value of [article].
             *
             * Unlike [article], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("article") @ExcludeMissing fun _article(): JsonField<Long> = article

            /**
             * Returns the raw JSON value of [author].
             *
             * Unlike [author], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("author") @ExcludeMissing fun _author(): JsonField<Long> = author

            /**
             * Returns the raw JSON value of [card].
             *
             * Unlike [card], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("card") @ExcludeMissing fun _card(): JsonField<Long> = card

            /**
             * Returns the raw JSON value of [communityNote].
             *
             * Unlike [communityNote], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("communityNote")
            @ExcludeMissing
            fun _communityNote(): JsonField<Long> = communityNote

            /**
             * Returns the raw JSON value of [createdAt].
             *
             * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

            /**
             * Returns the raw JSON value of [engagementCounts].
             *
             * Unlike [engagementCounts], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("engagementCounts")
            @ExcludeMissing
            fun _engagementCounts(): JsonField<Long> = engagementCounts

            /**
             * Returns the raw JSON value of [entities].
             *
             * Unlike [entities], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("entities") @ExcludeMissing fun _entities(): JsonField<Long> = entities

            /**
             * Returns the raw JSON value of [language].
             *
             * Unlike [language], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<Long> = language

            /**
             * Returns the raw JSON value of [media].
             *
             * Unlike [media], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("media") @ExcludeMissing fun _media(): JsonField<Long> = media

            /**
             * Returns the raw JSON value of [quotedOrRepostedTweet].
             *
             * Unlike [quotedOrRepostedTweet], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("quotedOrRepostedTweet")
            @ExcludeMissing
            fun _quotedOrRepostedTweet(): JsonField<Long> = quotedOrRepostedTweet

            /**
             * Returns the raw JSON value of [text].
             *
             * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<Long> = text

            /**
             * Returns the raw JSON value of [totalReplies].
             *
             * Unlike [totalReplies], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("totalReplies")
            @ExcludeMissing
            fun _totalReplies(): JsonField<Long> = totalReplies

            /**
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<Long> = url

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
                 * Returns a mutable builder for constructing an instance of [Richness].
                 *
                 * The following fields are required:
                 * ```java
                 * .article()
                 * .author()
                 * .card()
                 * .communityNote()
                 * .createdAt()
                 * .engagementCounts()
                 * .entities()
                 * .language()
                 * .media()
                 * .quotedOrRepostedTweet()
                 * .text()
                 * .totalReplies()
                 * .url()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Richness]. */
            class Builder internal constructor() {

                private var article: JsonField<Long>? = null
                private var author: JsonField<Long>? = null
                private var card: JsonField<Long>? = null
                private var communityNote: JsonField<Long>? = null
                private var createdAt: JsonField<Long>? = null
                private var engagementCounts: JsonField<Long>? = null
                private var entities: JsonField<Long>? = null
                private var language: JsonField<Long>? = null
                private var media: JsonField<Long>? = null
                private var quotedOrRepostedTweet: JsonField<Long>? = null
                private var text: JsonField<Long>? = null
                private var totalReplies: JsonField<Long>? = null
                private var url: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(richness: Richness) = apply {
                    article = richness.article
                    author = richness.author
                    card = richness.card
                    communityNote = richness.communityNote
                    createdAt = richness.createdAt
                    engagementCounts = richness.engagementCounts
                    entities = richness.entities
                    language = richness.language
                    media = richness.media
                    quotedOrRepostedTweet = richness.quotedOrRepostedTweet
                    text = richness.text
                    totalReplies = richness.totalReplies
                    url = richness.url
                    additionalProperties = richness.additionalProperties.toMutableMap()
                }

                /** Replies with article content. */
                fun article(article: Long) = article(JsonField.of(article))

                /** Sets [Builder.article] to an arbitrary JSON value. */
                fun article(article: JsonField<Long>) = apply { this.article = article }

                /** Replies with author details. */
                fun author(author: Long) = author(JsonField.of(author))

                /** Sets [Builder.author] to an arbitrary JSON value. */
                fun author(author: JsonField<Long>) = apply { this.author = author }

                /** Replies with card metadata. */
                fun card(card: Long) = card(JsonField.of(card))

                /** Sets [Builder.card] to an arbitrary JSON value. */
                fun card(card: JsonField<Long>) = apply { this.card = card }

                /** Replies with community-note data. */
                fun communityNote(communityNote: Long) = communityNote(JsonField.of(communityNote))

                /** Sets [Builder.communityNote] to an arbitrary JSON value. */
                fun communityNote(communityNote: JsonField<Long>) = apply {
                    this.communityNote = communityNote
                }

                /** Replies with a creation timestamp. */
                fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

                /** Sets [Builder.createdAt] to an arbitrary JSON value. */
                fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

                /** Replies with engagement counts. */
                fun engagementCounts(engagementCounts: Long) =
                    engagementCounts(JsonField.of(engagementCounts))

                /** Sets [Builder.engagementCounts] to an arbitrary JSON value. */
                fun engagementCounts(engagementCounts: JsonField<Long>) = apply {
                    this.engagementCounts = engagementCounts
                }

                /** Replies with entity metadata. */
                fun entities(entities: Long) = entities(JsonField.of(entities))

                /** Sets [Builder.entities] to an arbitrary JSON value. */
                fun entities(entities: JsonField<Long>) = apply { this.entities = entities }

                /** Replies with a language value. */
                fun language(language: Long) = language(JsonField.of(language))

                /** Sets [Builder.language] to an arbitrary JSON value. */
                fun language(language: JsonField<Long>) = apply { this.language = language }

                /** Replies with media metadata. */
                fun media(media: Long) = media(JsonField.of(media))

                /** Sets [Builder.media] to an arbitrary JSON value. */
                fun media(media: JsonField<Long>) = apply { this.media = media }

                /** Replies with quoted or reposted tweet data. */
                fun quotedOrRepostedTweet(quotedOrRepostedTweet: Long) =
                    quotedOrRepostedTweet(JsonField.of(quotedOrRepostedTweet))

                /** Sets [Builder.quotedOrRepostedTweet] to an arbitrary JSON value. */
                fun quotedOrRepostedTweet(quotedOrRepostedTweet: JsonField<Long>) = apply {
                    this.quotedOrRepostedTweet = quotedOrRepostedTweet
                }

                /** Replies with text. */
                fun text(text: Long) = text(JsonField.of(text))

                /** Sets [Builder.text] to an arbitrary JSON value. */
                fun text(text: JsonField<Long>) = apply { this.text = text }

                /** Total unique direct replies evaluated for richness. */
                fun totalReplies(totalReplies: Long) = totalReplies(JsonField.of(totalReplies))

                /** Sets [Builder.totalReplies] to an arbitrary JSON value. */
                fun totalReplies(totalReplies: JsonField<Long>) = apply {
                    this.totalReplies = totalReplies
                }

                /** Replies with a canonical URL. */
                fun url(url: Long) = url(JsonField.of(url))

                /** Sets [Builder.url] to an arbitrary JSON value. */
                fun url(url: JsonField<Long>) = apply { this.url = url }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Richness].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .article()
                 * .author()
                 * .card()
                 * .communityNote()
                 * .createdAt()
                 * .engagementCounts()
                 * .entities()
                 * .language()
                 * .media()
                 * .quotedOrRepostedTweet()
                 * .text()
                 * .totalReplies()
                 * .url()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Richness =
                    Richness(
                        checkRequired("article", article),
                        checkRequired("author", author),
                        checkRequired("card", card),
                        checkRequired("communityNote", communityNote),
                        checkRequired("createdAt", createdAt),
                        checkRequired("engagementCounts", engagementCounts),
                        checkRequired("entities", entities),
                        checkRequired("language", language),
                        checkRequired("media", media),
                        checkRequired("quotedOrRepostedTweet", quotedOrRepostedTweet),
                        checkRequired("text", text),
                        checkRequired("totalReplies", totalReplies),
                        checkRequired("url", url),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): Richness = apply {
                if (validated) {
                    return@apply
                }

                article()
                author()
                card()
                communityNote()
                createdAt()
                engagementCounts()
                entities()
                language()
                media()
                quotedOrRepostedTweet()
                text()
                totalReplies()
                url()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            @JvmSynthetic
            internal fun validity(): Int =
                (if (article.asKnown().isPresent) 1 else 0) +
                    (if (author.asKnown().isPresent) 1 else 0) +
                    (if (card.asKnown().isPresent) 1 else 0) +
                    (if (communityNote.asKnown().isPresent) 1 else 0) +
                    (if (createdAt.asKnown().isPresent) 1 else 0) +
                    (if (engagementCounts.asKnown().isPresent) 1 else 0) +
                    (if (entities.asKnown().isPresent) 1 else 0) +
                    (if (language.asKnown().isPresent) 1 else 0) +
                    (if (media.asKnown().isPresent) 1 else 0) +
                    (if (quotedOrRepostedTweet.asKnown().isPresent) 1 else 0) +
                    (if (text.asKnown().isPresent) 1 else 0) +
                    (if (totalReplies.asKnown().isPresent) 1 else 0) +
                    (if (url.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Richness &&
                    article == other.article &&
                    author == other.author &&
                    card == other.card &&
                    communityNote == other.communityNote &&
                    createdAt == other.createdAt &&
                    engagementCounts == other.engagementCounts &&
                    entities == other.entities &&
                    language == other.language &&
                    media == other.media &&
                    quotedOrRepostedTweet == other.quotedOrRepostedTweet &&
                    text == other.text &&
                    totalReplies == other.totalReplies &&
                    url == other.url &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    article,
                    author,
                    card,
                    communityNote,
                    createdAt,
                    engagementCounts,
                    entities,
                    language,
                    media,
                    quotedOrRepostedTweet,
                    text,
                    totalReplies,
                    url,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Richness{article=$article, author=$author, card=$card, communityNote=$communityNote, createdAt=$createdAt, engagementCounts=$engagementCounts, entities=$entities, language=$language, media=$media, quotedOrRepostedTweet=$quotedOrRepostedTweet, text=$text, totalReplies=$totalReplies, url=$url, additionalProperties=$additionalProperties}"
        }

        class StrategiesAttempted
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val name: JsonField<String>,
            private val newDirectReplies: JsonField<Long>,
            private val newNestedReplies: JsonField<Long>,
            private val pagesAttempted: JsonField<Long>,
            private val stopReason: JsonField<StopReason>,
            private val newDirectReplyPages: JsonField<List<Long>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("newDirectReplies")
                @ExcludeMissing
                newDirectReplies: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("newNestedReplies")
                @ExcludeMissing
                newNestedReplies: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("pagesAttempted")
                @ExcludeMissing
                pagesAttempted: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("stopReason")
                @ExcludeMissing
                stopReason: JsonField<StopReason> = JsonMissing.of(),
                @JsonProperty("newDirectReplyPages")
                @ExcludeMissing
                newDirectReplyPages: JsonField<List<Long>> = JsonMissing.of(),
            ) : this(
                name,
                newDirectReplies,
                newNestedReplies,
                pagesAttempted,
                stopReason,
                newDirectReplyPages,
                mutableMapOf(),
            )

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun name(): String = name.getRequired("name")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun newDirectReplies(): Long = newDirectReplies.getRequired("newDirectReplies")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun newNestedReplies(): Long = newNestedReplies.getRequired("newNestedReplies")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun pagesAttempted(): Long = pagesAttempted.getRequired("pagesAttempted")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun stopReason(): StopReason = stopReason.getRequired("stopReason")

            /**
             * For a search of the post's conversation, the page that listed each new direct reply,
             * from 1.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun newDirectReplyPages(): Optional<List<Long>> =
                newDirectReplyPages.getOptional("newDirectReplyPages")

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [newDirectReplies].
             *
             * Unlike [newDirectReplies], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("newDirectReplies")
            @ExcludeMissing
            fun _newDirectReplies(): JsonField<Long> = newDirectReplies

            /**
             * Returns the raw JSON value of [newNestedReplies].
             *
             * Unlike [newNestedReplies], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("newNestedReplies")
            @ExcludeMissing
            fun _newNestedReplies(): JsonField<Long> = newNestedReplies

            /**
             * Returns the raw JSON value of [pagesAttempted].
             *
             * Unlike [pagesAttempted], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("pagesAttempted")
            @ExcludeMissing
            fun _pagesAttempted(): JsonField<Long> = pagesAttempted

            /**
             * Returns the raw JSON value of [stopReason].
             *
             * Unlike [stopReason], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("stopReason")
            @ExcludeMissing
            fun _stopReason(): JsonField<StopReason> = stopReason

            /**
             * Returns the raw JSON value of [newDirectReplyPages].
             *
             * Unlike [newDirectReplyPages], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("newDirectReplyPages")
            @ExcludeMissing
            fun _newDirectReplyPages(): JsonField<List<Long>> = newDirectReplyPages

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
                 * Returns a mutable builder for constructing an instance of [StrategiesAttempted].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * .newDirectReplies()
                 * .newNestedReplies()
                 * .pagesAttempted()
                 * .stopReason()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [StrategiesAttempted]. */
            class Builder internal constructor() {

                private var name: JsonField<String>? = null
                private var newDirectReplies: JsonField<Long>? = null
                private var newNestedReplies: JsonField<Long>? = null
                private var pagesAttempted: JsonField<Long>? = null
                private var stopReason: JsonField<StopReason>? = null
                private var newDirectReplyPages: JsonField<MutableList<Long>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(strategiesAttempted: StrategiesAttempted) = apply {
                    name = strategiesAttempted.name
                    newDirectReplies = strategiesAttempted.newDirectReplies
                    newNestedReplies = strategiesAttempted.newNestedReplies
                    pagesAttempted = strategiesAttempted.pagesAttempted
                    stopReason = strategiesAttempted.stopReason
                    newDirectReplyPages =
                        strategiesAttempted.newDirectReplyPages.map { it.toMutableList() }
                    additionalProperties = strategiesAttempted.additionalProperties.toMutableMap()
                }

                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun newDirectReplies(newDirectReplies: Long) =
                    newDirectReplies(JsonField.of(newDirectReplies))

                /** Sets [Builder.newDirectReplies] to an arbitrary JSON value. */
                fun newDirectReplies(newDirectReplies: JsonField<Long>) = apply {
                    this.newDirectReplies = newDirectReplies
                }

                fun newNestedReplies(newNestedReplies: Long) =
                    newNestedReplies(JsonField.of(newNestedReplies))

                /** Sets [Builder.newNestedReplies] to an arbitrary JSON value. */
                fun newNestedReplies(newNestedReplies: JsonField<Long>) = apply {
                    this.newNestedReplies = newNestedReplies
                }

                fun pagesAttempted(pagesAttempted: Long) =
                    pagesAttempted(JsonField.of(pagesAttempted))

                /** Sets [Builder.pagesAttempted] to an arbitrary JSON value. */
                fun pagesAttempted(pagesAttempted: JsonField<Long>) = apply {
                    this.pagesAttempted = pagesAttempted
                }

                fun stopReason(stopReason: StopReason) = stopReason(JsonField.of(stopReason))

                /** Sets [Builder.stopReason] to an arbitrary JSON value. */
                fun stopReason(stopReason: JsonField<StopReason>) = apply {
                    this.stopReason = stopReason
                }

                /**
                 * For a search of the post's conversation, the page that listed each new direct
                 * reply, from 1.
                 */
                fun newDirectReplyPages(newDirectReplyPages: List<Long>) =
                    newDirectReplyPages(JsonField.of(newDirectReplyPages))

                /** Sets [Builder.newDirectReplyPages] to an arbitrary JSON value. */
                fun newDirectReplyPages(newDirectReplyPages: JsonField<List<Long>>) = apply {
                    this.newDirectReplyPages = newDirectReplyPages.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Long] to [newDirectReplyPages].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addNewDirectReplyPage(newDirectReplyPage: Long) = apply {
                    newDirectReplyPages =
                        (newDirectReplyPages ?: JsonField.of(mutableListOf())).also {
                            checkKnown("newDirectReplyPages", it).add(newDirectReplyPage)
                        }
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [StrategiesAttempted].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * .newDirectReplies()
                 * .newNestedReplies()
                 * .pagesAttempted()
                 * .stopReason()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): StrategiesAttempted =
                    StrategiesAttempted(
                        checkRequired("name", name),
                        checkRequired("newDirectReplies", newDirectReplies),
                        checkRequired("newNestedReplies", newNestedReplies),
                        checkRequired("pagesAttempted", pagesAttempted),
                        checkRequired("stopReason", stopReason),
                        (newDirectReplyPages ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): StrategiesAttempted = apply {
                if (validated) {
                    return@apply
                }

                name()
                newDirectReplies()
                newNestedReplies()
                pagesAttempted()
                stopReason().validate()
                newDirectReplyPages()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            @JvmSynthetic
            internal fun validity(): Int =
                (if (name.asKnown().isPresent) 1 else 0) +
                    (if (newDirectReplies.asKnown().isPresent) 1 else 0) +
                    (if (newNestedReplies.asKnown().isPresent) 1 else 0) +
                    (if (pagesAttempted.asKnown().isPresent) 1 else 0) +
                    (stopReason.asKnown().getOrNull()?.validity() ?: 0) +
                    (newDirectReplyPages.asKnown().getOrNull()?.size ?: 0)

            class StopReason
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

                /** Returns this class instance's raw value. */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val DEADLINE = of("deadline")

                    @JvmField val EMPTY_PAGES = of("empty_pages")

                    @JvmField val ERROR = of("error")

                    @JvmField val MISSING_CURSOR = of("missing_cursor")

                    @JvmField val NO_NEXT_PAGE = of("no_next_page")

                    @JvmField val PAGE_CAP = of("page_cap")

                    @JvmField val REPEATED_CURSOR = of("repeated_cursor")

                    @JvmField val PARTIAL_VIEW = of("partial_view")

                    @JvmField val WINDOW_COVERED = of("window_covered")

                    @JvmField val WINDOW_PASSED = of("window_passed")

                    @JvmStatic fun of(value: String) = StopReason(JsonField.of(value))
                }

                /** An enum containing [StopReason]'s known values. */
                enum class Known {
                    DEADLINE,
                    EMPTY_PAGES,
                    ERROR,
                    MISSING_CURSOR,
                    NO_NEXT_PAGE,
                    PAGE_CAP,
                    REPEATED_CURSOR,
                    PARTIAL_VIEW,
                    WINDOW_COVERED,
                    WINDOW_PASSED,
                }

                /**
                 * An enum containing [StopReason]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [StopReason] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    DEADLINE,
                    EMPTY_PAGES,
                    ERROR,
                    MISSING_CURSOR,
                    NO_NEXT_PAGE,
                    PAGE_CAP,
                    REPEATED_CURSOR,
                    PARTIAL_VIEW,
                    WINDOW_COVERED,
                    WINDOW_PASSED,
                    /**
                     * An enum member indicating that [StopReason] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 */
                fun value(): Value =
                    when (this) {
                        DEADLINE -> Value.DEADLINE
                        EMPTY_PAGES -> Value.EMPTY_PAGES
                        ERROR -> Value.ERROR
                        MISSING_CURSOR -> Value.MISSING_CURSOR
                        NO_NEXT_PAGE -> Value.NO_NEXT_PAGE
                        PAGE_CAP -> Value.PAGE_CAP
                        REPEATED_CURSOR -> Value.REPEATED_CURSOR
                        PARTIAL_VIEW -> Value.PARTIAL_VIEW
                        WINDOW_COVERED -> Value.WINDOW_COVERED
                        WINDOW_PASSED -> Value.WINDOW_PASSED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        DEADLINE -> Known.DEADLINE
                        EMPTY_PAGES -> Known.EMPTY_PAGES
                        ERROR -> Known.ERROR
                        MISSING_CURSOR -> Known.MISSING_CURSOR
                        NO_NEXT_PAGE -> Known.NO_NEXT_PAGE
                        PAGE_CAP -> Known.PAGE_CAP
                        REPEATED_CURSOR -> Known.REPEATED_CURSOR
                        PARTIAL_VIEW -> Known.PARTIAL_VIEW
                        WINDOW_COVERED -> Known.WINDOW_COVERED
                        WINDOW_PASSED -> Known.WINDOW_PASSED
                        else ->
                            throw XTwitterScraperInvalidDataException("Unknown StopReason: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
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
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): StopReason = apply {
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

                @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is StopReason && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is StrategiesAttempted &&
                    name == other.name &&
                    newDirectReplies == other.newDirectReplies &&
                    newNestedReplies == other.newNestedReplies &&
                    pagesAttempted == other.pagesAttempted &&
                    stopReason == other.stopReason &&
                    newDirectReplyPages == other.newDirectReplyPages &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    name,
                    newDirectReplies,
                    newNestedReplies,
                    pagesAttempted,
                    stopReason,
                    newDirectReplyPages,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "StrategiesAttempted{name=$name, newDirectReplies=$newDirectReplies, newNestedReplies=$newNestedReplies, pagesAttempted=$pagesAttempted, stopReason=$stopReason, newDirectReplyPages=$newDirectReplyPages, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Diagnostic &&
                complete == other.complete &&
                coveragePercentage == other.coveragePercentage &&
                cursorFailures == other.cursorFailures &&
                duplicateCount == other.duplicateCount &&
                emptyFalseProgressPages == other.emptyFalseProgressPages &&
                malformedCount == other.malformedCount &&
                missingResponseModulesOrFields == other.missingResponseModulesOrFields &&
                nestedReplyCount == other.nestedReplyCount &&
                pagesAttempted == other.pagesAttempted &&
                recommendedFallback == other.recommendedFallback &&
                repeatedCursorCount == other.repeatedCursorCount &&
                reportedReplyCount == other.reportedReplyCount &&
                responseTruncated == other.responseTruncated &&
                richness == other.richness &&
                strategiesAttempted == other.strategiesAttempted &&
                targetDirectReplies == other.targetDirectReplies &&
                uniqueDirectReplies == other.uniqueDirectReplies &&
                unrelatedCount == other.unrelatedCount &&
                replyScopeComplete == other.replyScopeComplete &&
                replyTreeComplete == other.replyTreeComplete &&
                sourcesEnded == other.sourcesEnded &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                complete,
                coveragePercentage,
                cursorFailures,
                duplicateCount,
                emptyFalseProgressPages,
                malformedCount,
                missingResponseModulesOrFields,
                nestedReplyCount,
                pagesAttempted,
                recommendedFallback,
                repeatedCursorCount,
                reportedReplyCount,
                responseTruncated,
                richness,
                strategiesAttempted,
                targetDirectReplies,
                uniqueDirectReplies,
                unrelatedCount,
                replyScopeComplete,
                replyTreeComplete,
                sourcesEnded,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Diagnostic{complete=$complete, coveragePercentage=$coveragePercentage, cursorFailures=$cursorFailures, duplicateCount=$duplicateCount, emptyFalseProgressPages=$emptyFalseProgressPages, malformedCount=$malformedCount, missingResponseModulesOrFields=$missingResponseModulesOrFields, nestedReplyCount=$nestedReplyCount, pagesAttempted=$pagesAttempted, recommendedFallback=$recommendedFallback, repeatedCursorCount=$repeatedCursorCount, reportedReplyCount=$reportedReplyCount, responseTruncated=$responseTruncated, richness=$richness, strategiesAttempted=$strategiesAttempted, targetDirectReplies=$targetDirectReplies, uniqueDirectReplies=$uniqueDirectReplies, unrelatedCount=$unrelatedCount, replyScopeComplete=$replyScopeComplete, replyTreeComplete=$replyTreeComplete, sourcesEnded=$sourcesEnded, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetGetRepliesResponse &&
            hasNextPage == other.hasNextPage &&
            nextCursor == other.nextCursor &&
            tweets == other.tweets &&
            diagnostic == other.diagnostic &&
            filteredCount == other.filteredCount &&
            hiddenReplies == other.hiddenReplies &&
            limitReached == other.limitReached &&
            message == other.message &&
            nestedReplies == other.nestedReplies &&
            orderPartial == other.orderPartial &&
            partialBefore == other.partialBefore &&
            readBackTo == other.readBackTo &&
            searchContext == other.searchContext &&
            searchedQuery == other.searchedQuery &&
            windowComplete == other.windowComplete &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            hasNextPage,
            nextCursor,
            tweets,
            diagnostic,
            filteredCount,
            hiddenReplies,
            limitReached,
            message,
            nestedReplies,
            orderPartial,
            partialBefore,
            readBackTo,
            searchContext,
            searchedQuery,
            windowComplete,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TweetGetRepliesResponse{hasNextPage=$hasNextPage, nextCursor=$nextCursor, tweets=$tweets, diagnostic=$diagnostic, filteredCount=$filteredCount, hiddenReplies=$hiddenReplies, limitReached=$limitReached, message=$message, nestedReplies=$nestedReplies, orderPartial=$orderPartial, partialBefore=$partialBefore, readBackTo=$readBackTo, searchContext=$searchContext, searchedQuery=$searchedQuery, windowComplete=$windowComplete, additionalProperties=$additionalProperties}"
}
