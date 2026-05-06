// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.account

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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class AccountRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val monitorsAllowed: JsonField<Long>,
    private val monitorsUsed: JsonField<Long>,
    private val plan: JsonField<Plan>,
    private val creditInfo: JsonField<CreditInfo>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("monitorsAllowed")
        @ExcludeMissing
        monitorsAllowed: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("monitorsUsed")
        @ExcludeMissing
        monitorsUsed: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("plan") @ExcludeMissing plan: JsonField<Plan> = JsonMissing.of(),
        @JsonProperty("creditInfo")
        @ExcludeMissing
        creditInfo: JsonField<CreditInfo> = JsonMissing.of(),
    ) : this(monitorsAllowed, monitorsUsed, plan, creditInfo, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun monitorsAllowed(): Long = monitorsAllowed.getRequired("monitorsAllowed")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun monitorsUsed(): Long = monitorsUsed.getRequired("monitorsUsed")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun plan(): Plan = plan.getRequired("plan")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun creditInfo(): Optional<CreditInfo> = creditInfo.getOptional("creditInfo")

    /**
     * Returns the raw JSON value of [monitorsAllowed].
     *
     * Unlike [monitorsAllowed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("monitorsAllowed")
    @ExcludeMissing
    fun _monitorsAllowed(): JsonField<Long> = monitorsAllowed

    /**
     * Returns the raw JSON value of [monitorsUsed].
     *
     * Unlike [monitorsUsed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("monitorsUsed")
    @ExcludeMissing
    fun _monitorsUsed(): JsonField<Long> = monitorsUsed

    /**
     * Returns the raw JSON value of [plan].
     *
     * Unlike [plan], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("plan") @ExcludeMissing fun _plan(): JsonField<Plan> = plan

    /**
     * Returns the raw JSON value of [creditInfo].
     *
     * Unlike [creditInfo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("creditInfo")
    @ExcludeMissing
    fun _creditInfo(): JsonField<CreditInfo> = creditInfo

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
         * Returns a mutable builder for constructing an instance of [AccountRetrieveResponse].
         *
         * The following fields are required:
         * ```java
         * .monitorsAllowed()
         * .monitorsUsed()
         * .plan()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AccountRetrieveResponse]. */
    class Builder internal constructor() {

        private var monitorsAllowed: JsonField<Long>? = null
        private var monitorsUsed: JsonField<Long>? = null
        private var plan: JsonField<Plan>? = null
        private var creditInfo: JsonField<CreditInfo> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountRetrieveResponse: AccountRetrieveResponse) = apply {
            monitorsAllowed = accountRetrieveResponse.monitorsAllowed
            monitorsUsed = accountRetrieveResponse.monitorsUsed
            plan = accountRetrieveResponse.plan
            creditInfo = accountRetrieveResponse.creditInfo
            additionalProperties = accountRetrieveResponse.additionalProperties.toMutableMap()
        }

        fun monitorsAllowed(monitorsAllowed: Long) = monitorsAllowed(JsonField.of(monitorsAllowed))

        /**
         * Sets [Builder.monitorsAllowed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.monitorsAllowed] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun monitorsAllowed(monitorsAllowed: JsonField<Long>) = apply {
            this.monitorsAllowed = monitorsAllowed
        }

        fun monitorsUsed(monitorsUsed: Long) = monitorsUsed(JsonField.of(monitorsUsed))

        /**
         * Sets [Builder.monitorsUsed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.monitorsUsed] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun monitorsUsed(monitorsUsed: JsonField<Long>) = apply { this.monitorsUsed = monitorsUsed }

        fun plan(plan: Plan) = plan(JsonField.of(plan))

        /**
         * Sets [Builder.plan] to an arbitrary JSON value.
         *
         * You should usually call [Builder.plan] with a well-typed [Plan] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun plan(plan: JsonField<Plan>) = apply { this.plan = plan }

        fun creditInfo(creditInfo: CreditInfo) = creditInfo(JsonField.of(creditInfo))

        /**
         * Sets [Builder.creditInfo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.creditInfo] with a well-typed [CreditInfo] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun creditInfo(creditInfo: JsonField<CreditInfo>) = apply { this.creditInfo = creditInfo }

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
         * Returns an immutable instance of [AccountRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .monitorsAllowed()
         * .monitorsUsed()
         * .plan()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AccountRetrieveResponse =
            AccountRetrieveResponse(
                checkRequired("monitorsAllowed", monitorsAllowed),
                checkRequired("monitorsUsed", monitorsUsed),
                checkRequired("plan", plan),
                creditInfo,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AccountRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        monitorsAllowed()
        monitorsUsed()
        plan().validate()
        creditInfo().ifPresent { it.validate() }
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
        (if (monitorsAllowed.asKnown().isPresent) 1 else 0) +
            (if (monitorsUsed.asKnown().isPresent) 1 else 0) +
            (plan.asKnown().getOrNull()?.validity() ?: 0) +
            (creditInfo.asKnown().getOrNull()?.validity() ?: 0)

    class Plan @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val ACTIVE = of("active")

            @JvmField val INACTIVE = of("inactive")

            @JvmStatic fun of(value: String) = Plan(JsonField.of(value))
        }

        /** An enum containing [Plan]'s known values. */
        enum class Known {
            ACTIVE,
            INACTIVE,
        }

        /**
         * An enum containing [Plan]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Plan] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ACTIVE,
            INACTIVE,
            /** An enum member indicating that [Plan] was instantiated with an unknown value. */
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
                ACTIVE -> Value.ACTIVE
                INACTIVE -> Value.INACTIVE
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
                ACTIVE -> Known.ACTIVE
                INACTIVE -> Known.INACTIVE
                else -> throw XTwitterScraperInvalidDataException("Unknown Plan: $value")
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

        fun validate(): Plan = apply {
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

            return other is Plan && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class CreditInfo
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
            @JsonProperty("autoTopupEnabled")
            @ExcludeMissing
            autoTopupEnabled: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("balance") @ExcludeMissing balance: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("lifetimePurchased")
            @ExcludeMissing
            lifetimePurchased: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("lifetimeUsed")
            @ExcludeMissing
            lifetimeUsed: JsonField<Long> = JsonMissing.of(),
        ) : this(autoTopupEnabled, balance, lifetimePurchased, lifetimeUsed, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun autoTopupEnabled(): Boolean = autoTopupEnabled.getRequired("autoTopupEnabled")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun balance(): Long = balance.getRequired("balance")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun lifetimePurchased(): Long = lifetimePurchased.getRequired("lifetimePurchased")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun lifetimeUsed(): Long = lifetimeUsed.getRequired("lifetimeUsed")

        /**
         * Returns the raw JSON value of [autoTopupEnabled].
         *
         * Unlike [autoTopupEnabled], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("autoTopupEnabled")
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
        @JsonProperty("lifetimePurchased")
        @ExcludeMissing
        fun _lifetimePurchased(): JsonField<Long> = lifetimePurchased

        /**
         * Returns the raw JSON value of [lifetimeUsed].
         *
         * Unlike [lifetimeUsed], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("lifetimeUsed")
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
             * Returns a mutable builder for constructing an instance of [CreditInfo].
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

        /** A builder for [CreditInfo]. */
        class Builder internal constructor() {

            private var autoTopupEnabled: JsonField<Boolean>? = null
            private var balance: JsonField<Long>? = null
            private var lifetimePurchased: JsonField<Long>? = null
            private var lifetimeUsed: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(creditInfo: CreditInfo) = apply {
                autoTopupEnabled = creditInfo.autoTopupEnabled
                balance = creditInfo.balance
                lifetimePurchased = creditInfo.lifetimePurchased
                lifetimeUsed = creditInfo.lifetimeUsed
                additionalProperties = creditInfo.additionalProperties.toMutableMap()
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
             * You should usually call [Builder.balance] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * You should usually call [Builder.lifetimeUsed] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun lifetimeUsed(lifetimeUsed: JsonField<Long>) = apply {
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
             * Returns an immutable instance of [CreditInfo].
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
            fun build(): CreditInfo =
                CreditInfo(
                    checkRequired("autoTopupEnabled", autoTopupEnabled),
                    checkRequired("balance", balance),
                    checkRequired("lifetimePurchased", lifetimePurchased),
                    checkRequired("lifetimeUsed", lifetimeUsed),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): CreditInfo = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
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

            return other is CreditInfo &&
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
            "CreditInfo{autoTopupEnabled=$autoTopupEnabled, balance=$balance, lifetimePurchased=$lifetimePurchased, lifetimeUsed=$lifetimeUsed, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountRetrieveResponse &&
            monitorsAllowed == other.monitorsAllowed &&
            monitorsUsed == other.monitorsUsed &&
            plan == other.plan &&
            creditInfo == other.creditInfo &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(monitorsAllowed, monitorsUsed, plan, creditInfo, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AccountRetrieveResponse{monitorsAllowed=$monitorsAllowed, monitorsUsed=$monitorsUsed, plan=$plan, creditInfo=$creditInfo, additionalProperties=$additionalProperties}"
}
