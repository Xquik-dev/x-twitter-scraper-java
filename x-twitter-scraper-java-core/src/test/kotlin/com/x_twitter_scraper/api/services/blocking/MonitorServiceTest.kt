// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.monitors.MonitorCreateParams
import com.x_twitter_scraper.api.models.monitors.MonitorUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MonitorServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val monitorService = client.monitors()

        val monitor =
            monitorService.create(
                MonitorCreateParams.builder()
                    .addEventType(EventType.TWEET_NEW)
                    .addEventType(EventType.TWEET_REPLY)
                    .username("elonmusk")
                    .build()
            )

        monitor.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val monitorService = client.monitors()

        val monitor = monitorService.retrieve("id")

        monitor.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val monitorService = client.monitors()

        val monitor =
            monitorService.update(
                MonitorUpdateParams.builder()
                    .id("id")
                    .addEventType(EventType.TWEET_NEW)
                    .isActive(true)
                    .build()
            )

        monitor.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val monitorService = client.monitors()

        val monitors = monitorService.list()

        monitors.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun deactivate() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val monitorService = client.monitors()

        val response = monitorService.deactivate("id")

        response.validate()
    }
}
