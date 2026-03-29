// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
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
import java.util.function.Consumer

/** Bulk data extraction (20 tool types) */
interface ExtractionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ExtractionService

    /** Get extraction results */
    fun retrieve(id: String): ExtractionRetrieveResponse =
        retrieve(id, ExtractionRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ExtractionRetrieveParams = ExtractionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExtractionRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ExtractionRetrieveParams = ExtractionRetrieveParams.none(),
    ): ExtractionRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ExtractionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExtractionRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: ExtractionRetrieveParams): ExtractionRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): ExtractionRetrieveResponse =
        retrieve(id, ExtractionRetrieveParams.none(), requestOptions)

    /** List extraction jobs */
    fun list(): ExtractionListResponse = list(ExtractionListParams.none())

    /** @see list */
    fun list(
        params: ExtractionListParams = ExtractionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExtractionListResponse

    /** @see list */
    fun list(params: ExtractionListParams = ExtractionListParams.none()): ExtractionListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): ExtractionListResponse =
        list(ExtractionListParams.none(), requestOptions)

    /** Estimate extraction cost */
    fun estimateCost(params: ExtractionEstimateCostParams): ExtractionEstimateCostResponse =
        estimateCost(params, RequestOptions.none())

    /** @see estimateCost */
    fun estimateCost(
        params: ExtractionEstimateCostParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExtractionEstimateCostResponse

    /** Export extraction results */
    @MustBeClosed
    fun exportResults(id: String): HttpResponse =
        exportResults(id, ExtractionExportResultsParams.none())

    /** @see exportResults */
    @MustBeClosed
    fun exportResults(
        id: String,
        params: ExtractionExportResultsParams = ExtractionExportResultsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse = exportResults(params.toBuilder().id(id).build(), requestOptions)

    /** @see exportResults */
    @MustBeClosed
    fun exportResults(
        id: String,
        params: ExtractionExportResultsParams = ExtractionExportResultsParams.none(),
    ): HttpResponse = exportResults(id, params, RequestOptions.none())

    /** @see exportResults */
    @MustBeClosed
    fun exportResults(
        params: ExtractionExportResultsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    /** @see exportResults */
    @MustBeClosed
    fun exportResults(params: ExtractionExportResultsParams): HttpResponse =
        exportResults(params, RequestOptions.none())

    /** @see exportResults */
    @MustBeClosed
    fun exportResults(id: String, requestOptions: RequestOptions): HttpResponse =
        exportResults(id, ExtractionExportResultsParams.none(), requestOptions)

    /** Run extraction */
    fun run(params: ExtractionRunParams): ExtractionRunResponse = run(params, RequestOptions.none())

    /** @see run */
    fun run(
        params: ExtractionRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExtractionRunResponse

    /** A view of [ExtractionService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ExtractionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /extractions/{id}`, but is otherwise the same as
         * [ExtractionService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<ExtractionRetrieveResponse> =
            retrieve(id, ExtractionRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: ExtractionRetrieveParams = ExtractionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExtractionRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: ExtractionRetrieveParams = ExtractionRetrieveParams.none(),
        ): HttpResponseFor<ExtractionRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ExtractionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExtractionRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ExtractionRetrieveParams
        ): HttpResponseFor<ExtractionRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExtractionRetrieveResponse> =
            retrieve(id, ExtractionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /extractions`, but is otherwise the same as
         * [ExtractionService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<ExtractionListResponse> = list(ExtractionListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ExtractionListParams = ExtractionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExtractionListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: ExtractionListParams = ExtractionListParams.none()
        ): HttpResponseFor<ExtractionListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ExtractionListResponse> =
            list(ExtractionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /extractions/estimate`, but is otherwise the same
         * as [ExtractionService.estimateCost].
         */
        @MustBeClosed
        fun estimateCost(
            params: ExtractionEstimateCostParams
        ): HttpResponseFor<ExtractionEstimateCostResponse> =
            estimateCost(params, RequestOptions.none())

        /** @see estimateCost */
        @MustBeClosed
        fun estimateCost(
            params: ExtractionEstimateCostParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExtractionEstimateCostResponse>

        /**
         * Returns a raw HTTP response for `get /extractions/{id}/export`, but is otherwise the same
         * as [ExtractionService.exportResults].
         */
        @MustBeClosed
        fun exportResults(id: String): HttpResponse =
            exportResults(id, ExtractionExportResultsParams.none())

        /** @see exportResults */
        @MustBeClosed
        fun exportResults(
            id: String,
            params: ExtractionExportResultsParams = ExtractionExportResultsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = exportResults(params.toBuilder().id(id).build(), requestOptions)

        /** @see exportResults */
        @MustBeClosed
        fun exportResults(
            id: String,
            params: ExtractionExportResultsParams = ExtractionExportResultsParams.none(),
        ): HttpResponse = exportResults(id, params, RequestOptions.none())

        /** @see exportResults */
        @MustBeClosed
        fun exportResults(
            params: ExtractionExportResultsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see exportResults */
        @MustBeClosed
        fun exportResults(params: ExtractionExportResultsParams): HttpResponse =
            exportResults(params, RequestOptions.none())

        /** @see exportResults */
        @MustBeClosed
        fun exportResults(id: String, requestOptions: RequestOptions): HttpResponse =
            exportResults(id, ExtractionExportResultsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /extractions`, but is otherwise the same as
         * [ExtractionService.run].
         */
        @MustBeClosed
        fun run(params: ExtractionRunParams): HttpResponseFor<ExtractionRunResponse> =
            run(params, RequestOptions.none())

        /** @see run */
        @MustBeClosed
        fun run(
            params: ExtractionRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExtractionRunResponse>
    }
}
