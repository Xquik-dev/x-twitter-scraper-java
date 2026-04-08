// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventRetrieveResponseTest {

    @Test
    fun create() {
        val eventRetrieveResponse =
            EventRetrieveResponse.builder()
                .id("42")
                .data(
                    EventRetrieveResponse.Data.builder()
                        .putAdditionalProperty("tweetId", JsonValue.from("bar"))
                        .build()
                )
                .monitorId("10")
                .occurredAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .type(EventRetrieveResponse.Type.TWEET_NEW)
                .username("elonmusk")
                .xEventId("1234567890")
                .build()

        assertThat(eventRetrieveResponse.id()).isEqualTo("42")
        assertThat(eventRetrieveResponse.data())
            .isEqualTo(
                EventRetrieveResponse.Data.builder()
                    .putAdditionalProperty("tweetId", JsonValue.from("bar"))
                    .build()
            )
        assertThat(eventRetrieveResponse.monitorId()).isEqualTo("10")
        assertThat(eventRetrieveResponse.occurredAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(eventRetrieveResponse.type()).isEqualTo(EventRetrieveResponse.Type.TWEET_NEW)
        assertThat(eventRetrieveResponse.username()).isEqualTo("elonmusk")
        assertThat(eventRetrieveResponse.xEventId()).contains("1234567890")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eventRetrieveResponse =
            EventRetrieveResponse.builder()
                .id("42")
                .data(
                    EventRetrieveResponse.Data.builder()
                        .putAdditionalProperty("tweetId", JsonValue.from("bar"))
                        .build()
                )
                .monitorId("10")
                .occurredAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .type(EventRetrieveResponse.Type.TWEET_NEW)
                .username("elonmusk")
                .xEventId("1234567890")
                .build()

        val roundtrippedEventRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventRetrieveResponse),
                jacksonTypeRef<EventRetrieveResponse>(),
            )

        assertThat(roundtrippedEventRetrieveResponse).isEqualTo(eventRetrieveResponse)
    }
}
