// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.extractions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import com.x_twitter_scraper.api.models.SearchTweet
import com.x_twitter_scraper.api.models.TweetMedia
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ExtractionRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val hasMore: JsonField<Boolean>,
    private val job: JsonField<Job>,
    private val results: JsonField<List<Result>>,
    private val nextCursor: JsonField<String>,
    private val pollAfterMs: JsonField<Long>,
    private val waitUrl: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("hasMore") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("job") @ExcludeMissing job: JsonField<Job> = JsonMissing.of(),
        @JsonProperty("results")
        @ExcludeMissing
        results: JsonField<List<Result>> = JsonMissing.of(),
        @JsonProperty("nextCursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("pollAfterMs")
        @ExcludeMissing
        pollAfterMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("waitUrl") @ExcludeMissing waitUrl: JsonField<String> = JsonMissing.of(),
    ) : this(
        hasMore,
        job,
        results,
        nextCursor,
        pollAfterMs,
        waitUrl,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun hasMore(): Boolean = hasMore.getRequired("hasMore")

    /**
     * Extraction job metadata - shape varies by tool type (JSON)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun job(): Job = job.getRequired("job")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun results(): List<Result> = results.getRequired("results")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun nextCursor(): Optional<String> = nextCursor.getOptional("nextCursor")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun pollAfterMs(): Optional<Long> = pollAfterMs.getOptional("pollAfterMs")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun waitUrl(): Optional<String> = waitUrl.getOptional("waitUrl")

    /**
     * Returns the raw JSON value of [hasMore].
     *
     * Unlike [hasMore], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hasMore") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

    /**
     * Returns the raw JSON value of [job].
     *
     * Unlike [job], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("job") @ExcludeMissing fun _job(): JsonField<Job> = job

    /**
     * Returns the raw JSON value of [results].
     *
     * Unlike [results], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("results") @ExcludeMissing fun _results(): JsonField<List<Result>> = results

    /**
     * Returns the raw JSON value of [nextCursor].
     *
     * Unlike [nextCursor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("nextCursor") @ExcludeMissing fun _nextCursor(): JsonField<String> = nextCursor

    /**
     * Returns the raw JSON value of [pollAfterMs].
     *
     * Unlike [pollAfterMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("pollAfterMs") @ExcludeMissing fun _pollAfterMs(): JsonField<Long> = pollAfterMs

    /**
     * Returns the raw JSON value of [waitUrl].
     *
     * Unlike [waitUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("waitUrl") @ExcludeMissing fun _waitUrl(): JsonField<String> = waitUrl

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
         * Returns a mutable builder for constructing an instance of [ExtractionRetrieveResponse].
         *
         * The following fields are required:
         * ```java
         * .hasMore()
         * .job()
         * .results()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExtractionRetrieveResponse]. */
    class Builder internal constructor() {

        private var hasMore: JsonField<Boolean>? = null
        private var job: JsonField<Job>? = null
        private var results: JsonField<MutableList<Result>>? = null
        private var nextCursor: JsonField<String> = JsonMissing.of()
        private var pollAfterMs: JsonField<Long> = JsonMissing.of()
        private var waitUrl: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(extractionRetrieveResponse: ExtractionRetrieveResponse) = apply {
            hasMore = extractionRetrieveResponse.hasMore
            job = extractionRetrieveResponse.job
            results = extractionRetrieveResponse.results.map { it.toMutableList() }
            nextCursor = extractionRetrieveResponse.nextCursor
            pollAfterMs = extractionRetrieveResponse.pollAfterMs
            waitUrl = extractionRetrieveResponse.waitUrl
            additionalProperties = extractionRetrieveResponse.additionalProperties.toMutableMap()
        }

        fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

        /** Sets [Builder.hasMore] to an arbitrary JSON value. */
        fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

        /** Extraction job metadata - shape varies by tool type (JSON) */
        fun job(job: Job) = job(JsonField.of(job))

        /** Sets [Builder.job] to an arbitrary JSON value. */
        fun job(job: JsonField<Job>) = apply { this.job = job }

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

        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /** Sets [Builder.nextCursor] to an arbitrary JSON value. */
        fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

        fun pollAfterMs(pollAfterMs: Long) = pollAfterMs(JsonField.of(pollAfterMs))

        /** Sets [Builder.pollAfterMs] to an arbitrary JSON value. */
        fun pollAfterMs(pollAfterMs: JsonField<Long>) = apply { this.pollAfterMs = pollAfterMs }

        fun waitUrl(waitUrl: String) = waitUrl(JsonField.of(waitUrl))

        /** Sets [Builder.waitUrl] to an arbitrary JSON value. */
        fun waitUrl(waitUrl: JsonField<String>) = apply { this.waitUrl = waitUrl }

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
         * Returns an immutable instance of [ExtractionRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .hasMore()
         * .job()
         * .results()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ExtractionRetrieveResponse =
            ExtractionRetrieveResponse(
                checkRequired("hasMore", hasMore),
                checkRequired("job", job),
                checkRequired("results", results).map { it.toImmutable() },
                nextCursor,
                pollAfterMs,
                waitUrl,
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
    fun validate(): ExtractionRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        hasMore()
        job().validate()
        results().forEach { it.validate() }
        nextCursor()
        pollAfterMs()
        waitUrl()
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
        (if (hasMore.asKnown().isPresent) 1 else 0) +
            (job.asKnown().getOrNull()?.validity() ?: 0) +
            (results.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0) +
            (if (pollAfterMs.asKnown().isPresent) 1 else 0) +
            (if (waitUrl.asKnown().isPresent) 1 else 0)

    /** Extraction job metadata - shape varies by tool type (JSON) */
    class Job
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val toolType: JsonField<ExtractionJob.ToolType>,
        private val status: JsonField<Status>,
        private val totalResults: JsonField<Long>,
        private val resultsLimit: JsonField<Long>,
        private val effectiveResultsLimit: JsonField<Long>,
        private val completionReason: JsonField<CompletionReason>,
        private val errorMessage: JsonField<String>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val completedAt: JsonField<OffsetDateTime>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {
        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("toolType")
            @ExcludeMissing
            toolType: JsonField<ExtractionJob.ToolType> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("totalResults")
            @ExcludeMissing
            totalResults: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("resultsLimit")
            @ExcludeMissing
            resultsLimit: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("effectiveResultsLimit")
            @ExcludeMissing
            effectiveResultsLimit: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("completionReason")
            @ExcludeMissing
            completionReason: JsonField<CompletionReason> = JsonMissing.of(),
            @JsonProperty("errorMessage")
            @ExcludeMissing
            errorMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("completedAt")
            @ExcludeMissing
            completedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(
            id,
            toolType,
            status,
            totalResults,
            resultsLimit,
            effectiveResultsLimit,
            completionReason,
            errorMessage,
            createdAt,
            completedAt,
            mutableMapOf(),
        )

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun id(): Optional<String> = id.getOptional("id")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun toolType(): Optional<ExtractionJob.ToolType> = toolType.getOptional("toolType")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun status(): Optional<Status> = status.getOptional("status")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun totalResults(): Optional<Long> = totalResults.getOptional("totalResults")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun resultsLimit(): Optional<Long> = resultsLimit.getOptional("resultsLimit")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun effectiveResultsLimit(): Optional<Long> =
            effectiveResultsLimit.getOptional("effectiveResultsLimit")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun completionReason(): Optional<CompletionReason> =
            completionReason.getOptional("completionReason")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun errorMessage(): Optional<String> = errorMessage.getOptional("errorMessage")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun completedAt(): Optional<OffsetDateTime> = completedAt.getOptional("completedAt")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [toolType].
         *
         * Unlike [toolType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("toolType")
        @ExcludeMissing
        fun _toolType(): JsonField<ExtractionJob.ToolType> = toolType

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [totalResults].
         *
         * Unlike [totalResults], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("totalResults")
        @ExcludeMissing
        fun _totalResults(): JsonField<Long> = totalResults

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
         * Returns the raw JSON value of [effectiveResultsLimit].
         *
         * Unlike [effectiveResultsLimit], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("effectiveResultsLimit")
        @ExcludeMissing
        fun _effectiveResultsLimit(): JsonField<Long> = effectiveResultsLimit

        /**
         * Returns the raw JSON value of [completionReason].
         *
         * Unlike [completionReason], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("completionReason")
        @ExcludeMissing
        fun _completionReason(): JsonField<CompletionReason> = completionReason

        /**
         * Returns the raw JSON value of [errorMessage].
         *
         * Unlike [errorMessage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("errorMessage")
        @ExcludeMissing
        fun _errorMessage(): JsonField<String> = errorMessage

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [completedAt].
         *
         * Unlike [completedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("completedAt")
        @ExcludeMissing
        fun _completedAt(): JsonField<OffsetDateTime> = completedAt

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
            /** Returns a mutable builder for constructing an instance of [Job]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Job]. */
        class Builder internal constructor() {
            private var id: JsonField<String> = JsonMissing.of()
            private var toolType: JsonField<ExtractionJob.ToolType> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var totalResults: JsonField<Long> = JsonMissing.of()
            private var resultsLimit: JsonField<Long> = JsonMissing.of()
            private var effectiveResultsLimit: JsonField<Long> = JsonMissing.of()
            private var completionReason: JsonField<CompletionReason> = JsonMissing.of()
            private var errorMessage: JsonField<String> = JsonMissing.of()
            private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var completedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(job: Job) = apply {
                id = job.id
                toolType = job.toolType
                status = job.status
                totalResults = job.totalResults
                resultsLimit = job.resultsLimit
                effectiveResultsLimit = job.effectiveResultsLimit
                completionReason = job.completionReason
                errorMessage = job.errorMessage
                createdAt = job.createdAt
                completedAt = job.completedAt
                additionalProperties = job.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun toolType(toolType: ExtractionJob.ToolType) = toolType(JsonField.of(toolType))

            /** Sets [Builder.toolType] to an arbitrary JSON value. */
            fun toolType(toolType: JsonField<ExtractionJob.ToolType>) = apply {
                this.toolType = toolType
            }

            fun status(status: Status) = status(JsonField.of(status))

            /** Sets [Builder.status] to an arbitrary JSON value. */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            fun totalResults(totalResults: Long) = totalResults(JsonField.of(totalResults))

            /** Sets [Builder.totalResults] to an arbitrary JSON value. */
            fun totalResults(totalResults: JsonField<Long>) = apply {
                this.totalResults = totalResults
            }

            fun resultsLimit(resultsLimit: Long) = resultsLimit(JsonField.of(resultsLimit))

            /** Sets [Builder.resultsLimit] to an arbitrary JSON value. */
            fun resultsLimit(resultsLimit: JsonField<Long>) = apply {
                this.resultsLimit = resultsLimit
            }

            fun effectiveResultsLimit(effectiveResultsLimit: Long) =
                effectiveResultsLimit(JsonField.of(effectiveResultsLimit))

            /** Sets [Builder.effectiveResultsLimit] to an arbitrary JSON value. */
            fun effectiveResultsLimit(effectiveResultsLimit: JsonField<Long>) = apply {
                this.effectiveResultsLimit = effectiveResultsLimit
            }

            fun completionReason(completionReason: CompletionReason) =
                completionReason(JsonField.of(completionReason))

            /** Sets [Builder.completionReason] to an arbitrary JSON value. */
            fun completionReason(completionReason: JsonField<CompletionReason>) = apply {
                this.completionReason = completionReason
            }

            fun errorMessage(errorMessage: String) = errorMessage(JsonField.of(errorMessage))

            /** Sets [Builder.errorMessage] to an arbitrary JSON value. */
            fun errorMessage(errorMessage: JsonField<String>) = apply {
                this.errorMessage = errorMessage
            }

            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /** Sets [Builder.createdAt] to an arbitrary JSON value. */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            fun completedAt(completedAt: OffsetDateTime) = completedAt(JsonField.of(completedAt))

            /** Sets [Builder.completedAt] to an arbitrary JSON value. */
            fun completedAt(completedAt: JsonField<OffsetDateTime>) = apply {
                this.completedAt = completedAt
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
             * Returns an immutable instance of [Job].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Job =
                Job(
                    id,
                    toolType,
                    status,
                    totalResults,
                    resultsLimit,
                    effectiveResultsLimit,
                    completionReason,
                    errorMessage,
                    createdAt,
                    completedAt,
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
        fun validate(): Job = apply {
            if (validated) {
                return@apply
            }
            id()
            toolType().ifPresent { it.validate() }
            status().ifPresent { it.validate() }
            totalResults()
            resultsLimit()
            effectiveResultsLimit()
            completionReason().ifPresent { it.validate() }
            errorMessage()
            createdAt()
            completedAt()
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
            (0) +
                (if (id.asKnown().isPresent) 1 else 0) +
                (toolType.asKnown().getOrNull()?.validity() ?: 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (totalResults.asKnown().isPresent) 1 else 0) +
                (if (resultsLimit.asKnown().isPresent) 1 else 0) +
                (if (effectiveResultsLimit.asKnown().isPresent) 1 else 0) +
                (completionReason.asKnown().getOrNull()?.validity() ?: 0) +
                (if (errorMessage.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (completedAt.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }
            return other is Job &&
                id == other.id &&
                toolType == other.toolType &&
                status == other.status &&
                totalResults == other.totalResults &&
                resultsLimit == other.resultsLimit &&
                effectiveResultsLimit == other.effectiveResultsLimit &&
                completionReason == other.completionReason &&
                errorMessage == other.errorMessage &&
                createdAt == other.createdAt &&
                completedAt == other.completedAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                toolType,
                status,
                totalResults,
                resultsLimit,
                effectiveResultsLimit,
                completionReason,
                errorMessage,
                createdAt,
                completedAt,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Job{id=$id, toolType=$toolType, status=$status, totalResults=$totalResults, resultsLimit=$resultsLimit, effectiveResultsLimit=$effectiveResultsLimit, completionReason=$completionReason, errorMessage=$errorMessage, createdAt=$createdAt, completedAt=$completedAt, additionalProperties=$additionalProperties}"

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val PENDING = of("pending")

                @JvmField val RUNNING = of("running")

                @JvmField val CANCELED = of("canceled")

                @JvmField val COMPLETED = of("completed")

                @JvmField val FAILED = of("failed")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                PENDING,
                RUNNING,
                CANCELED,
                COMPLETED,
                FAILED,
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
                PENDING,
                RUNNING,
                CANCELED,
                COMPLETED,
                FAILED,
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
                    PENDING -> Value.PENDING
                    RUNNING -> Value.RUNNING
                    CANCELED -> Value.CANCELED
                    COMPLETED -> Value.COMPLETED
                    FAILED -> Value.FAILED
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
                    PENDING -> Known.PENDING
                    RUNNING -> Known.RUNNING
                    CANCELED -> Known.CANCELED
                    COMPLETED -> Known.COMPLETED
                    FAILED -> Known.FAILED
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

        class CompletionReason
        @JsonCreator
        private constructor(private val value: JsonField<String>) : Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val BUDGET_LIMITED = of("budget_limited")

                @JvmField val CANCELED = of("canceled")

                @JvmField val DEADLINE_REACHED = of("deadline_reached")

                @JvmField val FAILED = of("failed")

                @JvmField val PAGINATION_SAFETY_LIMIT = of("pagination_safety_limit")

                @JvmField val PARTIAL_FAILURE = of("partial_failure")

                @JvmField val REQUESTED_LIMIT_REACHED = of("requested_limit_reached")

                @JvmField val SOURCE_EXHAUSTED = of("source_exhausted")

                @JvmStatic fun of(value: String) = CompletionReason(JsonField.of(value))
            }

            /** An enum containing [CompletionReason]'s known values. */
            enum class Known {
                BUDGET_LIMITED,
                CANCELED,
                DEADLINE_REACHED,
                FAILED,
                PAGINATION_SAFETY_LIMIT,
                PARTIAL_FAILURE,
                REQUESTED_LIMIT_REACHED,
                SOURCE_EXHAUSTED,
            }

            /**
             * An enum containing [CompletionReason]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [CompletionReason] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                BUDGET_LIMITED,
                CANCELED,
                DEADLINE_REACHED,
                FAILED,
                PAGINATION_SAFETY_LIMIT,
                PARTIAL_FAILURE,
                REQUESTED_LIMIT_REACHED,
                SOURCE_EXHAUSTED,
                /**
                 * An enum member indicating that [CompletionReason] was instantiated with an
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
                    BUDGET_LIMITED -> Value.BUDGET_LIMITED
                    CANCELED -> Value.CANCELED
                    DEADLINE_REACHED -> Value.DEADLINE_REACHED
                    FAILED -> Value.FAILED
                    PAGINATION_SAFETY_LIMIT -> Value.PAGINATION_SAFETY_LIMIT
                    PARTIAL_FAILURE -> Value.PARTIAL_FAILURE
                    REQUESTED_LIMIT_REACHED -> Value.REQUESTED_LIMIT_REACHED
                    SOURCE_EXHAUSTED -> Value.SOURCE_EXHAUSTED
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
                    BUDGET_LIMITED -> Known.BUDGET_LIMITED
                    CANCELED -> Known.CANCELED
                    DEADLINE_REACHED -> Known.DEADLINE_REACHED
                    FAILED -> Known.FAILED
                    PAGINATION_SAFETY_LIMIT -> Known.PAGINATION_SAFETY_LIMIT
                    PARTIAL_FAILURE -> Known.PARTIAL_FAILURE
                    REQUESTED_LIMIT_REACHED -> Known.REQUESTED_LIMIT_REACHED
                    SOURCE_EXHAUSTED -> Known.SOURCE_EXHAUSTED
                    else ->
                        throw XTwitterScraperInvalidDataException(
                            "Unknown CompletionReason: $value"
                        )
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
            fun validate(): CompletionReason = apply {
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

                return other is CompletionReason && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }
    }

    class Result
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val xUserId: JsonField<String>,
        private val xUsername: JsonField<String>,
        private val xDisplayName: JsonField<String>,
        private val xFollowersCount: JsonField<Long>,
        private val xVerified: JsonField<Boolean>,
        private val xProfileImageUrl: JsonField<String>,
        private val email: JsonField<String>,
        private val tweetId: JsonField<String>,
        private val tweetUrl: JsonField<String>,
        private val tweetText: JsonField<String>,
        private val tweetCreatedAt: JsonField<OffsetDateTime>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val media: JsonField<List<TweetMedia>>,
        private val bookmarkCount: JsonField<Long>,
        private val likeCount: JsonField<Long>,
        private val quoteCount: JsonField<Long>,
        private val replyCount: JsonField<Long>,
        private val retweetCount: JsonField<Long>,
        private val viewCount: JsonField<Long>,
        private val enrichmentData: JsonField<SearchTweet.Scopes>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {
        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("xUserId") @ExcludeMissing xUserId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("xUsername")
            @ExcludeMissing
            xUsername: JsonField<String> = JsonMissing.of(),
            @JsonProperty("xDisplayName")
            @ExcludeMissing
            xDisplayName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("xFollowersCount")
            @ExcludeMissing
            xFollowersCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("xVerified")
            @ExcludeMissing
            xVerified: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("xProfileImageUrl")
            @ExcludeMissing
            xProfileImageUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tweetUrl")
            @ExcludeMissing
            tweetUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tweetText")
            @ExcludeMissing
            tweetText: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tweetCreatedAt")
            @ExcludeMissing
            tweetCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("media")
            @ExcludeMissing
            media: JsonField<List<TweetMedia>> = JsonMissing.of(),
            @JsonProperty("bookmarkCount")
            @ExcludeMissing
            bookmarkCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("likeCount")
            @ExcludeMissing
            likeCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("quoteCount")
            @ExcludeMissing
            quoteCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("replyCount")
            @ExcludeMissing
            replyCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("retweetCount")
            @ExcludeMissing
            retweetCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("viewCount")
            @ExcludeMissing
            viewCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("enrichmentData")
            @ExcludeMissing
            enrichmentData: JsonField<SearchTweet.Scopes> = JsonMissing.of(),
        ) : this(
            id,
            xUserId,
            xUsername,
            xDisplayName,
            xFollowersCount,
            xVerified,
            xProfileImageUrl,
            email,
            tweetId,
            tweetUrl,
            tweetText,
            tweetCreatedAt,
            createdAt,
            media,
            bookmarkCount,
            likeCount,
            quoteCount,
            replyCount,
            retweetCount,
            viewCount,
            enrichmentData,
            mutableMapOf(),
        )

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun id(): Optional<String> = id.getOptional("id")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun xUserId(): Optional<String> = xUserId.getOptional("xUserId")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun xUsername(): Optional<String> = xUsername.getOptional("xUsername")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun xDisplayName(): Optional<String> = xDisplayName.getOptional("xDisplayName")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun xFollowersCount(): Optional<Long> = xFollowersCount.getOptional("xFollowersCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun xVerified(): Optional<Boolean> = xVerified.getOptional("xVerified")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun xProfileImageUrl(): Optional<String> = xProfileImageUrl.getOptional("xProfileImageUrl")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun email(): Optional<String> = email.getOptional("email")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun tweetId(): Optional<String> = tweetId.getOptional("tweetId")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun tweetUrl(): Optional<String> = tweetUrl.getOptional("tweetUrl")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun tweetText(): Optional<String> = tweetText.getOptional("tweetText")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun tweetCreatedAt(): Optional<OffsetDateTime> =
            tweetCreatedAt.getOptional("tweetCreatedAt")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun media(): Optional<List<TweetMedia>> = media.getOptional("media")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun bookmarkCount(): Optional<Long> = bookmarkCount.getOptional("bookmarkCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun likeCount(): Optional<Long> = likeCount.getOptional("likeCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun quoteCount(): Optional<Long> = quoteCount.getOptional("quoteCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun replyCount(): Optional<Long> = replyCount.getOptional("replyCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun retweetCount(): Optional<Long> = retweetCount.getOptional("retweetCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun viewCount(): Optional<Long> = viewCount.getOptional("viewCount")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun enrichmentData(): Optional<SearchTweet.Scopes> =
            enrichmentData.getOptional("enrichmentData")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [xUserId].
         *
         * Unlike [xUserId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("xUserId") @ExcludeMissing fun _xUserId(): JsonField<String> = xUserId

        /**
         * Returns the raw JSON value of [xUsername].
         *
         * Unlike [xUsername], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("xUsername") @ExcludeMissing fun _xUsername(): JsonField<String> = xUsername

        /**
         * Returns the raw JSON value of [xDisplayName].
         *
         * Unlike [xDisplayName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("xDisplayName")
        @ExcludeMissing
        fun _xDisplayName(): JsonField<String> = xDisplayName

        /**
         * Returns the raw JSON value of [xFollowersCount].
         *
         * Unlike [xFollowersCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("xFollowersCount")
        @ExcludeMissing
        fun _xFollowersCount(): JsonField<Long> = xFollowersCount

        /**
         * Returns the raw JSON value of [xVerified].
         *
         * Unlike [xVerified], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("xVerified") @ExcludeMissing fun _xVerified(): JsonField<Boolean> = xVerified

        /**
         * Returns the raw JSON value of [xProfileImageUrl].
         *
         * Unlike [xProfileImageUrl], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("xProfileImageUrl")
        @ExcludeMissing
        fun _xProfileImageUrl(): JsonField<String> = xProfileImageUrl

        /**
         * Returns the raw JSON value of [email].
         *
         * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

        /**
         * Returns the raw JSON value of [tweetId].
         *
         * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

        /**
         * Returns the raw JSON value of [tweetUrl].
         *
         * Unlike [tweetUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweetUrl") @ExcludeMissing fun _tweetUrl(): JsonField<String> = tweetUrl

        /**
         * Returns the raw JSON value of [tweetText].
         *
         * Unlike [tweetText], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweetText") @ExcludeMissing fun _tweetText(): JsonField<String> = tweetText

        /**
         * Returns the raw JSON value of [tweetCreatedAt].
         *
         * Unlike [tweetCreatedAt], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("tweetCreatedAt")
        @ExcludeMissing
        fun _tweetCreatedAt(): JsonField<OffsetDateTime> = tweetCreatedAt

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [media].
         *
         * Unlike [media], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("media") @ExcludeMissing fun _media(): JsonField<List<TweetMedia>> = media

        /**
         * Returns the raw JSON value of [bookmarkCount].
         *
         * Unlike [bookmarkCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("bookmarkCount")
        @ExcludeMissing
        fun _bookmarkCount(): JsonField<Long> = bookmarkCount

        /**
         * Returns the raw JSON value of [likeCount].
         *
         * Unlike [likeCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("likeCount") @ExcludeMissing fun _likeCount(): JsonField<Long> = likeCount

        /**
         * Returns the raw JSON value of [quoteCount].
         *
         * Unlike [quoteCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("quoteCount") @ExcludeMissing fun _quoteCount(): JsonField<Long> = quoteCount

        /**
         * Returns the raw JSON value of [replyCount].
         *
         * Unlike [replyCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("replyCount") @ExcludeMissing fun _replyCount(): JsonField<Long> = replyCount

        /**
         * Returns the raw JSON value of [retweetCount].
         *
         * Unlike [retweetCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("retweetCount")
        @ExcludeMissing
        fun _retweetCount(): JsonField<Long> = retweetCount

        /**
         * Returns the raw JSON value of [viewCount].
         *
         * Unlike [viewCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("viewCount") @ExcludeMissing fun _viewCount(): JsonField<Long> = viewCount

        /**
         * Returns the raw JSON value of [enrichmentData].
         *
         * Unlike [enrichmentData], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("enrichmentData")
        @ExcludeMissing
        fun _enrichmentData(): JsonField<SearchTweet.Scopes> = enrichmentData

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
            /** Returns a mutable builder for constructing an instance of [Result]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Result]. */
        class Builder internal constructor() {
            private var id: JsonField<String> = JsonMissing.of()
            private var xUserId: JsonField<String> = JsonMissing.of()
            private var xUsername: JsonField<String> = JsonMissing.of()
            private var xDisplayName: JsonField<String> = JsonMissing.of()
            private var xFollowersCount: JsonField<Long> = JsonMissing.of()
            private var xVerified: JsonField<Boolean> = JsonMissing.of()
            private var xProfileImageUrl: JsonField<String> = JsonMissing.of()
            private var email: JsonField<String> = JsonMissing.of()
            private var tweetId: JsonField<String> = JsonMissing.of()
            private var tweetUrl: JsonField<String> = JsonMissing.of()
            private var tweetText: JsonField<String> = JsonMissing.of()
            private var tweetCreatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var media: JsonField<MutableList<TweetMedia>>? = null
            private var bookmarkCount: JsonField<Long> = JsonMissing.of()
            private var likeCount: JsonField<Long> = JsonMissing.of()
            private var quoteCount: JsonField<Long> = JsonMissing.of()
            private var replyCount: JsonField<Long> = JsonMissing.of()
            private var retweetCount: JsonField<Long> = JsonMissing.of()
            private var viewCount: JsonField<Long> = JsonMissing.of()
            private var enrichmentData: JsonField<SearchTweet.Scopes> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(result: Result) = apply {
                id = result.id
                xUserId = result.xUserId
                xUsername = result.xUsername
                xDisplayName = result.xDisplayName
                xFollowersCount = result.xFollowersCount
                xVerified = result.xVerified
                xProfileImageUrl = result.xProfileImageUrl
                email = result.email
                tweetId = result.tweetId
                tweetUrl = result.tweetUrl
                tweetText = result.tweetText
                tweetCreatedAt = result.tweetCreatedAt
                createdAt = result.createdAt
                media = result.media.map { it.toMutableList() }
                bookmarkCount = result.bookmarkCount
                likeCount = result.likeCount
                quoteCount = result.quoteCount
                replyCount = result.replyCount
                retweetCount = result.retweetCount
                viewCount = result.viewCount
                enrichmentData = result.enrichmentData
                additionalProperties = result.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun xUserId(xUserId: String) = xUserId(JsonField.of(xUserId))

            /** Sets [Builder.xUserId] to an arbitrary JSON value. */
            fun xUserId(xUserId: JsonField<String>) = apply { this.xUserId = xUserId }

            fun xUsername(xUsername: String) = xUsername(JsonField.of(xUsername))

            /** Sets [Builder.xUsername] to an arbitrary JSON value. */
            fun xUsername(xUsername: JsonField<String>) = apply { this.xUsername = xUsername }

            fun xDisplayName(xDisplayName: String) = xDisplayName(JsonField.of(xDisplayName))

            /** Sets [Builder.xDisplayName] to an arbitrary JSON value. */
            fun xDisplayName(xDisplayName: JsonField<String>) = apply {
                this.xDisplayName = xDisplayName
            }

            fun xFollowersCount(xFollowersCount: Long) =
                xFollowersCount(JsonField.of(xFollowersCount))

            /** Sets [Builder.xFollowersCount] to an arbitrary JSON value. */
            fun xFollowersCount(xFollowersCount: JsonField<Long>) = apply {
                this.xFollowersCount = xFollowersCount
            }

            fun xVerified(xVerified: Boolean) = xVerified(JsonField.of(xVerified))

            /** Sets [Builder.xVerified] to an arbitrary JSON value. */
            fun xVerified(xVerified: JsonField<Boolean>) = apply { this.xVerified = xVerified }

            fun xProfileImageUrl(xProfileImageUrl: String) =
                xProfileImageUrl(JsonField.of(xProfileImageUrl))

            /** Sets [Builder.xProfileImageUrl] to an arbitrary JSON value. */
            fun xProfileImageUrl(xProfileImageUrl: JsonField<String>) = apply {
                this.xProfileImageUrl = xProfileImageUrl
            }

            fun email(email: String) = email(JsonField.of(email))

            /** Sets [Builder.email] to an arbitrary JSON value. */
            fun email(email: JsonField<String>) = apply { this.email = email }

            fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

            /** Sets [Builder.tweetId] to an arbitrary JSON value. */
            fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

            fun tweetUrl(tweetUrl: String) = tweetUrl(JsonField.of(tweetUrl))

            /** Sets [Builder.tweetUrl] to an arbitrary JSON value. */
            fun tweetUrl(tweetUrl: JsonField<String>) = apply { this.tweetUrl = tweetUrl }

            fun tweetText(tweetText: String) = tweetText(JsonField.of(tweetText))

            /** Sets [Builder.tweetText] to an arbitrary JSON value. */
            fun tweetText(tweetText: JsonField<String>) = apply { this.tweetText = tweetText }

            fun tweetCreatedAt(tweetCreatedAt: OffsetDateTime) =
                tweetCreatedAt(JsonField.of(tweetCreatedAt))

            /** Sets [Builder.tweetCreatedAt] to an arbitrary JSON value. */
            fun tweetCreatedAt(tweetCreatedAt: JsonField<OffsetDateTime>) = apply {
                this.tweetCreatedAt = tweetCreatedAt
            }

            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /** Sets [Builder.createdAt] to an arbitrary JSON value. */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            fun media(media: List<TweetMedia>) = media(JsonField.of(media))

            /** Sets [Builder.media] to an arbitrary JSON value. */
            fun media(media: JsonField<List<TweetMedia>>) = apply {
                this.media = media.map { it.toMutableList() }
            }

            /**
             * Adds a single [TweetMedia] to [media].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addMedia(media: TweetMedia) = apply {
                this.media =
                    (this.media ?: JsonField.of(mutableListOf())).also {
                        checkKnown("media", it).add(media)
                    }
            }

            fun bookmarkCount(bookmarkCount: Long) = bookmarkCount(JsonField.of(bookmarkCount))

            /** Sets [Builder.bookmarkCount] to an arbitrary JSON value. */
            fun bookmarkCount(bookmarkCount: JsonField<Long>) = apply {
                this.bookmarkCount = bookmarkCount
            }

            fun likeCount(likeCount: Long) = likeCount(JsonField.of(likeCount))

            /** Sets [Builder.likeCount] to an arbitrary JSON value. */
            fun likeCount(likeCount: JsonField<Long>) = apply { this.likeCount = likeCount }

            fun quoteCount(quoteCount: Long) = quoteCount(JsonField.of(quoteCount))

            /** Sets [Builder.quoteCount] to an arbitrary JSON value. */
            fun quoteCount(quoteCount: JsonField<Long>) = apply { this.quoteCount = quoteCount }

            fun replyCount(replyCount: Long) = replyCount(JsonField.of(replyCount))

            /** Sets [Builder.replyCount] to an arbitrary JSON value. */
            fun replyCount(replyCount: JsonField<Long>) = apply { this.replyCount = replyCount }

            fun retweetCount(retweetCount: Long) = retweetCount(JsonField.of(retweetCount))

            /** Sets [Builder.retweetCount] to an arbitrary JSON value. */
            fun retweetCount(retweetCount: JsonField<Long>) = apply {
                this.retweetCount = retweetCount
            }

            fun viewCount(viewCount: Long) = viewCount(JsonField.of(viewCount))

            /** Sets [Builder.viewCount] to an arbitrary JSON value. */
            fun viewCount(viewCount: JsonField<Long>) = apply { this.viewCount = viewCount }

            fun enrichmentData(enrichmentData: SearchTweet.Scopes) =
                enrichmentData(JsonField.of(enrichmentData))

            /** Sets [Builder.enrichmentData] to an arbitrary JSON value. */
            fun enrichmentData(enrichmentData: JsonField<SearchTweet.Scopes>) = apply {
                this.enrichmentData = enrichmentData
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
             */
            fun build(): Result =
                Result(
                    id,
                    xUserId,
                    xUsername,
                    xDisplayName,
                    xFollowersCount,
                    xVerified,
                    xProfileImageUrl,
                    email,
                    tweetId,
                    tweetUrl,
                    tweetText,
                    tweetCreatedAt,
                    createdAt,
                    (media ?: JsonMissing.of()).map { it.toImmutable() },
                    bookmarkCount,
                    likeCount,
                    quoteCount,
                    replyCount,
                    retweetCount,
                    viewCount,
                    enrichmentData,
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
            id()
            xUserId()
            xUsername()
            xDisplayName()
            xFollowersCount()
            xVerified()
            xProfileImageUrl()
            email()
            tweetId()
            tweetUrl()
            tweetText()
            tweetCreatedAt()
            createdAt()
            media().ifPresent { it.forEach { it.validate() } }
            bookmarkCount()
            likeCount()
            quoteCount()
            replyCount()
            retweetCount()
            viewCount()
            enrichmentData().ifPresent { it.validate() }
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
            (0) +
                (if (id.asKnown().isPresent) 1 else 0) +
                (if (xUserId.asKnown().isPresent) 1 else 0) +
                (if (xUsername.asKnown().isPresent) 1 else 0) +
                (if (xDisplayName.asKnown().isPresent) 1 else 0) +
                (if (xFollowersCount.asKnown().isPresent) 1 else 0) +
                (if (xVerified.asKnown().isPresent) 1 else 0) +
                (if (xProfileImageUrl.asKnown().isPresent) 1 else 0) +
                (if (email.asKnown().isPresent) 1 else 0) +
                (if (tweetId.asKnown().isPresent) 1 else 0) +
                (if (tweetUrl.asKnown().isPresent) 1 else 0) +
                (if (tweetText.asKnown().isPresent) 1 else 0) +
                (if (tweetCreatedAt.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (media.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (bookmarkCount.asKnown().isPresent) 1 else 0) +
                (if (likeCount.asKnown().isPresent) 1 else 0) +
                (if (quoteCount.asKnown().isPresent) 1 else 0) +
                (if (replyCount.asKnown().isPresent) 1 else 0) +
                (if (retweetCount.asKnown().isPresent) 1 else 0) +
                (if (viewCount.asKnown().isPresent) 1 else 0) +
                (enrichmentData.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }
            return other is Result &&
                id == other.id &&
                xUserId == other.xUserId &&
                xUsername == other.xUsername &&
                xDisplayName == other.xDisplayName &&
                xFollowersCount == other.xFollowersCount &&
                xVerified == other.xVerified &&
                xProfileImageUrl == other.xProfileImageUrl &&
                email == other.email &&
                tweetId == other.tweetId &&
                tweetUrl == other.tweetUrl &&
                tweetText == other.tweetText &&
                tweetCreatedAt == other.tweetCreatedAt &&
                createdAt == other.createdAt &&
                media == other.media &&
                bookmarkCount == other.bookmarkCount &&
                likeCount == other.likeCount &&
                quoteCount == other.quoteCount &&
                replyCount == other.replyCount &&
                retweetCount == other.retweetCount &&
                viewCount == other.viewCount &&
                enrichmentData == other.enrichmentData &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                xUserId,
                xUsername,
                xDisplayName,
                xFollowersCount,
                xVerified,
                xProfileImageUrl,
                email,
                tweetId,
                tweetUrl,
                tweetText,
                tweetCreatedAt,
                createdAt,
                media,
                bookmarkCount,
                likeCount,
                quoteCount,
                replyCount,
                retweetCount,
                viewCount,
                enrichmentData,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Result{id=$id, xUserId=$xUserId, xUsername=$xUsername, xDisplayName=$xDisplayName, xFollowersCount=$xFollowersCount, xVerified=$xVerified, xProfileImageUrl=$xProfileImageUrl, email=$email, tweetId=$tweetId, tweetUrl=$tweetUrl, tweetText=$tweetText, tweetCreatedAt=$tweetCreatedAt, createdAt=$createdAt, media=$media, bookmarkCount=$bookmarkCount, likeCount=$likeCount, quoteCount=$quoteCount, replyCount=$replyCount, retweetCount=$retweetCount, viewCount=$viewCount, enrichmentData=$enrichmentData, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExtractionRetrieveResponse &&
            hasMore == other.hasMore &&
            job == other.job &&
            results == other.results &&
            nextCursor == other.nextCursor &&
            pollAfterMs == other.pollAfterMs &&
            waitUrl == other.waitUrl &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(hasMore, job, results, nextCursor, pollAfterMs, waitUrl, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ExtractionRetrieveResponse{hasMore=$hasMore, job=$job, results=$results, nextCursor=$nextCursor, pollAfterMs=$pollAfterMs, waitUrl=$waitUrl, additionalProperties=$additionalProperties}"
}
