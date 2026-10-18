// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

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
import com.x_twitter_scraper.api.models.CommunityAnalytics
import com.x_twitter_scraper.api.models.CommunityPage
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.PaginatedUsers
import com.x_twitter_scraper.api.models.x.communities.CommunityCreateParams
import com.x_twitter_scraper.api.models.x.communities.CommunityCreateResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityDeleteParams
import com.x_twitter_scraper.api.models.x.communities.CommunityDeleteResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityFindParams
import com.x_twitter_scraper.api.models.x.communities.CommunityListPopularParams
import com.x_twitter_scraper.api.models.x.communities.CommunityListSuggestedParams
import com.x_twitter_scraper.api.models.x.communities.CommunityListSuggestedResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityListTopicsParams
import com.x_twitter_scraper.api.models.x.communities.CommunityListTopicsResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveAnalyticsParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveInfoParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveInfoResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveModeratorsParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveSearchParams
import com.x_twitter_scraper.api.models.x.communities.CommunitySearchMembersParams
import com.x_twitter_scraper.api.services.async.x.communities.JoinServiceAsync
import com.x_twitter_scraper.api.services.async.x.communities.JoinServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.x.communities.MediaServiceAsync
import com.x_twitter_scraper.api.services.async.x.communities.MediaServiceAsyncImpl
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

    private val media: MediaServiceAsync by lazy { MediaServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): CommunityServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CommunityServiceAsync =
        CommunityServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** X write actions (tweets, likes, follows, DMs) */
    override fun join(): JoinServiceAsync = join

    /** X Community info, members, and tweets */
    override fun tweets(): TweetServiceAsync = tweets

    /** Find X Communities & read their info, members, posts & media */
    override fun media(): MediaServiceAsync = media

    override fun create(
        params: CommunityCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityCreateResponse> =
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: CommunityDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityDeleteResponse> =
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun find(
        params: CommunityFindParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityPage> =
        withRawResponse().find(params, requestOptions).thenApply { it.parse() }

    override fun listPopular(
        params: CommunityListPopularParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityPage> =
        withRawResponse().listPopular(params, requestOptions).thenApply { it.parse() }

    override fun listSuggested(
        params: CommunityListSuggestedParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityListSuggestedResponse> =
        withRawResponse().listSuggested(params, requestOptions).thenApply { it.parse() }

    override fun listTopics(
        params: CommunityListTopicsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityListTopicsResponse> =
        withRawResponse().listTopics(params, requestOptions).thenApply { it.parse() }

    override fun retrieveAnalytics(
        params: CommunityRetrieveAnalyticsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityAnalytics> =
        withRawResponse().retrieveAnalytics(params, requestOptions).thenApply { it.parse() }

    override fun retrieveInfo(
        params: CommunityRetrieveInfoParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CommunityRetrieveInfoResponse> =
        withRawResponse().retrieveInfo(params, requestOptions).thenApply { it.parse() }

    override fun retrieveMembers(
        params: CommunityRetrieveMembersParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedUsers> =
        withRawResponse().retrieveMembers(params, requestOptions).thenApply { it.parse() }

    override fun retrieveModerators(
        params: CommunityRetrieveModeratorsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedUsers> =
        withRawResponse().retrieveModerators(params, requestOptions).thenApply { it.parse() }

    override fun retrieveSearch(
        params: CommunityRetrieveSearchParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedTweets> =
        withRawResponse().retrieveSearch(params, requestOptions).thenApply { it.parse() }

    override fun searchMembers(
        params: CommunitySearchMembersParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<PaginatedUsers> =
        withRawResponse().searchMembers(params, requestOptions).thenApply { it.parse() }

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

        private val media: MediaServiceAsync.WithRawResponse by lazy {
            MediaServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CommunityServiceAsync.WithRawResponse =
            CommunityServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** X write actions (tweets, likes, follows, DMs) */
        override fun join(): JoinServiceAsync.WithRawResponse = join

        /** X Community info, members, and tweets */
        override fun tweets(): TweetServiceAsync.WithRawResponse = tweets

        /** Find X Communities & read their info, members, posts & media */
        override fun media(): MediaServiceAsync.WithRawResponse = media

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

        private val findHandler: Handler<CommunityPage> =
            jsonHandler<CommunityPage>(clientOptions.jsonMapper)

        override fun find(
            params: CommunityFindParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CommunityPage>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", "find")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { findHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listPopularHandler: Handler<CommunityPage> =
            jsonHandler<CommunityPage>(clientOptions.jsonMapper)

        override fun listPopular(
            params: CommunityListPopularParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CommunityPage>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", "popular")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listPopularHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listSuggestedHandler: Handler<CommunityListSuggestedResponse> =
            jsonHandler<CommunityListSuggestedResponse>(clientOptions.jsonMapper)

        override fun listSuggested(
            params: CommunityListSuggestedParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CommunityListSuggestedResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", "suggested")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listSuggestedHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listTopicsHandler: Handler<CommunityListTopicsResponse> =
            jsonHandler<CommunityListTopicsResponse>(clientOptions.jsonMapper)

        override fun listTopics(
            params: CommunityListTopicsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CommunityListTopicsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", "topics")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listTopicsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveAnalyticsHandler: Handler<CommunityAnalytics> =
            jsonHandler<CommunityAnalytics>(clientOptions.jsonMapper)

        override fun retrieveAnalytics(
            params: CommunityRetrieveAnalyticsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CommunityAnalytics>> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", params._pathParam(0), "analytics")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveAnalyticsHandler.handle(it) }
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

        private val retrieveMembersHandler: Handler<PaginatedUsers> =
            jsonHandler<PaginatedUsers>(clientOptions.jsonMapper)

        override fun retrieveMembers(
            params: CommunityRetrieveMembersParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> {
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
                        response
                            .use { retrieveMembersHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveModeratorsHandler: Handler<PaginatedUsers> =
            jsonHandler<PaginatedUsers>(clientOptions.jsonMapper)

        override fun retrieveModerators(
            params: CommunityRetrieveModeratorsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> {
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
                        response
                            .use { retrieveModeratorsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveSearchHandler: Handler<PaginatedTweets> =
            jsonHandler<PaginatedTweets>(clientOptions.jsonMapper)

        override fun retrieveSearch(
            params: CommunityRetrieveSearchParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedTweets>> {
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
                        response
                            .use { retrieveSearchHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val searchMembersHandler: Handler<PaginatedUsers> =
            jsonHandler<PaginatedUsers>(clientOptions.jsonMapper)

        override fun searchMembers(
            params: CommunitySearchMembersParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<PaginatedUsers>> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", params._pathParam(0), "members", "search")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { searchMembersHandler.handle(it) }
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
