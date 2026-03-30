// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.events.EventListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class EventServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val eventServiceAsync = client.events()

        val eventDetailFuture = eventServiceAsync.retrieve("id")

        val eventDetail = eventDetailFuture.get()
        eventDetail.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val eventServiceAsync = client.events()

        val eventsFuture =
            eventServiceAsync.list(
                EventListParams.builder()
                    .after("after")
                    .eventType(EventType.TWEET_NEW)
                    .limit(1L)
                    .monitorId("monitorId")
                    .build()
            )

        val events = eventsFuture.get()
        events.validate()
    }
}
