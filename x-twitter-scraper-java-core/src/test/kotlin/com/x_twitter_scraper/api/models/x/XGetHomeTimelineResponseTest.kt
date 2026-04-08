// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetHomeTimelineResponseTest {

    @Test
    fun create() {
        val xGetHomeTimelineResponse =
            XGetHomeTimelineResponse.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addTweet(
                    XGetHomeTimelineResponse.Tweet.builder()
                        .id("1234567890")
                        .text("Just launched our new feature!")
                        .author(
                            XGetHomeTimelineResponse.Tweet.Author.builder()
                                .id("9876543210")
                                .name("Elon Musk")
                                .username("elonmusk")
                                .verified(true)
                                .build()
                        )
                        .bookmarkCount(2L)
                        .createdAt("2025-01-15T12:00:00Z")
                        .isNoteTweet(false)
                        .likeCount(42L)
                        .quoteCount(1L)
                        .replyCount(3L)
                        .retweetCount(5L)
                        .viewCount(1500L)
                        .build()
                )
                .build()

        assertThat(xGetHomeTimelineResponse.hasNextPage()).isEqualTo(true)
        assertThat(xGetHomeTimelineResponse.nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
        assertThat(xGetHomeTimelineResponse.tweets())
            .containsExactly(
                XGetHomeTimelineResponse.Tweet.builder()
                    .id("1234567890")
                    .text("Just launched our new feature!")
                    .author(
                        XGetHomeTimelineResponse.Tweet.Author.builder()
                            .id("9876543210")
                            .name("Elon Musk")
                            .username("elonmusk")
                            .verified(true)
                            .build()
                    )
                    .bookmarkCount(2L)
                    .createdAt("2025-01-15T12:00:00Z")
                    .isNoteTweet(false)
                    .likeCount(42L)
                    .quoteCount(1L)
                    .replyCount(3L)
                    .retweetCount(5L)
                    .viewCount(1500L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xGetHomeTimelineResponse =
            XGetHomeTimelineResponse.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addTweet(
                    XGetHomeTimelineResponse.Tweet.builder()
                        .id("1234567890")
                        .text("Just launched our new feature!")
                        .author(
                            XGetHomeTimelineResponse.Tweet.Author.builder()
                                .id("9876543210")
                                .name("Elon Musk")
                                .username("elonmusk")
                                .verified(true)
                                .build()
                        )
                        .bookmarkCount(2L)
                        .createdAt("2025-01-15T12:00:00Z")
                        .isNoteTweet(false)
                        .likeCount(42L)
                        .quoteCount(1L)
                        .replyCount(3L)
                        .retweetCount(5L)
                        .viewCount(1500L)
                        .build()
                )
                .build()

        val roundtrippedXGetHomeTimelineResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(xGetHomeTimelineResponse),
                jacksonTypeRef<XGetHomeTimelineResponse>(),
            )

        assertThat(roundtrippedXGetHomeTimelineResponse).isEqualTo(xGetHomeTimelineResponse)
    }
}
