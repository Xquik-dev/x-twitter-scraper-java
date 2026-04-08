// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MonitorUpdateResponseTest {

    @Test
    fun create() {
        val monitorUpdateResponse =
            MonitorUpdateResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(MonitorUpdateResponse.EventType.TWEET_NEW)
                .addEventType(MonitorUpdateResponse.EventType.FOLLOWER_GAINED)
                .isActive(true)
                .username("elonmusk")
                .xUserId("9876543210")
                .build()

        assertThat(monitorUpdateResponse.id()).isEqualTo("42")
        assertThat(monitorUpdateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(monitorUpdateResponse.eventTypes())
            .containsExactly(
                MonitorUpdateResponse.EventType.TWEET_NEW,
                MonitorUpdateResponse.EventType.FOLLOWER_GAINED,
            )
        assertThat(monitorUpdateResponse.isActive()).isEqualTo(true)
        assertThat(monitorUpdateResponse.username()).isEqualTo("elonmusk")
        assertThat(monitorUpdateResponse.xUserId()).isEqualTo("9876543210")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val monitorUpdateResponse =
            MonitorUpdateResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(MonitorUpdateResponse.EventType.TWEET_NEW)
                .addEventType(MonitorUpdateResponse.EventType.FOLLOWER_GAINED)
                .isActive(true)
                .username("elonmusk")
                .xUserId("9876543210")
                .build()

        val roundtrippedMonitorUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(monitorUpdateResponse),
                jacksonTypeRef<MonitorUpdateResponse>(),
            )

        assertThat(roundtrippedMonitorUpdateResponse).isEqualTo(monitorUpdateResponse)
    }
}
