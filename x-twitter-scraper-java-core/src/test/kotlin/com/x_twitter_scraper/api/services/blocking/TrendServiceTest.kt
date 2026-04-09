// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.trends.TrendListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TrendServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val trendService = client.trends()

        val trends = trendService.list(TrendListParams.builder().count(1L).woeid(0L).build())

        trends.validate()
    }
}
