// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.lists

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ListRetrieveSearchParamsTest {

    @Test
    fun create() {
        ListRetrieveSearchParams.builder()
            .q("q")
            .cursor("cursor")
            .fields("id,text,author.username")
            .omit("entities,media")
            .pageSize(1L)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ListRetrieveSearchParams.builder()
                .q("q")
                .cursor("cursor")
                .fields("id,text,author.username")
                .omit("entities,media")
                .pageSize(1L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("q", "q")
                    .put("cursor", "cursor")
                    .put("fields", "id,text,author.username")
                    .put("omit", "entities,media")
                    .put("pageSize", "1")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ListRetrieveSearchParams.builder().q("q").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("q", "q").build())
    }
}
