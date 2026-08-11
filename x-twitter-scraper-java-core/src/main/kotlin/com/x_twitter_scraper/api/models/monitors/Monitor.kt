// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.monitors

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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Account monitor that tracks activity for a given X user. */
class Monitor
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val eventTypes: JsonField<List<EventType>>,
    private val isActive: JsonField<Boolean>,
    private val nextBillingAt: JsonField<OffsetDateTime>,
    private val username: JsonField<String>,
    private val xUserId: JsonField<String>,
    private val pausedAt: JsonField<OffsetDateTime>,
    private val pausedReason: JsonField<PausedReason>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("eventTypes")
        @ExcludeMissing
        eventTypes: JsonField<List<EventType>> = JsonMissing.of(),
        @JsonProperty("isActive") @ExcludeMissing isActive: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("nextBillingAt")
        @ExcludeMissing
        nextBillingAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("username") @ExcludeMissing username: JsonField<String> = JsonMissing.of(),
        @JsonProperty("xUserId") @ExcludeMissing xUserId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("pausedAt")
        @ExcludeMissing
        pausedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("pausedReason")
        @ExcludeMissing
        pausedReason: JsonField<PausedReason> = JsonMissing.of(),
    ) : this(
        id,
        createdAt,
        eventTypes,
        isActive,
        nextBillingAt,
        username,
        xUserId,
        pausedAt,
        pausedReason,
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
    fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

    /**
     * Array of event types to subscribe to.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun eventTypes(): List<EventType> = eventTypes.getRequired("eventTypes")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isActive(): Boolean = isActive.getRequired("isActive")

    /**
     * Next hourly credit charge time for this account monitor.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun nextBillingAt(): OffsetDateTime = nextBillingAt.getRequired("nextBillingAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun username(): String = username.getRequired("username")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun xUserId(): String = xUserId.getRequired("xUserId")

    /**
     * When Xquik automatically paused this monitor.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun pausedAt(): Optional<OffsetDateTime> = pausedAt.getOptional("pausedAt")

    /**
     * Why Xquik automatically paused this monitor.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun pausedReason(): Optional<PausedReason> = pausedReason.getOptional("pausedReason")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [eventTypes].
     *
     * Unlike [eventTypes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("eventTypes")
    @ExcludeMissing
    fun _eventTypes(): JsonField<List<EventType>> = eventTypes

    /**
     * Returns the raw JSON value of [isActive].
     *
     * Unlike [isActive], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isActive") @ExcludeMissing fun _isActive(): JsonField<Boolean> = isActive

    /**
     * Returns the raw JSON value of [nextBillingAt].
     *
     * Unlike [nextBillingAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("nextBillingAt")
    @ExcludeMissing
    fun _nextBillingAt(): JsonField<OffsetDateTime> = nextBillingAt

    /**
     * Returns the raw JSON value of [username].
     *
     * Unlike [username], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

    /**
     * Returns the raw JSON value of [xUserId].
     *
     * Unlike [xUserId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("xUserId") @ExcludeMissing fun _xUserId(): JsonField<String> = xUserId

    /**
     * Returns the raw JSON value of [pausedAt].
     *
     * Unlike [pausedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("pausedAt") @ExcludeMissing fun _pausedAt(): JsonField<OffsetDateTime> = pausedAt

    /**
     * Returns the raw JSON value of [pausedReason].
     *
     * Unlike [pausedReason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("pausedReason")
    @ExcludeMissing
    fun _pausedReason(): JsonField<PausedReason> = pausedReason

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
         * .id()
         * .createdAt()
         * .eventTypes()
         * .isActive()
         * .nextBillingAt()
         * .username()
         * .xUserId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Monitor]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var eventTypes: JsonField<MutableList<EventType>>? = null
        private var isActive: JsonField<Boolean>? = null
        private var nextBillingAt: JsonField<OffsetDateTime>? = null
        private var username: JsonField<String>? = null
        private var xUserId: JsonField<String>? = null
        private var pausedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var pausedReason: JsonField<PausedReason> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(monitor: Monitor) = apply {
            id = monitor.id
            createdAt = monitor.createdAt
            eventTypes = monitor.eventTypes.map { it.toMutableList() }
            isActive = monitor.isActive
            nextBillingAt = monitor.nextBillingAt
            username = monitor.username
            xUserId = monitor.xUserId
            pausedAt = monitor.pausedAt
            pausedReason = monitor.pausedReason
            additionalProperties = monitor.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

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

        fun isActive(isActive: Boolean) = isActive(JsonField.of(isActive))

        /**
         * Sets [Builder.isActive] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isActive] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isActive(isActive: JsonField<Boolean>) = apply { this.isActive = isActive }

        /** Next hourly credit charge time for this account monitor. */
        fun nextBillingAt(nextBillingAt: OffsetDateTime) =
            nextBillingAt(JsonField.of(nextBillingAt))

        /**
         * Sets [Builder.nextBillingAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextBillingAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun nextBillingAt(nextBillingAt: JsonField<OffsetDateTime>) = apply {
            this.nextBillingAt = nextBillingAt
        }

        fun username(username: String) = username(JsonField.of(username))

        /**
         * Sets [Builder.username] to an arbitrary JSON value.
         *
         * You should usually call [Builder.username] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun username(username: JsonField<String>) = apply { this.username = username }

        fun xUserId(xUserId: String) = xUserId(JsonField.of(xUserId))

        /**
         * Sets [Builder.xUserId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.xUserId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun xUserId(xUserId: JsonField<String>) = apply { this.xUserId = xUserId }

        /** When Xquik automatically paused this monitor. */
        fun pausedAt(pausedAt: OffsetDateTime) = pausedAt(JsonField.of(pausedAt))

        /**
         * Sets [Builder.pausedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pausedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun pausedAt(pausedAt: JsonField<OffsetDateTime>) = apply { this.pausedAt = pausedAt }

        /** Why Xquik automatically paused this monitor. */
        fun pausedReason(pausedReason: PausedReason) = pausedReason(JsonField.of(pausedReason))

        /**
         * Sets [Builder.pausedReason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pausedReason] with a well-typed [PausedReason] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun pausedReason(pausedReason: JsonField<PausedReason>) = apply {
            this.pausedReason = pausedReason
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
         * Returns an immutable instance of [Monitor].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .eventTypes()
         * .isActive()
         * .nextBillingAt()
         * .username()
         * .xUserId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Monitor =
            Monitor(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("eventTypes", eventTypes).map { it.toImmutable() },
                checkRequired("isActive", isActive),
                checkRequired("nextBillingAt", nextBillingAt),
                checkRequired("username", username),
                checkRequired("xUserId", xUserId),
                pausedAt,
                pausedReason,
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
    fun validate(): Monitor = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        eventTypes().forEach { it.validate() }
        isActive()
        nextBillingAt()
        username()
        xUserId()
        pausedAt()
        pausedReason().ifPresent { it.validate() }
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
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (eventTypes.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (isActive.asKnown().isPresent) 1 else 0) +
            (if (nextBillingAt.asKnown().isPresent) 1 else 0) +
            (if (username.asKnown().isPresent) 1 else 0) +
            (if (xUserId.asKnown().isPresent) 1 else 0) +
            (if (pausedAt.asKnown().isPresent) 1 else 0) +
            (pausedReason.asKnown().getOrNull()?.validity() ?: 0)

    /** Why Xquik automatically paused this monitor. */
    class PausedReason @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val X_USER_NOT_FOUND = of("x_user_not_found")

            @JvmStatic fun of(value: String) = PausedReason(JsonField.of(value))
        }

        /** An enum containing [PausedReason]'s known values. */
        enum class Known {
            X_USER_NOT_FOUND
        }

        /**
         * An enum containing [PausedReason]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [PausedReason] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            X_USER_NOT_FOUND,
            /**
             * An enum member indicating that [PausedReason] was instantiated with an unknown value.
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
                X_USER_NOT_FOUND -> Value.X_USER_NOT_FOUND
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
                X_USER_NOT_FOUND -> Known.X_USER_NOT_FOUND
                else -> throw XTwitterScraperInvalidDataException("Unknown PausedReason: $value")
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
        fun validate(): PausedReason = apply {
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

            return other is PausedReason && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Monitor &&
            id == other.id &&
            createdAt == other.createdAt &&
            eventTypes == other.eventTypes &&
            isActive == other.isActive &&
            nextBillingAt == other.nextBillingAt &&
            username == other.username &&
            xUserId == other.xUserId &&
            pausedAt == other.pausedAt &&
            pausedReason == other.pausedReason &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            eventTypes,
            isActive,
            nextBillingAt,
            username,
            xUserId,
            pausedAt,
            pausedReason,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Monitor{id=$id, createdAt=$createdAt, eventTypes=$eventTypes, isActive=$isActive, nextBillingAt=$nextBillingAt, username=$username, xUserId=$xUserId, pausedAt=$pausedAt, pausedReason=$pausedReason, additionalProperties=$additionalProperties}"
}
