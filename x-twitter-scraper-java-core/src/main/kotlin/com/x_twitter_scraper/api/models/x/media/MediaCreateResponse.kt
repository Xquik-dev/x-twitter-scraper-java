// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.media

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

class MediaCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val mediaId: JsonField<String>,
    private val success: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("mediaId") @ExcludeMissing mediaId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonValue = JsonMissing.of(),
    ) : this(mediaId, success, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun mediaId(): String = mediaId.getRequired("mediaId")

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
     * Returns the raw JSON value of [mediaId].
     *
     * Unlike [mediaId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mediaId") @ExcludeMissing fun _mediaId(): JsonField<String> = mediaId

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
         * Returns a mutable builder for constructing an instance of [MediaCreateResponse].
         *
         * The following fields are required:
         * ```java
         * .mediaId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MediaCreateResponse]. */
    class Builder internal constructor() {

        private var mediaId: JsonField<String>? = null
        private var success: JsonValue = JsonValue.from(true)
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(mediaCreateResponse: MediaCreateResponse) = apply {
            mediaId = mediaCreateResponse.mediaId
            success = mediaCreateResponse.success
            additionalProperties = mediaCreateResponse.additionalProperties.toMutableMap()
        }

        fun mediaId(mediaId: String) = mediaId(JsonField.of(mediaId))

        /**
         * Sets [Builder.mediaId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mediaId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mediaId(mediaId: JsonField<String>) = apply { this.mediaId = mediaId }

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
         * Returns an immutable instance of [MediaCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .mediaId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MediaCreateResponse =
            MediaCreateResponse(
                checkRequired("mediaId", mediaId),
                success,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MediaCreateResponse = apply {
        if (validated) {
            return@apply
        }

        mediaId()
        _success().let {
            if (it != JsonValue.from(true)) {
                throw XTwitterScraperInvalidDataException("'success' is invalid, received $it")
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (mediaId.asKnown().isPresent) 1 else 0) +
            success.let { if (it == JsonValue.from(true)) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MediaCreateResponse &&
            mediaId == other.mediaId &&
            success == other.success &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(mediaId, success, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MediaCreateResponse{mediaId=$mediaId, success=$success, additionalProperties=$additionalProperties}"
}
