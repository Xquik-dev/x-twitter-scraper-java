// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.account

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountSetXUsernameResponseTest {

    @Test
    fun create() {
        val accountSetXUsernameResponse =
            AccountSetXUsernameResponse.builder().xUsername("elonmusk").build()

        assertThat(accountSetXUsernameResponse.xUsername()).isEqualTo("elonmusk")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountSetXUsernameResponse =
            AccountSetXUsernameResponse.builder().xUsername("elonmusk").build()

        val roundtrippedAccountSetXUsernameResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountSetXUsernameResponse),
                jacksonTypeRef<AccountSetXUsernameResponse>(),
            )

        assertThat(roundtrippedAccountSetXUsernameResponse).isEqualTo(accountSetXUsernameResponse)
    }
}
