// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

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
import com.x_twitter_scraper.api.models.UserProfile
import com.x_twitter_scraper.api.models.x.tweets.TweetCheckRepostParams
import com.x_twitter_scraper.api.models.x.tweets.TweetEmbedParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetFavoritersParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetHiddenRepliesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetInsightsParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetQuotesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRepliesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRetweeterIdsParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRetweetersParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetSubtitlesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetThreadParams
import com.x_twitter_scraper.api.models.x.tweets.TweetListParams
import com.x_twitter_scraper.api.models.x.tweets.TweetListTopParams
import com.x_twitter_scraper.api.models.x.tweets.TweetResolveLinksParams
import com.x_twitter_scraper.api.models.x.tweets.TweetRetrieveParams
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchParams
import com.x_twitter_scraper.api.models.x.tweets.TweetTranslateParams
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class TweetServiceSpecExampleTest {

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
    fun checkRepostParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/1234567890/retweeters/check"))
                .willReturn(
                    okJson(
                        """
                        {
                          "isRetweeted": true,
                          "retweetedAt": "2026-09-11T16:59:50.000Z",
                          "retweetId": "2098456494362460375",
                          "tweetId": "2098439298617856319",
                          "userId": "3065618342",
                          "checkedPosts": 20,
                          "complete": false
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            TweetCheckRepostParams.builder()
                .id("1234567890")
                .user("user")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().tweets().checkRepost(params)
        val asyncResponse = asyncClient.x().tweets().checkRepost(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/tweets/1234567890/retweeters/check"))
                .withQueryParam("user", equalTo("user"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.checkedPosts()).isEqualTo(20L)
        assertThat(response.complete()).isEqualTo(false)
        assertThat(response.isRetweeted()).isEqualTo(true)
        assertThat(response.retweetedAt()).contains("2026-09-11T16:59:50.000Z")
        assertThat(response.retweetId()).contains("2098456494362460375")
        assertThat(response.tweetId()).isEqualTo("2098439298617856319")
        assertThat(response.userId()).isEqualTo("3065618342")
    }

    @Test
    fun embedParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/1234567890/embed"))
                .willReturn(
                    okJson(
                        """
                        {
                          "embed": {
                            "tweetId": "2102882545427714266",
                            "url": "https://x.com/NASA/status/2102882545427714266",
                            "authorName": "NASA",
                            "authorUrl": "https://x.com/NASA",
                            "html": "<blockquote class=\"twitter-tweet\">...</blockquote>",
                            "width": 550
                          }
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            TweetEmbedParams.builder()
                .id("1234567890")
                .fields("id,text,author.username")
                .omit("entities,media")
                .theme(TweetEmbedParams.Theme.LIGHT)
                .build()

        val response = client.x().tweets().embed(params)
        val asyncResponse = asyncClient.x().tweets().embed(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/tweets/1234567890/embed"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("theme", equalTo("light")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.embed().authorName()).isEqualTo("NASA")
        assertThat(response.embed().authorUrl()).isEqualTo("https://x.com/NASA")
        assertThat(response.embed().html())
            .isEqualTo("<blockquote class=\"twitter-tweet\">...</blockquote>")
        assertThat(response.embed().tweetId()).isEqualTo("2102882545427714266")
        assertThat(response.embed().url())
            .isEqualTo("https://x.com/NASA/status/2102882545427714266")
        assertThat(response.embed().height()).isEmpty
        assertThat(response.embed().width()).contains(550L)
    }

    @Test
    fun getHiddenRepliesParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/1234567890/hidden-replies"))
                .willReturn(okJson(paginatedTweetsExample))
        )
        val params =
            TweetGetHiddenRepliesParams.builder()
                .id("1234567890")
                .fields("id,text,author.username")
                .mediaType(TweetGetHiddenRepliesParams.MediaType.IMAGES)
                .omit("entities,media")
                .quotes(TweetGetHiddenRepliesParams.Quotes.INCLUDE)
                .replies(TweetGetHiddenRepliesParams.Replies.INCLUDE)
                .retweets(TweetGetHiddenRepliesParams.Retweets.INCLUDE)
                .withinTime("7d")
                .build()

        val response = client.x().tweets().getHiddenReplies(params)
        val asyncResponse = asyncClient.x().tweets().getHiddenReplies(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/tweets/1234567890/hidden-replies"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("mediaType", equalTo("images"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("quotes", equalTo("include"))
                .withQueryParam("replies", equalTo("include"))
                .withQueryParam("retweets", equalTo("include"))
                .withQueryParam("withinTime", equalTo("7d")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(true)
        assertThat(response.nextCursor())
            .isEqualTo("DAAHCgABHTK6Vr___-sLAAIAAAATMjEwMTc3MDE4NjE1NjA1Mjk1OQgAAwAAAAIAAA")
        assertThat(response.tweets()).hasSize(2)
        assertThat(response.tweets()[0].id()).isEqualTo("2102761519985332442")
        assertThat(response.tweets()[0].text())
            .isEqualTo(
                "This galaxy is a little extra.\n\nMeet Messier 106, a spiral galaxy with an extra set of arms. These two additional arms are made of gas heated up by jets from the galaxy’s central black hole. The jets’ superheated shockwaves are depicted in royal blue by @chandraxray. https://t.co/421Lzs0r0c"
            )
    }

    @Test
    fun getInsightsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/1234567890/insights"))
                .willReturn(
                    okJson(
                        """
                        {
                          "insights": {
                            "tweetId": "2102882545427714266",
                            "authorId": "11348282",
                            "authorUserName": "NASA",
                            "createdAt": "2026-09-23T22:07:23.000Z",
                            "ageHours": 133.88,
                            "metrics": {
                              "likes": 9043,
                              "replies": 207,
                              "reposts": 772,
                              "quotes": 100,
                              "bookmarks": 661,
                              "views": 1291231
                            },
                            "engagements": 10122,
                            "engagementsPerHour": 75.605,
                            "engagementPerView": 0.7839,
                            "engagementRate": 0.011,
                            "amplification": 0.0964,
                            "conversation": 0.0229
                          }
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            TweetGetInsightsParams.builder()
                .id("1234567890")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().tweets().getInsights(params)
        val asyncResponse = asyncClient.x().tweets().getInsights(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/tweets/1234567890/insights"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.insights().ageHours()).contains(133.88)
        assertThat(response.insights().amplification()).contains(0.0964)
        assertThat(response.insights().authorId()).contains("11348282")
        assertThat(response.insights().authorUserName()).contains("NASA")
        assertThat(response.insights().conversation()).contains(0.0229)
        assertThat(response.insights().createdAt())
            .contains(OffsetDateTime.parse("2026-09-23T22:07:23.000Z"))
        assertThat(response.insights().engagementPerView()).contains(0.7839)
        assertThat(response.insights().engagementRate()).contains(0.011)
        assertThat(response.insights().engagements()).isEqualTo(10122.0)
        assertThat(response.insights().engagementsPerHour()).contains(75.605)
        assertThat(response.insights().metrics().bookmarks()).isEqualTo(661.0)
        assertThat(response.insights().metrics().likes()).isEqualTo(9043.0)
        assertThat(response.insights().metrics().quotes()).isEqualTo(100.0)
        assertThat(response.insights().metrics().replies()).isEqualTo(207.0)
        assertThat(response.insights().metrics().reposts()).isEqualTo(772.0)
        assertThat(response.insights().metrics().views()).isEqualTo(1291231.0)
        assertThat(response.insights().tweetId()).isEqualTo("2102882545427714266")
    }

    @Test
    fun getRetweeterIdsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/1234567890/retweeter-ids"))
                .willReturn(
                    okJson(
                        """
                        {
                          "ids": [
                            "9876543210",
                            "44196397"
                          ],
                          "has_next_page": true,
                          "next_cursor": "1878079982871151535"
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params = TweetGetRetweeterIdsParams.builder().id("1234567890").build()

        val response = client.x().tweets().getRetweeterIds(params)
        val asyncResponse = asyncClient.x().tweets().getRetweeterIds(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/tweets/1234567890/retweeter-ids")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(true)
        assertThat(response.ids()).containsExactly("9876543210", "44196397")
        assertThat(response.nextCursor()).isEqualTo("1878079982871151535")
    }

    @Test
    fun getSubtitlesParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/1234567890/subtitles"))
                .willReturn(
                    okJson(
                        """
                        {
                          "subtitles": {
                            "tweetId": "2104593672624886205",
                            "tracks": [
                              {
                                "mediaKey": "13_2104593621043314689",
                                "language": "en",
                                "name": "Planetary Defenders_Caption.en_US.srt",
                                "autoGenerated": false,
                                "url": "https://video.twimg.com/subtitles/amplify_video/2104593621043314689/0/-FdxBBY2iGcoP5wb.vtt",
                                "text": "This asteroid 2024 YR4 might get interesting.",
                                "truncated": false,
                                "cues": [
                                  {
                                    "startMs": 0,
                                    "endMs": 3370,
                                    "text": "This asteroid\n2024 YR4 might get interesting."
                                  }
                                ]
                              }
                            ]
                          }
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            TweetGetSubtitlesParams.builder()
                .id("1234567890")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().tweets().getSubtitles(params)
        val asyncResponse = asyncClient.x().tweets().getSubtitles(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/tweets/1234567890/subtitles"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.subtitles().tracks()).hasSize(1)
        assertThat(response.subtitles().tracks()[0].autoGenerated()).isEqualTo(false)
        assertThat(response.subtitles().tracks()[0].cues()).hasSize(1)
        assertThat(response.subtitles().tracks()[0].cues()[0].endMs()).isEqualTo(3370L)
        assertThat(response.subtitles().tracks()[0].cues()[0].startMs()).isEqualTo(0L)
        assertThat(response.subtitles().tracks()[0].cues()[0].text())
            .isEqualTo("This asteroid\n2024 YR4 might get interesting.")
        assertThat(response.subtitles().tracks()[0].text())
            .isEqualTo("This asteroid 2024 YR4 might get interesting.")
        assertThat(response.subtitles().tracks()[0].truncated()).isEqualTo(false)
        assertThat(response.subtitles().tracks()[0].url())
            .isEqualTo(
                "https://video.twimg.com/subtitles/amplify_video/2104593621043314689/0/-FdxBBY2iGcoP5wb.vtt"
            )
        assertThat(response.subtitles().tracks()[0].language()).contains("en")
        assertThat(response.subtitles().tracks()[0].mediaKey()).contains("13_2104593621043314689")
        assertThat(response.subtitles().tracks()[0].name())
            .contains("Planetary Defenders_Caption.en_US.srt")
        assertThat(response.subtitles().tweetId()).isEqualTo("2104593672624886205")
    }

    @Test
    fun listTopParsesTheSpecExample() {
        stubFor(get(urlPathEqualTo("/x/tweets/top")).willReturn(okJson(paginatedTweetsExample)))
        val params =
            TweetListTopParams.builder()
                .country("US")
                .fields("id,text,author.username")
                .language("en")
                .metric(TweetListTopParams.Metric.LIKES)
                .omit("entities,media")
                .window(TweetListTopParams.Window.DAY)
                .build()

        val response = client.x().tweets().listTop(params)
        val asyncResponse = asyncClient.x().tweets().listTop(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/tweets/top"))
                .withQueryParam("country", equalTo("US"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("language", equalTo("en"))
                .withQueryParam("metric", equalTo("likes"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("window", equalTo("day")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(true)
        assertThat(response.nextCursor())
            .isEqualTo("DAAHCgABHTK6Vr___-sLAAIAAAATMjEwMTc3MDE4NjE1NjA1Mjk1OQgAAwAAAAIAAA")
        assertThat(response.tweets()).hasSize(2)
        assertThat(response.tweets()[0].id()).isEqualTo("2102761519985332442")
        assertThat(response.tweets()[0].text())
            .isEqualTo(
                "This galaxy is a little extra.\n\nMeet Messier 106, a spiral galaxy with an extra set of arms. These two additional arms are made of gas heated up by jets from the galaxy’s central black hole. The jets’ superheated shockwaves are depicted in royal blue by @chandraxray. https://t.co/421Lzs0r0c"
            )
    }

    @Test
    fun resolveLinksParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/links/resolve"))
                .willReturn(
                    okJson(
                        """
                        {
                          "links": [
                            {
                              "url": "https://t.co/Xe1nm2pkSX",
                              "resolvedUrl": "https://go.nasa.gov/3VcvAQn"
                            }
                          ],
                          "unprocessedUrls": []
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            TweetResolveLinksParams.builder()
                .urls("https://t.co/Xe1nm2pkSX")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().tweets().resolveLinks(params)
        val asyncResponse = asyncClient.x().tweets().resolveLinks(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/links/resolve"))
                .withQueryParam("urls", equalTo("https://t.co/Xe1nm2pkSX"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.links()).hasSize(1)
        assertThat(response.links()[0].url()).isEqualTo("https://t.co/Xe1nm2pkSX")
        assertThat(response.links()[0].resolvedUrl()).contains("https://go.nasa.gov/3VcvAQn")
        assertThat(response.unprocessedUrls()).isEmpty()
    }

    @Test
    fun translateParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/1234567890/translation"))
                .willReturn(
                    okJson(
                        """
                        {
                          "translation": {
                            "tweetId": "2102882545427714266",
                            "language": "tr",
                            "sourceLanguage": "en",
                            "text": "Artemis Anlaşmaları’na Hoş Geldiniz, Hırvatistan https://t.co/Xe1nm2pkSX",
                            "entities": {
                              "urls": [
                                {
                                  "url": "https://t.co/Xe1nm2pkSX",
                                  "expanded_url": "https://go.nasa.gov/3VcvAQn",
                                  "display_url": "go.nasa.gov/3VcvAQn",
                                  "indices": [
                                    49,
                                    72
                                  ]
                                }
                              ]
                            }
                          }
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            TweetTranslateParams.builder()
                .id("1234567890")
                .language("tr")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().tweets().translate(params)
        val asyncResponse = asyncClient.x().tweets().translate(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/tweets/1234567890/translation"))
                .withQueryParam("language", equalTo("tr"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.translation().entities().hashtags()).isEmpty
        assertThat(response.translation().entities().smarttags()).isEmpty
        assertThat(response.translation().entities().symbols()).isEmpty
        assertThat(response.translation().entities().timestamps()).isEmpty
        assertThat(response.translation().entities().urls().get()).hasSize(1)
        assertThat(response.translation().entities().urls().get()[0].displayUrl())
            .contains("go.nasa.gov/3VcvAQn")
        assertThat(response.translation().entities().urls().get()[0].expandedUrl())
            .contains("https://go.nasa.gov/3VcvAQn")
        assertThat(response.translation().entities().urls().get()[0].indices().get())
            .containsExactly(49L, 72L)
        assertThat(response.translation().entities().urls().get()[0].url())
            .contains("https://t.co/Xe1nm2pkSX")
        assertThat(response.translation().entities().userMentions()).isEmpty
        assertThat(response.translation().language()).isEqualTo("tr")
        assertThat(response.translation().text())
            .isEqualTo("Artemis Anlaşmaları’na Hoş Geldiniz, Hırvatistan https://t.co/Xe1nm2pkSX")
        assertThat(response.translation().tweetId()).isEqualTo("2102882545427714266")
        assertThat(response.translation().sourceLanguage()).contains("en")
    }

    @Test
    fun listParsesTheSpecExample() {
        stubFor(get(urlPathEqualTo("/x/tweets")).willReturn(okJson(paginatedTweetsExampleList)))
        val params =
            TweetListParams.builder()
                .ids("ids-sample")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().tweets().list(params)
        val asyncResponse = asyncClient.x().tweets().list(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/tweets"))
                .withQueryParam("ids", equalTo("ids-sample"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.tweets()).hasSize(1)
        assertThat(response.tweets()[0].id()).isEqualTo("1234567890")
        assertThat(response.tweets()[0].bookmarkCount()).isEqualTo(2L)
        assertThat(response.tweets()[0].likeCount()).isEqualTo(42L)
        assertThat(response.tweets()[0].quoteCount()).isEqualTo(1L)
        assertThat(response.tweets()[0].replyCount()).isEqualTo(3L)
        assertThat(response.tweets()[0].retweetCount()).isEqualTo(5L)
        assertThat(response.tweets()[0].text()).isEqualTo("Just launched our new feature!")
        assertThat(response.tweets()[0].viewCount()).isEqualTo(1500L)
        assertThat(response.tweets()[0].author().get().id()).isEqualTo("9876543210")
        assertThat(response.tweets()[0].author().get().name()).isEqualTo("Elon Musk")
        assertThat(response.tweets()[0].author().get().username()).isEqualTo("elonmusk")
        assertThat(response.tweets()[0].author().get().verified()).contains(true)
        assertThat(response.tweets()[0].author().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[0].createdAt()).contains("2025-01-15T12:00:00Z")
        assertThat(response.tweets()[0]._additionalProperties()).isEmpty()
        assertThat(response._additionalProperties()).isEmpty()
    }

    @Test
    fun searchParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/search"))
                .willReturn(
                    okJson(
                        """
                        {
                          "tweets": [
                            {
                              "id": "1234567890",
                              "text": "Just launched our new feature!",
                              "createdAt": "2025-01-15T12:00:00Z",
                              "likeCount": 42,
                              "retweetCount": 5,
                              "replyCount": 3,
                              "quoteCount": 1,
                              "viewCount": 1500,
                              "bookmarkCount": 2,
                              "author": {
                                "id": "9876543210",
                                "username": "elonmusk",
                                "name": "Elon Musk",
                                "verified": true
                              }
                            }
                          ],
                          "has_next_page": true,
                          "next_cursor": "DAACCgACGRElMJcAAA"
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            TweetSearchParams.builder()
                .q("q-sample")
                .advancedQuery("advancedQuery-sample")
                .anyWords("anyWords-sample")
                .blueVerifiedOnly(true)
                .boundingBox("boundingBox-sample")
                .cardName("cardName-sample")
                .cashtags("cashtags-sample")
                .conversationId("conversationId-sample")
                .cursor("cursor-sample")
                .exactPhrase("exactPhrase-sample")
                .excludeSource("excludeSource-sample")
                .excludeWords("excludeWords-sample")
                .fields("id,text,author.username")
                .fromUser("fromUser-sample")
                .geocode("geocode-sample")
                .hashtags("hashtags-sample")
                .inReplyToTweetId("inReplyToTweetId-sample")
                .keywords("keywords-sample")
                .language("language-sample")
                .limit(29L)
                .listId("listId-sample")
                .maxFaves(31L)
                .maxId("maxId-sample")
                .maxQuotes(33L)
                .maxReplies(34L)
                .maxRetweets(35L)
                .mentioning("mentioning-sample")
                .minBookmarks(38L)
                .minFaves(39L)
                .minLikes(40L)
                .minQuotes(41L)
                .minReplies(42L)
                .minRetweets(43L)
                .minViews(44L)
                .nativeRetweets(true)
                .near("near-sample")
                .news(true)
                .omit("entities,media")
                .place("place-sample")
                .placeCountry("placeCountry-sample")
                .pointRadius("pointRadius-sample")
                .quotesOfTweetId("quotesOfTweetId-sample")
                .retweetsOfTweetId("retweetsOfTweetId-sample")
                .safe(true)
                .sinceId("sinceId-sample")
                .sinceTime("sinceTime-sample")
                .source("source-sample")
                .toUser("toUser-sample")
                .untilTime("untilTime-sample")
                .url("url-sample")
                .verifiedOnly(true)
                .within("within-sample")
                .withinTime("7d")
                .build()

        val response = client.x().tweets().search(params)
        val asyncResponse = asyncClient.x().tweets().search(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/tweets/search"))
                .withQueryParam("q", equalTo("q-sample"))
                .withQueryParam("advancedQuery", equalTo("advancedQuery-sample"))
                .withQueryParam("anyWords", equalTo("anyWords-sample"))
                .withQueryParam("blueVerifiedOnly", equalTo("true"))
                .withQueryParam("boundingBox", equalTo("boundingBox-sample"))
                .withQueryParam("cardName", equalTo("cardName-sample"))
                .withQueryParam("cashtags", equalTo("cashtags-sample"))
                .withQueryParam("conversationId", equalTo("conversationId-sample"))
                .withQueryParam("cursor", equalTo("cursor-sample"))
                .withQueryParam("exactPhrase", equalTo("exactPhrase-sample"))
                .withQueryParam("excludeSource", equalTo("excludeSource-sample"))
                .withQueryParam("excludeWords", equalTo("excludeWords-sample"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("fromUser", equalTo("fromUser-sample"))
                .withQueryParam("geocode", equalTo("geocode-sample"))
                .withQueryParam("hashtags", equalTo("hashtags-sample"))
                .withQueryParam("inReplyToTweetId", equalTo("inReplyToTweetId-sample"))
                .withQueryParam("keywords", equalTo("keywords-sample"))
                .withQueryParam("language", equalTo("language-sample"))
                .withQueryParam("limit", equalTo("29"))
                .withQueryParam("listId", equalTo("listId-sample"))
                .withQueryParam("maxFaves", equalTo("31"))
                .withQueryParam("maxId", equalTo("maxId-sample"))
                .withQueryParam("maxQuotes", equalTo("33"))
                .withQueryParam("maxReplies", equalTo("34"))
                .withQueryParam("maxRetweets", equalTo("35"))
                .withQueryParam("mentioning", equalTo("mentioning-sample"))
                .withQueryParam("minBookmarks", equalTo("38"))
                .withQueryParam("minFaves", equalTo("39"))
                .withQueryParam("minLikes", equalTo("40"))
                .withQueryParam("minQuotes", equalTo("41"))
                .withQueryParam("minReplies", equalTo("42"))
                .withQueryParam("minRetweets", equalTo("43"))
                .withQueryParam("minViews", equalTo("44"))
                .withQueryParam("nativeRetweets", equalTo("true"))
                .withQueryParam("near", equalTo("near-sample"))
                .withQueryParam("news", equalTo("true"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("place", equalTo("place-sample"))
                .withQueryParam("placeCountry", equalTo("placeCountry-sample"))
                .withQueryParam("pointRadius", equalTo("pointRadius-sample"))
                .withQueryParam("quotesOfTweetId", equalTo("quotesOfTweetId-sample"))
                .withQueryParam("retweetsOfTweetId", equalTo("retweetsOfTweetId-sample"))
                .withQueryParam("safe", equalTo("true"))
                .withQueryParam("sinceId", equalTo("sinceId-sample"))
                .withQueryParam("sinceTime", equalTo("sinceTime-sample"))
                .withQueryParam("source", equalTo("source-sample"))
                .withQueryParam("toUser", equalTo("toUser-sample"))
                .withQueryParam("untilTime", equalTo("untilTime-sample"))
                .withQueryParam("url", equalTo("url-sample"))
                .withQueryParam("verifiedOnly", equalTo("true"))
                .withQueryParam("within", equalTo("within-sample"))
                .withQueryParam("withinTime", equalTo("7d")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.isPaginatedTweets()).isTrue()
        assertThat(response.asPaginatedTweets().hasNextPage()).isEqualTo(true)
        assertThat(response.asPaginatedTweets().nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
        assertThat(response.asPaginatedTweets().tweets()).hasSize(1)
        assertThat(response.asPaginatedTweets().tweets()[0].id()).isEqualTo("1234567890")
        assertThat(response.asPaginatedTweets().tweets()[0].bookmarkCount()).isEqualTo(2L)
        assertThat(response.asPaginatedTweets().tweets()[0].likeCount()).isEqualTo(42L)
        assertThat(response.asPaginatedTweets().tweets()[0].quoteCount()).isEqualTo(1L)
        assertThat(response.asPaginatedTweets().tweets()[0].replyCount()).isEqualTo(3L)
        assertThat(response.asPaginatedTweets().tweets()[0].retweetCount()).isEqualTo(5L)
        assertThat(response.asPaginatedTweets().tweets()[0].text())
            .isEqualTo("Just launched our new feature!")
        assertThat(response.asPaginatedTweets().tweets()[0].viewCount()).isEqualTo(1500L)
        assertThat(response.asPaginatedTweets().tweets()[0].author().get().id())
            .isEqualTo("9876543210")
        assertThat(response.asPaginatedTweets().tweets()[0].author().get().name())
            .isEqualTo("Elon Musk")
        assertThat(response.asPaginatedTweets().tweets()[0].author().get().username())
            .isEqualTo("elonmusk")
        assertThat(response.asPaginatedTweets().tweets()[0].author().get().verified())
            .contains(true)
        assertThat(response.asPaginatedTweets().tweets()[0].author().get()._additionalProperties())
            .isEmpty()
        assertThat(response.asPaginatedTweets().tweets()[0].createdAt())
            .contains("2025-01-15T12:00:00Z")
        assertThat(response.asPaginatedTweets().tweets()[0]._additionalProperties()).isEmpty()
        assertThat(response.asPaginatedTweets()._additionalProperties()).isEmpty()
    }

    @Test
    fun retrieveParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/1234567890"))
                .willReturn(
                    okJson(
                        """
                        {
                          "tweet": {
                            "id": "1234567890",
                            "text": "New feature",
                            "retweetCount": 5,
                            "replyCount": 3,
                            "likeCount": 42,
                            "quoteCount": 1,
                            "viewCount": 1500,
                            "bookmarkCount": 2
                          }
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            TweetRetrieveParams.builder()
                .id("1234567890")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().tweets().retrieve(params)
        val asyncResponse = asyncClient.x().tweets().retrieve(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/tweets/1234567890"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.tweet().id()).isEqualTo("1234567890")
        assertThat(response.tweet().bookmarkCount()).isEqualTo(2L)
        assertThat(response.tweet().likeCount()).isEqualTo(42L)
        assertThat(response.tweet().quoteCount()).isEqualTo(1L)
        assertThat(response.tweet().replyCount()).isEqualTo(3L)
        assertThat(response.tweet().retweetCount()).isEqualTo(5L)
        assertThat(response.tweet().text()).isEqualTo("New feature")
        assertThat(response.tweet().viewCount()).isEqualTo(1500L)
        assertThat(response.tweet()._additionalProperties()).isEmpty()
        assertThat(response._additionalProperties()).isEmpty()
        assertThat(response.author()).isEmpty
    }

    @Test
    fun getFavoritersParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/1234567890/favoriters"))
                .willReturn(okJson(paginatedUsersExample))
        )
        val params =
            TweetGetFavoritersParams.builder()
                .id("1234567890")
                .bioContains("bioContains-sample")
                .blueVerifiedOnly(true)
                .businessEmailOnly(true)
                .cursor("cursor-sample")
                .emailDomains("acme.com,stanford.edu")
                .fields("id,text,author.username")
                .hasEmail(true)
                .hasLocation(true)
                .hasWebsite(true)
                .locationContains("locationContains-sample")
                .maxFollowers(20L)
                .maxFollowing(21L)
                .maxStatuses(22L)
                .minAccountAgeDays(23L)
                .minFollowers(24L)
                .minFollowing(25L)
                .minStatuses(26L)
                .omit("entities,media")
                .pageSize(28L)
                .usernameContains("usernameContains-sample")
                .verifiedOnly(true)
                .verifiedType("verifiedType-sample")
                .build()

        val response = client.x().tweets().getFavoriters(params)
        val asyncResponse = asyncClient.x().tweets().getFavoriters(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/tweets/1234567890/favoriters"))
                .withQueryParam("bioContains", equalTo("bioContains-sample"))
                .withQueryParam("blueVerifiedOnly", equalTo("true"))
                .withQueryParam("businessEmailOnly", equalTo("true"))
                .withQueryParam("cursor", equalTo("cursor-sample"))
                .withQueryParam("emailDomains", equalTo("acme.com,stanford.edu"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("hasEmail", equalTo("true"))
                .withQueryParam("hasLocation", equalTo("true"))
                .withQueryParam("hasWebsite", equalTo("true"))
                .withQueryParam("locationContains", equalTo("locationContains-sample"))
                .withQueryParam("maxFollowers", equalTo("20"))
                .withQueryParam("maxFollowing", equalTo("21"))
                .withQueryParam("maxStatuses", equalTo("22"))
                .withQueryParam("minAccountAgeDays", equalTo("23"))
                .withQueryParam("minFollowers", equalTo("24"))
                .withQueryParam("minFollowing", equalTo("25"))
                .withQueryParam("minStatuses", equalTo("26"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("pageSize", equalTo("28"))
                .withQueryParam("usernameContains", equalTo("usernameContains-sample"))
                .withQueryParam("verifiedOnly", equalTo("true"))
                .withQueryParam("verifiedType", equalTo("verifiedType-sample")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.users()).hasSize(2)
        assertThat(response.users()[0].id()).isEqualTo("34743251")
        assertThat(response.users()[0].name()).isEqualTo("SpaceX")
        assertThat(response.users()[0].username()).isEqualTo("SpaceX")
        assertThat(response.users()[0].contactInfo().get().links().get()).hasSize(1)
        assertThat(response.users()[0].contactInfo().get().links().get()[0].network())
            .isEqualTo("website")
        assertThat(response.users()[0].contactInfo().get().links().get()[0].source())
            .isEqualTo(UserProfile.ContactInfo.Link.Source.URL)
        assertThat(response.users()[0].contactInfo().get().links().get()[0].url())
            .isEqualTo("http://spacex.com")
        assertThat(response.users()[0].contactInfo().get().links().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(response.users()[0].contactInfo().get()._additionalProperties()).isEmpty()
        assertThat(response.users()[0].coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/34743251/1681251194")
        assertThat(response.users()[0].createdAt()).contains("Thu Apr 23 21:53:30 +0000 2009")
        assertThat(response.users()[0].description())
            .contains(
                "SpaceX designs, manufactures and launches the world's most advanced rockets and spacecraft"
            )
        assertThat(response.users()[0].favouritesCount()).contains(529L)
        assertThat(response.users()[0].followers()).contains(41936873L)
        assertThat(response.users()[0].following()).contains(127L)
        assertThat(response.users()[0].hasGraduatedAccess()).contains(true)
        assertThat(response.users()[0].isBlueVerified()).contains(true)
        assertThat(response.users()[0].isVerified()).contains(true)
        assertThat(response.users()[0].location()).contains("Earth")
        assertThat(response.users()[0].mediaCount()).contains(4713L)
        assertThat(response.users()[0].parodyCommentaryFanLabel()).contains("None")
        assertThat(response.users()[0].pinnedTweetIds().get())
            .containsExactly("2104354931595423762")
        assertThat(response.users()[0].possiblySensitive()).contains(false)
        assertThat(response.users()[0].profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/34743251/1681251194")
        assertThat(response.users()[0].profileDescriptionLanguage()).contains("en")
        assertThat(response.users()[0].profileImageShape()).contains("Square")
        assertThat(response.users()[0].profilePicture())
            .contains(
                "https://pbs.twimg.com/profile_images/1697749409851985920/HbrI04tM_normal.jpg"
            )
        assertThat(response.users()[0].profilePictureOriginal())
            .contains("https://pbs.twimg.com/profile_images/1697749409851985920/HbrI04tM.jpg")
        assertThat(response.users()[0].profileTranslatorType()).contains("none")
        assertThat(response.users()[0].protected_()).contains(false)
        assertThat(response.users()[0].statusesCount()).contains(11834L)
        assertThat(response.users()[0].superFollowEligible()).contains(false)
        assertThat(response.users()[0].url()).contains("http://spacex.com")
        assertThat(response.users()[0].verified()).contains(true)
        assertThat(response.users()[0].verifiedType()).contains("Business")
        assertThat(response.users()[0]._additionalProperties()).isEmpty()
        assertThat(response.users()[1].id()).isEqualTo("20536157")
        assertThat(response.users()[1].name()).isEqualTo("Google")
        assertThat(response.users()[1].username()).isEqualTo("Google")
        assertThat(response.users()[1].contactInfo().get().links().get()).hasSize(1)
        assertThat(response.users()[1].contactInfo().get().links().get()[0].network())
            .isEqualTo("website")
        assertThat(response.users()[1].contactInfo().get().links().get()[0].source())
            .isEqualTo(UserProfile.ContactInfo.Link.Source.URL)
        assertThat(response.users()[1].contactInfo().get().links().get()[0].url())
            .isEqualTo("https://blog.google/newsletter-subscribe/")
        assertThat(response.users()[1].contactInfo().get().links().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(response.users()[1].contactInfo().get()._additionalProperties()).isEmpty()
        assertThat(response.users()[1].coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/20536157/1780004508")
        assertThat(response.users()[1].createdAt()).contains("Tue Feb 10 19:14:39 +0000 2009")
        assertThat(response.users()[1].description()).contains("Here to help.")
        assertThat(response.users()[1].favouritesCount()).contains(5327L)
        assertThat(response.users()[1].followers()).contains(31909314L)
        assertThat(response.users()[1].following()).contains(298L)
        assertThat(response.users()[1].hasGraduatedAccess()).contains(true)
        assertThat(response.users()[1].isBlueVerified()).contains(true)
        assertThat(response.users()[1].isVerified()).contains(true)
        assertThat(response.users()[1].location()).contains("Mountain View, CA")
        assertThat(response.users()[1].mediaCount()).contains(38271L)
        assertThat(response.users()[1].parodyCommentaryFanLabel()).contains("None")
        assertThat(response.users()[1].pinnedTweetIds().get())
            .containsExactly("2105388143902175529")
        assertThat(response.users()[1].possiblySensitive()).contains(false)
        assertThat(response.users()[1].profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/20536157/1780004508")
        assertThat(response.users()[1].profileDescriptionLanguage()).contains("en")
        assertThat(response.users()[1].profileImageShape()).contains("Square")
        assertThat(response.users()[1].profilePicture())
            .contains(
                "https://pbs.twimg.com/profile_images/2042749771337564160/AgOFPEL3_normal.jpg"
            )
        assertThat(response.users()[1].profilePictureOriginal())
            .contains("https://pbs.twimg.com/profile_images/2042749771337564160/AgOFPEL3.jpg")
        assertThat(response.users()[1].profileTranslatorType()).contains("regular")
        assertThat(response.users()[1].protected_()).contains(false)
        assertThat(response.users()[1].statusesCount()).contains(251787L)
        assertThat(response.users()[1].superFollowEligible()).contains(false)
        assertThat(response.users()[1].url()).contains("https://blog.google/newsletter-subscribe/")
        assertThat(response.users()[1].verified()).contains(true)
        assertThat(response.users()[1].verifiedType()).contains("Business")
        assertThat(response.users()[1]._additionalProperties()).isEmpty()
        assertThat(response._additionalProperties()).isEmpty()
    }

    @Test
    fun getQuotesParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/1234567890/quotes"))
                .willReturn(okJson(paginatedTweetsExampleGetQuotes))
        )
        val params =
            TweetGetQuotesParams.builder()
                .id("1234567890")
                .advancedQuery("advancedQuery-sample")
                .anyWords("anyWords-sample")
                .blueVerifiedOnly(true)
                .boundingBox("boundingBox-sample")
                .cardName("cardName-sample")
                .cashtags("cashtags-sample")
                .conversationId("conversationId-sample")
                .cursor("cursor-sample")
                .exactPhrase("exactPhrase-sample")
                .excludeSource("excludeSource-sample")
                .excludeWords("excludeWords-sample")
                .fields("id,text,author.username")
                .fromUser("fromUser-sample")
                .geocode("geocode-sample")
                .hashtags("hashtags-sample")
                .includeReplies(true)
                .inReplyToTweetId("inReplyToTweetId-sample")
                .keywords("keywords-sample")
                .language("language-sample")
                .listId("listId-sample")
                .maxFaves(30L)
                .maxId("maxId-sample")
                .maxQuotes(32L)
                .maxReplies(33L)
                .maxRetweets(34L)
                .mentioning("mentioning-sample")
                .minBookmarks(37L)
                .minFaves(38L)
                .minLikes(39L)
                .minQuotes(40L)
                .minReplies(41L)
                .minRetweets(42L)
                .minViews(43L)
                .nativeRetweets(true)
                .near("near-sample")
                .news(true)
                .omit("entities,media")
                .pageSize(49L)
                .place("place-sample")
                .placeCountry("placeCountry-sample")
                .pointRadius("pointRadius-sample")
                .quotesOfTweetId("quotesOfTweetId-sample")
                .retweetsOfTweetId("retweetsOfTweetId-sample")
                .safe(true)
                .sinceId("sinceId-sample")
                .sinceTime("sinceTime-sample")
                .source("source-sample")
                .toUser("toUser-sample")
                .untilTime("untilTime-sample")
                .url("url-sample")
                .verifiedOnly(true)
                .within("within-sample")
                .withinTime("7d")
                .build()

        val response = client.x().tweets().getQuotes(params)
        val asyncResponse = asyncClient.x().tweets().getQuotes(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/tweets/1234567890/quotes"))
                .withQueryParam("advancedQuery", equalTo("advancedQuery-sample"))
                .withQueryParam("anyWords", equalTo("anyWords-sample"))
                .withQueryParam("blueVerifiedOnly", equalTo("true"))
                .withQueryParam("boundingBox", equalTo("boundingBox-sample"))
                .withQueryParam("cardName", equalTo("cardName-sample"))
                .withQueryParam("cashtags", equalTo("cashtags-sample"))
                .withQueryParam("conversationId", equalTo("conversationId-sample"))
                .withQueryParam("cursor", equalTo("cursor-sample"))
                .withQueryParam("exactPhrase", equalTo("exactPhrase-sample"))
                .withQueryParam("excludeSource", equalTo("excludeSource-sample"))
                .withQueryParam("excludeWords", equalTo("excludeWords-sample"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("fromUser", equalTo("fromUser-sample"))
                .withQueryParam("geocode", equalTo("geocode-sample"))
                .withQueryParam("hashtags", equalTo("hashtags-sample"))
                .withQueryParam("includeReplies", equalTo("true"))
                .withQueryParam("inReplyToTweetId", equalTo("inReplyToTweetId-sample"))
                .withQueryParam("keywords", equalTo("keywords-sample"))
                .withQueryParam("language", equalTo("language-sample"))
                .withQueryParam("listId", equalTo("listId-sample"))
                .withQueryParam("maxFaves", equalTo("30"))
                .withQueryParam("maxId", equalTo("maxId-sample"))
                .withQueryParam("maxQuotes", equalTo("32"))
                .withQueryParam("maxReplies", equalTo("33"))
                .withQueryParam("maxRetweets", equalTo("34"))
                .withQueryParam("mentioning", equalTo("mentioning-sample"))
                .withQueryParam("minBookmarks", equalTo("37"))
                .withQueryParam("minFaves", equalTo("38"))
                .withQueryParam("minLikes", equalTo("39"))
                .withQueryParam("minQuotes", equalTo("40"))
                .withQueryParam("minReplies", equalTo("41"))
                .withQueryParam("minRetweets", equalTo("42"))
                .withQueryParam("minViews", equalTo("43"))
                .withQueryParam("nativeRetweets", equalTo("true"))
                .withQueryParam("near", equalTo("near-sample"))
                .withQueryParam("news", equalTo("true"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("pageSize", equalTo("49"))
                .withQueryParam("place", equalTo("place-sample"))
                .withQueryParam("placeCountry", equalTo("placeCountry-sample"))
                .withQueryParam("pointRadius", equalTo("pointRadius-sample"))
                .withQueryParam("quotesOfTweetId", equalTo("quotesOfTweetId-sample"))
                .withQueryParam("retweetsOfTweetId", equalTo("retweetsOfTweetId-sample"))
                .withQueryParam("safe", equalTo("true"))
                .withQueryParam("sinceId", equalTo("sinceId-sample"))
                .withQueryParam("sinceTime", equalTo("sinceTime-sample"))
                .withQueryParam("source", equalTo("source-sample"))
                .withQueryParam("toUser", equalTo("toUser-sample"))
                .withQueryParam("untilTime", equalTo("untilTime-sample"))
                .withQueryParam("url", equalTo("url-sample"))
                .withQueryParam("verifiedOnly", equalTo("true"))
                .withQueryParam("within", equalTo("within-sample"))
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
    fun getRepliesParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/1234567890/replies"))
                .willReturn(
                    okJson(
                        """
                        {
                          "tweets": [
                            {
                              "id": "2083169393878684056",
                              "text": "@OpenAI A model optimizing its own serving cost after deployment is a neat flywheel to see in production ⚙️",
                              "retweetCount": 0,
                              "replyCount": 0,
                              "likeCount": 1,
                              "quoteCount": 0,
                              "viewCount": 473,
                              "bookmarkCount": 1,
                              "conversationId": "2082577277246972300",
                              "displayTextRange": [
                                8,
                                107
                              ],
                              "edit": {
                                "editableUntilMsecs": "1785504861000",
                                "editTweetIds": [
                                  "2083169393878684056"
                                ]
                              },
                              "entities": {
                                "hashtags": [],
                                "urls": [],
                                "user_mentions": [
                                  {
                                    "id_str": "4398626122",
                                    "indices": [
                                      0,
                                      7
                                    ],
                                    "name": "OpenAI",
                                    "screen_name": "OpenAI"
                                  }
                                ]
                              },
                              "inReplyToId": "2082577277246972300",
                              "inReplyToUserId": "4398626122",
                              "inReplyToUsername": "OpenAI",
                              "isNoteTweet": false,
                              "isPinned": false,
                              "isQuoteStatus": false,
                              "isReply": true,
                              "isRetweet": false,
                              "isTranslatable": false,
                              "lang": "en",
                              "source": "<a href=\"https://mobile.twitter.com\" rel=\"nofollow\">Twitter Web App</a>",
                              "type": "reply",
                              "url": "https://x.com/PublicAI_/status/2083169393878684056",
                              "viewState": "EnabledWithCount",
                              "hasCommunityNotes": false,
                              "createdAt": "Fri Jul 31 12:34:21 +0000 2026",
                              "author": {
                                "id": "1615238618301501440",
                                "username": "PublicAI_",
                                "name": "PublicAI",
                                "followers": 210053,
                                "following": 173,
                                "verified": true,
                                "isBlueVerified": true,
                                "isVerified": true,
                                "profilePicture": "https://pbs.twimg.com/profile_images/1936462795584729088/c3advPaX_normal.jpg",
                                "coverPicture": "https://pbs.twimg.com/profile_banners/1615238618301501440/1744434414",
                                "profileBannerUrl": "https://pbs.twimg.com/profile_banners/1615238618301501440/1744434414",
                                "description": "AI data research lab. We ship products that collect real human work for models. Backed by @StanfordSBA. PublicAI LLM Index @PublicAIData.",
                                "location": "Mars",
                                "createdAt": "Tue Jan 17 06:44:40 +0000 2023",
                                "statusesCount": 2936,
                                "mediaCount": 535,
                                "protected": false,
                                "url": "http://PublicAi.io",
                                "favouritesCount": 3726,
                                "isTranslator": false,
                                "possiblySensitive": false,
                                "pinnedTweetIds": [
                                  "2092582845722292633"
                                ],
                                "verifiedType": "Blue",
                                "profile_bio": {
                                  "description": "AI data research lab. We ship products that collect real human work for models. Backed by @StanfordSBA. PublicAI LLM Index @PublicAIData.",
                                  "entities": {
                                    "description": {},
                                    "url": {
                                      "urls": [
                                        {
                                          "display_url": "PublicAi.io",
                                          "expanded_url": "http://PublicAi.io",
                                          "indices": [
                                            0,
                                            23
                                          ],
                                          "url": "https://t.co/4HO9Tpo2aA"
                                        }
                                      ]
                                    }
                                  }
                                },
                                "hasGraduatedAccess": true,
                                "parodyCommentaryFanLabel": "None",
                                "professional": {
                                  "category": [
                                    {
                                      "icon_name": "IconBriefcaseStroke",
                                      "id": 713,
                                      "name": "Science & Technology"
                                    }
                                  ],
                                  "professional_type": "Business",
                                  "rest_id": "1856812443324092849"
                                },
                                "profileDescriptionLanguage": "en",
                                "profileImageShape": "Circle",
                                "profileTranslatorType": "none",
                                "superFollowEligible": false
                              }
                            },
                            {
                              "id": "2082911177416568983",
                              "text": "@OpenAI Cheaper, faster, better",
                              "retweetCount": 0,
                              "replyCount": 0,
                              "likeCount": 2,
                              "quoteCount": 0,
                              "viewCount": 1072,
                              "bookmarkCount": 0,
                              "conversationId": "2082577277246972300",
                              "displayTextRange": [
                                8,
                                31
                              ],
                              "edit": {
                                "editableUntilMsecs": "1785443297000",
                                "editTweetIds": [
                                  "2082911177416568983"
                                ]
                              },
                              "entities": {
                                "hashtags": [],
                                "urls": [],
                                "user_mentions": [
                                  {
                                    "id_str": "4398626122",
                                    "indices": [
                                      0,
                                      7
                                    ],
                                    "name": "OpenAI",
                                    "screen_name": "OpenAI"
                                  }
                                ]
                              },
                              "inReplyToId": "2082577277246972300",
                              "inReplyToUserId": "4398626122",
                              "inReplyToUsername": "OpenAI",
                              "isNoteTweet": false,
                              "isPinned": false,
                              "isQuoteStatus": false,
                              "isReply": true,
                              "isRetweet": false,
                              "isTranslatable": false,
                              "lang": "en",
                              "source": "<a href=\"https://mobile.twitter.com\" rel=\"nofollow\">Twitter Web App</a>",
                              "type": "reply",
                              "url": "https://x.com/Wager_Predict/status/2082911177416568983",
                              "viewState": "EnabledWithCount",
                              "hasCommunityNotes": false,
                              "createdAt": "Thu Jul 30 19:28:17 +0000 2026",
                              "author": {
                                "id": "1513781916990083073",
                                "username": "Wager_Predict",
                                "name": "Wager Predict",
                                "followers": 54048,
                                "following": 76,
                                "verified": true,
                                "isBlueVerified": false,
                                "isVerified": true,
                                "profilePicture": "https://pbs.twimg.com/profile_images/2076634676228407298/O2FJ2EIM_normal.jpg",
                                "coverPicture": "https://pbs.twimg.com/profile_banners/1513781916990083073/1784142396",
                                "profileBannerUrl": "https://pbs.twimg.com/profile_banners/1513781916990083073/1784142396",
                                "description": "Trade on what happens next. | The Markets are brewing Up.\nTGE soon!",
                                "createdAt": "Tue Apr 12 07:32:01 +0000 2022",
                                "statusesCount": 1918,
                                "mediaCount": 280,
                                "protected": false,
                                "url": "http://wagerpredict.com",
                                "favouritesCount": 1360,
                                "isTranslator": false,
                                "possiblySensitive": false,
                                "pinnedTweetIds": [
                                  "2077051650754367854"
                                ],
                                "verifiedType": "Business",
                                "profile_bio": {
                                  "description": "Trade on what happens next. | The Markets are brewing Up.\nTGE soon!",
                                  "entities": {
                                    "description": {},
                                    "url": {
                                      "urls": [
                                        {
                                          "display_url": "wagerpredict.com",
                                          "expanded_url": "http://wagerpredict.com",
                                          "indices": [
                                            0,
                                            23
                                          ],
                                          "url": "https://t.co/1MgjWEdMLw"
                                        }
                                      ]
                                    }
                                  }
                                },
                                "hasGraduatedAccess": true,
                                "parodyCommentaryFanLabel": "None",
                                "professional": {
                                  "category": [],
                                  "professional_type": "Business",
                                  "rest_id": "1560458726439788544"
                                },
                                "profileDescriptionLanguage": "en",
                                "profileImageShape": "Square",
                                "profileTranslatorType": "none",
                                "superFollowEligible": false
                              }
                            }
                          ],
                          "has_next_page": true,
                          "next_cursor": "xqcv1_tkGoEx1UJRqeog9a2BJdmzUZTMCoU_M8kb6ZZwaDFa0.1",
                          "filtered_count": 0
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            TweetGetRepliesParams.builder()
                .id("1234567890")
                .after("after-sample")
                .anyWords("anyWords-sample")
                .blueVerifiedOnly(true)
                .cardName("cardName-sample")
                .cashtags("cashtags-sample")
                .conversationId("conversationId-sample")
                .cursor("cursor-sample")
                .exactPhrase("exactPhrase-sample")
                .excludeOriginalAuthor(true)
                .excludeSource("excludeSource-sample")
                .excludeWords("excludeWords-sample")
                .fields("id,text,author.username")
                .fromUser("fromUser-sample")
                .geocode("geocode-sample")
                .hashtags("hashtags-sample")
                .hasMediaOnly(true)
                .includeHidden(true)
                .includeOriginalPost(true)
                .inReplyToTweetId("inReplyToTweetId-sample")
                .language("language-sample")
                .limit(30L)
                .maxDepth(31L)
                .maxFaves(32L)
                .maxId("maxId-sample")
                .maxQuotes(34L)
                .maxReplies(35L)
                .maxRetweets(36L)
                .mentioning("mentioning-sample")
                .minBookmarks(39L)
                .minFaves(40L)
                .minLikes(41L)
                .minQuotes(42L)
                .minReplies(43L)
                .minRetweets(44L)
                .minViews(45L)
                .nativeRetweets(true)
                .near("near-sample")
                .news(true)
                .omit("entities,media")
                .pageSize(51L)
                .quotesOfTweetId("quotesOfTweetId-sample")
                .retweetsOfTweetId("retweetsOfTweetId-sample")
                .safe(true)
                .sinceId("sinceId-sample")
                .sinceTime("sinceTime-sample")
                .source("source-sample")
                .toUser("toUser-sample")
                .untilTime("untilTime-sample")
                .url("url-sample")
                .verifiedOnly(true)
                .within("within-sample")
                .withinTime("7d")
                .build()

        val response = client.x().tweets().getReplies(params)
        val asyncResponse = asyncClient.x().tweets().getReplies(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/tweets/1234567890/replies"))
                .withQueryParam("after", equalTo("after-sample"))
                .withQueryParam("anyWords", equalTo("anyWords-sample"))
                .withQueryParam("blueVerifiedOnly", equalTo("true"))
                .withQueryParam("cardName", equalTo("cardName-sample"))
                .withQueryParam("cashtags", equalTo("cashtags-sample"))
                .withQueryParam("conversationId", equalTo("conversationId-sample"))
                .withQueryParam("cursor", equalTo("cursor-sample"))
                .withQueryParam("exactPhrase", equalTo("exactPhrase-sample"))
                .withQueryParam("excludeOriginalAuthor", equalTo("true"))
                .withQueryParam("excludeSource", equalTo("excludeSource-sample"))
                .withQueryParam("excludeWords", equalTo("excludeWords-sample"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("fromUser", equalTo("fromUser-sample"))
                .withQueryParam("geocode", equalTo("geocode-sample"))
                .withQueryParam("hashtags", equalTo("hashtags-sample"))
                .withQueryParam("hasMediaOnly", equalTo("true"))
                .withQueryParam("includeHidden", equalTo("true"))
                .withQueryParam("includeOriginalPost", equalTo("true"))
                .withQueryParam("inReplyToTweetId", equalTo("inReplyToTweetId-sample"))
                .withQueryParam("language", equalTo("language-sample"))
                .withQueryParam("limit", equalTo("30"))
                .withQueryParam("maxDepth", equalTo("31"))
                .withQueryParam("maxFaves", equalTo("32"))
                .withQueryParam("maxId", equalTo("maxId-sample"))
                .withQueryParam("maxQuotes", equalTo("34"))
                .withQueryParam("maxReplies", equalTo("35"))
                .withQueryParam("maxRetweets", equalTo("36"))
                .withQueryParam("mentioning", equalTo("mentioning-sample"))
                .withQueryParam("minBookmarks", equalTo("39"))
                .withQueryParam("minFaves", equalTo("40"))
                .withQueryParam("minLikes", equalTo("41"))
                .withQueryParam("minQuotes", equalTo("42"))
                .withQueryParam("minReplies", equalTo("43"))
                .withQueryParam("minRetweets", equalTo("44"))
                .withQueryParam("minViews", equalTo("45"))
                .withQueryParam("nativeRetweets", equalTo("true"))
                .withQueryParam("near", equalTo("near-sample"))
                .withQueryParam("news", equalTo("true"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("pageSize", equalTo("51"))
                .withQueryParam("quotesOfTweetId", equalTo("quotesOfTweetId-sample"))
                .withQueryParam("retweetsOfTweetId", equalTo("retweetsOfTweetId-sample"))
                .withQueryParam("safe", equalTo("true"))
                .withQueryParam("sinceId", equalTo("sinceId-sample"))
                .withQueryParam("sinceTime", equalTo("sinceTime-sample"))
                .withQueryParam("source", equalTo("source-sample"))
                .withQueryParam("toUser", equalTo("toUser-sample"))
                .withQueryParam("untilTime", equalTo("untilTime-sample"))
                .withQueryParam("url", equalTo("url-sample"))
                .withQueryParam("verifiedOnly", equalTo("true"))
                .withQueryParam("within", equalTo("within-sample"))
                .withQueryParam("withinTime", equalTo("7d")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(true)
        assertThat(response.nextCursor())
            .isEqualTo("xqcv1_tkGoEx1UJRqeog9a2BJdmzUZTMCoU_M8kb6ZZwaDFa0.1")
        assertThat(response.tweets()).hasSize(2)
        assertThat(response.tweets()[0].id()).isEqualTo("2083169393878684056")
        assertThat(response.tweets()[0].bookmarkCount()).isEqualTo(1L)
        assertThat(response.tweets()[0].likeCount()).isEqualTo(1L)
        assertThat(response.tweets()[0].quoteCount()).isEqualTo(0L)
        assertThat(response.tweets()[0].replyCount()).isEqualTo(0L)
        assertThat(response.tweets()[0].retweetCount()).isEqualTo(0L)
        assertThat(response.tweets()[0].text())
            .isEqualTo(
                "@OpenAI A model optimizing its own serving cost after deployment is a neat flywheel to see in production ⚙️"
            )
        assertThat(response.tweets()[0].viewCount()).isEqualTo(473L)
        assertThat(response.tweets()[0].author().get().id()).isEqualTo("1615238618301501440")
        assertThat(response.tweets()[0].author().get().name()).isEqualTo("PublicAI")
        assertThat(response.tweets()[0].author().get().username()).isEqualTo("PublicAI_")
        assertThat(response.tweets()[0].author().get().coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/1615238618301501440/1744434414")
        assertThat(response.tweets()[0].author().get().createdAt())
            .contains("Tue Jan 17 06:44:40 +0000 2023")
        assertThat(response.tweets()[0].author().get().description())
            .contains(
                "AI data research lab. We ship products that collect real human work for models. Backed by @StanfordSBA. PublicAI LLM Index @PublicAIData."
            )
        assertThat(response.tweets()[0].author().get().favouritesCount()).contains(3726L)
        assertThat(response.tweets()[0].author().get().followers()).contains(210053L)
        assertThat(response.tweets()[0].author().get().following()).contains(173L)
        assertThat(response.tweets()[0].author().get().hasGraduatedAccess()).contains(true)
        assertThat(response.tweets()[0].author().get().isBlueVerified()).contains(true)
        assertThat(response.tweets()[0].author().get().isTranslator()).contains(false)
        assertThat(response.tweets()[0].author().get().isVerified()).contains(true)
        assertThat(response.tweets()[0].author().get().location()).contains("Mars")
        assertThat(response.tweets()[0].author().get().mediaCount()).contains(535L)
        assertThat(response.tweets()[0].author().get().parodyCommentaryFanLabel()).contains("None")
        assertThat(response.tweets()[0].author().get().pinnedTweetIds().get())
            .containsExactly("2092582845722292633")
        assertThat(response.tweets()[0].author().get().possiblySensitive()).contains(false)
        assertThat(response.tweets()[0].author().get().profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/1615238618301501440/1744434414")
        assertThat(response.tweets()[0].author().get().profileDescriptionLanguage()).contains("en")
        assertThat(response.tweets()[0].author().get().profileImageShape()).contains("Circle")
        assertThat(response.tweets()[0].author().get().profilePicture())
            .contains(
                "https://pbs.twimg.com/profile_images/1936462795584729088/c3advPaX_normal.jpg"
            )
        assertThat(response.tweets()[0].author().get().profileTranslatorType()).contains("none")
        assertThat(response.tweets()[0].author().get().protected_()).contains(false)
        assertThat(response.tweets()[0].author().get().statusesCount()).contains(2936L)
        assertThat(response.tweets()[0].author().get().superFollowEligible()).contains(false)
        assertThat(response.tweets()[0].author().get().url()).contains("http://PublicAi.io")
        assertThat(response.tweets()[0].author().get().verified()).contains(true)
        assertThat(response.tweets()[0].author().get().verifiedType()).contains("Blue")
        assertThat(response.tweets()[0].author().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[0].conversationId()).contains("2082577277246972300")
        assertThat(response.tweets()[0].createdAt()).contains("Fri Jul 31 12:34:21 +0000 2026")
        assertThat(response.tweets()[0].displayTextRange().get()).containsExactly(8L, 107L)
        assertThat(response.tweets()[0].edit().get().editableUntilMsecs()).contains("1785504861000")
        assertThat(response.tweets()[0].edit().get().editTweetIds().get())
            .containsExactly("2083169393878684056")
        assertThat(response.tweets()[0].edit().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[0].entities().get().hashtags().get()).isEmpty()
        assertThat(response.tweets()[0].entities().get().urls().get()).isEmpty()
        assertThat(response.tweets()[0].entities().get().userMentions().get()).hasSize(1)
        assertThat(response.tweets()[0].entities().get().userMentions().get()[0].screenName())
            .isEqualTo("OpenAI")
        assertThat(response.tweets()[0].entities().get().userMentions().get()[0].idStr())
            .contains("4398626122")
        assertThat(response.tweets()[0].entities().get().userMentions().get()[0].indices().get())
            .containsExactly(0L, 7L)
        assertThat(response.tweets()[0].entities().get().userMentions().get()[0].name())
            .contains("OpenAI")
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
        assertThat(response.tweets()[0].hasCommunityNotes()).contains(false)
        assertThat(response.tweets()[0].inReplyToId()).contains("2082577277246972300")
        assertThat(response.tweets()[0].inReplyToUserId()).contains("4398626122")
        assertThat(response.tweets()[0].inReplyToUsername()).contains("OpenAI")
        assertThat(response.tweets()[0].isNoteTweet()).contains(false)
        assertThat(response.tweets()[0].isPinned()).contains(false)
        assertThat(response.tweets()[0].isQuoteStatus()).contains(false)
        assertThat(response.tweets()[0].isReply()).contains(true)
        assertThat(response.tweets()[0].isRetweet()).contains(false)
        assertThat(response.tweets()[0].isTranslatable()).contains(false)
        assertThat(response.tweets()[0].lang()).contains("en")
        assertThat(response.tweets()[0].source())
            .contains("<a href=\"https://mobile.twitter.com\" rel=\"nofollow\">Twitter Web App</a>")
        assertThat(response.tweets()[0].type()).contains("reply")
        assertThat(response.tweets()[0].url())
            .contains("https://x.com/PublicAI_/status/2083169393878684056")
        assertThat(response.tweets()[0].viewState()).contains("EnabledWithCount")
        assertThat(response.tweets()[0]._additionalProperties()).isEmpty()
        assertThat(response.tweets()[1].id()).isEqualTo("2082911177416568983")
        assertThat(response.tweets()[1].bookmarkCount()).isEqualTo(0L)
        assertThat(response.tweets()[1].likeCount()).isEqualTo(2L)
        assertThat(response.tweets()[1].quoteCount()).isEqualTo(0L)
        assertThat(response.tweets()[1].replyCount()).isEqualTo(0L)
        assertThat(response.tweets()[1].retweetCount()).isEqualTo(0L)
        assertThat(response.tweets()[1].text()).isEqualTo("@OpenAI Cheaper, faster, better")
        assertThat(response.tweets()[1].viewCount()).isEqualTo(1072L)
        assertThat(response.tweets()[1].author().get().id()).isEqualTo("1513781916990083073")
        assertThat(response.tweets()[1].author().get().name()).isEqualTo("Wager Predict")
        assertThat(response.tweets()[1].author().get().username()).isEqualTo("Wager_Predict")
        assertThat(response.tweets()[1].author().get().coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/1513781916990083073/1784142396")
        assertThat(response.tweets()[1].author().get().createdAt())
            .contains("Tue Apr 12 07:32:01 +0000 2022")
        assertThat(response.tweets()[1].author().get().description())
            .contains("Trade on what happens next. | The Markets are brewing Up.\nTGE soon!")
        assertThat(response.tweets()[1].author().get().favouritesCount()).contains(1360L)
        assertThat(response.tweets()[1].author().get().followers()).contains(54048L)
        assertThat(response.tweets()[1].author().get().following()).contains(76L)
        assertThat(response.tweets()[1].author().get().hasGraduatedAccess()).contains(true)
        assertThat(response.tweets()[1].author().get().isBlueVerified()).contains(false)
        assertThat(response.tweets()[1].author().get().isTranslator()).contains(false)
        assertThat(response.tweets()[1].author().get().isVerified()).contains(true)
        assertThat(response.tweets()[1].author().get().mediaCount()).contains(280L)
        assertThat(response.tweets()[1].author().get().parodyCommentaryFanLabel()).contains("None")
        assertThat(response.tweets()[1].author().get().pinnedTweetIds().get())
            .containsExactly("2077051650754367854")
        assertThat(response.tweets()[1].author().get().possiblySensitive()).contains(false)
        assertThat(response.tweets()[1].author().get().profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/1513781916990083073/1784142396")
        assertThat(response.tweets()[1].author().get().profileDescriptionLanguage()).contains("en")
        assertThat(response.tweets()[1].author().get().profileImageShape()).contains("Square")
        assertThat(response.tweets()[1].author().get().profilePicture())
            .contains(
                "https://pbs.twimg.com/profile_images/2076634676228407298/O2FJ2EIM_normal.jpg"
            )
        assertThat(response.tweets()[1].author().get().profileTranslatorType()).contains("none")
        assertThat(response.tweets()[1].author().get().protected_()).contains(false)
        assertThat(response.tweets()[1].author().get().statusesCount()).contains(1918L)
        assertThat(response.tweets()[1].author().get().superFollowEligible()).contains(false)
        assertThat(response.tweets()[1].author().get().url()).contains("http://wagerpredict.com")
        assertThat(response.tweets()[1].author().get().verified()).contains(true)
        assertThat(response.tweets()[1].author().get().verifiedType()).contains("Business")
        assertThat(response.tweets()[1].author().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[1].conversationId()).contains("2082577277246972300")
        assertThat(response.tweets()[1].createdAt()).contains("Thu Jul 30 19:28:17 +0000 2026")
        assertThat(response.tweets()[1].displayTextRange().get()).containsExactly(8L, 31L)
        assertThat(response.tweets()[1].edit().get().editableUntilMsecs()).contains("1785443297000")
        assertThat(response.tweets()[1].edit().get().editTweetIds().get())
            .containsExactly("2082911177416568983")
        assertThat(response.tweets()[1].edit().get()._additionalProperties()).isEmpty()
        assertThat(response.tweets()[1].entities().get().hashtags().get()).isEmpty()
        assertThat(response.tweets()[1].entities().get().urls().get()).isEmpty()
        assertThat(response.tweets()[1].entities().get().userMentions().get()).hasSize(1)
        assertThat(response.tweets()[1].entities().get().userMentions().get()[0].screenName())
            .isEqualTo("OpenAI")
        assertThat(response.tweets()[1].entities().get().userMentions().get()[0].idStr())
            .contains("4398626122")
        assertThat(response.tweets()[1].entities().get().userMentions().get()[0].indices().get())
            .containsExactly(0L, 7L)
        assertThat(response.tweets()[1].entities().get().userMentions().get()[0].name())
            .contains("OpenAI")
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
        assertThat(response.tweets()[1].hasCommunityNotes()).contains(false)
        assertThat(response.tweets()[1].inReplyToId()).contains("2082577277246972300")
        assertThat(response.tweets()[1].inReplyToUserId()).contains("4398626122")
        assertThat(response.tweets()[1].inReplyToUsername()).contains("OpenAI")
        assertThat(response.tweets()[1].isNoteTweet()).contains(false)
        assertThat(response.tweets()[1].isPinned()).contains(false)
        assertThat(response.tweets()[1].isQuoteStatus()).contains(false)
        assertThat(response.tweets()[1].isReply()).contains(true)
        assertThat(response.tweets()[1].isRetweet()).contains(false)
        assertThat(response.tweets()[1].isTranslatable()).contains(false)
        assertThat(response.tweets()[1].lang()).contains("en")
        assertThat(response.tweets()[1].source())
            .contains("<a href=\"https://mobile.twitter.com\" rel=\"nofollow\">Twitter Web App</a>")
        assertThat(response.tweets()[1].type()).contains("reply")
        assertThat(response.tweets()[1].url())
            .contains("https://x.com/Wager_Predict/status/2082911177416568983")
        assertThat(response.tweets()[1].viewState()).contains("EnabledWithCount")
        assertThat(response.tweets()[1]._additionalProperties()).isEmpty()
        assertThat(response.filteredCount()).contains(0L)
        assertThat(response._additionalProperties()).isEmpty()
        assertThat(response.diagnostic()).isEmpty
        assertThat(response.hiddenReplies()).isEmpty
        assertThat(response.limitReached()).isEmpty
        assertThat(response.message()).isEmpty
        assertThat(response.nestedReplies()).isEmpty
        assertThat(response.orderPartial()).isEmpty
        assertThat(response.partialBefore()).isEmpty
        assertThat(response.readBackTo()).isEmpty
        assertThat(response.searchContext()).isEmpty
        assertThat(response.searchedQuery()).isEmpty
        assertThat(response.windowComplete()).isEmpty
    }

    @Test
    fun getRetweetersParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/1234567890/retweeters"))
                .willReturn(okJson(paginatedUsersExample))
        )
        val params =
            TweetGetRetweetersParams.builder()
                .id("1234567890")
                .bioContains("bioContains-sample")
                .blueVerifiedOnly(true)
                .businessEmailOnly(true)
                .cursor("cursor-sample")
                .emailDomains("acme.com,stanford.edu")
                .enrichProfiles(true)
                .fields("id,text,author.username")
                .hasEmail(true)
                .hasLocation(true)
                .hasWebsite(true)
                .includeRetweetTimestamp(true)
                .locationContains("locationContains-sample")
                .maxFollowers(22L)
                .maxFollowing(23L)
                .maxStatuses(24L)
                .minAccountAgeDays(25L)
                .minFollowers(26L)
                .minFollowing(27L)
                .minStatuses(28L)
                .omit("entities,media")
                .pageSize(30L)
                .usernameContains("usernameContains-sample")
                .verifiedOnly(true)
                .verifiedType("verifiedType-sample")
                .build()

        val response = client.x().tweets().getRetweeters(params)
        val asyncResponse = asyncClient.x().tweets().getRetweeters(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/tweets/1234567890/retweeters"))
                .withQueryParam("bioContains", equalTo("bioContains-sample"))
                .withQueryParam("blueVerifiedOnly", equalTo("true"))
                .withQueryParam("businessEmailOnly", equalTo("true"))
                .withQueryParam("cursor", equalTo("cursor-sample"))
                .withQueryParam("emailDomains", equalTo("acme.com,stanford.edu"))
                .withQueryParam("enrichProfiles", equalTo("true"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("hasEmail", equalTo("true"))
                .withQueryParam("hasLocation", equalTo("true"))
                .withQueryParam("hasWebsite", equalTo("true"))
                .withQueryParam("includeRetweetTimestamp", equalTo("true"))
                .withQueryParam("locationContains", equalTo("locationContains-sample"))
                .withQueryParam("maxFollowers", equalTo("22"))
                .withQueryParam("maxFollowing", equalTo("23"))
                .withQueryParam("maxStatuses", equalTo("24"))
                .withQueryParam("minAccountAgeDays", equalTo("25"))
                .withQueryParam("minFollowers", equalTo("26"))
                .withQueryParam("minFollowing", equalTo("27"))
                .withQueryParam("minStatuses", equalTo("28"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("pageSize", equalTo("30"))
                .withQueryParam("usernameContains", equalTo("usernameContains-sample"))
                .withQueryParam("verifiedOnly", equalTo("true"))
                .withQueryParam("verifiedType", equalTo("verifiedType-sample")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.users()).hasSize(2)
        assertThat(response.users()[0].id()).isEqualTo("34743251")
        assertThat(response.users()[0].name()).isEqualTo("SpaceX")
        assertThat(response.users()[0].username()).isEqualTo("SpaceX")
        assertThat(response.users()[0].contactInfo().get().links().get()).hasSize(1)
        assertThat(response.users()[0].contactInfo().get().links().get()[0].network())
            .isEqualTo("website")
        assertThat(response.users()[0].contactInfo().get().links().get()[0].source())
            .isEqualTo(UserProfile.ContactInfo.Link.Source.URL)
        assertThat(response.users()[0].contactInfo().get().links().get()[0].url())
            .isEqualTo("http://spacex.com")
        assertThat(response.users()[0].contactInfo().get().links().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(response.users()[0].contactInfo().get()._additionalProperties()).isEmpty()
        assertThat(response.users()[0].coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/34743251/1681251194")
        assertThat(response.users()[0].createdAt()).contains("Thu Apr 23 21:53:30 +0000 2009")
        assertThat(response.users()[0].description())
            .contains(
                "SpaceX designs, manufactures and launches the world's most advanced rockets and spacecraft"
            )
        assertThat(response.users()[0].favouritesCount()).contains(529L)
        assertThat(response.users()[0].followers()).contains(41936873L)
        assertThat(response.users()[0].following()).contains(127L)
        assertThat(response.users()[0].hasGraduatedAccess()).contains(true)
        assertThat(response.users()[0].isBlueVerified()).contains(true)
        assertThat(response.users()[0].isVerified()).contains(true)
        assertThat(response.users()[0].location()).contains("Earth")
        assertThat(response.users()[0].mediaCount()).contains(4713L)
        assertThat(response.users()[0].parodyCommentaryFanLabel()).contains("None")
        assertThat(response.users()[0].pinnedTweetIds().get())
            .containsExactly("2104354931595423762")
        assertThat(response.users()[0].possiblySensitive()).contains(false)
        assertThat(response.users()[0].profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/34743251/1681251194")
        assertThat(response.users()[0].profileDescriptionLanguage()).contains("en")
        assertThat(response.users()[0].profileImageShape()).contains("Square")
        assertThat(response.users()[0].profilePicture())
            .contains(
                "https://pbs.twimg.com/profile_images/1697749409851985920/HbrI04tM_normal.jpg"
            )
        assertThat(response.users()[0].profilePictureOriginal())
            .contains("https://pbs.twimg.com/profile_images/1697749409851985920/HbrI04tM.jpg")
        assertThat(response.users()[0].profileTranslatorType()).contains("none")
        assertThat(response.users()[0].protected_()).contains(false)
        assertThat(response.users()[0].statusesCount()).contains(11834L)
        assertThat(response.users()[0].superFollowEligible()).contains(false)
        assertThat(response.users()[0].url()).contains("http://spacex.com")
        assertThat(response.users()[0].verified()).contains(true)
        assertThat(response.users()[0].verifiedType()).contains("Business")
        assertThat(response.users()[0]._additionalProperties()).isEmpty()
        assertThat(response.users()[1].id()).isEqualTo("20536157")
        assertThat(response.users()[1].name()).isEqualTo("Google")
        assertThat(response.users()[1].username()).isEqualTo("Google")
        assertThat(response.users()[1].contactInfo().get().links().get()).hasSize(1)
        assertThat(response.users()[1].contactInfo().get().links().get()[0].network())
            .isEqualTo("website")
        assertThat(response.users()[1].contactInfo().get().links().get()[0].source())
            .isEqualTo(UserProfile.ContactInfo.Link.Source.URL)
        assertThat(response.users()[1].contactInfo().get().links().get()[0].url())
            .isEqualTo("https://blog.google/newsletter-subscribe/")
        assertThat(response.users()[1].contactInfo().get().links().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(response.users()[1].contactInfo().get()._additionalProperties()).isEmpty()
        assertThat(response.users()[1].coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/20536157/1780004508")
        assertThat(response.users()[1].createdAt()).contains("Tue Feb 10 19:14:39 +0000 2009")
        assertThat(response.users()[1].description()).contains("Here to help.")
        assertThat(response.users()[1].favouritesCount()).contains(5327L)
        assertThat(response.users()[1].followers()).contains(31909314L)
        assertThat(response.users()[1].following()).contains(298L)
        assertThat(response.users()[1].hasGraduatedAccess()).contains(true)
        assertThat(response.users()[1].isBlueVerified()).contains(true)
        assertThat(response.users()[1].isVerified()).contains(true)
        assertThat(response.users()[1].location()).contains("Mountain View, CA")
        assertThat(response.users()[1].mediaCount()).contains(38271L)
        assertThat(response.users()[1].parodyCommentaryFanLabel()).contains("None")
        assertThat(response.users()[1].pinnedTweetIds().get())
            .containsExactly("2105388143902175529")
        assertThat(response.users()[1].possiblySensitive()).contains(false)
        assertThat(response.users()[1].profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/20536157/1780004508")
        assertThat(response.users()[1].profileDescriptionLanguage()).contains("en")
        assertThat(response.users()[1].profileImageShape()).contains("Square")
        assertThat(response.users()[1].profilePicture())
            .contains(
                "https://pbs.twimg.com/profile_images/2042749771337564160/AgOFPEL3_normal.jpg"
            )
        assertThat(response.users()[1].profilePictureOriginal())
            .contains("https://pbs.twimg.com/profile_images/2042749771337564160/AgOFPEL3.jpg")
        assertThat(response.users()[1].profileTranslatorType()).contains("regular")
        assertThat(response.users()[1].protected_()).contains(false)
        assertThat(response.users()[1].statusesCount()).contains(251787L)
        assertThat(response.users()[1].superFollowEligible()).contains(false)
        assertThat(response.users()[1].url()).contains("https://blog.google/newsletter-subscribe/")
        assertThat(response.users()[1].verified()).contains(true)
        assertThat(response.users()[1].verifiedType()).contains("Business")
        assertThat(response.users()[1]._additionalProperties()).isEmpty()
        assertThat(response._additionalProperties()).isEmpty()
    }

    @Test
    fun getThreadParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/tweets/1234567890/thread"))
                .willReturn(okJson(paginatedTweetsExampleGetQuotes))
        )
        val params =
            TweetGetThreadParams.builder()
                .id("1234567890")
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
                .minFaves(30L)
                .minLikes(31L)
                .minQuotes(32L)
                .minReplies(33L)
                .minRetweets(34L)
                .minViews(35L)
                .nativeRetweets(true)
                .omit("entities,media")
                .pageSize(38L)
                .quotesOfTweetId("quotesOfTweetId-sample")
                .retweetsOfTweetId("retweetsOfTweetId-sample")
                .sinceId("sinceId-sample")
                .toUser("toUser-sample")
                .url("url-sample")
                .verifiedOnly(true)
                .withinTime("7d")
                .build()

        val response = client.x().tweets().getThread(params)
        val asyncResponse = asyncClient.x().tweets().getThread(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/tweets/1234567890/thread"))
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
                .withQueryParam("minFaves", equalTo("30"))
                .withQueryParam("minLikes", equalTo("31"))
                .withQueryParam("minQuotes", equalTo("32"))
                .withQueryParam("minReplies", equalTo("33"))
                .withQueryParam("minRetweets", equalTo("34"))
                .withQueryParam("minViews", equalTo("35"))
                .withQueryParam("nativeRetweets", equalTo("true"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("pageSize", equalTo("38"))
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

        private val paginatedTweetsExampleGetQuotes =
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

        private val paginatedTweetsExampleList =
            """
            {
              "tweets": [
                {
                  "id": "1234567890",
                  "text": "Just launched our new feature!",
                  "createdAt": "2025-01-15T12:00:00Z",
                  "likeCount": 42,
                  "retweetCount": 5,
                  "replyCount": 3,
                  "quoteCount": 1,
                  "viewCount": 1500,
                  "bookmarkCount": 2,
                  "author": {
                    "id": "9876543210",
                    "username": "elonmusk",
                    "name": "Elon Musk",
                    "verified": true
                  }
                }
              ],
              "has_next_page": false,
              "next_cursor": ""
            }
            """
                .trimIndent()

        private val paginatedUsersExample =
            """
            {
              "users": [
                {
                  "id": "34743251",
                  "username": "SpaceX",
                  "name": "SpaceX",
                  "followers": 41936873,
                  "following": 127,
                  "verified": true,
                  "isBlueVerified": true,
                  "isVerified": true,
                  "profilePicture": "https://pbs.twimg.com/profile_images/1697749409851985920/HbrI04tM_normal.jpg",
                  "profilePictureOriginal": "https://pbs.twimg.com/profile_images/1697749409851985920/HbrI04tM.jpg",
                  "coverPicture": "https://pbs.twimg.com/profile_banners/34743251/1681251194",
                  "profileBannerUrl": "https://pbs.twimg.com/profile_banners/34743251/1681251194",
                  "description": "SpaceX designs, manufactures and launches the world's most advanced rockets and spacecraft",
                  "location": "Earth",
                  "createdAt": "Thu Apr 23 21:53:30 +0000 2009",
                  "statusesCount": 11834,
                  "mediaCount": 4713,
                  "protected": false,
                  "url": "http://spacex.com",
                  "contactInfo": {
                    "links": [
                      {
                        "url": "http://spacex.com",
                        "network": "website",
                        "source": "url"
                      }
                    ]
                  },
                  "favouritesCount": 529,
                  "possiblySensitive": false,
                  "pinnedTweetIds": [
                    "2104354931595423762"
                  ],
                  "verifiedType": "Business",
                  "profile_bio": {
                    "description": "SpaceX designs, manufactures and launches the world's most advanced rockets and spacecraft",
                    "entities": {
                      "description": {},
                      "url": {
                        "urls": [
                          {
                            "display_url": "spacex.com",
                            "expanded_url": "http://spacex.com",
                            "indices": [
                              0,
                              23
                            ],
                            "url": "https://t.co/VOJ6qEctND"
                          }
                        ]
                      }
                    }
                  },
                  "hasGraduatedAccess": true,
                  "parodyCommentaryFanLabel": "None",
                  "professional": {
                    "category": [],
                    "professional_type": "Business",
                    "rest_id": "1681839322029502464"
                  },
                  "profileDescriptionLanguage": "en",
                  "profileImageShape": "Square",
                  "profileTranslatorType": "none",
                  "superFollowEligible": false
                },
                {
                  "id": "20536157",
                  "username": "Google",
                  "name": "Google",
                  "followers": 31909314,
                  "following": 298,
                  "verified": true,
                  "isBlueVerified": true,
                  "isVerified": true,
                  "profilePicture": "https://pbs.twimg.com/profile_images/2042749771337564160/AgOFPEL3_normal.jpg",
                  "profilePictureOriginal": "https://pbs.twimg.com/profile_images/2042749771337564160/AgOFPEL3.jpg",
                  "coverPicture": "https://pbs.twimg.com/profile_banners/20536157/1780004508",
                  "profileBannerUrl": "https://pbs.twimg.com/profile_banners/20536157/1780004508",
                  "description": "Here to help.",
                  "location": "Mountain View, CA",
                  "createdAt": "Tue Feb 10 19:14:39 +0000 2009",
                  "statusesCount": 251787,
                  "mediaCount": 38271,
                  "protected": false,
                  "url": "https://blog.google/newsletter-subscribe/",
                  "contactInfo": {
                    "links": [
                      {
                        "url": "https://blog.google/newsletter-subscribe/",
                        "network": "website",
                        "source": "url"
                      }
                    ]
                  },
                  "favouritesCount": 5327,
                  "possiblySensitive": false,
                  "pinnedTweetIds": [
                    "2105388143902175529"
                  ],
                  "verifiedType": "Business",
                  "profile_bio": {
                    "description": "Here to help.",
                    "entities": {
                      "description": {},
                      "url": {
                        "urls": [
                          {
                            "display_url": "blog.google/newsletter-sub…",
                            "expanded_url": "https://blog.google/newsletter-subscribe/",
                            "indices": [
                              0,
                              23
                            ],
                            "url": "https://t.co/RS3iU87BGe"
                          }
                        ]
                      }
                    }
                  },
                  "hasGraduatedAccess": true,
                  "parodyCommentaryFanLabel": "None",
                  "professional": {
                    "category": [
                      {
                        "icon_name": "IconBriefcaseStroke",
                        "id": 713,
                        "name": "Science & Technology"
                      }
                    ],
                    "professional_type": "Business",
                    "rest_id": "1504886752259059716"
                  },
                  "profileDescriptionLanguage": "en",
                  "profileImageShape": "Square",
                  "profileTranslatorType": "regular",
                  "superFollowEligible": false
                }
              ],
              "has_next_page": false,
              "next_cursor": ""
            }
            """
                .trimIndent()

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
                    "hashtags": [],
                    "urls": [],
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
                    "hashtags": [],
                    "urls": [],
                    "user_mentions": []
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
