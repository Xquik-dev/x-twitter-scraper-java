// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
import com.x_twitter_scraper.api.models.monitors.posts.PostCreateParams
import com.x_twitter_scraper.api.models.monitors.posts.PostDeleteParams
import com.x_twitter_scraper.api.models.monitors.posts.PostDeleteResponse
import com.x_twitter_scraper.api.models.monitors.posts.PostListParams
import com.x_twitter_scraper.api.models.monitors.posts.PostListResponse
import com.x_twitter_scraper.api.models.monitors.posts.PostMonitor
import com.x_twitter_scraper.api.models.monitors.posts.PostMonitorMetrics
import com.x_twitter_scraper.api.models.monitors.posts.PostRetrieveMetricsParams
import com.x_twitter_scraper.api.models.monitors.posts.PostRetrieveParams
import com.x_twitter_scraper.api.models.monitors.posts.PostUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** X account monitoring with 1-second checks */
class PostServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    PostServiceAsync {

    private val withRawResponse: PostServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PostServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): PostServiceAsync =
        PostServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: PostCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PostMonitor> =
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: PostRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PostMonitor> =
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: PostUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PostMonitor> =
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: PostListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PostListResponse> =
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: PostDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PostDeleteResponse> =
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun retrieveMetrics(
        params: PostRetrieveMetricsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PostMonitorMetrics> =
        withRawResponse().retrieveMetrics(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PostServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PostServiceAsync.WithRawResponse =
            PostServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<PostMonitor> =
            jsonHandler<PostMonitor>(clientOptions.jsonMapper)

        override fun create(
            params: PostCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PostMonitor>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("monitors", "posts")
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

        private val retrieveHandler: Handler<PostMonitor> =
            jsonHandler<PostMonitor>(clientOptions.jsonMapper)

        override fun retrieve(
            params: PostRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PostMonitor>> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("monitors", "posts", params._pathParam(0))
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

        private val updateHandler: Handler<PostMonitor> =
            jsonHandler<PostMonitor>(clientOptions.jsonMapper)

        override fun update(
            params: PostUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PostMonitor>> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("monitors", "posts", params._pathParam(0))
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

        private val listHandler: Handler<PostListResponse> =
            jsonHandler<PostListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: PostListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PostListResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("monitors", "posts")
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

        private val deleteHandler: Handler<PostDeleteResponse> =
            jsonHandler<PostDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: PostDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PostDeleteResponse>> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("monitors", "posts", params._pathParam(0))
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

        private val retrieveMetricsHandler: Handler<PostMonitorMetrics> =
            jsonHandler<PostMonitorMetrics>(clientOptions.jsonMapper)

        override fun retrieveMetrics(
            params: PostRetrieveMetricsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PostMonitorMetrics>> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("monitors", "posts", params._pathParam(0), "metrics")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveMetricsHandler.handle(it) }
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
