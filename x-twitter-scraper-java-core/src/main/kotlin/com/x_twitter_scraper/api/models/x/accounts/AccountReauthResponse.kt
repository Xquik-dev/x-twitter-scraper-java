// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

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

/**
 * Sanitized X account summary returned by connect and reauth. Includes an optional `loginCountry`
 * field surfaced only when the declared proxy region had no Driver capacity and the login fell back
 * to a single US consumer device for this one-time action. Future activity continues to use the
 * selected `proxy_country`; the field is omitted on normal logins.
 */
class AccountReauthResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val health: JsonField<Health>,
    private val status: JsonField<String>,
    private val xUserId: JsonField<String>,
    private val xUsername: JsonField<String>,
    private val loginCountry: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("health") @ExcludeMissing health: JsonField<Health> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("xUserId") @ExcludeMissing xUserId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("xUsername") @ExcludeMissing xUsername: JsonField<String> = JsonMissing.of(),
        @JsonProperty("loginCountry")
        @ExcludeMissing
        loginCountry: JsonField<String> = JsonMissing.of(),
    ) : this(id, createdAt, health, status, xUserId, xUsername, loginCountry, mutableMapOf())

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
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun health(): Health = health.getRequired("health")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): String = status.getRequired("status")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun xUserId(): String = xUserId.getRequired("xUserId")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun xUsername(): String = xUsername.getRequired("xUsername")

    /**
     * ISO-3166-1 alpha-2 country code of the Driver consumer device used for this login. Present
     * only when the US fallback was triggered because Driver had no capacity in the declared
     * region. Omitted otherwise.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun loginCountry(): Optional<String> = loginCountry.getOptional("loginCountry")

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
     * Returns the raw JSON value of [health].
     *
     * Unlike [health], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("health") @ExcludeMissing fun _health(): JsonField<Health> = health

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

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
     * Returns the raw JSON value of [loginCountry].
     *
     * Unlike [loginCountry], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("loginCountry")
    @ExcludeMissing
    fun _loginCountry(): JsonField<String> = loginCountry

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
         * Returns a mutable builder for constructing an instance of [AccountReauthResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .health()
         * .status()
         * .xUserId()
         * .xUsername()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AccountReauthResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var health: JsonField<Health>? = null
        private var status: JsonField<String>? = null
        private var xUserId: JsonField<String>? = null
        private var xUsername: JsonField<String>? = null
        private var loginCountry: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountReauthResponse: AccountReauthResponse) = apply {
            id = accountReauthResponse.id
            createdAt = accountReauthResponse.createdAt
            health = accountReauthResponse.health
            status = accountReauthResponse.status
            xUserId = accountReauthResponse.xUserId
            xUsername = accountReauthResponse.xUsername
            loginCountry = accountReauthResponse.loginCountry
            additionalProperties = accountReauthResponse.additionalProperties.toMutableMap()
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

        fun health(health: Health) = health(JsonField.of(health))

        /**
         * Sets [Builder.health] to an arbitrary JSON value.
         *
         * You should usually call [Builder.health] with a well-typed [Health] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun health(health: JsonField<Health>) = apply { this.health = health }

        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        fun xUserId(xUserId: String) = xUserId(JsonField.of(xUserId))

        /**
         * Sets [Builder.xUserId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.xUserId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun xUserId(xUserId: JsonField<String>) = apply { this.xUserId = xUserId }

        fun xUsername(xUsername: String) = xUsername(JsonField.of(xUsername))

        /**
         * Sets [Builder.xUsername] to an arbitrary JSON value.
         *
         * You should usually call [Builder.xUsername] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun xUsername(xUsername: JsonField<String>) = apply { this.xUsername = xUsername }

        /**
         * ISO-3166-1 alpha-2 country code of the Driver consumer device used for this login.
         * Present only when the US fallback was triggered because Driver had no capacity in the
         * declared region. Omitted otherwise.
         */
        fun loginCountry(loginCountry: String) = loginCountry(JsonField.of(loginCountry))

        /**
         * Sets [Builder.loginCountry] to an arbitrary JSON value.
         *
         * You should usually call [Builder.loginCountry] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun loginCountry(loginCountry: JsonField<String>) = apply {
            this.loginCountry = loginCountry
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
         * Returns an immutable instance of [AccountReauthResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .health()
         * .status()
         * .xUserId()
         * .xUsername()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AccountReauthResponse =
            AccountReauthResponse(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("health", health),
                checkRequired("status", status),
                checkRequired("xUserId", xUserId),
                checkRequired("xUsername", xUsername),
                loginCountry,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AccountReauthResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        health().validate()
        status()
        xUserId()
        xUsername()
        loginCountry()
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
            (health.asKnown().getOrNull()?.validity() ?: 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (xUserId.asKnown().isPresent) 1 else 0) +
            (if (xUsername.asKnown().isPresent) 1 else 0) +
            (if (loginCountry.asKnown().isPresent) 1 else 0)

    class Health @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val HEALTHY = of("healthy")

            @JvmField val LOCKED = of("locked")

            @JvmField val NEEDS_REAUTH = of("needsReauth")

            @JvmField val RECOVERING = of("recovering")

            @JvmField val SUSPENDED = of("suspended")

            @JvmField val TEMPORARY_ISSUE = of("temporaryIssue")

            @JvmStatic fun of(value: String) = Health(JsonField.of(value))
        }

        /** An enum containing [Health]'s known values. */
        enum class Known {
            HEALTHY,
            LOCKED,
            NEEDS_REAUTH,
            RECOVERING,
            SUSPENDED,
            TEMPORARY_ISSUE,
        }

        /**
         * An enum containing [Health]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Health] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            HEALTHY,
            LOCKED,
            NEEDS_REAUTH,
            RECOVERING,
            SUSPENDED,
            TEMPORARY_ISSUE,
            /** An enum member indicating that [Health] was instantiated with an unknown value. */
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
                HEALTHY -> Value.HEALTHY
                LOCKED -> Value.LOCKED
                NEEDS_REAUTH -> Value.NEEDS_REAUTH
                RECOVERING -> Value.RECOVERING
                SUSPENDED -> Value.SUSPENDED
                TEMPORARY_ISSUE -> Value.TEMPORARY_ISSUE
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
                HEALTHY -> Known.HEALTHY
                LOCKED -> Known.LOCKED
                NEEDS_REAUTH -> Known.NEEDS_REAUTH
                RECOVERING -> Known.RECOVERING
                SUSPENDED -> Known.SUSPENDED
                TEMPORARY_ISSUE -> Known.TEMPORARY_ISSUE
                else -> throw XTwitterScraperInvalidDataException("Unknown Health: $value")
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

        fun validate(): Health = apply {
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

            return other is Health && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountReauthResponse &&
            id == other.id &&
            createdAt == other.createdAt &&
            health == other.health &&
            status == other.status &&
            xUserId == other.xUserId &&
            xUsername == other.xUsername &&
            loginCountry == other.loginCountry &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            createdAt,
            health,
            status,
            xUserId,
            xUsername,
            loginCountry,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AccountReauthResponse{id=$id, createdAt=$createdAt, health=$health, status=$status, xUserId=$xUserId, xUsername=$xUsername, loginCountry=$loginCountry, additionalProperties=$additionalProperties}"
}
