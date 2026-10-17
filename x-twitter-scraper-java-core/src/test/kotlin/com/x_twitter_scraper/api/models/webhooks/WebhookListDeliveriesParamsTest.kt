// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.webhooks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookListDeliveriesParamsTest {

    @Test
    fun create() {
        WebhookListDeliveriesParams.builder().id("id").build()
    }

    @Test
    fun pathParams() {
        val params = WebhookListDeliveriesParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun additionalFields() {
        val params = WebhookListDeliveriesParams.builder().limit(1L).cursor("sample").build()

        assertThat(params.limit()).isPresent()
        assertThat(params._queryParams().values("limit")).containsExactly("1")
        assertThat(params.cursor()).isPresent()
        assertThat(params._queryParams().values("cursor")).containsExactly("sample")
        assertThat(params.toBuilder().build()).isEqualTo(params)
    }
}
