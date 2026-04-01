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
                .nextCursor("next_cursor")
                .addTweet(
                    XGetHomeTimelineResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            XGetHomeTimelineResponse.Tweet.Author.builder()
                                .id("id")
                                .name("name")
                                .username("username")
                                .verified(true)
                                .build()
                        )
                        .bookmarkCount(0L)
                        .createdAt("createdAt")
                        .likeCount(0L)
                        .quoteCount(0L)
                        .replyCount(0L)
                        .retweetCount(0L)
                        .viewCount(0L)
                        .build()
                )
                .build()

        assertThat(xGetHomeTimelineResponse.hasNextPage()).isEqualTo(true)
        assertThat(xGetHomeTimelineResponse.nextCursor()).isEqualTo("next_cursor")
        assertThat(xGetHomeTimelineResponse.tweets())
            .containsExactly(
                XGetHomeTimelineResponse.Tweet.builder()
                    .id("id")
                    .text("text")
                    .author(
                        XGetHomeTimelineResponse.Tweet.Author.builder()
                            .id("id")
                            .name("name")
                            .username("username")
                            .verified(true)
                            .build()
                    )
                    .bookmarkCount(0L)
                    .createdAt("createdAt")
                    .likeCount(0L)
                    .quoteCount(0L)
                    .replyCount(0L)
                    .retweetCount(0L)
                    .viewCount(0L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xGetHomeTimelineResponse =
            XGetHomeTimelineResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addTweet(
                    XGetHomeTimelineResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            XGetHomeTimelineResponse.Tweet.Author.builder()
                                .id("id")
                                .name("name")
                                .username("username")
                                .verified(true)
                                .build()
                        )
                        .bookmarkCount(0L)
                        .createdAt("createdAt")
                        .likeCount(0L)
                        .quoteCount(0L)
                        .replyCount(0L)
                        .retweetCount(0L)
                        .viewCount(0L)
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
