// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.accounts.AccountCreateParams
import com.x_twitter_scraper.api.models.x.accounts.AccountReauthParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccountServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountService = client.x().accounts()

        val account =
            accountService.create(
                AccountCreateParams.builder()
                    .email("user@example.com")
                    .password("s3cur3Pa\$\$w0rd")
                    .username("elonmusk")
                    .proxyCountry("US")
                    .totpSecret("JBSWY3DPEHPK3PXP")
                    .build()
            )

        account.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountService = client.x().accounts()

        val xAccountDetail = accountService.retrieve("id")

        xAccountDetail.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountService = client.x().accounts()

        val accounts = accountService.list()

        accounts.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountService = client.x().accounts()

        val account = accountService.delete("id")

        account.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun bulkRetry() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountService = client.x().accounts()

        val response = accountService.bulkRetry()

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun reauth() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val accountService = client.x().accounts()

        val response =
            accountService.reauth(
                AccountReauthParams.builder()
                    .id("id")
                    .password("password_value")
                    .totpSecret("totp_secret_value")
                    .build()
            )

        response.validate()
    }
}
