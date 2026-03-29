// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountReauthParamsTest {

    @Test
    fun create() {
        AccountReauthParams.builder()
            .id("id")
            .password("password")
            .totpSecret("totp_secret")
            .build()
    }

    @Test
    fun pathParams() {
        val params = AccountReauthParams.builder().id("id").password("password").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            AccountReauthParams.builder()
                .id("id")
                .password("password")
                .totpSecret("totp_secret")
                .build()

        val body = params._body()

        assertThat(body.password()).isEqualTo("password")
        assertThat(body.totpSecret()).contains("totp_secret")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = AccountReauthParams.builder().id("id").password("password").build()

        val body = params._body()

        assertThat(body.password()).isEqualTo("password")
    }
}
