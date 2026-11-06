// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x.users

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.users.block.BlockCreateParams
import com.x_twitter_scraper.api.models.x.users.block.BlockDeleteParams
import org.junit.jupiter.api.Test

internal class BlockServiceAsyncTest {
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val blockServiceAsync = client.x().users().block()

        val blockFuture =
            blockServiceAsync.create(
                BlockCreateParams.builder()
                    .id("id")
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .build()
            )

        val block = blockFuture.get()
        kotlin.test.assertNotNull(block)
    }

    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val blockServiceAsync = client.x().users().block()

        val blockFuture =
            blockServiceAsync.delete(
                BlockDeleteParams.builder()
                    .id("id")
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .build()
            )

        val block = blockFuture.get()
        kotlin.test.assertNotNull(block)
    }
}
