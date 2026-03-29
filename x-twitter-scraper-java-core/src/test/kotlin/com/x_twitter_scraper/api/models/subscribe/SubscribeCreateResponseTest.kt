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
                .url("https://example.com")
                .message("message")
                .status(SubscribeCreateResponse.Status.CHECKOUT_CREATED)
                .build()

        assertThat(subscribeCreateResponse.url()).isEqualTo("https://example.com")
        assertThat(subscribeCreateResponse.message()).contains("message")
        assertThat(subscribeCreateResponse.status())
            .contains(SubscribeCreateResponse.Status.CHECKOUT_CREATED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val subscribeCreateResponse =
            SubscribeCreateResponse.builder()
                .url("https://example.com")
                .message("message")
                .status(SubscribeCreateResponse.Status.CHECKOUT_CREATED)
                .build()

        val roundtrippedSubscribeCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(subscribeCreateResponse),
                jacksonTypeRef<SubscribeCreateResponse>(),
            )

        assertThat(roundtrippedSubscribeCreateResponse).isEqualTo(subscribeCreateResponse)
    }
}
