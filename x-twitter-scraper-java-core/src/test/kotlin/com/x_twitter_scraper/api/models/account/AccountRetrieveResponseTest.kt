// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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

    @Test
    fun additionalCreditInfoFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json = """{"autoTopupStopped":true}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<AccountRetrieveResponse.CreditInfo>())

        assertThat(model.autoTopupStopped()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("autoTopupStopped")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<AccountRetrieveResponse.CreditInfo>(),
                )
            )
            .isEqualTo(model)
    }

    @Test
    fun additionalSubscriptionFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json =
            """{"status":"none","tier":"starter","currentPeriodStart":"2025-01-15T12:00:00Z","currentPeriodEnd":"2025-01-15T12:00:00Z"}"""
        val model =
            jsonMapper.readValue(json, jacksonTypeRef<AccountRetrieveResponse.Subscription>())

        assertThat(model.status()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("status")
        assertThat(model.tier()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("tier")
        assertThat(model.currentPeriodStart()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("currentPeriodStart")
        assertThat(model.currentPeriodEnd()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("currentPeriodEnd")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<AccountRetrieveResponse.Subscription>(),
                )
            )
            .isEqualTo(model)
    }

    @Test
    fun additionalFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json = """{"subscription":{}}"""
        val model = jsonMapper.readValue(json, jacksonTypeRef<AccountRetrieveResponse>())

        assertThat(model.subscription()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("subscription")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<AccountRetrieveResponse>(),
                )
            )
            .isEqualTo(model)
    }
}
