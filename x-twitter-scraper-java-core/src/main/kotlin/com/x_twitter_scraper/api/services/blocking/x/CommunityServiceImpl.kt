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
import com.x_twitter_scraper.api.core.http.json
import com.x_twitter_scraper.api.core.http.parseable
import com.x_twitter_scraper.api.core.prepare
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
import com.x_twitter_scraper.api.services.blocking.x.communities.JoinService
import com.x_twitter_scraper.api.services.blocking.x.communities.JoinServiceImpl
import com.x_twitter_scraper.api.services.blocking.x.communities.MediaService
import com.x_twitter_scraper.api.services.blocking.x.communities.MediaServiceImpl
import com.x_twitter_scraper.api.services.blocking.x.communities.TweetService
import com.x_twitter_scraper.api.services.blocking.x.communities.TweetServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class CommunityServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CommunityService {

    private val withRawResponse: CommunityService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val join: JoinService by lazy { JoinServiceImpl(clientOptions) }

    private val tweets: TweetService by lazy { TweetServiceImpl(clientOptions) }

    private val media: MediaService by lazy { MediaServiceImpl(clientOptions) }

    override fun withRawResponse(): CommunityService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CommunityService =
        CommunityServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** X write actions (tweets, likes, follows, DMs) */
    override fun join(): JoinService = join

    /** X Community info, members, and tweets */
    override fun tweets(): TweetService = tweets

    /** Find X Communities & read their info, members, posts & media */
    override fun media(): MediaService = media

    override fun create(
        params: CommunityCreateParams,
        requestOptions: RequestOptions,
    ): CommunityCreateResponse = withRawResponse().create(params, requestOptions).parse()

    override fun delete(
        params: CommunityDeleteParams,
        requestOptions: RequestOptions,
    ): CommunityDeleteResponse = withRawResponse().delete(params, requestOptions).parse()

    override fun find(params: CommunityFindParams, requestOptions: RequestOptions): CommunityPage =
        withRawResponse().find(params, requestOptions).parse()

    override fun listPopular(
        params: CommunityListPopularParams,
        requestOptions: RequestOptions,
    ): CommunityPage = withRawResponse().listPopular(params, requestOptions).parse()

    override fun listSuggested(
        params: CommunityListSuggestedParams,
        requestOptions: RequestOptions,
    ): CommunityListSuggestedResponse =
        withRawResponse().listSuggested(params, requestOptions).parse()

    override fun listTopics(
        params: CommunityListTopicsParams,
        requestOptions: RequestOptions,
    ): CommunityListTopicsResponse = withRawResponse().listTopics(params, requestOptions).parse()

    override fun retrieveAnalytics(
        params: CommunityRetrieveAnalyticsParams,
        requestOptions: RequestOptions,
    ): CommunityAnalytics = withRawResponse().retrieveAnalytics(params, requestOptions).parse()

    override fun retrieveInfo(
        params: CommunityRetrieveInfoParams,
        requestOptions: RequestOptions,
    ): CommunityRetrieveInfoResponse =
        withRawResponse().retrieveInfo(params, requestOptions).parse()

    override fun retrieveMembers(
        params: CommunityRetrieveMembersParams,
        requestOptions: RequestOptions,
    ): PaginatedUsers = withRawResponse().retrieveMembers(params, requestOptions).parse()

    override fun retrieveModerators(
        params: CommunityRetrieveModeratorsParams,
        requestOptions: RequestOptions,
    ): PaginatedUsers = withRawResponse().retrieveModerators(params, requestOptions).parse()

    override fun retrieveSearch(
        params: CommunityRetrieveSearchParams,
        requestOptions: RequestOptions,
    ): PaginatedTweets = withRawResponse().retrieveSearch(params, requestOptions).parse()

    override fun searchMembers(
        params: CommunitySearchMembersParams,
        requestOptions: RequestOptions,
    ): PaginatedUsers = withRawResponse().searchMembers(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CommunityService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val join: JoinService.WithRawResponse by lazy {
            JoinServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val tweets: TweetService.WithRawResponse by lazy {
            TweetServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val media: MediaService.WithRawResponse by lazy {
            MediaServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CommunityService.WithRawResponse =
            CommunityServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** X write actions (tweets, likes, follows, DMs) */
        override fun join(): JoinService.WithRawResponse = join

        /** X Community info, members, and tweets */
        override fun tweets(): TweetService.WithRawResponse = tweets

        /** Find X Communities & read their info, members, posts & media */
        override fun media(): MediaService.WithRawResponse = media

        private val createHandler: Handler<CommunityCreateResponse> =
            jsonHandler<CommunityCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: CommunityCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CommunityCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities")
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

        private val deleteHandler: Handler<CommunityDeleteResponse> =
            jsonHandler<CommunityDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: CommunityDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CommunityDeleteResponse> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", params._pathParam(0))
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

        private val findHandler: Handler<CommunityPage> =
            jsonHandler<CommunityPage>(clientOptions.jsonMapper)

        override fun find(
            params: CommunityFindParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CommunityPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", "find")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { findHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listPopularHandler: Handler<CommunityPage> =
            jsonHandler<CommunityPage>(clientOptions.jsonMapper)

        override fun listPopular(
            params: CommunityListPopularParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CommunityPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", "popular")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listPopularHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listSuggestedHandler: Handler<CommunityListSuggestedResponse> =
            jsonHandler<CommunityListSuggestedResponse>(clientOptions.jsonMapper)

        override fun listSuggested(
            params: CommunityListSuggestedParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CommunityListSuggestedResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", "suggested")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listSuggestedHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listTopicsHandler: Handler<CommunityListTopicsResponse> =
            jsonHandler<CommunityListTopicsResponse>(clientOptions.jsonMapper)

        override fun listTopics(
            params: CommunityListTopicsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CommunityListTopicsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", "topics")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listTopicsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveAnalyticsHandler: Handler<CommunityAnalytics> =
            jsonHandler<CommunityAnalytics>(clientOptions.jsonMapper)

        override fun retrieveAnalytics(
            params: CommunityRetrieveAnalyticsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CommunityAnalytics> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", params._pathParam(0), "analytics")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveAnalyticsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveInfoHandler: Handler<CommunityRetrieveInfoResponse> =
            jsonHandler<CommunityRetrieveInfoResponse>(clientOptions.jsonMapper)

        override fun retrieveInfo(
            params: CommunityRetrieveInfoParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CommunityRetrieveInfoResponse> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", params._pathParam(0), "info")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveInfoHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveMembersHandler: Handler<PaginatedUsers> =
            jsonHandler<PaginatedUsers>(clientOptions.jsonMapper)

        override fun retrieveMembers(
            params: CommunityRetrieveMembersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", params._pathParam(0), "members")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveMembersHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveModeratorsHandler: Handler<PaginatedUsers> =
            jsonHandler<PaginatedUsers>(clientOptions.jsonMapper)

        override fun retrieveModerators(
            params: CommunityRetrieveModeratorsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", params._pathParam(0), "moderators")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveModeratorsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveSearchHandler: Handler<PaginatedTweets> =
            jsonHandler<PaginatedTweets>(clientOptions.jsonMapper)

        override fun retrieveSearch(
            params: CommunityRetrieveSearchParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedTweets> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", "search")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveSearchHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val searchMembersHandler: Handler<PaginatedUsers> =
            jsonHandler<PaginatedUsers>(clientOptions.jsonMapper)

        override fun searchMembers(
            params: CommunitySearchMembersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "communities", params._pathParam(0), "members", "search")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
