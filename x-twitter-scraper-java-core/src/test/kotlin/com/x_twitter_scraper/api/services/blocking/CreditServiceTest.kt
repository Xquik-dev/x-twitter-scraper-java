// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.credits.CreditTopupBalanceParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CreditServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveBalance() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val creditService = client.credits()

        val response = creditService.retrieveBalance()

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun topupBalance() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val creditService = client.credits()

        val response =
            creditService.topupBalance(CreditTopupBalanceParams.builder().amount(0L).build())

        response.validate()
    }
}
