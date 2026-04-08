// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountReauthParamsTest {

    @Test
    fun create() {
        AccountReauthParams.builder()
            .id("id")
            .password("password_value")
            .totpSecret("totp_secret_value")
            .build()
    }

    @Test
    fun pathParams() {
        val params = AccountReauthParams.builder().id("id").password("password_value").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            AccountReauthParams.builder()
                .id("id")
                .password("password_value")
                .totpSecret("totp_secret_value")
                .build()

        val body = params._body()

        assertThat(body.password()).isEqualTo("password_value")
        assertThat(body.totpSecret()).contains("totp_secret_value")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = AccountReauthParams.builder().id("id").password("password_value").build()

        val body = params._body()

        assertThat(body.password()).isEqualTo("password_value")
    }
}
