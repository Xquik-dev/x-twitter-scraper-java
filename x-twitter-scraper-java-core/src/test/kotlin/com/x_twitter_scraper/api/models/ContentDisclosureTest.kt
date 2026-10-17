// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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

    @Test
    fun readsEveryFieldTheSpecDescribes() {
        val contentDisclosure =
            jsonMapper()
                .readValue(
                    """
                    {
                      "advertising": {
                        "isPaidPromotion": true
                      },
                      "aiGenerated": {
                        "detectionSource": "GrokSignature",
                        "hasAiGeneratedMedia": true
                      }
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<ContentDisclosure>(),
                )

        contentDisclosure.validate()
        assertThat(contentDisclosure.advertising().get().isPaidPromotion()).contains(true)
        assertThat(contentDisclosure.advertising().get()._additionalProperties()).isEmpty()
        assertThat(contentDisclosure.aiGenerated().get().detectionSource())
            .contains("GrokSignature")
        assertThat(contentDisclosure.aiGenerated().get().hasAiGeneratedMedia()).contains(true)
        assertThat(contentDisclosure.aiGenerated().get()._additionalProperties()).isEmpty()
        assertThat(contentDisclosure._additionalProperties()).isEmpty()
    }
}
