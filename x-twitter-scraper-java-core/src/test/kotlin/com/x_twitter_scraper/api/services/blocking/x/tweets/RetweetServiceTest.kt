// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x.tweets

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.tweets.retweet.RetweetCreateParams
import com.x_twitter_scraper.api.models.x.tweets.retweet.RetweetDeleteParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class RetweetServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val retweetService = client.x().tweets().retweet()

        val retweet =
            retweetService.create(
                RetweetCreateParams.builder().tweetId("tweetId").account("account").build()
            )

        retweet.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val retweetService = client.x().tweets().retweet()

        val retweet =
            retweetService.delete(
                RetweetDeleteParams.builder().tweetId("tweetId").account("account").build()
            )

        retweet.validate()
    }
}
