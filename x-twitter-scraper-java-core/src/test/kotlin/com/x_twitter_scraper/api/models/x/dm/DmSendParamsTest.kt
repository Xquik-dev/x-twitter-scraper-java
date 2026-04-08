// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.dm

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DmSendParamsTest {

    @Test
    fun create() {
        DmSendParams.builder()
            .userId("userId")
            .account("@elonmusk")
            .text("Example text content")
            .addMediaId("1234567890123456789")
            .replyToMessageId("1234567890123456789")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            DmSendParams.builder()
                .userId("userId")
                .account("@elonmusk")
                .text("Example text content")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("userId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            DmSendParams.builder()
                .userId("userId")
                .account("@elonmusk")
                .text("Example text content")
                .addMediaId("1234567890123456789")
                .replyToMessageId("1234567890123456789")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
        assertThat(body.text()).isEqualTo("Example text content")
        assertThat(body.mediaIds().getOrNull()).containsExactly("1234567890123456789")
        assertThat(body.replyToMessageId()).contains("1234567890123456789")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            DmSendParams.builder()
                .userId("userId")
                .account("@elonmusk")
                .text("Example text content")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
        assertThat(body.text()).isEqualTo("Example text content")
    }
}
