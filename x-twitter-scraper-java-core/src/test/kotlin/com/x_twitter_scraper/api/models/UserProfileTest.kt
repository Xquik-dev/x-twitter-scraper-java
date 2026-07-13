// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
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
                .automatedBy("example_user")
                .canDm(false)
                .communityRole("Member")
                .coverPicture("https://pbs.twimg.com/profile_banners/example.jpg")
                .createdAt("2009-06-02T20:12:29Z")
                .description("CEO of Tesla, SpaceX, and X")
                .favouritesCount(18000L)
                .followers(150000000L)
                .following(500L)
                .hasCustomTimelines(true)
                .isAutomated(false)
                .isBlueVerified(true)
                .isTranslator(false)
                .isVerified(true)
                .location("Austin, TX")
                .mediaCount(1200L)
                .addPinnedTweetId("1234567890")
                .possiblySensitive(false)
                .profileBio(
                    UserProfile.ProfileBio.builder()
                        .putAdditionalProperty("description", JsonValue.from("bar"))
                        .putAdditionalProperty("entities", JsonValue.from("bar"))
                        .build()
                )
                .profileBannerUrl("https://pbs.twimg.com/profile_banners/example.jpg")
                .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                .protected_(false)
                .statusesCount(35000L)
                .unavailable(false)
                .unavailableReason("suspended")
                .url("https://xquik.com")
                .verified(true)
                .verifiedType("Business")
                .viewerFollowedBy(false)
                .viewerFollowing(true)
                .addWithheldInCountry("DE")
                .build()

        assertThat(userProfile.id()).isEqualTo("9876543210")
        assertThat(userProfile.name()).isEqualTo("Elon Musk")
        assertThat(userProfile.username()).isEqualTo("elonmusk")
        assertThat(userProfile.automatedBy()).contains("example_user")
        assertThat(userProfile.canDm()).contains(false)
        assertThat(userProfile.communityRole()).contains("Member")
        assertThat(userProfile.coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/example.jpg")
        assertThat(userProfile.createdAt()).contains("2009-06-02T20:12:29Z")
        assertThat(userProfile.description()).contains("CEO of Tesla, SpaceX, and X")
        assertThat(userProfile.favouritesCount()).contains(18000L)
        assertThat(userProfile.followers()).contains(150000000L)
        assertThat(userProfile.following()).contains(500L)
        assertThat(userProfile.hasCustomTimelines()).contains(true)
        assertThat(userProfile.isAutomated()).contains(false)
        assertThat(userProfile.isBlueVerified()).contains(true)
        assertThat(userProfile.isTranslator()).contains(false)
        assertThat(userProfile.isVerified()).contains(true)
        assertThat(userProfile.location()).contains("Austin, TX")
        assertThat(userProfile.mediaCount()).contains(1200L)
        assertThat(userProfile.pinnedTweetIds().getOrNull()).containsExactly("1234567890")
        assertThat(userProfile.possiblySensitive()).contains(false)
        assertThat(userProfile.profileBio())
            .contains(
                UserProfile.ProfileBio.builder()
                    .putAdditionalProperty("description", JsonValue.from("bar"))
                    .putAdditionalProperty("entities", JsonValue.from("bar"))
                    .build()
            )
        assertThat(userProfile.profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/example.jpg")
        assertThat(userProfile.profilePicture())
            .contains("https://pbs.twimg.com/profile_images/example.jpg")
        assertThat(userProfile.protected_()).contains(false)
        assertThat(userProfile.statusesCount()).contains(35000L)
        assertThat(userProfile.unavailable()).contains(false)
        assertThat(userProfile.unavailableReason()).contains("suspended")
        assertThat(userProfile.url()).contains("https://xquik.com")
        assertThat(userProfile.verified()).contains(true)
        assertThat(userProfile.verifiedType()).contains("Business")
        assertThat(userProfile.viewerFollowedBy()).contains(false)
        assertThat(userProfile.viewerFollowing()).contains(true)
        assertThat(userProfile.withheldInCountries().getOrNull()).containsExactly("DE")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userProfile =
            UserProfile.builder()
                .id("9876543210")
                .name("Elon Musk")
                .username("elonmusk")
                .automatedBy("example_user")
                .canDm(false)
                .communityRole("Member")
                .coverPicture("https://pbs.twimg.com/profile_banners/example.jpg")
                .createdAt("2009-06-02T20:12:29Z")
                .description("CEO of Tesla, SpaceX, and X")
                .favouritesCount(18000L)
                .followers(150000000L)
                .following(500L)
                .hasCustomTimelines(true)
                .isAutomated(false)
                .isBlueVerified(true)
                .isTranslator(false)
                .isVerified(true)
                .location("Austin, TX")
                .mediaCount(1200L)
                .addPinnedTweetId("1234567890")
                .possiblySensitive(false)
                .profileBio(
                    UserProfile.ProfileBio.builder()
                        .putAdditionalProperty("description", JsonValue.from("bar"))
                        .putAdditionalProperty("entities", JsonValue.from("bar"))
                        .build()
                )
                .profileBannerUrl("https://pbs.twimg.com/profile_banners/example.jpg")
                .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                .protected_(false)
                .statusesCount(35000L)
                .unavailable(false)
                .unavailableReason("suspended")
                .url("https://xquik.com")
                .verified(true)
                .verifiedType("Business")
                .viewerFollowedBy(false)
                .viewerFollowing(true)
                .addWithheldInCountry("DE")
                .build()

        val roundtrippedUserProfile =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userProfile),
                jacksonTypeRef<UserProfile>(),
            )

        assertThat(roundtrippedUserProfile).isEqualTo(userProfile)
    }
}
