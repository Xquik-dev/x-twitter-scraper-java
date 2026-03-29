// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.bot.platformlinks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PlatformLinkCreateParamsTest {

    @Test
    fun create() {
        PlatformLinkCreateParams.builder()
            .platform(PlatformLinkCreateParams.Platform.TELEGRAM)
            .platformUserId("platformUserId")
            .build()
    }

    @Test
    fun body() {
        val params =
            PlatformLinkCreateParams.builder()
                .platform(PlatformLinkCreateParams.Platform.TELEGRAM)
                .platformUserId("platformUserId")
                .build()

        val body = params._body()

        assertThat(body.platform()).isEqualTo(PlatformLinkCreateParams.Platform.TELEGRAM)
        assertThat(body.platformUserId()).isEqualTo("platformUserId")
    }
}
