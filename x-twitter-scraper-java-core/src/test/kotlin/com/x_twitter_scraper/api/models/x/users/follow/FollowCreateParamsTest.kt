// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users.follow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FollowCreateParamsTest {

    @Test
    fun create() {
        FollowCreateParams.builder().userId("userId").account("account").build()
    }

    @Test
    fun pathParams() {
        val params = FollowCreateParams.builder().userId("userId").account("account").build()

        assertThat(params._pathParam(0)).isEqualTo("userId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params = FollowCreateParams.builder().userId("userId").account("account").build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("account")
    }
}
