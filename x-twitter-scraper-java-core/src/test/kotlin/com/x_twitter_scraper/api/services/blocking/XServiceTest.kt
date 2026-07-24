// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.XGetHomeTimelineParams
import com.x_twitter_scraper.api.models.x.XGetNotificationsParams
import com.x_twitter_scraper.api.models.x.XGetTrendsParams
import org.junit.jupiter.api.Test

internal class XServiceTest {
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
}
