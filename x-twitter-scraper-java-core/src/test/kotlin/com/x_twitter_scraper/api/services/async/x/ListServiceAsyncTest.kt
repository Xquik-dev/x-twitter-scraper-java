// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveSearchParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveTweetsParams
import org.junit.jupiter.api.Test

internal class ListServiceAsyncTest {
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val listServiceAsync = client.x().lists()

        val listFuture =
            listServiceAsync.retrieve(
                ListRetrieveParams.builder()
                    .id("id")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .build()
            )

        val list = listFuture.get()
        kotlin.test.assertNotNull(list)
    }

    @Test
    fun retrieveFollowers() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val listServiceAsync = client.x().lists()

        val paginatedUsersFuture =
            listServiceAsync.retrieveFollowers(
                ListRetrieveFollowersParams.builder()
                    .id("id")
                    .bioContains("bioContains")
                    .cursor("cursor")
                    .hasLocation(true)
                    .hasWebsite(true)
                    .locationContains("locationContains")
                    .maxFollowers(0L)
                    .maxFollowing(0L)
                    .maxStatuses(0L)
                    .minAccountAgeDays(0L)
                    .minFollowers(0L)
                    .minFollowing(0L)
                    .minStatuses(0L)
                    .pageSize(20L)
                    .usernameContains("usernameContains")
                    .verifiedOnly(true)
                    .verifiedType("verifiedType")
                    .build()
            )

        val paginatedUsers = paginatedUsersFuture.get()
        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveMembers() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val listServiceAsync = client.x().lists()

        val paginatedUsersFuture =
            listServiceAsync.retrieveMembers(
                ListRetrieveMembersParams.builder()
                    .id("id")
                    .bioContains("bioContains")
                    .cursor("cursor")
                    .hasLocation(true)
                    .hasWebsite(true)
                    .locationContains("locationContains")
                    .maxFollowers(0L)
                    .maxFollowing(0L)
                    .maxStatuses(0L)
                    .minAccountAgeDays(0L)
                    .minFollowers(0L)
                    .minFollowing(0L)
                    .minStatuses(0L)
                    .pageSize(20L)
                    .usernameContains("usernameContains")
                    .verifiedOnly(true)
                    .verifiedType("verifiedType")
                    .build()
            )

        val paginatedUsers = paginatedUsersFuture.get()
        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveSearch() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val listServiceAsync = client.x().lists()

        val responseFuture =
            listServiceAsync.retrieveSearch(
                ListRetrieveSearchParams.builder()
                    .q("q")
                    .cursor("cursor")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .pageSize(1L)
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveTweets() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val listServiceAsync = client.x().lists()

        val paginatedTweetsFuture =
            listServiceAsync.retrieveTweets(
                ListRetrieveTweetsParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .includeReplies(true)
                    .pageSize(1L)
                    .sinceTime("sinceTime")
                    .untilTime("untilTime")
                    .build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        kotlin.test.assertNotNull(paginatedTweets)
    }
}
