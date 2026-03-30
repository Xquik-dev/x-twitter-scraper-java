// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

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
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** Push notification integrations (Telegram) */
class IntegrationServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    IntegrationServiceAsync {

    private val withRawResponse: IntegrationServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): IntegrationServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): IntegrationServiceAsync =
        IntegrationServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: IntegrationCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Integration> =
        // post /integrations
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: IntegrationRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Integration> =
        // get /integrations/{id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: IntegrationUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Integration> =
        // patch /integrations/{id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: IntegrationListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<IntegrationListResponse> =
        // get /integrations
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: IntegrationDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<IntegrationDeleteResponse> =
        // delete /integrations/{id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun listDeliveries(
        params: IntegrationListDeliveriesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<IntegrationListDeliveriesResponse> =
        // get /integrations/{id}/deliveries
        withRawResponse().listDeliveries(params, requestOptions).thenApply { it.parse() }

    override fun sendTest(
        params: IntegrationSendTestParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<IntegrationSendTestResponse> =
        // post /integrations/{id}/test
        withRawResponse().sendTest(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        IntegrationServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): IntegrationServiceAsync.WithRawResponse =
            IntegrationServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<Integration> =
            jsonHandler<Integration>(clientOptions.jsonMapper)

        override fun create(
            params: IntegrationCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Integration>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("integrations")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveHandler: Handler<Integration> =
            jsonHandler<Integration>(clientOptions.jsonMapper)

        override fun retrieve(
            params: IntegrationRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Integration>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("integrations", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val updateHandler: Handler<Integration> =
            jsonHandler<Integration>(clientOptions.jsonMapper)

        override fun update(
            params: IntegrationUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Integration>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { updateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<IntegrationListResponse> =
            jsonHandler<IntegrationListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: IntegrationListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<IntegrationListResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("integrations")
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

        private val deleteHandler: Handler<IntegrationDeleteResponse> =
            jsonHandler<IntegrationDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: IntegrationDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<IntegrationDeleteResponse>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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

        private val listDeliveriesHandler: Handler<IntegrationListDeliveriesResponse> =
            jsonHandler<IntegrationListDeliveriesResponse>(clientOptions.jsonMapper)

        override fun listDeliveries(
            params: IntegrationListDeliveriesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<IntegrationListDeliveriesResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("integrations", params._pathParam(0), "deliveries")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listDeliveriesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val sendTestHandler: Handler<IntegrationSendTestResponse> =
            jsonHandler<IntegrationSendTestResponse>(clientOptions.jsonMapper)

        override fun sendTest(
            params: IntegrationSendTestParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<IntegrationSendTestResponse>> {
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
}
