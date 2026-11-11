// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.accountconnectionlinks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountConnectionLinkTest {

    private val link =
        AccountConnectionLink.builder()
            .id("xlink_AAAAAAAAAAAAAAAA")
            .accountId("42")
            .completedAt(OffsetDateTime.parse("2026-11-08T12:02:00Z"))
            .createdAt(OffsetDateTime.parse("2026-11-08T12:00:00Z"))
            .expiresAt(OffsetDateTime.parse("2026-11-08T12:30:00Z"))
            .failure(null)
            .health("healthy")
            .purpose(AccountConnectionLink.Purpose.RECONNECT)
            .reference("crm-user-7")
            .returnUrl("https://app.example.com/connected")
            .status(AccountConnectionLink.Status.CONNECTED)
            .xUserId("9876543210")
            .xUsername("elonmusk")
            .build()

    @Test
    fun create() {
        assertThat(link.id()).isEqualTo("xlink_AAAAAAAAAAAAAAAA")
        assertThat(link.accountId()).contains("42")
        assertThat(link.completedAt()).contains(OffsetDateTime.parse("2026-11-08T12:02:00Z"))
        assertThat(link.createdAt()).isEqualTo(OffsetDateTime.parse("2026-11-08T12:00:00Z"))
        assertThat(link.expiresAt()).isEqualTo(OffsetDateTime.parse("2026-11-08T12:30:00Z"))
        assertThat(link.failure()).isEmpty
        assertThat(link.health()).contains("healthy")
        assertThat(link._object_()).isEqualTo(JsonValue.from("x_account_connection_link"))
        assertThat(link.purpose()).isEqualTo(AccountConnectionLink.Purpose.RECONNECT)
        assertThat(link.reference()).contains("crm-user-7")
        assertThat(link.returnUrl()).contains("https://app.example.com/connected")
        assertThat(link.status()).isEqualTo(AccountConnectionLink.Status.CONNECTED)
        assertThat(link.xUserId()).contains("9876543210")
        assertThat(link.xUsername()).contains("elonmusk")
        assertThat(link.url()).isEmpty
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()

        val roundtripped =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(link),
                jacksonTypeRef<AccountConnectionLink>(),
            )

        assertThat(roundtripped).isEqualTo(link)
        assertThat(roundtripped.validate()).isSameAs(roundtripped)
    }

    @Test
    fun readsEveryPurposeAndStatus() {
        val purposes = listOf("connect", "reconnect")
        val statuses =
            listOf(
                "pending",
                "connecting",
                "requires_email_code",
                "connected",
                "failed",
                "expired",
                "revoked",
            )

        assertThat(purposes.map { AccountConnectionLink.Purpose.of(it).known().name.lowercase() })
            .isEqualTo(purposes)
        assertThat(statuses.map { AccountConnectionLink.Status.of(it).known().name.lowercase() })
            .isEqualTo(statuses)
        assertThat(AccountConnectionLink.Purpose.Known.entries).hasSize(purposes.size)
        assertThat(AccountConnectionLink.Status.Known.entries).hasSize(statuses.size)
    }
}
