// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.accountconnectionlinks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class AccountConnectionLinkListResponseTest {

    private val link =
        AccountConnectionLink.builder()
            .id("xlink_AAAAAAAAAAAAAAAA")
            .accountId(null)
            .completedAt(null)
            .createdAt(OffsetDateTime.parse("2026-11-08T12:00:00Z"))
            .expiresAt(OffsetDateTime.parse("2026-11-08T12:30:00Z"))
            .failure(null)
            .health(null)
            .purpose(AccountConnectionLink.Purpose.CONNECT)
            .reference("crm-user-7")
            .returnUrl(null)
            .status(AccountConnectionLink.Status.PENDING)
            .xUserId(null)
            .xUsername(null)
            .build()

    @Test
    fun create() {
        val page =
            AccountConnectionLinkListResponse.builder()
                .addLink(link)
                .hasMore(true)
                .nextCursor("def456")
                .build()

        assertThat(page.links()).containsExactly(link)
        assertThat(page.hasMore()).isTrue()
        assertThat(page.nextCursor()).contains("def456")
        assertThat(page.validate()).isSameAs(page)
        assertThat(page.isValid()).isTrue()
        assertThat(page.toBuilder().links(listOf(link)).build()).isEqualTo(page)
        assertThat(page.toBuilder().build().hashCode()).isEqualTo(page.hashCode())
        assertThat(page.toString()).contains("hasMore=true", "nextCursor=def456")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val page = AccountConnectionLinkListResponse.builder().addLink(link).hasMore(false).build()

        val roundtripped =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(page),
                jacksonTypeRef<AccountConnectionLinkListResponse>(),
            )

        assertThat(roundtripped).isEqualTo(page)
        assertThat(roundtripped.nextCursor()).isEmpty
    }

    @Test
    fun linksAndHasMoreAreRequired() {
        assertThatThrownBy { AccountConnectionLinkListResponse.builder().hasMore(false).build() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("links")
        assertThatThrownBy { AccountConnectionLinkListResponse.builder().links(listOf()).build() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("hasMore")
        assertThat(
                jsonMapper()
                    .readValue(
                        """{"links":[]}""",
                        jacksonTypeRef<AccountConnectionLinkListResponse>(),
                    )
                    .isValid()
            )
            .isFalse()
    }
}
