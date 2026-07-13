// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.accountconnectionchallenges.AccountConnectionChallengeSubmitParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccountConnectionChallengeServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun submit() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountConnectionChallengeService = client.x().accountConnectionChallenges()

        val response =
            accountConnectionChallengeService.submit(
                AccountConnectionChallengeSubmitParams.builder()
                    .id("id")
                    .emailCode("123456")
                    .build()
            )

        response.validate()
    }
}
