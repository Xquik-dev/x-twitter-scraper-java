// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TweetGetInsightsResponseTest {

    @Test
    fun create() {
        val tweetGetInsightsResponse =
            TweetGetInsightsResponse.builder()
                .insights(
                    TweetGetInsightsResponse.Insights.builder()
                        .ageHours(133.88)
                        .amplification(0.0964)
                        .authorId("11348282")
                        .authorUserName("NASA")
                        .conversation(0.0229)
                        .createdAt(OffsetDateTime.parse("2026-09-23T22:07:23.000Z"))
                        .engagementPerView(0.7839)
                        .engagementRate(0.011)
                        .engagements(10122.0)
                        .engagementsPerHour(75.605)
                        .metrics(
                            TweetGetInsightsResponse.Insights.Metrics.builder()
                                .bookmarks(661.0)
                                .likes(9043.0)
                                .quotes(100.0)
                                .replies(207.0)
                                .reposts(772.0)
                                .views(1291231.0)
                                .build()
                        )
                        .tweetId("2102882545427714266")
                        .build()
                )
                .build()

        assertThat(tweetGetInsightsResponse.insights())
            .isEqualTo(
                TweetGetInsightsResponse.Insights.builder()
                    .ageHours(133.88)
                    .amplification(0.0964)
                    .authorId("11348282")
                    .authorUserName("NASA")
                    .conversation(0.0229)
                    .createdAt(OffsetDateTime.parse("2026-09-23T22:07:23.000Z"))
                    .engagementPerView(0.7839)
                    .engagementRate(0.011)
                    .engagements(10122.0)
                    .engagementsPerHour(75.605)
                    .metrics(
                        TweetGetInsightsResponse.Insights.Metrics.builder()
                            .bookmarks(661.0)
                            .likes(9043.0)
                            .quotes(100.0)
                            .replies(207.0)
                            .reposts(772.0)
                            .views(1291231.0)
                            .build()
                    )
                    .tweetId("2102882545427714266")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tweetGetInsightsResponse =
            TweetGetInsightsResponse.builder()
                .insights(
                    TweetGetInsightsResponse.Insights.builder()
                        .ageHours(133.88)
                        .amplification(0.0964)
                        .authorId("11348282")
                        .authorUserName("NASA")
                        .conversation(0.0229)
                        .createdAt(OffsetDateTime.parse("2026-09-23T22:07:23.000Z"))
                        .engagementPerView(0.7839)
                        .engagementRate(0.011)
                        .engagements(10122.0)
                        .engagementsPerHour(75.605)
                        .metrics(
                            TweetGetInsightsResponse.Insights.Metrics.builder()
                                .bookmarks(661.0)
                                .likes(9043.0)
                                .quotes(100.0)
                                .replies(207.0)
                                .reposts(772.0)
                                .views(1291231.0)
                                .build()
                        )
                        .tweetId("2102882545427714266")
                        .build()
                )
                .build()

        val roundtrippedTweetGetInsightsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tweetGetInsightsResponse),
                jacksonTypeRef<TweetGetInsightsResponse>(),
            )

        assertThat(roundtrippedTweetGetInsightsResponse).isEqualTo(tweetGetInsightsResponse)
    }
}
