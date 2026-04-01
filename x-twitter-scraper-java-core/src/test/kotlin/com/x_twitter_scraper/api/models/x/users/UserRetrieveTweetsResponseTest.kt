// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveTweetsResponseTest {

    @Test
    fun create() {
        val userRetrieveTweetsResponse =
            UserRetrieveTweetsResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addTweet(
                    UserRetrieveTweetsResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            UserRetrieveTweetsResponse.Tweet.Author.builder()
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

        assertThat(userRetrieveTweetsResponse.hasNextPage()).isEqualTo(true)
        assertThat(userRetrieveTweetsResponse.nextCursor()).isEqualTo("next_cursor")
        assertThat(userRetrieveTweetsResponse.tweets())
            .containsExactly(
                UserRetrieveTweetsResponse.Tweet.builder()
                    .id("id")
                    .text("text")
                    .author(
                        UserRetrieveTweetsResponse.Tweet.Author.builder()
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
        val userRetrieveTweetsResponse =
            UserRetrieveTweetsResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addTweet(
                    UserRetrieveTweetsResponse.Tweet.builder()
                        .id("id")
                        .text("text")
                        .author(
                            UserRetrieveTweetsResponse.Tweet.Author.builder()
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

        val roundtrippedUserRetrieveTweetsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userRetrieveTweetsResponse),
                jacksonTypeRef<UserRetrieveTweetsResponse>(),
            )

        assertThat(roundtrippedUserRetrieveTweetsResponse).isEqualTo(userRetrieveTweetsResponse)
    }
}
