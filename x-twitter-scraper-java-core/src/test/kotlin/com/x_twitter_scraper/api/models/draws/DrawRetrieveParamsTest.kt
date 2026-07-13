// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.draws

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DrawRetrieveParamsTest {

    @Test
    fun create() {
        DrawRetrieveParams.builder().id("f4bd00a2-7b4e-4e59-8e1b-72e2c9f12345").build()
    }

    @Test
    fun pathParams() {
        val params = DrawRetrieveParams.builder().id("f4bd00a2-7b4e-4e59-8e1b-72e2c9f12345").build()

        assertThat(params._pathParam(0)).isEqualTo("f4bd00a2-7b4e-4e59-8e1b-72e2c9f12345")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
