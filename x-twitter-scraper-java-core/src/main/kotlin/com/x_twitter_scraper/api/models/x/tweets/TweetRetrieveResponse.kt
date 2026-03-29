// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TweetRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val tweet: JsonField<Tweet>,
    private val author: JsonField<Author>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("tweet") @ExcludeMissing tweet: JsonField<Tweet> = JsonMissing.of(),
        @JsonProperty("author") @ExcludeMissing author: JsonField<Author> = JsonMissing.of(),
    ) : this(tweet, author, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tweet(): Tweet = tweet.getRequired("tweet")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun author(): Optional<Author> = author.getOptional("author")

    /**
     * Returns the raw JSON value of [tweet].
     *
     * Unlike [tweet], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tweet") @ExcludeMissing fun _tweet(): JsonField<Tweet> = tweet

    /**
     * Returns the raw JSON value of [author].
     *
     * Unlike [author], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("author") @ExcludeMissing fun _author(): JsonField<Author> = author

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
         * Returns a mutable builder for constructing an instance of [TweetRetrieveResponse].
         *
         * The following fields are required:
         * ```java
         * .tweet()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetRetrieveResponse]. */
    class Builder internal constructor() {

        private var tweet: JsonField<Tweet>? = null
        private var author: JsonField<Author> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tweetRetrieveResponse: TweetRetrieveResponse) = apply {
            tweet = tweetRetrieveResponse.tweet
            author = tweetRetrieveResponse.author
            additionalProperties = tweetRetrieveResponse.additionalProperties.toMutableMap()
        }

        fun tweet(tweet: Tweet) = tweet(JsonField.of(tweet))

        /**
         * Sets [Builder.tweet] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tweet] with a well-typed [Tweet] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tweet(tweet: JsonField<Tweet>) = apply { this.tweet = tweet }

        fun author(author: Author) = author(JsonField.of(author))

        /**
         * Sets [Builder.author] to an arbitrary JSON value.
         *
         * You should usually call [Builder.author] with a well-typed [Author] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun author(author: JsonField<Author>) = apply { this.author = author }

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
         * Returns an immutable instance of [TweetRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .tweet()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TweetRetrieveResponse =
            TweetRetrieveResponse(
                checkRequired("tweet", tweet),
                author,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TweetRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        tweet().validate()
        author().ifPresent { it.validate() }
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
        (tweet.asKnown().getOrNull()?.validity() ?: 0) +
            (author.asKnown().getOrNull()?.validity() ?: 0)

    class Tweet
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val bookmarkCount: JsonField<Long>,
        private val likeCount: JsonField<Long>,
        private val quoteCount: JsonField<Long>,
        private val replyCount: JsonField<Long>,
        private val retweetCount: JsonField<Long>,
        private val text: JsonField<String>,
        private val viewCount: JsonField<Long>,
        private val createdAt: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bookmarkCount")
            @ExcludeMissing
            bookmarkCount: JsonField<Long> = JsonMissing.of(),
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
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("viewCount")
            @ExcludeMissing
            viewCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            bookmarkCount,
            likeCount,
            quoteCount,
            replyCount,
            retweetCount,
            text,
            viewCount,
            createdAt,
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
        fun bookmarkCount(): Long = bookmarkCount.getRequired("bookmarkCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun likeCount(): Long = likeCount.getRequired("likeCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun quoteCount(): Long = quoteCount.getRequired("quoteCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun replyCount(): Long = replyCount.getRequired("replyCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun retweetCount(): Long = retweetCount.getRequired("retweetCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun text(): String = text.getRequired("text")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun viewCount(): Long = viewCount.getRequired("viewCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun createdAt(): Optional<String> = createdAt.getOptional("createdAt")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

        /**
         * Returns the raw JSON value of [viewCount].
         *
         * Unlike [viewCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("viewCount") @ExcludeMissing fun _viewCount(): JsonField<Long> = viewCount

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

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
             * .bookmarkCount()
             * .likeCount()
             * .quoteCount()
             * .replyCount()
             * .retweetCount()
             * .text()
             * .viewCount()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Tweet]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var bookmarkCount: JsonField<Long>? = null
            private var likeCount: JsonField<Long>? = null
            private var quoteCount: JsonField<Long>? = null
            private var replyCount: JsonField<Long>? = null
            private var retweetCount: JsonField<Long>? = null
            private var text: JsonField<String>? = null
            private var viewCount: JsonField<Long>? = null
            private var createdAt: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(tweet: Tweet) = apply {
                id = tweet.id
                bookmarkCount = tweet.bookmarkCount
                likeCount = tweet.likeCount
                quoteCount = tweet.quoteCount
                replyCount = tweet.replyCount
                retweetCount = tweet.retweetCount
                text = tweet.text
                viewCount = tweet.viewCount
                createdAt = tweet.createdAt
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

            fun text(text: String) = text(JsonField.of(text))

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun text(text: JsonField<String>) = apply { this.text = text }

            fun viewCount(viewCount: Long) = viewCount(JsonField.of(viewCount))

            /**
             * Sets [Builder.viewCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.viewCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun viewCount(viewCount: JsonField<Long>) = apply { this.viewCount = viewCount }

            fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

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
             * .bookmarkCount()
             * .likeCount()
             * .quoteCount()
             * .replyCount()
             * .retweetCount()
             * .text()
             * .viewCount()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Tweet =
                Tweet(
                    checkRequired("id", id),
                    checkRequired("bookmarkCount", bookmarkCount),
                    checkRequired("likeCount", likeCount),
                    checkRequired("quoteCount", quoteCount),
                    checkRequired("replyCount", replyCount),
                    checkRequired("retweetCount", retweetCount),
                    checkRequired("text", text),
                    checkRequired("viewCount", viewCount),
                    createdAt,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Tweet = apply {
            if (validated) {
                return@apply
            }

            id()
            bookmarkCount()
            likeCount()
            quoteCount()
            replyCount()
            retweetCount()
            text()
            viewCount()
            createdAt()
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
                (if (bookmarkCount.asKnown().isPresent) 1 else 0) +
                (if (likeCount.asKnown().isPresent) 1 else 0) +
                (if (quoteCount.asKnown().isPresent) 1 else 0) +
                (if (replyCount.asKnown().isPresent) 1 else 0) +
                (if (retweetCount.asKnown().isPresent) 1 else 0) +
                (if (text.asKnown().isPresent) 1 else 0) +
                (if (viewCount.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Tweet &&
                id == other.id &&
                bookmarkCount == other.bookmarkCount &&
                likeCount == other.likeCount &&
                quoteCount == other.quoteCount &&
                replyCount == other.replyCount &&
                retweetCount == other.retweetCount &&
                text == other.text &&
                viewCount == other.viewCount &&
                createdAt == other.createdAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                bookmarkCount,
                likeCount,
                quoteCount,
                replyCount,
                retweetCount,
                text,
                viewCount,
                createdAt,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Tweet{id=$id, bookmarkCount=$bookmarkCount, likeCount=$likeCount, quoteCount=$quoteCount, replyCount=$replyCount, retweetCount=$retweetCount, text=$text, viewCount=$viewCount, createdAt=$createdAt, additionalProperties=$additionalProperties}"
    }

    class Author
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val followers: JsonField<Long>,
        private val username: JsonField<String>,
        private val verified: JsonField<Boolean>,
        private val profilePicture: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("followers")
            @ExcludeMissing
            followers: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("username")
            @ExcludeMissing
            username: JsonField<String> = JsonMissing.of(),
            @JsonProperty("verified")
            @ExcludeMissing
            verified: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("profilePicture")
            @ExcludeMissing
            profilePicture: JsonField<String> = JsonMissing.of(),
        ) : this(id, followers, username, verified, profilePicture, mutableMapOf())

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
        fun followers(): Long = followers.getRequired("followers")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun username(): String = username.getRequired("username")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun verified(): Boolean = verified.getRequired("verified")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [followers].
         *
         * Unlike [followers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("followers") @ExcludeMissing fun _followers(): JsonField<Long> = followers

        /**
         * Returns the raw JSON value of [username].
         *
         * Unlike [username], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

        /**
         * Returns the raw JSON value of [verified].
         *
         * Unlike [verified], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("verified") @ExcludeMissing fun _verified(): JsonField<Boolean> = verified

        /**
         * Returns the raw JSON value of [profilePicture].
         *
         * Unlike [profilePicture], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("profilePicture")
        @ExcludeMissing
        fun _profilePicture(): JsonField<String> = profilePicture

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
             * .followers()
             * .username()
             * .verified()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Author]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var followers: JsonField<Long>? = null
            private var username: JsonField<String>? = null
            private var verified: JsonField<Boolean>? = null
            private var profilePicture: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(author: Author) = apply {
                id = author.id
                followers = author.followers
                username = author.username
                verified = author.verified
                profilePicture = author.profilePicture
                additionalProperties = author.additionalProperties.toMutableMap()
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

            fun followers(followers: Long) = followers(JsonField.of(followers))

            /**
             * Sets [Builder.followers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.followers] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun followers(followers: JsonField<Long>) = apply { this.followers = followers }

            fun username(username: String) = username(JsonField.of(username))

            /**
             * Sets [Builder.username] to an arbitrary JSON value.
             *
             * You should usually call [Builder.username] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun username(username: JsonField<String>) = apply { this.username = username }

            fun verified(verified: Boolean) = verified(JsonField.of(verified))

            /**
             * Sets [Builder.verified] to an arbitrary JSON value.
             *
             * You should usually call [Builder.verified] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun verified(verified: JsonField<Boolean>) = apply { this.verified = verified }

            fun profilePicture(profilePicture: String) =
                profilePicture(JsonField.of(profilePicture))

            /**
             * Sets [Builder.profilePicture] to an arbitrary JSON value.
             *
             * You should usually call [Builder.profilePicture] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun profilePicture(profilePicture: JsonField<String>) = apply {
                this.profilePicture = profilePicture
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
             * Returns an immutable instance of [Author].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .followers()
             * .username()
             * .verified()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Author =
                Author(
                    checkRequired("id", id),
                    checkRequired("followers", followers),
                    checkRequired("username", username),
                    checkRequired("verified", verified),
                    profilePicture,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Author = apply {
            if (validated) {
                return@apply
            }

            id()
            followers()
            username()
            verified()
            profilePicture()
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
                (if (followers.asKnown().isPresent) 1 else 0) +
                (if (username.asKnown().isPresent) 1 else 0) +
                (if (verified.asKnown().isPresent) 1 else 0) +
                (if (profilePicture.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Author &&
                id == other.id &&
                followers == other.followers &&
                username == other.username &&
                verified == other.verified &&
                profilePicture == other.profilePicture &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, followers, username, verified, profilePicture, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Author{id=$id, followers=$followers, username=$username, verified=$verified, profilePicture=$profilePicture, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetRetrieveResponse &&
            tweet == other.tweet &&
            author == other.author &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(tweet, author, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TweetRetrieveResponse{tweet=$tweet, author=$author, additionalProperties=$additionalProperties}"
}
