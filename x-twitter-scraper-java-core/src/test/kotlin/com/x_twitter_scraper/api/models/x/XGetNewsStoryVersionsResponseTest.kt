// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XGetNewsStoryVersionsResponseTest {

    @Test
    fun create() {
        val xGetNewsStoryVersionsResponse =
            XGetNewsStoryVersionsResponse.builder()
                .count(1L)
                .id("2110209733533598095")
                .addVersion(
                    XGetNewsStoryVersionsResponse.Version.builder()
                        .createdAt(OffsetDateTime.parse("2026-10-14T03:30:42.536Z"))
                        .headline(
                            "Elon Musk Pushes Starlink for India's Remote Areas Amid Regulatory Hurdles"
                        )
                        .id("2110211669641105725")
                        .text(
                            "Musk has accused Reliance Industries' Mukesh Ambani of blocking Starlink's entry to protect local telecom giants like Jio, while India's government insists on equal treatment for all applicants, including ongoing security reviews. In Vietnam, Starlink already provides free internet to isolated spots for tourism and disaster response, highlighting its potential for hard-to-reach areas. Yet challengers note India's cheap mobile data from Jio and Airtel covers most needs, raising questions on pricing and national security as Starlink seeks final clearances."
                        )
                        .build()
                )
                .build()

        assertThat(xGetNewsStoryVersionsResponse.count()).isEqualTo(1L)
        assertThat(xGetNewsStoryVersionsResponse.id()).isEqualTo("2110209733533598095")
        assertThat(xGetNewsStoryVersionsResponse.versions())
            .containsExactly(
                XGetNewsStoryVersionsResponse.Version.builder()
                    .createdAt(OffsetDateTime.parse("2026-10-14T03:30:42.536Z"))
                    .headline(
                        "Elon Musk Pushes Starlink for India's Remote Areas Amid Regulatory Hurdles"
                    )
                    .id("2110211669641105725")
                    .text(
                        "Musk has accused Reliance Industries' Mukesh Ambani of blocking Starlink's entry to protect local telecom giants like Jio, while India's government insists on equal treatment for all applicants, including ongoing security reviews. In Vietnam, Starlink already provides free internet to isolated spots for tourism and disaster response, highlighting its potential for hard-to-reach areas. Yet challengers note India's cheap mobile data from Jio and Airtel covers most needs, raising questions on pricing and national security as Starlink seeks final clearances."
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val xGetNewsStoryVersionsResponse =
            XGetNewsStoryVersionsResponse.builder()
                .count(1L)
                .id("2110209733533598095")
                .addVersion(
                    XGetNewsStoryVersionsResponse.Version.builder()
                        .createdAt(OffsetDateTime.parse("2026-10-14T03:30:42.536Z"))
                        .headline(
                            "Elon Musk Pushes Starlink for India's Remote Areas Amid Regulatory Hurdles"
                        )
                        .id("2110211669641105725")
                        .text(
                            "Musk has accused Reliance Industries' Mukesh Ambani of blocking Starlink's entry to protect local telecom giants like Jio, while India's government insists on equal treatment for all applicants, including ongoing security reviews. In Vietnam, Starlink already provides free internet to isolated spots for tourism and disaster response, highlighting its potential for hard-to-reach areas. Yet challengers note India's cheap mobile data from Jio and Airtel covers most needs, raising questions on pricing and national security as Starlink seeks final clearances."
                        )
                        .build()
                )
                .build()

        val roundtrippedXGetNewsStoryVersionsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(xGetNewsStoryVersionsResponse),
                jacksonTypeRef<XGetNewsStoryVersionsResponse>(),
            )

        assertThat(roundtrippedXGetNewsStoryVersionsResponse)
            .isEqualTo(xGetNewsStoryVersionsResponse)
    }
}
