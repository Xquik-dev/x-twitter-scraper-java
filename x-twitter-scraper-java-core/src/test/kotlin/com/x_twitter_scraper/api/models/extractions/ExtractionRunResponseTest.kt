// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.extractions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExtractionRunResponseTest {

    @Test
    fun create() {
        val extractionRunResponse =
            ExtractionRunResponse.builder()
                .allowed(true)
                .creditsAvailable("creditsAvailable")
                .creditsRequired("creditsRequired")
                .estimatedResults(0L)
                .source("source")
                .resolvedXUserId("resolvedXUserId")
                .build()

        assertThat(extractionRunResponse.allowed()).isEqualTo(true)
        assertThat(extractionRunResponse.creditsAvailable()).isEqualTo("creditsAvailable")
        assertThat(extractionRunResponse.creditsRequired()).isEqualTo("creditsRequired")
        assertThat(extractionRunResponse.estimatedResults()).isEqualTo(0L)
        assertThat(extractionRunResponse.source()).isEqualTo("source")
        assertThat(extractionRunResponse.resolvedXUserId()).contains("resolvedXUserId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val extractionRunResponse =
            ExtractionRunResponse.builder()
                .allowed(true)
                .creditsAvailable("creditsAvailable")
                .creditsRequired("creditsRequired")
                .estimatedResults(0L)
                .source("source")
                .resolvedXUserId("resolvedXUserId")
                .build()

        val roundtrippedExtractionRunResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extractionRunResponse),
                jacksonTypeRef<ExtractionRunResponse>(),
            )

        assertThat(roundtrippedExtractionRunResponse).isEqualTo(extractionRunResponse)
    }

    @Test
    fun additionalFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json =
            """{"id":"sample","pollAfterMs":1,"statusUrl":"sample","waitUrl":"sample","toolType":"article_extractor","status":"pending"}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<ExtractionRunResponse>())

        assertThat(model.id()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("id")
        assertThat(model.pollAfterMs()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("pollAfterMs")
        assertThat(model.statusUrl()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("statusUrl")
        assertThat(model.waitUrl()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("waitUrl")
        assertThat(model.toolType()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("toolType")
        assertThat(model.status()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("status")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<ExtractionRunResponse>(),
                )
            )
            .isEqualTo(model)
    }
}
