// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.accounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AccountReauthResponseTest {

    @Test
    fun ofSanitizedXAccount() {
        val sanitizedXAccount =
            AccountReauthResponse.SanitizedXAccount.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .health(AccountReauthResponse.SanitizedXAccount.Health.HEALTHY)
                .xUserId("9876543210")
                .xUsername("elonmusk")
                .build()

        val accountCreateResponse = AccountReauthResponse.ofSanitizedXAccount(sanitizedXAccount)

        assertThat(accountCreateResponse.sanitizedXAccount()).contains(sanitizedXAccount)
        assertThat(accountCreateResponse.xAccountConnectionAttemptPending()).isEmpty
        assertThat(accountCreateResponse.xAccountConnectionChallenge()).isEmpty
    }

    @Test
    fun ofSanitizedXAccountRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountCreateResponse =
            AccountReauthResponse.ofSanitizedXAccount(
                AccountReauthResponse.SanitizedXAccount.builder()
                    .id("42")
                    .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                    .health(AccountReauthResponse.SanitizedXAccount.Health.HEALTHY)
                    .xUserId("9876543210")
                    .xUsername("elonmusk")
                    .build()
            )

        val roundtrippedAccountReauthResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountCreateResponse),
                jacksonTypeRef<AccountReauthResponse>(),
            )

        assertThat(roundtrippedAccountReauthResponse).isEqualTo(accountCreateResponse)
    }

    @Test
    fun ofXAccountConnectionAttemptPending() {
        val xAccountConnectionAttemptPending =
            AccountReauthResponse.XAccountConnectionAttemptPending.builder()
                .id("xatt_0123456789abcdef0123456789abcdef")
                .pollAfterMs(3000L)
                .build()

        val accountCreateResponse =
            AccountReauthResponse.ofXAccountConnectionAttemptPending(
                xAccountConnectionAttemptPending
            )

        assertThat(accountCreateResponse.sanitizedXAccount()).isEmpty
        assertThat(accountCreateResponse.xAccountConnectionAttemptPending())
            .contains(xAccountConnectionAttemptPending)
        assertThat(accountCreateResponse.xAccountConnectionChallenge()).isEmpty
    }

    @Test
    fun ofXAccountConnectionAttemptPendingRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountCreateResponse =
            AccountReauthResponse.ofXAccountConnectionAttemptPending(
                AccountReauthResponse.XAccountConnectionAttemptPending.builder()
                    .id("xatt_0123456789abcdef0123456789abcdef")
                    .pollAfterMs(3000L)
                    .build()
            )

        val roundtrippedAccountReauthResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountCreateResponse),
                jacksonTypeRef<AccountReauthResponse>(),
            )

        assertThat(roundtrippedAccountReauthResponse).isEqualTo(accountCreateResponse)
    }

    @Test
    fun ofXAccountConnectionChallenge() {
        val xAccountConnectionChallenge =
            AccountReauthResponse.XAccountConnectionChallenge.builder()
                .id("xch_8vGd8Y9JvH6dV0xA")
                .expiresAt(OffsetDateTime.parse("2026-05-08T12:10:00Z"))
                .message("Enter the email verification code to continue.")
                .username("elonmusk")
                .build()

        val accountCreateResponse =
            AccountReauthResponse.ofXAccountConnectionChallenge(xAccountConnectionChallenge)

        assertThat(accountCreateResponse.sanitizedXAccount()).isEmpty
        assertThat(accountCreateResponse.xAccountConnectionAttemptPending()).isEmpty
        assertThat(accountCreateResponse.xAccountConnectionChallenge())
            .contains(xAccountConnectionChallenge)
    }

    @Test
    fun ofXAccountConnectionChallengeRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountCreateResponse =
            AccountReauthResponse.ofXAccountConnectionChallenge(
                AccountReauthResponse.XAccountConnectionChallenge.builder()
                    .id("xch_8vGd8Y9JvH6dV0xA")
                    .expiresAt(OffsetDateTime.parse("2026-05-08T12:10:00Z"))
                    .message("Enter the email verification code to continue.")
                    .username("elonmusk")
                    .build()
            )

        val roundtrippedAccountReauthResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountCreateResponse),
                jacksonTypeRef<AccountReauthResponse>(),
            )

        assertThat(roundtrippedAccountReauthResponse).isEqualTo(accountCreateResponse)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val accountCreateResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AccountReauthResponse>())

        val e =
            assertThrows<XTwitterScraperInvalidDataException> { accountCreateResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
