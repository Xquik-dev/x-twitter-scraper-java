// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.ContentDisclosure
import com.x_twitter_scraper.api.models.EmbeddedTweet
import com.x_twitter_scraper.api.models.TweetMedia
import com.x_twitter_scraper.api.models.UnknownCount
import com.x_twitter_scraper.api.models.UserProfile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetRetrieveResponseTest {

    @Test
    fun create() {
        val tweetRetrieveResponse =
            TweetRetrieveResponse.builder()
                .tweet(
                    TweetDetail.builder()
                        .id("1234567890")
                        .bookmarkCount(2L)
                        .likeCount(42L)
                        .quoteCount(1L)
                        .replyCount(3L)
                        .retweetCount(5L)
                        .text("Just launched our new feature!")
                        .viewCount(1500L)
                        .article(
                            TweetDetail.Article.builder()
                                .id("id")
                                .coverMediaUrl("coverMediaUrl")
                                .previewText("previewText")
                                .title("title")
                                .build()
                        )
                        .author(
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
                                .profileBannerUrl(
                                    "https://pbs.twimg.com/profile_banners/example.jpg"
                                )
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
                        .card(
                            TweetDetail.Card.builder()
                                .id("id")
                                .bindingValues(
                                    TweetDetail.Card.BindingValues.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .name("name")
                                .url("url")
                                .build()
                        )
                        .communityNote(
                            TweetDetail.CommunityNote.builder()
                                .id("id")
                                .destinationUrl("destinationUrl")
                                .footer("footer")
                                .shortTitle("shortTitle")
                                .subtitle("subtitle")
                                .title("title")
                                .visualStyle("visualStyle")
                                .build()
                        )
                        .contentDisclosure(
                            ContentDisclosure.builder()
                                .advertising(
                                    ContentDisclosure.Advertising.builder()
                                        .isPaidPromotion(true)
                                        .build()
                                )
                                .aiGenerated(
                                    ContentDisclosure.AiGenerated.builder()
                                        .detectionSource("UserDeclared")
                                        .hasAiGeneratedMedia(true)
                                        .build()
                                )
                                .build()
                        )
                        .conversationId("1234567890")
                        .createdAt("2025-01-15T12:00:00Z")
                        .addDisplayTextRange(0L)
                        .addDisplayTextRange(31L)
                        .edit(
                            TweetDetail.Edit.builder()
                                .editableUntilMsecs("editableUntilMsecs")
                                .addEditTweetId("string")
                                .build()
                        )
                        .entities(
                            TweetDetail.Entities.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .inReplyToId("1234567890")
                        .inReplyToUserId("9876543210")
                        .inReplyToUsername("example_user")
                        .isLimitedReply(false)
                        .isNoteTweet(false)
                        .isQuoteStatus(false)
                        .isReply(false)
                        .isTranslatable(true)
                        .lang("en")
                        .addMedia(
                            TweetMedia.builder()
                                .mediaUrl("mediaUrl")
                                .type(TweetMedia.Type.PHOTO)
                                .url("url")
                                .id("id")
                                .allowDownload(true)
                                .altText("altText")
                                .addAspectRatio(0L)
                                .availabilityStatus("availabilityStatus")
                                .displayUrl("displayUrl")
                                .durationMillis(0L)
                                .expandedUrl("expandedUrl")
                                .faceRects(
                                    TweetMedia.FaceRects.builder()
                                        .putAdditionalProperty(
                                            "foo",
                                            JsonValue.from(
                                                listOf(
                                                    mapOf("h" to 0, "w" to 0, "x" to 0, "y" to 0)
                                                )
                                            ),
                                        )
                                        .build()
                                )
                                .addFocusRect(
                                    TweetMedia.FocusRect.builder().h(0L).w(0L).x(0L).y(0L).build()
                                )
                                .height(0L)
                                .addIndex(0L)
                                .mediaKey("mediaKey")
                                .monetizable(true)
                                .sizes(
                                    TweetMedia.Sizes.builder()
                                        .putAdditionalProperty(
                                            "foo",
                                            JsonValue.from(
                                                mapOf("h" to 0, "resize" to "resize", "w" to 0)
                                            ),
                                        )
                                        .build()
                                )
                                .addVideoVariant(
                                    TweetMedia.VideoVariant.builder()
                                        .contentType("contentType")
                                        .url("url")
                                        .bitrate(0L)
                                        .build()
                                )
                                .width(0L)
                                .build()
                        )
                        .noteTweet(
                            TweetDetail.NoteTweet.builder()
                                .text("text")
                                .id("id")
                                .entities(
                                    TweetDetail.NoteTweet.Entities.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .isExpandable(true)
                                .addRichtextTag(
                                    TweetDetail.NoteTweet.RichtextTag.builder()
                                        .fromIndex(0L)
                                        .toIndex(0L)
                                        .addType("string")
                                        .build()
                                )
                                .build()
                        )
                        .place(
                            TweetDetail.Place.builder()
                                .id("id")
                                .boundingBox(
                                    TweetDetail.Place.BoundingBox.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .country("country")
                                .countryCode("countryCode")
                                .fullName("fullName")
                                .name("name")
                                .placeType("placeType")
                                .url("url")
                                .build()
                        )
                        .possiblySensitive(true)
                        .previousCounts(
                            TweetDetail.PreviousCounts.builder()
                                .bookmarkCount(0L)
                                .likeCount(0L)
                                .quoteCount(0L)
                                .replyCount(0L)
                                .retweetCount(0L)
                                .build()
                        )
                        .quotedTweet(
                            EmbeddedTweet.builder()
                                .id("id")
                                .bookmarkCount(0L)
                                .likeCount(0L)
                                .quoteCount(0L)
                                .replyCount(0L)
                                .retweetCount(0L)
                                .text("text")
                                .viewCount(0L)
                                .article(
                                    EmbeddedTweet.Article.builder()
                                        .id("id")
                                        .coverMediaUrl("coverMediaUrl")
                                        .previewText("previewText")
                                        .title("title")
                                        .build()
                                )
                                .author(
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
                                        .coverPicture(
                                            "https://pbs.twimg.com/profile_banners/example.jpg"
                                        )
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
                                                .putAdditionalProperty(
                                                    "description",
                                                    JsonValue.from("bar"),
                                                )
                                                .putAdditionalProperty(
                                                    "entities",
                                                    JsonValue.from("bar"),
                                                )
                                                .build()
                                        )
                                        .profileBannerUrl(
                                            "https://pbs.twimg.com/profile_banners/example.jpg"
                                        )
                                        .profileDescriptionLanguage("profileDescriptionLanguage")
                                        .profileImageShape("profileImageShape")
                                        .profileInterstitialType("profileInterstitialType")
                                        .profilePicture(
                                            "https://pbs.twimg.com/profile_images/example.jpg"
                                        )
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
                                .card(
                                    EmbeddedTweet.Card.builder()
                                        .id("id")
                                        .bindingValues(
                                            EmbeddedTweet.Card.BindingValues.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .name("name")
                                        .url("url")
                                        .build()
                                )
                                .communityNote(
                                    EmbeddedTweet.CommunityNote.builder()
                                        .id("id")
                                        .destinationUrl("destinationUrl")
                                        .footer("footer")
                                        .shortTitle("shortTitle")
                                        .subtitle("subtitle")
                                        .title("title")
                                        .visualStyle("visualStyle")
                                        .build()
                                )
                                .contentDisclosure(
                                    ContentDisclosure.builder()
                                        .advertising(
                                            ContentDisclosure.Advertising.builder()
                                                .isPaidPromotion(true)
                                                .build()
                                        )
                                        .aiGenerated(
                                            ContentDisclosure.AiGenerated.builder()
                                                .detectionSource("UserDeclared")
                                                .hasAiGeneratedMedia(true)
                                                .build()
                                        )
                                        .build()
                                )
                                .conversationId("conversationId")
                                .createdAt("createdAt")
                                .addDisplayTextRange(0L)
                                .edit(
                                    EmbeddedTweet.Edit.builder()
                                        .editableUntilMsecs("editableUntilMsecs")
                                        .addEditTweetId("string")
                                        .build()
                                )
                                .entities(
                                    EmbeddedTweet.Entities.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .inReplyToId("inReplyToId")
                                .inReplyToUserId("inReplyToUserId")
                                .inReplyToUsername("inReplyToUsername")
                                .isLimitedReply(true)
                                .isNoteTweet(true)
                                .isQuoteStatus(true)
                                .isReply(true)
                                .isTranslatable(true)
                                .lang("lang")
                                .addMedia(
                                    TweetMedia.builder()
                                        .mediaUrl("mediaUrl")
                                        .type(TweetMedia.Type.PHOTO)
                                        .url("url")
                                        .id("id")
                                        .allowDownload(true)
                                        .altText("altText")
                                        .addAspectRatio(0L)
                                        .availabilityStatus("availabilityStatus")
                                        .displayUrl("displayUrl")
                                        .durationMillis(0L)
                                        .expandedUrl("expandedUrl")
                                        .faceRects(
                                            TweetMedia.FaceRects.builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(
                                                        listOf(
                                                            mapOf(
                                                                "h" to 0,
                                                                "w" to 0,
                                                                "x" to 0,
                                                                "y" to 0,
                                                            )
                                                        )
                                                    ),
                                                )
                                                .build()
                                        )
                                        .addFocusRect(
                                            TweetMedia.FocusRect.builder()
                                                .h(0L)
                                                .w(0L)
                                                .x(0L)
                                                .y(0L)
                                                .build()
                                        )
                                        .height(0L)
                                        .addIndex(0L)
                                        .mediaKey("mediaKey")
                                        .monetizable(true)
                                        .sizes(
                                            TweetMedia.Sizes.builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(
                                                        mapOf(
                                                            "h" to 0,
                                                            "resize" to "resize",
                                                            "w" to 0,
                                                        )
                                                    ),
                                                )
                                                .build()
                                        )
                                        .addVideoVariant(
                                            TweetMedia.VideoVariant.builder()
                                                .contentType("contentType")
                                                .url("url")
                                                .bitrate(0L)
                                                .build()
                                        )
                                        .width(0L)
                                        .build()
                                )
                                .noteTweet(
                                    EmbeddedTweet.NoteTweet.builder()
                                        .text("text")
                                        .id("id")
                                        .entities(
                                            EmbeddedTweet.NoteTweet.Entities.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .isExpandable(true)
                                        .addRichtextTag(
                                            EmbeddedTweet.NoteTweet.RichtextTag.builder()
                                                .fromIndex(0L)
                                                .toIndex(0L)
                                                .addType("string")
                                                .build()
                                        )
                                        .build()
                                )
                                .place(
                                    EmbeddedTweet.Place.builder()
                                        .id("id")
                                        .boundingBox(
                                            EmbeddedTweet.Place.BoundingBox.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .country("country")
                                        .countryCode("countryCode")
                                        .fullName("fullName")
                                        .name("name")
                                        .placeType("placeType")
                                        .url("url")
                                        .build()
                                )
                                .possiblySensitive(true)
                                .previousCounts(
                                    EmbeddedTweet.PreviousCounts.builder()
                                        .bookmarkCount(0L)
                                        .likeCount(0L)
                                        .quoteCount(0L)
                                        .replyCount(0L)
                                        .retweetCount(0L)
                                        .build()
                                )
                                .source("source")
                                .type("type")
                                .url("url")
                                .viewState("viewState")
                                .build()
                        )
                        .retweetedTweet(
                            EmbeddedTweet.builder()
                                .id("id")
                                .bookmarkCount(0L)
                                .likeCount(0L)
                                .quoteCount(0L)
                                .replyCount(0L)
                                .retweetCount(0L)
                                .text("text")
                                .viewCount(0L)
                                .article(
                                    EmbeddedTweet.Article.builder()
                                        .id("id")
                                        .coverMediaUrl("coverMediaUrl")
                                        .previewText("previewText")
                                        .title("title")
                                        .build()
                                )
                                .author(
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
                                        .coverPicture(
                                            "https://pbs.twimg.com/profile_banners/example.jpg"
                                        )
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
                                                .putAdditionalProperty(
                                                    "description",
                                                    JsonValue.from("bar"),
                                                )
                                                .putAdditionalProperty(
                                                    "entities",
                                                    JsonValue.from("bar"),
                                                )
                                                .build()
                                        )
                                        .profileBannerUrl(
                                            "https://pbs.twimg.com/profile_banners/example.jpg"
                                        )
                                        .profileDescriptionLanguage("profileDescriptionLanguage")
                                        .profileImageShape("profileImageShape")
                                        .profileInterstitialType("profileInterstitialType")
                                        .profilePicture(
                                            "https://pbs.twimg.com/profile_images/example.jpg"
                                        )
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
                                .card(
                                    EmbeddedTweet.Card.builder()
                                        .id("id")
                                        .bindingValues(
                                            EmbeddedTweet.Card.BindingValues.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .name("name")
                                        .url("url")
                                        .build()
                                )
                                .communityNote(
                                    EmbeddedTweet.CommunityNote.builder()
                                        .id("id")
                                        .destinationUrl("destinationUrl")
                                        .footer("footer")
                                        .shortTitle("shortTitle")
                                        .subtitle("subtitle")
                                        .title("title")
                                        .visualStyle("visualStyle")
                                        .build()
                                )
                                .contentDisclosure(
                                    ContentDisclosure.builder()
                                        .advertising(
                                            ContentDisclosure.Advertising.builder()
                                                .isPaidPromotion(true)
                                                .build()
                                        )
                                        .aiGenerated(
                                            ContentDisclosure.AiGenerated.builder()
                                                .detectionSource("UserDeclared")
                                                .hasAiGeneratedMedia(true)
                                                .build()
                                        )
                                        .build()
                                )
                                .conversationId("conversationId")
                                .createdAt("createdAt")
                                .addDisplayTextRange(0L)
                                .edit(
                                    EmbeddedTweet.Edit.builder()
                                        .editableUntilMsecs("editableUntilMsecs")
                                        .addEditTweetId("string")
                                        .build()
                                )
                                .entities(
                                    EmbeddedTweet.Entities.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .inReplyToId("inReplyToId")
                                .inReplyToUserId("inReplyToUserId")
                                .inReplyToUsername("inReplyToUsername")
                                .isLimitedReply(true)
                                .isNoteTweet(true)
                                .isQuoteStatus(true)
                                .isReply(true)
                                .isTranslatable(true)
                                .lang("lang")
                                .addMedia(
                                    TweetMedia.builder()
                                        .mediaUrl("mediaUrl")
                                        .type(TweetMedia.Type.PHOTO)
                                        .url("url")
                                        .id("id")
                                        .allowDownload(true)
                                        .altText("altText")
                                        .addAspectRatio(0L)
                                        .availabilityStatus("availabilityStatus")
                                        .displayUrl("displayUrl")
                                        .durationMillis(0L)
                                        .expandedUrl("expandedUrl")
                                        .faceRects(
                                            TweetMedia.FaceRects.builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(
                                                        listOf(
                                                            mapOf(
                                                                "h" to 0,
                                                                "w" to 0,
                                                                "x" to 0,
                                                                "y" to 0,
                                                            )
                                                        )
                                                    ),
                                                )
                                                .build()
                                        )
                                        .addFocusRect(
                                            TweetMedia.FocusRect.builder()
                                                .h(0L)
                                                .w(0L)
                                                .x(0L)
                                                .y(0L)
                                                .build()
                                        )
                                        .height(0L)
                                        .addIndex(0L)
                                        .mediaKey("mediaKey")
                                        .monetizable(true)
                                        .sizes(
                                            TweetMedia.Sizes.builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(
                                                        mapOf(
                                                            "h" to 0,
                                                            "resize" to "resize",
                                                            "w" to 0,
                                                        )
                                                    ),
                                                )
                                                .build()
                                        )
                                        .addVideoVariant(
                                            TweetMedia.VideoVariant.builder()
                                                .contentType("contentType")
                                                .url("url")
                                                .bitrate(0L)
                                                .build()
                                        )
                                        .width(0L)
                                        .build()
                                )
                                .noteTweet(
                                    EmbeddedTweet.NoteTweet.builder()
                                        .text("text")
                                        .id("id")
                                        .entities(
                                            EmbeddedTweet.NoteTweet.Entities.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .isExpandable(true)
                                        .addRichtextTag(
                                            EmbeddedTweet.NoteTweet.RichtextTag.builder()
                                                .fromIndex(0L)
                                                .toIndex(0L)
                                                .addType("string")
                                                .build()
                                        )
                                        .build()
                                )
                                .place(
                                    EmbeddedTweet.Place.builder()
                                        .id("id")
                                        .boundingBox(
                                            EmbeddedTweet.Place.BoundingBox.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .country("country")
                                        .countryCode("countryCode")
                                        .fullName("fullName")
                                        .name("name")
                                        .placeType("placeType")
                                        .url("url")
                                        .build()
                                )
                                .possiblySensitive(true)
                                .previousCounts(
                                    EmbeddedTweet.PreviousCounts.builder()
                                        .bookmarkCount(0L)
                                        .likeCount(0L)
                                        .quoteCount(0L)
                                        .replyCount(0L)
                                        .retweetCount(0L)
                                        .build()
                                )
                                .source("source")
                                .type("type")
                                .url("url")
                                .viewState("viewState")
                                .build()
                        )
                        .source("Twitter Web App")
                        .type("tweet")
                        .url("https://x.com/example_user/status/1234567890")
                        .viewState("viewState")
                        .build()
                )
                .author(
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
                )
                .build()

        assertThat(tweetRetrieveResponse.tweet())
            .isEqualTo(
                TweetDetail.builder()
                    .id("1234567890")
                    .bookmarkCount(2L)
                    .likeCount(42L)
                    .quoteCount(1L)
                    .replyCount(3L)
                    .retweetCount(5L)
                    .text("Just launched our new feature!")
                    .viewCount(1500L)
                    .article(
                        TweetDetail.Article.builder()
                            .id("id")
                            .coverMediaUrl("coverMediaUrl")
                            .previewText("previewText")
                            .title("title")
                            .build()
                    )
                    .author(
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
                    )
                    .card(
                        TweetDetail.Card.builder()
                            .id("id")
                            .bindingValues(
                                TweetDetail.Card.BindingValues.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .name("name")
                            .url("url")
                            .build()
                    )
                    .communityNote(
                        TweetDetail.CommunityNote.builder()
                            .id("id")
                            .destinationUrl("destinationUrl")
                            .footer("footer")
                            .shortTitle("shortTitle")
                            .subtitle("subtitle")
                            .title("title")
                            .visualStyle("visualStyle")
                            .build()
                    )
                    .contentDisclosure(
                        ContentDisclosure.builder()
                            .advertising(
                                ContentDisclosure.Advertising.builder()
                                    .isPaidPromotion(true)
                                    .build()
                            )
                            .aiGenerated(
                                ContentDisclosure.AiGenerated.builder()
                                    .detectionSource("UserDeclared")
                                    .hasAiGeneratedMedia(true)
                                    .build()
                            )
                            .build()
                    )
                    .conversationId("1234567890")
                    .createdAt("2025-01-15T12:00:00Z")
                    .addDisplayTextRange(0L)
                    .addDisplayTextRange(31L)
                    .edit(
                        TweetDetail.Edit.builder()
                            .editableUntilMsecs("editableUntilMsecs")
                            .addEditTweetId("string")
                            .build()
                    )
                    .entities(
                        TweetDetail.Entities.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .inReplyToId("1234567890")
                    .inReplyToUserId("9876543210")
                    .inReplyToUsername("example_user")
                    .isLimitedReply(false)
                    .isNoteTweet(false)
                    .isQuoteStatus(false)
                    .isReply(false)
                    .isTranslatable(true)
                    .lang("en")
                    .addMedia(
                        TweetMedia.builder()
                            .mediaUrl("mediaUrl")
                            .type(TweetMedia.Type.PHOTO)
                            .url("url")
                            .id("id")
                            .allowDownload(true)
                            .altText("altText")
                            .addAspectRatio(0L)
                            .availabilityStatus("availabilityStatus")
                            .displayUrl("displayUrl")
                            .durationMillis(0L)
                            .expandedUrl("expandedUrl")
                            .faceRects(
                                TweetMedia.FaceRects.builder()
                                    .putAdditionalProperty(
                                        "foo",
                                        JsonValue.from(
                                            listOf(mapOf("h" to 0, "w" to 0, "x" to 0, "y" to 0))
                                        ),
                                    )
                                    .build()
                            )
                            .addFocusRect(
                                TweetMedia.FocusRect.builder().h(0L).w(0L).x(0L).y(0L).build()
                            )
                            .height(0L)
                            .addIndex(0L)
                            .mediaKey("mediaKey")
                            .monetizable(true)
                            .sizes(
                                TweetMedia.Sizes.builder()
                                    .putAdditionalProperty(
                                        "foo",
                                        JsonValue.from(
                                            mapOf("h" to 0, "resize" to "resize", "w" to 0)
                                        ),
                                    )
                                    .build()
                            )
                            .addVideoVariant(
                                TweetMedia.VideoVariant.builder()
                                    .contentType("contentType")
                                    .url("url")
                                    .bitrate(0L)
                                    .build()
                            )
                            .width(0L)
                            .build()
                    )
                    .noteTweet(
                        TweetDetail.NoteTweet.builder()
                            .text("text")
                            .id("id")
                            .entities(
                                TweetDetail.NoteTweet.Entities.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .isExpandable(true)
                            .addRichtextTag(
                                TweetDetail.NoteTweet.RichtextTag.builder()
                                    .fromIndex(0L)
                                    .toIndex(0L)
                                    .addType("string")
                                    .build()
                            )
                            .build()
                    )
                    .place(
                        TweetDetail.Place.builder()
                            .id("id")
                            .boundingBox(
                                TweetDetail.Place.BoundingBox.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .country("country")
                            .countryCode("countryCode")
                            .fullName("fullName")
                            .name("name")
                            .placeType("placeType")
                            .url("url")
                            .build()
                    )
                    .possiblySensitive(true)
                    .previousCounts(
                        TweetDetail.PreviousCounts.builder()
                            .bookmarkCount(0L)
                            .likeCount(0L)
                            .quoteCount(0L)
                            .replyCount(0L)
                            .retweetCount(0L)
                            .build()
                    )
                    .quotedTweet(
                        EmbeddedTweet.builder()
                            .id("id")
                            .bookmarkCount(0L)
                            .likeCount(0L)
                            .quoteCount(0L)
                            .replyCount(0L)
                            .retweetCount(0L)
                            .text("text")
                            .viewCount(0L)
                            .article(
                                EmbeddedTweet.Article.builder()
                                    .id("id")
                                    .coverMediaUrl("coverMediaUrl")
                                    .previewText("previewText")
                                    .title("title")
                                    .build()
                            )
                            .author(
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
                                    .coverPicture(
                                        "https://pbs.twimg.com/profile_banners/example.jpg"
                                    )
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
                                            .putAdditionalProperty(
                                                "description",
                                                JsonValue.from("bar"),
                                            )
                                            .putAdditionalProperty(
                                                "entities",
                                                JsonValue.from("bar"),
                                            )
                                            .build()
                                    )
                                    .profileBannerUrl(
                                        "https://pbs.twimg.com/profile_banners/example.jpg"
                                    )
                                    .profileDescriptionLanguage("profileDescriptionLanguage")
                                    .profileImageShape("profileImageShape")
                                    .profileInterstitialType("profileInterstitialType")
                                    .profilePicture(
                                        "https://pbs.twimg.com/profile_images/example.jpg"
                                    )
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
                            .card(
                                EmbeddedTweet.Card.builder()
                                    .id("id")
                                    .bindingValues(
                                        EmbeddedTweet.Card.BindingValues.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .name("name")
                                    .url("url")
                                    .build()
                            )
                            .communityNote(
                                EmbeddedTweet.CommunityNote.builder()
                                    .id("id")
                                    .destinationUrl("destinationUrl")
                                    .footer("footer")
                                    .shortTitle("shortTitle")
                                    .subtitle("subtitle")
                                    .title("title")
                                    .visualStyle("visualStyle")
                                    .build()
                            )
                            .contentDisclosure(
                                ContentDisclosure.builder()
                                    .advertising(
                                        ContentDisclosure.Advertising.builder()
                                            .isPaidPromotion(true)
                                            .build()
                                    )
                                    .aiGenerated(
                                        ContentDisclosure.AiGenerated.builder()
                                            .detectionSource("UserDeclared")
                                            .hasAiGeneratedMedia(true)
                                            .build()
                                    )
                                    .build()
                            )
                            .conversationId("conversationId")
                            .createdAt("createdAt")
                            .addDisplayTextRange(0L)
                            .edit(
                                EmbeddedTweet.Edit.builder()
                                    .editableUntilMsecs("editableUntilMsecs")
                                    .addEditTweetId("string")
                                    .build()
                            )
                            .entities(
                                EmbeddedTweet.Entities.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .inReplyToId("inReplyToId")
                            .inReplyToUserId("inReplyToUserId")
                            .inReplyToUsername("inReplyToUsername")
                            .isLimitedReply(true)
                            .isNoteTweet(true)
                            .isQuoteStatus(true)
                            .isReply(true)
                            .isTranslatable(true)
                            .lang("lang")
                            .addMedia(
                                TweetMedia.builder()
                                    .mediaUrl("mediaUrl")
                                    .type(TweetMedia.Type.PHOTO)
                                    .url("url")
                                    .id("id")
                                    .allowDownload(true)
                                    .altText("altText")
                                    .addAspectRatio(0L)
                                    .availabilityStatus("availabilityStatus")
                                    .displayUrl("displayUrl")
                                    .durationMillis(0L)
                                    .expandedUrl("expandedUrl")
                                    .faceRects(
                                        TweetMedia.FaceRects.builder()
                                            .putAdditionalProperty(
                                                "foo",
                                                JsonValue.from(
                                                    listOf(
                                                        mapOf(
                                                            "h" to 0,
                                                            "w" to 0,
                                                            "x" to 0,
                                                            "y" to 0,
                                                        )
                                                    )
                                                ),
                                            )
                                            .build()
                                    )
                                    .addFocusRect(
                                        TweetMedia.FocusRect.builder()
                                            .h(0L)
                                            .w(0L)
                                            .x(0L)
                                            .y(0L)
                                            .build()
                                    )
                                    .height(0L)
                                    .addIndex(0L)
                                    .mediaKey("mediaKey")
                                    .monetizable(true)
                                    .sizes(
                                        TweetMedia.Sizes.builder()
                                            .putAdditionalProperty(
                                                "foo",
                                                JsonValue.from(
                                                    mapOf("h" to 0, "resize" to "resize", "w" to 0)
                                                ),
                                            )
                                            .build()
                                    )
                                    .addVideoVariant(
                                        TweetMedia.VideoVariant.builder()
                                            .contentType("contentType")
                                            .url("url")
                                            .bitrate(0L)
                                            .build()
                                    )
                                    .width(0L)
                                    .build()
                            )
                            .noteTweet(
                                EmbeddedTweet.NoteTweet.builder()
                                    .text("text")
                                    .id("id")
                                    .entities(
                                        EmbeddedTweet.NoteTweet.Entities.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .isExpandable(true)
                                    .addRichtextTag(
                                        EmbeddedTweet.NoteTweet.RichtextTag.builder()
                                            .fromIndex(0L)
                                            .toIndex(0L)
                                            .addType("string")
                                            .build()
                                    )
                                    .build()
                            )
                            .place(
                                EmbeddedTweet.Place.builder()
                                    .id("id")
                                    .boundingBox(
                                        EmbeddedTweet.Place.BoundingBox.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .country("country")
                                    .countryCode("countryCode")
                                    .fullName("fullName")
                                    .name("name")
                                    .placeType("placeType")
                                    .url("url")
                                    .build()
                            )
                            .possiblySensitive(true)
                            .previousCounts(
                                EmbeddedTweet.PreviousCounts.builder()
                                    .bookmarkCount(0L)
                                    .likeCount(0L)
                                    .quoteCount(0L)
                                    .replyCount(0L)
                                    .retweetCount(0L)
                                    .build()
                            )
                            .source("source")
                            .type("type")
                            .url("url")
                            .viewState("viewState")
                            .build()
                    )
                    .retweetedTweet(
                        EmbeddedTweet.builder()
                            .id("id")
                            .bookmarkCount(0L)
                            .likeCount(0L)
                            .quoteCount(0L)
                            .replyCount(0L)
                            .retweetCount(0L)
                            .text("text")
                            .viewCount(0L)
                            .article(
                                EmbeddedTweet.Article.builder()
                                    .id("id")
                                    .coverMediaUrl("coverMediaUrl")
                                    .previewText("previewText")
                                    .title("title")
                                    .build()
                            )
                            .author(
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
                                    .coverPicture(
                                        "https://pbs.twimg.com/profile_banners/example.jpg"
                                    )
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
                                            .putAdditionalProperty(
                                                "description",
                                                JsonValue.from("bar"),
                                            )
                                            .putAdditionalProperty(
                                                "entities",
                                                JsonValue.from("bar"),
                                            )
                                            .build()
                                    )
                                    .profileBannerUrl(
                                        "https://pbs.twimg.com/profile_banners/example.jpg"
                                    )
                                    .profileDescriptionLanguage("profileDescriptionLanguage")
                                    .profileImageShape("profileImageShape")
                                    .profileInterstitialType("profileInterstitialType")
                                    .profilePicture(
                                        "https://pbs.twimg.com/profile_images/example.jpg"
                                    )
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
                            .card(
                                EmbeddedTweet.Card.builder()
                                    .id("id")
                                    .bindingValues(
                                        EmbeddedTweet.Card.BindingValues.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .name("name")
                                    .url("url")
                                    .build()
                            )
                            .communityNote(
                                EmbeddedTweet.CommunityNote.builder()
                                    .id("id")
                                    .destinationUrl("destinationUrl")
                                    .footer("footer")
                                    .shortTitle("shortTitle")
                                    .subtitle("subtitle")
                                    .title("title")
                                    .visualStyle("visualStyle")
                                    .build()
                            )
                            .contentDisclosure(
                                ContentDisclosure.builder()
                                    .advertising(
                                        ContentDisclosure.Advertising.builder()
                                            .isPaidPromotion(true)
                                            .build()
                                    )
                                    .aiGenerated(
                                        ContentDisclosure.AiGenerated.builder()
                                            .detectionSource("UserDeclared")
                                            .hasAiGeneratedMedia(true)
                                            .build()
                                    )
                                    .build()
                            )
                            .conversationId("conversationId")
                            .createdAt("createdAt")
                            .addDisplayTextRange(0L)
                            .edit(
                                EmbeddedTweet.Edit.builder()
                                    .editableUntilMsecs("editableUntilMsecs")
                                    .addEditTweetId("string")
                                    .build()
                            )
                            .entities(
                                EmbeddedTweet.Entities.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                                    .build()
                            )
                            .inReplyToId("inReplyToId")
                            .inReplyToUserId("inReplyToUserId")
                            .inReplyToUsername("inReplyToUsername")
                            .isLimitedReply(true)
                            .isNoteTweet(true)
                            .isQuoteStatus(true)
                            .isReply(true)
                            .isTranslatable(true)
                            .lang("lang")
                            .addMedia(
                                TweetMedia.builder()
                                    .mediaUrl("mediaUrl")
                                    .type(TweetMedia.Type.PHOTO)
                                    .url("url")
                                    .id("id")
                                    .allowDownload(true)
                                    .altText("altText")
                                    .addAspectRatio(0L)
                                    .availabilityStatus("availabilityStatus")
                                    .displayUrl("displayUrl")
                                    .durationMillis(0L)
                                    .expandedUrl("expandedUrl")
                                    .faceRects(
                                        TweetMedia.FaceRects.builder()
                                            .putAdditionalProperty(
                                                "foo",
                                                JsonValue.from(
                                                    listOf(
                                                        mapOf(
                                                            "h" to 0,
                                                            "w" to 0,
                                                            "x" to 0,
                                                            "y" to 0,
                                                        )
                                                    )
                                                ),
                                            )
                                            .build()
                                    )
                                    .addFocusRect(
                                        TweetMedia.FocusRect.builder()
                                            .h(0L)
                                            .w(0L)
                                            .x(0L)
                                            .y(0L)
                                            .build()
                                    )
                                    .height(0L)
                                    .addIndex(0L)
                                    .mediaKey("mediaKey")
                                    .monetizable(true)
                                    .sizes(
                                        TweetMedia.Sizes.builder()
                                            .putAdditionalProperty(
                                                "foo",
                                                JsonValue.from(
                                                    mapOf("h" to 0, "resize" to "resize", "w" to 0)
                                                ),
                                            )
                                            .build()
                                    )
                                    .addVideoVariant(
                                        TweetMedia.VideoVariant.builder()
                                            .contentType("contentType")
                                            .url("url")
                                            .bitrate(0L)
                                            .build()
                                    )
                                    .width(0L)
                                    .build()
                            )
                            .noteTweet(
                                EmbeddedTweet.NoteTweet.builder()
                                    .text("text")
                                    .id("id")
                                    .entities(
                                        EmbeddedTweet.NoteTweet.Entities.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .isExpandable(true)
                                    .addRichtextTag(
                                        EmbeddedTweet.NoteTweet.RichtextTag.builder()
                                            .fromIndex(0L)
                                            .toIndex(0L)
                                            .addType("string")
                                            .build()
                                    )
                                    .build()
                            )
                            .place(
                                EmbeddedTweet.Place.builder()
                                    .id("id")
                                    .boundingBox(
                                        EmbeddedTweet.Place.BoundingBox.builder()
                                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                                            .build()
                                    )
                                    .country("country")
                                    .countryCode("countryCode")
                                    .fullName("fullName")
                                    .name("name")
                                    .placeType("placeType")
                                    .url("url")
                                    .build()
                            )
                            .possiblySensitive(true)
                            .previousCounts(
                                EmbeddedTweet.PreviousCounts.builder()
                                    .bookmarkCount(0L)
                                    .likeCount(0L)
                                    .quoteCount(0L)
                                    .replyCount(0L)
                                    .retweetCount(0L)
                                    .build()
                            )
                            .source("source")
                            .type("type")
                            .url("url")
                            .viewState("viewState")
                            .build()
                    )
                    .source("Twitter Web App")
                    .type("tweet")
                    .url("https://x.com/example_user/status/1234567890")
                    .viewState("viewState")
                    .build()
            )
        assertThat(tweetRetrieveResponse.author())
            .contains(
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
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetRetrieveResponse =
            TweetRetrieveResponse.builder()
                .tweet(
                    TweetDetail.builder()
                        .id("1234567890")
                        .bookmarkCount(2L)
                        .likeCount(42L)
                        .quoteCount(1L)
                        .replyCount(3L)
                        .retweetCount(5L)
                        .text("Just launched our new feature!")
                        .viewCount(1500L)
                        .article(
                            TweetDetail.Article.builder()
                                .id("id")
                                .coverMediaUrl("coverMediaUrl")
                                .previewText("previewText")
                                .title("title")
                                .build()
                        )
                        .author(
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
                                .profileBannerUrl(
                                    "https://pbs.twimg.com/profile_banners/example.jpg"
                                )
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
                        .card(
                            TweetDetail.Card.builder()
                                .id("id")
                                .bindingValues(
                                    TweetDetail.Card.BindingValues.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .name("name")
                                .url("url")
                                .build()
                        )
                        .communityNote(
                            TweetDetail.CommunityNote.builder()
                                .id("id")
                                .destinationUrl("destinationUrl")
                                .footer("footer")
                                .shortTitle("shortTitle")
                                .subtitle("subtitle")
                                .title("title")
                                .visualStyle("visualStyle")
                                .build()
                        )
                        .contentDisclosure(
                            ContentDisclosure.builder()
                                .advertising(
                                    ContentDisclosure.Advertising.builder()
                                        .isPaidPromotion(true)
                                        .build()
                                )
                                .aiGenerated(
                                    ContentDisclosure.AiGenerated.builder()
                                        .detectionSource("UserDeclared")
                                        .hasAiGeneratedMedia(true)
                                        .build()
                                )
                                .build()
                        )
                        .conversationId("1234567890")
                        .createdAt("2025-01-15T12:00:00Z")
                        .addDisplayTextRange(0L)
                        .addDisplayTextRange(31L)
                        .edit(
                            TweetDetail.Edit.builder()
                                .editableUntilMsecs("editableUntilMsecs")
                                .addEditTweetId("string")
                                .build()
                        )
                        .entities(
                            TweetDetail.Entities.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .inReplyToId("1234567890")
                        .inReplyToUserId("9876543210")
                        .inReplyToUsername("example_user")
                        .isLimitedReply(false)
                        .isNoteTweet(false)
                        .isQuoteStatus(false)
                        .isReply(false)
                        .isTranslatable(true)
                        .lang("en")
                        .addMedia(
                            TweetMedia.builder()
                                .mediaUrl("mediaUrl")
                                .type(TweetMedia.Type.PHOTO)
                                .url("url")
                                .id("id")
                                .allowDownload(true)
                                .altText("altText")
                                .addAspectRatio(0L)
                                .availabilityStatus("availabilityStatus")
                                .displayUrl("displayUrl")
                                .durationMillis(0L)
                                .expandedUrl("expandedUrl")
                                .faceRects(
                                    TweetMedia.FaceRects.builder()
                                        .putAdditionalProperty(
                                            "foo",
                                            JsonValue.from(
                                                listOf(
                                                    mapOf("h" to 0, "w" to 0, "x" to 0, "y" to 0)
                                                )
                                            ),
                                        )
                                        .build()
                                )
                                .addFocusRect(
                                    TweetMedia.FocusRect.builder().h(0L).w(0L).x(0L).y(0L).build()
                                )
                                .height(0L)
                                .addIndex(0L)
                                .mediaKey("mediaKey")
                                .monetizable(true)
                                .sizes(
                                    TweetMedia.Sizes.builder()
                                        .putAdditionalProperty(
                                            "foo",
                                            JsonValue.from(
                                                mapOf("h" to 0, "resize" to "resize", "w" to 0)
                                            ),
                                        )
                                        .build()
                                )
                                .addVideoVariant(
                                    TweetMedia.VideoVariant.builder()
                                        .contentType("contentType")
                                        .url("url")
                                        .bitrate(0L)
                                        .build()
                                )
                                .width(0L)
                                .build()
                        )
                        .noteTweet(
                            TweetDetail.NoteTweet.builder()
                                .text("text")
                                .id("id")
                                .entities(
                                    TweetDetail.NoteTweet.Entities.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .isExpandable(true)
                                .addRichtextTag(
                                    TweetDetail.NoteTweet.RichtextTag.builder()
                                        .fromIndex(0L)
                                        .toIndex(0L)
                                        .addType("string")
                                        .build()
                                )
                                .build()
                        )
                        .place(
                            TweetDetail.Place.builder()
                                .id("id")
                                .boundingBox(
                                    TweetDetail.Place.BoundingBox.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .country("country")
                                .countryCode("countryCode")
                                .fullName("fullName")
                                .name("name")
                                .placeType("placeType")
                                .url("url")
                                .build()
                        )
                        .possiblySensitive(true)
                        .previousCounts(
                            TweetDetail.PreviousCounts.builder()
                                .bookmarkCount(0L)
                                .likeCount(0L)
                                .quoteCount(0L)
                                .replyCount(0L)
                                .retweetCount(0L)
                                .build()
                        )
                        .quotedTweet(
                            EmbeddedTweet.builder()
                                .id("id")
                                .bookmarkCount(0L)
                                .likeCount(0L)
                                .quoteCount(0L)
                                .replyCount(0L)
                                .retweetCount(0L)
                                .text("text")
                                .viewCount(0L)
                                .article(
                                    EmbeddedTweet.Article.builder()
                                        .id("id")
                                        .coverMediaUrl("coverMediaUrl")
                                        .previewText("previewText")
                                        .title("title")
                                        .build()
                                )
                                .author(
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
                                        .coverPicture(
                                            "https://pbs.twimg.com/profile_banners/example.jpg"
                                        )
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
                                                .putAdditionalProperty(
                                                    "description",
                                                    JsonValue.from("bar"),
                                                )
                                                .putAdditionalProperty(
                                                    "entities",
                                                    JsonValue.from("bar"),
                                                )
                                                .build()
                                        )
                                        .profileBannerUrl(
                                            "https://pbs.twimg.com/profile_banners/example.jpg"
                                        )
                                        .profileDescriptionLanguage("profileDescriptionLanguage")
                                        .profileImageShape("profileImageShape")
                                        .profileInterstitialType("profileInterstitialType")
                                        .profilePicture(
                                            "https://pbs.twimg.com/profile_images/example.jpg"
                                        )
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
                                .card(
                                    EmbeddedTweet.Card.builder()
                                        .id("id")
                                        .bindingValues(
                                            EmbeddedTweet.Card.BindingValues.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .name("name")
                                        .url("url")
                                        .build()
                                )
                                .communityNote(
                                    EmbeddedTweet.CommunityNote.builder()
                                        .id("id")
                                        .destinationUrl("destinationUrl")
                                        .footer("footer")
                                        .shortTitle("shortTitle")
                                        .subtitle("subtitle")
                                        .title("title")
                                        .visualStyle("visualStyle")
                                        .build()
                                )
                                .contentDisclosure(
                                    ContentDisclosure.builder()
                                        .advertising(
                                            ContentDisclosure.Advertising.builder()
                                                .isPaidPromotion(true)
                                                .build()
                                        )
                                        .aiGenerated(
                                            ContentDisclosure.AiGenerated.builder()
                                                .detectionSource("UserDeclared")
                                                .hasAiGeneratedMedia(true)
                                                .build()
                                        )
                                        .build()
                                )
                                .conversationId("conversationId")
                                .createdAt("createdAt")
                                .addDisplayTextRange(0L)
                                .edit(
                                    EmbeddedTweet.Edit.builder()
                                        .editableUntilMsecs("editableUntilMsecs")
                                        .addEditTweetId("string")
                                        .build()
                                )
                                .entities(
                                    EmbeddedTweet.Entities.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .inReplyToId("inReplyToId")
                                .inReplyToUserId("inReplyToUserId")
                                .inReplyToUsername("inReplyToUsername")
                                .isLimitedReply(true)
                                .isNoteTweet(true)
                                .isQuoteStatus(true)
                                .isReply(true)
                                .isTranslatable(true)
                                .lang("lang")
                                .addMedia(
                                    TweetMedia.builder()
                                        .mediaUrl("mediaUrl")
                                        .type(TweetMedia.Type.PHOTO)
                                        .url("url")
                                        .id("id")
                                        .allowDownload(true)
                                        .altText("altText")
                                        .addAspectRatio(0L)
                                        .availabilityStatus("availabilityStatus")
                                        .displayUrl("displayUrl")
                                        .durationMillis(0L)
                                        .expandedUrl("expandedUrl")
                                        .faceRects(
                                            TweetMedia.FaceRects.builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(
                                                        listOf(
                                                            mapOf(
                                                                "h" to 0,
                                                                "w" to 0,
                                                                "x" to 0,
                                                                "y" to 0,
                                                            )
                                                        )
                                                    ),
                                                )
                                                .build()
                                        )
                                        .addFocusRect(
                                            TweetMedia.FocusRect.builder()
                                                .h(0L)
                                                .w(0L)
                                                .x(0L)
                                                .y(0L)
                                                .build()
                                        )
                                        .height(0L)
                                        .addIndex(0L)
                                        .mediaKey("mediaKey")
                                        .monetizable(true)
                                        .sizes(
                                            TweetMedia.Sizes.builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(
                                                        mapOf(
                                                            "h" to 0,
                                                            "resize" to "resize",
                                                            "w" to 0,
                                                        )
                                                    ),
                                                )
                                                .build()
                                        )
                                        .addVideoVariant(
                                            TweetMedia.VideoVariant.builder()
                                                .contentType("contentType")
                                                .url("url")
                                                .bitrate(0L)
                                                .build()
                                        )
                                        .width(0L)
                                        .build()
                                )
                                .noteTweet(
                                    EmbeddedTweet.NoteTweet.builder()
                                        .text("text")
                                        .id("id")
                                        .entities(
                                            EmbeddedTweet.NoteTweet.Entities.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .isExpandable(true)
                                        .addRichtextTag(
                                            EmbeddedTweet.NoteTweet.RichtextTag.builder()
                                                .fromIndex(0L)
                                                .toIndex(0L)
                                                .addType("string")
                                                .build()
                                        )
                                        .build()
                                )
                                .place(
                                    EmbeddedTweet.Place.builder()
                                        .id("id")
                                        .boundingBox(
                                            EmbeddedTweet.Place.BoundingBox.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .country("country")
                                        .countryCode("countryCode")
                                        .fullName("fullName")
                                        .name("name")
                                        .placeType("placeType")
                                        .url("url")
                                        .build()
                                )
                                .possiblySensitive(true)
                                .previousCounts(
                                    EmbeddedTweet.PreviousCounts.builder()
                                        .bookmarkCount(0L)
                                        .likeCount(0L)
                                        .quoteCount(0L)
                                        .replyCount(0L)
                                        .retweetCount(0L)
                                        .build()
                                )
                                .source("source")
                                .type("type")
                                .url("url")
                                .viewState("viewState")
                                .build()
                        )
                        .retweetedTweet(
                            EmbeddedTweet.builder()
                                .id("id")
                                .bookmarkCount(0L)
                                .likeCount(0L)
                                .quoteCount(0L)
                                .replyCount(0L)
                                .retweetCount(0L)
                                .text("text")
                                .viewCount(0L)
                                .article(
                                    EmbeddedTweet.Article.builder()
                                        .id("id")
                                        .coverMediaUrl("coverMediaUrl")
                                        .previewText("previewText")
                                        .title("title")
                                        .build()
                                )
                                .author(
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
                                        .coverPicture(
                                            "https://pbs.twimg.com/profile_banners/example.jpg"
                                        )
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
                                                .putAdditionalProperty(
                                                    "description",
                                                    JsonValue.from("bar"),
                                                )
                                                .putAdditionalProperty(
                                                    "entities",
                                                    JsonValue.from("bar"),
                                                )
                                                .build()
                                        )
                                        .profileBannerUrl(
                                            "https://pbs.twimg.com/profile_banners/example.jpg"
                                        )
                                        .profileDescriptionLanguage("profileDescriptionLanguage")
                                        .profileImageShape("profileImageShape")
                                        .profileInterstitialType("profileInterstitialType")
                                        .profilePicture(
                                            "https://pbs.twimg.com/profile_images/example.jpg"
                                        )
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
                                .card(
                                    EmbeddedTweet.Card.builder()
                                        .id("id")
                                        .bindingValues(
                                            EmbeddedTweet.Card.BindingValues.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .name("name")
                                        .url("url")
                                        .build()
                                )
                                .communityNote(
                                    EmbeddedTweet.CommunityNote.builder()
                                        .id("id")
                                        .destinationUrl("destinationUrl")
                                        .footer("footer")
                                        .shortTitle("shortTitle")
                                        .subtitle("subtitle")
                                        .title("title")
                                        .visualStyle("visualStyle")
                                        .build()
                                )
                                .contentDisclosure(
                                    ContentDisclosure.builder()
                                        .advertising(
                                            ContentDisclosure.Advertising.builder()
                                                .isPaidPromotion(true)
                                                .build()
                                        )
                                        .aiGenerated(
                                            ContentDisclosure.AiGenerated.builder()
                                                .detectionSource("UserDeclared")
                                                .hasAiGeneratedMedia(true)
                                                .build()
                                        )
                                        .build()
                                )
                                .conversationId("conversationId")
                                .createdAt("createdAt")
                                .addDisplayTextRange(0L)
                                .edit(
                                    EmbeddedTweet.Edit.builder()
                                        .editableUntilMsecs("editableUntilMsecs")
                                        .addEditTweetId("string")
                                        .build()
                                )
                                .entities(
                                    EmbeddedTweet.Entities.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                                        .build()
                                )
                                .inReplyToId("inReplyToId")
                                .inReplyToUserId("inReplyToUserId")
                                .inReplyToUsername("inReplyToUsername")
                                .isLimitedReply(true)
                                .isNoteTweet(true)
                                .isQuoteStatus(true)
                                .isReply(true)
                                .isTranslatable(true)
                                .lang("lang")
                                .addMedia(
                                    TweetMedia.builder()
                                        .mediaUrl("mediaUrl")
                                        .type(TweetMedia.Type.PHOTO)
                                        .url("url")
                                        .id("id")
                                        .allowDownload(true)
                                        .altText("altText")
                                        .addAspectRatio(0L)
                                        .availabilityStatus("availabilityStatus")
                                        .displayUrl("displayUrl")
                                        .durationMillis(0L)
                                        .expandedUrl("expandedUrl")
                                        .faceRects(
                                            TweetMedia.FaceRects.builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(
                                                        listOf(
                                                            mapOf(
                                                                "h" to 0,
                                                                "w" to 0,
                                                                "x" to 0,
                                                                "y" to 0,
                                                            )
                                                        )
                                                    ),
                                                )
                                                .build()
                                        )
                                        .addFocusRect(
                                            TweetMedia.FocusRect.builder()
                                                .h(0L)
                                                .w(0L)
                                                .x(0L)
                                                .y(0L)
                                                .build()
                                        )
                                        .height(0L)
                                        .addIndex(0L)
                                        .mediaKey("mediaKey")
                                        .monetizable(true)
                                        .sizes(
                                            TweetMedia.Sizes.builder()
                                                .putAdditionalProperty(
                                                    "foo",
                                                    JsonValue.from(
                                                        mapOf(
                                                            "h" to 0,
                                                            "resize" to "resize",
                                                            "w" to 0,
                                                        )
                                                    ),
                                                )
                                                .build()
                                        )
                                        .addVideoVariant(
                                            TweetMedia.VideoVariant.builder()
                                                .contentType("contentType")
                                                .url("url")
                                                .bitrate(0L)
                                                .build()
                                        )
                                        .width(0L)
                                        .build()
                                )
                                .noteTweet(
                                    EmbeddedTweet.NoteTweet.builder()
                                        .text("text")
                                        .id("id")
                                        .entities(
                                            EmbeddedTweet.NoteTweet.Entities.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .isExpandable(true)
                                        .addRichtextTag(
                                            EmbeddedTweet.NoteTweet.RichtextTag.builder()
                                                .fromIndex(0L)
                                                .toIndex(0L)
                                                .addType("string")
                                                .build()
                                        )
                                        .build()
                                )
                                .place(
                                    EmbeddedTweet.Place.builder()
                                        .id("id")
                                        .boundingBox(
                                            EmbeddedTweet.Place.BoundingBox.builder()
                                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                                .build()
                                        )
                                        .country("country")
                                        .countryCode("countryCode")
                                        .fullName("fullName")
                                        .name("name")
                                        .placeType("placeType")
                                        .url("url")
                                        .build()
                                )
                                .possiblySensitive(true)
                                .previousCounts(
                                    EmbeddedTweet.PreviousCounts.builder()
                                        .bookmarkCount(0L)
                                        .likeCount(0L)
                                        .quoteCount(0L)
                                        .replyCount(0L)
                                        .retweetCount(0L)
                                        .build()
                                )
                                .source("source")
                                .type("type")
                                .url("url")
                                .viewState("viewState")
                                .build()
                        )
                        .source("Twitter Web App")
                        .type("tweet")
                        .url("https://x.com/example_user/status/1234567890")
                        .viewState("viewState")
                        .build()
                )
                .author(
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
                )
                .build()

        val roundtrippedTweetRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetRetrieveResponse),
                jacksonTypeRef<TweetRetrieveResponse>(),
            )

        assertThat(roundtrippedTweetRetrieveResponse).isEqualTo(tweetRetrieveResponse)
    }

    @Test
    fun readsUnknownCountsForPostsAndRetweetedPosts() {
        val tweetRetrieveResponse =
            jsonMapper()
                .readValue(
                    """
                    {
                      "tweet": {
                        "id": "1234567890",
                        "text": "Reposted post",
                        "bookmarkCount": 0,
                        "unknownCounts": ["bookmarkCount", "viewCount"],
                        "likeCount": 42,
                        "quoteCount": 1,
                        "replyCount": 3,
                        "retweetCount": 5,
                        "viewCount": 0,
                        "retweeted_tweet": {
                          "id": "9876543210",
                          "text": "Original post",
                          "bookmarkCount": 0,
                          "unknownCounts": ["bookmarkCount", "viewCount"],
                          "likeCount": 42,
                          "quoteCount": 1,
                          "replyCount": 3,
                          "retweetCount": 5,
                          "viewCount": 0
                        }
                      }
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<TweetRetrieveResponse>(),
                )

        tweetRetrieveResponse.validate()
        val tweet = tweetRetrieveResponse.tweet()
        assertThat(tweet.unknownCounts())
            .hasValue(listOf(UnknownCount.BOOKMARK_COUNT, UnknownCount.VIEW_COUNT))
        assertThat(tweet.retweetedTweet().orElseThrow().unknownCounts())
            .hasValue(listOf(UnknownCount.BOOKMARK_COUNT, UnknownCount.VIEW_COUNT))
    }

    @Test
    fun readsPostsWithoutUnknownCounts() {
        val tweetRetrieveResponse =
            jsonMapper()
                .readValue(
                    """
                    {
                      "tweet": {
                        "id": "1234567890",
                        "text": "Post with every count",
                        "bookmarkCount": 2,
                        "likeCount": 42,
                        "quoteCount": 1,
                        "replyCount": 3,
                        "retweetCount": 5,
                        "viewCount": 1500,
                        "retweeted_tweet": {
                          "id": "9876543210",
                          "text": "Original post with every count",
                          "bookmarkCount": 2,
                          "likeCount": 42,
                          "quoteCount": 1,
                          "replyCount": 3,
                          "retweetCount": 5,
                          "viewCount": 1500
                        }
                      }
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<TweetRetrieveResponse>(),
                )

        tweetRetrieveResponse.validate()
        val tweet = tweetRetrieveResponse.tweet()
        assertThat(tweet.unknownCounts()).isEmpty()
        assertThat(tweet._unknownCounts().isMissing()).isTrue()
        assertThat(tweet.retweetedTweet().orElseThrow().unknownCounts()).isEmpty()
        assertThat(tweet.retweetedTweet().orElseThrow()._unknownCounts().isMissing()).isTrue()
    }

    @Test
    fun readsUnknownCountsFromFutureApiValues() {
        val tweetRetrieveResponse =
            jsonMapper()
                .readValue(
                    """
                    {
                      "tweet": {
                        "unknownCounts": ["futureCount"],
                        "retweeted_tweet": {
                          "unknownCounts": ["futureCount"]
                        }
                      }
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<TweetRetrieveResponse>(),
                )

        val tweet = tweetRetrieveResponse.tweet()
        val unknownCount = tweet.unknownCounts().orElseThrow().single()
        assertThat(unknownCount.value()).isEqualTo(UnknownCount.Value._UNKNOWN)
        assertThat(unknownCount.asString()).isEqualTo("futureCount")
        val retweetedUnknownCount =
            tweet.retweetedTweet().orElseThrow().unknownCounts().orElseThrow().single()
        assertThat(retweetedUnknownCount.value()).isEqualTo(UnknownCount.Value._UNKNOWN)
        assertThat(retweetedUnknownCount.asString()).isEqualTo("futureCount")
    }

    @Test
    fun readsEveryFieldTheSpecDescribes() {
        val tweetRetrieveResponse =
            jsonMapper()
                .readValue(
                    """
                    {
                      "tweet": {
                        "id": "1234567890",
                        "text": "Just launched!",
                        "type": "tweet",
                        "createdAt": "2025-01-15T12:00:00Z",
                        "url": "https://x.com/example_user/status/1234567890",
                        "lang": "en",
                        "isReply": false,
                        "isLimitedReply": false,
                        "isNoteTweet": false,
                        "isPinned": false,
                        "isQuoteStatus": false,
                        "isRetweet": false,
                        "quotedTweetId": "quotedTweetId-value",
                        "quotedTweetPermalink": {
                          "displayUrl": "displayUrl-value",
                          "expandedUrl": "expandedUrl-value",
                          "url": "url-value"
                        },
                        "quotedTweetUnavailable": {
                          "reason": "Suspended"
                        },
                        "retweetedAt": "2026-09-11T20:24:45.000Z",
                        "inReplyToId": "1234567890",
                        "inReplyToUserId": "9876543210",
                        "inReplyToUsername": "example_user",
                        "conversationId": "1234567890",
                        "conversationControl": {
                          "allowedCountryCodes": [
                            "TR"
                          ],
                          "inviteViaMention": false,
                          "mode": "my_network",
                          "ownerId": "1902917852849385472",
                          "ownerUsername": "ownerUsername-value",
                          "policy": "by_invitation"
                        },
                        "limitedActions": [
                          {
                            "action": "Reply",
                            "prompt": {
                              "ctaType": "SeeConversation",
                              "headline": "headline-value",
                              "metadata": {},
                              "subtext": "subtext-value"
                            }
                          }
                        ],
                        "source": "<a href=\"https://mobile.twitter.com\" rel=\"nofollow\">Twitter Web App</a>",
                        "displayTextRange": [
                          1772
                        ],
                        "textHighlights": [
                          {
                            "startIndex": 5,
                            "endIndex": 13
                          }
                        ],
                        "contentDisclosure": {
                          "advertising": {
                            "isPaidPromotion": true
                          },
                          "aiGenerated": {
                            "detectionSource": "GrokSignature",
                            "hasAiGeneratedMedia": true
                          }
                        },
                        "article": {
                          "coverMedia": {},
                          "id": "id-value",
                          "lifecycleState": {},
                          "metadata": {},
                          "title": "title-value",
                          "previewText": "previewText-value",
                          "coverMediaUrl": "coverMediaUrl-value"
                        },
                        "authorUnavailable": {
                          "reason": "Suspended",
                          "message": "message-value"
                        },
                        "unavailableAuthorId": "unavailableAuthorId-value",
                        "card": {
                          "id": "id-value",
                          "name": "name-value",
                          "url": "url-value",
                          "bindingValues": {},
                          "platform": {},
                          "userReferenceErrors": [
                            {
                              "message": "message-value",
                              "reason": "reason-value"
                            }
                          ],
                          "userReferences": [
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
                          ]
                        },
                        "cashtagAttachments": [
                          {
                            "cashtag": "${'$'}TSLA",
                            "candleSize": "5m",
                            "timeframe": "1D",
                            "startTime": "2026-10-09T13:30:00.000Z",
                            "endTime": "2026-10-09T13:42:08.796Z",
                            "sizeVariant": 1
                          }
                        ],
                        "communityId": "communityId-value",
                        "communityName": "Build in Public",
                        "communityNote": {
                          "id": "id-value",
                          "title": "title-value",
                          "shortTitle": "shortTitle-value",
                          "subtitle": "subtitle-value",
                          "footer": "footer-value",
                          "footerIconType": "footerIconType-value",
                          "destinationUrl": "destinationUrl-value",
                          "iconType": "iconType-value",
                          "visualStyle": "visualStyle-value",
                          "metadata": {}
                        },
                        "hasCommunityNotes": true,
                        "edit": {
                          "editTweetIds": [
                            "editTweetIds-value"
                          ],
                          "editableUntilMsecs": "editableUntilMsecs-value",
                          "initialTweetId": "initialTweetId-value"
                        },
                        "exclusiveContent": {
                          "creatorUserName": "creatorUserName-value",
                          "subscribeUrl": "subscribeUrl-value"
                        },
                        "isTranslatable": false,
                        "grokShareAttachment": {},
                        "grokTranslatedPost": {},
                        "jetfuelAttachment": {},
                        "noteTweet": {
                          "id": "id-value",
                          "noteId": "2100306607800229889",
                          "text": "text-value",
                          "isExpandable": true,
                          "entities": {
                            "hashtags": [
                              {
                                "indices": [
                                  1
                                ],
                                "tag": {
                                  "id": "U21hcnRUYWc6VFNMQQ==",
                                  "info": {
                                    "info": {
                                      "active": true,
                                      "name": "Tesla Inc",
                                      "ticker": "TSLA"
                                    }
                                  }
                                },
                                "text": "string"
                              }
                            ],
                            "smarttags": [
                              {
                                "indices": [
                                  1
                                ],
                                "seconds": 1.5,
                                "text": "string",
                                "tag": {
                                  "id": "U21hcnRUYWc6VFNMQQ==",
                                  "info": {
                                    "info": {
                                      "active": true,
                                      "name": "Tesla Inc",
                                      "ticker": "TSLA"
                                    }
                                  }
                                }
                              }
                            ],
                            "symbols": [
                              {
                                "indices": [
                                  1
                                ],
                                "seconds": 1.5,
                                "text": "string",
                                "tag": {
                                  "id": "U21hcnRUYWc6VFNMQQ==",
                                  "info": {
                                    "info": {
                                      "active": true,
                                      "name": "Tesla Inc",
                                      "ticker": "TSLA"
                                    }
                                  }
                                }
                              }
                            ],
                            "timestamps": [
                              {
                                "indices": [
                                  1
                                ],
                                "seconds": 1.5,
                                "text": "string",
                                "tag": {
                                  "id": "U21hcnRUYWc6VFNMQQ==",
                                  "info": {
                                    "info": {
                                      "active": true,
                                      "name": "Tesla Inc",
                                      "ticker": "TSLA"
                                    }
                                  }
                                }
                              }
                            ],
                            "urls": [
                              {
                                "display_url": "string",
                                "expanded_url": "string",
                                "indices": [
                                  1
                                ],
                                "url": "string"
                              }
                            ],
                            "user_mentions": [
                              {
                                "id_str": "string",
                                "indices": [
                                  1
                                ],
                                "name": "string",
                                "screen_name": "string"
                              }
                            ]
                          },
                          "inlineMedia": [
                            {
                              "index": 636,
                              "mediaId": "mediaId-value"
                            }
                          ],
                          "richtextTags": [
                            {
                              "fromIndex": 1040,
                              "toIndex": 831,
                              "types": [
                                "types-value"
                              ]
                            }
                          ]
                        },
                        "place": {
                          "boundingBox": {},
                          "country": "country-value",
                          "countryCode": "countryCode-value",
                          "fullName": "fullName-value",
                          "id": "id-value",
                          "name": "name-value",
                          "placeType": "placeType-value",
                          "url": "url-value"
                        },
                        "coordinates": {
                          "coordinates": [
                            1279.5
                          ],
                          "type": "Point"
                        },
                        "geo": {
                          "coordinates": [
                            1279.5
                          ],
                          "type": "Point"
                        },
                        "postCta": {},
                        "possiblySensitive": false,
                        "previousCounts": {
                          "bookmarkCount": 1475,
                          "likeCount": 1042,
                          "quoteCount": 1179,
                          "replyCount": 1177,
                          "retweetCount": 1389
                        },
                        "reactionContext": {
                          "reactedToPostId": "reactedToPostId-value",
                          "reactedToUser": {
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
                        },
                        "sportsContext": {
                          "gameId": "gameId-value",
                          "league": "league-value",
                          "title": "title-value",
                          "url": "url-value",
                          "state": "state-value",
                          "statusText": "statusText-value",
                          "scheduledAtMs": 1418.5,
                          "competitors": [
                            {
                              "teamId": "teamId-value",
                              "color": "color-value",
                              "isActive": true,
                              "isWinner": false,
                              "abbreviation": "abbreviation-value",
                              "name": "name-value",
                              "score": "score-value",
                              "logoUrl": "logoUrl-value",
                              "darkLogoUrl": "darkLogoUrl-value"
                            }
                          ]
                        },
                        "subscriberBadge": {
                          "creatorId": "44196397"
                        },
                        "tombstone": {
                          "type": "type-value",
                          "text": {
                            "text": "text-value",
                            "rtl": true,
                            "entities": [
                              {
                                "ref": {}
                              }
                            ]
                          }
                        },
                        "interstitial": {
                          "displayType": "NonCompliant",
                          "text": {
                            "text": "This Post violated the X Rules about glorifying violence. However, X has determined that it may be in the public's interest for the Post to remain accessible. Learn more",
                            "rtl": true,
                            "entities": [
                              {
                                "ref": {}
                              }
                            ]
                          }
                        },
                        "unmentionedUserIds": [
                          "unmentionedUserIds-value"
                        ],
                        "viewState": "viewState-value",
                        "entities": {
                          "hashtags": [
                            {
                              "indices": [
                                1
                              ],
                              "text": "text-value"
                            }
                          ],
                          "smarttags": [
                            {
                              "indices": [
                                1
                              ],
                              "seconds": 851.5,
                              "text": "text-value"
                            }
                          ],
                          "symbols": [
                            {
                              "indices": [
                                1
                              ],
                              "seconds": 851.5,
                              "text": "text-value"
                            }
                          ],
                          "timestamps": [
                            {
                              "indices": [
                                1
                              ],
                              "seconds": 851.5,
                              "text": "text-value"
                            }
                          ],
                          "urls": [
                            {
                              "display_url": "display_url-value",
                              "expanded_url": "expanded_url-value",
                              "indices": [
                                1
                              ],
                              "url": "url-value"
                            }
                          ],
                          "user_mentions": [
                            {
                              "id_str": "id_str-value",
                              "indices": [
                                1
                              ],
                              "name": "name-value",
                              "screen_name": "screen_name-value"
                            }
                          ]
                        },
                        "scopes": {},
                        "media": [
                          {
                            "mediaUrl": "string",
                            "type": "photo",
                            "url": "string",
                            "adultContent": true,
                            "allowDownload": true,
                            "altText": "string",
                            "aspectRatio": [
                              1
                            ],
                            "availabilityReason": "Dmcaed",
                            "availabilityStatus": "Available",
                            "description": "string",
                            "displayUrl": "string",
                            "durationMillis": 1,
                            "expandedUrl": "string",
                            "embeddable": true,
                            "faceRects": {},
                            "focusRects": [
                              {
                                "x": 1,
                                "y": 1,
                                "w": 1,
                                "h": 1
                              }
                            ],
                            "grokImageAnnotation": {
                              "prompt": "string",
                              "upsampledPrompt": "string"
                            },
                            "grokPostId": "string",
                            "graphicViolence": true,
                            "height": 1,
                            "id": "string",
                            "indices": [
                              1
                            ],
                            "mediaKey": "string",
                            "monetizable": true,
                            "otherSensitiveContent": true,
                            "sizes": {},
                            "sourceStatusId": "string",
                            "sourceUser": {
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
                            },
                            "sourceUserId": "string",
                            "tags": [
                              {
                                "name": "string",
                                "screen_name": "string",
                                "type": "string",
                                "user_id": "string"
                              }
                            ],
                            "title": "string",
                            "videoVariants": [
                              {
                                "bitrate": 1,
                                "contentType": "string",
                                "url": "string"
                              }
                            ],
                            "watchNowUrl": "string",
                            "visitSiteUrl": "string",
                            "width": 1
                          }
                        ],
                        "retweetCount": 5,
                        "replyCount": 3,
                        "likeCount": 42,
                        "quoteCount": 1,
                        "viewCount": 1500,
                        "bookmarkCount": 2,
                        "parentTweet": {
                          "id": "1234567890",
                          "text": "Just launched!",
                          "retweetCount": 5,
                          "replyCount": 3,
                          "likeCount": 42,
                          "quoteCount": 1,
                          "viewCount": 1500,
                          "bookmarkCount": 2,
                          "author": {
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
                        },
                        "quoted_tweet": {
                          "id": "1234567890",
                          "text": "Just launched!",
                          "retweetCount": 5,
                          "replyCount": 3,
                          "likeCount": 42,
                          "quoteCount": 1,
                          "viewCount": 1500,
                          "bookmarkCount": 2,
                          "author": {
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
                        },
                        "retweeted_tweet": {
                          "id": "1234567890",
                          "text": "Just launched!",
                          "retweetCount": 5,
                          "replyCount": 3,
                          "likeCount": 42,
                          "quoteCount": 1,
                          "viewCount": 1500,
                          "bookmarkCount": 2,
                          "author": {
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
                        },
                        "author": {
                          "id": "11348282",
                          "username": "NASA",
                          "name": "NASA",
                          "followers": 150000000,
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
                      },
                      "author": {
                        "id": "11348282",
                        "username": "NASA",
                        "name": "NASA",
                        "followers": 150000000,
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
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<TweetRetrieveResponse>(),
                )

        tweetRetrieveResponse.validate()
        assertThat(tweetRetrieveResponse.tweet().id()).isEqualTo("1234567890")
        assertThat(tweetRetrieveResponse.tweet().text()).isEqualTo("Just launched!")
        assertThat(tweetRetrieveResponse.author().get().id()).isEqualTo("11348282")
        assertThat(tweetRetrieveResponse.author().get().name()).isEqualTo("NASA")
        assertThat(tweetRetrieveResponse.author().get().username()).isEqualTo("NASA")
        assertThat(tweetRetrieveResponse._additionalProperties()).isEmpty()
    }
}
