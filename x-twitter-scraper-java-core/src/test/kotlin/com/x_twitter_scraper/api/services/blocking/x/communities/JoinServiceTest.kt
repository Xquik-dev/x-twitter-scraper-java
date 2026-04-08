// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x.communities

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.communities.join.JoinCreateParams
import com.x_twitter_scraper.api.models.x.communities.join.JoinDeleteAllParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class JoinServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val joinService = client.x().communities().join()

        val join =
            joinService.create(JoinCreateParams.builder().id("id").account("@elonmusk").build())

        join.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun deleteAll() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val joinService = client.x().communities().join()

        val response =
            joinService.deleteAll(
                JoinDeleteAllParams.builder().id("id").account("@elonmusk").build()
            )

        response.validate()
    }
}
