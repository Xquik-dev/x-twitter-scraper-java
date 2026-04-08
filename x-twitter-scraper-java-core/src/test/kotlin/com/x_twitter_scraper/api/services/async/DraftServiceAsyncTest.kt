// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.drafts.DraftCreateParams
import com.x_twitter_scraper.api.models.drafts.DraftListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class DraftServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val draftServiceAsync = client.drafts()

        val draftDetailFuture =
            draftServiceAsync.create(
                DraftCreateParams.builder()
                    .text("AI is the future of productivity")
                    .goal(DraftCreateParams.Goal.ENGAGEMENT)
                    .topic("AI trends")
                    .build()
            )

        val draftDetail = draftDetailFuture.get()
        draftDetail.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val draftServiceAsync = client.drafts()

        val draftDetailFuture = draftServiceAsync.retrieve("id")

        val draftDetail = draftDetailFuture.get()
        draftDetail.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val draftServiceAsync = client.drafts()

        val draftsFuture =
            draftServiceAsync.list(
                DraftListParams.builder().afterCursor("afterCursor").limit(1L).build()
            )

        val drafts = draftsFuture.get()
        drafts.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val draftServiceAsync = client.drafts()

        val future = draftServiceAsync.delete("id")

        val response = future.get()
    }
}
