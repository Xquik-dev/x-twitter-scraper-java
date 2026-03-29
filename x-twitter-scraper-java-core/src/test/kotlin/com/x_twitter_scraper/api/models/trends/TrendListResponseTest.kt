// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.trends

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TrendListResponseTest {

    @Test
    fun create() {
        val trendListResponse =
            TrendListResponse.builder()
                .total(0L)
                .addTrend(
                    TrendListResponse.Trend.builder()
                        .name("name")
                        .description("description")
                        .query("query")
                        .rank(0L)
                        .build()
                )
                .woeid(0L)
                .build()

        assertThat(trendListResponse.total()).isEqualTo(0L)
        assertThat(trendListResponse.trends())
            .containsExactly(
                TrendListResponse.Trend.builder()
                    .name("name")
                    .description("description")
                    .query("query")
                    .rank(0L)
                    .build()
            )
        assertThat(trendListResponse.woeid()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val trendListResponse =
            TrendListResponse.builder()
                .total(0L)
                .addTrend(
                    TrendListResponse.Trend.builder()
                        .name("name")
                        .description("description")
                        .query("query")
                        .rank(0L)
                        .build()
                )
                .woeid(0L)
                .build()

        val roundtrippedTrendListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(trendListResponse),
                jacksonTypeRef<TrendListResponse>(),
            )

        assertThat(roundtrippedTrendListResponse).isEqualTo(trendListResponse)
    }
}
