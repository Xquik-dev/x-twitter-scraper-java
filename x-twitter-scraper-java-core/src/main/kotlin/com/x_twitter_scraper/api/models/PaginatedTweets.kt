// File generated from our OpenAPI spec by Stainless.

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Paginated list of tweets with cursor-based navigation. */
class PaginatedTweets
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val hasNextPage: JsonField<Boolean>,
    private val nextCursor: JsonField<String>,
    private val tweets: JsonField<List<Tweet>>,
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
        @JsonProperty("tweets") @ExcludeMissing tweets: JsonField<List<Tweet>> = JsonMissing.of(),
    ) : this(hasNextPage, nextCursor, tweets, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun hasNextPage(): Boolean = hasNextPage.getRequired("has_next_page")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun nextCursor(): String = nextCursor.getRequired("next_cursor")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tweets(): List<Tweet> = tweets.getRequired("tweets")

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
    @JsonProperty("tweets") @ExcludeMissing fun _tweets(): JsonField<List<Tweet>> = tweets

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
        private var tweets: JsonField<MutableList<Tweet>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(paginatedTweets: PaginatedTweets) = apply {
            hasNextPage = paginatedTweets.hasNextPage
            nextCursor = paginatedTweets.nextCursor
            tweets = paginatedTweets.tweets.map { it.toMutableList() }
            additionalProperties = paginatedTweets.additionalProperties.toMutableMap()
        }

        fun hasNextPage(hasNextPage: Boolean) = hasNextPage(JsonField.of(hasNextPage))

        /**
         * Sets [Builder.hasNextPage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasNextPage] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun hasNextPage(hasNextPage: JsonField<Boolean>) = apply { this.hasNextPage = hasNextPage }

        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /**
         * Sets [Builder.nextCursor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextCursor] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

        fun tweets(tweets: List<Tweet>) = tweets(JsonField.of(tweets))

        /**
         * Sets [Builder.tweets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tweets] with a well-typed `List<Tweet>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tweets(tweets: JsonField<List<Tweet>>) = apply {
            this.tweets = tweets.map { it.toMutableList() }
        }

        /**
         * Adds a single [Tweet] to [tweets].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTweet(tweet: Tweet) = apply {
            tweets =
                (tweets ?: JsonField.of(mutableListOf())).also {
                    checkKnown("tweets", it).add(tweet)
                }
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
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): PaginatedTweets = apply {
        if (validated) {
            return@apply
        }

        hasNextPage()
        nextCursor()
        tweets().forEach { it.validate() }
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (hasNextPage.asKnown().isPresent) 1 else 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0) +
            (tweets.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** Tweet returned from search results with inline author info. */
    class Tweet
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val text: JsonField<String>,
        private val author: JsonField<Author>,
        private val bookmarkCount: JsonField<Long>,
        private val createdAt: JsonField<String>,
        private val isNoteTweet: JsonField<Boolean>,
        private val likeCount: JsonField<Long>,
        private val quoteCount: JsonField<Long>,
        private val replyCount: JsonField<Long>,
        private val retweetCount: JsonField<Long>,
        private val viewCount: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("author") @ExcludeMissing author: JsonField<Author> = JsonMissing.of(),
            @JsonProperty("bookmarkCount")
            @ExcludeMissing
            bookmarkCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("isNoteTweet")
            @ExcludeMissing
            isNoteTweet: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("likeCount")
            @ExcludeMissing
            likeCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("quoteCount")
            @ExcludeMissing
            quoteCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("replyCount")
            @ExcludeMissing
            replyCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("retweetCount")
            @ExcludeMissing
            retweetCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("viewCount") @ExcludeMissing viewCount: JsonField<Long> = JsonMissing.of(),
        ) : this(
            id,
            text,
            author,
            bookmarkCount,
            createdAt,
            isNoteTweet,
            likeCount,
            quoteCount,
            replyCount,
            retweetCount,
            viewCount,
            mutableMapOf(),
        )

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun text(): String = text.getRequired("text")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun author(): Optional<Author> = author.getOptional("author")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun bookmarkCount(): Optional<Long> = bookmarkCount.getOptional("bookmarkCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun createdAt(): Optional<String> = createdAt.getOptional("createdAt")

        /**
         * True for Note Tweets (long-form content, up to 25,000 characters)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun isNoteTweet(): Optional<Boolean> = isNoteTweet.getOptional("isNoteTweet")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun likeCount(): Optional<Long> = likeCount.getOptional("likeCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun quoteCount(): Optional<Long> = quoteCount.getOptional("quoteCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun replyCount(): Optional<Long> = replyCount.getOptional("replyCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun retweetCount(): Optional<Long> = retweetCount.getOptional("retweetCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun viewCount(): Optional<Long> = viewCount.getOptional("viewCount")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

        /**
         * Returns the raw JSON value of [author].
         *
         * Unlike [author], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("author") @ExcludeMissing fun _author(): JsonField<Author> = author

        /**
         * Returns the raw JSON value of [bookmarkCount].
         *
         * Unlike [bookmarkCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("bookmarkCount")
        @ExcludeMissing
        fun _bookmarkCount(): JsonField<Long> = bookmarkCount

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

        /**
         * Returns the raw JSON value of [isNoteTweet].
         *
         * Unlike [isNoteTweet], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isNoteTweet")
        @ExcludeMissing
        fun _isNoteTweet(): JsonField<Boolean> = isNoteTweet

        /**
         * Returns the raw JSON value of [likeCount].
         *
         * Unlike [likeCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("likeCount") @ExcludeMissing fun _likeCount(): JsonField<Long> = likeCount

        /**
         * Returns the raw JSON value of [quoteCount].
         *
         * Unlike [quoteCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("quoteCount") @ExcludeMissing fun _quoteCount(): JsonField<Long> = quoteCount

        /**
         * Returns the raw JSON value of [replyCount].
         *
         * Unlike [replyCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("replyCount") @ExcludeMissing fun _replyCount(): JsonField<Long> = replyCount

        /**
         * Returns the raw JSON value of [retweetCount].
         *
         * Unlike [retweetCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("retweetCount")
        @ExcludeMissing
        fun _retweetCount(): JsonField<Long> = retweetCount

        /**
         * Returns the raw JSON value of [viewCount].
         *
         * Unlike [viewCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("viewCount") @ExcludeMissing fun _viewCount(): JsonField<Long> = viewCount

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
             * Returns a mutable builder for constructing an instance of [Tweet].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .text()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Tweet]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var text: JsonField<String>? = null
            private var author: JsonField<Author> = JsonMissing.of()
            private var bookmarkCount: JsonField<Long> = JsonMissing.of()
            private var createdAt: JsonField<String> = JsonMissing.of()
            private var isNoteTweet: JsonField<Boolean> = JsonMissing.of()
            private var likeCount: JsonField<Long> = JsonMissing.of()
            private var quoteCount: JsonField<Long> = JsonMissing.of()
            private var replyCount: JsonField<Long> = JsonMissing.of()
            private var retweetCount: JsonField<Long> = JsonMissing.of()
            private var viewCount: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(tweet: Tweet) = apply {
                id = tweet.id
                text = tweet.text
                author = tweet.author
                bookmarkCount = tweet.bookmarkCount
                createdAt = tweet.createdAt
                isNoteTweet = tweet.isNoteTweet
                likeCount = tweet.likeCount
                quoteCount = tweet.quoteCount
                replyCount = tweet.replyCount
                retweetCount = tweet.retweetCount
                viewCount = tweet.viewCount
                additionalProperties = tweet.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun text(text: String) = text(JsonField.of(text))

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun text(text: JsonField<String>) = apply { this.text = text }

            fun author(author: Author) = author(JsonField.of(author))

            /**
             * Sets [Builder.author] to an arbitrary JSON value.
             *
             * You should usually call [Builder.author] with a well-typed [Author] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun author(author: JsonField<Author>) = apply { this.author = author }

            fun bookmarkCount(bookmarkCount: Long) = bookmarkCount(JsonField.of(bookmarkCount))

            /**
             * Sets [Builder.bookmarkCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bookmarkCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bookmarkCount(bookmarkCount: JsonField<Long>) = apply {
                this.bookmarkCount = bookmarkCount
            }

            fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

            /** True for Note Tweets (long-form content, up to 25,000 characters) */
            fun isNoteTweet(isNoteTweet: Boolean) = isNoteTweet(JsonField.of(isNoteTweet))

            /**
             * Sets [Builder.isNoteTweet] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isNoteTweet] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isNoteTweet(isNoteTweet: JsonField<Boolean>) = apply {
                this.isNoteTweet = isNoteTweet
            }

            fun likeCount(likeCount: Long) = likeCount(JsonField.of(likeCount))

            /**
             * Sets [Builder.likeCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.likeCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun likeCount(likeCount: JsonField<Long>) = apply { this.likeCount = likeCount }

            fun quoteCount(quoteCount: Long) = quoteCount(JsonField.of(quoteCount))

            /**
             * Sets [Builder.quoteCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.quoteCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun quoteCount(quoteCount: JsonField<Long>) = apply { this.quoteCount = quoteCount }

            fun replyCount(replyCount: Long) = replyCount(JsonField.of(replyCount))

            /**
             * Sets [Builder.replyCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.replyCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun replyCount(replyCount: JsonField<Long>) = apply { this.replyCount = replyCount }

            fun retweetCount(retweetCount: Long) = retweetCount(JsonField.of(retweetCount))

            /**
             * Sets [Builder.retweetCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.retweetCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun retweetCount(retweetCount: JsonField<Long>) = apply {
                this.retweetCount = retweetCount
            }

            fun viewCount(viewCount: Long) = viewCount(JsonField.of(viewCount))

            /**
             * Sets [Builder.viewCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.viewCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun viewCount(viewCount: JsonField<Long>) = apply { this.viewCount = viewCount }

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
             * Returns an immutable instance of [Tweet].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .text()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Tweet =
                Tweet(
                    checkRequired("id", id),
                    checkRequired("text", text),
                    author,
                    bookmarkCount,
                    createdAt,
                    isNoteTweet,
                    likeCount,
                    quoteCount,
                    replyCount,
                    retweetCount,
                    viewCount,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Tweet = apply {
            if (validated) {
                return@apply
            }

            id()
            text()
            author().ifPresent { it.validate() }
            bookmarkCount()
            createdAt()
            isNoteTweet()
            likeCount()
            quoteCount()
            replyCount()
            retweetCount()
            viewCount()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (text.asKnown().isPresent) 1 else 0) +
                (author.asKnown().getOrNull()?.validity() ?: 0) +
                (if (bookmarkCount.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (isNoteTweet.asKnown().isPresent) 1 else 0) +
                (if (likeCount.asKnown().isPresent) 1 else 0) +
                (if (quoteCount.asKnown().isPresent) 1 else 0) +
                (if (replyCount.asKnown().isPresent) 1 else 0) +
                (if (retweetCount.asKnown().isPresent) 1 else 0) +
                (if (viewCount.asKnown().isPresent) 1 else 0)

        class Author
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val name: JsonField<String>,
            private val username: JsonField<String>,
            private val verified: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("username")
                @ExcludeMissing
                username: JsonField<String> = JsonMissing.of(),
                @JsonProperty("verified")
                @ExcludeMissing
                verified: JsonField<Boolean> = JsonMissing.of(),
            ) : this(id, name, username, verified, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun id(): String = id.getRequired("id")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun username(): String = username.getRequired("username")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun verified(): Optional<Boolean> = verified.getOptional("verified")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [username].
             *
             * Unlike [username], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

            /**
             * Returns the raw JSON value of [verified].
             *
             * Unlike [verified], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("verified") @ExcludeMissing fun _verified(): JsonField<Boolean> = verified

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
                 * Returns a mutable builder for constructing an instance of [Author].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .name()
                 * .username()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Author]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var username: JsonField<String>? = null
                private var verified: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(author: Author) = apply {
                    id = author.id
                    name = author.name
                    username = author.username
                    verified = author.verified
                    additionalProperties = author.additionalProperties.toMutableMap()
                }

                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun username(username: String) = username(JsonField.of(username))

                /**
                 * Sets [Builder.username] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.username] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun username(username: JsonField<String>) = apply { this.username = username }

                fun verified(verified: Boolean) = verified(JsonField.of(verified))

                /**
                 * Sets [Builder.verified] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.verified] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun verified(verified: JsonField<Boolean>) = apply { this.verified = verified }

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
                 * Returns an immutable instance of [Author].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .name()
                 * .username()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Author =
                    Author(
                        checkRequired("id", id),
                        checkRequired("name", name),
                        checkRequired("username", username),
                        verified,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Author = apply {
                if (validated) {
                    return@apply
                }

                id()
                name()
                username()
                verified()
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
                (if (id.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (username.asKnown().isPresent) 1 else 0) +
                    (if (verified.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Author &&
                    id == other.id &&
                    name == other.name &&
                    username == other.username &&
                    verified == other.verified &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(id, name, username, verified, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Author{id=$id, name=$name, username=$username, verified=$verified, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Tweet &&
                id == other.id &&
                text == other.text &&
                author == other.author &&
                bookmarkCount == other.bookmarkCount &&
                createdAt == other.createdAt &&
                isNoteTweet == other.isNoteTweet &&
                likeCount == other.likeCount &&
                quoteCount == other.quoteCount &&
                replyCount == other.replyCount &&
                retweetCount == other.retweetCount &&
                viewCount == other.viewCount &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                text,
                author,
                bookmarkCount,
                createdAt,
                isNoteTweet,
                likeCount,
                quoteCount,
                replyCount,
                retweetCount,
                viewCount,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Tweet{id=$id, text=$text, author=$author, bookmarkCount=$bookmarkCount, createdAt=$createdAt, isNoteTweet=$isNoteTweet, likeCount=$likeCount, quoteCount=$quoteCount, replyCount=$replyCount, retweetCount=$retweetCount, viewCount=$viewCount, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PaginatedTweets &&
            hasNextPage == other.hasNextPage &&
            nextCursor == other.nextCursor &&
            tweets == other.tweets &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(hasNextPage, nextCursor, tweets, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PaginatedTweets{hasNextPage=$hasNextPage, nextCursor=$nextCursor, tweets=$tweets, additionalProperties=$additionalProperties}"
}
