// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.followers

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FollowerRetrieveCheckParamsTest {

    @Test
    fun create() {
        FollowerRetrieveCheckParams.builder().source("source").target("target").build()
    }

    @Test
    fun queryParams() {
        val params = FollowerRetrieveCheckParams.builder().source("source").target("target").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("source", "source").put("target", "target").build()
            )
    }
}
