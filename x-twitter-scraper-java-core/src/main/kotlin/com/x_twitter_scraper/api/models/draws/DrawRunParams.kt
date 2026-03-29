// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.draws

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Run giveaway draw */
class DrawRunParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tweetUrl(): String = body.tweetUrl()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun backupCount(): Optional<Long> = body.backupCount()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun filterAccountAgeDays(): Optional<Long> = body.filterAccountAgeDays()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun filterLanguage(): Optional<String> = body.filterLanguage()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun filterMinFollowers(): Optional<Long> = body.filterMinFollowers()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun mustFollowUsername(): Optional<String> = body.mustFollowUsername()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun mustRetweet(): Optional<Boolean> = body.mustRetweet()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun requiredHashtags(): Optional<List<String>> = body.requiredHashtags()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun requiredKeywords(): Optional<List<String>> = body.requiredKeywords()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun requiredMentions(): Optional<List<String>> = body.requiredMentions()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun uniqueAuthorsOnly(): Optional<Boolean> = body.uniqueAuthorsOnly()

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun winnerCount(): Optional<Long> = body.winnerCount()

    /**
     * Returns the raw JSON value of [tweetUrl].
     *
     * Unlike [tweetUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tweetUrl(): JsonField<String> = body._tweetUrl()

    /**
     * Returns the raw JSON value of [backupCount].
     *
     * Unlike [backupCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _backupCount(): JsonField<Long> = body._backupCount()

    /**
     * Returns the raw JSON value of [filterAccountAgeDays].
     *
     * Unlike [filterAccountAgeDays], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _filterAccountAgeDays(): JsonField<Long> = body._filterAccountAgeDays()

    /**
     * Returns the raw JSON value of [filterLanguage].
     *
     * Unlike [filterLanguage], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _filterLanguage(): JsonField<String> = body._filterLanguage()

    /**
     * Returns the raw JSON value of [filterMinFollowers].
     *
     * Unlike [filterMinFollowers], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _filterMinFollowers(): JsonField<Long> = body._filterMinFollowers()

    /**
     * Returns the raw JSON value of [mustFollowUsername].
     *
     * Unlike [mustFollowUsername], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _mustFollowUsername(): JsonField<String> = body._mustFollowUsername()

    /**
     * Returns the raw JSON value of [mustRetweet].
     *
     * Unlike [mustRetweet], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _mustRetweet(): JsonField<Boolean> = body._mustRetweet()

    /**
     * Returns the raw JSON value of [requiredHashtags].
     *
     * Unlike [requiredHashtags], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _requiredHashtags(): JsonField<List<String>> = body._requiredHashtags()

    /**
     * Returns the raw JSON value of [requiredKeywords].
     *
     * Unlike [requiredKeywords], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _requiredKeywords(): JsonField<List<String>> = body._requiredKeywords()

    /**
     * Returns the raw JSON value of [requiredMentions].
     *
     * Unlike [requiredMentions], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _requiredMentions(): JsonField<List<String>> = body._requiredMentions()

    /**
     * Returns the raw JSON value of [uniqueAuthorsOnly].
     *
     * Unlike [uniqueAuthorsOnly], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _uniqueAuthorsOnly(): JsonField<Boolean> = body._uniqueAuthorsOnly()

    /**
     * Returns the raw JSON value of [winnerCount].
     *
     * Unlike [winnerCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _winnerCount(): JsonField<Long> = body._winnerCount()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [DrawRunParams].
         *
         * The following fields are required:
         * ```java
         * .tweetUrl()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DrawRunParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(drawRunParams: DrawRunParams) = apply {
            body = drawRunParams.body.toBuilder()
            additionalHeaders = drawRunParams.additionalHeaders.toBuilder()
            additionalQueryParams = drawRunParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [tweetUrl]
         * - [backupCount]
         * - [filterAccountAgeDays]
         * - [filterLanguage]
         * - [filterMinFollowers]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        fun tweetUrl(tweetUrl: String) = apply { body.tweetUrl(tweetUrl) }

        /**
         * Sets [Builder.tweetUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tweetUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tweetUrl(tweetUrl: JsonField<String>) = apply { body.tweetUrl(tweetUrl) }

        fun backupCount(backupCount: Long) = apply { body.backupCount(backupCount) }

        /**
         * Sets [Builder.backupCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.backupCount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun backupCount(backupCount: JsonField<Long>) = apply { body.backupCount(backupCount) }

        fun filterAccountAgeDays(filterAccountAgeDays: Long) = apply {
            body.filterAccountAgeDays(filterAccountAgeDays)
        }

        /**
         * Sets [Builder.filterAccountAgeDays] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filterAccountAgeDays] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun filterAccountAgeDays(filterAccountAgeDays: JsonField<Long>) = apply {
            body.filterAccountAgeDays(filterAccountAgeDays)
        }

        fun filterLanguage(filterLanguage: String) = apply { body.filterLanguage(filterLanguage) }

        /**
         * Sets [Builder.filterLanguage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filterLanguage] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun filterLanguage(filterLanguage: JsonField<String>) = apply {
            body.filterLanguage(filterLanguage)
        }

        fun filterMinFollowers(filterMinFollowers: Long) = apply {
            body.filterMinFollowers(filterMinFollowers)
        }

        /**
         * Sets [Builder.filterMinFollowers] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filterMinFollowers] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun filterMinFollowers(filterMinFollowers: JsonField<Long>) = apply {
            body.filterMinFollowers(filterMinFollowers)
        }

        fun mustFollowUsername(mustFollowUsername: String) = apply {
            body.mustFollowUsername(mustFollowUsername)
        }

        /**
         * Sets [Builder.mustFollowUsername] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mustFollowUsername] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun mustFollowUsername(mustFollowUsername: JsonField<String>) = apply {
            body.mustFollowUsername(mustFollowUsername)
        }

        fun mustRetweet(mustRetweet: Boolean) = apply { body.mustRetweet(mustRetweet) }

        /**
         * Sets [Builder.mustRetweet] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mustRetweet] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun mustRetweet(mustRetweet: JsonField<Boolean>) = apply { body.mustRetweet(mustRetweet) }

        fun requiredHashtags(requiredHashtags: List<String>) = apply {
            body.requiredHashtags(requiredHashtags)
        }

        /**
         * Sets [Builder.requiredHashtags] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requiredHashtags] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun requiredHashtags(requiredHashtags: JsonField<List<String>>) = apply {
            body.requiredHashtags(requiredHashtags)
        }

        /**
         * Adds a single [String] to [requiredHashtags].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRequiredHashtag(requiredHashtag: String) = apply {
            body.addRequiredHashtag(requiredHashtag)
        }

        fun requiredKeywords(requiredKeywords: List<String>) = apply {
            body.requiredKeywords(requiredKeywords)
        }

        /**
         * Sets [Builder.requiredKeywords] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requiredKeywords] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun requiredKeywords(requiredKeywords: JsonField<List<String>>) = apply {
            body.requiredKeywords(requiredKeywords)
        }

        /**
         * Adds a single [String] to [requiredKeywords].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRequiredKeyword(requiredKeyword: String) = apply {
            body.addRequiredKeyword(requiredKeyword)
        }

        fun requiredMentions(requiredMentions: List<String>) = apply {
            body.requiredMentions(requiredMentions)
        }

        /**
         * Sets [Builder.requiredMentions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requiredMentions] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun requiredMentions(requiredMentions: JsonField<List<String>>) = apply {
            body.requiredMentions(requiredMentions)
        }

        /**
         * Adds a single [String] to [requiredMentions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRequiredMention(requiredMention: String) = apply {
            body.addRequiredMention(requiredMention)
        }

        fun uniqueAuthorsOnly(uniqueAuthorsOnly: Boolean) = apply {
            body.uniqueAuthorsOnly(uniqueAuthorsOnly)
        }

        /**
         * Sets [Builder.uniqueAuthorsOnly] to an arbitrary JSON value.
         *
         * You should usually call [Builder.uniqueAuthorsOnly] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun uniqueAuthorsOnly(uniqueAuthorsOnly: JsonField<Boolean>) = apply {
            body.uniqueAuthorsOnly(uniqueAuthorsOnly)
        }

        fun winnerCount(winnerCount: Long) = apply { body.winnerCount(winnerCount) }

        /**
         * Sets [Builder.winnerCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.winnerCount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun winnerCount(winnerCount: JsonField<Long>) = apply { body.winnerCount(winnerCount) }

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
         * Returns an immutable instance of [DrawRunParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .tweetUrl()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DrawRunParams =
            DrawRunParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val tweetUrl: JsonField<String>,
        private val backupCount: JsonField<Long>,
        private val filterAccountAgeDays: JsonField<Long>,
        private val filterLanguage: JsonField<String>,
        private val filterMinFollowers: JsonField<Long>,
        private val mustFollowUsername: JsonField<String>,
        private val mustRetweet: JsonField<Boolean>,
        private val requiredHashtags: JsonField<List<String>>,
        private val requiredKeywords: JsonField<List<String>>,
        private val requiredMentions: JsonField<List<String>>,
        private val uniqueAuthorsOnly: JsonField<Boolean>,
        private val winnerCount: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("tweetUrl")
            @ExcludeMissing
            tweetUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("backupCount")
            @ExcludeMissing
            backupCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("filterAccountAgeDays")
            @ExcludeMissing
            filterAccountAgeDays: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("filterLanguage")
            @ExcludeMissing
            filterLanguage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("filterMinFollowers")
            @ExcludeMissing
            filterMinFollowers: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("mustFollowUsername")
            @ExcludeMissing
            mustFollowUsername: JsonField<String> = JsonMissing.of(),
            @JsonProperty("mustRetweet")
            @ExcludeMissing
            mustRetweet: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("requiredHashtags")
            @ExcludeMissing
            requiredHashtags: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("requiredKeywords")
            @ExcludeMissing
            requiredKeywords: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("requiredMentions")
            @ExcludeMissing
            requiredMentions: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("uniqueAuthorsOnly")
            @ExcludeMissing
            uniqueAuthorsOnly: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("winnerCount")
            @ExcludeMissing
            winnerCount: JsonField<Long> = JsonMissing.of(),
        ) : this(
            tweetUrl,
            backupCount,
            filterAccountAgeDays,
            filterLanguage,
            filterMinFollowers,
            mustFollowUsername,
            mustRetweet,
            requiredHashtags,
            requiredKeywords,
            requiredMentions,
            uniqueAuthorsOnly,
            winnerCount,
            mutableMapOf(),
        )

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun tweetUrl(): String = tweetUrl.getRequired("tweetUrl")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun backupCount(): Optional<Long> = backupCount.getOptional("backupCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun filterAccountAgeDays(): Optional<Long> =
            filterAccountAgeDays.getOptional("filterAccountAgeDays")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun filterLanguage(): Optional<String> = filterLanguage.getOptional("filterLanguage")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun filterMinFollowers(): Optional<Long> =
            filterMinFollowers.getOptional("filterMinFollowers")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun mustFollowUsername(): Optional<String> =
            mustFollowUsername.getOptional("mustFollowUsername")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun mustRetweet(): Optional<Boolean> = mustRetweet.getOptional("mustRetweet")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun requiredHashtags(): Optional<List<String>> =
            requiredHashtags.getOptional("requiredHashtags")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun requiredKeywords(): Optional<List<String>> =
            requiredKeywords.getOptional("requiredKeywords")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun requiredMentions(): Optional<List<String>> =
            requiredMentions.getOptional("requiredMentions")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun uniqueAuthorsOnly(): Optional<Boolean> =
            uniqueAuthorsOnly.getOptional("uniqueAuthorsOnly")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun winnerCount(): Optional<Long> = winnerCount.getOptional("winnerCount")

        /**
         * Returns the raw JSON value of [tweetUrl].
         *
         * Unlike [tweetUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweetUrl") @ExcludeMissing fun _tweetUrl(): JsonField<String> = tweetUrl

        /**
         * Returns the raw JSON value of [backupCount].
         *
         * Unlike [backupCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("backupCount")
        @ExcludeMissing
        fun _backupCount(): JsonField<Long> = backupCount

        /**
         * Returns the raw JSON value of [filterAccountAgeDays].
         *
         * Unlike [filterAccountAgeDays], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("filterAccountAgeDays")
        @ExcludeMissing
        fun _filterAccountAgeDays(): JsonField<Long> = filterAccountAgeDays

        /**
         * Returns the raw JSON value of [filterLanguage].
         *
         * Unlike [filterLanguage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("filterLanguage")
        @ExcludeMissing
        fun _filterLanguage(): JsonField<String> = filterLanguage

        /**
         * Returns the raw JSON value of [filterMinFollowers].
         *
         * Unlike [filterMinFollowers], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("filterMinFollowers")
        @ExcludeMissing
        fun _filterMinFollowers(): JsonField<Long> = filterMinFollowers

        /**
         * Returns the raw JSON value of [mustFollowUsername].
         *
         * Unlike [mustFollowUsername], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("mustFollowUsername")
        @ExcludeMissing
        fun _mustFollowUsername(): JsonField<String> = mustFollowUsername

        /**
         * Returns the raw JSON value of [mustRetweet].
         *
         * Unlike [mustRetweet], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mustRetweet")
        @ExcludeMissing
        fun _mustRetweet(): JsonField<Boolean> = mustRetweet

        /**
         * Returns the raw JSON value of [requiredHashtags].
         *
         * Unlike [requiredHashtags], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("requiredHashtags")
        @ExcludeMissing
        fun _requiredHashtags(): JsonField<List<String>> = requiredHashtags

        /**
         * Returns the raw JSON value of [requiredKeywords].
         *
         * Unlike [requiredKeywords], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("requiredKeywords")
        @ExcludeMissing
        fun _requiredKeywords(): JsonField<List<String>> = requiredKeywords

        /**
         * Returns the raw JSON value of [requiredMentions].
         *
         * Unlike [requiredMentions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("requiredMentions")
        @ExcludeMissing
        fun _requiredMentions(): JsonField<List<String>> = requiredMentions

        /**
         * Returns the raw JSON value of [uniqueAuthorsOnly].
         *
         * Unlike [uniqueAuthorsOnly], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("uniqueAuthorsOnly")
        @ExcludeMissing
        fun _uniqueAuthorsOnly(): JsonField<Boolean> = uniqueAuthorsOnly

        /**
         * Returns the raw JSON value of [winnerCount].
         *
         * Unlike [winnerCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("winnerCount")
        @ExcludeMissing
        fun _winnerCount(): JsonField<Long> = winnerCount

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
             * .tweetUrl()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var tweetUrl: JsonField<String>? = null
            private var backupCount: JsonField<Long> = JsonMissing.of()
            private var filterAccountAgeDays: JsonField<Long> = JsonMissing.of()
            private var filterLanguage: JsonField<String> = JsonMissing.of()
            private var filterMinFollowers: JsonField<Long> = JsonMissing.of()
            private var mustFollowUsername: JsonField<String> = JsonMissing.of()
            private var mustRetweet: JsonField<Boolean> = JsonMissing.of()
            private var requiredHashtags: JsonField<MutableList<String>>? = null
            private var requiredKeywords: JsonField<MutableList<String>>? = null
            private var requiredMentions: JsonField<MutableList<String>>? = null
            private var uniqueAuthorsOnly: JsonField<Boolean> = JsonMissing.of()
            private var winnerCount: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                tweetUrl = body.tweetUrl
                backupCount = body.backupCount
                filterAccountAgeDays = body.filterAccountAgeDays
                filterLanguage = body.filterLanguage
                filterMinFollowers = body.filterMinFollowers
                mustFollowUsername = body.mustFollowUsername
                mustRetweet = body.mustRetweet
                requiredHashtags = body.requiredHashtags.map { it.toMutableList() }
                requiredKeywords = body.requiredKeywords.map { it.toMutableList() }
                requiredMentions = body.requiredMentions.map { it.toMutableList() }
                uniqueAuthorsOnly = body.uniqueAuthorsOnly
                winnerCount = body.winnerCount
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            fun tweetUrl(tweetUrl: String) = tweetUrl(JsonField.of(tweetUrl))

            /**
             * Sets [Builder.tweetUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tweetUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tweetUrl(tweetUrl: JsonField<String>) = apply { this.tweetUrl = tweetUrl }

            fun backupCount(backupCount: Long) = backupCount(JsonField.of(backupCount))

            /**
             * Sets [Builder.backupCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.backupCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun backupCount(backupCount: JsonField<Long>) = apply { this.backupCount = backupCount }

            fun filterAccountAgeDays(filterAccountAgeDays: Long) =
                filterAccountAgeDays(JsonField.of(filterAccountAgeDays))

            /**
             * Sets [Builder.filterAccountAgeDays] to an arbitrary JSON value.
             *
             * You should usually call [Builder.filterAccountAgeDays] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun filterAccountAgeDays(filterAccountAgeDays: JsonField<Long>) = apply {
                this.filterAccountAgeDays = filterAccountAgeDays
            }

            fun filterLanguage(filterLanguage: String) =
                filterLanguage(JsonField.of(filterLanguage))

            /**
             * Sets [Builder.filterLanguage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.filterLanguage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun filterLanguage(filterLanguage: JsonField<String>) = apply {
                this.filterLanguage = filterLanguage
            }

            fun filterMinFollowers(filterMinFollowers: Long) =
                filterMinFollowers(JsonField.of(filterMinFollowers))

            /**
             * Sets [Builder.filterMinFollowers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.filterMinFollowers] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun filterMinFollowers(filterMinFollowers: JsonField<Long>) = apply {
                this.filterMinFollowers = filterMinFollowers
            }

            fun mustFollowUsername(mustFollowUsername: String) =
                mustFollowUsername(JsonField.of(mustFollowUsername))

            /**
             * Sets [Builder.mustFollowUsername] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mustFollowUsername] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mustFollowUsername(mustFollowUsername: JsonField<String>) = apply {
                this.mustFollowUsername = mustFollowUsername
            }

            fun mustRetweet(mustRetweet: Boolean) = mustRetweet(JsonField.of(mustRetweet))

            /**
             * Sets [Builder.mustRetweet] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mustRetweet] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mustRetweet(mustRetweet: JsonField<Boolean>) = apply {
                this.mustRetweet = mustRetweet
            }

            fun requiredHashtags(requiredHashtags: List<String>) =
                requiredHashtags(JsonField.of(requiredHashtags))

            /**
             * Sets [Builder.requiredHashtags] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requiredHashtags] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun requiredHashtags(requiredHashtags: JsonField<List<String>>) = apply {
                this.requiredHashtags = requiredHashtags.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [requiredHashtags].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRequiredHashtag(requiredHashtag: String) = apply {
                requiredHashtags =
                    (requiredHashtags ?: JsonField.of(mutableListOf())).also {
                        checkKnown("requiredHashtags", it).add(requiredHashtag)
                    }
            }

            fun requiredKeywords(requiredKeywords: List<String>) =
                requiredKeywords(JsonField.of(requiredKeywords))

            /**
             * Sets [Builder.requiredKeywords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requiredKeywords] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun requiredKeywords(requiredKeywords: JsonField<List<String>>) = apply {
                this.requiredKeywords = requiredKeywords.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [requiredKeywords].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRequiredKeyword(requiredKeyword: String) = apply {
                requiredKeywords =
                    (requiredKeywords ?: JsonField.of(mutableListOf())).also {
                        checkKnown("requiredKeywords", it).add(requiredKeyword)
                    }
            }

            fun requiredMentions(requiredMentions: List<String>) =
                requiredMentions(JsonField.of(requiredMentions))

            /**
             * Sets [Builder.requiredMentions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requiredMentions] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun requiredMentions(requiredMentions: JsonField<List<String>>) = apply {
                this.requiredMentions = requiredMentions.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [requiredMentions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRequiredMention(requiredMention: String) = apply {
                requiredMentions =
                    (requiredMentions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("requiredMentions", it).add(requiredMention)
                    }
            }

            fun uniqueAuthorsOnly(uniqueAuthorsOnly: Boolean) =
                uniqueAuthorsOnly(JsonField.of(uniqueAuthorsOnly))

            /**
             * Sets [Builder.uniqueAuthorsOnly] to an arbitrary JSON value.
             *
             * You should usually call [Builder.uniqueAuthorsOnly] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun uniqueAuthorsOnly(uniqueAuthorsOnly: JsonField<Boolean>) = apply {
                this.uniqueAuthorsOnly = uniqueAuthorsOnly
            }

            fun winnerCount(winnerCount: Long) = winnerCount(JsonField.of(winnerCount))

            /**
             * Sets [Builder.winnerCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.winnerCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun winnerCount(winnerCount: JsonField<Long>) = apply { this.winnerCount = winnerCount }

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
             * .tweetUrl()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("tweetUrl", tweetUrl),
                    backupCount,
                    filterAccountAgeDays,
                    filterLanguage,
                    filterMinFollowers,
                    mustFollowUsername,
                    mustRetweet,
                    (requiredHashtags ?: JsonMissing.of()).map { it.toImmutable() },
                    (requiredKeywords ?: JsonMissing.of()).map { it.toImmutable() },
                    (requiredMentions ?: JsonMissing.of()).map { it.toImmutable() },
                    uniqueAuthorsOnly,
                    winnerCount,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            tweetUrl()
            backupCount()
            filterAccountAgeDays()
            filterLanguage()
            filterMinFollowers()
            mustFollowUsername()
            mustRetweet()
            requiredHashtags()
            requiredKeywords()
            requiredMentions()
            uniqueAuthorsOnly()
            winnerCount()
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
            (if (tweetUrl.asKnown().isPresent) 1 else 0) +
                (if (backupCount.asKnown().isPresent) 1 else 0) +
                (if (filterAccountAgeDays.asKnown().isPresent) 1 else 0) +
                (if (filterLanguage.asKnown().isPresent) 1 else 0) +
                (if (filterMinFollowers.asKnown().isPresent) 1 else 0) +
                (if (mustFollowUsername.asKnown().isPresent) 1 else 0) +
                (if (mustRetweet.asKnown().isPresent) 1 else 0) +
                (requiredHashtags.asKnown().getOrNull()?.size ?: 0) +
                (requiredKeywords.asKnown().getOrNull()?.size ?: 0) +
                (requiredMentions.asKnown().getOrNull()?.size ?: 0) +
                (if (uniqueAuthorsOnly.asKnown().isPresent) 1 else 0) +
                (if (winnerCount.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                tweetUrl == other.tweetUrl &&
                backupCount == other.backupCount &&
                filterAccountAgeDays == other.filterAccountAgeDays &&
                filterLanguage == other.filterLanguage &&
                filterMinFollowers == other.filterMinFollowers &&
                mustFollowUsername == other.mustFollowUsername &&
                mustRetweet == other.mustRetweet &&
                requiredHashtags == other.requiredHashtags &&
                requiredKeywords == other.requiredKeywords &&
                requiredMentions == other.requiredMentions &&
                uniqueAuthorsOnly == other.uniqueAuthorsOnly &&
                winnerCount == other.winnerCount &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                tweetUrl,
                backupCount,
                filterAccountAgeDays,
                filterLanguage,
                filterMinFollowers,
                mustFollowUsername,
                mustRetweet,
                requiredHashtags,
                requiredKeywords,
                requiredMentions,
                uniqueAuthorsOnly,
                winnerCount,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{tweetUrl=$tweetUrl, backupCount=$backupCount, filterAccountAgeDays=$filterAccountAgeDays, filterLanguage=$filterLanguage, filterMinFollowers=$filterMinFollowers, mustFollowUsername=$mustFollowUsername, mustRetweet=$mustRetweet, requiredHashtags=$requiredHashtags, requiredKeywords=$requiredKeywords, requiredMentions=$requiredMentions, uniqueAuthorsOnly=$uniqueAuthorsOnly, winnerCount=$winnerCount, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DrawRunParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "DrawRunParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
