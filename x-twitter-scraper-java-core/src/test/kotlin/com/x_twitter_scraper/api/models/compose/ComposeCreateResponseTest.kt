// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.compose

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComposeCreateResponseTest {

    @Test
    fun create() {
        val composeCreateResponse =
            ComposeCreateResponse.builder()
                .feedback("feedback")
                .score(0.0)
                .addSuggestion("string")
                .text("text")
                .build()

        assertThat(composeCreateResponse.feedback()).contains("feedback")
        assertThat(composeCreateResponse.score()).contains(0.0)
        assertThat(composeCreateResponse.suggestions().getOrNull()).containsExactly("string")
        assertThat(composeCreateResponse.text()).contains("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val composeCreateResponse =
            ComposeCreateResponse.builder()
                .feedback("feedback")
                .score(0.0)
                .addSuggestion("string")
                .text("text")
                .build()

        val roundtrippedComposeCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(composeCreateResponse),
                jacksonTypeRef<ComposeCreateResponse>(),
            )

        assertThat(roundtrippedComposeCreateResponse).isEqualTo(composeCreateResponse)
    }
}
