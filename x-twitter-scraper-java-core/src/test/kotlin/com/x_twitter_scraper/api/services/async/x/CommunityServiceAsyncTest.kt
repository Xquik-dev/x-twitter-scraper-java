// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.communities.CommunityCreateParams
import com.x_twitter_scraper.api.models.x.communities.CommunityDeleteParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveModeratorsParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveSearchParams
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
                    .cursor("cursor")
                    .pageSize(20L)
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
                CommunityRetrieveModeratorsParams.builder().id("id").cursor("cursor").build()
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
}
