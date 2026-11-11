// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.x.accountconnectionlinks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.Params
import com.x_twitter_scraper.api.core.http.Headers
import com.x_twitter_scraper.api.core.http.QueryParams
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/**
 * Creates a link to a page Xquik hosts, where a person connects an X account with no Xquik signup.
 * Your backend never receives their password or 2FA secret, and the account belongs to you. Send
 * accountId to reconnect 1 of your accounts instead. Connecting is free. Takes a Full access API
 * key or a dashboard session.
 *
 * The link works for 30 minutes, and the response is the only place its token appears.
 */
class AccountConnectionLinkCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The ID of 1 of your X accounts. The link then reconnects that account.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun accountId(): Optional<String> = body.accountId()

    /**
     * Your own ID for this person. It comes back when you read the link.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun reference(): Optional<String> = body.reference()

    /**
     * A public https URL the page offers as a button once the account connects. Xquik never
     * redirects by itself, and never adds the token.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
     */
    fun returnUrl(): Optional<String> = body.returnUrl()

    /**
     * Returns the raw JSON value of [accountId].
     *
     * Unlike [accountId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _accountId(): JsonField<String> = body._accountId()

    /**
     * Returns the raw JSON value of [reference].
     *
     * Unlike [reference], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _reference(): JsonField<String> = body._reference()

    /**
     * Returns the raw JSON value of [returnUrl].
     *
     * Unlike [returnUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _returnUrl(): JsonField<String> = body._returnUrl()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): AccountConnectionLinkCreateParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of
         * [AccountConnectionLinkCreateParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AccountConnectionLinkCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(accountConnectionLinkCreateParams: AccountConnectionLinkCreateParams) =
            apply {
                body = accountConnectionLinkCreateParams.body.toBuilder()
                additionalHeaders = accountConnectionLinkCreateParams.additionalHeaders.toBuilder()
                additionalQueryParams =
                    accountConnectionLinkCreateParams.additionalQueryParams.toBuilder()
            }

        /** Sets the entire request body. */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The ID of 1 of your X accounts. The link then reconnects that account. */
        fun accountId(accountId: String) = apply { body.accountId(accountId) }

        /** Sets [Builder.accountId] to an arbitrary JSON value. */
        fun accountId(accountId: JsonField<String>) = apply { body.accountId(accountId) }

        /** Your own ID for this person. It comes back when you read the link. */
        fun reference(reference: String) = apply { body.reference(reference) }

        /** Sets [Builder.reference] to an arbitrary JSON value. */
        fun reference(reference: JsonField<String>) = apply { body.reference(reference) }

        /**
         * A public https URL the page offers as a button once the account connects. Xquik never
         * redirects by itself, and never adds the token.
         */
        fun returnUrl(returnUrl: String) = apply { body.returnUrl(returnUrl) }

        /** Sets [Builder.returnUrl] to an arbitrary JSON value. */
        fun returnUrl(returnUrl: JsonField<String>) = apply { body.returnUrl(returnUrl) }

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
         * Returns an immutable instance of [AccountConnectionLinkCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): AccountConnectionLinkCreateParams =
            AccountConnectionLinkCreateParams(
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
        private val accountId: JsonField<String>,
        private val reference: JsonField<String>,
        private val returnUrl: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("accountId")
            @ExcludeMissing
            accountId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("reference")
            @ExcludeMissing
            reference: JsonField<String> = JsonMissing.of(),
            @JsonProperty("returnUrl")
            @ExcludeMissing
            returnUrl: JsonField<String> = JsonMissing.of(),
        ) : this(accountId, reference, returnUrl, mutableMapOf())

        /**
         * The ID of 1 of your X accounts. The link then reconnects that account.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun accountId(): Optional<String> = accountId.getOptional("accountId")

        /**
         * Your own ID for this person. It comes back when you read the link.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun reference(): Optional<String> = reference.getOptional("reference")

        /**
         * A public https URL the page offers as a button once the account connects. Xquik never
         * redirects by itself, and never adds the token.
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type.
         */
        fun returnUrl(): Optional<String> = returnUrl.getOptional("returnUrl")

        /**
         * Returns the raw JSON value of [accountId].
         *
         * Unlike [accountId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("accountId") @ExcludeMissing fun _accountId(): JsonField<String> = accountId

        /**
         * Returns the raw JSON value of [reference].
         *
         * Unlike [reference], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reference") @ExcludeMissing fun _reference(): JsonField<String> = reference

        /**
         * Returns the raw JSON value of [returnUrl].
         *
         * Unlike [returnUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("returnUrl") @ExcludeMissing fun _returnUrl(): JsonField<String> = returnUrl

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var accountId: JsonField<String> = JsonMissing.of()
            private var reference: JsonField<String> = JsonMissing.of()
            private var returnUrl: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                accountId = body.accountId
                reference = body.reference
                returnUrl = body.returnUrl
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The ID of 1 of your X accounts. The link then reconnects that account. */
            fun accountId(accountId: String) = accountId(JsonField.of(accountId))

            /** Sets [Builder.accountId] to an arbitrary JSON value. */
            fun accountId(accountId: JsonField<String>) = apply { this.accountId = accountId }

            /** Your own ID for this person. It comes back when you read the link. */
            fun reference(reference: String) = reference(JsonField.of(reference))

            /** Sets [Builder.reference] to an arbitrary JSON value. */
            fun reference(reference: JsonField<String>) = apply { this.reference = reference }

            /**
             * A public https URL the page offers as a button once the account connects. Xquik never
             * redirects by itself, and never adds the token.
             */
            fun returnUrl(returnUrl: String) = returnUrl(JsonField.of(returnUrl))

            /** Sets [Builder.returnUrl] to an arbitrary JSON value. */
            fun returnUrl(returnUrl: JsonField<String>) = apply { this.returnUrl = returnUrl }

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
             */
            fun build(): Body =
                Body(accountId, reference, returnUrl, additionalProperties.toMutableMap())
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

            accountId()
            reference()
            returnUrl()
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
            (if (accountId.asKnown().isPresent) 1 else 0) +
                (if (reference.asKnown().isPresent) 1 else 0) +
                (if (returnUrl.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                accountId == other.accountId &&
                reference == other.reference &&
                returnUrl == other.returnUrl &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(accountId, reference, returnUrl, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{accountId=$accountId, reference=$reference, returnUrl=$returnUrl, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountConnectionLinkCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "AccountConnectionLinkCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
