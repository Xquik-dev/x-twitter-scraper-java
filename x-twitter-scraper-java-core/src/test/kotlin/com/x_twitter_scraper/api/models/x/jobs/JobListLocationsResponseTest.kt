// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.jobs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JobListLocationsResponseTest {

    @Test
    fun create() {
        val jobListLocationsResponse =
            JobListLocationsResponse.builder()
                .count(2L)
                .addLocation(
                    JobListLocationsResponse.Location.builder()
                        .id("1720462281849397612")
                        .name("New York, US")
                        .build()
                )
                .build()

        assertThat(jobListLocationsResponse.count()).isEqualTo(2L)
        assertThat(jobListLocationsResponse.locations())
            .containsExactly(
                JobListLocationsResponse.Location.builder()
                    .id("1720462281849397612")
                    .name("New York, US")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val jobListLocationsResponse =
            JobListLocationsResponse.builder()
                .count(2L)
                .addLocation(
                    JobListLocationsResponse.Location.builder()
                        .id("1720462281849397612")
                        .name("New York, US")
                        .build()
                )
                .build()

        val roundtrippedJobListLocationsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(jobListLocationsResponse),
                jacksonTypeRef<JobListLocationsResponse>(),
            )

        assertThat(roundtrippedJobListLocationsResponse).isEqualTo(jobListLocationsResponse)
    }
}
