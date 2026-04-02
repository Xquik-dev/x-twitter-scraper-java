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
import com.x_twitter_scraper.api.models.x.tweets.TweetCreateParams
import com.x_twitter_scraper.api.models.x.tweets.TweetCreateResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetFavoritersParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetFavoritersResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetQuotesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetQuotesResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRepliesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRepliesResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRetweetersParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRetweetersResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetGetThreadParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetThreadResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetListParams
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchParams
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchResponse
import com.x_twitter_scraper.api.services.blocking.x.tweets.LikeService
import com.x_twitter_scraper.api.services.blocking.x.tweets.LikeServiceImpl
import com.x_twitter_scraper.api.services.blocking.x.tweets.RetweetService
import com.x_twitter_scraper.api.services.blocking.x.tweets.RetweetServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class TweetServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    TweetService {

    private val withRawResponse: TweetService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val like: LikeService by lazy { LikeServiceImpl(clientOptions) }

    private val retweet: RetweetService by lazy { RetweetServiceImpl(clientOptions) }

    override fun withRawResponse(): TweetService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TweetService =
        TweetServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun like(): LikeService = like

    override fun retweet(): RetweetService = retweet

    override fun create(
        params: TweetCreateParams,
        requestOptions: RequestOptions,
    ): TweetCreateResponse =
        // post /x/tweets
        withRawResponse().create(params, requestOptions).parse()

    override fun list(params: TweetListParams, requestOptions: RequestOptions) {
        // get /x/tweets
        withRawResponse().list(params, requestOptions)
    }

    override fun getFavoriters(
        params: TweetGetFavoritersParams,
        requestOptions: RequestOptions,
    ): TweetGetFavoritersResponse =
        // get /x/tweets/{id}/favoriters
        withRawResponse().getFavoriters(params, requestOptions).parse()

    override fun getQuotes(
        params: TweetGetQuotesParams,
        requestOptions: RequestOptions,
    ): TweetGetQuotesResponse =
        // get /x/tweets/{id}/quotes
        withRawResponse().getQuotes(params, requestOptions).parse()

    override fun getReplies(
        params: TweetGetRepliesParams,
        requestOptions: RequestOptions,
    ): TweetGetRepliesResponse =
        // get /x/tweets/{id}/replies
        withRawResponse().getReplies(params, requestOptions).parse()

    override fun getRetweeters(
        params: TweetGetRetweetersParams,
        requestOptions: RequestOptions,
    ): TweetGetRetweetersResponse =
        // get /x/tweets/{id}/retweeters
        withRawResponse().getRetweeters(params, requestOptions).parse()

    override fun getThread(
        params: TweetGetThreadParams,
        requestOptions: RequestOptions,
    ): TweetGetThreadResponse =
        // get /x/tweets/{id}/thread
        withRawResponse().getThread(params, requestOptions).parse()

    override fun search(
        params: TweetSearchParams,
        requestOptions: RequestOptions,
    ): TweetSearchResponse =
        // get /x/tweets/search
        withRawResponse().search(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TweetService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val like: LikeService.WithRawResponse by lazy {
            LikeServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val retweet: RetweetService.WithRawResponse by lazy {
            RetweetServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TweetService.WithRawResponse =
            TweetServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun like(): LikeService.WithRawResponse = like

        override fun retweet(): RetweetService.WithRawResponse = retweet

        private val createHandler: Handler<TweetCreateResponse> =
            jsonHandler<TweetCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: TweetCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "tweets")
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

        private val listHandler: Handler<Void?> = emptyHandler()

        override fun list(params: TweetListParams, requestOptions: RequestOptions): HttpResponse {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "tweets")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { listHandler.handle(it) }
            }
        }

        private val getFavoritersHandler: Handler<TweetGetFavoritersResponse> =
            jsonHandler<TweetGetFavoritersResponse>(clientOptions.jsonMapper)

        override fun getFavoriters(
            params: TweetGetFavoritersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetGetFavoritersResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "tweets", params._pathParam(0), "favoriters")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getFavoritersHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getQuotesHandler: Handler<TweetGetQuotesResponse> =
            jsonHandler<TweetGetQuotesResponse>(clientOptions.jsonMapper)

        override fun getQuotes(
            params: TweetGetQuotesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetGetQuotesResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "tweets", params._pathParam(0), "quotes")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getQuotesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getRepliesHandler: Handler<TweetGetRepliesResponse> =
            jsonHandler<TweetGetRepliesResponse>(clientOptions.jsonMapper)

        override fun getReplies(
            params: TweetGetRepliesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetGetRepliesResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "tweets", params._pathParam(0), "replies")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getRepliesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getRetweetersHandler: Handler<TweetGetRetweetersResponse> =
            jsonHandler<TweetGetRetweetersResponse>(clientOptions.jsonMapper)

        override fun getRetweeters(
            params: TweetGetRetweetersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetGetRetweetersResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "tweets", params._pathParam(0), "retweeters")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getRetweetersHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getThreadHandler: Handler<TweetGetThreadResponse> =
            jsonHandler<TweetGetThreadResponse>(clientOptions.jsonMapper)

        override fun getThread(
            params: TweetGetThreadParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetGetThreadResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "tweets", params._pathParam(0), "thread")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getThreadHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val searchHandler: Handler<TweetSearchResponse> =
            jsonHandler<TweetSearchResponse>(clientOptions.jsonMapper)

        override fun search(
            params: TweetSearchParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TweetSearchResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "tweets", "search")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { searchHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
