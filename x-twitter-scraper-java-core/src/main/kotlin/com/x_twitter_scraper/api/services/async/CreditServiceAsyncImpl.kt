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
import com.x_twitter_scraper.api.models.credits.CreditRetrieveBalanceParams
import com.x_twitter_scraper.api.models.credits.CreditRetrieveBalanceResponse
import com.x_twitter_scraper.api.models.credits.CreditTopupBalanceParams
import com.x_twitter_scraper.api.models.credits.CreditTopupBalanceResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Subscription & billing */
class CreditServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CreditServiceAsync {

    private val withRawResponse: CreditServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CreditServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CreditServiceAsync =
        CreditServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieveBalance(
        params: CreditRetrieveBalanceParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CreditRetrieveBalanceResponse> =
        // get /credits
        withRawResponse().retrieveBalance(params, requestOptions).thenApply { it.parse() }

    override fun topupBalance(
        params: CreditTopupBalanceParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CreditTopupBalanceResponse> =
        // post /credits/topup
        withRawResponse().topupBalance(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CreditServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CreditServiceAsync.WithRawResponse =
            CreditServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveBalanceHandler: Handler<CreditRetrieveBalanceResponse> =
            jsonHandler<CreditRetrieveBalanceResponse>(clientOptions.jsonMapper)

        override fun retrieveBalance(
            params: CreditRetrieveBalanceParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CreditRetrieveBalanceResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("credits")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveBalanceHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val topupBalanceHandler: Handler<CreditTopupBalanceResponse> =
            jsonHandler<CreditTopupBalanceResponse>(clientOptions.jsonMapper)

        override fun topupBalance(
            params: CreditTopupBalanceParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CreditTopupBalanceResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("credits", "topup")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { topupBalanceHandler.handle(it) }
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
