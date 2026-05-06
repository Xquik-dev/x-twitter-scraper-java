// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.account.AccountSetXUsernameParams
import com.x_twitter_scraper.api.models.account.AccountUpdateLocaleParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccountServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val accountService = client.account()

        val account = accountService.retrieve()

        account.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun setXUsername() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val accountService = client.account()

        val response =
            accountService.setXUsername(
                AccountSetXUsernameParams.builder().username("elonmusk").build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun updateLocale() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val accountService = client.account()

        val response =
            accountService.updateLocale(
                AccountUpdateLocaleParams.builder()
                    .locale(AccountUpdateLocaleParams.Locale.EN)
                    .build()
            )

        response.validate()
    }
}
