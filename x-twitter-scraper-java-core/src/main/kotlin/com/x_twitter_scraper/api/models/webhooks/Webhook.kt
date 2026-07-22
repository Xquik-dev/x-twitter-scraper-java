// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.webhooks

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
import com.x_twitter_scraper.api.models.EventType
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Webhook endpoint registered to receive event deliveries. */
class Webhook
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val consecutiveFailures: JsonField<Long>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val deliveryStatus: JsonField<DeliveryStatus>,
    private val eventTypes: JsonField<List<EventType>>,
    private val failureHardCap: JsonField<Long>,
    private val isActive: JsonField<Boolean>,
    private val url: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("consecutiveFailures")
        @ExcludeMissing
        consecutiveFailures: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("deliveryStatus")
        @ExcludeMissing
        deliveryStatus: JsonField<DeliveryStatus> = JsonMissing.of(),
        @JsonProperty("eventTypes")
        @ExcludeMissing
        eventTypes: JsonField<List<EventType>> = JsonMissing.of(),
        @JsonProperty("failureHardCap")
        @ExcludeMissing
        failureHardCap: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("isActive") @ExcludeMissing isActive: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        consecutiveFailures,
        createdAt,
        deliveryStatus,
        eventTypes,
        failureHardCap,
        isActive,
        url,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Consecutive failed delivery attempts since the last success.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun consecutiveFailures(): Long = consecutiveFailures.getRequired("consecutiveFailures")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

    /**
     * Endpoint delivery state. needs_attention means delivery stopped after repeated failures.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun deliveryStatus(): DeliveryStatus = deliveryStatus.getRequired("deliveryStatus")

    /**
     * Array of event types to subscribe to.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventTypes(): List<EventType> = eventTypes.getRequired("eventTypes")

    /**
     * Consecutive delivery failures that pause the endpoint.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun failureHardCap(): Long = failureHardCap.getRequired("failureHardCap")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isActive(): Boolean = isActive.getRequired("isActive")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun url(): String = url.getRequired("url")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [consecutiveFailures].
     *
     * Unlike [consecutiveFailures], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("consecutiveFailures")
    @ExcludeMissing
    fun _consecutiveFailures(): JsonField<Long> = consecutiveFailures

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [deliveryStatus].
     *
     * Unlike [deliveryStatus], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("deliveryStatus")
    @ExcludeMissing
    fun _deliveryStatus(): JsonField<DeliveryStatus> = deliveryStatus

    /**
     * Returns the raw JSON value of [eventTypes].
     *
     * Unlike [eventTypes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("eventTypes")
    @ExcludeMissing
    fun _eventTypes(): JsonField<List<EventType>> = eventTypes

    /**
     * Returns the raw JSON value of [failureHardCap].
     *
     * Unlike [failureHardCap], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("failureHardCap")
    @ExcludeMissing
    fun _failureHardCap(): JsonField<Long> = failureHardCap

    /**
     * Returns the raw JSON value of [isActive].
     *
     * Unlike [isActive], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isActive") @ExcludeMissing fun _isActive(): JsonField<Boolean> = isActive

    /**
     * Returns the raw JSON value of [url].
     *
     * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
         * Returns a mutable builder for constructing an instance of [Webhook].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .consecutiveFailures()
         * .createdAt()
         * .deliveryStatus()
         * .eventTypes()
         * .failureHardCap()
         * .isActive()
         * .url()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Webhook]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var consecutiveFailures: JsonField<Long>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var deliveryStatus: JsonField<DeliveryStatus>? = null
        private var eventTypes: JsonField<MutableList<EventType>>? = null
        private var failureHardCap: JsonField<Long>? = null
        private var isActive: JsonField<Boolean>? = null
        private var url: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(webhook: Webhook) = apply {
            id = webhook.id
            consecutiveFailures = webhook.consecutiveFailures
            createdAt = webhook.createdAt
            deliveryStatus = webhook.deliveryStatus
            eventTypes = webhook.eventTypes.map { it.toMutableList() }
            failureHardCap = webhook.failureHardCap
            isActive = webhook.isActive
            url = webhook.url
            additionalProperties = webhook.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Consecutive failed delivery attempts since the last success. */
        fun consecutiveFailures(consecutiveFailures: Long) =
            consecutiveFailures(JsonField.of(consecutiveFailures))

        /**
         * Sets [Builder.consecutiveFailures] to an arbitrary JSON value.
         *
         * You should usually call [Builder.consecutiveFailures] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun consecutiveFailures(consecutiveFailures: JsonField<Long>) = apply {
            this.consecutiveFailures = consecutiveFailures
        }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /**
         * Endpoint delivery state. needs_attention means delivery stopped after repeated failures.
         */
        fun deliveryStatus(deliveryStatus: DeliveryStatus) =
            deliveryStatus(JsonField.of(deliveryStatus))

        /**
         * Sets [Builder.deliveryStatus] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deliveryStatus] with a well-typed [DeliveryStatus] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun deliveryStatus(deliveryStatus: JsonField<DeliveryStatus>) = apply {
            this.deliveryStatus = deliveryStatus
        }

        /** Array of event types to subscribe to. */
        fun eventTypes(eventTypes: List<EventType>) = eventTypes(JsonField.of(eventTypes))

        /**
         * Sets [Builder.eventTypes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventTypes] with a well-typed `List<EventType>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun eventTypes(eventTypes: JsonField<List<EventType>>) = apply {
            this.eventTypes = eventTypes.map { it.toMutableList() }
        }

        /**
         * Adds a single [EventType] to [eventTypes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEventType(eventType: EventType) = apply {
            eventTypes =
                (eventTypes ?: JsonField.of(mutableListOf())).also {
                    checkKnown("eventTypes", it).add(eventType)
                }
        }

        /** Consecutive delivery failures that pause the endpoint. */
        fun failureHardCap(failureHardCap: Long) = failureHardCap(JsonField.of(failureHardCap))

        /**
         * Sets [Builder.failureHardCap] to an arbitrary JSON value.
         *
         * You should usually call [Builder.failureHardCap] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun failureHardCap(failureHardCap: JsonField<Long>) = apply {
            this.failureHardCap = failureHardCap
        }

        fun isActive(isActive: Boolean) = isActive(JsonField.of(isActive))

        /**
         * Sets [Builder.isActive] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isActive] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isActive(isActive: JsonField<Boolean>) = apply { this.isActive = isActive }

        fun url(url: String) = url(JsonField.of(url))

        /**
         * Sets [Builder.url] to an arbitrary JSON value.
         *
         * You should usually call [Builder.url] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun url(url: JsonField<String>) = apply { this.url = url }

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
         * Returns an immutable instance of [Webhook].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .consecutiveFailures()
         * .createdAt()
         * .deliveryStatus()
         * .eventTypes()
         * .failureHardCap()
         * .isActive()
         * .url()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Webhook =
            Webhook(
                checkRequired("id", id),
                checkRequired("consecutiveFailures", consecutiveFailures),
                checkRequired("createdAt", createdAt),
                checkRequired("deliveryStatus", deliveryStatus),
                checkRequired("eventTypes", eventTypes).map { it.toImmutable() },
                checkRequired("failureHardCap", failureHardCap),
                checkRequired("isActive", isActive),
                checkRequired("url", url),
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
    fun validate(): Webhook = apply {
        if (validated) {
            return@apply
        }

        id()
        consecutiveFailures()
        createdAt()
        deliveryStatus().validate()
        eventTypes().forEach { it.validate() }
        failureHardCap()
        isActive()
        url()
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
            (if (consecutiveFailures.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (deliveryStatus.asKnown().getOrNull()?.validity() ?: 0) +
            (eventTypes.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (failureHardCap.asKnown().isPresent) 1 else 0) +
            (if (isActive.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0)

    /** Endpoint delivery state. needs_attention means delivery stopped after repeated failures. */
    class DeliveryStatus @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val ACTIVE = of("active")

            @JvmField val PAUSED = of("paused")

            @JvmField val NEEDS_ATTENTION = of("needs_attention")

            @JvmStatic fun of(value: String) = DeliveryStatus(JsonField.of(value))
        }

        /** An enum containing [DeliveryStatus]'s known values. */
        enum class Known {
            ACTIVE,
            PAUSED,
            NEEDS_ATTENTION,
        }

        /**
         * An enum containing [DeliveryStatus]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [DeliveryStatus] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ACTIVE,
            PAUSED,
            NEEDS_ATTENTION,
            /**
             * An enum member indicating that [DeliveryStatus] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                ACTIVE -> Value.ACTIVE
                PAUSED -> Value.PAUSED
                NEEDS_ATTENTION -> Value.NEEDS_ATTENTION
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                ACTIVE -> Known.ACTIVE
                PAUSED -> Known.PAUSED
                NEEDS_ATTENTION -> Known.NEEDS_ATTENTION
                else -> throw XTwitterScraperInvalidDataException("Unknown DeliveryStatus: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
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
        fun validate(): DeliveryStatus = apply {
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

            return other is DeliveryStatus && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Webhook &&
            id == other.id &&
            consecutiveFailures == other.consecutiveFailures &&
            createdAt == other.createdAt &&
            deliveryStatus == other.deliveryStatus &&
            eventTypes == other.eventTypes &&
            failureHardCap == other.failureHardCap &&
            isActive == other.isActive &&
            url == other.url &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            consecutiveFailures,
            createdAt,
            deliveryStatus,
            eventTypes,
            failureHardCap,
            isActive,
            url,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Webhook{id=$id, consecutiveFailures=$consecutiveFailures, createdAt=$createdAt, deliveryStatus=$deliveryStatus, eventTypes=$eventTypes, failureHardCap=$failureHardCap, isActive=$isActive, url=$url, additionalProperties=$additionalProperties}"
}
