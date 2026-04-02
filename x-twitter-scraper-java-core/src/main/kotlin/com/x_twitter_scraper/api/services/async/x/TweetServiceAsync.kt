// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponse
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
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchParams
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchResponse
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

    fun like(): LikeServiceAsync

    fun retweet(): RetweetServiceAsync

    /** Create tweet */
    fun create(params: TweetCreateParams): CompletableFuture<TweetCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: TweetCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetCreateResponse>

    /** Get multiple tweets by IDs */
    fun list(params: TweetListParams): CompletableFuture<Void?> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TweetListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** Get users who liked a tweet */
    fun getFavoriters(id: String): CompletableFuture<TweetGetFavoritersResponse> =
        getFavoriters(id, TweetGetFavoritersParams.none())

    /** @see getFavoriters */
    fun getFavoriters(
        id: String,
        params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetGetFavoritersResponse> =
        getFavoriters(params.toBuilder().id(id).build(), requestOptions)

    /** @see getFavoriters */
    fun getFavoriters(
        id: String,
        params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
    ): CompletableFuture<TweetGetFavoritersResponse> =
        getFavoriters(id, params, RequestOptions.none())

    /** @see getFavoriters */
    fun getFavoriters(
        params: TweetGetFavoritersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetGetFavoritersResponse>

    /** @see getFavoriters */
    fun getFavoriters(
        params: TweetGetFavoritersParams
    ): CompletableFuture<TweetGetFavoritersResponse> = getFavoriters(params, RequestOptions.none())

    /** @see getFavoriters */
    fun getFavoriters(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<TweetGetFavoritersResponse> =
        getFavoriters(id, TweetGetFavoritersParams.none(), requestOptions)

    /** Get quote tweets of a tweet */
    fun getQuotes(id: String): CompletableFuture<TweetGetQuotesResponse> =
        getQuotes(id, TweetGetQuotesParams.none())

    /** @see getQuotes */
    fun getQuotes(
        id: String,
        params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetGetQuotesResponse> =
        getQuotes(params.toBuilder().id(id).build(), requestOptions)

    /** @see getQuotes */
    fun getQuotes(
        id: String,
        params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
    ): CompletableFuture<TweetGetQuotesResponse> = getQuotes(id, params, RequestOptions.none())

    /** @see getQuotes */
    fun getQuotes(
        params: TweetGetQuotesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetGetQuotesResponse>

    /** @see getQuotes */
    fun getQuotes(params: TweetGetQuotesParams): CompletableFuture<TweetGetQuotesResponse> =
        getQuotes(params, RequestOptions.none())

    /** @see getQuotes */
    fun getQuotes(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<TweetGetQuotesResponse> =
        getQuotes(id, TweetGetQuotesParams.none(), requestOptions)

    /** Get replies to a tweet */
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

    /** Get users who retweeted a tweet */
    fun getRetweeters(id: String): CompletableFuture<TweetGetRetweetersResponse> =
        getRetweeters(id, TweetGetRetweetersParams.none())

    /** @see getRetweeters */
    fun getRetweeters(
        id: String,
        params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetGetRetweetersResponse> =
        getRetweeters(params.toBuilder().id(id).build(), requestOptions)

    /** @see getRetweeters */
    fun getRetweeters(
        id: String,
        params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
    ): CompletableFuture<TweetGetRetweetersResponse> =
        getRetweeters(id, params, RequestOptions.none())

    /** @see getRetweeters */
    fun getRetweeters(
        params: TweetGetRetweetersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetGetRetweetersResponse>

    /** @see getRetweeters */
    fun getRetweeters(
        params: TweetGetRetweetersParams
    ): CompletableFuture<TweetGetRetweetersResponse> = getRetweeters(params, RequestOptions.none())

    /** @see getRetweeters */
    fun getRetweeters(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<TweetGetRetweetersResponse> =
        getRetweeters(id, TweetGetRetweetersParams.none(), requestOptions)

    /** Get thread context for a tweet */
    fun getThread(id: String): CompletableFuture<TweetGetThreadResponse> =
        getThread(id, TweetGetThreadParams.none())

    /** @see getThread */
    fun getThread(
        id: String,
        params: TweetGetThreadParams = TweetGetThreadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetGetThreadResponse> =
        getThread(params.toBuilder().id(id).build(), requestOptions)

    /** @see getThread */
    fun getThread(
        id: String,
        params: TweetGetThreadParams = TweetGetThreadParams.none(),
    ): CompletableFuture<TweetGetThreadResponse> = getThread(id, params, RequestOptions.none())

    /** @see getThread */
    fun getThread(
        params: TweetGetThreadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetGetThreadResponse>

    /** @see getThread */
    fun getThread(params: TweetGetThreadParams): CompletableFuture<TweetGetThreadResponse> =
        getThread(params, RequestOptions.none())

    /** @see getThread */
    fun getThread(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<TweetGetThreadResponse> =
        getThread(id, TweetGetThreadParams.none(), requestOptions)

    /** Search tweets */
    fun search(params: TweetSearchParams): CompletableFuture<TweetSearchResponse> =
        search(params, RequestOptions.none())

    /** @see search */
    fun search(
        params: TweetSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetSearchResponse>

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

        fun like(): LikeServiceAsync.WithRawResponse

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
         * Returns a raw HTTP response for `get /x/tweets`, but is otherwise the same as
         * [TweetServiceAsync.list].
         */
        fun list(params: TweetListParams): CompletableFuture<HttpResponse> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            params: TweetListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/favoriters`, but is otherwise the
         * same as [TweetServiceAsync.getFavoriters].
         */
        fun getFavoriters(
            id: String
        ): CompletableFuture<HttpResponseFor<TweetGetFavoritersResponse>> =
            getFavoriters(id, TweetGetFavoritersParams.none())

        /** @see getFavoriters */
        fun getFavoriters(
            id: String,
            params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetFavoritersResponse>> =
            getFavoriters(params.toBuilder().id(id).build(), requestOptions)

        /** @see getFavoriters */
        fun getFavoriters(
            id: String,
            params: TweetGetFavoritersParams = TweetGetFavoritersParams.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetFavoritersResponse>> =
            getFavoriters(id, params, RequestOptions.none())

        /** @see getFavoriters */
        fun getFavoriters(
            params: TweetGetFavoritersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetFavoritersResponse>>

        /** @see getFavoriters */
        fun getFavoriters(
            params: TweetGetFavoritersParams
        ): CompletableFuture<HttpResponseFor<TweetGetFavoritersResponse>> =
            getFavoriters(params, RequestOptions.none())

        /** @see getFavoriters */
        fun getFavoriters(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TweetGetFavoritersResponse>> =
            getFavoriters(id, TweetGetFavoritersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/quotes`, but is otherwise the same as
         * [TweetServiceAsync.getQuotes].
         */
        fun getQuotes(id: String): CompletableFuture<HttpResponseFor<TweetGetQuotesResponse>> =
            getQuotes(id, TweetGetQuotesParams.none())

        /** @see getQuotes */
        fun getQuotes(
            id: String,
            params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetQuotesResponse>> =
            getQuotes(params.toBuilder().id(id).build(), requestOptions)

        /** @see getQuotes */
        fun getQuotes(
            id: String,
            params: TweetGetQuotesParams = TweetGetQuotesParams.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetQuotesResponse>> =
            getQuotes(id, params, RequestOptions.none())

        /** @see getQuotes */
        fun getQuotes(
            params: TweetGetQuotesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetQuotesResponse>>

        /** @see getQuotes */
        fun getQuotes(
            params: TweetGetQuotesParams
        ): CompletableFuture<HttpResponseFor<TweetGetQuotesResponse>> =
            getQuotes(params, RequestOptions.none())

        /** @see getQuotes */
        fun getQuotes(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TweetGetQuotesResponse>> =
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
         * Returns a raw HTTP response for `get /x/tweets/{id}/retweeters`, but is otherwise the
         * same as [TweetServiceAsync.getRetweeters].
         */
        fun getRetweeters(
            id: String
        ): CompletableFuture<HttpResponseFor<TweetGetRetweetersResponse>> =
            getRetweeters(id, TweetGetRetweetersParams.none())

        /** @see getRetweeters */
        fun getRetweeters(
            id: String,
            params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetRetweetersResponse>> =
            getRetweeters(params.toBuilder().id(id).build(), requestOptions)

        /** @see getRetweeters */
        fun getRetweeters(
            id: String,
            params: TweetGetRetweetersParams = TweetGetRetweetersParams.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetRetweetersResponse>> =
            getRetweeters(id, params, RequestOptions.none())

        /** @see getRetweeters */
        fun getRetweeters(
            params: TweetGetRetweetersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetRetweetersResponse>>

        /** @see getRetweeters */
        fun getRetweeters(
            params: TweetGetRetweetersParams
        ): CompletableFuture<HttpResponseFor<TweetGetRetweetersResponse>> =
            getRetweeters(params, RequestOptions.none())

        /** @see getRetweeters */
        fun getRetweeters(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TweetGetRetweetersResponse>> =
            getRetweeters(id, TweetGetRetweetersParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/tweets/{id}/thread`, but is otherwise the same as
         * [TweetServiceAsync.getThread].
         */
        fun getThread(id: String): CompletableFuture<HttpResponseFor<TweetGetThreadResponse>> =
            getThread(id, TweetGetThreadParams.none())

        /** @see getThread */
        fun getThread(
            id: String,
            params: TweetGetThreadParams = TweetGetThreadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetThreadResponse>> =
            getThread(params.toBuilder().id(id).build(), requestOptions)

        /** @see getThread */
        fun getThread(
            id: String,
            params: TweetGetThreadParams = TweetGetThreadParams.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetThreadResponse>> =
            getThread(id, params, RequestOptions.none())

        /** @see getThread */
        fun getThread(
            params: TweetGetThreadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetGetThreadResponse>>

        /** @see getThread */
        fun getThread(
            params: TweetGetThreadParams
        ): CompletableFuture<HttpResponseFor<TweetGetThreadResponse>> =
            getThread(params, RequestOptions.none())

        /** @see getThread */
        fun getThread(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TweetGetThreadResponse>> =
            getThread(id, TweetGetThreadParams.none(), requestOptions)

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
    }
}
