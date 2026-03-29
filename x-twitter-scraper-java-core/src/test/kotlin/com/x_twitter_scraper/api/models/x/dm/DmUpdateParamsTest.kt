// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.dm

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DmUpdateParamsTest {

    @Test
    fun create() {
        DmUpdateParams.builder()
            .userId("userId")
            .account("account")
            .text("text")
            .addMediaId("string")
            .replyToMessageId("reply_to_message_id")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            DmUpdateParams.builder().userId("userId").account("account").text("text").build()

        assertThat(params._pathParam(0)).isEqualTo("userId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            DmUpdateParams.builder()
                .userId("userId")
                .account("account")
                .text("text")
                .addMediaId("string")
                .replyToMessageId("reply_to_message_id")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("account")
        assertThat(body.text()).isEqualTo("text")
        assertThat(body.mediaIds().getOrNull()).containsExactly("string")
        assertThat(body.replyToMessageId()).contains("reply_to_message_id")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            DmUpdateParams.builder().userId("userId").account("account").text("text").build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("account")
        assertThat(body.text()).isEqualTo("text")
    }
}
