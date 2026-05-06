// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.EventType
import com.x_twitter_scraper.api.models.events.EventListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class EventServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val eventService = client.events()

        val eventDetail = eventService.retrieve("id")

        eventDetail.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = XTwitterScraperOkHttpClient.builder().apiKey("My API Key").build()
        val eventService = client.events()

        val events =
            eventService.list(
                EventListParams.builder()
                    .after("after")
                    .eventType(EventType.TWEET_NEW)
                    .limit(1L)
                    .monitorId("monitorId")
                    .build()
            )

        events.validate()
    }
}
