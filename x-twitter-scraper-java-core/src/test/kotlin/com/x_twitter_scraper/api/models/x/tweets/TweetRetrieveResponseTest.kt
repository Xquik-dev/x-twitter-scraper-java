// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetRetrieveResponseTest {

    @Test
    fun create() {
        val tweetRetrieveResponse =
            TweetRetrieveResponse.builder()
                .tweet(
                    TweetDetail.builder()
                        .id("id")
                        .bookmarkCount(0L)
                        .likeCount(0L)
                        .quoteCount(0L)
                        .replyCount(0L)
                        .retweetCount(0L)
                        .text("text")
                        .viewCount(0L)
                        .createdAt("createdAt")
                        .build()
                )
                .author(
                    TweetAuthor.builder()
                        .id("id")
                        .followers(0L)
                        .username("username")
                        .verified(true)
                        .profilePicture("profilePicture")
                        .build()
                )
                .build()

        assertThat(tweetRetrieveResponse.tweet())
            .isEqualTo(
                TweetDetail.builder()
                    .id("id")
                    .bookmarkCount(0L)
                    .likeCount(0L)
                    .quoteCount(0L)
                    .replyCount(0L)
                    .retweetCount(0L)
                    .text("text")
                    .viewCount(0L)
                    .createdAt("createdAt")
                    .build()
            )
        assertThat(tweetRetrieveResponse.author())
            .contains(
                TweetAuthor.builder()
                    .id("id")
                    .followers(0L)
                    .username("username")
                    .verified(true)
                    .profilePicture("profilePicture")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetRetrieveResponse =
            TweetRetrieveResponse.builder()
                .tweet(
                    TweetDetail.builder()
                        .id("id")
                        .bookmarkCount(0L)
                        .likeCount(0L)
                        .quoteCount(0L)
                        .replyCount(0L)
                        .retweetCount(0L)
                        .text("text")
                        .viewCount(0L)
                        .createdAt("createdAt")
                        .build()
                )
                .author(
                    TweetAuthor.builder()
                        .id("id")
                        .followers(0L)
                        .username("username")
                        .verified(true)
                        .profilePicture("profilePicture")
                        .build()
                )
                .build()

        val roundtrippedTweetRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetRetrieveResponse),
                jacksonTypeRef<TweetRetrieveResponse>(),
            )

        assertThat(roundtrippedTweetRetrieveResponse).isEqualTo(tweetRetrieveResponse)
    }
}
