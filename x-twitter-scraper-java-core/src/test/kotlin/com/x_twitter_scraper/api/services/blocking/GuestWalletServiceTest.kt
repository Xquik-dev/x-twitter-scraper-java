// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletCreateParams
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletTopupParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class GuestWalletServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
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

        guestWallet.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveStatus() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val guestWalletService = client.guestWallets()

        val response = guestWalletService.retrieveStatus()

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun topup() {
        val client =
            XTwitterScraperOkHttpClient.builder()
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

        response.validate()
    }
}
