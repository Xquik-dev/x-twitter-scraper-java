// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities

import com.x_twitter_scraper.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityCreateParamsTest {

    @Test
    fun create() {
        CommunityCreateParams.builder()
            .idempotencyKey("Idempotency-Key")
            .account("@elonmusk")
            .name("Example Name")
            .description("A community for Tesla enthusiasts")
            .build()
    }

    @Test
    fun headers() {
        val params =
            CommunityCreateParams.builder()
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .name("Example Name")
                .description("A community for Tesla enthusiasts")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "Idempotency-Key").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            CommunityCreateParams.builder()
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .name("Example Name")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "Idempotency-Key").build())
    }

    @Test
    fun body() {
        val params =
            CommunityCreateParams.builder()
                .idempotencyKey("Idempotency-Key")
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
            CommunityCreateParams.builder()
                .idempotencyKey("Idempotency-Key")
                .account("@elonmusk")
                .name("Example Name")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
        assertThat(body.name()).isEqualTo("Example Name")
    }
}
