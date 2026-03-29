// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.bot.platformlinks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PlatformLinkDeleteParamsTest {

    @Test
    fun create() {
        PlatformLinkDeleteParams.builder()
            .platform(PlatformLinkDeleteParams.Platform.TELEGRAM)
            .platformUserId("platformUserId")
            .build()
    }

    @Test
    fun body() {
        val params =
            PlatformLinkDeleteParams.builder()
                .platform(PlatformLinkDeleteParams.Platform.TELEGRAM)
                .platformUserId("platformUserId")
                .build()

        val body = params._body()

        assertThat(body.platform()).isEqualTo(PlatformLinkDeleteParams.Platform.TELEGRAM)
        assertThat(body.platformUserId()).isEqualTo("platformUserId")
    }
}
