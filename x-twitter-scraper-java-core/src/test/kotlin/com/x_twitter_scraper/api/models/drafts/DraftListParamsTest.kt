// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.drafts

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DraftListParamsTest {

    @Test
    fun create() {
        DraftListParams.builder().afterCursor("afterCursor").limit(1L).build()
    }

    @Test
    fun queryParams() {
        val params = DraftListParams.builder().afterCursor("afterCursor").limit(1L).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("afterCursor", "afterCursor").put("limit", "1").build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = DraftListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
