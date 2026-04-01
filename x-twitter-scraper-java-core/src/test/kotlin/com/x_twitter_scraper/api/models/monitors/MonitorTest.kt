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
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addEventType(Monitor.EventType.TWEET_NEW)
                .isActive(true)
                .username("username")
                .xUserId("xUserId")
                .build()

        assertThat(monitor.id()).isEqualTo("id")
        assertThat(monitor.createdAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(monitor.eventTypes()).containsExactly(Monitor.EventType.TWEET_NEW)
        assertThat(monitor.isActive()).isEqualTo(true)
        assertThat(monitor.username()).isEqualTo("username")
        assertThat(monitor.xUserId()).isEqualTo("xUserId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val monitor =
            Monitor.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addEventType(Monitor.EventType.TWEET_NEW)
                .isActive(true)
                .username("username")
                .xUserId("xUserId")
                .build()

        val roundtrippedMonitor =
            jsonMapper.readValue(jsonMapper.writeValueAsString(monitor), jacksonTypeRef<Monitor>())

        assertThat(roundtrippedMonitor).isEqualTo(monitor)
    }
}
