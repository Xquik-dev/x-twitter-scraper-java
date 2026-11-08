// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.absent
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.XTwitterScraperClient
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.draws.DrawRunParams
import com.x_twitter_scraper.api.models.extractions.ExtractionRunParams
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class RunIdempotencyTest {

    private lateinit var client: XTwitterScraperClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun extractionRunSendsTheIdempotencyKeyOnlyWhenSet() {
        stubFor(post(urlPathEqualTo("/extractions")).willReturn(okJson("{}")))

        listOf("extraction-1", null).forEach { key ->
            client
                .extractions()
                .withRawResponse()
                .run(
                    ExtractionRunParams.builder()
                        .idempotencyKey(key)
                        .toolType(ExtractionRunParams.ToolType.FOLLOWER_EXPLORER)
                        .targetUsername("elonmusk")
                        .build()
                )
                .close()
        }

        verify(
            1,
            postRequestedFor(urlPathEqualTo("/extractions"))
                .withHeader("Idempotency-Key", equalTo("extraction-1")),
        )
        verify(
            1,
            postRequestedFor(urlPathEqualTo("/extractions"))
                .withHeader("Idempotency-Key", absent()),
        )
    }

    @Test
    fun drawRunSendsTheIdempotencyKeyOnlyWhenSet() {
        stubFor(post(urlPathEqualTo("/draws")).willReturn(okJson("{}")))

        listOf("draw-1", null).forEach { key ->
            client
                .draws()
                .withRawResponse()
                .run(
                    DrawRunParams.builder()
                        .idempotencyKey(key)
                        .tweetUrl("https://x.com/elonmusk/status/1234567890")
                        .build()
                )
                .close()
        }

        verify(
            1,
            postRequestedFor(urlPathEqualTo("/draws"))
                .withHeader("Idempotency-Key", equalTo("draw-1")),
        )
        verify(
            1,
            postRequestedFor(urlPathEqualTo("/draws")).withHeader("Idempotency-Key", absent()),
        )
    }
}
