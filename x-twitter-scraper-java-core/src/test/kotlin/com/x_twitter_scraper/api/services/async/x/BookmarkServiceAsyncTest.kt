// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.bookmarks.BookmarkListParams
import org.junit.jupiter.api.Test

internal class BookmarkServiceAsyncTest {
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val bookmarkServiceAsync = client.x().bookmarks()

        val paginatedTweetsFuture =
            bookmarkServiceAsync.list(
                BookmarkListParams.builder()
                    .cursor("DAACCgACGRElMJcAAA")
                    .folderId("folderId")
                    .build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun retrieveFolders() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val bookmarkServiceAsync = client.x().bookmarks()

        val responseFuture = bookmarkServiceAsync.retrieveFolders()

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
