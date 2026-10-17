// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.extractions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExtractionRetrieveResponseTest {

    @Test
    fun create() {
        val extractionRetrieveResponse =
            ExtractionRetrieveResponse.builder()
                .hasMore(false)
                .job(
                    ExtractionRetrieveResponse.Job.builder()
                        .id("id")
                        .toolType(ExtractionJob.ToolType.FOLLOWER_EXPLORER)
                        .status(ExtractionRetrieveResponse.Job.Status.COMPLETED)
                        .build()
                )
                .addResult(
                    ExtractionRetrieveResponse.Result.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .nextCursor("abc123")
                .build()

        assertThat(extractionRetrieveResponse.hasMore()).isEqualTo(false)
        assertThat(extractionRetrieveResponse.job())
            .isEqualTo(
                ExtractionRetrieveResponse.Job.builder()
                    .id("id")
                    .toolType(ExtractionJob.ToolType.FOLLOWER_EXPLORER)
                    .status(ExtractionRetrieveResponse.Job.Status.COMPLETED)
                    .build()
            )
        assertThat(extractionRetrieveResponse.results())
            .containsExactly(
                ExtractionRetrieveResponse.Result.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(extractionRetrieveResponse.nextCursor()).contains("abc123")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val extractionRetrieveResponse =
            ExtractionRetrieveResponse.builder()
                .hasMore(false)
                .job(
                    ExtractionRetrieveResponse.Job.builder()
                        .id("id")
                        .toolType(ExtractionJob.ToolType.FOLLOWER_EXPLORER)
                        .status(ExtractionRetrieveResponse.Job.Status.COMPLETED)
                        .build()
                )
                .addResult(
                    ExtractionRetrieveResponse.Result.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .nextCursor("abc123")
                .build()

        val roundtrippedExtractionRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extractionRetrieveResponse),
                jacksonTypeRef<ExtractionRetrieveResponse>(),
            )

        assertThat(roundtrippedExtractionRetrieveResponse).isEqualTo(extractionRetrieveResponse)
    }

    @Test
    fun additionalFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json = """{"pollAfterMs":1,"waitUrl":"sample"}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<ExtractionRetrieveResponse>())

        assertThat(model.pollAfterMs()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("pollAfterMs")
        assertThat(model.waitUrl()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("waitUrl")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<ExtractionRetrieveResponse>(),
                )
            )
            .isEqualTo(model)
    }

    @Test
    fun additionalResultFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json =
            """{"id":"sample","xUserId":"sample","xUsername":"sample","xDisplayName":"sample","xFollowersCount":1,"xVerified":true,"xProfileImageUrl":"sample","email":"sample","tweetId":"sample","tweetUrl":"sample","tweetText":"sample","tweetCreatedAt":"2025-01-15T12:00:00Z","createdAt":"2025-01-15T12:00:00Z","media":[{}],"bookmarkCount":1,"likeCount":1,"quoteCount":1,"replyCount":1,"retweetCount":1,"viewCount":1,"enrichmentData":{}}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<ExtractionRetrieveResponse.Result>())

        assertThat(model.id()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("id")
        assertThat(model.xUserId()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("xUserId")
        assertThat(model.xUsername()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("xUsername")
        assertThat(model.xDisplayName()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("xDisplayName")
        assertThat(model.xFollowersCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("xFollowersCount")
        assertThat(model.xVerified()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("xVerified")
        assertThat(model.xProfileImageUrl()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("xProfileImageUrl")
        assertThat(model.email()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("email")
        assertThat(model.tweetId()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("tweetId")
        assertThat(model.tweetUrl()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("tweetUrl")
        assertThat(model.tweetText()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("tweetText")
        assertThat(model.tweetCreatedAt()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("tweetCreatedAt")
        assertThat(model.createdAt()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("createdAt")
        assertThat(model.media()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("media")
        assertThat(model.bookmarkCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("bookmarkCount")
        assertThat(model.likeCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("likeCount")
        assertThat(model.quoteCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("quoteCount")
        assertThat(model.replyCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("replyCount")
        assertThat(model.retweetCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("retweetCount")
        assertThat(model.viewCount()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("viewCount")
        assertThat(model.enrichmentData()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("enrichmentData")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<ExtractionRetrieveResponse.Result>(),
                )
            )
            .isEqualTo(model)
    }

    @Test
    fun additionalJobFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json =
            """{"id":"sample","toolType":"article_extractor","status":"pending","totalResults":1,"resultsLimit":1,"effectiveResultsLimit":1,"completionReason":"budget_limited","errorMessage":"sample","createdAt":"2025-01-15T12:00:00Z","completedAt":"2025-01-15T12:00:00Z"}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<ExtractionRetrieveResponse.Job>())

        assertThat(model.id()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("id")
        assertThat(model.toolType()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("toolType")
        assertThat(model.status()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("status")
        assertThat(model.totalResults()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("totalResults")
        assertThat(model.resultsLimit()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("resultsLimit")
        assertThat(model.effectiveResultsLimit()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("effectiveResultsLimit")
        assertThat(model.completionReason()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("completionReason")
        assertThat(model.errorMessage()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("errorMessage")
        assertThat(model.createdAt()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("createdAt")
        assertThat(model.completedAt()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("completedAt")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<ExtractionRetrieveResponse.Job>(),
                )
            )
            .isEqualTo(model)
    }
}
