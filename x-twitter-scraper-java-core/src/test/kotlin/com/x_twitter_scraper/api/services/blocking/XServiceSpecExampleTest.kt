// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking

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
import com.x_twitter_scraper.api.models.x.XAutocompleteSearchParams
import com.x_twitter_scraper.api.models.x.XGetArticleParams
import com.x_twitter_scraper.api.models.x.XGetHashflagsParams
import com.x_twitter_scraper.api.models.x.XGetNewsStoryVersionsParams
import com.x_twitter_scraper.api.models.x.XGetTrendLocationsParams
import com.x_twitter_scraper.api.models.x.XGetTrendsHistoryParams
import com.x_twitter_scraper.api.models.x.XGetTrendsParams
import com.x_twitter_scraper.api.models.x.XSearchPlacesParams
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class XServiceSpecExampleTest {

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
    fun autocompleteSearchParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/search/autocomplete"))
                .willReturn(
                    okJson(
                        """
                        {
                          "query": "nasa",
                          "users": [
                            {
                              "id": "11348282",
                              "username": "NASA",
                              "name": "NASA",
                              "verified": true,
                              "isBlueVerified": true,
                              "isVerified": false,
                              "verifiedType": "Government",
                              "protected": false,
                              "location": "Pale Blue Dot",
                              "profilePicture": "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_normal.jpg",
                              "badges": [
                                {
                                  "badgeType": "BusinessLabel",
                                  "badgeUrl": "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_bigger.jpg",
                                  "description": "NASA"
                                }
                              ],
                              "isPersonaMediaGenable": false,
                              "score": 0,
                              "tokens": [
                                "nasa"
                              ],
                              "inline": false
                            }
                          ],
                          "topics": [
                            {
                              "topic": "nasa",
                              "score": 0,
                              "tokens": [
                                "nasa"
                              ],
                              "inline": false
                            }
                          ],
                          "hashtags": [
                            {
                              "hashtag": "#nasuanimalkingdom",
                              "score": 600,
                              "tokens": [
                                "#nasuanimalkingdom"
                              ],
                              "inline": false
                            }
                          ],
                          "cashtags": [
                            {
                              "ticker": "TSLA",
                              "name": "Tesla Inc",
                              "smartTag": "${'$'}TSLA",
                              "currency": "USD",
                              "price": "370.589999999",
                              "marketCap": "1463662787286.778808593",
                              "dailyChangePercent": 4.6539,
                              "logoUrl": "https://abs.twimg.com/finance/v1/stock/TSLA.png",
                              "exchangeShortName": "NASDAQ",
                              "contractAddress": "0x322f0929c4625ed5bad873c95208d54e1c003b2d",
                              "chainLogoUrl": "https://abs.twimg.com/finance/v1/crypto/robinhood/native.png"
                            }
                          ],
                          "count": 2
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            XAutocompleteSearchParams.builder()
                .q("nasa")
                .fields("id,text,author.username")
                .omit("entities,media")
                .types("users,topics")
                .build()

        val response = client.x().autocompleteSearch(params)
        val asyncResponse = asyncClient.x().autocompleteSearch(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/search/autocomplete"))
                .withQueryParam("q", equalTo("nasa"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("types", equalTo("users,topics")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.cashtags()).hasSize(1)
        assertThat(response.cashtags()[0].ticker()).isEqualTo("TSLA")
        assertThat(response.cashtags()[0].chainLogoUrl())
            .contains("https://abs.twimg.com/finance/v1/crypto/robinhood/native.png")
        assertThat(response.cashtags()[0].contractAddress())
            .contains("0x322f0929c4625ed5bad873c95208d54e1c003b2d")
        assertThat(response.cashtags()[0].currency()).contains("USD")
        assertThat(response.cashtags()[0].dailyChangePercent()).contains(4.6539)
        assertThat(response.cashtags()[0].exchangeShortName()).contains("NASDAQ")
        assertThat(response.cashtags()[0].logoUrl())
            .contains("https://abs.twimg.com/finance/v1/stock/TSLA.png")
        assertThat(response.cashtags()[0].marketCap()).contains("1463662787286.778808593")
        assertThat(response.cashtags()[0].name()).contains("Tesla Inc")
        assertThat(response.cashtags()[0].price()).contains("370.589999999")
        assertThat(response.cashtags()[0].smartTag()).contains("\$TSLA")
        assertThat(response.count()).isEqualTo(2L)
        assertThat(response.hashtags()).hasSize(1)
        assertThat(response.hashtags()[0].hashtag()).isEqualTo("#nasuanimalkingdom")
        assertThat(response.hashtags()[0].inline()).contains(false)
        assertThat(response.hashtags()[0].score()).contains(600.0)
        assertThat(response.hashtags()[0].tokens().get()).containsExactly("#nasuanimalkingdom")
        assertThat(response.query()).isEqualTo("nasa")
        assertThat(response.topics()).hasSize(1)
        assertThat(response.topics()[0].topic()).isEqualTo("nasa")
        assertThat(response.topics()[0].inline()).contains(false)
        assertThat(response.topics()[0].score()).contains(0.0)
        assertThat(response.topics()[0].tokens().get()).containsExactly("nasa")
        assertThat(response.users()).hasSize(1)
        assertThat(response.users()[0].id()).isEqualTo("11348282")
        assertThat(response.users()[0].name()).isEqualTo("NASA")
        assertThat(response.users()[0].username()).isEqualTo("NASA")
        assertThat(response.users()[0].badges().get()).hasSize(1)
        assertThat(response.users()[0].badges().get()[0].badgeType()).contains("BusinessLabel")
        assertThat(response.users()[0].badges().get()[0].badgeUrl())
            .contains(
                "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_bigger.jpg"
            )
        assertThat(response.users()[0].badges().get()[0].description()).contains("NASA")
        assertThat(response.users()[0].inline()).contains(false)
        assertThat(response.users()[0].isBlueVerified()).contains(true)
        assertThat(response.users()[0].isPersonaMediaGenable()).contains(false)
        assertThat(response.users()[0].isVerified()).contains(false)
        assertThat(response.users()[0].location()).contains("Pale Blue Dot")
        assertThat(response.users()[0].profilePicture())
            .contains(
                "https://pbs.twimg.com/profile_images/1321163587679784960/0ZxKlEKB_normal.jpg"
            )
        assertThat(response.users()[0].protected_()).contains(false)
        assertThat(response.users()[0].score()).contains(0.0)
        assertThat(response.users()[0].tokens().get()).containsExactly("nasa")
        assertThat(response.users()[0].verified()).contains(true)
        assertThat(response.users()[0].verifiedType()).contains("Government")
        assertThat(response.users()[0].profilePictureOriginal()).isEmpty
    }

    @Test
    fun getHashflagsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/hashflags"))
                .willReturn(
                    okJson(
                        """
                        {
                          "hashflags": [
                            {
                              "hashtag": "AION2",
                              "assetUrl": "https://abs.twimg.com/hashflags/BF-16692_AIon2_jp_Hashmoji_v3/BF-16692_AIon2_jp_Hashmoji_v3.png",
                              "startsAt": "2026-10-02T10:00:00.000Z",
                              "endsAt": "2027-01-03T14:59:00.000Z",
                              "isHashfettiEnabled": false,
                              "animations": [
                                {
                                  "context": "Like",
                                  "assetUrl": "https://abs.twimg.com/hashflags/2026FootballCustomLikeEvergreenv3/2026FootballCustomLikeEvergreenv3_sakura_0.json",
                                  "priority": 1
                                }
                              ]
                            }
                          ],
                          "count": 1,
                          "total": 1,
                          "message": "No hashflag runs now. Send activeOnly=false to list the rest."
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            XGetHashflagsParams.builder()
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().getHashflags(params)
        val asyncResponse = asyncClient.x().getHashflags(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/hashflags"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.count()).isEqualTo(1L)
        assertThat(response.hashflags()).hasSize(1)
        assertThat(response.hashflags()[0].animations()).hasSize(1)
        assertThat(response.hashflags()[0].animations()[0].assetUrl())
            .isEqualTo(
                "https://abs.twimg.com/hashflags/2026FootballCustomLikeEvergreenv3/2026FootballCustomLikeEvergreenv3_sakura_0.json"
            )
        assertThat(response.hashflags()[0].animations()[0].context()).contains("Like")
        assertThat(response.hashflags()[0].animations()[0].priority()).contains(1.0)
        assertThat(response.hashflags()[0].assetUrl())
            .isEqualTo(
                "https://abs.twimg.com/hashflags/BF-16692_AIon2_jp_Hashmoji_v3/BF-16692_AIon2_jp_Hashmoji_v3.png"
            )
        assertThat(response.hashflags()[0].endsAt())
            .isEqualTo(OffsetDateTime.parse("2027-01-03T14:59:00.000Z"))
        assertThat(response.hashflags()[0].hashtag()).isEqualTo("AION2")
        assertThat(response.hashflags()[0].isHashfettiEnabled()).isEqualTo(false)
        assertThat(response.hashflags()[0].startsAt())
            .isEqualTo(OffsetDateTime.parse("2026-10-02T10:00:00.000Z"))
        assertThat(response.total()).isEqualTo(1L)
        assertThat(response.message())
            .contains("No hashflag runs now. Send activeOnly=false to list the rest.")
    }

    @Test
    fun getNewsStoryVersionsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/news/2110209733533598095/versions"))
                .willReturn(
                    okJson(
                        """
                        {
                          "id": "2110209733533598095",
                          "count": 1,
                          "versions": [
                            {
                              "id": "2110211669641105725",
                              "createdAt": "2026-10-14T03:30:42.536Z",
                              "headline": "Elon Musk Pushes Starlink for India's Remote Areas Amid Regulatory Hurdles",
                              "text": "Musk has accused Reliance Industries' Mukesh Ambani of blocking Starlink's entry to protect local telecom giants like Jio, while India's government insists on equal treatment for all applicants, including ongoing security reviews. In Vietnam, Starlink already provides free internet to isolated spots for tourism and disaster response, highlighting its potential for hard-to-reach areas. Yet challengers note India's cheap mobile data from Jio and Airtel covers most needs, raising questions on pricing and national security as Starlink seeks final clearances."
                            }
                          ]
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            XGetNewsStoryVersionsParams.builder()
                .id("2110209733533598095")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().getNewsStoryVersions(params)
        val asyncResponse = asyncClient.x().getNewsStoryVersions(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/news/2110209733533598095/versions"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.count()).isEqualTo(1L)
        assertThat(response.id()).isEqualTo("2110209733533598095")
        assertThat(response.versions()).hasSize(1)
        assertThat(response.versions()[0].createdAt())
            .isEqualTo(OffsetDateTime.parse("2026-10-14T03:30:42.536Z"))
        assertThat(response.versions()[0].headline())
            .isEqualTo("Elon Musk Pushes Starlink for India's Remote Areas Amid Regulatory Hurdles")
        assertThat(response.versions()[0].id()).isEqualTo("2110211669641105725")
        assertThat(response.versions()[0].text())
            .isEqualTo(
                "Musk has accused Reliance Industries' Mukesh Ambani of blocking Starlink's entry to protect local telecom giants like Jio, while India's government insists on equal treatment for all applicants, including ongoing security reviews. In Vietnam, Starlink already provides free internet to isolated spots for tourism and disaster response, highlighting its potential for hard-to-reach areas. Yet challengers note India's cheap mobile data from Jio and Airtel covers most needs, raising questions on pricing and national security as Starlink seeks final clearances."
            )
    }

    @Test
    fun getTrendLocationsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/trends/locations"))
                .willReturn(
                    okJson(
                        """
                        {
                          "locations": [
                            {
                              "woeid": 2344116,
                              "name": "Istanbul",
                              "country": "Turkey",
                              "countryCode": "TR",
                              "placeType": "Town",
                              "placeTypeCode": 7,
                              "parentWoeid": 23424969,
                              "url": "http://where.yahooapis.com/v1/place/2344116"
                            }
                          ],
                          "count": 1,
                          "total": 1,
                          "message": "Unknown placeType. Use country, town, worldwide or unknown."
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            XGetTrendLocationsParams.builder()
                .fields("id,text,author.username")
                .omit("entities,media")
                .placeType(XGetTrendLocationsParams.PlaceType.COUNTRY)
                .build()

        val response = client.x().getTrendLocations(params)
        val asyncResponse = asyncClient.x().getTrendLocations(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/trends/locations"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("placeType", equalTo("country")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.count()).isEqualTo(1L)
        assertThat(response.locations()).hasSize(1)
        assertThat(response.locations()[0].country()).contains("Turkey")
        assertThat(response.locations()[0].countryCode()).contains("TR")
        assertThat(response.locations()[0].name()).isEqualTo("Istanbul")
        assertThat(response.locations()[0].parentWoeid()).contains(23424969L)
        assertThat(response.locations()[0].placeType()).contains("Town")
        assertThat(response.locations()[0].placeTypeCode()).contains(7L)
        assertThat(response.locations()[0].url())
            .contains("http://where.yahooapis.com/v1/place/2344116")
        assertThat(response.locations()[0].woeid()).isEqualTo(2344116L)
        assertThat(response.total()).isEqualTo(1L)
        assertThat(response.message())
            .contains("Unknown placeType. Use country, town, worldwide or unknown.")
    }

    @Test
    fun getTrendsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/trends"))
                .willReturn(
                    okJson(
                        """
                        {
                          "trends": [
                            {
                              "name": "#AI",
                              "description": "Artificial intelligence discussions",
                              "promotedContent": null,
                              "query": "%23AI",
                              "rank": 1,
                              "tweetVolume": 250000,
                              "url": "https://x.com/search?q=%23AI"
                            }
                          ],
                          "count": 30,
                          "woeid": 1,
                          "location": {
                            "woeid": 2344116,
                            "name": "Istanbul",
                            "country": "Turkey",
                            "countryCode": "TR",
                            "placeType": "Town",
                            "placeTypeCode": 7,
                            "parentWoeid": 23424969,
                            "url": "http://where.yahooapis.com/v1/place/2344116"
                          },
                          "capturedAt": "2026-10-13T14:00:26.000Z",
                          "requestedAt": "2026-10-13T14:00:00.000Z"
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            XGetTrendsParams.builder()
                .at("2026-10-13T14:00:00Z")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().getTrends(params)
        val asyncResponse = asyncClient.x().getTrends(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/trends"))
                .withQueryParam("at", equalTo("2026-10-13T14:00:00Z"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.count()).isEqualTo(30L)
        assertThat(response.trends()).hasSize(1)
        assertThat(response.trends()[0].name()).isEqualTo("#AI")
        assertThat(response.trends()[0].description())
            .contains("Artificial intelligence discussions")
        assertThat(response.trends()[0].promotedContent()).isEmpty
        assertThat(response.trends()[0].query()).contains("%23AI")
        assertThat(response.trends()[0].rank()).contains(1L)
        assertThat(response.trends()[0].tweetVolume()).contains(250000L)
        assertThat(response.trends()[0].url()).contains("https://x.com/search?q=%23AI")
        assertThat(response.woeid()).isEqualTo(1L)
        assertThat(response.capturedAt()).contains(OffsetDateTime.parse("2026-10-13T14:00:26.000Z"))
        assertThat(response.location().get().country()).contains("Turkey")
        assertThat(response.location().get().countryCode()).contains("TR")
        assertThat(response.location().get().name()).isEqualTo("Istanbul")
        assertThat(response.location().get().parentWoeid()).contains(23424969L)
        assertThat(response.location().get().placeType()).contains("Town")
        assertThat(response.location().get().placeTypeCode()).contains(7L)
        assertThat(response.location().get().url())
            .contains("http://where.yahooapis.com/v1/place/2344116")
        assertThat(response.location().get().woeid()).isEqualTo(2344116L)
        assertThat(response.requestedAt())
            .contains(OffsetDateTime.parse("2026-10-13T14:00:00.000Z"))
    }

    @Test
    fun getTrendsHistoryParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/trends/history"))
                .willReturn(
                    okJson(
                        """
                        {
                          "fromTime": "2026-10-13T00:00:00.000Z",
                          "toTime": "2026-10-14T00:00:00.000Z",
                          "snapshots": [
                            {
                              "capturedAt": "2026-10-13T14:00:26.000Z",
                              "count": 1,
                              "trends": [
                                {
                                  "name": "#AI",
                                  "description": "Artificial intelligence discussions",
                                  "promotedContent": null,
                                  "query": "%23AI",
                                  "rank": 1,
                                  "tweetVolume": 250000,
                                  "url": "https://x.com/search?q=%23AI"
                                }
                              ]
                            }
                          ],
                          "count": 1,
                          "woeid": 1,
                          "has_next_page": false,
                          "next_cursor": ""
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            XGetTrendsHistoryParams.builder()
                .cursor("2026-10-14T00:00:00.000Z~1791979200000")
                .every("1h")
                .fields("id,text,author.username")
                .from("2026-10-13")
                .omit("entities,media")
                .to("2026-10-14")
                .build()

        val response = client.x().getTrendsHistory(params)
        val asyncResponse = asyncClient.x().getTrendsHistory(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/trends/history"))
                .withQueryParam("cursor", equalTo("2026-10-14T00:00:00.000Z~1791979200000"))
                .withQueryParam("every", equalTo("1h"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("from", equalTo("2026-10-13"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("to", equalTo("2026-10-14")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.count()).isEqualTo(1L)
        assertThat(response.fromTime()).isEqualTo(OffsetDateTime.parse("2026-10-13T00:00:00.000Z"))
        assertThat(response.hasNextPage()).isEqualTo(false)
        assertThat(response.nextCursor()).isEqualTo("")
        assertThat(response.snapshots()).hasSize(1)
        assertThat(response.snapshots()[0].capturedAt())
            .isEqualTo(OffsetDateTime.parse("2026-10-13T14:00:26.000Z"))
        assertThat(response.snapshots()[0].count()).isEqualTo(1L)
        assertThat(response.snapshots()[0].trends()).hasSize(1)
        assertThat(response.snapshots()[0].trends()[0].name()).isEqualTo("#AI")
        assertThat(response.snapshots()[0].trends()[0].description())
            .contains("Artificial intelligence discussions")
        assertThat(response.snapshots()[0].trends()[0].promotedContent()).isEmpty
        assertThat(response.snapshots()[0].trends()[0].query()).contains("%23AI")
        assertThat(response.snapshots()[0].trends()[0].rank()).contains(1L)
        assertThat(response.snapshots()[0].trends()[0].tweetVolume()).contains(250000L)
        assertThat(response.snapshots()[0].trends()[0].url())
            .contains("https://x.com/search?q=%23AI")
        assertThat(response.toTime()).isEqualTo(OffsetDateTime.parse("2026-10-14T00:00:00.000Z"))
        assertThat(response.woeid()).isEqualTo(1L)
        assertThat(response.location()).isEmpty
    }

    @Test
    fun searchPlacesParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/places/search"))
                .willReturn(
                    okJson(
                        """
                        {
                          "places": [
                            {
                              "id": "5e02a0f0d91c76d2",
                              "name": "İstanbul",
                              "fullName": "İstanbul, Türkiye",
                              "country": "Turkey",
                              "countryCode": "TR",
                              "placeType": "city",
                              "url": "https://api.twitter.com/1.1/geo/id/5e02a0f0d91c76d2.json",
                              "centroid": [
                                28.84318392941324,
                                41.054196399999995
                              ],
                              "boundingBox": {
                                "type": "Polygon",
                                "coordinates": [
                                  [
                                    [
                                      28.6321043,
                                      40.8027337
                                    ],
                                    [
                                      28.6321043,
                                      41.2399073
                                    ],
                                    [
                                      29.3783413,
                                      41.2399073
                                    ],
                                    [
                                      29.3783413,
                                      40.8027337
                                    ]
                                  ]
                                ]
                              },
                              "attributes": {},
                              "containedWithin": [
                                {
                                  "id": "5e02a0f0d91c76d2",
                                  "name": "İstanbul",
                                  "fullName": "İstanbul, Türkiye",
                                  "country": "Turkey",
                                  "countryCode": "TR",
                                  "placeType": "city",
                                  "url": "https://api.twitter.com/1.1/geo/id/5e02a0f0d91c76d2.json",
                                  "centroid": [
                                    28.84318392941324,
                                    41.054196399999995
                                  ],
                                  "boundingBox": {
                                    "type": "Polygon",
                                    "coordinates": [
                                      [
                                        [
                                          28.6321043,
                                          40.8027337
                                        ],
                                        [
                                          28.6321043,
                                          41.2399073
                                        ],
                                        [
                                          29.3783413,
                                          41.2399073
                                        ],
                                        [
                                          29.3783413,
                                          40.8027337
                                        ]
                                      ]
                                    ]
                                  },
                                  "attributes": {}
                                }
                              ]
                            }
                          ],
                          "count": 1,
                          "total": 1,
                          "message": "X found no place for that text. Try a city or country name."
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            XSearchPlacesParams.builder()
                .q("q")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().searchPlaces(params)
        val asyncResponse = asyncClient.x().searchPlaces(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/places/search"))
                .withQueryParam("q", equalTo("q"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.count()).isEqualTo(1L)
        assertThat(response.places()).hasSize(1)
        assertThat(response.places()[0].boundingBox().get().type()).isEqualTo("Polygon")
        assertThat(response.places()[0].centroid().get())
            .containsExactly(28.84318392941324, 41.054196399999995)
        assertThat(response.places()[0].containedWithin()).hasSize(1)
        assertThat(response.places()[0].containedWithin()[0].boundingBox().get().type())
            .isEqualTo("Polygon")
        assertThat(response.places()[0].containedWithin()[0].centroid().get())
            .containsExactly(28.84318392941324, 41.054196399999995)
        assertThat(response.places()[0].containedWithin()[0].country()).contains("Turkey")
        assertThat(response.places()[0].containedWithin()[0].countryCode()).contains("TR")
        assertThat(response.places()[0].containedWithin()[0].fullName())
            .contains("İstanbul, Türkiye")
        assertThat(response.places()[0].containedWithin()[0].id()).isEqualTo("5e02a0f0d91c76d2")
        assertThat(response.places()[0].containedWithin()[0].name()).isEqualTo("İstanbul")
        assertThat(response.places()[0].containedWithin()[0].placeType()).contains("city")
        assertThat(response.places()[0].containedWithin()[0].url())
            .contains("https://api.twitter.com/1.1/geo/id/5e02a0f0d91c76d2.json")
        assertThat(response.places()[0].country()).contains("Turkey")
        assertThat(response.places()[0].countryCode()).contains("TR")
        assertThat(response.places()[0].fullName()).contains("İstanbul, Türkiye")
        assertThat(response.places()[0].id()).isEqualTo("5e02a0f0d91c76d2")
        assertThat(response.places()[0].name()).isEqualTo("İstanbul")
        assertThat(response.places()[0].placeType()).contains("city")
        assertThat(response.places()[0].url())
            .contains("https://api.twitter.com/1.1/geo/id/5e02a0f0d91c76d2.json")
        assertThat(response.total()).isEqualTo(1L)
        assertThat(response.message())
            .contains("X found no place for that text. Try a city or country name.")
    }

    @Test
    fun getArticleParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/articles/example"))
                .willReturn(
                    okJson(
                        """
                        {
                          "article": {
                            "articleId": "2100651802404544512",
                            "title": "The Future of AI",
                            "previewText": "A deep dive into the latest AI trends...",
                            "coverImageUrl": "https://pbs.twimg.com/media/example.jpg",
                            "contents": [
                              {
                                "type": "paragraph",
                                "text": "This is the first paragraph of the article.",
                                "links": [
                                  {
                                    "offset": 18,
                                    "length": 9,
                                    "url": "https://example.com/paragraph"
                                  }
                                ]
                              },
                              {
                                "type": "tweet",
                                "tweetId": "2058951429612875794"
                              }
                            ],
                            "createdAt": "2025-01-15T12:00:00Z",
                            "metadata": {
                              "first_published_at_secs": 1736942400
                            },
                            "lifecycleState": {
                              "modified_at_secs": 1736946000
                            },
                            "likeCount": 150,
                            "replyCount": 23,
                            "quoteCount": 8,
                            "retweetCount": 40,
                            "bookmarkCount": 61,
                            "viewCount": 5000
                          },
                          "author": {
                            "id": "9876543210",
                            "name": "Elon Musk",
                            "username": "elonmusk",
                            "profilePicture": "https://pbs.twimg.com/profile_images/example.jpg"
                          }
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            XGetArticleParams.builder()
                .tweetId("example")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().getArticle(params)
        val asyncResponse = asyncClient.x().getArticle(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/articles/example"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.article().articleId()).contains("2100651802404544512")
        assertThat(response.article().bookmarkCount()).contains(61L)
        assertThat(response.article().contents().get()).hasSize(2)
        assertThat(response.article().contents().get()[0].links().get()).hasSize(1)
        assertThat(response.article().contents().get()[0].links().get()[0].length()).contains(9L)
        assertThat(response.article().contents().get()[0].links().get()[0].offset()).contains(18L)
        assertThat(response.article().contents().get()[0].links().get()[0].url())
            .contains("https://example.com/paragraph")
        assertThat(response.article().contents().get()[0].links().get()[0]._additionalProperties())
            .isEmpty()
        assertThat(response.article().contents().get()[0].text())
            .contains("This is the first paragraph of the article.")
        assertThat(response.article().contents().get()[0].type()).contains("paragraph")
        assertThat(response.article().contents().get()[0]._additionalProperties()).isEmpty()
        assertThat(response.article().contents().get()[1].tweetId()).contains("2058951429612875794")
        assertThat(response.article().contents().get()[1].type()).contains("tweet")
        assertThat(response.article().contents().get()[1]._additionalProperties()).isEmpty()
        assertThat(response.article().coverImageUrl())
            .contains("https://pbs.twimg.com/media/example.jpg")
        assertThat(response.article().createdAt()).contains("2025-01-15T12:00:00Z")
        assertThat(response.article().likeCount()).contains(150L)
        assertThat(response.article().previewText())
            .contains("A deep dive into the latest AI trends...")
        assertThat(response.article().quoteCount()).contains(8L)
        assertThat(response.article().replyCount()).contains(23L)
        assertThat(response.article().retweetCount()).contains(40L)
        assertThat(response.article().title()).contains("The Future of AI")
        assertThat(response.article().viewCount()).contains(5000L)
        assertThat(response.article()._additionalProperties()).isEmpty()
        assertThat(response.author().get().id()).isEqualTo("9876543210")
        assertThat(response.author().get().name()).isEqualTo("Elon Musk")
        assertThat(response.author().get().username()).isEqualTo("elonmusk")
        assertThat(response.author().get().profilePicture())
            .contains("https://pbs.twimg.com/profile_images/example.jpg")
        assertThat(response.author().get()._additionalProperties()).isEmpty()
        assertThat(response._additionalProperties()).isEmpty()
        assertThat(response.article().bodyMarkdown()).isEmpty
        assertThat(response.article().bodyText()).isEmpty
        assertThat(response.article().contents().get()[0].altText()).isEmpty
        assertThat(response.article().contents().get()[0].caption()).isEmpty
        assertThat(response.article().contents().get()[0].durationMs()).isEmpty
        assertThat(response.article().contents().get()[0].height()).isEmpty
        assertThat(response.article().contents().get()[0].inlineStyleRanges()).isEmpty
        assertThat(response.article().contents().get()[0].mediaType()).isEmpty
        assertThat(response.article().contents().get()[0].previewUrl()).isEmpty
        assertThat(response.article().contents().get()[0].tweetId()).isEmpty
        assertThat(response.article().contents().get()[0].url()).isEmpty
        assertThat(response.article().contents().get()[0].variants()).isEmpty
        assertThat(response.article().contents().get()[0].width()).isEmpty
        assertThat(response.article().contents().get()[1].altText()).isEmpty
        assertThat(response.article().contents().get()[1].caption()).isEmpty
        assertThat(response.article().contents().get()[1].durationMs()).isEmpty
        assertThat(response.article().contents().get()[1].height()).isEmpty
        assertThat(response.article().contents().get()[1].inlineStyleRanges()).isEmpty
        assertThat(response.article().contents().get()[1].links()).isEmpty
        assertThat(response.article().contents().get()[1].mediaType()).isEmpty
        assertThat(response.article().contents().get()[1].previewUrl()).isEmpty
        assertThat(response.article().contents().get()[1].text()).isEmpty
        assertThat(response.article().contents().get()[1].url()).isEmpty
        assertThat(response.article().contents().get()[1].variants()).isEmpty
        assertThat(response.article().contents().get()[1].width()).isEmpty
        assertThat(response.article().coverMedia()).isEmpty
        assertThat(response.article().summaryText()).isEmpty
        assertThat(response.author().get().createdAt()).isEmpty
        assertThat(response.author().get().description()).isEmpty
        assertThat(response.author().get().favouritesCount()).isEmpty
        assertThat(response.author().get().followersCount()).isEmpty
        assertThat(response.author().get().followingCount()).isEmpty
        assertThat(response.author().get().isBlueVerified()).isEmpty
        assertThat(response.author().get().isTranslator()).isEmpty
        assertThat(response.author().get().isVerified()).isEmpty
        assertThat(response.author().get().location()).isEmpty
        assertThat(response.author().get().mediaCount()).isEmpty
        assertThat(response.author().get().profileBannerUrl()).isEmpty
        assertThat(response.author().get().profilePictureOriginal()).isEmpty
        assertThat(response.author().get().protected_()).isEmpty
        assertThat(response.author().get().statusesCount()).isEmpty
        assertThat(response.author().get().url()).isEmpty
    }
}
