// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.bookmarks

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BookmarkListParamsTest {

    @Test
    fun create() {
        BookmarkListParams.builder().cursor("cursor").folderId("folderId").build()
    }

    @Test
    fun queryParams() {
        val params = BookmarkListParams.builder().cursor("cursor").folderId("folderId").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("cursor", "cursor").put("folderId", "folderId").build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = BookmarkListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
