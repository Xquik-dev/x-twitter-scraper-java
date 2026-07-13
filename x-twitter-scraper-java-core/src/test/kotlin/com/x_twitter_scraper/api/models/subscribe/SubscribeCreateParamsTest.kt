// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.subscribe

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SubscribeCreateParamsTest {

    @Test
    fun create() {
        SubscribeCreateParams.builder().tier(SubscribeCreateParams.Tier.PRO).build()
    }

    @Test
    fun body() {
        val params = SubscribeCreateParams.builder().tier(SubscribeCreateParams.Tier.PRO).build()

        val body = params._body()

        assertThat(body.tier()).contains(SubscribeCreateParams.Tier.PRO)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = SubscribeCreateParams.builder().build()

        val body = params._body()
    }
}
