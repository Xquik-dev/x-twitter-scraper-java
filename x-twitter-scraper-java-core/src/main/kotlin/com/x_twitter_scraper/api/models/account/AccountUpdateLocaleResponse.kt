// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.models.account

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.core.checkKnown
import com.x_twitter_scraper.api.core.toImmutable
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

class AccountUpdateLocaleResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val success: JsonValue,
    private val ignoredFields: JsonField<List<String>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("success") @ExcludeMissing success: JsonValue = JsonMissing.of(),
        @JsonProperty("ignoredFields")
        @ExcludeMissing
        ignoredFields: JsonField<List<String>> = JsonMissing.of(),
    ) : this(
        success,
        ignoredFields,
        mutableMapOf(),
    )

    /**
     * Expected to always return the following:
     * ```java
     * JsonValue.from(true)
     * ```
     */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonValue = success

    /** @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type. */
    fun ignoredFields(): Optional<List<String>> = ignoredFields.getOptional("ignoredFields")

    /**
     * Returns the raw JSON value of [ignoredFields].
     *
     * Unlike [ignoredFields], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ignoredFields")
    @ExcludeMissing
    fun _ignoredFields(): JsonField<List<String>> = ignoredFields

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
         * Returns a mutable builder for constructing an instance of [AccountUpdateLocaleResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AccountUpdateLocaleResponse]. */
    class Builder internal constructor() {

        private var success: JsonValue = JsonValue.from(true)
        private var ignoredFields: JsonField<MutableList<String>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountUpdateLocaleResponse: AccountUpdateLocaleResponse) = apply {
            success = accountUpdateLocaleResponse.success
            ignoredFields = accountUpdateLocaleResponse.ignoredFields.map { it.toMutableList() }
            additionalProperties = accountUpdateLocaleResponse.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * Defaults to the following:
         * ```java
         * JsonValue.from(true)
         * ```
         */
        fun success(success: JsonValue) = apply { this.success = success }

        fun ignoredFields(ignoredFields: List<String>) = ignoredFields(JsonField.of(ignoredFields))

        /** Sets [Builder.ignoredFields] to an arbitrary JSON value. */
        fun ignoredFields(ignoredFields: JsonField<List<String>>) = apply {
            this.ignoredFields = ignoredFields.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [ignoredFields].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addIgnoredField(ignoredField: String) = apply {
            this.ignoredFields =
                (this.ignoredFields ?: JsonField.of(mutableListOf())).also {
                    checkKnown("ignoredFields", it).add(ignoredField)
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
         * Returns an immutable instance of [AccountUpdateLocaleResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): AccountUpdateLocaleResponse =
            AccountUpdateLocaleResponse(
                success,
                (ignoredFields ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): AccountUpdateLocaleResponse = apply {
        if (validated) {
            return@apply
        }

        _success().let {
            if (it != JsonValue.from(true)) {
                throw XTwitterScraperInvalidDataException("'success' is invalid, received $it")
            }
        }
        ignoredFields()
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
        success.let { if (it == JsonValue.from(true)) 1 else 0 } +
            (if (ignoredFields.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountUpdateLocaleResponse &&
            success == other.success &&
            ignoredFields == other.ignoredFields &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(success, ignoredFields, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AccountUpdateLocaleResponse{success=$success, ignoredFields=$ignoredFields, additionalProperties=$additionalProperties}"
}
