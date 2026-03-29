// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.styles

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

class StyleGetPerformanceResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val tweetCount: JsonField<Long>,
    private val tweets: JsonField<List<Tweet>>,
    private val xUsername: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("tweetCount") @ExcludeMissing tweetCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("tweets") @ExcludeMissing tweets: JsonField<List<Tweet>> = JsonMissing.of(),
        @JsonProperty("xUsername") @ExcludeMissing xUsername: JsonField<String> = JsonMissing.of(),
    ) : this(tweetCount, tweets, xUsername, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tweetCount(): Long = tweetCount.getRequired("tweetCount")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tweets(): List<Tweet> = tweets.getRequired("tweets")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun xUsername(): String = xUsername.getRequired("xUsername")

    /**
     * Returns the raw JSON value of [tweetCount].
     *
     * Unlike [tweetCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tweetCount") @ExcludeMissing fun _tweetCount(): JsonField<Long> = tweetCount

    /**
     * Returns the raw JSON value of [tweets].
     *
     * Unlike [tweets], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tweets") @ExcludeMissing fun _tweets(): JsonField<List<Tweet>> = tweets

    /**
     * Returns the raw JSON value of [xUsername].
     *
     * Unlike [xUsername], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("xUsername") @ExcludeMissing fun _xUsername(): JsonField<String> = xUsername

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
         * Returns a mutable builder for constructing an instance of [StyleGetPerformanceResponse].
         *
         * The following fields are required:
         * ```java
         * .tweetCount()
         * .tweets()
         * .xUsername()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StyleGetPerformanceResponse]. */
    class Builder internal constructor() {

        private var tweetCount: JsonField<Long>? = null
        private var tweets: JsonField<MutableList<Tweet>>? = null
        private var xUsername: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(styleGetPerformanceResponse: StyleGetPerformanceResponse) = apply {
            tweetCount = styleGetPerformanceResponse.tweetCount
            tweets = styleGetPerformanceResponse.tweets.map { it.toMutableList() }
            xUsername = styleGetPerformanceResponse.xUsername
            additionalProperties = styleGetPerformanceResponse.additionalProperties.toMutableMap()
        }

        fun tweetCount(tweetCount: Long) = tweetCount(JsonField.of(tweetCount))

        /**
         * Sets [Builder.tweetCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tweetCount] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tweetCount(tweetCount: JsonField<Long>) = apply { this.tweetCount = tweetCount }

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

        fun xUsername(xUsername: String) = xUsername(JsonField.of(xUsername))

        /**
         * Sets [Builder.xUsername] to an arbitrary JSON value.
         *
         * You should usually call [Builder.xUsername] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun xUsername(xUsername: JsonField<String>) = apply { this.xUsername = xUsername }

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
         * Returns an immutable instance of [StyleGetPerformanceResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .tweetCount()
         * .tweets()
         * .xUsername()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StyleGetPerformanceResponse =
            StyleGetPerformanceResponse(
                checkRequired("tweetCount", tweetCount),
                checkRequired("tweets", tweets).map { it.toImmutable() },
                checkRequired("xUsername", xUsername),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): StyleGetPerformanceResponse = apply {
        if (validated) {
            return@apply
        }

        tweetCount()
        tweets().forEach { it.validate() }
        xUsername()
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
        (if (tweetCount.asKnown().isPresent) 1 else 0) +
            (tweets.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (xUsername.asKnown().isPresent) 1 else 0)

    class Tweet
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val text: JsonField<String>,
        private val createdAt: JsonField<String>,
        private val likeCount: JsonField<Long>,
        private val replyCount: JsonField<Long>,
        private val retweetCount: JsonField<Long>,
        private val viewCount: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("likeCount")
            @ExcludeMissing
            likeCount: JsonField<Long> = JsonMissing.of(),
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
            createdAt,
            likeCount,
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
        fun createdAt(): Optional<String> = createdAt.getOptional("createdAt")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun likeCount(): Optional<Long> = likeCount.getOptional("likeCount")

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
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

        /**
         * Returns the raw JSON value of [likeCount].
         *
         * Unlike [likeCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("likeCount") @ExcludeMissing fun _likeCount(): JsonField<Long> = likeCount

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
            private var createdAt: JsonField<String> = JsonMissing.of()
            private var likeCount: JsonField<Long> = JsonMissing.of()
            private var replyCount: JsonField<Long> = JsonMissing.of()
            private var retweetCount: JsonField<Long> = JsonMissing.of()
            private var viewCount: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(tweet: Tweet) = apply {
                id = tweet.id
                text = tweet.text
                createdAt = tweet.createdAt
                likeCount = tweet.likeCount
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

            fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

            fun likeCount(likeCount: Long) = likeCount(JsonField.of(likeCount))

            /**
             * Sets [Builder.likeCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.likeCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun likeCount(likeCount: JsonField<Long>) = apply { this.likeCount = likeCount }

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
                    createdAt,
                    likeCount,
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
            createdAt()
            likeCount()
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
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (likeCount.asKnown().isPresent) 1 else 0) +
                (if (replyCount.asKnown().isPresent) 1 else 0) +
                (if (retweetCount.asKnown().isPresent) 1 else 0) +
                (if (viewCount.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Tweet &&
                id == other.id &&
                text == other.text &&
                createdAt == other.createdAt &&
                likeCount == other.likeCount &&
                replyCount == other.replyCount &&
                retweetCount == other.retweetCount &&
                viewCount == other.viewCount &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                text,
                createdAt,
                likeCount,
                replyCount,
                retweetCount,
                viewCount,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Tweet{id=$id, text=$text, createdAt=$createdAt, likeCount=$likeCount, replyCount=$replyCount, retweetCount=$retweetCount, viewCount=$viewCount, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StyleGetPerformanceResponse &&
            tweetCount == other.tweetCount &&
            tweets == other.tweets &&
            xUsername == other.xUsername &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(tweetCount, tweets, xUsername, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StyleGetPerformanceResponse{tweetCount=$tweetCount, tweets=$tweets, xUsername=$xUsername, additionalProperties=$additionalProperties}"
}
