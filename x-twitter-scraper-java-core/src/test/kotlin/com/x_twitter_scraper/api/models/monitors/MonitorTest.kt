// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MonitorTest {

    @Test
    fun create() {
        val monitor =
            Monitor.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(Monitor.EventType.TWEET_NEW)
                .addEventType(Monitor.EventType.FOLLOWER_GAINED)
                .isActive(true)
                .username("elonmusk")
                .xUserId("9876543210")
                .build()

        assertThat(monitor.id()).isEqualTo("42")
        assertThat(monitor.createdAt()).isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(monitor.eventTypes())
            .containsExactly(Monitor.EventType.TWEET_NEW, Monitor.EventType.FOLLOWER_GAINED)
        assertThat(monitor.isActive()).isEqualTo(true)
        assertThat(monitor.username()).isEqualTo("elonmusk")
        assertThat(monitor.xUserId()).isEqualTo("9876543210")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val monitor =
            Monitor.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(Monitor.EventType.TWEET_NEW)
                .addEventType(Monitor.EventType.FOLLOWER_GAINED)
                .isActive(true)
                .username("elonmusk")
                .xUserId("9876543210")
                .build()

        val roundtrippedMonitor =
            jsonMapper.readValue(jsonMapper.writeValueAsString(monitor), jacksonTypeRef<Monitor>())

        assertThat(roundtrippedMonitor).isEqualTo(monitor)
    }
}
