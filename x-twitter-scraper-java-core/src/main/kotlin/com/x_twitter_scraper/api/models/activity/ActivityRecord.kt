// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.activity

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

/** Full technical record of 1 activity. Timestamps are ISO 8601 in UTC to the millisecond. */
class ActivityRecord
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val object_: JsonField<Object>,
    private val id: JsonField<String>,
    private val kind: JsonField<Kind>,
    private val type: JsonField<String>,
    private val status: JsonField<Status>,
    private val url: JsonField<String>,
    private val requestId: JsonField<String>,
    private val timestamps: JsonField<Timestamps>,
    private val request: JsonField<Request>,
    private val caller: JsonField<Caller>,
    private val charge: JsonField<Charge>,
    private val details: JsonField<Details>,
    private val related: JsonField<List<Related>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("object") @ExcludeMissing object_: JsonField<Object> = JsonMissing.of(),
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("kind") @ExcludeMissing kind: JsonField<Kind> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        @JsonProperty("requestId") @ExcludeMissing requestId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("timestamps") @ExcludeMissing timestamps: JsonField<Timestamps> = JsonMissing.of(),
        @JsonProperty("request") @ExcludeMissing request: JsonField<Request> = JsonMissing.of(),
        @JsonProperty("caller") @ExcludeMissing caller: JsonField<Caller> = JsonMissing.of(),
        @JsonProperty("charge") @ExcludeMissing charge: JsonField<Charge> = JsonMissing.of(),
        @JsonProperty("details") @ExcludeMissing details: JsonField<Details> = JsonMissing.of(),
        @JsonProperty("related") @ExcludeMissing related: JsonField<List<Related>> = JsonMissing.of(),
    ) : this(object_, id, kind, type, status, url, requestId, timestamps, request, caller, charge, details, related, mutableMapOf())

    fun object_(): Object = object_.getRequired("object")

    /** Activity ID. */
    fun id(): String = id.getRequired("id")

    /** Kind of the activity. Only a signed-in dashboard session sees an `api_key` record. */
    fun kind(): Kind = kind.getRequired("kind")

    /** Type of the activity within its kind, the same as the type of its Activity log row. Examples are a write action type, an extraction tool type, a monitor change, a monitor event type or a ledger entry type. */
    fun type(): String = type.getRequired("type")

    fun status(): Status = status.getRequired("status")

    /** Dashboard page of this activity. */
    fun url(): String = url.getRequired("url")

    /** ID of the API request behind this activity. */
    fun requestId(): Optional<String> = requestId.getOptional("requestId")

    fun timestamps(): Timestamps = timestamps.getRequired("timestamps")

    /** The API request behind this activity. Null for activity from before Oct 30, 2026, and for activity no API request starts, such as a monitor event, a webhook delivery or a credit grant. */
    fun request(): Optional<Request> = request.getOptional("request")

    fun caller(): Caller = caller.getRequired("caller")

    /** Credits charged for this activity. */
    fun charge(): Optional<Charge> = charge.getOptional("charge")

    /** Fields of this kind of activity, such as its target. A field can hold JSON, such as the data of a monitor event or the payload of a webhook delivery. */
    fun details(): Details = details.getRequired("details")

    /** Up to 5 other activities on the same subject within 7 days, newest first. */
    fun related(): List<Related> = related.getRequired("related")

    /** Returns the raw JSON value of [object_]. */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Returns the raw JSON value of [kind]. */
    @JsonProperty("kind") @ExcludeMissing fun _kind(): JsonField<Kind> = kind

    /** Returns the raw JSON value of [type]. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

    /** Returns the raw JSON value of [status]. */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /** Returns the raw JSON value of [url]. */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

    /** Returns the raw JSON value of [requestId]. */
    @JsonProperty("requestId") @ExcludeMissing fun _requestId(): JsonField<String> = requestId

    /** Returns the raw JSON value of [timestamps]. */
    @JsonProperty("timestamps") @ExcludeMissing fun _timestamps(): JsonField<Timestamps> = timestamps

    /** Returns the raw JSON value of [request]. */
    @JsonProperty("request") @ExcludeMissing fun _request(): JsonField<Request> = request

    /** Returns the raw JSON value of [caller]. */
    @JsonProperty("caller") @ExcludeMissing fun _caller(): JsonField<Caller> = caller

    /** Returns the raw JSON value of [charge]. */
    @JsonProperty("charge") @ExcludeMissing fun _charge(): JsonField<Charge> = charge

    /** Returns the raw JSON value of [details]. */
    @JsonProperty("details") @ExcludeMissing fun _details(): JsonField<Details> = details

    /** Returns the raw JSON value of [related]. */
    @JsonProperty("related") @ExcludeMissing fun _related(): JsonField<List<Related>> = related

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

        /** Returns a mutable builder for constructing an instance of [ActivityRecord]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ActivityRecord]. */
    class Builder internal constructor() {

        private var object_: JsonField<Object>? = null
        private var id: JsonField<String>? = null
        private var kind: JsonField<Kind>? = null
        private var type: JsonField<String>? = null
        private var status: JsonField<Status>? = null
        private var url: JsonField<String>? = null
        private var requestId: JsonField<String>? = null
        private var timestamps: JsonField<Timestamps>? = null
        private var request: JsonField<Request>? = null
        private var caller: JsonField<Caller>? = null
        private var charge: JsonField<Charge>? = null
        private var details: JsonField<Details>? = null
        private var related: JsonField<MutableList<Related>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(activityRecord: ActivityRecord) = apply {
            object_ = activityRecord.object_
            id = activityRecord.id
            kind = activityRecord.kind
            type = activityRecord.type
            status = activityRecord.status
            url = activityRecord.url
            requestId = activityRecord.requestId
            timestamps = activityRecord.timestamps
            request = activityRecord.request
            caller = activityRecord.caller
            charge = activityRecord.charge
            details = activityRecord.details
            related = activityRecord.related.map { it.toMutableList() }
            additionalProperties = activityRecord.additionalProperties.toMutableMap()
        }

        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** Sets [Builder.object_] to an arbitrary JSON value. */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** Activity ID. */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Kind of the activity. Only a signed-in dashboard session sees an `api_key` record. */
        fun kind(kind: Kind) = kind(JsonField.of(kind))

        /** Sets [Builder.kind] to an arbitrary JSON value. */
        fun kind(kind: JsonField<Kind>) = apply { this.kind = kind }

        /** Type of the activity within its kind, the same as the type of its Activity log row. Examples are a write action type, an extraction tool type, a monitor change, a monitor event type or a ledger entry type. */
        fun type(type: String) = type(JsonField.of(type))

        /** Sets [Builder.type] to an arbitrary JSON value. */
        fun type(type: JsonField<String>) = apply { this.type = type }

        fun status(status: Status) = status(JsonField.of(status))

        /** Sets [Builder.status] to an arbitrary JSON value. */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** Dashboard page of this activity. */
        fun url(url: String) = url(JsonField.of(url))

        /** Sets [Builder.url] to an arbitrary JSON value. */
        fun url(url: JsonField<String>) = apply { this.url = url }

        /** ID of the API request behind this activity. */
        fun requestId(requestId: String?) = requestId(JsonField.ofNullable(requestId))

        /** Alias for calling [Builder.requestId] with `requestId.orElse(null)`. */
        fun requestId(requestId: Optional<String>) = requestId(requestId.getOrNull())

        /** Sets [Builder.requestId] to an arbitrary JSON value. */
        fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

        fun timestamps(timestamps: Timestamps) = timestamps(JsonField.of(timestamps))

        /** Sets [Builder.timestamps] to an arbitrary JSON value. */
        fun timestamps(timestamps: JsonField<Timestamps>) = apply { this.timestamps = timestamps }

        /** The API request behind this activity. Null for activity from before Oct 30, 2026, and for activity no API request starts, such as a monitor event, a webhook delivery or a credit grant. */
        fun request(request: Request?) = request(JsonField.ofNullable(request))

        /** Alias for calling [Builder.request] with `request.orElse(null)`. */
        fun request(request: Optional<Request>) = request(request.getOrNull())

        /** Sets [Builder.request] to an arbitrary JSON value. */
        fun request(request: JsonField<Request>) = apply { this.request = request }

        fun caller(caller: Caller) = caller(JsonField.of(caller))

        /** Sets [Builder.caller] to an arbitrary JSON value. */
        fun caller(caller: JsonField<Caller>) = apply { this.caller = caller }

        /** Credits charged for this activity. */
        fun charge(charge: Charge?) = charge(JsonField.ofNullable(charge))

        /** Alias for calling [Builder.charge] with `charge.orElse(null)`. */
        fun charge(charge: Optional<Charge>) = charge(charge.getOrNull())

        /** Sets [Builder.charge] to an arbitrary JSON value. */
        fun charge(charge: JsonField<Charge>) = apply { this.charge = charge }

        /** Fields of this kind of activity, such as its target. A field can hold JSON, such as the data of a monitor event or the payload of a webhook delivery. */
        fun details(details: Details) = details(JsonField.of(details))

        /** Sets [Builder.details] to an arbitrary JSON value. */
        fun details(details: JsonField<Details>) = apply { this.details = details }

        /** Up to 5 other activities on the same subject within 7 days, newest first. */
        fun related(related: List<Related>) = related(JsonField.of(related))

        /** Sets [Builder.related] to an arbitrary JSON value. */
        fun related(related: JsonField<List<Related>>) = apply { this.related = related.map { it.toMutableList() } }

        /** Adds a single [Related] to [related]. */
        fun addRelatedItem(relatedItem: Related) = apply {
            related =
                (related ?: JsonField.of(mutableListOf())).also {
                    checkKnown("related", it).add(relatedItem)
                }
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
         * Returns an immutable instance of [ActivityRecord].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ActivityRecord =
            ActivityRecord(
                checkRequired("object_", object_),
                checkRequired("id", id),
                checkRequired("kind", kind),
                checkRequired("type", type),
                checkRequired("status", status),
                checkRequired("url", url),
                checkRequired("requestId", requestId),
                checkRequired("timestamps", timestamps),
                checkRequired("request", request),
                checkRequired("caller", caller),
                checkRequired("charge", charge),
                checkRequired("details", details),
                checkRequired("related", related).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match its expected type.
     */
    fun validate(): ActivityRecord = apply {
        if (validated) {
            return@apply
        }

        object_().validate()
        id()
        kind().validate()
        type()
        status().validate()
        url()
        requestId()
        timestamps().validate()
        request().ifPresent { it.validate() }
        caller().validate()
        charge().ifPresent { it.validate() }
        details().validate()
        related().forEach { it.validate() }
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    @JvmSynthetic internal fun validity(): Int =
        (object_.asKnown().getOrNull()?.validity() ?: 0) +
            (if (id.asKnown().isPresent) 1 else 0) +
            (kind.asKnown().getOrNull()?.validity() ?: 0) +
            (if (type.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (url.asKnown().isPresent) 1 else 0) +
            (if (requestId.asKnown().isPresent) 1 else 0) +
            (timestamps.asKnown().getOrNull()?.validity() ?: 0) +
            (request.asKnown().getOrNull()?.validity() ?: 0) +
            (caller.asKnown().getOrNull()?.validity() ?: 0) +
            (charge.asKnown().getOrNull()?.validity() ?: 0) +
            (details.asKnown().getOrNull()?.validity() ?: 0) +
            (related.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

    class Object @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val ACTIVITY = of("activity")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        /** An enum containing [Object]'s known values. */
        enum class Known {
            ACTIVITY,
        }

        /** An enum containing [Object]'s known values, as well as an [_UNKNOWN] member. */
        enum class Value {
            ACTIVITY,
            /** An enum member indicating that [Object] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /** Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if unknown. */
        fun value(): Value =
            when (this) {
                ACTIVITY -> Value.ACTIVITY
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                ACTIVITY -> Known.ACTIVITY
                else -> throw XTwitterScraperInvalidDataException("Unknown Object: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { XTwitterScraperInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        /** Validates that this value is a known member. */
        fun validate(): Object = apply {
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

            return other is Object && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Kind of the activity. Only a signed-in dashboard session sees an `api_key` record. */
    class Kind @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val WRITE_ACTION = of("write_action")

            @JvmField val EXTRACTION = of("extraction")

            @JvmField val MONITOR_CHANGE = of("monitor_change")

            @JvmField val API_KEY = of("api_key")

            @JvmField val BILLING = of("billing")

            @JvmField val GIVEAWAY_DRAW = of("giveaway_draw")

            @JvmField val MONITOR_EVENT = of("monitor_event")

            @JvmField val MEDIA_DOWNLOAD = of("media_download")

            @JvmField val MEDIA_SHARE = of("media_share")

            @JvmField val SUPPORT_TICKET = of("support_ticket")

            @JvmField val WEBHOOK_DELIVERY = of("webhook_delivery")

            @JvmField val WEBHOOK_ENDPOINT = of("webhook_endpoint")

            @JvmField val X_ACCOUNT_CONNECTION = of("x_account_connection")

            @JvmStatic fun of(value: String) = Kind(JsonField.of(value))
        }

        /** An enum containing [Kind]'s known values. */
        enum class Known {
            WRITE_ACTION,
            EXTRACTION,
            MONITOR_CHANGE,
            API_KEY,
            BILLING,
            GIVEAWAY_DRAW,
            MONITOR_EVENT,
            MEDIA_DOWNLOAD,
            MEDIA_SHARE,
            SUPPORT_TICKET,
            WEBHOOK_DELIVERY,
            WEBHOOK_ENDPOINT,
            X_ACCOUNT_CONNECTION,
        }

        /** An enum containing [Kind]'s known values, as well as an [_UNKNOWN] member. */
        enum class Value {
            WRITE_ACTION,
            EXTRACTION,
            MONITOR_CHANGE,
            API_KEY,
            BILLING,
            GIVEAWAY_DRAW,
            MONITOR_EVENT,
            MEDIA_DOWNLOAD,
            MEDIA_SHARE,
            SUPPORT_TICKET,
            WEBHOOK_DELIVERY,
            WEBHOOK_ENDPOINT,
            X_ACCOUNT_CONNECTION,
            /** An enum member indicating that [Kind] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /** Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if unknown. */
        fun value(): Value =
            when (this) {
                WRITE_ACTION -> Value.WRITE_ACTION
                EXTRACTION -> Value.EXTRACTION
                MONITOR_CHANGE -> Value.MONITOR_CHANGE
                API_KEY -> Value.API_KEY
                BILLING -> Value.BILLING
                GIVEAWAY_DRAW -> Value.GIVEAWAY_DRAW
                MONITOR_EVENT -> Value.MONITOR_EVENT
                MEDIA_DOWNLOAD -> Value.MEDIA_DOWNLOAD
                MEDIA_SHARE -> Value.MEDIA_SHARE
                SUPPORT_TICKET -> Value.SUPPORT_TICKET
                WEBHOOK_DELIVERY -> Value.WEBHOOK_DELIVERY
                WEBHOOK_ENDPOINT -> Value.WEBHOOK_ENDPOINT
                X_ACCOUNT_CONNECTION -> Value.X_ACCOUNT_CONNECTION
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                WRITE_ACTION -> Known.WRITE_ACTION
                EXTRACTION -> Known.EXTRACTION
                MONITOR_CHANGE -> Known.MONITOR_CHANGE
                API_KEY -> Known.API_KEY
                BILLING -> Known.BILLING
                GIVEAWAY_DRAW -> Known.GIVEAWAY_DRAW
                MONITOR_EVENT -> Known.MONITOR_EVENT
                MEDIA_DOWNLOAD -> Known.MEDIA_DOWNLOAD
                MEDIA_SHARE -> Known.MEDIA_SHARE
                SUPPORT_TICKET -> Known.SUPPORT_TICKET
                WEBHOOK_DELIVERY -> Known.WEBHOOK_DELIVERY
                WEBHOOK_ENDPOINT -> Known.WEBHOOK_ENDPOINT
                X_ACCOUNT_CONNECTION -> Known.X_ACCOUNT_CONNECTION
                else -> throw XTwitterScraperInvalidDataException("Unknown Kind: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { XTwitterScraperInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        /** Validates that this value is a known member. */
        fun validate(): Kind = apply {
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

            return other is Kind && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val COMPLETED = of("completed")

            @JvmField val RUNNING = of("running")

            @JvmField val FAILED = of("failed")

            @JvmField val CANCELED = of("canceled")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            COMPLETED,
            RUNNING,
            FAILED,
            CANCELED,
        }

        /** An enum containing [Status]'s known values, as well as an [_UNKNOWN] member. */
        enum class Value {
            COMPLETED,
            RUNNING,
            FAILED,
            CANCELED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /** Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if unknown. */
        fun value(): Value =
            when (this) {
                COMPLETED -> Value.COMPLETED
                RUNNING -> Value.RUNNING
                FAILED -> Value.FAILED
                CANCELED -> Value.CANCELED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                COMPLETED -> Known.COMPLETED
                RUNNING -> Known.RUNNING
                FAILED -> Known.FAILED
                CANCELED -> Known.CANCELED
                else -> throw XTwitterScraperInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { XTwitterScraperInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        /** Validates that this value is a known member. */
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

    class Timestamps
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val createdAt: JsonField<OffsetDateTime>,
        private val updatedAt: JsonField<OffsetDateTime>,
        private val completedAt: JsonField<OffsetDateTime>,
        private val confirmedAt: JsonField<OffsetDateTime>,
        private val expiresAt: JsonField<OffsetDateTime>,
        private val occurredAt: JsonField<OffsetDateTime>,
        private val discoveredAt: JsonField<OffsetDateTime>,
        private val postedAt: JsonField<OffsetDateTime>,
        private val firstAttemptedAt: JsonField<OffsetDateTime>,
        private val deliveredAt: JsonField<OffsetDateTime>,
        private val nextRetryAt: JsonField<OffsetDateTime>,
        private val exhaustedAt: JsonField<OffsetDateTime>,
        private val drawnAt: JsonField<OffsetDateTime>,
        private val lastUsedAt: JsonField<OffsetDateTime>,
        private val pausedAt: JsonField<OffsetDateTime>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("updatedAt") @ExcludeMissing updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("completedAt") @ExcludeMissing completedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("confirmedAt") @ExcludeMissing confirmedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("expiresAt") @ExcludeMissing expiresAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("occurredAt") @ExcludeMissing occurredAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("discoveredAt") @ExcludeMissing discoveredAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("postedAt") @ExcludeMissing postedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("firstAttemptedAt") @ExcludeMissing firstAttemptedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("deliveredAt") @ExcludeMissing deliveredAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("nextRetryAt") @ExcludeMissing nextRetryAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("exhaustedAt") @ExcludeMissing exhaustedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("drawnAt") @ExcludeMissing drawnAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("lastUsedAt") @ExcludeMissing lastUsedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("pausedAt") @ExcludeMissing pausedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(createdAt, updatedAt, completedAt, confirmedAt, expiresAt, occurredAt, discoveredAt, postedAt, firstAttemptedAt, deliveredAt, nextRetryAt, exhaustedAt, drawnAt, lastUsedAt, pausedAt, mutableMapOf())

        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

        fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

        fun completedAt(): Optional<OffsetDateTime> = completedAt.getOptional("completedAt")

        fun confirmedAt(): Optional<OffsetDateTime> = confirmedAt.getOptional("confirmedAt")

        fun expiresAt(): Optional<OffsetDateTime> = expiresAt.getOptional("expiresAt")

        fun occurredAt(): Optional<OffsetDateTime> = occurredAt.getOptional("occurredAt")

        fun discoveredAt(): Optional<OffsetDateTime> = discoveredAt.getOptional("discoveredAt")

        fun postedAt(): Optional<OffsetDateTime> = postedAt.getOptional("postedAt")

        fun firstAttemptedAt(): Optional<OffsetDateTime> = firstAttemptedAt.getOptional("firstAttemptedAt")

        fun deliveredAt(): Optional<OffsetDateTime> = deliveredAt.getOptional("deliveredAt")

        fun nextRetryAt(): Optional<OffsetDateTime> = nextRetryAt.getOptional("nextRetryAt")

        fun exhaustedAt(): Optional<OffsetDateTime> = exhaustedAt.getOptional("exhaustedAt")

        fun drawnAt(): Optional<OffsetDateTime> = drawnAt.getOptional("drawnAt")

        fun lastUsedAt(): Optional<OffsetDateTime> = lastUsedAt.getOptional("lastUsedAt")

        fun pausedAt(): Optional<OffsetDateTime> = pausedAt.getOptional("pausedAt")

        /** Returns the raw JSON value of [createdAt]. */
        @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /** Returns the raw JSON value of [updatedAt]. */
        @JsonProperty("updatedAt") @ExcludeMissing fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

        /** Returns the raw JSON value of [completedAt]. */
        @JsonProperty("completedAt") @ExcludeMissing fun _completedAt(): JsonField<OffsetDateTime> = completedAt

        /** Returns the raw JSON value of [confirmedAt]. */
        @JsonProperty("confirmedAt") @ExcludeMissing fun _confirmedAt(): JsonField<OffsetDateTime> = confirmedAt

        /** Returns the raw JSON value of [expiresAt]. */
        @JsonProperty("expiresAt") @ExcludeMissing fun _expiresAt(): JsonField<OffsetDateTime> = expiresAt

        /** Returns the raw JSON value of [occurredAt]. */
        @JsonProperty("occurredAt") @ExcludeMissing fun _occurredAt(): JsonField<OffsetDateTime> = occurredAt

        /** Returns the raw JSON value of [discoveredAt]. */
        @JsonProperty("discoveredAt") @ExcludeMissing fun _discoveredAt(): JsonField<OffsetDateTime> = discoveredAt

        /** Returns the raw JSON value of [postedAt]. */
        @JsonProperty("postedAt") @ExcludeMissing fun _postedAt(): JsonField<OffsetDateTime> = postedAt

        /** Returns the raw JSON value of [firstAttemptedAt]. */
        @JsonProperty("firstAttemptedAt") @ExcludeMissing fun _firstAttemptedAt(): JsonField<OffsetDateTime> = firstAttemptedAt

        /** Returns the raw JSON value of [deliveredAt]. */
        @JsonProperty("deliveredAt") @ExcludeMissing fun _deliveredAt(): JsonField<OffsetDateTime> = deliveredAt

        /** Returns the raw JSON value of [nextRetryAt]. */
        @JsonProperty("nextRetryAt") @ExcludeMissing fun _nextRetryAt(): JsonField<OffsetDateTime> = nextRetryAt

        /** Returns the raw JSON value of [exhaustedAt]. */
        @JsonProperty("exhaustedAt") @ExcludeMissing fun _exhaustedAt(): JsonField<OffsetDateTime> = exhaustedAt

        /** Returns the raw JSON value of [drawnAt]. */
        @JsonProperty("drawnAt") @ExcludeMissing fun _drawnAt(): JsonField<OffsetDateTime> = drawnAt

        /** Returns the raw JSON value of [lastUsedAt]. */
        @JsonProperty("lastUsedAt") @ExcludeMissing fun _lastUsedAt(): JsonField<OffsetDateTime> = lastUsedAt

        /** Returns the raw JSON value of [pausedAt]. */
        @JsonProperty("pausedAt") @ExcludeMissing fun _pausedAt(): JsonField<OffsetDateTime> = pausedAt

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

            /** Returns a mutable builder for constructing an instance of [Timestamps]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Timestamps]. */
        class Builder internal constructor() {

            private var createdAt: JsonField<OffsetDateTime>? = null
            private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var completedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var confirmedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var expiresAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var occurredAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var discoveredAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var postedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var firstAttemptedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var deliveredAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var nextRetryAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var exhaustedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var drawnAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var lastUsedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var pausedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic internal fun from(timestamps: Timestamps) = apply {
                createdAt = timestamps.createdAt
                updatedAt = timestamps.updatedAt
                completedAt = timestamps.completedAt
                confirmedAt = timestamps.confirmedAt
                expiresAt = timestamps.expiresAt
                occurredAt = timestamps.occurredAt
                discoveredAt = timestamps.discoveredAt
                postedAt = timestamps.postedAt
                firstAttemptedAt = timestamps.firstAttemptedAt
                deliveredAt = timestamps.deliveredAt
                nextRetryAt = timestamps.nextRetryAt
                exhaustedAt = timestamps.exhaustedAt
                drawnAt = timestamps.drawnAt
                lastUsedAt = timestamps.lastUsedAt
                pausedAt = timestamps.pausedAt
                additionalProperties = timestamps.additionalProperties.toMutableMap()
            }

            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /** Sets [Builder.createdAt] to an arbitrary JSON value. */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

            fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

            /** Sets [Builder.updatedAt] to an arbitrary JSON value. */
            fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

            fun completedAt(completedAt: OffsetDateTime) = completedAt(JsonField.of(completedAt))

            /** Sets [Builder.completedAt] to an arbitrary JSON value. */
            fun completedAt(completedAt: JsonField<OffsetDateTime>) = apply { this.completedAt = completedAt }

            fun confirmedAt(confirmedAt: OffsetDateTime) = confirmedAt(JsonField.of(confirmedAt))

            /** Sets [Builder.confirmedAt] to an arbitrary JSON value. */
            fun confirmedAt(confirmedAt: JsonField<OffsetDateTime>) = apply { this.confirmedAt = confirmedAt }

            fun expiresAt(expiresAt: OffsetDateTime) = expiresAt(JsonField.of(expiresAt))

            /** Sets [Builder.expiresAt] to an arbitrary JSON value. */
            fun expiresAt(expiresAt: JsonField<OffsetDateTime>) = apply { this.expiresAt = expiresAt }

            fun occurredAt(occurredAt: OffsetDateTime) = occurredAt(JsonField.of(occurredAt))

            /** Sets [Builder.occurredAt] to an arbitrary JSON value. */
            fun occurredAt(occurredAt: JsonField<OffsetDateTime>) = apply { this.occurredAt = occurredAt }

            fun discoveredAt(discoveredAt: OffsetDateTime) = discoveredAt(JsonField.of(discoveredAt))

            /** Sets [Builder.discoveredAt] to an arbitrary JSON value. */
            fun discoveredAt(discoveredAt: JsonField<OffsetDateTime>) = apply { this.discoveredAt = discoveredAt }

            fun postedAt(postedAt: OffsetDateTime) = postedAt(JsonField.of(postedAt))

            /** Sets [Builder.postedAt] to an arbitrary JSON value. */
            fun postedAt(postedAt: JsonField<OffsetDateTime>) = apply { this.postedAt = postedAt }

            fun firstAttemptedAt(firstAttemptedAt: OffsetDateTime) = firstAttemptedAt(JsonField.of(firstAttemptedAt))

            /** Sets [Builder.firstAttemptedAt] to an arbitrary JSON value. */
            fun firstAttemptedAt(firstAttemptedAt: JsonField<OffsetDateTime>) = apply { this.firstAttemptedAt = firstAttemptedAt }

            fun deliveredAt(deliveredAt: OffsetDateTime) = deliveredAt(JsonField.of(deliveredAt))

            /** Sets [Builder.deliveredAt] to an arbitrary JSON value. */
            fun deliveredAt(deliveredAt: JsonField<OffsetDateTime>) = apply { this.deliveredAt = deliveredAt }

            fun nextRetryAt(nextRetryAt: OffsetDateTime) = nextRetryAt(JsonField.of(nextRetryAt))

            /** Sets [Builder.nextRetryAt] to an arbitrary JSON value. */
            fun nextRetryAt(nextRetryAt: JsonField<OffsetDateTime>) = apply { this.nextRetryAt = nextRetryAt }

            fun exhaustedAt(exhaustedAt: OffsetDateTime) = exhaustedAt(JsonField.of(exhaustedAt))

            /** Sets [Builder.exhaustedAt] to an arbitrary JSON value. */
            fun exhaustedAt(exhaustedAt: JsonField<OffsetDateTime>) = apply { this.exhaustedAt = exhaustedAt }

            fun drawnAt(drawnAt: OffsetDateTime) = drawnAt(JsonField.of(drawnAt))

            /** Sets [Builder.drawnAt] to an arbitrary JSON value. */
            fun drawnAt(drawnAt: JsonField<OffsetDateTime>) = apply { this.drawnAt = drawnAt }

            fun lastUsedAt(lastUsedAt: OffsetDateTime) = lastUsedAt(JsonField.of(lastUsedAt))

            /** Sets [Builder.lastUsedAt] to an arbitrary JSON value. */
            fun lastUsedAt(lastUsedAt: JsonField<OffsetDateTime>) = apply { this.lastUsedAt = lastUsedAt }

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
             * Returns an immutable instance of [Timestamps].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Timestamps =
                Timestamps(
                    checkRequired("createdAt", createdAt),
                    updatedAt,
                    completedAt,
                    confirmedAt,
                    expiresAt,
                    occurredAt,
                    discoveredAt,
                    postedAt,
                    firstAttemptedAt,
                    deliveredAt,
                    nextRetryAt,
                    exhaustedAt,
                    drawnAt,
                    lastUsedAt,
                    pausedAt,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types recursively.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match its expected type.
         */
        fun validate(): Timestamps = apply {
            if (validated) {
                return@apply
            }

            createdAt()
            updatedAt()
            completedAt()
            confirmedAt()
            expiresAt()
            occurredAt()
            discoveredAt()
            postedAt()
            firstAttemptedAt()
            deliveredAt()
            nextRetryAt()
            exhaustedAt()
            drawnAt()
            lastUsedAt()
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

        @JvmSynthetic internal fun validity(): Int =
            (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0) +
                (if (completedAt.asKnown().isPresent) 1 else 0) +
                (if (confirmedAt.asKnown().isPresent) 1 else 0) +
                (if (expiresAt.asKnown().isPresent) 1 else 0) +
                (if (occurredAt.asKnown().isPresent) 1 else 0) +
                (if (discoveredAt.asKnown().isPresent) 1 else 0) +
                (if (postedAt.asKnown().isPresent) 1 else 0) +
                (if (firstAttemptedAt.asKnown().isPresent) 1 else 0) +
                (if (deliveredAt.asKnown().isPresent) 1 else 0) +
                (if (nextRetryAt.asKnown().isPresent) 1 else 0) +
                (if (exhaustedAt.asKnown().isPresent) 1 else 0) +
                (if (drawnAt.asKnown().isPresent) 1 else 0) +
                (if (lastUsedAt.asKnown().isPresent) 1 else 0) +
                (if (pausedAt.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Timestamps &&
                createdAt == other.createdAt &&
                updatedAt == other.updatedAt &&
                completedAt == other.completedAt &&
                confirmedAt == other.confirmedAt &&
                expiresAt == other.expiresAt &&
                occurredAt == other.occurredAt &&
                discoveredAt == other.discoveredAt &&
                postedAt == other.postedAt &&
                firstAttemptedAt == other.firstAttemptedAt &&
                deliveredAt == other.deliveredAt &&
                nextRetryAt == other.nextRetryAt &&
                exhaustedAt == other.exhaustedAt &&
                drawnAt == other.drawnAt &&
                lastUsedAt == other.lastUsedAt &&
                pausedAt == other.pausedAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(createdAt, updatedAt, completedAt, confirmedAt, expiresAt, occurredAt, discoveredAt, postedAt, firstAttemptedAt, deliveredAt, nextRetryAt, exhaustedAt, drawnAt, lastUsedAt, pausedAt, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Timestamps{createdAt=$createdAt, updatedAt=$updatedAt, completedAt=$completedAt, confirmedAt=$confirmedAt, expiresAt=$expiresAt, occurredAt=$occurredAt, discoveredAt=$discoveredAt, postedAt=$postedAt, firstAttemptedAt=$firstAttemptedAt, deliveredAt=$deliveredAt, nextRetryAt=$nextRetryAt, exhaustedAt=$exhaustedAt, drawnAt=$drawnAt, lastUsedAt=$lastUsedAt, pausedAt=$pausedAt, additionalProperties=$additionalProperties}"
    }

    /** The API request behind this activity. Null for activity from before Oct 30, 2026, and for activity no API request starts, such as a monitor event, a webhook delivery or a credit grant. */
    class Request
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val method: JsonField<Method>,
        private val path: JsonField<String>,
        private val httpStatus: JsonField<Long>,
        private val durationMs: JsonField<Long>,
        private val ipAddress: JsonField<String>,
        private val userAgent: JsonField<String>,
        private val at: JsonField<OffsetDateTime>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("method") @ExcludeMissing method: JsonField<Method> = JsonMissing.of(),
            @JsonProperty("path") @ExcludeMissing path: JsonField<String> = JsonMissing.of(),
            @JsonProperty("httpStatus") @ExcludeMissing httpStatus: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("durationMs") @ExcludeMissing durationMs: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("ipAddress") @ExcludeMissing ipAddress: JsonField<String> = JsonMissing.of(),
            @JsonProperty("userAgent") @ExcludeMissing userAgent: JsonField<String> = JsonMissing.of(),
            @JsonProperty("at") @ExcludeMissing at: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(method, path, httpStatus, durationMs, ipAddress, userAgent, at, mutableMapOf())

        fun method(): Method = method.getRequired("method")

        fun path(): String = path.getRequired("path")

        fun httpStatus(): Long = httpStatus.getRequired("httpStatus")

        fun durationMs(): Long = durationMs.getRequired("durationMs")

        fun ipAddress(): Optional<String> = ipAddress.getOptional("ipAddress")

        fun userAgent(): Optional<String> = userAgent.getOptional("userAgent")

        fun at(): OffsetDateTime = at.getRequired("at")

        /** Returns the raw JSON value of [method]. */
        @JsonProperty("method") @ExcludeMissing fun _method(): JsonField<Method> = method

        /** Returns the raw JSON value of [path]. */
        @JsonProperty("path") @ExcludeMissing fun _path(): JsonField<String> = path

        /** Returns the raw JSON value of [httpStatus]. */
        @JsonProperty("httpStatus") @ExcludeMissing fun _httpStatus(): JsonField<Long> = httpStatus

        /** Returns the raw JSON value of [durationMs]. */
        @JsonProperty("durationMs") @ExcludeMissing fun _durationMs(): JsonField<Long> = durationMs

        /** Returns the raw JSON value of [ipAddress]. */
        @JsonProperty("ipAddress") @ExcludeMissing fun _ipAddress(): JsonField<String> = ipAddress

        /** Returns the raw JSON value of [userAgent]. */
        @JsonProperty("userAgent") @ExcludeMissing fun _userAgent(): JsonField<String> = userAgent

        /** Returns the raw JSON value of [at]. */
        @JsonProperty("at") @ExcludeMissing fun _at(): JsonField<OffsetDateTime> = at

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

            /** Returns a mutable builder for constructing an instance of [Request]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Request]. */
        class Builder internal constructor() {

            private var method: JsonField<Method>? = null
            private var path: JsonField<String>? = null
            private var httpStatus: JsonField<Long>? = null
            private var durationMs: JsonField<Long>? = null
            private var ipAddress: JsonField<String>? = null
            private var userAgent: JsonField<String>? = null
            private var at: JsonField<OffsetDateTime>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic internal fun from(request: Request) = apply {
                method = request.method
                path = request.path
                httpStatus = request.httpStatus
                durationMs = request.durationMs
                ipAddress = request.ipAddress
                userAgent = request.userAgent
                at = request.at
                additionalProperties = request.additionalProperties.toMutableMap()
            }

            fun method(method: Method) = method(JsonField.of(method))

            /** Sets [Builder.method] to an arbitrary JSON value. */
            fun method(method: JsonField<Method>) = apply { this.method = method }

            fun path(path: String) = path(JsonField.of(path))

            /** Sets [Builder.path] to an arbitrary JSON value. */
            fun path(path: JsonField<String>) = apply { this.path = path }

            fun httpStatus(httpStatus: Long) = httpStatus(JsonField.of(httpStatus))

            /** Sets [Builder.httpStatus] to an arbitrary JSON value. */
            fun httpStatus(httpStatus: JsonField<Long>) = apply { this.httpStatus = httpStatus }

            fun durationMs(durationMs: Long) = durationMs(JsonField.of(durationMs))

            /** Sets [Builder.durationMs] to an arbitrary JSON value. */
            fun durationMs(durationMs: JsonField<Long>) = apply { this.durationMs = durationMs }

            fun ipAddress(ipAddress: String?) = ipAddress(JsonField.ofNullable(ipAddress))

            /** Alias for calling [Builder.ipAddress] with `ipAddress.orElse(null)`. */
            fun ipAddress(ipAddress: Optional<String>) = ipAddress(ipAddress.getOrNull())

            /** Sets [Builder.ipAddress] to an arbitrary JSON value. */
            fun ipAddress(ipAddress: JsonField<String>) = apply { this.ipAddress = ipAddress }

            fun userAgent(userAgent: String?) = userAgent(JsonField.ofNullable(userAgent))

            /** Alias for calling [Builder.userAgent] with `userAgent.orElse(null)`. */
            fun userAgent(userAgent: Optional<String>) = userAgent(userAgent.getOrNull())

            /** Sets [Builder.userAgent] to an arbitrary JSON value. */
            fun userAgent(userAgent: JsonField<String>) = apply { this.userAgent = userAgent }

            fun at(at: OffsetDateTime) = at(JsonField.of(at))

            /** Sets [Builder.at] to an arbitrary JSON value. */
            fun at(at: JsonField<OffsetDateTime>) = apply { this.at = at }

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
             * Returns an immutable instance of [Request].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Request =
                Request(
                    checkRequired("method", method),
                    checkRequired("path", path),
                    checkRequired("httpStatus", httpStatus),
                    checkRequired("durationMs", durationMs),
                    checkRequired("ipAddress", ipAddress),
                    checkRequired("userAgent", userAgent),
                    checkRequired("at", at),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types recursively.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match its expected type.
         */
        fun validate(): Request = apply {
            if (validated) {
                return@apply
            }

            method().validate()
            path()
            httpStatus()
            durationMs()
            ipAddress()
            userAgent()
            at()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        @JvmSynthetic internal fun validity(): Int =
            (method.asKnown().getOrNull()?.validity() ?: 0) +
                (if (path.asKnown().isPresent) 1 else 0) +
                (if (httpStatus.asKnown().isPresent) 1 else 0) +
                (if (durationMs.asKnown().isPresent) 1 else 0) +
                (if (ipAddress.asKnown().isPresent) 1 else 0) +
                (if (userAgent.asKnown().isPresent) 1 else 0) +
                (if (at.asKnown().isPresent) 1 else 0)

        class Method @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val DELETE = of("DELETE")

                @JvmField val PATCH = of("PATCH")

                @JvmField val POST = of("POST")

                @JvmField val PUT = of("PUT")

                @JvmStatic fun of(value: String) = Method(JsonField.of(value))
            }

            /** An enum containing [Method]'s known values. */
            enum class Known {
                DELETE,
                PATCH,
                POST,
                PUT,
            }

            /** An enum containing [Method]'s known values, as well as an [_UNKNOWN] member. */
            enum class Value {
                DELETE,
                PATCH,
                POST,
                PUT,
                /** An enum member indicating that [Method] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /** Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if unknown. */
            fun value(): Value =
                when (this) {
                    DELETE -> Value.DELETE
                    PATCH -> Value.PATCH
                    POST -> Value.POST
                    PUT -> Value.PUT
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a known member.
             */
            fun known(): Known =
                when (this) {
                    DELETE -> Known.DELETE
                    PATCH -> Known.PATCH
                    POST -> Known.POST
                    PUT -> Known.PUT
                    else -> throw XTwitterScraperInvalidDataException("Unknown Method: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value does not have the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow { XTwitterScraperInvalidDataException("Value is not a String") }

            private var validated: Boolean = false

            /** Validates that this value is a known member. */
            fun validate(): Method = apply {
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

                return other is Method && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Request &&
                method == other.method &&
                path == other.path &&
                httpStatus == other.httpStatus &&
                durationMs == other.durationMs &&
                ipAddress == other.ipAddress &&
                userAgent == other.userAgent &&
                at == other.at &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(method, path, httpStatus, durationMs, ipAddress, userAgent, at, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Request{method=$method, path=$path, httpStatus=$httpStatus, durationMs=$durationMs, ipAddress=$ipAddress, userAgent=$userAgent, at=$at, additionalProperties=$additionalProperties}"
    }

    class Caller
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val authMethod: JsonField<AuthMethod>,
        private val apiKey: JsonField<ApiKey>,
        private val oauthClient: JsonField<OauthClient>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("authMethod") @ExcludeMissing authMethod: JsonField<AuthMethod> = JsonMissing.of(),
            @JsonProperty("apiKey") @ExcludeMissing apiKey: JsonField<ApiKey> = JsonMissing.of(),
            @JsonProperty("oauthClient") @ExcludeMissing oauthClient: JsonField<OauthClient> = JsonMissing.of(),
        ) : this(authMethod, apiKey, oauthClient, mutableMapOf())

        fun authMethod(): Optional<AuthMethod> = authMethod.getOptional("authMethod")

        /** Name and prefix of the API key used. Never its value. */
        fun apiKey(): Optional<ApiKey> = apiKey.getOptional("apiKey")

        fun oauthClient(): Optional<OauthClient> = oauthClient.getOptional("oauthClient")

        /** Returns the raw JSON value of [authMethod]. */
        @JsonProperty("authMethod") @ExcludeMissing fun _authMethod(): JsonField<AuthMethod> = authMethod

        /** Returns the raw JSON value of [apiKey]. */
        @JsonProperty("apiKey") @ExcludeMissing fun _apiKey(): JsonField<ApiKey> = apiKey

        /** Returns the raw JSON value of [oauthClient]. */
        @JsonProperty("oauthClient") @ExcludeMissing fun _oauthClient(): JsonField<OauthClient> = oauthClient

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

            /** Returns a mutable builder for constructing an instance of [Caller]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Caller]. */
        class Builder internal constructor() {

            private var authMethod: JsonField<AuthMethod>? = null
            private var apiKey: JsonField<ApiKey>? = null
            private var oauthClient: JsonField<OauthClient>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic internal fun from(caller: Caller) = apply {
                authMethod = caller.authMethod
                apiKey = caller.apiKey
                oauthClient = caller.oauthClient
                additionalProperties = caller.additionalProperties.toMutableMap()
            }

            fun authMethod(authMethod: AuthMethod?) = authMethod(JsonField.ofNullable(authMethod))

            /** Alias for calling [Builder.authMethod] with `authMethod.orElse(null)`. */
            fun authMethod(authMethod: Optional<AuthMethod>) = authMethod(authMethod.getOrNull())

            /** Sets [Builder.authMethod] to an arbitrary JSON value. */
            fun authMethod(authMethod: JsonField<AuthMethod>) = apply { this.authMethod = authMethod }

            /** Name and prefix of the API key used. Never its value. */
            fun apiKey(apiKey: ApiKey?) = apiKey(JsonField.ofNullable(apiKey))

            /** Alias for calling [Builder.apiKey] with `apiKey.orElse(null)`. */
            fun apiKey(apiKey: Optional<ApiKey>) = apiKey(apiKey.getOrNull())

            /** Sets [Builder.apiKey] to an arbitrary JSON value. */
            fun apiKey(apiKey: JsonField<ApiKey>) = apply { this.apiKey = apiKey }

            fun oauthClient(oauthClient: OauthClient?) = oauthClient(JsonField.ofNullable(oauthClient))

            /** Alias for calling [Builder.oauthClient] with `oauthClient.orElse(null)`. */
            fun oauthClient(oauthClient: Optional<OauthClient>) = oauthClient(oauthClient.getOrNull())

            /** Sets [Builder.oauthClient] to an arbitrary JSON value. */
            fun oauthClient(oauthClient: JsonField<OauthClient>) = apply { this.oauthClient = oauthClient }

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
             * Returns an immutable instance of [Caller].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Caller =
                Caller(
                    checkRequired("authMethod", authMethod),
                    checkRequired("apiKey", apiKey),
                    checkRequired("oauthClient", oauthClient),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types recursively.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match its expected type.
         */
        fun validate(): Caller = apply {
            if (validated) {
                return@apply
            }

            authMethod().ifPresent { it.validate() }
            apiKey().ifPresent { it.validate() }
            oauthClient().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        @JvmSynthetic internal fun validity(): Int =
            (authMethod.asKnown().getOrNull()?.validity() ?: 0) +
                (apiKey.asKnown().getOrNull()?.validity() ?: 0) +
                (oauthClient.asKnown().getOrNull()?.validity() ?: 0)

        class AuthMethod @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val API_KEY = of("api_key")

                @JvmField val OAUTH = of("oauth")

                @JvmField val SESSION = of("session")

                @JvmStatic fun of(value: String) = AuthMethod(JsonField.of(value))
            }

            /** An enum containing [AuthMethod]'s known values. */
            enum class Known {
                API_KEY,
                OAUTH,
                SESSION,
            }

            /** An enum containing [AuthMethod]'s known values, as well as an [_UNKNOWN] member. */
            enum class Value {
                API_KEY,
                OAUTH,
                SESSION,
                /** An enum member indicating that [AuthMethod] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /** Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if unknown. */
            fun value(): Value =
                when (this) {
                    API_KEY -> Value.API_KEY
                    OAUTH -> Value.OAUTH
                    SESSION -> Value.SESSION
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a known member.
             */
            fun known(): Known =
                when (this) {
                    API_KEY -> Known.API_KEY
                    OAUTH -> Known.OAUTH
                    SESSION -> Known.SESSION
                    else -> throw XTwitterScraperInvalidDataException("Unknown AuthMethod: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value does not have the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow { XTwitterScraperInvalidDataException("Value is not a String") }

            private var validated: Boolean = false

            /** Validates that this value is a known member. */
            fun validate(): AuthMethod = apply {
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

                return other is AuthMethod && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** Name and prefix of the API key used. Never its value. */
        class ApiKey
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val name: JsonField<String>,
            private val prefix: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("prefix") @ExcludeMissing prefix: JsonField<String> = JsonMissing.of(),
            ) : this(name, prefix, mutableMapOf())

            fun name(): String = name.getRequired("name")

            fun prefix(): String = prefix.getRequired("prefix")

            /** Returns the raw JSON value of [name]. */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /** Returns the raw JSON value of [prefix]. */
            @JsonProperty("prefix") @ExcludeMissing fun _prefix(): JsonField<String> = prefix

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

                /** Returns a mutable builder for constructing an instance of [ApiKey]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ApiKey]. */
            class Builder internal constructor() {

                private var name: JsonField<String>? = null
                private var prefix: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic internal fun from(apiKey: ApiKey) = apply {
                    name = apiKey.name
                    prefix = apiKey.prefix
                    additionalProperties = apiKey.additionalProperties.toMutableMap()
                }

                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
                fun name(name: JsonField<String>) = apply { this.name = name }

                fun prefix(prefix: String) = prefix(JsonField.of(prefix))

                /** Sets [Builder.prefix] to an arbitrary JSON value. */
                fun prefix(prefix: JsonField<String>) = apply { this.prefix = prefix }

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
                 * Returns an immutable instance of [ApiKey].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ApiKey =
                    ApiKey(
                        checkRequired("name", name),
                        checkRequired("prefix", prefix),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types recursively.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match its expected type.
             */
            fun validate(): ApiKey = apply {
                if (validated) {
                    return@apply
                }

                name()
                prefix()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            @JvmSynthetic internal fun validity(): Int =
                (if (name.asKnown().isPresent) 1 else 0) +
                    (if (prefix.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ApiKey &&
                    name == other.name &&
                    prefix == other.prefix &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(name, prefix, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ApiKey{name=$name, prefix=$prefix, additionalProperties=$additionalProperties}"
        }

        class OauthClient
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(id, name, mutableMapOf())

            fun id(): String = id.getRequired("id")

            fun name(): String = name.getRequired("name")

            /** Returns the raw JSON value of [id]. */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /** Returns the raw JSON value of [name]. */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

                /** Returns a mutable builder for constructing an instance of [OauthClient]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [OauthClient]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var name: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic internal fun from(oauthClient: OauthClient) = apply {
                    id = oauthClient.id
                    name = oauthClient.name
                    additionalProperties = oauthClient.additionalProperties.toMutableMap()
                }

                fun id(id: String) = id(JsonField.of(id))

                /** Sets [Builder.id] to an arbitrary JSON value. */
                fun id(id: JsonField<String>) = apply { this.id = id }

                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
                fun name(name: JsonField<String>) = apply { this.name = name }

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
                 * Returns an immutable instance of [OauthClient].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): OauthClient =
                    OauthClient(
                        checkRequired("id", id),
                        checkRequired("name", name),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types recursively.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match its expected type.
             */
            fun validate(): OauthClient = apply {
                if (validated) {
                    return@apply
                }

                id()
                name()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: XTwitterScraperInvalidDataException) {
                    false
                }

            @JvmSynthetic internal fun validity(): Int =
                (if (id.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is OauthClient &&
                    id == other.id &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(id, name, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "OauthClient{id=$id, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Caller &&
                authMethod == other.authMethod &&
                apiKey == other.apiKey &&
                oauthClient == other.oauthClient &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(authMethod, apiKey, oauthClient, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Caller{authMethod=$authMethod, apiKey=$apiKey, oauthClient=$oauthClient, additionalProperties=$additionalProperties}"
    }

    /** Credits charged for this activity. */
    class Charge
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val credits: JsonField<Long>,
        private val balanceAfter: JsonField<Long>,
        private val at: JsonField<OffsetDateTime>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("credits") @ExcludeMissing credits: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("balanceAfter") @ExcludeMissing balanceAfter: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("at") @ExcludeMissing at: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(credits, balanceAfter, at, mutableMapOf())

        fun credits(): Long = credits.getRequired("credits")

        fun balanceAfter(): Long = balanceAfter.getRequired("balanceAfter")

        fun at(): OffsetDateTime = at.getRequired("at")

        /** Returns the raw JSON value of [credits]. */
        @JsonProperty("credits") @ExcludeMissing fun _credits(): JsonField<Long> = credits

        /** Returns the raw JSON value of [balanceAfter]. */
        @JsonProperty("balanceAfter") @ExcludeMissing fun _balanceAfter(): JsonField<Long> = balanceAfter

        /** Returns the raw JSON value of [at]. */
        @JsonProperty("at") @ExcludeMissing fun _at(): JsonField<OffsetDateTime> = at

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

            /** Returns a mutable builder for constructing an instance of [Charge]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Charge]. */
        class Builder internal constructor() {

            private var credits: JsonField<Long>? = null
            private var balanceAfter: JsonField<Long>? = null
            private var at: JsonField<OffsetDateTime>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic internal fun from(charge: Charge) = apply {
                credits = charge.credits
                balanceAfter = charge.balanceAfter
                at = charge.at
                additionalProperties = charge.additionalProperties.toMutableMap()
            }

            fun credits(credits: Long) = credits(JsonField.of(credits))

            /** Sets [Builder.credits] to an arbitrary JSON value. */
            fun credits(credits: JsonField<Long>) = apply { this.credits = credits }

            fun balanceAfter(balanceAfter: Long) = balanceAfter(JsonField.of(balanceAfter))

            /** Sets [Builder.balanceAfter] to an arbitrary JSON value. */
            fun balanceAfter(balanceAfter: JsonField<Long>) = apply { this.balanceAfter = balanceAfter }

            fun at(at: OffsetDateTime) = at(JsonField.of(at))

            /** Sets [Builder.at] to an arbitrary JSON value. */
            fun at(at: JsonField<OffsetDateTime>) = apply { this.at = at }

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
             * Returns an immutable instance of [Charge].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Charge =
                Charge(
                    checkRequired("credits", credits),
                    checkRequired("balanceAfter", balanceAfter),
                    checkRequired("at", at),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types recursively.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match its expected type.
         */
        fun validate(): Charge = apply {
            if (validated) {
                return@apply
            }

            credits()
            balanceAfter()
            at()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: XTwitterScraperInvalidDataException) {
                false
            }

        @JvmSynthetic internal fun validity(): Int =
            (if (credits.asKnown().isPresent) 1 else 0) +
                (if (balanceAfter.asKnown().isPresent) 1 else 0) +
                (if (at.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Charge &&
                credits == other.credits &&
                balanceAfter == other.balanceAfter &&
                at == other.at &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(credits, balanceAfter, at, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Charge{credits=$credits, balanceAfter=$balanceAfter, at=$at, additionalProperties=$additionalProperties}"
    }

    /** Fields of this kind of activity, such as its target. A field can hold JSON, such as the data of a monitor event or the payload of a webhook delivery. */
    class Details
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
        ) : this(mutableMapOf())

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

            /** Returns a mutable builder for constructing an instance of [Details]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Details]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic internal fun from(details: Details) = apply {
                additionalProperties = details.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Details].
             *
             */
            fun build(): Details =
                Details(
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types recursively.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match its expected type.
         */
        fun validate(): Details = apply {
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

        @JvmSynthetic internal fun validity(): Int =
            0

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Details &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Details{additionalProperties=$additionalProperties}"
    }

    class Related
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val type: JsonField<String>,
        private val status: JsonField<Status>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val url: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("createdAt") @ExcludeMissing createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        ) : this(id, type, status, createdAt, url, mutableMapOf())

        fun id(): String = id.getRequired("id")

        fun type(): String = type.getRequired("type")

        fun status(): Status = status.getRequired("status")

        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

        fun url(): String = url.getRequired("url")

        /** Returns the raw JSON value of [id]. */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /** Returns the raw JSON value of [type]. */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

        /** Returns the raw JSON value of [status]. */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /** Returns the raw JSON value of [createdAt]. */
        @JsonProperty("createdAt") @ExcludeMissing fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /** Returns the raw JSON value of [url]. */
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

            /** Returns a mutable builder for constructing an instance of [Related]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Related]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var type: JsonField<String>? = null
            private var status: JsonField<Status>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var url: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic internal fun from(related: Related) = apply {
                id = related.id
                type = related.type
                status = related.status
                createdAt = related.createdAt
                url = related.url
                additionalProperties = related.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun type(type: String) = type(JsonField.of(type))

            /** Sets [Builder.type] to an arbitrary JSON value. */
            fun type(type: JsonField<String>) = apply { this.type = type }

            fun status(status: Status) = status(JsonField.of(status))

            /** Sets [Builder.status] to an arbitrary JSON value. */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /** Sets [Builder.createdAt] to an arbitrary JSON value. */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

            fun url(url: String) = url(JsonField.of(url))

            /** Sets [Builder.url] to an arbitrary JSON value. */
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
             * Returns an immutable instance of [Related].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Related =
                Related(
                    checkRequired("id", id),
                    checkRequired("type", type),
                    checkRequired("status", status),
                    checkRequired("createdAt", createdAt),
                    checkRequired("url", url),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types recursively.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match its expected type.
         */
        fun validate(): Related = apply {
            if (validated) {
                return@apply
            }

            id()
            type()
            status().validate()
            createdAt()
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

        @JvmSynthetic internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (type.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0)

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val COMPLETED = of("completed")

                @JvmField val RUNNING = of("running")

                @JvmField val FAILED = of("failed")

                @JvmField val CANCELED = of("canceled")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                COMPLETED,
                RUNNING,
                FAILED,
                CANCELED,
            }

            /** An enum containing [Status]'s known values, as well as an [_UNKNOWN] member. */
            enum class Value {
                COMPLETED,
                RUNNING,
                FAILED,
                CANCELED,
                /** An enum member indicating that [Status] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /** Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if unknown. */
            fun value(): Value =
                when (this) {
                    COMPLETED -> Value.COMPLETED
                    RUNNING -> Value.RUNNING
                    FAILED -> Value.FAILED
                    CANCELED -> Value.CANCELED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a known member.
             */
            fun known(): Known =
                when (this) {
                    COMPLETED -> Known.COMPLETED
                    RUNNING -> Known.RUNNING
                    FAILED -> Known.FAILED
                    CANCELED -> Known.CANCELED
                    else -> throw XTwitterScraperInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value does not have the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow { XTwitterScraperInvalidDataException("Value is not a String") }

            private var validated: Boolean = false

            /** Validates that this value is a known member. */
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

            return other is Related &&
                id == other.id &&
                type == other.type &&
                status == other.status &&
                createdAt == other.createdAt &&
                url == other.url &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(id, type, status, createdAt, url, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Related{id=$id, type=$type, status=$status, createdAt=$createdAt, url=$url, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ActivityRecord &&
            object_ == other.object_ &&
            id == other.id &&
            kind == other.kind &&
            type == other.type &&
            status == other.status &&
            url == other.url &&
            requestId == other.requestId &&
            timestamps == other.timestamps &&
            request == other.request &&
            caller == other.caller &&
            charge == other.charge &&
            details == other.details &&
            related == other.related &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(object_, id, kind, type, status, url, requestId, timestamps, request, caller, charge, details, related, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ActivityRecord{object_=$object_, id=$id, kind=$kind, type=$type, status=$status, url=$url, requestId=$requestId, timestamps=$timestamps, request=$request, caller=$caller, charge=$charge, details=$details, related=$related, additionalProperties=$additionalProperties}"
}
