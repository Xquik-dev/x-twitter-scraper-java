// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.draws

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DrawExportParamsTest {

    @Test
    fun create() {
        DrawExportParams.builder()
            .id("id")
            .format(DrawExportParams.Format.CSV)
            .type(DrawExportParams.Type.WINNERS)
            .build()
    }

    @Test
    fun pathParams() {
        val params = DrawExportParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            DrawExportParams.builder()
                .id("id")
                .format(DrawExportParams.Format.CSV)
                .type(DrawExportParams.Type.WINNERS)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("format", "csv").put("type", "winners").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = DrawExportParams.builder().id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
