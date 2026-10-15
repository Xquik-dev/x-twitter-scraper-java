// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.models.x.analysis.AnalysisBrandParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisClassifyParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisMarketSignalsParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisNewsParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisSentimentParams
import com.x_twitter_scraper.api.models.x.analysis.AnalysisViralScoreParams
import org.junit.jupiter.api.Test

internal class AnalysisServiceAsyncTest {
    @Test
    fun brand() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val analysisServiceAsync = client.x().analysis()

        val responseFuture =
            analysisServiceAsync.brand(
                AnalysisBrandParams.builder()
                    .analysis(
                        AnalysisBrandParams.Analysis.builder()
                            .concurrency(16L)
                            .context("Consumer headphones & customer service.")
                            .maxContextBytes(64000L)
                            .preset(AnalysisBrandParams.Analysis.Preset.COMPLAINTS)
                            .addQuestion(
                                AnalysisBrandParams.Analysis.Question.builder()
                                    .id("request")
                                    .instructions("What does the author ask for?")
                                    .type(AnalysisBrandParams.Analysis.Question.Type.CHOICE)
                                    .version("1")
                                    .categories(
                                        AnalysisBrandParams.Analysis.Question.Categories.builder()
                                            .putAdditionalProperty(
                                                "support",
                                                JsonValue.from("Help with a problem."),
                                            )
                                            .putAdditionalProperty(
                                                "recommendation",
                                                JsonValue.from("Advice on choosing a product."),
                                            )
                                            .build()
                                    )
                                    .criteria(
                                        AnalysisBrandParams.Analysis.Question.Criteria.builder()
                                            .no("Asks for no refund.")
                                            .yes("Asks for a refund.")
                                            .build()
                                    )
                                    .addLevel("No urgency.")
                                    .build()
                            )
                            .addTarget(
                                AnalysisBrandParams.Analysis.Target.builder()
                                    .name("Sony")
                                    .addAlias("WH-1000XM6")
                                    .build()
                            )
                            .build()
                    )
                    .addBaseline(
                        AnalysisBrandParams.Baseline.builder()
                            .answers(
                                AnalysisBrandParams.Baseline.Answers.builder()
                                    .putAdditionalProperty("sentiment", JsonValue.from("positive"))
                                    .putAdditionalProperty("intensity", JsonValue.from(1))
                                    .build()
                            )
                            .id("1893456789012345678")
                            .monitor(
                                AnalysisBrandParams.Baseline.Monitor.builder()
                                    .configurationFingerprint(
                                        "9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a"
                                    )
                                    .build()
                            )
                            .tweet(
                                AnalysisBrandParams.Baseline.Tweet.builder()
                                    .id("1893456789012345678")
                                    .build()
                            )
                            .build()
                    )
                    .cursor("DAACCgACGRElMJcAAA")
                    .limit(20L)
                    .listId("1234567890")
                    .query("Sony WH-1000XM6 lang:en")
                    .queryType(AnalysisBrandParams.QueryType.LATEST)
                    .quotesOf("1893456789012345678")
                    .repliesTo("1893456789012345678")
                    .sinceTime(AnalysisBrandParams.SinceTime.ofString("2026-09-25T00:00:00Z"))
                    .addText("We shipped dark mode today. Tell us what breaks.")
                    .addTweetId("1893456789012345678")
                    .untilTime(AnalysisBrandParams.UntilTime.ofString("2026-09-26T00:00:00Z"))
                    .username("@NASA")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun classify() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val analysisServiceAsync = client.x().analysis()

        val responseFuture =
            analysisServiceAsync.classify(
                AnalysisClassifyParams.builder()
                    .analysis(
                        AnalysisClassifyParams.Analysis.builder()
                            .concurrency(16L)
                            .context("Consumer headphones & customer service.")
                            .maxContextBytes(64000L)
                            .preset(AnalysisClassifyParams.Analysis.Preset.COMPLAINTS)
                            .addQuestion(
                                AnalysisClassifyParams.Analysis.Question.builder()
                                    .id("request")
                                    .instructions("What does the author ask for?")
                                    .type(AnalysisClassifyParams.Analysis.Question.Type.CHOICE)
                                    .version("1")
                                    .categories(
                                        AnalysisClassifyParams.Analysis.Question.Categories
                                            .builder()
                                            .putAdditionalProperty(
                                                "support",
                                                JsonValue.from("Help with a problem."),
                                            )
                                            .putAdditionalProperty(
                                                "recommendation",
                                                JsonValue.from("Advice on choosing a product."),
                                            )
                                            .build()
                                    )
                                    .criteria(
                                        AnalysisClassifyParams.Analysis.Question.Criteria.builder()
                                            .no("Asks for no refund.")
                                            .yes("Asks for a refund.")
                                            .build()
                                    )
                                    .addLevel("No urgency.")
                                    .build()
                            )
                            .addTarget(
                                AnalysisClassifyParams.Analysis.Target.builder()
                                    .name("Sony")
                                    .addAlias("WH-1000XM6")
                                    .build()
                            )
                            .build()
                    )
                    .addBaseline(
                        AnalysisClassifyParams.Baseline.builder()
                            .answers(
                                AnalysisClassifyParams.Baseline.Answers.builder()
                                    .putAdditionalProperty("sentiment", JsonValue.from("positive"))
                                    .putAdditionalProperty("intensity", JsonValue.from(1))
                                    .build()
                            )
                            .id("1893456789012345678")
                            .monitor(
                                AnalysisClassifyParams.Baseline.Monitor.builder()
                                    .configurationFingerprint(
                                        "9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a"
                                    )
                                    .build()
                            )
                            .tweet(
                                AnalysisClassifyParams.Baseline.Tweet.builder()
                                    .id("1893456789012345678")
                                    .build()
                            )
                            .build()
                    )
                    .cursor("DAACCgACGRElMJcAAA")
                    .limit(20L)
                    .listId("1234567890")
                    .query("Sony WH-1000XM6 lang:en")
                    .queryType(AnalysisClassifyParams.QueryType.LATEST)
                    .quotesOf("1893456789012345678")
                    .repliesTo("1893456789012345678")
                    .sinceTime(AnalysisClassifyParams.SinceTime.ofString("2026-09-25T00:00:00Z"))
                    .addText("We shipped dark mode today. Tell us what breaks.")
                    .addTweetId("1893456789012345678")
                    .untilTime(AnalysisClassifyParams.UntilTime.ofString("2026-09-26T00:00:00Z"))
                    .username("@NASA")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun marketSignals() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val analysisServiceAsync = client.x().analysis()

        val responseFuture =
            analysisServiceAsync.marketSignals(
                AnalysisMarketSignalsParams.builder()
                    .analysis(
                        AnalysisMarketSignalsParams.Analysis.builder()
                            .concurrency(16L)
                            .context("Consumer headphones & customer service.")
                            .maxContextBytes(64000L)
                            .preset(AnalysisMarketSignalsParams.Analysis.Preset.COMPLAINTS)
                            .addQuestion(
                                AnalysisMarketSignalsParams.Analysis.Question.builder()
                                    .id("request")
                                    .instructions("What does the author ask for?")
                                    .type(AnalysisMarketSignalsParams.Analysis.Question.Type.CHOICE)
                                    .version("1")
                                    .categories(
                                        AnalysisMarketSignalsParams.Analysis.Question.Categories
                                            .builder()
                                            .putAdditionalProperty(
                                                "support",
                                                JsonValue.from("Help with a problem."),
                                            )
                                            .putAdditionalProperty(
                                                "recommendation",
                                                JsonValue.from("Advice on choosing a product."),
                                            )
                                            .build()
                                    )
                                    .criteria(
                                        AnalysisMarketSignalsParams.Analysis.Question.Criteria
                                            .builder()
                                            .no("Asks for no refund.")
                                            .yes("Asks for a refund.")
                                            .build()
                                    )
                                    .addLevel("No urgency.")
                                    .build()
                            )
                            .addTarget(
                                AnalysisMarketSignalsParams.Analysis.Target.builder()
                                    .name("Sony")
                                    .addAlias("WH-1000XM6")
                                    .build()
                            )
                            .build()
                    )
                    .addBaseline(
                        AnalysisMarketSignalsParams.Baseline.builder()
                            .answers(
                                AnalysisMarketSignalsParams.Baseline.Answers.builder()
                                    .putAdditionalProperty("sentiment", JsonValue.from("positive"))
                                    .putAdditionalProperty("intensity", JsonValue.from(1))
                                    .build()
                            )
                            .id("1893456789012345678")
                            .monitor(
                                AnalysisMarketSignalsParams.Baseline.Monitor.builder()
                                    .configurationFingerprint(
                                        "9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a"
                                    )
                                    .build()
                            )
                            .tweet(
                                AnalysisMarketSignalsParams.Baseline.Tweet.builder()
                                    .id("1893456789012345678")
                                    .build()
                            )
                            .build()
                    )
                    .cursor("DAACCgACGRElMJcAAA")
                    .limit(20L)
                    .listId("1234567890")
                    .query("Sony WH-1000XM6 lang:en")
                    .queryType(AnalysisMarketSignalsParams.QueryType.LATEST)
                    .quotesOf("1893456789012345678")
                    .repliesTo("1893456789012345678")
                    .sinceTime(
                        AnalysisMarketSignalsParams.SinceTime.ofString("2026-09-25T00:00:00Z")
                    )
                    .addText("We shipped dark mode today. Tell us what breaks.")
                    .addTweetId("1893456789012345678")
                    .untilTime(
                        AnalysisMarketSignalsParams.UntilTime.ofString("2026-09-26T00:00:00Z")
                    )
                    .username("@NASA")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun news() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val analysisServiceAsync = client.x().analysis()

        val responseFuture =
            analysisServiceAsync.news(
                AnalysisNewsParams.builder()
                    .analysis(
                        AnalysisNewsParams.Analysis.builder()
                            .concurrency(16L)
                            .context("Consumer headphones & customer service.")
                            .maxContextBytes(64000L)
                            .preset(AnalysisNewsParams.Analysis.Preset.COMPLAINTS)
                            .addQuestion(
                                AnalysisNewsParams.Analysis.Question.builder()
                                    .id("request")
                                    .instructions("What does the author ask for?")
                                    .type(AnalysisNewsParams.Analysis.Question.Type.CHOICE)
                                    .version("1")
                                    .categories(
                                        AnalysisNewsParams.Analysis.Question.Categories.builder()
                                            .putAdditionalProperty(
                                                "support",
                                                JsonValue.from("Help with a problem."),
                                            )
                                            .putAdditionalProperty(
                                                "recommendation",
                                                JsonValue.from("Advice on choosing a product."),
                                            )
                                            .build()
                                    )
                                    .criteria(
                                        AnalysisNewsParams.Analysis.Question.Criteria.builder()
                                            .no("Asks for no refund.")
                                            .yes("Asks for a refund.")
                                            .build()
                                    )
                                    .addLevel("No urgency.")
                                    .build()
                            )
                            .addTarget(
                                AnalysisNewsParams.Analysis.Target.builder()
                                    .name("Sony")
                                    .addAlias("WH-1000XM6")
                                    .build()
                            )
                            .build()
                    )
                    .addBaseline(
                        AnalysisNewsParams.Baseline.builder()
                            .answers(
                                AnalysisNewsParams.Baseline.Answers.builder()
                                    .putAdditionalProperty("sentiment", JsonValue.from("positive"))
                                    .putAdditionalProperty("intensity", JsonValue.from(1))
                                    .build()
                            )
                            .id("1893456789012345678")
                            .monitor(
                                AnalysisNewsParams.Baseline.Monitor.builder()
                                    .configurationFingerprint(
                                        "9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a"
                                    )
                                    .build()
                            )
                            .tweet(
                                AnalysisNewsParams.Baseline.Tweet.builder()
                                    .id("1893456789012345678")
                                    .build()
                            )
                            .build()
                    )
                    .cursor("DAACCgACGRElMJcAAA")
                    .limit(20L)
                    .listId("1234567890")
                    .query("Sony WH-1000XM6 lang:en")
                    .queryType(AnalysisNewsParams.QueryType.LATEST)
                    .quotesOf("1893456789012345678")
                    .repliesTo("1893456789012345678")
                    .sinceTime(AnalysisNewsParams.SinceTime.ofString("2026-09-25T00:00:00Z"))
                    .addText("We shipped dark mode today. Tell us what breaks.")
                    .addTweetId("1893456789012345678")
                    .untilTime(AnalysisNewsParams.UntilTime.ofString("2026-09-26T00:00:00Z"))
                    .username("@NASA")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun sentiment() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val analysisServiceAsync = client.x().analysis()

        val responseFuture =
            analysisServiceAsync.sentiment(
                AnalysisSentimentParams.builder()
                    .analysis(
                        AnalysisSentimentParams.Analysis.builder()
                            .concurrency(16L)
                            .context("Consumer headphones & customer service.")
                            .maxContextBytes(64000L)
                            .preset(AnalysisSentimentParams.Analysis.Preset.COMPLAINTS)
                            .addQuestion(
                                AnalysisSentimentParams.Analysis.Question.builder()
                                    .id("request")
                                    .instructions("What does the author ask for?")
                                    .type(AnalysisSentimentParams.Analysis.Question.Type.CHOICE)
                                    .version("1")
                                    .categories(
                                        AnalysisSentimentParams.Analysis.Question.Categories
                                            .builder()
                                            .putAdditionalProperty(
                                                "support",
                                                JsonValue.from("Help with a problem."),
                                            )
                                            .putAdditionalProperty(
                                                "recommendation",
                                                JsonValue.from("Advice on choosing a product."),
                                            )
                                            .build()
                                    )
                                    .criteria(
                                        AnalysisSentimentParams.Analysis.Question.Criteria.builder()
                                            .no("Asks for no refund.")
                                            .yes("Asks for a refund.")
                                            .build()
                                    )
                                    .addLevel("No urgency.")
                                    .build()
                            )
                            .addTarget(
                                AnalysisSentimentParams.Analysis.Target.builder()
                                    .name("Sony")
                                    .addAlias("WH-1000XM6")
                                    .build()
                            )
                            .build()
                    )
                    .addBaseline(
                        AnalysisSentimentParams.Baseline.builder()
                            .answers(
                                AnalysisSentimentParams.Baseline.Answers.builder()
                                    .putAdditionalProperty("sentiment", JsonValue.from("positive"))
                                    .putAdditionalProperty("intensity", JsonValue.from(1))
                                    .build()
                            )
                            .id("1893456789012345678")
                            .monitor(
                                AnalysisSentimentParams.Baseline.Monitor.builder()
                                    .configurationFingerprint(
                                        "9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a"
                                    )
                                    .build()
                            )
                            .tweet(
                                AnalysisSentimentParams.Baseline.Tweet.builder()
                                    .id("1893456789012345678")
                                    .build()
                            )
                            .build()
                    )
                    .cursor("DAACCgACGRElMJcAAA")
                    .limit(20L)
                    .listId("1234567890")
                    .query("Sony WH-1000XM6 lang:en")
                    .queryType(AnalysisSentimentParams.QueryType.LATEST)
                    .quotesOf("1893456789012345678")
                    .repliesTo("1893456789012345678")
                    .sinceTime(AnalysisSentimentParams.SinceTime.ofString("2026-09-25T00:00:00Z"))
                    .addText("We shipped dark mode today. Tell us what breaks.")
                    .addTweetId("1893456789012345678")
                    .untilTime(AnalysisSentimentParams.UntilTime.ofString("2026-09-26T00:00:00Z"))
                    .username("@NASA")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun viralScore() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val analysisServiceAsync = client.x().analysis()

        val responseFuture =
            analysisServiceAsync.viralScore(
                AnalysisViralScoreParams.builder()
                    .analysis(
                        AnalysisViralScoreParams.Analysis.builder()
                            .concurrency(16L)
                            .context("Consumer headphones & customer service.")
                            .maxContextBytes(64000L)
                            .preset(AnalysisViralScoreParams.Analysis.Preset.COMPLAINTS)
                            .addQuestion(
                                AnalysisViralScoreParams.Analysis.Question.builder()
                                    .id("request")
                                    .instructions("What does the author ask for?")
                                    .type(AnalysisViralScoreParams.Analysis.Question.Type.CHOICE)
                                    .version("1")
                                    .categories(
                                        AnalysisViralScoreParams.Analysis.Question.Categories
                                            .builder()
                                            .putAdditionalProperty(
                                                "support",
                                                JsonValue.from("Help with a problem."),
                                            )
                                            .putAdditionalProperty(
                                                "recommendation",
                                                JsonValue.from("Advice on choosing a product."),
                                            )
                                            .build()
                                    )
                                    .criteria(
                                        AnalysisViralScoreParams.Analysis.Question.Criteria
                                            .builder()
                                            .no("Asks for no refund.")
                                            .yes("Asks for a refund.")
                                            .build()
                                    )
                                    .addLevel("No urgency.")
                                    .build()
                            )
                            .addTarget(
                                AnalysisViralScoreParams.Analysis.Target.builder()
                                    .name("Sony")
                                    .addAlias("WH-1000XM6")
                                    .build()
                            )
                            .build()
                    )
                    .addBaseline(
                        AnalysisViralScoreParams.Baseline.builder()
                            .answers(
                                AnalysisViralScoreParams.Baseline.Answers.builder()
                                    .putAdditionalProperty("sentiment", JsonValue.from("positive"))
                                    .putAdditionalProperty("intensity", JsonValue.from(1))
                                    .build()
                            )
                            .id("1893456789012345678")
                            .monitor(
                                AnalysisViralScoreParams.Baseline.Monitor.builder()
                                    .configurationFingerprint(
                                        "9f2c4e1b7a5d3c8e6f0a1b2c3d4e5f60718293a4b5c6d7e8f90a1b2c3d4e5f6a"
                                    )
                                    .build()
                            )
                            .tweet(
                                AnalysisViralScoreParams.Baseline.Tweet.builder()
                                    .id("1893456789012345678")
                                    .build()
                            )
                            .build()
                    )
                    .cursor("DAACCgACGRElMJcAAA")
                    .limit(20L)
                    .listId("1234567890")
                    .query("Sony WH-1000XM6 lang:en")
                    .queryType(AnalysisViralScoreParams.QueryType.LATEST)
                    .quotesOf("1893456789012345678")
                    .repliesTo("1893456789012345678")
                    .sinceTime(AnalysisViralScoreParams.SinceTime.ofString("2026-09-25T00:00:00Z"))
                    .addText("We shipped dark mode today. Tell us what breaks.")
                    .addTweetId("1893456789012345678")
                    .untilTime(AnalysisViralScoreParams.UntilTime.ofString("2026-09-26T00:00:00Z"))
                    .username("@NASA")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
