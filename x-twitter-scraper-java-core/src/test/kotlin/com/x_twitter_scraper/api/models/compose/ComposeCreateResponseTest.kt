// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.compose

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ComposeCreateResponseTest {

    @Test
    fun ofPrepareResult() {
        val prepareResult =
            ComposeCreateResponse.ComposePrepareResult.builder()
                .contentRules(
                    listOf(
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                            .rule("rule")
                            .build(),
                    )
                )
                .engagementMultipliers(
                    listOf(
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier.builder()
                            .action("action")
                            .build(),
                    )
                )
                .engagementVelocity("engagementVelocity")
                .followUpQuestions(listOf("string", "string", "string", "string"))
                .intentUrl("https://example.com")
                .nextStep("nextStep")
                .scorerWeights(
                    listOf(
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                        ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                            .context("context")
                            .signal("signal")
                            .build(),
                    )
                )
                .source("source")
                .topPenalties(listOf("string", "string", "string", "string"))
                .addSavedStyle(
                    ComposeCreateResponse.ComposePrepareResult.SavedStyle.builder()
                        .tweetCount(0L)
                        .username("username")
                        .build()
                )
                .styleNote("styleNote")
                .addStyleTweet("string")
                .build()

        val composeCreateResponse = ComposeCreateResponse.ofPrepareResult(prepareResult)

        assertThat(composeCreateResponse.prepareResult()).contains(prepareResult)
        assertThat(composeCreateResponse.refineResult()).isEmpty
        assertThat(composeCreateResponse.scoreResult()).isEmpty
    }

    @Test
    fun ofPrepareResultRoundtrip() {
        val jsonMapper = jsonMapper()
        val composeCreateResponse =
            ComposeCreateResponse.ofPrepareResult(
                ComposeCreateResponse.ComposePrepareResult.builder()
                    .contentRules(
                        listOf(
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ContentRule.builder()
                                .rule("rule")
                                .build(),
                        )
                    )
                    .engagementMultipliers(
                        listOf(
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.EngagementMultiplier
                                .builder()
                                .action("action")
                                .build(),
                        )
                    )
                    .engagementVelocity("engagementVelocity")
                    .followUpQuestions(listOf("string", "string", "string", "string"))
                    .intentUrl("https://example.com")
                    .nextStep("nextStep")
                    .scorerWeights(
                        listOf(
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                            ComposeCreateResponse.ComposePrepareResult.ScorerWeight.builder()
                                .context("context")
                                .signal("signal")
                                .build(),
                        )
                    )
                    .source("source")
                    .topPenalties(listOf("string", "string", "string", "string"))
                    .addSavedStyle(
                        ComposeCreateResponse.ComposePrepareResult.SavedStyle.builder()
                            .tweetCount(0L)
                            .username("username")
                            .build()
                    )
                    .styleNote("styleNote")
                    .addStyleTweet("string")
                    .build()
            )

        val roundtrippedComposeCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(composeCreateResponse),
                jacksonTypeRef<ComposeCreateResponse>(),
            )

        assertThat(roundtrippedComposeCreateResponse).isEqualTo(composeCreateResponse)
    }

    @Test
    fun ofRefineResult() {
        val refineResult =
            ComposeCreateResponse.ComposeRefineResult.builder()
                .addCompositionGuidance("string")
                .examplePatterns(
                    listOf(
                        ComposeCreateResponse.ComposeRefineResult.ExamplePattern.builder()
                            .description("description")
                            .pattern("pattern")
                            .build(),
                        ComposeCreateResponse.ComposeRefineResult.ExamplePattern.builder()
                            .description("description")
                            .pattern("pattern")
                            .build(),
                        ComposeCreateResponse.ComposeRefineResult.ExamplePattern.builder()
                            .description("description")
                            .pattern("pattern")
                            .build(),
                    )
                )
                .intentUrl("https://example.com")
                .nextStep("nextStep")
                .build()

        val composeCreateResponse = ComposeCreateResponse.ofRefineResult(refineResult)

        assertThat(composeCreateResponse.prepareResult()).isEmpty
        assertThat(composeCreateResponse.refineResult()).contains(refineResult)
        assertThat(composeCreateResponse.scoreResult()).isEmpty
    }

    @Test
    fun ofRefineResultRoundtrip() {
        val jsonMapper = jsonMapper()
        val composeCreateResponse =
            ComposeCreateResponse.ofRefineResult(
                ComposeCreateResponse.ComposeRefineResult.builder()
                    .addCompositionGuidance("string")
                    .examplePatterns(
                        listOf(
                            ComposeCreateResponse.ComposeRefineResult.ExamplePattern.builder()
                                .description("description")
                                .pattern("pattern")
                                .build(),
                            ComposeCreateResponse.ComposeRefineResult.ExamplePattern.builder()
                                .description("description")
                                .pattern("pattern")
                                .build(),
                            ComposeCreateResponse.ComposeRefineResult.ExamplePattern.builder()
                                .description("description")
                                .pattern("pattern")
                                .build(),
                        )
                    )
                    .intentUrl("https://example.com")
                    .nextStep("nextStep")
                    .build()
            )

        val roundtrippedComposeCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(composeCreateResponse),
                jacksonTypeRef<ComposeCreateResponse>(),
            )

        assertThat(roundtrippedComposeCreateResponse).isEqualTo(composeCreateResponse)
    }

    @Test
    fun ofScoreResult() {
        val scoreResult =
            ComposeCreateResponse.ComposeScoreResult.builder()
                .checklist(
                    listOf(
                        ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                            .factor("factor")
                            .passed(true)
                            .suggestion("suggestion")
                            .build(),
                        ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                            .factor("factor")
                            .passed(true)
                            .suggestion("suggestion")
                            .build(),
                        ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                            .factor("factor")
                            .passed(true)
                            .suggestion("suggestion")
                            .build(),
                        ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                            .factor("factor")
                            .passed(true)
                            .suggestion("suggestion")
                            .build(),
                        ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                            .factor("factor")
                            .passed(true)
                            .suggestion("suggestion")
                            .build(),
                        ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                            .factor("factor")
                            .passed(true)
                            .suggestion("suggestion")
                            .build(),
                        ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                            .factor("factor")
                            .passed(true)
                            .suggestion("suggestion")
                            .build(),
                        ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                            .factor("factor")
                            .passed(true)
                            .suggestion("suggestion")
                            .build(),
                        ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                            .factor("factor")
                            .passed(true)
                            .suggestion("suggestion")
                            .build(),
                    )
                )
                .nextStep("nextStep")
                .passed(true)
                .passedCount(0L)
                .topSuggestion("topSuggestion")
                .intentUrl("https://example.com")
                .build()

        val composeCreateResponse = ComposeCreateResponse.ofScoreResult(scoreResult)

        assertThat(composeCreateResponse.prepareResult()).isEmpty
        assertThat(composeCreateResponse.refineResult()).isEmpty
        assertThat(composeCreateResponse.scoreResult()).contains(scoreResult)
    }

    @Test
    fun ofScoreResultRoundtrip() {
        val jsonMapper = jsonMapper()
        val composeCreateResponse =
            ComposeCreateResponse.ofScoreResult(
                ComposeCreateResponse.ComposeScoreResult.builder()
                    .checklist(
                        listOf(
                            ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                                .factor("factor")
                                .passed(true)
                                .suggestion("suggestion")
                                .build(),
                            ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                                .factor("factor")
                                .passed(true)
                                .suggestion("suggestion")
                                .build(),
                            ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                                .factor("factor")
                                .passed(true)
                                .suggestion("suggestion")
                                .build(),
                            ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                                .factor("factor")
                                .passed(true)
                                .suggestion("suggestion")
                                .build(),
                            ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                                .factor("factor")
                                .passed(true)
                                .suggestion("suggestion")
                                .build(),
                            ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                                .factor("factor")
                                .passed(true)
                                .suggestion("suggestion")
                                .build(),
                            ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                                .factor("factor")
                                .passed(true)
                                .suggestion("suggestion")
                                .build(),
                            ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                                .factor("factor")
                                .passed(true)
                                .suggestion("suggestion")
                                .build(),
                            ComposeCreateResponse.ComposeScoreResult.Checklist.builder()
                                .factor("factor")
                                .passed(true)
                                .suggestion("suggestion")
                                .build(),
                        )
                    )
                    .nextStep("nextStep")
                    .passed(true)
                    .passedCount(0L)
                    .topSuggestion("topSuggestion")
                    .intentUrl("https://example.com")
                    .build()
            )

        val roundtrippedComposeCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(composeCreateResponse),
                jacksonTypeRef<ComposeCreateResponse>(),
            )

        assertThat(roundtrippedComposeCreateResponse).isEqualTo(composeCreateResponse)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val composeCreateResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ComposeCreateResponse>())

        val e =
            assertThrows<XTwitterScraperInvalidDataException> { composeCreateResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
