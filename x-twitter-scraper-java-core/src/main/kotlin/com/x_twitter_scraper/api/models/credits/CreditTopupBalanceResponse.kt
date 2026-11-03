// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
import com.x_twitter_scraper.api.models.Currency
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class CreditTopupBalanceResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val redirectUrl: JsonField<String>,
    private val url: JsonField<String>,
    private val chargedCurrency: JsonField<Currency>,
    private val chargedMinorUnits: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("redirect_url")
        @ExcludeMissing
        redirectUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        @JsonProperty("chargedCurrency")
        @ExcludeMissing
        chargedCurrency: JsonField<Currency> = JsonMissing.of(),
        @JsonProperty("chargedMinorUnits")
        @ExcludeMissing
        chargedMinorUnits: JsonField<Long> = JsonMissing.of(),
    ) : this(redirectUrl, url, chargedCurrency, chargedMinorUnits, mutableMapOf())

    /**
     * Stable Xquik redirect URL for the active checkout.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun redirectUrl(): String = redirectUrl.getRequired("redirect_url")

    /**
     * Same stable Xquik redirect URL as redirect_url. The response never exposes the hosted
     * checkout URL.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun url(): String = url.getRequired("url")

    /** Currency the checkout charges. */
    fun chargedCurrency(): Currency = chargedCurrency.getRequired("chargedCurrency")

    /**
     * Amount the checkout charges before tax, in the currency's smallest unit. JPY and KRW have no
     * decimals, so 1580 JPY is ¥1,580.
     */
    fun chargedMinorUnits(): Long = chargedMinorUnits.getRequired("chargedMinorUnits")

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

    /** Returns the raw JSON value of [chargedCurrency]. */
    @JsonProperty("chargedCurrency")
    @ExcludeMissing
    fun _chargedCurrency(): JsonField<Currency> = chargedCurrency

    /** Returns the raw JSON value of [chargedMinorUnits]. */
    @JsonProperty("chargedMinorUnits")
    @ExcludeMissing
    fun _chargedMinorUnits(): JsonField<Long> = chargedMinorUnits

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
         * .chargedCurrency()
         * .chargedMinorUnits()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CreditTopupBalanceResponse]. */
    class Builder internal constructor() {

        private var redirectUrl: JsonField<String>? = null
        private var url: JsonField<String>? = null
        private var chargedCurrency: JsonField<Currency>? = null
        private var chargedMinorUnits: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(creditTopupBalanceResponse: CreditTopupBalanceResponse) = apply {
            redirectUrl = creditTopupBalanceResponse.redirectUrl
            url = creditTopupBalanceResponse.url
            chargedCurrency = creditTopupBalanceResponse.chargedCurrency
            chargedMinorUnits = creditTopupBalanceResponse.chargedMinorUnits
            additionalProperties = creditTopupBalanceResponse.additionalProperties.toMutableMap()
        }

        /** Stable Xquik redirect URL for the active checkout. */
        fun redirectUrl(redirectUrl: String) = redirectUrl(JsonField.of(redirectUrl))

        /** Sets [Builder.redirectUrl] to an arbitrary JSON value. */
        fun redirectUrl(redirectUrl: JsonField<String>) = apply { this.redirectUrl = redirectUrl }

        /**
         * Same stable Xquik redirect URL as redirect_url. The response never exposes the hosted
         * checkout URL.
         */
        fun url(url: String) = url(JsonField.of(url))

        /** Sets [Builder.url] to an arbitrary JSON value. */
        fun url(url: JsonField<String>) = apply { this.url = url }

        /** Currency the checkout charges. */
        fun chargedCurrency(chargedCurrency: Currency) =
            chargedCurrency(JsonField.of(chargedCurrency))

        /** Sets [Builder.chargedCurrency] to an arbitrary JSON value. */
        fun chargedCurrency(chargedCurrency: JsonField<Currency>) = apply {
            this.chargedCurrency = chargedCurrency
        }

        /**
         * Amount the checkout charges before tax, in the currency's smallest unit. JPY and KRW have
         * no decimals, so 1580 JPY is ¥1,580.
         */
        fun chargedMinorUnits(chargedMinorUnits: Long) =
            chargedMinorUnits(JsonField.of(chargedMinorUnits))

        /** Sets [Builder.chargedMinorUnits] to an arbitrary JSON value. */
        fun chargedMinorUnits(chargedMinorUnits: JsonField<Long>) = apply {
            this.chargedMinorUnits = chargedMinorUnits
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
         * Returns an immutable instance of [CreditTopupBalanceResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .redirectUrl()
         * .url()
         * .chargedCurrency()
         * .chargedMinorUnits()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CreditTopupBalanceResponse =
            CreditTopupBalanceResponse(
                checkRequired("redirectUrl", redirectUrl),
                checkRequired("url", url),
                checkRequired("chargedCurrency", chargedCurrency),
                checkRequired("chargedMinorUnits", chargedMinorUnits),
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
        chargedCurrency().validate()
        chargedMinorUnits()
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
        (if (redirectUrl.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0) +
            (chargedCurrency.asKnown().getOrNull()?.validity() ?: 0) +
            (if (chargedMinorUnits.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CreditTopupBalanceResponse &&
            redirectUrl == other.redirectUrl &&
            url == other.url &&
            chargedCurrency == other.chargedCurrency &&
            chargedMinorUnits == other.chargedMinorUnits &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(redirectUrl, url, chargedCurrency, chargedMinorUnits, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CreditTopupBalanceResponse{redirectUrl=$redirectUrl, url=$url, chargedCurrency=$chargedCurrency, chargedMinorUnits=$chargedMinorUnits, additionalProperties=$additionalProperties}"
}
