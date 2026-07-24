// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.compose.ComposeCreateParams
import org.junit.jupiter.api.Test

internal class ComposeServiceAsyncTest {
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val composeServiceAsync = client.compose()

        val composeFuture =
            composeServiceAsync.create(
                ComposeCreateParams.Body.ComposePrepareRequest.builder()
                    .topic("PostgreSQL query planning")
                    .goal(ComposeCreateParams.Body.ComposePrepareRequest.Goal.ENGAGEMENT)
                    .styleUsername("x")
                    .build()
            )

        val compose = composeFuture.get()
        kotlin.test.assertNotNull(compose)
    }
}
