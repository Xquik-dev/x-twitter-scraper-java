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
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status("status")
                .xUserId("xUserId")
                .xUsername("xUsername")
                .cookiesObtainedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .proxyCountry("proxyCountry")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(accountRetrieveResponse.id()).isEqualTo("id")
        assertThat(accountRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(accountRetrieveResponse.status()).isEqualTo("status")
        assertThat(accountRetrieveResponse.xUserId()).isEqualTo("xUserId")
        assertThat(accountRetrieveResponse.xUsername()).isEqualTo("xUsername")
        assertThat(accountRetrieveResponse.cookiesObtainedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(accountRetrieveResponse.proxyCountry()).contains("proxyCountry")
        assertThat(accountRetrieveResponse.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountRetrieveResponse =
            AccountRetrieveResponse.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status("status")
                .xUserId("xUserId")
                .xUsername("xUsername")
                .cookiesObtainedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .proxyCountry("proxyCountry")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedAccountRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountRetrieveResponse),
                jacksonTypeRef<AccountRetrieveResponse>(),
            )

        assertThat(roundtrippedAccountRetrieveResponse).isEqualTo(accountRetrieveResponse)
    }
}
