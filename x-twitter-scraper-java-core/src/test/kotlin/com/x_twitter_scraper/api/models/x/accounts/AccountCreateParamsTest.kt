// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountCreateParamsTest {

    @Test
    fun create() {
        AccountCreateParams.builder()
            .email("user@example.com")
            .password("s3cur3Pa\$\$w0rd")
            .username("elonmusk")
            .proxyCountry("US")
            .totpSecret("JBSWY3DPEHPK3PXP")
            .build()
    }

    @Test
    fun body() {
        val params =
            AccountCreateParams.builder()
                .email("user@example.com")
                .password("s3cur3Pa\$\$w0rd")
                .username("elonmusk")
                .proxyCountry("US")
                .totpSecret("JBSWY3DPEHPK3PXP")
                .build()

        val body = params._body()

        assertThat(body.email()).isEqualTo("user@example.com")
        assertThat(body.password()).isEqualTo("s3cur3Pa\$\$w0rd")
        assertThat(body.username()).isEqualTo("elonmusk")
        assertThat(body.proxyCountry()).contains("US")
        assertThat(body.totpSecret()).contains("JBSWY3DPEHPK3PXP")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            AccountCreateParams.builder()
                .email("user@example.com")
                .password("s3cur3Pa\$\$w0rd")
                .username("elonmusk")
                .build()

        val body = params._body()

        assertThat(body.email()).isEqualTo("user@example.com")
        assertThat(body.password()).isEqualTo("s3cur3Pa\$\$w0rd")
        assertThat(body.username()).isEqualTo("elonmusk")
    }
}
