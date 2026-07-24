// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
                .hasNextPage(false)
                .nextCursor("")
                .build()

        assertThat(bookmarkRetrieveFoldersResponse.folders())
            .containsExactly(
                BookmarkRetrieveFoldersResponse.Folder.builder()
                    .id("1234567890")
                    .name("Read Later")
                    .build()
            )
        assertThat(bookmarkRetrieveFoldersResponse.hasNextPage()).isEqualTo(false)
        assertThat(bookmarkRetrieveFoldersResponse.nextCursor()).isEqualTo("")
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
                .hasNextPage(false)
                .nextCursor("")
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
