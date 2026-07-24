// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.async

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClientAsync
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.events.EventListParams
import org.junit.jupiter.api.Test

internal class EventServiceAsyncTest {
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val eventServiceAsync = client.events()

        val eventDetailFuture = eventServiceAsync.retrieve("id")

        val eventDetail = eventDetailFuture.get()
        kotlin.test.assertNotNull(eventDetail)
    }

    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClientAsync.builder()
                .baseUrl(com.x_twitter_scraper.api.LoopbackTestServer.baseUrl())
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val eventServiceAsync = client.events()

        val eventsFuture =
            eventServiceAsync.list(
                EventListParams.builder()
                    .cursor("cursor")
                    .eventType(EventType.TWEET_NEW)
                    .limit(1L)
                    .monitorId("monitorId")
                    .build()
            )

        val events = eventsFuture.get()
        kotlin.test.assertNotNull(events)
    }
}
