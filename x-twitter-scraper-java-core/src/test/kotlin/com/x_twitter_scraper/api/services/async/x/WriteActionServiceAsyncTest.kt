// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import org.junit.jupiter.api.Test

internal class WriteActionServiceAsyncTest {
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val writeActionServiceAsync = client.x().writeActions()

        val writeActionFuture = writeActionServiceAsync.retrieve("id")

        val writeAction = writeActionFuture.get()
        kotlin.test.assertNotNull(writeAction)
    }
}
