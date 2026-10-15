// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.broadcasts.BroadcastRetrieveParams
import org.junit.jupiter.api.Test

internal class BroadcastServiceAsyncTest {
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val broadcastServiceAsync = client.x().broadcasts()

        val broadcastFuture =
            broadcastServiceAsync.retrieve(
                BroadcastRetrieveParams.builder()
                    .id("id")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .build()
            )

        val broadcast = broadcastFuture.get()
        kotlin.test.assertNotNull(broadcast)
    }
}
