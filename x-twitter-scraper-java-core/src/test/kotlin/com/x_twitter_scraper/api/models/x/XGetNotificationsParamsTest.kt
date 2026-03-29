// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetNotificationsParamsTest {

    @Test
    fun create() {
        XGetNotificationsParams.builder()
            .cursor("cursor")
            .type(XGetNotificationsParams.Type.ALL)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            XGetNotificationsParams.builder()
                .cursor("cursor")
                .type(XGetNotificationsParams.Type.ALL)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("cursor", "cursor").put("type", "All").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = XGetNotificationsParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
