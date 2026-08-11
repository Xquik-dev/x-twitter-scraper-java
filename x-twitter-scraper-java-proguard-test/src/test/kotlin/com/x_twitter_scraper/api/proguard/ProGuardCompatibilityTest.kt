// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.ContentDisclosure
import com.x_twitter_scraper.api.models.EmbeddedTweet
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.SearchTweet
import com.x_twitter_scraper.api.models.TweetMedia
import com.x_twitter_scraper.api.models.UserProfile
import com.x_twitter_scraper.api.models.account.AccountRetrieveResponse
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchResponse
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream(
                "META-INF/proguard/x-twitter-scraper-java-core.pro"
            )

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()

        assertThat(client).isNotNull()
        assertThat(client.account()).isNotNull()
        assertThat(client.subscribe()).isNotNull()
        assertThat(client.compose()).isNotNull()
        assertThat(client.drafts()).isNotNull()
        assertThat(client.styles()).isNotNull()
        assertThat(client.radar()).isNotNull()
        assertThat(client.monitors()).isNotNull()
        assertThat(client.events()).isNotNull()
        assertThat(client.extractions()).isNotNull()
        assertThat(client.draws()).isNotNull()
        assertThat(client.webhooks()).isNotNull()
        assertThat(client.x()).isNotNull()
        assertThat(client.trends()).isNotNull()
        assertThat(client.support()).isNotNull()
        assertThat(client.credits()).isNotNull()
        assertThat(client.guestWallets()).isNotNull()
    }

    @Test
    fun accountRetrieveResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountRetrieveResponse =
            AccountRetrieveResponse.builder()
                .monitorBilling(
                    AccountRetrieveResponse.MonitorBilling.builder()
                        .activeDailyEstimate("1500")
                        .activeHourlyBurn("63")
                        .creditsPerActiveMonitorDay("500")
                        .creditsPerActiveMonitorHour("21")
                        .eventsIncluded(true)
                        .instantCheckIntervalSeconds(1L)
                        .unlimitedSlots(true)
                        .build()
                )
                .monitorsAllowed(9007199254740991L)
                .monitorsUsed(3L)
                .plan(AccountRetrieveResponse.Plan.ACTIVE)
                .creditInfo(
                    AccountRetrieveResponse.CreditInfo.builder()
                        .autoTopupAmountDollars(10.0)
                        .autoTopupEnabled(false)
                        .autoTopupThreshold("50000")
                        .balance("50000")
                        .lifetimePurchased("140000")
                        .lifetimeUsed("90000")
                        .build()
                )
                .xUsername("elonmusk")
                .build()

        val roundtrippedAccountRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountRetrieveResponse),
                jacksonTypeRef<AccountRetrieveResponse>(),
            )

        assertThat(roundtrippedAccountRetrieveResponse).isEqualTo(accountRetrieveResponse)
    }

    @Test
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

        assertThat(roundtrippedTweetSearchResponse).isEqualTo(tweetSearchResponse)
    }

    @Test
    fun eventTypeRoundtrip() {
        val jsonMapper = jsonMapper()
        val eventType = EventType.TWEET_NEW

        val roundtrippedEventType =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(eventType),
                jacksonTypeRef<EventType>(),
            )

        assertThat(roundtrippedEventType).isEqualTo(eventType)
    }
}
