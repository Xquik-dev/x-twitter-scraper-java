// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async.x.communities

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.x.communities.join.JoinCreateParams
import com.x_twitter_scraper.api.models.x.communities.join.JoinDeleteAllParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class JoinServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val joinServiceAsync = client.x().communities().join()

        val joinFuture =
            joinServiceAsync.create(JoinCreateParams.builder().id("id").account("account").build())

        val join = joinFuture.get()
        join.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun deleteAll() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val joinServiceAsync = client.x().communities().join()

        val responseFuture =
            joinServiceAsync.deleteAll(
                JoinDeleteAllParams.builder().id("id").account("account").build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
