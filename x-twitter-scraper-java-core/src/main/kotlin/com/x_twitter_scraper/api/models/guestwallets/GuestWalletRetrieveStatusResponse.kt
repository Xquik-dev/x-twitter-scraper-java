// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.guestwallets

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.Enum
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Current balance, usability, and latest guest purchase state. */
class GuestWalletRetrieveStatusResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val balance: JsonField<String>,
    private val latestPurchase: JsonField<LatestPurchase>,
    private val pollAfterSeconds: JsonField<PollAfterSeconds>,
    private val scope: JsonValue,
    private val status: JsonField<Status>,
    private val topUp: JsonField<TopUp>,
    private val usable: JsonField<Boolean>,
    private val walletId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("balance") @ExcludeMissing balance: JsonField<String> = JsonMissing.of(),
        @JsonProperty("latest_purchase")
        @ExcludeMissing
        latestPurchase: JsonField<LatestPurchase> = JsonMissing.of(),
        @JsonProperty("poll_after_seconds")
        @ExcludeMissing
        pollAfterSeconds: JsonField<PollAfterSeconds> = JsonMissing.of(),
        @JsonProperty("scope") @ExcludeMissing scope: JsonValue = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("top_up") @ExcludeMissing topUp: JsonField<TopUp> = JsonMissing.of(),
        @JsonProperty("usable") @ExcludeMissing usable: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("wallet_id") @ExcludeMissing walletId: JsonField<String> = JsonMissing.of(),
    ) : this(
        balance,
        latestPurchase,
        pollAfterSeconds,
        scope,
        status,
        topUp,
        usable,
        walletId,
        mutableMapOf(),
    )

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun balance(): String = balance.getRequired("balance")

    /**
     * Latest guest wallet purchase fulfillment state.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun latestPurchase(): Optional<LatestPurchase> = latestPurchase.getOptional("latest_purchase")

    /**
     * Polling delay while payment is pending. Null means stop.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun pollAfterSeconds(): Optional<PollAfterSeconds> =
        pollAfterSeconds.getOptional("poll_after_seconds")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("paid_reads")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("scope") @ExcludeMissing fun _scope(): JsonValue = scope

    /**
     * Combined wallet and pending-checkout state. A pending top-up can coexist with usable true.
     * Terminal expired or failed states require a new guest wallet.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * Top-up action when usable and no checkout is pending.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun topUp(): Optional<TopUp> = topUp.getOptional("top_up")

    /**
     * Authoritative paid-read readiness. Use instead of status.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun usable(): Boolean = usable.getRequired("usable")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun walletId(): String = walletId.getRequired("wallet_id")

    /**
     * Returns the raw JSON value of [balance].
     *
     * Unlike [balance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("balance") @ExcludeMissing fun _balance(): JsonField<String> = balance

    /**
     * Returns the raw JSON value of [latestPurchase].
     *
     * Unlike [latestPurchase], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("latest_purchase")
    @ExcludeMissing
    fun _latestPurchase(): JsonField<LatestPurchase> = latestPurchase

    /**
     * Returns the raw JSON value of [pollAfterSeconds].
     *
     * Unlike [pollAfterSeconds], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("poll_after_seconds")
    @ExcludeMissing
    fun _pollAfterSeconds(): JsonField<PollAfterSeconds> = pollAfterSeconds

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [topUp].
     *
     * Unlike [topUp], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("top_up") @ExcludeMissing fun _topUp(): JsonField<TopUp> = topUp

    /**
     * Returns the raw JSON value of [usable].
     *
     * Unlike [usable], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usable") @ExcludeMissing fun _usable(): JsonField<Boolean> = usable

    /**
     * Returns the raw JSON value of [walletId].
     *
     * Unlike [walletId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("wallet_id") @ExcludeMissing fun _walletId(): JsonField<String> = walletId

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
         * Returns a mutable builder for constructing an instance of
         * [GuestWalletRetrieveStatusResponse].
         *
         * The following fields are required:
         * ```java
         * .balance()
         * .latestPurchase()
         * .pollAfterSeconds()
         * .status()
         * .topUp()
         * .usable()
         * .walletId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GuestWalletRetrieveStatusResponse]. */
    class Builder internal constructor() {

        private var balance: JsonField<String>? = null
        private var latestPurchase: JsonField<LatestPurchase>? = null
        private var pollAfterSeconds: JsonField<PollAfterSeconds>? = null
        private var scope: JsonValue = JsonValue.from("paid_reads")
        private var status: JsonField<Status>? = null
        private var topUp: JsonField<TopUp>? = null
        private var usable: JsonField<Boolean>? = null
        private var walletId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(guestWalletRetrieveStatusResponse: GuestWalletRetrieveStatusResponse) =
            apply {
                balance = guestWalletRetrieveStatusResponse.balance
                latestPurchase = guestWalletRetrieveStatusResponse.latestPurchase
                pollAfterSeconds = guestWalletRetrieveStatusResponse.pollAfterSeconds
                scope = guestWalletRetrieveStatusResponse.scope
                status = guestWalletRetrieveStatusResponse.status
                topUp = guestWalletRetrieveStatusResponse.topUp
                usable = guestWalletRetrieveStatusResponse.usable
                walletId = guestWalletRetrieveStatusResponse.walletId
                additionalProperties =
                    guestWalletRetrieveStatusResponse.additionalProperties.toMutableMap()
            }

        fun balance(balance: String) = balance(JsonField.of(balance))

        /**
         * Sets [Builder.balance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.balance] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun balance(balance: JsonField<String>) = apply { this.balance = balance }

        /** Latest guest wallet purchase fulfillment state. */
        fun latestPurchase(latestPurchase: LatestPurchase?) =
            latestPurchase(JsonField.ofNullable(latestPurchase))

        /** Alias for calling [Builder.latestPurchase] with `latestPurchase.orElse(null)`. */
        fun latestPurchase(latestPurchase: Optional<LatestPurchase>) =
            latestPurchase(latestPurchase.getOrNull())

        /**
         * Sets [Builder.latestPurchase] to an arbitrary JSON value.
         *
         * You should usually call [Builder.latestPurchase] with a well-typed [LatestPurchase] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun latestPurchase(latestPurchase: JsonField<LatestPurchase>) = apply {
            this.latestPurchase = latestPurchase
        }

        /** Polling delay while payment is pending. Null means stop. */
        fun pollAfterSeconds(pollAfterSeconds: PollAfterSeconds?) =
            pollAfterSeconds(JsonField.ofNullable(pollAfterSeconds))

        /** Alias for calling [Builder.pollAfterSeconds] with `pollAfterSeconds.orElse(null)`. */
        fun pollAfterSeconds(pollAfterSeconds: Optional<PollAfterSeconds>) =
            pollAfterSeconds(pollAfterSeconds.getOrNull())

        /**
         * Sets [Builder.pollAfterSeconds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pollAfterSeconds] with a well-typed [PollAfterSeconds]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun pollAfterSeconds(pollAfterSeconds: JsonField<PollAfterSeconds>) = apply {
            this.pollAfterSeconds = pollAfterSeconds
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("paid_reads")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun scope(scope: JsonValue) = apply { this.scope = scope }

        /**
         * Combined wallet and pending-checkout state. A pending top-up can coexist with usable
         * true. Terminal expired or failed states require a new guest wallet.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** Top-up action when usable and no checkout is pending. */
        fun topUp(topUp: TopUp?) = topUp(JsonField.ofNullable(topUp))

        /** Alias for calling [Builder.topUp] with `topUp.orElse(null)`. */
        fun topUp(topUp: Optional<TopUp>) = topUp(topUp.getOrNull())

        /**
         * Sets [Builder.topUp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.topUp] with a well-typed [TopUp] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun topUp(topUp: JsonField<TopUp>) = apply { this.topUp = topUp }

        /** Authoritative paid-read readiness. Use instead of status. */
        fun usable(usable: Boolean) = usable(JsonField.of(usable))

        /**
         * Sets [Builder.usable] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usable] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun usable(usable: JsonField<Boolean>) = apply { this.usable = usable }

        fun walletId(walletId: String) = walletId(JsonField.of(walletId))

        /**
         * Sets [Builder.walletId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.walletId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun walletId(walletId: JsonField<String>) = apply { this.walletId = walletId }

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
         * Returns an immutable instance of [GuestWalletRetrieveStatusResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .balance()
         * .latestPurchase()
         * .pollAfterSeconds()
         * .status()
         * .topUp()
         * .usable()
         * .walletId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): GuestWalletRetrieveStatusResponse =
            GuestWalletRetrieveStatusResponse(
                checkRequired("balance", balance),
                checkRequired("latestPurchase", latestPurchase),
                checkRequired("pollAfterSeconds", pollAfterSeconds),
                scope,
                checkRequired("status", status),
                checkRequired("topUp", topUp),
                checkRequired("usable", usable),
                checkRequired("walletId", walletId),
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
    fun validate(): GuestWalletRetrieveStatusResponse = apply {
        if (validated) {
            return@apply
        }

        balance()
        latestPurchase().ifPresent { it.validate() }
        pollAfterSeconds().ifPresent { it.validate() }
        _scope().let {
            if (it != JsonValue.from("paid_reads")) {
                throw XTwitterScraperInvalidDataException("'scope' is invalid, received $it")
            }
        }
        status().validate()
        topUp().ifPresent { it.validate() }
        usable()
        walletId()
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
        (if (balance.asKnown().isPresent) 1 else 0) +
            (latestPurchase.asKnown().getOrNull()?.validity() ?: 0) +
            (pollAfterSeconds.asKnown().getOrNull()?.validity() ?: 0) +
            scope.let { if (it == JsonValue.from("paid_reads")) 1 else 0 } +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (topUp.asKnown().getOrNull()?.validity() ?: 0) +
            (if (usable.asKnown().isPresent) 1 else 0) +
            (if (walletId.asKnown().isPresent) 1 else 0)

    /** Latest guest wallet purchase fulfillment state. */
    class LatestPurchase
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val amount: JsonField<GuestWalletAmount>,
        private val checkoutUrl: JsonField<String>,
        private val credits: JsonField<String>,
        private val expiresAt: JsonField<OffsetDateTime>,
        private val purchaseId: JsonField<String>,
        private val status: JsonField<Status>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("amount")
            @ExcludeMissing
            amount: JsonField<GuestWalletAmount> = JsonMissing.of(),
            @JsonProperty("checkout_url")
            @ExcludeMissing
            checkoutUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("credits") @ExcludeMissing credits: JsonField<String> = JsonMissing.of(),
            @JsonProperty("expires_at")
            @ExcludeMissing
            expiresAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("purchase_id")
            @ExcludeMissing
            purchaseId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        ) : this(amount, checkoutUrl, credits, expiresAt, purchaseId, status, mutableMapOf())

        /**
         * Confirmed USD amount for a guest wallet purchase.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun amount(): GuestWalletAmount = amount.getRequired("amount")

        /**
         * Present only while the purchase is pending.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun checkoutUrl(): Optional<String> = checkoutUrl.getOptional("checkout_url")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun credits(): String = credits.getRequired("credits")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun expiresAt(): OffsetDateTime = expiresAt.getRequired("expires_at")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun purchaseId(): String = purchaseId.getRequired("purchase_id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun status(): Status = status.getRequired("status")

        /**
         * Returns the raw JSON value of [amount].
         *
         * Unlike [amount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("amount") @ExcludeMissing fun _amount(): JsonField<GuestWalletAmount> = amount

        /**
         * Returns the raw JSON value of [checkoutUrl].
         *
         * Unlike [checkoutUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("checkout_url")
        @ExcludeMissing
        fun _checkoutUrl(): JsonField<String> = checkoutUrl

        /**
         * Returns the raw JSON value of [credits].
         *
         * Unlike [credits], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("credits") @ExcludeMissing fun _credits(): JsonField<String> = credits

        /**
         * Returns the raw JSON value of [expiresAt].
         *
         * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("expires_at")
        @ExcludeMissing
        fun _expiresAt(): JsonField<OffsetDateTime> = expiresAt

        /**
         * Returns the raw JSON value of [purchaseId].
         *
         * Unlike [purchaseId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("purchase_id")
        @ExcludeMissing
        fun _purchaseId(): JsonField<String> = purchaseId

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
             * Returns a mutable builder for constructing an instance of [LatestPurchase].
             *
             * The following fields are required:
             * ```java
             * .amount()
             * .checkoutUrl()
             * .credits()
             * .expiresAt()
             * .purchaseId()
             * .status()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [LatestPurchase]. */
        class Builder internal constructor() {

            private var amount: JsonField<GuestWalletAmount>? = null
            private var checkoutUrl: JsonField<String>? = null
            private var credits: JsonField<String>? = null
            private var expiresAt: JsonField<OffsetDateTime>? = null
            private var purchaseId: JsonField<String>? = null
            private var status: JsonField<Status>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(latestPurchase: LatestPurchase) = apply {
                amount = latestPurchase.amount
                checkoutUrl = latestPurchase.checkoutUrl
                credits = latestPurchase.credits
                expiresAt = latestPurchase.expiresAt
                purchaseId = latestPurchase.purchaseId
                status = latestPurchase.status
                additionalProperties = latestPurchase.additionalProperties.toMutableMap()
            }

            /** Confirmed USD amount for a guest wallet purchase. */
            fun amount(amount: GuestWalletAmount) = amount(JsonField.of(amount))

            /**
             * Sets [Builder.amount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.amount] with a well-typed [GuestWalletAmount] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun amount(amount: JsonField<GuestWalletAmount>) = apply { this.amount = amount }

            /** Present only while the purchase is pending. */
            fun checkoutUrl(checkoutUrl: String?) = checkoutUrl(JsonField.ofNullable(checkoutUrl))

            /** Alias for calling [Builder.checkoutUrl] with `checkoutUrl.orElse(null)`. */
            fun checkoutUrl(checkoutUrl: Optional<String>) = checkoutUrl(checkoutUrl.getOrNull())

            /**
             * Sets [Builder.checkoutUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.checkoutUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun checkoutUrl(checkoutUrl: JsonField<String>) = apply {
                this.checkoutUrl = checkoutUrl
            }

            fun credits(credits: String) = credits(JsonField.of(credits))

            /**
             * Sets [Builder.credits] to an arbitrary JSON value.
             *
             * You should usually call [Builder.credits] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun credits(credits: JsonField<String>) = apply { this.credits = credits }

            fun expiresAt(expiresAt: OffsetDateTime) = expiresAt(JsonField.of(expiresAt))

            /**
             * Sets [Builder.expiresAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expiresAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expiresAt(expiresAt: JsonField<OffsetDateTime>) = apply {
                this.expiresAt = expiresAt
            }

            fun purchaseId(purchaseId: String) = purchaseId(JsonField.of(purchaseId))

            /**
             * Sets [Builder.purchaseId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.purchaseId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun purchaseId(purchaseId: JsonField<String>) = apply { this.purchaseId = purchaseId }

            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

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
             * Returns an immutable instance of [LatestPurchase].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .amount()
             * .checkoutUrl()
             * .credits()
             * .expiresAt()
             * .purchaseId()
             * .status()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): LatestPurchase =
                LatestPurchase(
                    checkRequired("amount", amount),
                    checkRequired("checkoutUrl", checkoutUrl),
                    checkRequired("credits", credits),
                    checkRequired("expiresAt", expiresAt),
                    checkRequired("purchaseId", purchaseId),
                    checkRequired("status", status),
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
        fun validate(): LatestPurchase = apply {
            if (validated) {
                return@apply
            }

            amount().validate()
            checkoutUrl()
            credits()
            expiresAt()
            purchaseId()
            status().validate()
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
            (amount.asKnown().getOrNull()?.validity() ?: 0) +
                (if (checkoutUrl.asKnown().isPresent) 1 else 0) +
                (if (credits.asKnown().isPresent) 1 else 0) +
                (if (expiresAt.asKnown().isPresent) 1 else 0) +
                (if (purchaseId.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0)

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val CREATING = of("creating")

                @JvmField val PENDING = of("pending")

                @JvmField val PAID = of("paid")

                @JvmField val EXPIRED = of("expired")

                @JvmField val FAILED = of("failed")

                @JvmField val REFUNDED = of("refunded")

                @JvmField val DISPUTED = of("disputed")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                CREATING,
                PENDING,
                PAID,
                EXPIRED,
                FAILED,
                REFUNDED,
                DISPUTED,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                CREATING,
                PENDING,
                PAID,
                EXPIRED,
                FAILED,
                REFUNDED,
                DISPUTED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    CREATING -> Value.CREATING
                    PENDING -> Value.PENDING
                    PAID -> Value.PAID
                    EXPIRED -> Value.EXPIRED
                    FAILED -> Value.FAILED
                    REFUNDED -> Value.REFUNDED
                    DISPUTED -> Value.DISPUTED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    CREATING -> Known.CREATING
                    PENDING -> Known.PENDING
                    PAID -> Known.PAID
                    EXPIRED -> Known.EXPIRED
                    FAILED -> Known.FAILED
                    REFUNDED -> Known.REFUNDED
                    DISPUTED -> Known.DISPUTED
                    else -> throw XTwitterScraperInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws XTwitterScraperInvalidDataException if this class instance's value does not
             *   have the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    XTwitterScraperInvalidDataException("Value is not a String")
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
            fun validate(): Status = apply {
                if (validated) {
                    return@apply
                }

                known()
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
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Status && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is LatestPurchase &&
                amount == other.amount &&
                checkoutUrl == other.checkoutUrl &&
                credits == other.credits &&
                expiresAt == other.expiresAt &&
                purchaseId == other.purchaseId &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                amount,
                checkoutUrl,
                credits,
                expiresAt,
                purchaseId,
                status,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "LatestPurchase{amount=$amount, checkoutUrl=$checkoutUrl, credits=$credits, expiresAt=$expiresAt, purchaseId=$purchaseId, status=$status, additionalProperties=$additionalProperties}"
    }

    /** Polling delay while payment is pending. Null means stop. */
    class PollAfterSeconds @JsonCreator private constructor(private val value: JsonField<Long>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Long> = value

        companion object {

            @JvmField val _2 = of(2L)

            @JvmStatic fun of(value: Long) = PollAfterSeconds(JsonField.of(value))
        }

        /** An enum containing [PollAfterSeconds]'s known values. */
        enum class Known {
            _2
        }

        /**
         * An enum containing [PollAfterSeconds]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [PollAfterSeconds] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            _2,
            /**
             * An enum member indicating that [PollAfterSeconds] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                _2 -> Value._2
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                _2 -> Known._2
                else ->
                    throw XTwitterScraperInvalidDataException("Unknown PollAfterSeconds: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asLong(): Long =
            _value().asNumber().getOrNull()?.let {
                if (it.toDouble() % 1 == 0.0) it.toLong() else null
            } ?: throw XTwitterScraperInvalidDataException("Value is not a Long")

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
        fun validate(): PollAfterSeconds = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PollAfterSeconds && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Combined wallet and pending-checkout state. A pending top-up can coexist with usable true.
     * Terminal expired or failed states require a new guest wallet.
     */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val ACTIVE = of("active")

            @JvmField val PENDING = of("pending")

            @JvmField val EXPIRED = of("expired")

            @JvmField val FAILED = of("failed")

            @JvmField val FROZEN = of("frozen")

            @JvmField val CLOSED = of("closed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            ACTIVE,
            PENDING,
            EXPIRED,
            FAILED,
            FROZEN,
            CLOSED,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            ACTIVE,
            PENDING,
            EXPIRED,
            FAILED,
            FROZEN,
            CLOSED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                ACTIVE -> Value.ACTIVE
                PENDING -> Value.PENDING
                EXPIRED -> Value.EXPIRED
                FAILED -> Value.FAILED
                FROZEN -> Value.FROZEN
                CLOSED -> Value.CLOSED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                ACTIVE -> Known.ACTIVE
                PENDING -> Known.PENDING
                EXPIRED -> Known.EXPIRED
                FAILED -> Known.FAILED
                FROZEN -> Known.FROZEN
                CLOSED -> Known.CLOSED
                else -> throw XTwitterScraperInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws XTwitterScraperInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                XTwitterScraperInvalidDataException("Value is not a String")
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
        fun validate(): Status = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Top-up action when usable and no checkout is pending. */
    class TopUp
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val method: JsonValue,
        private val path: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("method") @ExcludeMissing method: JsonValue = JsonMissing.of(),
            @JsonProperty("path") @ExcludeMissing path: JsonValue = JsonMissing.of(),
        ) : this(method, path, mutableMapOf())

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("POST")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("method") @ExcludeMissing fun _method(): JsonValue = method

        /**
         * Expected to always return the following:
         * ```java
         * JsonValue.from("/api/v1/guest-wallets/topups")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("path") @ExcludeMissing fun _path(): JsonValue = path

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

            /** Returns a mutable builder for constructing an instance of [TopUp]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TopUp]. */
        class Builder internal constructor() {

            private var method: JsonValue = JsonValue.from("POST")
            private var path: JsonValue = JsonValue.from("/api/v1/guest-wallets/topups")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(topUp: TopUp) = apply {
                method = topUp.method
                path = topUp.path
                additionalProperties = topUp.additionalProperties.toMutableMap()
            }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("POST")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun method(method: JsonValue) = apply { this.method = method }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("/api/v1/guest-wallets/topups")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun path(path: JsonValue) = apply { this.path = path }

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
             * Returns an immutable instance of [TopUp].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): TopUp = TopUp(method, path, additionalProperties.toMutableMap())
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
        fun validate(): TopUp = apply {
            if (validated) {
                return@apply
            }

            _method().let {
                if (it != JsonValue.from("POST")) {
                    throw XTwitterScraperInvalidDataException("'method' is invalid, received $it")
                }
            }
            _path().let {
                if (it != JsonValue.from("/api/v1/guest-wallets/topups")) {
                    throw XTwitterScraperInvalidDataException("'path' is invalid, received $it")
                }
            }
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
            method.let { if (it == JsonValue.from("POST")) 1 else 0 } +
                path.let { if (it == JsonValue.from("/api/v1/guest-wallets/topups")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TopUp &&
                method == other.method &&
                path == other.path &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(method, path, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TopUp{method=$method, path=$path, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is GuestWalletRetrieveStatusResponse &&
            balance == other.balance &&
            latestPurchase == other.latestPurchase &&
            pollAfterSeconds == other.pollAfterSeconds &&
            scope == other.scope &&
            status == other.status &&
            topUp == other.topUp &&
            usable == other.usable &&
            walletId == other.walletId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            balance,
            latestPurchase,
            pollAfterSeconds,
            scope,
            status,
            topUp,
            usable,
            walletId,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "GuestWalletRetrieveStatusResponse{balance=$balance, latestPurchase=$latestPurchase, pollAfterSeconds=$pollAfterSeconds, scope=$scope, status=$status, topUp=$topUp, usable=$usable, walletId=$walletId, additionalProperties=$additionalProperties}"
}
