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
import com.x_twitter_scraper.api.models.activity.ActivityListParams
import com.x_twitter_scraper.api.models.activity.ActivityRecord
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ActivityServiceTest {

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
    fun listSendsTheFiltersAndReturnsTheRows() {
        stubFor(get(urlPathEqualTo("/activity")).willReturn(okJson(rowsExample)))
        val params = ActivityListParams.builder().category("monitors").limit(50L).build()

        val rows = client.activity().list(params)
        val asyncRows = asyncClient.activity().list(params).get()
        val rawRows = client.activity().withRawResponse().list(params).use { it.parse() }

        verify(
            3,
            getRequestedFor(urlPathEqualTo("/activity"))
                .withQueryParam("category", equalTo("monitors"))
                .withQueryParam("limit", equalTo("50")),
        )
        assertThat(asyncRows).isEqualTo(rows)
        assertThat(rawRows).isEqualTo(rows)
        assertThat(rows).hasSize(2)
        assertThat(rows[0].id()).isEqualTo("naF3xqHLWDTs")
        assertThat(rows[0].activity()).isEqualTo("Account monitor for @NASA paused")
        assertThat(rows[0].credits().asString()).isEmpty()
        assertThat(rows[1].credits().asLong()).isEqualTo(-12L)
        assertThat(rows[1].results().asLong()).isEqualTo(40L)
    }

    @Test
    fun retrieveReturnsAWebhookDeliveryWithItsDeliveryTimes() {
        stubFor(get(urlPathEqualTo("/activity/naF3xqHLWDTs")).willReturn(okJson(deliveryExample)))

        val record = client.activity().retrieve("naF3xqHLWDTs")
        val asyncRecord = asyncClient.activity().retrieve("naF3xqHLWDTs").get()

        verify(2, getRequestedFor(urlPathEqualTo("/activity/naF3xqHLWDTs")))
        assertThat(asyncRecord).isEqualTo(record)
        assertThat(record.kind()).isEqualTo(ActivityRecord.Kind.WEBHOOK_DELIVERY)
        assertThat(record.status()).isEqualTo(ActivityRecord.Status.COMPLETED)
        assertThat(record.timestamps().deliveredAt())
            .contains(OffsetDateTime.parse("2026-10-28T20:22:13.702Z"))
        assertThat(record.timestamps().nextRetryAt()).isEmpty()
        assertThat(record.request().get().method()).isEqualTo(ActivityRecord.Request.Method.POST)
        assertThat(record.caller().authMethod()).contains(ActivityRecord.Caller.AuthMethod.API_KEY)
        assertThat(record.caller().apiKey().get().prefix()).isEqualTo("xq_ab12")
        assertThat(record.caller().oauthClient()).isEmpty()
        assertThat(record.charge()).isEmpty()
        assertThat(record.related()[0].status()).isEqualTo(ActivityRecord.Related.Status.FAILED)
        assertThat(record.details()._additionalProperties().keys).containsExactly("attempts")
    }

    companion object {

        private val rowsExample =
            """
            [
              {
                "time": "2026-10-28T20:22:13.481Z",
                "category": "monitor_change",
                "type": "pause",
                "activity": "Account monitor for @NASA paused",
                "status": "completed",
                "source": "NASA",
                "target": "",
                "results": "",
                "credits": "",
                "details": "",
                "id": "naF3xqHLWDTs",
                "link": ""
              },
              {
                "time": "2026-10-28T20:20:01.002Z",
                "category": "extraction",
                "type": "follower_explorer",
                "activity": "Followers of @NASA",
                "status": "completed",
                "source": "NASA",
                "target": "",
                "results": 40,
                "credits": -12,
                "details": "",
                "id": "Q7wErTyUiOpA",
                "link": ""
              }
            ]
            """
                .trimIndent()

        private val deliveryExample =
            """
            {
              "object": "activity",
              "id": "naF3xqHLWDTs",
              "kind": "webhook_delivery",
              "type": "tweet.new",
              "status": "completed",
              "url": "https://dashboard.xquik.com/activity/naF3xqHLWDTs",
              "requestId": "9f2c1d7e4b8a4c55a1e0d3b2c6f7a8e9",
              "timestamps": {
                "createdAt": "2026-10-28T20:22:13.481Z",
                "firstAttemptedAt": "2026-10-28T20:22:13.610Z",
                "deliveredAt": "2026-10-28T20:22:13.702Z"
              },
              "request": {
                "method": "POST",
                "path": "/api/v1/webhooks/42/test",
                "httpStatus": 200,
                "durationMs": 37,
                "ipAddress": "203.0.113.9",
                "userAgent": "my-agent/1.0",
                "at": "2026-10-28T20:22:13.519Z"
              },
              "caller": {
                "authMethod": "api_key",
                "apiKey": {"name": "Production", "prefix": "xq_ab12"},
                "oauthClient": null
              },
              "charge": null,
              "details": {"attempts": 2},
              "related": [
                {
                  "id": "Q7wErTyUiOpA",
                  "type": "tweet.new",
                  "status": "failed",
                  "createdAt": "2026-10-21T09:12:40.002Z",
                  "url": "https://dashboard.xquik.com/activity/Q7wErTyUiOpA"
                }
              ]
            }
            """
                .trimIndent()
    }
}
