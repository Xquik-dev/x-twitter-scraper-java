// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountListResponseTest {

    @Test
    fun create() {
        val accountListResponse =
            AccountListResponse.builder()
                .addAccount(
                    XAccount.builder()
                        .id("id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status("status")
                        .xUserId("xUserId")
                        .xUsername("xUsername")
                        .build()
                )
                .build()

        assertThat(accountListResponse.accounts())
            .containsExactly(
                XAccount.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .status("status")
                    .xUserId("xUserId")
                    .xUsername("xUsername")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountListResponse =
            AccountListResponse.builder()
                .addAccount(
                    XAccount.builder()
                        .id("id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status("status")
                        .xUserId("xUserId")
                        .xUsername("xUsername")
                        .build()
                )
                .build()

        val roundtrippedAccountListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountListResponse),
                jacksonTypeRef<AccountListResponse>(),
            )

        assertThat(roundtrippedAccountListResponse).isEqualTo(accountListResponse)
    }
}
