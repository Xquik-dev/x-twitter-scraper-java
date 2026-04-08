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
                .nextCursor("DAACCgACGRElMJcAAA")
                .addUser(
                    UserRetrieveFollowersYouKnowResponse.User.builder()
                        .id("9876543210")
                        .name("Elon Musk")
                        .username("elonmusk")
                        .createdAt("2009-06-02T20:12:29Z")
                        .description("CEO of Tesla, SpaceX, and X")
                        .followers(150000000L)
                        .following(500L)
                        .location("Austin, TX")
                        .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                        .statusesCount(35000L)
                        .verified(true)
                        .build()
                )
                .build()

        assertThat(userRetrieveFollowersYouKnowResponse.hasNextPage()).isEqualTo(true)
        assertThat(userRetrieveFollowersYouKnowResponse.nextCursor())
            .isEqualTo("DAACCgACGRElMJcAAA")
        assertThat(userRetrieveFollowersYouKnowResponse.users())
            .containsExactly(
                UserRetrieveFollowersYouKnowResponse.User.builder()
                    .id("9876543210")
                    .name("Elon Musk")
                    .username("elonmusk")
                    .createdAt("2009-06-02T20:12:29Z")
                    .description("CEO of Tesla, SpaceX, and X")
                    .followers(150000000L)
                    .following(500L)
                    .location("Austin, TX")
                    .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                    .statusesCount(35000L)
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
                .nextCursor("DAACCgACGRElMJcAAA")
                .addUser(
                    UserRetrieveFollowersYouKnowResponse.User.builder()
                        .id("9876543210")
                        .name("Elon Musk")
                        .username("elonmusk")
                        .createdAt("2009-06-02T20:12:29Z")
                        .description("CEO of Tesla, SpaceX, and X")
                        .followers(150000000L)
                        .following(500L)
                        .location("Austin, TX")
                        .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                        .statusesCount(35000L)
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
