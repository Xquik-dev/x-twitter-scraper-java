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
                .id("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
                .status(ExtractionRunResponse.Status.RUNNING)
                .toolType(ExtractionRunResponse.ToolType.FOLLOWER_EXPLORER)
                .build()

        assertThat(extractionRunResponse.id()).isEqualTo("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
        assertThat(extractionRunResponse.status()).isEqualTo(ExtractionRunResponse.Status.RUNNING)
        assertThat(extractionRunResponse.toolType())
            .isEqualTo(ExtractionRunResponse.ToolType.FOLLOWER_EXPLORER)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val extractionRunResponse =
            ExtractionRunResponse.builder()
                .id("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
                .status(ExtractionRunResponse.Status.RUNNING)
                .toolType(ExtractionRunResponse.ToolType.FOLLOWER_EXPLORER)
                .build()

        val roundtrippedExtractionRunResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extractionRunResponse),
                jacksonTypeRef<ExtractionRunResponse>(),
            )

        assertThat(roundtrippedExtractionRunResponse).isEqualTo(extractionRunResponse)
    }
}
