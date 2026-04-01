// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetGetRetweetersResponseTest {

    @Test
    fun create() {
        val tweetGetRetweetersResponse =
            TweetGetRetweetersResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addUser(
                    TweetGetRetweetersResponse.User.builder()
                        .id("id")
                        .name("name")
                        .username("username")
                        .createdAt("createdAt")
                        .description("description")
                        .followers(0L)
                        .following(0L)
                        .location("location")
                        .profilePicture("profilePicture")
                        .statusesCount(0L)
                        .verified(true)
                        .build()
                )
                .build()

        assertThat(tweetGetRetweetersResponse.hasNextPage()).isEqualTo(true)
        assertThat(tweetGetRetweetersResponse.nextCursor()).isEqualTo("next_cursor")
        assertThat(tweetGetRetweetersResponse.users())
            .containsExactly(
                TweetGetRetweetersResponse.User.builder()
                    .id("id")
                    .name("name")
                    .username("username")
                    .createdAt("createdAt")
                    .description("description")
                    .followers(0L)
                    .following(0L)
                    .location("location")
                    .profilePicture("profilePicture")
                    .statusesCount(0L)
                    .verified(true)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetGetRetweetersResponse =
            TweetGetRetweetersResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addUser(
                    TweetGetRetweetersResponse.User.builder()
                        .id("id")
                        .name("name")
                        .username("username")
                        .createdAt("createdAt")
                        .description("description")
                        .followers(0L)
                        .following(0L)
                        .location("location")
                        .profilePicture("profilePicture")
                        .statusesCount(0L)
                        .verified(true)
                        .build()
                )
                .build()

        val roundtrippedTweetGetRetweetersResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetGetRetweetersResponse),
                jacksonTypeRef<TweetGetRetweetersResponse>(),
            )

        assertThat(roundtrippedTweetGetRetweetersResponse).isEqualTo(tweetGetRetweetersResponse)
    }
}
