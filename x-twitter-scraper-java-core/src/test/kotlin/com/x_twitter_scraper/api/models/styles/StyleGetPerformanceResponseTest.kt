// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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

    @Test
    fun additionalTweetFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json = """{"quoteCount":1,"bookmarkCount":1}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<StyleGetPerformanceResponse.Tweet>())

        assertThat(model.quoteCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("quoteCount")
        assertThat(model.bookmarkCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("bookmarkCount")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<StyleGetPerformanceResponse.Tweet>(),
                )
            )
            .isEqualTo(model)
    }
}
