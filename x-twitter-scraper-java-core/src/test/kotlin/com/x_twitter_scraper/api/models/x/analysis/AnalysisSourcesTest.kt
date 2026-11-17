// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.analysis

import com.fasterxml.jackson.databind.JsonNode
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AnalysisSourcesTest {

    private fun json(body: Any): JsonNode =
        jsonMapper().readTree(jsonMapper().writeValueAsString(body))

    private fun JsonNode.texts(name: String): List<String> = get(name).map { it.asText() }

    @Test
    fun everyAnalysisReadSendsTheSingleAccountAndPostSources() {
        val bodies =
            listOf(
                AnalysisBrandParams.builder()
                    .threadOf("2102882545427714266")
                    .repliesBy("@NASA")
                    .mediaBy("@ESA")
                    .likedBy("@SpaceX")
                    .build()
                    ._body(),
                AnalysisClassifyParams.builder()
                    .threadOf("2102882545427714266")
                    .repliesBy("@NASA")
                    .mediaBy("@ESA")
                    .likedBy("@SpaceX")
                    .build()
                    ._body(),
                AnalysisMarketSignalsParams.builder()
                    .threadOf("2102882545427714266")
                    .repliesBy("@NASA")
                    .mediaBy("@ESA")
                    .likedBy("@SpaceX")
                    .build()
                    ._body(),
                AnalysisNewsParams.builder()
                    .threadOf("2102882545427714266")
                    .repliesBy("@NASA")
                    .mediaBy("@ESA")
                    .likedBy("@SpaceX")
                    .build()
                    ._body(),
                AnalysisSentimentParams.builder()
                    .threadOf("2102882545427714266")
                    .repliesBy("@NASA")
                    .mediaBy("@ESA")
                    .likedBy("@SpaceX")
                    .build()
                    ._body(),
                AnalysisViralScoreParams.builder()
                    .threadOf("2102882545427714266")
                    .repliesBy("@NASA")
                    .mediaBy("@ESA")
                    .likedBy("@SpaceX")
                    .build()
                    ._body(),
            )

        for (body in bodies.map(::json)) {
            assertThat(body.get("threadOf").asText()).isEqualTo("2102882545427714266")
            assertThat(body.get("repliesBy").asText()).isEqualTo("@NASA")
            assertThat(body.get("mediaBy").asText()).isEqualTo("@ESA")
            assertThat(body.get("likedBy").asText()).isEqualTo("@SpaceX")
        }
    }

    @Test
    fun everyAnalysisReadSendsSeveralAccountsListsAndSearches() {
        val bodies =
            listOf(
                AnalysisBrandParams.builder()
                    .usernames(listOf("@NASA"))
                    .addUsername("@ESA")
                    .listIds(listOf("4143408"))
                    .addListId("1970899750481260878")
                    .queries(listOf("Artemis lang:en"))
                    .addQuery("#moon")
                    .build()
                    ._body(),
                AnalysisClassifyParams.builder()
                    .usernames(listOf("@NASA"))
                    .addUsername("@ESA")
                    .listIds(listOf("4143408"))
                    .addListId("1970899750481260878")
                    .queries(listOf("Artemis lang:en"))
                    .addQuery("#moon")
                    .build()
                    ._body(),
                AnalysisMarketSignalsParams.builder()
                    .usernames(listOf("@NASA"))
                    .addUsername("@ESA")
                    .listIds(listOf("4143408"))
                    .addListId("1970899750481260878")
                    .queries(listOf("Artemis lang:en"))
                    .addQuery("#moon")
                    .build()
                    ._body(),
                AnalysisNewsParams.builder()
                    .usernames(listOf("@NASA"))
                    .addUsername("@ESA")
                    .listIds(listOf("4143408"))
                    .addListId("1970899750481260878")
                    .queries(listOf("Artemis lang:en"))
                    .addQuery("#moon")
                    .build()
                    ._body(),
                AnalysisSentimentParams.builder()
                    .usernames(listOf("@NASA"))
                    .addUsername("@ESA")
                    .listIds(listOf("4143408"))
                    .addListId("1970899750481260878")
                    .queries(listOf("Artemis lang:en"))
                    .addQuery("#moon")
                    .build()
                    ._body(),
                AnalysisViralScoreParams.builder()
                    .usernames(listOf("@NASA"))
                    .addUsername("@ESA")
                    .listIds(listOf("4143408"))
                    .addListId("1970899750481260878")
                    .queries(listOf("Artemis lang:en"))
                    .addQuery("#moon")
                    .build()
                    ._body(),
            )

        for (body in bodies.map(::json)) {
            assertThat(body.texts("usernames")).containsExactly("@NASA", "@ESA")
            assertThat(body.texts("listIds")).containsExactly("4143408", "1970899750481260878")
            assertThat(body.texts("queries")).containsExactly("Artemis lang:en", "#moon")
        }
    }

    @Test
    fun analysisParamsReadTheSourcesBack() {
        val params =
            AnalysisNewsParams.builder()
                .threadOf("2102882545427714266")
                .repliesBy("@NASA")
                .mediaBy("@ESA")
                .likedBy("@SpaceX")
                .addUsername("@NASA")
                .addListId("4143408")
                .addQuery("#moon")
                .build()

        assertThat(params.threadOf()).contains("2102882545427714266")
        assertThat(params.repliesBy()).contains("@NASA")
        assertThat(params.mediaBy()).contains("@ESA")
        assertThat(params.likedBy()).contains("@SpaceX")
        assertThat(params.usernames()).contains(listOf("@NASA"))
        assertThat(params.listIds()).contains(listOf("4143408"))
        assertThat(params.queries()).contains(listOf("#moon"))
        assertThat(params._threadOf().asKnown()).contains("2102882545427714266")
        assertThat(params._queries().asKnown()).contains(listOf("#moon"))
        assertThat(params.toBuilder().build()).isEqualTo(params)
        assertThat(AnalysisNewsParams.builder().build().threadOf()).isEmpty
        assertThat(json(AnalysisNewsParams.builder().build()._body()).has("usernames")).isFalse()
    }
}
