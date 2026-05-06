// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveTweetsParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ListServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveFollowers() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val listService = client.x().lists()

        val paginatedUsers =
            listService.retrieveFollowers(
                ListRetrieveFollowersParams.builder().id("id").cursor("cursor").build()
            )

        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveMembers() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val listService = client.x().lists()

        val paginatedUsers =
            listService.retrieveMembers(
                ListRetrieveMembersParams.builder().id("id").cursor("cursor").build()
            )

        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveTweets() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val listService = client.x().lists()

        val paginatedTweets =
            listService.retrieveTweets(
                ListRetrieveTweetsParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .includeReplies(true)
                    .sinceTime("sinceTime")
                    .untilTime("untilTime")
                    .build()
            )

        paginatedTweets.validate()
    }
}
