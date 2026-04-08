// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.compose

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComposeCreateParamsTest {

    @Test
    fun create() {
        ComposeCreateParams.builder()
            .step(ComposeCreateParams.Step.COMPOSE)
            .additionalContext("https://x.com/elonmusk/status/1234567890")
            .callToAction("Follow for more")
            .draft("AI is changing everything. Here's why.")
            .goal(ComposeCreateParams.Goal.ENGAGEMENT)
            .hasLink(false)
            .hasMedia(false)
            .mediaType(ComposeCreateParams.MediaType.NONE)
            .styleUsername("elonmusk")
            .tone("professional")
            .topic("AI trends in 2025")
            .build()
    }

    @Test
    fun body() {
        val params =
            ComposeCreateParams.builder()
                .step(ComposeCreateParams.Step.COMPOSE)
                .additionalContext("https://x.com/elonmusk/status/1234567890")
                .callToAction("Follow for more")
                .draft("AI is changing everything. Here's why.")
                .goal(ComposeCreateParams.Goal.ENGAGEMENT)
                .hasLink(false)
                .hasMedia(false)
                .mediaType(ComposeCreateParams.MediaType.NONE)
                .styleUsername("elonmusk")
                .tone("professional")
                .topic("AI trends in 2025")
                .build()

        val body = params._body()

        assertThat(body.step()).isEqualTo(ComposeCreateParams.Step.COMPOSE)
        assertThat(body.additionalContext()).contains("https://x.com/elonmusk/status/1234567890")
        assertThat(body.callToAction()).contains("Follow for more")
        assertThat(body.draft()).contains("AI is changing everything. Here's why.")
        assertThat(body.goal()).contains(ComposeCreateParams.Goal.ENGAGEMENT)
        assertThat(body.hasLink()).contains(false)
        assertThat(body.hasMedia()).contains(false)
        assertThat(body.mediaType()).contains(ComposeCreateParams.MediaType.NONE)
        assertThat(body.styleUsername()).contains("elonmusk")
        assertThat(body.tone()).contains("professional")
        assertThat(body.topic()).contains("AI trends in 2025")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ComposeCreateParams.builder().step(ComposeCreateParams.Step.COMPOSE).build()

        val body = params._body()

        assertThat(body.step()).isEqualTo(ComposeCreateParams.Step.COMPOSE)
    }
}
