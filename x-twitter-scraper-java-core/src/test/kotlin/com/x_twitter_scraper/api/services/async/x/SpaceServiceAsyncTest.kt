// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.spaces.SpaceRetrieveParams
import com.x_twitter_scraper.api.models.x.spaces.SpaceRetrieveReplayParams
import com.x_twitter_scraper.api.models.x.spaces.SpaceSearchParams
import org.junit.jupiter.api.Test

internal class SpaceServiceAsyncTest {
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val spaceServiceAsync = client.x().spaces()

        val spaceFuture =
            spaceServiceAsync.retrieve(
                SpaceRetrieveParams.builder()
                    .id("id")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .build()
            )

        val space = spaceFuture.get()
        kotlin.test.assertNotNull(space)
    }

    @Test
    fun retrieveReplay() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val spaceServiceAsync = client.x().spaces()

        val responseFuture =
            spaceServiceAsync.retrieveReplay(
                SpaceRetrieveReplayParams.builder()
                    .id("id")
                    .fields("id,text,author.username")
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
        val spaceServiceAsync = client.x().spaces()

        val responseFuture =
            spaceServiceAsync.search(
                SpaceSearchParams.builder()
                    .q("from:solana")
                    .cursor("cursor")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .pageSize(1L)
                    .queryType(SpaceSearchParams.QueryType.LATEST)
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }
}
