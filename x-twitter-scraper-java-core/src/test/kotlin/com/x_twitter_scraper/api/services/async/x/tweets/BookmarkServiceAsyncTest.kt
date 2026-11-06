// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x.tweets

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.tweets.bookmark.BookmarkCreateParams
import com.x_twitter_scraper.api.models.x.tweets.bookmark.BookmarkDeleteParams
import org.junit.jupiter.api.Test

internal class BookmarkServiceAsyncTest {
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val bookmarkServiceAsync = client.x().tweets().bookmark()

        val bookmarkFuture =
            bookmarkServiceAsync.create(
                BookmarkCreateParams.builder()
                    .id("id")
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .build()
            )

        val bookmark = bookmarkFuture.get()
        kotlin.test.assertNotNull(bookmark)
    }

    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val bookmarkServiceAsync = client.x().tweets().bookmark()

        val bookmarkFuture =
            bookmarkServiceAsync.delete(
                BookmarkDeleteParams.builder()
                    .id("id")
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .build()
            )

        val bookmark = bookmarkFuture.get()
        kotlin.test.assertNotNull(bookmark)
    }
}
