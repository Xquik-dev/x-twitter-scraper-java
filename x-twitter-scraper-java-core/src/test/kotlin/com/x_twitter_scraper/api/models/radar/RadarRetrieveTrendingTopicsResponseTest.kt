// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.radar

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RadarRetrieveTrendingTopicsResponseTest {

    @Test
    fun create() {
        val radarRetrieveTrendingTopicsResponse =
            RadarRetrieveTrendingTopicsResponse.builder()
                .hasMore(false)
                .addItem(
                    RadarItem.builder()
                        .id("4712")
                        .category(RadarItem.Category.TECH)
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:01:00Z"))
                        .language("en")
                        .metadata(
                            RadarItem.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .publishedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .region("global")
                        .score(95.5)
                        .source(RadarItem.Source.TRUSTMRR)
                        .sourceId("trustmrr_acme")
                        .title("AI Revolution in 2025")
                        .description("AI is transforming every industry")
                        .imageUrl("https://example.com/images/ai.jpg")
                        .url("https://example.com/article/ai-revolution")
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        assertThat(radarRetrieveTrendingTopicsResponse.hasMore()).isEqualTo(false)
        assertThat(radarRetrieveTrendingTopicsResponse.items())
            .containsExactly(
                RadarItem.builder()
                    .id("4712")
                    .category(RadarItem.Category.TECH)
                    .createdAt(OffsetDateTime.parse("2025-01-15T12:01:00Z"))
                    .language("en")
                    .metadata(
                        RadarItem.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .publishedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .region("global")
                    .score(95.5)
                    .source(RadarItem.Source.TRUSTMRR)
                    .sourceId("trustmrr_acme")
                    .title("AI Revolution in 2025")
                    .description("AI is transforming every industry")
                    .imageUrl("https://example.com/images/ai.jpg")
                    .url("https://example.com/article/ai-revolution")
                    .build()
            )
        assertThat(radarRetrieveTrendingTopicsResponse.nextCursor()).contains("nextCursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val radarRetrieveTrendingTopicsResponse =
            RadarRetrieveTrendingTopicsResponse.builder()
                .hasMore(false)
                .addItem(
                    RadarItem.builder()
                        .id("4712")
                        .category(RadarItem.Category.TECH)
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:01:00Z"))
                        .language("en")
                        .metadata(
                            RadarItem.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .publishedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .region("global")
                        .score(95.5)
                        .source(RadarItem.Source.TRUSTMRR)
                        .sourceId("trustmrr_acme")
                        .title("AI Revolution in 2025")
                        .description("AI is transforming every industry")
                        .imageUrl("https://example.com/images/ai.jpg")
                        .url("https://example.com/article/ai-revolution")
                        .build()
                )
                .nextCursor("nextCursor")
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
