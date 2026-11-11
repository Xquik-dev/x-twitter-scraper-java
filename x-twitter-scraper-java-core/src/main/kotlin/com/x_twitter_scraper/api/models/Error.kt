// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.BaseDeserializer
import com.x_twitter_scraper.api.core.BaseSerializer
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.allMaxBy
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.getOrThrow
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Error response. Default v1 returns a legacy string error code. Send `xquik-api-contract:
 * 2026-04-29` to receive the structured best-practice error object.
 */
class Error
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val error: JsonField<InnerError>,
    private val message: JsonField<String>,
    private val reason: JsonField<String>,
    private val retryAfter: JsonField<Long>,
    private val retryAfterMs: JsonField<Long>,
    private val requiredScope: JsonField<RequiredScope>,
    private val allowedFields: JsonField<List<String>>,
    private val fieldErrors: JsonField<List<FieldError>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("error") @ExcludeMissing error: JsonField<InnerError> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
        @JsonProperty("retryAfter") @ExcludeMissing retryAfter: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("retryAfterMs")
        @ExcludeMissing
        retryAfterMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("requiredScope")
        @ExcludeMissing
        requiredScope: JsonField<RequiredScope> = JsonMissing.of(),
        @JsonProperty("allowedFields")
        @ExcludeMissing
        allowedFields: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("fieldErrors")
        @ExcludeMissing
        fieldErrors: JsonField<List<FieldError>> = JsonMissing.of(),
    ) : this(
        error,
        message,
        reason,
        retryAfter,
        retryAfterMs,
        requiredScope,
        allowedFields,
        fieldErrors,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun error(): InnerError = error.getRequired("error")

    /**
     * Human-readable error guidance.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun message(): Optional<String> = message.getOptional("message")

    /**
     * Machine-readable reason for a login cooldown.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun reason(): Optional<String> = reason.getOptional("reason")

    /**
     * Seconds until the next permitted request.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun retryAfter(): Optional<Long> = retryAfter.getOptional("retryAfter")

    /**
     * Required wait in milliseconds.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun retryAfterMs(): Optional<Long> = retryAfterMs.getOptional("retryAfterMs")

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<InnerError> = error

    /**
     * Returns the raw JSON value of [message].
     *
     * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

    /**
     * Returns the raw JSON value of [reason].
     *
     * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

    /**
     * Returns the raw JSON value of [retryAfter].
     *
     * Unlike [retryAfter], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("retryAfter") @ExcludeMissing fun _retryAfter(): JsonField<Long> = retryAfter

    /**
     * Returns the raw JSON value of [retryAfterMs].
     *
     * Unlike [retryAfterMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("retryAfterMs")
    @ExcludeMissing
    fun _retryAfterMs(): JsonField<Long> = retryAfterMs

    /**
     * With insufficient_scope, the scope the API key needs for this route.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun requiredScope(): Optional<RequiredScope> = requiredScope.getOptional("requiredScope")

    /**
     * Returns the raw JSON value of [requiredScope].
     *
     * Unlike [requiredScope], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("requiredScope")
    @ExcludeMissing
    fun _requiredScope(): JsonField<RequiredScope> = requiredScope

    /**
     * With unknown_field, the valid names where the first unknown name in fields or omit stopped.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun allowedFields(): Optional<List<String>> = allowedFields.getOptional("allowedFields")

    /**
     * Returns the raw JSON value of [allowedFields].
     *
     * Unlike [allowedFields], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("allowedFields")
    @ExcludeMissing
    fun _allowedFields(): JsonField<List<String>> = allowedFields

    /**
     * With unknown_field, each unknown name in fields or omit, with the name it most likely meant.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun fieldErrors(): Optional<List<FieldError>> = fieldErrors.getOptional("fieldErrors")

    /**
     * Returns the raw JSON value of [fieldErrors].
     *
     * Unlike [fieldErrors], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fieldErrors")
    @ExcludeMissing
    fun _fieldErrors(): JsonField<List<FieldError>> = fieldErrors

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
        private var message: JsonField<String> = JsonMissing.of()
        private var reason: JsonField<String> = JsonMissing.of()
        private var retryAfter: JsonField<Long> = JsonMissing.of()
        private var retryAfterMs: JsonField<Long> = JsonMissing.of()
        private var requiredScope: JsonField<RequiredScope> = JsonMissing.of()
        private var allowedFields: JsonField<MutableList<String>>? = null
        private var fieldErrors: JsonField<MutableList<FieldError>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(error: Error) = apply {
            this.error = error.error
            message = error.message
            reason = error.reason
            retryAfter = error.retryAfter
            retryAfterMs = error.retryAfterMs
            requiredScope = error.requiredScope
            allowedFields = error.allowedFields.map { it.toMutableList() }
            fieldErrors = error.fieldErrors.map { it.toMutableList() }
            additionalProperties = error.additionalProperties.toMutableMap()
        }

        fun error(error: InnerError) = error(JsonField.of(error))

        /** Sets [Builder.error] to an arbitrary JSON value. */
        fun error(error: JsonField<InnerError>) = apply { this.error = error }

        /** Alias for calling [error] with `InnerError.ofLegacyErrorCode(legacyErrorCode)`. */
        fun error(legacyErrorCode: InnerError.LegacyErrorCode) =
            error(InnerError.ofLegacyErrorCode(legacyErrorCode))

        /** Alias for calling [error] with `InnerError.ofStructured(structured)`. */
        fun error(structured: InnerError.StructuredError) =
            error(InnerError.ofStructured(structured))

        /** Human-readable error guidance. */
        fun message(message: String) = message(JsonField.of(message))

        /** Sets [Builder.message] to an arbitrary JSON value. */
        fun message(message: JsonField<String>) = apply { this.message = message }

        /** Machine-readable reason for a login cooldown. */
        fun reason(reason: String) = reason(JsonField.of(reason))

        /** Sets [Builder.reason] to an arbitrary JSON value. */
        fun reason(reason: JsonField<String>) = apply { this.reason = reason }

        /** Seconds until the next permitted request. */
        fun retryAfter(retryAfter: Long) = retryAfter(JsonField.of(retryAfter))

        /** Sets [Builder.retryAfter] to an arbitrary JSON value. */
        fun retryAfter(retryAfter: JsonField<Long>) = apply { this.retryAfter = retryAfter }

        /** Required wait in milliseconds. */
        fun retryAfterMs(retryAfterMs: Long) = retryAfterMs(JsonField.of(retryAfterMs))

        /** Sets [Builder.retryAfterMs] to an arbitrary JSON value. */
        fun retryAfterMs(retryAfterMs: JsonField<Long>) = apply { this.retryAfterMs = retryAfterMs }

        /** With insufficient_scope, the scope the API key needs for this route. */
        fun requiredScope(requiredScope: RequiredScope) = requiredScope(JsonField.of(requiredScope))

        /**
         * Sets [Builder.requiredScope] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requiredScope] with a well-typed [RequiredScope] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun requiredScope(requiredScope: JsonField<RequiredScope>) = apply {
            this.requiredScope = requiredScope
        }

        /**
         * With unknown_field, the valid names where the first unknown name in fields or omit
         * stopped.
         */
        fun allowedFields(allowedFields: List<String>) = allowedFields(JsonField.of(allowedFields))

        /**
         * Sets [Builder.allowedFields] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowedFields] with a well-typed [List<String>] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun allowedFields(allowedFields: JsonField<List<String>>) = apply {
            this.allowedFields = allowedFields.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [allowedFields].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAllowedField(allowedField: String) = apply {
            allowedFields =
                (allowedFields ?: JsonField.of(mutableListOf())).also {
                    checkKnown("allowedFields", it).add(allowedField)
                }
        }

        /**
         * With unknown_field, each unknown name in fields or omit, with the name it most likely
         * meant.
         */
        fun fieldErrors(fieldErrors: List<FieldError>) = fieldErrors(JsonField.of(fieldErrors))

        /**
         * Sets [Builder.fieldErrors] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fieldErrors] with a well-typed [List<FieldError>] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun fieldErrors(fieldErrors: JsonField<List<FieldError>>) = apply {
            this.fieldErrors = fieldErrors.map { it.toMutableList() }
        }

        /**
         * Adds a single [FieldError] to [fieldErrors].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFieldError(fieldError: FieldError) = apply {
            fieldErrors =
                (fieldErrors ?: JsonField.of(mutableListOf())).also {
                    checkKnown("fieldErrors", it).add(fieldError)
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
            Error(
                checkRequired("error", error),
                message,
                reason,
                retryAfter,
                retryAfterMs,
                requiredScope,
                (allowedFields ?: JsonMissing.of()).map { it.toImmutable() },
                (fieldErrors ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): Error = apply {
        if (validated) {
            return@apply
        }

        error().validate()
        message()
        reason()
        retryAfter()
        retryAfterMs()
        requiredScope().ifPresent { it.validate() }
        allowedFields()
        fieldErrors().ifPresent { it.forEach { it.validate() } }
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
        (error.asKnown().getOrNull()?.validity() ?: 0) +
            (if (message.asKnown().isPresent) 1 else 0) +
            (if (reason.asKnown().isPresent) 1 else 0) +
            (if (retryAfter.asKnown().isPresent) 1 else 0) +
            (if (retryAfterMs.asKnown().isPresent) 1 else 0) +
            (requiredScope.asKnown().getOrNull()?.validity() ?: 0) +
            (allowedFields.asKnown().getOrNull()?.size ?: 0) +
            (fieldErrors.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

    @JsonDeserialize(using = InnerError.Deserializer::class)
    @JsonSerialize(using = InnerError.Serializer::class)
    class InnerError
    private constructor(
        private val legacyErrorCode: LegacyErrorCode? = null,
        private val structured: StructuredError? = null,
        private val _json: JsonValue? = null,
    ) {

        fun legacyErrorCode(): Optional<LegacyErrorCode> = Optional.ofNullable(legacyErrorCode)

        fun structured(): Optional<StructuredError> = Optional.ofNullable(structured)

        fun isLegacyErrorCode(): Boolean = legacyErrorCode != null

        fun isStructured(): Boolean = structured != null

        fun asLegacyErrorCode(): LegacyErrorCode = legacyErrorCode.getOrThrow("legacyErrorCode")

        fun asStructured(): StructuredError = structured.getOrThrow("structured")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * @throws XTwitterScraperInvalidDataException if [Visitor.unknown] is not overridden in
         *   [visitor] and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                legacyErrorCode != null -> visitor.visitLegacyErrorCode(legacyErrorCode)
                structured != null -> visitor.visitStructured(structured)
                else -> visitor.unknown(_json)
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
        fun validate(): InnerError = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitLegacyErrorCode(legacyErrorCode: LegacyErrorCode) {
                        legacyErrorCode.validate()
                    }

                    override fun visitStructured(structured: StructuredError) {
                        structured.validate()
                    }
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitLegacyErrorCode(legacyErrorCode: LegacyErrorCode) =
                        legacyErrorCode.validity()

                    override fun visitStructured(structured: StructuredError) =
                        structured.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is InnerError &&
                legacyErrorCode == other.legacyErrorCode &&
                structured == other.structured
        }

        override fun hashCode(): Int = Objects.hash(legacyErrorCode, structured)

        override fun toString(): String =
            when {
                legacyErrorCode != null -> "InnerError{legacyErrorCode=$legacyErrorCode}"
                structured != null -> "InnerError{structured=$structured}"
                _json != null -> "InnerError{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid InnerError")
            }

        companion object {

            @JvmStatic
            fun ofLegacyErrorCode(legacyErrorCode: LegacyErrorCode) =
                InnerError(legacyErrorCode = legacyErrorCode)

            @JvmStatic
            fun ofStructured(structured: StructuredError) = InnerError(structured = structured)
        }

        /**
         * An interface that defines how to map each variant of [InnerError] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitLegacyErrorCode(legacyErrorCode: LegacyErrorCode): T

            fun visitStructured(structured: StructuredError): T

            /**
             * Maps an unknown variant of [InnerError] to a value of type [T].
             *
             * An instance of [InnerError] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant.
             *
             * @throws XTwitterScraperInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw XTwitterScraperInvalidDataException("Unknown InnerError: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<InnerError>(InnerError::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): InnerError {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<LegacyErrorCode>())?.let {
                                InnerError(legacyErrorCode = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<StructuredError>())?.let {
                                InnerError(structured = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    0 -> InnerError(_json = json)
                    1 -> bestMatches.single()
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<InnerError>(InnerError::class) {

            override fun serialize(
                value: InnerError,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.legacyErrorCode != null -> generator.writeObject(value.legacyErrorCode)
                    value.structured != null -> generator.writeObject(value.structured)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid InnerError")
                }
            }
        }

        class LegacyErrorCode
        @JsonCreator
        private constructor(private val value: JsonField<String>) : Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val INTERNAL_ERROR = of("internal_error")

                @JvmField val ACCOUNT_ALREADY_CONNECTED = of("account_already_connected")

                @JvmField
                val X_ACCOUNT_CONNECT_PERMISSION_REQUIRED =
                    of("x_account_connect_permission_required")

                @JvmField val X_ACCOUNT_MISMATCH = of("x_account_mismatch")

                @JvmField val ACCOUNT_NEEDS_REAUTH = of("account_needs_reauth")

                @JvmField val ACCOUNT_NOT_FOUND = of("account_not_found")

                @JvmField val ACCOUNT_REQUIRED = of("account_required")

                @JvmField val ACCOUNT_RESTRICTED = of("account_restricted")

                @JvmField val API_KEY_EXPIRED = of("api_key_expired")

                @JvmField val API_KEY_LIMIT_REACHED = of("api_key_limit_reached")

                @JvmField val API_KEY_PAUSED = of("api_key_paused")

                @JvmField val API_KEY_BUDGET_REACHED = of("api_key_budget_reached")

                @JvmField val API_KEY_REVOKED = of("api_key_revoked")

                @JvmField val IP_NOT_ALLOWED = of("ip_not_allowed")

                @JvmField val ARTICLE_NOT_FOUND = of("article_not_found")

                @JvmField val CLOSED = of("closed")

                @JvmField val DM_NOT_PERMITTED = of("dm_not_permitted")

                @JvmField val INVALID_FORMAT = of("invalid_format")

                @JvmField val INVALID_ID = of("invalid_id")

                @JvmField val INVALID_INPUT = of("invalid_input")

                @JvmField val INVALID_MEDIA_URL = of("invalid_media_url")

                @JvmField val INVALID_MESSAGE_ID = of("invalid_message_id")

                @JvmField val INVALID_PARAMS = of("invalid_params")

                @JvmField val INVALID_TOOL_TYPE = of("invalid_tool_type")

                @JvmField val INVALID_TWEET_ID = of("invalid_tweet_id")

                @JvmField val INVALID_TWEET_URL = of("invalid_tweet_url")

                @JvmField val INVALID_USER_ID = of("invalid_user_id")

                @JvmField val INVALID_USER_IDS = of("invalid_user_ids")

                @JvmField val INVALID_USERNAME = of("invalid_username")

                @JvmField val INVALID_JSON = of("invalid_json")

                @JvmField val INSUFFICIENT_CREDITS = of("insufficient_credits")

                @JvmField val INSUFFICIENT_SCOPE = of("insufficient_scope")

                @JvmField val JOB_NOT_FOUND = of("job_not_found")

                @JvmField val LOGIN_COOLDOWN = of("login_cooldown")

                @JvmField val LOGIN_FAILED = of("login_failed")

                @JvmField val MEDIA_DOWNLOAD_FAILED = of("media_download_failed")

                @JvmField val MEDIA_NOT_UPLOADED = of("media_not_uploaded")

                @JvmField val MEDIA_TOO_LARGE = of("media_too_large")

                @JvmField val MEDIA_UNAVAILABLE = of("media_unavailable")

                @JvmField val MISSING_PARAMS = of("missing_params")

                @JvmField val MISSING_QUERY = of("missing_query")

                @JvmField val MONITOR_ALREADY_EXISTS = of("monitor_already_exists")

                @JvmField val MONITOR_PROFILE_UNAVAILABLE = of("monitor_profile_unavailable")

                @JvmField val NO_MEDIA = of("no_media")

                @JvmField val NO_CREDITS = of("no_credits")

                @JvmField val NO_SUBSCRIPTION = of("no_subscription")

                @JvmField val EXTRACTION_TERMINAL = of("extraction_terminal")

                @JvmField val NOT_FOUND = of("not_found")

                @JvmField val PAYMENT_FAILED = of("payment_failed")

                @JvmField val POST_UNAVAILABLE = of("post_unavailable")

                @JvmField val PRICE_CHANGED = of("price_changed")

                @JvmField val RATE_LIMIT_EXCEEDED = of("rate_limit_exceeded")

                @JvmField val SERVICE_UNAVAILABLE = of("service_unavailable")

                @JvmField val SESSION_REQUIRED = of("session_required")

                @JvmField val STYLE_NOT_FOUND = of("style_not_found")

                @JvmField val SUBSCRIPTION_INACTIVE = of("subscription_inactive")

                @JvmField val TWEET_NOT_FOUND = of("tweet_not_found")

                @JvmField val UNAUTHENTICATED = of("unauthenticated")

                @JvmField val UNSUPPORTED_FIELD = of("unsupported_field")

                @JvmField val USER_NOT_FOUND = of("user_not_found")

                @JvmField val BODY_TOO_LARGE = of("body_too_large")

                @JvmField val BOOKMARK_FOLDERS_UNAVAILABLE = of("bookmark_folders_unavailable")

                @JvmField val BROADCAST_NOT_FOUND = of("broadcast_not_found")

                @JvmField val CHECKOUT_UNAVAILABLE = of("checkout_unavailable")

                @JvmField val CONNECTION_CHALLENGE_EXPIRED = of("connection_challenge_expired")

                @JvmField val CONNECTION_CHALLENGE_INACTIVE = of("connection_challenge_inactive")

                @JvmField val CONTRIBUTOR_NOT_FOUND = of("contributor_not_found")

                @JvmField val COVERAGE_CURSOR_GONE = of("coverage_cursor_gone")

                @JvmField val COVERAGE_CURSOR_UNAVAILABLE = of("coverage_cursor_unavailable")

                @JvmField val CURSOR_ACCOUNT_UNAVAILABLE = of("cursor_account_unavailable")

                @JvmField val DRAFT_NOT_FOUND = of("draft_not_found")

                @JvmField val DRAW_TOO_LARGE = of("draw_too_large")

                @JvmField val EXPIRED = of("expired")

                @JvmField val FAVORITERS_UNAVAILABLE = of("favoriters_unavailable")

                @JvmField val FORBIDDEN = of("forbidden")

                @JvmField val GUEST_WALLET_UNAVAILABLE = of("guest_wallet_unavailable")

                @JvmField val GUEST_WALLETS_DISABLED = of("guest_wallets_disabled")

                @JvmField val GUEST_WALLETS_UNAVAILABLE = of("guest_wallets_unavailable")

                @JvmField val IDEMPOTENCY_CONFLICT = of("idempotency_conflict")

                @JvmField val IDEMPOTENCY_IN_PROGRESS = of("idempotency_in_progress")

                @JvmField val IDEMPOTENCY_KEY_CONFLICT = of("idempotency_key_conflict")

                @JvmField val INVALID_BROADCAST_ID = of("invalid_broadcast_id")

                @JvmField val INVALID_COMMUNITY_ID = of("invalid_community_id")

                @JvmField val INVALID_COMMUNITY_TOPIC = of("invalid_community_topic")

                @JvmField
                val INVALID_COMPLETE_REPLIES_REQUEST = of("invalid_complete_replies_request")

                @JvmField val INVALID_CONTRIBUTOR_ALIAS = of("invalid_contributor_alias")

                @JvmField val INVALID_COVERAGE_CURSOR = of("invalid_coverage_cursor")

                @JvmField val INVALID_COVERAGE_REQUEST = of("invalid_coverage_request")

                @JvmField val INVALID_CURSOR = of("invalid_cursor")

                @JvmField val INVALID_IDEMPOTENCY_KEY = of("invalid_idempotency_key")

                @JvmField val INVALID_JOB_FILTER = of("invalid_job_filter")

                @JvmField val INVALID_JOB_ID = of("invalid_job_id")

                @JvmField val INVALID_LIST_ID = of("invalid_list_id")

                @JvmField val INVALID_NEWS_ID = of("invalid_news_id")

                @JvmField val INVALID_OUTPUT_OPTIONS = of("invalid_output_options")

                @JvmField val INVALID_PAYMENT_AMOUNT = of("invalid_payment_amount")

                @JvmField val INVALID_RANGE = of("invalid_range")

                @JvmField val INVALID_REPLY_OPTIONS = of("invalid_reply_options")

                @JvmField val INVALID_SPACE_ID = of("invalid_space_id")

                @JvmField val LIKES_UNAVAILABLE = of("likes_unavailable")

                @JvmField val LIST_NOT_FOUND = of("list_not_found")

                @JvmField val LOGIN_RATE_LIMITED = of("login_rate_limited")

                @JvmField val LOGIN_SERVICE_UNAVAILABLE = of("login_service_unavailable")

                @JvmField val MISSING_IDEMPOTENCY_KEY = of("missing_idempotency_key")

                @JvmField val MISSING_IDS = of("missing_ids")

                @JvmField val MISSING_URL = of("missing_url")

                @JvmField val NEWS_NOT_FOUND = of("news_not_found")

                @JvmField val NO_CACHED_STYLE = of("no_cached_style")

                @JvmField val PAGINATION_STALLED = of("pagination_stalled")

                @JvmField val PASSKEY_REQUIRED = of("passkey_required")

                @JvmField val RATE_LIMITED = of("rate_limited")

                @JvmField val READ_REQUEST_TIMEOUT = of("read_request_timeout")

                @JvmField val REPLAY_UNAVAILABLE = of("replay_unavailable")

                @JvmField val REPLIES_INCOMPLETE = of("replies_incomplete")

                @JvmField val RETWEETERS_INCOMPLETE = of("retweeters_incomplete")

                @JvmField val SEARCH_UNAVAILABLE = of("search_unavailable")

                @JvmField val SPACE_CANCELED = of("space_canceled")

                @JvmField val SPACE_NOT_ENDED = of("space_not_ended")

                @JvmField val SUPPORT_MEDIA_RATE_LIMIT = of("support_media_rate_limit")

                @JvmField val SUPPORT_REQUEST_RATE_LIMIT = of("support_request_rate_limit")

                @JvmField val TELEGRAM_UNAVAILABLE = of("telegram_unavailable")

                @JvmField val TOO_MANY_IDS = of("too_many_ids")

                @JvmField val TOO_MANY_STREAMS = of("too_many_streams")

                @JvmField val TOO_MANY_TWEETS = of("too_many_tweets")

                @JvmField val TOPUP_IN_PROGRESS = of("topup_in_progress")

                @JvmField val UNKNOWN_FIELD = of("unknown_field")

                @JvmField val UNSUPPORTED_MEDIA_COMBINATION = of("unsupported_media_combination")

                @JvmField val UNSUPPORTED_MEDIA_TYPE = of("unsupported_media_type")

                @JvmField val WEBHOOK_INACTIVE = of("webhook_inactive")

                @JvmField val WRITE_TRACKING_UNAVAILABLE = of("write_tracking_unavailable")

                @JvmField val X_WRITE_UNCONFIRMED = of("x_write_unconfirmed")

                @JvmField val X_ACCOUNT_FEATURE_REQUIRED = of("x_account_feature_required")

                @JvmField val X_ACCOUNT_PROTECTED = of("x_account_protected")

                @JvmField val X_ACCOUNT_SUSPENDED = of("x_account_suspended")

                @JvmField val X_API_RATE_LIMITED = of("x_api_rate_limited")

                @JvmField val X_API_UNAVAILABLE = of("x_api_unavailable")

                @JvmField val X_API_UNAUTHORIZED = of("x_api_unauthorized")

                @JvmField val X_AUTH_FAILURE = of("x_auth_failure")

                @JvmField val X_AUTOMATION_REFUSED = of("x_automation_refused")

                @JvmField val X_COMMUNITY_CREATION_CLOSED = of("x_community_creation_closed")

                @JvmField val X_COMMUNITY_NOT_JOINED = of("x_community_not_joined")

                @JvmField val X_COMMUNITY_NOT_SELECTABLE = of("x_community_not_selectable")

                @JvmField val X_COMMUNITY_POST_PUBLIC = of("x_community_post_public")

                @JvmField val X_COMMUNITY_POST_REMOVED = of("x_community_post_removed")

                @JvmField val X_CONTENT_TOO_LONG = of("x_content_too_long")

                @JvmField val X_DAILY_LIMIT = of("x_daily_limit")

                @JvmField val X_DM_NOT_ALLOWED = of("x_dm_not_allowed")

                @JvmField val X_DM_NOT_DELETED = of("x_dm_not_deleted")

                @JvmField val X_DM_NOT_SENT = of("x_dm_not_sent")

                @JvmField val X_DUPLICATE_ACTION = of("x_duplicate_action")

                @JvmField val X_LOGIN_AUTH_FAILED = of("x_login_auth_failed")

                @JvmField val X_LOGIN_CHALLENGE = of("x_login_challenge")

                @JvmField val X_LOGIN_DENIED = of("x_login_denied")

                @JvmField val X_LOGIN_FAILED = of("x_login_failed")

                @JvmField val X_LOGIN_PROXY_ERROR = of("x_login_proxy_error")

                @JvmField val X_LOGIN_RATE_LIMITED = of("x_login_rate_limited")

                @JvmField val X_LOGIN_SERVICE_UNAVAILABLE = of("x_login_service_unavailable")

                @JvmField val X_LOGIN_SUSPENDED = of("x_login_suspended")

                @JvmField val X_IMAGE_INVALID = of("x_image_invalid")

                @JvmField val X_MEDIA_REJECTED = of("x_media_rejected")

                @JvmField val X_POST_NOT_SENT = of("x_post_not_sent")

                @JvmField val X_RATE_LIMITED = of("x_rate_limited")

                @JvmField val X_REJECTED = of("x_rejected")

                @JvmField val X_REPLY_NOT_ALLOWED = of("x_reply_not_allowed")

                @JvmField val X_REPLY_TARGET_UNAVAILABLE = of("x_reply_target_unavailable")

                @JvmField val X_TARGET_NOT_FOUND = of("x_target_not_found")

                @JvmField val X_TRANSIENT_ERROR = of("x_transient_error")

                @JvmField val X_USER_LOOKUP_FAILED = of("x_user_lookup_failed")

                @JvmField val X_VIDEO_TOO_LARGE = of("x_video_too_large")

                @JvmField val X_WRITE_AMBIGUOUS = of("x_write_ambiguous")

                @JvmField val X_WRITE_FAILED = of("x_write_failed")

                @JvmStatic fun of(value: String) = LegacyErrorCode(JsonField.of(value))
            }

            /** An enum containing [LegacyErrorCode]'s known values. */
            enum class Known {
                INTERNAL_ERROR,
                ACCOUNT_ALREADY_CONNECTED,
                X_ACCOUNT_CONNECT_PERMISSION_REQUIRED,
                X_ACCOUNT_MISMATCH,
                ACCOUNT_NEEDS_REAUTH,
                ACCOUNT_NOT_FOUND,
                ACCOUNT_REQUIRED,
                ACCOUNT_RESTRICTED,
                API_KEY_EXPIRED,
                API_KEY_LIMIT_REACHED,
                API_KEY_PAUSED,
                API_KEY_BUDGET_REACHED,
                API_KEY_REVOKED,
                IP_NOT_ALLOWED,
                ARTICLE_NOT_FOUND,
                CLOSED,
                DM_NOT_PERMITTED,
                INVALID_FORMAT,
                INVALID_ID,
                INVALID_INPUT,
                INVALID_MEDIA_URL,
                INVALID_MESSAGE_ID,
                INVALID_PARAMS,
                INVALID_TOOL_TYPE,
                INVALID_TWEET_ID,
                INVALID_TWEET_URL,
                INVALID_USER_ID,
                INVALID_USER_IDS,
                INVALID_USERNAME,
                INVALID_JSON,
                INSUFFICIENT_CREDITS,
                INSUFFICIENT_SCOPE,
                JOB_NOT_FOUND,
                LOGIN_COOLDOWN,
                LOGIN_FAILED,
                MEDIA_DOWNLOAD_FAILED,
                MEDIA_NOT_UPLOADED,
                MEDIA_TOO_LARGE,
                MEDIA_UNAVAILABLE,
                MISSING_PARAMS,
                MISSING_QUERY,
                MONITOR_ALREADY_EXISTS,
                MONITOR_PROFILE_UNAVAILABLE,
                NO_MEDIA,
                NO_CREDITS,
                NO_SUBSCRIPTION,
                EXTRACTION_TERMINAL,
                NOT_FOUND,
                PAYMENT_FAILED,
                POST_UNAVAILABLE,
                PRICE_CHANGED,
                RATE_LIMIT_EXCEEDED,
                SERVICE_UNAVAILABLE,
                SESSION_REQUIRED,
                STYLE_NOT_FOUND,
                SUBSCRIPTION_INACTIVE,
                TWEET_NOT_FOUND,
                UNAUTHENTICATED,
                UNSUPPORTED_FIELD,
                USER_NOT_FOUND,
                BODY_TOO_LARGE,
                BOOKMARK_FOLDERS_UNAVAILABLE,
                BROADCAST_NOT_FOUND,
                CHECKOUT_UNAVAILABLE,
                CONNECTION_CHALLENGE_EXPIRED,
                CONNECTION_CHALLENGE_INACTIVE,
                CONTRIBUTOR_NOT_FOUND,
                COVERAGE_CURSOR_GONE,
                COVERAGE_CURSOR_UNAVAILABLE,
                CURSOR_ACCOUNT_UNAVAILABLE,
                DRAFT_NOT_FOUND,
                DRAW_TOO_LARGE,
                EXPIRED,
                FAVORITERS_UNAVAILABLE,
                FORBIDDEN,
                GUEST_WALLET_UNAVAILABLE,
                GUEST_WALLETS_DISABLED,
                GUEST_WALLETS_UNAVAILABLE,
                IDEMPOTENCY_CONFLICT,
                IDEMPOTENCY_IN_PROGRESS,
                IDEMPOTENCY_KEY_CONFLICT,
                INVALID_BROADCAST_ID,
                INVALID_COMMUNITY_ID,
                INVALID_COMMUNITY_TOPIC,
                INVALID_COMPLETE_REPLIES_REQUEST,
                INVALID_CONTRIBUTOR_ALIAS,
                INVALID_COVERAGE_CURSOR,
                INVALID_COVERAGE_REQUEST,
                INVALID_CURSOR,
                INVALID_IDEMPOTENCY_KEY,
                INVALID_JOB_FILTER,
                INVALID_JOB_ID,
                INVALID_LIST_ID,
                INVALID_NEWS_ID,
                INVALID_OUTPUT_OPTIONS,
                INVALID_PAYMENT_AMOUNT,
                INVALID_RANGE,
                INVALID_REPLY_OPTIONS,
                INVALID_SPACE_ID,
                LIKES_UNAVAILABLE,
                LIST_NOT_FOUND,
                LOGIN_RATE_LIMITED,
                LOGIN_SERVICE_UNAVAILABLE,
                MISSING_IDEMPOTENCY_KEY,
                MISSING_IDS,
                MISSING_URL,
                NEWS_NOT_FOUND,
                NO_CACHED_STYLE,
                PAGINATION_STALLED,
                PASSKEY_REQUIRED,
                RATE_LIMITED,
                READ_REQUEST_TIMEOUT,
                REPLAY_UNAVAILABLE,
                REPLIES_INCOMPLETE,
                RETWEETERS_INCOMPLETE,
                SEARCH_UNAVAILABLE,
                SPACE_CANCELED,
                SPACE_NOT_ENDED,
                SUPPORT_MEDIA_RATE_LIMIT,
                SUPPORT_REQUEST_RATE_LIMIT,
                TELEGRAM_UNAVAILABLE,
                TOO_MANY_IDS,
                TOO_MANY_STREAMS,
                TOO_MANY_TWEETS,
                TOPUP_IN_PROGRESS,
                UNKNOWN_FIELD,
                UNSUPPORTED_MEDIA_COMBINATION,
                UNSUPPORTED_MEDIA_TYPE,
                WEBHOOK_INACTIVE,
                WRITE_TRACKING_UNAVAILABLE,
                X_WRITE_UNCONFIRMED,
                X_ACCOUNT_FEATURE_REQUIRED,
                X_ACCOUNT_PROTECTED,
                X_ACCOUNT_SUSPENDED,
                X_API_RATE_LIMITED,
                X_API_UNAVAILABLE,
                X_API_UNAUTHORIZED,
                X_AUTH_FAILURE,
                X_AUTOMATION_REFUSED,
                X_COMMUNITY_CREATION_CLOSED,
                X_COMMUNITY_NOT_JOINED,
                X_COMMUNITY_NOT_SELECTABLE,
                X_COMMUNITY_POST_PUBLIC,
                X_COMMUNITY_POST_REMOVED,
                X_CONTENT_TOO_LONG,
                X_DAILY_LIMIT,
                X_DM_NOT_ALLOWED,
                X_DM_NOT_DELETED,
                X_DM_NOT_SENT,
                X_DUPLICATE_ACTION,
                X_LOGIN_AUTH_FAILED,
                X_LOGIN_CHALLENGE,
                X_LOGIN_DENIED,
                X_LOGIN_FAILED,
                X_LOGIN_PROXY_ERROR,
                X_LOGIN_RATE_LIMITED,
                X_LOGIN_SERVICE_UNAVAILABLE,
                X_LOGIN_SUSPENDED,
                X_IMAGE_INVALID,
                X_MEDIA_REJECTED,
                X_POST_NOT_SENT,
                X_RATE_LIMITED,
                X_REJECTED,
                X_REPLY_NOT_ALLOWED,
                X_REPLY_TARGET_UNAVAILABLE,
                X_TARGET_NOT_FOUND,
                X_TRANSIENT_ERROR,
                X_USER_LOOKUP_FAILED,
                X_VIDEO_TOO_LARGE,
                X_WRITE_AMBIGUOUS,
                X_WRITE_FAILED,
            }

            /**
             * An enum containing [LegacyErrorCode]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [LegacyErrorCode] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                INTERNAL_ERROR,
                ACCOUNT_ALREADY_CONNECTED,
                X_ACCOUNT_CONNECT_PERMISSION_REQUIRED,
                X_ACCOUNT_MISMATCH,
                ACCOUNT_NEEDS_REAUTH,
                ACCOUNT_NOT_FOUND,
                ACCOUNT_REQUIRED,
                ACCOUNT_RESTRICTED,
                API_KEY_EXPIRED,
                API_KEY_LIMIT_REACHED,
                API_KEY_PAUSED,
                API_KEY_BUDGET_REACHED,
                API_KEY_REVOKED,
                IP_NOT_ALLOWED,
                ARTICLE_NOT_FOUND,
                CLOSED,
                DM_NOT_PERMITTED,
                INVALID_FORMAT,
                INVALID_ID,
                INVALID_INPUT,
                INVALID_MEDIA_URL,
                INVALID_MESSAGE_ID,
                INVALID_PARAMS,
                INVALID_TOOL_TYPE,
                INVALID_TWEET_ID,
                INVALID_TWEET_URL,
                INVALID_USER_ID,
                INVALID_USER_IDS,
                INVALID_USERNAME,
                INVALID_JSON,
                INSUFFICIENT_CREDITS,
                INSUFFICIENT_SCOPE,
                JOB_NOT_FOUND,
                LOGIN_COOLDOWN,
                LOGIN_FAILED,
                MEDIA_DOWNLOAD_FAILED,
                MEDIA_NOT_UPLOADED,
                MEDIA_TOO_LARGE,
                MEDIA_UNAVAILABLE,
                MISSING_PARAMS,
                MISSING_QUERY,
                MONITOR_ALREADY_EXISTS,
                MONITOR_PROFILE_UNAVAILABLE,
                NO_MEDIA,
                NO_CREDITS,
                NO_SUBSCRIPTION,
                EXTRACTION_TERMINAL,
                NOT_FOUND,
                PAYMENT_FAILED,
                POST_UNAVAILABLE,
                PRICE_CHANGED,
                RATE_LIMIT_EXCEEDED,
                SERVICE_UNAVAILABLE,
                SESSION_REQUIRED,
                STYLE_NOT_FOUND,
                SUBSCRIPTION_INACTIVE,
                TWEET_NOT_FOUND,
                UNAUTHENTICATED,
                UNSUPPORTED_FIELD,
                USER_NOT_FOUND,
                BODY_TOO_LARGE,
                BOOKMARK_FOLDERS_UNAVAILABLE,
                BROADCAST_NOT_FOUND,
                CHECKOUT_UNAVAILABLE,
                CONNECTION_CHALLENGE_EXPIRED,
                CONNECTION_CHALLENGE_INACTIVE,
                CONTRIBUTOR_NOT_FOUND,
                COVERAGE_CURSOR_GONE,
                COVERAGE_CURSOR_UNAVAILABLE,
                CURSOR_ACCOUNT_UNAVAILABLE,
                DRAFT_NOT_FOUND,
                DRAW_TOO_LARGE,
                EXPIRED,
                FAVORITERS_UNAVAILABLE,
                FORBIDDEN,
                GUEST_WALLET_UNAVAILABLE,
                GUEST_WALLETS_DISABLED,
                GUEST_WALLETS_UNAVAILABLE,
                IDEMPOTENCY_CONFLICT,
                IDEMPOTENCY_IN_PROGRESS,
                IDEMPOTENCY_KEY_CONFLICT,
                INVALID_BROADCAST_ID,
                INVALID_COMMUNITY_ID,
                INVALID_COMMUNITY_TOPIC,
                INVALID_COMPLETE_REPLIES_REQUEST,
                INVALID_CONTRIBUTOR_ALIAS,
                INVALID_COVERAGE_CURSOR,
                INVALID_COVERAGE_REQUEST,
                INVALID_CURSOR,
                INVALID_IDEMPOTENCY_KEY,
                INVALID_JOB_FILTER,
                INVALID_JOB_ID,
                INVALID_LIST_ID,
                INVALID_NEWS_ID,
                INVALID_OUTPUT_OPTIONS,
                INVALID_PAYMENT_AMOUNT,
                INVALID_RANGE,
                INVALID_REPLY_OPTIONS,
                INVALID_SPACE_ID,
                LIKES_UNAVAILABLE,
                LIST_NOT_FOUND,
                LOGIN_RATE_LIMITED,
                LOGIN_SERVICE_UNAVAILABLE,
                MISSING_IDEMPOTENCY_KEY,
                MISSING_IDS,
                MISSING_URL,
                NEWS_NOT_FOUND,
                NO_CACHED_STYLE,
                PAGINATION_STALLED,
                PASSKEY_REQUIRED,
                RATE_LIMITED,
                READ_REQUEST_TIMEOUT,
                REPLAY_UNAVAILABLE,
                REPLIES_INCOMPLETE,
                RETWEETERS_INCOMPLETE,
                SEARCH_UNAVAILABLE,
                SPACE_CANCELED,
                SPACE_NOT_ENDED,
                SUPPORT_MEDIA_RATE_LIMIT,
                SUPPORT_REQUEST_RATE_LIMIT,
                TELEGRAM_UNAVAILABLE,
                TOO_MANY_IDS,
                TOO_MANY_STREAMS,
                TOO_MANY_TWEETS,
                TOPUP_IN_PROGRESS,
                UNKNOWN_FIELD,
                UNSUPPORTED_MEDIA_COMBINATION,
                UNSUPPORTED_MEDIA_TYPE,
                WEBHOOK_INACTIVE,
                WRITE_TRACKING_UNAVAILABLE,
                X_WRITE_UNCONFIRMED,
                X_ACCOUNT_FEATURE_REQUIRED,
                X_ACCOUNT_PROTECTED,
                X_ACCOUNT_SUSPENDED,
                X_API_RATE_LIMITED,
                X_API_UNAVAILABLE,
                X_API_UNAUTHORIZED,
                X_AUTH_FAILURE,
                X_AUTOMATION_REFUSED,
                X_COMMUNITY_CREATION_CLOSED,
                X_COMMUNITY_NOT_JOINED,
                X_COMMUNITY_NOT_SELECTABLE,
                X_COMMUNITY_POST_PUBLIC,
                X_COMMUNITY_POST_REMOVED,
                X_CONTENT_TOO_LONG,
                X_DAILY_LIMIT,
                X_DM_NOT_ALLOWED,
                X_DM_NOT_DELETED,
                X_DM_NOT_SENT,
                X_DUPLICATE_ACTION,
                X_LOGIN_AUTH_FAILED,
                X_LOGIN_CHALLENGE,
                X_LOGIN_DENIED,
                X_LOGIN_FAILED,
                X_LOGIN_PROXY_ERROR,
                X_LOGIN_RATE_LIMITED,
                X_LOGIN_SERVICE_UNAVAILABLE,
                X_LOGIN_SUSPENDED,
                X_IMAGE_INVALID,
                X_MEDIA_REJECTED,
                X_POST_NOT_SENT,
                X_RATE_LIMITED,
                X_REJECTED,
                X_REPLY_NOT_ALLOWED,
                X_REPLY_TARGET_UNAVAILABLE,
                X_TARGET_NOT_FOUND,
                X_TRANSIENT_ERROR,
                X_USER_LOOKUP_FAILED,
                X_VIDEO_TOO_LARGE,
                X_WRITE_AMBIGUOUS,
                X_WRITE_FAILED,
                /**
                 * An enum member indicating that [LegacyErrorCode] was instantiated with an unknown
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
                    INTERNAL_ERROR -> Value.INTERNAL_ERROR
                    ACCOUNT_ALREADY_CONNECTED -> Value.ACCOUNT_ALREADY_CONNECTED
                    X_ACCOUNT_CONNECT_PERMISSION_REQUIRED ->
                        Value.X_ACCOUNT_CONNECT_PERMISSION_REQUIRED
                    X_ACCOUNT_MISMATCH -> Value.X_ACCOUNT_MISMATCH
                    ACCOUNT_NEEDS_REAUTH -> Value.ACCOUNT_NEEDS_REAUTH
                    ACCOUNT_NOT_FOUND -> Value.ACCOUNT_NOT_FOUND
                    ACCOUNT_REQUIRED -> Value.ACCOUNT_REQUIRED
                    ACCOUNT_RESTRICTED -> Value.ACCOUNT_RESTRICTED
                    API_KEY_EXPIRED -> Value.API_KEY_EXPIRED
                    API_KEY_LIMIT_REACHED -> Value.API_KEY_LIMIT_REACHED
                    API_KEY_PAUSED -> Value.API_KEY_PAUSED
                    API_KEY_BUDGET_REACHED -> Value.API_KEY_BUDGET_REACHED
                    API_KEY_REVOKED -> Value.API_KEY_REVOKED
                    IP_NOT_ALLOWED -> Value.IP_NOT_ALLOWED
                    ARTICLE_NOT_FOUND -> Value.ARTICLE_NOT_FOUND
                    CLOSED -> Value.CLOSED
                    DM_NOT_PERMITTED -> Value.DM_NOT_PERMITTED
                    INVALID_FORMAT -> Value.INVALID_FORMAT
                    INVALID_ID -> Value.INVALID_ID
                    INVALID_INPUT -> Value.INVALID_INPUT
                    INVALID_MEDIA_URL -> Value.INVALID_MEDIA_URL
                    INVALID_MESSAGE_ID -> Value.INVALID_MESSAGE_ID
                    INVALID_PARAMS -> Value.INVALID_PARAMS
                    INVALID_TOOL_TYPE -> Value.INVALID_TOOL_TYPE
                    INVALID_TWEET_ID -> Value.INVALID_TWEET_ID
                    INVALID_TWEET_URL -> Value.INVALID_TWEET_URL
                    INVALID_USER_ID -> Value.INVALID_USER_ID
                    INVALID_USER_IDS -> Value.INVALID_USER_IDS
                    INVALID_USERNAME -> Value.INVALID_USERNAME
                    INVALID_JSON -> Value.INVALID_JSON
                    INSUFFICIENT_CREDITS -> Value.INSUFFICIENT_CREDITS
                    INSUFFICIENT_SCOPE -> Value.INSUFFICIENT_SCOPE
                    JOB_NOT_FOUND -> Value.JOB_NOT_FOUND
                    LOGIN_COOLDOWN -> Value.LOGIN_COOLDOWN
                    LOGIN_FAILED -> Value.LOGIN_FAILED
                    MEDIA_DOWNLOAD_FAILED -> Value.MEDIA_DOWNLOAD_FAILED
                    MEDIA_NOT_UPLOADED -> Value.MEDIA_NOT_UPLOADED
                    MEDIA_TOO_LARGE -> Value.MEDIA_TOO_LARGE
                    MEDIA_UNAVAILABLE -> Value.MEDIA_UNAVAILABLE
                    MISSING_PARAMS -> Value.MISSING_PARAMS
                    MISSING_QUERY -> Value.MISSING_QUERY
                    MONITOR_ALREADY_EXISTS -> Value.MONITOR_ALREADY_EXISTS
                    MONITOR_PROFILE_UNAVAILABLE -> Value.MONITOR_PROFILE_UNAVAILABLE
                    NO_MEDIA -> Value.NO_MEDIA
                    NO_CREDITS -> Value.NO_CREDITS
                    NO_SUBSCRIPTION -> Value.NO_SUBSCRIPTION
                    EXTRACTION_TERMINAL -> Value.EXTRACTION_TERMINAL
                    NOT_FOUND -> Value.NOT_FOUND
                    PAYMENT_FAILED -> Value.PAYMENT_FAILED
                    POST_UNAVAILABLE -> Value.POST_UNAVAILABLE
                    PRICE_CHANGED -> Value.PRICE_CHANGED
                    RATE_LIMIT_EXCEEDED -> Value.RATE_LIMIT_EXCEEDED
                    SERVICE_UNAVAILABLE -> Value.SERVICE_UNAVAILABLE
                    SESSION_REQUIRED -> Value.SESSION_REQUIRED
                    STYLE_NOT_FOUND -> Value.STYLE_NOT_FOUND
                    SUBSCRIPTION_INACTIVE -> Value.SUBSCRIPTION_INACTIVE
                    TWEET_NOT_FOUND -> Value.TWEET_NOT_FOUND
                    UNAUTHENTICATED -> Value.UNAUTHENTICATED
                    UNSUPPORTED_FIELD -> Value.UNSUPPORTED_FIELD
                    USER_NOT_FOUND -> Value.USER_NOT_FOUND
                    BODY_TOO_LARGE -> Value.BODY_TOO_LARGE
                    BOOKMARK_FOLDERS_UNAVAILABLE -> Value.BOOKMARK_FOLDERS_UNAVAILABLE
                    BROADCAST_NOT_FOUND -> Value.BROADCAST_NOT_FOUND
                    CHECKOUT_UNAVAILABLE -> Value.CHECKOUT_UNAVAILABLE
                    CONNECTION_CHALLENGE_EXPIRED -> Value.CONNECTION_CHALLENGE_EXPIRED
                    CONNECTION_CHALLENGE_INACTIVE -> Value.CONNECTION_CHALLENGE_INACTIVE
                    CONTRIBUTOR_NOT_FOUND -> Value.CONTRIBUTOR_NOT_FOUND
                    COVERAGE_CURSOR_GONE -> Value.COVERAGE_CURSOR_GONE
                    COVERAGE_CURSOR_UNAVAILABLE -> Value.COVERAGE_CURSOR_UNAVAILABLE
                    CURSOR_ACCOUNT_UNAVAILABLE -> Value.CURSOR_ACCOUNT_UNAVAILABLE
                    DRAFT_NOT_FOUND -> Value.DRAFT_NOT_FOUND
                    DRAW_TOO_LARGE -> Value.DRAW_TOO_LARGE
                    EXPIRED -> Value.EXPIRED
                    FAVORITERS_UNAVAILABLE -> Value.FAVORITERS_UNAVAILABLE
                    FORBIDDEN -> Value.FORBIDDEN
                    GUEST_WALLET_UNAVAILABLE -> Value.GUEST_WALLET_UNAVAILABLE
                    GUEST_WALLETS_DISABLED -> Value.GUEST_WALLETS_DISABLED
                    GUEST_WALLETS_UNAVAILABLE -> Value.GUEST_WALLETS_UNAVAILABLE
                    IDEMPOTENCY_CONFLICT -> Value.IDEMPOTENCY_CONFLICT
                    IDEMPOTENCY_IN_PROGRESS -> Value.IDEMPOTENCY_IN_PROGRESS
                    IDEMPOTENCY_KEY_CONFLICT -> Value.IDEMPOTENCY_KEY_CONFLICT
                    INVALID_BROADCAST_ID -> Value.INVALID_BROADCAST_ID
                    INVALID_COMMUNITY_ID -> Value.INVALID_COMMUNITY_ID
                    INVALID_COMMUNITY_TOPIC -> Value.INVALID_COMMUNITY_TOPIC
                    INVALID_COMPLETE_REPLIES_REQUEST -> Value.INVALID_COMPLETE_REPLIES_REQUEST
                    INVALID_CONTRIBUTOR_ALIAS -> Value.INVALID_CONTRIBUTOR_ALIAS
                    INVALID_COVERAGE_CURSOR -> Value.INVALID_COVERAGE_CURSOR
                    INVALID_COVERAGE_REQUEST -> Value.INVALID_COVERAGE_REQUEST
                    INVALID_CURSOR -> Value.INVALID_CURSOR
                    INVALID_IDEMPOTENCY_KEY -> Value.INVALID_IDEMPOTENCY_KEY
                    INVALID_JOB_FILTER -> Value.INVALID_JOB_FILTER
                    INVALID_JOB_ID -> Value.INVALID_JOB_ID
                    INVALID_LIST_ID -> Value.INVALID_LIST_ID
                    INVALID_NEWS_ID -> Value.INVALID_NEWS_ID
                    INVALID_OUTPUT_OPTIONS -> Value.INVALID_OUTPUT_OPTIONS
                    INVALID_PAYMENT_AMOUNT -> Value.INVALID_PAYMENT_AMOUNT
                    INVALID_RANGE -> Value.INVALID_RANGE
                    INVALID_REPLY_OPTIONS -> Value.INVALID_REPLY_OPTIONS
                    INVALID_SPACE_ID -> Value.INVALID_SPACE_ID
                    LIKES_UNAVAILABLE -> Value.LIKES_UNAVAILABLE
                    LIST_NOT_FOUND -> Value.LIST_NOT_FOUND
                    LOGIN_RATE_LIMITED -> Value.LOGIN_RATE_LIMITED
                    LOGIN_SERVICE_UNAVAILABLE -> Value.LOGIN_SERVICE_UNAVAILABLE
                    MISSING_IDEMPOTENCY_KEY -> Value.MISSING_IDEMPOTENCY_KEY
                    MISSING_IDS -> Value.MISSING_IDS
                    MISSING_URL -> Value.MISSING_URL
                    NEWS_NOT_FOUND -> Value.NEWS_NOT_FOUND
                    NO_CACHED_STYLE -> Value.NO_CACHED_STYLE
                    PAGINATION_STALLED -> Value.PAGINATION_STALLED
                    PASSKEY_REQUIRED -> Value.PASSKEY_REQUIRED
                    RATE_LIMITED -> Value.RATE_LIMITED
                    READ_REQUEST_TIMEOUT -> Value.READ_REQUEST_TIMEOUT
                    REPLAY_UNAVAILABLE -> Value.REPLAY_UNAVAILABLE
                    REPLIES_INCOMPLETE -> Value.REPLIES_INCOMPLETE
                    RETWEETERS_INCOMPLETE -> Value.RETWEETERS_INCOMPLETE
                    SEARCH_UNAVAILABLE -> Value.SEARCH_UNAVAILABLE
                    SPACE_CANCELED -> Value.SPACE_CANCELED
                    SPACE_NOT_ENDED -> Value.SPACE_NOT_ENDED
                    SUPPORT_MEDIA_RATE_LIMIT -> Value.SUPPORT_MEDIA_RATE_LIMIT
                    SUPPORT_REQUEST_RATE_LIMIT -> Value.SUPPORT_REQUEST_RATE_LIMIT
                    TELEGRAM_UNAVAILABLE -> Value.TELEGRAM_UNAVAILABLE
                    TOO_MANY_IDS -> Value.TOO_MANY_IDS
                    TOO_MANY_STREAMS -> Value.TOO_MANY_STREAMS
                    TOO_MANY_TWEETS -> Value.TOO_MANY_TWEETS
                    TOPUP_IN_PROGRESS -> Value.TOPUP_IN_PROGRESS
                    UNKNOWN_FIELD -> Value.UNKNOWN_FIELD
                    UNSUPPORTED_MEDIA_COMBINATION -> Value.UNSUPPORTED_MEDIA_COMBINATION
                    UNSUPPORTED_MEDIA_TYPE -> Value.UNSUPPORTED_MEDIA_TYPE
                    WEBHOOK_INACTIVE -> Value.WEBHOOK_INACTIVE
                    WRITE_TRACKING_UNAVAILABLE -> Value.WRITE_TRACKING_UNAVAILABLE
                    X_WRITE_UNCONFIRMED -> Value.X_WRITE_UNCONFIRMED
                    X_ACCOUNT_FEATURE_REQUIRED -> Value.X_ACCOUNT_FEATURE_REQUIRED
                    X_ACCOUNT_PROTECTED -> Value.X_ACCOUNT_PROTECTED
                    X_ACCOUNT_SUSPENDED -> Value.X_ACCOUNT_SUSPENDED
                    X_API_RATE_LIMITED -> Value.X_API_RATE_LIMITED
                    X_API_UNAVAILABLE -> Value.X_API_UNAVAILABLE
                    X_API_UNAUTHORIZED -> Value.X_API_UNAUTHORIZED
                    X_AUTH_FAILURE -> Value.X_AUTH_FAILURE
                    X_AUTOMATION_REFUSED -> Value.X_AUTOMATION_REFUSED
                    X_COMMUNITY_CREATION_CLOSED -> Value.X_COMMUNITY_CREATION_CLOSED
                    X_COMMUNITY_NOT_JOINED -> Value.X_COMMUNITY_NOT_JOINED
                    X_COMMUNITY_NOT_SELECTABLE -> Value.X_COMMUNITY_NOT_SELECTABLE
                    X_COMMUNITY_POST_PUBLIC -> Value.X_COMMUNITY_POST_PUBLIC
                    X_COMMUNITY_POST_REMOVED -> Value.X_COMMUNITY_POST_REMOVED
                    X_CONTENT_TOO_LONG -> Value.X_CONTENT_TOO_LONG
                    X_DAILY_LIMIT -> Value.X_DAILY_LIMIT
                    X_DM_NOT_ALLOWED -> Value.X_DM_NOT_ALLOWED
                    X_DM_NOT_DELETED -> Value.X_DM_NOT_DELETED
                    X_DM_NOT_SENT -> Value.X_DM_NOT_SENT
                    X_DUPLICATE_ACTION -> Value.X_DUPLICATE_ACTION
                    X_LOGIN_AUTH_FAILED -> Value.X_LOGIN_AUTH_FAILED
                    X_LOGIN_CHALLENGE -> Value.X_LOGIN_CHALLENGE
                    X_LOGIN_DENIED -> Value.X_LOGIN_DENIED
                    X_LOGIN_FAILED -> Value.X_LOGIN_FAILED
                    X_LOGIN_PROXY_ERROR -> Value.X_LOGIN_PROXY_ERROR
                    X_LOGIN_RATE_LIMITED -> Value.X_LOGIN_RATE_LIMITED
                    X_LOGIN_SERVICE_UNAVAILABLE -> Value.X_LOGIN_SERVICE_UNAVAILABLE
                    X_LOGIN_SUSPENDED -> Value.X_LOGIN_SUSPENDED
                    X_IMAGE_INVALID -> Value.X_IMAGE_INVALID
                    X_MEDIA_REJECTED -> Value.X_MEDIA_REJECTED
                    X_POST_NOT_SENT -> Value.X_POST_NOT_SENT
                    X_RATE_LIMITED -> Value.X_RATE_LIMITED
                    X_REJECTED -> Value.X_REJECTED
                    X_REPLY_NOT_ALLOWED -> Value.X_REPLY_NOT_ALLOWED
                    X_REPLY_TARGET_UNAVAILABLE -> Value.X_REPLY_TARGET_UNAVAILABLE
                    X_TARGET_NOT_FOUND -> Value.X_TARGET_NOT_FOUND
                    X_TRANSIENT_ERROR -> Value.X_TRANSIENT_ERROR
                    X_USER_LOOKUP_FAILED -> Value.X_USER_LOOKUP_FAILED
                    X_VIDEO_TOO_LARGE -> Value.X_VIDEO_TOO_LARGE
                    X_WRITE_AMBIGUOUS -> Value.X_WRITE_AMBIGUOUS
                    X_WRITE_FAILED -> Value.X_WRITE_FAILED
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
                    INTERNAL_ERROR -> Known.INTERNAL_ERROR
                    ACCOUNT_ALREADY_CONNECTED -> Known.ACCOUNT_ALREADY_CONNECTED
                    X_ACCOUNT_CONNECT_PERMISSION_REQUIRED ->
                        Known.X_ACCOUNT_CONNECT_PERMISSION_REQUIRED
                    X_ACCOUNT_MISMATCH -> Known.X_ACCOUNT_MISMATCH
                    ACCOUNT_NEEDS_REAUTH -> Known.ACCOUNT_NEEDS_REAUTH
                    ACCOUNT_NOT_FOUND -> Known.ACCOUNT_NOT_FOUND
                    ACCOUNT_REQUIRED -> Known.ACCOUNT_REQUIRED
                    ACCOUNT_RESTRICTED -> Known.ACCOUNT_RESTRICTED
                    API_KEY_EXPIRED -> Known.API_KEY_EXPIRED
                    API_KEY_LIMIT_REACHED -> Known.API_KEY_LIMIT_REACHED
                    API_KEY_PAUSED -> Known.API_KEY_PAUSED
                    API_KEY_BUDGET_REACHED -> Known.API_KEY_BUDGET_REACHED
                    API_KEY_REVOKED -> Known.API_KEY_REVOKED
                    IP_NOT_ALLOWED -> Known.IP_NOT_ALLOWED
                    ARTICLE_NOT_FOUND -> Known.ARTICLE_NOT_FOUND
                    CLOSED -> Known.CLOSED
                    DM_NOT_PERMITTED -> Known.DM_NOT_PERMITTED
                    INVALID_FORMAT -> Known.INVALID_FORMAT
                    INVALID_ID -> Known.INVALID_ID
                    INVALID_INPUT -> Known.INVALID_INPUT
                    INVALID_MEDIA_URL -> Known.INVALID_MEDIA_URL
                    INVALID_MESSAGE_ID -> Known.INVALID_MESSAGE_ID
                    INVALID_PARAMS -> Known.INVALID_PARAMS
                    INVALID_TOOL_TYPE -> Known.INVALID_TOOL_TYPE
                    INVALID_TWEET_ID -> Known.INVALID_TWEET_ID
                    INVALID_TWEET_URL -> Known.INVALID_TWEET_URL
                    INVALID_USER_ID -> Known.INVALID_USER_ID
                    INVALID_USER_IDS -> Known.INVALID_USER_IDS
                    INVALID_USERNAME -> Known.INVALID_USERNAME
                    INVALID_JSON -> Known.INVALID_JSON
                    INSUFFICIENT_CREDITS -> Known.INSUFFICIENT_CREDITS
                    INSUFFICIENT_SCOPE -> Known.INSUFFICIENT_SCOPE
                    JOB_NOT_FOUND -> Known.JOB_NOT_FOUND
                    LOGIN_COOLDOWN -> Known.LOGIN_COOLDOWN
                    LOGIN_FAILED -> Known.LOGIN_FAILED
                    MEDIA_DOWNLOAD_FAILED -> Known.MEDIA_DOWNLOAD_FAILED
                    MEDIA_NOT_UPLOADED -> Known.MEDIA_NOT_UPLOADED
                    MEDIA_TOO_LARGE -> Known.MEDIA_TOO_LARGE
                    MEDIA_UNAVAILABLE -> Known.MEDIA_UNAVAILABLE
                    MISSING_PARAMS -> Known.MISSING_PARAMS
                    MISSING_QUERY -> Known.MISSING_QUERY
                    MONITOR_ALREADY_EXISTS -> Known.MONITOR_ALREADY_EXISTS
                    MONITOR_PROFILE_UNAVAILABLE -> Known.MONITOR_PROFILE_UNAVAILABLE
                    NO_MEDIA -> Known.NO_MEDIA
                    NO_CREDITS -> Known.NO_CREDITS
                    NO_SUBSCRIPTION -> Known.NO_SUBSCRIPTION
                    EXTRACTION_TERMINAL -> Known.EXTRACTION_TERMINAL
                    NOT_FOUND -> Known.NOT_FOUND
                    PAYMENT_FAILED -> Known.PAYMENT_FAILED
                    POST_UNAVAILABLE -> Known.POST_UNAVAILABLE
                    PRICE_CHANGED -> Known.PRICE_CHANGED
                    RATE_LIMIT_EXCEEDED -> Known.RATE_LIMIT_EXCEEDED
                    SERVICE_UNAVAILABLE -> Known.SERVICE_UNAVAILABLE
                    SESSION_REQUIRED -> Known.SESSION_REQUIRED
                    STYLE_NOT_FOUND -> Known.STYLE_NOT_FOUND
                    SUBSCRIPTION_INACTIVE -> Known.SUBSCRIPTION_INACTIVE
                    TWEET_NOT_FOUND -> Known.TWEET_NOT_FOUND
                    UNAUTHENTICATED -> Known.UNAUTHENTICATED
                    UNSUPPORTED_FIELD -> Known.UNSUPPORTED_FIELD
                    USER_NOT_FOUND -> Known.USER_NOT_FOUND
                    BODY_TOO_LARGE -> Known.BODY_TOO_LARGE
                    BOOKMARK_FOLDERS_UNAVAILABLE -> Known.BOOKMARK_FOLDERS_UNAVAILABLE
                    BROADCAST_NOT_FOUND -> Known.BROADCAST_NOT_FOUND
                    CHECKOUT_UNAVAILABLE -> Known.CHECKOUT_UNAVAILABLE
                    CONNECTION_CHALLENGE_EXPIRED -> Known.CONNECTION_CHALLENGE_EXPIRED
                    CONNECTION_CHALLENGE_INACTIVE -> Known.CONNECTION_CHALLENGE_INACTIVE
                    CONTRIBUTOR_NOT_FOUND -> Known.CONTRIBUTOR_NOT_FOUND
                    COVERAGE_CURSOR_GONE -> Known.COVERAGE_CURSOR_GONE
                    COVERAGE_CURSOR_UNAVAILABLE -> Known.COVERAGE_CURSOR_UNAVAILABLE
                    CURSOR_ACCOUNT_UNAVAILABLE -> Known.CURSOR_ACCOUNT_UNAVAILABLE
                    DRAFT_NOT_FOUND -> Known.DRAFT_NOT_FOUND
                    DRAW_TOO_LARGE -> Known.DRAW_TOO_LARGE
                    EXPIRED -> Known.EXPIRED
                    FAVORITERS_UNAVAILABLE -> Known.FAVORITERS_UNAVAILABLE
                    FORBIDDEN -> Known.FORBIDDEN
                    GUEST_WALLET_UNAVAILABLE -> Known.GUEST_WALLET_UNAVAILABLE
                    GUEST_WALLETS_DISABLED -> Known.GUEST_WALLETS_DISABLED
                    GUEST_WALLETS_UNAVAILABLE -> Known.GUEST_WALLETS_UNAVAILABLE
                    IDEMPOTENCY_CONFLICT -> Known.IDEMPOTENCY_CONFLICT
                    IDEMPOTENCY_IN_PROGRESS -> Known.IDEMPOTENCY_IN_PROGRESS
                    IDEMPOTENCY_KEY_CONFLICT -> Known.IDEMPOTENCY_KEY_CONFLICT
                    INVALID_BROADCAST_ID -> Known.INVALID_BROADCAST_ID
                    INVALID_COMMUNITY_ID -> Known.INVALID_COMMUNITY_ID
                    INVALID_COMMUNITY_TOPIC -> Known.INVALID_COMMUNITY_TOPIC
                    INVALID_COMPLETE_REPLIES_REQUEST -> Known.INVALID_COMPLETE_REPLIES_REQUEST
                    INVALID_CONTRIBUTOR_ALIAS -> Known.INVALID_CONTRIBUTOR_ALIAS
                    INVALID_COVERAGE_CURSOR -> Known.INVALID_COVERAGE_CURSOR
                    INVALID_COVERAGE_REQUEST -> Known.INVALID_COVERAGE_REQUEST
                    INVALID_CURSOR -> Known.INVALID_CURSOR
                    INVALID_IDEMPOTENCY_KEY -> Known.INVALID_IDEMPOTENCY_KEY
                    INVALID_JOB_FILTER -> Known.INVALID_JOB_FILTER
                    INVALID_JOB_ID -> Known.INVALID_JOB_ID
                    INVALID_LIST_ID -> Known.INVALID_LIST_ID
                    INVALID_NEWS_ID -> Known.INVALID_NEWS_ID
                    INVALID_OUTPUT_OPTIONS -> Known.INVALID_OUTPUT_OPTIONS
                    INVALID_PAYMENT_AMOUNT -> Known.INVALID_PAYMENT_AMOUNT
                    INVALID_RANGE -> Known.INVALID_RANGE
                    INVALID_REPLY_OPTIONS -> Known.INVALID_REPLY_OPTIONS
                    INVALID_SPACE_ID -> Known.INVALID_SPACE_ID
                    LIKES_UNAVAILABLE -> Known.LIKES_UNAVAILABLE
                    LIST_NOT_FOUND -> Known.LIST_NOT_FOUND
                    LOGIN_RATE_LIMITED -> Known.LOGIN_RATE_LIMITED
                    LOGIN_SERVICE_UNAVAILABLE -> Known.LOGIN_SERVICE_UNAVAILABLE
                    MISSING_IDEMPOTENCY_KEY -> Known.MISSING_IDEMPOTENCY_KEY
                    MISSING_IDS -> Known.MISSING_IDS
                    MISSING_URL -> Known.MISSING_URL
                    NEWS_NOT_FOUND -> Known.NEWS_NOT_FOUND
                    NO_CACHED_STYLE -> Known.NO_CACHED_STYLE
                    PAGINATION_STALLED -> Known.PAGINATION_STALLED
                    PASSKEY_REQUIRED -> Known.PASSKEY_REQUIRED
                    RATE_LIMITED -> Known.RATE_LIMITED
                    READ_REQUEST_TIMEOUT -> Known.READ_REQUEST_TIMEOUT
                    REPLAY_UNAVAILABLE -> Known.REPLAY_UNAVAILABLE
                    REPLIES_INCOMPLETE -> Known.REPLIES_INCOMPLETE
                    RETWEETERS_INCOMPLETE -> Known.RETWEETERS_INCOMPLETE
                    SEARCH_UNAVAILABLE -> Known.SEARCH_UNAVAILABLE
                    SPACE_CANCELED -> Known.SPACE_CANCELED
                    SPACE_NOT_ENDED -> Known.SPACE_NOT_ENDED
                    SUPPORT_MEDIA_RATE_LIMIT -> Known.SUPPORT_MEDIA_RATE_LIMIT
                    SUPPORT_REQUEST_RATE_LIMIT -> Known.SUPPORT_REQUEST_RATE_LIMIT
                    TELEGRAM_UNAVAILABLE -> Known.TELEGRAM_UNAVAILABLE
                    TOO_MANY_IDS -> Known.TOO_MANY_IDS
                    TOO_MANY_STREAMS -> Known.TOO_MANY_STREAMS
                    TOO_MANY_TWEETS -> Known.TOO_MANY_TWEETS
                    TOPUP_IN_PROGRESS -> Known.TOPUP_IN_PROGRESS
                    UNKNOWN_FIELD -> Known.UNKNOWN_FIELD
                    UNSUPPORTED_MEDIA_COMBINATION -> Known.UNSUPPORTED_MEDIA_COMBINATION
                    UNSUPPORTED_MEDIA_TYPE -> Known.UNSUPPORTED_MEDIA_TYPE
                    WEBHOOK_INACTIVE -> Known.WEBHOOK_INACTIVE
                    WRITE_TRACKING_UNAVAILABLE -> Known.WRITE_TRACKING_UNAVAILABLE
                    X_WRITE_UNCONFIRMED -> Known.X_WRITE_UNCONFIRMED
                    X_ACCOUNT_FEATURE_REQUIRED -> Known.X_ACCOUNT_FEATURE_REQUIRED
                    X_ACCOUNT_PROTECTED -> Known.X_ACCOUNT_PROTECTED
                    X_ACCOUNT_SUSPENDED -> Known.X_ACCOUNT_SUSPENDED
                    X_API_RATE_LIMITED -> Known.X_API_RATE_LIMITED
                    X_API_UNAVAILABLE -> Known.X_API_UNAVAILABLE
                    X_API_UNAUTHORIZED -> Known.X_API_UNAUTHORIZED
                    X_AUTH_FAILURE -> Known.X_AUTH_FAILURE
                    X_AUTOMATION_REFUSED -> Known.X_AUTOMATION_REFUSED
                    X_COMMUNITY_CREATION_CLOSED -> Known.X_COMMUNITY_CREATION_CLOSED
                    X_COMMUNITY_NOT_JOINED -> Known.X_COMMUNITY_NOT_JOINED
                    X_COMMUNITY_NOT_SELECTABLE -> Known.X_COMMUNITY_NOT_SELECTABLE
                    X_COMMUNITY_POST_PUBLIC -> Known.X_COMMUNITY_POST_PUBLIC
                    X_COMMUNITY_POST_REMOVED -> Known.X_COMMUNITY_POST_REMOVED
                    X_CONTENT_TOO_LONG -> Known.X_CONTENT_TOO_LONG
                    X_DAILY_LIMIT -> Known.X_DAILY_LIMIT
                    X_DM_NOT_ALLOWED -> Known.X_DM_NOT_ALLOWED
                    X_DM_NOT_DELETED -> Known.X_DM_NOT_DELETED
                    X_DM_NOT_SENT -> Known.X_DM_NOT_SENT
                    X_DUPLICATE_ACTION -> Known.X_DUPLICATE_ACTION
                    X_LOGIN_AUTH_FAILED -> Known.X_LOGIN_AUTH_FAILED
                    X_LOGIN_CHALLENGE -> Known.X_LOGIN_CHALLENGE
                    X_LOGIN_DENIED -> Known.X_LOGIN_DENIED
                    X_LOGIN_FAILED -> Known.X_LOGIN_FAILED
                    X_LOGIN_PROXY_ERROR -> Known.X_LOGIN_PROXY_ERROR
                    X_LOGIN_RATE_LIMITED -> Known.X_LOGIN_RATE_LIMITED
                    X_LOGIN_SERVICE_UNAVAILABLE -> Known.X_LOGIN_SERVICE_UNAVAILABLE
                    X_LOGIN_SUSPENDED -> Known.X_LOGIN_SUSPENDED
                    X_IMAGE_INVALID -> Known.X_IMAGE_INVALID
                    X_MEDIA_REJECTED -> Known.X_MEDIA_REJECTED
                    X_POST_NOT_SENT -> Known.X_POST_NOT_SENT
                    X_RATE_LIMITED -> Known.X_RATE_LIMITED
                    X_REJECTED -> Known.X_REJECTED
                    X_REPLY_NOT_ALLOWED -> Known.X_REPLY_NOT_ALLOWED
                    X_REPLY_TARGET_UNAVAILABLE -> Known.X_REPLY_TARGET_UNAVAILABLE
                    X_TARGET_NOT_FOUND -> Known.X_TARGET_NOT_FOUND
                    X_TRANSIENT_ERROR -> Known.X_TRANSIENT_ERROR
                    X_USER_LOOKUP_FAILED -> Known.X_USER_LOOKUP_FAILED
                    X_VIDEO_TOO_LARGE -> Known.X_VIDEO_TOO_LARGE
                    X_WRITE_AMBIGUOUS -> Known.X_WRITE_AMBIGUOUS
                    X_WRITE_FAILED -> Known.X_WRITE_FAILED
                    else ->
                        throw XTwitterScraperInvalidDataException("Unknown LegacyErrorCode: $value")
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
            fun validate(): LegacyErrorCode = apply {
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

                return other is LegacyErrorCode && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class StructuredError
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val code: JsonField<Code>,
            private val message: JsonField<String>,
            private val type: JsonField<Type>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("code") @ExcludeMissing code: JsonField<Code> = JsonMissing.of(),
                @JsonProperty("message")
                @ExcludeMissing
                message: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            ) : this(code, message, type, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun code(): Code = code.getRequired("code")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun message(): String = message.getRequired("message")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun type(): Type = type.getRequired("type")

            /**
             * Returns the raw JSON value of [code].
             *
             * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Code> = code

            /**
             * Returns the raw JSON value of [message].
             *
             * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                 * Returns a mutable builder for constructing an instance of [StructuredError].
                 *
                 * The following fields are required:
                 * ```java
                 * .code()
                 * .message()
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [StructuredError]. */
            class Builder internal constructor() {

                private var code: JsonField<Code>? = null
                private var message: JsonField<String>? = null
                private var type: JsonField<Type>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(structuredError: StructuredError) = apply {
                    code = structuredError.code
                    message = structuredError.message
                    type = structuredError.type
                    additionalProperties = structuredError.additionalProperties.toMutableMap()
                }

                fun code(code: Code) = code(JsonField.of(code))

                /** Sets [Builder.code] to an arbitrary JSON value. */
                fun code(code: JsonField<Code>) = apply { this.code = code }

                fun message(message: String) = message(JsonField.of(message))

                /** Sets [Builder.message] to an arbitrary JSON value. */
                fun message(message: JsonField<String>) = apply { this.message = message }

                fun type(type: Type) = type(JsonField.of(type))

                /** Sets [Builder.type] to an arbitrary JSON value. */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [StructuredError].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .code()
                 * .message()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): StructuredError =
                    StructuredError(
                        checkRequired("code", code),
                        checkRequired("message", message),
                        checkRequired("type", type),
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): StructuredError = apply {
                if (validated) {
                    return@apply
                }

                code().validate()
                message()
                type().validate()
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
                (code.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (message.asKnown().isPresent) 1 else 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0)

            class Code @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /** Returns this class instance's raw value. */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val INTERNAL_ERROR = of("internal_error")

                    @JvmField val ACCOUNT_ALREADY_CONNECTED = of("account_already_connected")

                    @JvmField
                    val X_ACCOUNT_CONNECT_PERMISSION_REQUIRED =
                        of("x_account_connect_permission_required")

                    @JvmField val X_ACCOUNT_MISMATCH = of("x_account_mismatch")

                    @JvmField val ACCOUNT_NEEDS_REAUTH = of("account_needs_reauth")

                    @JvmField val ACCOUNT_NOT_FOUND = of("account_not_found")

                    @JvmField val ACCOUNT_REQUIRED = of("account_required")

                    @JvmField val ACCOUNT_RESTRICTED = of("account_restricted")

                    @JvmField val API_KEY_EXPIRED = of("api_key_expired")

                    @JvmField val API_KEY_LIMIT_REACHED = of("api_key_limit_reached")

                    @JvmField val API_KEY_PAUSED = of("api_key_paused")

                    @JvmField val API_KEY_BUDGET_REACHED = of("api_key_budget_reached")

                    @JvmField val API_KEY_REVOKED = of("api_key_revoked")

                    @JvmField val IP_NOT_ALLOWED = of("ip_not_allowed")

                    @JvmField val ARTICLE_NOT_FOUND = of("article_not_found")

                    @JvmField val CLOSED = of("closed")

                    @JvmField val DM_NOT_PERMITTED = of("dm_not_permitted")

                    @JvmField val INVALID_FORMAT = of("invalid_format")

                    @JvmField val INVALID_ID = of("invalid_id")

                    @JvmField val INVALID_INPUT = of("invalid_input")

                    @JvmField val INVALID_MEDIA_URL = of("invalid_media_url")

                    @JvmField val INVALID_MESSAGE_ID = of("invalid_message_id")

                    @JvmField val INVALID_PARAMS = of("invalid_params")

                    @JvmField val INVALID_TOOL_TYPE = of("invalid_tool_type")

                    @JvmField val INVALID_TWEET_ID = of("invalid_tweet_id")

                    @JvmField val INVALID_TWEET_URL = of("invalid_tweet_url")

                    @JvmField val INVALID_USER_ID = of("invalid_user_id")

                    @JvmField val INVALID_USER_IDS = of("invalid_user_ids")

                    @JvmField val INVALID_USERNAME = of("invalid_username")

                    @JvmField val INVALID_JSON = of("invalid_json")

                    @JvmField val INSUFFICIENT_CREDITS = of("insufficient_credits")

                    @JvmField val INSUFFICIENT_SCOPE = of("insufficient_scope")

                    @JvmField val JOB_NOT_FOUND = of("job_not_found")

                    @JvmField val LOGIN_COOLDOWN = of("login_cooldown")

                    @JvmField val LOGIN_FAILED = of("login_failed")

                    @JvmField val MEDIA_DOWNLOAD_FAILED = of("media_download_failed")

                    @JvmField val MEDIA_NOT_UPLOADED = of("media_not_uploaded")

                    @JvmField val MEDIA_TOO_LARGE = of("media_too_large")

                    @JvmField val MEDIA_UNAVAILABLE = of("media_unavailable")

                    @JvmField val MISSING_PARAMS = of("missing_params")

                    @JvmField val MISSING_QUERY = of("missing_query")

                    @JvmField val MONITOR_ALREADY_EXISTS = of("monitor_already_exists")

                    @JvmField val MONITOR_PROFILE_UNAVAILABLE = of("monitor_profile_unavailable")

                    @JvmField val NO_MEDIA = of("no_media")

                    @JvmField val NO_CREDITS = of("no_credits")

                    @JvmField val NO_SUBSCRIPTION = of("no_subscription")

                    @JvmField val EXTRACTION_TERMINAL = of("extraction_terminal")

                    @JvmField val NOT_FOUND = of("not_found")

                    @JvmField val PAYMENT_FAILED = of("payment_failed")

                    @JvmField val POST_UNAVAILABLE = of("post_unavailable")

                    @JvmField val PRICE_CHANGED = of("price_changed")

                    @JvmField val RATE_LIMIT_EXCEEDED = of("rate_limit_exceeded")

                    @JvmField val SERVICE_UNAVAILABLE = of("service_unavailable")

                    @JvmField val SESSION_REQUIRED = of("session_required")

                    @JvmField val STYLE_NOT_FOUND = of("style_not_found")

                    @JvmField val SUBSCRIPTION_INACTIVE = of("subscription_inactive")

                    @JvmField val TWEET_NOT_FOUND = of("tweet_not_found")

                    @JvmField val UNAUTHENTICATED = of("unauthenticated")

                    @JvmField val UNSUPPORTED_FIELD = of("unsupported_field")

                    @JvmField val USER_NOT_FOUND = of("user_not_found")

                    @JvmField val BODY_TOO_LARGE = of("body_too_large")

                    @JvmField val BOOKMARK_FOLDERS_UNAVAILABLE = of("bookmark_folders_unavailable")

                    @JvmField val BROADCAST_NOT_FOUND = of("broadcast_not_found")

                    @JvmField val CHECKOUT_UNAVAILABLE = of("checkout_unavailable")

                    @JvmField val CONNECTION_CHALLENGE_EXPIRED = of("connection_challenge_expired")

                    @JvmField
                    val CONNECTION_CHALLENGE_INACTIVE = of("connection_challenge_inactive")

                    @JvmField val CONTRIBUTOR_NOT_FOUND = of("contributor_not_found")

                    @JvmField val COVERAGE_CURSOR_GONE = of("coverage_cursor_gone")

                    @JvmField val COVERAGE_CURSOR_UNAVAILABLE = of("coverage_cursor_unavailable")

                    @JvmField val CURSOR_ACCOUNT_UNAVAILABLE = of("cursor_account_unavailable")

                    @JvmField val DRAFT_NOT_FOUND = of("draft_not_found")

                    @JvmField val DRAW_TOO_LARGE = of("draw_too_large")

                    @JvmField val EXPIRED = of("expired")

                    @JvmField val FAVORITERS_UNAVAILABLE = of("favoriters_unavailable")

                    @JvmField val FORBIDDEN = of("forbidden")

                    @JvmField val GUEST_WALLET_UNAVAILABLE = of("guest_wallet_unavailable")

                    @JvmField val GUEST_WALLETS_DISABLED = of("guest_wallets_disabled")

                    @JvmField val GUEST_WALLETS_UNAVAILABLE = of("guest_wallets_unavailable")

                    @JvmField val IDEMPOTENCY_CONFLICT = of("idempotency_conflict")

                    @JvmField val IDEMPOTENCY_IN_PROGRESS = of("idempotency_in_progress")

                    @JvmField val IDEMPOTENCY_KEY_CONFLICT = of("idempotency_key_conflict")

                    @JvmField val INVALID_BROADCAST_ID = of("invalid_broadcast_id")

                    @JvmField val INVALID_COMMUNITY_ID = of("invalid_community_id")

                    @JvmField val INVALID_COMMUNITY_TOPIC = of("invalid_community_topic")

                    @JvmField
                    val INVALID_COMPLETE_REPLIES_REQUEST = of("invalid_complete_replies_request")

                    @JvmField val INVALID_CONTRIBUTOR_ALIAS = of("invalid_contributor_alias")

                    @JvmField val INVALID_COVERAGE_CURSOR = of("invalid_coverage_cursor")

                    @JvmField val INVALID_COVERAGE_REQUEST = of("invalid_coverage_request")

                    @JvmField val INVALID_CURSOR = of("invalid_cursor")

                    @JvmField val INVALID_IDEMPOTENCY_KEY = of("invalid_idempotency_key")

                    @JvmField val INVALID_JOB_FILTER = of("invalid_job_filter")

                    @JvmField val INVALID_JOB_ID = of("invalid_job_id")

                    @JvmField val INVALID_LIST_ID = of("invalid_list_id")

                    @JvmField val INVALID_NEWS_ID = of("invalid_news_id")

                    @JvmField val INVALID_OUTPUT_OPTIONS = of("invalid_output_options")

                    @JvmField val INVALID_PAYMENT_AMOUNT = of("invalid_payment_amount")

                    @JvmField val INVALID_RANGE = of("invalid_range")

                    @JvmField val INVALID_REPLY_OPTIONS = of("invalid_reply_options")

                    @JvmField val INVALID_SPACE_ID = of("invalid_space_id")

                    @JvmField val LIKES_UNAVAILABLE = of("likes_unavailable")

                    @JvmField val LIST_NOT_FOUND = of("list_not_found")

                    @JvmField val LOGIN_RATE_LIMITED = of("login_rate_limited")

                    @JvmField val LOGIN_SERVICE_UNAVAILABLE = of("login_service_unavailable")

                    @JvmField val MISSING_IDEMPOTENCY_KEY = of("missing_idempotency_key")

                    @JvmField val MISSING_IDS = of("missing_ids")

                    @JvmField val MISSING_URL = of("missing_url")

                    @JvmField val NEWS_NOT_FOUND = of("news_not_found")

                    @JvmField val NO_CACHED_STYLE = of("no_cached_style")

                    @JvmField val PAGINATION_STALLED = of("pagination_stalled")

                    @JvmField val PASSKEY_REQUIRED = of("passkey_required")

                    @JvmField val RATE_LIMITED = of("rate_limited")

                    @JvmField val READ_REQUEST_TIMEOUT = of("read_request_timeout")

                    @JvmField val REPLAY_UNAVAILABLE = of("replay_unavailable")

                    @JvmField val REPLIES_INCOMPLETE = of("replies_incomplete")

                    @JvmField val RETWEETERS_INCOMPLETE = of("retweeters_incomplete")

                    @JvmField val SEARCH_UNAVAILABLE = of("search_unavailable")

                    @JvmField val SPACE_CANCELED = of("space_canceled")

                    @JvmField val SPACE_NOT_ENDED = of("space_not_ended")

                    @JvmField val SUPPORT_MEDIA_RATE_LIMIT = of("support_media_rate_limit")

                    @JvmField val SUPPORT_REQUEST_RATE_LIMIT = of("support_request_rate_limit")

                    @JvmField val TELEGRAM_UNAVAILABLE = of("telegram_unavailable")

                    @JvmField val TOO_MANY_IDS = of("too_many_ids")

                    @JvmField val TOO_MANY_STREAMS = of("too_many_streams")

                    @JvmField val TOO_MANY_TWEETS = of("too_many_tweets")

                    @JvmField val TOPUP_IN_PROGRESS = of("topup_in_progress")

                    @JvmField val UNKNOWN_FIELD = of("unknown_field")

                    @JvmField
                    val UNSUPPORTED_MEDIA_COMBINATION = of("unsupported_media_combination")

                    @JvmField val UNSUPPORTED_MEDIA_TYPE = of("unsupported_media_type")

                    @JvmField val WEBHOOK_INACTIVE = of("webhook_inactive")

                    @JvmField val WRITE_TRACKING_UNAVAILABLE = of("write_tracking_unavailable")

                    @JvmField val X_WRITE_UNCONFIRMED = of("x_write_unconfirmed")

                    @JvmField val X_ACCOUNT_FEATURE_REQUIRED = of("x_account_feature_required")

                    @JvmField val X_ACCOUNT_PROTECTED = of("x_account_protected")

                    @JvmField val X_ACCOUNT_SUSPENDED = of("x_account_suspended")

                    @JvmField val X_API_RATE_LIMITED = of("x_api_rate_limited")

                    @JvmField val X_API_UNAVAILABLE = of("x_api_unavailable")

                    @JvmField val X_API_UNAUTHORIZED = of("x_api_unauthorized")

                    @JvmField val X_AUTH_FAILURE = of("x_auth_failure")

                    @JvmField val X_AUTOMATION_REFUSED = of("x_automation_refused")

                    @JvmField val X_COMMUNITY_CREATION_CLOSED = of("x_community_creation_closed")

                    @JvmField val X_COMMUNITY_NOT_JOINED = of("x_community_not_joined")

                    @JvmField val X_COMMUNITY_NOT_SELECTABLE = of("x_community_not_selectable")

                    @JvmField val X_COMMUNITY_POST_PUBLIC = of("x_community_post_public")

                    @JvmField val X_COMMUNITY_POST_REMOVED = of("x_community_post_removed")

                    @JvmField val X_CONTENT_TOO_LONG = of("x_content_too_long")

                    @JvmField val X_DAILY_LIMIT = of("x_daily_limit")

                    @JvmField val X_DM_NOT_ALLOWED = of("x_dm_not_allowed")

                    @JvmField val X_DM_NOT_DELETED = of("x_dm_not_deleted")

                    @JvmField val X_DM_NOT_SENT = of("x_dm_not_sent")

                    @JvmField val X_DUPLICATE_ACTION = of("x_duplicate_action")

                    @JvmField val X_LOGIN_AUTH_FAILED = of("x_login_auth_failed")

                    @JvmField val X_LOGIN_CHALLENGE = of("x_login_challenge")

                    @JvmField val X_LOGIN_DENIED = of("x_login_denied")

                    @JvmField val X_LOGIN_FAILED = of("x_login_failed")

                    @JvmField val X_LOGIN_PROXY_ERROR = of("x_login_proxy_error")

                    @JvmField val X_LOGIN_RATE_LIMITED = of("x_login_rate_limited")

                    @JvmField val X_LOGIN_SERVICE_UNAVAILABLE = of("x_login_service_unavailable")

                    @JvmField val X_LOGIN_SUSPENDED = of("x_login_suspended")

                    @JvmField val X_IMAGE_INVALID = of("x_image_invalid")

                    @JvmField val X_MEDIA_REJECTED = of("x_media_rejected")

                    @JvmField val X_POST_NOT_SENT = of("x_post_not_sent")

                    @JvmField val X_RATE_LIMITED = of("x_rate_limited")

                    @JvmField val X_REJECTED = of("x_rejected")

                    @JvmField val X_REPLY_NOT_ALLOWED = of("x_reply_not_allowed")

                    @JvmField val X_REPLY_TARGET_UNAVAILABLE = of("x_reply_target_unavailable")

                    @JvmField val X_TARGET_NOT_FOUND = of("x_target_not_found")

                    @JvmField val X_TRANSIENT_ERROR = of("x_transient_error")

                    @JvmField val X_USER_LOOKUP_FAILED = of("x_user_lookup_failed")

                    @JvmField val X_VIDEO_TOO_LARGE = of("x_video_too_large")

                    @JvmField val X_WRITE_AMBIGUOUS = of("x_write_ambiguous")

                    @JvmField val X_WRITE_FAILED = of("x_write_failed")

                    @JvmStatic fun of(value: String) = Code(JsonField.of(value))
                }

                /** An enum containing [Code]'s known values. */
                enum class Known {
                    INTERNAL_ERROR,
                    ACCOUNT_ALREADY_CONNECTED,
                    X_ACCOUNT_CONNECT_PERMISSION_REQUIRED,
                    X_ACCOUNT_MISMATCH,
                    ACCOUNT_NEEDS_REAUTH,
                    ACCOUNT_NOT_FOUND,
                    ACCOUNT_REQUIRED,
                    ACCOUNT_RESTRICTED,
                    API_KEY_EXPIRED,
                    API_KEY_LIMIT_REACHED,
                    API_KEY_PAUSED,
                    API_KEY_BUDGET_REACHED,
                    API_KEY_REVOKED,
                    IP_NOT_ALLOWED,
                    ARTICLE_NOT_FOUND,
                    CLOSED,
                    DM_NOT_PERMITTED,
                    INVALID_FORMAT,
                    INVALID_ID,
                    INVALID_INPUT,
                    INVALID_MEDIA_URL,
                    INVALID_MESSAGE_ID,
                    INVALID_PARAMS,
                    INVALID_TOOL_TYPE,
                    INVALID_TWEET_ID,
                    INVALID_TWEET_URL,
                    INVALID_USER_ID,
                    INVALID_USER_IDS,
                    INVALID_USERNAME,
                    INVALID_JSON,
                    INSUFFICIENT_CREDITS,
                    INSUFFICIENT_SCOPE,
                    JOB_NOT_FOUND,
                    LOGIN_COOLDOWN,
                    LOGIN_FAILED,
                    MEDIA_DOWNLOAD_FAILED,
                    MEDIA_NOT_UPLOADED,
                    MEDIA_TOO_LARGE,
                    MEDIA_UNAVAILABLE,
                    MISSING_PARAMS,
                    MISSING_QUERY,
                    MONITOR_ALREADY_EXISTS,
                    MONITOR_PROFILE_UNAVAILABLE,
                    NO_MEDIA,
                    NO_CREDITS,
                    NO_SUBSCRIPTION,
                    EXTRACTION_TERMINAL,
                    NOT_FOUND,
                    PAYMENT_FAILED,
                    POST_UNAVAILABLE,
                    PRICE_CHANGED,
                    RATE_LIMIT_EXCEEDED,
                    SERVICE_UNAVAILABLE,
                    SESSION_REQUIRED,
                    STYLE_NOT_FOUND,
                    SUBSCRIPTION_INACTIVE,
                    TWEET_NOT_FOUND,
                    UNAUTHENTICATED,
                    UNSUPPORTED_FIELD,
                    USER_NOT_FOUND,
                    BODY_TOO_LARGE,
                    BOOKMARK_FOLDERS_UNAVAILABLE,
                    BROADCAST_NOT_FOUND,
                    CHECKOUT_UNAVAILABLE,
                    CONNECTION_CHALLENGE_EXPIRED,
                    CONNECTION_CHALLENGE_INACTIVE,
                    CONTRIBUTOR_NOT_FOUND,
                    COVERAGE_CURSOR_GONE,
                    COVERAGE_CURSOR_UNAVAILABLE,
                    CURSOR_ACCOUNT_UNAVAILABLE,
                    DRAFT_NOT_FOUND,
                    DRAW_TOO_LARGE,
                    EXPIRED,
                    FAVORITERS_UNAVAILABLE,
                    FORBIDDEN,
                    GUEST_WALLET_UNAVAILABLE,
                    GUEST_WALLETS_DISABLED,
                    GUEST_WALLETS_UNAVAILABLE,
                    IDEMPOTENCY_CONFLICT,
                    IDEMPOTENCY_IN_PROGRESS,
                    IDEMPOTENCY_KEY_CONFLICT,
                    INVALID_BROADCAST_ID,
                    INVALID_COMMUNITY_ID,
                    INVALID_COMMUNITY_TOPIC,
                    INVALID_COMPLETE_REPLIES_REQUEST,
                    INVALID_CONTRIBUTOR_ALIAS,
                    INVALID_COVERAGE_CURSOR,
                    INVALID_COVERAGE_REQUEST,
                    INVALID_CURSOR,
                    INVALID_IDEMPOTENCY_KEY,
                    INVALID_JOB_FILTER,
                    INVALID_JOB_ID,
                    INVALID_LIST_ID,
                    INVALID_NEWS_ID,
                    INVALID_OUTPUT_OPTIONS,
                    INVALID_PAYMENT_AMOUNT,
                    INVALID_RANGE,
                    INVALID_REPLY_OPTIONS,
                    INVALID_SPACE_ID,
                    LIKES_UNAVAILABLE,
                    LIST_NOT_FOUND,
                    LOGIN_RATE_LIMITED,
                    LOGIN_SERVICE_UNAVAILABLE,
                    MISSING_IDEMPOTENCY_KEY,
                    MISSING_IDS,
                    MISSING_URL,
                    NEWS_NOT_FOUND,
                    NO_CACHED_STYLE,
                    PAGINATION_STALLED,
                    PASSKEY_REQUIRED,
                    RATE_LIMITED,
                    READ_REQUEST_TIMEOUT,
                    REPLAY_UNAVAILABLE,
                    REPLIES_INCOMPLETE,
                    RETWEETERS_INCOMPLETE,
                    SEARCH_UNAVAILABLE,
                    SPACE_CANCELED,
                    SPACE_NOT_ENDED,
                    SUPPORT_MEDIA_RATE_LIMIT,
                    SUPPORT_REQUEST_RATE_LIMIT,
                    TELEGRAM_UNAVAILABLE,
                    TOO_MANY_IDS,
                    TOO_MANY_STREAMS,
                    TOO_MANY_TWEETS,
                    TOPUP_IN_PROGRESS,
                    UNKNOWN_FIELD,
                    UNSUPPORTED_MEDIA_COMBINATION,
                    UNSUPPORTED_MEDIA_TYPE,
                    WEBHOOK_INACTIVE,
                    WRITE_TRACKING_UNAVAILABLE,
                    X_WRITE_UNCONFIRMED,
                    X_ACCOUNT_FEATURE_REQUIRED,
                    X_ACCOUNT_PROTECTED,
                    X_ACCOUNT_SUSPENDED,
                    X_API_RATE_LIMITED,
                    X_API_UNAVAILABLE,
                    X_API_UNAUTHORIZED,
                    X_AUTH_FAILURE,
                    X_AUTOMATION_REFUSED,
                    X_COMMUNITY_CREATION_CLOSED,
                    X_COMMUNITY_NOT_JOINED,
                    X_COMMUNITY_NOT_SELECTABLE,
                    X_COMMUNITY_POST_PUBLIC,
                    X_COMMUNITY_POST_REMOVED,
                    X_CONTENT_TOO_LONG,
                    X_DAILY_LIMIT,
                    X_DM_NOT_ALLOWED,
                    X_DM_NOT_DELETED,
                    X_DM_NOT_SENT,
                    X_DUPLICATE_ACTION,
                    X_LOGIN_AUTH_FAILED,
                    X_LOGIN_CHALLENGE,
                    X_LOGIN_DENIED,
                    X_LOGIN_FAILED,
                    X_LOGIN_PROXY_ERROR,
                    X_LOGIN_RATE_LIMITED,
                    X_LOGIN_SERVICE_UNAVAILABLE,
                    X_LOGIN_SUSPENDED,
                    X_IMAGE_INVALID,
                    X_MEDIA_REJECTED,
                    X_POST_NOT_SENT,
                    X_RATE_LIMITED,
                    X_REJECTED,
                    X_REPLY_NOT_ALLOWED,
                    X_REPLY_TARGET_UNAVAILABLE,
                    X_TARGET_NOT_FOUND,
                    X_TRANSIENT_ERROR,
                    X_USER_LOOKUP_FAILED,
                    X_VIDEO_TOO_LARGE,
                    X_WRITE_AMBIGUOUS,
                    X_WRITE_FAILED,
                }

                /**
                 * An enum containing [Code]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Code] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    INTERNAL_ERROR,
                    ACCOUNT_ALREADY_CONNECTED,
                    X_ACCOUNT_CONNECT_PERMISSION_REQUIRED,
                    X_ACCOUNT_MISMATCH,
                    ACCOUNT_NEEDS_REAUTH,
                    ACCOUNT_NOT_FOUND,
                    ACCOUNT_REQUIRED,
                    ACCOUNT_RESTRICTED,
                    API_KEY_EXPIRED,
                    API_KEY_LIMIT_REACHED,
                    API_KEY_PAUSED,
                    API_KEY_BUDGET_REACHED,
                    API_KEY_REVOKED,
                    IP_NOT_ALLOWED,
                    ARTICLE_NOT_FOUND,
                    CLOSED,
                    DM_NOT_PERMITTED,
                    INVALID_FORMAT,
                    INVALID_ID,
                    INVALID_INPUT,
                    INVALID_MEDIA_URL,
                    INVALID_MESSAGE_ID,
                    INVALID_PARAMS,
                    INVALID_TOOL_TYPE,
                    INVALID_TWEET_ID,
                    INVALID_TWEET_URL,
                    INVALID_USER_ID,
                    INVALID_USER_IDS,
                    INVALID_USERNAME,
                    INVALID_JSON,
                    INSUFFICIENT_CREDITS,
                    INSUFFICIENT_SCOPE,
                    JOB_NOT_FOUND,
                    LOGIN_COOLDOWN,
                    LOGIN_FAILED,
                    MEDIA_DOWNLOAD_FAILED,
                    MEDIA_NOT_UPLOADED,
                    MEDIA_TOO_LARGE,
                    MEDIA_UNAVAILABLE,
                    MISSING_PARAMS,
                    MISSING_QUERY,
                    MONITOR_ALREADY_EXISTS,
                    MONITOR_PROFILE_UNAVAILABLE,
                    NO_MEDIA,
                    NO_CREDITS,
                    NO_SUBSCRIPTION,
                    EXTRACTION_TERMINAL,
                    NOT_FOUND,
                    PAYMENT_FAILED,
                    POST_UNAVAILABLE,
                    PRICE_CHANGED,
                    RATE_LIMIT_EXCEEDED,
                    SERVICE_UNAVAILABLE,
                    SESSION_REQUIRED,
                    STYLE_NOT_FOUND,
                    SUBSCRIPTION_INACTIVE,
                    TWEET_NOT_FOUND,
                    UNAUTHENTICATED,
                    UNSUPPORTED_FIELD,
                    USER_NOT_FOUND,
                    BODY_TOO_LARGE,
                    BOOKMARK_FOLDERS_UNAVAILABLE,
                    BROADCAST_NOT_FOUND,
                    CHECKOUT_UNAVAILABLE,
                    CONNECTION_CHALLENGE_EXPIRED,
                    CONNECTION_CHALLENGE_INACTIVE,
                    CONTRIBUTOR_NOT_FOUND,
                    COVERAGE_CURSOR_GONE,
                    COVERAGE_CURSOR_UNAVAILABLE,
                    CURSOR_ACCOUNT_UNAVAILABLE,
                    DRAFT_NOT_FOUND,
                    DRAW_TOO_LARGE,
                    EXPIRED,
                    FAVORITERS_UNAVAILABLE,
                    FORBIDDEN,
                    GUEST_WALLET_UNAVAILABLE,
                    GUEST_WALLETS_DISABLED,
                    GUEST_WALLETS_UNAVAILABLE,
                    IDEMPOTENCY_CONFLICT,
                    IDEMPOTENCY_IN_PROGRESS,
                    IDEMPOTENCY_KEY_CONFLICT,
                    INVALID_BROADCAST_ID,
                    INVALID_COMMUNITY_ID,
                    INVALID_COMMUNITY_TOPIC,
                    INVALID_COMPLETE_REPLIES_REQUEST,
                    INVALID_CONTRIBUTOR_ALIAS,
                    INVALID_COVERAGE_CURSOR,
                    INVALID_COVERAGE_REQUEST,
                    INVALID_CURSOR,
                    INVALID_IDEMPOTENCY_KEY,
                    INVALID_JOB_FILTER,
                    INVALID_JOB_ID,
                    INVALID_LIST_ID,
                    INVALID_NEWS_ID,
                    INVALID_OUTPUT_OPTIONS,
                    INVALID_PAYMENT_AMOUNT,
                    INVALID_RANGE,
                    INVALID_REPLY_OPTIONS,
                    INVALID_SPACE_ID,
                    LIKES_UNAVAILABLE,
                    LIST_NOT_FOUND,
                    LOGIN_RATE_LIMITED,
                    LOGIN_SERVICE_UNAVAILABLE,
                    MISSING_IDEMPOTENCY_KEY,
                    MISSING_IDS,
                    MISSING_URL,
                    NEWS_NOT_FOUND,
                    NO_CACHED_STYLE,
                    PAGINATION_STALLED,
                    PASSKEY_REQUIRED,
                    RATE_LIMITED,
                    READ_REQUEST_TIMEOUT,
                    REPLAY_UNAVAILABLE,
                    REPLIES_INCOMPLETE,
                    RETWEETERS_INCOMPLETE,
                    SEARCH_UNAVAILABLE,
                    SPACE_CANCELED,
                    SPACE_NOT_ENDED,
                    SUPPORT_MEDIA_RATE_LIMIT,
                    SUPPORT_REQUEST_RATE_LIMIT,
                    TELEGRAM_UNAVAILABLE,
                    TOO_MANY_IDS,
                    TOO_MANY_STREAMS,
                    TOO_MANY_TWEETS,
                    TOPUP_IN_PROGRESS,
                    UNKNOWN_FIELD,
                    UNSUPPORTED_MEDIA_COMBINATION,
                    UNSUPPORTED_MEDIA_TYPE,
                    WEBHOOK_INACTIVE,
                    WRITE_TRACKING_UNAVAILABLE,
                    X_WRITE_UNCONFIRMED,
                    X_ACCOUNT_FEATURE_REQUIRED,
                    X_ACCOUNT_PROTECTED,
                    X_ACCOUNT_SUSPENDED,
                    X_API_RATE_LIMITED,
                    X_API_UNAVAILABLE,
                    X_API_UNAUTHORIZED,
                    X_AUTH_FAILURE,
                    X_AUTOMATION_REFUSED,
                    X_COMMUNITY_CREATION_CLOSED,
                    X_COMMUNITY_NOT_JOINED,
                    X_COMMUNITY_NOT_SELECTABLE,
                    X_COMMUNITY_POST_PUBLIC,
                    X_COMMUNITY_POST_REMOVED,
                    X_CONTENT_TOO_LONG,
                    X_DAILY_LIMIT,
                    X_DM_NOT_ALLOWED,
                    X_DM_NOT_DELETED,
                    X_DM_NOT_SENT,
                    X_DUPLICATE_ACTION,
                    X_LOGIN_AUTH_FAILED,
                    X_LOGIN_CHALLENGE,
                    X_LOGIN_DENIED,
                    X_LOGIN_FAILED,
                    X_LOGIN_PROXY_ERROR,
                    X_LOGIN_RATE_LIMITED,
                    X_LOGIN_SERVICE_UNAVAILABLE,
                    X_LOGIN_SUSPENDED,
                    X_IMAGE_INVALID,
                    X_MEDIA_REJECTED,
                    X_POST_NOT_SENT,
                    X_RATE_LIMITED,
                    X_REJECTED,
                    X_REPLY_NOT_ALLOWED,
                    X_REPLY_TARGET_UNAVAILABLE,
                    X_TARGET_NOT_FOUND,
                    X_TRANSIENT_ERROR,
                    X_USER_LOOKUP_FAILED,
                    X_VIDEO_TOO_LARGE,
                    X_WRITE_AMBIGUOUS,
                    X_WRITE_FAILED,
                    /**
                     * An enum member indicating that [Code] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 */
                fun value(): Value =
                    when (this) {
                        INTERNAL_ERROR -> Value.INTERNAL_ERROR
                        ACCOUNT_ALREADY_CONNECTED -> Value.ACCOUNT_ALREADY_CONNECTED
                        X_ACCOUNT_CONNECT_PERMISSION_REQUIRED ->
                            Value.X_ACCOUNT_CONNECT_PERMISSION_REQUIRED
                        X_ACCOUNT_MISMATCH -> Value.X_ACCOUNT_MISMATCH
                        ACCOUNT_NEEDS_REAUTH -> Value.ACCOUNT_NEEDS_REAUTH
                        ACCOUNT_NOT_FOUND -> Value.ACCOUNT_NOT_FOUND
                        ACCOUNT_REQUIRED -> Value.ACCOUNT_REQUIRED
                        ACCOUNT_RESTRICTED -> Value.ACCOUNT_RESTRICTED
                        API_KEY_EXPIRED -> Value.API_KEY_EXPIRED
                        API_KEY_LIMIT_REACHED -> Value.API_KEY_LIMIT_REACHED
                        API_KEY_PAUSED -> Value.API_KEY_PAUSED
                        API_KEY_BUDGET_REACHED -> Value.API_KEY_BUDGET_REACHED
                        API_KEY_REVOKED -> Value.API_KEY_REVOKED
                        IP_NOT_ALLOWED -> Value.IP_NOT_ALLOWED
                        ARTICLE_NOT_FOUND -> Value.ARTICLE_NOT_FOUND
                        CLOSED -> Value.CLOSED
                        DM_NOT_PERMITTED -> Value.DM_NOT_PERMITTED
                        INVALID_FORMAT -> Value.INVALID_FORMAT
                        INVALID_ID -> Value.INVALID_ID
                        INVALID_INPUT -> Value.INVALID_INPUT
                        INVALID_MEDIA_URL -> Value.INVALID_MEDIA_URL
                        INVALID_MESSAGE_ID -> Value.INVALID_MESSAGE_ID
                        INVALID_PARAMS -> Value.INVALID_PARAMS
                        INVALID_TOOL_TYPE -> Value.INVALID_TOOL_TYPE
                        INVALID_TWEET_ID -> Value.INVALID_TWEET_ID
                        INVALID_TWEET_URL -> Value.INVALID_TWEET_URL
                        INVALID_USER_ID -> Value.INVALID_USER_ID
                        INVALID_USER_IDS -> Value.INVALID_USER_IDS
                        INVALID_USERNAME -> Value.INVALID_USERNAME
                        INVALID_JSON -> Value.INVALID_JSON
                        INSUFFICIENT_CREDITS -> Value.INSUFFICIENT_CREDITS
                        INSUFFICIENT_SCOPE -> Value.INSUFFICIENT_SCOPE
                        JOB_NOT_FOUND -> Value.JOB_NOT_FOUND
                        LOGIN_COOLDOWN -> Value.LOGIN_COOLDOWN
                        LOGIN_FAILED -> Value.LOGIN_FAILED
                        MEDIA_DOWNLOAD_FAILED -> Value.MEDIA_DOWNLOAD_FAILED
                        MEDIA_NOT_UPLOADED -> Value.MEDIA_NOT_UPLOADED
                        MEDIA_TOO_LARGE -> Value.MEDIA_TOO_LARGE
                        MEDIA_UNAVAILABLE -> Value.MEDIA_UNAVAILABLE
                        MISSING_PARAMS -> Value.MISSING_PARAMS
                        MISSING_QUERY -> Value.MISSING_QUERY
                        MONITOR_ALREADY_EXISTS -> Value.MONITOR_ALREADY_EXISTS
                        MONITOR_PROFILE_UNAVAILABLE -> Value.MONITOR_PROFILE_UNAVAILABLE
                        NO_MEDIA -> Value.NO_MEDIA
                        NO_CREDITS -> Value.NO_CREDITS
                        NO_SUBSCRIPTION -> Value.NO_SUBSCRIPTION
                        EXTRACTION_TERMINAL -> Value.EXTRACTION_TERMINAL
                        NOT_FOUND -> Value.NOT_FOUND
                        PAYMENT_FAILED -> Value.PAYMENT_FAILED
                        POST_UNAVAILABLE -> Value.POST_UNAVAILABLE
                        PRICE_CHANGED -> Value.PRICE_CHANGED
                        RATE_LIMIT_EXCEEDED -> Value.RATE_LIMIT_EXCEEDED
                        SERVICE_UNAVAILABLE -> Value.SERVICE_UNAVAILABLE
                        SESSION_REQUIRED -> Value.SESSION_REQUIRED
                        STYLE_NOT_FOUND -> Value.STYLE_NOT_FOUND
                        SUBSCRIPTION_INACTIVE -> Value.SUBSCRIPTION_INACTIVE
                        TWEET_NOT_FOUND -> Value.TWEET_NOT_FOUND
                        UNAUTHENTICATED -> Value.UNAUTHENTICATED
                        UNSUPPORTED_FIELD -> Value.UNSUPPORTED_FIELD
                        USER_NOT_FOUND -> Value.USER_NOT_FOUND
                        BODY_TOO_LARGE -> Value.BODY_TOO_LARGE
                        BOOKMARK_FOLDERS_UNAVAILABLE -> Value.BOOKMARK_FOLDERS_UNAVAILABLE
                        BROADCAST_NOT_FOUND -> Value.BROADCAST_NOT_FOUND
                        CHECKOUT_UNAVAILABLE -> Value.CHECKOUT_UNAVAILABLE
                        CONNECTION_CHALLENGE_EXPIRED -> Value.CONNECTION_CHALLENGE_EXPIRED
                        CONNECTION_CHALLENGE_INACTIVE -> Value.CONNECTION_CHALLENGE_INACTIVE
                        CONTRIBUTOR_NOT_FOUND -> Value.CONTRIBUTOR_NOT_FOUND
                        COVERAGE_CURSOR_GONE -> Value.COVERAGE_CURSOR_GONE
                        COVERAGE_CURSOR_UNAVAILABLE -> Value.COVERAGE_CURSOR_UNAVAILABLE
                        CURSOR_ACCOUNT_UNAVAILABLE -> Value.CURSOR_ACCOUNT_UNAVAILABLE
                        DRAFT_NOT_FOUND -> Value.DRAFT_NOT_FOUND
                        DRAW_TOO_LARGE -> Value.DRAW_TOO_LARGE
                        EXPIRED -> Value.EXPIRED
                        FAVORITERS_UNAVAILABLE -> Value.FAVORITERS_UNAVAILABLE
                        FORBIDDEN -> Value.FORBIDDEN
                        GUEST_WALLET_UNAVAILABLE -> Value.GUEST_WALLET_UNAVAILABLE
                        GUEST_WALLETS_DISABLED -> Value.GUEST_WALLETS_DISABLED
                        GUEST_WALLETS_UNAVAILABLE -> Value.GUEST_WALLETS_UNAVAILABLE
                        IDEMPOTENCY_CONFLICT -> Value.IDEMPOTENCY_CONFLICT
                        IDEMPOTENCY_IN_PROGRESS -> Value.IDEMPOTENCY_IN_PROGRESS
                        IDEMPOTENCY_KEY_CONFLICT -> Value.IDEMPOTENCY_KEY_CONFLICT
                        INVALID_BROADCAST_ID -> Value.INVALID_BROADCAST_ID
                        INVALID_COMMUNITY_ID -> Value.INVALID_COMMUNITY_ID
                        INVALID_COMMUNITY_TOPIC -> Value.INVALID_COMMUNITY_TOPIC
                        INVALID_COMPLETE_REPLIES_REQUEST -> Value.INVALID_COMPLETE_REPLIES_REQUEST
                        INVALID_CONTRIBUTOR_ALIAS -> Value.INVALID_CONTRIBUTOR_ALIAS
                        INVALID_COVERAGE_CURSOR -> Value.INVALID_COVERAGE_CURSOR
                        INVALID_COVERAGE_REQUEST -> Value.INVALID_COVERAGE_REQUEST
                        INVALID_CURSOR -> Value.INVALID_CURSOR
                        INVALID_IDEMPOTENCY_KEY -> Value.INVALID_IDEMPOTENCY_KEY
                        INVALID_JOB_FILTER -> Value.INVALID_JOB_FILTER
                        INVALID_JOB_ID -> Value.INVALID_JOB_ID
                        INVALID_LIST_ID -> Value.INVALID_LIST_ID
                        INVALID_NEWS_ID -> Value.INVALID_NEWS_ID
                        INVALID_OUTPUT_OPTIONS -> Value.INVALID_OUTPUT_OPTIONS
                        INVALID_PAYMENT_AMOUNT -> Value.INVALID_PAYMENT_AMOUNT
                        INVALID_RANGE -> Value.INVALID_RANGE
                        INVALID_REPLY_OPTIONS -> Value.INVALID_REPLY_OPTIONS
                        INVALID_SPACE_ID -> Value.INVALID_SPACE_ID
                        LIKES_UNAVAILABLE -> Value.LIKES_UNAVAILABLE
                        LIST_NOT_FOUND -> Value.LIST_NOT_FOUND
                        LOGIN_RATE_LIMITED -> Value.LOGIN_RATE_LIMITED
                        LOGIN_SERVICE_UNAVAILABLE -> Value.LOGIN_SERVICE_UNAVAILABLE
                        MISSING_IDEMPOTENCY_KEY -> Value.MISSING_IDEMPOTENCY_KEY
                        MISSING_IDS -> Value.MISSING_IDS
                        MISSING_URL -> Value.MISSING_URL
                        NEWS_NOT_FOUND -> Value.NEWS_NOT_FOUND
                        NO_CACHED_STYLE -> Value.NO_CACHED_STYLE
                        PAGINATION_STALLED -> Value.PAGINATION_STALLED
                        PASSKEY_REQUIRED -> Value.PASSKEY_REQUIRED
                        RATE_LIMITED -> Value.RATE_LIMITED
                        READ_REQUEST_TIMEOUT -> Value.READ_REQUEST_TIMEOUT
                        REPLAY_UNAVAILABLE -> Value.REPLAY_UNAVAILABLE
                        REPLIES_INCOMPLETE -> Value.REPLIES_INCOMPLETE
                        RETWEETERS_INCOMPLETE -> Value.RETWEETERS_INCOMPLETE
                        SEARCH_UNAVAILABLE -> Value.SEARCH_UNAVAILABLE
                        SPACE_CANCELED -> Value.SPACE_CANCELED
                        SPACE_NOT_ENDED -> Value.SPACE_NOT_ENDED
                        SUPPORT_MEDIA_RATE_LIMIT -> Value.SUPPORT_MEDIA_RATE_LIMIT
                        SUPPORT_REQUEST_RATE_LIMIT -> Value.SUPPORT_REQUEST_RATE_LIMIT
                        TELEGRAM_UNAVAILABLE -> Value.TELEGRAM_UNAVAILABLE
                        TOO_MANY_IDS -> Value.TOO_MANY_IDS
                        TOO_MANY_STREAMS -> Value.TOO_MANY_STREAMS
                        TOO_MANY_TWEETS -> Value.TOO_MANY_TWEETS
                        TOPUP_IN_PROGRESS -> Value.TOPUP_IN_PROGRESS
                        UNKNOWN_FIELD -> Value.UNKNOWN_FIELD
                        UNSUPPORTED_MEDIA_COMBINATION -> Value.UNSUPPORTED_MEDIA_COMBINATION
                        UNSUPPORTED_MEDIA_TYPE -> Value.UNSUPPORTED_MEDIA_TYPE
                        WEBHOOK_INACTIVE -> Value.WEBHOOK_INACTIVE
                        WRITE_TRACKING_UNAVAILABLE -> Value.WRITE_TRACKING_UNAVAILABLE
                        X_WRITE_UNCONFIRMED -> Value.X_WRITE_UNCONFIRMED
                        X_ACCOUNT_FEATURE_REQUIRED -> Value.X_ACCOUNT_FEATURE_REQUIRED
                        X_ACCOUNT_PROTECTED -> Value.X_ACCOUNT_PROTECTED
                        X_ACCOUNT_SUSPENDED -> Value.X_ACCOUNT_SUSPENDED
                        X_API_RATE_LIMITED -> Value.X_API_RATE_LIMITED
                        X_API_UNAVAILABLE -> Value.X_API_UNAVAILABLE
                        X_API_UNAUTHORIZED -> Value.X_API_UNAUTHORIZED
                        X_AUTH_FAILURE -> Value.X_AUTH_FAILURE
                        X_AUTOMATION_REFUSED -> Value.X_AUTOMATION_REFUSED
                        X_COMMUNITY_CREATION_CLOSED -> Value.X_COMMUNITY_CREATION_CLOSED
                        X_COMMUNITY_NOT_JOINED -> Value.X_COMMUNITY_NOT_JOINED
                        X_COMMUNITY_NOT_SELECTABLE -> Value.X_COMMUNITY_NOT_SELECTABLE
                        X_COMMUNITY_POST_PUBLIC -> Value.X_COMMUNITY_POST_PUBLIC
                        X_COMMUNITY_POST_REMOVED -> Value.X_COMMUNITY_POST_REMOVED
                        X_CONTENT_TOO_LONG -> Value.X_CONTENT_TOO_LONG
                        X_DAILY_LIMIT -> Value.X_DAILY_LIMIT
                        X_DM_NOT_ALLOWED -> Value.X_DM_NOT_ALLOWED
                        X_DM_NOT_DELETED -> Value.X_DM_NOT_DELETED
                        X_DM_NOT_SENT -> Value.X_DM_NOT_SENT
                        X_DUPLICATE_ACTION -> Value.X_DUPLICATE_ACTION
                        X_LOGIN_AUTH_FAILED -> Value.X_LOGIN_AUTH_FAILED
                        X_LOGIN_CHALLENGE -> Value.X_LOGIN_CHALLENGE
                        X_LOGIN_DENIED -> Value.X_LOGIN_DENIED
                        X_LOGIN_FAILED -> Value.X_LOGIN_FAILED
                        X_LOGIN_PROXY_ERROR -> Value.X_LOGIN_PROXY_ERROR
                        X_LOGIN_RATE_LIMITED -> Value.X_LOGIN_RATE_LIMITED
                        X_LOGIN_SERVICE_UNAVAILABLE -> Value.X_LOGIN_SERVICE_UNAVAILABLE
                        X_LOGIN_SUSPENDED -> Value.X_LOGIN_SUSPENDED
                        X_IMAGE_INVALID -> Value.X_IMAGE_INVALID
                        X_MEDIA_REJECTED -> Value.X_MEDIA_REJECTED
                        X_POST_NOT_SENT -> Value.X_POST_NOT_SENT
                        X_RATE_LIMITED -> Value.X_RATE_LIMITED
                        X_REJECTED -> Value.X_REJECTED
                        X_REPLY_NOT_ALLOWED -> Value.X_REPLY_NOT_ALLOWED
                        X_REPLY_TARGET_UNAVAILABLE -> Value.X_REPLY_TARGET_UNAVAILABLE
                        X_TARGET_NOT_FOUND -> Value.X_TARGET_NOT_FOUND
                        X_TRANSIENT_ERROR -> Value.X_TRANSIENT_ERROR
                        X_USER_LOOKUP_FAILED -> Value.X_USER_LOOKUP_FAILED
                        X_VIDEO_TOO_LARGE -> Value.X_VIDEO_TOO_LARGE
                        X_WRITE_AMBIGUOUS -> Value.X_WRITE_AMBIGUOUS
                        X_WRITE_FAILED -> Value.X_WRITE_FAILED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        INTERNAL_ERROR -> Known.INTERNAL_ERROR
                        ACCOUNT_ALREADY_CONNECTED -> Known.ACCOUNT_ALREADY_CONNECTED
                        X_ACCOUNT_CONNECT_PERMISSION_REQUIRED ->
                            Known.X_ACCOUNT_CONNECT_PERMISSION_REQUIRED
                        X_ACCOUNT_MISMATCH -> Known.X_ACCOUNT_MISMATCH
                        ACCOUNT_NEEDS_REAUTH -> Known.ACCOUNT_NEEDS_REAUTH
                        ACCOUNT_NOT_FOUND -> Known.ACCOUNT_NOT_FOUND
                        ACCOUNT_REQUIRED -> Known.ACCOUNT_REQUIRED
                        ACCOUNT_RESTRICTED -> Known.ACCOUNT_RESTRICTED
                        API_KEY_EXPIRED -> Known.API_KEY_EXPIRED
                        API_KEY_LIMIT_REACHED -> Known.API_KEY_LIMIT_REACHED
                        API_KEY_PAUSED -> Known.API_KEY_PAUSED
                        API_KEY_BUDGET_REACHED -> Known.API_KEY_BUDGET_REACHED
                        API_KEY_REVOKED -> Known.API_KEY_REVOKED
                        IP_NOT_ALLOWED -> Known.IP_NOT_ALLOWED
                        ARTICLE_NOT_FOUND -> Known.ARTICLE_NOT_FOUND
                        CLOSED -> Known.CLOSED
                        DM_NOT_PERMITTED -> Known.DM_NOT_PERMITTED
                        INVALID_FORMAT -> Known.INVALID_FORMAT
                        INVALID_ID -> Known.INVALID_ID
                        INVALID_INPUT -> Known.INVALID_INPUT
                        INVALID_MEDIA_URL -> Known.INVALID_MEDIA_URL
                        INVALID_MESSAGE_ID -> Known.INVALID_MESSAGE_ID
                        INVALID_PARAMS -> Known.INVALID_PARAMS
                        INVALID_TOOL_TYPE -> Known.INVALID_TOOL_TYPE
                        INVALID_TWEET_ID -> Known.INVALID_TWEET_ID
                        INVALID_TWEET_URL -> Known.INVALID_TWEET_URL
                        INVALID_USER_ID -> Known.INVALID_USER_ID
                        INVALID_USER_IDS -> Known.INVALID_USER_IDS
                        INVALID_USERNAME -> Known.INVALID_USERNAME
                        INVALID_JSON -> Known.INVALID_JSON
                        INSUFFICIENT_CREDITS -> Known.INSUFFICIENT_CREDITS
                        INSUFFICIENT_SCOPE -> Known.INSUFFICIENT_SCOPE
                        JOB_NOT_FOUND -> Known.JOB_NOT_FOUND
                        LOGIN_COOLDOWN -> Known.LOGIN_COOLDOWN
                        LOGIN_FAILED -> Known.LOGIN_FAILED
                        MEDIA_DOWNLOAD_FAILED -> Known.MEDIA_DOWNLOAD_FAILED
                        MEDIA_NOT_UPLOADED -> Known.MEDIA_NOT_UPLOADED
                        MEDIA_TOO_LARGE -> Known.MEDIA_TOO_LARGE
                        MEDIA_UNAVAILABLE -> Known.MEDIA_UNAVAILABLE
                        MISSING_PARAMS -> Known.MISSING_PARAMS
                        MISSING_QUERY -> Known.MISSING_QUERY
                        MONITOR_ALREADY_EXISTS -> Known.MONITOR_ALREADY_EXISTS
                        MONITOR_PROFILE_UNAVAILABLE -> Known.MONITOR_PROFILE_UNAVAILABLE
                        NO_MEDIA -> Known.NO_MEDIA
                        NO_CREDITS -> Known.NO_CREDITS
                        NO_SUBSCRIPTION -> Known.NO_SUBSCRIPTION
                        EXTRACTION_TERMINAL -> Known.EXTRACTION_TERMINAL
                        NOT_FOUND -> Known.NOT_FOUND
                        PAYMENT_FAILED -> Known.PAYMENT_FAILED
                        POST_UNAVAILABLE -> Known.POST_UNAVAILABLE
                        PRICE_CHANGED -> Known.PRICE_CHANGED
                        RATE_LIMIT_EXCEEDED -> Known.RATE_LIMIT_EXCEEDED
                        SERVICE_UNAVAILABLE -> Known.SERVICE_UNAVAILABLE
                        SESSION_REQUIRED -> Known.SESSION_REQUIRED
                        STYLE_NOT_FOUND -> Known.STYLE_NOT_FOUND
                        SUBSCRIPTION_INACTIVE -> Known.SUBSCRIPTION_INACTIVE
                        TWEET_NOT_FOUND -> Known.TWEET_NOT_FOUND
                        UNAUTHENTICATED -> Known.UNAUTHENTICATED
                        UNSUPPORTED_FIELD -> Known.UNSUPPORTED_FIELD
                        USER_NOT_FOUND -> Known.USER_NOT_FOUND
                        BODY_TOO_LARGE -> Known.BODY_TOO_LARGE
                        BOOKMARK_FOLDERS_UNAVAILABLE -> Known.BOOKMARK_FOLDERS_UNAVAILABLE
                        BROADCAST_NOT_FOUND -> Known.BROADCAST_NOT_FOUND
                        CHECKOUT_UNAVAILABLE -> Known.CHECKOUT_UNAVAILABLE
                        CONNECTION_CHALLENGE_EXPIRED -> Known.CONNECTION_CHALLENGE_EXPIRED
                        CONNECTION_CHALLENGE_INACTIVE -> Known.CONNECTION_CHALLENGE_INACTIVE
                        CONTRIBUTOR_NOT_FOUND -> Known.CONTRIBUTOR_NOT_FOUND
                        COVERAGE_CURSOR_GONE -> Known.COVERAGE_CURSOR_GONE
                        COVERAGE_CURSOR_UNAVAILABLE -> Known.COVERAGE_CURSOR_UNAVAILABLE
                        CURSOR_ACCOUNT_UNAVAILABLE -> Known.CURSOR_ACCOUNT_UNAVAILABLE
                        DRAFT_NOT_FOUND -> Known.DRAFT_NOT_FOUND
                        DRAW_TOO_LARGE -> Known.DRAW_TOO_LARGE
                        EXPIRED -> Known.EXPIRED
                        FAVORITERS_UNAVAILABLE -> Known.FAVORITERS_UNAVAILABLE
                        FORBIDDEN -> Known.FORBIDDEN
                        GUEST_WALLET_UNAVAILABLE -> Known.GUEST_WALLET_UNAVAILABLE
                        GUEST_WALLETS_DISABLED -> Known.GUEST_WALLETS_DISABLED
                        GUEST_WALLETS_UNAVAILABLE -> Known.GUEST_WALLETS_UNAVAILABLE
                        IDEMPOTENCY_CONFLICT -> Known.IDEMPOTENCY_CONFLICT
                        IDEMPOTENCY_IN_PROGRESS -> Known.IDEMPOTENCY_IN_PROGRESS
                        IDEMPOTENCY_KEY_CONFLICT -> Known.IDEMPOTENCY_KEY_CONFLICT
                        INVALID_BROADCAST_ID -> Known.INVALID_BROADCAST_ID
                        INVALID_COMMUNITY_ID -> Known.INVALID_COMMUNITY_ID
                        INVALID_COMMUNITY_TOPIC -> Known.INVALID_COMMUNITY_TOPIC
                        INVALID_COMPLETE_REPLIES_REQUEST -> Known.INVALID_COMPLETE_REPLIES_REQUEST
                        INVALID_CONTRIBUTOR_ALIAS -> Known.INVALID_CONTRIBUTOR_ALIAS
                        INVALID_COVERAGE_CURSOR -> Known.INVALID_COVERAGE_CURSOR
                        INVALID_COVERAGE_REQUEST -> Known.INVALID_COVERAGE_REQUEST
                        INVALID_CURSOR -> Known.INVALID_CURSOR
                        INVALID_IDEMPOTENCY_KEY -> Known.INVALID_IDEMPOTENCY_KEY
                        INVALID_JOB_FILTER -> Known.INVALID_JOB_FILTER
                        INVALID_JOB_ID -> Known.INVALID_JOB_ID
                        INVALID_LIST_ID -> Known.INVALID_LIST_ID
                        INVALID_NEWS_ID -> Known.INVALID_NEWS_ID
                        INVALID_OUTPUT_OPTIONS -> Known.INVALID_OUTPUT_OPTIONS
                        INVALID_PAYMENT_AMOUNT -> Known.INVALID_PAYMENT_AMOUNT
                        INVALID_RANGE -> Known.INVALID_RANGE
                        INVALID_REPLY_OPTIONS -> Known.INVALID_REPLY_OPTIONS
                        INVALID_SPACE_ID -> Known.INVALID_SPACE_ID
                        LIKES_UNAVAILABLE -> Known.LIKES_UNAVAILABLE
                        LIST_NOT_FOUND -> Known.LIST_NOT_FOUND
                        LOGIN_RATE_LIMITED -> Known.LOGIN_RATE_LIMITED
                        LOGIN_SERVICE_UNAVAILABLE -> Known.LOGIN_SERVICE_UNAVAILABLE
                        MISSING_IDEMPOTENCY_KEY -> Known.MISSING_IDEMPOTENCY_KEY
                        MISSING_IDS -> Known.MISSING_IDS
                        MISSING_URL -> Known.MISSING_URL
                        NEWS_NOT_FOUND -> Known.NEWS_NOT_FOUND
                        NO_CACHED_STYLE -> Known.NO_CACHED_STYLE
                        PAGINATION_STALLED -> Known.PAGINATION_STALLED
                        PASSKEY_REQUIRED -> Known.PASSKEY_REQUIRED
                        RATE_LIMITED -> Known.RATE_LIMITED
                        READ_REQUEST_TIMEOUT -> Known.READ_REQUEST_TIMEOUT
                        REPLAY_UNAVAILABLE -> Known.REPLAY_UNAVAILABLE
                        REPLIES_INCOMPLETE -> Known.REPLIES_INCOMPLETE
                        RETWEETERS_INCOMPLETE -> Known.RETWEETERS_INCOMPLETE
                        SEARCH_UNAVAILABLE -> Known.SEARCH_UNAVAILABLE
                        SPACE_CANCELED -> Known.SPACE_CANCELED
                        SPACE_NOT_ENDED -> Known.SPACE_NOT_ENDED
                        SUPPORT_MEDIA_RATE_LIMIT -> Known.SUPPORT_MEDIA_RATE_LIMIT
                        SUPPORT_REQUEST_RATE_LIMIT -> Known.SUPPORT_REQUEST_RATE_LIMIT
                        TELEGRAM_UNAVAILABLE -> Known.TELEGRAM_UNAVAILABLE
                        TOO_MANY_IDS -> Known.TOO_MANY_IDS
                        TOO_MANY_STREAMS -> Known.TOO_MANY_STREAMS
                        TOO_MANY_TWEETS -> Known.TOO_MANY_TWEETS
                        TOPUP_IN_PROGRESS -> Known.TOPUP_IN_PROGRESS
                        UNKNOWN_FIELD -> Known.UNKNOWN_FIELD
                        UNSUPPORTED_MEDIA_COMBINATION -> Known.UNSUPPORTED_MEDIA_COMBINATION
                        UNSUPPORTED_MEDIA_TYPE -> Known.UNSUPPORTED_MEDIA_TYPE
                        WEBHOOK_INACTIVE -> Known.WEBHOOK_INACTIVE
                        WRITE_TRACKING_UNAVAILABLE -> Known.WRITE_TRACKING_UNAVAILABLE
                        X_WRITE_UNCONFIRMED -> Known.X_WRITE_UNCONFIRMED
                        X_ACCOUNT_FEATURE_REQUIRED -> Known.X_ACCOUNT_FEATURE_REQUIRED
                        X_ACCOUNT_PROTECTED -> Known.X_ACCOUNT_PROTECTED
                        X_ACCOUNT_SUSPENDED -> Known.X_ACCOUNT_SUSPENDED
                        X_API_RATE_LIMITED -> Known.X_API_RATE_LIMITED
                        X_API_UNAVAILABLE -> Known.X_API_UNAVAILABLE
                        X_API_UNAUTHORIZED -> Known.X_API_UNAUTHORIZED
                        X_AUTH_FAILURE -> Known.X_AUTH_FAILURE
                        X_AUTOMATION_REFUSED -> Known.X_AUTOMATION_REFUSED
                        X_COMMUNITY_CREATION_CLOSED -> Known.X_COMMUNITY_CREATION_CLOSED
                        X_COMMUNITY_NOT_JOINED -> Known.X_COMMUNITY_NOT_JOINED
                        X_COMMUNITY_NOT_SELECTABLE -> Known.X_COMMUNITY_NOT_SELECTABLE
                        X_COMMUNITY_POST_PUBLIC -> Known.X_COMMUNITY_POST_PUBLIC
                        X_COMMUNITY_POST_REMOVED -> Known.X_COMMUNITY_POST_REMOVED
                        X_CONTENT_TOO_LONG -> Known.X_CONTENT_TOO_LONG
                        X_DAILY_LIMIT -> Known.X_DAILY_LIMIT
                        X_DM_NOT_ALLOWED -> Known.X_DM_NOT_ALLOWED
                        X_DM_NOT_DELETED -> Known.X_DM_NOT_DELETED
                        X_DM_NOT_SENT -> Known.X_DM_NOT_SENT
                        X_DUPLICATE_ACTION -> Known.X_DUPLICATE_ACTION
                        X_LOGIN_AUTH_FAILED -> Known.X_LOGIN_AUTH_FAILED
                        X_LOGIN_CHALLENGE -> Known.X_LOGIN_CHALLENGE
                        X_LOGIN_DENIED -> Known.X_LOGIN_DENIED
                        X_LOGIN_FAILED -> Known.X_LOGIN_FAILED
                        X_LOGIN_PROXY_ERROR -> Known.X_LOGIN_PROXY_ERROR
                        X_LOGIN_RATE_LIMITED -> Known.X_LOGIN_RATE_LIMITED
                        X_LOGIN_SERVICE_UNAVAILABLE -> Known.X_LOGIN_SERVICE_UNAVAILABLE
                        X_LOGIN_SUSPENDED -> Known.X_LOGIN_SUSPENDED
                        X_IMAGE_INVALID -> Known.X_IMAGE_INVALID
                        X_MEDIA_REJECTED -> Known.X_MEDIA_REJECTED
                        X_POST_NOT_SENT -> Known.X_POST_NOT_SENT
                        X_RATE_LIMITED -> Known.X_RATE_LIMITED
                        X_REJECTED -> Known.X_REJECTED
                        X_REPLY_NOT_ALLOWED -> Known.X_REPLY_NOT_ALLOWED
                        X_REPLY_TARGET_UNAVAILABLE -> Known.X_REPLY_TARGET_UNAVAILABLE
                        X_TARGET_NOT_FOUND -> Known.X_TARGET_NOT_FOUND
                        X_TRANSIENT_ERROR -> Known.X_TRANSIENT_ERROR
                        X_USER_LOOKUP_FAILED -> Known.X_USER_LOOKUP_FAILED
                        X_VIDEO_TOO_LARGE -> Known.X_VIDEO_TOO_LARGE
                        X_WRITE_AMBIGUOUS -> Known.X_WRITE_AMBIGUOUS
                        X_WRITE_FAILED -> Known.X_WRITE_FAILED
                        else -> throw XTwitterScraperInvalidDataException("Unknown Code: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
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
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Code = apply {
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

                    return other is Code && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /** Returns this class instance's raw value. */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val API_ERROR = of("api_error")

                    @JvmField val AUTHENTICATION_ERROR = of("authentication_error")

                    @JvmField val BILLING_ERROR = of("billing_error")

                    @JvmField val DEPENDENCY_ERROR = of("dependency_error")

                    @JvmField val INVALID_REQUEST_ERROR = of("invalid_request_error")

                    @JvmField val PERMISSION_ERROR = of("permission_error")

                    @JvmField val RATE_LIMIT_ERROR = of("rate_limit_error")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    API_ERROR,
                    AUTHENTICATION_ERROR,
                    BILLING_ERROR,
                    DEPENDENCY_ERROR,
                    INVALID_REQUEST_ERROR,
                    PERMISSION_ERROR,
                    RATE_LIMIT_ERROR,
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    API_ERROR,
                    AUTHENTICATION_ERROR,
                    BILLING_ERROR,
                    DEPENDENCY_ERROR,
                    INVALID_REQUEST_ERROR,
                    PERMISSION_ERROR,
                    RATE_LIMIT_ERROR,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 */
                fun value(): Value =
                    when (this) {
                        API_ERROR -> Value.API_ERROR
                        AUTHENTICATION_ERROR -> Value.AUTHENTICATION_ERROR
                        BILLING_ERROR -> Value.BILLING_ERROR
                        DEPENDENCY_ERROR -> Value.DEPENDENCY_ERROR
                        INVALID_REQUEST_ERROR -> Value.INVALID_REQUEST_ERROR
                        PERMISSION_ERROR -> Value.PERMISSION_ERROR
                        RATE_LIMIT_ERROR -> Value.RATE_LIMIT_ERROR
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        API_ERROR -> Known.API_ERROR
                        AUTHENTICATION_ERROR -> Known.AUTHENTICATION_ERROR
                        BILLING_ERROR -> Known.BILLING_ERROR
                        DEPENDENCY_ERROR -> Known.DEPENDENCY_ERROR
                        INVALID_REQUEST_ERROR -> Known.INVALID_REQUEST_ERROR
                        PERMISSION_ERROR -> Known.PERMISSION_ERROR
                        RATE_LIMIT_ERROR -> Known.RATE_LIMIT_ERROR
                        else -> throw XTwitterScraperInvalidDataException("Unknown Type: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
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
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Type = apply {
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

                    return other is Type && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is StructuredError &&
                    code == other.code &&
                    message == other.message &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(code, message, type, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "StructuredError{code=$code, message=$message, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    /** 1 unknown name in fields or omit, with the name it most likely meant. */
    class FieldError
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val code: JsonField<String>,
        private val field: JsonField<String>,
        private val message: JsonField<String>,
        private val path: JsonField<Path>,
        private val suggestion: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
            @JsonProperty("field") @ExcludeMissing field: JsonField<String> = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
            @JsonProperty("path") @ExcludeMissing path: JsonField<Path> = JsonMissing.of(),
            @JsonProperty("suggestion")
            @ExcludeMissing
            suggestion: JsonField<String> = JsonMissing.of(),
        ) : this(code, field, message, path, suggestion, mutableMapOf())

        /**
         * Names the problem, which is unknown_field.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun code(): String = code.getRequired("code")

        /**
         * The name as the request wrote it.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun field(): String = field.getRequired("field")

        /**
         * What to send instead.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun message(): String = message.getRequired("message")

        /**
         * The parameter that held the name.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun path(): Path = path.getRequired("path")

        /**
         * The closest valid name, when 1 is close.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun suggestion(): Optional<String> = suggestion.getOptional("suggestion")

        /**
         * Returns the raw JSON value of [code].
         *
         * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

        /**
         * Returns the raw JSON value of [field].
         *
         * Unlike [field], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("field") @ExcludeMissing fun _field(): JsonField<String> = field

        /**
         * Returns the raw JSON value of [message].
         *
         * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

        /**
         * Returns the raw JSON value of [path].
         *
         * Unlike [path], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("path") @ExcludeMissing fun _path(): JsonField<Path> = path

        /**
         * Returns the raw JSON value of [suggestion].
         *
         * Unlike [suggestion], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("suggestion")
        @ExcludeMissing
        fun _suggestion(): JsonField<String> = suggestion

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
             * Returns a mutable builder for constructing an instance of [FieldError].
             *
             * The following fields are required:
             * ```java
             * .code()
             * .field()
             * .message()
             * .path()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FieldError]. */
        class Builder internal constructor() {

            private var code: JsonField<String>? = null
            private var field: JsonField<String>? = null
            private var message: JsonField<String>? = null
            private var path: JsonField<Path>? = null
            private var suggestion: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fieldError: FieldError) = apply {
                code = fieldError.code
                field = fieldError.field
                message = fieldError.message
                path = fieldError.path
                suggestion = fieldError.suggestion
                additionalProperties = fieldError.additionalProperties.toMutableMap()
            }

            /** Names the problem, which is unknown_field. */
            fun code(code: String) = code(JsonField.of(code))

            /** Sets [Builder.code] to an arbitrary JSON value. */
            fun code(code: JsonField<String>) = apply { this.code = code }

            /** The name as the request wrote it. */
            fun field(field: String) = field(JsonField.of(field))

            /** Sets [Builder.field] to an arbitrary JSON value. */
            fun field(field: JsonField<String>) = apply { this.field = field }

            /** What to send instead. */
            fun message(message: String) = message(JsonField.of(message))

            /** Sets [Builder.message] to an arbitrary JSON value. */
            fun message(message: JsonField<String>) = apply { this.message = message }

            /** The parameter that held the name. */
            fun path(path: Path) = path(JsonField.of(path))

            /** Sets [Builder.path] to an arbitrary JSON value. */
            fun path(path: JsonField<Path>) = apply { this.path = path }

            /** The closest valid name, when 1 is close. */
            fun suggestion(suggestion: String) = suggestion(JsonField.of(suggestion))

            /** Sets [Builder.suggestion] to an arbitrary JSON value. */
            fun suggestion(suggestion: JsonField<String>) = apply { this.suggestion = suggestion }

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
             * Returns an immutable instance of [FieldError].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .code()
             * .field()
             * .message()
             * .path()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): FieldError =
                FieldError(
                    checkRequired("code", code),
                    checkRequired("field", field),
                    checkRequired("message", message),
                    checkRequired("path", path),
                    suggestion,
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
        fun validate(): FieldError = apply {
            if (validated) {
                return@apply
            }

            code()
            field()
            message()
            path().validate()
            suggestion()
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
            (if (code.asKnown().isPresent) 1 else 0) +
                (if (field.asKnown().isPresent) 1 else 0) +
                (if (message.asKnown().isPresent) 1 else 0) +
                (path.asKnown().getOrNull()?.validity() ?: 0) +
                (if (suggestion.asKnown().isPresent) 1 else 0)

        /** The parameter that held the name. */
        class Path @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val QUERY_FIELDS = of("query.fields")

                @JvmField val QUERY_OMIT = of("query.omit")

                @JvmStatic fun of(value: String) = Path(JsonField.of(value))
            }

            /** An enum containing [Path]'s known values. */
            enum class Known {
                QUERY_FIELDS,
                QUERY_OMIT,
            }

            /** An enum containing [Path]'s known values, as well as an [_UNKNOWN] member. */
            enum class Value {
                QUERY_FIELDS,
                QUERY_OMIT,
                /** An enum member indicating that [Path] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if unknown.
             */
            fun value(): Value =
                when (this) {
                    QUERY_FIELDS -> Value.QUERY_FIELDS
                    QUERY_OMIT -> Value.QUERY_OMIT
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
                    QUERY_FIELDS -> Known.QUERY_FIELDS
                    QUERY_OMIT -> Known.QUERY_OMIT
                    else -> throw XTwitterScraperInvalidDataException("Unknown Path: $value")
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

            /** Validates that this value is a known member. */
            fun validate(): Path = apply {
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

                return other is Path && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FieldError &&
                code == other.code &&
                field == other.field &&
                message == other.message &&
                path == other.path &&
                suggestion == other.suggestion &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(code, field, message, path, suggestion, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FieldError{code=$code, field=$field, message=$message, path=$path, suggestion=$suggestion, additionalProperties=$additionalProperties}"
    }

    /** With insufficient_scope, the scope the API key needs for this route. */
    class RequiredScope @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val WRITE = of("write")

            @JvmField val MONITORS = of("monitors")

            @JvmField val EXPORTS = of("exports")

            @JvmField val BILLING = of("billing")

            @JvmField val FULL = of("full")

            @JvmStatic fun of(value: String) = RequiredScope(JsonField.of(value))
        }

        /** An enum containing [RequiredScope]'s known values. */
        enum class Known {
            WRITE,
            MONITORS,
            EXPORTS,
            BILLING,
            FULL,
        }

        /** An enum containing [RequiredScope]'s known values, as well as an [_UNKNOWN] member. */
        enum class Value {
            WRITE,
            MONITORS,
            EXPORTS,
            BILLING,
            FULL,
            /**
             * An enum member indicating that [RequiredScope] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if unknown.
         */
        fun value(): Value =
            when (this) {
                WRITE -> Value.WRITE
                MONITORS -> Value.MONITORS
                EXPORTS -> Value.EXPORTS
                BILLING -> Value.BILLING
                FULL -> Value.FULL
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
                WRITE -> Known.WRITE
                MONITORS -> Known.MONITORS
                EXPORTS -> Known.EXPORTS
                BILLING -> Known.BILLING
                FULL -> Known.FULL
                else -> throw XTwitterScraperInvalidDataException("Unknown RequiredScope: $value")
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

        /** Validates that this value is a known member. */
        fun validate(): RequiredScope = apply {
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

            return other is RequiredScope && value == other.value
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
            message == other.message &&
            reason == other.reason &&
            retryAfter == other.retryAfter &&
            retryAfterMs == other.retryAfterMs &&
            requiredScope == other.requiredScope &&
            allowedFields == other.allowedFields &&
            fieldErrors == other.fieldErrors &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            error,
            message,
            reason,
            retryAfter,
            retryAfterMs,
            requiredScope,
            allowedFields,
            fieldErrors,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Error{error=$error, message=$message, reason=$reason, retryAfter=$retryAfter, retryAfterMs=$retryAfterMs, requiredScope=$requiredScope, allowedFields=$allowedFields, fieldErrors=$fieldErrors, additionalProperties=$additionalProperties}"
}
