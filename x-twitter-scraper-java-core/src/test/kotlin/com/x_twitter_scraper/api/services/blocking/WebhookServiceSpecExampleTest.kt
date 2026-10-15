// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.equalToJson
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.XTwitterScraperClient
import com.x_twitter_scraper.api.client.XTwitterScraperClientAsync
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.webhooks.WebhookCreateTelegramLinkParams
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class WebhookServiceSpecExampleTest {

    private lateinit var client: XTwitterScraperClient
    private lateinit var asyncClient: XTwitterScraperClientAsync

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .responseValidation(true)
                .build()
        asyncClient =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .responseValidation(true)
                .build()
    }

    @Test
    fun createTelegramLinkParsesTheSpecExample() {
        stubFor(
            post(urlPathEqualTo("/webhooks/telegram"))
                .willReturn(
                    okJson(
                        """
                        {
                          "url": "https://t.me/XquikBot?start=Q2hhdExpbmtDb2RlRXhhbXBsZTAx",
                          "expiresAt": "2025-01-15T12:15:00.000Z"
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            WebhookCreateTelegramLinkParams.builder().addEventType(EventType.TWEET_NEW).build()

        val response = client.webhooks().createTelegramLink(params)
        val asyncResponse = asyncClient.webhooks().createTelegramLink(params).get()

        verify(
            2,
            postRequestedFor(urlPathEqualTo("/webhooks/telegram"))
                .withRequestBody(equalToJson("{\"eventTypes\": [\"tweet.new\"]}")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.expiresAt()).isEqualTo(OffsetDateTime.parse("2025-01-15T12:15:00.000Z"))
        assertThat(response.url())
            .isEqualTo("https://t.me/XquikBot?start=Q2hhdExpbmtDb2RlRXhhbXBsZTAx")
    }
}
