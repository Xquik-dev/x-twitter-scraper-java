// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountCreateParamsTest {

    @Test
    fun create() {
        AccountCreateParams.builder()
            .email("account@example.invalid")
            .password("<ACCOUNT_PASSWORD>")
            .username("your_x_username")
            .totpSecret("<TOTP_SECRET>")
            .build()
    }

    @Test
    fun body() {
        val params =
            AccountCreateParams.builder()
                .email("account@example.invalid")
                .password("<ACCOUNT_PASSWORD>")
                .username("your_x_username")
                .totpSecret("<TOTP_SECRET>")
                .build()

        val body = params._body()

        assertThat(body.email()).isEqualTo("account@example.invalid")
        assertThat(body.password()).isEqualTo("<ACCOUNT_PASSWORD>")
        assertThat(body.username()).isEqualTo("your_x_username")
        assertThat(body.totpSecret()).contains("<TOTP_SECRET>")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            AccountCreateParams.builder()
                .email("account@example.invalid")
                .password("<ACCOUNT_PASSWORD>")
                .username("your_x_username")
                .build()

        val body = params._body()

        assertThat(body.email()).isEqualTo("account@example.invalid")
        assertThat(body.password()).isEqualTo("<ACCOUNT_PASSWORD>")
        assertThat(body.username()).isEqualTo("your_x_username")
    }
}
