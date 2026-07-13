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
    private val autoTopupAmountDollars: JsonField<Double>,
    private val autoTopupEnabled: JsonField<Boolean>,
    private val autoTopupThreshold: JsonField<String>,
    private val balance: JsonField<String>,
    private val lifetimePurchased: JsonField<String>,
    private val lifetimeUsed: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("auto_topup_amount_dollars")
        @ExcludeMissing
        autoTopupAmountDollars: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("auto_topup_enabled")
        @ExcludeMissing
        autoTopupEnabled: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("auto_topup_threshold")
        @ExcludeMissing
        autoTopupThreshold: JsonField<String> = JsonMissing.of(),
        @JsonProperty("balance") @ExcludeMissing balance: JsonField<String> = JsonMissing.of(),
        @JsonProperty("lifetime_purchased")
        @ExcludeMissing
        lifetimePurchased: JsonField<String> = JsonMissing.of(),
        @JsonProperty("lifetime_used")
        @ExcludeMissing
        lifetimeUsed: JsonField<String> = JsonMissing.of(),
    ) : this(
        autoTopupAmountDollars,
        autoTopupEnabled,
        autoTopupThreshold,
        balance,
        lifetimePurchased,
        lifetimeUsed,
        mutableMapOf(),
    )

    /**
     * Configured dollar amount for each automatic top-up.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun autoTopupAmountDollars(): Double =
        autoTopupAmountDollars.getRequired("auto_topup_amount_dollars")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun autoTopupEnabled(): Boolean = autoTopupEnabled.getRequired("auto_topup_enabled")

    /**
     * Credit balance threshold that triggers automatic top-up when enabled, represented as a bigint
     * string.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun autoTopupThreshold(): String = autoTopupThreshold.getRequired("auto_topup_threshold")

    /**
     * Current credit balance as a bigint string to preserve precision above
     * Number.MAX_SAFE_INTEGER.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun balance(): String = balance.getRequired("balance")

    /**
     * Lifetime purchased credits as a bigint string.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun lifetimePurchased(): String = lifetimePurchased.getRequired("lifetime_purchased")

    /**
     * Lifetime consumed credits as a bigint string.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun lifetimeUsed(): String = lifetimeUsed.getRequired("lifetime_used")

    /**
     * Returns the raw JSON value of [autoTopupAmountDollars].
     *
     * Unlike [autoTopupAmountDollars], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("auto_topup_amount_dollars")
    @ExcludeMissing
    fun _autoTopupAmountDollars(): JsonField<Double> = autoTopupAmountDollars

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
     * Returns the raw JSON value of [autoTopupThreshold].
     *
     * Unlike [autoTopupThreshold], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("auto_topup_threshold")
    @ExcludeMissing
    fun _autoTopupThreshold(): JsonField<String> = autoTopupThreshold

    /**
     * Returns the raw JSON value of [balance].
     *
     * Unlike [balance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("balance") @ExcludeMissing fun _balance(): JsonField<String> = balance

    /**
     * Returns the raw JSON value of [lifetimePurchased].
     *
     * Unlike [lifetimePurchased], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("lifetime_purchased")
    @ExcludeMissing
    fun _lifetimePurchased(): JsonField<String> = lifetimePurchased

    /**
     * Returns the raw JSON value of [lifetimeUsed].
     *
     * Unlike [lifetimeUsed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("lifetime_used")
    @ExcludeMissing
    fun _lifetimeUsed(): JsonField<String> = lifetimeUsed

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
         * .autoTopupAmountDollars()
         * .autoTopupEnabled()
         * .autoTopupThreshold()
         * .balance()
         * .lifetimePurchased()
         * .lifetimeUsed()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CreditRetrieveBalanceResponse]. */
    class Builder internal constructor() {

        private var autoTopupAmountDollars: JsonField<Double>? = null
        private var autoTopupEnabled: JsonField<Boolean>? = null
        private var autoTopupThreshold: JsonField<String>? = null
        private var balance: JsonField<String>? = null
        private var lifetimePurchased: JsonField<String>? = null
        private var lifetimeUsed: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(creditRetrieveBalanceResponse: CreditRetrieveBalanceResponse) = apply {
            autoTopupAmountDollars = creditRetrieveBalanceResponse.autoTopupAmountDollars
            autoTopupEnabled = creditRetrieveBalanceResponse.autoTopupEnabled
            autoTopupThreshold = creditRetrieveBalanceResponse.autoTopupThreshold
            balance = creditRetrieveBalanceResponse.balance
            lifetimePurchased = creditRetrieveBalanceResponse.lifetimePurchased
            lifetimeUsed = creditRetrieveBalanceResponse.lifetimeUsed
            additionalProperties = creditRetrieveBalanceResponse.additionalProperties.toMutableMap()
        }

        /** Configured dollar amount for each automatic top-up. */
        fun autoTopupAmountDollars(autoTopupAmountDollars: Double) =
            autoTopupAmountDollars(JsonField.of(autoTopupAmountDollars))

        /**
         * Sets [Builder.autoTopupAmountDollars] to an arbitrary JSON value.
         *
         * You should usually call [Builder.autoTopupAmountDollars] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun autoTopupAmountDollars(autoTopupAmountDollars: JsonField<Double>) = apply {
            this.autoTopupAmountDollars = autoTopupAmountDollars
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

        /**
         * Credit balance threshold that triggers automatic top-up when enabled, represented as a
         * bigint string.
         */
        fun autoTopupThreshold(autoTopupThreshold: String) =
            autoTopupThreshold(JsonField.of(autoTopupThreshold))

        /**
         * Sets [Builder.autoTopupThreshold] to an arbitrary JSON value.
         *
         * You should usually call [Builder.autoTopupThreshold] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun autoTopupThreshold(autoTopupThreshold: JsonField<String>) = apply {
            this.autoTopupThreshold = autoTopupThreshold
        }

        /**
         * Current credit balance as a bigint string to preserve precision above
         * Number.MAX_SAFE_INTEGER.
         */
        fun balance(balance: String) = balance(JsonField.of(balance))

        /**
         * Sets [Builder.balance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.balance] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun balance(balance: JsonField<String>) = apply { this.balance = balance }

        /** Lifetime purchased credits as a bigint string. */
        fun lifetimePurchased(lifetimePurchased: String) =
            lifetimePurchased(JsonField.of(lifetimePurchased))

        /**
         * Sets [Builder.lifetimePurchased] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lifetimePurchased] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun lifetimePurchased(lifetimePurchased: JsonField<String>) = apply {
            this.lifetimePurchased = lifetimePurchased
        }

        /** Lifetime consumed credits as a bigint string. */
        fun lifetimeUsed(lifetimeUsed: String) = lifetimeUsed(JsonField.of(lifetimeUsed))

        /**
         * Sets [Builder.lifetimeUsed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lifetimeUsed] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun lifetimeUsed(lifetimeUsed: JsonField<String>) = apply {
            this.lifetimeUsed = lifetimeUsed
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
         * Returns an immutable instance of [CreditRetrieveBalanceResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .autoTopupAmountDollars()
         * .autoTopupEnabled()
         * .autoTopupThreshold()
         * .balance()
         * .lifetimePurchased()
         * .lifetimeUsed()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CreditRetrieveBalanceResponse =
            CreditRetrieveBalanceResponse(
                checkRequired("autoTopupAmountDollars", autoTopupAmountDollars),
                checkRequired("autoTopupEnabled", autoTopupEnabled),
                checkRequired("autoTopupThreshold", autoTopupThreshold),
                checkRequired("balance", balance),
                checkRequired("lifetimePurchased", lifetimePurchased),
                checkRequired("lifetimeUsed", lifetimeUsed),
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
    fun validate(): CreditRetrieveBalanceResponse = apply {
        if (validated) {
            return@apply
        }

        autoTopupAmountDollars()
        autoTopupEnabled()
        autoTopupThreshold()
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
        (if (autoTopupAmountDollars.asKnown().isPresent) 1 else 0) +
            (if (autoTopupEnabled.asKnown().isPresent) 1 else 0) +
            (if (autoTopupThreshold.asKnown().isPresent) 1 else 0) +
            (if (balance.asKnown().isPresent) 1 else 0) +
            (if (lifetimePurchased.asKnown().isPresent) 1 else 0) +
            (if (lifetimeUsed.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CreditRetrieveBalanceResponse &&
            autoTopupAmountDollars == other.autoTopupAmountDollars &&
            autoTopupEnabled == other.autoTopupEnabled &&
            autoTopupThreshold == other.autoTopupThreshold &&
            balance == other.balance &&
            lifetimePurchased == other.lifetimePurchased &&
            lifetimeUsed == other.lifetimeUsed &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            autoTopupAmountDollars,
            autoTopupEnabled,
            autoTopupThreshold,
            balance,
            lifetimePurchased,
            lifetimeUsed,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CreditRetrieveBalanceResponse{autoTopupAmountDollars=$autoTopupAmountDollars, autoTopupEnabled=$autoTopupEnabled, autoTopupThreshold=$autoTopupThreshold, balance=$balance, lifetimePurchased=$lifetimePurchased, lifetimeUsed=$lifetimeUsed, additionalProperties=$additionalProperties}"
}
