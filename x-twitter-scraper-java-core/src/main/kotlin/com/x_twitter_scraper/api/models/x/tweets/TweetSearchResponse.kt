// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

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
import com.x_twitter_scraper.api.core.allMaxBy
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.getOrThrow
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import com.x_twitter_scraper.api.models.PaginatedTweets
import com.x_twitter_scraper.api.models.SearchTweet
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * No-mode search, user Tweet, user reply, and direct reply reads use automatic coverage. Shape,
 * filters, aliases, and billing stay compatible. Unprefixed cursors remain legacy. Follow
 * next_cursor while has_next_page is true. An empty filtered page can still have has_next_page
 * true.
 */
@JsonDeserialize(using = TweetSearchResponse.Deserializer::class)
@JsonSerialize(using = TweetSearchResponse.Serializer::class)
class TweetSearchResponse
private constructor(
    private val paginatedTweets: PaginatedTweets? = null,
    private val coverage: TweetSearchCoverageResponse? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * No-mode search, user Tweet, user reply, and direct reply reads use automatic coverage. Shape,
     * filters, aliases, and billing stay compatible. Unprefixed cursors remain legacy. Follow
     * next_cursor while has_next_page is true. An empty filtered page can still have has_next_page
     * true.
     */
    fun paginatedTweets(): Optional<PaginatedTweets> = Optional.ofNullable(paginatedTweets)

    /**
     * No-mode search, user Tweet, user reply, and direct reply reads use automatic coverage. Shape,
     * filters, aliases, and billing stay compatible. Unprefixed cursors remain legacy. Follow
     * next_cursor while has_next_page is true. An empty filtered page can still have has_next_page
     * true.
     */
    fun coverage(): Optional<TweetSearchCoverageResponse> = Optional.ofNullable(coverage)

    fun isPaginatedTweets(): Boolean = paginatedTweets != null

    fun isCoverage(): Boolean = coverage != null

    /**
     * No-mode search, user Tweet, user reply, and direct reply reads use automatic coverage. Shape,
     * filters, aliases, and billing stay compatible. Unprefixed cursors remain legacy. Follow
     * next_cursor while has_next_page is true. An empty filtered page can still have has_next_page
     * true.
     */
    fun asPaginatedTweets(): PaginatedTweets = paginatedTweets.getOrThrow("paginatedTweets")

    /**
     * No-mode search, user Tweet, user reply, and direct reply reads use automatic coverage. Shape,
     * filters, aliases, and billing stay compatible. Unprefixed cursors remain legacy. Follow
     * next_cursor while has_next_page is true. An empty filtered page can still have has_next_page
     * true.
     */
    fun asCoverage(): TweetSearchCoverageResponse = coverage.getOrThrow("coverage")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.x_twitter_scraper.api.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = tweetSearchResponse.accept(new TweetSearchResponse.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitPaginatedTweets(PaginatedTweets paginatedTweets) {
     *         return Optional.of(paginatedTweets.toString());
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
            paginatedTweets != null -> visitor.visitPaginatedTweets(paginatedTweets)
            coverage != null -> visitor.visitCoverage(coverage)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match
     *   its expected type.
     */
    fun validate(): TweetSearchResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitPaginatedTweets(paginatedTweets: PaginatedTweets) {
                    paginatedTweets.validate()
                }

                override fun visitCoverage(coverage: TweetSearchCoverageResponse) {
                    coverage.validate()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitPaginatedTweets(paginatedTweets: PaginatedTweets) =
                    paginatedTweets.validity()

                override fun visitCoverage(coverage: TweetSearchCoverageResponse) =
                    coverage.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetSearchResponse &&
            paginatedTweets == other.paginatedTweets &&
            coverage == other.coverage
    }

    override fun hashCode(): Int = Objects.hash(paginatedTweets, coverage)

    override fun toString(): String =
        when {
            paginatedTweets != null -> "TweetSearchResponse{paginatedTweets=$paginatedTweets}"
            coverage != null -> "TweetSearchResponse{coverage=$coverage}"
            _json != null -> "TweetSearchResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid TweetSearchResponse")
        }

    companion object {

        /**
         * No-mode search, user Tweet, user reply, and direct reply reads use automatic coverage.
         * Shape, filters, aliases, and billing stay compatible. Unprefixed cursors remain legacy.
         * Follow next_cursor while has_next_page is true. An empty filtered page can still have
         * has_next_page true.
         */
        @JvmStatic
        fun ofPaginatedTweets(paginatedTweets: PaginatedTweets) =
            TweetSearchResponse(paginatedTweets = paginatedTweets)

        /**
         * No-mode search, user Tweet, user reply, and direct reply reads use automatic coverage.
         * Shape, filters, aliases, and billing stay compatible. Unprefixed cursors remain legacy.
         * Follow next_cursor while has_next_page is true. An empty filtered page can still have
         * has_next_page true.
         */
        @JvmStatic
        fun ofCoverage(coverage: TweetSearchCoverageResponse) =
            TweetSearchResponse(coverage = coverage)
    }

    /**
     * An interface that defines how to map each variant of [TweetSearchResponse] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /**
         * No-mode search, user Tweet, user reply, and direct reply reads use automatic coverage.
         * Shape, filters, aliases, and billing stay compatible. Unprefixed cursors remain legacy.
         * Follow next_cursor while has_next_page is true. An empty filtered page can still have
         * has_next_page true.
         */
        fun visitPaginatedTweets(paginatedTweets: PaginatedTweets): T

        /**
         * No-mode search, user Tweet, user reply, and direct reply reads use automatic coverage.
         * Shape, filters, aliases, and billing stay compatible. Unprefixed cursors remain legacy.
         * Follow next_cursor while has_next_page is true. An empty filtered page can still have
         * has_next_page true.
         */
        fun visitCoverage(coverage: TweetSearchCoverageResponse): T

        /**
         * Maps an unknown variant of [TweetSearchResponse] to a value of type [T].
         *
         * An instance of [TweetSearchResponse] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws XTwitterScraperInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw XTwitterScraperInvalidDataException("Unknown TweetSearchResponse: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<TweetSearchResponse>(TweetSearchResponse::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): TweetSearchResponse {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<PaginatedTweets>())?.let {
                            TweetSearchResponse(paginatedTweets = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<TweetSearchCoverageResponse>())?.let {
                            TweetSearchResponse(coverage = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> TweetSearchResponse(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<TweetSearchResponse>(TweetSearchResponse::class) {

        override fun serialize(
            value: TweetSearchResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.paginatedTweets != null -> generator.writeObject(value.paginatedTweets)
                value.coverage != null -> generator.writeObject(value.coverage)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid TweetSearchResponse")
            }
        }
    }

    /**
     * No-mode search, user Tweet, user reply, and direct reply reads use automatic coverage. Shape,
     * filters, aliases, and billing stay compatible. Unprefixed cursors remain legacy. Follow
     * next_cursor while has_next_page is true. An empty filtered page can still have has_next_page
     * true.
     */
    class TweetSearchCoverageResponse
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val hasNextPage: JsonField<Boolean>,
        private val nextCursor: JsonField<String>,
        private val tweets: JsonField<List<SearchTweet>>,
        private val diagnostic: JsonField<Diagnostic>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("has_next_page")
            @ExcludeMissing
            hasNextPage: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("next_cursor")
            @ExcludeMissing
            nextCursor: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tweets")
            @ExcludeMissing
            tweets: JsonField<List<SearchTweet>> = JsonMissing.of(),
            @JsonProperty("diagnostic")
            @ExcludeMissing
            diagnostic: JsonField<Diagnostic> = JsonMissing.of(),
        ) : this(hasNextPage, nextCursor, tweets, diagnostic, mutableMapOf())

        fun toPaginatedTweets(): PaginatedTweets =
            PaginatedTweets.builder()
                .hasNextPage(hasNextPage)
                .nextCursor(nextCursor)
                .tweets(tweets)
                .build()

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun hasNextPage(): Boolean = hasNextPage.getRequired("has_next_page")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun nextCursor(): String = nextCursor.getRequired("next_cursor")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun tweets(): List<SearchTweet> = tweets.getRequired("tweets")

        /**
         * Coverage evidence across parallel search strategies.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun diagnostic(): Diagnostic = diagnostic.getRequired("diagnostic")

        /**
         * Returns the raw JSON value of [hasNextPage].
         *
         * Unlike [hasNextPage], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("has_next_page")
        @ExcludeMissing
        fun _hasNextPage(): JsonField<Boolean> = hasNextPage

        /**
         * Returns the raw JSON value of [nextCursor].
         *
         * Unlike [nextCursor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("next_cursor")
        @ExcludeMissing
        fun _nextCursor(): JsonField<String> = nextCursor

        /**
         * Returns the raw JSON value of [tweets].
         *
         * Unlike [tweets], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweets") @ExcludeMissing fun _tweets(): JsonField<List<SearchTweet>> = tweets

        /**
         * Returns the raw JSON value of [diagnostic].
         *
         * Unlike [diagnostic], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("diagnostic")
        @ExcludeMissing
        fun _diagnostic(): JsonField<Diagnostic> = diagnostic

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
             * Returns a mutable builder for constructing an instance of
             * [TweetSearchCoverageResponse].
             *
             * The following fields are required:
             * ```java
             * .hasNextPage()
             * .nextCursor()
             * .tweets()
             * .diagnostic()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TweetSearchCoverageResponse]. */
        class Builder internal constructor() {

            private var hasNextPage: JsonField<Boolean>? = null
            private var nextCursor: JsonField<String>? = null
            private var tweets: JsonField<MutableList<SearchTweet>>? = null
            private var diagnostic: JsonField<Diagnostic>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(tweetSearchCoverageResponse: TweetSearchCoverageResponse) = apply {
                hasNextPage = tweetSearchCoverageResponse.hasNextPage
                nextCursor = tweetSearchCoverageResponse.nextCursor
                tweets = tweetSearchCoverageResponse.tweets.map { it.toMutableList() }
                diagnostic = tweetSearchCoverageResponse.diagnostic
                additionalProperties =
                    tweetSearchCoverageResponse.additionalProperties.toMutableMap()
            }

            fun hasNextPage(hasNextPage: Boolean) = hasNextPage(JsonField.of(hasNextPage))

            /**
             * Sets [Builder.hasNextPage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasNextPage] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasNextPage(hasNextPage: JsonField<Boolean>) = apply {
                this.hasNextPage = hasNextPage
            }

            fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

            /**
             * Sets [Builder.nextCursor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.nextCursor] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

            fun tweets(tweets: List<SearchTweet>) = tweets(JsonField.of(tweets))

            /**
             * Sets [Builder.tweets] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tweets] with a well-typed `List<SearchTweet>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tweets(tweets: JsonField<List<SearchTweet>>) = apply {
                this.tweets = tweets.map { it.toMutableList() }
            }

            /**
             * Adds a single [SearchTweet] to [tweets].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTweet(tweet: SearchTweet) = apply {
                tweets =
                    (tweets ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tweets", it).add(tweet)
                    }
            }

            /** Coverage evidence across parallel search strategies. */
            fun diagnostic(diagnostic: Diagnostic) = diagnostic(JsonField.of(diagnostic))

            /**
             * Sets [Builder.diagnostic] to an arbitrary JSON value.
             *
             * You should usually call [Builder.diagnostic] with a well-typed [Diagnostic] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun diagnostic(diagnostic: JsonField<Diagnostic>) = apply {
                this.diagnostic = diagnostic
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
             * Returns an immutable instance of [TweetSearchCoverageResponse].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .hasNextPage()
             * .nextCursor()
             * .tweets()
             * .diagnostic()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): TweetSearchCoverageResponse =
                TweetSearchCoverageResponse(
                    checkRequired("hasNextPage", hasNextPage),
                    checkRequired("nextCursor", nextCursor),
                    checkRequired("tweets", tweets).map { it.toImmutable() },
                    checkRequired("diagnostic", diagnostic),
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
        fun validate(): TweetSearchCoverageResponse = apply {
            if (validated) {
                return@apply
            }

            hasNextPage()
            nextCursor()
            tweets().forEach { it.validate() }
            diagnostic().validate()
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
            (if (hasNextPage.asKnown().isPresent) 1 else 0) +
                (if (nextCursor.asKnown().isPresent) 1 else 0) +
                (tweets.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (diagnostic.asKnown().getOrNull()?.validity() ?: 0)

        /** Coverage evidence across parallel search strategies. */
        class Diagnostic
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val complete: JsonField<Boolean>,
            private val cursorFailureCount: JsonField<Long>,
            private val deadlineReached: JsonField<Boolean>,
            private val duplicateCount: JsonField<Long>,
            private val failedStrategyCount: JsonField<Long>,
            private val malformedCount: JsonField<Long>,
            private val pagesFetched: JsonField<Long>,
            private val partitioned: JsonField<Boolean>,
            private val responseTruncated: JsonField<Boolean>,
            private val resultLimitReached: JsonField<Boolean>,
            private val returnedTweets: JsonField<Long>,
            private val stalledStrategyCount: JsonField<Long>,
            private val strategies: JsonField<List<Strategy>>,
            private val strategyCount: JsonField<Long>,
            private val uniqueTweets: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("complete")
                @ExcludeMissing
                complete: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("cursorFailureCount")
                @ExcludeMissing
                cursorFailureCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("deadlineReached")
                @ExcludeMissing
                deadlineReached: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("duplicateCount")
                @ExcludeMissing
                duplicateCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("failedStrategyCount")
                @ExcludeMissing
                failedStrategyCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("malformedCount")
                @ExcludeMissing
                malformedCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("pagesFetched")
                @ExcludeMissing
                pagesFetched: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("partitioned")
                @ExcludeMissing
                partitioned: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("responseTruncated")
                @ExcludeMissing
                responseTruncated: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("resultLimitReached")
                @ExcludeMissing
                resultLimitReached: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("returnedTweets")
                @ExcludeMissing
                returnedTweets: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("stalledStrategyCount")
                @ExcludeMissing
                stalledStrategyCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("strategies")
                @ExcludeMissing
                strategies: JsonField<List<Strategy>> = JsonMissing.of(),
                @JsonProperty("strategyCount")
                @ExcludeMissing
                strategyCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("uniqueTweets")
                @ExcludeMissing
                uniqueTweets: JsonField<Long> = JsonMissing.of(),
            ) : this(
                complete,
                cursorFailureCount,
                deadlineReached,
                duplicateCount,
                failedStrategyCount,
                malformedCount,
                pagesFetched,
                partitioned,
                responseTruncated,
                resultLimitReached,
                returnedTweets,
                stalledStrategyCount,
                strategies,
                strategyCount,
                uniqueTweets,
                mutableMapOf(),
            )

            /**
             * True when every strategy exhausted its source.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun complete(): Boolean = complete.getRequired("complete")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun cursorFailureCount(): Long = cursorFailureCount.getRequired("cursorFailureCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun deadlineReached(): Boolean = deadlineReached.getRequired("deadlineReached")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun duplicateCount(): Long = duplicateCount.getRequired("duplicateCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun failedStrategyCount(): Long = failedStrategyCount.getRequired("failedStrategyCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun malformedCount(): Long = malformedCount.getRequired("malformedCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun pagesFetched(): Long = pagesFetched.getRequired("pagesFetched")

            /**
             * Whether bounded time windows ran in parallel.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun partitioned(): Boolean = partitioned.getRequired("partitioned")

            /**
             * Whether credits or the requested limit reduced output.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun responseTruncated(): Boolean = responseTruncated.getRequired("responseTruncated")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun resultLimitReached(): Boolean = resultLimitReached.getRequired("resultLimitReached")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun returnedTweets(): Long = returnedTweets.getRequired("returnedTweets")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun stalledStrategyCount(): Long =
                stalledStrategyCount.getRequired("stalledStrategyCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun strategies(): List<Strategy> = strategies.getRequired("strategies")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun strategyCount(): Long = strategyCount.getRequired("strategyCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun uniqueTweets(): Long = uniqueTweets.getRequired("uniqueTweets")

            /**
             * Returns the raw JSON value of [complete].
             *
             * Unlike [complete], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("complete") @ExcludeMissing fun _complete(): JsonField<Boolean> = complete

            /**
             * Returns the raw JSON value of [cursorFailureCount].
             *
             * Unlike [cursorFailureCount], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("cursorFailureCount")
            @ExcludeMissing
            fun _cursorFailureCount(): JsonField<Long> = cursorFailureCount

            /**
             * Returns the raw JSON value of [deadlineReached].
             *
             * Unlike [deadlineReached], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("deadlineReached")
            @ExcludeMissing
            fun _deadlineReached(): JsonField<Boolean> = deadlineReached

            /**
             * Returns the raw JSON value of [duplicateCount].
             *
             * Unlike [duplicateCount], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("duplicateCount")
            @ExcludeMissing
            fun _duplicateCount(): JsonField<Long> = duplicateCount

            /**
             * Returns the raw JSON value of [failedStrategyCount].
             *
             * Unlike [failedStrategyCount], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("failedStrategyCount")
            @ExcludeMissing
            fun _failedStrategyCount(): JsonField<Long> = failedStrategyCount

            /**
             * Returns the raw JSON value of [malformedCount].
             *
             * Unlike [malformedCount], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("malformedCount")
            @ExcludeMissing
            fun _malformedCount(): JsonField<Long> = malformedCount

            /**
             * Returns the raw JSON value of [pagesFetched].
             *
             * Unlike [pagesFetched], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("pagesFetched")
            @ExcludeMissing
            fun _pagesFetched(): JsonField<Long> = pagesFetched

            /**
             * Returns the raw JSON value of [partitioned].
             *
             * Unlike [partitioned], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("partitioned")
            @ExcludeMissing
            fun _partitioned(): JsonField<Boolean> = partitioned

            /**
             * Returns the raw JSON value of [responseTruncated].
             *
             * Unlike [responseTruncated], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("responseTruncated")
            @ExcludeMissing
            fun _responseTruncated(): JsonField<Boolean> = responseTruncated

            /**
             * Returns the raw JSON value of [resultLimitReached].
             *
             * Unlike [resultLimitReached], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("resultLimitReached")
            @ExcludeMissing
            fun _resultLimitReached(): JsonField<Boolean> = resultLimitReached

            /**
             * Returns the raw JSON value of [returnedTweets].
             *
             * Unlike [returnedTweets], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("returnedTweets")
            @ExcludeMissing
            fun _returnedTweets(): JsonField<Long> = returnedTweets

            /**
             * Returns the raw JSON value of [stalledStrategyCount].
             *
             * Unlike [stalledStrategyCount], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("stalledStrategyCount")
            @ExcludeMissing
            fun _stalledStrategyCount(): JsonField<Long> = stalledStrategyCount

            /**
             * Returns the raw JSON value of [strategies].
             *
             * Unlike [strategies], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("strategies")
            @ExcludeMissing
            fun _strategies(): JsonField<List<Strategy>> = strategies

            /**
             * Returns the raw JSON value of [strategyCount].
             *
             * Unlike [strategyCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("strategyCount")
            @ExcludeMissing
            fun _strategyCount(): JsonField<Long> = strategyCount

            /**
             * Returns the raw JSON value of [uniqueTweets].
             *
             * Unlike [uniqueTweets], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("uniqueTweets")
            @ExcludeMissing
            fun _uniqueTweets(): JsonField<Long> = uniqueTweets

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
                 * Returns a mutable builder for constructing an instance of [Diagnostic].
                 *
                 * The following fields are required:
                 * ```java
                 * .complete()
                 * .cursorFailureCount()
                 * .deadlineReached()
                 * .duplicateCount()
                 * .failedStrategyCount()
                 * .malformedCount()
                 * .pagesFetched()
                 * .partitioned()
                 * .responseTruncated()
                 * .resultLimitReached()
                 * .returnedTweets()
                 * .stalledStrategyCount()
                 * .strategies()
                 * .strategyCount()
                 * .uniqueTweets()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Diagnostic]. */
            class Builder internal constructor() {

                private var complete: JsonField<Boolean>? = null
                private var cursorFailureCount: JsonField<Long>? = null
                private var deadlineReached: JsonField<Boolean>? = null
                private var duplicateCount: JsonField<Long>? = null
                private var failedStrategyCount: JsonField<Long>? = null
                private var malformedCount: JsonField<Long>? = null
                private var pagesFetched: JsonField<Long>? = null
                private var partitioned: JsonField<Boolean>? = null
                private var responseTruncated: JsonField<Boolean>? = null
                private var resultLimitReached: JsonField<Boolean>? = null
                private var returnedTweets: JsonField<Long>? = null
                private var stalledStrategyCount: JsonField<Long>? = null
                private var strategies: JsonField<MutableList<Strategy>>? = null
                private var strategyCount: JsonField<Long>? = null
                private var uniqueTweets: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(diagnostic: Diagnostic) = apply {
                    complete = diagnostic.complete
                    cursorFailureCount = diagnostic.cursorFailureCount
                    deadlineReached = diagnostic.deadlineReached
                    duplicateCount = diagnostic.duplicateCount
                    failedStrategyCount = diagnostic.failedStrategyCount
                    malformedCount = diagnostic.malformedCount
                    pagesFetched = diagnostic.pagesFetched
                    partitioned = diagnostic.partitioned
                    responseTruncated = diagnostic.responseTruncated
                    resultLimitReached = diagnostic.resultLimitReached
                    returnedTweets = diagnostic.returnedTweets
                    stalledStrategyCount = diagnostic.stalledStrategyCount
                    strategies = diagnostic.strategies.map { it.toMutableList() }
                    strategyCount = diagnostic.strategyCount
                    uniqueTweets = diagnostic.uniqueTweets
                    additionalProperties = diagnostic.additionalProperties.toMutableMap()
                }

                /** True when every strategy exhausted its source. */
                fun complete(complete: Boolean) = complete(JsonField.of(complete))

                /**
                 * Sets [Builder.complete] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.complete] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun complete(complete: JsonField<Boolean>) = apply { this.complete = complete }

                fun cursorFailureCount(cursorFailureCount: Long) =
                    cursorFailureCount(JsonField.of(cursorFailureCount))

                /**
                 * Sets [Builder.cursorFailureCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.cursorFailureCount] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun cursorFailureCount(cursorFailureCount: JsonField<Long>) = apply {
                    this.cursorFailureCount = cursorFailureCount
                }

                fun deadlineReached(deadlineReached: Boolean) =
                    deadlineReached(JsonField.of(deadlineReached))

                /**
                 * Sets [Builder.deadlineReached] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.deadlineReached] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun deadlineReached(deadlineReached: JsonField<Boolean>) = apply {
                    this.deadlineReached = deadlineReached
                }

                fun duplicateCount(duplicateCount: Long) =
                    duplicateCount(JsonField.of(duplicateCount))

                /**
                 * Sets [Builder.duplicateCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.duplicateCount] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun duplicateCount(duplicateCount: JsonField<Long>) = apply {
                    this.duplicateCount = duplicateCount
                }

                fun failedStrategyCount(failedStrategyCount: Long) =
                    failedStrategyCount(JsonField.of(failedStrategyCount))

                /**
                 * Sets [Builder.failedStrategyCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.failedStrategyCount] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun failedStrategyCount(failedStrategyCount: JsonField<Long>) = apply {
                    this.failedStrategyCount = failedStrategyCount
                }

                fun malformedCount(malformedCount: Long) =
                    malformedCount(JsonField.of(malformedCount))

                /**
                 * Sets [Builder.malformedCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.malformedCount] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun malformedCount(malformedCount: JsonField<Long>) = apply {
                    this.malformedCount = malformedCount
                }

                fun pagesFetched(pagesFetched: Long) = pagesFetched(JsonField.of(pagesFetched))

                /**
                 * Sets [Builder.pagesFetched] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.pagesFetched] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun pagesFetched(pagesFetched: JsonField<Long>) = apply {
                    this.pagesFetched = pagesFetched
                }

                /** Whether bounded time windows ran in parallel. */
                fun partitioned(partitioned: Boolean) = partitioned(JsonField.of(partitioned))

                /**
                 * Sets [Builder.partitioned] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.partitioned] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun partitioned(partitioned: JsonField<Boolean>) = apply {
                    this.partitioned = partitioned
                }

                /** Whether credits or the requested limit reduced output. */
                fun responseTruncated(responseTruncated: Boolean) =
                    responseTruncated(JsonField.of(responseTruncated))

                /**
                 * Sets [Builder.responseTruncated] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.responseTruncated] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun responseTruncated(responseTruncated: JsonField<Boolean>) = apply {
                    this.responseTruncated = responseTruncated
                }

                fun resultLimitReached(resultLimitReached: Boolean) =
                    resultLimitReached(JsonField.of(resultLimitReached))

                /**
                 * Sets [Builder.resultLimitReached] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.resultLimitReached] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun resultLimitReached(resultLimitReached: JsonField<Boolean>) = apply {
                    this.resultLimitReached = resultLimitReached
                }

                fun returnedTweets(returnedTweets: Long) =
                    returnedTweets(JsonField.of(returnedTweets))

                /**
                 * Sets [Builder.returnedTweets] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.returnedTweets] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun returnedTweets(returnedTweets: JsonField<Long>) = apply {
                    this.returnedTweets = returnedTweets
                }

                fun stalledStrategyCount(stalledStrategyCount: Long) =
                    stalledStrategyCount(JsonField.of(stalledStrategyCount))

                /**
                 * Sets [Builder.stalledStrategyCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.stalledStrategyCount] with a well-typed [Long]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun stalledStrategyCount(stalledStrategyCount: JsonField<Long>) = apply {
                    this.stalledStrategyCount = stalledStrategyCount
                }

                fun strategies(strategies: List<Strategy>) = strategies(JsonField.of(strategies))

                /**
                 * Sets [Builder.strategies] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.strategies] with a well-typed `List<Strategy>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun strategies(strategies: JsonField<List<Strategy>>) = apply {
                    this.strategies = strategies.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Strategy] to [strategies].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addStrategy(strategy: Strategy) = apply {
                    strategies =
                        (strategies ?: JsonField.of(mutableListOf())).also {
                            checkKnown("strategies", it).add(strategy)
                        }
                }

                fun strategyCount(strategyCount: Long) = strategyCount(JsonField.of(strategyCount))

                /**
                 * Sets [Builder.strategyCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.strategyCount] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun strategyCount(strategyCount: JsonField<Long>) = apply {
                    this.strategyCount = strategyCount
                }

                fun uniqueTweets(uniqueTweets: Long) = uniqueTweets(JsonField.of(uniqueTweets))

                /**
                 * Sets [Builder.uniqueTweets] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.uniqueTweets] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun uniqueTweets(uniqueTweets: JsonField<Long>) = apply {
                    this.uniqueTweets = uniqueTweets
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
                 * Returns an immutable instance of [Diagnostic].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .complete()
                 * .cursorFailureCount()
                 * .deadlineReached()
                 * .duplicateCount()
                 * .failedStrategyCount()
                 * .malformedCount()
                 * .pagesFetched()
                 * .partitioned()
                 * .responseTruncated()
                 * .resultLimitReached()
                 * .returnedTweets()
                 * .stalledStrategyCount()
                 * .strategies()
                 * .strategyCount()
                 * .uniqueTweets()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Diagnostic =
                    Diagnostic(
                        checkRequired("complete", complete),
                        checkRequired("cursorFailureCount", cursorFailureCount),
                        checkRequired("deadlineReached", deadlineReached),
                        checkRequired("duplicateCount", duplicateCount),
                        checkRequired("failedStrategyCount", failedStrategyCount),
                        checkRequired("malformedCount", malformedCount),
                        checkRequired("pagesFetched", pagesFetched),
                        checkRequired("partitioned", partitioned),
                        checkRequired("responseTruncated", responseTruncated),
                        checkRequired("resultLimitReached", resultLimitReached),
                        checkRequired("returnedTweets", returnedTweets),
                        checkRequired("stalledStrategyCount", stalledStrategyCount),
                        checkRequired("strategies", strategies).map { it.toImmutable() },
                        checkRequired("strategyCount", strategyCount),
                        checkRequired("uniqueTweets", uniqueTweets),
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
            fun validate(): Diagnostic = apply {
                if (validated) {
                    return@apply
                }

                complete()
                cursorFailureCount()
                deadlineReached()
                duplicateCount()
                failedStrategyCount()
                malformedCount()
                pagesFetched()
                partitioned()
                responseTruncated()
                resultLimitReached()
                returnedTweets()
                stalledStrategyCount()
                strategies().forEach { it.validate() }
                strategyCount()
                uniqueTweets()
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
                (if (complete.asKnown().isPresent) 1 else 0) +
                    (if (cursorFailureCount.asKnown().isPresent) 1 else 0) +
                    (if (deadlineReached.asKnown().isPresent) 1 else 0) +
                    (if (duplicateCount.asKnown().isPresent) 1 else 0) +
                    (if (failedStrategyCount.asKnown().isPresent) 1 else 0) +
                    (if (malformedCount.asKnown().isPresent) 1 else 0) +
                    (if (pagesFetched.asKnown().isPresent) 1 else 0) +
                    (if (partitioned.asKnown().isPresent) 1 else 0) +
                    (if (responseTruncated.asKnown().isPresent) 1 else 0) +
                    (if (resultLimitReached.asKnown().isPresent) 1 else 0) +
                    (if (returnedTweets.asKnown().isPresent) 1 else 0) +
                    (if (stalledStrategyCount.asKnown().isPresent) 1 else 0) +
                    (strategies.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (if (strategyCount.asKnown().isPresent) 1 else 0) +
                    (if (uniqueTweets.asKnown().isPresent) 1 else 0)

            class Strategy
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val duplicateCount: JsonField<Long>,
                private val pagesFetched: JsonField<Long>,
                private val queryType: JsonField<QueryType>,
                private val stopReason: JsonField<StopReason>,
                private val strategy: JsonField<Long>,
                private val uniqueAdded: JsonField<Long>,
                private val window: JsonField<Window>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("duplicateCount")
                    @ExcludeMissing
                    duplicateCount: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("pagesFetched")
                    @ExcludeMissing
                    pagesFetched: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("queryType")
                    @ExcludeMissing
                    queryType: JsonField<QueryType> = JsonMissing.of(),
                    @JsonProperty("stopReason")
                    @ExcludeMissing
                    stopReason: JsonField<StopReason> = JsonMissing.of(),
                    @JsonProperty("strategy")
                    @ExcludeMissing
                    strategy: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("uniqueAdded")
                    @ExcludeMissing
                    uniqueAdded: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("window")
                    @ExcludeMissing
                    window: JsonField<Window> = JsonMissing.of(),
                ) : this(
                    duplicateCount,
                    pagesFetched,
                    queryType,
                    stopReason,
                    strategy,
                    uniqueAdded,
                    window,
                    mutableMapOf(),
                )

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun duplicateCount(): Long = duplicateCount.getRequired("duplicateCount")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun pagesFetched(): Long = pagesFetched.getRequired("pagesFetched")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun queryType(): QueryType = queryType.getRequired("queryType")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun stopReason(): StopReason = stopReason.getRequired("stopReason")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun strategy(): Long = strategy.getRequired("strategy")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null (e.g. if the server responded with an
                 *   unexpected value).
                 */
                fun uniqueAdded(): Long = uniqueAdded.getRequired("uniqueAdded")

                /**
                 * Non-overlapping time partition used by one strategy.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type (e.g. if the server responded with an unexpected value).
                 */
                fun window(): Optional<Window> = window.getOptional("window")

                /**
                 * Returns the raw JSON value of [duplicateCount].
                 *
                 * Unlike [duplicateCount], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("duplicateCount")
                @ExcludeMissing
                fun _duplicateCount(): JsonField<Long> = duplicateCount

                /**
                 * Returns the raw JSON value of [pagesFetched].
                 *
                 * Unlike [pagesFetched], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("pagesFetched")
                @ExcludeMissing
                fun _pagesFetched(): JsonField<Long> = pagesFetched

                /**
                 * Returns the raw JSON value of [queryType].
                 *
                 * Unlike [queryType], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("queryType")
                @ExcludeMissing
                fun _queryType(): JsonField<QueryType> = queryType

                /**
                 * Returns the raw JSON value of [stopReason].
                 *
                 * Unlike [stopReason], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("stopReason")
                @ExcludeMissing
                fun _stopReason(): JsonField<StopReason> = stopReason

                /**
                 * Returns the raw JSON value of [strategy].
                 *
                 * Unlike [strategy], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("strategy")
                @ExcludeMissing
                fun _strategy(): JsonField<Long> = strategy

                /**
                 * Returns the raw JSON value of [uniqueAdded].
                 *
                 * Unlike [uniqueAdded], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("uniqueAdded")
                @ExcludeMissing
                fun _uniqueAdded(): JsonField<Long> = uniqueAdded

                /**
                 * Returns the raw JSON value of [window].
                 *
                 * Unlike [window], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("window") @ExcludeMissing fun _window(): JsonField<Window> = window

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
                     * Returns a mutable builder for constructing an instance of [Strategy].
                     *
                     * The following fields are required:
                     * ```java
                     * .duplicateCount()
                     * .pagesFetched()
                     * .queryType()
                     * .stopReason()
                     * .strategy()
                     * .uniqueAdded()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Strategy]. */
                class Builder internal constructor() {

                    private var duplicateCount: JsonField<Long>? = null
                    private var pagesFetched: JsonField<Long>? = null
                    private var queryType: JsonField<QueryType>? = null
                    private var stopReason: JsonField<StopReason>? = null
                    private var strategy: JsonField<Long>? = null
                    private var uniqueAdded: JsonField<Long>? = null
                    private var window: JsonField<Window> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(strategy: Strategy) = apply {
                        duplicateCount = strategy.duplicateCount
                        pagesFetched = strategy.pagesFetched
                        queryType = strategy.queryType
                        stopReason = strategy.stopReason
                        this.strategy = strategy.strategy
                        uniqueAdded = strategy.uniqueAdded
                        window = strategy.window
                        additionalProperties = strategy.additionalProperties.toMutableMap()
                    }

                    fun duplicateCount(duplicateCount: Long) =
                        duplicateCount(JsonField.of(duplicateCount))

                    /**
                     * Sets [Builder.duplicateCount] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.duplicateCount] with a well-typed [Long]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun duplicateCount(duplicateCount: JsonField<Long>) = apply {
                        this.duplicateCount = duplicateCount
                    }

                    fun pagesFetched(pagesFetched: Long) = pagesFetched(JsonField.of(pagesFetched))

                    /**
                     * Sets [Builder.pagesFetched] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.pagesFetched] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun pagesFetched(pagesFetched: JsonField<Long>) = apply {
                        this.pagesFetched = pagesFetched
                    }

                    fun queryType(queryType: QueryType) = queryType(JsonField.of(queryType))

                    /**
                     * Sets [Builder.queryType] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.queryType] with a well-typed [QueryType]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun queryType(queryType: JsonField<QueryType>) = apply {
                        this.queryType = queryType
                    }

                    fun stopReason(stopReason: StopReason) = stopReason(JsonField.of(stopReason))

                    /**
                     * Sets [Builder.stopReason] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.stopReason] with a well-typed [StopReason]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun stopReason(stopReason: JsonField<StopReason>) = apply {
                        this.stopReason = stopReason
                    }

                    fun strategy(strategy: Long) = strategy(JsonField.of(strategy))

                    /**
                     * Sets [Builder.strategy] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.strategy] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun strategy(strategy: JsonField<Long>) = apply { this.strategy = strategy }

                    fun uniqueAdded(uniqueAdded: Long) = uniqueAdded(JsonField.of(uniqueAdded))

                    /**
                     * Sets [Builder.uniqueAdded] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.uniqueAdded] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun uniqueAdded(uniqueAdded: JsonField<Long>) = apply {
                        this.uniqueAdded = uniqueAdded
                    }

                    /** Non-overlapping time partition used by one strategy. */
                    fun window(window: Window) = window(JsonField.of(window))

                    /**
                     * Sets [Builder.window] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.window] with a well-typed [Window] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun window(window: JsonField<Window>) = apply { this.window = window }

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
                     * Returns an immutable instance of [Strategy].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .duplicateCount()
                     * .pagesFetched()
                     * .queryType()
                     * .stopReason()
                     * .strategy()
                     * .uniqueAdded()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Strategy =
                        Strategy(
                            checkRequired("duplicateCount", duplicateCount),
                            checkRequired("pagesFetched", pagesFetched),
                            checkRequired("queryType", queryType),
                            checkRequired("stopReason", stopReason),
                            checkRequired("strategy", strategy),
                            checkRequired("uniqueAdded", uniqueAdded),
                            window,
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
                fun validate(): Strategy = apply {
                    if (validated) {
                        return@apply
                    }

                    duplicateCount()
                    pagesFetched()
                    queryType().validate()
                    stopReason().validate()
                    strategy()
                    uniqueAdded()
                    window().ifPresent { it.validate() }
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
                    (if (duplicateCount.asKnown().isPresent) 1 else 0) +
                        (if (pagesFetched.asKnown().isPresent) 1 else 0) +
                        (queryType.asKnown().getOrNull()?.validity() ?: 0) +
                        (stopReason.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (strategy.asKnown().isPresent) 1 else 0) +
                        (if (uniqueAdded.asKnown().isPresent) 1 else 0) +
                        (window.asKnown().getOrNull()?.validity() ?: 0)

                class QueryType
                @JsonCreator
                private constructor(private val value: JsonField<String>) : Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

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
                     * An enum containing [QueryType]'s known values, as well as an [_UNKNOWN]
                     * member.
                     *
                     * An instance of [QueryType] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        LATEST,
                        TOP,
                        /**
                         * An enum member indicating that [QueryType] was instantiated with an
                         * unknown value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
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
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws XTwitterScraperInvalidDataException if this class instance's value is
                     *   a not a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            LATEST -> Known.LATEST
                            TOP -> Known.TOP
                            else ->
                                throw XTwitterScraperInvalidDataException(
                                    "Unknown QueryType: $value"
                                )
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws XTwitterScraperInvalidDataException if this class instance's value
                     *   does not have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            XTwitterScraperInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws XTwitterScraperInvalidDataException if any value type in this object
                     *   doesn't match its expected type.
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is QueryType && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                class StopReason
                @JsonCreator
                private constructor(private val value: JsonField<String>) : Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val CURSOR_FAILURE = of("cursor_failure")

                        @JvmField val DEADLINE = of("deadline")

                        @JvmField val EXHAUSTED = of("exhausted")

                        @JvmField val FAILED = of("failed")

                        @JvmField val PAGE_LIMIT = of("page_limit")

                        @JvmField val RESULT_LIMIT = of("result_limit")

                        @JvmField val STALLED = of("stalled")

                        @JvmStatic fun of(value: String) = StopReason(JsonField.of(value))
                    }

                    /** An enum containing [StopReason]'s known values. */
                    enum class Known {
                        CURSOR_FAILURE,
                        DEADLINE,
                        EXHAUSTED,
                        FAILED,
                        PAGE_LIMIT,
                        RESULT_LIMIT,
                        STALLED,
                    }

                    /**
                     * An enum containing [StopReason]'s known values, as well as an [_UNKNOWN]
                     * member.
                     *
                     * An instance of [StopReason] can contain an unknown value in a couple of
                     * cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        CURSOR_FAILURE,
                        DEADLINE,
                        EXHAUSTED,
                        FAILED,
                        PAGE_LIMIT,
                        RESULT_LIMIT,
                        STALLED,
                        /**
                         * An enum member indicating that [StopReason] was instantiated with an
                         * unknown value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            CURSOR_FAILURE -> Value.CURSOR_FAILURE
                            DEADLINE -> Value.DEADLINE
                            EXHAUSTED -> Value.EXHAUSTED
                            FAILED -> Value.FAILED
                            PAGE_LIMIT -> Value.PAGE_LIMIT
                            RESULT_LIMIT -> Value.RESULT_LIMIT
                            STALLED -> Value.STALLED
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws XTwitterScraperInvalidDataException if this class instance's value is
                     *   a not a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            CURSOR_FAILURE -> Known.CURSOR_FAILURE
                            DEADLINE -> Known.DEADLINE
                            EXHAUSTED -> Known.EXHAUSTED
                            FAILED -> Known.FAILED
                            PAGE_LIMIT -> Known.PAGE_LIMIT
                            RESULT_LIMIT -> Known.RESULT_LIMIT
                            STALLED -> Known.STALLED
                            else ->
                                throw XTwitterScraperInvalidDataException(
                                    "Unknown StopReason: $value"
                                )
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws XTwitterScraperInvalidDataException if this class instance's value
                     *   does not have the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString().orElseThrow {
                            XTwitterScraperInvalidDataException("Value is not a String")
                        }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws XTwitterScraperInvalidDataException if any value type in this object
                     *   doesn't match its expected type.
                     */
                    fun validate(): StopReason = apply {
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
                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is StopReason && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                /** Non-overlapping time partition used by one strategy. */
                class Window
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val sinceTime: JsonField<OffsetDateTime>,
                    private val untilTime: JsonField<OffsetDateTime>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("sinceTime")
                        @ExcludeMissing
                        sinceTime: JsonField<OffsetDateTime> = JsonMissing.of(),
                        @JsonProperty("untilTime")
                        @ExcludeMissing
                        untilTime: JsonField<OffsetDateTime> = JsonMissing.of(),
                    ) : this(sinceTime, untilTime, mutableMapOf())

                    /**
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type or is unexpectedly missing or null (e.g. if the server
                     *   responded with an unexpected value).
                     */
                    fun sinceTime(): OffsetDateTime = sinceTime.getRequired("sinceTime")

                    /**
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type or is unexpectedly missing or null (e.g. if the server
                     *   responded with an unexpected value).
                     */
                    fun untilTime(): OffsetDateTime = untilTime.getRequired("untilTime")

                    /**
                     * Returns the raw JSON value of [sinceTime].
                     *
                     * Unlike [sinceTime], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("sinceTime")
                    @ExcludeMissing
                    fun _sinceTime(): JsonField<OffsetDateTime> = sinceTime

                    /**
                     * Returns the raw JSON value of [untilTime].
                     *
                     * Unlike [untilTime], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("untilTime")
                    @ExcludeMissing
                    fun _untilTime(): JsonField<OffsetDateTime> = untilTime

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
                         * Returns a mutable builder for constructing an instance of [Window].
                         *
                         * The following fields are required:
                         * ```java
                         * .sinceTime()
                         * .untilTime()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Window]. */
                    class Builder internal constructor() {

                        private var sinceTime: JsonField<OffsetDateTime>? = null
                        private var untilTime: JsonField<OffsetDateTime>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(window: Window) = apply {
                            sinceTime = window.sinceTime
                            untilTime = window.untilTime
                            additionalProperties = window.additionalProperties.toMutableMap()
                        }

                        fun sinceTime(sinceTime: OffsetDateTime) =
                            sinceTime(JsonField.of(sinceTime))

                        /**
                         * Sets [Builder.sinceTime] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.sinceTime] with a well-typed
                         * [OffsetDateTime] value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun sinceTime(sinceTime: JsonField<OffsetDateTime>) = apply {
                            this.sinceTime = sinceTime
                        }

                        fun untilTime(untilTime: OffsetDateTime) =
                            untilTime(JsonField.of(untilTime))

                        /**
                         * Sets [Builder.untilTime] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.untilTime] with a well-typed
                         * [OffsetDateTime] value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun untilTime(untilTime: JsonField<OffsetDateTime>) = apply {
                            this.untilTime = untilTime
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Window].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .sinceTime()
                         * .untilTime()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Window =
                            Window(
                                checkRequired("sinceTime", sinceTime),
                                checkRequired("untilTime", untilTime),
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws XTwitterScraperInvalidDataException if any value type in this object
                     *   doesn't match its expected type.
                     */
                    fun validate(): Window = apply {
                        if (validated) {
                            return@apply
                        }

                        sinceTime()
                        untilTime()
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
                        (if (sinceTime.asKnown().isPresent) 1 else 0) +
                            (if (untilTime.asKnown().isPresent) 1 else 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Window &&
                            sinceTime == other.sinceTime &&
                            untilTime == other.untilTime &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(sinceTime, untilTime, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Window{sinceTime=$sinceTime, untilTime=$untilTime, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Strategy &&
                        duplicateCount == other.duplicateCount &&
                        pagesFetched == other.pagesFetched &&
                        queryType == other.queryType &&
                        stopReason == other.stopReason &&
                        strategy == other.strategy &&
                        uniqueAdded == other.uniqueAdded &&
                        window == other.window &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        duplicateCount,
                        pagesFetched,
                        queryType,
                        stopReason,
                        strategy,
                        uniqueAdded,
                        window,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Strategy{duplicateCount=$duplicateCount, pagesFetched=$pagesFetched, queryType=$queryType, stopReason=$stopReason, strategy=$strategy, uniqueAdded=$uniqueAdded, window=$window, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Diagnostic &&
                    complete == other.complete &&
                    cursorFailureCount == other.cursorFailureCount &&
                    deadlineReached == other.deadlineReached &&
                    duplicateCount == other.duplicateCount &&
                    failedStrategyCount == other.failedStrategyCount &&
                    malformedCount == other.malformedCount &&
                    pagesFetched == other.pagesFetched &&
                    partitioned == other.partitioned &&
                    responseTruncated == other.responseTruncated &&
                    resultLimitReached == other.resultLimitReached &&
                    returnedTweets == other.returnedTweets &&
                    stalledStrategyCount == other.stalledStrategyCount &&
                    strategies == other.strategies &&
                    strategyCount == other.strategyCount &&
                    uniqueTweets == other.uniqueTweets &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    complete,
                    cursorFailureCount,
                    deadlineReached,
                    duplicateCount,
                    failedStrategyCount,
                    malformedCount,
                    pagesFetched,
                    partitioned,
                    responseTruncated,
                    resultLimitReached,
                    returnedTweets,
                    stalledStrategyCount,
                    strategies,
                    strategyCount,
                    uniqueTweets,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Diagnostic{complete=$complete, cursorFailureCount=$cursorFailureCount, deadlineReached=$deadlineReached, duplicateCount=$duplicateCount, failedStrategyCount=$failedStrategyCount, malformedCount=$malformedCount, pagesFetched=$pagesFetched, partitioned=$partitioned, responseTruncated=$responseTruncated, resultLimitReached=$resultLimitReached, returnedTweets=$returnedTweets, stalledStrategyCount=$stalledStrategyCount, strategies=$strategies, strategyCount=$strategyCount, uniqueTweets=$uniqueTweets, additionalProperties=$additionalProperties}"
        }

        class HasNextPage @JsonCreator private constructor(private val value: JsonField<Boolean>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Boolean> = value

            companion object {

                @JvmField val FALSE = of(false)

                @JvmStatic fun of(value: Boolean) = HasNextPage(JsonField.of(value))
            }

            /** An enum containing [HasNextPage]'s known values. */
            enum class Known {
                FALSE
            }

            /**
             * An enum containing [HasNextPage]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [HasNextPage] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                FALSE,
                /**
                 * An enum member indicating that [HasNextPage] was instantiated with an unknown
                 * value.
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
                    FALSE -> Value.FALSE
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
                    FALSE -> Known.FALSE
                    else -> throw XTwitterScraperInvalidDataException("Unknown HasNextPage: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value does not
             *   have the expected primitive type.
             */
            fun asBoolean(): Boolean =
                _value().asBoolean().orElseThrow {
                    XTwitterScraperInvalidDataException("Value is not a Boolean")
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
            fun validate(): HasNextPage = apply {
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

                return other is HasNextPage && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class NextCursor @JsonCreator private constructor(private val value: JsonField<String>) :
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

                @JvmField val EMPTY = of("")

                @JvmStatic fun of(value: String) = NextCursor(JsonField.of(value))
            }

            /** An enum containing [NextCursor]'s known values. */
            enum class Known {
                EMPTY
            }

            /**
             * An enum containing [NextCursor]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [NextCursor] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                EMPTY,
                /**
                 * An enum member indicating that [NextCursor] was instantiated with an unknown
                 * value.
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
                    EMPTY -> Value.EMPTY
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
                    EMPTY -> Known.EMPTY
                    else -> throw XTwitterScraperInvalidDataException("Unknown NextCursor: $value")
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
            fun validate(): NextCursor = apply {
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

                return other is NextCursor && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TweetSearchCoverageResponse &&
                hasNextPage == other.hasNextPage &&
                nextCursor == other.nextCursor &&
                tweets == other.tweets &&
                diagnostic == other.diagnostic &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(hasNextPage, nextCursor, tweets, diagnostic, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TweetSearchCoverageResponse{hasNextPage=$hasNextPage, nextCursor=$nextCursor, tweets=$tweets, diagnostic=$diagnostic, additionalProperties=$additionalProperties}"
    }
}
