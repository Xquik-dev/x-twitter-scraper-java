// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.UserProfile
import java.time.OffsetDateTime
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

        assertThat(tweetAuthor.id()).isEqualTo("9876543210")
        assertThat(tweetAuthor.name()).isEqualTo("Elon Musk")
        assertThat(tweetAuthor.username()).isEqualTo("elonmusk")
        assertThat(tweetAuthor.affiliatesHighlightedLabel())
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
        assertThat(tweetAuthor.automatedBy()).contains("example_user")
        assertThat(tweetAuthor.businessAccountAffiliatesCount()).contains(0L)
        assertThat(tweetAuthor.communityRole()).contains("Member")
        assertThat(tweetAuthor.coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/example.jpg")
        assertThat(tweetAuthor.createdAt()).contains("2009-06-02T20:12:29Z")
        assertThat(tweetAuthor.creatorSubscriptionsCount()).contains(0L)
        assertThat(tweetAuthor.description()).contains("CEO of Tesla, SpaceX, and X")
        assertThat(tweetAuthor.favouritesCount()).contains(18000L)
        assertThat(tweetAuthor.followers()).contains(150000000L)
        assertThat(tweetAuthor.following()).contains(500L)
        assertThat(tweetAuthor.hasCustomTimelines()).contains(true)
        assertThat(tweetAuthor.hasGraduatedAccess()).contains(true)
        assertThat(tweetAuthor.hasHiddenSubscriptionsOnProfile()).contains(true)
        assertThat(tweetAuthor.highlightsInfo())
            .contains(
                UserProfile.HighlightsInfo.builder()
                    .canHighlightTweets(true)
                    .highlightedTweets("highlightedTweets")
                    .build()
            )
        assertThat(tweetAuthor.identityVerification())
            .contains(
                UserProfile.IdentityVerification.builder()
                    .description("description")
                    .isIdentityVerified(true)
                    .verifiedSinceMsec("verifiedSinceMsec")
                    .build()
            )
        assertThat(tweetAuthor.isAutomated()).contains(false)
        assertThat(tweetAuthor.isBlueVerified()).contains(true)
        assertThat(tweetAuthor.isProfileTranslatable()).contains(true)
        assertThat(tweetAuthor.isTranslator()).contains(false)
        assertThat(tweetAuthor.isVerified()).contains(true)
        assertThat(tweetAuthor.location()).contains("Austin, TX")
        assertThat(tweetAuthor.mediaCount()).contains(1200L)
        assertThat(tweetAuthor.parodyCommentaryFanLabel()).contains("parodyCommentaryFanLabel")
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
        assertThat(tweetAuthor.profileDescriptionLanguage()).contains("profileDescriptionLanguage")
        assertThat(tweetAuthor.profileImageShape()).contains("profileImageShape")
        assertThat(tweetAuthor.profileInterstitialType()).contains("profileInterstitialType")
        assertThat(tweetAuthor.profilePicture())
            .contains("https://pbs.twimg.com/profile_images/example.jpg")
        assertThat(tweetAuthor.profileSortEnabled()).contains(true)
        assertThat(tweetAuthor.profileTranslatorType()).contains("profileTranslatorType")
        assertThat(tweetAuthor.protected_()).contains(false)
        assertThat(tweetAuthor.statusesCount()).contains(35000L)
        assertThat(tweetAuthor.superFollowEligible()).contains(true)
        assertThat(tweetAuthor.unavailable()).contains(false)
        assertThat(tweetAuthor.unavailableReason()).contains("suspended")
        assertThat(tweetAuthor.url()).contains("https://xquik.com")
        assertThat(tweetAuthor.verified()).contains(true)
        assertThat(tweetAuthor.verifiedType()).contains("Business")
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

        val roundtrippedTweetAuthor =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetAuthor),
                jacksonTypeRef<TweetAuthor>(),
            )

        assertThat(roundtrippedTweetAuthor).isEqualTo(tweetAuthor)
    }

    @Test
    fun readsEveryFieldTheSpecDescribes() {
        val tweetAuthor =
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
                    jacksonTypeRef<TweetAuthor>(),
                )

        tweetAuthor.validate()
        assertThat(tweetAuthor.id()).isEqualTo("9876543210")
        assertThat(tweetAuthor.name()).isEqualTo("Elon Musk")
        assertThat(tweetAuthor.username()).isEqualTo("elonmusk")
        assertThat(tweetAuthor.accountBasedIn().get().level())
            .isEqualTo(UserProfile.AccountBasedIn.Level.COUNTRY)
        assertThat(tweetAuthor.accountBasedIn().get().observedAt())
            .isEqualTo(OffsetDateTime.parse("2026-08-21T10:00:00Z"))
        assertThat(tweetAuthor.accountBasedIn().get().value()).isEqualTo("United States")
        assertThat(tweetAuthor.accountBasedIn().get()._additionalProperties()).isEmpty()
        assertThat(tweetAuthor.accountBasedInAccurate()).contains(false)
        assertThat(tweetAuthor.accountBasedInUnavailable()).contains(false)
        assertThat(tweetAuthor.advertiserAccountServiceLevels().get())
            .containsExactly("advertiserAccountServiceLevels-value")
        assertThat(tweetAuthor.advertiserAccountType()).contains("none")
        assertThat(tweetAuthor.affiliatesHighlightedLabel().get().badgeUrl())
            .contains("badgeUrl-value")
        assertThat(tweetAuthor.affiliatesHighlightedLabel().get().description())
            .contains("description-value")
        assertThat(tweetAuthor.affiliatesHighlightedLabel().get().url()).contains("url-value")
        assertThat(tweetAuthor.affiliatesHighlightedLabel().get().urlType())
            .contains("urlType-value")
        assertThat(tweetAuthor.affiliatesHighlightedLabel().get().userLabelDisplayType())
            .contains("userLabelDisplayType-value")
        assertThat(tweetAuthor.affiliatesHighlightedLabel().get().userLabelType())
            .contains("userLabelType-value")
        assertThat(tweetAuthor.affiliatesHighlightedLabel().get()._additionalProperties()).isEmpty()
        assertThat(tweetAuthor.affiliateUsername()).contains("BBCNews")
        assertThat(tweetAuthor.automatedBy()).contains("example_user")
        assertThat(tweetAuthor.birthdate().get().day()).contains(418L)
        assertThat(tweetAuthor.birthdate().get().month()).contains(650L)
        assertThat(tweetAuthor.birthdate().get().year()).contains(533L)
        assertThat(tweetAuthor.birthdate().get()._additionalProperties()).isEmpty()
        assertThat(tweetAuthor.businessAccountAffiliatesCount()).contains(3230L)
        assertThat(tweetAuthor.businessProfileState()).contains("none")
        assertThat(tweetAuthor.communityRole()).contains("Member")
        assertThat(tweetAuthor.connectedVia()).contains("United States App Store")
        assertThat(tweetAuthor.connectedViaAccurate()).contains(false)
        assertThat(tweetAuthor.contactInfo().get().emails().get()).hasSize(1)
        assertThat(tweetAuthor.contactInfo().get().emails().get()[0].domain())
            .isEqualTo("example.com")
        assertThat(tweetAuthor.contactInfo().get().emails().get()[0].source())
            .isEqualTo(UserProfile.ContactInfo.Email.Source.BIO)
        assertThat(tweetAuthor.contactInfo().get().emails().get()[0].value())
            .isEqualTo("press@example.com")
        assertThat(tweetAuthor.contactInfo().get().emails().get()[0].writtenAs())
            .contains("press [at] example [dot] com")
        assertThat(tweetAuthor.contactInfo().get().emails().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(tweetAuthor.contactInfo().get().links().get()).hasSize(1)
        assertThat(tweetAuthor.contactInfo().get().links().get()[0].network()).isEqualTo("linkedin")
        assertThat(tweetAuthor.contactInfo().get().links().get()[0].source())
            .isEqualTo(UserProfile.ContactInfo.Link.Source.URL)
        assertThat(tweetAuthor.contactInfo().get().links().get()[0].url())
            .isEqualTo("https://www.linkedin.com/company/acme")
        assertThat(tweetAuthor.contactInfo().get().links().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(tweetAuthor.contactInfo().get().phones().get()).hasSize(1)
        assertThat(tweetAuthor.contactInfo().get().phones().get()[0].source())
            .isEqualTo(UserProfile.ContactInfo.Phone.Source.BIO)
        assertThat(tweetAuthor.contactInfo().get().phones().get()[0].value())
            .isEqualTo("+14155550123")
        assertThat(tweetAuthor.contactInfo().get().phones().get()[0].writtenAs())
            .contains("+1 (415) 555-0123")
        assertThat(tweetAuthor.contactInfo().get().phones().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(tweetAuthor.contactInfo().get()._additionalProperties()).isEmpty()
        assertThat(tweetAuthor.coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/example.jpg")
        assertThat(tweetAuthor.createdAt()).contains("2009-06-02T20:12:29Z")
        assertThat(tweetAuthor.creatorSubscriptionsCount()).contains(2773L)
        assertThat(tweetAuthor.defaultProfile()).contains(true)
        assertThat(tweetAuthor.defaultProfileImage()).contains(false)
        assertThat(tweetAuthor.description()).contains("CEO of Tesla, SpaceX, and X")
        assertThat(tweetAuthor.email()).contains("press@example.com")
        assertThat(tweetAuthor.fastFollowersCount()).contains(2008L)
        assertThat(tweetAuthor.favouritesCount()).contains(18000L)
        assertThat(tweetAuthor.followers()).contains(150000000L)
        assertThat(tweetAuthor.following()).contains(500L)
        assertThat(tweetAuthor.geoEnabled()).contains(true)
        assertThat(tweetAuthor.hasCustomTimelines()).contains(true)
        assertThat(tweetAuthor.hasExtendedProfile()).contains(true)
        assertThat(tweetAuthor.hasGraduatedAccess()).contains(false)
        assertThat(tweetAuthor.hasHiddenSubscriptionsOnProfile()).contains(true)
        assertThat(tweetAuthor.highlightsInfo().get().canHighlightTweets()).contains(true)
        assertThat(tweetAuthor.highlightsInfo().get().highlightedTweets())
            .contains("highlightedTweets-value")
        assertThat(tweetAuthor.highlightsInfo().get()._additionalProperties()).isEmpty()
        assertThat(tweetAuthor.identityVerification().get().description())
            .contains("description-value")
        assertThat(tweetAuthor.identityVerification().get().isIdentityVerified()).contains(true)
        assertThat(tweetAuthor.identityVerification().get().verifiedSinceMsec())
            .contains("1507188387580")
        assertThat(tweetAuthor.identityVerification().get()._additionalProperties()).isEmpty()
        assertThat(tweetAuthor.isAutomated()).contains(false)
        assertThat(tweetAuthor.isBlueVerified()).contains(true)
        assertThat(tweetAuthor.isProfileTranslatable()).contains(true)
        assertThat(tweetAuthor.isTranslationEnabled()).contains(true)
        assertThat(tweetAuthor.isTranslator()).contains(false)
        assertThat(tweetAuthor.isVerified()).contains(true)
        assertThat(tweetAuthor.listedCount()).contains(3051L)
        assertThat(tweetAuthor.location()).contains("Austin, TX")
        assertThat(tweetAuthor.mediaCount()).contains(1200L)
        assertThat(tweetAuthor.normalFollowersCount()).contains(2227L)
        assertThat(tweetAuthor.parodyCommentaryFanLabel())
            .contains("parodyCommentaryFanLabel-value")
        assertThat(tweetAuthor.pinnedTweetIds().get()).containsExactly("pinnedTweetIds-value")
        assertThat(tweetAuthor.possiblySensitive()).contains(false)
        assertThat(tweetAuthor.profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/example.jpg")
        assertThat(tweetAuthor.profileDescriptionLanguage())
            .contains("profileDescriptionLanguage-value")
        assertThat(tweetAuthor.profileImageShape()).contains("profileImageShape-value")
        assertThat(tweetAuthor.profileInterstitialType()).contains("profileInterstitialType-value")
        assertThat(tweetAuthor.profilePicture())
            .contains("https://pbs.twimg.com/profile_images/example_normal.jpg")
        assertThat(tweetAuthor.profilePictureOriginal())
            .contains("https://pbs.twimg.com/profile_images/example.jpg")
        assertThat(tweetAuthor.profileSortEnabled()).contains(true)
        assertThat(tweetAuthor.profileTranslatorType()).contains("profileTranslatorType-value")
        assertThat(tweetAuthor.protected_()).contains(false)
        assertThat(tweetAuthor.redirectsToUsername()).contains("spacexsi")
        assertThat(tweetAuthor.retweetedAt())
            .contains(OffsetDateTime.parse("2026-09-11T20:24:45.000Z"))
        assertThat(tweetAuthor.statusesCount()).contains(35000L)
        assertThat(tweetAuthor.subscribersCount()).contains(1812L)
        assertThat(tweetAuthor.superFollowEligible()).contains(false)
        assertThat(tweetAuthor.superFollowsUserProfileActive()).contains(false)
        assertThat(tweetAuthor.tipJar().get().bandcampHandle()).contains("bandcampHandle-value")
        assertThat(tweetAuthor.tipJar().get().bitcoinHandle()).contains("bitcoinHandle-value")
        assertThat(tweetAuthor.tipJar().get().cashAppHandle()).contains("cashAppHandle-value")
        assertThat(tweetAuthor.tipJar().get().ethereumHandle()).contains("ethereumHandle-value")
        assertThat(tweetAuthor.tipJar().get().gofundmeHandle()).contains("gofundmeHandle-value")
        assertThat(tweetAuthor.tipJar().get().isEnabled()).contains(false)
        assertThat(tweetAuthor.tipJar().get().patreonHandle()).contains("patreonHandle-value")
        assertThat(tweetAuthor.tipJar().get().payPalHandle()).contains("payPalHandle-value")
        assertThat(tweetAuthor.tipJar().get().venmoHandle()).contains("venmoHandle-value")
        assertThat(tweetAuthor.tipJar().get()._additionalProperties()).isEmpty()
        assertThat(tweetAuthor.unavailable()).contains(false)
        assertThat(tweetAuthor.unavailableReason()).contains("suspended")
        assertThat(tweetAuthor.url()).contains("https://xquik.com")
        assertThat(tweetAuthor.usernameChanges().get().count()).isEqualTo(653L)
        assertThat(tweetAuthor.usernameChanges().get().lastChangedAt())
            .contains(OffsetDateTime.parse("2016-05-14T00:22:47.057Z"))
        assertThat(tweetAuthor.usernameChanges().get()._additionalProperties()).isEmpty()
        assertThat(tweetAuthor.verificationReason().get().entities().get()).hasSize(1)
        assertThat(tweetAuthor.verificationReason().get().entities().get()[0].fromIndex())
            .contains(1040L)
        assertThat(tweetAuthor.verificationReason().get().entities().get()[0].toIndex())
            .contains(831L)
        assertThat(tweetAuthor.verificationReason().get().entities().get()[0].url())
            .contains("url-value")
        assertThat(tweetAuthor.verificationReason().get().entities().get()[0].urlType())
            .contains("urlType-value")
        assertThat(
                tweetAuthor.verificationReason().get().entities().get()[0]._additionalProperties()
            )
            .isEmpty()
        assertThat(tweetAuthor.verificationReason().get().text())
            .contains("This account is verified because it's an official organization on X.")
        assertThat(tweetAuthor.verificationReason().get()._additionalProperties()).isEmpty()
        assertThat(tweetAuthor.verified()).contains(true)
        assertThat(tweetAuthor.verifiedType()).contains("Business")
        assertThat(tweetAuthor.withheldInCountries().get())
            .containsExactly("withheldInCountries-value")
        assertThat(tweetAuthor.withheldScope()).contains("user")
        assertThat(tweetAuthor._additionalProperties()).isEmpty()
        assertThat(tweetAuthor.toUserProfile()._id()).isEqualTo(tweetAuthor._id())
        assertThat(tweetAuthor.toUserProfile()._name()).isEqualTo(tweetAuthor._name())
        assertThat(tweetAuthor.toUserProfile()._username()).isEqualTo(tweetAuthor._username())
        assertThat(tweetAuthor.toUserProfile()._affiliatesHighlightedLabel())
            .isEqualTo(tweetAuthor._affiliatesHighlightedLabel())
        assertThat(tweetAuthor.toUserProfile()._automatedBy()).isEqualTo(tweetAuthor._automatedBy())
        assertThat(tweetAuthor.toUserProfile()._businessAccountAffiliatesCount())
            .isEqualTo(tweetAuthor._businessAccountAffiliatesCount())
        assertThat(tweetAuthor.toUserProfile()._communityRole())
            .isEqualTo(tweetAuthor._communityRole())
        assertThat(tweetAuthor.toUserProfile()._coverPicture())
            .isEqualTo(tweetAuthor._coverPicture())
        assertThat(tweetAuthor.toUserProfile()._createdAt()).isEqualTo(tweetAuthor._createdAt())
        assertThat(tweetAuthor.toUserProfile()._creatorSubscriptionsCount())
            .isEqualTo(tweetAuthor._creatorSubscriptionsCount())
        assertThat(tweetAuthor.toUserProfile()._description()).isEqualTo(tweetAuthor._description())
        assertThat(tweetAuthor.toUserProfile()._favouritesCount())
            .isEqualTo(tweetAuthor._favouritesCount())
        assertThat(tweetAuthor.toUserProfile()._followers()).isEqualTo(tweetAuthor._followers())
        assertThat(tweetAuthor.toUserProfile()._following()).isEqualTo(tweetAuthor._following())
        assertThat(tweetAuthor.toUserProfile()._hasCustomTimelines())
            .isEqualTo(tweetAuthor._hasCustomTimelines())
        assertThat(tweetAuthor.toUserProfile()._hasGraduatedAccess())
            .isEqualTo(tweetAuthor._hasGraduatedAccess())
        assertThat(tweetAuthor.toUserProfile()._hasHiddenSubscriptionsOnProfile())
            .isEqualTo(tweetAuthor._hasHiddenSubscriptionsOnProfile())
        assertThat(tweetAuthor.toUserProfile()._highlightsInfo())
            .isEqualTo(tweetAuthor._highlightsInfo())
        assertThat(tweetAuthor.toUserProfile()._identityVerification())
            .isEqualTo(tweetAuthor._identityVerification())
        assertThat(tweetAuthor.toUserProfile()._isAutomated()).isEqualTo(tweetAuthor._isAutomated())
        assertThat(tweetAuthor.toUserProfile()._isBlueVerified())
            .isEqualTo(tweetAuthor._isBlueVerified())
        assertThat(tweetAuthor.toUserProfile()._isProfileTranslatable())
            .isEqualTo(tweetAuthor._isProfileTranslatable())
        assertThat(tweetAuthor.toUserProfile()._isTranslator())
            .isEqualTo(tweetAuthor._isTranslator())
        assertThat(tweetAuthor.toUserProfile()._isVerified()).isEqualTo(tweetAuthor._isVerified())
        assertThat(tweetAuthor.toUserProfile()._location()).isEqualTo(tweetAuthor._location())
        assertThat(tweetAuthor.toUserProfile()._mediaCount()).isEqualTo(tweetAuthor._mediaCount())
        assertThat(tweetAuthor.toUserProfile()._parodyCommentaryFanLabel())
            .isEqualTo(tweetAuthor._parodyCommentaryFanLabel())
        assertThat(tweetAuthor.toUserProfile()._pinnedTweetIds())
            .isEqualTo(tweetAuthor._pinnedTweetIds())
        assertThat(tweetAuthor.toUserProfile()._possiblySensitive())
            .isEqualTo(tweetAuthor._possiblySensitive())
        assertThat(tweetAuthor.toUserProfile()._profileBio()).isEqualTo(tweetAuthor._profileBio())
        assertThat(tweetAuthor.toUserProfile()._profileBannerUrl())
            .isEqualTo(tweetAuthor._profileBannerUrl())
        assertThat(tweetAuthor.toUserProfile()._profileDescriptionLanguage())
            .isEqualTo(tweetAuthor._profileDescriptionLanguage())
        assertThat(tweetAuthor.toUserProfile()._profileImageShape())
            .isEqualTo(tweetAuthor._profileImageShape())
        assertThat(tweetAuthor.toUserProfile()._profileInterstitialType())
            .isEqualTo(tweetAuthor._profileInterstitialType())
        assertThat(tweetAuthor.toUserProfile()._profilePicture())
            .isEqualTo(tweetAuthor._profilePicture())
        assertThat(tweetAuthor.toUserProfile()._profileSortEnabled())
            .isEqualTo(tweetAuthor._profileSortEnabled())
        assertThat(tweetAuthor.toUserProfile()._profileTranslatorType())
            .isEqualTo(tweetAuthor._profileTranslatorType())
        assertThat(tweetAuthor.toUserProfile()._protected_()).isEqualTo(tweetAuthor._protected_())
        assertThat(tweetAuthor.toUserProfile()._statusesCount())
            .isEqualTo(tweetAuthor._statusesCount())
        assertThat(tweetAuthor.toUserProfile()._superFollowEligible())
            .isEqualTo(tweetAuthor._superFollowEligible())
        assertThat(tweetAuthor.toUserProfile()._unavailable()).isEqualTo(tweetAuthor._unavailable())
        assertThat(tweetAuthor.toUserProfile()._unavailableReason())
            .isEqualTo(tweetAuthor._unavailableReason())
        assertThat(tweetAuthor.toUserProfile()._url()).isEqualTo(tweetAuthor._url())
        assertThat(tweetAuthor.toUserProfile()._verified()).isEqualTo(tweetAuthor._verified())
        assertThat(tweetAuthor.toUserProfile()._verifiedType())
            .isEqualTo(tweetAuthor._verifiedType())
        assertThat(tweetAuthor.toUserProfile()._withheldInCountries())
            .isEqualTo(tweetAuthor._withheldInCountries())
        assertThat(tweetAuthor.toUserProfile()._accountBasedIn())
            .isEqualTo(tweetAuthor._accountBasedIn())
        assertThat(tweetAuthor.toUserProfile()._accountBasedInAccurate())
            .isEqualTo(tweetAuthor._accountBasedInAccurate())
        assertThat(tweetAuthor.toUserProfile()._accountBasedInUnavailable())
            .isEqualTo(tweetAuthor._accountBasedInUnavailable())
        assertThat(tweetAuthor.toUserProfile()._advertiserAccountServiceLevels())
            .isEqualTo(tweetAuthor._advertiserAccountServiceLevels())
        assertThat(tweetAuthor.toUserProfile()._advertiserAccountType())
            .isEqualTo(tweetAuthor._advertiserAccountType())
        assertThat(tweetAuthor.toUserProfile()._affiliateUsername())
            .isEqualTo(tweetAuthor._affiliateUsername())
        assertThat(tweetAuthor.toUserProfile()._birthdate()).isEqualTo(tweetAuthor._birthdate())
        assertThat(tweetAuthor.toUserProfile()._businessProfileState())
            .isEqualTo(tweetAuthor._businessProfileState())
        assertThat(tweetAuthor.toUserProfile()._connectedVia())
            .isEqualTo(tweetAuthor._connectedVia())
        assertThat(tweetAuthor.toUserProfile()._connectedViaAccurate())
            .isEqualTo(tweetAuthor._connectedViaAccurate())
        assertThat(tweetAuthor.toUserProfile()._contactInfo()).isEqualTo(tweetAuthor._contactInfo())
        assertThat(tweetAuthor.toUserProfile()._defaultProfile())
            .isEqualTo(tweetAuthor._defaultProfile())
        assertThat(tweetAuthor.toUserProfile()._defaultProfileImage())
            .isEqualTo(tweetAuthor._defaultProfileImage())
        assertThat(tweetAuthor.toUserProfile()._email()).isEqualTo(tweetAuthor._email())
        assertThat(tweetAuthor.toUserProfile()._fastFollowersCount())
            .isEqualTo(tweetAuthor._fastFollowersCount())
        assertThat(tweetAuthor.toUserProfile()._geoEnabled()).isEqualTo(tweetAuthor._geoEnabled())
        assertThat(tweetAuthor.toUserProfile()._grokTranslatedBio())
            .isEqualTo(tweetAuthor._grokTranslatedBio())
        assertThat(tweetAuthor.toUserProfile()._hasExtendedProfile())
            .isEqualTo(tweetAuthor._hasExtendedProfile())
        assertThat(tweetAuthor.toUserProfile()._isTranslationEnabled())
            .isEqualTo(tweetAuthor._isTranslationEnabled())
        assertThat(tweetAuthor.toUserProfile()._listedCount()).isEqualTo(tweetAuthor._listedCount())
        assertThat(tweetAuthor.toUserProfile()._normalFollowersCount())
            .isEqualTo(tweetAuthor._normalFollowersCount())
        assertThat(tweetAuthor.toUserProfile()._professional())
            .isEqualTo(tweetAuthor._professional())
        assertThat(tweetAuthor.toUserProfile()._profilePictureOriginal())
            .isEqualTo(tweetAuthor._profilePictureOriginal())
        assertThat(tweetAuthor.toUserProfile()._redirectsToUsername())
            .isEqualTo(tweetAuthor._redirectsToUsername())
        assertThat(tweetAuthor.toUserProfile()._retweetedAt()).isEqualTo(tweetAuthor._retweetedAt())
        assertThat(tweetAuthor.toUserProfile()._subscribersCount())
            .isEqualTo(tweetAuthor._subscribersCount())
        assertThat(tweetAuthor.toUserProfile()._superFollowsUserProfileActive())
            .isEqualTo(tweetAuthor._superFollowsUserProfileActive())
        assertThat(tweetAuthor.toUserProfile()._tipJar()).isEqualTo(tweetAuthor._tipJar())
        assertThat(tweetAuthor.toUserProfile()._usernameChanges())
            .isEqualTo(tweetAuthor._usernameChanges())
        assertThat(tweetAuthor.toUserProfile()._verificationReason())
            .isEqualTo(tweetAuthor._verificationReason())
        assertThat(tweetAuthor.toUserProfile()._withheldScope())
            .isEqualTo(tweetAuthor._withheldScope())
    }
}
