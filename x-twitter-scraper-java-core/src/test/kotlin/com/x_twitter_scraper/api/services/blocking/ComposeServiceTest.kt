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

        compose.validate()
    }
}
