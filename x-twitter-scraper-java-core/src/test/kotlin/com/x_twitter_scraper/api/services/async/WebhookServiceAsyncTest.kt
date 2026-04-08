// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.webhooks.WebhookCreateParams
import com.x_twitter_scraper.api.models.webhooks.WebhookUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WebhookServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val webhookServiceAsync = client.webhooks()

        val webhookFuture =
            webhookServiceAsync.create(
                WebhookCreateParams.builder()
                    .addEventType(WebhookCreateParams.EventType.TWEET_NEW)
                    .addEventType(WebhookCreateParams.EventType.FOLLOWER_GAINED)
                    .url("https://example.com/webhook")
                    .build()
            )

        val webhook = webhookFuture.get()
        webhook.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val webhookServiceAsync = client.webhooks()

        val webhookFuture =
            webhookServiceAsync.update(
                WebhookUpdateParams.builder()
                    .id("id")
                    .addEventType(WebhookUpdateParams.EventType.TWEET_NEW)
                    .addEventType(WebhookUpdateParams.EventType.FOLLOWER_GAINED)
                    .isActive(true)
                    .url("https://example.com/webhook")
                    .build()
            )

        val webhook = webhookFuture.get()
        webhook.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val webhookServiceAsync = client.webhooks()

        val webhooksFuture = webhookServiceAsync.list()

        val webhooks = webhooksFuture.get()
        webhooks.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun deactivate() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val webhookServiceAsync = client.webhooks()

        val responseFuture = webhookServiceAsync.deactivate("id")

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listDeliveries() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val webhookServiceAsync = client.webhooks()

        val responseFuture = webhookServiceAsync.listDeliveries("id")

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun test() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val webhookServiceAsync = client.webhooks()

        val responseFuture = webhookServiceAsync.test("id")

        val response = responseFuture.get()
        response.validate()
    }
}
