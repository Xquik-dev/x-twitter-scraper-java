// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.PaginatedUsers
import com.x_twitter_scraper.api.models.x.tweets.TweetCreateParams
import com.x_twitter_scraper.api.models.x.tweets.TweetCreateResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetDeleteParams
import com.x_twitter_scraper.api.models.x.tweets.TweetDeleteResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetFavoritersParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetQuotesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRepliesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRetweetersParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetThreadParams
import com.x_twitter_scraper.api.models.x.tweets.TweetListParams
import com.x_twitter_scraper.api.models.x.tweets.TweetRetrieveParams
import com.x_twitter_scraper.api.models.x.tweets.TweetRetrieveResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchParams
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

    /** Look up tweet */
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

    /** Get users who liked a tweet */
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

    /** Get quote tweets of a tweet */
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

    /** Get replies to a tweet */
    fun getReplies(id: String): CompletableFuture<PaginatedTweets> =
        getReplies(id, TweetGetRepliesParams.none())

    /** @see getReplies */
    fun getReplies(
        id: String,
        params: TweetGetRepliesParams = TweetGetRepliesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets> =
        getReplies(params.toBuilder().id(id).build(), requestOptions)

    /** @see getReplies */
    fun getReplies(
        id: String,
        params: TweetGetRepliesParams = TweetGetRepliesParams.none(),
    ): CompletableFuture<PaginatedTweets> = getReplies(id, params, RequestOptions.none())

    /** @see getReplies */
    fun getReplies(
        params: TweetGetRepliesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see getReplies */
    fun getReplies(params: TweetGetRepliesParams): CompletableFuture<PaginatedTweets> =
        getReplies(params, RequestOptions.none())

    /** @see getReplies */
    fun getReplies(id: String, requestOptions: RequestOptions): CompletableFuture<PaginatedTweets> =
        getReplies(id, TweetGetRepliesParams.none(), requestOptions)

    /** Get users who retweeted a tweet */
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

    /** Get thread context for a tweet */
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

    /** Search tweets */
    fun search(params: TweetSearchParams): CompletableFuture<PaginatedTweets> =
        search(params, RequestOptions.none())

    /** @see search */
    fun search(
        params: TweetSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

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
        fun getReplies(id: String): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getReplies(id, TweetGetRepliesParams.none())

        /** @see getReplies */
        fun getReplies(
            id: String,
            params: TweetGetRepliesParams = TweetGetRepliesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getReplies(params.toBuilder().id(id).build(), requestOptions)

        /** @see getReplies */
        fun getReplies(
            id: String,
            params: TweetGetRepliesParams = TweetGetRepliesParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getReplies(id, params, RequestOptions.none())

        /** @see getReplies */
        fun getReplies(
            params: TweetGetRepliesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see getReplies */
        fun getReplies(
            params: TweetGetRepliesParams
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getReplies(params, RequestOptions.none())

        /** @see getReplies */
        fun getReplies(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            getReplies(id, TweetGetRepliesParams.none(), requestOptions)

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
         * Returns a raw HTTP response for `get /x/tweets/search`, but is otherwise the same as
         * [TweetServiceAsync.search].
         */
        fun search(params: TweetSearchParams): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            search(params, RequestOptions.none())

        /** @see search */
        fun search(
            params: TweetSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>
    }
}
