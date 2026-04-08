// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.integrations.IntegrationCreateParams
import com.x_twitter_scraper.api.models.integrations.IntegrationListDeliveriesParams
import com.x_twitter_scraper.api.models.integrations.IntegrationUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class IntegrationServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val integrationService = client.integrations()

        val integration =
            integrationService.create(
                IntegrationCreateParams.builder()
                    .config(
                        IntegrationCreateParams.Config.builder().chatId("-1001234567890").build()
                    )
                    .addEventType(EventType.TWEET_NEW)
                    .addEventType(EventType.FOLLOWER_GAINED)
                    .name("My Telegram Bot")
                    .build()
            )

        integration.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val integrationService = client.integrations()

        val integration = integrationService.retrieve("id")

        integration.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val integrationService = client.integrations()

        val integration =
            integrationService.update(
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

        integration.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val integrationService = client.integrations()

        val integrations = integrationService.list()

        integrations.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val integrationService = client.integrations()

        val integration = integrationService.delete("id")

        integration.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listDeliveries() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val integrationService = client.integrations()

        val response =
            integrationService.listDeliveries(
                IntegrationListDeliveriesParams.builder().id("id").limit(1L).build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun sendTest() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val integrationService = client.integrations()

        val response = integrationService.sendTest("id")

        response.validate()
    }
}
