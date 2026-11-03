// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.google.errorprone.annotations.MustBeClosed
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
import java.util.function.Consumer

/** NFL & college football games, scoreboards, plays & box scores */
interface SportService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SportService

    /**
     * Lists NFL or college football games in a time window, with teams & scores. Use it to find
     * game IDs & team IDs. Without from or to, X picks about 5 weeks around today. Each request
     * costs 1 credit.
     */
    fun listGames(league: String): FootballSchedule = listGames(league, SportListGamesParams.none())

    /** @see listGames */
    fun listGames(
        league: String,
        params: SportListGamesParams = SportListGamesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FootballSchedule = listGames(params.toBuilder().league(league).build(), requestOptions)

    /** @see listGames */
    fun listGames(
        league: String,
        params: SportListGamesParams = SportListGamesParams.none(),
    ): FootballSchedule = listGames(league, params, RequestOptions.none())

    /** @see listGames */
    fun listGames(
        params: SportListGamesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FootballSchedule

    /** @see listGames */
    fun listGames(params: SportListGamesParams): FootballSchedule =
        listGames(params, RequestOptions.none())

    /** @see listGames */
    fun listGames(league: String, requestOptions: RequestOptions): FootballSchedule =
        listGames(league, SportListGamesParams.none(), requestOptions)

    /**
     * Returns 1 game's scoreboard. It has the teams, the score by period, the status & clock, down
     * & distance, the venue & the latest play. Each request costs 1 credit.
     */
    fun retrieveScoreboard(id: String, params: SportRetrieveScoreboardParams): FootballScoreboard =
        retrieveScoreboard(id, params, RequestOptions.none())

    /** @see retrieveScoreboard */
    fun retrieveScoreboard(
        id: String,
        params: SportRetrieveScoreboardParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FootballScoreboard =
        retrieveScoreboard(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveScoreboard */
    fun retrieveScoreboard(params: SportRetrieveScoreboardParams): FootballScoreboard =
        retrieveScoreboard(params, RequestOptions.none())

    /** @see retrieveScoreboard */
    fun retrieveScoreboard(
        params: SportRetrieveScoreboardParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FootballScoreboard

    /**
     * Returns each team's totals & each player's stats for 1 game. Stats cover passing, rushing,
     * receiving, defense, kicking & returns. A game that has not started has no stats yet. Each
     * request costs 1 credit.
     */
    fun retrieveBoxScore(id: String, params: SportRetrieveBoxScoreParams): FootballBoxScore =
        retrieveBoxScore(id, params, RequestOptions.none())

    /** @see retrieveBoxScore */
    fun retrieveBoxScore(
        id: String,
        params: SportRetrieveBoxScoreParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FootballBoxScore =
        retrieveBoxScore(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveBoxScore */
    fun retrieveBoxScore(params: SportRetrieveBoxScoreParams): FootballBoxScore =
        retrieveBoxScore(params, RequestOptions.none())

    /** @see retrieveBoxScore */
    fun retrieveBoxScore(
        params: SportRetrieveBoxScoreParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FootballBoxScore

    /**
     * Returns every drive & play of 1 game, by quarter. Each play has its clock, down & distance,
     * details, penalties & linked posts. Each request costs 1 credit.
     */
    fun retrievePlays(id: String, params: SportRetrievePlaysParams): FootballPlays =
        retrievePlays(id, params, RequestOptions.none())

    /** @see retrievePlays */
    fun retrievePlays(
        id: String,
        params: SportRetrievePlaysParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FootballPlays =
        retrievePlays(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrievePlays */
    fun retrievePlays(params: SportRetrievePlaysParams): FootballPlays =
        retrievePlays(params, RequestOptions.none())

    /** @see retrievePlays */
    fun retrievePlays(
        params: SportRetrievePlaysParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FootballPlays

    /**
     * Returns who follows 1 game on X. It has live viewers, fan picks per team & the game chat's
     * state. Each request costs 1 credit.
     */
    fun retrieveAudience(id: String, params: SportRetrieveAudienceParams): SportsGameAudience =
        retrieveAudience(id, params, RequestOptions.none())

    /** @see retrieveAudience */
    fun retrieveAudience(
        id: String,
        params: SportRetrieveAudienceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SportsGameAudience =
        retrieveAudience(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveAudience */
    fun retrieveAudience(params: SportRetrieveAudienceParams): SportsGameAudience =
        retrieveAudience(params, RequestOptions.none())

    /** @see retrieveAudience */
    fun retrieveAudience(
        params: SportRetrieveAudienceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SportsGameAudience

    /**
     * Returns both teams' players for 1 NFL game. Each player has a jersey, position, headshot & X account. Each request costs 1 credit.
     */
    fun retrieveRoster(id: String, params: SportRetrieveRosterParams): FootballRoster =
        retrieveRoster(id, params, RequestOptions.none())

    /** @see retrieveRoster */
    fun retrieveRoster(
        id: String,
        params: SportRetrieveRosterParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FootballRoster =
        retrieveRoster(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieveRoster */
    fun retrieveRoster(params: SportRetrieveRosterParams): FootballRoster =
        retrieveRoster(params, RequestOptions.none())

    /** @see retrieveRoster */
    fun retrieveRoster(
        params: SportRetrieveRosterParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FootballRoster

    /**
     * Returns the player prop lines & American odds X shows for 1 NFL game. X lists props before & during a game. Other games return no categories. Each request costs 1 credit.
     */
    fun retrievePlayerProps(id: String, params: SportRetrievePlayerPropsParams): FootballProps =
        retrievePlayerProps(id, params, RequestOptions.none())

    /** @see retrievePlayerProps */
    fun retrievePlayerProps(
        id: String,
        params: SportRetrievePlayerPropsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FootballProps =
        retrievePlayerProps(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrievePlayerProps */
    fun retrievePlayerProps(params: SportRetrievePlayerPropsParams): FootballProps =
        retrievePlayerProps(params, RequestOptions.none())

    /** @see retrievePlayerProps */
    fun retrievePlayerProps(
        params: SportRetrievePlayerPropsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FootballProps

    /**
     * Returns a game's top or latest posts, plus an X search you can run for more. Works before, during & after the game. Pages hold up to 20 posts, & each post costs 1 credit.
     */
    fun listPosts(id: String, params: SportListPostsParams): SportsGamePosts =
        listPosts(id, params, RequestOptions.none())

    /** @see listPosts */
    fun listPosts(
        id: String,
        params: SportListPostsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SportsGamePosts =
        listPosts(params.toBuilder().id(id).build(), requestOptions)

    /** @see listPosts */
    fun listPosts(params: SportListPostsParams): SportsGamePosts =
        listPosts(params, RequestOptions.none())

    /** @see listPosts */
    fun listPosts(
        params: SportListPostsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SportsGamePosts

    /** A view of [SportService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): SportService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /x/sports/{league}/games`, but is otherwise the same
         * as [SportService.listGames].
         */
        @MustBeClosed
        fun listGames(league: String): HttpResponseFor<FootballSchedule> =
            listGames(league, SportListGamesParams.none())

        /** @see listGames */
        @MustBeClosed
        fun listGames(
            league: String,
            params: SportListGamesParams = SportListGamesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FootballSchedule> =
            listGames(params.toBuilder().league(league).build(), requestOptions)

        /** @see listGames */
        @MustBeClosed
        fun listGames(
            league: String,
            params: SportListGamesParams = SportListGamesParams.none(),
        ): HttpResponseFor<FootballSchedule> = listGames(league, params, RequestOptions.none())

        /** @see listGames */
        @MustBeClosed
        fun listGames(
            params: SportListGamesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FootballSchedule>

        /** @see listGames */
        @MustBeClosed
        fun listGames(params: SportListGamesParams): HttpResponseFor<FootballSchedule> =
            listGames(params, RequestOptions.none())

        /** @see listGames */
        @MustBeClosed
        fun listGames(
            league: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FootballSchedule> =
            listGames(league, SportListGamesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /x/sports/{league}/games/{id}`, but is otherwise the
         * same as [SportService.retrieveScoreboard].
         */
        @MustBeClosed
        fun retrieveScoreboard(
            id: String,
            params: SportRetrieveScoreboardParams,
        ): HttpResponseFor<FootballScoreboard> =
            retrieveScoreboard(id, params, RequestOptions.none())

        /** @see retrieveScoreboard */
        @MustBeClosed
        fun retrieveScoreboard(
            id: String,
            params: SportRetrieveScoreboardParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FootballScoreboard> =
            retrieveScoreboard(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveScoreboard */
        @MustBeClosed
        fun retrieveScoreboard(
            params: SportRetrieveScoreboardParams
        ): HttpResponseFor<FootballScoreboard> = retrieveScoreboard(params, RequestOptions.none())

        /** @see retrieveScoreboard */
        @MustBeClosed
        fun retrieveScoreboard(
            params: SportRetrieveScoreboardParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FootballScoreboard>

        /**
         * Returns a raw HTTP response for `get /x/sports/{league}/games/{id}/box-score`, but is
         * otherwise the same as [SportService.retrieveBoxScore].
         */
        @MustBeClosed
        fun retrieveBoxScore(
            id: String,
            params: SportRetrieveBoxScoreParams,
        ): HttpResponseFor<FootballBoxScore> =
            retrieveBoxScore(id, params, RequestOptions.none())

        /** @see retrieveBoxScore */
        @MustBeClosed
        fun retrieveBoxScore(
            id: String,
            params: SportRetrieveBoxScoreParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FootballBoxScore> =
            retrieveBoxScore(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveBoxScore */
        @MustBeClosed
        fun retrieveBoxScore(
            params: SportRetrieveBoxScoreParams
        ): HttpResponseFor<FootballBoxScore> = retrieveBoxScore(params, RequestOptions.none())

        /** @see retrieveBoxScore */
        @MustBeClosed
        fun retrieveBoxScore(
            params: SportRetrieveBoxScoreParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FootballBoxScore>

        /**
         * Returns a raw HTTP response for `get /x/sports/{league}/games/{id}/plays`, but is
         * otherwise the same as [SportService.retrievePlays].
         */
        @MustBeClosed
        fun retrievePlays(
            id: String,
            params: SportRetrievePlaysParams,
        ): HttpResponseFor<FootballPlays> =
            retrievePlays(id, params, RequestOptions.none())

        /** @see retrievePlays */
        @MustBeClosed
        fun retrievePlays(
            id: String,
            params: SportRetrievePlaysParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FootballPlays> =
            retrievePlays(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrievePlays */
        @MustBeClosed
        fun retrievePlays(params: SportRetrievePlaysParams): HttpResponseFor<FootballPlays> =
            retrievePlays(params, RequestOptions.none())

        /** @see retrievePlays */
        @MustBeClosed
        fun retrievePlays(
            params: SportRetrievePlaysParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FootballPlays>

        /**
         * Returns a raw HTTP response for `get /x/sports/{league}/games/{id}/audience`, but is
         * otherwise the same as [SportService.retrieveAudience].
         */
        @MustBeClosed
        fun retrieveAudience(
            id: String,
            params: SportRetrieveAudienceParams,
        ): HttpResponseFor<SportsGameAudience> =
            retrieveAudience(id, params, RequestOptions.none())

        /** @see retrieveAudience */
        @MustBeClosed
        fun retrieveAudience(
            id: String,
            params: SportRetrieveAudienceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SportsGameAudience> =
            retrieveAudience(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveAudience */
        @MustBeClosed
        fun retrieveAudience(
            params: SportRetrieveAudienceParams
        ): HttpResponseFor<SportsGameAudience> = retrieveAudience(params, RequestOptions.none())

        /** @see retrieveAudience */
        @MustBeClosed
        fun retrieveAudience(
            params: SportRetrieveAudienceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SportsGameAudience>

        /**
         * Returns a raw HTTP response for `get /x/sports/{league}/games/{id}/roster`, but is
         * otherwise the same as [SportService.retrieveRoster].
         */
        @MustBeClosed
        fun retrieveRoster(
            id: String,
            params: SportRetrieveRosterParams,
        ): HttpResponseFor<FootballRoster> =
            retrieveRoster(id, params, RequestOptions.none())

        /** @see retrieveRoster */
        @MustBeClosed
        fun retrieveRoster(
            id: String,
            params: SportRetrieveRosterParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FootballRoster> =
            retrieveRoster(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieveRoster */
        @MustBeClosed
        fun retrieveRoster(
            params: SportRetrieveRosterParams
        ): HttpResponseFor<FootballRoster> = retrieveRoster(params, RequestOptions.none())

        /** @see retrieveRoster */
        @MustBeClosed
        fun retrieveRoster(
            params: SportRetrieveRosterParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FootballRoster>

        /**
         * Returns a raw HTTP response for `get /x/sports/{league}/games/{id}/player-props`, but is
         * otherwise the same as [SportService.retrievePlayerProps].
         */
        @MustBeClosed
        fun retrievePlayerProps(
            id: String,
            params: SportRetrievePlayerPropsParams,
        ): HttpResponseFor<FootballProps> =
            retrievePlayerProps(id, params, RequestOptions.none())

        /** @see retrievePlayerProps */
        @MustBeClosed
        fun retrievePlayerProps(
            id: String,
            params: SportRetrievePlayerPropsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FootballProps> =
            retrievePlayerProps(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrievePlayerProps */
        @MustBeClosed
        fun retrievePlayerProps(
            params: SportRetrievePlayerPropsParams
        ): HttpResponseFor<FootballProps> = retrievePlayerProps(params, RequestOptions.none())

        /** @see retrievePlayerProps */
        @MustBeClosed
        fun retrievePlayerProps(
            params: SportRetrievePlayerPropsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FootballProps>

        /**
         * Returns a raw HTTP response for `get /x/sports/{league}/games/{id}/posts`, but is
         * otherwise the same as [SportService.listPosts].
         */
        @MustBeClosed
        fun listPosts(
            id: String,
            params: SportListPostsParams,
        ): HttpResponseFor<SportsGamePosts> =
            listPosts(id, params, RequestOptions.none())

        /** @see listPosts */
        @MustBeClosed
        fun listPosts(
            id: String,
            params: SportListPostsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SportsGamePosts> =
            listPosts(params.toBuilder().id(id).build(), requestOptions)

        /** @see listPosts */
        @MustBeClosed
        fun listPosts(
            params: SportListPostsParams
        ): HttpResponseFor<SportsGamePosts> = listPosts(params, RequestOptions.none())

        /** @see listPosts */
        @MustBeClosed
        fun listPosts(
            params: SportListPostsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SportsGamePosts>
    }
}
