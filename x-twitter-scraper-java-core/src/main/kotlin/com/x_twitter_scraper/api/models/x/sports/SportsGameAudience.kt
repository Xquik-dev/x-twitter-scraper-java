// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.sports

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

/** Who watches & roots for 1 game on X. */
class SportsGameAudience
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val league: JsonField<League>,
    private val viewers: JsonField<SportsGameAudienceViewers>,
    private val teamPicks: JsonField<SportsGameAudienceTeamPicks>,
    private val chat: JsonField<SportsGameAudienceChat>,
    private val teams: JsonField<Map<String, SportsTeam>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("league") @ExcludeMissing league: JsonField<League> = JsonMissing.of(),
        @JsonProperty("viewers") @ExcludeMissing viewers: JsonField<SportsGameAudienceViewers> = JsonMissing.of(),
        @JsonProperty("teamPicks") @ExcludeMissing teamPicks: JsonField<SportsGameAudienceTeamPicks> = JsonMissing.of(),
        @JsonProperty("chat") @ExcludeMissing chat: JsonField<SportsGameAudienceChat> = JsonMissing.of(),
        @JsonProperty("teams") @ExcludeMissing teams: JsonField<Map<String, SportsTeam>> = JsonMissing.of(),
    ) : this(id, league, viewers, teamPicks, chat, teams, mutableMapOf())

    /** The ID of the game, from your request. */
    fun id(): String = id.getRequired("id")

    /** The game's league, from your request. */
    fun league(): League = league.getRequired("league")

    /** People watching the game on X at X's last count. Null before X counts any, as before kickoff. */
    fun viewers(): Optional<SportsGameAudienceViewers> = viewers.getOptional("viewers")

    /** How many people on X picked a team to root for. */
    fun teamPicks(): SportsGameAudienceTeamPicks = teamPicks.getRequired("teamPicks")

    /** The game's live chat on X. */
    fun chat(): SportsGameAudienceChat = chat.getRequired("chat")

    /** The game's teams, by team ID. X's team picker sends no short name, alternate ID, X account or record, so those are null. */
    fun teams(): Map<String, SportsTeam> = teams.getRequired("teams")

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Returns the raw JSON value of [league]. */
    @JsonProperty("league") @ExcludeMissing fun _league(): JsonField<League> = league

    /** Returns the raw JSON value of [viewers]. */
    @JsonProperty("viewers") @ExcludeMissing fun _viewers(): JsonField<SportsGameAudienceViewers> = viewers

    /** Returns the raw JSON value of [teamPicks]. */
    @JsonProperty("teamPicks") @ExcludeMissing fun _teamPicks(): JsonField<SportsGameAudienceTeamPicks> = teamPicks

    /** Returns the raw JSON value of [chat]. */
    @JsonProperty("chat") @ExcludeMissing fun _chat(): JsonField<SportsGameAudienceChat> = chat

    /** Returns the raw JSON value of [teams]. */
    @JsonProperty("teams") @ExcludeMissing fun _teams(): JsonField<Map<String, SportsTeam>> = teams

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

        /** Returns a mutable builder for constructing an instance of [SportsGameAudience]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SportsGameAudience]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var league: JsonField<League>? = null
        private var viewers: JsonField<SportsGameAudienceViewers>? = null
        private var teamPicks: JsonField<SportsGameAudienceTeamPicks>? = null
        private var chat: JsonField<SportsGameAudienceChat>? = null
        private var teams: JsonField<Map<String, SportsTeam>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(sportsGameAudience: SportsGameAudience) = apply {
            id = sportsGameAudience.id
            league = sportsGameAudience.league
            viewers = sportsGameAudience.viewers
            teamPicks = sportsGameAudience.teamPicks
            chat = sportsGameAudience.chat
            teams = sportsGameAudience.teams
            additionalProperties = sportsGameAudience.additionalProperties.toMutableMap()
        }

        /** The ID of the game, from your request. */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The game's league, from your request. */
        fun league(league: League) = league(JsonField.of(league))

        /** Sets [Builder.league] to an arbitrary JSON value. */
        fun league(league: JsonField<League>) = apply { this.league = league }

        /** People watching the game on X at X's last count. Null before X counts any, as before kickoff. */
        fun viewers(viewers: SportsGameAudienceViewers?) = viewers(JsonField.ofNullable(viewers))

        fun viewers(viewers: Optional<SportsGameAudienceViewers>) = viewers(viewers.getOrNull())

        /** Sets [Builder.viewers] to an arbitrary JSON value. */
        fun viewers(viewers: JsonField<SportsGameAudienceViewers>) = apply { this.viewers = viewers }

        /** How many people on X picked a team to root for. */
        fun teamPicks(teamPicks: SportsGameAudienceTeamPicks) = teamPicks(JsonField.of(teamPicks))

        /** Sets [Builder.teamPicks] to an arbitrary JSON value. */
        fun teamPicks(teamPicks: JsonField<SportsGameAudienceTeamPicks>) = apply { this.teamPicks = teamPicks }

        /** The game's live chat on X. */
        fun chat(chat: SportsGameAudienceChat) = chat(JsonField.of(chat))

        /** Sets [Builder.chat] to an arbitrary JSON value. */
        fun chat(chat: JsonField<SportsGameAudienceChat>) = apply { this.chat = chat }

        /** The game's teams, by team ID. X's team picker sends no short name, alternate ID, X account or record, so those are null. */
        fun teams(teams: Map<String, SportsTeam>) = teams(JsonField.of(teams))

        /** Sets [Builder.teams] to an arbitrary JSON value. */
        fun teams(teams: JsonField<Map<String, SportsTeam>>) = apply { this.teams = teams }

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
         * Returns an immutable instance of [SportsGameAudience].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SportsGameAudience =
            SportsGameAudience(
                checkRequired("id", id),
                checkRequired("league", league),
                checkRequired("viewers", viewers),
                checkRequired("teamPicks", teamPicks),
                checkRequired("chat", chat),
                checkRequired("teams", teams),
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
    fun validate(): SportsGameAudience = apply {
        if (validated) {
            return@apply
        }

        id()
        league().validate()
        viewers().ifPresent { it.validate() }
        teamPicks().validate()
        chat().validate()
        teams().values.forEach { it.validate() }
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (league.asKnown().getOrNull()?.validity() ?: 0) +
            (viewers.asKnown().getOrNull()?.validity() ?: 0) +
            (teamPicks.asKnown().getOrNull()?.validity() ?: 0) +
            (chat.asKnown().getOrNull()?.validity() ?: 0) +
            (teams.asKnown().getOrNull()?.values?.sumOf { it.validity() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SportsGameAudience &&
            id == other.id &&
            league == other.league &&
            viewers == other.viewers &&
            teamPicks == other.teamPicks &&
            chat == other.chat &&
            teams == other.teams &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, league, viewers, teamPicks, chat, teams, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SportsGameAudience{id=$id, league=$league, viewers=$viewers, teamPicks=$teamPicks, chat=$chat, teams=$teams, additionalProperties=$additionalProperties}"

    class League @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val NFL = of("nfl")

            @JvmField val NCAAFB = of("ncaafb")

            @JvmStatic fun of(value: String) = League(JsonField.of(value))
        }

        /** An enum containing [League]'s known values. */
        enum class Known {
            NFL,
            NCAAFB,
        }

        /** An enum containing [League]'s known values, as well as an [_UNKNOWN] member. */
        enum class Value {
            NFL,
            NCAAFB,
            /** An enum member indicating that [League] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /** Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if unknown. */
        fun value(): Value =
            when (this) {
                NFL -> Value.NFL
                NCAAFB -> Value.NCAAFB
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
                NFL -> Known.NFL
                NCAAFB -> Known.NCAAFB
                else -> throw XTwitterScraperInvalidDataException("Unknown League: $value")
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

        /** Validates that this value is a known member. */
        fun validate(): League = apply {
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

            return other is League && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }
}
