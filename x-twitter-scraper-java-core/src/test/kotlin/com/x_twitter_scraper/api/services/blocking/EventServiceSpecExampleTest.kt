// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.okJson
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
import com.x_twitter_scraper.api.models.events.EventDetail
import com.x_twitter_scraper.api.models.events.EventListParams
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

    @Test
    fun listFiltersByPostMonitorAndParsesPostEvents() {
        stubFor(get(urlPathEqualTo("/events")).willReturn(okJson(listPostEventsExample)))
        val params =
            EventListParams.builder()
                .postMonitorId("31")
                .eventType(EventType.POST_LIKES_CHANGED)
                .build()

        val response = client.events().list(params)
        val asyncResponse = asyncClient.events().list(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/events"))
                .withQueryParam("postMonitorId", equalTo("31"))
                .withQueryParam("eventType", equalTo("post.likes.changed")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasMore()).isTrue()
        assertThat(response.nextCursor()).contains("9001")
        assertThat(response.events()).hasSize(2)
        val likes = response.events()[0]
        assertThat(likes.id()).isEqualTo("9002")
        assertThat(likes.type()).isEqualTo(EventType.POST_LIKES_CHANGED)
        assertThat(likes.monitorId()).isEqualTo("31")
        assertThat(likes.monitorType()).isEqualTo(Event.MonitorType.POST)
        assertThat(likes.monitorName()).contains("Launch post")
        assertThat(likes.postId()).contains("2102761519985332442")
        assertThat(likes.postUrl()).contains("https://x.com/NASA/status/2102761519985332442")
        assertThat(likes.authorId()).contains("11348282")
        assertThat(likes.authorUsername()).contains("NASA")
        assertThat(likes.occurredAt()).isEqualTo(OffsetDateTime.parse("2026-10-22T11:06:00.000Z"))
        assertThat(likes.data().metric()).contains(Event.Data.Metric.LIKES)
        assertThat(likes.data().previous().get().asLong()).isEqualTo(17096L)
        assertThat(likes.data().current().get().asLong()).isEqualTo(17200L)
        assertThat(likes.data().change()).contains(104L)
        assertThat(likes.data()._additionalProperties()).isEmpty()
        val deleted = response.events()[1]
        assertThat(deleted.type()).isEqualTo(EventType.POST_DELETED)
        assertThat(deleted.monitorType()).isEqualTo(Event.MonitorType.POST)
        assertThat(deleted.monitorName()).isEmpty()
        assertThat(deleted.data().text()).contains("We cut serving costs by 20%.")
    }

    @Test
    fun retrieveParsesAPostEditEvent() {
        stubFor(get(urlPathEqualTo("/events/9003")).willReturn(okJson(getPostEventExample)))

        val response = client.events().retrieve("9003")
        val asyncResponse = asyncClient.events().retrieve("9003").get()

        verify(2, getRequestedFor(urlPathEqualTo("/events/9003")))
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.id()).isEqualTo("9003")
        assertThat(response.type()).isEqualTo(EventType.POST_EDITED)
        assertThat(response.monitorType()).isEqualTo(EventDetail.MonitorType.POST)
        assertThat(response.postId()).contains("2102761519985332442")
        assertThat(response.postUrl()).contains("https://x.com/NASA/status/2102761519985332442")
        assertThat(response.authorId()).contains("11348282")
        assertThat(response.authorUsername()).contains("NASA")
        assertThat(response.data().previousText()).contains("We cut serving costs by 20%.")
        assertThat(response.data().text()).contains("We cut serving costs by 25%.")
        assertThat(response.data().versionId()).contains("2082577277246973001")
        assertThat(response.data()._additionalProperties()).isEmpty()
    }

    companion object {

        private val listPostEventsExample =
            """
            {
              "events": [
                {
                  "id": "9002",
                  "type": "post.likes.changed",
                  "monitorId": "31",
                  "monitorType": "post",
                  "monitorName": "Launch post",
                  "postId": "2102761519985332442",
                  "postUrl": "https://x.com/NASA/status/2102761519985332442",
                  "authorId": "11348282",
                  "authorUsername": "NASA",
                  "occurredAt": "2026-10-22T11:06:00.000Z",
                  "data": {
                    "metric": "likes",
                    "previous": 17096,
                    "current": 17200,
                    "change": 104
                  }
                },
                {
                  "id": "9001",
                  "type": "post.deleted",
                  "monitorId": "31",
                  "monitorType": "post",
                  "postId": "2102761519985332442",
                  "postUrl": "https://x.com/NASA/status/2102761519985332442",
                  "authorId": "11348282",
                  "authorUsername": "NASA",
                  "occurredAt": "2026-10-22T11:05:00.000Z",
                  "data": {
                    "text": "We cut serving costs by 20%."
                  }
                }
              ],
              "hasMore": true,
              "nextCursor": "9001"
            }
            """
                .trimIndent()

        private val getPostEventExample =
            """
            {
              "id": "9003",
              "type": "post.edited",
              "monitorId": "31",
              "monitorType": "post",
              "postId": "2102761519985332442",
              "postUrl": "https://x.com/NASA/status/2102761519985332442",
              "authorId": "11348282",
              "authorUsername": "NASA",
              "occurredAt": "2026-10-22T11:07:00.000Z",
              "data": {
                "previousText": "We cut serving costs by 20%.",
                "text": "We cut serving costs by 25%.",
                "versionId": "2082577277246973001"
              }
            }
            """
                .trimIndent()
    }
}
