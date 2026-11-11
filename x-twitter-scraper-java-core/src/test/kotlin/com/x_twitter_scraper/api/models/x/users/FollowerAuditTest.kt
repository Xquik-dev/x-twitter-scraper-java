// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FollowerAuditTest {

    @Test
    fun create() {
        val followerAudit = buildFollowerAudit()

        assertThat(followerAudit.account()).isEqualTo(account)
        assertThat(followerAudit.coverage().percent()).isEqualTo(0.0002)
        assertThat(followerAudit.coverage().read()).isEqualTo(200L)
        assertThat(followerAudit.coverage().total()).isEqualTo(92376187L)
        assertThat(followerAudit.quality().grade()).isEqualTo(FollowerAudit.Quality.Grade.B)
        assertThat(followerAudit.quality().score()).isEqualTo(71L)
        assertThat(followerAudit.classes().single().class_()).isEqualTo(FollowerClass.LIKELY_REAL)
        assertThat(followerAudit.classes().single().count()).isEqualTo(122L)
        assertThat(followerAudit.classes().single().percent()).isEqualTo(61.0)
        assertThat(followerAudit.signals().single().id()).isEqualTo("defaultPicture")
        assertThat(followerAudit.signals().single().count()).isEqualTo(36L)
        assertThat(followerAudit.signals().single().percent()).isEqualTo(18.0)
        assertThat(followerAudit.signals().single().points()).isEqualTo(2L)
        assertThat(followerAudit.arrivalBands().single().count()).isEqualTo(13L)
        assertThat(followerAudit.arrivalBands().single().from()).isEqualTo(1L)
        assertThat(followerAudit.arrivalBands().single().percent()).isEqualTo(13.0)
        assertThat(followerAudit.arrivalBands().single().read()).isEqualTo(100L)
        assertThat(followerAudit.arrivalBands().single().to()).isEqualTo(100L)
        assertThat(followerAudit.cohorts().single().count()).isEqualTo(7L)
        assertThat(followerAudit.cohorts().single().likelyFake()).isEqualTo(6L)
        assertThat(followerAudit.cohorts().single().percent()).isEqualTo(3.5)
        assertThat(followerAudit.cohorts().single().weekStartMs()).isEqualTo(1761523200000L)
        assertThat(followerAudit.languages().single().count()).isEqualTo(141L)
        assertThat(followerAudit.languages().single().percent()).isEqualTo(70.5)
        assertThat(followerAudit.languages().single().value()).isEqualTo("en")
        assertThat(followerAudit.places().single().value()).isEqualTo("United States")
        assertThat(followerAudit.verified().count()).isEqualTo(9L)
        assertThat(followerAudit.verified().percent()).isEqualTo(4.5)
        val follower = followerAudit.followers().single()
        assertThat(follower.class_()).isEqualTo(FollowerClass.AUTOMATED)
        assertThat(follower.followers()).isEqualTo(312L)
        assertThat(follower.following()).isEqualTo(410L)
        assertThat(follower.id()).isEqualTo("1852412278803021824")
        assertThat(follower.likes()).isEqualTo(2840L)
        assertThat(follower.name()).isEqualTo("Orbit Watcher")
        assertThat(follower.position()).isEqualTo(1L)
        assertThat(follower.posts()).isEqualTo(1290L)
        assertThat(follower.score()).isEqualTo(5L)
        assertThat(follower.signals()).containsExactly("noBanner", "noBio")
        assertThat(follower.userName()).isEqualTo("orbit_watcher")
        assertThat(follower.joinedAtMs()).contains(1561939200000L)
        assertThat(follower.owner()).contains("NASA")
        assertThat(follower.pictureUrl())
            .contains("https://pbs.twimg.com/profile_images/1/photo.jpg")
        assertThat(followerAudit.topFollowers()).containsExactly(follower)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val followerAudit = buildFollowerAudit()

        val roundtrippedFollowerAudit =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(followerAudit),
                jacksonTypeRef<FollowerAudit>(),
            )

        assertThat(roundtrippedFollowerAudit).isEqualTo(followerAudit)
        assertThat(roundtrippedFollowerAudit.hashCode()).isEqualTo(followerAudit.hashCode())
        assertThat(roundtrippedFollowerAudit.isValid()).isTrue()
    }

    @Test
    fun toBuilderKeepsEveryField() {
        val followerAudit = buildFollowerAudit()

        val rebuilt = followerAudit.toBuilder().build()

        assertThat(rebuilt).isEqualTo(followerAudit)
        assertThat(rebuilt.toString()).isEqualTo(followerAudit.toString())
        assertThat(followerAudit.toBuilder().addPlace(place).build().places())
            .containsExactly(place, place)
    }

    companion object {

        private val account =
            UserRetrieveInsightsResponse.Insights.builder()
                .accountAgeDays(6449.0)
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
                .engagementPerView(0.55)
                .engagementRate(0.0047)
                .medianViews(512330.0)
                .followers(92376187.0)
                .following(180.0)
                .posts(73919.0)
                .postsPerDay(3.8)
                .postsPrivate(false)
                .sample(
                    UserRetrieveInsightsResponse.Insights.Sample.builder()
                        .newestAt(OffsetDateTime.parse("2026-11-02T22:12:05.000Z"))
                        .oldestAt(OffsetDateTime.parse("2026-10-28T13:15:28.000Z"))
                        .posts(20.0)
                        .read(22.0)
                        .build()
                )
                .topPostId("1852301447063109847")
                .userId("11348282")
                .userName("NASA")
                .build()

        private val place =
            FollowerAudit.FollowerValueCount.builder()
                .count(22L)
                .percent(11.0)
                .value("United States")
                .build()

        private fun buildFollowerAudit(): FollowerAudit {
            val follower =
                FollowerAudit.AuditedFollower.builder()
                    .class_(FollowerClass.AUTOMATED)
                    .followers(312L)
                    .following(410L)
                    .id("1852412278803021824")
                    .likes(2840L)
                    .name("Orbit Watcher")
                    .position(1L)
                    .posts(1290L)
                    .score(5L)
                    .addSignal("noBanner")
                    .addSignal("noBio")
                    .userName("orbit_watcher")
                    .joinedAtMs(1561939200000L)
                    .owner("NASA")
                    .pictureUrl("https://pbs.twimg.com/profile_images/1/photo.jpg")
                    .build()
            return FollowerAudit.builder()
                .account(account)
                .coverage(
                    FollowerAudit.Coverage.builder()
                        .percent(0.0002)
                        .read(200L)
                        .total(92376187L)
                        .build()
                )
                .quality(
                    FollowerAudit.Quality.builder()
                        .grade(FollowerAudit.Quality.Grade.B)
                        .score(71L)
                        .build()
                )
                .addClass(
                    FollowerAudit.ClassCount.builder()
                        .class_(FollowerClass.LIKELY_REAL)
                        .count(122L)
                        .percent(61.0)
                        .build()
                )
                .addSignal(
                    FollowerAudit.Signal.builder()
                        .count(36L)
                        .id("defaultPicture")
                        .percent(18.0)
                        .points(2L)
                        .build()
                )
                .addArrivalBand(
                    FollowerAudit.ArrivalBand.builder()
                        .count(13L)
                        .from(1L)
                        .percent(13.0)
                        .read(100L)
                        .to(100L)
                        .build()
                )
                .addCohort(
                    FollowerAudit.Cohort.builder()
                        .count(7L)
                        .likelyFake(6L)
                        .percent(3.5)
                        .weekStartMs(1761523200000L)
                        .build()
                )
                .languages(
                    listOf(
                        FollowerAudit.FollowerValueCount.builder()
                            .count(141L)
                            .percent(70.5)
                            .value("en")
                            .build()
                    )
                )
                .addPlace(place)
                .verified(FollowerAudit.Verified.builder().count(9L).percent(4.5).build())
                .addFollower(follower)
                .topFollowers(listOf(follower))
                .build()
        }
    }
}
