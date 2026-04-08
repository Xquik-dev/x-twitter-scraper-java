// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.styles.StyleAnalyzeParams
import com.x_twitter_scraper.api.models.styles.StyleCompareParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class StyleServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleService = client.styles()

        val styles = styleService.list()

        styles.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun analyze() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleService = client.styles()

        val response =
            styleService.analyze(StyleAnalyzeParams.builder().username("elonmusk").build())

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun compare() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val styleService = client.styles()

        val response =
            styleService.compare(
                StyleCompareParams.builder().username1("username1").username2("username2").build()
            )

        response.validate()
    }
}
