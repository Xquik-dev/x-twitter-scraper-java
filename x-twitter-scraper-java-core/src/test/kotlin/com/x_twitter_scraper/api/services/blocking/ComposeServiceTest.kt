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
                ComposeCreateParams.Body.ComposePrepareRequest.builder()
                    .topic("PostgreSQL query planning")
                    .goal(ComposeCreateParams.Body.ComposePrepareRequest.Goal.ENGAGEMENT)
                    .styleUsername("x")
                    .build()
            )

        compose.validate()
    }
}
