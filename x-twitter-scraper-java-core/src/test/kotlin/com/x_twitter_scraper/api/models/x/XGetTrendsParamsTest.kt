// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetTrendsParamsTest {

    @Test
    fun create() {
        XGetTrendsParams.builder()
            .at("2026-10-13T14:00:00Z")
            .count(1L)
            .country("country")
            .fields("id,text,author.username")
            .location("location")
            .omit("entities,media")
            .woeid(1L)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            XGetTrendsParams.builder()
                .at("2026-10-13T14:00:00Z")
                .count(1L)
                .country("country")
                .fields("id,text,author.username")
                .location("location")
                .omit("entities,media")
                .woeid(1L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("at", "2026-10-13T14:00:00Z")
                    .put("count", "1")
                    .put("country", "country")
                    .put("fields", "id,text,author.username")
                    .put("location", "location")
                    .put("omit", "entities,media")
                    .put("woeid", "1")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = XGetTrendsParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
