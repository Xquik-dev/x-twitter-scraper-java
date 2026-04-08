// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.trends.TrendListParams
import com.x_twitter_scraper.api.models.trends.TrendListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Trending topics by region */
interface TrendServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TrendServiceAsync

    /** Get regional trending topics */
    fun list(): CompletableFuture<TrendListResponse> = list(TrendListParams.none())

    /** @see list */
    fun list(
        params: TrendListParams = TrendListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TrendListResponse>

    /** @see list */
    fun list(
        params: TrendListParams = TrendListParams.none()
    ): CompletableFuture<TrendListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<TrendListResponse> =
        list(TrendListParams.none(), requestOptions)

    /** A view of [TrendServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TrendServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /trends`, but is otherwise the same as
         * [TrendServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<TrendListResponse>> =
            list(TrendListParams.none())

        /** @see list */
        fun list(
            params: TrendListParams = TrendListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TrendListResponse>>

        /** @see list */
        fun list(
            params: TrendListParams = TrendListParams.none()
        ): CompletableFuture<HttpResponseFor<TrendListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<TrendListResponse>> =
            list(TrendListParams.none(), requestOptions)
    }
}
