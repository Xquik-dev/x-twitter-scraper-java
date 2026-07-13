// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletCreateParams
import com.x_twitter_scraper.api.models.guestwallets.GuestWalletTopupParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class GuestWalletServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val guestWalletServiceAsync = client.guestWallets()

        val guestWalletFuture =
            guestWalletServiceAsync.create(
                GuestWalletCreateParams.builder()
                    .idempotencyKey("e1cb97D8-dDF3-4AaA-ad0a-49E4A0d1CfAa")
                    .amountMinor(1000L)
                    .build()
            )

        val guestWallet = guestWalletFuture.get()
        guestWallet.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveStatus() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val guestWalletServiceAsync = client.guestWallets()

        val responseFuture = guestWalletServiceAsync.retrieveStatus()

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun topup() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val guestWalletServiceAsync = client.guestWallets()

        val responseFuture =
            guestWalletServiceAsync.topup(
                GuestWalletTopupParams.builder()
                    .idempotencyKey("e1cb97D8-dDF3-4AaA-ad0a-49E4A0d1CfAa")
                    .amountMinor(1000L)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
