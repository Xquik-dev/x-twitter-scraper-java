// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.guestwallets

import com.x_twitter_scraper.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GuestWalletCreateParamsTest {

    @Test
    fun create() {
        GuestWalletCreateParams.builder()
            .idempotencyKey("e1cb97D8-dDF3-4AaA-ad0a-49E4A0d1CfAa")
            .amountMinor(1000L)
            .build()
    }

    @Test
    fun headers() {
        val params =
            GuestWalletCreateParams.builder()
                .idempotencyKey("e1cb97D8-dDF3-4AaA-ad0a-49E4A0d1CfAa")
                .amountMinor(1000L)
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(
                Headers.builder()
                    .put("Idempotency-Key", "e1cb97D8-dDF3-4AaA-ad0a-49E4A0d1CfAa")
                    .build()
            )
    }

    @Test
    fun body() {
        val params =
            GuestWalletCreateParams.builder()
                .idempotencyKey("e1cb97D8-dDF3-4AaA-ad0a-49E4A0d1CfAa")
                .amountMinor(1000L)
                .build()

        val body = params._body()

        assertThat(body.amountMinor()).isEqualTo(1000L)
    }
}
