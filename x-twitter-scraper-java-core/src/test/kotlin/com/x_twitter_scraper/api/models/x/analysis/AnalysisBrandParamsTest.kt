// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.analysis

import com.x_twitter_scraper.api.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AnalysisBrandParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.analysis())
            .contains(
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
        assertThat(body.baseline().getOrNull())
            .containsExactly(
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
        assertThat(body.cursor()).contains("DAACCgACGRElMJcAAA")
        assertThat(body.limit()).contains(20L)
        assertThat(body.listId()).contains("1234567890")
        assertThat(body.query()).contains("Sony WH-1000XM6 lang:en")
        assertThat(body.queryType()).contains(AnalysisBrandParams.QueryType.LATEST)
        assertThat(body.quotesOf()).contains("1893456789012345678")
        assertThat(body.repliesTo()).contains("1893456789012345678")
        assertThat(body.sinceTime())
            .contains(AnalysisBrandParams.SinceTime.ofString("2026-09-25T00:00:00Z"))
        assertThat(body.texts().getOrNull())
            .containsExactly("We shipped dark mode today. Tell us what breaks.")
        assertThat(body.tweetIds().getOrNull()).containsExactly("1893456789012345678")
        assertThat(body.untilTime())
            .contains(AnalysisBrandParams.UntilTime.ofString("2026-09-26T00:00:00Z"))
        assertThat(body.username()).contains("@NASA")
    }
}
