// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountReauthParamsTest {

    @Test
    fun create() {
        AccountReauthParams.builder()
            .id("id")
            .password("<ACCOUNT_PASSWORD>")
            .email("account@example.invalid")
            .totpSecret("<TOTP_SECRET>")
            .build()
    }

    @Test
    fun pathParams() {
        val params = AccountReauthParams.builder().id("id").password("<ACCOUNT_PASSWORD>").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            AccountReauthParams.builder()
                .id("id")
                .password("<ACCOUNT_PASSWORD>")
                .email("account@example.invalid")
                .totpSecret("<TOTP_SECRET>")
                .build()

        val body = params._body()

        assertThat(body.password()).isEqualTo("<ACCOUNT_PASSWORD>")
        assertThat(body.email()).contains("account@example.invalid")
        assertThat(body.totpSecret()).contains("<TOTP_SECRET>")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = AccountReauthParams.builder().id("id").password("<ACCOUNT_PASSWORD>").build()

        val body = params._body()

        assertThat(body.password()).isEqualTo("<ACCOUNT_PASSWORD>")
    }
}
