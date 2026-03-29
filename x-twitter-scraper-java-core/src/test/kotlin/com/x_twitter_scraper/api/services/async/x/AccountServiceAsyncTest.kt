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
                    .email("email")
                    .password("password")
                    .username("username")
                    .proxyCountry("proxy_country")
                    .totpSecret("totp_secret")
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

        val accountFuture = accountServiceAsync.retrieve("id")

        val account = accountFuture.get()
        account.validate()
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
                    .password("password")
                    .totpSecret("totp_secret")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
