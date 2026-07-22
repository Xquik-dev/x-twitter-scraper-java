// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.guestwallets

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects

/** Confirmed USD amount for a guest wallet purchase. */
class GuestWalletAmount
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val amountMinor: JsonField<Long>,
    private val currency: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("amount_minor")
        @ExcludeMissing
        amountMinor: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("currency") @ExcludeMissing currency: JsonValue = JsonMissing.of(),
    ) : this(amountMinor, currency, mutableMapOf())

    /**
     * USD amount in cents. Accepted range is $10-$250.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun amountMinor(): Long = amountMinor.getRequired("amount_minor")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("usd")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("currency") @ExcludeMissing fun _currency(): JsonValue = currency

    /**
     * Returns the raw JSON value of [amountMinor].
     *
     * Unlike [amountMinor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("amount_minor") @ExcludeMissing fun _amountMinor(): JsonField<Long> = amountMinor

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
         * Returns a mutable builder for constructing an instance of [GuestWalletAmount].
         *
         * The following fields are required:
         * ```java
         * .amountMinor()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GuestWalletAmount]. */
    class Builder internal constructor() {

        private var amountMinor: JsonField<Long>? = null
        private var currency: JsonValue = JsonValue.from("usd")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(guestWalletAmount: GuestWalletAmount) = apply {
            amountMinor = guestWalletAmount.amountMinor
            currency = guestWalletAmount.currency
            additionalProperties = guestWalletAmount.additionalProperties.toMutableMap()
        }

        /** USD amount in cents. Accepted range is $10-$250. */
        fun amountMinor(amountMinor: Long) = amountMinor(JsonField.of(amountMinor))

        /**
         * Sets [Builder.amountMinor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.amountMinor] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun amountMinor(amountMinor: JsonField<Long>) = apply { this.amountMinor = amountMinor }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("usd")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun currency(currency: JsonValue) = apply { this.currency = currency }

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
         * Returns an immutable instance of [GuestWalletAmount].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .amountMinor()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): GuestWalletAmount =
            GuestWalletAmount(
                checkRequired("amountMinor", amountMinor),
                currency,
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
    fun validate(): GuestWalletAmount = apply {
        if (validated) {
            return@apply
        }

        amountMinor()
        _currency().let {
            if (it != JsonValue.from("usd")) {
                throw XTwitterScraperInvalidDataException("'currency' is invalid, received $it")
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (amountMinor.asKnown().isPresent) 1 else 0) +
            currency.let { if (it == JsonValue.from("usd")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is GuestWalletAmount &&
            amountMinor == other.amountMinor &&
            currency == other.currency &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(amountMinor, currency, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "GuestWalletAmount{amountMinor=$amountMinor, currency=$currency, additionalProperties=$additionalProperties}"
}
