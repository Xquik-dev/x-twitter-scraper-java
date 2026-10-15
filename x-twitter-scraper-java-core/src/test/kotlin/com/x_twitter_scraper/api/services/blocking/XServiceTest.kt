// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.XAutocompleteSearchParams
import com.x_twitter_scraper.api.models.x.XGetHashflagsParams
import com.x_twitter_scraper.api.models.x.XGetHomeTimelineParams
import com.x_twitter_scraper.api.models.x.XGetNewsStoryVersionsParams
import com.x_twitter_scraper.api.models.x.XGetNotificationsParams
import com.x_twitter_scraper.api.models.x.XGetTrendLocationsParams
import com.x_twitter_scraper.api.models.x.XGetTrendsHistoryParams
import com.x_twitter_scraper.api.models.x.XGetTrendsParams
import com.x_twitter_scraper.api.models.x.XSearchPlacesParams
import org.junit.jupiter.api.Test

internal class XServiceTest {
    @Test
    fun autocompleteSearch() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val xService = client.x()

        val response =
            xService.autocompleteSearch(
                XAutocompleteSearchParams.builder()
                    .q("nasa")
                    .fields("id,text,author.username")
                    .limit(1L)
                    .omit("entities,media")
                    .types("users,topics")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun getArticle() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val xService = client.x()

        val response = xService.getArticle("tweetId")

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun getHashflags() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val xService = client.x()

        val response =
            xService.getHashflags(
                XGetHashflagsParams.builder()
                    .activeOnly(true)
                    .fields("id,text,author.username")
                    .limit(1L)
                    .omit("entities,media")
                    .q("q")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun getHomeTimeline() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val xService = client.x()

        val paginatedTweets =
            xService.getHomeTimeline(
                XGetHomeTimelineParams.builder()
                    .cursor("cursor")
                    .seenTweetIds("seenTweetIds")
                    .build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun getNewsStoryVersions() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val xService = client.x()

        val response =
            xService.getNewsStoryVersions(
                XGetNewsStoryVersionsParams.builder()
                    .id("id")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun getNotifications() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val xService = client.x()

        val response =
            xService.getNotifications(
                XGetNotificationsParams.builder()
                    .cursor("cursor")
                    .type(XGetNotificationsParams.Type.ALL)
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun getTrendLocations() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val xService = client.x()

        val response =
            xService.getTrendLocations(
                XGetTrendLocationsParams.builder()
                    .country("country")
                    .fields("id,text,author.username")
                    .limit(1L)
                    .omit("entities,media")
                    .placeType(XGetTrendLocationsParams.PlaceType.COUNTRY)
                    .q("q")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun getTrends() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val xService = client.x()

        val response = xService.getTrends(XGetTrendsParams.builder().count(1L).woeid(0L).build())

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun getTrendsHistory() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val xService = client.x()

        val response =
            xService.getTrendsHistory(
                XGetTrendsHistoryParams.builder()
                    .count(1L)
                    .country("country")
                    .cursor("2026-10-14T00:00:00.000Z~1791979200000")
                    .every("1h")
                    .fields("id,text,author.username")
                    .from("2026-10-13")
                    .limit(1L)
                    .location("location")
                    .omit("entities,media")
                    .to("2026-10-14")
                    .woeid(1L)
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun searchPlaces() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val xService = client.x()

        val response =
            xService.searchPlaces(
                XSearchPlacesParams.builder()
                    .q("q")
                    .fields("id,text,author.username")
                    .limit(1L)
                    .omit("entities,media")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }
}
