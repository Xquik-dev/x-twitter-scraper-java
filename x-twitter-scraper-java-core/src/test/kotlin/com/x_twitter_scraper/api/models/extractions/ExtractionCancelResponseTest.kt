// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.extractions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExtractionCancelResponseTest {

    @Test
    fun create() {
        val extractionCancelResponse = ExtractionCancelResponse.builder().id("aB3dE6gH9jK2").build()

        assertThat(extractionCancelResponse.id()).isEqualTo("aB3dE6gH9jK2")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val extractionCancelResponse = ExtractionCancelResponse.builder().id("aB3dE6gH9jK2").build()

        val roundtrippedExtractionCancelResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extractionCancelResponse),
                jacksonTypeRef<ExtractionCancelResponse>(),
            )

        assertThat(roundtrippedExtractionCancelResponse).isEqualTo(extractionCancelResponse)
    }
}
