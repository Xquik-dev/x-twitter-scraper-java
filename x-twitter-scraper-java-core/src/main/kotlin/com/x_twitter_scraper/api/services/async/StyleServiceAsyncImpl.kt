// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

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
import com.x_twitter_scraper.api.models.styles.StyleAnalyzeParams
import com.x_twitter_scraper.api.models.styles.StyleAnalyzeResponse
import com.x_twitter_scraper.api.models.styles.StyleCompareParams
import com.x_twitter_scraper.api.models.styles.StyleCompareResponse
import com.x_twitter_scraper.api.models.styles.StyleListParams
import com.x_twitter_scraper.api.models.styles.StyleListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Tweet composition, drafts, writing styles & radar */
class StyleServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    StyleServiceAsync {

    private val withRawResponse: StyleServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): StyleServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): StyleServiceAsync =
        StyleServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: StyleListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<StyleListResponse> =
        // get /styles
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun analyze(
        params: StyleAnalyzeParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<StyleAnalyzeResponse> =
        // post /styles
        withRawResponse().analyze(params, requestOptions).thenApply { it.parse() }

    override fun compare(
        params: StyleCompareParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<StyleCompareResponse> =
        // get /styles/compare
        withRawResponse().compare(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        StyleServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): StyleServiceAsync.WithRawResponse =
            StyleServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<StyleListResponse> =
            jsonHandler<StyleListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: StyleListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StyleListResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("styles")
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

        private val analyzeHandler: Handler<StyleAnalyzeResponse> =
            jsonHandler<StyleAnalyzeResponse>(clientOptions.jsonMapper)

        override fun analyze(
            params: StyleAnalyzeParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StyleAnalyzeResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("styles")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { analyzeHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val compareHandler: Handler<StyleCompareResponse> =
            jsonHandler<StyleCompareResponse>(clientOptions.jsonMapper)

        override fun compare(
            params: StyleCompareParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StyleCompareResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("styles", "compare")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { compareHandler.handle(it) }
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
