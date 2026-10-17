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

internal class SearchTweetTest {

    @Test
    fun create() {
        val searchTweet =
            SearchTweet.builder()
                .id("1234567890")
                .bookmarkCount(2L)
                .likeCount(42L)
                .quoteCount(1L)
                .replyCount(3L)
                .retweetCount(5L)
                .text("Just launched our new feature!")
                .viewCount(1500L)
                .article(
                    SearchTweet.Article.builder()
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
                    SearchTweet.Card.builder()
                        .id("id")
                        .bindingValues(
                            SearchTweet.Card.BindingValues.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .name("name")
                        .url("url")
                        .build()
                )
                .communityNote(
                    SearchTweet.CommunityNote.builder()
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
                            ContentDisclosure.Advertising.builder().isPaidPromotion(true).build()
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
                    SearchTweet.Edit.builder()
                        .editableUntilMsecs("editableUntilMsecs")
                        .addEditTweetId("string")
                        .build()
                )
                .entities(
                    SearchTweet.Entities.builder()
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
                                    JsonValue.from(mapOf("h" to 0, "resize" to "resize", "w" to 0)),
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
                    SearchTweet.NoteTweet.builder()
                        .text("text")
                        .id("id")
                        .entities(
                            SearchTweet.NoteTweet.Entities.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .isExpandable(true)
                        .addRichtextTag(
                            SearchTweet.NoteTweet.RichtextTag.builder()
                                .fromIndex(0L)
                                .toIndex(0L)
                                .addType("string")
                                .build()
                        )
                        .build()
                )
                .place(
                    SearchTweet.Place.builder()
                        .id("id")
                        .boundingBox(
                            SearchTweet.Place.BoundingBox.builder()
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
                    SearchTweet.PreviousCounts.builder()
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

        assertThat(searchTweet.id()).isEqualTo("1234567890")
        assertThat(searchTweet.bookmarkCount()).isEqualTo(2L)
        assertThat(searchTweet.likeCount()).isEqualTo(42L)
        assertThat(searchTweet.quoteCount()).isEqualTo(1L)
        assertThat(searchTweet.replyCount()).isEqualTo(3L)
        assertThat(searchTweet.retweetCount()).isEqualTo(5L)
        assertThat(searchTweet.text()).isEqualTo("Just launched our new feature!")
        assertThat(searchTweet.viewCount()).isEqualTo(1500L)
        assertThat(searchTweet.article())
            .contains(
                SearchTweet.Article.builder()
                    .id("id")
                    .coverMediaUrl("coverMediaUrl")
                    .previewText("previewText")
                    .title("title")
                    .build()
            )
        assertThat(searchTweet.author())
            .contains(
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
        assertThat(searchTweet.card())
            .contains(
                SearchTweet.Card.builder()
                    .id("id")
                    .bindingValues(
                        SearchTweet.Card.BindingValues.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .name("name")
                    .url("url")
                    .build()
            )
        assertThat(searchTweet.communityNote())
            .contains(
                SearchTweet.CommunityNote.builder()
                    .id("id")
                    .destinationUrl("destinationUrl")
                    .footer("footer")
                    .shortTitle("shortTitle")
                    .subtitle("subtitle")
                    .title("title")
                    .visualStyle("visualStyle")
                    .build()
            )
        assertThat(searchTweet.contentDisclosure())
            .contains(
                ContentDisclosure.builder()
                    .advertising(
                        ContentDisclosure.Advertising.builder().isPaidPromotion(true).build()
                    )
                    .aiGenerated(
                        ContentDisclosure.AiGenerated.builder()
                            .detectionSource("UserDeclared")
                            .hasAiGeneratedMedia(true)
                            .build()
                    )
                    .build()
            )
        assertThat(searchTweet.conversationId()).contains("1234567890")
        assertThat(searchTweet.createdAt()).contains("2025-01-15T12:00:00Z")
        assertThat(searchTweet.displayTextRange().getOrNull()).containsExactly(0L, 31L)
        assertThat(searchTweet.edit())
            .contains(
                SearchTweet.Edit.builder()
                    .editableUntilMsecs("editableUntilMsecs")
                    .addEditTweetId("string")
                    .build()
            )
        assertThat(searchTweet.entities())
            .contains(
                SearchTweet.Entities.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(searchTweet.inReplyToId()).contains("1234567890")
        assertThat(searchTweet.inReplyToUserId()).contains("9876543210")
        assertThat(searchTweet.inReplyToUsername()).contains("example_user")
        assertThat(searchTweet.isLimitedReply()).contains(false)
        assertThat(searchTweet.isNoteTweet()).contains(false)
        assertThat(searchTweet.isQuoteStatus()).contains(false)
        assertThat(searchTweet.isReply()).contains(false)
        assertThat(searchTweet.isTranslatable()).contains(true)
        assertThat(searchTweet.lang()).contains("en")
        assertThat(searchTweet.media().getOrNull())
            .containsExactly(
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
                    .addFocusRect(TweetMedia.FocusRect.builder().h(0L).w(0L).x(0L).y(0L).build())
                    .height(0L)
                    .addIndex(0L)
                    .mediaKey("mediaKey")
                    .monetizable(true)
                    .sizes(
                        TweetMedia.Sizes.builder()
                            .putAdditionalProperty(
                                "foo",
                                JsonValue.from(mapOf("h" to 0, "resize" to "resize", "w" to 0)),
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
        assertThat(searchTweet.noteTweet())
            .contains(
                SearchTweet.NoteTweet.builder()
                    .text("text")
                    .id("id")
                    .entities(
                        SearchTweet.NoteTweet.Entities.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .isExpandable(true)
                    .addRichtextTag(
                        SearchTweet.NoteTweet.RichtextTag.builder()
                            .fromIndex(0L)
                            .toIndex(0L)
                            .addType("string")
                            .build()
                    )
                    .build()
            )
        assertThat(searchTweet.place())
            .contains(
                SearchTweet.Place.builder()
                    .id("id")
                    .boundingBox(
                        SearchTweet.Place.BoundingBox.builder()
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
        assertThat(searchTweet.possiblySensitive()).contains(true)
        assertThat(searchTweet.previousCounts())
            .contains(
                SearchTweet.PreviousCounts.builder()
                    .bookmarkCount(0L)
                    .likeCount(0L)
                    .quoteCount(0L)
                    .replyCount(0L)
                    .retweetCount(0L)
                    .build()
            )
        assertThat(searchTweet.quotedTweet())
            .contains(
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
        assertThat(searchTweet.retweetedTweet())
            .contains(
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
        assertThat(searchTweet.source()).contains("Twitter Web App")
        assertThat(searchTweet.type()).contains("tweet")
        assertThat(searchTweet.url()).contains("https://x.com/example_user/status/1234567890")
        assertThat(searchTweet.viewState()).contains("viewState")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val searchTweet =
            SearchTweet.builder()
                .id("1234567890")
                .bookmarkCount(2L)
                .likeCount(42L)
                .quoteCount(1L)
                .replyCount(3L)
                .retweetCount(5L)
                .text("Just launched our new feature!")
                .viewCount(1500L)
                .article(
                    SearchTweet.Article.builder()
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
                    SearchTweet.Card.builder()
                        .id("id")
                        .bindingValues(
                            SearchTweet.Card.BindingValues.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .name("name")
                        .url("url")
                        .build()
                )
                .communityNote(
                    SearchTweet.CommunityNote.builder()
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
                            ContentDisclosure.Advertising.builder().isPaidPromotion(true).build()
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
                    SearchTweet.Edit.builder()
                        .editableUntilMsecs("editableUntilMsecs")
                        .addEditTweetId("string")
                        .build()
                )
                .entities(
                    SearchTweet.Entities.builder()
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
                                    JsonValue.from(mapOf("h" to 0, "resize" to "resize", "w" to 0)),
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
                    SearchTweet.NoteTweet.builder()
                        .text("text")
                        .id("id")
                        .entities(
                            SearchTweet.NoteTweet.Entities.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .isExpandable(true)
                        .addRichtextTag(
                            SearchTweet.NoteTweet.RichtextTag.builder()
                                .fromIndex(0L)
                                .toIndex(0L)
                                .addType("string")
                                .build()
                        )
                        .build()
                )
                .place(
                    SearchTweet.Place.builder()
                        .id("id")
                        .boundingBox(
                            SearchTweet.Place.BoundingBox.builder()
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
                    SearchTweet.PreviousCounts.builder()
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

        val roundtrippedSearchTweet =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(searchTweet),
                jacksonTypeRef<SearchTweet>(),
            )

        assertThat(roundtrippedSearchTweet).isEqualTo(searchTweet)
    }

    @Test
    fun readsEveryFieldTheSpecDescribes() {
        val searchTweet =
            jsonMapper()
                .readValue(
                    """
                    {
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
                              "fromIndex": 1040,
                              "toIndex": 831,
                              "ref": {
                                "type": "type-value",
                                "url": "url-value",
                                "urlType": "urlType-value",
                                "text": "text-value",
                                "screenName": "screenName-value"
                              }
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
                              "fromIndex": 1040,
                              "toIndex": 831,
                              "ref": {
                                "type": "TimelineUrl",
                                "url": "https://help.x.com/rules-and-policies/public-interest",
                                "urlType": "ExternalUrl",
                                "text": "text-value",
                                "screenName": "screenName-value"
                              }
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
                              835
                            ],
                            "tag": {
                              "id": "U21hcnRUYWc6VFNMQQ==",
                              "info": {}
                            },
                            "text": "text-value"
                          }
                        ],
                        "smarttags": [
                          {
                            "indices": [
                              835
                            ],
                            "seconds": 851.5,
                            "text": "text-value",
                            "tag": {
                              "id": "U21hcnRUYWc6VFNMQQ==",
                              "info": {}
                            }
                          }
                        ],
                        "symbols": [
                          {
                            "indices": [
                              835
                            ],
                            "seconds": 851.5,
                            "text": "text-value",
                            "tag": {
                              "id": "U21hcnRUYWc6VFNMQQ==",
                              "info": {}
                            }
                          }
                        ],
                        "timestamps": [
                          {
                            "indices": [
                              835
                            ],
                            "seconds": 851.5,
                            "text": "text-value",
                            "tag": {
                              "id": "U21hcnRUYWc6VFNMQQ==",
                              "info": {}
                            }
                          }
                        ],
                        "urls": [
                          {
                            "display_url": "display_url-value",
                            "expanded_url": "expanded_url-value",
                            "indices": [
                              835
                            ],
                            "url": "url-value"
                          }
                        ],
                        "user_mentions": [
                          {
                            "id_str": "id_str-value",
                            "indices": [
                              835
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
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<SearchTweet>(),
                )

        searchTweet.validate()
        assertThat(searchTweet.id()).isEqualTo("1234567890")
        assertThat(searchTweet.bookmarkCount()).isEqualTo(2L)
        assertThat(searchTweet.likeCount()).isEqualTo(42L)
        assertThat(searchTweet.quoteCount()).isEqualTo(1L)
        assertThat(searchTweet.replyCount()).isEqualTo(3L)
        assertThat(searchTweet.retweetCount()).isEqualTo(5L)
        assertThat(searchTweet.text()).isEqualTo("Just launched!")
        assertThat(searchTweet.viewCount()).isEqualTo(1500L)
        assertThat(searchTweet.article().get().id()).contains("id-value")
        assertThat(searchTweet.article().get().coverMediaUrl()).contains("coverMediaUrl-value")
        assertThat(searchTweet.article().get().previewText()).contains("previewText-value")
        assertThat(searchTweet.article().get().title()).contains("title-value")
        assertThat(searchTweet.article().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.author().get().id()).isEqualTo("11348282")
        assertThat(searchTweet.author().get().name()).isEqualTo("NASA")
        assertThat(searchTweet.author().get().username()).isEqualTo("NASA")
        assertThat(searchTweet.authorUnavailable().get().reason()).isEqualTo("Suspended")
        assertThat(searchTweet.authorUnavailable().get().message()).contains("message-value")
        assertThat(searchTweet.authorUnavailable().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.card().get().id()).contains("id-value")
        assertThat(searchTweet.card().get().name()).contains("name-value")
        assertThat(searchTweet.card().get().url()).contains("url-value")
        assertThat(searchTweet.card().get().userReferenceErrors().get()).hasSize(1)
        assertThat(searchTweet.card().get().userReferenceErrors().get()[0].message())
            .contains("message-value")
        assertThat(searchTweet.card().get().userReferenceErrors().get()[0].reason())
            .contains("reason-value")
        assertThat(searchTweet.card().get().userReferenceErrors().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(searchTweet.card().get().userReferences().get()).hasSize(1)
        assertThat(searchTweet.card().get().userReferences().get()[0].id()).isEqualTo("11348282")
        assertThat(searchTweet.card().get().userReferences().get()[0].name()).isEqualTo("NASA")
        assertThat(searchTweet.card().get().userReferences().get()[0].username()).isEqualTo("NASA")
        assertThat(searchTweet.card().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.cashtagAttachments().get()).hasSize(1)
        assertThat(searchTweet.cashtagAttachments().get()[0].cashtag()).isEqualTo("\$TSLA")
        assertThat(searchTweet.cashtagAttachments().get()[0].candleSize()).contains("5m")
        assertThat(searchTweet.cashtagAttachments().get()[0].endTime())
            .contains(OffsetDateTime.parse("2026-10-09T13:42:08.796Z"))
        assertThat(searchTweet.cashtagAttachments().get()[0].sizeVariant()).contains(1L)
        assertThat(searchTweet.cashtagAttachments().get()[0].startTime())
            .contains(OffsetDateTime.parse("2026-10-09T13:30:00.000Z"))
        assertThat(searchTweet.cashtagAttachments().get()[0].timeframe()).contains("1D")
        assertThat(searchTweet.cashtagAttachments().get()[0]._additionalProperties()).isEmpty()
        assertThat(searchTweet.communityId()).contains("communityId-value")
        assertThat(searchTweet.communityName()).contains("Build in Public")
        assertThat(searchTweet.communityNote().get().footerIconType())
            .contains("footerIconType-value")
        assertThat(searchTweet.communityNote().get().iconType()).contains("iconType-value")
        assertThat(searchTweet.communityNote().get().id()).contains("id-value")
        assertThat(searchTweet.communityNote().get().destinationUrl())
            .contains("destinationUrl-value")
        assertThat(searchTweet.communityNote().get().footer()).contains("footer-value")
        assertThat(searchTweet.communityNote().get().shortTitle()).contains("shortTitle-value")
        assertThat(searchTweet.communityNote().get().subtitle()).contains("subtitle-value")
        assertThat(searchTweet.communityNote().get().title()).contains("title-value")
        assertThat(searchTweet.communityNote().get().visualStyle()).contains("visualStyle-value")
        assertThat(searchTweet.communityNote().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.conversationControl().get().allowedCountryCodes().get())
            .containsExactly("TR")
        assertThat(searchTweet.conversationControl().get().inviteViaMention()).contains(false)
        assertThat(searchTweet.conversationControl().get().mode()).contains("my_network")
        assertThat(searchTweet.conversationControl().get().ownerId())
            .contains("1902917852849385472")
        assertThat(searchTweet.conversationControl().get().ownerUsername())
            .contains("ownerUsername-value")
        assertThat(searchTweet.conversationControl().get().policy()).contains("by_invitation")
        assertThat(searchTweet.conversationControl().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.conversationId()).contains("1234567890")
        assertThat(searchTweet.coordinates().get().coordinates()).containsExactly(1279.5)
        assertThat(searchTweet.coordinates().get().type())
            .isEqualTo(SearchTweet.Coordinates.Type.POINT)
        assertThat(searchTweet.coordinates().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.createdAt()).contains("2025-01-15T12:00:00Z")
        assertThat(searchTweet.displayTextRange().get()).containsExactly(1772L)
        assertThat(searchTweet.edit().get().editableUntilMsecs())
            .contains("editableUntilMsecs-value")
        assertThat(searchTweet.edit().get().editTweetIds().get())
            .containsExactly("editTweetIds-value")
        assertThat(searchTweet.edit().get().initialTweetId()).contains("initialTweetId-value")
        assertThat(searchTweet.edit().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.entities().get().hashtags().get()).hasSize(1)
        assertThat(searchTweet.entities().get().hashtags().get()[0].text()).isEqualTo("text-value")
        assertThat(searchTweet.entities().get().hashtags().get()[0].indices().get())
            .containsExactly(835L)
        assertThat(searchTweet.entities().get().hashtags().get()[0].tag().get().id())
            .contains("U21hcnRUYWc6VFNMQQ==")
        assertThat(
                searchTweet
                    .entities()
                    .get()
                    .hashtags()
                    .get()[0]
                    .tag()
                    .get()
                    .info()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                searchTweet.entities().get().hashtags().get()[0].tag().get()._additionalProperties()
            )
            .isEmpty()
        assertThat(searchTweet.entities().get().hashtags().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(searchTweet.entities().get().smarttags().get()).hasSize(1)
        assertThat(searchTweet.entities().get().smarttags().get()[0].indices().get())
            .containsExactly(835L)
        assertThat(searchTweet.entities().get().smarttags().get()[0].seconds()).contains(851.5)
        assertThat(searchTweet.entities().get().smarttags().get()[0].tag().get().id())
            .contains("U21hcnRUYWc6VFNMQQ==")
        assertThat(
                searchTweet
                    .entities()
                    .get()
                    .smarttags()
                    .get()[0]
                    .tag()
                    .get()
                    .info()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                searchTweet
                    .entities()
                    .get()
                    .smarttags()
                    .get()[0]
                    .tag()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(searchTweet.entities().get().smarttags().get()[0].text()).contains("text-value")
        assertThat(searchTweet.entities().get().smarttags().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(searchTweet.entities().get().symbols().get()).hasSize(1)
        assertThat(searchTweet.entities().get().symbols().get()[0].indices().get())
            .containsExactly(835L)
        assertThat(searchTweet.entities().get().symbols().get()[0].seconds()).contains(851.5)
        assertThat(searchTweet.entities().get().symbols().get()[0].tag().get().id())
            .contains("U21hcnRUYWc6VFNMQQ==")
        assertThat(
                searchTweet
                    .entities()
                    .get()
                    .symbols()
                    .get()[0]
                    .tag()
                    .get()
                    .info()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                searchTweet.entities().get().symbols().get()[0].tag().get()._additionalProperties()
            )
            .isEmpty()
        assertThat(searchTweet.entities().get().symbols().get()[0].text()).contains("text-value")
        assertThat(searchTweet.entities().get().symbols().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(searchTweet.entities().get().timestamps().get()).hasSize(1)
        assertThat(searchTweet.entities().get().timestamps().get()[0].indices().get())
            .containsExactly(835L)
        assertThat(searchTweet.entities().get().timestamps().get()[0].seconds()).contains(851.5)
        assertThat(searchTweet.entities().get().timestamps().get()[0].tag().get().id())
            .contains("U21hcnRUYWc6VFNMQQ==")
        assertThat(
                searchTweet
                    .entities()
                    .get()
                    .timestamps()
                    .get()[0]
                    .tag()
                    .get()
                    .info()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                searchTweet
                    .entities()
                    .get()
                    .timestamps()
                    .get()[0]
                    .tag()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(searchTweet.entities().get().timestamps().get()[0].text()).contains("text-value")
        assertThat(searchTweet.entities().get().timestamps().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(searchTweet.entities().get().urls().get()).hasSize(1)
        assertThat(searchTweet.entities().get().urls().get()[0].displayUrl())
            .contains("display_url-value")
        assertThat(searchTweet.entities().get().urls().get()[0].expandedUrl())
            .contains("expanded_url-value")
        assertThat(searchTweet.entities().get().urls().get()[0].indices().get())
            .containsExactly(835L)
        assertThat(searchTweet.entities().get().urls().get()[0].url()).contains("url-value")
        assertThat(searchTweet.entities().get().urls().get()[0]._additionalProperties()).isEmpty()
        assertThat(searchTweet.entities().get().userMentions().get()).hasSize(1)
        assertThat(searchTweet.entities().get().userMentions().get()[0].screenName())
            .isEqualTo("screen_name-value")
        assertThat(searchTweet.entities().get().userMentions().get()[0].idStr())
            .contains("id_str-value")
        assertThat(searchTweet.entities().get().userMentions().get()[0].indices().get())
            .containsExactly(835L)
        assertThat(searchTweet.entities().get().userMentions().get()[0].name())
            .contains("name-value")
        assertThat(searchTweet.entities().get().userMentions().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(searchTweet.entities().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.exclusiveContent().get().creatorUserName())
            .isEqualTo("creatorUserName-value")
        assertThat(searchTweet.exclusiveContent().get().subscribeUrl())
            .contains("subscribeUrl-value")
        assertThat(searchTweet.exclusiveContent().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.geo().get().coordinates()).containsExactly(1279.5)
        assertThat(searchTweet.geo().get().type()).isEqualTo(SearchTweet.Geo.Type.POINT)
        assertThat(searchTweet.geo().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.hasCommunityNotes()).contains(true)
        assertThat(searchTweet.inReplyToId()).contains("1234567890")
        assertThat(searchTweet.inReplyToUserId()).contains("9876543210")
        assertThat(searchTweet.inReplyToUsername()).contains("example_user")
        assertThat(searchTweet.interstitial().get().displayType()).contains("NonCompliant")
        assertThat(searchTweet.interstitial().get().text().get().entities().get()).hasSize(1)
        assertThat(searchTweet.interstitial().get().text().get().entities().get()[0].fromIndex())
            .contains(1040L)
        assertThat(
                searchTweet
                    .interstitial()
                    .get()
                    .text()
                    .get()
                    .entities()
                    .get()[0]
                    .ref()
                    .get()
                    .screenName()
            )
            .contains("screenName-value")
        assertThat(
                searchTweet.interstitial().get().text().get().entities().get()[0].ref().get().text()
            )
            .contains("text-value")
        assertThat(
                searchTweet.interstitial().get().text().get().entities().get()[0].ref().get().type()
            )
            .contains("TimelineUrl")
        assertThat(
                searchTweet.interstitial().get().text().get().entities().get()[0].ref().get().url()
            )
            .contains("https://help.x.com/rules-and-policies/public-interest")
        assertThat(
                searchTweet
                    .interstitial()
                    .get()
                    .text()
                    .get()
                    .entities()
                    .get()[0]
                    .ref()
                    .get()
                    .urlType()
            )
            .contains("ExternalUrl")
        assertThat(
                searchTweet
                    .interstitial()
                    .get()
                    .text()
                    .get()
                    .entities()
                    .get()[0]
                    .ref()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(searchTweet.interstitial().get().text().get().entities().get()[0].toIndex())
            .contains(831L)
        assertThat(
                searchTweet
                    .interstitial()
                    .get()
                    .text()
                    .get()
                    .entities()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(searchTweet.interstitial().get().text().get().rtl()).contains(true)
        assertThat(searchTweet.interstitial().get().text().get().text())
            .contains(
                "This Post violated the X Rules about glorifying violence. However, X has determined that it may be in the public's interest for the Post to remain accessible. Learn more"
            )
        assertThat(searchTweet.interstitial().get().text().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.interstitial().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.isLimitedReply()).contains(false)
        assertThat(searchTweet.isNoteTweet()).contains(false)
        assertThat(searchTweet.isPinned()).contains(false)
        assertThat(searchTweet.isQuoteStatus()).contains(false)
        assertThat(searchTweet.isReply()).contains(false)
        assertThat(searchTweet.isRetweet()).contains(false)
        assertThat(searchTweet.isTranslatable()).contains(false)
        assertThat(searchTweet.lang()).contains("en")
        assertThat(searchTweet.limitedActions().get()).hasSize(1)
        assertThat(searchTweet.limitedActions().get()[0].action()).contains("Reply")
        assertThat(searchTweet.limitedActions().get()[0].prompt().get().ctaType())
            .contains("SeeConversation")
        assertThat(searchTweet.limitedActions().get()[0].prompt().get().headline())
            .contains("headline-value")
        assertThat(searchTweet.limitedActions().get()[0].prompt().get().subtext())
            .contains("subtext-value")
        assertThat(searchTweet.limitedActions().get()[0].prompt().get()._additionalProperties())
            .isEmpty()
        assertThat(searchTweet.limitedActions().get()[0]._additionalProperties()).isEmpty()
        assertThat(searchTweet.media().get()).hasSize(1)
        assertThat(searchTweet.media().get()[0].id()).contains("string")
        assertThat(searchTweet.noteTweet().get().text()).isEqualTo("text-value")
        assertThat(searchTweet.noteTweet().get().id()).contains("id-value")
        assertThat(searchTweet.noteTweet().get().entities().get().hashtags().get()).hasSize(1)
        assertThat(searchTweet.noteTweet().get().entities().get().hashtags().get()[0].text())
            .isEqualTo("text-value")
        assertThat(
                searchTweet.noteTweet().get().entities().get().hashtags().get()[0].indices().get()
            )
            .containsExactly(1L)
        assertThat(
                searchTweet
                    .noteTweet()
                    .get()
                    .entities()
                    .get()
                    .hashtags()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(searchTweet.noteTweet().get().entities().get().smarttags().get()).hasSize(1)
        assertThat(
                searchTweet.noteTweet().get().entities().get().smarttags().get()[0].indices().get()
            )
            .containsExactly(1L)
        assertThat(searchTweet.noteTweet().get().entities().get().smarttags().get()[0].seconds())
            .contains(851.5)
        assertThat(searchTweet.noteTweet().get().entities().get().smarttags().get()[0].text())
            .contains("text-value")
        assertThat(
                searchTweet
                    .noteTweet()
                    .get()
                    .entities()
                    .get()
                    .smarttags()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(searchTweet.noteTweet().get().entities().get().symbols().get()).hasSize(1)
        assertThat(
                searchTweet.noteTweet().get().entities().get().symbols().get()[0].indices().get()
            )
            .containsExactly(1L)
        assertThat(searchTweet.noteTweet().get().entities().get().symbols().get()[0].seconds())
            .contains(851.5)
        assertThat(searchTweet.noteTweet().get().entities().get().symbols().get()[0].text())
            .contains("text-value")
        assertThat(
                searchTweet
                    .noteTweet()
                    .get()
                    .entities()
                    .get()
                    .symbols()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(searchTweet.noteTweet().get().entities().get().timestamps().get()).hasSize(1)
        assertThat(
                searchTweet.noteTweet().get().entities().get().timestamps().get()[0].indices().get()
            )
            .containsExactly(1L)
        assertThat(searchTweet.noteTweet().get().entities().get().timestamps().get()[0].seconds())
            .contains(851.5)
        assertThat(searchTweet.noteTweet().get().entities().get().timestamps().get()[0].text())
            .contains("text-value")
        assertThat(
                searchTweet
                    .noteTweet()
                    .get()
                    .entities()
                    .get()
                    .timestamps()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(searchTweet.noteTweet().get().entities().get().urls().get()).hasSize(1)
        assertThat(searchTweet.noteTweet().get().entities().get().urls().get()[0].displayUrl())
            .contains("display_url-value")
        assertThat(searchTweet.noteTweet().get().entities().get().urls().get()[0].expandedUrl())
            .contains("expanded_url-value")
        assertThat(searchTweet.noteTweet().get().entities().get().urls().get()[0].indices().get())
            .containsExactly(1L)
        assertThat(searchTweet.noteTweet().get().entities().get().urls().get()[0].url())
            .contains("url-value")
        assertThat(
                searchTweet
                    .noteTweet()
                    .get()
                    .entities()
                    .get()
                    .urls()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(searchTweet.noteTweet().get().entities().get().userMentions().get()).hasSize(1)
        assertThat(
                searchTweet.noteTweet().get().entities().get().userMentions().get()[0].screenName()
            )
            .isEqualTo("screen_name-value")
        assertThat(searchTweet.noteTweet().get().entities().get().userMentions().get()[0].idStr())
            .contains("id_str-value")
        assertThat(
                searchTweet
                    .noteTweet()
                    .get()
                    .entities()
                    .get()
                    .userMentions()
                    .get()[0]
                    .indices()
                    .get()
            )
            .containsExactly(1L)
        assertThat(searchTweet.noteTweet().get().entities().get().userMentions().get()[0].name())
            .contains("name-value")
        assertThat(
                searchTweet
                    .noteTweet()
                    .get()
                    .entities()
                    .get()
                    .userMentions()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(searchTweet.noteTweet().get().entities().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.noteTweet().get().inlineMedia().get()).hasSize(1)
        assertThat(searchTweet.noteTweet().get().inlineMedia().get()[0].index()).isEqualTo(636L)
        assertThat(searchTweet.noteTweet().get().inlineMedia().get()[0].mediaId())
            .isEqualTo("mediaId-value")
        assertThat(searchTweet.noteTweet().get().inlineMedia().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(searchTweet.noteTweet().get().isExpandable()).contains(true)
        assertThat(searchTweet.noteTweet().get().noteId()).contains("2100306607800229889")
        assertThat(searchTweet.noteTweet().get().richtextTags().get()).hasSize(1)
        assertThat(searchTweet.noteTweet().get().richtextTags().get()[0].fromIndex())
            .isEqualTo(1040L)
        assertThat(searchTweet.noteTweet().get().richtextTags().get()[0].toIndex()).isEqualTo(831L)
        assertThat(searchTweet.noteTweet().get().richtextTags().get()[0].types())
            .containsExactly("types-value")
        assertThat(searchTweet.noteTweet().get().richtextTags().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(searchTweet.noteTweet().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.parentTweet().get().id()).isEqualTo("1234567890")
        assertThat(searchTweet.parentTweet().get().text()).isEqualTo("Just launched!")
        assertThat(searchTweet.place().get().id()).contains("id-value")
        assertThat(searchTweet.place().get().country()).contains("country-value")
        assertThat(searchTweet.place().get().countryCode()).contains("countryCode-value")
        assertThat(searchTweet.place().get().fullName()).contains("fullName-value")
        assertThat(searchTweet.place().get().name()).contains("name-value")
        assertThat(searchTweet.place().get().placeType()).contains("placeType-value")
        assertThat(searchTweet.place().get().url()).contains("url-value")
        assertThat(searchTweet.place().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.possiblySensitive()).contains(false)
        assertThat(searchTweet.previousCounts().get().bookmarkCount()).contains(1475L)
        assertThat(searchTweet.previousCounts().get().likeCount()).contains(1042L)
        assertThat(searchTweet.previousCounts().get().quoteCount()).contains(1179L)
        assertThat(searchTweet.previousCounts().get().replyCount()).contains(1177L)
        assertThat(searchTweet.previousCounts().get().retweetCount()).contains(1389L)
        assertThat(searchTweet.previousCounts().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.quotedTweet().get().id()).isEqualTo("1234567890")
        assertThat(searchTweet.quotedTweet().get().text()).isEqualTo("Just launched!")
        assertThat(searchTweet.quotedTweetId()).contains("quotedTweetId-value")
        assertThat(searchTweet.quotedTweetPermalink().get().displayUrl())
            .contains("displayUrl-value")
        assertThat(searchTweet.quotedTweetPermalink().get().expandedUrl())
            .contains("expandedUrl-value")
        assertThat(searchTweet.quotedTweetPermalink().get().url()).contains("url-value")
        assertThat(searchTweet.quotedTweetPermalink().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.quotedTweetUnavailable().get().reason()).isEqualTo("Suspended")
        assertThat(searchTweet.quotedTweetUnavailable().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.reactionContext().get().reactedToPostId())
            .contains("reactedToPostId-value")
        assertThat(searchTweet.reactionContext().get().reactedToUser().get().id())
            .isEqualTo("11348282")
        assertThat(searchTweet.reactionContext().get().reactedToUser().get().name())
            .isEqualTo("NASA")
        assertThat(searchTweet.reactionContext().get().reactedToUser().get().username())
            .isEqualTo("NASA")
        assertThat(searchTweet.reactionContext().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.retweetedTweet().get().id()).isEqualTo("1234567890")
        assertThat(searchTweet.retweetedTweet().get().text()).isEqualTo("Just launched!")
        assertThat(searchTweet.retweetedAt())
            .contains(OffsetDateTime.parse("2026-09-11T20:24:45.000Z"))
        assertThat(searchTweet.source())
            .contains("<a href=\"https://mobile.twitter.com\" rel=\"nofollow\">Twitter Web App</a>")
        assertThat(searchTweet.sportsContext().get().competitors().get()).hasSize(1)
        assertThat(searchTweet.sportsContext().get().competitors().get()[0].abbreviation())
            .contains("abbreviation-value")
        assertThat(searchTweet.sportsContext().get().competitors().get()[0].color())
            .contains("color-value")
        assertThat(searchTweet.sportsContext().get().competitors().get()[0].darkLogoUrl())
            .contains("darkLogoUrl-value")
        assertThat(searchTweet.sportsContext().get().competitors().get()[0].isActive())
            .contains(true)
        assertThat(searchTweet.sportsContext().get().competitors().get()[0].isWinner())
            .contains(false)
        assertThat(searchTweet.sportsContext().get().competitors().get()[0].logoUrl())
            .contains("logoUrl-value")
        assertThat(searchTweet.sportsContext().get().competitors().get()[0].name())
            .contains("name-value")
        assertThat(searchTweet.sportsContext().get().competitors().get()[0].score())
            .contains("score-value")
        assertThat(searchTweet.sportsContext().get().competitors().get()[0].teamId())
            .contains("teamId-value")
        assertThat(searchTweet.sportsContext().get().competitors().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(searchTweet.sportsContext().get().gameId()).contains("gameId-value")
        assertThat(searchTweet.sportsContext().get().league()).contains("league-value")
        assertThat(searchTweet.sportsContext().get().state()).contains("state-value")
        assertThat(searchTweet.sportsContext().get().statusText()).contains("statusText-value")
        assertThat(searchTweet.sportsContext().get().title()).contains("title-value")
        assertThat(searchTweet.sportsContext().get().url()).contains("url-value")
        assertThat(searchTweet.sportsContext().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.subscriberBadge().get().creatorId()).isEqualTo("44196397")
        assertThat(searchTweet.subscriberBadge().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.textHighlights().get()).hasSize(1)
        assertThat(searchTweet.textHighlights().get()[0].endIndex()).isEqualTo(13L)
        assertThat(searchTweet.textHighlights().get()[0].startIndex()).isEqualTo(5L)
        assertThat(searchTweet.textHighlights().get()[0]._additionalProperties()).isEmpty()
        assertThat(searchTweet.tombstone().get().text().get().entities().get()).hasSize(1)
        assertThat(searchTweet.tombstone().get().text().get().entities().get()[0].fromIndex())
            .contains(1040L)
        assertThat(
                searchTweet
                    .tombstone()
                    .get()
                    .text()
                    .get()
                    .entities()
                    .get()[0]
                    .ref()
                    .get()
                    .screenName()
            )
            .contains("screenName-value")
        assertThat(
                searchTweet.tombstone().get().text().get().entities().get()[0].ref().get().text()
            )
            .contains("text-value")
        assertThat(
                searchTweet.tombstone().get().text().get().entities().get()[0].ref().get().type()
            )
            .contains("type-value")
        assertThat(searchTweet.tombstone().get().text().get().entities().get()[0].ref().get().url())
            .contains("url-value")
        assertThat(
                searchTweet.tombstone().get().text().get().entities().get()[0].ref().get().urlType()
            )
            .contains("urlType-value")
        assertThat(
                searchTweet
                    .tombstone()
                    .get()
                    .text()
                    .get()
                    .entities()
                    .get()[0]
                    .ref()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(searchTweet.tombstone().get().text().get().entities().get()[0].toIndex())
            .contains(831L)
        assertThat(
                searchTweet
                    .tombstone()
                    .get()
                    .text()
                    .get()
                    .entities()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(searchTweet.tombstone().get().text().get().rtl()).contains(true)
        assertThat(searchTweet.tombstone().get().text().get().text()).contains("text-value")
        assertThat(searchTweet.tombstone().get().text().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.tombstone().get().type()).contains("type-value")
        assertThat(searchTweet.tombstone().get()._additionalProperties()).isEmpty()
        assertThat(searchTweet.type()).contains("tweet")
        assertThat(searchTweet.unavailableAuthorId()).contains("unavailableAuthorId-value")
        assertThat(searchTweet.unmentionedUserIds().get())
            .containsExactly("unmentionedUserIds-value")
        assertThat(searchTweet.url()).contains("https://x.com/example_user/status/1234567890")
        assertThat(searchTweet.viewState()).contains("viewState-value")
        assertThat(searchTweet._additionalProperties()).isEmpty()
    }

    @Test
    fun additionalFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json = """{"hiddenByAuthor":true}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<SearchTweet>())

        assertThat(model.hiddenByAuthor()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("hiddenByAuthor")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<SearchTweet>(),
                )
            )
            .isEqualTo(model)
    }
}
