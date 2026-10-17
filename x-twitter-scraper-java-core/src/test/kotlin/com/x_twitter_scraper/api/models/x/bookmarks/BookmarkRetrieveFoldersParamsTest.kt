// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.bookmarks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BookmarkRetrieveFoldersParamsTest {

    @Test
    fun create() {
        BookmarkRetrieveFoldersParams.builder().build()
    }

    @Test
    fun additionalFields() {
        val params = BookmarkRetrieveFoldersParams.builder().cursor("sample").build()

        assertThat(params.cursor()).isPresent()
        assertThat(params._queryParams().values("cursor")).containsExactly("sample")
        assertThat(params.toBuilder().build()).isEqualTo(params)
    }
}
