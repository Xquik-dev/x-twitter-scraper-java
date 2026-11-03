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
import com.x_twitter_scraper.api.core.http.parseable
import com.x_twitter_scraper.api.core.prepareAsync
import com.x_twitter_scraper.api.models.x.sports.FootballBoxScore
import com.x_twitter_scraper.api.models.x.sports.FootballPlays
import com.x_twitter_scraper.api.models.x.sports.FootballProps
import com.x_twitter_scraper.api.models.x.sports.FootballRoster
import com.x_twitter_scraper.api.models.x.sports.FootballSchedule
import com.x_twitter_scraper.api.models.x.sports.FootballScoreboard
import com.x_twitter_scraper.api.models.x.sports.SportListGamesParams
import com.x_twitter_scraper.api.models.x.sports.SportListPostsParams
import com.x_twitter_scraper.api.models.x.sports.SportRetrieveAudienceParams
import com.x_twitter_scraper.api.models.x.sports.SportRetrieveBoxScoreParams
import com.x_twitter_scraper.api.models.x.sports.SportRetrievePlayerPropsParams
import com.x_twitter_scraper.api.models.x.sports.SportRetrievePlaysParams
import com.x_twitter_scraper.api.models.x.sports.SportRetrieveRosterParams
import com.x_twitter_scraper.api.models.x.sports.SportRetrieveScoreboardParams
import com.x_twitter_scraper.api.models.x.sports.SportsGameAudience
import com.x_twitter_scraper.api.models.x.sports.SportsGamePosts
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** NFL & college football games, scoreboards, plays & box scores */
class SportServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SportServiceAsync {

    private val withRawResponse: SportServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SportServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SportServiceAsync =
        SportServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun listGames(
        params: SportListGamesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FootballSchedule> =
        withRawResponse().listGames(params, requestOptions).thenApply { it.parse() }

    override fun retrieveScoreboard(
        params: SportRetrieveScoreboardParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FootballScoreboard> =
        withRawResponse().retrieveScoreboard(params, requestOptions).thenApply { it.parse() }

    override fun retrieveBoxScore(
        params: SportRetrieveBoxScoreParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FootballBoxScore> =
        withRawResponse().retrieveBoxScore(params, requestOptions).thenApply { it.parse() }

    override fun retrievePlays(
        params: SportRetrievePlaysParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FootballPlays> =
        withRawResponse().retrievePlays(params, requestOptions).thenApply { it.parse() }

    override fun retrieveAudience(
        params: SportRetrieveAudienceParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<SportsGameAudience> =
        withRawResponse().retrieveAudience(params, requestOptions).thenApply { it.parse() }

    override fun retrieveRoster(
        params: SportRetrieveRosterParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FootballRoster> =
        withRawResponse().retrieveRoster(params, requestOptions).thenApply { it.parse() }

    override fun retrievePlayerProps(
        params: SportRetrievePlayerPropsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FootballProps> =
        withRawResponse().retrievePlayerProps(params, requestOptions).thenApply { it.parse() }

    override fun listPosts(
        params: SportListPostsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<SportsGamePosts> =
        withRawResponse().listPosts(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SportServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SportServiceAsync.WithRawResponse =
            SportServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listGamesHandler: Handler<FootballSchedule> =
            jsonHandler<FootballSchedule>(clientOptions.jsonMapper)

        override fun listGames(
            params: SportListGamesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FootballSchedule>> {
            checkRequired("league", params.league().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "sports", params._pathParam(0), "games")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listGamesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveScoreboardHandler: Handler<FootballScoreboard> =
            jsonHandler<FootballScoreboard>(clientOptions.jsonMapper)

        override fun retrieveScoreboard(
            params: SportRetrieveScoreboardParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FootballScoreboard>> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "x",
                        "sports",
                        params._pathParam(0),
                        "games",
                        params._pathParam(1),
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveScoreboardHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveBoxScoreHandler: Handler<FootballBoxScore> =
            jsonHandler<FootballBoxScore>(clientOptions.jsonMapper)

        override fun retrieveBoxScore(
            params: SportRetrieveBoxScoreParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FootballBoxScore>> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "x",
                        "sports",
                        params._pathParam(0),
                        "games",
                        params._pathParam(1),
                        "box-score",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveBoxScoreHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrievePlaysHandler: Handler<FootballPlays> =
            jsonHandler<FootballPlays>(clientOptions.jsonMapper)

        override fun retrievePlays(
            params: SportRetrievePlaysParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FootballPlays>> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "x",
                        "sports",
                        params._pathParam(0),
                        "games",
                        params._pathParam(1),
                        "plays",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrievePlaysHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveAudienceHandler: Handler<SportsGameAudience> =
            jsonHandler<SportsGameAudience>(clientOptions.jsonMapper)

        override fun retrieveAudience(
            params: SportRetrieveAudienceParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SportsGameAudience>> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "x",
                        "sports",
                        params._pathParam(0),
                        "games",
                        params._pathParam(1),
                        "audience",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveAudienceHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveRosterHandler: Handler<FootballRoster> =
            jsonHandler<FootballRoster>(clientOptions.jsonMapper)

        override fun retrieveRoster(
            params: SportRetrieveRosterParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FootballRoster>> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "x",
                        "sports",
                        params._pathParam(0),
                        "games",
                        params._pathParam(1),
                        "roster",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveRosterHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrievePlayerPropsHandler: Handler<FootballProps> =
            jsonHandler<FootballProps>(clientOptions.jsonMapper)

        override fun retrievePlayerProps(
            params: SportRetrievePlayerPropsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FootballProps>> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "x",
                        "sports",
                        params._pathParam(0),
                        "games",
                        params._pathParam(1),
                        "player-props",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrievePlayerPropsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listPostsHandler: Handler<SportsGamePosts> =
            jsonHandler<SportsGamePosts>(clientOptions.jsonMapper)

        override fun listPosts(
            params: SportListPostsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SportsGamePosts>> {
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "x",
                        "sports",
                        params._pathParam(0),
                        "games",
                        params._pathParam(1),
                        "posts",
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listPostsHandler.handle(it) }
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
