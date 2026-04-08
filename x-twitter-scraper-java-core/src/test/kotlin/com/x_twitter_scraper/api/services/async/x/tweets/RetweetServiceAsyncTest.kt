// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x.tweets

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.tweets.retweet.RetweetCreateParams
import com.x_twitter_scraper.api.models.x.tweets.retweet.RetweetDeleteParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class RetweetServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val retweetServiceAsync = client.x().tweets().retweet()

        val retweetFuture =
            retweetServiceAsync.create(
                RetweetCreateParams.builder().id("id").account("@elonmusk").build()
            )

        val retweet = retweetFuture.get()
        retweet.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val retweetServiceAsync = client.x().tweets().retweet()

        val retweetFuture =
            retweetServiceAsync.delete(
                RetweetDeleteParams.builder().id("id").account("@elonmusk").build()
            )

        val retweet = retweetFuture.get()
        retweet.validate()
    }
}
