// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x.communities

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListByCommunityPageAsync
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListByCommunityParams
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListPageAsync
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X data lookups (subscription required) */
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

    /** Search tweets across all communities */
    fun list(params: TweetListParams): CompletableFuture<TweetListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TweetListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetListPageAsync>

    /** Get community tweets */
    fun listByCommunity(id: String): CompletableFuture<TweetListByCommunityPageAsync> =
        listByCommunity(id, TweetListByCommunityParams.none())

    /** @see listByCommunity */
    fun listByCommunity(
        id: String,
        params: TweetListByCommunityParams = TweetListByCommunityParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetListByCommunityPageAsync> =
        listByCommunity(params.toBuilder().id(id).build(), requestOptions)

    /** @see listByCommunity */
    fun listByCommunity(
        id: String,
        params: TweetListByCommunityParams = TweetListByCommunityParams.none(),
    ): CompletableFuture<TweetListByCommunityPageAsync> =
        listByCommunity(id, params, RequestOptions.none())

    /** @see listByCommunity */
    fun listByCommunity(
        params: TweetListByCommunityParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetListByCommunityPageAsync>

    /** @see listByCommunity */
    fun listByCommunity(
        params: TweetListByCommunityParams
    ): CompletableFuture<TweetListByCommunityPageAsync> =
        listByCommunity(params, RequestOptions.none())

    /** @see listByCommunity */
    fun listByCommunity(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<TweetListByCommunityPageAsync> =
        listByCommunity(id, TweetListByCommunityParams.none(), requestOptions)

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

        /**
         * Returns a raw HTTP response for `get /x/communities/tweets`, but is otherwise the same as
         * [TweetServiceAsync.list].
         */
        fun list(params: TweetListParams): CompletableFuture<HttpResponseFor<TweetListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            params: TweetListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetListPageAsync>>

        /**
         * Returns a raw HTTP response for `get /x/communities/{id}/tweets`, but is otherwise the
         * same as [TweetServiceAsync.listByCommunity].
         */
        fun listByCommunity(
            id: String
        ): CompletableFuture<HttpResponseFor<TweetListByCommunityPageAsync>> =
            listByCommunity(id, TweetListByCommunityParams.none())

        /** @see listByCommunity */
        fun listByCommunity(
            id: String,
            params: TweetListByCommunityParams = TweetListByCommunityParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetListByCommunityPageAsync>> =
            listByCommunity(params.toBuilder().id(id).build(), requestOptions)

        /** @see listByCommunity */
        fun listByCommunity(
            id: String,
            params: TweetListByCommunityParams = TweetListByCommunityParams.none(),
        ): CompletableFuture<HttpResponseFor<TweetListByCommunityPageAsync>> =
            listByCommunity(id, params, RequestOptions.none())

        /** @see listByCommunity */
        fun listByCommunity(
            params: TweetListByCommunityParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetListByCommunityPageAsync>>

        /** @see listByCommunity */
        fun listByCommunity(
            params: TweetListByCommunityParams
        ): CompletableFuture<HttpResponseFor<TweetListByCommunityPageAsync>> =
            listByCommunity(params, RequestOptions.none())

        /** @see listByCommunity */
        fun listByCommunity(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TweetListByCommunityPageAsync>> =
            listByCommunity(id, TweetListByCommunityParams.none(), requestOptions)
    }
}
