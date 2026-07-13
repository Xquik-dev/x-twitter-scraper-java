// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.writeactions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WriteActionRetrieveResponseTest {

    @Test
    fun create() {
        val writeActionRetrieveResponse =
            WriteActionRetrieveResponse.builder()
                .action("create_tweet")
                .charged(false)
                .chargedCredits("32")
                .createdAt(OffsetDateTime.parse("2026-05-08T20:00:00.000Z"))
                .media(
                    WriteActionRetrieveResponse.Media.builder()
                        .count(1L)
                        .credits("2")
                        .kind(WriteActionRetrieveResponse.Media.Kind.VIDEO)
                        .totalBytes("834921")
                        .build()
                )
                .sendDispatched(true)
                .status(WriteActionRetrieveResponse.Status.PENDING_CONFIRMATION)
                .writeActionId("42")
                .confirmationAttempts(2L)
                .confirmationCheckedAt(OffsetDateTime.parse("2026-05-08T20:00:05.000Z"))
                .confirmationSource("read_confirmation")
                .confirmedAt(OffsetDateTime.parse("2026-05-08T20:00:06.000Z"))
                .message("Confirmation is still pending.")
                .messageId("1234567890")
                .sendDispatchedAt(OffsetDateTime.parse("2026-05-08T20:00:01.000Z"))
                .targetId("1234567890")
                .tweetId("1234567890")
                .build()

        assertThat(writeActionRetrieveResponse.action()).isEqualTo("create_tweet")
        assertThat(writeActionRetrieveResponse.charged()).isEqualTo(false)
        assertThat(writeActionRetrieveResponse.chargedCredits()).isEqualTo("32")
        assertThat(writeActionRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2026-05-08T20:00:00.000Z"))
        assertThat(writeActionRetrieveResponse.media())
            .isEqualTo(
                WriteActionRetrieveResponse.Media.builder()
                    .count(1L)
                    .credits("2")
                    .kind(WriteActionRetrieveResponse.Media.Kind.VIDEO)
                    .totalBytes("834921")
                    .build()
            )
        assertThat(writeActionRetrieveResponse.sendDispatched()).isEqualTo(true)
        assertThat(writeActionRetrieveResponse.status())
            .isEqualTo(WriteActionRetrieveResponse.Status.PENDING_CONFIRMATION)
        assertThat(writeActionRetrieveResponse.writeActionId()).isEqualTo("42")
        assertThat(writeActionRetrieveResponse.confirmationAttempts()).contains(2L)
        assertThat(writeActionRetrieveResponse.confirmationCheckedAt())
            .contains(OffsetDateTime.parse("2026-05-08T20:00:05.000Z"))
        assertThat(writeActionRetrieveResponse.confirmationSource()).contains("read_confirmation")
        assertThat(writeActionRetrieveResponse.confirmedAt())
            .contains(OffsetDateTime.parse("2026-05-08T20:00:06.000Z"))
        assertThat(writeActionRetrieveResponse.message()).contains("Confirmation is still pending.")
        assertThat(writeActionRetrieveResponse.messageId()).contains("1234567890")
        assertThat(writeActionRetrieveResponse.sendDispatchedAt())
            .contains(OffsetDateTime.parse("2026-05-08T20:00:01.000Z"))
        assertThat(writeActionRetrieveResponse.targetId()).contains("1234567890")
        assertThat(writeActionRetrieveResponse.tweetId()).contains("1234567890")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val writeActionRetrieveResponse =
            WriteActionRetrieveResponse.builder()
                .action("create_tweet")
                .charged(false)
                .chargedCredits("32")
                .createdAt(OffsetDateTime.parse("2026-05-08T20:00:00.000Z"))
                .media(
                    WriteActionRetrieveResponse.Media.builder()
                        .count(1L)
                        .credits("2")
                        .kind(WriteActionRetrieveResponse.Media.Kind.VIDEO)
                        .totalBytes("834921")
                        .build()
                )
                .sendDispatched(true)
                .status(WriteActionRetrieveResponse.Status.PENDING_CONFIRMATION)
                .writeActionId("42")
                .confirmationAttempts(2L)
                .confirmationCheckedAt(OffsetDateTime.parse("2026-05-08T20:00:05.000Z"))
                .confirmationSource("read_confirmation")
                .confirmedAt(OffsetDateTime.parse("2026-05-08T20:00:06.000Z"))
                .message("Confirmation is still pending.")
                .messageId("1234567890")
                .sendDispatchedAt(OffsetDateTime.parse("2026-05-08T20:00:01.000Z"))
                .targetId("1234567890")
                .tweetId("1234567890")
                .build()

        val roundtrippedWriteActionRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(writeActionRetrieveResponse),
                jacksonTypeRef<WriteActionRetrieveResponse>(),
            )

        assertThat(roundtrippedWriteActionRetrieveResponse).isEqualTo(writeActionRetrieveResponse)
    }
}
