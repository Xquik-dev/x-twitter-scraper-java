// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.dm.DmRetrieveHistoryParams
import com.x_twitter_scraper.api.models.x.dm.DmSendParams
import org.junit.jupiter.api.Test

internal class DmServiceAsyncTest {
    @Test
    fun retrieveHistory() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val dmServiceAsync = client.x().dm()

        val responseFuture =
            dmServiceAsync.retrieveHistory(
                DmRetrieveHistoryParams.builder()
                    .userId("userId")
                    .account("account")
                    .cursor("cursor")
                    .maxId("maxId")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun send() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val dmServiceAsync = client.x().dm()

        val responseFuture =
            dmServiceAsync.send(
                DmSendParams.builder()
                    .userId("userId")
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .text("Example text content")
                    .addMediaId("1234567890123456789")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
