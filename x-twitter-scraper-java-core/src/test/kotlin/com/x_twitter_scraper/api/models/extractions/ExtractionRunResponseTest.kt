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
                .id("id")
                .status(ExtractionRunResponse.Status.RUNNING)
                .toolType(ExtractionRunResponse.ToolType.ARTICLE_EXTRACTOR)
                .build()

        assertThat(extractionRunResponse.id()).isEqualTo("id")
        assertThat(extractionRunResponse.status()).isEqualTo(ExtractionRunResponse.Status.RUNNING)
        assertThat(extractionRunResponse.toolType())
            .isEqualTo(ExtractionRunResponse.ToolType.ARTICLE_EXTRACTOR)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val extractionRunResponse =
            ExtractionRunResponse.builder()
                .id("id")
                .status(ExtractionRunResponse.Status.RUNNING)
                .toolType(ExtractionRunResponse.ToolType.ARTICLE_EXTRACTOR)
                .build()

        val roundtrippedExtractionRunResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extractionRunResponse),
                jacksonTypeRef<ExtractionRunResponse>(),
            )

        assertThat(roundtrippedExtractionRunResponse).isEqualTo(extractionRunResponse)
    }
}
