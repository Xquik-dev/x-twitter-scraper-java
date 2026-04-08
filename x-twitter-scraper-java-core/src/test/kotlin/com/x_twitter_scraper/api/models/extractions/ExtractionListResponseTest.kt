// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExtractionListResponseTest {

    @Test
    fun create() {
        val extractionListResponse =
            ExtractionListResponse.builder()
                .addExtraction(
                    ExtractionJob.builder()
                        .id("id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status(ExtractionJob.Status.RUNNING)
                        .toolType(ExtractionJob.ToolType.FOLLOWER_EXPLORER)
                        .totalResults(0L)
                        .completedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .hasMore(false)
                .nextCursor("abc123")
                .build()

        assertThat(extractionListResponse.extractions())
            .containsExactly(
                ExtractionJob.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .status(ExtractionJob.Status.RUNNING)
                    .toolType(ExtractionJob.ToolType.FOLLOWER_EXPLORER)
                    .totalResults(0L)
                    .completedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(extractionListResponse.hasMore()).isEqualTo(false)
        assertThat(extractionListResponse.nextCursor()).contains("abc123")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val extractionListResponse =
            ExtractionListResponse.builder()
                .addExtraction(
                    ExtractionJob.builder()
                        .id("id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status(ExtractionJob.Status.RUNNING)
                        .toolType(ExtractionJob.ToolType.FOLLOWER_EXPLORER)
                        .totalResults(0L)
                        .completedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .hasMore(false)
                .nextCursor("abc123")
                .build()

        val roundtrippedExtractionListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extractionListResponse),
                jacksonTypeRef<ExtractionListResponse>(),
            )

        assertThat(roundtrippedExtractionListResponse).isEqualTo(extractionListResponse)
    }
}
