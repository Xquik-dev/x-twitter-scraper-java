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

/** Flags X shows on the field for the play, or null. */
class FootballPlayOnField
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val calledBack: JsonField<Boolean>,
    private val penaltyOnField: JsonField<Boolean>,
    private val timeout: JsonField<Boolean>,
    private val underReview: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("calledBack") @ExcludeMissing calledBack: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("penaltyOnField") @ExcludeMissing penaltyOnField: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("timeout") @ExcludeMissing timeout: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("underReview") @ExcludeMissing underReview: JsonField<Boolean> = JsonMissing.of(),
    ) : this(calledBack, penaltyOnField, timeout, underReview, mutableMapOf())

    /** Whether a penalty called the play back. */
    fun calledBack(): Optional<Boolean> = calledBack.getOptional("calledBack")

    /** Whether a flag was thrown. */
    fun penaltyOnField(): Optional<Boolean> = penaltyOnField.getOptional("penaltyOnField")

    /** Whether a timeout followed the play. */
    fun timeout(): Optional<Boolean> = timeout.getOptional("timeout")

    /** Whether officials were reviewing the play. */
    fun underReview(): Optional<Boolean> = underReview.getOptional("underReview")

    /** Returns the raw JSON value of [calledBack]. */
    @JsonProperty("calledBack") @ExcludeMissing fun _calledBack(): JsonField<Boolean> = calledBack

    /** Returns the raw JSON value of [penaltyOnField]. */
    @JsonProperty("penaltyOnField") @ExcludeMissing fun _penaltyOnField(): JsonField<Boolean> = penaltyOnField

    /** Returns the raw JSON value of [timeout]. */
    @JsonProperty("timeout") @ExcludeMissing fun _timeout(): JsonField<Boolean> = timeout

    /** Returns the raw JSON value of [underReview]. */
    @JsonProperty("underReview") @ExcludeMissing fun _underReview(): JsonField<Boolean> = underReview

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

        /** Returns a mutable builder for constructing an instance of [FootballPlayOnField]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPlayOnField]. */
    class Builder internal constructor() {

        private var calledBack: JsonField<Boolean>? = null
        private var penaltyOnField: JsonField<Boolean>? = null
        private var timeout: JsonField<Boolean>? = null
        private var underReview: JsonField<Boolean>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballPlayOnField: FootballPlayOnField) = apply {
            calledBack = footballPlayOnField.calledBack
            penaltyOnField = footballPlayOnField.penaltyOnField
            timeout = footballPlayOnField.timeout
            underReview = footballPlayOnField.underReview
            additionalProperties = footballPlayOnField.additionalProperties.toMutableMap()
        }

        /** Whether a penalty called the play back. */
        fun calledBack(calledBack: Boolean?) = calledBack(JsonField.ofNullable(calledBack))

        fun calledBack(calledBack: Boolean) = calledBack(calledBack as Boolean?)

        fun calledBack(calledBack: Optional<Boolean>) = calledBack(calledBack.getOrNull())

        /** Sets [Builder.calledBack] to an arbitrary JSON value. */
        fun calledBack(calledBack: JsonField<Boolean>) = apply { this.calledBack = calledBack }

        /** Whether a flag was thrown. */
        fun penaltyOnField(penaltyOnField: Boolean?) = penaltyOnField(JsonField.ofNullable(penaltyOnField))

        fun penaltyOnField(penaltyOnField: Boolean) = penaltyOnField(penaltyOnField as Boolean?)

        fun penaltyOnField(penaltyOnField: Optional<Boolean>) = penaltyOnField(penaltyOnField.getOrNull())

        /** Sets [Builder.penaltyOnField] to an arbitrary JSON value. */
        fun penaltyOnField(penaltyOnField: JsonField<Boolean>) = apply { this.penaltyOnField = penaltyOnField }

        /** Whether a timeout followed the play. */
        fun timeout(timeout: Boolean?) = timeout(JsonField.ofNullable(timeout))

        fun timeout(timeout: Boolean) = timeout(timeout as Boolean?)

        fun timeout(timeout: Optional<Boolean>) = timeout(timeout.getOrNull())

        /** Sets [Builder.timeout] to an arbitrary JSON value. */
        fun timeout(timeout: JsonField<Boolean>) = apply { this.timeout = timeout }

        /** Whether officials were reviewing the play. */
        fun underReview(underReview: Boolean?) = underReview(JsonField.ofNullable(underReview))

        fun underReview(underReview: Boolean) = underReview(underReview as Boolean?)

        fun underReview(underReview: Optional<Boolean>) = underReview(underReview.getOrNull())

        /** Sets [Builder.underReview] to an arbitrary JSON value. */
        fun underReview(underReview: JsonField<Boolean>) = apply { this.underReview = underReview }

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
         * Returns an immutable instance of [FootballPlayOnField].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPlayOnField =
            FootballPlayOnField(
                checkRequired("calledBack", calledBack),
                checkRequired("penaltyOnField", penaltyOnField),
                checkRequired("timeout", timeout),
                checkRequired("underReview", underReview),
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
    fun validate(): FootballPlayOnField = apply {
        if (validated) {
            return@apply
        }

        calledBack()
        penaltyOnField()
        timeout()
        underReview()
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
        (if (calledBack.asKnown().isPresent) 1 else 0) +
            (if (penaltyOnField.asKnown().isPresent) 1 else 0) +
            (if (timeout.asKnown().isPresent) 1 else 0) +
            (if (underReview.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPlayOnField &&
            calledBack == other.calledBack &&
            penaltyOnField == other.penaltyOnField &&
            timeout == other.timeout &&
            underReview == other.underReview &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(calledBack, penaltyOnField, timeout, underReview, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPlayOnField{calledBack=$calledBack, penaltyOnField=$penaltyOnField, timeout=$timeout, underReview=$underReview, additionalProperties=$additionalProperties}"
}
