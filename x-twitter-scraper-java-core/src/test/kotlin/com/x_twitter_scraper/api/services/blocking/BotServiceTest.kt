// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.bot.BotTrackUsageParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class BotServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun trackUsage() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val botService = client.bot()

        val response =
            botService.trackUsage(
                BotTrackUsageParams.builder()
                    .inputTokens(0L)
                    .outputTokens(0L)
                    .platformUserId("platformUserId")
                    .build()
            )

        response.validate()
    }
}
