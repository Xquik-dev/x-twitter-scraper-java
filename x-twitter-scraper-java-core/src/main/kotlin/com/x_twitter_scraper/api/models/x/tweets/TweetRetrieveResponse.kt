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
    private val tweet: JsonField<TweetDetail>,
    private val author: JsonField<TweetAuthor>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("tweet") @ExcludeMissing tweet: JsonField<TweetDetail> = JsonMissing.of(),
        @JsonProperty("author") @ExcludeMissing author: JsonField<TweetAuthor> = JsonMissing.of(),
    ) : this(tweet, author, mutableMapOf())

    /**
     * Full tweet with text, engagement metrics, media, and metadata.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tweet(): TweetDetail = tweet.getRequired("tweet")

    /**
     * Author of a tweet with follower count and verification status.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun author(): Optional<TweetAuthor> = author.getOptional("author")

    /**
     * Returns the raw JSON value of [tweet].
     *
     * Unlike [tweet], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tweet") @ExcludeMissing fun _tweet(): JsonField<TweetDetail> = tweet

    /**
     * Returns the raw JSON value of [author].
     *
     * Unlike [author], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("author") @ExcludeMissing fun _author(): JsonField<TweetAuthor> = author

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

        private var tweet: JsonField<TweetDetail>? = null
        private var author: JsonField<TweetAuthor> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tweetRetrieveResponse: TweetRetrieveResponse) = apply {
            tweet = tweetRetrieveResponse.tweet
            author = tweetRetrieveResponse.author
            additionalProperties = tweetRetrieveResponse.additionalProperties.toMutableMap()
        }

        /** Full tweet with text, engagement metrics, media, and metadata. */
        fun tweet(tweet: TweetDetail) = tweet(JsonField.of(tweet))

        /**
         * Sets [Builder.tweet] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tweet] with a well-typed [TweetDetail] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tweet(tweet: JsonField<TweetDetail>) = apply { this.tweet = tweet }

        /** Author of a tweet with follower count and verification status. */
        fun author(author: TweetAuthor) = author(JsonField.of(author))

        /**
         * Sets [Builder.author] to an arbitrary JSON value.
         *
         * You should usually call [Builder.author] with a well-typed [TweetAuthor] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun author(author: JsonField<TweetAuthor>) = apply { this.author = author }

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
