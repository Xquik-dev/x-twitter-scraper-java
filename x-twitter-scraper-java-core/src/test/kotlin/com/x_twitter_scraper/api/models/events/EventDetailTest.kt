// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventDetailTest {

    @Test
    fun create() {
        val eventDetail =
            EventDetail.builder()
                .id("id")
                .data(
                    EventDetail.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .monitorId("monitorId")
                .occurredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .type(EventDetail.Type.TWEET_NEW)
                .username("username")
                .xEventId("xEventId")
                .build()

        assertThat(eventDetail.id()).isEqualTo("id")
        assertThat(eventDetail.data())
            .isEqualTo(
                EventDetail.Data.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(eventDetail.monitorId()).isEqualTo("monitorId")
        assertThat(eventDetail.occurredAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(eventDetail.type()).isEqualTo(EventDetail.Type.TWEET_NEW)
        assertThat(eventDetail.username()).isEqualTo("username")
        assertThat(eventDetail.xEventId()).contains("xEventId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val eventDetail =
            EventDetail.builder()
                .id("id")
                .data(
                    EventDetail.Data.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .monitorId("monitorId")
                .occurredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .type(EventDetail.Type.TWEET_NEW)
                .username("username")
                .xEventId("xEventId")
                .build()

        val roundtrippedEventDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventDetail),
                jacksonTypeRef<EventDetail>(),
            )

        assertThat(roundtrippedEventDetail).isEqualTo(eventDetail)
    }
}
