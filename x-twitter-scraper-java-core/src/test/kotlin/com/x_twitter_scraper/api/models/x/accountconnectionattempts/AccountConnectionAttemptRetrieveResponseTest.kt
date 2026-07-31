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
    fun ofPending() {
        val pending =
            AccountConnectionAttemptRetrieveResponse.Pending.builder()
                .id("xatt_0123456789abcdef0123456789abcdef")
                .pollAfterMs(3000L)
                .build()

        val accountConnectionAttemptRetrieveResponse =
            AccountConnectionAttemptRetrieveResponse.ofPending(pending)

        assertThat(accountConnectionAttemptRetrieveResponse.pending()).contains(pending)
        assertThat(accountConnectionAttemptRetrieveResponse.success()).isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.failed()).isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.requiresEmailCode()).isEmpty
    }

    @Test
    fun ofPendingRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountConnectionAttemptRetrieveResponse =
            AccountConnectionAttemptRetrieveResponse.ofPending(
                AccountConnectionAttemptRetrieveResponse.Pending.builder()
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
    fun ofSuccess() {
        val success =
            AccountConnectionAttemptRetrieveResponse.Success.builder()
                .id("xatt_0123456789abcdef0123456789abcdef")
                .build()

        val accountConnectionAttemptRetrieveResponse =
            AccountConnectionAttemptRetrieveResponse.ofSuccess(success)

        assertThat(accountConnectionAttemptRetrieveResponse.pending()).isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.success()).contains(success)
        assertThat(accountConnectionAttemptRetrieveResponse.failed()).isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.requiresEmailCode()).isEmpty
    }

    @Test
    fun ofSuccessRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountConnectionAttemptRetrieveResponse =
            AccountConnectionAttemptRetrieveResponse.ofSuccess(
                AccountConnectionAttemptRetrieveResponse.Success.builder()
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
    fun ofFailed() {
        val failed =
            AccountConnectionAttemptRetrieveResponse.Failed.builder()
                .id("xatt_0123456789abcdef0123456789abcdef")
                .error("service_unavailable")
                .retryable(true)
                .reason("wrong_password")
                .build()

        val accountConnectionAttemptRetrieveResponse =
            AccountConnectionAttemptRetrieveResponse.ofFailed(failed)

        assertThat(accountConnectionAttemptRetrieveResponse.pending()).isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.success()).isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.failed()).contains(failed)
        assertThat(accountConnectionAttemptRetrieveResponse.requiresEmailCode()).isEmpty
    }

    @Test
    fun ofFailedRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountConnectionAttemptRetrieveResponse =
            AccountConnectionAttemptRetrieveResponse.ofFailed(
                AccountConnectionAttemptRetrieveResponse.Failed.builder()
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
    fun ofRequiresEmailCode() {
        val requiresEmailCode =
            AccountConnectionAttemptRetrieveResponse.RequiresEmailCode.builder()
                .id("xch_8vGd8Y9JvH6dV0xA")
                .expiresAt(OffsetDateTime.parse("2026-05-08T12:10:00Z"))
                .message("Enter the email verification code to continue.")
                .username("elonmusk")
                .build()

        val accountConnectionAttemptRetrieveResponse =
            AccountConnectionAttemptRetrieveResponse.ofRequiresEmailCode(requiresEmailCode)

        assertThat(accountConnectionAttemptRetrieveResponse.pending()).isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.success()).isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.failed()).isEmpty
        assertThat(accountConnectionAttemptRetrieveResponse.requiresEmailCode())
            .contains(requiresEmailCode)
    }

    @Test
    fun ofRequiresEmailCodeRoundtrip() {
        val jsonMapper = jsonMapper()
        val accountConnectionAttemptRetrieveResponse =
            AccountConnectionAttemptRetrieveResponse.ofRequiresEmailCode(
                AccountConnectionAttemptRetrieveResponse.RequiresEmailCode.builder()
                    .id("xch_8vGd8Y9JvH6dV0xA")
                    .expiresAt(OffsetDateTime.parse("2026-05-08T12:10:00Z"))
                    .message("Enter the email verification code to continue.")
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
