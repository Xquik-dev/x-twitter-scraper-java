// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.extractions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
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
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("hasMore") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("job") @ExcludeMissing job: JsonField<Job> = JsonMissing.of(),
        @JsonProperty("results")
        @ExcludeMissing
        results: JsonField<List<Result>> = JsonMissing.of(),
        @JsonProperty("nextCursor") @ExcludeMissing nextCursor: JsonField<String> = JsonMissing.of(),
    ) : this(hasMore, job, results, nextCursor, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun hasMore(): Boolean = hasMore.getRequired("hasMore")

    /**
     * Extraction job metadata — shape varies by tool type (JSON)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun job(): Job = job.getRequired("job")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun results(): List<Result> = results.getRequired("results")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun nextCursor(): Optional<String> = nextCursor.getOptional("nextCursor")

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
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(extractionRetrieveResponse: ExtractionRetrieveResponse) = apply {
            hasMore = extractionRetrieveResponse.hasMore
            job = extractionRetrieveResponse.job
            results = extractionRetrieveResponse.results.map { it.toMutableList() }
            nextCursor = extractionRetrieveResponse.nextCursor
            additionalProperties = extractionRetrieveResponse.additionalProperties.toMutableMap()
        }

        fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

        /**
         * Sets [Builder.hasMore] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasMore] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

        /** Extraction job metadata — shape varies by tool type (JSON) */
        fun job(job: Job) = job(JsonField.of(job))

        /**
         * Sets [Builder.job] to an arbitrary JSON value.
         *
         * You should usually call [Builder.job] with a well-typed [Job] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun job(job: JsonField<Job>) = apply { this.job = job }

        fun results(results: List<Result>) = results(JsonField.of(results))

        /**
         * Sets [Builder.results] to an arbitrary JSON value.
         *
         * You should usually call [Builder.results] with a well-typed `List<Result>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
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

        /**
         * Sets [Builder.nextCursor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextCursor] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun nextCursor(nextCursor: JsonField<String>) = apply { this.nextCursor = nextCursor }

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
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ExtractionRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        hasMore()
        job().validate()
        results().forEach { it.validate() }
        nextCursor()
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
        (if (hasMore.asKnown().isPresent) 1 else 0) +
            (job.asKnown().getOrNull()?.validity() ?: 0) +
            (results.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0)

    /** Extraction job metadata — shape varies by tool type (JSON) */
    class Job
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

            /** Returns a mutable builder for constructing an instance of [Job]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Job]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(job: Job) = apply {
                additionalProperties = job.additionalProperties.toMutableMap()
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
            fun build(): Job = Job(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Job = apply {
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

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Job && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Job{additionalProperties=$additionalProperties}"
    }

    class Result
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

            /** Returns a mutable builder for constructing an instance of [Result]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Result]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(result: Result) = apply {
                additionalProperties = result.additionalProperties.toMutableMap()
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
            fun build(): Result = Result(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Result = apply {
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

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Result && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Result{additionalProperties=$additionalProperties}"
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
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(hasMore, job, results, nextCursor, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ExtractionRetrieveResponse{hasMore=$hasMore, job=$job, results=$results, nextCursor=$nextCursor, additionalProperties=$additionalProperties}"
}
