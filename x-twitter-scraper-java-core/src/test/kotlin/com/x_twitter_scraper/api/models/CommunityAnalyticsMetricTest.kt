// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.jsonMapper
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class CommunityAnalyticsMetricTest {

    @Test
    fun create() {
        val metric =
            CommunityAnalyticsMetric.builder()
                .count(9007199254740991L)
                .changePercent(-1.2076202776880853)
                .build()

        assertThat(metric.count()).isEqualTo(9007199254740991L)
        assertThat(metric.changePercent()).isEqualTo(-1.2076202776880853)
        assertThat(metric.validate()).isSameAs(metric)
        assertThat(metric.isValid()).isTrue()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val metric =
            CommunityAnalyticsMetric.builder()
                .count(15298L)
                .changePercent(-1.2076202776880853)
                .putAdditionalProperty("extra", JsonValue.from("value"))
                .build()

        val roundtrippedMetric =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(metric),
                jacksonTypeRef<CommunityAnalyticsMetric>(),
            )

        assertThat(roundtrippedMetric).isEqualTo(metric)
        assertThat(metric.toBuilder().build()).isEqualTo(metric)
        assertThat(roundtrippedMetric.hashCode()).isEqualTo(metric.hashCode())
        assertThat(roundtrippedMetric.toString()).isEqualTo(metric.toString())
        assertThat(roundtrippedMetric._additionalProperties())
            .containsEntry("extra", JsonValue.from("value"))
    }

    @Test
    fun requiredFields() {
        assertThatThrownBy { CommunityAnalyticsMetric.builder().changePercent(0.0).build() }
            .isInstanceOf(IllegalStateException::class.java)
        assertThatThrownBy { CommunityAnalyticsMetric.builder().count(0L).build() }
            .isInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun invalidField() {
        val metric =
            CommunityAnalyticsMetric.builder()
                .count(0L)
                .changePercent(JsonValue.from("unexpected"))
                .build()

        assertThat(metric._changePercent()).isEqualTo(JsonValue.from("unexpected"))
        assertThat(metric.isValid()).isFalse()
        assertThatThrownBy { metric.changePercent() }
            .isInstanceOf(XTwitterScraperInvalidDataException::class.java)
    }
}
