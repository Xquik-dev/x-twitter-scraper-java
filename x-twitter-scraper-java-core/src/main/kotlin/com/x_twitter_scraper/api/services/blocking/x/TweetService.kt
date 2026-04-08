// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.tweets.TweetCreateParams
import com.x_twitter_scraper.api.models.x.tweets.TweetCreateResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetFavoritersParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetFavoritersResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetQuotesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetQuotesResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRepliesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRepliesResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRetweetersParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRetweetersResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetThreadParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetThreadResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetListParams
import com.x_twitter_scraper.api.models.x.tweets.TweetListResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchParams
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchResponse
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

    fun like(): LikeService

    fun retweet(): RetweetService

    /** Create tweet */
    fun create(params: TweetCreateParams): TweetCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: TweetCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetCreateResponse

    /** Get multiple tweets by IDs */
    fun list(params: TweetListParams): TweetListResponse = list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TweetListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetListResponse

    /** Get users who liked a tweet */
    fun getFavoriters(id: String): TweetGetFavoritersResponse =
        getFavoriters(id, TweetGetFavoritersParams.none())

    /** @see getFavoriters */
    fun getFavoriters(
        id: String,
        params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetGetFavoritersResponse = getFavoriters(params.toBuilder().id(id).build(), requestOptions)

    /** @see getFavoriters */
    fun getFavoriters(
        id: String,
        params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
    ): TweetGetFavoritersResponse = getFavoriters(id, params, RequestOptions.none())

    /** @see getFavoriters */
    fun getFavoriters(
        params: TweetGetFavoritersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetGetFavoritersResponse

    /** @see getFavoriters */
    fun getFavoriters(params: TweetGetFavoritersParams): TweetGetFavoritersResponse =
        getFavoriters(params, RequestOptions.none())

    /** @see getFavoriters */
    fun getFavoriters(id: String, requestOptions: RequestOptions): TweetGetFavoritersResponse =
        getFavoriters(id, TweetGetFavoritersParams.none(), requestOptions)

    /** Get quote tweets of a tweet */
    fun getQuotes(id: String): TweetGetQuotesResponse = getQuotes(id, TweetGetQuotesParams.none())

    /** @see getQuotes */
    fun getQuotes(
        id: String,
        params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetGetQuotesResponse = getQuotes(params.toBuilder().id(id).build(), requestOptions)

    /** @see getQuotes */
    fun getQuotes(
        id: String,
        params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
    ): TweetGetQuotesResponse = getQuotes(id, params, RequestOptions.none())

    /** @see getQuotes */
    fun getQuotes(
        params: TweetGetQuotesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetGetQuotesResponse

    /** @see getQuotes */
    fun getQuotes(params: TweetGetQuotesParams): TweetGetQuotesResponse =
        getQuotes(params, RequestOptions.none())

    /** @see getQuotes */
    fun getQuotes(id: String, requestOptions: RequestOptions): TweetGetQuotesResponse =
        getQuotes(id, TweetGetQuotesParams.none(), requestOptions)

    /** Get replies to a tweet */
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

    /** Get users who retweeted a tweet */
    fun getRetweeters(id: String): TweetGetRetweetersResponse =
        getRetweeters(id, TweetGetRetweetersParams.none())

    /** @see getRetweeters */
    fun getRetweeters(
        id: String,
        params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetGetRetweetersResponse = getRetweeters(params.toBuilder().id(id).build(), requestOptions)

    /** @see getRetweeters */
    fun getRetweeters(
        id: String,
        params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
    ): TweetGetRetweetersResponse = getRetweeters(id, params, RequestOptions.none())

    /** @see getRetweeters */
    fun getRetweeters(
        params: TweetGetRetweetersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetGetRetweetersResponse

    /** @see getRetweeters */
    fun getRetweeters(params: TweetGetRetweetersParams): TweetGetRetweetersResponse =
        getRetweeters(params, RequestOptions.none())

    /** @see getRetweeters */
    fun getRetweeters(id: String, requestOptions: RequestOptions): TweetGetRetweetersResponse =
        getRetweeters(id, TweetGetRetweetersParams.none(), requestOptions)

    /** Get thread context for a tweet */
    fun getThread(id: String): TweetGetThreadResponse = getThread(id, TweetGetThreadParams.none())

    /** @see getThread */
    fun getThread(
        id: String,
        params: TweetGetThreadParams = TweetGetThreadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetGetThreadResponse = getThread(params.toBuilder().id(id).build(), requestOptions)

    /** @see getThread */
    fun getThread(
        id: String,
        params: TweetGetThreadParams = TweetGetThreadParams.none(),
    ): TweetGetThreadResponse = getThread(id, params, RequestOptions.none())

    /** @see getThread */
    fun getThread(
        params: TweetGetThreadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetGetThreadResponse

    /** @see getThread */
    fun getThread(params: TweetGetThreadParams): TweetGetThreadResponse =
        getThread(params, RequestOptions.none())

    /** @see getThread */
    fun getThread(id: String, requestOptions: RequestOptions): TweetGetThreadResponse =
        getThread(id, TweetGetThreadParams.none(), requestOptions)

    /** Search tweets */
    fun search(params: TweetSearchParams): TweetSearchResponse =
        search(params, RequestOptions.none())

    /** @see search */
    fun search(
        params: TweetSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TweetSearchResponse

    /** A view of [TweetService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): TweetService.WithRawResponse

        fun like(): LikeService.WithRawResponse

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
         * Returns a raw HTTP response for `get /x/tweets`, but is otherwise the same as
         * [TweetService.list].
         */
        @MustBeClosed
        fun list(params: TweetListParams): HttpResponseFor<TweetListResponse> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: TweetListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetListResponse>

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/favoriters`, but is otherwise the
         * same as [TweetService.getFavoriters].
         */
        @MustBeClosed
        fun getFavoriters(id: String): HttpResponseFor<TweetGetFavoritersResponse> =
            getFavoriters(id, TweetGetFavoritersParams.none())

        /** @see getFavoriters */
        @MustBeClosed
        fun getFavoriters(
            id: String,
            params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetGetFavoritersResponse> =
            getFavoriters(params.toBuilder().id(id).build(), requestOptions)

        /** @see getFavoriters */
        @MustBeClosed
        fun getFavoriters(
            id: String,
            params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
        ): HttpResponseFor<TweetGetFavoritersResponse> =
            getFavoriters(id, params, RequestOptions.none())

        /** @see getFavoriters */
        @MustBeClosed
        fun getFavoriters(
            params: TweetGetFavoritersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetGetFavoritersResponse>

        /** @see getFavoriters */
        @MustBeClosed
        fun getFavoriters(
            params: TweetGetFavoritersParams
        ): HttpResponseFor<TweetGetFavoritersResponse> =
            getFavoriters(params, RequestOptions.none())

        /** @see getFavoriters */
        @MustBeClosed
        fun getFavoriters(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetGetFavoritersResponse> =
            getFavoriters(id, TweetGetFavoritersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/quotes`, but is otherwise the same as
         * [TweetService.getQuotes].
         */
        @MustBeClosed
        fun getQuotes(id: String): HttpResponseFor<TweetGetQuotesResponse> =
            getQuotes(id, TweetGetQuotesParams.none())

        /** @see getQuotes */
        @MustBeClosed
        fun getQuotes(
            id: String,
            params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetGetQuotesResponse> =
            getQuotes(params.toBuilder().id(id).build(), requestOptions)

        /** @see getQuotes */
        @MustBeClosed
        fun getQuotes(
            id: String,
            params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
        ): HttpResponseFor<TweetGetQuotesResponse> = getQuotes(id, params, RequestOptions.none())

        /** @see getQuotes */
        @MustBeClosed
        fun getQuotes(
            params: TweetGetQuotesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetGetQuotesResponse>

        /** @see getQuotes */
        @MustBeClosed
        fun getQuotes(params: TweetGetQuotesParams): HttpResponseFor<TweetGetQuotesResponse> =
            getQuotes(params, RequestOptions.none())

        /** @see getQuotes */
        @MustBeClosed
        fun getQuotes(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetGetQuotesResponse> =
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
         * Returns a raw HTTP response for `get /x/tweets/{id}/retweeters`, but is otherwise the
         * same as [TweetService.getRetweeters].
         */
        @MustBeClosed
        fun getRetweeters(id: String): HttpResponseFor<TweetGetRetweetersResponse> =
            getRetweeters(id, TweetGetRetweetersParams.none())

        /** @see getRetweeters */
        @MustBeClosed
        fun getRetweeters(
            id: String,
            params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetGetRetweetersResponse> =
            getRetweeters(params.toBuilder().id(id).build(), requestOptions)

        /** @see getRetweeters */
        @MustBeClosed
        fun getRetweeters(
            id: String,
            params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
        ): HttpResponseFor<TweetGetRetweetersResponse> =
            getRetweeters(id, params, RequestOptions.none())

        /** @see getRetweeters */
        @MustBeClosed
        fun getRetweeters(
            params: TweetGetRetweetersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetGetRetweetersResponse>

        /** @see getRetweeters */
        @MustBeClosed
        fun getRetweeters(
            params: TweetGetRetweetersParams
        ): HttpResponseFor<TweetGetRetweetersResponse> =
            getRetweeters(params, RequestOptions.none())

        /** @see getRetweeters */
        @MustBeClosed
        fun getRetweeters(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetGetRetweetersResponse> =
            getRetweeters(id, TweetGetRetweetersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/thread`, but is otherwise the same as
         * [TweetService.getThread].
         */
        @MustBeClosed
        fun getThread(id: String): HttpResponseFor<TweetGetThreadResponse> =
            getThread(id, TweetGetThreadParams.none())

        /** @see getThread */
        @MustBeClosed
        fun getThread(
            id: String,
            params: TweetGetThreadParams = TweetGetThreadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetGetThreadResponse> =
            getThread(params.toBuilder().id(id).build(), requestOptions)

        /** @see getThread */
        @MustBeClosed
        fun getThread(
            id: String,
            params: TweetGetThreadParams = TweetGetThreadParams.none(),
        ): HttpResponseFor<TweetGetThreadResponse> = getThread(id, params, RequestOptions.none())

        /** @see getThread */
        @MustBeClosed
        fun getThread(
            params: TweetGetThreadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TweetGetThreadResponse>

        /** @see getThread */
        @MustBeClosed
        fun getThread(params: TweetGetThreadParams): HttpResponseFor<TweetGetThreadResponse> =
            getThread(params, RequestOptions.none())

        /** @see getThread */
        @MustBeClosed
        fun getThread(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetGetThreadResponse> =
            getThread(id, TweetGetThreadParams.none(), requestOptions)

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
    }
}
