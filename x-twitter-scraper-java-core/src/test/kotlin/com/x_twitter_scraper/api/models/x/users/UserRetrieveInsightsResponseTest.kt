// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveInsightsResponseTest {

    @Test
    fun create() {
        val userRetrieveInsightsResponse =
            UserRetrieveInsightsResponse.builder()
                .insights(
                    UserRetrieveInsightsResponse.Insights.builder()
                        .accountAgeDays(6858.0)
                        .averages(
                            UserRetrieveInsightsResponse.Insights.Averages.builder()
                                .bookmarks(209.7)
                                .engagements(4331.7)
                                .likes(3684.2)
                                .quotes(45.0)
                                .replies(142.7)
                                .reposts(459.8)
                                .views(785247.8)
                                .build()
                        )
                        .engagementPerView(0.5516)
                        .engagementRate(0.0047)
                        .followers(92376187.0)
                        .following(115.0)
                        .posts(74336.0)
                        .postsPerDay(1.6814)
                        .postsPrivate(false)
                        .sample(
                            UserRetrieveInsightsResponse.Insights.Sample.builder()
                                .newestAt(OffsetDateTime.parse("2026-09-28T22:12:05.000Z"))
                                .oldestAt(OffsetDateTime.parse("2026-09-23T13:15:28.000Z"))
                                .posts(10.0)
                                .build()
                        )
                        .topPostId("2102761519985332442")
                        .userId("11348282")
                        .userName("NASA")
                        .build()
                )
                .message("This account's posts are private, so the report has its counts only.")
                .build()

        assertThat(userRetrieveInsightsResponse.insights())
            .isEqualTo(
                UserRetrieveInsightsResponse.Insights.builder()
                    .accountAgeDays(6858.0)
                    .averages(
                        UserRetrieveInsightsResponse.Insights.Averages.builder()
                            .bookmarks(209.7)
                            .engagements(4331.7)
                            .likes(3684.2)
                            .quotes(45.0)
                            .replies(142.7)
                            .reposts(459.8)
                            .views(785247.8)
                            .build()
                    )
                    .engagementPerView(0.5516)
                    .engagementRate(0.0047)
                    .followers(92376187.0)
                    .following(115.0)
                    .posts(74336.0)
                    .postsPerDay(1.6814)
                    .postsPrivate(false)
                    .sample(
                        UserRetrieveInsightsResponse.Insights.Sample.builder()
                            .newestAt(OffsetDateTime.parse("2026-09-28T22:12:05.000Z"))
                            .oldestAt(OffsetDateTime.parse("2026-09-23T13:15:28.000Z"))
                            .posts(10.0)
                            .build()
                    )
                    .topPostId("2102761519985332442")
                    .userId("11348282")
                    .userName("NASA")
                    .build()
            )
        assertThat(userRetrieveInsightsResponse.message())
            .contains("This account's posts are private, so the report has its counts only.")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userRetrieveInsightsResponse =
            UserRetrieveInsightsResponse.builder()
                .insights(
                    UserRetrieveInsightsResponse.Insights.builder()
                        .accountAgeDays(6858.0)
                        .averages(
                            UserRetrieveInsightsResponse.Insights.Averages.builder()
                                .bookmarks(209.7)
                                .engagements(4331.7)
                                .likes(3684.2)
                                .quotes(45.0)
                                .replies(142.7)
                                .reposts(459.8)
                                .views(785247.8)
                                .build()
                        )
                        .engagementPerView(0.5516)
                        .engagementRate(0.0047)
                        .followers(92376187.0)
                        .following(115.0)
                        .posts(74336.0)
                        .postsPerDay(1.6814)
                        .postsPrivate(false)
                        .sample(
                            UserRetrieveInsightsResponse.Insights.Sample.builder()
                                .newestAt(OffsetDateTime.parse("2026-09-28T22:12:05.000Z"))
                                .oldestAt(OffsetDateTime.parse("2026-09-23T13:15:28.000Z"))
                                .posts(10.0)
                                .build()
                        )
                        .topPostId("2102761519985332442")
                        .userId("11348282")
                        .userName("NASA")
                        .build()
                )
                .message("This account's posts are private, so the report has its counts only.")
                .build()

        val roundtrippedUserRetrieveInsightsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userRetrieveInsightsResponse),
                jacksonTypeRef<UserRetrieveInsightsResponse>(),
            )

        assertThat(roundtrippedUserRetrieveInsightsResponse).isEqualTo(userRetrieveInsightsResponse)
    }
}
