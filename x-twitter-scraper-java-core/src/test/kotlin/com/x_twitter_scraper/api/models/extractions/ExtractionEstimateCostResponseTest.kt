// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExtractionEstimateCostResponseTest {

    @Test
    fun create() {
        val extractionEstimateCostResponse =
            ExtractionEstimateCostResponse.builder()
                .allowed(true)
                .creditsAvailable("50000")
                .creditsRequired("500")
                .estimatedResults(500L)
                .source("replyCount")
                .resolvedXUserId("123456")
                .build()

        assertThat(extractionEstimateCostResponse.allowed()).isEqualTo(true)
        assertThat(extractionEstimateCostResponse.creditsAvailable()).isEqualTo("50000")
        assertThat(extractionEstimateCostResponse.creditsRequired()).isEqualTo("500")
        assertThat(extractionEstimateCostResponse.estimatedResults()).isEqualTo(500L)
        assertThat(extractionEstimateCostResponse.source()).isEqualTo("replyCount")
        assertThat(extractionEstimateCostResponse.resolvedXUserId()).contains("123456")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val extractionEstimateCostResponse =
            ExtractionEstimateCostResponse.builder()
                .allowed(true)
                .creditsAvailable("50000")
                .creditsRequired("500")
                .estimatedResults(500L)
                .source("replyCount")
                .resolvedXUserId("123456")
                .build()

        val roundtrippedExtractionEstimateCostResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extractionEstimateCostResponse),
                jacksonTypeRef<ExtractionEstimateCostResponse>(),
            )

        assertThat(roundtrippedExtractionEstimateCostResponse)
            .isEqualTo(extractionEstimateCostResponse)
    }
}
