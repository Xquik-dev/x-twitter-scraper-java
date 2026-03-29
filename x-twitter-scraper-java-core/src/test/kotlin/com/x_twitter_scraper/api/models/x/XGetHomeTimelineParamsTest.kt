// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetHomeTimelineParamsTest {

    @Test
    fun create() {
        XGetHomeTimelineParams.builder().cursor("cursor").seenTweetIds("seenTweetIds").build()
    }

    @Test
    fun queryParams() {
        val params =
            XGetHomeTimelineParams.builder().cursor("cursor").seenTweetIds("seenTweetIds").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("cursor", "cursor")
                    .put("seenTweetIds", "seenTweetIds")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = XGetHomeTimelineParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
