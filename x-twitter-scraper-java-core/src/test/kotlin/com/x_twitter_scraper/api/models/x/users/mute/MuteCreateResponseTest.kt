// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users.mute

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MuteCreateResponseTest {

    @Test
    fun create() {
        val muteCreateResponse =
            MuteCreateResponse.builder()
                .id("12345")
                .account(MuteCreateResponse.Account.builder().id("42").username("example").build())
                .action(MuteCreateResponse.Action.MUTE)
                .billing(
                    MuteCreateResponse.Billing.builder()
                        .charged(true)
                        .chargedCredits("10")
                        .plannedCredits("10")
                        .status(MuteCreateResponse.Billing.Status.CHARGED)
                        .build()
                )
                .charged(true)
                .chargedCredits("10")
                .nextAction(
                    MuteCreateResponse.NextAction.builder()
                        .type(MuteCreateResponse.NextAction.Type.POLL)
                        .afterMs(2000L)
                        .requiresNewIdempotencyKey(true)
                        .url("/api/v1/x/write-actions/12345")
                        .build()
                )
                .pollAfterMs(null)
                .request(
                    MuteCreateResponse.Request.builder()
                        .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                        .payload(
                            MuteCreateResponse.Request.Payload.builder()
                                .putAdditionalProperty("user_id", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .result(
                    MuteCreateResponse.Result.builder()
                        .id("9876543210")
                        .state("muted")
                        .type(MuteCreateResponse.Result.Type.STATE_CHANGE)
                        .build()
                )
                .retryable(false)
                .safeToRetry(false)
                .sendDispatched(true)
                .status(MuteCreateResponse.Status.SUCCESS)
                .statusUrl("/api/v1/x/write-actions/12345")
                .success(true)
                .target(
                    MuteCreateResponse.Target.builder()
                        .id("9876543210")
                        .type(MuteCreateResponse.Target.Type.TWEET)
                        .build()
                )
                .targetId("9876543210")
                .terminal(true)
                .writeActionId("12345")
                .communityId("3456789012")
                .communityName("Builders")
                .completedAt(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
                .confirmationAttempts(1L)
                .confirmationCheckedAt(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
                .confirmedAt(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
                .createdAt(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
                .details(
                    MuteCreateResponse.Details.builder()
                        .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                        .build()
                )
                .error("x_write_ambiguous")
                .expiresAt(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
                .idempotent(false)
                .media(
                    MuteCreateResponse.Media.builder()
                        .putAdditionalProperty("count", JsonValue.from("bar"))
                        .putAdditionalProperty("kind", JsonValue.from("bar"))
                        .build()
                )
                .mediaId("2345678901")
                .mediaUrl("https://media.xquik.com/example.jpg")
                .message("Invalid input. Check request fields.")
                .messageId("1234567890")
                .requestHash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                .requestId("01JZ8R7QSC9QKT0V7JX4M2A6B8")
                .resultId("9876543210")
                .sendDispatchedAt(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
                .tweetId("9876543210")
                .updatedAt(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
                .build()

        assertThat(muteCreateResponse.id()).isEqualTo("12345")
        assertThat(muteCreateResponse.account())
            .contains(MuteCreateResponse.Account.builder().id("42").username("example").build())
        assertThat(muteCreateResponse.action()).isEqualTo(MuteCreateResponse.Action.MUTE)
        assertThat(muteCreateResponse.billing())
            .isEqualTo(
                MuteCreateResponse.Billing.builder()
                    .charged(true)
                    .chargedCredits("10")
                    .plannedCredits("10")
                    .status(MuteCreateResponse.Billing.Status.CHARGED)
                    .build()
            )
        assertThat(muteCreateResponse.charged()).isEqualTo(true)
        assertThat(muteCreateResponse.chargedCredits()).isEqualTo("10")
        assertThat(muteCreateResponse.nextAction())
            .contains(
                MuteCreateResponse.NextAction.builder()
                    .type(MuteCreateResponse.NextAction.Type.POLL)
                    .afterMs(2000L)
                    .requiresNewIdempotencyKey(true)
                    .url("/api/v1/x/write-actions/12345")
                    .build()
            )
        assertThat(muteCreateResponse.pollAfterMs()).isEmpty
        assertThat(muteCreateResponse.request())
            .isEqualTo(
                MuteCreateResponse.Request.builder()
                    .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                    .payload(
                        MuteCreateResponse.Request.Payload.builder()
                            .putAdditionalProperty("user_id", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )
        assertThat(muteCreateResponse.result())
            .contains(
                MuteCreateResponse.Result.builder()
                    .id("9876543210")
                    .state("muted")
                    .type(MuteCreateResponse.Result.Type.STATE_CHANGE)
                    .build()
            )
        assertThat(muteCreateResponse.retryable()).isEqualTo(false)
        assertThat(muteCreateResponse.safeToRetry()).isEqualTo(false)
        assertThat(muteCreateResponse.sendDispatched()).isEqualTo(true)
        assertThat(muteCreateResponse.status()).isEqualTo(MuteCreateResponse.Status.SUCCESS)
        assertThat(muteCreateResponse.statusUrl()).isEqualTo("/api/v1/x/write-actions/12345")
        assertThat(muteCreateResponse.success()).isEqualTo(true)
        assertThat(muteCreateResponse.target())
            .contains(
                MuteCreateResponse.Target.builder()
                    .id("9876543210")
                    .type(MuteCreateResponse.Target.Type.TWEET)
                    .build()
            )
        assertThat(muteCreateResponse.targetId()).contains("9876543210")
        assertThat(muteCreateResponse.terminal()).isEqualTo(true)
        assertThat(muteCreateResponse.writeActionId()).isEqualTo("12345")
        assertThat(muteCreateResponse.communityId()).contains("3456789012")
        assertThat(muteCreateResponse.communityName()).contains("Builders")
        assertThat(muteCreateResponse.completedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(muteCreateResponse.confirmationAttempts()).contains(1L)
        assertThat(muteCreateResponse.confirmationCheckedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(muteCreateResponse.confirmedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(muteCreateResponse.createdAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
        assertThat(muteCreateResponse.details())
            .contains(
                MuteCreateResponse.Details.builder()
                    .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                    .build()
            )
        assertThat(muteCreateResponse.error()).contains("x_write_ambiguous")
        assertThat(muteCreateResponse.expiresAt())
            .contains(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
        assertThat(muteCreateResponse.idempotent()).contains(false)
        assertThat(muteCreateResponse.media())
            .contains(
                MuteCreateResponse.Media.builder()
                    .putAdditionalProperty("count", JsonValue.from("bar"))
                    .putAdditionalProperty("kind", JsonValue.from("bar"))
                    .build()
            )
        assertThat(muteCreateResponse.mediaId()).contains("2345678901")
        assertThat(muteCreateResponse.mediaUrl()).contains("https://media.xquik.com/example.jpg")
        assertThat(muteCreateResponse.message()).contains("Invalid input. Check request fields.")
        assertThat(muteCreateResponse.messageId()).contains("1234567890")
        assertThat(muteCreateResponse.requestHash())
            .contains("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
        assertThat(muteCreateResponse.requestId()).contains("01JZ8R7QSC9QKT0V7JX4M2A6B8")
        assertThat(muteCreateResponse.resultId()).contains("9876543210")
        assertThat(muteCreateResponse.sendDispatchedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
        assertThat(muteCreateResponse.tweetId()).contains("9876543210")
        assertThat(muteCreateResponse.updatedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val muteCreateResponse =
            MuteCreateResponse.builder()
                .id("12345")
                .account(MuteCreateResponse.Account.builder().id("42").username("example").build())
                .action(MuteCreateResponse.Action.MUTE)
                .billing(
                    MuteCreateResponse.Billing.builder()
                        .charged(true)
                        .chargedCredits("10")
                        .plannedCredits("10")
                        .status(MuteCreateResponse.Billing.Status.CHARGED)
                        .build()
                )
                .charged(true)
                .chargedCredits("10")
                .nextAction(
                    MuteCreateResponse.NextAction.builder()
                        .type(MuteCreateResponse.NextAction.Type.POLL)
                        .afterMs(2000L)
                        .requiresNewIdempotencyKey(true)
                        .url("/api/v1/x/write-actions/12345")
                        .build()
                )
                .pollAfterMs(null)
                .request(
                    MuteCreateResponse.Request.builder()
                        .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                        .payload(
                            MuteCreateResponse.Request.Payload.builder()
                                .putAdditionalProperty("user_id", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .result(
                    MuteCreateResponse.Result.builder()
                        .id("9876543210")
                        .state("muted")
                        .type(MuteCreateResponse.Result.Type.STATE_CHANGE)
                        .build()
                )
                .retryable(false)
                .safeToRetry(false)
                .sendDispatched(true)
                .status(MuteCreateResponse.Status.SUCCESS)
                .statusUrl("/api/v1/x/write-actions/12345")
                .success(true)
                .target(
                    MuteCreateResponse.Target.builder()
                        .id("9876543210")
                        .type(MuteCreateResponse.Target.Type.TWEET)
                        .build()
                )
                .targetId("9876543210")
                .terminal(true)
                .writeActionId("12345")
                .communityId("3456789012")
                .communityName("Builders")
                .completedAt(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
                .confirmationAttempts(1L)
                .confirmationCheckedAt(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
                .confirmedAt(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
                .createdAt(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
                .details(
                    MuteCreateResponse.Details.builder()
                        .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                        .build()
                )
                .error("x_write_ambiguous")
                .expiresAt(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
                .idempotent(false)
                .media(
                    MuteCreateResponse.Media.builder()
                        .putAdditionalProperty("count", JsonValue.from("bar"))
                        .putAdditionalProperty("kind", JsonValue.from("bar"))
                        .build()
                )
                .mediaId("2345678901")
                .mediaUrl("https://media.xquik.com/example.jpg")
                .message("Invalid input. Check request fields.")
                .messageId("1234567890")
                .requestHash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                .requestId("01JZ8R7QSC9QKT0V7JX4M2A6B8")
                .resultId("9876543210")
                .sendDispatchedAt(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
                .tweetId("9876543210")
                .updatedAt(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
                .build()

        val roundtrippedLikeCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(muteCreateResponse),
                jacksonTypeRef<MuteCreateResponse>(),
            )

        assertThat(roundtrippedLikeCreateResponse).isEqualTo(muteCreateResponse)
    }

    @Test
    fun additionalActionValues() {
        assertThat(MuteCreateResponse.Action.of("delete_dm").known())
            .isEqualTo(MuteCreateResponse.Action.Known.DELETE_DM)
    }

    @Test
    fun bookmarkBlockAndMuteActionValues() {
        mapOf(
                "bookmark" to MuteCreateResponse.Action.Known.BOOKMARK,
                "unbookmark" to MuteCreateResponse.Action.Known.UNBOOKMARK,
                "block" to MuteCreateResponse.Action.Known.BLOCK,
                "unblock" to MuteCreateResponse.Action.Known.UNBLOCK,
                "mute" to MuteCreateResponse.Action.Known.MUTE,
                "unmute" to MuteCreateResponse.Action.Known.UNMUTE,
            )
            .forEach { (wire, known) ->
                assertThat(MuteCreateResponse.Action.of(wire).known()).isEqualTo(known)
                assertThat(MuteCreateResponse.Action.of(wire).value().name).isEqualTo(known.name)
            }
    }
}
