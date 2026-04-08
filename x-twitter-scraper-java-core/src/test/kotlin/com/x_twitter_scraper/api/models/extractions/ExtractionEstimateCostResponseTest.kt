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
                .estimatedResults(500L)
                .projectedPercent(30.0)
                .source("api_count")
                .usagePercent(25.0)
                .build()

        assertThat(extractionEstimateCostResponse.allowed()).isEqualTo(true)
        assertThat(extractionEstimateCostResponse.estimatedResults()).isEqualTo(500L)
        assertThat(extractionEstimateCostResponse.projectedPercent()).isEqualTo(30.0)
        assertThat(extractionEstimateCostResponse.source()).isEqualTo("api_count")
        assertThat(extractionEstimateCostResponse.usagePercent()).isEqualTo(25.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val extractionEstimateCostResponse =
            ExtractionEstimateCostResponse.builder()
                .allowed(true)
                .estimatedResults(500L)
                .projectedPercent(30.0)
                .source("api_count")
                .usagePercent(25.0)
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
