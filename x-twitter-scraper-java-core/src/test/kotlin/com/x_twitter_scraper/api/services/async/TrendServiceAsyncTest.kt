// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.trends.TrendListParams
import org.junit.jupiter.api.Test

internal class TrendServiceAsyncTest {
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val trendServiceAsync = client.trends()

        val trendsFuture =
            trendServiceAsync.list(TrendListParams.builder().count(1L).woeid(0L).build())

        val trends = trendsFuture.get()
        kotlin.test.assertNotNull(trends)
    }
}
