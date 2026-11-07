// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.extractions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExtractionJobTest {

    @Test
    fun create() {
        val extractionJob =
            ExtractionJob.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(ExtractionJob.Status.RUNNING)
                .toolType(ExtractionJob.ToolType.FOLLOWER_EXPLORER)
                .totalResults(0L)
                .url("https://dashboard.xquik.com/activity/a1")
                .completedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(extractionJob.id()).isEqualTo("id")
        assertThat(extractionJob.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(extractionJob.status()).isEqualTo(ExtractionJob.Status.RUNNING)
        assertThat(extractionJob.toolType()).isEqualTo(ExtractionJob.ToolType.FOLLOWER_EXPLORER)
        assertThat(extractionJob.totalResults()).isEqualTo(0L)
        assertThat(extractionJob.url()).isEqualTo("https://dashboard.xquik.com/activity/a1")
        assertThat(extractionJob.completedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val extractionJob =
            ExtractionJob.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(ExtractionJob.Status.RUNNING)
                .toolType(ExtractionJob.ToolType.FOLLOWER_EXPLORER)
                .totalResults(0L)
                .url("https://dashboard.xquik.com/activity/a1")
                .completedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedExtractionJob =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extractionJob),
                jacksonTypeRef<ExtractionJob>(),
            )

        assertThat(roundtrippedExtractionJob).isEqualTo(extractionJob)
    }

    @Test
    fun additionalFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json =
            """{"resultsLimit":1,"effectiveResultsLimit":1,"completionReason":"budget_limited","errorMessage":"sample"}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<ExtractionJob>())

        assertThat(model.resultsLimit()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("resultsLimit")
        assertThat(model.effectiveResultsLimit()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("effectiveResultsLimit")
        assertThat(model.completionReason()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("completionReason")
        assertThat(model.errorMessage()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("errorMessage")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<ExtractionJob>(),
                )
            )
            .isEqualTo(model)
    }

    @Test
    fun additionalStatusValues() {
        assertThat(ExtractionJob.Status.of("canceled").known())
            .isEqualTo(ExtractionJob.Status.Known.CANCELED)
        assertThat(ExtractionJob.Status.of("pending").known())
            .isEqualTo(ExtractionJob.Status.Known.PENDING)
    }

    @Test
    fun everyToolTypeKnowsUserAffiliates() {
        assertThat(ExtractionJob.ToolType.of("user_affiliates").known())
            .isEqualTo(ExtractionJob.ToolType.Known.USER_AFFILIATES)
        assertThat(ExtractionJob.ToolType.USER_AFFILIATES.value())
            .isEqualTo(ExtractionJob.ToolType.Value.USER_AFFILIATES)
        assertThat(ExtractionListParams.ToolType.of("user_affiliates").known())
            .isEqualTo(ExtractionListParams.ToolType.Known.USER_AFFILIATES)
        assertThat(ExtractionListParams.ToolType.USER_AFFILIATES.value())
            .isEqualTo(ExtractionListParams.ToolType.Value.USER_AFFILIATES)
        assertThat(ExtractionEstimateCostParams.ToolType.of("user_affiliates").known())
            .isEqualTo(ExtractionEstimateCostParams.ToolType.Known.USER_AFFILIATES)
        assertThat(ExtractionEstimateCostParams.ToolType.USER_AFFILIATES.value())
            .isEqualTo(ExtractionEstimateCostParams.ToolType.Value.USER_AFFILIATES)
        assertThat(ExtractionRunParams.ToolType.of("user_affiliates").known())
            .isEqualTo(ExtractionRunParams.ToolType.Known.USER_AFFILIATES)
        assertThat(ExtractionRunParams.ToolType.USER_AFFILIATES.value())
            .isEqualTo(ExtractionRunParams.ToolType.Value.USER_AFFILIATES)
    }
}
