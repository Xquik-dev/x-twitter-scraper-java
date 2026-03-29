// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountReauthResponseTest {

    @Test
    fun create() {
        val accountReauthResponse =
            AccountReauthResponse.builder().id("id").status("status").xUsername("xUsername").build()

        assertThat(accountReauthResponse.id()).isEqualTo("id")
        assertThat(accountReauthResponse.status()).isEqualTo("status")
        assertThat(accountReauthResponse.xUsername()).isEqualTo("xUsername")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountReauthResponse =
            AccountReauthResponse.builder().id("id").status("status").xUsername("xUsername").build()

        val roundtrippedAccountReauthResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountReauthResponse),
                jacksonTypeRef<AccountReauthResponse>(),
            )

        assertThat(roundtrippedAccountReauthResponse).isEqualTo(accountReauthResponse)
    }
}
