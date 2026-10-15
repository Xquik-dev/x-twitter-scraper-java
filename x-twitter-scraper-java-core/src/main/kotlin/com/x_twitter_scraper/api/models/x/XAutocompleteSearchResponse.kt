// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x

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

/**
 * What X suggests for a partial search query. Each list keeps X's order. A list is empty when X
 * suggests none of its type or types leaves it out.
 */
class XAutocompleteSearchResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val cashtags: JsonField<List<Cashtag>>,
    private val count: JsonField<Long>,
    private val hashtags: JsonField<List<Hashtag>>,
    private val query: JsonField<String>,
    private val topics: JsonField<List<Topic>>,
    private val users: JsonField<List<User>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("cashtags")
        @ExcludeMissing
        cashtags: JsonField<List<Cashtag>> = JsonMissing.of(),
        @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("hashtags")
        @ExcludeMissing
        hashtags: JsonField<List<Hashtag>> = JsonMissing.of(),
        @JsonProperty("query") @ExcludeMissing query: JsonField<String> = JsonMissing.of(),
        @JsonProperty("topics") @ExcludeMissing topics: JsonField<List<Topic>> = JsonMissing.of(),
        @JsonProperty("users") @ExcludeMissing users: JsonField<List<User>> = JsonMissing.of(),
    ) : this(cashtags, count, hashtags, query, topics, users, mutableMapOf())

    /**
     * Suggested stocks & crypto tokens.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun cashtags(): List<Cashtag> = cashtags.getRequired("cashtags")

    /**
     * Suggestions returned across all 4 lists. Each costs 1 credit.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun count(): Long = count.getRequired("count")

    /**
     * Suggested hashtags.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun hashtags(): List<Hashtag> = hashtags.getRequired("hashtags")

    /**
     * The query you sent, trimmed.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun query(): String = query.getRequired("query")

    /**
     * Suggested search phrases that are not hashtags.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun topics(): List<Topic> = topics.getRequired("topics")

    /**
     * Suggested accounts.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null.
     */
    fun users(): List<User> = users.getRequired("users")

    /**
     * Returns the raw JSON value of [cashtags].
     *
     * Unlike [cashtags], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cashtags") @ExcludeMissing fun _cashtags(): JsonField<List<Cashtag>> = cashtags

    /**
     * Returns the raw JSON value of [count].
     *
     * Unlike [count], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

    /**
     * Returns the raw JSON value of [hashtags].
     *
     * Unlike [hashtags], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hashtags") @ExcludeMissing fun _hashtags(): JsonField<List<Hashtag>> = hashtags

    /**
     * Returns the raw JSON value of [query].
     *
     * Unlike [query], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<String> = query

    /**
     * Returns the raw JSON value of [topics].
     *
     * Unlike [topics], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("topics") @ExcludeMissing fun _topics(): JsonField<List<Topic>> = topics

    /**
     * Returns the raw JSON value of [users].
     *
     * Unlike [users], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("users") @ExcludeMissing fun _users(): JsonField<List<User>> = users

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
         * Returns a mutable builder for constructing an instance of [XAutocompleteSearchResponse].
         *
         * The following fields are required:
         * ```java
         * .cashtags()
         * .count()
         * .hashtags()
         * .query()
         * .topics()
         * .users()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [XAutocompleteSearchResponse]. */
    class Builder internal constructor() {

        private var cashtags: JsonField<MutableList<Cashtag>>? = null
        private var count: JsonField<Long>? = null
        private var hashtags: JsonField<MutableList<Hashtag>>? = null
        private var query: JsonField<String>? = null
        private var topics: JsonField<MutableList<Topic>>? = null
        private var users: JsonField<MutableList<User>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(xAutocompleteSearchResponse: XAutocompleteSearchResponse) = apply {
            cashtags = xAutocompleteSearchResponse.cashtags.map { it.toMutableList() }
            count = xAutocompleteSearchResponse.count
            hashtags = xAutocompleteSearchResponse.hashtags.map { it.toMutableList() }
            query = xAutocompleteSearchResponse.query
            topics = xAutocompleteSearchResponse.topics.map { it.toMutableList() }
            users = xAutocompleteSearchResponse.users.map { it.toMutableList() }
            additionalProperties = xAutocompleteSearchResponse.additionalProperties.toMutableMap()
        }

        /** Suggested stocks & crypto tokens. */
        fun cashtags(cashtags: List<Cashtag>) = cashtags(JsonField.of(cashtags))

        /** Sets [Builder.cashtags] to an arbitrary JSON value. */
        fun cashtags(cashtags: JsonField<List<Cashtag>>) = apply {
            this.cashtags = cashtags.map { it.toMutableList() }
        }

        /**
         * Adds a single [Cashtag] to [cashtags].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addCashtag(cashtag: Cashtag) = apply {
            cashtags =
                (cashtags ?: JsonField.of(mutableListOf())).also {
                    checkKnown("cashtags", it).add(cashtag)
                }
        }

        /** Suggestions returned across all 4 lists. Each costs 1 credit. */
        fun count(count: Long) = count(JsonField.of(count))

        /** Sets [Builder.count] to an arbitrary JSON value. */
        fun count(count: JsonField<Long>) = apply { this.count = count }

        /** Suggested hashtags. */
        fun hashtags(hashtags: List<Hashtag>) = hashtags(JsonField.of(hashtags))

        /** Sets [Builder.hashtags] to an arbitrary JSON value. */
        fun hashtags(hashtags: JsonField<List<Hashtag>>) = apply {
            this.hashtags = hashtags.map { it.toMutableList() }
        }

        /**
         * Adds a single [Hashtag] to [hashtags].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addHashtag(hashtag: Hashtag) = apply {
            hashtags =
                (hashtags ?: JsonField.of(mutableListOf())).also {
                    checkKnown("hashtags", it).add(hashtag)
                }
        }

        /** The query you sent, trimmed. */
        fun query(query: String) = query(JsonField.of(query))

        /** Sets [Builder.query] to an arbitrary JSON value. */
        fun query(query: JsonField<String>) = apply { this.query = query }

        /** Suggested search phrases that are not hashtags. */
        fun topics(topics: List<Topic>) = topics(JsonField.of(topics))

        /** Sets [Builder.topics] to an arbitrary JSON value. */
        fun topics(topics: JsonField<List<Topic>>) = apply {
            this.topics = topics.map { it.toMutableList() }
        }

        /**
         * Adds a single [Topic] to [topics].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTopic(topic: Topic) = apply {
            topics =
                (topics ?: JsonField.of(mutableListOf())).also {
                    checkKnown("topics", it).add(topic)
                }
        }

        /** Suggested accounts. */
        fun users(users: List<User>) = users(JsonField.of(users))

        /** Sets [Builder.users] to an arbitrary JSON value. */
        fun users(users: JsonField<List<User>>) = apply {
            this.users = users.map { it.toMutableList() }
        }

        /**
         * Adds a single [User] to [users].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUser(user: User) = apply {
            users =
                (users ?: JsonField.of(mutableListOf())).also { checkKnown("users", it).add(user) }
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
         * Returns an immutable instance of [XAutocompleteSearchResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .cashtags()
         * .count()
         * .hashtags()
         * .query()
         * .topics()
         * .users()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): XAutocompleteSearchResponse =
            XAutocompleteSearchResponse(
                checkRequired("cashtags", cashtags).map { it.toImmutable() },
                checkRequired("count", count),
                checkRequired("hashtags", hashtags).map { it.toImmutable() },
                checkRequired("query", query),
                checkRequired("topics", topics).map { it.toImmutable() },
                checkRequired("users", users).map { it.toImmutable() },
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
    fun validate(): XAutocompleteSearchResponse = apply {
        if (validated) {
            return@apply
        }

        cashtags().forEach { it.validate() }
        count()
        hashtags().forEach { it.validate() }
        query()
        topics().forEach { it.validate() }
        users().forEach { it.validate() }
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
        (cashtags.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (count.asKnown().isPresent) 1 else 0) +
            (hashtags.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (if (query.asKnown().isPresent) 1 else 0) +
            (topics.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
            (users.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0)

    /** A stock or crypto token X suggests for the query. */
    class Cashtag
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val ticker: JsonField<String>,
        private val chainLogoUrl: JsonField<String>,
        private val contractAddress: JsonField<String>,
        private val currency: JsonField<String>,
        private val dailyChangePercent: JsonField<Double>,
        private val exchangeShortName: JsonField<String>,
        private val logoUrl: JsonField<String>,
        private val marketCap: JsonField<String>,
        private val name: JsonField<String>,
        private val price: JsonField<String>,
        private val smartTag: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("ticker") @ExcludeMissing ticker: JsonField<String> = JsonMissing.of(),
            @JsonProperty("chainLogoUrl")
            @ExcludeMissing
            chainLogoUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("contractAddress")
            @ExcludeMissing
            contractAddress: JsonField<String> = JsonMissing.of(),
            @JsonProperty("currency")
            @ExcludeMissing
            currency: JsonField<String> = JsonMissing.of(),
            @JsonProperty("dailyChangePercent")
            @ExcludeMissing
            dailyChangePercent: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("exchangeShortName")
            @ExcludeMissing
            exchangeShortName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("logoUrl") @ExcludeMissing logoUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("marketCap")
            @ExcludeMissing
            marketCap: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("price") @ExcludeMissing price: JsonField<String> = JsonMissing.of(),
            @JsonProperty("smartTag")
            @ExcludeMissing
            smartTag: JsonField<String> = JsonMissing.of(),
        ) : this(
            ticker,
            chainLogoUrl,
            contractAddress,
            currency,
            dailyChangePercent,
            exchangeShortName,
            logoUrl,
            marketCap,
            name,
            price,
            smartTag,
            mutableMapOf(),
        )

        /**
         * Ticker symbol without the $.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun ticker(): String = ticker.getRequired("ticker")

        /**
         * Logo of the token's chain. Tokens only.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun chainLogoUrl(): Optional<String> = chainLogoUrl.getOptional("chainLogoUrl")

        /**
         * Token contract address. Tokens only.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun contractAddress(): Optional<String> = contractAddress.getOptional("contractAddress")

        /**
         * Currency of price & marketCap.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun currency(): Optional<String> = currency.getOptional("currency")

        /**
         * Price change over the last 24 hours, in percent.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun dailyChangePercent(): Optional<Double> =
            dailyChangePercent.getOptional("dailyChangePercent")

        /**
         * Stock exchange. Stocks only.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun exchangeShortName(): Optional<String> =
            exchangeShortName.getOptional("exchangeShortName")

        /**
         * Logo image URL.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun logoUrl(): Optional<String> = logoUrl.getOptional("logoUrl")

        /**
         * Market capitalization as decimal text.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun marketCap(): Optional<String> = marketCap.getOptional("marketCap")

        /**
         * Company or token name.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Latest price as decimal text, which keeps every digit.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun price(): Optional<String> = price.getOptional("price")

        /**
         * X's tag for the asset. $TICKER for a stock, chain:contract for a token.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun smartTag(): Optional<String> = smartTag.getOptional("smartTag")

        /**
         * Returns the raw JSON value of [ticker].
         *
         * Unlike [ticker], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ticker") @ExcludeMissing fun _ticker(): JsonField<String> = ticker

        /**
         * Returns the raw JSON value of [chainLogoUrl].
         *
         * Unlike [chainLogoUrl], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("chainLogoUrl")
        @ExcludeMissing
        fun _chainLogoUrl(): JsonField<String> = chainLogoUrl

        /**
         * Returns the raw JSON value of [contractAddress].
         *
         * Unlike [contractAddress], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("contractAddress")
        @ExcludeMissing
        fun _contractAddress(): JsonField<String> = contractAddress

        /**
         * Returns the raw JSON value of [currency].
         *
         * Unlike [currency], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("currency") @ExcludeMissing fun _currency(): JsonField<String> = currency

        /**
         * Returns the raw JSON value of [dailyChangePercent].
         *
         * Unlike [dailyChangePercent], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("dailyChangePercent")
        @ExcludeMissing
        fun _dailyChangePercent(): JsonField<Double> = dailyChangePercent

        /**
         * Returns the raw JSON value of [exchangeShortName].
         *
         * Unlike [exchangeShortName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("exchangeShortName")
        @ExcludeMissing
        fun _exchangeShortName(): JsonField<String> = exchangeShortName

        /**
         * Returns the raw JSON value of [logoUrl].
         *
         * Unlike [logoUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("logoUrl") @ExcludeMissing fun _logoUrl(): JsonField<String> = logoUrl

        /**
         * Returns the raw JSON value of [marketCap].
         *
         * Unlike [marketCap], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("marketCap") @ExcludeMissing fun _marketCap(): JsonField<String> = marketCap

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [price].
         *
         * Unlike [price], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("price") @ExcludeMissing fun _price(): JsonField<String> = price

        /**
         * Returns the raw JSON value of [smartTag].
         *
         * Unlike [smartTag], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("smartTag") @ExcludeMissing fun _smartTag(): JsonField<String> = smartTag

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
             * Returns a mutable builder for constructing an instance of [Cashtag].
             *
             * The following fields are required:
             * ```java
             * .ticker()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Cashtag]. */
        class Builder internal constructor() {

            private var ticker: JsonField<String>? = null
            private var chainLogoUrl: JsonField<String> = JsonMissing.of()
            private var contractAddress: JsonField<String> = JsonMissing.of()
            private var currency: JsonField<String> = JsonMissing.of()
            private var dailyChangePercent: JsonField<Double> = JsonMissing.of()
            private var exchangeShortName: JsonField<String> = JsonMissing.of()
            private var logoUrl: JsonField<String> = JsonMissing.of()
            private var marketCap: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var price: JsonField<String> = JsonMissing.of()
            private var smartTag: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(cashtag: Cashtag) = apply {
                ticker = cashtag.ticker
                chainLogoUrl = cashtag.chainLogoUrl
                contractAddress = cashtag.contractAddress
                currency = cashtag.currency
                dailyChangePercent = cashtag.dailyChangePercent
                exchangeShortName = cashtag.exchangeShortName
                logoUrl = cashtag.logoUrl
                marketCap = cashtag.marketCap
                name = cashtag.name
                price = cashtag.price
                smartTag = cashtag.smartTag
                additionalProperties = cashtag.additionalProperties.toMutableMap()
            }

            /** Ticker symbol without the $. */
            fun ticker(ticker: String) = ticker(JsonField.of(ticker))

            /** Sets [Builder.ticker] to an arbitrary JSON value. */
            fun ticker(ticker: JsonField<String>) = apply { this.ticker = ticker }

            /** Logo of the token's chain. Tokens only. */
            fun chainLogoUrl(chainLogoUrl: String) = chainLogoUrl(JsonField.of(chainLogoUrl))

            /** Sets [Builder.chainLogoUrl] to an arbitrary JSON value. */
            fun chainLogoUrl(chainLogoUrl: JsonField<String>) = apply {
                this.chainLogoUrl = chainLogoUrl
            }

            /** Token contract address. Tokens only. */
            fun contractAddress(contractAddress: String) =
                contractAddress(JsonField.of(contractAddress))

            /** Sets [Builder.contractAddress] to an arbitrary JSON value. */
            fun contractAddress(contractAddress: JsonField<String>) = apply {
                this.contractAddress = contractAddress
            }

            /** Currency of price & marketCap. */
            fun currency(currency: String) = currency(JsonField.of(currency))

            /** Sets [Builder.currency] to an arbitrary JSON value. */
            fun currency(currency: JsonField<String>) = apply { this.currency = currency }

            /** Price change over the last 24 hours, in percent. */
            fun dailyChangePercent(dailyChangePercent: Double) =
                dailyChangePercent(JsonField.of(dailyChangePercent))

            /** Sets [Builder.dailyChangePercent] to an arbitrary JSON value. */
            fun dailyChangePercent(dailyChangePercent: JsonField<Double>) = apply {
                this.dailyChangePercent = dailyChangePercent
            }

            /** Stock exchange. Stocks only. */
            fun exchangeShortName(exchangeShortName: String) =
                exchangeShortName(JsonField.of(exchangeShortName))

            /** Sets [Builder.exchangeShortName] to an arbitrary JSON value. */
            fun exchangeShortName(exchangeShortName: JsonField<String>) = apply {
                this.exchangeShortName = exchangeShortName
            }

            /** Logo image URL. */
            fun logoUrl(logoUrl: String) = logoUrl(JsonField.of(logoUrl))

            /** Sets [Builder.logoUrl] to an arbitrary JSON value. */
            fun logoUrl(logoUrl: JsonField<String>) = apply { this.logoUrl = logoUrl }

            /** Market capitalization as decimal text. */
            fun marketCap(marketCap: String) = marketCap(JsonField.of(marketCap))

            /** Sets [Builder.marketCap] to an arbitrary JSON value. */
            fun marketCap(marketCap: JsonField<String>) = apply { this.marketCap = marketCap }

            /** Company or token name. */
            fun name(name: String) = name(JsonField.of(name))

            /** Sets [Builder.name] to an arbitrary JSON value. */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Latest price as decimal text, which keeps every digit. */
            fun price(price: String) = price(JsonField.of(price))

            /** Sets [Builder.price] to an arbitrary JSON value. */
            fun price(price: JsonField<String>) = apply { this.price = price }

            /** X's tag for the asset. $TICKER for a stock, chain:contract for a token. */
            fun smartTag(smartTag: String) = smartTag(JsonField.of(smartTag))

            /** Sets [Builder.smartTag] to an arbitrary JSON value. */
            fun smartTag(smartTag: JsonField<String>) = apply { this.smartTag = smartTag }

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
             * Returns an immutable instance of [Cashtag].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .ticker()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Cashtag =
                Cashtag(
                    checkRequired("ticker", ticker),
                    chainLogoUrl,
                    contractAddress,
                    currency,
                    dailyChangePercent,
                    exchangeShortName,
                    logoUrl,
                    marketCap,
                    name,
                    price,
                    smartTag,
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
        fun validate(): Cashtag = apply {
            if (validated) {
                return@apply
            }

            ticker()
            chainLogoUrl()
            contractAddress()
            currency()
            dailyChangePercent()
            exchangeShortName()
            logoUrl()
            marketCap()
            name()
            price()
            smartTag()
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
            (if (ticker.asKnown().isPresent) 1 else 0) +
                (if (chainLogoUrl.asKnown().isPresent) 1 else 0) +
                (if (contractAddress.asKnown().isPresent) 1 else 0) +
                (if (currency.asKnown().isPresent) 1 else 0) +
                (if (dailyChangePercent.asKnown().isPresent) 1 else 0) +
                (if (exchangeShortName.asKnown().isPresent) 1 else 0) +
                (if (logoUrl.asKnown().isPresent) 1 else 0) +
                (if (marketCap.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (price.asKnown().isPresent) 1 else 0) +
                (if (smartTag.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Cashtag &&
                ticker == other.ticker &&
                chainLogoUrl == other.chainLogoUrl &&
                contractAddress == other.contractAddress &&
                currency == other.currency &&
                dailyChangePercent == other.dailyChangePercent &&
                exchangeShortName == other.exchangeShortName &&
                logoUrl == other.logoUrl &&
                marketCap == other.marketCap &&
                name == other.name &&
                price == other.price &&
                smartTag == other.smartTag &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                ticker,
                chainLogoUrl,
                contractAddress,
                currency,
                dailyChangePercent,
                exchangeShortName,
                logoUrl,
                marketCap,
                name,
                price,
                smartTag,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Cashtag{ticker=$ticker, chainLogoUrl=$chainLogoUrl, contractAddress=$contractAddress, currency=$currency, dailyChangePercent=$dailyChangePercent, exchangeShortName=$exchangeShortName, logoUrl=$logoUrl, marketCap=$marketCap, name=$name, price=$price, smartTag=$smartTag, additionalProperties=$additionalProperties}"
    }

    /** A hashtag X suggests for the query. */
    class Hashtag
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val hashtag: JsonField<String>,
        private val inline: JsonField<Boolean>,
        private val score: JsonField<Double>,
        private val tokens: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("hashtag") @ExcludeMissing hashtag: JsonField<String> = JsonMissing.of(),
            @JsonProperty("inline") @ExcludeMissing inline: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("score") @ExcludeMissing score: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("tokens")
            @ExcludeMissing
            tokens: JsonField<List<String>> = JsonMissing.of(),
        ) : this(hashtag, inline, score, tokens, mutableMapOf())

        /**
         * Suggested hashtag, with its
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun hashtag(): String = hashtag.getRequired("hashtag")

        /**
         * X's inline flag for the hashtag.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun inline(): Optional<Boolean> = inline.getOptional("inline")

        /**
         * X's rounded relevance score for the hashtag.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun score(): Optional<Double> = score.getOptional("score")

        /**
         * Normalized text tokens X matches the hashtag by.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun tokens(): Optional<List<String>> = tokens.getOptional("tokens")

        /**
         * Returns the raw JSON value of [hashtag].
         *
         * Unlike [hashtag], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hashtag") @ExcludeMissing fun _hashtag(): JsonField<String> = hashtag

        /**
         * Returns the raw JSON value of [inline].
         *
         * Unlike [inline], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("inline") @ExcludeMissing fun _inline(): JsonField<Boolean> = inline

        /**
         * Returns the raw JSON value of [score].
         *
         * Unlike [score], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<Double> = score

        /**
         * Returns the raw JSON value of [tokens].
         *
         * Unlike [tokens], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tokens") @ExcludeMissing fun _tokens(): JsonField<List<String>> = tokens

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
             * Returns a mutable builder for constructing an instance of [Hashtag].
             *
             * The following fields are required:
             * ```java
             * .hashtag()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Hashtag]. */
        class Builder internal constructor() {

            private var hashtag: JsonField<String>? = null
            private var inline: JsonField<Boolean> = JsonMissing.of()
            private var score: JsonField<Double> = JsonMissing.of()
            private var tokens: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(hashtag: Hashtag) = apply {
                this.hashtag = hashtag.hashtag
                inline = hashtag.inline
                score = hashtag.score
                tokens = hashtag.tokens.map { it.toMutableList() }
                additionalProperties = hashtag.additionalProperties.toMutableMap()
            }

            /** Suggested hashtag, with its */
            fun hashtag(hashtag: String) = hashtag(JsonField.of(hashtag))

            /** Sets [Builder.hashtag] to an arbitrary JSON value. */
            fun hashtag(hashtag: JsonField<String>) = apply { this.hashtag = hashtag }

            /** X's inline flag for the hashtag. */
            fun inline(inline: Boolean) = inline(JsonField.of(inline))

            /** Sets [Builder.inline] to an arbitrary JSON value. */
            fun inline(inline: JsonField<Boolean>) = apply { this.inline = inline }

            /** X's rounded relevance score for the hashtag. */
            fun score(score: Double) = score(JsonField.of(score))

            /** Sets [Builder.score] to an arbitrary JSON value. */
            fun score(score: JsonField<Double>) = apply { this.score = score }

            /** Normalized text tokens X matches the hashtag by. */
            fun tokens(tokens: List<String>) = tokens(JsonField.of(tokens))

            /** Sets [Builder.tokens] to an arbitrary JSON value. */
            fun tokens(tokens: JsonField<List<String>>) = apply {
                this.tokens = tokens.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [tokens].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addToken(token: String) = apply {
                tokens =
                    (tokens ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tokens", it).add(token)
                    }
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
             * Returns an immutable instance of [Hashtag].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .hashtag()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Hashtag =
                Hashtag(
                    checkRequired("hashtag", hashtag),
                    inline,
                    score,
                    (tokens ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): Hashtag = apply {
            if (validated) {
                return@apply
            }

            hashtag()
            inline()
            score()
            tokens()
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
            (if (hashtag.asKnown().isPresent) 1 else 0) +
                (if (inline.asKnown().isPresent) 1 else 0) +
                (if (score.asKnown().isPresent) 1 else 0) +
                (tokens.asKnown().getOrNull()?.size ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Hashtag &&
                hashtag == other.hashtag &&
                inline == other.inline &&
                score == other.score &&
                tokens == other.tokens &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(hashtag, inline, score, tokens, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Hashtag{hashtag=$hashtag, inline=$inline, score=$score, tokens=$tokens, additionalProperties=$additionalProperties}"
    }

    /** A search phrase X suggests for the query. */
    class Topic
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val topic: JsonField<String>,
        private val inline: JsonField<Boolean>,
        private val score: JsonField<Double>,
        private val tokens: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("topic") @ExcludeMissing topic: JsonField<String> = JsonMissing.of(),
            @JsonProperty("inline") @ExcludeMissing inline: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("score") @ExcludeMissing score: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("tokens")
            @ExcludeMissing
            tokens: JsonField<List<String>> = JsonMissing.of(),
        ) : this(topic, inline, score, tokens, mutableMapOf())

        /**
         * Suggested search phrase.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun topic(): String = topic.getRequired("topic")

        /**
         * X's inline flag for the phrase.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun inline(): Optional<Boolean> = inline.getOptional("inline")

        /**
         * X's rounded relevance score for the phrase.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun score(): Optional<Double> = score.getOptional("score")

        /**
         * Normalized text tokens X matches the phrase by.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun tokens(): Optional<List<String>> = tokens.getOptional("tokens")

        /**
         * Returns the raw JSON value of [topic].
         *
         * Unlike [topic], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("topic") @ExcludeMissing fun _topic(): JsonField<String> = topic

        /**
         * Returns the raw JSON value of [inline].
         *
         * Unlike [inline], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("inline") @ExcludeMissing fun _inline(): JsonField<Boolean> = inline

        /**
         * Returns the raw JSON value of [score].
         *
         * Unlike [score], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<Double> = score

        /**
         * Returns the raw JSON value of [tokens].
         *
         * Unlike [tokens], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tokens") @ExcludeMissing fun _tokens(): JsonField<List<String>> = tokens

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
             * Returns a mutable builder for constructing an instance of [Topic].
             *
             * The following fields are required:
             * ```java
             * .topic()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Topic]. */
        class Builder internal constructor() {

            private var topic: JsonField<String>? = null
            private var inline: JsonField<Boolean> = JsonMissing.of()
            private var score: JsonField<Double> = JsonMissing.of()
            private var tokens: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(topic: Topic) = apply {
                this.topic = topic.topic
                inline = topic.inline
                score = topic.score
                tokens = topic.tokens.map { it.toMutableList() }
                additionalProperties = topic.additionalProperties.toMutableMap()
            }

            /** Suggested search phrase. */
            fun topic(topic: String) = topic(JsonField.of(topic))

            /** Sets [Builder.topic] to an arbitrary JSON value. */
            fun topic(topic: JsonField<String>) = apply { this.topic = topic }

            /** X's inline flag for the phrase. */
            fun inline(inline: Boolean) = inline(JsonField.of(inline))

            /** Sets [Builder.inline] to an arbitrary JSON value. */
            fun inline(inline: JsonField<Boolean>) = apply { this.inline = inline }

            /** X's rounded relevance score for the phrase. */
            fun score(score: Double) = score(JsonField.of(score))

            /** Sets [Builder.score] to an arbitrary JSON value. */
            fun score(score: JsonField<Double>) = apply { this.score = score }

            /** Normalized text tokens X matches the phrase by. */
            fun tokens(tokens: List<String>) = tokens(JsonField.of(tokens))

            /** Sets [Builder.tokens] to an arbitrary JSON value. */
            fun tokens(tokens: JsonField<List<String>>) = apply {
                this.tokens = tokens.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [tokens].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addToken(token: String) = apply {
                tokens =
                    (tokens ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tokens", it).add(token)
                    }
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
             * Returns an immutable instance of [Topic].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .topic()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Topic =
                Topic(
                    checkRequired("topic", topic),
                    inline,
                    score,
                    (tokens ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): Topic = apply {
            if (validated) {
                return@apply
            }

            topic()
            inline()
            score()
            tokens()
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
            (if (topic.asKnown().isPresent) 1 else 0) +
                (if (inline.asKnown().isPresent) 1 else 0) +
                (if (score.asKnown().isPresent) 1 else 0) +
                (tokens.asKnown().getOrNull()?.size ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Topic &&
                topic == other.topic &&
                inline == other.inline &&
                score == other.score &&
                tokens == other.tokens &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(topic, inline, score, tokens, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Topic{topic=$topic, inline=$inline, score=$score, tokens=$tokens, additionalProperties=$additionalProperties}"
    }

    /** An account X suggests for the query. */
    class User
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val name: JsonField<String>,
        private val username: JsonField<String>,
        private val badges: JsonField<List<Badge>>,
        private val inline: JsonField<Boolean>,
        private val isBlueVerified: JsonField<Boolean>,
        private val isPersonaMediaGenable: JsonField<Boolean>,
        private val isVerified: JsonField<Boolean>,
        private val location: JsonField<String>,
        private val profilePicture: JsonField<String>,
        private val profilePictureOriginal: JsonField<String>,
        private val protected_: JsonField<Boolean>,
        private val score: JsonField<Double>,
        private val tokens: JsonField<List<String>>,
        private val verified: JsonField<Boolean>,
        private val verifiedType: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("username")
            @ExcludeMissing
            username: JsonField<String> = JsonMissing.of(),
            @JsonProperty("badges")
            @ExcludeMissing
            badges: JsonField<List<Badge>> = JsonMissing.of(),
            @JsonProperty("inline") @ExcludeMissing inline: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isBlueVerified")
            @ExcludeMissing
            isBlueVerified: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isPersonaMediaGenable")
            @ExcludeMissing
            isPersonaMediaGenable: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("isVerified")
            @ExcludeMissing
            isVerified: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("location")
            @ExcludeMissing
            location: JsonField<String> = JsonMissing.of(),
            @JsonProperty("profilePicture")
            @ExcludeMissing
            profilePicture: JsonField<String> = JsonMissing.of(),
            @JsonProperty("profilePictureOriginal")
            @ExcludeMissing
            profilePictureOriginal: JsonField<String> = JsonMissing.of(),
            @JsonProperty("protected")
            @ExcludeMissing
            protected_: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("score") @ExcludeMissing score: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("tokens")
            @ExcludeMissing
            tokens: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("verified")
            @ExcludeMissing
            verified: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("verifiedType")
            @ExcludeMissing
            verifiedType: JsonField<String> = JsonMissing.of(),
        ) : this(
            id,
            name,
            username,
            badges,
            inline,
            isBlueVerified,
            isPersonaMediaGenable,
            isVerified,
            location,
            profilePicture,
            profilePictureOriginal,
            protected_,
            score,
            tokens,
            verified,
            verifiedType,
            mutableMapOf(),
        )

        /**
         * X user ID.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun id(): String = id.getRequired("id")

        /**
         * Display name.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun name(): String = name.getRequired("name")

        /**
         * Handle without the @.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null.
         */
        fun username(): String = username.getRequired("username")

        /**
         * Affiliation badges X shows beside the name.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun badges(): Optional<List<Badge>> = badges.getOptional("badges")

        /**
         * X's inline flag for the account.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun inline(): Optional<Boolean> = inline.getOptional("inline")

        /**
         * Whether X shows a blue verification badge.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isBlueVerified(): Optional<Boolean> = isBlueVerified.getOptional("isBlueVerified")

        /**
         * X's flag for whether media can be generated from this account's persona.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isPersonaMediaGenable(): Optional<Boolean> =
            isPersonaMediaGenable.getOptional("isPersonaMediaGenable")

        /**
         * Whether the account holds X's legacy verification.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun isVerified(): Optional<Boolean> = isVerified.getOptional("isVerified")

        /**
         * Public profile location text. Omitted when empty.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun location(): Optional<String> = location.getOptional("location")

        /**
         * Avatar URL.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun profilePicture(): Optional<String> = profilePicture.getOptional("profilePicture")

        /**
         * The same avatar at full size.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun profilePictureOriginal(): Optional<String> =
            profilePictureOriginal.getOptional("profilePictureOriginal")

        /**
         * Whether the account protects its posts.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun protected_(): Optional<Boolean> = protected_.getOptional("protected")

        /**
         * X's rounded relevance score for the account.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun score(): Optional<Double> = score.getOptional("score")

        /**
         * Normalized text tokens X matches the account by.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun tokens(): Optional<List<String>> = tokens.getOptional("tokens")

        /**
         * Whether X shows any verification badge.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun verified(): Optional<Boolean> = verified.getOptional("verified")

        /**
         * Verification category, such as Government or Business. Omitted when X names none.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun verifiedType(): Optional<String> = verifiedType.getOptional("verifiedType")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [username].
         *
         * Unlike [username], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("username") @ExcludeMissing fun _username(): JsonField<String> = username

        /**
         * Returns the raw JSON value of [badges].
         *
         * Unlike [badges], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("badges") @ExcludeMissing fun _badges(): JsonField<List<Badge>> = badges

        /**
         * Returns the raw JSON value of [inline].
         *
         * Unlike [inline], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("inline") @ExcludeMissing fun _inline(): JsonField<Boolean> = inline

        /**
         * Returns the raw JSON value of [isBlueVerified].
         *
         * Unlike [isBlueVerified], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("isBlueVerified")
        @ExcludeMissing
        fun _isBlueVerified(): JsonField<Boolean> = isBlueVerified

        /**
         * Returns the raw JSON value of [isPersonaMediaGenable].
         *
         * Unlike [isPersonaMediaGenable], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("isPersonaMediaGenable")
        @ExcludeMissing
        fun _isPersonaMediaGenable(): JsonField<Boolean> = isPersonaMediaGenable

        /**
         * Returns the raw JSON value of [isVerified].
         *
         * Unlike [isVerified], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isVerified")
        @ExcludeMissing
        fun _isVerified(): JsonField<Boolean> = isVerified

        /**
         * Returns the raw JSON value of [location].
         *
         * Unlike [location], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("location") @ExcludeMissing fun _location(): JsonField<String> = location

        /**
         * Returns the raw JSON value of [profilePicture].
         *
         * Unlike [profilePicture], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("profilePicture")
        @ExcludeMissing
        fun _profilePicture(): JsonField<String> = profilePicture

        /**
         * Returns the raw JSON value of [profilePictureOriginal].
         *
         * Unlike [profilePictureOriginal], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("profilePictureOriginal")
        @ExcludeMissing
        fun _profilePictureOriginal(): JsonField<String> = profilePictureOriginal

        /**
         * Returns the raw JSON value of [protected_].
         *
         * Unlike [protected_], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("protected")
        @ExcludeMissing
        fun _protected_(): JsonField<Boolean> = protected_

        /**
         * Returns the raw JSON value of [score].
         *
         * Unlike [score], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<Double> = score

        /**
         * Returns the raw JSON value of [tokens].
         *
         * Unlike [tokens], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tokens") @ExcludeMissing fun _tokens(): JsonField<List<String>> = tokens

        /**
         * Returns the raw JSON value of [verified].
         *
         * Unlike [verified], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("verified") @ExcludeMissing fun _verified(): JsonField<Boolean> = verified

        /**
         * Returns the raw JSON value of [verifiedType].
         *
         * Unlike [verifiedType], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("verifiedType")
        @ExcludeMissing
        fun _verifiedType(): JsonField<String> = verifiedType

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
             * Returns a mutable builder for constructing an instance of [User].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .name()
             * .username()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [User]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var username: JsonField<String>? = null
            private var badges: JsonField<MutableList<Badge>>? = null
            private var inline: JsonField<Boolean> = JsonMissing.of()
            private var isBlueVerified: JsonField<Boolean> = JsonMissing.of()
            private var isPersonaMediaGenable: JsonField<Boolean> = JsonMissing.of()
            private var isVerified: JsonField<Boolean> = JsonMissing.of()
            private var location: JsonField<String> = JsonMissing.of()
            private var profilePicture: JsonField<String> = JsonMissing.of()
            private var profilePictureOriginal: JsonField<String> = JsonMissing.of()
            private var protected_: JsonField<Boolean> = JsonMissing.of()
            private var score: JsonField<Double> = JsonMissing.of()
            private var tokens: JsonField<MutableList<String>>? = null
            private var verified: JsonField<Boolean> = JsonMissing.of()
            private var verifiedType: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(user: User) = apply {
                id = user.id
                name = user.name
                username = user.username
                badges = user.badges.map { it.toMutableList() }
                inline = user.inline
                isBlueVerified = user.isBlueVerified
                isPersonaMediaGenable = user.isPersonaMediaGenable
                isVerified = user.isVerified
                location = user.location
                profilePicture = user.profilePicture
                profilePictureOriginal = user.profilePictureOriginal
                protected_ = user.protected_
                score = user.score
                tokens = user.tokens.map { it.toMutableList() }
                verified = user.verified
                verifiedType = user.verifiedType
                additionalProperties = user.additionalProperties.toMutableMap()
            }

            /** X user ID. */
            fun id(id: String) = id(JsonField.of(id))

            /** Sets [Builder.id] to an arbitrary JSON value. */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Display name. */
            fun name(name: String) = name(JsonField.of(name))

            /** Sets [Builder.name] to an arbitrary JSON value. */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Handle without the @. */
            fun username(username: String) = username(JsonField.of(username))

            /** Sets [Builder.username] to an arbitrary JSON value. */
            fun username(username: JsonField<String>) = apply { this.username = username }

            /** Affiliation badges X shows beside the name. */
            fun badges(badges: List<Badge>) = badges(JsonField.of(badges))

            /** Sets [Builder.badges] to an arbitrary JSON value. */
            fun badges(badges: JsonField<List<Badge>>) = apply {
                this.badges = badges.map { it.toMutableList() }
            }

            /**
             * Adds a single [Badge] to [badges].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addBadge(badge: Badge) = apply {
                badges =
                    (badges ?: JsonField.of(mutableListOf())).also {
                        checkKnown("badges", it).add(badge)
                    }
            }

            /** X's inline flag for the account. */
            fun inline(inline: Boolean) = inline(JsonField.of(inline))

            /** Sets [Builder.inline] to an arbitrary JSON value. */
            fun inline(inline: JsonField<Boolean>) = apply { this.inline = inline }

            /** Whether X shows a blue verification badge. */
            fun isBlueVerified(isBlueVerified: Boolean) =
                isBlueVerified(JsonField.of(isBlueVerified))

            /** Sets [Builder.isBlueVerified] to an arbitrary JSON value. */
            fun isBlueVerified(isBlueVerified: JsonField<Boolean>) = apply {
                this.isBlueVerified = isBlueVerified
            }

            /** X's flag for whether media can be generated from this account's persona. */
            fun isPersonaMediaGenable(isPersonaMediaGenable: Boolean) =
                isPersonaMediaGenable(JsonField.of(isPersonaMediaGenable))

            /** Sets [Builder.isPersonaMediaGenable] to an arbitrary JSON value. */
            fun isPersonaMediaGenable(isPersonaMediaGenable: JsonField<Boolean>) = apply {
                this.isPersonaMediaGenable = isPersonaMediaGenable
            }

            /** Whether the account holds X's legacy verification. */
            fun isVerified(isVerified: Boolean) = isVerified(JsonField.of(isVerified))

            /** Sets [Builder.isVerified] to an arbitrary JSON value. */
            fun isVerified(isVerified: JsonField<Boolean>) = apply { this.isVerified = isVerified }

            /** Public profile location text. Omitted when empty. */
            fun location(location: String) = location(JsonField.of(location))

            /** Sets [Builder.location] to an arbitrary JSON value. */
            fun location(location: JsonField<String>) = apply { this.location = location }

            /** Avatar URL. */
            fun profilePicture(profilePicture: String) =
                profilePicture(JsonField.of(profilePicture))

            /** Sets [Builder.profilePicture] to an arbitrary JSON value. */
            fun profilePicture(profilePicture: JsonField<String>) = apply {
                this.profilePicture = profilePicture
            }

            /** The same avatar at full size. */
            fun profilePictureOriginal(profilePictureOriginal: String) =
                profilePictureOriginal(JsonField.of(profilePictureOriginal))

            /** Sets [Builder.profilePictureOriginal] to an arbitrary JSON value. */
            fun profilePictureOriginal(profilePictureOriginal: JsonField<String>) = apply {
                this.profilePictureOriginal = profilePictureOriginal
            }

            /** Whether the account protects its posts. */
            fun protected_(protected_: Boolean) = protected_(JsonField.of(protected_))

            /** Sets [Builder.protected_] to an arbitrary JSON value. */
            fun protected_(protected_: JsonField<Boolean>) = apply { this.protected_ = protected_ }

            /** X's rounded relevance score for the account. */
            fun score(score: Double) = score(JsonField.of(score))

            /** Sets [Builder.score] to an arbitrary JSON value. */
            fun score(score: JsonField<Double>) = apply { this.score = score }

            /** Normalized text tokens X matches the account by. */
            fun tokens(tokens: List<String>) = tokens(JsonField.of(tokens))

            /** Sets [Builder.tokens] to an arbitrary JSON value. */
            fun tokens(tokens: JsonField<List<String>>) = apply {
                this.tokens = tokens.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [tokens].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addToken(token: String) = apply {
                tokens =
                    (tokens ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tokens", it).add(token)
                    }
            }

            /** Whether X shows any verification badge. */
            fun verified(verified: Boolean) = verified(JsonField.of(verified))

            /** Sets [Builder.verified] to an arbitrary JSON value. */
            fun verified(verified: JsonField<Boolean>) = apply { this.verified = verified }

            /** Verification category, such as Government or Business. Omitted when X names none. */
            fun verifiedType(verifiedType: String) = verifiedType(JsonField.of(verifiedType))

            /** Sets [Builder.verifiedType] to an arbitrary JSON value. */
            fun verifiedType(verifiedType: JsonField<String>) = apply {
                this.verifiedType = verifiedType
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
             * Returns an immutable instance of [User].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .name()
             * .username()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): User =
                User(
                    checkRequired("id", id),
                    checkRequired("name", name),
                    checkRequired("username", username),
                    (badges ?: JsonMissing.of()).map { it.toImmutable() },
                    inline,
                    isBlueVerified,
                    isPersonaMediaGenable,
                    isVerified,
                    location,
                    profilePicture,
                    profilePictureOriginal,
                    protected_,
                    score,
                    (tokens ?: JsonMissing.of()).map { it.toImmutable() },
                    verified,
                    verifiedType,
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
        fun validate(): User = apply {
            if (validated) {
                return@apply
            }

            id()
            name()
            username()
            badges().ifPresent { it.forEach { it.validate() } }
            inline()
            isBlueVerified()
            isPersonaMediaGenable()
            isVerified()
            location()
            profilePicture()
            profilePictureOriginal()
            protected_()
            score()
            tokens()
            verified()
            verifiedType()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (username.asKnown().isPresent) 1 else 0) +
                (badges.asKnown().getOrNull()?.sumOf { it.validity() } ?: 0) +
                (if (inline.asKnown().isPresent) 1 else 0) +
                (if (isBlueVerified.asKnown().isPresent) 1 else 0) +
                (if (isPersonaMediaGenable.asKnown().isPresent) 1 else 0) +
                (if (isVerified.asKnown().isPresent) 1 else 0) +
                (if (location.asKnown().isPresent) 1 else 0) +
                (if (profilePicture.asKnown().isPresent) 1 else 0) +
                (if (profilePictureOriginal.asKnown().isPresent) 1 else 0) +
                (if (protected_.asKnown().isPresent) 1 else 0) +
                (if (score.asKnown().isPresent) 1 else 0) +
                (tokens.asKnown().getOrNull()?.size ?: 0) +
                (if (verified.asKnown().isPresent) 1 else 0) +
                (if (verifiedType.asKnown().isPresent) 1 else 0)

        /** 1 affiliation badge. */
        class Badge
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val badgeType: JsonField<String>,
            private val badgeUrl: JsonField<String>,
            private val description: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("badgeType")
                @ExcludeMissing
                badgeType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("badgeUrl")
                @ExcludeMissing
                badgeUrl: JsonField<String> = JsonMissing.of(),
                @JsonProperty("description")
                @ExcludeMissing
                description: JsonField<String> = JsonMissing.of(),
            ) : this(badgeType, badgeUrl, description, mutableMapOf())

            /**
             * Kind of badge.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun badgeType(): Optional<String> = badgeType.getOptional("badgeType")

            /**
             * Badge image URL.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun badgeUrl(): Optional<String> = badgeUrl.getOptional("badgeUrl")

            /**
             * Name of the affiliated account.
             *
             * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
             */
            fun description(): Optional<String> = description.getOptional("description")

            /**
             * Returns the raw JSON value of [badgeType].
             *
             * Unlike [badgeType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("badgeType")
            @ExcludeMissing
            fun _badgeType(): JsonField<String> = badgeType

            /**
             * Returns the raw JSON value of [badgeUrl].
             *
             * Unlike [badgeUrl], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("badgeUrl") @ExcludeMissing fun _badgeUrl(): JsonField<String> = badgeUrl

            /**
             * Returns the raw JSON value of [description].
             *
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

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

                /** Returns a mutable builder for constructing an instance of [Badge]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Badge]. */
            class Builder internal constructor() {

                private var badgeType: JsonField<String> = JsonMissing.of()
                private var badgeUrl: JsonField<String> = JsonMissing.of()
                private var description: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(badge: Badge) = apply {
                    badgeType = badge.badgeType
                    badgeUrl = badge.badgeUrl
                    description = badge.description
                    additionalProperties = badge.additionalProperties.toMutableMap()
                }

                /** Kind of badge. */
                fun badgeType(badgeType: String) = badgeType(JsonField.of(badgeType))

                /** Sets [Builder.badgeType] to an arbitrary JSON value. */
                fun badgeType(badgeType: JsonField<String>) = apply { this.badgeType = badgeType }

                /** Badge image URL. */
                fun badgeUrl(badgeUrl: String) = badgeUrl(JsonField.of(badgeUrl))

                /** Sets [Builder.badgeUrl] to an arbitrary JSON value. */
                fun badgeUrl(badgeUrl: JsonField<String>) = apply { this.badgeUrl = badgeUrl }

                /** Name of the affiliated account. */
                fun description(description: String) = description(JsonField.of(description))

                /** Sets [Builder.description] to an arbitrary JSON value. */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

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
                 * Returns an immutable instance of [Badge].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Badge =
                    Badge(badgeType, badgeUrl, description, additionalProperties.toMutableMap())
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
            fun validate(): Badge = apply {
                if (validated) {
                    return@apply
                }

                badgeType()
                badgeUrl()
                description()
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
                (if (badgeType.asKnown().isPresent) 1 else 0) +
                    (if (badgeUrl.asKnown().isPresent) 1 else 0) +
                    (if (description.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Badge &&
                    badgeType == other.badgeType &&
                    badgeUrl == other.badgeUrl &&
                    description == other.description &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(badgeType, badgeUrl, description, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Badge{badgeType=$badgeType, badgeUrl=$badgeUrl, description=$description, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is User &&
                id == other.id &&
                name == other.name &&
                username == other.username &&
                badges == other.badges &&
                inline == other.inline &&
                isBlueVerified == other.isBlueVerified &&
                isPersonaMediaGenable == other.isPersonaMediaGenable &&
                isVerified == other.isVerified &&
                location == other.location &&
                profilePicture == other.profilePicture &&
                profilePictureOriginal == other.profilePictureOriginal &&
                protected_ == other.protected_ &&
                score == other.score &&
                tokens == other.tokens &&
                verified == other.verified &&
                verifiedType == other.verifiedType &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                name,
                username,
                badges,
                inline,
                isBlueVerified,
                isPersonaMediaGenable,
                isVerified,
                location,
                profilePicture,
                profilePictureOriginal,
                protected_,
                score,
                tokens,
                verified,
                verifiedType,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "User{id=$id, name=$name, username=$username, badges=$badges, inline=$inline, isBlueVerified=$isBlueVerified, isPersonaMediaGenable=$isPersonaMediaGenable, isVerified=$isVerified, location=$location, profilePicture=$profilePicture, profilePictureOriginal=$profilePictureOriginal, protected_=$protected_, score=$score, tokens=$tokens, verified=$verified, verifiedType=$verifiedType, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is XAutocompleteSearchResponse &&
            cashtags == other.cashtags &&
            count == other.count &&
            hashtags == other.hashtags &&
            query == other.query &&
            topics == other.topics &&
            users == other.users &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(cashtags, count, hashtags, query, topics, users, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "XAutocompleteSearchResponse{cashtags=$cashtags, count=$count, hashtags=$hashtags, query=$query, topics=$topics, users=$users, additionalProperties=$additionalProperties}"
}
