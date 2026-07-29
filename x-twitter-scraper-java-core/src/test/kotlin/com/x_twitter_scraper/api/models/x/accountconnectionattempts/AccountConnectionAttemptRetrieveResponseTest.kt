// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accountconnectionattempts

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

internal class AccountConnectionAttemptRetrieveResponseTest {

    @Test
    fun ofXAccountConnectionAttemptPending() {
        val xAccountConnectionAttemptPending =
            AccountConnectionAttemptRetrieveResponse.XAccountConnectionAttemptPending.builder()
                .id("xatt_0123456789abcdef0123456789abcdef")
                .pollAfterMs(3000L)
                .build()

        val accountConnectionAttemptRetrieveResponse =
            AccountConnectionAttemptRetrieveResponse.ofXAccountConnectionAttemptPending(
                xAccountConnectionAttemptPending
            )

        assertThat(accountConnectionAttemptRetrieveResponse.xAccountConnectionAttemptPending())
            .contains(xAccountConnectionAttemptPending)
        assertThat(accountConnectionAttemptRetrieveResponse.xAccountConnectionAttemptSuccess())
            .isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.xAccountConnectionAttemptFailed())
            .isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.xAccountConnectionChallenge()).isEmpty
    }

    @Test
    fun ofXAccountConnectionAttemptPendingRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountConnectionAttemptRetrieveResponse =
            AccountConnectionAttemptRetrieveResponse.ofXAccountConnectionAttemptPending(
                AccountConnectionAttemptRetrieveResponse.XAccountConnectionAttemptPending.builder()
                    .id("xatt_0123456789abcdef0123456789abcdef")
                    .pollAfterMs(3000L)
                    .build()
            )

        val roundtrippedAccountConnectionAttemptRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountConnectionAttemptRetrieveResponse),
                jacksonTypeRef<AccountConnectionAttemptRetrieveResponse>(),
            )

        assertThat(roundtrippedAccountConnectionAttemptRetrieveResponse)
            .isEqualTo(accountConnectionAttemptRetrieveResponse)
    }

    @Test
    fun ofXAccountConnectionAttemptSuccess() {
        val xAccountConnectionAttemptSuccess =
            AccountConnectionAttemptRetrieveResponse.XAccountConnectionAttemptSuccess.builder()
                .id("xatt_0123456789abcdef0123456789abcdef")
                .build()

        val accountConnectionAttemptRetrieveResponse =
            AccountConnectionAttemptRetrieveResponse.ofXAccountConnectionAttemptSuccess(
                xAccountConnectionAttemptSuccess
            )

        assertThat(accountConnectionAttemptRetrieveResponse.xAccountConnectionAttemptPending())
            .isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.xAccountConnectionAttemptSuccess())
            .contains(xAccountConnectionAttemptSuccess)
        assertThat(accountConnectionAttemptRetrieveResponse.xAccountConnectionAttemptFailed())
            .isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.xAccountConnectionChallenge()).isEmpty
    }

    @Test
    fun ofXAccountConnectionAttemptSuccessRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountConnectionAttemptRetrieveResponse =
            AccountConnectionAttemptRetrieveResponse.ofXAccountConnectionAttemptSuccess(
                AccountConnectionAttemptRetrieveResponse.XAccountConnectionAttemptSuccess.builder()
                    .id("xatt_0123456789abcdef0123456789abcdef")
                    .build()
            )

        val roundtrippedAccountConnectionAttemptRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountConnectionAttemptRetrieveResponse),
                jacksonTypeRef<AccountConnectionAttemptRetrieveResponse>(),
            )

        assertThat(roundtrippedAccountConnectionAttemptRetrieveResponse)
            .isEqualTo(accountConnectionAttemptRetrieveResponse)
    }

    @Test
    fun ofXAccountConnectionAttemptFailed() {
        val xAccountConnectionAttemptFailed =
            AccountConnectionAttemptRetrieveResponse.XAccountConnectionAttemptFailed.builder()
                .id("xatt_0123456789abcdef0123456789abcdef")
                .error("service_unavailable")
                .retryable(true)
                .reason("wrong_password")
                .build()

        val accountConnectionAttemptRetrieveResponse =
            AccountConnectionAttemptRetrieveResponse.ofXAccountConnectionAttemptFailed(
                xAccountConnectionAttemptFailed
            )

        assertThat(accountConnectionAttemptRetrieveResponse.xAccountConnectionAttemptPending())
            .isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.xAccountConnectionAttemptSuccess())
            .isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.xAccountConnectionAttemptFailed())
            .contains(xAccountConnectionAttemptFailed)
        assertThat(accountConnectionAttemptRetrieveResponse.xAccountConnectionChallenge()).isEmpty
    }

    @Test
    fun ofXAccountConnectionAttemptFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountConnectionAttemptRetrieveResponse =
            AccountConnectionAttemptRetrieveResponse.ofXAccountConnectionAttemptFailed(
                AccountConnectionAttemptRetrieveResponse.XAccountConnectionAttemptFailed.builder()
                    .id("xatt_0123456789abcdef0123456789abcdef")
                    .error("service_unavailable")
                    .retryable(true)
                    .reason("wrong_password")
                    .build()
            )

        val roundtrippedAccountConnectionAttemptRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountConnectionAttemptRetrieveResponse),
                jacksonTypeRef<AccountConnectionAttemptRetrieveResponse>(),
            )

        assertThat(roundtrippedAccountConnectionAttemptRetrieveResponse)
            .isEqualTo(accountConnectionAttemptRetrieveResponse)
    }

    @Test
    fun ofXAccountConnectionChallenge() {
        val xAccountConnectionChallenge =
            AccountConnectionAttemptRetrieveResponse.XAccountConnectionChallenge.builder()
                .id("xch_8vGd8Y9JvH6dV0xA")
                .expiresAt(OffsetDateTime.parse("2026-05-08T12:10:00Z"))
                .message("Enter the email verification code to continue.")
                .object_(
                    AccountConnectionAttemptRetrieveResponse.XAccountConnectionChallenge.Object
                        .X_ACCOUNT_CONNECTION_CHALLENGE
                )
                .status(
                    AccountConnectionAttemptRetrieveResponse.XAccountConnectionChallenge.Status
                        .REQUIRES_EMAIL_CODE
                )
                .username("elonmusk")
                .build()

        val accountConnectionAttemptRetrieveResponse =
            AccountConnectionAttemptRetrieveResponse.ofXAccountConnectionChallenge(
                xAccountConnectionChallenge
            )

        assertThat(accountConnectionAttemptRetrieveResponse.xAccountConnectionAttemptPending())
            .isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.xAccountConnectionAttemptSuccess())
            .isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.xAccountConnectionAttemptFailed())
            .isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.xAccountConnectionChallenge())
            .contains(xAccountConnectionChallenge)
    }

    @Test
    fun ofXAccountConnectionChallengeRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountConnectionAttemptRetrieveResponse =
            AccountConnectionAttemptRetrieveResponse.ofXAccountConnectionChallenge(
                AccountConnectionAttemptRetrieveResponse.XAccountConnectionChallenge.builder()
                    .id("xch_8vGd8Y9JvH6dV0xA")
                    .expiresAt(OffsetDateTime.parse("2026-05-08T12:10:00Z"))
                    .message("Enter the email verification code to continue.")
                    .object_(
                        AccountConnectionAttemptRetrieveResponse.XAccountConnectionChallenge.Object
                            .X_ACCOUNT_CONNECTION_CHALLENGE
                    )
                    .status(
                        AccountConnectionAttemptRetrieveResponse.XAccountConnectionChallenge.Status
                            .REQUIRES_EMAIL_CODE
                    )
                    .username("elonmusk")
                    .build()
            )

        val roundtrippedAccountConnectionAttemptRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountConnectionAttemptRetrieveResponse),
                jacksonTypeRef<AccountConnectionAttemptRetrieveResponse>(),
            )

        assertThat(roundtrippedAccountConnectionAttemptRetrieveResponse)
            .isEqualTo(accountConnectionAttemptRetrieveResponse)
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
        val accountConnectionAttemptRetrieveResponse =
            jsonMapper()
                .convertValue(
                    testCase.value,
                    jacksonTypeRef<AccountConnectionAttemptRetrieveResponse>(),
                )

        val e =
            assertThrows<XTwitterScraperInvalidDataException> {
                accountConnectionAttemptRetrieveResponse.validate()
            }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
