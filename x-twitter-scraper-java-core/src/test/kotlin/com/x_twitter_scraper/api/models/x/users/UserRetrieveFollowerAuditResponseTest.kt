// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRetrieveFollowerAuditResponseTest {

    @Test
    fun create() {
        val userRetrieveFollowerAuditResponse =
            UserRetrieveFollowerAuditResponse.builder().audit(audit).build()

        assertThat(userRetrieveFollowerAuditResponse.audit()).isEqualTo(audit)
        assertThat(userRetrieveFollowerAuditResponse.audit().account().averages()).isEmpty()
        assertThat(userRetrieveFollowerAuditResponse.audit().followers()).isEmpty()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userRetrieveFollowerAuditResponse =
            UserRetrieveFollowerAuditResponse.builder().audit(audit).build()

        val roundtrippedUserRetrieveFollowerAuditResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userRetrieveFollowerAuditResponse),
                jacksonTypeRef<UserRetrieveFollowerAuditResponse>(),
            )

        assertThat(roundtrippedUserRetrieveFollowerAuditResponse)
            .isEqualTo(userRetrieveFollowerAuditResponse)
        assertThat(roundtrippedUserRetrieveFollowerAuditResponse.isValid()).isTrue()
    }

    @Test
    fun aResponseWithoutTheAuditFailsValidation() {
        val response =
            jsonMapper().readValue("{}", jacksonTypeRef<UserRetrieveFollowerAuditResponse>())

        assertThat(response.isValid()).isFalse()
    }

    companion object {

        private val audit =
            FollowerAudit.builder()
                .account(
                    UserRetrieveInsightsResponse.Insights.builder()
                        .accountAgeDays(null)
                        .averages(null)
                        .engagementPerView(null)
                        .engagementRate(null)
                        .medianViews(null)
                        .followers(12.0)
                        .following(3.0)
                        .posts(0.0)
                        .postsPerDay(null)
                        .postsPrivate(true)
                        .sample(
                            UserRetrieveInsightsResponse.Insights.Sample.builder()
                                .newestAt(null)
                                .oldestAt(null)
                                .posts(0.0)
                                .build()
                        )
                        .topPostId(null)
                        .userId("11348282")
                        .userName("NASA")
                        .build()
                )
                .coverage(FollowerAudit.Coverage.builder().percent(0.0).read(0L).total(12L).build())
                .quality(
                    FollowerAudit.Quality.builder()
                        .grade(FollowerAudit.Quality.Grade.F)
                        .score(0L)
                        .build()
                )
                .classes(listOf<FollowerAudit.ClassCount>())
                .signals(listOf<FollowerAudit.Signal>())
                .arrivalBands(listOf<FollowerAudit.ArrivalBand>())
                .cohorts(listOf<FollowerAudit.Cohort>())
                .languages(listOf<FollowerAudit.FollowerValueCount>())
                .places(listOf<FollowerAudit.FollowerValueCount>())
                .verified(FollowerAudit.Verified.builder().count(0L).percent(0.0).build())
                .followers(listOf<FollowerAudit.AuditedFollower>())
                .topFollowers(listOf<FollowerAudit.AuditedFollower>())
                .build()
    }
}
