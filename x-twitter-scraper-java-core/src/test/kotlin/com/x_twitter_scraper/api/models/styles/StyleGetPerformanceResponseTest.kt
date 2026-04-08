// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.styles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StyleGetPerformanceResponseTest {

    @Test
    fun create() {
        val styleGetPerformanceResponse =
            StyleGetPerformanceResponse.builder()
                .tweetCount(5L)
                .addTweet(
                    StyleGetPerformanceResponse.Tweet.builder()
                        .id("1234567890")
                        .text("Excited to share our latest research findings.")
                        .createdAt("2025-01-15T12:00:00Z")
                        .likeCount(120L)
                        .replyCount(8L)
                        .retweetCount(15L)
                        .viewCount(5000L)
                        .build()
                )
                .xUsername("elonmusk")
                .build()

        assertThat(styleGetPerformanceResponse.tweetCount()).isEqualTo(5L)
        assertThat(styleGetPerformanceResponse.tweets())
            .containsExactly(
                StyleGetPerformanceResponse.Tweet.builder()
                    .id("1234567890")
                    .text("Excited to share our latest research findings.")
                    .createdAt("2025-01-15T12:00:00Z")
                    .likeCount(120L)
                    .replyCount(8L)
                    .retweetCount(15L)
                    .viewCount(5000L)
                    .build()
            )
        assertThat(styleGetPerformanceResponse.xUsername()).isEqualTo("elonmusk")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val styleGetPerformanceResponse =
            StyleGetPerformanceResponse.builder()
                .tweetCount(5L)
                .addTweet(
                    StyleGetPerformanceResponse.Tweet.builder()
                        .id("1234567890")
                        .text("Excited to share our latest research findings.")
                        .createdAt("2025-01-15T12:00:00Z")
                        .likeCount(120L)
                        .replyCount(8L)
                        .retweetCount(15L)
                        .viewCount(5000L)
                        .build()
                )
                .xUsername("elonmusk")
                .build()

        val roundtrippedStyleGetPerformanceResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(styleGetPerformanceResponse),
                jacksonTypeRef<StyleGetPerformanceResponse>(),
            )

        assertThat(roundtrippedStyleGetPerformanceResponse).isEqualTo(styleGetPerformanceResponse)
    }
}
