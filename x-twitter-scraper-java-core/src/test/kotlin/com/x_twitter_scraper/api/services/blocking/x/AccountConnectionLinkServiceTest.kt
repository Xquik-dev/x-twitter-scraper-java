// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLinkCreateParams
import org.junit.jupiter.api.Test

internal class AccountConnectionLinkServiceTest {

    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .build()
        val accountConnectionLinkService = client.x().accountConnectionLinks()

        val accountConnectionLink =
            accountConnectionLinkService.create(
                AccountConnectionLinkCreateParams.builder()
                    .accountId("42")
                    .reference("crm-user-7")
                    .returnUrl("https://app.example.com/connected")
                    .build()
            )

        accountConnectionLink.validate()
    }

    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .build()
        val accountConnectionLinkService = client.x().accountConnectionLinks()

        val accountConnectionLink = accountConnectionLinkService.retrieve("xlink_AAAAAAAAAAAAAAAA")

        accountConnectionLink.validate()
    }

    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .build()
        val accountConnectionLinkService = client.x().accountConnectionLinks()

        val accountConnectionLink = accountConnectionLinkService.delete("xlink_AAAAAAAAAAAAAAAA")

        accountConnectionLink.validate()
    }
}
