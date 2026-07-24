// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.accountconnectionchallenges.AccountConnectionChallengeSubmitParams
import org.junit.jupiter.api.Test

internal class AccountConnectionChallengeServiceTest {
    @Test
    fun submit() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountConnectionChallengeService = client.x().accountConnectionChallenges()

        val response =
            accountConnectionChallengeService.submit(
                AccountConnectionChallengeSubmitParams.builder()
                    .id("id")
                    .emailCode("<EMAIL_VERIFICATION_CODE>")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }
}
