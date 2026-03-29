// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.events

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventListParamsTest {

    @Test
    fun create() {
        EventListParams.builder()
            .after("after")
            .eventType(EventListParams.EventType.TWEET_NEW)
            .limit(1L)
            .monitorId("monitorId")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            EventListParams.builder()
                .after("after")
                .eventType(EventListParams.EventType.TWEET_NEW)
                .limit(1L)
                .monitorId("monitorId")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("eventType", "tweet.new")
                    .put("limit", "1")
                    .put("monitorId", "monitorId")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = EventListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
