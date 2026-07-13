// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.x.tweets

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
import java.util.Optional

class TweetCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val charged: JsonField<Boolean>,
    private val chargedCredits: JsonField<String>,
    private val success: JsonValue,
    private val tweetId: JsonField<String>,
    private val writeActionId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("charged") @ExcludeMissing charged: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("chargedCredits")
        @ExcludeMissing
        chargedCredits: JsonField<String> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonValue = JsonMissing.of(),
        @JsonProperty("tweetId") @ExcludeMissing tweetId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("writeActionId")
        @ExcludeMissing
        writeActionId: JsonField<String> = JsonMissing.of(),
    ) : this(charged, chargedCredits, success, tweetId, writeActionId, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun charged(): Boolean = charged.getRequired("charged")

    /**
     * Credits charged for this tweet. Text-only tweets and replies cost 30 credits; attached media
     * adds 2 credits per started MB.
     *
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun chargedCredits(): String = chargedCredits.getRequired("chargedCredits")

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
    fun tweetId(): String = tweetId.getRequired("tweetId")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type (e.g. if
     *   the server responded with an unexpected value).
     */
    fun writeActionId(): Optional<String> = writeActionId.getOptional("writeActionId")

    /**
     * Returns the raw JSON value of [charged].
     *
     * Unlike [charged], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("charged") @ExcludeMissing fun _charged(): JsonField<Boolean> = charged

    /**
     * Returns the raw JSON value of [chargedCredits].
     *
     * Unlike [chargedCredits], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("chargedCredits")
    @ExcludeMissing
    fun _chargedCredits(): JsonField<String> = chargedCredits

    /**
     * Returns the raw JSON value of [tweetId].
     *
     * Unlike [tweetId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tweetId") @ExcludeMissing fun _tweetId(): JsonField<String> = tweetId

    /**
     * Returns the raw JSON value of [writeActionId].
     *
     * Unlike [writeActionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("writeActionId")
    @ExcludeMissing
    fun _writeActionId(): JsonField<String> = writeActionId

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
         * Returns a mutable builder for constructing an instance of [TweetCreateResponse].
         *
         * The following fields are required:
         * ```java
         * .charged()
         * .chargedCredits()
         * .tweetId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TweetCreateResponse]. */
    class Builder internal constructor() {

        private var charged: JsonField<Boolean>? = null
        private var chargedCredits: JsonField<String>? = null
        private var success: JsonValue = JsonValue.from(true)
        private var tweetId: JsonField<String>? = null
        private var writeActionId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tweetCreateResponse: TweetCreateResponse) = apply {
            charged = tweetCreateResponse.charged
            chargedCredits = tweetCreateResponse.chargedCredits
            success = tweetCreateResponse.success
            tweetId = tweetCreateResponse.tweetId
            writeActionId = tweetCreateResponse.writeActionId
            additionalProperties = tweetCreateResponse.additionalProperties.toMutableMap()
        }

        fun charged(charged: Boolean) = charged(JsonField.of(charged))

        /**
         * Sets [Builder.charged] to an arbitrary JSON value.
         *
         * You should usually call [Builder.charged] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun charged(charged: JsonField<Boolean>) = apply { this.charged = charged }

        /**
         * Credits charged for this tweet. Text-only tweets and replies cost 30 credits; attached
         * media adds 2 credits per started MB.
         */
        fun chargedCredits(chargedCredits: String) = chargedCredits(JsonField.of(chargedCredits))

        /**
         * Sets [Builder.chargedCredits] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chargedCredits] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun chargedCredits(chargedCredits: JsonField<String>) = apply {
            this.chargedCredits = chargedCredits
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

        fun tweetId(tweetId: String) = tweetId(JsonField.of(tweetId))

        /**
         * Sets [Builder.tweetId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tweetId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tweetId(tweetId: JsonField<String>) = apply { this.tweetId = tweetId }

        fun writeActionId(writeActionId: String) = writeActionId(JsonField.of(writeActionId))

        /**
         * Sets [Builder.writeActionId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.writeActionId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun writeActionId(writeActionId: JsonField<String>) = apply {
            this.writeActionId = writeActionId
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
         * Returns an immutable instance of [TweetCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .charged()
         * .chargedCredits()
         * .tweetId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TweetCreateResponse =
            TweetCreateResponse(
                checkRequired("charged", charged),
                checkRequired("chargedCredits", chargedCredits),
                success,
                checkRequired("tweetId", tweetId),
                writeActionId,
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
    fun validate(): TweetCreateResponse = apply {
        if (validated) {
            return@apply
        }

        charged()
        chargedCredits()
        _success().let {
            if (it != JsonValue.from(true)) {
                throw XTwitterScraperInvalidDataException("'success' is invalid, received $it")
            }
        }
        tweetId()
        writeActionId()
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
        (if (charged.asKnown().isPresent) 1 else 0) +
            (if (chargedCredits.asKnown().isPresent) 1 else 0) +
            success.let { if (it == JsonValue.from(true)) 1 else 0 } +
            (if (tweetId.asKnown().isPresent) 1 else 0) +
            (if (writeActionId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TweetCreateResponse &&
            charged == other.charged &&
            chargedCredits == other.chargedCredits &&
            success == other.success &&
            tweetId == other.tweetId &&
            writeActionId == other.writeActionId &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(charged, chargedCredits, success, tweetId, writeActionId, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TweetCreateResponse{charged=$charged, chargedCredits=$chargedCredits, success=$success, tweetId=$tweetId, writeActionId=$writeActionId, additionalProperties=$additionalProperties}"
}
