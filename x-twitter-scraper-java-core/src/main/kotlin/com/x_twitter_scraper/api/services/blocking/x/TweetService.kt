// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.PaginatedUsers
import com.x_twitter_scraper.api.models.x.tweets.TweetCheckRepostParams
import com.x_twitter_scraper.api.models.x.tweets.TweetCheckRepostResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetCreateParams
import com.x_twitter_scraper.api.models.x.tweets.TweetCreateResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetDeleteParams
import com.x_twitter_scraper.api.models.x.tweets.TweetDeleteResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetEmbedParams
import com.x_twitter_scraper.api.models.x.tweets.TweetEmbedResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetFavoritersParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetHiddenRepliesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetInsightsParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetInsightsResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetQuotesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRepliesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRepliesResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRetweeterIdsParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRetweeterIdsResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRetweetersParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetSubtitlesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetSubtitlesResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetThreadParams
import com.x_twitter_scraper.api.models.x.tweets.TweetListParams
import com.x_twitter_scraper.api.models.x.tweets.TweetListTopParams
import com.x_twitter_scraper.api.models.x.tweets.TweetResolveLinksParams
import com.x_twitter_scraper.api.models.x.tweets.TweetResolveLinksResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetRetrieveParams
import com.x_twitter_scraper.api.models.x.tweets.TweetRetrieveResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchParams
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetTranslateParams
import com.x_twitter_scraper.api.models.x.tweets.TweetTranslateResponse
import com.x_twitter_scraper.api.services.blocking.x.tweets.LikeService
import com.x_twitter_scraper.api.services.blocking.x.tweets.RetweetService
import java.util.function.Consumer

interface TweetService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TweetService

    /** X write actions (tweets, likes, follows, DMs) */
    fun like(): LikeService

    /** X write actions (tweets, likes, follows, DMs) */
    fun retweet(): RetweetService

    /** Create tweet */
    fun create(params: TweetCreateParams): TweetCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: TweetCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetCreateResponse

    /** Get tweet with full text, author, metrics and media */
    fun retrieve(id: String): TweetRetrieveResponse = retrieve(id, TweetRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TweetRetrieveParams = TweetRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TweetRetrieveParams = TweetRetrieveParams.none(),
    ): TweetRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: TweetRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: TweetRetrieveParams): TweetRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): TweetRetrieveResponse =
        retrieve(id, TweetRetrieveParams.none(), requestOptions)

    /** Get multiple tweets by IDs */
    fun list(params: TweetListParams): PaginatedTweets = list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TweetListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets

    /** Delete tweet */
    fun delete(id: String, params: TweetDeleteParams): TweetDeleteResponse =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        params: TweetDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetDeleteResponse = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(params: TweetDeleteParams): TweetDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: TweetDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetDeleteResponse

    /**
     * Returns whether 1 account reposted the post, read from its newest posts. A repost older than
     * the posts read returns false with complete false. Each check costs 1 credit.
     */
    fun checkRepost(id: String, params: TweetCheckRepostParams): TweetCheckRepostResponse =
        checkRepost(id, params, RequestOptions.none())

    /** @see checkRepost */
    fun checkRepost(
        id: String,
        params: TweetCheckRepostParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetCheckRepostResponse = checkRepost(params.toBuilder().id(id).build(), requestOptions)

    /** @see checkRepost */
    fun checkRepost(params: TweetCheckRepostParams): TweetCheckRepostResponse =
        checkRepost(params, RequestOptions.none())

    /** @see checkRepost */
    fun checkRepost(
        params: TweetCheckRepostParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetCheckRepostResponse

    /**
     * Returns the HTML that X gives websites to embed 1 public tweet, with the tweet's link and
     * author.
     */
    fun embed(id: String): TweetEmbedResponse = embed(id, TweetEmbedParams.none())

    /** @see embed */
    fun embed(
        id: String,
        params: TweetEmbedParams = TweetEmbedParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetEmbedResponse = embed(params.toBuilder().id(id).build(), requestOptions)

    /** @see embed */
    fun embed(id: String, params: TweetEmbedParams = TweetEmbedParams.none()): TweetEmbedResponse =
        embed(id, params, RequestOptions.none())

    /** @see embed */
    fun embed(
        params: TweetEmbedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetEmbedResponse

    /** @see embed */
    fun embed(params: TweetEmbedParams): TweetEmbedResponse = embed(params, RequestOptions.none())

    /** @see embed */
    fun embed(id: String, requestOptions: RequestOptions): TweetEmbedResponse =
        embed(id, TweetEmbedParams.none(), requestOptions)

    /**
     * Returns liker profiles that X makes visible for the post. X can withhold liker identities
     * even when the post reports likes. In that case this endpoint returns 424
     * `favoriters_unavailable` instead of a misleading empty success.
     */
    fun getFavoriters(id: String): PaginatedUsers =
        getFavoriters(id, TweetGetFavoritersParams.none())

    /** @see getFavoriters */
    fun getFavoriters(
        id: String,
        params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers = getFavoriters(params.toBuilder().id(id).build(), requestOptions)

    /** @see getFavoriters */
    fun getFavoriters(
        id: String,
        params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
    ): PaginatedUsers = getFavoriters(id, params, RequestOptions.none())

    /** @see getFavoriters */
    fun getFavoriters(
        params: TweetGetFavoritersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers

    /** @see getFavoriters */
    fun getFavoriters(params: TweetGetFavoritersParams): PaginatedUsers =
        getFavoriters(params, RequestOptions.none())

    /** @see getFavoriters */
    fun getFavoriters(id: String, requestOptions: RequestOptions): PaginatedUsers =
        getFavoriters(id, TweetGetFavoritersParams.none(), requestOptions)

    /**
     * Returns the replies the post's author hid, oldest first, with the replies to them. A post
     * without hidden replies returns an empty list.
     */
    fun getHiddenReplies(id: String): PaginatedTweets =
        getHiddenReplies(id, TweetGetHiddenRepliesParams.none())

    /** @see getHiddenReplies */
    fun getHiddenReplies(
        id: String,
        params: TweetGetHiddenRepliesParams = TweetGetHiddenRepliesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets = getHiddenReplies(params.toBuilder().id(id).build(), requestOptions)

    /** @see getHiddenReplies */
    fun getHiddenReplies(
        id: String,
        params: TweetGetHiddenRepliesParams = TweetGetHiddenRepliesParams.none(),
    ): PaginatedTweets = getHiddenReplies(id, params, RequestOptions.none())

    /** @see getHiddenReplies */
    fun getHiddenReplies(
        params: TweetGetHiddenRepliesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets

    /** @see getHiddenReplies */
    fun getHiddenReplies(params: TweetGetHiddenRepliesParams): PaginatedTweets =
        getHiddenReplies(params, RequestOptions.none())

    /** @see getHiddenReplies */
    fun getHiddenReplies(id: String, requestOptions: RequestOptions): PaginatedTweets =
        getHiddenReplies(id, TweetGetHiddenRepliesParams.none(), requestOptions)

    /**
     * Returns engagement insights for 1 tweet. They are engagements per hour since it went up, per
     * view and per follower of its author, and how far it spread. Each report costs 1 credit,
     * whatever it reads.
     */
    fun getInsights(id: String): TweetGetInsightsResponse =
        getInsights(id, TweetGetInsightsParams.none())

    /** @see getInsights */
    fun getInsights(
        id: String,
        params: TweetGetInsightsParams = TweetGetInsightsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetGetInsightsResponse = getInsights(params.toBuilder().id(id).build(), requestOptions)

    /** @see getInsights */
    fun getInsights(
        id: String,
        params: TweetGetInsightsParams = TweetGetInsightsParams.none(),
    ): TweetGetInsightsResponse = getInsights(id, params, RequestOptions.none())

    /** @see getInsights */
    fun getInsights(
        params: TweetGetInsightsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetGetInsightsResponse

    /** @see getInsights */
    fun getInsights(params: TweetGetInsightsParams): TweetGetInsightsResponse =
        getInsights(params, RequestOptions.none())

    /** @see getInsights */
    fun getInsights(id: String, requestOptions: RequestOptions): TweetGetInsightsResponse =
        getInsights(id, TweetGetInsightsParams.none(), requestOptions)

    /** List quote tweets of a tweet */
    fun getQuotes(id: String): PaginatedTweets = getQuotes(id, TweetGetQuotesParams.none())

    /** @see getQuotes */
    fun getQuotes(
        id: String,
        params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets = getQuotes(params.toBuilder().id(id).build(), requestOptions)

    /** @see getQuotes */
    fun getQuotes(
        id: String,
        params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
    ): PaginatedTweets = getQuotes(id, params, RequestOptions.none())

    /** @see getQuotes */
    fun getQuotes(
        params: TweetGetQuotesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets

    /** @see getQuotes */
    fun getQuotes(params: TweetGetQuotesParams): PaginatedTweets =
        getQuotes(params, RequestOptions.none())

    /** @see getQuotes */
    fun getQuotes(id: String, requestOptions: RequestOptions): PaginatedTweets =
        getQuotes(id, TweetGetQuotesParams.none(), requestOptions)

    /**
     * Returns direct replies. Omit mode for automatic maximum coverage with resumable pagination.
     * Complete mode returns nested replies, diagnostics, and 424 when direct coverage stays below
     * 80%.
     */
    fun getReplies(id: String): TweetGetRepliesResponse =
        getReplies(id, TweetGetRepliesParams.none())

    /** @see getReplies */
    fun getReplies(
        id: String,
        params: TweetGetRepliesParams = TweetGetRepliesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetGetRepliesResponse = getReplies(params.toBuilder().id(id).build(), requestOptions)

    /** @see getReplies */
    fun getReplies(
        id: String,
        params: TweetGetRepliesParams = TweetGetRepliesParams.none(),
    ): TweetGetRepliesResponse = getReplies(id, params, RequestOptions.none())

    /** @see getReplies */
    fun getReplies(
        params: TweetGetRepliesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetGetRepliesResponse

    /** @see getReplies */
    fun getReplies(params: TweetGetRepliesParams): TweetGetRepliesResponse =
        getReplies(params, RequestOptions.none())

    /** @see getReplies */
    fun getReplies(id: String, requestOptions: RequestOptions): TweetGetRepliesResponse =
        getReplies(id, TweetGetRepliesParams.none(), requestOptions)

    /**
     * Returns the user IDs of a post's reposters, in the order & pages of
     * /x/tweets/{id}/retweeters. Use it when you need IDs only. Each ID costs 1 credit. A post
     * nobody reposted returns an empty list for free.
     */
    fun getRetweeterIds(id: String): TweetGetRetweeterIdsResponse =
        getRetweeterIds(id, TweetGetRetweeterIdsParams.none())

    /** @see getRetweeterIds */
    fun getRetweeterIds(
        id: String,
        params: TweetGetRetweeterIdsParams = TweetGetRetweeterIdsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetGetRetweeterIdsResponse =
        getRetweeterIds(params.toBuilder().id(id).build(), requestOptions)

    /** @see getRetweeterIds */
    fun getRetweeterIds(
        id: String,
        params: TweetGetRetweeterIdsParams = TweetGetRetweeterIdsParams.none(),
    ): TweetGetRetweeterIdsResponse = getRetweeterIds(id, params, RequestOptions.none())

    /** @see getRetweeterIds */
    fun getRetweeterIds(
        params: TweetGetRetweeterIdsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetGetRetweeterIdsResponse

    /** @see getRetweeterIds */
    fun getRetweeterIds(params: TweetGetRetweeterIdsParams): TweetGetRetweeterIdsResponse =
        getRetweeterIds(params, RequestOptions.none())

    /** @see getRetweeterIds */
    fun getRetweeterIds(id: String, requestOptions: RequestOptions): TweetGetRetweeterIdsResponse =
        getRetweeterIds(id, TweetGetRetweeterIdsParams.none(), requestOptions)

    /** List users who retweeted a tweet */
    fun getRetweeters(id: String): PaginatedUsers =
        getRetweeters(id, TweetGetRetweetersParams.none())

    /** @see getRetweeters */
    fun getRetweeters(
        id: String,
        params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers = getRetweeters(params.toBuilder().id(id).build(), requestOptions)

    /** @see getRetweeters */
    fun getRetweeters(
        id: String,
        params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
    ): PaginatedUsers = getRetweeters(id, params, RequestOptions.none())

    /** @see getRetweeters */
    fun getRetweeters(
        params: TweetGetRetweetersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedUsers

    /** @see getRetweeters */
    fun getRetweeters(params: TweetGetRetweetersParams): PaginatedUsers =
        getRetweeters(params, RequestOptions.none())

    /** @see getRetweeters */
    fun getRetweeters(id: String, requestOptions: RequestOptions): PaginatedUsers =
        getRetweeters(id, TweetGetRetweetersParams.none(), requestOptions)

    /**
     * Returns the caption tracks of 1 public tweet's videos, as X's player reads them. Each track
     * has its language, name, timed cues, and full text. A tweet without video, or a video without
     * captions, returns no track and costs nothing.
     */
    fun getSubtitles(id: String): TweetGetSubtitlesResponse =
        getSubtitles(id, TweetGetSubtitlesParams.none())

    /** @see getSubtitles */
    fun getSubtitles(
        id: String,
        params: TweetGetSubtitlesParams = TweetGetSubtitlesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetGetSubtitlesResponse = getSubtitles(params.toBuilder().id(id).build(), requestOptions)

    /** @see getSubtitles */
    fun getSubtitles(
        id: String,
        params: TweetGetSubtitlesParams = TweetGetSubtitlesParams.none(),
    ): TweetGetSubtitlesResponse = getSubtitles(id, params, RequestOptions.none())

    /** @see getSubtitles */
    fun getSubtitles(
        params: TweetGetSubtitlesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetGetSubtitlesResponse

    /** @see getSubtitles */
    fun getSubtitles(params: TweetGetSubtitlesParams): TweetGetSubtitlesResponse =
        getSubtitles(params, RequestOptions.none())

    /** @see getSubtitles */
    fun getSubtitles(id: String, requestOptions: RequestOptions): TweetGetSubtitlesResponse =
        getSubtitles(id, TweetGetSubtitlesParams.none(), requestOptions)

    /** Get full conversation thread for a tweet */
    fun getThread(id: String): PaginatedTweets = getThread(id, TweetGetThreadParams.none())

    /** @see getThread */
    fun getThread(
        id: String,
        params: TweetGetThreadParams = TweetGetThreadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets = getThread(params.toBuilder().id(id).build(), requestOptions)

    /** @see getThread */
    fun getThread(
        id: String,
        params: TweetGetThreadParams = TweetGetThreadParams.none(),
    ): PaginatedTweets = getThread(id, params, RequestOptions.none())

    /** @see getThread */
    fun getThread(
        params: TweetGetThreadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets

    /** @see getThread */
    fun getThread(params: TweetGetThreadParams): PaginatedTweets =
        getThread(params, RequestOptions.none())

    /** @see getThread */
    fun getThread(id: String, requestOptions: RequestOptions): PaginatedTweets =
        getThread(id, TweetGetThreadParams.none(), requestOptions)

    /**
     * Returns the tweets X ranks highest by 1 metric over the last day, week or month, as x.com's
     * Inspiration page shows them. Covers all of X unless you pick a country or a language. Pages
     * hold up to 20 tweets, and the list ends at 100. Each tweet costs 1 credit.
     */
    fun listTop(): PaginatedTweets = listTop(TweetListTopParams.none())

    /** @see listTop */
    fun listTop(
        params: TweetListTopParams = TweetListTopParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets

    /** @see listTop */
    fun listTop(params: TweetListTopParams = TweetListTopParams.none()): PaginatedTweets =
        listTop(params, RequestOptions.none())

    /** @see listTop */
    fun listTop(requestOptions: RequestOptions): PaginatedTweets =
        listTop(TweetListTopParams.none(), requestOptions)

    /**
     * Returns where each t.co link leads, as X's own redirect says. Xquik reads the redirect and
     * never visits the target site. A link t.co does not have comes back without `resolvedUrl` and
     * costs nothing. A link X does not answer for in time comes back in `unprocessedUrls`, free.
     * Each resolved link costs 1 credit.
     */
    fun resolveLinks(params: TweetResolveLinksParams): TweetResolveLinksResponse =
        resolveLinks(params, RequestOptions.none())

    /** @see resolveLinks */
    fun resolveLinks(
        params: TweetResolveLinksParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetResolveLinksResponse

    /**
     * No-mode search maximizes coverage. New cursorless `Latest` sessions return rows newest-first
     * across cursor pages. Existing cursors preserve their established ordering.
     */
    fun search(params: TweetSearchParams): TweetSearchResponse =
        search(params, RequestOptions.none())

    /** @see search */
    fun search(
        params: TweetSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetSearchResponse

    /**
     * Returns X's own translation of 1 public tweet into the language you pick, with the links,
     * mentions, and tags X places in the translated text.
     */
    fun translate(id: String, params: TweetTranslateParams): TweetTranslateResponse =
        translate(id, params, RequestOptions.none())

    /** @see translate */
    fun translate(
        id: String,
        params: TweetTranslateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetTranslateResponse = translate(params.toBuilder().id(id).build(), requestOptions)

    /** @see translate */
    fun translate(params: TweetTranslateParams): TweetTranslateResponse =
        translate(params, RequestOptions.none())

    /** @see translate */
    fun translate(
        params: TweetTranslateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetTranslateResponse

    /** A view of [TweetService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): TweetService.WithRawResponse

        /** X write actions (tweets, likes, follows, DMs) */
        fun like(): LikeService.WithRawResponse

        /** X write actions (tweets, likes, follows, DMs) */
        fun retweet(): RetweetService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/tweets`, but is otherwise the same as
         * [TweetService.create].
         */
        @MustBeClosed
        fun create(params: TweetCreateParams): HttpResponseFor<TweetCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: TweetCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetCreateResponse>

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}`, but is otherwise the same as
         * [TweetService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<TweetRetrieveResponse> =
            retrieve(id, TweetRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: TweetRetrieveParams = TweetRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: TweetRetrieveParams = TweetRetrieveParams.none(),
        ): HttpResponseFor<TweetRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: TweetRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: TweetRetrieveParams): HttpResponseFor<TweetRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetRetrieveResponse> =
            retrieve(id, TweetRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets`, but is otherwise the same as
         * [TweetService.list].
         */
        @MustBeClosed
        fun list(params: TweetListParams): HttpResponseFor<PaginatedTweets> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: TweetListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets>

        /**
         * Returns a raw HTTP response for `delete /x/tweets/{id}`, but is otherwise the same as
         * [TweetService.delete].
         */
        @MustBeClosed
        fun delete(id: String, params: TweetDeleteParams): HttpResponseFor<TweetDeleteResponse> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: TweetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetDeleteResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: TweetDeleteParams): HttpResponseFor<TweetDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: TweetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetDeleteResponse>

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/retweeters/check`, but is otherwise
         * the same as [TweetService.checkRepost].
         */
        @MustBeClosed
        fun checkRepost(
            id: String,
            params: TweetCheckRepostParams,
        ): HttpResponseFor<TweetCheckRepostResponse> =
            checkRepost(id, params, RequestOptions.none())

        /** @see checkRepost */
        @MustBeClosed
        fun checkRepost(
            id: String,
            params: TweetCheckRepostParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetCheckRepostResponse> =
            checkRepost(params.toBuilder().id(id).build(), requestOptions)

        /** @see checkRepost */
        @MustBeClosed
        fun checkRepost(params: TweetCheckRepostParams): HttpResponseFor<TweetCheckRepostResponse> =
            checkRepost(params, RequestOptions.none())

        /** @see checkRepost */
        @MustBeClosed
        fun checkRepost(
            params: TweetCheckRepostParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetCheckRepostResponse>

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/embed`, but is otherwise the same as
         * [TweetService.embed].
         */
        @MustBeClosed
        fun embed(id: String): HttpResponseFor<TweetEmbedResponse> =
            embed(id, TweetEmbedParams.none())

        /** @see embed */
        @MustBeClosed
        fun embed(
            id: String,
            params: TweetEmbedParams = TweetEmbedParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetEmbedResponse> =
            embed(params.toBuilder().id(id).build(), requestOptions)

        /** @see embed */
        @MustBeClosed
        fun embed(
            id: String,
            params: TweetEmbedParams = TweetEmbedParams.none(),
        ): HttpResponseFor<TweetEmbedResponse> = embed(id, params, RequestOptions.none())

        /** @see embed */
        @MustBeClosed
        fun embed(
            params: TweetEmbedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetEmbedResponse>

        /** @see embed */
        @MustBeClosed
        fun embed(params: TweetEmbedParams): HttpResponseFor<TweetEmbedResponse> =
            embed(params, RequestOptions.none())

        /** @see embed */
        @MustBeClosed
        fun embed(id: String, requestOptions: RequestOptions): HttpResponseFor<TweetEmbedResponse> =
            embed(id, TweetEmbedParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/favoriters`, but is otherwise the
         * same as [TweetService.getFavoriters].
         */
        @MustBeClosed
        fun getFavoriters(id: String): HttpResponseFor<PaginatedUsers> =
            getFavoriters(id, TweetGetFavoritersParams.none())

        /** @see getFavoriters */
        @MustBeClosed
        fun getFavoriters(
            id: String,
            params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers> =
            getFavoriters(params.toBuilder().id(id).build(), requestOptions)

        /** @see getFavoriters */
        @MustBeClosed
        fun getFavoriters(
            id: String,
            params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
        ): HttpResponseFor<PaginatedUsers> = getFavoriters(id, params, RequestOptions.none())

        /** @see getFavoriters */
        @MustBeClosed
        fun getFavoriters(
            params: TweetGetFavoritersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers>

        /** @see getFavoriters */
        @MustBeClosed
        fun getFavoriters(params: TweetGetFavoritersParams): HttpResponseFor<PaginatedUsers> =
            getFavoriters(params, RequestOptions.none())

        /** @see getFavoriters */
        @MustBeClosed
        fun getFavoriters(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> =
            getFavoriters(id, TweetGetFavoritersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/hidden-replies`, but is otherwise the
         * same as [TweetService.getHiddenReplies].
         */
        @MustBeClosed
        fun getHiddenReplies(id: String): HttpResponseFor<PaginatedTweets> =
            getHiddenReplies(id, TweetGetHiddenRepliesParams.none())

        /** @see getHiddenReplies */
        @MustBeClosed
        fun getHiddenReplies(
            id: String,
            params: TweetGetHiddenRepliesParams = TweetGetHiddenRepliesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets> =
            getHiddenReplies(params.toBuilder().id(id).build(), requestOptions)

        /** @see getHiddenReplies */
        @MustBeClosed
        fun getHiddenReplies(
            id: String,
            params: TweetGetHiddenRepliesParams = TweetGetHiddenRepliesParams.none(),
        ): HttpResponseFor<PaginatedTweets> = getHiddenReplies(id, params, RequestOptions.none())

        /** @see getHiddenReplies */
        @MustBeClosed
        fun getHiddenReplies(
            params: TweetGetHiddenRepliesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets>

        /** @see getHiddenReplies */
        @MustBeClosed
        fun getHiddenReplies(
            params: TweetGetHiddenRepliesParams
        ): HttpResponseFor<PaginatedTweets> = getHiddenReplies(params, RequestOptions.none())

        /** @see getHiddenReplies */
        @MustBeClosed
        fun getHiddenReplies(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedTweets> =
            getHiddenReplies(id, TweetGetHiddenRepliesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/insights`, but is otherwise the same
         * as [TweetService.getInsights].
         */
        @MustBeClosed
        fun getInsights(id: String): HttpResponseFor<TweetGetInsightsResponse> =
            getInsights(id, TweetGetInsightsParams.none())

        /** @see getInsights */
        @MustBeClosed
        fun getInsights(
            id: String,
            params: TweetGetInsightsParams = TweetGetInsightsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetGetInsightsResponse> =
            getInsights(params.toBuilder().id(id).build(), requestOptions)

        /** @see getInsights */
        @MustBeClosed
        fun getInsights(
            id: String,
            params: TweetGetInsightsParams = TweetGetInsightsParams.none(),
        ): HttpResponseFor<TweetGetInsightsResponse> =
            getInsights(id, params, RequestOptions.none())

        /** @see getInsights */
        @MustBeClosed
        fun getInsights(
            params: TweetGetInsightsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetGetInsightsResponse>

        /** @see getInsights */
        @MustBeClosed
        fun getInsights(params: TweetGetInsightsParams): HttpResponseFor<TweetGetInsightsResponse> =
            getInsights(params, RequestOptions.none())

        /** @see getInsights */
        @MustBeClosed
        fun getInsights(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetGetInsightsResponse> =
            getInsights(id, TweetGetInsightsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/quotes`, but is otherwise the same as
         * [TweetService.getQuotes].
         */
        @MustBeClosed
        fun getQuotes(id: String): HttpResponseFor<PaginatedTweets> =
            getQuotes(id, TweetGetQuotesParams.none())

        /** @see getQuotes */
        @MustBeClosed
        fun getQuotes(
            id: String,
            params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets> =
            getQuotes(params.toBuilder().id(id).build(), requestOptions)

        /** @see getQuotes */
        @MustBeClosed
        fun getQuotes(
            id: String,
            params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
        ): HttpResponseFor<PaginatedTweets> = getQuotes(id, params, RequestOptions.none())

        /** @see getQuotes */
        @MustBeClosed
        fun getQuotes(
            params: TweetGetQuotesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets>

        /** @see getQuotes */
        @MustBeClosed
        fun getQuotes(params: TweetGetQuotesParams): HttpResponseFor<PaginatedTweets> =
            getQuotes(params, RequestOptions.none())

        /** @see getQuotes */
        @MustBeClosed
        fun getQuotes(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedTweets> =
            getQuotes(id, TweetGetQuotesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/replies`, but is otherwise the same
         * as [TweetService.getReplies].
         */
        @MustBeClosed
        fun getReplies(id: String): HttpResponseFor<TweetGetRepliesResponse> =
            getReplies(id, TweetGetRepliesParams.none())

        /** @see getReplies */
        @MustBeClosed
        fun getReplies(
            id: String,
            params: TweetGetRepliesParams = TweetGetRepliesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetGetRepliesResponse> =
            getReplies(params.toBuilder().id(id).build(), requestOptions)

        /** @see getReplies */
        @MustBeClosed
        fun getReplies(
            id: String,
            params: TweetGetRepliesParams = TweetGetRepliesParams.none(),
        ): HttpResponseFor<TweetGetRepliesResponse> = getReplies(id, params, RequestOptions.none())

        /** @see getReplies */
        @MustBeClosed
        fun getReplies(
            params: TweetGetRepliesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetGetRepliesResponse>

        /** @see getReplies */
        @MustBeClosed
        fun getReplies(params: TweetGetRepliesParams): HttpResponseFor<TweetGetRepliesResponse> =
            getReplies(params, RequestOptions.none())

        /** @see getReplies */
        @MustBeClosed
        fun getReplies(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetGetRepliesResponse> =
            getReplies(id, TweetGetRepliesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/retweeter-ids`, but is otherwise the
         * same as [TweetService.getRetweeterIds].
         */
        @MustBeClosed
        fun getRetweeterIds(id: String): HttpResponseFor<TweetGetRetweeterIdsResponse> =
            getRetweeterIds(id, TweetGetRetweeterIdsParams.none())

        /** @see getRetweeterIds */
        @MustBeClosed
        fun getRetweeterIds(
            id: String,
            params: TweetGetRetweeterIdsParams = TweetGetRetweeterIdsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetGetRetweeterIdsResponse> =
            getRetweeterIds(params.toBuilder().id(id).build(), requestOptions)

        /** @see getRetweeterIds */
        @MustBeClosed
        fun getRetweeterIds(
            id: String,
            params: TweetGetRetweeterIdsParams = TweetGetRetweeterIdsParams.none(),
        ): HttpResponseFor<TweetGetRetweeterIdsResponse> =
            getRetweeterIds(id, params, RequestOptions.none())

        /** @see getRetweeterIds */
        @MustBeClosed
        fun getRetweeterIds(
            params: TweetGetRetweeterIdsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetGetRetweeterIdsResponse>

        /** @see getRetweeterIds */
        @MustBeClosed
        fun getRetweeterIds(
            params: TweetGetRetweeterIdsParams
        ): HttpResponseFor<TweetGetRetweeterIdsResponse> =
            getRetweeterIds(params, RequestOptions.none())

        /** @see getRetweeterIds */
        @MustBeClosed
        fun getRetweeterIds(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetGetRetweeterIdsResponse> =
            getRetweeterIds(id, TweetGetRetweeterIdsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/retweeters`, but is otherwise the
         * same as [TweetService.getRetweeters].
         */
        @MustBeClosed
        fun getRetweeters(id: String): HttpResponseFor<PaginatedUsers> =
            getRetweeters(id, TweetGetRetweetersParams.none())

        /** @see getRetweeters */
        @MustBeClosed
        fun getRetweeters(
            id: String,
            params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers> =
            getRetweeters(params.toBuilder().id(id).build(), requestOptions)

        /** @see getRetweeters */
        @MustBeClosed
        fun getRetweeters(
            id: String,
            params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
        ): HttpResponseFor<PaginatedUsers> = getRetweeters(id, params, RequestOptions.none())

        /** @see getRetweeters */
        @MustBeClosed
        fun getRetweeters(
            params: TweetGetRetweetersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedUsers>

        /** @see getRetweeters */
        @MustBeClosed
        fun getRetweeters(params: TweetGetRetweetersParams): HttpResponseFor<PaginatedUsers> =
            getRetweeters(params, RequestOptions.none())

        /** @see getRetweeters */
        @MustBeClosed
        fun getRetweeters(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> =
            getRetweeters(id, TweetGetRetweetersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/subtitles`, but is otherwise the same
         * as [TweetService.getSubtitles].
         */
        @MustBeClosed
        fun getSubtitles(id: String): HttpResponseFor<TweetGetSubtitlesResponse> =
            getSubtitles(id, TweetGetSubtitlesParams.none())

        /** @see getSubtitles */
        @MustBeClosed
        fun getSubtitles(
            id: String,
            params: TweetGetSubtitlesParams = TweetGetSubtitlesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetGetSubtitlesResponse> =
            getSubtitles(params.toBuilder().id(id).build(), requestOptions)

        /** @see getSubtitles */
        @MustBeClosed
        fun getSubtitles(
            id: String,
            params: TweetGetSubtitlesParams = TweetGetSubtitlesParams.none(),
        ): HttpResponseFor<TweetGetSubtitlesResponse> =
            getSubtitles(id, params, RequestOptions.none())

        /** @see getSubtitles */
        @MustBeClosed
        fun getSubtitles(
            params: TweetGetSubtitlesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetGetSubtitlesResponse>

        /** @see getSubtitles */
        @MustBeClosed
        fun getSubtitles(
            params: TweetGetSubtitlesParams
        ): HttpResponseFor<TweetGetSubtitlesResponse> = getSubtitles(params, RequestOptions.none())

        /** @see getSubtitles */
        @MustBeClosed
        fun getSubtitles(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetGetSubtitlesResponse> =
            getSubtitles(id, TweetGetSubtitlesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/thread`, but is otherwise the same as
         * [TweetService.getThread].
         */
        @MustBeClosed
        fun getThread(id: String): HttpResponseFor<PaginatedTweets> =
            getThread(id, TweetGetThreadParams.none())

        /** @see getThread */
        @MustBeClosed
        fun getThread(
            id: String,
            params: TweetGetThreadParams = TweetGetThreadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets> =
            getThread(params.toBuilder().id(id).build(), requestOptions)

        /** @see getThread */
        @MustBeClosed
        fun getThread(
            id: String,
            params: TweetGetThreadParams = TweetGetThreadParams.none(),
        ): HttpResponseFor<PaginatedTweets> = getThread(id, params, RequestOptions.none())

        /** @see getThread */
        @MustBeClosed
        fun getThread(
            params: TweetGetThreadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets>

        /** @see getThread */
        @MustBeClosed
        fun getThread(params: TweetGetThreadParams): HttpResponseFor<PaginatedTweets> =
            getThread(params, RequestOptions.none())

        /** @see getThread */
        @MustBeClosed
        fun getThread(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedTweets> =
            getThread(id, TweetGetThreadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/top`, but is otherwise the same as
         * [TweetService.listTop].
         */
        @MustBeClosed
        fun listTop(): HttpResponseFor<PaginatedTweets> = listTop(TweetListTopParams.none())

        /** @see listTop */
        @MustBeClosed
        fun listTop(
            params: TweetListTopParams = TweetListTopParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets>

        /** @see listTop */
        @MustBeClosed
        fun listTop(
            params: TweetListTopParams = TweetListTopParams.none()
        ): HttpResponseFor<PaginatedTweets> = listTop(params, RequestOptions.none())

        /** @see listTop */
        @MustBeClosed
        fun listTop(requestOptions: RequestOptions): HttpResponseFor<PaginatedTweets> =
            listTop(TweetListTopParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/links/resolve`, but is otherwise the same as
         * [TweetService.resolveLinks].
         */
        @MustBeClosed
        fun resolveLinks(
            params: TweetResolveLinksParams
        ): HttpResponseFor<TweetResolveLinksResponse> = resolveLinks(params, RequestOptions.none())

        /** @see resolveLinks */
        @MustBeClosed
        fun resolveLinks(
            params: TweetResolveLinksParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetResolveLinksResponse>

        /**
         * Returns a raw HTTP response for `get /x/tweets/search`, but is otherwise the same as
         * [TweetService.search].
         */
        @MustBeClosed
        fun search(params: TweetSearchParams): HttpResponseFor<TweetSearchResponse> =
            search(params, RequestOptions.none())

        /** @see search */
        @MustBeClosed
        fun search(
            params: TweetSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetSearchResponse>

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/translation`, but is otherwise the
         * same as [TweetService.translate].
         */
        @MustBeClosed
        fun translate(
            id: String,
            params: TweetTranslateParams,
        ): HttpResponseFor<TweetTranslateResponse> = translate(id, params, RequestOptions.none())

        /** @see translate */
        @MustBeClosed
        fun translate(
            id: String,
            params: TweetTranslateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetTranslateResponse> =
            translate(params.toBuilder().id(id).build(), requestOptions)

        /** @see translate */
        @MustBeClosed
        fun translate(params: TweetTranslateParams): HttpResponseFor<TweetTranslateResponse> =
            translate(params, RequestOptions.none())

        /** @see translate */
        @MustBeClosed
        fun translate(
            params: TweetTranslateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetTranslateResponse>
    }
}
