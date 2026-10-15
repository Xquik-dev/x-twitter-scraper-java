// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetTrendsHistoryResponseTest {

    @Test
    fun create() {
        val xGetTrendsHistoryResponse =
            XGetTrendsHistoryResponse.builder()
                .count(1L)
                .fromTime(OffsetDateTime.parse("2026-10-13T00:00:00.000Z"))
                .hasNextPage(false)
                .nextCursor("")
                .addSnapshot(
                    XGetTrendsHistoryResponse.Snapshot.builder()
                        .capturedAt(OffsetDateTime.parse("2026-10-13T14:00:26.000Z"))
                        .count(1L)
                        .addTrend(
                            XGetTrendsHistoryResponse.Snapshot.Trend.builder()
                                .name("#AI")
                                .description("Artificial intelligence discussions")
                                .promotedContent(null)
                                .query("%23AI")
                                .rank(1L)
                                .tweetVolume(250000L)
                                .url("https://x.com/search?q=%23AI")
                                .build()
                        )
                        .build()
                )
                .toTime(OffsetDateTime.parse("2026-10-14T00:00:00.000Z"))
                .woeid(1L)
                .location(
                    XGetTrendsHistoryResponse.Location.builder()
                        .country("Turkey")
                        .countryCode("TR")
                        .name("Turkey")
                        .parentWoeid(1L)
                        .placeType("Country")
                        .placeTypeCode(12L)
                        .url("http://where.yahooapis.com/v1/place/23424969")
                        .woeid(23424969L)
                        .build()
                )
                .build()

        assertThat(xGetTrendsHistoryResponse.count()).isEqualTo(1L)
        assertThat(xGetTrendsHistoryResponse.fromTime())
            .isEqualTo(OffsetDateTime.parse("2026-10-13T00:00:00.000Z"))
        assertThat(xGetTrendsHistoryResponse.hasNextPage()).isEqualTo(false)
        assertThat(xGetTrendsHistoryResponse.nextCursor()).isEqualTo("")
        assertThat(xGetTrendsHistoryResponse.snapshots())
            .containsExactly(
                XGetTrendsHistoryResponse.Snapshot.builder()
                    .capturedAt(OffsetDateTime.parse("2026-10-13T14:00:26.000Z"))
                    .count(1L)
                    .addTrend(
                        XGetTrendsHistoryResponse.Snapshot.Trend.builder()
                            .name("#AI")
                            .description("Artificial intelligence discussions")
                            .promotedContent(null)
                            .query("%23AI")
                            .rank(1L)
                            .tweetVolume(250000L)
                            .url("https://x.com/search?q=%23AI")
                            .build()
                    )
                    .build()
            )
        assertThat(xGetTrendsHistoryResponse.toTime())
            .isEqualTo(OffsetDateTime.parse("2026-10-14T00:00:00.000Z"))
        assertThat(xGetTrendsHistoryResponse.woeid()).isEqualTo(1L)
        assertThat(xGetTrendsHistoryResponse.location())
            .contains(
                XGetTrendsHistoryResponse.Location.builder()
                    .country("Turkey")
                    .countryCode("TR")
                    .name("Turkey")
                    .parentWoeid(1L)
                    .placeType("Country")
                    .placeTypeCode(12L)
                    .url("http://where.yahooapis.com/v1/place/23424969")
                    .woeid(23424969L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xGetTrendsHistoryResponse =
            XGetTrendsHistoryResponse.builder()
                .count(1L)
                .fromTime(OffsetDateTime.parse("2026-10-13T00:00:00.000Z"))
                .hasNextPage(false)
                .nextCursor("")
                .addSnapshot(
                    XGetTrendsHistoryResponse.Snapshot.builder()
                        .capturedAt(OffsetDateTime.parse("2026-10-13T14:00:26.000Z"))
                        .count(1L)
                        .addTrend(
                            XGetTrendsHistoryResponse.Snapshot.Trend.builder()
                                .name("#AI")
                                .description("Artificial intelligence discussions")
                                .promotedContent(null)
                                .query("%23AI")
                                .rank(1L)
                                .tweetVolume(250000L)
                                .url("https://x.com/search?q=%23AI")
                                .build()
                        )
                        .build()
                )
                .toTime(OffsetDateTime.parse("2026-10-14T00:00:00.000Z"))
                .woeid(1L)
                .location(
                    XGetTrendsHistoryResponse.Location.builder()
                        .country("Turkey")
                        .countryCode("TR")
                        .name("Turkey")
                        .parentWoeid(1L)
                        .placeType("Country")
                        .placeTypeCode(12L)
                        .url("http://where.yahooapis.com/v1/place/23424969")
                        .woeid(23424969L)
                        .build()
                )
                .build()

        val roundtrippedXGetTrendsHistoryResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(xGetTrendsHistoryResponse),
                jacksonTypeRef<XGetTrendsHistoryResponse>(),
            )

        assertThat(roundtrippedXGetTrendsHistoryResponse).isEqualTo(xGetTrendsHistoryResponse)
    }
}
