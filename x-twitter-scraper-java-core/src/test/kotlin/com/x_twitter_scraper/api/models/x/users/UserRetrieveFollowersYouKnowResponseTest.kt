// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveFollowersYouKnowResponseTest {

    @Test
    fun create() {
        val userRetrieveFollowersYouKnowResponse =
            UserRetrieveFollowersYouKnowResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addUser(
                    UserRetrieveFollowersYouKnowResponse.User.builder()
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

        assertThat(userRetrieveFollowersYouKnowResponse.hasNextPage()).isEqualTo(true)
        assertThat(userRetrieveFollowersYouKnowResponse.nextCursor()).isEqualTo("next_cursor")
        assertThat(userRetrieveFollowersYouKnowResponse.users())
            .containsExactly(
                UserRetrieveFollowersYouKnowResponse.User.builder()
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
        val userRetrieveFollowersYouKnowResponse =
            UserRetrieveFollowersYouKnowResponse.builder()
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .addUser(
                    UserRetrieveFollowersYouKnowResponse.User.builder()
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

        val roundtrippedUserRetrieveFollowersYouKnowResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userRetrieveFollowersYouKnowResponse),
                jacksonTypeRef<UserRetrieveFollowersYouKnowResponse>(),
            )

        assertThat(roundtrippedUserRetrieveFollowersYouKnowResponse)
            .isEqualTo(userRetrieveFollowersYouKnowResponse)
    }
}
