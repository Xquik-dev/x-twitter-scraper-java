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
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** How many people on X picked a team to root for. */
class SportsGameAudienceTeamPicks
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val total: JsonField<Long>,
    private val teams: JsonField<List<SportsGameAudienceTeamPick>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("teams") @ExcludeMissing teams: JsonField<List<SportsGameAudienceTeamPick>> = JsonMissing.of(),
    ) : this(total, teams, mutableMapOf())

    /** Picks for every team in the game. */
    fun total(): Optional<Long> = total.getOptional("total")

    /** Picks per team. */
    fun teams(): List<SportsGameAudienceTeamPick> = teams.getRequired("teams")

    /** Returns the raw JSON value of [total]. */
    @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

    /** Returns the raw JSON value of [teams]. */
    @JsonProperty("teams") @ExcludeMissing fun _teams(): JsonField<List<SportsGameAudienceTeamPick>> = teams

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

        /** Returns a mutable builder for constructing an instance of [SportsGameAudienceTeamPicks]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SportsGameAudienceTeamPicks]. */
    class Builder internal constructor() {

        private var total: JsonField<Long>? = null
        private var teams: JsonField<MutableList<SportsGameAudienceTeamPick>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(sportsGameAudienceTeamPicks: SportsGameAudienceTeamPicks) = apply {
            total = sportsGameAudienceTeamPicks.total
            teams = sportsGameAudienceTeamPicks.teams.map { it.toMutableList() }
            additionalProperties = sportsGameAudienceTeamPicks.additionalProperties.toMutableMap()
        }

        /** Picks for every team in the game. */
        fun total(total: Long?) = total(JsonField.ofNullable(total))

        fun total(total: Long) = total(total as Long?)

        fun total(total: Optional<Long>) = total(total.getOrNull())

        /** Sets [Builder.total] to an arbitrary JSON value. */
        fun total(total: JsonField<Long>) = apply { this.total = total }

        /** Picks per team. */
        fun teams(teams: List<SportsGameAudienceTeamPick>) = teams(JsonField.of(teams))

        /** Sets [Builder.teams] to an arbitrary JSON value. */
        fun teams(teams: JsonField<List<SportsGameAudienceTeamPick>>) = apply { this.teams = teams.map { it.toMutableList() } }

        /** Adds a single [SportsGameAudienceTeamPick] to [teams]. */
        fun addTeam(team: SportsGameAudienceTeamPick) = apply {
            teams =
                (teams ?: JsonField.of(mutableListOf())).also {
                    checkKnown("teams", it).add(team)
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
         * Returns an immutable instance of [SportsGameAudienceTeamPicks].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SportsGameAudienceTeamPicks =
            SportsGameAudienceTeamPicks(
                checkRequired("total", total),
                checkRequired("teams", teams).map { it.toImmutable() },
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
    fun validate(): SportsGameAudienceTeamPicks = apply {
        if (validated) {
            return@apply
        }

        total()
        teams().forEach { it.validate() }
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
        (if (total.asKnown().isPresent) 1 else 0) +
            (teams.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SportsGameAudienceTeamPicks &&
            total == other.total &&
            teams == other.teams &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(total, teams, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SportsGameAudienceTeamPicks{total=$total, teams=$teams, additionalProperties=$additionalProperties}"
}
