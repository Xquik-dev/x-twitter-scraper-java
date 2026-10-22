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
 * Quoted or retweeted tweet context. Every object includes id, text, and engagement metrics. A zero
 * metric can mean X did not report the count. Author, media, and conversation fields appear when
 * available.
 */
class EmbeddedTweet
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val bookmarkCount: JsonField<Long>,
    private val unknownCounts: JsonField<List<UnknownCount>>,
    private val likeCount: JsonField<Long>,
    private val quoteCount: JsonField<Long>,
    private val replyCount: JsonField<Long>,
    private val retweetCount: JsonField<Long>,
    private val text: JsonField<String>,
    private val viewCount: JsonField<Long>,
    private val article: JsonField<Article>,
    private val author: JsonField<UserProfile>,
    private val authorUnavailable: JsonField<SearchTweet.AuthorUnavailable>,
    private val card: JsonField<Card>,
    private val cashtagAttachments: JsonField<List<SearchTweet.CashtagAttachment>>,
    private val communityId: JsonField<String>,
    private val communityName: JsonField<String>,
    private val communityNote: JsonField<CommunityNote>,
    private val contentDisclosure: JsonField<ContentDisclosure>,
    private val conversationControl: JsonField<SearchTweet.ConversationControl>,
    private val conversationId: JsonField<String>,
    private val coordinates: JsonField<SearchTweet.Coordinates>,
    private val createdAt: JsonField<String>,
    private val displayTextRange: JsonField<List<Long>>,
    private val edit: JsonField<Edit>,
    private val entities: JsonField<Entities>,
    private val exclusiveContent: JsonField<SearchTweet.ExclusiveContent>,
    private val geo: JsonField<SearchTweet.Geo>,
    private val grokShareAttachment: JsonField<SearchTweet.GrokShareAttachment>,
    private val grokTranslatedPost: JsonField<SearchTweet.GrokTranslatedPost>,
    private val hasCommunityNotes: JsonField<Boolean>,
    private val inReplyToId: JsonField<String>,
    private val inReplyToUserId: JsonField<String>,
    private val inReplyToUsername: JsonField<String>,
    private val interstitial: JsonField<SearchTweet.Interstitial>,
    private val isLimitedReply: JsonField<Boolean>,
    private val isNoteTweet: JsonField<Boolean>,
    private val isPinned: JsonField<Boolean>,
    private val isQuoteStatus: JsonField<Boolean>,
    private val isReply: JsonField<Boolean>,
    private val isRetweet: JsonField<Boolean>,
    private val isTranslatable: JsonField<Boolean>,
    private val jetfuelAttachment: JsonField<SearchTweet.JetfuelAttachment>,
    private val lang: JsonField<String>,
    private val limitedActions: JsonField<List<SearchTweet.LimitedAction>>,
    private val media: JsonField<List<TweetMedia>>,
    private val noteTweet: JsonField<NoteTweet>,
    private val parentTweet: JsonField<EmbeddedTweet>,
    private val place: JsonField<Place>,
    private val possiblySensitive: JsonField<Boolean>,
    private val postCta: JsonField<SearchTweet.PostCta>,
    private val previousCounts: JsonField<PreviousCounts>,
    private val quotedTweet: JsonField<EmbeddedTweet>,
    private val quotedTweetId: JsonField<String>,
    private val quotedTweetPermalink: JsonField<SearchTweet.QuotedTweetPermalink>,
    private val quotedTweetUnavailable: JsonField<SearchTweet.QuotedTweetUnavailable>,
    private val reactionContext: JsonField<SearchTweet.ReactionContext>,
    private val retweetedTweet: JsonField<EmbeddedTweet>,
    private val retweetedAt: JsonField<OffsetDateTime>,
    private val scopes: JsonField<SearchTweet.Scopes>,
    private val softIntervention: JsonField<SoftIntervention>,
    private val source: JsonField<String>,
    private val sportsContext: JsonField<SearchTweet.SportsContext>,
    private val subscriberBadge: JsonField<SearchTweet.SubscriberBadge>,
    private val textHighlights: JsonField<List<SearchTweet.TextHighlight>>,
    private val tombstone: JsonField<SearchTweet.Tombstone>,
    private val type: JsonField<String>,
    private val unavailableAuthorId: JsonField<String>,
    private val unmentionedUserIds: JsonField<List<String>>,
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
        @JsonProperty("unknownCounts")
        @ExcludeMissing
        unknownCounts: JsonField<List<UnknownCount>> = JsonMissing.of(),
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
        @JsonProperty("authorUnavailable")
        @ExcludeMissing
        authorUnavailable: JsonField<SearchTweet.AuthorUnavailable> = JsonMissing.of(),
        @JsonProperty("card") @ExcludeMissing card: JsonField<Card> = JsonMissing.of(),
        @JsonProperty("cashtagAttachments")
        @ExcludeMissing
        cashtagAttachments: JsonField<List<SearchTweet.CashtagAttachment>> = JsonMissing.of(),
        @JsonProperty("communityId")
        @ExcludeMissing
        communityId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("communityName")
        @ExcludeMissing
        communityName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("communityNote")
        @ExcludeMissing
        communityNote: JsonField<CommunityNote> = JsonMissing.of(),
        @JsonProperty("contentDisclosure")
        @ExcludeMissing
        contentDisclosure: JsonField<ContentDisclosure> = JsonMissing.of(),
        @JsonProperty("conversationControl")
        @ExcludeMissing
        conversationControl: JsonField<SearchTweet.ConversationControl> = JsonMissing.of(),
        @JsonProperty("conversationId")
        @ExcludeMissing
        conversationId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("coordinates")
        @ExcludeMissing
        coordinates: JsonField<SearchTweet.Coordinates> = JsonMissing.of(),
        @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("displayTextRange")
        @ExcludeMissing
        displayTextRange: JsonField<List<Long>> = JsonMissing.of(),
        @JsonProperty("edit") @ExcludeMissing edit: JsonField<Edit> = JsonMissing.of(),
        @JsonProperty("entities") @ExcludeMissing entities: JsonField<Entities> = JsonMissing.of(),
        @JsonProperty("exclusiveContent")
        @ExcludeMissing
        exclusiveContent: JsonField<SearchTweet.ExclusiveContent> = JsonMissing.of(),
        @JsonProperty("geo") @ExcludeMissing geo: JsonField<SearchTweet.Geo> = JsonMissing.of(),
        @JsonProperty("grokShareAttachment")
        @ExcludeMissing
        grokShareAttachment: JsonField<SearchTweet.GrokShareAttachment> = JsonMissing.of(),
        @JsonProperty("grokTranslatedPost")
        @ExcludeMissing
        grokTranslatedPost: JsonField<SearchTweet.GrokTranslatedPost> = JsonMissing.of(),
        @JsonProperty("hasCommunityNotes")
        @ExcludeMissing
        hasCommunityNotes: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("inReplyToId")
        @ExcludeMissing
        inReplyToId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("inReplyToUserId")
        @ExcludeMissing
        inReplyToUserId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("inReplyToUsername")
        @ExcludeMissing
        inReplyToUsername: JsonField<String> = JsonMissing.of(),
        @JsonProperty("interstitial")
        @ExcludeMissing
        interstitial: JsonField<SearchTweet.Interstitial> = JsonMissing.of(),
        @JsonProperty("isLimitedReply")
        @ExcludeMissing
        isLimitedReply: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isNoteTweet")
        @ExcludeMissing
        isNoteTweet: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isPinned") @ExcludeMissing isPinned: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isQuoteStatus")
        @ExcludeMissing
        isQuoteStatus: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isReply") @ExcludeMissing isReply: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isRetweet") @ExcludeMissing isRetweet: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("isTranslatable")
        @ExcludeMissing
        isTranslatable: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("jetfuelAttachment")
        @ExcludeMissing
        jetfuelAttachment: JsonField<SearchTweet.JetfuelAttachment> = JsonMissing.of(),
        @JsonProperty("lang") @ExcludeMissing lang: JsonField<String> = JsonMissing.of(),
        @JsonProperty("limitedActions")
        @ExcludeMissing
        limitedActions: JsonField<List<SearchTweet.LimitedAction>> = JsonMissing.of(),
        @JsonProperty("media")
        @ExcludeMissing
        media: JsonField<List<TweetMedia>> = JsonMissing.of(),
        @JsonProperty("noteTweet")
        @ExcludeMissing
        noteTweet: JsonField<NoteTweet> = JsonMissing.of(),
        @JsonProperty("parentTweet")
        @ExcludeMissing
        parentTweet: JsonField<EmbeddedTweet> = JsonMissing.of(),
        @JsonProperty("place") @ExcludeMissing place: JsonField<Place> = JsonMissing.of(),
        @JsonProperty("possiblySensitive")
        @ExcludeMissing
        possiblySensitive: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("postCta")
        @ExcludeMissing
        postCta: JsonField<SearchTweet.PostCta> = JsonMissing.of(),
        @JsonProperty("previousCounts")
        @ExcludeMissing
        previousCounts: JsonField<PreviousCounts> = JsonMissing.of(),
        @JsonProperty("quoted_tweet")
        @ExcludeMissing
        quotedTweet: JsonField<EmbeddedTweet> = JsonMissing.of(),
        @JsonProperty("quotedTweetId")
        @ExcludeMissing
        quotedTweetId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("quotedTweetPermalink")
        @ExcludeMissing
        quotedTweetPermalink: JsonField<SearchTweet.QuotedTweetPermalink> = JsonMissing.of(),
        @JsonProperty("quotedTweetUnavailable")
        @ExcludeMissing
        quotedTweetUnavailable: JsonField<SearchTweet.QuotedTweetUnavailable> = JsonMissing.of(),
        @JsonProperty("reactionContext")
        @ExcludeMissing
        reactionContext: JsonField<SearchTweet.ReactionContext> = JsonMissing.of(),
        @JsonProperty("retweeted_tweet")
        @ExcludeMissing
        retweetedTweet: JsonField<EmbeddedTweet> = JsonMissing.of(),
        @JsonProperty("retweetedAt")
        @ExcludeMissing
        retweetedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("scopes")
        @ExcludeMissing
        scopes: JsonField<SearchTweet.Scopes> = JsonMissing.of(),
        @JsonProperty("softIntervention")
        @ExcludeMissing
        softIntervention: JsonField<SoftIntervention> = JsonMissing.of(),
        @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sportsContext")
        @ExcludeMissing
        sportsContext: JsonField<SearchTweet.SportsContext> = JsonMissing.of(),
        @JsonProperty("subscriberBadge")
        @ExcludeMissing
        subscriberBadge: JsonField<SearchTweet.SubscriberBadge> = JsonMissing.of(),
        @JsonProperty("textHighlights")
        @ExcludeMissing
        textHighlights: JsonField<List<SearchTweet.TextHighlight>> = JsonMissing.of(),
        @JsonProperty("tombstone")
        @ExcludeMissing
        tombstone: JsonField<SearchTweet.Tombstone> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("unavailableAuthorId")
        @ExcludeMissing
        unavailableAuthorId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("unmentionedUserIds")
        @ExcludeMissing
        unmentionedUserIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        @JsonProperty("viewState") @ExcludeMissing viewState: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        bookmarkCount,
        unknownCounts,
        likeCount,
        quoteCount,
        replyCount,
        retweetCount,
        text,
        viewCount,
        article,
        author,
        authorUnavailable,
        card,
        cashtagAttachments,
        communityId,
        communityName,
        communityNote,
        contentDisclosure,
        conversationControl,
        conversationId,
        coordinates,
        createdAt,
        displayTextRange,
        edit,
        entities,
        exclusiveContent,
        geo,
        grokShareAttachment,
        grokTranslatedPost,
        hasCommunityNotes,
        inReplyToId,
        inReplyToUserId,
        inReplyToUsername,
        interstitial,
        isLimitedReply,
        isNoteTweet,
        isPinned,
        isQuoteStatus,
        isReply,
        isRetweet,
        isTranslatable,
        jetfuelAttachment,
        lang,
        limitedActions,
        media,
        noteTweet,
        parentTweet,
        place,
        possiblySensitive,
        postCta,
        previousCounts,
        quotedTweet,
        quotedTweetId,
        quotedTweetPermalink,
        quotedTweetUnavailable,
        reactionContext,
        retweetedTweet,
        retweetedAt,
        scopes,
        softIntervention,
        source,
        sportsContext,
        subscriberBadge,
        textHighlights,
        tombstone,
        type,
        unavailableAuthorId,
        unmentionedUserIds,
        url,
        viewState,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun bookmarkCount(): Long = bookmarkCount.getRequired("bookmarkCount")

    /**
     * X did not send these counts, so each 0 means unknown.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun unknownCounts(): Optional<List<UnknownCount>> = unknownCounts.getOptional("unknownCounts")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun likeCount(): Long = likeCount.getRequired("likeCount")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun quoteCount(): Long = quoteCount.getRequired("quoteCount")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun replyCount(): Long = replyCount.getRequired("replyCount")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun retweetCount(): Long = retweetCount.getRequired("retweetCount")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun text(): String = text.getRequired("text")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun viewCount(): Long = viewCount.getRequired("viewCount")

    /**
     * Article metadata attached to a tweet.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun article(): Optional<Article> = article.getOptional("article")

    /**
     * X user profile with bio, follower counts, and verification status.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun author(): Optional<UserProfile> = author.getOptional("author")

    /**
     * Why the tweet has no author. X serves a suspended or deleted account as an unavailable user
     * with a reason such as Suspended or NotFound. Omitted when the author is available.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun authorUnavailable(): Optional<SearchTweet.AuthorUnavailable> =
        authorUnavailable.getOptional("authorUnavailable")

    /**
     * Public card metadata attached to a tweet.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun card(): Optional<Card> = card.getOptional("card")

    /**
     * Price charts the author attached under the post, 1 per cashtag. Absent when the post has
     * none. X may send a cashtag without a chart window.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun cashtagAttachments(): Optional<List<SearchTweet.CashtagAttachment>> =
        cashtagAttachments.getOptional("cashtagAttachments")

    /**
     * Community ID.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun communityId(): Optional<String> = communityId.getOptional("communityId")

    /**
     * Community name. Present when X sends it with the post.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun communityName(): Optional<String> = communityName.getOptional("communityName")

    /**
     * Community Note presentation metadata returned by X.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun communityNote(): Optional<CommunityNote> = communityNote.getOptional("communityNote")

    /**
     * Content disclosure metadata shown by X when a tweet is labeled as paid partnership content or
     * AI-generated media.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun contentDisclosure(): Optional<ContentDisclosure> =
        contentDisclosure.getOptional("contentDisclosure")

    /**
     * Reply policy & conversation owner.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun conversationControl(): Optional<SearchTweet.ConversationControl> =
        conversationControl.getOptional("conversationControl")

    /**
     * Root tweet ID for the conversation
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun conversationId(): Optional<String> = conversationId.getOptional("conversationId")

    /**
     * Author-published point, with longitude before latitude.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun coordinates(): Optional<SearchTweet.Coordinates> = coordinates.getOptional("coordinates")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun createdAt(): Optional<String> = createdAt.getOptional("createdAt")

    /**
     * Rendered text's start and end offsets.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun displayTextRange(): Optional<List<Long>> = displayTextRange.getOptional("displayTextRange")

    /**
     * Edit history metadata returned by X.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun edit(): Optional<Edit> = edit.getOptional("edit")

    /**
     * Parsed search-result entities including URLs, mentions, hashtags, and media markers
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun entities(): Optional<Entities> = entities.getOptional("entities")

    /**
     * Marks a subscriber-only post with the creator whose subscription unlocks it. Non-subscribers
     * get the preview text & the subscribe link. Omitted on public posts.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun exclusiveContent(): Optional<SearchTweet.ExclusiveContent> =
        exclusiveContent.getOptional("exclusiveContent")

    /**
     * Author-published point, with latitude before longitude.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun geo(): Optional<SearchTweet.Geo> = geo.getOptional("geo")

    /**
     * Public metadata whose fields X defines.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun grokShareAttachment(): Optional<SearchTweet.GrokShareAttachment> =
        grokShareAttachment.getOptional("grokShareAttachment")

    /**
     * Grok's translation of the post, as X shows it.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun grokTranslatedPost(): Optional<SearchTweet.GrokTranslatedPost> =
        grokTranslatedPost.getOptional("grokTranslatedPost")

    /**
     * Whether X holds Community Notes on the post, shown or not.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun hasCommunityNotes(): Optional<Boolean> = hasCommunityNotes.getOptional("hasCommunityNotes")

    /**
     * ID of the tweet this result replies to.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun inReplyToId(): Optional<String> = inReplyToId.getOptional("inReplyToId")

    /**
     * ID of the user this result replies to.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun inReplyToUserId(): Optional<String> = inReplyToUserId.getOptional("inReplyToUserId")

    /**
     * Username this result replies to.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun inReplyToUsername(): Optional<String> = inReplyToUsername.getOptional("inReplyToUsername")

    /**
     * The notice x.com covers the post with until the reader views it, such as X's public interest
     * notice on a post that broke its rules but stays up.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun interstitial(): Optional<SearchTweet.Interstitial> =
        interstitial.getOptional("interstitial")

    /**
     * Whether the tweet has limited reply permissions
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun isLimitedReply(): Optional<Boolean> = isLimitedReply.getOptional("isLimitedReply")

    /**
     * True for Note Tweets (long-form content, up to 25,000 characters)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun isNoteTweet(): Optional<Boolean> = isNoteTweet.getOptional("isNoteTweet")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun isPinned(): Optional<Boolean> = isPinned.getOptional("isPinned")

    /**
     * True when this tweet quotes another tweet
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun isQuoteStatus(): Optional<Boolean> = isQuoteStatus.getOptional("isQuoteStatus")

    /**
     * True when this tweet is a reply
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun isReply(): Optional<Boolean> = isReply.getOptional("isReply")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun isRetweet(): Optional<Boolean> = isRetweet.getOptional("isRetweet")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun isTranslatable(): Optional<Boolean> = isTranslatable.getOptional("isTranslatable")

    /**
     * Public metadata whose fields X defines.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun jetfuelAttachment(): Optional<SearchTweet.JetfuelAttachment> =
        jetfuelAttachment.getOptional("jetfuelAttachment")

    /**
     * Search result language code.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun lang(): Optional<String> = lang.getOptional("lang")

    /**
     * Public restrictions & prompts.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun limitedActions(): Optional<List<SearchTweet.LimitedAction>> =
        limitedActions.getOptional("limitedActions")

    /**
     * Media, omitted when unavailable.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun media(): Optional<List<TweetMedia>> = media.getOptional("media")

    /**
     * Complete Note Tweet content and rich-text metadata.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun noteTweet(): Optional<NoteTweet> = noteTweet.getOptional("noteTweet")

    /** The post this one replies to, with the same fields. */
    fun parentTweet(): Optional<EmbeddedTweet> = parentTweet.getOptional("parentTweet")

    /**
     * Public place metadata attached to a tweet.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun place(): Optional<Place> = place.getOptional("place")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun possiblySensitive(): Optional<Boolean> = possiblySensitive.getOptional("possiblySensitive")

    /**
     * Public metadata whose fields X defines.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun postCta(): Optional<SearchTweet.PostCta> = postCta.getOptional("postCta")

    /**
     * Engagement counts retained from a prior tweet edit.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun previousCounts(): Optional<PreviousCounts> = previousCounts.getOptional("previousCounts")

    /** The post this one quotes, with the same fields. */
    fun quotedTweet(): Optional<EmbeddedTweet> = quotedTweet.getOptional("quoted_tweet")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun quotedTweetId(): Optional<String> = quotedTweetId.getOptional("quotedTweetId")

    /**
     * The quoted post's link, kept when X withholds that post.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun quotedTweetPermalink(): Optional<SearchTweet.QuotedTweetPermalink> =
        quotedTweetPermalink.getOptional("quotedTweetPermalink")

    /**
     * Why X shows no quoted post. Omitted when X names no reason, as its legacy answers never do.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun quotedTweetUnavailable(): Optional<SearchTweet.QuotedTweetUnavailable> =
        quotedTweetUnavailable.getOptional("quotedTweetUnavailable")

    /**
     * Public post & user this reaction references.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun reactionContext(): Optional<SearchTweet.ReactionContext> =
        reactionContext.getOptional("reactionContext")

    /** The post this one reposts, with the same fields. */
    fun retweetedTweet(): Optional<EmbeddedTweet> = retweetedTweet.getOptional("retweeted_tweet")

    /**
     * Repost event time in UTC. Null when unavailable. Omitted for other posts.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun retweetedAt(): Optional<OffsetDateTime> = retweetedAt.getOptional("retweetedAt")

    /**
     * Public metadata whose fields X defines.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun scopes(): Optional<SearchTweet.Scopes> = scopes.getOptional("scopes")

    /**
     * The label X shows under a post whose reach it limits. It links to the page that explains it.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun softIntervention(): Optional<SoftIntervention> =
        softIntervention.getOptional("softIntervention")

    /**
     * Client application used to post the tweet
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun source(): Optional<String> = source.getOptional("source")

    /**
     * Game metadata attached to this post.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun sportsContext(): Optional<SearchTweet.SportsContext> =
        sportsContext.getOptional("sportsContext")

    /**
     * The Subscriber badge X shows on a reply. The reply's author subscribes to the creator who
     * started the conversation. Omitted on a post without the badge.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun subscriberBadge(): Optional<SearchTweet.SubscriberBadge> =
        subscriberBadge.getOptional("subscriberBadge")

    /**
     * Where `text` matches the search, on each row a search read. Offsets count code points of
     * `text`, as `displayTextRange` does. Empty when X marks nothing in the post. X marks matches
     * only in a post's first 280 characters.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun textHighlights(): Optional<List<SearchTweet.TextHighlight>> =
        textHighlights.getOptional("textHighlights")

    /**
     * Public visibility notice attached to an available tweet.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun tombstone(): Optional<SearchTweet.Tombstone> = tombstone.getOptional("tombstone")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun type(): Optional<String> = type.getOptional("type")

    /**
     * The author's ID when X withholds the author's profile.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun unavailableAuthorId(): Optional<String> =
        unavailableAuthorId.getOptional("unavailableAuthorId")

    /**
     * User IDs that left this conversation.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun unmentionedUserIds(): Optional<List<String>> =
        unmentionedUserIds.getOptional("unmentionedUserIds")

    /**
     * Search result permalink.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun url(): Optional<String> = url.getOptional("url")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
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
     * Returns the raw JSON value of [unknownCounts].
     *
     * Unlike [unknownCounts], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("unknownCounts")
    @ExcludeMissing
    fun _unknownCounts(): JsonField<List<UnknownCount>> = unknownCounts

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
     * Returns the raw JSON value of [authorUnavailable].
     *
     * Unlike [authorUnavailable], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("authorUnavailable")
    @ExcludeMissing
    fun _authorUnavailable(): JsonField<SearchTweet.AuthorUnavailable> = authorUnavailable

    /**
     * Returns the raw JSON value of [card].
     *
     * Unlike [card], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("card") @ExcludeMissing fun _card(): JsonField<Card> = card

    /**
     * Returns the raw JSON value of [cashtagAttachments].
     *
     * Unlike [cashtagAttachments], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("cashtagAttachments")
    @ExcludeMissing
    fun _cashtagAttachments(): JsonField<List<SearchTweet.CashtagAttachment>> = cashtagAttachments

    /**
     * Returns the raw JSON value of [communityId].
     *
     * Unlike [communityId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("communityId") @ExcludeMissing fun _communityId(): JsonField<String> = communityId

    /**
     * Returns the raw JSON value of [communityName].
     *
     * Unlike [communityName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("communityName")
    @ExcludeMissing
    fun _communityName(): JsonField<String> = communityName

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
     * Returns the raw JSON value of [conversationControl].
     *
     * Unlike [conversationControl], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("conversationControl")
    @ExcludeMissing
    fun _conversationControl(): JsonField<SearchTweet.ConversationControl> = conversationControl

    /**
     * Returns the raw JSON value of [conversationId].
     *
     * Unlike [conversationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("conversationId")
    @ExcludeMissing
    fun _conversationId(): JsonField<String> = conversationId

    /**
     * Returns the raw JSON value of [coordinates].
     *
     * Unlike [coordinates], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("coordinates")
    @ExcludeMissing
    fun _coordinates(): JsonField<SearchTweet.Coordinates> = coordinates

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
     * Returns the raw JSON value of [exclusiveContent].
     *
     * Unlike [exclusiveContent], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("exclusiveContent")
    @ExcludeMissing
    fun _exclusiveContent(): JsonField<SearchTweet.ExclusiveContent> = exclusiveContent

    /**
     * Returns the raw JSON value of [geo].
     *
     * Unlike [geo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("geo") @ExcludeMissing fun _geo(): JsonField<SearchTweet.Geo> = geo

    /**
     * Returns the raw JSON value of [grokShareAttachment].
     *
     * Unlike [grokShareAttachment], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("grokShareAttachment")
    @ExcludeMissing
    fun _grokShareAttachment(): JsonField<SearchTweet.GrokShareAttachment> = grokShareAttachment

    /**
     * Returns the raw JSON value of [grokTranslatedPost].
     *
     * Unlike [grokTranslatedPost], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("grokTranslatedPost")
    @ExcludeMissing
    fun _grokTranslatedPost(): JsonField<SearchTweet.GrokTranslatedPost> = grokTranslatedPost

    /**
     * Returns the raw JSON value of [hasCommunityNotes].
     *
     * Unlike [hasCommunityNotes], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("hasCommunityNotes")
    @ExcludeMissing
    fun _hasCommunityNotes(): JsonField<Boolean> = hasCommunityNotes

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
     * Returns the raw JSON value of [interstitial].
     *
     * Unlike [interstitial], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("interstitial")
    @ExcludeMissing
    fun _interstitial(): JsonField<SearchTweet.Interstitial> = interstitial

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
     * Returns the raw JSON value of [isPinned].
     *
     * Unlike [isPinned], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isPinned") @ExcludeMissing fun _isPinned(): JsonField<Boolean> = isPinned

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
     * Returns the raw JSON value of [isRetweet].
     *
     * Unlike [isRetweet], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isRetweet") @ExcludeMissing fun _isRetweet(): JsonField<Boolean> = isRetweet

    /**
     * Returns the raw JSON value of [isTranslatable].
     *
     * Unlike [isTranslatable], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isTranslatable")
    @ExcludeMissing
    fun _isTranslatable(): JsonField<Boolean> = isTranslatable

    /**
     * Returns the raw JSON value of [jetfuelAttachment].
     *
     * Unlike [jetfuelAttachment], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("jetfuelAttachment")
    @ExcludeMissing
    fun _jetfuelAttachment(): JsonField<SearchTweet.JetfuelAttachment> = jetfuelAttachment

    /**
     * Returns the raw JSON value of [lang].
     *
     * Unlike [lang], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("lang") @ExcludeMissing fun _lang(): JsonField<String> = lang

    /**
     * Returns the raw JSON value of [limitedActions].
     *
     * Unlike [limitedActions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("limitedActions")
    @ExcludeMissing
    fun _limitedActions(): JsonField<List<SearchTweet.LimitedAction>> = limitedActions

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
     * Returns the raw JSON value of [parentTweet].
     *
     * Unlike [parentTweet], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("parentTweet")
    @ExcludeMissing
    fun _parentTweet(): JsonField<EmbeddedTweet> = parentTweet

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
     * Returns the raw JSON value of [postCta].
     *
     * Unlike [postCta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("postCta")
    @ExcludeMissing
    fun _postCta(): JsonField<SearchTweet.PostCta> = postCta

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
     * Returns the raw JSON value of [quotedTweetId].
     *
     * Unlike [quotedTweetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("quotedTweetId")
    @ExcludeMissing
    fun _quotedTweetId(): JsonField<String> = quotedTweetId

    /**
     * Returns the raw JSON value of [quotedTweetPermalink].
     *
     * Unlike [quotedTweetPermalink], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("quotedTweetPermalink")
    @ExcludeMissing
    fun _quotedTweetPermalink(): JsonField<SearchTweet.QuotedTweetPermalink> = quotedTweetPermalink

    /**
     * Returns the raw JSON value of [quotedTweetUnavailable].
     *
     * Unlike [quotedTweetUnavailable], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("quotedTweetUnavailable")
    @ExcludeMissing
    fun _quotedTweetUnavailable(): JsonField<SearchTweet.QuotedTweetUnavailable> =
        quotedTweetUnavailable

    /**
     * Returns the raw JSON value of [reactionContext].
     *
     * Unlike [reactionContext], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reactionContext")
    @ExcludeMissing
    fun _reactionContext(): JsonField<SearchTweet.ReactionContext> = reactionContext

    /**
     * Returns the raw JSON value of [retweetedTweet].
     *
     * Unlike [retweetedTweet], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("retweeted_tweet")
    @ExcludeMissing
    fun _retweetedTweet(): JsonField<EmbeddedTweet> = retweetedTweet

    /**
     * Returns the raw JSON value of [retweetedAt].
     *
     * Unlike [retweetedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("retweetedAt")
    @ExcludeMissing
    fun _retweetedAt(): JsonField<OffsetDateTime> = retweetedAt

    /**
     * Returns the raw JSON value of [scopes].
     *
     * Unlike [scopes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("scopes") @ExcludeMissing fun _scopes(): JsonField<SearchTweet.Scopes> = scopes

    /**
     * Returns the raw JSON value of [softIntervention].
     *
     * Unlike [softIntervention], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("softIntervention")
    @ExcludeMissing
    fun _softIntervention(): JsonField<SoftIntervention> = softIntervention

    /**
     * Returns the raw JSON value of [source].
     *
     * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

    /**
     * Returns the raw JSON value of [sportsContext].
     *
     * Unlike [sportsContext], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sportsContext")
    @ExcludeMissing
    fun _sportsContext(): JsonField<SearchTweet.SportsContext> = sportsContext

    /**
     * Returns the raw JSON value of [subscriberBadge].
     *
     * Unlike [subscriberBadge], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("subscriberBadge")
    @ExcludeMissing
    fun _subscriberBadge(): JsonField<SearchTweet.SubscriberBadge> = subscriberBadge

    /**
     * Returns the raw JSON value of [textHighlights].
     *
     * Unlike [textHighlights], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("textHighlights")
    @ExcludeMissing
    fun _textHighlights(): JsonField<List<SearchTweet.TextHighlight>> = textHighlights

    /**
     * Returns the raw JSON value of [tombstone].
     *
     * Unlike [tombstone], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tombstone")
    @ExcludeMissing
    fun _tombstone(): JsonField<SearchTweet.Tombstone> = tombstone

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

    /**
     * Returns the raw JSON value of [unavailableAuthorId].
     *
     * Unlike [unavailableAuthorId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("unavailableAuthorId")
    @ExcludeMissing
    fun _unavailableAuthorId(): JsonField<String> = unavailableAuthorId

    /**
     * Returns the raw JSON value of [unmentionedUserIds].
     *
     * Unlike [unmentionedUserIds], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("unmentionedUserIds")
    @ExcludeMissing
    fun _unmentionedUserIds(): JsonField<List<String>> = unmentionedUserIds

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
         * Returns a mutable builder for constructing an instance of [EmbeddedTweet].
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

    /** A builder for [EmbeddedTweet]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var bookmarkCount: JsonField<Long>? = null
        private var unknownCounts: JsonField<MutableList<UnknownCount>>? = null
        private var likeCount: JsonField<Long>? = null
        private var quoteCount: JsonField<Long>? = null
        private var replyCount: JsonField<Long>? = null
        private var retweetCount: JsonField<Long>? = null
        private var text: JsonField<String>? = null
        private var viewCount: JsonField<Long>? = null
        private var article: JsonField<Article> = JsonMissing.of()
        private var author: JsonField<UserProfile> = JsonMissing.of()
        private var authorUnavailable: JsonField<SearchTweet.AuthorUnavailable> = JsonMissing.of()
        private var card: JsonField<Card> = JsonMissing.of()
        private var cashtagAttachments: JsonField<MutableList<SearchTweet.CashtagAttachment>>? =
            null
        private var communityId: JsonField<String> = JsonMissing.of()
        private var communityName: JsonField<String> = JsonMissing.of()
        private var communityNote: JsonField<CommunityNote> = JsonMissing.of()
        private var contentDisclosure: JsonField<ContentDisclosure> = JsonMissing.of()
        private var conversationControl: JsonField<SearchTweet.ConversationControl> =
            JsonMissing.of()
        private var conversationId: JsonField<String> = JsonMissing.of()
        private var coordinates: JsonField<SearchTweet.Coordinates> = JsonMissing.of()
        private var createdAt: JsonField<String> = JsonMissing.of()
        private var displayTextRange: JsonField<MutableList<Long>>? = null
        private var edit: JsonField<Edit> = JsonMissing.of()
        private var entities: JsonField<Entities> = JsonMissing.of()
        private var exclusiveContent: JsonField<SearchTweet.ExclusiveContent> = JsonMissing.of()
        private var geo: JsonField<SearchTweet.Geo> = JsonMissing.of()
        private var grokShareAttachment: JsonField<SearchTweet.GrokShareAttachment> =
            JsonMissing.of()
        private var grokTranslatedPost: JsonField<SearchTweet.GrokTranslatedPost> = JsonMissing.of()
        private var hasCommunityNotes: JsonField<Boolean> = JsonMissing.of()
        private var inReplyToId: JsonField<String> = JsonMissing.of()
        private var inReplyToUserId: JsonField<String> = JsonMissing.of()
        private var inReplyToUsername: JsonField<String> = JsonMissing.of()
        private var interstitial: JsonField<SearchTweet.Interstitial> = JsonMissing.of()
        private var isLimitedReply: JsonField<Boolean> = JsonMissing.of()
        private var isNoteTweet: JsonField<Boolean> = JsonMissing.of()
        private var isPinned: JsonField<Boolean> = JsonMissing.of()
        private var isQuoteStatus: JsonField<Boolean> = JsonMissing.of()
        private var isReply: JsonField<Boolean> = JsonMissing.of()
        private var isRetweet: JsonField<Boolean> = JsonMissing.of()
        private var isTranslatable: JsonField<Boolean> = JsonMissing.of()
        private var jetfuelAttachment: JsonField<SearchTweet.JetfuelAttachment> = JsonMissing.of()
        private var lang: JsonField<String> = JsonMissing.of()
        private var limitedActions: JsonField<MutableList<SearchTweet.LimitedAction>>? = null
        private var media: JsonField<MutableList<TweetMedia>>? = null
        private var noteTweet: JsonField<NoteTweet> = JsonMissing.of()
        private var parentTweet: JsonField<EmbeddedTweet> = JsonMissing.of()
        private var place: JsonField<Place> = JsonMissing.of()
        private var possiblySensitive: JsonField<Boolean> = JsonMissing.of()
        private var postCta: JsonField<SearchTweet.PostCta> = JsonMissing.of()
        private var previousCounts: JsonField<PreviousCounts> = JsonMissing.of()
        private var quotedTweet: JsonField<EmbeddedTweet> = JsonMissing.of()
        private var quotedTweetId: JsonField<String> = JsonMissing.of()
        private var quotedTweetPermalink: JsonField<SearchTweet.QuotedTweetPermalink> =
            JsonMissing.of()
        private var quotedTweetUnavailable: JsonField<SearchTweet.QuotedTweetUnavailable> =
            JsonMissing.of()
        private var reactionContext: JsonField<SearchTweet.ReactionContext> = JsonMissing.of()
        private var retweetedTweet: JsonField<EmbeddedTweet> = JsonMissing.of()
        private var retweetedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var scopes: JsonField<SearchTweet.Scopes> = JsonMissing.of()
        private var softIntervention: JsonField<SoftIntervention> = JsonMissing.of()
        private var source: JsonField<String> = JsonMissing.of()
        private var sportsContext: JsonField<SearchTweet.SportsContext> = JsonMissing.of()
        private var subscriberBadge: JsonField<SearchTweet.SubscriberBadge> = JsonMissing.of()
        private var textHighlights: JsonField<MutableList<SearchTweet.TextHighlight>>? = null
        private var tombstone: JsonField<SearchTweet.Tombstone> = JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var unavailableAuthorId: JsonField<String> = JsonMissing.of()
        private var unmentionedUserIds: JsonField<MutableList<String>>? = null
        private var url: JsonField<String> = JsonMissing.of()
        private var viewState: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(embeddedTweet: EmbeddedTweet) = apply {
            id = embeddedTweet.id
            bookmarkCount = embeddedTweet.bookmarkCount
            unknownCounts = embeddedTweet.unknownCounts.map { it.toMutableList() }
            likeCount = embeddedTweet.likeCount
            quoteCount = embeddedTweet.quoteCount
            replyCount = embeddedTweet.replyCount
            retweetCount = embeddedTweet.retweetCount
            text = embeddedTweet.text
            viewCount = embeddedTweet.viewCount
            article = embeddedTweet.article
            author = embeddedTweet.author
            authorUnavailable = embeddedTweet.authorUnavailable
            card = embeddedTweet.card
            cashtagAttachments = embeddedTweet.cashtagAttachments.map { it.toMutableList() }
            communityId = embeddedTweet.communityId
            communityName = embeddedTweet.communityName
            communityNote = embeddedTweet.communityNote
            contentDisclosure = embeddedTweet.contentDisclosure
            conversationControl = embeddedTweet.conversationControl
            conversationId = embeddedTweet.conversationId
            coordinates = embeddedTweet.coordinates
            createdAt = embeddedTweet.createdAt
            displayTextRange = embeddedTweet.displayTextRange.map { it.toMutableList() }
            edit = embeddedTweet.edit
            entities = embeddedTweet.entities
            exclusiveContent = embeddedTweet.exclusiveContent
            geo = embeddedTweet.geo
            grokShareAttachment = embeddedTweet.grokShareAttachment
            grokTranslatedPost = embeddedTweet.grokTranslatedPost
            hasCommunityNotes = embeddedTweet.hasCommunityNotes
            inReplyToId = embeddedTweet.inReplyToId
            inReplyToUserId = embeddedTweet.inReplyToUserId
            inReplyToUsername = embeddedTweet.inReplyToUsername
            interstitial = embeddedTweet.interstitial
            isLimitedReply = embeddedTweet.isLimitedReply
            isNoteTweet = embeddedTweet.isNoteTweet
            isPinned = embeddedTweet.isPinned
            isQuoteStatus = embeddedTweet.isQuoteStatus
            isReply = embeddedTweet.isReply
            isRetweet = embeddedTweet.isRetweet
            isTranslatable = embeddedTweet.isTranslatable
            jetfuelAttachment = embeddedTweet.jetfuelAttachment
            lang = embeddedTweet.lang
            limitedActions = embeddedTweet.limitedActions.map { it.toMutableList() }
            media = embeddedTweet.media.map { it.toMutableList() }
            noteTweet = embeddedTweet.noteTweet
            parentTweet = embeddedTweet.parentTweet
            place = embeddedTweet.place
            possiblySensitive = embeddedTweet.possiblySensitive
            postCta = embeddedTweet.postCta
            previousCounts = embeddedTweet.previousCounts
            quotedTweet = embeddedTweet.quotedTweet
            quotedTweetId = embeddedTweet.quotedTweetId
            quotedTweetPermalink = embeddedTweet.quotedTweetPermalink
            quotedTweetUnavailable = embeddedTweet.quotedTweetUnavailable
            reactionContext = embeddedTweet.reactionContext
            retweetedTweet = embeddedTweet.retweetedTweet
            retweetedAt = embeddedTweet.retweetedAt
            scopes = embeddedTweet.scopes
            softIntervention = embeddedTweet.softIntervention
            source = embeddedTweet.source
            sportsContext = embeddedTweet.sportsContext
            subscriberBadge = embeddedTweet.subscriberBadge
            textHighlights = embeddedTweet.textHighlights.map { it.toMutableList() }
            tombstone = embeddedTweet.tombstone
            type = embeddedTweet.type
            unavailableAuthorId = embeddedTweet.unavailableAuthorId
            unmentionedUserIds = embeddedTweet.unmentionedUserIds.map { it.toMutableList() }
            url = embeddedTweet.url
            viewState = embeddedTweet.viewState
            additionalProperties = embeddedTweet.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun bookmarkCount(bookmarkCount: Long) = bookmarkCount(JsonField.of(bookmarkCount))

        /** Sets [Builder.bookmarkCount] to an arbitrary JSON value. */
        fun bookmarkCount(bookmarkCount: JsonField<Long>) = apply {
            this.bookmarkCount = bookmarkCount
        }

        /** X did not send these counts, so each 0 means unknown. */
        fun unknownCounts(unknownCounts: List<UnknownCount>) =
            unknownCounts(JsonField.of(unknownCounts))

        /** Sets [Builder.unknownCounts] to an arbitrary JSON value. */
        fun unknownCounts(unknownCounts: JsonField<List<UnknownCount>>) = apply {
            this.unknownCounts = unknownCounts.map { it.toMutableList() }
        }

        /**
         * Adds a single [UnknownCount] to [unknownCounts].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUnknownCount(unknownCount: UnknownCount) = apply {
            unknownCounts =
                (unknownCounts ?: JsonField.of(mutableListOf())).also {
                    checkKnown("unknownCounts", it).add(unknownCount)
                }
        }

        fun likeCount(likeCount: Long) = likeCount(JsonField.of(likeCount))

        /** Sets [Builder.likeCount] to an arbitrary JSON value. */
        fun likeCount(likeCount: JsonField<Long>) = apply { this.likeCount = likeCount }

        fun quoteCount(quoteCount: Long) = quoteCount(JsonField.of(quoteCount))

        /** Sets [Builder.quoteCount] to an arbitrary JSON value. */
        fun quoteCount(quoteCount: JsonField<Long>) = apply { this.quoteCount = quoteCount }

        fun replyCount(replyCount: Long) = replyCount(JsonField.of(replyCount))

        /** Sets [Builder.replyCount] to an arbitrary JSON value. */
        fun replyCount(replyCount: JsonField<Long>) = apply { this.replyCount = replyCount }

        fun retweetCount(retweetCount: Long) = retweetCount(JsonField.of(retweetCount))

        /** Sets [Builder.retweetCount] to an arbitrary JSON value. */
        fun retweetCount(retweetCount: JsonField<Long>) = apply { this.retweetCount = retweetCount }

        fun text(text: String) = text(JsonField.of(text))

        /** Sets [Builder.text] to an arbitrary JSON value. */
        fun text(text: JsonField<String>) = apply { this.text = text }

        fun viewCount(viewCount: Long) = viewCount(JsonField.of(viewCount))

        /** Sets [Builder.viewCount] to an arbitrary JSON value. */
        fun viewCount(viewCount: JsonField<Long>) = apply { this.viewCount = viewCount }

        /** Article metadata attached to a tweet. */
        fun article(article: Article) = article(JsonField.of(article))

        /** Sets [Builder.article] to an arbitrary JSON value. */
        fun article(article: JsonField<Article>) = apply { this.article = article }

        /** X user profile with bio, follower counts, and verification status. */
        fun author(author: UserProfile) = author(JsonField.of(author))

        /** Sets [Builder.author] to an arbitrary JSON value. */
        fun author(author: JsonField<UserProfile>) = apply { this.author = author }

        /**
         * Why the tweet has no author. X serves a suspended or deleted account as an unavailable
         * user with a reason such as Suspended or NotFound. Omitted when the author is available.
         */
        fun authorUnavailable(authorUnavailable: SearchTweet.AuthorUnavailable) =
            authorUnavailable(JsonField.of(authorUnavailable))

        /** Sets [Builder.authorUnavailable] to an arbitrary JSON value. */
        fun authorUnavailable(authorUnavailable: JsonField<SearchTweet.AuthorUnavailable>) = apply {
            this.authorUnavailable = authorUnavailable
        }

        /** Public card metadata attached to a tweet. */
        fun card(card: Card) = card(JsonField.of(card))

        /** Sets [Builder.card] to an arbitrary JSON value. */
        fun card(card: JsonField<Card>) = apply { this.card = card }

        /**
         * Price charts the author attached under the post, 1 per cashtag. Absent when the post has
         * none. X may send a cashtag without a chart window.
         */
        fun cashtagAttachments(cashtagAttachments: List<SearchTweet.CashtagAttachment>) =
            cashtagAttachments(JsonField.of(cashtagAttachments))

        /** Sets [Builder.cashtagAttachments] to an arbitrary JSON value. */
        fun cashtagAttachments(cashtagAttachments: JsonField<List<SearchTweet.CashtagAttachment>>) =
            apply {
                this.cashtagAttachments = cashtagAttachments.map { it.toMutableList() }
            }

        /**
         * Adds a single [SearchTweet.CashtagAttachment] to [cashtagAttachments].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addCashtagAttachment(cashtagAttachment: SearchTweet.CashtagAttachment) = apply {
            cashtagAttachments =
                (cashtagAttachments ?: JsonField.of(mutableListOf())).also {
                    checkKnown("cashtagAttachments", it).add(cashtagAttachment)
                }
        }

        /** Community ID. */
        fun communityId(communityId: String) = communityId(JsonField.of(communityId))

        /** Sets [Builder.communityId] to an arbitrary JSON value. */
        fun communityId(communityId: JsonField<String>) = apply { this.communityId = communityId }

        /** Community name. Present when X sends it with the post. */
        fun communityName(communityName: String) = communityName(JsonField.of(communityName))

        /** Sets [Builder.communityName] to an arbitrary JSON value. */
        fun communityName(communityName: JsonField<String>) = apply {
            this.communityName = communityName
        }

        /** Community Note presentation metadata returned by X. */
        fun communityNote(communityNote: CommunityNote) = communityNote(JsonField.of(communityNote))

        /** Sets [Builder.communityNote] to an arbitrary JSON value. */
        fun communityNote(communityNote: JsonField<CommunityNote>) = apply {
            this.communityNote = communityNote
        }

        /**
         * Content disclosure metadata shown by X when a tweet is labeled as paid partnership
         * content or AI-generated media.
         */
        fun contentDisclosure(contentDisclosure: ContentDisclosure) =
            contentDisclosure(JsonField.of(contentDisclosure))

        /** Sets [Builder.contentDisclosure] to an arbitrary JSON value. */
        fun contentDisclosure(contentDisclosure: JsonField<ContentDisclosure>) = apply {
            this.contentDisclosure = contentDisclosure
        }

        /** Reply policy & conversation owner. */
        fun conversationControl(conversationControl: SearchTweet.ConversationControl) =
            conversationControl(JsonField.of(conversationControl))

        /** Sets [Builder.conversationControl] to an arbitrary JSON value. */
        fun conversationControl(conversationControl: JsonField<SearchTweet.ConversationControl>) =
            apply {
                this.conversationControl = conversationControl
            }

        /** Root tweet ID for the conversation */
        fun conversationId(conversationId: String) = conversationId(JsonField.of(conversationId))

        /** Sets [Builder.conversationId] to an arbitrary JSON value. */
        fun conversationId(conversationId: JsonField<String>) = apply {
            this.conversationId = conversationId
        }

        /** Author-published point, with longitude before latitude. */
        fun coordinates(coordinates: SearchTweet.Coordinates) =
            coordinates(JsonField.of(coordinates))

        /** Sets [Builder.coordinates] to an arbitrary JSON value. */
        fun coordinates(coordinates: JsonField<SearchTweet.Coordinates>) = apply {
            this.coordinates = coordinates
        }

        fun createdAt(createdAt: String) = createdAt(JsonField.of(createdAt))

        /** Sets [Builder.createdAt] to an arbitrary JSON value. */
        fun createdAt(createdAt: JsonField<String>) = apply { this.createdAt = createdAt }

        /** Rendered text's start and end offsets. */
        fun displayTextRange(displayTextRange: List<Long>) =
            displayTextRange(JsonField.of(displayTextRange))

        /** Sets [Builder.displayTextRange] to an arbitrary JSON value. */
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

        /** Sets [Builder.edit] to an arbitrary JSON value. */
        fun edit(edit: JsonField<Edit>) = apply { this.edit = edit }

        /** Parsed search-result entities including URLs, mentions, hashtags, and media markers */
        fun entities(entities: Entities) = entities(JsonField.of(entities))

        /** Sets [Builder.entities] to an arbitrary JSON value. */
        fun entities(entities: JsonField<Entities>) = apply { this.entities = entities }

        /**
         * Marks a subscriber-only post with the creator whose subscription unlocks it.
         * Non-subscribers get the preview text & the subscribe link. Omitted on public posts.
         */
        fun exclusiveContent(exclusiveContent: SearchTweet.ExclusiveContent) =
            exclusiveContent(JsonField.of(exclusiveContent))

        /** Sets [Builder.exclusiveContent] to an arbitrary JSON value. */
        fun exclusiveContent(exclusiveContent: JsonField<SearchTweet.ExclusiveContent>) = apply {
            this.exclusiveContent = exclusiveContent
        }

        /** Author-published point, with latitude before longitude. */
        fun geo(geo: SearchTweet.Geo) = geo(JsonField.of(geo))

        /** Sets [Builder.geo] to an arbitrary JSON value. */
        fun geo(geo: JsonField<SearchTweet.Geo>) = apply { this.geo = geo }

        /** Public metadata whose fields X defines. */
        fun grokShareAttachment(grokShareAttachment: SearchTweet.GrokShareAttachment) =
            grokShareAttachment(JsonField.of(grokShareAttachment))

        /** Sets [Builder.grokShareAttachment] to an arbitrary JSON value. */
        fun grokShareAttachment(grokShareAttachment: JsonField<SearchTweet.GrokShareAttachment>) =
            apply {
                this.grokShareAttachment = grokShareAttachment
            }

        /** Grok's translation of the post, as X shows it. */
        fun grokTranslatedPost(grokTranslatedPost: SearchTweet.GrokTranslatedPost) =
            grokTranslatedPost(JsonField.of(grokTranslatedPost))

        /** Sets [Builder.grokTranslatedPost] to an arbitrary JSON value. */
        fun grokTranslatedPost(grokTranslatedPost: JsonField<SearchTweet.GrokTranslatedPost>) =
            apply {
                this.grokTranslatedPost = grokTranslatedPost
            }

        /** Whether X holds Community Notes on the post, shown or not. */
        fun hasCommunityNotes(hasCommunityNotes: Boolean) =
            hasCommunityNotes(JsonField.of(hasCommunityNotes))

        /** Sets [Builder.hasCommunityNotes] to an arbitrary JSON value. */
        fun hasCommunityNotes(hasCommunityNotes: JsonField<Boolean>) = apply {
            this.hasCommunityNotes = hasCommunityNotes
        }

        /** ID of the tweet this result replies to. */
        fun inReplyToId(inReplyToId: String) = inReplyToId(JsonField.of(inReplyToId))

        /** Sets [Builder.inReplyToId] to an arbitrary JSON value. */
        fun inReplyToId(inReplyToId: JsonField<String>) = apply { this.inReplyToId = inReplyToId }

        /** ID of the user this result replies to. */
        fun inReplyToUserId(inReplyToUserId: String) =
            inReplyToUserId(JsonField.of(inReplyToUserId))

        /** Sets [Builder.inReplyToUserId] to an arbitrary JSON value. */
        fun inReplyToUserId(inReplyToUserId: JsonField<String>) = apply {
            this.inReplyToUserId = inReplyToUserId
        }

        /** Username this result replies to. */
        fun inReplyToUsername(inReplyToUsername: String) =
            inReplyToUsername(JsonField.of(inReplyToUsername))

        /** Sets [Builder.inReplyToUsername] to an arbitrary JSON value. */
        fun inReplyToUsername(inReplyToUsername: JsonField<String>) = apply {
            this.inReplyToUsername = inReplyToUsername
        }

        /**
         * The notice x.com covers the post with until the reader views it, such as X's public
         * interest notice on a post that broke its rules but stays up.
         */
        fun interstitial(interstitial: SearchTweet.Interstitial) =
            interstitial(JsonField.of(interstitial))

        /** Sets [Builder.interstitial] to an arbitrary JSON value. */
        fun interstitial(interstitial: JsonField<SearchTweet.Interstitial>) = apply {
            this.interstitial = interstitial
        }

        /** Whether the tweet has limited reply permissions */
        fun isLimitedReply(isLimitedReply: Boolean) = isLimitedReply(JsonField.of(isLimitedReply))

        /** Sets [Builder.isLimitedReply] to an arbitrary JSON value. */
        fun isLimitedReply(isLimitedReply: JsonField<Boolean>) = apply {
            this.isLimitedReply = isLimitedReply
        }

        /** True for Note Tweets (long-form content, up to 25,000 characters) */
        fun isNoteTweet(isNoteTweet: Boolean) = isNoteTweet(JsonField.of(isNoteTweet))

        /** Sets [Builder.isNoteTweet] to an arbitrary JSON value. */
        fun isNoteTweet(isNoteTweet: JsonField<Boolean>) = apply { this.isNoteTweet = isNoteTweet }

        fun isPinned(isPinned: Boolean) = isPinned(JsonField.of(isPinned))

        /** Sets [Builder.isPinned] to an arbitrary JSON value. */
        fun isPinned(isPinned: JsonField<Boolean>) = apply { this.isPinned = isPinned }

        /** True when this tweet quotes another tweet */
        fun isQuoteStatus(isQuoteStatus: Boolean) = isQuoteStatus(JsonField.of(isQuoteStatus))

        /** Sets [Builder.isQuoteStatus] to an arbitrary JSON value. */
        fun isQuoteStatus(isQuoteStatus: JsonField<Boolean>) = apply {
            this.isQuoteStatus = isQuoteStatus
        }

        /** True when this tweet is a reply */
        fun isReply(isReply: Boolean) = isReply(JsonField.of(isReply))

        /** Sets [Builder.isReply] to an arbitrary JSON value. */
        fun isReply(isReply: JsonField<Boolean>) = apply { this.isReply = isReply }

        fun isRetweet(isRetweet: Boolean) = isRetweet(JsonField.of(isRetweet))

        /** Sets [Builder.isRetweet] to an arbitrary JSON value. */
        fun isRetweet(isRetweet: JsonField<Boolean>) = apply { this.isRetweet = isRetweet }

        fun isTranslatable(isTranslatable: Boolean) = isTranslatable(JsonField.of(isTranslatable))

        /** Sets [Builder.isTranslatable] to an arbitrary JSON value. */
        fun isTranslatable(isTranslatable: JsonField<Boolean>) = apply {
            this.isTranslatable = isTranslatable
        }

        /** Public metadata whose fields X defines. */
        fun jetfuelAttachment(jetfuelAttachment: SearchTweet.JetfuelAttachment) =
            jetfuelAttachment(JsonField.of(jetfuelAttachment))

        /** Sets [Builder.jetfuelAttachment] to an arbitrary JSON value. */
        fun jetfuelAttachment(jetfuelAttachment: JsonField<SearchTweet.JetfuelAttachment>) = apply {
            this.jetfuelAttachment = jetfuelAttachment
        }

        /** Search result language code. */
        fun lang(lang: String) = lang(JsonField.of(lang))

        /** Sets [Builder.lang] to an arbitrary JSON value. */
        fun lang(lang: JsonField<String>) = apply { this.lang = lang }

        /** Public restrictions & prompts. */
        fun limitedActions(limitedActions: List<SearchTweet.LimitedAction>) =
            limitedActions(JsonField.of(limitedActions))

        /** Sets [Builder.limitedActions] to an arbitrary JSON value. */
        fun limitedActions(limitedActions: JsonField<List<SearchTweet.LimitedAction>>) = apply {
            this.limitedActions = limitedActions.map { it.toMutableList() }
        }

        /**
         * Adds a single [SearchTweet.LimitedAction] to [limitedActions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addLimitedAction(limitedAction: SearchTweet.LimitedAction) = apply {
            limitedActions =
                (limitedActions ?: JsonField.of(mutableListOf())).also {
                    checkKnown("limitedActions", it).add(limitedAction)
                }
        }

        /** Media, omitted when unavailable. */
        fun media(media: List<TweetMedia>) = media(JsonField.of(media))

        /** Sets [Builder.media] to an arbitrary JSON value. */
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

        /** Sets [Builder.noteTweet] to an arbitrary JSON value. */
        fun noteTweet(noteTweet: JsonField<NoteTweet>) = apply { this.noteTweet = noteTweet }

        /** The post this one replies to, with the same fields. */
        fun parentTweet(parentTweet: EmbeddedTweet) = parentTweet(JsonField.of(parentTweet))

        fun parentTweet(parentTweet: JsonField<EmbeddedTweet>) = apply {
            this.parentTweet = parentTweet
        }

        /** Public place metadata attached to a tweet. */
        fun place(place: Place) = place(JsonField.of(place))

        /** Sets [Builder.place] to an arbitrary JSON value. */
        fun place(place: JsonField<Place>) = apply { this.place = place }

        fun possiblySensitive(possiblySensitive: Boolean) =
            possiblySensitive(JsonField.of(possiblySensitive))

        /** Sets [Builder.possiblySensitive] to an arbitrary JSON value. */
        fun possiblySensitive(possiblySensitive: JsonField<Boolean>) = apply {
            this.possiblySensitive = possiblySensitive
        }

        /** Public metadata whose fields X defines. */
        fun postCta(postCta: SearchTweet.PostCta) = postCta(JsonField.of(postCta))

        /** Sets [Builder.postCta] to an arbitrary JSON value. */
        fun postCta(postCta: JsonField<SearchTweet.PostCta>) = apply { this.postCta = postCta }

        /** Engagement counts retained from a prior tweet edit. */
        fun previousCounts(previousCounts: PreviousCounts) =
            previousCounts(JsonField.of(previousCounts))

        /** Sets [Builder.previousCounts] to an arbitrary JSON value. */
        fun previousCounts(previousCounts: JsonField<PreviousCounts>) = apply {
            this.previousCounts = previousCounts
        }

        /** The post this one quotes, with the same fields. */
        fun quotedTweet(quotedTweet: EmbeddedTweet) = quotedTweet(JsonField.of(quotedTweet))

        /** Sets [Builder.quotedTweet] to an arbitrary JSON value. */
        fun quotedTweet(quotedTweet: JsonField<EmbeddedTweet>) = apply {
            this.quotedTweet = quotedTweet
        }

        fun quotedTweetId(quotedTweetId: String) = quotedTweetId(JsonField.of(quotedTweetId))

        /** Sets [Builder.quotedTweetId] to an arbitrary JSON value. */
        fun quotedTweetId(quotedTweetId: JsonField<String>) = apply {
            this.quotedTweetId = quotedTweetId
        }

        /** The quoted post's link, kept when X withholds that post. */
        fun quotedTweetPermalink(quotedTweetPermalink: SearchTweet.QuotedTweetPermalink) =
            quotedTweetPermalink(JsonField.of(quotedTweetPermalink))

        /** Sets [Builder.quotedTweetPermalink] to an arbitrary JSON value. */
        fun quotedTweetPermalink(
            quotedTweetPermalink: JsonField<SearchTweet.QuotedTweetPermalink>
        ) = apply { this.quotedTweetPermalink = quotedTweetPermalink }

        /**
         * Why X shows no quoted post. Omitted when X names no reason, as its legacy answers never
         * do.
         */
        fun quotedTweetUnavailable(quotedTweetUnavailable: SearchTweet.QuotedTweetUnavailable) =
            quotedTweetUnavailable(JsonField.of(quotedTweetUnavailable))

        /** Sets [Builder.quotedTweetUnavailable] to an arbitrary JSON value. */
        fun quotedTweetUnavailable(
            quotedTweetUnavailable: JsonField<SearchTweet.QuotedTweetUnavailable>
        ) = apply { this.quotedTweetUnavailable = quotedTweetUnavailable }

        /** Public post & user this reaction references. */
        fun reactionContext(reactionContext: SearchTweet.ReactionContext) =
            reactionContext(JsonField.of(reactionContext))

        /** Sets [Builder.reactionContext] to an arbitrary JSON value. */
        fun reactionContext(reactionContext: JsonField<SearchTweet.ReactionContext>) = apply {
            this.reactionContext = reactionContext
        }

        /** The post this one reposts, with the same fields. */
        fun retweetedTweet(retweetedTweet: EmbeddedTweet) =
            retweetedTweet(JsonField.of(retweetedTweet))

        /** Sets [Builder.retweetedTweet] to an arbitrary JSON value. */
        fun retweetedTweet(retweetedTweet: JsonField<EmbeddedTweet>) = apply {
            this.retweetedTweet = retweetedTweet
        }

        /** Repost event time in UTC. Null when unavailable. Omitted for other posts. */
        fun retweetedAt(retweetedAt: OffsetDateTime?) =
            retweetedAt(JsonField.ofNullable(retweetedAt))

        /** Alias for calling [Builder.retweetedAt] with `retweetedAt.orElse(null)`. */
        fun retweetedAt(retweetedAt: Optional<OffsetDateTime>) =
            retweetedAt(retweetedAt.getOrNull())

        /** Sets [Builder.retweetedAt] to an arbitrary JSON value. */
        fun retweetedAt(retweetedAt: JsonField<OffsetDateTime>) = apply {
            this.retweetedAt = retweetedAt
        }

        /** Public metadata whose fields X defines. */
        fun scopes(scopes: SearchTweet.Scopes) = scopes(JsonField.of(scopes))

        /** Sets [Builder.scopes] to an arbitrary JSON value. */
        fun scopes(scopes: JsonField<SearchTweet.Scopes>) = apply { this.scopes = scopes }

        /**
         * The label X shows under a post whose reach it limits. It links to the page that explains
         * it.
         */
        fun softIntervention(softIntervention: SoftIntervention) =
            softIntervention(JsonField.of(softIntervention))

        /** Sets [Builder.softIntervention] to an arbitrary JSON value. */
        fun softIntervention(softIntervention: JsonField<SoftIntervention>) = apply {
            this.softIntervention = softIntervention
        }

        /** Client application used to post the tweet */
        fun source(source: String) = source(JsonField.of(source))

        /** Sets [Builder.source] to an arbitrary JSON value. */
        fun source(source: JsonField<String>) = apply { this.source = source }

        /** Game metadata attached to this post. */
        fun sportsContext(sportsContext: SearchTweet.SportsContext) =
            sportsContext(JsonField.of(sportsContext))

        /** Sets [Builder.sportsContext] to an arbitrary JSON value. */
        fun sportsContext(sportsContext: JsonField<SearchTweet.SportsContext>) = apply {
            this.sportsContext = sportsContext
        }

        /**
         * The Subscriber badge X shows on a reply. The reply's author subscribes to the creator who
         * started the conversation. Omitted on a post without the badge.
         */
        fun subscriberBadge(subscriberBadge: SearchTweet.SubscriberBadge) =
            subscriberBadge(JsonField.of(subscriberBadge))

        /** Sets [Builder.subscriberBadge] to an arbitrary JSON value. */
        fun subscriberBadge(subscriberBadge: JsonField<SearchTweet.SubscriberBadge>) = apply {
            this.subscriberBadge = subscriberBadge
        }

        /**
         * Where `text` matches the search, on each row a search read. Offsets count code points of
         * `text`, as `displayTextRange` does. Empty when X marks nothing in the post. X marks
         * matches only in a post's first 280 characters.
         */
        fun textHighlights(textHighlights: List<SearchTweet.TextHighlight>) =
            textHighlights(JsonField.of(textHighlights))

        /** Sets [Builder.textHighlights] to an arbitrary JSON value. */
        fun textHighlights(textHighlights: JsonField<List<SearchTweet.TextHighlight>>) = apply {
            this.textHighlights = textHighlights.map { it.toMutableList() }
        }

        /**
         * Adds a single [SearchTweet.TextHighlight] to [textHighlights].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTextHighlight(textHighlight: SearchTweet.TextHighlight) = apply {
            textHighlights =
                (textHighlights ?: JsonField.of(mutableListOf())).also {
                    checkKnown("textHighlights", it).add(textHighlight)
                }
        }

        /** Public visibility notice attached to an available tweet. */
        fun tombstone(tombstone: SearchTweet.Tombstone) = tombstone(JsonField.of(tombstone))

        /** Sets [Builder.tombstone] to an arbitrary JSON value. */
        fun tombstone(tombstone: JsonField<SearchTweet.Tombstone>) = apply {
            this.tombstone = tombstone
        }

        fun type(type: String) = type(JsonField.of(type))

        /** Sets [Builder.type] to an arbitrary JSON value. */
        fun type(type: JsonField<String>) = apply { this.type = type }

        /** The author's ID when X withholds the author's profile. */
        fun unavailableAuthorId(unavailableAuthorId: String) =
            unavailableAuthorId(JsonField.of(unavailableAuthorId))

        /** Sets [Builder.unavailableAuthorId] to an arbitrary JSON value. */
        fun unavailableAuthorId(unavailableAuthorId: JsonField<String>) = apply {
            this.unavailableAuthorId = unavailableAuthorId
        }

        /** User IDs that left this conversation. */
        fun unmentionedUserIds(unmentionedUserIds: List<String>) =
            unmentionedUserIds(JsonField.of(unmentionedUserIds))

        /** Sets [Builder.unmentionedUserIds] to an arbitrary JSON value. */
        fun unmentionedUserIds(unmentionedUserIds: JsonField<List<String>>) = apply {
            this.unmentionedUserIds = unmentionedUserIds.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [unmentionedUserIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUnmentionedUserId(unmentionedUserId: String) = apply {
            unmentionedUserIds =
                (unmentionedUserIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("unmentionedUserIds", it).add(unmentionedUserId)
                }
        }

        /** Search result permalink. */
        fun url(url: String) = url(JsonField.of(url))

        /** Sets [Builder.url] to an arbitrary JSON value. */
        fun url(url: JsonField<String>) = apply { this.url = url }

        fun viewState(viewState: String) = viewState(JsonField.of(viewState))

        /** Sets [Builder.viewState] to an arbitrary JSON value. */
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
         * Returns an immutable instance of [EmbeddedTweet].
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
        fun build(): EmbeddedTweet =
            EmbeddedTweet(
                checkRequired("id", id),
                checkRequired("bookmarkCount", bookmarkCount),
                (unknownCounts ?: JsonMissing.of()).map { it.toImmutable() },
                checkRequired("likeCount", likeCount),
                checkRequired("quoteCount", quoteCount),
                checkRequired("replyCount", replyCount),
                checkRequired("retweetCount", retweetCount),
                checkRequired("text", text),
                checkRequired("viewCount", viewCount),
                article,
                author,
                authorUnavailable,
                card,
                (cashtagAttachments ?: JsonMissing.of()).map { it.toImmutable() },
                communityId,
                communityName,
                communityNote,
                contentDisclosure,
                conversationControl,
                conversationId,
                coordinates,
                createdAt,
                (displayTextRange ?: JsonMissing.of()).map { it.toImmutable() },
                edit,
                entities,
                exclusiveContent,
                geo,
                grokShareAttachment,
                grokTranslatedPost,
                hasCommunityNotes,
                inReplyToId,
                inReplyToUserId,
                inReplyToUsername,
                interstitial,
                isLimitedReply,
                isNoteTweet,
                isPinned,
                isQuoteStatus,
                isReply,
                isRetweet,
                isTranslatable,
                jetfuelAttachment,
                lang,
                (limitedActions ?: JsonMissing.of()).map { it.toImmutable() },
                (media ?: JsonMissing.of()).map { it.toImmutable() },
                noteTweet,
                parentTweet,
                place,
                possiblySensitive,
                postCta,
                previousCounts,
                quotedTweet,
                quotedTweetId,
                quotedTweetPermalink,
                quotedTweetUnavailable,
                reactionContext,
                retweetedTweet,
                retweetedAt,
                scopes,
                softIntervention,
                source,
                sportsContext,
                subscriberBadge,
                (textHighlights ?: JsonMissing.of()).map { it.toImmutable() },
                tombstone,
                type,
                unavailableAuthorId,
                (unmentionedUserIds ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): EmbeddedTweet = apply {
        if (validated) {
            return@apply
        }

        id()
        bookmarkCount()
        unknownCounts().ifPresent { it.forEach { it.validate() } }
        likeCount()
        quoteCount()
        replyCount()
        retweetCount()
        text()
        viewCount()
        article().ifPresent { it.validate() }
        author().ifPresent { it.validate() }
        authorUnavailable().ifPresent { it.validate() }
        card().ifPresent { it.validate() }
        cashtagAttachments().ifPresent { it.forEach { it.validate() } }
        communityId()
        communityName()
        communityNote().ifPresent { it.validate() }
        contentDisclosure().ifPresent { it.validate() }
        conversationControl().ifPresent { it.validate() }
        conversationId()
        coordinates().ifPresent { it.validate() }
        createdAt()
        displayTextRange()
        edit().ifPresent { it.validate() }
        entities().ifPresent { it.validate() }
        exclusiveContent().ifPresent { it.validate() }
        geo().ifPresent { it.validate() }
        grokShareAttachment().ifPresent { it.validate() }
        grokTranslatedPost().ifPresent { it.validate() }
        hasCommunityNotes()
        inReplyToId()
        inReplyToUserId()
        inReplyToUsername()
        interstitial().ifPresent { it.validate() }
        isLimitedReply()
        isNoteTweet()
        isPinned()
        isQuoteStatus()
        isReply()
        isRetweet()
        isTranslatable()
        jetfuelAttachment().ifPresent { it.validate() }
        lang()
        limitedActions().ifPresent { it.forEach { it.validate() } }
        media().ifPresent { it.forEach { it.validate() } }
        noteTweet().ifPresent { it.validate() }
        parentTweet().ifPresent { it.validate() }
        place().ifPresent { it.validate() }
        possiblySensitive()
        postCta().ifPresent { it.validate() }
        previousCounts().ifPresent { it.validate() }
        quotedTweet().ifPresent { it.validate() }
        quotedTweetId()
        quotedTweetPermalink().ifPresent { it.validate() }
        quotedTweetUnavailable().ifPresent { it.validate() }
        reactionContext().ifPresent { it.validate() }
        retweetedTweet().ifPresent { it.validate() }
        retweetedAt()
        scopes().ifPresent { it.validate() }
        softIntervention().ifPresent { it.validate() }
        source()
        sportsContext().ifPresent { it.validate() }
        subscriberBadge().ifPresent { it.validate() }
        textHighlights().ifPresent { it.forEach { it.validate() } }
        tombstone().ifPresent { it.validate() }
        type()
        unavailableAuthorId()
        unmentionedUserIds()
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

    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (bookmarkCount.asKnown().isPresent) 1 else 0) +
            (unknownCounts.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (likeCount.asKnown().isPresent) 1 else 0) +
            (if (quoteCount.asKnown().isPresent) 1 else 0) +
            (if (replyCount.asKnown().isPresent) 1 else 0) +
            (if (retweetCount.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            (if (viewCount.asKnown().isPresent) 1 else 0) +
            (article.asKnown().getOrNull()?.validity() ?: 0) +
            (author.asKnown().getOrNull()?.validity() ?: 0) +
            (authorUnavailable.asKnown().getOrNull()?.validity() ?: 0) +
            (card.asKnown().getOrNull()?.validity() ?: 0) +
            (cashtagAttachments.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (communityId.asKnown().isPresent) 1 else 0) +
            (if (communityName.asKnown().isPresent) 1 else 0) +
            (communityNote.asKnown().getOrNull()?.validity() ?: 0) +
            (contentDisclosure.asKnown().getOrNull()?.validity() ?: 0) +
            (conversationControl.asKnown().getOrNull()?.validity() ?: 0) +
            (if (conversationId.asKnown().isPresent) 1 else 0) +
            (coordinates.asKnown().getOrNull()?.validity() ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (displayTextRange.asKnown().getOrNull()?.size ?: 0) +
            (edit.asKnown().getOrNull()?.validity() ?: 0) +
            (entities.asKnown().getOrNull()?.validity() ?: 0) +
            (exclusiveContent.asKnown().getOrNull()?.validity() ?: 0) +
            (geo.asKnown().getOrNull()?.validity() ?: 0) +
            (grokShareAttachment.asKnown().getOrNull()?.validity() ?: 0) +
            (grokTranslatedPost.asKnown().getOrNull()?.validity() ?: 0) +
            (if (hasCommunityNotes.asKnown().isPresent) 1 else 0) +
            (if (inReplyToId.asKnown().isPresent) 1 else 0) +
            (if (inReplyToUserId.asKnown().isPresent) 1 else 0) +
            (if (inReplyToUsername.asKnown().isPresent) 1 else 0) +
            (interstitial.asKnown().getOrNull()?.validity() ?: 0) +
            (if (isLimitedReply.asKnown().isPresent) 1 else 0) +
            (if (isNoteTweet.asKnown().isPresent) 1 else 0) +
            (if (isPinned.asKnown().isPresent) 1 else 0) +
            (if (isQuoteStatus.asKnown().isPresent) 1 else 0) +
            (if (isReply.asKnown().isPresent) 1 else 0) +
            (if (isRetweet.asKnown().isPresent) 1 else 0) +
            (if (isTranslatable.asKnown().isPresent) 1 else 0) +
            (jetfuelAttachment.asKnown().getOrNull()?.validity() ?: 0) +
            (if (lang.asKnown().isPresent) 1 else 0) +
            (limitedActions.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (media.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (noteTweet.asKnown().getOrNull()?.validity() ?: 0) +
            (parentTweet.asKnown().getOrNull()?.validity() ?: 0) +
            (place.asKnown().getOrNull()?.validity() ?: 0) +
            (if (possiblySensitive.asKnown().isPresent) 1 else 0) +
            (postCta.asKnown().getOrNull()?.validity() ?: 0) +
            (previousCounts.asKnown().getOrNull()?.validity() ?: 0) +
            (quotedTweet.asKnown().getOrNull()?.validity() ?: 0) +
            (if (quotedTweetId.asKnown().isPresent) 1 else 0) +
            (quotedTweetPermalink.asKnown().getOrNull()?.validity() ?: 0) +
            (quotedTweetUnavailable.asKnown().getOrNull()?.validity() ?: 0) +
            (reactionContext.asKnown().getOrNull()?.validity() ?: 0) +
            (retweetedTweet.asKnown().getOrNull()?.validity() ?: 0) +
            (if (retweetedAt.asKnown().isPresent) 1 else 0) +
            (scopes.asKnown().getOrNull()?.validity() ?: 0) +
            (softIntervention.asKnown().getOrNull()?.validity() ?: 0) +
            (if (source.asKnown().isPresent) 1 else 0) +
            (sportsContext.asKnown().getOrNull()?.validity() ?: 0) +
            (subscriberBadge.asKnown().getOrNull()?.validity() ?: 0) +
            (textHighlights.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (tombstone.asKnown().getOrNull()?.validity() ?: 0) +
            (if (type.asKnown().isPresent) 1 else 0) +
            (if (unavailableAuthorId.asKnown().isPresent) 1 else 0) +
            (unmentionedUserIds.asKnown().getOrNull()?.size ?: 0) +
            (if (url.asKnown().isPresent) 1 else 0) +
            (if (viewState.asKnown().isPresent) 1 else 0)

    /** Article metadata attached to a tweet. */
    class Article
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val coverMedia: JsonField<SearchTweet.Article.CoverMedia>,
        private val id: JsonField<String>,
        private val coverMediaUrl: JsonField<String>,
        private val lifecycleState: JsonField<SearchTweet.Article.LifecycleState>,
        private val metadata: JsonField<SearchTweet.Article.Metadata>,
        private val previewText: JsonField<String>,
        private val title: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("coverMedia")
            @ExcludeMissing
            coverMedia: JsonField<SearchTweet.Article.CoverMedia> = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("coverMediaUrl")
            @ExcludeMissing
            coverMediaUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("lifecycleState")
            @ExcludeMissing
            lifecycleState: JsonField<SearchTweet.Article.LifecycleState> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<SearchTweet.Article.Metadata> = JsonMissing.of(),
            @JsonProperty("previewText")
            @ExcludeMissing
            previewText: JsonField<String> = JsonMissing.of(),
            @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
        ) : this(
            coverMedia,
            id,
            coverMediaUrl,
            lifecycleState,
            metadata,
            previewText,
            title,
            mutableMapOf(),
        )

        /**
         * Public metadata whose fields X defines.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun coverMedia(): Optional<SearchTweet.Article.CoverMedia> =
            coverMedia.getOptional("coverMedia")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun id(): Optional<String> = id.getOptional("id")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun coverMediaUrl(): Optional<String> = coverMediaUrl.getOptional("coverMediaUrl")

        /**
         * Public metadata whose fields X defines.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun lifecycleState(): Optional<SearchTweet.Article.LifecycleState> =
            lifecycleState.getOptional("lifecycleState")

        /**
         * Public metadata whose fields X defines.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun metadata(): Optional<SearchTweet.Article.Metadata> = metadata.getOptional("metadata")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun previewText(): Optional<String> = previewText.getOptional("previewText")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun title(): Optional<String> = title.getOptional("title")

        /**
         * Returns the raw JSON value of [coverMedia].
         *
         * Unlike [coverMedia], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("coverMedia")
        @ExcludeMissing
        fun _coverMedia(): JsonField<SearchTweet.Article.CoverMedia> = coverMedia

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
         * Returns the raw JSON value of [lifecycleState].
         *
         * Unlike [lifecycleState], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("lifecycleState")
        @ExcludeMissing
        fun _lifecycleState(): JsonField<SearchTweet.Article.LifecycleState> = lifecycleState

        /**
         * Returns the raw JSON value of [metadata].
         *
         * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metadata")
        @ExcludeMissing
        fun _metadata(): JsonField<SearchTweet.Article.Metadata> = metadata

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

            private var coverMedia: JsonField<SearchTweet.Article.CoverMedia> = JsonMissing.of()
            private var id: JsonField<String> = JsonMissing.of()
            private var coverMediaUrl: JsonField<String> = JsonMissing.of()
            private var lifecycleState: JsonField<SearchTweet.Article.LifecycleState> =
                JsonMissing.of()
            private var metadata: JsonField<SearchTweet.Article.Metadata> = JsonMissing.of()
            private var previewText: JsonField<String> = JsonMissing.of()
            private var title: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(article: Article) = apply {
                coverMedia = article.coverMedia
                id = article.id
                coverMediaUrl = article.coverMediaUrl
                lifecycleState = article.lifecycleState
                metadata = article.metadata
                previewText = article.previewText
                title = article.title
                additionalProperties = article.additionalProperties.toMutableMap()
            }

            /** Public metadata whose fields X defines. */
            fun coverMedia(coverMedia: SearchTweet.Article.CoverMedia) =
                coverMedia(JsonField.of(coverMedia))

            /** Sets [Builder.coverMedia] to an arbitrary JSON value. */
            fun coverMedia(coverMedia: JsonField<SearchTweet.Article.CoverMedia>) = apply {
                this.coverMedia = coverMedia
            }

            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun coverMediaUrl(coverMediaUrl: String) = coverMediaUrl(JsonField.of(coverMediaUrl))

            /** Sets [Builder.coverMediaUrl] to an arbitrary JSON value. */
            fun coverMediaUrl(coverMediaUrl: JsonField<String>) = apply {
                this.coverMediaUrl = coverMediaUrl
            }

            /** Public metadata whose fields X defines. */
            fun lifecycleState(lifecycleState: SearchTweet.Article.LifecycleState) =
                lifecycleState(JsonField.of(lifecycleState))

            /** Sets [Builder.lifecycleState] to an arbitrary JSON value. */
            fun lifecycleState(lifecycleState: JsonField<SearchTweet.Article.LifecycleState>) =
                apply {
                    this.lifecycleState = lifecycleState
                }

            /** Public metadata whose fields X defines. */
            fun metadata(metadata: SearchTweet.Article.Metadata) = metadata(JsonField.of(metadata))

            /** Sets [Builder.metadata] to an arbitrary JSON value. */
            fun metadata(metadata: JsonField<SearchTweet.Article.Metadata>) = apply {
                this.metadata = metadata
            }

            fun previewText(previewText: String) = previewText(JsonField.of(previewText))

            /** Sets [Builder.previewText] to an arbitrary JSON value. */
            fun previewText(previewText: JsonField<String>) = apply {
                this.previewText = previewText
            }

            fun title(title: String) = title(JsonField.of(title))

            /** Sets [Builder.title] to an arbitrary JSON value. */
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
                Article(
                    coverMedia,
                    id,
                    coverMediaUrl,
                    lifecycleState,
                    metadata,
                    previewText,
                    title,
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
        fun validate(): Article = apply {
            if (validated) {
                return@apply
            }

            coverMedia().ifPresent { it.validate() }
            id()
            coverMediaUrl()
            lifecycleState().ifPresent { it.validate() }
            metadata().ifPresent { it.validate() }
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

        @JvmSynthetic
        internal fun validity(): Int =
            (coverMedia.asKnown().getOrNull()?.validity() ?: 0) +
                (if (id.asKnown().isPresent) 1 else 0) +
                (if (coverMediaUrl.asKnown().isPresent) 1 else 0) +
                (lifecycleState.asKnown().getOrNull()?.validity() ?: 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                (if (previewText.asKnown().isPresent) 1 else 0) +
                (if (title.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Article &&
                coverMedia == other.coverMedia &&
                id == other.id &&
                coverMediaUrl == other.coverMediaUrl &&
                lifecycleState == other.lifecycleState &&
                metadata == other.metadata &&
                previewText == other.previewText &&
                title == other.title &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                coverMedia,
                id,
                coverMediaUrl,
                lifecycleState,
                metadata,
                previewText,
                title,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Article{coverMedia=$coverMedia, id=$id, coverMediaUrl=$coverMediaUrl, lifecycleState=$lifecycleState, metadata=$metadata, previewText=$previewText, title=$title, additionalProperties=$additionalProperties}"
    }

    /** Public card metadata attached to a tweet. */
    class Card
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val bindingValues: JsonField<BindingValues>,
        private val name: JsonField<String>,
        private val platform: JsonField<SearchTweet.Card.Platform>,
        private val url: JsonField<String>,
        private val userReferenceErrors: JsonField<List<SearchTweet.Card.UserReferenceError>>,
        private val userReferences: JsonField<List<UserProfile>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bindingValues")
            @ExcludeMissing
            bindingValues: JsonField<BindingValues> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("platform")
            @ExcludeMissing
            platform: JsonField<SearchTweet.Card.Platform> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("userReferenceErrors")
            @ExcludeMissing
            userReferenceErrors: JsonField<List<SearchTweet.Card.UserReferenceError>> =
                JsonMissing.of(),
            @JsonProperty("userReferences")
            @ExcludeMissing
            userReferences: JsonField<List<UserProfile>> = JsonMissing.of(),
        ) : this(
            id,
            bindingValues,
            name,
            platform,
            url,
            userReferenceErrors,
            userReferences,
            mutableMapOf(),
        )

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun id(): Optional<String> = id.getOptional("id")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun bindingValues(): Optional<BindingValues> = bindingValues.getOptional("bindingValues")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Public metadata whose fields X defines.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun platform(): Optional<SearchTweet.Card.Platform> = platform.getOptional("platform")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * Unresolved card user references.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun userReferenceErrors(): Optional<List<SearchTweet.Card.UserReferenceError>> =
            userReferenceErrors.getOptional("userReferenceErrors")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun userReferences(): Optional<List<UserProfile>> =
            userReferences.getOptional("userReferences")

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
         * Returns the raw JSON value of [platform].
         *
         * Unlike [platform], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("platform")
        @ExcludeMissing
        fun _platform(): JsonField<SearchTweet.Card.Platform> = platform

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [userReferenceErrors].
         *
         * Unlike [userReferenceErrors], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("userReferenceErrors")
        @ExcludeMissing
        fun _userReferenceErrors(): JsonField<List<SearchTweet.Card.UserReferenceError>> =
            userReferenceErrors

        /**
         * Returns the raw JSON value of [userReferences].
         *
         * Unlike [userReferences], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("userReferences")
        @ExcludeMissing
        fun _userReferences(): JsonField<List<UserProfile>> = userReferences

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
            private var platform: JsonField<SearchTweet.Card.Platform> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var userReferenceErrors:
                JsonField<MutableList<SearchTweet.Card.UserReferenceError>>? =
                null
            private var userReferences: JsonField<MutableList<UserProfile>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(card: Card) = apply {
                id = card.id
                bindingValues = card.bindingValues
                name = card.name
                platform = card.platform
                url = card.url
                userReferenceErrors = card.userReferenceErrors.map { it.toMutableList() }
                userReferences = card.userReferences.map { it.toMutableList() }
                additionalProperties = card.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun bindingValues(bindingValues: BindingValues) =
                bindingValues(JsonField.of(bindingValues))

            /** Sets [Builder.bindingValues] to an arbitrary JSON value. */
            fun bindingValues(bindingValues: JsonField<BindingValues>) = apply {
                this.bindingValues = bindingValues
            }

            fun name(name: String) = name(JsonField.of(name))

            /** Sets [Builder.name] to an arbitrary JSON value. */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Public metadata whose fields X defines. */
            fun platform(platform: SearchTweet.Card.Platform) = platform(JsonField.of(platform))

            /** Sets [Builder.platform] to an arbitrary JSON value. */
            fun platform(platform: JsonField<SearchTweet.Card.Platform>) = apply {
                this.platform = platform
            }

            fun url(url: String) = url(JsonField.of(url))

            /** Sets [Builder.url] to an arbitrary JSON value. */
            fun url(url: JsonField<String>) = apply { this.url = url }

            /** Unresolved card user references. */
            fun userReferenceErrors(
                userReferenceErrors: List<SearchTweet.Card.UserReferenceError>
            ) = userReferenceErrors(JsonField.of(userReferenceErrors))

            /** Sets [Builder.userReferenceErrors] to an arbitrary JSON value. */
            fun userReferenceErrors(
                userReferenceErrors: JsonField<List<SearchTweet.Card.UserReferenceError>>
            ) = apply { this.userReferenceErrors = userReferenceErrors.map { it.toMutableList() } }

            /**
             * Adds a single [SearchTweet.Card.UserReferenceError] to [userReferenceErrors].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addUserReferenceError(userReferenceError: SearchTweet.Card.UserReferenceError) =
                apply {
                    userReferenceErrors =
                        (userReferenceErrors ?: JsonField.of(mutableListOf())).also {
                            checkKnown("userReferenceErrors", it).add(userReferenceError)
                        }
                }

            fun userReferences(userReferences: List<UserProfile>) =
                userReferences(JsonField.of(userReferences))

            /** Sets [Builder.userReferences] to an arbitrary JSON value. */
            fun userReferences(userReferences: JsonField<List<UserProfile>>) = apply {
                this.userReferences = userReferences.map { it.toMutableList() }
            }

            /**
             * Adds a single [UserProfile] to [userReferences].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addUserReference(userReference: UserProfile) = apply {
                userReferences =
                    (userReferences ?: JsonField.of(mutableListOf())).also {
                        checkKnown("userReferences", it).add(userReference)
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
             * Returns an immutable instance of [Card].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Card =
                Card(
                    id,
                    bindingValues,
                    name,
                    platform,
                    url,
                    (userReferenceErrors ?: JsonMissing.of()).map { it.toImmutable() },
                    (userReferences ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): Card = apply {
            if (validated) {
                return@apply
            }

            id()
            bindingValues().ifPresent { it.validate() }
            name()
            platform().ifPresent { it.validate() }
            url()
            userReferenceErrors().ifPresent { it.forEach { it.validate() } }
            userReferences().ifPresent { it.forEach { it.validate() } }
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
                (bindingValues.asKnown().getOrNull()?.validity() ?: 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (platform.asKnown().getOrNull()?.validity() ?: 0) +
                (if (url.asKnown().isPresent) 1 else 0) +
                (userReferenceErrors.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (userReferences.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

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

            @JvmSynthetic
            internal fun validity(): Int = additionalProperties.count { (_, value) ->
                !value.isNull() && !value.isMissing()
            }

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
                platform == other.platform &&
                url == other.url &&
                userReferenceErrors == other.userReferenceErrors &&
                userReferences == other.userReferences &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                bindingValues,
                name,
                platform,
                url,
                userReferenceErrors,
                userReferences,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Card{id=$id, bindingValues=$bindingValues, name=$name, platform=$platform, url=$url, userReferenceErrors=$userReferenceErrors, userReferences=$userReferences, additionalProperties=$additionalProperties}"
    }

    /** Community Note presentation metadata returned by X. */
    class CommunityNote
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val footerIconType: JsonField<String>,
        private val iconType: JsonField<String>,
        private val id: JsonField<String>,
        private val destinationUrl: JsonField<String>,
        private val footer: JsonField<String>,
        private val metadata: JsonField<SearchTweet.CommunityNote.Metadata>,
        private val shortTitle: JsonField<String>,
        private val subtitle: JsonField<String>,
        private val title: JsonField<String>,
        private val visualStyle: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("footerIconType")
            @ExcludeMissing
            footerIconType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("iconType")
            @ExcludeMissing
            iconType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("destinationUrl")
            @ExcludeMissing
            destinationUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("footer") @ExcludeMissing footer: JsonField<String> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<SearchTweet.CommunityNote.Metadata> = JsonMissing.of(),
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
            footerIconType,
            iconType,
            id,
            destinationUrl,
            footer,
            metadata,
            shortTitle,
            subtitle,
            title,
            visualStyle,
            mutableMapOf(),
        )

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun footerIconType(): Optional<String> = footerIconType.getOptional("footerIconType")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun iconType(): Optional<String> = iconType.getOptional("iconType")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun id(): Optional<String> = id.getOptional("id")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun destinationUrl(): Optional<String> = destinationUrl.getOptional("destinationUrl")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun footer(): Optional<String> = footer.getOptional("footer")

        /**
         * Public metadata whose fields X defines.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun metadata(): Optional<SearchTweet.CommunityNote.Metadata> =
            metadata.getOptional("metadata")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun shortTitle(): Optional<String> = shortTitle.getOptional("shortTitle")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun subtitle(): Optional<String> = subtitle.getOptional("subtitle")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun title(): Optional<String> = title.getOptional("title")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun visualStyle(): Optional<String> = visualStyle.getOptional("visualStyle")

        /**
         * Returns the raw JSON value of [footerIconType].
         *
         * Unlike [footerIconType], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("footerIconType")
        @ExcludeMissing
        fun _footerIconType(): JsonField<String> = footerIconType

        /**
         * Returns the raw JSON value of [iconType].
         *
         * Unlike [iconType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("iconType") @ExcludeMissing fun _iconType(): JsonField<String> = iconType

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
         * Returns the raw JSON value of [metadata].
         *
         * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metadata")
        @ExcludeMissing
        fun _metadata(): JsonField<SearchTweet.CommunityNote.Metadata> = metadata

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

            private var footerIconType: JsonField<String> = JsonMissing.of()
            private var iconType: JsonField<String> = JsonMissing.of()
            private var id: JsonField<String> = JsonMissing.of()
            private var destinationUrl: JsonField<String> = JsonMissing.of()
            private var footer: JsonField<String> = JsonMissing.of()
            private var metadata: JsonField<SearchTweet.CommunityNote.Metadata> = JsonMissing.of()
            private var shortTitle: JsonField<String> = JsonMissing.of()
            private var subtitle: JsonField<String> = JsonMissing.of()
            private var title: JsonField<String> = JsonMissing.of()
            private var visualStyle: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(communityNote: CommunityNote) = apply {
                footerIconType = communityNote.footerIconType
                iconType = communityNote.iconType
                id = communityNote.id
                destinationUrl = communityNote.destinationUrl
                footer = communityNote.footer
                metadata = communityNote.metadata
                shortTitle = communityNote.shortTitle
                subtitle = communityNote.subtitle
                title = communityNote.title
                visualStyle = communityNote.visualStyle
                additionalProperties = communityNote.additionalProperties.toMutableMap()
            }

            fun footerIconType(footerIconType: String) =
                footerIconType(JsonField.of(footerIconType))

            /** Sets [Builder.footerIconType] to an arbitrary JSON value. */
            fun footerIconType(footerIconType: JsonField<String>) = apply {
                this.footerIconType = footerIconType
            }

            fun iconType(iconType: String) = iconType(JsonField.of(iconType))

            /** Sets [Builder.iconType] to an arbitrary JSON value. */
            fun iconType(iconType: JsonField<String>) = apply { this.iconType = iconType }

            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun destinationUrl(destinationUrl: String) =
                destinationUrl(JsonField.of(destinationUrl))

            /** Sets [Builder.destinationUrl] to an arbitrary JSON value. */
            fun destinationUrl(destinationUrl: JsonField<String>) = apply {
                this.destinationUrl = destinationUrl
            }

            fun footer(footer: String) = footer(JsonField.of(footer))

            /** Sets [Builder.footer] to an arbitrary JSON value. */
            fun footer(footer: JsonField<String>) = apply { this.footer = footer }

            /** Public metadata whose fields X defines. */
            fun metadata(metadata: SearchTweet.CommunityNote.Metadata) =
                metadata(JsonField.of(metadata))

            /** Sets [Builder.metadata] to an arbitrary JSON value. */
            fun metadata(metadata: JsonField<SearchTweet.CommunityNote.Metadata>) = apply {
                this.metadata = metadata
            }

            fun shortTitle(shortTitle: String) = shortTitle(JsonField.of(shortTitle))

            /** Sets [Builder.shortTitle] to an arbitrary JSON value. */
            fun shortTitle(shortTitle: JsonField<String>) = apply { this.shortTitle = shortTitle }

            fun subtitle(subtitle: String) = subtitle(JsonField.of(subtitle))

            /** Sets [Builder.subtitle] to an arbitrary JSON value. */
            fun subtitle(subtitle: JsonField<String>) = apply { this.subtitle = subtitle }

            fun title(title: String) = title(JsonField.of(title))

            /** Sets [Builder.title] to an arbitrary JSON value. */
            fun title(title: JsonField<String>) = apply { this.title = title }

            fun visualStyle(visualStyle: String) = visualStyle(JsonField.of(visualStyle))

            /** Sets [Builder.visualStyle] to an arbitrary JSON value. */
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
                    footerIconType,
                    iconType,
                    id,
                    destinationUrl,
                    footer,
                    metadata,
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

            footerIconType()
            iconType()
            id()
            destinationUrl()
            footer()
            metadata().ifPresent { it.validate() }
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

        @JvmSynthetic
        internal fun validity(): Int =
            (if (footerIconType.asKnown().isPresent) 1 else 0) +
                (if (iconType.asKnown().isPresent) 1 else 0) +
                (if (id.asKnown().isPresent) 1 else 0) +
                (if (destinationUrl.asKnown().isPresent) 1 else 0) +
                (if (footer.asKnown().isPresent) 1 else 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                (if (shortTitle.asKnown().isPresent) 1 else 0) +
                (if (subtitle.asKnown().isPresent) 1 else 0) +
                (if (title.asKnown().isPresent) 1 else 0) +
                (if (visualStyle.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CommunityNote &&
                footerIconType == other.footerIconType &&
                iconType == other.iconType &&
                id == other.id &&
                destinationUrl == other.destinationUrl &&
                footer == other.footer &&
                metadata == other.metadata &&
                shortTitle == other.shortTitle &&
                subtitle == other.subtitle &&
                title == other.title &&
                visualStyle == other.visualStyle &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                footerIconType,
                iconType,
                id,
                destinationUrl,
                footer,
                metadata,
                shortTitle,
                subtitle,
                title,
                visualStyle,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CommunityNote{footerIconType=$footerIconType, iconType=$iconType, id=$id, destinationUrl=$destinationUrl, footer=$footer, metadata=$metadata, shortTitle=$shortTitle, subtitle=$subtitle, title=$title, visualStyle=$visualStyle, additionalProperties=$additionalProperties}"
    }

    /** Edit history metadata returned by X. */
    class Edit
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val editableUntilMsecs: JsonField<String>,
        private val editTweetIds: JsonField<List<String>>,
        private val initialTweetId: JsonField<String>,
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
            @JsonProperty("initialTweetId")
            @ExcludeMissing
            initialTweetId: JsonField<String> = JsonMissing.of(),
        ) : this(editableUntilMsecs, editTweetIds, initialTweetId, mutableMapOf())

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun editableUntilMsecs(): Optional<String> =
            editableUntilMsecs.getOptional("editableUntilMsecs")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun editTweetIds(): Optional<List<String>> = editTweetIds.getOptional("editTweetIds")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun initialTweetId(): Optional<String> = initialTweetId.getOptional("initialTweetId")

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

        /**
         * Returns the raw JSON value of [initialTweetId].
         *
         * Unlike [initialTweetId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("initialTweetId")
        @ExcludeMissing
        fun _initialTweetId(): JsonField<String> = initialTweetId

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
            private var initialTweetId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(edit: Edit) = apply {
                editableUntilMsecs = edit.editableUntilMsecs
                editTweetIds = edit.editTweetIds.map { it.toMutableList() }
                initialTweetId = edit.initialTweetId
                additionalProperties = edit.additionalProperties.toMutableMap()
            }

            fun editableUntilMsecs(editableUntilMsecs: String) =
                editableUntilMsecs(JsonField.of(editableUntilMsecs))

            /** Sets [Builder.editableUntilMsecs] to an arbitrary JSON value. */
            fun editableUntilMsecs(editableUntilMsecs: JsonField<String>) = apply {
                this.editableUntilMsecs = editableUntilMsecs
            }

            fun editTweetIds(editTweetIds: List<String>) = editTweetIds(JsonField.of(editTweetIds))

            /** Sets [Builder.editTweetIds] to an arbitrary JSON value. */
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

            fun initialTweetId(initialTweetId: String) =
                initialTweetId(JsonField.of(initialTweetId))

            /** Sets [Builder.initialTweetId] to an arbitrary JSON value. */
            fun initialTweetId(initialTweetId: JsonField<String>) = apply {
                this.initialTweetId = initialTweetId
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
                    initialTweetId,
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
            initialTweetId()
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
            (if (editableUntilMsecs.asKnown().isPresent) 1 else 0) +
                (editTweetIds.asKnown().getOrNull()?.size ?: 0) +
                (if (initialTweetId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Edit &&
                editableUntilMsecs == other.editableUntilMsecs &&
                editTweetIds == other.editTweetIds &&
                initialTweetId == other.initialTweetId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(editableUntilMsecs, editTweetIds, initialTweetId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Edit{editableUntilMsecs=$editableUntilMsecs, editTweetIds=$editTweetIds, initialTweetId=$initialTweetId, additionalProperties=$additionalProperties}"
    }

    /** Parsed search-result entities including URLs, mentions, hashtags, and media markers */
    class Entities
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val hashtags: JsonField<List<SearchTweet.Entities.Hashtag>>,
        private val smarttags: JsonField<List<SearchTweet.Entities.Smarttag>>,
        private val symbols: JsonField<List<SearchTweet.Entities.Symbol>>,
        private val timestamps: JsonField<List<SearchTweet.Entities.Timestamp>>,
        private val urls: JsonField<List<SearchTweet.Entities.Url>>,
        private val userMentions: JsonField<List<SearchTweet.Entities.UserMention>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("hashtags")
            @ExcludeMissing
            hashtags: JsonField<List<SearchTweet.Entities.Hashtag>> = JsonMissing.of(),
            @JsonProperty("smarttags")
            @ExcludeMissing
            smarttags: JsonField<List<SearchTweet.Entities.Smarttag>> = JsonMissing.of(),
            @JsonProperty("symbols")
            @ExcludeMissing
            symbols: JsonField<List<SearchTweet.Entities.Symbol>> = JsonMissing.of(),
            @JsonProperty("timestamps")
            @ExcludeMissing
            timestamps: JsonField<List<SearchTweet.Entities.Timestamp>> = JsonMissing.of(),
            @JsonProperty("urls")
            @ExcludeMissing
            urls: JsonField<List<SearchTweet.Entities.Url>> = JsonMissing.of(),
            @JsonProperty("user_mentions")
            @ExcludeMissing
            userMentions: JsonField<List<SearchTweet.Entities.UserMention>> = JsonMissing.of(),
        ) : this(hashtags, smarttags, symbols, timestamps, urls, userMentions, mutableMapOf())

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun hashtags(): Optional<List<SearchTweet.Entities.Hashtag>> =
            hashtags.getOptional("hashtags")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun smarttags(): Optional<List<SearchTweet.Entities.Smarttag>> =
            smarttags.getOptional("smarttags")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun symbols(): Optional<List<SearchTweet.Entities.Symbol>> = symbols.getOptional("symbols")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun timestamps(): Optional<List<SearchTweet.Entities.Timestamp>> =
            timestamps.getOptional("timestamps")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun urls(): Optional<List<SearchTweet.Entities.Url>> = urls.getOptional("urls")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun userMentions(): Optional<List<SearchTweet.Entities.UserMention>> =
            userMentions.getOptional("user_mentions")

        /**
         * Returns the raw JSON value of [hashtags].
         *
         * Unlike [hashtags], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hashtags")
        @ExcludeMissing
        fun _hashtags(): JsonField<List<SearchTweet.Entities.Hashtag>> = hashtags

        /**
         * Returns the raw JSON value of [smarttags].
         *
         * Unlike [smarttags], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("smarttags")
        @ExcludeMissing
        fun _smarttags(): JsonField<List<SearchTweet.Entities.Smarttag>> = smarttags

        /**
         * Returns the raw JSON value of [symbols].
         *
         * Unlike [symbols], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("symbols")
        @ExcludeMissing
        fun _symbols(): JsonField<List<SearchTweet.Entities.Symbol>> = symbols

        /**
         * Returns the raw JSON value of [timestamps].
         *
         * Unlike [timestamps], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("timestamps")
        @ExcludeMissing
        fun _timestamps(): JsonField<List<SearchTweet.Entities.Timestamp>> = timestamps

        /**
         * Returns the raw JSON value of [urls].
         *
         * Unlike [urls], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("urls")
        @ExcludeMissing
        fun _urls(): JsonField<List<SearchTweet.Entities.Url>> = urls

        /**
         * Returns the raw JSON value of [userMentions].
         *
         * Unlike [userMentions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("user_mentions")
        @ExcludeMissing
        fun _userMentions(): JsonField<List<SearchTweet.Entities.UserMention>> = userMentions

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

            /** Returns a mutable builder for constructing an instance of [Entities]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Entities]. */
        class Builder internal constructor() {

            private var hashtags: JsonField<MutableList<SearchTweet.Entities.Hashtag>>? = null
            private var smarttags: JsonField<MutableList<SearchTweet.Entities.Smarttag>>? = null
            private var symbols: JsonField<MutableList<SearchTweet.Entities.Symbol>>? = null
            private var timestamps: JsonField<MutableList<SearchTweet.Entities.Timestamp>>? = null
            private var urls: JsonField<MutableList<SearchTweet.Entities.Url>>? = null
            private var userMentions: JsonField<MutableList<SearchTweet.Entities.UserMention>>? =
                null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(entities: Entities) = apply {
                hashtags = entities.hashtags.map { it.toMutableList() }
                smarttags = entities.smarttags.map { it.toMutableList() }
                symbols = entities.symbols.map { it.toMutableList() }
                timestamps = entities.timestamps.map { it.toMutableList() }
                urls = entities.urls.map { it.toMutableList() }
                userMentions = entities.userMentions.map { it.toMutableList() }
                additionalProperties = entities.additionalProperties.toMutableMap()
            }

            fun hashtags(hashtags: List<SearchTweet.Entities.Hashtag>) =
                hashtags(JsonField.of(hashtags))

            /** Sets [Builder.hashtags] to an arbitrary JSON value. */
            fun hashtags(hashtags: JsonField<List<SearchTweet.Entities.Hashtag>>) = apply {
                this.hashtags = hashtags.map { it.toMutableList() }
            }

            /**
             * Adds a single [SearchTweet.Entities.Hashtag] to [hashtags].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addHashtag(hashtag: SearchTweet.Entities.Hashtag) = apply {
                hashtags =
                    (hashtags ?: JsonField.of(mutableListOf())).also {
                        checkKnown("hashtags", it).add(hashtag)
                    }
            }

            fun smarttags(smarttags: List<SearchTweet.Entities.Smarttag>) =
                smarttags(JsonField.of(smarttags))

            /** Sets [Builder.smarttags] to an arbitrary JSON value. */
            fun smarttags(smarttags: JsonField<List<SearchTweet.Entities.Smarttag>>) = apply {
                this.smarttags = smarttags.map { it.toMutableList() }
            }

            /**
             * Adds a single [SearchTweet.Entities.Smarttag] to [smarttags].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSmarttag(smarttag: SearchTweet.Entities.Smarttag) = apply {
                smarttags =
                    (smarttags ?: JsonField.of(mutableListOf())).also {
                        checkKnown("smarttags", it).add(smarttag)
                    }
            }

            fun symbols(symbols: List<SearchTweet.Entities.Symbol>) = symbols(JsonField.of(symbols))

            /** Sets [Builder.symbols] to an arbitrary JSON value. */
            fun symbols(symbols: JsonField<List<SearchTweet.Entities.Symbol>>) = apply {
                this.symbols = symbols.map { it.toMutableList() }
            }

            /**
             * Adds a single [SearchTweet.Entities.Symbol] to [symbols].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSymbol(symbol: SearchTweet.Entities.Symbol) = apply {
                symbols =
                    (symbols ?: JsonField.of(mutableListOf())).also {
                        checkKnown("symbols", it).add(symbol)
                    }
            }

            fun timestamps(timestamps: List<SearchTweet.Entities.Timestamp>) =
                timestamps(JsonField.of(timestamps))

            /** Sets [Builder.timestamps] to an arbitrary JSON value. */
            fun timestamps(timestamps: JsonField<List<SearchTweet.Entities.Timestamp>>) = apply {
                this.timestamps = timestamps.map { it.toMutableList() }
            }

            /**
             * Adds a single [SearchTweet.Entities.Timestamp] to [timestamps].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTimestamp(timestamp: SearchTweet.Entities.Timestamp) = apply {
                timestamps =
                    (timestamps ?: JsonField.of(mutableListOf())).also {
                        checkKnown("timestamps", it).add(timestamp)
                    }
            }

            fun urls(urls: List<SearchTweet.Entities.Url>) = urls(JsonField.of(urls))

            /** Sets [Builder.urls] to an arbitrary JSON value. */
            fun urls(urls: JsonField<List<SearchTweet.Entities.Url>>) = apply {
                this.urls = urls.map { it.toMutableList() }
            }

            /**
             * Adds a single [SearchTweet.Entities.Url] to [urls].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addUrl(url: SearchTweet.Entities.Url) = apply {
                urls =
                    (urls ?: JsonField.of(mutableListOf())).also { checkKnown("urls", it).add(url) }
            }

            fun userMentions(userMentions: List<SearchTweet.Entities.UserMention>) =
                userMentions(JsonField.of(userMentions))

            /** Sets [Builder.userMentions] to an arbitrary JSON value. */
            fun userMentions(userMentions: JsonField<List<SearchTweet.Entities.UserMention>>) =
                apply {
                    this.userMentions = userMentions.map { it.toMutableList() }
                }

            /**
             * Adds a single [SearchTweet.Entities.UserMention] to [userMentions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addUserMention(userMention: SearchTweet.Entities.UserMention) = apply {
                userMentions =
                    (userMentions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("userMentions", it).add(userMention)
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
             * Returns an immutable instance of [Entities].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Entities =
                Entities(
                    (hashtags ?: JsonMissing.of()).map { it.toImmutable() },
                    (smarttags ?: JsonMissing.of()).map { it.toImmutable() },
                    (symbols ?: JsonMissing.of()).map { it.toImmutable() },
                    (timestamps ?: JsonMissing.of()).map { it.toImmutable() },
                    (urls ?: JsonMissing.of()).map { it.toImmutable() },
                    (userMentions ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): Entities = apply {
            if (validated) {
                return@apply
            }

            hashtags().ifPresent { it.forEach { it.validate() } }
            smarttags().ifPresent { it.forEach { it.validate() } }
            symbols().ifPresent { it.forEach { it.validate() } }
            timestamps().ifPresent { it.forEach { it.validate() } }
            urls().ifPresent { it.forEach { it.validate() } }
            userMentions().ifPresent { it.forEach { it.validate() } }
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
            (hashtags.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (smarttags.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (symbols.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (timestamps.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (urls.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (userMentions.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Entities &&
                hashtags == other.hashtags &&
                smarttags == other.smarttags &&
                symbols == other.symbols &&
                timestamps == other.timestamps &&
                urls == other.urls &&
                userMentions == other.userMentions &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                hashtags,
                smarttags,
                symbols,
                timestamps,
                urls,
                userMentions,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Entities{hashtags=$hashtags, smarttags=$smarttags, symbols=$symbols, timestamps=$timestamps, urls=$urls, userMentions=$userMentions, additionalProperties=$additionalProperties}"
    }

    /** Complete Note Tweet content and rich-text metadata. */
    class NoteTweet
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val text: JsonField<String>,
        private val id: JsonField<String>,
        private val entities: JsonField<Entities>,
        private val inlineMedia: JsonField<List<SearchTweet.NoteTweet.InlineMedia>>,
        private val isExpandable: JsonField<Boolean>,
        private val noteId: JsonField<String>,
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
            @JsonProperty("inlineMedia")
            @ExcludeMissing
            inlineMedia: JsonField<List<SearchTweet.NoteTweet.InlineMedia>> = JsonMissing.of(),
            @JsonProperty("isExpandable")
            @ExcludeMissing
            isExpandable: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("noteId") @ExcludeMissing noteId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("richtextTags")
            @ExcludeMissing
            richtextTags: JsonField<List<RichtextTag>> = JsonMissing.of(),
        ) : this(
            text,
            id,
            entities,
            inlineMedia,
            isExpandable,
            noteId,
            richtextTags,
            mutableMapOf(),
        )

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun text(): String = text.getRequired("text")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun id(): Optional<String> = id.getOptional("id")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun entities(): Optional<Entities> = entities.getOptional("entities")

        /**
         * Inline media positions in the Note Tweet text.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun inlineMedia(): Optional<List<SearchTweet.NoteTweet.InlineMedia>> =
            inlineMedia.getOptional("inlineMedia")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun isExpandable(): Optional<Boolean> = isExpandable.getOptional("isExpandable")

        /**
         * The Note's own ID, apart from the post's.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun noteId(): Optional<String> = noteId.getOptional("noteId")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
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
         * Returns the raw JSON value of [inlineMedia].
         *
         * Unlike [inlineMedia], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("inlineMedia")
        @ExcludeMissing
        fun _inlineMedia(): JsonField<List<SearchTweet.NoteTweet.InlineMedia>> = inlineMedia

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
         * Returns the raw JSON value of [noteId].
         *
         * Unlike [noteId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("noteId") @ExcludeMissing fun _noteId(): JsonField<String> = noteId

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
            private var inlineMedia: JsonField<MutableList<SearchTweet.NoteTweet.InlineMedia>>? =
                null
            private var isExpandable: JsonField<Boolean> = JsonMissing.of()
            private var noteId: JsonField<String> = JsonMissing.of()
            private var richtextTags: JsonField<MutableList<RichtextTag>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(noteTweet: NoteTweet) = apply {
                text = noteTweet.text
                id = noteTweet.id
                entities = noteTweet.entities
                inlineMedia = noteTweet.inlineMedia.map { it.toMutableList() }
                isExpandable = noteTweet.isExpandable
                noteId = noteTweet.noteId
                richtextTags = noteTweet.richtextTags.map { it.toMutableList() }
                additionalProperties = noteTweet.additionalProperties.toMutableMap()
            }

            fun text(text: String) = text(JsonField.of(text))

            /** Sets [Builder.text] to an arbitrary JSON value. */
            fun text(text: JsonField<String>) = apply { this.text = text }

            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun entities(entities: Entities) = entities(JsonField.of(entities))

            /** Sets [Builder.entities] to an arbitrary JSON value. */
            fun entities(entities: JsonField<Entities>) = apply { this.entities = entities }

            /** Inline media positions in the Note Tweet text. */
            fun inlineMedia(inlineMedia: List<SearchTweet.NoteTweet.InlineMedia>) =
                inlineMedia(JsonField.of(inlineMedia))

            /** Sets [Builder.inlineMedia] to an arbitrary JSON value. */
            fun inlineMedia(inlineMedia: JsonField<List<SearchTweet.NoteTweet.InlineMedia>>) =
                apply {
                    this.inlineMedia = inlineMedia.map { it.toMutableList() }
                }

            /**
             * Adds a single [SearchTweet.NoteTweet.InlineMedia] to [Builder.inlineMedia].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addInlineMedia(inlineMedia: SearchTweet.NoteTweet.InlineMedia) = apply {
                this.inlineMedia =
                    (this.inlineMedia ?: JsonField.of(mutableListOf())).also {
                        checkKnown("inlineMedia", it).add(inlineMedia)
                    }
            }

            fun isExpandable(isExpandable: Boolean) = isExpandable(JsonField.of(isExpandable))

            /** Sets [Builder.isExpandable] to an arbitrary JSON value. */
            fun isExpandable(isExpandable: JsonField<Boolean>) = apply {
                this.isExpandable = isExpandable
            }

            /** The Note's own ID, apart from the post's. */
            fun noteId(noteId: String) = noteId(JsonField.of(noteId))

            /** Sets [Builder.noteId] to an arbitrary JSON value. */
            fun noteId(noteId: JsonField<String>) = apply { this.noteId = noteId }

            fun richtextTags(richtextTags: List<RichtextTag>) =
                richtextTags(JsonField.of(richtextTags))

            /** Sets [Builder.richtextTags] to an arbitrary JSON value. */
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
                    (inlineMedia ?: JsonMissing.of()).map { it.toImmutable() },
                    isExpandable,
                    noteId,
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
            inlineMedia().ifPresent { it.forEach { it.validate() } }
            isExpandable()
            noteId()
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

        @JvmSynthetic
        internal fun validity(): Int =
            (if (text.asKnown().isPresent) 1 else 0) +
                (if (id.asKnown().isPresent) 1 else 0) +
                (entities.asKnown().getOrNull()?.validity() ?: 0) +
                (inlineMedia.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (isExpandable.asKnown().isPresent) 1 else 0) +
                (if (noteId.asKnown().isPresent) 1 else 0) +
                (richtextTags.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

        class Entities
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val hashtags: JsonField<List<SearchTweet.NoteTweet.Entities.Hashtag>>,
            private val smarttags: JsonField<List<SearchTweet.NoteTweet.Entities.Smarttag>>,
            private val symbols: JsonField<List<SearchTweet.NoteTweet.Entities.Symbol>>,
            private val timestamps: JsonField<List<SearchTweet.NoteTweet.Entities.Timestamp>>,
            private val urls: JsonField<List<SearchTweet.NoteTweet.Entities.Url>>,
            private val userMentions: JsonField<List<SearchTweet.NoteTweet.Entities.UserMention>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("hashtags")
                @ExcludeMissing
                hashtags: JsonField<List<SearchTweet.NoteTweet.Entities.Hashtag>> =
                    JsonMissing.of(),
                @JsonProperty("smarttags")
                @ExcludeMissing
                smarttags: JsonField<List<SearchTweet.NoteTweet.Entities.Smarttag>> =
                    JsonMissing.of(),
                @JsonProperty("symbols")
                @ExcludeMissing
                symbols: JsonField<List<SearchTweet.NoteTweet.Entities.Symbol>> = JsonMissing.of(),
                @JsonProperty("timestamps")
                @ExcludeMissing
                timestamps: JsonField<List<SearchTweet.NoteTweet.Entities.Timestamp>> =
                    JsonMissing.of(),
                @JsonProperty("urls")
                @ExcludeMissing
                urls: JsonField<List<SearchTweet.NoteTweet.Entities.Url>> = JsonMissing.of(),
                @JsonProperty("user_mentions")
                @ExcludeMissing
                userMentions: JsonField<List<SearchTweet.NoteTweet.Entities.UserMention>> =
                    JsonMissing.of(),
            ) : this(hashtags, smarttags, symbols, timestamps, urls, userMentions, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun hashtags(): Optional<List<SearchTweet.NoteTweet.Entities.Hashtag>> =
                hashtags.getOptional("hashtags")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun smarttags(): Optional<List<SearchTweet.NoteTweet.Entities.Smarttag>> =
                smarttags.getOptional("smarttags")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun symbols(): Optional<List<SearchTweet.NoteTweet.Entities.Symbol>> =
                symbols.getOptional("symbols")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun timestamps(): Optional<List<SearchTweet.NoteTweet.Entities.Timestamp>> =
                timestamps.getOptional("timestamps")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun urls(): Optional<List<SearchTweet.NoteTweet.Entities.Url>> =
                urls.getOptional("urls")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun userMentions(): Optional<List<SearchTweet.NoteTweet.Entities.UserMention>> =
                userMentions.getOptional("user_mentions")

            /**
             * Returns the raw JSON value of [hashtags].
             *
             * Unlike [hashtags], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("hashtags")
            @ExcludeMissing
            fun _hashtags(): JsonField<List<SearchTweet.NoteTweet.Entities.Hashtag>> = hashtags

            /**
             * Returns the raw JSON value of [smarttags].
             *
             * Unlike [smarttags], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("smarttags")
            @ExcludeMissing
            fun _smarttags(): JsonField<List<SearchTweet.NoteTweet.Entities.Smarttag>> = smarttags

            /**
             * Returns the raw JSON value of [symbols].
             *
             * Unlike [symbols], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("symbols")
            @ExcludeMissing
            fun _symbols(): JsonField<List<SearchTweet.NoteTweet.Entities.Symbol>> = symbols

            /**
             * Returns the raw JSON value of [timestamps].
             *
             * Unlike [timestamps], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("timestamps")
            @ExcludeMissing
            fun _timestamps(): JsonField<List<SearchTweet.NoteTweet.Entities.Timestamp>> =
                timestamps

            /**
             * Returns the raw JSON value of [urls].
             *
             * Unlike [urls], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("urls")
            @ExcludeMissing
            fun _urls(): JsonField<List<SearchTweet.NoteTweet.Entities.Url>> = urls

            /**
             * Returns the raw JSON value of [userMentions].
             *
             * Unlike [userMentions], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("user_mentions")
            @ExcludeMissing
            fun _userMentions(): JsonField<List<SearchTweet.NoteTweet.Entities.UserMention>> =
                userMentions

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

                /** Returns a mutable builder for constructing an instance of [Entities]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Entities]. */
            class Builder internal constructor() {

                private var hashtags:
                    JsonField<MutableList<SearchTweet.NoteTweet.Entities.Hashtag>>? =
                    null
                private var smarttags:
                    JsonField<MutableList<SearchTweet.NoteTweet.Entities.Smarttag>>? =
                    null
                private var symbols:
                    JsonField<MutableList<SearchTweet.NoteTweet.Entities.Symbol>>? =
                    null
                private var timestamps:
                    JsonField<MutableList<SearchTweet.NoteTweet.Entities.Timestamp>>? =
                    null
                private var urls: JsonField<MutableList<SearchTweet.NoteTweet.Entities.Url>>? = null
                private var userMentions:
                    JsonField<MutableList<SearchTweet.NoteTweet.Entities.UserMention>>? =
                    null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(entities: Entities) = apply {
                    hashtags = entities.hashtags.map { it.toMutableList() }
                    smarttags = entities.smarttags.map { it.toMutableList() }
                    symbols = entities.symbols.map { it.toMutableList() }
                    timestamps = entities.timestamps.map { it.toMutableList() }
                    urls = entities.urls.map { it.toMutableList() }
                    userMentions = entities.userMentions.map { it.toMutableList() }
                    additionalProperties = entities.additionalProperties.toMutableMap()
                }

                fun hashtags(hashtags: List<SearchTweet.NoteTweet.Entities.Hashtag>) =
                    hashtags(JsonField.of(hashtags))

                /** Sets [Builder.hashtags] to an arbitrary JSON value. */
                fun hashtags(hashtags: JsonField<List<SearchTweet.NoteTweet.Entities.Hashtag>>) =
                    apply {
                        this.hashtags = hashtags.map { it.toMutableList() }
                    }

                /**
                 * Adds a single [SearchTweet.NoteTweet.Entities.Hashtag] to [hashtags].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addHashtag(hashtag: SearchTweet.NoteTweet.Entities.Hashtag) = apply {
                    hashtags =
                        (hashtags ?: JsonField.of(mutableListOf())).also {
                            checkKnown("hashtags", it).add(hashtag)
                        }
                }

                fun smarttags(smarttags: List<SearchTweet.NoteTweet.Entities.Smarttag>) =
                    smarttags(JsonField.of(smarttags))

                /** Sets [Builder.smarttags] to an arbitrary JSON value. */
                fun smarttags(smarttags: JsonField<List<SearchTweet.NoteTweet.Entities.Smarttag>>) =
                    apply {
                        this.smarttags = smarttags.map { it.toMutableList() }
                    }

                /**
                 * Adds a single [SearchTweet.NoteTweet.Entities.Smarttag] to [smarttags].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addSmarttag(smarttag: SearchTweet.NoteTweet.Entities.Smarttag) = apply {
                    smarttags =
                        (smarttags ?: JsonField.of(mutableListOf())).also {
                            checkKnown("smarttags", it).add(smarttag)
                        }
                }

                fun symbols(symbols: List<SearchTweet.NoteTweet.Entities.Symbol>) =
                    symbols(JsonField.of(symbols))

                /** Sets [Builder.symbols] to an arbitrary JSON value. */
                fun symbols(symbols: JsonField<List<SearchTweet.NoteTweet.Entities.Symbol>>) =
                    apply {
                        this.symbols = symbols.map { it.toMutableList() }
                    }

                /**
                 * Adds a single [SearchTweet.NoteTweet.Entities.Symbol] to [symbols].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addSymbol(symbol: SearchTweet.NoteTweet.Entities.Symbol) = apply {
                    symbols =
                        (symbols ?: JsonField.of(mutableListOf())).also {
                            checkKnown("symbols", it).add(symbol)
                        }
                }

                fun timestamps(timestamps: List<SearchTweet.NoteTweet.Entities.Timestamp>) =
                    timestamps(JsonField.of(timestamps))

                /** Sets [Builder.timestamps] to an arbitrary JSON value. */
                fun timestamps(
                    timestamps: JsonField<List<SearchTweet.NoteTweet.Entities.Timestamp>>
                ) = apply { this.timestamps = timestamps.map { it.toMutableList() } }

                /**
                 * Adds a single [SearchTweet.NoteTweet.Entities.Timestamp] to [timestamps].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addTimestamp(timestamp: SearchTweet.NoteTweet.Entities.Timestamp) = apply {
                    timestamps =
                        (timestamps ?: JsonField.of(mutableListOf())).also {
                            checkKnown("timestamps", it).add(timestamp)
                        }
                }

                fun urls(urls: List<SearchTweet.NoteTweet.Entities.Url>) = urls(JsonField.of(urls))

                /** Sets [Builder.urls] to an arbitrary JSON value. */
                fun urls(urls: JsonField<List<SearchTweet.NoteTweet.Entities.Url>>) = apply {
                    this.urls = urls.map { it.toMutableList() }
                }

                /**
                 * Adds a single [SearchTweet.NoteTweet.Entities.Url] to [urls].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addUrl(url: SearchTweet.NoteTweet.Entities.Url) = apply {
                    urls =
                        (urls ?: JsonField.of(mutableListOf())).also {
                            checkKnown("urls", it).add(url)
                        }
                }

                fun userMentions(userMentions: List<SearchTweet.NoteTweet.Entities.UserMention>) =
                    userMentions(JsonField.of(userMentions))

                /** Sets [Builder.userMentions] to an arbitrary JSON value. */
                fun userMentions(
                    userMentions: JsonField<List<SearchTweet.NoteTweet.Entities.UserMention>>
                ) = apply { this.userMentions = userMentions.map { it.toMutableList() } }

                /**
                 * Adds a single [SearchTweet.NoteTweet.Entities.UserMention] to [userMentions].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addUserMention(userMention: SearchTweet.NoteTweet.Entities.UserMention) =
                    apply {
                        userMentions =
                            (userMentions ?: JsonField.of(mutableListOf())).also {
                                checkKnown("userMentions", it).add(userMention)
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
                 * Returns an immutable instance of [Entities].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Entities =
                    Entities(
                        (hashtags ?: JsonMissing.of()).map { it.toImmutable() },
                        (smarttags ?: JsonMissing.of()).map { it.toImmutable() },
                        (symbols ?: JsonMissing.of()).map { it.toImmutable() },
                        (timestamps ?: JsonMissing.of()).map { it.toImmutable() },
                        (urls ?: JsonMissing.of()).map { it.toImmutable() },
                        (userMentions ?: JsonMissing.of()).map { it.toImmutable() },
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
            fun validate(): Entities = apply {
                if (validated) {
                    return@apply
                }

                hashtags().ifPresent { it.forEach { it.validate() } }
                smarttags().ifPresent { it.forEach { it.validate() } }
                symbols().ifPresent { it.forEach { it.validate() } }
                timestamps().ifPresent { it.forEach { it.validate() } }
                urls().ifPresent { it.forEach { it.validate() } }
                userMentions().ifPresent { it.forEach { it.validate() } }
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
                (hashtags.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (smarttags.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (symbols.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (timestamps.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (urls.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (userMentions.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Entities &&
                    hashtags == other.hashtags &&
                    smarttags == other.smarttags &&
                    symbols == other.symbols &&
                    timestamps == other.timestamps &&
                    urls == other.urls &&
                    userMentions == other.userMentions &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    hashtags,
                    smarttags,
                    symbols,
                    timestamps,
                    urls,
                    userMentions,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Entities{hashtags=$hashtags, smarttags=$smarttags, symbols=$symbols, timestamps=$timestamps, urls=$urls, userMentions=$userMentions, additionalProperties=$additionalProperties}"
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
             *   or is unexpectedly missing or null.
             */
            fun fromIndex(): Long = fromIndex.getRequired("fromIndex")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun toIndex(): Long = toIndex.getRequired("toIndex")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
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

                /** Sets [Builder.fromIndex] to an arbitrary JSON value. */
                fun fromIndex(fromIndex: JsonField<Long>) = apply { this.fromIndex = fromIndex }

                fun toIndex(toIndex: Long) = toIndex(JsonField.of(toIndex))

                /** Sets [Builder.toIndex] to an arbitrary JSON value. */
                fun toIndex(toIndex: JsonField<Long>) = apply { this.toIndex = toIndex }

                fun types(types: List<String>) = types(JsonField.of(types))

                /** Sets [Builder.types] to an arbitrary JSON value. */
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
                inlineMedia == other.inlineMedia &&
                isExpandable == other.isExpandable &&
                noteId == other.noteId &&
                richtextTags == other.richtextTags &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                text,
                id,
                entities,
                inlineMedia,
                isExpandable,
                noteId,
                richtextTags,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "NoteTweet{text=$text, id=$id, entities=$entities, inlineMedia=$inlineMedia, isExpandable=$isExpandable, noteId=$noteId, richtextTags=$richtextTags, additionalProperties=$additionalProperties}"
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

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun id(): Optional<String> = id.getOptional("id")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun boundingBox(): Optional<BoundingBox> = boundingBox.getOptional("boundingBox")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun country(): Optional<String> = country.getOptional("country")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun countryCode(): Optional<String> = countryCode.getOptional("countryCode")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun fullName(): Optional<String> = fullName.getOptional("fullName")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun name(): Optional<String> = name.getOptional("name")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun placeType(): Optional<String> = placeType.getOptional("placeType")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
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

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun boundingBox(boundingBox: BoundingBox) = boundingBox(JsonField.of(boundingBox))

            /** Sets [Builder.boundingBox] to an arbitrary JSON value. */
            fun boundingBox(boundingBox: JsonField<BoundingBox>) = apply {
                this.boundingBox = boundingBox
            }

            fun country(country: String) = country(JsonField.of(country))

            /** Sets [Builder.country] to an arbitrary JSON value. */
            fun country(country: JsonField<String>) = apply { this.country = country }

            fun countryCode(countryCode: String) = countryCode(JsonField.of(countryCode))

            /** Sets [Builder.countryCode] to an arbitrary JSON value. */
            fun countryCode(countryCode: JsonField<String>) = apply {
                this.countryCode = countryCode
            }

            fun fullName(fullName: String) = fullName(JsonField.of(fullName))

            /** Sets [Builder.fullName] to an arbitrary JSON value. */
            fun fullName(fullName: JsonField<String>) = apply { this.fullName = fullName }

            fun name(name: String) = name(JsonField.of(name))

            /** Sets [Builder.name] to an arbitrary JSON value. */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun placeType(placeType: String) = placeType(JsonField.of(placeType))

            /** Sets [Builder.placeType] to an arbitrary JSON value. */
            fun placeType(placeType: JsonField<String>) = apply { this.placeType = placeType }

            fun url(url: String) = url(JsonField.of(url))

            /** Sets [Builder.url] to an arbitrary JSON value. */
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

            @JvmSynthetic
            internal fun validity(): Int = additionalProperties.count { (_, value) ->
                !value.isNull() && !value.isMissing()
            }

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

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun bookmarkCount(): Optional<Long> = bookmarkCount.getOptional("bookmarkCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun likeCount(): Optional<Long> = likeCount.getOptional("likeCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun quoteCount(): Optional<Long> = quoteCount.getOptional("quoteCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun replyCount(): Optional<Long> = replyCount.getOptional("replyCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
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

            /** Sets [Builder.bookmarkCount] to an arbitrary JSON value. */
            fun bookmarkCount(bookmarkCount: JsonField<Long>) = apply {
                this.bookmarkCount = bookmarkCount
            }

            fun likeCount(likeCount: Long) = likeCount(JsonField.of(likeCount))

            /** Sets [Builder.likeCount] to an arbitrary JSON value. */
            fun likeCount(likeCount: JsonField<Long>) = apply { this.likeCount = likeCount }

            fun quoteCount(quoteCount: Long) = quoteCount(JsonField.of(quoteCount))

            /** Sets [Builder.quoteCount] to an arbitrary JSON value. */
            fun quoteCount(quoteCount: JsonField<Long>) = apply { this.quoteCount = quoteCount }

            fun replyCount(replyCount: Long) = replyCount(JsonField.of(replyCount))

            /** Sets [Builder.replyCount] to an arbitrary JSON value. */
            fun replyCount(replyCount: JsonField<Long>) = apply { this.replyCount = replyCount }

            fun retweetCount(retweetCount: Long) = retweetCount(JsonField.of(retweetCount))

            /** Sets [Builder.retweetCount] to an arbitrary JSON value. */
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

        return other is EmbeddedTweet &&
            id == other.id &&
            bookmarkCount == other.bookmarkCount &&
            unknownCounts == other.unknownCounts &&
            likeCount == other.likeCount &&
            quoteCount == other.quoteCount &&
            replyCount == other.replyCount &&
            retweetCount == other.retweetCount &&
            text == other.text &&
            viewCount == other.viewCount &&
            article == other.article &&
            author == other.author &&
            authorUnavailable == other.authorUnavailable &&
            card == other.card &&
            cashtagAttachments == other.cashtagAttachments &&
            communityId == other.communityId &&
            communityName == other.communityName &&
            communityNote == other.communityNote &&
            contentDisclosure == other.contentDisclosure &&
            conversationControl == other.conversationControl &&
            conversationId == other.conversationId &&
            coordinates == other.coordinates &&
            createdAt == other.createdAt &&
            displayTextRange == other.displayTextRange &&
            edit == other.edit &&
            entities == other.entities &&
            exclusiveContent == other.exclusiveContent &&
            geo == other.geo &&
            grokShareAttachment == other.grokShareAttachment &&
            grokTranslatedPost == other.grokTranslatedPost &&
            hasCommunityNotes == other.hasCommunityNotes &&
            inReplyToId == other.inReplyToId &&
            inReplyToUserId == other.inReplyToUserId &&
            inReplyToUsername == other.inReplyToUsername &&
            interstitial == other.interstitial &&
            isLimitedReply == other.isLimitedReply &&
            isNoteTweet == other.isNoteTweet &&
            isPinned == other.isPinned &&
            isQuoteStatus == other.isQuoteStatus &&
            isReply == other.isReply &&
            isRetweet == other.isRetweet &&
            isTranslatable == other.isTranslatable &&
            jetfuelAttachment == other.jetfuelAttachment &&
            lang == other.lang &&
            limitedActions == other.limitedActions &&
            media == other.media &&
            noteTweet == other.noteTweet &&
            parentTweet == other.parentTweet &&
            place == other.place &&
            possiblySensitive == other.possiblySensitive &&
            postCta == other.postCta &&
            previousCounts == other.previousCounts &&
            quotedTweet == other.quotedTweet &&
            quotedTweetId == other.quotedTweetId &&
            quotedTweetPermalink == other.quotedTweetPermalink &&
            quotedTweetUnavailable == other.quotedTweetUnavailable &&
            reactionContext == other.reactionContext &&
            retweetedTweet == other.retweetedTweet &&
            retweetedAt == other.retweetedAt &&
            scopes == other.scopes &&
            softIntervention == other.softIntervention &&
            source == other.source &&
            sportsContext == other.sportsContext &&
            subscriberBadge == other.subscriberBadge &&
            textHighlights == other.textHighlights &&
            tombstone == other.tombstone &&
            type == other.type &&
            unavailableAuthorId == other.unavailableAuthorId &&
            unmentionedUserIds == other.unmentionedUserIds &&
            url == other.url &&
            viewState == other.viewState &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            bookmarkCount,
            unknownCounts,
            likeCount,
            quoteCount,
            replyCount,
            retweetCount,
            text,
            viewCount,
            article,
            author,
            authorUnavailable,
            card,
            cashtagAttachments,
            communityId,
            communityName,
            communityNote,
            contentDisclosure,
            conversationControl,
            conversationId,
            coordinates,
            createdAt,
            displayTextRange,
            edit,
            entities,
            exclusiveContent,
            geo,
            grokShareAttachment,
            grokTranslatedPost,
            hasCommunityNotes,
            inReplyToId,
            inReplyToUserId,
            inReplyToUsername,
            interstitial,
            isLimitedReply,
            isNoteTweet,
            isPinned,
            isQuoteStatus,
            isReply,
            isRetweet,
            isTranslatable,
            jetfuelAttachment,
            lang,
            limitedActions,
            media,
            noteTweet,
            parentTweet,
            place,
            possiblySensitive,
            postCta,
            previousCounts,
            quotedTweet,
            quotedTweetId,
            quotedTweetPermalink,
            quotedTweetUnavailable,
            reactionContext,
            retweetedTweet,
            retweetedAt,
            scopes,
            softIntervention,
            source,
            sportsContext,
            subscriberBadge,
            textHighlights,
            tombstone,
            type,
            unavailableAuthorId,
            unmentionedUserIds,
            url,
            viewState,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "EmbeddedTweet{id=$id, bookmarkCount=$bookmarkCount, unknownCounts=$unknownCounts, likeCount=$likeCount, quoteCount=$quoteCount, replyCount=$replyCount, retweetCount=$retweetCount, text=$text, viewCount=$viewCount, article=$article, author=$author, authorUnavailable=$authorUnavailable, card=$card, cashtagAttachments=$cashtagAttachments, communityId=$communityId, communityName=$communityName, communityNote=$communityNote, contentDisclosure=$contentDisclosure, conversationControl=$conversationControl, conversationId=$conversationId, coordinates=$coordinates, createdAt=$createdAt, displayTextRange=$displayTextRange, edit=$edit, entities=$entities, exclusiveContent=$exclusiveContent, geo=$geo, grokShareAttachment=$grokShareAttachment, grokTranslatedPost=$grokTranslatedPost, hasCommunityNotes=$hasCommunityNotes, inReplyToId=$inReplyToId, inReplyToUserId=$inReplyToUserId, inReplyToUsername=$inReplyToUsername, interstitial=$interstitial, isLimitedReply=$isLimitedReply, isNoteTweet=$isNoteTweet, isPinned=$isPinned, isQuoteStatus=$isQuoteStatus, isReply=$isReply, isRetweet=$isRetweet, isTranslatable=$isTranslatable, jetfuelAttachment=$jetfuelAttachment, lang=$lang, limitedActions=$limitedActions, media=$media, noteTweet=$noteTweet, parentTweet=$parentTweet, place=$place, possiblySensitive=$possiblySensitive, postCta=$postCta, previousCounts=$previousCounts, quotedTweet=$quotedTweet, quotedTweetId=$quotedTweetId, quotedTweetPermalink=$quotedTweetPermalink, quotedTweetUnavailable=$quotedTweetUnavailable, reactionContext=$reactionContext, retweetedTweet=$retweetedTweet, retweetedAt=$retweetedAt, scopes=$scopes, softIntervention=$softIntervention, source=$source, sportsContext=$sportsContext, subscriberBadge=$subscriberBadge, textHighlights=$textHighlights, tombstone=$tombstone, type=$type, unavailableAuthorId=$unavailableAuthorId, unmentionedUserIds=$unmentionedUserIds, url=$url, viewState=$viewState, additionalProperties=$additionalProperties}"
}
