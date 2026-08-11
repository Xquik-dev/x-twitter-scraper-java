// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MonitorListResponseTest {

    @Test
    fun create() {
        val monitorListResponse =
            MonitorListResponse.builder()
                .addMonitor(
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
                )
                .total(0L)
                .build()

        assertThat(monitorListResponse.monitors())
            .containsExactly(
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
            )
        assertThat(monitorListResponse.total()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val monitorListResponse =
            MonitorListResponse.builder()
                .addMonitor(
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
                )
                .total(0L)
                .build()

        val roundtrippedMonitorListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(monitorListResponse),
                jacksonTypeRef<MonitorListResponse>(),
            )

        assertThat(roundtrippedMonitorListResponse).isEqualTo(monitorListResponse)
    }
}
