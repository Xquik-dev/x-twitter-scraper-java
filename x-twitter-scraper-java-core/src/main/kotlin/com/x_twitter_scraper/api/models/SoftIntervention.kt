// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models

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
import com.x_twitter_scraper.api.models.SearchTweet.Interstitial.Text.Entity
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The label X shows under a post whose reach it limits. It links to the page that explains it. */
class SoftIntervention
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val displayType: JsonField<String>,
    private val engagementNudge: JsonField<Boolean>,
    private val text: JsonField<Text>,
    private val url: JsonField<Url>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("displayType")
        @ExcludeMissing
        displayType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("engagementNudge")
        @ExcludeMissing
        engagementNudge: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<Text> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<Url> = JsonMissing.of(),
    ) : this(displayType, engagementNudge, text, url, mutableMapOf())

    /**
     * The label's kind. `Fosnr` marks a post X keeps up but shows to fewer people.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun displayType(): Optional<String> = displayType.getOptional("displayType")

    /**
     * Whether X prompts readers before they engage with the post.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun engagementNudge(): Optional<Boolean> = engagementNudge.getOptional("engagementNudge")

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun text(): Optional<Text> = text.getOptional("text")

    /**
     * The page that explains the label.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun url(): Optional<Url> = url.getOptional("url")

    /**
     * Returns the raw JSON value of [displayType].
     *
     * Unlike [displayType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("displayType") @ExcludeMissing fun _displayType(): JsonField<String> = displayType

    /**
     * Returns the raw JSON value of [engagementNudge].
     *
     * Unlike [engagementNudge], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("engagementNudge")
    @ExcludeMissing
    fun _engagementNudge(): JsonField<Boolean> = engagementNudge

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<Text> = text

    /**
     * Returns the raw JSON value of [url].
     *
     * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<Url> = url

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

        /** Returns a mutable builder for constructing an instance of [SoftIntervention]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SoftIntervention]. */
    class Builder internal constructor() {

        private var displayType: JsonField<String> = JsonMissing.of()
        private var engagementNudge: JsonField<Boolean> = JsonMissing.of()
        private var text: JsonField<Text> = JsonMissing.of()
        private var url: JsonField<Url> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(softIntervention: SoftIntervention) = apply {
            displayType = softIntervention.displayType
            engagementNudge = softIntervention.engagementNudge
            text = softIntervention.text
            url = softIntervention.url
            additionalProperties = softIntervention.additionalProperties.toMutableMap()
        }

        /** The label's kind. `Fosnr` marks a post X keeps up but shows to fewer people. */
        fun displayType(displayType: String) = displayType(JsonField.of(displayType))

        /** Sets [Builder.displayType] to an arbitrary JSON value. */
        fun displayType(displayType: JsonField<String>) = apply { this.displayType = displayType }

        /** Whether X prompts readers before they engage with the post. */
        fun engagementNudge(engagementNudge: Boolean) =
            engagementNudge(JsonField.of(engagementNudge))

        /** Sets [Builder.engagementNudge] to an arbitrary JSON value. */
        fun engagementNudge(engagementNudge: JsonField<Boolean>) = apply {
            this.engagementNudge = engagementNudge
        }

        fun text(text: Text) = text(JsonField.of(text))

        /** Sets [Builder.text] to an arbitrary JSON value. */
        fun text(text: JsonField<Text>) = apply { this.text = text }

        /** The page that explains the label. */
        fun url(url: Url) = url(JsonField.of(url))

        /** Sets [Builder.url] to an arbitrary JSON value. */
        fun url(url: JsonField<Url>) = apply { this.url = url }

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
         * Returns an immutable instance of [SoftIntervention].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SoftIntervention =
            SoftIntervention(
                displayType,
                engagementNudge,
                text,
                url,
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
    fun validate(): SoftIntervention = apply {
        if (validated) {
            return@apply
        }

        displayType()
        engagementNudge()
        text().ifPresent { it.validate() }
        url().ifPresent { it.validate() }
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
        (if (displayType.asKnown().isPresent) 1 else 0) +
            (if (engagementNudge.asKnown().isPresent) 1 else 0) +
            (text.asKnown().getOrNull()?.validity() ?: 0) +
            (url.asKnown().getOrNull()?.validity() ?: 0)

    class Text
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val entities: JsonField<List<Entity>>,
        private val rtl: JsonField<Boolean>,
        private val text: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("entities")
            @ExcludeMissing
            entities: JsonField<List<Entity>> = JsonMissing.of(),
            @JsonProperty("rtl") @ExcludeMissing rtl: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        ) : this(entities, rtl, text, mutableMapOf())

        /**
         * Links inside the label, by character range.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun entities(): Optional<List<Entity>> = entities.getOptional("entities")

        /**
         * Whether the label reads right to left.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun rtl(): Optional<Boolean> = rtl.getOptional("rtl")

        /**
         * The label's text.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun text(): Optional<String> = text.getOptional("text")

        /**
         * Returns the raw JSON value of [entities].
         *
         * Unlike [entities], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("entities")
        @ExcludeMissing
        fun _entities(): JsonField<List<Entity>> = entities

        /**
         * Returns the raw JSON value of [rtl].
         *
         * Unlike [rtl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rtl") @ExcludeMissing fun _rtl(): JsonField<Boolean> = rtl

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

            /** Returns a mutable builder for constructing an instance of [Text]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Text]. */
        class Builder internal constructor() {

            private var entities: JsonField<MutableList<Entity>>? = null
            private var rtl: JsonField<Boolean> = JsonMissing.of()
            private var text: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(text: Text) = apply {
                entities = text.entities.map { it.toMutableList() }
                rtl = text.rtl
                this.text = text.text
                additionalProperties = text.additionalProperties.toMutableMap()
            }

            /** Links inside the label, by character range. */
            fun entities(entities: List<Entity>) = entities(JsonField.of(entities))

            /** Sets [Builder.entities] to an arbitrary JSON value. */
            fun entities(entities: JsonField<List<Entity>>) = apply {
                this.entities = entities.map { it.toMutableList() }
            }

            /**
             * Adds a single [Entity] to [entities].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addEntity(entity: Entity) = apply {
                entities =
                    (entities ?: JsonField.of(mutableListOf())).also {
                        checkKnown("entities", it).add(entity)
                    }
            }

            /** Whether the label reads right to left. */
            fun rtl(rtl: Boolean) = rtl(JsonField.of(rtl))

            /** Sets [Builder.rtl] to an arbitrary JSON value. */
            fun rtl(rtl: JsonField<Boolean>) = apply { this.rtl = rtl }

            /** The label's text. */
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Text].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Text =
                Text(
                    (entities ?: JsonMissing.of()).map { it.toImmutable() },
                    rtl,
                    text,
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
        fun validate(): Text = apply {
            if (validated) {
                return@apply
            }

            entities().ifPresent { it.forEach { it.validate() } }
            rtl()
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
            (entities.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (rtl.asKnown().isPresent) 1 else 0) +
                (if (text.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Text &&
                entities == other.entities &&
                rtl == other.rtl &&
                text == other.text &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(entities, rtl, text, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Text{entities=$entities, rtl=$rtl, text=$text, additionalProperties=$additionalProperties}"
    }

    /** The page that explains the label. */
    class Url
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val url: JsonField<String>,
        private val urlType: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("urlType") @ExcludeMissing urlType: JsonField<String> = JsonMissing.of(),
        ) : this(url, urlType, mutableMapOf())

        /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * How X opens the link, such as ExternalUrl.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun urlType(): Optional<String> = urlType.getOptional("urlType")

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [urlType].
         *
         * Unlike [urlType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("urlType") @ExcludeMissing fun _urlType(): JsonField<String> = urlType

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

            /** Returns a mutable builder for constructing an instance of [Url]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Url]. */
        class Builder internal constructor() {

            private var url: JsonField<String> = JsonMissing.of()
            private var urlType: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(url: Url) = apply {
                this.url = url.url
                urlType = url.urlType
                additionalProperties = url.additionalProperties.toMutableMap()
            }

            fun url(url: String) = url(JsonField.of(url))

            /** Sets [Builder.url] to an arbitrary JSON value. */
            fun url(url: JsonField<String>) = apply { this.url = url }

            /** How X opens the link, such as ExternalUrl. */
            fun urlType(urlType: String) = urlType(JsonField.of(urlType))

            /** Sets [Builder.urlType] to an arbitrary JSON value. */
            fun urlType(urlType: JsonField<String>) = apply { this.urlType = urlType }

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
             * Returns an immutable instance of [Url].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Url = Url(url, urlType, additionalProperties.toMutableMap())
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
        fun validate(): Url = apply {
            if (validated) {
                return@apply
            }

            url()
            urlType()
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
            (if (url.asKnown().isPresent) 1 else 0) + (if (urlType.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Url &&
                url == other.url &&
                urlType == other.urlType &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(url, urlType, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Url{url=$url, urlType=$urlType, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SoftIntervention &&
            displayType == other.displayType &&
            engagementNudge == other.engagementNudge &&
            text == other.text &&
            url == other.url &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(displayType, engagementNudge, text, url, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SoftIntervention{displayType=$displayType, engagementNudge=$engagementNudge, text=$text, url=$url, additionalProperties=$additionalProperties}"
}
