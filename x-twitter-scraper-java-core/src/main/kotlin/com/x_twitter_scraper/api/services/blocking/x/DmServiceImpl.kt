// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

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
import com.x_twitter_scraper.api.core.prepare
import com.x_twitter_scraper.api.models.x.dm.DmDeleteMessageParams
import com.x_twitter_scraper.api.models.x.dm.DmDeleteMessageResponse
import com.x_twitter_scraper.api.models.x.dm.DmRetrieveHistoryParams
import com.x_twitter_scraper.api.models.x.dm.DmRetrieveHistoryResponse
import com.x_twitter_scraper.api.models.x.dm.DmSendParams
import com.x_twitter_scraper.api.models.x.dm.DmSendResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class DmServiceImpl internal constructor(private val clientOptions: ClientOptions) : DmService {

    private val withRawResponse: DmService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): DmService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): DmService =
        DmServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun deleteMessage(
        params: DmDeleteMessageParams,
        requestOptions: RequestOptions,
    ): DmDeleteMessageResponse = withRawResponse().deleteMessage(params, requestOptions).parse()

    override fun retrieveHistory(
        params: DmRetrieveHistoryParams,
        requestOptions: RequestOptions,
    ): DmRetrieveHistoryResponse = withRawResponse().retrieveHistory(params, requestOptions).parse()

    override fun send(params: DmSendParams, requestOptions: RequestOptions): DmSendResponse =
        withRawResponse().send(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        DmService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): DmService.WithRawResponse =
            DmServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val deleteMessageHandler: Handler<DmDeleteMessageResponse> =
            jsonHandler<DmDeleteMessageResponse>(clientOptions.jsonMapper)

        override fun deleteMessage(
            params: DmDeleteMessageParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DmDeleteMessageResponse> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteMessageHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHistoryHandler: Handler<DmRetrieveHistoryResponse> =
            jsonHandler<DmRetrieveHistoryResponse>(clientOptions.jsonMapper)

        override fun retrieveHistory(
            params: DmRetrieveHistoryParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DmRetrieveHistoryResponse> {
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "dm", params._pathParam(0), "history")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHistoryHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val sendHandler: Handler<DmSendResponse> =
            jsonHandler<DmSendResponse>(clientOptions.jsonMapper)

        override fun send(
            params: DmSendParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DmSendResponse> {
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "dm", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
