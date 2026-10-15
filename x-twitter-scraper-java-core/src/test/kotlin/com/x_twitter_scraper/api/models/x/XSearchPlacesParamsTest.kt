// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XSearchPlacesParamsTest {

    @Test
    fun create() {
        XSearchPlacesParams.builder()
            .q("q")
            .fields("id,text,author.username")
            .limit(1L)
            .omit("entities,media")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            XSearchPlacesParams.builder()
                .q("q")
                .fields("id,text,author.username")
                .limit(1L)
                .omit("entities,media")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("q", "q")
                    .put("fields", "id,text,author.username")
                    .put("limit", "1")
                    .put("omit", "entities,media")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = XSearchPlacesParams.builder().q("q").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("q", "q").build())
    }
}
