// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.account

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountSetXUsernameParamsTest {

    @Test
    fun create() {
        AccountSetXUsernameParams.builder().username("username").build()
    }

    @Test
    fun body() {
        val params = AccountSetXUsernameParams.builder().username("username").build()

        val body = params._body()

        assertThat(body.username()).isEqualTo("username")
    }
}
