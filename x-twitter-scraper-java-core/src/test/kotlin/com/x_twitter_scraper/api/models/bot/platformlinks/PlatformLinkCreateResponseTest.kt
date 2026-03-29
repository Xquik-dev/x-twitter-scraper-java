// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.bot.platformlinks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PlatformLinkCreateResponseTest {

    @Test
    fun create() {
        val platformLinkCreateResponse =
            PlatformLinkCreateResponse.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .platform("platform")
                .platformUserId("platformUserId")
                .build()

        assertThat(platformLinkCreateResponse.id()).isEqualTo("id")
        assertThat(platformLinkCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(platformLinkCreateResponse.platform()).isEqualTo("platform")
        assertThat(platformLinkCreateResponse.platformUserId()).isEqualTo("platformUserId")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val platformLinkCreateResponse =
            PlatformLinkCreateResponse.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .platform("platform")
                .platformUserId("platformUserId")
                .build()

        val roundtrippedPlatformLinkCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(platformLinkCreateResponse),
                jacksonTypeRef<PlatformLinkCreateResponse>(),
            )

        assertThat(roundtrippedPlatformLinkCreateResponse).isEqualTo(platformLinkCreateResponse)
    }
}
