// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.monitors

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordCreateParams
import com.x_twitter_scraper.api.models.monitors.keywords.KeywordUpdateParams
import org.junit.jupiter.api.Test

internal class KeywordServiceTest {
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val keywordService = client.monitors().keywords()

        val keyword =
            keywordService.create(
                KeywordCreateParams.builder()
                    .addEventType(EventType.TWEET_NEW)
                    .query("xquik OR \"x api\"")
                    .build()
            )

        kotlin.test.assertNotNull(keyword)
    }

    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val keywordService = client.monitors().keywords()

        val keyword = keywordService.retrieve("id")

        kotlin.test.assertNotNull(keyword)
    }

    @Test
    fun update() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val keywordService = client.monitors().keywords()

        val keyword =
            keywordService.update(
                KeywordUpdateParams.builder()
                    .id("id")
                    .addEventType(EventType.TWEET_NEW)
                    .isActive(true)
                    .build()
            )

        kotlin.test.assertNotNull(keyword)
    }

    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val keywordService = client.monitors().keywords()

        val keywords = keywordService.list()

        kotlin.test.assertNotNull(keywords)
    }

    @Test
    fun deactivate() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val keywordService = client.monitors().keywords()

        val response = keywordService.deactivate("id")

        kotlin.test.assertNotNull(response)
    }
}
