// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.account

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

class AccountSetXUsernameResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val success: JsonValue,
    private val xUsername: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("success") @ExcludeMissing success: JsonValue = JsonMissing.of(),
        @JsonProperty("xUsername") @ExcludeMissing xUsername: JsonField<String> = JsonMissing.of(),
    ) : this(success, xUsername, mutableMapOf())

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from(true)
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonValue = success

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun xUsername(): String = xUsername.getRequired("xUsername")

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
         * Returns a mutable builder for constructing an instance of [AccountSetXUsernameResponse].
         *
         * The following fields are required:
         * ```java
         * .xUsername()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AccountSetXUsernameResponse]. */
    class Builder internal constructor() {

        private var success: JsonValue = JsonValue.from(true)
        private var xUsername: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountSetXUsernameResponse: AccountSetXUsernameResponse) = apply {
            success = accountSetXUsernameResponse.success
            xUsername = accountSetXUsernameResponse.xUsername
            additionalProperties = accountSetXUsernameResponse.additionalProperties.toMutableMap()
        }

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
        fun success(success: JsonValue) = apply { this.success = success }

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
         * Returns an immutable instance of [AccountSetXUsernameResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .xUsername()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AccountSetXUsernameResponse =
            AccountSetXUsernameResponse(
                success,
                checkRequired("xUsername", xUsername),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AccountSetXUsernameResponse = apply {
        if (validated) {
            return@apply
        }

        _success().let {
            if (it != JsonValue.from(true)) {
                throw XTwitterScraperInvalidDataException("'success' is invalid, received $it")
            }
        }
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
        success.let { if (it == JsonValue.from(true)) 1 else 0 } +
            (if (xUsername.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountSetXUsernameResponse &&
            success == other.success &&
            xUsername == other.xUsername &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(success, xUsername, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AccountSetXUsernameResponse{success=$success, xUsername=$xUsername, additionalProperties=$additionalProperties}"
}
