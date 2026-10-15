// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.communities.CommunityCreateParams
import com.x_twitter_scraper.api.models.x.communities.CommunityDeleteParams
import com.x_twitter_scraper.api.models.x.communities.CommunityFindParams
import com.x_twitter_scraper.api.models.x.communities.CommunityListPopularParams
import com.x_twitter_scraper.api.models.x.communities.CommunityListSuggestedParams
import com.x_twitter_scraper.api.models.x.communities.CommunityListTopicsParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveModeratorsParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveSearchParams
import com.x_twitter_scraper.api.models.x.communities.CommunitySearchMembersParams
import org.junit.jupiter.api.Test

internal class CommunityServiceAsyncTest {
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityServiceAsync = client.x().communities()

        val communityFuture =
            communityServiceAsync.create(
                CommunityCreateParams.builder()
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .name("Example Name")
                    .description("A community for Tesla enthusiasts")
                    .build()
            )

        val community = communityFuture.get()
        kotlin.test.assertNotNull(community)
    }

    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityServiceAsync = client.x().communities()

        val communityFuture =
            communityServiceAsync.delete(
                CommunityDeleteParams.builder()
                    .id("id")
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .communityName("Tesla Fans")
                    .build()
            )

        val community = communityFuture.get()
        kotlin.test.assertNotNull(community)
    }

    @Test
    fun find() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityServiceAsync = client.x().communities()

        val communityPageFuture =
            communityServiceAsync.find(
                CommunityFindParams.builder()
                    .q("q")
                    .cursor("cursor")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .pageSize(1L)
                    .build()
            )

        val communityPage = communityPageFuture.get()
        kotlin.test.assertNotNull(communityPage)
    }

    @Test
    fun listPopular() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityServiceAsync = client.x().communities()

        val communityPageFuture =
            communityServiceAsync.listPopular(
                CommunityListPopularParams.builder()
                    .cursor("cursor")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .pageSize(1L)
                    .topic("topic")
                    .topicId("topicId")
                    .build()
            )

        val communityPage = communityPageFuture.get()
        kotlin.test.assertNotNull(communityPage)
    }

    @Test
    fun listSuggested() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityServiceAsync = client.x().communities()

        val responseFuture =
            communityServiceAsync.listSuggested(
                CommunityListSuggestedParams.builder()
                    .fields("id,text,author.username")
                    .limit(1L)
                    .omit("entities,media")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun listTopics() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityServiceAsync = client.x().communities()

        val responseFuture =
            communityServiceAsync.listTopics(
                CommunityListTopicsParams.builder()
                    .fields("id,text,author.username")
                    .limit(1L)
                    .omit("entities,media")
                    .build()
            )

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveInfo() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityServiceAsync = client.x().communities()

        val responseFuture = communityServiceAsync.retrieveInfo("id")

        val response = responseFuture.get()
        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveMembers() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityServiceAsync = client.x().communities()

        val paginatedUsersFuture =
            communityServiceAsync.retrieveMembers(
                CommunityRetrieveMembersParams.builder()
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
    fun retrieveModerators() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityServiceAsync = client.x().communities()

        val paginatedUsersFuture =
            communityServiceAsync.retrieveModerators(
                CommunityRetrieveModeratorsParams.builder()
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
        val communityServiceAsync = client.x().communities()

        val paginatedTweetsFuture =
            communityServiceAsync.retrieveSearch(
                CommunityRetrieveSearchParams.builder()
                    .communityId("321669910225")
                    .q("q")
                    .cursor("cursor")
                    .pageSize(1L)
                    .queryType(CommunityRetrieveSearchParams.QueryType.LATEST)
                    .build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun searchMembers() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityServiceAsync = client.x().communities()

        val paginatedUsersFuture =
            communityServiceAsync.searchMembers(
                CommunitySearchMembersParams.builder()
                    .id("id")
                    .q("q")
                    .bioContains("bioContains")
                    .blueVerifiedOnly(true)
                    .businessEmailOnly(true)
                    .emailDomains("acme.com,stanford.edu")
                    .fields("id,text,author.username")
                    .hasEmail(true)
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
                    .omit("entities,media")
                    .usernameContains("usernameContains")
                    .verifiedOnly(true)
                    .verifiedType("verifiedType")
                    .build()
            )

        val paginatedUsers = paginatedUsersFuture.get()
        kotlin.test.assertNotNull(paginatedUsers)
    }
}
