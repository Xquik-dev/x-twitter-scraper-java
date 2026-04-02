// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.styles.StyleAnalyzeParams
import com.x_twitter_scraper.api.models.styles.StyleAnalyzeResponse
import com.x_twitter_scraper.api.models.styles.StyleCompareParams
import com.x_twitter_scraper.api.models.styles.StyleCompareResponse
import com.x_twitter_scraper.api.models.styles.StyleListParams
import com.x_twitter_scraper.api.models.styles.StyleListResponse
import java.util.function.Consumer

/** Tweet composition, drafts, writing styles & radar */
interface StyleService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): StyleService

    /** List cached style profiles */
    fun list(): StyleListResponse = list(StyleListParams.none())

    /** @see list */
    fun list(
        params: StyleListParams = StyleListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StyleListResponse

    /** @see list */
    fun list(params: StyleListParams = StyleListParams.none()): StyleListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): StyleListResponse =
        list(StyleListParams.none(), requestOptions)

    /** Analyze writing style from recent tweets */
    fun analyze(params: StyleAnalyzeParams): StyleAnalyzeResponse =
        analyze(params, RequestOptions.none())

    /** @see analyze */
    fun analyze(
        params: StyleAnalyzeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StyleAnalyzeResponse

    /** Compare two style profiles */
    fun compare(params: StyleCompareParams): StyleCompareResponse =
        compare(params, RequestOptions.none())

    /** @see compare */
    fun compare(
        params: StyleCompareParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StyleCompareResponse

    /** A view of [StyleService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): StyleService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /styles`, but is otherwise the same as
         * [StyleService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<StyleListResponse> = list(StyleListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: StyleListParams = StyleListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StyleListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: StyleListParams = StyleListParams.none()
        ): HttpResponseFor<StyleListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<StyleListResponse> =
            list(StyleListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /styles`, but is otherwise the same as
         * [StyleService.analyze].
         */
        @MustBeClosed
        fun analyze(params: StyleAnalyzeParams): HttpResponseFor<StyleAnalyzeResponse> =
            analyze(params, RequestOptions.none())

        /** @see analyze */
        @MustBeClosed
        fun analyze(
            params: StyleAnalyzeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StyleAnalyzeResponse>

        /**
         * Returns a raw HTTP response for `get /styles/compare`, but is otherwise the same as
         * [StyleService.compare].
         */
        @MustBeClosed
        fun compare(params: StyleCompareParams): HttpResponseFor<StyleCompareResponse> =
            compare(params, RequestOptions.none())

        /** @see compare */
        @MustBeClosed
        fun compare(
            params: StyleCompareParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StyleCompareResponse>
    }
}
