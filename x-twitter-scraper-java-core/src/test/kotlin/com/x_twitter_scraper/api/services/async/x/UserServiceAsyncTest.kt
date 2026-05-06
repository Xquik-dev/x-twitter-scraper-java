// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.users.UserRetrieveBatchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowersYouKnowParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveFollowingParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveLikesParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMediaParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveMentionsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveSearchParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveTweetsParams
import com.x_twitter_scraper.api.models.x.users.UserRetrieveVerifiedFollowersParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class UserServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.x().users()

        val userProfileFuture = userServiceAsync.retrieve("id")

        val userProfile = userProfileFuture.get()
        userProfile.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveBatch() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.x().users()

        val paginatedUsersFuture =
            userServiceAsync.retrieveBatch(UserRetrieveBatchParams.builder().ids("ids").build())

        val paginatedUsers = paginatedUsersFuture.get()
        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveFollowers() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.x().users()

        val paginatedUsersFuture =
            userServiceAsync.retrieveFollowers(
                UserRetrieveFollowersParams.builder().id("id").cursor("cursor").pageSize(0L).build()
            )

        val paginatedUsers = paginatedUsersFuture.get()
        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveFollowersYouKnow() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.x().users()

        val paginatedUsersFuture =
            userServiceAsync.retrieveFollowersYouKnow(
                UserRetrieveFollowersYouKnowParams.builder().id("id").cursor("cursor").build()
            )

        val paginatedUsers = paginatedUsersFuture.get()
        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveFollowing() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.x().users()

        val paginatedUsersFuture =
            userServiceAsync.retrieveFollowing(
                UserRetrieveFollowingParams.builder().id("id").cursor("cursor").pageSize(0L).build()
            )

        val paginatedUsers = paginatedUsersFuture.get()
        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveLikes() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.x().users()

        val paginatedTweetsFuture =
            userServiceAsync.retrieveLikes(
                UserRetrieveLikesParams.builder().id("id").cursor("cursor").build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        paginatedTweets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveMedia() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.x().users()

        val paginatedTweetsFuture =
            userServiceAsync.retrieveMedia(
                UserRetrieveMediaParams.builder().id("id").cursor("cursor").build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        paginatedTweets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveMentions() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.x().users()

        val paginatedTweetsFuture =
            userServiceAsync.retrieveMentions(
                UserRetrieveMentionsParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .sinceTime("sinceTime")
                    .untilTime("untilTime")
                    .build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        paginatedTweets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveSearch() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.x().users()

        val paginatedUsersFuture =
            userServiceAsync.retrieveSearch(
                UserRetrieveSearchParams.builder().q("q").cursor("cursor").build()
            )

        val paginatedUsers = paginatedUsersFuture.get()
        paginatedUsers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveTweets() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.x().users()

        val paginatedTweetsFuture =
            userServiceAsync.retrieveTweets(
                UserRetrieveTweetsParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .includeParentTweet(true)
                    .includeReplies(true)
                    .build()
            )

        val paginatedTweets = paginatedTweetsFuture.get()
        paginatedTweets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveVerifiedFollowers() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val userServiceAsync = client.x().users()

        val paginatedUsersFuture =
            userServiceAsync.retrieveVerifiedFollowers(
                UserRetrieveVerifiedFollowersParams.builder().id("id").cursor("cursor").build()
            )

        val paginatedUsers = paginatedUsersFuture.get()
        paginatedUsers.validate()
    }
}
