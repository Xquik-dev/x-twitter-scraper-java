// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetTrendsParamsTest {

    @Test
    fun create() {
        XGetTrendsParams.builder().count(1L).woeid(0L).build()
    }

    @Test
    fun queryParams() {
        val params = XGetTrendsParams.builder().count(1L).woeid(0L).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("count", "1").put("woeid", "0").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = XGetTrendsParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
