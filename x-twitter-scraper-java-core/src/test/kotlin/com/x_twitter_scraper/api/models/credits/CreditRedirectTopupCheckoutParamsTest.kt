// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.credits

import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreditRedirectTopupCheckoutParamsTest {

    @Test
    fun create() {
        CreditRedirectTopupCheckoutParams.builder().sessionId("session_id").build()
    }

    @Test
    fun queryParams() {
        val params = CreditRedirectTopupCheckoutParams.builder().sessionId("session_id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("session_id", "session_id").build())
    }
}
