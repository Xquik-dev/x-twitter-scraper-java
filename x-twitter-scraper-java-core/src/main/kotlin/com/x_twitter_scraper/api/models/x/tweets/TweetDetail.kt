// File generated from our OpenAPI spec by Stainless.

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Full tweet with text, engagement metrics, media, and metadata. */
class TweetDetail
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
    private val conversationId: JsonField<String>,
    private val createdAt: JsonField<String>,
    private val entities: JsonField<Entities>,
    private val isNoteTweet: JsonField<Boolean>,
    private val isQuoteStatus: JsonField<Boolean>,
    private val isReply: JsonField<Boolean>,
    private val media: JsonField<List<Media>>,
    private val quotedTweet: JsonField<QuotedTweet>,
    private val source: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("bookmarkCount")
        @ExcludeMissing
        bookmarkCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("likeCount") @ExcludeMissing likeCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("quoteCount") @ExcludeMissing quoteCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("replyCount") @ExcludeMissing replyCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("retweetCount")
        @ExcludeMissing
        retweetCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("viewCount") @ExcludeMissing viewCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("conversationId")
        @ExcludeMissing
        conversationId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("entities") @ExcludeMissing entities: JsonField<Entities> = JsonMissing.of(),
        @JsonProperty("isNoteTweet")
        @ExcludeMissing
        isNoteTweet: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isQuoteStatus")
        @ExcludeMissing
        isQuoteStatus: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isReply") @ExcludeMissing isReply: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("media") @ExcludeMissing media: JsonField<List<Media>> = JsonMissing.of(),
        @JsonProperty("quoted_tweet")
        @ExcludeMissing
        quotedTweet: JsonField<QuotedTweet> = JsonMissing.of(),
        @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        bookmarkCount,
        likeCount,
        quoteCount,
        replyCount,
        retweetCount,
        text,
        viewCount,
        conversationId,
        createdAt,
        entities,
        isNoteTweet,
        isQuoteStatus,
        isReply,
        media,
        quotedTweet,
        source,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun bookmarkCount(): Long = bookmarkCount.getRequired("bookmarkCount")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun likeCount(): Long = likeCount.getRequired("likeCount")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun quoteCount(): Long = quoteCount.getRequired("quoteCount")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun replyCount(): Long = replyCount.getRequired("replyCount")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun retweetCount(): Long = retweetCount.getRequired("retweetCount")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun text(): String = text.getRequired("text")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun viewCount(): Long = viewCount.getRequired("viewCount")

    /**
     * ID of the root tweet in the conversation thread
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun conversationId(): Optional<String> = conversationId.getOptional("conversationId")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun createdAt(): Optional<String> = createdAt.getOptional("createdAt")

    /**
     * Parsed entities from the tweet text (URLs, mentions, hashtags, media)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun entities(): Optional<Entities> = entities.getOptional("entities")

    /**
     * Whether this is a Note Tweet (long-form post, up to 25,000 characters)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun isNoteTweet(): Optional<Boolean> = isNoteTweet.getOptional("isNoteTweet")

    /**
     * Whether this tweet quotes another tweet
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun isQuoteStatus(): Optional<Boolean> = isQuoteStatus.getOptional("isQuoteStatus")

    /**
     * Whether this tweet is a reply to another tweet
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun isReply(): Optional<Boolean> = isReply.getOptional("isReply")

    /**
     * Attached media items, omitted when the tweet has no media
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun media(): Optional<List<Media>> = media.getOptional("media")

    /**
     * The quoted tweet object, present when isQuoteStatus is true
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun quotedTweet(): Optional<QuotedTweet> = quotedTweet.getOptional("quoted_tweet")

    /**
     * Client application used to post this tweet
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun source(): Optional<String> = source.getOptional("source")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [bookmarkCount].
     *
     * Unlike [bookmarkCount], this method doesn't throw if the JSON field has an unexpected type.
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
     * Unlike [retweetCount], this method doesn't throw if the JSON field has an unexpected type.
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
     * Returns the raw JSON value of [conversationId].
     *
     * Unlike [conversationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("conversationId")
    @ExcludeMissing
    fun _conversationId(): JsonField<String> = conversationId

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

    /**
     * Returns the raw JSON value of [entities].
     *
     * Unlike [entities], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("entities") @ExcludeMissing fun _entities(): JsonField<Entities> = entities

    /**
     * Returns the raw JSON value of [isNoteTweet].
     *
     * Unlike [isNoteTweet], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isNoteTweet")
    @ExcludeMissing
    fun _isNoteTweet(): JsonField<Boolean> = isNoteTweet

    /**
     * Returns the raw JSON value of [isQuoteStatus].
     *
     * Unlike [isQuoteStatus], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isQuoteStatus")
    @ExcludeMissing
    fun _isQuoteStatus(): JsonField<Boolean> = isQuoteStatus

    /**
     * Returns the raw JSON value of [isReply].
     *
     * Unlike [isReply], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isReply") @ExcludeMissing fun _isReply(): JsonField<Boolean> = isReply

    /**
     * Returns the raw JSON value of [media].
     *
     * Unlike [media], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("media") @ExcludeMissing fun _media(): JsonField<List<Media>> = media

    /**
     * Returns the raw JSON value of [quotedTweet].
     *
     * Unlike [quotedTweet], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("quoted_tweet")
    @ExcludeMissing
    fun _quotedTweet(): JsonField<QuotedTweet> = quotedTweet

    /**
     * Returns the raw JSON value of [source].
     *
     * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

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
         * Returns a mutable builder for constructing an instance of [TweetDetail].
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

    /** A builder for [TweetDetail]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var bookmarkCount: JsonField<Long>? = null
        private var likeCount: JsonField<Long>? = null
        private var quoteCount: JsonField<Long>? = null
        private var replyCount: JsonField<Long>? = null
        private var retweetCount: JsonField<Long>? = null
        private var text: JsonField<String>? = null
        private var viewCount: JsonField<Long>? = null
        private var conversationId: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<String> = JsonMissing.of()
        private var entities: JsonField<Entities> = JsonMissing.of()
        private var isNoteTweet: JsonField<Boolean> = JsonMissing.of()
        private var isQuoteStatus: JsonField<Boolean> = JsonMissing.of()
        private var isReply: JsonField<Boolean> = JsonMissing.of()
        private var media: JsonField<MutableList<Media>>? = null
        private var quotedTweet: JsonField<QuotedTweet> = JsonMissing.of()
        private var source: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tweetDetail: TweetDetail) = apply {
            id = tweetDetail.id
            bookmarkCount = tweetDetail.bookmarkCount
            likeCount = tweetDetail.likeCount
            quoteCount = tweetDetail.quoteCount
            replyCount = tweetDetail.replyCount
            retweetCount = tweetDetail.retweetCount
            text = tweetDetail.text
            viewCount = tweetDetail.viewCount
            conversationId = tweetDetail.conversationId
            createdAt = tweetDetail.createdAt
            entities = tweetDetail.entities
            isNoteTweet = tweetDetail.isNoteTweet
            isQuoteStatus = tweetDetail.isQuoteStatus
            isReply = tweetDetail.isReply
            media = tweetDetail.media.map { it.toMutableList() }
            quotedTweet = tweetDetail.quotedTweet
            source = tweetDetail.source
            additionalProperties = tweetDetail.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun bookmarkCount(bookmarkCount: Long) = bookmarkCount(JsonField.of(bookmarkCount))

        /**
         * Sets [Builder.bookmarkCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bookmarkCount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun bookmarkCount(bookmarkCount: JsonField<Long>) = apply {
            this.bookmarkCount = bookmarkCount
        }

        fun likeCount(likeCount: Long) = likeCount(JsonField.of(likeCount))

        /**
         * Sets [Builder.likeCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.likeCount] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun likeCount(likeCount: JsonField<Long>) = apply { this.likeCount = likeCount }

        fun quoteCount(quoteCount: Long) = quoteCount(JsonField.of(quoteCount))

        /**
         * Sets [Builder.quoteCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quoteCount] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun quoteCount(quoteCount: JsonField<Long>) = apply { this.quoteCount = quoteCount }

        fun replyCount(replyCount: Long) = replyCount(JsonField.of(replyCount))

        /**
         * Sets [Builder.replyCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.replyCount] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun replyCount(replyCount: JsonField<Long>) = apply { this.replyCount = replyCount }

        fun retweetCount(retweetCount: Long) = retweetCount(JsonField.of(retweetCount))

        /**
         * Sets [Builder.retweetCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.retweetCount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun retweetCount(retweetCount: JsonField<Long>) = apply { this.retweetCount = retweetCount }

        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        fun viewCount(viewCount: Long) = viewCount(JsonField.of(viewCount))

        /**
         * Sets [Builder.viewCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.viewCount] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun viewCount(viewCount: JsonField<Long>) = apply { this.viewCount = viewCount }

        /** ID of the root tweet in the conversation thread */
        fun conversationId(conversationId: String) = conversationId(JsonField.of(conversationId))

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

        fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

        /** Parsed entities from the tweet text (URLs, mentions, hashtags, media) */
        fun entities(entities: Entities) = entities(JsonField.of(entities))

        /**
         * Sets [Builder.entities] to an arbitrary JSON value.
         *
         * You should usually call [Builder.entities] with a well-typed [Entities] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun entities(entities: JsonField<Entities>) = apply { this.entities = entities }

        /** Whether this is a Note Tweet (long-form post, up to 25,000 characters) */
        fun isNoteTweet(isNoteTweet: Boolean) = isNoteTweet(JsonField.of(isNoteTweet))

        /**
         * Sets [Builder.isNoteTweet] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isNoteTweet] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isNoteTweet(isNoteTweet: JsonField<Boolean>) = apply { this.isNoteTweet = isNoteTweet }

        /** Whether this tweet quotes another tweet */
        fun isQuoteStatus(isQuoteStatus: Boolean) = isQuoteStatus(JsonField.of(isQuoteStatus))

        /**
         * Sets [Builder.isQuoteStatus] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isQuoteStatus] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun isQuoteStatus(isQuoteStatus: JsonField<Boolean>) = apply {
            this.isQuoteStatus = isQuoteStatus
        }

        /** Whether this tweet is a reply to another tweet */
        fun isReply(isReply: Boolean) = isReply(JsonField.of(isReply))

        /**
         * Sets [Builder.isReply] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isReply] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun isReply(isReply: JsonField<Boolean>) = apply { this.isReply = isReply }

        /** Attached media items, omitted when the tweet has no media */
        fun media(media: List<Media>) = media(JsonField.of(media))

        /**
         * Sets [Builder.media] to an arbitrary JSON value.
         *
         * You should usually call [Builder.media] with a well-typed `List<Media>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun media(media: JsonField<List<Media>>) = apply {
            this.media = media.map { it.toMutableList() }
        }

        /**
         * Adds a single [Media] to [Builder.media].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMedia(media: Media) = apply {
            this.media =
                (this.media ?: JsonField.of(mutableListOf())).also {
                    checkKnown("media", it).add(media)
                }
        }

        /** The quoted tweet object, present when isQuoteStatus is true */
        fun quotedTweet(quotedTweet: QuotedTweet) = quotedTweet(JsonField.of(quotedTweet))

        /**
         * Sets [Builder.quotedTweet] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quotedTweet] with a well-typed [QuotedTweet] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun quotedTweet(quotedTweet: JsonField<QuotedTweet>) = apply {
            this.quotedTweet = quotedTweet
        }

        /** Client application used to post this tweet */
        fun source(source: String) = source(JsonField.of(source))

        /**
         * Sets [Builder.source] to an arbitrary JSON value.
         *
         * You should usually call [Builder.source] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun source(source: JsonField<String>) = apply { this.source = source }

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
         * Returns an immutable instance of [TweetDetail].
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
        fun build(): TweetDetail =
            TweetDetail(
                checkRequired("id", id),
                checkRequired("bookmarkCount", bookmarkCount),
                checkRequired("likeCount", likeCount),
                checkRequired("quoteCount", quoteCount),
                checkRequired("replyCount", replyCount),
                checkRequired("retweetCount", retweetCount),
                checkRequired("text", text),
                checkRequired("viewCount", viewCount),
                conversationId,
                createdAt,
                entities,
                isNoteTweet,
                isQuoteStatus,
                isReply,
                (media ?: JsonMissing.of()).map { it.toImmutable() },
                quotedTweet,
                source,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TweetDetail = apply {
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
        conversationId()
        createdAt()
        entities().ifPresent { it.validate() }
        isNoteTweet()
        isQuoteStatus()
        isReply()
        media().ifPresent { it.forEach { it.validate() } }
        quotedTweet().ifPresent { it.validate() }
        source()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (bookmarkCount.asKnown().isPresent) 1 else 0) +
            (if (likeCount.asKnown().isPresent) 1 else 0) +
            (if (quoteCount.asKnown().isPresent) 1 else 0) +
            (if (replyCount.asKnown().isPresent) 1 else 0) +
            (if (retweetCount.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            (if (viewCount.asKnown().isPresent) 1 else 0) +
            (if (conversationId.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (entities.asKnown().getOrNull()?.validity() ?: 0) +
            (if (isNoteTweet.asKnown().isPresent) 1 else 0) +
            (if (isQuoteStatus.asKnown().isPresent) 1 else 0) +
            (if (isReply.asKnown().isPresent) 1 else 0) +
            (media.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (quotedTweet.asKnown().getOrNull()?.validity() ?: 0) +
            (if (source.asKnown().isPresent) 1 else 0)

    /** Parsed entities from the tweet text (URLs, mentions, hashtags, media) */
    class Entities
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Entities]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Entities]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(entities: Entities) = apply {
                additionalProperties = entities.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Entities].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Entities = Entities(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Entities = apply {
            if (validated) {
                return@apply
            }

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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Entities && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Entities{additionalProperties=$additionalProperties}"
    }

    class Media
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val mediaUrl: JsonField<String>,
        private val type: JsonField<Type>,
        private val url: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("mediaUrl")
            @ExcludeMissing
            mediaUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        ) : this(mediaUrl, type, url, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun mediaUrl(): Optional<String> = mediaUrl.getOptional("mediaUrl")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun type(): Optional<Type> = type.getOptional("type")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * Returns the raw JSON value of [mediaUrl].
         *
         * Unlike [mediaUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mediaUrl") @ExcludeMissing fun _mediaUrl(): JsonField<String> = mediaUrl

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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

            /** Returns a mutable builder for constructing an instance of [Media]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Media]. */
        class Builder internal constructor() {

            private var mediaUrl: JsonField<String> = JsonMissing.of()
            private var type: JsonField<Type> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(media: Media) = apply {
                mediaUrl = media.mediaUrl
                type = media.type
                url = media.url
                additionalProperties = media.additionalProperties.toMutableMap()
            }

            fun mediaUrl(mediaUrl: String) = mediaUrl(JsonField.of(mediaUrl))

            /**
             * Sets [Builder.mediaUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mediaUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mediaUrl(mediaUrl: JsonField<String>) = apply { this.mediaUrl = mediaUrl }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

            fun url(url: String) = url(JsonField.of(url))

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun url(url: JsonField<String>) = apply { this.url = url }

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
             * Returns an immutable instance of [Media].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Media = Media(mediaUrl, type, url, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Media = apply {
            if (validated) {
                return@apply
            }

            mediaUrl()
            type().ifPresent { it.validate() }
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

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (mediaUrl.asKnown().isPresent) 1 else 0) +
                (type.asKnown().getOrNull()?.validity() ?: 0) +
                (if (url.asKnown().isPresent) 1 else 0)

        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val PHOTO = of("photo")

                @JvmField val VIDEO = of("video")

                @JvmField val ANIMATED_GIF = of("animated_gif")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                PHOTO,
                VIDEO,
                ANIMATED_GIF,
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                PHOTO,
                VIDEO,
                ANIMATED_GIF,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    PHOTO -> Value.PHOTO
                    VIDEO -> Value.VIDEO
                    ANIMATED_GIF -> Value.ANIMATED_GIF
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    PHOTO -> Known.PHOTO
                    VIDEO -> Known.VIDEO
                    ANIMATED_GIF -> Known.ANIMATED_GIF
                    else -> throw XTwitterScraperInvalidDataException("Unknown Type: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value does not
             *   have the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    XTwitterScraperInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): Type = apply {
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

                return other is Type && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Media &&
                mediaUrl == other.mediaUrl &&
                type == other.type &&
                url == other.url &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(mediaUrl, type, url, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Media{mediaUrl=$mediaUrl, type=$type, url=$url, additionalProperties=$additionalProperties}"
    }

    /** The quoted tweet object, present when isQuoteStatus is true */
    class QuotedTweet
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [QuotedTweet]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [QuotedTweet]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(quotedTweet: QuotedTweet) = apply {
                additionalProperties = quotedTweet.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [QuotedTweet].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): QuotedTweet = QuotedTweet(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): QuotedTweet = apply {
            if (validated) {
                return@apply
            }

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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is QuotedTweet && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "QuotedTweet{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetDetail &&
            id == other.id &&
            bookmarkCount == other.bookmarkCount &&
            likeCount == other.likeCount &&
            quoteCount == other.quoteCount &&
            replyCount == other.replyCount &&
            retweetCount == other.retweetCount &&
            text == other.text &&
            viewCount == other.viewCount &&
            conversationId == other.conversationId &&
            createdAt == other.createdAt &&
            entities == other.entities &&
            isNoteTweet == other.isNoteTweet &&
            isQuoteStatus == other.isQuoteStatus &&
            isReply == other.isReply &&
            media == other.media &&
            quotedTweet == other.quotedTweet &&
            source == other.source &&
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
            conversationId,
            createdAt,
            entities,
            isNoteTweet,
            isQuoteStatus,
            isReply,
            media,
            quotedTweet,
            source,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TweetDetail{id=$id, bookmarkCount=$bookmarkCount, likeCount=$likeCount, quoteCount=$quoteCount, replyCount=$replyCount, retweetCount=$retweetCount, text=$text, viewCount=$viewCount, conversationId=$conversationId, createdAt=$createdAt, entities=$entities, isNoteTweet=$isNoteTweet, isQuoteStatus=$isQuoteStatus, isReply=$isReply, media=$media, quotedTweet=$quotedTweet, source=$source, additionalProperties=$additionalProperties}"
}
