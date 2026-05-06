// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.compose.ComposeCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ComposeServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val composeServiceAsync = client.compose()

        val composeFuture =
            composeServiceAsync.create(
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

        val compose = composeFuture.get()
        compose.validate()
    }
}
