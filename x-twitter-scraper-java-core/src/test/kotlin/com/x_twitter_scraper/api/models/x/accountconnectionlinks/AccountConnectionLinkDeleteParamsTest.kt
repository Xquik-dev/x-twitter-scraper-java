// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.accountconnectionlinks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountConnectionLinkDeleteParamsTest {

    @Test
    fun create() {
        val params =
            AccountConnectionLinkDeleteParams.builder().id("xlink_AAAAAAAAAAAAAAAA").build()

        assertThat(params.id()).contains("xlink_AAAAAAAAAAAAAAAA")
    }

    @Test
    fun pathParams() {
        val params =
            AccountConnectionLinkDeleteParams.builder().id("xlink_AAAAAAAAAAAAAAAA").build()

        assertThat(params._pathParam(0)).isEqualTo("xlink_AAAAAAAAAAAAAAAA")
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
