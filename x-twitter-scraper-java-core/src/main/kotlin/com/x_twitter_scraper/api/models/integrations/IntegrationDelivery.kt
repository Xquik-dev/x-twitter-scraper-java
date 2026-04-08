// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.integrations

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** Integration delivery attempt record with status and retry count. */
class IntegrationDelivery
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val attempts: JsonField<Long>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val eventType: JsonField<String>,
    private val status: JsonField<String>,
    private val deliveredAt: JsonField<OffsetDateTime>,
    private val lastError: JsonField<String>,
    private val lastStatusCode: JsonField<Long>,
    private val sourceId: JsonField<String>,
    private val sourceType: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("attempts") @ExcludeMissing attempts: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("eventType") @ExcludeMissing eventType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("deliveredAt")
        @ExcludeMissing
        deliveredAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("lastError") @ExcludeMissing lastError: JsonField<String> = JsonMissing.of(),
        @JsonProperty("lastStatusCode")
        @ExcludeMissing
        lastStatusCode: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("sourceId") @ExcludeMissing sourceId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sourceType") @ExcludeMissing sourceType: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        attempts,
        createdAt,
        eventType,
        status,
        deliveredAt,
        lastError,
        lastStatusCode,
        sourceId,
        sourceType,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun attempts(): Long = attempts.getRequired("attempts")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventType(): String = eventType.getRequired("eventType")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): String = status.getRequired("status")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun deliveredAt(): Optional<OffsetDateTime> = deliveredAt.getOptional("deliveredAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun lastError(): Optional<String> = lastError.getOptional("lastError")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun lastStatusCode(): Optional<Long> = lastStatusCode.getOptional("lastStatusCode")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun sourceId(): Optional<String> = sourceId.getOptional("sourceId")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun sourceType(): Optional<String> = sourceType.getOptional("sourceType")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [attempts].
     *
     * Unlike [attempts], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("attempts") @ExcludeMissing fun _attempts(): JsonField<Long> = attempts

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [eventType].
     *
     * Unlike [eventType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("eventType") @ExcludeMissing fun _eventType(): JsonField<String> = eventType

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    /**
     * Returns the raw JSON value of [deliveredAt].
     *
     * Unlike [deliveredAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("deliveredAt")
    @ExcludeMissing
    fun _deliveredAt(): JsonField<OffsetDateTime> = deliveredAt

    /**
     * Returns the raw JSON value of [lastError].
     *
     * Unlike [lastError], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("lastError") @ExcludeMissing fun _lastError(): JsonField<String> = lastError

    /**
     * Returns the raw JSON value of [lastStatusCode].
     *
     * Unlike [lastStatusCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("lastStatusCode")
    @ExcludeMissing
    fun _lastStatusCode(): JsonField<Long> = lastStatusCode

    /**
     * Returns the raw JSON value of [sourceId].
     *
     * Unlike [sourceId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sourceId") @ExcludeMissing fun _sourceId(): JsonField<String> = sourceId

    /**
     * Returns the raw JSON value of [sourceType].
     *
     * Unlike [sourceType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sourceType") @ExcludeMissing fun _sourceType(): JsonField<String> = sourceType

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
         * Returns a mutable builder for constructing an instance of [IntegrationDelivery].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .attempts()
         * .createdAt()
         * .eventType()
         * .status()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [IntegrationDelivery]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var attempts: JsonField<Long>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var eventType: JsonField<String>? = null
        private var status: JsonField<String>? = null
        private var deliveredAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var lastError: JsonField<String> = JsonMissing.of()
        private var lastStatusCode: JsonField<Long> = JsonMissing.of()
        private var sourceId: JsonField<String> = JsonMissing.of()
        private var sourceType: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(integrationDelivery: IntegrationDelivery) = apply {
            id = integrationDelivery.id
            attempts = integrationDelivery.attempts
            createdAt = integrationDelivery.createdAt
            eventType = integrationDelivery.eventType
            status = integrationDelivery.status
            deliveredAt = integrationDelivery.deliveredAt
            lastError = integrationDelivery.lastError
            lastStatusCode = integrationDelivery.lastStatusCode
            sourceId = integrationDelivery.sourceId
            sourceType = integrationDelivery.sourceType
            additionalProperties = integrationDelivery.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun attempts(attempts: Long) = attempts(JsonField.of(attempts))

        /**
         * Sets [Builder.attempts] to an arbitrary JSON value.
         *
         * You should usually call [Builder.attempts] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun attempts(attempts: JsonField<Long>) = apply { this.attempts = attempts }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        fun eventType(eventType: String) = eventType(JsonField.of(eventType))

        /**
         * Sets [Builder.eventType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun eventType(eventType: JsonField<String>) = apply { this.eventType = eventType }

        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        fun deliveredAt(deliveredAt: OffsetDateTime) = deliveredAt(JsonField.of(deliveredAt))

        /**
         * Sets [Builder.deliveredAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deliveredAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun deliveredAt(deliveredAt: JsonField<OffsetDateTime>) = apply {
            this.deliveredAt = deliveredAt
        }

        fun lastError(lastError: String) = lastError(JsonField.of(lastError))

        /**
         * Sets [Builder.lastError] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastError] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun lastError(lastError: JsonField<String>) = apply { this.lastError = lastError }

        fun lastStatusCode(lastStatusCode: Long) = lastStatusCode(JsonField.of(lastStatusCode))

        /**
         * Sets [Builder.lastStatusCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastStatusCode] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun lastStatusCode(lastStatusCode: JsonField<Long>) = apply {
            this.lastStatusCode = lastStatusCode
        }

        fun sourceId(sourceId: String) = sourceId(JsonField.of(sourceId))

        /**
         * Sets [Builder.sourceId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sourceId(sourceId: JsonField<String>) = apply { this.sourceId = sourceId }

        fun sourceType(sourceType: String) = sourceType(JsonField.of(sourceType))

        /**
         * Sets [Builder.sourceType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sourceType(sourceType: JsonField<String>) = apply { this.sourceType = sourceType }

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
         * Returns an immutable instance of [IntegrationDelivery].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .attempts()
         * .createdAt()
         * .eventType()
         * .status()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): IntegrationDelivery =
            IntegrationDelivery(
                checkRequired("id", id),
                checkRequired("attempts", attempts),
                checkRequired("createdAt", createdAt),
                checkRequired("eventType", eventType),
                checkRequired("status", status),
                deliveredAt,
                lastError,
                lastStatusCode,
                sourceId,
                sourceType,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): IntegrationDelivery = apply {
        if (validated) {
            return@apply
        }

        id()
        attempts()
        createdAt()
        eventType()
        status()
        deliveredAt()
        lastError()
        lastStatusCode()
        sourceId()
        sourceType()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (attempts.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (eventType.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (deliveredAt.asKnown().isPresent) 1 else 0) +
            (if (lastError.asKnown().isPresent) 1 else 0) +
            (if (lastStatusCode.asKnown().isPresent) 1 else 0) +
            (if (sourceId.asKnown().isPresent) 1 else 0) +
            (if (sourceType.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is IntegrationDelivery &&
            id == other.id &&
            attempts == other.attempts &&
            createdAt == other.createdAt &&
            eventType == other.eventType &&
            status == other.status &&
            deliveredAt == other.deliveredAt &&
            lastError == other.lastError &&
            lastStatusCode == other.lastStatusCode &&
            sourceId == other.sourceId &&
            sourceType == other.sourceType &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            attempts,
            createdAt,
            eventType,
            status,
            deliveredAt,
            lastError,
            lastStatusCode,
            sourceId,
            sourceType,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "IntegrationDelivery{id=$id, attempts=$attempts, createdAt=$createdAt, eventType=$eventType, status=$status, deliveredAt=$deliveredAt, lastError=$lastError, lastStatusCode=$lastStatusCode, sourceId=$sourceId, sourceType=$sourceType, additionalProperties=$additionalProperties}"
}
