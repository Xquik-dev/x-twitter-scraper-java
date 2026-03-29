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
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects

class ExtractionEstimateCostResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val allowed: JsonField<Boolean>,
    private val estimatedResults: JsonField<Long>,
    private val projectedPercent: JsonField<Double>,
    private val source: JsonField<String>,
    private val usagePercent: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("allowed") @ExcludeMissing allowed: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("estimatedResults")
        @ExcludeMissing
        estimatedResults: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("projectedPercent")
        @ExcludeMissing
        projectedPercent: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
        @JsonProperty("usagePercent")
        @ExcludeMissing
        usagePercent: JsonField<Double> = JsonMissing.of(),
    ) : this(allowed, estimatedResults, projectedPercent, source, usagePercent, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun allowed(): Boolean = allowed.getRequired("allowed")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun estimatedResults(): Long = estimatedResults.getRequired("estimatedResults")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun projectedPercent(): Double = projectedPercent.getRequired("projectedPercent")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun source(): String = source.getRequired("source")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun usagePercent(): Double = usagePercent.getRequired("usagePercent")

    /**
     * Returns the raw JSON value of [allowed].
     *
     * Unlike [allowed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("allowed") @ExcludeMissing fun _allowed(): JsonField<Boolean> = allowed

    /**
     * Returns the raw JSON value of [estimatedResults].
     *
     * Unlike [estimatedResults], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("estimatedResults")
    @ExcludeMissing
    fun _estimatedResults(): JsonField<Long> = estimatedResults

    /**
     * Returns the raw JSON value of [projectedPercent].
     *
     * Unlike [projectedPercent], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("projectedPercent")
    @ExcludeMissing
    fun _projectedPercent(): JsonField<Double> = projectedPercent

    /**
     * Returns the raw JSON value of [source].
     *
     * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

    /**
     * Returns the raw JSON value of [usagePercent].
     *
     * Unlike [usagePercent], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usagePercent")
    @ExcludeMissing
    fun _usagePercent(): JsonField<Double> = usagePercent

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
         * [ExtractionEstimateCostResponse].
         *
         * The following fields are required:
         * ```java
         * .allowed()
         * .estimatedResults()
         * .projectedPercent()
         * .source()
         * .usagePercent()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExtractionEstimateCostResponse]. */
    class Builder internal constructor() {

        private var allowed: JsonField<Boolean>? = null
        private var estimatedResults: JsonField<Long>? = null
        private var projectedPercent: JsonField<Double>? = null
        private var source: JsonField<String>? = null
        private var usagePercent: JsonField<Double>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(extractionEstimateCostResponse: ExtractionEstimateCostResponse) = apply {
            allowed = extractionEstimateCostResponse.allowed
            estimatedResults = extractionEstimateCostResponse.estimatedResults
            projectedPercent = extractionEstimateCostResponse.projectedPercent
            source = extractionEstimateCostResponse.source
            usagePercent = extractionEstimateCostResponse.usagePercent
            additionalProperties =
                extractionEstimateCostResponse.additionalProperties.toMutableMap()
        }

        fun allowed(allowed: Boolean) = allowed(JsonField.of(allowed))

        /**
         * Sets [Builder.allowed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowed] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun allowed(allowed: JsonField<Boolean>) = apply { this.allowed = allowed }

        fun estimatedResults(estimatedResults: Long) =
            estimatedResults(JsonField.of(estimatedResults))

        /**
         * Sets [Builder.estimatedResults] to an arbitrary JSON value.
         *
         * You should usually call [Builder.estimatedResults] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun estimatedResults(estimatedResults: JsonField<Long>) = apply {
            this.estimatedResults = estimatedResults
        }

        fun projectedPercent(projectedPercent: Double) =
            projectedPercent(JsonField.of(projectedPercent))

        /**
         * Sets [Builder.projectedPercent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.projectedPercent] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun projectedPercent(projectedPercent: JsonField<Double>) = apply {
            this.projectedPercent = projectedPercent
        }

        fun source(source: String) = source(JsonField.of(source))

        /**
         * Sets [Builder.source] to an arbitrary JSON value.
         *
         * You should usually call [Builder.source] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun source(source: JsonField<String>) = apply { this.source = source }

        fun usagePercent(usagePercent: Double) = usagePercent(JsonField.of(usagePercent))

        /**
         * Sets [Builder.usagePercent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usagePercent] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun usagePercent(usagePercent: JsonField<Double>) = apply {
            this.usagePercent = usagePercent
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
         * Returns an immutable instance of [ExtractionEstimateCostResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .allowed()
         * .estimatedResults()
         * .projectedPercent()
         * .source()
         * .usagePercent()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ExtractionEstimateCostResponse =
            ExtractionEstimateCostResponse(
                checkRequired("allowed", allowed),
                checkRequired("estimatedResults", estimatedResults),
                checkRequired("projectedPercent", projectedPercent),
                checkRequired("source", source),
                checkRequired("usagePercent", usagePercent),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ExtractionEstimateCostResponse = apply {
        if (validated) {
            return@apply
        }

        allowed()
        estimatedResults()
        projectedPercent()
        source()
        usagePercent()
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
        (if (allowed.asKnown().isPresent) 1 else 0) +
            (if (estimatedResults.asKnown().isPresent) 1 else 0) +
            (if (projectedPercent.asKnown().isPresent) 1 else 0) +
            (if (source.asKnown().isPresent) 1 else 0) +
            (if (usagePercent.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExtractionEstimateCostResponse &&
            allowed == other.allowed &&
            estimatedResults == other.estimatedResults &&
            projectedPercent == other.projectedPercent &&
            source == other.source &&
            usagePercent == other.usagePercent &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            allowed,
            estimatedResults,
            projectedPercent,
            source,
            usagePercent,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ExtractionEstimateCostResponse{allowed=$allowed, estimatedResults=$estimatedResults, projectedPercent=$projectedPercent, source=$source, usagePercent=$usagePercent, additionalProperties=$additionalProperties}"
}
