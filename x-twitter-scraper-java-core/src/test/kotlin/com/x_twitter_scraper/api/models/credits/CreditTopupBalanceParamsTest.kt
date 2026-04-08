// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.credits

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreditTopupBalanceParamsTest {

    @Test
    fun create() {
        CreditTopupBalanceParams.builder().amount(10000L).build()
    }

    @Test
    fun body() {
        val params = CreditTopupBalanceParams.builder().amount(10000L).build()

        val body = params._body()

        assertThat(body.amount()).isEqualTo(10000L)
    }
}
