// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.guestwallets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GuestWalletTopupResponseTest {

    @Test
    fun create() {
        val guestWalletTopupResponse =
            GuestWalletTopupResponse.builder()
                .amount(GuestWalletAmount.builder().amountMinor(1000L).build())
                .checkoutUrl("https://buy.stripe.com/example")
                .credits("66666")
                .expiresAt(OffsetDateTime.parse("2026-07-13T13:00:00.000Z"))
                .purchaseId("gp_example")
                .status(GuestWalletTopupResponse.Status.PENDING)
                .walletId("gw_example")
                .apiKey("xq_example_returned_once")
                .authorization(
                    GuestWalletTopupResponse.Authorization.builder()
                        .header(GuestWalletTopupResponse.Authorization.Header.AUTHORIZATION)
                        .scheme(GuestWalletTopupResponse.Authorization.Scheme.BEARER)
                        .build()
                )
                .credentialNotice(
                    GuestWalletTopupResponse.CredentialNotice
                        .STORE_API_KEY_AND_THE_IDEMPOTENCY_KEY_SECURELY_BEFORE_SHARING_CHECKOUT_URL_NO_EMAIL_RECOVERY_IS_AVAILABLE
                )
                .build()

        assertThat(guestWalletTopupResponse.amount())
            .isEqualTo(GuestWalletAmount.builder().amountMinor(1000L).build())
        assertThat(guestWalletTopupResponse.checkoutUrl())
            .isEqualTo("https://buy.stripe.com/example")
        assertThat(guestWalletTopupResponse.credits()).isEqualTo("66666")
        assertThat(guestWalletTopupResponse.expiresAt())
            .isEqualTo(OffsetDateTime.parse("2026-07-13T13:00:00.000Z"))
        assertThat(guestWalletTopupResponse.purchaseId()).isEqualTo("gp_example")
        assertThat(guestWalletTopupResponse.status())
            .isEqualTo(GuestWalletTopupResponse.Status.PENDING)
        assertThat(guestWalletTopupResponse.walletId()).isEqualTo("gw_example")
        assertThat(guestWalletTopupResponse.apiKey()).contains("xq_example_returned_once")
        assertThat(guestWalletTopupResponse.authorization())
            .contains(
                GuestWalletTopupResponse.Authorization.builder()
                    .header(GuestWalletTopupResponse.Authorization.Header.AUTHORIZATION)
                    .scheme(GuestWalletTopupResponse.Authorization.Scheme.BEARER)
                    .build()
            )
        assertThat(guestWalletTopupResponse.credentialNotice())
            .contains(
                GuestWalletTopupResponse.CredentialNotice
                    .STORE_API_KEY_AND_THE_IDEMPOTENCY_KEY_SECURELY_BEFORE_SHARING_CHECKOUT_URL_NO_EMAIL_RECOVERY_IS_AVAILABLE
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val guestWalletTopupResponse =
            GuestWalletTopupResponse.builder()
                .amount(GuestWalletAmount.builder().amountMinor(1000L).build())
                .checkoutUrl("https://buy.stripe.com/example")
                .credits("66666")
                .expiresAt(OffsetDateTime.parse("2026-07-13T13:00:00.000Z"))
                .purchaseId("gp_example")
                .status(GuestWalletTopupResponse.Status.PENDING)
                .walletId("gw_example")
                .apiKey("xq_example_returned_once")
                .authorization(
                    GuestWalletTopupResponse.Authorization.builder()
                        .header(GuestWalletTopupResponse.Authorization.Header.AUTHORIZATION)
                        .scheme(GuestWalletTopupResponse.Authorization.Scheme.BEARER)
                        .build()
                )
                .credentialNotice(
                    GuestWalletTopupResponse.CredentialNotice
                        .STORE_API_KEY_AND_THE_IDEMPOTENCY_KEY_SECURELY_BEFORE_SHARING_CHECKOUT_URL_NO_EMAIL_RECOVERY_IS_AVAILABLE
                )
                .build()

        val roundtrippedGuestWalletTopupResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(guestWalletTopupResponse),
                jacksonTypeRef<GuestWalletTopupResponse>(),
            )

        assertThat(roundtrippedGuestWalletTopupResponse).isEqualTo(guestWalletTopupResponse)
    }
}
