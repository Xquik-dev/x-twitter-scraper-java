// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

import com.fasterxml.jackson.annotation.JsonCreator
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.time.LocalDate
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Returns the posts on the user's Articles tab, newest first. Each post's `article` holds the
 * Article's ID, title, preview, cover & dates. Read the full text with GET /x/articles/{tweetId}.
 */
class UserRetrieveArticlesParams
private constructor(
    private val id: String?,
    private val anyWords: String?,
    private val blueVerifiedOnly: Boolean?,
    private val cashtags: String?,
    private val conversationId: String?,
    private val cursor: String?,
    private val exactPhrase: String?,
    private val excludeWords: String?,
    private val fields: String?,
    private val fromUser: String?,
    private val hashtags: String?,
    private val inReplyToTweetId: String?,
    private val language: String?,
    private val maxFaves: Long?,
    private val maxId: String?,
    private val maxQuotes: Long?,
    private val maxReplies: Long?,
    private val maxRetweets: Long?,
    private val mediaType: MediaType?,
    private val mentioning: String?,
    private val minBookmarks: Long?,
    private val minLikes: Long?,
    private val minQuotes: Long?,
    private val minReplies: Long?,
    private val minRetweets: Long?,
    private val minViews: Long?,
    private val nativeRetweets: Boolean?,
    private val omit: String?,
    private val pageSize: Long?,
    private val quotes: Quotes?,
    private val quotesOfTweetId: String?,
    private val replies: Replies?,
    private val retweets: Retweets?,
    private val retweetsOfTweetId: String?,
    private val sinceDate: LocalDate?,
    private val sinceId: String?,
    private val toUser: String?,
    private val untilDate: LocalDate?,
    private val url: String?,
    private val verifiedOnly: Boolean?,
    private val withinTime: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun id(): Optional<String> = Optional.ofNullable(id)

    /** Words or quoted phrases where any one can match. Separate with spaces, commas, or lines. */
    fun anyWords(): Optional<String> = Optional.ofNullable(anyWords)

    /** Only return tweets from Blue-verified authors. */
    fun blueVerifiedOnly(): Optional<Boolean> = Optional.ofNullable(blueVerifiedOnly)

    /** Cashtags separated by spaces, commas, or lines. */
    fun cashtags(): Optional<String> = Optional.ofNullable(cashtags)

    /** Conversation ID filter. */
    fun conversationId(): Optional<String> = Optional.ofNullable(conversationId)

    /**
     * Pagination cursor for collection results. Also read as next_cursor, next_token,
     * pagination_token or continuation_token.
     */
    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    /** Match this literal phrase, including any hyphens. */
    fun exactPhrase(): Optional<String> = Optional.ofNullable(exactPhrase)

    /** Words or quoted phrases to exclude. Separate with spaces, commas, or lines. */
    fun excludeWords(): Optional<String> = Optional.ofNullable(excludeWords)

    /**
     * Fields to keep in each row, comma-separated. Use dots for nested fields, such as
     * author.username. A list keeps the field in each item. Case & underscores do not matter. A row
     * that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An unknown name
     * answers 400 unknown_field with the valid names, before any read. The price stays the same.
     * SDK row types then hold only the named fields.
     */
    fun fields(): Optional<String> = Optional.ofNullable(fields)

    /** Filter by author username. */
    fun fromUser(): Optional<String> = Optional.ofNullable(fromUser)

    /** Hashtags separated by spaces, commas, or lines. */
    fun hashtags(): Optional<String> = Optional.ofNullable(hashtags)

    /** Only replies to this tweet ID. */
    fun inReplyToTweetId(): Optional<String> = Optional.ofNullable(inReplyToTweetId)

    /** Filter by language. Its alias is `lang`. */
    fun language(): Optional<String> = Optional.ofNullable(language)

    /** Maximum likes threshold. maxLikes & max_likes also work. */
    fun maxFaves(): Optional<Long> = Optional.ofNullable(maxFaves)

    /** Return Tweets at or below this ID. */
    fun maxId(): Optional<String> = Optional.ofNullable(maxId)

    /** Maximum quotes threshold. */
    fun maxQuotes(): Optional<Long> = Optional.ofNullable(maxQuotes)

    /** Maximum replies threshold. */
    fun maxReplies(): Optional<Long> = Optional.ofNullable(maxReplies)

    /** Maximum retweets threshold. */
    fun maxRetweets(): Optional<Long> = Optional.ofNullable(maxRetweets)

    /** Filter media. Its aliases are has_video & has_media. */
    fun mediaType(): Optional<MediaType> = Optional.ofNullable(mediaType)

    /** Filter tweets mentioning a username. */
    fun mentioning(): Optional<String> = Optional.ofNullable(mentioning)

    /** Minimum bookmark count threshold. */
    fun minBookmarks(): Optional<Long> = Optional.ofNullable(minBookmarks)

    /** Minimum likes. Its aliases are minFaves, min_likes & min_faves. */
    fun minLikes(): Optional<Long> = Optional.ofNullable(minLikes)

    /** Minimum quote count threshold. */
    fun minQuotes(): Optional<Long> = Optional.ofNullable(minQuotes)

    /** Minimum replies threshold. */
    fun minReplies(): Optional<Long> = Optional.ofNullable(minReplies)

    /** Minimum retweets threshold. */
    fun minRetweets(): Optional<Long> = Optional.ofNullable(minRetweets)

    /** Minimum view count threshold. */
    fun minViews(): Optional<Long> = Optional.ofNullable(minViews)

    /** Only return native reposts. */
    fun nativeRetweets(): Optional<Boolean> = Optional.ofNullable(nativeRetweets)

    /**
     * Fields to drop from each row, comma-separated. It takes the same names as fields. With
     * fields, it drops from the kept fields.
     */
    fun omit(): Optional<String> = Optional.ofNullable(omit)

    /**
     * Items per page (1-100, default 20). Source, filters or credits can return fewer. Follow
     * next_cursor for more pages. Its aliases are limit, count, max_results, maxItems, max_items &
     * per_page.
     */
    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    /** Only when the caller requests a quote mode. */
    fun quotes(): Optional<Quotes> = Optional.ofNullable(quotes)

    /** Only quotes of this tweet ID. */
    fun quotesOfTweetId(): Optional<String> = Optional.ofNullable(quotesOfTweetId)

    /** Reply mode. Exclude keeps own-thread replies. */
    fun replies(): Optional<Replies> = Optional.ofNullable(replies)

    /** Only when the caller requests a repost mode. */
    fun retweets(): Optional<Retweets> = Optional.ofNullable(retweets)

    /** Only retweets of this tweet ID. */
    fun retweetsOfTweetId(): Optional<String> = Optional.ofNullable(retweetsOfTweetId)

    /** Start date in YYYY-MM-DD format, as a UTC day. */
    fun sinceDate(): Optional<LocalDate> = Optional.ofNullable(sinceDate)

    /** Return Tweets whose IDs exceed this ID. */
    fun sinceId(): Optional<String> = Optional.ofNullable(sinceId)

    /** Filter replies sent to a username. */
    fun toUser(): Optional<String> = Optional.ofNullable(toUser)

    /** End date in YYYY-MM-DD format, as a UTC day, inclusive, so its own posts count. */
    fun untilDate(): Optional<LocalDate> = Optional.ofNullable(untilDate)

    /** URL substring or domain filter. */
    fun url(): Optional<String> = Optional.ofNullable(url)

    /** Only return tweets from verified authors. */
    fun verifiedOnly(): Optional<Boolean> = Optional.ofNullable(verifiedOnly)

    /** Keeps Tweets from a recent window, such as 90m or 7d. Use a whole number & s, m, h or d. */
    fun withinTime(): Optional<String> = Optional.ofNullable(withinTime)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): UserRetrieveArticlesParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of [UserRetrieveArticlesParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserRetrieveArticlesParams]. */
    class Builder internal constructor() {

        private var id: String? = null
        private var anyWords: String? = null
        private var blueVerifiedOnly: Boolean? = null
        private var cashtags: String? = null
        private var conversationId: String? = null
        private var cursor: String? = null
        private var exactPhrase: String? = null
        private var excludeWords: String? = null
        private var fields: String? = null
        private var fromUser: String? = null
        private var hashtags: String? = null
        private var inReplyToTweetId: String? = null
        private var language: String? = null
        private var maxFaves: Long? = null
        private var maxId: String? = null
        private var maxQuotes: Long? = null
        private var maxReplies: Long? = null
        private var maxRetweets: Long? = null
        private var mediaType: MediaType? = null
        private var mentioning: String? = null
        private var minBookmarks: Long? = null
        private var minLikes: Long? = null
        private var minQuotes: Long? = null
        private var minReplies: Long? = null
        private var minRetweets: Long? = null
        private var minViews: Long? = null
        private var nativeRetweets: Boolean? = null
        private var omit: String? = null
        private var pageSize: Long? = null
        private var quotes: Quotes? = null
        private var quotesOfTweetId: String? = null
        private var replies: Replies? = null
        private var retweets: Retweets? = null
        private var retweetsOfTweetId: String? = null
        private var sinceDate: LocalDate? = null
        private var sinceId: String? = null
        private var toUser: String? = null
        private var untilDate: LocalDate? = null
        private var url: String? = null
        private var verifiedOnly: Boolean? = null
        private var withinTime: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(userRetrieveArticlesParams: UserRetrieveArticlesParams) = apply {
            id = userRetrieveArticlesParams.id
            anyWords = userRetrieveArticlesParams.anyWords
            blueVerifiedOnly = userRetrieveArticlesParams.blueVerifiedOnly
            cashtags = userRetrieveArticlesParams.cashtags
            conversationId = userRetrieveArticlesParams.conversationId
            cursor = userRetrieveArticlesParams.cursor
            exactPhrase = userRetrieveArticlesParams.exactPhrase
            excludeWords = userRetrieveArticlesParams.excludeWords
            fields = userRetrieveArticlesParams.fields
            fromUser = userRetrieveArticlesParams.fromUser
            hashtags = userRetrieveArticlesParams.hashtags
            inReplyToTweetId = userRetrieveArticlesParams.inReplyToTweetId
            language = userRetrieveArticlesParams.language
            maxFaves = userRetrieveArticlesParams.maxFaves
            maxId = userRetrieveArticlesParams.maxId
            maxQuotes = userRetrieveArticlesParams.maxQuotes
            maxReplies = userRetrieveArticlesParams.maxReplies
            maxRetweets = userRetrieveArticlesParams.maxRetweets
            mediaType = userRetrieveArticlesParams.mediaType
            mentioning = userRetrieveArticlesParams.mentioning
            minBookmarks = userRetrieveArticlesParams.minBookmarks
            minLikes = userRetrieveArticlesParams.minLikes
            minQuotes = userRetrieveArticlesParams.minQuotes
            minReplies = userRetrieveArticlesParams.minReplies
            minRetweets = userRetrieveArticlesParams.minRetweets
            minViews = userRetrieveArticlesParams.minViews
            nativeRetweets = userRetrieveArticlesParams.nativeRetweets
            omit = userRetrieveArticlesParams.omit
            pageSize = userRetrieveArticlesParams.pageSize
            quotes = userRetrieveArticlesParams.quotes
            quotesOfTweetId = userRetrieveArticlesParams.quotesOfTweetId
            replies = userRetrieveArticlesParams.replies
            retweets = userRetrieveArticlesParams.retweets
            retweetsOfTweetId = userRetrieveArticlesParams.retweetsOfTweetId
            sinceDate = userRetrieveArticlesParams.sinceDate
            sinceId = userRetrieveArticlesParams.sinceId
            toUser = userRetrieveArticlesParams.toUser
            untilDate = userRetrieveArticlesParams.untilDate
            url = userRetrieveArticlesParams.url
            verifiedOnly = userRetrieveArticlesParams.verifiedOnly
            withinTime = userRetrieveArticlesParams.withinTime
            additionalHeaders = userRetrieveArticlesParams.additionalHeaders.toBuilder()
            additionalQueryParams = userRetrieveArticlesParams.additionalQueryParams.toBuilder()
        }

        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /**
         * Words or quoted phrases where any one can match. Separate with spaces, commas, or lines.
         */
        fun anyWords(anyWords: String?) = apply { this.anyWords = anyWords }

        /** Alias for calling [Builder.anyWords] with `anyWords.orElse(null)`. */
        fun anyWords(anyWords: Optional<String>) = anyWords(anyWords.getOrNull())

        /** Only return tweets from Blue-verified authors. */
        fun blueVerifiedOnly(blueVerifiedOnly: Boolean?) = apply {
            this.blueVerifiedOnly = blueVerifiedOnly
        }

        /** Alias for [Builder.blueVerifiedOnly]. */
        fun blueVerifiedOnly(blueVerifiedOnly: Boolean) =
            blueVerifiedOnly(blueVerifiedOnly as Boolean?)

        /** Alias for calling [Builder.blueVerifiedOnly] with `blueVerifiedOnly.orElse(null)`. */
        fun blueVerifiedOnly(blueVerifiedOnly: Optional<Boolean>) =
            blueVerifiedOnly(blueVerifiedOnly.getOrNull())

        /** Cashtags separated by spaces, commas, or lines. */
        fun cashtags(cashtags: String?) = apply { this.cashtags = cashtags }

        /** Alias for calling [Builder.cashtags] with `cashtags.orElse(null)`. */
        fun cashtags(cashtags: Optional<String>) = cashtags(cashtags.getOrNull())

        /** Conversation ID filter. */
        fun conversationId(conversationId: String?) = apply { this.conversationId = conversationId }

        /** Alias for calling [Builder.conversationId] with `conversationId.orElse(null)`. */
        fun conversationId(conversationId: Optional<String>) =
            conversationId(conversationId.getOrNull())

        /**
         * Pagination cursor for collection results. Also read as next_cursor, next_token,
         * pagination_token or continuation_token.
         */
        fun cursor(cursor: String?) = apply { this.cursor = cursor }

        /** Alias for calling [Builder.cursor] with `cursor.orElse(null)`. */
        fun cursor(cursor: Optional<String>) = cursor(cursor.getOrNull())

        /** Match this literal phrase, including any hyphens. */
        fun exactPhrase(exactPhrase: String?) = apply { this.exactPhrase = exactPhrase }

        /** Alias for calling [Builder.exactPhrase] with `exactPhrase.orElse(null)`. */
        fun exactPhrase(exactPhrase: Optional<String>) = exactPhrase(exactPhrase.getOrNull())

        /** Words or quoted phrases to exclude. Separate with spaces, commas, or lines. */
        fun excludeWords(excludeWords: String?) = apply { this.excludeWords = excludeWords }

        /** Alias for calling [Builder.excludeWords] with `excludeWords.orElse(null)`. */
        fun excludeWords(excludeWords: Optional<String>) = excludeWords(excludeWords.getOrNull())

        /**
         * Fields to keep in each row, comma-separated. Use dots for nested fields, such as
         * author.username. A list keeps the field in each item. Case & underscores do not matter. A
         * row that lacks a field leaves it out. Cursors, counts & diagnostics always stay. An
         * unknown name answers 400 unknown_field with the valid names, before any read. The price
         * stays the same. SDK row types then hold only the named fields.
         */
        fun fields(fields: String?) = apply { this.fields = fields }

        /** Alias for calling [Builder.fields] with `fields.orElse(null)`. */
        fun fields(fields: Optional<String>) = fields(fields.getOrNull())

        /** Filter by author username. */
        fun fromUser(fromUser: String?) = apply { this.fromUser = fromUser }

        /** Alias for calling [Builder.fromUser] with `fromUser.orElse(null)`. */
        fun fromUser(fromUser: Optional<String>) = fromUser(fromUser.getOrNull())

        /** Hashtags separated by spaces, commas, or lines. */
        fun hashtags(hashtags: String?) = apply { this.hashtags = hashtags }

        /** Alias for calling [Builder.hashtags] with `hashtags.orElse(null)`. */
        fun hashtags(hashtags: Optional<String>) = hashtags(hashtags.getOrNull())

        /** Only replies to this tweet ID. */
        fun inReplyToTweetId(inReplyToTweetId: String?) = apply {
            this.inReplyToTweetId = inReplyToTweetId
        }

        /** Alias for calling [Builder.inReplyToTweetId] with `inReplyToTweetId.orElse(null)`. */
        fun inReplyToTweetId(inReplyToTweetId: Optional<String>) =
            inReplyToTweetId(inReplyToTweetId.getOrNull())

        /** Filter by language. Its alias is `lang`. */
        fun language(language: String?) = apply { this.language = language }

        /** Alias for calling [Builder.language] with `language.orElse(null)`. */
        fun language(language: Optional<String>) = language(language.getOrNull())

        /** Maximum likes threshold. maxLikes & max_likes also work. */
        fun maxFaves(maxFaves: Long?) = apply { this.maxFaves = maxFaves }

        /** Alias for [Builder.maxFaves]. */
        fun maxFaves(maxFaves: Long) = maxFaves(maxFaves as Long?)

        /** Alias for calling [Builder.maxFaves] with `maxFaves.orElse(null)`. */
        fun maxFaves(maxFaves: Optional<Long>) = maxFaves(maxFaves.getOrNull())

        /** Return Tweets at or below this ID. */
        fun maxId(maxId: String?) = apply { this.maxId = maxId }

        /** Alias for calling [Builder.maxId] with `maxId.orElse(null)`. */
        fun maxId(maxId: Optional<String>) = maxId(maxId.getOrNull())

        /** Maximum quotes threshold. */
        fun maxQuotes(maxQuotes: Long?) = apply { this.maxQuotes = maxQuotes }

        /** Alias for [Builder.maxQuotes]. */
        fun maxQuotes(maxQuotes: Long) = maxQuotes(maxQuotes as Long?)

        /** Alias for calling [Builder.maxQuotes] with `maxQuotes.orElse(null)`. */
        fun maxQuotes(maxQuotes: Optional<Long>) = maxQuotes(maxQuotes.getOrNull())

        /** Maximum replies threshold. */
        fun maxReplies(maxReplies: Long?) = apply { this.maxReplies = maxReplies }

        /** Alias for [Builder.maxReplies]. */
        fun maxReplies(maxReplies: Long) = maxReplies(maxReplies as Long?)

        /** Alias for calling [Builder.maxReplies] with `maxReplies.orElse(null)`. */
        fun maxReplies(maxReplies: Optional<Long>) = maxReplies(maxReplies.getOrNull())

        /** Maximum retweets threshold. */
        fun maxRetweets(maxRetweets: Long?) = apply { this.maxRetweets = maxRetweets }

        /** Alias for [Builder.maxRetweets]. */
        fun maxRetweets(maxRetweets: Long) = maxRetweets(maxRetweets as Long?)

        /** Alias for calling [Builder.maxRetweets] with `maxRetweets.orElse(null)`. */
        fun maxRetweets(maxRetweets: Optional<Long>) = maxRetweets(maxRetweets.getOrNull())

        /** Filter media. Its aliases are has_video & has_media. */
        fun mediaType(mediaType: MediaType?) = apply { this.mediaType = mediaType }

        /** Alias for calling [Builder.mediaType] with `mediaType.orElse(null)`. */
        fun mediaType(mediaType: Optional<MediaType>) = mediaType(mediaType.getOrNull())

        /** Filter tweets mentioning a username. */
        fun mentioning(mentioning: String?) = apply { this.mentioning = mentioning }

        /** Alias for calling [Builder.mentioning] with `mentioning.orElse(null)`. */
        fun mentioning(mentioning: Optional<String>) = mentioning(mentioning.getOrNull())

        /** Minimum bookmark count threshold. */
        fun minBookmarks(minBookmarks: Long?) = apply { this.minBookmarks = minBookmarks }

        /** Alias for [Builder.minBookmarks]. */
        fun minBookmarks(minBookmarks: Long) = minBookmarks(minBookmarks as Long?)

        /** Alias for calling [Builder.minBookmarks] with `minBookmarks.orElse(null)`. */
        fun minBookmarks(minBookmarks: Optional<Long>) = minBookmarks(minBookmarks.getOrNull())

        /** Minimum likes. Its aliases are minFaves, min_likes & min_faves. */
        fun minLikes(minLikes: Long?) = apply { this.minLikes = minLikes }

        /** Alias for [Builder.minLikes]. */
        fun minLikes(minLikes: Long) = minLikes(minLikes as Long?)

        /** Alias for calling [Builder.minLikes] with `minLikes.orElse(null)`. */
        fun minLikes(minLikes: Optional<Long>) = minLikes(minLikes.getOrNull())

        /** Minimum quote count threshold. */
        fun minQuotes(minQuotes: Long?) = apply { this.minQuotes = minQuotes }

        /** Alias for [Builder.minQuotes]. */
        fun minQuotes(minQuotes: Long) = minQuotes(minQuotes as Long?)

        /** Alias for calling [Builder.minQuotes] with `minQuotes.orElse(null)`. */
        fun minQuotes(minQuotes: Optional<Long>) = minQuotes(minQuotes.getOrNull())

        /** Minimum replies threshold. */
        fun minReplies(minReplies: Long?) = apply { this.minReplies = minReplies }

        /** Alias for [Builder.minReplies]. */
        fun minReplies(minReplies: Long) = minReplies(minReplies as Long?)

        /** Alias for calling [Builder.minReplies] with `minReplies.orElse(null)`. */
        fun minReplies(minReplies: Optional<Long>) = minReplies(minReplies.getOrNull())

        /** Minimum retweets threshold. */
        fun minRetweets(minRetweets: Long?) = apply { this.minRetweets = minRetweets }

        /** Alias for [Builder.minRetweets]. */
        fun minRetweets(minRetweets: Long) = minRetweets(minRetweets as Long?)

        /** Alias for calling [Builder.minRetweets] with `minRetweets.orElse(null)`. */
        fun minRetweets(minRetweets: Optional<Long>) = minRetweets(minRetweets.getOrNull())

        /** Minimum view count threshold. */
        fun minViews(minViews: Long?) = apply { this.minViews = minViews }

        /** Alias for [Builder.minViews]. */
        fun minViews(minViews: Long) = minViews(minViews as Long?)

        /** Alias for calling [Builder.minViews] with `minViews.orElse(null)`. */
        fun minViews(minViews: Optional<Long>) = minViews(minViews.getOrNull())

        /** Only return native reposts. */
        fun nativeRetweets(nativeRetweets: Boolean?) = apply {
            this.nativeRetweets = nativeRetweets
        }

        /** Alias for [Builder.nativeRetweets]. */
        fun nativeRetweets(nativeRetweets: Boolean) = nativeRetweets(nativeRetweets as Boolean?)

        /** Alias for calling [Builder.nativeRetweets] with `nativeRetweets.orElse(null)`. */
        fun nativeRetweets(nativeRetweets: Optional<Boolean>) =
            nativeRetweets(nativeRetweets.getOrNull())

        /**
         * Fields to drop from each row, comma-separated. It takes the same names as fields. With
         * fields, it drops from the kept fields.
         */
        fun omit(omit: String?) = apply { this.omit = omit }

        /** Alias for calling [Builder.omit] with `omit.orElse(null)`. */
        fun omit(omit: Optional<String>) = omit(omit.getOrNull())

        /**
         * Items per page (1-100, default 20). Source, filters or credits can return fewer. Follow
         * next_cursor for more pages. Its aliases are limit, count, max_results, maxItems,
         * max_items & per_page.
         */
        fun pageSize(pageSize: Long?) = apply { this.pageSize = pageSize }

        /** Alias for [Builder.pageSize]. */
        fun pageSize(pageSize: Long) = pageSize(pageSize as Long?)

        /** Alias for calling [Builder.pageSize] with `pageSize.orElse(null)`. */
        fun pageSize(pageSize: Optional<Long>) = pageSize(pageSize.getOrNull())

        /** Only when the caller requests a quote mode. */
        fun quotes(quotes: Quotes?) = apply { this.quotes = quotes }

        /** Alias for calling [Builder.quotes] with `quotes.orElse(null)`. */
        fun quotes(quotes: Optional<Quotes>) = quotes(quotes.getOrNull())

        /** Only quotes of this tweet ID. */
        fun quotesOfTweetId(quotesOfTweetId: String?) = apply {
            this.quotesOfTweetId = quotesOfTweetId
        }

        /** Alias for calling [Builder.quotesOfTweetId] with `quotesOfTweetId.orElse(null)`. */
        fun quotesOfTweetId(quotesOfTweetId: Optional<String>) =
            quotesOfTweetId(quotesOfTweetId.getOrNull())

        /** Reply mode. Exclude keeps own-thread replies. */
        fun replies(replies: Replies?) = apply { this.replies = replies }

        /** Alias for calling [Builder.replies] with `replies.orElse(null)`. */
        fun replies(replies: Optional<Replies>) = replies(replies.getOrNull())

        /** Only when the caller requests a repost mode. */
        fun retweets(retweets: Retweets?) = apply { this.retweets = retweets }

        /** Alias for calling [Builder.retweets] with `retweets.orElse(null)`. */
        fun retweets(retweets: Optional<Retweets>) = retweets(retweets.getOrNull())

        /** Only retweets of this tweet ID. */
        fun retweetsOfTweetId(retweetsOfTweetId: String?) = apply {
            this.retweetsOfTweetId = retweetsOfTweetId
        }

        /** Alias for calling [Builder.retweetsOfTweetId] with `retweetsOfTweetId.orElse(null)`. */
        fun retweetsOfTweetId(retweetsOfTweetId: Optional<String>) =
            retweetsOfTweetId(retweetsOfTweetId.getOrNull())

        /** Start date in YYYY-MM-DD format, as a UTC day. */
        fun sinceDate(sinceDate: LocalDate?) = apply { this.sinceDate = sinceDate }

        /** Alias for calling [Builder.sinceDate] with `sinceDate.orElse(null)`. */
        fun sinceDate(sinceDate: Optional<LocalDate>) = sinceDate(sinceDate.getOrNull())

        /** Return Tweets whose IDs exceed this ID. */
        fun sinceId(sinceId: String?) = apply { this.sinceId = sinceId }

        /** Alias for calling [Builder.sinceId] with `sinceId.orElse(null)`. */
        fun sinceId(sinceId: Optional<String>) = sinceId(sinceId.getOrNull())

        /** Filter replies sent to a username. */
        fun toUser(toUser: String?) = apply { this.toUser = toUser }

        /** Alias for calling [Builder.toUser] with `toUser.orElse(null)`. */
        fun toUser(toUser: Optional<String>) = toUser(toUser.getOrNull())

        /** End date in YYYY-MM-DD format, as a UTC day, inclusive, so its own posts count. */
        fun untilDate(untilDate: LocalDate?) = apply { this.untilDate = untilDate }

        /** Alias for calling [Builder.untilDate] with `untilDate.orElse(null)`. */
        fun untilDate(untilDate: Optional<LocalDate>) = untilDate(untilDate.getOrNull())

        /** URL substring or domain filter. */
        fun url(url: String?) = apply { this.url = url }

        /** Alias for calling [Builder.url] with `url.orElse(null)`. */
        fun url(url: Optional<String>) = url(url.getOrNull())

        /** Only return tweets from verified authors. */
        fun verifiedOnly(verifiedOnly: Boolean?) = apply { this.verifiedOnly = verifiedOnly }

        /** Alias for [Builder.verifiedOnly]. */
        fun verifiedOnly(verifiedOnly: Boolean) = verifiedOnly(verifiedOnly as Boolean?)

        /** Alias for calling [Builder.verifiedOnly] with `verifiedOnly.orElse(null)`. */
        fun verifiedOnly(verifiedOnly: Optional<Boolean>) = verifiedOnly(verifiedOnly.getOrNull())

        /**
         * Keeps Tweets from a recent window, such as 90m or 7d. Use a whole number & s, m, h or d.
         */
        fun withinTime(withinTime: String?) = apply { this.withinTime = withinTime }

        /** Alias for calling [Builder.withinTime] with `withinTime.orElse(null)`. */
        fun withinTime(withinTime: Optional<String>) = withinTime(withinTime.getOrNull())

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [UserRetrieveArticlesParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): UserRetrieveArticlesParams =
            UserRetrieveArticlesParams(
                id,
                anyWords,
                blueVerifiedOnly,
                cashtags,
                conversationId,
                cursor,
                exactPhrase,
                excludeWords,
                fields,
                fromUser,
                hashtags,
                inReplyToTweetId,
                language,
                maxFaves,
                maxId,
                maxQuotes,
                maxReplies,
                maxRetweets,
                mediaType,
                mentioning,
                minBookmarks,
                minLikes,
                minQuotes,
                minReplies,
                minRetweets,
                minViews,
                nativeRetweets,
                omit,
                pageSize,
                quotes,
                quotesOfTweetId,
                replies,
                retweets,
                retweetsOfTweetId,
                sinceDate,
                sinceId,
                toUser,
                untilDate,
                url,
                verifiedOnly,
                withinTime,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> id ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                anyWords?.let { put("anyWords", it) }
                blueVerifiedOnly?.let { put("blueVerifiedOnly", it.toString()) }
                cashtags?.let { put("cashtags", it) }
                conversationId?.let { put("conversationId", it) }
                cursor?.let { put("cursor", it) }
                exactPhrase?.let { put("exactPhrase", it) }
                excludeWords?.let { put("excludeWords", it) }
                fields?.let { put("fields", it) }
                fromUser?.let { put("fromUser", it) }
                hashtags?.let { put("hashtags", it) }
                inReplyToTweetId?.let { put("inReplyToTweetId", it) }
                language?.let { put("language", it) }
                maxFaves?.let { put("maxFaves", it.toString()) }
                maxId?.let { put("maxId", it) }
                maxQuotes?.let { put("maxQuotes", it.toString()) }
                maxReplies?.let { put("maxReplies", it.toString()) }
                maxRetweets?.let { put("maxRetweets", it.toString()) }
                mediaType?.let { put("mediaType", it.toString()) }
                mentioning?.let { put("mentioning", it) }
                minBookmarks?.let { put("minBookmarks", it.toString()) }
                minLikes?.let { put("minLikes", it.toString()) }
                minQuotes?.let { put("minQuotes", it.toString()) }
                minReplies?.let { put("minReplies", it.toString()) }
                minRetweets?.let { put("minRetweets", it.toString()) }
                minViews?.let { put("minViews", it.toString()) }
                nativeRetweets?.let { put("nativeRetweets", it.toString()) }
                omit?.let { put("omit", it) }
                pageSize?.let { put("pageSize", it.toString()) }
                quotes?.let { put("quotes", it.toString()) }
                quotesOfTweetId?.let { put("quotesOfTweetId", it) }
                replies?.let { put("replies", it.toString()) }
                retweets?.let { put("retweets", it.toString()) }
                retweetsOfTweetId?.let { put("retweetsOfTweetId", it) }
                sinceDate?.let { put("sinceDate", it.toString()) }
                sinceId?.let { put("sinceId", it) }
                toUser?.let { put("toUser", it) }
                untilDate?.let { put("untilDate", it.toString()) }
                url?.let { put("url", it) }
                verifiedOnly?.let { put("verifiedOnly", it.toString()) }
                withinTime?.let { put("withinTime", it) }
                putAll(additionalQueryParams)
            }
            .build()

    class MediaType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val IMAGES = of("images")

            @JvmField val VIDEOS = of("videos")

            @JvmField val GIFS = of("gifs")

            @JvmField val MEDIA = of("media")

            @JvmField val LINKS = of("links")

            @JvmField val NONE = of("none")

            @JvmStatic fun of(value: String) = MediaType(JsonField.of(value))
        }

        /** An enum containing [MediaType]'s known values. */
        enum class Known {
            IMAGES,
            VIDEOS,
            GIFS,
            MEDIA,
            LINKS,
            NONE,
        }

        /**
         * An enum containing [MediaType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [MediaType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            IMAGES,
            VIDEOS,
            GIFS,
            MEDIA,
            LINKS,
            NONE,
            /**
             * An enum member indicating that [MediaType] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         */
        fun value(): Value =
            when (this) {
                IMAGES -> Value.IMAGES
                VIDEOS -> Value.VIDEOS
                GIFS -> Value.GIFS
                MEDIA -> Value.MEDIA
                LINKS -> Value.LINKS
                NONE -> Value.NONE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                IMAGES -> Known.IMAGES
                VIDEOS -> Known.VIDEOS
                GIFS -> Known.GIFS
                MEDIA -> Known.MEDIA
                LINKS -> Known.LINKS
                NONE -> Known.NONE
                else -> throw XTwitterScraperInvalidDataException("Unknown MediaType: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
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
        fun validate(): MediaType = apply {
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

        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MediaType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Quotes @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val INCLUDE = of("include")

            @JvmField val EXCLUDE = of("exclude")

            @JvmField val ONLY = of("only")

            @JvmStatic fun of(value: String) = Quotes(JsonField.of(value))
        }

        /** An enum containing [Quotes]'s known values. */
        enum class Known {
            INCLUDE,
            EXCLUDE,
            ONLY,
        }

        /**
         * An enum containing [Quotes]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Quotes] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            INCLUDE,
            EXCLUDE,
            ONLY,
            /** An enum member indicating that [Quotes] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         */
        fun value(): Value =
            when (this) {
                INCLUDE -> Value.INCLUDE
                EXCLUDE -> Value.EXCLUDE
                ONLY -> Value.ONLY
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                INCLUDE -> Known.INCLUDE
                EXCLUDE -> Known.EXCLUDE
                ONLY -> Known.ONLY
                else -> throw XTwitterScraperInvalidDataException("Unknown Quotes: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
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
        fun validate(): Quotes = apply {
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

        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Quotes && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Replies @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val INCLUDE = of("include")

            @JvmField val EXCLUDE = of("exclude")

            @JvmField val ONLY = of("only")

            @JvmStatic fun of(value: String) = Replies(JsonField.of(value))
        }

        /** An enum containing [Replies]'s known values. */
        enum class Known {
            INCLUDE,
            EXCLUDE,
            ONLY,
        }

        /**
         * An enum containing [Replies]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Replies] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            INCLUDE,
            EXCLUDE,
            ONLY,
            /** An enum member indicating that [Replies] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         */
        fun value(): Value =
            when (this) {
                INCLUDE -> Value.INCLUDE
                EXCLUDE -> Value.EXCLUDE
                ONLY -> Value.ONLY
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                INCLUDE -> Known.INCLUDE
                EXCLUDE -> Known.EXCLUDE
                ONLY -> Known.ONLY
                else -> throw XTwitterScraperInvalidDataException("Unknown Replies: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
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
        fun validate(): Replies = apply {
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

        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Replies && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Retweets @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val INCLUDE = of("include")

            @JvmField val EXCLUDE = of("exclude")

            @JvmField val ONLY = of("only")

            @JvmStatic fun of(value: String) = Retweets(JsonField.of(value))
        }

        /** An enum containing [Retweets]'s known values. */
        enum class Known {
            INCLUDE,
            EXCLUDE,
            ONLY,
        }

        /**
         * An enum containing [Retweets]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Retweets] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            INCLUDE,
            EXCLUDE,
            ONLY,
            /** An enum member indicating that [Retweets] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         */
        fun value(): Value =
            when (this) {
                INCLUDE -> Value.INCLUDE
                EXCLUDE -> Value.EXCLUDE
                ONLY -> Value.ONLY
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                INCLUDE -> Known.INCLUDE
                EXCLUDE -> Known.EXCLUDE
                ONLY -> Known.ONLY
                else -> throw XTwitterScraperInvalidDataException("Unknown Retweets: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
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
        fun validate(): Retweets = apply {
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

        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Retweets && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserRetrieveArticlesParams &&
            id == other.id &&
            anyWords == other.anyWords &&
            blueVerifiedOnly == other.blueVerifiedOnly &&
            cashtags == other.cashtags &&
            conversationId == other.conversationId &&
            cursor == other.cursor &&
            exactPhrase == other.exactPhrase &&
            excludeWords == other.excludeWords &&
            fields == other.fields &&
            fromUser == other.fromUser &&
            hashtags == other.hashtags &&
            inReplyToTweetId == other.inReplyToTweetId &&
            language == other.language &&
            maxFaves == other.maxFaves &&
            maxId == other.maxId &&
            maxQuotes == other.maxQuotes &&
            maxReplies == other.maxReplies &&
            maxRetweets == other.maxRetweets &&
            mediaType == other.mediaType &&
            mentioning == other.mentioning &&
            minBookmarks == other.minBookmarks &&
            minLikes == other.minLikes &&
            minQuotes == other.minQuotes &&
            minReplies == other.minReplies &&
            minRetweets == other.minRetweets &&
            minViews == other.minViews &&
            nativeRetweets == other.nativeRetweets &&
            omit == other.omit &&
            pageSize == other.pageSize &&
            quotes == other.quotes &&
            quotesOfTweetId == other.quotesOfTweetId &&
            replies == other.replies &&
            retweets == other.retweets &&
            retweetsOfTweetId == other.retweetsOfTweetId &&
            sinceDate == other.sinceDate &&
            sinceId == other.sinceId &&
            toUser == other.toUser &&
            untilDate == other.untilDate &&
            url == other.url &&
            verifiedOnly == other.verifiedOnly &&
            withinTime == other.withinTime &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            id,
            anyWords,
            blueVerifiedOnly,
            cashtags,
            conversationId,
            cursor,
            exactPhrase,
            excludeWords,
            fields,
            fromUser,
            hashtags,
            inReplyToTweetId,
            language,
            maxFaves,
            maxId,
            maxQuotes,
            maxReplies,
            maxRetweets,
            mediaType,
            mentioning,
            minBookmarks,
            minLikes,
            minQuotes,
            minReplies,
            minRetweets,
            minViews,
            nativeRetweets,
            omit,
            pageSize,
            quotes,
            quotesOfTweetId,
            replies,
            retweets,
            retweetsOfTweetId,
            sinceDate,
            sinceId,
            toUser,
            untilDate,
            url,
            verifiedOnly,
            withinTime,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "UserRetrieveArticlesParams{id=$id, anyWords=$anyWords, blueVerifiedOnly=$blueVerifiedOnly, cashtags=$cashtags, conversationId=$conversationId, cursor=$cursor, exactPhrase=$exactPhrase, excludeWords=$excludeWords, fields=$fields, fromUser=$fromUser, hashtags=$hashtags, inReplyToTweetId=$inReplyToTweetId, language=$language, maxFaves=$maxFaves, maxId=$maxId, maxQuotes=$maxQuotes, maxReplies=$maxReplies, maxRetweets=$maxRetweets, mediaType=$mediaType, mentioning=$mentioning, minBookmarks=$minBookmarks, minLikes=$minLikes, minQuotes=$minQuotes, minReplies=$minReplies, minRetweets=$minRetweets, minViews=$minViews, nativeRetweets=$nativeRetweets, omit=$omit, pageSize=$pageSize, quotes=$quotes, quotesOfTweetId=$quotesOfTweetId, replies=$replies, retweets=$retweets, retweetsOfTweetId=$retweetsOfTweetId, sinceDate=$sinceDate, sinceId=$sinceId, toUser=$toUser, untilDate=$untilDate, url=$url, verifiedOnly=$verifiedOnly, withinTime=$withinTime, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
