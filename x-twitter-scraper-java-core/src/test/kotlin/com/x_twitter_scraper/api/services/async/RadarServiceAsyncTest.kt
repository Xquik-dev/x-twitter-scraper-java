// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.radar.RadarRetrieveTrendingTopicsParams
import org.junit.jupiter.api.Test

internal class RadarServiceAsyncTest {
    @Test
    fun retrieveTrendingTopics() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val radarServiceAsync = client.radar()

        val responseFuture =
            radarServiceAsync.retrieveTrendingTopics(
                RadarRetrieveTrendingTopicsParams.builder()
                    .after("after")
                    .category(RadarRetrieveTrendingTopicsParams.Category.GENERAL)
                    .hours(1L)
                    .limit(1L)
                    .region("region")
                    .source(RadarRetrieveTrendingTopicsParams.Source.GITHUB)
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
