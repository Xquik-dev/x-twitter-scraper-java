// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveSearchParamsTest {

    @Test
    fun create() {
        UserRetrieveSearchParams.builder().q("q").cursor("cursor").build()
    }

    @Test
    fun queryParams() {
        val params = UserRetrieveSearchParams.builder().q("q").cursor("cursor").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("q", "q").put("cursor", "cursor").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = UserRetrieveSearchParams.builder().q("q").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("q", "q").build())
    }
}
