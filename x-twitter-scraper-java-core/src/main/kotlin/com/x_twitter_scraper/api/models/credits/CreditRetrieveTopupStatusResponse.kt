// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.credits

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

class CreditRetrieveTopupStatusResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val status: JsonField<Status>,
    private val amountDollars: JsonField<Long>,
    private val credits: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("amount_dollars")
        @ExcludeMissing
        amountDollars: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("credits") @ExcludeMissing credits: JsonField<String> = JsonMissing.of(),
    ) : this(status, amountDollars, credits, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * Dollar amount requested for the top-up.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun amountDollars(): Optional<Long> = amountDollars.getOptional("amount_dollars")

    /**
     * Bigint string credit amount granted or pending.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun credits(): Optional<String> = credits.getOptional("credits")

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [amountDollars].
     *
     * Unlike [amountDollars], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("amount_dollars")
    @ExcludeMissing
    fun _amountDollars(): JsonField<Long> = amountDollars

    /**
     * Returns the raw JSON value of [credits].
     *
     * Unlike [credits], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("credits") @ExcludeMissing fun _credits(): JsonField<String> = credits

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
         * [CreditRetrieveTopupStatusResponse].
         *
         * The following fields are required:
         * ```java
         * .status()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CreditRetrieveTopupStatusResponse]. */
    class Builder internal constructor() {

        private var status: JsonField<Status>? = null
        private var amountDollars: JsonField<Long> = JsonMissing.of()
        private var credits: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(creditRetrieveTopupStatusResponse: CreditRetrieveTopupStatusResponse) =
            apply {
                status = creditRetrieveTopupStatusResponse.status
                amountDollars = creditRetrieveTopupStatusResponse.amountDollars
                credits = creditRetrieveTopupStatusResponse.credits
                additionalProperties =
                    creditRetrieveTopupStatusResponse.additionalProperties.toMutableMap()
            }

        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** Dollar amount requested for the top-up. */
        fun amountDollars(amountDollars: Long?) = amountDollars(JsonField.ofNullable(amountDollars))

        /**
         * Alias for [Builder.amountDollars].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun amountDollars(amountDollars: Long) = amountDollars(amountDollars as Long?)

        /** Alias for calling [Builder.amountDollars] with `amountDollars.orElse(null)`. */
        fun amountDollars(amountDollars: Optional<Long>) = amountDollars(amountDollars.getOrNull())

        /**
         * Sets [Builder.amountDollars] to an arbitrary JSON value.
         *
         * You should usually call [Builder.amountDollars] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun amountDollars(amountDollars: JsonField<Long>) = apply {
            this.amountDollars = amountDollars
        }

        /** Bigint string credit amount granted or pending. */
        fun credits(credits: String) = credits(JsonField.of(credits))

        /**
         * Sets [Builder.credits] to an arbitrary JSON value.
         *
         * You should usually call [Builder.credits] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun credits(credits: JsonField<String>) = apply { this.credits = credits }

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
         * Returns an immutable instance of [CreditRetrieveTopupStatusResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .status()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CreditRetrieveTopupStatusResponse =
            CreditRetrieveTopupStatusResponse(
                checkRequired("status", status),
                amountDollars,
                credits,
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
    fun validate(): CreditRetrieveTopupStatusResponse = apply {
        if (validated) {
            return@apply
        }

        status().validate()
        amountDollars()
        credits()
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
        (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (amountDollars.asKnown().isPresent) 1 else 0) +
            (if (credits.asKnown().isPresent) 1 else 0)

    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val PAID = of("paid")

            @JvmField val PROCESSING = of("processing")

            @JvmField val FAILED = of("failed")

            @JvmField val EXPIRED = of("expired")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            PAID,
            PROCESSING,
            FAILED,
            EXPIRED,
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
            PAID,
            PROCESSING,
            FAILED,
            EXPIRED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
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
                PAID -> Value.PAID
                PROCESSING -> Value.PROCESSING
                FAILED -> Value.FAILED
                EXPIRED -> Value.EXPIRED
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
                PAID -> Known.PAID
                PROCESSING -> Known.PROCESSING
                FAILED -> Known.FAILED
                EXPIRED -> Known.EXPIRED
                else -> throw XTwitterScraperInvalidDataException("Unknown Status: $value")
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

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CreditRetrieveTopupStatusResponse &&
            status == other.status &&
            amountDollars == other.amountDollars &&
            credits == other.credits &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(status, amountDollars, credits, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CreditRetrieveTopupStatusResponse{status=$status, amountDollars=$amountDollars, credits=$credits, additionalProperties=$additionalProperties}"
}
