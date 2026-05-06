// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserProfileTest {

    @Test
    fun create() {
        val userProfile =
            UserProfile.builder()
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

        assertThat(userProfile.id()).isEqualTo("9876543210")
        assertThat(userProfile.name()).isEqualTo("Elon Musk")
        assertThat(userProfile.username()).isEqualTo("elonmusk")
        assertThat(userProfile.createdAt()).contains("2009-06-02T20:12:29Z")
        assertThat(userProfile.description()).contains("CEO of Tesla, SpaceX, and X")
        assertThat(userProfile.followers()).contains(150000000L)
        assertThat(userProfile.following()).contains(500L)
        assertThat(userProfile.location()).contains("Austin, TX")
        assertThat(userProfile.profilePicture())
            .contains("https://pbs.twimg.com/profile_images/example.jpg")
        assertThat(userProfile.statusesCount()).contains(35000L)
        assertThat(userProfile.verified()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userProfile =
            UserProfile.builder()
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

        val roundtrippedUserProfile =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userProfile),
                jacksonTypeRef<UserProfile>(),
            )

        assertThat(roundtrippedUserProfile).isEqualTo(userProfile)
    }
}
