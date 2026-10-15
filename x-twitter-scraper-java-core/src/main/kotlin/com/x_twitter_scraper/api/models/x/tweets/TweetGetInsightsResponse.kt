// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.tweets

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TweetGetInsightsResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val insights: JsonField<Insights>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("insights") @ExcludeMissing insights: JsonField<Insights> = JsonMissing.of()
    ) : this(insights, mutableMapOf())

    /**
     * Engagement insights of 1 tweet. Engagements are likes, replies, reposts and quotes. A rate is
     * null when nothing divides it, such as a tweet without views.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun insights(): Insights = insights.getRequired("insights")

    /**
     * Returns the raw JSON value of [insights].
     *
     * Unlike [insights], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("insights") @ExcludeMissing fun _insights(): JsonField<Insights> = insights

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
         * Returns a mutable builder for constructing an instance of [TweetGetInsightsResponse].
         *
         * The following fields are required:
         * ```java
         * .insights()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetGetInsightsResponse]. */
    class Builder internal constructor() {

        private var insights: JsonField<Insights>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tweetGetInsightsResponse: TweetGetInsightsResponse) = apply {
            insights = tweetGetInsightsResponse.insights
            additionalProperties = tweetGetInsightsResponse.additionalProperties.toMutableMap()
        }

        /**
         * Engagement insights of 1 tweet. Engagements are likes, replies, reposts and quotes. A
         * rate is null when nothing divides it, such as a tweet without views.
         */
        fun insights(insights: Insights) = insights(JsonField.of(insights))

        /** Sets [Builder.insights] to an arbitrary JSON value. */
        fun insights(insights: JsonField<Insights>) = apply { this.insights = insights }

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
         * Returns an immutable instance of [TweetGetInsightsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .insights()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TweetGetInsightsResponse =
            TweetGetInsightsResponse(
                checkRequired("insights", insights),
                additionalProperties.toMutableMap(),
            )
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
    fun validate(): TweetGetInsightsResponse = apply {
        if (validated) {
            return@apply
        }

        insights().validate()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    @JvmSynthetic internal fun validity(): Int = (insights.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Engagement insights of 1 tweet. Engagements are likes, replies, reposts and quotes. A rate is
     * null when nothing divides it, such as a tweet without views.
     */
    class Insights
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val ageHours: JsonField<Double>,
        private val amplification: JsonField<Double>,
        private val authorId: JsonField<String>,
        private val authorUserName: JsonField<String>,
        private val conversation: JsonField<Double>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val engagementPerView: JsonField<Double>,
        private val engagementRate: JsonField<Double>,
        private val engagements: JsonField<Double>,
        private val engagementsPerHour: JsonField<Double>,
        private val metrics: JsonField<Metrics>,
        private val tweetId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("ageHours")
            @ExcludeMissing
            ageHours: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("amplification")
            @ExcludeMissing
            amplification: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("authorId")
            @ExcludeMissing
            authorId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("authorUserName")
            @ExcludeMissing
            authorUserName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("conversation")
            @ExcludeMissing
            conversation: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("engagementPerView")
            @ExcludeMissing
            engagementPerView: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("engagementRate")
            @ExcludeMissing
            engagementRate: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("engagements")
            @ExcludeMissing
            engagements: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("engagementsPerHour")
            @ExcludeMissing
            engagementsPerHour: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("metrics") @ExcludeMissing metrics: JsonField<Metrics> = JsonMissing.of(),
            @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
        ) : this(
            ageHours,
            amplification,
            authorId,
            authorUserName,
            conversation,
            createdAt,
            engagementPerView,
            engagementRate,
            engagements,
            engagementsPerHour,
            metrics,
            tweetId,
            mutableMapOf(),
        )

        /**
         * Hours since the tweet went up.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun ageHours(): Optional<Double> = ageHours.getOptional("ageHours")

        /**
         * Reposts and quotes per like.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun amplification(): Optional<Double> = amplification.getOptional("amplification")

        /**
         * ID of the author.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun authorId(): Optional<String> = authorId.getOptional("authorId")

        /**
         * Username of the author.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun authorUserName(): Optional<String> = authorUserName.getOptional("authorUserName")

        /**
         * Replies per like.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun conversation(): Optional<Double> = conversation.getOptional("conversation")

        /**
         * When the tweet went up.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

        /**
         * Engagements as a percent of views.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun engagementPerView(): Optional<Double> =
            engagementPerView.getOptional("engagementPerView")

        /**
         * Engagements as a percent of the author's followers.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun engagementRate(): Optional<Double> = engagementRate.getOptional("engagementRate")

        /**
         * Likes, replies, reposts and quotes.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun engagements(): Double = engagements.getRequired("engagements")

        /**
         * Engagements per hour since the tweet went up.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun engagementsPerHour(): Optional<Double> =
            engagementsPerHour.getOptional("engagementsPerHour")

        /**
         * The public counts of 1 tweet.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun metrics(): Metrics = metrics.getRequired("metrics")

        /**
         * ID of the tweet the insights describe.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun tweetId(): String = tweetId.getRequired("tweetId")

        /**
         * Returns the raw JSON value of [ageHours].
         *
         * Unlike [ageHours], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ageHours") @ExcludeMissing fun _ageHours(): JsonField<Double> = ageHours

        /**
         * Returns the raw JSON value of [amplification].
         *
         * Unlike [amplification], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("amplification")
        @ExcludeMissing
        fun _amplification(): JsonField<Double> = amplification

        /**
         * Returns the raw JSON value of [authorId].
         *
         * Unlike [authorId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("authorId") @ExcludeMissing fun _authorId(): JsonField<String> = authorId

        /**
         * Returns the raw JSON value of [authorUserName].
         *
         * Unlike [authorUserName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("authorUserName")
        @ExcludeMissing
        fun _authorUserName(): JsonField<String> = authorUserName

        /**
         * Returns the raw JSON value of [conversation].
         *
         * Unlike [conversation], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("conversation")
        @ExcludeMissing
        fun _conversation(): JsonField<Double> = conversation

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [engagementPerView].
         *
         * Unlike [engagementPerView], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("engagementPerView")
        @ExcludeMissing
        fun _engagementPerView(): JsonField<Double> = engagementPerView

        /**
         * Returns the raw JSON value of [engagementRate].
         *
         * Unlike [engagementRate], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("engagementRate")
        @ExcludeMissing
        fun _engagementRate(): JsonField<Double> = engagementRate

        /**
         * Returns the raw JSON value of [engagements].
         *
         * Unlike [engagements], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("engagements")
        @ExcludeMissing
        fun _engagements(): JsonField<Double> = engagements

        /**
         * Returns the raw JSON value of [engagementsPerHour].
         *
         * Unlike [engagementsPerHour], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("engagementsPerHour")
        @ExcludeMissing
        fun _engagementsPerHour(): JsonField<Double> = engagementsPerHour

        /**
         * Returns the raw JSON value of [metrics].
         *
         * Unlike [metrics], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metrics") @ExcludeMissing fun _metrics(): JsonField<Metrics> = metrics

        /**
         * Returns the raw JSON value of [tweetId].
         *
         * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

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
             * Returns a mutable builder for constructing an instance of [Insights].
             *
             * The following fields are required:
             * ```java
             * .ageHours()
             * .amplification()
             * .authorId()
             * .authorUserName()
             * .conversation()
             * .createdAt()
             * .engagementPerView()
             * .engagementRate()
             * .engagements()
             * .engagementsPerHour()
             * .metrics()
             * .tweetId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Insights]. */
        class Builder internal constructor() {

            private var ageHours: JsonField<Double>? = null
            private var amplification: JsonField<Double>? = null
            private var authorId: JsonField<String>? = null
            private var authorUserName: JsonField<String>? = null
            private var conversation: JsonField<Double>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var engagementPerView: JsonField<Double>? = null
            private var engagementRate: JsonField<Double>? = null
            private var engagements: JsonField<Double>? = null
            private var engagementsPerHour: JsonField<Double>? = null
            private var metrics: JsonField<Metrics>? = null
            private var tweetId: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(insights: Insights) = apply {
                ageHours = insights.ageHours
                amplification = insights.amplification
                authorId = insights.authorId
                authorUserName = insights.authorUserName
                conversation = insights.conversation
                createdAt = insights.createdAt
                engagementPerView = insights.engagementPerView
                engagementRate = insights.engagementRate
                engagements = insights.engagements
                engagementsPerHour = insights.engagementsPerHour
                metrics = insights.metrics
                tweetId = insights.tweetId
                additionalProperties = insights.additionalProperties.toMutableMap()
            }

            /** Hours since the tweet went up. */
            fun ageHours(ageHours: Double?) = ageHours(JsonField.ofNullable(ageHours))

            /** Alias for [Builder.ageHours]. */
            fun ageHours(ageHours: Double) = ageHours(ageHours as Double?)

            /** Alias for calling [Builder.ageHours] with `ageHours.orElse(null)`. */
            fun ageHours(ageHours: Optional<Double>) = ageHours(ageHours.getOrNull())

            /** Sets [Builder.ageHours] to an arbitrary JSON value. */
            fun ageHours(ageHours: JsonField<Double>) = apply { this.ageHours = ageHours }

            /** Reposts and quotes per like. */
            fun amplification(amplification: Double?) =
                amplification(JsonField.ofNullable(amplification))

            /** Alias for [Builder.amplification]. */
            fun amplification(amplification: Double) = amplification(amplification as Double?)

            /** Alias for calling [Builder.amplification] with `amplification.orElse(null)`. */
            fun amplification(amplification: Optional<Double>) =
                amplification(amplification.getOrNull())

            /** Sets [Builder.amplification] to an arbitrary JSON value. */
            fun amplification(amplification: JsonField<Double>) = apply {
                this.amplification = amplification
            }

            /** ID of the author. */
            fun authorId(authorId: String?) = authorId(JsonField.ofNullable(authorId))

            /** Alias for calling [Builder.authorId] with `authorId.orElse(null)`. */
            fun authorId(authorId: Optional<String>) = authorId(authorId.getOrNull())

            /** Sets [Builder.authorId] to an arbitrary JSON value. */
            fun authorId(authorId: JsonField<String>) = apply { this.authorId = authorId }

            /** Username of the author. */
            fun authorUserName(authorUserName: String?) =
                authorUserName(JsonField.ofNullable(authorUserName))

            /** Alias for calling [Builder.authorUserName] with `authorUserName.orElse(null)`. */
            fun authorUserName(authorUserName: Optional<String>) =
                authorUserName(authorUserName.getOrNull())

            /** Sets [Builder.authorUserName] to an arbitrary JSON value. */
            fun authorUserName(authorUserName: JsonField<String>) = apply {
                this.authorUserName = authorUserName
            }

            /** Replies per like. */
            fun conversation(conversation: Double?) =
                conversation(JsonField.ofNullable(conversation))

            /** Alias for [Builder.conversation]. */
            fun conversation(conversation: Double) = conversation(conversation as Double?)

            /** Alias for calling [Builder.conversation] with `conversation.orElse(null)`. */
            fun conversation(conversation: Optional<Double>) =
                conversation(conversation.getOrNull())

            /** Sets [Builder.conversation] to an arbitrary JSON value. */
            fun conversation(conversation: JsonField<Double>) = apply {
                this.conversation = conversation
            }

            /** When the tweet went up. */
            fun createdAt(createdAt: OffsetDateTime?) = createdAt(JsonField.ofNullable(createdAt))

            /** Alias for calling [Builder.createdAt] with `createdAt.orElse(null)`. */
            fun createdAt(createdAt: Optional<OffsetDateTime>) = createdAt(createdAt.getOrNull())

            /** Sets [Builder.createdAt] to an arbitrary JSON value. */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            /** Engagements as a percent of views. */
            fun engagementPerView(engagementPerView: Double?) =
                engagementPerView(JsonField.ofNullable(engagementPerView))

            /** Alias for [Builder.engagementPerView]. */
            fun engagementPerView(engagementPerView: Double) =
                engagementPerView(engagementPerView as Double?)

            /**
             * Alias for calling [Builder.engagementPerView] with `engagementPerView.orElse(null)`.
             */
            fun engagementPerView(engagementPerView: Optional<Double>) =
                engagementPerView(engagementPerView.getOrNull())

            /** Sets [Builder.engagementPerView] to an arbitrary JSON value. */
            fun engagementPerView(engagementPerView: JsonField<Double>) = apply {
                this.engagementPerView = engagementPerView
            }

            /** Engagements as a percent of the author's followers. */
            fun engagementRate(engagementRate: Double?) =
                engagementRate(JsonField.ofNullable(engagementRate))

            /** Alias for [Builder.engagementRate]. */
            fun engagementRate(engagementRate: Double) = engagementRate(engagementRate as Double?)

            /** Alias for calling [Builder.engagementRate] with `engagementRate.orElse(null)`. */
            fun engagementRate(engagementRate: Optional<Double>) =
                engagementRate(engagementRate.getOrNull())

            /** Sets [Builder.engagementRate] to an arbitrary JSON value. */
            fun engagementRate(engagementRate: JsonField<Double>) = apply {
                this.engagementRate = engagementRate
            }

            /** Likes, replies, reposts and quotes. */
            fun engagements(engagements: Double) = engagements(JsonField.of(engagements))

            /** Sets [Builder.engagements] to an arbitrary JSON value. */
            fun engagements(engagements: JsonField<Double>) = apply {
                this.engagements = engagements
            }

            /** Engagements per hour since the tweet went up. */
            fun engagementsPerHour(engagementsPerHour: Double?) =
                engagementsPerHour(JsonField.ofNullable(engagementsPerHour))

            /** Alias for [Builder.engagementsPerHour]. */
            fun engagementsPerHour(engagementsPerHour: Double) =
                engagementsPerHour(engagementsPerHour as Double?)

            /**
             * Alias for calling [Builder.engagementsPerHour] with
             * `engagementsPerHour.orElse(null)`.
             */
            fun engagementsPerHour(engagementsPerHour: Optional<Double>) =
                engagementsPerHour(engagementsPerHour.getOrNull())

            /** Sets [Builder.engagementsPerHour] to an arbitrary JSON value. */
            fun engagementsPerHour(engagementsPerHour: JsonField<Double>) = apply {
                this.engagementsPerHour = engagementsPerHour
            }

            /** The public counts of 1 tweet. */
            fun metrics(metrics: Metrics) = metrics(JsonField.of(metrics))

            /** Sets [Builder.metrics] to an arbitrary JSON value. */
            fun metrics(metrics: JsonField<Metrics>) = apply { this.metrics = metrics }

            /** ID of the tweet the insights describe. */
            fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

            /** Sets [Builder.tweetId] to an arbitrary JSON value. */
            fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

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
             * Returns an immutable instance of [Insights].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .ageHours()
             * .amplification()
             * .authorId()
             * .authorUserName()
             * .conversation()
             * .createdAt()
             * .engagementPerView()
             * .engagementRate()
             * .engagements()
             * .engagementsPerHour()
             * .metrics()
             * .tweetId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Insights =
                Insights(
                    checkRequired("ageHours", ageHours),
                    checkRequired("amplification", amplification),
                    checkRequired("authorId", authorId),
                    checkRequired("authorUserName", authorUserName),
                    checkRequired("conversation", conversation),
                    checkRequired("createdAt", createdAt),
                    checkRequired("engagementPerView", engagementPerView),
                    checkRequired("engagementRate", engagementRate),
                    checkRequired("engagements", engagements),
                    checkRequired("engagementsPerHour", engagementsPerHour),
                    checkRequired("metrics", metrics),
                    checkRequired("tweetId", tweetId),
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
        fun validate(): Insights = apply {
            if (validated) {
                return@apply
            }

            ageHours()
            amplification()
            authorId()
            authorUserName()
            conversation()
            createdAt()
            engagementPerView()
            engagementRate()
            engagements()
            engagementsPerHour()
            metrics().validate()
            tweetId()
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
            (if (ageHours.asKnown().isPresent) 1 else 0) +
                (if (amplification.asKnown().isPresent) 1 else 0) +
                (if (authorId.asKnown().isPresent) 1 else 0) +
                (if (authorUserName.asKnown().isPresent) 1 else 0) +
                (if (conversation.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (engagementPerView.asKnown().isPresent) 1 else 0) +
                (if (engagementRate.asKnown().isPresent) 1 else 0) +
                (if (engagements.asKnown().isPresent) 1 else 0) +
                (if (engagementsPerHour.asKnown().isPresent) 1 else 0) +
                (metrics.asKnown().getOrNull()?.validity() ?: 0) +
                (if (tweetId.asKnown().isPresent) 1 else 0)

        /** The public counts of 1 tweet. */
        class Metrics
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val bookmarks: JsonField<Double>,
            private val likes: JsonField<Double>,
            private val quotes: JsonField<Double>,
            private val replies: JsonField<Double>,
            private val reposts: JsonField<Double>,
            private val views: JsonField<Double>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bookmarks")
                @ExcludeMissing
                bookmarks: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("likes") @ExcludeMissing likes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("quotes")
                @ExcludeMissing
                quotes: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("replies")
                @ExcludeMissing
                replies: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("reposts")
                @ExcludeMissing
                reposts: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("views") @ExcludeMissing views: JsonField<Double> = JsonMissing.of(),
            ) : this(bookmarks, likes, quotes, replies, reposts, views, mutableMapOf())

            /**
             * Bookmarks.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun bookmarks(): Double = bookmarks.getRequired("bookmarks")

            /**
             * Likes.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun likes(): Double = likes.getRequired("likes")

            /**
             * Quotes.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun quotes(): Double = quotes.getRequired("quotes")

            /**
             * Replies.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun replies(): Double = replies.getRequired("replies")

            /**
             * Reposts.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun reposts(): Double = reposts.getRequired("reposts")

            /**
             * Views.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun views(): Double = views.getRequired("views")

            /**
             * Returns the raw JSON value of [bookmarks].
             *
             * Unlike [bookmarks], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("bookmarks")
            @ExcludeMissing
            fun _bookmarks(): JsonField<Double> = bookmarks

            /**
             * Returns the raw JSON value of [likes].
             *
             * Unlike [likes], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("likes") @ExcludeMissing fun _likes(): JsonField<Double> = likes

            /**
             * Returns the raw JSON value of [quotes].
             *
             * Unlike [quotes], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("quotes") @ExcludeMissing fun _quotes(): JsonField<Double> = quotes

            /**
             * Returns the raw JSON value of [replies].
             *
             * Unlike [replies], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("replies") @ExcludeMissing fun _replies(): JsonField<Double> = replies

            /**
             * Returns the raw JSON value of [reposts].
             *
             * Unlike [reposts], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("reposts") @ExcludeMissing fun _reposts(): JsonField<Double> = reposts

            /**
             * Returns the raw JSON value of [views].
             *
             * Unlike [views], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("views") @ExcludeMissing fun _views(): JsonField<Double> = views

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
                 * Returns a mutable builder for constructing an instance of [Metrics].
                 *
                 * The following fields are required:
                 * ```java
                 * .bookmarks()
                 * .likes()
                 * .quotes()
                 * .replies()
                 * .reposts()
                 * .views()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Metrics]. */
            class Builder internal constructor() {

                private var bookmarks: JsonField<Double>? = null
                private var likes: JsonField<Double>? = null
                private var quotes: JsonField<Double>? = null
                private var replies: JsonField<Double>? = null
                private var reposts: JsonField<Double>? = null
                private var views: JsonField<Double>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(metrics: Metrics) = apply {
                    bookmarks = metrics.bookmarks
                    likes = metrics.likes
                    quotes = metrics.quotes
                    replies = metrics.replies
                    reposts = metrics.reposts
                    views = metrics.views
                    additionalProperties = metrics.additionalProperties.toMutableMap()
                }

                /** Bookmarks. */
                fun bookmarks(bookmarks: Double) = bookmarks(JsonField.of(bookmarks))

                /** Sets [Builder.bookmarks] to an arbitrary JSON value. */
                fun bookmarks(bookmarks: JsonField<Double>) = apply { this.bookmarks = bookmarks }

                /** Likes. */
                fun likes(likes: Double) = likes(JsonField.of(likes))

                /** Sets [Builder.likes] to an arbitrary JSON value. */
                fun likes(likes: JsonField<Double>) = apply { this.likes = likes }

                /** Quotes. */
                fun quotes(quotes: Double) = quotes(JsonField.of(quotes))

                /** Sets [Builder.quotes] to an arbitrary JSON value. */
                fun quotes(quotes: JsonField<Double>) = apply { this.quotes = quotes }

                /** Replies. */
                fun replies(replies: Double) = replies(JsonField.of(replies))

                /** Sets [Builder.replies] to an arbitrary JSON value. */
                fun replies(replies: JsonField<Double>) = apply { this.replies = replies }

                /** Reposts. */
                fun reposts(reposts: Double) = reposts(JsonField.of(reposts))

                /** Sets [Builder.reposts] to an arbitrary JSON value. */
                fun reposts(reposts: JsonField<Double>) = apply { this.reposts = reposts }

                /** Views. */
                fun views(views: Double) = views(JsonField.of(views))

                /** Sets [Builder.views] to an arbitrary JSON value. */
                fun views(views: JsonField<Double>) = apply { this.views = views }

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
                 * Returns an immutable instance of [Metrics].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .bookmarks()
                 * .likes()
                 * .quotes()
                 * .replies()
                 * .reposts()
                 * .views()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Metrics =
                    Metrics(
                        checkRequired("bookmarks", bookmarks),
                        checkRequired("likes", likes),
                        checkRequired("quotes", quotes),
                        checkRequired("replies", replies),
                        checkRequired("reposts", reposts),
                        checkRequired("views", views),
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
            fun validate(): Metrics = apply {
                if (validated) {
                    return@apply
                }

                bookmarks()
                likes()
                quotes()
                replies()
                reposts()
                views()
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
                (if (bookmarks.asKnown().isPresent) 1 else 0) +
                    (if (likes.asKnown().isPresent) 1 else 0) +
                    (if (quotes.asKnown().isPresent) 1 else 0) +
                    (if (replies.asKnown().isPresent) 1 else 0) +
                    (if (reposts.asKnown().isPresent) 1 else 0) +
                    (if (views.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Metrics &&
                    bookmarks == other.bookmarks &&
                    likes == other.likes &&
                    quotes == other.quotes &&
                    replies == other.replies &&
                    reposts == other.reposts &&
                    views == other.views &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    bookmarks,
                    likes,
                    quotes,
                    replies,
                    reposts,
                    views,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Metrics{bookmarks=$bookmarks, likes=$likes, quotes=$quotes, replies=$replies, reposts=$reposts, views=$views, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Insights &&
                ageHours == other.ageHours &&
                amplification == other.amplification &&
                authorId == other.authorId &&
                authorUserName == other.authorUserName &&
                conversation == other.conversation &&
                createdAt == other.createdAt &&
                engagementPerView == other.engagementPerView &&
                engagementRate == other.engagementRate &&
                engagements == other.engagements &&
                engagementsPerHour == other.engagementsPerHour &&
                metrics == other.metrics &&
                tweetId == other.tweetId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                ageHours,
                amplification,
                authorId,
                authorUserName,
                conversation,
                createdAt,
                engagementPerView,
                engagementRate,
                engagements,
                engagementsPerHour,
                metrics,
                tweetId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Insights{ageHours=$ageHours, amplification=$amplification, authorId=$authorId, authorUserName=$authorUserName, conversation=$conversation, createdAt=$createdAt, engagementPerView=$engagementPerView, engagementRate=$engagementRate, engagements=$engagements, engagementsPerHour=$engagementsPerHour, metrics=$metrics, tweetId=$tweetId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetGetInsightsResponse &&
            insights == other.insights &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(insights, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TweetGetInsightsResponse{insights=$insights, additionalProperties=$additionalProperties}"
}
