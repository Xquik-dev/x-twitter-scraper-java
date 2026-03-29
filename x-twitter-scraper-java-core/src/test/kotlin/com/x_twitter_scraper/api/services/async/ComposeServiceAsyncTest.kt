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
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val composeServiceAsync = client.compose()

        val composeFuture =
            composeServiceAsync.create(
                ComposeCreateParams.builder()
                    .step(ComposeCreateParams.Step.COMPOSE)
                    .additionalContext("additionalContext")
                    .callToAction("callToAction")
                    .draft("draft")
                    .goal(ComposeCreateParams.Goal.ENGAGEMENT)
                    .hasLink(true)
                    .hasMedia(true)
                    .mediaType(ComposeCreateParams.MediaType.PHOTO)
                    .styleUsername("styleUsername")
                    .tone("tone")
                    .topic("topic")
                    .build()
            )

        val compose = composeFuture.get()
        compose.validate()
    }
}
