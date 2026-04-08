// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.draws

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
import kotlin.jvm.optionals.getOrNull

class DrawRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val draw: JsonField<DrawDetail>,
    private val winners: JsonField<List<Winner>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("draw") @ExcludeMissing draw: JsonField<DrawDetail> = JsonMissing.of(),
        @JsonProperty("winners") @ExcludeMissing winners: JsonField<List<Winner>> = JsonMissing.of(),
    ) : this(draw, winners, mutableMapOf())

    /**
     * Full giveaway draw with tweet metrics, entries, and timing.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun draw(): DrawDetail = draw.getRequired("draw")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun winners(): List<Winner> = winners.getRequired("winners")

    /**
     * Returns the raw JSON value of [draw].
     *
     * Unlike [draw], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("draw") @ExcludeMissing fun _draw(): JsonField<DrawDetail> = draw

    /**
     * Returns the raw JSON value of [winners].
     *
     * Unlike [winners], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("winners") @ExcludeMissing fun _winners(): JsonField<List<Winner>> = winners

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
         * Returns a mutable builder for constructing an instance of [DrawRetrieveResponse].
         *
         * The following fields are required:
         * ```java
         * .draw()
         * .winners()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DrawRetrieveResponse]. */
    class Builder internal constructor() {

        private var draw: JsonField<DrawDetail>? = null
        private var winners: JsonField<MutableList<Winner>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(drawRetrieveResponse: DrawRetrieveResponse) = apply {
            draw = drawRetrieveResponse.draw
            winners = drawRetrieveResponse.winners.map { it.toMutableList() }
            additionalProperties = drawRetrieveResponse.additionalProperties.toMutableMap()
        }

        /** Full giveaway draw with tweet metrics, entries, and timing. */
        fun draw(draw: DrawDetail) = draw(JsonField.of(draw))

        /**
         * Sets [Builder.draw] to an arbitrary JSON value.
         *
         * You should usually call [Builder.draw] with a well-typed [DrawDetail] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun draw(draw: JsonField<DrawDetail>) = apply { this.draw = draw }

        fun winners(winners: List<Winner>) = winners(JsonField.of(winners))

        /**
         * Sets [Builder.winners] to an arbitrary JSON value.
         *
         * You should usually call [Builder.winners] with a well-typed `List<Winner>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun winners(winners: JsonField<List<Winner>>) = apply {
            this.winners = winners.map { it.toMutableList() }
        }

        /**
         * Adds a single [Winner] to [winners].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addWinner(winner: Winner) = apply {
            winners =
                (winners ?: JsonField.of(mutableListOf())).also {
                    checkKnown("winners", it).add(winner)
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
         * Returns an immutable instance of [DrawRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .draw()
         * .winners()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DrawRetrieveResponse =
            DrawRetrieveResponse(
                checkRequired("draw", draw),
                checkRequired("winners", winners).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): DrawRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        draw().validate()
        winners().forEach { it.validate() }
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
        (draw.asKnown().getOrNull()?.validity() ?: 0) +
            (winners.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DrawRetrieveResponse &&
            draw == other.draw &&
            winners == other.winners &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(draw, winners, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DrawRetrieveResponse{draw=$draw, winners=$winners, additionalProperties=$additionalProperties}"
}
