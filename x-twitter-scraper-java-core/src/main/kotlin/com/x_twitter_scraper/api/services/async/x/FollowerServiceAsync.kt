// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.x.followers.FollowerRetrieveCheckParams
import com.x_twitter_scraper.api.models.x.followers.FollowerRetrieveCheckResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** X data lookups (subscription required) */
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

    /** Check follow relationship */
    fun retrieveCheck(
        params: FollowerRetrieveCheckParams
    ): CompletableFuture<FollowerRetrieveCheckResponse> =
        retrieveCheck(params, RequestOptions.none())

    /** @see retrieveCheck */
    fun retrieveCheck(
        params: FollowerRetrieveCheckParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FollowerRetrieveCheckResponse>

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
         * [FollowerServiceAsync.retrieveCheck].
         */
        fun retrieveCheck(
            params: FollowerRetrieveCheckParams
        ): CompletableFuture<HttpResponseFor<FollowerRetrieveCheckResponse>> =
            retrieveCheck(params, RequestOptions.none())

        /** @see retrieveCheck */
        fun retrieveCheck(
            params: FollowerRetrieveCheckParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FollowerRetrieveCheckResponse>>
    }
}
