// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.credits

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreditTopupBalanceResponseTest {

    @Test
    fun create() {
        val creditTopupBalanceResponse = CreditTopupBalanceResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val creditTopupBalanceResponse = CreditTopupBalanceResponse.builder().build()

        val roundtrippedCreditTopupBalanceResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(creditTopupBalanceResponse),
                jacksonTypeRef<CreditTopupBalanceResponse>(),
            )

        assertThat(roundtrippedCreditTopupBalanceResponse).isEqualTo(creditTopupBalanceResponse)
    }
}
