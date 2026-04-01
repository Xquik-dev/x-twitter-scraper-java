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
                .id("id")
                .data(
                    EventRetrieveResponse.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .monitorId("monitorId")
                .occurredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .type(EventRetrieveResponse.Type.TWEET_NEW)
                .username("username")
                .xEventId("xEventId")
                .build()

        assertThat(eventRetrieveResponse.id()).isEqualTo("id")
        assertThat(eventRetrieveResponse.data())
            .isEqualTo(
                EventRetrieveResponse.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(eventRetrieveResponse.monitorId()).isEqualTo("monitorId")
        assertThat(eventRetrieveResponse.occurredAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(eventRetrieveResponse.type()).isEqualTo(EventRetrieveResponse.Type.TWEET_NEW)
        assertThat(eventRetrieveResponse.username()).isEqualTo("username")
        assertThat(eventRetrieveResponse.xEventId()).contains("xEventId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eventRetrieveResponse =
            EventRetrieveResponse.builder()
                .id("id")
                .data(
                    EventRetrieveResponse.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .monitorId("monitorId")
                .occurredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .type(EventRetrieveResponse.Type.TWEET_NEW)
                .username("username")
                .xEventId("xEventId")
                .build()

        val roundtrippedEventRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventRetrieveResponse),
                jacksonTypeRef<EventRetrieveResponse>(),
            )

        assertThat(roundtrippedEventRetrieveResponse).isEqualTo(eventRetrieveResponse)
    }
}
