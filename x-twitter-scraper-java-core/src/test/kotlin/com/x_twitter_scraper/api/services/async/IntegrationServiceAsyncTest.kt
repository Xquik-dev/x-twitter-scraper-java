// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.integrations.IntegrationCreateParams
import com.x_twitter_scraper.api.models.integrations.IntegrationListDeliveriesParams
import com.x_twitter_scraper.api.models.integrations.IntegrationUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class IntegrationServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val integrationServiceAsync = client.integrations()

        val integrationFuture =
            integrationServiceAsync.create(
                IntegrationCreateParams.builder()
                    .config(
                        IntegrationCreateParams.Config.builder().chatId("-1001234567890").build()
                    )
                    .addEventType(EventType.TWEET_NEW)
                    .addEventType(EventType.FOLLOWER_GAINED)
                    .name("My Telegram Bot")
                    .type(IntegrationCreateParams.Type.TELEGRAM)
                    .build()
            )

        val integration = integrationFuture.get()
        integration.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val integrationServiceAsync = client.integrations()

        val integrationFuture = integrationServiceAsync.retrieve("id")

        val integration = integrationFuture.get()
        integration.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val integrationServiceAsync = client.integrations()

        val integrationFuture =
            integrationServiceAsync.update(
                IntegrationUpdateParams.builder()
                    .id("id")
                    .addEventType(EventType.TWEET_NEW)
                    .filters(IntegrationUpdateParams.Filters.builder().build())
                    .isActive(true)
                    .messageTemplate(IntegrationUpdateParams.MessageTemplate.builder().build())
                    .name("My Telegram Bot")
                    .scopeAllMonitors(true)
                    .silentPush(false)
                    .build()
            )

        val integration = integrationFuture.get()
        integration.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val integrationServiceAsync = client.integrations()

        val integrationsFuture = integrationServiceAsync.list()

        val integrations = integrationsFuture.get()
        integrations.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val integrationServiceAsync = client.integrations()

        val integrationFuture = integrationServiceAsync.delete("id")

        val integration = integrationFuture.get()
        integration.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listDeliveries() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val integrationServiceAsync = client.integrations()

        val responseFuture =
            integrationServiceAsync.listDeliveries(
                IntegrationListDeliveriesParams.builder().id("id").limit(1L).build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun sendTest() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val integrationServiceAsync = client.integrations()

        val responseFuture = integrationServiceAsync.sendTest("id")

        val response = responseFuture.get()
        response.validate()
    }
}
