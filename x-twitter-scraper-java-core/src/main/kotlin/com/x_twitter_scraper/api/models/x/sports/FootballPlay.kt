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

/** A play, with its situation, steps & linked posts. */
class FootballPlay
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val sequence: JsonField<Long>,
    private val clock: JsonField<String>,
    private val type: JsonField<String>,
    private val direction: JsonField<String>,
    private val description: JsonField<String>,
    private val scoring: JsonField<Boolean>,
    private val homePoints: JsonField<Long>,
    private val awayPoints: JsonField<Long>,
    private val score: JsonField<FootballPlayScore>,
    private val start: JsonField<FootballPlayStart>,
    private val onField: JsonField<FootballPlayOnField>,
    private val details: JsonField<List<FootballPlayDetail>>,
    private val post: JsonField<FootballPlayPost>,
    private val videoPostId: JsonField<String>,
    private val videoReplyPostId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sequence") @ExcludeMissing sequence: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("clock") @ExcludeMissing clock: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("direction") @ExcludeMissing direction: JsonField<String> = JsonMissing.of(),
        @JsonProperty("description") @ExcludeMissing description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("scoring") @ExcludeMissing scoring: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("homePoints") @ExcludeMissing homePoints: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("awayPoints") @ExcludeMissing awayPoints: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("score") @ExcludeMissing score: JsonField<FootballPlayScore> = JsonMissing.of(),
        @JsonProperty("start") @ExcludeMissing start: JsonField<FootballPlayStart> = JsonMissing.of(),
        @JsonProperty("onField") @ExcludeMissing onField: JsonField<FootballPlayOnField> = JsonMissing.of(),
        @JsonProperty("details") @ExcludeMissing details: JsonField<List<FootballPlayDetail>> = JsonMissing.of(),
        @JsonProperty("post") @ExcludeMissing post: JsonField<FootballPlayPost> = JsonMissing.of(),
        @JsonProperty("videoPostId") @ExcludeMissing videoPostId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("videoReplyPostId") @ExcludeMissing videoReplyPostId: JsonField<String> = JsonMissing.of(),
    ) : this(id, sequence, clock, type, direction, description, scoring, homePoints, awayPoints, score, start, onField, details, post, videoPostId, videoReplyPostId, mutableMapOf())

    /** X's ID for the play within the game. */
    fun id(): Optional<String> = id.getOptional("id")

    /** The play's place in its drive, or null when X sends no digits. */
    fun sequence(): Optional<Long> = sequence.getOptional("sequence")

    /** The game clock when the play started, as HH:MM:SS. */
    fun clock(): Optional<String> = clock.getOptional("clock")

    /** X's kind of play, such as Pass, Rush, Punt or Conversion. */
    fun type(): Optional<String> = type.getOptional("type")

    /** Where the play went, such as Left or Middle. */
    fun direction(): Optional<String> = direction.getOptional("direction")

    /** The play as the official play-by-play writes it. */
    fun description(): Optional<String> = description.getOptional("description")

    /** Whether the play scored points. */
    fun scoring(): Optional<Boolean> = scoring.getOptional("scoring")

    /** The home team's points after the play. */
    fun homePoints(): Optional<Long> = homePoints.getOptional("homePoints")

    /** The away team's points after the play. */
    fun awayPoints(): Optional<Long> = awayPoints.getOptional("awayPoints")

    /** The points a scoring play added, or null. */
    fun score(): Optional<FootballPlayScore> = score.getOptional("score")

    /** Down & distance when the play started, or null. */
    fun start(): Optional<FootballPlayStart> = start.getOptional("start")

    /** Flags X shows on the field for the play, or null. */
    fun onField(): Optional<FootballPlayOnField> = onField.getOptional("onField")

    /** The play's steps, in order. */
    fun details(): List<FootballPlayDetail> = details.getRequired("details")

    /** The post X links to the play, or null. */
    fun post(): Optional<FootballPlayPost> = post.getOptional("post")

    /** The ID of a post with the play's video. */
    fun videoPostId(): Optional<String> = videoPostId.getOptional("videoPostId")

    /** The ID of a reply with the play's video. */
    fun videoReplyPostId(): Optional<String> = videoReplyPostId.getOptional("videoReplyPostId")

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Returns the raw JSON value of [sequence]. */
    @JsonProperty("sequence") @ExcludeMissing fun _sequence(): JsonField<Long> = sequence

    /** Returns the raw JSON value of [clock]. */
    @JsonProperty("clock") @ExcludeMissing fun _clock(): JsonField<String> = clock

    /** Returns the raw JSON value of [type]. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

    /** Returns the raw JSON value of [direction]. */
    @JsonProperty("direction") @ExcludeMissing fun _direction(): JsonField<String> = direction

    /** Returns the raw JSON value of [description]. */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /** Returns the raw JSON value of [scoring]. */
    @JsonProperty("scoring") @ExcludeMissing fun _scoring(): JsonField<Boolean> = scoring

    /** Returns the raw JSON value of [homePoints]. */
    @JsonProperty("homePoints") @ExcludeMissing fun _homePoints(): JsonField<Long> = homePoints

    /** Returns the raw JSON value of [awayPoints]. */
    @JsonProperty("awayPoints") @ExcludeMissing fun _awayPoints(): JsonField<Long> = awayPoints

    /** Returns the raw JSON value of [score]. */
    @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<FootballPlayScore> = score

    /** Returns the raw JSON value of [start]. */
    @JsonProperty("start") @ExcludeMissing fun _start(): JsonField<FootballPlayStart> = start

    /** Returns the raw JSON value of [onField]. */
    @JsonProperty("onField") @ExcludeMissing fun _onField(): JsonField<FootballPlayOnField> = onField

    /** Returns the raw JSON value of [details]. */
    @JsonProperty("details") @ExcludeMissing fun _details(): JsonField<List<FootballPlayDetail>> = details

    /** Returns the raw JSON value of [post]. */
    @JsonProperty("post") @ExcludeMissing fun _post(): JsonField<FootballPlayPost> = post

    /** Returns the raw JSON value of [videoPostId]. */
    @JsonProperty("videoPostId") @ExcludeMissing fun _videoPostId(): JsonField<String> = videoPostId

    /** Returns the raw JSON value of [videoReplyPostId]. */
    @JsonProperty("videoReplyPostId") @ExcludeMissing fun _videoReplyPostId(): JsonField<String> = videoReplyPostId

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

        /** Returns a mutable builder for constructing an instance of [FootballPlay]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FootballPlay]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var sequence: JsonField<Long>? = null
        private var clock: JsonField<String>? = null
        private var type: JsonField<String>? = null
        private var direction: JsonField<String>? = null
        private var description: JsonField<String>? = null
        private var scoring: JsonField<Boolean>? = null
        private var homePoints: JsonField<Long>? = null
        private var awayPoints: JsonField<Long>? = null
        private var score: JsonField<FootballPlayScore>? = null
        private var start: JsonField<FootballPlayStart>? = null
        private var onField: JsonField<FootballPlayOnField>? = null
        private var details: JsonField<MutableList<FootballPlayDetail>>? = null
        private var post: JsonField<FootballPlayPost>? = null
        private var videoPostId: JsonField<String>? = null
        private var videoReplyPostId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic internal fun from(footballPlay: FootballPlay) = apply {
            id = footballPlay.id
            sequence = footballPlay.sequence
            clock = footballPlay.clock
            type = footballPlay.type
            direction = footballPlay.direction
            description = footballPlay.description
            scoring = footballPlay.scoring
            homePoints = footballPlay.homePoints
            awayPoints = footballPlay.awayPoints
            score = footballPlay.score
            start = footballPlay.start
            onField = footballPlay.onField
            details = footballPlay.details.map { it.toMutableList() }
            post = footballPlay.post
            videoPostId = footballPlay.videoPostId
            videoReplyPostId = footballPlay.videoReplyPostId
            additionalProperties = footballPlay.additionalProperties.toMutableMap()
        }

        /** X's ID for the play within the game. */
        fun id(id: String?) = id(JsonField.ofNullable(id))

        fun id(id: Optional<String>) = id(id.getOrNull())

        /** Sets [Builder.id] to an arbitrary JSON value. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The play's place in its drive, or null when X sends no digits. */
        fun sequence(sequence: Long?) = sequence(JsonField.ofNullable(sequence))

        fun sequence(sequence: Long) = sequence(sequence as Long?)

        fun sequence(sequence: Optional<Long>) = sequence(sequence.getOrNull())

        /** Sets [Builder.sequence] to an arbitrary JSON value. */
        fun sequence(sequence: JsonField<Long>) = apply { this.sequence = sequence }

        /** The game clock when the play started, as HH:MM:SS. */
        fun clock(clock: String?) = clock(JsonField.ofNullable(clock))

        fun clock(clock: Optional<String>) = clock(clock.getOrNull())

        /** Sets [Builder.clock] to an arbitrary JSON value. */
        fun clock(clock: JsonField<String>) = apply { this.clock = clock }

        /** X's kind of play, such as Pass, Rush, Punt or Conversion. */
        fun type(type: String?) = type(JsonField.ofNullable(type))

        fun type(type: Optional<String>) = type(type.getOrNull())

        /** Sets [Builder.type] to an arbitrary JSON value. */
        fun type(type: JsonField<String>) = apply { this.type = type }

        /** Where the play went, such as Left or Middle. */
        fun direction(direction: String?) = direction(JsonField.ofNullable(direction))

        fun direction(direction: Optional<String>) = direction(direction.getOrNull())

        /** Sets [Builder.direction] to an arbitrary JSON value. */
        fun direction(direction: JsonField<String>) = apply { this.direction = direction }

        /** The play as the official play-by-play writes it. */
        fun description(description: String?) = description(JsonField.ofNullable(description))

        fun description(description: Optional<String>) = description(description.getOrNull())

        /** Sets [Builder.description] to an arbitrary JSON value. */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** Whether the play scored points. */
        fun scoring(scoring: Boolean?) = scoring(JsonField.ofNullable(scoring))

        fun scoring(scoring: Boolean) = scoring(scoring as Boolean?)

        fun scoring(scoring: Optional<Boolean>) = scoring(scoring.getOrNull())

        /** Sets [Builder.scoring] to an arbitrary JSON value. */
        fun scoring(scoring: JsonField<Boolean>) = apply { this.scoring = scoring }

        /** The home team's points after the play. */
        fun homePoints(homePoints: Long?) = homePoints(JsonField.ofNullable(homePoints))

        fun homePoints(homePoints: Long) = homePoints(homePoints as Long?)

        fun homePoints(homePoints: Optional<Long>) = homePoints(homePoints.getOrNull())

        /** Sets [Builder.homePoints] to an arbitrary JSON value. */
        fun homePoints(homePoints: JsonField<Long>) = apply { this.homePoints = homePoints }

        /** The away team's points after the play. */
        fun awayPoints(awayPoints: Long?) = awayPoints(JsonField.ofNullable(awayPoints))

        fun awayPoints(awayPoints: Long) = awayPoints(awayPoints as Long?)

        fun awayPoints(awayPoints: Optional<Long>) = awayPoints(awayPoints.getOrNull())

        /** Sets [Builder.awayPoints] to an arbitrary JSON value. */
        fun awayPoints(awayPoints: JsonField<Long>) = apply { this.awayPoints = awayPoints }

        /** The points a scoring play added, or null. */
        fun score(score: FootballPlayScore?) = score(JsonField.ofNullable(score))

        fun score(score: Optional<FootballPlayScore>) = score(score.getOrNull())

        /** Sets [Builder.score] to an arbitrary JSON value. */
        fun score(score: JsonField<FootballPlayScore>) = apply { this.score = score }

        /** Down & distance when the play started, or null. */
        fun start(start: FootballPlayStart?) = start(JsonField.ofNullable(start))

        fun start(start: Optional<FootballPlayStart>) = start(start.getOrNull())

        /** Sets [Builder.start] to an arbitrary JSON value. */
        fun start(start: JsonField<FootballPlayStart>) = apply { this.start = start }

        /** Flags X shows on the field for the play, or null. */
        fun onField(onField: FootballPlayOnField?) = onField(JsonField.ofNullable(onField))

        fun onField(onField: Optional<FootballPlayOnField>) = onField(onField.getOrNull())

        /** Sets [Builder.onField] to an arbitrary JSON value. */
        fun onField(onField: JsonField<FootballPlayOnField>) = apply { this.onField = onField }

        /** The play's steps, in order. */
        fun details(details: List<FootballPlayDetail>) = details(JsonField.of(details))

        /** Sets [Builder.details] to an arbitrary JSON value. */
        fun details(details: JsonField<List<FootballPlayDetail>>) = apply { this.details = details.map { it.toMutableList() } }

        /** Adds a single [FootballPlayDetail] to [details]. */
        fun addDetail(detail: FootballPlayDetail) = apply {
            details =
                (details ?: JsonField.of(mutableListOf())).also {
                    checkKnown("details", it).add(detail)
                }
        }

        /** The post X links to the play, or null. */
        fun post(post: FootballPlayPost?) = post(JsonField.ofNullable(post))

        fun post(post: Optional<FootballPlayPost>) = post(post.getOrNull())

        /** Sets [Builder.post] to an arbitrary JSON value. */
        fun post(post: JsonField<FootballPlayPost>) = apply { this.post = post }

        /** The ID of a post with the play's video. */
        fun videoPostId(videoPostId: String?) = videoPostId(JsonField.ofNullable(videoPostId))

        fun videoPostId(videoPostId: Optional<String>) = videoPostId(videoPostId.getOrNull())

        /** Sets [Builder.videoPostId] to an arbitrary JSON value. */
        fun videoPostId(videoPostId: JsonField<String>) = apply { this.videoPostId = videoPostId }

        /** The ID of a reply with the play's video. */
        fun videoReplyPostId(videoReplyPostId: String?) = videoReplyPostId(JsonField.ofNullable(videoReplyPostId))

        fun videoReplyPostId(videoReplyPostId: Optional<String>) = videoReplyPostId(videoReplyPostId.getOrNull())

        /** Sets [Builder.videoReplyPostId] to an arbitrary JSON value. */
        fun videoReplyPostId(videoReplyPostId: JsonField<String>) = apply { this.videoReplyPostId = videoReplyPostId }

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
         * Returns an immutable instance of [FootballPlay].
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FootballPlay =
            FootballPlay(
                checkRequired("id", id),
                checkRequired("sequence", sequence),
                checkRequired("clock", clock),
                checkRequired("type", type),
                checkRequired("direction", direction),
                checkRequired("description", description),
                checkRequired("scoring", scoring),
                checkRequired("homePoints", homePoints),
                checkRequired("awayPoints", awayPoints),
                checkRequired("score", score),
                checkRequired("start", start),
                checkRequired("onField", onField),
                checkRequired("details", details).map { it.toImmutable() },
                checkRequired("post", post),
                checkRequired("videoPostId", videoPostId),
                checkRequired("videoReplyPostId", videoReplyPostId),
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
    fun validate(): FootballPlay = apply {
        if (validated) {
            return@apply
        }

        id()
        sequence()
        clock()
        type()
        direction()
        description()
        scoring()
        homePoints()
        awayPoints()
        score().ifPresent { it.validate() }
        start().ifPresent { it.validate() }
        onField().ifPresent { it.validate() }
        details().forEach { it.validate() }
        post().ifPresent { it.validate() }
        videoPostId()
        videoReplyPostId()
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
            (if (sequence.asKnown().isPresent) 1 else 0) +
            (if (clock.asKnown().isPresent) 1 else 0) +
            (if (type.asKnown().isPresent) 1 else 0) +
            (if (direction.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (scoring.asKnown().isPresent) 1 else 0) +
            (if (homePoints.asKnown().isPresent) 1 else 0) +
            (if (awayPoints.asKnown().isPresent) 1 else 0) +
            (score.asKnown().getOrNull()?.validity() ?: 0) +
            (start.asKnown().getOrNull()?.validity() ?: 0) +
            (onField.asKnown().getOrNull()?.validity() ?: 0) +
            (details.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (post.asKnown().getOrNull()?.validity() ?: 0) +
            (if (videoPostId.asKnown().isPresent) 1 else 0) +
            (if (videoReplyPostId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FootballPlay &&
            id == other.id &&
            sequence == other.sequence &&
            clock == other.clock &&
            type == other.type &&
            direction == other.direction &&
            description == other.description &&
            scoring == other.scoring &&
            homePoints == other.homePoints &&
            awayPoints == other.awayPoints &&
            score == other.score &&
            start == other.start &&
            onField == other.onField &&
            details == other.details &&
            post == other.post &&
            videoPostId == other.videoPostId &&
            videoReplyPostId == other.videoReplyPostId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, sequence, clock, type, direction, description, scoring, homePoints, awayPoints, score, start, onField, details, post, videoPostId, videoReplyPostId, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FootballPlay{id=$id, sequence=$sequence, clock=$clock, type=$type, direction=$direction, description=$description, scoring=$scoring, homePoints=$homePoints, awayPoints=$awayPoints, score=$score, start=$start, onField=$onField, details=$details, post=$post, videoPostId=$videoPostId, videoReplyPostId=$videoReplyPostId, additionalProperties=$additionalProperties}"
}
