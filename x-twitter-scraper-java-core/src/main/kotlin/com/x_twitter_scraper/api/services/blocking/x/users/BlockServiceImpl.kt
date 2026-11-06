// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x.users

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
import com.x_twitter_scraper.api.models.x.users.block.BlockCreateParams
import com.x_twitter_scraper.api.models.x.users.block.BlockCreateResponse
import com.x_twitter_scraper.api.models.x.users.block.BlockDeleteParams
import com.x_twitter_scraper.api.models.x.users.block.BlockDeleteResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** X write actions (tweets, likes, follows, DMs) */
class BlockServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    BlockService {

    private val withRawResponse: BlockService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BlockService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BlockService =
        BlockServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: BlockCreateParams,
        requestOptions: RequestOptions,
    ): BlockCreateResponse = withRawResponse().create(params, requestOptions).parse()

    override fun delete(
        params: BlockDeleteParams,
        requestOptions: RequestOptions,
    ): BlockDeleteResponse = withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BlockService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BlockService.WithRawResponse =
            BlockServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<BlockCreateResponse> =
            jsonHandler<BlockCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: BlockCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BlockCreateResponse> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "users", params._pathParam(0), "block")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
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

        private val deleteHandler: Handler<BlockDeleteResponse> =
            jsonHandler<BlockDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: BlockDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BlockDeleteResponse> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "users", params._pathParam(0), "block")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
