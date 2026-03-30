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

class WebhookListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val webhooks: JsonField<List<Webhook>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("webhooks")
        @ExcludeMissing
        webhooks: JsonField<List<Webhook>> = JsonMissing.of()
    ) : this(webhooks, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun webhooks(): List<Webhook> = webhooks.getRequired("webhooks")

    /**
     * Returns the raw JSON value of [webhooks].
     *
     * Unlike [webhooks], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("webhooks") @ExcludeMissing fun _webhooks(): JsonField<List<Webhook>> = webhooks

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
         * Returns a mutable builder for constructing an instance of [WebhookListResponse].
         *
         * The following fields are required:
         * ```java
         * .webhooks()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookListResponse]. */
    class Builder internal constructor() {

        private var webhooks: JsonField<MutableList<Webhook>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(webhookListResponse: WebhookListResponse) = apply {
            webhooks = webhookListResponse.webhooks.map { it.toMutableList() }
            additionalProperties = webhookListResponse.additionalProperties.toMutableMap()
        }

        fun webhooks(webhooks: List<Webhook>) = webhooks(JsonField.of(webhooks))

        /**
         * Sets [Builder.webhooks] to an arbitrary JSON value.
         *
         * You should usually call [Builder.webhooks] with a well-typed `List<Webhook>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun webhooks(webhooks: JsonField<List<Webhook>>) = apply {
            this.webhooks = webhooks.map { it.toMutableList() }
        }

        /**
         * Adds a single [Webhook] to [webhooks].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addWebhook(webhook: Webhook) = apply {
            webhooks =
                (webhooks ?: JsonField.of(mutableListOf())).also {
                    checkKnown("webhooks", it).add(webhook)
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
         * Returns an immutable instance of [WebhookListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .webhooks()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WebhookListResponse =
            WebhookListResponse(
                checkRequired("webhooks", webhooks).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): WebhookListResponse = apply {
        if (validated) {
            return@apply
        }

        webhooks().forEach { it.validate() }
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
        (webhooks.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookListResponse &&
            webhooks == other.webhooks &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(webhooks, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WebhookListResponse{webhooks=$webhooks, additionalProperties=$additionalProperties}"
}
