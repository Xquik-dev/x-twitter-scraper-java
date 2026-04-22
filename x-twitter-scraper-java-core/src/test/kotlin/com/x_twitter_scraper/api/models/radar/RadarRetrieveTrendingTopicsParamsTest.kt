// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.radar

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RadarRetrieveTrendingTopicsParamsTest {

    @Test
    fun create() {
        RadarRetrieveTrendingTopicsParams.builder()
            .after("after")
            .category(RadarRetrieveTrendingTopicsParams.Category.GENERAL)
            .hours(1L)
            .limit(1L)
            .region("region")
            .source(RadarRetrieveTrendingTopicsParams.Source.GITHUB)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            RadarRetrieveTrendingTopicsParams.builder()
                .after("after")
                .category(RadarRetrieveTrendingTopicsParams.Category.GENERAL)
                .hours(1L)
                .limit(1L)
                .region("region")
                .source(RadarRetrieveTrendingTopicsParams.Source.GITHUB)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("category", "general")
                    .put("hours", "1")
                    .put("limit", "1")
                    .put("region", "region")
                    .put("source", "github")
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
