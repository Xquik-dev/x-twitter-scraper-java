// File generated from our OpenAPI spec by Stainless.

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
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveFollowersResponse
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveMembersResponse
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveTweetsParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveTweetsResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** X data lookups (subscription required) */
class ListServiceImpl internal constructor(private val clientOptions: ClientOptions) : ListService {

    private val withRawResponse: ListService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ListService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ListService =
        ListServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieveFollowers(
        params: ListRetrieveFollowersParams,
        requestOptions: RequestOptions,
    ): ListRetrieveFollowersResponse =
        // get /x/lists/{id}/followers
        withRawResponse().retrieveFollowers(params, requestOptions).parse()

    override fun retrieveMembers(
        params: ListRetrieveMembersParams,
        requestOptions: RequestOptions,
    ): ListRetrieveMembersResponse =
        // get /x/lists/{id}/members
        withRawResponse().retrieveMembers(params, requestOptions).parse()

    override fun retrieveTweets(
        params: ListRetrieveTweetsParams,
        requestOptions: RequestOptions,
    ): ListRetrieveTweetsResponse =
        // get /x/lists/{id}/tweets
        withRawResponse().retrieveTweets(params, requestOptions).parse()

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

        private val retrieveFollowersHandler: Handler<ListRetrieveFollowersResponse> =
            jsonHandler<ListRetrieveFollowersResponse>(clientOptions.jsonMapper)

        override fun retrieveFollowers(
            params: ListRetrieveFollowersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ListRetrieveFollowersResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
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

        private val retrieveMembersHandler: Handler<ListRetrieveMembersResponse> =
            jsonHandler<ListRetrieveMembersResponse>(clientOptions.jsonMapper)

        override fun retrieveMembers(
            params: ListRetrieveMembersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ListRetrieveMembersResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
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

        private val retrieveTweetsHandler: Handler<ListRetrieveTweetsResponse> =
            jsonHandler<ListRetrieveTweetsResponse>(clientOptions.jsonMapper)

        override fun retrieveTweets(
            params: ListRetrieveTweetsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ListRetrieveTweetsResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
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
