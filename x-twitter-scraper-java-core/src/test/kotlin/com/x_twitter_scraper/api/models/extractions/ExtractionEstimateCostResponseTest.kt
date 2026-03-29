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
                .estimatedResults(0L)
                .projectedPercent(0.0)
                .source("source")
                .usagePercent(0.0)
                .build()

        assertThat(extractionEstimateCostResponse.allowed()).isEqualTo(true)
        assertThat(extractionEstimateCostResponse.estimatedResults()).isEqualTo(0L)
        assertThat(extractionEstimateCostResponse.projectedPercent()).isEqualTo(0.0)
        assertThat(extractionEstimateCostResponse.source()).isEqualTo("source")
        assertThat(extractionEstimateCostResponse.usagePercent()).isEqualTo(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val extractionEstimateCostResponse =
            ExtractionEstimateCostResponse.builder()
                .allowed(true)
                .estimatedResults(0L)
                .projectedPercent(0.0)
                .source("source")
                .usagePercent(0.0)
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
