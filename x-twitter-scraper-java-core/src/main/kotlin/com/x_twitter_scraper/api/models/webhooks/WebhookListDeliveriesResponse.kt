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
import java.util.Collections
import java.util.Objects
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
