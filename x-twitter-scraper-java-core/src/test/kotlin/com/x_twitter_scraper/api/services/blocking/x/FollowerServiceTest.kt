// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.followers.FollowerCheckParams
import org.junit.jupiter.api.Test

internal class FollowerServiceTest {
    @Test
    fun check() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val followerService = client.x().followers()

        val response =
            followerService.check(
                FollowerCheckParams.builder().source("source").target("target").build()
            )

        kotlin.test.assertNotNull(response)
    }
}
