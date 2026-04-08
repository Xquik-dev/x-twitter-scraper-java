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
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class AccountListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val accounts: JsonField<List<Account>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("accounts")
        @ExcludeMissing
        accounts: JsonField<List<Account>> = JsonMissing.of()
    ) : this(accounts, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun accounts(): List<Account> = accounts.getRequired("accounts")

    /**
     * Returns the raw JSON value of [accounts].
     *
     * Unlike [accounts], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("accounts") @ExcludeMissing fun _accounts(): JsonField<List<Account>> = accounts

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
         * Returns a mutable builder for constructing an instance of [AccountListResponse].
         *
         * The following fields are required:
         * ```java
         * .accounts()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AccountListResponse]. */
    class Builder internal constructor() {

        private var accounts: JsonField<MutableList<Account>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountListResponse: AccountListResponse) = apply {
            accounts = accountListResponse.accounts.map { it.toMutableList() }
            additionalProperties = accountListResponse.additionalProperties.toMutableMap()
        }

        fun accounts(accounts: List<Account>) = accounts(JsonField.of(accounts))

        /**
         * Sets [Builder.accounts] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accounts] with a well-typed `List<Account>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun accounts(accounts: JsonField<List<Account>>) = apply {
            this.accounts = accounts.map { it.toMutableList() }
        }

        /**
         * Adds a single [Account] to [accounts].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAccount(account: Account) = apply {
            accounts =
                (accounts ?: JsonField.of(mutableListOf())).also {
                    checkKnown("accounts", it).add(account)
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
         * Returns an immutable instance of [AccountListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .accounts()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AccountListResponse =
            AccountListResponse(
                checkRequired("accounts", accounts).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AccountListResponse = apply {
        if (validated) {
            return@apply
        }

        accounts().forEach { it.validate() }
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
        (accounts.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** Linked X account summary with username and connection status. */
    class Account
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val status: JsonField<String>,
        private val xUserId: JsonField<String>,
        private val xUsername: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("createdAt")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
            @JsonProperty("xUserId") @ExcludeMissing xUserId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("xUsername")
            @ExcludeMissing
            xUsername: JsonField<String> = JsonMissing.of(),
        ) : this(id, createdAt, status, xUserId, xUsername, mutableMapOf())

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun createdAt(): OffsetDateTime = createdAt.getRequired("createdAt")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun status(): String = status.getRequired("status")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun xUserId(): String = xUserId.getRequired("xUserId")

        /**
         * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun xUsername(): String = xUsername.getRequired("xUsername")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("createdAt")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

        /**
         * Returns the raw JSON value of [xUserId].
         *
         * Unlike [xUserId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("xUserId") @ExcludeMissing fun _xUserId(): JsonField<String> = xUserId

        /**
         * Returns the raw JSON value of [xUsername].
         *
         * Unlike [xUsername], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("xUsername") @ExcludeMissing fun _xUsername(): JsonField<String> = xUsername

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
             * Returns a mutable builder for constructing an instance of [Account].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .createdAt()
             * .status()
             * .xUserId()
             * .xUsername()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Account]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var createdAt: JsonField<OffsetDateTime>? = null
            private var status: JsonField<String>? = null
            private var xUserId: JsonField<String>? = null
            private var xUsername: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(account: Account) = apply {
                id = account.id
                createdAt = account.createdAt
                status = account.status
                xUserId = account.xUserId
                xUsername = account.xUsername
                additionalProperties = account.additionalProperties.toMutableMap()
            }

            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            fun status(status: String) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<String>) = apply { this.status = status }

            fun xUserId(xUserId: String) = xUserId(JsonField.of(xUserId))

            /**
             * Sets [Builder.xUserId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.xUserId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun xUserId(xUserId: JsonField<String>) = apply { this.xUserId = xUserId }

            fun xUsername(xUsername: String) = xUsername(JsonField.of(xUsername))

            /**
             * Sets [Builder.xUsername] to an arbitrary JSON value.
             *
             * You should usually call [Builder.xUsername] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun xUsername(xUsername: JsonField<String>) = apply { this.xUsername = xUsername }

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
             * Returns an immutable instance of [Account].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .createdAt()
             * .status()
             * .xUserId()
             * .xUsername()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Account =
                Account(
                    checkRequired("id", id),
                    checkRequired("createdAt", createdAt),
                    checkRequired("status", status),
                    checkRequired("xUserId", xUserId),
                    checkRequired("xUsername", xUsername),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Account = apply {
            if (validated) {
                return@apply
            }

            id()
            createdAt()
            status()
            xUserId()
            xUsername()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (status.asKnown().isPresent) 1 else 0) +
                (if (xUserId.asKnown().isPresent) 1 else 0) +
                (if (xUsername.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Account &&
                id == other.id &&
                createdAt == other.createdAt &&
                status == other.status &&
                xUserId == other.xUserId &&
                xUsername == other.xUsername &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, createdAt, status, xUserId, xUsername, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Account{id=$id, createdAt=$createdAt, status=$status, xUserId=$xUserId, xUsername=$xUsername, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountListResponse &&
            accounts == other.accounts &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(accounts, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AccountListResponse{accounts=$accounts, additionalProperties=$additionalProperties}"
}
