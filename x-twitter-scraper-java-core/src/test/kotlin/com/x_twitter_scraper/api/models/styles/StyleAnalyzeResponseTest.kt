// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.styles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StyleAnalyzeResponseTest {

    @Test
    fun create() {
        val styleAnalyzeResponse =
            StyleAnalyzeResponse.builder()
                .fetchedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .isOwnAccount(true)
                .tweetCount(50L)
                .addTweet(
                    StyleAnalyzeResponse.Tweet.builder()
                        .id("1234567890")
                        .text("Just launched our new feature!")
                        .authorUsername("elonmusk")
                        .createdAt("2025-01-15T12:00:00Z")
                        .build()
                )
                .xUsername("elonmusk")
                .build()

        assertThat(styleAnalyzeResponse.fetchedAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(styleAnalyzeResponse.isOwnAccount()).isEqualTo(true)
        assertThat(styleAnalyzeResponse.tweetCount()).isEqualTo(50L)
        assertThat(styleAnalyzeResponse.tweets())
            .containsExactly(
                StyleAnalyzeResponse.Tweet.builder()
                    .id("1234567890")
                    .text("Just launched our new feature!")
                    .authorUsername("elonmusk")
                    .createdAt("2025-01-15T12:00:00Z")
                    .build()
            )
        assertThat(styleAnalyzeResponse.xUsername()).isEqualTo("elonmusk")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val styleAnalyzeResponse =
            StyleAnalyzeResponse.builder()
                .fetchedAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .isOwnAccount(true)
                .tweetCount(50L)
                .addTweet(
                    StyleAnalyzeResponse.Tweet.builder()
                        .id("1234567890")
                        .text("Just launched our new feature!")
                        .authorUsername("elonmusk")
                        .createdAt("2025-01-15T12:00:00Z")
                        .build()
                )
                .xUsername("elonmusk")
                .build()

        val roundtrippedStyleAnalyzeResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(styleAnalyzeResponse),
                jacksonTypeRef<StyleAnalyzeResponse>(),
            )

        assertThat(roundtrippedStyleAnalyzeResponse).isEqualTo(styleAnalyzeResponse)
    }
}
