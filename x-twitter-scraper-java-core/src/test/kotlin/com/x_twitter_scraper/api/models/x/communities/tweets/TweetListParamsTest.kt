// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities.tweets

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetListParamsTest {

    @Test
    fun create() {
        TweetListParams.builder().q("q").cursor("cursor").queryType("queryType").build()
    }

    @Test
    fun queryParams() {
        val params =
            TweetListParams.builder().q("q").cursor("cursor").queryType("queryType").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("q", "q")
                    .put("cursor", "cursor")
                    .put("queryType", "queryType")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = TweetListParams.builder().q("q").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("q", "q").build())
    }
}
