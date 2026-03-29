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
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleServiceAsync = client.styles()

        val styleFuture = styleServiceAsync.retrieve("username")

        val style = styleFuture.get()
        style.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleServiceAsync = client.styles()

        val styleFuture =
            styleServiceAsync.update(
                StyleUpdateParams.builder()
                    .username("username")
                    .label("label")
                    .addTweet(StyleUpdateParams.Tweet.builder().text("text").build())
                    .build()
            )

        val style = styleFuture.get()
        style.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleServiceAsync = client.styles()

        val stylesFuture = styleServiceAsync.list()

        val styles = stylesFuture.get()
        styles.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleServiceAsync = client.styles()

        val future = styleServiceAsync.delete("username")

        val response = future.get()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun analyze() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleServiceAsync = client.styles()

        val responseFuture =
            styleServiceAsync.analyze(StyleAnalyzeParams.builder().username("username").build())

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun compare() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
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
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleServiceAsync = client.styles()

        val responseFuture = styleServiceAsync.getPerformance("username")

        val response = responseFuture.get()
        response.validate()
    }
}
