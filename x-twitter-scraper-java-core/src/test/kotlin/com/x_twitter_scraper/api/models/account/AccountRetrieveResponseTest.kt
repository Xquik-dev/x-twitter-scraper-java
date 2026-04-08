// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.account

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
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
                .currentPeriod(
                    AccountRetrieveResponse.CurrentPeriod.builder()
                        .end(OffsetDateTime.parse("2025-02-01T00:00:00Z"))
                        .start(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
                        .usagePercent(42.5)
                        .build()
                )
                .build()

        assertThat(accountRetrieveResponse.monitorsAllowed()).isEqualTo(10L)
        assertThat(accountRetrieveResponse.monitorsUsed()).isEqualTo(3L)
        assertThat(accountRetrieveResponse.plan()).isEqualTo(AccountRetrieveResponse.Plan.ACTIVE)
        assertThat(accountRetrieveResponse.currentPeriod())
            .contains(
                AccountRetrieveResponse.CurrentPeriod.builder()
                    .end(OffsetDateTime.parse("2025-02-01T00:00:00Z"))
                    .start(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
                    .usagePercent(42.5)
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
                .currentPeriod(
                    AccountRetrieveResponse.CurrentPeriod.builder()
                        .end(OffsetDateTime.parse("2025-02-01T00:00:00Z"))
                        .start(OffsetDateTime.parse("2025-01-01T00:00:00Z"))
                        .usagePercent(42.5)
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
