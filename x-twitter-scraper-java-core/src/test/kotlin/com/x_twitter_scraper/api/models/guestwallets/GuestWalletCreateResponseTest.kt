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

internal class GuestWalletCreateResponseTest {

    @Test
    fun create() {
        val guestWalletCreateResponse =
            GuestWalletCreateResponse.builder()
                .amount(GuestWalletAmount.builder().amountMinor(1000L).build())
                .apiKey("xq_example_returned_once")
                .authorization(
                    GuestWalletCreateResponse.Authorization.builder()
                        .header(GuestWalletCreateResponse.Authorization.Header.AUTHORIZATION)
                        .scheme(GuestWalletCreateResponse.Authorization.Scheme.BEARER)
                        .build()
                )
                .checkoutUrl("https://buy.stripe.com/example")
                .credits("66666")
                .expiresAt(OffsetDateTime.parse("2026-07-13T13:00:00.000Z"))
                .purchaseId("gp_example")
                .status(GuestWalletCreateResponse.Status.PENDING)
                .walletId("gw_example")
                .build()

        assertThat(guestWalletCreateResponse.amount())
            .isEqualTo(GuestWalletAmount.builder().amountMinor(1000L).build())
        assertThat(guestWalletCreateResponse.apiKey()).isEqualTo("xq_example_returned_once")
        assertThat(guestWalletCreateResponse.authorization())
            .isEqualTo(
                GuestWalletCreateResponse.Authorization.builder()
                    .header(GuestWalletCreateResponse.Authorization.Header.AUTHORIZATION)
                    .scheme(GuestWalletCreateResponse.Authorization.Scheme.BEARER)
                    .build()
            )
        assertThat(guestWalletCreateResponse.checkoutUrl())
            .isEqualTo("https://buy.stripe.com/example")
        assertThat(guestWalletCreateResponse.credits()).isEqualTo("66666")
        assertThat(guestWalletCreateResponse.expiresAt())
            .isEqualTo(OffsetDateTime.parse("2026-07-13T13:00:00.000Z"))
        assertThat(guestWalletCreateResponse.purchaseId()).isEqualTo("gp_example")
        assertThat(guestWalletCreateResponse.status())
            .isEqualTo(GuestWalletCreateResponse.Status.PENDING)
        assertThat(guestWalletCreateResponse.walletId()).isEqualTo("gw_example")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val guestWalletCreateResponse =
            GuestWalletCreateResponse.builder()
                .amount(GuestWalletAmount.builder().amountMinor(1000L).build())
                .apiKey("xq_example_returned_once")
                .authorization(
                    GuestWalletCreateResponse.Authorization.builder()
                        .header(GuestWalletCreateResponse.Authorization.Header.AUTHORIZATION)
                        .scheme(GuestWalletCreateResponse.Authorization.Scheme.BEARER)
                        .build()
                )
                .checkoutUrl("https://buy.stripe.com/example")
                .credits("66666")
                .expiresAt(OffsetDateTime.parse("2026-07-13T13:00:00.000Z"))
                .purchaseId("gp_example")
                .status(GuestWalletCreateResponse.Status.PENDING)
                .walletId("gw_example")
                .build()

        val roundtrippedGuestWalletCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(guestWalletCreateResponse),
                jacksonTypeRef<GuestWalletCreateResponse>(),
            )

        assertThat(roundtrippedGuestWalletCreateResponse).isEqualTo(guestWalletCreateResponse)
    }
}
