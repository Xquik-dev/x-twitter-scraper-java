// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.accounts.AccountCreateParams
import com.x_twitter_scraper.api.models.x.accounts.AccountReauthParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccountServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountServiceAsync = client.x().accounts()

        val accountFuture =
            accountServiceAsync.create(
                AccountCreateParams.builder()
                    .email("user@example.com")
                    .password("s3cur3Pa\$\$w0rd")
                    .username("elonmusk")
                    .proxyCountry("US")
                    .totpSecret("JBSWY3DPEHPK3PXP")
                    .build()
            )

        val account = accountFuture.get()
        account.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountServiceAsync = client.x().accounts()

        val xAccountDetailFuture = accountServiceAsync.retrieve("id")

        val xAccountDetail = xAccountDetailFuture.get()
        xAccountDetail.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountServiceAsync = client.x().accounts()

        val accountsFuture = accountServiceAsync.list()

        val accounts = accountsFuture.get()
        accounts.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountServiceAsync = client.x().accounts()

        val accountFuture = accountServiceAsync.delete("id")

        val account = accountFuture.get()
        account.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun bulkRetry() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountServiceAsync = client.x().accounts()

        val responseFuture = accountServiceAsync.bulkRetry()

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun reauth() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountServiceAsync = client.x().accounts()

        val responseFuture =
            accountServiceAsync.reauth(
                AccountReauthParams.builder()
                    .id("id")
                    .password("password_value")
                    .totpSecret("totp_secret_value")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
