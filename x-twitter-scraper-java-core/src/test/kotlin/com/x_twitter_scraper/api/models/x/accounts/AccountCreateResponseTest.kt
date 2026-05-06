// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountCreateResponseTest {

    @Test
    fun create() {
        val accountCreateResponse =
            AccountCreateResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .health(AccountCreateResponse.Health.HEALTHY)
                .status("active")
                .xUserId("9876543210")
                .xUsername("elonmusk")
                .loginCountry("US")
                .build()

        assertThat(accountCreateResponse.id()).isEqualTo("42")
        assertThat(accountCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(accountCreateResponse.health()).isEqualTo(AccountCreateResponse.Health.HEALTHY)
        assertThat(accountCreateResponse.status()).isEqualTo("active")
        assertThat(accountCreateResponse.xUserId()).isEqualTo("9876543210")
        assertThat(accountCreateResponse.xUsername()).isEqualTo("elonmusk")
        assertThat(accountCreateResponse.loginCountry()).contains("US")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountCreateResponse =
            AccountCreateResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .health(AccountCreateResponse.Health.HEALTHY)
                .status("active")
                .xUserId("9876543210")
                .xUsername("elonmusk")
                .loginCountry("US")
                .build()

        val roundtrippedAccountCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountCreateResponse),
                jacksonTypeRef<AccountCreateResponse>(),
            )

        assertThat(roundtrippedAccountCreateResponse).isEqualTo(accountCreateResponse)
    }
}
