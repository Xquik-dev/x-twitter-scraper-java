// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.support.tickets

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TicketListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val tickets: JsonField<List<Ticket>>,
    private val hasMore: JsonField<Boolean>,
    private val nextCursor: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("tickets")
        @ExcludeMissing
        tickets: JsonField<List<Ticket>> = JsonMissing.of(),
        @JsonProperty("hasMore") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("nextCursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
    ) : this(
        tickets,
        hasMore,
        nextCursor,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun tickets(): List<Ticket> = tickets.getRequired("tickets")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun hasMore(): Optional<Boolean> = hasMore.getOptional("hasMore")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun nextCursor(): Optional<String> = nextCursor.getOptional("nextCursor")

    /**
     * Returns the raw JSON value of [tickets].
     *
     * Unlike [tickets], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tickets") @ExcludeMissing fun _tickets(): JsonField<List<Ticket>> = tickets

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
         * Returns a mutable builder for constructing an instance of [TicketListResponse].
         *
         * The following fields are required:
         * ```java
         * .tickets()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TicketListResponse]. */
    class Builder internal constructor() {

        private var tickets: JsonField<MutableList<Ticket>>? = null
        private var hasMore: JsonField<Boolean> = JsonMissing.of()
        private var nextCursor: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(ticketListResponse: TicketListResponse) = apply {
            tickets = ticketListResponse.tickets.map { it.toMutableList() }
            hasMore = ticketListResponse.hasMore
            nextCursor = ticketListResponse.nextCursor
            additionalProperties = ticketListResponse.additionalProperties.toMutableMap()
        }

        fun tickets(tickets: List<Ticket>) = tickets(JsonField.of(tickets))

        /** Sets [Builder.tickets] to an arbitrary JSON value. */
        fun tickets(tickets: JsonField<List<Ticket>>) = apply {
            this.tickets = tickets.map { it.toMutableList() }
        }

        /**
         * Adds a single [Ticket] to [tickets].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTicket(ticket: Ticket) = apply {
            tickets =
                (tickets ?: JsonField.of(mutableListOf())).also {
                    checkKnown("tickets", it).add(ticket)
                }
        }

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
         * Returns an immutable instance of [TicketListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .tickets()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TicketListResponse =
            TicketListResponse(
                checkRequired("tickets", tickets).map { it.toImmutable() },
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
    fun validate(): TicketListResponse = apply {
        if (validated) {
            return@apply
        }

        tickets().forEach { it.validate() }
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
        (tickets.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (hasMore.asKnown().isPresent) 1 else 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0)

    class Ticket
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val createdAt: JsonField<OffsetDateTime>,
        private val messageCount: JsonField<Long>,
        private val publicId: JsonField<String>,
        private val status: JsonField<Status>,
        private val subject: JsonField<String>,
        private val updatedAt: JsonField<OffsetDateTime>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("messageCount")
            @ExcludeMissing
            messageCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("publicId")
            @ExcludeMissing
            publicId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("subject") @ExcludeMissing subject: JsonField<String> = JsonMissing.of(),
            @JsonProperty("updatedAt")
            @ExcludeMissing
            updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(createdAt, messageCount, publicId, status, subject, updatedAt, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun messageCount(): Long = messageCount.getRequired("messageCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun publicId(): String = publicId.getRequired("publicId")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun status(): Status = status.getRequired("status")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun subject(): String = subject.getRequired("subject")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updatedAt")

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [messageCount].
         *
         * Unlike [messageCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("messageCount")
        @ExcludeMissing
        fun _messageCount(): JsonField<Long> = messageCount

        /**
         * Returns the raw JSON value of [publicId].
         *
         * Unlike [publicId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("publicId") @ExcludeMissing fun _publicId(): JsonField<String> = publicId

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [subject].
         *
         * Unlike [subject], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("subject") @ExcludeMissing fun _subject(): JsonField<String> = subject

        /**
         * Returns the raw JSON value of [updatedAt].
         *
         * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("updatedAt")
        @ExcludeMissing
        fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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
             * Returns a mutable builder for constructing an instance of [Ticket].
             *
             * The following fields are required:
             * ```java
             * .createdAt()
             * .messageCount()
             * .publicId()
             * .status()
             * .subject()
             * .updatedAt()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Ticket]. */
        class Builder internal constructor() {

            private var createdAt: JsonField<OffsetDateTime>? = null
            private var messageCount: JsonField<Long>? = null
            private var publicId: JsonField<String>? = null
            private var status: JsonField<Status>? = null
            private var subject: JsonField<String>? = null
            private var updatedAt: JsonField<OffsetDateTime>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(ticket: Ticket) = apply {
                createdAt = ticket.createdAt
                messageCount = ticket.messageCount
                publicId = ticket.publicId
                status = ticket.status
                subject = ticket.subject
                updatedAt = ticket.updatedAt
                additionalProperties = ticket.additionalProperties.toMutableMap()
            }

            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /** Sets [Builder.createdAt] to an arbitrary JSON value. */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            fun messageCount(messageCount: Long) = messageCount(JsonField.of(messageCount))

            /** Sets [Builder.messageCount] to an arbitrary JSON value. */
            fun messageCount(messageCount: JsonField<Long>) = apply {
                this.messageCount = messageCount
            }

            fun publicId(publicId: String) = publicId(JsonField.of(publicId))

            /** Sets [Builder.publicId] to an arbitrary JSON value. */
            fun publicId(publicId: JsonField<String>) = apply { this.publicId = publicId }

            fun status(status: Status) = status(JsonField.of(status))

            /** Sets [Builder.status] to an arbitrary JSON value. */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            fun subject(subject: String) = subject(JsonField.of(subject))

            /** Sets [Builder.subject] to an arbitrary JSON value. */
            fun subject(subject: JsonField<String>) = apply { this.subject = subject }

            fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

            /** Sets [Builder.updatedAt] to an arbitrary JSON value. */
            fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                this.updatedAt = updatedAt
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
             * Returns an immutable instance of [Ticket].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .createdAt()
             * .messageCount()
             * .publicId()
             * .status()
             * .subject()
             * .updatedAt()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Ticket =
                Ticket(
                    checkRequired("createdAt", createdAt),
                    checkRequired("messageCount", messageCount),
                    checkRequired("publicId", publicId),
                    checkRequired("status", status),
                    checkRequired("subject", subject),
                    checkRequired("updatedAt", updatedAt),
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
        fun validate(): Ticket = apply {
            if (validated) {
                return@apply
            }

            createdAt()
            messageCount()
            publicId()
            status().validate()
            subject()
            updatedAt()
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
            (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (messageCount.asKnown().isPresent) 1 else 0) +
                (if (publicId.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (subject.asKnown().isPresent) 1 else 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0)

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val OPEN = of("open")

                @JvmField val IN_PROGRESS = of("in_progress")

                @JvmField val RESOLVED = of("resolved")

                @JvmField val CLOSED = of("closed")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                OPEN,
                IN_PROGRESS,
                RESOLVED,
                CLOSED,
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
                OPEN,
                IN_PROGRESS,
                RESOLVED,
                CLOSED,
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
                    OPEN -> Value.OPEN
                    IN_PROGRESS -> Value.IN_PROGRESS
                    RESOLVED -> Value.RESOLVED
                    CLOSED -> Value.CLOSED
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
                    OPEN -> Known.OPEN
                    IN_PROGRESS -> Known.IN_PROGRESS
                    RESOLVED -> Known.RESOLVED
                    CLOSED -> Known.CLOSED
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

            return other is Ticket &&
                createdAt == other.createdAt &&
                messageCount == other.messageCount &&
                publicId == other.publicId &&
                status == other.status &&
                subject == other.subject &&
                updatedAt == other.updatedAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                createdAt,
                messageCount,
                publicId,
                status,
                subject,
                updatedAt,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Ticket{createdAt=$createdAt, messageCount=$messageCount, publicId=$publicId, status=$status, subject=$subject, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TicketListResponse &&
            tickets == other.tickets &&
            hasMore == other.hasMore &&
            nextCursor == other.nextCursor &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(tickets, hasMore, nextCursor, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TicketListResponse{tickets=$tickets, hasMore=$hasMore, nextCursor=$nextCursor, additionalProperties=$additionalProperties}"
}
