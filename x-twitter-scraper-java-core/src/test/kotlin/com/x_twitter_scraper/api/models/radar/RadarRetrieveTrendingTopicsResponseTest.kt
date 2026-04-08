// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.radar

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RadarRetrieveTrendingTopicsResponseTest {

    @Test
    fun create() {
        val radarRetrieveTrendingTopicsResponse =
            RadarRetrieveTrendingTopicsResponse.builder()
                .addItem(
                    RadarItem.builder()
                        .category("Technology")
                        .publishedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .region("US")
                        .score(95.5)
                        .source("X")
                        .title("AI Revolution in 2025")
                        .description("AI is transforming every industry")
                        .imageUrl("https://example.com/images/ai.jpg")
                        .url("https://example.com/article/ai-revolution")
                        .build()
                )
                .total(0L)
                .build()

        assertThat(radarRetrieveTrendingTopicsResponse.items())
            .containsExactly(
                RadarItem.builder()
                    .category("Technology")
                    .publishedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .region("US")
                    .score(95.5)
                    .source("X")
                    .title("AI Revolution in 2025")
                    .description("AI is transforming every industry")
                    .imageUrl("https://example.com/images/ai.jpg")
                    .url("https://example.com/article/ai-revolution")
                    .build()
            )
        assertThat(radarRetrieveTrendingTopicsResponse.total()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val radarRetrieveTrendingTopicsResponse =
            RadarRetrieveTrendingTopicsResponse.builder()
                .addItem(
                    RadarItem.builder()
                        .category("Technology")
                        .publishedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .region("US")
                        .score(95.5)
                        .source("X")
                        .title("AI Revolution in 2025")
                        .description("AI is transforming every industry")
                        .imageUrl("https://example.com/images/ai.jpg")
                        .url("https://example.com/article/ai-revolution")
                        .build()
                )
                .total(0L)
                .build()

        val roundtrippedRadarRetrieveTrendingTopicsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(radarRetrieveTrendingTopicsResponse),
                jacksonTypeRef<RadarRetrieveTrendingTopicsResponse>(),
            )

        assertThat(roundtrippedRadarRetrieveTrendingTopicsResponse)
            .isEqualTo(radarRetrieveTrendingTopicsResponse)
    }
}
