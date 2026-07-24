// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.extractions.ExtractionEstimateCostParams
import com.x_twitter_scraper.api.models.extractions.ExtractionExportResultsParams
import com.x_twitter_scraper.api.models.extractions.ExtractionListParams
import com.x_twitter_scraper.api.models.extractions.ExtractionRetrieveParams
import com.x_twitter_scraper.api.models.extractions.ExtractionRunParams
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ExtractionServiceAsyncTest {
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val extractionServiceAsync = client.extractions()

        val extractionFuture =
            extractionServiceAsync.retrieve(
                ExtractionRetrieveParams.builder().id("id").cursor("cursor").limit(1L).build()
            )

        val extraction = extractionFuture.get()
        kotlin.test.assertNotNull(extraction)
    }

    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val extractionServiceAsync = client.extractions()

        val extractionsFuture =
            extractionServiceAsync.list(
                ExtractionListParams.builder()
                    .cursor("cursor")
                    .limit(1L)
                    .status(ExtractionListParams.Status.RUNNING)
                    .toolType(ExtractionListParams.ToolType.FOLLOWER_EXPLORER)
                    .build()
            )

        val extractions = extractionsFuture.get()
        kotlin.test.assertNotNull(extractions)
    }

    @Test
    fun estimateCost() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val extractionServiceAsync = client.extractions()

        val responseFuture =
            extractionServiceAsync.estimateCost(
                ExtractionEstimateCostParams.builder()
                    .toolType(ExtractionEstimateCostParams.ToolType.FOLLOWER_EXPLORER)
                    .advancedQuery("min_faves:100")
                    .anyWords("ChatGPT AI model")
                    .boundingBox("-74.1 40.6 -73.9 40.8")
                    .cashtags("\$TSLA \$NVDA")
                    .conversationId("1234567890")
                    .exactPhrase("artificial intelligence")
                    .excludeWords("spam")
                    .fromUser("nasa")
                    .hashtags("#AI startups")
                    .inReplyToTweetId("1234567890")
                    .language("en")
                    .listId("1234567890")
                    .mediaType(ExtractionEstimateCostParams.MediaType.IMAGES)
                    .mentioning("example_user")
                    .minFaves(10L)
                    .minQuotes(2L)
                    .minReplies(3L)
                    .minRetweets(5L)
                    .place("96683cc9126741d1")
                    .placeCountry("US")
                    .pointRadius("-73.99 40.73 25mi")
                    .quotes(ExtractionEstimateCostParams.Quotes.INCLUDE)
                    .quotesOfTweetId("1234567890")
                    .replies(ExtractionEstimateCostParams.Replies.INCLUDE)
                    .resultsLimit(1000L)
                    .retweets(ExtractionEstimateCostParams.Retweets.EXCLUDE)
                    .retweetsOfTweetId("1234567890")
                    .searchQuery("AI trends 2025")
                    .sinceDate(LocalDate.parse("2025-01-01"))
                    .targetCommunityId("1500000000000000000")
                    .targetListId("1234567890")
                    .targetSpaceId("1vOGwMdBqpwGB")
                    .targetTweetId("1234567890")
                    .targetUsername("elonmusk")
                    .toUser("openai")
                    .untilDate(LocalDate.parse("2025-12-31"))
                    .url("example.com")
                    .verifiedOnly(false)
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun exportResults(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val extractionServiceAsync = client.extractions()
        stubFor(get(anyUrl()).willReturn(ok().withBody("abc")))

        val responseFuture =
            extractionServiceAsync.exportResults(
                ExtractionExportResultsParams.builder()
                    .id("id")
                    .format(ExtractionExportResultsParams.Format.CSV)
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
        val extractionServiceAsync = client.extractions()

        val responseFuture =
            extractionServiceAsync.run(
                ExtractionRunParams.builder()
                    .toolType(ExtractionRunParams.ToolType.FOLLOWER_EXPLORER)
                    .advancedQuery("min_faves:100")
                    .anyWords("ChatGPT AI model")
                    .boundingBox("-74.1 40.6 -73.9 40.8")
                    .cashtags("\$TSLA \$NVDA")
                    .conversationId("1234567890")
                    .exactPhrase("artificial intelligence")
                    .excludeWords("spam")
                    .fromUser("nasa")
                    .hashtags("#AI startups")
                    .inReplyToTweetId("1234567890")
                    .language("en")
                    .listId("1234567890")
                    .mediaType(ExtractionRunParams.MediaType.IMAGES)
                    .mentioning("example_user")
                    .minFaves(10L)
                    .minQuotes(2L)
                    .minReplies(3L)
                    .minRetweets(5L)
                    .place("96683cc9126741d1")
                    .placeCountry("US")
                    .pointRadius("-73.99 40.73 25mi")
                    .quotes(ExtractionRunParams.Quotes.INCLUDE)
                    .quotesOfTweetId("1234567890")
                    .replies(ExtractionRunParams.Replies.INCLUDE)
                    .resultsLimit(1000L)
                    .retweets(ExtractionRunParams.Retweets.EXCLUDE)
                    .retweetsOfTweetId("1234567890")
                    .searchQuery("AI trends 2025")
                    .sinceDate(LocalDate.parse("2025-01-01"))
                    .targetCommunityId("1500000000000000000")
                    .targetListId("1234567890")
                    .targetSpaceId("1vOGwMdBqpwGB")
                    .targetTweetId("1234567890")
                    .targetUsername("elonmusk")
                    .toUser("openai")
                    .untilDate(LocalDate.parse("2025-12-31"))
                    .url("example.com")
                    .verifiedOnly(false)
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
