// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExtractionRunParamsTest {

    @Test
    fun create() {
        ExtractionRunParams.builder()
            .toolType(ExtractionRunParams.ToolType.ARTICLE_EXTRACTOR)
            .advancedQuery("advancedQuery")
            .exactPhrase("exactPhrase")
            .excludeWords("excludeWords")
            .searchQuery("searchQuery")
            .targetCommunityId("targetCommunityId")
            .targetListId("targetListId")
            .targetSpaceId("targetSpaceId")
            .targetTweetId("targetTweetId")
            .targetUsername("targetUsername")
            .build()
    }

    @Test
    fun body() {
        val params =
            ExtractionRunParams.builder()
                .toolType(ExtractionRunParams.ToolType.ARTICLE_EXTRACTOR)
                .advancedQuery("advancedQuery")
                .exactPhrase("exactPhrase")
                .excludeWords("excludeWords")
                .searchQuery("searchQuery")
                .targetCommunityId("targetCommunityId")
                .targetListId("targetListId")
                .targetSpaceId("targetSpaceId")
                .targetTweetId("targetTweetId")
                .targetUsername("targetUsername")
                .build()

        val body = params._body()

        assertThat(body.toolType()).isEqualTo(ExtractionRunParams.ToolType.ARTICLE_EXTRACTOR)
        assertThat(body.advancedQuery()).contains("advancedQuery")
        assertThat(body.exactPhrase()).contains("exactPhrase")
        assertThat(body.excludeWords()).contains("excludeWords")
        assertThat(body.searchQuery()).contains("searchQuery")
        assertThat(body.targetCommunityId()).contains("targetCommunityId")
        assertThat(body.targetListId()).contains("targetListId")
        assertThat(body.targetSpaceId()).contains("targetSpaceId")
        assertThat(body.targetTweetId()).contains("targetTweetId")
        assertThat(body.targetUsername()).contains("targetUsername")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ExtractionRunParams.builder()
                .toolType(ExtractionRunParams.ToolType.ARTICLE_EXTRACTOR)
                .build()

        val body = params._body()

        assertThat(body.toolType()).isEqualTo(ExtractionRunParams.ToolType.ARTICLE_EXTRACTOR)
    }
}
