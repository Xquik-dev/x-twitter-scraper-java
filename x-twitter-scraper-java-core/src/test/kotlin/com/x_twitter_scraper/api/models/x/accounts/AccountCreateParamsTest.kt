// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
            .totpSecret("<TOTP_SECRET>")
            .username("your_x_username")
            .build()
    }

    @Test
    fun body() {
        val params =
            AccountCreateParams.builder()
                .email("account@example.invalid")
                .password("<ACCOUNT_PASSWORD>")
                .totpSecret("<TOTP_SECRET>")
                .username("your_x_username")
                .build()

        val body = params._body()

        assertThat(body.email()).isEqualTo("account@example.invalid")
        assertThat(body.password()).isEqualTo("<ACCOUNT_PASSWORD>")
        assertThat(body.totpSecret()).isEqualTo("<TOTP_SECRET>")
        assertThat(body.username()).isEqualTo("your_x_username")
    }
}
