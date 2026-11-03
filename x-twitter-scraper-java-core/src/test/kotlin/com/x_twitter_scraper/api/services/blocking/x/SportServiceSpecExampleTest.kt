// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.github.tomakehurst.wiremock.client.WireMock.absent
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.XTwitterScraperClient
import com.x_twitter_scraper.api.client.XTwitterScraperClientAsync
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.sports.FootballBoxScore
import com.x_twitter_scraper.api.models.x.sports.FootballPlays
import com.x_twitter_scraper.api.models.x.sports.FootballSchedule
import com.x_twitter_scraper.api.models.x.sports.FootballScoreboard
import com.x_twitter_scraper.api.models.x.sports.SportListGamesParams
import com.x_twitter_scraper.api.models.x.sports.SportRetrieveAudienceParams
import com.x_twitter_scraper.api.models.x.sports.SportRetrieveBoxScoreParams
import com.x_twitter_scraper.api.models.x.sports.SportRetrievePlaysParams
import com.x_twitter_scraper.api.models.x.sports.SportRetrieveScoreboardParams
import com.x_twitter_scraper.api.models.x.sports.SportsGameAudience
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class SportServiceSpecExampleTest {

    private lateinit var client: XTwitterScraperClient
    private lateinit var asyncClient: XTwitterScraperClientAsync

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .responseValidation(true)
                .build()
        asyncClient =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .responseValidation(true)
                .build()
    }

    @Test
    fun listGamesParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/sports/nfl/games")).willReturn(okJson(listFootballGamesExample))
        )
        val params =
            SportListGamesParams.builder()
                .from("2026-10-01")
                .to("2026-10-08")
                .team("689566294702555136")
                .fields("games.id,games.home")
                .omit("teams")
                .build()

        val response = client.x().sports().listGames("nfl", params)
        val asyncResponse = asyncClient.x().sports().listGames("nfl", params).get()
        val rawResponse =
            client
                .x()
                .sports()
                .withRawResponse()
                .listGames(params.toBuilder().league("nfl").build())
                .use { it.parse() }

        verify(
            3,
            getRequestedFor(urlPathEqualTo("/x/sports/nfl/games"))
                .withQueryParam("from", equalTo("2026-10-01"))
                .withQueryParam("to", equalTo("2026-10-08"))
                .withQueryParam("team", equalTo("689566294702555136"))
                .withQueryParam("fields", equalTo("games.id,games.home"))
                .withQueryParam("omit", equalTo("teams")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(rawResponse).isEqualTo(response)
        assertThat(response.league()).isEqualTo(FootballSchedule.League.NFL)
        assertThat(response.games()).hasSize(1)
        val game = response.games()[0]
        assertThat(game.id()).isEqualTo("2055084502741811200")
        assertThat(game.seasonType()).contains("RegularSeason")
        assertThat(game.week()).contains(6L)
        assertThat(game.startsAt()).contains(OffsetDateTime.parse("2026-10-20T00:15:00.000Z"))
        assertThat(game.status()).contains("Closed")
        assertThat(game.quarter()).contains(4L)
        assertThat(game.home().teamId()).contains("689566294702555136")
        assertThat(game.home().points()).contains(23L)
        assertThat(game.teamIds()).containsExactly("689566294702555136", "689566304366292992")
        val team = response.teams().getValue("689566294702555136")
        assertThat(team.name()).contains("San Francisco 49ers")
        assertThat(team.abbreviation()).contains("SF")
        assertThat(team.xUserId()).contains("43403778")
        assertThat(team.record().get().wins()).contains(7L)
        assertThat(team.record().get().losses()).contains(1L)
        assertThat(team.record().get().ties()).contains(0L)
    }

    @Test
    fun listGamesWithoutParamsSendsNoQuery() {
        stubFor(
            get(urlPathEqualTo("/x/sports/ncaafb/games"))
                .willReturn(okJson(listFootballGamesExample))
        )

        client.x().sports().listGames("ncaafb")
        asyncClient.x().sports().listGames("ncaafb").get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/sports/ncaafb/games"))
                .withQueryParam("from", absent())
                .withQueryParam("to", absent())
                .withQueryParam("team", absent()),
        )
    }

    @Test
    fun retrieveScoreboardParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/sports/nfl/games/2055084502741811200"))
                .willReturn(okJson(getFootballScoreboardExample))
        )
        val params = SportRetrieveScoreboardParams.builder().league("nfl").build()

        val response = client.x().sports().retrieveScoreboard("2055084502741811200", params)
        val asyncResponse =
            asyncClient.x().sports().retrieveScoreboard("2055084502741811200", params).get()

        verify(2, getRequestedFor(urlPathEqualTo("/x/sports/nfl/games/2055084502741811200")))
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.id()).isEqualTo("2055084502741811200")
        assertThat(response.league()).isEqualTo(FootballScoreboard.League.NFL)
        assertThat(response.seasonId()).contains("2039131233582546945")
        assertThat(response.venue()).contains("Levi's Stadium")
        assertThat(response.status()).contains("Closed")
        assertThat(response.clock()).contains("00:00:00")
        assertThat(response.quarter()).contains(4L)
        assertThat(response.situation().get().down()).contains(3L)
        assertThat(response.situation().get().yardsToGo()).contains(22L)
        assertThat(response.situation().get().possessionTeamId()).contains("689566304366292992")
        assertThat(response.home().teamId()).contains("689566294702555136")
        assertThat(response.periods()).hasSize(1)
        assertThat(response.teams()).containsOnlyKeys("689566294702555136")
        val player = response.players().getValue("1520565710329499648")
        assertThat(player.name()).contains("Brock Purdy")
        assertThat(player.position()).contains("QB")
        assertThat(player.xUser().get().username()).contains("brockpurdy13")
    }

    @Test
    fun retrieveBoxScoreParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/sports/nfl/games/2055084502741811200/box-score"))
                .willReturn(okJson(getFootballBoxScoreExample))
        )
        val params =
            SportRetrieveBoxScoreParams.builder()
                .league("nfl")
                .id("2055084502741811200")
                .fields("home,away")
                .omit("players")
                .build()

        val response = client.x().sports().retrieveBoxScore(params)
        val asyncResponse = asyncClient.x().sports().retrieveBoxScore(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/sports/nfl/games/2055084502741811200/box-score"))
                .withQueryParam("fields", equalTo("home,away"))
                .withQueryParam("omit", equalTo("players")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.id()).isEqualTo("2055084502741811200")
        assertThat(response.league()).isEqualTo(FootballBoxScore.League.NFL)
        assertThat(response.home().teamId()).contains("689566294702555136")
        assertThat(response.home().totals()).isPresent()
        assertThat(response.home().players()).hasSize(1)
        assertThat(response.away().teamId()).contains("689566294702555136")
        assertThat(response.teams()).containsOnlyKeys("689566294702555136")
        assertThat(response.players()).containsOnlyKeys("1520565710329499648")
    }

    @Test
    fun retrievePlaysParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/sports/nfl/games/2055084502741811200/plays"))
                .willReturn(okJson(getFootballPlaysExample))
        )
        val params = SportRetrievePlaysParams.builder().league("nfl").build()

        val response = client.x().sports().retrievePlays("2055084502741811200", params)
        val asyncResponse =
            asyncClient.x().sports().retrievePlays("2055084502741811200", params).get()

        verify(2, getRequestedFor(urlPathEqualTo("/x/sports/nfl/games/2055084502741811200/plays")))
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.id()).isEqualTo("2055084502741811200")
        assertThat(response.league()).isEqualTo(FootballPlays.League.NFL)
        assertThat(response.homeTeamId()).contains("689566294702555136")
        assertThat(response.awayTeamId()).contains("689566304366292992")
        assertThat(response.quarters()).hasSize(1)
        val quarter = response.quarters()[0]
        assertThat(quarter.id()).contains("quarter-1")
        assertThat(quarter.number()).contains(1L)
        assertThat(quarter.drives()).hasSize(1)
        val drive = quarter.drives()[0]
        assertThat(drive.id()).contains("drive-2")
        assertThat(drive.offense()).contains("Home")
        assertThat(drive.plays()).hasSize(1)
        val play = drive.plays()[0]
        assertThat(play.id()).contains("170")
        assertThat(play.clock()).contains("00:10:58")
        assertThat(play.type()).contains("Pass")
        assertThat(play.description())
            .contains("(10:58) B.Purdy pass short left to G.Kittle for 11 yards, TOUCHDOWN.")
    }

    @Test
    fun retrieveAudienceParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/sports/nfl/games/2055084502741811200/audience"))
                .willReturn(okJson(getSportsGameAudienceExample))
        )
        val params = SportRetrieveAudienceParams.builder().league("nfl").build()

        val response = client.x().sports().retrieveAudience("2055084502741811200", params)
        val asyncResponse =
            asyncClient.x().sports().retrieveAudience("2055084502741811200", params).get()
        val rawResponse =
            client
                .x()
                .sports()
                .withRawResponse()
                .retrieveAudience("2055084502741811200", params)
                .use { it.parse() }

        verify(
            3,
            getRequestedFor(urlPathEqualTo("/x/sports/nfl/games/2055084502741811200/audience")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(rawResponse).isEqualTo(response)
        assertThat(response.id()).isEqualTo("2055084502741811200")
        assertThat(response.league()).isEqualTo(SportsGameAudience.League.NFL)
        assertThat(response.viewers().get().count()).isEqualTo(155L)
        assertThat(response.viewers().get().asOf())
            .isEqualTo(OffsetDateTime.parse("2026-10-20T06:19:50.000Z"))
        assertThat(response.teamPicks().total()).contains(7976L)
        assertThat(response.teamPicks().teams()).hasSize(2)
        assertThat(response.teamPicks().teams()[0].teamId()).isEqualTo("689566294702555136")
        assertThat(response.teamPicks().teams()[0].count()).contains(4998L)
        assertThat(response.teamPicks().teams()[1].count()).contains(2978L)
        assertThat(response.chat().available()).contains(false)
        assertThat(response.chat().broadcastId()).contains("nfl-2055084502741811200")
        assertThat(response.chat().opensIn().get().hours()).contains(12L)
        assertThat(response.chat().opensIn().get().minutes()).contains(2L)
        assertThat(response.teams().getValue("689566294702555136").record().get().wins())
            .contains(7L)
    }

    companion object {

        private val listFootballGamesExample =
            """
            {
              "league": "nfl",
              "games": [
                {
                  "id": "2055084502741811200",
                  "seasonType": "RegularSeason",
                  "week": 6,
                  "startsAt": "2026-10-20T00:15:00.000Z",
                  "status": "Closed",
                  "clock": "00:00:00",
                  "quarter": 4,
                  "home": {
                    "teamId": "689566294702555136",
                    "points": 23
                  },
                  "away": {
                    "teamId": "689566294702555136",
                    "points": 23
                  },
                  "teamIds": [
                    "689566294702555136",
                    "689566304366292992"
                  ],
                  "periods": [
                    {
                      "type": "Quarter"
                    }
                  ],
                  "odds": {
                    "home": {
                      "moneyLine": "text",
                      "spread": "text",
                      "total": "text"
                    },
                    "away": {
                      "moneyLine": "text",
                      "spread": "text",
                      "total": "text"
                    }
                  }
                }
              ],
              "teams": {
                "689566294702555136": {
                  "id": "689566294702555136",
                  "name": "San Francisco 49ers",
                  "shortName": "49ers",
                  "abbreviation": "SF",
                  "alternateId": "f0e724b0-4cbf-495a-be47-013907608da9",
                  "location": "Virginia Tech",
                  "colors": [
                    {
                      "r": 170,
                      "g": 0,
                      "b": 0
                    }
                  ],
                  "logos": {
                    "default": "https://pbs.twimg.com/semantic_core_img/2094846255792873472/BUi2WqsC?format=png&name=orig",
                    "light": "https://pbs.twimg.com/semantic_core_img/2094841642129739776/YCBRBHV5?format=png&name=orig",
                    "dark": "https://pbs.twimg.com/semantic_core_img/2094848191451598848/82O7RY0H?format=png&name=orig"
                  },
                  "xUserId": "43403778",
                  "record": {
                    "wins": 7,
                    "losses": 1,
                    "ties": 0
                  },
                  "recentGames": []
                }
              }
            }
            """
                .trimIndent()

        private val getFootballScoreboardExample =
            """
            {
              "id": "2055084502741811200",
              "league": "nfl",
              "seasonId": "2039131233582546945",
              "seasonType": "RegularSeason",
              "week": 6,
              "startsAt": "2026-10-20T00:15:00.000Z",
              "venue": "Levi's Stadium",
              "status": "Closed",
              "clock": "00:00:00",
              "quarter": 4,
              "situation": {
                "down": 3,
                "yardsToGo": 22,
                "yardline": 40,
                "yardlineTeamId": "689566294702555136",
                "possessionTeamId": "689566304366292992"
              },
              "home": {
                "teamId": "689566294702555136",
                "points": 23,
                "timeoutsLeft": 2
              },
              "away": {
                "teamId": "689566294702555136",
                "points": 23,
                "timeoutsLeft": 2
              },
              "periods": [
                {
                  "number": 1,
                  "type": "Quarter",
                  "sequence": 1,
                  "homePoints": 13,
                  "awayPoints": 3
                }
              ],
              "lastPlay": {
                "id": "170",
                "sequence": 9,
                "clock": "00:10:58",
                "type": "Pass",
                "direction": "Left",
                "description": "(10:58) B.Purdy pass short left to G.Kittle for 11 yards, TOUCHDOWN.",
                "scoring": true,
                "homePoints": 6,
                "awayPoints": 0,
                "score": {
                  "homePoints": 6,
                  "awayPoints": 0,
                  "points": 6
                },
                "start": {
                  "down": 1,
                  "yardsToGo": 10,
                  "yardline": 11,
                  "yardlineSide": "Away",
                  "possession": "5c218a3b-a013-4037-97b6-603c9502b701"
                },
                "onField": {
                  "calledBack": false,
                  "penaltyOnField": false,
                  "timeout": true,
                  "underReview": false
                },
                "details": [
                  {
                    "sequence": 1,
                    "category": "Pass",
                    "description": "Pass attempt",
                    "direction": null,
                    "yards": null,
                    "players": [
                      {
                        "playerId": "1520565710329499648",
                        "playerRole": "Pass"
                      }
                    ],
                    "penalty": null
                  }
                ],
                "post": {
                  "id": "2112339130483151117",
                  "username": "text"
                },
                "videoPostId": "2112339130483151117",
                "videoReplyPostId": "text"
              },
              "teams": {
                "689566294702555136": {
                  "id": "689566294702555136",
                  "name": "San Francisco 49ers",
                  "shortName": "49ers",
                  "abbreviation": "SF",
                  "alternateId": "f0e724b0-4cbf-495a-be47-013907608da9",
                  "location": "Virginia Tech",
                  "colors": [
                    {
                      "r": 170,
                      "g": 0,
                      "b": 0
                    }
                  ],
                  "logos": {
                    "default": "https://pbs.twimg.com/semantic_core_img/2094846255792873472/BUi2WqsC?format=png&name=orig",
                    "light": "https://pbs.twimg.com/semantic_core_img/2094841642129739776/YCBRBHV5?format=png&name=orig",
                    "dark": "https://pbs.twimg.com/semantic_core_img/2094848191451598848/82O7RY0H?format=png&name=orig"
                  },
                  "xUserId": "43403778",
                  "record": {
                    "wins": 7,
                    "losses": 1,
                    "ties": 0
                  },
                  "recentGames": []
                }
              },
              "players": {
                "1520565710329499648": {
                  "id": "1520565710329499648",
                  "teamId": "689566294702555136",
                  "name": "Brock Purdy",
                  "shortName": "B.Purdy",
                  "jersey": "13",
                  "position": "QB",
                  "college": "Iowa State",
                  "birthPlace": "Gilbert, AZ, USA",
                  "birthDate": "1999-12-27",
                  "headshots": {
                    "original": "https://ton.twimg.com/twitter-assets/sports-product/headshots/nfl/1520565710329499648_large_c96c3d47bd.png",
                    "large": "https://pbs.twimg.com/semantic_core_img/1960525277903106048/qEOJWYP6?format=png&name=orig",
                    "medium": "https://pbs.twimg.com/semantic_core_img/1960514226075602944/OZ6rz5aH?format=png&name=orig",
                    "small": "https://pbs.twimg.com/semantic_core_img/1960202905849405441/OnS0Xdd9?format=png&name=orig"
                  },
                  "xUser": {
                    "id": "723177170382647296",
                    "username": "brockpurdy13",
                    "blueVerified": true,
                    "protected": null,
                    "superFollowEligible": null,
                    "labelType": null
                  }
                }
              }
            }
            """
                .trimIndent()

        private val getFootballBoxScoreExample =
            """
            {
              "id": "2055084502741811200",
              "league": "nfl",
              "home": {
                "teamId": "689566294702555136",
                "totals": {
                  "firstDowns": 20,
                  "thirdDowns": {
                    "attempts": 14,
                    "successes": 7
                  },
                  "fumbles": {
                    "lost": 1,
                    "opponentRecoveryTouchdowns": 0,
                    "ownRecoveryTouchdowns": 0
                  },
                  "passing": {
                    "attempts": 29,
                    "avgYards": 9.10345,
                    "completions": 21,
                    "interceptions": 0,
                    "netYards": 249,
                    "rating": 111.85345,
                    "sackYards": 15,
                    "sacks": 2,
                    "touchdowns": 1,
                    "yards": 264
                  },
                  "penalties": {
                    "count": 11,
                    "yards": 88
                  },
                  "rushing": {
                    "attempts": 5,
                    "avgYards": 5.6,
                    "longest": 11,
                    "touchdowns": 0,
                    "yards": 28
                  },
                  "timeOfPossessionSeconds": 1785,
                  "totalYards": 375,
                  "turnovers": 1
                },
                "players": [
                  {
                    "playerId": "1520565710329499648",
                    "passing": {
                      "attempts": 29,
                      "avgYards": 9.10345,
                      "completions": 21,
                      "interceptions": 0,
                      "netYards": 249,
                      "rating": 111.85345,
                      "sackYards": 15,
                      "sacks": 2,
                      "touchdowns": 1,
                      "yards": 264
                    },
                    "rushing": {
                      "attempts": 5,
                      "avgYards": 5.6,
                      "longest": 11,
                      "touchdowns": 0,
                      "yards": 28
                    },
                    "receiving": {
                      "avgYards": 3,
                      "longest": 3,
                      "receptions": 1,
                      "targets": 1,
                      "touchdowns": 0,
                      "yards": 3
                    },
                    "defense": {
                      "combined": 8,
                      "forcedFumbles": 0,
                      "interceptions": 0,
                      "passesDefended": 0,
                      "sacks": 0.5,
                      "tackles": 6,
                      "tacklesForLoss": 0
                    },
                    "fumbles": {
                      "lost": 1,
                      "opponentRecoveryTouchdowns": 0,
                      "ownRecoveryTouchdowns": 0
                    },
                    "kickReturns": {
                      "avgYards": 24,
                      "longest": 24,
                      "returns": 1,
                      "touchdowns": 0,
                      "yards": 24
                    },
                    "puntReturns": {
                      "avgYards": 24,
                      "longest": 24,
                      "returns": 1,
                      "touchdowns": 0,
                      "yards": 24
                    },
                    "interceptionReturns": {
                      "avgYards": 24,
                      "longest": 24,
                      "returns": 1,
                      "touchdowns": 0,
                      "yards": 24
                    },
                    "punts": {
                      "attempts": 4,
                      "avgNetYards": 47.8,
                      "avgYards": 47.75,
                      "inside20": 0,
                      "longest": 49,
                      "yards": 191
                    },
                    "fieldGoals": {
                      "attempts": 1,
                      "longest": 33,
                      "made": 1
                    },
                    "extraPoints": {
                      "attempts": 3,
                      "made": 2
                    },
                    "conversions": {
                      "defenseSuccesses": 0,
                      "passSuccesses": 1,
                      "rushSuccesses": 0,
                      "turnoverSuccesses": 0
                    }
                  }
                ]
              },
              "away": {
                "teamId": "689566294702555136",
                "totals": {
                  "firstDowns": 20,
                  "thirdDowns": {
                    "attempts": 14,
                    "successes": 7
                  },
                  "fumbles": {
                    "lost": 1,
                    "opponentRecoveryTouchdowns": 0,
                    "ownRecoveryTouchdowns": 0
                  },
                  "passing": {
                    "attempts": 29,
                    "avgYards": 9.10345,
                    "completions": 21,
                    "interceptions": 0,
                    "netYards": 249,
                    "rating": 111.85345,
                    "sackYards": 15,
                    "sacks": 2,
                    "touchdowns": 1,
                    "yards": 264
                  },
                  "penalties": {
                    "count": 11,
                    "yards": 88
                  },
                  "rushing": {
                    "attempts": 5,
                    "avgYards": 5.6,
                    "longest": 11,
                    "touchdowns": 0,
                    "yards": 28
                  },
                  "timeOfPossessionSeconds": 1785,
                  "totalYards": 375,
                  "turnovers": 1
                },
                "players": [
                  {
                    "playerId": "1520565710329499648",
                    "passing": {
                      "attempts": 29,
                      "avgYards": 9.10345,
                      "completions": 21,
                      "interceptions": 0,
                      "netYards": 249,
                      "rating": 111.85345,
                      "sackYards": 15,
                      "sacks": 2,
                      "touchdowns": 1,
                      "yards": 264
                    },
                    "rushing": {
                      "attempts": 5,
                      "avgYards": 5.6,
                      "longest": 11,
                      "touchdowns": 0,
                      "yards": 28
                    },
                    "receiving": {
                      "avgYards": 3,
                      "longest": 3,
                      "receptions": 1,
                      "targets": 1,
                      "touchdowns": 0,
                      "yards": 3
                    },
                    "defense": {
                      "combined": 8,
                      "forcedFumbles": 0,
                      "interceptions": 0,
                      "passesDefended": 0,
                      "sacks": 0.5,
                      "tackles": 6,
                      "tacklesForLoss": 0
                    },
                    "fumbles": {
                      "lost": 1,
                      "opponentRecoveryTouchdowns": 0,
                      "ownRecoveryTouchdowns": 0
                    },
                    "kickReturns": {
                      "avgYards": 24,
                      "longest": 24,
                      "returns": 1,
                      "touchdowns": 0,
                      "yards": 24
                    },
                    "puntReturns": {
                      "avgYards": 24,
                      "longest": 24,
                      "returns": 1,
                      "touchdowns": 0,
                      "yards": 24
                    },
                    "interceptionReturns": {
                      "avgYards": 24,
                      "longest": 24,
                      "returns": 1,
                      "touchdowns": 0,
                      "yards": 24
                    },
                    "punts": {
                      "attempts": 4,
                      "avgNetYards": 47.8,
                      "avgYards": 47.75,
                      "inside20": 0,
                      "longest": 49,
                      "yards": 191
                    },
                    "fieldGoals": {
                      "attempts": 1,
                      "longest": 33,
                      "made": 1
                    },
                    "extraPoints": {
                      "attempts": 3,
                      "made": 2
                    },
                    "conversions": {
                      "defenseSuccesses": 0,
                      "passSuccesses": 1,
                      "rushSuccesses": 0,
                      "turnoverSuccesses": 0
                    }
                  }
                ]
              },
              "teams": {
                "689566294702555136": {
                  "id": "689566294702555136",
                  "name": "San Francisco 49ers",
                  "shortName": "49ers",
                  "abbreviation": "SF",
                  "alternateId": "f0e724b0-4cbf-495a-be47-013907608da9",
                  "location": "Virginia Tech",
                  "colors": [
                    {
                      "r": 170,
                      "g": 0,
                      "b": 0
                    }
                  ],
                  "logos": {
                    "default": "https://pbs.twimg.com/semantic_core_img/2094846255792873472/BUi2WqsC?format=png&name=orig",
                    "light": "https://pbs.twimg.com/semantic_core_img/2094841642129739776/YCBRBHV5?format=png&name=orig",
                    "dark": "https://pbs.twimg.com/semantic_core_img/2094848191451598848/82O7RY0H?format=png&name=orig"
                  },
                  "xUserId": "43403778",
                  "record": {
                    "wins": 7,
                    "losses": 1,
                    "ties": 0
                  },
                  "recentGames": []
                }
              },
              "players": {
                "1520565710329499648": {
                  "id": "1520565710329499648",
                  "teamId": "689566294702555136",
                  "name": "Brock Purdy",
                  "shortName": "B.Purdy",
                  "jersey": "13",
                  "position": "QB",
                  "college": "Iowa State",
                  "birthPlace": "Gilbert, AZ, USA",
                  "birthDate": "1999-12-27",
                  "headshots": {
                    "original": "https://ton.twimg.com/twitter-assets/sports-product/headshots/nfl/1520565710329499648_large_c96c3d47bd.png",
                    "large": "https://pbs.twimg.com/semantic_core_img/1960525277903106048/qEOJWYP6?format=png&name=orig",
                    "medium": "https://pbs.twimg.com/semantic_core_img/1960514226075602944/OZ6rz5aH?format=png&name=orig",
                    "small": "https://pbs.twimg.com/semantic_core_img/1960202905849405441/OnS0Xdd9?format=png&name=orig"
                  },
                  "xUser": {
                    "id": "723177170382647296",
                    "username": "brockpurdy13",
                    "blueVerified": true,
                    "protected": null,
                    "superFollowEligible": null,
                    "labelType": null
                  }
                }
              }
            }
            """
                .trimIndent()

        private val getFootballPlaysExample =
            """
            {
              "id": "2055084502741811200",
              "league": "nfl",
              "homeTeamId": "689566294702555136",
              "awayTeamId": "689566304366292992",
              "quarters": [
                {
                  "id": "quarter-1",
                  "number": 1,
                  "sequence": 1,
                  "drives": [
                    {
                      "id": "drive-2",
                      "sequence": 2,
                      "offense": "Home",
                      "defense": "Away",
                      "startClock": "00:14:55",
                      "endClock": "00:10:53",
                      "startReason": "Kickoff",
                      "endReason": "Touchdown",
                      "playCount": 10,
                      "firstDowns": 0,
                      "netYards": 64,
                      "scoring": true,
                      "plays": [
                        {
                          "id": "170",
                          "sequence": 9,
                          "clock": "00:10:58",
                          "type": "Pass",
                          "direction": "Left",
                          "description": "(10:58) B.Purdy pass short left to G.Kittle for 11 yards, TOUCHDOWN.",
                          "scoring": true,
                          "homePoints": 6,
                          "awayPoints": 0,
                          "score": {
                            "homePoints": 6,
                            "awayPoints": 0,
                            "points": 6
                          },
                          "start": {
                            "down": 1,
                            "yardsToGo": 10,
                            "yardline": 11,
                            "yardlineSide": "Away",
                            "possession": "5c218a3b-a013-4037-97b6-603c9502b701"
                          },
                          "onField": {
                            "calledBack": false,
                            "penaltyOnField": false,
                            "timeout": true,
                            "underReview": false
                          },
                          "details": [
                            {
                              "sequence": 1,
                              "category": "Pass",
                              "description": "Pass attempt",
                              "direction": null,
                              "yards": null,
                              "players": [
                                {
                                  "playerId": "1520565710329499648",
                                  "playerRole": "Pass"
                                }
                              ],
                              "penalty": null
                            }
                          ],
                          "post": {
                            "id": "2112339130483151117",
                            "username": "text"
                          },
                          "videoPostId": "2112339130483151117",
                          "videoReplyPostId": "text"
                        }
                      ]
                    }
                  ]
                }
              ],
              "teams": {
                "689566294702555136": {
                  "id": "689566294702555136",
                  "name": "San Francisco 49ers",
                  "shortName": "49ers",
                  "abbreviation": "SF",
                  "alternateId": "f0e724b0-4cbf-495a-be47-013907608da9",
                  "location": "Virginia Tech",
                  "colors": [
                    {
                      "r": 170,
                      "g": 0,
                      "b": 0
                    }
                  ],
                  "logos": {
                    "default": "https://pbs.twimg.com/semantic_core_img/2094846255792873472/BUi2WqsC?format=png&name=orig",
                    "light": "https://pbs.twimg.com/semantic_core_img/2094841642129739776/YCBRBHV5?format=png&name=orig",
                    "dark": "https://pbs.twimg.com/semantic_core_img/2094848191451598848/82O7RY0H?format=png&name=orig"
                  },
                  "xUserId": "43403778",
                  "record": {
                    "wins": 7,
                    "losses": 1,
                    "ties": 0
                  },
                  "recentGames": []
                }
              },
              "players": {
                "1520565710329499648": {
                  "id": "1520565710329499648",
                  "teamId": "689566294702555136",
                  "name": "Brock Purdy",
                  "shortName": "B.Purdy",
                  "jersey": "13",
                  "position": "QB",
                  "college": "Iowa State",
                  "birthPlace": "Gilbert, AZ, USA",
                  "birthDate": "1999-12-27",
                  "headshots": {
                    "original": "https://ton.twimg.com/twitter-assets/sports-product/headshots/nfl/1520565710329499648_large_c96c3d47bd.png",
                    "large": "https://pbs.twimg.com/semantic_core_img/1960525277903106048/qEOJWYP6?format=png&name=orig",
                    "medium": "https://pbs.twimg.com/semantic_core_img/1960514226075602944/OZ6rz5aH?format=png&name=orig",
                    "small": "https://pbs.twimg.com/semantic_core_img/1960202905849405441/OnS0Xdd9?format=png&name=orig"
                  },
                  "xUser": {
                    "id": "723177170382647296",
                    "username": "brockpurdy13",
                    "blueVerified": true,
                    "protected": null,
                    "superFollowEligible": null,
                    "labelType": null
                  }
                }
              }
            }
            """
                .trimIndent()

        private val getSportsGameAudienceExample =
            """
            {
              "id": "2055084502741811200",
              "league": "nfl",
              "viewers": {
                "count": 155,
                "asOf": "2026-10-20T06:19:50.000Z"
              },
              "teamPicks": {
                "total": 7976,
                "teams": [
                  {
                    "teamId": "689566294702555136",
                    "count": 4998
                  },
                  {
                    "teamId": "689566304366292992",
                    "count": 2978
                  }
                ]
              },
              "chat": {
                "available": false,
                "broadcastId": "nfl-2055084502741811200",
                "opensIn": {
                  "days": 0,
                  "hours": 12,
                  "minutes": 2
                }
              },
              "teams": {
                "689566294702555136": {
                  "id": "689566294702555136",
                  "name": "San Francisco 49ers",
                  "shortName": "49ers",
                  "abbreviation": "SF",
                  "alternateId": "f0e724b0-4cbf-495a-be47-013907608da9",
                  "location": "Virginia Tech",
                  "colors": [
                    {
                      "r": 170,
                      "g": 0,
                      "b": 0
                    }
                  ],
                  "logos": {
                    "default": "https://pbs.twimg.com/semantic_core_img/2094846255792873472/BUi2WqsC?format=png&name=orig",
                    "light": "https://pbs.twimg.com/semantic_core_img/2094841642129739776/YCBRBHV5?format=png&name=orig",
                    "dark": "https://pbs.twimg.com/semantic_core_img/2094848191451598848/82O7RY0H?format=png&name=orig"
                  },
                  "xUserId": "43403778",
                  "record": {
                    "wins": 7,
                    "losses": 1,
                    "ties": 0
                  },
                  "recentGames": []
                }
              }
            }
            """
                .trimIndent()
    }
}
