// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.compose

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComposeCreateResponseTest {

    @Test
    fun create() {
        val composeCreateResponse =
            ComposeCreateResponse.builder()
                .putAdditionalProperty("foo", JsonValue.from("bar"))
                .build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val composeCreateResponse =
            ComposeCreateResponse.builder()
                .putAdditionalProperty("foo", JsonValue.from("bar"))
                .build()

        val roundtrippedComposeCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(composeCreateResponse),
                jacksonTypeRef<ComposeCreateResponse>(),
            )

        assertThat(roundtrippedComposeCreateResponse).isEqualTo(composeCreateResponse)
    }
}
