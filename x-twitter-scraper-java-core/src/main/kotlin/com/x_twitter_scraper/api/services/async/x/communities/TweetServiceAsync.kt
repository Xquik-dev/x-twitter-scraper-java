// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x.communities

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListByCommunityParams
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X Community info, members, and tweets */
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

    /** List tweets across all communities */
    fun list(params: TweetListParams): CompletableFuture<PaginatedTweets> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TweetListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** List tweets posted in a community */
    fun listByCommunity(id: String): CompletableFuture<PaginatedTweets> =
        listByCommunity(id, TweetListByCommunityParams.none())

    /** @see listByCommunity */
    fun listByCommunity(
        id: String,
        params: TweetListByCommunityParams = TweetListByCommunityParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets> =
        listByCommunity(params.toBuilder().id(id).build(), requestOptions)

    /** @see listByCommunity */
    fun listByCommunity(
        id: String,
        params: TweetListByCommunityParams = TweetListByCommunityParams.none(),
    ): CompletableFuture<PaginatedTweets> = listByCommunity(id, params, RequestOptions.none())

    /** @see listByCommunity */
    fun listByCommunity(
        params: TweetListByCommunityParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PaginatedTweets>

    /** @see listByCommunity */
    fun listByCommunity(params: TweetListByCommunityParams): CompletableFuture<PaginatedTweets> =
        listByCommunity(params, RequestOptions.none())

    /** @see listByCommunity */
    fun listByCommunity(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedTweets> =
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
        fun list(params: TweetListParams): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            params: TweetListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /**
         * Returns a raw HTTP response for `get /x/communities/{id}/tweets`, but is otherwise the
         * same as [TweetServiceAsync.listByCommunity].
         */
        fun listByCommunity(id: String): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            listByCommunity(id, TweetListByCommunityParams.none())

        /** @see listByCommunity */
        fun listByCommunity(
            id: String,
            params: TweetListByCommunityParams = TweetListByCommunityParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            listByCommunity(params.toBuilder().id(id).build(), requestOptions)

        /** @see listByCommunity */
        fun listByCommunity(
            id: String,
            params: TweetListByCommunityParams = TweetListByCommunityParams.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            listByCommunity(id, params, RequestOptions.none())

        /** @see listByCommunity */
        fun listByCommunity(
            params: TweetListByCommunityParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>>

        /** @see listByCommunity */
        fun listByCommunity(
            params: TweetListByCommunityParams
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            listByCommunity(params, RequestOptions.none())

        /** @see listByCommunity */
        fun listByCommunity(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> =
            listByCommunity(id, TweetListByCommunityParams.none(), requestOptions)
    }
}
