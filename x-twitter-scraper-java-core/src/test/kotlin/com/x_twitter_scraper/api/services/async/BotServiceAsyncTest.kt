// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.bot.BotTrackUsageParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class BotServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun trackUsage() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val botServiceAsync = client.bot()

        val responseFuture =
            botServiceAsync.trackUsage(
                BotTrackUsageParams.builder()
                    .inputTokens(0L)
                    .outputTokens(0L)
                    .platformUserId("platformUserId")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
