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
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.PaginatedUsers
import com.x_twitter_scraper.api.models.UserProfile
import com.x_twitter_scraper.api.models.x.users.UserRetrieveBatchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersYouKnowParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowingParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveLikesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMediaParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMentionsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSearchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveTweetsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveVerifiedFollowersParams
import com.x_twitter_scraper.api.services.blocking.x.users.FollowService
import com.x_twitter_scraper.api.services.blocking.x.users.FollowServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** X data lookups (subscription required) */
class UserServiceImpl internal constructor(private val clientOptions: ClientOptions) : UserService {

    private val withRawResponse: UserService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val follow: FollowService by lazy { FollowServiceImpl(clientOptions) }

    override fun withRawResponse(): UserService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserService =
        UserServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** X write actions (tweets, likes, follows, DMs) */
    override fun follow(): FollowService = follow

    override fun retrieve(params: UserRetrieveParams, requestOptions: RequestOptions): UserProfile =
        // get /x/users/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun retrieveBatch(
        params: UserRetrieveBatchParams,
        requestOptions: RequestOptions,
    ): PaginatedUsers =
        // get /x/users/batch
        withRawResponse().retrieveBatch(params, requestOptions).parse()

    override fun retrieveFollowers(
        params: UserRetrieveFollowersParams,
        requestOptions: RequestOptions,
    ): PaginatedUsers =
        // get /x/users/{id}/followers
        withRawResponse().retrieveFollowers(params, requestOptions).parse()

    override fun retrieveFollowersYouKnow(
        params: UserRetrieveFollowersYouKnowParams,
        requestOptions: RequestOptions,
    ): PaginatedUsers =
        // get /x/users/{id}/followers-you-know
        withRawResponse().retrieveFollowersYouKnow(params, requestOptions).parse()

    override fun retrieveFollowing(
        params: UserRetrieveFollowingParams,
        requestOptions: RequestOptions,
    ): PaginatedUsers =
        // get /x/users/{id}/following
        withRawResponse().retrieveFollowing(params, requestOptions).parse()

    override fun retrieveLikes(
        params: UserRetrieveLikesParams,
        requestOptions: RequestOptions,
    ): PaginatedTweets =
        // get /x/users/{id}/likes
        withRawResponse().retrieveLikes(params, requestOptions).parse()

    override fun retrieveMedia(
        params: UserRetrieveMediaParams,
        requestOptions: RequestOptions,
    ): PaginatedTweets =
        // get /x/users/{id}/media
        withRawResponse().retrieveMedia(params, requestOptions).parse()

    override fun retrieveMentions(
        params: UserRetrieveMentionsParams,
        requestOptions: RequestOptions,
    ): PaginatedTweets =
        // get /x/users/{id}/mentions
        withRawResponse().retrieveMentions(params, requestOptions).parse()

    override fun retrieveSearch(
        params: UserRetrieveSearchParams,
        requestOptions: RequestOptions,
    ): PaginatedUsers =
        // get /x/users/search
        withRawResponse().retrieveSearch(params, requestOptions).parse()

    override fun retrieveTweets(
        params: UserRetrieveTweetsParams,
        requestOptions: RequestOptions,
    ): PaginatedTweets =
        // get /x/users/{id}/tweets
        withRawResponse().retrieveTweets(params, requestOptions).parse()

    override fun retrieveVerifiedFollowers(
        params: UserRetrieveVerifiedFollowersParams,
        requestOptions: RequestOptions,
    ): PaginatedUsers =
        // get /x/users/{id}/verified-followers
        withRawResponse().retrieveVerifiedFollowers(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        UserService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val follow: FollowService.WithRawResponse by lazy {
            FollowServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): UserService.WithRawResponse =
            UserServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** X write actions (tweets, likes, follows, DMs) */
        override fun follow(): FollowService.WithRawResponse = follow

        private val retrieveHandler: Handler<UserProfile> =
            jsonHandler<UserProfile>(clientOptions.jsonMapper)

        override fun retrieve(
            params: UserRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UserProfile> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "users", params._pathParam(0))
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

        private val retrieveBatchHandler: Handler<PaginatedUsers> =
            jsonHandler<PaginatedUsers>(clientOptions.jsonMapper)

        override fun retrieveBatch(
            params: UserRetrieveBatchParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "users", "batch")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveBatchHandler.handle(it) }
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
            params: UserRetrieveFollowersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "users", params._pathParam(0), "followers")
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

        private val retrieveFollowersYouKnowHandler: Handler<PaginatedUsers> =
            jsonHandler<PaginatedUsers>(clientOptions.jsonMapper)

        override fun retrieveFollowersYouKnow(
            params: UserRetrieveFollowersYouKnowParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "users", params._pathParam(0), "followers-you-know")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveFollowersYouKnowHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveFollowingHandler: Handler<PaginatedUsers> =
            jsonHandler<PaginatedUsers>(clientOptions.jsonMapper)

        override fun retrieveFollowing(
            params: UserRetrieveFollowingParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "users", params._pathParam(0), "following")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveFollowingHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveLikesHandler: Handler<PaginatedTweets> =
            jsonHandler<PaginatedTweets>(clientOptions.jsonMapper)

        override fun retrieveLikes(
            params: UserRetrieveLikesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedTweets> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "users", params._pathParam(0), "likes")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveLikesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveMediaHandler: Handler<PaginatedTweets> =
            jsonHandler<PaginatedTweets>(clientOptions.jsonMapper)

        override fun retrieveMedia(
            params: UserRetrieveMediaParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedTweets> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "users", params._pathParam(0), "media")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveMediaHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveMentionsHandler: Handler<PaginatedTweets> =
            jsonHandler<PaginatedTweets>(clientOptions.jsonMapper)

        override fun retrieveMentions(
            params: UserRetrieveMentionsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedTweets> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "users", params._pathParam(0), "mentions")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveMentionsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveSearchHandler: Handler<PaginatedUsers> =
            jsonHandler<PaginatedUsers>(clientOptions.jsonMapper)

        override fun retrieveSearch(
            params: UserRetrieveSearchParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "users", "search")
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
            params: UserRetrieveTweetsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedTweets> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "users", params._pathParam(0), "tweets")
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

        private val retrieveVerifiedFollowersHandler: Handler<PaginatedUsers> =
            jsonHandler<PaginatedUsers>(clientOptions.jsonMapper)

        override fun retrieveVerifiedFollowers(
            params: UserRetrieveVerifiedFollowersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PaginatedUsers> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "users", params._pathParam(0), "verified-followers")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveVerifiedFollowersHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
