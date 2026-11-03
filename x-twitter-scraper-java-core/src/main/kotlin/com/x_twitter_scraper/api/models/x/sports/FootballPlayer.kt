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

/** A football player, as X's sports pages show them. */
class FootballPlayer
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val teamId: JsonField<String>,
    private val name: JsonField<String>,
    private val shortName: JsonField<String>,
    private val jersey: JsonField<String>,
    private val position: JsonField<String>,
    private val college: JsonField<String>,
    private val birthPlace: JsonField<String>,
    private val birthDate: JsonField<String>,
    private val headshots: JsonField<FootballPlayerHeadshots>,
    private val xUser: JsonField<FootballPlayerXUser>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("teamId") @ExcludeMissing teamId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("shortName") @ExcludeMissing shortName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("jersey") @ExcludeMissing jersey: JsonField<String> = JsonMissing.of(),
        @JsonProperty("position") @ExcludeMissing position: JsonField<String> = JsonMissing.of(),
        @JsonProperty("college") @ExcludeMissing college: JsonField<String> = JsonMissing.of(),
        @JsonProperty("birthPlace") @ExcludeMissing birthPlace: JsonField<String> = JsonMissing.of(),
        @JsonProperty("birthDate") @ExcludeMissing birthDate: JsonField<String> = JsonMissing.of(),
        @JsonProperty("headshots") @ExcludeMissing headshots: JsonField<FootballPlayerHeadshots> = JsonMissing.of(),
        @JsonProperty("xUser") @ExcludeMissing xUser: JsonField<FootballPlayerXUser> = JsonMissing.of(),
    ) : this(id, teamId, name, shortName, jersey, position, college, birthPlace, birthDate, headshots, xUser, mutableMapOf())

    /** The player ID that plays & stats refer to. */
    fun id(): String = id.getRequired("id")

    /** The player's team, a key of teams. */
    fun teamId(): Optional<String> = teamId.getOptional("teamId")

    /** The player's full name. */
    fun name(): Optional<String> = name.getOptional("name")

    /** The name play descriptions use. */
    fun shortName(): Optional<String> = shortName.getOptional("shortName")

    /** The jersey number, as text. */
    fun jersey(): Optional<String> = jersey.getOptional("jersey")

    /** The position abbreviation, such as QB or DE. */
    fun position(): Optional<String> = position.getOptional("position")

    /** The college the player came from. */
    fun college(): Optional<String> = college.getOptional("college")

    /** Where the player was born. */
    fun birthPlace(): Optional<String> = birthPlace.getOptional("birthPlace")

    /** The birth date, as YYYY-MM-DD. */
    fun birthDate(): Optional<String> = birthDate.getOptional("birthDate")

    /** Photos of the player. Any of them can be null. */
    fun headshots(): FootballPlayerHeadshots = headshots.getRequired("headshots")

    /** The player's X account, or null without one. */
    fun xUser(): Optional<FootballPlayerXUser> = xUser.getOptional("xUser")

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Returns the raw JSON value of [teamId]. */
    @JsonProperty("teamId") @ExcludeMissing fun _teamId(): JsonField<String> = teamId

    /** Returns the raw JSON value of [name]. */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /** Returns the raw JSON value of [shortName]. */
    @JsonProperty("shortName") @ExcludeMissing fun _shortName(): JsonField<String> = shortName

    /** Returns the raw JSON value of [jersey]. */
    @JsonProperty("jersey") @ExcludeMissing fun _jersey(): JsonField<String> = jersey

    /** Returns the raw JSON value of [position]. */
    @JsonProperty("position") @ExcludeMissing fun _position(): JsonField<String> = position

    /** Returns the raw JSON value of [college]. */
    @JsonProperty("college") @ExcludeMissing fun _college(): JsonField<String> = college

    /** Returns the raw JSON value of [birthPlace]. */
    @JsonProperty("birthPlace") @ExcludeMissing fun _birthPlace(): JsonField<String> = birthPlace

    /** Returns the raw JSON value of [birthDate]. */
    @JsonProperty("birthDate") @ExcludeMissing fun _birthDate(): JsonField<String> = birthDate

    /** Returns the raw JSON value of [headshots]. */
    @JsonProperty("headshots") @ExcludeMissing fun _headshots(): JsonField<FootballPlayerHeadshots> = headshots

    /** Returns the raw JSON value of [xUser]. */
    @JsonProperty("xUser") @ExcludeMissing fun _xUser(): JsonField<FootballPlayerXUser> = xUser

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

        /** Returns a mutable builder for constructing an instance of [FootballPlayer]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPlayer]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var teamId: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var shortName: JsonField<String>? = null
        private var jersey: JsonField<String>? = null
        private var position: JsonField<String>? = null
        private var college: JsonField<String>? = null
        private var birthPlace: JsonField<String>? = null
        private var birthDate: JsonField<String>? = null
        private var headshots: JsonField<FootballPlayerHeadshots>? = null
        private var xUser: JsonField<FootballPlayerXUser>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballPlayer: FootballPlayer) = apply {
            id = footballPlayer.id
            teamId = footballPlayer.teamId
            name = footballPlayer.name
            shortName = footballPlayer.shortName
            jersey = footballPlayer.jersey
            position = footballPlayer.position
            college = footballPlayer.college
            birthPlace = footballPlayer.birthPlace
            birthDate = footballPlayer.birthDate
            headshots = footballPlayer.headshots
            xUser = footballPlayer.xUser
            additionalProperties = footballPlayer.additionalProperties.toMutableMap()
        }

        /** The player ID that plays & stats refer to. */
        fun id(id: String) = id(JsonField.of(id))

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The player's team, a key of teams. */
        fun teamId(teamId: String?) = teamId(JsonField.ofNullable(teamId))

        fun teamId(teamId: Optional<String>) = teamId(teamId.getOrNull())

        /** Sets [Builder.teamId] to an arbitrary JSON value. */
        fun teamId(teamId: JsonField<String>) = apply { this.teamId = teamId }

        /** The player's full name. */
        fun name(name: String?) = name(JsonField.ofNullable(name))

        fun name(name: Optional<String>) = name(name.getOrNull())

        /** Sets [Builder.name] to an arbitrary JSON value. */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The name play descriptions use. */
        fun shortName(shortName: String?) = shortName(JsonField.ofNullable(shortName))

        fun shortName(shortName: Optional<String>) = shortName(shortName.getOrNull())

        /** Sets [Builder.shortName] to an arbitrary JSON value. */
        fun shortName(shortName: JsonField<String>) = apply { this.shortName = shortName }

        /** The jersey number, as text. */
        fun jersey(jersey: String?) = jersey(JsonField.ofNullable(jersey))

        fun jersey(jersey: Optional<String>) = jersey(jersey.getOrNull())

        /** Sets [Builder.jersey] to an arbitrary JSON value. */
        fun jersey(jersey: JsonField<String>) = apply { this.jersey = jersey }

        /** The position abbreviation, such as QB or DE. */
        fun position(position: String?) = position(JsonField.ofNullable(position))

        fun position(position: Optional<String>) = position(position.getOrNull())

        /** Sets [Builder.position] to an arbitrary JSON value. */
        fun position(position: JsonField<String>) = apply { this.position = position }

        /** The college the player came from. */
        fun college(college: String?) = college(JsonField.ofNullable(college))

        fun college(college: Optional<String>) = college(college.getOrNull())

        /** Sets [Builder.college] to an arbitrary JSON value. */
        fun college(college: JsonField<String>) = apply { this.college = college }

        /** Where the player was born. */
        fun birthPlace(birthPlace: String?) = birthPlace(JsonField.ofNullable(birthPlace))

        fun birthPlace(birthPlace: Optional<String>) = birthPlace(birthPlace.getOrNull())

        /** Sets [Builder.birthPlace] to an arbitrary JSON value. */
        fun birthPlace(birthPlace: JsonField<String>) = apply { this.birthPlace = birthPlace }

        /** The birth date, as YYYY-MM-DD. */
        fun birthDate(birthDate: String?) = birthDate(JsonField.ofNullable(birthDate))

        fun birthDate(birthDate: Optional<String>) = birthDate(birthDate.getOrNull())

        /** Sets [Builder.birthDate] to an arbitrary JSON value. */
        fun birthDate(birthDate: JsonField<String>) = apply { this.birthDate = birthDate }

        /** Photos of the player. Any of them can be null. */
        fun headshots(headshots: FootballPlayerHeadshots) = headshots(JsonField.of(headshots))

        /** Sets [Builder.headshots] to an arbitrary JSON value. */
        fun headshots(headshots: JsonField<FootballPlayerHeadshots>) = apply { this.headshots = headshots }

        /** The player's X account, or null without one. */
        fun xUser(xUser: FootballPlayerXUser?) = xUser(JsonField.ofNullable(xUser))

        fun xUser(xUser: Optional<FootballPlayerXUser>) = xUser(xUser.getOrNull())

        /** Sets [Builder.xUser] to an arbitrary JSON value. */
        fun xUser(xUser: JsonField<FootballPlayerXUser>) = apply { this.xUser = xUser }

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
         * Returns an immutable instance of [FootballPlayer].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPlayer =
            FootballPlayer(
                checkRequired("id", id),
                checkRequired("teamId", teamId),
                checkRequired("name", name),
                checkRequired("shortName", shortName),
                checkRequired("jersey", jersey),
                checkRequired("position", position),
                checkRequired("college", college),
                checkRequired("birthPlace", birthPlace),
                checkRequired("birthDate", birthDate),
                checkRequired("headshots", headshots),
                checkRequired("xUser", xUser),
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
    fun validate(): FootballPlayer = apply {
        if (validated) {
            return@apply
        }

        id()
        teamId()
        name()
        shortName()
        jersey()
        position()
        college()
        birthPlace()
        birthDate()
        headshots().validate()
        xUser().ifPresent { it.validate() }
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
            (if (teamId.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (shortName.asKnown().isPresent) 1 else 0) +
            (if (jersey.asKnown().isPresent) 1 else 0) +
            (if (position.asKnown().isPresent) 1 else 0) +
            (if (college.asKnown().isPresent) 1 else 0) +
            (if (birthPlace.asKnown().isPresent) 1 else 0) +
            (if (birthDate.asKnown().isPresent) 1 else 0) +
            (headshots.asKnown().getOrNull()?.validity() ?: 0) +
            (xUser.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPlayer &&
            id == other.id &&
            teamId == other.teamId &&
            name == other.name &&
            shortName == other.shortName &&
            jersey == other.jersey &&
            position == other.position &&
            college == other.college &&
            birthPlace == other.birthPlace &&
            birthDate == other.birthDate &&
            headshots == other.headshots &&
            xUser == other.xUser &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, teamId, name, shortName, jersey, position, college, birthPlace, birthDate, headshots, xUser, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPlayer{id=$id, teamId=$teamId, name=$name, shortName=$shortName, jersey=$jersey, position=$position, college=$college, birthPlace=$birthPlace, birthDate=$birthDate, headshots=$headshots, xUser=$xUser, additionalProperties=$additionalProperties}"
}
