// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.x.XAutocompleteSearchParams
import com.x_twitter_scraper.api.models.x.XAutocompleteSearchResponse
import com.x_twitter_scraper.api.models.x.XGetArticleParams
import com.x_twitter_scraper.api.models.x.XGetArticleResponse
import com.x_twitter_scraper.api.models.x.XGetHashflagsParams
import com.x_twitter_scraper.api.models.x.XGetHashflagsResponse
import com.x_twitter_scraper.api.models.x.XGetHomeTimelineParams
import com.x_twitter_scraper.api.models.x.XGetNewsStoryVersionsParams
import com.x_twitter_scraper.api.models.x.XGetNewsStoryVersionsResponse
import com.x_twitter_scraper.api.models.x.XGetNotificationsParams
import com.x_twitter_scraper.api.models.x.XGetNotificationsResponse
import com.x_twitter_scraper.api.models.x.XGetTrendLocationsParams
import com.x_twitter_scraper.api.models.x.XGetTrendLocationsResponse
import com.x_twitter_scraper.api.models.x.XGetTrendsHistoryParams
import com.x_twitter_scraper.api.models.x.XGetTrendsHistoryResponse
import com.x_twitter_scraper.api.models.x.XGetTrendsParams
import com.x_twitter_scraper.api.models.x.XGetTrendsResponse
import com.x_twitter_scraper.api.models.x.XSearchPlacesParams
import com.x_twitter_scraper.api.models.x.XSearchPlacesResponse
import com.x_twitter_scraper.api.services.async.x.AccountConnectionAttemptServiceAsync
import com.x_twitter_scraper.api.services.async.x.AccountConnectionChallengeServiceAsync
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
import com.x_twitter_scraper.api.services.async.x.WriteActionServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

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

    /** X write actions (tweets, likes, follows, DMs) */
    fun writeActions(): WriteActionServiceAsync

    fun tweets(): TweetServiceAsync

    fun users(): UserServiceAsync

    /** Look up, search, and explore user profiles and relationships */
    fun followers(): FollowerServiceAsync

    fun dm(): DmServiceAsync

    fun media(): MediaServiceAsync

    /** X write actions (tweets, likes, follows, DMs) */
    fun profile(): ProfileServiceAsync

    fun communities(): CommunityServiceAsync

    /** Connected X account management */
    fun accounts(): AccountServiceAsync

    /** Connected X account management */
    fun accountConnectionChallenges(): AccountConnectionChallengeServiceAsync

    /** Connected X account management */
    fun accountConnectionAttempts(): AccountConnectionAttemptServiceAsync

    /** Look up, search, and analyze individual tweets */
    fun bookmarks(): BookmarkServiceAsync

    /** X List followers, members, and tweets */
    fun lists(): ListServiceAsync

    /**
     * Returns the accounts, topics, hashtags & cashtags X suggests while someone types a search. X
     * may rank them differently per request. Costs 1 credit per suggestion.
     */
    fun autocompleteSearch(
        params: XAutocompleteSearchParams
    ): CompletableFuture<XAutocompleteSearchResponse> =
        autocompleteSearch(params, RequestOptions.none())

    /** @see autocompleteSearch */
    fun autocompleteSearch(
        params: XAutocompleteSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<XAutocompleteSearchResponse>

    /**
     * Retrieve the full content of an X Article (long-form post) by numeric tweet ID. Returns
     * article_not_found when the tweet is valid but is not an X Article.
     */
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

    /**
     * Returns X's hashflags, the custom emoji X shows after some hashtags. Lists the ones running
     * now unless activeOnly is false. Each returned hashflag costs 1 credit.
     */
    fun getHashflags(): CompletableFuture<XGetHashflagsResponse> =
        getHashflags(XGetHashflagsParams.none())

    /** @see getHashflags */
    fun getHashflags(
        params: XGetHashflagsParams = XGetHashflagsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<XGetHashflagsResponse>

    /** @see getHashflags */
    fun getHashflags(
        params: XGetHashflagsParams = XGetHashflagsParams.none()
    ): CompletableFuture<XGetHashflagsResponse> = getHashflags(params, RequestOptions.none())

    /** @see getHashflags */
    fun getHashflags(requestOptions: RequestOptions): CompletableFuture<XGetHashflagsResponse> =
        getHashflags(XGetHashflagsParams.none(), requestOptions)

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

    /**
     * Returns each version X wrote of 1 news story, the AI trends x.com shows under Explore & News.
     * Each version has its time, headline & text, oldest first, so you can see how the story
     * changed. X lists every version at once. Each request costs 1 credit.
     */
    fun getNewsStoryVersions(id: String): CompletableFuture<XGetNewsStoryVersionsResponse> =
        getNewsStoryVersions(id, XGetNewsStoryVersionsParams.none())

    /** @see getNewsStoryVersions */
    fun getNewsStoryVersions(
        id: String,
        params: XGetNewsStoryVersionsParams = XGetNewsStoryVersionsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<XGetNewsStoryVersionsResponse> =
        getNewsStoryVersions(params.toBuilder().id(id).build(), requestOptions)

    /** @see getNewsStoryVersions */
    fun getNewsStoryVersions(
        id: String,
        params: XGetNewsStoryVersionsParams = XGetNewsStoryVersionsParams.none(),
    ): CompletableFuture<XGetNewsStoryVersionsResponse> =
        getNewsStoryVersions(id, params, RequestOptions.none())

    /** @see getNewsStoryVersions */
    fun getNewsStoryVersions(
        params: XGetNewsStoryVersionsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<XGetNewsStoryVersionsResponse>

    /** @see getNewsStoryVersions */
    fun getNewsStoryVersions(
        params: XGetNewsStoryVersionsParams
    ): CompletableFuture<XGetNewsStoryVersionsResponse> =
        getNewsStoryVersions(params, RequestOptions.none())

    /** @see getNewsStoryVersions */
    fun getNewsStoryVersions(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<XGetNewsStoryVersionsResponse> =
        getNewsStoryVersions(id, XGetNewsStoryVersionsParams.none(), requestOptions)

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

    /**
     * Returns the places X offers trends for. Pass a location's woeid to /x/trends. Each returned
     * location costs 1 credit.
     */
    fun getTrendLocations(): CompletableFuture<XGetTrendLocationsResponse> =
        getTrendLocations(XGetTrendLocationsParams.none())

    /** @see getTrendLocations */
    fun getTrendLocations(
        params: XGetTrendLocationsParams = XGetTrendLocationsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<XGetTrendLocationsResponse>

    /** @see getTrendLocations */
    fun getTrendLocations(
        params: XGetTrendLocationsParams = XGetTrendLocationsParams.none()
    ): CompletableFuture<XGetTrendLocationsResponse> =
        getTrendLocations(params, RequestOptions.none())

    /** @see getTrendLocations */
    fun getTrendLocations(
        requestOptions: RequestOptions
    ): CompletableFuture<XGetTrendLocationsResponse> =
        getTrendLocations(XGetTrendLocationsParams.none(), requestOptions)

    /** Get trending hashtags and topics from X by region */
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

    /**
     * Returns the Twitter trends archive of a place, as the lists X showed there over a range of
     * time. Use it for trending on Twitter yesterday, last week or any day since 2026-10-13 02:20
     * UTC. Xquik stores 1 list per place every 5 minutes and keeps it for 25 months. Pick the place
     * by woeid, country or location name, the range with from & to, and the step with every. from &
     * to take a time or a span back from now, such as 7d, so a schedule can read the last day on
     * every run. Each step returns the first list stored in it, with its own time. Each returned
     * list costs 1 credit, so 24 lists cost 24 credits. A step with no stored list returns none and
     * costs nothing. 1 request returns 24 lists, or up to 100 with limit.
     */
    fun getTrendsHistory(): CompletableFuture<XGetTrendsHistoryResponse> =
        getTrendsHistory(XGetTrendsHistoryParams.none())

    /** @see getTrendsHistory */
    fun getTrendsHistory(
        params: XGetTrendsHistoryParams = XGetTrendsHistoryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<XGetTrendsHistoryResponse>

    /** @see getTrendsHistory */
    fun getTrendsHistory(
        params: XGetTrendsHistoryParams = XGetTrendsHistoryParams.none()
    ): CompletableFuture<XGetTrendsHistoryResponse> =
        getTrendsHistory(params, RequestOptions.none())

    /** @see getTrendsHistory */
    fun getTrendsHistory(
        requestOptions: RequestOptions
    ): CompletableFuture<XGetTrendsHistoryResponse> =
        getTrendsHistory(XGetTrendsHistoryParams.none(), requestOptions)

    /**
     * Finds places on X by name. Pass a place's id as place to /x/tweets/search to read posts
     * tagged there. X ranks the places, so their order can differ between requests. Each returned
     * place costs 1 credit.
     */
    fun searchPlaces(params: XSearchPlacesParams): CompletableFuture<XSearchPlacesResponse> =
        searchPlaces(params, RequestOptions.none())

    /** @see searchPlaces */
    fun searchPlaces(
        params: XSearchPlacesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<XSearchPlacesResponse>

    /** A view of [XServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): XServiceAsync.WithRawResponse

        /** X write actions (tweets, likes, follows, DMs) */
        fun writeActions(): WriteActionServiceAsync.WithRawResponse

        fun tweets(): TweetServiceAsync.WithRawResponse

        fun users(): UserServiceAsync.WithRawResponse

        /** Look up, search, and explore user profiles and relationships */
        fun followers(): FollowerServiceAsync.WithRawResponse

        fun dm(): DmServiceAsync.WithRawResponse

        fun media(): MediaServiceAsync.WithRawResponse

        /** X write actions (tweets, likes, follows, DMs) */
        fun profile(): ProfileServiceAsync.WithRawResponse

        fun communities(): CommunityServiceAsync.WithRawResponse

        /** Connected X account management */
        fun accounts(): AccountServiceAsync.WithRawResponse

        /** Connected X account management */
        fun accountConnectionChallenges(): AccountConnectionChallengeServiceAsync.WithRawResponse

        /** Connected X account management */
        fun accountConnectionAttempts(): AccountConnectionAttemptServiceAsync.WithRawResponse

        /** Look up, search, and analyze individual tweets */
        fun bookmarks(): BookmarkServiceAsync.WithRawResponse

        /** X List followers, members, and tweets */
        fun lists(): ListServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/search/autocomplete`, but is otherwise the same
         * as [XServiceAsync.autocompleteSearch].
         */
        fun autocompleteSearch(
            params: XAutocompleteSearchParams
        ): CompletableFuture<HttpResponseFor<XAutocompleteSearchResponse>> =
            autocompleteSearch(params, RequestOptions.none())

        /** @see autocompleteSearch */
        fun autocompleteSearch(
            params: XAutocompleteSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<XAutocompleteSearchResponse>>

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
         * Returns a raw HTTP response for `get /x/hashflags`, but is otherwise the same as
         * [XServiceAsync.getHashflags].
         */
        fun getHashflags(): CompletableFuture<HttpResponseFor<XGetHashflagsResponse>> =
            getHashflags(XGetHashflagsParams.none())

        /** @see getHashflags */
        fun getHashflags(
            params: XGetHashflagsParams = XGetHashflagsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<XGetHashflagsResponse>>

        /** @see getHashflags */
        fun getHashflags(
            params: XGetHashflagsParams = XGetHashflagsParams.none()
        ): CompletableFuture<HttpResponseFor<XGetHashflagsResponse>> =
            getHashflags(params, RequestOptions.none())

        /** @see getHashflags */
        fun getHashflags(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<XGetHashflagsResponse>> =
            getHashflags(XGetHashflagsParams.none(), requestOptions)

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
         * Returns a raw HTTP response for `get /x/news/{id}/versions`, but is otherwise the same as
         * [XServiceAsync.getNewsStoryVersions].
         */
        fun getNewsStoryVersions(
            id: String
        ): CompletableFuture<HttpResponseFor<XGetNewsStoryVersionsResponse>> =
            getNewsStoryVersions(id, XGetNewsStoryVersionsParams.none())

        /** @see getNewsStoryVersions */
        fun getNewsStoryVersions(
            id: String,
            params: XGetNewsStoryVersionsParams = XGetNewsStoryVersionsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<XGetNewsStoryVersionsResponse>> =
            getNewsStoryVersions(params.toBuilder().id(id).build(), requestOptions)

        /** @see getNewsStoryVersions */
        fun getNewsStoryVersions(
            id: String,
            params: XGetNewsStoryVersionsParams = XGetNewsStoryVersionsParams.none(),
        ): CompletableFuture<HttpResponseFor<XGetNewsStoryVersionsResponse>> =
            getNewsStoryVersions(id, params, RequestOptions.none())

        /** @see getNewsStoryVersions */
        fun getNewsStoryVersions(
            params: XGetNewsStoryVersionsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<XGetNewsStoryVersionsResponse>>

        /** @see getNewsStoryVersions */
        fun getNewsStoryVersions(
            params: XGetNewsStoryVersionsParams
        ): CompletableFuture<HttpResponseFor<XGetNewsStoryVersionsResponse>> =
            getNewsStoryVersions(params, RequestOptions.none())

        /** @see getNewsStoryVersions */
        fun getNewsStoryVersions(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<XGetNewsStoryVersionsResponse>> =
            getNewsStoryVersions(id, XGetNewsStoryVersionsParams.none(), requestOptions)

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
         * Returns a raw HTTP response for `get /x/trends/locations`, but is otherwise the same as
         * [XServiceAsync.getTrendLocations].
         */
        fun getTrendLocations(): CompletableFuture<HttpResponseFor<XGetTrendLocationsResponse>> =
            getTrendLocations(XGetTrendLocationsParams.none())

        /** @see getTrendLocations */
        fun getTrendLocations(
            params: XGetTrendLocationsParams = XGetTrendLocationsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<XGetTrendLocationsResponse>>

        /** @see getTrendLocations */
        fun getTrendLocations(
            params: XGetTrendLocationsParams = XGetTrendLocationsParams.none()
        ): CompletableFuture<HttpResponseFor<XGetTrendLocationsResponse>> =
            getTrendLocations(params, RequestOptions.none())

        /** @see getTrendLocations */
        fun getTrendLocations(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<XGetTrendLocationsResponse>> =
            getTrendLocations(XGetTrendLocationsParams.none(), requestOptions)

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

        /**
         * Returns a raw HTTP response for `get /x/trends/history`, but is otherwise the same as
         * [XServiceAsync.getTrendsHistory].
         */
        fun getTrendsHistory(): CompletableFuture<HttpResponseFor<XGetTrendsHistoryResponse>> =
            getTrendsHistory(XGetTrendsHistoryParams.none())

        /** @see getTrendsHistory */
        fun getTrendsHistory(
            params: XGetTrendsHistoryParams = XGetTrendsHistoryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<XGetTrendsHistoryResponse>>

        /** @see getTrendsHistory */
        fun getTrendsHistory(
            params: XGetTrendsHistoryParams = XGetTrendsHistoryParams.none()
        ): CompletableFuture<HttpResponseFor<XGetTrendsHistoryResponse>> =
            getTrendsHistory(params, RequestOptions.none())

        /** @see getTrendsHistory */
        fun getTrendsHistory(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<XGetTrendsHistoryResponse>> =
            getTrendsHistory(XGetTrendsHistoryParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/places/search`, but is otherwise the same as
         * [XServiceAsync.searchPlaces].
         */
        fun searchPlaces(
            params: XSearchPlacesParams
        ): CompletableFuture<HttpResponseFor<XSearchPlacesResponse>> =
            searchPlaces(params, RequestOptions.none())

        /** @see searchPlaces */
        fun searchPlaces(
            params: XSearchPlacesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<XSearchPlacesResponse>>
    }
}
