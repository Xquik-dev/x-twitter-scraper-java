// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.monitors.keywords

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class KeywordDeactivateResponseTest {

    @Test
    fun create() {
        val keywordDeactivateResponse = KeywordDeactivateResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val keywordDeactivateResponse = KeywordDeactivateResponse.builder().build()

        val roundtrippedKeywordDeactivateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(keywordDeactivateResponse),
                jacksonTypeRef<KeywordDeactivateResponse>(),
            )

        assertThat(roundtrippedKeywordDeactivateResponse).isEqualTo(keywordDeactivateResponse)
    }

    @Test
    fun additionalFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json = """{"deletionStatus":"deleting","statusUrl":"sample"}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<KeywordDeactivateResponse>())

        assertThat(model.deletionStatus()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("deletionStatus")
        assertThat(model.statusUrl()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("statusUrl")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<KeywordDeactivateResponse>(),
                )
            )
            .isEqualTo(model)
    }
}
