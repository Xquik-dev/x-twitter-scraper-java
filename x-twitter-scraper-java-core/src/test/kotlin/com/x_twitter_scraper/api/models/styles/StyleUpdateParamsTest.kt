// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.styles

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StyleUpdateParamsTest {

    @Test
    fun create() {
        StyleUpdateParams.builder()
            .id("id")
            .label("Professional Voice")
            .addTweet(
                StyleUpdateParams.Tweet.builder()
                    .text("Excited to share our latest research findings.")
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            StyleUpdateParams.builder()
                .id("id")
                .label("Professional Voice")
                .addTweet(
                    StyleUpdateParams.Tweet.builder()
                        .text("Excited to share our latest research findings.")
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            StyleUpdateParams.builder()
                .id("id")
                .label("Professional Voice")
                .addTweet(
                    StyleUpdateParams.Tweet.builder()
                        .text("Excited to share our latest research findings.")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.label()).isEqualTo("Professional Voice")
        assertThat(body.tweets())
            .containsExactly(
                StyleUpdateParams.Tweet.builder()
                    .text("Excited to share our latest research findings.")
                    .build()
            )
    }
}
