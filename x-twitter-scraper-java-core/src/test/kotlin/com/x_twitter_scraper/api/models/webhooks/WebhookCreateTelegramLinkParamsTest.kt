// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.webhooks

import com.x_twitter_scraper.api.models.EventType
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookCreateTelegramLinkParamsTest {

    @Test
    fun create() {
        WebhookCreateTelegramLinkParams.builder().addEventType(EventType.TWEET_NEW).build()
    }

    @Test
    fun body() {
        val params =
            WebhookCreateTelegramLinkParams.builder().addEventType(EventType.TWEET_NEW).build()

        val body = params._body()

        assertThat(body.eventTypes().getOrNull()).containsExactly(EventType.TWEET_NEW)
    }
}
