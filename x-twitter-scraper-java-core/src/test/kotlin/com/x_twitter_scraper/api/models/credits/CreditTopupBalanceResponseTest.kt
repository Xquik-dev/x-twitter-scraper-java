// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.credits

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.models.Currency
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreditTopupBalanceResponseTest {

    @Test
    fun create() {
        val creditTopupBalanceResponse =
            CreditTopupBalanceResponse.builder()
                .redirectUrl(
                    "https://xquik.com/api/v1/credits/topup/redirect?session_id=checkout_example"
                )
                .url("https://xquik.com/api/v1/credits/topup/redirect?session_id=checkout_example")
                .chargedCurrency(Currency.EUR)
                .chargedMinorUnits(892L)
                .build()

        assertThat(creditTopupBalanceResponse.redirectUrl())
            .isEqualTo(
                "https://xquik.com/api/v1/credits/topup/redirect?session_id=checkout_example"
            )
        assertThat(creditTopupBalanceResponse.url())
            .isEqualTo(
                "https://xquik.com/api/v1/credits/topup/redirect?session_id=checkout_example"
            )
        assertThat(creditTopupBalanceResponse.chargedCurrency()).isEqualTo(Currency.EUR)
        assertThat(creditTopupBalanceResponse.chargedMinorUnits()).isEqualTo(892L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val creditTopupBalanceResponse =
            CreditTopupBalanceResponse.builder()
                .redirectUrl(
                    "https://xquik.com/api/v1/credits/topup/redirect?session_id=checkout_example"
                )
                .url("https://xquik.com/api/v1/credits/topup/redirect?session_id=checkout_example")
                .chargedCurrency(Currency.EUR)
                .chargedMinorUnits(892L)
                .build()

        val roundtrippedCreditTopupBalanceResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(creditTopupBalanceResponse),
                jacksonTypeRef<CreditTopupBalanceResponse>(),
            )

        assertThat(roundtrippedCreditTopupBalanceResponse).isEqualTo(creditTopupBalanceResponse)
    }
}
