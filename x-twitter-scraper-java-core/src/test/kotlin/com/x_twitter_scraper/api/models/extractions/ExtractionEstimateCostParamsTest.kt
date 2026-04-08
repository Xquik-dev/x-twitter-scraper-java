// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExtractionEstimateCostParamsTest {

    @Test
    fun create() {
        ExtractionEstimateCostParams.builder()
            .toolType(ExtractionEstimateCostParams.ToolType.FOLLOWER_EXPLORER)
            .advancedQuery("min_faves:100")
            .exactPhrase("artificial intelligence")
            .excludeWords("spam")
            .searchQuery("AI trends 2025")
            .targetCommunityId("1500000000000000000")
            .targetListId("1234567890")
            .targetSpaceId("1vOGwMdBqpwGB")
            .targetTweetId("1234567890")
            .targetUsername("elonmusk")
            .build()
    }

    @Test
    fun body() {
        val params =
            ExtractionEstimateCostParams.builder()
                .toolType(ExtractionEstimateCostParams.ToolType.FOLLOWER_EXPLORER)
                .advancedQuery("min_faves:100")
                .exactPhrase("artificial intelligence")
                .excludeWords("spam")
                .searchQuery("AI trends 2025")
                .targetCommunityId("1500000000000000000")
                .targetListId("1234567890")
                .targetSpaceId("1vOGwMdBqpwGB")
                .targetTweetId("1234567890")
                .targetUsername("elonmusk")
                .build()

        val body = params._body()

        assertThat(body.toolType())
            .isEqualTo(ExtractionEstimateCostParams.ToolType.FOLLOWER_EXPLORER)
        assertThat(body.advancedQuery()).contains("min_faves:100")
        assertThat(body.exactPhrase()).contains("artificial intelligence")
        assertThat(body.excludeWords()).contains("spam")
        assertThat(body.searchQuery()).contains("AI trends 2025")
        assertThat(body.targetCommunityId()).contains("1500000000000000000")
        assertThat(body.targetListId()).contains("1234567890")
        assertThat(body.targetSpaceId()).contains("1vOGwMdBqpwGB")
        assertThat(body.targetTweetId()).contains("1234567890")
        assertThat(body.targetUsername()).contains("elonmusk")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ExtractionEstimateCostParams.builder()
                .toolType(ExtractionEstimateCostParams.ToolType.FOLLOWER_EXPLORER)
                .build()

        val body = params._body()

        assertThat(body.toolType())
            .isEqualTo(ExtractionEstimateCostParams.ToolType.FOLLOWER_EXPLORER)
    }
}
