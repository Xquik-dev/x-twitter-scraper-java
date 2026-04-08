// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventDetailTest {

    @Test
    fun create() {
        val eventDetail =
            EventDetail.builder()
                .id("42")
                .data(
                    EventDetail.Data.builder()
                        .putAdditionalProperty("tweetId", JsonValue.from("bar"))
                        .build()
                )
                .monitorId("10")
                .occurredAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .type(EventType.TWEET_NEW)
                .username("elonmusk")
                .xEventId("1234567890")
                .build()

        assertThat(eventDetail.id()).isEqualTo("42")
        assertThat(eventDetail.data())
            .isEqualTo(
                EventDetail.Data.builder()
                    .putAdditionalProperty("tweetId", JsonValue.from("bar"))
                    .build()
            )
        assertThat(eventDetail.monitorId()).isEqualTo("10")
        assertThat(eventDetail.occurredAt()).isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(eventDetail.type()).isEqualTo(EventType.TWEET_NEW)
        assertThat(eventDetail.username()).isEqualTo("elonmusk")
        assertThat(eventDetail.xEventId()).contains("1234567890")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eventDetail =
            EventDetail.builder()
                .id("42")
                .data(
                    EventDetail.Data.builder()
                        .putAdditionalProperty("tweetId", JsonValue.from("bar"))
                        .build()
                )
                .monitorId("10")
                .occurredAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .type(EventType.TWEET_NEW)
                .username("elonmusk")
                .xEventId("1234567890")
                .build()

        val roundtrippedEventDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventDetail),
                jacksonTypeRef<EventDetail>(),
            )

        assertThat(roundtrippedEventDetail).isEqualTo(eventDetail)
    }
}
