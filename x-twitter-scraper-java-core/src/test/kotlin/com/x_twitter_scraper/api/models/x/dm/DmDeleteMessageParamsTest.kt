// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.dm

import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DmDeleteMessageParamsTest {

    @Test
    fun create() {
        DmDeleteMessageParams.builder()
            .userId("userId")
            .messageId("messageId")
            .account("account")
            .idempotencyKey("Idempotency-Key")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            DmDeleteMessageParams.builder()
                .userId("userId")
                .messageId("messageId")
                .account("account")
                .idempotencyKey("Idempotency-Key")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("userId")
        assertThat(params._pathParam(1)).isEqualTo("messageId")
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            DmDeleteMessageParams.builder()
                .userId("userId")
                .messageId("messageId")
                .account("account")
                .idempotencyKey("Idempotency-Key")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "Idempotency-Key").build())
    }

    @Test
    fun queryParams() {
        val params =
            DmDeleteMessageParams.builder()
                .userId("userId")
                .messageId("messageId")
                .account("account")
                .idempotencyKey("Idempotency-Key")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("account", "account").build())
    }
}
