// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.x.XGetArticleParams
import com.x_twitter_scraper.api.models.x.XGetArticleResponse
import com.x_twitter_scraper.api.models.x.XGetHomeTimelineParams
import com.x_twitter_scraper.api.models.x.XGetNotificationsParams
import com.x_twitter_scraper.api.models.x.XGetNotificationsResponse
import com.x_twitter_scraper.api.models.x.XGetTrendsParams
import com.x_twitter_scraper.api.models.x.XGetTrendsResponse
import com.x_twitter_scraper.api.services.async.x.AccountServiceAsync
import com.x_twitter_scraper.api.services.async.x.BookmarkServiceAsync
import com.x_twitter_scraper.api.services.async.x.CommunityServiceAsync
import com.x_twitter_scraper.api.services.async.x.DmServiceAsync
import com.x_twitter_scraper.api.services.async.x.FollowerServiceAsync
import com.x_twitter_scraper.api.services.async.x.ListServiceAsync
import com.x_twitter_scraper.api.services.async.x.MediaServiceAsync
import com.x_twitter_scraper.api.services.async.x.ProfileServiceAsync
import com.x_twitter_scraper.api.services.async.x.TweetServiceAsync
import com.x_twitter_scraper.api.services.async.x.UserServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X data lookups (subscription required) */
interface XServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): XServiceAsync

    fun tweets(): TweetServiceAsync

    /** X data lookups (subscription required) */
    fun users(): UserServiceAsync

    /** X data lookups (subscription required) */
    fun followers(): FollowerServiceAsync

    fun dm(): DmServiceAsync

    /** Media upload & download */
    fun media(): MediaServiceAsync

    /** X write actions (tweets, likes, follows, DMs) */
    fun profile(): ProfileServiceAsync

    fun communities(): CommunityServiceAsync

    /** Connected X account management */
    fun accounts(): AccountServiceAsync

    /** X data lookups (subscription required) */
    fun bookmarks(): BookmarkServiceAsync

    /** X data lookups (subscription required) */
    fun lists(): ListServiceAsync

    /** Retrieve the full content of an X Article (long-form post) by tweet ID. */
    fun getArticle(tweetId: String): CompletableFuture<XGetArticleResponse> =
        getArticle(tweetId, XGetArticleParams.none())

    /** @see getArticle */
    fun getArticle(
        tweetId: String,
        params: XGetArticleParams = XGetArticleParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<XGetArticleResponse> =
        getArticle(params.toBuilder().tweetId(tweetId).build(), requestOptions)

    /** @see getArticle */
    fun getArticle(
        tweetId: String,
        params: XGetArticleParams = XGetArticleParams.none(),
    ): CompletableFuture<XGetArticleResponse> = getArticle(tweetId, params, RequestOptions.none())

    /** @see getArticle */
    fun getArticle(
        params: XGetArticleParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<XGetArticleResponse>

    /** @see getArticle */
    fun getArticle(params: XGetArticleParams): CompletableFuture<XGetArticleResponse> =
        getArticle(params, RequestOptions.none())

    /** @see getArticle */
    fun getArticle(
        tweetId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<XGetArticleResponse> =
        getArticle(tweetId, XGetArticleParams.none(), requestOptions)

    /** Get home timeline */
    fun getHomeTimeline(): CompletableFuture<PaginatedTweets> =
        getHomeTimeline(XGetHomeTimelineParams.none())

    /** @see getHomeTimeline */
    fun getHomeTimeline(
        params: XGetHomeTimelineParams = XGetHomeTimelineParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see getHomeTimeline */
    fun getHomeTimeline(
        params: XGetHomeTimelineParams = XGetHomeTimelineParams.none()
    ): CompletableFuture<PaginatedTweets> = getHomeTimeline(params, RequestOptions.none())

    /** @see getHomeTimeline */
    fun getHomeTimeline(requestOptions: RequestOptions): CompletableFuture<PaginatedTweets> =
        getHomeTimeline(XGetHomeTimelineParams.none(), requestOptions)

    /** Get notifications */
    fun getNotifications(): CompletableFuture<XGetNotificationsResponse> =
        getNotifications(XGetNotificationsParams.none())

    /** @see getNotifications */
    fun getNotifications(
        params: XGetNotificationsParams = XGetNotificationsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<XGetNotificationsResponse>

    /** @see getNotifications */
    fun getNotifications(
        params: XGetNotificationsParams = XGetNotificationsParams.none()
    ): CompletableFuture<XGetNotificationsResponse> =
        getNotifications(params, RequestOptions.none())

    /** @see getNotifications */
    fun getNotifications(
        requestOptions: RequestOptions
    ): CompletableFuture<XGetNotificationsResponse> =
        getNotifications(XGetNotificationsParams.none(), requestOptions)

    /** Get trending topics */
    fun getTrends(): CompletableFuture<XGetTrendsResponse> = getTrends(XGetTrendsParams.none())

    /** @see getTrends */
    fun getTrends(
        params: XGetTrendsParams = XGetTrendsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<XGetTrendsResponse>

    /** @see getTrends */
    fun getTrends(
        params: XGetTrendsParams = XGetTrendsParams.none()
    ): CompletableFuture<XGetTrendsResponse> = getTrends(params, RequestOptions.none())

    /** @see getTrends */
    fun getTrends(requestOptions: RequestOptions): CompletableFuture<XGetTrendsResponse> =
        getTrends(XGetTrendsParams.none(), requestOptions)

    /** A view of [XServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): XServiceAsync.WithRawResponse

        fun tweets(): TweetServiceAsync.WithRawResponse

        /** X data lookups (subscription required) */
        fun users(): UserServiceAsync.WithRawResponse

        /** X data lookups (subscription required) */
        fun followers(): FollowerServiceAsync.WithRawResponse

        fun dm(): DmServiceAsync.WithRawResponse

        /** Media upload & download */
        fun media(): MediaServiceAsync.WithRawResponse

        /** X write actions (tweets, likes, follows, DMs) */
        fun profile(): ProfileServiceAsync.WithRawResponse

        fun communities(): CommunityServiceAsync.WithRawResponse

        /** Connected X account management */
        fun accounts(): AccountServiceAsync.WithRawResponse

        /** X data lookups (subscription required) */
        fun bookmarks(): BookmarkServiceAsync.WithRawResponse

        /** X data lookups (subscription required) */
        fun lists(): ListServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/articles/{tweetId}`, but is otherwise the same as
         * [XServiceAsync.getArticle].
         */
        fun getArticle(tweetId: String): CompletableFuture<HttpResponseFor<XGetArticleResponse>> =
            getArticle(tweetId, XGetArticleParams.none())

        /** @see getArticle */
        fun getArticle(
            tweetId: String,
            params: XGetArticleParams = XGetArticleParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<XGetArticleResponse>> =
            getArticle(params.toBuilder().tweetId(tweetId).build(), requestOptions)

        /** @see getArticle */
        fun getArticle(
            tweetId: String,
            params: XGetArticleParams = XGetArticleParams.none(),
        ): CompletableFuture<HttpResponseFor<XGetArticleResponse>> =
            getArticle(tweetId, params, RequestOptions.none())

        /** @see getArticle */
        fun getArticle(
            params: XGetArticleParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<XGetArticleResponse>>

        /** @see getArticle */
        fun getArticle(
            params: XGetArticleParams
        ): CompletableFuture<HttpResponseFor<XGetArticleResponse>> =
            getArticle(params, RequestOptions.none())

        /** @see getArticle */
        fun getArticle(
            tweetId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<XGetArticleResponse>> =
            getArticle(tweetId, XGetArticleParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/timeline`, but is otherwise the same as
         * [XServiceAsync.getHomeTimeline].
         */
        fun getHomeTimeline(): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getHomeTimeline(XGetHomeTimelineParams.none())

        /** @see getHomeTimeline */
        fun getHomeTimeline(
            params: XGetHomeTimelineParams = XGetHomeTimelineParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see getHomeTimeline */
        fun getHomeTimeline(
            params: XGetHomeTimelineParams = XGetHomeTimelineParams.none()
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getHomeTimeline(params, RequestOptions.none())

        /** @see getHomeTimeline */
        fun getHomeTimeline(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getHomeTimeline(XGetHomeTimelineParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/notifications`, but is otherwise the same as
         * [XServiceAsync.getNotifications].
         */
        fun getNotifications(): CompletableFuture<HttpResponseFor<XGetNotificationsResponse>> =
            getNotifications(XGetNotificationsParams.none())

        /** @see getNotifications */
        fun getNotifications(
            params: XGetNotificationsParams = XGetNotificationsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<XGetNotificationsResponse>>

        /** @see getNotifications */
        fun getNotifications(
            params: XGetNotificationsParams = XGetNotificationsParams.none()
        ): CompletableFuture<HttpResponseFor<XGetNotificationsResponse>> =
            getNotifications(params, RequestOptions.none())

        /** @see getNotifications */
        fun getNotifications(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<XGetNotificationsResponse>> =
            getNotifications(XGetNotificationsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/trends`, but is otherwise the same as
         * [XServiceAsync.getTrends].
         */
        fun getTrends(): CompletableFuture<HttpResponseFor<XGetTrendsResponse>> =
            getTrends(XGetTrendsParams.none())

        /** @see getTrends */
        fun getTrends(
            params: XGetTrendsParams = XGetTrendsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<XGetTrendsResponse>>

        /** @see getTrends */
        fun getTrends(
            params: XGetTrendsParams = XGetTrendsParams.none()
        ): CompletableFuture<HttpResponseFor<XGetTrendsResponse>> =
            getTrends(params, RequestOptions.none())

        /** @see getTrends */
        fun getTrends(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<XGetTrendsResponse>> =
            getTrends(XGetTrendsParams.none(), requestOptions)
    }
}
