// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveMembersParams
import com.x_twitter_scraper.api.models.x.lists.ListRetrieveTweetsParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ListServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveFollowers() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val listServiceAsync = client.x().lists()

        val paginatedUsersFuture =
            listServiceAsync.retrieveFollowers(
                ListRetrieveFollowersParams.builder().id("id").cursor("cursor").build()
            )

        val paginatedUsers = paginatedUsersFuture.get()
        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveMembers() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val listServiceAsync = client.x().lists()

        val paginatedUsersFuture =
            listServiceAsync.retrieveMembers(
                ListRetrieveMembersParams.builder().id("id").cursor("cursor").build()
            )

        val paginatedUsers = paginatedUsersFuture.get()
        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveTweets() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val listServiceAsync = client.x().lists()

        val paginatedTweetsFuture =
            listServiceAsync.retrieveTweets(
                ListRetrieveTweetsParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .includeReplies(true)
                    .sinceTime("sinceTime")
                    .untilTime("untilTime")
                    .build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        paginatedTweets.validate()
    }
}
