// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MonitorRetrieveResponseTest {

    @Test
    fun create() {
        val monitorRetrieveResponse =
            MonitorRetrieveResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(MonitorRetrieveResponse.EventType.TWEET_NEW)
                .addEventType(MonitorRetrieveResponse.EventType.FOLLOWER_GAINED)
                .isActive(true)
                .username("elonmusk")
                .xUserId("9876543210")
                .build()

        assertThat(monitorRetrieveResponse.id()).isEqualTo("42")
        assertThat(monitorRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(monitorRetrieveResponse.eventTypes())
            .containsExactly(
                MonitorRetrieveResponse.EventType.TWEET_NEW,
                MonitorRetrieveResponse.EventType.FOLLOWER_GAINED,
            )
        assertThat(monitorRetrieveResponse.isActive()).isEqualTo(true)
        assertThat(monitorRetrieveResponse.username()).isEqualTo("elonmusk")
        assertThat(monitorRetrieveResponse.xUserId()).isEqualTo("9876543210")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val monitorRetrieveResponse =
            MonitorRetrieveResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(MonitorRetrieveResponse.EventType.TWEET_NEW)
                .addEventType(MonitorRetrieveResponse.EventType.FOLLOWER_GAINED)
                .isActive(true)
                .username("elonmusk")
                .xUserId("9876543210")
                .build()

        val roundtrippedMonitorRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(monitorRetrieveResponse),
                jacksonTypeRef<MonitorRetrieveResponse>(),
            )

        assertThat(roundtrippedMonitorRetrieveResponse).isEqualTo(monitorRetrieveResponse)
    }
}
