// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.analysis

import com.x_twitter_scraper.api.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AnalysisClassifyParamsTest {

    @Test
    fun create() {
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
                                AnalysisClassifyParams.Analysis.Question.Categories.builder()
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
    }

    @Test
    fun body() {
        val params =
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
                                    AnalysisClassifyParams.Analysis.Question.Categories.builder()
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

        val body = params._body()

        assertThat(body.analysis())
            .contains(
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
                                AnalysisClassifyParams.Analysis.Question.Categories.builder()
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
        assertThat(body.baseline().getOrNull())
            .containsExactly(
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
        assertThat(body.cursor()).contains("DAACCgACGRElMJcAAA")
        assertThat(body.limit()).contains(20L)
        assertThat(body.listId()).contains("1234567890")
        assertThat(body.query()).contains("Sony WH-1000XM6 lang:en")
        assertThat(body.queryType()).contains(AnalysisClassifyParams.QueryType.LATEST)
        assertThat(body.quotesOf()).contains("1893456789012345678")
        assertThat(body.repliesTo()).contains("1893456789012345678")
        assertThat(body.sinceTime())
            .contains(AnalysisClassifyParams.SinceTime.ofString("2026-09-25T00:00:00Z"))
        assertThat(body.texts().getOrNull())
            .containsExactly("We shipped dark mode today. Tell us what breaks.")
        assertThat(body.tweetIds().getOrNull()).containsExactly("1893456789012345678")
        assertThat(body.untilTime())
            .contains(AnalysisClassifyParams.UntilTime.ofString("2026-09-26T00:00:00Z"))
        assertThat(body.username()).contains("@NASA")
    }
}
