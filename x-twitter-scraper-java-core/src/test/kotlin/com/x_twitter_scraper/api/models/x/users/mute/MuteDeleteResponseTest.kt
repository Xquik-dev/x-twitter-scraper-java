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

internal class MuteDeleteResponseTest {

    @Test
    fun create() {
        val muteDeleteResponse =
            MuteDeleteResponse.builder()
                .id("12345")
                .account(MuteDeleteResponse.Account.builder().id("42").username("example").build())
                .action(MuteDeleteResponse.Action.UNMUTE)
                .billing(
                    MuteDeleteResponse.Billing.builder()
                        .charged(true)
                        .chargedCredits("10")
                        .plannedCredits("10")
                        .status(MuteDeleteResponse.Billing.Status.CHARGED)
                        .build()
                )
                .charged(true)
                .chargedCredits("10")
                .nextAction(
                    MuteDeleteResponse.NextAction.builder()
                        .type(MuteDeleteResponse.NextAction.Type.POLL)
                        .afterMs(2000L)
                        .requiresNewIdempotencyKey(true)
                        .url("/api/v1/x/write-actions/12345")
                        .build()
                )
                .pollAfterMs(null)
                .request(
                    MuteDeleteResponse.Request.builder()
                        .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                        .payload(
                            MuteDeleteResponse.Request.Payload.builder()
                                .putAdditionalProperty("user_id", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .result(
                    MuteDeleteResponse.Result.builder()
                        .id("9876543210")
                        .state("unmuted")
                        .type(MuteDeleteResponse.Result.Type.STATE_CHANGE)
                        .build()
                )
                .retryable(false)
                .safeToRetry(false)
                .sendDispatched(true)
                .status(MuteDeleteResponse.Status.SUCCESS)
                .statusUrl("/api/v1/x/write-actions/12345")
                .success(true)
                .target(
                    MuteDeleteResponse.Target.builder()
                        .id("9876543210")
                        .type(MuteDeleteResponse.Target.Type.TWEET)
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
                    MuteDeleteResponse.Details.builder()
                        .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                        .build()
                )
                .error("x_write_ambiguous")
                .expiresAt(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
                .idempotent(false)
                .media(
                    MuteDeleteResponse.Media.builder()
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

        assertThat(muteDeleteResponse.id()).isEqualTo("12345")
        assertThat(muteDeleteResponse.account())
            .contains(MuteDeleteResponse.Account.builder().id("42").username("example").build())
        assertThat(muteDeleteResponse.action()).isEqualTo(MuteDeleteResponse.Action.UNMUTE)
        assertThat(muteDeleteResponse.billing())
            .isEqualTo(
                MuteDeleteResponse.Billing.builder()
                    .charged(true)
                    .chargedCredits("10")
                    .plannedCredits("10")
                    .status(MuteDeleteResponse.Billing.Status.CHARGED)
                    .build()
            )
        assertThat(muteDeleteResponse.charged()).isEqualTo(true)
        assertThat(muteDeleteResponse.chargedCredits()).isEqualTo("10")
        assertThat(muteDeleteResponse.nextAction())
            .contains(
                MuteDeleteResponse.NextAction.builder()
                    .type(MuteDeleteResponse.NextAction.Type.POLL)
                    .afterMs(2000L)
                    .requiresNewIdempotencyKey(true)
                    .url("/api/v1/x/write-actions/12345")
                    .build()
            )
        assertThat(muteDeleteResponse.pollAfterMs()).isEmpty
        assertThat(muteDeleteResponse.request())
            .isEqualTo(
                MuteDeleteResponse.Request.builder()
                    .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                    .payload(
                        MuteDeleteResponse.Request.Payload.builder()
                            .putAdditionalProperty("user_id", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )
        assertThat(muteDeleteResponse.result())
            .contains(
                MuteDeleteResponse.Result.builder()
                    .id("9876543210")
                    .state("unmuted")
                    .type(MuteDeleteResponse.Result.Type.STATE_CHANGE)
                    .build()
            )
        assertThat(muteDeleteResponse.retryable()).isEqualTo(false)
        assertThat(muteDeleteResponse.safeToRetry()).isEqualTo(false)
        assertThat(muteDeleteResponse.sendDispatched()).isEqualTo(true)
        assertThat(muteDeleteResponse.status()).isEqualTo(MuteDeleteResponse.Status.SUCCESS)
        assertThat(muteDeleteResponse.statusUrl()).isEqualTo("/api/v1/x/write-actions/12345")
        assertThat(muteDeleteResponse.success()).isEqualTo(true)
        assertThat(muteDeleteResponse.target())
            .contains(
                MuteDeleteResponse.Target.builder()
                    .id("9876543210")
                    .type(MuteDeleteResponse.Target.Type.TWEET)
                    .build()
            )
        assertThat(muteDeleteResponse.targetId()).contains("9876543210")
        assertThat(muteDeleteResponse.terminal()).isEqualTo(true)
        assertThat(muteDeleteResponse.writeActionId()).isEqualTo("12345")
        assertThat(muteDeleteResponse.communityId()).contains("3456789012")
        assertThat(muteDeleteResponse.communityName()).contains("Builders")
        assertThat(muteDeleteResponse.completedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(muteDeleteResponse.confirmationAttempts()).contains(1L)
        assertThat(muteDeleteResponse.confirmationCheckedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(muteDeleteResponse.confirmedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(muteDeleteResponse.createdAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
        assertThat(muteDeleteResponse.details())
            .contains(
                MuteDeleteResponse.Details.builder()
                    .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                    .build()
            )
        assertThat(muteDeleteResponse.error()).contains("x_write_ambiguous")
        assertThat(muteDeleteResponse.expiresAt())
            .contains(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
        assertThat(muteDeleteResponse.idempotent()).contains(false)
        assertThat(muteDeleteResponse.media())
            .contains(
                MuteDeleteResponse.Media.builder()
                    .putAdditionalProperty("count", JsonValue.from("bar"))
                    .putAdditionalProperty("kind", JsonValue.from("bar"))
                    .build()
            )
        assertThat(muteDeleteResponse.mediaId()).contains("2345678901")
        assertThat(muteDeleteResponse.mediaUrl()).contains("https://media.xquik.com/example.jpg")
        assertThat(muteDeleteResponse.message()).contains("Invalid input. Check request fields.")
        assertThat(muteDeleteResponse.messageId()).contains("1234567890")
        assertThat(muteDeleteResponse.requestHash())
            .contains("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
        assertThat(muteDeleteResponse.requestId()).contains("01JZ8R7QSC9QKT0V7JX4M2A6B8")
        assertThat(muteDeleteResponse.resultId()).contains("9876543210")
        assertThat(muteDeleteResponse.sendDispatchedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
        assertThat(muteDeleteResponse.tweetId()).contains("9876543210")
        assertThat(muteDeleteResponse.updatedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val muteDeleteResponse =
            MuteDeleteResponse.builder()
                .id("12345")
                .account(MuteDeleteResponse.Account.builder().id("42").username("example").build())
                .action(MuteDeleteResponse.Action.UNMUTE)
                .billing(
                    MuteDeleteResponse.Billing.builder()
                        .charged(true)
                        .chargedCredits("10")
                        .plannedCredits("10")
                        .status(MuteDeleteResponse.Billing.Status.CHARGED)
                        .build()
                )
                .charged(true)
                .chargedCredits("10")
                .nextAction(
                    MuteDeleteResponse.NextAction.builder()
                        .type(MuteDeleteResponse.NextAction.Type.POLL)
                        .afterMs(2000L)
                        .requiresNewIdempotencyKey(true)
                        .url("/api/v1/x/write-actions/12345")
                        .build()
                )
                .pollAfterMs(null)
                .request(
                    MuteDeleteResponse.Request.builder()
                        .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                        .payload(
                            MuteDeleteResponse.Request.Payload.builder()
                                .putAdditionalProperty("user_id", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .result(
                    MuteDeleteResponse.Result.builder()
                        .id("9876543210")
                        .state("unmuted")
                        .type(MuteDeleteResponse.Result.Type.STATE_CHANGE)
                        .build()
                )
                .retryable(false)
                .safeToRetry(false)
                .sendDispatched(true)
                .status(MuteDeleteResponse.Status.SUCCESS)
                .statusUrl("/api/v1/x/write-actions/12345")
                .success(true)
                .target(
                    MuteDeleteResponse.Target.builder()
                        .id("9876543210")
                        .type(MuteDeleteResponse.Target.Type.TWEET)
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
                    MuteDeleteResponse.Details.builder()
                        .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                        .build()
                )
                .error("x_write_ambiguous")
                .expiresAt(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
                .idempotent(false)
                .media(
                    MuteDeleteResponse.Media.builder()
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

        val roundtrippedLikeDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(muteDeleteResponse),
                jacksonTypeRef<MuteDeleteResponse>(),
            )

        assertThat(roundtrippedLikeDeleteResponse).isEqualTo(muteDeleteResponse)
    }

    @Test
    fun additionalActionValues() {
        assertThat(MuteDeleteResponse.Action.of("delete_dm").known())
            .isEqualTo(MuteDeleteResponse.Action.Known.DELETE_DM)
    }

    @Test
    fun bookmarkBlockAndMuteActionValues() {
        mapOf(
                "bookmark" to MuteDeleteResponse.Action.Known.BOOKMARK,
                "unbookmark" to MuteDeleteResponse.Action.Known.UNBOOKMARK,
                "block" to MuteDeleteResponse.Action.Known.BLOCK,
                "unblock" to MuteDeleteResponse.Action.Known.UNBLOCK,
                "mute" to MuteDeleteResponse.Action.Known.MUTE,
                "unmute" to MuteDeleteResponse.Action.Known.UNMUTE,
            )
            .forEach { (wire, known) ->
                assertThat(MuteDeleteResponse.Action.of(wire).known()).isEqualTo(known)
                assertThat(MuteDeleteResponse.Action.of(wire).value().name).isEqualTo(known.name)
            }
    }
}
