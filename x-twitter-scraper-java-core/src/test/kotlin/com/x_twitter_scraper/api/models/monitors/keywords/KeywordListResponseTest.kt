// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors.keywords

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class KeywordListResponseTest {

    @Test
    fun create() {
        val keywordListResponse =
            KeywordListResponse.builder()
                .addMonitor(
                    KeywordListResponse.Monitor.builder()
                        .id("21")
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .addEventType(EventType.TWEET_NEW)
                        .isActive(true)
                        .nextBillingAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .query("xquik OR \"x api\"")
                        .build()
                )
                .total(0L)
                .build()

        assertThat(keywordListResponse.monitors())
            .containsExactly(
                KeywordListResponse.Monitor.builder()
                    .id("21")
                    .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .addEventType(EventType.TWEET_NEW)
                    .isActive(true)
                    .nextBillingAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .query("xquik OR \"x api\"")
                    .build()
            )
        assertThat(keywordListResponse.total()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val keywordListResponse =
            KeywordListResponse.builder()
                .addMonitor(
                    KeywordListResponse.Monitor.builder()
                        .id("21")
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .addEventType(EventType.TWEET_NEW)
                        .isActive(true)
                        .nextBillingAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .query("xquik OR \"x api\"")
                        .build()
                )
                .total(0L)
                .build()

        val roundtrippedKeywordListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(keywordListResponse),
                jacksonTypeRef<KeywordListResponse>(),
            )

        assertThat(roundtrippedKeywordListResponse).isEqualTo(keywordListResponse)
    }
}
