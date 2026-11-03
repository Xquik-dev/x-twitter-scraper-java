// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.events

import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventStreamParamsTest {

    @Test
    fun create() {
        EventStreamParams.builder().lastEventID("Last-Event-ID").build()
    }

    @Test
    fun headers() {
        val params = EventStreamParams.builder().lastEventID("Last-Event-ID").build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Last-Event-ID", "Last-Event-ID").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params = EventStreamParams.builder().build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun queryParams() {
        val params =
            EventStreamParams.builder()
                .include(EventStreamParams.Include.POST_METRICS)
                .lookBack(true)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("include", "post_metrics").put("lookBack", "true").build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = EventStreamParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
