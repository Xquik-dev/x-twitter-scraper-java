// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XAutocompleteSearchParamsTest {

    @Test
    fun create() {
        XAutocompleteSearchParams.builder()
            .q("nasa")
            .fields("id,text,author.username")
            .limit(1L)
            .omit("entities,media")
            .types("users,topics")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            XAutocompleteSearchParams.builder()
                .q("nasa")
                .fields("id,text,author.username")
                .limit(1L)
                .omit("entities,media")
                .types("users,topics")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("q", "nasa")
                    .put("fields", "id,text,author.username")
                    .put("limit", "1")
                    .put("omit", "entities,media")
                    .put("types", "users,topics")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = XAutocompleteSearchParams.builder().q("nasa").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("q", "nasa").build())
    }
}
