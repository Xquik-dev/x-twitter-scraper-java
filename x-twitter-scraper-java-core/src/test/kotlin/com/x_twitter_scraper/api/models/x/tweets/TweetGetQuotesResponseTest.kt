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
                .nextCursor("next_cursor")
                .addTweet(
                    TweetGetQuotesResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            TweetGetQuotesResponse.Tweet.Author.builder()
                                .id("id")
                                .name("name")
                                .username("username")
                                .verified(true)
                                .build()
                        )
                        .bookmarkCount(0L)
                        .createdAt("createdAt")
                        .isNoteTweet(true)
                        .likeCount(0L)
                        .quoteCount(0L)
                        .replyCount(0L)
                        .retweetCount(0L)
                        .viewCount(0L)
                        .build()
                )
                .build()

        assertThat(tweetGetQuotesResponse.hasNextPage()).isEqualTo(true)
        assertThat(tweetGetQuotesResponse.nextCursor()).isEqualTo("next_cursor")
        assertThat(tweetGetQuotesResponse.tweets())
            .containsExactly(
                TweetGetQuotesResponse.Tweet.builder()
                    .id("id")
                    .text("text")
                    .author(
                        TweetGetQuotesResponse.Tweet.Author.builder()
                            .id("id")
                            .name("name")
                            .username("username")
                            .verified(true)
                            .build()
                    )
                    .bookmarkCount(0L)
                    .createdAt("createdAt")
                    .isNoteTweet(true)
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
        val tweetGetQuotesResponse =
            TweetGetQuotesResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addTweet(
                    TweetGetQuotesResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            TweetGetQuotesResponse.Tweet.Author.builder()
                                .id("id")
                                .name("name")
                                .username("username")
                                .verified(true)
                                .build()
                        )
                        .bookmarkCount(0L)
                        .createdAt("createdAt")
                        .isNoteTweet(true)
                        .likeCount(0L)
                        .quoteCount(0L)
                        .replyCount(0L)
                        .retweetCount(0L)
                        .viewCount(0L)
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
