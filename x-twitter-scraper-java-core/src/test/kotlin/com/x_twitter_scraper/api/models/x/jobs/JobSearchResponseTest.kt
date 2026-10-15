// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.jobs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JobSearchResponseTest {

    @Test
    fun create() {
        val jobSearchResponse =
            JobSearchResponse.builder()
                .hasNextPage(true)
                .addJob(
                    JobSearchResponse.Job.builder()
                        .id("1899202395210649861")
                        .url("https://x.com/i/jobs/1899202395210649861")
                        .account(
                            JobSearchResponse.Job.Account.builder()
                                .id("1812126202804711425")
                                .verified(true)
                                .description("description")
                                .name("commonware")
                                .profileImageShape("Square")
                                .profilePicture("profilePicture")
                                .profilePictureOriginal("profilePictureOriginal")
                                .username("commonwarexyz")
                                .verifiedType("Business")
                                .build()
                        )
                        .applyUrl("https://xquik.com/example")
                        .company(
                            JobSearchResponse.Job.Company.builder()
                                .id("1714017006498824192")
                                .logoUrl("logoUrl")
                                .name("TotalMed")
                                .build()
                        )
                        .description("description")
                        .descriptionMarkdown("descriptionMarkdown")
                        .employmentType("full_time")
                        .featured(true)
                        .formattedSalary("Starting at \$225K")
                        .jobFunction("software_engineering")
                        .location("United States")
                        .locationType("remote")
                        .postedAt(OffsetDateTime.parse("2025-10-04T08:30:00.000Z"))
                        .salaryCurrencyCode("USD")
                        .salaryInterval("annually")
                        .salaryMax(300000.0)
                        .salaryMin(225000.0)
                        .seniorityLevel("lead")
                        .shortDescription("shortDescription")
                        .team("Protocol")
                        .title("Engineer")
                        .build()
                )
                .nextCursor("DAACCgACGRElMJcAAA")
                .build()

        assertThat(jobSearchResponse.hasNextPage()).isEqualTo(true)
        assertThat(jobSearchResponse.jobs())
            .containsExactly(
                JobSearchResponse.Job.builder()
                    .id("1899202395210649861")
                    .url("https://x.com/i/jobs/1899202395210649861")
                    .account(
                        JobSearchResponse.Job.Account.builder()
                            .id("1812126202804711425")
                            .verified(true)
                            .description("description")
                            .name("commonware")
                            .profileImageShape("Square")
                            .profilePicture("profilePicture")
                            .profilePictureOriginal("profilePictureOriginal")
                            .username("commonwarexyz")
                            .verifiedType("Business")
                            .build()
                    )
                    .applyUrl("https://xquik.com/example")
                    .company(
                        JobSearchResponse.Job.Company.builder()
                            .id("1714017006498824192")
                            .logoUrl("logoUrl")
                            .name("TotalMed")
                            .build()
                    )
                    .description("description")
                    .descriptionMarkdown("descriptionMarkdown")
                    .employmentType("full_time")
                    .featured(true)
                    .formattedSalary("Starting at \$225K")
                    .jobFunction("software_engineering")
                    .location("United States")
                    .locationType("remote")
                    .postedAt(OffsetDateTime.parse("2025-10-04T08:30:00.000Z"))
                    .salaryCurrencyCode("USD")
                    .salaryInterval("annually")
                    .salaryMax(300000.0)
                    .salaryMin(225000.0)
                    .seniorityLevel("lead")
                    .shortDescription("shortDescription")
                    .team("Protocol")
                    .title("Engineer")
                    .build()
            )
        assertThat(jobSearchResponse.nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val jobSearchResponse =
            JobSearchResponse.builder()
                .hasNextPage(true)
                .addJob(
                    JobSearchResponse.Job.builder()
                        .id("1899202395210649861")
                        .url("https://x.com/i/jobs/1899202395210649861")
                        .account(
                            JobSearchResponse.Job.Account.builder()
                                .id("1812126202804711425")
                                .verified(true)
                                .description("description")
                                .name("commonware")
                                .profileImageShape("Square")
                                .profilePicture("profilePicture")
                                .profilePictureOriginal("profilePictureOriginal")
                                .username("commonwarexyz")
                                .verifiedType("Business")
                                .build()
                        )
                        .applyUrl("https://xquik.com/example")
                        .company(
                            JobSearchResponse.Job.Company.builder()
                                .id("1714017006498824192")
                                .logoUrl("logoUrl")
                                .name("TotalMed")
                                .build()
                        )
                        .description("description")
                        .descriptionMarkdown("descriptionMarkdown")
                        .employmentType("full_time")
                        .featured(true)
                        .formattedSalary("Starting at \$225K")
                        .jobFunction("software_engineering")
                        .location("United States")
                        .locationType("remote")
                        .postedAt(OffsetDateTime.parse("2025-10-04T08:30:00.000Z"))
                        .salaryCurrencyCode("USD")
                        .salaryInterval("annually")
                        .salaryMax(300000.0)
                        .salaryMin(225000.0)
                        .seniorityLevel("lead")
                        .shortDescription("shortDescription")
                        .team("Protocol")
                        .title("Engineer")
                        .build()
                )
                .nextCursor("DAACCgACGRElMJcAAA")
                .build()

        val roundtrippedJobSearchResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(jobSearchResponse),
                jacksonTypeRef<JobSearchResponse>(),
            )

        assertThat(roundtrippedJobSearchResponse).isEqualTo(jobSearchResponse)
    }
}
