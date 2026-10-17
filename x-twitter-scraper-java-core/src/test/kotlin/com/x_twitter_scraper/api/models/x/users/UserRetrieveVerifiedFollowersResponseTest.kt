// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import com.x_twitter_scraper.api.models.PaginatedUsers
import com.x_twitter_scraper.api.models.UserProfile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class UserRetrieveVerifiedFollowersResponseTest {

    @Test
    fun ofPaginatedUsers() {
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

        val userRetrieveVerifiedFollowersResponse =
            UserRetrieveVerifiedFollowersResponse.ofPaginatedUsers(paginatedUsers)

        assertThat(userRetrieveVerifiedFollowersResponse.paginatedUsers()).contains(paginatedUsers)
        assertThat(userRetrieveVerifiedFollowersResponse.listCoverage()).isEmpty
    }

    @Test
    fun ofPaginatedUsersRoundtrip() {
        val jsonMapper = jsonMapper()
        val userRetrieveVerifiedFollowersResponse =
            UserRetrieveVerifiedFollowersResponse.ofPaginatedUsers(
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
            )

        val roundtrippedUserRetrieveVerifiedFollowersResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userRetrieveVerifiedFollowersResponse),
                jacksonTypeRef<UserRetrieveVerifiedFollowersResponse>(),
            )

        assertThat(roundtrippedUserRetrieveVerifiedFollowersResponse)
            .isEqualTo(userRetrieveVerifiedFollowersResponse)
    }

    @Test
    fun ofListCoverage() {
        val listCoverage =
            UserRetrieveVerifiedFollowersResponse.UserListCoverageResponse.builder()
                .hasNextPage(false)
                .nextCursor("")
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
                .diagnostic(
                    UserRetrieveVerifiedFollowersResponse.UserListCoverageResponse.Diagnostic
                        .builder()
                        .complete(true)
                        .cursorFailureCount(0L)
                        .deadlineReached(true)
                        .duplicateCount(0L)
                        .failedStrategyCount(0L)
                        .malformedCount(0L)
                        .pagesFetched(0L)
                        .responseTruncated(true)
                        .resultLimitReached(true)
                        .returnedUsers(0L)
                        .stalledStrategyCount(0L)
                        .addStrategy(
                            UserRetrieveVerifiedFollowersResponse.UserListCoverageResponse
                                .Diagnostic
                                .Strategy
                                .builder()
                                .duplicateCount(0L)
                                .pagesFetched(0L)
                                .stopReason(
                                    UserRetrieveVerifiedFollowersResponse.UserListCoverageResponse
                                        .Diagnostic
                                        .Strategy
                                        .StopReason
                                        .CURSOR_FAILURE
                                )
                                .strategy(1L)
                                .uniqueAdded(0L)
                                .build()
                        )
                        .strategyCount(1L)
                        .uniqueUsers(0L)
                        .build()
                )
                .build()

        val userRetrieveVerifiedFollowersResponse =
            UserRetrieveVerifiedFollowersResponse.ofListCoverage(listCoverage)

        assertThat(userRetrieveVerifiedFollowersResponse.paginatedUsers()).isEmpty
        assertThat(userRetrieveVerifiedFollowersResponse.listCoverage()).contains(listCoverage)
    }

    @Test
    fun ofListCoverageRoundtrip() {
        val jsonMapper = jsonMapper()
        val userRetrieveVerifiedFollowersResponse =
            UserRetrieveVerifiedFollowersResponse.ofListCoverage(
                UserRetrieveVerifiedFollowersResponse.UserListCoverageResponse.builder()
                    .hasNextPage(false)
                    .nextCursor("")
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
                    .diagnostic(
                        UserRetrieveVerifiedFollowersResponse.UserListCoverageResponse.Diagnostic
                            .builder()
                            .complete(true)
                            .cursorFailureCount(0L)
                            .deadlineReached(true)
                            .duplicateCount(0L)
                            .failedStrategyCount(0L)
                            .malformedCount(0L)
                            .pagesFetched(0L)
                            .responseTruncated(true)
                            .resultLimitReached(true)
                            .returnedUsers(0L)
                            .stalledStrategyCount(0L)
                            .addStrategy(
                                UserRetrieveVerifiedFollowersResponse.UserListCoverageResponse
                                    .Diagnostic
                                    .Strategy
                                    .builder()
                                    .duplicateCount(0L)
                                    .pagesFetched(0L)
                                    .stopReason(
                                        UserRetrieveVerifiedFollowersResponse
                                            .UserListCoverageResponse
                                            .Diagnostic
                                            .Strategy
                                            .StopReason
                                            .CURSOR_FAILURE
                                    )
                                    .strategy(1L)
                                    .uniqueAdded(0L)
                                    .build()
                            )
                            .strategyCount(1L)
                            .uniqueUsers(0L)
                            .build()
                    )
                    .build()
            )

        val roundtrippedUserRetrieveVerifiedFollowersResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userRetrieveVerifiedFollowersResponse),
                jacksonTypeRef<UserRetrieveVerifiedFollowersResponse>(),
            )

        assertThat(roundtrippedUserRetrieveVerifiedFollowersResponse)
            .isEqualTo(userRetrieveVerifiedFollowersResponse)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val userRetrieveVerifiedFollowersResponse =
            jsonMapper()
                .convertValue(
                    testCase.value,
                    jacksonTypeRef<UserRetrieveVerifiedFollowersResponse>(),
                )

        val e =
            assertThrows<XTwitterScraperInvalidDataException> {
                userRetrieveVerifiedFollowersResponse.validate()
            }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }

    @Test
    fun readsEveryFieldTheSpecDescribes() {
        val userRetrieveVerifiedFollowersResponse =
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
                      "has_next_page": false,
                      "next_cursor": "",
                      "diagnostic": {
                        "complete": false,
                        "cursorFailureCount": 2003,
                        "deadlineReached": true,
                        "duplicateCount": 1576,
                        "failedStrategyCount": 2085,
                        "malformedCount": 1572,
                        "pagesFetched": 1319,
                        "responseTruncated": false,
                        "resultLimitReached": true,
                        "stalledStrategyCount": 2217,
                        "strategyCount": 1504,
                        "returnedUsers": 1503,
                        "strategies": [
                          {
                            "duplicateCount": 1576,
                            "pagesFetched": 1319,
                            "stopReason": "cursor_failure",
                            "strategy": 983,
                            "uniqueAdded": 1229
                          }
                        ],
                        "uniqueUsers": 1293
                      }
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<UserRetrieveVerifiedFollowersResponse>(),
                )

        userRetrieveVerifiedFollowersResponse.validate()
        assertThat(userRetrieveVerifiedFollowersResponse.isListCoverage()).isTrue()
        assertThat(userRetrieveVerifiedFollowersResponse.asListCoverage().hasNextPage())
            .isEqualTo(false)
        assertThat(userRetrieveVerifiedFollowersResponse.asListCoverage().nextCursor())
            .isEqualTo("")
        assertThat(userRetrieveVerifiedFollowersResponse.asListCoverage().users()).hasSize(1)
        assertThat(userRetrieveVerifiedFollowersResponse.asListCoverage().users()[0].id())
            .isEqualTo("11348282")
        assertThat(userRetrieveVerifiedFollowersResponse.asListCoverage().users()[0].name())
            .isEqualTo("NASA")
        assertThat(userRetrieveVerifiedFollowersResponse.asListCoverage().users()[0].username())
            .isEqualTo("NASA")
        assertThat(userRetrieveVerifiedFollowersResponse.asListCoverage().diagnostic().complete())
            .isEqualTo(false)
        assertThat(
                userRetrieveVerifiedFollowersResponse
                    .asListCoverage()
                    .diagnostic()
                    .cursorFailureCount()
            )
            .isEqualTo(2003L)
        assertThat(
                userRetrieveVerifiedFollowersResponse
                    .asListCoverage()
                    .diagnostic()
                    .deadlineReached()
            )
            .isEqualTo(true)
        assertThat(
                userRetrieveVerifiedFollowersResponse.asListCoverage().diagnostic().duplicateCount()
            )
            .isEqualTo(1576L)
        assertThat(
                userRetrieveVerifiedFollowersResponse
                    .asListCoverage()
                    .diagnostic()
                    .failedStrategyCount()
            )
            .isEqualTo(2085L)
        assertThat(
                userRetrieveVerifiedFollowersResponse.asListCoverage().diagnostic().malformedCount()
            )
            .isEqualTo(1572L)
        assertThat(
                userRetrieveVerifiedFollowersResponse.asListCoverage().diagnostic().pagesFetched()
            )
            .isEqualTo(1319L)
        assertThat(
                userRetrieveVerifiedFollowersResponse
                    .asListCoverage()
                    .diagnostic()
                    .responseTruncated()
            )
            .isEqualTo(false)
        assertThat(
                userRetrieveVerifiedFollowersResponse
                    .asListCoverage()
                    .diagnostic()
                    .resultLimitReached()
            )
            .isEqualTo(true)
        assertThat(
                userRetrieveVerifiedFollowersResponse.asListCoverage().diagnostic().returnedUsers()
            )
            .isEqualTo(1503L)
        assertThat(
                userRetrieveVerifiedFollowersResponse
                    .asListCoverage()
                    .diagnostic()
                    .stalledStrategyCount()
            )
            .isEqualTo(2217L)
        assertThat(userRetrieveVerifiedFollowersResponse.asListCoverage().diagnostic().strategies())
            .hasSize(1)
        assertThat(
                userRetrieveVerifiedFollowersResponse
                    .asListCoverage()
                    .diagnostic()
                    .strategies()[0]
                    .duplicateCount()
            )
            .isEqualTo(1576L)
        assertThat(
                userRetrieveVerifiedFollowersResponse
                    .asListCoverage()
                    .diagnostic()
                    .strategies()[0]
                    .pagesFetched()
            )
            .isEqualTo(1319L)
        assertThat(
                userRetrieveVerifiedFollowersResponse
                    .asListCoverage()
                    .diagnostic()
                    .strategies()[0]
                    .stopReason()
            )
            .isEqualTo(
                UserRetrieveVerifiedFollowersResponse.UserListCoverageResponse.Diagnostic.Strategy
                    .StopReason
                    .CURSOR_FAILURE
            )
        assertThat(
                userRetrieveVerifiedFollowersResponse
                    .asListCoverage()
                    .diagnostic()
                    .strategies()[0]
                    .strategy()
            )
            .isEqualTo(983L)
        assertThat(
                userRetrieveVerifiedFollowersResponse
                    .asListCoverage()
                    .diagnostic()
                    .strategies()[0]
                    .uniqueAdded()
            )
            .isEqualTo(1229L)
        assertThat(
                userRetrieveVerifiedFollowersResponse
                    .asListCoverage()
                    .diagnostic()
                    .strategies()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                userRetrieveVerifiedFollowersResponse.asListCoverage().diagnostic().strategyCount()
            )
            .isEqualTo(1504L)
        assertThat(
                userRetrieveVerifiedFollowersResponse.asListCoverage().diagnostic().uniqueUsers()
            )
            .isEqualTo(1293L)
        assertThat(
                userRetrieveVerifiedFollowersResponse
                    .asListCoverage()
                    .diagnostic()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(userRetrieveVerifiedFollowersResponse.asListCoverage().filteredCount())
            .contains(1595L)
        assertThat(userRetrieveVerifiedFollowersResponse.asListCoverage()._additionalProperties())
            .isEmpty()
        assertThat(
                userRetrieveVerifiedFollowersResponse
                    .asListCoverage()
                    .toPaginatedUsers()
                    ._hasNextPage()
            )
            .isEqualTo(userRetrieveVerifiedFollowersResponse.asListCoverage()._hasNextPage())
        assertThat(
                userRetrieveVerifiedFollowersResponse
                    .asListCoverage()
                    .toPaginatedUsers()
                    ._nextCursor()
            )
            .isEqualTo(userRetrieveVerifiedFollowersResponse.asListCoverage()._nextCursor())
        assertThat(
                userRetrieveVerifiedFollowersResponse.asListCoverage().toPaginatedUsers()._users()
            )
            .isEqualTo(userRetrieveVerifiedFollowersResponse.asListCoverage()._users())
        assertThat(
                userRetrieveVerifiedFollowersResponse
                    .asListCoverage()
                    .toPaginatedUsers()
                    ._filteredCount()
            )
            .isEqualTo(userRetrieveVerifiedFollowersResponse.asListCoverage()._filteredCount())
    }
}
