// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import com.x_twitter_scraper.api.models.ContentDisclosure
import com.x_twitter_scraper.api.models.EmbeddedTweet
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.SearchTweet
import com.x_twitter_scraper.api.models.TweetMedia
import com.x_twitter_scraper.api.models.UserProfile
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class TweetSearchResponseTest {

    @Test
    fun ofPaginatedTweets() {
        val paginatedTweets =
            PaginatedTweets.builder()
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .addTweet(
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
                .build()

        val tweetSearchResponse = TweetSearchResponse.ofPaginatedTweets(paginatedTweets)

        assertThat(tweetSearchResponse.paginatedTweets()).contains(paginatedTweets)
        assertThat(tweetSearchResponse.coverage()).isEmpty
    }

    @Test
    fun ofPaginatedTweetsRoundtrip() {
        val jsonMapper = jsonMapper()
        val tweetSearchResponse =
            TweetSearchResponse.ofPaginatedTweets(
                PaginatedTweets.builder()
                    .hasNextPage(true)
                    .nextCursor("DAACCgACGRElMJcAAA")
                    .addTweet(
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
                                            .profileDescriptionLanguage(
                                                "profileDescriptionLanguage"
                                            )
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
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
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
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
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
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
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
                                            .profileDescriptionLanguage(
                                                "profileDescriptionLanguage"
                                            )
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
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
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
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
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
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
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
                    .build()
            )

        val roundtrippedTweetSearchResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetSearchResponse),
                jacksonTypeRef<TweetSearchResponse>(),
            )

        assertThat(roundtrippedTweetSearchResponse).isEqualTo(tweetSearchResponse)
    }

    @Test
    fun ofCoverage() {
        val coverage =
            TweetSearchResponse.TweetSearchCoverageResponse.builder()
                .hasNextPage(false)
                .nextCursor("")
                .addTweet(
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
                .diagnostic(
                    TweetSearchResponse.TweetSearchCoverageResponse.Diagnostic.builder()
                        .complete(true)
                        .cursorFailureCount(0L)
                        .deadlineReached(true)
                        .duplicateCount(0L)
                        .failedStrategyCount(0L)
                        .malformedCount(0L)
                        .pagesFetched(0L)
                        .partitioned(true)
                        .responseTruncated(true)
                        .resultLimitReached(true)
                        .returnedTweets(0L)
                        .stalledStrategyCount(0L)
                        .addStrategy(
                            TweetSearchResponse.TweetSearchCoverageResponse.Diagnostic.Strategy
                                .builder()
                                .duplicateCount(0L)
                                .pagesFetched(0L)
                                .queryType(
                                    TweetSearchResponse.TweetSearchCoverageResponse.Diagnostic
                                        .Strategy
                                        .QueryType
                                        .LATEST
                                )
                                .stopReason(
                                    TweetSearchResponse.TweetSearchCoverageResponse.Diagnostic
                                        .Strategy
                                        .StopReason
                                        .CURSOR_FAILURE
                                )
                                .strategy(1L)
                                .uniqueAdded(0L)
                                .window(
                                    TweetSearchResponse.TweetSearchCoverageResponse.Diagnostic
                                        .Strategy
                                        .Window
                                        .builder()
                                        .sinceTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                        .untilTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                        .build()
                                )
                                .build()
                        )
                        .strategyCount(1L)
                        .uniqueTweets(0L)
                        .build()
                )
                .build()

        val tweetSearchResponse = TweetSearchResponse.ofCoverage(coverage)

        assertThat(tweetSearchResponse.paginatedTweets()).isEmpty
        assertThat(tweetSearchResponse.coverage()).contains(coverage)
    }

    @Test
    fun ofCoverageRoundtrip() {
        val jsonMapper = jsonMapper()
        val tweetSearchResponse =
            TweetSearchResponse.ofCoverage(
                TweetSearchResponse.TweetSearchCoverageResponse.builder()
                    .hasNextPage(false)
                    .nextCursor("")
                    .addTweet(
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
                                            .profileDescriptionLanguage(
                                                "profileDescriptionLanguage"
                                            )
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
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
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
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
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
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
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
                                            .profileDescriptionLanguage(
                                                "profileDescriptionLanguage"
                                            )
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
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
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
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
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
                                                    .putAdditionalProperty(
                                                        "foo",
                                                        JsonValue.from("bar"),
                                                    )
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
                    .diagnostic(
                        TweetSearchResponse.TweetSearchCoverageResponse.Diagnostic.builder()
                            .complete(true)
                            .cursorFailureCount(0L)
                            .deadlineReached(true)
                            .duplicateCount(0L)
                            .failedStrategyCount(0L)
                            .malformedCount(0L)
                            .pagesFetched(0L)
                            .partitioned(true)
                            .responseTruncated(true)
                            .resultLimitReached(true)
                            .returnedTweets(0L)
                            .stalledStrategyCount(0L)
                            .addStrategy(
                                TweetSearchResponse.TweetSearchCoverageResponse.Diagnostic.Strategy
                                    .builder()
                                    .duplicateCount(0L)
                                    .pagesFetched(0L)
                                    .queryType(
                                        TweetSearchResponse.TweetSearchCoverageResponse.Diagnostic
                                            .Strategy
                                            .QueryType
                                            .LATEST
                                    )
                                    .stopReason(
                                        TweetSearchResponse.TweetSearchCoverageResponse.Diagnostic
                                            .Strategy
                                            .StopReason
                                            .CURSOR_FAILURE
                                    )
                                    .strategy(1L)
                                    .uniqueAdded(0L)
                                    .window(
                                        TweetSearchResponse.TweetSearchCoverageResponse.Diagnostic
                                            .Strategy
                                            .Window
                                            .builder()
                                            .sinceTime(
                                                OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                            )
                                            .untilTime(
                                                OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                            .strategyCount(1L)
                            .uniqueTweets(0L)
                            .build()
                    )
                    .build()
            )

        val roundtrippedTweetSearchResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetSearchResponse),
                jacksonTypeRef<TweetSearchResponse>(),
            )

        assertThat(roundtrippedTweetSearchResponse).isEqualTo(tweetSearchResponse)
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
        val tweetSearchResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<TweetSearchResponse>())

        val e = assertThrows<XTwitterScraperInvalidDataException> { tweetSearchResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }

    @Test
    fun readsEveryFieldTheSpecDescribes() {
        val tweetSearchResponse =
            jsonMapper()
                .readValue(
                    """
                    {
                      "filtered_count": 1595,
                      "tweets": [
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
                          "quotedTweetId": "string",
                          "quotedTweetPermalink": {
                            "displayUrl": "string",
                            "expandedUrl": "string",
                            "url": "string"
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
                            "inviteViaMention": true,
                            "mode": "my_network",
                            "ownerId": "1902917852849385472",
                            "ownerUsername": "string",
                            "policy": "by_invitation"
                          },
                          "limitedActions": [
                            {
                              "action": "Reply",
                              "prompt": {
                                "ctaType": "SeeConversation",
                                "headline": "string",
                                "metadata": {},
                                "subtext": "string"
                              }
                            }
                          ],
                          "source": "<a href=\"https://mobile.twitter.com\" rel=\"nofollow\">Twitter Web App</a>",
                          "displayTextRange": [
                            0,
                            31
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
                            "id": "string",
                            "lifecycleState": {},
                            "metadata": {},
                            "title": "string",
                            "previewText": "string",
                            "coverMediaUrl": "string"
                          },
                          "authorUnavailable": {
                            "reason": "Suspended",
                            "message": "string"
                          },
                          "unavailableAuthorId": "string",
                          "card": {
                            "id": "string",
                            "name": "string",
                            "url": "string",
                            "bindingValues": {},
                            "platform": {},
                            "userReferenceErrors": [
                              {
                                "message": "User unavailable",
                                "reason": "Suspended"
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
                          "communityId": "string",
                          "communityName": "Build in Public",
                          "communityNote": {
                            "id": "string",
                            "title": "string",
                            "shortTitle": "string",
                            "subtitle": "string",
                            "footer": "string",
                            "footerIconType": "string",
                            "destinationUrl": "string",
                            "iconType": "string",
                            "visualStyle": "string",
                            "metadata": {}
                          },
                          "hasCommunityNotes": true,
                          "edit": {
                            "editTweetIds": [
                              "string"
                            ],
                            "editableUntilMsecs": "string",
                            "initialTweetId": "string"
                          },
                          "exclusiveContent": {
                            "creatorUserName": "string",
                            "subscribeUrl": "string"
                          },
                          "isTranslatable": true,
                          "grokShareAttachment": {},
                          "grokTranslatedPost": {},
                          "jetfuelAttachment": {},
                          "noteTweet": {
                            "id": "string",
                            "noteId": "2100306607800229889",
                            "text": "string",
                            "isExpandable": true,
                            "entities": {
                              "hashtags": [
                                {
                                  "indices": [],
                                  "text": "string"
                                }
                              ],
                              "smarttags": [
                                {
                                  "indices": [],
                                  "seconds": 1.5,
                                  "text": "string"
                                }
                              ],
                              "symbols": [
                                {
                                  "indices": [],
                                  "seconds": 1.5,
                                  "text": "string"
                                }
                              ],
                              "timestamps": [
                                {
                                  "indices": [],
                                  "seconds": 1.5,
                                  "text": "string"
                                }
                              ],
                              "urls": [
                                {
                                  "display_url": "string",
                                  "expanded_url": "string",
                                  "indices": [],
                                  "url": "string"
                                }
                              ],
                              "user_mentions": [
                                {
                                  "id_str": "string",
                                  "indices": [],
                                  "name": "string",
                                  "screen_name": "string"
                                }
                              ]
                            },
                            "inlineMedia": [
                              {
                                "index": 1,
                                "mediaId": "string"
                              }
                            ],
                            "richtextTags": [
                              {
                                "fromIndex": 1,
                                "toIndex": 1,
                                "types": [
                                  "string"
                                ]
                              }
                            ]
                          },
                          "place": {
                            "boundingBox": {},
                            "country": "string",
                            "countryCode": "string",
                            "fullName": "string",
                            "id": "string",
                            "name": "string",
                            "placeType": "string",
                            "url": "string"
                          },
                          "coordinates": {
                            "coordinates": [
                              1.5
                            ],
                            "type": "Point"
                          },
                          "geo": {
                            "coordinates": [
                              1.5
                            ],
                            "type": "Point"
                          },
                          "postCta": {},
                          "possiblySensitive": true,
                          "previousCounts": {
                            "bookmarkCount": 1,
                            "likeCount": 1,
                            "quoteCount": 1,
                            "replyCount": 1,
                            "retweetCount": 1
                          },
                          "reactionContext": {
                            "reactedToPostId": "string",
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
                            "gameId": "string",
                            "league": "string",
                            "title": "string",
                            "url": "string",
                            "state": "string",
                            "statusText": "string",
                            "scheduledAtMs": 1.5,
                            "competitors": [
                              {
                                "teamId": "string",
                                "color": "string",
                                "isActive": true,
                                "isWinner": true,
                                "abbreviation": "string",
                                "name": "string",
                                "score": "string",
                                "logoUrl": "string",
                                "darkLogoUrl": "string"
                              }
                            ]
                          },
                          "subscriberBadge": {
                            "creatorId": "44196397"
                          },
                          "tombstone": {
                            "type": "string",
                            "text": {
                              "text": "string",
                              "rtl": true,
                              "entities": [
                                {
                                  "fromIndex": 1,
                                  "toIndex": 1,
                                  "ref": {
                                    "type": "string",
                                    "url": "string",
                                    "urlType": "string",
                                    "text": "string",
                                    "screenName": "string"
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
                                  "fromIndex": 1,
                                  "toIndex": 1,
                                  "ref": {
                                    "type": "TimelineUrl",
                                    "url": "https://help.x.com/rules-and-policies/public-interest",
                                    "urlType": "ExternalUrl",
                                    "text": "string",
                                    "screenName": "string"
                                  }
                                }
                              ]
                            }
                          },
                          "unmentionedUserIds": [
                            "string"
                          ],
                          "viewState": "string",
                          "entities": {
                            "hashtags": [
                              {
                                "indices": [
                                  1
                                ],
                                "tag": {
                                  "id": "U21hcnRUYWc6VFNMQQ==",
                                  "info": {}
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
                                  "info": {}
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
                                  "info": {}
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
                                  "info": {}
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
                      ],
                      "has_next_page": false,
                      "next_cursor": "",
                      "readBackTo": "2026-10-04T10:07:00.000Z",
                      "windowComplete": true,
                      "searchedQuery": "openai gpt",
                      "searchContext": {
                        "smartTag": {
                          "id": "BTC",
                          "active": true,
                          "supportsOhlc": false
                        }
                      },
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
                        "partitioned": false,
                        "returnedTweets": 1609,
                        "strategies": [
                          {
                            "duplicateCount": 1576,
                            "pagesFetched": 1319,
                            "queryType": "Latest",
                            "stopReason": "cursor_failure",
                            "strategy": 983,
                            "uniqueAdded": 1229,
                            "window": {
                              "sinceTime": "2026-01-06T00:00:00Z",
                              "untilTime": "2026-01-04T00:00:00Z"
                            }
                          }
                        ],
                        "uniqueTweets": 1399
                      }
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<TweetSearchResponse>(),
                )

        tweetSearchResponse.validate()
        assertThat(tweetSearchResponse.isCoverage()).isTrue()
        assertThat(tweetSearchResponse.asCoverage().hasNextPage()).isEqualTo(false)
        assertThat(tweetSearchResponse.asCoverage().nextCursor()).isEqualTo("")
        assertThat(tweetSearchResponse.asCoverage().tweets()).hasSize(1)
        assertThat(tweetSearchResponse.asCoverage().tweets()[0].id()).isEqualTo("1234567890")
        assertThat(tweetSearchResponse.asCoverage().tweets()[0].text()).isEqualTo("Just launched!")
        assertThat(tweetSearchResponse.asCoverage().diagnostic().complete()).isEqualTo(false)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().cursorFailureCount())
            .isEqualTo(2003L)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().deadlineReached()).isEqualTo(true)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().duplicateCount()).isEqualTo(1576L)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().failedStrategyCount())
            .isEqualTo(2085L)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().malformedCount()).isEqualTo(1572L)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().pagesFetched()).isEqualTo(1319L)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().partitioned()).isEqualTo(false)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().responseTruncated())
            .isEqualTo(false)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().resultLimitReached())
            .isEqualTo(true)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().returnedTweets()).isEqualTo(1609L)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().stalledStrategyCount())
            .isEqualTo(2217L)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().strategies()).hasSize(1)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().strategies()[0].duplicateCount())
            .isEqualTo(1576L)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().strategies()[0].pagesFetched())
            .isEqualTo(1319L)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().strategies()[0].queryType())
            .isEqualTo(
                TweetSearchResponse.TweetSearchCoverageResponse.Diagnostic.Strategy.QueryType.LATEST
            )
        assertThat(tweetSearchResponse.asCoverage().diagnostic().strategies()[0].stopReason())
            .isEqualTo(
                TweetSearchResponse.TweetSearchCoverageResponse.Diagnostic.Strategy.StopReason
                    .CURSOR_FAILURE
            )
        assertThat(tweetSearchResponse.asCoverage().diagnostic().strategies()[0].strategy())
            .isEqualTo(983L)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().strategies()[0].uniqueAdded())
            .isEqualTo(1229L)
        assertThat(
                tweetSearchResponse
                    .asCoverage()
                    .diagnostic()
                    .strategies()[0]
                    .window()
                    .get()
                    .sinceTime()
            )
            .isEqualTo(OffsetDateTime.parse("2026-01-06T00:00:00Z"))
        assertThat(
                tweetSearchResponse
                    .asCoverage()
                    .diagnostic()
                    .strategies()[0]
                    .window()
                    .get()
                    .untilTime()
            )
            .isEqualTo(OffsetDateTime.parse("2026-01-04T00:00:00Z"))
        assertThat(
                tweetSearchResponse
                    .asCoverage()
                    .diagnostic()
                    .strategies()[0]
                    .window()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                tweetSearchResponse
                    .asCoverage()
                    .diagnostic()
                    .strategies()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(tweetSearchResponse.asCoverage().diagnostic().strategyCount()).isEqualTo(1504L)
        assertThat(tweetSearchResponse.asCoverage().diagnostic().uniqueTweets()).isEqualTo(1399L)
        assertThat(tweetSearchResponse.asCoverage().diagnostic()._additionalProperties()).isEmpty()
        assertThat(tweetSearchResponse.asCoverage().filteredCount()).contains(1595L)
        assertThat(tweetSearchResponse.asCoverage().readBackTo())
            .contains(OffsetDateTime.parse("2026-10-04T10:07:00.000Z"))
        assertThat(tweetSearchResponse.asCoverage().searchContext().get().smartTag().id())
            .isEqualTo("BTC")
        assertThat(tweetSearchResponse.asCoverage().searchContext().get().smartTag().active())
            .contains(true)
        assertThat(tweetSearchResponse.asCoverage().searchContext().get().smartTag().supportsOhlc())
            .contains(false)
        assertThat(
                tweetSearchResponse
                    .asCoverage()
                    .searchContext()
                    .get()
                    .smartTag()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(tweetSearchResponse.asCoverage().searchContext().get()._additionalProperties())
            .isEmpty()
        assertThat(tweetSearchResponse.asCoverage().searchedQuery()).contains("openai gpt")
        assertThat(tweetSearchResponse.asCoverage().windowComplete()).contains(true)
        assertThat(tweetSearchResponse.asCoverage()._additionalProperties()).isEmpty()
        assertThat(tweetSearchResponse.asCoverage().toPaginatedTweets()._hasNextPage())
            .isEqualTo(tweetSearchResponse.asCoverage()._hasNextPage())
        assertThat(tweetSearchResponse.asCoverage().toPaginatedTweets()._nextCursor())
            .isEqualTo(tweetSearchResponse.asCoverage()._nextCursor())
        assertThat(tweetSearchResponse.asCoverage().toPaginatedTweets()._tweets())
            .isEqualTo(tweetSearchResponse.asCoverage()._tweets())
        assertThat(tweetSearchResponse.asCoverage().toPaginatedTweets()._filteredCount())
            .isEqualTo(tweetSearchResponse.asCoverage()._filteredCount())
        assertThat(tweetSearchResponse.asCoverage().toPaginatedTweets()._readBackTo())
            .isEqualTo(tweetSearchResponse.asCoverage()._readBackTo())
        assertThat(tweetSearchResponse.asCoverage().toPaginatedTweets()._searchContext())
            .isEqualTo(tweetSearchResponse.asCoverage()._searchContext())
        assertThat(tweetSearchResponse.asCoverage().toPaginatedTweets()._searchedQuery())
            .isEqualTo(tweetSearchResponse.asCoverage()._searchedQuery())
        assertThat(tweetSearchResponse.asCoverage().toPaginatedTweets()._windowComplete())
            .isEqualTo(tweetSearchResponse.asCoverage()._windowComplete())
    }
}
