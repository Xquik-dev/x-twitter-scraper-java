// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.jobs.JobListLocationsParams
import com.x_twitter_scraper.api.models.x.jobs.JobRetrieveParams
import com.x_twitter_scraper.api.models.x.jobs.JobSearchParams
import org.junit.jupiter.api.Test

internal class JobServiceTest {
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val jobService = client.x().jobs()

        val job =
            jobService.retrieve(
                JobRetrieveParams.builder()
                    .id("id")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .build()
            )

        kotlin.test.assertNotNull(job)
    }

    @Test
    fun listLocations() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val jobService = client.x().jobs()

        val response =
            jobService.listLocations(
                JobListLocationsParams.builder()
                    .q("new york")
                    .fields("id,text,author.username")
                    .limit(5L)
                    .omit("entities,media")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun search() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val jobService = client.x().jobs()

        val response =
            jobService.search(
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
            )

        kotlin.test.assertNotNull(response)
    }
}
