// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.monitors

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
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordCreateParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordCreateResponse
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordDeactivateParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordDeactivateResponse
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordListParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordListResponse
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordRetrieveParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordRetrieveResponse
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordUpdateParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordUpdateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** X account monitoring with 1-second checks */
class KeywordServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    KeywordServiceAsync {

    private val withRawResponse: KeywordServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): KeywordServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): KeywordServiceAsync =
        KeywordServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: KeywordCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<KeywordCreateResponse> =
        // post /monitors/keywords
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: KeywordRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<KeywordRetrieveResponse> =
        // get /monitors/keywords/{id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: KeywordUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<KeywordUpdateResponse> =
        // patch /monitors/keywords/{id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: KeywordListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<KeywordListResponse> =
        // get /monitors/keywords
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun deactivate(
        params: KeywordDeactivateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<KeywordDeactivateResponse> =
        // delete /monitors/keywords/{id}
        withRawResponse().deactivate(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        KeywordServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): KeywordServiceAsync.WithRawResponse =
            KeywordServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<KeywordCreateResponse> =
            jsonHandler<KeywordCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: KeywordCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KeywordCreateResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("monitors", "keywords")
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

        private val retrieveHandler: Handler<KeywordRetrieveResponse> =
            jsonHandler<KeywordRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: KeywordRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KeywordRetrieveResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("monitors", "keywords", params._pathParam(0))
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

        private val updateHandler: Handler<KeywordUpdateResponse> =
            jsonHandler<KeywordUpdateResponse>(clientOptions.jsonMapper)

        override fun update(
            params: KeywordUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KeywordUpdateResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("monitors", "keywords", params._pathParam(0))
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

        private val listHandler: Handler<KeywordListResponse> =
            jsonHandler<KeywordListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: KeywordListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KeywordListResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("monitors", "keywords")
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

        private val deactivateHandler: Handler<KeywordDeactivateResponse> =
            jsonHandler<KeywordDeactivateResponse>(clientOptions.jsonMapper)

        override fun deactivate(
            params: KeywordDeactivateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KeywordDeactivateResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("monitors", "keywords", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { deactivateHandler.handle(it) }
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
