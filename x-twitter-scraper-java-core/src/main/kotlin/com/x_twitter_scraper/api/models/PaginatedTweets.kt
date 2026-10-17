// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * No-mode search, user Tweet, user reply, and direct reply reads use automatic coverage. Shape,
 * filters, aliases, and billing stay compatible. Unprefixed cursors remain legacy. Follow
 * next_cursor while has_next_page is true. An empty filtered page can still have has_next_page
 * true.
 */
class PaginatedTweets
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val hasNextPage: JsonField<Boolean>,
    private val nextCursor: JsonField<String>,
    private val tweets: JsonField<List<SearchTweet>>,
    private val filteredCount: JsonField<Long>,
    private val readBackTo: JsonField<OffsetDateTime>,
    private val searchContext: JsonField<SearchContext>,
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
        @JsonProperty("filtered_count")
        @ExcludeMissing
        filteredCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("readBackTo")
        @ExcludeMissing
        readBackTo: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("searchContext")
        @ExcludeMissing
        searchContext: JsonField<SearchContext> = JsonMissing.of(),
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
        filteredCount,
        readBackTo,
        searchContext,
        searchedQuery,
        windowComplete,
        mutableMapOf(),
    )

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

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun filteredCount(): Optional<Long> = filteredCount.getOptional("filtered_count")

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
    fun searchContext(): Optional<SearchContext> = searchContext.getOptional("searchContext")

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
     * Returns the raw JSON value of [filteredCount].
     *
     * Unlike [filteredCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("filtered_count")
    @ExcludeMissing
    fun _filteredCount(): JsonField<Long> = filteredCount

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
    fun _searchContext(): JsonField<SearchContext> = searchContext

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
         * Returns a mutable builder for constructing an instance of [PaginatedTweets].
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

    /** A builder for [PaginatedTweets]. */
    class Builder internal constructor() {

        private var hasNextPage: JsonField<Boolean>? = null
        private var nextCursor: JsonField<String>? = null
        private var tweets: JsonField<MutableList<SearchTweet>>? = null
        private var filteredCount: JsonField<Long> = JsonMissing.of()
        private var readBackTo: JsonField<OffsetDateTime> = JsonMissing.of()
        private var searchContext: JsonField<SearchContext> = JsonMissing.of()
        private var searchedQuery: JsonField<String> = JsonMissing.of()
        private var windowComplete: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(paginatedTweets: PaginatedTweets) = apply {
            hasNextPage = paginatedTweets.hasNextPage
            nextCursor = paginatedTweets.nextCursor
            tweets = paginatedTweets.tweets.map { it.toMutableList() }
            filteredCount = paginatedTweets.filteredCount
            readBackTo = paginatedTweets.readBackTo
            searchContext = paginatedTweets.searchContext
            searchedQuery = paginatedTweets.searchedQuery
            windowComplete = paginatedTweets.windowComplete
            additionalProperties = paginatedTweets.additionalProperties.toMutableMap()
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

        fun filteredCount(filteredCount: Long) = filteredCount(JsonField.of(filteredCount))

        /** Sets [Builder.filteredCount] to an arbitrary JSON value. */
        fun filteredCount(filteredCount: JsonField<Long>) = apply {
            this.filteredCount = filteredCount
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
        fun searchContext(searchContext: SearchContext) = searchContext(JsonField.of(searchContext))

        /** Sets [Builder.searchContext] to an arbitrary JSON value. */
        fun searchContext(searchContext: JsonField<SearchContext>) = apply {
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
         * Returns an immutable instance of [PaginatedTweets].
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
        fun build(): PaginatedTweets =
            PaginatedTweets(
                checkRequired("hasNextPage", hasNextPage),
                checkRequired("nextCursor", nextCursor),
                checkRequired("tweets", tweets).map { it.toImmutable() },
                filteredCount,
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
    fun validate(): PaginatedTweets = apply {
        if (validated) {
            return@apply
        }

        hasNextPage()
        nextCursor()
        tweets().forEach { it.validate() }
        filteredCount()
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
            (if (filteredCount.asKnown().isPresent) 1 else 0) +
            (if (readBackTo.asKnown().isPresent) 1 else 0) +
            (searchContext.asKnown().getOrNull()?.validity() ?: 0) +
            (if (searchedQuery.asKnown().isPresent) 1 else 0) +
            (if (windowComplete.asKnown().isPresent) 1 else 0)

    /**
     * What X shows beside a search's posts that is the same for every reader. Present on a search
     * for a cashtag X has a card for, such as $BTC.
     */
    class SearchContext
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val smartTag: JsonField<SmartTag>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("smartTag")
            @ExcludeMissing
            smartTag: JsonField<SmartTag> = JsonMissing.of()
        ) : this(smartTag, mutableMapOf())

        /**
         * X's card for the cashtag the search names.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun smartTag(): SmartTag = smartTag.getRequired("smartTag")

        /**
         * Returns the raw JSON value of [smartTag].
         *
         * Unlike [smartTag], this method doesn't throw if the JSON field has an unexpected type.
         */
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

            /**
             * Returns a mutable builder for constructing an instance of [SearchContext].
             *
             * The following fields are required:
             * ```java
             * .smartTag()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [SearchContext]. */
        class Builder internal constructor() {

            private var smartTag: JsonField<SmartTag>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(searchContext: SearchContext) = apply {
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
             * The following fields are required:
             * ```java
             * .smartTag()
             * ```
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
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
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

        @JvmSynthetic
        internal fun validity(): Int = (smartTag.asKnown().getOrNull()?.validity() ?: 0)

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
                @JsonProperty("active")
                @ExcludeMissing
                active: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("supportsOhlc")
                @ExcludeMissing
                supportsOhlc: JsonField<Boolean> = JsonMissing.of(),
            ) : this(id, active, supportsOhlc, mutableMapOf())

            /**
             * The ticker X matched.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun id(): String = id.getRequired("id")

            /**
             * Whether X lists the ticker as active.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun active(): Optional<Boolean> = active.getOptional("active")

            /**
             * Whether X charts the ticker with open, high, low & close prices.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun supportsOhlc(): Optional<Boolean> = supportsOhlc.getOptional("supportsOhlc")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [active].
             *
             * Unlike [active], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("active") @ExcludeMissing fun _active(): JsonField<Boolean> = active

            /**
             * Returns the raw JSON value of [supportsOhlc].
             *
             * Unlike [supportsOhlc], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("supportsOhlc")
            @ExcludeMissing
            fun _supportsOhlc(): JsonField<Boolean> = supportsOhlc

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
                 * Returns a mutable builder for constructing an instance of [SmartTag].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [SmartTag]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var active: JsonField<Boolean> = JsonMissing.of()
                private var supportsOhlc: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(smartTag: SmartTag) = apply {
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
                fun supportsOhlc(supportsOhlc: JsonField<Boolean>) = apply {
                    this.supportsOhlc = supportsOhlc
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
                 * Returns an immutable instance of [SmartTag].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * ```
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
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
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

            @JvmSynthetic
            internal fun validity(): Int =
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

            private val hashCode: Int by lazy {
                Objects.hash(id, active, supportsOhlc, additionalProperties)
            }

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

        return other is PaginatedTweets &&
            hasNextPage == other.hasNextPage &&
            nextCursor == other.nextCursor &&
            tweets == other.tweets &&
            filteredCount == other.filteredCount &&
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
            filteredCount,
            readBackTo,
            searchContext,
            searchedQuery,
            windowComplete,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PaginatedTweets{hasNextPage=$hasNextPage, nextCursor=$nextCursor, tweets=$tweets, filteredCount=$filteredCount, readBackTo=$readBackTo, searchContext=$searchContext, searchedQuery=$searchedQuery, windowComplete=$windowComplete, additionalProperties=$additionalProperties}"
}
