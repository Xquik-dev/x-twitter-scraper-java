// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.analysis

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Answers 1 to 8 questions you write in analysis.questions. A choice picks a category, such as a
 * topic. A score picks a level. A probability answers yes or no. Without questions it answers the
 * sentiment questions. Each analyzed post costs 2 credits.
 */
class AnalysisClassifyParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Analysis settings, the same as the analysis input of Xquik's AI Actors. Leave it out for the
     * route's own questions.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun analysis(): Optional<Analysis> = body.analysis()

    /**
     * Rows of an earlier answer to compare with, such as its results. Each needs the post's id, or
     * tweet.id, & its answers. Send monitor too, so other settings show as not_comparable. Each
     * result's monitor says whether the post is new, changed or unchanged. The comparison costs
     * nothing extra.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun baseline(): Optional<List<Baseline>> = body.baseline()

    /**
     * The next_cursor of the page before. Send the same search with it.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun cursor(): Optional<String> = body.cursor()

    /**
     * Maximum posts to analyze from the search. A low credit balance can return fewer.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun limit(): Optional<Long> = body.limit()

    /**
     * Analyze a public List's posts. Send its ID or URL.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun listId(): Optional<String> = body.listId()

    /**
     * X search to analyze, with the operators of /x/tweets/search, such as from:nasa or lang:en. X
     * searches up to 512 characters, counted with the other search fields, as /x/tweets/search
     * counts q.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun query(): Optional<String> = body.query()

    /**
     * Search order. Default Latest.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun queryType(): Optional<QueryType> = body.queryType()

    /**
     * Analyze the quotes of 1 post. Send its ID or URL.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun quotesOf(): Optional<String> = body.quotesOf()

    /**
     * Analyze the replies in 1 post's conversation. Send its ID or URL.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun repliesTo(): Optional<String> = body.repliesTo()

    /**
     * Inclusive start of the search, such as 2026-09-25T00:00:00Z. Unix seconds also work. A time
     * without an offset is UTC.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun sinceTime(): Optional<SinceTime> = body.sinceTime()

    /**
     * Your own texts to analyze, such as drafts. Reads nothing from X. Each text costs the same as
     * 1 analyzed post.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun texts(): Optional<List<String>> = body.texts()

    /**
     * Post IDs or post URLs to analyze, up to 100.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun tweetIds(): Optional<List<String>> = body.tweetIds()

    /**
     * Exclusive end of the search, such as 2026-09-26T00:00:00Z. Unix seconds also work. A time
     * without an offset is UTC.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun untilTime(): Optional<UntilTime> = body.untilTime()

    /**
     * Analyze 1 account's posts. Send a handle, with or without @, or a profile URL.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun username(): Optional<String> = body.username()

    /**
     * Returns the raw JSON value of [analysis].
     *
     * Unlike [analysis], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _analysis(): JsonField<Analysis> = body._analysis()

    /**
     * Returns the raw JSON value of [baseline].
     *
     * Unlike [baseline], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _baseline(): JsonField<List<Baseline>> = body._baseline()

    /**
     * Returns the raw JSON value of [cursor].
     *
     * Unlike [cursor], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _cursor(): JsonField<String> = body._cursor()

    /**
     * Returns the raw JSON value of [limit].
     *
     * Unlike [limit], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _limit(): JsonField<Long> = body._limit()

    /**
     * Returns the raw JSON value of [listId].
     *
     * Unlike [listId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _listId(): JsonField<String> = body._listId()

    /**
     * Returns the raw JSON value of [query].
     *
     * Unlike [query], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _query(): JsonField<String> = body._query()

    /**
     * Returns the raw JSON value of [queryType].
     *
     * Unlike [queryType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _queryType(): JsonField<QueryType> = body._queryType()

    /**
     * Returns the raw JSON value of [quotesOf].
     *
     * Unlike [quotesOf], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _quotesOf(): JsonField<String> = body._quotesOf()

    /**
     * Returns the raw JSON value of [repliesTo].
     *
     * Unlike [repliesTo], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _repliesTo(): JsonField<String> = body._repliesTo()

    /**
     * Returns the raw JSON value of [sinceTime].
     *
     * Unlike [sinceTime], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sinceTime(): JsonField<SinceTime> = body._sinceTime()

    /**
     * Returns the raw JSON value of [texts].
     *
     * Unlike [texts], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _texts(): JsonField<List<String>> = body._texts()

    /**
     * Returns the raw JSON value of [tweetIds].
     *
     * Unlike [tweetIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tweetIds(): JsonField<List<String>> = body._tweetIds()

    /**
     * Returns the raw JSON value of [untilTime].
     *
     * Unlike [untilTime], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _untilTime(): JsonField<UntilTime> = body._untilTime()

    /**
     * Returns the raw JSON value of [username].
     *
     * Unlike [username], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _username(): JsonField<String> = body._username()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): AnalysisClassifyParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [AnalysisClassifyParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AnalysisClassifyParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(analysisClassifyParams: AnalysisClassifyParams) = apply {
            body = analysisClassifyParams.body.toBuilder()
            additionalHeaders = analysisClassifyParams.additionalHeaders.toBuilder()
            additionalQueryParams = analysisClassifyParams.additionalQueryParams.toBuilder()
        }

        /** Sets the entire request body. */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Analysis settings, the same as the analysis input of Xquik's AI Actors. Leave it out for
         * the route's own questions.
         */
        fun analysis(analysis: Analysis) = apply { body.analysis(analysis) }

        /** Sets [Builder.analysis] to an arbitrary JSON value. */
        fun analysis(analysis: JsonField<Analysis>) = apply { body.analysis(analysis) }

        /**
         * Rows of an earlier answer to compare with, such as its results. Each needs the post's id,
         * or tweet.id, & its answers. Send monitor too, so other settings show as not_comparable.
         * Each result's monitor says whether the post is new, changed or unchanged. The comparison
         * costs nothing extra.
         */
        fun baseline(baseline: List<Baseline>) = apply { body.baseline(baseline) }

        /** Sets [Builder.baseline] to an arbitrary JSON value. */
        fun baseline(baseline: JsonField<List<Baseline>>) = apply { body.baseline(baseline) }

        /**
         * Adds a single [Baseline] to [baseline].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addBaseline(baseline: Baseline) = apply { body.addBaseline(baseline) }

        /** The next_cursor of the page before. Send the same search with it. */
        fun cursor(cursor: String) = apply { body.cursor(cursor) }

        /** Sets [Builder.cursor] to an arbitrary JSON value. */
        fun cursor(cursor: JsonField<String>) = apply { body.cursor(cursor) }

        /** Maximum posts to analyze from the search. A low credit balance can return fewer. */
        fun limit(limit: Long) = apply { body.limit(limit) }

        /** Sets [Builder.limit] to an arbitrary JSON value. */
        fun limit(limit: JsonField<Long>) = apply { body.limit(limit) }

        /** Analyze a public List's posts. Send its ID or URL. */
        fun listId(listId: String) = apply { body.listId(listId) }

        /** Sets [Builder.listId] to an arbitrary JSON value. */
        fun listId(listId: JsonField<String>) = apply { body.listId(listId) }

        /**
         * X search to analyze, with the operators of /x/tweets/search, such as from:nasa or
         * lang:en. X searches up to 512 characters, counted with the other search fields, as
         * /x/tweets/search counts q.
         */
        fun query(query: String) = apply { body.query(query) }

        /** Sets [Builder.query] to an arbitrary JSON value. */
        fun query(query: JsonField<String>) = apply { body.query(query) }

        /** Search order. Default Latest. */
        fun queryType(queryType: QueryType) = apply { body.queryType(queryType) }

        /** Sets [Builder.queryType] to an arbitrary JSON value. */
        fun queryType(queryType: JsonField<QueryType>) = apply { body.queryType(queryType) }

        /** Analyze the quotes of 1 post. Send its ID or URL. */
        fun quotesOf(quotesOf: String) = apply { body.quotesOf(quotesOf) }

        /** Sets [Builder.quotesOf] to an arbitrary JSON value. */
        fun quotesOf(quotesOf: JsonField<String>) = apply { body.quotesOf(quotesOf) }

        /** Analyze the replies in 1 post's conversation. Send its ID or URL. */
        fun repliesTo(repliesTo: String) = apply { body.repliesTo(repliesTo) }

        /** Sets [Builder.repliesTo] to an arbitrary JSON value. */
        fun repliesTo(repliesTo: JsonField<String>) = apply { body.repliesTo(repliesTo) }

        /**
         * Inclusive start of the search, such as 2026-09-25T00:00:00Z. Unix seconds also work. A
         * time without an offset is UTC.
         */
        fun sinceTime(sinceTime: SinceTime) = apply { body.sinceTime(sinceTime) }

        /** Sets [Builder.sinceTime] to an arbitrary JSON value. */
        fun sinceTime(sinceTime: JsonField<SinceTime>) = apply { body.sinceTime(sinceTime) }

        /** Alias for calling [sinceTime] with `SinceTime.ofString(string)`. */
        fun sinceTime(string: String) = apply { body.sinceTime(string) }

        /** Alias for calling [sinceTime] with `SinceTime.ofInteger(integer)`. */
        fun sinceTime(integer: Long) = apply { body.sinceTime(integer) }

        /**
         * Your own texts to analyze, such as drafts. Reads nothing from X. Each text costs the same
         * as 1 analyzed post.
         */
        fun texts(texts: List<String>) = apply { body.texts(texts) }

        /** Sets [Builder.texts] to an arbitrary JSON value. */
        fun texts(texts: JsonField<List<String>>) = apply { body.texts(texts) }

        /**
         * Adds a single [String] to [texts].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addText(text: String) = apply { body.addText(text) }

        /** Post IDs or post URLs to analyze, up to 100. */
        fun tweetIds(tweetIds: List<String>) = apply { body.tweetIds(tweetIds) }

        /** Sets [Builder.tweetIds] to an arbitrary JSON value. */
        fun tweetIds(tweetIds: JsonField<List<String>>) = apply { body.tweetIds(tweetIds) }

        /**
         * Adds a single [String] to [tweetIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTweetId(tweetId: String) = apply { body.addTweetId(tweetId) }

        /**
         * Exclusive end of the search, such as 2026-09-26T00:00:00Z. Unix seconds also work. A time
         * without an offset is UTC.
         */
        fun untilTime(untilTime: UntilTime) = apply { body.untilTime(untilTime) }

        /** Sets [Builder.untilTime] to an arbitrary JSON value. */
        fun untilTime(untilTime: JsonField<UntilTime>) = apply { body.untilTime(untilTime) }

        /** Alias for calling [untilTime] with `UntilTime.ofString(string)`. */
        fun untilTime(string: String) = apply { body.untilTime(string) }

        /** Alias for calling [untilTime] with `UntilTime.ofInteger(integer)`. */
        fun untilTime(integer: Long) = apply { body.untilTime(integer) }

        /** Analyze 1 account's posts. Send a handle, with or without @, or a profile URL. */
        fun username(username: String) = apply { body.username(username) }

        /** Sets [Builder.username] to an arbitrary JSON value. */
        fun username(username: JsonField<String>) = apply { body.username(username) }

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
         * Returns an immutable instance of [AnalysisClassifyParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): AnalysisClassifyParams =
            AnalysisClassifyParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /**
     * Posts to analyze & optional analysis settings. Send tweetIds, texts, or a search, never more
     * than 1. A search is query, username, listId, quotesOf or repliesTo, alone or together, &
     * sinceTime & untilTime narrow it.
     */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val analysis: JsonField<Analysis>,
        private val baseline: JsonField<List<Baseline>>,
        private val cursor: JsonField<String>,
        private val limit: JsonField<Long>,
        private val listId: JsonField<String>,
        private val query: JsonField<String>,
        private val queryType: JsonField<QueryType>,
        private val quotesOf: JsonField<String>,
        private val repliesTo: JsonField<String>,
        private val sinceTime: JsonField<SinceTime>,
        private val texts: JsonField<List<String>>,
        private val tweetIds: JsonField<List<String>>,
        private val untilTime: JsonField<UntilTime>,
        private val username: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("analysis")
            @ExcludeMissing
            analysis: JsonField<Analysis> = JsonMissing.of(),
            @JsonProperty("baseline")
            @ExcludeMissing
            baseline: JsonField<List<Baseline>> = JsonMissing.of(),
            @JsonProperty("cursor") @ExcludeMissing cursor: JsonField<String> = JsonMissing.of(),
            @JsonProperty("limit") @ExcludeMissing limit: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("listId") @ExcludeMissing listId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("query") @ExcludeMissing query: JsonField<String> = JsonMissing.of(),
            @JsonProperty("queryType")
            @ExcludeMissing
            queryType: JsonField<QueryType> = JsonMissing.of(),
            @JsonProperty("quotesOf")
            @ExcludeMissing
            quotesOf: JsonField<String> = JsonMissing.of(),
            @JsonProperty("repliesTo")
            @ExcludeMissing
            repliesTo: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sinceTime")
            @ExcludeMissing
            sinceTime: JsonField<SinceTime> = JsonMissing.of(),
            @JsonProperty("texts")
            @ExcludeMissing
            texts: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("tweetIds")
            @ExcludeMissing
            tweetIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("untilTime")
            @ExcludeMissing
            untilTime: JsonField<UntilTime> = JsonMissing.of(),
            @JsonProperty("username")
            @ExcludeMissing
            username: JsonField<String> = JsonMissing.of(),
        ) : this(
            analysis,
            baseline,
            cursor,
            limit,
            listId,
            query,
            queryType,
            quotesOf,
            repliesTo,
            sinceTime,
            texts,
            tweetIds,
            untilTime,
            username,
            mutableMapOf(),
        )

        /**
         * Analysis settings, the same as the analysis input of Xquik's AI Actors. Leave it out for
         * the route's own questions.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun analysis(): Optional<Analysis> = analysis.getOptional("analysis")

        /**
         * Rows of an earlier answer to compare with, such as its results. Each needs the post's id,
         * or tweet.id, & its answers. Send monitor too, so other settings show as not_comparable.
         * Each result's monitor says whether the post is new, changed or unchanged. The comparison
         * costs nothing extra.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun baseline(): Optional<List<Baseline>> = baseline.getOptional("baseline")

        /**
         * The next_cursor of the page before. Send the same search with it.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun cursor(): Optional<String> = cursor.getOptional("cursor")

        /**
         * Maximum posts to analyze from the search. A low credit balance can return fewer.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun limit(): Optional<Long> = limit.getOptional("limit")

        /**
         * Analyze a public List's posts. Send its ID or URL.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun listId(): Optional<String> = listId.getOptional("listId")

        /**
         * X search to analyze, with the operators of /x/tweets/search, such as from:nasa or
         * lang:en. X searches up to 512 characters, counted with the other search fields, as
         * /x/tweets/search counts q.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun query(): Optional<String> = query.getOptional("query")

        /**
         * Search order. Default Latest.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun queryType(): Optional<QueryType> = queryType.getOptional("queryType")

        /**
         * Analyze the quotes of 1 post. Send its ID or URL.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun quotesOf(): Optional<String> = quotesOf.getOptional("quotesOf")

        /**
         * Analyze the replies in 1 post's conversation. Send its ID or URL.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun repliesTo(): Optional<String> = repliesTo.getOptional("repliesTo")

        /**
         * Inclusive start of the search, such as 2026-09-25T00:00:00Z. Unix seconds also work. A
         * time without an offset is UTC.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun sinceTime(): Optional<SinceTime> = sinceTime.getOptional("sinceTime")

        /**
         * Your own texts to analyze, such as drafts. Reads nothing from X. Each text costs the same
         * as 1 analyzed post.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun texts(): Optional<List<String>> = texts.getOptional("texts")

        /**
         * Post IDs or post URLs to analyze, up to 100.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun tweetIds(): Optional<List<String>> = tweetIds.getOptional("tweetIds")

        /**
         * Exclusive end of the search, such as 2026-09-26T00:00:00Z. Unix seconds also work. A time
         * without an offset is UTC.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun untilTime(): Optional<UntilTime> = untilTime.getOptional("untilTime")

        /**
         * Analyze 1 account's posts. Send a handle, with or without @, or a profile URL.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun username(): Optional<String> = username.getOptional("username")

        /**
         * Returns the raw JSON value of [analysis].
         *
         * Unlike [analysis], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("analysis") @ExcludeMissing fun _analysis(): JsonField<Analysis> = analysis

        /**
         * Returns the raw JSON value of [baseline].
         *
         * Unlike [baseline], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("baseline")
        @ExcludeMissing
        fun _baseline(): JsonField<List<Baseline>> = baseline

        /**
         * Returns the raw JSON value of [cursor].
         *
         * Unlike [cursor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cursor") @ExcludeMissing fun _cursor(): JsonField<String> = cursor

        /**
         * Returns the raw JSON value of [limit].
         *
         * Unlike [limit], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("limit") @ExcludeMissing fun _limit(): JsonField<Long> = limit

        /**
         * Returns the raw JSON value of [listId].
         *
         * Unlike [listId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("listId") @ExcludeMissing fun _listId(): JsonField<String> = listId

        /**
         * Returns the raw JSON value of [query].
         *
         * Unlike [query], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<String> = query

        /**
         * Returns the raw JSON value of [queryType].
         *
         * Unlike [queryType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("queryType")
        @ExcludeMissing
        fun _queryType(): JsonField<QueryType> = queryType

        /**
         * Returns the raw JSON value of [quotesOf].
         *
         * Unlike [quotesOf], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("quotesOf") @ExcludeMissing fun _quotesOf(): JsonField<String> = quotesOf

        /**
         * Returns the raw JSON value of [repliesTo].
         *
         * Unlike [repliesTo], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("repliesTo") @ExcludeMissing fun _repliesTo(): JsonField<String> = repliesTo

        /**
         * Returns the raw JSON value of [sinceTime].
         *
         * Unlike [sinceTime], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sinceTime")
        @ExcludeMissing
        fun _sinceTime(): JsonField<SinceTime> = sinceTime

        /**
         * Returns the raw JSON value of [texts].
         *
         * Unlike [texts], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("texts") @ExcludeMissing fun _texts(): JsonField<List<String>> = texts

        /**
         * Returns the raw JSON value of [tweetIds].
         *
         * Unlike [tweetIds], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweetIds")
        @ExcludeMissing
        fun _tweetIds(): JsonField<List<String>> = tweetIds

        /**
         * Returns the raw JSON value of [untilTime].
         *
         * Unlike [untilTime], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("untilTime")
        @ExcludeMissing
        fun _untilTime(): JsonField<UntilTime> = untilTime

        /**
         * Returns the raw JSON value of [username].
         *
         * Unlike [username], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var analysis: JsonField<Analysis> = JsonMissing.of()
            private var baseline: JsonField<MutableList<Baseline>>? = null
            private var cursor: JsonField<String> = JsonMissing.of()
            private var limit: JsonField<Long> = JsonMissing.of()
            private var listId: JsonField<String> = JsonMissing.of()
            private var query: JsonField<String> = JsonMissing.of()
            private var queryType: JsonField<QueryType> = JsonMissing.of()
            private var quotesOf: JsonField<String> = JsonMissing.of()
            private var repliesTo: JsonField<String> = JsonMissing.of()
            private var sinceTime: JsonField<SinceTime> = JsonMissing.of()
            private var texts: JsonField<MutableList<String>>? = null
            private var tweetIds: JsonField<MutableList<String>>? = null
            private var untilTime: JsonField<UntilTime> = JsonMissing.of()
            private var username: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                analysis = body.analysis
                baseline = body.baseline.map { it.toMutableList() }
                cursor = body.cursor
                limit = body.limit
                listId = body.listId
                query = body.query
                queryType = body.queryType
                quotesOf = body.quotesOf
                repliesTo = body.repliesTo
                sinceTime = body.sinceTime
                texts = body.texts.map { it.toMutableList() }
                tweetIds = body.tweetIds.map { it.toMutableList() }
                untilTime = body.untilTime
                username = body.username
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Analysis settings, the same as the analysis input of Xquik's AI Actors. Leave it out
             * for the route's own questions.
             */
            fun analysis(analysis: Analysis) = analysis(JsonField.of(analysis))

            /** Sets [Builder.analysis] to an arbitrary JSON value. */
            fun analysis(analysis: JsonField<Analysis>) = apply { this.analysis = analysis }

            /**
             * Rows of an earlier answer to compare with, such as its results. Each needs the post's
             * id, or tweet.id, & its answers. Send monitor too, so other settings show as
             * not_comparable. Each result's monitor says whether the post is new, changed or
             * unchanged. The comparison costs nothing extra.
             */
            fun baseline(baseline: List<Baseline>) = baseline(JsonField.of(baseline))

            /** Sets [Builder.baseline] to an arbitrary JSON value. */
            fun baseline(baseline: JsonField<List<Baseline>>) = apply {
                this.baseline = baseline.map { it.toMutableList() }
            }

            /**
             * Adds a single [Baseline] to [baseline].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addBaseline(baseline: Baseline) = apply {
                this.baseline =
                    (this.baseline ?: JsonField.of(mutableListOf())).also {
                        checkKnown("baseline", it).add(baseline)
                    }
            }

            /** The next_cursor of the page before. Send the same search with it. */
            fun cursor(cursor: String) = cursor(JsonField.of(cursor))

            /** Sets [Builder.cursor] to an arbitrary JSON value. */
            fun cursor(cursor: JsonField<String>) = apply { this.cursor = cursor }

            /** Maximum posts to analyze from the search. A low credit balance can return fewer. */
            fun limit(limit: Long) = limit(JsonField.of(limit))

            /** Sets [Builder.limit] to an arbitrary JSON value. */
            fun limit(limit: JsonField<Long>) = apply { this.limit = limit }

            /** Analyze a public List's posts. Send its ID or URL. */
            fun listId(listId: String) = listId(JsonField.of(listId))

            /** Sets [Builder.listId] to an arbitrary JSON value. */
            fun listId(listId: JsonField<String>) = apply { this.listId = listId }

            /**
             * X search to analyze, with the operators of /x/tweets/search, such as from:nasa or
             * lang:en. X searches up to 512 characters, counted with the other search fields, as
             * /x/tweets/search counts q.
             */
            fun query(query: String) = query(JsonField.of(query))

            /** Sets [Builder.query] to an arbitrary JSON value. */
            fun query(query: JsonField<String>) = apply { this.query = query }

            /** Search order. Default Latest. */
            fun queryType(queryType: QueryType) = queryType(JsonField.of(queryType))

            /** Sets [Builder.queryType] to an arbitrary JSON value. */
            fun queryType(queryType: JsonField<QueryType>) = apply { this.queryType = queryType }

            /** Analyze the quotes of 1 post. Send its ID or URL. */
            fun quotesOf(quotesOf: String) = quotesOf(JsonField.of(quotesOf))

            /** Sets [Builder.quotesOf] to an arbitrary JSON value. */
            fun quotesOf(quotesOf: JsonField<String>) = apply { this.quotesOf = quotesOf }

            /** Analyze the replies in 1 post's conversation. Send its ID or URL. */
            fun repliesTo(repliesTo: String) = repliesTo(JsonField.of(repliesTo))

            /** Sets [Builder.repliesTo] to an arbitrary JSON value. */
            fun repliesTo(repliesTo: JsonField<String>) = apply { this.repliesTo = repliesTo }

            /**
             * Inclusive start of the search, such as 2026-09-25T00:00:00Z. Unix seconds also work.
             * A time without an offset is UTC.
             */
            fun sinceTime(sinceTime: SinceTime) = sinceTime(JsonField.of(sinceTime))

            /** Sets [Builder.sinceTime] to an arbitrary JSON value. */
            fun sinceTime(sinceTime: JsonField<SinceTime>) = apply { this.sinceTime = sinceTime }

            /** Alias for calling [sinceTime] with `SinceTime.ofString(string)`. */
            fun sinceTime(string: String) = sinceTime(SinceTime.ofString(string))

            /** Alias for calling [sinceTime] with `SinceTime.ofInteger(integer)`. */
            fun sinceTime(integer: Long) = sinceTime(SinceTime.ofInteger(integer))

            /**
             * Your own texts to analyze, such as drafts. Reads nothing from X. Each text costs the
             * same as 1 analyzed post.
             */
            fun texts(texts: List<String>) = texts(JsonField.of(texts))

            /** Sets [Builder.texts] to an arbitrary JSON value. */
            fun texts(texts: JsonField<List<String>>) = apply {
                this.texts = texts.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [texts].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addText(text: String) = apply {
                texts =
                    (texts ?: JsonField.of(mutableListOf())).also {
                        checkKnown("texts", it).add(text)
                    }
            }

            /** Post IDs or post URLs to analyze, up to 100. */
            fun tweetIds(tweetIds: List<String>) = tweetIds(JsonField.of(tweetIds))

            /** Sets [Builder.tweetIds] to an arbitrary JSON value. */
            fun tweetIds(tweetIds: JsonField<List<String>>) = apply {
                this.tweetIds = tweetIds.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [tweetIds].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTweetId(tweetId: String) = apply {
                tweetIds =
                    (tweetIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tweetIds", it).add(tweetId)
                    }
            }

            /**
             * Exclusive end of the search, such as 2026-09-26T00:00:00Z. Unix seconds also work. A
             * time without an offset is UTC.
             */
            fun untilTime(untilTime: UntilTime) = untilTime(JsonField.of(untilTime))

            /** Sets [Builder.untilTime] to an arbitrary JSON value. */
            fun untilTime(untilTime: JsonField<UntilTime>) = apply { this.untilTime = untilTime }

            /** Alias for calling [untilTime] with `UntilTime.ofString(string)`. */
            fun untilTime(string: String) = untilTime(UntilTime.ofString(string))

            /** Alias for calling [untilTime] with `UntilTime.ofInteger(integer)`. */
            fun untilTime(integer: Long) = untilTime(UntilTime.ofInteger(integer))

            /** Analyze 1 account's posts. Send a handle, with or without @, or a profile URL. */
            fun username(username: String) = username(JsonField.of(username))

            /** Sets [Builder.username] to an arbitrary JSON value. */
            fun username(username: JsonField<String>) = apply { this.username = username }

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
             */
            fun build(): Body =
                Body(
                    analysis,
                    (baseline ?: JsonMissing.of()).map { it.toImmutable() },
                    cursor,
                    limit,
                    listId,
                    query,
                    queryType,
                    quotesOf,
                    repliesTo,
                    sinceTime,
                    (texts ?: JsonMissing.of()).map { it.toImmutable() },
                    (tweetIds ?: JsonMissing.of()).map { it.toImmutable() },
                    untilTime,
                    username,
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

            analysis().ifPresent { it.validate() }
            baseline().ifPresent { it.forEach { it.validate() } }
            cursor()
            limit()
            listId()
            query()
            queryType().ifPresent { it.validate() }
            quotesOf()
            repliesTo()
            sinceTime().ifPresent { it.validate() }
            texts()
            tweetIds()
            untilTime().ifPresent { it.validate() }
            username()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        @JvmSynthetic
        internal fun validity(): Int =
            (analysis.asKnown().getOrNull()?.validity() ?: 0) +
                (baseline.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (cursor.asKnown().isPresent) 1 else 0) +
                (if (limit.asKnown().isPresent) 1 else 0) +
                (if (listId.asKnown().isPresent) 1 else 0) +
                (if (query.asKnown().isPresent) 1 else 0) +
                (queryType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (quotesOf.asKnown().isPresent) 1 else 0) +
                (if (repliesTo.asKnown().isPresent) 1 else 0) +
                (sinceTime.asKnown().getOrNull()?.validity() ?: 0) +
                (texts.asKnown().getOrNull()?.size ?: 0) +
                (tweetIds.asKnown().getOrNull()?.size ?: 0) +
                (untilTime.asKnown().getOrNull()?.validity() ?: 0) +
                (if (username.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                analysis == other.analysis &&
                baseline == other.baseline &&
                cursor == other.cursor &&
                limit == other.limit &&
                listId == other.listId &&
                query == other.query &&
                queryType == other.queryType &&
                quotesOf == other.quotesOf &&
                repliesTo == other.repliesTo &&
                sinceTime == other.sinceTime &&
                texts == other.texts &&
                tweetIds == other.tweetIds &&
                untilTime == other.untilTime &&
                username == other.username &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                analysis,
                baseline,
                cursor,
                limit,
                listId,
                query,
                queryType,
                quotesOf,
                repliesTo,
                sinceTime,
                texts,
                tweetIds,
                untilTime,
                username,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{analysis=$analysis, baseline=$baseline, cursor=$cursor, limit=$limit, listId=$listId, query=$query, queryType=$queryType, quotesOf=$quotesOf, repliesTo=$repliesTo, sinceTime=$sinceTime, texts=$texts, tweetIds=$tweetIds, untilTime=$untilTime, username=$username, additionalProperties=$additionalProperties}"
    }

    /**
     * Analysis settings, the same as the analysis input of Xquik's AI Actors. Leave it out for the
     * route's own questions.
     */
    class Analysis
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val concurrency: JsonField<Long>,
        private val context: JsonField<String>,
        private val maxContextBytes: JsonField<Long>,
        private val preset: JsonField<Preset>,
        private val questions: JsonField<List<Question>>,
        private val targets: JsonField<List<Target>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("concurrency")
            @ExcludeMissing
            concurrency: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("context") @ExcludeMissing context: JsonField<String> = JsonMissing.of(),
            @JsonProperty("maxContextBytes")
            @ExcludeMissing
            maxContextBytes: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("preset") @ExcludeMissing preset: JsonField<Preset> = JsonMissing.of(),
            @JsonProperty("questions")
            @ExcludeMissing
            questions: JsonField<List<Question>> = JsonMissing.of(),
            @JsonProperty("targets")
            @ExcludeMissing
            targets: JsonField<List<Target>> = JsonMissing.of(),
        ) : this(concurrency, context, maxContextBytes, preset, questions, targets, mutableMapOf())

        /**
         * Posts analyzed at the same time.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun concurrency(): Optional<Long> = concurrency.getOptional("concurrency")

        /**
         * Background the AI reads with every post.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun context(): Optional<String> = context.getOptional("context")

        /**
         * Bytes of post, quote & settings the AI reads. Xquik cuts longer posts to fit. Empty
         * settings take 219 bytes, so a smaller value gets a 400.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun maxContextBytes(): Optional<Long> = maxContextBytes.getOptional("maxContextBytes")

        /**
         * A ready set of questions, used when questions is left out. complaints, competitors,
         * purchase_intent & product_feedback need targets. viral_lite scores how viral the wording
         * reads.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun preset(): Optional<Preset> = preset.getOptional("preset")

        /**
         * Your own questions, which replace the route's questions. Write question IDs & category
         * names in lower case without hyphens.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun questions(): Optional<List<Question>> = questions.getOptional("questions")

        /**
         * Brands, people, assets or topics the questions are about, each with its aliases.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun targets(): Optional<List<Target>> = targets.getOptional("targets")

        /**
         * Returns the raw JSON value of [concurrency].
         *
         * Unlike [concurrency], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("concurrency")
        @ExcludeMissing
        fun _concurrency(): JsonField<Long> = concurrency

        /**
         * Returns the raw JSON value of [context].
         *
         * Unlike [context], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("context") @ExcludeMissing fun _context(): JsonField<String> = context

        /**
         * Returns the raw JSON value of [maxContextBytes].
         *
         * Unlike [maxContextBytes], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("maxContextBytes")
        @ExcludeMissing
        fun _maxContextBytes(): JsonField<Long> = maxContextBytes

        /**
         * Returns the raw JSON value of [preset].
         *
         * Unlike [preset], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("preset") @ExcludeMissing fun _preset(): JsonField<Preset> = preset

        /**
         * Returns the raw JSON value of [questions].
         *
         * Unlike [questions], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("questions")
        @ExcludeMissing
        fun _questions(): JsonField<List<Question>> = questions

        /**
         * Returns the raw JSON value of [targets].
         *
         * Unlike [targets], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("targets") @ExcludeMissing fun _targets(): JsonField<List<Target>> = targets

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

            /** Returns a mutable builder for constructing an instance of [Analysis]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Analysis]. */
        class Builder internal constructor() {

            private var concurrency: JsonField<Long> = JsonMissing.of()
            private var context: JsonField<String> = JsonMissing.of()
            private var maxContextBytes: JsonField<Long> = JsonMissing.of()
            private var preset: JsonField<Preset> = JsonMissing.of()
            private var questions: JsonField<MutableList<Question>>? = null
            private var targets: JsonField<MutableList<Target>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(analysis: Analysis) = apply {
                concurrency = analysis.concurrency
                context = analysis.context
                maxContextBytes = analysis.maxContextBytes
                preset = analysis.preset
                questions = analysis.questions.map { it.toMutableList() }
                targets = analysis.targets.map { it.toMutableList() }
                additionalProperties = analysis.additionalProperties.toMutableMap()
            }

            /** Posts analyzed at the same time. */
            fun concurrency(concurrency: Long) = concurrency(JsonField.of(concurrency))

            /** Sets [Builder.concurrency] to an arbitrary JSON value. */
            fun concurrency(concurrency: JsonField<Long>) = apply { this.concurrency = concurrency }

            /** Background the AI reads with every post. */
            fun context(context: String) = context(JsonField.of(context))

            /** Sets [Builder.context] to an arbitrary JSON value. */
            fun context(context: JsonField<String>) = apply { this.context = context }

            /**
             * Bytes of post, quote & settings the AI reads. Xquik cuts longer posts to fit. Empty
             * settings take 219 bytes, so a smaller value gets a 400.
             */
            fun maxContextBytes(maxContextBytes: Long) =
                maxContextBytes(JsonField.of(maxContextBytes))

            /** Sets [Builder.maxContextBytes] to an arbitrary JSON value. */
            fun maxContextBytes(maxContextBytes: JsonField<Long>) = apply {
                this.maxContextBytes = maxContextBytes
            }

            /**
             * A ready set of questions, used when questions is left out. complaints, competitors,
             * purchase_intent & product_feedback need targets. viral_lite scores how viral the
             * wording reads.
             */
            fun preset(preset: Preset) = preset(JsonField.of(preset))

            /** Sets [Builder.preset] to an arbitrary JSON value. */
            fun preset(preset: JsonField<Preset>) = apply { this.preset = preset }

            /**
             * Your own questions, which replace the route's questions. Write question IDs &
             * category names in lower case without hyphens.
             */
            fun questions(questions: List<Question>) = questions(JsonField.of(questions))

            /** Sets [Builder.questions] to an arbitrary JSON value. */
            fun questions(questions: JsonField<List<Question>>) = apply {
                this.questions = questions.map { it.toMutableList() }
            }

            /**
             * Adds a single [Question] to [questions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addQuestion(question: Question) = apply {
                questions =
                    (questions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("questions", it).add(question)
                    }
            }

            /** Brands, people, assets or topics the questions are about, each with its aliases. */
            fun targets(targets: List<Target>) = targets(JsonField.of(targets))

            /** Sets [Builder.targets] to an arbitrary JSON value. */
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
             * Returns an immutable instance of [Analysis].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Analysis =
                Analysis(
                    concurrency,
                    context,
                    maxContextBytes,
                    preset,
                    (questions ?: JsonMissing.of()).map { it.toImmutable() },
                    (targets ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): Analysis = apply {
            if (validated) {
                return@apply
            }

            concurrency()
            context()
            maxContextBytes()
            preset().ifPresent { it.validate() }
            questions().ifPresent { it.forEach { it.validate() } }
            targets().ifPresent { it.forEach { it.validate() } }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        @JvmSynthetic
        internal fun validity(): Int =
            (if (concurrency.asKnown().isPresent) 1 else 0) +
                (if (context.asKnown().isPresent) 1 else 0) +
                (if (maxContextBytes.asKnown().isPresent) 1 else 0) +
                (preset.asKnown().getOrNull()?.validity() ?: 0) +
                (questions.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (targets.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

        /**
         * A ready set of questions, used when questions is left out. complaints, competitors,
         * purchase_intent & product_feedback need targets. viral_lite scores how viral the wording
         * reads.
         */
        class Preset @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val BRAND = of("brand")

                @JvmField val COMPLAINTS = of("complaints")

                @JvmField val COMPETITORS = of("competitors")

                @JvmField val PURCHASE_INTENT = of("purchase_intent")

                @JvmField val PRODUCT_FEEDBACK = of("product_feedback")

                @JvmField val NEWS = of("news")

                @JvmField val SENTIMENT = of("sentiment")

                @JvmField val MARKET = of("market")

                @JvmField val VIRAL_LITE = of("viral_lite")

                @JvmStatic fun of(value: String) = Preset(JsonField.of(value))
            }

            /** An enum containing [Preset]'s known values. */
            enum class Known {
                BRAND,
                COMPLAINTS,
                COMPETITORS,
                PURCHASE_INTENT,
                PRODUCT_FEEDBACK,
                NEWS,
                SENTIMENT,
                MARKET,
                VIRAL_LITE,
            }

            /**
             * An enum containing [Preset]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Preset] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                BRAND,
                COMPLAINTS,
                COMPETITORS,
                PURCHASE_INTENT,
                PRODUCT_FEEDBACK,
                NEWS,
                SENTIMENT,
                MARKET,
                VIRAL_LITE,
                /**
                 * An enum member indicating that [Preset] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             */
            fun value(): Value =
                when (this) {
                    BRAND -> Value.BRAND
                    COMPLAINTS -> Value.COMPLAINTS
                    COMPETITORS -> Value.COMPETITORS
                    PURCHASE_INTENT -> Value.PURCHASE_INTENT
                    PRODUCT_FEEDBACK -> Value.PRODUCT_FEEDBACK
                    NEWS -> Value.NEWS
                    SENTIMENT -> Value.SENTIMENT
                    MARKET -> Value.MARKET
                    VIRAL_LITE -> Value.VIRAL_LITE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    BRAND -> Known.BRAND
                    COMPLAINTS -> Known.COMPLAINTS
                    COMPETITORS -> Known.COMPETITORS
                    PURCHASE_INTENT -> Known.PURCHASE_INTENT
                    PRODUCT_FEEDBACK -> Known.PRODUCT_FEEDBACK
                    NEWS -> Known.NEWS
                    SENTIMENT -> Known.SENTIMENT
                    MARKET -> Known.MARKET
                    VIRAL_LITE -> Known.VIRAL_LITE
                    else -> throw XTwitterScraperInvalidDataException("Unknown Preset: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
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
            fun validate(): Preset = apply {
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

            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Preset && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * A question the AI answers for each post. A choice picks 1 of 2 to 255 categories, a score
         * picks 1 of 2 or more ordered levels & a probability answers yes or no.
         */
        class Question
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val instructions: JsonField<String>,
            private val type: JsonField<Type>,
            private val version: JsonField<String>,
            private val categories: JsonField<Categories>,
            private val criteria: JsonField<Criteria>,
            private val levels: JsonField<List<String>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("instructions")
                @ExcludeMissing
                instructions: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("version")
                @ExcludeMissing
                version: JsonField<String> = JsonMissing.of(),
                @JsonProperty("categories")
                @ExcludeMissing
                categories: JsonField<Categories> = JsonMissing.of(),
                @JsonProperty("criteria")
                @ExcludeMissing
                criteria: JsonField<Criteria> = JsonMissing.of(),
                @JsonProperty("levels")
                @ExcludeMissing
                levels: JsonField<List<String>> = JsonMissing.of(),
            ) : this(id, instructions, type, version, categories, criteria, levels, mutableMapOf())

            /**
             * Name of the answer, such as request. A name the response renames or drops gets a 400,
             * such as created_at, favorite_count, muting or blocking.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun id(): String = id.getRequired("id")

            /**
             * The question, as the AI reads it.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun instructions(): String = instructions.getRequired("instructions")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun type(): Type = type.getRequired("type")

            /**
             * Your version of the question, such as 1.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun version(): String = version.getRequired("version")

            /**
             * For a choice. Each category name with its description, or null.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun categories(): Optional<Categories> = categories.getOptional("categories")

            /**
             * For a probability. What counts as yes & as no.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun criteria(): Optional<Criteria> = criteria.getOptional("criteria")

            /**
             * For a score. Each level's description, lowest first.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun levels(): Optional<List<String>> = levels.getOptional("levels")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [instructions].
             *
             * Unlike [instructions], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("instructions")
            @ExcludeMissing
            fun _instructions(): JsonField<String> = instructions

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            /**
             * Returns the raw JSON value of [version].
             *
             * Unlike [version], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("version") @ExcludeMissing fun _version(): JsonField<String> = version

            /**
             * Returns the raw JSON value of [categories].
             *
             * Unlike [categories], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("categories")
            @ExcludeMissing
            fun _categories(): JsonField<Categories> = categories

            /**
             * Returns the raw JSON value of [criteria].
             *
             * Unlike [criteria], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("criteria")
            @ExcludeMissing
            fun _criteria(): JsonField<Criteria> = criteria

            /**
             * Returns the raw JSON value of [levels].
             *
             * Unlike [levels], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("levels") @ExcludeMissing fun _levels(): JsonField<List<String>> = levels

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
                 * Returns a mutable builder for constructing an instance of [Question].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .instructions()
                 * .type()
                 * .version()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Question]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var instructions: JsonField<String>? = null
                private var type: JsonField<Type>? = null
                private var version: JsonField<String>? = null
                private var categories: JsonField<Categories> = JsonMissing.of()
                private var criteria: JsonField<Criteria> = JsonMissing.of()
                private var levels: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(question: Question) = apply {
                    id = question.id
                    instructions = question.instructions
                    type = question.type
                    version = question.version
                    categories = question.categories
                    criteria = question.criteria
                    levels = question.levels.map { it.toMutableList() }
                    additionalProperties = question.additionalProperties.toMutableMap()
                }

                /**
                 * Name of the answer, such as request. A name the response renames or drops gets a
                 * 400, such as created_at, favorite_count, muting or blocking.
                 */
                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** The question, as the AI reads it. */
                fun instructions(instructions: String) = instructions(JsonField.of(instructions))

                /** Sets [Builder.instructions] to an arbitrary JSON value. */
                fun instructions(instructions: JsonField<String>) = apply {
                    this.instructions = instructions
                }

                fun type(type: Type) = type(JsonField.of(type))

                /** Sets [Builder.type] to an arbitrary JSON value. */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                /** Your version of the question, such as 1. */
                fun version(version: String) = version(JsonField.of(version))

                /** Sets [Builder.version] to an arbitrary JSON value. */
                fun version(version: JsonField<String>) = apply { this.version = version }

                /** For a choice. Each category name with its description, or null. */
                fun categories(categories: Categories) = categories(JsonField.of(categories))

                /** Sets [Builder.categories] to an arbitrary JSON value. */
                fun categories(categories: JsonField<Categories>) = apply {
                    this.categories = categories
                }

                /** For a probability. What counts as yes & as no. */
                fun criteria(criteria: Criteria) = criteria(JsonField.of(criteria))

                /** Sets [Builder.criteria] to an arbitrary JSON value. */
                fun criteria(criteria: JsonField<Criteria>) = apply { this.criteria = criteria }

                /** For a score. Each level's description, lowest first. */
                fun levels(levels: List<String>) = levels(JsonField.of(levels))

                /** Sets [Builder.levels] to an arbitrary JSON value. */
                fun levels(levels: JsonField<List<String>>) = apply {
                    this.levels = levels.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [levels].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addLevel(level: String) = apply {
                    levels =
                        (levels ?: JsonField.of(mutableListOf())).also {
                            checkKnown("levels", it).add(level)
                        }
                }

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
                 * Returns an immutable instance of [Question].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * .instructions()
                 * .type()
                 * .version()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Question =
                    Question(
                        checkRequired("id", id),
                        checkRequired("instructions", instructions),
                        checkRequired("type", type),
                        checkRequired("version", version),
                        categories,
                        criteria,
                        (levels ?: JsonMissing.of()).map { it.toImmutable() },
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
            fun validate(): Question = apply {
                if (validated) {
                    return@apply
                }

                id()
                instructions()
                type().validate()
                version()
                categories().ifPresent { it.validate() }
                criteria().ifPresent { it.validate() }
                levels()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            @JvmSynthetic
            internal fun validity(): Int =
                (if (id.asKnown().isPresent) 1 else 0) +
                    (if (instructions.asKnown().isPresent) 1 else 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (version.asKnown().isPresent) 1 else 0) +
                    (categories.asKnown().getOrNull()?.validity() ?: 0) +
                    (criteria.asKnown().getOrNull()?.validity() ?: 0) +
                    (levels.asKnown().getOrNull()?.size ?: 0)

            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /** Returns this class instance's raw value. */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val CHOICE = of("choice")

                    @JvmField val SCORE = of("score")

                    @JvmField val PROBABILITY = of("probability")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    CHOICE,
                    SCORE,
                    PROBABILITY,
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    CHOICE,
                    SCORE,
                    PROBABILITY,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 */
                fun value(): Value =
                    when (this) {
                        CHOICE -> Value.CHOICE
                        SCORE -> Value.SCORE
                        PROBABILITY -> Value.PROBABILITY
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        CHOICE -> Known.CHOICE
                        SCORE -> Known.SCORE
                        PROBABILITY -> Known.PROBABILITY
                        else -> throw XTwitterScraperInvalidDataException("Unknown Type: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
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
                fun validate(): Type = apply {
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

                @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Type && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            /** For a choice. Each category name with its description, or null. */
            class Categories
            @JsonCreator
            private constructor(
                @com.fasterxml.jackson.annotation.JsonValue
                private val additionalProperties: Map<String, JsonValue>
            ) {

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [Categories]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Categories]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(categories: Categories) = apply {
                        additionalProperties = categories.additionalProperties.toMutableMap()
                    }

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
                     * Returns an immutable instance of [Categories].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Categories = Categories(additionalProperties.toImmutable())
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
                fun validate(): Categories = apply {
                    if (validated) {
                        return@apply
                    }

                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: XTwitterScraperInvalidDataException) {
                        false
                    }

                @JvmSynthetic
                internal fun validity(): Int = additionalProperties.count { (_, value) ->
                    !value.isNull() && !value.isMissing()
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Categories && additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() = "Categories{additionalProperties=$additionalProperties}"
            }

            /** For a probability. What counts as yes & as no. */
            class Criteria
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val no: JsonField<String>,
                private val yes: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("no") @ExcludeMissing no: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("yes") @ExcludeMissing yes: JsonField<String> = JsonMissing.of(),
                ) : this(no, yes, mutableMapOf())

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun no(): String = no.getRequired("no")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun yes(): String = yes.getRequired("yes")

                /**
                 * Returns the raw JSON value of [no].
                 *
                 * Unlike [no], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("no") @ExcludeMissing fun _no(): JsonField<String> = no

                /**
                 * Returns the raw JSON value of [yes].
                 *
                 * Unlike [yes], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("yes") @ExcludeMissing fun _yes(): JsonField<String> = yes

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
                     * Returns a mutable builder for constructing an instance of [Criteria].
                     *
                     * The following fields are required:
                     * ```java
                     * .no()
                     * .yes()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Criteria]. */
                class Builder internal constructor() {

                    private var no: JsonField<String>? = null
                    private var yes: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(criteria: Criteria) = apply {
                        no = criteria.no
                        yes = criteria.yes
                        additionalProperties = criteria.additionalProperties.toMutableMap()
                    }

                    fun no(no: String) = no(JsonField.of(no))

                    /** Sets [Builder.no] to an arbitrary JSON value. */
                    fun no(no: JsonField<String>) = apply { this.no = no }

                    fun yes(yes: String) = yes(JsonField.of(yes))

                    /** Sets [Builder.yes] to an arbitrary JSON value. */
                    fun yes(yes: JsonField<String>) = apply { this.yes = yes }

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
                     * Returns an immutable instance of [Criteria].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .no()
                     * .yes()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Criteria =
                        Criteria(
                            checkRequired("no", no),
                            checkRequired("yes", yes),
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
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Criteria = apply {
                    if (validated) {
                        return@apply
                    }

                    no()
                    yes()
                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: XTwitterScraperInvalidDataException) {
                        false
                    }

                @JvmSynthetic
                internal fun validity(): Int =
                    (if (no.asKnown().isPresent) 1 else 0) + (if (yes.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Criteria &&
                        no == other.no &&
                        yes == other.yes &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(no, yes, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Criteria{no=$no, yes=$yes, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Question &&
                    id == other.id &&
                    instructions == other.instructions &&
                    type == other.type &&
                    version == other.version &&
                    categories == other.categories &&
                    criteria == other.criteria &&
                    levels == other.levels &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    instructions,
                    type,
                    version,
                    categories,
                    criteria,
                    levels,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Question{id=$id, instructions=$instructions, type=$type, version=$version, categories=$categories, criteria=$criteria, levels=$levels, additionalProperties=$additionalProperties}"
        }

        class Target
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val name: JsonField<String>,
            private val aliases: JsonField<List<String>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("aliases")
                @ExcludeMissing
                aliases: JsonField<List<String>> = JsonMissing.of(),
            ) : this(name, aliases, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun name(): String = name.getRequired("name")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun aliases(): Optional<List<String>> = aliases.getOptional("aliases")

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [aliases].
             *
             * Unlike [aliases], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("aliases")
            @ExcludeMissing
            fun _aliases(): JsonField<List<String>> = aliases

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
                 * Returns a mutable builder for constructing an instance of [Target].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Target]. */
            class Builder internal constructor() {

                private var name: JsonField<String>? = null
                private var aliases: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(target: Target) = apply {
                    name = target.name
                    aliases = target.aliases.map { it.toMutableList() }
                    additionalProperties = target.additionalProperties.toMutableMap()
                }

                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun aliases(aliases: List<String>) = aliases(JsonField.of(aliases))

                /** Sets [Builder.aliases] to an arbitrary JSON value. */
                fun aliases(aliases: JsonField<List<String>>) = apply {
                    this.aliases = aliases.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [aliases].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addAlias(alias: String) = apply {
                    aliases =
                        (aliases ?: JsonField.of(mutableListOf())).also {
                            checkKnown("aliases", it).add(alias)
                        }
                }

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
                 * Returns an immutable instance of [Target].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Target =
                    Target(
                        checkRequired("name", name),
                        (aliases ?: JsonMissing.of()).map { it.toImmutable() },
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
            fun validate(): Target = apply {
                if (validated) {
                    return@apply
                }

                name()
                aliases()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            @JvmSynthetic
            internal fun validity(): Int =
                (if (name.asKnown().isPresent) 1 else 0) +
                    (aliases.asKnown().getOrNull()?.size ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Target &&
                    name == other.name &&
                    aliases == other.aliases &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(name, aliases, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Target{name=$name, aliases=$aliases, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Analysis &&
                concurrency == other.concurrency &&
                context == other.context &&
                maxContextBytes == other.maxContextBytes &&
                preset == other.preset &&
                questions == other.questions &&
                targets == other.targets &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                concurrency,
                context,
                maxContextBytes,
                preset,
                questions,
                targets,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Analysis{concurrency=$concurrency, context=$context, maxContextBytes=$maxContextBytes, preset=$preset, questions=$questions, targets=$targets, additionalProperties=$additionalProperties}"
    }

    class Baseline
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val answers: JsonField<Answers>,
        private val id: JsonField<String>,
        private val monitor: JsonField<Monitor>,
        private val tweet: JsonField<Tweet>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("answers") @ExcludeMissing answers: JsonField<Answers> = JsonMissing.of(),
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("monitor") @ExcludeMissing monitor: JsonField<Monitor> = JsonMissing.of(),
            @JsonProperty("tweet") @ExcludeMissing tweet: JsonField<Tweet> = JsonMissing.of(),
        ) : this(answers, id, monitor, tweet, mutableMapOf())

        /**
         * The earlier answers by question ID.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun answers(): Answers = answers.getRequired("answers")

        /**
         * Post ID, or text:1 & so on. Otherwise tweet.id counts.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The earlier row's monitor, with its fingerprint.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun monitor(): Optional<Monitor> = monitor.getOptional("monitor")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun tweet(): Optional<Tweet> = tweet.getOptional("tweet")

        /**
         * Returns the raw JSON value of [answers].
         *
         * Unlike [answers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("answers") @ExcludeMissing fun _answers(): JsonField<Answers> = answers

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [monitor].
         *
         * Unlike [monitor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("monitor") @ExcludeMissing fun _monitor(): JsonField<Monitor> = monitor

        /**
         * Returns the raw JSON value of [tweet].
         *
         * Unlike [tweet], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweet") @ExcludeMissing fun _tweet(): JsonField<Tweet> = tweet

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
             * Returns a mutable builder for constructing an instance of [Baseline].
             *
             * The following fields are required:
             * ```java
             * .answers()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Baseline]. */
        class Builder internal constructor() {

            private var answers: JsonField<Answers>? = null
            private var id: JsonField<String> = JsonMissing.of()
            private var monitor: JsonField<Monitor> = JsonMissing.of()
            private var tweet: JsonField<Tweet> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(baseline: Baseline) = apply {
                answers = baseline.answers
                id = baseline.id
                monitor = baseline.monitor
                tweet = baseline.tweet
                additionalProperties = baseline.additionalProperties.toMutableMap()
            }

            /** The earlier answers by question ID. */
            fun answers(answers: Answers) = answers(JsonField.of(answers))

            /** Sets [Builder.answers] to an arbitrary JSON value. */
            fun answers(answers: JsonField<Answers>) = apply { this.answers = answers }

            /** Post ID, or text:1 & so on. Otherwise tweet.id counts. */
            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The earlier row's monitor, with its fingerprint. */
            fun monitor(monitor: Monitor) = monitor(JsonField.of(monitor))

            /** Sets [Builder.monitor] to an arbitrary JSON value. */
            fun monitor(monitor: JsonField<Monitor>) = apply { this.monitor = monitor }

            fun tweet(tweet: Tweet) = tweet(JsonField.of(tweet))

            /** Sets [Builder.tweet] to an arbitrary JSON value. */
            fun tweet(tweet: JsonField<Tweet>) = apply { this.tweet = tweet }

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
             * Returns an immutable instance of [Baseline].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .answers()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Baseline =
                Baseline(
                    checkRequired("answers", answers),
                    id,
                    monitor,
                    tweet,
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
        fun validate(): Baseline = apply {
            if (validated) {
                return@apply
            }

            answers().validate()
            id()
            monitor().ifPresent { it.validate() }
            tweet().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        @JvmSynthetic
        internal fun validity(): Int =
            (answers.asKnown().getOrNull()?.validity() ?: 0) +
                (if (id.asKnown().isPresent) 1 else 0) +
                (monitor.asKnown().getOrNull()?.validity() ?: 0) +
                (tweet.asKnown().getOrNull()?.validity() ?: 0)

        /** The earlier answers by question ID. */
        class Answers
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Answers]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Answers]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(answers: Answers) = apply {
                    additionalProperties = answers.additionalProperties.toMutableMap()
                }

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
                 * Returns an immutable instance of [Answers].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Answers = Answers(additionalProperties.toImmutable())
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
            fun validate(): Answers = apply {
                if (validated) {
                    return@apply
                }

                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            @JvmSynthetic
            internal fun validity(): Int = additionalProperties.count { (_, value) ->
                !value.isNull() && !value.isMissing()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Answers && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Answers{additionalProperties=$additionalProperties}"
        }

        /** The earlier row's monitor, with its fingerprint. */
        class Monitor
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val configurationFingerprint: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("configurationFingerprint")
                @ExcludeMissing
                configurationFingerprint: JsonField<String> = JsonMissing.of()
            ) : this(configurationFingerprint, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun configurationFingerprint(): Optional<String> =
                configurationFingerprint.getOptional("configurationFingerprint")

            /**
             * Returns the raw JSON value of [configurationFingerprint].
             *
             * Unlike [configurationFingerprint], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("configurationFingerprint")
            @ExcludeMissing
            fun _configurationFingerprint(): JsonField<String> = configurationFingerprint

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

                /** Returns a mutable builder for constructing an instance of [Monitor]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Monitor]. */
            class Builder internal constructor() {

                private var configurationFingerprint: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(monitor: Monitor) = apply {
                    configurationFingerprint = monitor.configurationFingerprint
                    additionalProperties = monitor.additionalProperties.toMutableMap()
                }

                fun configurationFingerprint(configurationFingerprint: String) =
                    configurationFingerprint(JsonField.of(configurationFingerprint))

                /** Sets [Builder.configurationFingerprint] to an arbitrary JSON value. */
                fun configurationFingerprint(configurationFingerprint: JsonField<String>) = apply {
                    this.configurationFingerprint = configurationFingerprint
                }

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
                 * Returns an immutable instance of [Monitor].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Monitor =
                    Monitor(configurationFingerprint, additionalProperties.toMutableMap())
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
            fun validate(): Monitor = apply {
                if (validated) {
                    return@apply
                }

                configurationFingerprint()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            @JvmSynthetic
            internal fun validity(): Int =
                (if (configurationFingerprint.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Monitor &&
                    configurationFingerprint == other.configurationFingerprint &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(configurationFingerprint, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Monitor{configurationFingerprint=$configurationFingerprint, additionalProperties=$additionalProperties}"
        }

        class Tweet
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of()
            ) : this(id, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun id(): String = id.getRequired("id")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
                 * Returns a mutable builder for constructing an instance of [Tweet].
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Tweet]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(tweet: Tweet) = apply {
                    id = tweet.id
                    additionalProperties = tweet.additionalProperties.toMutableMap()
                }

                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

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
                 * Returns an immutable instance of [Tweet].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .id()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Tweet =
                    Tweet(checkRequired("id", id), additionalProperties.toMutableMap())
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
            fun validate(): Tweet = apply {
                if (validated) {
                    return@apply
                }

                id()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            @JvmSynthetic internal fun validity(): Int = (if (id.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Tweet &&
                    id == other.id &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(id, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Tweet{id=$id, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Baseline &&
                answers == other.answers &&
                id == other.id &&
                monitor == other.monitor &&
                tweet == other.tweet &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(answers, id, monitor, tweet, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Baseline{answers=$answers, id=$id, monitor=$monitor, tweet=$tweet, additionalProperties=$additionalProperties}"
    }

    /** Search order. Default Latest. */
    class QueryType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val LATEST = of("Latest")

            @JvmField val TOP = of("Top")

            @JvmStatic fun of(value: String) = QueryType(JsonField.of(value))
        }

        /** An enum containing [QueryType]'s known values. */
        enum class Known {
            LATEST,
            TOP,
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
            /**
             * An enum member indicating that [QueryType] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         */
        fun value(): Value =
            when (this) {
                LATEST -> Value.LATEST
                TOP -> Value.TOP
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                LATEST -> Known.LATEST
                TOP -> Known.TOP
                else -> throw XTwitterScraperInvalidDataException("Unknown QueryType: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
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

    /**
     * Inclusive start of the search, such as 2026-09-25T00:00:00Z. Unix seconds also work. A time
     * without an offset is UTC.
     */
    @JsonDeserialize(using = SinceTime.Deserializer::class)
    @JsonSerialize(using = SinceTime.Serializer::class)
    class SinceTime
    private constructor(
        private val string: String? = null,
        private val integer: Long? = null,
        private val _json: JsonValue? = null,
    ) {

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun integer(): Optional<Long> = Optional.ofNullable(integer)

        fun isString(): Boolean = string != null

        fun isInteger(): Boolean = integer != null

        fun asString(): String = string.getOrThrow("string")

        fun asInteger(): Long = integer.getOrThrow("integer")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * @throws XTwitterScraperInvalidDataException if [Visitor.unknown] is not overridden in
         *   [visitor] and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                string != null -> visitor.visitString(string)
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
                    override fun visitString(string: String) {}

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

        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitString(string: String) = 1

                    override fun visitInteger(integer: Long) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is SinceTime && string == other.string && integer == other.integer
        }

        override fun hashCode(): Int = Objects.hash(string, integer)

        override fun toString(): String =
            when {
                string != null -> "SinceTime{string=$string}"
                integer != null -> "SinceTime{integer=$integer}"
                _json != null -> "SinceTime{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid SinceTime")
            }

        companion object {

            @JvmStatic fun ofString(string: String) = SinceTime(string = string)

            @JvmStatic fun ofInteger(integer: Long) = SinceTime(integer = integer)
        }

        /**
         * An interface that defines how to map each variant of [SinceTime] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitInteger(integer: Long): T

            /**
             * Maps an unknown variant of [SinceTime] to a value of type [T].
             *
             * An instance of [SinceTime] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant.
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
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                SinceTime(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                SinceTime(integer = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    0 -> SinceTime(_json = json)
                    1 -> bestMatches.single()
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
                    value.string != null -> generator.writeObject(value.string)
                    value.integer != null -> generator.writeObject(value.integer)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid SinceTime")
                }
            }
        }
    }

    /**
     * Exclusive end of the search, such as 2026-09-26T00:00:00Z. Unix seconds also work. A time
     * without an offset is UTC.
     */
    @JsonDeserialize(using = UntilTime.Deserializer::class)
    @JsonSerialize(using = UntilTime.Serializer::class)
    class UntilTime
    private constructor(
        private val string: String? = null,
        private val integer: Long? = null,
        private val _json: JsonValue? = null,
    ) {

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun integer(): Optional<Long> = Optional.ofNullable(integer)

        fun isString(): Boolean = string != null

        fun isInteger(): Boolean = integer != null

        fun asString(): String = string.getOrThrow("string")

        fun asInteger(): Long = integer.getOrThrow("integer")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * @throws XTwitterScraperInvalidDataException if [Visitor.unknown] is not overridden in
         *   [visitor] and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                string != null -> visitor.visitString(string)
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
                    override fun visitString(string: String) {}

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

        @JvmSynthetic
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitString(string: String) = 1

                    override fun visitInteger(integer: Long) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UntilTime && string == other.string && integer == other.integer
        }

        override fun hashCode(): Int = Objects.hash(string, integer)

        override fun toString(): String =
            when {
                string != null -> "UntilTime{string=$string}"
                integer != null -> "UntilTime{integer=$integer}"
                _json != null -> "UntilTime{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid UntilTime")
            }

        companion object {

            @JvmStatic fun ofString(string: String) = UntilTime(string = string)

            @JvmStatic fun ofInteger(integer: Long) = UntilTime(integer = integer)
        }

        /**
         * An interface that defines how to map each variant of [UntilTime] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitInteger(integer: Long): T

            /**
             * Maps an unknown variant of [UntilTime] to a value of type [T].
             *
             * An instance of [UntilTime] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant.
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
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                UntilTime(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Long>())?.let {
                                UntilTime(integer = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    0 -> UntilTime(_json = json)
                    1 -> bestMatches.single()
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
                    value.string != null -> generator.writeObject(value.string)
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

        return other is AnalysisClassifyParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "AnalysisClassifyParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
