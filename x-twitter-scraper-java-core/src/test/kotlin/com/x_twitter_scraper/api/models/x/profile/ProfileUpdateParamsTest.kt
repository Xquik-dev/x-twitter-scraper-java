// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.profile

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileUpdateParamsTest {

    @Test
    fun create() {
        ProfileUpdateParams.builder()
            .account("account")
            .description("description")
            .location("location")
            .name("name")
            .url("url")
            .build()
    }

    @Test
    fun body() {
        val params =
            ProfileUpdateParams.builder()
                .account("account")
                .description("description")
                .location("location")
                .name("name")
                .url("url")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("account")
        assertThat(body.description()).contains("description")
        assertThat(body.location()).contains("location")
        assertThat(body.name()).contains("name")
        assertThat(body.url()).contains("url")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ProfileUpdateParams.builder().account("account").build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("account")
    }
}
