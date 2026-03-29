// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExtractionRetrieveResponseTest {

    @Test
    fun create() {
        val extractionRetrieveResponse =
            ExtractionRetrieveResponse.builder()
                .hasMore(true)
                .job(
                    ExtractionRetrieveResponse.Job.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addResult(
                    ExtractionRetrieveResponse.Result.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        assertThat(extractionRetrieveResponse.hasMore()).isEqualTo(true)
        assertThat(extractionRetrieveResponse.job())
            .isEqualTo(
                ExtractionRetrieveResponse.Job.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(extractionRetrieveResponse.results())
            .containsExactly(
                ExtractionRetrieveResponse.Result.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(extractionRetrieveResponse.nextCursor()).contains("nextCursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val extractionRetrieveResponse =
            ExtractionRetrieveResponse.builder()
                .hasMore(true)
                .job(
                    ExtractionRetrieveResponse.Job.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .addResult(
                    ExtractionRetrieveResponse.Result.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .nextCursor("nextCursor")
                .build()

        val roundtrippedExtractionRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(extractionRetrieveResponse),
                jacksonTypeRef<ExtractionRetrieveResponse>(),
            )

        assertThat(roundtrippedExtractionRetrieveResponse).isEqualTo(extractionRetrieveResponse)
    }
}
