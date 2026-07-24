// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.credits.CreditRedirectTopupCheckoutParams
import com.x_twitter_scraper.api.models.credits.CreditRetrieveTopupStatusParams
import com.x_twitter_scraper.api.models.credits.CreditTopupBalanceParams
import org.junit.jupiter.api.Test

internal class CreditServiceTest {
    @Test
    fun redirectTopupCheckout() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val creditService = client.credits()

        creditService.redirectTopupCheckout(
            CreditRedirectTopupCheckoutParams.builder().sessionId("session_id").build()
        )
    }

    @Test
    fun retrieveBalance() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val creditService = client.credits()

        val response = creditService.retrieveBalance()

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveTopupStatus() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val creditService = client.credits()

        val response =
            creditService.retrieveTopupStatus(
                CreditRetrieveTopupStatusParams.builder().sessionId("session_id").build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun topupBalance() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val creditService = client.credits()

        val response =
            creditService.topupBalance(
                CreditTopupBalanceParams.builder().dollars(10L).locale("en").build()
            )

        kotlin.test.assertNotNull(response)
    }
}
