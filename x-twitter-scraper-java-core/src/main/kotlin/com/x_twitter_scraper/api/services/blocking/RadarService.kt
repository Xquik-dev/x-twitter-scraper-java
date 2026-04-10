// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.radar.RadarRetrieveTrendingTopicsParams
import com.x_twitter_scraper.api.models.radar.RadarRetrieveTrendingTopicsResponse
import java.util.function.Consumer

/** AI tweet composition, drafts, writing styles, and radar */
interface RadarService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RadarService

    /** Get trending topics from curated sources */
    fun retrieveTrendingTopics(): RadarRetrieveTrendingTopicsResponse =
        retrieveTrendingTopics(RadarRetrieveTrendingTopicsParams.none())

    /** @see retrieveTrendingTopics */
    fun retrieveTrendingTopics(
        params: RadarRetrieveTrendingTopicsParams = RadarRetrieveTrendingTopicsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RadarRetrieveTrendingTopicsResponse

    /** @see retrieveTrendingTopics */
    fun retrieveTrendingTopics(
        params: RadarRetrieveTrendingTopicsParams = RadarRetrieveTrendingTopicsParams.none()
    ): RadarRetrieveTrendingTopicsResponse = retrieveTrendingTopics(params, RequestOptions.none())

    /** @see retrieveTrendingTopics */
    fun retrieveTrendingTopics(
        requestOptions: RequestOptions
    ): RadarRetrieveTrendingTopicsResponse =
        retrieveTrendingTopics(RadarRetrieveTrendingTopicsParams.none(), requestOptions)

    /** A view of [RadarService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RadarService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /radar`, but is otherwise the same as
         * [RadarService.retrieveTrendingTopics].
         */
        @MustBeClosed
        fun retrieveTrendingTopics(): HttpResponseFor<RadarRetrieveTrendingTopicsResponse> =
            retrieveTrendingTopics(RadarRetrieveTrendingTopicsParams.none())

        /** @see retrieveTrendingTopics */
        @MustBeClosed
        fun retrieveTrendingTopics(
            params: RadarRetrieveTrendingTopicsParams = RadarRetrieveTrendingTopicsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RadarRetrieveTrendingTopicsResponse>

        /** @see retrieveTrendingTopics */
        @MustBeClosed
        fun retrieveTrendingTopics(
            params: RadarRetrieveTrendingTopicsParams = RadarRetrieveTrendingTopicsParams.none()
        ): HttpResponseFor<RadarRetrieveTrendingTopicsResponse> =
            retrieveTrendingTopics(params, RequestOptions.none())

        /** @see retrieveTrendingTopics */
        @MustBeClosed
        fun retrieveTrendingTopics(
            requestOptions: RequestOptions
        ): HttpResponseFor<RadarRetrieveTrendingTopicsResponse> =
            retrieveTrendingTopics(RadarRetrieveTrendingTopicsParams.none(), requestOptions)
    }
}
