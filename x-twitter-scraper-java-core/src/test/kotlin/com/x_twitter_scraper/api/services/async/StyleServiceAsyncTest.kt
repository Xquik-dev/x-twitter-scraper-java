// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.styles.StyleAnalyzeParams
import com.x_twitter_scraper.api.models.styles.StyleCompareParams
import com.x_twitter_scraper.api.models.styles.StyleUpdateParams
import org.junit.jupiter.api.Test

internal class StyleServiceAsyncTest {
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleServiceAsync = client.styles()

        val styleProfileFuture = styleServiceAsync.retrieve("id")

        val styleProfile = styleProfileFuture.get()
        kotlin.test.assertNotNull(styleProfile)
    }

    @Test
    fun update() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleServiceAsync = client.styles()

        val styleProfileFuture =
            styleServiceAsync.update(
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

        val styleProfile = styleProfileFuture.get()
        kotlin.test.assertNotNull(styleProfile)
    }

    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleServiceAsync = client.styles()

        val stylesFuture = styleServiceAsync.list()

        val styles = stylesFuture.get()
        kotlin.test.assertNotNull(styles)
    }

    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleServiceAsync = client.styles()

        val future = styleServiceAsync.delete("id")

        val response = future.get()
    }

    @Test
    fun analyze() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleServiceAsync = client.styles()

        val styleProfileFuture =
            styleServiceAsync.analyze(StyleAnalyzeParams.builder().username("elonmusk").build())

        val styleProfile = styleProfileFuture.get()
        kotlin.test.assertNotNull(styleProfile)
    }

    @Test
    fun compare() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleServiceAsync = client.styles()

        val responseFuture =
            styleServiceAsync.compare(
                StyleCompareParams.builder().username1("username1").username2("username2").build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun getPerformance() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleServiceAsync = client.styles()

        val responseFuture = styleServiceAsync.getPerformance("id")

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
