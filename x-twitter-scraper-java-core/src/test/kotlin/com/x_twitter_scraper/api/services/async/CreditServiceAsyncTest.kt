// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.credits.CreditRedirectTopupCheckoutParams
import com.x_twitter_scraper.api.models.credits.CreditRetrieveTopupStatusParams
import com.x_twitter_scraper.api.models.credits.CreditTopupBalanceParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CreditServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun redirectTopupCheckout() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val creditServiceAsync = client.credits()

        val future =
            creditServiceAsync.redirectTopupCheckout(
                CreditRedirectTopupCheckoutParams.builder().sessionId("session_id").build()
            )

        val response = future.get()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveBalance() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val creditServiceAsync = client.credits()

        val responseFuture = creditServiceAsync.retrieveBalance()

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveTopupStatus() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val creditServiceAsync = client.credits()

        val responseFuture =
            creditServiceAsync.retrieveTopupStatus(
                CreditRetrieveTopupStatusParams.builder().sessionId("session_id").build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun topupBalance() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val creditServiceAsync = client.credits()

        val responseFuture =
            creditServiceAsync.topupBalance(
                CreditTopupBalanceParams.builder().dollars(10L).locale("en").build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
