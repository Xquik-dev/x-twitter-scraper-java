// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.monitors

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MonitorListParamsTest {

    @Test
    fun create() {
        MonitorListParams.builder().build()
    }

    @Test
    fun additionalFields() {
        val params = MonitorListParams.builder().limit(1L).cursor("sample").build()

        assertThat(params.limit()).isPresent()
        assertThat(params._queryParams().values("limit")).containsExactly("1")
        assertThat(params.cursor()).isPresent()
        assertThat(params._queryParams().values("cursor")).containsExactly("sample")
        assertThat(params.toBuilder().build()).isEqualTo(params)
    }
}
