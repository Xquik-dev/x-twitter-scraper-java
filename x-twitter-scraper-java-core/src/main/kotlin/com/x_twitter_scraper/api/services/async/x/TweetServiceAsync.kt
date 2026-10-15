// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

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
import com.x_twitter_scraper.api.services.async.x.tweets.LikeServiceAsync
import com.x_twitter_scraper.api.services.async.x.tweets.RetweetServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface TweetServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TweetServiceAsync

    /** X write actions (tweets, likes, follows, DMs) */
    fun like(): LikeServiceAsync

    /** X write actions (tweets, likes, follows, DMs) */
    fun retweet(): RetweetServiceAsync

    /** Create tweet */
    fun create(params: TweetCreateParams): CompletableFuture<TweetCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: TweetCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetCreateResponse>

    /** Get tweet with full text, author, metrics and media */
    fun retrieve(id: String): CompletableFuture<TweetRetrieveResponse> =
        retrieve(id, TweetRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TweetRetrieveParams = TweetRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TweetRetrieveParams = TweetRetrieveParams.none(),
    ): CompletableFuture<TweetRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: TweetRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: TweetRetrieveParams): CompletableFuture<TweetRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<TweetRetrieveResponse> =
        retrieve(id, TweetRetrieveParams.none(), requestOptions)

    /** Get multiple tweets by IDs */
    fun list(params: TweetListParams): CompletableFuture<PaginatedTweets> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TweetListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** Delete tweet */
    fun delete(id: String, params: TweetDeleteParams): CompletableFuture<TweetDeleteResponse> =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        params: TweetDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetDeleteResponse> =
        delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(params: TweetDeleteParams): CompletableFuture<TweetDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: TweetDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetDeleteResponse>

    /**
     * Returns whether 1 account reposted the post, read from its newest posts. A repost older than
     * the posts read returns false with complete false. Each check costs 1 credit.
     */
    fun checkRepost(
        id: String,
        params: TweetCheckRepostParams,
    ): CompletableFuture<TweetCheckRepostResponse> = checkRepost(id, params, RequestOptions.none())

    /** @see checkRepost */
    fun checkRepost(
        id: String,
        params: TweetCheckRepostParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetCheckRepostResponse> =
        checkRepost(params.toBuilder().id(id).build(), requestOptions)

    /** @see checkRepost */
    fun checkRepost(params: TweetCheckRepostParams): CompletableFuture<TweetCheckRepostResponse> =
        checkRepost(params, RequestOptions.none())

    /** @see checkRepost */
    fun checkRepost(
        params: TweetCheckRepostParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetCheckRepostResponse>

    /**
     * Returns the HTML that X gives websites to embed 1 public tweet, with the tweet's link and
     * author.
     */
    fun embed(id: String): CompletableFuture<TweetEmbedResponse> =
        embed(id, TweetEmbedParams.none())

    /** @see embed */
    fun embed(
        id: String,
        params: TweetEmbedParams = TweetEmbedParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetEmbedResponse> =
        embed(params.toBuilder().id(id).build(), requestOptions)

    /** @see embed */
    fun embed(
        id: String,
        params: TweetEmbedParams = TweetEmbedParams.none(),
    ): CompletableFuture<TweetEmbedResponse> = embed(id, params, RequestOptions.none())

    /** @see embed */
    fun embed(
        params: TweetEmbedParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetEmbedResponse>

    /** @see embed */
    fun embed(params: TweetEmbedParams): CompletableFuture<TweetEmbedResponse> =
        embed(params, RequestOptions.none())

    /** @see embed */
    fun embed(id: String, requestOptions: RequestOptions): CompletableFuture<TweetEmbedResponse> =
        embed(id, TweetEmbedParams.none(), requestOptions)

    /**
     * Returns liker profiles that X makes visible for the post. X can withhold liker identities
     * even when the post reports likes. In that case this endpoint returns 424
     * `favoriters_unavailable` instead of a misleading empty success.
     */
    fun getFavoriters(id: String): CompletableFuture<PaginatedUsers> =
        getFavoriters(id, TweetGetFavoritersParams.none())

    /** @see getFavoriters */
    fun getFavoriters(
        id: String,
        params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers> =
        getFavoriters(params.toBuilder().id(id).build(), requestOptions)

    /** @see getFavoriters */
    fun getFavoriters(
        id: String,
        params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
    ): CompletableFuture<PaginatedUsers> = getFavoriters(id, params, RequestOptions.none())

    /** @see getFavoriters */
    fun getFavoriters(
        params: TweetGetFavoritersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers>

    /** @see getFavoriters */
    fun getFavoriters(params: TweetGetFavoritersParams): CompletableFuture<PaginatedUsers> =
        getFavoriters(params, RequestOptions.none())

    /** @see getFavoriters */
    fun getFavoriters(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedUsers> =
        getFavoriters(id, TweetGetFavoritersParams.none(), requestOptions)

    /**
     * Returns the replies the post's author hid, oldest first, with the replies to them. A post
     * without hidden replies returns an empty list.
     */
    fun getHiddenReplies(id: String): CompletableFuture<PaginatedTweets> =
        getHiddenReplies(id, TweetGetHiddenRepliesParams.none())

    /** @see getHiddenReplies */
    fun getHiddenReplies(
        id: String,
        params: TweetGetHiddenRepliesParams = TweetGetHiddenRepliesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets> =
        getHiddenReplies(params.toBuilder().id(id).build(), requestOptions)

    /** @see getHiddenReplies */
    fun getHiddenReplies(
        id: String,
        params: TweetGetHiddenRepliesParams = TweetGetHiddenRepliesParams.none(),
    ): CompletableFuture<PaginatedTweets> = getHiddenReplies(id, params, RequestOptions.none())

    /** @see getHiddenReplies */
    fun getHiddenReplies(
        params: TweetGetHiddenRepliesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see getHiddenReplies */
    fun getHiddenReplies(params: TweetGetHiddenRepliesParams): CompletableFuture<PaginatedTweets> =
        getHiddenReplies(params, RequestOptions.none())

    /** @see getHiddenReplies */
    fun getHiddenReplies(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedTweets> =
        getHiddenReplies(id, TweetGetHiddenRepliesParams.none(), requestOptions)

    /**
     * Returns engagement insights for 1 tweet. They are engagements per hour since it went up, per
     * view and per follower of its author, and how far it spread. Each report costs 1 credit,
     * whatever it reads.
     */
    fun getInsights(id: String): CompletableFuture<TweetGetInsightsResponse> =
        getInsights(id, TweetGetInsightsParams.none())

    /** @see getInsights */
    fun getInsights(
        id: String,
        params: TweetGetInsightsParams = TweetGetInsightsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetGetInsightsResponse> =
        getInsights(params.toBuilder().id(id).build(), requestOptions)

    /** @see getInsights */
    fun getInsights(
        id: String,
        params: TweetGetInsightsParams = TweetGetInsightsParams.none(),
    ): CompletableFuture<TweetGetInsightsResponse> = getInsights(id, params, RequestOptions.none())

    /** @see getInsights */
    fun getInsights(
        params: TweetGetInsightsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetGetInsightsResponse>

    /** @see getInsights */
    fun getInsights(params: TweetGetInsightsParams): CompletableFuture<TweetGetInsightsResponse> =
        getInsights(params, RequestOptions.none())

    /** @see getInsights */
    fun getInsights(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<TweetGetInsightsResponse> =
        getInsights(id, TweetGetInsightsParams.none(), requestOptions)

    /** List quote tweets of a tweet */
    fun getQuotes(id: String): CompletableFuture<PaginatedTweets> =
        getQuotes(id, TweetGetQuotesParams.none())

    /** @see getQuotes */
    fun getQuotes(
        id: String,
        params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets> =
        getQuotes(params.toBuilder().id(id).build(), requestOptions)

    /** @see getQuotes */
    fun getQuotes(
        id: String,
        params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
    ): CompletableFuture<PaginatedTweets> = getQuotes(id, params, RequestOptions.none())

    /** @see getQuotes */
    fun getQuotes(
        params: TweetGetQuotesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see getQuotes */
    fun getQuotes(params: TweetGetQuotesParams): CompletableFuture<PaginatedTweets> =
        getQuotes(params, RequestOptions.none())

    /** @see getQuotes */
    fun getQuotes(id: String, requestOptions: RequestOptions): CompletableFuture<PaginatedTweets> =
        getQuotes(id, TweetGetQuotesParams.none(), requestOptions)

    /**
     * Returns direct replies. Omit mode for automatic maximum coverage with resumable pagination.
     * Complete mode returns nested replies, diagnostics, and 424 when direct coverage stays below
     * 80%.
     */
    fun getReplies(id: String): CompletableFuture<TweetGetRepliesResponse> =
        getReplies(id, TweetGetRepliesParams.none())

    /** @see getReplies */
    fun getReplies(
        id: String,
        params: TweetGetRepliesParams = TweetGetRepliesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetGetRepliesResponse> =
        getReplies(params.toBuilder().id(id).build(), requestOptions)

    /** @see getReplies */
    fun getReplies(
        id: String,
        params: TweetGetRepliesParams = TweetGetRepliesParams.none(),
    ): CompletableFuture<TweetGetRepliesResponse> = getReplies(id, params, RequestOptions.none())

    /** @see getReplies */
    fun getReplies(
        params: TweetGetRepliesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetGetRepliesResponse>

    /** @see getReplies */
    fun getReplies(params: TweetGetRepliesParams): CompletableFuture<TweetGetRepliesResponse> =
        getReplies(params, RequestOptions.none())

    /** @see getReplies */
    fun getReplies(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<TweetGetRepliesResponse> =
        getReplies(id, TweetGetRepliesParams.none(), requestOptions)

    /**
     * Returns the user IDs of a post's reposters, in the order & pages of
     * /x/tweets/{id}/retweeters. Use it when you need IDs only. Each ID costs 1 credit. A post
     * nobody reposted returns an empty list for free.
     */
    fun getRetweeterIds(id: String): CompletableFuture<TweetGetRetweeterIdsResponse> =
        getRetweeterIds(id, TweetGetRetweeterIdsParams.none())

    /** @see getRetweeterIds */
    fun getRetweeterIds(
        id: String,
        params: TweetGetRetweeterIdsParams = TweetGetRetweeterIdsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetGetRetweeterIdsResponse> =
        getRetweeterIds(params.toBuilder().id(id).build(), requestOptions)

    /** @see getRetweeterIds */
    fun getRetweeterIds(
        id: String,
        params: TweetGetRetweeterIdsParams = TweetGetRetweeterIdsParams.none(),
    ): CompletableFuture<TweetGetRetweeterIdsResponse> =
        getRetweeterIds(id, params, RequestOptions.none())

    /** @see getRetweeterIds */
    fun getRetweeterIds(
        params: TweetGetRetweeterIdsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetGetRetweeterIdsResponse>

    /** @see getRetweeterIds */
    fun getRetweeterIds(
        params: TweetGetRetweeterIdsParams
    ): CompletableFuture<TweetGetRetweeterIdsResponse> =
        getRetweeterIds(params, RequestOptions.none())

    /** @see getRetweeterIds */
    fun getRetweeterIds(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<TweetGetRetweeterIdsResponse> =
        getRetweeterIds(id, TweetGetRetweeterIdsParams.none(), requestOptions)

    /** List users who retweeted a tweet */
    fun getRetweeters(id: String): CompletableFuture<PaginatedUsers> =
        getRetweeters(id, TweetGetRetweetersParams.none())

    /** @see getRetweeters */
    fun getRetweeters(
        id: String,
        params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers> =
        getRetweeters(params.toBuilder().id(id).build(), requestOptions)

    /** @see getRetweeters */
    fun getRetweeters(
        id: String,
        params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
    ): CompletableFuture<PaginatedUsers> = getRetweeters(id, params, RequestOptions.none())

    /** @see getRetweeters */
    fun getRetweeters(
        params: TweetGetRetweetersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedUsers>

    /** @see getRetweeters */
    fun getRetweeters(params: TweetGetRetweetersParams): CompletableFuture<PaginatedUsers> =
        getRetweeters(params, RequestOptions.none())

    /** @see getRetweeters */
    fun getRetweeters(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedUsers> =
        getRetweeters(id, TweetGetRetweetersParams.none(), requestOptions)

    /**
     * Returns the caption tracks of 1 public tweet's videos, as X's player reads them. Each track
     * has its language, name, timed cues, and full text. A tweet without video, or a video without
     * captions, returns no track and costs nothing.
     */
    fun getSubtitles(id: String): CompletableFuture<TweetGetSubtitlesResponse> =
        getSubtitles(id, TweetGetSubtitlesParams.none())

    /** @see getSubtitles */
    fun getSubtitles(
        id: String,
        params: TweetGetSubtitlesParams = TweetGetSubtitlesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetGetSubtitlesResponse> =
        getSubtitles(params.toBuilder().id(id).build(), requestOptions)

    /** @see getSubtitles */
    fun getSubtitles(
        id: String,
        params: TweetGetSubtitlesParams = TweetGetSubtitlesParams.none(),
    ): CompletableFuture<TweetGetSubtitlesResponse> =
        getSubtitles(id, params, RequestOptions.none())

    /** @see getSubtitles */
    fun getSubtitles(
        params: TweetGetSubtitlesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetGetSubtitlesResponse>

    /** @see getSubtitles */
    fun getSubtitles(
        params: TweetGetSubtitlesParams
    ): CompletableFuture<TweetGetSubtitlesResponse> = getSubtitles(params, RequestOptions.none())

    /** @see getSubtitles */
    fun getSubtitles(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<TweetGetSubtitlesResponse> =
        getSubtitles(id, TweetGetSubtitlesParams.none(), requestOptions)

    /** Get full conversation thread for a tweet */
    fun getThread(id: String): CompletableFuture<PaginatedTweets> =
        getThread(id, TweetGetThreadParams.none())

    /** @see getThread */
    fun getThread(
        id: String,
        params: TweetGetThreadParams = TweetGetThreadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets> =
        getThread(params.toBuilder().id(id).build(), requestOptions)

    /** @see getThread */
    fun getThread(
        id: String,
        params: TweetGetThreadParams = TweetGetThreadParams.none(),
    ): CompletableFuture<PaginatedTweets> = getThread(id, params, RequestOptions.none())

    /** @see getThread */
    fun getThread(
        params: TweetGetThreadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see getThread */
    fun getThread(params: TweetGetThreadParams): CompletableFuture<PaginatedTweets> =
        getThread(params, RequestOptions.none())

    /** @see getThread */
    fun getThread(id: String, requestOptions: RequestOptions): CompletableFuture<PaginatedTweets> =
        getThread(id, TweetGetThreadParams.none(), requestOptions)

    /**
     * Returns the tweets X ranks highest by 1 metric over the last day, week or month, as x.com's
     * Inspiration page shows them. Covers all of X unless you pick a country or a language. Pages
     * hold up to 20 tweets, and the list ends at 100. Each tweet costs 1 credit.
     */
    fun listTop(): CompletableFuture<PaginatedTweets> = listTop(TweetListTopParams.none())

    /** @see listTop */
    fun listTop(
        params: TweetListTopParams = TweetListTopParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see listTop */
    fun listTop(
        params: TweetListTopParams = TweetListTopParams.none()
    ): CompletableFuture<PaginatedTweets> = listTop(params, RequestOptions.none())

    /** @see listTop */
    fun listTop(requestOptions: RequestOptions): CompletableFuture<PaginatedTweets> =
        listTop(TweetListTopParams.none(), requestOptions)

    /**
     * Returns where each t.co link leads, as X's own redirect says. Xquik reads the redirect and
     * never visits the target site. A link t.co does not have comes back without `resolvedUrl` and
     * costs nothing. A link X does not answer for in time comes back in `unprocessedUrls`, free.
     * Each resolved link costs 1 credit.
     */
    fun resolveLinks(
        params: TweetResolveLinksParams
    ): CompletableFuture<TweetResolveLinksResponse> = resolveLinks(params, RequestOptions.none())

    /** @see resolveLinks */
    fun resolveLinks(
        params: TweetResolveLinksParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetResolveLinksResponse>

    /**
     * No-mode search maximizes coverage. New cursorless `Latest` sessions return rows newest-first
     * across cursor pages. Existing cursors preserve their established ordering.
     */
    fun search(params: TweetSearchParams): CompletableFuture<TweetSearchResponse> =
        search(params, RequestOptions.none())

    /** @see search */
    fun search(
        params: TweetSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetSearchResponse>

    /**
     * Returns X's own translation of 1 public tweet into the language you pick, with the links,
     * mentions, and tags X places in the translated text.
     */
    fun translate(
        id: String,
        params: TweetTranslateParams,
    ): CompletableFuture<TweetTranslateResponse> = translate(id, params, RequestOptions.none())

    /** @see translate */
    fun translate(
        id: String,
        params: TweetTranslateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetTranslateResponse> =
        translate(params.toBuilder().id(id).build(), requestOptions)

    /** @see translate */
    fun translate(params: TweetTranslateParams): CompletableFuture<TweetTranslateResponse> =
        translate(params, RequestOptions.none())

    /** @see translate */
    fun translate(
        params: TweetTranslateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetTranslateResponse>

    /** A view of [TweetServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TweetServiceAsync.WithRawResponse

        /** X write actions (tweets, likes, follows, DMs) */
        fun like(): LikeServiceAsync.WithRawResponse

        /** X write actions (tweets, likes, follows, DMs) */
        fun retweet(): RetweetServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /x/tweets`, but is otherwise the same as
         * [TweetServiceAsync.create].
         */
        fun create(
            params: TweetCreateParams
        ): CompletableFuture<HttpResponseFor<TweetCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: TweetCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}`, but is otherwise the same as
         * [TweetServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<TweetRetrieveResponse>> =
            retrieve(id, TweetRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: TweetRetrieveParams = TweetRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: TweetRetrieveParams = TweetRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<TweetRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: TweetRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: TweetRetrieveParams
        ): CompletableFuture<HttpResponseFor<TweetRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TweetRetrieveResponse>> =
            retrieve(id, TweetRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets`, but is otherwise the same as
         * [TweetServiceAsync.list].
         */
        fun list(params: TweetListParams): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            params: TweetListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /**
         * Returns a raw HTTP response for `delete /x/tweets/{id}`, but is otherwise the same as
         * [TweetServiceAsync.delete].
         */
        fun delete(
            id: String,
            params: TweetDeleteParams,
        ): CompletableFuture<HttpResponseFor<TweetDeleteResponse>> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            params: TweetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetDeleteResponse>> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: TweetDeleteParams
        ): CompletableFuture<HttpResponseFor<TweetDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: TweetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetDeleteResponse>>

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/retweeters/check`, but is otherwise
         * the same as [TweetServiceAsync.checkRepost].
         */
        fun checkRepost(
            id: String,
            params: TweetCheckRepostParams,
        ): CompletableFuture<HttpResponseFor<TweetCheckRepostResponse>> =
            checkRepost(id, params, RequestOptions.none())

        /** @see checkRepost */
        fun checkRepost(
            id: String,
            params: TweetCheckRepostParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetCheckRepostResponse>> =
            checkRepost(params.toBuilder().id(id).build(), requestOptions)

        /** @see checkRepost */
        fun checkRepost(
            params: TweetCheckRepostParams
        ): CompletableFuture<HttpResponseFor<TweetCheckRepostResponse>> =
            checkRepost(params, RequestOptions.none())

        /** @see checkRepost */
        fun checkRepost(
            params: TweetCheckRepostParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetCheckRepostResponse>>

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/embed`, but is otherwise the same as
         * [TweetServiceAsync.embed].
         */
        fun embed(id: String): CompletableFuture<HttpResponseFor<TweetEmbedResponse>> =
            embed(id, TweetEmbedParams.none())

        /** @see embed */
        fun embed(
            id: String,
            params: TweetEmbedParams = TweetEmbedParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetEmbedResponse>> =
            embed(params.toBuilder().id(id).build(), requestOptions)

        /** @see embed */
        fun embed(
            id: String,
            params: TweetEmbedParams = TweetEmbedParams.none(),
        ): CompletableFuture<HttpResponseFor<TweetEmbedResponse>> =
            embed(id, params, RequestOptions.none())

        /** @see embed */
        fun embed(
            params: TweetEmbedParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetEmbedResponse>>

        /** @see embed */
        fun embed(
            params: TweetEmbedParams
        ): CompletableFuture<HttpResponseFor<TweetEmbedResponse>> =
            embed(params, RequestOptions.none())

        /** @see embed */
        fun embed(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TweetEmbedResponse>> =
            embed(id, TweetEmbedParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/favoriters`, but is otherwise the
         * same as [TweetServiceAsync.getFavoriters].
         */
        fun getFavoriters(id: String): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            getFavoriters(id, TweetGetFavoritersParams.none())

        /** @see getFavoriters */
        fun getFavoriters(
            id: String,
            params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            getFavoriters(params.toBuilder().id(id).build(), requestOptions)

        /** @see getFavoriters */
        fun getFavoriters(
            id: String,
            params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            getFavoriters(id, params, RequestOptions.none())

        /** @see getFavoriters */
        fun getFavoriters(
            params: TweetGetFavoritersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>>

        /** @see getFavoriters */
        fun getFavoriters(
            params: TweetGetFavoritersParams
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            getFavoriters(params, RequestOptions.none())

        /** @see getFavoriters */
        fun getFavoriters(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            getFavoriters(id, TweetGetFavoritersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/hidden-replies`, but is otherwise the
         * same as [TweetServiceAsync.getHiddenReplies].
         */
        fun getHiddenReplies(id: String): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getHiddenReplies(id, TweetGetHiddenRepliesParams.none())

        /** @see getHiddenReplies */
        fun getHiddenReplies(
            id: String,
            params: TweetGetHiddenRepliesParams = TweetGetHiddenRepliesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getHiddenReplies(params.toBuilder().id(id).build(), requestOptions)

        /** @see getHiddenReplies */
        fun getHiddenReplies(
            id: String,
            params: TweetGetHiddenRepliesParams = TweetGetHiddenRepliesParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getHiddenReplies(id, params, RequestOptions.none())

        /** @see getHiddenReplies */
        fun getHiddenReplies(
            params: TweetGetHiddenRepliesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see getHiddenReplies */
        fun getHiddenReplies(
            params: TweetGetHiddenRepliesParams
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getHiddenReplies(params, RequestOptions.none())

        /** @see getHiddenReplies */
        fun getHiddenReplies(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getHiddenReplies(id, TweetGetHiddenRepliesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/insights`, but is otherwise the same
         * as [TweetServiceAsync.getInsights].
         */
        fun getInsights(id: String): CompletableFuture<HttpResponseFor<TweetGetInsightsResponse>> =
            getInsights(id, TweetGetInsightsParams.none())

        /** @see getInsights */
        fun getInsights(
            id: String,
            params: TweetGetInsightsParams = TweetGetInsightsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetInsightsResponse>> =
            getInsights(params.toBuilder().id(id).build(), requestOptions)

        /** @see getInsights */
        fun getInsights(
            id: String,
            params: TweetGetInsightsParams = TweetGetInsightsParams.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetInsightsResponse>> =
            getInsights(id, params, RequestOptions.none())

        /** @see getInsights */
        fun getInsights(
            params: TweetGetInsightsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetInsightsResponse>>

        /** @see getInsights */
        fun getInsights(
            params: TweetGetInsightsParams
        ): CompletableFuture<HttpResponseFor<TweetGetInsightsResponse>> =
            getInsights(params, RequestOptions.none())

        /** @see getInsights */
        fun getInsights(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TweetGetInsightsResponse>> =
            getInsights(id, TweetGetInsightsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/quotes`, but is otherwise the same as
         * [TweetServiceAsync.getQuotes].
         */
        fun getQuotes(id: String): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getQuotes(id, TweetGetQuotesParams.none())

        /** @see getQuotes */
        fun getQuotes(
            id: String,
            params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getQuotes(params.toBuilder().id(id).build(), requestOptions)

        /** @see getQuotes */
        fun getQuotes(
            id: String,
            params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getQuotes(id, params, RequestOptions.none())

        /** @see getQuotes */
        fun getQuotes(
            params: TweetGetQuotesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see getQuotes */
        fun getQuotes(
            params: TweetGetQuotesParams
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getQuotes(params, RequestOptions.none())

        /** @see getQuotes */
        fun getQuotes(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getQuotes(id, TweetGetQuotesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/replies`, but is otherwise the same
         * as [TweetServiceAsync.getReplies].
         */
        fun getReplies(id: String): CompletableFuture<HttpResponseFor<TweetGetRepliesResponse>> =
            getReplies(id, TweetGetRepliesParams.none())

        /** @see getReplies */
        fun getReplies(
            id: String,
            params: TweetGetRepliesParams = TweetGetRepliesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetRepliesResponse>> =
            getReplies(params.toBuilder().id(id).build(), requestOptions)

        /** @see getReplies */
        fun getReplies(
            id: String,
            params: TweetGetRepliesParams = TweetGetRepliesParams.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetRepliesResponse>> =
            getReplies(id, params, RequestOptions.none())

        /** @see getReplies */
        fun getReplies(
            params: TweetGetRepliesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetRepliesResponse>>

        /** @see getReplies */
        fun getReplies(
            params: TweetGetRepliesParams
        ): CompletableFuture<HttpResponseFor<TweetGetRepliesResponse>> =
            getReplies(params, RequestOptions.none())

        /** @see getReplies */
        fun getReplies(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TweetGetRepliesResponse>> =
            getReplies(id, TweetGetRepliesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/retweeter-ids`, but is otherwise the
         * same as [TweetServiceAsync.getRetweeterIds].
         */
        fun getRetweeterIds(
            id: String
        ): CompletableFuture<HttpResponseFor<TweetGetRetweeterIdsResponse>> =
            getRetweeterIds(id, TweetGetRetweeterIdsParams.none())

        /** @see getRetweeterIds */
        fun getRetweeterIds(
            id: String,
            params: TweetGetRetweeterIdsParams = TweetGetRetweeterIdsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetRetweeterIdsResponse>> =
            getRetweeterIds(params.toBuilder().id(id).build(), requestOptions)

        /** @see getRetweeterIds */
        fun getRetweeterIds(
            id: String,
            params: TweetGetRetweeterIdsParams = TweetGetRetweeterIdsParams.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetRetweeterIdsResponse>> =
            getRetweeterIds(id, params, RequestOptions.none())

        /** @see getRetweeterIds */
        fun getRetweeterIds(
            params: TweetGetRetweeterIdsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetRetweeterIdsResponse>>

        /** @see getRetweeterIds */
        fun getRetweeterIds(
            params: TweetGetRetweeterIdsParams
        ): CompletableFuture<HttpResponseFor<TweetGetRetweeterIdsResponse>> =
            getRetweeterIds(params, RequestOptions.none())

        /** @see getRetweeterIds */
        fun getRetweeterIds(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TweetGetRetweeterIdsResponse>> =
            getRetweeterIds(id, TweetGetRetweeterIdsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/retweeters`, but is otherwise the
         * same as [TweetServiceAsync.getRetweeters].
         */
        fun getRetweeters(id: String): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            getRetweeters(id, TweetGetRetweetersParams.none())

        /** @see getRetweeters */
        fun getRetweeters(
            id: String,
            params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            getRetweeters(params.toBuilder().id(id).build(), requestOptions)

        /** @see getRetweeters */
        fun getRetweeters(
            id: String,
            params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            getRetweeters(id, params, RequestOptions.none())

        /** @see getRetweeters */
        fun getRetweeters(
            params: TweetGetRetweetersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>>

        /** @see getRetweeters */
        fun getRetweeters(
            params: TweetGetRetweetersParams
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            getRetweeters(params, RequestOptions.none())

        /** @see getRetweeters */
        fun getRetweeters(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> =
            getRetweeters(id, TweetGetRetweetersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/subtitles`, but is otherwise the same
         * as [TweetServiceAsync.getSubtitles].
         */
        fun getSubtitles(
            id: String
        ): CompletableFuture<HttpResponseFor<TweetGetSubtitlesResponse>> =
            getSubtitles(id, TweetGetSubtitlesParams.none())

        /** @see getSubtitles */
        fun getSubtitles(
            id: String,
            params: TweetGetSubtitlesParams = TweetGetSubtitlesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetSubtitlesResponse>> =
            getSubtitles(params.toBuilder().id(id).build(), requestOptions)

        /** @see getSubtitles */
        fun getSubtitles(
            id: String,
            params: TweetGetSubtitlesParams = TweetGetSubtitlesParams.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetSubtitlesResponse>> =
            getSubtitles(id, params, RequestOptions.none())

        /** @see getSubtitles */
        fun getSubtitles(
            params: TweetGetSubtitlesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetSubtitlesResponse>>

        /** @see getSubtitles */
        fun getSubtitles(
            params: TweetGetSubtitlesParams
        ): CompletableFuture<HttpResponseFor<TweetGetSubtitlesResponse>> =
            getSubtitles(params, RequestOptions.none())

        /** @see getSubtitles */
        fun getSubtitles(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TweetGetSubtitlesResponse>> =
            getSubtitles(id, TweetGetSubtitlesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/thread`, but is otherwise the same as
         * [TweetServiceAsync.getThread].
         */
        fun getThread(id: String): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getThread(id, TweetGetThreadParams.none())

        /** @see getThread */
        fun getThread(
            id: String,
            params: TweetGetThreadParams = TweetGetThreadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getThread(params.toBuilder().id(id).build(), requestOptions)

        /** @see getThread */
        fun getThread(
            id: String,
            params: TweetGetThreadParams = TweetGetThreadParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getThread(id, params, RequestOptions.none())

        /** @see getThread */
        fun getThread(
            params: TweetGetThreadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see getThread */
        fun getThread(
            params: TweetGetThreadParams
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getThread(params, RequestOptions.none())

        /** @see getThread */
        fun getThread(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getThread(id, TweetGetThreadParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/top`, but is otherwise the same as
         * [TweetServiceAsync.listTop].
         */
        fun listTop(): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            listTop(TweetListTopParams.none())

        /** @see listTop */
        fun listTop(
            params: TweetListTopParams = TweetListTopParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see listTop */
        fun listTop(
            params: TweetListTopParams = TweetListTopParams.none()
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            listTop(params, RequestOptions.none())

        /** @see listTop */
        fun listTop(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            listTop(TweetListTopParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/links/resolve`, but is otherwise the same as
         * [TweetServiceAsync.resolveLinks].
         */
        fun resolveLinks(
            params: TweetResolveLinksParams
        ): CompletableFuture<HttpResponseFor<TweetResolveLinksResponse>> =
            resolveLinks(params, RequestOptions.none())

        /** @see resolveLinks */
        fun resolveLinks(
            params: TweetResolveLinksParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetResolveLinksResponse>>

        /**
         * Returns a raw HTTP response for `get /x/tweets/search`, but is otherwise the same as
         * [TweetServiceAsync.search].
         */
        fun search(
            params: TweetSearchParams
        ): CompletableFuture<HttpResponseFor<TweetSearchResponse>> =
            search(params, RequestOptions.none())

        /** @see search */
        fun search(
            params: TweetSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetSearchResponse>>

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/translation`, but is otherwise the
         * same as [TweetServiceAsync.translate].
         */
        fun translate(
            id: String,
            params: TweetTranslateParams,
        ): CompletableFuture<HttpResponseFor<TweetTranslateResponse>> =
            translate(id, params, RequestOptions.none())

        /** @see translate */
        fun translate(
            id: String,
            params: TweetTranslateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetTranslateResponse>> =
            translate(params.toBuilder().id(id).build(), requestOptions)

        /** @see translate */
        fun translate(
            params: TweetTranslateParams
        ): CompletableFuture<HttpResponseFor<TweetTranslateResponse>> =
            translate(params, RequestOptions.none())

        /** @see translate */
        fun translate(
            params: TweetTranslateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetTranslateResponse>>
    }
}
