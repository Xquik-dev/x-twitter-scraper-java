// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.styles

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StyleAnalyzeParamsTest {

    @Test
    fun create() {
        StyleAnalyzeParams.builder().username("username").build()
    }

    @Test
    fun body() {
        val params = StyleAnalyzeParams.builder().username("username").build()

        val body = params._body()

        assertThat(body.username()).isEqualTo("username")
    }
}
