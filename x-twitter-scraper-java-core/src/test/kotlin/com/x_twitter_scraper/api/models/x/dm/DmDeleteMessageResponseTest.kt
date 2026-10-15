// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.dm

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DmDeleteMessageResponseTest {

    @Test
    fun create() {
        val dmDeleteMessageResponse =
            DmDeleteMessageResponse.builder()
                .account(
                    DmDeleteMessageResponse.Account.builder().id("42").username("example").build()
                )
                .action(DmDeleteMessageResponse.Action.LIKE)
                .billing(
                    DmDeleteMessageResponse.Billing.builder()
                        .charged(true)
                        .chargedCredits("10")
                        .plannedCredits("10")
                        .status(DmDeleteMessageResponse.Billing.Status.CHARGED)
                        .build()
                )
                .charged(true)
                .chargedCredits("10")
                .id("12345")
                .nextAction(null)
                .pollAfterMs(null)
                .request(
                    DmDeleteMessageResponse.Request.builder()
                        .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                        .payload(
                            DmDeleteMessageResponse.Request.Payload.builder()
                                .putAdditionalProperty("tweet_id", JsonValue.from("9876543210"))
                                .build()
                        )
                        .build()
                )
                .result(
                    DmDeleteMessageResponse.Result.builder()
                        .id("9876543210")
                        .state("liked")
                        .type(DmDeleteMessageResponse.Result.Type.STATE_CHANGE)
                        .build()
                )
                .retryable(false)
                .safeToRetry(false)
                .sendDispatched(true)
                .status(DmDeleteMessageResponse.Status.SUCCESS)
                .statusUrl("/api/v1/x/write-actions/12345")
                .success(true)
                .target(
                    DmDeleteMessageResponse.Target.builder()
                        .id("9876543210")
                        .type(DmDeleteMessageResponse.Target.Type.TWEET)
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
                    DmDeleteMessageResponse.Details.builder()
                        .putAdditionalProperty(
                            "suggestion",
                            JsonValue.from("Poll the action status URL."),
                        )
                        .build()
                )
                .error("x_write_ambiguous")
                .expiresAt(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
                .idempotent(false)
                .media(
                    DmDeleteMessageResponse.Media.builder()
                        .putAdditionalProperty("count", JsonValue.from(1))
                        .putAdditionalProperty("kind", JsonValue.from("image"))
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

        assertThat(dmDeleteMessageResponse.account())
            .contains(
                DmDeleteMessageResponse.Account.builder().id("42").username("example").build()
            )
        assertThat(dmDeleteMessageResponse.action()).isEqualTo(DmDeleteMessageResponse.Action.LIKE)
        assertThat(dmDeleteMessageResponse.billing())
            .isEqualTo(
                DmDeleteMessageResponse.Billing.builder()
                    .charged(true)
                    .chargedCredits("10")
                    .plannedCredits("10")
                    .status(DmDeleteMessageResponse.Billing.Status.CHARGED)
                    .build()
            )
        assertThat(dmDeleteMessageResponse.charged()).isEqualTo(true)
        assertThat(dmDeleteMessageResponse.chargedCredits()).isEqualTo("10")
        assertThat(dmDeleteMessageResponse.id()).isEqualTo("12345")
        assertThat(dmDeleteMessageResponse.nextAction()).isEmpty
        assertThat(dmDeleteMessageResponse.pollAfterMs()).isEmpty
        assertThat(dmDeleteMessageResponse.request())
            .isEqualTo(
                DmDeleteMessageResponse.Request.builder()
                    .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                    .payload(
                        DmDeleteMessageResponse.Request.Payload.builder()
                            .putAdditionalProperty("tweet_id", JsonValue.from("9876543210"))
                            .build()
                    )
                    .build()
            )
        assertThat(dmDeleteMessageResponse.result())
            .contains(
                DmDeleteMessageResponse.Result.builder()
                    .id("9876543210")
                    .state("liked")
                    .type(DmDeleteMessageResponse.Result.Type.STATE_CHANGE)
                    .build()
            )
        assertThat(dmDeleteMessageResponse.retryable()).isEqualTo(false)
        assertThat(dmDeleteMessageResponse.safeToRetry()).isEqualTo(false)
        assertThat(dmDeleteMessageResponse.sendDispatched()).isEqualTo(true)
        assertThat(dmDeleteMessageResponse.status())
            .isEqualTo(DmDeleteMessageResponse.Status.SUCCESS)
        assertThat(dmDeleteMessageResponse.statusUrl()).isEqualTo("/api/v1/x/write-actions/12345")
        assertThat(dmDeleteMessageResponse.success()).isEqualTo(true)
        assertThat(dmDeleteMessageResponse.target())
            .contains(
                DmDeleteMessageResponse.Target.builder()
                    .id("9876543210")
                    .type(DmDeleteMessageResponse.Target.Type.TWEET)
                    .build()
            )
        assertThat(dmDeleteMessageResponse.targetId()).contains("9876543210")
        assertThat(dmDeleteMessageResponse.terminal()).isEqualTo(true)
        assertThat(dmDeleteMessageResponse.writeActionId()).isEqualTo("12345")
        assertThat(dmDeleteMessageResponse.communityId()).contains("3456789012")
        assertThat(dmDeleteMessageResponse.communityName()).contains("Builders")
        assertThat(dmDeleteMessageResponse.completedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(dmDeleteMessageResponse.confirmationAttempts()).contains(1L)
        assertThat(dmDeleteMessageResponse.confirmationCheckedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(dmDeleteMessageResponse.confirmedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
        assertThat(dmDeleteMessageResponse.createdAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
        assertThat(dmDeleteMessageResponse.details())
            .contains(
                DmDeleteMessageResponse.Details.builder()
                    .putAdditionalProperty(
                        "suggestion",
                        JsonValue.from("Poll the action status URL."),
                    )
                    .build()
            )
        assertThat(dmDeleteMessageResponse.error()).contains("x_write_ambiguous")
        assertThat(dmDeleteMessageResponse.expiresAt())
            .contains(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
        assertThat(dmDeleteMessageResponse.idempotent()).contains(false)
        assertThat(dmDeleteMessageResponse.media())
            .contains(
                DmDeleteMessageResponse.Media.builder()
                    .putAdditionalProperty("count", JsonValue.from(1))
                    .putAdditionalProperty("kind", JsonValue.from("image"))
                    .build()
            )
        assertThat(dmDeleteMessageResponse.mediaId()).contains("2345678901")
        assertThat(dmDeleteMessageResponse.mediaUrl())
            .contains("https://media.xquik.com/example.jpg")
        assertThat(dmDeleteMessageResponse.message())
            .contains("Invalid input. Check request fields.")
        assertThat(dmDeleteMessageResponse.messageId()).contains("1234567890")
        assertThat(dmDeleteMessageResponse.requestHash())
            .contains("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
        assertThat(dmDeleteMessageResponse.requestId()).contains("01JZ8R7QSC9QKT0V7JX4M2A6B8")
        assertThat(dmDeleteMessageResponse.resultId()).contains("9876543210")
        assertThat(dmDeleteMessageResponse.sendDispatchedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:00Z"))
        assertThat(dmDeleteMessageResponse.tweetId()).contains("9876543210")
        assertThat(dmDeleteMessageResponse.updatedAt())
            .contains(OffsetDateTime.parse("2026-07-21T05:00:02Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val dmDeleteMessageResponse =
            DmDeleteMessageResponse.builder()
                .account(
                    DmDeleteMessageResponse.Account.builder().id("42").username("example").build()
                )
                .action(DmDeleteMessageResponse.Action.LIKE)
                .billing(
                    DmDeleteMessageResponse.Billing.builder()
                        .charged(true)
                        .chargedCredits("10")
                        .plannedCredits("10")
                        .status(DmDeleteMessageResponse.Billing.Status.CHARGED)
                        .build()
                )
                .charged(true)
                .chargedCredits("10")
                .id("12345")
                .nextAction(null)
                .pollAfterMs(null)
                .request(
                    DmDeleteMessageResponse.Request.builder()
                        .hash("0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef")
                        .payload(
                            DmDeleteMessageResponse.Request.Payload.builder()
                                .putAdditionalProperty("tweet_id", JsonValue.from("9876543210"))
                                .build()
                        )
                        .build()
                )
                .result(
                    DmDeleteMessageResponse.Result.builder()
                        .id("9876543210")
                        .state("liked")
                        .type(DmDeleteMessageResponse.Result.Type.STATE_CHANGE)
                        .build()
                )
                .retryable(false)
                .safeToRetry(false)
                .sendDispatched(true)
                .status(DmDeleteMessageResponse.Status.SUCCESS)
                .statusUrl("/api/v1/x/write-actions/12345")
                .success(true)
                .target(
                    DmDeleteMessageResponse.Target.builder()
                        .id("9876543210")
                        .type(DmDeleteMessageResponse.Target.Type.TWEET)
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
                    DmDeleteMessageResponse.Details.builder()
                        .putAdditionalProperty(
                            "suggestion",
                            JsonValue.from("Poll the action status URL."),
                        )
                        .build()
                )
                .error("x_write_ambiguous")
                .expiresAt(OffsetDateTime.parse("2026-07-22T05:00:00Z"))
                .idempotent(false)
                .media(
                    DmDeleteMessageResponse.Media.builder()
                        .putAdditionalProperty("count", JsonValue.from(1))
                        .putAdditionalProperty("kind", JsonValue.from("image"))
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

        val roundtrippedDmDeleteMessageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(dmDeleteMessageResponse),
                jacksonTypeRef<DmDeleteMessageResponse>(),
            )

        assertThat(roundtrippedDmDeleteMessageResponse).isEqualTo(dmDeleteMessageResponse)
    }
}
