// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.styles.StyleAnalyzeParams
import com.x_twitter_scraper.api.models.styles.StyleCompareParams
import com.x_twitter_scraper.api.models.styles.StyleUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class StyleServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val styleServiceAsync = client.styles()

        val styleProfileFuture = styleServiceAsync.retrieve("id")

        val styleProfile = styleProfileFuture.get()
        styleProfile.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
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
        styleProfile.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val styleServiceAsync = client.styles()

        val stylesFuture = styleServiceAsync.list()

        val styles = stylesFuture.get()
        styles.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val styleServiceAsync = client.styles()

        val future = styleServiceAsync.delete("id")

        val response = future.get()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun analyze() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val styleServiceAsync = client.styles()

        val styleProfileFuture =
            styleServiceAsync.analyze(StyleAnalyzeParams.builder().username("elonmusk").build())

        val styleProfile = styleProfileFuture.get()
        styleProfile.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun compare() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val styleServiceAsync = client.styles()

        val responseFuture =
            styleServiceAsync.compare(
                StyleCompareParams.builder().username1("username1").username2("username2").build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getPerformance() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val styleServiceAsync = client.styles()

        val responseFuture = styleServiceAsync.getPerformance("id")

        val response = responseFuture.get()
        response.validate()
    }
}
