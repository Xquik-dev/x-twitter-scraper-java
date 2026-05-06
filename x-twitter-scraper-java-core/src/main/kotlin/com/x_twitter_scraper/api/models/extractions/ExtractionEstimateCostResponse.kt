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
import java.util.Optional

class ExtractionEstimateCostResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val allowed: JsonField<Boolean>,
    private val creditsAvailable: JsonField<String>,
    private val creditsRequired: JsonField<String>,
    private val estimatedResults: JsonField<Long>,
    private val source: JsonField<String>,
    private val resolvedXUserId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("allowed") @ExcludeMissing allowed: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("creditsAvailable")
        @ExcludeMissing
        creditsAvailable: JsonField<String> = JsonMissing.of(),
        @JsonProperty("creditsRequired")
        @ExcludeMissing
        creditsRequired: JsonField<String> = JsonMissing.of(),
        @JsonProperty("estimatedResults")
        @ExcludeMissing
        estimatedResults: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
        @JsonProperty("resolvedXUserId")
        @ExcludeMissing
        resolvedXUserId: JsonField<String> = JsonMissing.of(),
    ) : this(
        allowed,
        creditsAvailable,
        creditsRequired,
        estimatedResults,
        source,
        resolvedXUserId,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun allowed(): Boolean = allowed.getRequired("allowed")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun creditsAvailable(): String = creditsAvailable.getRequired("creditsAvailable")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun creditsRequired(): String = creditsRequired.getRequired("creditsRequired")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun estimatedResults(): Long = estimatedResults.getRequired("estimatedResults")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun source(): String = source.getRequired("source")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun resolvedXUserId(): Optional<String> = resolvedXUserId.getOptional("resolvedXUserId")

    /**
     * Returns the raw JSON value of [allowed].
     *
     * Unlike [allowed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("allowed") @ExcludeMissing fun _allowed(): JsonField<Boolean> = allowed

    /**
     * Returns the raw JSON value of [creditsAvailable].
     *
     * Unlike [creditsAvailable], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("creditsAvailable")
    @ExcludeMissing
    fun _creditsAvailable(): JsonField<String> = creditsAvailable

    /**
     * Returns the raw JSON value of [creditsRequired].
     *
     * Unlike [creditsRequired], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("creditsRequired")
    @ExcludeMissing
    fun _creditsRequired(): JsonField<String> = creditsRequired

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
     * Returns the raw JSON value of [source].
     *
     * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

    /**
     * Returns the raw JSON value of [resolvedXUserId].
     *
     * Unlike [resolvedXUserId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("resolvedXUserId")
    @ExcludeMissing
    fun _resolvedXUserId(): JsonField<String> = resolvedXUserId

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
         * .creditsAvailable()
         * .creditsRequired()
         * .estimatedResults()
         * .source()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ExtractionEstimateCostResponse]. */
    class Builder internal constructor() {

        private var allowed: JsonField<Boolean>? = null
        private var creditsAvailable: JsonField<String>? = null
        private var creditsRequired: JsonField<String>? = null
        private var estimatedResults: JsonField<Long>? = null
        private var source: JsonField<String>? = null
        private var resolvedXUserId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(extractionEstimateCostResponse: ExtractionEstimateCostResponse) = apply {
            allowed = extractionEstimateCostResponse.allowed
            creditsAvailable = extractionEstimateCostResponse.creditsAvailable
            creditsRequired = extractionEstimateCostResponse.creditsRequired
            estimatedResults = extractionEstimateCostResponse.estimatedResults
            source = extractionEstimateCostResponse.source
            resolvedXUserId = extractionEstimateCostResponse.resolvedXUserId
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

        fun creditsAvailable(creditsAvailable: String) =
            creditsAvailable(JsonField.of(creditsAvailable))

        /**
         * Sets [Builder.creditsAvailable] to an arbitrary JSON value.
         *
         * You should usually call [Builder.creditsAvailable] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun creditsAvailable(creditsAvailable: JsonField<String>) = apply {
            this.creditsAvailable = creditsAvailable
        }

        fun creditsRequired(creditsRequired: String) =
            creditsRequired(JsonField.of(creditsRequired))

        /**
         * Sets [Builder.creditsRequired] to an arbitrary JSON value.
         *
         * You should usually call [Builder.creditsRequired] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun creditsRequired(creditsRequired: JsonField<String>) = apply {
            this.creditsRequired = creditsRequired
        }

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

        fun source(source: String) = source(JsonField.of(source))

        /**
         * Sets [Builder.source] to an arbitrary JSON value.
         *
         * You should usually call [Builder.source] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun source(source: JsonField<String>) = apply { this.source = source }

        fun resolvedXUserId(resolvedXUserId: String) =
            resolvedXUserId(JsonField.of(resolvedXUserId))

        /**
         * Sets [Builder.resolvedXUserId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.resolvedXUserId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun resolvedXUserId(resolvedXUserId: JsonField<String>) = apply {
            this.resolvedXUserId = resolvedXUserId
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
         * .creditsAvailable()
         * .creditsRequired()
         * .estimatedResults()
         * .source()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ExtractionEstimateCostResponse =
            ExtractionEstimateCostResponse(
                checkRequired("allowed", allowed),
                checkRequired("creditsAvailable", creditsAvailable),
                checkRequired("creditsRequired", creditsRequired),
                checkRequired("estimatedResults", estimatedResults),
                checkRequired("source", source),
                resolvedXUserId,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ExtractionEstimateCostResponse = apply {
        if (validated) {
            return@apply
        }

        allowed()
        creditsAvailable()
        creditsRequired()
        estimatedResults()
        source()
        resolvedXUserId()
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
            (if (creditsAvailable.asKnown().isPresent) 1 else 0) +
            (if (creditsRequired.asKnown().isPresent) 1 else 0) +
            (if (estimatedResults.asKnown().isPresent) 1 else 0) +
            (if (source.asKnown().isPresent) 1 else 0) +
            (if (resolvedXUserId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExtractionEstimateCostResponse &&
            allowed == other.allowed &&
            creditsAvailable == other.creditsAvailable &&
            creditsRequired == other.creditsRequired &&
            estimatedResults == other.estimatedResults &&
            source == other.source &&
            resolvedXUserId == other.resolvedXUserId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            allowed,
            creditsAvailable,
            creditsRequired,
            estimatedResults,
            source,
            resolvedXUserId,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ExtractionEstimateCostResponse{allowed=$allowed, creditsAvailable=$creditsAvailable, creditsRequired=$creditsRequired, estimatedResults=$estimatedResults, source=$source, resolvedXUserId=$resolvedXUserId, additionalProperties=$additionalProperties}"
}
