// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.compose

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.x_twitter_scraper.api.core.BaseDeserializer
import com.x_twitter_scraper.api.core.BaseSerializer
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.allMaxBy
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.getOrThrow
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@JsonDeserialize(using = ComposeCreateResponse.Deserializer::class)
@JsonSerialize(using = ComposeCreateResponse.Serializer::class)
class ComposeCreateResponse
private constructor(
    private val prepareResult: ComposePrepareResult? = null,
    private val refineResult: ComposeRefineResult? = null,
    private val scoreResult: ComposeScoreResult? = null,
    private val _json: JsonValue? = null,
) {

    fun prepareResult(): Optional<ComposePrepareResult> = Optional.ofNullable(prepareResult)

    fun refineResult(): Optional<ComposeRefineResult> = Optional.ofNullable(refineResult)

    fun scoreResult(): Optional<ComposeScoreResult> = Optional.ofNullable(scoreResult)

    fun isPrepareResult(): Boolean = prepareResult != null

    fun isRefineResult(): Boolean = refineResult != null

    fun isScoreResult(): Boolean = scoreResult != null

    fun asPrepareResult(): ComposePrepareResult = prepareResult.getOrThrow("prepareResult")

    fun asRefineResult(): ComposeRefineResult = refineResult.getOrThrow("refineResult")

    fun asScoreResult(): ComposeScoreResult = scoreResult.getOrThrow("scoreResult")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.x_twitter_scraper.api.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = composeCreateResponse.accept(new ComposeCreateResponse.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitPrepareResult(ComposePrepareResult prepareResult) {
     *         return Optional.of(prepareResult.toString());
     *     }
     *
     *     // ...
     *
     *     @Override
     *     public Optional<String> unknown(JsonValue json) {
     *         // Or inspect the `json`.
     *         return Optional.empty();
     *     }
     * });
     * ```
     *
     * @throws XTwitterScraperInvalidDataException if [Visitor.unknown] is not overridden in
     *   [visitor] and the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            prepareResult != null -> visitor.visitPrepareResult(prepareResult)
            refineResult != null -> visitor.visitRefineResult(refineResult)
            scoreResult != null -> visitor.visitScoreResult(scoreResult)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't match
     *   its expected type.
     */
    fun validate(): ComposeCreateResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitPrepareResult(prepareResult: ComposePrepareResult) {
                    prepareResult.validate()
                }

                override fun visitRefineResult(refineResult: ComposeRefineResult) {
                    refineResult.validate()
                }

                override fun visitScoreResult(scoreResult: ComposeScoreResult) {
                    scoreResult.validate()
                }
            }
        )
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
        accept(
            object : Visitor<Int> {
                override fun visitPrepareResult(prepareResult: ComposePrepareResult) =
                    prepareResult.validity()

                override fun visitRefineResult(refineResult: ComposeRefineResult) =
                    refineResult.validity()

                override fun visitScoreResult(scoreResult: ComposeScoreResult) =
                    scoreResult.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ComposeCreateResponse &&
            prepareResult == other.prepareResult &&
            refineResult == other.refineResult &&
            scoreResult == other.scoreResult
    }

    override fun hashCode(): Int = Objects.hash(prepareResult, refineResult, scoreResult)

    override fun toString(): String =
        when {
            prepareResult != null -> "ComposeCreateResponse{prepareResult=$prepareResult}"
            refineResult != null -> "ComposeCreateResponse{refineResult=$refineResult}"
            scoreResult != null -> "ComposeCreateResponse{scoreResult=$scoreResult}"
            _json != null -> "ComposeCreateResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ComposeCreateResponse")
        }

    companion object {

        @JvmStatic
        fun ofPrepareResult(prepareResult: ComposePrepareResult) =
            ComposeCreateResponse(prepareResult = prepareResult)

        @JvmStatic
        fun ofRefineResult(refineResult: ComposeRefineResult) =
            ComposeCreateResponse(refineResult = refineResult)

        @JvmStatic
        fun ofScoreResult(scoreResult: ComposeScoreResult) =
            ComposeCreateResponse(scoreResult = scoreResult)
    }

    /**
     * An interface that defines how to map each variant of [ComposeCreateResponse] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        fun visitPrepareResult(prepareResult: ComposePrepareResult): T

        fun visitRefineResult(refineResult: ComposeRefineResult): T

        fun visitScoreResult(scoreResult: ComposeScoreResult): T

        /**
         * Maps an unknown variant of [ComposeCreateResponse] to a value of type [T].
         *
         * An instance of [ComposeCreateResponse] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws XTwitterScraperInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw XTwitterScraperInvalidDataException("Unknown ComposeCreateResponse: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ComposeCreateResponse>(ComposeCreateResponse::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ComposeCreateResponse {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<ComposePrepareResult>())?.let {
                            ComposeCreateResponse(prepareResult = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<ComposeRefineResult>())?.let {
                            ComposeCreateResponse(refineResult = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<ComposeScoreResult>())?.let {
                            ComposeCreateResponse(scoreResult = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> ComposeCreateResponse(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<ComposeCreateResponse>(ComposeCreateResponse::class) {

        override fun serialize(
            value: ComposeCreateResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.prepareResult != null -> generator.writeObject(value.prepareResult)
                value.refineResult != null -> generator.writeObject(value.refineResult)
                value.scoreResult != null -> generator.writeObject(value.scoreResult)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ComposeCreateResponse")
            }
        }
    }

    class ComposePrepareResult
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val contentRules: JsonField<List<ContentRule>>,
        private val engagementMultipliers: JsonField<List<EngagementMultiplier>>,
        private val engagementVelocity: JsonField<String>,
        private val followUpQuestions: JsonField<List<String>>,
        private val intentUrl: JsonField<String>,
        private val nextStep: JsonField<String>,
        private val radarRecommendations: JsonField<List<RadarRecommendation>>,
        private val scorerWeights: JsonField<List<ScorerWeight>>,
        private val source: JsonField<String>,
        private val topPenalties: JsonField<List<String>>,
        private val savedStyles: JsonField<List<SavedStyle>>,
        private val styleNote: JsonField<String>,
        private val styleTweets: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("contentRules")
            @ExcludeMissing
            contentRules: JsonField<List<ContentRule>> = JsonMissing.of(),
            @JsonProperty("engagementMultipliers")
            @ExcludeMissing
            engagementMultipliers: JsonField<List<EngagementMultiplier>> = JsonMissing.of(),
            @JsonProperty("engagementVelocity")
            @ExcludeMissing
            engagementVelocity: JsonField<String> = JsonMissing.of(),
            @JsonProperty("followUpQuestions")
            @ExcludeMissing
            followUpQuestions: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("intentUrl")
            @ExcludeMissing
            intentUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("nextStep")
            @ExcludeMissing
            nextStep: JsonField<String> = JsonMissing.of(),
            @JsonProperty("radarRecommendations")
            @ExcludeMissing
            radarRecommendations: JsonField<List<RadarRecommendation>> = JsonMissing.of(),
            @JsonProperty("scorerWeights")
            @ExcludeMissing
            scorerWeights: JsonField<List<ScorerWeight>> = JsonMissing.of(),
            @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
            @JsonProperty("topPenalties")
            @ExcludeMissing
            topPenalties: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("savedStyles")
            @ExcludeMissing
            savedStyles: JsonField<List<SavedStyle>> = JsonMissing.of(),
            @JsonProperty("styleNote")
            @ExcludeMissing
            styleNote: JsonField<String> = JsonMissing.of(),
            @JsonProperty("styleTweets")
            @ExcludeMissing
            styleTweets: JsonField<List<String>> = JsonMissing.of(),
        ) : this(
            contentRules,
            engagementMultipliers,
            engagementVelocity,
            followUpQuestions,
            intentUrl,
            nextStep,
            radarRecommendations,
            scorerWeights,
            source,
            topPenalties,
            savedStyles,
            styleNote,
            styleTweets,
            mutableMapOf(),
        )

        /**
         * Xquik editorial heuristics, ordered for the goal.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun contentRules(): List<ContentRule> = contentRules.getRequired("contentRules")

        /**
         * Published engagement signal names. Production multipliers are not published.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun engagementMultipliers(): List<EngagementMultiplier> =
            engagementMultipliers.getRequired("engagementMultipliers")

        /**
         * Publication limit for timing and decay claims.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun engagementVelocity(): String = engagementVelocity.getRequired("engagementVelocity")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun followUpQuestions(): List<String> = followUpQuestions.getRequired("followUpQuestions")

        /**
         * X post intent seeded with the topic.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun intentUrl(): String = intentUrl.getRequired("intentUrl")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun nextStep(): String = nextStep.getRequired("nextStep")

        /**
         * Sources and guidance for researching a fresh post angle.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun radarRecommendations(): List<RadarRecommendation> =
            radarRecommendations.getRequired("radarRecommendations")

        /**
         * Published signal names with unpublished weights as null.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun scorerWeights(): List<ScorerWeight> = scorerWeights.getRequired("scorerWeights")

        /**
         * Signal source and evidence limits.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun source(): String = source.getRequired("source")

        /**
         * Negative engagement predictions in the public model.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun topPenalties(): List<String> = topPenalties.getRequired("topPenalties")

        /**
         * Style analyses saved to the account.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun savedStyles(): Optional<List<SavedStyle>> = savedStyles.getOptional("savedStyles")

        /**
         * Next action when no cached style is available.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun styleNote(): Optional<String> = styleNote.getOptional("styleNote")

        /**
         * Cached examples for the requested style username.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun styleTweets(): Optional<List<String>> = styleTweets.getOptional("styleTweets")

        /**
         * Returns the raw JSON value of [contentRules].
         *
         * Unlike [contentRules], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("contentRules")
        @ExcludeMissing
        fun _contentRules(): JsonField<List<ContentRule>> = contentRules

        /**
         * Returns the raw JSON value of [engagementMultipliers].
         *
         * Unlike [engagementMultipliers], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("engagementMultipliers")
        @ExcludeMissing
        fun _engagementMultipliers(): JsonField<List<EngagementMultiplier>> = engagementMultipliers

        /**
         * Returns the raw JSON value of [engagementVelocity].
         *
         * Unlike [engagementVelocity], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("engagementVelocity")
        @ExcludeMissing
        fun _engagementVelocity(): JsonField<String> = engagementVelocity

        /**
         * Returns the raw JSON value of [followUpQuestions].
         *
         * Unlike [followUpQuestions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("followUpQuestions")
        @ExcludeMissing
        fun _followUpQuestions(): JsonField<List<String>> = followUpQuestions

        /**
         * Returns the raw JSON value of [intentUrl].
         *
         * Unlike [intentUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("intentUrl") @ExcludeMissing fun _intentUrl(): JsonField<String> = intentUrl

        /**
         * Returns the raw JSON value of [nextStep].
         *
         * Unlike [nextStep], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("nextStep") @ExcludeMissing fun _nextStep(): JsonField<String> = nextStep

        /**
         * Returns the raw JSON value of [radarRecommendations].
         *
         * Unlike [radarRecommendations], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("radarRecommendations")
        @ExcludeMissing
        fun _radarRecommendations(): JsonField<List<RadarRecommendation>> = radarRecommendations

        /**
         * Returns the raw JSON value of [scorerWeights].
         *
         * Unlike [scorerWeights], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("scorerWeights")
        @ExcludeMissing
        fun _scorerWeights(): JsonField<List<ScorerWeight>> = scorerWeights

        /**
         * Returns the raw JSON value of [source].
         *
         * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

        /**
         * Returns the raw JSON value of [topPenalties].
         *
         * Unlike [topPenalties], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("topPenalties")
        @ExcludeMissing
        fun _topPenalties(): JsonField<List<String>> = topPenalties

        /**
         * Returns the raw JSON value of [savedStyles].
         *
         * Unlike [savedStyles], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("savedStyles")
        @ExcludeMissing
        fun _savedStyles(): JsonField<List<SavedStyle>> = savedStyles

        /**
         * Returns the raw JSON value of [styleNote].
         *
         * Unlike [styleNote], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("styleNote") @ExcludeMissing fun _styleNote(): JsonField<String> = styleNote

        /**
         * Returns the raw JSON value of [styleTweets].
         *
         * Unlike [styleTweets], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("styleTweets")
        @ExcludeMissing
        fun _styleTweets(): JsonField<List<String>> = styleTweets

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
             * Returns a mutable builder for constructing an instance of [ComposePrepareResult].
             *
             * The following fields are required:
             * ```java
             * .contentRules()
             * .engagementMultipliers()
             * .engagementVelocity()
             * .followUpQuestions()
             * .intentUrl()
             * .nextStep()
             * .radarRecommendations()
             * .scorerWeights()
             * .source()
             * .topPenalties()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ComposePrepareResult]. */
        class Builder internal constructor() {

            private var contentRules: JsonField<MutableList<ContentRule>>? = null
            private var engagementMultipliers: JsonField<MutableList<EngagementMultiplier>>? = null
            private var engagementVelocity: JsonField<String>? = null
            private var followUpQuestions: JsonField<MutableList<String>>? = null
            private var intentUrl: JsonField<String>? = null
            private var nextStep: JsonField<String>? = null
            private var radarRecommendations: JsonField<MutableList<RadarRecommendation>>? = null
            private var scorerWeights: JsonField<MutableList<ScorerWeight>>? = null
            private var source: JsonField<String>? = null
            private var topPenalties: JsonField<MutableList<String>>? = null
            private var savedStyles: JsonField<MutableList<SavedStyle>>? = null
            private var styleNote: JsonField<String> = JsonMissing.of()
            private var styleTweets: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(composePrepareResult: ComposePrepareResult) = apply {
                contentRules = composePrepareResult.contentRules.map { it.toMutableList() }
                engagementMultipliers =
                    composePrepareResult.engagementMultipliers.map { it.toMutableList() }
                engagementVelocity = composePrepareResult.engagementVelocity
                followUpQuestions =
                    composePrepareResult.followUpQuestions.map { it.toMutableList() }
                intentUrl = composePrepareResult.intentUrl
                nextStep = composePrepareResult.nextStep
                radarRecommendations =
                    composePrepareResult.radarRecommendations.map { it.toMutableList() }
                scorerWeights = composePrepareResult.scorerWeights.map { it.toMutableList() }
                source = composePrepareResult.source
                topPenalties = composePrepareResult.topPenalties.map { it.toMutableList() }
                savedStyles = composePrepareResult.savedStyles.map { it.toMutableList() }
                styleNote = composePrepareResult.styleNote
                styleTweets = composePrepareResult.styleTweets.map { it.toMutableList() }
                additionalProperties = composePrepareResult.additionalProperties.toMutableMap()
            }

            /** Xquik editorial heuristics, ordered for the goal. */
            fun contentRules(contentRules: List<ContentRule>) =
                contentRules(JsonField.of(contentRules))

            /**
             * Sets [Builder.contentRules] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contentRules] with a well-typed `List<ContentRule>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun contentRules(contentRules: JsonField<List<ContentRule>>) = apply {
                this.contentRules = contentRules.map { it.toMutableList() }
            }

            /**
             * Adds a single [ContentRule] to [contentRules].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addContentRule(contentRule: ContentRule) = apply {
                contentRules =
                    (contentRules ?: JsonField.of(mutableListOf())).also {
                        checkKnown("contentRules", it).add(contentRule)
                    }
            }

            /** Published engagement signal names. Production multipliers are not published. */
            fun engagementMultipliers(engagementMultipliers: List<EngagementMultiplier>) =
                engagementMultipliers(JsonField.of(engagementMultipliers))

            /**
             * Sets [Builder.engagementMultipliers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.engagementMultipliers] with a well-typed
             * `List<EngagementMultiplier>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun engagementMultipliers(
                engagementMultipliers: JsonField<List<EngagementMultiplier>>
            ) = apply {
                this.engagementMultipliers = engagementMultipliers.map { it.toMutableList() }
            }

            /**
             * Adds a single [EngagementMultiplier] to [engagementMultipliers].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addEngagementMultiplier(engagementMultiplier: EngagementMultiplier) = apply {
                engagementMultipliers =
                    (engagementMultipliers ?: JsonField.of(mutableListOf())).also {
                        checkKnown("engagementMultipliers", it).add(engagementMultiplier)
                    }
            }

            /** Publication limit for timing and decay claims. */
            fun engagementVelocity(engagementVelocity: String) =
                engagementVelocity(JsonField.of(engagementVelocity))

            /**
             * Sets [Builder.engagementVelocity] to an arbitrary JSON value.
             *
             * You should usually call [Builder.engagementVelocity] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun engagementVelocity(engagementVelocity: JsonField<String>) = apply {
                this.engagementVelocity = engagementVelocity
            }

            fun followUpQuestions(followUpQuestions: List<String>) =
                followUpQuestions(JsonField.of(followUpQuestions))

            /**
             * Sets [Builder.followUpQuestions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.followUpQuestions] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun followUpQuestions(followUpQuestions: JsonField<List<String>>) = apply {
                this.followUpQuestions = followUpQuestions.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [followUpQuestions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addFollowUpQuestion(followUpQuestion: String) = apply {
                followUpQuestions =
                    (followUpQuestions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("followUpQuestions", it).add(followUpQuestion)
                    }
            }

            /** X post intent seeded with the topic. */
            fun intentUrl(intentUrl: String) = intentUrl(JsonField.of(intentUrl))

            /**
             * Sets [Builder.intentUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.intentUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun intentUrl(intentUrl: JsonField<String>) = apply { this.intentUrl = intentUrl }

            fun nextStep(nextStep: String) = nextStep(JsonField.of(nextStep))

            /**
             * Sets [Builder.nextStep] to an arbitrary JSON value.
             *
             * You should usually call [Builder.nextStep] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun nextStep(nextStep: JsonField<String>) = apply { this.nextStep = nextStep }

            /** Sources and guidance for researching a fresh post angle. */
            fun radarRecommendations(radarRecommendations: List<RadarRecommendation>) =
                radarRecommendations(JsonField.of(radarRecommendations))

            /**
             * Sets [Builder.radarRecommendations] to an arbitrary JSON value.
             *
             * You should usually call [Builder.radarRecommendations] with a well-typed
             * `List<RadarRecommendation>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun radarRecommendations(radarRecommendations: JsonField<List<RadarRecommendation>>) =
                apply {
                    this.radarRecommendations = radarRecommendations.map { it.toMutableList() }
                }

            /**
             * Adds a single [RadarRecommendation] to [radarRecommendations].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRadarRecommendation(radarRecommendation: RadarRecommendation) = apply {
                radarRecommendations =
                    (radarRecommendations ?: JsonField.of(mutableListOf())).also {
                        checkKnown("radarRecommendations", it).add(radarRecommendation)
                    }
            }

            /** Published signal names with unpublished weights as null. */
            fun scorerWeights(scorerWeights: List<ScorerWeight>) =
                scorerWeights(JsonField.of(scorerWeights))

            /**
             * Sets [Builder.scorerWeights] to an arbitrary JSON value.
             *
             * You should usually call [Builder.scorerWeights] with a well-typed
             * `List<ScorerWeight>` value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun scorerWeights(scorerWeights: JsonField<List<ScorerWeight>>) = apply {
                this.scorerWeights = scorerWeights.map { it.toMutableList() }
            }

            /**
             * Adds a single [ScorerWeight] to [scorerWeights].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addScorerWeight(scorerWeight: ScorerWeight) = apply {
                scorerWeights =
                    (scorerWeights ?: JsonField.of(mutableListOf())).also {
                        checkKnown("scorerWeights", it).add(scorerWeight)
                    }
            }

            /** Signal source and evidence limits. */
            fun source(source: String) = source(JsonField.of(source))

            /**
             * Sets [Builder.source] to an arbitrary JSON value.
             *
             * You should usually call [Builder.source] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun source(source: JsonField<String>) = apply { this.source = source }

            /** Negative engagement predictions in the public model. */
            fun topPenalties(topPenalties: List<String>) = topPenalties(JsonField.of(topPenalties))

            /**
             * Sets [Builder.topPenalties] to an arbitrary JSON value.
             *
             * You should usually call [Builder.topPenalties] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun topPenalties(topPenalties: JsonField<List<String>>) = apply {
                this.topPenalties = topPenalties.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [topPenalties].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTopPenalty(topPenalty: String) = apply {
                topPenalties =
                    (topPenalties ?: JsonField.of(mutableListOf())).also {
                        checkKnown("topPenalties", it).add(topPenalty)
                    }
            }

            /** Style analyses saved to the account. */
            fun savedStyles(savedStyles: List<SavedStyle>) = savedStyles(JsonField.of(savedStyles))

            /**
             * Sets [Builder.savedStyles] to an arbitrary JSON value.
             *
             * You should usually call [Builder.savedStyles] with a well-typed `List<SavedStyle>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun savedStyles(savedStyles: JsonField<List<SavedStyle>>) = apply {
                this.savedStyles = savedStyles.map { it.toMutableList() }
            }

            /**
             * Adds a single [SavedStyle] to [savedStyles].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSavedStyle(savedStyle: SavedStyle) = apply {
                savedStyles =
                    (savedStyles ?: JsonField.of(mutableListOf())).also {
                        checkKnown("savedStyles", it).add(savedStyle)
                    }
            }

            /** Next action when no cached style is available. */
            fun styleNote(styleNote: String) = styleNote(JsonField.of(styleNote))

            /**
             * Sets [Builder.styleNote] to an arbitrary JSON value.
             *
             * You should usually call [Builder.styleNote] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun styleNote(styleNote: JsonField<String>) = apply { this.styleNote = styleNote }

            /** Cached examples for the requested style username. */
            fun styleTweets(styleTweets: List<String>) = styleTweets(JsonField.of(styleTweets))

            /**
             * Sets [Builder.styleTweets] to an arbitrary JSON value.
             *
             * You should usually call [Builder.styleTweets] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun styleTweets(styleTweets: JsonField<List<String>>) = apply {
                this.styleTweets = styleTweets.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [styleTweets].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addStyleTweet(styleTweet: String) = apply {
                styleTweets =
                    (styleTweets ?: JsonField.of(mutableListOf())).also {
                        checkKnown("styleTweets", it).add(styleTweet)
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
             * Returns an immutable instance of [ComposePrepareResult].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .contentRules()
             * .engagementMultipliers()
             * .engagementVelocity()
             * .followUpQuestions()
             * .intentUrl()
             * .nextStep()
             * .radarRecommendations()
             * .scorerWeights()
             * .source()
             * .topPenalties()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ComposePrepareResult =
                ComposePrepareResult(
                    checkRequired("contentRules", contentRules).map { it.toImmutable() },
                    checkRequired("engagementMultipliers", engagementMultipliers).map {
                        it.toImmutable()
                    },
                    checkRequired("engagementVelocity", engagementVelocity),
                    checkRequired("followUpQuestions", followUpQuestions).map { it.toImmutable() },
                    checkRequired("intentUrl", intentUrl),
                    checkRequired("nextStep", nextStep),
                    checkRequired("radarRecommendations", radarRecommendations).map {
                        it.toImmutable()
                    },
                    checkRequired("scorerWeights", scorerWeights).map { it.toImmutable() },
                    checkRequired("source", source),
                    checkRequired("topPenalties", topPenalties).map { it.toImmutable() },
                    (savedStyles ?: JsonMissing.of()).map { it.toImmutable() },
                    styleNote,
                    (styleTweets ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): ComposePrepareResult = apply {
            if (validated) {
                return@apply
            }

            contentRules().forEach { it.validate() }
            engagementMultipliers().forEach { it.validate() }
            engagementVelocity()
            followUpQuestions()
            intentUrl()
            nextStep()
            radarRecommendations().forEach { it.validate() }
            scorerWeights().forEach { it.validate() }
            source()
            topPenalties()
            savedStyles().ifPresent { it.forEach { it.validate() } }
            styleNote()
            styleTweets()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (contentRules.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (engagementMultipliers.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (engagementVelocity.asKnown().isPresent) 1 else 0) +
                (followUpQuestions.asKnown().getOrNull()?.size ?: 0) +
                (if (intentUrl.asKnown().isPresent) 1 else 0) +
                (if (nextStep.asKnown().isPresent) 1 else 0) +
                (radarRecommendations.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (scorerWeights.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (source.asKnown().isPresent) 1 else 0) +
                (topPenalties.asKnown().getOrNull()?.size ?: 0) +
                (savedStyles.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (styleNote.asKnown().isPresent) 1 else 0) +
                (styleTweets.asKnown().getOrNull()?.size ?: 0)

        class ContentRule
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val rule: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("rule") @ExcludeMissing rule: JsonField<String> = JsonMissing.of()
            ) : this(rule, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun rule(): String = rule.getRequired("rule")

            /**
             * Returns the raw JSON value of [rule].
             *
             * Unlike [rule], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("rule") @ExcludeMissing fun _rule(): JsonField<String> = rule

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
                 * Returns a mutable builder for constructing an instance of [ContentRule].
                 *
                 * The following fields are required:
                 * ```java
                 * .rule()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ContentRule]. */
            class Builder internal constructor() {

                private var rule: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(contentRule: ContentRule) = apply {
                    rule = contentRule.rule
                    additionalProperties = contentRule.additionalProperties.toMutableMap()
                }

                fun rule(rule: String) = rule(JsonField.of(rule))

                /**
                 * Sets [Builder.rule] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.rule] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun rule(rule: JsonField<String>) = apply { this.rule = rule }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ContentRule].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .rule()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ContentRule =
                    ContentRule(checkRequired("rule", rule), additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): ContentRule = apply {
                if (validated) {
                    return@apply
                }

                rule()
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic internal fun validity(): Int = (if (rule.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ContentRule &&
                    rule == other.rule &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(rule, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ContentRule{rule=$rule, additionalProperties=$additionalProperties}"
        }

        class EngagementMultiplier
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val action: JsonField<String>,
            private val multiplier: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("action")
                @ExcludeMissing
                action: JsonField<String> = JsonMissing.of(),
                @JsonProperty("multiplier")
                @ExcludeMissing
                multiplier: JsonValue = JsonMissing.of(),
            ) : this(action, multiplier, mutableMapOf())

            /**
             * Human-readable published signal name.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun action(): String = action.getRequired("action")

            /**
             * Expected to always return the following:
             * ```java
             * JsonValue.from("Production weight not published by X")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("multiplier") @ExcludeMissing fun _multiplier(): JsonValue = multiplier

            /**
             * Returns the raw JSON value of [action].
             *
             * Unlike [action], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("action") @ExcludeMissing fun _action(): JsonField<String> = action

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
                 * Returns a mutable builder for constructing an instance of [EngagementMultiplier].
                 *
                 * The following fields are required:
                 * ```java
                 * .action()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [EngagementMultiplier]. */
            class Builder internal constructor() {

                private var action: JsonField<String>? = null
                private var multiplier: JsonValue =
                    JsonValue.from("Production weight not published by X")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(engagementMultiplier: EngagementMultiplier) = apply {
                    action = engagementMultiplier.action
                    multiplier = engagementMultiplier.multiplier
                    additionalProperties = engagementMultiplier.additionalProperties.toMutableMap()
                }

                /** Human-readable published signal name. */
                fun action(action: String) = action(JsonField.of(action))

                /**
                 * Sets [Builder.action] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.action] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun action(action: JsonField<String>) = apply { this.action = action }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("Production weight not published by X")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun multiplier(multiplier: JsonValue) = apply { this.multiplier = multiplier }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [EngagementMultiplier].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .action()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): EngagementMultiplier =
                    EngagementMultiplier(
                        checkRequired("action", action),
                        multiplier,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): EngagementMultiplier = apply {
                if (validated) {
                    return@apply
                }

                action()
                _multiplier().let {
                    if (it != JsonValue.from("Production weight not published by X")) {
                        throw XTwitterScraperInvalidDataException(
                            "'multiplier' is invalid, received $it"
                        )
                    }
                }
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (action.asKnown().isPresent) 1 else 0) +
                    multiplier.let {
                        if (it == JsonValue.from("Production weight not published by X")) 1 else 0
                    }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is EngagementMultiplier &&
                    action == other.action &&
                    multiplier == other.multiplier &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(action, multiplier, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "EngagementMultiplier{action=$action, multiplier=$multiplier, additionalProperties=$additionalProperties}"
        }

        class RadarRecommendation
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val endpoint: JsonField<String>,
            private val guidance: JsonField<String>,
            private val source: JsonField<Source>,
            private val useFor: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("endpoint")
                @ExcludeMissing
                endpoint: JsonField<String> = JsonMissing.of(),
                @JsonProperty("guidance")
                @ExcludeMissing
                guidance: JsonField<String> = JsonMissing.of(),
                @JsonProperty("source")
                @ExcludeMissing
                source: JsonField<Source> = JsonMissing.of(),
                @JsonProperty("useFor")
                @ExcludeMissing
                useFor: JsonField<String> = JsonMissing.of(),
            ) : this(endpoint, guidance, source, useFor, mutableMapOf())

            /**
             * Radar endpoint for this source.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun endpoint(): String = endpoint.getRequired("endpoint")

            /**
             * Source-specific drafting guidance.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun guidance(): String = guidance.getRequired("guidance")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun source(): Source = source.getRequired("source")

            /**
             * Current-topic research this source supports.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun useFor(): String = useFor.getRequired("useFor")

            /**
             * Returns the raw JSON value of [endpoint].
             *
             * Unlike [endpoint], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("endpoint") @ExcludeMissing fun _endpoint(): JsonField<String> = endpoint

            /**
             * Returns the raw JSON value of [guidance].
             *
             * Unlike [guidance], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("guidance") @ExcludeMissing fun _guidance(): JsonField<String> = guidance

            /**
             * Returns the raw JSON value of [source].
             *
             * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<Source> = source

            /**
             * Returns the raw JSON value of [useFor].
             *
             * Unlike [useFor], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("useFor") @ExcludeMissing fun _useFor(): JsonField<String> = useFor

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
                 * Returns a mutable builder for constructing an instance of [RadarRecommendation].
                 *
                 * The following fields are required:
                 * ```java
                 * .endpoint()
                 * .guidance()
                 * .source()
                 * .useFor()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [RadarRecommendation]. */
            class Builder internal constructor() {

                private var endpoint: JsonField<String>? = null
                private var guidance: JsonField<String>? = null
                private var source: JsonField<Source>? = null
                private var useFor: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(radarRecommendation: RadarRecommendation) = apply {
                    endpoint = radarRecommendation.endpoint
                    guidance = radarRecommendation.guidance
                    source = radarRecommendation.source
                    useFor = radarRecommendation.useFor
                    additionalProperties = radarRecommendation.additionalProperties.toMutableMap()
                }

                /** Radar endpoint for this source. */
                fun endpoint(endpoint: String) = endpoint(JsonField.of(endpoint))

                /**
                 * Sets [Builder.endpoint] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.endpoint] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun endpoint(endpoint: JsonField<String>) = apply { this.endpoint = endpoint }

                /** Source-specific drafting guidance. */
                fun guidance(guidance: String) = guidance(JsonField.of(guidance))

                /**
                 * Sets [Builder.guidance] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.guidance] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun guidance(guidance: JsonField<String>) = apply { this.guidance = guidance }

                fun source(source: Source) = source(JsonField.of(source))

                /**
                 * Sets [Builder.source] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.source] with a well-typed [Source] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun source(source: JsonField<Source>) = apply { this.source = source }

                /** Current-topic research this source supports. */
                fun useFor(useFor: String) = useFor(JsonField.of(useFor))

                /**
                 * Sets [Builder.useFor] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.useFor] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun useFor(useFor: JsonField<String>) = apply { this.useFor = useFor }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [RadarRecommendation].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .endpoint()
                 * .guidance()
                 * .source()
                 * .useFor()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): RadarRecommendation =
                    RadarRecommendation(
                        checkRequired("endpoint", endpoint),
                        checkRequired("guidance", guidance),
                        checkRequired("source", source),
                        checkRequired("useFor", useFor),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): RadarRecommendation = apply {
                if (validated) {
                    return@apply
                }

                endpoint()
                guidance()
                source().validate()
                useFor()
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (endpoint.asKnown().isPresent) 1 else 0) +
                    (if (guidance.asKnown().isPresent) 1 else 0) +
                    (source.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (useFor.asKnown().isPresent) 1 else 0)

            class Source @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val REDDIT = of("reddit")

                    @JvmField val GITHUB = of("github")

                    @JvmField val TRUSTMRR = of("trustmrr")

                    @JvmField val HACKER_NEWS = of("hacker_news")

                    @JvmField val GOOGLE_TRENDS = of("google_trends")

                    @JvmField val WIKIPEDIA = of("wikipedia")

                    @JvmField val POLYMARKET = of("polymarket")

                    @JvmStatic fun of(value: String) = Source(JsonField.of(value))
                }

                /** An enum containing [Source]'s known values. */
                enum class Known {
                    REDDIT,
                    GITHUB,
                    TRUSTMRR,
                    HACKER_NEWS,
                    GOOGLE_TRENDS,
                    WIKIPEDIA,
                    POLYMARKET,
                }

                /**
                 * An enum containing [Source]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Source] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    REDDIT,
                    GITHUB,
                    TRUSTMRR,
                    HACKER_NEWS,
                    GOOGLE_TRENDS,
                    WIKIPEDIA,
                    POLYMARKET,
                    /**
                     * An enum member indicating that [Source] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        REDDIT -> Value.REDDIT
                        GITHUB -> Value.GITHUB
                        TRUSTMRR -> Value.TRUSTMRR
                        HACKER_NEWS -> Value.HACKER_NEWS
                        GOOGLE_TRENDS -> Value.GOOGLE_TRENDS
                        WIKIPEDIA -> Value.WIKIPEDIA
                        POLYMARKET -> Value.POLYMARKET
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value is a
                 *   not a known member.
                 */
                fun known(): Known =
                    when (this) {
                        REDDIT -> Known.REDDIT
                        GITHUB -> Known.GITHUB
                        TRUSTMRR -> Known.TRUSTMRR
                        HACKER_NEWS -> Known.HACKER_NEWS
                        GOOGLE_TRENDS -> Known.GOOGLE_TRENDS
                        WIKIPEDIA -> Known.WIKIPEDIA
                        POLYMARKET -> Known.POLYMARKET
                        else -> throw XTwitterScraperInvalidDataException("Unknown Source: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws XTwitterScraperInvalidDataException if this class instance's value does
                 *   not have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        XTwitterScraperInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Source = apply {
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

                /**
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Source && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is RadarRecommendation &&
                    endpoint == other.endpoint &&
                    guidance == other.guidance &&
                    source == other.source &&
                    useFor == other.useFor &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(endpoint, guidance, source, useFor, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "RadarRecommendation{endpoint=$endpoint, guidance=$guidance, source=$source, useFor=$useFor, additionalProperties=$additionalProperties}"
        }

        class ScorerWeight
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val context: JsonField<String>,
            private val signal: JsonField<String>,
            private val weight: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("context")
                @ExcludeMissing
                context: JsonField<String> = JsonMissing.of(),
                @JsonProperty("signal")
                @ExcludeMissing
                signal: JsonField<String> = JsonMissing.of(),
                @JsonProperty("weight") @ExcludeMissing weight: JsonValue = JsonMissing.of(),
            ) : this(context, signal, weight, mutableMapOf())

            /**
             * Signal direction and publication limit.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun context(): String = context.getRequired("context")

            /**
             * Signal name from X's public ranking repository.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun signal(): String = signal.getRequired("signal")

            /**
             * X does not publish the production weight.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from(null)
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("weight") @ExcludeMissing fun _weight(): JsonValue = weight

            /**
             * Returns the raw JSON value of [context].
             *
             * Unlike [context], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("context") @ExcludeMissing fun _context(): JsonField<String> = context

            /**
             * Returns the raw JSON value of [signal].
             *
             * Unlike [signal], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("signal") @ExcludeMissing fun _signal(): JsonField<String> = signal

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
                 * Returns a mutable builder for constructing an instance of [ScorerWeight].
                 *
                 * The following fields are required:
                 * ```java
                 * .context()
                 * .signal()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ScorerWeight]. */
            class Builder internal constructor() {

                private var context: JsonField<String>? = null
                private var signal: JsonField<String>? = null
                private var weight: JsonValue = JsonValue.from(null)
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(scorerWeight: ScorerWeight) = apply {
                    context = scorerWeight.context
                    signal = scorerWeight.signal
                    weight = scorerWeight.weight
                    additionalProperties = scorerWeight.additionalProperties.toMutableMap()
                }

                /** Signal direction and publication limit. */
                fun context(context: String) = context(JsonField.of(context))

                /**
                 * Sets [Builder.context] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.context] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun context(context: JsonField<String>) = apply { this.context = context }

                /** Signal name from X's public ranking repository. */
                fun signal(signal: String) = signal(JsonField.of(signal))

                /**
                 * Sets [Builder.signal] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.signal] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun signal(signal: JsonField<String>) = apply { this.signal = signal }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from(null)
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun weight(weight: JsonValue) = apply { this.weight = weight }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ScorerWeight].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .context()
                 * .signal()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ScorerWeight =
                    ScorerWeight(
                        checkRequired("context", context),
                        checkRequired("signal", signal),
                        weight,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): ScorerWeight = apply {
                if (validated) {
                    return@apply
                }

                context()
                signal()
                _weight().let {
                    if (it != JsonValue.from(null)) {
                        throw XTwitterScraperInvalidDataException(
                            "'weight' is invalid, received $it"
                        )
                    }
                }
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (context.asKnown().isPresent) 1 else 0) +
                    (if (signal.asKnown().isPresent) 1 else 0) +
                    weight.let { if (it == JsonValue.from(null)) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ScorerWeight &&
                    context == other.context &&
                    signal == other.signal &&
                    weight == other.weight &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(context, signal, weight, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ScorerWeight{context=$context, signal=$signal, weight=$weight, additionalProperties=$additionalProperties}"
        }

        class SavedStyle
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val tweetCount: JsonField<Long>,
            private val username: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("tweetCount")
                @ExcludeMissing
                tweetCount: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("username")
                @ExcludeMissing
                username: JsonField<String> = JsonMissing.of(),
            ) : this(tweetCount, username, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun tweetCount(): Long = tweetCount.getRequired("tweetCount")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun username(): String = username.getRequired("username")

            /**
             * Returns the raw JSON value of [tweetCount].
             *
             * Unlike [tweetCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("tweetCount")
            @ExcludeMissing
            fun _tweetCount(): JsonField<Long> = tweetCount

            /**
             * Returns the raw JSON value of [username].
             *
             * Unlike [username], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

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
                 * Returns a mutable builder for constructing an instance of [SavedStyle].
                 *
                 * The following fields are required:
                 * ```java
                 * .tweetCount()
                 * .username()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [SavedStyle]. */
            class Builder internal constructor() {

                private var tweetCount: JsonField<Long>? = null
                private var username: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(savedStyle: SavedStyle) = apply {
                    tweetCount = savedStyle.tweetCount
                    username = savedStyle.username
                    additionalProperties = savedStyle.additionalProperties.toMutableMap()
                }

                fun tweetCount(tweetCount: Long) = tweetCount(JsonField.of(tweetCount))

                /**
                 * Sets [Builder.tweetCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.tweetCount] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun tweetCount(tweetCount: JsonField<Long>) = apply { this.tweetCount = tweetCount }

                fun username(username: String) = username(JsonField.of(username))

                /**
                 * Sets [Builder.username] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.username] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun username(username: JsonField<String>) = apply { this.username = username }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [SavedStyle].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .tweetCount()
                 * .username()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): SavedStyle =
                    SavedStyle(
                        checkRequired("tweetCount", tweetCount),
                        checkRequired("username", username),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): SavedStyle = apply {
                if (validated) {
                    return@apply
                }

                tweetCount()
                username()
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (tweetCount.asKnown().isPresent) 1 else 0) +
                    (if (username.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is SavedStyle &&
                    tweetCount == other.tweetCount &&
                    username == other.username &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(tweetCount, username, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "SavedStyle{tweetCount=$tweetCount, username=$username, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ComposePrepareResult &&
                contentRules == other.contentRules &&
                engagementMultipliers == other.engagementMultipliers &&
                engagementVelocity == other.engagementVelocity &&
                followUpQuestions == other.followUpQuestions &&
                intentUrl == other.intentUrl &&
                nextStep == other.nextStep &&
                radarRecommendations == other.radarRecommendations &&
                scorerWeights == other.scorerWeights &&
                source == other.source &&
                topPenalties == other.topPenalties &&
                savedStyles == other.savedStyles &&
                styleNote == other.styleNote &&
                styleTweets == other.styleTweets &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                contentRules,
                engagementMultipliers,
                engagementVelocity,
                followUpQuestions,
                intentUrl,
                nextStep,
                radarRecommendations,
                scorerWeights,
                source,
                topPenalties,
                savedStyles,
                styleNote,
                styleTweets,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ComposePrepareResult{contentRules=$contentRules, engagementMultipliers=$engagementMultipliers, engagementVelocity=$engagementVelocity, followUpQuestions=$followUpQuestions, intentUrl=$intentUrl, nextStep=$nextStep, radarRecommendations=$radarRecommendations, scorerWeights=$scorerWeights, source=$source, topPenalties=$topPenalties, savedStyles=$savedStyles, styleNote=$styleNote, styleTweets=$styleTweets, additionalProperties=$additionalProperties}"
    }

    class ComposeRefineResult
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val compositionGuidance: JsonField<List<String>>,
        private val examplePatterns: JsonField<List<ExamplePattern>>,
        private val intentUrl: JsonField<String>,
        private val nextStep: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("compositionGuidance")
            @ExcludeMissing
            compositionGuidance: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("examplePatterns")
            @ExcludeMissing
            examplePatterns: JsonField<List<ExamplePattern>> = JsonMissing.of(),
            @JsonProperty("intentUrl")
            @ExcludeMissing
            intentUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("nextStep")
            @ExcludeMissing
            nextStep: JsonField<String> = JsonMissing.of(),
        ) : this(compositionGuidance, examplePatterns, intentUrl, nextStep, mutableMapOf())

        /**
         * Goal, tone, media, and editorial guidance.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun compositionGuidance(): List<String> =
            compositionGuidance.getRequired("compositionGuidance")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun examplePatterns(): List<ExamplePattern> = examplePatterns.getRequired("examplePatterns")

        /**
         * X post intent seeded with the topic.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun intentUrl(): String = intentUrl.getRequired("intentUrl")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun nextStep(): String = nextStep.getRequired("nextStep")

        /**
         * Returns the raw JSON value of [compositionGuidance].
         *
         * Unlike [compositionGuidance], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("compositionGuidance")
        @ExcludeMissing
        fun _compositionGuidance(): JsonField<List<String>> = compositionGuidance

        /**
         * Returns the raw JSON value of [examplePatterns].
         *
         * Unlike [examplePatterns], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("examplePatterns")
        @ExcludeMissing
        fun _examplePatterns(): JsonField<List<ExamplePattern>> = examplePatterns

        /**
         * Returns the raw JSON value of [intentUrl].
         *
         * Unlike [intentUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("intentUrl") @ExcludeMissing fun _intentUrl(): JsonField<String> = intentUrl

        /**
         * Returns the raw JSON value of [nextStep].
         *
         * Unlike [nextStep], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("nextStep") @ExcludeMissing fun _nextStep(): JsonField<String> = nextStep

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
             * Returns a mutable builder for constructing an instance of [ComposeRefineResult].
             *
             * The following fields are required:
             * ```java
             * .compositionGuidance()
             * .examplePatterns()
             * .intentUrl()
             * .nextStep()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ComposeRefineResult]. */
        class Builder internal constructor() {

            private var compositionGuidance: JsonField<MutableList<String>>? = null
            private var examplePatterns: JsonField<MutableList<ExamplePattern>>? = null
            private var intentUrl: JsonField<String>? = null
            private var nextStep: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(composeRefineResult: ComposeRefineResult) = apply {
                compositionGuidance =
                    composeRefineResult.compositionGuidance.map { it.toMutableList() }
                examplePatterns = composeRefineResult.examplePatterns.map { it.toMutableList() }
                intentUrl = composeRefineResult.intentUrl
                nextStep = composeRefineResult.nextStep
                additionalProperties = composeRefineResult.additionalProperties.toMutableMap()
            }

            /** Goal, tone, media, and editorial guidance. */
            fun compositionGuidance(compositionGuidance: List<String>) =
                compositionGuidance(JsonField.of(compositionGuidance))

            /**
             * Sets [Builder.compositionGuidance] to an arbitrary JSON value.
             *
             * You should usually call [Builder.compositionGuidance] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun compositionGuidance(compositionGuidance: JsonField<List<String>>) = apply {
                this.compositionGuidance = compositionGuidance.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.compositionGuidance].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addCompositionGuidance(compositionGuidance: String) = apply {
                this.compositionGuidance =
                    (this.compositionGuidance ?: JsonField.of(mutableListOf())).also {
                        checkKnown("compositionGuidance", it).add(compositionGuidance)
                    }
            }

            fun examplePatterns(examplePatterns: List<ExamplePattern>) =
                examplePatterns(JsonField.of(examplePatterns))

            /**
             * Sets [Builder.examplePatterns] to an arbitrary JSON value.
             *
             * You should usually call [Builder.examplePatterns] with a well-typed
             * `List<ExamplePattern>` value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun examplePatterns(examplePatterns: JsonField<List<ExamplePattern>>) = apply {
                this.examplePatterns = examplePatterns.map { it.toMutableList() }
            }

            /**
             * Adds a single [ExamplePattern] to [examplePatterns].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addExamplePattern(examplePattern: ExamplePattern) = apply {
                examplePatterns =
                    (examplePatterns ?: JsonField.of(mutableListOf())).also {
                        checkKnown("examplePatterns", it).add(examplePattern)
                    }
            }

            /** X post intent seeded with the topic. */
            fun intentUrl(intentUrl: String) = intentUrl(JsonField.of(intentUrl))

            /**
             * Sets [Builder.intentUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.intentUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun intentUrl(intentUrl: JsonField<String>) = apply { this.intentUrl = intentUrl }

            fun nextStep(nextStep: String) = nextStep(JsonField.of(nextStep))

            /**
             * Sets [Builder.nextStep] to an arbitrary JSON value.
             *
             * You should usually call [Builder.nextStep] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun nextStep(nextStep: JsonField<String>) = apply { this.nextStep = nextStep }

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
             * Returns an immutable instance of [ComposeRefineResult].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .compositionGuidance()
             * .examplePatterns()
             * .intentUrl()
             * .nextStep()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ComposeRefineResult =
                ComposeRefineResult(
                    checkRequired("compositionGuidance", compositionGuidance).map {
                        it.toImmutable()
                    },
                    checkRequired("examplePatterns", examplePatterns).map { it.toImmutable() },
                    checkRequired("intentUrl", intentUrl),
                    checkRequired("nextStep", nextStep),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): ComposeRefineResult = apply {
            if (validated) {
                return@apply
            }

            compositionGuidance()
            examplePatterns().forEach { it.validate() }
            intentUrl()
            nextStep()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (compositionGuidance.asKnown().getOrNull()?.size ?: 0) +
                (examplePatterns.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (intentUrl.asKnown().isPresent) 1 else 0) +
                (if (nextStep.asKnown().isPresent) 1 else 0)

        class ExamplePattern
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val description: JsonField<String>,
            private val pattern: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
                @JsonProperty("pattern")
                @ExcludeMissing
                pattern: JsonField<String> = JsonMissing.of(),
            ) : this(description, pattern, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun description(): String = description.getRequired("description")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun pattern(): String = pattern.getRequired("pattern")

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [pattern].
             *
             * Unlike [pattern], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("pattern") @ExcludeMissing fun _pattern(): JsonField<String> = pattern

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
                 * Returns a mutable builder for constructing an instance of [ExamplePattern].
                 *
                 * The following fields are required:
                 * ```java
                 * .description()
                 * .pattern()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ExamplePattern]. */
            class Builder internal constructor() {

                private var description: JsonField<String>? = null
                private var pattern: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(examplePattern: ExamplePattern) = apply {
                    description = examplePattern.description
                    pattern = examplePattern.pattern
                    additionalProperties = examplePattern.additionalProperties.toMutableMap()
                }

                fun description(description: String) = description(JsonField.of(description))

                /**
                 * Sets [Builder.description] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                fun pattern(pattern: String) = pattern(JsonField.of(pattern))

                /**
                 * Sets [Builder.pattern] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.pattern] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun pattern(pattern: JsonField<String>) = apply { this.pattern = pattern }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ExamplePattern].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .description()
                 * .pattern()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ExamplePattern =
                    ExamplePattern(
                        checkRequired("description", description),
                        checkRequired("pattern", pattern),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): ExamplePattern = apply {
                if (validated) {
                    return@apply
                }

                description()
                pattern()
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (description.asKnown().isPresent) 1 else 0) +
                    (if (pattern.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ExamplePattern &&
                    description == other.description &&
                    pattern == other.pattern &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(description, pattern, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ExamplePattern{description=$description, pattern=$pattern, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ComposeRefineResult &&
                compositionGuidance == other.compositionGuidance &&
                examplePatterns == other.examplePatterns &&
                intentUrl == other.intentUrl &&
                nextStep == other.nextStep &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                compositionGuidance,
                examplePatterns,
                intentUrl,
                nextStep,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ComposeRefineResult{compositionGuidance=$compositionGuidance, examplePatterns=$examplePatterns, intentUrl=$intentUrl, nextStep=$nextStep, additionalProperties=$additionalProperties}"
    }

    class ComposeScoreResult
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val checklist: JsonField<List<Checklist>>,
        private val nextStep: JsonField<String>,
        private val passed: JsonField<Boolean>,
        private val passedCount: JsonField<Long>,
        private val topSuggestion: JsonField<String>,
        private val totalChecks: JsonValue,
        private val intentUrl: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("checklist")
            @ExcludeMissing
            checklist: JsonField<List<Checklist>> = JsonMissing.of(),
            @JsonProperty("nextStep")
            @ExcludeMissing
            nextStep: JsonField<String> = JsonMissing.of(),
            @JsonProperty("passed") @ExcludeMissing passed: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("passedCount")
            @ExcludeMissing
            passedCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("topSuggestion")
            @ExcludeMissing
            topSuggestion: JsonField<String> = JsonMissing.of(),
            @JsonProperty("totalChecks") @ExcludeMissing totalChecks: JsonValue = JsonMissing.of(),
            @JsonProperty("intentUrl")
            @ExcludeMissing
            intentUrl: JsonField<String> = JsonMissing.of(),
        ) : this(
            checklist,
            nextStep,
            passed,
            passedCount,
            topSuggestion,
            totalChecks,
            intentUrl,
            mutableMapOf(),
        )

        /**
         * Deterministic editorial checks. Not a reach prediction.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun checklist(): List<Checklist> = checklist.getRequired("checklist")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun nextStep(): String = nextStep.getRequired("nextStep")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun passed(): Boolean = passed.getRequired("passed")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun passedCount(): Long = passedCount.getRequired("passedCount")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun topSuggestion(): String = topSuggestion.getRequired("topSuggestion")

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from(9)
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("totalChecks") @ExcludeMissing fun _totalChecks(): JsonValue = totalChecks

        /**
         * Present only when every check passes.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun intentUrl(): Optional<String> = intentUrl.getOptional("intentUrl")

        /**
         * Returns the raw JSON value of [checklist].
         *
         * Unlike [checklist], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("checklist")
        @ExcludeMissing
        fun _checklist(): JsonField<List<Checklist>> = checklist

        /**
         * Returns the raw JSON value of [nextStep].
         *
         * Unlike [nextStep], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("nextStep") @ExcludeMissing fun _nextStep(): JsonField<String> = nextStep

        /**
         * Returns the raw JSON value of [passed].
         *
         * Unlike [passed], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("passed") @ExcludeMissing fun _passed(): JsonField<Boolean> = passed

        /**
         * Returns the raw JSON value of [passedCount].
         *
         * Unlike [passedCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("passedCount")
        @ExcludeMissing
        fun _passedCount(): JsonField<Long> = passedCount

        /**
         * Returns the raw JSON value of [topSuggestion].
         *
         * Unlike [topSuggestion], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("topSuggestion")
        @ExcludeMissing
        fun _topSuggestion(): JsonField<String> = topSuggestion

        /**
         * Returns the raw JSON value of [intentUrl].
         *
         * Unlike [intentUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("intentUrl") @ExcludeMissing fun _intentUrl(): JsonField<String> = intentUrl

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
             * Returns a mutable builder for constructing an instance of [ComposeScoreResult].
             *
             * The following fields are required:
             * ```java
             * .checklist()
             * .nextStep()
             * .passed()
             * .passedCount()
             * .topSuggestion()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ComposeScoreResult]. */
        class Builder internal constructor() {

            private var checklist: JsonField<MutableList<Checklist>>? = null
            private var nextStep: JsonField<String>? = null
            private var passed: JsonField<Boolean>? = null
            private var passedCount: JsonField<Long>? = null
            private var topSuggestion: JsonField<String>? = null
            private var totalChecks: JsonValue = JsonValue.from(9)
            private var intentUrl: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(composeScoreResult: ComposeScoreResult) = apply {
                checklist = composeScoreResult.checklist.map { it.toMutableList() }
                nextStep = composeScoreResult.nextStep
                passed = composeScoreResult.passed
                passedCount = composeScoreResult.passedCount
                topSuggestion = composeScoreResult.topSuggestion
                totalChecks = composeScoreResult.totalChecks
                intentUrl = composeScoreResult.intentUrl
                additionalProperties = composeScoreResult.additionalProperties.toMutableMap()
            }

            /** Deterministic editorial checks. Not a reach prediction. */
            fun checklist(checklist: List<Checklist>) = checklist(JsonField.of(checklist))

            /**
             * Sets [Builder.checklist] to an arbitrary JSON value.
             *
             * You should usually call [Builder.checklist] with a well-typed `List<Checklist>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun checklist(checklist: JsonField<List<Checklist>>) = apply {
                this.checklist = checklist.map { it.toMutableList() }
            }

            /**
             * Adds a single [Checklist] to [Builder.checklist].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addChecklist(checklist: Checklist) = apply {
                this.checklist =
                    (this.checklist ?: JsonField.of(mutableListOf())).also {
                        checkKnown("checklist", it).add(checklist)
                    }
            }

            fun nextStep(nextStep: String) = nextStep(JsonField.of(nextStep))

            /**
             * Sets [Builder.nextStep] to an arbitrary JSON value.
             *
             * You should usually call [Builder.nextStep] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun nextStep(nextStep: JsonField<String>) = apply { this.nextStep = nextStep }

            fun passed(passed: Boolean) = passed(JsonField.of(passed))

            /**
             * Sets [Builder.passed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.passed] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun passed(passed: JsonField<Boolean>) = apply { this.passed = passed }

            fun passedCount(passedCount: Long) = passedCount(JsonField.of(passedCount))

            /**
             * Sets [Builder.passedCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.passedCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun passedCount(passedCount: JsonField<Long>) = apply { this.passedCount = passedCount }

            fun topSuggestion(topSuggestion: String) = topSuggestion(JsonField.of(topSuggestion))

            /**
             * Sets [Builder.topSuggestion] to an arbitrary JSON value.
             *
             * You should usually call [Builder.topSuggestion] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun topSuggestion(topSuggestion: JsonField<String>) = apply {
                this.topSuggestion = topSuggestion
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from(9)
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalChecks(totalChecks: JsonValue) = apply { this.totalChecks = totalChecks }

            /** Present only when every check passes. */
            fun intentUrl(intentUrl: String) = intentUrl(JsonField.of(intentUrl))

            /**
             * Sets [Builder.intentUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.intentUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun intentUrl(intentUrl: JsonField<String>) = apply { this.intentUrl = intentUrl }

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
             * Returns an immutable instance of [ComposeScoreResult].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .checklist()
             * .nextStep()
             * .passed()
             * .passedCount()
             * .topSuggestion()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): ComposeScoreResult =
                ComposeScoreResult(
                    checkRequired("checklist", checklist).map { it.toImmutable() },
                    checkRequired("nextStep", nextStep),
                    checkRequired("passed", passed),
                    checkRequired("passedCount", passedCount),
                    checkRequired("topSuggestion", topSuggestion),
                    totalChecks,
                    intentUrl,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
         *   match its expected type.
         */
        fun validate(): ComposeScoreResult = apply {
            if (validated) {
                return@apply
            }

            checklist().forEach { it.validate() }
            nextStep()
            passed()
            passedCount()
            topSuggestion()
            _totalChecks().let {
                if (it != JsonValue.from(9)) {
                    throw XTwitterScraperInvalidDataException(
                        "'totalChecks' is invalid, received $it"
                    )
                }
            }
            intentUrl()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (checklist.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (nextStep.asKnown().isPresent) 1 else 0) +
                (if (passed.asKnown().isPresent) 1 else 0) +
                (if (passedCount.asKnown().isPresent) 1 else 0) +
                (if (topSuggestion.asKnown().isPresent) 1 else 0) +
                totalChecks.let { if (it == JsonValue.from(9)) 1 else 0 } +
                (if (intentUrl.asKnown().isPresent) 1 else 0)

        class Checklist
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val factor: JsonField<String>,
            private val passed: JsonField<Boolean>,
            private val suggestion: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("factor")
                @ExcludeMissing
                factor: JsonField<String> = JsonMissing.of(),
                @JsonProperty("passed")
                @ExcludeMissing
                passed: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("suggestion")
                @ExcludeMissing
                suggestion: JsonField<String> = JsonMissing.of(),
            ) : this(factor, passed, suggestion, mutableMapOf())

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun factor(): String = factor.getRequired("factor")

            /**
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun passed(): Boolean = passed.getRequired("passed")

            /**
             * Present only when the check fails.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun suggestion(): Optional<String> = suggestion.getOptional("suggestion")

            /**
             * Returns the raw JSON value of [factor].
             *
             * Unlike [factor], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("factor") @ExcludeMissing fun _factor(): JsonField<String> = factor

            /**
             * Returns the raw JSON value of [passed].
             *
             * Unlike [passed], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("passed") @ExcludeMissing fun _passed(): JsonField<Boolean> = passed

            /**
             * Returns the raw JSON value of [suggestion].
             *
             * Unlike [suggestion], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("suggestion")
            @ExcludeMissing
            fun _suggestion(): JsonField<String> = suggestion

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
                 * Returns a mutable builder for constructing an instance of [Checklist].
                 *
                 * The following fields are required:
                 * ```java
                 * .factor()
                 * .passed()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Checklist]. */
            class Builder internal constructor() {

                private var factor: JsonField<String>? = null
                private var passed: JsonField<Boolean>? = null
                private var suggestion: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(checklist: Checklist) = apply {
                    factor = checklist.factor
                    passed = checklist.passed
                    suggestion = checklist.suggestion
                    additionalProperties = checklist.additionalProperties.toMutableMap()
                }

                fun factor(factor: String) = factor(JsonField.of(factor))

                /**
                 * Sets [Builder.factor] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.factor] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun factor(factor: JsonField<String>) = apply { this.factor = factor }

                fun passed(passed: Boolean) = passed(JsonField.of(passed))

                /**
                 * Sets [Builder.passed] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.passed] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun passed(passed: JsonField<Boolean>) = apply { this.passed = passed }

                /** Present only when the check fails. */
                fun suggestion(suggestion: String) = suggestion(JsonField.of(suggestion))

                /**
                 * Sets [Builder.suggestion] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.suggestion] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun suggestion(suggestion: JsonField<String>) = apply {
                    this.suggestion = suggestion
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Checklist].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .factor()
                 * .passed()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Checklist =
                    Checklist(
                        checkRequired("factor", factor),
                        checkRequired("passed", passed),
                        suggestion,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws XTwitterScraperInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): Checklist = apply {
                if (validated) {
                    return@apply
                }

                factor()
                passed()
                suggestion()
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (factor.asKnown().isPresent) 1 else 0) +
                    (if (passed.asKnown().isPresent) 1 else 0) +
                    (if (suggestion.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Checklist &&
                    factor == other.factor &&
                    passed == other.passed &&
                    suggestion == other.suggestion &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(factor, passed, suggestion, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Checklist{factor=$factor, passed=$passed, suggestion=$suggestion, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ComposeScoreResult &&
                checklist == other.checklist &&
                nextStep == other.nextStep &&
                passed == other.passed &&
                passedCount == other.passedCount &&
                topSuggestion == other.topSuggestion &&
                totalChecks == other.totalChecks &&
                intentUrl == other.intentUrl &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                checklist,
                nextStep,
                passed,
                passedCount,
                topSuggestion,
                totalChecks,
                intentUrl,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ComposeScoreResult{checklist=$checklist, nextStep=$nextStep, passed=$passed, passedCount=$passedCount, topSuggestion=$topSuggestion, totalChecks=$totalChecks, intentUrl=$intentUrl, additionalProperties=$additionalProperties}"
    }
}
