// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.draws

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DrawListParamsTest {

    @Test
    fun create() {
        DrawListParams.builder().after("after").limit(1L).build()
    }

    @Test
    fun queryParams() {
        val params = DrawListParams.builder().after("after").limit(1L).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("after", "after").put("limit", "1").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = DrawListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
