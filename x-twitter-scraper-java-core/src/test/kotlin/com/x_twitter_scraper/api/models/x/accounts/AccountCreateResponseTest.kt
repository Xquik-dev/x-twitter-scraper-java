// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountCreateResponseTest {

    @Test
    fun create() {
        val accountCreateResponse =
            AccountCreateResponse.builder()
                .id("42")
                .status("active")
                .xUserId("9876543210")
                .xUsername("elonmusk")
                .build()

        assertThat(accountCreateResponse.id()).isEqualTo("42")
        assertThat(accountCreateResponse.status()).isEqualTo("active")
        assertThat(accountCreateResponse.xUserId()).isEqualTo("9876543210")
        assertThat(accountCreateResponse.xUsername()).isEqualTo("elonmusk")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountCreateResponse =
            AccountCreateResponse.builder()
                .id("42")
                .status("active")
                .xUserId("9876543210")
                .xUsername("elonmusk")
                .build()

        val roundtrippedAccountCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountCreateResponse),
                jacksonTypeRef<AccountCreateResponse>(),
            )

        assertThat(roundtrippedAccountCreateResponse).isEqualTo(accountCreateResponse)
    }
}
