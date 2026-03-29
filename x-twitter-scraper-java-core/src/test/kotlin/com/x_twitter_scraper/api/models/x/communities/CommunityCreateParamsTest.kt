// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityCreateParamsTest {

    @Test
    fun create() {
        CommunityCreateParams.builder()
            .account("account")
            .name("name")
            .description("description")
            .build()
    }

    @Test
    fun body() {
        val params =
            CommunityCreateParams.builder()
                .account("account")
                .name("name")
                .description("description")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("account")
        assertThat(body.name()).isEqualTo("name")
        assertThat(body.description()).contains("description")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = CommunityCreateParams.builder().account("account").name("name").build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("account")
        assertThat(body.name()).isEqualTo("name")
    }
}
