// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors.keywords

import com.x_twitter_scraper.api.models.EventType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class KeywordCreateParamsTest {

    @Test
    fun create() {
        KeywordCreateParams.builder()
            .addEventType(EventType.TWEET_NEW)
            .query("xquik OR \"x api\"")
            .build()
    }

    @Test
    fun body() {
        val params =
            KeywordCreateParams.builder()
                .addEventType(EventType.TWEET_NEW)
                .query("xquik OR \"x api\"")
                .build()

        val body = params._body()

        assertThat(body.eventTypes()).containsExactly(EventType.TWEET_NEW)
        assertThat(body.query()).isEqualTo("xquik OR \"x api\"")
    }
}
