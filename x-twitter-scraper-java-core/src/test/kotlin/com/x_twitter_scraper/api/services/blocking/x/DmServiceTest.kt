// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.dm.DmDeleteMessageParams
import com.x_twitter_scraper.api.models.x.dm.DmRetrieveHistoryParams
import com.x_twitter_scraper.api.models.x.dm.DmSendParams
import org.junit.jupiter.api.Test

internal class DmServiceTest {
    @Test
    fun deleteMessage() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val dmService = client.x().dm()

        val response =
            dmService.deleteMessage(
                DmDeleteMessageParams.builder()
                    .userId("userId")
                    .messageId("messageId")
                    .account("account")
                    .idempotencyKey("Idempotency-Key")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveHistory() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val dmService = client.x().dm()

        val response =
            dmService.retrieveHistory(
                DmRetrieveHistoryParams.builder()
                    .userId("userId")
                    .account("account")
                    .cursor("cursor")
                    .maxId("maxId")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun send() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val dmService = client.x().dm()

        val response =
            dmService.send(
                DmSendParams.builder()
                    .userId("userId")
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .text("Example text content")
                    .addMediaId("1234567890123456789")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }
}
