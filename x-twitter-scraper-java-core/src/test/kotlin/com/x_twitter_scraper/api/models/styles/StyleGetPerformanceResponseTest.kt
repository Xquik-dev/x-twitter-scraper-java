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
                .tweetCount(0L)
                .addTweet(
                    StyleGetPerformanceResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .createdAt("createdAt")
                        .likeCount(0L)
                        .replyCount(0L)
                        .retweetCount(0L)
                        .viewCount(0L)
                        .build()
                )
                .xUsername("xUsername")
                .build()

        assertThat(styleGetPerformanceResponse.tweetCount()).isEqualTo(0L)
        assertThat(styleGetPerformanceResponse.tweets())
            .containsExactly(
                StyleGetPerformanceResponse.Tweet.builder()
                    .id("id")
                    .text("text")
                    .createdAt("createdAt")
                    .likeCount(0L)
                    .replyCount(0L)
                    .retweetCount(0L)
                    .viewCount(0L)
                    .build()
            )
        assertThat(styleGetPerformanceResponse.xUsername()).isEqualTo("xUsername")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val styleGetPerformanceResponse =
            StyleGetPerformanceResponse.builder()
                .tweetCount(0L)
                .addTweet(
                    StyleGetPerformanceResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .createdAt("createdAt")
                        .likeCount(0L)
                        .replyCount(0L)
                        .retweetCount(0L)
                        .viewCount(0L)
                        .build()
                )
                .xUsername("xUsername")
                .build()

        val roundtrippedStyleGetPerformanceResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(styleGetPerformanceResponse),
                jacksonTypeRef<StyleGetPerformanceResponse>(),
            )

        assertThat(roundtrippedStyleGetPerformanceResponse).isEqualTo(styleGetPerformanceResponse)
    }
}
