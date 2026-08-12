// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.BaseDeserializer
import com.x_twitter_scraper.api.core.BaseSerializer
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.allMaxBy
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.getOrThrow
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Estimate extraction cost */
class ExtractionEstimateCostParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Identifier for the extraction tool used to run a job.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun toolType(): ToolType = body.toolType()

    /**
     * Raw advanced search query appended as-is (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun advancedQuery(): Optional<String> = body.advancedQuery()

    /**
     * Words or quoted phrases where any one can match. Separate with spaces, commas, or lines.
     * (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun anyWords(): Optional<String> = body.anyWords()

    /**
     * Bio terms separated by commas or lines.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun bioContains(): Optional<String> = body.bioContains()

    /**
     * Return only Blue-verified Tweet authors.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun blueVerifiedOnly(): Optional<Boolean> = body.blueVerifiedOnly()

    /**
     * Geo bounding box, e.g. -74.1 40.6 -73.9 40.8 (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun boundingBox(): Optional<String> = body.boundingBox()

    /**
     * Match the Tweet card name.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun cardName(): Optional<String> = body.cardName()

    /**
     * Cashtags separated by spaces, commas, or lines. (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun cashtags(): Optional<String> = body.cashtags()

    /**
     * Reply collection strategy.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun collectionStrategy(): Optional<CollectionStrategy> = body.collectionStrategy()

    /**
     * Conversation ID filter (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun conversationId(): Optional<String> = body.conversationId()

    /**
     * Merge duplicate results across collection targets.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun dedupeAcrossTargets(): Optional<Boolean> = body.dedupeAcrossTargets()

    /**
     * Keep target duplicates, first rows, or merged overlap.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun dedupeMode(): Optional<DedupeMode> = body.dedupeMode()

    /**
     * Exact phrase to match (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun exactPhrase(): Optional<String> = body.exactPhrase()

    /**
     * Exclude replies from the source author.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun excludeOriginalAuthor(): Optional<Boolean> = body.excludeOriginalAuthor()

    /**
     * Exclude a source application.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun excludeSource(): Optional<String> = body.excludeSource()

    /**
     * Words or quoted phrases to exclude. Separate with spaces, commas, or lines.
     * (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun excludeWords(): Optional<String> = body.excludeWords()

    /**
     * Filter by author username (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun fromUser(): Optional<String> = body.fromUser()

    /**
     * Match latitude, longitude, and radius.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun geocode(): Optional<String> = body.geocode()

    /**
     * Hashtags separated by spaces, commas, or lines. (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun hashtags(): Optional<String> = body.hashtags()

    /**
     * Require a profile location.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun hasLocation(): Optional<Boolean> = body.hasLocation()

    /**
     * Return only replies with media.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun hasMediaOnly(): Optional<Boolean> = body.hasMediaOnly()

    /**
     * Require a profile website.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun hasWebsite(): Optional<Boolean> = body.hasWebsite()

    /**
     * Include the source post in reply results.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun includeOriginalPost(): Optional<Boolean> = body.includeOriginalPost()

    /**
     * Add matching search terms to collection metadata.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun includeSearchTerms(): Optional<Boolean> = body.includeSearchTerms()

    /**
     * Add source target metadata to each result.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun includeTargetMetadata(): Optional<Boolean> = body.includeTargetMetadata()

    /**
     * Only replies to this tweet ID (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun inReplyToTweetId(): Optional<String> = body.inReplyToTweetId()

    /**
     * Language code filter (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun language(): Optional<String> = body.language()

    /**
     * Search within a list ID (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun listId(): Optional<String> = body.listId()

    /**
     * Required profile location text.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun locationContains(): Optional<String> = body.locationContains()

    /**
     * Maximum nested reply depth.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun maxDepth(): Optional<Long> = body.maxDepth()

    /**
     * Maximum follower count for profile results.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun maxFollowers(): Optional<Long> = body.maxFollowers()

    /**
     * Maximum following count for profile results.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun maxFollowing(): Optional<Long> = body.maxFollowing()

    /**
     * Return Tweets older than this Tweet ID.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun maxId(): Optional<String> = body.maxId()

    /**
     * Maximum results collected for each target.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun maxItemsPerTarget(): Optional<Long> = body.maxItemsPerTarget()

    /**
     * Maximum Tweet like count.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun maxLikes(): Optional<Long> = body.maxLikes()

    /**
     * Reply pages collected for each target.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun maxPagesPerTarget(): Optional<Long> = body.maxPagesPerTarget()

    /**
     * Maximum post count for profile results.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun maxPosts(): Optional<Long> = body.maxPosts()

    /**
     * Maximum Tweet quote count.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun maxQuotes(): Optional<Long> = body.maxQuotes()

    /**
     * Maximum Tweet reply count.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun maxReplies(): Optional<Long> = body.maxReplies()

    /**
     * Maximum Tweet repost count.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun maxRetweets(): Optional<Long> = body.maxRetweets()

    /**
     * Media type filter (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun mediaType(): Optional<MediaType> = body.mediaType()

    /**
     * Filter tweets mentioning a username (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun mentioning(): Optional<String> = body.mentioning()

    /**
     * Minimum profile age in days.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun minAccountAgeDays(): Optional<Long> = body.minAccountAgeDays()

    /**
     * Minimum Tweet bookmark count.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun minBookmarks(): Optional<Long> = body.minBookmarks()

    /**
     * Minimum likes threshold (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun minFaves(): Optional<Long> = body.minFaves()

    /**
     * Minimum follower count for profile results.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun minFollowers(): Optional<Long> = body.minFollowers()

    /**
     * Minimum following count for profile results.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun minFollowing(): Optional<Long> = body.minFollowing()

    /**
     * Minimum post count for profile results.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun minPosts(): Optional<Long> = body.minPosts()

    /**
     * Minimum quote count threshold (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun minQuotes(): Optional<Long> = body.minQuotes()

    /**
     * Minimum replies threshold (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun minReplies(): Optional<Long> = body.minReplies()

    /**
     * Minimum retweets threshold (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun minRetweets(): Optional<Long> = body.minRetweets()

    /**
     * Minimum Tweet view count.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun minViews(): Optional<Long> = body.minViews()

    /**
     * Only return native reposts.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun nativeRetweets(): Optional<Boolean> = body.nativeRetweets()

    /**
     * Match a place name.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun near(): Optional<String> = body.near()

    /**
     * Only return news results.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun news(): Optional<Boolean> = body.news()

    /**
     * Shortcut for dedupeMode=merge.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun overlapMode(): Optional<Boolean> = body.overlapMode()

    /**
     * Search within a place ID (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun place(): Optional<String> = body.place()

    /**
     * Search within a country code (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun placeCountry(): Optional<String> = body.placeCountry()

    /**
     * Geo point radius, e.g. -73.99 40.73 25mi (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun pointRadius(): Optional<String> = body.pointRadius()

    /**
     * Search ranking applied to every query.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun queryType(): Optional<QueryType> = body.queryType()

    /**
     * Quote mode (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun quotes(): Optional<Quotes> = body.quotes()

    /**
     * Only quotes of this tweet ID (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun quotesOfTweetId(): Optional<String> = body.quotesOfTweetId()

    /**
     * Profile relations processed within one job.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun relationTargets(): Optional<List<RelationTarget>> = body.relationTargets()

    /**
     * Reply mode (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun replies(): Optional<Replies> = body.replies()

    /**
     * Maximum number of results to extract. When set, the extraction stops after reaching this
     * limit.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun resultsLimit(): Optional<Long> = body.resultsLimit()

    /**
     * Retweet mode (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun retweets(): Optional<Retweets> = body.retweets()

    /**
     * Only retweets of this tweet ID (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun retweetsOfTweetId(): Optional<String> = body.retweetsOfTweetId()

    /**
     * Enable the safe-search filter.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun safe(): Optional<Boolean> = body.safe()

    /**
     * Reply depth scope.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun scope(): Optional<Scope> = body.scope()

    /**
     * Search queries processed as one collection job.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun searchQueries(): Optional<List<String>> = body.searchQueries()

    /**
     * Required for tweet_search_extractor & community_search.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun searchQuery(): Optional<String> = body.searchQuery()

    /**
     * Start date YYYY-MM-DD (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun sinceDate(): Optional<LocalDate> = body.sinceDate()

    /**
     * Return Tweets newer than this Tweet ID.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun sinceId(): Optional<String> = body.sinceId()

    /**
     * Reply start time as ISO 8601 or Unix seconds.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun sinceTime(): Optional<SinceTime> = body.sinceTime()

    /**
     * Reply result order.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun sort(): Optional<Sort> = body.sort()

    /**
     * Match the source application.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun source(): Optional<String> = body.source()

    /**
     * Resume one reply target from this cursor.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun startCursor(): Optional<String> = body.startCursor()

    /**
     * Required for community_post_extractor & community_search.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetCommunityId(): Optional<String> = body.targetCommunityId()

    /**
     * Community IDs processed as one collection job.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetCommunityIds(): Optional<List<String>> = body.targetCommunityIds()

    /**
     * Required for list_follower_explorer, list_member_extractor & list_post_extractor.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetListId(): Optional<String> = body.targetListId()

    /**
     * List IDs processed as one collection job.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetListIds(): Optional<List<String>> = body.targetListIds()

    /**
     * Mixed targets auto-routed within one job.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targets(): Optional<List<Target>> = body.targets()

    /**
     * Required for space_explorer.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetSpaceId(): Optional<String> = body.targetSpaceId()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetTweetId(): Optional<String> = body.targetTweetId()

    /**
     * Tweet IDs processed as one collection job.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetTweetIds(): Optional<List<String>> = body.targetTweetIds()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetUsername(): Optional<String> = body.targetUsername()

    /**
     * Usernames processed as one collection job.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun targetUsernames(): Optional<List<String>> = body.targetUsernames()

    /**
     * Filter replies sent to a username (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun toUser(): Optional<String> = body.toUser()

    /**
     * End date YYYY-MM-DD (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun untilDate(): Optional<LocalDate> = body.untilDate()

    /**
     * Reply end time as ISO 8601 or Unix seconds.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun untilTime(): Optional<UntilTime> = body.untilTime()

    /**
     * URL substring or domain filter (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun url(): Optional<String> = body.url()

    /**
     * Required username text.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun usernameContains(): Optional<String> = body.usernameContains()

    /**
     * Only verified authors (tweet_search_extractor)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun verifiedOnly(): Optional<Boolean> = body.verifiedOnly()

    /**
     * Exact profile verification type.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun verifiedType(): Optional<String> = body.verifiedType()

    /**
     * Set the radius for the near filter.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun within(): Optional<String> = body.within()

    /**
     * Match Tweets inside a recent time window.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun withinTime(): Optional<String> = body.withinTime()

    /**
     * Returns the raw JSON value of [toolType].
     *
     * Unlike [toolType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _toolType(): JsonField<ToolType> = body._toolType()

    /**
     * Returns the raw JSON value of [advancedQuery].
     *
     * Unlike [advancedQuery], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _advancedQuery(): JsonField<String> = body._advancedQuery()

    /**
     * Returns the raw JSON value of [anyWords].
     *
     * Unlike [anyWords], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _anyWords(): JsonField<String> = body._anyWords()

    /**
     * Returns the raw JSON value of [bioContains].
     *
     * Unlike [bioContains], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _bioContains(): JsonField<String> = body._bioContains()

    /**
     * Returns the raw JSON value of [blueVerifiedOnly].
     *
     * Unlike [blueVerifiedOnly], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _blueVerifiedOnly(): JsonField<Boolean> = body._blueVerifiedOnly()

    /**
     * Returns the raw JSON value of [boundingBox].
     *
     * Unlike [boundingBox], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _boundingBox(): JsonField<String> = body._boundingBox()

    /**
     * Returns the raw JSON value of [cardName].
     *
     * Unlike [cardName], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _cardName(): JsonField<String> = body._cardName()

    /**
     * Returns the raw JSON value of [cashtags].
     *
     * Unlike [cashtags], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _cashtags(): JsonField<String> = body._cashtags()

    /**
     * Returns the raw JSON value of [collectionStrategy].
     *
     * Unlike [collectionStrategy], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _collectionStrategy(): JsonField<CollectionStrategy> = body._collectionStrategy()

    /**
     * Returns the raw JSON value of [conversationId].
     *
     * Unlike [conversationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _conversationId(): JsonField<String> = body._conversationId()

    /**
     * Returns the raw JSON value of [dedupeAcrossTargets].
     *
     * Unlike [dedupeAcrossTargets], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _dedupeAcrossTargets(): JsonField<Boolean> = body._dedupeAcrossTargets()

    /**
     * Returns the raw JSON value of [dedupeMode].
     *
     * Unlike [dedupeMode], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _dedupeMode(): JsonField<DedupeMode> = body._dedupeMode()

    /**
     * Returns the raw JSON value of [exactPhrase].
     *
     * Unlike [exactPhrase], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _exactPhrase(): JsonField<String> = body._exactPhrase()

    /**
     * Returns the raw JSON value of [excludeOriginalAuthor].
     *
     * Unlike [excludeOriginalAuthor], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _excludeOriginalAuthor(): JsonField<Boolean> = body._excludeOriginalAuthor()

    /**
     * Returns the raw JSON value of [excludeSource].
     *
     * Unlike [excludeSource], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _excludeSource(): JsonField<String> = body._excludeSource()

    /**
     * Returns the raw JSON value of [excludeWords].
     *
     * Unlike [excludeWords], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _excludeWords(): JsonField<String> = body._excludeWords()

    /**
     * Returns the raw JSON value of [fromUser].
     *
     * Unlike [fromUser], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _fromUser(): JsonField<String> = body._fromUser()

    /**
     * Returns the raw JSON value of [geocode].
     *
     * Unlike [geocode], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _geocode(): JsonField<String> = body._geocode()

    /**
     * Returns the raw JSON value of [hashtags].
     *
     * Unlike [hashtags], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _hashtags(): JsonField<String> = body._hashtags()

    /**
     * Returns the raw JSON value of [hasLocation].
     *
     * Unlike [hasLocation], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _hasLocation(): JsonField<Boolean> = body._hasLocation()

    /**
     * Returns the raw JSON value of [hasMediaOnly].
     *
     * Unlike [hasMediaOnly], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _hasMediaOnly(): JsonField<Boolean> = body._hasMediaOnly()

    /**
     * Returns the raw JSON value of [hasWebsite].
     *
     * Unlike [hasWebsite], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _hasWebsite(): JsonField<Boolean> = body._hasWebsite()

    /**
     * Returns the raw JSON value of [includeOriginalPost].
     *
     * Unlike [includeOriginalPost], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _includeOriginalPost(): JsonField<Boolean> = body._includeOriginalPost()

    /**
     * Returns the raw JSON value of [includeSearchTerms].
     *
     * Unlike [includeSearchTerms], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _includeSearchTerms(): JsonField<Boolean> = body._includeSearchTerms()

    /**
     * Returns the raw JSON value of [includeTargetMetadata].
     *
     * Unlike [includeTargetMetadata], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _includeTargetMetadata(): JsonField<Boolean> = body._includeTargetMetadata()

    /**
     * Returns the raw JSON value of [inReplyToTweetId].
     *
     * Unlike [inReplyToTweetId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _inReplyToTweetId(): JsonField<String> = body._inReplyToTweetId()

    /**
     * Returns the raw JSON value of [language].
     *
     * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _language(): JsonField<String> = body._language()

    /**
     * Returns the raw JSON value of [listId].
     *
     * Unlike [listId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _listId(): JsonField<String> = body._listId()

    /**
     * Returns the raw JSON value of [locationContains].
     *
     * Unlike [locationContains], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _locationContains(): JsonField<String> = body._locationContains()

    /**
     * Returns the raw JSON value of [maxDepth].
     *
     * Unlike [maxDepth], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _maxDepth(): JsonField<Long> = body._maxDepth()

    /**
     * Returns the raw JSON value of [maxFollowers].
     *
     * Unlike [maxFollowers], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _maxFollowers(): JsonField<Long> = body._maxFollowers()

    /**
     * Returns the raw JSON value of [maxFollowing].
     *
     * Unlike [maxFollowing], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _maxFollowing(): JsonField<Long> = body._maxFollowing()

    /**
     * Returns the raw JSON value of [maxId].
     *
     * Unlike [maxId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _maxId(): JsonField<String> = body._maxId()

    /**
     * Returns the raw JSON value of [maxItemsPerTarget].
     *
     * Unlike [maxItemsPerTarget], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _maxItemsPerTarget(): JsonField<Long> = body._maxItemsPerTarget()

    /**
     * Returns the raw JSON value of [maxLikes].
     *
     * Unlike [maxLikes], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _maxLikes(): JsonField<Long> = body._maxLikes()

    /**
     * Returns the raw JSON value of [maxPagesPerTarget].
     *
     * Unlike [maxPagesPerTarget], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _maxPagesPerTarget(): JsonField<Long> = body._maxPagesPerTarget()

    /**
     * Returns the raw JSON value of [maxPosts].
     *
     * Unlike [maxPosts], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _maxPosts(): JsonField<Long> = body._maxPosts()

    /**
     * Returns the raw JSON value of [maxQuotes].
     *
     * Unlike [maxQuotes], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _maxQuotes(): JsonField<Long> = body._maxQuotes()

    /**
     * Returns the raw JSON value of [maxReplies].
     *
     * Unlike [maxReplies], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _maxReplies(): JsonField<Long> = body._maxReplies()

    /**
     * Returns the raw JSON value of [maxRetweets].
     *
     * Unlike [maxRetweets], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _maxRetweets(): JsonField<Long> = body._maxRetweets()

    /**
     * Returns the raw JSON value of [mediaType].
     *
     * Unlike [mediaType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _mediaType(): JsonField<MediaType> = body._mediaType()

    /**
     * Returns the raw JSON value of [mentioning].
     *
     * Unlike [mentioning], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _mentioning(): JsonField<String> = body._mentioning()

    /**
     * Returns the raw JSON value of [minAccountAgeDays].
     *
     * Unlike [minAccountAgeDays], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _minAccountAgeDays(): JsonField<Long> = body._minAccountAgeDays()

    /**
     * Returns the raw JSON value of [minBookmarks].
     *
     * Unlike [minBookmarks], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _minBookmarks(): JsonField<Long> = body._minBookmarks()

    /**
     * Returns the raw JSON value of [minFaves].
     *
     * Unlike [minFaves], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _minFaves(): JsonField<Long> = body._minFaves()

    /**
     * Returns the raw JSON value of [minFollowers].
     *
     * Unlike [minFollowers], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _minFollowers(): JsonField<Long> = body._minFollowers()

    /**
     * Returns the raw JSON value of [minFollowing].
     *
     * Unlike [minFollowing], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _minFollowing(): JsonField<Long> = body._minFollowing()

    /**
     * Returns the raw JSON value of [minPosts].
     *
     * Unlike [minPosts], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _minPosts(): JsonField<Long> = body._minPosts()

    /**
     * Returns the raw JSON value of [minQuotes].
     *
     * Unlike [minQuotes], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _minQuotes(): JsonField<Long> = body._minQuotes()

    /**
     * Returns the raw JSON value of [minReplies].
     *
     * Unlike [minReplies], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _minReplies(): JsonField<Long> = body._minReplies()

    /**
     * Returns the raw JSON value of [minRetweets].
     *
     * Unlike [minRetweets], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _minRetweets(): JsonField<Long> = body._minRetweets()

    /**
     * Returns the raw JSON value of [minViews].
     *
     * Unlike [minViews], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _minViews(): JsonField<Long> = body._minViews()

    /**
     * Returns the raw JSON value of [nativeRetweets].
     *
     * Unlike [nativeRetweets], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _nativeRetweets(): JsonField<Boolean> = body._nativeRetweets()

    /**
     * Returns the raw JSON value of [near].
     *
     * Unlike [near], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _near(): JsonField<String> = body._near()

    /**
     * Returns the raw JSON value of [news].
     *
     * Unlike [news], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _news(): JsonField<Boolean> = body._news()

    /**
     * Returns the raw JSON value of [overlapMode].
     *
     * Unlike [overlapMode], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _overlapMode(): JsonField<Boolean> = body._overlapMode()

    /**
     * Returns the raw JSON value of [place].
     *
     * Unlike [place], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _place(): JsonField<String> = body._place()

    /**
     * Returns the raw JSON value of [placeCountry].
     *
     * Unlike [placeCountry], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _placeCountry(): JsonField<String> = body._placeCountry()

    /**
     * Returns the raw JSON value of [pointRadius].
     *
     * Unlike [pointRadius], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _pointRadius(): JsonField<String> = body._pointRadius()

    /**
     * Returns the raw JSON value of [queryType].
     *
     * Unlike [queryType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _queryType(): JsonField<QueryType> = body._queryType()

    /**
     * Returns the raw JSON value of [quotes].
     *
     * Unlike [quotes], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _quotes(): JsonField<Quotes> = body._quotes()

    /**
     * Returns the raw JSON value of [quotesOfTweetId].
     *
     * Unlike [quotesOfTweetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _quotesOfTweetId(): JsonField<String> = body._quotesOfTweetId()

    /**
     * Returns the raw JSON value of [relationTargets].
     *
     * Unlike [relationTargets], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _relationTargets(): JsonField<List<RelationTarget>> = body._relationTargets()

    /**
     * Returns the raw JSON value of [replies].
     *
     * Unlike [replies], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _replies(): JsonField<Replies> = body._replies()

    /**
     * Returns the raw JSON value of [resultsLimit].
     *
     * Unlike [resultsLimit], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _resultsLimit(): JsonField<Long> = body._resultsLimit()

    /**
     * Returns the raw JSON value of [retweets].
     *
     * Unlike [retweets], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _retweets(): JsonField<Retweets> = body._retweets()

    /**
     * Returns the raw JSON value of [retweetsOfTweetId].
     *
     * Unlike [retweetsOfTweetId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _retweetsOfTweetId(): JsonField<String> = body._retweetsOfTweetId()

    /**
     * Returns the raw JSON value of [safe].
     *
     * Unlike [safe], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _safe(): JsonField<Boolean> = body._safe()

    /**
     * Returns the raw JSON value of [scope].
     *
     * Unlike [scope], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _scope(): JsonField<Scope> = body._scope()

    /**
     * Returns the raw JSON value of [searchQueries].
     *
     * Unlike [searchQueries], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _searchQueries(): JsonField<List<String>> = body._searchQueries()

    /**
     * Returns the raw JSON value of [searchQuery].
     *
     * Unlike [searchQuery], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _searchQuery(): JsonField<String> = body._searchQuery()

    /**
     * Returns the raw JSON value of [sinceDate].
     *
     * Unlike [sinceDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sinceDate(): JsonField<LocalDate> = body._sinceDate()

    /**
     * Returns the raw JSON value of [sinceId].
     *
     * Unlike [sinceId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sinceId(): JsonField<String> = body._sinceId()

    /**
     * Returns the raw JSON value of [sinceTime].
     *
     * Unlike [sinceTime], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sinceTime(): JsonField<SinceTime> = body._sinceTime()

    /**
     * Returns the raw JSON value of [sort].
     *
     * Unlike [sort], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sort(): JsonField<Sort> = body._sort()

    /**
     * Returns the raw JSON value of [source].
     *
     * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _source(): JsonField<String> = body._source()

    /**
     * Returns the raw JSON value of [startCursor].
     *
     * Unlike [startCursor], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _startCursor(): JsonField<String> = body._startCursor()

    /**
     * Returns the raw JSON value of [targetCommunityId].
     *
     * Unlike [targetCommunityId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _targetCommunityId(): JsonField<String> = body._targetCommunityId()

    /**
     * Returns the raw JSON value of [targetCommunityIds].
     *
     * Unlike [targetCommunityIds], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _targetCommunityIds(): JsonField<List<String>> = body._targetCommunityIds()

    /**
     * Returns the raw JSON value of [targetListId].
     *
     * Unlike [targetListId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _targetListId(): JsonField<String> = body._targetListId()

    /**
     * Returns the raw JSON value of [targetListIds].
     *
     * Unlike [targetListIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _targetListIds(): JsonField<List<String>> = body._targetListIds()

    /**
     * Returns the raw JSON value of [targets].
     *
     * Unlike [targets], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _targets(): JsonField<List<Target>> = body._targets()

    /**
     * Returns the raw JSON value of [targetSpaceId].
     *
     * Unlike [targetSpaceId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _targetSpaceId(): JsonField<String> = body._targetSpaceId()

    /**
     * Returns the raw JSON value of [targetTweetId].
     *
     * Unlike [targetTweetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _targetTweetId(): JsonField<String> = body._targetTweetId()

    /**
     * Returns the raw JSON value of [targetTweetIds].
     *
     * Unlike [targetTweetIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _targetTweetIds(): JsonField<List<String>> = body._targetTweetIds()

    /**
     * Returns the raw JSON value of [targetUsername].
     *
     * Unlike [targetUsername], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _targetUsername(): JsonField<String> = body._targetUsername()

    /**
     * Returns the raw JSON value of [targetUsernames].
     *
     * Unlike [targetUsernames], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _targetUsernames(): JsonField<List<String>> = body._targetUsernames()

    /**
     * Returns the raw JSON value of [toUser].
     *
     * Unlike [toUser], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _toUser(): JsonField<String> = body._toUser()

    /**
     * Returns the raw JSON value of [untilDate].
     *
     * Unlike [untilDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _untilDate(): JsonField<LocalDate> = body._untilDate()

    /**
     * Returns the raw JSON value of [untilTime].
     *
     * Unlike [untilTime], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _untilTime(): JsonField<UntilTime> = body._untilTime()

    /**
     * Returns the raw JSON value of [url].
     *
     * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _url(): JsonField<String> = body._url()

    /**
     * Returns the raw JSON value of [usernameContains].
     *
     * Unlike [usernameContains], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _usernameContains(): JsonField<String> = body._usernameContains()

    /**
     * Returns the raw JSON value of [verifiedOnly].
     *
     * Unlike [verifiedOnly], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _verifiedOnly(): JsonField<Boolean> = body._verifiedOnly()

    /**
     * Returns the raw JSON value of [verifiedType].
     *
     * Unlike [verifiedType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _verifiedType(): JsonField<String> = body._verifiedType()

    /**
     * Returns the raw JSON value of [within].
     *
     * Unlike [within], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _within(): JsonField<String> = body._within()

    /**
     * Returns the raw JSON value of [withinTime].
     *
     * Unlike [withinTime], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _withinTime(): JsonField<String> = body._withinTime()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ExtractionEstimateCostParams].
         *
         * The following fields are required:
         * ```java
         * .toolType()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExtractionEstimateCostParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(extractionEstimateCostParams: ExtractionEstimateCostParams) = apply {
            body = extractionEstimateCostParams.body.toBuilder()
            additionalHeaders = extractionEstimateCostParams.additionalHeaders.toBuilder()
            additionalQueryParams = extractionEstimateCostParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [toolType]
         * - [advancedQuery]
         * - [anyWords]
         * - [bioContains]
         * - [blueVerifiedOnly]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Identifier for the extraction tool used to run a job. */
        fun toolType(toolType: ToolType) = apply { body.toolType(toolType) }

        /**
         * Sets [Builder.toolType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolType] with a well-typed [ToolType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun toolType(toolType: JsonField<ToolType>) = apply { body.toolType(toolType) }

        /** Raw advanced search query appended as-is (tweet_search_extractor) */
        fun advancedQuery(advancedQuery: String) = apply { body.advancedQuery(advancedQuery) }

        /**
         * Sets [Builder.advancedQuery] to an arbitrary JSON value.
         *
         * You should usually call [Builder.advancedQuery] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun advancedQuery(advancedQuery: JsonField<String>) = apply {
            body.advancedQuery(advancedQuery)
        }

        /**
         * Words or quoted phrases where any one can match. Separate with spaces, commas, or lines.
         * (tweet_search_extractor)
         */
        fun anyWords(anyWords: String) = apply { body.anyWords(anyWords) }

        /**
         * Sets [Builder.anyWords] to an arbitrary JSON value.
         *
         * You should usually call [Builder.anyWords] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun anyWords(anyWords: JsonField<String>) = apply { body.anyWords(anyWords) }

        /** Bio terms separated by commas or lines. */
        fun bioContains(bioContains: String) = apply { body.bioContains(bioContains) }

        /**
         * Sets [Builder.bioContains] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bioContains] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun bioContains(bioContains: JsonField<String>) = apply { body.bioContains(bioContains) }

        /** Return only Blue-verified Tweet authors. */
        fun blueVerifiedOnly(blueVerifiedOnly: Boolean) = apply {
            body.blueVerifiedOnly(blueVerifiedOnly)
        }

        /**
         * Sets [Builder.blueVerifiedOnly] to an arbitrary JSON value.
         *
         * You should usually call [Builder.blueVerifiedOnly] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun blueVerifiedOnly(blueVerifiedOnly: JsonField<Boolean>) = apply {
            body.blueVerifiedOnly(blueVerifiedOnly)
        }

        /** Geo bounding box, e.g. -74.1 40.6 -73.9 40.8 (tweet_search_extractor) */
        fun boundingBox(boundingBox: String) = apply { body.boundingBox(boundingBox) }

        /**
         * Sets [Builder.boundingBox] to an arbitrary JSON value.
         *
         * You should usually call [Builder.boundingBox] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun boundingBox(boundingBox: JsonField<String>) = apply { body.boundingBox(boundingBox) }

        /** Match the Tweet card name. */
        fun cardName(cardName: String) = apply { body.cardName(cardName) }

        /**
         * Sets [Builder.cardName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cardName] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cardName(cardName: JsonField<String>) = apply { body.cardName(cardName) }

        /** Cashtags separated by spaces, commas, or lines. (tweet_search_extractor) */
        fun cashtags(cashtags: String) = apply { body.cashtags(cashtags) }

        /**
         * Sets [Builder.cashtags] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cashtags] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cashtags(cashtags: JsonField<String>) = apply { body.cashtags(cashtags) }

        /** Reply collection strategy. */
        fun collectionStrategy(collectionStrategy: CollectionStrategy) = apply {
            body.collectionStrategy(collectionStrategy)
        }

        /**
         * Sets [Builder.collectionStrategy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.collectionStrategy] with a well-typed
         * [CollectionStrategy] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun collectionStrategy(collectionStrategy: JsonField<CollectionStrategy>) = apply {
            body.collectionStrategy(collectionStrategy)
        }

        /** Conversation ID filter (tweet_search_extractor) */
        fun conversationId(conversationId: String) = apply { body.conversationId(conversationId) }

        /**
         * Sets [Builder.conversationId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.conversationId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun conversationId(conversationId: JsonField<String>) = apply {
            body.conversationId(conversationId)
        }

        /** Merge duplicate results across collection targets. */
        fun dedupeAcrossTargets(dedupeAcrossTargets: Boolean) = apply {
            body.dedupeAcrossTargets(dedupeAcrossTargets)
        }

        /**
         * Sets [Builder.dedupeAcrossTargets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dedupeAcrossTargets] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun dedupeAcrossTargets(dedupeAcrossTargets: JsonField<Boolean>) = apply {
            body.dedupeAcrossTargets(dedupeAcrossTargets)
        }

        /** Keep target duplicates, first rows, or merged overlap. */
        fun dedupeMode(dedupeMode: DedupeMode) = apply { body.dedupeMode(dedupeMode) }

        /**
         * Sets [Builder.dedupeMode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dedupeMode] with a well-typed [DedupeMode] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun dedupeMode(dedupeMode: JsonField<DedupeMode>) = apply { body.dedupeMode(dedupeMode) }

        /** Exact phrase to match (tweet_search_extractor) */
        fun exactPhrase(exactPhrase: String) = apply { body.exactPhrase(exactPhrase) }

        /**
         * Sets [Builder.exactPhrase] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exactPhrase] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun exactPhrase(exactPhrase: JsonField<String>) = apply { body.exactPhrase(exactPhrase) }

        /** Exclude replies from the source author. */
        fun excludeOriginalAuthor(excludeOriginalAuthor: Boolean) = apply {
            body.excludeOriginalAuthor(excludeOriginalAuthor)
        }

        /**
         * Sets [Builder.excludeOriginalAuthor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.excludeOriginalAuthor] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun excludeOriginalAuthor(excludeOriginalAuthor: JsonField<Boolean>) = apply {
            body.excludeOriginalAuthor(excludeOriginalAuthor)
        }

        /** Exclude a source application. */
        fun excludeSource(excludeSource: String) = apply { body.excludeSource(excludeSource) }

        /**
         * Sets [Builder.excludeSource] to an arbitrary JSON value.
         *
         * You should usually call [Builder.excludeSource] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun excludeSource(excludeSource: JsonField<String>) = apply {
            body.excludeSource(excludeSource)
        }

        /**
         * Words or quoted phrases to exclude. Separate with spaces, commas, or lines.
         * (tweet_search_extractor)
         */
        fun excludeWords(excludeWords: String) = apply { body.excludeWords(excludeWords) }

        /**
         * Sets [Builder.excludeWords] to an arbitrary JSON value.
         *
         * You should usually call [Builder.excludeWords] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun excludeWords(excludeWords: JsonField<String>) = apply {
            body.excludeWords(excludeWords)
        }

        /** Filter by author username (tweet_search_extractor) */
        fun fromUser(fromUser: String) = apply { body.fromUser(fromUser) }

        /**
         * Sets [Builder.fromUser] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fromUser] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fromUser(fromUser: JsonField<String>) = apply { body.fromUser(fromUser) }

        /** Match latitude, longitude, and radius. */
        fun geocode(geocode: String) = apply { body.geocode(geocode) }

        /**
         * Sets [Builder.geocode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.geocode] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun geocode(geocode: JsonField<String>) = apply { body.geocode(geocode) }

        /** Hashtags separated by spaces, commas, or lines. (tweet_search_extractor) */
        fun hashtags(hashtags: String) = apply { body.hashtags(hashtags) }

        /**
         * Sets [Builder.hashtags] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hashtags] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hashtags(hashtags: JsonField<String>) = apply { body.hashtags(hashtags) }

        /** Require a profile location. */
        fun hasLocation(hasLocation: Boolean) = apply { body.hasLocation(hasLocation) }

        /**
         * Sets [Builder.hasLocation] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasLocation] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun hasLocation(hasLocation: JsonField<Boolean>) = apply { body.hasLocation(hasLocation) }

        /** Return only replies with media. */
        fun hasMediaOnly(hasMediaOnly: Boolean) = apply { body.hasMediaOnly(hasMediaOnly) }

        /**
         * Sets [Builder.hasMediaOnly] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasMediaOnly] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun hasMediaOnly(hasMediaOnly: JsonField<Boolean>) = apply {
            body.hasMediaOnly(hasMediaOnly)
        }

        /** Require a profile website. */
        fun hasWebsite(hasWebsite: Boolean) = apply { body.hasWebsite(hasWebsite) }

        /**
         * Sets [Builder.hasWebsite] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasWebsite] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun hasWebsite(hasWebsite: JsonField<Boolean>) = apply { body.hasWebsite(hasWebsite) }

        /** Include the source post in reply results. */
        fun includeOriginalPost(includeOriginalPost: Boolean) = apply {
            body.includeOriginalPost(includeOriginalPost)
        }

        /**
         * Sets [Builder.includeOriginalPost] to an arbitrary JSON value.
         *
         * You should usually call [Builder.includeOriginalPost] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun includeOriginalPost(includeOriginalPost: JsonField<Boolean>) = apply {
            body.includeOriginalPost(includeOriginalPost)
        }

        /** Add matching search terms to collection metadata. */
        fun includeSearchTerms(includeSearchTerms: Boolean) = apply {
            body.includeSearchTerms(includeSearchTerms)
        }

        /**
         * Sets [Builder.includeSearchTerms] to an arbitrary JSON value.
         *
         * You should usually call [Builder.includeSearchTerms] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun includeSearchTerms(includeSearchTerms: JsonField<Boolean>) = apply {
            body.includeSearchTerms(includeSearchTerms)
        }

        /** Add source target metadata to each result. */
        fun includeTargetMetadata(includeTargetMetadata: Boolean) = apply {
            body.includeTargetMetadata(includeTargetMetadata)
        }

        /**
         * Sets [Builder.includeTargetMetadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.includeTargetMetadata] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun includeTargetMetadata(includeTargetMetadata: JsonField<Boolean>) = apply {
            body.includeTargetMetadata(includeTargetMetadata)
        }

        /** Only replies to this tweet ID (tweet_search_extractor) */
        fun inReplyToTweetId(inReplyToTweetId: String) = apply {
            body.inReplyToTweetId(inReplyToTweetId)
        }

        /**
         * Sets [Builder.inReplyToTweetId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inReplyToTweetId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inReplyToTweetId(inReplyToTweetId: JsonField<String>) = apply {
            body.inReplyToTweetId(inReplyToTweetId)
        }

        /** Language code filter (tweet_search_extractor) */
        fun language(language: String) = apply { body.language(language) }

        /**
         * Sets [Builder.language] to an arbitrary JSON value.
         *
         * You should usually call [Builder.language] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun language(language: JsonField<String>) = apply { body.language(language) }

        /** Search within a list ID (tweet_search_extractor) */
        fun listId(listId: String) = apply { body.listId(listId) }

        /**
         * Sets [Builder.listId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.listId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun listId(listId: JsonField<String>) = apply { body.listId(listId) }

        /** Required profile location text. */
        fun locationContains(locationContains: String) = apply {
            body.locationContains(locationContains)
        }

        /**
         * Sets [Builder.locationContains] to an arbitrary JSON value.
         *
         * You should usually call [Builder.locationContains] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun locationContains(locationContains: JsonField<String>) = apply {
            body.locationContains(locationContains)
        }

        /** Maximum nested reply depth. */
        fun maxDepth(maxDepth: Long) = apply { body.maxDepth(maxDepth) }

        /**
         * Sets [Builder.maxDepth] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxDepth] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun maxDepth(maxDepth: JsonField<Long>) = apply { body.maxDepth(maxDepth) }

        /** Maximum follower count for profile results. */
        fun maxFollowers(maxFollowers: Long) = apply { body.maxFollowers(maxFollowers) }

        /**
         * Sets [Builder.maxFollowers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxFollowers] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun maxFollowers(maxFollowers: JsonField<Long>) = apply { body.maxFollowers(maxFollowers) }

        /** Maximum following count for profile results. */
        fun maxFollowing(maxFollowing: Long) = apply { body.maxFollowing(maxFollowing) }

        /**
         * Sets [Builder.maxFollowing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxFollowing] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun maxFollowing(maxFollowing: JsonField<Long>) = apply { body.maxFollowing(maxFollowing) }

        /** Return Tweets older than this Tweet ID. */
        fun maxId(maxId: String) = apply { body.maxId(maxId) }

        /**
         * Sets [Builder.maxId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun maxId(maxId: JsonField<String>) = apply { body.maxId(maxId) }

        /** Maximum results collected for each target. */
        fun maxItemsPerTarget(maxItemsPerTarget: Long) = apply {
            body.maxItemsPerTarget(maxItemsPerTarget)
        }

        /**
         * Sets [Builder.maxItemsPerTarget] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxItemsPerTarget] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun maxItemsPerTarget(maxItemsPerTarget: JsonField<Long>) = apply {
            body.maxItemsPerTarget(maxItemsPerTarget)
        }

        /** Maximum Tweet like count. */
        fun maxLikes(maxLikes: Long) = apply { body.maxLikes(maxLikes) }

        /**
         * Sets [Builder.maxLikes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxLikes] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun maxLikes(maxLikes: JsonField<Long>) = apply { body.maxLikes(maxLikes) }

        /** Reply pages collected for each target. */
        fun maxPagesPerTarget(maxPagesPerTarget: Long) = apply {
            body.maxPagesPerTarget(maxPagesPerTarget)
        }

        /**
         * Sets [Builder.maxPagesPerTarget] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxPagesPerTarget] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun maxPagesPerTarget(maxPagesPerTarget: JsonField<Long>) = apply {
            body.maxPagesPerTarget(maxPagesPerTarget)
        }

        /** Maximum post count for profile results. */
        fun maxPosts(maxPosts: Long) = apply { body.maxPosts(maxPosts) }

        /**
         * Sets [Builder.maxPosts] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxPosts] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun maxPosts(maxPosts: JsonField<Long>) = apply { body.maxPosts(maxPosts) }

        /** Maximum Tweet quote count. */
        fun maxQuotes(maxQuotes: Long) = apply { body.maxQuotes(maxQuotes) }

        /**
         * Sets [Builder.maxQuotes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxQuotes] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun maxQuotes(maxQuotes: JsonField<Long>) = apply { body.maxQuotes(maxQuotes) }

        /** Maximum Tweet reply count. */
        fun maxReplies(maxReplies: Long) = apply { body.maxReplies(maxReplies) }

        /**
         * Sets [Builder.maxReplies] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxReplies] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun maxReplies(maxReplies: JsonField<Long>) = apply { body.maxReplies(maxReplies) }

        /** Maximum Tweet repost count. */
        fun maxRetweets(maxRetweets: Long) = apply { body.maxRetweets(maxRetweets) }

        /**
         * Sets [Builder.maxRetweets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxRetweets] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun maxRetweets(maxRetweets: JsonField<Long>) = apply { body.maxRetweets(maxRetweets) }

        /** Media type filter (tweet_search_extractor) */
        fun mediaType(mediaType: MediaType) = apply { body.mediaType(mediaType) }

        /**
         * Sets [Builder.mediaType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mediaType] with a well-typed [MediaType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun mediaType(mediaType: JsonField<MediaType>) = apply { body.mediaType(mediaType) }

        /** Filter tweets mentioning a username (tweet_search_extractor) */
        fun mentioning(mentioning: String) = apply { body.mentioning(mentioning) }

        /**
         * Sets [Builder.mentioning] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mentioning] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun mentioning(mentioning: JsonField<String>) = apply { body.mentioning(mentioning) }

        /** Minimum profile age in days. */
        fun minAccountAgeDays(minAccountAgeDays: Long) = apply {
            body.minAccountAgeDays(minAccountAgeDays)
        }

        /**
         * Sets [Builder.minAccountAgeDays] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minAccountAgeDays] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun minAccountAgeDays(minAccountAgeDays: JsonField<Long>) = apply {
            body.minAccountAgeDays(minAccountAgeDays)
        }

        /** Minimum Tweet bookmark count. */
        fun minBookmarks(minBookmarks: Long) = apply { body.minBookmarks(minBookmarks) }

        /**
         * Sets [Builder.minBookmarks] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minBookmarks] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun minBookmarks(minBookmarks: JsonField<Long>) = apply { body.minBookmarks(minBookmarks) }

        /** Minimum likes threshold (tweet_search_extractor) */
        fun minFaves(minFaves: Long) = apply { body.minFaves(minFaves) }

        /**
         * Sets [Builder.minFaves] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minFaves] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun minFaves(minFaves: JsonField<Long>) = apply { body.minFaves(minFaves) }

        /** Minimum follower count for profile results. */
        fun minFollowers(minFollowers: Long) = apply { body.minFollowers(minFollowers) }

        /**
         * Sets [Builder.minFollowers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minFollowers] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun minFollowers(minFollowers: JsonField<Long>) = apply { body.minFollowers(minFollowers) }

        /** Minimum following count for profile results. */
        fun minFollowing(minFollowing: Long) = apply { body.minFollowing(minFollowing) }

        /**
         * Sets [Builder.minFollowing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minFollowing] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun minFollowing(minFollowing: JsonField<Long>) = apply { body.minFollowing(minFollowing) }

        /** Minimum post count for profile results. */
        fun minPosts(minPosts: Long) = apply { body.minPosts(minPosts) }

        /**
         * Sets [Builder.minPosts] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minPosts] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun minPosts(minPosts: JsonField<Long>) = apply { body.minPosts(minPosts) }

        /** Minimum quote count threshold (tweet_search_extractor) */
        fun minQuotes(minQuotes: Long) = apply { body.minQuotes(minQuotes) }

        /**
         * Sets [Builder.minQuotes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minQuotes] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun minQuotes(minQuotes: JsonField<Long>) = apply { body.minQuotes(minQuotes) }

        /** Minimum replies threshold (tweet_search_extractor) */
        fun minReplies(minReplies: Long) = apply { body.minReplies(minReplies) }

        /**
         * Sets [Builder.minReplies] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minReplies] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun minReplies(minReplies: JsonField<Long>) = apply { body.minReplies(minReplies) }

        /** Minimum retweets threshold (tweet_search_extractor) */
        fun minRetweets(minRetweets: Long) = apply { body.minRetweets(minRetweets) }

        /**
         * Sets [Builder.minRetweets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minRetweets] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun minRetweets(minRetweets: JsonField<Long>) = apply { body.minRetweets(minRetweets) }

        /** Minimum Tweet view count. */
        fun minViews(minViews: Long) = apply { body.minViews(minViews) }

        /**
         * Sets [Builder.minViews] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minViews] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun minViews(minViews: JsonField<Long>) = apply { body.minViews(minViews) }

        /** Only return native reposts. */
        fun nativeRetweets(nativeRetweets: Boolean) = apply { body.nativeRetweets(nativeRetweets) }

        /**
         * Sets [Builder.nativeRetweets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nativeRetweets] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun nativeRetweets(nativeRetweets: JsonField<Boolean>) = apply {
            body.nativeRetweets(nativeRetweets)
        }

        /** Match a place name. */
        fun near(near: String) = apply { body.near(near) }

        /**
         * Sets [Builder.near] to an arbitrary JSON value.
         *
         * You should usually call [Builder.near] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun near(near: JsonField<String>) = apply { body.near(near) }

        /** Only return news results. */
        fun news(news: Boolean) = apply { body.news(news) }

        /**
         * Sets [Builder.news] to an arbitrary JSON value.
         *
         * You should usually call [Builder.news] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun news(news: JsonField<Boolean>) = apply { body.news(news) }

        /** Shortcut for dedupeMode=merge. */
        fun overlapMode(overlapMode: Boolean) = apply { body.overlapMode(overlapMode) }

        /**
         * Sets [Builder.overlapMode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.overlapMode] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun overlapMode(overlapMode: JsonField<Boolean>) = apply { body.overlapMode(overlapMode) }

        /** Search within a place ID (tweet_search_extractor) */
        fun place(place: String) = apply { body.place(place) }

        /**
         * Sets [Builder.place] to an arbitrary JSON value.
         *
         * You should usually call [Builder.place] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun place(place: JsonField<String>) = apply { body.place(place) }

        /** Search within a country code (tweet_search_extractor) */
        fun placeCountry(placeCountry: String) = apply { body.placeCountry(placeCountry) }

        /**
         * Sets [Builder.placeCountry] to an arbitrary JSON value.
         *
         * You should usually call [Builder.placeCountry] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun placeCountry(placeCountry: JsonField<String>) = apply {
            body.placeCountry(placeCountry)
        }

        /** Geo point radius, e.g. -73.99 40.73 25mi (tweet_search_extractor) */
        fun pointRadius(pointRadius: String) = apply { body.pointRadius(pointRadius) }

        /**
         * Sets [Builder.pointRadius] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pointRadius] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun pointRadius(pointRadius: JsonField<String>) = apply { body.pointRadius(pointRadius) }

        /** Search ranking applied to every query. */
        fun queryType(queryType: QueryType) = apply { body.queryType(queryType) }

        /**
         * Sets [Builder.queryType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.queryType] with a well-typed [QueryType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun queryType(queryType: JsonField<QueryType>) = apply { body.queryType(queryType) }

        /** Quote mode (tweet_search_extractor) */
        fun quotes(quotes: Quotes) = apply { body.quotes(quotes) }

        /**
         * Sets [Builder.quotes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quotes] with a well-typed [Quotes] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun quotes(quotes: JsonField<Quotes>) = apply { body.quotes(quotes) }

        /** Only quotes of this tweet ID (tweet_search_extractor) */
        fun quotesOfTweetId(quotesOfTweetId: String) = apply {
            body.quotesOfTweetId(quotesOfTweetId)
        }

        /**
         * Sets [Builder.quotesOfTweetId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quotesOfTweetId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun quotesOfTweetId(quotesOfTweetId: JsonField<String>) = apply {
            body.quotesOfTweetId(quotesOfTweetId)
        }

        /** Profile relations processed within one job. */
        fun relationTargets(relationTargets: List<RelationTarget>) = apply {
            body.relationTargets(relationTargets)
        }

        /**
         * Sets [Builder.relationTargets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.relationTargets] with a well-typed
         * `List<RelationTarget>` value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun relationTargets(relationTargets: JsonField<List<RelationTarget>>) = apply {
            body.relationTargets(relationTargets)
        }

        /**
         * Adds a single [RelationTarget] to [relationTargets].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRelationTarget(relationTarget: RelationTarget) = apply {
            body.addRelationTarget(relationTarget)
        }

        /** Reply mode (tweet_search_extractor) */
        fun replies(replies: Replies) = apply { body.replies(replies) }

        /**
         * Sets [Builder.replies] to an arbitrary JSON value.
         *
         * You should usually call [Builder.replies] with a well-typed [Replies] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun replies(replies: JsonField<Replies>) = apply { body.replies(replies) }

        /**
         * Maximum number of results to extract. When set, the extraction stops after reaching this
         * limit.
         */
        fun resultsLimit(resultsLimit: Long) = apply { body.resultsLimit(resultsLimit) }

        /**
         * Sets [Builder.resultsLimit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.resultsLimit] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun resultsLimit(resultsLimit: JsonField<Long>) = apply { body.resultsLimit(resultsLimit) }

        /** Retweet mode (tweet_search_extractor) */
        fun retweets(retweets: Retweets) = apply { body.retweets(retweets) }

        /**
         * Sets [Builder.retweets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.retweets] with a well-typed [Retweets] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun retweets(retweets: JsonField<Retweets>) = apply { body.retweets(retweets) }

        /** Only retweets of this tweet ID (tweet_search_extractor) */
        fun retweetsOfTweetId(retweetsOfTweetId: String) = apply {
            body.retweetsOfTweetId(retweetsOfTweetId)
        }

        /**
         * Sets [Builder.retweetsOfTweetId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.retweetsOfTweetId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun retweetsOfTweetId(retweetsOfTweetId: JsonField<String>) = apply {
            body.retweetsOfTweetId(retweetsOfTweetId)
        }

        /** Enable the safe-search filter. */
        fun safe(safe: Boolean) = apply { body.safe(safe) }

        /**
         * Sets [Builder.safe] to an arbitrary JSON value.
         *
         * You should usually call [Builder.safe] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun safe(safe: JsonField<Boolean>) = apply { body.safe(safe) }

        /** Reply depth scope. */
        fun scope(scope: Scope) = apply { body.scope(scope) }

        /**
         * Sets [Builder.scope] to an arbitrary JSON value.
         *
         * You should usually call [Builder.scope] with a well-typed [Scope] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun scope(scope: JsonField<Scope>) = apply { body.scope(scope) }

        /** Search queries processed as one collection job. */
        fun searchQueries(searchQueries: List<String>) = apply { body.searchQueries(searchQueries) }

        /**
         * Sets [Builder.searchQueries] to an arbitrary JSON value.
         *
         * You should usually call [Builder.searchQueries] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun searchQueries(searchQueries: JsonField<List<String>>) = apply {
            body.searchQueries(searchQueries)
        }

        /**
         * Adds a single [String] to [searchQueries].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSearchQuery(searchQuery: String) = apply { body.addSearchQuery(searchQuery) }

        /** Required for tweet_search_extractor & community_search. */
        fun searchQuery(searchQuery: String) = apply { body.searchQuery(searchQuery) }

        /**
         * Sets [Builder.searchQuery] to an arbitrary JSON value.
         *
         * You should usually call [Builder.searchQuery] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun searchQuery(searchQuery: JsonField<String>) = apply { body.searchQuery(searchQuery) }

        /** Start date YYYY-MM-DD (tweet_search_extractor) */
        fun sinceDate(sinceDate: LocalDate) = apply { body.sinceDate(sinceDate) }

        /**
         * Sets [Builder.sinceDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sinceDate] with a well-typed [LocalDate] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sinceDate(sinceDate: JsonField<LocalDate>) = apply { body.sinceDate(sinceDate) }

        /** Return Tweets newer than this Tweet ID. */
        fun sinceId(sinceId: String) = apply { body.sinceId(sinceId) }

        /**
         * Sets [Builder.sinceId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sinceId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sinceId(sinceId: JsonField<String>) = apply { body.sinceId(sinceId) }

        /** Reply start time as ISO 8601 or Unix seconds. */
        fun sinceTime(sinceTime: SinceTime) = apply { body.sinceTime(sinceTime) }

        /**
         * Sets [Builder.sinceTime] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sinceTime] with a well-typed [SinceTime] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sinceTime(sinceTime: JsonField<SinceTime>) = apply { body.sinceTime(sinceTime) }

        /** Alias for calling [sinceTime] with `SinceTime.ofOffsetDate(offsetDate)`. */
        fun sinceTime(offsetDate: OffsetDateTime) = apply { body.sinceTime(offsetDate) }

        /** Alias for calling [sinceTime] with `SinceTime.ofInteger(integer)`. */
        fun sinceTime(integer: Long) = apply { body.sinceTime(integer) }

        /** Reply result order. */
        fun sort(sort: Sort) = apply { body.sort(sort) }

        /**
         * Sets [Builder.sort] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sort] with a well-typed [Sort] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sort(sort: JsonField<Sort>) = apply { body.sort(sort) }

        /** Match the source application. */
        fun source(source: String) = apply { body.source(source) }

        /**
         * Sets [Builder.source] to an arbitrary JSON value.
         *
         * You should usually call [Builder.source] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun source(source: JsonField<String>) = apply { body.source(source) }

        /** Resume one reply target from this cursor. */
        fun startCursor(startCursor: String) = apply { body.startCursor(startCursor) }

        /**
         * Sets [Builder.startCursor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.startCursor] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun startCursor(startCursor: JsonField<String>) = apply { body.startCursor(startCursor) }

        /** Required for community_post_extractor & community_search. */
        fun targetCommunityId(targetCommunityId: String) = apply {
            body.targetCommunityId(targetCommunityId)
        }

        /**
         * Sets [Builder.targetCommunityId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targetCommunityId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun targetCommunityId(targetCommunityId: JsonField<String>) = apply {
            body.targetCommunityId(targetCommunityId)
        }

        /** Community IDs processed as one collection job. */
        fun targetCommunityIds(targetCommunityIds: List<String>) = apply {
            body.targetCommunityIds(targetCommunityIds)
        }

        /**
         * Sets [Builder.targetCommunityIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targetCommunityIds] with a well-typed `List<String>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun targetCommunityIds(targetCommunityIds: JsonField<List<String>>) = apply {
            body.targetCommunityIds(targetCommunityIds)
        }

        /**
         * Adds a single [String] to [targetCommunityIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTargetCommunityId(targetCommunityId: String) = apply {
            body.addTargetCommunityId(targetCommunityId)
        }

        /** Required for list_follower_explorer, list_member_extractor & list_post_extractor. */
        fun targetListId(targetListId: String) = apply { body.targetListId(targetListId) }

        /**
         * Sets [Builder.targetListId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targetListId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun targetListId(targetListId: JsonField<String>) = apply {
            body.targetListId(targetListId)
        }

        /** List IDs processed as one collection job. */
        fun targetListIds(targetListIds: List<String>) = apply { body.targetListIds(targetListIds) }

        /**
         * Sets [Builder.targetListIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targetListIds] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun targetListIds(targetListIds: JsonField<List<String>>) = apply {
            body.targetListIds(targetListIds)
        }

        /**
         * Adds a single [String] to [targetListIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTargetListId(targetListId: String) = apply { body.addTargetListId(targetListId) }

        /** Mixed targets auto-routed within one job. */
        fun targets(targets: List<Target>) = apply { body.targets(targets) }

        /**
         * Sets [Builder.targets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targets] with a well-typed `List<Target>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun targets(targets: JsonField<List<Target>>) = apply { body.targets(targets) }

        /**
         * Adds a single [Target] to [targets].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTarget(target: Target) = apply { body.addTarget(target) }

        /** Alias for calling [addTarget] with `Target.ofString(string)`. */
        fun addTarget(string: String) = apply { body.addTarget(string) }

        /** Alias for calling [addTarget] with `Target.ofUnionMember1(unionMember1)`. */
        fun addTarget(unionMember1: Target.UnionMember1) = apply { body.addTarget(unionMember1) }

        /** Required for space_explorer. */
        fun targetSpaceId(targetSpaceId: String) = apply { body.targetSpaceId(targetSpaceId) }

        /**
         * Sets [Builder.targetSpaceId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targetSpaceId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun targetSpaceId(targetSpaceId: JsonField<String>) = apply {
            body.targetSpaceId(targetSpaceId)
        }

        fun targetTweetId(targetTweetId: String) = apply { body.targetTweetId(targetTweetId) }

        /**
         * Sets [Builder.targetTweetId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targetTweetId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun targetTweetId(targetTweetId: JsonField<String>) = apply {
            body.targetTweetId(targetTweetId)
        }

        /** Tweet IDs processed as one collection job. */
        fun targetTweetIds(targetTweetIds: List<String>) = apply {
            body.targetTweetIds(targetTweetIds)
        }

        /**
         * Sets [Builder.targetTweetIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targetTweetIds] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun targetTweetIds(targetTweetIds: JsonField<List<String>>) = apply {
            body.targetTweetIds(targetTweetIds)
        }

        /**
         * Adds a single [String] to [targetTweetIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTargetTweetId(targetTweetId: String) = apply { body.addTargetTweetId(targetTweetId) }

        fun targetUsername(targetUsername: String) = apply { body.targetUsername(targetUsername) }

        /**
         * Sets [Builder.targetUsername] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targetUsername] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun targetUsername(targetUsername: JsonField<String>) = apply {
            body.targetUsername(targetUsername)
        }

        /** Usernames processed as one collection job. */
        fun targetUsernames(targetUsernames: List<String>) = apply {
            body.targetUsernames(targetUsernames)
        }

        /**
         * Sets [Builder.targetUsernames] to an arbitrary JSON value.
         *
         * You should usually call [Builder.targetUsernames] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun targetUsernames(targetUsernames: JsonField<List<String>>) = apply {
            body.targetUsernames(targetUsernames)
        }

        /**
         * Adds a single [String] to [targetUsernames].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTargetUsername(targetUsername: String) = apply {
            body.addTargetUsername(targetUsername)
        }

        /** Filter replies sent to a username (tweet_search_extractor) */
        fun toUser(toUser: String) = apply { body.toUser(toUser) }

        /**
         * Sets [Builder.toUser] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toUser] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun toUser(toUser: JsonField<String>) = apply { body.toUser(toUser) }

        /** End date YYYY-MM-DD (tweet_search_extractor) */
        fun untilDate(untilDate: LocalDate) = apply { body.untilDate(untilDate) }

        /**
         * Sets [Builder.untilDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.untilDate] with a well-typed [LocalDate] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun untilDate(untilDate: JsonField<LocalDate>) = apply { body.untilDate(untilDate) }

        /** Reply end time as ISO 8601 or Unix seconds. */
        fun untilTime(untilTime: UntilTime) = apply { body.untilTime(untilTime) }

        /**
         * Sets [Builder.untilTime] to an arbitrary JSON value.
         *
         * You should usually call [Builder.untilTime] with a well-typed [UntilTime] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun untilTime(untilTime: JsonField<UntilTime>) = apply { body.untilTime(untilTime) }

        /** Alias for calling [untilTime] with `UntilTime.ofOffsetDate(offsetDate)`. */
        fun untilTime(offsetDate: OffsetDateTime) = apply { body.untilTime(offsetDate) }

        /** Alias for calling [untilTime] with `UntilTime.ofInteger(integer)`. */
        fun untilTime(integer: Long) = apply { body.untilTime(integer) }

        /** URL substring or domain filter (tweet_search_extractor) */
        fun url(url: String) = apply { body.url(url) }

        /**
         * Sets [Builder.url] to an arbitrary JSON value.
         *
         * You should usually call [Builder.url] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun url(url: JsonField<String>) = apply { body.url(url) }

        /** Required username text. */
        fun usernameContains(usernameContains: String) = apply {
            body.usernameContains(usernameContains)
        }

        /**
         * Sets [Builder.usernameContains] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usernameContains] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun usernameContains(usernameContains: JsonField<String>) = apply {
            body.usernameContains(usernameContains)
        }

        /** Only verified authors (tweet_search_extractor) */
        fun verifiedOnly(verifiedOnly: Boolean) = apply { body.verifiedOnly(verifiedOnly) }

        /**
         * Sets [Builder.verifiedOnly] to an arbitrary JSON value.
         *
         * You should usually call [Builder.verifiedOnly] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun verifiedOnly(verifiedOnly: JsonField<Boolean>) = apply {
            body.verifiedOnly(verifiedOnly)
        }

        /** Exact profile verification type. */
        fun verifiedType(verifiedType: String) = apply { body.verifiedType(verifiedType) }

        /**
         * Sets [Builder.verifiedType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.verifiedType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun verifiedType(verifiedType: JsonField<String>) = apply {
            body.verifiedType(verifiedType)
        }

        /** Set the radius for the near filter. */
        fun within(within: String) = apply { body.within(within) }

        /**
         * Sets [Builder.within] to an arbitrary JSON value.
         *
         * You should usually call [Builder.within] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun within(within: JsonField<String>) = apply { body.within(within) }

        /** Match Tweets inside a recent time window. */
        fun withinTime(withinTime: String) = apply { body.withinTime(withinTime) }

        /**
         * Sets [Builder.withinTime] to an arbitrary JSON value.
         *
         * You should usually call [Builder.withinTime] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun withinTime(withinTime: JsonField<String>) = apply { body.withinTime(withinTime) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [ExtractionEstimateCostParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .toolType()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ExtractionEstimateCostParams =
            ExtractionEstimateCostParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** One synchronous estimate or asynchronous extraction request. */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val toolType: JsonField<ToolType>,
        private val advancedQuery: JsonField<String>,
        private val anyWords: JsonField<String>,
        private val bioContains: JsonField<String>,
        private val blueVerifiedOnly: JsonField<Boolean>,
        private val boundingBox: JsonField<String>,
        private val cardName: JsonField<String>,
        private val cashtags: JsonField<String>,
        private val collectionStrategy: JsonField<CollectionStrategy>,
        private val conversationId: JsonField<String>,
        private val dedupeAcrossTargets: JsonField<Boolean>,
        private val dedupeMode: JsonField<DedupeMode>,
        private val exactPhrase: JsonField<String>,
        private val excludeOriginalAuthor: JsonField<Boolean>,
        private val excludeSource: JsonField<String>,
        private val excludeWords: JsonField<String>,
        private val fromUser: JsonField<String>,
        private val geocode: JsonField<String>,
        private val hashtags: JsonField<String>,
        private val hasLocation: JsonField<Boolean>,
        private val hasMediaOnly: JsonField<Boolean>,
        private val hasWebsite: JsonField<Boolean>,
        private val includeOriginalPost: JsonField<Boolean>,
        private val includeSearchTerms: JsonField<Boolean>,
        private val includeTargetMetadata: JsonField<Boolean>,
        private val inReplyToTweetId: JsonField<String>,
        private val language: JsonField<String>,
        private val listId: JsonField<String>,
        private val locationContains: JsonField<String>,
        private val maxDepth: JsonField<Long>,
        private val maxFollowers: JsonField<Long>,
        private val maxFollowing: JsonField<Long>,
        private val maxId: JsonField<String>,
        private val maxItemsPerTarget: JsonField<Long>,
        private val maxLikes: JsonField<Long>,
        private val maxPagesPerTarget: JsonField<Long>,
        private val maxPosts: JsonField<Long>,
        private val maxQuotes: JsonField<Long>,
        private val maxReplies: JsonField<Long>,
        private val maxRetweets: JsonField<Long>,
        private val mediaType: JsonField<MediaType>,
        private val mentioning: JsonField<String>,
        private val minAccountAgeDays: JsonField<Long>,
        private val minBookmarks: JsonField<Long>,
        private val minFaves: JsonField<Long>,
        private val minFollowers: JsonField<Long>,
        private val minFollowing: JsonField<Long>,
        private val minPosts: JsonField<Long>,
        private val minQuotes: JsonField<Long>,
        private val minReplies: JsonField<Long>,
        private val minRetweets: JsonField<Long>,
        private val minViews: JsonField<Long>,
        private val nativeRetweets: JsonField<Boolean>,
        private val near: JsonField<String>,
        private val news: JsonField<Boolean>,
        private val overlapMode: JsonField<Boolean>,
        private val place: JsonField<String>,
        private val placeCountry: JsonField<String>,
        private val pointRadius: JsonField<String>,
        private val queryType: JsonField<QueryType>,
        private val quotes: JsonField<Quotes>,
        private val quotesOfTweetId: JsonField<String>,
        private val relationTargets: JsonField<List<RelationTarget>>,
        private val replies: JsonField<Replies>,
        private val resultsLimit: JsonField<Long>,
        private val retweets: JsonField<Retweets>,
        private val retweetsOfTweetId: JsonField<String>,
        private val safe: JsonField<Boolean>,
        private val scope: JsonField<Scope>,
        private val searchQueries: JsonField<List<String>>,
        private val searchQuery: JsonField<String>,
        private val sinceDate: JsonField<LocalDate>,
        private val sinceId: JsonField<String>,
        private val sinceTime: JsonField<SinceTime>,
        private val sort: JsonField<Sort>,
        private val source: JsonField<String>,
        private val startCursor: JsonField<String>,
        private val targetCommunityId: JsonField<String>,
        private val targetCommunityIds: JsonField<List<String>>,
        private val targetListId: JsonField<String>,
        private val targetListIds: JsonField<List<String>>,
        private val targets: JsonField<List<Target>>,
        private val targetSpaceId: JsonField<String>,
        private val targetTweetId: JsonField<String>,
        private val targetTweetIds: JsonField<List<String>>,
        private val targetUsername: JsonField<String>,
        private val targetUsernames: JsonField<List<String>>,
        private val toUser: JsonField<String>,
        private val untilDate: JsonField<LocalDate>,
        private val untilTime: JsonField<UntilTime>,
        private val url: JsonField<String>,
        private val usernameContains: JsonField<String>,
        private val verifiedOnly: JsonField<Boolean>,
        private val verifiedType: JsonField<String>,
        private val within: JsonField<String>,
        private val withinTime: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("toolType")
            @ExcludeMissing
            toolType: JsonField<ToolType> = JsonMissing.of(),
            @JsonProperty("advancedQuery")
            @ExcludeMissing
            advancedQuery: JsonField<String> = JsonMissing.of(),
            @JsonProperty("anyWords")
            @ExcludeMissing
            anyWords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bioContains")
            @ExcludeMissing
            bioContains: JsonField<String> = JsonMissing.of(),
            @JsonProperty("blueVerifiedOnly")
            @ExcludeMissing
            blueVerifiedOnly: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("boundingBox")
            @ExcludeMissing
            boundingBox: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cardName")
            @ExcludeMissing
            cardName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cashtags")
            @ExcludeMissing
            cashtags: JsonField<String> = JsonMissing.of(),
            @JsonProperty("collectionStrategy")
            @ExcludeMissing
            collectionStrategy: JsonField<CollectionStrategy> = JsonMissing.of(),
            @JsonProperty("conversationId")
            @ExcludeMissing
            conversationId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("dedupeAcrossTargets")
            @ExcludeMissing
            dedupeAcrossTargets: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("dedupeMode")
            @ExcludeMissing
            dedupeMode: JsonField<DedupeMode> = JsonMissing.of(),
            @JsonProperty("exactPhrase")
            @ExcludeMissing
            exactPhrase: JsonField<String> = JsonMissing.of(),
            @JsonProperty("excludeOriginalAuthor")
            @ExcludeMissing
            excludeOriginalAuthor: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("excludeSource")
            @ExcludeMissing
            excludeSource: JsonField<String> = JsonMissing.of(),
            @JsonProperty("excludeWords")
            @ExcludeMissing
            excludeWords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("fromUser")
            @ExcludeMissing
            fromUser: JsonField<String> = JsonMissing.of(),
            @JsonProperty("geocode") @ExcludeMissing geocode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("hashtags")
            @ExcludeMissing
            hashtags: JsonField<String> = JsonMissing.of(),
            @JsonProperty("hasLocation")
            @ExcludeMissing
            hasLocation: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("hasMediaOnly")
            @ExcludeMissing
            hasMediaOnly: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("hasWebsite")
            @ExcludeMissing
            hasWebsite: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("includeOriginalPost")
            @ExcludeMissing
            includeOriginalPost: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("includeSearchTerms")
            @ExcludeMissing
            includeSearchTerms: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("includeTargetMetadata")
            @ExcludeMissing
            includeTargetMetadata: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("inReplyToTweetId")
            @ExcludeMissing
            inReplyToTweetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("language")
            @ExcludeMissing
            language: JsonField<String> = JsonMissing.of(),
            @JsonProperty("listId") @ExcludeMissing listId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("locationContains")
            @ExcludeMissing
            locationContains: JsonField<String> = JsonMissing.of(),
            @JsonProperty("maxDepth") @ExcludeMissing maxDepth: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("maxFollowers")
            @ExcludeMissing
            maxFollowers: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("maxFollowing")
            @ExcludeMissing
            maxFollowing: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("maxId") @ExcludeMissing maxId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("maxItemsPerTarget")
            @ExcludeMissing
            maxItemsPerTarget: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("maxLikes") @ExcludeMissing maxLikes: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("maxPagesPerTarget")
            @ExcludeMissing
            maxPagesPerTarget: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("maxPosts") @ExcludeMissing maxPosts: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("maxQuotes")
            @ExcludeMissing
            maxQuotes: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("maxReplies")
            @ExcludeMissing
            maxReplies: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("maxRetweets")
            @ExcludeMissing
            maxRetweets: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("mediaType")
            @ExcludeMissing
            mediaType: JsonField<MediaType> = JsonMissing.of(),
            @JsonProperty("mentioning")
            @ExcludeMissing
            mentioning: JsonField<String> = JsonMissing.of(),
            @JsonProperty("minAccountAgeDays")
            @ExcludeMissing
            minAccountAgeDays: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("minBookmarks")
            @ExcludeMissing
            minBookmarks: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("minFaves") @ExcludeMissing minFaves: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("minFollowers")
            @ExcludeMissing
            minFollowers: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("minFollowing")
            @ExcludeMissing
            minFollowing: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("minPosts") @ExcludeMissing minPosts: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("minQuotes")
            @ExcludeMissing
            minQuotes: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("minReplies")
            @ExcludeMissing
            minReplies: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("minRetweets")
            @ExcludeMissing
            minRetweets: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("minViews") @ExcludeMissing minViews: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("nativeRetweets")
            @ExcludeMissing
            nativeRetweets: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("near") @ExcludeMissing near: JsonField<String> = JsonMissing.of(),
            @JsonProperty("news") @ExcludeMissing news: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("overlapMode")
            @ExcludeMissing
            overlapMode: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("place") @ExcludeMissing place: JsonField<String> = JsonMissing.of(),
            @JsonProperty("placeCountry")
            @ExcludeMissing
            placeCountry: JsonField<String> = JsonMissing.of(),
            @JsonProperty("pointRadius")
            @ExcludeMissing
            pointRadius: JsonField<String> = JsonMissing.of(),
            @JsonProperty("queryType")
            @ExcludeMissing
            queryType: JsonField<QueryType> = JsonMissing.of(),
            @JsonProperty("quotes") @ExcludeMissing quotes: JsonField<Quotes> = JsonMissing.of(),
            @JsonProperty("quotesOfTweetId")
            @ExcludeMissing
            quotesOfTweetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("relationTargets")
            @ExcludeMissing
            relationTargets: JsonField<List<RelationTarget>> = JsonMissing.of(),
            @JsonProperty("replies") @ExcludeMissing replies: JsonField<Replies> = JsonMissing.of(),
            @JsonProperty("resultsLimit")
            @ExcludeMissing
            resultsLimit: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("retweets")
            @ExcludeMissing
            retweets: JsonField<Retweets> = JsonMissing.of(),
            @JsonProperty("retweetsOfTweetId")
            @ExcludeMissing
            retweetsOfTweetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("safe") @ExcludeMissing safe: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("scope") @ExcludeMissing scope: JsonField<Scope> = JsonMissing.of(),
            @JsonProperty("searchQueries")
            @ExcludeMissing
            searchQueries: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("searchQuery")
            @ExcludeMissing
            searchQuery: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sinceDate")
            @ExcludeMissing
            sinceDate: JsonField<LocalDate> = JsonMissing.of(),
            @JsonProperty("sinceId") @ExcludeMissing sinceId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sinceTime")
            @ExcludeMissing
            sinceTime: JsonField<SinceTime> = JsonMissing.of(),
            @JsonProperty("sort") @ExcludeMissing sort: JsonField<Sort> = JsonMissing.of(),
            @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
            @JsonProperty("startCursor")
            @ExcludeMissing
            startCursor: JsonField<String> = JsonMissing.of(),
            @JsonProperty("targetCommunityId")
            @ExcludeMissing
            targetCommunityId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("targetCommunityIds")
            @ExcludeMissing
            targetCommunityIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("targetListId")
            @ExcludeMissing
            targetListId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("targetListIds")
            @ExcludeMissing
            targetListIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("targets")
            @ExcludeMissing
            targets: JsonField<List<Target>> = JsonMissing.of(),
            @JsonProperty("targetSpaceId")
            @ExcludeMissing
            targetSpaceId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("targetTweetId")
            @ExcludeMissing
            targetTweetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("targetTweetIds")
            @ExcludeMissing
            targetTweetIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("targetUsername")
            @ExcludeMissing
            targetUsername: JsonField<String> = JsonMissing.of(),
            @JsonProperty("targetUsernames")
            @ExcludeMissing
            targetUsernames: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("toUser") @ExcludeMissing toUser: JsonField<String> = JsonMissing.of(),
            @JsonProperty("untilDate")
            @ExcludeMissing
            untilDate: JsonField<LocalDate> = JsonMissing.of(),
            @JsonProperty("untilTime")
            @ExcludeMissing
            untilTime: JsonField<UntilTime> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("usernameContains")
            @ExcludeMissing
            usernameContains: JsonField<String> = JsonMissing.of(),
            @JsonProperty("verifiedOnly")
            @ExcludeMissing
            verifiedOnly: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("verifiedType")
            @ExcludeMissing
            verifiedType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("within") @ExcludeMissing within: JsonField<String> = JsonMissing.of(),
            @JsonProperty("withinTime")
            @ExcludeMissing
            withinTime: JsonField<String> = JsonMissing.of(),
        ) : this(
            toolType,
            advancedQuery,
            anyWords,
            bioContains,
            blueVerifiedOnly,
            boundingBox,
            cardName,
            cashtags,
            collectionStrategy,
            conversationId,
            dedupeAcrossTargets,
            dedupeMode,
            exactPhrase,
            excludeOriginalAuthor,
            excludeSource,
            excludeWords,
            fromUser,
            geocode,
            hashtags,
            hasLocation,
            hasMediaOnly,
            hasWebsite,
            includeOriginalPost,
            includeSearchTerms,
            includeTargetMetadata,
            inReplyToTweetId,
            language,
            listId,
            locationContains,
            maxDepth,
            maxFollowers,
            maxFollowing,
            maxId,
            maxItemsPerTarget,
            maxLikes,
            maxPagesPerTarget,
            maxPosts,
            maxQuotes,
            maxReplies,
            maxRetweets,
            mediaType,
            mentioning,
            minAccountAgeDays,
            minBookmarks,
            minFaves,
            minFollowers,
            minFollowing,
            minPosts,
            minQuotes,
            minReplies,
            minRetweets,
            minViews,
            nativeRetweets,
            near,
            news,
            overlapMode,
            place,
            placeCountry,
            pointRadius,
            queryType,
            quotes,
            quotesOfTweetId,
            relationTargets,
            replies,
            resultsLimit,
            retweets,
            retweetsOfTweetId,
            safe,
            scope,
            searchQueries,
            searchQuery,
            sinceDate,
            sinceId,
            sinceTime,
            sort,
            source,
            startCursor,
            targetCommunityId,
            targetCommunityIds,
            targetListId,
            targetListIds,
            targets,
            targetSpaceId,
            targetTweetId,
            targetTweetIds,
            targetUsername,
            targetUsernames,
            toUser,
            untilDate,
            untilTime,
            url,
            usernameContains,
            verifiedOnly,
            verifiedType,
            within,
            withinTime,
            mutableMapOf(),
        )

        /**
         * Identifier for the extraction tool used to run a job.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun toolType(): ToolType = toolType.getRequired("toolType")

        /**
         * Raw advanced search query appended as-is (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun advancedQuery(): Optional<String> = advancedQuery.getOptional("advancedQuery")

        /**
         * Words or quoted phrases where any one can match. Separate with spaces, commas, or lines.
         * (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun anyWords(): Optional<String> = anyWords.getOptional("anyWords")

        /**
         * Bio terms separated by commas or lines.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun bioContains(): Optional<String> = bioContains.getOptional("bioContains")

        /**
         * Return only Blue-verified Tweet authors.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun blueVerifiedOnly(): Optional<Boolean> = blueVerifiedOnly.getOptional("blueVerifiedOnly")

        /**
         * Geo bounding box, e.g. -74.1 40.6 -73.9 40.8 (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun boundingBox(): Optional<String> = boundingBox.getOptional("boundingBox")

        /**
         * Match the Tweet card name.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun cardName(): Optional<String> = cardName.getOptional("cardName")

        /**
         * Cashtags separated by spaces, commas, or lines. (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun cashtags(): Optional<String> = cashtags.getOptional("cashtags")

        /**
         * Reply collection strategy.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun collectionStrategy(): Optional<CollectionStrategy> =
            collectionStrategy.getOptional("collectionStrategy")

        /**
         * Conversation ID filter (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun conversationId(): Optional<String> = conversationId.getOptional("conversationId")

        /**
         * Merge duplicate results across collection targets.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun dedupeAcrossTargets(): Optional<Boolean> =
            dedupeAcrossTargets.getOptional("dedupeAcrossTargets")

        /**
         * Keep target duplicates, first rows, or merged overlap.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun dedupeMode(): Optional<DedupeMode> = dedupeMode.getOptional("dedupeMode")

        /**
         * Exact phrase to match (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun exactPhrase(): Optional<String> = exactPhrase.getOptional("exactPhrase")

        /**
         * Exclude replies from the source author.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun excludeOriginalAuthor(): Optional<Boolean> =
            excludeOriginalAuthor.getOptional("excludeOriginalAuthor")

        /**
         * Exclude a source application.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun excludeSource(): Optional<String> = excludeSource.getOptional("excludeSource")

        /**
         * Words or quoted phrases to exclude. Separate with spaces, commas, or lines.
         * (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun excludeWords(): Optional<String> = excludeWords.getOptional("excludeWords")

        /**
         * Filter by author username (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun fromUser(): Optional<String> = fromUser.getOptional("fromUser")

        /**
         * Match latitude, longitude, and radius.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun geocode(): Optional<String> = geocode.getOptional("geocode")

        /**
         * Hashtags separated by spaces, commas, or lines. (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun hashtags(): Optional<String> = hashtags.getOptional("hashtags")

        /**
         * Require a profile location.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun hasLocation(): Optional<Boolean> = hasLocation.getOptional("hasLocation")

        /**
         * Return only replies with media.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun hasMediaOnly(): Optional<Boolean> = hasMediaOnly.getOptional("hasMediaOnly")

        /**
         * Require a profile website.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun hasWebsite(): Optional<Boolean> = hasWebsite.getOptional("hasWebsite")

        /**
         * Include the source post in reply results.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun includeOriginalPost(): Optional<Boolean> =
            includeOriginalPost.getOptional("includeOriginalPost")

        /**
         * Add matching search terms to collection metadata.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun includeSearchTerms(): Optional<Boolean> =
            includeSearchTerms.getOptional("includeSearchTerms")

        /**
         * Add source target metadata to each result.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun includeTargetMetadata(): Optional<Boolean> =
            includeTargetMetadata.getOptional("includeTargetMetadata")

        /**
         * Only replies to this tweet ID (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun inReplyToTweetId(): Optional<String> = inReplyToTweetId.getOptional("inReplyToTweetId")

        /**
         * Language code filter (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun language(): Optional<String> = language.getOptional("language")

        /**
         * Search within a list ID (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun listId(): Optional<String> = listId.getOptional("listId")

        /**
         * Required profile location text.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun locationContains(): Optional<String> = locationContains.getOptional("locationContains")

        /**
         * Maximum nested reply depth.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun maxDepth(): Optional<Long> = maxDepth.getOptional("maxDepth")

        /**
         * Maximum follower count for profile results.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun maxFollowers(): Optional<Long> = maxFollowers.getOptional("maxFollowers")

        /**
         * Maximum following count for profile results.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun maxFollowing(): Optional<Long> = maxFollowing.getOptional("maxFollowing")

        /**
         * Return Tweets older than this Tweet ID.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun maxId(): Optional<String> = maxId.getOptional("maxId")

        /**
         * Maximum results collected for each target.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun maxItemsPerTarget(): Optional<Long> = maxItemsPerTarget.getOptional("maxItemsPerTarget")

        /**
         * Maximum Tweet like count.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun maxLikes(): Optional<Long> = maxLikes.getOptional("maxLikes")

        /**
         * Reply pages collected for each target.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun maxPagesPerTarget(): Optional<Long> = maxPagesPerTarget.getOptional("maxPagesPerTarget")

        /**
         * Maximum post count for profile results.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun maxPosts(): Optional<Long> = maxPosts.getOptional("maxPosts")

        /**
         * Maximum Tweet quote count.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun maxQuotes(): Optional<Long> = maxQuotes.getOptional("maxQuotes")

        /**
         * Maximum Tweet reply count.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun maxReplies(): Optional<Long> = maxReplies.getOptional("maxReplies")

        /**
         * Maximum Tweet repost count.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun maxRetweets(): Optional<Long> = maxRetweets.getOptional("maxRetweets")

        /**
         * Media type filter (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun mediaType(): Optional<MediaType> = mediaType.getOptional("mediaType")

        /**
         * Filter tweets mentioning a username (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun mentioning(): Optional<String> = mentioning.getOptional("mentioning")

        /**
         * Minimum profile age in days.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun minAccountAgeDays(): Optional<Long> = minAccountAgeDays.getOptional("minAccountAgeDays")

        /**
         * Minimum Tweet bookmark count.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun minBookmarks(): Optional<Long> = minBookmarks.getOptional("minBookmarks")

        /**
         * Minimum likes threshold (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun minFaves(): Optional<Long> = minFaves.getOptional("minFaves")

        /**
         * Minimum follower count for profile results.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun minFollowers(): Optional<Long> = minFollowers.getOptional("minFollowers")

        /**
         * Minimum following count for profile results.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun minFollowing(): Optional<Long> = minFollowing.getOptional("minFollowing")

        /**
         * Minimum post count for profile results.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun minPosts(): Optional<Long> = minPosts.getOptional("minPosts")

        /**
         * Minimum quote count threshold (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun minQuotes(): Optional<Long> = minQuotes.getOptional("minQuotes")

        /**
         * Minimum replies threshold (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun minReplies(): Optional<Long> = minReplies.getOptional("minReplies")

        /**
         * Minimum retweets threshold (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun minRetweets(): Optional<Long> = minRetweets.getOptional("minRetweets")

        /**
         * Minimum Tweet view count.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun minViews(): Optional<Long> = minViews.getOptional("minViews")

        /**
         * Only return native reposts.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun nativeRetweets(): Optional<Boolean> = nativeRetweets.getOptional("nativeRetweets")

        /**
         * Match a place name.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun near(): Optional<String> = near.getOptional("near")

        /**
         * Only return news results.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun news(): Optional<Boolean> = news.getOptional("news")

        /**
         * Shortcut for dedupeMode=merge.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun overlapMode(): Optional<Boolean> = overlapMode.getOptional("overlapMode")

        /**
         * Search within a place ID (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun place(): Optional<String> = place.getOptional("place")

        /**
         * Search within a country code (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun placeCountry(): Optional<String> = placeCountry.getOptional("placeCountry")

        /**
         * Geo point radius, e.g. -73.99 40.73 25mi (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun pointRadius(): Optional<String> = pointRadius.getOptional("pointRadius")

        /**
         * Search ranking applied to every query.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun queryType(): Optional<QueryType> = queryType.getOptional("queryType")

        /**
         * Quote mode (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun quotes(): Optional<Quotes> = quotes.getOptional("quotes")

        /**
         * Only quotes of this tweet ID (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun quotesOfTweetId(): Optional<String> = quotesOfTweetId.getOptional("quotesOfTweetId")

        /**
         * Profile relations processed within one job.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun relationTargets(): Optional<List<RelationTarget>> =
            relationTargets.getOptional("relationTargets")

        /**
         * Reply mode (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun replies(): Optional<Replies> = replies.getOptional("replies")

        /**
         * Maximum number of results to extract. When set, the extraction stops after reaching this
         * limit.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun resultsLimit(): Optional<Long> = resultsLimit.getOptional("resultsLimit")

        /**
         * Retweet mode (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun retweets(): Optional<Retweets> = retweets.getOptional("retweets")

        /**
         * Only retweets of this tweet ID (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun retweetsOfTweetId(): Optional<String> =
            retweetsOfTweetId.getOptional("retweetsOfTweetId")

        /**
         * Enable the safe-search filter.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun safe(): Optional<Boolean> = safe.getOptional("safe")

        /**
         * Reply depth scope.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun scope(): Optional<Scope> = scope.getOptional("scope")

        /**
         * Search queries processed as one collection job.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun searchQueries(): Optional<List<String>> = searchQueries.getOptional("searchQueries")

        /**
         * Required for tweet_search_extractor & community_search.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun searchQuery(): Optional<String> = searchQuery.getOptional("searchQuery")

        /**
         * Start date YYYY-MM-DD (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun sinceDate(): Optional<LocalDate> = sinceDate.getOptional("sinceDate")

        /**
         * Return Tweets newer than this Tweet ID.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun sinceId(): Optional<String> = sinceId.getOptional("sinceId")

        /**
         * Reply start time as ISO 8601 or Unix seconds.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun sinceTime(): Optional<SinceTime> = sinceTime.getOptional("sinceTime")

        /**
         * Reply result order.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun sort(): Optional<Sort> = sort.getOptional("sort")

        /**
         * Match the source application.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun source(): Optional<String> = source.getOptional("source")

        /**
         * Resume one reply target from this cursor.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun startCursor(): Optional<String> = startCursor.getOptional("startCursor")

        /**
         * Required for community_post_extractor & community_search.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targetCommunityId(): Optional<String> =
            targetCommunityId.getOptional("targetCommunityId")

        /**
         * Community IDs processed as one collection job.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targetCommunityIds(): Optional<List<String>> =
            targetCommunityIds.getOptional("targetCommunityIds")

        /**
         * Required for list_follower_explorer, list_member_extractor & list_post_extractor.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targetListId(): Optional<String> = targetListId.getOptional("targetListId")

        /**
         * List IDs processed as one collection job.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targetListIds(): Optional<List<String>> = targetListIds.getOptional("targetListIds")

        /**
         * Mixed targets auto-routed within one job.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targets(): Optional<List<Target>> = targets.getOptional("targets")

        /**
         * Required for space_explorer.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targetSpaceId(): Optional<String> = targetSpaceId.getOptional("targetSpaceId")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targetTweetId(): Optional<String> = targetTweetId.getOptional("targetTweetId")

        /**
         * Tweet IDs processed as one collection job.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targetTweetIds(): Optional<List<String>> = targetTweetIds.getOptional("targetTweetIds")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targetUsername(): Optional<String> = targetUsername.getOptional("targetUsername")

        /**
         * Usernames processed as one collection job.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun targetUsernames(): Optional<List<String>> =
            targetUsernames.getOptional("targetUsernames")

        /**
         * Filter replies sent to a username (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun toUser(): Optional<String> = toUser.getOptional("toUser")

        /**
         * End date YYYY-MM-DD (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun untilDate(): Optional<LocalDate> = untilDate.getOptional("untilDate")

        /**
         * Reply end time as ISO 8601 or Unix seconds.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun untilTime(): Optional<UntilTime> = untilTime.getOptional("untilTime")

        /**
         * URL substring or domain filter (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * Required username text.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun usernameContains(): Optional<String> = usernameContains.getOptional("usernameContains")

        /**
         * Only verified authors (tweet_search_extractor)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun verifiedOnly(): Optional<Boolean> = verifiedOnly.getOptional("verifiedOnly")

        /**
         * Exact profile verification type.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun verifiedType(): Optional<String> = verifiedType.getOptional("verifiedType")

        /**
         * Set the radius for the near filter.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun within(): Optional<String> = within.getOptional("within")

        /**
         * Match Tweets inside a recent time window.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun withinTime(): Optional<String> = withinTime.getOptional("withinTime")

        /**
         * Returns the raw JSON value of [toolType].
         *
         * Unlike [toolType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("toolType") @ExcludeMissing fun _toolType(): JsonField<ToolType> = toolType

        /**
         * Returns the raw JSON value of [advancedQuery].
         *
         * Unlike [advancedQuery], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("advancedQuery")
        @ExcludeMissing
        fun _advancedQuery(): JsonField<String> = advancedQuery

        /**
         * Returns the raw JSON value of [anyWords].
         *
         * Unlike [anyWords], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("anyWords") @ExcludeMissing fun _anyWords(): JsonField<String> = anyWords

        /**
         * Returns the raw JSON value of [bioContains].
         *
         * Unlike [bioContains], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bioContains")
        @ExcludeMissing
        fun _bioContains(): JsonField<String> = bioContains

        /**
         * Returns the raw JSON value of [blueVerifiedOnly].
         *
         * Unlike [blueVerifiedOnly], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("blueVerifiedOnly")
        @ExcludeMissing
        fun _blueVerifiedOnly(): JsonField<Boolean> = blueVerifiedOnly

        /**
         * Returns the raw JSON value of [boundingBox].
         *
         * Unlike [boundingBox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("boundingBox")
        @ExcludeMissing
        fun _boundingBox(): JsonField<String> = boundingBox

        /**
         * Returns the raw JSON value of [cardName].
         *
         * Unlike [cardName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cardName") @ExcludeMissing fun _cardName(): JsonField<String> = cardName

        /**
         * Returns the raw JSON value of [cashtags].
         *
         * Unlike [cashtags], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cashtags") @ExcludeMissing fun _cashtags(): JsonField<String> = cashtags

        /**
         * Returns the raw JSON value of [collectionStrategy].
         *
         * Unlike [collectionStrategy], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("collectionStrategy")
        @ExcludeMissing
        fun _collectionStrategy(): JsonField<CollectionStrategy> = collectionStrategy

        /**
         * Returns the raw JSON value of [conversationId].
         *
         * Unlike [conversationId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("conversationId")
        @ExcludeMissing
        fun _conversationId(): JsonField<String> = conversationId

        /**
         * Returns the raw JSON value of [dedupeAcrossTargets].
         *
         * Unlike [dedupeAcrossTargets], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("dedupeAcrossTargets")
        @ExcludeMissing
        fun _dedupeAcrossTargets(): JsonField<Boolean> = dedupeAcrossTargets

        /**
         * Returns the raw JSON value of [dedupeMode].
         *
         * Unlike [dedupeMode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("dedupeMode")
        @ExcludeMissing
        fun _dedupeMode(): JsonField<DedupeMode> = dedupeMode

        /**
         * Returns the raw JSON value of [exactPhrase].
         *
         * Unlike [exactPhrase], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("exactPhrase")
        @ExcludeMissing
        fun _exactPhrase(): JsonField<String> = exactPhrase

        /**
         * Returns the raw JSON value of [excludeOriginalAuthor].
         *
         * Unlike [excludeOriginalAuthor], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("excludeOriginalAuthor")
        @ExcludeMissing
        fun _excludeOriginalAuthor(): JsonField<Boolean> = excludeOriginalAuthor

        /**
         * Returns the raw JSON value of [excludeSource].
         *
         * Unlike [excludeSource], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("excludeSource")
        @ExcludeMissing
        fun _excludeSource(): JsonField<String> = excludeSource

        /**
         * Returns the raw JSON value of [excludeWords].
         *
         * Unlike [excludeWords], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("excludeWords")
        @ExcludeMissing
        fun _excludeWords(): JsonField<String> = excludeWords

        /**
         * Returns the raw JSON value of [fromUser].
         *
         * Unlike [fromUser], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fromUser") @ExcludeMissing fun _fromUser(): JsonField<String> = fromUser

        /**
         * Returns the raw JSON value of [geocode].
         *
         * Unlike [geocode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("geocode") @ExcludeMissing fun _geocode(): JsonField<String> = geocode

        /**
         * Returns the raw JSON value of [hashtags].
         *
         * Unlike [hashtags], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hashtags") @ExcludeMissing fun _hashtags(): JsonField<String> = hashtags

        /**
         * Returns the raw JSON value of [hasLocation].
         *
         * Unlike [hasLocation], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hasLocation")
        @ExcludeMissing
        fun _hasLocation(): JsonField<Boolean> = hasLocation

        /**
         * Returns the raw JSON value of [hasMediaOnly].
         *
         * Unlike [hasMediaOnly], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("hasMediaOnly")
        @ExcludeMissing
        fun _hasMediaOnly(): JsonField<Boolean> = hasMediaOnly

        /**
         * Returns the raw JSON value of [hasWebsite].
         *
         * Unlike [hasWebsite], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hasWebsite")
        @ExcludeMissing
        fun _hasWebsite(): JsonField<Boolean> = hasWebsite

        /**
         * Returns the raw JSON value of [includeOriginalPost].
         *
         * Unlike [includeOriginalPost], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("includeOriginalPost")
        @ExcludeMissing
        fun _includeOriginalPost(): JsonField<Boolean> = includeOriginalPost

        /**
         * Returns the raw JSON value of [includeSearchTerms].
         *
         * Unlike [includeSearchTerms], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("includeSearchTerms")
        @ExcludeMissing
        fun _includeSearchTerms(): JsonField<Boolean> = includeSearchTerms

        /**
         * Returns the raw JSON value of [includeTargetMetadata].
         *
         * Unlike [includeTargetMetadata], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("includeTargetMetadata")
        @ExcludeMissing
        fun _includeTargetMetadata(): JsonField<Boolean> = includeTargetMetadata

        /**
         * Returns the raw JSON value of [inReplyToTweetId].
         *
         * Unlike [inReplyToTweetId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("inReplyToTweetId")
        @ExcludeMissing
        fun _inReplyToTweetId(): JsonField<String> = inReplyToTweetId

        /**
         * Returns the raw JSON value of [language].
         *
         * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<String> = language

        /**
         * Returns the raw JSON value of [listId].
         *
         * Unlike [listId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("listId") @ExcludeMissing fun _listId(): JsonField<String> = listId

        /**
         * Returns the raw JSON value of [locationContains].
         *
         * Unlike [locationContains], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("locationContains")
        @ExcludeMissing
        fun _locationContains(): JsonField<String> = locationContains

        /**
         * Returns the raw JSON value of [maxDepth].
         *
         * Unlike [maxDepth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("maxDepth") @ExcludeMissing fun _maxDepth(): JsonField<Long> = maxDepth

        /**
         * Returns the raw JSON value of [maxFollowers].
         *
         * Unlike [maxFollowers], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("maxFollowers")
        @ExcludeMissing
        fun _maxFollowers(): JsonField<Long> = maxFollowers

        /**
         * Returns the raw JSON value of [maxFollowing].
         *
         * Unlike [maxFollowing], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("maxFollowing")
        @ExcludeMissing
        fun _maxFollowing(): JsonField<Long> = maxFollowing

        /**
         * Returns the raw JSON value of [maxId].
         *
         * Unlike [maxId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("maxId") @ExcludeMissing fun _maxId(): JsonField<String> = maxId

        /**
         * Returns the raw JSON value of [maxItemsPerTarget].
         *
         * Unlike [maxItemsPerTarget], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("maxItemsPerTarget")
        @ExcludeMissing
        fun _maxItemsPerTarget(): JsonField<Long> = maxItemsPerTarget

        /**
         * Returns the raw JSON value of [maxLikes].
         *
         * Unlike [maxLikes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("maxLikes") @ExcludeMissing fun _maxLikes(): JsonField<Long> = maxLikes

        /**
         * Returns the raw JSON value of [maxPagesPerTarget].
         *
         * Unlike [maxPagesPerTarget], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("maxPagesPerTarget")
        @ExcludeMissing
        fun _maxPagesPerTarget(): JsonField<Long> = maxPagesPerTarget

        /**
         * Returns the raw JSON value of [maxPosts].
         *
         * Unlike [maxPosts], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("maxPosts") @ExcludeMissing fun _maxPosts(): JsonField<Long> = maxPosts

        /**
         * Returns the raw JSON value of [maxQuotes].
         *
         * Unlike [maxQuotes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("maxQuotes") @ExcludeMissing fun _maxQuotes(): JsonField<Long> = maxQuotes

        /**
         * Returns the raw JSON value of [maxReplies].
         *
         * Unlike [maxReplies], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("maxReplies") @ExcludeMissing fun _maxReplies(): JsonField<Long> = maxReplies

        /**
         * Returns the raw JSON value of [maxRetweets].
         *
         * Unlike [maxRetweets], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("maxRetweets")
        @ExcludeMissing
        fun _maxRetweets(): JsonField<Long> = maxRetweets

        /**
         * Returns the raw JSON value of [mediaType].
         *
         * Unlike [mediaType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mediaType")
        @ExcludeMissing
        fun _mediaType(): JsonField<MediaType> = mediaType

        /**
         * Returns the raw JSON value of [mentioning].
         *
         * Unlike [mentioning], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mentioning")
        @ExcludeMissing
        fun _mentioning(): JsonField<String> = mentioning

        /**
         * Returns the raw JSON value of [minAccountAgeDays].
         *
         * Unlike [minAccountAgeDays], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("minAccountAgeDays")
        @ExcludeMissing
        fun _minAccountAgeDays(): JsonField<Long> = minAccountAgeDays

        /**
         * Returns the raw JSON value of [minBookmarks].
         *
         * Unlike [minBookmarks], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("minBookmarks")
        @ExcludeMissing
        fun _minBookmarks(): JsonField<Long> = minBookmarks

        /**
         * Returns the raw JSON value of [minFaves].
         *
         * Unlike [minFaves], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("minFaves") @ExcludeMissing fun _minFaves(): JsonField<Long> = minFaves

        /**
         * Returns the raw JSON value of [minFollowers].
         *
         * Unlike [minFollowers], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("minFollowers")
        @ExcludeMissing
        fun _minFollowers(): JsonField<Long> = minFollowers

        /**
         * Returns the raw JSON value of [minFollowing].
         *
         * Unlike [minFollowing], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("minFollowing")
        @ExcludeMissing
        fun _minFollowing(): JsonField<Long> = minFollowing

        /**
         * Returns the raw JSON value of [minPosts].
         *
         * Unlike [minPosts], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("minPosts") @ExcludeMissing fun _minPosts(): JsonField<Long> = minPosts

        /**
         * Returns the raw JSON value of [minQuotes].
         *
         * Unlike [minQuotes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("minQuotes") @ExcludeMissing fun _minQuotes(): JsonField<Long> = minQuotes

        /**
         * Returns the raw JSON value of [minReplies].
         *
         * Unlike [minReplies], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("minReplies") @ExcludeMissing fun _minReplies(): JsonField<Long> = minReplies

        /**
         * Returns the raw JSON value of [minRetweets].
         *
         * Unlike [minRetweets], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("minRetweets")
        @ExcludeMissing
        fun _minRetweets(): JsonField<Long> = minRetweets

        /**
         * Returns the raw JSON value of [minViews].
         *
         * Unlike [minViews], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("minViews") @ExcludeMissing fun _minViews(): JsonField<Long> = minViews

        /**
         * Returns the raw JSON value of [nativeRetweets].
         *
         * Unlike [nativeRetweets], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("nativeRetweets")
        @ExcludeMissing
        fun _nativeRetweets(): JsonField<Boolean> = nativeRetweets

        /**
         * Returns the raw JSON value of [near].
         *
         * Unlike [near], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("near") @ExcludeMissing fun _near(): JsonField<String> = near

        /**
         * Returns the raw JSON value of [news].
         *
         * Unlike [news], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("news") @ExcludeMissing fun _news(): JsonField<Boolean> = news

        /**
         * Returns the raw JSON value of [overlapMode].
         *
         * Unlike [overlapMode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("overlapMode")
        @ExcludeMissing
        fun _overlapMode(): JsonField<Boolean> = overlapMode

        /**
         * Returns the raw JSON value of [place].
         *
         * Unlike [place], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("place") @ExcludeMissing fun _place(): JsonField<String> = place

        /**
         * Returns the raw JSON value of [placeCountry].
         *
         * Unlike [placeCountry], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("placeCountry")
        @ExcludeMissing
        fun _placeCountry(): JsonField<String> = placeCountry

        /**
         * Returns the raw JSON value of [pointRadius].
         *
         * Unlike [pointRadius], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("pointRadius")
        @ExcludeMissing
        fun _pointRadius(): JsonField<String> = pointRadius

        /**
         * Returns the raw JSON value of [queryType].
         *
         * Unlike [queryType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("queryType")
        @ExcludeMissing
        fun _queryType(): JsonField<QueryType> = queryType

        /**
         * Returns the raw JSON value of [quotes].
         *
         * Unlike [quotes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("quotes") @ExcludeMissing fun _quotes(): JsonField<Quotes> = quotes

        /**
         * Returns the raw JSON value of [quotesOfTweetId].
         *
         * Unlike [quotesOfTweetId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("quotesOfTweetId")
        @ExcludeMissing
        fun _quotesOfTweetId(): JsonField<String> = quotesOfTweetId

        /**
         * Returns the raw JSON value of [relationTargets].
         *
         * Unlike [relationTargets], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("relationTargets")
        @ExcludeMissing
        fun _relationTargets(): JsonField<List<RelationTarget>> = relationTargets

        /**
         * Returns the raw JSON value of [replies].
         *
         * Unlike [replies], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("replies") @ExcludeMissing fun _replies(): JsonField<Replies> = replies

        /**
         * Returns the raw JSON value of [resultsLimit].
         *
         * Unlike [resultsLimit], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("resultsLimit")
        @ExcludeMissing
        fun _resultsLimit(): JsonField<Long> = resultsLimit

        /**
         * Returns the raw JSON value of [retweets].
         *
         * Unlike [retweets], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("retweets") @ExcludeMissing fun _retweets(): JsonField<Retweets> = retweets

        /**
         * Returns the raw JSON value of [retweetsOfTweetId].
         *
         * Unlike [retweetsOfTweetId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("retweetsOfTweetId")
        @ExcludeMissing
        fun _retweetsOfTweetId(): JsonField<String> = retweetsOfTweetId

        /**
         * Returns the raw JSON value of [safe].
         *
         * Unlike [safe], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("safe") @ExcludeMissing fun _safe(): JsonField<Boolean> = safe

        /**
         * Returns the raw JSON value of [scope].
         *
         * Unlike [scope], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("scope") @ExcludeMissing fun _scope(): JsonField<Scope> = scope

        /**
         * Returns the raw JSON value of [searchQueries].
         *
         * Unlike [searchQueries], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("searchQueries")
        @ExcludeMissing
        fun _searchQueries(): JsonField<List<String>> = searchQueries

        /**
         * Returns the raw JSON value of [searchQuery].
         *
         * Unlike [searchQuery], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("searchQuery")
        @ExcludeMissing
        fun _searchQuery(): JsonField<String> = searchQuery

        /**
         * Returns the raw JSON value of [sinceDate].
         *
         * Unlike [sinceDate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sinceDate")
        @ExcludeMissing
        fun _sinceDate(): JsonField<LocalDate> = sinceDate

        /**
         * Returns the raw JSON value of [sinceId].
         *
         * Unlike [sinceId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sinceId") @ExcludeMissing fun _sinceId(): JsonField<String> = sinceId

        /**
         * Returns the raw JSON value of [sinceTime].
         *
         * Unlike [sinceTime], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sinceTime")
        @ExcludeMissing
        fun _sinceTime(): JsonField<SinceTime> = sinceTime

        /**
         * Returns the raw JSON value of [sort].
         *
         * Unlike [sort], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sort") @ExcludeMissing fun _sort(): JsonField<Sort> = sort

        /**
         * Returns the raw JSON value of [source].
         *
         * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

        /**
         * Returns the raw JSON value of [startCursor].
         *
         * Unlike [startCursor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("startCursor")
        @ExcludeMissing
        fun _startCursor(): JsonField<String> = startCursor

        /**
         * Returns the raw JSON value of [targetCommunityId].
         *
         * Unlike [targetCommunityId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("targetCommunityId")
        @ExcludeMissing
        fun _targetCommunityId(): JsonField<String> = targetCommunityId

        /**
         * Returns the raw JSON value of [targetCommunityIds].
         *
         * Unlike [targetCommunityIds], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("targetCommunityIds")
        @ExcludeMissing
        fun _targetCommunityIds(): JsonField<List<String>> = targetCommunityIds

        /**
         * Returns the raw JSON value of [targetListId].
         *
         * Unlike [targetListId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("targetListId")
        @ExcludeMissing
        fun _targetListId(): JsonField<String> = targetListId

        /**
         * Returns the raw JSON value of [targetListIds].
         *
         * Unlike [targetListIds], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("targetListIds")
        @ExcludeMissing
        fun _targetListIds(): JsonField<List<String>> = targetListIds

        /**
         * Returns the raw JSON value of [targets].
         *
         * Unlike [targets], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("targets") @ExcludeMissing fun _targets(): JsonField<List<Target>> = targets

        /**
         * Returns the raw JSON value of [targetSpaceId].
         *
         * Unlike [targetSpaceId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("targetSpaceId")
        @ExcludeMissing
        fun _targetSpaceId(): JsonField<String> = targetSpaceId

        /**
         * Returns the raw JSON value of [targetTweetId].
         *
         * Unlike [targetTweetId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("targetTweetId")
        @ExcludeMissing
        fun _targetTweetId(): JsonField<String> = targetTweetId

        /**
         * Returns the raw JSON value of [targetTweetIds].
         *
         * Unlike [targetTweetIds], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("targetTweetIds")
        @ExcludeMissing
        fun _targetTweetIds(): JsonField<List<String>> = targetTweetIds

        /**
         * Returns the raw JSON value of [targetUsername].
         *
         * Unlike [targetUsername], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("targetUsername")
        @ExcludeMissing
        fun _targetUsername(): JsonField<String> = targetUsername

        /**
         * Returns the raw JSON value of [targetUsernames].
         *
         * Unlike [targetUsernames], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("targetUsernames")
        @ExcludeMissing
        fun _targetUsernames(): JsonField<List<String>> = targetUsernames

        /**
         * Returns the raw JSON value of [toUser].
         *
         * Unlike [toUser], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("toUser") @ExcludeMissing fun _toUser(): JsonField<String> = toUser

        /**
         * Returns the raw JSON value of [untilDate].
         *
         * Unlike [untilDate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("untilDate")
        @ExcludeMissing
        fun _untilDate(): JsonField<LocalDate> = untilDate

        /**
         * Returns the raw JSON value of [untilTime].
         *
         * Unlike [untilTime], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("untilTime")
        @ExcludeMissing
        fun _untilTime(): JsonField<UntilTime> = untilTime

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [usernameContains].
         *
         * Unlike [usernameContains], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("usernameContains")
        @ExcludeMissing
        fun _usernameContains(): JsonField<String> = usernameContains

        /**
         * Returns the raw JSON value of [verifiedOnly].
         *
         * Unlike [verifiedOnly], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("verifiedOnly")
        @ExcludeMissing
        fun _verifiedOnly(): JsonField<Boolean> = verifiedOnly

        /**
         * Returns the raw JSON value of [verifiedType].
         *
         * Unlike [verifiedType], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("verifiedType")
        @ExcludeMissing
        fun _verifiedType(): JsonField<String> = verifiedType

        /**
         * Returns the raw JSON value of [within].
         *
         * Unlike [within], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("within") @ExcludeMissing fun _within(): JsonField<String> = within

        /**
         * Returns the raw JSON value of [withinTime].
         *
         * Unlike [withinTime], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("withinTime")
        @ExcludeMissing
        fun _withinTime(): JsonField<String> = withinTime

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .toolType()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var toolType: JsonField<ToolType>? = null
            private var advancedQuery: JsonField<String> = JsonMissing.of()
            private var anyWords: JsonField<String> = JsonMissing.of()
            private var bioContains: JsonField<String> = JsonMissing.of()
            private var blueVerifiedOnly: JsonField<Boolean> = JsonMissing.of()
            private var boundingBox: JsonField<String> = JsonMissing.of()
            private var cardName: JsonField<String> = JsonMissing.of()
            private var cashtags: JsonField<String> = JsonMissing.of()
            private var collectionStrategy: JsonField<CollectionStrategy> = JsonMissing.of()
            private var conversationId: JsonField<String> = JsonMissing.of()
            private var dedupeAcrossTargets: JsonField<Boolean> = JsonMissing.of()
            private var dedupeMode: JsonField<DedupeMode> = JsonMissing.of()
            private var exactPhrase: JsonField<String> = JsonMissing.of()
            private var excludeOriginalAuthor: JsonField<Boolean> = JsonMissing.of()
            private var excludeSource: JsonField<String> = JsonMissing.of()
            private var excludeWords: JsonField<String> = JsonMissing.of()
            private var fromUser: JsonField<String> = JsonMissing.of()
            private var geocode: JsonField<String> = JsonMissing.of()
            private var hashtags: JsonField<String> = JsonMissing.of()
            private var hasLocation: JsonField<Boolean> = JsonMissing.of()
            private var hasMediaOnly: JsonField<Boolean> = JsonMissing.of()
            private var hasWebsite: JsonField<Boolean> = JsonMissing.of()
            private var includeOriginalPost: JsonField<Boolean> = JsonMissing.of()
            private var includeSearchTerms: JsonField<Boolean> = JsonMissing.of()
            private var includeTargetMetadata: JsonField<Boolean> = JsonMissing.of()
            private var inReplyToTweetId: JsonField<String> = JsonMissing.of()
            private var language: JsonField<String> = JsonMissing.of()
            private var listId: JsonField<String> = JsonMissing.of()
            private var locationContains: JsonField<String> = JsonMissing.of()
            private var maxDepth: JsonField<Long> = JsonMissing.of()
            private var maxFollowers: JsonField<Long> = JsonMissing.of()
            private var maxFollowing: JsonField<Long> = JsonMissing.of()
            private var maxId: JsonField<String> = JsonMissing.of()
            private var maxItemsPerTarget: JsonField<Long> = JsonMissing.of()
            private var maxLikes: JsonField<Long> = JsonMissing.of()
            private var maxPagesPerTarget: JsonField<Long> = JsonMissing.of()
            private var maxPosts: JsonField<Long> = JsonMissing.of()
            private var maxQuotes: JsonField<Long> = JsonMissing.of()
            private var maxReplies: JsonField<Long> = JsonMissing.of()
            private var maxRetweets: JsonField<Long> = JsonMissing.of()
            private var mediaType: JsonField<MediaType> = JsonMissing.of()
            private var mentioning: JsonField<String> = JsonMissing.of()
            private var minAccountAgeDays: JsonField<Long> = JsonMissing.of()
            private var minBookmarks: JsonField<Long> = JsonMissing.of()
            private var minFaves: JsonField<Long> = JsonMissing.of()
            private var minFollowers: JsonField<Long> = JsonMissing.of()
            private var minFollowing: JsonField<Long> = JsonMissing.of()
            private var minPosts: JsonField<Long> = JsonMissing.of()
            private var minQuotes: JsonField<Long> = JsonMissing.of()
            private var minReplies: JsonField<Long> = JsonMissing.of()
            private var minRetweets: JsonField<Long> = JsonMissing.of()
            private var minViews: JsonField<Long> = JsonMissing.of()
            private var nativeRetweets: JsonField<Boolean> = JsonMissing.of()
            private var near: JsonField<String> = JsonMissing.of()
            private var news: JsonField<Boolean> = JsonMissing.of()
            private var overlapMode: JsonField<Boolean> = JsonMissing.of()
            private var place: JsonField<String> = JsonMissing.of()
            private var placeCountry: JsonField<String> = JsonMissing.of()
            private var pointRadius: JsonField<String> = JsonMissing.of()
            private var queryType: JsonField<QueryType> = JsonMissing.of()
            private var quotes: JsonField<Quotes> = JsonMissing.of()
            private var quotesOfTweetId: JsonField<String> = JsonMissing.of()
            private var relationTargets: JsonField<MutableList<RelationTarget>>? = null
            private var replies: JsonField<Replies> = JsonMissing.of()
            private var resultsLimit: JsonField<Long> = JsonMissing.of()
            private var retweets: JsonField<Retweets> = JsonMissing.of()
            private var retweetsOfTweetId: JsonField<String> = JsonMissing.of()
            private var safe: JsonField<Boolean> = JsonMissing.of()
            private var scope: JsonField<Scope> = JsonMissing.of()
            private var searchQueries: JsonField<MutableList<String>>? = null
            private var searchQuery: JsonField<String> = JsonMissing.of()
            private var sinceDate: JsonField<LocalDate> = JsonMissing.of()
            private var sinceId: JsonField<String> = JsonMissing.of()
            private var sinceTime: JsonField<SinceTime> = JsonMissing.of()
            private var sort: JsonField<Sort> = JsonMissing.of()
            private var source: JsonField<String> = JsonMissing.of()
            private var startCursor: JsonField<String> = JsonMissing.of()
            private var targetCommunityId: JsonField<String> = JsonMissing.of()
            private var targetCommunityIds: JsonField<MutableList<String>>? = null
            private var targetListId: JsonField<String> = JsonMissing.of()
            private var targetListIds: JsonField<MutableList<String>>? = null
            private var targets: JsonField<MutableList<Target>>? = null
            private var targetSpaceId: JsonField<String> = JsonMissing.of()
            private var targetTweetId: JsonField<String> = JsonMissing.of()
            private var targetTweetIds: JsonField<MutableList<String>>? = null
            private var targetUsername: JsonField<String> = JsonMissing.of()
            private var targetUsernames: JsonField<MutableList<String>>? = null
            private var toUser: JsonField<String> = JsonMissing.of()
            private var untilDate: JsonField<LocalDate> = JsonMissing.of()
            private var untilTime: JsonField<UntilTime> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var usernameContains: JsonField<String> = JsonMissing.of()
            private var verifiedOnly: JsonField<Boolean> = JsonMissing.of()
            private var verifiedType: JsonField<String> = JsonMissing.of()
            private var within: JsonField<String> = JsonMissing.of()
            private var withinTime: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                toolType = body.toolType
                advancedQuery = body.advancedQuery
                anyWords = body.anyWords
                bioContains = body.bioContains
                blueVerifiedOnly = body.blueVerifiedOnly
                boundingBox = body.boundingBox
                cardName = body.cardName
                cashtags = body.cashtags
                collectionStrategy = body.collectionStrategy
                conversationId = body.conversationId
                dedupeAcrossTargets = body.dedupeAcrossTargets
                dedupeMode = body.dedupeMode
                exactPhrase = body.exactPhrase
                excludeOriginalAuthor = body.excludeOriginalAuthor
                excludeSource = body.excludeSource
                excludeWords = body.excludeWords
                fromUser = body.fromUser
                geocode = body.geocode
                hashtags = body.hashtags
                hasLocation = body.hasLocation
                hasMediaOnly = body.hasMediaOnly
                hasWebsite = body.hasWebsite
                includeOriginalPost = body.includeOriginalPost
                includeSearchTerms = body.includeSearchTerms
                includeTargetMetadata = body.includeTargetMetadata
                inReplyToTweetId = body.inReplyToTweetId
                language = body.language
                listId = body.listId
                locationContains = body.locationContains
                maxDepth = body.maxDepth
                maxFollowers = body.maxFollowers
                maxFollowing = body.maxFollowing
                maxId = body.maxId
                maxItemsPerTarget = body.maxItemsPerTarget
                maxLikes = body.maxLikes
                maxPagesPerTarget = body.maxPagesPerTarget
                maxPosts = body.maxPosts
                maxQuotes = body.maxQuotes
                maxReplies = body.maxReplies
                maxRetweets = body.maxRetweets
                mediaType = body.mediaType
                mentioning = body.mentioning
                minAccountAgeDays = body.minAccountAgeDays
                minBookmarks = body.minBookmarks
                minFaves = body.minFaves
                minFollowers = body.minFollowers
                minFollowing = body.minFollowing
                minPosts = body.minPosts
                minQuotes = body.minQuotes
                minReplies = body.minReplies
                minRetweets = body.minRetweets
                minViews = body.minViews
                nativeRetweets = body.nativeRetweets
                near = body.near
                news = body.news
                overlapMode = body.overlapMode
                place = body.place
                placeCountry = body.placeCountry
                pointRadius = body.pointRadius
                queryType = body.queryType
                quotes = body.quotes
                quotesOfTweetId = body.quotesOfTweetId
                relationTargets = body.relationTargets.map { it.toMutableList() }
                replies = body.replies
                resultsLimit = body.resultsLimit
                retweets = body.retweets
                retweetsOfTweetId = body.retweetsOfTweetId
                safe = body.safe
                scope = body.scope
                searchQueries = body.searchQueries.map { it.toMutableList() }
                searchQuery = body.searchQuery
                sinceDate = body.sinceDate
                sinceId = body.sinceId
                sinceTime = body.sinceTime
                sort = body.sort
                source = body.source
                startCursor = body.startCursor
                targetCommunityId = body.targetCommunityId
                targetCommunityIds = body.targetCommunityIds.map { it.toMutableList() }
                targetListId = body.targetListId
                targetListIds = body.targetListIds.map { it.toMutableList() }
                targets = body.targets.map { it.toMutableList() }
                targetSpaceId = body.targetSpaceId
                targetTweetId = body.targetTweetId
                targetTweetIds = body.targetTweetIds.map { it.toMutableList() }
                targetUsername = body.targetUsername
                targetUsernames = body.targetUsernames.map { it.toMutableList() }
                toUser = body.toUser
                untilDate = body.untilDate
                untilTime = body.untilTime
                url = body.url
                usernameContains = body.usernameContains
                verifiedOnly = body.verifiedOnly
                verifiedType = body.verifiedType
                within = body.within
                withinTime = body.withinTime
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Identifier for the extraction tool used to run a job. */
            fun toolType(toolType: ToolType) = toolType(JsonField.of(toolType))

            /**
             * Sets [Builder.toolType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toolType] with a well-typed [ToolType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun toolType(toolType: JsonField<ToolType>) = apply { this.toolType = toolType }

            /** Raw advanced search query appended as-is (tweet_search_extractor) */
            fun advancedQuery(advancedQuery: String) = advancedQuery(JsonField.of(advancedQuery))

            /**
             * Sets [Builder.advancedQuery] to an arbitrary JSON value.
             *
             * You should usually call [Builder.advancedQuery] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun advancedQuery(advancedQuery: JsonField<String>) = apply {
                this.advancedQuery = advancedQuery
            }

            /**
             * Words or quoted phrases where any one can match. Separate with spaces, commas, or
             * lines. (tweet_search_extractor)
             */
            fun anyWords(anyWords: String) = anyWords(JsonField.of(anyWords))

            /**
             * Sets [Builder.anyWords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.anyWords] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun anyWords(anyWords: JsonField<String>) = apply { this.anyWords = anyWords }

            /** Bio terms separated by commas or lines. */
            fun bioContains(bioContains: String) = bioContains(JsonField.of(bioContains))

            /**
             * Sets [Builder.bioContains] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bioContains] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bioContains(bioContains: JsonField<String>) = apply {
                this.bioContains = bioContains
            }

            /** Return only Blue-verified Tweet authors. */
            fun blueVerifiedOnly(blueVerifiedOnly: Boolean) =
                blueVerifiedOnly(JsonField.of(blueVerifiedOnly))

            /**
             * Sets [Builder.blueVerifiedOnly] to an arbitrary JSON value.
             *
             * You should usually call [Builder.blueVerifiedOnly] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun blueVerifiedOnly(blueVerifiedOnly: JsonField<Boolean>) = apply {
                this.blueVerifiedOnly = blueVerifiedOnly
            }

            /** Geo bounding box, e.g. -74.1 40.6 -73.9 40.8 (tweet_search_extractor) */
            fun boundingBox(boundingBox: String) = boundingBox(JsonField.of(boundingBox))

            /**
             * Sets [Builder.boundingBox] to an arbitrary JSON value.
             *
             * You should usually call [Builder.boundingBox] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun boundingBox(boundingBox: JsonField<String>) = apply {
                this.boundingBox = boundingBox
            }

            /** Match the Tweet card name. */
            fun cardName(cardName: String) = cardName(JsonField.of(cardName))

            /**
             * Sets [Builder.cardName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cardName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cardName(cardName: JsonField<String>) = apply { this.cardName = cardName }

            /** Cashtags separated by spaces, commas, or lines. (tweet_search_extractor) */
            fun cashtags(cashtags: String) = cashtags(JsonField.of(cashtags))

            /**
             * Sets [Builder.cashtags] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cashtags] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cashtags(cashtags: JsonField<String>) = apply { this.cashtags = cashtags }

            /** Reply collection strategy. */
            fun collectionStrategy(collectionStrategy: CollectionStrategy) =
                collectionStrategy(JsonField.of(collectionStrategy))

            /**
             * Sets [Builder.collectionStrategy] to an arbitrary JSON value.
             *
             * You should usually call [Builder.collectionStrategy] with a well-typed
             * [CollectionStrategy] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun collectionStrategy(collectionStrategy: JsonField<CollectionStrategy>) = apply {
                this.collectionStrategy = collectionStrategy
            }

            /** Conversation ID filter (tweet_search_extractor) */
            fun conversationId(conversationId: String) =
                conversationId(JsonField.of(conversationId))

            /**
             * Sets [Builder.conversationId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.conversationId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun conversationId(conversationId: JsonField<String>) = apply {
                this.conversationId = conversationId
            }

            /** Merge duplicate results across collection targets. */
            fun dedupeAcrossTargets(dedupeAcrossTargets: Boolean) =
                dedupeAcrossTargets(JsonField.of(dedupeAcrossTargets))

            /**
             * Sets [Builder.dedupeAcrossTargets] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dedupeAcrossTargets] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun dedupeAcrossTargets(dedupeAcrossTargets: JsonField<Boolean>) = apply {
                this.dedupeAcrossTargets = dedupeAcrossTargets
            }

            /** Keep target duplicates, first rows, or merged overlap. */
            fun dedupeMode(dedupeMode: DedupeMode) = dedupeMode(JsonField.of(dedupeMode))

            /**
             * Sets [Builder.dedupeMode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dedupeMode] with a well-typed [DedupeMode] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun dedupeMode(dedupeMode: JsonField<DedupeMode>) = apply {
                this.dedupeMode = dedupeMode
            }

            /** Exact phrase to match (tweet_search_extractor) */
            fun exactPhrase(exactPhrase: String) = exactPhrase(JsonField.of(exactPhrase))

            /**
             * Sets [Builder.exactPhrase] to an arbitrary JSON value.
             *
             * You should usually call [Builder.exactPhrase] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun exactPhrase(exactPhrase: JsonField<String>) = apply {
                this.exactPhrase = exactPhrase
            }

            /** Exclude replies from the source author. */
            fun excludeOriginalAuthor(excludeOriginalAuthor: Boolean) =
                excludeOriginalAuthor(JsonField.of(excludeOriginalAuthor))

            /**
             * Sets [Builder.excludeOriginalAuthor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.excludeOriginalAuthor] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun excludeOriginalAuthor(excludeOriginalAuthor: JsonField<Boolean>) = apply {
                this.excludeOriginalAuthor = excludeOriginalAuthor
            }

            /** Exclude a source application. */
            fun excludeSource(excludeSource: String) = excludeSource(JsonField.of(excludeSource))

            /**
             * Sets [Builder.excludeSource] to an arbitrary JSON value.
             *
             * You should usually call [Builder.excludeSource] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun excludeSource(excludeSource: JsonField<String>) = apply {
                this.excludeSource = excludeSource
            }

            /**
             * Words or quoted phrases to exclude. Separate with spaces, commas, or lines.
             * (tweet_search_extractor)
             */
            fun excludeWords(excludeWords: String) = excludeWords(JsonField.of(excludeWords))

            /**
             * Sets [Builder.excludeWords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.excludeWords] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun excludeWords(excludeWords: JsonField<String>) = apply {
                this.excludeWords = excludeWords
            }

            /** Filter by author username (tweet_search_extractor) */
            fun fromUser(fromUser: String) = fromUser(JsonField.of(fromUser))

            /**
             * Sets [Builder.fromUser] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fromUser] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fromUser(fromUser: JsonField<String>) = apply { this.fromUser = fromUser }

            /** Match latitude, longitude, and radius. */
            fun geocode(geocode: String) = geocode(JsonField.of(geocode))

            /**
             * Sets [Builder.geocode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.geocode] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun geocode(geocode: JsonField<String>) = apply { this.geocode = geocode }

            /** Hashtags separated by spaces, commas, or lines. (tweet_search_extractor) */
            fun hashtags(hashtags: String) = hashtags(JsonField.of(hashtags))

            /**
             * Sets [Builder.hashtags] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hashtags] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hashtags(hashtags: JsonField<String>) = apply { this.hashtags = hashtags }

            /** Require a profile location. */
            fun hasLocation(hasLocation: Boolean) = hasLocation(JsonField.of(hasLocation))

            /**
             * Sets [Builder.hasLocation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasLocation] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasLocation(hasLocation: JsonField<Boolean>) = apply {
                this.hasLocation = hasLocation
            }

            /** Return only replies with media. */
            fun hasMediaOnly(hasMediaOnly: Boolean) = hasMediaOnly(JsonField.of(hasMediaOnly))

            /**
             * Sets [Builder.hasMediaOnly] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasMediaOnly] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasMediaOnly(hasMediaOnly: JsonField<Boolean>) = apply {
                this.hasMediaOnly = hasMediaOnly
            }

            /** Require a profile website. */
            fun hasWebsite(hasWebsite: Boolean) = hasWebsite(JsonField.of(hasWebsite))

            /**
             * Sets [Builder.hasWebsite] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasWebsite] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasWebsite(hasWebsite: JsonField<Boolean>) = apply { this.hasWebsite = hasWebsite }

            /** Include the source post in reply results. */
            fun includeOriginalPost(includeOriginalPost: Boolean) =
                includeOriginalPost(JsonField.of(includeOriginalPost))

            /**
             * Sets [Builder.includeOriginalPost] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeOriginalPost] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun includeOriginalPost(includeOriginalPost: JsonField<Boolean>) = apply {
                this.includeOriginalPost = includeOriginalPost
            }

            /** Add matching search terms to collection metadata. */
            fun includeSearchTerms(includeSearchTerms: Boolean) =
                includeSearchTerms(JsonField.of(includeSearchTerms))

            /**
             * Sets [Builder.includeSearchTerms] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeSearchTerms] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun includeSearchTerms(includeSearchTerms: JsonField<Boolean>) = apply {
                this.includeSearchTerms = includeSearchTerms
            }

            /** Add source target metadata to each result. */
            fun includeTargetMetadata(includeTargetMetadata: Boolean) =
                includeTargetMetadata(JsonField.of(includeTargetMetadata))

            /**
             * Sets [Builder.includeTargetMetadata] to an arbitrary JSON value.
             *
             * You should usually call [Builder.includeTargetMetadata] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun includeTargetMetadata(includeTargetMetadata: JsonField<Boolean>) = apply {
                this.includeTargetMetadata = includeTargetMetadata
            }

            /** Only replies to this tweet ID (tweet_search_extractor) */
            fun inReplyToTweetId(inReplyToTweetId: String) =
                inReplyToTweetId(JsonField.of(inReplyToTweetId))

            /**
             * Sets [Builder.inReplyToTweetId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inReplyToTweetId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun inReplyToTweetId(inReplyToTweetId: JsonField<String>) = apply {
                this.inReplyToTweetId = inReplyToTweetId
            }

            /** Language code filter (tweet_search_extractor) */
            fun language(language: String) = language(JsonField.of(language))

            /**
             * Sets [Builder.language] to an arbitrary JSON value.
             *
             * You should usually call [Builder.language] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun language(language: JsonField<String>) = apply { this.language = language }

            /** Search within a list ID (tweet_search_extractor) */
            fun listId(listId: String) = listId(JsonField.of(listId))

            /**
             * Sets [Builder.listId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.listId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun listId(listId: JsonField<String>) = apply { this.listId = listId }

            /** Required profile location text. */
            fun locationContains(locationContains: String) =
                locationContains(JsonField.of(locationContains))

            /**
             * Sets [Builder.locationContains] to an arbitrary JSON value.
             *
             * You should usually call [Builder.locationContains] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun locationContains(locationContains: JsonField<String>) = apply {
                this.locationContains = locationContains
            }

            /** Maximum nested reply depth. */
            fun maxDepth(maxDepth: Long) = maxDepth(JsonField.of(maxDepth))

            /**
             * Sets [Builder.maxDepth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxDepth] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxDepth(maxDepth: JsonField<Long>) = apply { this.maxDepth = maxDepth }

            /** Maximum follower count for profile results. */
            fun maxFollowers(maxFollowers: Long) = maxFollowers(JsonField.of(maxFollowers))

            /**
             * Sets [Builder.maxFollowers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxFollowers] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxFollowers(maxFollowers: JsonField<Long>) = apply {
                this.maxFollowers = maxFollowers
            }

            /** Maximum following count for profile results. */
            fun maxFollowing(maxFollowing: Long) = maxFollowing(JsonField.of(maxFollowing))

            /**
             * Sets [Builder.maxFollowing] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxFollowing] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxFollowing(maxFollowing: JsonField<Long>) = apply {
                this.maxFollowing = maxFollowing
            }

            /** Return Tweets older than this Tweet ID. */
            fun maxId(maxId: String) = maxId(JsonField.of(maxId))

            /**
             * Sets [Builder.maxId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxId(maxId: JsonField<String>) = apply { this.maxId = maxId }

            /** Maximum results collected for each target. */
            fun maxItemsPerTarget(maxItemsPerTarget: Long) =
                maxItemsPerTarget(JsonField.of(maxItemsPerTarget))

            /**
             * Sets [Builder.maxItemsPerTarget] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxItemsPerTarget] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxItemsPerTarget(maxItemsPerTarget: JsonField<Long>) = apply {
                this.maxItemsPerTarget = maxItemsPerTarget
            }

            /** Maximum Tweet like count. */
            fun maxLikes(maxLikes: Long) = maxLikes(JsonField.of(maxLikes))

            /**
             * Sets [Builder.maxLikes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxLikes] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxLikes(maxLikes: JsonField<Long>) = apply { this.maxLikes = maxLikes }

            /** Reply pages collected for each target. */
            fun maxPagesPerTarget(maxPagesPerTarget: Long) =
                maxPagesPerTarget(JsonField.of(maxPagesPerTarget))

            /**
             * Sets [Builder.maxPagesPerTarget] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxPagesPerTarget] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxPagesPerTarget(maxPagesPerTarget: JsonField<Long>) = apply {
                this.maxPagesPerTarget = maxPagesPerTarget
            }

            /** Maximum post count for profile results. */
            fun maxPosts(maxPosts: Long) = maxPosts(JsonField.of(maxPosts))

            /**
             * Sets [Builder.maxPosts] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxPosts] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxPosts(maxPosts: JsonField<Long>) = apply { this.maxPosts = maxPosts }

            /** Maximum Tweet quote count. */
            fun maxQuotes(maxQuotes: Long) = maxQuotes(JsonField.of(maxQuotes))

            /**
             * Sets [Builder.maxQuotes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxQuotes] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxQuotes(maxQuotes: JsonField<Long>) = apply { this.maxQuotes = maxQuotes }

            /** Maximum Tweet reply count. */
            fun maxReplies(maxReplies: Long) = maxReplies(JsonField.of(maxReplies))

            /**
             * Sets [Builder.maxReplies] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxReplies] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxReplies(maxReplies: JsonField<Long>) = apply { this.maxReplies = maxReplies }

            /** Maximum Tweet repost count. */
            fun maxRetweets(maxRetweets: Long) = maxRetweets(JsonField.of(maxRetweets))

            /**
             * Sets [Builder.maxRetweets] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxRetweets] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxRetweets(maxRetweets: JsonField<Long>) = apply { this.maxRetweets = maxRetweets }

            /** Media type filter (tweet_search_extractor) */
            fun mediaType(mediaType: MediaType) = mediaType(JsonField.of(mediaType))

            /**
             * Sets [Builder.mediaType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mediaType] with a well-typed [MediaType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mediaType(mediaType: JsonField<MediaType>) = apply { this.mediaType = mediaType }

            /** Filter tweets mentioning a username (tweet_search_extractor) */
            fun mentioning(mentioning: String) = mentioning(JsonField.of(mentioning))

            /**
             * Sets [Builder.mentioning] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mentioning] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mentioning(mentioning: JsonField<String>) = apply { this.mentioning = mentioning }

            /** Minimum profile age in days. */
            fun minAccountAgeDays(minAccountAgeDays: Long) =
                minAccountAgeDays(JsonField.of(minAccountAgeDays))

            /**
             * Sets [Builder.minAccountAgeDays] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minAccountAgeDays] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minAccountAgeDays(minAccountAgeDays: JsonField<Long>) = apply {
                this.minAccountAgeDays = minAccountAgeDays
            }

            /** Minimum Tweet bookmark count. */
            fun minBookmarks(minBookmarks: Long) = minBookmarks(JsonField.of(minBookmarks))

            /**
             * Sets [Builder.minBookmarks] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minBookmarks] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minBookmarks(minBookmarks: JsonField<Long>) = apply {
                this.minBookmarks = minBookmarks
            }

            /** Minimum likes threshold (tweet_search_extractor) */
            fun minFaves(minFaves: Long) = minFaves(JsonField.of(minFaves))

            /**
             * Sets [Builder.minFaves] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minFaves] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minFaves(minFaves: JsonField<Long>) = apply { this.minFaves = minFaves }

            /** Minimum follower count for profile results. */
            fun minFollowers(minFollowers: Long) = minFollowers(JsonField.of(minFollowers))

            /**
             * Sets [Builder.minFollowers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minFollowers] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minFollowers(minFollowers: JsonField<Long>) = apply {
                this.minFollowers = minFollowers
            }

            /** Minimum following count for profile results. */
            fun minFollowing(minFollowing: Long) = minFollowing(JsonField.of(minFollowing))

            /**
             * Sets [Builder.minFollowing] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minFollowing] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minFollowing(minFollowing: JsonField<Long>) = apply {
                this.minFollowing = minFollowing
            }

            /** Minimum post count for profile results. */
            fun minPosts(minPosts: Long) = minPosts(JsonField.of(minPosts))

            /**
             * Sets [Builder.minPosts] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minPosts] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minPosts(minPosts: JsonField<Long>) = apply { this.minPosts = minPosts }

            /** Minimum quote count threshold (tweet_search_extractor) */
            fun minQuotes(minQuotes: Long) = minQuotes(JsonField.of(minQuotes))

            /**
             * Sets [Builder.minQuotes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minQuotes] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minQuotes(minQuotes: JsonField<Long>) = apply { this.minQuotes = minQuotes }

            /** Minimum replies threshold (tweet_search_extractor) */
            fun minReplies(minReplies: Long) = minReplies(JsonField.of(minReplies))

            /**
             * Sets [Builder.minReplies] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minReplies] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minReplies(minReplies: JsonField<Long>) = apply { this.minReplies = minReplies }

            /** Minimum retweets threshold (tweet_search_extractor) */
            fun minRetweets(minRetweets: Long) = minRetweets(JsonField.of(minRetweets))

            /**
             * Sets [Builder.minRetweets] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minRetweets] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minRetweets(minRetweets: JsonField<Long>) = apply { this.minRetweets = minRetweets }

            /** Minimum Tweet view count. */
            fun minViews(minViews: Long) = minViews(JsonField.of(minViews))

            /**
             * Sets [Builder.minViews] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minViews] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minViews(minViews: JsonField<Long>) = apply { this.minViews = minViews }

            /** Only return native reposts. */
            fun nativeRetweets(nativeRetweets: Boolean) =
                nativeRetweets(JsonField.of(nativeRetweets))

            /**
             * Sets [Builder.nativeRetweets] to an arbitrary JSON value.
             *
             * You should usually call [Builder.nativeRetweets] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun nativeRetweets(nativeRetweets: JsonField<Boolean>) = apply {
                this.nativeRetweets = nativeRetweets
            }

            /** Match a place name. */
            fun near(near: String) = near(JsonField.of(near))

            /**
             * Sets [Builder.near] to an arbitrary JSON value.
             *
             * You should usually call [Builder.near] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun near(near: JsonField<String>) = apply { this.near = near }

            /** Only return news results. */
            fun news(news: Boolean) = news(JsonField.of(news))

            /**
             * Sets [Builder.news] to an arbitrary JSON value.
             *
             * You should usually call [Builder.news] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun news(news: JsonField<Boolean>) = apply { this.news = news }

            /** Shortcut for dedupeMode=merge. */
            fun overlapMode(overlapMode: Boolean) = overlapMode(JsonField.of(overlapMode))

            /**
             * Sets [Builder.overlapMode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.overlapMode] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun overlapMode(overlapMode: JsonField<Boolean>) = apply {
                this.overlapMode = overlapMode
            }

            /** Search within a place ID (tweet_search_extractor) */
            fun place(place: String) = place(JsonField.of(place))

            /**
             * Sets [Builder.place] to an arbitrary JSON value.
             *
             * You should usually call [Builder.place] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun place(place: JsonField<String>) = apply { this.place = place }

            /** Search within a country code (tweet_search_extractor) */
            fun placeCountry(placeCountry: String) = placeCountry(JsonField.of(placeCountry))

            /**
             * Sets [Builder.placeCountry] to an arbitrary JSON value.
             *
             * You should usually call [Builder.placeCountry] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun placeCountry(placeCountry: JsonField<String>) = apply {
                this.placeCountry = placeCountry
            }

            /** Geo point radius, e.g. -73.99 40.73 25mi (tweet_search_extractor) */
            fun pointRadius(pointRadius: String) = pointRadius(JsonField.of(pointRadius))

            /**
             * Sets [Builder.pointRadius] to an arbitrary JSON value.
             *
             * You should usually call [Builder.pointRadius] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun pointRadius(pointRadius: JsonField<String>) = apply {
                this.pointRadius = pointRadius
            }

            /** Search ranking applied to every query. */
            fun queryType(queryType: QueryType) = queryType(JsonField.of(queryType))

            /**
             * Sets [Builder.queryType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.queryType] with a well-typed [QueryType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun queryType(queryType: JsonField<QueryType>) = apply { this.queryType = queryType }

            /** Quote mode (tweet_search_extractor) */
            fun quotes(quotes: Quotes) = quotes(JsonField.of(quotes))

            /**
             * Sets [Builder.quotes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.quotes] with a well-typed [Quotes] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun quotes(quotes: JsonField<Quotes>) = apply { this.quotes = quotes }

            /** Only quotes of this tweet ID (tweet_search_extractor) */
            fun quotesOfTweetId(quotesOfTweetId: String) =
                quotesOfTweetId(JsonField.of(quotesOfTweetId))

            /**
             * Sets [Builder.quotesOfTweetId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.quotesOfTweetId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun quotesOfTweetId(quotesOfTweetId: JsonField<String>) = apply {
                this.quotesOfTweetId = quotesOfTweetId
            }

            /** Profile relations processed within one job. */
            fun relationTargets(relationTargets: List<RelationTarget>) =
                relationTargets(JsonField.of(relationTargets))

            /**
             * Sets [Builder.relationTargets] to an arbitrary JSON value.
             *
             * You should usually call [Builder.relationTargets] with a well-typed
             * `List<RelationTarget>` value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun relationTargets(relationTargets: JsonField<List<RelationTarget>>) = apply {
                this.relationTargets = relationTargets.map { it.toMutableList() }
            }

            /**
             * Adds a single [RelationTarget] to [relationTargets].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRelationTarget(relationTarget: RelationTarget) = apply {
                relationTargets =
                    (relationTargets ?: JsonField.of(mutableListOf())).also {
                        checkKnown("relationTargets", it).add(relationTarget)
                    }
            }

            /** Reply mode (tweet_search_extractor) */
            fun replies(replies: Replies) = replies(JsonField.of(replies))

            /**
             * Sets [Builder.replies] to an arbitrary JSON value.
             *
             * You should usually call [Builder.replies] with a well-typed [Replies] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun replies(replies: JsonField<Replies>) = apply { this.replies = replies }

            /**
             * Maximum number of results to extract. When set, the extraction stops after reaching
             * this limit.
             */
            fun resultsLimit(resultsLimit: Long) = resultsLimit(JsonField.of(resultsLimit))

            /**
             * Sets [Builder.resultsLimit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.resultsLimit] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun resultsLimit(resultsLimit: JsonField<Long>) = apply {
                this.resultsLimit = resultsLimit
            }

            /** Retweet mode (tweet_search_extractor) */
            fun retweets(retweets: Retweets) = retweets(JsonField.of(retweets))

            /**
             * Sets [Builder.retweets] to an arbitrary JSON value.
             *
             * You should usually call [Builder.retweets] with a well-typed [Retweets] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun retweets(retweets: JsonField<Retweets>) = apply { this.retweets = retweets }

            /** Only retweets of this tweet ID (tweet_search_extractor) */
            fun retweetsOfTweetId(retweetsOfTweetId: String) =
                retweetsOfTweetId(JsonField.of(retweetsOfTweetId))

            /**
             * Sets [Builder.retweetsOfTweetId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.retweetsOfTweetId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun retweetsOfTweetId(retweetsOfTweetId: JsonField<String>) = apply {
                this.retweetsOfTweetId = retweetsOfTweetId
            }

            /** Enable the safe-search filter. */
            fun safe(safe: Boolean) = safe(JsonField.of(safe))

            /**
             * Sets [Builder.safe] to an arbitrary JSON value.
             *
             * You should usually call [Builder.safe] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun safe(safe: JsonField<Boolean>) = apply { this.safe = safe }

            /** Reply depth scope. */
            fun scope(scope: Scope) = scope(JsonField.of(scope))

            /**
             * Sets [Builder.scope] to an arbitrary JSON value.
             *
             * You should usually call [Builder.scope] with a well-typed [Scope] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun scope(scope: JsonField<Scope>) = apply { this.scope = scope }

            /** Search queries processed as one collection job. */
            fun searchQueries(searchQueries: List<String>) =
                searchQueries(JsonField.of(searchQueries))

            /**
             * Sets [Builder.searchQueries] to an arbitrary JSON value.
             *
             * You should usually call [Builder.searchQueries] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun searchQueries(searchQueries: JsonField<List<String>>) = apply {
                this.searchQueries = searchQueries.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [searchQueries].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSearchQuery(searchQuery: String) = apply {
                searchQueries =
                    (searchQueries ?: JsonField.of(mutableListOf())).also {
                        checkKnown("searchQueries", it).add(searchQuery)
                    }
            }

            /** Required for tweet_search_extractor & community_search. */
            fun searchQuery(searchQuery: String) = searchQuery(JsonField.of(searchQuery))

            /**
             * Sets [Builder.searchQuery] to an arbitrary JSON value.
             *
             * You should usually call [Builder.searchQuery] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun searchQuery(searchQuery: JsonField<String>) = apply {
                this.searchQuery = searchQuery
            }

            /** Start date YYYY-MM-DD (tweet_search_extractor) */
            fun sinceDate(sinceDate: LocalDate) = sinceDate(JsonField.of(sinceDate))

            /**
             * Sets [Builder.sinceDate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sinceDate] with a well-typed [LocalDate] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sinceDate(sinceDate: JsonField<LocalDate>) = apply { this.sinceDate = sinceDate }

            /** Return Tweets newer than this Tweet ID. */
            fun sinceId(sinceId: String) = sinceId(JsonField.of(sinceId))

            /**
             * Sets [Builder.sinceId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sinceId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sinceId(sinceId: JsonField<String>) = apply { this.sinceId = sinceId }

            /** Reply start time as ISO 8601 or Unix seconds. */
            fun sinceTime(sinceTime: SinceTime) = sinceTime(JsonField.of(sinceTime))

            /**
             * Sets [Builder.sinceTime] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sinceTime] with a well-typed [SinceTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sinceTime(sinceTime: JsonField<SinceTime>) = apply { this.sinceTime = sinceTime }

            /** Alias for calling [sinceTime] with `SinceTime.ofOffsetDate(offsetDate)`. */
            fun sinceTime(offsetDate: OffsetDateTime) =
                sinceTime(SinceTime.ofOffsetDate(offsetDate))

            /** Alias for calling [sinceTime] with `SinceTime.ofInteger(integer)`. */
            fun sinceTime(integer: Long) = sinceTime(SinceTime.ofInteger(integer))

            /** Reply result order. */
            fun sort(sort: Sort) = sort(JsonField.of(sort))

            /**
             * Sets [Builder.sort] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sort] with a well-typed [Sort] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun sort(sort: JsonField<Sort>) = apply { this.sort = sort }

            /** Match the source application. */
            fun source(source: String) = source(JsonField.of(source))

            /**
             * Sets [Builder.source] to an arbitrary JSON value.
             *
             * You should usually call [Builder.source] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun source(source: JsonField<String>) = apply { this.source = source }

            /** Resume one reply target from this cursor. */
            fun startCursor(startCursor: String) = startCursor(JsonField.of(startCursor))

            /**
             * Sets [Builder.startCursor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.startCursor] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun startCursor(startCursor: JsonField<String>) = apply {
                this.startCursor = startCursor
            }

            /** Required for community_post_extractor & community_search. */
            fun targetCommunityId(targetCommunityId: String) =
                targetCommunityId(JsonField.of(targetCommunityId))

            /**
             * Sets [Builder.targetCommunityId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.targetCommunityId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun targetCommunityId(targetCommunityId: JsonField<String>) = apply {
                this.targetCommunityId = targetCommunityId
            }

            /** Community IDs processed as one collection job. */
            fun targetCommunityIds(targetCommunityIds: List<String>) =
                targetCommunityIds(JsonField.of(targetCommunityIds))

            /**
             * Sets [Builder.targetCommunityIds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.targetCommunityIds] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun targetCommunityIds(targetCommunityIds: JsonField<List<String>>) = apply {
                this.targetCommunityIds = targetCommunityIds.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [targetCommunityIds].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTargetCommunityId(targetCommunityId: String) = apply {
                targetCommunityIds =
                    (targetCommunityIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("targetCommunityIds", it).add(targetCommunityId)
                    }
            }

            /** Required for list_follower_explorer, list_member_extractor & list_post_extractor. */
            fun targetListId(targetListId: String) = targetListId(JsonField.of(targetListId))

            /**
             * Sets [Builder.targetListId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.targetListId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun targetListId(targetListId: JsonField<String>) = apply {
                this.targetListId = targetListId
            }

            /** List IDs processed as one collection job. */
            fun targetListIds(targetListIds: List<String>) =
                targetListIds(JsonField.of(targetListIds))

            /**
             * Sets [Builder.targetListIds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.targetListIds] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun targetListIds(targetListIds: JsonField<List<String>>) = apply {
                this.targetListIds = targetListIds.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [targetListIds].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTargetListId(targetListId: String) = apply {
                targetListIds =
                    (targetListIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("targetListIds", it).add(targetListId)
                    }
            }

            /** Mixed targets auto-routed within one job. */
            fun targets(targets: List<Target>) = targets(JsonField.of(targets))

            /**
             * Sets [Builder.targets] to an arbitrary JSON value.
             *
             * You should usually call [Builder.targets] with a well-typed `List<Target>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun targets(targets: JsonField<List<Target>>) = apply {
                this.targets = targets.map { it.toMutableList() }
            }

            /**
             * Adds a single [Target] to [targets].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTarget(target: Target) = apply {
                targets =
                    (targets ?: JsonField.of(mutableListOf())).also {
                        checkKnown("targets", it).add(target)
                    }
            }

            /** Alias for calling [addTarget] with `Target.ofString(string)`. */
            fun addTarget(string: String) = addTarget(Target.ofString(string))

            /** Alias for calling [addTarget] with `Target.ofUnionMember1(unionMember1)`. */
            fun addTarget(unionMember1: Target.UnionMember1) =
                addTarget(Target.ofUnionMember1(unionMember1))

            /** Required for space_explorer. */
            fun targetSpaceId(targetSpaceId: String) = targetSpaceId(JsonField.of(targetSpaceId))

            /**
             * Sets [Builder.targetSpaceId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.targetSpaceId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun targetSpaceId(targetSpaceId: JsonField<String>) = apply {
                this.targetSpaceId = targetSpaceId
            }

            fun targetTweetId(targetTweetId: String) = targetTweetId(JsonField.of(targetTweetId))

            /**
             * Sets [Builder.targetTweetId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.targetTweetId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun targetTweetId(targetTweetId: JsonField<String>) = apply {
                this.targetTweetId = targetTweetId
            }

            /** Tweet IDs processed as one collection job. */
            fun targetTweetIds(targetTweetIds: List<String>) =
                targetTweetIds(JsonField.of(targetTweetIds))

            /**
             * Sets [Builder.targetTweetIds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.targetTweetIds] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun targetTweetIds(targetTweetIds: JsonField<List<String>>) = apply {
                this.targetTweetIds = targetTweetIds.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [targetTweetIds].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTargetTweetId(targetTweetId: String) = apply {
                targetTweetIds =
                    (targetTweetIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("targetTweetIds", it).add(targetTweetId)
                    }
            }

            fun targetUsername(targetUsername: String) =
                targetUsername(JsonField.of(targetUsername))

            /**
             * Sets [Builder.targetUsername] to an arbitrary JSON value.
             *
             * You should usually call [Builder.targetUsername] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun targetUsername(targetUsername: JsonField<String>) = apply {
                this.targetUsername = targetUsername
            }

            /** Usernames processed as one collection job. */
            fun targetUsernames(targetUsernames: List<String>) =
                targetUsernames(JsonField.of(targetUsernames))

            /**
             * Sets [Builder.targetUsernames] to an arbitrary JSON value.
             *
             * You should usually call [Builder.targetUsernames] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun targetUsernames(targetUsernames: JsonField<List<String>>) = apply {
                this.targetUsernames = targetUsernames.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [targetUsernames].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTargetUsername(targetUsername: String) = apply {
                targetUsernames =
                    (targetUsernames ?: JsonField.of(mutableListOf())).also {
                        checkKnown("targetUsernames", it).add(targetUsername)
                    }
            }

            /** Filter replies sent to a username (tweet_search_extractor) */
            fun toUser(toUser: String) = toUser(JsonField.of(toUser))

            /**
             * Sets [Builder.toUser] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toUser] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun toUser(toUser: JsonField<String>) = apply { this.toUser = toUser }

            /** End date YYYY-MM-DD (tweet_search_extractor) */
            fun untilDate(untilDate: LocalDate) = untilDate(JsonField.of(untilDate))

            /**
             * Sets [Builder.untilDate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.untilDate] with a well-typed [LocalDate] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun untilDate(untilDate: JsonField<LocalDate>) = apply { this.untilDate = untilDate }

            /** Reply end time as ISO 8601 or Unix seconds. */
            fun untilTime(untilTime: UntilTime) = untilTime(JsonField.of(untilTime))

            /**
             * Sets [Builder.untilTime] to an arbitrary JSON value.
             *
             * You should usually call [Builder.untilTime] with a well-typed [UntilTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun untilTime(untilTime: JsonField<UntilTime>) = apply { this.untilTime = untilTime }

            /** Alias for calling [untilTime] with `UntilTime.ofOffsetDate(offsetDate)`. */
            fun untilTime(offsetDate: OffsetDateTime) =
                untilTime(UntilTime.ofOffsetDate(offsetDate))

            /** Alias for calling [untilTime] with `UntilTime.ofInteger(integer)`. */
            fun untilTime(integer: Long) = untilTime(UntilTime.ofInteger(integer))

            /** URL substring or domain filter (tweet_search_extractor) */
            fun url(url: String) = url(JsonField.of(url))

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun url(url: JsonField<String>) = apply { this.url = url }

            /** Required username text. */
            fun usernameContains(usernameContains: String) =
                usernameContains(JsonField.of(usernameContains))

            /**
             * Sets [Builder.usernameContains] to an arbitrary JSON value.
             *
             * You should usually call [Builder.usernameContains] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun usernameContains(usernameContains: JsonField<String>) = apply {
                this.usernameContains = usernameContains
            }

            /** Only verified authors (tweet_search_extractor) */
            fun verifiedOnly(verifiedOnly: Boolean) = verifiedOnly(JsonField.of(verifiedOnly))

            /**
             * Sets [Builder.verifiedOnly] to an arbitrary JSON value.
             *
             * You should usually call [Builder.verifiedOnly] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun verifiedOnly(verifiedOnly: JsonField<Boolean>) = apply {
                this.verifiedOnly = verifiedOnly
            }

            /** Exact profile verification type. */
            fun verifiedType(verifiedType: String) = verifiedType(JsonField.of(verifiedType))

            /**
             * Sets [Builder.verifiedType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.verifiedType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun verifiedType(verifiedType: JsonField<String>) = apply {
                this.verifiedType = verifiedType
            }

            /** Set the radius for the near filter. */
            fun within(within: String) = within(JsonField.of(within))

            /**
             * Sets [Builder.within] to an arbitrary JSON value.
             *
             * You should usually call [Builder.within] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun within(within: JsonField<String>) = apply { this.within = within }

            /** Match Tweets inside a recent time window. */
            fun withinTime(withinTime: String) = withinTime(JsonField.of(withinTime))

            /**
             * Sets [Builder.withinTime] to an arbitrary JSON value.
             *
             * You should usually call [Builder.withinTime] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun withinTime(withinTime: JsonField<String>) = apply { this.withinTime = withinTime }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .toolType()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("toolType", toolType),
                    advancedQuery,
                    anyWords,
                    bioContains,
                    blueVerifiedOnly,
                    boundingBox,
                    cardName,
                    cashtags,
                    collectionStrategy,
                    conversationId,
                    dedupeAcrossTargets,
                    dedupeMode,
                    exactPhrase,
                    excludeOriginalAuthor,
                    excludeSource,
                    excludeWords,
                    fromUser,
                    geocode,
                    hashtags,
                    hasLocation,
                    hasMediaOnly,
                    hasWebsite,
                    includeOriginalPost,
                    includeSearchTerms,
                    includeTargetMetadata,
                    inReplyToTweetId,
                    language,
                    listId,
                    locationContains,
                    maxDepth,
                    maxFollowers,
                    maxFollowing,
                    maxId,
                    maxItemsPerTarget,
                    maxLikes,
                    maxPagesPerTarget,
                    maxPosts,
                    maxQuotes,
                    maxReplies,
                    maxRetweets,
                    mediaType,
                    mentioning,
                    minAccountAgeDays,
                    minBookmarks,
                    minFaves,
                    minFollowers,
                    minFollowing,
                    minPosts,
                    minQuotes,
                    minReplies,
                    minRetweets,
                    minViews,
                    nativeRetweets,
                    near,
                    news,
                    overlapMode,
                    place,
                    placeCountry,
                    pointRadius,
                    queryType,
                    quotes,
                    quotesOfTweetId,
                    (relationTargets ?: JsonMissing.of()).map { it.toImmutable() },
                    replies,
                    resultsLimit,
                    retweets,
                    retweetsOfTweetId,
                    safe,
                    scope,
                    (searchQueries ?: JsonMissing.of()).map { it.toImmutable() },
                    searchQuery,
                    sinceDate,
                    sinceId,
                    sinceTime,
                    sort,
                    source,
                    startCursor,
                    targetCommunityId,
                    (targetCommunityIds ?: JsonMissing.of()).map { it.toImmutable() },
                    targetListId,
                    (targetListIds ?: JsonMissing.of()).map { it.toImmutable() },
                    (targets ?: JsonMissing.of()).map { it.toImmutable() },
                    targetSpaceId,
                    targetTweetId,
                    (targetTweetIds ?: JsonMissing.of()).map { it.toImmutable() },
                    targetUsername,
                    (targetUsernames ?: JsonMissing.of()).map { it.toImmutable() },
                    toUser,
                    untilDate,
                    untilTime,
                    url,
                    usernameContains,
                    verifiedOnly,
                    verifiedType,
                    within,
                    withinTime,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            toolType().validate()
            advancedQuery()
            anyWords()
            bioContains()
            blueVerifiedOnly()
            boundingBox()
            cardName()
            cashtags()
            collectionStrategy().ifPresent { it.validate() }
            conversationId()
            dedupeAcrossTargets()
            dedupeMode().ifPresent { it.validate() }
            exactPhrase()
            excludeOriginalAuthor()
            excludeSource()
            excludeWords()
            fromUser()
            geocode()
            hashtags()
            hasLocation()
            hasMediaOnly()
            hasWebsite()
            includeOriginalPost()
            includeSearchTerms()
            includeTargetMetadata()
            inReplyToTweetId()
            language()
            listId()
            locationContains()
            maxDepth()
            maxFollowers()
            maxFollowing()
            maxId()
            maxItemsPerTarget()
            maxLikes()
            maxPagesPerTarget()
            maxPosts()
            maxQuotes()
            maxReplies()
            maxRetweets()
            mediaType().ifPresent { it.validate() }
            mentioning()
            minAccountAgeDays()
            minBookmarks()
            minFaves()
            minFollowers()
            minFollowing()
            minPosts()
            minQuotes()
            minReplies()
            minRetweets()
            minViews()
            nativeRetweets()
            near()
            news()
            overlapMode()
            place()
            placeCountry()
            pointRadius()
            queryType().ifPresent { it.validate() }
            quotes().ifPresent { it.validate() }
            quotesOfTweetId()
            relationTargets().ifPresent { it.forEach { it.validate() } }
            replies().ifPresent { it.validate() }
            resultsLimit()
            retweets().ifPresent { it.validate() }
            retweetsOfTweetId()
            safe()
            scope().ifPresent { it.validate() }
            searchQueries()
            searchQuery()
            sinceDate()
            sinceId()
            sinceTime().ifPresent { it.validate() }
            sort().ifPresent { it.validate() }
            source()
            startCursor()
            targetCommunityId()
            targetCommunityIds()
            targetListId()
            targetListIds()
            targets().ifPresent { it.forEach { it.validate() } }
            targetSpaceId()
            targetTweetId()
            targetTweetIds()
            targetUsername()
            targetUsernames()
            toUser()
            untilDate()
            untilTime().ifPresent { it.validate() }
            url()
            usernameContains()
            verifiedOnly()
            verifiedType()
            within()
            withinTime()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (toolType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (advancedQuery.asKnown().isPresent) 1 else 0) +
                (if (anyWords.asKnown().isPresent) 1 else 0) +
                (if (bioContains.asKnown().isPresent) 1 else 0) +
                (if (blueVerifiedOnly.asKnown().isPresent) 1 else 0) +
                (if (boundingBox.asKnown().isPresent) 1 else 0) +
                (if (cardName.asKnown().isPresent) 1 else 0) +
                (if (cashtags.asKnown().isPresent) 1 else 0) +
                (collectionStrategy.asKnown().getOrNull()?.validity() ?: 0) +
                (if (conversationId.asKnown().isPresent) 1 else 0) +
                (if (dedupeAcrossTargets.asKnown().isPresent) 1 else 0) +
                (dedupeMode.asKnown().getOrNull()?.validity() ?: 0) +
                (if (exactPhrase.asKnown().isPresent) 1 else 0) +
                (if (excludeOriginalAuthor.asKnown().isPresent) 1 else 0) +
                (if (excludeSource.asKnown().isPresent) 1 else 0) +
                (if (excludeWords.asKnown().isPresent) 1 else 0) +
                (if (fromUser.asKnown().isPresent) 1 else 0) +
                (if (geocode.asKnown().isPresent) 1 else 0) +
                (if (hashtags.asKnown().isPresent) 1 else 0) +
                (if (hasLocation.asKnown().isPresent) 1 else 0) +
                (if (hasMediaOnly.asKnown().isPresent) 1 else 0) +
                (if (hasWebsite.asKnown().isPresent) 1 else 0) +
                (if (includeOriginalPost.asKnown().isPresent) 1 else 0) +
                (if (includeSearchTerms.asKnown().isPresent) 1 else 0) +
                (if (includeTargetMetadata.asKnown().isPresent) 1 else 0) +
                (if (inReplyToTweetId.asKnown().isPresent) 1 else 0) +
                (if (language.asKnown().isPresent) 1 else 0) +
                (if (listId.asKnown().isPresent) 1 else 0) +
                (if (locationContains.asKnown().isPresent) 1 else 0) +
                (if (maxDepth.asKnown().isPresent) 1 else 0) +
                (if (maxFollowers.asKnown().isPresent) 1 else 0) +
                (if (maxFollowing.asKnown().isPresent) 1 else 0) +
                (if (maxId.asKnown().isPresent) 1 else 0) +
                (if (maxItemsPerTarget.asKnown().isPresent) 1 else 0) +
                (if (maxLikes.asKnown().isPresent) 1 else 0) +
                (if (maxPagesPerTarget.asKnown().isPresent) 1 else 0) +
                (if (maxPosts.asKnown().isPresent) 1 else 0) +
                (if (maxQuotes.asKnown().isPresent) 1 else 0) +
                (if (maxReplies.asKnown().isPresent) 1 else 0) +
                (if (maxRetweets.asKnown().isPresent) 1 else 0) +
                (mediaType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (mentioning.asKnown().isPresent) 1 else 0) +
                (if (minAccountAgeDays.asKnown().isPresent) 1 else 0) +
                (if (minBookmarks.asKnown().isPresent) 1 else 0) +
                (if (minFaves.asKnown().isPresent) 1 else 0) +
                (if (minFollowers.asKnown().isPresent) 1 else 0) +
                (if (minFollowing.asKnown().isPresent) 1 else 0) +
                (if (minPosts.asKnown().isPresent) 1 else 0) +
                (if (minQuotes.asKnown().isPresent) 1 else 0) +
                (if (minReplies.asKnown().isPresent) 1 else 0) +
                (if (minRetweets.asKnown().isPresent) 1 else 0) +
                (if (minViews.asKnown().isPresent) 1 else 0) +
                (if (nativeRetweets.asKnown().isPresent) 1 else 0) +
                (if (near.asKnown().isPresent) 1 else 0) +
                (if (news.asKnown().isPresent) 1 else 0) +
                (if (overlapMode.asKnown().isPresent) 1 else 0) +
                (if (place.asKnown().isPresent) 1 else 0) +
                (if (placeCountry.asKnown().isPresent) 1 else 0) +
                (if (pointRadius.asKnown().isPresent) 1 else 0) +
                (queryType.asKnown().getOrNull()?.validity() ?: 0) +
                (quotes.asKnown().getOrNull()?.validity() ?: 0) +
                (if (quotesOfTweetId.asKnown().isPresent) 1 else 0) +
                (relationTargets.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (replies.asKnown().getOrNull()?.validity() ?: 0) +
                (if (resultsLimit.asKnown().isPresent) 1 else 0) +
                (retweets.asKnown().getOrNull()?.validity() ?: 0) +
                (if (retweetsOfTweetId.asKnown().isPresent) 1 else 0) +
                (if (safe.asKnown().isPresent) 1 else 0) +
                (scope.asKnown().getOrNull()?.validity() ?: 0) +
                (searchQueries.asKnown().getOrNull()?.size ?: 0) +
                (if (searchQuery.asKnown().isPresent) 1 else 0) +
                (if (sinceDate.asKnown().isPresent) 1 else 0) +
                (if (sinceId.asKnown().isPresent) 1 else 0) +
                (sinceTime.asKnown().getOrNull()?.validity() ?: 0) +
                (sort.asKnown().getOrNull()?.validity() ?: 0) +
                (if (source.asKnown().isPresent) 1 else 0) +
                (if (startCursor.asKnown().isPresent) 1 else 0) +
                (if (targetCommunityId.asKnown().isPresent) 1 else 0) +
                (targetCommunityIds.asKnown().getOrNull()?.size ?: 0) +
                (if (targetListId.asKnown().isPresent) 1 else 0) +
                (targetListIds.asKnown().getOrNull()?.size ?: 0) +
                (targets.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (targetSpaceId.asKnown().isPresent) 1 else 0) +
                (if (targetTweetId.asKnown().isPresent) 1 else 0) +
                (targetTweetIds.asKnown().getOrNull()?.size ?: 0) +
                (if (targetUsername.asKnown().isPresent) 1 else 0) +
                (targetUsernames.asKnown().getOrNull()?.size ?: 0) +
                (if (toUser.asKnown().isPresent) 1 else 0) +
                (if (untilDate.asKnown().isPresent) 1 else 0) +
                (untilTime.asKnown().getOrNull()?.validity() ?: 0) +
                (if (url.asKnown().isPresent) 1 else 0) +
                (if (usernameContains.asKnown().isPresent) 1 else 0) +
                (if (verifiedOnly.asKnown().isPresent) 1 else 0) +
                (if (verifiedType.asKnown().isPresent) 1 else 0) +
                (if (within.asKnown().isPresent) 1 else 0) +
                (if (withinTime.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                toolType == other.toolType &&
                advancedQuery == other.advancedQuery &&
                anyWords == other.anyWords &&
                bioContains == other.bioContains &&
                blueVerifiedOnly == other.blueVerifiedOnly &&
                boundingBox == other.boundingBox &&
                cardName == other.cardName &&
                cashtags == other.cashtags &&
                collectionStrategy == other.collectionStrategy &&
                conversationId == other.conversationId &&
                dedupeAcrossTargets == other.dedupeAcrossTargets &&
                dedupeMode == other.dedupeMode &&
                exactPhrase == other.exactPhrase &&
                excludeOriginalAuthor == other.excludeOriginalAuthor &&
                excludeSource == other.excludeSource &&
                excludeWords == other.excludeWords &&
                fromUser == other.fromUser &&
                geocode == other.geocode &&
                hashtags == other.hashtags &&
                hasLocation == other.hasLocation &&
                hasMediaOnly == other.hasMediaOnly &&
                hasWebsite == other.hasWebsite &&
                includeOriginalPost == other.includeOriginalPost &&
                includeSearchTerms == other.includeSearchTerms &&
                includeTargetMetadata == other.includeTargetMetadata &&
                inReplyToTweetId == other.inReplyToTweetId &&
                language == other.language &&
                listId == other.listId &&
                locationContains == other.locationContains &&
                maxDepth == other.maxDepth &&
                maxFollowers == other.maxFollowers &&
                maxFollowing == other.maxFollowing &&
                maxId == other.maxId &&
                maxItemsPerTarget == other.maxItemsPerTarget &&
                maxLikes == other.maxLikes &&
                maxPagesPerTarget == other.maxPagesPerTarget &&
                maxPosts == other.maxPosts &&
                maxQuotes == other.maxQuotes &&
                maxReplies == other.maxReplies &&
                maxRetweets == other.maxRetweets &&
                mediaType == other.mediaType &&
                mentioning == other.mentioning &&
                minAccountAgeDays == other.minAccountAgeDays &&
                minBookmarks == other.minBookmarks &&
                minFaves == other.minFaves &&
                minFollowers == other.minFollowers &&
                minFollowing == other.minFollowing &&
                minPosts == other.minPosts &&
                minQuotes == other.minQuotes &&
                minReplies == other.minReplies &&
                minRetweets == other.minRetweets &&
                minViews == other.minViews &&
                nativeRetweets == other.nativeRetweets &&
                near == other.near &&
                news == other.news &&
                overlapMode == other.overlapMode &&
                place == other.place &&
                placeCountry == other.placeCountry &&
                pointRadius == other.pointRadius &&
                queryType == other.queryType &&
                quotes == other.quotes &&
                quotesOfTweetId == other.quotesOfTweetId &&
                relationTargets == other.relationTargets &&
                replies == other.replies &&
                resultsLimit == other.resultsLimit &&
                retweets == other.retweets &&
                retweetsOfTweetId == other.retweetsOfTweetId &&
                safe == other.safe &&
                scope == other.scope &&
                searchQueries == other.searchQueries &&
                searchQuery == other.searchQuery &&
                sinceDate == other.sinceDate &&
                sinceId == other.sinceId &&
                sinceTime == other.sinceTime &&
                sort == other.sort &&
                source == other.source &&
                startCursor == other.startCursor &&
                targetCommunityId == other.targetCommunityId &&
                targetCommunityIds == other.targetCommunityIds &&
                targetListId == other.targetListId &&
                targetListIds == other.targetListIds &&
                targets == other.targets &&
                targetSpaceId == other.targetSpaceId &&
                targetTweetId == other.targetTweetId &&
                targetTweetIds == other.targetTweetIds &&
                targetUsername == other.targetUsername &&
                targetUsernames == other.targetUsernames &&
                toUser == other.toUser &&
                untilDate == other.untilDate &&
                untilTime == other.untilTime &&
                url == other.url &&
                usernameContains == other.usernameContains &&
                verifiedOnly == other.verifiedOnly &&
                verifiedType == other.verifiedType &&
                within == other.within &&
                withinTime == other.withinTime &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                toolType,
                advancedQuery,
                anyWords,
                bioContains,
                blueVerifiedOnly,
                boundingBox,
                cardName,
                cashtags,
                collectionStrategy,
                conversationId,
                dedupeAcrossTargets,
                dedupeMode,
                exactPhrase,
                excludeOriginalAuthor,
                excludeSource,
                excludeWords,
                fromUser,
                geocode,
                hashtags,
                hasLocation,
                hasMediaOnly,
                hasWebsite,
                includeOriginalPost,
                includeSearchTerms,
                includeTargetMetadata,
                inReplyToTweetId,
                language,
                listId,
                locationContains,
                maxDepth,
                maxFollowers,
                maxFollowing,
                maxId,
                maxItemsPerTarget,
                maxLikes,
                maxPagesPerTarget,
                maxPosts,
                maxQuotes,
                maxReplies,
                maxRetweets,
                mediaType,
                mentioning,
                minAccountAgeDays,
                minBookmarks,
                minFaves,
                minFollowers,
                minFollowing,
                minPosts,
                minQuotes,
                minReplies,
                minRetweets,
                minViews,
                nativeRetweets,
                near,
                news,
                overlapMode,
                place,
                placeCountry,
                pointRadius,
                queryType,
                quotes,
                quotesOfTweetId,
                relationTargets,
                replies,
                resultsLimit,
                retweets,
                retweetsOfTweetId,
                safe,
                scope,
                searchQueries,
                searchQuery,
                sinceDate,
                sinceId,
                sinceTime,
                sort,
                source,
                startCursor,
                targetCommunityId,
                targetCommunityIds,
                targetListId,
                targetListIds,
                targets,
                targetSpaceId,
                targetTweetId,
                targetTweetIds,
                targetUsername,
                targetUsernames,
                toUser,
                untilDate,
                untilTime,
                url,
                usernameContains,
                verifiedOnly,
                verifiedType,
                within,
                withinTime,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{toolType=$toolType, advancedQuery=$advancedQuery, anyWords=$anyWords, bioContains=$bioContains, blueVerifiedOnly=$blueVerifiedOnly, boundingBox=$boundingBox, cardName=$cardName, cashtags=$cashtags, collectionStrategy=$collectionStrategy, conversationId=$conversationId, dedupeAcrossTargets=$dedupeAcrossTargets, dedupeMode=$dedupeMode, exactPhrase=$exactPhrase, excludeOriginalAuthor=$excludeOriginalAuthor, excludeSource=$excludeSource, excludeWords=$excludeWords, fromUser=$fromUser, geocode=$geocode, hashtags=$hashtags, hasLocation=$hasLocation, hasMediaOnly=$hasMediaOnly, hasWebsite=$hasWebsite, includeOriginalPost=$includeOriginalPost, includeSearchTerms=$includeSearchTerms, includeTargetMetadata=$includeTargetMetadata, inReplyToTweetId=$inReplyToTweetId, language=$language, listId=$listId, locationContains=$locationContains, maxDepth=$maxDepth, maxFollowers=$maxFollowers, maxFollowing=$maxFollowing, maxId=$maxId, maxItemsPerTarget=$maxItemsPerTarget, maxLikes=$maxLikes, maxPagesPerTarget=$maxPagesPerTarget, maxPosts=$maxPosts, maxQuotes=$maxQuotes, maxReplies=$maxReplies, maxRetweets=$maxRetweets, mediaType=$mediaType, mentioning=$mentioning, minAccountAgeDays=$minAccountAgeDays, minBookmarks=$minBookmarks, minFaves=$minFaves, minFollowers=$minFollowers, minFollowing=$minFollowing, minPosts=$minPosts, minQuotes=$minQuotes, minReplies=$minReplies, minRetweets=$minRetweets, minViews=$minViews, nativeRetweets=$nativeRetweets, near=$near, news=$news, overlapMode=$overlapMode, place=$place, placeCountry=$placeCountry, pointRadius=$pointRadius, queryType=$queryType, quotes=$quotes, quotesOfTweetId=$quotesOfTweetId, relationTargets=$relationTargets, replies=$replies, resultsLimit=$resultsLimit, retweets=$retweets, retweetsOfTweetId=$retweetsOfTweetId, safe=$safe, scope=$scope, searchQueries=$searchQueries, searchQuery=$searchQuery, sinceDate=$sinceDate, sinceId=$sinceId, sinceTime=$sinceTime, sort=$sort, source=$source, startCursor=$startCursor, targetCommunityId=$targetCommunityId, targetCommunityIds=$targetCommunityIds, targetListId=$targetListId, targetListIds=$targetListIds, targets=$targets, targetSpaceId=$targetSpaceId, targetTweetId=$targetTweetId, targetTweetIds=$targetTweetIds, targetUsername=$targetUsername, targetUsernames=$targetUsernames, toUser=$toUser, untilDate=$untilDate, untilTime=$untilTime, url=$url, usernameContains=$usernameContains, verifiedOnly=$verifiedOnly, verifiedType=$verifiedType, within=$within, withinTime=$withinTime, additionalProperties=$additionalProperties}"
    }

    /** Identifier for the extraction tool used to run a job. */
    class ToolType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val ARTICLE_EXTRACTOR = of("article_extractor")

            @JvmField val COMMUNITY_EXTRACTOR = of("community_extractor")

            @JvmField val COMMUNITY_MODERATOR_EXPLORER = of("community_moderator_explorer")

            @JvmField val COMMUNITY_POST_EXTRACTOR = of("community_post_extractor")

            @JvmField val COMMUNITY_SEARCH = of("community_search")

            @JvmField val FAVORITERS = of("favoriters")

            @JvmField val FOLLOWER_EXPLORER = of("follower_explorer")

            @JvmField val FOLLOWING_EXPLORER = of("following_explorer")

            @JvmField val LIST_FOLLOWER_EXPLORER = of("list_follower_explorer")

            @JvmField val LIST_MEMBER_EXTRACTOR = of("list_member_extractor")

            @JvmField val LIST_POST_EXTRACTOR = of("list_post_extractor")

            @JvmField val MENTION_EXTRACTOR = of("mention_extractor")

            @JvmField val PEOPLE_SEARCH = of("people_search")

            @JvmField val POST_EXTRACTOR = of("post_extractor")

            @JvmField val QUOTE_EXTRACTOR = of("quote_extractor")

            @JvmField val REPLY_EXTRACTOR = of("reply_extractor")

            @JvmField val REPOST_EXTRACTOR = of("repost_extractor")

            @JvmField val SPACE_EXPLORER = of("space_explorer")

            @JvmField val THREAD_EXTRACTOR = of("thread_extractor")

            @JvmField val TWEET_SEARCH_EXTRACTOR = of("tweet_search_extractor")

            @JvmField val USER_LIKES = of("user_likes")

            @JvmField val USER_MEDIA = of("user_media")

            @JvmField val VERIFIED_FOLLOWER_EXPLORER = of("verified_follower_explorer")

            @JvmStatic fun of(value: String) = ToolType(JsonField.of(value))
        }

        /** An enum containing [ToolType]'s known values. */
        enum class Known {
            ARTICLE_EXTRACTOR,
            COMMUNITY_EXTRACTOR,
            COMMUNITY_MODERATOR_EXPLORER,
            COMMUNITY_POST_EXTRACTOR,
            COMMUNITY_SEARCH,
            FAVORITERS,
            FOLLOWER_EXPLORER,
            FOLLOWING_EXPLORER,
            LIST_FOLLOWER_EXPLORER,
            LIST_MEMBER_EXTRACTOR,
            LIST_POST_EXTRACTOR,
            MENTION_EXTRACTOR,
            PEOPLE_SEARCH,
            POST_EXTRACTOR,
            QUOTE_EXTRACTOR,
            REPLY_EXTRACTOR,
            REPOST_EXTRACTOR,
            SPACE_EXPLORER,
            THREAD_EXTRACTOR,
            TWEET_SEARCH_EXTRACTOR,
            USER_LIKES,
            USER_MEDIA,
            VERIFIED_FOLLOWER_EXPLORER,
        }

        /**
         * An enum containing [ToolType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ToolType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ARTICLE_EXTRACTOR,
            COMMUNITY_EXTRACTOR,
            COMMUNITY_MODERATOR_EXPLORER,
            COMMUNITY_POST_EXTRACTOR,
            COMMUNITY_SEARCH,
            FAVORITERS,
            FOLLOWER_EXPLORER,
            FOLLOWING_EXPLORER,
            LIST_FOLLOWER_EXPLORER,
            LIST_MEMBER_EXTRACTOR,
            LIST_POST_EXTRACTOR,
            MENTION_EXTRACTOR,
            PEOPLE_SEARCH,
            POST_EXTRACTOR,
            QUOTE_EXTRACTOR,
            REPLY_EXTRACTOR,
            REPOST_EXTRACTOR,
            SPACE_EXPLORER,
            THREAD_EXTRACTOR,
            TWEET_SEARCH_EXTRACTOR,
            USER_LIKES,
            USER_MEDIA,
            VERIFIED_FOLLOWER_EXPLORER,
            /** An enum member indicating that [ToolType] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                ARTICLE_EXTRACTOR -> Value.ARTICLE_EXTRACTOR
                COMMUNITY_EXTRACTOR -> Value.COMMUNITY_EXTRACTOR
                COMMUNITY_MODERATOR_EXPLORER -> Value.COMMUNITY_MODERATOR_EXPLORER
                COMMUNITY_POST_EXTRACTOR -> Value.COMMUNITY_POST_EXTRACTOR
                COMMUNITY_SEARCH -> Value.COMMUNITY_SEARCH
                FAVORITERS -> Value.FAVORITERS
                FOLLOWER_EXPLORER -> Value.FOLLOWER_EXPLORER
                FOLLOWING_EXPLORER -> Value.FOLLOWING_EXPLORER
                LIST_FOLLOWER_EXPLORER -> Value.LIST_FOLLOWER_EXPLORER
                LIST_MEMBER_EXTRACTOR -> Value.LIST_MEMBER_EXTRACTOR
                LIST_POST_EXTRACTOR -> Value.LIST_POST_EXTRACTOR
                MENTION_EXTRACTOR -> Value.MENTION_EXTRACTOR
                PEOPLE_SEARCH -> Value.PEOPLE_SEARCH
                POST_EXTRACTOR -> Value.POST_EXTRACTOR
                QUOTE_EXTRACTOR -> Value.QUOTE_EXTRACTOR
                REPLY_EXTRACTOR -> Value.REPLY_EXTRACTOR
                REPOST_EXTRACTOR -> Value.REPOST_EXTRACTOR
                SPACE_EXPLORER -> Value.SPACE_EXPLORER
                THREAD_EXTRACTOR -> Value.THREAD_EXTRACTOR
                TWEET_SEARCH_EXTRACTOR -> Value.TWEET_SEARCH_EXTRACTOR
                USER_LIKES -> Value.USER_LIKES
                USER_MEDIA -> Value.USER_MEDIA
                VERIFIED_FOLLOWER_EXPLORER -> Value.VERIFIED_FOLLOWER_EXPLORER
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                ARTICLE_EXTRACTOR -> Known.ARTICLE_EXTRACTOR
                COMMUNITY_EXTRACTOR -> Known.COMMUNITY_EXTRACTOR
                COMMUNITY_MODERATOR_EXPLORER -> Known.COMMUNITY_MODERATOR_EXPLORER
                COMMUNITY_POST_EXTRACTOR -> Known.COMMUNITY_POST_EXTRACTOR
                COMMUNITY_SEARCH -> Known.COMMUNITY_SEARCH
                FAVORITERS -> Known.FAVORITERS
                FOLLOWER_EXPLORER -> Known.FOLLOWER_EXPLORER
                FOLLOWING_EXPLORER -> Known.FOLLOWING_EXPLORER
                LIST_FOLLOWER_EXPLORER -> Known.LIST_FOLLOWER_EXPLORER
                LIST_MEMBER_EXTRACTOR -> Known.LIST_MEMBER_EXTRACTOR
                LIST_POST_EXTRACTOR -> Known.LIST_POST_EXTRACTOR
                MENTION_EXTRACTOR -> Known.MENTION_EXTRACTOR
                PEOPLE_SEARCH -> Known.PEOPLE_SEARCH
                POST_EXTRACTOR -> Known.POST_EXTRACTOR
                QUOTE_EXTRACTOR -> Known.QUOTE_EXTRACTOR
                REPLY_EXTRACTOR -> Known.REPLY_EXTRACTOR
                REPOST_EXTRACTOR -> Known.REPOST_EXTRACTOR
                SPACE_EXPLORER -> Known.SPACE_EXPLORER
                THREAD_EXTRACTOR -> Known.THREAD_EXTRACTOR
                TWEET_SEARCH_EXTRACTOR -> Known.TWEET_SEARCH_EXTRACTOR
                USER_LIKES -> Known.USER_LIKES
                USER_MEDIA -> Known.USER_MEDIA
                VERIFIED_FOLLOWER_EXPLORER -> Known.VERIFIED_FOLLOWER_EXPLORER
                else -> throw XTwitterScraperInvalidDataException("Unknown ToolType: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): ToolType = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ToolType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Reply collection strategy. */
    class CollectionStrategy
    @JsonCreator
    private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val AUTO = of("auto")

            @JvmField val COMPLETE = of("complete")

            @JvmField val DIRECT = of("direct")

            @JvmField val SEARCH = of("search")

            @JvmField val THREAD = of("thread")

            @JvmStatic fun of(value: String) = CollectionStrategy(JsonField.of(value))
        }

        /** An enum containing [CollectionStrategy]'s known values. */
        enum class Known {
            AUTO,
            COMPLETE,
            DIRECT,
            SEARCH,
            THREAD,
        }

        /**
         * An enum containing [CollectionStrategy]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [CollectionStrategy] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            AUTO,
            COMPLETE,
            DIRECT,
            SEARCH,
            THREAD,
            /**
             * An enum member indicating that [CollectionStrategy] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                AUTO -> Value.AUTO
                COMPLETE -> Value.COMPLETE
                DIRECT -> Value.DIRECT
                SEARCH -> Value.SEARCH
                THREAD -> Value.THREAD
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                AUTO -> Known.AUTO
                COMPLETE -> Known.COMPLETE
                DIRECT -> Known.DIRECT
                SEARCH -> Known.SEARCH
                THREAD -> Known.THREAD
                else ->
                    throw XTwitterScraperInvalidDataException("Unknown CollectionStrategy: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): CollectionStrategy = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CollectionStrategy && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Keep target duplicates, first rows, or merged overlap. */
    class DedupeMode @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val NONE = of("none")

            @JvmField val FIRST = of("first")

            @JvmField val MERGE = of("merge")

            @JvmStatic fun of(value: String) = DedupeMode(JsonField.of(value))
        }

        /** An enum containing [DedupeMode]'s known values. */
        enum class Known {
            NONE,
            FIRST,
            MERGE,
        }

        /**
         * An enum containing [DedupeMode]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [DedupeMode] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            NONE,
            FIRST,
            MERGE,
            /**
             * An enum member indicating that [DedupeMode] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                NONE -> Value.NONE
                FIRST -> Value.FIRST
                MERGE -> Value.MERGE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                NONE -> Known.NONE
                FIRST -> Known.FIRST
                MERGE -> Known.MERGE
                else -> throw XTwitterScraperInvalidDataException("Unknown DedupeMode: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): DedupeMode = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is DedupeMode && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Media type filter (tweet_search_extractor) */
    class MediaType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val IMAGES = of("images")

            @JvmField val VIDEOS = of("videos")

            @JvmField val GIFS = of("gifs")

            @JvmField val MEDIA = of("media")

            @JvmField val LINKS = of("links")

            @JvmField val NONE = of("none")

            @JvmStatic fun of(value: String) = MediaType(JsonField.of(value))
        }

        /** An enum containing [MediaType]'s known values. */
        enum class Known {
            IMAGES,
            VIDEOS,
            GIFS,
            MEDIA,
            LINKS,
            NONE,
        }

        /**
         * An enum containing [MediaType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [MediaType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            IMAGES,
            VIDEOS,
            GIFS,
            MEDIA,
            LINKS,
            NONE,
            /**
             * An enum member indicating that [MediaType] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                IMAGES -> Value.IMAGES
                VIDEOS -> Value.VIDEOS
                GIFS -> Value.GIFS
                MEDIA -> Value.MEDIA
                LINKS -> Value.LINKS
                NONE -> Value.NONE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                IMAGES -> Known.IMAGES
                VIDEOS -> Known.VIDEOS
                GIFS -> Known.GIFS
                MEDIA -> Known.MEDIA
                LINKS -> Known.LINKS
                NONE -> Known.NONE
                else -> throw XTwitterScraperInvalidDataException("Unknown MediaType: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): MediaType = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MediaType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Search ranking applied to every query. */
    class QueryType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val LATEST = of("Latest")

            @JvmField val TOP = of("Top")

            @JvmField val BOTH = of("Both")

            @JvmStatic fun of(value: String) = QueryType(JsonField.of(value))
        }

        /** An enum containing [QueryType]'s known values. */
        enum class Known {
            LATEST,
            TOP,
            BOTH,
        }

        /**
         * An enum containing [QueryType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [QueryType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            LATEST,
            TOP,
            BOTH,
            /**
             * An enum member indicating that [QueryType] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                LATEST -> Value.LATEST
                TOP -> Value.TOP
                BOTH -> Value.BOTH
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                LATEST -> Known.LATEST
                TOP -> Known.TOP
                BOTH -> Known.BOTH
                else -> throw XTwitterScraperInvalidDataException("Unknown QueryType: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): QueryType = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is QueryType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Quote mode (tweet_search_extractor) */
    class Quotes @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val INCLUDE = of("include")

            @JvmField val EXCLUDE = of("exclude")

            @JvmField val ONLY = of("only")

            @JvmStatic fun of(value: String) = Quotes(JsonField.of(value))
        }

        /** An enum containing [Quotes]'s known values. */
        enum class Known {
            INCLUDE,
            EXCLUDE,
            ONLY,
        }

        /**
         * An enum containing [Quotes]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Quotes] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            INCLUDE,
            EXCLUDE,
            ONLY,
            /** An enum member indicating that [Quotes] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                INCLUDE -> Value.INCLUDE
                EXCLUDE -> Value.EXCLUDE
                ONLY -> Value.ONLY
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                INCLUDE -> Known.INCLUDE
                EXCLUDE -> Known.EXCLUDE
                ONLY -> Known.ONLY
                else -> throw XTwitterScraperInvalidDataException("Unknown Quotes: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Quotes = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Quotes && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** One target and relation in a mixed profile collection. */
    class RelationTarget
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val relation: JsonField<Relation>,
        private val value: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("relation")
            @ExcludeMissing
            relation: JsonField<Relation> = JsonMissing.of(),
            @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
        ) : this(relation, value, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun relation(): Relation = relation.getRequired("relation")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun value(): String = value.getRequired("value")

        /**
         * Returns the raw JSON value of [relation].
         *
         * Unlike [relation], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("relation") @ExcludeMissing fun _relation(): JsonField<Relation> = relation

        /**
         * Returns the raw JSON value of [value].
         *
         * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [RelationTarget].
             *
             * The following fields are required:
             * ```java
             * .relation()
             * .value()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [RelationTarget]. */
        class Builder internal constructor() {

            private var relation: JsonField<Relation>? = null
            private var value: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(relationTarget: RelationTarget) = apply {
                relation = relationTarget.relation
                value = relationTarget.value
                additionalProperties = relationTarget.additionalProperties.toMutableMap()
            }

            fun relation(relation: Relation) = relation(JsonField.of(relation))

            /**
             * Sets [Builder.relation] to an arbitrary JSON value.
             *
             * You should usually call [Builder.relation] with a well-typed [Relation] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun relation(relation: JsonField<Relation>) = apply { this.relation = relation }

            fun value(value: String) = value(JsonField.of(value))

            /**
             * Sets [Builder.value] to an arbitrary JSON value.
             *
             * You should usually call [Builder.value] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun value(value: JsonField<String>) = apply { this.value = value }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [RelationTarget].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .relation()
             * .value()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): RelationTarget =
                RelationTarget(
                    checkRequired("relation", relation),
                    checkRequired("value", value),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): RelationTarget = apply {
            if (validated) {
                return@apply
            }

            relation().validate()
            value()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (relation.asKnown().getOrNull()?.validity() ?: 0) +
                (if (value.asKnown().isPresent) 1 else 0)

        class Relation @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val COMMUNITY_MEMBERS = of("community_members")

                @JvmField val FOLLOWERS = of("followers")

                @JvmField val FOLLOWING = of("following")

                @JvmField val LIST_FOLLOWERS = of("list_followers")

                @JvmField val LIST_MEMBERS = of("list_members")

                @JvmField val VERIFIED_FOLLOWERS = of("verified_followers")

                @JvmStatic fun of(value: String) = Relation(JsonField.of(value))
            }

            /** An enum containing [Relation]'s known values. */
            enum class Known {
                COMMUNITY_MEMBERS,
                FOLLOWERS,
                FOLLOWING,
                LIST_FOLLOWERS,
                LIST_MEMBERS,
                VERIFIED_FOLLOWERS,
            }

            /**
             * An enum containing [Relation]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Relation] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                COMMUNITY_MEMBERS,
                FOLLOWERS,
                FOLLOWING,
                LIST_FOLLOWERS,
                LIST_MEMBERS,
                VERIFIED_FOLLOWERS,
                /**
                 * An enum member indicating that [Relation] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    COMMUNITY_MEMBERS -> Value.COMMUNITY_MEMBERS
                    FOLLOWERS -> Value.FOLLOWERS
                    FOLLOWING -> Value.FOLLOWING
                    LIST_FOLLOWERS -> Value.LIST_FOLLOWERS
                    LIST_MEMBERS -> Value.LIST_MEMBERS
                    VERIFIED_FOLLOWERS -> Value.VERIFIED_FOLLOWERS
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    COMMUNITY_MEMBERS -> Known.COMMUNITY_MEMBERS
                    FOLLOWERS -> Known.FOLLOWERS
                    FOLLOWING -> Known.FOLLOWING
                    LIST_FOLLOWERS -> Known.LIST_FOLLOWERS
                    LIST_MEMBERS -> Known.LIST_MEMBERS
                    VERIFIED_FOLLOWERS -> Known.VERIFIED_FOLLOWERS
                    else -> throw XTwitterScraperInvalidDataException("Unknown Relation: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value does not
             *   have the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    XTwitterScraperInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): Relation = apply {
                if (validated) {
                    return@apply
                }

                known()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Relation && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RelationTarget &&
                relation == other.relation &&
                value == other.value &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(relation, value, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "RelationTarget{relation=$relation, value=$value, additionalProperties=$additionalProperties}"
    }

    /** Reply mode (tweet_search_extractor) */
    class Replies @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val INCLUDE = of("include")

            @JvmField val EXCLUDE = of("exclude")

            @JvmField val ONLY = of("only")

            @JvmStatic fun of(value: String) = Replies(JsonField.of(value))
        }

        /** An enum containing [Replies]'s known values. */
        enum class Known {
            INCLUDE,
            EXCLUDE,
            ONLY,
        }

        /**
         * An enum containing [Replies]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Replies] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            INCLUDE,
            EXCLUDE,
            ONLY,
            /** An enum member indicating that [Replies] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                INCLUDE -> Value.INCLUDE
                EXCLUDE -> Value.EXCLUDE
                ONLY -> Value.ONLY
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                INCLUDE -> Known.INCLUDE
                EXCLUDE -> Known.EXCLUDE
                ONLY -> Known.ONLY
                else -> throw XTwitterScraperInvalidDataException("Unknown Replies: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Replies = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Replies && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Retweet mode (tweet_search_extractor) */
    class Retweets @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val INCLUDE = of("include")

            @JvmField val EXCLUDE = of("exclude")

            @JvmField val ONLY = of("only")

            @JvmStatic fun of(value: String) = Retweets(JsonField.of(value))
        }

        /** An enum containing [Retweets]'s known values. */
        enum class Known {
            INCLUDE,
            EXCLUDE,
            ONLY,
        }

        /**
         * An enum containing [Retweets]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Retweets] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            INCLUDE,
            EXCLUDE,
            ONLY,
            /** An enum member indicating that [Retweets] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                INCLUDE -> Value.INCLUDE
                EXCLUDE -> Value.EXCLUDE
                ONLY -> Value.ONLY
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                INCLUDE -> Known.INCLUDE
                EXCLUDE -> Known.EXCLUDE
                ONLY -> Known.ONLY
                else -> throw XTwitterScraperInvalidDataException("Unknown Retweets: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Retweets = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Retweets && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Reply depth scope. */
    class Scope @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val ALL = of("all")

            @JvmField val DIRECT = of("direct")

            @JvmField val NESTED = of("nested")

            @JvmStatic fun of(value: String) = Scope(JsonField.of(value))
        }

        /** An enum containing [Scope]'s known values. */
        enum class Known {
            ALL,
            DIRECT,
            NESTED,
        }

        /**
         * An enum containing [Scope]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Scope] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ALL,
            DIRECT,
            NESTED,
            /** An enum member indicating that [Scope] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                ALL -> Value.ALL
                DIRECT -> Value.DIRECT
                NESTED -> Value.NESTED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                ALL -> Known.ALL
                DIRECT -> Known.DIRECT
                NESTED -> Known.NESTED
                else -> throw XTwitterScraperInvalidDataException("Unknown Scope: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Scope = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Scope && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Reply start time as ISO 8601 or Unix seconds. */
    @JsonDeserialize(using = SinceTime.Deserializer::class)
    @JsonSerialize(using = SinceTime.Serializer::class)
    class SinceTime
    private constructor(
        private val offsetDate: OffsetDateTime? = null,
        private val integer: Long? = null,
        private val _json: JsonValue? = null,
    ) {

        fun offsetDate(): Optional<OffsetDateTime> = Optional.ofNullable(offsetDate)

        fun integer(): Optional<Long> = Optional.ofNullable(integer)

        fun isOffsetDate(): Boolean = offsetDate != null

        fun isInteger(): Boolean = integer != null

        fun asOffsetDate(): OffsetDateTime = offsetDate.getOrThrow("offsetDate")

        fun asInteger(): Long = integer.getOrThrow("integer")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.x_twitter_scraper.api.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = sinceTime.accept(new SinceTime.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitOffsetDate(OffsetDateTime offsetDate) {
         *         return Optional.of(offsetDate.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws XTwitterScraperInvalidDataException if [Visitor.unknown] is not overridden in
         *   [visitor] and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                offsetDate != null -> visitor.visitOffsetDate(offsetDate)
                integer != null -> visitor.visitInteger(integer)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): SinceTime = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitOffsetDate(offsetDate: OffsetDateTime) {}

                    override fun visitInteger(integer: Long) {}
                }
            )
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitOffsetDate(offsetDate: OffsetDateTime) = 1

                    override fun visitInteger(integer: Long) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is SinceTime && offsetDate == other.offsetDate && integer == other.integer
        }

        override fun hashCode(): Int = Objects.hash(offsetDate, integer)

        override fun toString(): String =
            when {
                offsetDate != null -> "SinceTime{offsetDate=$offsetDate}"
                integer != null -> "SinceTime{integer=$integer}"
                _json != null -> "SinceTime{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid SinceTime")
            }

        companion object {

            @JvmStatic
            fun ofOffsetDate(offsetDate: OffsetDateTime) = SinceTime(offsetDate = offsetDate)

            @JvmStatic fun ofInteger(integer: Long) = SinceTime(integer = integer)
        }

        /**
         * An interface that defines how to map each variant of [SinceTime] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitOffsetDate(offsetDate: OffsetDateTime): T

            fun visitInteger(integer: Long): T

            /**
             * Maps an unknown variant of [SinceTime] to a value of type [T].
             *
             * An instance of [SinceTime] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws XTwitterScraperInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw XTwitterScraperInvalidDataException("Unknown SinceTime: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<SinceTime>(SinceTime::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): SinceTime {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<OffsetDateTime>())?.let {
                                SinceTime(offsetDate = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                SinceTime(integer = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> SinceTime(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<SinceTime>(SinceTime::class) {

            override fun serialize(
                value: SinceTime,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.offsetDate != null -> generator.writeObject(value.offsetDate)
                    value.integer != null -> generator.writeObject(value.integer)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid SinceTime")
                }
            }
        }
    }

    /** Reply result order. */
    class Sort @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val RELEVANCE = of("relevance")

            @JvmField val LATEST = of("latest")

            @JvmField val OLDEST = of("oldest")

            @JvmField val LIKES = of("likes")

            @JvmStatic fun of(value: String) = Sort(JsonField.of(value))
        }

        /** An enum containing [Sort]'s known values. */
        enum class Known {
            RELEVANCE,
            LATEST,
            OLDEST,
            LIKES,
        }

        /**
         * An enum containing [Sort]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Sort] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            RELEVANCE,
            LATEST,
            OLDEST,
            LIKES,
            /** An enum member indicating that [Sort] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                RELEVANCE -> Value.RELEVANCE
                LATEST -> Value.LATEST
                OLDEST -> Value.OLDEST
                LIKES -> Value.LIKES
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                RELEVANCE -> Known.RELEVANCE
                LATEST -> Known.LATEST
                OLDEST -> Known.OLDEST
                LIKES -> Known.LIKES
                else -> throw XTwitterScraperInvalidDataException("Unknown Sort: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Sort = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Sort && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** One auto-routed target in a mixed Tweet collection. */
    @JsonDeserialize(using = Target.Deserializer::class)
    @JsonSerialize(using = Target.Serializer::class)
    class Target
    private constructor(
        private val string: String? = null,
        private val unionMember1: UnionMember1? = null,
        private val _json: JsonValue? = null,
    ) {

        /** X URL, numeric Tweet ID, @username, kind:value target, or search. */
        fun string(): Optional<String> = Optional.ofNullable(string)

        fun unionMember1(): Optional<UnionMember1> = Optional.ofNullable(unionMember1)

        fun isString(): Boolean = string != null

        fun isUnionMember1(): Boolean = unionMember1 != null

        /** X URL, numeric Tweet ID, @username, kind:value target, or search. */
        fun asString(): String = string.getOrThrow("string")

        fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.x_twitter_scraper.api.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = target.accept(new Target.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitString(String string) {
         *         return Optional.of(string.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws XTwitterScraperInvalidDataException if [Visitor.unknown] is not overridden in
         *   [visitor] and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                string != null -> visitor.visitString(string)
                unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): Target = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitUnionMember1(unionMember1: UnionMember1) {
                        unionMember1.validate()
                    }
                }
            )
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitString(string: String) = 1

                    override fun visitUnionMember1(unionMember1: UnionMember1) =
                        unionMember1.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Target && string == other.string && unionMember1 == other.unionMember1
        }

        override fun hashCode(): Int = Objects.hash(string, unionMember1)

        override fun toString(): String =
            when {
                string != null -> "Target{string=$string}"
                unionMember1 != null -> "Target{unionMember1=$unionMember1}"
                _json != null -> "Target{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Target")
            }

        companion object {

            /** X URL, numeric Tweet ID, @username, kind:value target, or search. */
            @JvmStatic fun ofString(string: String) = Target(string = string)

            @JvmStatic
            fun ofUnionMember1(unionMember1: UnionMember1) = Target(unionMember1 = unionMember1)
        }

        /** An interface that defines how to map each variant of [Target] to a value of type [T]. */
        interface Visitor<out T> {

            /** X URL, numeric Tweet ID, @username, kind:value target, or search. */
            fun visitString(string: String): T

            fun visitUnionMember1(unionMember1: UnionMember1): T

            /**
             * Maps an unknown variant of [Target] to a value of type [T].
             *
             * An instance of [Target] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws XTwitterScraperInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw XTwitterScraperInvalidDataException("Unknown Target: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Target>(Target::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Target {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<UnionMember1>())?.let {
                                Target(unionMember1 = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Target(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Target(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Target>(Target::class) {

            override fun serialize(
                value: Target,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.unionMember1 != null -> generator.writeObject(value.unionMember1)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Target")
                }
            }
        }

        class UnionMember1
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val kind: JsonField<Kind>,
            private val value: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("kind") @ExcludeMissing kind: JsonField<Kind> = JsonMissing.of(),
                @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
            ) : this(kind, value, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun kind(): Kind = kind.getRequired("kind")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun value(): String = value.getRequired("value")

            /**
             * Returns the raw JSON value of [kind].
             *
             * Unlike [kind], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("kind") @ExcludeMissing fun _kind(): JsonField<Kind> = kind

            /**
             * Returns the raw JSON value of [value].
             *
             * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [UnionMember1].
                 *
                 * The following fields are required:
                 * ```java
                 * .kind()
                 * .value()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [UnionMember1]. */
            class Builder internal constructor() {

                private var kind: JsonField<Kind>? = null
                private var value: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(unionMember1: UnionMember1) = apply {
                    kind = unionMember1.kind
                    value = unionMember1.value
                    additionalProperties = unionMember1.additionalProperties.toMutableMap()
                }

                fun kind(kind: Kind) = kind(JsonField.of(kind))

                /**
                 * Sets [Builder.kind] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.kind] with a well-typed [Kind] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun kind(kind: JsonField<Kind>) = apply { this.kind = kind }

                fun value(value: String) = value(JsonField.of(value))

                /**
                 * Sets [Builder.value] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.value] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun value(value: JsonField<String>) = apply { this.value = value }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [UnionMember1].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .kind()
                 * .value()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): UnionMember1 =
                    UnionMember1(
                        checkRequired("kind", kind),
                        checkRequired("value", value),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): UnionMember1 = apply {
                if (validated) {
                    return@apply
                }

                kind().validate()
                value()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (kind.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (value.asKnown().isPresent) 1 else 0)

            class Kind @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val FAVORITERS = of("favoriters")

                    @JvmField val LIST = of("list")

                    @JvmField val PROFILE = of("profile")

                    @JvmField val PROFILE_LIKES = of("profile_likes")

                    @JvmField val PROFILE_MEDIA = of("profile_media")

                    @JvmField val PROFILE_REPLIES = of("profile_replies")

                    @JvmField val QUOTES = of("quotes")

                    @JvmField val REPLIES = of("replies")

                    @JvmField val RETWEETERS = of("retweeters")

                    @JvmField val SEARCH = of("search")

                    @JvmField val THREAD = of("thread")

                    @JvmField val TWEET = of("tweet")

                    @JvmStatic fun of(value: String) = Kind(JsonField.of(value))
                }

                /** An enum containing [Kind]'s known values. */
                enum class Known {
                    FAVORITERS,
                    LIST,
                    PROFILE,
                    PROFILE_LIKES,
                    PROFILE_MEDIA,
                    PROFILE_REPLIES,
                    QUOTES,
                    REPLIES,
                    RETWEETERS,
                    SEARCH,
                    THREAD,
                    TWEET,
                }

                /**
                 * An enum containing [Kind]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Kind] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    FAVORITERS,
                    LIST,
                    PROFILE,
                    PROFILE_LIKES,
                    PROFILE_MEDIA,
                    PROFILE_REPLIES,
                    QUOTES,
                    REPLIES,
                    RETWEETERS,
                    SEARCH,
                    THREAD,
                    TWEET,
                    /**
                     * An enum member indicating that [Kind] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        FAVORITERS -> Value.FAVORITERS
                        LIST -> Value.LIST
                        PROFILE -> Value.PROFILE
                        PROFILE_LIKES -> Value.PROFILE_LIKES
                        PROFILE_MEDIA -> Value.PROFILE_MEDIA
                        PROFILE_REPLIES -> Value.PROFILE_REPLIES
                        QUOTES -> Value.QUOTES
                        REPLIES -> Value.REPLIES
                        RETWEETERS -> Value.RETWEETERS
                        SEARCH -> Value.SEARCH
                        THREAD -> Value.THREAD
                        TWEET -> Value.TWEET
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        FAVORITERS -> Known.FAVORITERS
                        LIST -> Known.LIST
                        PROFILE -> Known.PROFILE
                        PROFILE_LIKES -> Known.PROFILE_LIKES
                        PROFILE_MEDIA -> Known.PROFILE_MEDIA
                        PROFILE_REPLIES -> Known.PROFILE_REPLIES
                        QUOTES -> Known.QUOTES
                        REPLIES -> Known.REPLIES
                        RETWEETERS -> Known.RETWEETERS
                        SEARCH -> Known.SEARCH
                        THREAD -> Known.THREAD
                        TWEET -> Known.TWEET
                        else -> throw XTwitterScraperInvalidDataException("Unknown Kind: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        XTwitterScraperInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Kind = apply {
                    if (validated) {
                        return@apply
                    }

                    known()
                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: XTwitterScraperInvalidDataException) {
                        false
                    }

                /**
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Kind && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is UnionMember1 &&
                    kind == other.kind &&
                    value == other.value &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(kind, value, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "UnionMember1{kind=$kind, value=$value, additionalProperties=$additionalProperties}"
        }
    }

    /** Reply end time as ISO 8601 or Unix seconds. */
    @JsonDeserialize(using = UntilTime.Deserializer::class)
    @JsonSerialize(using = UntilTime.Serializer::class)
    class UntilTime
    private constructor(
        private val offsetDate: OffsetDateTime? = null,
        private val integer: Long? = null,
        private val _json: JsonValue? = null,
    ) {

        fun offsetDate(): Optional<OffsetDateTime> = Optional.ofNullable(offsetDate)

        fun integer(): Optional<Long> = Optional.ofNullable(integer)

        fun isOffsetDate(): Boolean = offsetDate != null

        fun isInteger(): Boolean = integer != null

        fun asOffsetDate(): OffsetDateTime = offsetDate.getOrThrow("offsetDate")

        fun asInteger(): Long = integer.getOrThrow("integer")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.x_twitter_scraper.api.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = untilTime.accept(new UntilTime.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitOffsetDate(OffsetDateTime offsetDate) {
         *         return Optional.of(offsetDate.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws XTwitterScraperInvalidDataException if [Visitor.unknown] is not overridden in
         *   [visitor] and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                offsetDate != null -> visitor.visitOffsetDate(offsetDate)
                integer != null -> visitor.visitInteger(integer)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): UntilTime = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitOffsetDate(offsetDate: OffsetDateTime) {}

                    override fun visitInteger(integer: Long) {}
                }
            )
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitOffsetDate(offsetDate: OffsetDateTime) = 1

                    override fun visitInteger(integer: Long) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UntilTime && offsetDate == other.offsetDate && integer == other.integer
        }

        override fun hashCode(): Int = Objects.hash(offsetDate, integer)

        override fun toString(): String =
            when {
                offsetDate != null -> "UntilTime{offsetDate=$offsetDate}"
                integer != null -> "UntilTime{integer=$integer}"
                _json != null -> "UntilTime{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid UntilTime")
            }

        companion object {

            @JvmStatic
            fun ofOffsetDate(offsetDate: OffsetDateTime) = UntilTime(offsetDate = offsetDate)

            @JvmStatic fun ofInteger(integer: Long) = UntilTime(integer = integer)
        }

        /**
         * An interface that defines how to map each variant of [UntilTime] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitOffsetDate(offsetDate: OffsetDateTime): T

            fun visitInteger(integer: Long): T

            /**
             * Maps an unknown variant of [UntilTime] to a value of type [T].
             *
             * An instance of [UntilTime] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws XTwitterScraperInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw XTwitterScraperInvalidDataException("Unknown UntilTime: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<UntilTime>(UntilTime::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): UntilTime {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<OffsetDateTime>())?.let {
                                UntilTime(offsetDate = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                UntilTime(integer = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> UntilTime(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<UntilTime>(UntilTime::class) {

            override fun serialize(
                value: UntilTime,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.offsetDate != null -> generator.writeObject(value.offsetDate)
                    value.integer != null -> generator.writeObject(value.integer)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid UntilTime")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExtractionEstimateCostParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ExtractionEstimateCostParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
