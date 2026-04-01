// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetGetFavoritersResponseTest {

    @Test
    fun create() {
        val tweetGetFavoritersResponse =
            TweetGetFavoritersResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addUser(
                    TweetGetFavoritersResponse.User.builder()
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

        assertThat(tweetGetFavoritersResponse.hasNextPage()).isEqualTo(true)
        assertThat(tweetGetFavoritersResponse.nextCursor()).isEqualTo("next_cursor")
        assertThat(tweetGetFavoritersResponse.users())
            .containsExactly(
                TweetGetFavoritersResponse.User.builder()
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
        val tweetGetFavoritersResponse =
            TweetGetFavoritersResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addUser(
                    TweetGetFavoritersResponse.User.builder()
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

        val roundtrippedTweetGetFavoritersResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetGetFavoritersResponse),
                jacksonTypeRef<TweetGetFavoritersResponse>(),
            )

        assertThat(roundtrippedTweetGetFavoritersResponse).isEqualTo(tweetGetFavoritersResponse)
    }
}
