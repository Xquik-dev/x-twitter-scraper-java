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

internal class KeywordRetrieveResponseTest {

    @Test
    fun create() {
        val keywordRetrieveResponse =
            KeywordRetrieveResponse.builder()
                .id("21")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(EventType.TWEET_NEW)
                .isActive(true)
                .nextBillingAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .query("xquik OR \"x api\"")
                .build()

        assertThat(keywordRetrieveResponse.id()).isEqualTo("21")
        assertThat(keywordRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(keywordRetrieveResponse.eventTypes()).containsExactly(EventType.TWEET_NEW)
        assertThat(keywordRetrieveResponse.isActive()).isEqualTo(true)
        assertThat(keywordRetrieveResponse.nextBillingAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(keywordRetrieveResponse.query()).isEqualTo("xquik OR \"x api\"")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val keywordRetrieveResponse =
            KeywordRetrieveResponse.builder()
                .id("21")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(EventType.TWEET_NEW)
                .isActive(true)
                .nextBillingAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .query("xquik OR \"x api\"")
                .build()

        val roundtrippedKeywordRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(keywordRetrieveResponse),
                jacksonTypeRef<KeywordRetrieveResponse>(),
            )

        assertThat(roundtrippedKeywordRetrieveResponse).isEqualTo(keywordRetrieveResponse)
    }
}
