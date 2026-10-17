// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
                .xUserId("9876543210")
                .xUsername("elonmusk")
                .build()

        assertThat(accountConnectionChallengeSubmitResponse.id()).isEqualTo("42")
        assertThat(accountConnectionChallengeSubmitResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(accountConnectionChallengeSubmitResponse.health())
            .isEqualTo(AccountConnectionChallengeSubmitResponse.Health.HEALTHY)
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

    @Test
    fun additionalFieldsRoundtrip() {
        val jsonMapper = jsonMapper()
        val json =
            """{"object":"x_account_connection_challenge","expiresAt":"2025-01-15T12:00:00Z","message":"sample","username":"sample"}"""
        val model =
            jsonMapper.readValue(json, jacksonTypeRef<AccountConnectionChallengeSubmitResponse>())

        assertThat(model.object_()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("object")
        assertThat(model.expiresAt()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("expiresAt")
        assertThat(model.message()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("message")
        assertThat(model.username()).isPresent()
        assertThat(model._additionalProperties()).doesNotContainKey("username")
        assertThat(model.toBuilder().build()).isEqualTo(model)
        assertThat(jsonMapper.readTree(jsonMapper.writeValueAsString(model)))
            .isEqualTo(jsonMapper.readTree(json))
        assertThat(
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(model),
                    jacksonTypeRef<AccountConnectionChallengeSubmitResponse>(),
                )
            )
            .isEqualTo(model)
    }
}
