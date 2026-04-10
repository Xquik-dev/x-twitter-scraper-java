// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.followers.FollowerCheckParams
import com.x_twitter_scraper.api.models.x.followers.FollowerCheckResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Look up, search, and explore user profiles and relationships */
interface FollowerServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FollowerServiceAsync

    /** Check if one user follows another */
    fun check(params: FollowerCheckParams): CompletableFuture<FollowerCheckResponse> =
        check(params, RequestOptions.none())

    /** @see check */
    fun check(
        params: FollowerCheckParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FollowerCheckResponse>

    /**
     * A view of [FollowerServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FollowerServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/followers/check`, but is otherwise the same as
         * [FollowerServiceAsync.check].
         */
        fun check(
            params: FollowerCheckParams
        ): CompletableFuture<HttpResponseFor<FollowerCheckResponse>> =
            check(params, RequestOptions.none())

        /** @see check */
        fun check(
            params: FollowerCheckParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FollowerCheckResponse>>
    }
}
