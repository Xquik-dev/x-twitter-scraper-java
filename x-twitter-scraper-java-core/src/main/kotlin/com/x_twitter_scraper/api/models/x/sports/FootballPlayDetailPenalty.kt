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

/** The penalty this step called, or null. */
class FootballPlayDetailPenalty
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val description: JsonField<String>,
    private val nextDown: JsonField<String>,
    private val result: JsonField<String>,
    private val teamId: JsonField<String>,
    private val yards: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("description") @ExcludeMissing description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("nextDown") @ExcludeMissing nextDown: JsonField<String> = JsonMissing.of(),
        @JsonProperty("result") @ExcludeMissing result: JsonField<String> = JsonMissing.of(),
        @JsonProperty("teamId") @ExcludeMissing teamId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("yards") @ExcludeMissing yards: JsonField<Long> = JsonMissing.of(),
    ) : this(description, nextDown, result, teamId, yards, mutableMapOf())

    /** The penalty's name. */
    fun description(): Optional<String> = description.getOptional("description")

    /** What the penalty does to the down. */
    fun nextDown(): Optional<String> = nextDown.getOptional("nextDown")

    /** Whether the penalty was accepted or declined. */
    fun result(): Optional<String> = result.getOptional("result")

    /** The penalized team, a key of teams. */
    fun teamId(): Optional<String> = teamId.getOptional("teamId")

    /** The penalty's yards. */
    fun yards(): Optional<Long> = yards.getOptional("yards")

    /** Returns the raw JSON value of [description]. */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /** Returns the raw JSON value of [nextDown]. */
    @JsonProperty("nextDown") @ExcludeMissing fun _nextDown(): JsonField<String> = nextDown

    /** Returns the raw JSON value of [result]. */
    @JsonProperty("result") @ExcludeMissing fun _result(): JsonField<String> = result

    /** Returns the raw JSON value of [teamId]. */
    @JsonProperty("teamId") @ExcludeMissing fun _teamId(): JsonField<String> = teamId

    /** Returns the raw JSON value of [yards]. */
    @JsonProperty("yards") @ExcludeMissing fun _yards(): JsonField<Long> = yards

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

        /** Returns a mutable builder for constructing an instance of [FootballPlayDetailPenalty]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPlayDetailPenalty]. */
    class Builder internal constructor() {

        private var description: JsonField<String>? = null
        private var nextDown: JsonField<String>? = null
        private var result: JsonField<String>? = null
        private var teamId: JsonField<String>? = null
        private var yards: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballPlayDetailPenalty: FootballPlayDetailPenalty) = apply {
            description = footballPlayDetailPenalty.description
            nextDown = footballPlayDetailPenalty.nextDown
            result = footballPlayDetailPenalty.result
            teamId = footballPlayDetailPenalty.teamId
            yards = footballPlayDetailPenalty.yards
            additionalProperties = footballPlayDetailPenalty.additionalProperties.toMutableMap()
        }

        /** The penalty's name. */
        fun description(description: String?) = description(JsonField.ofNullable(description))

        fun description(description: Optional<String>) = description(description.getOrNull())

        /** Sets [Builder.description] to an arbitrary JSON value. */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** What the penalty does to the down. */
        fun nextDown(nextDown: String?) = nextDown(JsonField.ofNullable(nextDown))

        fun nextDown(nextDown: Optional<String>) = nextDown(nextDown.getOrNull())

        /** Sets [Builder.nextDown] to an arbitrary JSON value. */
        fun nextDown(nextDown: JsonField<String>) = apply { this.nextDown = nextDown }

        /** Whether the penalty was accepted or declined. */
        fun result(result: String?) = result(JsonField.ofNullable(result))

        fun result(result: Optional<String>) = result(result.getOrNull())

        /** Sets [Builder.result] to an arbitrary JSON value. */
        fun result(result: JsonField<String>) = apply { this.result = result }

        /** The penalized team, a key of teams. */
        fun teamId(teamId: String?) = teamId(JsonField.ofNullable(teamId))

        fun teamId(teamId: Optional<String>) = teamId(teamId.getOrNull())

        /** Sets [Builder.teamId] to an arbitrary JSON value. */
        fun teamId(teamId: JsonField<String>) = apply { this.teamId = teamId }

        /** The penalty's yards. */
        fun yards(yards: Long?) = yards(JsonField.ofNullable(yards))

        fun yards(yards: Long) = yards(yards as Long?)

        fun yards(yards: Optional<Long>) = yards(yards.getOrNull())

        /** Sets [Builder.yards] to an arbitrary JSON value. */
        fun yards(yards: JsonField<Long>) = apply { this.yards = yards }

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
         * Returns an immutable instance of [FootballPlayDetailPenalty].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPlayDetailPenalty =
            FootballPlayDetailPenalty(
                checkRequired("description", description),
                checkRequired("nextDown", nextDown),
                checkRequired("result", result),
                checkRequired("teamId", teamId),
                checkRequired("yards", yards),
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
    fun validate(): FootballPlayDetailPenalty = apply {
        if (validated) {
            return@apply
        }

        description()
        nextDown()
        result()
        teamId()
        yards()
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
        (if (description.asKnown().isPresent) 1 else 0) +
            (if (nextDown.asKnown().isPresent) 1 else 0) +
            (if (result.asKnown().isPresent) 1 else 0) +
            (if (teamId.asKnown().isPresent) 1 else 0) +
            (if (yards.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPlayDetailPenalty &&
            description == other.description &&
            nextDown == other.nextDown &&
            result == other.result &&
            teamId == other.teamId &&
            yards == other.yards &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(description, nextDown, result, teamId, yards, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPlayDetailPenalty{description=$description, nextDown=$nextDown, result=$result, teamId=$teamId, yards=$yards, additionalProperties=$additionalProperties}"
}
