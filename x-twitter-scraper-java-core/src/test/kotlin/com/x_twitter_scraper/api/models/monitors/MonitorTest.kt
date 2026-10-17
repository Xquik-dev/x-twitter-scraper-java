// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.monitors

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
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
                .addEventType(EventType.TWEET_NEW)
                .addEventType(EventType.TWEET_REPLY)
                .isActive(true)
                .nextBillingAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .username("elonmusk")
                .xUserId("9876543210")
                .pausedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pausedReason(Monitor.PausedReason.X_USER_NOT_FOUND)
                .build()

        assertThat(monitor.id()).isEqualTo("42")
        assertThat(monitor.createdAt()).isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(monitor.eventTypes()).containsExactly(EventType.TWEET_NEW, EventType.TWEET_REPLY)
        assertThat(monitor.isActive()).isEqualTo(true)
        assertThat(monitor.nextBillingAt()).isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(monitor.username()).isEqualTo("elonmusk")
        assertThat(monitor.xUserId()).isEqualTo("9876543210")
        assertThat(monitor.pausedAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(monitor.pausedReason()).contains(Monitor.PausedReason.X_USER_NOT_FOUND)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val monitor =
            Monitor.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(EventType.TWEET_NEW)
                .addEventType(EventType.TWEET_REPLY)
                .isActive(true)
                .nextBillingAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .username("elonmusk")
                .xUserId("9876543210")
                .pausedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pausedReason(Monitor.PausedReason.X_USER_NOT_FOUND)
                .build()

        val roundtrippedMonitor =
            jsonMapper.readValue(jsonMapper.writeValueAsString(monitor), jacksonTypeRef<Monitor>())

        assertThat(roundtrippedMonitor).isEqualTo(monitor)
    }

    @Test
    fun additionalFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json = """{"name":"sample"}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<Monitor>())

        assertThat(model.name()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("name")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<Monitor>(),
                )
            )
            .isEqualTo(model)
    }

    @Test
    fun additionalPausedReasonValues() {
        assertThat(Monitor.PausedReason.of("insufficient_credits").known())
            .isEqualTo(Monitor.PausedReason.Known.INSUFFICIENT_CREDITS)
        assertThat(Monitor.PausedReason.of("x_account_protected").known())
            .isEqualTo(Monitor.PausedReason.Known.X_ACCOUNT_PROTECTED)
    }
}
