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
                    RadarRetrieveTrendingTopicsResponse.Item.builder()
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
                )
                .total(0L)
                .build()

        assertThat(radarRetrieveTrendingTopicsResponse.items())
            .containsExactly(
                RadarRetrieveTrendingTopicsResponse.Item.builder()
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
            )
        assertThat(radarRetrieveTrendingTopicsResponse.total()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val radarRetrieveTrendingTopicsResponse =
            RadarRetrieveTrendingTopicsResponse.builder()
                .addItem(
                    RadarRetrieveTrendingTopicsResponse.Item.builder()
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
