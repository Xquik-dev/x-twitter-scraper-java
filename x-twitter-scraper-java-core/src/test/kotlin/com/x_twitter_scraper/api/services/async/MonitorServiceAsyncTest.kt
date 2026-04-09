// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.monitors.MonitorCreateParams
import com.x_twitter_scraper.api.models.monitors.MonitorUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MonitorServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val monitorServiceAsync = client.monitors()

        val monitorFuture =
            monitorServiceAsync.create(
                MonitorCreateParams.builder()
                    .addEventType(EventType.TWEET_NEW)
                    .addEventType(EventType.FOLLOWER_GAINED)
                    .username("elonmusk")
                    .build()
            )

        val monitor = monitorFuture.get()
        monitor.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val monitorServiceAsync = client.monitors()

        val monitorFuture = monitorServiceAsync.retrieve("id")

        val monitor = monitorFuture.get()
        monitor.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val monitorServiceAsync = client.monitors()

        val monitorFuture =
            monitorServiceAsync.update(
                MonitorUpdateParams.builder()
                    .id("id")
                    .addEventType(EventType.TWEET_NEW)
                    .isActive(true)
                    .build()
            )

        val monitor = monitorFuture.get()
        monitor.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val monitorServiceAsync = client.monitors()

        val monitorsFuture = monitorServiceAsync.list()

        val monitors = monitorsFuture.get()
        monitors.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun deactivate() {
        val client = XTwitterScraperOkHttpClientAsync.builder().apiKey("My API Key").build()
        val monitorServiceAsync = client.monitors()

        val responseFuture = monitorServiceAsync.deactivate("id")

        val response = responseFuture.get()
        response.validate()
    }
}
