// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.compose.ComposeCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ComposeServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val composeService = client.compose()

        val compose =
            composeService.create(
                ComposeCreateParams.builder()
                    .step(ComposeCreateParams.Step.COMPOSE)
                    .additionalContext("https://x.com/elonmusk/status/1234567890")
                    .callToAction("Follow for more")
                    .draft("AI is changing everything. Here's why.")
                    .goal(ComposeCreateParams.Goal.ENGAGEMENT)
                    .hasLink(false)
                    .hasMedia(false)
                    .mediaType(ComposeCreateParams.MediaType.NONE)
                    .styleUsername("elonmusk")
                    .tone("professional")
                    .topic("AI trends in 2025")
                    .build()
            )

        compose.validate()
    }
}
