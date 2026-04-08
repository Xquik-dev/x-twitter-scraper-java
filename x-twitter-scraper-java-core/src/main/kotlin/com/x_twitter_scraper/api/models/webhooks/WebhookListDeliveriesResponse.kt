// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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

class WebhookListDeliveriesResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val deliveries: JsonField<List<Delivery>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("deliveries")
        @ExcludeMissing
        deliveries: JsonField<List<Delivery>> = JsonMissing.of()
    ) : this(deliveries, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun deliveries(): List<Delivery> = deliveries.getRequired("deliveries")

    /**
     * Returns the raw JSON value of [deliveries].
     *
     * Unlike [deliveries], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("deliveries")
    @ExcludeMissing
    fun _deliveries(): JsonField<List<Delivery>> = deliveries

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
         * [WebhookListDeliveriesResponse].
         *
         * The following fields are required:
         * ```java
         * .deliveries()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookListDeliveriesResponse]. */
    class Builder internal constructor() {

        private var deliveries: JsonField<MutableList<Delivery>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(webhookListDeliveriesResponse: WebhookListDeliveriesResponse) = apply {
            deliveries = webhookListDeliveriesResponse.deliveries.map { it.toMutableList() }
            additionalProperties = webhookListDeliveriesResponse.additionalProperties.toMutableMap()
        }

        fun deliveries(deliveries: List<Delivery>) = deliveries(JsonField.of(deliveries))

        /**
         * Sets [Builder.deliveries] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deliveries] with a well-typed `List<Delivery>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun deliveries(deliveries: JsonField<List<Delivery>>) = apply {
            this.deliveries = deliveries.map { it.toMutableList() }
        }

        /**
         * Adds a single [Delivery] to [deliveries].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDelivery(delivery: Delivery) = apply {
            deliveries =
                (deliveries ?: JsonField.of(mutableListOf())).also {
                    checkKnown("deliveries", it).add(delivery)
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
         * Returns an immutable instance of [WebhookListDeliveriesResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .deliveries()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WebhookListDeliveriesResponse =
            WebhookListDeliveriesResponse(
                checkRequired("deliveries", deliveries).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): WebhookListDeliveriesResponse = apply {
        if (validated) {
            return@apply
        }

        deliveries().forEach { it.validate() }
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
        (deliveries.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** Webhook delivery attempt record with status and retry count. */
    class Delivery
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val attempts: JsonField<Long>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val status: JsonField<String>,
        private val streamEventId: JsonField<String>,
        private val deliveredAt: JsonField<OffsetDateTime>,
        private val lastError: JsonField<String>,
        private val lastStatusCode: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("attempts") @ExcludeMissing attempts: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
            @JsonProperty("streamEventId")
            @ExcludeMissing
            streamEventId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("deliveredAt")
            @ExcludeMissing
            deliveredAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("lastError")
            @ExcludeMissing
            lastError: JsonField<String> = JsonMissing.of(),
            @JsonProperty("lastStatusCode")
            @ExcludeMissing
            lastStatusCode: JsonField<Long> = JsonMissing.of(),
        ) : this(
            id,
            attempts,
            createdAt,
            status,
            streamEventId,
            deliveredAt,
            lastError,
            lastStatusCode,
            mutableMapOf(),
        )

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
        fun attempts(): Long = attempts.getRequired("attempts")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun status(): String = status.getRequired("status")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun streamEventId(): String = streamEventId.getRequired("streamEventId")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun deliveredAt(): Optional<OffsetDateTime> = deliveredAt.getOptional("deliveredAt")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun lastError(): Optional<String> = lastError.getOptional("lastError")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun lastStatusCode(): Optional<Long> = lastStatusCode.getOptional("lastStatusCode")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [attempts].
         *
         * Unlike [attempts], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("attempts") @ExcludeMissing fun _attempts(): JsonField<Long> = attempts

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

        /**
         * Returns the raw JSON value of [streamEventId].
         *
         * Unlike [streamEventId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("streamEventId")
        @ExcludeMissing
        fun _streamEventId(): JsonField<String> = streamEventId

        /**
         * Returns the raw JSON value of [deliveredAt].
         *
         * Unlike [deliveredAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("deliveredAt")
        @ExcludeMissing
        fun _deliveredAt(): JsonField<OffsetDateTime> = deliveredAt

        /**
         * Returns the raw JSON value of [lastError].
         *
         * Unlike [lastError], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("lastError") @ExcludeMissing fun _lastError(): JsonField<String> = lastError

        /**
         * Returns the raw JSON value of [lastStatusCode].
         *
         * Unlike [lastStatusCode], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("lastStatusCode")
        @ExcludeMissing
        fun _lastStatusCode(): JsonField<Long> = lastStatusCode

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
             * Returns a mutable builder for constructing an instance of [Delivery].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .attempts()
             * .createdAt()
             * .status()
             * .streamEventId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Delivery]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var attempts: JsonField<Long>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var status: JsonField<String>? = null
            private var streamEventId: JsonField<String>? = null
            private var deliveredAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var lastError: JsonField<String> = JsonMissing.of()
            private var lastStatusCode: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(delivery: Delivery) = apply {
                id = delivery.id
                attempts = delivery.attempts
                createdAt = delivery.createdAt
                status = delivery.status
                streamEventId = delivery.streamEventId
                deliveredAt = delivery.deliveredAt
                lastError = delivery.lastError
                lastStatusCode = delivery.lastStatusCode
                additionalProperties = delivery.additionalProperties.toMutableMap()
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

            fun attempts(attempts: Long) = attempts(JsonField.of(attempts))

            /**
             * Sets [Builder.attempts] to an arbitrary JSON value.
             *
             * You should usually call [Builder.attempts] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun attempts(attempts: JsonField<Long>) = apply { this.attempts = attempts }

            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            fun status(status: String) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<String>) = apply { this.status = status }

            fun streamEventId(streamEventId: String) = streamEventId(JsonField.of(streamEventId))

            /**
             * Sets [Builder.streamEventId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.streamEventId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun streamEventId(streamEventId: JsonField<String>) = apply {
                this.streamEventId = streamEventId
            }

            fun deliveredAt(deliveredAt: OffsetDateTime) = deliveredAt(JsonField.of(deliveredAt))

            /**
             * Sets [Builder.deliveredAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.deliveredAt] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun deliveredAt(deliveredAt: JsonField<OffsetDateTime>) = apply {
                this.deliveredAt = deliveredAt
            }

            fun lastError(lastError: String) = lastError(JsonField.of(lastError))

            /**
             * Sets [Builder.lastError] to an arbitrary JSON value.
             *
             * You should usually call [Builder.lastError] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun lastError(lastError: JsonField<String>) = apply { this.lastError = lastError }

            fun lastStatusCode(lastStatusCode: Long) = lastStatusCode(JsonField.of(lastStatusCode))

            /**
             * Sets [Builder.lastStatusCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.lastStatusCode] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun lastStatusCode(lastStatusCode: JsonField<Long>) = apply {
                this.lastStatusCode = lastStatusCode
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
             * Returns an immutable instance of [Delivery].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .attempts()
             * .createdAt()
             * .status()
             * .streamEventId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Delivery =
                Delivery(
                    checkRequired("id", id),
                    checkRequired("attempts", attempts),
                    checkRequired("createdAt", createdAt),
                    checkRequired("status", status),
                    checkRequired("streamEventId", streamEventId),
                    deliveredAt,
                    lastError,
                    lastStatusCode,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Delivery = apply {
            if (validated) {
                return@apply
            }

            id()
            attempts()
            createdAt()
            status()
            streamEventId()
            deliveredAt()
            lastError()
            lastStatusCode()
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
                (if (attempts.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (status.asKnown().isPresent) 1 else 0) +
                (if (streamEventId.asKnown().isPresent) 1 else 0) +
                (if (deliveredAt.asKnown().isPresent) 1 else 0) +
                (if (lastError.asKnown().isPresent) 1 else 0) +
                (if (lastStatusCode.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Delivery &&
                id == other.id &&
                attempts == other.attempts &&
                createdAt == other.createdAt &&
                status == other.status &&
                streamEventId == other.streamEventId &&
                deliveredAt == other.deliveredAt &&
                lastError == other.lastError &&
                lastStatusCode == other.lastStatusCode &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                attempts,
                createdAt,
                status,
                streamEventId,
                deliveredAt,
                lastError,
                lastStatusCode,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Delivery{id=$id, attempts=$attempts, createdAt=$createdAt, status=$status, streamEventId=$streamEventId, deliveredAt=$deliveredAt, lastError=$lastError, lastStatusCode=$lastStatusCode, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookListDeliveriesResponse &&
            deliveries == other.deliveries &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(deliveries, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WebhookListDeliveriesResponse{deliveries=$deliveries, additionalProperties=$additionalProperties}"
}
