// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetHashflagsParamsTest {

    @Test
    fun create() {
        XGetHashflagsParams.builder()
            .activeOnly(true)
            .fields("id,text,author.username")
            .limit(1L)
            .omit("entities,media")
            .q("q")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            XGetHashflagsParams.builder()
                .activeOnly(true)
                .fields("id,text,author.username")
                .limit(1L)
                .omit("entities,media")
                .q("q")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("activeOnly", "true")
                    .put("fields", "id,text,author.username")
                    .put("limit", "1")
                    .put("omit", "entities,media")
                    .put("q", "q")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = XGetHashflagsParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
