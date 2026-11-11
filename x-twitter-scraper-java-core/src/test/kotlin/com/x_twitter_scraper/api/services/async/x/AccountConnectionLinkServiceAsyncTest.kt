// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLinkCreateParams
import org.junit.jupiter.api.Test

internal class AccountConnectionLinkServiceAsyncTest {

    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .build()
        val accountConnectionLinkServiceAsync = client.x().accountConnectionLinks()

        val accountConnectionLinkFuture =
            accountConnectionLinkServiceAsync.create(
                AccountConnectionLinkCreateParams.builder()
                    .accountId("42")
                    .reference("crm-user-7")
                    .returnUrl("https://app.example.com/connected")
                    .build()
            )

        val accountConnectionLink = accountConnectionLinkFuture.get()
        accountConnectionLink.validate()
    }

    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .build()
        val accountConnectionLinkServiceAsync = client.x().accountConnectionLinks()

        val accountConnectionLinkFuture =
            accountConnectionLinkServiceAsync.retrieve("xlink_AAAAAAAAAAAAAAAA")

        val accountConnectionLink = accountConnectionLinkFuture.get()
        accountConnectionLink.validate()
    }

    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .build()
        val accountConnectionLinkServiceAsync = client.x().accountConnectionLinks()

        val accountConnectionLinkFuture =
            accountConnectionLinkServiceAsync.delete("xlink_AAAAAAAAAAAAAAAA")

        val accountConnectionLink = accountConnectionLinkFuture.get()
        accountConnectionLink.validate()
    }
}
