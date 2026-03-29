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
import java.time.OffsetDateTime
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
    private val currentPeriod: JsonField<CurrentPeriod>,
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
        @JsonProperty("currentPeriod")
        @ExcludeMissing
        currentPeriod: JsonField<CurrentPeriod> = JsonMissing.of(),
    ) : this(monitorsAllowed, monitorsUsed, plan, currentPeriod, mutableMapOf())

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
    fun currentPeriod(): Optional<CurrentPeriod> = currentPeriod.getOptional("currentPeriod")

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
     * Returns the raw JSON value of [currentPeriod].
     *
     * Unlike [currentPeriod], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("currentPeriod")
    @ExcludeMissing
    fun _currentPeriod(): JsonField<CurrentPeriod> = currentPeriod

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
        private var currentPeriod: JsonField<CurrentPeriod> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountRetrieveResponse: AccountRetrieveResponse) = apply {
            monitorsAllowed = accountRetrieveResponse.monitorsAllowed
            monitorsUsed = accountRetrieveResponse.monitorsUsed
            plan = accountRetrieveResponse.plan
            currentPeriod = accountRetrieveResponse.currentPeriod
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

        fun currentPeriod(currentPeriod: CurrentPeriod) = currentPeriod(JsonField.of(currentPeriod))

        /**
         * Sets [Builder.currentPeriod] to an arbitrary JSON value.
         *
         * You should usually call [Builder.currentPeriod] with a well-typed [CurrentPeriod] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun currentPeriod(currentPeriod: JsonField<CurrentPeriod>) = apply {
            this.currentPeriod = currentPeriod
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
                currentPeriod,
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
        currentPeriod().ifPresent { it.validate() }
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
            (currentPeriod.asKnown().getOrNull()?.validity() ?: 0)

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

    class CurrentPeriod
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val end: JsonField<OffsetDateTime>,
        private val start: JsonField<OffsetDateTime>,
        private val usagePercent: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("end") @ExcludeMissing end: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("start")
            @ExcludeMissing
            start: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("usagePercent")
            @ExcludeMissing
            usagePercent: JsonField<Double> = JsonMissing.of(),
        ) : this(end, start, usagePercent, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun end(): OffsetDateTime = end.getRequired("end")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun start(): OffsetDateTime = start.getRequired("start")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun usagePercent(): Double = usagePercent.getRequired("usagePercent")

        /**
         * Returns the raw JSON value of [end].
         *
         * Unlike [end], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("end") @ExcludeMissing fun _end(): JsonField<OffsetDateTime> = end

        /**
         * Returns the raw JSON value of [start].
         *
         * Unlike [start], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("start") @ExcludeMissing fun _start(): JsonField<OffsetDateTime> = start

        /**
         * Returns the raw JSON value of [usagePercent].
         *
         * Unlike [usagePercent], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("usagePercent")
        @ExcludeMissing
        fun _usagePercent(): JsonField<Double> = usagePercent

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
             * Returns a mutable builder for constructing an instance of [CurrentPeriod].
             *
             * The following fields are required:
             * ```java
             * .end()
             * .start()
             * .usagePercent()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CurrentPeriod]. */
        class Builder internal constructor() {

            private var end: JsonField<OffsetDateTime>? = null
            private var start: JsonField<OffsetDateTime>? = null
            private var usagePercent: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(currentPeriod: CurrentPeriod) = apply {
                end = currentPeriod.end
                start = currentPeriod.start
                usagePercent = currentPeriod.usagePercent
                additionalProperties = currentPeriod.additionalProperties.toMutableMap()
            }

            fun end(end: OffsetDateTime) = end(JsonField.of(end))

            /**
             * Sets [Builder.end] to an arbitrary JSON value.
             *
             * You should usually call [Builder.end] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun end(end: JsonField<OffsetDateTime>) = apply { this.end = end }

            fun start(start: OffsetDateTime) = start(JsonField.of(start))

            /**
             * Sets [Builder.start] to an arbitrary JSON value.
             *
             * You should usually call [Builder.start] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun start(start: JsonField<OffsetDateTime>) = apply { this.start = start }

            fun usagePercent(usagePercent: Double) = usagePercent(JsonField.of(usagePercent))

            /**
             * Sets [Builder.usagePercent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.usagePercent] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun usagePercent(usagePercent: JsonField<Double>) = apply {
                this.usagePercent = usagePercent
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
             * Returns an immutable instance of [CurrentPeriod].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .end()
             * .start()
             * .usagePercent()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): CurrentPeriod =
                CurrentPeriod(
                    checkRequired("end", end),
                    checkRequired("start", start),
                    checkRequired("usagePercent", usagePercent),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): CurrentPeriod = apply {
            if (validated) {
                return@apply
            }

            end()
            start()
            usagePercent()
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
            (if (end.asKnown().isPresent) 1 else 0) +
                (if (start.asKnown().isPresent) 1 else 0) +
                (if (usagePercent.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CurrentPeriod &&
                end == other.end &&
                start == other.start &&
                usagePercent == other.usagePercent &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(end, start, usagePercent, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CurrentPeriod{end=$end, start=$start, usagePercent=$usagePercent, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountRetrieveResponse &&
            monitorsAllowed == other.monitorsAllowed &&
            monitorsUsed == other.monitorsUsed &&
            plan == other.plan &&
            currentPeriod == other.currentPeriod &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(monitorsAllowed, monitorsUsed, plan, currentPeriod, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AccountRetrieveResponse{monitorsAllowed=$monitorsAllowed, monitorsUsed=$monitorsUsed, plan=$plan, currentPeriod=$currentPeriod, additionalProperties=$additionalProperties}"
}
