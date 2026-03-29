// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.radar.RadarRetrieveTrendingTopicsParams
import com.x_twitter_scraper.api.models.radar.RadarRetrieveTrendingTopicsResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Tweet composition, drafts, writing styles & radar */
interface RadarServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RadarServiceAsync

    /** Get trending topics from curated sources */
    fun retrieveTrendingTopics(): CompletableFuture<RadarRetrieveTrendingTopicsResponse> =
        retrieveTrendingTopics(RadarRetrieveTrendingTopicsParams.none())

    /** @see retrieveTrendingTopics */
    fun retrieveTrendingTopics(
        params: RadarRetrieveTrendingTopicsParams = RadarRetrieveTrendingTopicsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RadarRetrieveTrendingTopicsResponse>

    /** @see retrieveTrendingTopics */
    fun retrieveTrendingTopics(
        params: RadarRetrieveTrendingTopicsParams = RadarRetrieveTrendingTopicsParams.none()
    ): CompletableFuture<RadarRetrieveTrendingTopicsResponse> =
        retrieveTrendingTopics(params, RequestOptions.none())

    /** @see retrieveTrendingTopics */
    fun retrieveTrendingTopics(
        requestOptions: RequestOptions
    ): CompletableFuture<RadarRetrieveTrendingTopicsResponse> =
        retrieveTrendingTopics(RadarRetrieveTrendingTopicsParams.none(), requestOptions)

    /** A view of [RadarServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RadarServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /radar`, but is otherwise the same as
         * [RadarServiceAsync.retrieveTrendingTopics].
         */
        fun retrieveTrendingTopics():
            CompletableFuture<HttpResponseFor<RadarRetrieveTrendingTopicsResponse>> =
            retrieveTrendingTopics(RadarRetrieveTrendingTopicsParams.none())

        /** @see retrieveTrendingTopics */
        fun retrieveTrendingTopics(
            params: RadarRetrieveTrendingTopicsParams = RadarRetrieveTrendingTopicsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RadarRetrieveTrendingTopicsResponse>>

        /** @see retrieveTrendingTopics */
        fun retrieveTrendingTopics(
            params: RadarRetrieveTrendingTopicsParams = RadarRetrieveTrendingTopicsParams.none()
        ): CompletableFuture<HttpResponseFor<RadarRetrieveTrendingTopicsResponse>> =
            retrieveTrendingTopics(params, RequestOptions.none())

        /** @see retrieveTrendingTopics */
        fun retrieveTrendingTopics(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<RadarRetrieveTrendingTopicsResponse>> =
            retrieveTrendingTopics(RadarRetrieveTrendingTopicsParams.none(), requestOptions)
    }
}
