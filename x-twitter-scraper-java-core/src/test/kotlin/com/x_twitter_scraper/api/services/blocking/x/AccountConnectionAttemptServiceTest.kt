// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccountConnectionAttemptServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountConnectionAttemptService = client.x().accountConnectionAttempts()

        val accountConnectionAttempt =
            accountConnectionAttemptService.retrieve("xatt_0123456789abcdef0123456789abcdef")

        accountConnectionAttempt.validate()
    }
}
