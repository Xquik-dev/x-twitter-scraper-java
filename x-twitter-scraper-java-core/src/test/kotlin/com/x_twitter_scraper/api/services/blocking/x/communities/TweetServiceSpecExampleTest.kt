// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x.communities

import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.XTwitterScraperClient
import com.x_twitter_scraper.api.client.XTwitterScraperClientAsync
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.TweetMedia
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListByCommunityParams
import com.x_twitter_scraper.api.models.x.communities.tweets.TweetListParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class TweetSpecExampleTest {

    private lateinit var client: XTwitterScraperClient
    private lateinit var asyncClient: XTwitterScraperClientAsync

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .responseValidation(true)
                .build()
        asyncClient =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .responseValidation(true)
                .build()
    }

    @Test
    fun listParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/communities/tweets")).willReturn(okJson(paginatedTweetsExample))
        )
        val params =
            TweetListParams.builder()
                .communityId("communityId-sample")
                .q("q-sample")
                .anyWords("anyWords-sample")
                .blueVerifiedOnly(true)
                .cashtags("cashtags-sample")
                .conversationId("conversationId-sample")
                .cursor("cursor-sample")
                .exactPhrase("exactPhrase-sample")
                .excludeWords("excludeWords-sample")
                .fields("id,text,author.username")
                .fromUser("fromUser-sample")
                .hashtags("hashtags-sample")
                .inReplyToTweetId("inReplyToTweetId-sample")
                .language("language-sample")
                .maxFaves(24L)
                .maxId("maxId-sample")
                .maxQuotes(26L)
                .maxReplies(27L)
                .maxRetweets(28L)
                .mentioning("mentioning-sample")
                .minBookmarks(31L)
                .minLikes(32L)
                .minQuotes(33L)
                .minReplies(34L)
                .minRetweets(35L)
                .minViews(36L)
                .nativeRetweets(true)
                .omit("entities,media")
                .pageSize(39L)
                .quotesOfTweetId("quotesOfTweetId-sample")
                .retweetsOfTweetId("retweetsOfTweetId-sample")
                .sinceId("sinceId-sample")
                .toUser("toUser-sample")
                .url("url-sample")
                .verifiedOnly(true)
                .withinTime("7d")
                .build()

        val response = client.x().communities().tweets().list(params)
        val asyncResponse = asyncClient.x().communities().tweets().list(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/communities/tweets"))
                .withQueryParam("communityId", equalTo("communityId-sample"))
                .withQueryParam("q", equalTo("q-sample"))
                .withQueryParam("anyWords", equalTo("anyWords-sample"))
                .withQueryParam("blueVerifiedOnly", equalTo("true"))
                .withQueryParam("cashtags", equalTo("cashtags-sample"))
                .withQueryParam("conversationId", equalTo("conversationId-sample"))
                .withQueryParam("cursor", equalTo("cursor-sample"))
                .withQueryParam("exactPhrase", equalTo("exactPhrase-sample"))
                .withQueryParam("excludeWords", equalTo("excludeWords-sample"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("fromUser", equalTo("fromUser-sample"))
                .withQueryParam("hashtags", equalTo("hashtags-sample"))
                .withQueryParam("inReplyToTweetId", equalTo("inReplyToTweetId-sample"))
                .withQueryParam("language", equalTo("language-sample"))
                .withQueryParam("maxFaves", equalTo("24"))
                .withQueryParam("maxId", equalTo("maxId-sample"))
                .withQueryParam("maxQuotes", equalTo("26"))
                .withQueryParam("maxReplies", equalTo("27"))
                .withQueryParam("maxRetweets", equalTo("28"))
                .withQueryParam("mentioning", equalTo("mentioning-sample"))
                .withQueryParam("minBookmarks", equalTo("31"))
                .withQueryParam("minLikes", equalTo("32"))
                .withQueryParam("minQuotes", equalTo("33"))
                .withQueryParam("minReplies", equalTo("34"))
                .withQueryParam("minRetweets", equalTo("35"))
                .withQueryParam("minViews", equalTo("36"))
                .withQueryParam("nativeRetweets", equalTo("true"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("pageSize", equalTo("39"))
                .withQueryParam("quotesOfTweetId", equalTo("quotesOfTweetId-sample"))
                .withQueryParam("retweetsOfTweetId", equalTo("retweetsOfTweetId-sample"))
                .withQueryParam("sinceId", equalTo("sinceId-sample"))
                .withQueryParam("toUser", equalTo("toUser-sample"))
                .withQueryParam("url", equalTo("url-sample"))
                .withQueryParam("verifiedOnly", equalTo("true"))
                .withQueryParam("withinTime", equalTo("7d")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(true)
        assertThat(response.nextCursor())
            .isEqualTo("DAAHCgABHTK6Vr___-sLAAIAAAATMjEwMTc3MDE4NjE1NjA1Mjk1OQgAAwAAAAIAAA")
        assertThat(response.tweets()).hasSize(2)
        assertThat(response.tweets()[0].id()).isEqualTo("2102761519985332442")
        assertThat(response.tweets()[0].bookmarkCount()).isEqualTo(599L)
        assertThat(response.tweets()[0].likeCount()).isEqualTo(9775L)
        assertThat(response.tweets()[0].quoteCount()).isEqualTo(85L)
        assertThat(response.tweets()[0].replyCount()).isEqualTo(271L)
        assertThat(response.tweets()[0].retweetCount()).isEqualTo(1364L)
        assertThat(response.tweets()[0].text())
            .isEqualTo(
                "This galaxy is a little extra.\n\nMeet Messier 106, a spiral galaxy with an extra set of arms. These two additional arms are made of gas heated up by jets from the galaxy’s central black hole. The jets’ superheated shockwaves are depicted in royal blue by @chandraxray. https://t.co/421Lzs0r0c"
            )
        assertThat(response.tweets()[0].viewCount()).isEqualTo(962488L)
        assertThat(response.tweets()[0].author().get().id()).isEqualTo("11348282")
        assertThat(response.tweets()[0].author().get().name()).isEqualTo("NASA")
        assertThat(response.tweets()[0].author().get().username()).isEqualTo("NASA")
        assertThat(response.tweets()[0].author().get().coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/11348282/1788992290")
        assertThat(response.tweets()[0].author().get().createdAt())
            .contains("Wed Dec 19 20:20:32 +0000 2007")
        assertThat(response.tweets()[0].author().get().description())
            .contains("Making the seemingly impossible, possible. ✨")
        assertThat(response.tweets()[0].author().get().favouritesCount()).contains(17003L)
        assertThat(response.tweets()[0].author().get().followers()).contains(92376233L)
        assertThat(response.tweets()[0].author().get().following()).contains(115L)
        assertThat(response.tweets()[0].author().get().hasGraduatedAccess()).contains(true)
        assertThat(response.tweets()[0].author().get().isBlueVerified()).contains(true)
        assertThat(response.tweets()[0].author().get().isTranslator()).contains(false)
        assertThat(response.tweets()[0].author().get().isVerified()).contains(true)
        assertThat(response.tweets()[0].author().get().location()).contains("Pale Blue Dot")
        assertThat(response.tweets()[0].author().get().mediaCount()).contains(28160L)
        assertThat(response.tweets()[0].author().get().parodyCommentaryFanLabel()).contains("None")
        assertThat(response.tweets()[0].author().get().possiblySensitive()).contains(false)
        assertThat(response.tweets()[0].author().get().profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/11348282/1788992290")
        assertThat(response.tweets()[0].author().get().profileDescriptionLanguage()).contains("en")
        assertThat(response.tweets()[0].author().get().profileImageShape()).contains("Square")
        assertThat(response.tweets()[0].author().get().profilePicture())
            .contains(
                "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_normal.jpg"
            )
        assertThat(response.tweets()[0].author().get().profileTranslatorType()).contains("regular")
        assertThat(response.tweets()[0].author().get().protected_()).contains(false)
        assertThat(response.tweets()[0].author().get().statusesCount()).contains(74336L)
        assertThat(response.tweets()[0].author().get().superFollowEligible()).contains(false)
        assertThat(response.tweets()[0].author().get().url()).contains("http://www.nasa.gov/")
        assertThat(response.tweets()[0].author().get().verified()).contains(true)
        assertThat(response.tweets()[0].author().get().verifiedType()).contains("Government")
        assertThat(response.tweets()[0].author().get()._additionalProperties()).isEmpty()
        assertThat(
                response
                    .tweets()[0]
                    .contentDisclosure()
                    .get()
                    .aiGenerated()
                    .get()
                    .hasAiGeneratedMedia()
            )
            .contains(false)
        assertThat(
                response
                    .tweets()[0]
                    .contentDisclosure()
                    .get()
                    .aiGenerated()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[0].contentDisclosure().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[0].conversationId()).contains("2102761519985332442")
        assertThat(response.tweets()[0].createdAt()).contains("Wed Sep 23 14:06:28 +0000 2026")
        assertThat(response.tweets()[0].displayTextRange().get()).containsExactly(0L, 267L)
        assertThat(response.tweets()[0].edit().get().editableUntilMsecs()).contains("1790175988000")
        assertThat(response.tweets()[0].edit().get().editTweetIds().get())
            .containsExactly("2102761519985332442")
        assertThat(response.tweets()[0].edit().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[0].entities().get().hashtags().get()).hasSize(1)
        assertThat(response.tweets()[0].entities().get().hashtags().get()[0].text())
            .isEqualTo("string")
        assertThat(response.tweets()[0].entities().get().hashtags().get()[0].indices().get())
            .containsExactly(1L)
        assertThat(response.tweets()[0].entities().get().hashtags().get()[0].tag().get().id())
            .contains("U21hcnRUYWc6VFNMQQ==")
        assertThat(
                response
                    .tweets()[0]
                    .entities()
                    .get()
                    .hashtags()
                    .get()[0]
                    .tag()
                    .get()
                    .info()
                    .get()
                    .info()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                response
                    .tweets()[0]
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
                response
                    .tweets()[0]
                    .entities()
                    .get()
                    .hashtags()
                    .get()[0]
                    .tag()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                response.tweets()[0].entities().get().hashtags().get()[0]._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[0].entities().get().urls().get()).hasSize(1)
        assertThat(response.tweets()[0].entities().get().urls().get()[0].displayUrl())
            .contains("string")
        assertThat(response.tweets()[0].entities().get().urls().get()[0].expandedUrl())
            .contains("string")
        assertThat(response.tweets()[0].entities().get().urls().get()[0].indices().get())
            .containsExactly(1L)
        assertThat(response.tweets()[0].entities().get().urls().get()[0].url()).contains("string")
        assertThat(response.tweets()[0].entities().get().urls().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(response.tweets()[0].entities().get().userMentions().get()).hasSize(1)
        assertThat(response.tweets()[0].entities().get().userMentions().get()[0].screenName())
            .isEqualTo("chandraxray")
        assertThat(response.tweets()[0].entities().get().userMentions().get()[0].idStr())
            .contains("12415722")
        assertThat(response.tweets()[0].entities().get().userMentions().get()[0].indices().get())
            .containsExactly(254L, 266L)
        assertThat(response.tweets()[0].entities().get().userMentions().get()[0].name())
            .contains("Chandra Observatory")
        assertThat(
                response
                    .tweets()[0]
                    .entities()
                    .get()
                    .userMentions()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[0].entities().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[0].isNoteTweet()).contains(false)
        assertThat(response.tweets()[0].isPinned()).contains(false)
        assertThat(response.tweets()[0].isQuoteStatus()).contains(false)
        assertThat(response.tweets()[0].isReply()).contains(false)
        assertThat(response.tweets()[0].isRetweet()).contains(false)
        assertThat(response.tweets()[0].isTranslatable()).contains(false)
        assertThat(response.tweets()[0].lang()).contains("en")
        assertThat(response.tweets()[0].media().get()).hasSize(1)
        assertThat(response.tweets()[0].media().get()[0].mediaUrl())
            .isEqualTo("https://pbs.twimg.com/media/HS6CdTYWkAAp0e1.jpg")
        assertThat(response.tweets()[0].media().get()[0].type()).isEqualTo(TweetMedia.Type.PHOTO)
        assertThat(response.tweets()[0].media().get()[0].url()).isEqualTo("https://t.co/421Lzs0r0c")
        assertThat(response.tweets()[0].media().get()[0].id()).contains("2102761515958833152")
        assertThat(response.tweets()[0].media().get()[0].altText())
            .contains(
                "A spiral galaxy, laying diagonally at a three-quarters profile view. Its center is a luminous yellow that stretches out into a pinwheel of wispy blue and red arms. The disc itself is decorated with a smattering of stars and dark dust."
            )
        assertThat(response.tweets()[0].media().get()[0].availabilityStatus()).contains("Available")
        assertThat(response.tweets()[0].media().get()[0].displayUrl())
            .contains("pic.x.com/421Lzs0r0c")
        assertThat(response.tweets()[0].media().get()[0].expandedUrl())
            .contains("https://x.com/NASA/status/2102761519985332442/photo/1")
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()).hasSize(5)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[0].h()).isEqualTo(1146L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[0].w()).isEqualTo(2047L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[0].x()).isEqualTo(0L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[0].y()).isEqualTo(419L)
        assertThat(
                response.tweets()[0].media().get()[0].focusRects().get()[0]._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[1].h()).isEqualTo(1565L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[1].w()).isEqualTo(1565L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[1].x()).isEqualTo(0L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[1].y()).isEqualTo(0L)
        assertThat(
                response.tweets()[0].media().get()[0].focusRects().get()[1]._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[2].h()).isEqualTo(1565L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[2].w()).isEqualTo(1373L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[2].x()).isEqualTo(0L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[2].y()).isEqualTo(0L)
        assertThat(
                response.tweets()[0].media().get()[0].focusRects().get()[2]._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[0].media().get()[0].height()).contains(1565L)
        assertThat(response.tweets()[0].media().get()[0].indices().get())
            .containsExactly(268L, 291L)
        assertThat(response.tweets()[0].media().get()[0].mediaKey())
            .contains("3_2102761515958833152")
        assertThat(response.tweets()[0].media().get()[0].width()).contains(2047L)
        assertThat(response.tweets()[0].media().get()[0]._additionalProperties()).isEmpty()
        assertThat(response.tweets()[0].possiblySensitive()).contains(false)
        assertThat(response.tweets()[0].source())
            .contains("<a href=\"https://www.sprinklr.com\" rel=\"nofollow\">Sprinklr</a>")
        assertThat(response.tweets()[0].type()).contains("tweet")
        assertThat(response.tweets()[0].url())
            .contains("https://x.com/NASA/status/2102761519985332442")
        assertThat(response.tweets()[0].viewState()).contains("EnabledWithCount")
        assertThat(response.tweets()[0]._additionalProperties()).isEmpty()
        assertThat(response.tweets()[1].id()).isEqualTo("2102425682286412261")
        assertThat(response.tweets()[1].bookmarkCount()).isEqualTo(322L)
        assertThat(response.tweets()[1].likeCount()).isEqualTo(7566L)
        assertThat(response.tweets()[1].quoteCount()).isEqualTo(98L)
        assertThat(response.tweets()[1].replyCount()).isEqualTo(200L)
        assertThat(response.tweets()[1].retweetCount()).isEqualTo(1258L)
        assertThat(response.tweets()[1].text())
            .isEqualTo(
                "Sept. 22 marks the fall equinox. That means day and night are nearly equal in length around the world, and in the Northern Hemisphere, fall begins. In the Southern Hemisphere, spring begins on this day. https://t.co/laEQ0JajuN"
            )
        assertThat(response.tweets()[1].viewCount()).isEqualTo(961825L)
        assertThat(response.tweets()[1].author().get().id()).isEqualTo("11348282")
        assertThat(response.tweets()[1].author().get().name()).isEqualTo("NASA")
        assertThat(response.tweets()[1].author().get().username()).isEqualTo("NASA")
        assertThat(response.tweets()[1].author().get().coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/11348282/1788992290")
        assertThat(response.tweets()[1].author().get().createdAt())
            .contains("Wed Dec 19 20:20:32 +0000 2007")
        assertThat(response.tweets()[1].author().get().description())
            .contains("Making the seemingly impossible, possible. ✨")
        assertThat(response.tweets()[1].author().get().favouritesCount()).contains(17003L)
        assertThat(response.tweets()[1].author().get().followers()).contains(92376233L)
        assertThat(response.tweets()[1].author().get().following()).contains(115L)
        assertThat(response.tweets()[1].author().get().hasGraduatedAccess()).contains(true)
        assertThat(response.tweets()[1].author().get().isBlueVerified()).contains(true)
        assertThat(response.tweets()[1].author().get().isTranslator()).contains(false)
        assertThat(response.tweets()[1].author().get().isVerified()).contains(true)
        assertThat(response.tweets()[1].author().get().location()).contains("Pale Blue Dot")
        assertThat(response.tweets()[1].author().get().mediaCount()).contains(28160L)
        assertThat(response.tweets()[1].author().get().parodyCommentaryFanLabel()).contains("None")
        assertThat(response.tweets()[1].author().get().possiblySensitive()).contains(false)
        assertThat(response.tweets()[1].author().get().profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/11348282/1788992290")
        assertThat(response.tweets()[1].author().get().profileDescriptionLanguage()).contains("en")
        assertThat(response.tweets()[1].author().get().profileImageShape()).contains("Square")
        assertThat(response.tweets()[1].author().get().profilePicture())
            .contains(
                "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_normal.jpg"
            )
        assertThat(response.tweets()[1].author().get().profileTranslatorType()).contains("regular")
        assertThat(response.tweets()[1].author().get().protected_()).contains(false)
        assertThat(response.tweets()[1].author().get().statusesCount()).contains(74336L)
        assertThat(response.tweets()[1].author().get().superFollowEligible()).contains(false)
        assertThat(response.tweets()[1].author().get().url()).contains("http://www.nasa.gov/")
        assertThat(response.tweets()[1].author().get().verified()).contains(true)
        assertThat(response.tweets()[1].author().get().verifiedType()).contains("Government")
        assertThat(response.tweets()[1].author().get()._additionalProperties()).isEmpty()
        assertThat(
                response
                    .tweets()[1]
                    .contentDisclosure()
                    .get()
                    .aiGenerated()
                    .get()
                    .hasAiGeneratedMedia()
            )
            .contains(false)
        assertThat(
                response
                    .tweets()[1]
                    .contentDisclosure()
                    .get()
                    .aiGenerated()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[1].contentDisclosure().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[1].conversationId()).contains("2102425682286412261")
        assertThat(response.tweets()[1].createdAt()).contains("Tue Sep 22 15:51:58 +0000 2026")
        assertThat(response.tweets()[1].displayTextRange().get()).containsExactly(0L, 202L)
        assertThat(response.tweets()[1].edit().get().editableUntilMsecs()).contains("1790095918000")
        assertThat(response.tweets()[1].edit().get().editTweetIds().get())
            .containsExactly("2102425682286412261")
        assertThat(response.tweets()[1].edit().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[1].entities().get().hashtags().get()).hasSize(1)
        assertThat(response.tweets()[1].entities().get().hashtags().get()[0].text())
            .isEqualTo("string")
        assertThat(response.tweets()[1].entities().get().hashtags().get()[0].indices().get())
            .containsExactly(1L)
        assertThat(response.tweets()[1].entities().get().hashtags().get()[0].tag().get().id())
            .contains("U21hcnRUYWc6VFNMQQ==")
        assertThat(
                response
                    .tweets()[1]
                    .entities()
                    .get()
                    .hashtags()
                    .get()[0]
                    .tag()
                    .get()
                    .info()
                    .get()
                    .info()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                response
                    .tweets()[1]
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
                response
                    .tweets()[1]
                    .entities()
                    .get()
                    .hashtags()
                    .get()[0]
                    .tag()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                response.tweets()[1].entities().get().hashtags().get()[0]._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[1].entities().get().urls().get()).hasSize(1)
        assertThat(response.tweets()[1].entities().get().urls().get()[0].displayUrl())
            .contains("string")
        assertThat(response.tweets()[1].entities().get().urls().get()[0].expandedUrl())
            .contains("string")
        assertThat(response.tweets()[1].entities().get().urls().get()[0].indices().get())
            .containsExactly(1L)
        assertThat(response.tweets()[1].entities().get().urls().get()[0].url()).contains("string")
        assertThat(response.tweets()[1].entities().get().urls().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(response.tweets()[1].entities().get().userMentions().get()).hasSize(1)
        assertThat(response.tweets()[1].entities().get().userMentions().get()[0].screenName())
            .isEqualTo("string")
        assertThat(response.tweets()[1].entities().get().userMentions().get()[0].idStr())
            .contains("string")
        assertThat(response.tweets()[1].entities().get().userMentions().get()[0].indices().get())
            .containsExactly(1L)
        assertThat(response.tweets()[1].entities().get().userMentions().get()[0].name())
            .contains("string")
        assertThat(
                response
                    .tweets()[1]
                    .entities()
                    .get()
                    .userMentions()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[1].entities().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[1].isNoteTweet()).contains(false)
        assertThat(response.tweets()[1].isPinned()).contains(false)
        assertThat(response.tweets()[1].isQuoteStatus()).contains(false)
        assertThat(response.tweets()[1].isReply()).contains(false)
        assertThat(response.tweets()[1].isRetweet()).contains(false)
        assertThat(response.tweets()[1].isTranslatable()).contains(false)
        assertThat(response.tweets()[1].lang()).contains("en")
        assertThat(response.tweets()[1].media().get()).hasSize(1)
        assertThat(response.tweets()[1].media().get()[0].mediaUrl())
            .isEqualTo("https://pbs.twimg.com/media/HS1RAkdW8AAY1Mp.jpg")
        assertThat(response.tweets()[1].media().get()[0].type()).isEqualTo(TweetMedia.Type.PHOTO)
        assertThat(response.tweets()[1].media().get()[0].url()).isEqualTo("https://t.co/laEQ0JajuN")
        assertThat(response.tweets()[1].media().get()[0].id()).contains("2102425671280553984")
        assertThat(response.tweets()[1].media().get()[0].altText())
            .contains(
                "A satellite's-eye view from October 2022 of the Adirondack Mountains of northeast New York during fall. The leaves on trees are a fiery orange and red. Some trees remain green. White fluffy clouds are visible at the edges of the image."
            )
        assertThat(response.tweets()[1].media().get()[0].availabilityStatus()).contains("Available")
        assertThat(response.tweets()[1].media().get()[0].displayUrl())
            .contains("pic.x.com/laEQ0JajuN")
        assertThat(response.tweets()[1].media().get()[0].expandedUrl())
            .contains("https://x.com/NASA/status/2102425682286412261/photo/1")
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()).hasSize(5)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[0].h()).isEqualTo(1801L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[0].w()).isEqualTo(3216L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[0].x()).isEqualTo(0L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[0].y()).isEqualTo(1187L)
        assertThat(
                response.tweets()[1].media().get()[0].focusRects().get()[0]._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[1].h()).isEqualTo(2988L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[1].w()).isEqualTo(2988L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[1].x()).isEqualTo(0L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[1].y()).isEqualTo(0L)
        assertThat(
                response.tweets()[1].media().get()[0].focusRects().get()[1]._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[2].h()).isEqualTo(2988L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[2].w()).isEqualTo(2621L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[2].x()).isEqualTo(0L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[2].y()).isEqualTo(0L)
        assertThat(
                response.tweets()[1].media().get()[0].focusRects().get()[2]._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[1].media().get()[0].height()).contains(2988L)
        assertThat(response.tweets()[1].media().get()[0].indices().get())
            .containsExactly(203L, 226L)
        assertThat(response.tweets()[1].media().get()[0].mediaKey())
            .contains("3_2102425671280553984")
        assertThat(response.tweets()[1].media().get()[0].width()).contains(3216L)
        assertThat(response.tweets()[1].media().get()[0]._additionalProperties()).isEmpty()
        assertThat(response.tweets()[1].possiblySensitive()).contains(false)
        assertThat(response.tweets()[1].source())
            .contains("<a href=\"https://www.sprinklr.com\" rel=\"nofollow\">Sprinklr</a>")
        assertThat(response.tweets()[1].type()).contains("tweet")
        assertThat(response.tweets()[1].url())
            .contains("https://x.com/NASA/status/2102425682286412261")
        assertThat(response.tweets()[1].viewState()).contains("EnabledWithCount")
        assertThat(response.tweets()[1]._additionalProperties()).isEmpty()
        assertThat(response.filteredCount()).contains(0L)
        assertThat(response._additionalProperties()).isEmpty()
    }

    @Test
    fun listByCommunityParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/communities/1500000000000000000/tweets"))
                .willReturn(okJson(paginatedTweetsExample))
        )
        val params =
            TweetListByCommunityParams.builder()
                .id("1500000000000000000")
                .anyWords("anyWords-sample")
                .blueVerifiedOnly(true)
                .cashtags("cashtags-sample")
                .conversationId("conversationId-sample")
                .cursor("cursor-sample")
                .exactPhrase("exactPhrase-sample")
                .excludeWords("excludeWords-sample")
                .fields("id,text,author.username")
                .fromUser("fromUser-sample")
                .hashtags("hashtags-sample")
                .inReplyToTweetId("inReplyToTweetId-sample")
                .language("language-sample")
                .maxFaves(22L)
                .maxId("maxId-sample")
                .maxQuotes(24L)
                .maxReplies(25L)
                .maxRetweets(26L)
                .mentioning("mentioning-sample")
                .minBookmarks(29L)
                .minLikes(30L)
                .minQuotes(31L)
                .minReplies(32L)
                .minRetweets(33L)
                .minViews(34L)
                .nativeRetweets(true)
                .omit("entities,media")
                .pageSize(37L)
                .quotesOfTweetId("quotesOfTweetId-sample")
                .retweetsOfTweetId("retweetsOfTweetId-sample")
                .sinceId("sinceId-sample")
                .toUser("toUser-sample")
                .url("url-sample")
                .verifiedOnly(true)
                .withinTime("7d")
                .build()

        val response = client.x().communities().tweets().listByCommunity(params)
        val asyncResponse = asyncClient.x().communities().tweets().listByCommunity(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/communities/1500000000000000000/tweets"))
                .withQueryParam("anyWords", equalTo("anyWords-sample"))
                .withQueryParam("blueVerifiedOnly", equalTo("true"))
                .withQueryParam("cashtags", equalTo("cashtags-sample"))
                .withQueryParam("conversationId", equalTo("conversationId-sample"))
                .withQueryParam("cursor", equalTo("cursor-sample"))
                .withQueryParam("exactPhrase", equalTo("exactPhrase-sample"))
                .withQueryParam("excludeWords", equalTo("excludeWords-sample"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("fromUser", equalTo("fromUser-sample"))
                .withQueryParam("hashtags", equalTo("hashtags-sample"))
                .withQueryParam("inReplyToTweetId", equalTo("inReplyToTweetId-sample"))
                .withQueryParam("language", equalTo("language-sample"))
                .withQueryParam("maxFaves", equalTo("22"))
                .withQueryParam("maxId", equalTo("maxId-sample"))
                .withQueryParam("maxQuotes", equalTo("24"))
                .withQueryParam("maxReplies", equalTo("25"))
                .withQueryParam("maxRetweets", equalTo("26"))
                .withQueryParam("mentioning", equalTo("mentioning-sample"))
                .withQueryParam("minBookmarks", equalTo("29"))
                .withQueryParam("minLikes", equalTo("30"))
                .withQueryParam("minQuotes", equalTo("31"))
                .withQueryParam("minReplies", equalTo("32"))
                .withQueryParam("minRetweets", equalTo("33"))
                .withQueryParam("minViews", equalTo("34"))
                .withQueryParam("nativeRetweets", equalTo("true"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("pageSize", equalTo("37"))
                .withQueryParam("quotesOfTweetId", equalTo("quotesOfTweetId-sample"))
                .withQueryParam("retweetsOfTweetId", equalTo("retweetsOfTweetId-sample"))
                .withQueryParam("sinceId", equalTo("sinceId-sample"))
                .withQueryParam("toUser", equalTo("toUser-sample"))
                .withQueryParam("url", equalTo("url-sample"))
                .withQueryParam("verifiedOnly", equalTo("true"))
                .withQueryParam("withinTime", equalTo("7d")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(true)
        assertThat(response.nextCursor())
            .isEqualTo("DAAHCgABHTK6Vr___-sLAAIAAAATMjEwMTc3MDE4NjE1NjA1Mjk1OQgAAwAAAAIAAA")
        assertThat(response.tweets()).hasSize(2)
        assertThat(response.tweets()[0].id()).isEqualTo("2102761519985332442")
        assertThat(response.tweets()[0].bookmarkCount()).isEqualTo(599L)
        assertThat(response.tweets()[0].likeCount()).isEqualTo(9775L)
        assertThat(response.tweets()[0].quoteCount()).isEqualTo(85L)
        assertThat(response.tweets()[0].replyCount()).isEqualTo(271L)
        assertThat(response.tweets()[0].retweetCount()).isEqualTo(1364L)
        assertThat(response.tweets()[0].text())
            .isEqualTo(
                "This galaxy is a little extra.\n\nMeet Messier 106, a spiral galaxy with an extra set of arms. These two additional arms are made of gas heated up by jets from the galaxy’s central black hole. The jets’ superheated shockwaves are depicted in royal blue by @chandraxray. https://t.co/421Lzs0r0c"
            )
        assertThat(response.tweets()[0].viewCount()).isEqualTo(962488L)
        assertThat(response.tweets()[0].author().get().id()).isEqualTo("11348282")
        assertThat(response.tweets()[0].author().get().name()).isEqualTo("NASA")
        assertThat(response.tweets()[0].author().get().username()).isEqualTo("NASA")
        assertThat(response.tweets()[0].author().get().coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/11348282/1788992290")
        assertThat(response.tweets()[0].author().get().createdAt())
            .contains("Wed Dec 19 20:20:32 +0000 2007")
        assertThat(response.tweets()[0].author().get().description())
            .contains("Making the seemingly impossible, possible. ✨")
        assertThat(response.tweets()[0].author().get().favouritesCount()).contains(17003L)
        assertThat(response.tweets()[0].author().get().followers()).contains(92376233L)
        assertThat(response.tweets()[0].author().get().following()).contains(115L)
        assertThat(response.tweets()[0].author().get().hasGraduatedAccess()).contains(true)
        assertThat(response.tweets()[0].author().get().isBlueVerified()).contains(true)
        assertThat(response.tweets()[0].author().get().isTranslator()).contains(false)
        assertThat(response.tweets()[0].author().get().isVerified()).contains(true)
        assertThat(response.tweets()[0].author().get().location()).contains("Pale Blue Dot")
        assertThat(response.tweets()[0].author().get().mediaCount()).contains(28160L)
        assertThat(response.tweets()[0].author().get().parodyCommentaryFanLabel()).contains("None")
        assertThat(response.tweets()[0].author().get().possiblySensitive()).contains(false)
        assertThat(response.tweets()[0].author().get().profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/11348282/1788992290")
        assertThat(response.tweets()[0].author().get().profileDescriptionLanguage()).contains("en")
        assertThat(response.tweets()[0].author().get().profileImageShape()).contains("Square")
        assertThat(response.tweets()[0].author().get().profilePicture())
            .contains(
                "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_normal.jpg"
            )
        assertThat(response.tweets()[0].author().get().profileTranslatorType()).contains("regular")
        assertThat(response.tweets()[0].author().get().protected_()).contains(false)
        assertThat(response.tweets()[0].author().get().statusesCount()).contains(74336L)
        assertThat(response.tweets()[0].author().get().superFollowEligible()).contains(false)
        assertThat(response.tweets()[0].author().get().url()).contains("http://www.nasa.gov/")
        assertThat(response.tweets()[0].author().get().verified()).contains(true)
        assertThat(response.tweets()[0].author().get().verifiedType()).contains("Government")
        assertThat(response.tweets()[0].author().get()._additionalProperties()).isEmpty()
        assertThat(
                response
                    .tweets()[0]
                    .contentDisclosure()
                    .get()
                    .aiGenerated()
                    .get()
                    .hasAiGeneratedMedia()
            )
            .contains(false)
        assertThat(
                response
                    .tweets()[0]
                    .contentDisclosure()
                    .get()
                    .aiGenerated()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[0].contentDisclosure().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[0].conversationId()).contains("2102761519985332442")
        assertThat(response.tweets()[0].createdAt()).contains("Wed Sep 23 14:06:28 +0000 2026")
        assertThat(response.tweets()[0].displayTextRange().get()).containsExactly(0L, 267L)
        assertThat(response.tweets()[0].edit().get().editableUntilMsecs()).contains("1790175988000")
        assertThat(response.tweets()[0].edit().get().editTweetIds().get())
            .containsExactly("2102761519985332442")
        assertThat(response.tweets()[0].edit().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[0].entities().get().hashtags().get()).hasSize(1)
        assertThat(response.tweets()[0].entities().get().hashtags().get()[0].text())
            .isEqualTo("string")
        assertThat(response.tweets()[0].entities().get().hashtags().get()[0].indices().get())
            .containsExactly(1L)
        assertThat(response.tweets()[0].entities().get().hashtags().get()[0].tag().get().id())
            .contains("U21hcnRUYWc6VFNMQQ==")
        assertThat(
                response
                    .tweets()[0]
                    .entities()
                    .get()
                    .hashtags()
                    .get()[0]
                    .tag()
                    .get()
                    .info()
                    .get()
                    .info()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                response
                    .tweets()[0]
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
                response
                    .tweets()[0]
                    .entities()
                    .get()
                    .hashtags()
                    .get()[0]
                    .tag()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                response.tweets()[0].entities().get().hashtags().get()[0]._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[0].entities().get().urls().get()).hasSize(1)
        assertThat(response.tweets()[0].entities().get().urls().get()[0].displayUrl())
            .contains("string")
        assertThat(response.tweets()[0].entities().get().urls().get()[0].expandedUrl())
            .contains("string")
        assertThat(response.tweets()[0].entities().get().urls().get()[0].indices().get())
            .containsExactly(1L)
        assertThat(response.tweets()[0].entities().get().urls().get()[0].url()).contains("string")
        assertThat(response.tweets()[0].entities().get().urls().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(response.tweets()[0].entities().get().userMentions().get()).hasSize(1)
        assertThat(response.tweets()[0].entities().get().userMentions().get()[0].screenName())
            .isEqualTo("chandraxray")
        assertThat(response.tweets()[0].entities().get().userMentions().get()[0].idStr())
            .contains("12415722")
        assertThat(response.tweets()[0].entities().get().userMentions().get()[0].indices().get())
            .containsExactly(254L, 266L)
        assertThat(response.tweets()[0].entities().get().userMentions().get()[0].name())
            .contains("Chandra Observatory")
        assertThat(
                response
                    .tweets()[0]
                    .entities()
                    .get()
                    .userMentions()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[0].entities().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[0].isNoteTweet()).contains(false)
        assertThat(response.tweets()[0].isPinned()).contains(false)
        assertThat(response.tweets()[0].isQuoteStatus()).contains(false)
        assertThat(response.tweets()[0].isReply()).contains(false)
        assertThat(response.tweets()[0].isRetweet()).contains(false)
        assertThat(response.tweets()[0].isTranslatable()).contains(false)
        assertThat(response.tweets()[0].lang()).contains("en")
        assertThat(response.tweets()[0].media().get()).hasSize(1)
        assertThat(response.tweets()[0].media().get()[0].mediaUrl())
            .isEqualTo("https://pbs.twimg.com/media/HS6CdTYWkAAp0e1.jpg")
        assertThat(response.tweets()[0].media().get()[0].type()).isEqualTo(TweetMedia.Type.PHOTO)
        assertThat(response.tweets()[0].media().get()[0].url()).isEqualTo("https://t.co/421Lzs0r0c")
        assertThat(response.tweets()[0].media().get()[0].id()).contains("2102761515958833152")
        assertThat(response.tweets()[0].media().get()[0].altText())
            .contains(
                "A spiral galaxy, laying diagonally at a three-quarters profile view. Its center is a luminous yellow that stretches out into a pinwheel of wispy blue and red arms. The disc itself is decorated with a smattering of stars and dark dust."
            )
        assertThat(response.tweets()[0].media().get()[0].availabilityStatus()).contains("Available")
        assertThat(response.tweets()[0].media().get()[0].displayUrl())
            .contains("pic.x.com/421Lzs0r0c")
        assertThat(response.tweets()[0].media().get()[0].expandedUrl())
            .contains("https://x.com/NASA/status/2102761519985332442/photo/1")
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()).hasSize(5)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[0].h()).isEqualTo(1146L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[0].w()).isEqualTo(2047L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[0].x()).isEqualTo(0L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[0].y()).isEqualTo(419L)
        assertThat(
                response.tweets()[0].media().get()[0].focusRects().get()[0]._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[1].h()).isEqualTo(1565L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[1].w()).isEqualTo(1565L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[1].x()).isEqualTo(0L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[1].y()).isEqualTo(0L)
        assertThat(
                response.tweets()[0].media().get()[0].focusRects().get()[1]._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[2].h()).isEqualTo(1565L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[2].w()).isEqualTo(1373L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[2].x()).isEqualTo(0L)
        assertThat(response.tweets()[0].media().get()[0].focusRects().get()[2].y()).isEqualTo(0L)
        assertThat(
                response.tweets()[0].media().get()[0].focusRects().get()[2]._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[0].media().get()[0].height()).contains(1565L)
        assertThat(response.tweets()[0].media().get()[0].indices().get())
            .containsExactly(268L, 291L)
        assertThat(response.tweets()[0].media().get()[0].mediaKey())
            .contains("3_2102761515958833152")
        assertThat(response.tweets()[0].media().get()[0].width()).contains(2047L)
        assertThat(response.tweets()[0].media().get()[0]._additionalProperties()).isEmpty()
        assertThat(response.tweets()[0].possiblySensitive()).contains(false)
        assertThat(response.tweets()[0].source())
            .contains("<a href=\"https://www.sprinklr.com\" rel=\"nofollow\">Sprinklr</a>")
        assertThat(response.tweets()[0].type()).contains("tweet")
        assertThat(response.tweets()[0].url())
            .contains("https://x.com/NASA/status/2102761519985332442")
        assertThat(response.tweets()[0].viewState()).contains("EnabledWithCount")
        assertThat(response.tweets()[0]._additionalProperties()).isEmpty()
        assertThat(response.tweets()[1].id()).isEqualTo("2102425682286412261")
        assertThat(response.tweets()[1].bookmarkCount()).isEqualTo(322L)
        assertThat(response.tweets()[1].likeCount()).isEqualTo(7566L)
        assertThat(response.tweets()[1].quoteCount()).isEqualTo(98L)
        assertThat(response.tweets()[1].replyCount()).isEqualTo(200L)
        assertThat(response.tweets()[1].retweetCount()).isEqualTo(1258L)
        assertThat(response.tweets()[1].text())
            .isEqualTo(
                "Sept. 22 marks the fall equinox. That means day and night are nearly equal in length around the world, and in the Northern Hemisphere, fall begins. In the Southern Hemisphere, spring begins on this day. https://t.co/laEQ0JajuN"
            )
        assertThat(response.tweets()[1].viewCount()).isEqualTo(961825L)
        assertThat(response.tweets()[1].author().get().id()).isEqualTo("11348282")
        assertThat(response.tweets()[1].author().get().name()).isEqualTo("NASA")
        assertThat(response.tweets()[1].author().get().username()).isEqualTo("NASA")
        assertThat(response.tweets()[1].author().get().coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/11348282/1788992290")
        assertThat(response.tweets()[1].author().get().createdAt())
            .contains("Wed Dec 19 20:20:32 +0000 2007")
        assertThat(response.tweets()[1].author().get().description())
            .contains("Making the seemingly impossible, possible. ✨")
        assertThat(response.tweets()[1].author().get().favouritesCount()).contains(17003L)
        assertThat(response.tweets()[1].author().get().followers()).contains(92376233L)
        assertThat(response.tweets()[1].author().get().following()).contains(115L)
        assertThat(response.tweets()[1].author().get().hasGraduatedAccess()).contains(true)
        assertThat(response.tweets()[1].author().get().isBlueVerified()).contains(true)
        assertThat(response.tweets()[1].author().get().isTranslator()).contains(false)
        assertThat(response.tweets()[1].author().get().isVerified()).contains(true)
        assertThat(response.tweets()[1].author().get().location()).contains("Pale Blue Dot")
        assertThat(response.tweets()[1].author().get().mediaCount()).contains(28160L)
        assertThat(response.tweets()[1].author().get().parodyCommentaryFanLabel()).contains("None")
        assertThat(response.tweets()[1].author().get().possiblySensitive()).contains(false)
        assertThat(response.tweets()[1].author().get().profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/11348282/1788992290")
        assertThat(response.tweets()[1].author().get().profileDescriptionLanguage()).contains("en")
        assertThat(response.tweets()[1].author().get().profileImageShape()).contains("Square")
        assertThat(response.tweets()[1].author().get().profilePicture())
            .contains(
                "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_normal.jpg"
            )
        assertThat(response.tweets()[1].author().get().profileTranslatorType()).contains("regular")
        assertThat(response.tweets()[1].author().get().protected_()).contains(false)
        assertThat(response.tweets()[1].author().get().statusesCount()).contains(74336L)
        assertThat(response.tweets()[1].author().get().superFollowEligible()).contains(false)
        assertThat(response.tweets()[1].author().get().url()).contains("http://www.nasa.gov/")
        assertThat(response.tweets()[1].author().get().verified()).contains(true)
        assertThat(response.tweets()[1].author().get().verifiedType()).contains("Government")
        assertThat(response.tweets()[1].author().get()._additionalProperties()).isEmpty()
        assertThat(
                response
                    .tweets()[1]
                    .contentDisclosure()
                    .get()
                    .aiGenerated()
                    .get()
                    .hasAiGeneratedMedia()
            )
            .contains(false)
        assertThat(
                response
                    .tweets()[1]
                    .contentDisclosure()
                    .get()
                    .aiGenerated()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[1].contentDisclosure().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[1].conversationId()).contains("2102425682286412261")
        assertThat(response.tweets()[1].createdAt()).contains("Tue Sep 22 15:51:58 +0000 2026")
        assertThat(response.tweets()[1].displayTextRange().get()).containsExactly(0L, 202L)
        assertThat(response.tweets()[1].edit().get().editableUntilMsecs()).contains("1790095918000")
        assertThat(response.tweets()[1].edit().get().editTweetIds().get())
            .containsExactly("2102425682286412261")
        assertThat(response.tweets()[1].edit().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[1].entities().get().hashtags().get()).hasSize(1)
        assertThat(response.tweets()[1].entities().get().hashtags().get()[0].text())
            .isEqualTo("string")
        assertThat(response.tweets()[1].entities().get().hashtags().get()[0].indices().get())
            .containsExactly(1L)
        assertThat(response.tweets()[1].entities().get().hashtags().get()[0].tag().get().id())
            .contains("U21hcnRUYWc6VFNMQQ==")
        assertThat(
                response
                    .tweets()[1]
                    .entities()
                    .get()
                    .hashtags()
                    .get()[0]
                    .tag()
                    .get()
                    .info()
                    .get()
                    .info()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                response
                    .tweets()[1]
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
                response
                    .tweets()[1]
                    .entities()
                    .get()
                    .hashtags()
                    .get()[0]
                    .tag()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                response.tweets()[1].entities().get().hashtags().get()[0]._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[1].entities().get().urls().get()).hasSize(1)
        assertThat(response.tweets()[1].entities().get().urls().get()[0].displayUrl())
            .contains("string")
        assertThat(response.tweets()[1].entities().get().urls().get()[0].expandedUrl())
            .contains("string")
        assertThat(response.tweets()[1].entities().get().urls().get()[0].indices().get())
            .containsExactly(1L)
        assertThat(response.tweets()[1].entities().get().urls().get()[0].url()).contains("string")
        assertThat(response.tweets()[1].entities().get().urls().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(response.tweets()[1].entities().get().userMentions().get()).hasSize(1)
        assertThat(response.tweets()[1].entities().get().userMentions().get()[0].screenName())
            .isEqualTo("string")
        assertThat(response.tweets()[1].entities().get().userMentions().get()[0].idStr())
            .contains("string")
        assertThat(response.tweets()[1].entities().get().userMentions().get()[0].indices().get())
            .containsExactly(1L)
        assertThat(response.tweets()[1].entities().get().userMentions().get()[0].name())
            .contains("string")
        assertThat(
                response
                    .tweets()[1]
                    .entities()
                    .get()
                    .userMentions()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[1].entities().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[1].isNoteTweet()).contains(false)
        assertThat(response.tweets()[1].isPinned()).contains(false)
        assertThat(response.tweets()[1].isQuoteStatus()).contains(false)
        assertThat(response.tweets()[1].isReply()).contains(false)
        assertThat(response.tweets()[1].isRetweet()).contains(false)
        assertThat(response.tweets()[1].isTranslatable()).contains(false)
        assertThat(response.tweets()[1].lang()).contains("en")
        assertThat(response.tweets()[1].media().get()).hasSize(1)
        assertThat(response.tweets()[1].media().get()[0].mediaUrl())
            .isEqualTo("https://pbs.twimg.com/media/HS1RAkdW8AAY1Mp.jpg")
        assertThat(response.tweets()[1].media().get()[0].type()).isEqualTo(TweetMedia.Type.PHOTO)
        assertThat(response.tweets()[1].media().get()[0].url()).isEqualTo("https://t.co/laEQ0JajuN")
        assertThat(response.tweets()[1].media().get()[0].id()).contains("2102425671280553984")
        assertThat(response.tweets()[1].media().get()[0].altText())
            .contains(
                "A satellite's-eye view from October 2022 of the Adirondack Mountains of northeast New York during fall. The leaves on trees are a fiery orange and red. Some trees remain green. White fluffy clouds are visible at the edges of the image."
            )
        assertThat(response.tweets()[1].media().get()[0].availabilityStatus()).contains("Available")
        assertThat(response.tweets()[1].media().get()[0].displayUrl())
            .contains("pic.x.com/laEQ0JajuN")
        assertThat(response.tweets()[1].media().get()[0].expandedUrl())
            .contains("https://x.com/NASA/status/2102425682286412261/photo/1")
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()).hasSize(5)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[0].h()).isEqualTo(1801L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[0].w()).isEqualTo(3216L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[0].x()).isEqualTo(0L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[0].y()).isEqualTo(1187L)
        assertThat(
                response.tweets()[1].media().get()[0].focusRects().get()[0]._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[1].h()).isEqualTo(2988L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[1].w()).isEqualTo(2988L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[1].x()).isEqualTo(0L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[1].y()).isEqualTo(0L)
        assertThat(
                response.tweets()[1].media().get()[0].focusRects().get()[1]._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[2].h()).isEqualTo(2988L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[2].w()).isEqualTo(2621L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[2].x()).isEqualTo(0L)
        assertThat(response.tweets()[1].media().get()[0].focusRects().get()[2].y()).isEqualTo(0L)
        assertThat(
                response.tweets()[1].media().get()[0].focusRects().get()[2]._additionalProperties()
            )
            .isEmpty()
        assertThat(response.tweets()[1].media().get()[0].height()).contains(2988L)
        assertThat(response.tweets()[1].media().get()[0].indices().get())
            .containsExactly(203L, 226L)
        assertThat(response.tweets()[1].media().get()[0].mediaKey())
            .contains("3_2102425671280553984")
        assertThat(response.tweets()[1].media().get()[0].width()).contains(3216L)
        assertThat(response.tweets()[1].media().get()[0]._additionalProperties()).isEmpty()
        assertThat(response.tweets()[1].possiblySensitive()).contains(false)
        assertThat(response.tweets()[1].source())
            .contains("<a href=\"https://www.sprinklr.com\" rel=\"nofollow\">Sprinklr</a>")
        assertThat(response.tweets()[1].type()).contains("tweet")
        assertThat(response.tweets()[1].url())
            .contains("https://x.com/NASA/status/2102425682286412261")
        assertThat(response.tweets()[1].viewState()).contains("EnabledWithCount")
        assertThat(response.tweets()[1]._additionalProperties()).isEmpty()
        assertThat(response.filteredCount()).contains(0L)
        assertThat(response._additionalProperties()).isEmpty()
    }

    companion object {

        private val paginatedTweetsExample =
            """
            {
              "tweets": [
                {
                  "id": "2102761519985332442",
                  "text": "This galaxy is a little extra.\n\nMeet Messier 106, a spiral galaxy with an extra set of arms. These two additional arms are made of gas heated up by jets from the galaxy’s central black hole. The jets’ superheated shockwaves are depicted in royal blue by @chandraxray. https://t.co/421Lzs0r0c",
                  "retweetCount": 1364,
                  "replyCount": 271,
                  "likeCount": 9775,
                  "quoteCount": 85,
                  "viewCount": 962488,
                  "bookmarkCount": 599,
                  "conversationId": "2102761519985332442",
                  "contentDisclosure": {
                    "aiGenerated": {
                      "hasAiGeneratedMedia": false
                    }
                  },
                  "displayTextRange": [
                    0,
                    267
                  ],
                  "edit": {
                    "editableUntilMsecs": "1790175988000",
                    "editTweetIds": [
                      "2102761519985332442"
                    ]
                  },
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
                        "id_str": "12415722",
                        "indices": [
                          254,
                          266
                        ],
                        "name": "Chandra Observatory",
                        "screen_name": "chandraxray"
                      }
                    ]
                  },
                  "isNoteTweet": false,
                  "isPinned": false,
                  "isQuoteStatus": false,
                  "isReply": false,
                  "isRetweet": false,
                  "isTranslatable": false,
                  "lang": "en",
                  "possiblySensitive": false,
                  "source": "<a href=\"https://www.sprinklr.com\" rel=\"nofollow\">Sprinklr</a>",
                  "type": "tweet",
                  "url": "https://x.com/NASA/status/2102761519985332442",
                  "viewState": "EnabledWithCount",
                  "createdAt": "Wed Sep 23 14:06:28 +0000 2026",
                  "media": [
                    {
                      "altText": "A spiral galaxy, laying diagonally at a three-quarters profile view. Its center is a luminous yellow that stretches out into a pinwheel of wispy blue and red arms. The disc itself is decorated with a smattering of stars and dark dust.",
                      "availabilityStatus": "Available",
                      "displayUrl": "pic.x.com/421Lzs0r0c",
                      "expandedUrl": "https://x.com/NASA/status/2102761519985332442/photo/1",
                      "focusRects": [
                        {
                          "h": 1146,
                          "w": 2047,
                          "x": 0,
                          "y": 419
                        },
                        {
                          "h": 1565,
                          "w": 1565,
                          "x": 0,
                          "y": 0
                        },
                        {
                          "h": 1565,
                          "w": 1373,
                          "x": 0,
                          "y": 0
                        },
                        {
                          "h": 1565,
                          "w": 783,
                          "x": 0,
                          "y": 0
                        },
                        {
                          "h": 1565,
                          "w": 2047,
                          "x": 0,
                          "y": 0
                        }
                      ],
                      "height": 1565,
                      "id": "2102761515958833152",
                      "indices": [
                        268,
                        291
                      ],
                      "mediaKey": "3_2102761515958833152",
                      "mediaUrl": "https://pbs.twimg.com/media/HS6CdTYWkAAp0e1.jpg",
                      "sizes": {
                        "large": {
                          "h": 1565,
                          "resize": "fit",
                          "w": 2047
                        },
                        "medium": {
                          "h": 917,
                          "resize": "fit",
                          "w": 1200
                        },
                        "small": {
                          "h": 520,
                          "resize": "fit",
                          "w": 680
                        },
                        "thumb": {
                          "h": 150,
                          "resize": "crop",
                          "w": 150
                        }
                      },
                      "type": "photo",
                      "url": "https://t.co/421Lzs0r0c",
                      "width": 2047
                    }
                  ],
                  "author": {
                    "id": "11348282",
                    "username": "NASA",
                    "name": "NASA",
                    "followers": 92376233,
                    "following": 115,
                    "verified": true,
                    "isBlueVerified": true,
                    "isVerified": true,
                    "profilePicture": "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_normal.jpg",
                    "coverPicture": "https://pbs.twimg.com/profile_banners/11348282/1788992290",
                    "profileBannerUrl": "https://pbs.twimg.com/profile_banners/11348282/1788992290",
                    "description": "Making the seemingly impossible, possible. ✨",
                    "location": "Pale Blue Dot",
                    "createdAt": "Wed Dec 19 20:20:32 +0000 2007",
                    "statusesCount": 74336,
                    "mediaCount": 28160,
                    "protected": false,
                    "url": "http://www.nasa.gov/",
                    "favouritesCount": 17003,
                    "isTranslator": false,
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
                    "hasGraduatedAccess": true,
                    "parodyCommentaryFanLabel": "None",
                    "profileDescriptionLanguage": "en",
                    "profileImageShape": "Square",
                    "profileTranslatorType": "regular",
                    "superFollowEligible": false
                  }
                },
                {
                  "id": "2102425682286412261",
                  "text": "Sept. 22 marks the fall equinox. That means day and night are nearly equal in length around the world, and in the Northern Hemisphere, fall begins. In the Southern Hemisphere, spring begins on this day. https://t.co/laEQ0JajuN",
                  "retweetCount": 1258,
                  "replyCount": 200,
                  "likeCount": 7566,
                  "quoteCount": 98,
                  "viewCount": 961825,
                  "bookmarkCount": 322,
                  "conversationId": "2102425682286412261",
                  "contentDisclosure": {
                    "aiGenerated": {
                      "hasAiGeneratedMedia": false
                    }
                  },
                  "displayTextRange": [
                    0,
                    202
                  ],
                  "edit": {
                    "editableUntilMsecs": "1790095918000",
                    "editTweetIds": [
                      "2102425682286412261"
                    ]
                  },
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
                  "isNoteTweet": false,
                  "isPinned": false,
                  "isQuoteStatus": false,
                  "isReply": false,
                  "isRetweet": false,
                  "isTranslatable": false,
                  "lang": "en",
                  "possiblySensitive": false,
                  "source": "<a href=\"https://www.sprinklr.com\" rel=\"nofollow\">Sprinklr</a>",
                  "type": "tweet",
                  "url": "https://x.com/NASA/status/2102425682286412261",
                  "viewState": "EnabledWithCount",
                  "createdAt": "Tue Sep 22 15:51:58 +0000 2026",
                  "media": [
                    {
                      "altText": "A satellite's-eye view from October 2022 of the Adirondack Mountains of northeast New York during fall. The leaves on trees are a fiery orange and red. Some trees remain green. White fluffy clouds are visible at the edges of the image.",
                      "availabilityStatus": "Available",
                      "displayUrl": "pic.x.com/laEQ0JajuN",
                      "expandedUrl": "https://x.com/NASA/status/2102425682286412261/photo/1",
                      "focusRects": [
                        {
                          "h": 1801,
                          "w": 3216,
                          "x": 0,
                          "y": 1187
                        },
                        {
                          "h": 2988,
                          "w": 2988,
                          "x": 0,
                          "y": 0
                        },
                        {
                          "h": 2988,
                          "w": 2621,
                          "x": 0,
                          "y": 0
                        },
                        {
                          "h": 2988,
                          "w": 1494,
                          "x": 0,
                          "y": 0
                        },
                        {
                          "h": 2988,
                          "w": 3216,
                          "x": 0,
                          "y": 0
                        }
                      ],
                      "height": 2988,
                      "id": "2102425671280553984",
                      "indices": [
                        203,
                        226
                      ],
                      "mediaKey": "3_2102425671280553984",
                      "mediaUrl": "https://pbs.twimg.com/media/HS1RAkdW8AAY1Mp.jpg",
                      "sizes": {
                        "large": {
                          "h": 1903,
                          "resize": "fit",
                          "w": 2048
                        },
                        "medium": {
                          "h": 1115,
                          "resize": "fit",
                          "w": 1200
                        },
                        "small": {
                          "h": 632,
                          "resize": "fit",
                          "w": 680
                        },
                        "thumb": {
                          "h": 150,
                          "resize": "crop",
                          "w": 150
                        }
                      },
                      "type": "photo",
                      "url": "https://t.co/laEQ0JajuN",
                      "width": 3216
                    }
                  ],
                  "author": {
                    "id": "11348282",
                    "username": "NASA",
                    "name": "NASA",
                    "followers": 92376233,
                    "following": 115,
                    "verified": true,
                    "isBlueVerified": true,
                    "isVerified": true,
                    "profilePicture": "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_normal.jpg",
                    "coverPicture": "https://pbs.twimg.com/profile_banners/11348282/1788992290",
                    "profileBannerUrl": "https://pbs.twimg.com/profile_banners/11348282/1788992290",
                    "description": "Making the seemingly impossible, possible. ✨",
                    "location": "Pale Blue Dot",
                    "createdAt": "Wed Dec 19 20:20:32 +0000 2007",
                    "statusesCount": 74336,
                    "mediaCount": 28160,
                    "protected": false,
                    "url": "http://www.nasa.gov/",
                    "favouritesCount": 17003,
                    "isTranslator": false,
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
                    "hasGraduatedAccess": true,
                    "parodyCommentaryFanLabel": "None",
                    "profileDescriptionLanguage": "en",
                    "profileImageShape": "Square",
                    "profileTranslatorType": "regular",
                    "superFollowEligible": false
                  }
                }
              ],
              "has_next_page": true,
              "next_cursor": "DAAHCgABHTK6Vr___-sLAAIAAAATMjEwMTc3MDE4NjE1NjA1Mjk1OQgAAwAAAAIAAA",
              "filtered_count": 0
            }
            """
                .trimIndent()
    }
}
