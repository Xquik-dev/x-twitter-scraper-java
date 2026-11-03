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
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** The live event the post belongs to, such as an election. */
class LiveEventContext
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val title: JsonField<String>,
    private val url: JsonField<String>,
    private val imageUrl: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        @JsonProperty("imageUrl") @ExcludeMissing imageUrl: JsonField<String> = JsonMissing.of(),
    ) : this(title, url, imageUrl, mutableMapOf())

    /** Event name. */
    fun title(): Optional<String> = title.getOptional("title")

    /** The event's page on X. */
    fun url(): Optional<String> = url.getOptional("url")

    /** The event's image. */
    fun imageUrl(): Optional<String> = imageUrl.getOptional("imageUrl")

    /** Returns the raw JSON value of [title]. */
    @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

    /** Returns the raw JSON value of [url]. */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

    /** Returns the raw JSON value of [imageUrl]. */
    @JsonProperty("imageUrl") @ExcludeMissing fun _imageUrl(): JsonField<String> = imageUrl

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

        /** Returns a mutable builder for constructing an instance of [LiveEventContext]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [LiveEventContext]. */
    class Builder internal constructor() {

        private var title: JsonField<String> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var imageUrl: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(liveEventContext: LiveEventContext) = apply {
            title = liveEventContext.title
            url = liveEventContext.url
            imageUrl = liveEventContext.imageUrl
            additionalProperties = liveEventContext.additionalProperties.toMutableMap()
        }

        /** Event name. */
        fun title(title: String) = title(JsonField.of(title))

        /** Sets [Builder.title] to an arbitrary JSON value. */
        fun title(title: JsonField<String>) = apply { this.title = title }

        /** The event's page on X. */
        fun url(url: String) = url(JsonField.of(url))

        /** Sets [Builder.url] to an arbitrary JSON value. */
        fun url(url: JsonField<String>) = apply { this.url = url }

        /** The event's image. */
        fun imageUrl(imageUrl: String) = imageUrl(JsonField.of(imageUrl))

        /** Sets [Builder.imageUrl] to an arbitrary JSON value. */
        fun imageUrl(imageUrl: JsonField<String>) = apply { this.imageUrl = imageUrl }

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

        /** Returns an immutable instance of [LiveEventContext]. */
        fun build(): LiveEventContext =
            LiveEventContext(
                title,
                url,
                imageUrl,
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
    fun validate(): LiveEventContext = apply {
        if (validated) {
            return@apply
        }

        title()
        url()
        imageUrl()
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
        (if (title.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0) +
            (if (imageUrl.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is LiveEventContext &&
            title == other.title &&
            url == other.url &&
            imageUrl == other.imageUrl &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(title, url, imageUrl, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "LiveEventContext{title=$title, url=$url, imageUrl=$imageUrl, additionalProperties=$additionalProperties}"
}
