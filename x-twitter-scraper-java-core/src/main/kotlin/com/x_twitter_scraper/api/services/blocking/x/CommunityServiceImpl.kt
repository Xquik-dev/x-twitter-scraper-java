// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

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
import com.x_twitter_scraper.api.core.prepare
import com.x_twitter_scraper.api.models.x.communities.CommunityCreateParams
import com.x_twitter_scraper.api.models.x.communities.CommunityCreateResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityDeleteParams
import com.x_twitter_scraper.api.models.x.communities.CommunityDeleteResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveInfoParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveInfoResponse
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveModeratorsParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveSearchParams
import com.x_twitter_scraper.api.services.blocking.x.communities.JoinService
import com.x_twitter_scraper.api.services.blocking.x.communities.JoinServiceImpl
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

    override fun withRawResponse(): CommunityService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CommunityService =
        CommunityServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** X write actions (tweets, likes, follows, DMs) */
    override fun join(): JoinService = join

    /** X data lookups (subscription required) */
    override fun tweets(): TweetService = tweets

    override fun create(
        params: CommunityCreateParams,
        requestOptions: RequestOptions,
    ): CommunityCreateResponse =
        // post /x/communities
        withRawResponse().create(params, requestOptions).parse()

    override fun delete(
        params: CommunityDeleteParams,
        requestOptions: RequestOptions,
    ): CommunityDeleteResponse =
        // delete /x/communities/{id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun retrieveInfo(
        params: CommunityRetrieveInfoParams,
        requestOptions: RequestOptions,
    ): CommunityRetrieveInfoResponse =
        // get /x/communities/{id}/info
        withRawResponse().retrieveInfo(params, requestOptions).parse()

    override fun retrieveMembers(
        params: CommunityRetrieveMembersParams,
        requestOptions: RequestOptions,
    ) {
        // get /x/communities/{id}/members
        withRawResponse().retrieveMembers(params, requestOptions)
    }

    override fun retrieveModerators(
        params: CommunityRetrieveModeratorsParams,
        requestOptions: RequestOptions,
    ) {
        // get /x/communities/{id}/moderators
        withRawResponse().retrieveModerators(params, requestOptions)
    }

    override fun retrieveSearch(
        params: CommunityRetrieveSearchParams,
        requestOptions: RequestOptions,
    ) {
        // get /x/communities/search
        withRawResponse().retrieveSearch(params, requestOptions)
    }

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

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CommunityService.WithRawResponse =
            CommunityServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** X write actions (tweets, likes, follows, DMs) */
        override fun join(): JoinService.WithRawResponse = join

        /** X data lookups (subscription required) */
        override fun tweets(): TweetService.WithRawResponse = tweets

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

        private val retrieveInfoHandler: Handler<CommunityRetrieveInfoResponse> =
            jsonHandler<CommunityRetrieveInfoResponse>(clientOptions.jsonMapper)

        override fun retrieveInfo(
            params: CommunityRetrieveInfoParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CommunityRetrieveInfoResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
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

        private val retrieveMembersHandler: Handler<Void?> = emptyHandler()

        override fun retrieveMembers(
            params: CommunityRetrieveMembersParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
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
                response.use { retrieveMembersHandler.handle(it) }
            }
        }

        private val retrieveModeratorsHandler: Handler<Void?> = emptyHandler()

        override fun retrieveModerators(
            params: CommunityRetrieveModeratorsParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
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
                response.use { retrieveModeratorsHandler.handle(it) }
            }
        }

        private val retrieveSearchHandler: Handler<Void?> = emptyHandler()

        override fun retrieveSearch(
            params: CommunityRetrieveSearchParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
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
                response.use { retrieveSearchHandler.handle(it) }
            }
        }
    }
}
