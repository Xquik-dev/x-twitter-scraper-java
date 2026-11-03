// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.sports

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import com.x_twitter_scraper.api.models.SearchTweet
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A page of 1 game's posts, in Xquik's post shape. Pass next_cursor as cursor for the next page. */
class SportsGamePosts
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val filteredCount: JsonField<Long>,
    private val tweets: JsonField<List<SearchTweet>>,
    private val hasNextPage: JsonField<Boolean>,
    private val nextCursor: JsonField<String>,
    private val readBackTo: JsonField<OffsetDateTime>,
    private val windowComplete: JsonField<Boolean>,
    private val searchedQuery: JsonField<String>,
    private val searchContext: JsonField<SearchContext>,
    private val query: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("filtered_count") @ExcludeMissing filteredCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("tweets") @ExcludeMissing tweets: JsonField<List<SearchTweet>> = JsonMissing.of(),
        @JsonProperty("has_next_page") @ExcludeMissing hasNextPage: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("next_cursor") @ExcludeMissing nextCursor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("readBackTo") @ExcludeMissing readBackTo: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("windowComplete") @ExcludeMissing windowComplete: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("searchedQuery") @ExcludeMissing searchedQuery: JsonField<String> = JsonMissing.of(),
        @JsonProperty("searchContext") @ExcludeMissing searchContext: JsonField<SearchContext> = JsonMissing.of(),
        @JsonProperty("query") @ExcludeMissing query: JsonField<String> = JsonMissing.of(),
    ) : this(filteredCount, tweets, hasNextPage, nextCursor, readBackTo, windowComplete, searchedQuery, searchContext, query, mutableMapOf())

    /** Whole number from 0. */
    fun filteredCount(): Optional<Long> = filteredCount.getOptional("filtered_count")

    fun tweets(): List<SearchTweet> = tweets.getRequired("tweets")

    fun hasNextPage(): Boolean = hasNextPage.getRequired("has_next_page")

    /** Cursor for the next page. Send it unchanged. Each next page arrives fast. */
    fun nextCursor(): String = nextCursor.getRequired("next_cursor")

    /** The UTC time this filtered search has reached. */
    fun readBackTo(): Optional<OffsetDateTime> = readBackTo.getOptional("readBackTo")

    /** Present on a last page whose sources all read past its start time. */
    fun windowComplete(): Optional<Boolean> = windowComplete.getOptional("windowComplete")

    /** The query that ran, when it differs from your q. */
    fun searchedQuery(): Optional<String> = searchedQuery.getOptional("searchedQuery")

    /** What X shows beside a search's posts, the same for everyone. Present on a search for a cashtag X has a card for, such as $BTC. Cashtag searches add X's ticker card in `searchContext`. */
    fun searchContext(): Optional<SearchContext> = searchContext.getOptional("searchContext")

    /** An X search for this game's posts, in the order asked. Send it to GET /x/tweets/search for more filters. Null when no search is available. */
    fun query(): Optional<String> = query.getOptional("query")

    /** Returns the raw JSON value of [filteredCount]. */
    @JsonProperty("filtered_count") @ExcludeMissing fun _filteredCount(): JsonField<Long> = filteredCount

    /** Returns the raw JSON value of [tweets]. */
    @JsonProperty("tweets") @ExcludeMissing fun _tweets(): JsonField<List<SearchTweet>> = tweets

    /** Returns the raw JSON value of [hasNextPage]. */
    @JsonProperty("has_next_page") @ExcludeMissing fun _hasNextPage(): JsonField<Boolean> = hasNextPage

    /** Returns the raw JSON value of [nextCursor]. */
    @JsonProperty("next_cursor") @ExcludeMissing fun _nextCursor(): JsonField<String> = nextCursor

    /** Returns the raw JSON value of [readBackTo]. */
    @JsonProperty("readBackTo") @ExcludeMissing fun _readBackTo(): JsonField<OffsetDateTime> = readBackTo

    /** Returns the raw JSON value of [windowComplete]. */
    @JsonProperty("windowComplete") @ExcludeMissing fun _windowComplete(): JsonField<Boolean> = windowComplete

    /** Returns the raw JSON value of [searchedQuery]. */
    @JsonProperty("searchedQuery") @ExcludeMissing fun _searchedQuery(): JsonField<String> = searchedQuery

    /** Returns the raw JSON value of [searchContext]. */
    @JsonProperty("searchContext") @ExcludeMissing fun _searchContext(): JsonField<SearchContext> = searchContext

    /** Returns the raw JSON value of [query]. */
    @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<String> = query

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

        /** Returns a mutable builder for constructing an instance of [SportsGamePosts]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SportsGamePosts]. */
    class Builder internal constructor() {

        private var filteredCount: JsonField<Long> = JsonMissing.of()
        private var tweets: JsonField<MutableList<SearchTweet>>? = null
        private var hasNextPage: JsonField<Boolean>? = null
        private var nextCursor: JsonField<String>? = null
        private var readBackTo: JsonField<OffsetDateTime> = JsonMissing.of()
        private var windowComplete: JsonField<Boolean> = JsonMissing.of()
        private var searchedQuery: JsonField<String> = JsonMissing.of()
        private var searchContext: JsonField<SearchContext> = JsonMissing.of()
        private var query: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(sportsGamePosts: SportsGamePosts) = apply {
            filteredCount = sportsGamePosts.filteredCount
            tweets = sportsGamePosts.tweets.map { it.toMutableList() }
            hasNextPage = sportsGamePosts.hasNextPage
            nextCursor = sportsGamePosts.nextCursor
            readBackTo = sportsGamePosts.readBackTo
            windowComplete = sportsGamePosts.windowComplete
            searchedQuery = sportsGamePosts.searchedQuery
            searchContext = sportsGamePosts.searchContext
            query = sportsGamePosts.query
            additionalProperties = sportsGamePosts.additionalProperties.toMutableMap()
        }

        /** Whole number from 0. */
        fun filteredCount(filteredCount: Long) = filteredCount(JsonField.of(filteredCount))

        /** Sets [Builder.filteredCount] to an arbitrary JSON value. */
        fun filteredCount(filteredCount: JsonField<Long>) = apply { this.filteredCount = filteredCount }

        fun tweets(tweets: List<SearchTweet>) = tweets(JsonField.of(tweets))

        /** Sets [Builder.tweets] to an arbitrary JSON value. */
        fun tweets(tweets: JsonField<List<SearchTweet>>) = apply { this.tweets = tweets.map { it.toMutableList() } }

        /** Adds a single [SearchTweet] to [tweets]. */
        fun addTweet(tweet: SearchTweet) = apply {
            tweets =
                (tweets ?: JsonField.of(mutableListOf())).also {
                    checkKnown("tweets", it).add(tweet)
                }
        }

        fun hasNextPage(hasNextPage: Boolean) = hasNextPage(JsonField.of(hasNextPage))

        /** Sets [Builder.hasNextPage] to an arbitrary JSON value. */
        fun hasNextPage(hasNextPage: JsonField<Boolean>) = apply { this.hasNextPage = hasNextPage }

        /** Cursor for the next page. Send it unchanged. Each next page arrives fast. */
        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /** Sets [Builder.nextCursor] to an arbitrary JSON value. */
        fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

        /** The UTC time this filtered search has reached. */
        fun readBackTo(readBackTo: OffsetDateTime) = readBackTo(JsonField.of(readBackTo))

        /** Sets [Builder.readBackTo] to an arbitrary JSON value. */
        fun readBackTo(readBackTo: JsonField<OffsetDateTime>) = apply { this.readBackTo = readBackTo }

        /** Present on a last page whose sources all read past its start time. */
        fun windowComplete(windowComplete: Boolean) = windowComplete(JsonField.of(windowComplete))

        /** Sets [Builder.windowComplete] to an arbitrary JSON value. */
        fun windowComplete(windowComplete: JsonField<Boolean>) = apply { this.windowComplete = windowComplete }

        /** The query that ran, when it differs from your q. */
        fun searchedQuery(searchedQuery: String) = searchedQuery(JsonField.of(searchedQuery))

        /** Sets [Builder.searchedQuery] to an arbitrary JSON value. */
        fun searchedQuery(searchedQuery: JsonField<String>) = apply { this.searchedQuery = searchedQuery }

        /** What X shows beside a search's posts, the same for everyone. Present on a search for a cashtag X has a card for, such as $BTC. Cashtag searches add X's ticker card in `searchContext`. */
        fun searchContext(searchContext: SearchContext) = searchContext(JsonField.of(searchContext))

        /** Sets [Builder.searchContext] to an arbitrary JSON value. */
        fun searchContext(searchContext: JsonField<SearchContext>) = apply { this.searchContext = searchContext }

        /** An X search for this game's posts, in the order asked. Send it to GET /x/tweets/search for more filters. Null when no search is available. */
        fun query(query: String?) = query(JsonField.ofNullable(query))

        /** Alias for calling [Builder.query] with `query.orElse(null)`. */
        fun query(query: Optional<String>) = query(query.getOrNull())

        /** Sets [Builder.query] to an arbitrary JSON value. */
        fun query(query: JsonField<String>) = apply { this.query = query }

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
         * Returns an immutable instance of [SportsGamePosts].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SportsGamePosts =
            SportsGamePosts(
                filteredCount,
                checkRequired("tweets", tweets).map { it.toImmutable() },
                checkRequired("hasNextPage", hasNextPage),
                checkRequired("nextCursor", nextCursor),
                readBackTo,
                windowComplete,
                searchedQuery,
                searchContext,
                checkRequired("query", query),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match its expected type.
     */
    fun validate(): SportsGamePosts = apply {
        if (validated) {
            return@apply
        }

        filteredCount()
        tweets().forEach { it.validate() }
        hasNextPage()
        nextCursor()
        readBackTo()
        windowComplete()
        searchedQuery()
        searchContext().ifPresent { it.validate() }
        query()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    @JvmSynthetic internal fun validity(): Int =
        (if (filteredCount.asKnown().isPresent) 1 else 0) +
            (tweets.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (hasNextPage.asKnown().isPresent) 1 else 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0) +
            (if (readBackTo.asKnown().isPresent) 1 else 0) +
            (if (windowComplete.asKnown().isPresent) 1 else 0) +
            (if (searchedQuery.asKnown().isPresent) 1 else 0) +
            (searchContext.asKnown().getOrNull()?.validity() ?: 0) +
            (if (query.asKnown().isPresent) 1 else 0)

    /** What X shows beside a search's posts, the same for everyone. Present on a search for a cashtag X has a card for, such as $BTC. Cashtag searches add X's ticker card in `searchContext`. */
    class SearchContext
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val smartTag: JsonField<SmartTag>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("smartTag") @ExcludeMissing smartTag: JsonField<SmartTag> = JsonMissing.of(),
        ) : this(smartTag, mutableMapOf())

        /** X's card for the cashtag the search names. */
        fun smartTag(): SmartTag = smartTag.getRequired("smartTag")

        /** Returns the raw JSON value of [smartTag]. */
        @JsonProperty("smartTag") @ExcludeMissing fun _smartTag(): JsonField<SmartTag> = smartTag

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

            /** Returns a mutable builder for constructing an instance of [SearchContext]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [SearchContext]. */
        class Builder internal constructor() {

            private var smartTag: JsonField<SmartTag>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic internal fun from(searchContext: SearchContext) = apply {
                smartTag = searchContext.smartTag
                additionalProperties = searchContext.additionalProperties.toMutableMap()
            }

            /** X's card for the cashtag the search names. */
            fun smartTag(smartTag: SmartTag) = smartTag(JsonField.of(smartTag))

            /** Sets [Builder.smartTag] to an arbitrary JSON value. */
            fun smartTag(smartTag: JsonField<SmartTag>) = apply { this.smartTag = smartTag }

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
             * Returns an immutable instance of [SearchContext].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): SearchContext =
                SearchContext(
                    checkRequired("smartTag", smartTag),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types recursively.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match its expected type.
         */
        fun validate(): SearchContext = apply {
            if (validated) {
                return@apply
            }

            smartTag().validate()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        @JvmSynthetic internal fun validity(): Int =
            (smartTag.asKnown().getOrNull()?.validity() ?: 0)

        /** X's card for the cashtag the search names. */
        class SmartTag
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val active: JsonField<Boolean>,
            private val supportsOhlc: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("active") @ExcludeMissing active: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("supportsOhlc") @ExcludeMissing supportsOhlc: JsonField<Boolean> = JsonMissing.of(),
            ) : this(id, active, supportsOhlc, mutableMapOf())

            /** The ticker X matched. */
            fun id(): String = id.getRequired("id")

            /** Whether X lists the ticker as active. */
            fun active(): Optional<Boolean> = active.getOptional("active")

            /** Whether X charts the ticker with open, high, low & close prices. */
            fun supportsOhlc(): Optional<Boolean> = supportsOhlc.getOptional("supportsOhlc")

            /** Returns the raw JSON value of [id]. */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /** Returns the raw JSON value of [active]. */
            @JsonProperty("active") @ExcludeMissing fun _active(): JsonField<Boolean> = active

            /** Returns the raw JSON value of [supportsOhlc]. */
            @JsonProperty("supportsOhlc") @ExcludeMissing fun _supportsOhlc(): JsonField<Boolean> = supportsOhlc

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

                /** Returns a mutable builder for constructing an instance of [SmartTag]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [SmartTag]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var active: JsonField<Boolean> = JsonMissing.of()
                private var supportsOhlc: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic internal fun from(smartTag: SmartTag) = apply {
                    id = smartTag.id
                    active = smartTag.active
                    supportsOhlc = smartTag.supportsOhlc
                    additionalProperties = smartTag.additionalProperties.toMutableMap()
                }

                /** The ticker X matched. */
                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** Whether X lists the ticker as active. */
                fun active(active: Boolean) = active(JsonField.of(active))

                /** Sets [Builder.active] to an arbitrary JSON value. */
                fun active(active: JsonField<Boolean>) = apply { this.active = active }

                /** Whether X charts the ticker with open, high, low & close prices. */
                fun supportsOhlc(supportsOhlc: Boolean) = supportsOhlc(JsonField.of(supportsOhlc))

                /** Sets [Builder.supportsOhlc] to an arbitrary JSON value. */
                fun supportsOhlc(supportsOhlc: JsonField<Boolean>) = apply { this.supportsOhlc = supportsOhlc }

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
                 * Returns an immutable instance of [SmartTag].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): SmartTag =
                    SmartTag(
                        checkRequired("id", id),
                        active,
                        supportsOhlc,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types recursively.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match its expected type.
             */
            fun validate(): SmartTag = apply {
                if (validated) {
                    return@apply
                }

                id()
                active()
                supportsOhlc()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            @JvmSynthetic internal fun validity(): Int =
                (if (id.asKnown().isPresent) 1 else 0) +
                    (if (active.asKnown().isPresent) 1 else 0) +
                    (if (supportsOhlc.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is SmartTag &&
                    id == other.id &&
                    active == other.active &&
                    supportsOhlc == other.supportsOhlc &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(id, active, supportsOhlc, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "SmartTag{id=$id, active=$active, supportsOhlc=$supportsOhlc, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is SearchContext &&
                smartTag == other.smartTag &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(smartTag, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "SearchContext{smartTag=$smartTag, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SportsGamePosts &&
            filteredCount == other.filteredCount &&
            tweets == other.tweets &&
            hasNextPage == other.hasNextPage &&
            nextCursor == other.nextCursor &&
            readBackTo == other.readBackTo &&
            windowComplete == other.windowComplete &&
            searchedQuery == other.searchedQuery &&
            searchContext == other.searchContext &&
            query == other.query &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(filteredCount, tweets, hasNextPage, nextCursor, readBackTo, windowComplete, searchedQuery, searchContext, query, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SportsGamePosts{filteredCount=$filteredCount, tweets=$tweets, hasNextPage=$hasNextPage, nextCursor=$nextCursor, readBackTo=$readBackTo, windowComplete=$windowComplete, searchedQuery=$searchedQuery, searchContext=$searchContext, query=$query, additionalProperties=$additionalProperties}"
}
