// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accountconnectionchallenges

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountConnectionChallengeSubmitParamsTest {

    @Test
    fun create() {
        AccountConnectionChallengeSubmitParams.builder().id("id").emailCode("123456").build()
    }

    @Test
    fun pathParams() {
        val params =
            AccountConnectionChallengeSubmitParams.builder().id("id").emailCode("123456").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            AccountConnectionChallengeSubmitParams.builder().id("id").emailCode("123456").build()

        val body = params._body()

        assertThat(body.emailCode()).isEqualTo("123456")
    }
}
