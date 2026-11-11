// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.monitors

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class MonitorUpsertByUsernameResponseTest {

    private fun builder() =
        MonitorUpsertByUsernameResponse.builder()
            .id("42")
            .created(true)
            .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
            .addEventType(EventType.TWEET_NEW)
            .addEventType(EventType.TWEET_REPLY)
            .isActive(true)
            .nextBillingAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
            .username("elonmusk")
            .xUserId("1234567890")

    @Test
    fun create() {
        val monitor = builder().name("Launch watch").build()

        assertThat(monitor.id()).isEqualTo("42")
        assertThat(monitor.created()).isTrue()
        assertThat(monitor.isActive()).isTrue()
        assertThat(monitor.name()).contains("Launch watch")
        assertThat(monitor.toBuilder().build()).isEqualTo(monitor)
        assertThat(monitor.isValid()).isTrue()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val monitor = builder().build()

        val roundtrippedMonitor =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(monitor),
                jacksonTypeRef<MonitorUpsertByUsernameResponse>(),
            )

        assertThat(roundtrippedMonitor).isEqualTo(monitor)
    }

    @Test
    fun createdIsRequired() {
        assertThatThrownBy {
                MonitorUpsertByUsernameResponse.builder()
                    .id("42")
                    .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .addEventType(EventType.TWEET_NEW)
                    .isActive(true)
                    .nextBillingAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .username("elonmusk")
                    .xUserId("1234567890")
                    .build()
            }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("created")
    }
}
