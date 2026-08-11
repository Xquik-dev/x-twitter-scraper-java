// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient
import com.x_twitter_scraper.api.models.extractions.ExtractionEstimateCostParams
import com.x_twitter_scraper.api.models.extractions.ExtractionExportResultsParams
import com.x_twitter_scraper.api.models.extractions.ExtractionListParams
import com.x_twitter_scraper.api.models.extractions.ExtractionRetrieveParams
import com.x_twitter_scraper.api.models.extractions.ExtractionRunParams
import java.time.LocalDate
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ExtractionServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val extractionService = client.extractions()

        val extraction =
            extractionService.retrieve(
                ExtractionRetrieveParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .fieldStyle(ExtractionRetrieveParams.FieldStyle.SOURCE)
                    .includeRaw(true)
                    .limit(1L)
                    .outputMode(ExtractionRetrieveParams.OutputMode.COMPACT)
                    .outputPreset(ExtractionRetrieveParams.OutputPreset.NESTED)
                    .build()
            )

        extraction.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val extractionService = client.extractions()

        val extractions =
            extractionService.list(
                ExtractionListParams.builder()
                    .cursor("cursor")
                    .limit(1L)
                    .status(ExtractionListParams.Status.RUNNING)
                    .toolType(ExtractionListParams.ToolType.FOLLOWER_EXPLORER)
                    .build()
            )

        extractions.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun estimateCost() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val extractionService = client.extractions()

        val response =
            extractionService.estimateCost(
                ExtractionEstimateCostParams.builder()
                    .toolType(ExtractionEstimateCostParams.ToolType.FOLLOWER_EXPLORER)
                    .advancedQuery("min_faves:100")
                    .anyWords("ChatGPT AI model")
                    .bioContains("bioContains")
                    .blueVerifiedOnly(true)
                    .boundingBox("-74.1 40.6 -73.9 40.8")
                    .cardName("cardName")
                    .cashtags("\$TSLA \$NVDA")
                    .collectionStrategy(ExtractionEstimateCostParams.CollectionStrategy.AUTO)
                    .conversationId("1234567890")
                    .dedupeAcrossTargets(true)
                    .dedupeMode(ExtractionEstimateCostParams.DedupeMode.NONE)
                    .exactPhrase("artificial intelligence")
                    .excludeOriginalAuthor(true)
                    .excludeSource("excludeSource")
                    .excludeWords("spam")
                    .fromUser("nasa")
                    .geocode("geocode")
                    .hashtags("#AI startups")
                    .hasLocation(true)
                    .hasMediaOnly(true)
                    .hasWebsite(true)
                    .includeOriginalPost(true)
                    .includeSearchTerms(true)
                    .includeTargetMetadata(true)
                    .inReplyToTweetId("1234567890")
                    .language("en")
                    .listId("1234567890")
                    .locationContains("locationContains")
                    .maxDepth(1L)
                    .maxFollowers(0L)
                    .maxFollowing(0L)
                    .maxId("maxId")
                    .maxItemsPerTarget(1L)
                    .maxLikes(0L)
                    .maxPagesPerTarget(1L)
                    .maxPosts(0L)
                    .maxQuotes(0L)
                    .maxReplies(0L)
                    .maxRetweets(0L)
                    .mediaType(ExtractionEstimateCostParams.MediaType.IMAGES)
                    .mentioning("example_user")
                    .minAccountAgeDays(0L)
                    .minBookmarks(0L)
                    .minFaves(10L)
                    .minFollowers(0L)
                    .minFollowing(0L)
                    .minPosts(0L)
                    .minQuotes(2L)
                    .minReplies(3L)
                    .minRetweets(5L)
                    .minViews(0L)
                    .nativeRetweets(true)
                    .near("near")
                    .news(true)
                    .overlapMode(true)
                    .place("96683cc9126741d1")
                    .placeCountry("US")
                    .pointRadius("-73.99 40.73 25mi")
                    .queryType(ExtractionEstimateCostParams.QueryType.LATEST)
                    .quotes(ExtractionEstimateCostParams.Quotes.INCLUDE)
                    .quotesOfTweetId("1234567890")
                    .addRelationTarget(
                        ExtractionEstimateCostParams.RelationTarget.builder()
                            .relation(
                                ExtractionEstimateCostParams.RelationTarget.Relation
                                    .COMMUNITY_MEMBERS
                            )
                            .value("x")
                            .build()
                    )
                    .replies(ExtractionEstimateCostParams.Replies.INCLUDE)
                    .resultsLimit(1000L)
                    .retweets(ExtractionEstimateCostParams.Retweets.EXCLUDE)
                    .retweetsOfTweetId("1234567890")
                    .safe(true)
                    .scope(ExtractionEstimateCostParams.Scope.ALL)
                    .addSearchQuery("string")
                    .searchQuery("AI trends 2025")
                    .sinceDate(LocalDate.parse("2025-01-01"))
                    .sinceId("sinceId")
                    .sinceTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .sort(ExtractionEstimateCostParams.Sort.RELEVANCE)
                    .source("source")
                    .startCursor("x")
                    .targetCommunityId("1500000000000000000")
                    .addTargetCommunityId("string")
                    .targetListId("1234567890")
                    .addTargetListId("string")
                    .addTarget("string")
                    .targetSpaceId("1vOGwMdBqpwGB")
                    .targetTweetId("1234567890")
                    .addTargetTweetId("string")
                    .targetUsername("elonmusk")
                    .addTargetUsername("string")
                    .toUser("openai")
                    .untilDate(LocalDate.parse("2025-12-31"))
                    .untilTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .url("example.com")
                    .usernameContains("usernameContains")
                    .verifiedOnly(false)
                    .verifiedType("verifiedType")
                    .within("within")
                    .withinTime("withinTime")
                    .build()
            )

        response.validate()
    }

    @Test
    fun exportResults(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val extractionService = client.extractions()
        stubFor(get(anyUrl()).willReturn(ok().withBody("abc")))

        val response =
            extractionService.exportResults(
                ExtractionExportResultsParams.builder()
                    .id("id")
                    .format(ExtractionExportResultsParams.Format.CSV)
                    .hasDescription(true)
                    .hasLocation(true)
                    .hasMedia(true)
                    .lang("lang")
                    .maxFollowers(0L)
                    .maxFollowing(0L)
                    .maxPosts(0L)
                    .minFollowers(0L)
                    .minFollowing(0L)
                    .minLikes(0L)
                    .minPosts(0L)
                    .minReplies(0L)
                    .minRetweets(0L)
                    .minViews(0L)
                    .search("search")
                    .sinceDate(LocalDate.parse("2019-12-27"))
                    .untilDate(LocalDate.parse("2019-12-27"))
                    .verified(true)
                    .build()
            )

        assertThat(response.body()).hasContent("abc")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun run() {
        val client =
            XTwitterScraperOkHttpClient.builder()
                .apiKey("My API Key")
                .bearerToken("My Bearer Token")
                .build()
        val extractionService = client.extractions()

        val response =
            extractionService.run(
                ExtractionRunParams.builder()
                    .dryRun(true)
                    .toolType(ExtractionRunParams.ToolType.FOLLOWER_EXPLORER)
                    .advancedQuery("min_faves:100")
                    .anyWords("ChatGPT AI model")
                    .bioContains("bioContains")
                    .blueVerifiedOnly(true)
                    .boundingBox("-74.1 40.6 -73.9 40.8")
                    .cardName("cardName")
                    .cashtags("\$TSLA \$NVDA")
                    .collectionStrategy(ExtractionRunParams.CollectionStrategy.AUTO)
                    .conversationId("1234567890")
                    .dedupeAcrossTargets(true)
                    .dedupeMode(ExtractionRunParams.DedupeMode.NONE)
                    .exactPhrase("artificial intelligence")
                    .excludeOriginalAuthor(true)
                    .excludeSource("excludeSource")
                    .excludeWords("spam")
                    .fromUser("nasa")
                    .geocode("geocode")
                    .hashtags("#AI startups")
                    .hasLocation(true)
                    .hasMediaOnly(true)
                    .hasWebsite(true)
                    .includeOriginalPost(true)
                    .includeSearchTerms(true)
                    .includeTargetMetadata(true)
                    .inReplyToTweetId("1234567890")
                    .language("en")
                    .listId("1234567890")
                    .locationContains("locationContains")
                    .maxDepth(1L)
                    .maxFollowers(0L)
                    .maxFollowing(0L)
                    .maxId("maxId")
                    .maxItemsPerTarget(1L)
                    .maxLikes(0L)
                    .maxPagesPerTarget(1L)
                    .maxPosts(0L)
                    .maxQuotes(0L)
                    .maxReplies(0L)
                    .maxRetweets(0L)
                    .mediaType(ExtractionRunParams.MediaType.IMAGES)
                    .mentioning("example_user")
                    .minAccountAgeDays(0L)
                    .minBookmarks(0L)
                    .minFaves(10L)
                    .minFollowers(0L)
                    .minFollowing(0L)
                    .minPosts(0L)
                    .minQuotes(2L)
                    .minReplies(3L)
                    .minRetweets(5L)
                    .minViews(0L)
                    .nativeRetweets(true)
                    .near("near")
                    .news(true)
                    .overlapMode(true)
                    .place("96683cc9126741d1")
                    .placeCountry("US")
                    .pointRadius("-73.99 40.73 25mi")
                    .queryType(ExtractionRunParams.QueryType.LATEST)
                    .quotes(ExtractionRunParams.Quotes.INCLUDE)
                    .quotesOfTweetId("1234567890")
                    .addRelationTarget(
                        ExtractionRunParams.RelationTarget.builder()
                            .relation(ExtractionRunParams.RelationTarget.Relation.COMMUNITY_MEMBERS)
                            .value("x")
                            .build()
                    )
                    .replies(ExtractionRunParams.Replies.INCLUDE)
                    .resultsLimit(1000L)
                    .retweets(ExtractionRunParams.Retweets.EXCLUDE)
                    .retweetsOfTweetId("1234567890")
                    .safe(true)
                    .scope(ExtractionRunParams.Scope.ALL)
                    .addSearchQuery("string")
                    .searchQuery("AI trends 2025")
                    .sinceDate(LocalDate.parse("2025-01-01"))
                    .sinceId("sinceId")
                    .sinceTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .sort(ExtractionRunParams.Sort.RELEVANCE)
                    .source("source")
                    .startCursor("x")
                    .targetCommunityId("1500000000000000000")
                    .addTargetCommunityId("string")
                    .targetListId("1234567890")
                    .addTargetListId("string")
                    .addTarget("string")
                    .targetSpaceId("1vOGwMdBqpwGB")
                    .targetTweetId("1234567890")
                    .addTargetTweetId("string")
                    .targetUsername("elonmusk")
                    .addTargetUsername("string")
                    .toUser("openai")
                    .untilDate(LocalDate.parse("2025-12-31"))
                    .untilTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .url("example.com")
                    .usernameContains("usernameContains")
                    .verifiedOnly(false)
                    .verifiedType("verifiedType")
                    .within("within")
                    .withinTime("withinTime")
                    .build()
            )

        response.validate()
    }
}
