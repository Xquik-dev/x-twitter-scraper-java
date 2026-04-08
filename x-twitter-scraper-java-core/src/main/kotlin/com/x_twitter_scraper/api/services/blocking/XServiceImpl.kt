// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

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
import com.x_twitter_scraper.api.models.x.XGetArticleParams
import com.x_twitter_scraper.api.models.x.XGetArticleResponse
import com.x_twitter_scraper.api.models.x.XGetHomeTimelineParams
import com.x_twitter_scraper.api.models.x.XGetHomeTimelineResponse
import com.x_twitter_scraper.api.models.x.XGetNotificationsParams
import com.x_twitter_scraper.api.models.x.XGetNotificationsResponse
import com.x_twitter_scraper.api.models.x.XGetTrendsParams
import com.x_twitter_scraper.api.models.x.XGetTrendsResponse
import com.x_twitter_scraper.api.services.blocking.x.AccountService
import com.x_twitter_scraper.api.services.blocking.x.AccountServiceImpl
import com.x_twitter_scraper.api.services.blocking.x.BookmarkService
import com.x_twitter_scraper.api.services.blocking.x.BookmarkServiceImpl
import com.x_twitter_scraper.api.services.blocking.x.CommunityService
import com.x_twitter_scraper.api.services.blocking.x.CommunityServiceImpl
import com.x_twitter_scraper.api.services.blocking.x.DmService
import com.x_twitter_scraper.api.services.blocking.x.DmServiceImpl
import com.x_twitter_scraper.api.services.blocking.x.FollowerService
import com.x_twitter_scraper.api.services.blocking.x.FollowerServiceImpl
import com.x_twitter_scraper.api.services.blocking.x.ListService
import com.x_twitter_scraper.api.services.blocking.x.ListServiceImpl
import com.x_twitter_scraper.api.services.blocking.x.MediaService
import com.x_twitter_scraper.api.services.blocking.x.MediaServiceImpl
import com.x_twitter_scraper.api.services.blocking.x.ProfileService
import com.x_twitter_scraper.api.services.blocking.x.ProfileServiceImpl
import com.x_twitter_scraper.api.services.blocking.x.TweetService
import com.x_twitter_scraper.api.services.blocking.x.TweetServiceImpl
import com.x_twitter_scraper.api.services.blocking.x.UserService
import com.x_twitter_scraper.api.services.blocking.x.UserServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** X data lookups (subscription required) */
class XServiceImpl internal constructor(private val clientOptions: ClientOptions) : XService {

    private val withRawResponse: XService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val tweets: TweetService by lazy { TweetServiceImpl(clientOptions) }

    private val users: UserService by lazy { UserServiceImpl(clientOptions) }

    private val followers: FollowerService by lazy { FollowerServiceImpl(clientOptions) }

    private val dm: DmService by lazy { DmServiceImpl(clientOptions) }

    private val media: MediaService by lazy { MediaServiceImpl(clientOptions) }

    private val profile: ProfileService by lazy { ProfileServiceImpl(clientOptions) }

    private val communities: CommunityService by lazy { CommunityServiceImpl(clientOptions) }

    private val accounts: AccountService by lazy { AccountServiceImpl(clientOptions) }

    private val bookmarks: BookmarkService by lazy { BookmarkServiceImpl(clientOptions) }

    private val lists: ListService by lazy { ListServiceImpl(clientOptions) }

    override fun withRawResponse(): XService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): XService =
        XServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun tweets(): TweetService = tweets

    /** X data lookups (subscription required) */
    override fun users(): UserService = users

    /** X data lookups (subscription required) */
    override fun followers(): FollowerService = followers

    override fun dm(): DmService = dm

    /** Media upload & download */
    override fun media(): MediaService = media

    /** X write actions (tweets, likes, follows, DMs) */
    override fun profile(): ProfileService = profile

    override fun communities(): CommunityService = communities

    /** Connected X account management */
    override fun accounts(): AccountService = accounts

    /** X data lookups (subscription required) */
    override fun bookmarks(): BookmarkService = bookmarks

    /** X data lookups (subscription required) */
    override fun lists(): ListService = lists

    override fun getArticle(
        params: XGetArticleParams,
        requestOptions: RequestOptions,
    ): XGetArticleResponse =
        // get /x/articles/{tweetId}
        withRawResponse().getArticle(params, requestOptions).parse()

    override fun getHomeTimeline(
        params: XGetHomeTimelineParams,
        requestOptions: RequestOptions,
    ): XGetHomeTimelineResponse =
        // get /x/timeline
        withRawResponse().getHomeTimeline(params, requestOptions).parse()

    override fun getNotifications(
        params: XGetNotificationsParams,
        requestOptions: RequestOptions,
    ): XGetNotificationsResponse =
        // get /x/notifications
        withRawResponse().getNotifications(params, requestOptions).parse()

    override fun getTrends(
        params: XGetTrendsParams,
        requestOptions: RequestOptions,
    ): XGetTrendsResponse =
        // get /x/trends
        withRawResponse().getTrends(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        XService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val tweets: TweetService.WithRawResponse by lazy {
            TweetServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val users: UserService.WithRawResponse by lazy {
            UserServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val followers: FollowerService.WithRawResponse by lazy {
            FollowerServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val dm: DmService.WithRawResponse by lazy {
            DmServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val media: MediaService.WithRawResponse by lazy {
            MediaServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val profile: ProfileService.WithRawResponse by lazy {
            ProfileServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val communities: CommunityService.WithRawResponse by lazy {
            CommunityServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val accounts: AccountService.WithRawResponse by lazy {
            AccountServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val bookmarks: BookmarkService.WithRawResponse by lazy {
            BookmarkServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val lists: ListService.WithRawResponse by lazy {
            ListServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): XService.WithRawResponse =
            XServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun tweets(): TweetService.WithRawResponse = tweets

        /** X data lookups (subscription required) */
        override fun users(): UserService.WithRawResponse = users

        /** X data lookups (subscription required) */
        override fun followers(): FollowerService.WithRawResponse = followers

        override fun dm(): DmService.WithRawResponse = dm

        /** Media upload & download */
        override fun media(): MediaService.WithRawResponse = media

        /** X write actions (tweets, likes, follows, DMs) */
        override fun profile(): ProfileService.WithRawResponse = profile

        override fun communities(): CommunityService.WithRawResponse = communities

        /** Connected X account management */
        override fun accounts(): AccountService.WithRawResponse = accounts

        /** X data lookups (subscription required) */
        override fun bookmarks(): BookmarkService.WithRawResponse = bookmarks

        /** X data lookups (subscription required) */
        override fun lists(): ListService.WithRawResponse = lists

        private val getArticleHandler: Handler<XGetArticleResponse> =
            jsonHandler<XGetArticleResponse>(clientOptions.jsonMapper)

        override fun getArticle(
            params: XGetArticleParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<XGetArticleResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("tweetId", params.tweetId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "articles", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getArticleHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getHomeTimelineHandler: Handler<XGetHomeTimelineResponse> =
            jsonHandler<XGetHomeTimelineResponse>(clientOptions.jsonMapper)

        override fun getHomeTimeline(
            params: XGetHomeTimelineParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<XGetHomeTimelineResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "timeline")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getHomeTimelineHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getNotificationsHandler: Handler<XGetNotificationsResponse> =
            jsonHandler<XGetNotificationsResponse>(clientOptions.jsonMapper)

        override fun getNotifications(
            params: XGetNotificationsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<XGetNotificationsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "notifications")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getNotificationsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getTrendsHandler: Handler<XGetTrendsResponse> =
            jsonHandler<XGetTrendsResponse>(clientOptions.jsonMapper)

        override fun getTrends(
            params: XGetTrendsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<XGetTrendsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "trends")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
