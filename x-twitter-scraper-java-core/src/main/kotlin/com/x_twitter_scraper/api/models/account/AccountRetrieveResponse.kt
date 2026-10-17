// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class AccountRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val monitorBilling: JsonField<MonitorBilling>,
    private val monitorsAllowed: JsonField<Long>,
    private val monitorsUsed: JsonField<Long>,
    private val plan: JsonField<Plan>,
    private val creditInfo: JsonField<CreditInfo>,
    private val xUsername: JsonField<String>,
    private val subscription: JsonField<Subscription>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("monitorBilling")
        @ExcludeMissing
        monitorBilling: JsonField<MonitorBilling> = JsonMissing.of(),
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
        @JsonProperty("xUsername") @ExcludeMissing xUsername: JsonField<String> = JsonMissing.of(),
        @JsonProperty("subscription")
        @ExcludeMissing
        subscription: JsonField<Subscription> = JsonMissing.of(),
    ) : this(
        monitorBilling,
        monitorsAllowed,
        monitorsUsed,
        plan,
        creditInfo,
        xUsername,
        subscription,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun monitorBilling(): MonitorBilling = monitorBilling.getRequired("monitorBilling")

    /**
     * Deprecated. Monitor slots are unlimited, so this is always Number.MAX_SAFE_INTEGER.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    @Deprecated("Monitor slots are unlimited. Use monitorBilling.unlimitedSlots instead.")
    fun monitorsAllowed(): Long = monitorsAllowed.getRequired("monitorsAllowed")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun monitorsUsed(): Long = monitorsUsed.getRequired("monitorsUsed")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun plan(): Plan = plan.getRequired("plan")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun creditInfo(): Optional<CreditInfo> = creditInfo.getOptional("creditInfo")

    /**
     * Linked X username, omitted when no X account is connected.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun xUsername(): Optional<String> = xUsername.getOptional("xUsername")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun subscription(): Optional<Subscription> = subscription.getOptional("subscription")

    /**
     * Returns the raw JSON value of [monitorBilling].
     *
     * Unlike [monitorBilling], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("monitorBilling")
    @ExcludeMissing
    fun _monitorBilling(): JsonField<MonitorBilling> = monitorBilling

    /**
     * Returns the raw JSON value of [monitorsAllowed].
     *
     * Unlike [monitorsAllowed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @Deprecated("Monitor slots are unlimited. Use monitorBilling.unlimitedSlots instead.")
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

    /**
     * Returns the raw JSON value of [xUsername].
     *
     * Unlike [xUsername], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("xUsername") @ExcludeMissing fun _xUsername(): JsonField<String> = xUsername

    /**
     * Returns the raw JSON value of [subscription].
     *
     * Unlike [subscription], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("subscription")
    @ExcludeMissing
    fun _subscription(): JsonField<Subscription> = subscription

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
         * .monitorBilling()
         * .monitorsAllowed()
         * .monitorsUsed()
         * .plan()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AccountRetrieveResponse]. */
    class Builder internal constructor() {

        private var monitorBilling: JsonField<MonitorBilling>? = null
        private var monitorsAllowed: JsonField<Long>? = null
        private var monitorsUsed: JsonField<Long>? = null
        private var plan: JsonField<Plan>? = null
        private var creditInfo: JsonField<CreditInfo> = JsonMissing.of()
        private var xUsername: JsonField<String> = JsonMissing.of()
        private var subscription: JsonField<Subscription> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountRetrieveResponse: AccountRetrieveResponse) = apply {
            monitorBilling = accountRetrieveResponse.monitorBilling
            monitorsAllowed = accountRetrieveResponse.monitorsAllowed
            monitorsUsed = accountRetrieveResponse.monitorsUsed
            plan = accountRetrieveResponse.plan
            creditInfo = accountRetrieveResponse.creditInfo
            xUsername = accountRetrieveResponse.xUsername
            subscription = accountRetrieveResponse.subscription
            additionalProperties = accountRetrieveResponse.additionalProperties.toMutableMap()
        }

        fun monitorBilling(monitorBilling: MonitorBilling) =
            monitorBilling(JsonField.of(monitorBilling))

        /** Sets [Builder.monitorBilling] to an arbitrary JSON value. */
        fun monitorBilling(monitorBilling: JsonField<MonitorBilling>) = apply {
            this.monitorBilling = monitorBilling
        }

        /** Deprecated. Monitor slots are unlimited, so this is always Number.MAX_SAFE_INTEGER. */
        @Deprecated("Monitor slots are unlimited. Use monitorBilling.unlimitedSlots instead.")
        fun monitorsAllowed(monitorsAllowed: Long) = apply {
            this.monitorsAllowed = JsonField.of(monitorsAllowed)
        }

        /** Sets [Builder.monitorsAllowed] to an arbitrary JSON value. */
        @Deprecated("Monitor slots are unlimited. Use monitorBilling.unlimitedSlots instead.")
        fun monitorsAllowed(monitorsAllowed: JsonField<Long>) = apply {
            this.monitorsAllowed = monitorsAllowed
        }

        fun monitorsUsed(monitorsUsed: Long) = monitorsUsed(JsonField.of(monitorsUsed))

        /** Sets [Builder.monitorsUsed] to an arbitrary JSON value. */
        fun monitorsUsed(monitorsUsed: JsonField<Long>) = apply { this.monitorsUsed = monitorsUsed }

        fun plan(plan: Plan) = plan(JsonField.of(plan))

        /** Sets [Builder.plan] to an arbitrary JSON value. */
        fun plan(plan: JsonField<Plan>) = apply { this.plan = plan }

        fun creditInfo(creditInfo: CreditInfo) = creditInfo(JsonField.of(creditInfo))

        /** Sets [Builder.creditInfo] to an arbitrary JSON value. */
        fun creditInfo(creditInfo: JsonField<CreditInfo>) = apply { this.creditInfo = creditInfo }

        /** Linked X username, omitted when no X account is connected. */
        fun xUsername(xUsername: String) = xUsername(JsonField.of(xUsername))

        /** Sets [Builder.xUsername] to an arbitrary JSON value. */
        fun xUsername(xUsername: JsonField<String>) = apply { this.xUsername = xUsername }

        fun subscription(subscription: Subscription) = subscription(JsonField.of(subscription))

        /** Sets [Builder.subscription] to an arbitrary JSON value. */
        fun subscription(subscription: JsonField<Subscription>) = apply {
            this.subscription = subscription
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
         * Returns an immutable instance of [AccountRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .monitorBilling()
         * .monitorsAllowed()
         * .monitorsUsed()
         * .plan()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AccountRetrieveResponse =
            AccountRetrieveResponse(
                checkRequired("monitorBilling", monitorBilling),
                checkRequired("monitorsAllowed", monitorsAllowed),
                checkRequired("monitorsUsed", monitorsUsed),
                checkRequired("plan", plan),
                creditInfo,
                xUsername,
                subscription,
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
    fun validate(): AccountRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        monitorBilling().validate()
        monitorsAllowed.getRequired("monitorsAllowed")
        monitorsUsed()
        plan().validate()
        creditInfo().ifPresent { it.validate() }
        xUsername()
        subscription().ifPresent { it.validate() }
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
        (monitorBilling.asKnown().getOrNull()?.validity() ?: 0) +
            (if (monitorsAllowed.asKnown().isPresent) 1 else 0) +
            (if (monitorsUsed.asKnown().isPresent) 1 else 0) +
            (plan.asKnown().getOrNull()?.validity() ?: 0) +
            (creditInfo.asKnown().getOrNull()?.validity() ?: 0) +
            (if (xUsername.asKnown().isPresent) 1 else 0) +
            (subscription.asKnown().getOrNull()?.validity() ?: 0)

    class MonitorBilling
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val activeDailyEstimate: JsonField<String>,
        private val activeHourlyBurn: JsonField<String>,
        private val creditsPerActiveMonitorDay: JsonField<String>,
        private val creditsPerActiveMonitorHour: JsonField<String>,
        private val eventsIncluded: JsonField<Boolean>,
        private val instantCheckIntervalSeconds: JsonField<Long>,
        private val unlimitedSlots: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("activeDailyEstimate")
            @ExcludeMissing
            activeDailyEstimate: JsonField<String> = JsonMissing.of(),
            @JsonProperty("activeHourlyBurn")
            @ExcludeMissing
            activeHourlyBurn: JsonField<String> = JsonMissing.of(),
            @JsonProperty("creditsPerActiveMonitorDay")
            @ExcludeMissing
            creditsPerActiveMonitorDay: JsonField<String> = JsonMissing.of(),
            @JsonProperty("creditsPerActiveMonitorHour")
            @ExcludeMissing
            creditsPerActiveMonitorHour: JsonField<String> = JsonMissing.of(),
            @JsonProperty("eventsIncluded")
            @ExcludeMissing
            eventsIncluded: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("instantCheckIntervalSeconds")
            @ExcludeMissing
            instantCheckIntervalSeconds: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("unlimitedSlots")
            @ExcludeMissing
            unlimitedSlots: JsonField<Boolean> = JsonMissing.of(),
        ) : this(
            activeDailyEstimate,
            activeHourlyBurn,
            creditsPerActiveMonitorDay,
            creditsPerActiveMonitorHour,
            eventsIncluded,
            instantCheckIntervalSeconds,
            unlimitedSlots,
            mutableMapOf(),
        )

        /**
         * Estimated daily credits for currently active monitors.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun activeDailyEstimate(): String = activeDailyEstimate.getRequired("activeDailyEstimate")

        /**
         * Credits charged each hour for currently active monitors.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun activeHourlyBurn(): String = activeHourlyBurn.getRequired("activeHourlyBurn")

        /**
         * Rounded daily estimate for 1 active monitor.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun creditsPerActiveMonitorDay(): String =
            creditsPerActiveMonitorDay.getRequired("creditsPerActiveMonitorDay")

        /**
         * Hourly credits charged for 1 active monitor.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun creditsPerActiveMonitorHour(): String =
            creditsPerActiveMonitorHour.getRequired("creditsPerActiveMonitorHour")

        /**
         * Webhook and event deliveries are included in monitor billing.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun eventsIncluded(): Boolean = eventsIncluded.getRequired("eventsIncluded")

        /**
         * Active monitors check every 1 second.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun instantCheckIntervalSeconds(): Long =
            instantCheckIntervalSeconds.getRequired("instantCheckIntervalSeconds")

        /**
         * Monitor slot count is unlimited.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun unlimitedSlots(): Boolean = unlimitedSlots.getRequired("unlimitedSlots")

        /**
         * Returns the raw JSON value of [activeDailyEstimate].
         *
         * Unlike [activeDailyEstimate], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("activeDailyEstimate")
        @ExcludeMissing
        fun _activeDailyEstimate(): JsonField<String> = activeDailyEstimate

        /**
         * Returns the raw JSON value of [activeHourlyBurn].
         *
         * Unlike [activeHourlyBurn], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("activeHourlyBurn")
        @ExcludeMissing
        fun _activeHourlyBurn(): JsonField<String> = activeHourlyBurn

        /**
         * Returns the raw JSON value of [creditsPerActiveMonitorDay].
         *
         * Unlike [creditsPerActiveMonitorDay], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("creditsPerActiveMonitorDay")
        @ExcludeMissing
        fun _creditsPerActiveMonitorDay(): JsonField<String> = creditsPerActiveMonitorDay

        /**
         * Returns the raw JSON value of [creditsPerActiveMonitorHour].
         *
         * Unlike [creditsPerActiveMonitorHour], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("creditsPerActiveMonitorHour")
        @ExcludeMissing
        fun _creditsPerActiveMonitorHour(): JsonField<String> = creditsPerActiveMonitorHour

        /**
         * Returns the raw JSON value of [eventsIncluded].
         *
         * Unlike [eventsIncluded], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("eventsIncluded")
        @ExcludeMissing
        fun _eventsIncluded(): JsonField<Boolean> = eventsIncluded

        /**
         * Returns the raw JSON value of [instantCheckIntervalSeconds].
         *
         * Unlike [instantCheckIntervalSeconds], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("instantCheckIntervalSeconds")
        @ExcludeMissing
        fun _instantCheckIntervalSeconds(): JsonField<Long> = instantCheckIntervalSeconds

        /**
         * Returns the raw JSON value of [unlimitedSlots].
         *
         * Unlike [unlimitedSlots], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("unlimitedSlots")
        @ExcludeMissing
        fun _unlimitedSlots(): JsonField<Boolean> = unlimitedSlots

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
             * Returns a mutable builder for constructing an instance of [MonitorBilling].
             *
             * The following fields are required:
             * ```java
             * .activeDailyEstimate()
             * .activeHourlyBurn()
             * .creditsPerActiveMonitorDay()
             * .creditsPerActiveMonitorHour()
             * .eventsIncluded()
             * .instantCheckIntervalSeconds()
             * .unlimitedSlots()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [MonitorBilling]. */
        class Builder internal constructor() {

            private var activeDailyEstimate: JsonField<String>? = null
            private var activeHourlyBurn: JsonField<String>? = null
            private var creditsPerActiveMonitorDay: JsonField<String>? = null
            private var creditsPerActiveMonitorHour: JsonField<String>? = null
            private var eventsIncluded: JsonField<Boolean>? = null
            private var instantCheckIntervalSeconds: JsonField<Long>? = null
            private var unlimitedSlots: JsonField<Boolean>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(monitorBilling: MonitorBilling) = apply {
                activeDailyEstimate = monitorBilling.activeDailyEstimate
                activeHourlyBurn = monitorBilling.activeHourlyBurn
                creditsPerActiveMonitorDay = monitorBilling.creditsPerActiveMonitorDay
                creditsPerActiveMonitorHour = monitorBilling.creditsPerActiveMonitorHour
                eventsIncluded = monitorBilling.eventsIncluded
                instantCheckIntervalSeconds = monitorBilling.instantCheckIntervalSeconds
                unlimitedSlots = monitorBilling.unlimitedSlots
                additionalProperties = monitorBilling.additionalProperties.toMutableMap()
            }

            /** Estimated daily credits for currently active monitors. */
            fun activeDailyEstimate(activeDailyEstimate: String) =
                activeDailyEstimate(JsonField.of(activeDailyEstimate))

            /** Sets [Builder.activeDailyEstimate] to an arbitrary JSON value. */
            fun activeDailyEstimate(activeDailyEstimate: JsonField<String>) = apply {
                this.activeDailyEstimate = activeDailyEstimate
            }

            /** Credits charged each hour for currently active monitors. */
            fun activeHourlyBurn(activeHourlyBurn: String) =
                activeHourlyBurn(JsonField.of(activeHourlyBurn))

            /** Sets [Builder.activeHourlyBurn] to an arbitrary JSON value. */
            fun activeHourlyBurn(activeHourlyBurn: JsonField<String>) = apply {
                this.activeHourlyBurn = activeHourlyBurn
            }

            /** Rounded daily estimate for 1 active monitor. */
            fun creditsPerActiveMonitorDay(creditsPerActiveMonitorDay: String) =
                creditsPerActiveMonitorDay(JsonField.of(creditsPerActiveMonitorDay))

            /** Sets [Builder.creditsPerActiveMonitorDay] to an arbitrary JSON value. */
            fun creditsPerActiveMonitorDay(creditsPerActiveMonitorDay: JsonField<String>) = apply {
                this.creditsPerActiveMonitorDay = creditsPerActiveMonitorDay
            }

            /** Hourly credits charged for 1 active monitor. */
            fun creditsPerActiveMonitorHour(creditsPerActiveMonitorHour: String) =
                creditsPerActiveMonitorHour(JsonField.of(creditsPerActiveMonitorHour))

            /** Sets [Builder.creditsPerActiveMonitorHour] to an arbitrary JSON value. */
            fun creditsPerActiveMonitorHour(creditsPerActiveMonitorHour: JsonField<String>) =
                apply {
                    this.creditsPerActiveMonitorHour = creditsPerActiveMonitorHour
                }

            /** Webhook and event deliveries are included in monitor billing. */
            fun eventsIncluded(eventsIncluded: Boolean) =
                eventsIncluded(JsonField.of(eventsIncluded))

            /** Sets [Builder.eventsIncluded] to an arbitrary JSON value. */
            fun eventsIncluded(eventsIncluded: JsonField<Boolean>) = apply {
                this.eventsIncluded = eventsIncluded
            }

            /** Active monitors check every 1 second. */
            fun instantCheckIntervalSeconds(instantCheckIntervalSeconds: Long) =
                instantCheckIntervalSeconds(JsonField.of(instantCheckIntervalSeconds))

            /** Sets [Builder.instantCheckIntervalSeconds] to an arbitrary JSON value. */
            fun instantCheckIntervalSeconds(instantCheckIntervalSeconds: JsonField<Long>) = apply {
                this.instantCheckIntervalSeconds = instantCheckIntervalSeconds
            }

            /** Monitor slot count is unlimited. */
            fun unlimitedSlots(unlimitedSlots: Boolean) =
                unlimitedSlots(JsonField.of(unlimitedSlots))

            /** Sets [Builder.unlimitedSlots] to an arbitrary JSON value. */
            fun unlimitedSlots(unlimitedSlots: JsonField<Boolean>) = apply {
                this.unlimitedSlots = unlimitedSlots
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
             * Returns an immutable instance of [MonitorBilling].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .activeDailyEstimate()
             * .activeHourlyBurn()
             * .creditsPerActiveMonitorDay()
             * .creditsPerActiveMonitorHour()
             * .eventsIncluded()
             * .instantCheckIntervalSeconds()
             * .unlimitedSlots()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): MonitorBilling =
                MonitorBilling(
                    checkRequired("activeDailyEstimate", activeDailyEstimate),
                    checkRequired("activeHourlyBurn", activeHourlyBurn),
                    checkRequired("creditsPerActiveMonitorDay", creditsPerActiveMonitorDay),
                    checkRequired("creditsPerActiveMonitorHour", creditsPerActiveMonitorHour),
                    checkRequired("eventsIncluded", eventsIncluded),
                    checkRequired("instantCheckIntervalSeconds", instantCheckIntervalSeconds),
                    checkRequired("unlimitedSlots", unlimitedSlots),
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
        fun validate(): MonitorBilling = apply {
            if (validated) {
                return@apply
            }

            activeDailyEstimate()
            activeHourlyBurn()
            creditsPerActiveMonitorDay()
            creditsPerActiveMonitorHour()
            eventsIncluded()
            instantCheckIntervalSeconds()
            unlimitedSlots()
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
            (if (activeDailyEstimate.asKnown().isPresent) 1 else 0) +
                (if (activeHourlyBurn.asKnown().isPresent) 1 else 0) +
                (if (creditsPerActiveMonitorDay.asKnown().isPresent) 1 else 0) +
                (if (creditsPerActiveMonitorHour.asKnown().isPresent) 1 else 0) +
                (if (eventsIncluded.asKnown().isPresent) 1 else 0) +
                (if (instantCheckIntervalSeconds.asKnown().isPresent) 1 else 0) +
                (if (unlimitedSlots.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MonitorBilling &&
                activeDailyEstimate == other.activeDailyEstimate &&
                activeHourlyBurn == other.activeHourlyBurn &&
                creditsPerActiveMonitorDay == other.creditsPerActiveMonitorDay &&
                creditsPerActiveMonitorHour == other.creditsPerActiveMonitorHour &&
                eventsIncluded == other.eventsIncluded &&
                instantCheckIntervalSeconds == other.instantCheckIntervalSeconds &&
                unlimitedSlots == other.unlimitedSlots &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                activeDailyEstimate,
                activeHourlyBurn,
                creditsPerActiveMonitorDay,
                creditsPerActiveMonitorHour,
                eventsIncluded,
                instantCheckIntervalSeconds,
                unlimitedSlots,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "MonitorBilling{activeDailyEstimate=$activeDailyEstimate, activeHourlyBurn=$activeHourlyBurn, creditsPerActiveMonitorDay=$creditsPerActiveMonitorDay, creditsPerActiveMonitorHour=$creditsPerActiveMonitorHour, eventsIncluded=$eventsIncluded, instantCheckIntervalSeconds=$instantCheckIntervalSeconds, unlimitedSlots=$unlimitedSlots, additionalProperties=$additionalProperties}"
    }

    class Plan @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
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
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
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
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
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
        private val autoTopupAmountDollars: JsonField<Double>,
        private val autoTopupEnabled: JsonField<Boolean>,
        private val autoTopupThreshold: JsonField<String>,
        private val balance: JsonField<String>,
        private val lifetimePurchased: JsonField<String>,
        private val lifetimeUsed: JsonField<String>,
        private val autoTopupStopped: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("autoTopupAmountDollars")
            @ExcludeMissing
            autoTopupAmountDollars: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("autoTopupEnabled")
            @ExcludeMissing
            autoTopupEnabled: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("autoTopupThreshold")
            @ExcludeMissing
            autoTopupThreshold: JsonField<String> = JsonMissing.of(),
            @JsonProperty("balance") @ExcludeMissing balance: JsonField<String> = JsonMissing.of(),
            @JsonProperty("lifetimePurchased")
            @ExcludeMissing
            lifetimePurchased: JsonField<String> = JsonMissing.of(),
            @JsonProperty("lifetimeUsed")
            @ExcludeMissing
            lifetimeUsed: JsonField<String> = JsonMissing.of(),
            @JsonProperty("autoTopupStopped")
            @ExcludeMissing
            autoTopupStopped: JsonField<Boolean> = JsonMissing.of(),
        ) : this(
            autoTopupAmountDollars,
            autoTopupEnabled,
            autoTopupThreshold,
            balance,
            lifetimePurchased,
            lifetimeUsed,
            autoTopupStopped,
            mutableMapOf(),
        )

        /**
         * Dollar amount charged when automatic top-up runs.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun autoTopupAmountDollars(): Double =
            autoTopupAmountDollars.getRequired("autoTopupAmountDollars")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun autoTopupEnabled(): Boolean = autoTopupEnabled.getRequired("autoTopupEnabled")

        /**
         * Bigint string threshold that triggers automatic top-up when enabled.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun autoTopupThreshold(): String = autoTopupThreshold.getRequired("autoTopupThreshold")

        /**
         * Bigint string to preserve precision above Number.MAX_SAFE_INTEGER.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun balance(): String = balance.getRequired("balance")

        /**
         * Total purchased credits as a bigint string.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun lifetimePurchased(): String = lifetimePurchased.getRequired("lifetimePurchased")

        /**
         * Total consumed credits as a bigint string.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun lifetimeUsed(): String = lifetimeUsed.getRequired("lifetimeUsed")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun autoTopupStopped(): Optional<Boolean> = autoTopupStopped.getOptional("autoTopupStopped")

        /**
         * Returns the raw JSON value of [autoTopupAmountDollars].
         *
         * Unlike [autoTopupAmountDollars], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("autoTopupAmountDollars")
        @ExcludeMissing
        fun _autoTopupAmountDollars(): JsonField<Double> = autoTopupAmountDollars

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
         * Returns the raw JSON value of [autoTopupThreshold].
         *
         * Unlike [autoTopupThreshold], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("autoTopupThreshold")
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
        @JsonProperty("lifetimePurchased")
        @ExcludeMissing
        fun _lifetimePurchased(): JsonField<String> = lifetimePurchased

        /**
         * Returns the raw JSON value of [lifetimeUsed].
         *
         * Unlike [lifetimeUsed], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("lifetimeUsed")
        @ExcludeMissing
        fun _lifetimeUsed(): JsonField<String> = lifetimeUsed

        /**
         * Returns the raw JSON value of [autoTopupStopped].
         *
         * Unlike [autoTopupStopped], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("autoTopupStopped")
        @ExcludeMissing
        fun _autoTopupStopped(): JsonField<Boolean> = autoTopupStopped

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

        /** A builder for [CreditInfo]. */
        class Builder internal constructor() {

            private var autoTopupAmountDollars: JsonField<Double>? = null
            private var autoTopupEnabled: JsonField<Boolean>? = null
            private var autoTopupThreshold: JsonField<String>? = null
            private var balance: JsonField<String>? = null
            private var lifetimePurchased: JsonField<String>? = null
            private var lifetimeUsed: JsonField<String>? = null
            private var autoTopupStopped: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(creditInfo: CreditInfo) = apply {
                autoTopupAmountDollars = creditInfo.autoTopupAmountDollars
                autoTopupEnabled = creditInfo.autoTopupEnabled
                autoTopupThreshold = creditInfo.autoTopupThreshold
                balance = creditInfo.balance
                lifetimePurchased = creditInfo.lifetimePurchased
                lifetimeUsed = creditInfo.lifetimeUsed
                autoTopupStopped = creditInfo.autoTopupStopped
                additionalProperties = creditInfo.additionalProperties.toMutableMap()
            }

            /** Dollar amount charged when automatic top-up runs. */
            fun autoTopupAmountDollars(autoTopupAmountDollars: Double) =
                autoTopupAmountDollars(JsonField.of(autoTopupAmountDollars))

            /** Sets [Builder.autoTopupAmountDollars] to an arbitrary JSON value. */
            fun autoTopupAmountDollars(autoTopupAmountDollars: JsonField<Double>) = apply {
                this.autoTopupAmountDollars = autoTopupAmountDollars
            }

            fun autoTopupEnabled(autoTopupEnabled: Boolean) =
                autoTopupEnabled(JsonField.of(autoTopupEnabled))

            /** Sets [Builder.autoTopupEnabled] to an arbitrary JSON value. */
            fun autoTopupEnabled(autoTopupEnabled: JsonField<Boolean>) = apply {
                this.autoTopupEnabled = autoTopupEnabled
            }

            /** Bigint string threshold that triggers automatic top-up when enabled. */
            fun autoTopupThreshold(autoTopupThreshold: String) =
                autoTopupThreshold(JsonField.of(autoTopupThreshold))

            /** Sets [Builder.autoTopupThreshold] to an arbitrary JSON value. */
            fun autoTopupThreshold(autoTopupThreshold: JsonField<String>) = apply {
                this.autoTopupThreshold = autoTopupThreshold
            }

            /** Bigint string to preserve precision above Number.MAX_SAFE_INTEGER. */
            fun balance(balance: String) = balance(JsonField.of(balance))

            /** Sets [Builder.balance] to an arbitrary JSON value. */
            fun balance(balance: JsonField<String>) = apply { this.balance = balance }

            /** Total purchased credits as a bigint string. */
            fun lifetimePurchased(lifetimePurchased: String) =
                lifetimePurchased(JsonField.of(lifetimePurchased))

            /** Sets [Builder.lifetimePurchased] to an arbitrary JSON value. */
            fun lifetimePurchased(lifetimePurchased: JsonField<String>) = apply {
                this.lifetimePurchased = lifetimePurchased
            }

            /** Total consumed credits as a bigint string. */
            fun lifetimeUsed(lifetimeUsed: String) = lifetimeUsed(JsonField.of(lifetimeUsed))

            /** Sets [Builder.lifetimeUsed] to an arbitrary JSON value. */
            fun lifetimeUsed(lifetimeUsed: JsonField<String>) = apply {
                this.lifetimeUsed = lifetimeUsed
            }

            fun autoTopupStopped(autoTopupStopped: Boolean) =
                autoTopupStopped(JsonField.of(autoTopupStopped))

            /** Sets [Builder.autoTopupStopped] to an arbitrary JSON value. */
            fun autoTopupStopped(autoTopupStopped: JsonField<Boolean>) = apply {
                this.autoTopupStopped = autoTopupStopped
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
            fun build(): CreditInfo =
                CreditInfo(
                    checkRequired("autoTopupAmountDollars", autoTopupAmountDollars),
                    checkRequired("autoTopupEnabled", autoTopupEnabled),
                    checkRequired("autoTopupThreshold", autoTopupThreshold),
                    checkRequired("balance", balance),
                    checkRequired("lifetimePurchased", lifetimePurchased),
                    checkRequired("lifetimeUsed", lifetimeUsed),
                    autoTopupStopped,
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
        fun validate(): CreditInfo = apply {
            if (validated) {
                return@apply
            }

            autoTopupAmountDollars()
            autoTopupEnabled()
            autoTopupThreshold()
            balance()
            lifetimePurchased()
            lifetimeUsed()
            autoTopupStopped()
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
            (if (autoTopupAmountDollars.asKnown().isPresent) 1 else 0) +
                (if (autoTopupEnabled.asKnown().isPresent) 1 else 0) +
                (if (autoTopupThreshold.asKnown().isPresent) 1 else 0) +
                (if (balance.asKnown().isPresent) 1 else 0) +
                (if (lifetimePurchased.asKnown().isPresent) 1 else 0) +
                (if (lifetimeUsed.asKnown().isPresent) 1 else 0) +
                (if (autoTopupStopped.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CreditInfo &&
                autoTopupAmountDollars == other.autoTopupAmountDollars &&
                autoTopupEnabled == other.autoTopupEnabled &&
                autoTopupThreshold == other.autoTopupThreshold &&
                balance == other.balance &&
                lifetimePurchased == other.lifetimePurchased &&
                lifetimeUsed == other.lifetimeUsed &&
                autoTopupStopped == other.autoTopupStopped &&
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
                autoTopupStopped,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CreditInfo{autoTopupAmountDollars=$autoTopupAmountDollars, autoTopupEnabled=$autoTopupEnabled, autoTopupThreshold=$autoTopupThreshold, balance=$balance, lifetimePurchased=$lifetimePurchased, lifetimeUsed=$lifetimeUsed, autoTopupStopped=$autoTopupStopped, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountRetrieveResponse &&
            monitorBilling == other.monitorBilling &&
            monitorsAllowed == other.monitorsAllowed &&
            monitorsUsed == other.monitorsUsed &&
            plan == other.plan &&
            creditInfo == other.creditInfo &&
            xUsername == other.xUsername &&
            subscription == other.subscription &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            monitorBilling,
            monitorsAllowed,
            monitorsUsed,
            plan,
            creditInfo,
            xUsername,
            subscription,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AccountRetrieveResponse{monitorBilling=$monitorBilling, monitorsAllowed=$monitorsAllowed, monitorsUsed=$monitorsUsed, plan=$plan, creditInfo=$creditInfo, xUsername=$xUsername, subscription=$subscription, additionalProperties=$additionalProperties}"

    class Subscription
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val status: JsonField<Status>,
        private val tier: JsonField<Tier>,
        private val currentPeriodStart: JsonField<OffsetDateTime>,
        private val currentPeriodEnd: JsonField<OffsetDateTime>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {
        @JsonCreator
        private constructor(
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("tier") @ExcludeMissing tier: JsonField<Tier> = JsonMissing.of(),
            @JsonProperty("currentPeriodStart")
            @ExcludeMissing
            currentPeriodStart: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("currentPeriodEnd")
            @ExcludeMissing
            currentPeriodEnd: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(
            status,
            tier,
            currentPeriodStart,
            currentPeriodEnd,
            mutableMapOf(),
        )

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun status(): Optional<Status> = status.getOptional("status")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun tier(): Optional<Tier> = tier.getOptional("tier")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun currentPeriodStart(): Optional<OffsetDateTime> =
            currentPeriodStart.getOptional("currentPeriodStart")

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun currentPeriodEnd(): Optional<OffsetDateTime> =
            currentPeriodEnd.getOptional("currentPeriodEnd")

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [tier].
         *
         * Unlike [tier], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tier") @ExcludeMissing fun _tier(): JsonField<Tier> = tier

        /**
         * Returns the raw JSON value of [currentPeriodStart].
         *
         * Unlike [currentPeriodStart], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("currentPeriodStart")
        @ExcludeMissing
        fun _currentPeriodStart(): JsonField<OffsetDateTime> = currentPeriodStart

        /**
         * Returns the raw JSON value of [currentPeriodEnd].
         *
         * Unlike [currentPeriodEnd], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("currentPeriodEnd")
        @ExcludeMissing
        fun _currentPeriodEnd(): JsonField<OffsetDateTime> = currentPeriodEnd

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
            /** Returns a mutable builder for constructing an instance of [Subscription]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Subscription]. */
        class Builder internal constructor() {
            private var status: JsonField<Status> = JsonMissing.of()
            private var tier: JsonField<Tier> = JsonMissing.of()
            private var currentPeriodStart: JsonField<OffsetDateTime> = JsonMissing.of()
            private var currentPeriodEnd: JsonField<OffsetDateTime> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(subscription: Subscription) = apply {
                status = subscription.status
                tier = subscription.tier
                currentPeriodStart = subscription.currentPeriodStart
                currentPeriodEnd = subscription.currentPeriodEnd
                additionalProperties = subscription.additionalProperties.toMutableMap()
            }

            fun status(status: Status) = status(JsonField.of(status))

            /** Sets [Builder.status] to an arbitrary JSON value. */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            fun tier(tier: Tier) = tier(JsonField.of(tier))

            /** Sets [Builder.tier] to an arbitrary JSON value. */
            fun tier(tier: JsonField<Tier>) = apply { this.tier = tier }

            fun currentPeriodStart(currentPeriodStart: OffsetDateTime) =
                currentPeriodStart(JsonField.of(currentPeriodStart))

            /** Sets [Builder.currentPeriodStart] to an arbitrary JSON value. */
            fun currentPeriodStart(currentPeriodStart: JsonField<OffsetDateTime>) = apply {
                this.currentPeriodStart = currentPeriodStart
            }

            fun currentPeriodEnd(currentPeriodEnd: OffsetDateTime) =
                currentPeriodEnd(JsonField.of(currentPeriodEnd))

            /** Sets [Builder.currentPeriodEnd] to an arbitrary JSON value. */
            fun currentPeriodEnd(currentPeriodEnd: JsonField<OffsetDateTime>) = apply {
                this.currentPeriodEnd = currentPeriodEnd
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
             * Returns an immutable instance of [Subscription].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Subscription =
                Subscription(
                    status,
                    tier,
                    currentPeriodStart,
                    currentPeriodEnd,
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
        fun validate(): Subscription = apply {
            if (validated) {
                return@apply
            }
            status().ifPresent { it.validate() }
            tier().ifPresent { it.validate() }
            currentPeriodStart()
            currentPeriodEnd()
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
            (status.asKnown().getOrNull()?.validity() ?: 0) +
                (tier.asKnown().getOrNull()?.validity() ?: 0) +
                (if (currentPeriodStart.asKnown().isPresent) 1 else 0) +
                (if (currentPeriodEnd.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }
            return other is Subscription &&
                status == other.status &&
                tier == other.tier &&
                currentPeriodStart == other.currentPeriodStart &&
                currentPeriodEnd == other.currentPeriodEnd &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(status, tier, currentPeriodStart, currentPeriodEnd, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Subscription{status=$status, tier=$tier, currentPeriodStart=$currentPeriodStart, currentPeriodEnd=$currentPeriodEnd, additionalProperties=$additionalProperties}"

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val NONE = of("none")

                @JvmField val ACTIVE = of("active")

                @JvmField val PAST_DUE = of("past_due")

                @JvmField val CANCELING = of("canceling")

                @JvmField val INCOMPLETE = of("incomplete")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                NONE,
                ACTIVE,
                PAST_DUE,
                CANCELING,
                INCOMPLETE,
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
                NONE,
                ACTIVE,
                PAST_DUE,
                CANCELING,
                INCOMPLETE,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             */
            fun value(): Value =
                when (this) {
                    NONE -> Value.NONE
                    ACTIVE -> Value.ACTIVE
                    PAST_DUE -> Value.PAST_DUE
                    CANCELING -> Value.CANCELING
                    INCOMPLETE -> Value.INCOMPLETE
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
                    NONE -> Known.NONE
                    ACTIVE -> Known.ACTIVE
                    PAST_DUE -> Known.PAST_DUE
                    CANCELING -> Known.CANCELING
                    INCOMPLETE -> Known.INCOMPLETE
                    else -> throw XTwitterScraperInvalidDataException("Unknown Status: $value")
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

        class Tier @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /** Returns this class instance's raw value. */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val STARTER = of("starter")

                @JvmField val PRO = of("pro")

                @JvmField val BUSINESS = of("business")

                @JvmStatic fun of(value: String) = Tier(JsonField.of(value))
            }

            /** An enum containing [Tier]'s known values. */
            enum class Known {
                STARTER,
                PRO,
                BUSINESS,
            }

            /**
             * An enum containing [Tier]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Tier] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                STARTER,
                PRO,
                BUSINESS,
                /** An enum member indicating that [Tier] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             */
            fun value(): Value =
                when (this) {
                    STARTER -> Value.STARTER
                    PRO -> Value.PRO
                    BUSINESS -> Value.BUSINESS
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
                    STARTER -> Known.STARTER
                    PRO -> Known.PRO
                    BUSINESS -> Known.BUSINESS
                    else -> throw XTwitterScraperInvalidDataException("Unknown Tier: $value")
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
            fun validate(): Tier = apply {
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

                return other is Tier && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }
    }
}
