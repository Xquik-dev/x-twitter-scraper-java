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
import com.x_twitter_scraper.api.models.integrations.Integration
import com.x_twitter_scraper.api.models.integrations.IntegrationCreateParams
import com.x_twitter_scraper.api.models.integrations.IntegrationDeleteParams
import com.x_twitter_scraper.api.models.integrations.IntegrationDeleteResponse
import com.x_twitter_scraper.api.models.integrations.IntegrationListDeliveriesParams
import com.x_twitter_scraper.api.models.integrations.IntegrationListDeliveriesResponse
import com.x_twitter_scraper.api.models.integrations.IntegrationListParams
import com.x_twitter_scraper.api.models.integrations.IntegrationListResponse
import com.x_twitter_scraper.api.models.integrations.IntegrationRetrieveParams
import com.x_twitter_scraper.api.models.integrations.IntegrationSendTestParams
import com.x_twitter_scraper.api.models.integrations.IntegrationSendTestResponse
import com.x_twitter_scraper.api.models.integrations.IntegrationUpdateParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** Push notification integrations (Telegram) */
class IntegrationServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    IntegrationService {

    private val withRawResponse: IntegrationService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): IntegrationService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): IntegrationService =
        IntegrationServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: IntegrationCreateParams,
        requestOptions: RequestOptions,
    ): Integration =
        // post /integrations
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: IntegrationRetrieveParams,
        requestOptions: RequestOptions,
    ): Integration =
        // get /integrations/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: IntegrationUpdateParams,
        requestOptions: RequestOptions,
    ): Integration =
        // patch /integrations/{id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: IntegrationListParams,
        requestOptions: RequestOptions,
    ): IntegrationListResponse =
        // get /integrations
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: IntegrationDeleteParams,
        requestOptions: RequestOptions,
    ): IntegrationDeleteResponse =
        // delete /integrations/{id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun listDeliveries(
        params: IntegrationListDeliveriesParams,
        requestOptions: RequestOptions,
    ): IntegrationListDeliveriesResponse =
        // get /integrations/{id}/deliveries
        withRawResponse().listDeliveries(params, requestOptions).parse()

    override fun sendTest(
        params: IntegrationSendTestParams,
        requestOptions: RequestOptions,
    ): IntegrationSendTestResponse =
        // post /integrations/{id}/test
        withRawResponse().sendTest(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        IntegrationService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): IntegrationService.WithRawResponse =
            IntegrationServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<Integration> =
            jsonHandler<Integration>(clientOptions.jsonMapper)

        override fun create(
            params: IntegrationCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Integration> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("integrations")
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

        private val retrieveHandler: Handler<Integration> =
            jsonHandler<Integration>(clientOptions.jsonMapper)

        override fun retrieve(
            params: IntegrationRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Integration> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("integrations", params._pathParam(0))
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

        private val updateHandler: Handler<Integration> =
            jsonHandler<Integration>(clientOptions.jsonMapper)

        override fun update(
            params: IntegrationUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Integration> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("integrations", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<IntegrationListResponse> =
            jsonHandler<IntegrationListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: IntegrationListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<IntegrationListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("integrations")
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

        private val deleteHandler: Handler<IntegrationDeleteResponse> =
            jsonHandler<IntegrationDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: IntegrationDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<IntegrationDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("integrations", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
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

        private val listDeliveriesHandler: Handler<IntegrationListDeliveriesResponse> =
            jsonHandler<IntegrationListDeliveriesResponse>(clientOptions.jsonMapper)

        override fun listDeliveries(
            params: IntegrationListDeliveriesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<IntegrationListDeliveriesResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("integrations", params._pathParam(0), "deliveries")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listDeliveriesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val sendTestHandler: Handler<IntegrationSendTestResponse> =
            jsonHandler<IntegrationSendTestResponse>(clientOptions.jsonMapper)

        override fun sendTest(
            params: IntegrationSendTestParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<IntegrationSendTestResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("integrations", params._pathParam(0), "test")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { sendTestHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
