// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.HttpResponseFor
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

/** NFL & college football games, scoreboards, plays & box scores */
interface SportServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SportServiceAsync

    /**
     * Lists NFL or college football games in a time window, with teams & scores. Use it to find
     * game IDs & team IDs. Without from or to, X picks about 5 weeks around today. Each request
     * costs 1 credit.
     */
    fun listGames(league: String): CompletableFuture<FootballSchedule> =
        listGames(league, SportListGamesParams.none())

    /** @see listGames */
    fun listGames(
        league: String,
        params: SportListGamesParams = SportListGamesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FootballSchedule> =
        listGames(params.toBuilder().league(league).build(), requestOptions)

    /** @see listGames */
    fun listGames(
        league: String,
        params: SportListGamesParams = SportListGamesParams.none(),
    ): CompletableFuture<FootballSchedule> = listGames(league, params, RequestOptions.none())

    /** @see listGames */
    fun listGames(
        params: SportListGamesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FootballSchedule>

    /** @see listGames */
    fun listGames(params: SportListGamesParams): CompletableFuture<FootballSchedule> =
        listGames(params, RequestOptions.none())

    /** @see listGames */
    fun listGames(
        league: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<FootballSchedule> =
        listGames(league, SportListGamesParams.none(), requestOptions)

    /**
     * Returns 1 game's scoreboard. It has the teams, the score by period, the status & clock, down
     * & distance, the venue & the latest play. Each request costs 1 credit.
     */
    fun retrieveScoreboard(
        id: String,
        params: SportRetrieveScoreboardParams,
    ): CompletableFuture<FootballScoreboard> =
        retrieveScoreboard(id, params, RequestOptions.none())

    /** @see retrieveScoreboard */
    fun retrieveScoreboard(
        id: String,
        params: SportRetrieveScoreboardParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FootballScoreboard> =
        retrieveScoreboard(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveScoreboard */
    fun retrieveScoreboard(
        params: SportRetrieveScoreboardParams
    ): CompletableFuture<FootballScoreboard> = retrieveScoreboard(params, RequestOptions.none())

    /** @see retrieveScoreboard */
    fun retrieveScoreboard(
        params: SportRetrieveScoreboardParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FootballScoreboard>

    /**
     * Returns each team's totals & each player's stats for 1 game. Stats cover passing, rushing,
     * receiving, defense, kicking & returns. A game that has not started has no stats yet. Each
     * request costs 1 credit.
     */
    fun retrieveBoxScore(
        id: String,
        params: SportRetrieveBoxScoreParams,
    ): CompletableFuture<FootballBoxScore> =
        retrieveBoxScore(id, params, RequestOptions.none())

    /** @see retrieveBoxScore */
    fun retrieveBoxScore(
        id: String,
        params: SportRetrieveBoxScoreParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FootballBoxScore> =
        retrieveBoxScore(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveBoxScore */
    fun retrieveBoxScore(params: SportRetrieveBoxScoreParams): CompletableFuture<FootballBoxScore> =
        retrieveBoxScore(params, RequestOptions.none())

    /** @see retrieveBoxScore */
    fun retrieveBoxScore(
        params: SportRetrieveBoxScoreParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FootballBoxScore>

    /**
     * Returns every drive & play of 1 game, by quarter. Each play has its clock, down & distance,
     * details, penalties & linked posts. Each request costs 1 credit.
     */
    fun retrievePlays(
        id: String,
        params: SportRetrievePlaysParams,
    ): CompletableFuture<FootballPlays> =
        retrievePlays(id, params, RequestOptions.none())

    /** @see retrievePlays */
    fun retrievePlays(
        id: String,
        params: SportRetrievePlaysParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FootballPlays> =
        retrievePlays(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrievePlays */
    fun retrievePlays(params: SportRetrievePlaysParams): CompletableFuture<FootballPlays> =
        retrievePlays(params, RequestOptions.none())

    /** @see retrievePlays */
    fun retrievePlays(
        params: SportRetrievePlaysParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FootballPlays>

    /**
     * Returns who follows 1 game on X. It has live viewers, fan picks per team & the game chat's
     * state. Each request costs 1 credit.
     */
    fun retrieveAudience(
        id: String,
        params: SportRetrieveAudienceParams,
    ): CompletableFuture<SportsGameAudience> =
        retrieveAudience(id, params, RequestOptions.none())

    /** @see retrieveAudience */
    fun retrieveAudience(
        id: String,
        params: SportRetrieveAudienceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SportsGameAudience> =
        retrieveAudience(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveAudience */
    fun retrieveAudience(
        params: SportRetrieveAudienceParams
    ): CompletableFuture<SportsGameAudience> = retrieveAudience(params, RequestOptions.none())

    /** @see retrieveAudience */
    fun retrieveAudience(
        params: SportRetrieveAudienceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SportsGameAudience>

    /**
     * Returns both teams' players for 1 NFL game. Each player has a jersey, position, headshot & X account. Each request costs 1 credit.
     */
    fun retrieveRoster(
        id: String,
        params: SportRetrieveRosterParams,
    ): CompletableFuture<FootballRoster> =
        retrieveRoster(id, params, RequestOptions.none())

    /** @see retrieveRoster */
    fun retrieveRoster(
        id: String,
        params: SportRetrieveRosterParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FootballRoster> =
        retrieveRoster(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveRoster */
    fun retrieveRoster(
        params: SportRetrieveRosterParams
    ): CompletableFuture<FootballRoster> = retrieveRoster(params, RequestOptions.none())

    /** @see retrieveRoster */
    fun retrieveRoster(
        params: SportRetrieveRosterParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FootballRoster>

    /**
     * Returns the player prop lines & American odds X shows for 1 NFL game. X lists props before & during a game. Other games return no categories. Each request costs 1 credit.
     */
    fun retrievePlayerProps(
        id: String,
        params: SportRetrievePlayerPropsParams,
    ): CompletableFuture<FootballProps> =
        retrievePlayerProps(id, params, RequestOptions.none())

    /** @see retrievePlayerProps */
    fun retrievePlayerProps(
        id: String,
        params: SportRetrievePlayerPropsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FootballProps> =
        retrievePlayerProps(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrievePlayerProps */
    fun retrievePlayerProps(
        params: SportRetrievePlayerPropsParams
    ): CompletableFuture<FootballProps> = retrievePlayerProps(params, RequestOptions.none())

    /** @see retrievePlayerProps */
    fun retrievePlayerProps(
        params: SportRetrievePlayerPropsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FootballProps>

    /**
     * Returns a game's top or latest posts, plus an X search you can run for more. Works before, during & after the game. Pages hold up to 20 posts, & each post costs 1 credit.
     */
    fun listPosts(
        id: String,
        params: SportListPostsParams,
    ): CompletableFuture<SportsGamePosts> =
        listPosts(id, params, RequestOptions.none())

    /** @see listPosts */
    fun listPosts(
        id: String,
        params: SportListPostsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SportsGamePosts> =
        listPosts(params.toBuilder().id(id).build(), requestOptions)

    /** @see listPosts */
    fun listPosts(
        params: SportListPostsParams
    ): CompletableFuture<SportsGamePosts> = listPosts(params, RequestOptions.none())

    /** @see listPosts */
    fun listPosts(
        params: SportListPostsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SportsGamePosts>

    /**
     * A view of [SportServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SportServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/sports/{league}/games`, but is otherwise the same
         * as [SportServiceAsync.listGames].
         */
        fun listGames(league: String): CompletableFuture<HttpResponseFor<FootballSchedule>> =
            listGames(league, SportListGamesParams.none())

        /** @see listGames */
        fun listGames(
            league: String,
            params: SportListGamesParams = SportListGamesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FootballSchedule>> =
            listGames(params.toBuilder().league(league).build(), requestOptions)

        /** @see listGames */
        fun listGames(
            league: String,
            params: SportListGamesParams = SportListGamesParams.none(),
        ): CompletableFuture<HttpResponseFor<FootballSchedule>> =
            listGames(league, params, RequestOptions.none())

        /** @see listGames */
        fun listGames(
            params: SportListGamesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FootballSchedule>>

        /** @see listGames */
        fun listGames(
            params: SportListGamesParams
        ): CompletableFuture<HttpResponseFor<FootballSchedule>> =
            listGames(params, RequestOptions.none())

        /** @see listGames */
        fun listGames(
            league: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FootballSchedule>> =
            listGames(league, SportListGamesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/sports/{league}/games/{id}`, but is otherwise the
         * same as [SportServiceAsync.retrieveScoreboard].
         */
        fun retrieveScoreboard(
            id: String,
            params: SportRetrieveScoreboardParams,
        ): CompletableFuture<HttpResponseFor<FootballScoreboard>> =
            retrieveScoreboard(id, params, RequestOptions.none())

        /** @see retrieveScoreboard */
        fun retrieveScoreboard(
            id: String,
            params: SportRetrieveScoreboardParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FootballScoreboard>> =
            retrieveScoreboard(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveScoreboard */
        fun retrieveScoreboard(
            params: SportRetrieveScoreboardParams
        ): CompletableFuture<HttpResponseFor<FootballScoreboard>> =
            retrieveScoreboard(params, RequestOptions.none())

        /** @see retrieveScoreboard */
        fun retrieveScoreboard(
            params: SportRetrieveScoreboardParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FootballScoreboard>>

        /**
         * Returns a raw HTTP response for `get /x/sports/{league}/games/{id}/box-score`, but is
         * otherwise the same as [SportServiceAsync.retrieveBoxScore].
         */
        fun retrieveBoxScore(
            id: String,
            params: SportRetrieveBoxScoreParams,
        ): CompletableFuture<HttpResponseFor<FootballBoxScore>> =
            retrieveBoxScore(id, params, RequestOptions.none())

        /** @see retrieveBoxScore */
        fun retrieveBoxScore(
            id: String,
            params: SportRetrieveBoxScoreParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FootballBoxScore>> =
            retrieveBoxScore(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveBoxScore */
        fun retrieveBoxScore(
            params: SportRetrieveBoxScoreParams
        ): CompletableFuture<HttpResponseFor<FootballBoxScore>> =
            retrieveBoxScore(params, RequestOptions.none())

        /** @see retrieveBoxScore */
        fun retrieveBoxScore(
            params: SportRetrieveBoxScoreParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FootballBoxScore>>

        /**
         * Returns a raw HTTP response for `get /x/sports/{league}/games/{id}/plays`, but is
         * otherwise the same as [SportServiceAsync.retrievePlays].
         */
        fun retrievePlays(
            id: String,
            params: SportRetrievePlaysParams,
        ): CompletableFuture<HttpResponseFor<FootballPlays>> =
            retrievePlays(id, params, RequestOptions.none())

        /** @see retrievePlays */
        fun retrievePlays(
            id: String,
            params: SportRetrievePlaysParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FootballPlays>> =
            retrievePlays(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrievePlays */
        fun retrievePlays(
            params: SportRetrievePlaysParams
        ): CompletableFuture<HttpResponseFor<FootballPlays>> =
            retrievePlays(params, RequestOptions.none())

        /** @see retrievePlays */
        fun retrievePlays(
            params: SportRetrievePlaysParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FootballPlays>>

        /**
         * Returns a raw HTTP response for `get /x/sports/{league}/games/{id}/audience`, but is
         * otherwise the same as [SportServiceAsync.retrieveAudience].
         */
        fun retrieveAudience(
            id: String,
            params: SportRetrieveAudienceParams,
        ): CompletableFuture<HttpResponseFor<SportsGameAudience>> =
            retrieveAudience(id, params, RequestOptions.none())

        /** @see retrieveAudience */
        fun retrieveAudience(
            id: String,
            params: SportRetrieveAudienceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SportsGameAudience>> =
            retrieveAudience(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveAudience */
        fun retrieveAudience(
            params: SportRetrieveAudienceParams
        ): CompletableFuture<HttpResponseFor<SportsGameAudience>> =
            retrieveAudience(params, RequestOptions.none())

        /** @see retrieveAudience */
        fun retrieveAudience(
            params: SportRetrieveAudienceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SportsGameAudience>>

        /**
         * Returns a raw HTTP response for `get /x/sports/{league}/games/{id}/roster`, but is
         * otherwise the same as [SportServiceAsync.retrieveRoster].
         */
        fun retrieveRoster(
            id: String,
            params: SportRetrieveRosterParams,
        ): CompletableFuture<HttpResponseFor<FootballRoster>> =
            retrieveRoster(id, params, RequestOptions.none())

        /** @see retrieveRoster */
        fun retrieveRoster(
            id: String,
            params: SportRetrieveRosterParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FootballRoster>> =
            retrieveRoster(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveRoster */
        fun retrieveRoster(
            params: SportRetrieveRosterParams
        ): CompletableFuture<HttpResponseFor<FootballRoster>> =
            retrieveRoster(params, RequestOptions.none())

        /** @see retrieveRoster */
        fun retrieveRoster(
            params: SportRetrieveRosterParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FootballRoster>>

        /**
         * Returns a raw HTTP response for `get /x/sports/{league}/games/{id}/player-props`, but is
         * otherwise the same as [SportServiceAsync.retrievePlayerProps].
         */
        fun retrievePlayerProps(
            id: String,
            params: SportRetrievePlayerPropsParams,
        ): CompletableFuture<HttpResponseFor<FootballProps>> =
            retrievePlayerProps(id, params, RequestOptions.none())

        /** @see retrievePlayerProps */
        fun retrievePlayerProps(
            id: String,
            params: SportRetrievePlayerPropsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FootballProps>> =
            retrievePlayerProps(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrievePlayerProps */
        fun retrievePlayerProps(
            params: SportRetrievePlayerPropsParams
        ): CompletableFuture<HttpResponseFor<FootballProps>> =
            retrievePlayerProps(params, RequestOptions.none())

        /** @see retrievePlayerProps */
        fun retrievePlayerProps(
            params: SportRetrievePlayerPropsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FootballProps>>

        /**
         * Returns a raw HTTP response for `get /x/sports/{league}/games/{id}/posts`, but is
         * otherwise the same as [SportServiceAsync.listPosts].
         */
        fun listPosts(
            id: String,
            params: SportListPostsParams,
        ): CompletableFuture<HttpResponseFor<SportsGamePosts>> =
            listPosts(id, params, RequestOptions.none())

        /** @see listPosts */
        fun listPosts(
            id: String,
            params: SportListPostsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SportsGamePosts>> =
            listPosts(params.toBuilder().id(id).build(), requestOptions)

        /** @see listPosts */
        fun listPosts(
            params: SportListPostsParams
        ): CompletableFuture<HttpResponseFor<SportsGamePosts>> =
            listPosts(params, RequestOptions.none())

        /** @see listPosts */
        fun listPosts(
            params: SportListPostsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SportsGamePosts>>
    }
}
