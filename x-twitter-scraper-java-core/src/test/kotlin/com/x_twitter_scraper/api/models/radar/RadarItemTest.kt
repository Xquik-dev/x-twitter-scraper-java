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
                .category("category")
                .publishedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .region("region")
                .score(0.0)
                .source("source")
                .title("title")
                .description("description")
                .imageUrl("imageUrl")
                .url("url")
                .build()

        assertThat(radarItem.category()).isEqualTo("category")
        assertThat(radarItem.publishedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(radarItem.region()).isEqualTo("region")
        assertThat(radarItem.score()).isEqualTo(0.0)
        assertThat(radarItem.source()).isEqualTo("source")
        assertThat(radarItem.title()).isEqualTo("title")
        assertThat(radarItem.description()).contains("description")
        assertThat(radarItem.imageUrl()).contains("imageUrl")
        assertThat(radarItem.url()).contains("url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val radarItem =
            RadarItem.builder()
                .category("category")
                .publishedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .region("region")
                .score(0.0)
                .source("source")
                .title("title")
                .description("description")
                .imageUrl("imageUrl")
                .url("url")
                .build()

        val roundtrippedRadarItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(radarItem),
                jacksonTypeRef<RadarItem>(),
            )

        assertThat(roundtrippedRadarItem).isEqualTo(radarItem)
    }
}
