// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.draws.DrawExportParams
import com.x_twitter_scraper.api.models.draws.DrawListParams
import com.x_twitter_scraper.api.models.draws.DrawRunParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class DrawServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val drawService = client.draws()

        val draw = drawService.retrieve("id")

        draw.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val drawService = client.draws()

        val draws = drawService.list(DrawListParams.builder().after("after").limit(1L).build())

        draws.validate()
    }

    @Test
    fun export(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val drawService = client.draws()
        stubFor(get(anyUrl()).willReturn(ok().withBody("abc")))

        val response =
            drawService.export(
                DrawExportParams.builder()
                    .id("id")
                    .format(DrawExportParams.Format.CSV)
                    .type(DrawExportParams.Type.WINNERS)
                    .build()
            )

        assertThat(response.body()).hasContent("abc")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun run() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val drawService = client.draws()

        val response =
            drawService.run(
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

        response.validate()
    }
}
