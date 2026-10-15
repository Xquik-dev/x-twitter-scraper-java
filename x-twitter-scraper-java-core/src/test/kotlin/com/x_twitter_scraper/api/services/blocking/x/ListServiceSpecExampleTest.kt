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
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveSearchParams
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
}
