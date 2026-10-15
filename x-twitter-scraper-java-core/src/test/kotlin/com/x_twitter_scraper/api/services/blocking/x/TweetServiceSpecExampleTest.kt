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
import com.x_twitter_scraper.api.models.x.tweets.TweetCheckRepostParams
import com.x_twitter_scraper.api.models.x.tweets.TweetEmbedParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetHiddenRepliesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetInsightsParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetRetweeterIdsParams
import com.x_twitter_scraper.api.models.x.tweets.TweetGetSubtitlesParams
import com.x_twitter_scraper.api.models.x.tweets.TweetListTopParams
import com.x_twitter_scraper.api.models.x.tweets.TweetResolveLinksParams
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
