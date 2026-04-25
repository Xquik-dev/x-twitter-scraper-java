// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
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
import com.x_twitter_scraper.api.services.blocking.x.AccountService
import com.x_twitter_scraper.api.services.blocking.x.BookmarkService
import com.x_twitter_scraper.api.services.blocking.x.CommunityService
import com.x_twitter_scraper.api.services.blocking.x.DmService
import com.x_twitter_scraper.api.services.blocking.x.FollowerService
import com.x_twitter_scraper.api.services.blocking.x.ListService
import com.x_twitter_scraper.api.services.blocking.x.MediaService
import com.x_twitter_scraper.api.services.blocking.x.ProfileService
import com.x_twitter_scraper.api.services.blocking.x.TweetService
import com.x_twitter_scraper.api.services.blocking.x.UserService
import java.util.function.Consumer

interface XService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): XService

    fun tweets(): TweetService

    /** Look up, search, and explore user profiles and relationships */
    fun users(): UserService

    /** Look up, search, and explore user profiles and relationships */
    fun followers(): FollowerService

    fun dm(): DmService

    /** Media upload and download */
    fun media(): MediaService

    /** X write actions (tweets, likes, follows, DMs) */
    fun profile(): ProfileService

    fun communities(): CommunityService

    /** Connected X account management */
    fun accounts(): AccountService

    /** Look up, search, and analyze individual tweets */
    fun bookmarks(): BookmarkService

    /** X List followers, members, and tweets */
    fun lists(): ListService

    /** Retrieve the full content of an X Article (long-form post) by tweet ID. */
    fun getArticle(tweetId: String): XGetArticleResponse =
        getArticle(tweetId, XGetArticleParams.none())

    /** @see getArticle */
    fun getArticle(
        tweetId: String,
        params: XGetArticleParams = XGetArticleParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): XGetArticleResponse = getArticle(params.toBuilder().tweetId(tweetId).build(), requestOptions)

    /** @see getArticle */
    fun getArticle(
        tweetId: String,
        params: XGetArticleParams = XGetArticleParams.none(),
    ): XGetArticleResponse = getArticle(tweetId, params, RequestOptions.none())

    /** @see getArticle */
    fun getArticle(
        params: XGetArticleParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): XGetArticleResponse

    /** @see getArticle */
    fun getArticle(params: XGetArticleParams): XGetArticleResponse =
        getArticle(params, RequestOptions.none())

    /** @see getArticle */
    fun getArticle(tweetId: String, requestOptions: RequestOptions): XGetArticleResponse =
        getArticle(tweetId, XGetArticleParams.none(), requestOptions)

    /** Get home timeline */
    fun getHomeTimeline(): PaginatedTweets = getHomeTimeline(XGetHomeTimelineParams.none())

    /** @see getHomeTimeline */
    fun getHomeTimeline(
        params: XGetHomeTimelineParams = XGetHomeTimelineParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PaginatedTweets

    /** @see getHomeTimeline */
    fun getHomeTimeline(
        params: XGetHomeTimelineParams = XGetHomeTimelineParams.none()
    ): PaginatedTweets = getHomeTimeline(params, RequestOptions.none())

    /** @see getHomeTimeline */
    fun getHomeTimeline(requestOptions: RequestOptions): PaginatedTweets =
        getHomeTimeline(XGetHomeTimelineParams.none(), requestOptions)

    /** Get notifications */
    fun getNotifications(): XGetNotificationsResponse =
        getNotifications(XGetNotificationsParams.none())

    /** @see getNotifications */
    fun getNotifications(
        params: XGetNotificationsParams = XGetNotificationsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): XGetNotificationsResponse

    /** @see getNotifications */
    fun getNotifications(
        params: XGetNotificationsParams = XGetNotificationsParams.none()
    ): XGetNotificationsResponse = getNotifications(params, RequestOptions.none())

    /** @see getNotifications */
    fun getNotifications(requestOptions: RequestOptions): XGetNotificationsResponse =
        getNotifications(XGetNotificationsParams.none(), requestOptions)

    /** Get trending hashtags and topics from X by region */
    fun getTrends(): XGetTrendsResponse = getTrends(XGetTrendsParams.none())

    /** @see getTrends */
    fun getTrends(
        params: XGetTrendsParams = XGetTrendsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): XGetTrendsResponse

    /** @see getTrends */
    fun getTrends(params: XGetTrendsParams = XGetTrendsParams.none()): XGetTrendsResponse =
        getTrends(params, RequestOptions.none())

    /** @see getTrends */
    fun getTrends(requestOptions: RequestOptions): XGetTrendsResponse =
        getTrends(XGetTrendsParams.none(), requestOptions)

    /** A view of [XService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): XService.WithRawResponse

        fun tweets(): TweetService.WithRawResponse

        /** Look up, search, and explore user profiles and relationships */
        fun users(): UserService.WithRawResponse

        /** Look up, search, and explore user profiles and relationships */
        fun followers(): FollowerService.WithRawResponse

        fun dm(): DmService.WithRawResponse

        /** Media upload and download */
        fun media(): MediaService.WithRawResponse

        /** X write actions (tweets, likes, follows, DMs) */
        fun profile(): ProfileService.WithRawResponse

        fun communities(): CommunityService.WithRawResponse

        /** Connected X account management */
        fun accounts(): AccountService.WithRawResponse

        /** Look up, search, and analyze individual tweets */
        fun bookmarks(): BookmarkService.WithRawResponse

        /** X List followers, members, and tweets */
        fun lists(): ListService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/articles/{tweetId}`, but is otherwise the same as
         * [XService.getArticle].
         */
        @MustBeClosed
        fun getArticle(tweetId: String): HttpResponseFor<XGetArticleResponse> =
            getArticle(tweetId, XGetArticleParams.none())

        /** @see getArticle */
        @MustBeClosed
        fun getArticle(
            tweetId: String,
            params: XGetArticleParams = XGetArticleParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<XGetArticleResponse> =
            getArticle(params.toBuilder().tweetId(tweetId).build(), requestOptions)

        /** @see getArticle */
        @MustBeClosed
        fun getArticle(
            tweetId: String,
            params: XGetArticleParams = XGetArticleParams.none(),
        ): HttpResponseFor<XGetArticleResponse> = getArticle(tweetId, params, RequestOptions.none())

        /** @see getArticle */
        @MustBeClosed
        fun getArticle(
            params: XGetArticleParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<XGetArticleResponse>

        /** @see getArticle */
        @MustBeClosed
        fun getArticle(params: XGetArticleParams): HttpResponseFor<XGetArticleResponse> =
            getArticle(params, RequestOptions.none())

        /** @see getArticle */
        @MustBeClosed
        fun getArticle(
            tweetId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<XGetArticleResponse> =
            getArticle(tweetId, XGetArticleParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/timeline`, but is otherwise the same as
         * [XService.getHomeTimeline].
         */
        @MustBeClosed
        fun getHomeTimeline(): HttpResponseFor<PaginatedTweets> =
            getHomeTimeline(XGetHomeTimelineParams.none())

        /** @see getHomeTimeline */
        @MustBeClosed
        fun getHomeTimeline(
            params: XGetHomeTimelineParams = XGetHomeTimelineParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PaginatedTweets>

        /** @see getHomeTimeline */
        @MustBeClosed
        fun getHomeTimeline(
            params: XGetHomeTimelineParams = XGetHomeTimelineParams.none()
        ): HttpResponseFor<PaginatedTweets> = getHomeTimeline(params, RequestOptions.none())

        /** @see getHomeTimeline */
        @MustBeClosed
        fun getHomeTimeline(requestOptions: RequestOptions): HttpResponseFor<PaginatedTweets> =
            getHomeTimeline(XGetHomeTimelineParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/notifications`, but is otherwise the same as
         * [XService.getNotifications].
         */
        @MustBeClosed
        fun getNotifications(): HttpResponseFor<XGetNotificationsResponse> =
            getNotifications(XGetNotificationsParams.none())

        /** @see getNotifications */
        @MustBeClosed
        fun getNotifications(
            params: XGetNotificationsParams = XGetNotificationsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<XGetNotificationsResponse>

        /** @see getNotifications */
        @MustBeClosed
        fun getNotifications(
            params: XGetNotificationsParams = XGetNotificationsParams.none()
        ): HttpResponseFor<XGetNotificationsResponse> =
            getNotifications(params, RequestOptions.none())

        /** @see getNotifications */
        @MustBeClosed
        fun getNotifications(
            requestOptions: RequestOptions
        ): HttpResponseFor<XGetNotificationsResponse> =
            getNotifications(XGetNotificationsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/trends`, but is otherwise the same as
         * [XService.getTrends].
         */
        @MustBeClosed
        fun getTrends(): HttpResponseFor<XGetTrendsResponse> = getTrends(XGetTrendsParams.none())

        /** @see getTrends */
        @MustBeClosed
        fun getTrends(
            params: XGetTrendsParams = XGetTrendsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<XGetTrendsResponse>

        /** @see getTrends */
        @MustBeClosed
        fun getTrends(
            params: XGetTrendsParams = XGetTrendsParams.none()
        ): HttpResponseFor<XGetTrendsResponse> = getTrends(params, RequestOptions.none())

        /** @see getTrends */
        @MustBeClosed
        fun getTrends(requestOptions: RequestOptions): HttpResponseFor<XGetTrendsResponse> =
            getTrends(XGetTrendsParams.none(), requestOptions)
    }
}
