// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.credits

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreditTopupBalanceParamsTest {

    @Test
    fun create() {
        CreditTopupBalanceParams.builder().dollars(10L).locale("en").build()
    }

    @Test
    fun body() {
        val params = CreditTopupBalanceParams.builder().dollars(10L).locale("en").build()

        val body = params._body()

        assertThat(body.dollars()).isEqualTo(10L)
        assertThat(body.locale()).contains("en")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = CreditTopupBalanceParams.builder().dollars(10L).build()

        val body = params._body()

        assertThat(body.dollars()).isEqualTo(10L)
    }
}
