// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services

import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.core.RequestOptions
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLink
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLinkListParams
import com.x_twitter_scraper.api.models.x.accountconnectionlinks.AccountConnectionLinkListResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class AccountConnectionLinkListTest {

    private val page =
        """{"links":[{"object":"x_account_connection_link","id":"xlink_BBBBBBBBBBBBBBBB","purpose":"connect","status":"pending","reference":"crm-user-8","returnUrl":null,"accountId":null,"xUserId":null,"xUsername":null,"health":null,"failure":null,"createdAt":"2026-11-08T13:00:00Z","expiresAt":"2026-11-08T13:30:00Z","completedAt":null},{"object":"x_account_connection_link","id":"xlink_AAAAAAAAAAAAAAAA","purpose":"connect","status":"connected","reference":"crm-user-7","returnUrl":"https://app.example.com/connected","accountId":"42","xUserId":"1234567890","xUsername":"your_x_username","health":"healthy","failure":null,"createdAt":"2026-11-08T12:00:00Z","expiresAt":"2026-11-08T12:30:00Z","completedAt":"2026-11-08T12:04:00Z"}],"hasMore":true,"nextCursor":"def456"}"""

    private val params =
        AccountConnectionLinkListParams.builder().limit(20L).cursor("abc123").build()

    private lateinit var baseUrl: String

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        baseUrl = wmRuntimeInfo.httpBaseUrl
        stubFor(get(urlPathEqualTo("/x/account-connection-links")).willReturn(okJson(page)))
    }

    private fun client() =
        XTwitterScraperOkHttpClient.builder().baseUrl(baseUrl).apiKey("My API Key").build()

    private fun asyncClient() =
        XTwitterScraperOkHttpClientAsync.builder().baseUrl(baseUrl).apiKey("My API Key").build()

    private fun assertPage(page: AccountConnectionLinkListResponse) {
        assertThat(page.hasMore()).isTrue()
        assertThat(page.nextCursor()).contains("def456")
        assertThat(page.links().map { it.id() })
            .containsExactly("xlink_BBBBBBBBBBBBBBBB", "xlink_AAAAAAAAAAAAAAAA")
        assertThat(page.links().map { it.status() })
            .containsExactly(
                AccountConnectionLink.Status.PENDING,
                AccountConnectionLink.Status.CONNECTED,
            )
        assertThat(page.links().map { it.url() }).allMatch { it.isEmpty }
    }

    @Test
    fun listSendsTheLimitAndCursorAndReadsEachLink() {
        val page = client().x().accountConnectionLinks().list(params)

        verify(
            getRequestedFor(urlPathEqualTo("/x/account-connection-links"))
                .withQueryParam("limit", equalTo("20"))
                .withQueryParam("cursor", equalTo("abc123"))
        )
        assertPage(page)
    }

    @Test
    fun listWithNoParamsSendsNoQuery() {
        assertPage(client().x().accountConnectionLinks().list())

        verify(getRequestedFor(urlEqualTo("/x/account-connection-links")))
    }

    @Test
    fun asyncListSendsTheLimitAndCursorAndReadsEachLink() {
        val page = asyncClient().x().accountConnectionLinks().list(params).get()

        verify(
            getRequestedFor(urlPathEqualTo("/x/account-connection-links"))
                .withQueryParam("limit", equalTo("20"))
                .withQueryParam("cursor", equalTo("abc123"))
        )
        assertPage(page)
    }

    @Test
    fun everyListOverloadReadsThePage() {
        val service = client().x().accountConnectionLinks()
        val raw = service.withRawResponse()
        val options = RequestOptions.none()
        val pages =
            listOf(
                service.list(),
                service.list(params),
                service.list(options),
                service.list(params, options),
                raw.list().use { it.parse() },
                raw.list(params).use { it.parse() },
                raw.list(options).use { it.parse() },
                raw.list(params, options).use { it.parse() },
            )

        pages.forEach(::assertPage)
    }

    @Test
    fun everyAsyncListOverloadReadsThePage() {
        val service = asyncClient().x().accountConnectionLinks()
        val raw = service.withRawResponse()
        val options = RequestOptions.none()
        val pages =
            listOf(
                service.list().get(),
                service.list(params).get(),
                service.list(options).get(),
                service.list(params, options).get(),
                raw.list().get().use { it.parse() },
                raw.list(params).get().use { it.parse() },
                raw.list(options).get().use { it.parse() },
                raw.list(params, options).get().use { it.parse() },
            )

        pages.forEach(::assertPage)
    }
}
