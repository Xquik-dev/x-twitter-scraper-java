// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.accountconnectionlinks

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A link to a page Xquik hosts, where a person connects an X account with no Xquik signup. */
class AccountConnectionLink
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val accountId: JsonField<String>,
    private val completedAt: JsonField<OffsetDateTime>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val expiresAt: JsonField<OffsetDateTime>,
    private val failure: JsonField<String>,
    private val health: JsonField<String>,
    private val object_: JsonValue,
    private val purpose: JsonField<Purpose>,
    private val reference: JsonField<String>,
    private val returnUrl: JsonField<String>,
    private val status: JsonField<Status>,
    private val xUserId: JsonField<String>,
    private val xUsername: JsonField<String>,
    private val url: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("accountId") @ExcludeMissing accountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("completedAt")
        @ExcludeMissing
        completedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("expiresAt")
        @ExcludeMissing
        expiresAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("failure") @ExcludeMissing failure: JsonField<String> = JsonMissing.of(),
        @JsonProperty("health") @ExcludeMissing health: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("purpose") @ExcludeMissing purpose: JsonField<Purpose> = JsonMissing.of(),
        @JsonProperty("reference") @ExcludeMissing reference: JsonField<String> = JsonMissing.of(),
        @JsonProperty("returnUrl") @ExcludeMissing returnUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("xUserId") @ExcludeMissing xUserId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("xUsername") @ExcludeMissing xUsername: JsonField<String> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        accountId,
        completedAt,
        createdAt,
        expiresAt,
        failure,
        health,
        object_,
        purpose,
        reference,
        returnUrl,
        status,
        xUserId,
        xUsername,
        url,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun id(): String = id.getRequired("id")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun accountId(): Optional<String> = accountId.getOptional("accountId")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun completedAt(): Optional<OffsetDateTime> = completedAt.getOptional("completedAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun expiresAt(): OffsetDateTime = expiresAt.getRequired("expiresAt")

    /**
     * Why the last login didn't finish.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun failure(): Optional<String> = failure.getOptional("failure")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun health(): Optional<String> = health.getOptional("health")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("x_account_connection_link")
     * ```
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun purpose(): Purpose = purpose.getRequired("purpose")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun reference(): Optional<String> = reference.getOptional("reference")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun returnUrl(): Optional<String> = returnUrl.getOptional("returnUrl")

    /**
     * failed means 5 logins were refused, so make a new link.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun status(): Status = status.getRequired("status")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun xUserId(): Optional<String> = xUserId.getOptional("xUserId")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun xUsername(): Optional<String> = xUsername.getOptional("xUsername")

    /**
     * Present only in the response that creates the link.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun url(): Optional<String> = url.getOptional("url")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [accountId].
     *
     * Unlike [accountId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("accountId") @ExcludeMissing fun _accountId(): JsonField<String> = accountId

    /**
     * Returns the raw JSON value of [completedAt].
     *
     * Unlike [completedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("completedAt")
    @ExcludeMissing
    fun _completedAt(): JsonField<OffsetDateTime> = completedAt

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [expiresAt].
     *
     * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expiresAt")
    @ExcludeMissing
    fun _expiresAt(): JsonField<OffsetDateTime> = expiresAt

    /**
     * Returns the raw JSON value of [failure].
     *
     * Unlike [failure], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("failure") @ExcludeMissing fun _failure(): JsonField<String> = failure

    /**
     * Returns the raw JSON value of [health].
     *
     * Unlike [health], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("health") @ExcludeMissing fun _health(): JsonField<String> = health

    /**
     * Returns the raw JSON value of [purpose].
     *
     * Unlike [purpose], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("purpose") @ExcludeMissing fun _purpose(): JsonField<Purpose> = purpose

    /**
     * Returns the raw JSON value of [reference].
     *
     * Unlike [reference], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reference") @ExcludeMissing fun _reference(): JsonField<String> = reference

    /**
     * Returns the raw JSON value of [returnUrl].
     *
     * Unlike [returnUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("returnUrl") @ExcludeMissing fun _returnUrl(): JsonField<String> = returnUrl

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [xUserId].
     *
     * Unlike [xUserId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("xUserId") @ExcludeMissing fun _xUserId(): JsonField<String> = xUserId

    /**
     * Returns the raw JSON value of [xUsername].
     *
     * Unlike [xUsername], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("xUsername") @ExcludeMissing fun _xUsername(): JsonField<String> = xUsername

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
         * Returns a mutable builder for constructing an instance of [AccountConnectionLink].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .accountId()
         * .completedAt()
         * .createdAt()
         * .expiresAt()
         * .failure()
         * .health()
         * .purpose()
         * .reference()
         * .returnUrl()
         * .status()
         * .xUserId()
         * .xUsername()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AccountConnectionLink]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var accountId: JsonField<String>? = null
        private var completedAt: JsonField<OffsetDateTime>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var expiresAt: JsonField<OffsetDateTime>? = null
        private var failure: JsonField<String>? = null
        private var health: JsonField<String>? = null
        private var object_: JsonValue = JsonValue.from("x_account_connection_link")
        private var purpose: JsonField<Purpose>? = null
        private var reference: JsonField<String>? = null
        private var returnUrl: JsonField<String>? = null
        private var status: JsonField<Status>? = null
        private var xUserId: JsonField<String>? = null
        private var xUsername: JsonField<String>? = null
        private var url: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountConnectionLink: AccountConnectionLink) = apply {
            id = accountConnectionLink.id
            accountId = accountConnectionLink.accountId
            completedAt = accountConnectionLink.completedAt
            createdAt = accountConnectionLink.createdAt
            expiresAt = accountConnectionLink.expiresAt
            failure = accountConnectionLink.failure
            health = accountConnectionLink.health
            object_ = accountConnectionLink.object_
            purpose = accountConnectionLink.purpose
            reference = accountConnectionLink.reference
            returnUrl = accountConnectionLink.returnUrl
            status = accountConnectionLink.status
            xUserId = accountConnectionLink.xUserId
            xUsername = accountConnectionLink.xUsername
            url = accountConnectionLink.url
            additionalProperties = accountConnectionLink.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun accountId(accountId: String?) = accountId(JsonField.ofNullable(accountId))

        /** Alias for calling [Builder.accountId] with `accountId.orElse(null)`. */
        fun accountId(accountId: Optional<String>) = accountId(accountId.getOrNull())

        /** Sets [Builder.accountId] to an arbitrary JSON value. */
        fun accountId(accountId: JsonField<String>) = apply { this.accountId = accountId }

        fun completedAt(completedAt: OffsetDateTime?) =
            completedAt(JsonField.ofNullable(completedAt))

        /** Sets [Builder.completedAt] to an arbitrary JSON value. */
        fun completedAt(completedAt: JsonField<OffsetDateTime>) = apply {
            this.completedAt = completedAt
        }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /** Sets [Builder.createdAt] to an arbitrary JSON value. */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        fun expiresAt(expiresAt: OffsetDateTime) = expiresAt(JsonField.of(expiresAt))

        /** Sets [Builder.expiresAt] to an arbitrary JSON value. */
        fun expiresAt(expiresAt: JsonField<OffsetDateTime>) = apply { this.expiresAt = expiresAt }

        /** Why the last login didn't finish. */
        fun failure(failure: String?) = failure(JsonField.ofNullable(failure))

        /** Alias for calling [Builder.failure] with `failure.orElse(null)`. */
        fun failure(failure: Optional<String>) = failure(failure.getOrNull())

        /** Sets [Builder.failure] to an arbitrary JSON value. */
        fun failure(failure: JsonField<String>) = apply { this.failure = failure }

        fun health(health: String?) = health(JsonField.ofNullable(health))

        /** Alias for calling [Builder.health] with `health.orElse(null)`. */
        fun health(health: Optional<String>) = health(health.getOrNull())

        /** Sets [Builder.health] to an arbitrary JSON value. */
        fun health(health: JsonField<String>) = apply { this.health = health }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * Defaults to the following:
         * ```java
         * JsonValue.from("x_account_connection_link")
         * ```
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        fun purpose(purpose: Purpose) = purpose(JsonField.of(purpose))

        /** Sets [Builder.purpose] to an arbitrary JSON value. */
        fun purpose(purpose: JsonField<Purpose>) = apply { this.purpose = purpose }

        fun reference(reference: String?) = reference(JsonField.ofNullable(reference))

        /** Alias for calling [Builder.reference] with `reference.orElse(null)`. */
        fun reference(reference: Optional<String>) = reference(reference.getOrNull())

        /** Sets [Builder.reference] to an arbitrary JSON value. */
        fun reference(reference: JsonField<String>) = apply { this.reference = reference }

        fun returnUrl(returnUrl: String?) = returnUrl(JsonField.ofNullable(returnUrl))

        /** Alias for calling [Builder.returnUrl] with `returnUrl.orElse(null)`. */
        fun returnUrl(returnUrl: Optional<String>) = returnUrl(returnUrl.getOrNull())

        /** Sets [Builder.returnUrl] to an arbitrary JSON value. */
        fun returnUrl(returnUrl: JsonField<String>) = apply { this.returnUrl = returnUrl }

        /** failed means 5 logins were refused, so make a new link. */
        fun status(status: Status) = status(JsonField.of(status))

        /** Sets [Builder.status] to an arbitrary JSON value. */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        fun xUserId(xUserId: String?) = xUserId(JsonField.ofNullable(xUserId))

        /** Alias for calling [Builder.xUserId] with `xUserId.orElse(null)`. */
        fun xUserId(xUserId: Optional<String>) = xUserId(xUserId.getOrNull())

        /** Sets [Builder.xUserId] to an arbitrary JSON value. */
        fun xUserId(xUserId: JsonField<String>) = apply { this.xUserId = xUserId }

        fun xUsername(xUsername: String?) = xUsername(JsonField.ofNullable(xUsername))

        /** Alias for calling [Builder.xUsername] with `xUsername.orElse(null)`. */
        fun xUsername(xUsername: Optional<String>) = xUsername(xUsername.getOrNull())

        /** Sets [Builder.xUsername] to an arbitrary JSON value. */
        fun xUsername(xUsername: JsonField<String>) = apply { this.xUsername = xUsername }

        /** Present only in the response that creates the link. */
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
         * Returns an immutable instance of [AccountConnectionLink].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .accountId()
         * .completedAt()
         * .createdAt()
         * .expiresAt()
         * .failure()
         * .health()
         * .purpose()
         * .reference()
         * .returnUrl()
         * .status()
         * .xUserId()
         * .xUsername()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AccountConnectionLink =
            AccountConnectionLink(
                checkRequired("id", id),
                checkRequired("accountId", accountId),
                checkRequired("completedAt", completedAt),
                checkRequired("createdAt", createdAt),
                checkRequired("expiresAt", expiresAt),
                checkRequired("failure", failure),
                checkRequired("health", health),
                object_,
                checkRequired("purpose", purpose),
                checkRequired("reference", reference),
                checkRequired("returnUrl", returnUrl),
                checkRequired("status", status),
                checkRequired("xUserId", xUserId),
                checkRequired("xUsername", xUsername),
                url,
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
    fun validate(): AccountConnectionLink = apply {
        if (validated) {
            return@apply
        }

        id()
        accountId()
        completedAt()
        createdAt()
        expiresAt()
        failure()
        health()
        _object_().let {
            if (it != JsonValue.from("x_account_connection_link")) {
                throw XTwitterScraperInvalidDataException("'object_' is invalid, received $it")
            }
        }
        purpose().validate()
        reference()
        returnUrl()
        status().validate()
        xUserId()
        xUsername()
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

    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (accountId.asKnown().isPresent) 1 else 0) +
            (if (completedAt.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (expiresAt.asKnown().isPresent) 1 else 0) +
            (if (failure.asKnown().isPresent) 1 else 0) +
            (if (health.asKnown().isPresent) 1 else 0) +
            object_.let { if (it == JsonValue.from("x_account_connection_link")) 1 else 0 } +
            (purpose.asKnown().getOrNull()?.validity() ?: 0) +
            (if (reference.asKnown().isPresent) 1 else 0) +
            (if (returnUrl.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (xUserId.asKnown().isPresent) 1 else 0) +
            (if (xUsername.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0)

    class Purpose @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val CONNECT = of("connect")

            @JvmField val RECONNECT = of("reconnect")

            @JvmStatic fun of(value: String) = Purpose(JsonField.of(value))
        }

        /** An enum containing [Purpose]'s known values. */
        enum class Known {
            CONNECT,
            RECONNECT,
        }

        /**
         * An enum containing [Purpose]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Purpose] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            CONNECT,
            RECONNECT,
            /** An enum member indicating that [Purpose] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         */
        fun value(): Value =
            when (this) {
                CONNECT -> Value.CONNECT
                RECONNECT -> Value.RECONNECT
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
                CONNECT -> Known.CONNECT
                RECONNECT -> Known.RECONNECT
                else -> throw XTwitterScraperInvalidDataException("Unknown Purpose: $value")
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
        fun validate(): Purpose = apply {
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

            return other is Purpose && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val PENDING = of("pending")

            @JvmField val CONNECTING = of("connecting")

            @JvmField val REQUIRES_EMAIL_CODE = of("requires_email_code")

            @JvmField val CONNECTED = of("connected")

            @JvmField val FAILED = of("failed")

            @JvmField val EXPIRED = of("expired")

            @JvmField val REVOKED = of("revoked")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            PENDING,
            CONNECTING,
            REQUIRES_EMAIL_CODE,
            CONNECTED,
            FAILED,
            EXPIRED,
            REVOKED,
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
            CONNECTING,
            REQUIRES_EMAIL_CODE,
            CONNECTED,
            FAILED,
            EXPIRED,
            REVOKED,
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
                CONNECTING -> Value.CONNECTING
                REQUIRES_EMAIL_CODE -> Value.REQUIRES_EMAIL_CODE
                CONNECTED -> Value.CONNECTED
                FAILED -> Value.FAILED
                EXPIRED -> Value.EXPIRED
                REVOKED -> Value.REVOKED
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
                CONNECTING -> Known.CONNECTING
                REQUIRES_EMAIL_CODE -> Known.REQUIRES_EMAIL_CODE
                CONNECTED -> Known.CONNECTED
                FAILED -> Known.FAILED
                EXPIRED -> Known.EXPIRED
                REVOKED -> Known.REVOKED
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountConnectionLink &&
            id == other.id &&
            accountId == other.accountId &&
            completedAt == other.completedAt &&
            createdAt == other.createdAt &&
            expiresAt == other.expiresAt &&
            failure == other.failure &&
            health == other.health &&
            object_ == other.object_ &&
            purpose == other.purpose &&
            reference == other.reference &&
            returnUrl == other.returnUrl &&
            status == other.status &&
            xUserId == other.xUserId &&
            xUsername == other.xUsername &&
            url == other.url &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            accountId,
            completedAt,
            createdAt,
            expiresAt,
            failure,
            health,
            object_,
            purpose,
            reference,
            returnUrl,
            status,
            xUserId,
            xUsername,
            url,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AccountConnectionLink{id=$id, accountId=$accountId, completedAt=$completedAt, createdAt=$createdAt, expiresAt=$expiresAt, failure=$failure, health=$health, object_=$object_, purpose=$purpose, reference=$reference, returnUrl=$returnUrl, status=$status, xUserId=$xUserId, xUsername=$xUsername, url=$url, additionalProperties=$additionalProperties}"
}
