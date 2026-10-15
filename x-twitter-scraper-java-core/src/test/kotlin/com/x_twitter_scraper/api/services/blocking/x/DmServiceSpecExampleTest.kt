// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.github.tomakehurst.wiremock.client.WireMock.delete
import com.github.tomakehurst.wiremock.client.WireMock.deleteRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
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
import com.x_twitter_scraper.api.models.x.dm.DmDeleteMessageParams
import com.x_twitter_scraper.api.models.x.dm.DmDeleteMessageResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class DmServiceSpecExampleTest {

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
    fun deleteMessageParsesTheSpecExample() {
        stubFor(
            delete(urlPathEqualTo("/x/dm/44196397/messages/1790000000000000000"))
                .willReturn(
                    okJson(
                        """
                        {
                          "object": "x_write_action",
                          "id": "12345",
                          "writeActionId": "12345",
                          "action": "like",
                          "status": "success",
                          "terminal": true,
                          "retryable": false,
                          "safeToRetry": false,
                          "statusUrl": "/api/v1/x/write-actions/12345",
                          "pollAfterMs": null,
                          "charged": true,
                          "chargedCredits": "10",
                          "billing": {
                            "status": "charged",
                            "charged": true,
                            "plannedCredits": "10",
                            "chargedCredits": "10"
                          },
                          "request": {
                            "hash": "0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef",
                            "payload": {
                              "tweet_id": "9876543210"
                            }
                          },
                          "account": {
                            "id": "42",
                            "username": "example"
                          },
                          "target": {
                            "type": "tweet",
                            "id": "9876543210"
                          },
                          "targetId": "9876543210",
                          "result": {
                            "type": "state_change",
                            "id": "9876543210",
                            "state": "liked"
                          },
                          "nextAction": null,
                          "sendDispatched": true,
                          "success": true
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            DmDeleteMessageParams.builder()
                .userId("44196397")
                .messageId("1790000000000000000")
                .account("account")
                .idempotencyKey("fixture-idempotency-key")
                .build()

        val response = client.x().dm().deleteMessage(params)
        val asyncResponse = asyncClient.x().dm().deleteMessage(params).get()

        verify(
            2,
            deleteRequestedFor(urlPathEqualTo("/x/dm/44196397/messages/1790000000000000000"))
                .withQueryParam("account", equalTo("account"))
                .withHeader("Idempotency-Key", equalTo("fixture-idempotency-key")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.account().get().id()).isEqualTo("42")
        assertThat(response.account().get().username()).isEqualTo("example")
        assertThat(response.action()).isEqualTo(DmDeleteMessageResponse.Action.LIKE)
        assertThat(response.billing().charged()).isEqualTo(true)
        assertThat(response.billing().chargedCredits()).isEqualTo("10")
        assertThat(response.billing().plannedCredits()).isEqualTo("10")
        assertThat(response.billing().status())
            .isEqualTo(DmDeleteMessageResponse.Billing.Status.CHARGED)
        assertThat(response.charged()).isEqualTo(true)
        assertThat(response.chargedCredits()).isEqualTo("10")
        assertThat(response.id()).isEqualTo("12345")
        assertThat(response.nextAction()).isEmpty
        assertThat(response._object_()).isEqualTo(JsonValue.from("x_write_action"))
        assertThat(response.pollAfterMs()).isEmpty
        assertThat(response.request().hash())
            .contains("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
        assertThat(response.result().get().id()).contains("9876543210")
        assertThat(response.result().get().state()).contains("liked")
        assertThat(response.result().get().type())
            .contains(DmDeleteMessageResponse.Result.Type.STATE_CHANGE)
        assertThat(response.retryable()).isEqualTo(false)
        assertThat(response.safeToRetry()).isEqualTo(false)
        assertThat(response.sendDispatched()).isEqualTo(true)
        assertThat(response.status()).isEqualTo(DmDeleteMessageResponse.Status.SUCCESS)
        assertThat(response.statusUrl()).isEqualTo("/api/v1/x/write-actions/12345")
        assertThat(response.success()).isEqualTo(true)
        assertThat(response.target().get().id()).isEqualTo("9876543210")
        assertThat(response.target().get().type())
            .isEqualTo(DmDeleteMessageResponse.Target.Type.TWEET)
        assertThat(response.targetId()).contains("9876543210")
        assertThat(response.terminal()).isEqualTo(true)
        assertThat(response.writeActionId()).isEqualTo("12345")
        assertThat(response.communityId()).isEmpty
        assertThat(response.communityName()).isEmpty
        assertThat(response.completedAt()).isEmpty
        assertThat(response.confirmationAttempts()).isEmpty
        assertThat(response.confirmationCheckedAt()).isEmpty
        assertThat(response.confirmedAt()).isEmpty
        assertThat(response.createdAt()).isEmpty
        assertThat(response.error()).isEmpty
        assertThat(response.expiresAt()).isEmpty
        assertThat(response.idempotent()).isEmpty
        assertThat(response.mediaId()).isEmpty
        assertThat(response.mediaUrl()).isEmpty
        assertThat(response.message()).isEmpty
        assertThat(response.messageId()).isEmpty
        assertThat(response.requestHash()).isEmpty
        assertThat(response.requestId()).isEmpty
        assertThat(response.resultId()).isEmpty
        assertThat(response.sendDispatchedAt()).isEmpty
        assertThat(response.tweetId()).isEmpty
        assertThat(response.updatedAt()).isEmpty
    }
}
