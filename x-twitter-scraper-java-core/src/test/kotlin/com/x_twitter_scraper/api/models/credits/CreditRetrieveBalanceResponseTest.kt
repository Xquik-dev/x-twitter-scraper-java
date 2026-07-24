// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
                .autoTopupAmountDollars(10.0)
                .autoTopupEnabled(false)
                .autoTopupThreshold("50000")
                .balance("50000")
                .lifetimePurchased("200000")
                .lifetimeUsed("150000")
                .build()

        assertThat(creditRetrieveBalanceResponse.autoTopupAmountDollars()).isEqualTo(10.0)
        assertThat(creditRetrieveBalanceResponse.autoTopupEnabled()).isEqualTo(false)
        assertThat(creditRetrieveBalanceResponse.autoTopupThreshold()).isEqualTo("50000")
        assertThat(creditRetrieveBalanceResponse.balance()).isEqualTo("50000")
        assertThat(creditRetrieveBalanceResponse.lifetimePurchased()).isEqualTo("200000")
        assertThat(creditRetrieveBalanceResponse.lifetimeUsed()).isEqualTo("150000")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val creditRetrieveBalanceResponse =
            CreditRetrieveBalanceResponse.builder()
                .autoTopupAmountDollars(10.0)
                .autoTopupEnabled(false)
                .autoTopupThreshold("50000")
                .balance("50000")
                .lifetimePurchased("200000")
                .lifetimeUsed("150000")
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
