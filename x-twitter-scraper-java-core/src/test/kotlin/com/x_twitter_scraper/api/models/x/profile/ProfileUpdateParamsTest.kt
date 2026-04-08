// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.profile

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileUpdateParamsTest {

    @Test
    fun create() {
        ProfileUpdateParams.builder()
            .account("@elonmusk")
            .description("description_value")
            .location("location_value")
            .name("Example Name")
            .url("https://xquik.com/example")
            .build()
    }

    @Test
    fun body() {
        val params =
            ProfileUpdateParams.builder()
                .account("@elonmusk")
                .description("description_value")
                .location("location_value")
                .name("Example Name")
                .url("https://xquik.com/example")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
        assertThat(body.description()).contains("description_value")
        assertThat(body.location()).contains("location_value")
        assertThat(body.name()).contains("Example Name")
        assertThat(body.url()).contains("https://xquik.com/example")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ProfileUpdateParams.builder().account("@elonmusk").build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
    }
}
