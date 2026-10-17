// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.extractions

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExtractionRetrieveParamsTest {

    @Test
    fun create() {
        ExtractionRetrieveParams.builder()
            .id("id")
            .cursor("cursor")
            .fieldStyle(ExtractionRetrieveParams.FieldStyle.SOURCE)
            .includeRaw(true)
            .limit(1L)
            .outputMode(ExtractionRetrieveParams.OutputMode.COMPACT)
            .outputPreset(ExtractionRetrieveParams.OutputPreset.NESTED)
            .build()
    }

    @Test
    fun pathParams() {
        val params = ExtractionRetrieveParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            ExtractionRetrieveParams.builder()
                .id("id")
                .cursor("cursor")
                .fieldStyle(ExtractionRetrieveParams.FieldStyle.SOURCE)
                .includeRaw(true)
                .limit(1L)
                .outputMode(ExtractionRetrieveParams.OutputMode.COMPACT)
                .outputPreset(ExtractionRetrieveParams.OutputPreset.NESTED)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("cursor", "cursor")
                    .put("fieldStyle", "source")
                    .put("includeRaw", "true")
                    .put("limit", "1")
                    .put("outputMode", "compact")
                    .put("outputPreset", "nested")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ExtractionRetrieveParams.builder().id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun additionalFields() {
        val params = ExtractionRetrieveParams.builder().wait(1L).build()

        assertThat(params.wait()).isPresent()
        assertThat(params._queryParams().values("wait")).containsExactly("1")
        assertThat(params.toBuilder().build()).isEqualTo(params)
    }
}
