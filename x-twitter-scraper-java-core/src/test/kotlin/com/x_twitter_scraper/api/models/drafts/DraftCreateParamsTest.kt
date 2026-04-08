// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.drafts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DraftCreateParamsTest {

    @Test
    fun create() {
        DraftCreateParams.builder()
            .text("AI is the future of productivity")
            .goal(DraftCreateParams.Goal.ENGAGEMENT)
            .topic("AI trends")
            .build()
    }

    @Test
    fun body() {
        val params =
            DraftCreateParams.builder()
                .text("AI is the future of productivity")
                .goal(DraftCreateParams.Goal.ENGAGEMENT)
                .topic("AI trends")
                .build()

        val body = params._body()

        assertThat(body.text()).isEqualTo("AI is the future of productivity")
        assertThat(body.goal()).contains(DraftCreateParams.Goal.ENGAGEMENT)
        assertThat(body.topic()).contains("AI trends")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = DraftCreateParams.builder().text("AI is the future of productivity").build()

        val body = params._body()

        assertThat(body.text()).isEqualTo("AI is the future of productivity")
    }
}
