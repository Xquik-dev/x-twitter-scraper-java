// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.styles.StyleAnalyzeParams
import com.x_twitter_scraper.api.models.styles.StyleCompareParams
import com.x_twitter_scraper.api.models.styles.StyleUpdateParams
import org.junit.jupiter.api.Test

internal class StyleServiceTest {
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleService = client.styles()

        val styleProfile = styleService.retrieve("id")

        kotlin.test.assertNotNull(styleProfile)
    }

    @Test
    fun update() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleService = client.styles()

        val styleProfile =
            styleService.update(
                StyleUpdateParams.builder()
                    .id("id")
                    .label("Professional Voice")
                    .addTweet(
                        StyleUpdateParams.Tweet.builder()
                            .text("Excited to share our latest research findings.")
                            .build()
                    )
                    .build()
            )

        kotlin.test.assertNotNull(styleProfile)
    }

    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleService = client.styles()

        val styles = styleService.list()

        kotlin.test.assertNotNull(styles)
    }

    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleService = client.styles()

        styleService.delete("id")
    }

    @Test
    fun analyze() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleService = client.styles()

        val styleProfile =
            styleService.analyze(StyleAnalyzeParams.builder().username("elonmusk").build())

        kotlin.test.assertNotNull(styleProfile)
    }

    @Test
    fun compare() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleService = client.styles()

        val response =
            styleService.compare(
                StyleCompareParams.builder().username1("username1").username2("username2").build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun getPerformance() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleService = client.styles()

        val response = styleService.getPerformance("id")

        kotlin.test.assertNotNull(response)
    }
}
