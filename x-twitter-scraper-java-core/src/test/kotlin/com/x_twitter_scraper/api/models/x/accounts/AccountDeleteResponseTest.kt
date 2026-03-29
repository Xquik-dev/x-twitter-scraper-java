// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountDeleteResponseTest {

    @Test
    fun create() {
        val accountDeleteResponse = AccountDeleteResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountDeleteResponse = AccountDeleteResponse.builder().build()

        val roundtrippedAccountDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountDeleteResponse),
                jacksonTypeRef<AccountDeleteResponse>(),
            )

        assertThat(roundtrippedAccountDeleteResponse).isEqualTo(accountDeleteResponse)
    }
}
