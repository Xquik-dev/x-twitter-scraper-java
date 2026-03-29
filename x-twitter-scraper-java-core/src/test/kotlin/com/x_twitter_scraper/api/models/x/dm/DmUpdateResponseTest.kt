// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.dm

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DmUpdateResponseTest {

    @Test
    fun create() {
        val dmUpdateResponse = DmUpdateResponse.builder().messageId("messageId").build()

        assertThat(dmUpdateResponse.messageId()).isEqualTo("messageId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val dmUpdateResponse = DmUpdateResponse.builder().messageId("messageId").build()

        val roundtrippedDmUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(dmUpdateResponse),
                jacksonTypeRef<DmUpdateResponse>(),
            )

        assertThat(roundtrippedDmUpdateResponse).isEqualTo(dmUpdateResponse)
    }
}
