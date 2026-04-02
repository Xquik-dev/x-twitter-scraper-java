// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.styles.StyleAnalyzeParams
import com.x_twitter_scraper.api.models.styles.StyleAnalyzeResponse
import com.x_twitter_scraper.api.models.styles.StyleCompareParams
import com.x_twitter_scraper.api.models.styles.StyleCompareResponse
import com.x_twitter_scraper.api.models.styles.StyleListParams
import com.x_twitter_scraper.api.models.styles.StyleListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Tweet composition, drafts, writing styles & radar */
interface StyleServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): StyleServiceAsync

    /** List cached style profiles */
    fun list(): CompletableFuture<StyleListResponse> = list(StyleListParams.none())

    /** @see list */
    fun list(
        params: StyleListParams = StyleListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StyleListResponse>

    /** @see list */
    fun list(
        params: StyleListParams = StyleListParams.none()
    ): CompletableFuture<StyleListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<StyleListResponse> =
        list(StyleListParams.none(), requestOptions)

    /** Analyze writing style from recent tweets */
    fun analyze(params: StyleAnalyzeParams): CompletableFuture<StyleAnalyzeResponse> =
        analyze(params, RequestOptions.none())

    /** @see analyze */
    fun analyze(
        params: StyleAnalyzeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StyleAnalyzeResponse>

    /** Compare two style profiles */
    fun compare(params: StyleCompareParams): CompletableFuture<StyleCompareResponse> =
        compare(params, RequestOptions.none())

    /** @see compare */
    fun compare(
        params: StyleCompareParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StyleCompareResponse>

    /** A view of [StyleServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): StyleServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /styles`, but is otherwise the same as
         * [StyleServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<StyleListResponse>> =
            list(StyleListParams.none())

        /** @see list */
        fun list(
            params: StyleListParams = StyleListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StyleListResponse>>

        /** @see list */
        fun list(
            params: StyleListParams = StyleListParams.none()
        ): CompletableFuture<HttpResponseFor<StyleListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<StyleListResponse>> =
            list(StyleListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /styles`, but is otherwise the same as
         * [StyleServiceAsync.analyze].
         */
        fun analyze(
            params: StyleAnalyzeParams
        ): CompletableFuture<HttpResponseFor<StyleAnalyzeResponse>> =
            analyze(params, RequestOptions.none())

        /** @see analyze */
        fun analyze(
            params: StyleAnalyzeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StyleAnalyzeResponse>>

        /**
         * Returns a raw HTTP response for `get /styles/compare`, but is otherwise the same as
         * [StyleServiceAsync.compare].
         */
        fun compare(
            params: StyleCompareParams
        ): CompletableFuture<HttpResponseFor<StyleCompareResponse>> =
            compare(params, RequestOptions.none())

        /** @see compare */
        fun compare(
            params: StyleCompareParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StyleCompareResponse>>
    }
}
