// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.xquik.consumer.proguard

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.client.XTwitterScraperClientImpl
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.core.ClientOptions
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.HttpClient
import com.x_twitter_scraper.api.core.http.HttpRequest
import com.x_twitter_scraper.api.core.http.HttpResponse
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.ContentDisclosure
import com.x_twitter_scraper.api.models.EmbeddedTweet
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.SearchTweet
import com.x_twitter_scraper.api.models.TweetMedia
import com.x_twitter_scraper.api.models.UserProfile
import com.x_twitter_scraper.api.models.x.tweets.TweetAuthor
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchResponse
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.util.concurrent.CompletableFuture

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            val test = ProGuardCompatibilityTest()
            test.proguardRules()
            test.client()
            test.productionDeserialization()
            test.tweetAuthorRoundtrip()
            test.tweetSearchResponseRoundtrip()
            test.eventTypeRoundtrip()
        }
    }

    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream(
                "META-INF/proguard/x-twitter-scraper-java-core.pro"
            )

        checkNotNull(rulesFile).close()
    }

    fun client() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()

        client.account()
        client.guestWallets()
        client.subscribe()
        client.compose()
        client.drafts()
        client.styles()
        client.radar()
        client.monitors()
        client.events()
        client.extractions()
        client.draws()
        client.webhooks()
        client.x()
        client.trends()
        client.support()
        client.credits()
        client.close()
    }

    fun productionDeserialization() {
        val client =
            XTwitterScraperClientImpl(
                ClientOptions.builder()
                    .httpClient(FixedResponseHttpClient(CREDIT_BALANCE_JSON))
                    .apiKey("My API Key")
                    .maxRetries(0)
                    .build()
            )

        val balance = client.credits().retrieveBalance()
        check(balance.autoTopupEnabled())
        check(balance.balance() == "42")
        check(balance.lifetimePurchased() == "100")
        check(balance.lifetimeUsed() == "58")
        client.close()
    }

    fun tweetAuthorRoundtrip() {
        val jsonMapper = jsonMapper()
        val tweetAuthor =
            TweetAuthor.builder()
                .id("9876543210")
                .name("Elon Musk")
                .followers(150000000L)
                .username("elonmusk")
                .verified(true)
                .profilePicture("https://pbs.twimg.com/profile_images/example.jpg")
                .build()

        val roundtrippedTweetAuthor =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetAuthor),
                object : TypeReference<TweetAuthor>() {},
            )

        check(roundtrippedTweetAuthor == tweetAuthor) {
            "TweetAuthor roundtrip changed: expected=$tweetAuthor, actual=$roundtrippedTweetAuthor"
        }
    }

    fun tweetSearchResponseRoundtrip() {
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

        check(roundtrippedTweetSearchResponse == tweetSearchResponse) {
            "TweetSearchResponse roundtrip changed"
        }
    }

    fun eventTypeRoundtrip() {
        val jsonMapper = jsonMapper()
        val eventType = EventType.TWEET_NEW

        val roundtrippedEventType =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventType),
                object : TypeReference<EventType>() {},
            )

        check(roundtrippedEventType == eventType) {
            "EventType roundtrip changed: expected=$eventType, actual=$roundtrippedEventType"
        }
    }
}

private const val CREDIT_BALANCE_JSON =
    """{"auto_topup_enabled":true,"balance":"42","lifetime_purchased":"100","lifetime_used":"58"}"""

private class FixedResponseHttpClient(responseBody: String) : HttpClient {

    private val responseBody = responseBody.toByteArray()

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        response()

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> = CompletableFuture.completedFuture(response())

    override fun close() {}

    private fun response(): HttpResponse =
        object : HttpResponse {

            override fun statusCode(): Int = 200

            override fun headers(): Headers = Headers.builder().build()

            override fun body(): InputStream = ByteArrayInputStream(responseBody)

            override fun close() {}
        }
}
