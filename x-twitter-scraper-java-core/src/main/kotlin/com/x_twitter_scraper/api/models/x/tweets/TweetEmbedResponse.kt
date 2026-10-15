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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TweetEmbedResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val embed: JsonField<Embed>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("embed") @ExcludeMissing embed: JsonField<Embed> = JsonMissing.of()
    ) : this(embed, mutableMapOf())

    /**
     * Holds the HTML that embeds 1 tweet on a website.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun embed(): Embed = embed.getRequired("embed")

    /**
     * Returns the raw JSON value of [embed].
     *
     * Unlike [embed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("embed") @ExcludeMissing fun _embed(): JsonField<Embed> = embed

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
         * Returns a mutable builder for constructing an instance of [TweetEmbedResponse].
         *
         * The following fields are required:
         * ```java
         * .embed()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetEmbedResponse]. */
    class Builder internal constructor() {

        private var embed: JsonField<Embed>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tweetEmbedResponse: TweetEmbedResponse) = apply {
            embed = tweetEmbedResponse.embed
            additionalProperties = tweetEmbedResponse.additionalProperties.toMutableMap()
        }

        /** Holds the HTML that embeds 1 tweet on a website. */
        fun embed(embed: Embed) = embed(JsonField.of(embed))

        /** Sets [Builder.embed] to an arbitrary JSON value. */
        fun embed(embed: JsonField<Embed>) = apply { this.embed = embed }

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
         * Returns an immutable instance of [TweetEmbedResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .embed()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TweetEmbedResponse =
            TweetEmbedResponse(checkRequired("embed", embed), additionalProperties.toMutableMap())
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
    fun validate(): TweetEmbedResponse = apply {
        if (validated) {
            return@apply
        }

        embed().validate()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: XTwitterScraperInvalidDataException) {
            false
        }

    @JvmSynthetic internal fun validity(): Int = (embed.asKnown().getOrNull()?.validity() ?: 0)

    /** Holds the HTML that embeds 1 tweet on a website. */
    class Embed
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val authorName: JsonField<String>,
        private val authorUrl: JsonField<String>,
        private val html: JsonField<String>,
        private val tweetId: JsonField<String>,
        private val url: JsonField<String>,
        private val height: JsonField<Long>,
        private val width: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("authorName")
            @ExcludeMissing
            authorName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("authorUrl")
            @ExcludeMissing
            authorUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("html") @ExcludeMissing html: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("height") @ExcludeMissing height: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("width") @ExcludeMissing width: JsonField<Long> = JsonMissing.of(),
        ) : this(authorName, authorUrl, html, tweetId, url, height, width, mutableMapOf())

        /**
         * Display name of the tweet's author.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun authorName(): String = authorName.getRequired("authorName")

        /**
         * Link to the author's profile.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun authorUrl(): String = authorUrl.getRequired("authorUrl")

        /**
         * Markup to place on a page. It loads X's widget script unless `omitScript` is `true`.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun html(): String = html.getRequired("html")

        /**
         * ID of the embedded tweet.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun tweetId(): String = tweetId.getRequired("tweetId")

        /**
         * Link to the tweet with its author's username.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun url(): String = url.getRequired("url")

        /**
         * Height in pixels, when X fixes it.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun height(): Optional<Long> = height.getOptional("height")

        /**
         * Width of the embed in pixels.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun width(): Optional<Long> = width.getOptional("width")

        /**
         * Returns the raw JSON value of [authorName].
         *
         * Unlike [authorName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("authorName")
        @ExcludeMissing
        fun _authorName(): JsonField<String> = authorName

        /**
         * Returns the raw JSON value of [authorUrl].
         *
         * Unlike [authorUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("authorUrl") @ExcludeMissing fun _authorUrl(): JsonField<String> = authorUrl

        /**
         * Returns the raw JSON value of [html].
         *
         * Unlike [html], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("html") @ExcludeMissing fun _html(): JsonField<String> = html

        /**
         * Returns the raw JSON value of [tweetId].
         *
         * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [height].
         *
         * Unlike [height], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("height") @ExcludeMissing fun _height(): JsonField<Long> = height

        /**
         * Returns the raw JSON value of [width].
         *
         * Unlike [width], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("width") @ExcludeMissing fun _width(): JsonField<Long> = width

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
             * Returns a mutable builder for constructing an instance of [Embed].
             *
             * The following fields are required:
             * ```java
             * .authorName()
             * .authorUrl()
             * .html()
             * .tweetId()
             * .url()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Embed]. */
        class Builder internal constructor() {

            private var authorName: JsonField<String>? = null
            private var authorUrl: JsonField<String>? = null
            private var html: JsonField<String>? = null
            private var tweetId: JsonField<String>? = null
            private var url: JsonField<String>? = null
            private var height: JsonField<Long> = JsonMissing.of()
            private var width: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(embed: Embed) = apply {
                authorName = embed.authorName
                authorUrl = embed.authorUrl
                html = embed.html
                tweetId = embed.tweetId
                url = embed.url
                height = embed.height
                width = embed.width
                additionalProperties = embed.additionalProperties.toMutableMap()
            }

            /** Display name of the tweet's author. */
            fun authorName(authorName: String) = authorName(JsonField.of(authorName))

            /** Sets [Builder.authorName] to an arbitrary JSON value. */
            fun authorName(authorName: JsonField<String>) = apply { this.authorName = authorName }

            /** Link to the author's profile. */
            fun authorUrl(authorUrl: String) = authorUrl(JsonField.of(authorUrl))

            /** Sets [Builder.authorUrl] to an arbitrary JSON value. */
            fun authorUrl(authorUrl: JsonField<String>) = apply { this.authorUrl = authorUrl }

            /**
             * Markup to place on a page. It loads X's widget script unless `omitScript` is `true`.
             */
            fun html(html: String) = html(JsonField.of(html))

            /** Sets [Builder.html] to an arbitrary JSON value. */
            fun html(html: JsonField<String>) = apply { this.html = html }

            /** ID of the embedded tweet. */
            fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

            /** Sets [Builder.tweetId] to an arbitrary JSON value. */
            fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

            /** Link to the tweet with its author's username. */
            fun url(url: String) = url(JsonField.of(url))

            /** Sets [Builder.url] to an arbitrary JSON value. */
            fun url(url: JsonField<String>) = apply { this.url = url }

            /** Height in pixels, when X fixes it. */
            fun height(height: Long) = height(JsonField.of(height))

            /** Sets [Builder.height] to an arbitrary JSON value. */
            fun height(height: JsonField<Long>) = apply { this.height = height }

            /** Width of the embed in pixels. */
            fun width(width: Long) = width(JsonField.of(width))

            /** Sets [Builder.width] to an arbitrary JSON value. */
            fun width(width: JsonField<Long>) = apply { this.width = width }

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
             * Returns an immutable instance of [Embed].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .authorName()
             * .authorUrl()
             * .html()
             * .tweetId()
             * .url()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Embed =
                Embed(
                    checkRequired("authorName", authorName),
                    checkRequired("authorUrl", authorUrl),
                    checkRequired("html", html),
                    checkRequired("tweetId", tweetId),
                    checkRequired("url", url),
                    height,
                    width,
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
        fun validate(): Embed = apply {
            if (validated) {
                return@apply
            }

            authorName()
            authorUrl()
            html()
            tweetId()
            url()
            height()
            width()
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
            (if (authorName.asKnown().isPresent) 1 else 0) +
                (if (authorUrl.asKnown().isPresent) 1 else 0) +
                (if (html.asKnown().isPresent) 1 else 0) +
                (if (tweetId.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0) +
                (if (height.asKnown().isPresent) 1 else 0) +
                (if (width.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Embed &&
                authorName == other.authorName &&
                authorUrl == other.authorUrl &&
                html == other.html &&
                tweetId == other.tweetId &&
                url == other.url &&
                height == other.height &&
                width == other.width &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                authorName,
                authorUrl,
                html,
                tweetId,
                url,
                height,
                width,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Embed{authorName=$authorName, authorUrl=$authorUrl, html=$html, tweetId=$tweetId, url=$url, height=$height, width=$width, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetEmbedResponse &&
            embed == other.embed &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(embed, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TweetEmbedResponse{embed=$embed, additionalProperties=$additionalProperties}"
}
