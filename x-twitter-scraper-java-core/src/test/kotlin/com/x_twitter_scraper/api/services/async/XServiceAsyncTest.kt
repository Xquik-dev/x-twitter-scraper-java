// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.XGetHomeTimelineParams
import com.x_twitter_scraper.api.models.x.XGetNotificationsParams
import com.x_twitter_scraper.api.models.x.XGetTrendsParams
import org.junit.jupiter.api.Test

internal class XServiceAsyncTest {
    @Test
    fun getArticle() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val xServiceAsync = client.x()

        val responseFuture = xServiceAsync.getArticle("tweetId")

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun getHomeTimeline() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val xServiceAsync = client.x()

        val paginatedTweetsFuture =
            xServiceAsync.getHomeTimeline(
                XGetHomeTimelineParams.builder()
                    .cursor("cursor")
                    .seenTweetIds("seenTweetIds")
                    .build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun getNotifications() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val xServiceAsync = client.x()

        val responseFuture =
            xServiceAsync.getNotifications(
                XGetNotificationsParams.builder()
                    .cursor("cursor")
                    .type(XGetNotificationsParams.Type.ALL)
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun getTrends() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val xServiceAsync = client.x()

        val responseFuture =
            xServiceAsync.getTrends(XGetTrendsParams.builder().count(1L).woeid(0L).build())

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
