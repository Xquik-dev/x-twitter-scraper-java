// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.UserProfile
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetAuthorTest {

    @Test
    fun create() {
        val tweetAuthor =
            TweetAuthor.builder()
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

        assertThat(tweetAuthor.id()).isEqualTo("9876543210")
        assertThat(tweetAuthor.name()).isEqualTo("Elon Musk")
        assertThat(tweetAuthor.username()).isEqualTo("elonmusk")
        assertThat(tweetAuthor.automatedBy()).contains("example_user")
        assertThat(tweetAuthor.canDm()).contains(false)
        assertThat(tweetAuthor.communityRole()).contains("Member")
        assertThat(tweetAuthor.coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/example.jpg")
        assertThat(tweetAuthor.createdAt()).contains("2009-06-02T20:12:29Z")
        assertThat(tweetAuthor.description()).contains("CEO of Tesla, SpaceX, and X")
        assertThat(tweetAuthor.favouritesCount()).contains(18000L)
        assertThat(tweetAuthor.followers()).contains(150000000L)
        assertThat(tweetAuthor.following()).contains(500L)
        assertThat(tweetAuthor.hasCustomTimelines()).contains(true)
        assertThat(tweetAuthor.isAutomated()).contains(false)
        assertThat(tweetAuthor.isBlueVerified()).contains(true)
        assertThat(tweetAuthor.isTranslator()).contains(false)
        assertThat(tweetAuthor.isVerified()).contains(true)
        assertThat(tweetAuthor.location()).contains("Austin, TX")
        assertThat(tweetAuthor.mediaCount()).contains(1200L)
        assertThat(tweetAuthor.pinnedTweetIds().getOrNull()).containsExactly("1234567890")
        assertThat(tweetAuthor.possiblySensitive()).contains(false)
        assertThat(tweetAuthor.profileBio())
            .contains(
                UserProfile.ProfileBio.builder()
                    .putAdditionalProperty("description", JsonValue.from("bar"))
                    .putAdditionalProperty("entities", JsonValue.from("bar"))
                    .build()
            )
        assertThat(tweetAuthor.profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/example.jpg")
        assertThat(tweetAuthor.profilePicture())
            .contains("https://pbs.twimg.com/profile_images/example.jpg")
        assertThat(tweetAuthor.protected_()).contains(false)
        assertThat(tweetAuthor.statusesCount()).contains(35000L)
        assertThat(tweetAuthor.unavailable()).contains(false)
        assertThat(tweetAuthor.unavailableReason()).contains("suspended")
        assertThat(tweetAuthor.url()).contains("https://xquik.com")
        assertThat(tweetAuthor.verified()).contains(true)
        assertThat(tweetAuthor.verifiedType()).contains("Business")
        assertThat(tweetAuthor.viewerFollowedBy()).contains(false)
        assertThat(tweetAuthor.viewerFollowing()).contains(true)
        assertThat(tweetAuthor.withheldInCountries().getOrNull()).containsExactly("DE")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetAuthor =
            TweetAuthor.builder()
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

        val roundtrippedTweetAuthor =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetAuthor),
                jacksonTypeRef<TweetAuthor>(),
            )

        assertThat(roundtrippedTweetAuthor).isEqualTo(tweetAuthor)
    }
}
