// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.credits

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

class CreditRetrieveBalanceResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val autoTopupEnabled: JsonField<Boolean>,
    private val balance: JsonField<Long>,
    private val lifetimePurchased: JsonField<Long>,
    private val lifetimeUsed: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("auto_topup_enabled")
        @ExcludeMissing
        autoTopupEnabled: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("balance") @ExcludeMissing balance: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("lifetime_purchased")
        @ExcludeMissing
        lifetimePurchased: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("lifetime_used")
        @ExcludeMissing
        lifetimeUsed: JsonField<Long> = JsonMissing.of(),
    ) : this(autoTopupEnabled, balance, lifetimePurchased, lifetimeUsed, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun autoTopupEnabled(): Boolean = autoTopupEnabled.getRequired("auto_topup_enabled")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun balance(): Long = balance.getRequired("balance")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun lifetimePurchased(): Long = lifetimePurchased.getRequired("lifetime_purchased")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun lifetimeUsed(): Long = lifetimeUsed.getRequired("lifetime_used")

    /**
     * Returns the raw JSON value of [autoTopupEnabled].
     *
     * Unlike [autoTopupEnabled], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("auto_topup_enabled")
    @ExcludeMissing
    fun _autoTopupEnabled(): JsonField<Boolean> = autoTopupEnabled

    /**
     * Returns the raw JSON value of [balance].
     *
     * Unlike [balance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("balance") @ExcludeMissing fun _balance(): JsonField<Long> = balance

    /**
     * Returns the raw JSON value of [lifetimePurchased].
     *
     * Unlike [lifetimePurchased], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("lifetime_purchased")
    @ExcludeMissing
    fun _lifetimePurchased(): JsonField<Long> = lifetimePurchased

    /**
     * Returns the raw JSON value of [lifetimeUsed].
     *
     * Unlike [lifetimeUsed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("lifetime_used")
    @ExcludeMissing
    fun _lifetimeUsed(): JsonField<Long> = lifetimeUsed

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
         * [CreditRetrieveBalanceResponse].
         *
         * The following fields are required:
         * ```java
         * .autoTopupEnabled()
         * .balance()
         * .lifetimePurchased()
         * .lifetimeUsed()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CreditRetrieveBalanceResponse]. */
    class Builder internal constructor() {

        private var autoTopupEnabled: JsonField<Boolean>? = null
        private var balance: JsonField<Long>? = null
        private var lifetimePurchased: JsonField<Long>? = null
        private var lifetimeUsed: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(creditRetrieveBalanceResponse: CreditRetrieveBalanceResponse) = apply {
            autoTopupEnabled = creditRetrieveBalanceResponse.autoTopupEnabled
            balance = creditRetrieveBalanceResponse.balance
            lifetimePurchased = creditRetrieveBalanceResponse.lifetimePurchased
            lifetimeUsed = creditRetrieveBalanceResponse.lifetimeUsed
            additionalProperties = creditRetrieveBalanceResponse.additionalProperties.toMutableMap()
        }

        fun autoTopupEnabled(autoTopupEnabled: Boolean) =
            autoTopupEnabled(JsonField.of(autoTopupEnabled))

        /**
         * Sets [Builder.autoTopupEnabled] to an arbitrary JSON value.
         *
         * You should usually call [Builder.autoTopupEnabled] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun autoTopupEnabled(autoTopupEnabled: JsonField<Boolean>) = apply {
            this.autoTopupEnabled = autoTopupEnabled
        }

        fun balance(balance: Long) = balance(JsonField.of(balance))

        /**
         * Sets [Builder.balance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.balance] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun balance(balance: JsonField<Long>) = apply { this.balance = balance }

        fun lifetimePurchased(lifetimePurchased: Long) =
            lifetimePurchased(JsonField.of(lifetimePurchased))

        /**
         * Sets [Builder.lifetimePurchased] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lifetimePurchased] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun lifetimePurchased(lifetimePurchased: JsonField<Long>) = apply {
            this.lifetimePurchased = lifetimePurchased
        }

        fun lifetimeUsed(lifetimeUsed: Long) = lifetimeUsed(JsonField.of(lifetimeUsed))

        /**
         * Sets [Builder.lifetimeUsed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lifetimeUsed] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun lifetimeUsed(lifetimeUsed: JsonField<Long>) = apply { this.lifetimeUsed = lifetimeUsed }

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
         * Returns an immutable instance of [CreditRetrieveBalanceResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .autoTopupEnabled()
         * .balance()
         * .lifetimePurchased()
         * .lifetimeUsed()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CreditRetrieveBalanceResponse =
            CreditRetrieveBalanceResponse(
                checkRequired("autoTopupEnabled", autoTopupEnabled),
                checkRequired("balance", balance),
                checkRequired("lifetimePurchased", lifetimePurchased),
                checkRequired("lifetimeUsed", lifetimeUsed),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CreditRetrieveBalanceResponse = apply {
        if (validated) {
            return@apply
        }

        autoTopupEnabled()
        balance()
        lifetimePurchased()
        lifetimeUsed()
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
        (if (autoTopupEnabled.asKnown().isPresent) 1 else 0) +
            (if (balance.asKnown().isPresent) 1 else 0) +
            (if (lifetimePurchased.asKnown().isPresent) 1 else 0) +
            (if (lifetimeUsed.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CreditRetrieveBalanceResponse &&
            autoTopupEnabled == other.autoTopupEnabled &&
            balance == other.balance &&
            lifetimePurchased == other.lifetimePurchased &&
            lifetimeUsed == other.lifetimeUsed &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            autoTopupEnabled,
            balance,
            lifetimePurchased,
            lifetimeUsed,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CreditRetrieveBalanceResponse{autoTopupEnabled=$autoTopupEnabled, balance=$balance, lifetimePurchased=$lifetimePurchased, lifetimeUsed=$lifetimeUsed, additionalProperties=$additionalProperties}"
}
