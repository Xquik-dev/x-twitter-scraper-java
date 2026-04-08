// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users.follow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FollowDeleteAllParamsTest {

    @Test
    fun create() {
        FollowDeleteAllParams.builder().id("id").account("@elonmusk").build()
    }

    @Test
    fun pathParams() {
        val params = FollowDeleteAllParams.builder().id("id").account("@elonmusk").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params = FollowDeleteAllParams.builder().id("id").account("@elonmusk").build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
    }
}
