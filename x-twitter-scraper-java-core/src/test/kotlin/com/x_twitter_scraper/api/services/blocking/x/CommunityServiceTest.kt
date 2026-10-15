// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
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

internal class CommunityServiceTest {
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val community =
            communityService.create(
                CommunityCreateParams.builder()
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .name("Example Name")
                    .description("A community for Tesla enthusiasts")
                    .build()
            )

        kotlin.test.assertNotNull(community)
    }

    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val community =
            communityService.delete(
                CommunityDeleteParams.builder()
                    .id("id")
                    .idempotencyKey("Idempotency-Key")
                    .account("@elonmusk")
                    .communityName("Tesla Fans")
                    .build()
            )

        kotlin.test.assertNotNull(community)
    }

    @Test
    fun find() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val communityPage =
            communityService.find(
                CommunityFindParams.builder()
                    .q("q")
                    .cursor("cursor")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .pageSize(1L)
                    .build()
            )

        kotlin.test.assertNotNull(communityPage)
    }

    @Test
    fun listPopular() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val communityPage =
            communityService.listPopular(
                CommunityListPopularParams.builder()
                    .cursor("cursor")
                    .fields("id,text,author.username")
                    .omit("entities,media")
                    .pageSize(1L)
                    .topic("topic")
                    .topicId("topicId")
                    .build()
            )

        kotlin.test.assertNotNull(communityPage)
    }

    @Test
    fun listSuggested() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val response =
            communityService.listSuggested(
                CommunityListSuggestedParams.builder()
                    .fields("id,text,author.username")
                    .limit(1L)
                    .omit("entities,media")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun listTopics() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val response =
            communityService.listTopics(
                CommunityListTopicsParams.builder()
                    .fields("id,text,author.username")
                    .limit(1L)
                    .omit("entities,media")
                    .build()
            )

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveInfo() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val response = communityService.retrieveInfo("id")

        kotlin.test.assertNotNull(response)
    }

    @Test
    fun retrieveMembers() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val paginatedUsers =
            communityService.retrieveMembers(
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

        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveModerators() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val paginatedUsers =
            communityService.retrieveModerators(
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

        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveSearch() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val paginatedTweets =
            communityService.retrieveSearch(
                CommunityRetrieveSearchParams.builder()
                    .communityId("321669910225")
                    .q("q")
                    .cursor("cursor")
                    .pageSize(1L)
                    .queryType(CommunityRetrieveSearchParams.QueryType.LATEST)
                    .build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
    }

    @Test
    fun searchMembers() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityService = client.x().communities()

        val paginatedUsers =
            communityService.searchMembers(
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

        kotlin.test.assertNotNull(paginatedUsers)
    }
}
