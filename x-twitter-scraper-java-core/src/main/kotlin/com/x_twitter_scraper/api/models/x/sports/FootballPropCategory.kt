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

/** 1 kind of player prop & its lines. */
class FootballPropCategory
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val key: JsonField<String>,
    private val name: JsonField<String>,
    private val rank: JsonField<Double>,
    private val props: JsonField<List<FootballPlayerProp>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("key") @ExcludeMissing key: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("rank") @ExcludeMissing rank: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("props")
        @ExcludeMissing
        props: JsonField<List<FootballPlayerProp>> = JsonMissing.of(),
    ) : this(key, name, rank, props, mutableMapOf())

    /** X's key for the prop, such as passing_yards. */
    fun key(): Optional<String> = key.getOptional("key")

    /** The name X shows for the prop. */
    fun name(): Optional<String> = name.getOptional("name")

    /** The category's place in X's order, from 1. */
    fun rank(): Optional<Double> = rank.getOptional("rank")

    /** Each player's line, in X's order. */
    fun props(): List<FootballPlayerProp> = props.getRequired("props")

    /** Returns the raw JSON value of [key]. */
    @JsonProperty("key") @ExcludeMissing fun _key(): JsonField<String> = key

    /** Returns the raw JSON value of [name]. */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /** Returns the raw JSON value of [rank]. */
    @JsonProperty("rank") @ExcludeMissing fun _rank(): JsonField<Double> = rank

    /** Returns the raw JSON value of [props]. */
    @JsonProperty("props") @ExcludeMissing fun _props(): JsonField<List<FootballPlayerProp>> = props

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

        /** Returns a mutable builder for constructing an instance of [FootballPropCategory]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPropCategory]. */
    class Builder internal constructor() {

        private var key: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var rank: JsonField<Double>? = null
        private var props: JsonField<MutableList<FootballPlayerProp>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(footballPropCategory: FootballPropCategory) = apply {
            key = footballPropCategory.key
            name = footballPropCategory.name
            rank = footballPropCategory.rank
            props = footballPropCategory.props.map { it.toMutableList() }
            additionalProperties = footballPropCategory.additionalProperties.toMutableMap()
        }

        /** X's key for the prop, such as passing_yards. */
        fun key(key: String?) = key(JsonField.ofNullable(key))

        /** Alias for calling [Builder.key] with `key.orElse(null)`. */
        fun key(key: Optional<String>) = key(key.getOrNull())

        /** Sets [Builder.key] to an arbitrary JSON value. */
        fun key(key: JsonField<String>) = apply { this.key = key }

        /** The name X shows for the prop. */
        fun name(name: String?) = name(JsonField.ofNullable(name))

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /** Sets [Builder.name] to an arbitrary JSON value. */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** The category's place in X's order, from 1. */
        fun rank(rank: Double?) = rank(JsonField.ofNullable(rank))

        /**
         * Alias for [Builder.rank].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun rank(rank: Double) = rank(rank as Double?)

        /** Alias for calling [Builder.rank] with `rank.orElse(null)`. */
        fun rank(rank: Optional<Double>) = rank(rank.getOrNull())

        /** Sets [Builder.rank] to an arbitrary JSON value. */
        fun rank(rank: JsonField<Double>) = apply { this.rank = rank }

        /** Each player's line, in X's order. */
        fun props(props: List<FootballPlayerProp>) = props(JsonField.of(props))

        /** Sets [Builder.props] to an arbitrary JSON value. */
        fun props(props: JsonField<List<FootballPlayerProp>>) = apply {
            this.props = props.map { it.toMutableList() }
        }

        /** Adds a single [FootballPlayerProp] to [props]. */
        fun addProp(prop: FootballPlayerProp) = apply {
            props =
                (props ?: JsonField.of(mutableListOf())).also {
                    checkKnown("props", it).add(prop)
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
         * Returns an immutable instance of [FootballPropCategory].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPropCategory =
            FootballPropCategory(
                checkRequired("key", key),
                checkRequired("name", name),
                checkRequired("rank", rank),
                checkRequired("props", props).map { it.toImmutable() },
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
    fun validate(): FootballPropCategory = apply {
        if (validated) {
            return@apply
        }

        key()
        name()
        rank()
        props().forEach { it.validate() }
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
        (if (key.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (rank.asKnown().isPresent) 1 else 0) +
            (props.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPropCategory &&
            key == other.key &&
            name == other.name &&
            rank == other.rank &&
            props == other.props &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(key, name, rank, props, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPropCategory{key=$key, name=$name, rank=$rank, props=$props, additionalProperties=$additionalProperties}"
}
