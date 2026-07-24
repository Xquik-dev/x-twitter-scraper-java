// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.subscribe.SubscribeCreateParams
import org.junit.jupiter.api.Test

internal class SubscribeServiceTest {
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val subscribeService = client.subscribe()

        val subscribe =
            subscribeService.create(
                SubscribeCreateParams.builder().tier(SubscribeCreateParams.Tier.PRO).build()
            )

        kotlin.test.assertNotNull(subscribe)
    }
}
