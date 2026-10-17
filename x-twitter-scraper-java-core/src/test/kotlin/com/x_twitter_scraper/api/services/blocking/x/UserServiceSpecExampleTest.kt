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
import com.x_twitter_scraper.api.models.TweetMedia
import com.x_twitter_scraper.api.models.UserProfile
import com.x_twitter_scraper.api.models.x.users.UserRetrieveAffiliatesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveArticlesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveBatchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveBatchTweetsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowerIdsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersYouKnowParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowingIdsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowingParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveHighlightsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveInsightsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveLikesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveListMembershipsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveListsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveLiveParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMediaParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMentionsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveRepliesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSearchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSimilarParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSubscriptionsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveTweetsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveVerifiedFollowersParams
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

    @Test
    fun retrieveBatchParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/batch"))
                .willReturn(
                    okJson(
                        """
                        {
                          "users": [
                            {
                              "id": "9876543210",
                              "username": "elonmusk",
                              "name": "Elon Musk"
                            }
                          ],
                          "has_next_page": false,
                          "next_cursor": "",
                          "requested_count": 2,
                          "processed_count": 2,
                          "returned_count": 1,
                          "unavailable_ids": [
                            "1234567890"
                          ],
                          "failed_ids": [
                            "string"
                          ],
                          "unprocessed_ids": [
                            "string"
                          ]
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            UserRetrieveBatchParams.builder()
                .ids("ids-sample")
                .bioContains("bioContains-sample")
                .blueVerifiedOnly(true)
                .businessEmailOnly(true)
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
                .usernameContains("usernameContains-sample")
                .usernames("nasa,@OpenAI,x.com/verge")
                .verifiedOnly(true)
                .verifiedType("verifiedType-sample")
                .build()

        val response = client.x().users().retrieveBatch(params)
        val asyncResponse = asyncClient.x().users().retrieveBatch(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/batch"))
                .withQueryParam("ids", equalTo("ids-sample"))
                .withQueryParam("bioContains", equalTo("bioContains-sample"))
                .withQueryParam("blueVerifiedOnly", equalTo("true"))
                .withQueryParam("businessEmailOnly", equalTo("true"))
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
                .withQueryParam("usernameContains", equalTo("usernameContains-sample"))
                .withQueryParam("usernames", equalTo("nasa,@OpenAI,x.com/verge"))
                .withQueryParam("verifiedOnly", equalTo("true"))
                .withQueryParam("verifiedType", equalTo("verifiedType-sample")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.failedIds().get()).containsExactly("string")
        assertThat(response._hasNextPage()).isEqualTo(JsonValue.from(false))
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.processedCount()).isEqualTo(2L)
        assertThat(response.requestedCount()).isEqualTo(2L)
        assertThat(response.returnedCount()).isEqualTo(1L)
        assertThat(response.unavailableIds()).containsExactly("1234567890")
        assertThat(response.unprocessedIds()).containsExactly("string")
        assertThat(response.users()).hasSize(1)
        assertThat(response.users()[0].id()).isEqualTo("9876543210")
        assertThat(response.users()[0].name()).isEqualTo("Elon Musk")
        assertThat(response.users()[0].username()).isEqualTo("elonmusk")
        assertThat(response.users()[0]._additionalProperties()).isEmpty()
        assertThat(response._additionalProperties()).isEmpty()
        assertThat(response.filteredCount()).isEmpty
    }

    @Test
    fun retrieveSearchParsesTheSpecExample() {
        stubFor(get(urlPathEqualTo("/x/users/search")).willReturn(okJson(paginatedUsersExample)))
        val params =
            UserRetrieveSearchParams.builder()
                .q("q-sample")
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

        val response = client.x().users().retrieveSearch(params)
        val asyncResponse = asyncClient.x().users().retrieveSearch(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/search"))
                .withQueryParam("q", equalTo("q-sample"))
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
    fun retrieveParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890"))
                .willReturn(
                    okJson(
                        """
                        {
                          "id": "9876543210",
                          "username": "elonmusk",
                          "name": "Elon Musk",
                          "description": "CEO of Tesla, SpaceX, and X",
                          "followers": 150000000,
                          "following": 500,
                          "verified": true
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            UserRetrieveParams.builder()
                .id("1234567890")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().users().retrieve(params)
        val asyncResponse = asyncClient.x().users().retrieve(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.id()).isEqualTo("9876543210")
        assertThat(response.name()).isEqualTo("Elon Musk")
        assertThat(response.username()).isEqualTo("elonmusk")
        assertThat(response.description()).contains("CEO of Tesla, SpaceX, and X")
        assertThat(response.followers()).contains(150000000L)
        assertThat(response.following()).contains(500L)
        assertThat(response.verified()).contains(true)
        assertThat(response._additionalProperties()).isEmpty()
    }

    @Test
    fun retrieveFollowersParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/followers"))
                .willReturn(
                    okJson(
                        """
                        {
                          "users": [
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
            UserRetrieveFollowersParams.builder()
                .id("1234567890")
                .after("after-sample")
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
                .limit(21L)
                .locationContains("locationContains-sample")
                .maxFollowers(23L)
                .maxFollowing(24L)
                .maxScan(10000L)
                .maxStatuses(26L)
                .minAccountAgeDays(27L)
                .minFollowers(28L)
                .minFollowing(29L)
                .minStatuses(30L)
                .omit("entities,media")
                .pageSize(33L)
                .usernameContains("usernameContains-sample")
                .verifiedOnly(true)
                .verifiedType("verifiedType-sample")
                .build()

        val response = client.x().users().retrieveFollowers(params)
        val asyncResponse = asyncClient.x().users().retrieveFollowers(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/followers"))
                .withQueryParam("after", equalTo("after-sample"))
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
                .withQueryParam("limit", equalTo("21"))
                .withQueryParam("locationContains", equalTo("locationContains-sample"))
                .withQueryParam("maxFollowers", equalTo("23"))
                .withQueryParam("maxFollowing", equalTo("24"))
                .withQueryParam("maxScan", equalTo("10000"))
                .withQueryParam("maxStatuses", equalTo("26"))
                .withQueryParam("minAccountAgeDays", equalTo("27"))
                .withQueryParam("minFollowers", equalTo("28"))
                .withQueryParam("minFollowing", equalTo("29"))
                .withQueryParam("minStatuses", equalTo("30"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("pageSize", equalTo("33"))
                .withQueryParam("usernameContains", equalTo("usernameContains-sample"))
                .withQueryParam("verifiedOnly", equalTo("true"))
                .withQueryParam("verifiedType", equalTo("verifiedType-sample")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.isPaginatedUsers()).isTrue()
        assertThat(response.asPaginatedUsers().hasNextPage()).isEqualTo(false)
        assertThat(response.asPaginatedUsers().nextCursor()).isEqualTo("")
        assertThat(response.asPaginatedUsers().users()).hasSize(1)
        assertThat(response.asPaginatedUsers().users()[0].id()).isEqualTo("11348282")
        assertThat(response.asPaginatedUsers().users()[0].name()).isEqualTo("NASA")
        assertThat(response.asPaginatedUsers().users()[0].username()).isEqualTo("NASA")
        assertThat(response.asPaginatedUsers().users()[0].accountBasedIn()).isEmpty
        assertThat(response.asPaginatedUsers().users()[0].birthdate().get().day()).contains(1L)
        assertThat(response.asPaginatedUsers().users()[0].birthdate().get().month()).contains(10L)
        assertThat(response.asPaginatedUsers().users()[0].birthdate().get().year()).contains(1958L)
        assertThat(response.asPaginatedUsers().users()[0].birthdate().get()._additionalProperties())
            .isEmpty()
        assertThat(response.asPaginatedUsers().users()[0].businessAccountAffiliatesCount())
            .contains(85L)
        assertThat(response.asPaginatedUsers().users()[0].contactInfo().get().links().get())
            .hasSize(1)
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .contactInfo()
                    .get()
                    .links()
                    .get()[0]
                    .network()
            )
            .isEqualTo("website")
        assertThat(
                response.asPaginatedUsers().users()[0].contactInfo().get().links().get()[0].source()
            )
            .isEqualTo(UserProfile.ContactInfo.Link.Source.URL)
        assertThat(
                response.asPaginatedUsers().users()[0].contactInfo().get().links().get()[0].url()
            )
            .isEqualTo("http://www.nasa.gov/")
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .contactInfo()
                    .get()
                    .links()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                response.asPaginatedUsers().users()[0].contactInfo().get()._additionalProperties()
            )
            .isEmpty()
        assertThat(response.asPaginatedUsers().users()[0].coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/11348282/1788992290")
        assertThat(response.asPaginatedUsers().users()[0].createdAt())
            .contains("Wed Dec 19 20:20:32 +0000 2007")
        assertThat(response.asPaginatedUsers().users()[0].creatorSubscriptionsCount()).contains(0L)
        assertThat(response.asPaginatedUsers().users()[0].description())
            .contains("Making the seemingly impossible, possible. ✨")
        assertThat(response.asPaginatedUsers().users()[0].favouritesCount()).contains(17003L)
        assertThat(response.asPaginatedUsers().users()[0].followers()).contains(92376187L)
        assertThat(response.asPaginatedUsers().users()[0].following()).contains(115L)
        assertThat(response.asPaginatedUsers().users()[0].hasGraduatedAccess()).contains(true)
        assertThat(response.asPaginatedUsers().users()[0].hasHiddenSubscriptionsOnProfile())
            .contains(false)
        assertThat(
                response.asPaginatedUsers().users()[0].highlightsInfo().get().canHighlightTweets()
            )
            .contains(true)
        assertThat(
                response.asPaginatedUsers().users()[0].highlightsInfo().get().highlightedTweets()
            )
            .contains("280")
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .highlightsInfo()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .identityVerification()
                    .get()
                    .isIdentityVerified()
            )
            .contains(false)
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .identityVerification()
                    .get()
                    .verifiedSinceMsec()
            )
            .contains("1249674830941")
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .identityVerification()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.asPaginatedUsers().users()[0].isBlueVerified()).contains(true)
        assertThat(response.asPaginatedUsers().users()[0].isProfileTranslatable()).contains(false)
        assertThat(response.asPaginatedUsers().users()[0].isVerified()).contains(true)
        assertThat(response.asPaginatedUsers().users()[0].location()).contains("Pale Blue Dot")
        assertThat(response.asPaginatedUsers().users()[0].mediaCount()).contains(28160L)
        assertThat(response.asPaginatedUsers().users()[0].parodyCommentaryFanLabel())
            .contains("None")
        assertThat(response.asPaginatedUsers().users()[0].possiblySensitive()).contains(false)
        assertThat(response.asPaginatedUsers().users()[0].profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/11348282/1788992290")
        assertThat(response.asPaginatedUsers().users()[0].profileDescriptionLanguage())
            .contains("en")
        assertThat(response.asPaginatedUsers().users()[0].profileImageShape()).contains("Square")
        assertThat(response.asPaginatedUsers().users()[0].profilePicture())
            .contains(
                "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_normal.jpg"
            )
        assertThat(response.asPaginatedUsers().users()[0].profilePictureOriginal())
            .contains("https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB.jpg")
        assertThat(response.asPaginatedUsers().users()[0].profileSortEnabled()).contains(true)
        assertThat(response.asPaginatedUsers().users()[0].profileTranslatorType())
            .contains("regular")
        assertThat(response.asPaginatedUsers().users()[0].protected_()).contains(false)
        assertThat(response.asPaginatedUsers().users()[0].statusesCount()).contains(74336L)
        assertThat(response.asPaginatedUsers().users()[0].superFollowEligible()).contains(false)
        assertThat(response.asPaginatedUsers().users()[0].url()).contains("http://www.nasa.gov/")
        assertThat(
                response.asPaginatedUsers().users()[0].verificationReason().get().entities().get()
            )
            .hasSize(1)
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    .entities()
                    .get()[0]
                    .fromIndex()
            )
            .contains(91L)
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    .entities()
                    .get()[0]
                    .toIndex()
            )
            .contains(101L)
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    .entities()
                    .get()[0]
                    .url()
            )
            .contains("https://help.twitter.com/en/rules-and-policies/profile-labels")
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    .entities()
                    .get()[0]
                    .urlType()
            )
            .contains("ExternalUrl")
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    .entities()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.asPaginatedUsers().users()[0].verificationReason().get().text())
            .contains(
                "This account is verified because it is a government or multilateral organization account.  Learn more"
            )
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.asPaginatedUsers().users()[0].verified()).contains(true)
        assertThat(response.asPaginatedUsers().users()[0].verifiedType()).contains("Government")
        assertThat(response.asPaginatedUsers().users()[0]._additionalProperties()).isEmpty()
        assertThat(response.asPaginatedUsers()._additionalProperties()).isEmpty()
    }

    @Test
    fun retrieveFollowersYouKnowParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/followers-you-know"))
                .willReturn(okJson(paginatedUsersExample))
        )
        val params =
            UserRetrieveFollowersYouKnowParams.builder()
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

        val response = client.x().users().retrieveFollowersYouKnow(params)
        val asyncResponse = asyncClient.x().users().retrieveFollowersYouKnow(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/followers-you-know"))
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
    fun retrieveFollowingParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/following"))
                .willReturn(
                    okJson(
                        """
                        {
                          "users": [
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
            UserRetrieveFollowingParams.builder()
                .id("1234567890")
                .after("after-sample")
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
                .limit(21L)
                .locationContains("locationContains-sample")
                .maxFollowers(23L)
                .maxFollowing(24L)
                .maxScan(10000L)
                .maxStatuses(26L)
                .minAccountAgeDays(27L)
                .minFollowers(28L)
                .minFollowing(29L)
                .minStatuses(30L)
                .omit("entities,media")
                .pageSize(33L)
                .usernameContains("usernameContains-sample")
                .verifiedOnly(true)
                .verifiedType("verifiedType-sample")
                .build()

        val response = client.x().users().retrieveFollowing(params)
        val asyncResponse = asyncClient.x().users().retrieveFollowing(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/following"))
                .withQueryParam("after", equalTo("after-sample"))
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
                .withQueryParam("limit", equalTo("21"))
                .withQueryParam("locationContains", equalTo("locationContains-sample"))
                .withQueryParam("maxFollowers", equalTo("23"))
                .withQueryParam("maxFollowing", equalTo("24"))
                .withQueryParam("maxScan", equalTo("10000"))
                .withQueryParam("maxStatuses", equalTo("26"))
                .withQueryParam("minAccountAgeDays", equalTo("27"))
                .withQueryParam("minFollowers", equalTo("28"))
                .withQueryParam("minFollowing", equalTo("29"))
                .withQueryParam("minStatuses", equalTo("30"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("pageSize", equalTo("33"))
                .withQueryParam("usernameContains", equalTo("usernameContains-sample"))
                .withQueryParam("verifiedOnly", equalTo("true"))
                .withQueryParam("verifiedType", equalTo("verifiedType-sample")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.isPaginatedUsers()).isTrue()
        assertThat(response.asPaginatedUsers().hasNextPage()).isEqualTo(false)
        assertThat(response.asPaginatedUsers().nextCursor()).isEqualTo("")
        assertThat(response.asPaginatedUsers().users()).hasSize(1)
        assertThat(response.asPaginatedUsers().users()[0].id()).isEqualTo("11348282")
        assertThat(response.asPaginatedUsers().users()[0].name()).isEqualTo("NASA")
        assertThat(response.asPaginatedUsers().users()[0].username()).isEqualTo("NASA")
        assertThat(response.asPaginatedUsers().users()[0].accountBasedIn()).isEmpty
        assertThat(response.asPaginatedUsers().users()[0].birthdate().get().day()).contains(1L)
        assertThat(response.asPaginatedUsers().users()[0].birthdate().get().month()).contains(10L)
        assertThat(response.asPaginatedUsers().users()[0].birthdate().get().year()).contains(1958L)
        assertThat(response.asPaginatedUsers().users()[0].birthdate().get()._additionalProperties())
            .isEmpty()
        assertThat(response.asPaginatedUsers().users()[0].businessAccountAffiliatesCount())
            .contains(85L)
        assertThat(response.asPaginatedUsers().users()[0].contactInfo().get().links().get())
            .hasSize(1)
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .contactInfo()
                    .get()
                    .links()
                    .get()[0]
                    .network()
            )
            .isEqualTo("website")
        assertThat(
                response.asPaginatedUsers().users()[0].contactInfo().get().links().get()[0].source()
            )
            .isEqualTo(UserProfile.ContactInfo.Link.Source.URL)
        assertThat(
                response.asPaginatedUsers().users()[0].contactInfo().get().links().get()[0].url()
            )
            .isEqualTo("http://www.nasa.gov/")
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .contactInfo()
                    .get()
                    .links()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                response.asPaginatedUsers().users()[0].contactInfo().get()._additionalProperties()
            )
            .isEmpty()
        assertThat(response.asPaginatedUsers().users()[0].coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/11348282/1788992290")
        assertThat(response.asPaginatedUsers().users()[0].createdAt())
            .contains("Wed Dec 19 20:20:32 +0000 2007")
        assertThat(response.asPaginatedUsers().users()[0].creatorSubscriptionsCount()).contains(0L)
        assertThat(response.asPaginatedUsers().users()[0].description())
            .contains("Making the seemingly impossible, possible. ✨")
        assertThat(response.asPaginatedUsers().users()[0].favouritesCount()).contains(17003L)
        assertThat(response.asPaginatedUsers().users()[0].followers()).contains(92376187L)
        assertThat(response.asPaginatedUsers().users()[0].following()).contains(115L)
        assertThat(response.asPaginatedUsers().users()[0].hasGraduatedAccess()).contains(true)
        assertThat(response.asPaginatedUsers().users()[0].hasHiddenSubscriptionsOnProfile())
            .contains(false)
        assertThat(
                response.asPaginatedUsers().users()[0].highlightsInfo().get().canHighlightTweets()
            )
            .contains(true)
        assertThat(
                response.asPaginatedUsers().users()[0].highlightsInfo().get().highlightedTweets()
            )
            .contains("280")
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .highlightsInfo()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .identityVerification()
                    .get()
                    .isIdentityVerified()
            )
            .contains(false)
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .identityVerification()
                    .get()
                    .verifiedSinceMsec()
            )
            .contains("1249674830941")
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .identityVerification()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.asPaginatedUsers().users()[0].isBlueVerified()).contains(true)
        assertThat(response.asPaginatedUsers().users()[0].isProfileTranslatable()).contains(false)
        assertThat(response.asPaginatedUsers().users()[0].isVerified()).contains(true)
        assertThat(response.asPaginatedUsers().users()[0].location()).contains("Pale Blue Dot")
        assertThat(response.asPaginatedUsers().users()[0].mediaCount()).contains(28160L)
        assertThat(response.asPaginatedUsers().users()[0].parodyCommentaryFanLabel())
            .contains("None")
        assertThat(response.asPaginatedUsers().users()[0].possiblySensitive()).contains(false)
        assertThat(response.asPaginatedUsers().users()[0].profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/11348282/1788992290")
        assertThat(response.asPaginatedUsers().users()[0].profileDescriptionLanguage())
            .contains("en")
        assertThat(response.asPaginatedUsers().users()[0].profileImageShape()).contains("Square")
        assertThat(response.asPaginatedUsers().users()[0].profilePicture())
            .contains(
                "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_normal.jpg"
            )
        assertThat(response.asPaginatedUsers().users()[0].profilePictureOriginal())
            .contains("https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB.jpg")
        assertThat(response.asPaginatedUsers().users()[0].profileSortEnabled()).contains(true)
        assertThat(response.asPaginatedUsers().users()[0].profileTranslatorType())
            .contains("regular")
        assertThat(response.asPaginatedUsers().users()[0].protected_()).contains(false)
        assertThat(response.asPaginatedUsers().users()[0].statusesCount()).contains(74336L)
        assertThat(response.asPaginatedUsers().users()[0].superFollowEligible()).contains(false)
        assertThat(response.asPaginatedUsers().users()[0].url()).contains("http://www.nasa.gov/")
        assertThat(
                response.asPaginatedUsers().users()[0].verificationReason().get().entities().get()
            )
            .hasSize(1)
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    .entities()
                    .get()[0]
                    .fromIndex()
            )
            .contains(91L)
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    .entities()
                    .get()[0]
                    .toIndex()
            )
            .contains(101L)
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    .entities()
                    .get()[0]
                    .url()
            )
            .contains("https://help.twitter.com/en/rules-and-policies/profile-labels")
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    .entities()
                    .get()[0]
                    .urlType()
            )
            .contains("ExternalUrl")
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    .entities()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.asPaginatedUsers().users()[0].verificationReason().get().text())
            .contains(
                "This account is verified because it is a government or multilateral organization account.  Learn more"
            )
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.asPaginatedUsers().users()[0].verified()).contains(true)
        assertThat(response.asPaginatedUsers().users()[0].verifiedType()).contains("Government")
        assertThat(response.asPaginatedUsers().users()[0]._additionalProperties()).isEmpty()
        assertThat(response.asPaginatedUsers()._additionalProperties()).isEmpty()
    }

    @Test
    fun retrieveLikesParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/likes"))
                .willReturn(okJson(paginatedTweetsExampleRetrieveLikes))
        )
        val params =
            UserRetrieveLikesParams.builder()
                .id("1234567890")
                .anyWords("anyWords-sample")
                .blueVerifiedOnly(true)
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
                .language("language-sample")
                .maxFaves(25L)
                .maxId("maxId-sample")
                .maxQuotes(27L)
                .maxReplies(28L)
                .maxRetweets(29L)
                .mentioning("mentioning-sample")
                .minBookmarks(32L)
                .minFaves(33L)
                .minLikes(34L)
                .minQuotes(35L)
                .minReplies(36L)
                .minRetweets(37L)
                .minViews(38L)
                .nativeRetweets(true)
                .near("near-sample")
                .news(true)
                .omit("entities,media")
                .pageSize(43L)
                .quotesOfTweetId("quotesOfTweetId-sample")
                .retweetsOfTweetId("retweetsOfTweetId-sample")
                .safe(true)
                .sinceId("sinceId-sample")
                .source("source-sample")
                .toUser("toUser-sample")
                .url("url-sample")
                .verifiedOnly(true)
                .within("within-sample")
                .withinTime("7d")
                .build()

        val response = client.x().users().retrieveLikes(params)
        val asyncResponse = asyncClient.x().users().retrieveLikes(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/likes"))
                .withQueryParam("anyWords", equalTo("anyWords-sample"))
                .withQueryParam("blueVerifiedOnly", equalTo("true"))
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
                .withQueryParam("language", equalTo("language-sample"))
                .withQueryParam("maxFaves", equalTo("25"))
                .withQueryParam("maxId", equalTo("maxId-sample"))
                .withQueryParam("maxQuotes", equalTo("27"))
                .withQueryParam("maxReplies", equalTo("28"))
                .withQueryParam("maxRetweets", equalTo("29"))
                .withQueryParam("mentioning", equalTo("mentioning-sample"))
                .withQueryParam("minBookmarks", equalTo("32"))
                .withQueryParam("minFaves", equalTo("33"))
                .withQueryParam("minLikes", equalTo("34"))
                .withQueryParam("minQuotes", equalTo("35"))
                .withQueryParam("minReplies", equalTo("36"))
                .withQueryParam("minRetweets", equalTo("37"))
                .withQueryParam("minViews", equalTo("38"))
                .withQueryParam("nativeRetweets", equalTo("true"))
                .withQueryParam("near", equalTo("near-sample"))
                .withQueryParam("news", equalTo("true"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("pageSize", equalTo("43"))
                .withQueryParam("quotesOfTweetId", equalTo("quotesOfTweetId-sample"))
                .withQueryParam("retweetsOfTweetId", equalTo("retweetsOfTweetId-sample"))
                .withQueryParam("safe", equalTo("true"))
                .withQueryParam("sinceId", equalTo("sinceId-sample"))
                .withQueryParam("source", equalTo("source-sample"))
                .withQueryParam("toUser", equalTo("toUser-sample"))
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
    fun retrieveMediaParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/media"))
                .willReturn(okJson(paginatedTweetsExampleRetrieveLikes))
        )
        val params =
            UserRetrieveMediaParams.builder()
                .id("1234567890")
                .anyWords("anyWords-sample")
                .blueVerifiedOnly(true)
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
                .language("language-sample")
                .maxFaves(25L)
                .maxId("maxId-sample")
                .maxQuotes(27L)
                .maxReplies(28L)
                .maxRetweets(29L)
                .mentioning("mentioning-sample")
                .minBookmarks(32L)
                .minFaves(33L)
                .minLikes(34L)
                .minQuotes(35L)
                .minReplies(36L)
                .minRetweets(37L)
                .minViews(38L)
                .nativeRetweets(true)
                .near("near-sample")
                .news(true)
                .omit("entities,media")
                .pageSize(43L)
                .quotesOfTweetId("quotesOfTweetId-sample")
                .retweetsOfTweetId("retweetsOfTweetId-sample")
                .safe(true)
                .sinceId("sinceId-sample")
                .source("source-sample")
                .toUser("toUser-sample")
                .url("url-sample")
                .verifiedOnly(true)
                .within("within-sample")
                .withinTime("7d")
                .build()

        val response = client.x().users().retrieveMedia(params)
        val asyncResponse = asyncClient.x().users().retrieveMedia(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/media"))
                .withQueryParam("anyWords", equalTo("anyWords-sample"))
                .withQueryParam("blueVerifiedOnly", equalTo("true"))
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
                .withQueryParam("language", equalTo("language-sample"))
                .withQueryParam("maxFaves", equalTo("25"))
                .withQueryParam("maxId", equalTo("maxId-sample"))
                .withQueryParam("maxQuotes", equalTo("27"))
                .withQueryParam("maxReplies", equalTo("28"))
                .withQueryParam("maxRetweets", equalTo("29"))
                .withQueryParam("mentioning", equalTo("mentioning-sample"))
                .withQueryParam("minBookmarks", equalTo("32"))
                .withQueryParam("minFaves", equalTo("33"))
                .withQueryParam("minLikes", equalTo("34"))
                .withQueryParam("minQuotes", equalTo("35"))
                .withQueryParam("minReplies", equalTo("36"))
                .withQueryParam("minRetweets", equalTo("37"))
                .withQueryParam("minViews", equalTo("38"))
                .withQueryParam("nativeRetweets", equalTo("true"))
                .withQueryParam("near", equalTo("near-sample"))
                .withQueryParam("news", equalTo("true"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("pageSize", equalTo("43"))
                .withQueryParam("quotesOfTweetId", equalTo("quotesOfTweetId-sample"))
                .withQueryParam("retweetsOfTweetId", equalTo("retweetsOfTweetId-sample"))
                .withQueryParam("safe", equalTo("true"))
                .withQueryParam("sinceId", equalTo("sinceId-sample"))
                .withQueryParam("source", equalTo("source-sample"))
                .withQueryParam("toUser", equalTo("toUser-sample"))
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
    fun retrieveMentionsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/mentions"))
                .willReturn(okJson(paginatedTweetsExampleRetrieveLikes))
        )
        val params =
            UserRetrieveMentionsParams.builder()
                .id("1234567890")
                .anyWords("anyWords-sample")
                .blueVerifiedOnly(true)
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
                .language("language-sample")
                .maxFaves(25L)
                .maxId("maxId-sample")
                .maxQuotes(27L)
                .maxReplies(28L)
                .maxRetweets(29L)
                .mentioning("mentioning-sample")
                .minBookmarks(32L)
                .minFaves(33L)
                .minLikes(34L)
                .minQuotes(35L)
                .minReplies(36L)
                .minRetweets(37L)
                .minViews(38L)
                .nativeRetweets(true)
                .near("near-sample")
                .news(true)
                .omit("entities,media")
                .pageSize(43L)
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

        val response = client.x().users().retrieveMentions(params)
        val asyncResponse = asyncClient.x().users().retrieveMentions(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/mentions"))
                .withQueryParam("anyWords", equalTo("anyWords-sample"))
                .withQueryParam("blueVerifiedOnly", equalTo("true"))
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
                .withQueryParam("language", equalTo("language-sample"))
                .withQueryParam("maxFaves", equalTo("25"))
                .withQueryParam("maxId", equalTo("maxId-sample"))
                .withQueryParam("maxQuotes", equalTo("27"))
                .withQueryParam("maxReplies", equalTo("28"))
                .withQueryParam("maxRetweets", equalTo("29"))
                .withQueryParam("mentioning", equalTo("mentioning-sample"))
                .withQueryParam("minBookmarks", equalTo("32"))
                .withQueryParam("minFaves", equalTo("33"))
                .withQueryParam("minLikes", equalTo("34"))
                .withQueryParam("minQuotes", equalTo("35"))
                .withQueryParam("minReplies", equalTo("36"))
                .withQueryParam("minRetweets", equalTo("37"))
                .withQueryParam("minViews", equalTo("38"))
                .withQueryParam("nativeRetweets", equalTo("true"))
                .withQueryParam("near", equalTo("near-sample"))
                .withQueryParam("news", equalTo("true"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("pageSize", equalTo("43"))
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
    fun retrieveRepliesParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/replies"))
                .willReturn(okJson(paginatedTweetsExampleRetrieveLikes))
        )
        val params =
            UserRetrieveRepliesParams.builder()
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
                .includeParentTweet(true)
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

        val response = client.x().users().retrieveReplies(params)
        val asyncResponse = asyncClient.x().users().retrieveReplies(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/replies"))
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
                .withQueryParam("includeParentTweet", equalTo("true"))
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
    fun retrieveTweetsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/tweets"))
                .willReturn(okJson(paginatedTweetsExampleRetrieveLikes))
        )
        val params =
            UserRetrieveTweetsParams.builder()
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
                .includeParentTweet(true)
                .includeReplies(true)
                .inReplyToTweetId("inReplyToTweetId-sample")
                .keywords("keywords-sample")
                .language("language-sample")
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
                .pageSize(50L)
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

        val response = client.x().users().retrieveTweets(params)
        val asyncResponse = asyncClient.x().users().retrieveTweets(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/tweets"))
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
                .withQueryParam("includeParentTweet", equalTo("true"))
                .withQueryParam("includeReplies", equalTo("true"))
                .withQueryParam("inReplyToTweetId", equalTo("inReplyToTweetId-sample"))
                .withQueryParam("keywords", equalTo("keywords-sample"))
                .withQueryParam("language", equalTo("language-sample"))
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
                .withQueryParam("pageSize", equalTo("50"))
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
    fun retrieveVerifiedFollowersParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/users/1234567890/verified-followers"))
                .willReturn(
                    okJson(
                        """
                        {
                          "users": [
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
            UserRetrieveVerifiedFollowersParams.builder()
                .id("1234567890")
                .after("after-sample")
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
                .limit(21L)
                .locationContains("locationContains-sample")
                .maxFollowers(23L)
                .maxFollowing(24L)
                .maxScan(10000L)
                .maxStatuses(26L)
                .minAccountAgeDays(27L)
                .minFollowers(28L)
                .minFollowing(29L)
                .minStatuses(30L)
                .omit("entities,media")
                .pageSize(33L)
                .usernameContains("usernameContains-sample")
                .verifiedOnly(true)
                .verifiedType("verifiedType-sample")
                .build()

        val response = client.x().users().retrieveVerifiedFollowers(params)
        val asyncResponse = asyncClient.x().users().retrieveVerifiedFollowers(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/users/1234567890/verified-followers"))
                .withQueryParam("after", equalTo("after-sample"))
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
                .withQueryParam("limit", equalTo("21"))
                .withQueryParam("locationContains", equalTo("locationContains-sample"))
                .withQueryParam("maxFollowers", equalTo("23"))
                .withQueryParam("maxFollowing", equalTo("24"))
                .withQueryParam("maxScan", equalTo("10000"))
                .withQueryParam("maxStatuses", equalTo("26"))
                .withQueryParam("minAccountAgeDays", equalTo("27"))
                .withQueryParam("minFollowers", equalTo("28"))
                .withQueryParam("minFollowing", equalTo("29"))
                .withQueryParam("minStatuses", equalTo("30"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("pageSize", equalTo("33"))
                .withQueryParam("usernameContains", equalTo("usernameContains-sample"))
                .withQueryParam("verifiedOnly", equalTo("true"))
                .withQueryParam("verifiedType", equalTo("verifiedType-sample")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.isPaginatedUsers()).isTrue()
        assertThat(response.asPaginatedUsers().hasNextPage()).isEqualTo(false)
        assertThat(response.asPaginatedUsers().nextCursor()).isEqualTo("")
        assertThat(response.asPaginatedUsers().users()).hasSize(1)
        assertThat(response.asPaginatedUsers().users()[0].id()).isEqualTo("11348282")
        assertThat(response.asPaginatedUsers().users()[0].name()).isEqualTo("NASA")
        assertThat(response.asPaginatedUsers().users()[0].username()).isEqualTo("NASA")
        assertThat(response.asPaginatedUsers().users()[0].accountBasedIn()).isEmpty
        assertThat(response.asPaginatedUsers().users()[0].birthdate().get().day()).contains(1L)
        assertThat(response.asPaginatedUsers().users()[0].birthdate().get().month()).contains(10L)
        assertThat(response.asPaginatedUsers().users()[0].birthdate().get().year()).contains(1958L)
        assertThat(response.asPaginatedUsers().users()[0].birthdate().get()._additionalProperties())
            .isEmpty()
        assertThat(response.asPaginatedUsers().users()[0].businessAccountAffiliatesCount())
            .contains(85L)
        assertThat(response.asPaginatedUsers().users()[0].contactInfo().get().links().get())
            .hasSize(1)
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .contactInfo()
                    .get()
                    .links()
                    .get()[0]
                    .network()
            )
            .isEqualTo("website")
        assertThat(
                response.asPaginatedUsers().users()[0].contactInfo().get().links().get()[0].source()
            )
            .isEqualTo(UserProfile.ContactInfo.Link.Source.URL)
        assertThat(
                response.asPaginatedUsers().users()[0].contactInfo().get().links().get()[0].url()
            )
            .isEqualTo("http://www.nasa.gov/")
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .contactInfo()
                    .get()
                    .links()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                response.asPaginatedUsers().users()[0].contactInfo().get()._additionalProperties()
            )
            .isEmpty()
        assertThat(response.asPaginatedUsers().users()[0].coverPicture())
            .contains("https://pbs.twimg.com/profile_banners/11348282/1788992290")
        assertThat(response.asPaginatedUsers().users()[0].createdAt())
            .contains("Wed Dec 19 20:20:32 +0000 2007")
        assertThat(response.asPaginatedUsers().users()[0].creatorSubscriptionsCount()).contains(0L)
        assertThat(response.asPaginatedUsers().users()[0].description())
            .contains("Making the seemingly impossible, possible. ✨")
        assertThat(response.asPaginatedUsers().users()[0].favouritesCount()).contains(17003L)
        assertThat(response.asPaginatedUsers().users()[0].followers()).contains(92376187L)
        assertThat(response.asPaginatedUsers().users()[0].following()).contains(115L)
        assertThat(response.asPaginatedUsers().users()[0].hasGraduatedAccess()).contains(true)
        assertThat(response.asPaginatedUsers().users()[0].hasHiddenSubscriptionsOnProfile())
            .contains(false)
        assertThat(
                response.asPaginatedUsers().users()[0].highlightsInfo().get().canHighlightTweets()
            )
            .contains(true)
        assertThat(
                response.asPaginatedUsers().users()[0].highlightsInfo().get().highlightedTweets()
            )
            .contains("280")
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .highlightsInfo()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .identityVerification()
                    .get()
                    .isIdentityVerified()
            )
            .contains(false)
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .identityVerification()
                    .get()
                    .verifiedSinceMsec()
            )
            .contains("1249674830941")
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .identityVerification()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.asPaginatedUsers().users()[0].isBlueVerified()).contains(true)
        assertThat(response.asPaginatedUsers().users()[0].isProfileTranslatable()).contains(false)
        assertThat(response.asPaginatedUsers().users()[0].isVerified()).contains(true)
        assertThat(response.asPaginatedUsers().users()[0].location()).contains("Pale Blue Dot")
        assertThat(response.asPaginatedUsers().users()[0].mediaCount()).contains(28160L)
        assertThat(response.asPaginatedUsers().users()[0].parodyCommentaryFanLabel())
            .contains("None")
        assertThat(response.asPaginatedUsers().users()[0].possiblySensitive()).contains(false)
        assertThat(response.asPaginatedUsers().users()[0].profileBannerUrl())
            .contains("https://pbs.twimg.com/profile_banners/11348282/1788992290")
        assertThat(response.asPaginatedUsers().users()[0].profileDescriptionLanguage())
            .contains("en")
        assertThat(response.asPaginatedUsers().users()[0].profileImageShape()).contains("Square")
        assertThat(response.asPaginatedUsers().users()[0].profilePicture())
            .contains(
                "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_normal.jpg"
            )
        assertThat(response.asPaginatedUsers().users()[0].profilePictureOriginal())
            .contains("https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB.jpg")
        assertThat(response.asPaginatedUsers().users()[0].profileSortEnabled()).contains(true)
        assertThat(response.asPaginatedUsers().users()[0].profileTranslatorType())
            .contains("regular")
        assertThat(response.asPaginatedUsers().users()[0].protected_()).contains(false)
        assertThat(response.asPaginatedUsers().users()[0].statusesCount()).contains(74336L)
        assertThat(response.asPaginatedUsers().users()[0].superFollowEligible()).contains(false)
        assertThat(response.asPaginatedUsers().users()[0].url()).contains("http://www.nasa.gov/")
        assertThat(
                response.asPaginatedUsers().users()[0].verificationReason().get().entities().get()
            )
            .hasSize(1)
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    .entities()
                    .get()[0]
                    .fromIndex()
            )
            .contains(91L)
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    .entities()
                    .get()[0]
                    .toIndex()
            )
            .contains(101L)
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    .entities()
                    .get()[0]
                    .url()
            )
            .contains("https://help.twitter.com/en/rules-and-policies/profile-labels")
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    .entities()
                    .get()[0]
                    .urlType()
            )
            .contains("ExternalUrl")
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    .entities()
                    .get()[0]
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.asPaginatedUsers().users()[0].verificationReason().get().text())
            .contains(
                "This account is verified because it is a government or multilateral organization account.  Learn more"
            )
        assertThat(
                response
                    .asPaginatedUsers()
                    .users()[0]
                    .verificationReason()
                    .get()
                    ._additionalProperties()
            )
            .isEmpty()
        assertThat(response.asPaginatedUsers().users()[0].verified()).contains(true)
        assertThat(response.asPaginatedUsers().users()[0].verifiedType()).contains("Government")
        assertThat(response.asPaginatedUsers().users()[0]._additionalProperties()).isEmpty()
        assertThat(response.asPaginatedUsers()._additionalProperties()).isEmpty()
    }

    companion object {

        private val paginatedTweetsExampleRetrieveLikes =
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
