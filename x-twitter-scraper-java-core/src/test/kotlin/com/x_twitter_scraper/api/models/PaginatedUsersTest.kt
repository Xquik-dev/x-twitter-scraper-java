// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PaginatedUsersTest {

    @Test
    fun create() {
        val paginatedUsers =
            PaginatedUsers.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addUser(
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
                )
                .build()

        assertThat(paginatedUsers.hasNextPage()).isEqualTo(true)
        assertThat(paginatedUsers.nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
        assertThat(paginatedUsers.users())
            .containsExactly(
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
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val paginatedUsers =
            PaginatedUsers.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addUser(
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
                )
                .build()

        val roundtrippedPaginatedUsers =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(paginatedUsers),
                jacksonTypeRef<PaginatedUsers>(),
            )

        assertThat(roundtrippedPaginatedUsers).isEqualTo(paginatedUsers)
    }

    @Test
    fun readsEveryFieldTheSpecDescribes() {
        val paginatedUsers =
            jsonMapper()
                .readValue(
                    """
                    {
                      "filtered_count": 1595,
                      "users": [
                        {
                          "id": "11348282",
                          "username": "NASA",
                          "name": "NASA",
                          "followers": 92376187,
                          "accountBasedIn": null,
                          "following": 115,
                          "verified": true,
                          "isBlueVerified": true,
                          "isVerified": true,
                          "profilePicture": "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_normal.jpg",
                          "profilePictureOriginal": "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB.jpg",
                          "coverPicture": "https://pbs.twimg.com/profile_banners/11348282/1788992290",
                          "profileBannerUrl": "https://pbs.twimg.com/profile_banners/11348282/1788992290",
                          "description": "Making the seemingly impossible, possible. ✨",
                          "location": "Pale Blue Dot",
                          "createdAt": "Wed Dec 19 20:20:32 +0000 2007",
                          "birthdate": {
                            "day": 1,
                            "month": 10,
                            "year": 1958
                          },
                          "statusesCount": 74336,
                          "mediaCount": 28160,
                          "protected": false,
                          "url": "http://www.nasa.gov/",
                          "contactInfo": {
                            "links": [
                              {
                                "url": "http://www.nasa.gov/",
                                "network": "website",
                                "source": "url"
                              }
                            ]
                          },
                          "favouritesCount": 17003,
                          "possiblySensitive": false,
                          "verifiedType": "Government",
                          "profile_bio": {
                            "description": "Making the seemingly impossible, possible. ✨",
                            "entities": {
                              "description": {},
                              "url": {
                                "urls": [
                                  {
                                    "display_url": "nasa.gov",
                                    "expanded_url": "http://www.nasa.gov/",
                                    "indices": [
                                      0,
                                      23
                                    ],
                                    "url": "https://t.co/9NkQJKAnuU"
                                  }
                                ]
                              }
                            }
                          },
                          "businessAccountAffiliatesCount": 85,
                          "creatorSubscriptionsCount": 0,
                          "hasGraduatedAccess": true,
                          "hasHiddenSubscriptionsOnProfile": false,
                          "highlightsInfo": {
                            "canHighlightTweets": true,
                            "highlightedTweets": "280"
                          },
                          "identityVerification": {
                            "isIdentityVerified": false,
                            "verifiedSinceMsec": "1249674830941"
                          },
                          "isProfileTranslatable": false,
                          "parodyCommentaryFanLabel": "None",
                          "profileDescriptionLanguage": "en",
                          "profileImageShape": "Square",
                          "profileSortEnabled": true,
                          "profileTranslatorType": "regular",
                          "superFollowEligible": false,
                          "verificationReason": {
                            "entities": [
                              {
                                "fromIndex": 91,
                                "toIndex": 101,
                                "url": "https://help.twitter.com/en/rules-and-policies/profile-labels",
                                "urlType": "ExternalUrl"
                              }
                            ],
                            "text": "This account is verified because it is a government or multilateral organization account.  Learn more"
                          }
                        }
                      ],
                      "has_next_page": true,
                      "next_cursor": "DAACCgACGRElMJcAAA"
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<PaginatedUsers>(),
                )

        paginatedUsers.validate()
        assertThat(paginatedUsers.hasNextPage()).isEqualTo(true)
        assertThat(paginatedUsers.nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
        assertThat(paginatedUsers.users()).hasSize(1)
        assertThat(paginatedUsers.users()[0].id()).isEqualTo("11348282")
        assertThat(paginatedUsers.users()[0].name()).isEqualTo("NASA")
        assertThat(paginatedUsers.users()[0].username()).isEqualTo("NASA")
        assertThat(paginatedUsers.filteredCount()).contains(1595L)
        assertThat(paginatedUsers._additionalProperties()).isEmpty()
    }

    @Test
    fun additionalScanLimitFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json = """{"limit":100000,"rowsRead":1,"message":"sample"}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<PaginatedUsers.ScanLimit>())

        assertThat(model.limit()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("limit")
        assertThat(model.rowsRead()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("rowsRead")
        assertThat(model.message()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("message")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<PaginatedUsers.ScanLimit>(),
                )
            )
            .isEqualTo(model)
    }

    @Test
    fun additionalFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json = """{"scanLimit":{},"diagnostic":{}}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<PaginatedUsers>())

        assertThat(model.scanLimit()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("scanLimit")
        assertThat(model.diagnostic()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("diagnostic")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<PaginatedUsers>(),
                )
            )
            .isEqualTo(model)
    }

    @Test
    fun additionalDiagnosticFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json =
            """{"complete":true,"cursorFailureCount":1,"deadlineReached":true,"duplicateCount":1,"failedStrategyCount":1,"malformedCount":1,"pagesFetched":1,"responseTruncated":true,"resultLimitReached":true,"stalledStrategyCount":1,"strategyCount":1,"returnedUsers":1,"strategies":[{}],"uniqueUsers":1}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<PaginatedUsers.Diagnostic>())

        assertThat(model.complete()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("complete")
        assertThat(model.cursorFailureCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("cursorFailureCount")
        assertThat(model.deadlineReached()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("deadlineReached")
        assertThat(model.duplicateCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("duplicateCount")
        assertThat(model.failedStrategyCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("failedStrategyCount")
        assertThat(model.malformedCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("malformedCount")
        assertThat(model.pagesFetched()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("pagesFetched")
        assertThat(model.responseTruncated()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("responseTruncated")
        assertThat(model.resultLimitReached()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("resultLimitReached")
        assertThat(model.stalledStrategyCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("stalledStrategyCount")
        assertThat(model.strategyCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("strategyCount")
        assertThat(model.returnedUsers()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("returnedUsers")
        assertThat(model.strategies()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("strategies")
        assertThat(model.uniqueUsers()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("uniqueUsers")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<PaginatedUsers.Diagnostic>(),
                )
            )
            .isEqualTo(model)
    }

    @Test
    fun additionalDiagnosticStrategyFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json =
            """{"duplicateCount":1,"pagesFetched":1,"stopReason":"cursor_failure","strategy":1,"uniqueAdded":1}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<PaginatedUsers.Diagnostic.Strategy>())

        assertThat(model.duplicateCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("duplicateCount")
        assertThat(model.pagesFetched()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("pagesFetched")
        assertThat(model.stopReason()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("stopReason")
        assertThat(model.strategy()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("strategy")
        assertThat(model.uniqueAdded()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("uniqueAdded")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<PaginatedUsers.Diagnostic.Strategy>(),
                )
            )
            .isEqualTo(model)
    }
}
