// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.subscribe

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SubscribeCreateResponseTest {

    @Test
    fun create() {
        val subscribeCreateResponse =
            SubscribeCreateResponse.builder()
                .message("Billing session created")
                .status(SubscribeCreateResponse.Status.CHECKOUT_CREATED)
                .url("https://xquik.com/billing/session")
                .build()

        assertThat(subscribeCreateResponse.message()).isEqualTo("Billing session created")
        assertThat(subscribeCreateResponse.status())
            .isEqualTo(SubscribeCreateResponse.Status.CHECKOUT_CREATED)
        assertThat(subscribeCreateResponse.url()).isEqualTo("https://xquik.com/billing/session")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val subscribeCreateResponse =
            SubscribeCreateResponse.builder()
                .message("Billing session created")
                .status(SubscribeCreateResponse.Status.CHECKOUT_CREATED)
                .url("https://xquik.com/billing/session")
                .build()

        val roundtrippedSubscribeCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(subscribeCreateResponse),
                jacksonTypeRef<SubscribeCreateResponse>(),
            )

        assertThat(roundtrippedSubscribeCreateResponse).isEqualTo(subscribeCreateResponse)
    }
}
