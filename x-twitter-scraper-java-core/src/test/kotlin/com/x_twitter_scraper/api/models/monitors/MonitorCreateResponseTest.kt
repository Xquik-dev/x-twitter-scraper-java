// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MonitorCreateResponseTest {

    @Test
    fun create() {
        val monitorCreateResponse =
            MonitorCreateResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(MonitorCreateResponse.EventType.TWEET_NEW)
                .addEventType(MonitorCreateResponse.EventType.FOLLOWER_GAINED)
                .username("elonmusk")
                .xUserId("1234567890")
                .build()

        assertThat(monitorCreateResponse.id()).isEqualTo("42")
        assertThat(monitorCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(monitorCreateResponse.eventTypes())
            .containsExactly(
                MonitorCreateResponse.EventType.TWEET_NEW,
                MonitorCreateResponse.EventType.FOLLOWER_GAINED,
            )
        assertThat(monitorCreateResponse.username()).isEqualTo("elonmusk")
        assertThat(monitorCreateResponse.xUserId()).isEqualTo("1234567890")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val monitorCreateResponse =
            MonitorCreateResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(MonitorCreateResponse.EventType.TWEET_NEW)
                .addEventType(MonitorCreateResponse.EventType.FOLLOWER_GAINED)
                .username("elonmusk")
                .xUserId("1234567890")
                .build()

        val roundtrippedMonitorCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(monitorCreateResponse),
                jacksonTypeRef<MonitorCreateResponse>(),
            )

        assertThat(roundtrippedMonitorCreateResponse).isEqualTo(monitorCreateResponse)
    }
}
