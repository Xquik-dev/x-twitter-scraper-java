// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accountconnectionattempts

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
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.getOrThrow
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The connection is still in progress. */
@JsonDeserialize(using = AccountConnectionAttemptRetrieveResponse.Deserializer::class)
@JsonSerialize(using = AccountConnectionAttemptRetrieveResponse.Serializer::class)
class AccountConnectionAttemptRetrieveResponse
private constructor(
    private val xAccountConnectionAttemptPending: XAccountConnectionAttemptPending? = null,
    private val xAccountConnectionAttemptSuccess: XAccountConnectionAttemptSuccess? = null,
    private val xAccountConnectionAttemptFailed: XAccountConnectionAttemptFailed? = null,
    private val xAccountConnectionChallenge: XAccountConnectionChallenge? = null,
    private val _json: JsonValue? = null,
) {

    /** The connection is still in progress. */
    fun xAccountConnectionAttemptPending(): Optional<XAccountConnectionAttemptPending> =
        Optional.ofNullable(xAccountConnectionAttemptPending)

    /** The account connected successfully. */
    fun xAccountConnectionAttemptSuccess(): Optional<XAccountConnectionAttemptSuccess> =
        Optional.ofNullable(xAccountConnectionAttemptSuccess)

    /** The connection reached a final failure. */
    fun xAccountConnectionAttemptFailed(): Optional<XAccountConnectionAttemptFailed> =
        Optional.ofNullable(xAccountConnectionAttemptFailed)

    /**
     * Resumable account connection challenge. Submit the email code to finish the same connection
     * attempt.
     */
    fun xAccountConnectionChallenge(): Optional<XAccountConnectionChallenge> =
        Optional.ofNullable(xAccountConnectionChallenge)

    fun isXAccountConnectionAttemptPending(): Boolean = xAccountConnectionAttemptPending != null

    fun isXAccountConnectionAttemptSuccess(): Boolean = xAccountConnectionAttemptSuccess != null

    fun isXAccountConnectionAttemptFailed(): Boolean = xAccountConnectionAttemptFailed != null

    fun isXAccountConnectionChallenge(): Boolean = xAccountConnectionChallenge != null

    /** The connection is still in progress. */
    fun asXAccountConnectionAttemptPending(): XAccountConnectionAttemptPending =
        xAccountConnectionAttemptPending.getOrThrow("xAccountConnectionAttemptPending")

    /** The account connected successfully. */
    fun asXAccountConnectionAttemptSuccess(): XAccountConnectionAttemptSuccess =
        xAccountConnectionAttemptSuccess.getOrThrow("xAccountConnectionAttemptSuccess")

    /** The connection reached a final failure. */
    fun asXAccountConnectionAttemptFailed(): XAccountConnectionAttemptFailed =
        xAccountConnectionAttemptFailed.getOrThrow("xAccountConnectionAttemptFailed")

    /**
     * Resumable account connection challenge. Submit the email code to finish the same connection
     * attempt.
     */
    fun asXAccountConnectionChallenge(): XAccountConnectionChallenge =
        xAccountConnectionChallenge.getOrThrow("xAccountConnectionChallenge")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.x_twitter_scraper.api.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = accountConnectionAttemptRetrieveResponse.accept(new AccountConnectionAttemptRetrieveResponse.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitXAccountConnectionAttemptPending(XAccountConnectionAttemptPending xAccountConnectionAttemptPending) {
     *         return Optional.of(xAccountConnectionAttemptPending.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws XTwitterScraperInvalidDataException if [Visitor.unknown] is not overridden in
     *   [visitor] and the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            xAccountConnectionAttemptPending != null ->
                visitor.visitXAccountConnectionAttemptPending(xAccountConnectionAttemptPending)
            xAccountConnectionAttemptSuccess != null ->
                visitor.visitXAccountConnectionAttemptSuccess(xAccountConnectionAttemptSuccess)
            xAccountConnectionAttemptFailed != null ->
                visitor.visitXAccountConnectionAttemptFailed(xAccountConnectionAttemptFailed)
            xAccountConnectionChallenge != null ->
                visitor.visitXAccountConnectionChallenge(xAccountConnectionChallenge)
            else -> visitor.unknown(_json)
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
    fun validate(): AccountConnectionAttemptRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitXAccountConnectionAttemptPending(
                    xAccountConnectionAttemptPending: XAccountConnectionAttemptPending
                ) {
                    xAccountConnectionAttemptPending.validate()
                }

                override fun visitXAccountConnectionAttemptSuccess(
                    xAccountConnectionAttemptSuccess: XAccountConnectionAttemptSuccess
                ) {
                    xAccountConnectionAttemptSuccess.validate()
                }

                override fun visitXAccountConnectionAttemptFailed(
                    xAccountConnectionAttemptFailed: XAccountConnectionAttemptFailed
                ) {
                    xAccountConnectionAttemptFailed.validate()
                }

                override fun visitXAccountConnectionChallenge(
                    xAccountConnectionChallenge: XAccountConnectionChallenge
                ) {
                    xAccountConnectionChallenge.validate()
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

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitXAccountConnectionAttemptPending(
                    xAccountConnectionAttemptPending: XAccountConnectionAttemptPending
                ) = xAccountConnectionAttemptPending.validity()

                override fun visitXAccountConnectionAttemptSuccess(
                    xAccountConnectionAttemptSuccess: XAccountConnectionAttemptSuccess
                ) = xAccountConnectionAttemptSuccess.validity()

                override fun visitXAccountConnectionAttemptFailed(
                    xAccountConnectionAttemptFailed: XAccountConnectionAttemptFailed
                ) = xAccountConnectionAttemptFailed.validity()

                override fun visitXAccountConnectionChallenge(
                    xAccountConnectionChallenge: XAccountConnectionChallenge
                ) = xAccountConnectionChallenge.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountConnectionAttemptRetrieveResponse &&
            xAccountConnectionAttemptPending == other.xAccountConnectionAttemptPending &&
            xAccountConnectionAttemptSuccess == other.xAccountConnectionAttemptSuccess &&
            xAccountConnectionAttemptFailed == other.xAccountConnectionAttemptFailed &&
            xAccountConnectionChallenge == other.xAccountConnectionChallenge
    }

    override fun hashCode(): Int =
        Objects.hash(
            xAccountConnectionAttemptPending,
            xAccountConnectionAttemptSuccess,
            xAccountConnectionAttemptFailed,
            xAccountConnectionChallenge,
        )

    override fun toString(): String =
        when {
            xAccountConnectionAttemptPending != null ->
                "AccountConnectionAttemptRetrieveResponse{xAccountConnectionAttemptPending=$xAccountConnectionAttemptPending}"
            xAccountConnectionAttemptSuccess != null ->
                "AccountConnectionAttemptRetrieveResponse{xAccountConnectionAttemptSuccess=$xAccountConnectionAttemptSuccess}"
            xAccountConnectionAttemptFailed != null ->
                "AccountConnectionAttemptRetrieveResponse{xAccountConnectionAttemptFailed=$xAccountConnectionAttemptFailed}"
            xAccountConnectionChallenge != null ->
                "AccountConnectionAttemptRetrieveResponse{xAccountConnectionChallenge=$xAccountConnectionChallenge}"
            _json != null -> "AccountConnectionAttemptRetrieveResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AccountConnectionAttemptRetrieveResponse")
        }

    companion object {

        /** The connection is still in progress. */
        @JvmStatic
        fun ofXAccountConnectionAttemptPending(
            xAccountConnectionAttemptPending: XAccountConnectionAttemptPending
        ) =
            AccountConnectionAttemptRetrieveResponse(
                xAccountConnectionAttemptPending = xAccountConnectionAttemptPending
            )

        /** The account connected successfully. */
        @JvmStatic
        fun ofXAccountConnectionAttemptSuccess(
            xAccountConnectionAttemptSuccess: XAccountConnectionAttemptSuccess
        ) =
            AccountConnectionAttemptRetrieveResponse(
                xAccountConnectionAttemptSuccess = xAccountConnectionAttemptSuccess
            )

        /** The connection reached a final failure. */
        @JvmStatic
        fun ofXAccountConnectionAttemptFailed(
            xAccountConnectionAttemptFailed: XAccountConnectionAttemptFailed
        ) =
            AccountConnectionAttemptRetrieveResponse(
                xAccountConnectionAttemptFailed = xAccountConnectionAttemptFailed
            )

        /**
         * Resumable account connection challenge. Submit the email code to finish the same
         * connection attempt.
         */
        @JvmStatic
        fun ofXAccountConnectionChallenge(
            xAccountConnectionChallenge: XAccountConnectionChallenge
        ) =
            AccountConnectionAttemptRetrieveResponse(
                xAccountConnectionChallenge = xAccountConnectionChallenge
            )
    }

    /**
     * An interface that defines how to map each variant of
     * [AccountConnectionAttemptRetrieveResponse] to a value of type [T].
     */
    interface Visitor<out T> {

        /** The connection is still in progress. */
        fun visitXAccountConnectionAttemptPending(
            xAccountConnectionAttemptPending: XAccountConnectionAttemptPending
        ): T

        /** The account connected successfully. */
        fun visitXAccountConnectionAttemptSuccess(
            xAccountConnectionAttemptSuccess: XAccountConnectionAttemptSuccess
        ): T

        /** The connection reached a final failure. */
        fun visitXAccountConnectionAttemptFailed(
            xAccountConnectionAttemptFailed: XAccountConnectionAttemptFailed
        ): T

        /**
         * Resumable account connection challenge. Submit the email code to finish the same
         * connection attempt.
         */
        fun visitXAccountConnectionChallenge(
            xAccountConnectionChallenge: XAccountConnectionChallenge
        ): T

        /**
         * Maps an unknown variant of [AccountConnectionAttemptRetrieveResponse] to a value of type
         * [T].
         *
         * An instance of [AccountConnectionAttemptRetrieveResponse] can contain an unknown variant
         * if it was deserialized from data that doesn't match any known variant. For example, if
         * the SDK is on an older version than the API, then the API may respond with new variants
         * that the SDK is unaware of.
         *
         * @throws XTwitterScraperInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw XTwitterScraperInvalidDataException(
                "Unknown AccountConnectionAttemptRetrieveResponse: $json"
            )
        }
    }

    internal class Deserializer :
        BaseDeserializer<AccountConnectionAttemptRetrieveResponse>(
            AccountConnectionAttemptRetrieveResponse::class
        ) {

        override fun ObjectCodec.deserialize(
            node: JsonNode
        ): AccountConnectionAttemptRetrieveResponse {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<XAccountConnectionAttemptPending>())
                            ?.let {
                                AccountConnectionAttemptRetrieveResponse(
                                    xAccountConnectionAttemptPending = it,
                                    _json = json,
                                )
                            },
                        tryDeserialize(node, jacksonTypeRef<XAccountConnectionAttemptSuccess>())
                            ?.let {
                                AccountConnectionAttemptRetrieveResponse(
                                    xAccountConnectionAttemptSuccess = it,
                                    _json = json,
                                )
                            },
                        tryDeserialize(node, jacksonTypeRef<XAccountConnectionAttemptFailed>())
                            ?.let {
                                AccountConnectionAttemptRetrieveResponse(
                                    xAccountConnectionAttemptFailed = it,
                                    _json = json,
                                )
                            },
                        tryDeserialize(node, jacksonTypeRef<XAccountConnectionChallenge>())?.let {
                            AccountConnectionAttemptRetrieveResponse(
                                xAccountConnectionChallenge = it,
                                _json = json,
                            )
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> AccountConnectionAttemptRetrieveResponse(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<AccountConnectionAttemptRetrieveResponse>(
            AccountConnectionAttemptRetrieveResponse::class
        ) {

        override fun serialize(
            value: AccountConnectionAttemptRetrieveResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.xAccountConnectionAttemptPending != null ->
                    generator.writeObject(value.xAccountConnectionAttemptPending)
                value.xAccountConnectionAttemptSuccess != null ->
                    generator.writeObject(value.xAccountConnectionAttemptSuccess)
                value.xAccountConnectionAttemptFailed != null ->
                    generator.writeObject(value.xAccountConnectionAttemptFailed)
                value.xAccountConnectionChallenge != null ->
                    generator.writeObject(value.xAccountConnectionChallenge)
                value._json != null -> generator.writeObject(value._json)
                else ->
                    throw IllegalStateException("Invalid AccountConnectionAttemptRetrieveResponse")
            }
        }
    }

    /** The connection is still in progress. */
    class XAccountConnectionAttemptPending
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val object_: JsonValue,
        private val pollAfterMs: JsonField<Long>,
        private val status: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
            @JsonProperty("pollAfterMs")
            @ExcludeMissing
            pollAfterMs: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonValue = JsonMissing.of(),
        ) : this(id, object_, pollAfterMs, status, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("x_account_connection_attempt")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun pollAfterMs(): Long = pollAfterMs.getRequired("pollAfterMs")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("pending")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonValue = status

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [pollAfterMs].
         *
         * Unlike [pollAfterMs], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("pollAfterMs")
        @ExcludeMissing
        fun _pollAfterMs(): JsonField<Long> = pollAfterMs

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
             * [XAccountConnectionAttemptPending].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .pollAfterMs()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [XAccountConnectionAttemptPending]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var object_: JsonValue = JsonValue.from("x_account_connection_attempt")
            private var pollAfterMs: JsonField<Long>? = null
            private var status: JsonValue = JsonValue.from("pending")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(xAccountConnectionAttemptPending: XAccountConnectionAttemptPending) =
                apply {
                    id = xAccountConnectionAttemptPending.id
                    object_ = xAccountConnectionAttemptPending.object_
                    pollAfterMs = xAccountConnectionAttemptPending.pollAfterMs
                    status = xAccountConnectionAttemptPending.status
                    additionalProperties =
                        xAccountConnectionAttemptPending.additionalProperties.toMutableMap()
                }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("x_account_connection_attempt")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun object_(object_: JsonValue) = apply { this.object_ = object_ }

            fun pollAfterMs(pollAfterMs: Long) = pollAfterMs(JsonField.of(pollAfterMs))

            /**
             * Sets [Builder.pollAfterMs] to an arbitrary JSON value.
             *
             * You should usually call [Builder.pollAfterMs] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun pollAfterMs(pollAfterMs: JsonField<Long>) = apply { this.pollAfterMs = pollAfterMs }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("pending")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonValue) = apply { this.status = status }

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
             * Returns an immutable instance of [XAccountConnectionAttemptPending].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .pollAfterMs()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): XAccountConnectionAttemptPending =
                XAccountConnectionAttemptPending(
                    checkRequired("id", id),
                    object_,
                    checkRequired("pollAfterMs", pollAfterMs),
                    status,
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
        fun validate(): XAccountConnectionAttemptPending = apply {
            if (validated) {
                return@apply
            }

            id()
            _object_().let {
                if (it != JsonValue.from("x_account_connection_attempt")) {
                    throw XTwitterScraperInvalidDataException("'object_' is invalid, received $it")
                }
            }
            pollAfterMs()
            _status().let {
                if (it != JsonValue.from("pending")) {
                    throw XTwitterScraperInvalidDataException("'status' is invalid, received $it")
                }
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

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                object_.let { if (it == JsonValue.from("x_account_connection_attempt")) 1 else 0 } +
                (if (pollAfterMs.asKnown().isPresent) 1 else 0) +
                status.let { if (it == JsonValue.from("pending")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is XAccountConnectionAttemptPending &&
                id == other.id &&
                object_ == other.object_ &&
                pollAfterMs == other.pollAfterMs &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, object_, pollAfterMs, status, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "XAccountConnectionAttemptPending{id=$id, object_=$object_, pollAfterMs=$pollAfterMs, status=$status, additionalProperties=$additionalProperties}"
    }

    /** The account connected successfully. */
    class XAccountConnectionAttemptSuccess
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val object_: JsonValue,
        private val status: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonValue = JsonMissing.of(),
        ) : this(id, object_, status, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("x_account_connection_attempt")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("success")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonValue = status

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
             * [XAccountConnectionAttemptSuccess].
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [XAccountConnectionAttemptSuccess]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var object_: JsonValue = JsonValue.from("x_account_connection_attempt")
            private var status: JsonValue = JsonValue.from("success")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(xAccountConnectionAttemptSuccess: XAccountConnectionAttemptSuccess) =
                apply {
                    id = xAccountConnectionAttemptSuccess.id
                    object_ = xAccountConnectionAttemptSuccess.object_
                    status = xAccountConnectionAttemptSuccess.status
                    additionalProperties =
                        xAccountConnectionAttemptSuccess.additionalProperties.toMutableMap()
                }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("x_account_connection_attempt")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun object_(object_: JsonValue) = apply { this.object_ = object_ }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("success")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonValue) = apply { this.status = status }

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
             * Returns an immutable instance of [XAccountConnectionAttemptSuccess].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): XAccountConnectionAttemptSuccess =
                XAccountConnectionAttemptSuccess(
                    checkRequired("id", id),
                    object_,
                    status,
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
        fun validate(): XAccountConnectionAttemptSuccess = apply {
            if (validated) {
                return@apply
            }

            id()
            _object_().let {
                if (it != JsonValue.from("x_account_connection_attempt")) {
                    throw XTwitterScraperInvalidDataException("'object_' is invalid, received $it")
                }
            }
            _status().let {
                if (it != JsonValue.from("success")) {
                    throw XTwitterScraperInvalidDataException("'status' is invalid, received $it")
                }
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

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                object_.let { if (it == JsonValue.from("x_account_connection_attempt")) 1 else 0 } +
                status.let { if (it == JsonValue.from("success")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is XAccountConnectionAttemptSuccess &&
                id == other.id &&
                object_ == other.object_ &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, object_, status, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "XAccountConnectionAttemptSuccess{id=$id, object_=$object_, status=$status, additionalProperties=$additionalProperties}"
    }

    /** The connection reached a final failure. */
    class XAccountConnectionAttemptFailed
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val error: JsonField<String>,
        private val object_: JsonValue,
        private val retryable: JsonField<Boolean>,
        private val status: JsonValue,
        private val reason: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("error") @ExcludeMissing error: JsonField<String> = JsonMissing.of(),
            @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
            @JsonProperty("retryable")
            @ExcludeMissing
            retryable: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonValue = JsonMissing.of(),
            @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
        ) : this(id, error, object_, retryable, status, reason, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun error(): String = error.getRequired("error")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("x_account_connection_attempt")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun retryable(): Boolean = retryable.getRequired("retryable")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("failed")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonValue = status

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun reason(): Optional<String> = reason.getOptional("reason")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [error].
         *
         * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<String> = error

        /**
         * Returns the raw JSON value of [retryable].
         *
         * Unlike [retryable], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("retryable") @ExcludeMissing fun _retryable(): JsonField<Boolean> = retryable

        /**
         * Returns the raw JSON value of [reason].
         *
         * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

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
             * [XAccountConnectionAttemptFailed].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .error()
             * .retryable()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [XAccountConnectionAttemptFailed]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var error: JsonField<String>? = null
            private var object_: JsonValue = JsonValue.from("x_account_connection_attempt")
            private var retryable: JsonField<Boolean>? = null
            private var status: JsonValue = JsonValue.from("failed")
            private var reason: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(xAccountConnectionAttemptFailed: XAccountConnectionAttemptFailed) =
                apply {
                    id = xAccountConnectionAttemptFailed.id
                    error = xAccountConnectionAttemptFailed.error
                    object_ = xAccountConnectionAttemptFailed.object_
                    retryable = xAccountConnectionAttemptFailed.retryable
                    status = xAccountConnectionAttemptFailed.status
                    reason = xAccountConnectionAttemptFailed.reason
                    additionalProperties =
                        xAccountConnectionAttemptFailed.additionalProperties.toMutableMap()
                }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun error(error: String) = error(JsonField.of(error))

            /**
             * Sets [Builder.error] to an arbitrary JSON value.
             *
             * You should usually call [Builder.error] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun error(error: JsonField<String>) = apply { this.error = error }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("x_account_connection_attempt")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun object_(object_: JsonValue) = apply { this.object_ = object_ }

            fun retryable(retryable: Boolean) = retryable(JsonField.of(retryable))

            /**
             * Sets [Builder.retryable] to an arbitrary JSON value.
             *
             * You should usually call [Builder.retryable] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun retryable(retryable: JsonField<Boolean>) = apply { this.retryable = retryable }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("failed")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonValue) = apply { this.status = status }

            fun reason(reason: String) = reason(JsonField.of(reason))

            /**
             * Sets [Builder.reason] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reason] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun reason(reason: JsonField<String>) = apply { this.reason = reason }

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
             * Returns an immutable instance of [XAccountConnectionAttemptFailed].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .error()
             * .retryable()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): XAccountConnectionAttemptFailed =
                XAccountConnectionAttemptFailed(
                    checkRequired("id", id),
                    checkRequired("error", error),
                    object_,
                    checkRequired("retryable", retryable),
                    status,
                    reason,
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
        fun validate(): XAccountConnectionAttemptFailed = apply {
            if (validated) {
                return@apply
            }

            id()
            error()
            _object_().let {
                if (it != JsonValue.from("x_account_connection_attempt")) {
                    throw XTwitterScraperInvalidDataException("'object_' is invalid, received $it")
                }
            }
            retryable()
            _status().let {
                if (it != JsonValue.from("failed")) {
                    throw XTwitterScraperInvalidDataException("'status' is invalid, received $it")
                }
            }
            reason()
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
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (error.asKnown().isPresent) 1 else 0) +
                object_.let { if (it == JsonValue.from("x_account_connection_attempt")) 1 else 0 } +
                (if (retryable.asKnown().isPresent) 1 else 0) +
                status.let { if (it == JsonValue.from("failed")) 1 else 0 } +
                (if (reason.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is XAccountConnectionAttemptFailed &&
                id == other.id &&
                error == other.error &&
                object_ == other.object_ &&
                retryable == other.retryable &&
                status == other.status &&
                reason == other.reason &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, error, object_, retryable, status, reason, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "XAccountConnectionAttemptFailed{id=$id, error=$error, object_=$object_, retryable=$retryable, status=$status, reason=$reason, additionalProperties=$additionalProperties}"
    }

    /**
     * Resumable account connection challenge. Submit the email code to finish the same connection
     * attempt.
     */
    class XAccountConnectionChallenge
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val expiresAt: JsonField<OffsetDateTime>,
        private val message: JsonField<String>,
        private val object_: JsonField<Object>,
        private val status: JsonField<Status>,
        private val username: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("expiresAt")
            @ExcludeMissing
            expiresAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
            @JsonProperty("object") @ExcludeMissing object_: JsonField<Object> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("username") @ExcludeMissing username: JsonField<String> = JsonMissing.of(),
        ) : this(id, expiresAt, message, object_, status, username, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun expiresAt(): OffsetDateTime = expiresAt.getRequired("expiresAt")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun message(): String = message.getRequired("message")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun object_(): Object = object_.getRequired("object")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun username(): String = username.getRequired("username")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [expiresAt].
         *
         * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("expiresAt")
        @ExcludeMissing
        fun _expiresAt(): JsonField<OffsetDateTime> = expiresAt

        /**
         * Returns the raw JSON value of [message].
         *
         * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

        /**
         * Returns the raw JSON value of [object_].
         *
         * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [username].
         *
         * Unlike [username], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

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
             * [XAccountConnectionChallenge].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .expiresAt()
             * .message()
             * .object_()
             * .status()
             * .username()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [XAccountConnectionChallenge]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var expiresAt: JsonField<OffsetDateTime>? = null
            private var message: JsonField<String>? = null
            private var object_: JsonField<Object>? = null
            private var status: JsonField<Status>? = null
            private var username: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(xAccountConnectionChallenge: XAccountConnectionChallenge) = apply {
                id = xAccountConnectionChallenge.id
                expiresAt = xAccountConnectionChallenge.expiresAt
                message = xAccountConnectionChallenge.message
                object_ = xAccountConnectionChallenge.object_
                status = xAccountConnectionChallenge.status
                username = xAccountConnectionChallenge.username
                additionalProperties =
                    xAccountConnectionChallenge.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun expiresAt(expiresAt: OffsetDateTime) = expiresAt(JsonField.of(expiresAt))

            /**
             * Sets [Builder.expiresAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expiresAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expiresAt(expiresAt: JsonField<OffsetDateTime>) = apply {
                this.expiresAt = expiresAt
            }

            fun message(message: String) = message(JsonField.of(message))

            /**
             * Sets [Builder.message] to an arbitrary JSON value.
             *
             * You should usually call [Builder.message] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun message(message: JsonField<String>) = apply { this.message = message }

            fun object_(object_: Object) = object_(JsonField.of(object_))

            /**
             * Sets [Builder.object_] to an arbitrary JSON value.
             *
             * You should usually call [Builder.object_] with a well-typed [Object] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            fun username(username: String) = username(JsonField.of(username))

            /**
             * Sets [Builder.username] to an arbitrary JSON value.
             *
             * You should usually call [Builder.username] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun username(username: JsonField<String>) = apply { this.username = username }

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
             * Returns an immutable instance of [XAccountConnectionChallenge].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .expiresAt()
             * .message()
             * .object_()
             * .status()
             * .username()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): XAccountConnectionChallenge =
                XAccountConnectionChallenge(
                    checkRequired("id", id),
                    checkRequired("expiresAt", expiresAt),
                    checkRequired("message", message),
                    checkRequired("object_", object_),
                    checkRequired("status", status),
                    checkRequired("username", username),
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
        fun validate(): XAccountConnectionChallenge = apply {
            if (validated) {
                return@apply
            }

            id()
            expiresAt()
            message()
            object_().validate()
            status().validate()
            username()
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
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (expiresAt.asKnown().isPresent) 1 else 0) +
                (if (message.asKnown().isPresent) 1 else 0) +
                (object_.asKnown().getOrNull()?.validity() ?: 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (username.asKnown().isPresent) 1 else 0)

        class Object @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val X_ACCOUNT_CONNECTION_CHALLENGE = of("x_account_connection_challenge")

                @JvmStatic fun of(value: String) = Object(JsonField.of(value))
            }

            /** An enum containing [Object]'s known values. */
            enum class Known {
                X_ACCOUNT_CONNECTION_CHALLENGE
            }

            /**
             * An enum containing [Object]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Object] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                X_ACCOUNT_CONNECTION_CHALLENGE,
                /**
                 * An enum member indicating that [Object] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    X_ACCOUNT_CONNECTION_CHALLENGE -> Value.X_ACCOUNT_CONNECTION_CHALLENGE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    X_ACCOUNT_CONNECTION_CHALLENGE -> Known.X_ACCOUNT_CONNECTION_CHALLENGE
                    else -> throw XTwitterScraperInvalidDataException("Unknown Object: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
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

                return other is Object && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val REQUIRES_EMAIL_CODE = of("requires_email_code")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                REQUIRES_EMAIL_CODE
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
                REQUIRES_EMAIL_CODE,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    REQUIRES_EMAIL_CODE -> Value.REQUIRES_EMAIL_CODE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    REQUIRES_EMAIL_CODE -> Known.REQUIRES_EMAIL_CODE
                    else -> throw XTwitterScraperInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
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

            return other is XAccountConnectionChallenge &&
                id == other.id &&
                expiresAt == other.expiresAt &&
                message == other.message &&
                object_ == other.object_ &&
                status == other.status &&
                username == other.username &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, expiresAt, message, object_, status, username, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "XAccountConnectionChallenge{id=$id, expiresAt=$expiresAt, message=$message, object_=$object_, status=$status, username=$username, additionalProperties=$additionalProperties}"
    }
}
