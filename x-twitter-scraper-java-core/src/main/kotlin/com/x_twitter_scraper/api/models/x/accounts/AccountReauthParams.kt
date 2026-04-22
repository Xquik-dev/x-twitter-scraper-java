// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.accounts

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Re-authenticate X account */
class AccountReauthParams
private constructor(
    private val id: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun id(): Optional<String> = Optional.ofNullable(id)

    /**
     * Updated account password
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun password(): String = body.password()

    /**
     * Email for the X account (updates stored email)
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun email(): Optional<String> = body.email()

    /**
     * Two-letter country code for login proxy region
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun proxyCountry(): Optional<String> = body.proxyCountry()

    /**
     * TOTP secret for 2FA re-authentication
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun totpSecret(): Optional<String> = body.totpSecret()

    /**
     * Returns the raw JSON value of [password].
     *
     * Unlike [password], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _password(): JsonField<String> = body._password()

    /**
     * Returns the raw JSON value of [email].
     *
     * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _email(): JsonField<String> = body._email()

    /**
     * Returns the raw JSON value of [proxyCountry].
     *
     * Unlike [proxyCountry], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _proxyCountry(): JsonField<String> = body._proxyCountry()

    /**
     * Returns the raw JSON value of [totpSecret].
     *
     * Unlike [totpSecret], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _totpSecret(): JsonField<String> = body._totpSecret()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AccountReauthParams].
         *
         * The following fields are required:
         * ```java
         * .password()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AccountReauthParams]. */
    class Builder internal constructor() {

        private var id: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(accountReauthParams: AccountReauthParams) = apply {
            id = accountReauthParams.id
            body = accountReauthParams.body.toBuilder()
            additionalHeaders = accountReauthParams.additionalHeaders.toBuilder()
            additionalQueryParams = accountReauthParams.additionalQueryParams.toBuilder()
        }

        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [password]
         * - [email]
         * - [proxyCountry]
         * - [totpSecret]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Updated account password */
        fun password(password: String) = apply { body.password(password) }

        /**
         * Sets [Builder.password] to an arbitrary JSON value.
         *
         * You should usually call [Builder.password] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun password(password: JsonField<String>) = apply { body.password(password) }

        /** Email for the X account (updates stored email) */
        fun email(email: String) = apply { body.email(email) }

        /**
         * Sets [Builder.email] to an arbitrary JSON value.
         *
         * You should usually call [Builder.email] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun email(email: JsonField<String>) = apply { body.email(email) }

        /** Two-letter country code for login proxy region */
        fun proxyCountry(proxyCountry: String) = apply { body.proxyCountry(proxyCountry) }

        /**
         * Sets [Builder.proxyCountry] to an arbitrary JSON value.
         *
         * You should usually call [Builder.proxyCountry] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun proxyCountry(proxyCountry: JsonField<String>) = apply {
            body.proxyCountry(proxyCountry)
        }

        /** TOTP secret for 2FA re-authentication */
        fun totpSecret(totpSecret: String) = apply { body.totpSecret(totpSecret) }

        /**
         * Sets [Builder.totpSecret] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totpSecret] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun totpSecret(totpSecret: JsonField<String>) = apply { body.totpSecret(totpSecret) }

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
         * Returns an immutable instance of [AccountReauthParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .password()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AccountReauthParams =
            AccountReauthParams(
                id,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> id ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val password: JsonField<String>,
        private val email: JsonField<String>,
        private val proxyCountry: JsonField<String>,
        private val totpSecret: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("password")
            @ExcludeMissing
            password: JsonField<String> = JsonMissing.of(),
            @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
            @JsonProperty("proxy_country")
            @ExcludeMissing
            proxyCountry: JsonField<String> = JsonMissing.of(),
            @JsonProperty("totp_secret")
            @ExcludeMissing
            totpSecret: JsonField<String> = JsonMissing.of(),
        ) : this(password, email, proxyCountry, totpSecret, mutableMapOf())

        /**
         * Updated account password
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun password(): String = password.getRequired("password")

        /**
         * Email for the X account (updates stored email)
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun email(): Optional<String> = email.getOptional("email")

        /**
         * Two-letter country code for login proxy region
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun proxyCountry(): Optional<String> = proxyCountry.getOptional("proxy_country")

        /**
         * TOTP secret for 2FA re-authentication
         *
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun totpSecret(): Optional<String> = totpSecret.getOptional("totp_secret")

        /**
         * Returns the raw JSON value of [password].
         *
         * Unlike [password], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("password") @ExcludeMissing fun _password(): JsonField<String> = password

        /**
         * Returns the raw JSON value of [email].
         *
         * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

        /**
         * Returns the raw JSON value of [proxyCountry].
         *
         * Unlike [proxyCountry], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("proxy_country")
        @ExcludeMissing
        fun _proxyCountry(): JsonField<String> = proxyCountry

        /**
         * Returns the raw JSON value of [totpSecret].
         *
         * Unlike [totpSecret], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("totp_secret")
        @ExcludeMissing
        fun _totpSecret(): JsonField<String> = totpSecret

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
             * .password()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var password: JsonField<String>? = null
            private var email: JsonField<String> = JsonMissing.of()
            private var proxyCountry: JsonField<String> = JsonMissing.of()
            private var totpSecret: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                password = body.password
                email = body.email
                proxyCountry = body.proxyCountry
                totpSecret = body.totpSecret
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Updated account password */
            fun password(password: String) = password(JsonField.of(password))

            /**
             * Sets [Builder.password] to an arbitrary JSON value.
             *
             * You should usually call [Builder.password] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun password(password: JsonField<String>) = apply { this.password = password }

            /** Email for the X account (updates stored email) */
            fun email(email: String) = email(JsonField.of(email))

            /**
             * Sets [Builder.email] to an arbitrary JSON value.
             *
             * You should usually call [Builder.email] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun email(email: JsonField<String>) = apply { this.email = email }

            /** Two-letter country code for login proxy region */
            fun proxyCountry(proxyCountry: String) = proxyCountry(JsonField.of(proxyCountry))

            /**
             * Sets [Builder.proxyCountry] to an arbitrary JSON value.
             *
             * You should usually call [Builder.proxyCountry] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun proxyCountry(proxyCountry: JsonField<String>) = apply {
                this.proxyCountry = proxyCountry
            }

            /** TOTP secret for 2FA re-authentication */
            fun totpSecret(totpSecret: String) = totpSecret(JsonField.of(totpSecret))

            /**
             * Sets [Builder.totpSecret] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totpSecret] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totpSecret(totpSecret: JsonField<String>) = apply { this.totpSecret = totpSecret }

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
             * .password()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("password", password),
                    email,
                    proxyCountry,
                    totpSecret,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            password()
            email()
            proxyCountry()
            totpSecret()
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
            (if (password.asKnown().isPresent) 1 else 0) +
                (if (email.asKnown().isPresent) 1 else 0) +
                (if (proxyCountry.asKnown().isPresent) 1 else 0) +
                (if (totpSecret.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                password == other.password &&
                email == other.email &&
                proxyCountry == other.proxyCountry &&
                totpSecret == other.totpSecret &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(password, email, proxyCountry, totpSecret, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{password=$password, email=$email, proxyCountry=$proxyCountry, totpSecret=$totpSecret, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountReauthParams &&
            id == other.id &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(id, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "AccountReauthParams{id=$id, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
