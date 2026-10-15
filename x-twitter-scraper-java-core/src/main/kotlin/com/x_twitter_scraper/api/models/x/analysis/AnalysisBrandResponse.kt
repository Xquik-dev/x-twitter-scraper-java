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
import com.x_twitter_scraper.api.core.allMaxBy
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.getOrThrow
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import com.x_twitter_scraper.api.models.SearchTweet
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Analyzed posts, the posts without an analysis & the totals of the answers. Each row in results
 * costs 2 credits.
 */
class AnalysisBrandResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val analysisSummary: JsonField<AnalysisSummary>,
    private val hasNextPage: JsonField<Boolean>,
    private val nextCursor: JsonField<String>,
    private val results: JsonField<List<Result>>,
    private val unanalyzed: JsonField<List<Unanalyzed>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("analysisSummary")
        @ExcludeMissing
        analysisSummary: JsonField<AnalysisSummary> = JsonMissing.of(),
        @JsonProperty("has_next_page")
        @ExcludeMissing
        hasNextPage: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("next_cursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("results")
        @ExcludeMissing
        results: JsonField<List<Result>> = JsonMissing.of(),
        @JsonProperty("unanalyzed")
        @ExcludeMissing
        unanalyzed: JsonField<List<Unanalyzed>> = JsonMissing.of(),
    ) : this(analysisSummary, hasNextPage, nextCursor, results, unanalyzed, mutableMapOf())

    /**
     * Totals of the answers across the analyzed posts.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun analysisSummary(): AnalysisSummary = analysisSummary.getRequired("analysisSummary")

    /**
     * Whether the search has more posts. Send next_cursor as cursor.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun hasNextPage(): Boolean = hasNextPage.getRequired("has_next_page")

    /**
     * Cursor of the search's next page, else empty.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun nextCursor(): String = nextCursor.getRequired("next_cursor")

    /**
     * Each analyzed post with its answers.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun results(): List<Result> = results.getRequired("results")

    /**
     * Each post without an analysis, by ID & reason. These cost nothing.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun unanalyzed(): List<Unanalyzed> = unanalyzed.getRequired("unanalyzed")

    /**
     * Returns the raw JSON value of [analysisSummary].
     *
     * Unlike [analysisSummary], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("analysisSummary")
    @ExcludeMissing
    fun _analysisSummary(): JsonField<AnalysisSummary> = analysisSummary

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
    @JsonProperty("next_cursor") @ExcludeMissing fun _nextCursor(): JsonField<String> = nextCursor

    /**
     * Returns the raw JSON value of [results].
     *
     * Unlike [results], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("results") @ExcludeMissing fun _results(): JsonField<List<Result>> = results

    /**
     * Returns the raw JSON value of [unanalyzed].
     *
     * Unlike [unanalyzed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("unanalyzed")
    @ExcludeMissing
    fun _unanalyzed(): JsonField<List<Unanalyzed>> = unanalyzed

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
         * Returns a mutable builder for constructing an instance of [AnalysisBrandResponse].
         *
         * The following fields are required:
         * ```java
         * .analysisSummary()
         * .hasNextPage()
         * .nextCursor()
         * .results()
         * .unanalyzed()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AnalysisBrandResponse]. */
    class Builder internal constructor() {

        private var analysisSummary: JsonField<AnalysisSummary>? = null
        private var hasNextPage: JsonField<Boolean>? = null
        private var nextCursor: JsonField<String>? = null
        private var results: JsonField<MutableList<Result>>? = null
        private var unanalyzed: JsonField<MutableList<Unanalyzed>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(analysisBrandResponse: AnalysisBrandResponse) = apply {
            analysisSummary = analysisBrandResponse.analysisSummary
            hasNextPage = analysisBrandResponse.hasNextPage
            nextCursor = analysisBrandResponse.nextCursor
            results = analysisBrandResponse.results.map { it.toMutableList() }
            unanalyzed = analysisBrandResponse.unanalyzed.map { it.toMutableList() }
            additionalProperties = analysisBrandResponse.additionalProperties.toMutableMap()
        }

        /** Totals of the answers across the analyzed posts. */
        fun analysisSummary(analysisSummary: AnalysisSummary) =
            analysisSummary(JsonField.of(analysisSummary))

        /** Sets [Builder.analysisSummary] to an arbitrary JSON value. */
        fun analysisSummary(analysisSummary: JsonField<AnalysisSummary>) = apply {
            this.analysisSummary = analysisSummary
        }

        /** Whether the search has more posts. Send next_cursor as cursor. */
        fun hasNextPage(hasNextPage: Boolean) = hasNextPage(JsonField.of(hasNextPage))

        /** Sets [Builder.hasNextPage] to an arbitrary JSON value. */
        fun hasNextPage(hasNextPage: JsonField<Boolean>) = apply { this.hasNextPage = hasNextPage }

        /** Cursor of the search's next page, else empty. */
        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /** Sets [Builder.nextCursor] to an arbitrary JSON value. */
        fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

        /** Each analyzed post with its answers. */
        fun results(results: List<Result>) = results(JsonField.of(results))

        /** Sets [Builder.results] to an arbitrary JSON value. */
        fun results(results: JsonField<List<Result>>) = apply {
            this.results = results.map { it.toMutableList() }
        }

        /**
         * Adds a single [Result] to [results].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addResult(result: Result) = apply {
            results =
                (results ?: JsonField.of(mutableListOf())).also {
                    checkKnown("results", it).add(result)
                }
        }

        /** Each post without an analysis, by ID & reason. These cost nothing. */
        fun unanalyzed(unanalyzed: List<Unanalyzed>) = unanalyzed(JsonField.of(unanalyzed))

        /** Sets [Builder.unanalyzed] to an arbitrary JSON value. */
        fun unanalyzed(unanalyzed: JsonField<List<Unanalyzed>>) = apply {
            this.unanalyzed = unanalyzed.map { it.toMutableList() }
        }

        /**
         * Adds a single [Unanalyzed] to [unanalyzed].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUnanalyzed(unanalyzed: Unanalyzed) = apply {
            this.unanalyzed =
                (this.unanalyzed ?: JsonField.of(mutableListOf())).also {
                    checkKnown("unanalyzed", it).add(unanalyzed)
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
         * Returns an immutable instance of [AnalysisBrandResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .analysisSummary()
         * .hasNextPage()
         * .nextCursor()
         * .results()
         * .unanalyzed()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AnalysisBrandResponse =
            AnalysisBrandResponse(
                checkRequired("analysisSummary", analysisSummary),
                checkRequired("hasNextPage", hasNextPage),
                checkRequired("nextCursor", nextCursor),
                checkRequired("results", results).map { it.toImmutable() },
                checkRequired("unanalyzed", unanalyzed).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
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
    fun validate(): AnalysisBrandResponse = apply {
        if (validated) {
            return@apply
        }

        analysisSummary().validate()
        hasNextPage()
        nextCursor()
        results().forEach { it.validate() }
        unanalyzed().forEach { it.validate() }
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
        (analysisSummary.asKnown().getOrNull()?.validity() ?: 0) +
            (if (hasNextPage.asKnown().isPresent) 1 else 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0) +
            (results.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (unanalyzed.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

    /** Totals of the answers across the analyzed posts. */
    class AnalysisSummary
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val cashtags: JsonField<List<Cashtag>>,
        private val engagement: JsonField<Long>,
        private val monitor: JsonField<Monitor>,
        private val questions: JsonField<Questions>,
        private val rows: JsonField<Rows>,
        private val schemaVersion: JsonField<Long>,
        private val sourceDomains: JsonField<List<SourceDomain>>,
        private val targets: JsonField<List<Target>>,
        private val viral: JsonField<Viral>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("cashtags")
            @ExcludeMissing
            cashtags: JsonField<List<Cashtag>> = JsonMissing.of(),
            @JsonProperty("engagement")
            @ExcludeMissing
            engagement: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("monitor") @ExcludeMissing monitor: JsonField<Monitor> = JsonMissing.of(),
            @JsonProperty("questions")
            @ExcludeMissing
            questions: JsonField<Questions> = JsonMissing.of(),
            @JsonProperty("rows") @ExcludeMissing rows: JsonField<Rows> = JsonMissing.of(),
            @JsonProperty("schemaVersion")
            @ExcludeMissing
            schemaVersion: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("sourceDomains")
            @ExcludeMissing
            sourceDomains: JsonField<List<SourceDomain>> = JsonMissing.of(),
            @JsonProperty("targets")
            @ExcludeMissing
            targets: JsonField<List<Target>> = JsonMissing.of(),
            @JsonProperty("viral") @ExcludeMissing viral: JsonField<Viral> = JsonMissing.of(),
        ) : this(
            cashtags,
            engagement,
            monitor,
            questions,
            rows,
            schemaVersion,
            sourceDomains,
            targets,
            viral,
            mutableMapOf(),
        )

        /**
         * Posts & answers per cashtag, most posts first, up to 20. signal is present for the market
         * questions.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun cashtags(): List<Cashtag> = cashtags.getRequired("cashtags")

        /**
         * Likes, reposts, replies & quotes of the analyzed posts.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun engagement(): Long = engagement.getRequired("engagement")

        /**
         * Posts per comparison status, & up to 50 changed posts with their changes. Null when the
         * answer holds no post.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun monitor(): Optional<Monitor> = monitor.getOptional("monitor")

        /**
         * Totals by question ID. A choice has counts, shares, engagementShares & top posts per
         * category. A score has mean, engagementWeightedMean & levels. A probability has mean, yes
         * & no.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun questions(): Questions = questions.getRequired("questions")

        /**
         * Posts by analysis outcome.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun rows(): Rows = rows.getRequired("rows")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun schemaVersion(): Long = schemaVersion.getRequired("schemaVersion")

        /**
         * Posts per linked hostname, most posts first, up to 20.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun sourceDomains(): List<SourceDomain> = sourceDomains.getRequired("sourceDomains")

        /**
         * Mentions & answers per target in analysis.targets.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun targets(): List<Target> = targets.getRequired("targets")

        /**
         * Only from /x/analysis/viral-score. Scored posts, the average score, verdict counts, the
         * scores against actual engagement, a report per author & the leaderboards.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun viral(): Optional<Viral> = viral.getOptional("viral")

        /**
         * Returns the raw JSON value of [cashtags].
         *
         * Unlike [cashtags], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cashtags")
        @ExcludeMissing
        fun _cashtags(): JsonField<List<Cashtag>> = cashtags

        /**
         * Returns the raw JSON value of [engagement].
         *
         * Unlike [engagement], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("engagement") @ExcludeMissing fun _engagement(): JsonField<Long> = engagement

        /**
         * Returns the raw JSON value of [monitor].
         *
         * Unlike [monitor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("monitor") @ExcludeMissing fun _monitor(): JsonField<Monitor> = monitor

        /**
         * Returns the raw JSON value of [questions].
         *
         * Unlike [questions], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("questions")
        @ExcludeMissing
        fun _questions(): JsonField<Questions> = questions

        /**
         * Returns the raw JSON value of [rows].
         *
         * Unlike [rows], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rows") @ExcludeMissing fun _rows(): JsonField<Rows> = rows

        /**
         * Returns the raw JSON value of [schemaVersion].
         *
         * Unlike [schemaVersion], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("schemaVersion")
        @ExcludeMissing
        fun _schemaVersion(): JsonField<Long> = schemaVersion

        /**
         * Returns the raw JSON value of [sourceDomains].
         *
         * Unlike [sourceDomains], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("sourceDomains")
        @ExcludeMissing
        fun _sourceDomains(): JsonField<List<SourceDomain>> = sourceDomains

        /**
         * Returns the raw JSON value of [targets].
         *
         * Unlike [targets], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("targets") @ExcludeMissing fun _targets(): JsonField<List<Target>> = targets

        /**
         * Returns the raw JSON value of [viral].
         *
         * Unlike [viral], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("viral") @ExcludeMissing fun _viral(): JsonField<Viral> = viral

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
             * Returns a mutable builder for constructing an instance of [AnalysisSummary].
             *
             * The following fields are required:
             * ```java
             * .cashtags()
             * .engagement()
             * .monitor()
             * .questions()
             * .rows()
             * .schemaVersion()
             * .sourceDomains()
             * .targets()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AnalysisSummary]. */
        class Builder internal constructor() {

            private var cashtags: JsonField<MutableList<Cashtag>>? = null
            private var engagement: JsonField<Long>? = null
            private var monitor: JsonField<Monitor>? = null
            private var questions: JsonField<Questions>? = null
            private var rows: JsonField<Rows>? = null
            private var schemaVersion: JsonField<Long>? = null
            private var sourceDomains: JsonField<MutableList<SourceDomain>>? = null
            private var targets: JsonField<MutableList<Target>>? = null
            private var viral: JsonField<Viral> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(analysisSummary: AnalysisSummary) = apply {
                cashtags = analysisSummary.cashtags.map { it.toMutableList() }
                engagement = analysisSummary.engagement
                monitor = analysisSummary.monitor
                questions = analysisSummary.questions
                rows = analysisSummary.rows
                schemaVersion = analysisSummary.schemaVersion
                sourceDomains = analysisSummary.sourceDomains.map { it.toMutableList() }
                targets = analysisSummary.targets.map { it.toMutableList() }
                viral = analysisSummary.viral
                additionalProperties = analysisSummary.additionalProperties.toMutableMap()
            }

            /**
             * Posts & answers per cashtag, most posts first, up to 20. signal is present for the
             * market questions.
             */
            fun cashtags(cashtags: List<Cashtag>) = cashtags(JsonField.of(cashtags))

            /** Sets [Builder.cashtags] to an arbitrary JSON value. */
            fun cashtags(cashtags: JsonField<List<Cashtag>>) = apply {
                this.cashtags = cashtags.map { it.toMutableList() }
            }

            /**
             * Adds a single [Cashtag] to [cashtags].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addCashtag(cashtag: Cashtag) = apply {
                cashtags =
                    (cashtags ?: JsonField.of(mutableListOf())).also {
                        checkKnown("cashtags", it).add(cashtag)
                    }
            }

            /** Likes, reposts, replies & quotes of the analyzed posts. */
            fun engagement(engagement: Long) = engagement(JsonField.of(engagement))

            /** Sets [Builder.engagement] to an arbitrary JSON value. */
            fun engagement(engagement: JsonField<Long>) = apply { this.engagement = engagement }

            /**
             * Posts per comparison status, & up to 50 changed posts with their changes. Null when
             * the answer holds no post.
             */
            fun monitor(monitor: Monitor?) = monitor(JsonField.ofNullable(monitor))

            /** Alias for calling [Builder.monitor] with `monitor.orElse(null)`. */
            fun monitor(monitor: Optional<Monitor>) = monitor(monitor.getOrNull())

            /** Sets [Builder.monitor] to an arbitrary JSON value. */
            fun monitor(monitor: JsonField<Monitor>) = apply { this.monitor = monitor }

            /**
             * Totals by question ID. A choice has counts, shares, engagementShares & top posts per
             * category. A score has mean, engagementWeightedMean & levels. A probability has mean,
             * yes & no.
             */
            fun questions(questions: Questions) = questions(JsonField.of(questions))

            /** Sets [Builder.questions] to an arbitrary JSON value. */
            fun questions(questions: JsonField<Questions>) = apply { this.questions = questions }

            /** Posts by analysis outcome. */
            fun rows(rows: Rows) = rows(JsonField.of(rows))

            /** Sets [Builder.rows] to an arbitrary JSON value. */
            fun rows(rows: JsonField<Rows>) = apply { this.rows = rows }

            fun schemaVersion(schemaVersion: Long) = schemaVersion(JsonField.of(schemaVersion))

            /** Sets [Builder.schemaVersion] to an arbitrary JSON value. */
            fun schemaVersion(schemaVersion: JsonField<Long>) = apply {
                this.schemaVersion = schemaVersion
            }

            /** Posts per linked hostname, most posts first, up to 20. */
            fun sourceDomains(sourceDomains: List<SourceDomain>) =
                sourceDomains(JsonField.of(sourceDomains))

            /** Sets [Builder.sourceDomains] to an arbitrary JSON value. */
            fun sourceDomains(sourceDomains: JsonField<List<SourceDomain>>) = apply {
                this.sourceDomains = sourceDomains.map { it.toMutableList() }
            }

            /**
             * Adds a single [SourceDomain] to [sourceDomains].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSourceDomain(sourceDomain: SourceDomain) = apply {
                sourceDomains =
                    (sourceDomains ?: JsonField.of(mutableListOf())).also {
                        checkKnown("sourceDomains", it).add(sourceDomain)
                    }
            }

            /** Mentions & answers per target in analysis.targets. */
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

            /**
             * Only from /x/analysis/viral-score. Scored posts, the average score, verdict counts,
             * the scores against actual engagement, a report per author & the leaderboards.
             */
            fun viral(viral: Viral) = viral(JsonField.of(viral))

            /** Sets [Builder.viral] to an arbitrary JSON value. */
            fun viral(viral: JsonField<Viral>) = apply { this.viral = viral }

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
             * Returns an immutable instance of [AnalysisSummary].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .cashtags()
             * .engagement()
             * .monitor()
             * .questions()
             * .rows()
             * .schemaVersion()
             * .sourceDomains()
             * .targets()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): AnalysisSummary =
                AnalysisSummary(
                    checkRequired("cashtags", cashtags).map { it.toImmutable() },
                    checkRequired("engagement", engagement),
                    checkRequired("monitor", monitor),
                    checkRequired("questions", questions),
                    checkRequired("rows", rows),
                    checkRequired("schemaVersion", schemaVersion),
                    checkRequired("sourceDomains", sourceDomains).map { it.toImmutable() },
                    checkRequired("targets", targets).map { it.toImmutable() },
                    viral,
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
        fun validate(): AnalysisSummary = apply {
            if (validated) {
                return@apply
            }

            cashtags().forEach { it.validate() }
            engagement()
            monitor().ifPresent { it.validate() }
            questions().validate()
            rows().validate()
            schemaVersion()
            sourceDomains().forEach { it.validate() }
            targets().forEach { it.validate() }
            viral().ifPresent { it.validate() }
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
            (cashtags.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (engagement.asKnown().isPresent) 1 else 0) +
                (monitor.asKnown().getOrNull()?.validity() ?: 0) +
                (questions.asKnown().getOrNull()?.validity() ?: 0) +
                (rows.asKnown().getOrNull()?.validity() ?: 0) +
                (if (schemaVersion.asKnown().isPresent) 1 else 0) +
                (sourceDomains.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (targets.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (viral.asKnown().getOrNull()?.validity() ?: 0)

        class Cashtag
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val cashtag: JsonField<String>,
            private val choices: JsonField<Choices>,
            private val rows: JsonField<Long>,
            private val signal: JsonField<Signal>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("cashtag")
                @ExcludeMissing
                cashtag: JsonField<String> = JsonMissing.of(),
                @JsonProperty("choices")
                @ExcludeMissing
                choices: JsonField<Choices> = JsonMissing.of(),
                @JsonProperty("rows") @ExcludeMissing rows: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("signal")
                @ExcludeMissing
                signal: JsonField<Signal> = JsonMissing.of(),
            ) : this(cashtag, choices, rows, signal, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun cashtag(): String = cashtag.getRequired("cashtag")

            /**
             * Category counts of the cashtag's posts by question ID.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun choices(): Choices = choices.getRequired("choices")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun rows(): Long = rows.getRequired("rows")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun signal(): Optional<Signal> = signal.getOptional("signal")

            /**
             * Returns the raw JSON value of [cashtag].
             *
             * Unlike [cashtag], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("cashtag") @ExcludeMissing fun _cashtag(): JsonField<String> = cashtag

            /**
             * Returns the raw JSON value of [choices].
             *
             * Unlike [choices], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("choices") @ExcludeMissing fun _choices(): JsonField<Choices> = choices

            /**
             * Returns the raw JSON value of [rows].
             *
             * Unlike [rows], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("rows") @ExcludeMissing fun _rows(): JsonField<Long> = rows

            /**
             * Returns the raw JSON value of [signal].
             *
             * Unlike [signal], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("signal") @ExcludeMissing fun _signal(): JsonField<Signal> = signal

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
                 * Returns a mutable builder for constructing an instance of [Cashtag].
                 *
                 * The following fields are required:
                 * ```java
                 * .cashtag()
                 * .choices()
                 * .rows()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Cashtag]. */
            class Builder internal constructor() {

                private var cashtag: JsonField<String>? = null
                private var choices: JsonField<Choices>? = null
                private var rows: JsonField<Long>? = null
                private var signal: JsonField<Signal> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(cashtag: Cashtag) = apply {
                    this.cashtag = cashtag.cashtag
                    choices = cashtag.choices
                    rows = cashtag.rows
                    signal = cashtag.signal
                    additionalProperties = cashtag.additionalProperties.toMutableMap()
                }

                fun cashtag(cashtag: String) = cashtag(JsonField.of(cashtag))

                /** Sets [Builder.cashtag] to an arbitrary JSON value. */
                fun cashtag(cashtag: JsonField<String>) = apply { this.cashtag = cashtag }

                /** Category counts of the cashtag's posts by question ID. */
                fun choices(choices: Choices) = choices(JsonField.of(choices))

                /** Sets [Builder.choices] to an arbitrary JSON value. */
                fun choices(choices: JsonField<Choices>) = apply { this.choices = choices }

                fun rows(rows: Long) = rows(JsonField.of(rows))

                /** Sets [Builder.rows] to an arbitrary JSON value. */
                fun rows(rows: JsonField<Long>) = apply { this.rows = rows }

                fun signal(signal: Signal) = signal(JsonField.of(signal))

                /** Sets [Builder.signal] to an arbitrary JSON value. */
                fun signal(signal: JsonField<Signal>) = apply { this.signal = signal }

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
                 * Returns an immutable instance of [Cashtag].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .cashtag()
                 * .choices()
                 * .rows()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Cashtag =
                    Cashtag(
                        checkRequired("cashtag", cashtag),
                        checkRequired("choices", choices),
                        checkRequired("rows", rows),
                        signal,
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
            fun validate(): Cashtag = apply {
                if (validated) {
                    return@apply
                }

                cashtag()
                choices().validate()
                rows()
                signal().ifPresent { it.validate() }
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
                (if (cashtag.asKnown().isPresent) 1 else 0) +
                    (choices.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (rows.asKnown().isPresent) 1 else 0) +
                    (signal.asKnown().getOrNull()?.validity() ?: 0)

            /** Category counts of the cashtag's posts by question ID. */
            class Choices
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

                    /** Returns a mutable builder for constructing an instance of [Choices]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Choices]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(choices: Choices) = apply {
                        additionalProperties = choices.additionalProperties.toMutableMap()
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
                     * Returns an immutable instance of [Choices].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Choices = Choices(additionalProperties.toImmutable())
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
                fun validate(): Choices = apply {
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

                    return other is Choices && additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() = "Choices{additionalProperties=$additionalProperties}"
            }

            class Signal
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val bearish: JsonField<Long>,
                private val bullish: JsonField<Long>,
                private val score: JsonField<Double>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("bearish")
                    @ExcludeMissing
                    bearish: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("bullish")
                    @ExcludeMissing
                    bullish: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("score")
                    @ExcludeMissing
                    score: JsonField<Double> = JsonMissing.of(),
                ) : this(bearish, bullish, score, mutableMapOf())

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun bearish(): Long = bearish.getRequired("bearish")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun bullish(): Long = bullish.getRequired("bullish")

                /**
                 * Bullish minus bearish posts, over all posts.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun score(): Double = score.getRequired("score")

                /**
                 * Returns the raw JSON value of [bearish].
                 *
                 * Unlike [bearish], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("bearish") @ExcludeMissing fun _bearish(): JsonField<Long> = bearish

                /**
                 * Returns the raw JSON value of [bullish].
                 *
                 * Unlike [bullish], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("bullish") @ExcludeMissing fun _bullish(): JsonField<Long> = bullish

                /**
                 * Returns the raw JSON value of [score].
                 *
                 * Unlike [score], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<Double> = score

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
                     * Returns a mutable builder for constructing an instance of [Signal].
                     *
                     * The following fields are required:
                     * ```java
                     * .bearish()
                     * .bullish()
                     * .score()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Signal]. */
                class Builder internal constructor() {

                    private var bearish: JsonField<Long>? = null
                    private var bullish: JsonField<Long>? = null
                    private var score: JsonField<Double>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(signal: Signal) = apply {
                        bearish = signal.bearish
                        bullish = signal.bullish
                        score = signal.score
                        additionalProperties = signal.additionalProperties.toMutableMap()
                    }

                    fun bearish(bearish: Long) = bearish(JsonField.of(bearish))

                    /** Sets [Builder.bearish] to an arbitrary JSON value. */
                    fun bearish(bearish: JsonField<Long>) = apply { this.bearish = bearish }

                    fun bullish(bullish: Long) = bullish(JsonField.of(bullish))

                    /** Sets [Builder.bullish] to an arbitrary JSON value. */
                    fun bullish(bullish: JsonField<Long>) = apply { this.bullish = bullish }

                    /** Bullish minus bearish posts, over all posts. */
                    fun score(score: Double) = score(JsonField.of(score))

                    /** Sets [Builder.score] to an arbitrary JSON value. */
                    fun score(score: JsonField<Double>) = apply { this.score = score }

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
                     * Returns an immutable instance of [Signal].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .bearish()
                     * .bullish()
                     * .score()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Signal =
                        Signal(
                            checkRequired("bearish", bearish),
                            checkRequired("bullish", bullish),
                            checkRequired("score", score),
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
                fun validate(): Signal = apply {
                    if (validated) {
                        return@apply
                    }

                    bearish()
                    bullish()
                    score()
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
                    (if (bearish.asKnown().isPresent) 1 else 0) +
                        (if (bullish.asKnown().isPresent) 1 else 0) +
                        (if (score.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Signal &&
                        bearish == other.bearish &&
                        bullish == other.bullish &&
                        score == other.score &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(bearish, bullish, score, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Signal{bearish=$bearish, bullish=$bullish, score=$score, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Cashtag &&
                    cashtag == other.cashtag &&
                    choices == other.choices &&
                    rows == other.rows &&
                    signal == other.signal &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(cashtag, choices, rows, signal, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Cashtag{cashtag=$cashtag, choices=$choices, rows=$rows, signal=$signal, additionalProperties=$additionalProperties}"
        }

        /**
         * Posts per comparison status, & up to 50 changed posts with their changes. Null when the
         * answer holds no post.
         */
        class Monitor
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val changedRows: JsonField<List<ChangedRow>>,
            private val statuses: JsonField<Statuses>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("changedRows")
                @ExcludeMissing
                changedRows: JsonField<List<ChangedRow>> = JsonMissing.of(),
                @JsonProperty("statuses")
                @ExcludeMissing
                statuses: JsonField<Statuses> = JsonMissing.of(),
            ) : this(changedRows, statuses, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun changedRows(): List<ChangedRow> = changedRows.getRequired("changedRows")

            /**
             * Posts per monitor status.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun statuses(): Statuses = statuses.getRequired("statuses")

            /**
             * Returns the raw JSON value of [changedRows].
             *
             * Unlike [changedRows], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("changedRows")
            @ExcludeMissing
            fun _changedRows(): JsonField<List<ChangedRow>> = changedRows

            /**
             * Returns the raw JSON value of [statuses].
             *
             * Unlike [statuses], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("statuses")
            @ExcludeMissing
            fun _statuses(): JsonField<Statuses> = statuses

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
                 * Returns a mutable builder for constructing an instance of [Monitor].
                 *
                 * The following fields are required:
                 * ```java
                 * .changedRows()
                 * .statuses()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Monitor]. */
            class Builder internal constructor() {

                private var changedRows: JsonField<MutableList<ChangedRow>>? = null
                private var statuses: JsonField<Statuses>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(monitor: Monitor) = apply {
                    changedRows = monitor.changedRows.map { it.toMutableList() }
                    statuses = monitor.statuses
                    additionalProperties = monitor.additionalProperties.toMutableMap()
                }

                fun changedRows(changedRows: List<ChangedRow>) =
                    changedRows(JsonField.of(changedRows))

                /** Sets [Builder.changedRows] to an arbitrary JSON value. */
                fun changedRows(changedRows: JsonField<List<ChangedRow>>) = apply {
                    this.changedRows = changedRows.map { it.toMutableList() }
                }

                /**
                 * Adds a single [ChangedRow] to [changedRows].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addChangedRow(changedRow: ChangedRow) = apply {
                    changedRows =
                        (changedRows ?: JsonField.of(mutableListOf())).also {
                            checkKnown("changedRows", it).add(changedRow)
                        }
                }

                /** Posts per monitor status. */
                fun statuses(statuses: Statuses) = statuses(JsonField.of(statuses))

                /** Sets [Builder.statuses] to an arbitrary JSON value. */
                fun statuses(statuses: JsonField<Statuses>) = apply { this.statuses = statuses }

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
                 *
                 * The following fields are required:
                 * ```java
                 * .changedRows()
                 * .statuses()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Monitor =
                    Monitor(
                        checkRequired("changedRows", changedRows).map { it.toImmutable() },
                        checkRequired("statuses", statuses),
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
            fun validate(): Monitor = apply {
                if (validated) {
                    return@apply
                }

                changedRows().forEach { it.validate() }
                statuses().validate()
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
                (changedRows.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (statuses.asKnown().getOrNull()?.validity() ?: 0)

            class ChangedRow
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val changes: JsonField<List<Change>>,
                private val tweetId: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("changes")
                    @ExcludeMissing
                    changes: JsonField<List<Change>> = JsonMissing.of(),
                    @JsonProperty("tweetId")
                    @ExcludeMissing
                    tweetId: JsonField<String> = JsonMissing.of(),
                ) : this(changes, tweetId, mutableMapOf())

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun changes(): List<Change> = changes.getRequired("changes")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun tweetId(): String = tweetId.getRequired("tweetId")

                /**
                 * Returns the raw JSON value of [changes].
                 *
                 * Unlike [changes], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("changes")
                @ExcludeMissing
                fun _changes(): JsonField<List<Change>> = changes

                /**
                 * Returns the raw JSON value of [tweetId].
                 *
                 * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

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
                     * Returns a mutable builder for constructing an instance of [ChangedRow].
                     *
                     * The following fields are required:
                     * ```java
                     * .changes()
                     * .tweetId()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [ChangedRow]. */
                class Builder internal constructor() {

                    private var changes: JsonField<MutableList<Change>>? = null
                    private var tweetId: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(changedRow: ChangedRow) = apply {
                        changes = changedRow.changes.map { it.toMutableList() }
                        tweetId = changedRow.tweetId
                        additionalProperties = changedRow.additionalProperties.toMutableMap()
                    }

                    fun changes(changes: List<Change>) = changes(JsonField.of(changes))

                    /** Sets [Builder.changes] to an arbitrary JSON value. */
                    fun changes(changes: JsonField<List<Change>>) = apply {
                        this.changes = changes.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [Change] to [changes].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addChange(change: Change) = apply {
                        changes =
                            (changes ?: JsonField.of(mutableListOf())).also {
                                checkKnown("changes", it).add(change)
                            }
                    }

                    fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

                    /** Sets [Builder.tweetId] to an arbitrary JSON value. */
                    fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

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
                     * Returns an immutable instance of [ChangedRow].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .changes()
                     * .tweetId()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): ChangedRow =
                        ChangedRow(
                            checkRequired("changes", changes).map { it.toImmutable() },
                            checkRequired("tweetId", tweetId),
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
                fun validate(): ChangedRow = apply {
                    if (validated) {
                        return@apply
                    }

                    changes().forEach { it.validate() }
                    tweetId()
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
                    (changes.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                        (if (tweetId.asKnown().isPresent) 1 else 0)

                class Change
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val current: JsonField<String>,
                    private val previous: JsonField<String>,
                    private val questionId: JsonField<String>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("current")
                        @ExcludeMissing
                        current: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("previous")
                        @ExcludeMissing
                        previous: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("questionId")
                        @ExcludeMissing
                        questionId: JsonField<String> = JsonMissing.of(),
                    ) : this(current, previous, questionId, mutableMapOf())

                    /**
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type or is unexpectedly missing or null.
                     */
                    fun current(): String = current.getRequired("current")

                    /**
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type or is unexpectedly missing or null.
                     */
                    fun previous(): String = previous.getRequired("previous")

                    /**
                     * @throws XTwitterScraperInvalidDataException if the JSON field has an
                     *   unexpected type or is unexpectedly missing or null.
                     */
                    fun questionId(): String = questionId.getRequired("questionId")

                    /**
                     * Returns the raw JSON value of [current].
                     *
                     * Unlike [current], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("current")
                    @ExcludeMissing
                    fun _current(): JsonField<String> = current

                    /**
                     * Returns the raw JSON value of [previous].
                     *
                     * Unlike [previous], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("previous")
                    @ExcludeMissing
                    fun _previous(): JsonField<String> = previous

                    /**
                     * Returns the raw JSON value of [questionId].
                     *
                     * Unlike [questionId], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("questionId")
                    @ExcludeMissing
                    fun _questionId(): JsonField<String> = questionId

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
                         * Returns a mutable builder for constructing an instance of [Change].
                         *
                         * The following fields are required:
                         * ```java
                         * .current()
                         * .previous()
                         * .questionId()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Change]. */
                    class Builder internal constructor() {

                        private var current: JsonField<String>? = null
                        private var previous: JsonField<String>? = null
                        private var questionId: JsonField<String>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(change: Change) = apply {
                            current = change.current
                            previous = change.previous
                            questionId = change.questionId
                            additionalProperties = change.additionalProperties.toMutableMap()
                        }

                        fun current(current: String) = current(JsonField.of(current))

                        /** Sets [Builder.current] to an arbitrary JSON value. */
                        fun current(current: JsonField<String>) = apply { this.current = current }

                        fun previous(previous: String) = previous(JsonField.of(previous))

                        /** Sets [Builder.previous] to an arbitrary JSON value. */
                        fun previous(previous: JsonField<String>) = apply {
                            this.previous = previous
                        }

                        fun questionId(questionId: String) = questionId(JsonField.of(questionId))

                        /** Sets [Builder.questionId] to an arbitrary JSON value. */
                        fun questionId(questionId: JsonField<String>) = apply {
                            this.questionId = questionId
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
                        ) = apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Change].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .current()
                         * .previous()
                         * .questionId()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Change =
                            Change(
                                checkRequired("current", current),
                                checkRequired("previous", previous),
                                checkRequired("questionId", questionId),
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
                    fun validate(): Change = apply {
                        if (validated) {
                            return@apply
                        }

                        current()
                        previous()
                        questionId()
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
                        (if (current.asKnown().isPresent) 1 else 0) +
                            (if (previous.asKnown().isPresent) 1 else 0) +
                            (if (questionId.asKnown().isPresent) 1 else 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Change &&
                            current == other.current &&
                            previous == other.previous &&
                            questionId == other.questionId &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(current, previous, questionId, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Change{current=$current, previous=$previous, questionId=$questionId, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is ChangedRow &&
                        changes == other.changes &&
                        tweetId == other.tweetId &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(changes, tweetId, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "ChangedRow{changes=$changes, tweetId=$tweetId, additionalProperties=$additionalProperties}"
            }

            /** Posts per monitor status. */
            class Statuses
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

                    /** Returns a mutable builder for constructing an instance of [Statuses]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Statuses]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(statuses: Statuses) = apply {
                        additionalProperties = statuses.additionalProperties.toMutableMap()
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
                     * Returns an immutable instance of [Statuses].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Statuses = Statuses(additionalProperties.toImmutable())
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
                fun validate(): Statuses = apply {
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

                    return other is Statuses && additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() = "Statuses{additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Monitor &&
                    changedRows == other.changedRows &&
                    statuses == other.statuses &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(changedRows, statuses, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Monitor{changedRows=$changedRows, statuses=$statuses, additionalProperties=$additionalProperties}"
        }

        /**
         * Totals by question ID. A choice has counts, shares, engagementShares & top posts per
         * category. A score has mean, engagementWeightedMean & levels. A probability has mean, yes
         * & no.
         */
        class Questions
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

                /** Returns a mutable builder for constructing an instance of [Questions]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Questions]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(questions: Questions) = apply {
                    additionalProperties = questions.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Questions].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Questions = Questions(additionalProperties.toImmutable())
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
            fun validate(): Questions = apply {
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

                return other is Questions && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Questions{additionalProperties=$additionalProperties}"
        }

        /** Posts by analysis outcome. */
        class Rows
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val analyzed: JsonField<Long>,
            private val failed: JsonField<Long>,
            private val skipped: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("analyzed")
                @ExcludeMissing
                analyzed: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("failed") @ExcludeMissing failed: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("skipped")
                @ExcludeMissing
                skipped: JsonField<Long> = JsonMissing.of(),
            ) : this(analyzed, failed, skipped, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun analyzed(): Long = analyzed.getRequired("analyzed")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun failed(): Long = failed.getRequired("failed")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun skipped(): Long = skipped.getRequired("skipped")

            /**
             * Returns the raw JSON value of [analyzed].
             *
             * Unlike [analyzed], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("analyzed") @ExcludeMissing fun _analyzed(): JsonField<Long> = analyzed

            /**
             * Returns the raw JSON value of [failed].
             *
             * Unlike [failed], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("failed") @ExcludeMissing fun _failed(): JsonField<Long> = failed

            /**
             * Returns the raw JSON value of [skipped].
             *
             * Unlike [skipped], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("skipped") @ExcludeMissing fun _skipped(): JsonField<Long> = skipped

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
                 * Returns a mutable builder for constructing an instance of [Rows].
                 *
                 * The following fields are required:
                 * ```java
                 * .analyzed()
                 * .failed()
                 * .skipped()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Rows]. */
            class Builder internal constructor() {

                private var analyzed: JsonField<Long>? = null
                private var failed: JsonField<Long>? = null
                private var skipped: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(rows: Rows) = apply {
                    analyzed = rows.analyzed
                    failed = rows.failed
                    skipped = rows.skipped
                    additionalProperties = rows.additionalProperties.toMutableMap()
                }

                fun analyzed(analyzed: Long) = analyzed(JsonField.of(analyzed))

                /** Sets [Builder.analyzed] to an arbitrary JSON value. */
                fun analyzed(analyzed: JsonField<Long>) = apply { this.analyzed = analyzed }

                fun failed(failed: Long) = failed(JsonField.of(failed))

                /** Sets [Builder.failed] to an arbitrary JSON value. */
                fun failed(failed: JsonField<Long>) = apply { this.failed = failed }

                fun skipped(skipped: Long) = skipped(JsonField.of(skipped))

                /** Sets [Builder.skipped] to an arbitrary JSON value. */
                fun skipped(skipped: JsonField<Long>) = apply { this.skipped = skipped }

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
                 * Returns an immutable instance of [Rows].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .analyzed()
                 * .failed()
                 * .skipped()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Rows =
                    Rows(
                        checkRequired("analyzed", analyzed),
                        checkRequired("failed", failed),
                        checkRequired("skipped", skipped),
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
            fun validate(): Rows = apply {
                if (validated) {
                    return@apply
                }

                analyzed()
                failed()
                skipped()
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
                (if (analyzed.asKnown().isPresent) 1 else 0) +
                    (if (failed.asKnown().isPresent) 1 else 0) +
                    (if (skipped.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Rows &&
                    analyzed == other.analyzed &&
                    failed == other.failed &&
                    skipped == other.skipped &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(analyzed, failed, skipped, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Rows{analyzed=$analyzed, failed=$failed, skipped=$skipped, additionalProperties=$additionalProperties}"
        }

        class SourceDomain
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val domain: JsonField<String>,
            private val posts: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("domain")
                @ExcludeMissing
                domain: JsonField<String> = JsonMissing.of(),
                @JsonProperty("posts") @ExcludeMissing posts: JsonField<Long> = JsonMissing.of(),
            ) : this(domain, posts, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun domain(): String = domain.getRequired("domain")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun posts(): Long = posts.getRequired("posts")

            /**
             * Returns the raw JSON value of [domain].
             *
             * Unlike [domain], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("domain") @ExcludeMissing fun _domain(): JsonField<String> = domain

            /**
             * Returns the raw JSON value of [posts].
             *
             * Unlike [posts], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("posts") @ExcludeMissing fun _posts(): JsonField<Long> = posts

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
                 * Returns a mutable builder for constructing an instance of [SourceDomain].
                 *
                 * The following fields are required:
                 * ```java
                 * .domain()
                 * .posts()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [SourceDomain]. */
            class Builder internal constructor() {

                private var domain: JsonField<String>? = null
                private var posts: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(sourceDomain: SourceDomain) = apply {
                    domain = sourceDomain.domain
                    posts = sourceDomain.posts
                    additionalProperties = sourceDomain.additionalProperties.toMutableMap()
                }

                fun domain(domain: String) = domain(JsonField.of(domain))

                /** Sets [Builder.domain] to an arbitrary JSON value. */
                fun domain(domain: JsonField<String>) = apply { this.domain = domain }

                fun posts(posts: Long) = posts(JsonField.of(posts))

                /** Sets [Builder.posts] to an arbitrary JSON value. */
                fun posts(posts: JsonField<Long>) = apply { this.posts = posts }

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
                 * Returns an immutable instance of [SourceDomain].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .domain()
                 * .posts()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): SourceDomain =
                    SourceDomain(
                        checkRequired("domain", domain),
                        checkRequired("posts", posts),
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
            fun validate(): SourceDomain = apply {
                if (validated) {
                    return@apply
                }

                domain()
                posts()
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
                (if (domain.asKnown().isPresent) 1 else 0) +
                    (if (posts.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is SourceDomain &&
                    domain == other.domain &&
                    posts == other.posts &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(domain, posts, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "SourceDomain{domain=$domain, posts=$posts, additionalProperties=$additionalProperties}"
        }

        class Target
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val choices: JsonField<Choices>,
            private val engagement: JsonField<Long>,
            private val mentions: JsonField<Long>,
            private val name: JsonField<String>,
            private val share: JsonField<Double>,
            private val top: JsonField<Top>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("choices")
                @ExcludeMissing
                choices: JsonField<Choices> = JsonMissing.of(),
                @JsonProperty("engagement")
                @ExcludeMissing
                engagement: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("mentions")
                @ExcludeMissing
                mentions: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("share") @ExcludeMissing share: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("top") @ExcludeMissing top: JsonField<Top> = JsonMissing.of(),
            ) : this(choices, engagement, mentions, name, share, top, mutableMapOf())

            /**
             * Category counts by question ID.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun choices(): Choices = choices.getRequired("choices")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun engagement(): Long = engagement.getRequired("engagement")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun mentions(): Long = mentions.getRequired("mentions")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun name(): String = name.getRequired("name")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun share(): Double = share.getRequired("share")

            /**
             * The most engaged posts per question ID & category.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun top(): Top = top.getRequired("top")

            /**
             * Returns the raw JSON value of [choices].
             *
             * Unlike [choices], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("choices") @ExcludeMissing fun _choices(): JsonField<Choices> = choices

            /**
             * Returns the raw JSON value of [engagement].
             *
             * Unlike [engagement], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("engagement")
            @ExcludeMissing
            fun _engagement(): JsonField<Long> = engagement

            /**
             * Returns the raw JSON value of [mentions].
             *
             * Unlike [mentions], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("mentions") @ExcludeMissing fun _mentions(): JsonField<Long> = mentions

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [share].
             *
             * Unlike [share], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("share") @ExcludeMissing fun _share(): JsonField<Double> = share

            /**
             * Returns the raw JSON value of [top].
             *
             * Unlike [top], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("top") @ExcludeMissing fun _top(): JsonField<Top> = top

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
                 * .choices()
                 * .engagement()
                 * .mentions()
                 * .name()
                 * .share()
                 * .top()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Target]. */
            class Builder internal constructor() {

                private var choices: JsonField<Choices>? = null
                private var engagement: JsonField<Long>? = null
                private var mentions: JsonField<Long>? = null
                private var name: JsonField<String>? = null
                private var share: JsonField<Double>? = null
                private var top: JsonField<Top>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(target: Target) = apply {
                    choices = target.choices
                    engagement = target.engagement
                    mentions = target.mentions
                    name = target.name
                    share = target.share
                    top = target.top
                    additionalProperties = target.additionalProperties.toMutableMap()
                }

                /** Category counts by question ID. */
                fun choices(choices: Choices) = choices(JsonField.of(choices))

                /** Sets [Builder.choices] to an arbitrary JSON value. */
                fun choices(choices: JsonField<Choices>) = apply { this.choices = choices }

                fun engagement(engagement: Long) = engagement(JsonField.of(engagement))

                /** Sets [Builder.engagement] to an arbitrary JSON value. */
                fun engagement(engagement: JsonField<Long>) = apply { this.engagement = engagement }

                fun mentions(mentions: Long) = mentions(JsonField.of(mentions))

                /** Sets [Builder.mentions] to an arbitrary JSON value. */
                fun mentions(mentions: JsonField<Long>) = apply { this.mentions = mentions }

                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun share(share: Double) = share(JsonField.of(share))

                /** Sets [Builder.share] to an arbitrary JSON value. */
                fun share(share: JsonField<Double>) = apply { this.share = share }

                /** The most engaged posts per question ID & category. */
                fun top(top: Top) = top(JsonField.of(top))

                /** Sets [Builder.top] to an arbitrary JSON value. */
                fun top(top: JsonField<Top>) = apply { this.top = top }

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
                 * .choices()
                 * .engagement()
                 * .mentions()
                 * .name()
                 * .share()
                 * .top()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Target =
                    Target(
                        checkRequired("choices", choices),
                        checkRequired("engagement", engagement),
                        checkRequired("mentions", mentions),
                        checkRequired("name", name),
                        checkRequired("share", share),
                        checkRequired("top", top),
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

                choices().validate()
                engagement()
                mentions()
                name()
                share()
                top().validate()
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
                (choices.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (engagement.asKnown().isPresent) 1 else 0) +
                    (if (mentions.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (share.asKnown().isPresent) 1 else 0) +
                    (top.asKnown().getOrNull()?.validity() ?: 0)

            /** Category counts by question ID. */
            class Choices
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

                    /** Returns a mutable builder for constructing an instance of [Choices]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Choices]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(choices: Choices) = apply {
                        additionalProperties = choices.additionalProperties.toMutableMap()
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
                     * Returns an immutable instance of [Choices].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Choices = Choices(additionalProperties.toImmutable())
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
                fun validate(): Choices = apply {
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

                    return other is Choices && additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() = "Choices{additionalProperties=$additionalProperties}"
            }

            /** The most engaged posts per question ID & category. */
            class Top
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

                    /** Returns a mutable builder for constructing an instance of [Top]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Top]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(top: Top) = apply {
                        additionalProperties = top.additionalProperties.toMutableMap()
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
                     * Returns an immutable instance of [Top].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Top = Top(additionalProperties.toImmutable())
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
                fun validate(): Top = apply {
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

                    return other is Top && additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() = "Top{additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Target &&
                    choices == other.choices &&
                    engagement == other.engagement &&
                    mentions == other.mentions &&
                    name == other.name &&
                    share == other.share &&
                    top == other.top &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(choices, engagement, mentions, name, share, top, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Target{choices=$choices, engagement=$engagement, mentions=$mentions, name=$name, share=$share, top=$top, additionalProperties=$additionalProperties}"
        }

        /**
         * Only from /x/analysis/viral-score. Scored posts, the average score, verdict counts, the
         * scores against actual engagement, a report per author & the leaderboards.
         */
        class Viral
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

                /** Returns a mutable builder for constructing an instance of [Viral]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Viral]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(viral: Viral) = apply {
                    additionalProperties = viral.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Viral].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Viral = Viral(additionalProperties.toImmutable())
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
            fun validate(): Viral = apply {
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

                return other is Viral && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Viral{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AnalysisSummary &&
                cashtags == other.cashtags &&
                engagement == other.engagement &&
                monitor == other.monitor &&
                questions == other.questions &&
                rows == other.rows &&
                schemaVersion == other.schemaVersion &&
                sourceDomains == other.sourceDomains &&
                targets == other.targets &&
                viral == other.viral &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                cashtags,
                engagement,
                monitor,
                questions,
                rows,
                schemaVersion,
                sourceDomains,
                targets,
                viral,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AnalysisSummary{cashtags=$cashtags, engagement=$engagement, monitor=$monitor, questions=$questions, rows=$rows, schemaVersion=$schemaVersion, sourceDomains=$sourceDomains, targets=$targets, viral=$viral, additionalProperties=$additionalProperties}"
    }

    /** 1 analyzed post with its answers. */
    class Result
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val analysis: JsonField<Analysis>,
        private val answers: JsonField<Answers>,
        private val cashtags: JsonField<List<String>>,
        private val monitor: JsonField<Monitor>,
        private val sourceDomains: JsonField<List<String>>,
        private val tweet: JsonField<SearchTweet>,
        private val viral: JsonField<Viral>,
        private val viralActualEngagementRate: JsonField<Double>,
        private val viralAlgorithmScore: JsonField<Double>,
        private val viralScore: JsonField<Long>,
        private val viralVerdict: JsonField<ViralVerdict>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("analysis")
            @ExcludeMissing
            analysis: JsonField<Analysis> = JsonMissing.of(),
            @JsonProperty("answers") @ExcludeMissing answers: JsonField<Answers> = JsonMissing.of(),
            @JsonProperty("cashtags")
            @ExcludeMissing
            cashtags: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("monitor") @ExcludeMissing monitor: JsonField<Monitor> = JsonMissing.of(),
            @JsonProperty("sourceDomains")
            @ExcludeMissing
            sourceDomains: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("tweet") @ExcludeMissing tweet: JsonField<SearchTweet> = JsonMissing.of(),
            @JsonProperty("viral") @ExcludeMissing viral: JsonField<Viral> = JsonMissing.of(),
            @JsonProperty("viralActualEngagementRate")
            @ExcludeMissing
            viralActualEngagementRate: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("viralAlgorithmScore")
            @ExcludeMissing
            viralAlgorithmScore: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("viralScore")
            @ExcludeMissing
            viralScore: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("viralVerdict")
            @ExcludeMissing
            viralVerdict: JsonField<ViralVerdict> = JsonMissing.of(),
        ) : this(
            analysis,
            answers,
            cashtags,
            monitor,
            sourceDomains,
            tweet,
            viral,
            viralActualEngagementRate,
            viralAlgorithmScore,
            viralScore,
            viralVerdict,
            mutableMapOf(),
        )

        /**
         * The answers in full, with their probabilities.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun analysis(): Analysis = analysis.getRequired("analysis")

        /**
         * Each question's decision by question ID. A choice gives its category, a score its level
         * from 0, which can have decimals, & a probability its value from 0 to 1.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun answers(): Answers = answers.getRequired("answers")

        /**
         * Cashtags in the post's text, in upper case.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun cashtags(): List<String> = cashtags.getRequired("cashtags")

        /**
         * How the post's answers compare with its row in baseline, as the AI Actors compare a run
         * with an earlier dataset.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun monitor(): Monitor = monitor.getRequired("monitor")

        /**
         * Hostnames the post links to, without t.co.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun sourceDomains(): List<String> = sourceDomains.getRequired("sourceDomains")

        /**
         * The post, as /x/tweets/search returns it. Your own texts have the IDs text:1, text:2 & so
         * on.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun tweet(): SearchTweet = tweet.getRequired("tweet")

        /**
         * Only from /x/analysis/viral-score. The score with its weights version, the caps that
         * applied & the engagement comparison.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun viral(): Optional<Viral> = viral.getOptional("viral")

        /**
         * Only from /x/analysis/viral-score. log10 of 1 plus the weighted engagement per 1,000
         * followers. Null without a follower count.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun viralActualEngagementRate(): Optional<Double> =
            viralActualEngagementRate.getOptional("viralActualEngagementRate")

        /**
         * Only from /x/analysis/viral-score. The post's public counts under X's published ranking
         * weights, per 1,000 views or followers.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun viralAlgorithmScore(): Optional<Double> =
            viralAlgorithmScore.getOptional("viralAlgorithmScore")

        /**
         * Only from /x/analysis/viral-score. How viral the wording reads, or null when a trait has
         * no answer.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun viralScore(): Optional<Long> = viralScore.getOptional("viralScore")

        /**
         * Only from /x/analysis/viral-score. send_it from 70, edit_first from 40, else sleep_on_it.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun viralVerdict(): Optional<ViralVerdict> = viralVerdict.getOptional("viralVerdict")

        /**
         * Returns the raw JSON value of [analysis].
         *
         * Unlike [analysis], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("analysis") @ExcludeMissing fun _analysis(): JsonField<Analysis> = analysis

        /**
         * Returns the raw JSON value of [answers].
         *
         * Unlike [answers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("answers") @ExcludeMissing fun _answers(): JsonField<Answers> = answers

        /**
         * Returns the raw JSON value of [cashtags].
         *
         * Unlike [cashtags], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cashtags")
        @ExcludeMissing
        fun _cashtags(): JsonField<List<String>> = cashtags

        /**
         * Returns the raw JSON value of [monitor].
         *
         * Unlike [monitor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("monitor") @ExcludeMissing fun _monitor(): JsonField<Monitor> = monitor

        /**
         * Returns the raw JSON value of [sourceDomains].
         *
         * Unlike [sourceDomains], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("sourceDomains")
        @ExcludeMissing
        fun _sourceDomains(): JsonField<List<String>> = sourceDomains

        /**
         * Returns the raw JSON value of [tweet].
         *
         * Unlike [tweet], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweet") @ExcludeMissing fun _tweet(): JsonField<SearchTweet> = tweet

        /**
         * Returns the raw JSON value of [viral].
         *
         * Unlike [viral], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("viral") @ExcludeMissing fun _viral(): JsonField<Viral> = viral

        /**
         * Returns the raw JSON value of [viralActualEngagementRate].
         *
         * Unlike [viralActualEngagementRate], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("viralActualEngagementRate")
        @ExcludeMissing
        fun _viralActualEngagementRate(): JsonField<Double> = viralActualEngagementRate

        /**
         * Returns the raw JSON value of [viralAlgorithmScore].
         *
         * Unlike [viralAlgorithmScore], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("viralAlgorithmScore")
        @ExcludeMissing
        fun _viralAlgorithmScore(): JsonField<Double> = viralAlgorithmScore

        /**
         * Returns the raw JSON value of [viralScore].
         *
         * Unlike [viralScore], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("viralScore") @ExcludeMissing fun _viralScore(): JsonField<Long> = viralScore

        /**
         * Returns the raw JSON value of [viralVerdict].
         *
         * Unlike [viralVerdict], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("viralVerdict")
        @ExcludeMissing
        fun _viralVerdict(): JsonField<ViralVerdict> = viralVerdict

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
             * Returns a mutable builder for constructing an instance of [Result].
             *
             * The following fields are required:
             * ```java
             * .analysis()
             * .answers()
             * .cashtags()
             * .monitor()
             * .sourceDomains()
             * .tweet()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Result]. */
        class Builder internal constructor() {

            private var analysis: JsonField<Analysis>? = null
            private var answers: JsonField<Answers>? = null
            private var cashtags: JsonField<MutableList<String>>? = null
            private var monitor: JsonField<Monitor>? = null
            private var sourceDomains: JsonField<MutableList<String>>? = null
            private var tweet: JsonField<SearchTweet>? = null
            private var viral: JsonField<Viral> = JsonMissing.of()
            private var viralActualEngagementRate: JsonField<Double> = JsonMissing.of()
            private var viralAlgorithmScore: JsonField<Double> = JsonMissing.of()
            private var viralScore: JsonField<Long> = JsonMissing.of()
            private var viralVerdict: JsonField<ViralVerdict> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(result: Result) = apply {
                analysis = result.analysis
                answers = result.answers
                cashtags = result.cashtags.map { it.toMutableList() }
                monitor = result.monitor
                sourceDomains = result.sourceDomains.map { it.toMutableList() }
                tweet = result.tweet
                viral = result.viral
                viralActualEngagementRate = result.viralActualEngagementRate
                viralAlgorithmScore = result.viralAlgorithmScore
                viralScore = result.viralScore
                viralVerdict = result.viralVerdict
                additionalProperties = result.additionalProperties.toMutableMap()
            }

            /** The answers in full, with their probabilities. */
            fun analysis(analysis: Analysis) = analysis(JsonField.of(analysis))

            /** Sets [Builder.analysis] to an arbitrary JSON value. */
            fun analysis(analysis: JsonField<Analysis>) = apply { this.analysis = analysis }

            /**
             * Each question's decision by question ID. A choice gives its category, a score its
             * level from 0, which can have decimals, & a probability its value from 0 to 1.
             */
            fun answers(answers: Answers) = answers(JsonField.of(answers))

            /** Sets [Builder.answers] to an arbitrary JSON value. */
            fun answers(answers: JsonField<Answers>) = apply { this.answers = answers }

            /** Cashtags in the post's text, in upper case. */
            fun cashtags(cashtags: List<String>) = cashtags(JsonField.of(cashtags))

            /** Sets [Builder.cashtags] to an arbitrary JSON value. */
            fun cashtags(cashtags: JsonField<List<String>>) = apply {
                this.cashtags = cashtags.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [cashtags].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addCashtag(cashtag: String) = apply {
                cashtags =
                    (cashtags ?: JsonField.of(mutableListOf())).also {
                        checkKnown("cashtags", it).add(cashtag)
                    }
            }

            /**
             * How the post's answers compare with its row in baseline, as the AI Actors compare a
             * run with an earlier dataset.
             */
            fun monitor(monitor: Monitor) = monitor(JsonField.of(monitor))

            /** Sets [Builder.monitor] to an arbitrary JSON value. */
            fun monitor(monitor: JsonField<Monitor>) = apply { this.monitor = monitor }

            /** Hostnames the post links to, without t.co. */
            fun sourceDomains(sourceDomains: List<String>) =
                sourceDomains(JsonField.of(sourceDomains))

            /** Sets [Builder.sourceDomains] to an arbitrary JSON value. */
            fun sourceDomains(sourceDomains: JsonField<List<String>>) = apply {
                this.sourceDomains = sourceDomains.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [sourceDomains].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSourceDomain(sourceDomain: String) = apply {
                sourceDomains =
                    (sourceDomains ?: JsonField.of(mutableListOf())).also {
                        checkKnown("sourceDomains", it).add(sourceDomain)
                    }
            }

            /**
             * The post, as /x/tweets/search returns it. Your own texts have the IDs text:1, text:2
             * & so on.
             */
            fun tweet(tweet: SearchTweet) = tweet(JsonField.of(tweet))

            /** Sets [Builder.tweet] to an arbitrary JSON value. */
            fun tweet(tweet: JsonField<SearchTweet>) = apply { this.tweet = tweet }

            /**
             * Only from /x/analysis/viral-score. The score with its weights version, the caps that
             * applied & the engagement comparison.
             */
            fun viral(viral: Viral) = viral(JsonField.of(viral))

            /** Sets [Builder.viral] to an arbitrary JSON value. */
            fun viral(viral: JsonField<Viral>) = apply { this.viral = viral }

            /**
             * Only from /x/analysis/viral-score. log10 of 1 plus the weighted engagement per 1,000
             * followers. Null without a follower count.
             */
            fun viralActualEngagementRate(viralActualEngagementRate: Double?) =
                viralActualEngagementRate(JsonField.ofNullable(viralActualEngagementRate))

            /** Alias for [Builder.viralActualEngagementRate]. */
            fun viralActualEngagementRate(viralActualEngagementRate: Double) =
                viralActualEngagementRate(viralActualEngagementRate as Double?)

            /**
             * Alias for calling [Builder.viralActualEngagementRate] with
             * `viralActualEngagementRate.orElse(null)`.
             */
            fun viralActualEngagementRate(viralActualEngagementRate: Optional<Double>) =
                viralActualEngagementRate(viralActualEngagementRate.getOrNull())

            /** Sets [Builder.viralActualEngagementRate] to an arbitrary JSON value. */
            fun viralActualEngagementRate(viralActualEngagementRate: JsonField<Double>) = apply {
                this.viralActualEngagementRate = viralActualEngagementRate
            }

            /**
             * Only from /x/analysis/viral-score. The post's public counts under X's published
             * ranking weights, per 1,000 views or followers.
             */
            fun viralAlgorithmScore(viralAlgorithmScore: Double?) =
                viralAlgorithmScore(JsonField.ofNullable(viralAlgorithmScore))

            /** Alias for [Builder.viralAlgorithmScore]. */
            fun viralAlgorithmScore(viralAlgorithmScore: Double) =
                viralAlgorithmScore(viralAlgorithmScore as Double?)

            /**
             * Alias for calling [Builder.viralAlgorithmScore] with
             * `viralAlgorithmScore.orElse(null)`.
             */
            fun viralAlgorithmScore(viralAlgorithmScore: Optional<Double>) =
                viralAlgorithmScore(viralAlgorithmScore.getOrNull())

            /** Sets [Builder.viralAlgorithmScore] to an arbitrary JSON value. */
            fun viralAlgorithmScore(viralAlgorithmScore: JsonField<Double>) = apply {
                this.viralAlgorithmScore = viralAlgorithmScore
            }

            /**
             * Only from /x/analysis/viral-score. How viral the wording reads, or null when a trait
             * has no answer.
             */
            fun viralScore(viralScore: Long?) = viralScore(JsonField.ofNullable(viralScore))

            /** Alias for [Builder.viralScore]. */
            fun viralScore(viralScore: Long) = viralScore(viralScore as Long?)

            /** Alias for calling [Builder.viralScore] with `viralScore.orElse(null)`. */
            fun viralScore(viralScore: Optional<Long>) = viralScore(viralScore.getOrNull())

            /** Sets [Builder.viralScore] to an arbitrary JSON value. */
            fun viralScore(viralScore: JsonField<Long>) = apply { this.viralScore = viralScore }

            /**
             * Only from /x/analysis/viral-score. send_it from 70, edit_first from 40, else
             * sleep_on_it.
             */
            fun viralVerdict(viralVerdict: ViralVerdict?) =
                viralVerdict(JsonField.ofNullable(viralVerdict))

            /** Alias for calling [Builder.viralVerdict] with `viralVerdict.orElse(null)`. */
            fun viralVerdict(viralVerdict: Optional<ViralVerdict>) =
                viralVerdict(viralVerdict.getOrNull())

            /** Sets [Builder.viralVerdict] to an arbitrary JSON value. */
            fun viralVerdict(viralVerdict: JsonField<ViralVerdict>) = apply {
                this.viralVerdict = viralVerdict
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
             * Returns an immutable instance of [Result].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .analysis()
             * .answers()
             * .cashtags()
             * .monitor()
             * .sourceDomains()
             * .tweet()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Result =
                Result(
                    checkRequired("analysis", analysis),
                    checkRequired("answers", answers),
                    checkRequired("cashtags", cashtags).map { it.toImmutable() },
                    checkRequired("monitor", monitor),
                    checkRequired("sourceDomains", sourceDomains).map { it.toImmutable() },
                    checkRequired("tweet", tweet),
                    viral,
                    viralActualEngagementRate,
                    viralAlgorithmScore,
                    viralScore,
                    viralVerdict,
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
        fun validate(): Result = apply {
            if (validated) {
                return@apply
            }

            analysis().validate()
            answers().validate()
            cashtags()
            monitor().validate()
            sourceDomains()
            tweet().validate()
            viral().ifPresent { it.validate() }
            viralActualEngagementRate()
            viralAlgorithmScore()
            viralScore()
            viralVerdict().ifPresent { it.validate() }
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
                (answers.asKnown().getOrNull()?.validity() ?: 0) +
                (cashtags.asKnown().getOrNull()?.size ?: 0) +
                (monitor.asKnown().getOrNull()?.validity() ?: 0) +
                (sourceDomains.asKnown().getOrNull()?.size ?: 0) +
                (tweet.asKnown().getOrNull()?.validity() ?: 0) +
                (viral.asKnown().getOrNull()?.validity() ?: 0) +
                (if (viralActualEngagementRate.asKnown().isPresent) 1 else 0) +
                (if (viralAlgorithmScore.asKnown().isPresent) 1 else 0) +
                (if (viralScore.asKnown().isPresent) 1 else 0) +
                (viralVerdict.asKnown().getOrNull()?.validity() ?: 0)

        /** The answers in full, with their probabilities. */
        class Analysis
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val answers: JsonField<List<Answer>>,
            private val contextAvailability: JsonField<ContextAvailability>,
            private val contextBytes: JsonField<Long>,
            private val questions: JsonField<List<Question>>,
            private val status: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("answers")
                @ExcludeMissing
                answers: JsonField<List<Answer>> = JsonMissing.of(),
                @JsonProperty("contextAvailability")
                @ExcludeMissing
                contextAvailability: JsonField<ContextAvailability> = JsonMissing.of(),
                @JsonProperty("contextBytes")
                @ExcludeMissing
                contextBytes: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("questions")
                @ExcludeMissing
                questions: JsonField<List<Question>> = JsonMissing.of(),
                @JsonProperty("status") @ExcludeMissing status: JsonValue = JsonMissing.of(),
            ) : this(answers, contextAvailability, contextBytes, questions, status, mutableMapOf())

            /**
             * 1 answer per question, in question order.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun answers(): List<Answer> = answers.getRequired("answers")

            /**
             * What the AI read beside the post's text.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun contextAvailability(): ContextAvailability =
                contextAvailability.getRequired("contextAvailability")

            /**
             * Bytes of post & settings the AI read.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun contextBytes(): Long = contextBytes.getRequired("contextBytes")

            /**
             * The ID & version of each question asked.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun questions(): List<Question> = questions.getRequired("questions")

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("succeeded")
             * ```
             */
            @JsonProperty("status") @ExcludeMissing fun _status(): JsonValue = status

            /**
             * Returns the raw JSON value of [answers].
             *
             * Unlike [answers], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("answers")
            @ExcludeMissing
            fun _answers(): JsonField<List<Answer>> = answers

            /**
             * Returns the raw JSON value of [contextAvailability].
             *
             * Unlike [contextAvailability], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("contextAvailability")
            @ExcludeMissing
            fun _contextAvailability(): JsonField<ContextAvailability> = contextAvailability

            /**
             * Returns the raw JSON value of [contextBytes].
             *
             * Unlike [contextBytes], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("contextBytes")
            @ExcludeMissing
            fun _contextBytes(): JsonField<Long> = contextBytes

            /**
             * Returns the raw JSON value of [questions].
             *
             * Unlike [questions], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("questions")
            @ExcludeMissing
            fun _questions(): JsonField<List<Question>> = questions

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
                 * Returns a mutable builder for constructing an instance of [Analysis].
                 *
                 * The following fields are required:
                 * ```java
                 * .answers()
                 * .contextAvailability()
                 * .contextBytes()
                 * .questions()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Analysis]. */
            class Builder internal constructor() {

                private var answers: JsonField<MutableList<Answer>>? = null
                private var contextAvailability: JsonField<ContextAvailability>? = null
                private var contextBytes: JsonField<Long>? = null
                private var questions: JsonField<MutableList<Question>>? = null
                private var status: JsonValue = JsonValue.from("succeeded")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(analysis: Analysis) = apply {
                    answers = analysis.answers.map { it.toMutableList() }
                    contextAvailability = analysis.contextAvailability
                    contextBytes = analysis.contextBytes
                    questions = analysis.questions.map { it.toMutableList() }
                    status = analysis.status
                    additionalProperties = analysis.additionalProperties.toMutableMap()
                }

                /** 1 answer per question, in question order. */
                fun answers(answers: List<Answer>) = answers(JsonField.of(answers))

                /** Sets [Builder.answers] to an arbitrary JSON value. */
                fun answers(answers: JsonField<List<Answer>>) = apply {
                    this.answers = answers.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Answer] to [answers].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addAnswer(answer: Answer) = apply {
                    answers =
                        (answers ?: JsonField.of(mutableListOf())).also {
                            checkKnown("answers", it).add(answer)
                        }
                }

                /** What the AI read beside the post's text. */
                fun contextAvailability(contextAvailability: ContextAvailability) =
                    contextAvailability(JsonField.of(contextAvailability))

                /** Sets [Builder.contextAvailability] to an arbitrary JSON value. */
                fun contextAvailability(contextAvailability: JsonField<ContextAvailability>) =
                    apply {
                        this.contextAvailability = contextAvailability
                    }

                /** Bytes of post & settings the AI read. */
                fun contextBytes(contextBytes: Long) = contextBytes(JsonField.of(contextBytes))

                /** Sets [Builder.contextBytes] to an arbitrary JSON value. */
                fun contextBytes(contextBytes: JsonField<Long>) = apply {
                    this.contextBytes = contextBytes
                }

                /** The ID & version of each question asked. */
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

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * Defaults to the following:
                 * ```java
                 * JsonValue.from("succeeded")
                 * ```
                 */
                fun status(status: JsonValue) = apply { this.status = status }

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
                 * Returns an immutable instance of [Analysis].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .answers()
                 * .contextAvailability()
                 * .contextBytes()
                 * .questions()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Analysis =
                    Analysis(
                        checkRequired("answers", answers).map { it.toImmutable() },
                        checkRequired("contextAvailability", contextAvailability),
                        checkRequired("contextBytes", contextBytes),
                        checkRequired("questions", questions).map { it.toImmutable() },
                        status,
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
            fun validate(): Analysis = apply {
                if (validated) {
                    return@apply
                }

                answers().forEach { it.validate() }
                contextAvailability().validate()
                contextBytes()
                questions().forEach { it.validate() }
                _status().let {
                    if (it != JsonValue.from("succeeded")) {
                        throw XTwitterScraperInvalidDataException(
                            "'status' is invalid, received $it"
                        )
                    }
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
            internal fun validity(): Int =
                (answers.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (contextAvailability.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (contextBytes.asKnown().isPresent) 1 else 0) +
                    (questions.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    status.let { if (it == JsonValue.from("succeeded")) 1 else 0 }

            /**
             * 1 question's answer. A probability has probability. A choice or score has value,
             * confidence & the probability of each category or level.
             */
            class Answer
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val questionId: JsonField<String>,
                private val questionVersion: JsonField<String>,
                private val type: JsonField<Type>,
                private val confidence: JsonField<Double>,
                private val levels: JsonField<List<String>>,
                private val probabilities: JsonField<Probabilities>,
                private val probability: JsonField<Double>,
                private val value: JsonField<AnswerValue>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("questionId")
                    @ExcludeMissing
                    questionId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("questionVersion")
                    @ExcludeMissing
                    questionVersion: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                    @JsonProperty("confidence")
                    @ExcludeMissing
                    confidence: JsonField<Double> = JsonMissing.of(),
                    @JsonProperty("levels")
                    @ExcludeMissing
                    levels: JsonField<List<String>> = JsonMissing.of(),
                    @JsonProperty("probabilities")
                    @ExcludeMissing
                    probabilities: JsonField<Probabilities> = JsonMissing.of(),
                    @JsonProperty("probability")
                    @ExcludeMissing
                    probability: JsonField<Double> = JsonMissing.of(),
                    @JsonProperty("value")
                    @ExcludeMissing
                    value: JsonField<AnswerValue> = JsonMissing.of(),
                ) : this(
                    questionId,
                    questionVersion,
                    type,
                    confidence,
                    levels,
                    probabilities,
                    probability,
                    value,
                    mutableMapOf(),
                )

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun questionId(): String = questionId.getRequired("questionId")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun questionVersion(): String = questionVersion.getRequired("questionVersion")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun type(): Type = type.getRequired("type")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun confidence(): Optional<Double> = confidence.getOptional("confidence")

                /**
                 * For a score. The levels the question named, from 0.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun levels(): Optional<List<String>> = levels.getOptional("levels")

                /**
                 * Probability of each category, or of each level by index.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun probabilities(): Optional<Probabilities> =
                    probabilities.getOptional("probabilities")

                /**
                 * For a probability. The chance the answer is yes.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun probability(): Optional<Double> = probability.getOptional("probability")

                /**
                 * The chosen category, or the level from 0, which can have decimals, such as 1.4
                 * between levels 1 & 2.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type.
                 */
                fun value(): Optional<AnswerValue> = value.getOptional("value")

                /**
                 * Returns the raw JSON value of [questionId].
                 *
                 * Unlike [questionId], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("questionId")
                @ExcludeMissing
                fun _questionId(): JsonField<String> = questionId

                /**
                 * Returns the raw JSON value of [questionVersion].
                 *
                 * Unlike [questionVersion], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("questionVersion")
                @ExcludeMissing
                fun _questionVersion(): JsonField<String> = questionVersion

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                /**
                 * Returns the raw JSON value of [confidence].
                 *
                 * Unlike [confidence], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("confidence")
                @ExcludeMissing
                fun _confidence(): JsonField<Double> = confidence

                /**
                 * Returns the raw JSON value of [levels].
                 *
                 * Unlike [levels], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("levels")
                @ExcludeMissing
                fun _levels(): JsonField<List<String>> = levels

                /**
                 * Returns the raw JSON value of [probabilities].
                 *
                 * Unlike [probabilities], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("probabilities")
                @ExcludeMissing
                fun _probabilities(): JsonField<Probabilities> = probabilities

                /**
                 * Returns the raw JSON value of [probability].
                 *
                 * Unlike [probability], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("probability")
                @ExcludeMissing
                fun _probability(): JsonField<Double> = probability

                /**
                 * Returns the raw JSON value of [value].
                 *
                 * Unlike [value], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<AnswerValue> = value

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
                     * Returns a mutable builder for constructing an instance of [Answer].
                     *
                     * The following fields are required:
                     * ```java
                     * .questionId()
                     * .questionVersion()
                     * .type()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Answer]. */
                class Builder internal constructor() {

                    private var questionId: JsonField<String>? = null
                    private var questionVersion: JsonField<String>? = null
                    private var type: JsonField<Type>? = null
                    private var confidence: JsonField<Double> = JsonMissing.of()
                    private var levels: JsonField<MutableList<String>>? = null
                    private var probabilities: JsonField<Probabilities> = JsonMissing.of()
                    private var probability: JsonField<Double> = JsonMissing.of()
                    private var value: JsonField<AnswerValue> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(answer: Answer) = apply {
                        questionId = answer.questionId
                        questionVersion = answer.questionVersion
                        type = answer.type
                        confidence = answer.confidence
                        levels = answer.levels.map { it.toMutableList() }
                        probabilities = answer.probabilities
                        probability = answer.probability
                        value = answer.value
                        additionalProperties = answer.additionalProperties.toMutableMap()
                    }

                    fun questionId(questionId: String) = questionId(JsonField.of(questionId))

                    /** Sets [Builder.questionId] to an arbitrary JSON value. */
                    fun questionId(questionId: JsonField<String>) = apply {
                        this.questionId = questionId
                    }

                    fun questionVersion(questionVersion: String) =
                        questionVersion(JsonField.of(questionVersion))

                    /** Sets [Builder.questionVersion] to an arbitrary JSON value. */
                    fun questionVersion(questionVersion: JsonField<String>) = apply {
                        this.questionVersion = questionVersion
                    }

                    fun type(type: Type) = type(JsonField.of(type))

                    /** Sets [Builder.type] to an arbitrary JSON value. */
                    fun type(type: JsonField<Type>) = apply { this.type = type }

                    fun confidence(confidence: Double) = confidence(JsonField.of(confidence))

                    /** Sets [Builder.confidence] to an arbitrary JSON value. */
                    fun confidence(confidence: JsonField<Double>) = apply {
                        this.confidence = confidence
                    }

                    /** For a score. The levels the question named, from 0. */
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

                    /** Probability of each category, or of each level by index. */
                    fun probabilities(probabilities: Probabilities) =
                        probabilities(JsonField.of(probabilities))

                    /** Sets [Builder.probabilities] to an arbitrary JSON value. */
                    fun probabilities(probabilities: JsonField<Probabilities>) = apply {
                        this.probabilities = probabilities
                    }

                    /** For a probability. The chance the answer is yes. */
                    fun probability(probability: Double) = probability(JsonField.of(probability))

                    /** Sets [Builder.probability] to an arbitrary JSON value. */
                    fun probability(probability: JsonField<Double>) = apply {
                        this.probability = probability
                    }

                    /**
                     * The chosen category, or the level from 0, which can have decimals, such as
                     * 1.4 between levels 1 & 2.
                     */
                    fun value(value: AnswerValue) = value(JsonField.of(value))

                    /** Sets [Builder.value] to an arbitrary JSON value. */
                    fun value(value: JsonField<AnswerValue>) = apply { this.value = value }

                    /** Alias for calling [value] with `AnswerValue.ofString(string)`. */
                    fun value(string: String) = value(AnswerValue.ofString(string))

                    /** Alias for calling [value] with `AnswerValue.ofNumber(number)`. */
                    fun value(number: Double) = value(AnswerValue.ofNumber(number))

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
                     * Returns an immutable instance of [Answer].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .questionId()
                     * .questionVersion()
                     * .type()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Answer =
                        Answer(
                            checkRequired("questionId", questionId),
                            checkRequired("questionVersion", questionVersion),
                            checkRequired("type", type),
                            confidence,
                            (levels ?: JsonMissing.of()).map { it.toImmutable() },
                            probabilities,
                            probability,
                            value,
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
                fun validate(): Answer = apply {
                    if (validated) {
                        return@apply
                    }

                    questionId()
                    questionVersion()
                    type().validate()
                    confidence()
                    levels()
                    probabilities().ifPresent { it.validate() }
                    probability()
                    value().ifPresent { it.validate() }
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
                    (if (questionId.asKnown().isPresent) 1 else 0) +
                        (if (questionVersion.asKnown().isPresent) 1 else 0) +
                        (type.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (confidence.asKnown().isPresent) 1 else 0) +
                        (levels.asKnown().getOrNull()?.size ?: 0) +
                        (probabilities.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (probability.asKnown().isPresent) 1 else 0) +
                        (value.asKnown().getOrNull()?.validity() ?: 0)

                class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /** Returns this class instance's raw value. */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

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
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        CHOICE,
                        SCORE,
                        PROBABILITY,
                        /**
                         * An enum member indicating that [Type] was instantiated with an unknown
                         * value.
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
                     * @throws XTwitterScraperInvalidDataException if this class instance's value is
                     *   a not a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            CHOICE -> Known.CHOICE
                            SCORE -> Known.SCORE
                            PROBABILITY -> Known.PROBABILITY
                            else ->
                                throw XTwitterScraperInvalidDataException("Unknown Type: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
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

                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Type && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                /** Probability of each category, or of each level by index. */
                class Probabilities
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

                        /**
                         * Returns a mutable builder for constructing an instance of
                         * [Probabilities].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Probabilities]. */
                    class Builder internal constructor() {

                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(probabilities: Probabilities) = apply {
                            additionalProperties = probabilities.additionalProperties.toMutableMap()
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
                        ) = apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Probabilities].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         */
                        fun build(): Probabilities =
                            Probabilities(additionalProperties.toImmutable())
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
                    fun validate(): Probabilities = apply {
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

                        return other is Probabilities &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Probabilities{additionalProperties=$additionalProperties}"
                }

                /**
                 * The chosen category, or the level from 0, which can have decimals, such as 1.4
                 * between levels 1 & 2.
                 */
                @JsonDeserialize(using = AnswerValue.Deserializer::class)
                @JsonSerialize(using = AnswerValue.Serializer::class)
                class AnswerValue
                private constructor(
                    private val string: String? = null,
                    private val number: Double? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun string(): Optional<String> = Optional.ofNullable(string)

                    fun number(): Optional<Double> = Optional.ofNullable(number)

                    fun isString(): Boolean = string != null

                    fun isNumber(): Boolean = number != null

                    fun asString(): String = string.getOrThrow("string")

                    fun asNumber(): Double = number.getOrThrow("number")

                    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                    /**
                     * Maps this instance's current variant to a value of type [T] using the given
                     * [visitor].
                     *
                     * @throws XTwitterScraperInvalidDataException if [Visitor.unknown] is not
                     *   overridden in [visitor] and the current variant is unknown.
                     */
                    fun <T> accept(visitor: Visitor<T>): T =
                        when {
                            string != null -> visitor.visitString(string)
                            number != null -> visitor.visitNumber(number)
                            else -> visitor.unknown(_json)
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
                    fun validate(): AnswerValue = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitString(string: String) {}

                                override fun visitNumber(number: Double) {}
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

                                override fun visitNumber(number: Double) = 1

                                override fun unknown(json: JsonValue?) = 0
                            }
                        )

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is AnswerValue &&
                            string == other.string &&
                            number == other.number
                    }

                    override fun hashCode(): Int = Objects.hash(string, number)

                    override fun toString(): String =
                        when {
                            string != null -> "AnswerValue{string=$string}"
                            number != null -> "AnswerValue{number=$number}"
                            _json != null -> "AnswerValue{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid AnswerValue")
                        }

                    companion object {

                        @JvmStatic fun ofString(string: String) = AnswerValue(string = string)

                        @JvmStatic fun ofNumber(number: Double) = AnswerValue(number = number)
                    }

                    /**
                     * An interface that defines how to map each variant of [AnswerValue] to a value
                     * of type [T].
                     */
                    interface Visitor<out T> {

                        fun visitString(string: String): T

                        fun visitNumber(number: Double): T

                        /**
                         * Maps an unknown variant of [AnswerValue] to a value of type [T].
                         *
                         * An instance of [AnswerValue] can contain an unknown variant if it was
                         * deserialized from data that doesn't match any known variant.
                         *
                         * @throws XTwitterScraperInvalidDataException in the default
                         *   implementation.
                         */
                        fun unknown(json: JsonValue?): T {
                            throw XTwitterScraperInvalidDataException("Unknown AnswerValue: $json")
                        }
                    }

                    internal class Deserializer :
                        BaseDeserializer<AnswerValue>(AnswerValue::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): AnswerValue {
                            val json = JsonValue.fromJsonNode(node)

                            val bestMatches =
                                sequenceOf(
                                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                            AnswerValue(string = it, _json = json)
                                        },
                                        tryDeserialize(node, jacksonTypeRef<Double>())?.let {
                                            AnswerValue(number = it, _json = json)
                                        },
                                    )
                                    .filterNotNull()
                                    .allMaxBy { it.validity() }
                                    .toList()
                            return when (bestMatches.size) {
                                0 -> AnswerValue(_json = json)
                                1 -> bestMatches.single()
                                else ->
                                    bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                            }
                        }
                    }

                    internal class Serializer : BaseSerializer<AnswerValue>(AnswerValue::class) {

                        override fun serialize(
                            value: AnswerValue,
                            generator: JsonGenerator,
                            provider: SerializerProvider,
                        ) {
                            when {
                                value.string != null -> generator.writeObject(value.string)
                                value.number != null -> generator.writeObject(value.number)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid AnswerValue")
                            }
                        }
                    }
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Answer &&
                        questionId == other.questionId &&
                        questionVersion == other.questionVersion &&
                        type == other.type &&
                        confidence == other.confidence &&
                        levels == other.levels &&
                        probabilities == other.probabilities &&
                        probability == other.probability &&
                        value == other.value &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        questionId,
                        questionVersion,
                        type,
                        confidence,
                        levels,
                        probabilities,
                        probability,
                        value,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Answer{questionId=$questionId, questionVersion=$questionVersion, type=$type, confidence=$confidence, levels=$levels, probabilities=$probabilities, probability=$probability, value=$value, additionalProperties=$additionalProperties}"
            }

            /** What the AI read beside the post's text. */
            class ContextAvailability
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val article: JsonField<Article>,
                private val author: JsonField<Author>,
                private val media: JsonField<Media>,
                private val postText: JsonField<PostText>,
                private val quote: JsonField<Quote>,
                private val reply: JsonField<Reply>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("article")
                    @ExcludeMissing
                    article: JsonField<Article> = JsonMissing.of(),
                    @JsonProperty("author")
                    @ExcludeMissing
                    author: JsonField<Author> = JsonMissing.of(),
                    @JsonProperty("media")
                    @ExcludeMissing
                    media: JsonField<Media> = JsonMissing.of(),
                    @JsonProperty("postText")
                    @ExcludeMissing
                    postText: JsonField<PostText> = JsonMissing.of(),
                    @JsonProperty("quote")
                    @ExcludeMissing
                    quote: JsonField<Quote> = JsonMissing.of(),
                    @JsonProperty("reply")
                    @ExcludeMissing
                    reply: JsonField<Reply> = JsonMissing.of(),
                ) : this(article, author, media, postText, quote, reply, mutableMapOf())

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun article(): Article = article.getRequired("article")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun author(): Author = author.getRequired("author")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun media(): Media = media.getRequired("media")

                /**
                 * truncated when the post was cut to fit.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun postText(): PostText = postText.getRequired("postText")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun quote(): Quote = quote.getRequired("quote")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun reply(): Reply = reply.getRequired("reply")

                /**
                 * Returns the raw JSON value of [article].
                 *
                 * Unlike [article], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("article")
                @ExcludeMissing
                fun _article(): JsonField<Article> = article

                /**
                 * Returns the raw JSON value of [author].
                 *
                 * Unlike [author], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("author") @ExcludeMissing fun _author(): JsonField<Author> = author

                /**
                 * Returns the raw JSON value of [media].
                 *
                 * Unlike [media], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("media") @ExcludeMissing fun _media(): JsonField<Media> = media

                /**
                 * Returns the raw JSON value of [postText].
                 *
                 * Unlike [postText], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("postText")
                @ExcludeMissing
                fun _postText(): JsonField<PostText> = postText

                /**
                 * Returns the raw JSON value of [quote].
                 *
                 * Unlike [quote], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("quote") @ExcludeMissing fun _quote(): JsonField<Quote> = quote

                /**
                 * Returns the raw JSON value of [reply].
                 *
                 * Unlike [reply], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("reply") @ExcludeMissing fun _reply(): JsonField<Reply> = reply

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
                     * [ContextAvailability].
                     *
                     * The following fields are required:
                     * ```java
                     * .article()
                     * .author()
                     * .media()
                     * .postText()
                     * .quote()
                     * .reply()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [ContextAvailability]. */
                class Builder internal constructor() {

                    private var article: JsonField<Article>? = null
                    private var author: JsonField<Author>? = null
                    private var media: JsonField<Media>? = null
                    private var postText: JsonField<PostText>? = null
                    private var quote: JsonField<Quote>? = null
                    private var reply: JsonField<Reply>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(contextAvailability: ContextAvailability) = apply {
                        article = contextAvailability.article
                        author = contextAvailability.author
                        media = contextAvailability.media
                        postText = contextAvailability.postText
                        quote = contextAvailability.quote
                        reply = contextAvailability.reply
                        additionalProperties =
                            contextAvailability.additionalProperties.toMutableMap()
                    }

                    fun article(article: Article) = article(JsonField.of(article))

                    /** Sets [Builder.article] to an arbitrary JSON value. */
                    fun article(article: JsonField<Article>) = apply { this.article = article }

                    fun author(author: Author) = author(JsonField.of(author))

                    /** Sets [Builder.author] to an arbitrary JSON value. */
                    fun author(author: JsonField<Author>) = apply { this.author = author }

                    fun media(media: Media) = media(JsonField.of(media))

                    /** Sets [Builder.media] to an arbitrary JSON value. */
                    fun media(media: JsonField<Media>) = apply { this.media = media }

                    /** truncated when the post was cut to fit. */
                    fun postText(postText: PostText) = postText(JsonField.of(postText))

                    /** Sets [Builder.postText] to an arbitrary JSON value. */
                    fun postText(postText: JsonField<PostText>) = apply { this.postText = postText }

                    fun quote(quote: Quote) = quote(JsonField.of(quote))

                    /** Sets [Builder.quote] to an arbitrary JSON value. */
                    fun quote(quote: JsonField<Quote>) = apply { this.quote = quote }

                    fun reply(reply: Reply) = reply(JsonField.of(reply))

                    /** Sets [Builder.reply] to an arbitrary JSON value. */
                    fun reply(reply: JsonField<Reply>) = apply { this.reply = reply }

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
                     * Returns an immutable instance of [ContextAvailability].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .article()
                     * .author()
                     * .media()
                     * .postText()
                     * .quote()
                     * .reply()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): ContextAvailability =
                        ContextAvailability(
                            checkRequired("article", article),
                            checkRequired("author", author),
                            checkRequired("media", media),
                            checkRequired("postText", postText),
                            checkRequired("quote", quote),
                            checkRequired("reply", reply),
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
                fun validate(): ContextAvailability = apply {
                    if (validated) {
                        return@apply
                    }

                    article().validate()
                    author().validate()
                    media().validate()
                    postText().validate()
                    quote().validate()
                    reply().validate()
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
                    (article.asKnown().getOrNull()?.validity() ?: 0) +
                        (author.asKnown().getOrNull()?.validity() ?: 0) +
                        (media.asKnown().getOrNull()?.validity() ?: 0) +
                        (postText.asKnown().getOrNull()?.validity() ?: 0) +
                        (quote.asKnown().getOrNull()?.validity() ?: 0) +
                        (reply.asKnown().getOrNull()?.validity() ?: 0)

                class Article
                @JsonCreator
                private constructor(private val value: JsonField<String>) : Enum {

                    /** Returns this class instance's raw value. */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val TEXT_BLOCKS = of("text_blocks")

                        @JvmField val SUMMARY = of("summary")

                        @JvmField val NOT_SUPPLIED = of("not_supplied")

                        @JvmStatic fun of(value: String) = Article(JsonField.of(value))
                    }

                    /** An enum containing [Article]'s known values. */
                    enum class Known {
                        TEXT_BLOCKS,
                        SUMMARY,
                        NOT_SUPPLIED,
                    }

                    /**
                     * An enum containing [Article]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Article] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        TEXT_BLOCKS,
                        SUMMARY,
                        NOT_SUPPLIED,
                        /**
                         * An enum member indicating that [Article] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     */
                    fun value(): Value =
                        when (this) {
                            TEXT_BLOCKS -> Value.TEXT_BLOCKS
                            SUMMARY -> Value.SUMMARY
                            NOT_SUPPLIED -> Value.NOT_SUPPLIED
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * @throws XTwitterScraperInvalidDataException if this class instance's value is
                     *   a not a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            TEXT_BLOCKS -> Known.TEXT_BLOCKS
                            SUMMARY -> Known.SUMMARY
                            NOT_SUPPLIED -> Known.NOT_SUPPLIED
                            else ->
                                throw XTwitterScraperInvalidDataException("Unknown Article: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
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
                    fun validate(): Article = apply {
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

                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Article && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                class Author
                @JsonCreator
                private constructor(private val value: JsonField<String>) : Enum {

                    /** Returns this class instance's raw value. */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val AVAILABLE = of("available")

                        @JvmField val MISSING = of("missing")

                        @JvmStatic fun of(value: String) = Author(JsonField.of(value))
                    }

                    /** An enum containing [Author]'s known values. */
                    enum class Known {
                        AVAILABLE,
                        MISSING,
                    }

                    /**
                     * An enum containing [Author]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Author] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        AVAILABLE,
                        MISSING,
                        /**
                         * An enum member indicating that [Author] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     */
                    fun value(): Value =
                        when (this) {
                            AVAILABLE -> Value.AVAILABLE
                            MISSING -> Value.MISSING
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * @throws XTwitterScraperInvalidDataException if this class instance's value is
                     *   a not a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            AVAILABLE -> Known.AVAILABLE
                            MISSING -> Known.MISSING
                            else ->
                                throw XTwitterScraperInvalidDataException("Unknown Author: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
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
                    fun validate(): Author = apply {
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

                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Author && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                class Media @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /** Returns this class instance's raw value. */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val TEXT_DESCRIPTIONS_ONLY = of("text_descriptions_only")

                        @JvmField val NOT_SUPPLIED = of("not_supplied")

                        @JvmStatic fun of(value: String) = Media(JsonField.of(value))
                    }

                    /** An enum containing [Media]'s known values. */
                    enum class Known {
                        TEXT_DESCRIPTIONS_ONLY,
                        NOT_SUPPLIED,
                    }

                    /**
                     * An enum containing [Media]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Media] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        TEXT_DESCRIPTIONS_ONLY,
                        NOT_SUPPLIED,
                        /**
                         * An enum member indicating that [Media] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     */
                    fun value(): Value =
                        when (this) {
                            TEXT_DESCRIPTIONS_ONLY -> Value.TEXT_DESCRIPTIONS_ONLY
                            NOT_SUPPLIED -> Value.NOT_SUPPLIED
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * @throws XTwitterScraperInvalidDataException if this class instance's value is
                     *   a not a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            TEXT_DESCRIPTIONS_ONLY -> Known.TEXT_DESCRIPTIONS_ONLY
                            NOT_SUPPLIED -> Known.NOT_SUPPLIED
                            else ->
                                throw XTwitterScraperInvalidDataException("Unknown Media: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
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
                    fun validate(): Media = apply {
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

                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Media && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                /** truncated when the post was cut to fit. */
                class PostText
                @JsonCreator
                private constructor(private val value: JsonField<String>) : Enum {

                    /** Returns this class instance's raw value. */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val FULL = of("full")

                        @JvmField val TRUNCATED = of("truncated")

                        @JvmStatic fun of(value: String) = PostText(JsonField.of(value))
                    }

                    /** An enum containing [PostText]'s known values. */
                    enum class Known {
                        FULL,
                        TRUNCATED,
                    }

                    /**
                     * An enum containing [PostText]'s known values, as well as an [_UNKNOWN]
                     * member.
                     *
                     * An instance of [PostText] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        FULL,
                        TRUNCATED,
                        /**
                         * An enum member indicating that [PostText] was instantiated with an
                         * unknown value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     */
                    fun value(): Value =
                        when (this) {
                            FULL -> Value.FULL
                            TRUNCATED -> Value.TRUNCATED
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * @throws XTwitterScraperInvalidDataException if this class instance's value is
                     *   a not a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            FULL -> Known.FULL
                            TRUNCATED -> Known.TRUNCATED
                            else ->
                                throw XTwitterScraperInvalidDataException(
                                    "Unknown PostText: $value"
                                )
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
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
                    fun validate(): PostText = apply {
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

                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is PostText && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                class Quote @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /** Returns this class instance's raw value. */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val AVAILABLE = of("available")

                        @JvmField val MISSING = of("missing")

                        @JvmField val NOT_APPLICABLE = of("not_applicable")

                        @JvmStatic fun of(value: String) = Quote(JsonField.of(value))
                    }

                    /** An enum containing [Quote]'s known values. */
                    enum class Known {
                        AVAILABLE,
                        MISSING,
                        NOT_APPLICABLE,
                    }

                    /**
                     * An enum containing [Quote]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Quote] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        AVAILABLE,
                        MISSING,
                        NOT_APPLICABLE,
                        /**
                         * An enum member indicating that [Quote] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     */
                    fun value(): Value =
                        when (this) {
                            AVAILABLE -> Value.AVAILABLE
                            MISSING -> Value.MISSING
                            NOT_APPLICABLE -> Value.NOT_APPLICABLE
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * @throws XTwitterScraperInvalidDataException if this class instance's value is
                     *   a not a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            AVAILABLE -> Known.AVAILABLE
                            MISSING -> Known.MISSING
                            NOT_APPLICABLE -> Known.NOT_APPLICABLE
                            else ->
                                throw XTwitterScraperInvalidDataException("Unknown Quote: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
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
                    fun validate(): Quote = apply {
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

                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Quote && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                class Reply @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

                    /** Returns this class instance's raw value. */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        @JvmField val AVAILABLE = of("available")

                        @JvmField val MISSING = of("missing")

                        @JvmField val NOT_APPLICABLE = of("not_applicable")

                        @JvmStatic fun of(value: String) = Reply(JsonField.of(value))
                    }

                    /** An enum containing [Reply]'s known values. */
                    enum class Known {
                        AVAILABLE,
                        MISSING,
                        NOT_APPLICABLE,
                    }

                    /**
                     * An enum containing [Reply]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Reply] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        AVAILABLE,
                        MISSING,
                        NOT_APPLICABLE,
                        /**
                         * An enum member indicating that [Reply] was instantiated with an unknown
                         * value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     */
                    fun value(): Value =
                        when (this) {
                            AVAILABLE -> Value.AVAILABLE
                            MISSING -> Value.MISSING
                            NOT_APPLICABLE -> Value.NOT_APPLICABLE
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * @throws XTwitterScraperInvalidDataException if this class instance's value is
                     *   a not a known member.
                     */
                    fun known(): Known =
                        when (this) {
                            AVAILABLE -> Known.AVAILABLE
                            MISSING -> Known.MISSING
                            NOT_APPLICABLE -> Known.NOT_APPLICABLE
                            else ->
                                throw XTwitterScraperInvalidDataException("Unknown Reply: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
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
                    fun validate(): Reply = apply {
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

                    @JvmSynthetic
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Reply && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is ContextAvailability &&
                        article == other.article &&
                        author == other.author &&
                        media == other.media &&
                        postText == other.postText &&
                        quote == other.quote &&
                        reply == other.reply &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        article,
                        author,
                        media,
                        postText,
                        quote,
                        reply,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "ContextAvailability{article=$article, author=$author, media=$media, postText=$postText, quote=$quote, reply=$reply, additionalProperties=$additionalProperties}"
            }

            class Question
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val id: JsonField<String>,
                private val version: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("version")
                    @ExcludeMissing
                    version: JsonField<String> = JsonMissing.of(),
                ) : this(id, version, mutableMapOf())

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun id(): String = id.getRequired("id")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun version(): String = version.getRequired("version")

                /**
                 * Returns the raw JSON value of [id].
                 *
                 * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                /**
                 * Returns the raw JSON value of [version].
                 *
                 * Unlike [version], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("version") @ExcludeMissing fun _version(): JsonField<String> = version

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
                     * .version()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Question]. */
                class Builder internal constructor() {

                    private var id: JsonField<String>? = null
                    private var version: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(question: Question) = apply {
                        id = question.id
                        version = question.version
                        additionalProperties = question.additionalProperties.toMutableMap()
                    }

                    fun id(id: String) = id(JsonField.of(id))

                    /** Sets [Builder.id] to an arbitrary JSON value. */
                    fun id(id: JsonField<String>) = apply { this.id = id }

                    fun version(version: String) = version(JsonField.of(version))

                    /** Sets [Builder.version] to an arbitrary JSON value. */
                    fun version(version: JsonField<String>) = apply { this.version = version }

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
                     * .version()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Question =
                        Question(
                            checkRequired("id", id),
                            checkRequired("version", version),
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
                fun validate(): Question = apply {
                    if (validated) {
                        return@apply
                    }

                    id()
                    version()
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
                        (if (version.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Question &&
                        id == other.id &&
                        version == other.version &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(id, version, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Question{id=$id, version=$version, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Analysis &&
                    answers == other.answers &&
                    contextAvailability == other.contextAvailability &&
                    contextBytes == other.contextBytes &&
                    questions == other.questions &&
                    status == other.status &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    answers,
                    contextAvailability,
                    contextBytes,
                    questions,
                    status,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Analysis{answers=$answers, contextAvailability=$contextAvailability, contextBytes=$contextBytes, questions=$questions, status=$status, additionalProperties=$additionalProperties}"
        }

        /**
         * Each question's decision by question ID. A choice gives its category, a score its level
         * from 0, which can have decimals, & a probability its value from 0 to 1.
         */
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

        /**
         * How the post's answers compare with its row in baseline, as the AI Actors compare a run
         * with an earlier dataset.
         */
        class Monitor
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val baselineDatasetId: JsonValue,
            private val changedQuestionIds: JsonField<List<String>>,
            private val changes: JsonField<List<Change>>,
            private val configurationFingerprint: JsonField<String>,
            private val status: JsonField<Status>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("baselineDatasetId")
                @ExcludeMissing
                baselineDatasetId: JsonValue = JsonMissing.of(),
                @JsonProperty("changedQuestionIds")
                @ExcludeMissing
                changedQuestionIds: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("changes")
                @ExcludeMissing
                changes: JsonField<List<Change>> = JsonMissing.of(),
                @JsonProperty("configurationFingerprint")
                @ExcludeMissing
                configurationFingerprint: JsonField<String> = JsonMissing.of(),
                @JsonProperty("status")
                @ExcludeMissing
                status: JsonField<Status> = JsonMissing.of(),
            ) : this(
                baselineDatasetId,
                changedQuestionIds,
                changes,
                configurationFingerprint,
                status,
                mutableMapOf(),
            )

            /**
             * Always null. The baseline is the rows you sent.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from(null)
             * ```
             */
            @JsonProperty("baselineDatasetId")
            @ExcludeMissing
            fun _baselineDatasetId(): JsonValue = baselineDatasetId

            /**
             * IDs of the questions whose decision changed.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun changedQuestionIds(): List<String> =
                changedQuestionIds.getRequired("changedQuestionIds")

            /**
             * Each changed decision, earlier & now.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun changes(): List<Change> = changes.getRequired("changes")

            /**
             * Hash of the questions, targets & context. Rows with another hash are not_comparable.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun configurationFingerprint(): String =
                configurationFingerprint.getRequired("configurationFingerprint")

            /**
             * first_run without baseline. new_to_baseline for a post baseline lacks. changed when
             * an answer clearly left its earlier decision. not_comparable when other settings made
             * the earlier row or it answers none of these questions.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun status(): Status = status.getRequired("status")

            /**
             * Returns the raw JSON value of [changedQuestionIds].
             *
             * Unlike [changedQuestionIds], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("changedQuestionIds")
            @ExcludeMissing
            fun _changedQuestionIds(): JsonField<List<String>> = changedQuestionIds

            /**
             * Returns the raw JSON value of [changes].
             *
             * Unlike [changes], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("changes")
            @ExcludeMissing
            fun _changes(): JsonField<List<Change>> = changes

            /**
             * Returns the raw JSON value of [configurationFingerprint].
             *
             * Unlike [configurationFingerprint], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("configurationFingerprint")
            @ExcludeMissing
            fun _configurationFingerprint(): JsonField<String> = configurationFingerprint

            /**
             * Returns the raw JSON value of [status].
             *
             * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
                 * Returns a mutable builder for constructing an instance of [Monitor].
                 *
                 * The following fields are required:
                 * ```java
                 * .changedQuestionIds()
                 * .changes()
                 * .configurationFingerprint()
                 * .status()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Monitor]. */
            class Builder internal constructor() {

                private var baselineDatasetId: JsonValue = JsonValue.from(null)
                private var changedQuestionIds: JsonField<MutableList<String>>? = null
                private var changes: JsonField<MutableList<Change>>? = null
                private var configurationFingerprint: JsonField<String>? = null
                private var status: JsonField<Status>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(monitor: Monitor) = apply {
                    baselineDatasetId = monitor.baselineDatasetId
                    changedQuestionIds = monitor.changedQuestionIds.map { it.toMutableList() }
                    changes = monitor.changes.map { it.toMutableList() }
                    configurationFingerprint = monitor.configurationFingerprint
                    status = monitor.status
                    additionalProperties = monitor.additionalProperties.toMutableMap()
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * Defaults to the following:
                 * ```java
                 * JsonValue.from(null)
                 * ```
                 */
                fun baselineDatasetId(baselineDatasetId: JsonValue) = apply {
                    this.baselineDatasetId = baselineDatasetId
                }

                /** IDs of the questions whose decision changed. */
                fun changedQuestionIds(changedQuestionIds: List<String>) =
                    changedQuestionIds(JsonField.of(changedQuestionIds))

                /** Sets [Builder.changedQuestionIds] to an arbitrary JSON value. */
                fun changedQuestionIds(changedQuestionIds: JsonField<List<String>>) = apply {
                    this.changedQuestionIds = changedQuestionIds.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [changedQuestionIds].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addChangedQuestionId(changedQuestionId: String) = apply {
                    changedQuestionIds =
                        (changedQuestionIds ?: JsonField.of(mutableListOf())).also {
                            checkKnown("changedQuestionIds", it).add(changedQuestionId)
                        }
                }

                /** Each changed decision, earlier & now. */
                fun changes(changes: List<Change>) = changes(JsonField.of(changes))

                /** Sets [Builder.changes] to an arbitrary JSON value. */
                fun changes(changes: JsonField<List<Change>>) = apply {
                    this.changes = changes.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Change] to [changes].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addChange(change: Change) = apply {
                    changes =
                        (changes ?: JsonField.of(mutableListOf())).also {
                            checkKnown("changes", it).add(change)
                        }
                }

                /**
                 * Hash of the questions, targets & context. Rows with another hash are
                 * not_comparable.
                 */
                fun configurationFingerprint(configurationFingerprint: String) =
                    configurationFingerprint(JsonField.of(configurationFingerprint))

                /** Sets [Builder.configurationFingerprint] to an arbitrary JSON value. */
                fun configurationFingerprint(configurationFingerprint: JsonField<String>) = apply {
                    this.configurationFingerprint = configurationFingerprint
                }

                /**
                 * first_run without baseline. new_to_baseline for a post baseline lacks. changed
                 * when an answer clearly left its earlier decision. not_comparable when other
                 * settings made the earlier row or it answers none of these questions.
                 */
                fun status(status: Status) = status(JsonField.of(status))

                /** Sets [Builder.status] to an arbitrary JSON value. */
                fun status(status: JsonField<Status>) = apply { this.status = status }

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
                 *
                 * The following fields are required:
                 * ```java
                 * .changedQuestionIds()
                 * .changes()
                 * .configurationFingerprint()
                 * .status()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Monitor =
                    Monitor(
                        baselineDatasetId,
                        checkRequired("changedQuestionIds", changedQuestionIds).map {
                            it.toImmutable()
                        },
                        checkRequired("changes", changes).map { it.toImmutable() },
                        checkRequired("configurationFingerprint", configurationFingerprint),
                        checkRequired("status", status),
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
            fun validate(): Monitor = apply {
                if (validated) {
                    return@apply
                }

                _baselineDatasetId().let {
                    if (it != JsonValue.from(null)) {
                        throw XTwitterScraperInvalidDataException(
                            "'baselineDatasetId' is invalid, received $it"
                        )
                    }
                }
                changedQuestionIds()
                changes().forEach { it.validate() }
                configurationFingerprint()
                status().validate()
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
                baselineDatasetId.let { if (it == JsonValue.from(null)) 1 else 0 } +
                    (changedQuestionIds.asKnown().getOrNull()?.size ?: 0) +
                    (changes.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (if (configurationFingerprint.asKnown().isPresent) 1 else 0) +
                    (status.asKnown().getOrNull()?.validity() ?: 0)

            class Change
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val current: JsonField<String>,
                private val previous: JsonField<String>,
                private val questionId: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("current")
                    @ExcludeMissing
                    current: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("previous")
                    @ExcludeMissing
                    previous: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("questionId")
                    @ExcludeMissing
                    questionId: JsonField<String> = JsonMissing.of(),
                ) : this(current, previous, questionId, mutableMapOf())

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun current(): String = current.getRequired("current")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun previous(): String = previous.getRequired("previous")

                /**
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun questionId(): String = questionId.getRequired("questionId")

                /**
                 * Returns the raw JSON value of [current].
                 *
                 * Unlike [current], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("current") @ExcludeMissing fun _current(): JsonField<String> = current

                /**
                 * Returns the raw JSON value of [previous].
                 *
                 * Unlike [previous], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("previous")
                @ExcludeMissing
                fun _previous(): JsonField<String> = previous

                /**
                 * Returns the raw JSON value of [questionId].
                 *
                 * Unlike [questionId], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("questionId")
                @ExcludeMissing
                fun _questionId(): JsonField<String> = questionId

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
                     * Returns a mutable builder for constructing an instance of [Change].
                     *
                     * The following fields are required:
                     * ```java
                     * .current()
                     * .previous()
                     * .questionId()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Change]. */
                class Builder internal constructor() {

                    private var current: JsonField<String>? = null
                    private var previous: JsonField<String>? = null
                    private var questionId: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(change: Change) = apply {
                        current = change.current
                        previous = change.previous
                        questionId = change.questionId
                        additionalProperties = change.additionalProperties.toMutableMap()
                    }

                    fun current(current: String) = current(JsonField.of(current))

                    /** Sets [Builder.current] to an arbitrary JSON value. */
                    fun current(current: JsonField<String>) = apply { this.current = current }

                    fun previous(previous: String) = previous(JsonField.of(previous))

                    /** Sets [Builder.previous] to an arbitrary JSON value. */
                    fun previous(previous: JsonField<String>) = apply { this.previous = previous }

                    fun questionId(questionId: String) = questionId(JsonField.of(questionId))

                    /** Sets [Builder.questionId] to an arbitrary JSON value. */
                    fun questionId(questionId: JsonField<String>) = apply {
                        this.questionId = questionId
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
                     * Returns an immutable instance of [Change].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .current()
                     * .previous()
                     * .questionId()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Change =
                        Change(
                            checkRequired("current", current),
                            checkRequired("previous", previous),
                            checkRequired("questionId", questionId),
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
                fun validate(): Change = apply {
                    if (validated) {
                        return@apply
                    }

                    current()
                    previous()
                    questionId()
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
                    (if (current.asKnown().isPresent) 1 else 0) +
                        (if (previous.asKnown().isPresent) 1 else 0) +
                        (if (questionId.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Change &&
                        current == other.current &&
                        previous == other.previous &&
                        questionId == other.questionId &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(current, previous, questionId, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Change{current=$current, previous=$previous, questionId=$questionId, additionalProperties=$additionalProperties}"
            }

            /**
             * first_run without baseline. new_to_baseline for a post baseline lacks. changed when
             * an answer clearly left its earlier decision. not_comparable when other settings made
             * the earlier row or it answers none of these questions.
             */
            class Status @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /** Returns this class instance's raw value. */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val FIRST_RUN = of("first_run")

                    @JvmField val NEW_TO_BASELINE = of("new_to_baseline")

                    @JvmField val UNCHANGED = of("unchanged")

                    @JvmField val CHANGED = of("changed")

                    @JvmField val NOT_COMPARABLE = of("not_comparable")

                    @JvmField val ANALYSIS_UNAVAILABLE = of("analysis_unavailable")

                    @JvmStatic fun of(value: String) = Status(JsonField.of(value))
                }

                /** An enum containing [Status]'s known values. */
                enum class Known {
                    FIRST_RUN,
                    NEW_TO_BASELINE,
                    UNCHANGED,
                    CHANGED,
                    NOT_COMPARABLE,
                    ANALYSIS_UNAVAILABLE,
                }

                /**
                 * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Status] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    FIRST_RUN,
                    NEW_TO_BASELINE,
                    UNCHANGED,
                    CHANGED,
                    NOT_COMPARABLE,
                    ANALYSIS_UNAVAILABLE,
                    /**
                     * An enum member indicating that [Status] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 */
                fun value(): Value =
                    when (this) {
                        FIRST_RUN -> Value.FIRST_RUN
                        NEW_TO_BASELINE -> Value.NEW_TO_BASELINE
                        UNCHANGED -> Value.UNCHANGED
                        CHANGED -> Value.CHANGED
                        NOT_COMPARABLE -> Value.NOT_COMPARABLE
                        ANALYSIS_UNAVAILABLE -> Value.ANALYSIS_UNAVAILABLE
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
                        FIRST_RUN -> Known.FIRST_RUN
                        NEW_TO_BASELINE -> Known.NEW_TO_BASELINE
                        UNCHANGED -> Known.UNCHANGED
                        CHANGED -> Known.CHANGED
                        NOT_COMPARABLE -> Known.NOT_COMPARABLE
                        ANALYSIS_UNAVAILABLE -> Known.ANALYSIS_UNAVAILABLE
                        else -> throw XTwitterScraperInvalidDataException("Unknown Status: $value")
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
                fun validate(): Status = apply {
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

                    return other is Status && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Monitor &&
                    baselineDatasetId == other.baselineDatasetId &&
                    changedQuestionIds == other.changedQuestionIds &&
                    changes == other.changes &&
                    configurationFingerprint == other.configurationFingerprint &&
                    status == other.status &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    baselineDatasetId,
                    changedQuestionIds,
                    changes,
                    configurationFingerprint,
                    status,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Monitor{baselineDatasetId=$baselineDatasetId, changedQuestionIds=$changedQuestionIds, changes=$changes, configurationFingerprint=$configurationFingerprint, status=$status, additionalProperties=$additionalProperties}"
        }

        /**
         * Only from /x/analysis/viral-score. The score with its weights version, the caps that
         * applied & the engagement comparison.
         */
        class Viral
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

                /** Returns a mutable builder for constructing an instance of [Viral]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Viral]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(viral: Viral) = apply {
                    additionalProperties = viral.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Viral].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Viral = Viral(additionalProperties.toImmutable())
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
            fun validate(): Viral = apply {
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

                return other is Viral && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Viral{additionalProperties=$additionalProperties}"
        }

        /**
         * Only from /x/analysis/viral-score. send_it from 70, edit_first from 40, else sleep_on_it.
         */
        class ViralVerdict @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val SEND_IT = of("send_it")

                @JvmField val EDIT_FIRST = of("edit_first")

                @JvmField val SLEEP_ON_IT = of("sleep_on_it")

                @JvmStatic fun of(value: String) = ViralVerdict(JsonField.of(value))
            }

            /** An enum containing [ViralVerdict]'s known values. */
            enum class Known {
                SEND_IT,
                EDIT_FIRST,
                SLEEP_ON_IT,
            }

            /**
             * An enum containing [ViralVerdict]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [ViralVerdict] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                SEND_IT,
                EDIT_FIRST,
                SLEEP_ON_IT,
                /**
                 * An enum member indicating that [ViralVerdict] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             */
            fun value(): Value =
                when (this) {
                    SEND_IT -> Value.SEND_IT
                    EDIT_FIRST -> Value.EDIT_FIRST
                    SLEEP_ON_IT -> Value.SLEEP_ON_IT
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
                    SEND_IT -> Known.SEND_IT
                    EDIT_FIRST -> Known.EDIT_FIRST
                    SLEEP_ON_IT -> Known.SLEEP_ON_IT
                    else ->
                        throw XTwitterScraperInvalidDataException("Unknown ViralVerdict: $value")
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
            fun validate(): ViralVerdict = apply {
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

                return other is ViralVerdict && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Result &&
                analysis == other.analysis &&
                answers == other.answers &&
                cashtags == other.cashtags &&
                monitor == other.monitor &&
                sourceDomains == other.sourceDomains &&
                tweet == other.tweet &&
                viral == other.viral &&
                viralActualEngagementRate == other.viralActualEngagementRate &&
                viralAlgorithmScore == other.viralAlgorithmScore &&
                viralScore == other.viralScore &&
                viralVerdict == other.viralVerdict &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                analysis,
                answers,
                cashtags,
                monitor,
                sourceDomains,
                tweet,
                viral,
                viralActualEngagementRate,
                viralAlgorithmScore,
                viralScore,
                viralVerdict,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Result{analysis=$analysis, answers=$answers, cashtags=$cashtags, monitor=$monitor, sourceDomains=$sourceDomains, tweet=$tweet, viral=$viral, viralActualEngagementRate=$viralActualEngagementRate, viralAlgorithmScore=$viralAlgorithmScore, viralScore=$viralScore, viralVerdict=$viralVerdict, additionalProperties=$additionalProperties}"
    }

    /** A post without an analysis. It costs nothing. */
    class Unanalyzed
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val reason: JsonField<String>,
        private val status: JsonField<Status>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        ) : this(id, reason, status, mutableMapOf())

        /**
         * Post ID. Your own texts have the IDs text:1, text:2 & so on.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun id(): String = id.getRequired("id")

        /**
         * post_unavailable when X returns no such post. missing_text for a post without text.
         * insufficient_credits when credits ran out. context_limit when the settings leave the post
         * no room. The other reasons mean the analysis failed. Send the post again.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun reason(): String = reason.getRequired("reason")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun status(): Status = status.getRequired("status")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [reason].
         *
         * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
             * Returns a mutable builder for constructing an instance of [Unanalyzed].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .reason()
             * .status()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Unanalyzed]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var reason: JsonField<String>? = null
            private var status: JsonField<Status>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(unanalyzed: Unanalyzed) = apply {
                id = unanalyzed.id
                reason = unanalyzed.reason
                status = unanalyzed.status
                additionalProperties = unanalyzed.additionalProperties.toMutableMap()
            }

            /** Post ID. Your own texts have the IDs text:1, text:2 & so on. */
            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /**
             * post_unavailable when X returns no such post. missing_text for a post without text.
             * insufficient_credits when credits ran out. context_limit when the settings leave the
             * post no room. The other reasons mean the analysis failed. Send the post again.
             */
            fun reason(reason: String) = reason(JsonField.of(reason))

            /** Sets [Builder.reason] to an arbitrary JSON value. */
            fun reason(reason: JsonField<String>) = apply { this.reason = reason }

            fun status(status: Status) = status(JsonField.of(status))

            /** Sets [Builder.status] to an arbitrary JSON value. */
            fun status(status: JsonField<Status>) = apply { this.status = status }

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
             * Returns an immutable instance of [Unanalyzed].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .reason()
             * .status()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Unanalyzed =
                Unanalyzed(
                    checkRequired("id", id),
                    checkRequired("reason", reason),
                    checkRequired("status", status),
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
        fun validate(): Unanalyzed = apply {
            if (validated) {
                return@apply
            }

            id()
            reason()
            status().validate()
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
                (if (reason.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0)

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val FAILED = of("failed")

                @JvmField val SKIPPED = of("skipped")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                FAILED,
                SKIPPED,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                FAILED,
                SKIPPED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             */
            fun value(): Value =
                when (this) {
                    FAILED -> Value.FAILED
                    SKIPPED -> Value.SKIPPED
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
                    FAILED -> Known.FAILED
                    SKIPPED -> Known.SKIPPED
                    else -> throw XTwitterScraperInvalidDataException("Unknown Status: $value")
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
            fun validate(): Status = apply {
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

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Unanalyzed &&
                id == other.id &&
                reason == other.reason &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, reason, status, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Unanalyzed{id=$id, reason=$reason, status=$status, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AnalysisBrandResponse &&
            analysisSummary == other.analysisSummary &&
            hasNextPage == other.hasNextPage &&
            nextCursor == other.nextCursor &&
            results == other.results &&
            unanalyzed == other.unanalyzed &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            analysisSummary,
            hasNextPage,
            nextCursor,
            results,
            unanalyzed,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AnalysisBrandResponse{analysisSummary=$analysisSummary, hasNextPage=$hasNextPage, nextCursor=$nextCursor, results=$results, unanalyzed=$unanalyzed, additionalProperties=$additionalProperties}"
}
