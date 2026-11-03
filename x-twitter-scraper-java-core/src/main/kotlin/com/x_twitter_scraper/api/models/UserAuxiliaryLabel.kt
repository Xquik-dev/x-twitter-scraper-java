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

/** A label X shows on an X profile beside its affiliation label. */
class UserAuxiliaryLabel
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val badgeUrl: JsonField<String>,
    private val description: JsonField<String>,
    private val url: JsonField<String>,
    private val userLabelDisplayType: JsonField<String>,
    private val userLabelType: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("badgeUrl") @ExcludeMissing badgeUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        @JsonProperty("userLabelDisplayType")
        @ExcludeMissing
        userLabelDisplayType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("userLabelType")
        @ExcludeMissing
        userLabelType: JsonField<String> = JsonMissing.of(),
    ) : this(badgeUrl, description, url, userLabelDisplayType, userLabelType, mutableMapOf())

    fun badgeUrl(): Optional<String> = badgeUrl.getOptional("badgeUrl")

    fun description(): Optional<String> = description.getOptional("description")

    fun url(): Optional<String> = url.getOptional("url")

    fun userLabelDisplayType(): Optional<String> =
        userLabelDisplayType.getOptional("userLabelDisplayType")

    fun userLabelType(): Optional<String> = userLabelType.getOptional("userLabelType")

    /** Returns the raw JSON value of [badgeUrl]. */
    @JsonProperty("badgeUrl") @ExcludeMissing fun _badgeUrl(): JsonField<String> = badgeUrl

    /** Returns the raw JSON value of [description]. */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /** Returns the raw JSON value of [url]. */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

    /** Returns the raw JSON value of [userLabelDisplayType]. */
    @JsonProperty("userLabelDisplayType")
    @ExcludeMissing
    fun _userLabelDisplayType(): JsonField<String> = userLabelDisplayType

    /** Returns the raw JSON value of [userLabelType]. */
    @JsonProperty("userLabelType")
    @ExcludeMissing
    fun _userLabelType(): JsonField<String> = userLabelType

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

        /** Returns a mutable builder for constructing an instance of [UserAuxiliaryLabel]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserAuxiliaryLabel]. */
    class Builder internal constructor() {

        private var badgeUrl: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var userLabelDisplayType: JsonField<String> = JsonMissing.of()
        private var userLabelType: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(userAuxiliaryLabel: UserAuxiliaryLabel) = apply {
            badgeUrl = userAuxiliaryLabel.badgeUrl
            description = userAuxiliaryLabel.description
            url = userAuxiliaryLabel.url
            userLabelDisplayType = userAuxiliaryLabel.userLabelDisplayType
            userLabelType = userAuxiliaryLabel.userLabelType
            additionalProperties = userAuxiliaryLabel.additionalProperties.toMutableMap()
        }

        fun badgeUrl(badgeUrl: String) = badgeUrl(JsonField.of(badgeUrl))

        /** Sets [Builder.badgeUrl] to an arbitrary JSON value. */
        fun badgeUrl(badgeUrl: JsonField<String>) = apply { this.badgeUrl = badgeUrl }

        fun description(description: String) = description(JsonField.of(description))

        /** Sets [Builder.description] to an arbitrary JSON value. */
        fun description(description: JsonField<String>) = apply { this.description = description }

        fun url(url: String) = url(JsonField.of(url))

        /** Sets [Builder.url] to an arbitrary JSON value. */
        fun url(url: JsonField<String>) = apply { this.url = url }

        fun userLabelDisplayType(userLabelDisplayType: String) =
            userLabelDisplayType(JsonField.of(userLabelDisplayType))

        /** Sets [Builder.userLabelDisplayType] to an arbitrary JSON value. */
        fun userLabelDisplayType(userLabelDisplayType: JsonField<String>) = apply {
            this.userLabelDisplayType = userLabelDisplayType
        }

        fun userLabelType(userLabelType: String) = userLabelType(JsonField.of(userLabelType))

        /** Sets [Builder.userLabelType] to an arbitrary JSON value. */
        fun userLabelType(userLabelType: JsonField<String>) = apply {
            this.userLabelType = userLabelType
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

        /** Returns an immutable instance of [UserAuxiliaryLabel]. */
        fun build(): UserAuxiliaryLabel =
            UserAuxiliaryLabel(
                badgeUrl,
                description,
                url,
                userLabelDisplayType,
                userLabelType,
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
    fun validate(): UserAuxiliaryLabel = apply {
        if (validated) {
            return@apply
        }

        badgeUrl()
        description()
        url()
        userLabelDisplayType()
        userLabelType()
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
        (if (badgeUrl.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0) +
            (if (userLabelDisplayType.asKnown().isPresent) 1 else 0) +
            (if (userLabelType.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserAuxiliaryLabel &&
            badgeUrl == other.badgeUrl &&
            description == other.description &&
            url == other.url &&
            userLabelDisplayType == other.userLabelDisplayType &&
            userLabelType == other.userLabelType &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            badgeUrl,
            description,
            url,
            userLabelDisplayType,
            userLabelType,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UserAuxiliaryLabel{badgeUrl=$badgeUrl, description=$description, url=$url, userLabelDisplayType=$userLabelDisplayType, userLabelType=$userLabelType, additionalProperties=$additionalProperties}"
}
