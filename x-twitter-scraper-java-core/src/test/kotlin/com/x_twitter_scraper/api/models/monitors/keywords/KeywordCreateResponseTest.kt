// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors.keywords

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.EventType
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class KeywordCreateResponseTest {

    @Test
    fun create() {
        val keywordCreateResponse =
            KeywordCreateResponse.builder()
                .id("21")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(EventType.TWEET_NEW)
                .isActive(true)
                .nextBillingAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .query("xquik OR \"x api\"")
                .build()

        assertThat(keywordCreateResponse.id()).isEqualTo("21")
        assertThat(keywordCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(keywordCreateResponse.eventTypes()).containsExactly(EventType.TWEET_NEW)
        assertThat(keywordCreateResponse.isActive()).isEqualTo(true)
        assertThat(keywordCreateResponse.nextBillingAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(keywordCreateResponse.query()).isEqualTo("xquik OR \"x api\"")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val keywordCreateResponse =
            KeywordCreateResponse.builder()
                .id("21")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .addEventType(EventType.TWEET_NEW)
                .isActive(true)
                .nextBillingAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .query("xquik OR \"x api\"")
                .build()

        val roundtrippedKeywordCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(keywordCreateResponse),
                jacksonTypeRef<KeywordCreateResponse>(),
            )

        assertThat(roundtrippedKeywordCreateResponse).isEqualTo(keywordCreateResponse)
    }
}
