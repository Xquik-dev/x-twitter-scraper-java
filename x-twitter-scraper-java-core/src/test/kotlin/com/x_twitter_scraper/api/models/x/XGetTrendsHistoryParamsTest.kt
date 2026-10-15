// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetTrendsHistoryParamsTest {

    @Test
    fun create() {
        XGetTrendsHistoryParams.builder()
            .count(1L)
            .country("country")
            .cursor("2026-10-14T00:00:00.000Z~1791979200000")
            .every("1h")
            .fields("id,text,author.username")
            .from("2026-10-13")
            .limit(1L)
            .location("location")
            .omit("entities,media")
            .to("2026-10-14")
            .woeid(1L)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            XGetTrendsHistoryParams.builder()
                .count(1L)
                .country("country")
                .cursor("2026-10-14T00:00:00.000Z~1791979200000")
                .every("1h")
                .fields("id,text,author.username")
                .from("2026-10-13")
                .limit(1L)
                .location("location")
                .omit("entities,media")
                .to("2026-10-14")
                .woeid(1L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("count", "1")
                    .put("country", "country")
                    .put("cursor", "2026-10-14T00:00:00.000Z~1791979200000")
                    .put("every", "1h")
                    .put("fields", "id,text,author.username")
                    .put("from", "2026-10-13")
                    .put("limit", "1")
                    .put("location", "location")
                    .put("omit", "entities,media")
                    .put("to", "2026-10-14")
                    .put("woeid", "1")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = XGetTrendsHistoryParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
