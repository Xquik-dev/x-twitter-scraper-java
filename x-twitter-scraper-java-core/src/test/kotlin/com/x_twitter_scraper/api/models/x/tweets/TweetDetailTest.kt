// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.ContentDisclosure
import com.x_twitter_scraper.api.models.EmbeddedTweet
import com.x_twitter_scraper.api.models.SearchTweet
import com.x_twitter_scraper.api.models.TweetMedia
import com.x_twitter_scraper.api.models.UserProfile
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetDetailTest {

    @Test
    fun create() {
        val tweetDetail =
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

        assertThat(tweetDetail.id()).isEqualTo("1234567890")
        assertThat(tweetDetail.bookmarkCount()).isEqualTo(2L)
        assertThat(tweetDetail.likeCount()).isEqualTo(42L)
        assertThat(tweetDetail.quoteCount()).isEqualTo(1L)
        assertThat(tweetDetail.replyCount()).isEqualTo(3L)
        assertThat(tweetDetail.retweetCount()).isEqualTo(5L)
        assertThat(tweetDetail.text()).isEqualTo("Just launched our new feature!")
        assertThat(tweetDetail.viewCount()).isEqualTo(1500L)
        assertThat(tweetDetail.article())
            .contains(
                TweetDetail.Article.builder()
                    .id("id")
                    .coverMediaUrl("coverMediaUrl")
                    .previewText("previewText")
                    .title("title")
                    .build()
            )
        assertThat(tweetDetail.author())
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
        assertThat(tweetDetail.card())
            .contains(
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
        assertThat(tweetDetail.communityNote())
            .contains(
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
        assertThat(tweetDetail.contentDisclosure())
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
        assertThat(tweetDetail.conversationId()).contains("1234567890")
        assertThat(tweetDetail.createdAt()).contains("2025-01-15T12:00:00Z")
        assertThat(tweetDetail.displayTextRange().getOrNull()).containsExactly(0L, 31L)
        assertThat(tweetDetail.edit())
            .contains(
                TweetDetail.Edit.builder()
                    .editableUntilMsecs("editableUntilMsecs")
                    .addEditTweetId("string")
                    .build()
            )
        assertThat(tweetDetail.entities())
            .contains(
                TweetDetail.Entities.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(tweetDetail.inReplyToId()).contains("1234567890")
        assertThat(tweetDetail.inReplyToUserId()).contains("9876543210")
        assertThat(tweetDetail.inReplyToUsername()).contains("example_user")
        assertThat(tweetDetail.isLimitedReply()).contains(false)
        assertThat(tweetDetail.isNoteTweet()).contains(false)
        assertThat(tweetDetail.isQuoteStatus()).contains(false)
        assertThat(tweetDetail.isReply()).contains(false)
        assertThat(tweetDetail.isTranslatable()).contains(true)
        assertThat(tweetDetail.lang()).contains("en")
        assertThat(tweetDetail.media().getOrNull())
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
        assertThat(tweetDetail.noteTweet())
            .contains(
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
        assertThat(tweetDetail.place())
            .contains(
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
        assertThat(tweetDetail.possiblySensitive()).contains(true)
        assertThat(tweetDetail.previousCounts())
            .contains(
                TweetDetail.PreviousCounts.builder()
                    .bookmarkCount(0L)
                    .likeCount(0L)
                    .quoteCount(0L)
                    .replyCount(0L)
                    .retweetCount(0L)
                    .build()
            )
        assertThat(tweetDetail.quotedTweet())
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
        assertThat(tweetDetail.retweetedTweet())
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
        assertThat(tweetDetail.source()).contains("Twitter Web App")
        assertThat(tweetDetail.type()).contains("tweet")
        assertThat(tweetDetail.url()).contains("https://x.com/example_user/status/1234567890")
        assertThat(tweetDetail.viewState()).contains("viewState")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetDetail =
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

        val roundtrippedTweetDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetDetail),
                jacksonTypeRef<TweetDetail>(),
            )

        assertThat(roundtrippedTweetDetail).isEqualTo(tweetDetail)
    }

    @Test
    fun readsEveryFieldTheSpecDescribes() {
        val tweetDetail =
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
                    jacksonTypeRef<TweetDetail>(),
                )

        tweetDetail.validate()
        assertThat(tweetDetail.id()).isEqualTo("1234567890")
        assertThat(tweetDetail.bookmarkCount()).isEqualTo(2L)
        assertThat(tweetDetail.likeCount()).isEqualTo(42L)
        assertThat(tweetDetail.quoteCount()).isEqualTo(1L)
        assertThat(tweetDetail.replyCount()).isEqualTo(3L)
        assertThat(tweetDetail.retweetCount()).isEqualTo(5L)
        assertThat(tweetDetail.text()).isEqualTo("Just launched!")
        assertThat(tweetDetail.viewCount()).isEqualTo(1500L)
        assertThat(tweetDetail.article().get().id()).contains("id-value")
        assertThat(tweetDetail.article().get().coverMediaUrl()).contains("coverMediaUrl-value")
        assertThat(tweetDetail.article().get().previewText()).contains("previewText-value")
        assertThat(tweetDetail.article().get().title()).contains("title-value")
        assertThat(tweetDetail.article().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.author().get().id()).isEqualTo("11348282")
        assertThat(tweetDetail.author().get().name()).isEqualTo("NASA")
        assertThat(tweetDetail.author().get().username()).isEqualTo("NASA")
        assertThat(tweetDetail.authorUnavailable().get().reason()).isEqualTo("Suspended")
        assertThat(tweetDetail.authorUnavailable().get().message()).contains("message-value")
        assertThat(tweetDetail.authorUnavailable().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.card().get().id()).contains("id-value")
        assertThat(tweetDetail.card().get().name()).contains("name-value")
        assertThat(tweetDetail.card().get().url()).contains("url-value")
        assertThat(tweetDetail.card().get().userReferenceErrors().get()).hasSize(1)
        assertThat(tweetDetail.card().get().userReferenceErrors().get()[0].message())
            .contains("message-value")
        assertThat(tweetDetail.card().get().userReferenceErrors().get()[0].reason())
            .contains("reason-value")
        assertThat(tweetDetail.card().get().userReferenceErrors().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(tweetDetail.card().get().userReferences().get()).hasSize(1)
        assertThat(tweetDetail.card().get().userReferences().get()[0].id()).isEqualTo("11348282")
        assertThat(tweetDetail.card().get().userReferences().get()[0].name()).isEqualTo("NASA")
        assertThat(tweetDetail.card().get().userReferences().get()[0].username()).isEqualTo("NASA")
        assertThat(tweetDetail.card().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.cashtagAttachments().get()).hasSize(1)
        assertThat(tweetDetail.cashtagAttachments().get()[0].cashtag()).isEqualTo("\$TSLA")
        assertThat(tweetDetail.cashtagAttachments().get()[0].candleSize()).contains("5m")
        assertThat(tweetDetail.cashtagAttachments().get()[0].endTime())
            .contains(OffsetDateTime.parse("2026-10-09T13:42:08.796Z"))
        assertThat(tweetDetail.cashtagAttachments().get()[0].sizeVariant()).contains(1L)
        assertThat(tweetDetail.cashtagAttachments().get()[0].startTime())
            .contains(OffsetDateTime.parse("2026-10-09T13:30:00.000Z"))
        assertThat(tweetDetail.cashtagAttachments().get()[0].timeframe()).contains("1D")
        assertThat(tweetDetail.cashtagAttachments().get()[0]._additionalProperties()).isEmpty()
        assertThat(tweetDetail.communityId()).contains("communityId-value")
        assertThat(tweetDetail.communityName()).contains("Build in Public")
        assertThat(tweetDetail.communityNote().get().footerIconType())
            .contains("footerIconType-value")
        assertThat(tweetDetail.communityNote().get().iconType()).contains("iconType-value")
        assertThat(tweetDetail.communityNote().get().id()).contains("id-value")
        assertThat(tweetDetail.communityNote().get().destinationUrl())
            .contains("destinationUrl-value")
        assertThat(tweetDetail.communityNote().get().footer()).contains("footer-value")
        assertThat(tweetDetail.communityNote().get().shortTitle()).contains("shortTitle-value")
        assertThat(tweetDetail.communityNote().get().subtitle()).contains("subtitle-value")
        assertThat(tweetDetail.communityNote().get().title()).contains("title-value")
        assertThat(tweetDetail.communityNote().get().visualStyle()).contains("visualStyle-value")
        assertThat(tweetDetail.communityNote().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.conversationControl().get().allowedCountryCodes().get())
            .containsExactly("TR")
        assertThat(tweetDetail.conversationControl().get().inviteViaMention()).contains(false)
        assertThat(tweetDetail.conversationControl().get().mode()).contains("my_network")
        assertThat(tweetDetail.conversationControl().get().ownerId())
            .contains("1902917852849385472")
        assertThat(tweetDetail.conversationControl().get().ownerUsername())
            .contains("ownerUsername-value")
        assertThat(tweetDetail.conversationControl().get().policy()).contains("by_invitation")
        assertThat(tweetDetail.conversationControl().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.conversationId()).contains("1234567890")
        assertThat(tweetDetail.coordinates().get().coordinates()).containsExactly(1279.5)
        assertThat(tweetDetail.coordinates().get().type())
            .isEqualTo(SearchTweet.Coordinates.Type.POINT)
        assertThat(tweetDetail.coordinates().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.createdAt()).contains("2025-01-15T12:00:00Z")
        assertThat(tweetDetail.displayTextRange().get()).containsExactly(1772L)
        assertThat(tweetDetail.edit().get().editableUntilMsecs())
            .contains("editableUntilMsecs-value")
        assertThat(tweetDetail.edit().get().editTweetIds().get())
            .containsExactly("editTweetIds-value")
        assertThat(tweetDetail.edit().get().initialTweetId()).contains("initialTweetId-value")
        assertThat(tweetDetail.edit().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.entities().get().hashtags().get()).hasSize(1)
        assertThat(tweetDetail.entities().get().hashtags().get()[0].text()).isEqualTo("text-value")
        assertThat(tweetDetail.entities().get().hashtags().get()[0].indices().get())
            .containsExactly(835L)
        assertThat(tweetDetail.entities().get().hashtags().get()[0].tag().get().id())
            .contains("U21hcnRUYWc6VFNMQQ==")
        assertThat(
                tweetDetail
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
                tweetDetail.entities().get().hashtags().get()[0].tag().get()._additionalProperties()
            )
            .isEmpty()
        assertThat(tweetDetail.entities().get().hashtags().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(tweetDetail.entities().get().smarttags().get()).hasSize(1)
        assertThat(tweetDetail.entities().get().smarttags().get()[0].indices().get())
            .containsExactly(835L)
        assertThat(tweetDetail.entities().get().smarttags().get()[0].seconds()).contains(851.5)
        assertThat(tweetDetail.entities().get().smarttags().get()[0].tag().get().id())
            .contains("U21hcnRUYWc6VFNMQQ==")
        assertThat(
                tweetDetail
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
                tweetDetail
                    .entities()
                    .get()
                    .smarttags()
                    .get()[0]
                    .tag()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(tweetDetail.entities().get().smarttags().get()[0].text()).contains("text-value")
        assertThat(tweetDetail.entities().get().smarttags().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(tweetDetail.entities().get().symbols().get()).hasSize(1)
        assertThat(tweetDetail.entities().get().symbols().get()[0].indices().get())
            .containsExactly(835L)
        assertThat(tweetDetail.entities().get().symbols().get()[0].seconds()).contains(851.5)
        assertThat(tweetDetail.entities().get().symbols().get()[0].tag().get().id())
            .contains("U21hcnRUYWc6VFNMQQ==")
        assertThat(
                tweetDetail
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
                tweetDetail.entities().get().symbols().get()[0].tag().get()._additionalProperties()
            )
            .isEmpty()
        assertThat(tweetDetail.entities().get().symbols().get()[0].text()).contains("text-value")
        assertThat(tweetDetail.entities().get().symbols().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(tweetDetail.entities().get().timestamps().get()).hasSize(1)
        assertThat(tweetDetail.entities().get().timestamps().get()[0].indices().get())
            .containsExactly(835L)
        assertThat(tweetDetail.entities().get().timestamps().get()[0].seconds()).contains(851.5)
        assertThat(tweetDetail.entities().get().timestamps().get()[0].tag().get().id())
            .contains("U21hcnRUYWc6VFNMQQ==")
        assertThat(
                tweetDetail
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
                tweetDetail
                    .entities()
                    .get()
                    .timestamps()
                    .get()[0]
                    .tag()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(tweetDetail.entities().get().timestamps().get()[0].text()).contains("text-value")
        assertThat(tweetDetail.entities().get().timestamps().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(tweetDetail.entities().get().urls().get()).hasSize(1)
        assertThat(tweetDetail.entities().get().urls().get()[0].displayUrl())
            .contains("display_url-value")
        assertThat(tweetDetail.entities().get().urls().get()[0].expandedUrl())
            .contains("expanded_url-value")
        assertThat(tweetDetail.entities().get().urls().get()[0].indices().get())
            .containsExactly(835L)
        assertThat(tweetDetail.entities().get().urls().get()[0].url()).contains("url-value")
        assertThat(tweetDetail.entities().get().urls().get()[0]._additionalProperties()).isEmpty()
        assertThat(tweetDetail.entities().get().userMentions().get()).hasSize(1)
        assertThat(tweetDetail.entities().get().userMentions().get()[0].screenName())
            .isEqualTo("screen_name-value")
        assertThat(tweetDetail.entities().get().userMentions().get()[0].idStr())
            .contains("id_str-value")
        assertThat(tweetDetail.entities().get().userMentions().get()[0].indices().get())
            .containsExactly(835L)
        assertThat(tweetDetail.entities().get().userMentions().get()[0].name())
            .contains("name-value")
        assertThat(tweetDetail.entities().get().userMentions().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(tweetDetail.entities().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.exclusiveContent().get().creatorUserName())
            .isEqualTo("creatorUserName-value")
        assertThat(tweetDetail.exclusiveContent().get().subscribeUrl())
            .contains("subscribeUrl-value")
        assertThat(tweetDetail.exclusiveContent().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.geo().get().coordinates()).containsExactly(1279.5)
        assertThat(tweetDetail.geo().get().type()).isEqualTo(SearchTweet.Geo.Type.POINT)
        assertThat(tweetDetail.geo().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.hasCommunityNotes()).contains(true)
        assertThat(tweetDetail.inReplyToId()).contains("1234567890")
        assertThat(tweetDetail.inReplyToUserId()).contains("9876543210")
        assertThat(tweetDetail.inReplyToUsername()).contains("example_user")
        assertThat(tweetDetail.interstitial().get().displayType()).contains("NonCompliant")
        assertThat(tweetDetail.interstitial().get().text().get().entities().get()).hasSize(1)
        assertThat(tweetDetail.interstitial().get().text().get().entities().get()[0].fromIndex())
            .contains(1040L)
        assertThat(
                tweetDetail
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
                tweetDetail.interstitial().get().text().get().entities().get()[0].ref().get().text()
            )
            .contains("text-value")
        assertThat(
                tweetDetail.interstitial().get().text().get().entities().get()[0].ref().get().type()
            )
            .contains("TimelineUrl")
        assertThat(
                tweetDetail.interstitial().get().text().get().entities().get()[0].ref().get().url()
            )
            .contains("https://help.x.com/rules-and-policies/public-interest")
        assertThat(
                tweetDetail
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
                tweetDetail
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
        assertThat(tweetDetail.interstitial().get().text().get().entities().get()[0].toIndex())
            .contains(831L)
        assertThat(
                tweetDetail
                    .interstitial()
                    .get()
                    .text()
                    .get()
                    .entities()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(tweetDetail.interstitial().get().text().get().rtl()).contains(true)
        assertThat(tweetDetail.interstitial().get().text().get().text())
            .contains(
                "This Post violated the X Rules about glorifying violence. However, X has determined that it may be in the public's interest for the Post to remain accessible. Learn more"
            )
        assertThat(tweetDetail.interstitial().get().text().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.interstitial().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.isLimitedReply()).contains(false)
        assertThat(tweetDetail.isNoteTweet()).contains(false)
        assertThat(tweetDetail.isPinned()).contains(false)
        assertThat(tweetDetail.isQuoteStatus()).contains(false)
        assertThat(tweetDetail.isReply()).contains(false)
        assertThat(tweetDetail.isRetweet()).contains(false)
        assertThat(tweetDetail.isTranslatable()).contains(false)
        assertThat(tweetDetail.lang()).contains("en")
        assertThat(tweetDetail.limitedActions().get()).hasSize(1)
        assertThat(tweetDetail.limitedActions().get()[0].action()).contains("Reply")
        assertThat(tweetDetail.limitedActions().get()[0].prompt().get().ctaType())
            .contains("SeeConversation")
        assertThat(tweetDetail.limitedActions().get()[0].prompt().get().headline())
            .contains("headline-value")
        assertThat(tweetDetail.limitedActions().get()[0].prompt().get().subtext())
            .contains("subtext-value")
        assertThat(tweetDetail.limitedActions().get()[0].prompt().get()._additionalProperties())
            .isEmpty()
        assertThat(tweetDetail.limitedActions().get()[0]._additionalProperties()).isEmpty()
        assertThat(tweetDetail.media().get()).hasSize(1)
        assertThat(tweetDetail.media().get()[0].id()).contains("string")
        assertThat(tweetDetail.noteTweet().get().text()).isEqualTo("text-value")
        assertThat(tweetDetail.noteTweet().get().id()).contains("id-value")
        assertThat(tweetDetail.noteTweet().get().entities().get().hashtags().get()).hasSize(1)
        assertThat(tweetDetail.noteTweet().get().entities().get().hashtags().get()[0].text())
            .isEqualTo("text-value")
        assertThat(
                tweetDetail.noteTweet().get().entities().get().hashtags().get()[0].indices().get()
            )
            .containsExactly(1L)
        assertThat(
                tweetDetail
                    .noteTweet()
                    .get()
                    .entities()
                    .get()
                    .hashtags()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(tweetDetail.noteTweet().get().entities().get().smarttags().get()).hasSize(1)
        assertThat(
                tweetDetail.noteTweet().get().entities().get().smarttags().get()[0].indices().get()
            )
            .containsExactly(1L)
        assertThat(tweetDetail.noteTweet().get().entities().get().smarttags().get()[0].seconds())
            .contains(851.5)
        assertThat(tweetDetail.noteTweet().get().entities().get().smarttags().get()[0].text())
            .contains("text-value")
        assertThat(
                tweetDetail
                    .noteTweet()
                    .get()
                    .entities()
                    .get()
                    .smarttags()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(tweetDetail.noteTweet().get().entities().get().symbols().get()).hasSize(1)
        assertThat(
                tweetDetail.noteTweet().get().entities().get().symbols().get()[0].indices().get()
            )
            .containsExactly(1L)
        assertThat(tweetDetail.noteTweet().get().entities().get().symbols().get()[0].seconds())
            .contains(851.5)
        assertThat(tweetDetail.noteTweet().get().entities().get().symbols().get()[0].text())
            .contains("text-value")
        assertThat(
                tweetDetail
                    .noteTweet()
                    .get()
                    .entities()
                    .get()
                    .symbols()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(tweetDetail.noteTweet().get().entities().get().timestamps().get()).hasSize(1)
        assertThat(
                tweetDetail.noteTweet().get().entities().get().timestamps().get()[0].indices().get()
            )
            .containsExactly(1L)
        assertThat(tweetDetail.noteTweet().get().entities().get().timestamps().get()[0].seconds())
            .contains(851.5)
        assertThat(tweetDetail.noteTweet().get().entities().get().timestamps().get()[0].text())
            .contains("text-value")
        assertThat(
                tweetDetail
                    .noteTweet()
                    .get()
                    .entities()
                    .get()
                    .timestamps()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(tweetDetail.noteTweet().get().entities().get().urls().get()).hasSize(1)
        assertThat(tweetDetail.noteTweet().get().entities().get().urls().get()[0].displayUrl())
            .contains("display_url-value")
        assertThat(tweetDetail.noteTweet().get().entities().get().urls().get()[0].expandedUrl())
            .contains("expanded_url-value")
        assertThat(tweetDetail.noteTweet().get().entities().get().urls().get()[0].indices().get())
            .containsExactly(1L)
        assertThat(tweetDetail.noteTweet().get().entities().get().urls().get()[0].url())
            .contains("url-value")
        assertThat(
                tweetDetail
                    .noteTweet()
                    .get()
                    .entities()
                    .get()
                    .urls()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(tweetDetail.noteTweet().get().entities().get().userMentions().get()).hasSize(1)
        assertThat(
                tweetDetail.noteTweet().get().entities().get().userMentions().get()[0].screenName()
            )
            .isEqualTo("screen_name-value")
        assertThat(tweetDetail.noteTweet().get().entities().get().userMentions().get()[0].idStr())
            .contains("id_str-value")
        assertThat(
                tweetDetail
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
        assertThat(tweetDetail.noteTweet().get().entities().get().userMentions().get()[0].name())
            .contains("name-value")
        assertThat(
                tweetDetail
                    .noteTweet()
                    .get()
                    .entities()
                    .get()
                    .userMentions()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(tweetDetail.noteTweet().get().entities().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.noteTweet().get().inlineMedia().get()).hasSize(1)
        assertThat(tweetDetail.noteTweet().get().inlineMedia().get()[0].index()).isEqualTo(636L)
        assertThat(tweetDetail.noteTweet().get().inlineMedia().get()[0].mediaId())
            .isEqualTo("mediaId-value")
        assertThat(tweetDetail.noteTweet().get().inlineMedia().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(tweetDetail.noteTweet().get().isExpandable()).contains(true)
        assertThat(tweetDetail.noteTweet().get().noteId()).contains("2100306607800229889")
        assertThat(tweetDetail.noteTweet().get().richtextTags().get()).hasSize(1)
        assertThat(tweetDetail.noteTweet().get().richtextTags().get()[0].fromIndex())
            .isEqualTo(1040L)
        assertThat(tweetDetail.noteTweet().get().richtextTags().get()[0].toIndex()).isEqualTo(831L)
        assertThat(tweetDetail.noteTweet().get().richtextTags().get()[0].types())
            .containsExactly("types-value")
        assertThat(tweetDetail.noteTweet().get().richtextTags().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(tweetDetail.noteTweet().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.parentTweet().get().id()).isEqualTo("1234567890")
        assertThat(tweetDetail.parentTweet().get().text()).isEqualTo("Just launched!")
        assertThat(tweetDetail.place().get().id()).contains("id-value")
        assertThat(tweetDetail.place().get().country()).contains("country-value")
        assertThat(tweetDetail.place().get().countryCode()).contains("countryCode-value")
        assertThat(tweetDetail.place().get().fullName()).contains("fullName-value")
        assertThat(tweetDetail.place().get().name()).contains("name-value")
        assertThat(tweetDetail.place().get().placeType()).contains("placeType-value")
        assertThat(tweetDetail.place().get().url()).contains("url-value")
        assertThat(tweetDetail.place().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.possiblySensitive()).contains(false)
        assertThat(tweetDetail.previousCounts().get().bookmarkCount()).contains(1475L)
        assertThat(tweetDetail.previousCounts().get().likeCount()).contains(1042L)
        assertThat(tweetDetail.previousCounts().get().quoteCount()).contains(1179L)
        assertThat(tweetDetail.previousCounts().get().replyCount()).contains(1177L)
        assertThat(tweetDetail.previousCounts().get().retweetCount()).contains(1389L)
        assertThat(tweetDetail.previousCounts().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.quotedTweet().get().id()).isEqualTo("1234567890")
        assertThat(tweetDetail.quotedTweet().get().text()).isEqualTo("Just launched!")
        assertThat(tweetDetail.quotedTweetId()).contains("quotedTweetId-value")
        assertThat(tweetDetail.quotedTweetPermalink().get().displayUrl())
            .contains("displayUrl-value")
        assertThat(tweetDetail.quotedTweetPermalink().get().expandedUrl())
            .contains("expandedUrl-value")
        assertThat(tweetDetail.quotedTweetPermalink().get().url()).contains("url-value")
        assertThat(tweetDetail.quotedTweetPermalink().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.quotedTweetUnavailable().get().reason()).isEqualTo("Suspended")
        assertThat(tweetDetail.quotedTweetUnavailable().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.reactionContext().get().reactedToPostId())
            .contains("reactedToPostId-value")
        assertThat(tweetDetail.reactionContext().get().reactedToUser().get().id())
            .isEqualTo("11348282")
        assertThat(tweetDetail.reactionContext().get().reactedToUser().get().name())
            .isEqualTo("NASA")
        assertThat(tweetDetail.reactionContext().get().reactedToUser().get().username())
            .isEqualTo("NASA")
        assertThat(tweetDetail.reactionContext().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.retweetedTweet().get().id()).isEqualTo("1234567890")
        assertThat(tweetDetail.retweetedTweet().get().text()).isEqualTo("Just launched!")
        assertThat(tweetDetail.retweetedAt())
            .contains(OffsetDateTime.parse("2026-09-11T20:24:45.000Z"))
        assertThat(tweetDetail.source())
            .contains("<a href=\"https://mobile.twitter.com\" rel=\"nofollow\">Twitter Web App</a>")
        assertThat(tweetDetail.sportsContext().get().competitors().get()).hasSize(1)
        assertThat(tweetDetail.sportsContext().get().competitors().get()[0].abbreviation())
            .contains("abbreviation-value")
        assertThat(tweetDetail.sportsContext().get().competitors().get()[0].color())
            .contains("color-value")
        assertThat(tweetDetail.sportsContext().get().competitors().get()[0].darkLogoUrl())
            .contains("darkLogoUrl-value")
        assertThat(tweetDetail.sportsContext().get().competitors().get()[0].isActive())
            .contains(true)
        assertThat(tweetDetail.sportsContext().get().competitors().get()[0].isWinner())
            .contains(false)
        assertThat(tweetDetail.sportsContext().get().competitors().get()[0].logoUrl())
            .contains("logoUrl-value")
        assertThat(tweetDetail.sportsContext().get().competitors().get()[0].name())
            .contains("name-value")
        assertThat(tweetDetail.sportsContext().get().competitors().get()[0].score())
            .contains("score-value")
        assertThat(tweetDetail.sportsContext().get().competitors().get()[0].teamId())
            .contains("teamId-value")
        assertThat(tweetDetail.sportsContext().get().competitors().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(tweetDetail.sportsContext().get().gameId()).contains("gameId-value")
        assertThat(tweetDetail.sportsContext().get().league()).contains("league-value")
        assertThat(tweetDetail.sportsContext().get().state()).contains("state-value")
        assertThat(tweetDetail.sportsContext().get().statusText()).contains("statusText-value")
        assertThat(tweetDetail.sportsContext().get().title()).contains("title-value")
        assertThat(tweetDetail.sportsContext().get().url()).contains("url-value")
        assertThat(tweetDetail.sportsContext().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.subscriberBadge().get().creatorId()).isEqualTo("44196397")
        assertThat(tweetDetail.subscriberBadge().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.textHighlights().get()).hasSize(1)
        assertThat(tweetDetail.textHighlights().get()[0].endIndex()).isEqualTo(13L)
        assertThat(tweetDetail.textHighlights().get()[0].startIndex()).isEqualTo(5L)
        assertThat(tweetDetail.textHighlights().get()[0]._additionalProperties()).isEmpty()
        assertThat(tweetDetail.tombstone().get().text().get().entities().get()).hasSize(1)
        assertThat(tweetDetail.tombstone().get().text().get().entities().get()[0].fromIndex())
            .contains(1040L)
        assertThat(
                tweetDetail
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
                tweetDetail.tombstone().get().text().get().entities().get()[0].ref().get().text()
            )
            .contains("text-value")
        assertThat(
                tweetDetail.tombstone().get().text().get().entities().get()[0].ref().get().type()
            )
            .contains("type-value")
        assertThat(tweetDetail.tombstone().get().text().get().entities().get()[0].ref().get().url())
            .contains("url-value")
        assertThat(
                tweetDetail.tombstone().get().text().get().entities().get()[0].ref().get().urlType()
            )
            .contains("urlType-value")
        assertThat(
                tweetDetail
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
        assertThat(tweetDetail.tombstone().get().text().get().entities().get()[0].toIndex())
            .contains(831L)
        assertThat(
                tweetDetail
                    .tombstone()
                    .get()
                    .text()
                    .get()
                    .entities()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(tweetDetail.tombstone().get().text().get().rtl()).contains(true)
        assertThat(tweetDetail.tombstone().get().text().get().text()).contains("text-value")
        assertThat(tweetDetail.tombstone().get().text().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.tombstone().get().type()).contains("type-value")
        assertThat(tweetDetail.tombstone().get()._additionalProperties()).isEmpty()
        assertThat(tweetDetail.type()).contains("tweet")
        assertThat(tweetDetail.unavailableAuthorId()).contains("unavailableAuthorId-value")
        assertThat(tweetDetail.unmentionedUserIds().get())
            .containsExactly("unmentionedUserIds-value")
        assertThat(tweetDetail.url()).contains("https://x.com/example_user/status/1234567890")
        assertThat(tweetDetail.viewState()).contains("viewState-value")
        assertThat(tweetDetail._additionalProperties()).isEmpty()
    }
}
