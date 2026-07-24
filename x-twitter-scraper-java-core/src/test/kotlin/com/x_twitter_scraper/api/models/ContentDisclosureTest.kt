// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContentDisclosureTest {

    @Test
    fun create() {
        val contentDisclosure =
            ContentDisclosure.builder()
                .advertising(ContentDisclosure.Advertising.builder().isPaidPromotion(true).build())
                .aiGenerated(
                    ContentDisclosure.AiGenerated.builder()
                        .canEdit(true)
                        .detectionSource("UserDeclared")
                        .hasAiGeneratedMedia(true)
                        .build()
                )
                .build()

        assertThat(contentDisclosure.advertising())
            .contains(ContentDisclosure.Advertising.builder().isPaidPromotion(true).build())
        assertThat(contentDisclosure.aiGenerated())
            .contains(
                ContentDisclosure.AiGenerated.builder()
                    .canEdit(true)
                    .detectionSource("UserDeclared")
                    .hasAiGeneratedMedia(true)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contentDisclosure =
            ContentDisclosure.builder()
                .advertising(ContentDisclosure.Advertising.builder().isPaidPromotion(true).build())
                .aiGenerated(
                    ContentDisclosure.AiGenerated.builder()
                        .canEdit(true)
                        .detectionSource("UserDeclared")
                        .hasAiGeneratedMedia(true)
                        .build()
                )
                .build()

        val roundtrippedContentDisclosure =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contentDisclosure),
                jacksonTypeRef<ContentDisclosure>(),
            )

        assertThat(roundtrippedContentDisclosure).isEqualTo(contentDisclosure)
    }
}
