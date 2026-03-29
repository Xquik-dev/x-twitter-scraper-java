// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.bot.platformlinks

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PlatformLinkLookupParamsTest {

    @Test
    fun create() {
        PlatformLinkLookupParams.builder()
            .platform("platform")
            .platformUserId("platformUserId")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            PlatformLinkLookupParams.builder()
                .platform("platform")
                .platformUserId("platformUserId")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("platform", "platform")
                    .put("platformUserId", "platformUserId")
                    .build()
            )
    }
}
