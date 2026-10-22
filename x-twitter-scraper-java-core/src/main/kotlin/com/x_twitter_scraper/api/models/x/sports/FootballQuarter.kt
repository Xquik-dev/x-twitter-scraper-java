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

/** A quarter & its drives. */
class FootballQuarter
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val number: JsonField<Long>,
    private val sequence: JsonField<Long>,
    private val drives: JsonField<List<FootballDrive>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("number") @ExcludeMissing number: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("sequence") @ExcludeMissing sequence: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("drives") @ExcludeMissing drives: JsonField<List<FootballDrive>> = JsonMissing.of(),
    ) : this(id, number, sequence, drives, mutableMapOf())

    /** X's ID for the quarter within the game. */
    fun id(): Optional<String> = id.getOptional("id")

    /** The quarter's number. */
    fun number(): Optional<Long> = number.getOptional("number")

    /** The quarter's place in the game, from 1. */
    fun sequence(): Optional<Long> = sequence.getOptional("sequence")

    /** The quarter's drives, in order. */
    fun drives(): List<FootballDrive> = drives.getRequired("drives")

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Returns the raw JSON value of [number]. */
    @JsonProperty("number") @ExcludeMissing fun _number(): JsonField<Long> = number

    /** Returns the raw JSON value of [sequence]. */
    @JsonProperty("sequence") @ExcludeMissing fun _sequence(): JsonField<Long> = sequence

    /** Returns the raw JSON value of [drives]. */
    @JsonProperty("drives") @ExcludeMissing fun _drives(): JsonField<List<FootballDrive>> = drives

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

        /** Returns a mutable builder for constructing an instance of [FootballQuarter]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballQuarter]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var number: JsonField<Long>? = null
        private var sequence: JsonField<Long>? = null
        private var drives: JsonField<MutableList<FootballDrive>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballQuarter: FootballQuarter) = apply {
            id = footballQuarter.id
            number = footballQuarter.number
            sequence = footballQuarter.sequence
            drives = footballQuarter.drives.map { it.toMutableList() }
            additionalProperties = footballQuarter.additionalProperties.toMutableMap()
        }

        /** X's ID for the quarter within the game. */
        fun id(id: String?) = id(JsonField.ofNullable(id))

        fun id(id: Optional<String>) = id(id.getOrNull())

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The quarter's number. */
        fun number(number: Long?) = number(JsonField.ofNullable(number))

        fun number(number: Long) = number(number as Long?)

        fun number(number: Optional<Long>) = number(number.getOrNull())

        /** Sets [Builder.number] to an arbitrary JSON value. */
        fun number(number: JsonField<Long>) = apply { this.number = number }

        /** The quarter's place in the game, from 1. */
        fun sequence(sequence: Long?) = sequence(JsonField.ofNullable(sequence))

        fun sequence(sequence: Long) = sequence(sequence as Long?)

        fun sequence(sequence: Optional<Long>) = sequence(sequence.getOrNull())

        /** Sets [Builder.sequence] to an arbitrary JSON value. */
        fun sequence(sequence: JsonField<Long>) = apply { this.sequence = sequence }

        /** The quarter's drives, in order. */
        fun drives(drives: List<FootballDrive>) = drives(JsonField.of(drives))

        /** Sets [Builder.drives] to an arbitrary JSON value. */
        fun drives(drives: JsonField<List<FootballDrive>>) = apply { this.drives = drives.map { it.toMutableList() } }

        /** Adds a single [FootballDrive] to [drives]. */
        fun addDrive(drive: FootballDrive) = apply {
            drives =
                (drives ?: JsonField.of(mutableListOf())).also {
                    checkKnown("drives", it).add(drive)
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
         * Returns an immutable instance of [FootballQuarter].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballQuarter =
            FootballQuarter(
                checkRequired("id", id),
                checkRequired("number", number),
                checkRequired("sequence", sequence),
                checkRequired("drives", drives).map { it.toImmutable() },
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
    fun validate(): FootballQuarter = apply {
        if (validated) {
            return@apply
        }

        id()
        number()
        sequence()
        drives().forEach { it.validate() }
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
            (if (number.asKnown().isPresent) 1 else 0) +
            (if (sequence.asKnown().isPresent) 1 else 0) +
            (drives.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballQuarter &&
            id == other.id &&
            number == other.number &&
            sequence == other.sequence &&
            drives == other.drives &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, number, sequence, drives, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballQuarter{id=$id, number=$number, sequence=$sequence, drives=$drives, additionalProperties=$additionalProperties}"
}
