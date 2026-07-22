// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.account

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@Suppress("DEPRECATION")
internal class AccountRetrieveResponseTest {

    @Test
    fun create() {
        val accountRetrieveResponse =
            AccountRetrieveResponse.builder()
                .monitorBilling(
                    AccountRetrieveResponse.MonitorBilling.builder()
                        .activeDailyEstimate("1500")
                        .activeHourlyBurn("63")
                        .creditsPerActiveMonitorDay("500")
                        .creditsPerActiveMonitorHour("21")
                        .eventsIncluded(true)
                        .instantCheckIntervalSeconds(1L)
                        .unlimitedSlots(true)
                        .build()
                )
                .monitorsAllowed(9007199254740991L)
                .monitorsUsed(3L)
                .plan(AccountRetrieveResponse.Plan.ACTIVE)
                .creditInfo(
                    AccountRetrieveResponse.CreditInfo.builder()
                        .autoTopupAmountDollars(10.0)
                        .autoTopupEnabled(false)
                        .autoTopupThreshold("50000")
                        .balance("50000")
                        .lifetimePurchased("140000")
                        .lifetimeUsed("90000")
                        .build()
                )
                .xUsername("elonmusk")
                .build()

        assertThat(accountRetrieveResponse.monitorBilling())
            .isEqualTo(
                AccountRetrieveResponse.MonitorBilling.builder()
                    .activeDailyEstimate("1500")
                    .activeHourlyBurn("63")
                    .creditsPerActiveMonitorDay("500")
                    .creditsPerActiveMonitorHour("21")
                    .eventsIncluded(true)
                    .instantCheckIntervalSeconds(1L)
                    .unlimitedSlots(true)
                    .build()
            )
        assertThat(accountRetrieveResponse.monitorsAllowed()).isEqualTo(9007199254740991L)
        assertThat(accountRetrieveResponse.monitorsUsed()).isEqualTo(3L)
        assertThat(accountRetrieveResponse.plan()).isEqualTo(AccountRetrieveResponse.Plan.ACTIVE)
        assertThat(accountRetrieveResponse.creditInfo())
            .contains(
                AccountRetrieveResponse.CreditInfo.builder()
                    .autoTopupAmountDollars(10.0)
                    .autoTopupEnabled(false)
                    .autoTopupThreshold("50000")
                    .balance("50000")
                    .lifetimePurchased("140000")
                    .lifetimeUsed("90000")
                    .build()
            )
        assertThat(accountRetrieveResponse.xUsername()).contains("elonmusk")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountRetrieveResponse =
            AccountRetrieveResponse.builder()
                .monitorBilling(
                    AccountRetrieveResponse.MonitorBilling.builder()
                        .activeDailyEstimate("1500")
                        .activeHourlyBurn("63")
                        .creditsPerActiveMonitorDay("500")
                        .creditsPerActiveMonitorHour("21")
                        .eventsIncluded(true)
                        .instantCheckIntervalSeconds(1L)
                        .unlimitedSlots(true)
                        .build()
                )
                .monitorsAllowed(9007199254740991L)
                .monitorsUsed(3L)
                .plan(AccountRetrieveResponse.Plan.ACTIVE)
                .creditInfo(
                    AccountRetrieveResponse.CreditInfo.builder()
                        .autoTopupAmountDollars(10.0)
                        .autoTopupEnabled(false)
                        .autoTopupThreshold("50000")
                        .balance("50000")
                        .lifetimePurchased("140000")
                        .lifetimeUsed("90000")
                        .build()
                )
                .xUsername("elonmusk")
                .build()

        val roundtrippedAccountRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountRetrieveResponse),
                jacksonTypeRef<AccountRetrieveResponse>(),
            )

        assertThat(roundtrippedAccountRetrieveResponse).isEqualTo(accountRetrieveResponse)
    }
}
