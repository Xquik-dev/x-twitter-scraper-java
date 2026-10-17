// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class WebhookListDeliveriesResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val deliveries: JsonField<List<Delivery>>,
    private val hasMore: JsonField<Boolean>,
    private val nextCursor: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("deliveries")
        @ExcludeMissing
        deliveries: JsonField<List<Delivery>> = JsonMissing.of(),
        @JsonProperty("hasMore") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("nextCursor")
        @ExcludeMissing
        nextCursor: JsonField<String> = JsonMissing.of(),
    ) : this(
        deliveries,
        hasMore,
        nextCursor,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun deliveries(): List<Delivery> = deliveries.getRequired("deliveries")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun hasMore(): Optional<Boolean> = hasMore.getOptional("hasMore")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun nextCursor(): Optional<String> = nextCursor.getOptional("nextCursor")

    /**
     * Returns the raw JSON value of [deliveries].
     *
     * Unlike [deliveries], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("deliveries")
    @ExcludeMissing
    fun _deliveries(): JsonField<List<Delivery>> = deliveries

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
        private var hasMore: JsonField<Boolean> = JsonMissing.of()
        private var nextCursor: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(webhookListDeliveriesResponse: WebhookListDeliveriesResponse) = apply {
            deliveries = webhookListDeliveriesResponse.deliveries.map { it.toMutableList() }
            hasMore = webhookListDeliveriesResponse.hasMore
            nextCursor = webhookListDeliveriesResponse.nextCursor
            additionalProperties = webhookListDeliveriesResponse.additionalProperties.toMutableMap()
        }

        fun deliveries(deliveries: List<Delivery>) = deliveries(JsonField.of(deliveries))

        /** Sets [Builder.deliveries] to an arbitrary JSON value. */
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
    fun validate(): WebhookListDeliveriesResponse = apply {
        if (validated) {
            return@apply
        }

        deliveries().forEach { it.validate() }
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
        (deliveries.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (hasMore.asKnown().isPresent) 1 else 0) +
            (if (nextCursor.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookListDeliveriesResponse &&
            deliveries == other.deliveries &&
            hasMore == other.hasMore &&
            nextCursor == other.nextCursor &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(deliveries, hasMore, nextCursor, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WebhookListDeliveriesResponse{deliveries=$deliveries, hasMore=$hasMore, nextCursor=$nextCursor, additionalProperties=$additionalProperties}"
}
