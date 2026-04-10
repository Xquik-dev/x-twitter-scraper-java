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
import com.x_twitter_scraper.api.core.http.parseable
import com.x_twitter_scraper.api.core.prepareAsync
import com.x_twitter_scraper.api.models.trends.TrendListParams
import com.x_twitter_scraper.api.models.trends.TrendListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Trending topics and hashtags by region */
class TrendServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    TrendServiceAsync {

    private val withRawResponse: TrendServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TrendServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TrendServiceAsync =
        TrendServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: TrendListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<TrendListResponse> =
        // get /trends
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TrendServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TrendServiceAsync.WithRawResponse =
            TrendServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<TrendListResponse> =
            jsonHandler<TrendListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: TrendListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TrendListResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("trends")
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
    }
}
