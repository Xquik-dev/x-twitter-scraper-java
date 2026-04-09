// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking.x.tweets

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.x.tweets.like.LikeCreateParams
import com.x_twitter_scraper.api.models.x.tweets.like.LikeDeleteParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class LikeServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val likeService = client.x().tweets().like()

        val like =
            likeService.create(LikeCreateParams.builder().id("id").account("@elonmusk").build())

        like.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val likeService = client.x().tweets().like()

        val like =
            likeService.delete(LikeDeleteParams.builder().id("id").account("@elonmusk").build())

        like.validate()
    }
}
