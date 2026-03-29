// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x.users

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
import com.x_twitter_scraper.api.models.x.users.follow.FollowCreateParams
import com.x_twitter_scraper.api.models.x.users.follow.FollowCreateResponse
import com.x_twitter_scraper.api.models.x.users.follow.FollowDeleteAllParams
import com.x_twitter_scraper.api.models.x.users.follow.FollowDeleteAllResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** X write actions (tweets, likes, follows, DMs) */
class FollowServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    FollowServiceAsync {

    private val withRawResponse: FollowServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FollowServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): FollowServiceAsync =
        FollowServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: FollowCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FollowCreateResponse> =
        // post /x/users/{userId}/follow
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun deleteAll(
        params: FollowDeleteAllParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FollowDeleteAllResponse> =
        // delete /x/users/{userId}/follow
        withRawResponse().deleteAll(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FollowServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FollowServiceAsync.WithRawResponse =
            FollowServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<FollowCreateResponse> =
            jsonHandler<FollowCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: FollowCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FollowCreateResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "users", params._pathParam(0), "follow")
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

        private val deleteAllHandler: Handler<FollowDeleteAllResponse> =
            jsonHandler<FollowDeleteAllResponse>(clientOptions.jsonMapper)

        override fun deleteAll(
            params: FollowDeleteAllParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FollowDeleteAllResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "users", params._pathParam(0), "follow")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { deleteAllHandler.handle(it) }
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
