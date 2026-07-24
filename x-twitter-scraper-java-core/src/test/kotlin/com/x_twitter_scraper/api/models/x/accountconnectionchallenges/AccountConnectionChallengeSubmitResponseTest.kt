// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accountconnectionchallenges

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountConnectionChallengeSubmitResponseTest {

    @Test
    fun create() {
        val accountConnectionChallengeSubmitResponse =
            AccountConnectionChallengeSubmitResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .health(AccountConnectionChallengeSubmitResponse.Health.HEALTHY)
                .status("active")
                .xUserId("9876543210")
                .xUsername("elonmusk")
                .build()

        assertThat(accountConnectionChallengeSubmitResponse.id()).isEqualTo("42")
        assertThat(accountConnectionChallengeSubmitResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(accountConnectionChallengeSubmitResponse.health())
            .isEqualTo(AccountConnectionChallengeSubmitResponse.Health.HEALTHY)
        assertThat(accountConnectionChallengeSubmitResponse.status()).isEqualTo("active")
        assertThat(accountConnectionChallengeSubmitResponse.xUserId()).isEqualTo("9876543210")
        assertThat(accountConnectionChallengeSubmitResponse.xUsername()).isEqualTo("elonmusk")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountConnectionChallengeSubmitResponse =
            AccountConnectionChallengeSubmitResponse.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .health(AccountConnectionChallengeSubmitResponse.Health.HEALTHY)
                .status("active")
                .xUserId("9876543210")
                .xUsername("elonmusk")
                .build()

        val roundtrippedAccountConnectionChallengeSubmitResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountConnectionChallengeSubmitResponse),
                jacksonTypeRef<AccountConnectionChallengeSubmitResponse>(),
            )

        assertThat(roundtrippedAccountConnectionChallengeSubmitResponse)
            .isEqualTo(accountConnectionChallengeSubmitResponse)
    }
}
