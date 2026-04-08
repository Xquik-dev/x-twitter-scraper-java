// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

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
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .status("active")
                .xUserId("9876543210")
                .xUsername("elonmusk")
                .cookiesObtainedAt(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
                .proxyCountry("US")
                .updatedAt(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
                .build()

        assertThat(accountRetrieveResponse.id()).isEqualTo("42")
        assertThat(accountRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(accountRetrieveResponse.status()).isEqualTo("active")
        assertThat(accountRetrieveResponse.xUserId()).isEqualTo("9876543210")
        assertThat(accountRetrieveResponse.xUsername()).isEqualTo("elonmusk")
        assertThat(accountRetrieveResponse.cookiesObtainedAt())
            .contains(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
        assertThat(accountRetrieveResponse.proxyCountry()).contains("US")
        assertThat(accountRetrieveResponse.updatedAt())
            .contains(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountRetrieveResponse =
            AccountRetrieveResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .status("active")
                .xUserId("9876543210")
                .xUsername("elonmusk")
                .cookiesObtainedAt(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
                .proxyCountry("US")
                .updatedAt(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
                .build()

        val roundtrippedAccountRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountRetrieveResponse),
                jacksonTypeRef<AccountRetrieveResponse>(),
            )

        assertThat(roundtrippedAccountRetrieveResponse).isEqualTo(accountRetrieveResponse)
    }
}
