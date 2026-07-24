// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

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
}
