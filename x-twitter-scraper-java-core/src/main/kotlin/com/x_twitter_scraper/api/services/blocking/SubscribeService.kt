// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.subscribe.SubscribeCreateParams
import com.x_twitter_scraper.api.models.subscribe.SubscribeCreateResponse
import java.util.function.Consumer

/** Subscription, billing, and credits */
interface SubscribeService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SubscribeService

    /** Get checkout or billing URL */
    fun create(): SubscribeCreateResponse = create(SubscribeCreateParams.none())

    /** @see create */
    fun create(
        params: SubscribeCreateParams = SubscribeCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SubscribeCreateResponse

    /** @see create */
    fun create(
        params: SubscribeCreateParams = SubscribeCreateParams.none()
    ): SubscribeCreateResponse = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): SubscribeCreateResponse =
        create(SubscribeCreateParams.none(), requestOptions)

    /** A view of [SubscribeService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): SubscribeService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /subscribe`, but is otherwise the same as
         * [SubscribeService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<SubscribeCreateResponse> =
            create(SubscribeCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: SubscribeCreateParams = SubscribeCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SubscribeCreateResponse>

        /** @see create */
        @MustBeClosed
        fun create(
            params: SubscribeCreateParams = SubscribeCreateParams.none()
        ): HttpResponseFor<SubscribeCreateResponse> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<SubscribeCreateResponse> =
            create(SubscribeCreateParams.none(), requestOptions)
    }
}
