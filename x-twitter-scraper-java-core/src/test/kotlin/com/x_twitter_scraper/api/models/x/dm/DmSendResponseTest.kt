// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.dm

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DmSendResponseTest {

    @Test
    fun create() {
        val dmSendResponse = DmSendResponse.builder().messageId("messageId").build()

        assertThat(dmSendResponse.messageId()).isEqualTo("messageId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val dmSendResponse = DmSendResponse.builder().messageId("messageId").build()

        val roundtrippedDmSendResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(dmSendResponse),
                jacksonTypeRef<DmSendResponse>(),
            )

        assertThat(roundtrippedDmSendResponse).isEqualTo(dmSendResponse)
    }
}
