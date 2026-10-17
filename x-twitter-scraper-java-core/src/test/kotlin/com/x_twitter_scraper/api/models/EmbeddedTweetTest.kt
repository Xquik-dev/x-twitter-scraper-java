// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmbeddedTweetTest {

    @Test
    fun create() {
        val embeddedTweet =
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

        assertThat(embeddedTweet.id()).isEqualTo("id")
        assertThat(embeddedTweet.bookmarkCount()).isEqualTo(0L)
        assertThat(embeddedTweet.likeCount()).isEqualTo(0L)
        assertThat(embeddedTweet.quoteCount()).isEqualTo(0L)
        assertThat(embeddedTweet.replyCount()).isEqualTo(0L)
        assertThat(embeddedTweet.retweetCount()).isEqualTo(0L)
        assertThat(embeddedTweet.text()).isEqualTo("text")
        assertThat(embeddedTweet.viewCount()).isEqualTo(0L)
        assertThat(embeddedTweet.article())
            .contains(
                EmbeddedTweet.Article.builder()
                    .id("id")
                    .coverMediaUrl("coverMediaUrl")
                    .previewText("previewText")
                    .title("title")
                    .build()
            )
        assertThat(embeddedTweet.author())
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
        assertThat(embeddedTweet.card())
            .contains(
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
        assertThat(embeddedTweet.communityNote())
            .contains(
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
        assertThat(embeddedTweet.contentDisclosure())
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
        assertThat(embeddedTweet.conversationId()).contains("conversationId")
        assertThat(embeddedTweet.createdAt()).contains("createdAt")
        assertThat(embeddedTweet.displayTextRange().getOrNull()).containsExactly(0L)
        assertThat(embeddedTweet.edit())
            .contains(
                EmbeddedTweet.Edit.builder()
                    .editableUntilMsecs("editableUntilMsecs")
                    .addEditTweetId("string")
                    .build()
            )
        assertThat(embeddedTweet.entities())
            .contains(
                EmbeddedTweet.Entities.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(embeddedTweet.inReplyToId()).contains("inReplyToId")
        assertThat(embeddedTweet.inReplyToUserId()).contains("inReplyToUserId")
        assertThat(embeddedTweet.inReplyToUsername()).contains("inReplyToUsername")
        assertThat(embeddedTweet.isLimitedReply()).contains(true)
        assertThat(embeddedTweet.isNoteTweet()).contains(true)
        assertThat(embeddedTweet.isQuoteStatus()).contains(true)
        assertThat(embeddedTweet.isReply()).contains(true)
        assertThat(embeddedTweet.isTranslatable()).contains(true)
        assertThat(embeddedTweet.lang()).contains("lang")
        assertThat(embeddedTweet.media().getOrNull())
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
        assertThat(embeddedTweet.noteTweet())
            .contains(
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
        assertThat(embeddedTweet.place())
            .contains(
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
        assertThat(embeddedTweet.possiblySensitive()).contains(true)
        assertThat(embeddedTweet.previousCounts())
            .contains(
                EmbeddedTweet.PreviousCounts.builder()
                    .bookmarkCount(0L)
                    .likeCount(0L)
                    .quoteCount(0L)
                    .replyCount(0L)
                    .retweetCount(0L)
                    .build()
            )
        assertThat(embeddedTweet.source()).contains("source")
        assertThat(embeddedTweet.type()).contains("type")
        assertThat(embeddedTweet.url()).contains("url")
        assertThat(embeddedTweet.viewState()).contains("viewState")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val embeddedTweet =
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

        val roundtrippedEmbeddedTweet =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(embeddedTweet),
                jacksonTypeRef<EmbeddedTweet>(),
            )

        assertThat(roundtrippedEmbeddedTweet).isEqualTo(embeddedTweet)
    }

    @Test
    fun readsEveryFieldTheSpecDescribes() {
        val embeddedTweet =
            jsonMapper()
                .readValue(
                    """
                    {
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
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<EmbeddedTweet>(),
                )

        embeddedTweet.validate()
        assertThat(embeddedTweet.id()).isEqualTo("1234567890")
        assertThat(embeddedTweet.bookmarkCount()).isEqualTo(2L)
        assertThat(embeddedTweet.likeCount()).isEqualTo(42L)
        assertThat(embeddedTweet.quoteCount()).isEqualTo(1L)
        assertThat(embeddedTweet.replyCount()).isEqualTo(3L)
        assertThat(embeddedTweet.retweetCount()).isEqualTo(5L)
        assertThat(embeddedTweet.text()).isEqualTo("Just launched!")
        assertThat(embeddedTweet.viewCount()).isEqualTo(1500L)
        assertThat(embeddedTweet.author().get().id()).isEqualTo("11348282")
        assertThat(embeddedTweet.author().get().name()).isEqualTo("NASA")
        assertThat(embeddedTweet.author().get().username()).isEqualTo("NASA")
        assertThat(embeddedTweet._additionalProperties()).isEmpty()
    }
}
