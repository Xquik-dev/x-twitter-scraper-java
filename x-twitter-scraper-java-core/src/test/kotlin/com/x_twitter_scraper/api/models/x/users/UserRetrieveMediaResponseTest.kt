// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveMediaResponseTest {

    @Test
    fun create() {
        val userRetrieveMediaResponse =
            UserRetrieveMediaResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addTweet(
                    UserRetrieveMediaResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            UserRetrieveMediaResponse.Tweet.Author.builder()
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

        assertThat(userRetrieveMediaResponse.hasNextPage()).isEqualTo(true)
        assertThat(userRetrieveMediaResponse.nextCursor()).isEqualTo("next_cursor")
        assertThat(userRetrieveMediaResponse.tweets())
            .containsExactly(
                UserRetrieveMediaResponse.Tweet.builder()
                    .id("id")
                    .text("text")
                    .author(
                        UserRetrieveMediaResponse.Tweet.Author.builder()
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
        val userRetrieveMediaResponse =
            UserRetrieveMediaResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addTweet(
                    UserRetrieveMediaResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            UserRetrieveMediaResponse.Tweet.Author.builder()
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

        val roundtrippedUserRetrieveMediaResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userRetrieveMediaResponse),
                jacksonTypeRef<UserRetrieveMediaResponse>(),
            )

        assertThat(roundtrippedUserRetrieveMediaResponse).isEqualTo(userRetrieveMediaResponse)
    }
}
