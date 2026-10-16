// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
                        .promotedContent("promotedContent")
                        .query("%23AI")
                        .rank(1L)
                        .tweetVolume(250000L)
                        .url("https://example.com")
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
                    .promotedContent("promotedContent")
                    .query("%23AI")
                    .rank(1L)
                    .tweetVolume(250000L)
                    .url("https://example.com")
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
                        .promotedContent("promotedContent")
                        .query("%23AI")
                        .rank(1L)
                        .tweetVolume(250000L)
                        .url("https://example.com")
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

    @Test
    fun readsEveryFieldTheSpecDescribes() {
        val trendListResponse =
            jsonMapper()
                .readValue(
                    """
                    {
                      "trends": [
                        {
                          "name": "#AI",
                          "description": "Artificial intelligence discussions",
                          "query": "%23AI",
                          "promotedContent": "promotedContent-value",
                          "rank": 1,
                          "tweetVolume": 250000,
                          "url": "https://xquik.com/url"
                        }
                      ],
                      "total": 30,
                      "woeid": 1
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<TrendListResponse>(),
                )

        trendListResponse.validate()
        assertThat(trendListResponse.total()).isEqualTo(30L)
        assertThat(trendListResponse.trends()).hasSize(1)
        assertThat(trendListResponse.trends()[0].name()).isEqualTo("#AI")
        assertThat(trendListResponse.trends()[0].description())
            .contains("Artificial intelligence discussions")
        assertThat(trendListResponse.trends()[0].promotedContent())
            .contains("promotedContent-value")
        assertThat(trendListResponse.trends()[0].query()).contains("%23AI")
        assertThat(trendListResponse.trends()[0].rank()).contains(1L)
        assertThat(trendListResponse.trends()[0].tweetVolume()).contains(250000L)
        assertThat(trendListResponse.trends()[0].url()).contains("https://xquik.com/url")
        assertThat(trendListResponse.trends()[0]._additionalProperties()).isEmpty()
        assertThat(trendListResponse.woeid()).isEqualTo(1L)
        assertThat(trendListResponse._additionalProperties()).isEmpty()
    }
}
