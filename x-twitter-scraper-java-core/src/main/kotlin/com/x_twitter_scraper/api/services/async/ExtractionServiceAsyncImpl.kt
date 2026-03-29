// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.handlers.errorBodyHandler
import com.x_twitter_scraper.api.core.handlers.errorHandler
import com.x_twitter_scraper.api.core.handlers.jsonHandler
import com.x_twitter_scraper.api.core.http.HttpMethod
import com.x_twitter_scraper.api.core.http.HttpRequest
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.http.HttpResponse.Handler
import com.x_twitter_scraper.api.core.http.HttpResponseFor
import com.x_twitter_scraper.api.core.http.json
import com.x_twitter_scraper.api.core.http.parseable
import com.x_twitter_scraper.api.core.prepareAsync
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
import kotlin.jvm.optionals.getOrNull

/** Bulk data extraction (20 tool types) */
class ExtractionServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ExtractionServiceAsync {

    private val withRawResponse: ExtractionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ExtractionServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ExtractionServiceAsync =
        ExtractionServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: ExtractionRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExtractionRetrieveResponse> =
        // get /extractions/{id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: ExtractionListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExtractionListResponse> =
        // get /extractions
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun estimateCost(
        params: ExtractionEstimateCostParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExtractionEstimateCostResponse> =
        // post /extractions/estimate
        withRawResponse().estimateCost(params, requestOptions).thenApply { it.parse() }

    override fun exportResults(
        params: ExtractionExportResultsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        // get /extractions/{id}/export
        withRawResponse().exportResults(params, requestOptions)

    override fun run(
        params: ExtractionRunParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExtractionRunResponse> =
        // post /extractions
        withRawResponse().run(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ExtractionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ExtractionServiceAsync.WithRawResponse =
            ExtractionServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<ExtractionRetrieveResponse> =
            jsonHandler<ExtractionRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ExtractionRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExtractionRetrieveResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("extractions", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<ExtractionListResponse> =
            jsonHandler<ExtractionListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ExtractionListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExtractionListResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("extractions")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val estimateCostHandler: Handler<ExtractionEstimateCostResponse> =
            jsonHandler<ExtractionEstimateCostResponse>(clientOptions.jsonMapper)

        override fun estimateCost(
            params: ExtractionEstimateCostParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExtractionEstimateCostResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("extractions", "estimate")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { estimateCostHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        override fun exportResults(
            params: ExtractionExportResultsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("extractions", params._pathParam(0), "export")
                    .putHeader("Accept", "application/octet-stream")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response -> errorHandler.handle(response) }
        }

        private val runHandler: Handler<ExtractionRunResponse> =
            jsonHandler<ExtractionRunResponse>(clientOptions.jsonMapper)

        override fun run(
            params: ExtractionRunParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExtractionRunResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("extractions")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { runHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
