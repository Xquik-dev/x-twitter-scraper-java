// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventTest {

    @Test
    fun create() {
        val event =
            Event.builder()
                .id("id")
                .data(
                    Event.Data.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
                )
                .monitorId("monitorId")
                .occurredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .type(EventType.TWEET_NEW)
                .username("username")
                .build()

        assertThat(event.id()).isEqualTo("id")
        assertThat(event.data())
            .isEqualTo(
                Event.Data.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
            )
        assertThat(event.monitorId()).isEqualTo("monitorId")
        assertThat(event.occurredAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(event.type()).isEqualTo(EventType.TWEET_NEW)
        assertThat(event.username()).isEqualTo("username")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val event =
            Event.builder()
                .id("id")
                .data(
                    Event.Data.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
                )
                .monitorId("monitorId")
                .occurredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .type(EventType.TWEET_NEW)
                .username("username")
                .build()

        val roundtrippedEvent =
            jsonMapper.readValue(jsonMapper.writeValueAsString(event), jacksonTypeRef<Event>())

        assertThat(roundtrippedEvent).isEqualTo(event)
    }
}
