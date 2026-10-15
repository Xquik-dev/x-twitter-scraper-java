// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.ok
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
import com.x_twitter_scraper.api.models.events.Event
import com.x_twitter_scraper.api.models.events.EventStreamParams
import java.time.OffsetDateTime
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class EventServiceSpecExampleTest {

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
    fun streamParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/events/stream"))
                .willReturn(
                    ok()
                        .withHeader("Content-Type", "text/event-stream")
                        .withBody(
                            """
                            : connected

                            id: 42
                            event: tweet.new
                            data: {"id":"42","type":"tweet.new","monitorId":"7","monitorType":"account","occurredAt":"2025-01-15T12:00:00.000Z","data":{}}

                            : keep-alive

                            id: 43
                            event: tweet.reply
                            data: {"id":"43","type":"tweet.reply","monitorId":"7","monitorType":"account","occurredAt":"2025-01-15T12:00:00.000Z","data":{}}

                            : keep-alive
                            """
                                .trimIndent()
                        )
                )
        )
        val params = EventStreamParams.builder().lastEventID("41").build()

        val events = client.events().stream(params).use { it.stream().toList() }
        val asyncEvents = mutableListOf<Event>()
        val handlerThreads = mutableSetOf<String>()
        asyncClient
            .withOptions {
                it.streamHandlerExecutor { task -> Thread(task, "event-handler").start() }
            }
            .events()
            .stream(params)
            .subscribe { event ->
                handlerThreads.add(Thread.currentThread().name)
                asyncEvents.add(event)
            }
            .onCompleteFuture()
            .get(10, TimeUnit.SECONDS)

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/events/stream"))
                .withHeader("Last-Event-ID", equalTo("41")),
        )
        assertThat(asyncEvents).isEqualTo(events)
        assertThat(handlerThreads).containsExactly("event-handler")
        assertThat(events).hasSize(2)
        assertThat(events[0].id()).isEqualTo("42")
        assertThat(events[0].type()).isEqualTo(EventType.TWEET_NEW)
        assertThat(events[0].monitorId()).isEqualTo("7")
        assertThat(events[0].monitorType()).isEqualTo(Event.MonitorType.ACCOUNT)
        assertThat(events[0].occurredAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00.000Z"))
        assertThat(events[0].data()._additionalProperties()).isEmpty()
        assertThat(events[1].id()).isEqualTo("43")
        assertThat(events[1].type()).isEqualTo(EventType.TWEET_REPLY)
    }
}
