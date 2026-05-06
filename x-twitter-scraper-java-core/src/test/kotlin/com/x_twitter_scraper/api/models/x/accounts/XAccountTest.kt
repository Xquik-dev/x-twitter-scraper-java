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
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .health(XAccount.Health.HEALTHY)
                .status("active")
                .xUserId("9876543210")
                .xUsername("elonmusk")
                .build()

        assertThat(xAccount.id()).isEqualTo("42")
        assertThat(xAccount.createdAt()).isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(xAccount.health()).isEqualTo(XAccount.Health.HEALTHY)
        assertThat(xAccount.status()).isEqualTo("active")
        assertThat(xAccount.xUserId()).isEqualTo("9876543210")
        assertThat(xAccount.xUsername()).isEqualTo("elonmusk")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xAccount =
            XAccount.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .health(XAccount.Health.HEALTHY)
                .status("active")
                .xUserId("9876543210")
                .xUsername("elonmusk")
                .build()

        val roundtrippedXAccount =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(xAccount),
                jacksonTypeRef<XAccount>(),
            )

        assertThat(roundtrippedXAccount).isEqualTo(xAccount)
    }
}
