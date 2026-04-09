// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.radar.RadarRetrieveTrendingTopicsParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class RadarServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveTrendingTopics() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val radarService = client.radar()

        val response =
            radarService.retrieveTrendingTopics(
                RadarRetrieveTrendingTopicsParams.builder()
                    .category("category")
                    .count(0L)
                    .hours(0L)
                    .region("region")
                    .source(RadarRetrieveTrendingTopicsParams.Source.GITHUB)
                    .build()
            )

        response.validate()
    }
}
