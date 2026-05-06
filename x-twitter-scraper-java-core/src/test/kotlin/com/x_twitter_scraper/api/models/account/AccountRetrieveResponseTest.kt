// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.account

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountRetrieveResponseTest {

    @Test
    fun create() {
        val accountRetrieveResponse =
            AccountRetrieveResponse.builder()
                .monitorsAllowed(10L)
                .monitorsUsed(3L)
                .plan(AccountRetrieveResponse.Plan.ACTIVE)
                .creditInfo(
                    AccountRetrieveResponse.CreditInfo.builder()
                        .autoTopupEnabled(false)
                        .balance(50000L)
                        .lifetimePurchased(140000L)
                        .lifetimeUsed(90000L)
                        .build()
                )
                .build()

        assertThat(accountRetrieveResponse.monitorsAllowed()).isEqualTo(10L)
        assertThat(accountRetrieveResponse.monitorsUsed()).isEqualTo(3L)
        assertThat(accountRetrieveResponse.plan()).isEqualTo(AccountRetrieveResponse.Plan.ACTIVE)
        assertThat(accountRetrieveResponse.creditInfo())
            .contains(
                AccountRetrieveResponse.CreditInfo.builder()
                    .autoTopupEnabled(false)
                    .balance(50000L)
                    .lifetimePurchased(140000L)
                    .lifetimeUsed(90000L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountRetrieveResponse =
            AccountRetrieveResponse.builder()
                .monitorsAllowed(10L)
                .monitorsUsed(3L)
                .plan(AccountRetrieveResponse.Plan.ACTIVE)
                .creditInfo(
                    AccountRetrieveResponse.CreditInfo.builder()
                        .autoTopupEnabled(false)
                        .balance(50000L)
                        .lifetimePurchased(140000L)
                        .lifetimeUsed(90000L)
                        .build()
                )
                .build()

        val roundtrippedAccountRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountRetrieveResponse),
                jacksonTypeRef<AccountRetrieveResponse>(),
            )

        assertThat(roundtrippedAccountRetrieveResponse).isEqualTo(accountRetrieveResponse)
    }
}
