// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountListResponseTest {

    @Test
    fun create() {
        val accountListResponse =
            AccountListResponse.builder()
                .addAccount(
                    XAccount.builder()
                        .id("42")
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .health(XAccount.Health.HEALTHY)
                        .status("active")
                        .updatedAt(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
                        .xUserId("9876543210")
                        .xUsername("elonmusk")
                        .cookiesObtainedAt(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
                        .build()
                )
                .build()

        assertThat(accountListResponse.accounts())
            .containsExactly(
                XAccount.builder()
                    .id("42")
                    .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .health(XAccount.Health.HEALTHY)
                    .status("active")
                    .updatedAt(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
                    .xUserId("9876543210")
                    .xUsername("elonmusk")
                    .cookiesObtainedAt(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountListResponse =
            AccountListResponse.builder()
                .addAccount(
                    XAccount.builder()
                        .id("42")
                        .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                        .health(XAccount.Health.HEALTHY)
                        .status("active")
                        .updatedAt(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
                        .xUserId("9876543210")
                        .xUsername("elonmusk")
                        .cookiesObtainedAt(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
                        .build()
                )
                .build()

        val roundtrippedAccountListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountListResponse),
                jacksonTypeRef<AccountListResponse>(),
            )

        assertThat(roundtrippedAccountListResponse).isEqualTo(accountListResponse)
    }
}
