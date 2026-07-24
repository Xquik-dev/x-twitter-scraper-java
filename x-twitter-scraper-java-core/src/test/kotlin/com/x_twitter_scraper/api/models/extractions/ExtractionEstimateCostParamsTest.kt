// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExtractionEstimateCostParamsTest {

    @Test
    fun create() {
        ExtractionEstimateCostParams.builder()
            .toolType(ExtractionEstimateCostParams.ToolType.FOLLOWER_EXPLORER)
            .advancedQuery("min_faves:100")
            .anyWords("ChatGPT AI model")
            .boundingBox("-74.1 40.6 -73.9 40.8")
            .cashtags("\$TSLA \$NVDA")
            .conversationId("1234567890")
            .exactPhrase("artificial intelligence")
            .excludeWords("spam")
            .fromUser("nasa")
            .hashtags("#AI startups")
            .inReplyToTweetId("1234567890")
            .language("en")
            .listId("1234567890")
            .mediaType(ExtractionEstimateCostParams.MediaType.IMAGES)
            .mentioning("example_user")
            .minFaves(10L)
            .minQuotes(2L)
            .minReplies(3L)
            .minRetweets(5L)
            .place("96683cc9126741d1")
            .placeCountry("US")
            .pointRadius("-73.99 40.73 25mi")
            .quotes(ExtractionEstimateCostParams.Quotes.INCLUDE)
            .quotesOfTweetId("1234567890")
            .replies(ExtractionEstimateCostParams.Replies.INCLUDE)
            .resultsLimit(1000L)
            .retweets(ExtractionEstimateCostParams.Retweets.EXCLUDE)
            .retweetsOfTweetId("1234567890")
            .searchQuery("AI trends 2025")
            .sinceDate(LocalDate.parse("2025-01-01"))
            .targetCommunityId("1500000000000000000")
            .targetListId("1234567890")
            .targetSpaceId("1vOGwMdBqpwGB")
            .targetTweetId("1234567890")
            .targetUsername("elonmusk")
            .toUser("openai")
            .untilDate(LocalDate.parse("2025-12-31"))
            .url("example.com")
            .verifiedOnly(false)
            .build()
    }

    @Test
    fun body() {
        val params =
            ExtractionEstimateCostParams.builder()
                .toolType(ExtractionEstimateCostParams.ToolType.FOLLOWER_EXPLORER)
                .advancedQuery("min_faves:100")
                .anyWords("ChatGPT AI model")
                .boundingBox("-74.1 40.6 -73.9 40.8")
                .cashtags("\$TSLA \$NVDA")
                .conversationId("1234567890")
                .exactPhrase("artificial intelligence")
                .excludeWords("spam")
                .fromUser("nasa")
                .hashtags("#AI startups")
                .inReplyToTweetId("1234567890")
                .language("en")
                .listId("1234567890")
                .mediaType(ExtractionEstimateCostParams.MediaType.IMAGES)
                .mentioning("example_user")
                .minFaves(10L)
                .minQuotes(2L)
                .minReplies(3L)
                .minRetweets(5L)
                .place("96683cc9126741d1")
                .placeCountry("US")
                .pointRadius("-73.99 40.73 25mi")
                .quotes(ExtractionEstimateCostParams.Quotes.INCLUDE)
                .quotesOfTweetId("1234567890")
                .replies(ExtractionEstimateCostParams.Replies.INCLUDE)
                .resultsLimit(1000L)
                .retweets(ExtractionEstimateCostParams.Retweets.EXCLUDE)
                .retweetsOfTweetId("1234567890")
                .searchQuery("AI trends 2025")
                .sinceDate(LocalDate.parse("2025-01-01"))
                .targetCommunityId("1500000000000000000")
                .targetListId("1234567890")
                .targetSpaceId("1vOGwMdBqpwGB")
                .targetTweetId("1234567890")
                .targetUsername("elonmusk")
                .toUser("openai")
                .untilDate(LocalDate.parse("2025-12-31"))
                .url("example.com")
                .verifiedOnly(false)
                .build()

        val body = params._body()

        assertThat(body.toolType())
            .isEqualTo(ExtractionEstimateCostParams.ToolType.FOLLOWER_EXPLORER)
        assertThat(body.advancedQuery()).contains("min_faves:100")
        assertThat(body.anyWords()).contains("ChatGPT AI model")
        assertThat(body.boundingBox()).contains("-74.1 40.6 -73.9 40.8")
        assertThat(body.cashtags()).contains("\$TSLA \$NVDA")
        assertThat(body.conversationId()).contains("1234567890")
        assertThat(body.exactPhrase()).contains("artificial intelligence")
        assertThat(body.excludeWords()).contains("spam")
        assertThat(body.fromUser()).contains("nasa")
        assertThat(body.hashtags()).contains("#AI startups")
        assertThat(body.inReplyToTweetId()).contains("1234567890")
        assertThat(body.language()).contains("en")
        assertThat(body.listId()).contains("1234567890")
        assertThat(body.mediaType()).contains(ExtractionEstimateCostParams.MediaType.IMAGES)
        assertThat(body.mentioning()).contains("example_user")
        assertThat(body.minFaves()).contains(10L)
        assertThat(body.minQuotes()).contains(2L)
        assertThat(body.minReplies()).contains(3L)
        assertThat(body.minRetweets()).contains(5L)
        assertThat(body.place()).contains("96683cc9126741d1")
        assertThat(body.placeCountry()).contains("US")
        assertThat(body.pointRadius()).contains("-73.99 40.73 25mi")
        assertThat(body.quotes()).contains(ExtractionEstimateCostParams.Quotes.INCLUDE)
        assertThat(body.quotesOfTweetId()).contains("1234567890")
        assertThat(body.replies()).contains(ExtractionEstimateCostParams.Replies.INCLUDE)
        assertThat(body.resultsLimit()).contains(1000L)
        assertThat(body.retweets()).contains(ExtractionEstimateCostParams.Retweets.EXCLUDE)
        assertThat(body.retweetsOfTweetId()).contains("1234567890")
        assertThat(body.searchQuery()).contains("AI trends 2025")
        assertThat(body.sinceDate()).contains(LocalDate.parse("2025-01-01"))
        assertThat(body.targetCommunityId()).contains("1500000000000000000")
        assertThat(body.targetListId()).contains("1234567890")
        assertThat(body.targetSpaceId()).contains("1vOGwMdBqpwGB")
        assertThat(body.targetTweetId()).contains("1234567890")
        assertThat(body.targetUsername()).contains("elonmusk")
        assertThat(body.toUser()).contains("openai")
        assertThat(body.untilDate()).contains(LocalDate.parse("2025-12-31"))
        assertThat(body.url()).contains("example.com")
        assertThat(body.verifiedOnly()).contains(false)
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
