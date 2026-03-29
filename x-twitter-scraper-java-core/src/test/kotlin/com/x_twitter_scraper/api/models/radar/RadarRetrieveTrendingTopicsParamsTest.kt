// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.radar

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RadarRetrieveTrendingTopicsParamsTest {

    @Test
    fun create() {
        RadarRetrieveTrendingTopicsParams.builder()
            .category("category")
            .count(0L)
            .hours(0L)
            .region("region")
            .source("source")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            RadarRetrieveTrendingTopicsParams.builder()
                .category("category")
                .count(0L)
                .hours(0L)
                .region("region")
                .source("source")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("category", "category")
                    .put("count", "0")
                    .put("hours", "0")
                    .put("region", "region")
                    .put("source", "source")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = RadarRetrieveTrendingTopicsParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
