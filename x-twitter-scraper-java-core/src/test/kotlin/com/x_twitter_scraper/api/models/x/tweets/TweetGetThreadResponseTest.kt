// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetGetThreadResponseTest {

    @Test
    fun create() {
        val tweetGetThreadResponse =
            TweetGetThreadResponse.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addTweet(
                    TweetGetThreadResponse.Tweet.builder()
                        .id("1234567890")
                        .text("Just launched our new feature!")
                        .author(
                            TweetGetThreadResponse.Tweet.Author.builder()
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

        assertThat(tweetGetThreadResponse.hasNextPage()).isEqualTo(true)
        assertThat(tweetGetThreadResponse.nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
        assertThat(tweetGetThreadResponse.tweets())
            .containsExactly(
                TweetGetThreadResponse.Tweet.builder()
                    .id("1234567890")
                    .text("Just launched our new feature!")
                    .author(
                        TweetGetThreadResponse.Tweet.Author.builder()
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
        val tweetGetThreadResponse =
            TweetGetThreadResponse.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addTweet(
                    TweetGetThreadResponse.Tweet.builder()
                        .id("1234567890")
                        .text("Just launched our new feature!")
                        .author(
                            TweetGetThreadResponse.Tweet.Author.builder()
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

        val roundtrippedTweetGetThreadResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetGetThreadResponse),
                jacksonTypeRef<TweetGetThreadResponse>(),
            )

        assertThat(roundtrippedTweetGetThreadResponse).isEqualTo(tweetGetThreadResponse)
    }
}
