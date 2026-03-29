// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets.like

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LikeCreateParamsTest {

    @Test
    fun create() {
        LikeCreateParams.builder().tweetId("tweetId").account("account").build()
    }

    @Test
    fun pathParams() {
        val params = LikeCreateParams.builder().tweetId("tweetId").account("account").build()

        assertThat(params._pathParam(0)).isEqualTo("tweetId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params = LikeCreateParams.builder().tweetId("tweetId").account("account").build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("account")
    }
}
