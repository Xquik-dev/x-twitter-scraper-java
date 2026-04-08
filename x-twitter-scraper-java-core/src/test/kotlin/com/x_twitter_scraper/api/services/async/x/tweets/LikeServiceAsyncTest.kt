// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x.tweets

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.tweets.like.LikeCreateParams
import com.x_twitter_scraper.api.models.x.tweets.like.LikeDeleteParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class LikeServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val likeServiceAsync = client.x().tweets().like()

        val likeFuture =
            likeServiceAsync.create(
                LikeCreateParams.builder().id("id").account("@elonmusk").build()
            )

        val like = likeFuture.get()
        like.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val likeServiceAsync = client.x().tweets().like()

        val likeFuture =
            likeServiceAsync.delete(
                LikeDeleteParams.builder().id("id").account("@elonmusk").build()
            )

        val like = likeFuture.get()
        like.validate()
    }
}
