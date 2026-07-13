// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.guestwallets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GuestWalletAmountTest {

    @Test
    fun create() {
        val guestWalletAmount = GuestWalletAmount.builder().amountMinor(1000L).build()

        assertThat(guestWalletAmount.amountMinor()).isEqualTo(1000L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val guestWalletAmount = GuestWalletAmount.builder().amountMinor(1000L).build()

        val roundtrippedGuestWalletAmount =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(guestWalletAmount),
                jacksonTypeRef<GuestWalletAmount>(),
            )

        assertThat(roundtrippedGuestWalletAmount).isEqualTo(guestWalletAmount)
    }
}
