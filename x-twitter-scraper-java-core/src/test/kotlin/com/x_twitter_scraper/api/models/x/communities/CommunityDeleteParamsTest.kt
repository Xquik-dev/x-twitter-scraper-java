// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.communities

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CommunityDeleteParamsTest {

    @Test
    fun create() {
        CommunityDeleteParams.builder()
            .id("id")
            .account("@elonmusk")
            .communityName("Tesla Fans")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            CommunityDeleteParams.builder()
                .id("id")
                .account("@elonmusk")
                .communityName("Tesla Fans")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            CommunityDeleteParams.builder()
                .id("id")
                .account("@elonmusk")
                .communityName("Tesla Fans")
                .build()

        val body = params._body()

        assertThat(body.account()).isEqualTo("@elonmusk")
        assertThat(body.communityName()).isEqualTo("Tesla Fans")
    }
}
