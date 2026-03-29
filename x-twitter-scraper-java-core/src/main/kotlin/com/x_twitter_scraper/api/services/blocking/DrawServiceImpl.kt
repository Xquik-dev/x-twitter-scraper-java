// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

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
import com.x_twitter_scraper.api.models.draws.DrawExportParams
import com.x_twitter_scraper.api.models.draws.DrawListParams
import com.x_twitter_scraper.api.models.draws.DrawListResponse
import com.x_twitter_scraper.api.models.draws.DrawRetrieveParams
import com.x_twitter_scraper.api.models.draws.DrawRetrieveResponse
import com.x_twitter_scraper.api.models.draws.DrawRunParams
import com.x_twitter_scraper.api.models.draws.DrawRunResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** Giveaway draws from tweet replies */
class DrawServiceImpl internal constructor(private val clientOptions: ClientOptions) : DrawService {

    private val withRawResponse: DrawService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): DrawService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): DrawService =
        DrawServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: DrawRetrieveParams,
        requestOptions: RequestOptions,
    ): DrawRetrieveResponse =
        // get /draws/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: DrawListParams, requestOptions: RequestOptions): DrawListResponse =
        // get /draws
        withRawResponse().list(params, requestOptions).parse()

    override fun export(params: DrawExportParams, requestOptions: RequestOptions): HttpResponse =
        // get /draws/{id}/export
        withRawResponse().export(params, requestOptions)

    override fun run(params: DrawRunParams, requestOptions: RequestOptions): DrawRunResponse =
        // post /draws
        withRawResponse().run(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        DrawService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): DrawService.WithRawResponse =
            DrawServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<DrawRetrieveResponse> =
            jsonHandler<DrawRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: DrawRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DrawRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("draws", params._pathParam(0))
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

        private val listHandler: Handler<DrawListResponse> =
            jsonHandler<DrawListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: DrawListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DrawListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("draws")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        override fun export(
            params: DrawExportParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("draws", params._pathParam(0), "export")
                    .putHeader("Accept", "application/octet-stream")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response)
        }

        private val runHandler: Handler<DrawRunResponse> =
            jsonHandler<DrawRunResponse>(clientOptions.jsonMapper)

        override fun run(
            params: DrawRunParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<DrawRunResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("draws")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { runHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
