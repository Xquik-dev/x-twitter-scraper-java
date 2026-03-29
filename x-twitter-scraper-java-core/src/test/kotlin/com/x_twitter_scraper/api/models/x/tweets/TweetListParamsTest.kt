// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetListParamsTest {

    @Test
    fun create() {
        TweetListParams.builder().ids("ids").build()
    }

    @Test
    fun queryParams() {
        val params = TweetListParams.builder().ids("ids").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("ids", "ids").build())
    }
}
