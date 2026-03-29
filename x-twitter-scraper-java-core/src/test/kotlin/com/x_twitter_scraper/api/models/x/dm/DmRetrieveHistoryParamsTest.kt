// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.dm

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DmRetrieveHistoryParamsTest {

    @Test
    fun create() {
        DmRetrieveHistoryParams.builder().userId("userId").cursor("cursor").maxId("maxId").build()
    }

    @Test
    fun pathParams() {
        val params = DmRetrieveHistoryParams.builder().userId("userId").build()

        assertThat(params._pathParam(0)).isEqualTo("userId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            DmRetrieveHistoryParams.builder()
                .userId("userId")
                .cursor("cursor")
                .maxId("maxId")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("cursor", "cursor").put("maxId", "maxId").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = DmRetrieveHistoryParams.builder().userId("userId").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
