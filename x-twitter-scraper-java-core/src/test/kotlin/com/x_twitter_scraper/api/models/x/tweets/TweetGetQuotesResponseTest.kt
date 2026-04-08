// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetGetQuotesResponseTest {

    @Test
    fun create() {
        val tweetGetQuotesResponse =
            TweetGetQuotesResponse.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addTweet(
                    TweetGetQuotesResponse.Tweet.builder()
                        .id("1234567890")
                        .text("Just launched our new feature!")
                        .author(
                            TweetGetQuotesResponse.Tweet.Author.builder()
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

        assertThat(tweetGetQuotesResponse.hasNextPage()).isEqualTo(true)
        assertThat(tweetGetQuotesResponse.nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
        assertThat(tweetGetQuotesResponse.tweets())
            .containsExactly(
                TweetGetQuotesResponse.Tweet.builder()
                    .id("1234567890")
                    .text("Just launched our new feature!")
                    .author(
                        TweetGetQuotesResponse.Tweet.Author.builder()
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
        val tweetGetQuotesResponse =
            TweetGetQuotesResponse.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addTweet(
                    TweetGetQuotesResponse.Tweet.builder()
                        .id("1234567890")
                        .text("Just launched our new feature!")
                        .author(
                            TweetGetQuotesResponse.Tweet.Author.builder()
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

        val roundtrippedTweetGetQuotesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetGetQuotesResponse),
                jacksonTypeRef<TweetGetQuotesResponse>(),
            )

        assertThat(roundtrippedTweetGetQuotesResponse).isEqualTo(tweetGetQuotesResponse)
    }
}
