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
                .autoTopupEnabled(false)
                .balance(50000L)
                .lifetimePurchased(200000L)
                .lifetimeUsed(150000L)
                .build()

        assertThat(creditRetrieveBalanceResponse.autoTopupEnabled()).isEqualTo(false)
        assertThat(creditRetrieveBalanceResponse.balance()).isEqualTo(50000L)
        assertThat(creditRetrieveBalanceResponse.lifetimePurchased()).isEqualTo(200000L)
        assertThat(creditRetrieveBalanceResponse.lifetimeUsed()).isEqualTo(150000L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val creditRetrieveBalanceResponse =
            CreditRetrieveBalanceResponse.builder()
                .autoTopupEnabled(false)
                .balance(50000L)
                .lifetimePurchased(200000L)
                .lifetimeUsed(150000L)
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
