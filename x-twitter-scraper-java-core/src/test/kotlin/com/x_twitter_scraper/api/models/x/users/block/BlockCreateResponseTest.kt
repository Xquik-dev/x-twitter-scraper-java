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

internal class BlockCreateResponseTest {

    @Test
    fun create() {
        val blockCreateResponse =
            BlockCreateResponse.builder()
                .id("12345")
                .account(BlockCreateResponse.Account.builder().id("42").username("example").build())
                .action(BlockCreateResponse.Action.BLOCK)
                .billing(
                    BlockCreateResponse.Billing.builder()
                        .charged(true)
                        .chargedCredits("10")
                        .plannedCredits("10")
                        .status(BlockCreateResponse.Billing.Status.CHARGED)
                        .build()
                )
                .charged(true)
                .chargedCredits("10")
                .nextAction(
                    BlockCreateResponse.NextAction.builder()
                        .type(BlockCreateResponse.NextAction.Type.POLL)
                        .afterMs(2000L)
                        .requiresNewIdempotencyKey(true)
                        .url("/api/v1/x/write-actions/12345")
                        .build()
                )
                .pollAfterMs(null)
                .request(
                    BlockCreateResponse.Request.builder()
                        .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                        .payload(
                            BlockCreateResponse.Request.Payload.builder()
                                .putAdditionalProperty("user_id", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .result(
                    BlockCreateResponse.Result.builder()
                        .id("9876543210")
                        .state("blocked")
                        .type(BlockCreateResponse.Result.Type.STATE_CHANGE)
                        .build()
                )
                .retryable(false)
                .safeToRetry(false)
                .sendDispatched(true)
                .status(BlockCreateResponse.Status.SUCCESS)
                .statusUrl("/api/v1/x/write-actions/12345")
                .success(true)
                .target(
                    BlockCreateResponse.Target.builder()
                        .id("9876543210")
                        .type(BlockCreateResponse.Target.Type.TWEET)
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
                    BlockCreateResponse.Details.builder()
                        .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                        .build()
                )
                .error("x_write_ambiguous")
                .expiresAt(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
                .idempotent(false)
                .media(
                    BlockCreateResponse.Media.builder()
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

        assertThat(blockCreateResponse.id()).isEqualTo("12345")
        assertThat(blockCreateResponse.account())
            .contains(BlockCreateResponse.Account.builder().id("42").username("example").build())
        assertThat(blockCreateResponse.action()).isEqualTo(BlockCreateResponse.Action.BLOCK)
        assertThat(blockCreateResponse.billing())
            .isEqualTo(
                BlockCreateResponse.Billing.builder()
                    .charged(true)
                    .chargedCredits("10")
                    .plannedCredits("10")
                    .status(BlockCreateResponse.Billing.Status.CHARGED)
                    .build()
            )
        assertThat(blockCreateResponse.charged()).isEqualTo(true)
        assertThat(blockCreateResponse.chargedCredits()).isEqualTo("10")
        assertThat(blockCreateResponse.nextAction())
            .contains(
                BlockCreateResponse.NextAction.builder()
                    .type(BlockCreateResponse.NextAction.Type.POLL)
                    .afterMs(2000L)
                    .requiresNewIdempotencyKey(true)
                    .url("/api/v1/x/write-actions/12345")
                    .build()
            )
        assertThat(blockCreateResponse.pollAfterMs()).isEmpty
        assertThat(blockCreateResponse.request())
            .isEqualTo(
                BlockCreateResponse.Request.builder()
                    .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                    .payload(
                        BlockCreateResponse.Request.Payload.builder()
                            .putAdditionalProperty("user_id", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )
        assertThat(blockCreateResponse.result())
            .contains(
                BlockCreateResponse.Result.builder()
                    .id("9876543210")
                    .state("blocked")
                    .type(BlockCreateResponse.Result.Type.STATE_CHANGE)
                    .build()
            )
        assertThat(blockCreateResponse.retryable()).isEqualTo(false)
        assertThat(blockCreateResponse.safeToRetry()).isEqualTo(false)
        assertThat(blockCreateResponse.sendDispatched()).isEqualTo(true)
        assertThat(blockCreateResponse.status()).isEqualTo(BlockCreateResponse.Status.SUCCESS)
        assertThat(blockCreateResponse.statusUrl()).isEqualTo("/api/v1/x/write-actions/12345")
        assertThat(blockCreateResponse.success()).isEqualTo(true)
        assertThat(blockCreateResponse.target())
            .contains(
                BlockCreateResponse.Target.builder()
                    .id("9876543210")
                    .type(BlockCreateResponse.Target.Type.TWEET)
                    .build()
            )
        assertThat(blockCreateResponse.targetId()).contains("9876543210")
        assertThat(blockCreateResponse.terminal()).isEqualTo(true)
        assertThat(blockCreateResponse.writeActionId()).isEqualTo("12345")
        assertThat(blockCreateResponse.communityId()).contains("3456789012")
        assertThat(blockCreateResponse.communityName()).contains("Builders")
        assertThat(blockCreateResponse.completedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(blockCreateResponse.confirmationAttempts()).contains(1L)
        assertThat(blockCreateResponse.confirmationCheckedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(blockCreateResponse.confirmedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(blockCreateResponse.createdAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
        assertThat(blockCreateResponse.details())
            .contains(
                BlockCreateResponse.Details.builder()
                    .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                    .build()
            )
        assertThat(blockCreateResponse.error()).contains("x_write_ambiguous")
        assertThat(blockCreateResponse.expiresAt())
            .contains(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
        assertThat(blockCreateResponse.idempotent()).contains(false)
        assertThat(blockCreateResponse.media())
            .contains(
                BlockCreateResponse.Media.builder()
                    .putAdditionalProperty("count", JsonValue.from("bar"))
                    .putAdditionalProperty("kind", JsonValue.from("bar"))
                    .build()
            )
        assertThat(blockCreateResponse.mediaId()).contains("2345678901")
        assertThat(blockCreateResponse.mediaUrl()).contains("https://media.xquik.com/example.jpg")
        assertThat(blockCreateResponse.message()).contains("Invalid input. Check request fields.")
        assertThat(blockCreateResponse.messageId()).contains("1234567890")
        assertThat(blockCreateResponse.requestHash())
            .contains("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
        assertThat(blockCreateResponse.requestId()).contains("01JZ8R7QSC9QKT0V7JX4M2A6B8")
        assertThat(blockCreateResponse.resultId()).contains("9876543210")
        assertThat(blockCreateResponse.sendDispatchedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
        assertThat(blockCreateResponse.tweetId()).contains("9876543210")
        assertThat(blockCreateResponse.updatedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val blockCreateResponse =
            BlockCreateResponse.builder()
                .id("12345")
                .account(BlockCreateResponse.Account.builder().id("42").username("example").build())
                .action(BlockCreateResponse.Action.BLOCK)
                .billing(
                    BlockCreateResponse.Billing.builder()
                        .charged(true)
                        .chargedCredits("10")
                        .plannedCredits("10")
                        .status(BlockCreateResponse.Billing.Status.CHARGED)
                        .build()
                )
                .charged(true)
                .chargedCredits("10")
                .nextAction(
                    BlockCreateResponse.NextAction.builder()
                        .type(BlockCreateResponse.NextAction.Type.POLL)
                        .afterMs(2000L)
                        .requiresNewIdempotencyKey(true)
                        .url("/api/v1/x/write-actions/12345")
                        .build()
                )
                .pollAfterMs(null)
                .request(
                    BlockCreateResponse.Request.builder()
                        .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                        .payload(
                            BlockCreateResponse.Request.Payload.builder()
                                .putAdditionalProperty("user_id", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .result(
                    BlockCreateResponse.Result.builder()
                        .id("9876543210")
                        .state("blocked")
                        .type(BlockCreateResponse.Result.Type.STATE_CHANGE)
                        .build()
                )
                .retryable(false)
                .safeToRetry(false)
                .sendDispatched(true)
                .status(BlockCreateResponse.Status.SUCCESS)
                .statusUrl("/api/v1/x/write-actions/12345")
                .success(true)
                .target(
                    BlockCreateResponse.Target.builder()
                        .id("9876543210")
                        .type(BlockCreateResponse.Target.Type.TWEET)
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
                    BlockCreateResponse.Details.builder()
                        .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                        .build()
                )
                .error("x_write_ambiguous")
                .expiresAt(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
                .idempotent(false)
                .media(
                    BlockCreateResponse.Media.builder()
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
                jsonMapper.writeValueAsString(blockCreateResponse),
                jacksonTypeRef<BlockCreateResponse>(),
            )

        assertThat(roundtrippedLikeCreateResponse).isEqualTo(blockCreateResponse)
    }

    @Test
    fun additionalActionValues() {
        assertThat(BlockCreateResponse.Action.of("delete_dm").known())
            .isEqualTo(BlockCreateResponse.Action.Known.DELETE_DM)
    }

    @Test
    fun bookmarkBlockAndMuteActionValues() {
        mapOf(
                "bookmark" to BlockCreateResponse.Action.Known.BOOKMARK,
                "unbookmark" to BlockCreateResponse.Action.Known.UNBOOKMARK,
                "block" to BlockCreateResponse.Action.Known.BLOCK,
                "unblock" to BlockCreateResponse.Action.Known.UNBLOCK,
                "mute" to BlockCreateResponse.Action.Known.MUTE,
                "unmute" to BlockCreateResponse.Action.Known.UNMUTE,
            )
            .forEach { (wire, known) ->
                assertThat(BlockCreateResponse.Action.of(wire).known()).isEqualTo(known)
                assertThat(BlockCreateResponse.Action.of(wire).value().name).isEqualTo(known.name)
            }
    }
}
