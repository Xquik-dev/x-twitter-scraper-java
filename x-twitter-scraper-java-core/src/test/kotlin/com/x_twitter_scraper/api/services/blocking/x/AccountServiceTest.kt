// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.accounts.AccountCreateParams
import com.x_twitter_scraper.api.models.x.accounts.AccountReauthParams
import org.junit.jupiter.api.Test

internal class AccountServiceTest {
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountService = client.x().accounts()

        val account =
            accountService.create(
                AccountCreateParams.builder()
                    .email("account@example.invalid")
                    .password("<ACCOUNT_PASSWORD>")
                    .username("your_x_username")
                    .totpSecret("<TOTP_SECRET>")
                    .build()
            )

        kotlin.test.assertNotNull(account)
    }

    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountService = client.x().accounts()

        val xAccountDetail = accountService.retrieve("id")

        kotlin.test.assertNotNull(xAccountDetail)
    }

    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountService = client.x().accounts()

        val accounts = accountService.list()

        kotlin.test.assertNotNull(accounts)
    }

    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountService = client.x().accounts()

        val account = accountService.delete("id")

        kotlin.test.assertNotNull(account)
    }

    @Test
    fun bulkRetry() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountService = client.x().accounts()

        val response = accountService.bulkRetry()

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun reauth() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountService = client.x().accounts()

        val response =
            accountService.reauth(
                AccountReauthParams.builder()
                    .id("id")
                    .password("<ACCOUNT_PASSWORD>")
                    .email("account@example.invalid")
                    .totpSecret("<TOTP_SECRET>")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }
}
