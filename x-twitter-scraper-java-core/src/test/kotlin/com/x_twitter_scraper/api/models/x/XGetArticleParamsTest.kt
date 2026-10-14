// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetArticleParamsTest {

    @Test
    fun create() {
        XGetArticleParams.builder().tweetId("tweetId").build()
    }

    @Test
    fun pathParams() {
        val params = XGetArticleParams.builder().tweetId("tweetId").build()

        assertThat(params._pathParam(0)).isEqualTo("tweetId")
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
