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
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ExtractionRunResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val allowed: JsonField<Boolean>,
    private val creditsAvailable: JsonField<String>,
    private val creditsRequired: JsonField<String>,
    private val estimatedResults: JsonField<Long>,
    private val source: JsonField<String>,
    private val resolvedXUserId: JsonField<String>,
    private val id: JsonField<String>,
    private val pollAfterMs: JsonField<Long>,
    private val statusUrl: JsonField<String>,
    private val waitUrl: JsonField<String>,
    private val toolType: JsonField<ExtractionJob.ToolType>,
    private val status: JsonField<Status>,
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
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("pollAfterMs")
        @ExcludeMissing
        pollAfterMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("statusUrl") @ExcludeMissing statusUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("waitUrl") @ExcludeMissing waitUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("toolType")
        @ExcludeMissing
        toolType: JsonField<ExtractionJob.ToolType> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
    ) : this(
        allowed,
        creditsAvailable,
        creditsRequired,
        estimatedResults,
        source,
        resolvedXUserId,
        id,
        pollAfterMs,
        statusUrl,
        waitUrl,
        toolType,
        status,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun allowed(): Boolean = allowed.getRequired("allowed")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun creditsAvailable(): String = creditsAvailable.getRequired("creditsAvailable")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun creditsRequired(): String = creditsRequired.getRequired("creditsRequired")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun estimatedResults(): Long = estimatedResults.getRequired("estimatedResults")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun source(): String = source.getRequired("source")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun resolvedXUserId(): Optional<String> = resolvedXUserId.getOptional("resolvedXUserId")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun id(): Optional<String> = id.getOptional("id")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun pollAfterMs(): Optional<Long> = pollAfterMs.getOptional("pollAfterMs")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun statusUrl(): Optional<String> = statusUrl.getOptional("statusUrl")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun waitUrl(): Optional<String> = waitUrl.getOptional("waitUrl")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun toolType(): Optional<ExtractionJob.ToolType> = toolType.getOptional("toolType")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun status(): Optional<Status> = status.getOptional("status")

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

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [pollAfterMs].
     *
     * Unlike [pollAfterMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("pollAfterMs") @ExcludeMissing fun _pollAfterMs(): JsonField<Long> = pollAfterMs

    /**
     * Returns the raw JSON value of [statusUrl].
     *
     * Unlike [statusUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("statusUrl") @ExcludeMissing fun _statusUrl(): JsonField<String> = statusUrl

    /**
     * Returns the raw JSON value of [waitUrl].
     *
     * Unlike [waitUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("waitUrl") @ExcludeMissing fun _waitUrl(): JsonField<String> = waitUrl

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
         * Returns a mutable builder for constructing an instance of [ExtractionRunResponse].
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

    /** A builder for [ExtractionRunResponse]. */
    class Builder internal constructor() {

        private var allowed: JsonField<Boolean>? = null
        private var creditsAvailable: JsonField<String>? = null
        private var creditsRequired: JsonField<String>? = null
        private var estimatedResults: JsonField<Long>? = null
        private var source: JsonField<String>? = null
        private var resolvedXUserId: JsonField<String> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var pollAfterMs: JsonField<Long> = JsonMissing.of()
        private var statusUrl: JsonField<String> = JsonMissing.of()
        private var waitUrl: JsonField<String> = JsonMissing.of()
        private var toolType: JsonField<ExtractionJob.ToolType> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(extractionRunResponse: ExtractionRunResponse) = apply {
            allowed = extractionRunResponse.allowed
            creditsAvailable = extractionRunResponse.creditsAvailable
            creditsRequired = extractionRunResponse.creditsRequired
            estimatedResults = extractionRunResponse.estimatedResults
            source = extractionRunResponse.source
            resolvedXUserId = extractionRunResponse.resolvedXUserId
            id = extractionRunResponse.id
            pollAfterMs = extractionRunResponse.pollAfterMs
            statusUrl = extractionRunResponse.statusUrl
            waitUrl = extractionRunResponse.waitUrl
            toolType = extractionRunResponse.toolType
            status = extractionRunResponse.status
            additionalProperties = extractionRunResponse.additionalProperties.toMutableMap()
        }

        fun allowed(allowed: Boolean) = allowed(JsonField.of(allowed))

        /** Sets [Builder.allowed] to an arbitrary JSON value. */
        fun allowed(allowed: JsonField<Boolean>) = apply { this.allowed = allowed }

        fun creditsAvailable(creditsAvailable: String) =
            creditsAvailable(JsonField.of(creditsAvailable))

        /** Sets [Builder.creditsAvailable] to an arbitrary JSON value. */
        fun creditsAvailable(creditsAvailable: JsonField<String>) = apply {
            this.creditsAvailable = creditsAvailable
        }

        fun creditsRequired(creditsRequired: String) =
            creditsRequired(JsonField.of(creditsRequired))

        /** Sets [Builder.creditsRequired] to an arbitrary JSON value. */
        fun creditsRequired(creditsRequired: JsonField<String>) = apply {
            this.creditsRequired = creditsRequired
        }

        fun estimatedResults(estimatedResults: Long) =
            estimatedResults(JsonField.of(estimatedResults))

        /** Sets [Builder.estimatedResults] to an arbitrary JSON value. */
        fun estimatedResults(estimatedResults: JsonField<Long>) = apply {
            this.estimatedResults = estimatedResults
        }

        fun source(source: String) = source(JsonField.of(source))

        /** Sets [Builder.source] to an arbitrary JSON value. */
        fun source(source: JsonField<String>) = apply { this.source = source }

        fun resolvedXUserId(resolvedXUserId: String) =
            resolvedXUserId(JsonField.of(resolvedXUserId))

        /** Sets [Builder.resolvedXUserId] to an arbitrary JSON value. */
        fun resolvedXUserId(resolvedXUserId: JsonField<String>) = apply {
            this.resolvedXUserId = resolvedXUserId
        }

        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun pollAfterMs(pollAfterMs: Long) = pollAfterMs(JsonField.of(pollAfterMs))

        /** Sets [Builder.pollAfterMs] to an arbitrary JSON value. */
        fun pollAfterMs(pollAfterMs: JsonField<Long>) = apply { this.pollAfterMs = pollAfterMs }

        fun statusUrl(statusUrl: String) = statusUrl(JsonField.of(statusUrl))

        /** Sets [Builder.statusUrl] to an arbitrary JSON value. */
        fun statusUrl(statusUrl: JsonField<String>) = apply { this.statusUrl = statusUrl }

        fun waitUrl(waitUrl: String) = waitUrl(JsonField.of(waitUrl))

        /** Sets [Builder.waitUrl] to an arbitrary JSON value. */
        fun waitUrl(waitUrl: JsonField<String>) = apply { this.waitUrl = waitUrl }

        fun toolType(toolType: ExtractionJob.ToolType) = toolType(JsonField.of(toolType))

        /** Sets [Builder.toolType] to an arbitrary JSON value. */
        fun toolType(toolType: JsonField<ExtractionJob.ToolType>) = apply {
            this.toolType = toolType
        }

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
         * Returns an immutable instance of [ExtractionRunResponse].
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
        fun build(): ExtractionRunResponse =
            ExtractionRunResponse(
                checkRequired("allowed", allowed),
                checkRequired("creditsAvailable", creditsAvailable),
                checkRequired("creditsRequired", creditsRequired),
                checkRequired("estimatedResults", estimatedResults),
                checkRequired("source", source),
                resolvedXUserId,
                id,
                pollAfterMs,
                statusUrl,
                waitUrl,
                toolType,
                status,
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
    fun validate(): ExtractionRunResponse = apply {
        if (validated) {
            return@apply
        }

        allowed()
        creditsAvailable()
        creditsRequired()
        estimatedResults()
        source()
        resolvedXUserId()
        id()
        pollAfterMs()
        statusUrl()
        waitUrl()
        toolType().ifPresent { it.validate() }
        status().ifPresent { it.validate() }
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
        (if (allowed.asKnown().isPresent) 1 else 0) +
            (if (creditsAvailable.asKnown().isPresent) 1 else 0) +
            (if (creditsRequired.asKnown().isPresent) 1 else 0) +
            (if (estimatedResults.asKnown().isPresent) 1 else 0) +
            (if (source.asKnown().isPresent) 1 else 0) +
            (if (resolvedXUserId.asKnown().isPresent) 1 else 0) +
            (if (id.asKnown().isPresent) 1 else 0) +
            (if (pollAfterMs.asKnown().isPresent) 1 else 0) +
            (if (statusUrl.asKnown().isPresent) 1 else 0) +
            (if (waitUrl.asKnown().isPresent) 1 else 0) +
            (toolType.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExtractionRunResponse &&
            allowed == other.allowed &&
            creditsAvailable == other.creditsAvailable &&
            creditsRequired == other.creditsRequired &&
            estimatedResults == other.estimatedResults &&
            source == other.source &&
            resolvedXUserId == other.resolvedXUserId &&
            id == other.id &&
            pollAfterMs == other.pollAfterMs &&
            statusUrl == other.statusUrl &&
            waitUrl == other.waitUrl &&
            toolType == other.toolType &&
            status == other.status &&
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
            id,
            pollAfterMs,
            statusUrl,
            waitUrl,
            toolType,
            status,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ExtractionRunResponse{allowed=$allowed, creditsAvailable=$creditsAvailable, creditsRequired=$creditsRequired, estimatedResults=$estimatedResults, source=$source, resolvedXUserId=$resolvedXUserId, id=$id, pollAfterMs=$pollAfterMs, statusUrl=$statusUrl, waitUrl=$waitUrl, toolType=$toolType, status=$status, additionalProperties=$additionalProperties}"

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
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PENDING,
            RUNNING,
            CANCELED,
            COMPLETED,
            FAILED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
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
}
