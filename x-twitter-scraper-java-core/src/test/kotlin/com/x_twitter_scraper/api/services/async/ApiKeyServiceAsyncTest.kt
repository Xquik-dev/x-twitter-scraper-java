// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.apikeys.ApiKeyCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ApiKeyServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val apiKeyServiceAsync = client.apiKeys()

        val apiKeyFuture =
            apiKeyServiceAsync.create(ApiKeyCreateParams.builder().name("My API Key").build())

        val apiKey = apiKeyFuture.get()
        apiKey.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val apiKeyServiceAsync = client.apiKeys()

        val apiKeysFuture = apiKeyServiceAsync.list()

        val apiKeys = apiKeysFuture.get()
        apiKeys.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun revoke() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val apiKeyServiceAsync = client.apiKeys()

        val responseFuture = apiKeyServiceAsync.revoke("id")

        val response = responseFuture.get()
        response.validate()
    }
}
