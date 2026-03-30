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
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status("status")
                .xUserId("xUserId")
                .xUsername("xUsername")
                .cookiesObtainedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .proxyCountry("proxyCountry")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(xAccountDetail.id()).isEqualTo("id")
        assertThat(xAccountDetail.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(xAccountDetail.status()).isEqualTo("status")
        assertThat(xAccountDetail.xUserId()).isEqualTo("xUserId")
        assertThat(xAccountDetail.xUsername()).isEqualTo("xUsername")
        assertThat(xAccountDetail.cookiesObtainedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(xAccountDetail.proxyCountry()).contains("proxyCountry")
        assertThat(xAccountDetail.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xAccountDetail =
            XAccountDetail.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status("status")
                .xUserId("xUserId")
                .xUsername("xUsername")
                .cookiesObtainedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .proxyCountry("proxyCountry")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedXAccountDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(xAccountDetail),
                jacksonTypeRef<XAccountDetail>(),
            )

        assertThat(roundtrippedXAccountDetail).isEqualTo(xAccountDetail)
    }
}
