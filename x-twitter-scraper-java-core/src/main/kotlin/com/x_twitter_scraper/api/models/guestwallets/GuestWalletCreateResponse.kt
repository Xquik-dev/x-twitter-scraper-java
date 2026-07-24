// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

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
import kotlin.jvm.optionals.getOrNull

/** Initial guest wallet response containing the one-time key. */
class GuestWalletCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val accountRequired: JsonValue,
    private val amount: JsonField<GuestWalletAmount>,
    private val apiKey: JsonField<String>,
    private val authorization: JsonField<Authorization>,
    private val checkoutUrl: JsonField<String>,
    private val credentialNotice: JsonValue,
    private val credits: JsonField<String>,
    private val expiresAt: JsonField<OffsetDateTime>,
    private val instructions: JsonValue,
    private val pollAfterSeconds: JsonValue,
    private val purchaseId: JsonField<String>,
    private val requiresUserInteraction: JsonValue,
    private val status: JsonField<Status>,
    private val statusUrl: JsonValue,
    private val walletId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("account_required")
        @ExcludeMissing
        accountRequired: JsonValue = JsonMissing.of(),
        @JsonProperty("amount")
        @ExcludeMissing
        amount: JsonField<GuestWalletAmount> = JsonMissing.of(),
        @JsonProperty("api_key") @ExcludeMissing apiKey: JsonField<String> = JsonMissing.of(),
        @JsonProperty("authorization")
        @ExcludeMissing
        authorization: JsonField<Authorization> = JsonMissing.of(),
        @JsonProperty("checkout_url")
        @ExcludeMissing
        checkoutUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("credential_notice")
        @ExcludeMissing
        credentialNotice: JsonValue = JsonMissing.of(),
        @JsonProperty("credits") @ExcludeMissing credits: JsonField<String> = JsonMissing.of(),
        @JsonProperty("expires_at")
        @ExcludeMissing
        expiresAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("instructions") @ExcludeMissing instructions: JsonValue = JsonMissing.of(),
        @JsonProperty("poll_after_seconds")
        @ExcludeMissing
        pollAfterSeconds: JsonValue = JsonMissing.of(),
        @JsonProperty("purchase_id")
        @ExcludeMissing
        purchaseId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("requires_user_interaction")
        @ExcludeMissing
        requiresUserInteraction: JsonValue = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("status_url") @ExcludeMissing statusUrl: JsonValue = JsonMissing.of(),
        @JsonProperty("wallet_id") @ExcludeMissing walletId: JsonField<String> = JsonMissing.of(),
    ) : this(
        accountRequired,
        amount,
        apiKey,
        authorization,
        checkoutUrl,
        credentialNotice,
        credits,
        expiresAt,
        instructions,
        pollAfterSeconds,
        purchaseId,
        requiresUserInteraction,
        status,
        statusUrl,
        walletId,
        mutableMapOf(),
    )

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from(false)
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("account_required")
    @ExcludeMissing
    fun _accountRequired(): JsonValue = accountRequired

    /**
     * Confirmed USD amount for a guest wallet purchase.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun amount(): GuestWalletAmount = amount.getRequired("amount")

    /**
     * Paid-read bearer credential returned only by initial creation. Store it as a secret. Never
     * place it in a URL or log.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun apiKey(): String = apiKey.getRequired("api_key")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun authorization(): Authorization = authorization.getRequired("authorization")

    /**
     * Raw Stripe-hosted checkout URL for user interaction.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun checkoutUrl(): String = checkoutUrl.getRequired("checkout_url")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("Store api_key and the Idempotency-Key securely before sharing checkout_url. No email recovery is available.")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("credential_notice")
    @ExcludeMissing
    fun _credentialNotice(): JsonValue = credentialNotice

    /**
     * Credits granted after verified payment.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun credits(): String = credits.getRequired("credits")

    /**
     * Time when the pending checkout expires.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun expiresAt(): OffsetDateTime = expiresAt.getRequired("expires_at")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("Give checkout_url to the user. They must complete payment on Stripe. Never submit payment for them. After payment, poll status_url every poll_after_seconds until latest_purchase.status is no longer pending.")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("instructions") @ExcludeMissing fun _instructions(): JsonValue = instructions

    /**
     * Wait at least this long before polling status_url.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from(2)
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("poll_after_seconds")
    @ExcludeMissing
    fun _pollAfterSeconds(): JsonValue = pollAfterSeconds

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun purchaseId(): String = purchaseId.getRequired("purchase_id")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from(true)
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("requires_user_interaction")
    @ExcludeMissing
    fun _requiresUserInteraction(): JsonValue = requiresUserInteraction

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from("https://xquik.com/api/v1/guest-wallets/status")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("status_url") @ExcludeMissing fun _statusUrl(): JsonValue = statusUrl

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun walletId(): String = walletId.getRequired("wallet_id")

    /**
     * Returns the raw JSON value of [amount].
     *
     * Unlike [amount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("amount") @ExcludeMissing fun _amount(): JsonField<GuestWalletAmount> = amount

    /**
     * Returns the raw JSON value of [apiKey].
     *
     * Unlike [apiKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("api_key") @ExcludeMissing fun _apiKey(): JsonField<String> = apiKey

    /**
     * Returns the raw JSON value of [authorization].
     *
     * Unlike [authorization], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("authorization")
    @ExcludeMissing
    fun _authorization(): JsonField<Authorization> = authorization

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
    @JsonProperty("purchase_id") @ExcludeMissing fun _purchaseId(): JsonField<String> = purchaseId

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
         * Returns a mutable builder for constructing an instance of [GuestWalletCreateResponse].
         *
         * The following fields are required:
         * ```java
         * .amount()
         * .apiKey()
         * .authorization()
         * .checkoutUrl()
         * .credits()
         * .expiresAt()
         * .purchaseId()
         * .status()
         * .walletId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GuestWalletCreateResponse]. */
    class Builder internal constructor() {

        private var accountRequired: JsonValue = JsonValue.from(false)
        private var amount: JsonField<GuestWalletAmount>? = null
        private var apiKey: JsonField<String>? = null
        private var authorization: JsonField<Authorization>? = null
        private var checkoutUrl: JsonField<String>? = null
        private var credentialNotice: JsonValue =
            JsonValue.from(
                "Store api_key and the Idempotency-Key securely before sharing checkout_url. No email recovery is available."
            )
        private var credits: JsonField<String>? = null
        private var expiresAt: JsonField<OffsetDateTime>? = null
        private var instructions: JsonValue =
            JsonValue.from(
                "Give checkout_url to the user. They must complete payment on Stripe. Never submit payment for them. After payment, poll status_url every poll_after_seconds until latest_purchase.status is no longer pending."
            )
        private var pollAfterSeconds: JsonValue = JsonValue.from(2)
        private var purchaseId: JsonField<String>? = null
        private var requiresUserInteraction: JsonValue = JsonValue.from(true)
        private var status: JsonField<Status>? = null
        private var statusUrl: JsonValue =
            JsonValue.from("https://xquik.com/api/v1/guest-wallets/status")
        private var walletId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(guestWalletCreateResponse: GuestWalletCreateResponse) = apply {
            accountRequired = guestWalletCreateResponse.accountRequired
            amount = guestWalletCreateResponse.amount
            apiKey = guestWalletCreateResponse.apiKey
            authorization = guestWalletCreateResponse.authorization
            checkoutUrl = guestWalletCreateResponse.checkoutUrl
            credentialNotice = guestWalletCreateResponse.credentialNotice
            credits = guestWalletCreateResponse.credits
            expiresAt = guestWalletCreateResponse.expiresAt
            instructions = guestWalletCreateResponse.instructions
            pollAfterSeconds = guestWalletCreateResponse.pollAfterSeconds
            purchaseId = guestWalletCreateResponse.purchaseId
            requiresUserInteraction = guestWalletCreateResponse.requiresUserInteraction
            status = guestWalletCreateResponse.status
            statusUrl = guestWalletCreateResponse.statusUrl
            walletId = guestWalletCreateResponse.walletId
            additionalProperties = guestWalletCreateResponse.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from(false)
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun accountRequired(accountRequired: JsonValue) = apply {
            this.accountRequired = accountRequired
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

        /**
         * Paid-read bearer credential returned only by initial creation. Store it as a secret.
         * Never place it in a URL or log.
         */
        fun apiKey(apiKey: String) = apiKey(JsonField.of(apiKey))

        /**
         * Sets [Builder.apiKey] to an arbitrary JSON value.
         *
         * You should usually call [Builder.apiKey] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun apiKey(apiKey: JsonField<String>) = apply { this.apiKey = apiKey }

        fun authorization(authorization: Authorization) = authorization(JsonField.of(authorization))

        /**
         * Sets [Builder.authorization] to an arbitrary JSON value.
         *
         * You should usually call [Builder.authorization] with a well-typed [Authorization] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun authorization(authorization: JsonField<Authorization>) = apply {
            this.authorization = authorization
        }

        /** Raw Stripe-hosted checkout URL for user interaction. */
        fun checkoutUrl(checkoutUrl: String) = checkoutUrl(JsonField.of(checkoutUrl))

        /**
         * Sets [Builder.checkoutUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.checkoutUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun checkoutUrl(checkoutUrl: JsonField<String>) = apply { this.checkoutUrl = checkoutUrl }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("Store api_key and the Idempotency-Key securely before sharing checkout_url. No email recovery is available.")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun credentialNotice(credentialNotice: JsonValue) = apply {
            this.credentialNotice = credentialNotice
        }

        /** Credits granted after verified payment. */
        fun credits(credits: String) = credits(JsonField.of(credits))

        /**
         * Sets [Builder.credits] to an arbitrary JSON value.
         *
         * You should usually call [Builder.credits] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun credits(credits: JsonField<String>) = apply { this.credits = credits }

        /** Time when the pending checkout expires. */
        fun expiresAt(expiresAt: OffsetDateTime) = expiresAt(JsonField.of(expiresAt))

        /**
         * Sets [Builder.expiresAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun expiresAt(expiresAt: JsonField<OffsetDateTime>) = apply { this.expiresAt = expiresAt }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("Give checkout_url to the user. They must complete payment on Stripe. Never submit payment for them. After payment, poll status_url every poll_after_seconds until latest_purchase.status is no longer pending.")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun instructions(instructions: JsonValue) = apply { this.instructions = instructions }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from(2)
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun pollAfterSeconds(pollAfterSeconds: JsonValue) = apply {
            this.pollAfterSeconds = pollAfterSeconds
        }

        fun purchaseId(purchaseId: String) = purchaseId(JsonField.of(purchaseId))

        /**
         * Sets [Builder.purchaseId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.purchaseId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun purchaseId(purchaseId: JsonField<String>) = apply { this.purchaseId = purchaseId }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from(true)
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun requiresUserInteraction(requiresUserInteraction: JsonValue) = apply {
            this.requiresUserInteraction = requiresUserInteraction
        }

        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("https://xquik.com/api/v1/guest-wallets/status")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun statusUrl(statusUrl: JsonValue) = apply { this.statusUrl = statusUrl }

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
         * Returns an immutable instance of [GuestWalletCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .amount()
         * .apiKey()
         * .authorization()
         * .checkoutUrl()
         * .credits()
         * .expiresAt()
         * .purchaseId()
         * .status()
         * .walletId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): GuestWalletCreateResponse =
            GuestWalletCreateResponse(
                accountRequired,
                checkRequired("amount", amount),
                checkRequired("apiKey", apiKey),
                checkRequired("authorization", authorization),
                checkRequired("checkoutUrl", checkoutUrl),
                credentialNotice,
                checkRequired("credits", credits),
                checkRequired("expiresAt", expiresAt),
                instructions,
                pollAfterSeconds,
                checkRequired("purchaseId", purchaseId),
                requiresUserInteraction,
                checkRequired("status", status),
                statusUrl,
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
    fun validate(): GuestWalletCreateResponse = apply {
        if (validated) {
            return@apply
        }

        _accountRequired().let {
            if (it != JsonValue.from(false)) {
                throw XTwitterScraperInvalidDataException(
                    "'accountRequired' is invalid, received $it"
                )
            }
        }
        amount().validate()
        apiKey()
        authorization().validate()
        checkoutUrl()
        _credentialNotice().let {
            if (
                it !=
                    JsonValue.from(
                        "Store api_key and the Idempotency-Key securely before sharing checkout_url. No email recovery is available."
                    )
            ) {
                throw XTwitterScraperInvalidDataException(
                    "'credentialNotice' is invalid, received $it"
                )
            }
        }
        credits()
        expiresAt()
        _instructions().let {
            if (
                it !=
                    JsonValue.from(
                        "Give checkout_url to the user. They must complete payment on Stripe. Never submit payment for them. After payment, poll status_url every poll_after_seconds until latest_purchase.status is no longer pending."
                    )
            ) {
                throw XTwitterScraperInvalidDataException("'instructions' is invalid, received $it")
            }
        }
        _pollAfterSeconds().let {
            if (it != JsonValue.from(2)) {
                throw XTwitterScraperInvalidDataException(
                    "'pollAfterSeconds' is invalid, received $it"
                )
            }
        }
        purchaseId()
        _requiresUserInteraction().let {
            if (it != JsonValue.from(true)) {
                throw XTwitterScraperInvalidDataException(
                    "'requiresUserInteraction' is invalid, received $it"
                )
            }
        }
        status().validate()
        _statusUrl().let {
            if (it != JsonValue.from("https://xquik.com/api/v1/guest-wallets/status")) {
                throw XTwitterScraperInvalidDataException("'statusUrl' is invalid, received $it")
            }
        }
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
        accountRequired.let { if (it == JsonValue.from(false)) 1 else 0 } +
            (amount.asKnown().getOrNull()?.validity() ?: 0) +
            (if (apiKey.asKnown().isPresent) 1 else 0) +
            (authorization.asKnown().getOrNull()?.validity() ?: 0) +
            (if (checkoutUrl.asKnown().isPresent) 1 else 0) +
            credentialNotice.let {
                if (
                    it ==
                        JsonValue.from(
                            "Store api_key and the Idempotency-Key securely before sharing checkout_url. No email recovery is available."
                        )
                )
                    1
                else 0
            } +
            (if (credits.asKnown().isPresent) 1 else 0) +
            (if (expiresAt.asKnown().isPresent) 1 else 0) +
            instructions.let {
                if (
                    it ==
                        JsonValue.from(
                            "Give checkout_url to the user. They must complete payment on Stripe. Never submit payment for them. After payment, poll status_url every poll_after_seconds until latest_purchase.status is no longer pending."
                        )
                )
                    1
                else 0
            } +
            pollAfterSeconds.let { if (it == JsonValue.from(2)) 1 else 0 } +
            (if (purchaseId.asKnown().isPresent) 1 else 0) +
            requiresUserInteraction.let { if (it == JsonValue.from(true)) 1 else 0 } +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            statusUrl.let {
                if (it == JsonValue.from("https://xquik.com/api/v1/guest-wallets/status")) 1 else 0
            } +
            (if (walletId.asKnown().isPresent) 1 else 0)

    class Authorization
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val header: JsonField<Header>,
        private val scheme: JsonField<Scheme>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("header") @ExcludeMissing header: JsonField<Header> = JsonMissing.of(),
            @JsonProperty("scheme") @ExcludeMissing scheme: JsonField<Scheme> = JsonMissing.of(),
        ) : this(header, scheme, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun header(): Header = header.getRequired("header")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun scheme(): Scheme = scheme.getRequired("scheme")

        /**
         * Returns the raw JSON value of [header].
         *
         * Unlike [header], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("header") @ExcludeMissing fun _header(): JsonField<Header> = header

        /**
         * Returns the raw JSON value of [scheme].
         *
         * Unlike [scheme], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("scheme") @ExcludeMissing fun _scheme(): JsonField<Scheme> = scheme

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
             * Returns a mutable builder for constructing an instance of [Authorization].
             *
             * The following fields are required:
             * ```java
             * .header()
             * .scheme()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Authorization]. */
        class Builder internal constructor() {

            private var header: JsonField<Header>? = null
            private var scheme: JsonField<Scheme>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(authorization: Authorization) = apply {
                header = authorization.header
                scheme = authorization.scheme
                additionalProperties = authorization.additionalProperties.toMutableMap()
            }

            fun header(header: Header) = header(JsonField.of(header))

            /**
             * Sets [Builder.header] to an arbitrary JSON value.
             *
             * You should usually call [Builder.header] with a well-typed [Header] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun header(header: JsonField<Header>) = apply { this.header = header }

            fun scheme(scheme: Scheme) = scheme(JsonField.of(scheme))

            /**
             * Sets [Builder.scheme] to an arbitrary JSON value.
             *
             * You should usually call [Builder.scheme] with a well-typed [Scheme] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun scheme(scheme: JsonField<Scheme>) = apply { this.scheme = scheme }

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
             * Returns an immutable instance of [Authorization].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .header()
             * .scheme()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Authorization =
                Authorization(
                    checkRequired("header", header),
                    checkRequired("scheme", scheme),
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
        fun validate(): Authorization = apply {
            if (validated) {
                return@apply
            }

            header().validate()
            scheme().validate()
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
            (header.asKnown().getOrNull()?.validity() ?: 0) +
                (scheme.asKnown().getOrNull()?.validity() ?: 0)

        class Header @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val AUTHORIZATION = of("Authorization")

                @JvmStatic fun of(value: String) = Header(JsonField.of(value))
            }

            /** An enum containing [Header]'s known values. */
            enum class Known {
                AUTHORIZATION
            }

            /**
             * An enum containing [Header]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Header] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AUTHORIZATION,
                /**
                 * An enum member indicating that [Header] was instantiated with an unknown value.
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
                    AUTHORIZATION -> Value.AUTHORIZATION
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
                    AUTHORIZATION -> Known.AUTHORIZATION
                    else -> throw XTwitterScraperInvalidDataException("Unknown Header: $value")
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
            fun validate(): Header = apply {
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

                return other is Header && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class Scheme @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val BEARER = of("Bearer")

                @JvmStatic fun of(value: String) = Scheme(JsonField.of(value))
            }

            /** An enum containing [Scheme]'s known values. */
            enum class Known {
                BEARER
            }

            /**
             * An enum containing [Scheme]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Scheme] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                BEARER,
                /**
                 * An enum member indicating that [Scheme] was instantiated with an unknown value.
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
                    BEARER -> Value.BEARER
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
                    BEARER -> Known.BEARER
                    else -> throw XTwitterScraperInvalidDataException("Unknown Scheme: $value")
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
            fun validate(): Scheme = apply {
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

                return other is Scheme && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Authorization &&
                header == other.header &&
                scheme == other.scheme &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(header, scheme, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Authorization{header=$header, scheme=$scheme, additionalProperties=$additionalProperties}"
    }

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
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is GuestWalletCreateResponse &&
            accountRequired == other.accountRequired &&
            amount == other.amount &&
            apiKey == other.apiKey &&
            authorization == other.authorization &&
            checkoutUrl == other.checkoutUrl &&
            credentialNotice == other.credentialNotice &&
            credits == other.credits &&
            expiresAt == other.expiresAt &&
            instructions == other.instructions &&
            pollAfterSeconds == other.pollAfterSeconds &&
            purchaseId == other.purchaseId &&
            requiresUserInteraction == other.requiresUserInteraction &&
            status == other.status &&
            statusUrl == other.statusUrl &&
            walletId == other.walletId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            accountRequired,
            amount,
            apiKey,
            authorization,
            checkoutUrl,
            credentialNotice,
            credits,
            expiresAt,
            instructions,
            pollAfterSeconds,
            purchaseId,
            requiresUserInteraction,
            status,
            statusUrl,
            walletId,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "GuestWalletCreateResponse{accountRequired=$accountRequired, amount=$amount, apiKey=$apiKey, authorization=$authorization, checkoutUrl=$checkoutUrl, credentialNotice=$credentialNotice, credits=$credits, expiresAt=$expiresAt, instructions=$instructions, pollAfterSeconds=$pollAfterSeconds, purchaseId=$purchaseId, requiresUserInteraction=$requiresUserInteraction, status=$status, statusUrl=$statusUrl, walletId=$walletId, additionalProperties=$additionalProperties}"
}
