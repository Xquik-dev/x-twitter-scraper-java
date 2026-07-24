// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.profile

import com.x_twitter_scraper.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileUpdateParamsTest {

    @Test
    fun create() {
        ProfileUpdateParams.builder()
            .idempotencyKey("Idempotency-Key")
            .account("@elonmusk")
            .description("description_value")
            .location("location_value")
            .name("Example Name")
            .url("https://xquik.com/example")
            .build()
    }

    @Test
    fun headers() {
        val params =
            ProfileUpdateParams.builder()
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .description("description_value")
                .location("location_value")
                .name("Example Name")
                .url("https://xquik.com/example")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "Idempotency-Key").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            ProfileUpdateParams.builder()
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
            ProfileUpdateParams.builder()
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .description("description_value")
                .location("location_value")
                .name("Example Name")
                .url("https://xquik.com/example")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
        assertThat(body.description()).contains("description_value")
        assertThat(body.location()).contains("location_value")
        assertThat(body.name()).contains("Example Name")
        assertThat(body.url()).contains("https://xquik.com/example")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ProfileUpdateParams.builder()
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
    }
}
