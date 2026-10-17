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
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveSearchParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveTweetsParams
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ListServiceSpecExampleTest {

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
    fun retrieveParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/lists/1234567890"))
                .willReturn(
                    okJson(
                        """
                        {
                          "list": {
                            "id": "4143408",
                            "name": "NASA Centers",
                            "description": "NASA has 10 centers",
                            "memberCount": 11,
                            "subscriberCount": 859,
                            "owner": {
                              "id": "11348282",
                              "username": "NASA",
                              "name": "NASA"
                            },
                            "url": "https://x.com/i/lists/4143408",
                            "createdAt": "2009-12-02T22:41:02.000Z",
                            "bannerUrl": "https://pbs.twimg.com/media/example.png",
                            "membersContext": "11 members"
                          }
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            ListRetrieveParams.builder()
                .id("1234567890")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().lists().retrieve(params)
        val asyncResponse = asyncClient.x().lists().retrieve(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/lists/1234567890"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.list().id()).isEqualTo("4143408")
        assertThat(response.list().name()).isEqualTo("NASA Centers")
        assertThat(response.list().bannerUrl()).contains("https://pbs.twimg.com/media/example.png")
        assertThat(response.list().createdAt())
            .contains(OffsetDateTime.parse("2009-12-02T22:41:02.000Z"))
        assertThat(response.list().description()).contains("NASA has 10 centers")
        assertThat(response.list().memberCount()).contains(11L)
        assertThat(response.list().membersContext()).contains("11 members")
        assertThat(response.list().owner().get().id()).isEqualTo("11348282")
        assertThat(response.list().owner().get().username()).isEqualTo("NASA")
        assertThat(response.list().owner().get().name()).isEqualTo("NASA")
        assertThat(response.list().subscriberCount()).contains(859L)
        assertThat(response.list().url()).contains("https://x.com/i/lists/4143408")
        assertThat(response.list().customBanner()).isEmpty
        assertThat(response.list().defaultBanner()).isEmpty
        assertThat(response.list().facepileUrls()).isEmpty
    }

    @Test
    fun retrieveSearchParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/lists/search"))
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
            ListRetrieveSearchParams.builder()
                .q("q")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().lists().retrieveSearch(params)
        val asyncResponse = asyncClient.x().lists().retrieveSearch(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/lists/search"))
                .withQueryParam("q", equalTo("q"))
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
    fun retrieveFollowersParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/lists/1234567890/followers"))
                .willReturn(okJson(paginatedUsersExample))
        )
        val params =
            ListRetrieveFollowersParams.builder()
                .id("1234567890")
                .after("after-sample")
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
                .maxFollowers(21L)
                .maxFollowing(22L)
                .maxScan(10000L)
                .maxStatuses(24L)
                .minAccountAgeDays(25L)
                .minFollowers(26L)
                .minFollowing(27L)
                .minStatuses(28L)
                .omit("entities,media")
                .pageSize(31L)
                .usernameContains("usernameContains-sample")
                .verifiedOnly(true)
                .verifiedType("verifiedType-sample")
                .build()

        val response = client.x().lists().retrieveFollowers(params)
        val asyncResponse = asyncClient.x().lists().retrieveFollowers(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/lists/1234567890/followers"))
                .withQueryParam("after", equalTo("after-sample"))
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
                .withQueryParam("maxFollowers", equalTo("21"))
                .withQueryParam("maxFollowing", equalTo("22"))
                .withQueryParam("maxScan", equalTo("10000"))
                .withQueryParam("maxStatuses", equalTo("24"))
                .withQueryParam("minAccountAgeDays", equalTo("25"))
                .withQueryParam("minFollowers", equalTo("26"))
                .withQueryParam("minFollowing", equalTo("27"))
                .withQueryParam("minStatuses", equalTo("28"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("pageSize", equalTo("31"))
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
    fun retrieveMembersParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/lists/1234567890/members"))
                .willReturn(okJson(paginatedUsersExample))
        )
        val params =
            ListRetrieveMembersParams.builder()
                .id("1234567890")
                .after("after-sample")
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
                .maxFollowers(21L)
                .maxFollowing(22L)
                .maxScan(10000L)
                .maxStatuses(24L)
                .minAccountAgeDays(25L)
                .minFollowers(26L)
                .minFollowing(27L)
                .minStatuses(28L)
                .omit("entities,media")
                .pageSize(31L)
                .usernameContains("usernameContains-sample")
                .verifiedOnly(true)
                .verifiedType("verifiedType-sample")
                .build()

        val response = client.x().lists().retrieveMembers(params)
        val asyncResponse = asyncClient.x().lists().retrieveMembers(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/lists/1234567890/members"))
                .withQueryParam("after", equalTo("after-sample"))
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
                .withQueryParam("maxFollowers", equalTo("21"))
                .withQueryParam("maxFollowing", equalTo("22"))
                .withQueryParam("maxScan", equalTo("10000"))
                .withQueryParam("maxStatuses", equalTo("24"))
                .withQueryParam("minAccountAgeDays", equalTo("25"))
                .withQueryParam("minFollowers", equalTo("26"))
                .withQueryParam("minFollowing", equalTo("27"))
                .withQueryParam("minStatuses", equalTo("28"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("pageSize", equalTo("31"))
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
    fun retrieveTweetsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/lists/1234567890/tweets"))
                .willReturn(okJson(paginatedTweetsExample))
        )
        val params =
            ListRetrieveTweetsParams.builder()
                .id("1234567890")
                .advancedQuery("advancedQuery-sample")
                .after("after-sample")
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
                .maxFaves(30L)
                .maxId("maxId-sample")
                .maxQuotes(32L)
                .maxReplies(33L)
                .maxRetweets(34L)
                .mentioning("mentioning-sample")
                .minBookmarks(37L)
                .minLikes(38L)
                .minQuotes(39L)
                .minReplies(40L)
                .minRetweets(41L)
                .minViews(42L)
                .nativeRetweets(true)
                .near("near-sample")
                .news(true)
                .omit("entities,media")
                .pageSize(48L)
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

        val response = client.x().lists().retrieveTweets(params)
        val asyncResponse = asyncClient.x().lists().retrieveTweets(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/lists/1234567890/tweets"))
                .withQueryParam("advancedQuery", equalTo("advancedQuery-sample"))
                .withQueryParam("after", equalTo("after-sample"))
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
                .withQueryParam("maxFaves", equalTo("30"))
                .withQueryParam("maxId", equalTo("maxId-sample"))
                .withQueryParam("maxQuotes", equalTo("32"))
                .withQueryParam("maxReplies", equalTo("33"))
                .withQueryParam("maxRetweets", equalTo("34"))
                .withQueryParam("mentioning", equalTo("mentioning-sample"))
                .withQueryParam("minBookmarks", equalTo("37"))
                .withQueryParam("minLikes", equalTo("38"))
                .withQueryParam("minQuotes", equalTo("39"))
                .withQueryParam("minReplies", equalTo("40"))
                .withQueryParam("minRetweets", equalTo("41"))
                .withQueryParam("minViews", equalTo("42"))
                .withQueryParam("nativeRetweets", equalTo("true"))
                .withQueryParam("near", equalTo("near-sample"))
                .withQueryParam("news", equalTo("true"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("pageSize", equalTo("48"))
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
