// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.subscribe.SubscribeCreateParams
import com.x_twitter_scraper.api.models.subscribe.SubscribeCreateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Subscription, billing, and credits */
interface SubscribeServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SubscribeServiceAsync

    /** Get checkout or billing URL */
    fun create(): CompletableFuture<SubscribeCreateResponse> = create(SubscribeCreateParams.none())

    /** @see create */
    fun create(
        params: SubscribeCreateParams = SubscribeCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SubscribeCreateResponse>

    /** @see create */
    fun create(
        params: SubscribeCreateParams = SubscribeCreateParams.none()
    ): CompletableFuture<SubscribeCreateResponse> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<SubscribeCreateResponse> =
        create(SubscribeCreateParams.none(), requestOptions)

    /**
     * A view of [SubscribeServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SubscribeServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /subscribe`, but is otherwise the same as
         * [SubscribeServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<SubscribeCreateResponse>> =
            create(SubscribeCreateParams.none())

        /** @see create */
        fun create(
            params: SubscribeCreateParams = SubscribeCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SubscribeCreateResponse>>

        /** @see create */
        fun create(
            params: SubscribeCreateParams = SubscribeCreateParams.none()
        ): CompletableFuture<HttpResponseFor<SubscribeCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<SubscribeCreateResponse>> =
            create(SubscribeCreateParams.none(), requestOptions)
    }
}
