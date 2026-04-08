// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventListResponseTest {

    @Test
    fun create() {
        val eventListResponse =
            EventListResponse.builder()
                .addEvent(
                    EventListResponse.Event.builder()
                        .id("id")
                        .data(
                            EventListResponse.Event.Data.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .monitorId("monitorId")
                        .occurredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .type(EventListResponse.Event.Type.TWEET_NEW)
                        .username("username")
                        .build()
                )
                .hasMore(false)
                .nextCursor("abc123")
                .build()

        assertThat(eventListResponse.events())
            .containsExactly(
                EventListResponse.Event.builder()
                    .id("id")
                    .data(
                        EventListResponse.Event.Data.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .monitorId("monitorId")
                    .occurredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .type(EventListResponse.Event.Type.TWEET_NEW)
                    .username("username")
                    .build()
            )
        assertThat(eventListResponse.hasMore()).isEqualTo(false)
        assertThat(eventListResponse.nextCursor()).contains("abc123")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eventListResponse =
            EventListResponse.builder()
                .addEvent(
                    EventListResponse.Event.builder()
                        .id("id")
                        .data(
                            EventListResponse.Event.Data.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .monitorId("monitorId")
                        .occurredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .type(EventListResponse.Event.Type.TWEET_NEW)
                        .username("username")
                        .build()
                )
                .hasMore(false)
                .nextCursor("abc123")
                .build()

        val roundtrippedEventListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventListResponse),
                jacksonTypeRef<EventListResponse>(),
            )

        assertThat(roundtrippedEventListResponse).isEqualTo(eventListResponse)
    }
}
