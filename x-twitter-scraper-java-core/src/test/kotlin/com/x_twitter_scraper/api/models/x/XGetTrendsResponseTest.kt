// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetTrendsResponseTest {

    @Test
    fun create() {
        val xGetTrendsResponse =
            XGetTrendsResponse.builder()
                .count(30L)
                .addTrend(
                    XGetTrendsResponse.Trend.builder()
                        .name("#AI")
                        .description("Artificial intelligence discussions")
                        .query("%23AI")
                        .rank(1L)
                        .build()
                )
                .woeid(1L)
                .build()

        assertThat(xGetTrendsResponse.count()).isEqualTo(30L)
        assertThat(xGetTrendsResponse.trends())
            .containsExactly(
                XGetTrendsResponse.Trend.builder()
                    .name("#AI")
                    .description("Artificial intelligence discussions")
                    .query("%23AI")
                    .rank(1L)
                    .build()
            )
        assertThat(xGetTrendsResponse.woeid()).isEqualTo(1L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xGetTrendsResponse =
            XGetTrendsResponse.builder()
                .count(30L)
                .addTrend(
                    XGetTrendsResponse.Trend.builder()
                        .name("#AI")
                        .description("Artificial intelligence discussions")
                        .query("%23AI")
                        .rank(1L)
                        .build()
                )
                .woeid(1L)
                .build()

        val roundtrippedXGetTrendsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(xGetTrendsResponse),
                jacksonTypeRef<XGetTrendsResponse>(),
            )

        assertThat(roundtrippedXGetTrendsResponse).isEqualTo(xGetTrendsResponse)
    }
}
