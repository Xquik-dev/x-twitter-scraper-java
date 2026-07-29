// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accountconnectionattempts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountConnectionAttemptRetrieveParamsTest {

    @Test
    fun create() {
        AccountConnectionAttemptRetrieveParams.builder()
            .id("xatt_0123456789abcdef0123456789abcdef")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            AccountConnectionAttemptRetrieveParams.builder()
                .id("xatt_0123456789abcdef0123456789abcdef")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("xatt_0123456789abcdef0123456789abcdef")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
