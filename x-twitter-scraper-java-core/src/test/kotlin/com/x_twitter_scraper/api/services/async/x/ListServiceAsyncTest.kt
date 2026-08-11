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
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
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
        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveMembers() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
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
        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveTweets() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
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
        paginatedTweets.validate()
    }
}
