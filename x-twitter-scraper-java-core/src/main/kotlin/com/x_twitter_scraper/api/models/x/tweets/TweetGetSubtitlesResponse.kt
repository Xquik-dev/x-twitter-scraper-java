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
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TweetGetSubtitlesResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val subtitles: JsonField<Subtitles>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("subtitles")
        @ExcludeMissing
        subtitles: JsonField<Subtitles> = JsonMissing.of()
    ) : this(subtitles, mutableMapOf())

    /**
     * Holds the caption tracks of 1 tweet's videos.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun subtitles(): Subtitles = subtitles.getRequired("subtitles")

    /**
     * Returns the raw JSON value of [subtitles].
     *
     * Unlike [subtitles], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("subtitles") @ExcludeMissing fun _subtitles(): JsonField<Subtitles> = subtitles

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
         * Returns a mutable builder for constructing an instance of [TweetGetSubtitlesResponse].
         *
         * The following fields are required:
         * ```java
         * .subtitles()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetGetSubtitlesResponse]. */
    class Builder internal constructor() {

        private var subtitles: JsonField<Subtitles>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tweetGetSubtitlesResponse: TweetGetSubtitlesResponse) = apply {
            subtitles = tweetGetSubtitlesResponse.subtitles
            additionalProperties = tweetGetSubtitlesResponse.additionalProperties.toMutableMap()
        }

        /** Holds the caption tracks of 1 tweet's videos. */
        fun subtitles(subtitles: Subtitles) = subtitles(JsonField.of(subtitles))

        /** Sets [Builder.subtitles] to an arbitrary JSON value. */
        fun subtitles(subtitles: JsonField<Subtitles>) = apply { this.subtitles = subtitles }

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
         * Returns an immutable instance of [TweetGetSubtitlesResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .subtitles()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TweetGetSubtitlesResponse =
            TweetGetSubtitlesResponse(
                checkRequired("subtitles", subtitles),
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
    fun validate(): TweetGetSubtitlesResponse = apply {
        if (validated) {
            return@apply
        }

        subtitles().validate()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    @JvmSynthetic internal fun validity(): Int = (subtitles.asKnown().getOrNull()?.validity() ?: 0)

    /** Holds the caption tracks of 1 tweet's videos. */
    class Subtitles
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val tracks: JsonField<List<Track>>,
        private val tweetId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("tracks")
            @ExcludeMissing
            tracks: JsonField<List<Track>> = JsonMissing.of(),
            @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
        ) : this(tracks, tweetId, mutableMapOf())

        /**
         * Caption tracks, empty when no video has captions.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun tracks(): List<Track> = tracks.getRequired("tracks")

        /**
         * ID of the tweet.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun tweetId(): String = tweetId.getRequired("tweetId")

        /**
         * Returns the raw JSON value of [tracks].
         *
         * Unlike [tracks], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tracks") @ExcludeMissing fun _tracks(): JsonField<List<Track>> = tracks

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
             * Returns a mutable builder for constructing an instance of [Subtitles].
             *
             * The following fields are required:
             * ```java
             * .tracks()
             * .tweetId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Subtitles]. */
        class Builder internal constructor() {

            private var tracks: JsonField<MutableList<Track>>? = null
            private var tweetId: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(subtitles: Subtitles) = apply {
                tracks = subtitles.tracks.map { it.toMutableList() }
                tweetId = subtitles.tweetId
                additionalProperties = subtitles.additionalProperties.toMutableMap()
            }

            /** Caption tracks, empty when no video has captions. */
            fun tracks(tracks: List<Track>) = tracks(JsonField.of(tracks))

            /** Sets [Builder.tracks] to an arbitrary JSON value. */
            fun tracks(tracks: JsonField<List<Track>>) = apply {
                this.tracks = tracks.map { it.toMutableList() }
            }

            /**
             * Adds a single [Track] to [tracks].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTrack(track: Track) = apply {
                tracks =
                    (tracks ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tracks", it).add(track)
                    }
            }

            /** ID of the tweet. */
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
             * Returns an immutable instance of [Subtitles].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .tracks()
             * .tweetId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Subtitles =
                Subtitles(
                    checkRequired("tracks", tracks).map { it.toImmutable() },
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
        fun validate(): Subtitles = apply {
            if (validated) {
                return@apply
            }

            tracks().forEach { it.validate() }
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
            (tracks.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (tweetId.asKnown().isPresent) 1 else 0)

        /** Holds 1 caption track of a video. */
        class Track
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val autoGenerated: JsonField<Boolean>,
            private val cues: JsonField<List<Cue>>,
            private val text: JsonField<String>,
            private val truncated: JsonField<Boolean>,
            private val url: JsonField<String>,
            private val language: JsonField<String>,
            private val mediaKey: JsonField<String>,
            private val name: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("autoGenerated")
                @ExcludeMissing
                autoGenerated: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("cues") @ExcludeMissing cues: JsonField<List<Cue>> = JsonMissing.of(),
                @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
                @JsonProperty("truncated")
                @ExcludeMissing
                truncated: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                @JsonProperty("language")
                @ExcludeMissing
                language: JsonField<String> = JsonMissing.of(),
                @JsonProperty("mediaKey")
                @ExcludeMissing
                mediaKey: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            ) : this(
                autoGenerated,
                cues,
                text,
                truncated,
                url,
                language,
                mediaKey,
                name,
                mutableMapOf(),
            )

            /**
             * True when X transcribed the audio itself.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun autoGenerated(): Boolean = autoGenerated.getRequired("autoGenerated")

            /**
             * Timed captions in order.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun cues(): List<Cue> = cues.getRequired("cues")

            /**
             * Every cue's text in order, as 1 line.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun text(): String = text.getRequired("text")

            /**
             * True when the track holds more than 50 caption files. The cues then cover the
             * first 50.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun truncated(): Boolean = truncated.getRequired("truncated")

            /**
             * Link to the track's first WebVTT file.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
             *   or is unexpectedly missing or null.
             */
            fun url(): String = url.getRequired("url")

            /**
             * Language code of the track, in lower case.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun language(): Optional<String> = language.getOptional("language")

            /**
             * Media key of the video, as media rows carry it.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun mediaKey(): Optional<String> = mediaKey.getOptional("mediaKey")

            /**
             * Track name the uploader or X gave it.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Returns the raw JSON value of [autoGenerated].
             *
             * Unlike [autoGenerated], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("autoGenerated")
            @ExcludeMissing
            fun _autoGenerated(): JsonField<Boolean> = autoGenerated

            /**
             * Returns the raw JSON value of [cues].
             *
             * Unlike [cues], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("cues") @ExcludeMissing fun _cues(): JsonField<List<Cue>> = cues

            /**
             * Returns the raw JSON value of [text].
             *
             * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

            /**
             * Returns the raw JSON value of [truncated].
             *
             * Unlike [truncated], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("truncated")
            @ExcludeMissing
            fun _truncated(): JsonField<Boolean> = truncated

            /**
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

            /**
             * Returns the raw JSON value of [language].
             *
             * Unlike [language], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<String> = language

            /**
             * Returns the raw JSON value of [mediaKey].
             *
             * Unlike [mediaKey], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("mediaKey") @ExcludeMissing fun _mediaKey(): JsonField<String> = mediaKey

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
                 * Returns a mutable builder for constructing an instance of [Track].
                 *
                 * The following fields are required:
                 * ```java
                 * .autoGenerated()
                 * .cues()
                 * .text()
                 * .truncated()
                 * .url()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Track]. */
            class Builder internal constructor() {

                private var autoGenerated: JsonField<Boolean>? = null
                private var cues: JsonField<MutableList<Cue>>? = null
                private var text: JsonField<String>? = null
                private var truncated: JsonField<Boolean>? = null
                private var url: JsonField<String>? = null
                private var language: JsonField<String> = JsonMissing.of()
                private var mediaKey: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(track: Track) = apply {
                    autoGenerated = track.autoGenerated
                    cues = track.cues.map { it.toMutableList() }
                    text = track.text
                    truncated = track.truncated
                    url = track.url
                    language = track.language
                    mediaKey = track.mediaKey
                    name = track.name
                    additionalProperties = track.additionalProperties.toMutableMap()
                }

                /** True when X transcribed the audio itself. */
                fun autoGenerated(autoGenerated: Boolean) =
                    autoGenerated(JsonField.of(autoGenerated))

                /** Sets [Builder.autoGenerated] to an arbitrary JSON value. */
                fun autoGenerated(autoGenerated: JsonField<Boolean>) = apply {
                    this.autoGenerated = autoGenerated
                }

                /** Timed captions in order. */
                fun cues(cues: List<Cue>) = cues(JsonField.of(cues))

                /** Sets [Builder.cues] to an arbitrary JSON value. */
                fun cues(cues: JsonField<List<Cue>>) = apply {
                    this.cues = cues.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Cue] to [cues].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addCue(cue: Cue) = apply {
                    cues =
                        (cues ?: JsonField.of(mutableListOf())).also {
                            checkKnown("cues", it).add(cue)
                        }
                }

                /** Every cue's text in order, as 1 line. */
                fun text(text: String) = text(JsonField.of(text))

                /** Sets [Builder.text] to an arbitrary JSON value. */
                fun text(text: JsonField<String>) = apply { this.text = text }

                /**
                 * True when the track holds more than 50 caption files. The cues then cover the
                 * first 50.
                 */
                fun truncated(truncated: Boolean) = truncated(JsonField.of(truncated))

                /** Sets [Builder.truncated] to an arbitrary JSON value. */
                fun truncated(truncated: JsonField<Boolean>) = apply { this.truncated = truncated }

                /** Link to the track's first WebVTT file. */
                fun url(url: String) = url(JsonField.of(url))

                /** Sets [Builder.url] to an arbitrary JSON value. */
                fun url(url: JsonField<String>) = apply { this.url = url }

                /** Language code of the track, in lower case. */
                fun language(language: String) = language(JsonField.of(language))

                /** Sets [Builder.language] to an arbitrary JSON value. */
                fun language(language: JsonField<String>) = apply { this.language = language }

                /** Media key of the video, as media rows carry it. */
                fun mediaKey(mediaKey: String) = mediaKey(JsonField.of(mediaKey))

                /** Sets [Builder.mediaKey] to an arbitrary JSON value. */
                fun mediaKey(mediaKey: JsonField<String>) = apply { this.mediaKey = mediaKey }

                /** Track name the uploader or X gave it. */
                fun name(name: String) = name(JsonField.of(name))

                /** Sets [Builder.name] to an arbitrary JSON value. */
                fun name(name: JsonField<String>) = apply { this.name = name }

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
                 * Returns an immutable instance of [Track].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .autoGenerated()
                 * .cues()
                 * .text()
                 * .truncated()
                 * .url()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Track =
                    Track(
                        checkRequired("autoGenerated", autoGenerated),
                        checkRequired("cues", cues).map { it.toImmutable() },
                        checkRequired("text", text),
                        checkRequired("truncated", truncated),
                        checkRequired("url", url),
                        language,
                        mediaKey,
                        name,
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
            fun validate(): Track = apply {
                if (validated) {
                    return@apply
                }

                autoGenerated()
                cues().forEach { it.validate() }
                text()
                truncated()
                url()
                language()
                mediaKey()
                name()
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
                (if (autoGenerated.asKnown().isPresent) 1 else 0) +
                    (cues.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                    (if (text.asKnown().isPresent) 1 else 0) +
                    (if (truncated.asKnown().isPresent) 1 else 0) +
                    (if (url.asKnown().isPresent) 1 else 0) +
                    (if (language.asKnown().isPresent) 1 else 0) +
                    (if (mediaKey.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0)

            class Cue
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val endMs: JsonField<Long>,
                private val startMs: JsonField<Long>,
                private val text: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("endMs")
                    @ExcludeMissing
                    endMs: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("startMs")
                    @ExcludeMissing
                    startMs: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("text")
                    @ExcludeMissing
                    text: JsonField<String> = JsonMissing.of(),
                ) : this(endMs, startMs, text, mutableMapOf())

                /**
                 * End time in milliseconds.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun endMs(): Long = endMs.getRequired("endMs")

                /**
                 * Start time in milliseconds.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun startMs(): Long = startMs.getRequired("startMs")

                /**
                 * Caption text, with a line break between lines.
                 *
                 * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected
                 *   type or is unexpectedly missing or null.
                 */
                fun text(): String = text.getRequired("text")

                /**
                 * Returns the raw JSON value of [endMs].
                 *
                 * Unlike [endMs], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("endMs") @ExcludeMissing fun _endMs(): JsonField<Long> = endMs

                /**
                 * Returns the raw JSON value of [startMs].
                 *
                 * Unlike [startMs], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("startMs") @ExcludeMissing fun _startMs(): JsonField<Long> = startMs

                /**
                 * Returns the raw JSON value of [text].
                 *
                 * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                 * type.
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

                    /**
                     * Returns a mutable builder for constructing an instance of [Cue].
                     *
                     * The following fields are required:
                     * ```java
                     * .endMs()
                     * .startMs()
                     * .text()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Cue]. */
                class Builder internal constructor() {

                    private var endMs: JsonField<Long>? = null
                    private var startMs: JsonField<Long>? = null
                    private var text: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(cue: Cue) = apply {
                        endMs = cue.endMs
                        startMs = cue.startMs
                        text = cue.text
                        additionalProperties = cue.additionalProperties.toMutableMap()
                    }

                    /** End time in milliseconds. */
                    fun endMs(endMs: Long) = endMs(JsonField.of(endMs))

                    /** Sets [Builder.endMs] to an arbitrary JSON value. */
                    fun endMs(endMs: JsonField<Long>) = apply { this.endMs = endMs }

                    /** Start time in milliseconds. */
                    fun startMs(startMs: Long) = startMs(JsonField.of(startMs))

                    /** Sets [Builder.startMs] to an arbitrary JSON value. */
                    fun startMs(startMs: JsonField<Long>) = apply { this.startMs = startMs }

                    /** Caption text, with a line break between lines. */
                    fun text(text: String) = text(JsonField.of(text))

                    /** Sets [Builder.text] to an arbitrary JSON value. */
                    fun text(text: JsonField<String>) = apply { this.text = text }

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
                     * Returns an immutable instance of [Cue].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .endMs()
                     * .startMs()
                     * .text()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Cue =
                        Cue(
                            checkRequired("endMs", endMs),
                            checkRequired("startMs", startMs),
                            checkRequired("text", text),
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
                 * @throws XTwitterScraperInvalidDataException if any value type in this object
                 *   doesn't match its expected type.
                 */
                fun validate(): Cue = apply {
                    if (validated) {
                        return@apply
                    }

                    endMs()
                    startMs()
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

                @JvmSynthetic
                internal fun validity(): Int =
                    (if (endMs.asKnown().isPresent) 1 else 0) +
                        (if (startMs.asKnown().isPresent) 1 else 0) +
                        (if (text.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Cue &&
                        endMs == other.endMs &&
                        startMs == other.startMs &&
                        text == other.text &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(endMs, startMs, text, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Cue{endMs=$endMs, startMs=$startMs, text=$text, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Track &&
                    autoGenerated == other.autoGenerated &&
                    cues == other.cues &&
                    text == other.text &&
                    truncated == other.truncated &&
                    url == other.url &&
                    language == other.language &&
                    mediaKey == other.mediaKey &&
                    name == other.name &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    autoGenerated,
                    cues,
                    text,
                    truncated,
                    url,
                    language,
                    mediaKey,
                    name,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Track{autoGenerated=$autoGenerated, cues=$cues, text=$text, truncated=$truncated, url=$url, language=$language, mediaKey=$mediaKey, name=$name, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Subtitles &&
                tracks == other.tracks &&
                tweetId == other.tweetId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(tracks, tweetId, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Subtitles{tracks=$tracks, tweetId=$tweetId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetGetSubtitlesResponse &&
            subtitles == other.subtitles &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(subtitles, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TweetGetSubtitlesResponse{subtitles=$subtitles, additionalProperties=$additionalProperties}"
}
