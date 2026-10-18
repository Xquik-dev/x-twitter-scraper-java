// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class CommunityAnalyticsTest {

    @Test
    fun create() {
        val metric = CommunityAnalyticsMetric.builder().count(0L).changePercent(0.0).build()
        val metrics =
            CommunityAnalytics.Metrics.builder()
                .likes(metric)
                .newMembers(metric)
                .posts(metric)
                .replies(metric)
                .uniquePosters(metric)
                .build()
        val analytics =
            CommunityAnalytics.builder()
                .id("1493446837214187523")
                .periodEndsAt(OffsetDateTime.parse("2026-10-16T23:59:59.999Z"))
                .metrics(metrics)
                .build()

        assertThat(analytics.id()).isEqualTo("1493446837214187523")
        assertThat(analytics.periodEndsAt())
            .isEqualTo(OffsetDateTime.parse("2026-10-16T23:59:59.999Z"))
        assertThat(analytics.metrics().likes()).isEqualTo(metric)
        assertThat(analytics.metrics().newMembers()).isEqualTo(metric)
        assertThat(analytics.metrics().posts()).isEqualTo(metric)
        assertThat(analytics.metrics().replies()).isEqualTo(metric)
        assertThat(analytics.metrics().uniquePosters()).isEqualTo(metric)
        assertThat(analytics.validate()).isSameAs(analytics)
        assertThat(analytics.isValid()).isTrue()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val metric =
            CommunityAnalyticsMetric.builder()
                .count(15298L)
                .changePercent(-1.2076202776880853)
                .build()
        val metrics =
            CommunityAnalytics.Metrics.builder()
                .likes(metric)
                .newMembers(metric)
                .posts(metric)
                .replies(metric)
                .uniquePosters(metric)
                .putAdditionalProperty("extraMetric", JsonValue.from("value"))
                .build()
        val analytics =
            CommunityAnalytics.builder()
                .id("1493446837214187523")
                .periodEndsAt(OffsetDateTime.parse("2026-10-16T23:59:59.999Z"))
                .metrics(metrics)
                .putAdditionalProperty("extra", JsonValue.from("value"))
                .build()

        val roundtrippedAnalytics =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(analytics),
                jacksonTypeRef<CommunityAnalytics>(),
            )

        assertThat(roundtrippedAnalytics).isEqualTo(analytics)
        assertThat(analytics.toBuilder().build()).isEqualTo(analytics)
        assertThat(metrics.toBuilder().build()).isEqualTo(metrics)
        assertThat(roundtrippedAnalytics.hashCode()).isEqualTo(analytics.hashCode())
        assertThat(roundtrippedAnalytics.toString()).isEqualTo(analytics.toString())
        assertThat(roundtrippedAnalytics.metrics().hashCode()).isEqualTo(metrics.hashCode())
        assertThat(roundtrippedAnalytics.metrics().toString()).isEqualTo(metrics.toString())
        assertThat(roundtrippedAnalytics._additionalProperties())
            .containsEntry("extra", JsonValue.from("value"))
        assertThat(roundtrippedAnalytics.metrics()._additionalProperties())
            .containsEntry("extraMetric", JsonValue.from("value"))
    }

    @Test
    fun requiredFields() {
        val metric = CommunityAnalyticsMetric.builder().count(0L).changePercent(0.0).build()
        val metrics =
            CommunityAnalytics.Metrics.builder()
                .likes(metric)
                .newMembers(metric)
                .posts(metric)
                .replies(metric)
                .uniquePosters(metric)
                .build()

        assertThatThrownBy {
                CommunityAnalytics.builder()
                    .periodEndsAt(OffsetDateTime.parse("2026-10-16T23:59:59.999Z"))
                    .metrics(metrics)
                    .build()
            }
            .isInstanceOf(IllegalStateException::class.java)
        assertThatThrownBy {
                CommunityAnalytics.builder().id("1493446837214187523").metrics(metrics).build()
            }
            .isInstanceOf(IllegalStateException::class.java)
        assertThatThrownBy {
                CommunityAnalytics.builder()
                    .id("1493446837214187523")
                    .periodEndsAt(OffsetDateTime.parse("2026-10-16T23:59:59.999Z"))
                    .build()
            }
            .isInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun validationRejectsMissingMetrics() {
        val jsonMapper = jsonMapper()

        for (field in listOf("likes", "newMembers", "posts", "replies", "uniquePosters")) {
            val metrics =
                listOf("likes", "newMembers", "posts", "replies", "uniquePosters")
                    .filter { it != field }
                    .associateWith { mapOf("count" to 0L, "changePercent" to 0.0) }
            val analytics =
                jsonMapper.readValue(
                    jsonMapper.writeValueAsString(
                        mapOf(
                            "id" to "1493446837214187523",
                            "periodEndsAt" to "2026-10-16T23:59:59.999Z",
                            "metrics" to metrics,
                        )
                    ),
                    jacksonTypeRef<CommunityAnalytics>(),
                )

            assertThat(analytics.isValid()).isFalse()
            assertThatThrownBy { analytics.validate() }
                .isInstanceOf(XTwitterScraperInvalidDataException::class.java)
        }
    }
}
