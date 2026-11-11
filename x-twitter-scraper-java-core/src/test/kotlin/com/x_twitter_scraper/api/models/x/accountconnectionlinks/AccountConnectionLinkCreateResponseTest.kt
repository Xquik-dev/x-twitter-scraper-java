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

internal class AccountConnectionLinkCreateResponseTest {

    private val response =
        AccountConnectionLinkCreateResponse.builder()
            .id("xlink_AAAAAAAAAAAAAAAA")
            .accountId(null)
            .completedAt(null)
            .createdAt(OffsetDateTime.parse("2026-11-08T12:00:00Z"))
            .expiresAt(OffsetDateTime.parse("2026-11-08T12:30:00Z"))
            .failure(null)
            .health(null)
            .purpose(AccountConnectionLink.Purpose.CONNECT)
            .reference("crm-user-7")
            .returnUrl("https://app.example.com/connected")
            .status(AccountConnectionLink.Status.PENDING)
            .xUserId(null)
            .xUsername(null)
            .url("https://xquik.com/connect-x#token=CONNECT_LINK_TOKEN")
            .build()

    @Test
    fun create() {
        assertThat(response.id()).isEqualTo("xlink_AAAAAAAAAAAAAAAA")
        assertThat(response.accountId()).isEmpty
        assertThat(response.completedAt()).isEmpty
        assertThat(response.createdAt()).isEqualTo(OffsetDateTime.parse("2026-11-08T12:00:00Z"))
        assertThat(response.expiresAt()).isEqualTo(OffsetDateTime.parse("2026-11-08T12:30:00Z"))
        assertThat(response.failure()).isEmpty
        assertThat(response.health()).isEmpty
        assertThat(response._object_()).isEqualTo(JsonValue.from("x_account_connection_link"))
        assertThat(response.purpose()).isEqualTo(AccountConnectionLink.Purpose.CONNECT)
        assertThat(response.reference()).contains("crm-user-7")
        assertThat(response.returnUrl()).contains("https://app.example.com/connected")
        assertThat(response.status()).isEqualTo(AccountConnectionLink.Status.PENDING)
        assertThat(response.xUserId()).isEmpty
        assertThat(response.xUsername()).isEmpty
        assertThat(response.url()).isEqualTo("https://xquik.com/connect-x#token=CONNECT_LINK_TOKEN")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()

        val roundtripped =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(response),
                jacksonTypeRef<AccountConnectionLinkCreateResponse>(),
            )

        assertThat(roundtripped).isEqualTo(response)
        assertThat(roundtripped.validate()).isSameAs(roundtripped)
    }
}
