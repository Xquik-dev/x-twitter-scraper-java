// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x.users

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.users.follow.FollowCreateParams
import com.x_twitter_scraper.api.models.x.users.follow.FollowDeleteAllParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FollowServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val followServiceAsync = client.x().users().follow()

        val followFuture =
            followServiceAsync.create(
                FollowCreateParams.builder().userId("userId").account("account").build()
            )

        val follow = followFuture.get()
        follow.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun deleteAll() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val followServiceAsync = client.x().users().follow()

        val responseFuture =
            followServiceAsync.deleteAll(
                FollowDeleteAllParams.builder().userId("userId").account("account").build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
