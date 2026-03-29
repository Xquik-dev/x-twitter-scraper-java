// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExtractionExportResultsParamsTest {

    @Test
    fun create() {
        ExtractionExportResultsParams.builder()
            .id("id")
            .format(ExtractionExportResultsParams.Format.CSV)
            .build()
    }

    @Test
    fun pathParams() {
        val params = ExtractionExportResultsParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ExtractionExportResultsParams.builder()
                .id("id")
                .format(ExtractionExportResultsParams.Format.CSV)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("format", "csv").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ExtractionExportResultsParams.builder().id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
