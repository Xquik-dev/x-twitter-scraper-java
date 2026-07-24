// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.radar.RadarRetrieveTrendingTopicsParams
import org.junit.jupiter.api.Test

internal class RadarServiceTest {
    @Test
    fun retrieveTrendingTopics() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val radarService = client.radar()

        val response =
            radarService.retrieveTrendingTopics(
                RadarRetrieveTrendingTopicsParams.builder()
                    .after("after")
                    .category(RadarRetrieveTrendingTopicsParams.Category.GENERAL)
                    .hours(1L)
                    .limit(1L)
                    .region("region")
                    .source(RadarRetrieveTrendingTopicsParams.Source.GITHUB)
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }
}
