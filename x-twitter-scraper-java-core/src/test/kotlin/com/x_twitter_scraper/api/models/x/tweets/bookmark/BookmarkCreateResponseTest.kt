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

internal class BookmarkCreateResponseTest {

    @Test
    fun create() {
        val bookmarkCreateResponse =
            BookmarkCreateResponse.builder()
                .id("12345")
                .account(
                    BookmarkCreateResponse.Account.builder().id("42").username("example").build()
                )
                .action(BookmarkCreateResponse.Action.BOOKMARK)
                .billing(
                    BookmarkCreateResponse.Billing.builder()
                        .charged(true)
                        .chargedCredits("10")
                        .plannedCredits("10")
                        .status(BookmarkCreateResponse.Billing.Status.CHARGED)
                        .build()
                )
                .charged(true)
                .chargedCredits("10")
                .nextAction(
                    BookmarkCreateResponse.NextAction.builder()
                        .type(BookmarkCreateResponse.NextAction.Type.POLL)
                        .afterMs(2000L)
                        .requiresNewIdempotencyKey(true)
                        .url("/api/v1/x/write-actions/12345")
                        .build()
                )
                .pollAfterMs(null)
                .request(
                    BookmarkCreateResponse.Request.builder()
                        .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                        .payload(
                            BookmarkCreateResponse.Request.Payload.builder()
                                .putAdditionalProperty("tweet_id", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .result(
                    BookmarkCreateResponse.Result.builder()
                        .id("9876543210")
                        .state("bookmarked")
                        .type(BookmarkCreateResponse.Result.Type.STATE_CHANGE)
                        .build()
                )
                .retryable(false)
                .safeToRetry(false)
                .sendDispatched(true)
                .status(BookmarkCreateResponse.Status.SUCCESS)
                .statusUrl("/api/v1/x/write-actions/12345")
                .success(true)
                .target(
                    BookmarkCreateResponse.Target.builder()
                        .id("9876543210")
                        .type(BookmarkCreateResponse.Target.Type.TWEET)
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
                    BookmarkCreateResponse.Details.builder()
                        .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                        .build()
                )
                .error("x_write_ambiguous")
                .expiresAt(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
                .idempotent(false)
                .media(
                    BookmarkCreateResponse.Media.builder()
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

        assertThat(bookmarkCreateResponse.id()).isEqualTo("12345")
        assertThat(bookmarkCreateResponse.account())
            .contains(BookmarkCreateResponse.Account.builder().id("42").username("example").build())
        assertThat(bookmarkCreateResponse.action())
            .isEqualTo(BookmarkCreateResponse.Action.BOOKMARK)
        assertThat(bookmarkCreateResponse.billing())
            .isEqualTo(
                BookmarkCreateResponse.Billing.builder()
                    .charged(true)
                    .chargedCredits("10")
                    .plannedCredits("10")
                    .status(BookmarkCreateResponse.Billing.Status.CHARGED)
                    .build()
            )
        assertThat(bookmarkCreateResponse.charged()).isEqualTo(true)
        assertThat(bookmarkCreateResponse.chargedCredits()).isEqualTo("10")
        assertThat(bookmarkCreateResponse.nextAction())
            .contains(
                BookmarkCreateResponse.NextAction.builder()
                    .type(BookmarkCreateResponse.NextAction.Type.POLL)
                    .afterMs(2000L)
                    .requiresNewIdempotencyKey(true)
                    .url("/api/v1/x/write-actions/12345")
                    .build()
            )
        assertThat(bookmarkCreateResponse.pollAfterMs()).isEmpty
        assertThat(bookmarkCreateResponse.request())
            .isEqualTo(
                BookmarkCreateResponse.Request.builder()
                    .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                    .payload(
                        BookmarkCreateResponse.Request.Payload.builder()
                            .putAdditionalProperty("tweet_id", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )
        assertThat(bookmarkCreateResponse.result())
            .contains(
                BookmarkCreateResponse.Result.builder()
                    .id("9876543210")
                    .state("bookmarked")
                    .type(BookmarkCreateResponse.Result.Type.STATE_CHANGE)
                    .build()
            )
        assertThat(bookmarkCreateResponse.retryable()).isEqualTo(false)
        assertThat(bookmarkCreateResponse.safeToRetry()).isEqualTo(false)
        assertThat(bookmarkCreateResponse.sendDispatched()).isEqualTo(true)
        assertThat(bookmarkCreateResponse.status()).isEqualTo(BookmarkCreateResponse.Status.SUCCESS)
        assertThat(bookmarkCreateResponse.statusUrl()).isEqualTo("/api/v1/x/write-actions/12345")
        assertThat(bookmarkCreateResponse.success()).isEqualTo(true)
        assertThat(bookmarkCreateResponse.target())
            .contains(
                BookmarkCreateResponse.Target.builder()
                    .id("9876543210")
                    .type(BookmarkCreateResponse.Target.Type.TWEET)
                    .build()
            )
        assertThat(bookmarkCreateResponse.targetId()).contains("9876543210")
        assertThat(bookmarkCreateResponse.terminal()).isEqualTo(true)
        assertThat(bookmarkCreateResponse.writeActionId()).isEqualTo("12345")
        assertThat(bookmarkCreateResponse.communityId()).contains("3456789012")
        assertThat(bookmarkCreateResponse.communityName()).contains("Builders")
        assertThat(bookmarkCreateResponse.completedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(bookmarkCreateResponse.confirmationAttempts()).contains(1L)
        assertThat(bookmarkCreateResponse.confirmationCheckedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(bookmarkCreateResponse.confirmedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(bookmarkCreateResponse.createdAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
        assertThat(bookmarkCreateResponse.details())
            .contains(
                BookmarkCreateResponse.Details.builder()
                    .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                    .build()
            )
        assertThat(bookmarkCreateResponse.error()).contains("x_write_ambiguous")
        assertThat(bookmarkCreateResponse.expiresAt())
            .contains(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
        assertThat(bookmarkCreateResponse.idempotent()).contains(false)
        assertThat(bookmarkCreateResponse.media())
            .contains(
                BookmarkCreateResponse.Media.builder()
                    .putAdditionalProperty("count", JsonValue.from("bar"))
                    .putAdditionalProperty("kind", JsonValue.from("bar"))
                    .build()
            )
        assertThat(bookmarkCreateResponse.mediaId()).contains("2345678901")
        assertThat(bookmarkCreateResponse.mediaUrl())
            .contains("https://media.xquik.com/example.jpg")
        assertThat(bookmarkCreateResponse.message())
            .contains("Invalid input. Check request fields.")
        assertThat(bookmarkCreateResponse.messageId()).contains("1234567890")
        assertThat(bookmarkCreateResponse.requestHash())
            .contains("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
        assertThat(bookmarkCreateResponse.requestId()).contains("01JZ8R7QSC9QKT0V7JX4M2A6B8")
        assertThat(bookmarkCreateResponse.resultId()).contains("9876543210")
        assertThat(bookmarkCreateResponse.sendDispatchedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
        assertThat(bookmarkCreateResponse.tweetId()).contains("9876543210")
        assertThat(bookmarkCreateResponse.updatedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val bookmarkCreateResponse =
            BookmarkCreateResponse.builder()
                .id("12345")
                .account(
                    BookmarkCreateResponse.Account.builder().id("42").username("example").build()
                )
                .action(BookmarkCreateResponse.Action.BOOKMARK)
                .billing(
                    BookmarkCreateResponse.Billing.builder()
                        .charged(true)
                        .chargedCredits("10")
                        .plannedCredits("10")
                        .status(BookmarkCreateResponse.Billing.Status.CHARGED)
                        .build()
                )
                .charged(true)
                .chargedCredits("10")
                .nextAction(
                    BookmarkCreateResponse.NextAction.builder()
                        .type(BookmarkCreateResponse.NextAction.Type.POLL)
                        .afterMs(2000L)
                        .requiresNewIdempotencyKey(true)
                        .url("/api/v1/x/write-actions/12345")
                        .build()
                )
                .pollAfterMs(null)
                .request(
                    BookmarkCreateResponse.Request.builder()
                        .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                        .payload(
                            BookmarkCreateResponse.Request.Payload.builder()
                                .putAdditionalProperty("tweet_id", JsonValue.from("bar"))
                                .build()
                        )
                        .build()
                )
                .result(
                    BookmarkCreateResponse.Result.builder()
                        .id("9876543210")
                        .state("bookmarked")
                        .type(BookmarkCreateResponse.Result.Type.STATE_CHANGE)
                        .build()
                )
                .retryable(false)
                .safeToRetry(false)
                .sendDispatched(true)
                .status(BookmarkCreateResponse.Status.SUCCESS)
                .statusUrl("/api/v1/x/write-actions/12345")
                .success(true)
                .target(
                    BookmarkCreateResponse.Target.builder()
                        .id("9876543210")
                        .type(BookmarkCreateResponse.Target.Type.TWEET)
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
                    BookmarkCreateResponse.Details.builder()
                        .putAdditionalProperty("suggestion", JsonValue.from("bar"))
                        .build()
                )
                .error("x_write_ambiguous")
                .expiresAt(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
                .idempotent(false)
                .media(
                    BookmarkCreateResponse.Media.builder()
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
                jsonMapper.writeValueAsString(bookmarkCreateResponse),
                jacksonTypeRef<BookmarkCreateResponse>(),
            )

        assertThat(roundtrippedLikeCreateResponse).isEqualTo(bookmarkCreateResponse)
    }

    @Test
    fun additionalActionValues() {
        assertThat(BookmarkCreateResponse.Action.of("delete_dm").known())
            .isEqualTo(BookmarkCreateResponse.Action.Known.DELETE_DM)
    }

    @Test
    fun bookmarkBlockAndMuteActionValues() {
        mapOf(
                "bookmark" to BookmarkCreateResponse.Action.Known.BOOKMARK,
                "unbookmark" to BookmarkCreateResponse.Action.Known.UNBOOKMARK,
                "block" to BookmarkCreateResponse.Action.Known.BLOCK,
                "unblock" to BookmarkCreateResponse.Action.Known.UNBLOCK,
                "mute" to BookmarkCreateResponse.Action.Known.MUTE,
                "unmute" to BookmarkCreateResponse.Action.Known.UNMUTE,
            )
            .forEach { (wire, known) ->
                assertThat(BookmarkCreateResponse.Action.of(wire).known()).isEqualTo(known)
                assertThat(BookmarkCreateResponse.Action.of(wire).value().name)
                    .isEqualTo(known.name)
            }
    }
}
