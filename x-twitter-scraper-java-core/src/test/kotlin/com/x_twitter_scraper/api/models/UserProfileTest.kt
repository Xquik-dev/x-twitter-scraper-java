// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
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
                .affiliatesHighlightedLabel(
                    UserProfile.AffiliatesHighlightedLabel.builder()
                        .badgeUrl("badgeUrl")
                        .description("description")
                        .url("url")
                        .urlType("urlType")
                        .userLabelDisplayType("userLabelDisplayType")
                        .userLabelType("userLabelType")
                        .build()
                )
                .automatedBy("example_user")
                .businessAccountAffiliatesCount(0L)
                .communityRole("Member")
                .coverPicture("https://pbs.twimg.com/profile_banners/example.jpg")
                .createdAt("2009-06-02T20:12:29Z")
                .creatorSubscriptionsCount(0L)
                .description("CEO of Tesla, SpaceX, and X")
                .favouritesCount(18000L)
                .followers(150000000L)
                .following(500L)
                .hasCustomTimelines(true)
                .hasGraduatedAccess(true)
                .hasHiddenSubscriptionsOnProfile(true)
                .highlightsInfo(
                    UserProfile.HighlightsInfo.builder()
                        .canHighlightTweets(true)
                        .highlightedTweets("highlightedTweets")
                        .build()
                )
                .identityVerification(
                    UserProfile.IdentityVerification.builder()
                        .description("description")
                        .isIdentityVerified(true)
                        .verifiedSinceMsec("verifiedSinceMsec")
                        .build()
                )
                .isAutomated(false)
                .isBlueVerified(true)
                .isProfileTranslatable(true)
                .isTranslator(false)
                .isVerified(true)
                .location("Austin, TX")
                .mediaCount(1200L)
                .parodyCommentaryFanLabel("parodyCommentaryFanLabel")
                .addPinnedTweetId("1234567890")
                .possiblySensitive(false)
                .profileBio(
                    UserProfile.ProfileBio.builder()
                        .putAdditionalProperty("description", JsonValue.from("bar"))
                        .putAdditionalProperty("entities", JsonValue.from("bar"))
                        .build()
                )
                .profileBannerUrl("https://pbs.twimg.com/profile_banners/example.jpg")
                .profileDescriptionLanguage("profileDescriptionLanguage")
                .profileImageShape("profileImageShape")
                .profileInterstitialType("profileInterstitialType")
                .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                .profileSortEnabled(true)
                .profileTranslatorType("profileTranslatorType")
                .protected_(false)
                .statusesCount(35000L)
                .superFollowEligible(true)
                .unavailable(false)
                .unavailableReason("suspended")
                .url("https://xquik.com")
                .verified(true)
                .verifiedType("Business")
                .addWithheldInCountry("DE")
                .build()

        assertThat(userProfile.id()).isEqualTo("9876543210")
        assertThat(userProfile.name()).isEqualTo("Elon Musk")
        assertThat(userProfile.username()).isEqualTo("elonmusk")
        assertThat(userProfile.affiliatesHighlightedLabel())
            .contains(
                UserProfile.AffiliatesHighlightedLabel.builder()
                    .badgeUrl("badgeUrl")
                    .description("description")
                    .url("url")
                    .urlType("urlType")
                    .userLabelDisplayType("userLabelDisplayType")
                    .userLabelType("userLabelType")
                    .build()
            )
        assertThat(userProfile.automatedBy()).contains("example_user")
        assertThat(userProfile.businessAccountAffiliatesCount()).contains(0L)
        assertThat(userProfile.communityRole()).contains("Member")
        assertThat(userProfile.coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/example.jpg")
        assertThat(userProfile.createdAt()).contains("2009-06-02T20:12:29Z")
        assertThat(userProfile.creatorSubscriptionsCount()).contains(0L)
        assertThat(userProfile.description()).contains("CEO of Tesla, SpaceX, and X")
        assertThat(userProfile.favouritesCount()).contains(18000L)
        assertThat(userProfile.followers()).contains(150000000L)
        assertThat(userProfile.following()).contains(500L)
        assertThat(userProfile.hasCustomTimelines()).contains(true)
        assertThat(userProfile.hasGraduatedAccess()).contains(true)
        assertThat(userProfile.hasHiddenSubscriptionsOnProfile()).contains(true)
        assertThat(userProfile.highlightsInfo())
            .contains(
                UserProfile.HighlightsInfo.builder()
                    .canHighlightTweets(true)
                    .highlightedTweets("highlightedTweets")
                    .build()
            )
        assertThat(userProfile.identityVerification())
            .contains(
                UserProfile.IdentityVerification.builder()
                    .description("description")
                    .isIdentityVerified(true)
                    .verifiedSinceMsec("verifiedSinceMsec")
                    .build()
            )
        assertThat(userProfile.isAutomated()).contains(false)
        assertThat(userProfile.isBlueVerified()).contains(true)
        assertThat(userProfile.isProfileTranslatable()).contains(true)
        assertThat(userProfile.isTranslator()).contains(false)
        assertThat(userProfile.isVerified()).contains(true)
        assertThat(userProfile.location()).contains("Austin, TX")
        assertThat(userProfile.mediaCount()).contains(1200L)
        assertThat(userProfile.parodyCommentaryFanLabel()).contains("parodyCommentaryFanLabel")
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
        assertThat(userProfile.profileDescriptionLanguage()).contains("profileDescriptionLanguage")
        assertThat(userProfile.profileImageShape()).contains("profileImageShape")
        assertThat(userProfile.profileInterstitialType()).contains("profileInterstitialType")
        assertThat(userProfile.profilePicture())
            .contains("https://pbs.twimg.com/profile_images/example.jpg")
        assertThat(userProfile.profileSortEnabled()).contains(true)
        assertThat(userProfile.profileTranslatorType()).contains("profileTranslatorType")
        assertThat(userProfile.protected_()).contains(false)
        assertThat(userProfile.statusesCount()).contains(35000L)
        assertThat(userProfile.superFollowEligible()).contains(true)
        assertThat(userProfile.unavailable()).contains(false)
        assertThat(userProfile.unavailableReason()).contains("suspended")
        assertThat(userProfile.url()).contains("https://xquik.com")
        assertThat(userProfile.verified()).contains(true)
        assertThat(userProfile.verifiedType()).contains("Business")
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
                .affiliatesHighlightedLabel(
                    UserProfile.AffiliatesHighlightedLabel.builder()
                        .badgeUrl("badgeUrl")
                        .description("description")
                        .url("url")
                        .urlType("urlType")
                        .userLabelDisplayType("userLabelDisplayType")
                        .userLabelType("userLabelType")
                        .build()
                )
                .automatedBy("example_user")
                .businessAccountAffiliatesCount(0L)
                .communityRole("Member")
                .coverPicture("https://pbs.twimg.com/profile_banners/example.jpg")
                .createdAt("2009-06-02T20:12:29Z")
                .creatorSubscriptionsCount(0L)
                .description("CEO of Tesla, SpaceX, and X")
                .favouritesCount(18000L)
                .followers(150000000L)
                .following(500L)
                .hasCustomTimelines(true)
                .hasGraduatedAccess(true)
                .hasHiddenSubscriptionsOnProfile(true)
                .highlightsInfo(
                    UserProfile.HighlightsInfo.builder()
                        .canHighlightTweets(true)
                        .highlightedTweets("highlightedTweets")
                        .build()
                )
                .identityVerification(
                    UserProfile.IdentityVerification.builder()
                        .description("description")
                        .isIdentityVerified(true)
                        .verifiedSinceMsec("verifiedSinceMsec")
                        .build()
                )
                .isAutomated(false)
                .isBlueVerified(true)
                .isProfileTranslatable(true)
                .isTranslator(false)
                .isVerified(true)
                .location("Austin, TX")
                .mediaCount(1200L)
                .parodyCommentaryFanLabel("parodyCommentaryFanLabel")
                .addPinnedTweetId("1234567890")
                .possiblySensitive(false)
                .profileBio(
                    UserProfile.ProfileBio.builder()
                        .putAdditionalProperty("description", JsonValue.from("bar"))
                        .putAdditionalProperty("entities", JsonValue.from("bar"))
                        .build()
                )
                .profileBannerUrl("https://pbs.twimg.com/profile_banners/example.jpg")
                .profileDescriptionLanguage("profileDescriptionLanguage")
                .profileImageShape("profileImageShape")
                .profileInterstitialType("profileInterstitialType")
                .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                .profileSortEnabled(true)
                .profileTranslatorType("profileTranslatorType")
                .protected_(false)
                .statusesCount(35000L)
                .superFollowEligible(true)
                .unavailable(false)
                .unavailableReason("suspended")
                .url("https://xquik.com")
                .verified(true)
                .verifiedType("Business")
                .addWithheldInCountry("DE")
                .build()

        val roundtrippedUserProfile =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userProfile),
                jacksonTypeRef<UserProfile>(),
            )

        assertThat(roundtrippedUserProfile).isEqualTo(userProfile)
    }

    @Test
    fun readsEveryFieldTheSpecDescribes() {
        val userProfile =
            jsonMapper()
                .readValue(
                    """
                    {
                      "id": "9876543210",
                      "username": "elonmusk",
                      "name": "Elon Musk",
                      "description": "CEO of Tesla, SpaceX, and X",
                      "followers": 150000000,
                      "following": 500,
                      "verified": true,
                      "isBlueVerified": true,
                      "isVerified": true,
                      "profilePicture": "https://pbs.twimg.com/profile_images/example_normal.jpg",
                      "profilePictureOriginal": "https://pbs.twimg.com/profile_images/example.jpg",
                      "coverPicture": "https://pbs.twimg.com/profile_banners/example.jpg",
                      "profileBannerUrl": "https://pbs.twimg.com/profile_banners/example.jpg",
                      "location": "Austin, TX",
                      "accountBasedIn": {
                        "value": "United States",
                        "level": "country",
                        "observedAt": "2026-08-21T10:00:00Z"
                      },
                      "accountBasedInUnavailable": false,
                      "accountBasedInAccurate": false,
                      "connectedVia": "United States App Store",
                      "connectedViaAccurate": false,
                      "affiliateUsername": "BBCNews",
                      "email": "press@example.com",
                      "contactInfo": {
                        "emails": [
                          {
                            "value": "press@example.com",
                            "domain": "example.com",
                            "source": "bio",
                            "writtenAs": "press [at] example [dot] com"
                          }
                        ],
                        "phones": [
                          {
                            "value": "+14155550123",
                            "source": "bio",
                            "writtenAs": "+1 (415) 555-0123"
                          }
                        ],
                        "links": [
                          {
                            "url": "https://www.linkedin.com/company/acme",
                            "network": "linkedin",
                            "source": "url"
                          }
                        ]
                      },
                      "usernameChanges": {
                        "count": 653,
                        "lastChangedAt": "2016-05-14T00:22:47.057Z"
                      },
                      "birthdate": {
                        "day": 418,
                        "month": 650,
                        "year": 533
                      },
                      "retweetedAt": "2026-09-11T20:24:45.000Z",
                      "createdAt": "2009-06-02T20:12:29Z",
                      "statusesCount": 35000,
                      "mediaCount": 1200,
                      "protected": false,
                      "url": "https://xquik.com",
                      "favouritesCount": 18000,
                      "hasCustomTimelines": true,
                      "isTranslator": false,
                      "withheldInCountries": [
                        "withheldInCountries-value"
                      ],
                      "withheldScope": "user",
                      "possiblySensitive": false,
                      "professional": {},
                      "grokTranslatedBio": {},
                      "pinnedTweetIds": [
                        "pinnedTweetIds-value"
                      ],
                      "isAutomated": false,
                      "automatedBy": "example_user",
                      "unavailable": false,
                      "unavailableReason": "suspended",
                      "verifiedType": "Business",
                      "affiliatesHighlightedLabel": {
                        "badgeUrl": "badgeUrl-value",
                        "description": "description-value",
                        "longDescription": {},
                        "url": "url-value",
                        "urlType": "urlType-value",
                        "userLabelDisplayType": "userLabelDisplayType-value",
                        "userLabelType": "userLabelType-value"
                      },
                      "businessAccountAffiliatesCount": 3230,
                      "creatorSubscriptionsCount": 2773,
                      "hasGraduatedAccess": false,
                      "hasHiddenSubscriptionsOnProfile": true,
                      "highlightsInfo": {
                        "canHighlightTweets": true,
                        "highlightedTweets": "highlightedTweets-value"
                      },
                      "identityVerification": {
                        "description": "description-value",
                        "isIdentityVerified": true,
                        "overrideVerifiedYear": 2009,
                        "verifiedSinceMsec": "1507188387580"
                      },
                      "isProfileTranslatable": true,
                      "parodyCommentaryFanLabel": "parodyCommentaryFanLabel-value",
                      "profileDescriptionLanguage": "profileDescriptionLanguage-value",
                      "profileImageShape": "profileImageShape-value",
                      "profileInterstitialType": "profileInterstitialType-value",
                      "profileSortEnabled": true,
                      "profileTranslatorType": "profileTranslatorType-value",
                      "redirectsToUsername": "spacexsi",
                      "superFollowEligible": false,
                      "superFollowsUserProfileActive": false,
                      "tipJar": {
                        "bandcampHandle": "bandcampHandle-value",
                        "bitcoinHandle": "bitcoinHandle-value",
                        "cashAppHandle": "cashAppHandle-value",
                        "ethereumHandle": "ethereumHandle-value",
                        "gofundmeHandle": "gofundmeHandle-value",
                        "isEnabled": false,
                        "patreonHandle": "patreonHandle-value",
                        "payPalHandle": "payPalHandle-value",
                        "venmoHandle": "venmoHandle-value"
                      },
                      "listedCount": 3051,
                      "fastFollowersCount": 2008,
                      "normalFollowersCount": 2227,
                      "defaultProfile": true,
                      "defaultProfileImage": false,
                      "hasExtendedProfile": true,
                      "isTranslationEnabled": true,
                      "geoEnabled": true,
                      "advertiserAccountType": "none",
                      "advertiserAccountServiceLevels": [
                        "advertiserAccountServiceLevels-value"
                      ],
                      "businessProfileState": "none",
                      "subscribersCount": 1812,
                      "verificationReason": {
                        "text": "This account is verified because it's an official organization on X.",
                        "entities": [
                          {
                            "fromIndex": 1040,
                            "toIndex": 831,
                            "url": "url-value",
                            "urlType": "urlType-value"
                          }
                        ]
                      },
                      "communityRole": "Member",
                      "profile_bio": {}
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<UserProfile>(),
                )

        userProfile.validate()
        assertThat(userProfile.id()).isEqualTo("9876543210")
        assertThat(userProfile.name()).isEqualTo("Elon Musk")
        assertThat(userProfile.username()).isEqualTo("elonmusk")
        assertThat(userProfile.accountBasedIn().get().level())
            .isEqualTo(UserProfile.AccountBasedIn.Level.COUNTRY)
        assertThat(userProfile.accountBasedIn().get().observedAt())
            .isEqualTo(OffsetDateTime.parse("2026-08-21T10:00:00Z"))
        assertThat(userProfile.accountBasedIn().get().value()).isEqualTo("United States")
        assertThat(userProfile.accountBasedIn().get()._additionalProperties()).isEmpty()
        assertThat(userProfile.accountBasedInAccurate()).contains(false)
        assertThat(userProfile.accountBasedInUnavailable()).contains(false)
        assertThat(userProfile.advertiserAccountServiceLevels().get())
            .containsExactly("advertiserAccountServiceLevels-value")
        assertThat(userProfile.advertiserAccountType()).contains("none")
        assertThat(userProfile.affiliatesHighlightedLabel().get().badgeUrl())
            .contains("badgeUrl-value")
        assertThat(userProfile.affiliatesHighlightedLabel().get().description())
            .contains("description-value")
        assertThat(userProfile.affiliatesHighlightedLabel().get().url()).contains("url-value")
        assertThat(userProfile.affiliatesHighlightedLabel().get().urlType())
            .contains("urlType-value")
        assertThat(userProfile.affiliatesHighlightedLabel().get().userLabelDisplayType())
            .contains("userLabelDisplayType-value")
        assertThat(userProfile.affiliatesHighlightedLabel().get().userLabelType())
            .contains("userLabelType-value")
        assertThat(userProfile.affiliatesHighlightedLabel().get()._additionalProperties()).isEmpty()
        assertThat(userProfile.affiliateUsername()).contains("BBCNews")
        assertThat(userProfile.automatedBy()).contains("example_user")
        assertThat(userProfile.birthdate().get().day()).contains(418L)
        assertThat(userProfile.birthdate().get().month()).contains(650L)
        assertThat(userProfile.birthdate().get().year()).contains(533L)
        assertThat(userProfile.birthdate().get()._additionalProperties()).isEmpty()
        assertThat(userProfile.businessAccountAffiliatesCount()).contains(3230L)
        assertThat(userProfile.businessProfileState()).contains("none")
        assertThat(userProfile.communityRole()).contains("Member")
        assertThat(userProfile.connectedVia()).contains("United States App Store")
        assertThat(userProfile.connectedViaAccurate()).contains(false)
        assertThat(userProfile.contactInfo().get().emails().get()).hasSize(1)
        assertThat(userProfile.contactInfo().get().emails().get()[0].domain())
            .isEqualTo("example.com")
        assertThat(userProfile.contactInfo().get().emails().get()[0].source())
            .isEqualTo(UserProfile.ContactInfo.Email.Source.BIO)
        assertThat(userProfile.contactInfo().get().emails().get()[0].value())
            .isEqualTo("press@example.com")
        assertThat(userProfile.contactInfo().get().emails().get()[0].writtenAs())
            .contains("press [at] example [dot] com")
        assertThat(userProfile.contactInfo().get().emails().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(userProfile.contactInfo().get().links().get()).hasSize(1)
        assertThat(userProfile.contactInfo().get().links().get()[0].network()).isEqualTo("linkedin")
        assertThat(userProfile.contactInfo().get().links().get()[0].source())
            .isEqualTo(UserProfile.ContactInfo.Link.Source.URL)
        assertThat(userProfile.contactInfo().get().links().get()[0].url())
            .isEqualTo("https://www.linkedin.com/company/acme")
        assertThat(userProfile.contactInfo().get().links().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(userProfile.contactInfo().get().phones().get()).hasSize(1)
        assertThat(userProfile.contactInfo().get().phones().get()[0].source())
            .isEqualTo(UserProfile.ContactInfo.Phone.Source.BIO)
        assertThat(userProfile.contactInfo().get().phones().get()[0].value())
            .isEqualTo("+14155550123")
        assertThat(userProfile.contactInfo().get().phones().get()[0].writtenAs())
            .contains("+1 (415) 555-0123")
        assertThat(userProfile.contactInfo().get().phones().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(userProfile.contactInfo().get()._additionalProperties()).isEmpty()
        assertThat(userProfile.coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/example.jpg")
        assertThat(userProfile.createdAt()).contains("2009-06-02T20:12:29Z")
        assertThat(userProfile.creatorSubscriptionsCount()).contains(2773L)
        assertThat(userProfile.defaultProfile()).contains(true)
        assertThat(userProfile.defaultProfileImage()).contains(false)
        assertThat(userProfile.description()).contains("CEO of Tesla, SpaceX, and X")
        assertThat(userProfile.email()).contains("press@example.com")
        assertThat(userProfile.fastFollowersCount()).contains(2008L)
        assertThat(userProfile.favouritesCount()).contains(18000L)
        assertThat(userProfile.followers()).contains(150000000L)
        assertThat(userProfile.following()).contains(500L)
        assertThat(userProfile.geoEnabled()).contains(true)
        assertThat(userProfile.hasCustomTimelines()).contains(true)
        assertThat(userProfile.hasExtendedProfile()).contains(true)
        assertThat(userProfile.hasGraduatedAccess()).contains(false)
        assertThat(userProfile.hasHiddenSubscriptionsOnProfile()).contains(true)
        assertThat(userProfile.highlightsInfo().get().canHighlightTweets()).contains(true)
        assertThat(userProfile.highlightsInfo().get().highlightedTweets())
            .contains("highlightedTweets-value")
        assertThat(userProfile.highlightsInfo().get()._additionalProperties()).isEmpty()
        assertThat(userProfile.identityVerification().get().description())
            .contains("description-value")
        assertThat(userProfile.identityVerification().get().isIdentityVerified()).contains(true)
        assertThat(userProfile.identityVerification().get().overrideVerifiedYear()).contains(2009L)
        assertThat(userProfile.identityVerification().get().verifiedSinceMsec())
            .contains("1507188387580")
        assertThat(userProfile.identityVerification().get()._additionalProperties()).isEmpty()
        assertThat(userProfile.isAutomated()).contains(false)
        assertThat(userProfile.isBlueVerified()).contains(true)
        assertThat(userProfile.isProfileTranslatable()).contains(true)
        assertThat(userProfile.isTranslationEnabled()).contains(true)
        assertThat(userProfile.isTranslator()).contains(false)
        assertThat(userProfile.isVerified()).contains(true)
        assertThat(userProfile.listedCount()).contains(3051L)
        assertThat(userProfile.location()).contains("Austin, TX")
        assertThat(userProfile.mediaCount()).contains(1200L)
        assertThat(userProfile.normalFollowersCount()).contains(2227L)
        assertThat(userProfile.parodyCommentaryFanLabel())
            .contains("parodyCommentaryFanLabel-value")
        assertThat(userProfile.pinnedTweetIds().get()).containsExactly("pinnedTweetIds-value")
        assertThat(userProfile.possiblySensitive()).contains(false)
        assertThat(userProfile.profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/example.jpg")
        assertThat(userProfile.profileDescriptionLanguage())
            .contains("profileDescriptionLanguage-value")
        assertThat(userProfile.profileImageShape()).contains("profileImageShape-value")
        assertThat(userProfile.profileInterstitialType()).contains("profileInterstitialType-value")
        assertThat(userProfile.profilePicture())
            .contains("https://pbs.twimg.com/profile_images/example_normal.jpg")
        assertThat(userProfile.profilePictureOriginal())
            .contains("https://pbs.twimg.com/profile_images/example.jpg")
        assertThat(userProfile.profileSortEnabled()).contains(true)
        assertThat(userProfile.profileTranslatorType()).contains("profileTranslatorType-value")
        assertThat(userProfile.protected_()).contains(false)
        assertThat(userProfile.redirectsToUsername()).contains("spacexsi")
        assertThat(userProfile.retweetedAt())
            .contains(OffsetDateTime.parse("2026-09-11T20:24:45.000Z"))
        assertThat(userProfile.statusesCount()).contains(35000L)
        assertThat(userProfile.subscribersCount()).contains(1812L)
        assertThat(userProfile.superFollowEligible()).contains(false)
        assertThat(userProfile.superFollowsUserProfileActive()).contains(false)
        assertThat(userProfile.tipJar().get().bandcampHandle()).contains("bandcampHandle-value")
        assertThat(userProfile.tipJar().get().bitcoinHandle()).contains("bitcoinHandle-value")
        assertThat(userProfile.tipJar().get().cashAppHandle()).contains("cashAppHandle-value")
        assertThat(userProfile.tipJar().get().ethereumHandle()).contains("ethereumHandle-value")
        assertThat(userProfile.tipJar().get().gofundmeHandle()).contains("gofundmeHandle-value")
        assertThat(userProfile.tipJar().get().isEnabled()).contains(false)
        assertThat(userProfile.tipJar().get().patreonHandle()).contains("patreonHandle-value")
        assertThat(userProfile.tipJar().get().payPalHandle()).contains("payPalHandle-value")
        assertThat(userProfile.tipJar().get().venmoHandle()).contains("venmoHandle-value")
        assertThat(userProfile.tipJar().get()._additionalProperties()).isEmpty()
        assertThat(userProfile.unavailable()).contains(false)
        assertThat(userProfile.unavailableReason()).contains("suspended")
        assertThat(userProfile.url()).contains("https://xquik.com")
        assertThat(userProfile.usernameChanges().get().count()).isEqualTo(653L)
        assertThat(userProfile.usernameChanges().get().lastChangedAt())
            .contains(OffsetDateTime.parse("2016-05-14T00:22:47.057Z"))
        assertThat(userProfile.usernameChanges().get()._additionalProperties()).isEmpty()
        assertThat(userProfile.verificationReason().get().entities().get()).hasSize(1)
        assertThat(userProfile.verificationReason().get().entities().get()[0].fromIndex())
            .contains(1040L)
        assertThat(userProfile.verificationReason().get().entities().get()[0].toIndex())
            .contains(831L)
        assertThat(userProfile.verificationReason().get().entities().get()[0].url())
            .contains("url-value")
        assertThat(userProfile.verificationReason().get().entities().get()[0].urlType())
            .contains("urlType-value")
        assertThat(
                userProfile.verificationReason().get().entities().get()[0]._additionalProperties()
            )
            .isEmpty()
        assertThat(userProfile.verificationReason().get().text())
            .contains("This account is verified because it's an official organization on X.")
        assertThat(userProfile.verificationReason().get()._additionalProperties()).isEmpty()
        assertThat(userProfile.verified()).contains(true)
        assertThat(userProfile.verifiedType()).contains("Business")
        assertThat(userProfile.withheldInCountries().get())
            .containsExactly("withheldInCountries-value")
        assertThat(userProfile.withheldScope()).contains("user")
        assertThat(userProfile._additionalProperties()).isEmpty()
    }
}
