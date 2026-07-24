// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletCreateParams
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletTopupParams
import org.junit.jupiter.api.Test

internal class GuestWalletServiceTest {
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val guestWalletService = client.guestWallets()

        val guestWallet =
            guestWalletService.create(
                GuestWalletCreateParams.builder()
                    .idempotencyKey("e1cb97D8-dDF3-4AaA-ad0a-49E4A0d1CfAa")
                    .amountMinor(1000L)
                    .build()
            )

        kotlin.test.assertNotNull(guestWallet)
    }

    @Test
    fun retrieveStatus() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val guestWalletService = client.guestWallets()

        val response = guestWalletService.retrieveStatus()

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun topup() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val guestWalletService = client.guestWallets()

        val response =
            guestWalletService.topup(
                GuestWalletTopupParams.builder()
                    .idempotencyKey("e1cb97D8-dDF3-4AaA-ad0a-49E4A0d1CfAa")
                    .amountMinor(1000L)
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }
}
