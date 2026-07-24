// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.users

import com.x_twitter_scraper.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRemoveFollowerParamsTest {

    @Test
    fun create() {
        UserRemoveFollowerParams.builder()
            .id("id")
            .idempotencyKey("Idempotency-Key")
            .account("@elonmusk")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            UserRemoveFollowerParams.builder()
                .id("id")
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            UserRemoveFollowerParams.builder()
                .id("id")
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "Idempotency-Key").build())
    }

    @Test
    fun body() {
        val params =
            UserRemoveFollowerParams.builder()
                .id("id")
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
    }
}
