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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class StyleUpdateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val fetchedAt: JsonField<OffsetDateTime>,
    private val isOwnAccount: JsonField<Boolean>,
    private val tweetCount: JsonField<Long>,
    private val tweets: JsonField<List<Tweet>>,
    private val xUsername: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("fetchedAt")
        @ExcludeMissing
        fetchedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("isOwnAccount")
        @ExcludeMissing
        isOwnAccount: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("tweetCount") @ExcludeMissing tweetCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("tweets") @ExcludeMissing tweets: JsonField<List<Tweet>> = JsonMissing.of(),
        @JsonProperty("xUsername") @ExcludeMissing xUsername: JsonField<String> = JsonMissing.of(),
    ) : this(fetchedAt, isOwnAccount, tweetCount, tweets, xUsername, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fetchedAt(): OffsetDateTime = fetchedAt.getRequired("fetchedAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isOwnAccount(): Boolean = isOwnAccount.getRequired("isOwnAccount")

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
     * Returns the raw JSON value of [fetchedAt].
     *
     * Unlike [fetchedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fetchedAt")
    @ExcludeMissing
    fun _fetchedAt(): JsonField<OffsetDateTime> = fetchedAt

    /**
     * Returns the raw JSON value of [isOwnAccount].
     *
     * Unlike [isOwnAccount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isOwnAccount")
    @ExcludeMissing
    fun _isOwnAccount(): JsonField<Boolean> = isOwnAccount

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
         * Returns a mutable builder for constructing an instance of [StyleUpdateResponse].
         *
         * The following fields are required:
         * ```java
         * .fetchedAt()
         * .isOwnAccount()
         * .tweetCount()
         * .tweets()
         * .xUsername()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StyleUpdateResponse]. */
    class Builder internal constructor() {

        private var fetchedAt: JsonField<OffsetDateTime>? = null
        private var isOwnAccount: JsonField<Boolean>? = null
        private var tweetCount: JsonField<Long>? = null
        private var tweets: JsonField<MutableList<Tweet>>? = null
        private var xUsername: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(styleUpdateResponse: StyleUpdateResponse) = apply {
            fetchedAt = styleUpdateResponse.fetchedAt
            isOwnAccount = styleUpdateResponse.isOwnAccount
            tweetCount = styleUpdateResponse.tweetCount
            tweets = styleUpdateResponse.tweets.map { it.toMutableList() }
            xUsername = styleUpdateResponse.xUsername
            additionalProperties = styleUpdateResponse.additionalProperties.toMutableMap()
        }

        fun fetchedAt(fetchedAt: OffsetDateTime) = fetchedAt(JsonField.of(fetchedAt))

        /**
         * Sets [Builder.fetchedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fetchedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun fetchedAt(fetchedAt: JsonField<OffsetDateTime>) = apply { this.fetchedAt = fetchedAt }

        fun isOwnAccount(isOwnAccount: Boolean) = isOwnAccount(JsonField.of(isOwnAccount))

        /**
         * Sets [Builder.isOwnAccount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isOwnAccount] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isOwnAccount(isOwnAccount: JsonField<Boolean>) = apply {
            this.isOwnAccount = isOwnAccount
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
         * Returns an immutable instance of [StyleUpdateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .fetchedAt()
         * .isOwnAccount()
         * .tweetCount()
         * .tweets()
         * .xUsername()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StyleUpdateResponse =
            StyleUpdateResponse(
                checkRequired("fetchedAt", fetchedAt),
                checkRequired("isOwnAccount", isOwnAccount),
                checkRequired("tweetCount", tweetCount),
                checkRequired("tweets", tweets).map { it.toImmutable() },
                checkRequired("xUsername", xUsername),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): StyleUpdateResponse = apply {
        if (validated) {
            return@apply
        }

        fetchedAt()
        isOwnAccount()
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
        (if (fetchedAt.asKnown().isPresent) 1 else 0) +
            (if (isOwnAccount.asKnown().isPresent) 1 else 0) +
            (if (tweetCount.asKnown().isPresent) 1 else 0) +
            (tweets.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (xUsername.asKnown().isPresent) 1 else 0)

    class Tweet
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val text: JsonField<String>,
        private val authorUsername: JsonField<String>,
        private val createdAt: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("authorUsername")
            @ExcludeMissing
            authorUsername: JsonField<String> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<String> = JsonMissing.of(),
        ) : this(id, text, authorUsername, createdAt, mutableMapOf())

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
        fun authorUsername(): Optional<String> = authorUsername.getOptional("authorUsername")

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
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

        /**
         * Returns the raw JSON value of [authorUsername].
         *
         * Unlike [authorUsername], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("authorUsername")
        @ExcludeMissing
        fun _authorUsername(): JsonField<String> = authorUsername

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
             * .text()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Tweet]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var text: JsonField<String>? = null
            private var authorUsername: JsonField<String> = JsonMissing.of()
            private var createdAt: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(tweet: Tweet) = apply {
                id = tweet.id
                text = tweet.text
                authorUsername = tweet.authorUsername
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

            fun text(text: String) = text(JsonField.of(text))

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun text(text: JsonField<String>) = apply { this.text = text }

            fun authorUsername(authorUsername: String) =
                authorUsername(JsonField.of(authorUsername))

            /**
             * Sets [Builder.authorUsername] to an arbitrary JSON value.
             *
             * You should usually call [Builder.authorUsername] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun authorUsername(authorUsername: JsonField<String>) = apply {
                this.authorUsername = authorUsername
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
                    authorUsername,
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
            text()
            authorUsername()
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
                (if (text.asKnown().isPresent) 1 else 0) +
                (if (authorUsername.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Tweet &&
                id == other.id &&
                text == other.text &&
                authorUsername == other.authorUsername &&
                createdAt == other.createdAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, text, authorUsername, createdAt, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Tweet{id=$id, text=$text, authorUsername=$authorUsername, createdAt=$createdAt, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StyleUpdateResponse &&
            fetchedAt == other.fetchedAt &&
            isOwnAccount == other.isOwnAccount &&
            tweetCount == other.tweetCount &&
            tweets == other.tweets &&
            xUsername == other.xUsername &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(fetchedAt, isOwnAccount, tweetCount, tweets, xUsername, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StyleUpdateResponse{fetchedAt=$fetchedAt, isOwnAccount=$isOwnAccount, tweetCount=$tweetCount, tweets=$tweets, xUsername=$xUsername, additionalProperties=$additionalProperties}"
}
