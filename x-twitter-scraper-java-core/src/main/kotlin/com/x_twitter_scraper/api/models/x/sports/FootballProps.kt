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
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The player props X shows for 1 NFL game. */
class FootballProps
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val league: JsonField<League>,
    private val sportsbookUrl: JsonField<String>,
    private val categories: JsonField<List<FootballPropCategory>>,
    private val players: JsonField<Map<String, FootballPlayer>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("league") @ExcludeMissing league: JsonField<League> = JsonMissing.of(),
        @JsonProperty("sportsbookUrl") @ExcludeMissing sportsbookUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("categories") @ExcludeMissing categories: JsonField<List<FootballPropCategory>> = JsonMissing.of(),
        @JsonProperty("players") @ExcludeMissing players: JsonField<Map<String, FootballPlayer>> = JsonMissing.of(),
    ) : this(id, league, sportsbookUrl, categories, players, mutableMapOf())

    /** The ID of the game these props cover. */
    fun id(): String = id.getRequired("id")

    /** The league of the game these props cover. */
    fun league(): League = league.getRequired("league")

    /** The sportsbook page X links for these props. */
    fun sportsbookUrl(): Optional<String> = sportsbookUrl.getOptional("sportsbookUrl")

    /** Each kind of prop, such as passing yards, in X's order. A game without props has none. */
    fun categories(): List<FootballPropCategory> = categories.getRequired("categories")

    /** The players these props name, by player ID. X sends only each player's name, jersey & team, so other fields are null. */
    fun players(): Map<String, FootballPlayer> = players.getRequired("players")

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Returns the raw JSON value of [league]. */
    @JsonProperty("league") @ExcludeMissing fun _league(): JsonField<League> = league

    /** Returns the raw JSON value of [sportsbookUrl]. */
    @JsonProperty("sportsbookUrl") @ExcludeMissing fun _sportsbookUrl(): JsonField<String> = sportsbookUrl

    /** Returns the raw JSON value of [categories]. */
    @JsonProperty("categories") @ExcludeMissing fun _categories(): JsonField<List<FootballPropCategory>> = categories

    /** Returns the raw JSON value of [players]. */
    @JsonProperty("players") @ExcludeMissing fun _players(): JsonField<Map<String, FootballPlayer>> = players

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

        /** Returns a mutable builder for constructing an instance of [FootballProps]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballProps]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var league: JsonField<League>? = null
        private var sportsbookUrl: JsonField<String>? = null
        private var categories: JsonField<MutableList<FootballPropCategory>>? = null
        private var players: JsonField<Map<String, FootballPlayer>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballProps: FootballProps) = apply {
            id = footballProps.id
            league = footballProps.league
            sportsbookUrl = footballProps.sportsbookUrl
            categories = footballProps.categories.map { it.toMutableList() }
            players = footballProps.players
            additionalProperties = footballProps.additionalProperties.toMutableMap()
        }

        /** The ID of the game these props cover. */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The league of the game these props cover. */
        fun league(league: League) = league(JsonField.of(league))

        /** Sets [Builder.league] to an arbitrary JSON value. */
        fun league(league: JsonField<League>) = apply { this.league = league }

        /** The sportsbook page X links for these props. */
        fun sportsbookUrl(sportsbookUrl: String?) = sportsbookUrl(JsonField.ofNullable(sportsbookUrl))

        /** Alias for calling [Builder.sportsbookUrl] with `sportsbookUrl.orElse(null)`. */
        fun sportsbookUrl(sportsbookUrl: Optional<String>) = sportsbookUrl(sportsbookUrl.getOrNull())

        /** Sets [Builder.sportsbookUrl] to an arbitrary JSON value. */
        fun sportsbookUrl(sportsbookUrl: JsonField<String>) = apply { this.sportsbookUrl = sportsbookUrl }

        /** Each kind of prop, such as passing yards, in X's order. A game without props has none. */
        fun categories(categories: List<FootballPropCategory>) = categories(JsonField.of(categories))

        /** Sets [Builder.categories] to an arbitrary JSON value. */
        fun categories(categories: JsonField<List<FootballPropCategory>>) = apply { this.categories = categories.map { it.toMutableList() } }

        /** Adds a single [FootballPropCategory] to [categories]. */
        fun addCategory(category: FootballPropCategory) = apply {
            categories =
                (categories ?: JsonField.of(mutableListOf())).also {
                    checkKnown("categories", it).add(category)
                }
        }

        /** The players these props name, by player ID. X sends only each player's name, jersey & team, so other fields are null. */
        fun players(players: Map<String, FootballPlayer>) = players(JsonField.of(players))

        /** Sets [Builder.players] to an arbitrary JSON value. */
        fun players(players: JsonField<Map<String, FootballPlayer>>) = apply { this.players = players }

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
         * Returns an immutable instance of [FootballProps].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballProps =
            FootballProps(
                checkRequired("id", id),
                checkRequired("league", league),
                checkRequired("sportsbookUrl", sportsbookUrl),
                checkRequired("categories", categories).map { it.toImmutable() },
                checkRequired("players", players),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match its expected type.
     */
    fun validate(): FootballProps = apply {
        if (validated) {
            return@apply
        }

        id()
        league().validate()
        sportsbookUrl()
        categories().forEach { it.validate() }
        players().values.forEach { it.validate() }
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
            (if (sportsbookUrl.asKnown().isPresent) 1 else 0) +
            (categories.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (players.asKnown().getOrNull()?.values?.sumOf { it.validity().toInt() } ?: 0)

    /** The league of the game these props cover. */
    class League @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /** Returns this class instance's raw value. */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val NFL = of("nfl")

            @JvmStatic fun of(value: String) = League(JsonField.of(value))
        }

        /** An enum containing [League]'s known values. */
        enum class Known {
            NFL,
        }

        /** An enum containing [League]'s known values, as well as an [_UNKNOWN] member. */
        enum class Value {
            NFL,
            /** An enum member indicating that [League] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /** Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if unknown. */
        fun value(): Value =
            when (this) {
                NFL -> Value.NFL
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                NFL -> Known.NFL
                else -> throw XTwitterScraperInvalidDataException("Unknown League: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { XTwitterScraperInvalidDataException("Value is not a String") }

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballProps &&
            id == other.id &&
            league == other.league &&
            sportsbookUrl == other.sportsbookUrl &&
            categories == other.categories &&
            players == other.players &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, league, sportsbookUrl, categories, players, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballProps{id=$id, league=$league, sportsbookUrl=$sportsbookUrl, categories=$categories, players=$players, additionalProperties=$additionalProperties}"
}
