// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.credits

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreditRetrieveTopupStatusResponseTest {

    @Test
    fun create() {
        val creditRetrieveTopupStatusResponse =
            CreditRetrieveTopupStatusResponse.builder()
                .status(CreditRetrieveTopupStatusResponse.Status.PAID)
                .amountDollars(25L)
                .credits("166666")
                .build()

        assertThat(creditRetrieveTopupStatusResponse.status())
            .isEqualTo(CreditRetrieveTopupStatusResponse.Status.PAID)
        assertThat(creditRetrieveTopupStatusResponse.amountDollars()).contains(25L)
        assertThat(creditRetrieveTopupStatusResponse.credits()).contains("166666")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val creditRetrieveTopupStatusResponse =
            CreditRetrieveTopupStatusResponse.builder()
                .status(CreditRetrieveTopupStatusResponse.Status.PAID)
                .amountDollars(25L)
                .credits("166666")
                .build()

        val roundtrippedCreditRetrieveTopupStatusResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(creditRetrieveTopupStatusResponse),
                jacksonTypeRef<CreditRetrieveTopupStatusResponse>(),
            )

        assertThat(roundtrippedCreditRetrieveTopupStatusResponse)
            .isEqualTo(creditRetrieveTopupStatusResponse)
    }
}
