// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.communities.CommunityCreateParams
import com.x_twitter_scraper.api.models.x.communities.CommunityDeleteParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveModeratorsParams
import com.x_twitter_scraper.api.models.x.communities.CommunityRetrieveSearchParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CommunityServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityServiceAsync = client.x().communities()

        val communityFuture =
            communityServiceAsync.create(
                CommunityCreateParams.builder()
                    .account("@elonmusk")
                    .name("Example Name")
                    .description("A community for Tesla enthusiasts")
                    .build()
            )

        val community = communityFuture.get()
        community.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityServiceAsync = client.x().communities()

        val communityFuture =
            communityServiceAsync.delete(
                CommunityDeleteParams.builder()
                    .id("id")
                    .account("@elonmusk")
                    .communityName("Tesla Fans")
                    .build()
            )

        val community = communityFuture.get()
        community.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveInfo() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityServiceAsync = client.x().communities()

        val responseFuture = communityServiceAsync.retrieveInfo("id")

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveMembers() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityServiceAsync = client.x().communities()

        val paginatedUsersFuture =
            communityServiceAsync.retrieveMembers(
                CommunityRetrieveMembersParams.builder().id("id").cursor("cursor").build()
            )

        val paginatedUsers = paginatedUsersFuture.get()
        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveModerators() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityServiceAsync = client.x().communities()

        val paginatedUsersFuture =
            communityServiceAsync.retrieveModerators(
                CommunityRetrieveModeratorsParams.builder().id("id").cursor("cursor").build()
            )

        val paginatedUsers = paginatedUsersFuture.get()
        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveSearch() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val communityServiceAsync = client.x().communities()

        val paginatedTweetsFuture =
            communityServiceAsync.retrieveSearch(
                CommunityRetrieveSearchParams.builder()
                    .q("q")
                    .cursor("cursor")
                    .queryType("queryType")
                    .build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        paginatedTweets.validate()
    }
}
