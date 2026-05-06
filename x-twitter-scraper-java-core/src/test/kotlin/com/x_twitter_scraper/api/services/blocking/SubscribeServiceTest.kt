// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class SubscribeServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val subscribeService = client.subscribe()

        val subscribe = subscribeService.create()

        subscribe.validate()
    }
}
