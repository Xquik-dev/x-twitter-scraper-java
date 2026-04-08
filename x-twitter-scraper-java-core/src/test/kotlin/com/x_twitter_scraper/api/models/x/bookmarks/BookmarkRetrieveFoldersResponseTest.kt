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
                    BookmarkRetrieveFoldersResponse.Folder.builder()
                        .id("1234567890")
                        .name("Read Later")
                        .build()
                )
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
                .build()

        assertThat(bookmarkRetrieveFoldersResponse.folders())
            .containsExactly(
                BookmarkRetrieveFoldersResponse.Folder.builder()
                    .id("1234567890")
                    .name("Read Later")
                    .build()
            )
        assertThat(bookmarkRetrieveFoldersResponse.hasNextPage()).isEqualTo(true)
        assertThat(bookmarkRetrieveFoldersResponse.nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bookmarkRetrieveFoldersResponse =
            BookmarkRetrieveFoldersResponse.builder()
                .addFolder(
                    BookmarkRetrieveFoldersResponse.Folder.builder()
                        .id("1234567890")
                        .name("Read Later")
                        .build()
                )
                .hasNextPage(true)
                .nextCursor("DAACCgACGRElMJcAAA")
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
