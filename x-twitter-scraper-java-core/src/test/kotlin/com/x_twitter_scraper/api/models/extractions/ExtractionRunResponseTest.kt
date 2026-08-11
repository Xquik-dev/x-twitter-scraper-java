// File generated from our OpenAPI spec by Stainless.

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
}
