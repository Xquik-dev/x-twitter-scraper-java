// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetGetRepliesResponseTest {

    @Test
    fun create() {
        val tweetGetRepliesResponse =
            TweetGetRepliesResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addTweet(
                    TweetGetRepliesResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            TweetGetRepliesResponse.Tweet.Author.builder()
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

        assertThat(tweetGetRepliesResponse.hasNextPage()).isEqualTo(true)
        assertThat(tweetGetRepliesResponse.nextCursor()).isEqualTo("next_cursor")
        assertThat(tweetGetRepliesResponse.tweets())
            .containsExactly(
                TweetGetRepliesResponse.Tweet.builder()
                    .id("id")
                    .text("text")
                    .author(
                        TweetGetRepliesResponse.Tweet.Author.builder()
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
        val tweetGetRepliesResponse =
            TweetGetRepliesResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addTweet(
                    TweetGetRepliesResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            TweetGetRepliesResponse.Tweet.Author.builder()
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

        val roundtrippedTweetGetRepliesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetGetRepliesResponse),
                jacksonTypeRef<TweetGetRepliesResponse>(),
            )

        assertThat(roundtrippedTweetGetRepliesResponse).isEqualTo(tweetGetRepliesResponse)
    }
}
