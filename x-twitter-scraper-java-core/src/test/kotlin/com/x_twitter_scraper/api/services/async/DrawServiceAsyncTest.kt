// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.draws.DrawExportParams
import com.x_twitter_scraper.api.models.draws.DrawListParams
import com.x_twitter_scraper.api.models.draws.DrawRunParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class DrawServiceAsyncTest {
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val drawServiceAsync = client.draws()

        val drawFuture = drawServiceAsync.retrieve("f4bd00a2-7b4e-4e59-8e1b-72e2c9f12345")

        val draw = drawFuture.get()
        kotlin.test.assertNotNull(draw)
    }

    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val drawServiceAsync = client.draws()

        val drawsFuture =
            drawServiceAsync.list(DrawListParams.builder().cursor("cursor").limit(1L).build())

        val draws = drawsFuture.get()
        kotlin.test.assertNotNull(draws)
    }

    @Test
    fun export(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val drawServiceAsync = client.draws()
        stubFor(get(anyUrl()).willReturn(ok().withBody("abc")))

        val responseFuture =
            drawServiceAsync.export(
                DrawExportParams.builder()
                    .id("f4bd00a2-7b4e-4e59-8e1b-72e2c9f12345")
                    .format(DrawExportParams.Format.CSV)
                    .type(DrawExportParams.Type.WINNERS)
                    .build()
            )

        val response = responseFuture.get()
        assertThat(response.body()).hasContent("abc")
    }

    @Test
    fun run() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val drawServiceAsync = client.draws()

        val responseFuture =
            drawServiceAsync.run(
                DrawRunParams.builder()
                    .tweetUrl("https://x.com/elonmusk/status/1234567890")
                    .backupCount(2L)
                    .filterAccountAgeDays(30L)
                    .filterLanguage("en")
                    .filterMinFollowers(50L)
                    .mustFollowUsername("elonmusk")
                    .mustRetweet(true)
                    .addRequiredHashtag("#giveaway")
                    .addRequiredKeyword("entered")
                    .addRequiredMention("@elonmusk")
                    .uniqueAuthorsOnly(true)
                    .winnerCount(3L)
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
