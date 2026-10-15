// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

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
import com.x_twitter_scraper.api.models.x.dm.DmDeleteMessageParams
import com.x_twitter_scraper.api.models.x.dm.DmDeleteMessageResponse
import com.x_twitter_scraper.api.models.x.dm.DmRetrieveHistoryParams
import com.x_twitter_scraper.api.models.x.dm.DmRetrieveHistoryResponse
import com.x_twitter_scraper.api.models.x.dm.DmSendParams
import com.x_twitter_scraper.api.models.x.dm.DmSendResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class DmServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    DmServiceAsync {

    private val withRawResponse: DmServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): DmServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): DmServiceAsync =
        DmServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun deleteMessage(
        params: DmDeleteMessageParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<DmDeleteMessageResponse> =
        withRawResponse().deleteMessage(params, requestOptions).thenApply { it.parse() }

    override fun retrieveHistory(
        params: DmRetrieveHistoryParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<DmRetrieveHistoryResponse> =
        withRawResponse().retrieveHistory(params, requestOptions).thenApply { it.parse() }

    override fun send(
        params: DmSendParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<DmSendResponse> =
        withRawResponse().send(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        DmServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): DmServiceAsync.WithRawResponse =
            DmServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val deleteMessageHandler: Handler<DmDeleteMessageResponse> =
            jsonHandler<DmDeleteMessageResponse>(clientOptions.jsonMapper)

        override fun deleteMessage(
            params: DmDeleteMessageParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<DmDeleteMessageResponse>> {
            checkRequired("messageId", params.messageId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "x",
                        "dm",
                        params._pathParam(0),
                        "messages",
                        params._pathParam(1),
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { deleteMessageHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveHistoryHandler: Handler<DmRetrieveHistoryResponse> =
            jsonHandler<DmRetrieveHistoryResponse>(clientOptions.jsonMapper)

        override fun retrieveHistory(
            params: DmRetrieveHistoryParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<DmRetrieveHistoryResponse>> {
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "dm", params._pathParam(0), "history")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveHistoryHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val sendHandler: Handler<DmSendResponse> =
            jsonHandler<DmSendResponse>(clientOptions.jsonMapper)

        override fun send(
            params: DmSendParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<DmSendResponse>> {
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "dm", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { sendHandler.handle(it) }
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
