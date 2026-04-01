// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.compose

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ComposeCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val feedback: JsonField<String>,
    private val score: JsonField<Double>,
    private val suggestions: JsonField<List<String>>,
    private val text: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("feedback") @ExcludeMissing feedback: JsonField<String> = JsonMissing.of(),
        @JsonProperty("score") @ExcludeMissing score: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("suggestions")
        @ExcludeMissing
        suggestions: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
    ) : this(feedback, score, suggestions, text, mutableMapOf())

    /**
     * AI feedback on the draft
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun feedback(): Optional<String> = feedback.getOptional("feedback")

    /**
     * Engagement score (0-100)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun score(): Optional<Double> = score.getOptional("score")

    /**
     * Improvement suggestions
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun suggestions(): Optional<List<String>> = suggestions.getOptional("suggestions")

    /**
     * Generated or refined tweet text
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun text(): Optional<String> = text.getOptional("text")

    /**
     * Returns the raw JSON value of [feedback].
     *
     * Unlike [feedback], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("feedback") @ExcludeMissing fun _feedback(): JsonField<String> = feedback

    /**
     * Returns the raw JSON value of [score].
     *
     * Unlike [score], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<Double> = score

    /**
     * Returns the raw JSON value of [suggestions].
     *
     * Unlike [suggestions], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("suggestions")
    @ExcludeMissing
    fun _suggestions(): JsonField<List<String>> = suggestions

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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

        /** Returns a mutable builder for constructing an instance of [ComposeCreateResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ComposeCreateResponse]. */
    class Builder internal constructor() {

        private var feedback: JsonField<String> = JsonMissing.of()
        private var score: JsonField<Double> = JsonMissing.of()
        private var suggestions: JsonField<MutableList<String>>? = null
        private var text: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(composeCreateResponse: ComposeCreateResponse) = apply {
            feedback = composeCreateResponse.feedback
            score = composeCreateResponse.score
            suggestions = composeCreateResponse.suggestions.map { it.toMutableList() }
            text = composeCreateResponse.text
            additionalProperties = composeCreateResponse.additionalProperties.toMutableMap()
        }

        /** AI feedback on the draft */
        fun feedback(feedback: String) = feedback(JsonField.of(feedback))

        /**
         * Sets [Builder.feedback] to an arbitrary JSON value.
         *
         * You should usually call [Builder.feedback] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun feedback(feedback: JsonField<String>) = apply { this.feedback = feedback }

        /** Engagement score (0-100) */
        fun score(score: Double) = score(JsonField.of(score))

        /**
         * Sets [Builder.score] to an arbitrary JSON value.
         *
         * You should usually call [Builder.score] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun score(score: JsonField<Double>) = apply { this.score = score }

        /** Improvement suggestions */
        fun suggestions(suggestions: List<String>) = suggestions(JsonField.of(suggestions))

        /**
         * Sets [Builder.suggestions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.suggestions] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun suggestions(suggestions: JsonField<List<String>>) = apply {
            this.suggestions = suggestions.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [suggestions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSuggestion(suggestion: String) = apply {
            suggestions =
                (suggestions ?: JsonField.of(mutableListOf())).also {
                    checkKnown("suggestions", it).add(suggestion)
                }
        }

        /** Generated or refined tweet text */
        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

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
         * Returns an immutable instance of [ComposeCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ComposeCreateResponse =
            ComposeCreateResponse(
                feedback,
                score,
                (suggestions ?: JsonMissing.of()).map { it.toImmutable() },
                text,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ComposeCreateResponse = apply {
        if (validated) {
            return@apply
        }

        feedback()
        score()
        suggestions()
        text()
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
        (if (feedback.asKnown().isPresent) 1 else 0) +
            (if (score.asKnown().isPresent) 1 else 0) +
            (suggestions.asKnown().getOrNull()?.size ?: 0) +
            (if (text.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ComposeCreateResponse &&
            feedback == other.feedback &&
            score == other.score &&
            suggestions == other.suggestions &&
            text == other.text &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(feedback, score, suggestions, text, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ComposeCreateResponse{feedback=$feedback, score=$score, suggestions=$suggestions, text=$text, additionalProperties=$additionalProperties}"
}
