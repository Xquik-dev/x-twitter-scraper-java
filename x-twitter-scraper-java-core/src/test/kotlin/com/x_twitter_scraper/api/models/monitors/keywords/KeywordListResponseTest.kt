// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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

    @Test
    fun additionalMonitorFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json =
            """{"name":"sample","pausedReason":"insufficient_credits","pausedAt":"2025-01-15T12:00:00Z"}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<KeywordListResponse.Monitor>())

        assertThat(model.name()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("name")
        assertThat(model.pausedReason()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("pausedReason")
        assertThat(model.pausedAt()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("pausedAt")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<KeywordListResponse.Monitor>(),
                )
            )
            .isEqualTo(model)
    }

    @Test
    fun additionalFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json = """{"hasMore":true,"nextCursor":"sample"}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<KeywordListResponse>())

        assertThat(model.hasMore()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("hasMore")
        assertThat(model.nextCursor()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("nextCursor")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<KeywordListResponse>(),
                )
            )
            .isEqualTo(model)
    }
}
