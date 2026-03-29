// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.apikeys

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyCreateParamsTest {

    @Test
    fun create() {
        ApiKeyCreateParams.builder().name("name").build()
    }

    @Test
    fun body() {
        val params = ApiKeyCreateParams.builder().name("name").build()

        val body = params._body()

        assertThat(body.name()).contains("name")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ApiKeyCreateParams.builder().build()

        val body = params._body()
    }
}
