// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x.communities

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.communities.join.JoinCreateParams
import com.x_twitter_scraper.api.models.x.communities.join.JoinDeleteAllParams
import org.junit.jupiter.api.Test

internal class JoinServiceTest {
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val joinService = client.x().communities().join()

        val join =
            joinService.create(
                JoinCreateParams.builder()
                    .id("id")
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .build()
            )

        kotlin.test.assertNotNull(join)
    }

    @Test
    fun deleteAll() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val joinService = client.x().communities().join()

        val response =
            joinService.deleteAll(
                JoinDeleteAllParams.builder()
                    .id("id")
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }
}
