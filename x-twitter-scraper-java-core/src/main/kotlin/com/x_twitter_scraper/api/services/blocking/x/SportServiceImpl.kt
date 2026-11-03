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
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** NFL & college football games, scoreboards, plays & box scores */
class SportServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SportService {

    private val withRawResponse: SportService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SportService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SportService =
        SportServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun listGames(
        params: SportListGamesParams,
        requestOptions: RequestOptions,
    ): FootballSchedule = withRawResponse().listGames(params, requestOptions).parse()

    override fun retrieveScoreboard(
        params: SportRetrieveScoreboardParams,
        requestOptions: RequestOptions,
    ): FootballScoreboard = withRawResponse().retrieveScoreboard(params, requestOptions).parse()

    override fun retrieveBoxScore(
        params: SportRetrieveBoxScoreParams,
        requestOptions: RequestOptions,
    ): FootballBoxScore = withRawResponse().retrieveBoxScore(params, requestOptions).parse()

    override fun retrievePlays(
        params: SportRetrievePlaysParams,
        requestOptions: RequestOptions,
    ): FootballPlays = withRawResponse().retrievePlays(params, requestOptions).parse()

    override fun retrieveAudience(
        params: SportRetrieveAudienceParams,
        requestOptions: RequestOptions,
    ): SportsGameAudience = withRawResponse().retrieveAudience(params, requestOptions).parse()

    override fun retrieveRoster(
        params: SportRetrieveRosterParams,
        requestOptions: RequestOptions,
    ): FootballRoster = withRawResponse().retrieveRoster(params, requestOptions).parse()

    override fun retrievePlayerProps(
        params: SportRetrievePlayerPropsParams,
        requestOptions: RequestOptions,
    ): FootballProps = withRawResponse().retrievePlayerProps(params, requestOptions).parse()

    override fun listPosts(
        params: SportListPostsParams,
        requestOptions: RequestOptions,
    ): SportsGamePosts = withRawResponse().listPosts(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SportService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SportService.WithRawResponse =
            SportServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listGamesHandler: Handler<FootballSchedule> =
            jsonHandler<FootballSchedule>(clientOptions.jsonMapper)

        override fun listGames(
            params: SportListGamesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FootballSchedule> {
            checkRequired("league", params.league().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("x", "sports", params._pathParam(0), "games")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listGamesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveScoreboardHandler: Handler<FootballScoreboard> =
            jsonHandler<FootballScoreboard>(clientOptions.jsonMapper)

        override fun retrieveScoreboard(
            params: SportRetrieveScoreboardParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FootballScoreboard> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveScoreboardHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveBoxScoreHandler: Handler<FootballBoxScore> =
            jsonHandler<FootballBoxScore>(clientOptions.jsonMapper)

        override fun retrieveBoxScore(
            params: SportRetrieveBoxScoreParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FootballBoxScore> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveBoxScoreHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrievePlaysHandler: Handler<FootballPlays> =
            jsonHandler<FootballPlays>(clientOptions.jsonMapper)

        override fun retrievePlays(
            params: SportRetrievePlaysParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FootballPlays> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrievePlaysHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveAudienceHandler: Handler<SportsGameAudience> =
            jsonHandler<SportsGameAudience>(clientOptions.jsonMapper)

        override fun retrieveAudience(
            params: SportRetrieveAudienceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SportsGameAudience> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveAudienceHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveRosterHandler: Handler<FootballRoster> =
            jsonHandler<FootballRoster>(clientOptions.jsonMapper)

        override fun retrieveRoster(
            params: SportRetrieveRosterParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FootballRoster> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveRosterHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrievePlayerPropsHandler: Handler<FootballProps> =
            jsonHandler<FootballProps>(clientOptions.jsonMapper)

        override fun retrievePlayerProps(
            params: SportRetrievePlayerPropsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FootballProps> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrievePlayerPropsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listPostsHandler: Handler<SportsGamePosts> =
            jsonHandler<SportsGamePosts>(clientOptions.jsonMapper)

        override fun listPosts(
            params: SportListPostsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SportsGamePosts> {
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
