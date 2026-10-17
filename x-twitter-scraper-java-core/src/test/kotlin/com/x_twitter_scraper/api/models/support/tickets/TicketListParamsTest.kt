// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.support.tickets

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TicketListParamsTest {

    @Test
    fun create() {
        TicketListParams.builder().build()
    }

    @Test
    fun additionalFields() {
        val params = TicketListParams.builder().limit(1L).cursor("sample").build()

        assertThat(params.limit()).isPresent()
        assertThat(params._queryParams().values("limit")).containsExactly("1")
        assertThat(params.cursor()).isPresent()
        assertThat(params._queryParams().values("cursor")).containsExactly("sample")
        assertThat(params.toBuilder().build()).isEqualTo(params)
    }
}
