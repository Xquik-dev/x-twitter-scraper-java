// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.equalToJson
import com.github.tomakehurst.wiremock.client.WireMock.jsonResponse
import com.github.tomakehurst.wiremock.client.WireMock.put
import com.github.tomakehurst.wiremock.client.WireMock.putRequestedFor
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
import com.x_twitter_scraper.api.models.monitors.MonitorUpsertByUsernameParams
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class MonitorUpsertByUsernameTest {

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
    fun upsertPutsTheBodyAndReadsACreatedMonitor() {
        stubFor(put(urlPathEqualTo(PATH)).willReturn(jsonResponse(example(true), 201)))
        val params =
            MonitorUpsertByUsernameParams.builder()
                .addEventType(EventType.TWEET_NEW)
                .addEventType(EventType.TWEET_REPLY)
                .name("Launch watch")
                .build()

        val monitor = client.monitors().upsertByUsername("elonmusk", params)

        assertThat(monitor.created()).isTrue()
        assertThat(monitor.id()).isEqualTo("42")
        assertThat(monitor.username()).isEqualTo("elonmusk")
        assertThat(monitor.xUserId()).isEqualTo("1234567890")
        assertThat(monitor.name()).contains("Launch watch")
        verify(
            putRequestedFor(urlPathEqualTo(PATH))
                .withRequestBody(
                    equalToJson(
                        """{"eventTypes":["tweet.new","tweet.reply"],"name":"Launch watch"}"""
                    )
                )
        )
    }

    @Test
    fun upsertReadsAnUpdatedMonitorAndLeavesOutAnUnsetName() {
        stubFor(put(urlPathEqualTo(PATH)).willReturn(jsonResponse(example(false), 200)))
        val params =
            MonitorUpsertByUsernameParams.builder()
                .username("elonmusk")
                .addEventType(EventType.TWEET_NEW)
                .build()

        val monitor = client.monitors().upsertByUsername(params)

        assertThat(monitor.created()).isFalse()
        verify(
            putRequestedFor(urlPathEqualTo(PATH))
                .withRequestBody(equalToJson("""{"eventTypes":["tweet.new"]}"""))
        )
    }

    @Test
    fun upsertSendsANullNameToRemoveTheLabel() {
        stubFor(put(urlPathEqualTo(PATH)).willReturn(jsonResponse(example(false), 200)))
        val params =
            MonitorUpsertByUsernameParams.builder()
                .addEventType(EventType.TWEET_NEW)
                .name(null as String?)
                .build()

        client.monitors().upsertByUsername("elonmusk", params)

        verify(
            putRequestedFor(urlPathEqualTo(PATH))
                .withRequestBody(equalToJson("""{"eventTypes":["tweet.new"],"name":null}"""))
        )
    }

    @Test
    fun asyncUpsertPutsTheBodyAndReadsCreated() {
        stubFor(put(urlPathEqualTo(PATH)).willReturn(jsonResponse(example(true), 201)))
        val params =
            MonitorUpsertByUsernameParams.builder().addEventType(EventType.TWEET_NEW).build()

        val monitor = asyncClient.monitors().upsertByUsername("elonmusk", params).get()

        assertThat(monitor.created()).isTrue()
        verify(
            putRequestedFor(urlPathEqualTo(PATH))
                .withRequestBody(equalToJson("""{"eventTypes":["tweet.new"]}"""))
        )
    }

    @Test
    fun theRawViewsAnswerWithTheStatus() {
        stubFor(put(urlPathEqualTo(PATH)).willReturn(jsonResponse(example(true), 201)))
        val params =
            MonitorUpsertByUsernameParams.builder()
                .username("elonmusk")
                .addEventType(EventType.TWEET_NEW)
                .build()

        client.monitors().withRawResponse().upsertByUsername(params).use { response ->
            assertThat(response.statusCode()).isEqualTo(201)
            assertThat(response.parse().created()).isTrue()
        }
        asyncClient.monitors().withRawResponse().upsertByUsername(params).get().use { response ->
            assertThat(response.statusCode()).isEqualTo(201)
            assertThat(response.parse().created()).isTrue()
        }
    }

    @Test
    fun upsertRefusesAMissingUsername() {
        val params =
            MonitorUpsertByUsernameParams.builder().addEventType(EventType.TWEET_NEW).build()

        assertThatThrownBy { client.monitors().upsertByUsername(params) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("username")
        assertThatThrownBy { asyncClient.monitors().upsertByUsername(params) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("username")
    }

    private fun example(created: Boolean) =
        """{"created":$created,"id":"42","username":"elonmusk","xUserId":"1234567890","name":"Launch watch","eventTypes":["tweet.new","tweet.reply"],"isActive":true,"createdAt":"2025-01-15T12:00:00Z","nextBillingAt":"2025-01-15T12:00:00Z"}"""

    private companion object {
        const val PATH = "/monitors/username/elonmusk"
    }
}
