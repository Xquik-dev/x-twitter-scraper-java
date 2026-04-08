// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.radar

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RadarItemTest {

    @Test
    fun create() {
        val radarItem =
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

        assertThat(radarItem.category()).isEqualTo("Technology")
        assertThat(radarItem.publishedAt()).isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(radarItem.region()).isEqualTo("US")
        assertThat(radarItem.score()).isEqualTo(95.5)
        assertThat(radarItem.source()).isEqualTo("X")
        assertThat(radarItem.title()).isEqualTo("AI Revolution in 2025")
        assertThat(radarItem.description()).contains("AI is transforming every industry")
        assertThat(radarItem.imageUrl()).contains("https://example.com/images/ai.jpg")
        assertThat(radarItem.url()).contains("https://example.com/article/ai-revolution")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val radarItem =
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

        val roundtrippedRadarItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(radarItem),
                jacksonTypeRef<RadarItem>(),
            )

        assertThat(roundtrippedRadarItem).isEqualTo(radarItem)
    }
}
