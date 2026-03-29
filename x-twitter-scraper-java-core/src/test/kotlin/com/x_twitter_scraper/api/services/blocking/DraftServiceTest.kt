// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.drafts.DraftCreateParams
import com.x_twitter_scraper.api.models.drafts.DraftListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class DraftServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val draftService = client.drafts()

        val draft =
            draftService.create(
                DraftCreateParams.builder()
                    .text("text")
                    .goal(DraftCreateParams.Goal.ENGAGEMENT)
                    .topic("topic")
                    .build()
            )

        draft.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val draftService = client.drafts()

        val draft = draftService.retrieve("id")

        draft.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val draftService = client.drafts()

        val drafts =
            draftService.list(
                DraftListParams.builder().afterCursor("afterCursor").limit(1L).build()
            )

        drafts.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val draftService = client.drafts()

        draftService.delete("id")
    }
}
