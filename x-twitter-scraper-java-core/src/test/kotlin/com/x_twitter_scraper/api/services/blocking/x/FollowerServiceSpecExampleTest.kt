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
import com.x_twitter_scraper.api.models.x.followers.FollowerCheckParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class FollowerSpecExampleTest {

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
    fun checkParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/followers/check"))
                .willReturn(
                    okJson(
                        """
                        {
                          "isFollowing": false,
                          "isFollowedBy": true,
                          "sourceId": "11348282",
                          "sourceUsername": "nasa",
                          "targetId": "34743251",
                          "targetUsername": "spacex"
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            FollowerCheckParams.builder()
                .source("source-sample")
                .target("target-sample")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().followers().check(params)
        val asyncResponse = asyncClient.x().followers().check(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/followers/check"))
                .withQueryParam("source", equalTo("source-sample"))
                .withQueryParam("target", equalTo("target-sample"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.isFollowedBy()).isEqualTo(true)
        assertThat(response.isFollowing()).isEqualTo(false)
        assertThat(response.sourceUsername()).isEqualTo("nasa")
        assertThat(response.targetUsername()).isEqualTo("spacex")
        assertThat(response.sourceId()).contains("11348282")
        assertThat(response.targetId()).contains("34743251")
        assertThat(response._additionalProperties()).isEmpty()
    }
}
