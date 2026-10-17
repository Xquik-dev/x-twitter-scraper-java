// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.monitors.keywords

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

class KeywordListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val monitors: JsonField<List<Monitor>>,
    private val total: JsonField<Long>,
    private val hasMore: JsonField<Boolean>,
    private val nextCursor: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("monitors")
        @ExcludeMissing
        monitors: JsonField<List<Monitor>> = JsonMissing.of(),
        @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("hasMore") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("nextCursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
    ) : this(
        monitors,
        total,
        hasMore,
        nextCursor,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun monitors(): List<Monitor> = monitors.getRequired("monitors")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun total(): Long = total.getRequired("total")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun hasMore(): Optional<Boolean> = hasMore.getOptional("hasMore")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun nextCursor(): Optional<String> = nextCursor.getOptional("nextCursor")

    /**
     * Returns the raw JSON value of [monitors].
     *
     * Unlike [monitors], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("monitors") @ExcludeMissing fun _monitors(): JsonField<List<Monitor>> = monitors

    /**
     * Returns the raw JSON value of [total].
     *
     * Unlike [total], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

    /**
     * Returns the raw JSON value of [hasMore].
     *
     * Unlike [hasMore], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hasMore") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

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
         * Returns a mutable builder for constructing an instance of [KeywordListResponse].
         *
         * The following fields are required:
         * ```java
         * .monitors()
         * .total()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [KeywordListResponse]. */
    class Builder internal constructor() {

        private var monitors: JsonField<MutableList<Monitor>>? = null
        private var total: JsonField<Long>? = null
        private var hasMore: JsonField<Boolean> = JsonMissing.of()
        private var nextCursor: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(keywordListResponse: KeywordListResponse) = apply {
            monitors = keywordListResponse.monitors.map { it.toMutableList() }
            total = keywordListResponse.total
            hasMore = keywordListResponse.hasMore
            nextCursor = keywordListResponse.nextCursor
            additionalProperties = keywordListResponse.additionalProperties.toMutableMap()
        }

        fun monitors(monitors: List<Monitor>) = monitors(JsonField.of(monitors))

        /** Sets [Builder.monitors] to an arbitrary JSON value. */
        fun monitors(monitors: JsonField<List<Monitor>>) = apply {
            this.monitors = monitors.map { it.toMutableList() }
        }

        /**
         * Adds a single [Monitor] to [monitors].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMonitor(monitor: Monitor) = apply {
            monitors =
                (monitors ?: JsonField.of(mutableListOf())).also {
                    checkKnown("monitors", it).add(monitor)
                }
        }

        fun total(total: Long) = total(JsonField.of(total))

        /** Sets [Builder.total] to an arbitrary JSON value. */
        fun total(total: JsonField<Long>) = apply { this.total = total }

        fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

        /** Sets [Builder.hasMore] to an arbitrary JSON value. */
        fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /** Sets [Builder.nextCursor] to an arbitrary JSON value. */
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
         * Returns an immutable instance of [KeywordListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .monitors()
         * .total()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): KeywordListResponse =
            KeywordListResponse(
                checkRequired("monitors", monitors).map { it.toImmutable() },
                checkRequired("total", total),
                hasMore,
                nextCursor,
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
    fun validate(): KeywordListResponse = apply {
        if (validated) {
            return@apply
        }

        monitors().forEach { it.validate() }
        total()
        hasMore()
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

    @JvmSynthetic
    internal fun validity(): Int =
        (monitors.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (total.asKnown().isPresent) 1 else 0) +
            (if (hasMore.asKnown().isPresent) 1 else 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0)

    /** Keyword monitor that tracks matching public X activity. */
    class Monitor
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val eventTypes: JsonField<List<EventType>>,
        private val isActive: JsonField<Boolean>,
        private val nextBillingAt: JsonField<OffsetDateTime>,
        private val query: JsonField<String>,
        private val name: JsonField<String>,
        private val pausedReason: JsonField<PausedReason>,
        private val pausedAt: JsonField<OffsetDateTime>,
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
            @JsonProperty("isActive")
            @ExcludeMissing
            isActive: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("nextBillingAt")
            @ExcludeMissing
            nextBillingAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("query") @ExcludeMissing query: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("pausedReason")
            @ExcludeMissing
            pausedReason: JsonField<PausedReason> = JsonMissing.of(),
            @JsonProperty("pausedAt")
            @ExcludeMissing
            pausedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(
            id,
            createdAt,
            eventTypes,
            isActive,
            nextBillingAt,
            query,
            name,
            pausedReason,
            pausedAt,
            mutableMapOf(),
        )

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

        /**
         * Array of event types to subscribe to.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun eventTypes(): List<EventType> = eventTypes.getRequired("eventTypes")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun isActive(): Boolean = isActive.getRequired("isActive")

        /**
         * Next hourly credit charge time for this keyword query monitor.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun nextBillingAt(): OffsetDateTime = nextBillingAt.getRequired("nextBillingAt")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun query(): String = query.getRequired("query")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun name(): Optional<String> = name.getOptional("name")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun pausedReason(): Optional<PausedReason> = pausedReason.getOptional("pausedReason")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun pausedAt(): Optional<OffsetDateTime> = pausedAt.getOptional("pausedAt")

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
         * Unlike [nextBillingAt], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("nextBillingAt")
        @ExcludeMissing
        fun _nextBillingAt(): JsonField<OffsetDateTime> = nextBillingAt

        /**
         * Returns the raw JSON value of [query].
         *
         * Unlike [query], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<String> = query

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [pausedReason].
         *
         * Unlike [pausedReason], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("pausedReason")
        @ExcludeMissing
        fun _pausedReason(): JsonField<PausedReason> = pausedReason

        /**
         * Returns the raw JSON value of [pausedAt].
         *
         * Unlike [pausedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("pausedAt")
        @ExcludeMissing
        fun _pausedAt(): JsonField<OffsetDateTime> = pausedAt

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
             * .query()
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
            private var query: JsonField<String>? = null
            private var name: JsonField<String> = JsonMissing.of()
            private var pausedReason: JsonField<PausedReason> = JsonMissing.of()
            private var pausedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(monitor: Monitor) = apply {
                id = monitor.id
                createdAt = monitor.createdAt
                eventTypes = monitor.eventTypes.map { it.toMutableList() }
                isActive = monitor.isActive
                nextBillingAt = monitor.nextBillingAt
                query = monitor.query
                name = monitor.name
                pausedReason = monitor.pausedReason
                pausedAt = monitor.pausedAt
                additionalProperties = monitor.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /** Sets [Builder.createdAt] to an arbitrary JSON value. */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            /** Array of event types to subscribe to. */
            fun eventTypes(eventTypes: List<EventType>) = eventTypes(JsonField.of(eventTypes))

            /** Sets [Builder.eventTypes] to an arbitrary JSON value. */
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

            /** Sets [Builder.isActive] to an arbitrary JSON value. */
            fun isActive(isActive: JsonField<Boolean>) = apply { this.isActive = isActive }

            /** Next hourly credit charge time for this keyword query monitor. */
            fun nextBillingAt(nextBillingAt: OffsetDateTime) =
                nextBillingAt(JsonField.of(nextBillingAt))

            /** Sets [Builder.nextBillingAt] to an arbitrary JSON value. */
            fun nextBillingAt(nextBillingAt: JsonField<OffsetDateTime>) = apply {
                this.nextBillingAt = nextBillingAt
            }

            fun query(query: String) = query(JsonField.of(query))

            /** Sets [Builder.query] to an arbitrary JSON value. */
            fun query(query: JsonField<String>) = apply { this.query = query }

            fun name(name: String) = name(JsonField.of(name))

            /** Sets [Builder.name] to an arbitrary JSON value. */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun pausedReason(pausedReason: PausedReason) = pausedReason(JsonField.of(pausedReason))

            /** Sets [Builder.pausedReason] to an arbitrary JSON value. */
            fun pausedReason(pausedReason: JsonField<PausedReason>) = apply {
                this.pausedReason = pausedReason
            }

            fun pausedAt(pausedAt: OffsetDateTime) = pausedAt(JsonField.of(pausedAt))

            /** Sets [Builder.pausedAt] to an arbitrary JSON value. */
            fun pausedAt(pausedAt: JsonField<OffsetDateTime>) = apply { this.pausedAt = pausedAt }

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
             * .query()
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
                    checkRequired("query", query),
                    name,
                    pausedReason,
                    pausedAt,
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
        fun validate(): Monitor = apply {
            if (validated) {
                return@apply
            }

            id()
            createdAt()
            eventTypes().forEach { it.validate() }
            isActive()
            nextBillingAt()
            query()
            name()
            pausedReason().ifPresent { it.validate() }
            pausedAt()
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
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (eventTypes.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (isActive.asKnown().isPresent) 1 else 0) +
                (if (nextBillingAt.asKnown().isPresent) 1 else 0) +
                (if (query.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (pausedReason.asKnown().getOrNull()?.validity() ?: 0) +
                (if (pausedAt.asKnown().isPresent) 1 else 0)

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
                query == other.query &&
                name == other.name &&
                pausedReason == other.pausedReason &&
                pausedAt == other.pausedAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                createdAt,
                eventTypes,
                isActive,
                nextBillingAt,
                query,
                name,
                pausedReason,
                pausedAt,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Monitor{id=$id, createdAt=$createdAt, eventTypes=$eventTypes, isActive=$isActive, nextBillingAt=$nextBillingAt, query=$query, name=$name, pausedReason=$pausedReason, pausedAt=$pausedAt, additionalProperties=$additionalProperties}"

        class PausedReason @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val INSUFFICIENT_CREDITS = of("insufficient_credits")

                @JvmStatic fun of(value: String) = PausedReason(JsonField.of(value))
            }

            /** An enum containing [PausedReason]'s known values. */
            enum class Known {
                INSUFFICIENT_CREDITS
            }

            /**
             * An enum containing [PausedReason]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [PausedReason] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                INSUFFICIENT_CREDITS,
                /**
                 * An enum member indicating that [PausedReason] was instantiated with an unknown
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
                    INSUFFICIENT_CREDITS -> Value.INSUFFICIENT_CREDITS
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
                    INSUFFICIENT_CREDITS -> Known.INSUFFICIENT_CREDITS
                    else ->
                        throw XTwitterScraperInvalidDataException("Unknown PausedReason: $value")
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
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is KeywordListResponse &&
            monitors == other.monitors &&
            total == other.total &&
            hasMore == other.hasMore &&
            nextCursor == other.nextCursor &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(monitors, total, hasMore, nextCursor, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "KeywordListResponse{monitors=$monitors, total=$total, hasMore=$hasMore, nextCursor=$nextCursor, additionalProperties=$additionalProperties}"
}
