// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExtractionJobTest {

    @Test
    fun create() {
        val extractionJob =
            ExtractionJob.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(ExtractionJob.Status.RUNNING)
                .toolType(ExtractionJob.ToolType.ARTICLE_EXTRACTOR)
                .totalResults(0L)
                .completedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(extractionJob.id()).isEqualTo("id")
        assertThat(extractionJob.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(extractionJob.status()).isEqualTo(ExtractionJob.Status.RUNNING)
        assertThat(extractionJob.toolType()).isEqualTo(ExtractionJob.ToolType.ARTICLE_EXTRACTOR)
        assertThat(extractionJob.totalResults()).isEqualTo(0L)
        assertThat(extractionJob.completedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val extractionJob =
            ExtractionJob.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(ExtractionJob.Status.RUNNING)
                .toolType(ExtractionJob.ToolType.ARTICLE_EXTRACTOR)
                .totalResults(0L)
                .completedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedExtractionJob =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extractionJob),
                jacksonTypeRef<ExtractionJob>(),
            )

        assertThat(roundtrippedExtractionJob).isEqualTo(extractionJob)
    }
}
