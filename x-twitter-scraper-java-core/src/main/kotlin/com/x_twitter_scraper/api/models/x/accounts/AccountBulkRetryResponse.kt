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

class AccountBulkRetryResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val cleared: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("cleared") @ExcludeMissing cleared: JsonField<Long> = JsonMissing.of()
    ) : this(cleared, mutableMapOf())

    /**
     * Number of accounts cleared
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun cleared(): Long = cleared.getRequired("cleared")

    /**
     * Returns the raw JSON value of [cleared].
     *
     * Unlike [cleared], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cleared") @ExcludeMissing fun _cleared(): JsonField<Long> = cleared

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
         * Returns a mutable builder for constructing an instance of [AccountBulkRetryResponse].
         *
         * The following fields are required:
         * ```java
         * .cleared()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AccountBulkRetryResponse]. */
    class Builder internal constructor() {

        private var cleared: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(accountBulkRetryResponse: AccountBulkRetryResponse) = apply {
            cleared = accountBulkRetryResponse.cleared
            additionalProperties = accountBulkRetryResponse.additionalProperties.toMutableMap()
        }

        /** Number of accounts cleared */
        fun cleared(cleared: Long) = cleared(JsonField.of(cleared))

        /**
         * Sets [Builder.cleared] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cleared] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cleared(cleared: JsonField<Long>) = apply { this.cleared = cleared }

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
         * Returns an immutable instance of [AccountBulkRetryResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .cleared()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AccountBulkRetryResponse =
            AccountBulkRetryResponse(
                checkRequired("cleared", cleared),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): AccountBulkRetryResponse = apply {
        if (validated) {
            return@apply
        }

        cleared()
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
    @JvmSynthetic internal fun validity(): Int = (if (cleared.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AccountBulkRetryResponse &&
            cleared == other.cleared &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(cleared, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AccountBulkRetryResponse{cleared=$cleared, additionalProperties=$additionalProperties}"
}
