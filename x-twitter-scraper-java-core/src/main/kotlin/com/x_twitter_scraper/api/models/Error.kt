// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models

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
import kotlin.jvm.optionals.getOrNull

/** Error response containing a machine-readable error code. */
class Error
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val error: JsonField<InnerError>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("error") @ExcludeMissing error: JsonField<InnerError> = JsonMissing.of()
    ) : this(error, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun error(): InnerError = error.getRequired("error")

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<InnerError> = error

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
         * Returns a mutable builder for constructing an instance of [Error].
         *
         * The following fields are required:
         * ```java
         * .error()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Error]. */
    class Builder internal constructor() {

        private var error: JsonField<InnerError>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(error: Error) = apply {
            this.error = error.error
            additionalProperties = error.additionalProperties.toMutableMap()
        }

        fun error(error: InnerError) = error(JsonField.of(error))

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [InnerError] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun error(error: JsonField<InnerError>) = apply { this.error = error }

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
         * Returns an immutable instance of [Error].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .error()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Error =
            Error(checkRequired("error", error), additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): Error = apply {
        if (validated) {
            return@apply
        }

        error().validate()
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
    @JvmSynthetic internal fun validity(): Int = (error.asKnown().getOrNull()?.validity() ?: 0)

    class InnerError @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val INTERNAL_ERROR = of("internal_error")

            @JvmField val INVALID_FORMAT = of("invalid_format")

            @JvmField val INVALID_ID = of("invalid_id")

            @JvmField val INVALID_INPUT = of("invalid_input")

            @JvmField val INVALID_PARAMS = of("invalid_params")

            @JvmField val INVALID_TOOL_TYPE = of("invalid_tool_type")

            @JvmField val INVALID_TWEET_ID = of("invalid_tweet_id")

            @JvmField val INVALID_TWEET_URL = of("invalid_tweet_url")

            @JvmField val INVALID_USERNAME = of("invalid_username")

            @JvmField val MISSING_PARAMS = of("missing_params")

            @JvmField val MISSING_QUERY = of("missing_query")

            @JvmField val MONITOR_ALREADY_EXISTS = of("monitor_already_exists")

            @JvmField val MONITOR_LIMIT_REACHED = of("monitor_limit_reached")

            @JvmField val NO_SUBSCRIPTION = of("no_subscription")

            @JvmField val NOT_FOUND = of("not_found")

            @JvmField val STREAM_REGISTRATION_FAILED = of("stream_registration_failed")

            @JvmField val SUBSCRIPTION_INACTIVE = of("subscription_inactive")

            @JvmField val TWEET_NOT_FOUND = of("tweet_not_found")

            @JvmField val UNAUTHENTICATED = of("unauthenticated")

            @JvmField val USAGE_LIMIT_REACHED = of("usage_limit_reached")

            @JvmField val USER_NOT_FOUND = of("user_not_found")

            @JvmField val WEBHOOK_INACTIVE = of("webhook_inactive")

            @JvmField val X_API_RATE_LIMITED = of("x_api_rate_limited")

            @JvmField val X_API_UNAVAILABLE = of("x_api_unavailable")

            @JvmField val X_API_UNAUTHORIZED = of("x_api_unauthorized")

            @JvmStatic fun of(value: String) = InnerError(JsonField.of(value))
        }

        /** An enum containing [InnerError]'s known values. */
        enum class Known {
            INTERNAL_ERROR,
            INVALID_FORMAT,
            INVALID_ID,
            INVALID_INPUT,
            INVALID_PARAMS,
            INVALID_TOOL_TYPE,
            INVALID_TWEET_ID,
            INVALID_TWEET_URL,
            INVALID_USERNAME,
            MISSING_PARAMS,
            MISSING_QUERY,
            MONITOR_ALREADY_EXISTS,
            MONITOR_LIMIT_REACHED,
            NO_SUBSCRIPTION,
            NOT_FOUND,
            STREAM_REGISTRATION_FAILED,
            SUBSCRIPTION_INACTIVE,
            TWEET_NOT_FOUND,
            UNAUTHENTICATED,
            USAGE_LIMIT_REACHED,
            USER_NOT_FOUND,
            WEBHOOK_INACTIVE,
            X_API_RATE_LIMITED,
            X_API_UNAVAILABLE,
            X_API_UNAUTHORIZED,
        }

        /**
         * An enum containing [InnerError]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [InnerError] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            INTERNAL_ERROR,
            INVALID_FORMAT,
            INVALID_ID,
            INVALID_INPUT,
            INVALID_PARAMS,
            INVALID_TOOL_TYPE,
            INVALID_TWEET_ID,
            INVALID_TWEET_URL,
            INVALID_USERNAME,
            MISSING_PARAMS,
            MISSING_QUERY,
            MONITOR_ALREADY_EXISTS,
            MONITOR_LIMIT_REACHED,
            NO_SUBSCRIPTION,
            NOT_FOUND,
            STREAM_REGISTRATION_FAILED,
            SUBSCRIPTION_INACTIVE,
            TWEET_NOT_FOUND,
            UNAUTHENTICATED,
            USAGE_LIMIT_REACHED,
            USER_NOT_FOUND,
            WEBHOOK_INACTIVE,
            X_API_RATE_LIMITED,
            X_API_UNAVAILABLE,
            X_API_UNAUTHORIZED,
            /**
             * An enum member indicating that [InnerError] was instantiated with an unknown value.
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
                INTERNAL_ERROR -> Value.INTERNAL_ERROR
                INVALID_FORMAT -> Value.INVALID_FORMAT
                INVALID_ID -> Value.INVALID_ID
                INVALID_INPUT -> Value.INVALID_INPUT
                INVALID_PARAMS -> Value.INVALID_PARAMS
                INVALID_TOOL_TYPE -> Value.INVALID_TOOL_TYPE
                INVALID_TWEET_ID -> Value.INVALID_TWEET_ID
                INVALID_TWEET_URL -> Value.INVALID_TWEET_URL
                INVALID_USERNAME -> Value.INVALID_USERNAME
                MISSING_PARAMS -> Value.MISSING_PARAMS
                MISSING_QUERY -> Value.MISSING_QUERY
                MONITOR_ALREADY_EXISTS -> Value.MONITOR_ALREADY_EXISTS
                MONITOR_LIMIT_REACHED -> Value.MONITOR_LIMIT_REACHED
                NO_SUBSCRIPTION -> Value.NO_SUBSCRIPTION
                NOT_FOUND -> Value.NOT_FOUND
                STREAM_REGISTRATION_FAILED -> Value.STREAM_REGISTRATION_FAILED
                SUBSCRIPTION_INACTIVE -> Value.SUBSCRIPTION_INACTIVE
                TWEET_NOT_FOUND -> Value.TWEET_NOT_FOUND
                UNAUTHENTICATED -> Value.UNAUTHENTICATED
                USAGE_LIMIT_REACHED -> Value.USAGE_LIMIT_REACHED
                USER_NOT_FOUND -> Value.USER_NOT_FOUND
                WEBHOOK_INACTIVE -> Value.WEBHOOK_INACTIVE
                X_API_RATE_LIMITED -> Value.X_API_RATE_LIMITED
                X_API_UNAVAILABLE -> Value.X_API_UNAVAILABLE
                X_API_UNAUTHORIZED -> Value.X_API_UNAUTHORIZED
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
                INTERNAL_ERROR -> Known.INTERNAL_ERROR
                INVALID_FORMAT -> Known.INVALID_FORMAT
                INVALID_ID -> Known.INVALID_ID
                INVALID_INPUT -> Known.INVALID_INPUT
                INVALID_PARAMS -> Known.INVALID_PARAMS
                INVALID_TOOL_TYPE -> Known.INVALID_TOOL_TYPE
                INVALID_TWEET_ID -> Known.INVALID_TWEET_ID
                INVALID_TWEET_URL -> Known.INVALID_TWEET_URL
                INVALID_USERNAME -> Known.INVALID_USERNAME
                MISSING_PARAMS -> Known.MISSING_PARAMS
                MISSING_QUERY -> Known.MISSING_QUERY
                MONITOR_ALREADY_EXISTS -> Known.MONITOR_ALREADY_EXISTS
                MONITOR_LIMIT_REACHED -> Known.MONITOR_LIMIT_REACHED
                NO_SUBSCRIPTION -> Known.NO_SUBSCRIPTION
                NOT_FOUND -> Known.NOT_FOUND
                STREAM_REGISTRATION_FAILED -> Known.STREAM_REGISTRATION_FAILED
                SUBSCRIPTION_INACTIVE -> Known.SUBSCRIPTION_INACTIVE
                TWEET_NOT_FOUND -> Known.TWEET_NOT_FOUND
                UNAUTHENTICATED -> Known.UNAUTHENTICATED
                USAGE_LIMIT_REACHED -> Known.USAGE_LIMIT_REACHED
                USER_NOT_FOUND -> Known.USER_NOT_FOUND
                WEBHOOK_INACTIVE -> Known.WEBHOOK_INACTIVE
                X_API_RATE_LIMITED -> Known.X_API_RATE_LIMITED
                X_API_UNAVAILABLE -> Known.X_API_UNAVAILABLE
                X_API_UNAUTHORIZED -> Known.X_API_UNAUTHORIZED
                else -> throw XTwitterScraperInvalidDataException("Unknown InnerError: $value")
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

        fun validate(): InnerError = apply {
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

            return other is InnerError && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Error &&
            error == other.error &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(error, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() = "Error{error=$error, additionalProperties=$additionalProperties}"
}
