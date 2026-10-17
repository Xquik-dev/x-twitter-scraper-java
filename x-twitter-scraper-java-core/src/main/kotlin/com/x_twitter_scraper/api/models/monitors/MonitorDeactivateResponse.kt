// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class MonitorDeactivateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val success: JsonValue,
    private val deletionStatus: JsonField<DeletionStatus>,
    private val statusUrl: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("success") @ExcludeMissing success: JsonValue = JsonMissing.of(),
        @JsonProperty("deletionStatus")
        @ExcludeMissing
        deletionStatus: JsonField<DeletionStatus> = JsonMissing.of(),
        @JsonProperty("statusUrl") @ExcludeMissing statusUrl: JsonField<String> = JsonMissing.of(),
    ) : this(
        success,
        deletionStatus,
        statusUrl,
        mutableMapOf(),
    )

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from(true)
     * ```
     */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonValue = success

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun deletionStatus(): Optional<DeletionStatus> = deletionStatus.getOptional("deletionStatus")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun statusUrl(): Optional<String> = statusUrl.getOptional("statusUrl")

    /**
     * Returns the raw JSON value of [deletionStatus].
     *
     * Unlike [deletionStatus], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("deletionStatus")
    @ExcludeMissing
    fun _deletionStatus(): JsonField<DeletionStatus> = deletionStatus

    /**
     * Returns the raw JSON value of [statusUrl].
     *
     * Unlike [statusUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("statusUrl") @ExcludeMissing fun _statusUrl(): JsonField<String> = statusUrl

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
         * Returns a mutable builder for constructing an instance of [MonitorDeactivateResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MonitorDeactivateResponse]. */
    class Builder internal constructor() {

        private var success: JsonValue = JsonValue.from(true)
        private var deletionStatus: JsonField<DeletionStatus> = JsonMissing.of()
        private var statusUrl: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(monitorDeactivateResponse: MonitorDeactivateResponse) = apply {
            success = monitorDeactivateResponse.success
            deletionStatus = monitorDeactivateResponse.deletionStatus
            statusUrl = monitorDeactivateResponse.statusUrl
            additionalProperties = monitorDeactivateResponse.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * Defaults to the following:
         * ```java
         * JsonValue.from(true)
         * ```
         */
        fun success(success: JsonValue) = apply { this.success = success }

        fun deletionStatus(deletionStatus: DeletionStatus) =
            deletionStatus(JsonField.of(deletionStatus))

        /** Sets [Builder.deletionStatus] to an arbitrary JSON value. */
        fun deletionStatus(deletionStatus: JsonField<DeletionStatus>) = apply {
            this.deletionStatus = deletionStatus
        }

        fun statusUrl(statusUrl: String) = statusUrl(JsonField.of(statusUrl))

        /** Sets [Builder.statusUrl] to an arbitrary JSON value. */
        fun statusUrl(statusUrl: JsonField<String>) = apply { this.statusUrl = statusUrl }

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
         * Returns an immutable instance of [MonitorDeactivateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MonitorDeactivateResponse =
            MonitorDeactivateResponse(
                success,
                deletionStatus,
                statusUrl,
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
    fun validate(): MonitorDeactivateResponse = apply {
        if (validated) {
            return@apply
        }

        _success().let {
            if (it != JsonValue.from(true)) {
                throw XTwitterScraperInvalidDataException("'success' is invalid, received $it")
            }
        }
        deletionStatus().ifPresent { it.validate() }
        statusUrl()
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
        success.let { if (it == JsonValue.from(true)) 1 else 0 } +
            (deletionStatus.asKnown().getOrNull()?.validity() ?: 0) +
            (if (statusUrl.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MonitorDeactivateResponse &&
            success == other.success &&
            deletionStatus == other.deletionStatus &&
            statusUrl == other.statusUrl &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(success, deletionStatus, statusUrl, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MonitorDeactivateResponse{success=$success, deletionStatus=$deletionStatus, statusUrl=$statusUrl, additionalProperties=$additionalProperties}"

    class DeletionStatus @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val DELETING = of("deleting")

            @JvmStatic fun of(value: String) = DeletionStatus(JsonField.of(value))
        }

        /** An enum containing [DeletionStatus]'s known values. */
        enum class Known {
            DELETING
        }

        /**
         * An enum containing [DeletionStatus]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [DeletionStatus] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            DELETING,
            /**
             * An enum member indicating that [DeletionStatus] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         */
        fun value(): Value =
            when (this) {
                DELETING -> Value.DELETING
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
                DELETING -> Known.DELETING
                else -> throw XTwitterScraperInvalidDataException("Unknown DeletionStatus: $value")
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
        fun validate(): DeletionStatus = apply {
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

            return other is DeletionStatus && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }
}
