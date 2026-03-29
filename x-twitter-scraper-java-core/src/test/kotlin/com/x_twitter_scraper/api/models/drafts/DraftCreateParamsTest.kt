// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.drafts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DraftCreateParamsTest {

    @Test
    fun create() {
        DraftCreateParams.builder()
            .text("text")
            .goal(DraftCreateParams.Goal.ENGAGEMENT)
            .topic("topic")
            .build()
    }

    @Test
    fun body() {
        val params =
            DraftCreateParams.builder()
                .text("text")
                .goal(DraftCreateParams.Goal.ENGAGEMENT)
                .topic("topic")
                .build()

        val body = params._body()

        assertThat(body.text()).isEqualTo("text")
        assertThat(body.goal()).contains(DraftCreateParams.Goal.ENGAGEMENT)
        assertThat(body.topic()).contains("topic")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = DraftCreateParams.builder().text("text").build()

        val body = params._body()

        assertThat(body.text()).isEqualTo("text")
    }
}
