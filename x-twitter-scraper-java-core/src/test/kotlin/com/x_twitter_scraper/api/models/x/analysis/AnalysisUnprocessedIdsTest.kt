// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.analysis

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AnalysisUnprocessedIdsTest {

    private val page =
        """{"analysisSummary":{},"has_next_page":false,"next_cursor":"","results":[],"unanalyzed":[]"""

    private inline fun <reified T> read(json: String): T =
        jsonMapper().readValue(json, jacksonTypeRef<T>())

    private fun unprocessedIds(ending: String): List<Optional<List<String>>> =
        listOf(
            read<AnalysisBrandResponse>(page + ending).unprocessedIds(),
            read<AnalysisClassifyResponse>(page + ending).unprocessedIds(),
            read<AnalysisMarketSignalsResponse>(page + ending).unprocessedIds(),
            read<AnalysisNewsResponse>(page + ending).unprocessedIds(),
            read<AnalysisSentimentResponse>(page + ending).unprocessedIds(),
            read<AnalysisViralScoreResponse>(page + ending).unprocessedIds(),
        )

    @Test
    fun everyAnalysisResponseNamesThePostsTheTimeRanOutFor() {
        assertThat(unprocessedIds(""","unprocessed_ids":["2102882545427714266","draft-2"]}"""))
            .containsOnly(Optional.of(listOf("2102882545427714266", "draft-2")))
    }

    @Test
    fun anAnalysisThatFinishedEveryPostHasNoUnprocessedIds() {
        assertThat(unprocessedIds(""","unprocessed_ids":[]}""")).containsOnly(Optional.of(listOf()))
        assertThat(unprocessedIds("}")).containsOnly(Optional.empty())
    }

    @Test
    fun unprocessedIdsSurviveTheBuilderAndJson() {
        val response =
            read<AnalysisSentimentResponse>("$page}")
                .toBuilder()
                .unprocessedIds(listOf("2102882545427714266"))
                .addUnprocessedId("draft-2")
                .build()

        assertThat(response.unprocessedIds()).contains(listOf("2102882545427714266", "draft-2"))
        assertThat(response._unprocessedIds().asKnown())
            .contains(listOf("2102882545427714266", "draft-2"))
        assertThat(read<AnalysisSentimentResponse>(jsonMapper().writeValueAsString(response)))
            .isEqualTo(response)
        assertThat(
                jsonMapper()
                    .readTree(jsonMapper().writeValueAsString(response))
                    .get("unprocessed_ids")
                    .map { it.asText() }
            )
            .containsExactly("2102882545427714266", "draft-2")
        assertThat(response.toString()).contains("unprocessedIds=[2102882545427714266, draft-2]")
    }
}
