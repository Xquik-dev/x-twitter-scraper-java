// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
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

internal class UserServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveBatch() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveBatch(UserRetrieveBatchParams.builder().ids("ids").build())

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveFollowers() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveFollowers(
                UserRetrieveFollowersParams.builder().id("id").cursor("cursor").pageSize(0L).build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveFollowersYouKnow() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveFollowersYouKnow(
                UserRetrieveFollowersYouKnowParams.builder().id("id").cursor("cursor").build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveFollowing() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveFollowing(
                UserRetrieveFollowingParams.builder().id("id").cursor("cursor").pageSize(0L).build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveLikes() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveLikes(
                UserRetrieveLikesParams.builder().id("id").cursor("cursor").build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveMedia() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveMedia(
                UserRetrieveMediaParams.builder().id("id").cursor("cursor").build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveMentions() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveMentions(
                UserRetrieveMentionsParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .sinceTime("sinceTime")
                    .untilTime("untilTime")
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveSearch() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveSearch(
                UserRetrieveSearchParams.builder().q("q").cursor("cursor").build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveTweets() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveTweets(
                UserRetrieveTweetsParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .includeParentTweet(true)
                    .includeReplies(true)
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveVerifiedFollowers() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val userService = client.x().users()

        val response =
            userService.retrieveVerifiedFollowers(
                UserRetrieveVerifiedFollowersParams.builder().id("id").cursor("cursor").build()
            )

        response.validate()
    }
}
