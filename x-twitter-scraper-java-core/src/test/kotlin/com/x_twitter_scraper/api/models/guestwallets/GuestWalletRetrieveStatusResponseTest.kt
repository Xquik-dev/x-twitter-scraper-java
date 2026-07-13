// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.guestwallets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GuestWalletRetrieveStatusResponseTest {

    @Test
    fun create() {
        val guestWalletRetrieveStatusResponse =
            GuestWalletRetrieveStatusResponse.builder()
                .balance("66666")
                .latestPurchase(
                    GuestWalletRetrieveStatusResponse.LatestPurchase.builder()
                        .amount(GuestWalletAmount.builder().amountMinor(1000L).build())
                        .checkoutUrl(null)
                        .credits("66666")
                        .expiresAt(OffsetDateTime.parse("2026-07-13T13:00:00.000Z"))
                        .purchaseId("gp_example")
                        .status(GuestWalletRetrieveStatusResponse.LatestPurchase.Status.PAID)
                        .build()
                )
                .pollAfterSeconds(GuestWalletRetrieveStatusResponse.PollAfterSeconds._2)
                .status(GuestWalletRetrieveStatusResponse.Status.ACTIVE)
                .topUp(GuestWalletRetrieveStatusResponse.TopUp.builder().build())
                .usable(true)
                .walletId("gw_example")
                .build()

        assertThat(guestWalletRetrieveStatusResponse.balance()).isEqualTo("66666")
        assertThat(guestWalletRetrieveStatusResponse.latestPurchase())
            .contains(
                GuestWalletRetrieveStatusResponse.LatestPurchase.builder()
                    .amount(GuestWalletAmount.builder().amountMinor(1000L).build())
                    .checkoutUrl(null)
                    .credits("66666")
                    .expiresAt(OffsetDateTime.parse("2026-07-13T13:00:00.000Z"))
                    .purchaseId("gp_example")
                    .status(GuestWalletRetrieveStatusResponse.LatestPurchase.Status.PAID)
                    .build()
            )
        assertThat(guestWalletRetrieveStatusResponse.pollAfterSeconds())
            .contains(GuestWalletRetrieveStatusResponse.PollAfterSeconds._2)
        assertThat(guestWalletRetrieveStatusResponse.status())
            .isEqualTo(GuestWalletRetrieveStatusResponse.Status.ACTIVE)
        assertThat(guestWalletRetrieveStatusResponse.topUp())
            .contains(GuestWalletRetrieveStatusResponse.TopUp.builder().build())
        assertThat(guestWalletRetrieveStatusResponse.usable()).isEqualTo(true)
        assertThat(guestWalletRetrieveStatusResponse.walletId()).isEqualTo("gw_example")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val guestWalletRetrieveStatusResponse =
            GuestWalletRetrieveStatusResponse.builder()
                .balance("66666")
                .latestPurchase(
                    GuestWalletRetrieveStatusResponse.LatestPurchase.builder()
                        .amount(GuestWalletAmount.builder().amountMinor(1000L).build())
                        .checkoutUrl(null)
                        .credits("66666")
                        .expiresAt(OffsetDateTime.parse("2026-07-13T13:00:00.000Z"))
                        .purchaseId("gp_example")
                        .status(GuestWalletRetrieveStatusResponse.LatestPurchase.Status.PAID)
                        .build()
                )
                .pollAfterSeconds(GuestWalletRetrieveStatusResponse.PollAfterSeconds._2)
                .status(GuestWalletRetrieveStatusResponse.Status.ACTIVE)
                .topUp(GuestWalletRetrieveStatusResponse.TopUp.builder().build())
                .usable(true)
                .walletId("gw_example")
                .build()

        val roundtrippedGuestWalletRetrieveStatusResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(guestWalletRetrieveStatusResponse),
                jacksonTypeRef<GuestWalletRetrieveStatusResponse>(),
            )

        assertThat(roundtrippedGuestWalletRetrieveStatusResponse)
            .isEqualTo(guestWalletRetrieveStatusResponse)
    }
}
