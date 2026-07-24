// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveTweetsParams
import org.junit.jupiter.api.Test

internal class ListServiceTest {
    @Test
    fun retrieveFollowers() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val listService = client.x().lists()

        val paginatedUsers =
            listService.retrieveFollowers(
                ListRetrieveFollowersParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .pageSize(20L)
                    .build()
            )

        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveMembers() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val listService = client.x().lists()

        val paginatedUsers =
            listService.retrieveMembers(
                ListRetrieveMembersParams.builder().id("id").cursor("cursor").pageSize(20L).build()
            )

        kotlin.test.assertNotNull(paginatedUsers)
    }

    @Test
    fun retrieveTweets() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val listService = client.x().lists()

        val paginatedTweets =
            listService.retrieveTweets(
                ListRetrieveTweetsParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .includeReplies(true)
                    .pageSize(1L)
                    .sinceTime("sinceTime")
                    .untilTime("untilTime")
                    .build()
            )

        kotlin.test.assertNotNull(paginatedTweets)
    }
}
