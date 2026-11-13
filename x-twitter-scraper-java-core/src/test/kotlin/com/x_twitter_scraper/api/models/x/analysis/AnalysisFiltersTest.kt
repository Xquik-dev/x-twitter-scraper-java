// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.analysis

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AnalysisFiltersTest {

    private val page =
        """{"analysisSummary":{},"has_next_page":false,"next_cursor":"","results":[],"unanalyzed":[],"topicFilter":{"topic":"rust","question":"Is this post about rust?","cutoff":0.5,"checked":4,"kept":1,"unchecked":[]},"imageFilter":{"imageShows":"charts","question":"Does a picture attached to this post show a chart?","cutoff":0.5,"checked":4,"kept":2,"unchecked":[]}}"""

    @Test
    fun everyAnalysisReadSendsTopicAndImageShows() {
        val bodies =
            listOf(
                AnalysisBrandParams.builder().topic("rust").imageShows("charts").build()._body(),
                AnalysisClassifyParams.builder().topic("rust").imageShows("charts").build()._body(),
                AnalysisMarketSignalsParams.builder()
                    .topic("rust")
                    .imageShows("charts")
                    .build()
                    ._body(),
                AnalysisNewsParams.builder().topic("rust").imageShows("charts").build()._body(),
                AnalysisSentimentParams.builder()
                    .topic("rust")
                    .imageShows("charts")
                    .build()
                    ._body(),
                AnalysisViralScoreParams.builder()
                    .topic("rust")
                    .imageShows("charts")
                    .build()
                    ._body(),
            )

        for (body in bodies) {
            val json = jsonMapper().readTree(jsonMapper().writeValueAsString(body))
            assertThat(json.get("topic").asText()).isEqualTo("rust")
            assertThat(json.get("imageShows").asText()).isEqualTo("charts")
        }
    }

    @Test
    fun analysisParamsReadTopicAndImageShowsBack() {
        val params = AnalysisBrandParams.builder().topic("rust").imageShows("charts").build()

        assertThat(params.topic()).contains("rust")
        assertThat(params.imageShows()).contains("charts")
        assertThat(params._topic().asKnown()).contains("rust")
        assertThat(params._imageShows().asKnown()).contains("charts")
        assertThat(params.toBuilder().build()).isEqualTo(params)
    }

    @Test
    fun everyAnalysisResponseReadsTheTopicAndImageFilters() {
        val brand = jsonMapper().readValue(page, jacksonTypeRef<AnalysisBrandResponse>())
        val classify = jsonMapper().readValue(page, jacksonTypeRef<AnalysisClassifyResponse>())
        val market = jsonMapper().readValue(page, jacksonTypeRef<AnalysisMarketSignalsResponse>())
        val news = jsonMapper().readValue(page, jacksonTypeRef<AnalysisNewsResponse>())
        val sentiment = jsonMapper().readValue(page, jacksonTypeRef<AnalysisSentimentResponse>())
        val viral = jsonMapper().readValue(page, jacksonTypeRef<AnalysisViralScoreResponse>())

        assertThat(
                listOf(
                    brand.topicFilter().get().kept() to brand.imageFilter().get().kept(),
                    classify.topicFilter().get().kept() to classify.imageFilter().get().kept(),
                    market.topicFilter().get().kept() to market.imageFilter().get().kept(),
                    news.topicFilter().get().kept() to news.imageFilter().get().kept(),
                    sentiment.topicFilter().get().kept() to sentiment.imageFilter().get().kept(),
                    viral.topicFilter().get().kept() to viral.imageFilter().get().kept(),
                )
            )
            .containsOnly(1L to 2L)
        assertThat(brand._topicFilter().asKnown().get().topic()).isEqualTo("rust")
        assertThat(brand._imageFilter().asKnown().get().imageShows()).isEqualTo("charts")
        assertThat(brand.toBuilder().build()).isEqualTo(brand)
        assertThat(classify.toBuilder().build()).isEqualTo(classify)
        assertThat(market.toBuilder().build()).isEqualTo(market)
        assertThat(news.toBuilder().build()).isEqualTo(news)
        assertThat(sentiment.toBuilder().build()).isEqualTo(sentiment)
        assertThat(viral.toBuilder().build()).isEqualTo(viral)
        assertThat(
                jsonMapper()
                    .readValue(
                        jsonMapper().writeValueAsString(brand),
                        jacksonTypeRef<AnalysisBrandResponse>(),
                    )
            )
            .isEqualTo(brand)
    }
}
