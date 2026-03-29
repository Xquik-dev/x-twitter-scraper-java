// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveLikesResponseTest {

    @Test
    fun create() {
        val userRetrieveLikesResponse =
            UserRetrieveLikesResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addTweet(
                    UserRetrieveLikesResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            UserRetrieveLikesResponse.Tweet.Author.builder()
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

        assertThat(userRetrieveLikesResponse.hasNextPage()).isEqualTo(true)
        assertThat(userRetrieveLikesResponse.nextCursor()).isEqualTo("next_cursor")
        assertThat(userRetrieveLikesResponse.tweets())
            .containsExactly(
                UserRetrieveLikesResponse.Tweet.builder()
                    .id("id")
                    .text("text")
                    .author(
                        UserRetrieveLikesResponse.Tweet.Author.builder()
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
        val userRetrieveLikesResponse =
            UserRetrieveLikesResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addTweet(
                    UserRetrieveLikesResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            UserRetrieveLikesResponse.Tweet.Author.builder()
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

        val roundtrippedUserRetrieveLikesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userRetrieveLikesResponse),
                jacksonTypeRef<UserRetrieveLikesResponse>(),
            )

        assertThat(roundtrippedUserRetrieveLikesResponse).isEqualTo(userRetrieveLikesResponse)
    }
}
