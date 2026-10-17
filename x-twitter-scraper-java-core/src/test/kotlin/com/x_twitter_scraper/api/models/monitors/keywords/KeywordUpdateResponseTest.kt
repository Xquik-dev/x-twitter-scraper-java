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

internal class KeywordUpdateResponseTest {

    @Test
    fun create() {
        val keywordUpdateResponse =
            KeywordUpdateResponse.builder()
                .id("21")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(EventType.TWEET_NEW)
                .isActive(true)
                .nextBillingAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .query("xquik OR \"x api\"")
                .build()

        assertThat(keywordUpdateResponse.id()).isEqualTo("21")
        assertThat(keywordUpdateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(keywordUpdateResponse.eventTypes()).containsExactly(EventType.TWEET_NEW)
        assertThat(keywordUpdateResponse.isActive()).isEqualTo(true)
        assertThat(keywordUpdateResponse.nextBillingAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(keywordUpdateResponse.query()).isEqualTo("xquik OR \"x api\"")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val keywordUpdateResponse =
            KeywordUpdateResponse.builder()
                .id("21")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(EventType.TWEET_NEW)
                .isActive(true)
                .nextBillingAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .query("xquik OR \"x api\"")
                .build()

        val roundtrippedKeywordUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(keywordUpdateResponse),
                jacksonTypeRef<KeywordUpdateResponse>(),
            )

        assertThat(roundtrippedKeywordUpdateResponse).isEqualTo(keywordUpdateResponse)
    }

    @Test
    fun additionalFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json =
            """{"name":"sample","pausedReason":"insufficient_credits","pausedAt":"2025-01-15T12:00:00Z"}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<KeywordUpdateResponse>())

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
                    jacksonTypeRef<KeywordUpdateResponse>(),
                )
            )
            .isEqualTo(model)
    }
}
