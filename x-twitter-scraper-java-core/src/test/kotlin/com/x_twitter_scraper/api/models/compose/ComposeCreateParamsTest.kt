// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.compose

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComposeCreateParamsTest {

    @Test
    fun create() {
        ComposeCreateParams.builder()
            .step(ComposeCreateParams.Step.COMPOSE)
            .additionalContext("additionalContext")
            .callToAction("callToAction")
            .draft("draft")
            .goal(ComposeCreateParams.Goal.ENGAGEMENT)
            .hasLink(true)
            .hasMedia(true)
            .mediaType(ComposeCreateParams.MediaType.PHOTO)
            .styleUsername("styleUsername")
            .tone("tone")
            .topic("topic")
            .build()
    }

    @Test
    fun body() {
        val params =
            ComposeCreateParams.builder()
                .step(ComposeCreateParams.Step.COMPOSE)
                .additionalContext("additionalContext")
                .callToAction("callToAction")
                .draft("draft")
                .goal(ComposeCreateParams.Goal.ENGAGEMENT)
                .hasLink(true)
                .hasMedia(true)
                .mediaType(ComposeCreateParams.MediaType.PHOTO)
                .styleUsername("styleUsername")
                .tone("tone")
                .topic("topic")
                .build()

        val body = params._body()

        assertThat(body.step()).isEqualTo(ComposeCreateParams.Step.COMPOSE)
        assertThat(body.additionalContext()).contains("additionalContext")
        assertThat(body.callToAction()).contains("callToAction")
        assertThat(body.draft()).contains("draft")
        assertThat(body.goal()).contains(ComposeCreateParams.Goal.ENGAGEMENT)
        assertThat(body.hasLink()).contains(true)
        assertThat(body.hasMedia()).contains(true)
        assertThat(body.mediaType()).contains(ComposeCreateParams.MediaType.PHOTO)
        assertThat(body.styleUsername()).contains("styleUsername")
        assertThat(body.tone()).contains("tone")
        assertThat(body.topic()).contains("topic")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ComposeCreateParams.builder().step(ComposeCreateParams.Step.COMPOSE).build()

        val body = params._body()

        assertThat(body.step()).isEqualTo(ComposeCreateParams.Step.COMPOSE)
    }
}
