// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.handlers.emptyHandler
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
import com.x_twitter_scraper.api.models.x.communities.CommunityCreateParams
import com.x_twitter_scraper.api.models.x.communities.CommunityCreateResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityDeleteParams
import com.x_twitter_scraper.api.models.x.communities.CommunityDeleteResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveInfoParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveInfoResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveModeratorsParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveSearchParams
import com.x_twitter_scraper.api.services.async.x.communities.JoinServiceAsync
import com.x_twitter_scraper.api.services.async.x.communities.JoinServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.x.communities.TweetServiceAsync
import com.x_twitter_scraper.api.services.async.x.communities.TweetServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class CommunityServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CommunityServiceAsync {

    private val withRawResponse: CommunityServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val join: JoinServiceAsync by lazy { JoinServiceAsyncImpl(clientOptions) }

    private val tweets: TweetServiceAsync by lazy { TweetServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): CommunityServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CommunityServiceAsync =
        CommunityServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** X write actions (tweets, likes, follows, DMs) */
    override fun join(): JoinServiceAsync = join

    /** X data lookups (subscription required) */
    override fun tweets(): TweetServiceAsync = tweets

    override fun create(
        params: CommunityCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityCreateResponse> =
        // post /x/communities
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: CommunityDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityDeleteResponse> =
        // delete /x/communities/{id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun retrieveInfo(
        params: CommunityRetrieveInfoParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityRetrieveInfoResponse> =
        // get /x/communities/{id}/info
        withRawResponse().retrieveInfo(params, requestOptions).thenApply { it.parse() }

    override fun retrieveMembers(
        params: CommunityRetrieveMembersParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // get /x/communities/{id}/members
        withRawResponse().retrieveMembers(params, requestOptions).thenAccept {}

    override fun retrieveModerators(
        params: CommunityRetrieveModeratorsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // get /x/communities/{id}/moderators
        withRawResponse().retrieveModerators(params, requestOptions).thenAccept {}

    override fun retrieveSearch(
        params: CommunityRetrieveSearchParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // get /x/communities/search
        withRawResponse().retrieveSearch(params, requestOptions).thenAccept {}

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CommunityServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val join: JoinServiceAsync.WithRawResponse by lazy {
            JoinServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val tweets: TweetServiceAsync.WithRawResponse by lazy {
            TweetServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CommunityServiceAsync.WithRawResponse =
            CommunityServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** X write actions (tweets, likes, follows, DMs) */
        override fun join(): JoinServiceAsync.WithRawResponse = join

        /** X data lookups (subscription required) */
        override fun tweets(): TweetServiceAsync.WithRawResponse = tweets

        private val createHandler: Handler<CommunityCreateResponse> =
            jsonHandler<CommunityCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: CommunityCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CommunityCreateResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities")
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

        private val deleteHandler: Handler<CommunityDeleteResponse> =
            jsonHandler<CommunityDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: CommunityDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CommunityDeleteResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
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

        private val retrieveInfoHandler: Handler<CommunityRetrieveInfoResponse> =
            jsonHandler<CommunityRetrieveInfoResponse>(clientOptions.jsonMapper)

        override fun retrieveInfo(
            params: CommunityRetrieveInfoParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CommunityRetrieveInfoResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", params._pathParam(0), "info")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveInfoHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveMembersHandler: Handler<Void?> = emptyHandler()

        override fun retrieveMembers(
            params: CommunityRetrieveMembersParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", params._pathParam(0), "members")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { retrieveMembersHandler.handle(it) }
                    }
                }
        }

        private val retrieveModeratorsHandler: Handler<Void?> = emptyHandler()

        override fun retrieveModerators(
            params: CommunityRetrieveModeratorsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", params._pathParam(0), "moderators")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { retrieveModeratorsHandler.handle(it) }
                    }
                }
        }

        private val retrieveSearchHandler: Handler<Void?> = emptyHandler()

        override fun retrieveSearch(
            params: CommunityRetrieveSearchParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", "search")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { retrieveSearchHandler.handle(it) }
                    }
                }
        }
    }
}
