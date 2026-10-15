// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.XTwitterScraperClient
import com.x_twitter_scraper.api.client.XTwitterScraperClientAsync
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.jobs.JobListLocationsParams
import com.x_twitter_scraper.api.models.x.jobs.JobRetrieveParams
import com.x_twitter_scraper.api.models.x.jobs.JobSearchParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class JobServiceSpecExampleTest {

    private lateinit var client: XTwitterScraperClient
    private lateinit var asyncClient: XTwitterScraperClientAsync

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .responseValidation(true)
                .build()
        asyncClient =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .responseValidation(true)
                .build()
    }

    @Test
    fun retrieveParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/jobs/1899202395210649861"))
                .willReturn(
                    okJson(
                        """
                        {
                          "job": {
                            "id": "1899202395210649861",
                            "title": "Engineer",
                            "url": "https://x.com/i/jobs/1899202395210649861",
                            "applyUrl": "https://xquik.com/example",
                            "location": "United States",
                            "locationType": "remote",
                            "employmentType": "full_time",
                            "seniorityLevel": "lead",
                            "jobFunction": "software_engineering",
                            "formattedSalary": "Starting at ${'$'}225K",
                            "salaryMin": 225000,
                            "salaryCurrencyCode": "USD",
                            "salaryInterval": "annually",
                            "featured": true,
                            "shortDescription": "Commonware is hiring founding engineers.",
                            "description": "What is Commonware? We build open primitives.",
                            "descriptionMarkdown": "# What is Commonware?",
                            "account": {
                              "id": "1812126202804711425",
                              "username": "commonwarexyz",
                              "name": "commonware",
                              "verified": true,
                              "verifiedType": "Business"
                            }
                          }
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            JobRetrieveParams.builder()
                .id("1899202395210649861")
                .fields("id,text,author.username")
                .omit("entities,media")
                .build()

        val response = client.x().jobs().retrieve(params)
        val asyncResponse = asyncClient.x().jobs().retrieve(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/jobs/1899202395210649861"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.job().id()).isEqualTo("1899202395210649861")
        assertThat(response.job().url()).isEqualTo("https://x.com/i/jobs/1899202395210649861")
        assertThat(response.job().account().get().id()).isEqualTo("1812126202804711425")
        assertThat(response.job().account().get().verified()).isEqualTo(true)
        assertThat(response.job().account().get().name()).contains("commonware")
        assertThat(response.job().account().get().username()).contains("commonwarexyz")
        assertThat(response.job().account().get().verifiedType()).contains("Business")
        assertThat(response.job().applyUrl()).contains("https://xquik.com/example")
        assertThat(response.job().description())
            .contains("What is Commonware? We build open primitives.")
        assertThat(response.job().descriptionMarkdown()).contains("# What is Commonware?")
        assertThat(response.job().employmentType()).contains("full_time")
        assertThat(response.job().featured()).contains(true)
        assertThat(response.job().formattedSalary()).contains("Starting at \$225K")
        assertThat(response.job().jobFunction()).contains("software_engineering")
        assertThat(response.job().location()).contains("United States")
        assertThat(response.job().locationType()).contains("remote")
        assertThat(response.job().salaryCurrencyCode()).contains("USD")
        assertThat(response.job().salaryInterval()).contains("annually")
        assertThat(response.job().salaryMin()).contains(225000.0)
        assertThat(response.job().seniorityLevel()).contains("lead")
        assertThat(response.job().shortDescription())
            .contains("Commonware is hiring founding engineers.")
        assertThat(response.job().title()).contains("Engineer")
        assertThat(response.job().account().get().description()).isEmpty
        assertThat(response.job().account().get().profileImageShape()).isEmpty
        assertThat(response.job().account().get().profilePicture()).isEmpty
        assertThat(response.job().account().get().profilePictureOriginal()).isEmpty
        assertThat(response.job().company()).isEmpty
        assertThat(response.job().postedAt()).isEmpty
        assertThat(response.job().salaryMax()).isEmpty
        assertThat(response.job().team()).isEmpty
    }

    @Test
    fun listLocationsParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/jobs/locations"))
                .willReturn(
                    okJson(
                        """
                        {
                          "locations": [
                            {
                              "id": "1720462281849397612",
                              "name": "New York, US"
                            },
                            {
                              "id": "1720462281920696805",
                              "name": "New York City, NY"
                            }
                          ],
                          "count": 2
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            JobListLocationsParams.builder()
                .q("new york")
                .fields("id,text,author.username")
                .limit(5L)
                .omit("entities,media")
                .build()

        val response = client.x().jobs().listLocations(params)
        val asyncResponse = asyncClient.x().jobs().listLocations(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/jobs/locations"))
                .withQueryParam("q", equalTo("new york"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("limit", equalTo("5"))
                .withQueryParam("omit", equalTo("entities,media")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.count()).isEqualTo(2L)
        assertThat(response.locations()).hasSize(2)
        assertThat(response.locations()[0].id()).isEqualTo("1720462281849397612")
        assertThat(response.locations()[0].name()).isEqualTo("New York, US")
        assertThat(response.locations()[1].id()).isEqualTo("1720462281920696805")
        assertThat(response.locations()[1].name()).isEqualTo("New York City, NY")
    }

    @Test
    fun searchParsesTheSpecExample() {
        stubFor(
            get(urlPathEqualTo("/x/jobs/search"))
                .willReturn(
                    okJson(
                        """
                        {
                          "jobs": [
                            {
                              "id": "1899202395210649861",
                              "title": "Engineer",
                              "url": "https://x.com/i/jobs/1899202395210649861",
                              "applyUrl": "https://xquik.com/example",
                              "location": "United States",
                              "formattedSalary": "Starting at ${'$'}225K",
                              "salaryMin": 225000,
                              "salaryCurrencyCode": "USD",
                              "salaryInterval": "annually",
                              "account": {
                                "id": "1812126202804711425",
                                "username": "commonwarexyz",
                                "name": "commonware",
                                "verified": true,
                                "verifiedType": "Business"
                              }
                            }
                          ],
                          "has_next_page": true,
                          "next_cursor": "DAACCgACGRElMJcAAA"
                        }
                        """
                            .trimIndent()
                    )
                )
        )
        val params =
            JobSearchParams.builder()
                .q("engineer")
                .company("SpaceX")
                .employmentType("full_time")
                .fields("id,text,author.username")
                .location("Berlin")
                .locationId("1720462281849397612")
                .locationType("remote,hybrid")
                .omit("entities,media")
                .seniority("senior,lead")
                .build()

        val response = client.x().jobs().search(params)
        val asyncResponse = asyncClient.x().jobs().search(params).get()

        verify(
            2,
            getRequestedFor(urlPathEqualTo("/x/jobs/search"))
                .withQueryParam("q", equalTo("engineer"))
                .withQueryParam("company", equalTo("SpaceX"))
                .withQueryParam("employmentType", equalTo("full_time"))
                .withQueryParam("fields", equalTo("id,text,author.username"))
                .withQueryParam("location", equalTo("Berlin"))
                .withQueryParam("locationId", equalTo("1720462281849397612"))
                .withQueryParam("locationType", equalTo("remote,hybrid"))
                .withQueryParam("omit", equalTo("entities,media"))
                .withQueryParam("seniority", equalTo("senior,lead")),
        )
        assertThat(asyncResponse).isEqualTo(response)
        assertThat(response.hasNextPage()).isEqualTo(true)
        assertThat(response.jobs()).hasSize(1)
        assertThat(response.jobs()[0].id()).isEqualTo("1899202395210649861")
        assertThat(response.jobs()[0].url()).isEqualTo("https://x.com/i/jobs/1899202395210649861")
        assertThat(response.jobs()[0].account().get().id()).isEqualTo("1812126202804711425")
        assertThat(response.jobs()[0].account().get().verified()).isEqualTo(true)
        assertThat(response.jobs()[0].account().get().name()).contains("commonware")
        assertThat(response.jobs()[0].account().get().username()).contains("commonwarexyz")
        assertThat(response.jobs()[0].account().get().verifiedType()).contains("Business")
        assertThat(response.jobs()[0].applyUrl()).contains("https://xquik.com/example")
        assertThat(response.jobs()[0].formattedSalary()).contains("Starting at \$225K")
        assertThat(response.jobs()[0].location()).contains("United States")
        assertThat(response.jobs()[0].salaryCurrencyCode()).contains("USD")
        assertThat(response.jobs()[0].salaryInterval()).contains("annually")
        assertThat(response.jobs()[0].salaryMin()).contains(225000.0)
        assertThat(response.jobs()[0].title()).contains("Engineer")
        assertThat(response.nextCursor()).isEqualTo("DAACCgACGRElMJcAAA")
        assertThat(response.jobs()[0].account().get().description()).isEmpty
        assertThat(response.jobs()[0].account().get().profileImageShape()).isEmpty
        assertThat(response.jobs()[0].account().get().profilePicture()).isEmpty
        assertThat(response.jobs()[0].account().get().profilePictureOriginal()).isEmpty
        assertThat(response.jobs()[0].company()).isEmpty
        assertThat(response.jobs()[0].description()).isEmpty
        assertThat(response.jobs()[0].descriptionMarkdown()).isEmpty
        assertThat(response.jobs()[0].employmentType()).isEmpty
        assertThat(response.jobs()[0].featured()).isEmpty
        assertThat(response.jobs()[0].jobFunction()).isEmpty
        assertThat(response.jobs()[0].locationType()).isEmpty
        assertThat(response.jobs()[0].postedAt()).isEmpty
        assertThat(response.jobs()[0].salaryMax()).isEmpty
        assertThat(response.jobs()[0].seniorityLevel()).isEmpty
        assertThat(response.jobs()[0].shortDescription()).isEmpty
        assertThat(response.jobs()[0].team()).isEmpty
    }
}
