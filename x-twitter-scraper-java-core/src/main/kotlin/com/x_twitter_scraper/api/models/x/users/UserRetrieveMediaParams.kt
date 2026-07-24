// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

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

/** List media tweets posted by a user */
class UserRetrieveMediaParams
private constructor(
    private val id: String?,
    private val anyWords: String?,
    private val cashtags: String?,
    private val conversationId: String?,
    private val cursor: String?,
    private val exactPhrase: String?,
    private val excludeWords: String?,
    private val fromUser: String?,
    private val hashtags: String?,
    private val inReplyToTweetId: String?,
    private val language: String?,
    private val mediaType: MediaType?,
    private val mentioning: String?,
    private val minFaves: Long?,
    private val minQuotes: Long?,
    private val minReplies: Long?,
    private val minRetweets: Long?,
    private val pageSize: Long?,
    private val quotes: Quotes?,
    private val quotesOfTweetId: String?,
    private val replies: Replies?,
    private val retweets: Retweets?,
    private val retweetsOfTweetId: String?,
    private val sinceDate: LocalDate?,
    private val toUser: String?,
    private val untilDate: LocalDate?,
    private val url: String?,
    private val verifiedOnly: Boolean?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun id(): Optional<String> = Optional.ofNullable(id)

    /** Words or quoted phrases where any one can match. Separate with spaces, commas, or lines. */
    fun anyWords(): Optional<String> = Optional.ofNullable(anyWords)

    /** Cashtags separated by spaces, commas, or lines. */
    fun cashtags(): Optional<String> = Optional.ofNullable(cashtags)

    /** Conversation ID filter. */
    fun conversationId(): Optional<String> = Optional.ofNullable(conversationId)

    /** Pagination cursor for media tweets */
    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    /** Exact phrase to match. */
    fun exactPhrase(): Optional<String> = Optional.ofNullable(exactPhrase)

    /** Words or quoted phrases to exclude. Separate with spaces, commas, or lines. */
    fun excludeWords(): Optional<String> = Optional.ofNullable(excludeWords)

    /** Filter by author username. */
    fun fromUser(): Optional<String> = Optional.ofNullable(fromUser)

    /** Hashtags separated by spaces, commas, or lines. */
    fun hashtags(): Optional<String> = Optional.ofNullable(hashtags)

    /** Only replies to this tweet ID. */
    fun inReplyToTweetId(): Optional<String> = Optional.ofNullable(inReplyToTweetId)

    /** Language code filter, e.g. en or tr. */
    fun language(): Optional<String> = Optional.ofNullable(language)

    /** Filter by media type. */
    fun mediaType(): Optional<MediaType> = Optional.ofNullable(mediaType)

    /** Filter tweets mentioning a username. */
    fun mentioning(): Optional<String> = Optional.ofNullable(mentioning)

    /** Minimum likes threshold. */
    fun minFaves(): Optional<Long> = Optional.ofNullable(minFaves)

    /** Minimum quote count threshold. */
    fun minQuotes(): Optional<Long> = Optional.ofNullable(minQuotes)

    /** Minimum replies threshold. */
    fun minReplies(): Optional<Long> = Optional.ofNullable(minReplies)

    /** Minimum retweets threshold. */
    fun minRetweets(): Optional<Long> = Optional.ofNullable(minRetweets)

    /**
     * Maximum items requested from this page (1-100, default 20). The response can contain fewer
     * items because the source returned fewer, filters removed items, or remaining credits cover
     * fewer results. Keep requesting next_cursor while has_next_page is true, even when a page is
     * empty. The deprecated limit and count aliases remain accepted.
     */
    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    /** Quote mode. */
    fun quotes(): Optional<Quotes> = Optional.ofNullable(quotes)

    /** Only quotes of this tweet ID. */
    fun quotesOfTweetId(): Optional<String> = Optional.ofNullable(quotesOfTweetId)

    /** Reply mode. */
    fun replies(): Optional<Replies> = Optional.ofNullable(replies)

    /** Retweet mode. */
    fun retweets(): Optional<Retweets> = Optional.ofNullable(retweets)

    /** Only retweets of this tweet ID. */
    fun retweetsOfTweetId(): Optional<String> = Optional.ofNullable(retweetsOfTweetId)

    /** Start date in YYYY-MM-DD format. */
    fun sinceDate(): Optional<LocalDate> = Optional.ofNullable(sinceDate)

    /** Filter replies sent to a username. */
    fun toUser(): Optional<String> = Optional.ofNullable(toUser)

    /** End date in YYYY-MM-DD format. */
    fun untilDate(): Optional<LocalDate> = Optional.ofNullable(untilDate)

    /** URL substring or domain filter. */
    fun url(): Optional<String> = Optional.ofNullable(url)

    /** Only return tweets from verified authors. */
    fun verifiedOnly(): Optional<Boolean> = Optional.ofNullable(verifiedOnly)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): UserRetrieveMediaParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [UserRetrieveMediaParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserRetrieveMediaParams]. */
    class Builder internal constructor() {

        private var id: String? = null
        private var anyWords: String? = null
        private var cashtags: String? = null
        private var conversationId: String? = null
        private var cursor: String? = null
        private var exactPhrase: String? = null
        private var excludeWords: String? = null
        private var fromUser: String? = null
        private var hashtags: String? = null
        private var inReplyToTweetId: String? = null
        private var language: String? = null
        private var mediaType: MediaType? = null
        private var mentioning: String? = null
        private var minFaves: Long? = null
        private var minQuotes: Long? = null
        private var minReplies: Long? = null
        private var minRetweets: Long? = null
        private var pageSize: Long? = null
        private var quotes: Quotes? = null
        private var quotesOfTweetId: String? = null
        private var replies: Replies? = null
        private var retweets: Retweets? = null
        private var retweetsOfTweetId: String? = null
        private var sinceDate: LocalDate? = null
        private var toUser: String? = null
        private var untilDate: LocalDate? = null
        private var url: String? = null
        private var verifiedOnly: Boolean? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(userRetrieveMediaParams: UserRetrieveMediaParams) = apply {
            id = userRetrieveMediaParams.id
            anyWords = userRetrieveMediaParams.anyWords
            cashtags = userRetrieveMediaParams.cashtags
            conversationId = userRetrieveMediaParams.conversationId
            cursor = userRetrieveMediaParams.cursor
            exactPhrase = userRetrieveMediaParams.exactPhrase
            excludeWords = userRetrieveMediaParams.excludeWords
            fromUser = userRetrieveMediaParams.fromUser
            hashtags = userRetrieveMediaParams.hashtags
            inReplyToTweetId = userRetrieveMediaParams.inReplyToTweetId
            language = userRetrieveMediaParams.language
            mediaType = userRetrieveMediaParams.mediaType
            mentioning = userRetrieveMediaParams.mentioning
            minFaves = userRetrieveMediaParams.minFaves
            minQuotes = userRetrieveMediaParams.minQuotes
            minReplies = userRetrieveMediaParams.minReplies
            minRetweets = userRetrieveMediaParams.minRetweets
            pageSize = userRetrieveMediaParams.pageSize
            quotes = userRetrieveMediaParams.quotes
            quotesOfTweetId = userRetrieveMediaParams.quotesOfTweetId
            replies = userRetrieveMediaParams.replies
            retweets = userRetrieveMediaParams.retweets
            retweetsOfTweetId = userRetrieveMediaParams.retweetsOfTweetId
            sinceDate = userRetrieveMediaParams.sinceDate
            toUser = userRetrieveMediaParams.toUser
            untilDate = userRetrieveMediaParams.untilDate
            url = userRetrieveMediaParams.url
            verifiedOnly = userRetrieveMediaParams.verifiedOnly
            additionalHeaders = userRetrieveMediaParams.additionalHeaders.toBuilder()
            additionalQueryParams = userRetrieveMediaParams.additionalQueryParams.toBuilder()
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

        /** Cashtags separated by spaces, commas, or lines. */
        fun cashtags(cashtags: String?) = apply { this.cashtags = cashtags }

        /** Alias for calling [Builder.cashtags] with `cashtags.orElse(null)`. */
        fun cashtags(cashtags: Optional<String>) = cashtags(cashtags.getOrNull())

        /** Conversation ID filter. */
        fun conversationId(conversationId: String?) = apply { this.conversationId = conversationId }

        /** Alias for calling [Builder.conversationId] with `conversationId.orElse(null)`. */
        fun conversationId(conversationId: Optional<String>) =
            conversationId(conversationId.getOrNull())

        /** Pagination cursor for media tweets */
        fun cursor(cursor: String?) = apply { this.cursor = cursor }

        /** Alias for calling [Builder.cursor] with `cursor.orElse(null)`. */
        fun cursor(cursor: Optional<String>) = cursor(cursor.getOrNull())

        /** Exact phrase to match. */
        fun exactPhrase(exactPhrase: String?) = apply { this.exactPhrase = exactPhrase }

        /** Alias for calling [Builder.exactPhrase] with `exactPhrase.orElse(null)`. */
        fun exactPhrase(exactPhrase: Optional<String>) = exactPhrase(exactPhrase.getOrNull())

        /** Words or quoted phrases to exclude. Separate with spaces, commas, or lines. */
        fun excludeWords(excludeWords: String?) = apply { this.excludeWords = excludeWords }

        /** Alias for calling [Builder.excludeWords] with `excludeWords.orElse(null)`. */
        fun excludeWords(excludeWords: Optional<String>) = excludeWords(excludeWords.getOrNull())

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

        /** Language code filter, e.g. en or tr. */
        fun language(language: String?) = apply { this.language = language }

        /** Alias for calling [Builder.language] with `language.orElse(null)`. */
        fun language(language: Optional<String>) = language(language.getOrNull())

        /** Filter by media type. */
        fun mediaType(mediaType: MediaType?) = apply { this.mediaType = mediaType }

        /** Alias for calling [Builder.mediaType] with `mediaType.orElse(null)`. */
        fun mediaType(mediaType: Optional<MediaType>) = mediaType(mediaType.getOrNull())

        /** Filter tweets mentioning a username. */
        fun mentioning(mentioning: String?) = apply { this.mentioning = mentioning }

        /** Alias for calling [Builder.mentioning] with `mentioning.orElse(null)`. */
        fun mentioning(mentioning: Optional<String>) = mentioning(mentioning.getOrNull())

        /** Minimum likes threshold. */
        fun minFaves(minFaves: Long?) = apply { this.minFaves = minFaves }

        /**
         * Alias for [Builder.minFaves].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun minFaves(minFaves: Long) = minFaves(minFaves as Long?)

        /** Alias for calling [Builder.minFaves] with `minFaves.orElse(null)`. */
        fun minFaves(minFaves: Optional<Long>) = minFaves(minFaves.getOrNull())

        /** Minimum quote count threshold. */
        fun minQuotes(minQuotes: Long?) = apply { this.minQuotes = minQuotes }

        /**
         * Alias for [Builder.minQuotes].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun minQuotes(minQuotes: Long) = minQuotes(minQuotes as Long?)

        /** Alias for calling [Builder.minQuotes] with `minQuotes.orElse(null)`. */
        fun minQuotes(minQuotes: Optional<Long>) = minQuotes(minQuotes.getOrNull())

        /** Minimum replies threshold. */
        fun minReplies(minReplies: Long?) = apply { this.minReplies = minReplies }

        /**
         * Alias for [Builder.minReplies].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun minReplies(minReplies: Long) = minReplies(minReplies as Long?)

        /** Alias for calling [Builder.minReplies] with `minReplies.orElse(null)`. */
        fun minReplies(minReplies: Optional<Long>) = minReplies(minReplies.getOrNull())

        /** Minimum retweets threshold. */
        fun minRetweets(minRetweets: Long?) = apply { this.minRetweets = minRetweets }

        /**
         * Alias for [Builder.minRetweets].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun minRetweets(minRetweets: Long) = minRetweets(minRetweets as Long?)

        /** Alias for calling [Builder.minRetweets] with `minRetweets.orElse(null)`. */
        fun minRetweets(minRetweets: Optional<Long>) = minRetweets(minRetweets.getOrNull())

        /**
         * Maximum items requested from this page (1-100, default 20). The response can contain
         * fewer items because the source returned fewer, filters removed items, or remaining
         * credits cover fewer results. Keep requesting next_cursor while has_next_page is true,
         * even when a page is empty. The deprecated limit and count aliases remain accepted.
         */
        fun pageSize(pageSize: Long?) = apply { this.pageSize = pageSize }

        /**
         * Alias for [Builder.pageSize].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun pageSize(pageSize: Long) = pageSize(pageSize as Long?)

        /** Alias for calling [Builder.pageSize] with `pageSize.orElse(null)`. */
        fun pageSize(pageSize: Optional<Long>) = pageSize(pageSize.getOrNull())

        /** Quote mode. */
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

        /** Reply mode. */
        fun replies(replies: Replies?) = apply { this.replies = replies }

        /** Alias for calling [Builder.replies] with `replies.orElse(null)`. */
        fun replies(replies: Optional<Replies>) = replies(replies.getOrNull())

        /** Retweet mode. */
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

        /** Start date in YYYY-MM-DD format. */
        fun sinceDate(sinceDate: LocalDate?) = apply { this.sinceDate = sinceDate }

        /** Alias for calling [Builder.sinceDate] with `sinceDate.orElse(null)`. */
        fun sinceDate(sinceDate: Optional<LocalDate>) = sinceDate(sinceDate.getOrNull())

        /** Filter replies sent to a username. */
        fun toUser(toUser: String?) = apply { this.toUser = toUser }

        /** Alias for calling [Builder.toUser] with `toUser.orElse(null)`. */
        fun toUser(toUser: Optional<String>) = toUser(toUser.getOrNull())

        /** End date in YYYY-MM-DD format. */
        fun untilDate(untilDate: LocalDate?) = apply { this.untilDate = untilDate }

        /** Alias for calling [Builder.untilDate] with `untilDate.orElse(null)`. */
        fun untilDate(untilDate: Optional<LocalDate>) = untilDate(untilDate.getOrNull())

        /** URL substring or domain filter. */
        fun url(url: String?) = apply { this.url = url }

        /** Alias for calling [Builder.url] with `url.orElse(null)`. */
        fun url(url: Optional<String>) = url(url.getOrNull())

        /** Only return tweets from verified authors. */
        fun verifiedOnly(verifiedOnly: Boolean?) = apply { this.verifiedOnly = verifiedOnly }

        /**
         * Alias for [Builder.verifiedOnly].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun verifiedOnly(verifiedOnly: Boolean) = verifiedOnly(verifiedOnly as Boolean?)

        /** Alias for calling [Builder.verifiedOnly] with `verifiedOnly.orElse(null)`. */
        fun verifiedOnly(verifiedOnly: Optional<Boolean>) = verifiedOnly(verifiedOnly.getOrNull())

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
         * Returns an immutable instance of [UserRetrieveMediaParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): UserRetrieveMediaParams =
            UserRetrieveMediaParams(
                id,
                anyWords,
                cashtags,
                conversationId,
                cursor,
                exactPhrase,
                excludeWords,
                fromUser,
                hashtags,
                inReplyToTweetId,
                language,
                mediaType,
                mentioning,
                minFaves,
                minQuotes,
                minReplies,
                minRetweets,
                pageSize,
                quotes,
                quotesOfTweetId,
                replies,
                retweets,
                retweetsOfTweetId,
                sinceDate,
                toUser,
                untilDate,
                url,
                verifiedOnly,
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
                cashtags?.let { put("cashtags", it) }
                conversationId?.let { put("conversationId", it) }
                cursor?.let { put("cursor", it) }
                exactPhrase?.let { put("exactPhrase", it) }
                excludeWords?.let { put("excludeWords", it) }
                fromUser?.let { put("fromUser", it) }
                hashtags?.let { put("hashtags", it) }
                inReplyToTweetId?.let { put("inReplyToTweetId", it) }
                language?.let { put("language", it) }
                mediaType?.let { put("mediaType", it.toString()) }
                mentioning?.let { put("mentioning", it) }
                minFaves?.let { put("minFaves", it.toString()) }
                minQuotes?.let { put("minQuotes", it.toString()) }
                minReplies?.let { put("minReplies", it.toString()) }
                minRetweets?.let { put("minRetweets", it.toString()) }
                pageSize?.let { put("pageSize", it.toString()) }
                quotes?.let { put("quotes", it.toString()) }
                quotesOfTweetId?.let { put("quotesOfTweetId", it) }
                replies?.let { put("replies", it.toString()) }
                retweets?.let { put("retweets", it.toString()) }
                retweetsOfTweetId?.let { put("retweetsOfTweetId", it) }
                sinceDate?.let { put("sinceDate", it.toString()) }
                toUser?.let { put("toUser", it) }
                untilDate?.let { put("untilDate", it.toString()) }
                url?.let { put("url", it) }
                verifiedOnly?.let { put("verifiedOnly", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    /** Filter by media type. */
    class MediaType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
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
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
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
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
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

            return other is MediaType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Quote mode. */
    class Quotes @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
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
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
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
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
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

            return other is Quotes && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Reply mode. */
    class Replies @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
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
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
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
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
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

            return other is Replies && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Retweet mode. */
    class Retweets @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
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
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
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
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
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

            return other is Retweets && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserRetrieveMediaParams &&
            id == other.id &&
            anyWords == other.anyWords &&
            cashtags == other.cashtags &&
            conversationId == other.conversationId &&
            cursor == other.cursor &&
            exactPhrase == other.exactPhrase &&
            excludeWords == other.excludeWords &&
            fromUser == other.fromUser &&
            hashtags == other.hashtags &&
            inReplyToTweetId == other.inReplyToTweetId &&
            language == other.language &&
            mediaType == other.mediaType &&
            mentioning == other.mentioning &&
            minFaves == other.minFaves &&
            minQuotes == other.minQuotes &&
            minReplies == other.minReplies &&
            minRetweets == other.minRetweets &&
            pageSize == other.pageSize &&
            quotes == other.quotes &&
            quotesOfTweetId == other.quotesOfTweetId &&
            replies == other.replies &&
            retweets == other.retweets &&
            retweetsOfTweetId == other.retweetsOfTweetId &&
            sinceDate == other.sinceDate &&
            toUser == other.toUser &&
            untilDate == other.untilDate &&
            url == other.url &&
            verifiedOnly == other.verifiedOnly &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            id,
            anyWords,
            cashtags,
            conversationId,
            cursor,
            exactPhrase,
            excludeWords,
            fromUser,
            hashtags,
            inReplyToTweetId,
            language,
            mediaType,
            mentioning,
            minFaves,
            minQuotes,
            minReplies,
            minRetweets,
            pageSize,
            quotes,
            quotesOfTweetId,
            replies,
            retweets,
            retweetsOfTweetId,
            sinceDate,
            toUser,
            untilDate,
            url,
            verifiedOnly,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "UserRetrieveMediaParams{id=$id, anyWords=$anyWords, cashtags=$cashtags, conversationId=$conversationId, cursor=$cursor, exactPhrase=$exactPhrase, excludeWords=$excludeWords, fromUser=$fromUser, hashtags=$hashtags, inReplyToTweetId=$inReplyToTweetId, language=$language, mediaType=$mediaType, mentioning=$mentioning, minFaves=$minFaves, minQuotes=$minQuotes, minReplies=$minReplies, minRetweets=$minRetweets, pageSize=$pageSize, quotes=$quotes, quotesOfTweetId=$quotesOfTweetId, replies=$replies, retweets=$retweets, retweetsOfTweetId=$retweetsOfTweetId, sinceDate=$sinceDate, toUser=$toUser, untilDate=$untilDate, url=$url, verifiedOnly=$verifiedOnly, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
