// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.SecurityOptions
import com.x_twitter_scraper.api.core.handlers.emptyHandler
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
import com.x_twitter_scraper.api.core.prepare
import com.x_twitter_scraper.api.models.credits.CreditRedirectTopupCheckoutParams
import com.x_twitter_scraper.api.models.credits.CreditRetrieveBalanceParams
import com.x_twitter_scraper.api.models.credits.CreditRetrieveBalanceResponse
import com.x_twitter_scraper.api.models.credits.CreditRetrieveTopupStatusParams
import com.x_twitter_scraper.api.models.credits.CreditRetrieveTopupStatusResponse
import com.x_twitter_scraper.api.models.credits.CreditTopupBalanceParams
import com.x_twitter_scraper.api.models.credits.CreditTopupBalanceResponse
import java.util.function.Consumer

/** Subscription, billing, and credits */
class CreditServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CreditService {

    private val withRawResponse: CreditService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CreditService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CreditService =
        CreditServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun redirectTopupCheckout(
        params: CreditRedirectTopupCheckoutParams,
        requestOptions: RequestOptions,
    ) {
        // get /credits/topup/redirect
        withRawResponse().redirectTopupCheckout(params, requestOptions)
    }

    override fun retrieveBalance(
        params: CreditRetrieveBalanceParams,
        requestOptions: RequestOptions,
    ): CreditRetrieveBalanceResponse =
        // get /credits
        withRawResponse().retrieveBalance(params, requestOptions).parse()

    override fun retrieveTopupStatus(
        params: CreditRetrieveTopupStatusParams,
        requestOptions: RequestOptions,
    ): CreditRetrieveTopupStatusResponse =
        // get /credits/topup/status
        withRawResponse().retrieveTopupStatus(params, requestOptions).parse()

    override fun topupBalance(
        params: CreditTopupBalanceParams,
        requestOptions: RequestOptions,
    ): CreditTopupBalanceResponse =
        // post /credits/topup
        withRawResponse().topupBalance(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CreditService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CreditService.WithRawResponse =
            CreditServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val redirectTopupCheckoutHandler: Handler<Void?> = emptyHandler()

        override fun redirectTopupCheckout(
            params: CreditRedirectTopupCheckoutParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("credits", "topup", "redirect")
                    .build()
                    .prepare(clientOptions, params, SecurityOptions.none())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { redirectTopupCheckoutHandler.handle(it) }
            }
        }

        private val retrieveBalanceHandler: Handler<CreditRetrieveBalanceResponse> =
            jsonHandler<CreditRetrieveBalanceResponse>(clientOptions.jsonMapper)

        override fun retrieveBalance(
            params: CreditRetrieveBalanceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CreditRetrieveBalanceResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("credits")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveBalanceHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveTopupStatusHandler: Handler<CreditRetrieveTopupStatusResponse> =
            jsonHandler<CreditRetrieveTopupStatusResponse>(clientOptions.jsonMapper)

        override fun retrieveTopupStatus(
            params: CreditRetrieveTopupStatusParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CreditRetrieveTopupStatusResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("credits", "topup", "status")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveTopupStatusHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val topupBalanceHandler: Handler<CreditTopupBalanceResponse> =
            jsonHandler<CreditTopupBalanceResponse>(clientOptions.jsonMapper)

        override fun topupBalance(
            params: CreditTopupBalanceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CreditTopupBalanceResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("credits", "topup")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
