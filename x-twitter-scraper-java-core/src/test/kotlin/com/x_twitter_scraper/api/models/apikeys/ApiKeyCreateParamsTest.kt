// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.apikeys

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiKeyCreateParamsTest {

    @Test
    fun create() {
        ApiKeyCreateParams.builder().name("My API Key").build()
    }

    @Test
    fun body() {
        val params = ApiKeyCreateParams.builder().name("My API Key").build()

        val body = params._body()

        assertThat(body.name()).contains("My API Key")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ApiKeyCreateParams.builder().build()

        val body = params._body()
    }
}
