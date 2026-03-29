// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountCreateParamsTest {

    @Test
    fun create() {
        AccountCreateParams.builder()
            .email("email")
            .password("password")
            .username("username")
            .proxyCountry("proxy_country")
            .totpSecret("totp_secret")
            .build()
    }

    @Test
    fun body() {
        val params =
            AccountCreateParams.builder()
                .email("email")
                .password("password")
                .username("username")
                .proxyCountry("proxy_country")
                .totpSecret("totp_secret")
                .build()

        val body = params._body()

        assertThat(body.email()).isEqualTo("email")
        assertThat(body.password()).isEqualTo("password")
        assertThat(body.username()).isEqualTo("username")
        assertThat(body.proxyCountry()).contains("proxy_country")
        assertThat(body.totpSecret()).contains("totp_secret")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            AccountCreateParams.builder()
                .email("email")
                .password("password")
                .username("username")
                .build()

        val body = params._body()

        assertThat(body.email()).isEqualTo("email")
        assertThat(body.password()).isEqualTo("password")
        assertThat(body.username()).isEqualTo("username")
    }
}
