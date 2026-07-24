// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x.communities

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.communities.join.JoinCreateParams
import com.x_twitter_scraper.api.models.x.communities.join.JoinDeleteAllParams
import org.junit.jupiter.api.Test

internal class JoinServiceAsyncTest {
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val joinServiceAsync = client.x().communities().join()

        val joinFuture =
            joinServiceAsync.create(
                JoinCreateParams.builder()
                    .id("id")
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .build()
            )

        val join = joinFuture.get()
        kotlin.test.assertNotNull(join)
    }

    @Test
    fun deleteAll() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val joinServiceAsync = client.x().communities().join()

        val responseFuture =
            joinServiceAsync.deleteAll(
                JoinDeleteAllParams.builder()
                    .id("id")
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
