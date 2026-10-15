// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
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
import com.x_twitter_scraper.api.models.x.analysis.AnalysisBrandParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisBrandResponse
import com.x_twitter_scraper.api.models.x.analysis.AnalysisClassifyParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisClassifyResponse
import com.x_twitter_scraper.api.models.x.analysis.AnalysisMarketSignalsParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisMarketSignalsResponse
import com.x_twitter_scraper.api.models.x.analysis.AnalysisNewsParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisNewsResponse
import com.x_twitter_scraper.api.models.x.analysis.AnalysisSentimentParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisSentimentResponse
import com.x_twitter_scraper.api.models.x.analysis.AnalysisViralScoreParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisViralScoreResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** AI analysis of posts, at 2 credits per analyzed post */
class AnalysisServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AnalysisServiceAsync {

    private val withRawResponse: AnalysisServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): AnalysisServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AnalysisServiceAsync =
        AnalysisServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun brand(
        params: AnalysisBrandParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AnalysisBrandResponse> =
        withRawResponse().brand(params, requestOptions).thenApply { it.parse() }

    override fun classify(
        params: AnalysisClassifyParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AnalysisClassifyResponse> =
        withRawResponse().classify(params, requestOptions).thenApply { it.parse() }

    override fun marketSignals(
        params: AnalysisMarketSignalsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AnalysisMarketSignalsResponse> =
        withRawResponse().marketSignals(params, requestOptions).thenApply { it.parse() }

    override fun news(
        params: AnalysisNewsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AnalysisNewsResponse> =
        withRawResponse().news(params, requestOptions).thenApply { it.parse() }

    override fun sentiment(
        params: AnalysisSentimentParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AnalysisSentimentResponse> =
        withRawResponse().sentiment(params, requestOptions).thenApply { it.parse() }

    override fun viralScore(
        params: AnalysisViralScoreParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AnalysisViralScoreResponse> =
        withRawResponse().viralScore(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AnalysisServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AnalysisServiceAsync.WithRawResponse =
            AnalysisServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val brandHandler: Handler<AnalysisBrandResponse> =
            jsonHandler<AnalysisBrandResponse>(clientOptions.jsonMapper)

        override fun brand(
            params: AnalysisBrandParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AnalysisBrandResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "analysis", "brand")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { brandHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val classifyHandler: Handler<AnalysisClassifyResponse> =
            jsonHandler<AnalysisClassifyResponse>(clientOptions.jsonMapper)

        override fun classify(
            params: AnalysisClassifyParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AnalysisClassifyResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "analysis", "classify")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { classifyHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val marketSignalsHandler: Handler<AnalysisMarketSignalsResponse> =
            jsonHandler<AnalysisMarketSignalsResponse>(clientOptions.jsonMapper)

        override fun marketSignals(
            params: AnalysisMarketSignalsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AnalysisMarketSignalsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "analysis", "market-signals")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { marketSignalsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val newsHandler: Handler<AnalysisNewsResponse> =
            jsonHandler<AnalysisNewsResponse>(clientOptions.jsonMapper)

        override fun news(
            params: AnalysisNewsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AnalysisNewsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "analysis", "news")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { newsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val sentimentHandler: Handler<AnalysisSentimentResponse> =
            jsonHandler<AnalysisSentimentResponse>(clientOptions.jsonMapper)

        override fun sentiment(
            params: AnalysisSentimentParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AnalysisSentimentResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "analysis", "sentiment")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { sentimentHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val viralScoreHandler: Handler<AnalysisViralScoreResponse> =
            jsonHandler<AnalysisViralScoreResponse>(clientOptions.jsonMapper)

        override fun viralScore(
            params: AnalysisViralScoreParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AnalysisViralScoreResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "analysis", "viral-score")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { viralScoreHandler.handle(it) }
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
