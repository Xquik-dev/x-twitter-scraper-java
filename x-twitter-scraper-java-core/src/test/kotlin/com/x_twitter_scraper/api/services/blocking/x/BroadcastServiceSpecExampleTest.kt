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
import com.x_twitter_scraper.api.models.x.broadcasts.BroadcastRetrieveParams
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class BroadcastServiceSpecExampleTest {

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
            get(urlPathEqualTo("/x/broadcasts/1234567890"))
                .willReturn(
                    okJson(
                        """
                        {
                          "broadcast": {
                            "id": "1nGeLMWbkpaKX",
                            "title": "USSF-259 Mission",
                            "state": "Ended",
                            "startedAt": "2026-09-17T00:54:56.506Z",
                            "endedAt": "2026-09-17T01:17:35.036Z",
                            "totalWatched": 161758,
                            "totalWatching": 21639,
                            "width": 3840,
                            "height": 2160,
                            "creator": {
                              "id": "34743251",
                              "username": "SpaceX",
                              "name": "SpaceX"
                            }
                          }
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            BroadcastRetrieveParams.builder()
                .id("1234567890")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().broadcasts().retrieve(params)
        val asyncResponse = asyncClient.x().broadcasts().retrieve(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/broadcasts/1234567890"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.broadcast().id()).isEqualTo("1nGeLMWbkpaKX")
        assertThat(response.broadcast().creator().get().id()).isEqualTo("34743251")
        assertThat(response.broadcast().creator().get().username()).isEqualTo("SpaceX")
        assertThat(response.broadcast().creator().get().name()).isEqualTo("SpaceX")
        assertThat(response.broadcast().endedAt())
            .contains(OffsetDateTime.parse("2026-09-17T01:17:35.036Z"))
        assertThat(response.broadcast().height()).contains(2160L)
        assertThat(response.broadcast().startedAt())
            .contains(OffsetDateTime.parse("2026-09-17T00:54:56.506Z"))
        assertThat(response.broadcast().state()).contains("Ended")
        assertThat(response.broadcast().title()).contains("USSF-259 Mission")
        assertThat(response.broadcast().totalWatched()).contains(161758L)
        assertThat(response.broadcast().totalWatching()).contains(21639L)
        assertThat(response.broadcast().width()).contains(3840L)
        assertThat(response.broadcast().cameraRotation()).isEmpty
        assertThat(response.broadcast().chatOption()).isEmpty
        assertThat(response.broadcast().isAvailableForReplay()).isEmpty
        assertThat(response.broadcast().isHighLatency()).isEmpty
        assertThat(response.broadcast().isPrivateChat()).isEmpty
        assertThat(response.broadcast().isTitleEdited()).isEmpty
        assertThat(response.broadcast().lastPingAt()).isEmpty
        assertThat(response.broadcast().mediaKey()).isEmpty
        assertThat(response.broadcast().periscopeUser()).isEmpty
        assertThat(response.broadcast().preLiveSlateUrl()).isEmpty
        assertThat(response.broadcast().scheduledStart()).isEmpty
        assertThat(response.broadcast().source()).isEmpty
        assertThat(response.broadcast().tweet()).isEmpty
        assertThat(response.broadcast().tweetId()).isEmpty
        assertThat(response.broadcast().version()).isEmpty
    }
}
