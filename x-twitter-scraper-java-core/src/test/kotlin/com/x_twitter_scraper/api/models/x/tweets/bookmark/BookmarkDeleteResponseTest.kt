// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets.bookmark

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BookmarkDeleteResponseTest {

    @Test
    fun create() {
        val bookmarkDeleteResponse =
            BookmarkDeleteResponse.builder()
                .id("12345")
                .account(
                    BookmarkDeleteResponse.Account.builder().id("42").username("example").build()
                )
                .action(BookmarkDeleteResponse.Action.UNBOOKMARK)
                .billing(
                    BookmarkDeleteResponse.Billing.builder()
                        .charged(true)
                        .chargedCredits("10")
                        .plannedCredits("10")
                        .status(BookmarkDeleteResponse.Billing.Status.CHARGED)
                        .build()
                )
                .charged(true)
                .chargedCredits("10")
                .nextAction(
                    BookmarkDeleteResponse.NextAction.builder()
                        .type(BookmarkDeleteResponse.NextAction.Type.POLL)
                        .afterMs(2000L)
                        .requiresNewIdempotencyKey(true)
                        .url("/api/v1/x/write-actions/12345")
                        .build()
                )
                .pollAfterMs(null)
                .request(
                    BookmarkDeleteResponse.Request.builder()
                        .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                        .payload(
                            BookmarkDeleteResponse.Request.Payload.builder()
                                .putAdditionalProperty("tweet_id", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .result(
                    BookmarkDeleteResponse.Result.builder()
                        .id("9876543210")
                        .state("unbookmarked")
                        .type(BookmarkDeleteResponse.Result.Type.STATE_CHANGE)
                        .build()
                )
                .retryable(false)
                .safeToRetry(false)
                .sendDispatched(true)
                .status(BookmarkDeleteResponse.Status.SUCCESS)
                .statusUrl("/api/v1/x/write-actions/12345")
                .success(true)
                .target(
                    BookmarkDeleteResponse.Target.builder()
                        .id("9876543210")
                        .type(BookmarkDeleteResponse.Target.Type.TWEET)
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
                    BookmarkDeleteResponse.Details.builder()
                        .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                        .build()
                )
                .error("x_write_ambiguous")
                .expiresAt(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
                .idempotent(false)
                .media(
                    BookmarkDeleteResponse.Media.builder()
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

        assertThat(bookmarkDeleteResponse.id()).isEqualTo("12345")
        assertThat(bookmarkDeleteResponse.account())
            .contains(BookmarkDeleteResponse.Account.builder().id("42").username("example").build())
        assertThat(bookmarkDeleteResponse.action())
            .isEqualTo(BookmarkDeleteResponse.Action.UNBOOKMARK)
        assertThat(bookmarkDeleteResponse.billing())
            .isEqualTo(
                BookmarkDeleteResponse.Billing.builder()
                    .charged(true)
                    .chargedCredits("10")
                    .plannedCredits("10")
                    .status(BookmarkDeleteResponse.Billing.Status.CHARGED)
                    .build()
            )
        assertThat(bookmarkDeleteResponse.charged()).isEqualTo(true)
        assertThat(bookmarkDeleteResponse.chargedCredits()).isEqualTo("10")
        assertThat(bookmarkDeleteResponse.nextAction())
            .contains(
                BookmarkDeleteResponse.NextAction.builder()
                    .type(BookmarkDeleteResponse.NextAction.Type.POLL)
                    .afterMs(2000L)
                    .requiresNewIdempotencyKey(true)
                    .url("/api/v1/x/write-actions/12345")
                    .build()
            )
        assertThat(bookmarkDeleteResponse.pollAfterMs()).isEmpty
        assertThat(bookmarkDeleteResponse.request())
            .isEqualTo(
                BookmarkDeleteResponse.Request.builder()
                    .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                    .payload(
                        BookmarkDeleteResponse.Request.Payload.builder()
                            .putAdditionalProperty("tweet_id", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )
        assertThat(bookmarkDeleteResponse.result())
            .contains(
                BookmarkDeleteResponse.Result.builder()
                    .id("9876543210")
                    .state("unbookmarked")
                    .type(BookmarkDeleteResponse.Result.Type.STATE_CHANGE)
                    .build()
            )
        assertThat(bookmarkDeleteResponse.retryable()).isEqualTo(false)
        assertThat(bookmarkDeleteResponse.safeToRetry()).isEqualTo(false)
        assertThat(bookmarkDeleteResponse.sendDispatched()).isEqualTo(true)
        assertThat(bookmarkDeleteResponse.status()).isEqualTo(BookmarkDeleteResponse.Status.SUCCESS)
        assertThat(bookmarkDeleteResponse.statusUrl()).isEqualTo("/api/v1/x/write-actions/12345")
        assertThat(bookmarkDeleteResponse.success()).isEqualTo(true)
        assertThat(bookmarkDeleteResponse.target())
            .contains(
                BookmarkDeleteResponse.Target.builder()
                    .id("9876543210")
                    .type(BookmarkDeleteResponse.Target.Type.TWEET)
                    .build()
            )
        assertThat(bookmarkDeleteResponse.targetId()).contains("9876543210")
        assertThat(bookmarkDeleteResponse.terminal()).isEqualTo(true)
        assertThat(bookmarkDeleteResponse.writeActionId()).isEqualTo("12345")
        assertThat(bookmarkDeleteResponse.communityId()).contains("3456789012")
        assertThat(bookmarkDeleteResponse.communityName()).contains("Builders")
        assertThat(bookmarkDeleteResponse.completedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(bookmarkDeleteResponse.confirmationAttempts()).contains(1L)
        assertThat(bookmarkDeleteResponse.confirmationCheckedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(bookmarkDeleteResponse.confirmedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(bookmarkDeleteResponse.createdAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
        assertThat(bookmarkDeleteResponse.details())
            .contains(
                BookmarkDeleteResponse.Details.builder()
                    .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                    .build()
            )
        assertThat(bookmarkDeleteResponse.error()).contains("x_write_ambiguous")
        assertThat(bookmarkDeleteResponse.expiresAt())
            .contains(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
        assertThat(bookmarkDeleteResponse.idempotent()).contains(false)
        assertThat(bookmarkDeleteResponse.media())
            .contains(
                BookmarkDeleteResponse.Media.builder()
                    .putAdditionalProperty("count", JsonValue.from("bar"))
                    .putAdditionalProperty("kind", JsonValue.from("bar"))
                    .build()
            )
        assertThat(bookmarkDeleteResponse.mediaId()).contains("2345678901")
        assertThat(bookmarkDeleteResponse.mediaUrl())
            .contains("https://media.xquik.com/example.jpg")
        assertThat(bookmarkDeleteResponse.message())
            .contains("Invalid input. Check request fields.")
        assertThat(bookmarkDeleteResponse.messageId()).contains("1234567890")
        assertThat(bookmarkDeleteResponse.requestHash())
            .contains("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
        assertThat(bookmarkDeleteResponse.requestId()).contains("01JZ8R7QSC9QKT0V7JX4M2A6B8")
        assertThat(bookmarkDeleteResponse.resultId()).contains("9876543210")
        assertThat(bookmarkDeleteResponse.sendDispatchedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
        assertThat(bookmarkDeleteResponse.tweetId()).contains("9876543210")
        assertThat(bookmarkDeleteResponse.updatedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bookmarkDeleteResponse =
            BookmarkDeleteResponse.builder()
                .id("12345")
                .account(
                    BookmarkDeleteResponse.Account.builder().id("42").username("example").build()
                )
                .action(BookmarkDeleteResponse.Action.UNBOOKMARK)
                .billing(
                    BookmarkDeleteResponse.Billing.builder()
                        .charged(true)
                        .chargedCredits("10")
                        .plannedCredits("10")
                        .status(BookmarkDeleteResponse.Billing.Status.CHARGED)
                        .build()
                )
                .charged(true)
                .chargedCredits("10")
                .nextAction(
                    BookmarkDeleteResponse.NextAction.builder()
                        .type(BookmarkDeleteResponse.NextAction.Type.POLL)
                        .afterMs(2000L)
                        .requiresNewIdempotencyKey(true)
                        .url("/api/v1/x/write-actions/12345")
                        .build()
                )
                .pollAfterMs(null)
                .request(
                    BookmarkDeleteResponse.Request.builder()
                        .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                        .payload(
                            BookmarkDeleteResponse.Request.Payload.builder()
                                .putAdditionalProperty("tweet_id", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .result(
                    BookmarkDeleteResponse.Result.builder()
                        .id("9876543210")
                        .state("unbookmarked")
                        .type(BookmarkDeleteResponse.Result.Type.STATE_CHANGE)
                        .build()
                )
                .retryable(false)
                .safeToRetry(false)
                .sendDispatched(true)
                .status(BookmarkDeleteResponse.Status.SUCCESS)
                .statusUrl("/api/v1/x/write-actions/12345")
                .success(true)
                .target(
                    BookmarkDeleteResponse.Target.builder()
                        .id("9876543210")
                        .type(BookmarkDeleteResponse.Target.Type.TWEET)
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
                    BookmarkDeleteResponse.Details.builder()
                        .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                        .build()
                )
                .error("x_write_ambiguous")
                .expiresAt(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
                .idempotent(false)
                .media(
                    BookmarkDeleteResponse.Media.builder()
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
                jsonMapper.writeValueAsString(bookmarkDeleteResponse),
                jacksonTypeRef<BookmarkDeleteResponse>(),
            )

        assertThat(roundtrippedLikeDeleteResponse).isEqualTo(bookmarkDeleteResponse)
    }

    @Test
    fun additionalActionValues() {
        assertThat(BookmarkDeleteResponse.Action.of("delete_dm").known())
            .isEqualTo(BookmarkDeleteResponse.Action.Known.DELETE_DM)
    }

    @Test
    fun bookmarkBlockAndMuteActionValues() {
        mapOf(
                "bookmark" to BookmarkDeleteResponse.Action.Known.BOOKMARK,
                "unbookmark" to BookmarkDeleteResponse.Action.Known.UNBOOKMARK,
                "block" to BookmarkDeleteResponse.Action.Known.BLOCK,
                "unblock" to BookmarkDeleteResponse.Action.Known.UNBLOCK,
                "mute" to BookmarkDeleteResponse.Action.Known.MUTE,
                "unmute" to BookmarkDeleteResponse.Action.Known.UNMUTE,
            )
            .forEach { (wire, known) ->
                assertThat(BookmarkDeleteResponse.Action.of(wire).known()).isEqualTo(known)
                assertThat(BookmarkDeleteResponse.Action.of(wire).value().name)
                    .isEqualTo(known.name)
            }
    }
}
