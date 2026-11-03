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
import com.x_twitter_scraper.api.models.x.users.ShadowbanReport
import com.x_twitter_scraper.api.models.x.users.ShadowbanVerdict
import com.x_twitter_scraper.api.models.x.users.UserRetrieveShadowbanParams
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class UserServiceShadowbanTest {

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
    fun retrieveShadowbanSendsTheFieldFiltersAndReadsEachCheck() {
        stubFor(get(urlPathEqualTo("/x/users/NASA/shadowban")).willReturn(okJson(activeExample)))
        val params = UserRetrieveShadowbanParams.builder().fields("checks").omit("username").build()

        val response = client.x().users().retrieveShadowban("NASA", params)
        val asyncResponse = asyncClient.x().users().retrieveShadowban("NASA", params).get()
        val rawResponse =
            client.x().users().withRawResponse().retrieveShadowban("NASA", params).use {
                it.parse()
            }

        verify(
            3,
            getRequestedFor(urlPathEqualTo("/x/users/NASA/shadowban"))
                .withQueryParam("fields", equalTo("checks"))
                .withQueryParam("omit", equalTo("username")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(rawResponse).isEqualTo(response)
        assertThat(response.account()).isEqualTo(ShadowbanReport.Account.ACTIVE)
        val checks = response.checks()
        assertThat(checks.account().evidence().profileUrl()).isEqualTo("https://x.com/NASA")
        assertThat(checks.search().verdict()).isEqualTo(ShadowbanVerdict.PASS)
        assertThat(checks.search().evidence().get().foundPostIds())
            .containsExactly("2103610284464316469")
        assertThat(checks.suggestion().reason())
            .isEqualTo(ShadowbanReport.Checks.Suggestion.Reason.NOT_SUGGESTED)
        assertThat(checks.suggestion().evidence().get().suggestedUsernames())
            .containsExactly("NASAHubble", "NASAEarth")
        assertThat(checks.replies().verdict()).isEqualTo(ShadowbanVerdict.UNKNOWN)
        assertThat(checks.replies().evidence().get().replies().map { it.placement() })
            .containsExactly(ShadowbanReport.Checks.Replies.Evidence.Reply.Placement.MORE_REPLIES)
        assertThat(response.checkedAt()).isEqualTo(OffsetDateTime.parse("2026-11-03T02:15:00.000Z"))
        assertThat(response.overall()).isEqualTo(ShadowbanReport.Overall.LIMITED)
        assertThat(checks.replyLock().evidence().get().shownReplies()).isEqualTo(0L)
        assertThat(checks.timeline().reason())
            .isEqualTo(ShadowbanReport.Checks.Timeline.Reason.VISIBLE)
        assertThat(checks.engagement().evidence().get().newestMedian()).isEqualTo(4268.0)
        assertThat(checks.sensitive().reason())
            .isEqualTo(ShadowbanReport.Checks.Sensitive.Reason.NOT_FLAGGED)
        assertThat(checks.withheld().evidence().get().countries()).isEmpty()
    }

    @Test
    fun aSuspendedAccountHasEvidenceOnlyForTheAccountCheck() {
        stubFor(get(urlPathEqualTo("/x/users/gone/shadowban")).willReturn(okJson(suspendedExample)))

        val response = client.x().users().retrieveShadowban("gone")

        assertThat(response.userId()).isEmpty()
        assertThat(response.account()).isEqualTo(ShadowbanReport.Account.SUSPENDED)
        assertThat(response.checks().account().verdict()).isEqualTo(ShadowbanVerdict.FAIL)
        assertThat(response.checks().search().evidence()).isEmpty()
        assertThat(response.checks().suggestion().evidence()).isEmpty()
        assertThat(response.checks().replies().evidence()).isEmpty()
        assertThat(response.overall()).isEqualTo(ShadowbanReport.Overall.SUSPENDED)
        assertThat(response.checks().timeline().reason())
            .isEqualTo(ShadowbanReport.Checks.Timeline.Reason.SUSPENDED)
        assertThat(response.checks().withheld().evidence()).isEmpty()
    }

    companion object {

        private val activeExample =
            """
            {
              "username": "NASA",
              "userId": "11348282",
              "account": "active",
              "checkedAt": "2026-11-03T02:15:00.000Z",
              "overall": "limited",
              "checks": {
                "account": {
                  "verdict": "pass",
                  "reason": "active",
                  "evidence": {
                    "profileUrl": "https://x.com/NASA"
                  }
                },
                "search": {
                  "verdict": "pass",
                  "reason": "listed",
                  "evidence": {
                    "query": "from:NASA",
                    "searchUrl": "https://x.com/search?q=from%3ANASA&f=live",
                    "recentPostIds": [
                      "2103610284464316469",
                      "2103583087540003274"
                    ],
                    "foundPostIds": [
                      "2103610284464316469"
                    ]
                  }
                },
                "suggestion": {
                  "verdict": "fail",
                  "reason": "not_suggested",
                  "evidence": {
                    "query": "NASA",
                    "suggestedUsernames": [
                      "NASAHubble",
                      "NASAEarth"
                    ]
                  }
                },
                "replies": {
                  "verdict": "unknown",
                  "reason": "more_replies",
                  "evidence": {
                    "replies": [
                      {
                        "replyId": "2103589735449141451",
                        "replyUrl": "https://x.com/i/status/2103589735449141451",
                        "parentId": "2102883223948628205",
                        "parentUrl": "https://x.com/i/status/2102883223948628205",
                        "placement": "more_replies"
                      }
                    ]
                  }
                },
                "replyLock": {
                  "verdict": "unknown",
                  "reason": "replies_missing",
                  "evidence": {
                    "checkedReplies": 1,
                    "shownReplies": 0
                  }
                },
                "timeline": {
                  "verdict": "pass",
                  "reason": "visible",
                  "evidence": {
                    "postCount": 74486,
                    "timelinePosts": 20
                  }
                },
                "engagement": {
                  "verdict": "pass",
                  "reason": "typical",
                  "evidence": {
                    "newestMedian": 4268,
                    "newestPosts": 5,
                    "earlierMedian": 2773,
                    "earlierPosts": 7
                  }
                },
                "sensitive": {
                  "verdict": "pass",
                  "reason": "not_flagged",
                  "evidence": null
                },
                "withheld": {
                  "verdict": "pass",
                  "reason": "none",
                  "evidence": {
                    "countries": []
                  }
                }
              }
            }
            """
                .trimIndent()

        private val suspendedExample =
            """
            {
              "username": "gone",
              "userId": null,
              "account": "suspended",
              "checkedAt": "2026-11-03T02:15:00.000Z",
              "overall": "suspended",
              "checks": {
                "account": {
                  "verdict": "fail",
                  "reason": "suspended",
                  "evidence": {
                    "profileUrl": "https://x.com/gone"
                  }
                },
                "search": {
                  "verdict": "unknown",
                  "reason": "suspended",
                  "evidence": null
                },
                "suggestion": {
                  "verdict": "unknown",
                  "reason": "suspended",
                  "evidence": null
                },
                "replies": {
                  "verdict": "unknown",
                  "reason": "suspended",
                  "evidence": null
                },
                "replyLock": {
                  "verdict": "unknown",
                  "reason": "suspended",
                  "evidence": null
                },
                "timeline": {
                  "verdict": "unknown",
                  "reason": "suspended",
                  "evidence": null
                },
                "engagement": {
                  "verdict": "unknown",
                  "reason": "suspended",
                  "evidence": null
                },
                "sensitive": {
                  "verdict": "unknown",
                  "reason": "suspended",
                  "evidence": null
                },
                "withheld": {
                  "verdict": "unknown",
                  "reason": "suspended",
                  "evidence": null
                }
              }
            }
            """
                .trimIndent()
    }
}
