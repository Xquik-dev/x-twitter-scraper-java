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

/**
 * Tweet returned from search results with inline author info. A zero metric can mean X did not
 * report the count.
 */
class SearchTweet
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
    private val article: JsonField<Article>,
    private val author: JsonField<UserProfile>,
    private val card: JsonField<Card>,
    private val communityNote: JsonField<CommunityNote>,
    private val contentDisclosure: JsonField<ContentDisclosure>,
    private val conversationId: JsonField<String>,
    private val createdAt: JsonField<String>,
    private val displayTextRange: JsonField<List<Long>>,
    private val edit: JsonField<Edit>,
    private val entities: JsonField<Entities>,
    private val inReplyToId: JsonField<String>,
    private val inReplyToUserId: JsonField<String>,
    private val inReplyToUsername: JsonField<String>,
    private val isLimitedReply: JsonField<Boolean>,
    private val isNoteTweet: JsonField<Boolean>,
    private val isQuoteStatus: JsonField<Boolean>,
    private val isReply: JsonField<Boolean>,
    private val isTranslatable: JsonField<Boolean>,
    private val lang: JsonField<String>,
    private val media: JsonField<List<TweetMedia>>,
    private val noteTweet: JsonField<NoteTweet>,
    private val place: JsonField<Place>,
    private val possiblySensitive: JsonField<Boolean>,
    private val previousCounts: JsonField<PreviousCounts>,
    private val quotedTweet: JsonField<EmbeddedTweet>,
    private val retweetedTweet: JsonField<EmbeddedTweet>,
    private val source: JsonField<String>,
    private val type: JsonField<String>,
    private val url: JsonField<String>,
    private val viewState: JsonField<String>,
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
        @JsonProperty("article") @ExcludeMissing article: JsonField<Article> = JsonMissing.of(),
        @JsonProperty("author") @ExcludeMissing author: JsonField<UserProfile> = JsonMissing.of(),
        @JsonProperty("card") @ExcludeMissing card: JsonField<Card> = JsonMissing.of(),
        @JsonProperty("communityNote")
        @ExcludeMissing
        communityNote: JsonField<CommunityNote> = JsonMissing.of(),
        @JsonProperty("contentDisclosure")
        @ExcludeMissing
        contentDisclosure: JsonField<ContentDisclosure> = JsonMissing.of(),
        @JsonProperty("conversationId")
        @ExcludeMissing
        conversationId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("displayTextRange")
        @ExcludeMissing
        displayTextRange: JsonField<List<Long>> = JsonMissing.of(),
        @JsonProperty("edit") @ExcludeMissing edit: JsonField<Edit> = JsonMissing.of(),
        @JsonProperty("entities") @ExcludeMissing entities: JsonField<Entities> = JsonMissing.of(),
        @JsonProperty("inReplyToId")
        @ExcludeMissing
        inReplyToId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("inReplyToUserId")
        @ExcludeMissing
        inReplyToUserId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("inReplyToUsername")
        @ExcludeMissing
        inReplyToUsername: JsonField<String> = JsonMissing.of(),
        @JsonProperty("isLimitedReply")
        @ExcludeMissing
        isLimitedReply: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isNoteTweet")
        @ExcludeMissing
        isNoteTweet: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isQuoteStatus")
        @ExcludeMissing
        isQuoteStatus: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isReply") @ExcludeMissing isReply: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isTranslatable")
        @ExcludeMissing
        isTranslatable: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("lang") @ExcludeMissing lang: JsonField<String> = JsonMissing.of(),
        @JsonProperty("media")
        @ExcludeMissing
        media: JsonField<List<TweetMedia>> = JsonMissing.of(),
        @JsonProperty("noteTweet")
        @ExcludeMissing
        noteTweet: JsonField<NoteTweet> = JsonMissing.of(),
        @JsonProperty("place") @ExcludeMissing place: JsonField<Place> = JsonMissing.of(),
        @JsonProperty("possiblySensitive")
        @ExcludeMissing
        possiblySensitive: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("previousCounts")
        @ExcludeMissing
        previousCounts: JsonField<PreviousCounts> = JsonMissing.of(),
        @JsonProperty("quoted_tweet")
        @ExcludeMissing
        quotedTweet: JsonField<EmbeddedTweet> = JsonMissing.of(),
        @JsonProperty("retweeted_tweet")
        @ExcludeMissing
        retweetedTweet: JsonField<EmbeddedTweet> = JsonMissing.of(),
        @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        @JsonProperty("viewState") @ExcludeMissing viewState: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        bookmarkCount,
        likeCount,
        quoteCount,
        replyCount,
        retweetCount,
        text,
        viewCount,
        article,
        author,
        card,
        communityNote,
        contentDisclosure,
        conversationId,
        createdAt,
        displayTextRange,
        edit,
        entities,
        inReplyToId,
        inReplyToUserId,
        inReplyToUsername,
        isLimitedReply,
        isNoteTweet,
        isQuoteStatus,
        isReply,
        isTranslatable,
        lang,
        media,
        noteTweet,
        place,
        possiblySensitive,
        previousCounts,
        quotedTweet,
        retweetedTweet,
        source,
        type,
        url,
        viewState,
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
     * Article metadata attached to a tweet.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun article(): Optional<Article> = article.getOptional("article")

    /**
     * X user profile with bio, follower counts, and verification status.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun author(): Optional<UserProfile> = author.getOptional("author")

    /**
     * Public card metadata attached to a tweet.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun card(): Optional<Card> = card.getOptional("card")

    /**
     * Community Note presentation metadata returned by X.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun communityNote(): Optional<CommunityNote> = communityNote.getOptional("communityNote")

    /**
     * Content disclosure metadata shown by X when a tweet is labeled as paid partnership content or
     * AI-generated media.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun contentDisclosure(): Optional<ContentDisclosure> =
        contentDisclosure.getOptional("contentDisclosure")

    /**
     * Root tweet ID for the search result conversation
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
     * Rendered text's start and end offsets.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun displayTextRange(): Optional<List<Long>> = displayTextRange.getOptional("displayTextRange")

    /**
     * Edit history metadata returned by X.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun edit(): Optional<Edit> = edit.getOptional("edit")

    /**
     * Parsed search-result entities including URLs, mentions, hashtags, and media markers
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun entities(): Optional<Entities> = entities.getOptional("entities")

    /**
     * ID of the tweet this result replies to.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun inReplyToId(): Optional<String> = inReplyToId.getOptional("inReplyToId")

    /**
     * ID of the user this result replies to.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun inReplyToUserId(): Optional<String> = inReplyToUserId.getOptional("inReplyToUserId")

    /**
     * Username this result replies to.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun inReplyToUsername(): Optional<String> = inReplyToUsername.getOptional("inReplyToUsername")

    /**
     * Whether the tweet has limited reply permissions
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun isLimitedReply(): Optional<Boolean> = isLimitedReply.getOptional("isLimitedReply")

    /**
     * True for Note Tweets (long-form content, up to 25,000 characters)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun isNoteTweet(): Optional<Boolean> = isNoteTweet.getOptional("isNoteTweet")

    /**
     * True when this search result quotes another tweet
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun isQuoteStatus(): Optional<Boolean> = isQuoteStatus.getOptional("isQuoteStatus")

    /**
     * True when this search result is a reply
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun isReply(): Optional<Boolean> = isReply.getOptional("isReply")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun isTranslatable(): Optional<Boolean> = isTranslatable.getOptional("isTranslatable")

    /**
     * Search result language code.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun lang(): Optional<String> = lang.getOptional("lang")

    /**
     * Search-result media attachments, omitted when no media is present
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun media(): Optional<List<TweetMedia>> = media.getOptional("media")

    /**
     * Complete Note Tweet content and rich-text metadata.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun noteTweet(): Optional<NoteTweet> = noteTweet.getOptional("noteTweet")

    /**
     * Public place metadata attached to a tweet.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun place(): Optional<Place> = place.getOptional("place")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun possiblySensitive(): Optional<Boolean> = possiblySensitive.getOptional("possiblySensitive")

    /**
     * Engagement counts retained from a prior tweet edit.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun previousCounts(): Optional<PreviousCounts> = previousCounts.getOptional("previousCounts")

    /**
     * Quoted or retweeted tweet context. Every object includes id, text, and engagement metrics. A
     * zero metric can mean X did not report the count. Author, media, and conversation fields
     * appear when available.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun quotedTweet(): Optional<EmbeddedTweet> = quotedTweet.getOptional("quoted_tweet")

    /**
     * Quoted or retweeted tweet context. Every object includes id, text, and engagement metrics. A
     * zero metric can mean X did not report the count. Author, media, and conversation fields
     * appear when available.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun retweetedTweet(): Optional<EmbeddedTweet> = retweetedTweet.getOptional("retweeted_tweet")

    /**
     * Client application used to post the tweet
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun source(): Optional<String> = source.getOptional("source")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun type(): Optional<String> = type.getOptional("type")

    /**
     * Search result permalink.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun url(): Optional<String> = url.getOptional("url")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun viewState(): Optional<String> = viewState.getOptional("viewState")

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
     * Returns the raw JSON value of [article].
     *
     * Unlike [article], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("article") @ExcludeMissing fun _article(): JsonField<Article> = article

    /**
     * Returns the raw JSON value of [author].
     *
     * Unlike [author], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("author") @ExcludeMissing fun _author(): JsonField<UserProfile> = author

    /**
     * Returns the raw JSON value of [card].
     *
     * Unlike [card], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("card") @ExcludeMissing fun _card(): JsonField<Card> = card

    /**
     * Returns the raw JSON value of [communityNote].
     *
     * Unlike [communityNote], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("communityNote")
    @ExcludeMissing
    fun _communityNote(): JsonField<CommunityNote> = communityNote

    /**
     * Returns the raw JSON value of [contentDisclosure].
     *
     * Unlike [contentDisclosure], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("contentDisclosure")
    @ExcludeMissing
    fun _contentDisclosure(): JsonField<ContentDisclosure> = contentDisclosure

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
     * Returns the raw JSON value of [displayTextRange].
     *
     * Unlike [displayTextRange], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("displayTextRange")
    @ExcludeMissing
    fun _displayTextRange(): JsonField<List<Long>> = displayTextRange

    /**
     * Returns the raw JSON value of [edit].
     *
     * Unlike [edit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("edit") @ExcludeMissing fun _edit(): JsonField<Edit> = edit

    /**
     * Returns the raw JSON value of [entities].
     *
     * Unlike [entities], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("entities") @ExcludeMissing fun _entities(): JsonField<Entities> = entities

    /**
     * Returns the raw JSON value of [inReplyToId].
     *
     * Unlike [inReplyToId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inReplyToId") @ExcludeMissing fun _inReplyToId(): JsonField<String> = inReplyToId

    /**
     * Returns the raw JSON value of [inReplyToUserId].
     *
     * Unlike [inReplyToUserId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inReplyToUserId")
    @ExcludeMissing
    fun _inReplyToUserId(): JsonField<String> = inReplyToUserId

    /**
     * Returns the raw JSON value of [inReplyToUsername].
     *
     * Unlike [inReplyToUsername], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("inReplyToUsername")
    @ExcludeMissing
    fun _inReplyToUsername(): JsonField<String> = inReplyToUsername

    /**
     * Returns the raw JSON value of [isLimitedReply].
     *
     * Unlike [isLimitedReply], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isLimitedReply")
    @ExcludeMissing
    fun _isLimitedReply(): JsonField<Boolean> = isLimitedReply

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
     * Returns the raw JSON value of [isTranslatable].
     *
     * Unlike [isTranslatable], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isTranslatable")
    @ExcludeMissing
    fun _isTranslatable(): JsonField<Boolean> = isTranslatable

    /**
     * Returns the raw JSON value of [lang].
     *
     * Unlike [lang], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("lang") @ExcludeMissing fun _lang(): JsonField<String> = lang

    /**
     * Returns the raw JSON value of [media].
     *
     * Unlike [media], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("media") @ExcludeMissing fun _media(): JsonField<List<TweetMedia>> = media

    /**
     * Returns the raw JSON value of [noteTweet].
     *
     * Unlike [noteTweet], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("noteTweet") @ExcludeMissing fun _noteTweet(): JsonField<NoteTweet> = noteTweet

    /**
     * Returns the raw JSON value of [place].
     *
     * Unlike [place], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("place") @ExcludeMissing fun _place(): JsonField<Place> = place

    /**
     * Returns the raw JSON value of [possiblySensitive].
     *
     * Unlike [possiblySensitive], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("possiblySensitive")
    @ExcludeMissing
    fun _possiblySensitive(): JsonField<Boolean> = possiblySensitive

    /**
     * Returns the raw JSON value of [previousCounts].
     *
     * Unlike [previousCounts], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("previousCounts")
    @ExcludeMissing
    fun _previousCounts(): JsonField<PreviousCounts> = previousCounts

    /**
     * Returns the raw JSON value of [quotedTweet].
     *
     * Unlike [quotedTweet], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("quoted_tweet")
    @ExcludeMissing
    fun _quotedTweet(): JsonField<EmbeddedTweet> = quotedTweet

    /**
     * Returns the raw JSON value of [retweetedTweet].
     *
     * Unlike [retweetedTweet], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("retweeted_tweet")
    @ExcludeMissing
    fun _retweetedTweet(): JsonField<EmbeddedTweet> = retweetedTweet

    /**
     * Returns the raw JSON value of [source].
     *
     * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

    /**
     * Returns the raw JSON value of [url].
     *
     * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

    /**
     * Returns the raw JSON value of [viewState].
     *
     * Unlike [viewState], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("viewState") @ExcludeMissing fun _viewState(): JsonField<String> = viewState

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
         * Returns a mutable builder for constructing an instance of [SearchTweet].
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

    /** A builder for [SearchTweet]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var bookmarkCount: JsonField<Long>? = null
        private var likeCount: JsonField<Long>? = null
        private var quoteCount: JsonField<Long>? = null
        private var replyCount: JsonField<Long>? = null
        private var retweetCount: JsonField<Long>? = null
        private var text: JsonField<String>? = null
        private var viewCount: JsonField<Long>? = null
        private var article: JsonField<Article> = JsonMissing.of()
        private var author: JsonField<UserProfile> = JsonMissing.of()
        private var card: JsonField<Card> = JsonMissing.of()
        private var communityNote: JsonField<CommunityNote> = JsonMissing.of()
        private var contentDisclosure: JsonField<ContentDisclosure> = JsonMissing.of()
        private var conversationId: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<String> = JsonMissing.of()
        private var displayTextRange: JsonField<MutableList<Long>>? = null
        private var edit: JsonField<Edit> = JsonMissing.of()
        private var entities: JsonField<Entities> = JsonMissing.of()
        private var inReplyToId: JsonField<String> = JsonMissing.of()
        private var inReplyToUserId: JsonField<String> = JsonMissing.of()
        private var inReplyToUsername: JsonField<String> = JsonMissing.of()
        private var isLimitedReply: JsonField<Boolean> = JsonMissing.of()
        private var isNoteTweet: JsonField<Boolean> = JsonMissing.of()
        private var isQuoteStatus: JsonField<Boolean> = JsonMissing.of()
        private var isReply: JsonField<Boolean> = JsonMissing.of()
        private var isTranslatable: JsonField<Boolean> = JsonMissing.of()
        private var lang: JsonField<String> = JsonMissing.of()
        private var media: JsonField<MutableList<TweetMedia>>? = null
        private var noteTweet: JsonField<NoteTweet> = JsonMissing.of()
        private var place: JsonField<Place> = JsonMissing.of()
        private var possiblySensitive: JsonField<Boolean> = JsonMissing.of()
        private var previousCounts: JsonField<PreviousCounts> = JsonMissing.of()
        private var quotedTweet: JsonField<EmbeddedTweet> = JsonMissing.of()
        private var retweetedTweet: JsonField<EmbeddedTweet> = JsonMissing.of()
        private var source: JsonField<String> = JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var viewState: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(searchTweet: SearchTweet) = apply {
            id = searchTweet.id
            bookmarkCount = searchTweet.bookmarkCount
            likeCount = searchTweet.likeCount
            quoteCount = searchTweet.quoteCount
            replyCount = searchTweet.replyCount
            retweetCount = searchTweet.retweetCount
            text = searchTweet.text
            viewCount = searchTweet.viewCount
            article = searchTweet.article
            author = searchTweet.author
            card = searchTweet.card
            communityNote = searchTweet.communityNote
            contentDisclosure = searchTweet.contentDisclosure
            conversationId = searchTweet.conversationId
            createdAt = searchTweet.createdAt
            displayTextRange = searchTweet.displayTextRange.map { it.toMutableList() }
            edit = searchTweet.edit
            entities = searchTweet.entities
            inReplyToId = searchTweet.inReplyToId
            inReplyToUserId = searchTweet.inReplyToUserId
            inReplyToUsername = searchTweet.inReplyToUsername
            isLimitedReply = searchTweet.isLimitedReply
            isNoteTweet = searchTweet.isNoteTweet
            isQuoteStatus = searchTweet.isQuoteStatus
            isReply = searchTweet.isReply
            isTranslatable = searchTweet.isTranslatable
            lang = searchTweet.lang
            media = searchTweet.media.map { it.toMutableList() }
            noteTweet = searchTweet.noteTweet
            place = searchTweet.place
            possiblySensitive = searchTweet.possiblySensitive
            previousCounts = searchTweet.previousCounts
            quotedTweet = searchTweet.quotedTweet
            retweetedTweet = searchTweet.retweetedTweet
            source = searchTweet.source
            type = searchTweet.type
            url = searchTweet.url
            viewState = searchTweet.viewState
            additionalProperties = searchTweet.additionalProperties.toMutableMap()
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

        /** Article metadata attached to a tweet. */
        fun article(article: Article) = article(JsonField.of(article))

        /**
         * Sets [Builder.article] to an arbitrary JSON value.
         *
         * You should usually call [Builder.article] with a well-typed [Article] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun article(article: JsonField<Article>) = apply { this.article = article }

        /** X user profile with bio, follower counts, and verification status. */
        fun author(author: UserProfile) = author(JsonField.of(author))

        /**
         * Sets [Builder.author] to an arbitrary JSON value.
         *
         * You should usually call [Builder.author] with a well-typed [UserProfile] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun author(author: JsonField<UserProfile>) = apply { this.author = author }

        /** Public card metadata attached to a tweet. */
        fun card(card: Card) = card(JsonField.of(card))

        /**
         * Sets [Builder.card] to an arbitrary JSON value.
         *
         * You should usually call [Builder.card] with a well-typed [Card] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun card(card: JsonField<Card>) = apply { this.card = card }

        /** Community Note presentation metadata returned by X. */
        fun communityNote(communityNote: CommunityNote) = communityNote(JsonField.of(communityNote))

        /**
         * Sets [Builder.communityNote] to an arbitrary JSON value.
         *
         * You should usually call [Builder.communityNote] with a well-typed [CommunityNote] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun communityNote(communityNote: JsonField<CommunityNote>) = apply {
            this.communityNote = communityNote
        }

        /**
         * Content disclosure metadata shown by X when a tweet is labeled as paid partnership
         * content or AI-generated media.
         */
        fun contentDisclosure(contentDisclosure: ContentDisclosure) =
            contentDisclosure(JsonField.of(contentDisclosure))

        /**
         * Sets [Builder.contentDisclosure] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contentDisclosure] with a well-typed [ContentDisclosure]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun contentDisclosure(contentDisclosure: JsonField<ContentDisclosure>) = apply {
            this.contentDisclosure = contentDisclosure
        }

        /** Root tweet ID for the search result conversation */
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

        /** Rendered text's start and end offsets. */
        fun displayTextRange(displayTextRange: List<Long>) =
            displayTextRange(JsonField.of(displayTextRange))

        /**
         * Sets [Builder.displayTextRange] to an arbitrary JSON value.
         *
         * You should usually call [Builder.displayTextRange] with a well-typed `List<Long>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun displayTextRange(displayTextRange: JsonField<List<Long>>) = apply {
            this.displayTextRange = displayTextRange.map { it.toMutableList() }
        }

        /**
         * Adds a single [Long] to [Builder.displayTextRange].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDisplayTextRange(displayTextRange: Long) = apply {
            this.displayTextRange =
                (this.displayTextRange ?: JsonField.of(mutableListOf())).also {
                    checkKnown("displayTextRange", it).add(displayTextRange)
                }
        }

        /** Edit history metadata returned by X. */
        fun edit(edit: Edit) = edit(JsonField.of(edit))

        /**
         * Sets [Builder.edit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.edit] with a well-typed [Edit] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun edit(edit: JsonField<Edit>) = apply { this.edit = edit }

        /** Parsed search-result entities including URLs, mentions, hashtags, and media markers */
        fun entities(entities: Entities) = entities(JsonField.of(entities))

        /**
         * Sets [Builder.entities] to an arbitrary JSON value.
         *
         * You should usually call [Builder.entities] with a well-typed [Entities] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun entities(entities: JsonField<Entities>) = apply { this.entities = entities }

        /** ID of the tweet this result replies to. */
        fun inReplyToId(inReplyToId: String) = inReplyToId(JsonField.of(inReplyToId))

        /**
         * Sets [Builder.inReplyToId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inReplyToId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun inReplyToId(inReplyToId: JsonField<String>) = apply { this.inReplyToId = inReplyToId }

        /** ID of the user this result replies to. */
        fun inReplyToUserId(inReplyToUserId: String) =
            inReplyToUserId(JsonField.of(inReplyToUserId))

        /**
         * Sets [Builder.inReplyToUserId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inReplyToUserId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inReplyToUserId(inReplyToUserId: JsonField<String>) = apply {
            this.inReplyToUserId = inReplyToUserId
        }

        /** Username this result replies to. */
        fun inReplyToUsername(inReplyToUsername: String) =
            inReplyToUsername(JsonField.of(inReplyToUsername))

        /**
         * Sets [Builder.inReplyToUsername] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inReplyToUsername] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inReplyToUsername(inReplyToUsername: JsonField<String>) = apply {
            this.inReplyToUsername = inReplyToUsername
        }

        /** Whether the tweet has limited reply permissions */
        fun isLimitedReply(isLimitedReply: Boolean) = isLimitedReply(JsonField.of(isLimitedReply))

        /**
         * Sets [Builder.isLimitedReply] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isLimitedReply] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun isLimitedReply(isLimitedReply: JsonField<Boolean>) = apply {
            this.isLimitedReply = isLimitedReply
        }

        /** True for Note Tweets (long-form content, up to 25,000 characters) */
        fun isNoteTweet(isNoteTweet: Boolean) = isNoteTweet(JsonField.of(isNoteTweet))

        /**
         * Sets [Builder.isNoteTweet] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isNoteTweet] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isNoteTweet(isNoteTweet: JsonField<Boolean>) = apply { this.isNoteTweet = isNoteTweet }

        /** True when this search result quotes another tweet */
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

        /** True when this search result is a reply */
        fun isReply(isReply: Boolean) = isReply(JsonField.of(isReply))

        /**
         * Sets [Builder.isReply] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isReply] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun isReply(isReply: JsonField<Boolean>) = apply { this.isReply = isReply }

        fun isTranslatable(isTranslatable: Boolean) = isTranslatable(JsonField.of(isTranslatable))

        /**
         * Sets [Builder.isTranslatable] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isTranslatable] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun isTranslatable(isTranslatable: JsonField<Boolean>) = apply {
            this.isTranslatable = isTranslatable
        }

        /** Search result language code. */
        fun lang(lang: String) = lang(JsonField.of(lang))

        /**
         * Sets [Builder.lang] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lang] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun lang(lang: JsonField<String>) = apply { this.lang = lang }

        /** Search-result media attachments, omitted when no media is present */
        fun media(media: List<TweetMedia>) = media(JsonField.of(media))

        /**
         * Sets [Builder.media] to an arbitrary JSON value.
         *
         * You should usually call [Builder.media] with a well-typed `List<TweetMedia>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun media(media: JsonField<List<TweetMedia>>) = apply {
            this.media = media.map { it.toMutableList() }
        }

        /**
         * Adds a single [TweetMedia] to [Builder.media].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMedia(media: TweetMedia) = apply {
            this.media =
                (this.media ?: JsonField.of(mutableListOf())).also {
                    checkKnown("media", it).add(media)
                }
        }

        /** Complete Note Tweet content and rich-text metadata. */
        fun noteTweet(noteTweet: NoteTweet) = noteTweet(JsonField.of(noteTweet))

        /**
         * Sets [Builder.noteTweet] to an arbitrary JSON value.
         *
         * You should usually call [Builder.noteTweet] with a well-typed [NoteTweet] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun noteTweet(noteTweet: JsonField<NoteTweet>) = apply { this.noteTweet = noteTweet }

        /** Public place metadata attached to a tweet. */
        fun place(place: Place) = place(JsonField.of(place))

        /**
         * Sets [Builder.place] to an arbitrary JSON value.
         *
         * You should usually call [Builder.place] with a well-typed [Place] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun place(place: JsonField<Place>) = apply { this.place = place }

        fun possiblySensitive(possiblySensitive: Boolean) =
            possiblySensitive(JsonField.of(possiblySensitive))

        /**
         * Sets [Builder.possiblySensitive] to an arbitrary JSON value.
         *
         * You should usually call [Builder.possiblySensitive] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun possiblySensitive(possiblySensitive: JsonField<Boolean>) = apply {
            this.possiblySensitive = possiblySensitive
        }

        /** Engagement counts retained from a prior tweet edit. */
        fun previousCounts(previousCounts: PreviousCounts) =
            previousCounts(JsonField.of(previousCounts))

        /**
         * Sets [Builder.previousCounts] to an arbitrary JSON value.
         *
         * You should usually call [Builder.previousCounts] with a well-typed [PreviousCounts] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun previousCounts(previousCounts: JsonField<PreviousCounts>) = apply {
            this.previousCounts = previousCounts
        }

        /**
         * Quoted or retweeted tweet context. Every object includes id, text, and engagement
         * metrics. A zero metric can mean X did not report the count. Author, media, and
         * conversation fields appear when available.
         */
        fun quotedTweet(quotedTweet: EmbeddedTweet) = quotedTweet(JsonField.of(quotedTweet))

        /**
         * Sets [Builder.quotedTweet] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quotedTweet] with a well-typed [EmbeddedTweet] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun quotedTweet(quotedTweet: JsonField<EmbeddedTweet>) = apply {
            this.quotedTweet = quotedTweet
        }

        /**
         * Quoted or retweeted tweet context. Every object includes id, text, and engagement
         * metrics. A zero metric can mean X did not report the count. Author, media, and
         * conversation fields appear when available.
         */
        fun retweetedTweet(retweetedTweet: EmbeddedTweet) =
            retweetedTweet(JsonField.of(retweetedTweet))

        /**
         * Sets [Builder.retweetedTweet] to an arbitrary JSON value.
         *
         * You should usually call [Builder.retweetedTweet] with a well-typed [EmbeddedTweet] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun retweetedTweet(retweetedTweet: JsonField<EmbeddedTweet>) = apply {
            this.retweetedTweet = retweetedTweet
        }

        /** Client application used to post the tweet */
        fun source(source: String) = source(JsonField.of(source))

        /**
         * Sets [Builder.source] to an arbitrary JSON value.
         *
         * You should usually call [Builder.source] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun source(source: JsonField<String>) = apply { this.source = source }

        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

        /** Search result permalink. */
        fun url(url: String) = url(JsonField.of(url))

        /**
         * Sets [Builder.url] to an arbitrary JSON value.
         *
         * You should usually call [Builder.url] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun url(url: JsonField<String>) = apply { this.url = url }

        fun viewState(viewState: String) = viewState(JsonField.of(viewState))

        /**
         * Sets [Builder.viewState] to an arbitrary JSON value.
         *
         * You should usually call [Builder.viewState] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun viewState(viewState: JsonField<String>) = apply { this.viewState = viewState }

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
         * Returns an immutable instance of [SearchTweet].
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
        fun build(): SearchTweet =
            SearchTweet(
                checkRequired("id", id),
                checkRequired("bookmarkCount", bookmarkCount),
                checkRequired("likeCount", likeCount),
                checkRequired("quoteCount", quoteCount),
                checkRequired("replyCount", replyCount),
                checkRequired("retweetCount", retweetCount),
                checkRequired("text", text),
                checkRequired("viewCount", viewCount),
                article,
                author,
                card,
                communityNote,
                contentDisclosure,
                conversationId,
                createdAt,
                (displayTextRange ?: JsonMissing.of()).map { it.toImmutable() },
                edit,
                entities,
                inReplyToId,
                inReplyToUserId,
                inReplyToUsername,
                isLimitedReply,
                isNoteTweet,
                isQuoteStatus,
                isReply,
                isTranslatable,
                lang,
                (media ?: JsonMissing.of()).map { it.toImmutable() },
                noteTweet,
                place,
                possiblySensitive,
                previousCounts,
                quotedTweet,
                retweetedTweet,
                source,
                type,
                url,
                viewState,
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
    fun validate(): SearchTweet = apply {
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
        article().ifPresent { it.validate() }
        author().ifPresent { it.validate() }
        card().ifPresent { it.validate() }
        communityNote().ifPresent { it.validate() }
        contentDisclosure().ifPresent { it.validate() }
        conversationId()
        createdAt()
        displayTextRange()
        edit().ifPresent { it.validate() }
        entities().ifPresent { it.validate() }
        inReplyToId()
        inReplyToUserId()
        inReplyToUsername()
        isLimitedReply()
        isNoteTweet()
        isQuoteStatus()
        isReply()
        isTranslatable()
        lang()
        media().ifPresent { it.forEach { it.validate() } }
        noteTweet().ifPresent { it.validate() }
        place().ifPresent { it.validate() }
        possiblySensitive()
        previousCounts().ifPresent { it.validate() }
        quotedTweet().ifPresent { it.validate() }
        retweetedTweet().ifPresent { it.validate() }
        source()
        type()
        url()
        viewState()
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
            (article.asKnown().getOrNull()?.validity() ?: 0) +
            (author.asKnown().getOrNull()?.validity() ?: 0) +
            (card.asKnown().getOrNull()?.validity() ?: 0) +
            (communityNote.asKnown().getOrNull()?.validity() ?: 0) +
            (contentDisclosure.asKnown().getOrNull()?.validity() ?: 0) +
            (if (conversationId.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (displayTextRange.asKnown().getOrNull()?.size ?: 0) +
            (edit.asKnown().getOrNull()?.validity() ?: 0) +
            (entities.asKnown().getOrNull()?.validity() ?: 0) +
            (if (inReplyToId.asKnown().isPresent) 1 else 0) +
            (if (inReplyToUserId.asKnown().isPresent) 1 else 0) +
            (if (inReplyToUsername.asKnown().isPresent) 1 else 0) +
            (if (isLimitedReply.asKnown().isPresent) 1 else 0) +
            (if (isNoteTweet.asKnown().isPresent) 1 else 0) +
            (if (isQuoteStatus.asKnown().isPresent) 1 else 0) +
            (if (isReply.asKnown().isPresent) 1 else 0) +
            (if (isTranslatable.asKnown().isPresent) 1 else 0) +
            (if (lang.asKnown().isPresent) 1 else 0) +
            (media.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (noteTweet.asKnown().getOrNull()?.validity() ?: 0) +
            (place.asKnown().getOrNull()?.validity() ?: 0) +
            (if (possiblySensitive.asKnown().isPresent) 1 else 0) +
            (previousCounts.asKnown().getOrNull()?.validity() ?: 0) +
            (quotedTweet.asKnown().getOrNull()?.validity() ?: 0) +
            (retweetedTweet.asKnown().getOrNull()?.validity() ?: 0) +
            (if (source.asKnown().isPresent) 1 else 0) +
            (if (type.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0) +
            (if (viewState.asKnown().isPresent) 1 else 0)

    /** Article metadata attached to a tweet. */
    class Article
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val coverMediaUrl: JsonField<String>,
        private val previewText: JsonField<String>,
        private val title: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("coverMediaUrl")
            @ExcludeMissing
            coverMediaUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("previewText")
            @ExcludeMissing
            previewText: JsonField<String> = JsonMissing.of(),
            @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
        ) : this(id, coverMediaUrl, previewText, title, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun coverMediaUrl(): Optional<String> = coverMediaUrl.getOptional("coverMediaUrl")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun previewText(): Optional<String> = previewText.getOptional("previewText")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun title(): Optional<String> = title.getOptional("title")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [coverMediaUrl].
         *
         * Unlike [coverMediaUrl], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("coverMediaUrl")
        @ExcludeMissing
        fun _coverMediaUrl(): JsonField<String> = coverMediaUrl

        /**
         * Returns the raw JSON value of [previewText].
         *
         * Unlike [previewText], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("previewText")
        @ExcludeMissing
        fun _previewText(): JsonField<String> = previewText

        /**
         * Returns the raw JSON value of [title].
         *
         * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

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

            /** Returns a mutable builder for constructing an instance of [Article]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Article]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var coverMediaUrl: JsonField<String> = JsonMissing.of()
            private var previewText: JsonField<String> = JsonMissing.of()
            private var title: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(article: Article) = apply {
                id = article.id
                coverMediaUrl = article.coverMediaUrl
                previewText = article.previewText
                title = article.title
                additionalProperties = article.additionalProperties.toMutableMap()
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

            fun coverMediaUrl(coverMediaUrl: String) = coverMediaUrl(JsonField.of(coverMediaUrl))

            /**
             * Sets [Builder.coverMediaUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.coverMediaUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun coverMediaUrl(coverMediaUrl: JsonField<String>) = apply {
                this.coverMediaUrl = coverMediaUrl
            }

            fun previewText(previewText: String) = previewText(JsonField.of(previewText))

            /**
             * Sets [Builder.previewText] to an arbitrary JSON value.
             *
             * You should usually call [Builder.previewText] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun previewText(previewText: JsonField<String>) = apply {
                this.previewText = previewText
            }

            fun title(title: String) = title(JsonField.of(title))

            /**
             * Sets [Builder.title] to an arbitrary JSON value.
             *
             * You should usually call [Builder.title] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun title(title: JsonField<String>) = apply { this.title = title }

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
             * Returns an immutable instance of [Article].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Article =
                Article(id, coverMediaUrl, previewText, title, additionalProperties.toMutableMap())
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
        fun validate(): Article = apply {
            if (validated) {
                return@apply
            }

            id()
            coverMediaUrl()
            previewText()
            title()
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
                (if (coverMediaUrl.asKnown().isPresent) 1 else 0) +
                (if (previewText.asKnown().isPresent) 1 else 0) +
                (if (title.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Article &&
                id == other.id &&
                coverMediaUrl == other.coverMediaUrl &&
                previewText == other.previewText &&
                title == other.title &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, coverMediaUrl, previewText, title, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Article{id=$id, coverMediaUrl=$coverMediaUrl, previewText=$previewText, title=$title, additionalProperties=$additionalProperties}"
    }

    /** Public card metadata attached to a tweet. */
    class Card
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val bindingValues: JsonField<BindingValues>,
        private val name: JsonField<String>,
        private val url: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bindingValues")
            @ExcludeMissing
            bindingValues: JsonField<BindingValues> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        ) : this(id, bindingValues, name, url, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun bindingValues(): Optional<BindingValues> = bindingValues.getOptional("bindingValues")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [bindingValues].
         *
         * Unlike [bindingValues], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("bindingValues")
        @ExcludeMissing
        fun _bindingValues(): JsonField<BindingValues> = bindingValues

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

            /** Returns a mutable builder for constructing an instance of [Card]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Card]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var bindingValues: JsonField<BindingValues> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(card: Card) = apply {
                id = card.id
                bindingValues = card.bindingValues
                name = card.name
                url = card.url
                additionalProperties = card.additionalProperties.toMutableMap()
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

            fun bindingValues(bindingValues: BindingValues) =
                bindingValues(JsonField.of(bindingValues))

            /**
             * Sets [Builder.bindingValues] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bindingValues] with a well-typed [BindingValues]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun bindingValues(bindingValues: JsonField<BindingValues>) = apply {
                this.bindingValues = bindingValues
            }

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

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
             * Returns an immutable instance of [Card].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Card =
                Card(id, bindingValues, name, url, additionalProperties.toMutableMap())
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
        fun validate(): Card = apply {
            if (validated) {
                return@apply
            }

            id()
            bindingValues().ifPresent { it.validate() }
            name()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (bindingValues.asKnown().getOrNull()?.validity() ?: 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0)

        class BindingValues
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

                /** Returns a mutable builder for constructing an instance of [BindingValues]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [BindingValues]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(bindingValues: BindingValues) = apply {
                    additionalProperties = bindingValues.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [BindingValues].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): BindingValues = BindingValues(additionalProperties.toImmutable())
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
            fun validate(): BindingValues = apply {
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

                return other is BindingValues && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "BindingValues{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Card &&
                id == other.id &&
                bindingValues == other.bindingValues &&
                name == other.name &&
                url == other.url &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, bindingValues, name, url, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Card{id=$id, bindingValues=$bindingValues, name=$name, url=$url, additionalProperties=$additionalProperties}"
    }

    /** Community Note presentation metadata returned by X. */
    class CommunityNote
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val destinationUrl: JsonField<String>,
        private val footer: JsonField<String>,
        private val shortTitle: JsonField<String>,
        private val subtitle: JsonField<String>,
        private val title: JsonField<String>,
        private val visualStyle: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("destinationUrl")
            @ExcludeMissing
            destinationUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("footer") @ExcludeMissing footer: JsonField<String> = JsonMissing.of(),
            @JsonProperty("shortTitle")
            @ExcludeMissing
            shortTitle: JsonField<String> = JsonMissing.of(),
            @JsonProperty("subtitle")
            @ExcludeMissing
            subtitle: JsonField<String> = JsonMissing.of(),
            @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
            @JsonProperty("visualStyle")
            @ExcludeMissing
            visualStyle: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            destinationUrl,
            footer,
            shortTitle,
            subtitle,
            title,
            visualStyle,
            mutableMapOf(),
        )

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun destinationUrl(): Optional<String> = destinationUrl.getOptional("destinationUrl")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun footer(): Optional<String> = footer.getOptional("footer")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun shortTitle(): Optional<String> = shortTitle.getOptional("shortTitle")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun subtitle(): Optional<String> = subtitle.getOptional("subtitle")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun title(): Optional<String> = title.getOptional("title")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun visualStyle(): Optional<String> = visualStyle.getOptional("visualStyle")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [destinationUrl].
         *
         * Unlike [destinationUrl], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("destinationUrl")
        @ExcludeMissing
        fun _destinationUrl(): JsonField<String> = destinationUrl

        /**
         * Returns the raw JSON value of [footer].
         *
         * Unlike [footer], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("footer") @ExcludeMissing fun _footer(): JsonField<String> = footer

        /**
         * Returns the raw JSON value of [shortTitle].
         *
         * Unlike [shortTitle], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("shortTitle")
        @ExcludeMissing
        fun _shortTitle(): JsonField<String> = shortTitle

        /**
         * Returns the raw JSON value of [subtitle].
         *
         * Unlike [subtitle], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("subtitle") @ExcludeMissing fun _subtitle(): JsonField<String> = subtitle

        /**
         * Returns the raw JSON value of [title].
         *
         * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

        /**
         * Returns the raw JSON value of [visualStyle].
         *
         * Unlike [visualStyle], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("visualStyle")
        @ExcludeMissing
        fun _visualStyle(): JsonField<String> = visualStyle

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

            /** Returns a mutable builder for constructing an instance of [CommunityNote]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CommunityNote]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var destinationUrl: JsonField<String> = JsonMissing.of()
            private var footer: JsonField<String> = JsonMissing.of()
            private var shortTitle: JsonField<String> = JsonMissing.of()
            private var subtitle: JsonField<String> = JsonMissing.of()
            private var title: JsonField<String> = JsonMissing.of()
            private var visualStyle: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(communityNote: CommunityNote) = apply {
                id = communityNote.id
                destinationUrl = communityNote.destinationUrl
                footer = communityNote.footer
                shortTitle = communityNote.shortTitle
                subtitle = communityNote.subtitle
                title = communityNote.title
                visualStyle = communityNote.visualStyle
                additionalProperties = communityNote.additionalProperties.toMutableMap()
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

            fun destinationUrl(destinationUrl: String) =
                destinationUrl(JsonField.of(destinationUrl))

            /**
             * Sets [Builder.destinationUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.destinationUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun destinationUrl(destinationUrl: JsonField<String>) = apply {
                this.destinationUrl = destinationUrl
            }

            fun footer(footer: String) = footer(JsonField.of(footer))

            /**
             * Sets [Builder.footer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.footer] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun footer(footer: JsonField<String>) = apply { this.footer = footer }

            fun shortTitle(shortTitle: String) = shortTitle(JsonField.of(shortTitle))

            /**
             * Sets [Builder.shortTitle] to an arbitrary JSON value.
             *
             * You should usually call [Builder.shortTitle] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun shortTitle(shortTitle: JsonField<String>) = apply { this.shortTitle = shortTitle }

            fun subtitle(subtitle: String) = subtitle(JsonField.of(subtitle))

            /**
             * Sets [Builder.subtitle] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subtitle] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subtitle(subtitle: JsonField<String>) = apply { this.subtitle = subtitle }

            fun title(title: String) = title(JsonField.of(title))

            /**
             * Sets [Builder.title] to an arbitrary JSON value.
             *
             * You should usually call [Builder.title] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun title(title: JsonField<String>) = apply { this.title = title }

            fun visualStyle(visualStyle: String) = visualStyle(JsonField.of(visualStyle))

            /**
             * Sets [Builder.visualStyle] to an arbitrary JSON value.
             *
             * You should usually call [Builder.visualStyle] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun visualStyle(visualStyle: JsonField<String>) = apply {
                this.visualStyle = visualStyle
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
             * Returns an immutable instance of [CommunityNote].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): CommunityNote =
                CommunityNote(
                    id,
                    destinationUrl,
                    footer,
                    shortTitle,
                    subtitle,
                    title,
                    visualStyle,
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
        fun validate(): CommunityNote = apply {
            if (validated) {
                return@apply
            }

            id()
            destinationUrl()
            footer()
            shortTitle()
            subtitle()
            title()
            visualStyle()
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
                (if (destinationUrl.asKnown().isPresent) 1 else 0) +
                (if (footer.asKnown().isPresent) 1 else 0) +
                (if (shortTitle.asKnown().isPresent) 1 else 0) +
                (if (subtitle.asKnown().isPresent) 1 else 0) +
                (if (title.asKnown().isPresent) 1 else 0) +
                (if (visualStyle.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CommunityNote &&
                id == other.id &&
                destinationUrl == other.destinationUrl &&
                footer == other.footer &&
                shortTitle == other.shortTitle &&
                subtitle == other.subtitle &&
                title == other.title &&
                visualStyle == other.visualStyle &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                destinationUrl,
                footer,
                shortTitle,
                subtitle,
                title,
                visualStyle,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CommunityNote{id=$id, destinationUrl=$destinationUrl, footer=$footer, shortTitle=$shortTitle, subtitle=$subtitle, title=$title, visualStyle=$visualStyle, additionalProperties=$additionalProperties}"
    }

    /** Edit history metadata returned by X. */
    class Edit
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val editableUntilMsecs: JsonField<String>,
        private val editTweetIds: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("editableUntilMsecs")
            @ExcludeMissing
            editableUntilMsecs: JsonField<String> = JsonMissing.of(),
            @JsonProperty("editTweetIds")
            @ExcludeMissing
            editTweetIds: JsonField<List<String>> = JsonMissing.of(),
        ) : this(editableUntilMsecs, editTweetIds, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun editableUntilMsecs(): Optional<String> =
            editableUntilMsecs.getOptional("editableUntilMsecs")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun editTweetIds(): Optional<List<String>> = editTweetIds.getOptional("editTweetIds")

        /**
         * Returns the raw JSON value of [editableUntilMsecs].
         *
         * Unlike [editableUntilMsecs], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("editableUntilMsecs")
        @ExcludeMissing
        fun _editableUntilMsecs(): JsonField<String> = editableUntilMsecs

        /**
         * Returns the raw JSON value of [editTweetIds].
         *
         * Unlike [editTweetIds], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("editTweetIds")
        @ExcludeMissing
        fun _editTweetIds(): JsonField<List<String>> = editTweetIds

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

            /** Returns a mutable builder for constructing an instance of [Edit]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Edit]. */
        class Builder internal constructor() {

            private var editableUntilMsecs: JsonField<String> = JsonMissing.of()
            private var editTweetIds: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(edit: Edit) = apply {
                editableUntilMsecs = edit.editableUntilMsecs
                editTweetIds = edit.editTweetIds.map { it.toMutableList() }
                additionalProperties = edit.additionalProperties.toMutableMap()
            }

            fun editableUntilMsecs(editableUntilMsecs: String) =
                editableUntilMsecs(JsonField.of(editableUntilMsecs))

            /**
             * Sets [Builder.editableUntilMsecs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.editableUntilMsecs] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun editableUntilMsecs(editableUntilMsecs: JsonField<String>) = apply {
                this.editableUntilMsecs = editableUntilMsecs
            }

            fun editTweetIds(editTweetIds: List<String>) = editTweetIds(JsonField.of(editTweetIds))

            /**
             * Sets [Builder.editTweetIds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.editTweetIds] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun editTweetIds(editTweetIds: JsonField<List<String>>) = apply {
                this.editTweetIds = editTweetIds.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [editTweetIds].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addEditTweetId(editTweetId: String) = apply {
                editTweetIds =
                    (editTweetIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("editTweetIds", it).add(editTweetId)
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
             * Returns an immutable instance of [Edit].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Edit =
                Edit(
                    editableUntilMsecs,
                    (editTweetIds ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): Edit = apply {
            if (validated) {
                return@apply
            }

            editableUntilMsecs()
            editTweetIds()
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
            (if (editableUntilMsecs.asKnown().isPresent) 1 else 0) +
                (editTweetIds.asKnown().getOrNull()?.size ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Edit &&
                editableUntilMsecs == other.editableUntilMsecs &&
                editTweetIds == other.editTweetIds &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(editableUntilMsecs, editTweetIds, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Edit{editableUntilMsecs=$editableUntilMsecs, editTweetIds=$editTweetIds, additionalProperties=$additionalProperties}"
    }

    /** Parsed search-result entities including URLs, mentions, hashtags, and media markers */
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
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

    /** Complete Note Tweet content and rich-text metadata. */
    class NoteTweet
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val text: JsonField<String>,
        private val id: JsonField<String>,
        private val entities: JsonField<Entities>,
        private val isExpandable: JsonField<Boolean>,
        private val richtextTags: JsonField<List<RichtextTag>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("entities")
            @ExcludeMissing
            entities: JsonField<Entities> = JsonMissing.of(),
            @JsonProperty("isExpandable")
            @ExcludeMissing
            isExpandable: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("richtextTags")
            @ExcludeMissing
            richtextTags: JsonField<List<RichtextTag>> = JsonMissing.of(),
        ) : this(text, id, entities, isExpandable, richtextTags, mutableMapOf())

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
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun entities(): Optional<Entities> = entities.getOptional("entities")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun isExpandable(): Optional<Boolean> = isExpandable.getOptional("isExpandable")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun richtextTags(): Optional<List<RichtextTag>> = richtextTags.getOptional("richtextTags")

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [entities].
         *
         * Unlike [entities], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("entities") @ExcludeMissing fun _entities(): JsonField<Entities> = entities

        /**
         * Returns the raw JSON value of [isExpandable].
         *
         * Unlike [isExpandable], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("isExpandable")
        @ExcludeMissing
        fun _isExpandable(): JsonField<Boolean> = isExpandable

        /**
         * Returns the raw JSON value of [richtextTags].
         *
         * Unlike [richtextTags], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("richtextTags")
        @ExcludeMissing
        fun _richtextTags(): JsonField<List<RichtextTag>> = richtextTags

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
             * Returns a mutable builder for constructing an instance of [NoteTweet].
             *
             * The following fields are required:
             * ```java
             * .text()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [NoteTweet]. */
        class Builder internal constructor() {

            private var text: JsonField<String>? = null
            private var id: JsonField<String> = JsonMissing.of()
            private var entities: JsonField<Entities> = JsonMissing.of()
            private var isExpandable: JsonField<Boolean> = JsonMissing.of()
            private var richtextTags: JsonField<MutableList<RichtextTag>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(noteTweet: NoteTweet) = apply {
                text = noteTweet.text
                id = noteTweet.id
                entities = noteTweet.entities
                isExpandable = noteTweet.isExpandable
                richtextTags = noteTweet.richtextTags.map { it.toMutableList() }
                additionalProperties = noteTweet.additionalProperties.toMutableMap()
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

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun entities(entities: Entities) = entities(JsonField.of(entities))

            /**
             * Sets [Builder.entities] to an arbitrary JSON value.
             *
             * You should usually call [Builder.entities] with a well-typed [Entities] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun entities(entities: JsonField<Entities>) = apply { this.entities = entities }

            fun isExpandable(isExpandable: Boolean) = isExpandable(JsonField.of(isExpandable))

            /**
             * Sets [Builder.isExpandable] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isExpandable] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isExpandable(isExpandable: JsonField<Boolean>) = apply {
                this.isExpandable = isExpandable
            }

            fun richtextTags(richtextTags: List<RichtextTag>) =
                richtextTags(JsonField.of(richtextTags))

            /**
             * Sets [Builder.richtextTags] to an arbitrary JSON value.
             *
             * You should usually call [Builder.richtextTags] with a well-typed `List<RichtextTag>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun richtextTags(richtextTags: JsonField<List<RichtextTag>>) = apply {
                this.richtextTags = richtextTags.map { it.toMutableList() }
            }

            /**
             * Adds a single [RichtextTag] to [richtextTags].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRichtextTag(richtextTag: RichtextTag) = apply {
                richtextTags =
                    (richtextTags ?: JsonField.of(mutableListOf())).also {
                        checkKnown("richtextTags", it).add(richtextTag)
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
             * Returns an immutable instance of [NoteTweet].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .text()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): NoteTweet =
                NoteTweet(
                    checkRequired("text", text),
                    id,
                    entities,
                    isExpandable,
                    (richtextTags ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): NoteTweet = apply {
            if (validated) {
                return@apply
            }

            text()
            id()
            entities().ifPresent { it.validate() }
            isExpandable()
            richtextTags().ifPresent { it.forEach { it.validate() } }
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
            (if (text.asKnown().isPresent) 1 else 0) +
                (if (id.asKnown().isPresent) 1 else 0) +
                (entities.asKnown().getOrNull()?.validity() ?: 0) +
                (if (isExpandable.asKnown().isPresent) 1 else 0) +
                (richtextTags.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

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
                 * Returns an immutable instance of [Entities].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Entities = Entities(additionalProperties.toImmutable())
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

        class RichtextTag
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val fromIndex: JsonField<Long>,
            private val toIndex: JsonField<Long>,
            private val types: JsonField<List<String>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("fromIndex")
                @ExcludeMissing
                fromIndex: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("toIndex")
                @ExcludeMissing
                toIndex: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("types")
                @ExcludeMissing
                types: JsonField<List<String>> = JsonMissing.of(),
            ) : this(fromIndex, toIndex, types, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun fromIndex(): Long = fromIndex.getRequired("fromIndex")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun toIndex(): Long = toIndex.getRequired("toIndex")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun types(): List<String> = types.getRequired("types")

            /**
             * Returns the raw JSON value of [fromIndex].
             *
             * Unlike [fromIndex], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("fromIndex") @ExcludeMissing fun _fromIndex(): JsonField<Long> = fromIndex

            /**
             * Returns the raw JSON value of [toIndex].
             *
             * Unlike [toIndex], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("toIndex") @ExcludeMissing fun _toIndex(): JsonField<Long> = toIndex

            /**
             * Returns the raw JSON value of [types].
             *
             * Unlike [types], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("types") @ExcludeMissing fun _types(): JsonField<List<String>> = types

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
                 * Returns a mutable builder for constructing an instance of [RichtextTag].
                 *
                 * The following fields are required:
                 * ```java
                 * .fromIndex()
                 * .toIndex()
                 * .types()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [RichtextTag]. */
            class Builder internal constructor() {

                private var fromIndex: JsonField<Long>? = null
                private var toIndex: JsonField<Long>? = null
                private var types: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(richtextTag: RichtextTag) = apply {
                    fromIndex = richtextTag.fromIndex
                    toIndex = richtextTag.toIndex
                    types = richtextTag.types.map { it.toMutableList() }
                    additionalProperties = richtextTag.additionalProperties.toMutableMap()
                }

                fun fromIndex(fromIndex: Long) = fromIndex(JsonField.of(fromIndex))

                /**
                 * Sets [Builder.fromIndex] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fromIndex] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fromIndex(fromIndex: JsonField<Long>) = apply { this.fromIndex = fromIndex }

                fun toIndex(toIndex: Long) = toIndex(JsonField.of(toIndex))

                /**
                 * Sets [Builder.toIndex] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.toIndex] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun toIndex(toIndex: JsonField<Long>) = apply { this.toIndex = toIndex }

                fun types(types: List<String>) = types(JsonField.of(types))

                /**
                 * Sets [Builder.types] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.types] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun types(types: JsonField<List<String>>) = apply {
                    this.types = types.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [types].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addType(type: String) = apply {
                    types =
                        (types ?: JsonField.of(mutableListOf())).also {
                            checkKnown("types", it).add(type)
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
                 * Returns an immutable instance of [RichtextTag].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .fromIndex()
                 * .toIndex()
                 * .types()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): RichtextTag =
                    RichtextTag(
                        checkRequired("fromIndex", fromIndex),
                        checkRequired("toIndex", toIndex),
                        checkRequired("types", types).map { it.toImmutable() },
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
            fun validate(): RichtextTag = apply {
                if (validated) {
                    return@apply
                }

                fromIndex()
                toIndex()
                types()
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
                (if (fromIndex.asKnown().isPresent) 1 else 0) +
                    (if (toIndex.asKnown().isPresent) 1 else 0) +
                    (types.asKnown().getOrNull()?.size ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is RichtextTag &&
                    fromIndex == other.fromIndex &&
                    toIndex == other.toIndex &&
                    types == other.types &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(fromIndex, toIndex, types, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "RichtextTag{fromIndex=$fromIndex, toIndex=$toIndex, types=$types, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is NoteTweet &&
                text == other.text &&
                id == other.id &&
                entities == other.entities &&
                isExpandable == other.isExpandable &&
                richtextTags == other.richtextTags &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(text, id, entities, isExpandable, richtextTags, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "NoteTweet{text=$text, id=$id, entities=$entities, isExpandable=$isExpandable, richtextTags=$richtextTags, additionalProperties=$additionalProperties}"
    }

    /** Public place metadata attached to a tweet. */
    class Place
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val boundingBox: JsonField<BoundingBox>,
        private val country: JsonField<String>,
        private val countryCode: JsonField<String>,
        private val fullName: JsonField<String>,
        private val name: JsonField<String>,
        private val placeType: JsonField<String>,
        private val url: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("boundingBox")
            @ExcludeMissing
            boundingBox: JsonField<BoundingBox> = JsonMissing.of(),
            @JsonProperty("country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
            @JsonProperty("countryCode")
            @ExcludeMissing
            countryCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("fullName")
            @ExcludeMissing
            fullName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("placeType")
            @ExcludeMissing
            placeType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            boundingBox,
            country,
            countryCode,
            fullName,
            name,
            placeType,
            url,
            mutableMapOf(),
        )

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun boundingBox(): Optional<BoundingBox> = boundingBox.getOptional("boundingBox")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun country(): Optional<String> = country.getOptional("country")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun countryCode(): Optional<String> = countryCode.getOptional("countryCode")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun fullName(): Optional<String> = fullName.getOptional("fullName")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun placeType(): Optional<String> = placeType.getOptional("placeType")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [boundingBox].
         *
         * Unlike [boundingBox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("boundingBox")
        @ExcludeMissing
        fun _boundingBox(): JsonField<BoundingBox> = boundingBox

        /**
         * Returns the raw JSON value of [country].
         *
         * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

        /**
         * Returns the raw JSON value of [countryCode].
         *
         * Unlike [countryCode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("countryCode")
        @ExcludeMissing
        fun _countryCode(): JsonField<String> = countryCode

        /**
         * Returns the raw JSON value of [fullName].
         *
         * Unlike [fullName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fullName") @ExcludeMissing fun _fullName(): JsonField<String> = fullName

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [placeType].
         *
         * Unlike [placeType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("placeType") @ExcludeMissing fun _placeType(): JsonField<String> = placeType

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

            /** Returns a mutable builder for constructing an instance of [Place]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Place]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var boundingBox: JsonField<BoundingBox> = JsonMissing.of()
            private var country: JsonField<String> = JsonMissing.of()
            private var countryCode: JsonField<String> = JsonMissing.of()
            private var fullName: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var placeType: JsonField<String> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(place: Place) = apply {
                id = place.id
                boundingBox = place.boundingBox
                country = place.country
                countryCode = place.countryCode
                fullName = place.fullName
                name = place.name
                placeType = place.placeType
                url = place.url
                additionalProperties = place.additionalProperties.toMutableMap()
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

            fun boundingBox(boundingBox: BoundingBox) = boundingBox(JsonField.of(boundingBox))

            /**
             * Sets [Builder.boundingBox] to an arbitrary JSON value.
             *
             * You should usually call [Builder.boundingBox] with a well-typed [BoundingBox] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun boundingBox(boundingBox: JsonField<BoundingBox>) = apply {
                this.boundingBox = boundingBox
            }

            fun country(country: String) = country(JsonField.of(country))

            /**
             * Sets [Builder.country] to an arbitrary JSON value.
             *
             * You should usually call [Builder.country] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun country(country: JsonField<String>) = apply { this.country = country }

            fun countryCode(countryCode: String) = countryCode(JsonField.of(countryCode))

            /**
             * Sets [Builder.countryCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.countryCode] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun countryCode(countryCode: JsonField<String>) = apply {
                this.countryCode = countryCode
            }

            fun fullName(fullName: String) = fullName(JsonField.of(fullName))

            /**
             * Sets [Builder.fullName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fullName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fullName(fullName: JsonField<String>) = apply { this.fullName = fullName }

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun placeType(placeType: String) = placeType(JsonField.of(placeType))

            /**
             * Sets [Builder.placeType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.placeType] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun placeType(placeType: JsonField<String>) = apply { this.placeType = placeType }

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
             * Returns an immutable instance of [Place].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Place =
                Place(
                    id,
                    boundingBox,
                    country,
                    countryCode,
                    fullName,
                    name,
                    placeType,
                    url,
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
        fun validate(): Place = apply {
            if (validated) {
                return@apply
            }

            id()
            boundingBox().ifPresent { it.validate() }
            country()
            countryCode()
            fullName()
            name()
            placeType()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (boundingBox.asKnown().getOrNull()?.validity() ?: 0) +
                (if (country.asKnown().isPresent) 1 else 0) +
                (if (countryCode.asKnown().isPresent) 1 else 0) +
                (if (fullName.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (placeType.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0)

        class BoundingBox
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

                /** Returns a mutable builder for constructing an instance of [BoundingBox]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [BoundingBox]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(boundingBox: BoundingBox) = apply {
                    additionalProperties = boundingBox.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [BoundingBox].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): BoundingBox = BoundingBox(additionalProperties.toImmutable())
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
            fun validate(): BoundingBox = apply {
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

                return other is BoundingBox && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "BoundingBox{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Place &&
                id == other.id &&
                boundingBox == other.boundingBox &&
                country == other.country &&
                countryCode == other.countryCode &&
                fullName == other.fullName &&
                name == other.name &&
                placeType == other.placeType &&
                url == other.url &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                boundingBox,
                country,
                countryCode,
                fullName,
                name,
                placeType,
                url,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Place{id=$id, boundingBox=$boundingBox, country=$country, countryCode=$countryCode, fullName=$fullName, name=$name, placeType=$placeType, url=$url, additionalProperties=$additionalProperties}"
    }

    /** Engagement counts retained from a prior tweet edit. */
    class PreviousCounts
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val bookmarkCount: JsonField<Long>,
        private val likeCount: JsonField<Long>,
        private val quoteCount: JsonField<Long>,
        private val replyCount: JsonField<Long>,
        private val retweetCount: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
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
        ) : this(bookmarkCount, likeCount, quoteCount, replyCount, retweetCount, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun bookmarkCount(): Optional<Long> = bookmarkCount.getOptional("bookmarkCount")

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

            /** Returns a mutable builder for constructing an instance of [PreviousCounts]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PreviousCounts]. */
        class Builder internal constructor() {

            private var bookmarkCount: JsonField<Long> = JsonMissing.of()
            private var likeCount: JsonField<Long> = JsonMissing.of()
            private var quoteCount: JsonField<Long> = JsonMissing.of()
            private var replyCount: JsonField<Long> = JsonMissing.of()
            private var retweetCount: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(previousCounts: PreviousCounts) = apply {
                bookmarkCount = previousCounts.bookmarkCount
                likeCount = previousCounts.likeCount
                quoteCount = previousCounts.quoteCount
                replyCount = previousCounts.replyCount
                retweetCount = previousCounts.retweetCount
                additionalProperties = previousCounts.additionalProperties.toMutableMap()
            }

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
             * Returns an immutable instance of [PreviousCounts].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): PreviousCounts =
                PreviousCounts(
                    bookmarkCount,
                    likeCount,
                    quoteCount,
                    replyCount,
                    retweetCount,
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
        fun validate(): PreviousCounts = apply {
            if (validated) {
                return@apply
            }

            bookmarkCount()
            likeCount()
            quoteCount()
            replyCount()
            retweetCount()
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
            (if (bookmarkCount.asKnown().isPresent) 1 else 0) +
                (if (likeCount.asKnown().isPresent) 1 else 0) +
                (if (quoteCount.asKnown().isPresent) 1 else 0) +
                (if (replyCount.asKnown().isPresent) 1 else 0) +
                (if (retweetCount.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PreviousCounts &&
                bookmarkCount == other.bookmarkCount &&
                likeCount == other.likeCount &&
                quoteCount == other.quoteCount &&
                replyCount == other.replyCount &&
                retweetCount == other.retweetCount &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                bookmarkCount,
                likeCount,
                quoteCount,
                replyCount,
                retweetCount,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PreviousCounts{bookmarkCount=$bookmarkCount, likeCount=$likeCount, quoteCount=$quoteCount, replyCount=$replyCount, retweetCount=$retweetCount, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SearchTweet &&
            id == other.id &&
            bookmarkCount == other.bookmarkCount &&
            likeCount == other.likeCount &&
            quoteCount == other.quoteCount &&
            replyCount == other.replyCount &&
            retweetCount == other.retweetCount &&
            text == other.text &&
            viewCount == other.viewCount &&
            article == other.article &&
            author == other.author &&
            card == other.card &&
            communityNote == other.communityNote &&
            contentDisclosure == other.contentDisclosure &&
            conversationId == other.conversationId &&
            createdAt == other.createdAt &&
            displayTextRange == other.displayTextRange &&
            edit == other.edit &&
            entities == other.entities &&
            inReplyToId == other.inReplyToId &&
            inReplyToUserId == other.inReplyToUserId &&
            inReplyToUsername == other.inReplyToUsername &&
            isLimitedReply == other.isLimitedReply &&
            isNoteTweet == other.isNoteTweet &&
            isQuoteStatus == other.isQuoteStatus &&
            isReply == other.isReply &&
            isTranslatable == other.isTranslatable &&
            lang == other.lang &&
            media == other.media &&
            noteTweet == other.noteTweet &&
            place == other.place &&
            possiblySensitive == other.possiblySensitive &&
            previousCounts == other.previousCounts &&
            quotedTweet == other.quotedTweet &&
            retweetedTweet == other.retweetedTweet &&
            source == other.source &&
            type == other.type &&
            url == other.url &&
            viewState == other.viewState &&
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
            article,
            author,
            card,
            communityNote,
            contentDisclosure,
            conversationId,
            createdAt,
            displayTextRange,
            edit,
            entities,
            inReplyToId,
            inReplyToUserId,
            inReplyToUsername,
            isLimitedReply,
            isNoteTweet,
            isQuoteStatus,
            isReply,
            isTranslatable,
            lang,
            media,
            noteTweet,
            place,
            possiblySensitive,
            previousCounts,
            quotedTweet,
            retweetedTweet,
            source,
            type,
            url,
            viewState,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SearchTweet{id=$id, bookmarkCount=$bookmarkCount, likeCount=$likeCount, quoteCount=$quoteCount, replyCount=$replyCount, retweetCount=$retweetCount, text=$text, viewCount=$viewCount, article=$article, author=$author, card=$card, communityNote=$communityNote, contentDisclosure=$contentDisclosure, conversationId=$conversationId, createdAt=$createdAt, displayTextRange=$displayTextRange, edit=$edit, entities=$entities, inReplyToId=$inReplyToId, inReplyToUserId=$inReplyToUserId, inReplyToUsername=$inReplyToUsername, isLimitedReply=$isLimitedReply, isNoteTweet=$isNoteTweet, isQuoteStatus=$isQuoteStatus, isReply=$isReply, isTranslatable=$isTranslatable, lang=$lang, media=$media, noteTweet=$noteTweet, place=$place, possiblySensitive=$possiblySensitive, previousCounts=$previousCounts, quotedTweet=$quotedTweet, retweetedTweet=$retweetedTweet, source=$source, type=$type, url=$url, viewState=$viewState, additionalProperties=$additionalProperties}"
}
