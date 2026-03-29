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
import com.x_twitter_scraper.api.core.checkRequired
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects

class AccountCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val status: JsonField<String>,
    private val xUserId: JsonField<String>,
    private val xUsername: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("xUserId") @ExcludeMissing xUserId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("xUsername") @ExcludeMissing xUsername: JsonField<String> = JsonMissing.of(),
    ) : this(id, status, xUserId, xUsername, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): String = status.getRequired("status")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun xUserId(): String = xUserId.getRequired("xUserId")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun xUsername(): String = xUsername.getRequired("xUsername")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
         * Returns a mutable builder for constructing an instance of [AccountCreateResponse].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .status()
         * .xUserId()
         * .xUsername()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AccountCreateResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var status: JsonField<String>? = null
        private var xUserId: JsonField<String>? = null
        private var xUsername: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountCreateResponse: AccountCreateResponse) = apply {
            id = accountCreateResponse.id
            status = accountCreateResponse.status
            xUserId = accountCreateResponse.xUserId
            xUsername = accountCreateResponse.xUsername
            additionalProperties = accountCreateResponse.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        fun xUserId(xUserId: String) = xUserId(JsonField.of(xUserId))

        /**
         * Sets [Builder.xUserId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.xUserId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun xUserId(xUserId: JsonField<String>) = apply { this.xUserId = xUserId }

        fun xUsername(xUsername: String) = xUsername(JsonField.of(xUsername))

        /**
         * Sets [Builder.xUsername] to an arbitrary JSON value.
         *
         * You should usually call [Builder.xUsername] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Returns an immutable instance of [AccountCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .status()
         * .xUserId()
         * .xUsername()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AccountCreateResponse =
            AccountCreateResponse(
                checkRequired("id", id),
                checkRequired("status", status),
                checkRequired("xUserId", xUserId),
                checkRequired("xUsername", xUsername),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AccountCreateResponse = apply {
        if (validated) {
            return@apply
        }

        id()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (xUserId.asKnown().isPresent) 1 else 0) +
            (if (xUsername.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountCreateResponse &&
            id == other.id &&
            status == other.status &&
            xUserId == other.xUserId &&
            xUsername == other.xUsername &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, status, xUserId, xUsername, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AccountCreateResponse{id=$id, status=$status, xUserId=$xUserId, xUsername=$xUsername, additionalProperties=$additionalProperties}"
}
