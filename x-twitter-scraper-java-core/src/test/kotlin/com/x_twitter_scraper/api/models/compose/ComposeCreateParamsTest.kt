// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.compose

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComposeCreateParamsTest {

    @Test
    fun create() {
        ComposeCreateParams.builder()
            .body(
                ComposeCreateParams.Body.ComposePrepareRequest.builder()
                    .topic("PostgreSQL query planning")
                    .goal(ComposeCreateParams.Body.ComposePrepareRequest.Goal.ENGAGEMENT)
                    .styleUsername("x")
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            ComposeCreateParams.builder()
                .body(
                    ComposeCreateParams.Body.ComposePrepareRequest.builder()
                        .topic("PostgreSQL query planning")
                        .goal(ComposeCreateParams.Body.ComposePrepareRequest.Goal.ENGAGEMENT)
                        .styleUsername("x")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                ComposeCreateParams.Body.ofComposePrepareRequest(
                    ComposeCreateParams.Body.ComposePrepareRequest.builder()
                        .topic("PostgreSQL query planning")
                        .goal(ComposeCreateParams.Body.ComposePrepareRequest.Goal.ENGAGEMENT)
                        .styleUsername("x")
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ComposeCreateParams.builder()
                .body(
                    ComposeCreateParams.Body.ComposePrepareRequest.builder()
                        .topic("PostgreSQL query planning")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                ComposeCreateParams.Body.ofComposePrepareRequest(
                    ComposeCreateParams.Body.ComposePrepareRequest.builder()
                        .topic("PostgreSQL query planning")
                        .build()
                )
            )
    }
}
