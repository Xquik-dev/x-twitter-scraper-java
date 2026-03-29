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
                .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .isOwnAccount(true)
                .tweetCount(0L)
                .addTweet(
                    StyleAnalyzeResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .authorUsername("authorUsername")
                        .createdAt("createdAt")
                        .build()
                )
                .xUsername("xUsername")
                .build()

        assertThat(styleAnalyzeResponse.fetchedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(styleAnalyzeResponse.isOwnAccount()).isEqualTo(true)
        assertThat(styleAnalyzeResponse.tweetCount()).isEqualTo(0L)
        assertThat(styleAnalyzeResponse.tweets())
            .containsExactly(
                StyleAnalyzeResponse.Tweet.builder()
                    .id("id")
                    .text("text")
                    .authorUsername("authorUsername")
                    .createdAt("createdAt")
                    .build()
            )
        assertThat(styleAnalyzeResponse.xUsername()).isEqualTo("xUsername")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val styleAnalyzeResponse =
            StyleAnalyzeResponse.builder()
                .fetchedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .isOwnAccount(true)
                .tweetCount(0L)
                .addTweet(
                    StyleAnalyzeResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .authorUsername("authorUsername")
                        .createdAt("createdAt")
                        .build()
                )
                .xUsername("xUsername")
                .build()

        val roundtrippedStyleAnalyzeResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(styleAnalyzeResponse),
                jacksonTypeRef<StyleAnalyzeResponse>(),
            )

        assertThat(roundtrippedStyleAnalyzeResponse).isEqualTo(styleAnalyzeResponse)
    }
}
