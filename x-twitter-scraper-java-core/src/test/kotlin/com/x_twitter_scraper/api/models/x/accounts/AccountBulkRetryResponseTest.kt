// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountBulkRetryResponseTest {

    @Test
    fun create() {
        val accountBulkRetryResponse = AccountBulkRetryResponse.builder().cleared(3L).build()

        assertThat(accountBulkRetryResponse.cleared()).isEqualTo(3L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountBulkRetryResponse = AccountBulkRetryResponse.builder().cleared(3L).build()

        val roundtrippedAccountBulkRetryResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountBulkRetryResponse),
                jacksonTypeRef<AccountBulkRetryResponse>(),
            )

        assertThat(roundtrippedAccountBulkRetryResponse).isEqualTo(accountBulkRetryResponse)
    }
}
