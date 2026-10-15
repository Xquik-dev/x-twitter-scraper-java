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
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.models.x.users.UserRetrieveAffiliatesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveArticlesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveBatchTweetsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowerIdsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowingIdsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveHighlightsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveInsightsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveListMembershipsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveListsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveLiveParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSimilarParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSubscriptionsParams
import com.x_twitter_scraper.api.models.x.users.UserTranslateBioParams
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class UserServiceSpecExampleTest {

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
    fun retrieveAffiliatesParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/affiliates"))
                .willReturn(okJson(paginatedUsersExample))
        )
        val params =
            UserRetrieveAffiliatesParams.builder()
                .id("1234567890")
                .emailDomains("acme.com,stanford.edu")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().users().retrieveAffiliates(params)
        val asyncResponse = asyncClient.x().users().retrieveAffiliates(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/affiliates"))
                .withQueryParam("emailDomains", equalTo("acme.com,stanford.edu"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.users()).hasSize(2)
        assertThat(response.users()[0].id()).isEqualTo("34743251")
        assertThat(response.users()[0].username()).isEqualTo("SpaceX")
    }

    @Test
    fun retrieveArticlesParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/articles"))
                .willReturn(okJson(paginatedTweetsExample))
        )
        val params =
            UserRetrieveArticlesParams.builder()
                .id("1234567890")
                .fields("id,text,author.username")
                .mediaType(UserRetrieveArticlesParams.MediaType.IMAGES)
                .omit("entities,media")
                .quotes(UserRetrieveArticlesParams.Quotes.INCLUDE)
                .replies(UserRetrieveArticlesParams.Replies.INCLUDE)
                .retweets(UserRetrieveArticlesParams.Retweets.INCLUDE)
                .withinTime("7d")
                .build()

        val response = client.x().users().retrieveArticles(params)
        val asyncResponse = asyncClient.x().users().retrieveArticles(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/articles"))
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
    fun retrieveBatchTweetsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/batch/tweets"))
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
                          "has_next_page": false,
                          "next_cursor": "",
                          "unavailable_ids": [
                            "1234567890"
                          ],
                          "unprocessed_ids": []
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            UserRetrieveBatchTweetsParams.builder()
                .fields("id,text,author.username")
                .omit("entities,media")
                .usernames("nasa,@OpenAI,x.com/verge")
                .build()

        val response = client.x().users().retrieveBatchTweets(params)
        val asyncResponse = asyncClient.x().users().retrieveBatchTweets(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/batch/tweets"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("usernames", equalTo("nasa,@OpenAI,x.com/verge")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response._hasNextPage()).isEqualTo(JsonValue.from(false))
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.tweets()).hasSize(1)
        assertThat(response.tweets()[0].id()).isEqualTo("1234567890")
        assertThat(response.tweets()[0].text()).isEqualTo("Just launched our new feature!")
        assertThat(response.unavailableIds()).containsExactly("1234567890")
        assertThat(response.unprocessedIds()).isEmpty()
    }

    @Test
    fun retrieveFollowerIdsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/follower-ids"))
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
        val params = UserRetrieveFollowerIdsParams.builder().id("1234567890").build()

        val response = client.x().users().retrieveFollowerIds(params)
        val asyncResponse = asyncClient.x().users().retrieveFollowerIds(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/follower-ids")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(true)
        assertThat(response.ids()).containsExactly("9876543210", "44196397")
        assertThat(response.nextCursor()).isEqualTo("1878079982871151535")
    }

    @Test
    fun retrieveFollowingIdsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/following-ids"))
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
        val params = UserRetrieveFollowingIdsParams.builder().id("1234567890").build()

        val response = client.x().users().retrieveFollowingIds(params)
        val asyncResponse = asyncClient.x().users().retrieveFollowingIds(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/following-ids")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(true)
        assertThat(response.ids()).containsExactly("9876543210", "44196397")
        assertThat(response.nextCursor()).isEqualTo("1878079982871151535")
    }

    @Test
    fun retrieveHighlightsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/highlights"))
                .willReturn(okJson(paginatedTweetsExample))
        )
        val params =
            UserRetrieveHighlightsParams.builder()
                .id("1234567890")
                .fields("id,text,author.username")
                .mediaType(UserRetrieveHighlightsParams.MediaType.IMAGES)
                .omit("entities,media")
                .quotes(UserRetrieveHighlightsParams.Quotes.INCLUDE)
                .replies(UserRetrieveHighlightsParams.Replies.INCLUDE)
                .retweets(UserRetrieveHighlightsParams.Retweets.INCLUDE)
                .withinTime("7d")
                .build()

        val response = client.x().users().retrieveHighlights(params)
        val asyncResponse = asyncClient.x().users().retrieveHighlights(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/highlights"))
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
    fun retrieveInsightsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/insights"))
                .willReturn(
                    okJson(
                        """
                        {
                          "insights": {
                            "userId": "11348282",
                            "userName": "NASA",
                            "followers": 92376187,
                            "following": 115,
                            "posts": 74336,
                            "accountAgeDays": 6858,
                            "postsPrivate": false,
                            "sample": {
                              "posts": 10,
                              "oldestAt": "2026-09-23T13:15:28.000Z",
                              "newestAt": "2026-09-28T22:12:05.000Z"
                            },
                            "averages": {
                              "likes": 3684.2,
                              "replies": 142.7,
                              "reposts": 459.8,
                              "quotes": 45,
                              "bookmarks": 209.7,
                              "views": 785247.8,
                              "engagements": 4331.7
                            },
                            "engagementRate": 0.0047,
                            "engagementPerView": 0.5516,
                            "postsPerDay": 1.6814,
                            "topPostId": "2102761519985332442"
                          },
                          "message": "This account's posts are private, so the report has its counts only."
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            UserRetrieveInsightsParams.builder()
                .id("1234567890")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().users().retrieveInsights(params)
        val asyncResponse = asyncClient.x().users().retrieveInsights(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/insights"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.insights().accountAgeDays()).contains(6858.0)
        assertThat(response.insights().averages().get().bookmarks()).isEqualTo(209.7)
        assertThat(response.insights().averages().get().engagements()).isEqualTo(4331.7)
        assertThat(response.insights().averages().get().likes()).isEqualTo(3684.2)
        assertThat(response.insights().averages().get().quotes()).isEqualTo(45.0)
        assertThat(response.insights().averages().get().replies()).isEqualTo(142.7)
        assertThat(response.insights().averages().get().reposts()).isEqualTo(459.8)
        assertThat(response.insights().averages().get().views()).isEqualTo(785247.8)
        assertThat(response.insights().engagementPerView()).contains(0.5516)
        assertThat(response.insights().engagementRate()).contains(0.0047)
        assertThat(response.insights().followers()).isEqualTo(92376187.0)
        assertThat(response.insights().following()).isEqualTo(115.0)
        assertThat(response.insights().posts()).isEqualTo(74336.0)
        assertThat(response.insights().postsPerDay()).contains(1.6814)
        assertThat(response.insights().postsPrivate()).isEqualTo(false)
        assertThat(response.insights().sample().newestAt())
            .contains(OffsetDateTime.parse("2026-09-28T22:12:05.000Z"))
        assertThat(response.insights().sample().oldestAt())
            .contains(OffsetDateTime.parse("2026-09-23T13:15:28.000Z"))
        assertThat(response.insights().sample().posts()).isEqualTo(10.0)
        assertThat(response.insights().topPostId()).contains("2102761519985332442")
        assertThat(response.insights().userId()).isEqualTo("11348282")
        assertThat(response.insights().userName()).isEqualTo("NASA")
        assertThat(response.message())
            .contains("This account's posts are private, so the report has its counts only.")
    }

    @Test
    fun retrieveListMembershipsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/list-memberships"))
                .willReturn(
                    okJson(
                        """
                        {
                          "lists": [
                            {
                              "id": "4143408",
                              "name": "NASA Centers",
                              "description": "NASA has 10 centers http://www.nasa.gov/about/sites",
                              "memberCount": 11,
                              "subscriberCount": 859,
                              "owner": {
                                "id": "11348282",
                                "username": "NASA",
                                "name": "NASA",
                                "followers": 92379503,
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
                                "statusesCount": 74372,
                                "mediaCount": 28176,
                                "protected": false,
                                "url": "http://www.nasa.gov/",
                                "favouritesCount": 17012,
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
                              },
                              "url": "https://x.com/i/lists/4143408",
                              "createdAt": "2009-12-02T22:41:02.000Z",
                              "defaultBanner": {
                                "height": 375,
                                "salientRect": {
                                  "height": 1,
                                  "left": 562,
                                  "top": 187,
                                  "width": 1
                                },
                                "url": "https://pbs.twimg.com/media/GkIOx3HW4AAHAs6.png",
                                "width": 1125
                              },
                              "membersContext": "11 members"
                            }
                          ],
                          "has_next_page": false,
                          "next_cursor": ""
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            UserRetrieveListMembershipsParams.builder()
                .id("1234567890")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().users().retrieveListMemberships(params)
        val asyncResponse = asyncClient.x().users().retrieveListMemberships(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/list-memberships"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.lists()).hasSize(1)
        assertThat(response.lists()[0].id()).isEqualTo("4143408")
        assertThat(response.lists()[0].name()).isEqualTo("NASA Centers")
        assertThat(response.lists()[0].createdAt())
            .contains(OffsetDateTime.parse("2009-12-02T22:41:02.000Z"))
        assertThat(response.lists()[0].defaultBanner().get().url())
            .isEqualTo("https://pbs.twimg.com/media/GkIOx3HW4AAHAs6.png")
        assertThat(response.lists()[0].defaultBanner().get().height()).contains(375L)
        assertThat(response.lists()[0].defaultBanner().get().salientRect().get().height())
            .contains(1L)
        assertThat(response.lists()[0].defaultBanner().get().salientRect().get().left())
            .contains(562L)
        assertThat(response.lists()[0].defaultBanner().get().salientRect().get().top())
            .contains(187L)
        assertThat(response.lists()[0].defaultBanner().get().salientRect().get().width())
            .contains(1L)
        assertThat(response.lists()[0].defaultBanner().get().width()).contains(1125L)
        assertThat(response.lists()[0].description())
            .contains("NASA has 10 centers http://www.nasa.gov/about/sites")
        assertThat(response.lists()[0].memberCount()).contains(11L)
        assertThat(response.lists()[0].membersContext()).contains("11 members")
        assertThat(response.lists()[0].owner().get().id()).isEqualTo("11348282")
        assertThat(response.lists()[0].owner().get().username()).isEqualTo("NASA")
        assertThat(response.lists()[0].owner().get().name()).isEqualTo("NASA")
        assertThat(response.lists()[0].subscriberCount()).contains(859L)
        assertThat(response.lists()[0].url()).contains("https://x.com/i/lists/4143408")
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.lists()[0].bannerUrl()).isEmpty
        assertThat(response.lists()[0].customBanner()).isEmpty
        assertThat(response.lists()[0].defaultBanner().get().mediaId()).isEmpty
        assertThat(response.lists()[0].defaultBanner().get().mediaKey()).isEmpty
        assertThat(response.lists()[0].defaultBanner().get().palette()).isEmpty
        assertThat(response.lists()[0].facepileUrls()).isEmpty
    }

    @Test
    fun retrieveListsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/lists"))
                .willReturn(
                    okJson(
                        """
                        {
                          "lists": [
                            {
                              "id": "4143408",
                              "name": "NASA Centers",
                              "description": "NASA has 10 centers http://www.nasa.gov/about/sites",
                              "memberCount": 11,
                              "subscriberCount": 859,
                              "owner": {
                                "id": "11348282",
                                "username": "NASA",
                                "name": "NASA",
                                "followers": 92379503,
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
                                "statusesCount": 74372,
                                "mediaCount": 28176,
                                "protected": false,
                                "url": "http://www.nasa.gov/",
                                "favouritesCount": 17012,
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
                              },
                              "url": "https://x.com/i/lists/4143408",
                              "createdAt": "2009-12-02T22:41:02.000Z",
                              "defaultBanner": {
                                "height": 375,
                                "salientRect": {
                                  "height": 1,
                                  "left": 562,
                                  "top": 187,
                                  "width": 1
                                },
                                "url": "https://pbs.twimg.com/media/GkIOx3HW4AAHAs6.png",
                                "width": 1125
                              },
                              "membersContext": "11 members"
                            }
                          ],
                          "has_next_page": false,
                          "next_cursor": ""
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            UserRetrieveListsParams.builder()
                .id("1234567890")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().users().retrieveLists(params)
        val asyncResponse = asyncClient.x().users().retrieveLists(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/lists"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.lists()).hasSize(1)
        assertThat(response.lists()[0].id()).isEqualTo("4143408")
        assertThat(response.lists()[0].name()).isEqualTo("NASA Centers")
        assertThat(response.lists()[0].createdAt())
            .contains(OffsetDateTime.parse("2009-12-02T22:41:02.000Z"))
        assertThat(response.lists()[0].defaultBanner().get().url())
            .isEqualTo("https://pbs.twimg.com/media/GkIOx3HW4AAHAs6.png")
        assertThat(response.lists()[0].defaultBanner().get().height()).contains(375L)
        assertThat(response.lists()[0].defaultBanner().get().salientRect().get().height())
            .contains(1L)
        assertThat(response.lists()[0].defaultBanner().get().salientRect().get().left())
            .contains(562L)
        assertThat(response.lists()[0].defaultBanner().get().salientRect().get().top())
            .contains(187L)
        assertThat(response.lists()[0].defaultBanner().get().salientRect().get().width())
            .contains(1L)
        assertThat(response.lists()[0].defaultBanner().get().width()).contains(1125L)
        assertThat(response.lists()[0].description())
            .contains("NASA has 10 centers http://www.nasa.gov/about/sites")
        assertThat(response.lists()[0].memberCount()).contains(11L)
        assertThat(response.lists()[0].membersContext()).contains("11 members")
        assertThat(response.lists()[0].owner().get().id()).isEqualTo("11348282")
        assertThat(response.lists()[0].owner().get().username()).isEqualTo("NASA")
        assertThat(response.lists()[0].owner().get().name()).isEqualTo("NASA")
        assertThat(response.lists()[0].subscriberCount()).contains(859L)
        assertThat(response.lists()[0].url()).contains("https://x.com/i/lists/4143408")
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.lists()[0].bannerUrl()).isEmpty
        assertThat(response.lists()[0].customBanner()).isEmpty
        assertThat(response.lists()[0].defaultBanner().get().mediaId()).isEmpty
        assertThat(response.lists()[0].defaultBanner().get().mediaKey()).isEmpty
        assertThat(response.lists()[0].defaultBanner().get().palette()).isEmpty
        assertThat(response.lists()[0].facepileUrls()).isEmpty
    }

    @Test
    fun retrieveLiveParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/live"))
                .willReturn(
                    okJson(
                        """
                        {
                          "live": false,
                          "userId": "11348282",
                          "userName": "NASA",
                          "broadcast": {
                            "id": "1DxLdZyVPMMxm",
                            "title": "NASA's SpaceX Crew-12 Re-Entry & Splashdown",
                            "state": "Ended",
                            "startedAt": "2026-10-08T14:20:33.863Z",
                            "endedAt": "2026-10-08T16:38:16.770Z",
                            "totalWatched": 220908,
                            "totalWatching": 119617,
                            "width": 3840,
                            "height": 2160
                          }
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            UserRetrieveLiveParams.builder()
                .id("1234567890")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().users().retrieveLive(params)
        val asyncResponse = asyncClient.x().users().retrieveLive(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/live"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.broadcast().get().id()).isEqualTo("1DxLdZyVPMMxm")
        assertThat(response.broadcast().get().endedAt())
            .contains(OffsetDateTime.parse("2026-10-08T16:38:16.770Z"))
        assertThat(response.broadcast().get().height()).contains(2160L)
        assertThat(response.broadcast().get().startedAt())
            .contains(OffsetDateTime.parse("2026-10-08T14:20:33.863Z"))
        assertThat(response.broadcast().get().state()).contains("Ended")
        assertThat(response.broadcast().get().title())
            .contains("NASA's SpaceX Crew-12 Re-Entry & Splashdown")
        assertThat(response.broadcast().get().totalWatched()).contains(220908L)
        assertThat(response.broadcast().get().totalWatching()).contains(119617L)
        assertThat(response.broadcast().get().width()).contains(3840L)
        assertThat(response.live()).isEqualTo(false)
        assertThat(response.userId()).isEqualTo("11348282")
        assertThat(response.userName()).isEqualTo("NASA")
        assertThat(response.broadcast().get().cameraRotation()).isEmpty
        assertThat(response.broadcast().get().chatOption()).isEmpty
        assertThat(response.broadcast().get().creator()).isEmpty
        assertThat(response.broadcast().get().isAvailableForReplay()).isEmpty
        assertThat(response.broadcast().get().isHighLatency()).isEmpty
        assertThat(response.broadcast().get().isPrivateChat()).isEmpty
        assertThat(response.broadcast().get().isTitleEdited()).isEmpty
        assertThat(response.broadcast().get().lastPingAt()).isEmpty
        assertThat(response.broadcast().get().mediaKey()).isEmpty
        assertThat(response.broadcast().get().periscopeUser()).isEmpty
        assertThat(response.broadcast().get().preLiveSlateUrl()).isEmpty
        assertThat(response.broadcast().get().scheduledStart()).isEmpty
        assertThat(response.broadcast().get().source()).isEmpty
        assertThat(response.broadcast().get().tweet()).isEmpty
        assertThat(response.broadcast().get().tweetId()).isEmpty
        assertThat(response.broadcast().get().version()).isEmpty
    }

    @Test
    fun retrieveSimilarParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/similar"))
                .willReturn(okJson(paginatedUsersExample))
        )
        val params =
            UserRetrieveSimilarParams.builder()
                .id("1234567890")
                .emailDomains("acme.com,stanford.edu")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().users().retrieveSimilar(params)
        val asyncResponse = asyncClient.x().users().retrieveSimilar(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/similar"))
                .withQueryParam("emailDomains", equalTo("acme.com,stanford.edu"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.users()).hasSize(2)
        assertThat(response.users()[0].id()).isEqualTo("34743251")
        assertThat(response.users()[0].username()).isEqualTo("SpaceX")
    }

    @Test
    fun retrieveSubscriptionsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/subscriptions"))
                .willReturn(okJson(paginatedUsersExample))
        )
        val params =
            UserRetrieveSubscriptionsParams.builder()
                .id("1234567890")
                .emailDomains("acme.com,stanford.edu")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().users().retrieveSubscriptions(params)
        val asyncResponse = asyncClient.x().users().retrieveSubscriptions(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/subscriptions"))
                .withQueryParam("emailDomains", equalTo("acme.com,stanford.edu"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.users()).hasSize(2)
        assertThat(response.users()[0].id()).isEqualTo("34743251")
        assertThat(response.users()[0].username()).isEqualTo("SpaceX")
    }

    @Test
    fun translateBioParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/translation"))
                .willReturn(
                    okJson(
                        """
                        {
                          "translation": {
                            "userId": "11348282",
                            "userName": "NASA",
                            "language": "es",
                            "sourceLanguage": "en",
                            "text": "Haciendo lo aparentemente imposible, posible. ✨",
                            "entities": {}
                          }
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            UserTranslateBioParams.builder()
                .id("1234567890")
                .language("es")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().users().translateBio(params)
        val asyncResponse = asyncClient.x().users().translateBio(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/translation"))
                .withQueryParam("language", equalTo("es"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.translation().get().language()).isEqualTo("es")
        assertThat(response.translation().get().text())
            .isEqualTo("Haciendo lo aparentemente imposible, posible. ✨")
        assertThat(response.translation().get().userId()).isEqualTo("11348282")
        assertThat(response.translation().get().userName()).isEqualTo("NASA")
        assertThat(response.translation().get().sourceLanguage()).contains("en")
        assertThat(response.translation().get().entities().hashtags()).isEmpty
        assertThat(response.translation().get().entities().smarttags()).isEmpty
        assertThat(response.translation().get().entities().symbols()).isEmpty
        assertThat(response.translation().get().entities().timestamps()).isEmpty
        assertThat(response.translation().get().entities().urls()).isEmpty
        assertThat(response.translation().get().entities().userMentions()).isEmpty
        assertThat(response.message()).isEmpty
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
    }
}
