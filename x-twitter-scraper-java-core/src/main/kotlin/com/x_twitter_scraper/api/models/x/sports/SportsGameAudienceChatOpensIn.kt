// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.sports

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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Time left until the chat opens. Null while it is open & after the game. */
class SportsGameAudienceChatOpensIn
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val days: JsonField<Long>,
    private val hours: JsonField<Long>,
    private val minutes: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("days") @ExcludeMissing days: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("hours") @ExcludeMissing hours: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("minutes") @ExcludeMissing minutes: JsonField<Long> = JsonMissing.of(),
    ) : this(days, hours, minutes, mutableMapOf())

    /** Whole days left. */
    fun days(): Optional<Long> = days.getOptional("days")

    /** Hours left after the days. */
    fun hours(): Optional<Long> = hours.getOptional("hours")

    /** Minutes left after the hours. */
    fun minutes(): Optional<Long> = minutes.getOptional("minutes")

    /** Returns the raw JSON value of [days]. */
    @JsonProperty("days") @ExcludeMissing fun _days(): JsonField<Long> = days

    /** Returns the raw JSON value of [hours]. */
    @JsonProperty("hours") @ExcludeMissing fun _hours(): JsonField<Long> = hours

    /** Returns the raw JSON value of [minutes]. */
    @JsonProperty("minutes") @ExcludeMissing fun _minutes(): JsonField<Long> = minutes

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

        /** Returns a mutable builder for constructing an instance of [SportsGameAudienceChatOpensIn]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SportsGameAudienceChatOpensIn]. */
    class Builder internal constructor() {

        private var days: JsonField<Long>? = null
        private var hours: JsonField<Long>? = null
        private var minutes: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(sportsGameAudienceChatOpensIn: SportsGameAudienceChatOpensIn) = apply {
            days = sportsGameAudienceChatOpensIn.days
            hours = sportsGameAudienceChatOpensIn.hours
            minutes = sportsGameAudienceChatOpensIn.minutes
            additionalProperties = sportsGameAudienceChatOpensIn.additionalProperties.toMutableMap()
        }

        /** Whole days left. */
        fun days(days: Long?) = days(JsonField.ofNullable(days))

        fun days(days: Long) = days(days as Long?)

        fun days(days: Optional<Long>) = days(days.getOrNull())

        /** Sets [Builder.days] to an arbitrary JSON value. */
        fun days(days: JsonField<Long>) = apply { this.days = days }

        /** Hours left after the days. */
        fun hours(hours: Long?) = hours(JsonField.ofNullable(hours))

        fun hours(hours: Long) = hours(hours as Long?)

        fun hours(hours: Optional<Long>) = hours(hours.getOrNull())

        /** Sets [Builder.hours] to an arbitrary JSON value. */
        fun hours(hours: JsonField<Long>) = apply { this.hours = hours }

        /** Minutes left after the hours. */
        fun minutes(minutes: Long?) = minutes(JsonField.ofNullable(minutes))

        fun minutes(minutes: Long) = minutes(minutes as Long?)

        fun minutes(minutes: Optional<Long>) = minutes(minutes.getOrNull())

        /** Sets [Builder.minutes] to an arbitrary JSON value. */
        fun minutes(minutes: JsonField<Long>) = apply { this.minutes = minutes }

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
         * Returns an immutable instance of [SportsGameAudienceChatOpensIn].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SportsGameAudienceChatOpensIn =
            SportsGameAudienceChatOpensIn(
                checkRequired("days", days),
                checkRequired("hours", hours),
                checkRequired("minutes", minutes),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match
     *   its expected type.
     */
    fun validate(): SportsGameAudienceChatOpensIn = apply {
        if (validated) {
            return@apply
        }

        days()
        hours()
        minutes()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    @JvmSynthetic internal fun validity(): Int =
        (if (days.asKnown().isPresent) 1 else 0) +
            (if (hours.asKnown().isPresent) 1 else 0) +
            (if (minutes.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SportsGameAudienceChatOpensIn &&
            days == other.days &&
            hours == other.hours &&
            minutes == other.minutes &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(days, hours, minutes, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SportsGameAudienceChatOpensIn{days=$days, hours=$hours, minutes=$minutes, additionalProperties=$additionalProperties}"
}
