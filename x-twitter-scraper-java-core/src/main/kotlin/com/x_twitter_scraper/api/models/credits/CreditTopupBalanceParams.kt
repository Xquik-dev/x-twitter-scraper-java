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
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import com.x_twitter_scraper.api.models.Currency
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Create a hosted checkout only after the user confirms. The request never completes payment or
 * adds credits.
 */
class CreditTopupBalanceParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Amount to top up in US dollars. Minimum 10.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun dollars(): Long = body.dollars()

    /**
     * Optional checkout locale. Defaults to en.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun locale(): Optional<String> = body.locale()

    /**
     * Returns the raw JSON value of [dollars].
     *
     * Unlike [dollars], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _dollars(): JsonField<Long> = body._dollars()

    /**
     * Returns the raw JSON value of [locale].
     *
     * Unlike [locale], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _locale(): JsonField<String> = body._locale()

    /**
     * Currency to pay in. Xquik converts the dollar amount at the latest daily ECB rate, or charges
     * USD when those rates are more than 3 ECB working days old. chargedCurrency shows the currency
     * charged.
     */
    fun currency(): Optional<Currency> = body.currency()

    /** Returns the raw JSON value of [currency]. */
    fun _currency(): JsonField<Currency> = body._currency()

    /** Optional Xquik tool page to return to after Checkout, such as /en/x-article-reader. */
    fun returnPath(): Optional<String> = body.returnPath()

    /** Returns the raw JSON value of [returnPath]. */
    fun _returnPath(): JsonField<String> = body._returnPath()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CreditTopupBalanceParams].
         *
         * The following fields are required:
         * ```java
         * .dollars()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CreditTopupBalanceParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(creditTopupBalanceParams: CreditTopupBalanceParams) = apply {
            body = creditTopupBalanceParams.body.toBuilder()
            additionalHeaders = creditTopupBalanceParams.additionalHeaders.toBuilder()
            additionalQueryParams = creditTopupBalanceParams.additionalQueryParams.toBuilder()
        }

        /** Sets the entire request body. */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Amount to top up in US dollars. Minimum 10. */
        fun dollars(dollars: Long) = apply { body.dollars(dollars) }

        /** Sets [Builder.dollars] to an arbitrary JSON value. */
        fun dollars(dollars: JsonField<Long>) = apply { body.dollars(dollars) }

        /** Optional checkout locale. Defaults to en. */
        fun locale(locale: String) = apply { body.locale(locale) }

        /** Sets [Builder.locale] to an arbitrary JSON value. */
        fun locale(locale: JsonField<String>) = apply { body.locale(locale) }

        /**
         * Currency to pay in. Xquik converts the dollar amount at the latest daily ECB rate, or
         * charges USD when those rates are more than 3 ECB working days old. chargedCurrency shows
         * the currency charged.
         */
        fun currency(currency: Currency) = apply { body.currency(currency) }

        /** Sets [Builder.currency] to an arbitrary JSON value. */
        fun currency(currency: JsonField<Currency>) = apply { body.currency(currency) }

        /** Optional Xquik tool page to return to after Checkout, such as /en/x-article-reader. */
        fun returnPath(returnPath: String) = apply { body.returnPath(returnPath) }

        /** Sets [Builder.returnPath] to an arbitrary JSON value. */
        fun returnPath(returnPath: JsonField<String>) = apply { body.returnPath(returnPath) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [CreditTopupBalanceParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .dollars()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CreditTopupBalanceParams =
            CreditTopupBalanceParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val dollars: JsonField<Long>,
        private val locale: JsonField<String>,
        private val currency: JsonField<Currency>,
        private val returnPath: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("dollars") @ExcludeMissing dollars: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("locale") @ExcludeMissing locale: JsonField<String> = JsonMissing.of(),
            @JsonProperty("currency")
            @ExcludeMissing
            currency: JsonField<Currency> = JsonMissing.of(),
            @JsonProperty("returnPath")
            @ExcludeMissing
            returnPath: JsonField<String> = JsonMissing.of(),
        ) : this(dollars, locale, currency, returnPath, mutableMapOf())

        /**
         * Amount to top up in US dollars. Minimum 10.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun dollars(): Long = dollars.getRequired("dollars")

        /**
         * Optional checkout locale. Defaults to en.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun locale(): Optional<String> = locale.getOptional("locale")

        /**
         * Currency to pay in. Xquik converts the dollar amount at the latest daily ECB rate, or
         * charges USD when those rates are more than 3 ECB working days old. chargedCurrency shows
         * the currency charged.
         */
        fun currency(): Optional<Currency> = currency.getOptional("currency")

        /** Optional Xquik tool page to return to after Checkout, such as /en/x-article-reader. */
        fun returnPath(): Optional<String> = returnPath.getOptional("returnPath")

        /**
         * Returns the raw JSON value of [dollars].
         *
         * Unlike [dollars], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("dollars") @ExcludeMissing fun _dollars(): JsonField<Long> = dollars

        /**
         * Returns the raw JSON value of [locale].
         *
         * Unlike [locale], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("locale") @ExcludeMissing fun _locale(): JsonField<String> = locale

        /** Returns the raw JSON value of [currency]. */
        @JsonProperty("currency") @ExcludeMissing fun _currency(): JsonField<Currency> = currency

        /** Returns the raw JSON value of [returnPath]. */
        @JsonProperty("returnPath")
        @ExcludeMissing
        fun _returnPath(): JsonField<String> = returnPath

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .dollars()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var dollars: JsonField<Long>? = null
            private var locale: JsonField<String> = JsonMissing.of()
            private var currency: JsonField<Currency> = JsonMissing.of()
            private var returnPath: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                dollars = body.dollars
                locale = body.locale
                currency = body.currency
                returnPath = body.returnPath
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Amount to top up in US dollars. Minimum 10. */
            fun dollars(dollars: Long) = dollars(JsonField.of(dollars))

            /** Sets [Builder.dollars] to an arbitrary JSON value. */
            fun dollars(dollars: JsonField<Long>) = apply { this.dollars = dollars }

            /** Optional checkout locale. Defaults to en. */
            fun locale(locale: String) = locale(JsonField.of(locale))

            /** Sets [Builder.locale] to an arbitrary JSON value. */
            fun locale(locale: JsonField<String>) = apply { this.locale = locale }

            /**
             * Currency to pay in. Xquik converts the dollar amount at the latest daily ECB rate, or
             * charges USD when those rates are more than 3 ECB working days old. chargedCurrency
             * shows the currency charged.
             */
            fun currency(currency: Currency) = currency(JsonField.of(currency))

            /** Sets [Builder.currency] to an arbitrary JSON value. */
            fun currency(currency: JsonField<Currency>) = apply { this.currency = currency }

            /**
             * Optional Xquik tool page to return to after Checkout, such as /en/x-article-reader.
             */
            fun returnPath(returnPath: String) = returnPath(JsonField.of(returnPath))

            /** Sets [Builder.returnPath] to an arbitrary JSON value. */
            fun returnPath(returnPath: JsonField<String>) = apply { this.returnPath = returnPath }

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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .dollars()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("dollars", dollars),
                    locale,
                    currency,
                    returnPath,
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
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            dollars()
            locale()
            currency().ifPresent { it.validate() }
            returnPath()
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
            (if (dollars.asKnown().isPresent) 1 else 0) +
                (if (locale.asKnown().isPresent) 1 else 0) +
                (currency.asKnown().getOrNull()?.validity() ?: 0) +
                (if (returnPath.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                dollars == other.dollars &&
                locale == other.locale &&
                currency == other.currency &&
                returnPath == other.returnPath &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(dollars, locale, currency, returnPath, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{dollars=$dollars, locale=$locale, currency=$currency, returnPath=$returnPath, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CreditTopupBalanceParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "CreditTopupBalanceParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
