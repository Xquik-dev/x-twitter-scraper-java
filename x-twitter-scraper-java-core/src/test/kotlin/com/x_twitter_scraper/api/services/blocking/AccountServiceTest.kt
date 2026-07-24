// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.account.AccountSetXUsernameParams
import com.x_twitter_scraper.api.models.account.AccountUpdateLocaleParams
import org.junit.jupiter.api.Test

internal class AccountServiceTest {
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountService = client.account()

        val account = accountService.retrieve()

        kotlin.test.assertNotNull(account)
    }

    @Test
    fun setXUsername() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountService = client.account()

        val response =
            accountService.setXUsername(
                AccountSetXUsernameParams.builder().username("elonmusk").build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun updateLocale() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountService = client.account()

        val response =
            accountService.updateLocale(
                AccountUpdateLocaleParams.builder()
                    .locale(AccountUpdateLocaleParams.Locale.EN)
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }
}
