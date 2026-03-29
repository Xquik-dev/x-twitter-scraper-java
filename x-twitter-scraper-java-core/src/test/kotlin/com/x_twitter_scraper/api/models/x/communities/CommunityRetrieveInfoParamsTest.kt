// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityRetrieveInfoParamsTest {

    @Test
    fun create() {
        CommunityRetrieveInfoParams.builder().id("id").build()
    }

    @Test
    fun pathParams() {
        val params = CommunityRetrieveInfoParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
