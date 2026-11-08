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
import com.x_twitter_scraper.api.models.x.users.FollowerAudit
import com.x_twitter_scraper.api.models.x.users.FollowerClass
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowerAuditParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class UserServiceFollowerAuditTest {

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
    fun retrieveFollowerAuditSendsTheLimitAndReadsTheSpecExample() {
        stubFor(get(urlPathEqualTo("/x/users/NASA/follower-audit")).willReturn(okJson(example)))
        val params =
            UserRetrieveFollowerAuditParams.builder()
                .limit(200L)
                .fields("followers.userName")
                .omit("topFollowers")
                .build()

        val response = client.x().users().retrieveFollowerAudit("NASA", params)
        val asyncResponse = asyncClient.x().users().retrieveFollowerAudit("NASA", params).get()
        val rawResponse =
            client.x().users().withRawResponse().retrieveFollowerAudit("NASA", params).use {
                it.parse()
            }

        verify(
            3,
            getRequestedFor(urlPathEqualTo("/x/users/NASA/follower-audit"))
                .withQueryParam("limit", equalTo("200"))
                .withQueryParam("fields", equalTo("followers.userName"))
                .withQueryParam("omit", equalTo("topFollowers")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(rawResponse).isEqualTo(response)
        val audit = response.audit()
        assertThat(audit.account().userName()).isEqualTo("NASA")
        assertThat(audit.account().averages().get().engagements()).isEqualTo(4331.7)
        assertThat(audit.account().medianViews()).contains(512330.0)
        assertThat(audit.coverage().percent()).isEqualTo(0.0002)
        assertThat(audit.coverage().read()).isEqualTo(200L)
        assertThat(audit.coverage().total()).isEqualTo(92376187L)
        assertThat(audit.quality().grade()).isEqualTo(FollowerAudit.Quality.Grade.B)
        assertThat(audit.quality().score()).isEqualTo(71L)
        assertThat(audit.classes().map { it.class_() })
            .containsExactly(
                FollowerClass.LIKELY_REAL,
                FollowerClass.INACTIVE,
                FollowerClass.LIKELY_FAKE,
                FollowerClass.TOO_NEW,
            )
        assertThat(audit.classes()[1].count()).isEqualTo(41L)
        assertThat(audit.classes()[1].percent()).isEqualTo(20.5)
        assertThat(audit.signals().map { it.id() }).containsExactly("defaultPicture", "noBio")
        assertThat(audit.signals()[0].points()).isEqualTo(2L)
        assertThat(audit.arrivalBands()[1].from()).isEqualTo(101L)
        assertThat(audit.arrivalBands()[1].to()).isEqualTo(200L)
        assertThat(audit.arrivalBands()[1].read()).isEqualTo(100L)
        assertThat(audit.cohorts()[0].likelyFake()).isEqualTo(6L)
        assertThat(audit.cohorts()[0].weekStartMs()).isEqualTo(1761523200000L)
        assertThat(audit.languages()[0].value()).isEqualTo("en")
        assertThat(audit.places()[0].value()).isEqualTo("United States")
        assertThat(audit.places()[0].percent()).isEqualTo(11.0)
        assertThat(audit.verified().count()).isEqualTo(9L)
        val follower = audit.followers().single()
        assertThat(follower.class_()).isEqualTo(FollowerClass.LIKELY_REAL)
        assertThat(follower.userName()).isEqualTo("orbit_watcher")
        assertThat(follower.signals()).containsExactly("noBanner")
        assertThat(follower.position()).isEqualTo(1L)
        assertThat(follower.joinedAtMs()).contains(1561939200000L)
        assertThat(follower.pictureUrl())
            .contains("https://pbs.twimg.com/profile_images/1/photo.jpg")
        assertThat(follower.owner()).isEmpty()
        assertThat(audit.topFollowers()).containsExactly(follower)
    }

    @Test
    fun aFollowerClassTheApiDoesNotDefineFailsValidation() {
        val classCount =
            FollowerAudit.ClassCount.builder()
                .class_(FollowerClass.of("bot"))
                .count(1L)
                .percent(0.5)
                .build()

        assertThat(classCount.class_().value()).isEqualTo(FollowerClass.Value._UNKNOWN)
        assertThat(classCount.isValid()).isFalse()
        assertThat(classCount.toBuilder().class_(FollowerClass.AUTOMATED).build().isValid())
            .isTrue()
    }

    companion object {

        private val example =
            """
            {
              "audit": {
                "account": {
                  "userId": "11348282",
                  "userName": "NASA",
                  "followers": 92376187,
                  "following": 180,
                  "posts": 73919,
                  "accountAgeDays": 6449,
                  "postsPrivate": false,
                  "sample": {
                    "posts": 20,
                    "read": 22,
                    "oldestAt": "2026-10-28T13:15:28.000Z",
                    "newestAt": "2026-11-02T22:12:05.000Z"
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
                  "medianViews": 512330,
                  "engagementRate": 0.0047,
                  "engagementPerView": 0.55,
                  "postsPerDay": 3.8,
                  "topPostId": "1852301447063109847"
                },
                "coverage": {
                  "percent": 0.0002,
                  "read": 200,
                  "total": 92376187
                },
                "quality": {
                  "grade": "B",
                  "score": 71
                },
                "classes": [
                  {
                    "class": "likelyReal",
                    "count": 122,
                    "percent": 61
                  },
                  {
                    "class": "inactive",
                    "count": 41,
                    "percent": 20.5
                  },
                  {
                    "class": "likelyFake",
                    "count": 29,
                    "percent": 14.5
                  },
                  {
                    "class": "tooNew",
                    "count": 8,
                    "percent": 4
                  }
                ],
                "signals": [
                  {
                    "count": 36,
                    "id": "defaultPicture",
                    "percent": 18,
                    "points": 2
                  },
                  {
                    "count": 58,
                    "id": "noBio",
                    "percent": 29,
                    "points": 1
                  }
                ],
                "arrivalBands": [
                  {
                    "count": 13,
                    "from": 1,
                    "percent": 13,
                    "read": 100,
                    "to": 100
                  },
                  {
                    "count": 16,
                    "from": 101,
                    "percent": 16,
                    "read": 100,
                    "to": 200
                  }
                ],
                "cohorts": [
                  {
                    "count": 7,
                    "likelyFake": 6,
                    "percent": 3.5,
                    "weekStartMs": 1761523200000
                  }
                ],
                "languages": [
                  {
                    "count": 141,
                    "percent": 70.5,
                    "value": "en"
                  }
                ],
                "places": [
                  {
                    "count": 22,
                    "percent": 11,
                    "value": "United States"
                  }
                ],
                "verified": {
                  "count": 9,
                  "percent": 4.5
                },
                "followers": [
                  {
                    "id": "1852412278803021824",
                    "userName": "orbit_watcher",
                    "name": "Orbit Watcher",
                    "class": "likelyReal",
                    "score": 1,
                    "signals": [
                      "noBanner"
                    ],
                    "followers": 312,
                    "following": 410,
                    "likes": 2840,
                    "posts": 1290,
                    "position": 1,
                    "joinedAtMs": 1561939200000,
                    "pictureUrl": "https://pbs.twimg.com/profile_images/1/photo.jpg"
                  }
                ],
                "topFollowers": [
                  {
                    "id": "1852412278803021824",
                    "userName": "orbit_watcher",
                    "name": "Orbit Watcher",
                    "class": "likelyReal",
                    "score": 1,
                    "signals": [
                      "noBanner"
                    ],
                    "followers": 312,
                    "following": 410,
                    "likes": 2840,
                    "posts": 1290,
                    "position": 1,
                    "joinedAtMs": 1561939200000,
                    "pictureUrl": "https://pbs.twimg.com/profile_images/1/photo.jpg"
                  }
                ]
              }
            }
            """
                .trimIndent()
    }
}
