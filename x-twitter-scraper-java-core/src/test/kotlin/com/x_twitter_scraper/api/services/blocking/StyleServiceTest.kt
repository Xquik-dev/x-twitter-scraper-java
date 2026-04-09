// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.styles.StyleAnalyzeParams
import com.x_twitter_scraper.api.models.styles.StyleCompareParams
import com.x_twitter_scraper.api.models.styles.StyleUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class StyleServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val styleService = client.styles()

        val styleProfile = styleService.retrieve("id")

        styleProfile.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
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

        styleProfile.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val styleService = client.styles()

        val styles = styleService.list()

        styles.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val styleService = client.styles()

        styleService.delete("id")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun analyze() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val styleService = client.styles()

        val styleProfile =
            styleService.analyze(StyleAnalyzeParams.builder().username("elonmusk").build())

        styleProfile.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun compare() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val styleService = client.styles()

        val response =
            styleService.compare(
                StyleCompareParams.builder().username1("username1").username2("username2").build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getPerformance() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val styleService = client.styles()

        val response = styleService.getPerformance("id")

        response.validate()
    }
}
