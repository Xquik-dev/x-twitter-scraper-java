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
                .total(30L)
                .addTrend(
                    TrendListResponse.Trend.builder()
                        .name("#AI")
                        .description("Artificial intelligence discussions")
                        .query("%23AI")
                        .rank(1L)
                        .build()
                )
                .woeid(1L)
                .build()

        assertThat(trendListResponse.total()).isEqualTo(30L)
        assertThat(trendListResponse.trends())
            .containsExactly(
                TrendListResponse.Trend.builder()
                    .name("#AI")
                    .description("Artificial intelligence discussions")
                    .query("%23AI")
                    .rank(1L)
                    .build()
            )
        assertThat(trendListResponse.woeid()).isEqualTo(1L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val trendListResponse =
            TrendListResponse.builder()
                .total(30L)
                .addTrend(
                    TrendListResponse.Trend.builder()
                        .name("#AI")
                        .description("Artificial intelligence discussions")
                        .query("%23AI")
                        .rank(1L)
                        .build()
                )
                .woeid(1L)
                .build()

        val roundtrippedTrendListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(trendListResponse),
                jacksonTypeRef<TrendListResponse>(),
            )

        assertThat(roundtrippedTrendListResponse).isEqualTo(trendListResponse)
    }
}
