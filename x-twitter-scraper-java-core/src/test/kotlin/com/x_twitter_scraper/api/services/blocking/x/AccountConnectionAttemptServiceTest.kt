// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import org.junit.jupiter.api.Test

internal class AccountConnectionAttemptServiceTest {

    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .build()
        val accountConnectionAttemptService = client.x().accountConnectionAttempts()

        val accountConnectionAttempt =
            accountConnectionAttemptService.retrieve("xatt_0123456789abcdef0123456789abcdef")

        accountConnectionAttempt.validate()
    }
}
