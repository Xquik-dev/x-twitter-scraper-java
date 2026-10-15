// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetHashflagsResponseTest {

    @Test
    fun create() {
        val xGetHashflagsResponse =
            XGetHashflagsResponse.builder()
                .count(1L)
                .addHashflag(
                    XGetHashflagsResponse.Hashflag.builder()
                        .addAnimation(
                            XGetHashflagsResponse.Hashflag.Animation.builder()
                                .assetUrl(
                                    "https://abs.twimg.com/hashflags/2026FootballCustomLikeEvergreenv3/2026FootballCustomLikeEvergreenv3_sakura_0.json"
                                )
                                .context("Like")
                                .priority(1.0)
                                .build()
                        )
                        .assetUrl(
                            "https://abs.twimg.com/hashflags/BF-16692_AIon2_jp_Hashmoji_v3/BF-16692_AIon2_jp_Hashmoji_v3.png"
                        )
                        .endsAt(OffsetDateTime.parse("2027-01-03T14:59:00.000Z"))
                        .hashtag("AION2")
                        .isHashfettiEnabled(false)
                        .startsAt(OffsetDateTime.parse("2026-10-02T10:00:00.000Z"))
                        .build()
                )
                .total(1L)
                .message("No hashflag runs now. Send activeOnly=false to list the rest.")
                .build()

        assertThat(xGetHashflagsResponse.count()).isEqualTo(1L)
        assertThat(xGetHashflagsResponse.hashflags())
            .containsExactly(
                XGetHashflagsResponse.Hashflag.builder()
                    .addAnimation(
                        XGetHashflagsResponse.Hashflag.Animation.builder()
                            .assetUrl(
                                "https://abs.twimg.com/hashflags/2026FootballCustomLikeEvergreenv3/2026FootballCustomLikeEvergreenv3_sakura_0.json"
                            )
                            .context("Like")
                            .priority(1.0)
                            .build()
                    )
                    .assetUrl(
                        "https://abs.twimg.com/hashflags/BF-16692_AIon2_jp_Hashmoji_v3/BF-16692_AIon2_jp_Hashmoji_v3.png"
                    )
                    .endsAt(OffsetDateTime.parse("2027-01-03T14:59:00.000Z"))
                    .hashtag("AION2")
                    .isHashfettiEnabled(false)
                    .startsAt(OffsetDateTime.parse("2026-10-02T10:00:00.000Z"))
                    .build()
            )
        assertThat(xGetHashflagsResponse.total()).isEqualTo(1L)
        assertThat(xGetHashflagsResponse.message())
            .contains("No hashflag runs now. Send activeOnly=false to list the rest.")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xGetHashflagsResponse =
            XGetHashflagsResponse.builder()
                .count(1L)
                .addHashflag(
                    XGetHashflagsResponse.Hashflag.builder()
                        .addAnimation(
                            XGetHashflagsResponse.Hashflag.Animation.builder()
                                .assetUrl(
                                    "https://abs.twimg.com/hashflags/2026FootballCustomLikeEvergreenv3/2026FootballCustomLikeEvergreenv3_sakura_0.json"
                                )
                                .context("Like")
                                .priority(1.0)
                                .build()
                        )
                        .assetUrl(
                            "https://abs.twimg.com/hashflags/BF-16692_AIon2_jp_Hashmoji_v3/BF-16692_AIon2_jp_Hashmoji_v3.png"
                        )
                        .endsAt(OffsetDateTime.parse("2027-01-03T14:59:00.000Z"))
                        .hashtag("AION2")
                        .isHashfettiEnabled(false)
                        .startsAt(OffsetDateTime.parse("2026-10-02T10:00:00.000Z"))
                        .build()
                )
                .total(1L)
                .message("No hashflag runs now. Send activeOnly=false to list the rest.")
                .build()

        val roundtrippedXGetHashflagsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(xGetHashflagsResponse),
                jacksonTypeRef<XGetHashflagsResponse>(),
            )

        assertThat(roundtrippedXGetHashflagsResponse).isEqualTo(xGetHashflagsResponse)
    }
}
