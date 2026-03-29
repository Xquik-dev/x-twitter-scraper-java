// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.models.extractions.ExtractionEstimateCostParams
import com.x_twitter_scraper.api.models.extractions.ExtractionEstimateCostResponse
import com.x_twitter_scraper.api.models.extractions.ExtractionExportResultsParams
import com.x_twitter_scraper.api.models.extractions.ExtractionListParams
import com.x_twitter_scraper.api.models.extractions.ExtractionListResponse
import com.x_twitter_scraper.api.models.extractions.ExtractionRetrieveParams
import com.x_twitter_scraper.api.models.extractions.ExtractionRetrieveResponse
import com.x_twitter_scraper.api.models.extractions.ExtractionRunParams
import com.x_twitter_scraper.api.models.extractions.ExtractionRunResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Bulk data extraction (20 tool types) */
interface ExtractionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ExtractionServiceAsync

    /** Get extraction results */
    fun retrieve(id: String): CompletableFuture<ExtractionRetrieveResponse> =
        retrieve(id, ExtractionRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ExtractionRetrieveParams = ExtractionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExtractionRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ExtractionRetrieveParams = ExtractionRetrieveParams.none(),
    ): CompletableFuture<ExtractionRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ExtractionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExtractionRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: ExtractionRetrieveParams): CompletableFuture<ExtractionRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExtractionRetrieveResponse> =
        retrieve(id, ExtractionRetrieveParams.none(), requestOptions)

    /** List extraction jobs */
    fun list(): CompletableFuture<ExtractionListResponse> = list(ExtractionListParams.none())

    /** @see list */
    fun list(
        params: ExtractionListParams = ExtractionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExtractionListResponse>

    /** @see list */
    fun list(
        params: ExtractionListParams = ExtractionListParams.none()
    ): CompletableFuture<ExtractionListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<ExtractionListResponse> =
        list(ExtractionListParams.none(), requestOptions)

    /** Estimate extraction cost */
    fun estimateCost(
        params: ExtractionEstimateCostParams
    ): CompletableFuture<ExtractionEstimateCostResponse> =
        estimateCost(params, RequestOptions.none())

    /** @see estimateCost */
    fun estimateCost(
        params: ExtractionEstimateCostParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExtractionEstimateCostResponse>

    /** Export extraction results */
    fun exportResults(id: String): CompletableFuture<HttpResponse> =
        exportResults(id, ExtractionExportResultsParams.none())

    /** @see exportResults */
    fun exportResults(
        id: String,
        params: ExtractionExportResultsParams = ExtractionExportResultsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse> =
        exportResults(params.toBuilder().id(id).build(), requestOptions)

    /** @see exportResults */
    fun exportResults(
        id: String,
        params: ExtractionExportResultsParams = ExtractionExportResultsParams.none(),
    ): CompletableFuture<HttpResponse> = exportResults(id, params, RequestOptions.none())

    /** @see exportResults */
    fun exportResults(
        params: ExtractionExportResultsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    /** @see exportResults */
    fun exportResults(params: ExtractionExportResultsParams): CompletableFuture<HttpResponse> =
        exportResults(params, RequestOptions.none())

    /** @see exportResults */
    fun exportResults(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
        exportResults(id, ExtractionExportResultsParams.none(), requestOptions)

    /** Run extraction */
    fun run(params: ExtractionRunParams): CompletableFuture<ExtractionRunResponse> =
        run(params, RequestOptions.none())

    /** @see run */
    fun run(
        params: ExtractionRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ExtractionRunResponse>

    /**
     * A view of [ExtractionServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ExtractionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /extractions/{id}`, but is otherwise the same as
         * [ExtractionServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<ExtractionRetrieveResponse>> =
            retrieve(id, ExtractionRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: ExtractionRetrieveParams = ExtractionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExtractionRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: ExtractionRetrieveParams = ExtractionRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ExtractionRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ExtractionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExtractionRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: ExtractionRetrieveParams
        ): CompletableFuture<HttpResponseFor<ExtractionRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExtractionRetrieveResponse>> =
            retrieve(id, ExtractionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /extractions`, but is otherwise the same as
         * [ExtractionServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<ExtractionListResponse>> =
            list(ExtractionListParams.none())

        /** @see list */
        fun list(
            params: ExtractionListParams = ExtractionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExtractionListResponse>>

        /** @see list */
        fun list(
            params: ExtractionListParams = ExtractionListParams.none()
        ): CompletableFuture<HttpResponseFor<ExtractionListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ExtractionListResponse>> =
            list(ExtractionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /extractions/estimate`, but is otherwise the same
         * as [ExtractionServiceAsync.estimateCost].
         */
        fun estimateCost(
            params: ExtractionEstimateCostParams
        ): CompletableFuture<HttpResponseFor<ExtractionEstimateCostResponse>> =
            estimateCost(params, RequestOptions.none())

        /** @see estimateCost */
        fun estimateCost(
            params: ExtractionEstimateCostParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExtractionEstimateCostResponse>>

        /**
         * Returns a raw HTTP response for `get /extractions/{id}/export`, but is otherwise the same
         * as [ExtractionServiceAsync.exportResults].
         */
        fun exportResults(id: String): CompletableFuture<HttpResponse> =
            exportResults(id, ExtractionExportResultsParams.none())

        /** @see exportResults */
        fun exportResults(
            id: String,
            params: ExtractionExportResultsParams = ExtractionExportResultsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            exportResults(params.toBuilder().id(id).build(), requestOptions)

        /** @see exportResults */
        fun exportResults(
            id: String,
            params: ExtractionExportResultsParams = ExtractionExportResultsParams.none(),
        ): CompletableFuture<HttpResponse> = exportResults(id, params, RequestOptions.none())

        /** @see exportResults */
        fun exportResults(
            params: ExtractionExportResultsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see exportResults */
        fun exportResults(params: ExtractionExportResultsParams): CompletableFuture<HttpResponse> =
            exportResults(params, RequestOptions.none())

        /** @see exportResults */
        fun exportResults(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            exportResults(id, ExtractionExportResultsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /extractions`, but is otherwise the same as
         * [ExtractionServiceAsync.run].
         */
        fun run(
            params: ExtractionRunParams
        ): CompletableFuture<HttpResponseFor<ExtractionRunResponse>> =
            run(params, RequestOptions.none())

        /** @see run */
        fun run(
            params: ExtractionRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ExtractionRunResponse>>
    }
}
