// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.jobs.JobListLocationsParams
import com.x_twitter_scraper.api.models.x.jobs.JobRetrieveParams
import com.x_twitter_scraper.api.models.x.jobs.JobSearchParams
import org.junit.jupiter.api.Test

internal class JobServiceAsyncTest {
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val jobServiceAsync = client.x().jobs()

        val jobFuture =
            jobServiceAsync.retrieve(
                JobRetrieveParams.builder()
                    .id("id")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .build()
            )

        val job = jobFuture.get()
        kotlin.test.assertNotNull(job)
    }

    @Test
    fun listLocations() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val jobServiceAsync = client.x().jobs()

        val responseFuture =
            jobServiceAsync.listLocations(
                JobListLocationsParams.builder()
                    .q("new york")
                    .fields("id,text,author.username")
                    .limit(5L)
                    .omit("entities,media")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun search() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val jobServiceAsync = client.x().jobs()

        val responseFuture =
            jobServiceAsync.search(
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

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
