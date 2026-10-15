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
import com.x_twitter_scraper.api.core.http.parseable
import com.x_twitter_scraper.api.core.prepare
import com.x_twitter_scraper.api.models.x.spaces.SpaceRetrieveParams
import com.x_twitter_scraper.api.models.x.spaces.SpaceRetrieveReplayParams
import com.x_twitter_scraper.api.models.x.spaces.SpaceRetrieveReplayResponse
import com.x_twitter_scraper.api.models.x.spaces.SpaceRetrieveResponse
import com.x_twitter_scraper.api.models.x.spaces.SpaceSearchParams
import com.x_twitter_scraper.api.models.x.spaces.SpaceSearchResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** X Space details, host, and speakers */
class SpaceServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SpaceService {

    private val withRawResponse: SpaceService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SpaceService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpaceService =
        SpaceServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: SpaceRetrieveParams,
        requestOptions: RequestOptions,
    ): SpaceRetrieveResponse = withRawResponse().retrieve(params, requestOptions).parse()

    override fun retrieveReplay(
        params: SpaceRetrieveReplayParams,
        requestOptions: RequestOptions,
    ): SpaceRetrieveReplayResponse =
        withRawResponse().retrieveReplay(params, requestOptions).parse()

    override fun search(
        params: SpaceSearchParams,
        requestOptions: RequestOptions,
    ): SpaceSearchResponse = withRawResponse().search(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SpaceService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SpaceService.WithRawResponse =
            SpaceServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<SpaceRetrieveResponse> =
            jsonHandler<SpaceRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: SpaceRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SpaceRetrieveResponse> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "spaces", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveReplayHandler: Handler<SpaceRetrieveReplayResponse> =
            jsonHandler<SpaceRetrieveReplayResponse>(clientOptions.jsonMapper)

        override fun retrieveReplay(
            params: SpaceRetrieveReplayParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SpaceRetrieveReplayResponse> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "spaces", params._pathParam(0), "replay")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveReplayHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val searchHandler: Handler<SpaceSearchResponse> =
            jsonHandler<SpaceSearchResponse>(clientOptions.jsonMapper)

        override fun search(
            params: SpaceSearchParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SpaceSearchResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "spaces", "search")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { searchHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
