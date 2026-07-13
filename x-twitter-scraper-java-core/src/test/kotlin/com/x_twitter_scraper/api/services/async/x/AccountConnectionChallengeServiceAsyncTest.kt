// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.accountconnectionchallenges.AccountConnectionChallengeSubmitParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccountConnectionChallengeServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun submit() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountConnectionChallengeServiceAsync = client.x().accountConnectionChallenges()

        val responseFuture =
            accountConnectionChallengeServiceAsync.submit(
                AccountConnectionChallengeSubmitParams.builder()
                    .id("id")
                    .emailCode("123456")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
