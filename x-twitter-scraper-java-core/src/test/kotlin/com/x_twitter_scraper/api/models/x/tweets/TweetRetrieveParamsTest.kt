// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetRetrieveParamsTest {

    @Test
    fun create() {
        TweetRetrieveParams.builder().tweetId("tweetId").build()
    }

    @Test
    fun pathParams() {
        val params = TweetRetrieveParams.builder().tweetId("tweetId").build()

        assertThat(params._pathParam(0)).isEqualTo("tweetId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
