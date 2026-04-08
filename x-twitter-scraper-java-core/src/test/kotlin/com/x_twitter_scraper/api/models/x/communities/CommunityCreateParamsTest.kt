// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityCreateParamsTest {

    @Test
    fun create() {
        CommunityCreateParams.builder()
            .account("@elonmusk")
            .name("Example Name")
            .description("A community for Tesla enthusiasts")
            .build()
    }

    @Test
    fun body() {
        val params =
            CommunityCreateParams.builder()
                .account("@elonmusk")
                .name("Example Name")
                .description("A community for Tesla enthusiasts")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
        assertThat(body.name()).isEqualTo("Example Name")
        assertThat(body.description()).contains("A community for Tesla enthusiasts")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            CommunityCreateParams.builder().account("@elonmusk").name("Example Name").build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
        assertThat(body.name()).isEqualTo("Example Name")
    }
}
