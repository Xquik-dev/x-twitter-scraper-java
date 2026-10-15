// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.spaces

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

class SpaceRetrieveReplayResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val replay: JsonField<Replay>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("replay") @ExcludeMissing replay: JsonField<Replay> = JsonMissing.of()
    ) : this(replay, mutableMapOf())

    /**
     * Recording of an ended Space
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun replay(): Replay = replay.getRequired("replay")

    /**
     * Returns the raw JSON value of [replay].
     *
     * Unlike [replay], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("replay") @ExcludeMissing fun _replay(): JsonField<Replay> = replay

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
         * Returns a mutable builder for constructing an instance of [SpaceRetrieveReplayResponse].
         *
         * The following fields are required:
         * ```java
         * .replay()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SpaceRetrieveReplayResponse]. */
    class Builder internal constructor() {

        private var replay: JsonField<Replay>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(spaceRetrieveReplayResponse: SpaceRetrieveReplayResponse) = apply {
            replay = spaceRetrieveReplayResponse.replay
            additionalProperties = spaceRetrieveReplayResponse.additionalProperties.toMutableMap()
        }

        /** Recording of an ended Space */
        fun replay(replay: Replay) = replay(JsonField.of(replay))

        /** Sets [Builder.replay] to an arbitrary JSON value. */
        fun replay(replay: JsonField<Replay>) = apply { this.replay = replay }

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
         * Returns an immutable instance of [SpaceRetrieveReplayResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .replay()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SpaceRetrieveReplayResponse =
            SpaceRetrieveReplayResponse(
                checkRequired("replay", replay),
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
    fun validate(): SpaceRetrieveReplayResponse = apply {
        if (validated) {
            return@apply
        }

        replay().validate()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    @JvmSynthetic internal fun validity(): Int = (replay.asKnown().getOrNull()?.validity() ?: 0)

    /** Recording of an ended Space */
    class Replay
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val url: JsonField<String>,
        private val status: JsonField<String>,
        private val streamType: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
            @JsonProperty("streamType")
            @ExcludeMissing
            streamType: JsonField<String> = JsonMissing.of(),
        ) : this(url, status, streamType, mutableMapOf())

        /**
         * HLS playlist of the recording
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun url(): String = url.getRequired("url")

        /**
         * Stream status, as X names it
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun status(): Optional<String> = status.getOptional("status")

        /**
         * Stream format, as X names it
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun streamType(): Optional<String> = streamType.getOptional("streamType")

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

        /**
         * Returns the raw JSON value of [streamType].
         *
         * Unlike [streamType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("streamType")
        @ExcludeMissing
        fun _streamType(): JsonField<String> = streamType

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
             * Returns a mutable builder for constructing an instance of [Replay].
             *
             * The following fields are required:
             * ```java
             * .url()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Replay]. */
        class Builder internal constructor() {

            private var url: JsonField<String>? = null
            private var status: JsonField<String> = JsonMissing.of()
            private var streamType: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(replay: Replay) = apply {
                url = replay.url
                status = replay.status
                streamType = replay.streamType
                additionalProperties = replay.additionalProperties.toMutableMap()
            }

            /** HLS playlist of the recording */
            fun url(url: String) = url(JsonField.of(url))

            /** Sets [Builder.url] to an arbitrary JSON value. */
            fun url(url: JsonField<String>) = apply { this.url = url }

            /** Stream status, as X names it */
            fun status(status: String) = status(JsonField.of(status))

            /** Sets [Builder.status] to an arbitrary JSON value. */
            fun status(status: JsonField<String>) = apply { this.status = status }

            /** Stream format, as X names it */
            fun streamType(streamType: String) = streamType(JsonField.of(streamType))

            /** Sets [Builder.streamType] to an arbitrary JSON value. */
            fun streamType(streamType: JsonField<String>) = apply { this.streamType = streamType }

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
             * Returns an immutable instance of [Replay].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .url()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Replay =
                Replay(
                    checkRequired("url", url),
                    status,
                    streamType,
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
        fun validate(): Replay = apply {
            if (validated) {
                return@apply
            }

            url()
            status()
            streamType()
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
            (if (url.asKnown().isPresent) 1 else 0) +
                (if (status.asKnown().isPresent) 1 else 0) +
                (if (streamType.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Replay &&
                url == other.url &&
                status == other.status &&
                streamType == other.streamType &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(url, status, streamType, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Replay{url=$url, status=$status, streamType=$streamType, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SpaceRetrieveReplayResponse &&
            replay == other.replay &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(replay, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SpaceRetrieveReplayResponse{replay=$replay, additionalProperties=$additionalProperties}"
}
