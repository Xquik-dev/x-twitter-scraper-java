// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.jobs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JobRetrieveResponseTest {

    @Test
    fun create() {
        val jobRetrieveResponse =
            JobRetrieveResponse.builder()
                .job(
                    JobRetrieveResponse.Job.builder()
                        .id("1899202395210649861")
                        .url("https://x.com/i/jobs/1899202395210649861")
                        .account(
                            JobRetrieveResponse.Job.Account.builder()
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
                            JobRetrieveResponse.Job.Company.builder()
                                .id("1714017006498824192")
                                .logoUrl("logoUrl")
                                .name("TotalMed")
                                .build()
                        )
                        .description("What is Commonware? We build open primitives.")
                        .descriptionMarkdown("# What is Commonware?")
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
                        .shortDescription("Commonware is hiring founding engineers.")
                        .team("Protocol")
                        .title("Engineer")
                        .build()
                )
                .build()

        assertThat(jobRetrieveResponse.job())
            .isEqualTo(
                JobRetrieveResponse.Job.builder()
                    .id("1899202395210649861")
                    .url("https://x.com/i/jobs/1899202395210649861")
                    .account(
                        JobRetrieveResponse.Job.Account.builder()
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
                        JobRetrieveResponse.Job.Company.builder()
                            .id("1714017006498824192")
                            .logoUrl("logoUrl")
                            .name("TotalMed")
                            .build()
                    )
                    .description("What is Commonware? We build open primitives.")
                    .descriptionMarkdown("# What is Commonware?")
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
                    .shortDescription("Commonware is hiring founding engineers.")
                    .team("Protocol")
                    .title("Engineer")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val jobRetrieveResponse =
            JobRetrieveResponse.builder()
                .job(
                    JobRetrieveResponse.Job.builder()
                        .id("1899202395210649861")
                        .url("https://x.com/i/jobs/1899202395210649861")
                        .account(
                            JobRetrieveResponse.Job.Account.builder()
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
                            JobRetrieveResponse.Job.Company.builder()
                                .id("1714017006498824192")
                                .logoUrl("logoUrl")
                                .name("TotalMed")
                                .build()
                        )
                        .description("What is Commonware? We build open primitives.")
                        .descriptionMarkdown("# What is Commonware?")
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
                        .shortDescription("Commonware is hiring founding engineers.")
                        .team("Protocol")
                        .title("Engineer")
                        .build()
                )
                .build()

        val roundtrippedJobRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(jobRetrieveResponse),
                jacksonTypeRef<JobRetrieveResponse>(),
            )

        assertThat(roundtrippedJobRetrieveResponse).isEqualTo(jobRetrieveResponse)
    }
}
