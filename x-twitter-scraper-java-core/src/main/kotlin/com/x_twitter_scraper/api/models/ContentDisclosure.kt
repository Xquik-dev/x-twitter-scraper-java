// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Content disclosure metadata shown by X when a tweet is labeled as paid partnership content or
 * AI-generated media.
 */
class ContentDisclosure
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val advertising: JsonField<Advertising>,
    private val aiGenerated: JsonField<AiGenerated>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("advertising")
        @ExcludeMissing
        advertising: JsonField<Advertising> = JsonMissing.of(),
        @JsonProperty("aiGenerated")
        @ExcludeMissing
        aiGenerated: JsonField<AiGenerated> = JsonMissing.of(),
    ) : this(advertising, aiGenerated, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun advertising(): Optional<Advertising> = advertising.getOptional("advertising")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun aiGenerated(): Optional<AiGenerated> = aiGenerated.getOptional("aiGenerated")

    /**
     * Returns the raw JSON value of [advertising].
     *
     * Unlike [advertising], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("advertising")
    @ExcludeMissing
    fun _advertising(): JsonField<Advertising> = advertising

    /**
     * Returns the raw JSON value of [aiGenerated].
     *
     * Unlike [aiGenerated], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("aiGenerated")
    @ExcludeMissing
    fun _aiGenerated(): JsonField<AiGenerated> = aiGenerated

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

        /** Returns a mutable builder for constructing an instance of [ContentDisclosure]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContentDisclosure]. */
    class Builder internal constructor() {

        private var advertising: JsonField<Advertising> = JsonMissing.of()
        private var aiGenerated: JsonField<AiGenerated> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(contentDisclosure: ContentDisclosure) = apply {
            advertising = contentDisclosure.advertising
            aiGenerated = contentDisclosure.aiGenerated
            additionalProperties = contentDisclosure.additionalProperties.toMutableMap()
        }

        fun advertising(advertising: Advertising) = advertising(JsonField.of(advertising))

        /**
         * Sets [Builder.advertising] to an arbitrary JSON value.
         *
         * You should usually call [Builder.advertising] with a well-typed [Advertising] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun advertising(advertising: JsonField<Advertising>) = apply {
            this.advertising = advertising
        }

        fun aiGenerated(aiGenerated: AiGenerated) = aiGenerated(JsonField.of(aiGenerated))

        /**
         * Sets [Builder.aiGenerated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aiGenerated] with a well-typed [AiGenerated] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun aiGenerated(aiGenerated: JsonField<AiGenerated>) = apply {
            this.aiGenerated = aiGenerated
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
         * Returns an immutable instance of [ContentDisclosure].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ContentDisclosure =
            ContentDisclosure(advertising, aiGenerated, additionalProperties.toMutableMap())
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
    fun validate(): ContentDisclosure = apply {
        if (validated) {
            return@apply
        }

        advertising().ifPresent { it.validate() }
        aiGenerated().ifPresent { it.validate() }
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
        (advertising.asKnown().getOrNull()?.validity() ?: 0) +
            (aiGenerated.asKnown().getOrNull()?.validity() ?: 0)

    class Advertising
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val isPaidPromotion: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("isPaidPromotion")
            @ExcludeMissing
            isPaidPromotion: JsonField<Boolean> = JsonMissing.of()
        ) : this(isPaidPromotion, mutableMapOf())

        /**
         * True when X labels the tweet as paid promotion content.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun isPaidPromotion(): Optional<Boolean> = isPaidPromotion.getOptional("isPaidPromotion")

        /**
         * Returns the raw JSON value of [isPaidPromotion].
         *
         * Unlike [isPaidPromotion], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("isPaidPromotion")
        @ExcludeMissing
        fun _isPaidPromotion(): JsonField<Boolean> = isPaidPromotion

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

            /** Returns a mutable builder for constructing an instance of [Advertising]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Advertising]. */
        class Builder internal constructor() {

            private var isPaidPromotion: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(advertising: Advertising) = apply {
                isPaidPromotion = advertising.isPaidPromotion
                additionalProperties = advertising.additionalProperties.toMutableMap()
            }

            /** True when X labels the tweet as paid promotion content. */
            fun isPaidPromotion(isPaidPromotion: Boolean) =
                isPaidPromotion(JsonField.of(isPaidPromotion))

            /**
             * Sets [Builder.isPaidPromotion] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isPaidPromotion] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isPaidPromotion(isPaidPromotion: JsonField<Boolean>) = apply {
                this.isPaidPromotion = isPaidPromotion
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
             * Returns an immutable instance of [Advertising].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Advertising =
                Advertising(isPaidPromotion, additionalProperties.toMutableMap())
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
        fun validate(): Advertising = apply {
            if (validated) {
                return@apply
            }

            isPaidPromotion()
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
        internal fun validity(): Int = (if (isPaidPromotion.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Advertising &&
                isPaidPromotion == other.isPaidPromotion &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(isPaidPromotion, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Advertising{isPaidPromotion=$isPaidPromotion, additionalProperties=$additionalProperties}"
    }

    class AiGenerated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val canEdit: JsonField<Boolean>,
        private val detectionSource: JsonField<String>,
        private val hasAiGeneratedMedia: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("canEdit") @ExcludeMissing canEdit: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("detectionSource")
            @ExcludeMissing
            detectionSource: JsonField<String> = JsonMissing.of(),
            @JsonProperty("hasAiGeneratedMedia")
            @ExcludeMissing
            hasAiGeneratedMedia: JsonField<Boolean> = JsonMissing.of(),
        ) : this(canEdit, detectionSource, hasAiGeneratedMedia, mutableMapOf())

        /**
         * Whether the disclosure can be edited on X.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun canEdit(): Optional<Boolean> = canEdit.getOptional("canEdit")

        /**
         * Source of the AI-generated media disclosure.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun detectionSource(): Optional<String> = detectionSource.getOptional("detectionSource")

        /**
         * True when X labels the tweet as containing AI-generated media.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun hasAiGeneratedMedia(): Optional<Boolean> =
            hasAiGeneratedMedia.getOptional("hasAiGeneratedMedia")

        /**
         * Returns the raw JSON value of [canEdit].
         *
         * Unlike [canEdit], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("canEdit") @ExcludeMissing fun _canEdit(): JsonField<Boolean> = canEdit

        /**
         * Returns the raw JSON value of [detectionSource].
         *
         * Unlike [detectionSource], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("detectionSource")
        @ExcludeMissing
        fun _detectionSource(): JsonField<String> = detectionSource

        /**
         * Returns the raw JSON value of [hasAiGeneratedMedia].
         *
         * Unlike [hasAiGeneratedMedia], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("hasAiGeneratedMedia")
        @ExcludeMissing
        fun _hasAiGeneratedMedia(): JsonField<Boolean> = hasAiGeneratedMedia

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

            /** Returns a mutable builder for constructing an instance of [AiGenerated]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AiGenerated]. */
        class Builder internal constructor() {

            private var canEdit: JsonField<Boolean> = JsonMissing.of()
            private var detectionSource: JsonField<String> = JsonMissing.of()
            private var hasAiGeneratedMedia: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(aiGenerated: AiGenerated) = apply {
                canEdit = aiGenerated.canEdit
                detectionSource = aiGenerated.detectionSource
                hasAiGeneratedMedia = aiGenerated.hasAiGeneratedMedia
                additionalProperties = aiGenerated.additionalProperties.toMutableMap()
            }

            /** Whether the disclosure can be edited on X. */
            fun canEdit(canEdit: Boolean) = canEdit(JsonField.of(canEdit))

            /**
             * Sets [Builder.canEdit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.canEdit] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun canEdit(canEdit: JsonField<Boolean>) = apply { this.canEdit = canEdit }

            /** Source of the AI-generated media disclosure. */
            fun detectionSource(detectionSource: String) =
                detectionSource(JsonField.of(detectionSource))

            /**
             * Sets [Builder.detectionSource] to an arbitrary JSON value.
             *
             * You should usually call [Builder.detectionSource] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun detectionSource(detectionSource: JsonField<String>) = apply {
                this.detectionSource = detectionSource
            }

            /** True when X labels the tweet as containing AI-generated media. */
            fun hasAiGeneratedMedia(hasAiGeneratedMedia: Boolean) =
                hasAiGeneratedMedia(JsonField.of(hasAiGeneratedMedia))

            /**
             * Sets [Builder.hasAiGeneratedMedia] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasAiGeneratedMedia] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun hasAiGeneratedMedia(hasAiGeneratedMedia: JsonField<Boolean>) = apply {
                this.hasAiGeneratedMedia = hasAiGeneratedMedia
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
             * Returns an immutable instance of [AiGenerated].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): AiGenerated =
                AiGenerated(
                    canEdit,
                    detectionSource,
                    hasAiGeneratedMedia,
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
        fun validate(): AiGenerated = apply {
            if (validated) {
                return@apply
            }

            canEdit()
            detectionSource()
            hasAiGeneratedMedia()
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
            (if (canEdit.asKnown().isPresent) 1 else 0) +
                (if (detectionSource.asKnown().isPresent) 1 else 0) +
                (if (hasAiGeneratedMedia.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AiGenerated &&
                canEdit == other.canEdit &&
                detectionSource == other.detectionSource &&
                hasAiGeneratedMedia == other.hasAiGeneratedMedia &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(canEdit, detectionSource, hasAiGeneratedMedia, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AiGenerated{canEdit=$canEdit, detectionSource=$detectionSource, hasAiGeneratedMedia=$hasAiGeneratedMedia, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContentDisclosure &&
            advertising == other.advertising &&
            aiGenerated == other.aiGenerated &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(advertising, aiGenerated, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContentDisclosure{advertising=$advertising, aiGenerated=$aiGenerated, additionalProperties=$additionalProperties}"
}
