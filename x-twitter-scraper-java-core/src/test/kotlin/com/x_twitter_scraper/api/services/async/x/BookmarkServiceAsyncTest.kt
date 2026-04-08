// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.bookmarks.BookmarkListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class BookmarkServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val bookmarkServiceAsync = client.x().bookmarks()

        val bookmarksFuture =
            bookmarkServiceAsync.list(
                BookmarkListParams.builder().cursor("folders_value").folderId("folderId").build()
            )

        val bookmarks = bookmarksFuture.get()
        bookmarks.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveFolders() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val bookmarkServiceAsync = client.x().bookmarks()

        val responseFuture = bookmarkServiceAsync.retrieveFolders()

        val response = responseFuture.get()
        response.validate()
    }
}
