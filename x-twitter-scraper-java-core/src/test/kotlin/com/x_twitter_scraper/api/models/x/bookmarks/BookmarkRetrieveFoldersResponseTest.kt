// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.bookmarks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BookmarkRetrieveFoldersResponseTest {

    @Test
    fun create() {
        val bookmarkRetrieveFoldersResponse =
            BookmarkRetrieveFoldersResponse.builder()
                .addFolder(
                    BookmarkRetrieveFoldersResponse.Folder.builder().id("id").name("name").build()
                )
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .build()

        assertThat(bookmarkRetrieveFoldersResponse.folders())
            .containsExactly(
                BookmarkRetrieveFoldersResponse.Folder.builder().id("id").name("name").build()
            )
        assertThat(bookmarkRetrieveFoldersResponse.hasNextPage()).isEqualTo(true)
        assertThat(bookmarkRetrieveFoldersResponse.nextCursor()).isEqualTo("next_cursor")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bookmarkRetrieveFoldersResponse =
            BookmarkRetrieveFoldersResponse.builder()
                .addFolder(
                    BookmarkRetrieveFoldersResponse.Folder.builder().id("id").name("name").build()
                )
                .hasNextPage(true)
                .nextCursor("next_cursor")
                .build()

        val roundtrippedBookmarkRetrieveFoldersResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(bookmarkRetrieveFoldersResponse),
                jacksonTypeRef<BookmarkRetrieveFoldersResponse>(),
            )

        assertThat(roundtrippedBookmarkRetrieveFoldersResponse)
            .isEqualTo(bookmarkRetrieveFoldersResponse)
    }
}
