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
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.PaginatedUsers
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveResponse
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveSearchParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveSearchResponse
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveTweetsParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** X List followers, members, and tweets */
class ListServiceImpl internal constructor(private val clientOptions: ClientOptions) : ListService {

    private val withRawResponse: ListService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ListService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ListService =
        ListServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: ListRetrieveParams,
        requestOptions: RequestOptions,
    ): ListRetrieveResponse = withRawResponse().retrieve(params, requestOptions).parse()

    override fun retrieveFollowers(
        params: ListRetrieveFollowersParams,
        requestOptions: RequestOptions,
    ): PaginatedUsers = withRawResponse().retrieveFollowers(params, requestOptions).parse()

    override fun retrieveMembers(
        params: ListRetrieveMembersParams,
        requestOptions: RequestOptions,
    ): PaginatedUsers = withRawResponse().retrieveMembers(params, requestOptions).parse()

    override fun retrieveSearch(
        params: ListRetrieveSearchParams,
        requestOptions: RequestOptions,
    ): ListRetrieveSearchResponse = withRawResponse().retrieveSearch(params, requestOptions).parse()

    override fun retrieveTweets(
        params: ListRetrieveTweetsParams,
        requestOptions: RequestOptions,
    ): PaginatedTweets = withRawResponse().retrieveTweets(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ListService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ListService.WithRawResponse =
            ListServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<ListRetrieveResponse> =
            jsonHandler<ListRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ListRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ListRetrieveResponse> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "lists", params._pathParam(0))
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

        private val retrieveFollowersHandler: Handler<PaginatedUsers> =
            jsonHandler<PaginatedUsers>(clientOptions.jsonMapper)

        override fun retrieveFollowers(
            params: ListRetrieveFollowersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "lists", params._pathParam(0), "followers")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveFollowersHandler.handle(it) }
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
            params: ListRetrieveMembersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "lists", params._pathParam(0), "members")
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

        private val retrieveSearchHandler: Handler<ListRetrieveSearchResponse> =
            jsonHandler<ListRetrieveSearchResponse>(clientOptions.jsonMapper)

        override fun retrieveSearch(
            params: ListRetrieveSearchParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ListRetrieveSearchResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "lists", "search")
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

        private val retrieveTweetsHandler: Handler<PaginatedTweets> =
            jsonHandler<PaginatedTweets>(clientOptions.jsonMapper)

        override fun retrieveTweets(
            params: ListRetrieveTweetsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedTweets> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "lists", params._pathParam(0), "tweets")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveTweetsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
