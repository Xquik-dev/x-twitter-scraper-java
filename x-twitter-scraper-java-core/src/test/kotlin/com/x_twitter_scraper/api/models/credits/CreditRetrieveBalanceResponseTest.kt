// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.credits

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreditRetrieveBalanceResponseTest {

    @Test
    fun create() {
        val creditRetrieveBalanceResponse =
            CreditRetrieveBalanceResponse.builder()
                .autoTopupEnabled(true)
                .balance(0L)
                .lifetimePurchased(0L)
                .lifetimeUsed(0L)
                .build()

        assertThat(creditRetrieveBalanceResponse.autoTopupEnabled()).isEqualTo(true)
        assertThat(creditRetrieveBalanceResponse.balance()).isEqualTo(0L)
        assertThat(creditRetrieveBalanceResponse.lifetimePurchased()).isEqualTo(0L)
        assertThat(creditRetrieveBalanceResponse.lifetimeUsed()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val creditRetrieveBalanceResponse =
            CreditRetrieveBalanceResponse.builder()
                .autoTopupEnabled(true)
                .balance(0L)
                .lifetimePurchased(0L)
                .lifetimeUsed(0L)
                .build()

        val roundtrippedCreditRetrieveBalanceResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(creditRetrieveBalanceResponse),
                jacksonTypeRef<CreditRetrieveBalanceResponse>(),
            )

        assertThat(roundtrippedCreditRetrieveBalanceResponse)
            .isEqualTo(creditRetrieveBalanceResponse)
    }
}
