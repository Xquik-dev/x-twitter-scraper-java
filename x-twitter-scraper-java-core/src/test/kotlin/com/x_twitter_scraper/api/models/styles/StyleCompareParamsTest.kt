// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.styles

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StyleCompareParamsTest {

    @Test
    fun create() {
        StyleCompareParams.builder().username1("username1").username2("username2").build()
    }

    @Test
    fun queryParams() {
        val params =
            StyleCompareParams.builder().username1("username1").username2("username2").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("username1", "username1")
                    .put("username2", "username2")
                    .build()
            )
    }
}
