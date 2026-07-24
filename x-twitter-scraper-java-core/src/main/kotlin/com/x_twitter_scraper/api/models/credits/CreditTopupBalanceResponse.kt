// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.credits

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

class CreditTopupBalanceResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val redirectUrl: JsonField<String>,
    private val url: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("redirect_url")
        @ExcludeMissing
        redirectUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
    ) : this(redirectUrl, url, mutableMapOf())

    /**
     * Stable first-party Xquik redirect URL for the active Stripe Checkout session.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun redirectUrl(): String = redirectUrl.getRequired("redirect_url")

    /**
     * Same stable first-party Xquik redirect URL as redirect_url. The response never exposes a raw
     * Stripe Checkout URL.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun url(): String = url.getRequired("url")

    /**
     * Returns the raw JSON value of [redirectUrl].
     *
     * Unlike [redirectUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("redirect_url")
    @ExcludeMissing
    fun _redirectUrl(): JsonField<String> = redirectUrl

    /**
     * Returns the raw JSON value of [url].
     *
     * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
         * Returns a mutable builder for constructing an instance of [CreditTopupBalanceResponse].
         *
         * The following fields are required:
         * ```java
         * .redirectUrl()
         * .url()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CreditTopupBalanceResponse]. */
    class Builder internal constructor() {

        private var redirectUrl: JsonField<String>? = null
        private var url: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(creditTopupBalanceResponse: CreditTopupBalanceResponse) = apply {
            redirectUrl = creditTopupBalanceResponse.redirectUrl
            url = creditTopupBalanceResponse.url
            additionalProperties = creditTopupBalanceResponse.additionalProperties.toMutableMap()
        }

        /** Stable first-party Xquik redirect URL for the active Stripe Checkout session. */
        fun redirectUrl(redirectUrl: String) = redirectUrl(JsonField.of(redirectUrl))

        /**
         * Sets [Builder.redirectUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.redirectUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun redirectUrl(redirectUrl: JsonField<String>) = apply { this.redirectUrl = redirectUrl }

        /**
         * Same stable first-party Xquik redirect URL as redirect_url. The response never exposes a
         * raw Stripe Checkout URL.
         */
        fun url(url: String) = url(JsonField.of(url))

        /**
         * Sets [Builder.url] to an arbitrary JSON value.
         *
         * You should usually call [Builder.url] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun url(url: JsonField<String>) = apply { this.url = url }

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
         * Returns an immutable instance of [CreditTopupBalanceResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .redirectUrl()
         * .url()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CreditTopupBalanceResponse =
            CreditTopupBalanceResponse(
                checkRequired("redirectUrl", redirectUrl),
                checkRequired("url", url),
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
    fun validate(): CreditTopupBalanceResponse = apply {
        if (validated) {
            return@apply
        }

        redirectUrl()
        url()
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
        (if (redirectUrl.asKnown().isPresent) 1 else 0) + (if (url.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CreditTopupBalanceResponse &&
            redirectUrl == other.redirectUrl &&
            url == other.url &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(redirectUrl, url, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CreditTopupBalanceResponse{redirectUrl=$redirectUrl, url=$url, additionalProperties=$additionalProperties}"
}
