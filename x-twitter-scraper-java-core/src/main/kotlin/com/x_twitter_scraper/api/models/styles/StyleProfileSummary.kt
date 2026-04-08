// File generated from our OpenAPI spec by Stainless.

package com.x_twitter_scraper.api.models.styles

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects

/** Style profile summary with tweet count and ownership flag. */
class StyleProfileSummary
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val fetchedAt: JsonField<OffsetDateTime>,
    private val isOwnAccount: JsonField<Boolean>,
    private val tweetCount: JsonField<Long>,
    private val xUsername: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("fetchedAt")
        @ExcludeMissing
        fetchedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("isOwnAccount")
        @ExcludeMissing
        isOwnAccount: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("tweetCount") @ExcludeMissing tweetCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("xUsername") @ExcludeMissing xUsername: JsonField<String> = JsonMissing.of(),
    ) : this(fetchedAt, isOwnAccount, tweetCount, xUsername, mutableMapOf())

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fetchedAt(): OffsetDateTime = fetchedAt.getRequired("fetchedAt")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isOwnAccount(): Boolean = isOwnAccount.getRequired("isOwnAccount")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tweetCount(): Long = tweetCount.getRequired("tweetCount")

    /**
     * @throws XTwitterScraperInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun xUsername(): String = xUsername.getRequired("xUsername")

    /**
     * Returns the raw JSON value of [fetchedAt].
     *
     * Unlike [fetchedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fetchedAt")
    @ExcludeMissing
    fun _fetchedAt(): JsonField<OffsetDateTime> = fetchedAt

    /**
     * Returns the raw JSON value of [isOwnAccount].
     *
     * Unlike [isOwnAccount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isOwnAccount")
    @ExcludeMissing
    fun _isOwnAccount(): JsonField<Boolean> = isOwnAccount

    /**
     * Returns the raw JSON value of [tweetCount].
     *
     * Unlike [tweetCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tweetCount") @ExcludeMissing fun _tweetCount(): JsonField<Long> = tweetCount

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
         * Returns a mutable builder for constructing an instance of [StyleProfileSummary].
         *
         * The following fields are required:
         * ```java
         * .fetchedAt()
         * .isOwnAccount()
         * .tweetCount()
         * .xUsername()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [StyleProfileSummary]. */
    class Builder internal constructor() {

        private var fetchedAt: JsonField<OffsetDateTime>? = null
        private var isOwnAccount: JsonField<Boolean>? = null
        private var tweetCount: JsonField<Long>? = null
        private var xUsername: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(styleProfileSummary: StyleProfileSummary) = apply {
            fetchedAt = styleProfileSummary.fetchedAt
            isOwnAccount = styleProfileSummary.isOwnAccount
            tweetCount = styleProfileSummary.tweetCount
            xUsername = styleProfileSummary.xUsername
            additionalProperties = styleProfileSummary.additionalProperties.toMutableMap()
        }

        fun fetchedAt(fetchedAt: OffsetDateTime) = fetchedAt(JsonField.of(fetchedAt))

        /**
         * Sets [Builder.fetchedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fetchedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun fetchedAt(fetchedAt: JsonField<OffsetDateTime>) = apply { this.fetchedAt = fetchedAt }

        fun isOwnAccount(isOwnAccount: Boolean) = isOwnAccount(JsonField.of(isOwnAccount))

        /**
         * Sets [Builder.isOwnAccount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isOwnAccount] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isOwnAccount(isOwnAccount: JsonField<Boolean>) = apply {
            this.isOwnAccount = isOwnAccount
        }

        fun tweetCount(tweetCount: Long) = tweetCount(JsonField.of(tweetCount))

        /**
         * Sets [Builder.tweetCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tweetCount] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tweetCount(tweetCount: JsonField<Long>) = apply { this.tweetCount = tweetCount }

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
         * Returns an immutable instance of [StyleProfileSummary].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .fetchedAt()
         * .isOwnAccount()
         * .tweetCount()
         * .xUsername()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): StyleProfileSummary =
            StyleProfileSummary(
                checkRequired("fetchedAt", fetchedAt),
                checkRequired("isOwnAccount", isOwnAccount),
                checkRequired("tweetCount", tweetCount),
                checkRequired("xUsername", xUsername),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): StyleProfileSummary = apply {
        if (validated) {
            return@apply
        }

        fetchedAt()
        isOwnAccount()
        tweetCount()
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
        (if (fetchedAt.asKnown().isPresent) 1 else 0) +
            (if (isOwnAccount.asKnown().isPresent) 1 else 0) +
            (if (tweetCount.asKnown().isPresent) 1 else 0) +
            (if (xUsername.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StyleProfileSummary &&
            fetchedAt == other.fetchedAt &&
            isOwnAccount == other.isOwnAccount &&
            tweetCount == other.tweetCount &&
            xUsername == other.xUsername &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(fetchedAt, isOwnAccount, tweetCount, xUsername, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "StyleProfileSummary{fetchedAt=$fetchedAt, isOwnAccount=$isOwnAccount, tweetCount=$tweetCount, xUsername=$xUsername, additionalProperties=$additionalProperties}"
}
