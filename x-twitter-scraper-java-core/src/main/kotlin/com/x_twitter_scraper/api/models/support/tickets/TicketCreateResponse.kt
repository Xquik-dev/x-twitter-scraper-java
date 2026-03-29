// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.support.tickets

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.x_twitter_scraper.api.core.ExcludeMissing
import com.x_twitter_scraper.api.core.JsonField
import com.x_twitter_scraper.api.core.JsonMissing
import com.x_twitter_scraper.api.core.JsonValue
import com.x_twitter_scraper.api.errors.XTwitterScraperInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

class TicketCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val publicId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("publicId") @ExcludeMissing publicId: JsonField<String> = JsonMissing.of()
    ) : this(publicId, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun publicId(): Optional<String> = publicId.getOptional("publicId")

    /**
     * Returns the raw JSON value of [publicId].
     *
     * Unlike [publicId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("publicId") @ExcludeMissing fun _publicId(): JsonField<String> = publicId

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

        /** Returns a mutable builder for constructing an instance of [TicketCreateResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TicketCreateResponse]. */
    class Builder internal constructor() {

        private var publicId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(ticketCreateResponse: TicketCreateResponse) = apply {
            publicId = ticketCreateResponse.publicId
            additionalProperties = ticketCreateResponse.additionalProperties.toMutableMap()
        }

        fun publicId(publicId: String) = publicId(JsonField.of(publicId))

        /**
         * Sets [Builder.publicId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.publicId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun publicId(publicId: JsonField<String>) = apply { this.publicId = publicId }

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
         * Returns an immutable instance of [TicketCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TicketCreateResponse =
            TicketCreateResponse(publicId, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): TicketCreateResponse = apply {
        if (validated) {
            return@apply
        }

        publicId()
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
    @JvmSynthetic internal fun validity(): Int = (if (publicId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TicketCreateResponse &&
            publicId == other.publicId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(publicId, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TicketCreateResponse{publicId=$publicId, additionalProperties=$additionalProperties}"
}
