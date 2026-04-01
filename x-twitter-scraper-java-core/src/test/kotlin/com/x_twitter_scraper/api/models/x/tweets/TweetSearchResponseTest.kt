// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetSearchResponseTest {

    @Test
    fun create() {
        val tweetSearchResponse =
            TweetSearchResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addTweet(
                    TweetSearchResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            TweetSearchResponse.Tweet.Author.builder()
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

        assertThat(tweetSearchResponse.hasNextPage()).isEqualTo(true)
        assertThat(tweetSearchResponse.nextCursor()).isEqualTo("next_cursor")
        assertThat(tweetSearchResponse.tweets())
            .containsExactly(
                TweetSearchResponse.Tweet.builder()
                    .id("id")
                    .text("text")
                    .author(
                        TweetSearchResponse.Tweet.Author.builder()
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
        val tweetSearchResponse =
            TweetSearchResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addTweet(
                    TweetSearchResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            TweetSearchResponse.Tweet.Author.builder()
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

        val roundtrippedTweetSearchResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetSearchResponse),
                jacksonTypeRef<TweetSearchResponse>(),
            )

        assertThat(roundtrippedTweetSearchResponse).isEqualTo(tweetSearchResponse)
    }
}
