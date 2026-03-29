// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.account

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountUpdateLocaleParamsTest {

    @Test
    fun create() {
        AccountUpdateLocaleParams.builder().locale(AccountUpdateLocaleParams.Locale.EN).build()
    }

    @Test
    fun body() {
        val params =
            AccountUpdateLocaleParams.builder().locale(AccountUpdateLocaleParams.Locale.EN).build()

        val body = params._body()

        assertThat(body.locale()).isEqualTo(AccountUpdateLocaleParams.Locale.EN)
    }
}
