// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.jobs

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JobListLocationsParamsTest {

    @Test
    fun create() {
        JobListLocationsParams.builder()
            .q("new york")
            .fields("id,text,author.username")
            .limit(5L)
            .omit("entities,media")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            JobListLocationsParams.builder()
                .q("new york")
                .fields("id,text,author.username")
                .limit(5L)
                .omit("entities,media")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("q", "new york")
                    .put("fields", "id,text,author.username")
                    .put("limit", "5")
                    .put("omit", "entities,media")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = JobListLocationsParams.builder().q("new york").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("q", "new york").build())
    }
}
