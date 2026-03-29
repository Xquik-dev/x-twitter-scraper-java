// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.radar.RadarRetrieveTrendingTopicsParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class RadarServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveTrendingTopics() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val radarServiceAsync = client.radar()

        val responseFuture =
            radarServiceAsync.retrieveTrendingTopics(
                RadarRetrieveTrendingTopicsParams.builder()
                    .category("category")
                    .count(0L)
                    .hours(0L)
                    .region("region")
                    .source("source")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
