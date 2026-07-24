// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.credits

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreditTopupBalanceResponseTest {

    @Test
    fun create() {
        val creditTopupBalanceResponse =
            CreditTopupBalanceResponse.builder()
                .redirectUrl(
                    "https://xquik.com/api/v1/credits/topup/redirect?session_id=cs_test_123"
                )
                .url("https://xquik.com/api/v1/credits/topup/redirect?session_id=cs_test_123")
                .build()

        assertThat(creditTopupBalanceResponse.redirectUrl())
            .isEqualTo("https://xquik.com/api/v1/credits/topup/redirect?session_id=cs_test_123")
        assertThat(creditTopupBalanceResponse.url())
            .isEqualTo("https://xquik.com/api/v1/credits/topup/redirect?session_id=cs_test_123")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val creditTopupBalanceResponse =
            CreditTopupBalanceResponse.builder()
                .redirectUrl(
                    "https://xquik.com/api/v1/credits/topup/redirect?session_id=cs_test_123"
                )
                .url("https://xquik.com/api/v1/credits/topup/redirect?session_id=cs_test_123")
                .build()

        val roundtrippedCreditTopupBalanceResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(creditTopupBalanceResponse),
                jacksonTypeRef<CreditTopupBalanceResponse>(),
            )

        assertThat(roundtrippedCreditTopupBalanceResponse).isEqualTo(creditTopupBalanceResponse)
    }
}
