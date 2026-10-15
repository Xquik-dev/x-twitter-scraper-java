// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetTrendsResponseTest {

    @Test
    fun create() {
        val xGetTrendsResponse =
            XGetTrendsResponse.builder()
                .count(30L)
                .addTrend(
                    XGetTrendsResponse.Trend.builder()
                        .name("#AI")
                        .description("Artificial intelligence discussions")
                        .promotedContent(null)
                        .query("%23AI")
                        .rank(1L)
                        .tweetVolume(250000L)
                        .url("https://x.com/search?q=%23AI")
                        .build()
                )
                .woeid(1L)
                .capturedAt(OffsetDateTime.parse("2026-10-13T14:00:26.000Z"))
                .location(
                    XGetTrendsResponse.Location.builder()
                        .country("Turkey")
                        .countryCode("TR")
                        .name("Istanbul")
                        .parentWoeid(23424969L)
                        .placeType("Town")
                        .placeTypeCode(7L)
                        .url("http://where.yahooapis.com/v1/place/2344116")
                        .woeid(2344116L)
                        .build()
                )
                .requestedAt(OffsetDateTime.parse("2026-10-13T14:00:00.000Z"))
                .build()

        assertThat(xGetTrendsResponse.count()).isEqualTo(30L)
        assertThat(xGetTrendsResponse.trends())
            .containsExactly(
                XGetTrendsResponse.Trend.builder()
                    .name("#AI")
                    .description("Artificial intelligence discussions")
                    .promotedContent(null)
                    .query("%23AI")
                    .rank(1L)
                    .tweetVolume(250000L)
                    .url("https://x.com/search?q=%23AI")
                    .build()
            )
        assertThat(xGetTrendsResponse.woeid()).isEqualTo(1L)
        assertThat(xGetTrendsResponse.capturedAt())
            .contains(OffsetDateTime.parse("2026-10-13T14:00:26.000Z"))
        assertThat(xGetTrendsResponse.location())
            .contains(
                XGetTrendsResponse.Location.builder()
                    .country("Turkey")
                    .countryCode("TR")
                    .name("Istanbul")
                    .parentWoeid(23424969L)
                    .placeType("Town")
                    .placeTypeCode(7L)
                    .url("http://where.yahooapis.com/v1/place/2344116")
                    .woeid(2344116L)
                    .build()
            )
        assertThat(xGetTrendsResponse.requestedAt())
            .contains(OffsetDateTime.parse("2026-10-13T14:00:00.000Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xGetTrendsResponse =
            XGetTrendsResponse.builder()
                .count(30L)
                .addTrend(
                    XGetTrendsResponse.Trend.builder()
                        .name("#AI")
                        .description("Artificial intelligence discussions")
                        .promotedContent(null)
                        .query("%23AI")
                        .rank(1L)
                        .tweetVolume(250000L)
                        .url("https://x.com/search?q=%23AI")
                        .build()
                )
                .woeid(1L)
                .capturedAt(OffsetDateTime.parse("2026-10-13T14:00:26.000Z"))
                .location(
                    XGetTrendsResponse.Location.builder()
                        .country("Turkey")
                        .countryCode("TR")
                        .name("Istanbul")
                        .parentWoeid(23424969L)
                        .placeType("Town")
                        .placeTypeCode(7L)
                        .url("http://where.yahooapis.com/v1/place/2344116")
                        .woeid(2344116L)
                        .build()
                )
                .requestedAt(OffsetDateTime.parse("2026-10-13T14:00:00.000Z"))
                .build()

        val roundtrippedXGetTrendsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(xGetTrendsResponse),
                jacksonTypeRef<XGetTrendsResponse>(),
            )

        assertThat(roundtrippedXGetTrendsResponse).isEqualTo(xGetTrendsResponse)
    }
}
