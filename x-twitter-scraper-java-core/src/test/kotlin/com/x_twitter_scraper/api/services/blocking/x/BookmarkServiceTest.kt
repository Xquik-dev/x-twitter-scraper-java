// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.bookmarks.BookmarkListParams
import org.junit.jupiter.api.Test

internal class BookmarkServiceTest {
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val bookmarkService = client.x().bookmarks()

        val paginatedTweets =
            bookmarkService.list(
                BookmarkListParams.builder()
                    .cursor("DAACCgACGRElMJcAAA")
                    .folderId("folderId")
                    .build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun retrieveFolders() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val bookmarkService = client.x().bookmarks()

        val response = bookmarkService.retrieveFolders()

        kotlin.test.assertNotNull(response)
    }
}
