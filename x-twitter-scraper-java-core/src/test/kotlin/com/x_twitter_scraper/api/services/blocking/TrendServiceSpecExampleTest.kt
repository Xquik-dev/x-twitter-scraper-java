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
import com.x_twitter_scraper.api.models.trends.TrendListParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class TrendSpecExampleTest {

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
    fun listParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/trends"))
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
                          "total": 30,
                          "woeid": 1
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            TrendListParams.builder()
                .count(10L)
                .fields("id,text,author.username")
                .omit("entities,media")
                .woeid(13L)
                .build()

        val response = client.trends().list(params)
        val asyncResponse = asyncClient.trends().list(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/trends"))
                .withQueryParam("count", equalTo("10"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("woeid", equalTo("13")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.total()).isEqualTo(30L)
        assertThat(response.trends()).hasSize(1)
        assertThat(response.trends()[0].name()).isEqualTo("#AI")
        assertThat(response.trends()[0].description())
            .contains("Artificial intelligence discussions")
        assertThat(response.trends()[0].promotedContent()).isEmpty
        assertThat(response.trends()[0].query()).contains("%23AI")
        assertThat(response.trends()[0].rank()).contains(1L)
        assertThat(response.trends()[0].tweetVolume()).contains(250000L)
        assertThat(response.trends()[0].url()).contains("https://x.com/search?q=%23AI")
        assertThat(response.trends()[0]._additionalProperties()).isEmpty()
        assertThat(response.woeid()).isEqualTo(1L)
        assertThat(response._additionalProperties()).isEmpty()
    }
}
