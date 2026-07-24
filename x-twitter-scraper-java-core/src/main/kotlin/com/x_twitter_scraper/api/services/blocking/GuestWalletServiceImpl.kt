// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.SecurityOptions
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
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletCreateParams
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletCreateResponse
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletRetrieveStatusParams
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletRetrieveStatusResponse
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletTopupParams
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletTopupResponse
import java.util.function.Consumer

/** Accountless prepaid access for paid read endpoints */
class GuestWalletServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    GuestWalletService {

    private val withRawResponse: GuestWalletService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): GuestWalletService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): GuestWalletService =
        GuestWalletServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: GuestWalletCreateParams,
        requestOptions: RequestOptions,
    ): GuestWalletCreateResponse =
        // post /guest-wallets
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieveStatus(
        params: GuestWalletRetrieveStatusParams,
        requestOptions: RequestOptions,
    ): GuestWalletRetrieveStatusResponse =
        // get /guest-wallets/status
        withRawResponse().retrieveStatus(params, requestOptions).parse()

    override fun topup(
        params: GuestWalletTopupParams,
        requestOptions: RequestOptions,
    ): GuestWalletTopupResponse =
        // post /guest-wallets/topups
        withRawResponse().topup(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GuestWalletService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GuestWalletService.WithRawResponse =
            GuestWalletServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<GuestWalletCreateResponse> =
            jsonHandler<GuestWalletCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: GuestWalletCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GuestWalletCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("guest-wallets")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, SecurityOptions.none())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveStatusHandler: Handler<GuestWalletRetrieveStatusResponse> =
            jsonHandler<GuestWalletRetrieveStatusResponse>(clientOptions.jsonMapper)

        override fun retrieveStatus(
            params: GuestWalletRetrieveStatusParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GuestWalletRetrieveStatusResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("guest-wallets", "status")
                    .build()
                    .prepare(clientOptions, params, SecurityOptions.builder().apiKey(true).build())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveStatusHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val topupHandler: Handler<GuestWalletTopupResponse> =
            jsonHandler<GuestWalletTopupResponse>(clientOptions.jsonMapper)

        override fun topup(
            params: GuestWalletTopupParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GuestWalletTopupResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("guest-wallets", "topups")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, SecurityOptions.builder().apiKey(true).build())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { topupHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
