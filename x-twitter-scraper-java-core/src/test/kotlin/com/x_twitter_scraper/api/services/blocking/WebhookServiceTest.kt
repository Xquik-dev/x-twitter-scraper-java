// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.webhooks.WebhookCreateParams
import com.x_twitter_scraper.api.models.webhooks.WebhookUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WebhookServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val webhookService = client.webhooks()

        val webhook =
            webhookService.create(
                WebhookCreateParams.builder()
                    .addEventType(EventType.TWEET_NEW)
                    .addEventType(EventType.TWEET_REPLY)
                    .url("https://example.com/webhook")
                    .build()
            )

        webhook.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val webhookService = client.webhooks()

        val webhook =
            webhookService.update(
                WebhookUpdateParams.builder()
                    .id("id")
                    .addEventType(EventType.TWEET_NEW)
                    .isActive(true)
                    .url("https://example.com/webhook")
                    .build()
            )

        webhook.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val webhookService = client.webhooks()

        val webhooks = webhookService.list()

        webhooks.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun deactivate() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val webhookService = client.webhooks()

        val response = webhookService.deactivate("id")

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listDeliveries() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val webhookService = client.webhooks()

        val response = webhookService.listDeliveries("id")

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun test() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val webhookService = client.webhooks()

        val response = webhookService.test("id")

        response.validate()
    }
}
