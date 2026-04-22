// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XAccountDetailTest {

    @Test
    fun create() {
        val xAccountDetail =
            XAccountDetail.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .health(XAccountDetail.Health.HEALTHY)
                .status("active")
                .xUserId("9876543210")
                .xUsername("elonmusk")
                .cookiesObtainedAt(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
                .proxyCountry("US")
                .updatedAt(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
                .build()

        assertThat(xAccountDetail.id()).isEqualTo("42")
        assertThat(xAccountDetail.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
        assertThat(xAccountDetail.health()).isEqualTo(XAccountDetail.Health.HEALTHY)
        assertThat(xAccountDetail.status()).isEqualTo("active")
        assertThat(xAccountDetail.xUserId()).isEqualTo("9876543210")
        assertThat(xAccountDetail.xUsername()).isEqualTo("elonmusk")
        assertThat(xAccountDetail.cookiesObtainedAt())
            .contains(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
        assertThat(xAccountDetail.proxyCountry()).contains("US")
        assertThat(xAccountDetail.updatedAt())
            .contains(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xAccountDetail =
            XAccountDetail.builder()
                .id("42")
                .createdAt(OffsetDateTime.parse("2025-01-15T12:00:00Z"))
                .health(XAccountDetail.Health.HEALTHY)
                .status("active")
                .xUserId("9876543210")
                .xUsername("elonmusk")
                .cookiesObtainedAt(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
                .proxyCountry("US")
                .updatedAt(OffsetDateTime.parse("2025-03-10T08:30:00Z"))
                .build()

        val roundtrippedXAccountDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(xAccountDetail),
                jacksonTypeRef<XAccountDetail>(),
            )

        assertThat(roundtrippedXAccountDetail).isEqualTo(xAccountDetail)
    }
}
