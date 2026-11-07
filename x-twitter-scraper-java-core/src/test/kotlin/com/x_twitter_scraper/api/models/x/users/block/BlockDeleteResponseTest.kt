// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users.block

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BlockDeleteResponseTest {

    @Test
    fun create() {
        val blockDeleteResponse =
            BlockDeleteResponse.builder()
                .id("12345")
                .account(BlockDeleteResponse.Account.builder().id("42").username("example").build())
                .action(BlockDeleteResponse.Action.UNBLOCK)
                .billing(
                    BlockDeleteResponse.Billing.builder()
                        .charged(true)
                        .chargedCredits("10")
                        .plannedCredits("10")
                        .status(BlockDeleteResponse.Billing.Status.CHARGED)
                        .build()
                )
                .charged(true)
                .chargedCredits("10")
                .nextAction(
                    BlockDeleteResponse.NextAction.builder()
                        .type(BlockDeleteResponse.NextAction.Type.POLL)
                        .afterMs(2000L)
                        .requiresNewIdempotencyKey(true)
                        .url("/api/v1/x/write-actions/12345")
                        .build()
                )
                .pollAfterMs(null)
                .request(
                    BlockDeleteResponse.Request.builder()
                        .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                        .payload(
                            BlockDeleteResponse.Request.Payload.builder()
                                .putAdditionalProperty("user_id", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .result(
                    BlockDeleteResponse.Result.builder()
                        .id("9876543210")
                        .state("unblocked")
                        .type(BlockDeleteResponse.Result.Type.STATE_CHANGE)
                        .build()
                )
                .retryable(false)
                .safeToRetry(false)
                .sendDispatched(true)
                .status(BlockDeleteResponse.Status.SUCCESS)
                .statusUrl("/api/v1/x/write-actions/12345")
                .success(true)
                .target(
                    BlockDeleteResponse.Target.builder()
                        .id("9876543210")
                        .type(BlockDeleteResponse.Target.Type.TWEET)
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
                    BlockDeleteResponse.Details.builder()
                        .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                        .build()
                )
                .error("x_write_ambiguous")
                .expiresAt(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
                .idempotent(false)
                .media(
                    BlockDeleteResponse.Media.builder()
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

        assertThat(blockDeleteResponse.id()).isEqualTo("12345")
        assertThat(blockDeleteResponse.account())
            .contains(BlockDeleteResponse.Account.builder().id("42").username("example").build())
        assertThat(blockDeleteResponse.action()).isEqualTo(BlockDeleteResponse.Action.UNBLOCK)
        assertThat(blockDeleteResponse.billing())
            .isEqualTo(
                BlockDeleteResponse.Billing.builder()
                    .charged(true)
                    .chargedCredits("10")
                    .plannedCredits("10")
                    .status(BlockDeleteResponse.Billing.Status.CHARGED)
                    .build()
            )
        assertThat(blockDeleteResponse.charged()).isEqualTo(true)
        assertThat(blockDeleteResponse.chargedCredits()).isEqualTo("10")
        assertThat(blockDeleteResponse.nextAction())
            .contains(
                BlockDeleteResponse.NextAction.builder()
                    .type(BlockDeleteResponse.NextAction.Type.POLL)
                    .afterMs(2000L)
                    .requiresNewIdempotencyKey(true)
                    .url("/api/v1/x/write-actions/12345")
                    .build()
            )
        assertThat(blockDeleteResponse.pollAfterMs()).isEmpty
        assertThat(blockDeleteResponse.request())
            .isEqualTo(
                BlockDeleteResponse.Request.builder()
                    .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                    .payload(
                        BlockDeleteResponse.Request.Payload.builder()
                            .putAdditionalProperty("user_id", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )
        assertThat(blockDeleteResponse.result())
            .contains(
                BlockDeleteResponse.Result.builder()
                    .id("9876543210")
                    .state("unblocked")
                    .type(BlockDeleteResponse.Result.Type.STATE_CHANGE)
                    .build()
            )
        assertThat(blockDeleteResponse.retryable()).isEqualTo(false)
        assertThat(blockDeleteResponse.safeToRetry()).isEqualTo(false)
        assertThat(blockDeleteResponse.sendDispatched()).isEqualTo(true)
        assertThat(blockDeleteResponse.status()).isEqualTo(BlockDeleteResponse.Status.SUCCESS)
        assertThat(blockDeleteResponse.statusUrl()).isEqualTo("/api/v1/x/write-actions/12345")
        assertThat(blockDeleteResponse.success()).isEqualTo(true)
        assertThat(blockDeleteResponse.target())
            .contains(
                BlockDeleteResponse.Target.builder()
                    .id("9876543210")
                    .type(BlockDeleteResponse.Target.Type.TWEET)
                    .build()
            )
        assertThat(blockDeleteResponse.targetId()).contains("9876543210")
        assertThat(blockDeleteResponse.terminal()).isEqualTo(true)
        assertThat(blockDeleteResponse.writeActionId()).isEqualTo("12345")
        assertThat(blockDeleteResponse.communityId()).contains("3456789012")
        assertThat(blockDeleteResponse.communityName()).contains("Builders")
        assertThat(blockDeleteResponse.completedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(blockDeleteResponse.confirmationAttempts()).contains(1L)
        assertThat(blockDeleteResponse.confirmationCheckedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(blockDeleteResponse.confirmedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(blockDeleteResponse.createdAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
        assertThat(blockDeleteResponse.details())
            .contains(
                BlockDeleteResponse.Details.builder()
                    .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                    .build()
            )
        assertThat(blockDeleteResponse.error()).contains("x_write_ambiguous")
        assertThat(blockDeleteResponse.expiresAt())
            .contains(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
        assertThat(blockDeleteResponse.idempotent()).contains(false)
        assertThat(blockDeleteResponse.media())
            .contains(
                BlockDeleteResponse.Media.builder()
                    .putAdditionalProperty("count", JsonValue.from("bar"))
                    .putAdditionalProperty("kind", JsonValue.from("bar"))
                    .build()
            )
        assertThat(blockDeleteResponse.mediaId()).contains("2345678901")
        assertThat(blockDeleteResponse.mediaUrl()).contains("https://media.xquik.com/example.jpg")
        assertThat(blockDeleteResponse.message()).contains("Invalid input. Check request fields.")
        assertThat(blockDeleteResponse.messageId()).contains("1234567890")
        assertThat(blockDeleteResponse.requestHash())
            .contains("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
        assertThat(blockDeleteResponse.requestId()).contains("01JZ8R7QSC9QKT0V7JX4M2A6B8")
        assertThat(blockDeleteResponse.resultId()).contains("9876543210")
        assertThat(blockDeleteResponse.sendDispatchedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
        assertThat(blockDeleteResponse.tweetId()).contains("9876543210")
        assertThat(blockDeleteResponse.updatedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val blockDeleteResponse =
            BlockDeleteResponse.builder()
                .id("12345")
                .account(BlockDeleteResponse.Account.builder().id("42").username("example").build())
                .action(BlockDeleteResponse.Action.UNBLOCK)
                .billing(
                    BlockDeleteResponse.Billing.builder()
                        .charged(true)
                        .chargedCredits("10")
                        .plannedCredits("10")
                        .status(BlockDeleteResponse.Billing.Status.CHARGED)
                        .build()
                )
                .charged(true)
                .chargedCredits("10")
                .nextAction(
                    BlockDeleteResponse.NextAction.builder()
                        .type(BlockDeleteResponse.NextAction.Type.POLL)
                        .afterMs(2000L)
                        .requiresNewIdempotencyKey(true)
                        .url("/api/v1/x/write-actions/12345")
                        .build()
                )
                .pollAfterMs(null)
                .request(
                    BlockDeleteResponse.Request.builder()
                        .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                        .payload(
                            BlockDeleteResponse.Request.Payload.builder()
                                .putAdditionalProperty("user_id", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .result(
                    BlockDeleteResponse.Result.builder()
                        .id("9876543210")
                        .state("unblocked")
                        .type(BlockDeleteResponse.Result.Type.STATE_CHANGE)
                        .build()
                )
                .retryable(false)
                .safeToRetry(false)
                .sendDispatched(true)
                .status(BlockDeleteResponse.Status.SUCCESS)
                .statusUrl("/api/v1/x/write-actions/12345")
                .success(true)
                .target(
                    BlockDeleteResponse.Target.builder()
                        .id("9876543210")
                        .type(BlockDeleteResponse.Target.Type.TWEET)
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
                    BlockDeleteResponse.Details.builder()
                        .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                        .build()
                )
                .error("x_write_ambiguous")
                .expiresAt(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
                .idempotent(false)
                .media(
                    BlockDeleteResponse.Media.builder()
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
                jsonMapper.writeValueAsString(blockDeleteResponse),
                jacksonTypeRef<BlockDeleteResponse>(),
            )

        assertThat(roundtrippedLikeDeleteResponse).isEqualTo(blockDeleteResponse)
    }

    @Test
    fun additionalActionValues() {
        assertThat(BlockDeleteResponse.Action.of("delete_dm").known())
            .isEqualTo(BlockDeleteResponse.Action.Known.DELETE_DM)
    }

    @Test
    fun bookmarkBlockAndMuteActionValues() {
        mapOf(
                "bookmark" to BlockDeleteResponse.Action.Known.BOOKMARK,
                "unbookmark" to BlockDeleteResponse.Action.Known.UNBOOKMARK,
                "block" to BlockDeleteResponse.Action.Known.BLOCK,
                "unblock" to BlockDeleteResponse.Action.Known.UNBLOCK,
                "mute" to BlockDeleteResponse.Action.Known.MUTE,
                "unmute" to BlockDeleteResponse.Action.Known.UNMUTE,
            )
            .forEach { (wire, known) ->
                assertThat(BlockDeleteResponse.Action.of(wire).known()).isEqualTo(known)
                assertThat(BlockDeleteResponse.Action.of(wire).value().name).isEqualTo(known.name)
            }
    }
}
