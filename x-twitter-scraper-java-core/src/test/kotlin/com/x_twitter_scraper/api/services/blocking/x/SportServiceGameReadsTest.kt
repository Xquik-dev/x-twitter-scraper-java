// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

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
import com.x_twitter_scraper.api.models.x.sports.FootballProps
import com.x_twitter_scraper.api.models.x.sports.FootballRoster
import com.x_twitter_scraper.api.models.x.sports.SportListPostsParams
import com.x_twitter_scraper.api.models.x.sports.SportRetrievePlayerPropsParams
import com.x_twitter_scraper.api.models.x.sports.SportRetrieveRosterParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class SportServiceGameReadsTest {

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
    fun retrieveRosterReadsBothTeamsPlayers() {
        val path = "/x/sports/nfl/games/2055084502741811200/roster"
        stubFor(get(urlPathEqualTo(path)).willReturn(okJson(rosterExample)))
        val params = SportRetrieveRosterParams.builder().league("nfl").omit("teams").build()

        val response = client.x().sports().retrieveRoster("2055084502741811200", params)
        val asyncResponse =
            asyncClient.x().sports().retrieveRoster("2055084502741811200", params).get()
        val rawResponse =
            client
                .x()
                .sports()
                .withRawResponse()
                .retrieveRoster("2055084502741811200", params)
                .use { it.parse() }

        verify(3, getRequestedFor(urlPathEqualTo(path)).withQueryParam("omit", equalTo("teams")))
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(rawResponse).isEqualTo(response)
        assertThat(response.league()).isEqualTo(FootballRoster.League.NFL)
        assertThat(response.rosters()[0].teamId()).isEqualTo("689566294702555136")
        assertThat(response.rosters()[0].playerIds()).containsExactly("1520565710329499648")
        val player = response.players().getValue("1520565710329499648")
        assertThat(player.name()).contains("Brock Purdy")
        assertThat(player.headshots().small()).isEmpty()
        assertThat(player.xUser()).isEmpty()
    }

    @Test
    fun retrievePlayerPropsReadsLinesAndOdds() {
        val path = "/x/sports/nfl/games/2055084502741929984/player-props"
        stubFor(get(urlPathEqualTo(path)).willReturn(okJson(playerPropsExample)))
        val params =
            SportRetrievePlayerPropsParams.builder().league("nfl").fields("categories").build()

        val response = client.x().sports().retrievePlayerProps("2055084502741929984", params)
        val asyncResponse =
            asyncClient.x().sports().retrievePlayerProps("2055084502741929984", params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo(path)).withQueryParam("fields", equalTo("categories")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.league()).isEqualTo(FootballProps.League.NFL)
        assertThat(response.sportsbookUrl()).isEmpty()
        val category = response.categories()[0]
        assertThat(category.key()).contains("passing_yards")
        assertThat(category.props()[0].line()).contains(248.5)
        assertThat(category.props()[0].odds()).contains(-115.0)
        assertThat(category.props()[0].alternateOdds()).contains(-105.0)
        assertThat(category.props()[0].openForBetting()).contains(true)
    }

    @Test
    fun listPostsSendsTheOrderAndCursorAndReturnsTheGameSearch() {
        val path = "/x/sports/ncaafb/games/2055084502741811200/posts"
        stubFor(get(urlPathEqualTo(path)).willReturn(okJson(gamePostsExample)))
        val params =
            SportListPostsParams.builder()
                .league("ncaafb")
                .queryType(SportListPostsParams.QueryType.LATEST)
                .cursor("DAACCgACHVOxUHMAJxAK")
                .pageSize(40L)
                .build()

        val response = client.x().sports().listPosts("2055084502741811200", params)
        val asyncResponse = asyncClient.x().sports().listPosts("2055084502741811200", params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo(path))
                .withQueryParam("queryType", equalTo("Latest"))
                .withQueryParam("cursor", equalTo("DAACCgACHVOxUHMAJxAK"))
                .withQueryParam("pageSize", equalTo("40")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.query())
            .contains(
                "(#WASvsSF OR @49ers OR @Commanders) since_time:1792455300 until_time:1792541700"
            )
        assertThat(response.tweets().map { it.id() }).containsExactly("2102761519985332442")
        assertThat(response.hasNextPage()).isTrue()
        assertThat(response.nextCursor()).isEqualTo("DAACCgACHVOxUHMAJxAL")
    }

    companion object {

        private val rosterExample =
            """
            {
              "id": "2055084502741811200",
              "league": "nfl",
              "rosters": [
                {"teamId": "689566294702555136", "playerIds": ["1520565710329499648"]}
              ],
              "teams": {},
              "players": {
                "1520565710329499648": {
                  "id": "1520565710329499648",
                  "teamId": "689566294702555136",
                  "name": "Brock Purdy",
                  "shortName": "B. Purdy",
                  "jersey": "13",
                  "position": "QB",
                  "college": "Iowa State",
                  "birthPlace": null,
                  "birthDate": null,
                  "headshots": {"original": null, "large": null, "medium": null, "small": null},
                  "xUser": null
                }
              }
            }
            """
                .trimIndent()

        private val playerPropsExample =
            """
            {
              "id": "2055084502741929984",
              "league": "nfl",
              "sportsbookUrl": null,
              "categories": [
                {
                  "key": "passing_yards",
                  "name": "Passing Yards",
                  "rank": 1,
                  "props": [
                    {
                      "playerId": "1783744053755990016",
                      "rank": 1,
                      "line": 248.5,
                      "odds": -115,
                      "alternateOdds": -105,
                      "openForBetting": true
                    }
                  ]
                }
              ],
              "players": {}
            }
            """
                .trimIndent()

        private val gamePostsExample =
            """
            {
              "tweets": [
                {
                  "id": "2102761519985332442",
                  "text": "This galaxy is a little extra.",
                  "retweetCount": 1364,
                  "replyCount": 271,
                  "likeCount": 9775,
                  "quoteCount": 85,
                  "viewCount": 962488,
                  "bookmarkCount": 599
                }
              ],
              "has_next_page": true,
              "next_cursor": "DAACCgACHVOxUHMAJxAL",
              "query": "(#WASvsSF OR @49ers OR @Commanders) since_time:1792455300 until_time:1792541700"
            }
            """
                .trimIndent()
    }
}
