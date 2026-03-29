// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.account

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountUpdateLocaleResponseTest {

    @Test
    fun create() {
        val accountUpdateLocaleResponse = AccountUpdateLocaleResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountUpdateLocaleResponse = AccountUpdateLocaleResponse.builder().build()

        val roundtrippedAccountUpdateLocaleResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountUpdateLocaleResponse),
                jacksonTypeRef<AccountUpdateLocaleResponse>(),
            )

        assertThat(roundtrippedAccountUpdateLocaleResponse).isEqualTo(accountUpdateLocaleResponse)
    }
}
