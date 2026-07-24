// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.accounts.AccountCreateParams
import com.x_twitter_scraper.api.models.x.accounts.AccountReauthParams
import org.junit.jupiter.api.Test

internal class AccountServiceAsyncTest {
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountServiceAsync = client.x().accounts()

        val accountFuture =
            accountServiceAsync.create(
                AccountCreateParams.builder()
                    .email("account@example.invalid")
                    .password("<ACCOUNT_PASSWORD>")
                    .username("your_x_username")
                    .totpSecret("<TOTP_SECRET>")
                    .build()
            )

        val account = accountFuture.get()
        kotlin.test.assertNotNull(account)
    }

    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountServiceAsync = client.x().accounts()

        val xAccountDetailFuture = accountServiceAsync.retrieve("id")

        val xAccountDetail = xAccountDetailFuture.get()
        kotlin.test.assertNotNull(xAccountDetail)
    }

    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountServiceAsync = client.x().accounts()

        val accountsFuture = accountServiceAsync.list()

        val accounts = accountsFuture.get()
        kotlin.test.assertNotNull(accounts)
    }

    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountServiceAsync = client.x().accounts()

        val accountFuture = accountServiceAsync.delete("id")

        val account = accountFuture.get()
        kotlin.test.assertNotNull(account)
    }

    @Test
    fun bulkRetry() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountServiceAsync = client.x().accounts()

        val responseFuture = accountServiceAsync.bulkRetry()

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun reauth() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountServiceAsync = client.x().accounts()

        val responseFuture =
            accountServiceAsync.reauth(
                AccountReauthParams.builder()
                    .id("id")
                    .password("<ACCOUNT_PASSWORD>")
                    .email("account@example.invalid")
                    .totpSecret("<TOTP_SECRET>")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
