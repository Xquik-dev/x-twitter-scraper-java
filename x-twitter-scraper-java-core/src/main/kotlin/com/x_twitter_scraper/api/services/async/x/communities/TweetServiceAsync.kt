// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x.communities

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListParams
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListResponse
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
    fun list(params: TweetListParams): CompletableFuture<TweetListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TweetListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TweetListResponse>

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
        fun list(params: TweetListParams): CompletableFuture<HttpResponseFor<TweetListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            params: TweetListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TweetListResponse>>
    }
}
