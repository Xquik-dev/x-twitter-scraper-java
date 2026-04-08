// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

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
import com.x_twitter_scraper.api.core.prepareAsync
import com.x_twitter_scraper.api.models.x.XGetArticleParams
import com.x_twitter_scraper.api.models.x.XGetArticleResponse
import com.x_twitter_scraper.api.models.x.XGetHomeTimelineParams
import com.x_twitter_scraper.api.models.x.XGetHomeTimelineResponse
import com.x_twitter_scraper.api.models.x.XGetNotificationsParams
import com.x_twitter_scraper.api.models.x.XGetNotificationsResponse
import com.x_twitter_scraper.api.models.x.XGetTrendsParams
import com.x_twitter_scraper.api.models.x.XGetTrendsResponse
import com.x_twitter_scraper.api.services.async.x.AccountServiceAsync
import com.x_twitter_scraper.api.services.async.x.AccountServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.x.BookmarkServiceAsync
import com.x_twitter_scraper.api.services.async.x.BookmarkServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.x.CommunityServiceAsync
import com.x_twitter_scraper.api.services.async.x.CommunityServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.x.DmServiceAsync
import com.x_twitter_scraper.api.services.async.x.DmServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.x.FollowerServiceAsync
import com.x_twitter_scraper.api.services.async.x.FollowerServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.x.ListServiceAsync
import com.x_twitter_scraper.api.services.async.x.ListServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.x.MediaServiceAsync
import com.x_twitter_scraper.api.services.async.x.MediaServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.x.ProfileServiceAsync
import com.x_twitter_scraper.api.services.async.x.ProfileServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.x.TweetServiceAsync
import com.x_twitter_scraper.api.services.async.x.TweetServiceAsyncImpl
import com.x_twitter_scraper.api.services.async.x.UserServiceAsync
import com.x_twitter_scraper.api.services.async.x.UserServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** X data lookups (subscription required) */
class XServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    XServiceAsync {

    private val withRawResponse: XServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val tweets: TweetServiceAsync by lazy { TweetServiceAsyncImpl(clientOptions) }

    private val users: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptions) }

    private val followers: FollowerServiceAsync by lazy { FollowerServiceAsyncImpl(clientOptions) }

    private val dm: DmServiceAsync by lazy { DmServiceAsyncImpl(clientOptions) }

    private val media: MediaServiceAsync by lazy { MediaServiceAsyncImpl(clientOptions) }

    private val profile: ProfileServiceAsync by lazy { ProfileServiceAsyncImpl(clientOptions) }

    private val communities: CommunityServiceAsync by lazy {
        CommunityServiceAsyncImpl(clientOptions)
    }

    private val accounts: AccountServiceAsync by lazy { AccountServiceAsyncImpl(clientOptions) }

    private val bookmarks: BookmarkServiceAsync by lazy { BookmarkServiceAsyncImpl(clientOptions) }

    private val lists: ListServiceAsync by lazy { ListServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): XServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): XServiceAsync =
        XServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun tweets(): TweetServiceAsync = tweets

    /** X data lookups (subscription required) */
    override fun users(): UserServiceAsync = users

    /** X data lookups (subscription required) */
    override fun followers(): FollowerServiceAsync = followers

    override fun dm(): DmServiceAsync = dm

    /** Media upload & download */
    override fun media(): MediaServiceAsync = media

    /** X write actions (tweets, likes, follows, DMs) */
    override fun profile(): ProfileServiceAsync = profile

    override fun communities(): CommunityServiceAsync = communities

    /** Connected X account management */
    override fun accounts(): AccountServiceAsync = accounts

    /** X data lookups (subscription required) */
    override fun bookmarks(): BookmarkServiceAsync = bookmarks

    /** X data lookups (subscription required) */
    override fun lists(): ListServiceAsync = lists

    override fun getArticle(
        params: XGetArticleParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<XGetArticleResponse> =
        // get /x/articles/{tweetId}
        withRawResponse().getArticle(params, requestOptions).thenApply { it.parse() }

    override fun getHomeTimeline(
        params: XGetHomeTimelineParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<XGetHomeTimelineResponse> =
        // get /x/timeline
        withRawResponse().getHomeTimeline(params, requestOptions).thenApply { it.parse() }

    override fun getNotifications(
        params: XGetNotificationsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<XGetNotificationsResponse> =
        // get /x/notifications
        withRawResponse().getNotifications(params, requestOptions).thenApply { it.parse() }

    override fun getTrends(
        params: XGetTrendsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<XGetTrendsResponse> =
        // get /x/trends
        withRawResponse().getTrends(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        XServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val tweets: TweetServiceAsync.WithRawResponse by lazy {
            TweetServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val users: UserServiceAsync.WithRawResponse by lazy {
            UserServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val followers: FollowerServiceAsync.WithRawResponse by lazy {
            FollowerServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val dm: DmServiceAsync.WithRawResponse by lazy {
            DmServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val media: MediaServiceAsync.WithRawResponse by lazy {
            MediaServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val profile: ProfileServiceAsync.WithRawResponse by lazy {
            ProfileServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val communities: CommunityServiceAsync.WithRawResponse by lazy {
            CommunityServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val accounts: AccountServiceAsync.WithRawResponse by lazy {
            AccountServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val bookmarks: BookmarkServiceAsync.WithRawResponse by lazy {
            BookmarkServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val lists: ListServiceAsync.WithRawResponse by lazy {
            ListServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): XServiceAsync.WithRawResponse =
            XServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun tweets(): TweetServiceAsync.WithRawResponse = tweets

        /** X data lookups (subscription required) */
        override fun users(): UserServiceAsync.WithRawResponse = users

        /** X data lookups (subscription required) */
        override fun followers(): FollowerServiceAsync.WithRawResponse = followers

        override fun dm(): DmServiceAsync.WithRawResponse = dm

        /** Media upload & download */
        override fun media(): MediaServiceAsync.WithRawResponse = media

        /** X write actions (tweets, likes, follows, DMs) */
        override fun profile(): ProfileServiceAsync.WithRawResponse = profile

        override fun communities(): CommunityServiceAsync.WithRawResponse = communities

        /** Connected X account management */
        override fun accounts(): AccountServiceAsync.WithRawResponse = accounts

        /** X data lookups (subscription required) */
        override fun bookmarks(): BookmarkServiceAsync.WithRawResponse = bookmarks

        /** X data lookups (subscription required) */
        override fun lists(): ListServiceAsync.WithRawResponse = lists

        private val getArticleHandler: Handler<XGetArticleResponse> =
            jsonHandler<XGetArticleResponse>(clientOptions.jsonMapper)

        override fun getArticle(
            params: XGetArticleParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<XGetArticleResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("tweetId", params.tweetId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "articles", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { getArticleHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val getHomeTimelineHandler: Handler<XGetHomeTimelineResponse> =
            jsonHandler<XGetHomeTimelineResponse>(clientOptions.jsonMapper)

        override fun getHomeTimeline(
            params: XGetHomeTimelineParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<XGetHomeTimelineResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "timeline")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { getHomeTimelineHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val getNotificationsHandler: Handler<XGetNotificationsResponse> =
            jsonHandler<XGetNotificationsResponse>(clientOptions.jsonMapper)

        override fun getNotifications(
            params: XGetNotificationsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<XGetNotificationsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "notifications")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { getNotificationsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val getTrendsHandler: Handler<XGetTrendsResponse> =
            jsonHandler<XGetTrendsResponse>(clientOptions.jsonMapper)

        override fun getTrends(
            params: XGetTrendsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<XGetTrendsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "trends")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { getTrendsHandler.handle(it) }
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
