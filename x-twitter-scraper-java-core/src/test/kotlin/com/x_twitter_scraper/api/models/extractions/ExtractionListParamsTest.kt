// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExtractionListParamsTest {

    @Test
    fun create() {
        ExtractionListParams.builder()
            .after("after")
            .limit(1L)
            .status(ExtractionListParams.Status.RUNNING)
            .toolType(ExtractionListParams.ToolType.FOLLOWER_EXPLORER)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ExtractionListParams.builder()
                .after("after")
                .limit(1L)
                .status(ExtractionListParams.Status.RUNNING)
                .toolType(ExtractionListParams.ToolType.FOLLOWER_EXPLORER)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("limit", "1")
                    .put("status", "running")
                    .put("toolType", "follower_explorer")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ExtractionListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
