// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountReauthResponseTest {

    @Test
    fun create() {
        val accountReauthResponse =
            AccountReauthResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .health(AccountReauthResponse.Health.HEALTHY)
                .status("active")
                .xUserId("9876543210")
                .xUsername("elonmusk")
                .loginCountry("US")
                .build()

        assertThat(accountReauthResponse.id()).isEqualTo("42")
        assertThat(accountReauthResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(accountReauthResponse.health()).isEqualTo(AccountReauthResponse.Health.HEALTHY)
        assertThat(accountReauthResponse.status()).isEqualTo("active")
        assertThat(accountReauthResponse.xUserId()).isEqualTo("9876543210")
        assertThat(accountReauthResponse.xUsername()).isEqualTo("elonmusk")
        assertThat(accountReauthResponse.loginCountry()).contains("US")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountReauthResponse =
            AccountReauthResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .health(AccountReauthResponse.Health.HEALTHY)
                .status("active")
                .xUserId("9876543210")
                .xUsername("elonmusk")
                .loginCountry("US")
                .build()

        val roundtrippedAccountReauthResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountReauthResponse),
                jacksonTypeRef<AccountReauthResponse>(),
            )

        assertThat(roundtrippedAccountReauthResponse).isEqualTo(accountReauthResponse)
    }
}
