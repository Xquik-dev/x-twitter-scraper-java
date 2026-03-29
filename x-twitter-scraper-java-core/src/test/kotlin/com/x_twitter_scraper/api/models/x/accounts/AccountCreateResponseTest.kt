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
                .id("id")
                .status("status")
                .xUserId("xUserId")
                .xUsername("xUsername")
                .build()

        assertThat(accountCreateResponse.id()).isEqualTo("id")
        assertThat(accountCreateResponse.status()).isEqualTo("status")
        assertThat(accountCreateResponse.xUserId()).isEqualTo("xUserId")
        assertThat(accountCreateResponse.xUsername()).isEqualTo("xUsername")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountCreateResponse =
            AccountCreateResponse.builder()
                .id("id")
                .status("status")
                .xUserId("xUserId")
                .xUsername("xUsername")
                .build()

        val roundtrippedAccountCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountCreateResponse),
                jacksonTypeRef<AccountCreateResponse>(),
            )

        assertThat(roundtrippedAccountCreateResponse).isEqualTo(accountCreateResponse)
    }
}
