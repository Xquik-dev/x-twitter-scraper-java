// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XAccountTest {

    @Test
    fun create() {
        val xAccount =
            XAccount.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status("status")
                .xUserId("xUserId")
                .xUsername("xUsername")
                .build()

        assertThat(xAccount.id()).isEqualTo("id")
        assertThat(xAccount.createdAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(xAccount.status()).isEqualTo("status")
        assertThat(xAccount.xUserId()).isEqualTo("xUserId")
        assertThat(xAccount.xUsername()).isEqualTo("xUsername")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xAccount =
            XAccount.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status("status")
                .xUserId("xUserId")
                .xUsername("xUsername")
                .build()

        val roundtrippedXAccount =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(xAccount),
                jacksonTypeRef<XAccount>(),
            )

        assertThat(roundtrippedXAccount).isEqualTo(xAccount)
    }
}
