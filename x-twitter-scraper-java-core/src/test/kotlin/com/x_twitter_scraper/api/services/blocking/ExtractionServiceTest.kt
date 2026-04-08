// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.extractions.ExtractionEstimateCostParams
import com.x_twitter_scraper.api.models.extractions.ExtractionExportResultsParams
import com.x_twitter_scraper.api.models.extractions.ExtractionListParams
import com.x_twitter_scraper.api.models.extractions.ExtractionRetrieveParams
import com.x_twitter_scraper.api.models.extractions.ExtractionRunParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ExtractionServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val extractionService = client.extractions()

        val extraction =
            extractionService.retrieve(
                ExtractionRetrieveParams.builder().id("id").after("after").limit(1L).build()
            )

        extraction.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val extractionService = client.extractions()

        val extractions =
            extractionService.list(
                ExtractionListParams.builder()
                    .after("after")
                    .limit(1L)
                    .status(ExtractionListParams.Status.RUNNING)
                    .toolType(ExtractionListParams.ToolType.FOLLOWER_EXPLORER)
                    .build()
            )

        extractions.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun estimateCost() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val extractionService = client.extractions()

        val response =
            extractionService.estimateCost(
                ExtractionEstimateCostParams.builder()
                    .toolType(ExtractionEstimateCostParams.ToolType.FOLLOWER_EXPLORER)
                    .advancedQuery("min_faves:100")
                    .exactPhrase("artificial intelligence")
                    .excludeWords("spam")
                    .searchQuery("AI trends 2025")
                    .targetCommunityId("1500000000000000000")
                    .targetListId("1234567890")
                    .targetSpaceId("1vOGwMdBqpwGB")
                    .targetTweetId("1234567890")
                    .targetUsername("elonmusk")
                    .build()
            )

        response.validate()
    }

    @Test
    fun exportResults(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val extractionService = client.extractions()
        stubFor(get(anyUrl()).willReturn(ok().withBody("abc")))

        val response =
            extractionService.exportResults(
                ExtractionExportResultsParams.builder()
                    .id("id")
                    .format(ExtractionExportResultsParams.Format.CSV)
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
        val extractionService = client.extractions()

        val response =
            extractionService.run(
                ExtractionRunParams.builder()
                    .toolType(ExtractionRunParams.ToolType.FOLLOWER_EXPLORER)
                    .advancedQuery("min_faves:100")
                    .exactPhrase("artificial intelligence")
                    .excludeWords("spam")
                    .searchQuery("AI trends 2025")
                    .targetCommunityId("1500000000000000000")
                    .targetListId("1234567890")
                    .targetSpaceId("1vOGwMdBqpwGB")
                    .targetTweetId("1234567890")
                    .targetUsername("elonmusk")
                    .build()
            )

        response.validate()
    }
}
