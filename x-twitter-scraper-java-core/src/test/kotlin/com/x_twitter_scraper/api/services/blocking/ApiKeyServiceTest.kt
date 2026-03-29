// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.apikeys.ApiKeyCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ApiKeyServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val apiKeyService = client.apiKeys()

        val apiKey = apiKeyService.create(ApiKeyCreateParams.builder().name("name").build())

        apiKey.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val apiKeyService = client.apiKeys()

        val apiKeys = apiKeyService.list()

        apiKeys.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun revoke() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val apiKeyService = client.apiKeys()

        val response = apiKeyService.revoke("id")

        response.validate()
    }
}
