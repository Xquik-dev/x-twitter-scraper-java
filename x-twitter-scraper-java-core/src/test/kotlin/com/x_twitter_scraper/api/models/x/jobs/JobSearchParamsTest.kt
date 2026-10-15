// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.jobs

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JobSearchParamsTest {

    @Test
    fun create() {
        JobSearchParams.builder()
            .q("engineer")
            .company("SpaceX")
            .cursor("cursor")
            .employmentType("full_time")
            .fields("id,text,author.username")
            .location("Berlin")
            .locationId("1720462281849397612")
            .locationType("remote,hybrid")
            .omit("entities,media")
            .pageSize(1L)
            .seniority("senior,lead")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            JobSearchParams.builder()
                .q("engineer")
                .company("SpaceX")
                .cursor("cursor")
                .employmentType("full_time")
                .fields("id,text,author.username")
                .location("Berlin")
                .locationId("1720462281849397612")
                .locationType("remote,hybrid")
                .omit("entities,media")
                .pageSize(1L)
                .seniority("senior,lead")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("q", "engineer")
                    .put("company", "SpaceX")
                    .put("cursor", "cursor")
                    .put("employmentType", "full_time")
                    .put("fields", "id,text,author.username")
                    .put("location", "Berlin")
                    .put("locationId", "1720462281849397612")
                    .put("locationType", "remote,hybrid")
                    .put("omit", "entities,media")
                    .put("pageSize", "1")
                    .put("seniority", "senior,lead")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = JobSearchParams.builder().q("engineer").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("q", "engineer").build())
    }
}
